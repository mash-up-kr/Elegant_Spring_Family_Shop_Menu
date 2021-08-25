package com.mashup.shopmenu.service

import com.mashup.shopmenu.common.exception.NotExistShopException
import com.mashup.shopmenu.domain.Shop
import com.mashup.shopmenu.domain.repository.ShopRepository
import com.mashup.shopmenu.dto.request.CreateShopRequestDTO
import com.mashup.shopmenu.dto.request.UpdateShopRequestDTO
import com.mashup.shopmenu.dto.response.CreateShopResponseDTO
import com.mashup.shopmenu.dto.response.ShopResponseDTO
import com.mashup.shopmenu.dto.response.UpdateShopResponseDTO
import com.mashup.shopmenu.event.ModifyEventPublisher
import org.modelmapper.ModelMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class ShopService(
    private val shopRepository: ShopRepository,
    private val modelMapper: ModelMapper,
    private val modifyEventPublisher: ModifyEventPublisher
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    @Transactional
    fun createShop(createShopRequestDTO: CreateShopRequestDTO): CreateShopResponseDTO {
        val result = shopRepository.save(modelMapper.map(createShopRequestDTO, Shop::class.java))
        modifyEventPublisher.publish(result)
        return modelMapper.map(result, CreateShopResponseDTO::class.java)
    }

    fun findByCategory(category: String): List<ShopResponseDTO> {
        return shopRepository.findAllByCategory(category).map { modelMapper.map(it, ShopResponseDTO::class.java) }
    }

    @Transactional
    fun updateShop(updateShopRequestDTO: UpdateShopRequestDTO): UpdateShopResponseDTO {
        // find
        val findShop = shopRepository.findById(updateShopRequestDTO.shopID)
            .orElseThrow { throw NotExistShopException() }
        // 넘어온 값으로 수정하고
        findShop.update(updateShopRequestDTO)
        // 끝
        modifyEventPublisher.publish(findShop)
        return modelMapper.map(findShop, UpdateShopResponseDTO::class.java)
    }

    fun findByShopID(shopID: Long): ShopResponseDTO {
        val findShop = shopRepository.findById(shopID)
                        .orElseThrow { throw NotExistShopException() }
        findShop.update(findShop)
        return modelMapper.map(findShop, ShopResponseDTO::class.java)
    }

    fun deleteShop(shopID: Long): Any {
        shopRepository.deleteById(shopID)
        return "Done!!!"
    }

}