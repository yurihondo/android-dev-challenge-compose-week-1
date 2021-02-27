package com.example.androiddevchallenge.data

class PuppySource {
    companion object {
        fun getPuppies(): List<Dog> {
            return listOf(
                Dog(
                    name = "Ace",
                    breed = "Pug",
                    imageUrl = "https://images.pexels.com/photos/1851164/pexels-photo-1851164.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                ),
                Dog(
                    name = "Elvis",
                    breed = "Akita",
                    imageUrl = "https://images.pexels.com/photos/5749135/pexels-photo-5749135.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                ),
                Dog(
                    name = "Otis",
                    breed = "Siberian Husky",
                    imageUrl = "https://images.pexels.com/photos/3726314/pexels-photo-3726314.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                ),
                Dog(
                    name = "Peanut",
                    breed = "Dachshund",
                    imageUrl = "https://images.pexels.com/photos/4490129/pexels-photo-4490129.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                ),
                Dog(
                    name = "Finn",
                    breed = "Border Collie",
                    imageUrl = "https://images.pexels.com/photos/3888471/pexels-photo-3888471.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                ),
                Dog(
                    name = "Apollo",
                    breed = "Yorkshire Terrier",
                    imageUrl = "https://images.pexels.com/photos/1420405/pexels-photo-1420405.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                ),
            )
        }
    }
}