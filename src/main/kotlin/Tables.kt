package com.example

import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction


object KeyBoardCard : Table("KeyboardCard") {
    val id = integer("id").autoIncrement()
    val name = text("name")
    val image = text("image")
    val descriptions = text("descriptions")
    val switchTypeId = integer("switch_type_id").references(SwitchType.id)
    val keycapsTypeId = integer("keycaps_type_id").references(KeycapsType.id)
    val layoutTypeId = integer("layout_type_id").references(LayoutType.id)
    val price = float("price")
    override val primaryKey = PrimaryKey(id)
}

object SwitchType : IdTable<Int>("SwitchType") {
    override val id = integer("id").autoIncrement().entityId()
    val name = text("name")
    val descriptions = text("descriptions")
    val type = text("type") // внешний ключ
    val manufacturer = text("manufacturer") // внешний ключ
    override val primaryKey = PrimaryKey(id)
}

object KeycapsType : IdTable<Int>("KeycapsType") {
    override val id = integer("id").autoIncrement().entityId()
    val name = text("name")
    val descriptions = text("descriptions")
    val type = text("type") // внешний ключ
    val manufacturer = text("manufacturer") // внешний ключ
    override val primaryKey = PrimaryKey(id)
}

object LayoutType : IdTable<Int>("LayoutType") {
    override val id = integer("id").autoIncrement().entityId()
    val name = integer("name")
    override val primaryKey = PrimaryKey(id)
}






object KeycapsCard : Table("KeycapsCard") {
    val id = integer("id").autoIncrement()
    val name = text("name")
    val image = text("image")
    val descriptions = text("descriptions")
    val keycapsTypeId = integer("keycaps_type_id").references(KeycapsType.id)
    val count = integer("count")
    val price = float("price")
    override val primaryKey = PrimaryKey(id)
}

object SwitchCard : Table("SwitchCard") {
    val id = integer("id").autoIncrement()
    val name = text("name")
    val image = text("image")
    val descriptions = text("descriptions")
    val keycapsTypeId = integer("switch_type_id").references(SwitchType.id)
    val count = integer("count")
    val price = float("price")
    override val primaryKey = PrimaryKey(id)
}

object UserProfile : Table(name = "UserProfile") {
    val id = integer("id").autoIncrement()
    val name = text("name")
    val password = text("password")
    override val primaryKey = PrimaryKey(id)


}

object Repair : Table("Repair") {
    val id = integer("id").autoIncrement()
    val nameUser = text("nameUser")
    val photo = text("photo")
    val title = text("title")
    val description = text("description")
    override val primaryKey = PrimaryKey(id)


}


