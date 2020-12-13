package com.example.myapplication

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

/*Описати FamilyTree у форматі JSON.
Повинен бути JSON файл у якому описана структура з такими властивостями, як ім’я, вік, повнолітність (чи повнолітня) ця людина, кількість родичів та тато і мама, які в свою чергу теж JSON об’єкти.
Створити відповідні їм data класи.
Серіалізувати та десеріалізувати їх за допомогою GSON.*/

data class Mother(
    val name : String,
    val age : Int,
    val majority : Boolean,
    val numberOfRelatives : Int
)

data class Futher(
    val name : String,
    val age : Int,
    val majority : Boolean,
    val numberOfRelatives : Int
)

data class Me constructor (
    @SerializedName ("MY_NAME_IS")
    val name : String,
    val age : Int,
    val majority : Boolean,
    val numberOfRelatives : Int,
    val mother : String,
    val futher : String,
)


fun main() {
    val gson=Gson()

    val motherMe = Mother("Inga", 53, true,6)
    println("val motherMe = $motherMe")
    val motherMeJOSON = gson.toJson(motherMe)
    println("val motherMeJOSON = $motherMeJOSON")
    val futherMe = Futher("Anatoly",53, true, 6)
    println("val futherMe = $futherMe")
    val futherMeJOSON = gson.toJson(futherMe)
    println("val futherMeJOSON = $futherMeJOSON")
    val me = Me("Gleb", 29, true,6, motherMeJOSON, futherMeJOSON)
    println("val me = $me")
    val meJSON = gson.toJson(me)
    println("val meJSON = $meJSON")

    val meFromJson = gson.fromJson(meJSON, Me::class.java)
    println("val meFromJson = $meFromJson")
    val motherFromJSON = gson.fromJson(meFromJson.mother, Mother::class.java)
    println("val motherFromJson =$motherFromJSON")
    val futherFromJSON = gson.fromJson(meFromJson.futher, Futher::class.java)
    println("val futherFromJSON =$futherFromJSON")
}
