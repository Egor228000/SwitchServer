package com.example

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import java.math.BigDecimal

@kotlinx.serialization.Serializable
data class KeyboardDTO(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val description: String,
    val switchType: String,
    val keycapType: String,
    val layoutType: String,
    val price: Float,
    val stockQuantity: Int
)

class UserService {
    companion object {
        suspend fun getAllKeyboards(): List<KeyboardDTO> = newSuspendedTransaction {
            // innerJoin справочников по новым объектам Table
            (Keyboards
                    innerJoin SwitchType
                    innerJoin KeycapType
                    innerJoin LayoutTypes)
                .selectAll()
                .map(::mapRowToDTO)
        }

        private fun mapRowToDTO(row: ResultRow): KeyboardDTO = KeyboardDTO(
            id            = row[Keyboards.id],
            name          = row[Keyboards.name],
            imageUrl      = row[Keyboards.imageUrl],
            description   = row[Keyboards.description],
            switchType    = row[SwitchType.type],
            keycapType    = row[KeycapType.type],
            layoutType    = row[LayoutTypes.scale],
            price         = row[Keyboards.price],
            stockQuantity = row[Keyboards.stockQuantity]
        )
    }
}