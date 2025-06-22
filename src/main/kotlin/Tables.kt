package com.example

import org.jetbrains.exposed.sql.Table


object SwitchName : Table("switch_name") {
    val id   = integer("id").autoIncrement()
    val name = varchar("name", length = 100)
    override val primaryKey = PrimaryKey(id)
}
object SwitchType : Table("switch_type") {
    val id   = integer("id").autoIncrement()
    val type = varchar("type", length = 100)
    override val primaryKey = PrimaryKey(id)
}



object KeycapType : Table("keycap_type") {
    val id   = integer("id").autoIncrement()
    val type = varchar("type", length = 100)
    override val primaryKey = PrimaryKey(id)
}


object KeycapMaterial : Table("keycap_material") {
    val id   = integer("id").autoIncrement()
    val material = varchar("material", length = 100)
    override val primaryKey = PrimaryKey(id)
}

object LayoutTypes : Table("layout_types") {
    val id   = integer("id").autoIncrement()
    val scale = varchar("scale", length = 100)
    override val primaryKey = PrimaryKey(id)
}


object Keyboards : Table("keyboards") {
    val id            = integer("id").autoIncrement()
    val name          = varchar("name",   length = 200)
    val imageUrl      = varchar("image_url", length = 500) // URL или путь
    val description   = text("description")
    val switchTypeIdName  = integer("switch_type_id_name").references(SwitchName.id)
    val switchTypeIdType  = integer("switch_type_id_type").references(SwitchType.id)
    val keycapTypeIdType  = integer("keycap_type_id_type").references(KeycapType.id)
    val keycapTypeIdMaterial  = integer("keycap_type_id_material").references(KeycapMaterial.id)
    val layoutTypeId  = integer("layout_type_id").references(LayoutTypes.id)
    val price         = decimal("price", precision = 10, scale = 2)
    val stockQuantity = integer("stock_quantity").default(0)
    override val primaryKey = PrimaryKey(id)
}

object Switches : Table("switches") {
    val id            = integer("id").autoIncrement()
    val name          = varchar("name", length = 200)
    val imageUrl      = varchar("image_url", length = 500)
    val description   = text("description")
    val switchTypeIdName  = integer("switch_type_id_name").references(SwitchName.id)
    val switchTypeIdType  = integer("switch_type_id_type").references(SwitchType.id)
    val price         = decimal("price", precision = 10, scale = 2)
    val stockQuantity = integer("stock_quantity").default(0)
    override val primaryKey = PrimaryKey(id)
}

object Keycaps : Table("keycaps") {
    val id            = integer("id").autoIncrement()
    val name          = varchar("name", length = 200)
    val imageUrl      = varchar("image_url", length = 500)
    val description   = text("description")
    val keycapTypeIdType  = integer("keycap_type_id_type").references(KeycapType.id)
    val keycapTypeIdMaterial  = integer("keycap_type_id_material").references(KeycapMaterial.id)
    val price         = decimal("price", precision = 10, scale = 2)
    val stockQuantity = integer("stock_quantity").default(0)
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


