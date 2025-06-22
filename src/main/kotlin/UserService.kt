package com.example

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

@kotlinx.serialization.Serializable
data class KeyboardDTO(
    val id: Int,
    val name: String,
    val image: String,
    val descriptions: String,
    val switchType: String,
    val keycapsType: String,
    val layoutType: Int,
    val price: Float
)

class UserService {
    companion object {
        suspend fun getAllKeyboards(): List<KeyboardDTO> = newSuspendedTransaction {
            (KeyBoardCard innerJoin SwitchType innerJoin KeycapsType innerJoin LayoutType)
                .selectAll()
                .map(::mapRowToDTO)
        }

        private fun mapRowToDTO(row: ResultRow): KeyboardDTO = KeyboardDTO(
            id = row[KeyBoardCard.id],
            name = row[KeyBoardCard.name],
            image = row[KeyBoardCard.image],
            descriptions = row[KeyBoardCard.descriptions],
            switchType = row[SwitchType.name],
            keycapsType = row[KeycapsType.name],
            layoutType = row[LayoutType.name],
            price = row[KeyBoardCard.price]
        )
    }

}

