/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

class PuppySource {
    companion object {
        fun getPuppies(): List<Puppy> {
            return listOf(
                Puppy(
                    name = "Ace",
                    breed = "Pug",
                    imageUrl = "https://images.pexels.com/photos/1851164/pexels-photo-1851164.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam faucibus, sem in vulputate sollicitudin, turpis diam fringilla elit, nec feugiat nunc nibh quis justo. Ut dapibus nisi at neque vestibulum consequat. Pellentesque pretium leo et leo malesuada, vel tincidunt urna accumsan. Sed efficitur tempus ex viverra iaculis. Fusce semper dignissim porta. Pellentesque bibendum elit feugiat orci pellentesque, sed vulputate tortor pulvinar. Donec lacus sapien, congue id tristique ac, auctor et turpis. Mauris venenatis ligula velit, non molestie sapien consectetur sit amet. Suspendisse non facilisis magna. Etiam efficitur id massa vel fermentum. Quisque at suscipit odio."
                ),
                Puppy(
                    name = "Elvis",
                    breed = "Akita",
                    imageUrl = "https://images.pexels.com/photos/5749135/pexels-photo-5749135.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    description = "Nullam dignissim, lacus eget cursus ullamcorper, lectus sapien tincidunt neque, vel commodo risus nunc vitae ante. In vel purus at justo aliquet mollis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Donec condimentum nunc sodales metus elementum, at lobortis urna laoreet. Ut sit amet ipsum in sem dictum semper. Sed et pellentesque turpis. Fusce placerat orci quam. Ut accumsan, sem quis viverra pharetra, dui nisi feugiat nisl, ac laoreet mauris quam at est. Donec consectetur nulla a dictum imperdiet. Donec porttitor magna neque. Nunc vel metus quis sem faucibus egestas eu id ipsum. Sed mollis turpis lacinia turpis efficitur accumsan."
                ),
                Puppy(
                    name = "Otis",
                    breed = "Siberian Husky",
                    imageUrl = "https://images.pexels.com/photos/3726314/pexels-photo-3726314.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam faucibus, sem in vulputate sollicitudin, turpis diam fringilla elit, nec feugiat nunc nibh quis justo. Ut dapibus nisi at neque vestibulum consequat. Pellentesque pretium leo et leo malesuada, vel tincidunt urna accumsan. Sed efficitur tempus ex viverra iaculis. Fusce semper dignissim porta. Pellentesque bibendum elit feugiat orci pellentesque, sed vulputate tortor pulvinar. Donec lacus sapien, congue id tristique ac, auctor et turpis. Mauris venenatis ligula velit, non molestie sapien consectetur sit amet. Suspendisse non facilisis magna. Etiam efficitur id massa vel fermentum. Quisque at suscipit odio."
                ),
                Puppy(
                    name = "Peanut",
                    breed = "Dachshund",
                    imageUrl = "https://images.pexels.com/photos/4490129/pexels-photo-4490129.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    description = "Nullam dignissim, lacus eget cursus ullamcorper, lectus sapien tincidunt neque, vel commodo risus nunc vitae ante. In vel purus at justo aliquet mollis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Donec condimentum nunc sodales metus elementum, at lobortis urna laoreet. Ut sit amet ipsum in sem dictum semper. Sed et pellentesque turpis. Fusce placerat orci quam. Ut accumsan, sem quis viverra pharetra, dui nisi feugiat nisl, ac laoreet mauris quam at est. Donec consectetur nulla a dictum imperdiet. Donec porttitor magna neque. Nunc vel metus quis sem faucibus egestas eu id ipsum. Sed mollis turpis lacinia turpis efficitur accumsan."
                ),
                Puppy(
                    name = "Finn",
                    breed = "Border Collie",
                    imageUrl = "https://images.pexels.com/photos/3888471/pexels-photo-3888471.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam faucibus, sem in vulputate sollicitudin, turpis diam fringilla elit, nec feugiat nunc nibh quis justo. Ut dapibus nisi at neque vestibulum consequat. Pellentesque pretium leo et leo malesuada, vel tincidunt urna accumsan. Sed efficitur tempus ex viverra iaculis. Fusce semper dignissim porta. Pellentesque bibendum elit feugiat orci pellentesque, sed vulputate tortor pulvinar. Donec lacus sapien, congue id tristique ac, auctor et turpis. Mauris venenatis ligula velit, non molestie sapien consectetur sit amet. Suspendisse non facilisis magna. Etiam efficitur id massa vel fermentum. Quisque at suscipit odio."
                ),
                Puppy(
                    name = "Apollo",
                    breed = "Yorkshire Terrier",
                    imageUrl = "https://images.pexels.com/photos/1420405/pexels-photo-1420405.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    description = "Nullam dignissim, lacus eget cursus ullamcorper, lectus sapien tincidunt neque, vel commodo risus nunc vitae ante. In vel purus at justo aliquet mollis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Donec condimentum nunc sodales metus elementum, at lobortis urna laoreet. Ut sit amet ipsum in sem dictum semper. Sed et pellentesque turpis. Fusce placerat orci quam. Ut accumsan, sem quis viverra pharetra, dui nisi feugiat nisl, ac laoreet mauris quam at est. Donec consectetur nulla a dictum imperdiet. Donec porttitor magna neque. Nunc vel metus quis sem faucibus egestas eu id ipsum. Sed mollis turpis lacinia turpis efficitur accumsan."
                ),
                Puppy(
                    name = "Bailey",
                    breed = "American Eskimo Dog",
                    imageUrl = "https://images.pexels.com/photos/235805/pexels-photo-235805.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam faucibus, sem in vulputate sollicitudin, turpis diam fringilla elit, nec feugiat nunc nibh quis justo. Ut dapibus nisi at neque vestibulum consequat. Pellentesque pretium leo et leo malesuada, vel tincidunt urna accumsan. Sed efficitur tempus ex viverra iaculis. Fusce semper dignissim porta. Pellentesque bibendum elit feugiat orci pellentesque, sed vulputate tortor pulvinar. Donec lacus sapien, congue id tristique ac, auctor et turpis. Mauris venenatis ligula velit, non molestie sapien consectetur sit amet. Suspendisse non facilisis magna. Etiam efficitur id massa vel fermentum. Quisque at suscipit odio."
                ),
                Puppy(
                    name = "Frankie",
                    breed = "Chihuahua",
                    imageUrl = "https://images.pexels.com/photos/485294/pexels-photo-485294.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    description = "Nullam dignissim, lacus eget cursus ullamcorper, lectus sapien tincidunt neque, vel commodo risus nunc vitae ante. In vel purus at justo aliquet mollis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Donec condimentum nunc sodales metus elementum, at lobortis urna laoreet. Ut sit amet ipsum in sem dictum semper. Sed et pellentesque turpis. Fusce placerat orci quam. Ut accumsan, sem quis viverra pharetra, dui nisi feugiat nisl, ac laoreet mauris quam at est. Donec consectetur nulla a dictum imperdiet. Donec porttitor magna neque. Nunc vel metus quis sem faucibus egestas eu id ipsum. Sed mollis turpis lacinia turpis efficitur accumsan."
                ),
                Puppy(
                    name = "Prince",
                    breed = "Pembroke Welsh Corgi",
                    imageUrl = "https://images.pexels.com/photos/2664417/pexels-photo-2664417.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam faucibus, sem in vulputate sollicitudin, turpis diam fringilla elit, nec feugiat nunc nibh quis justo. Ut dapibus nisi at neque vestibulum consequat. Pellentesque pretium leo et leo malesuada, vel tincidunt urna accumsan. Sed efficitur tempus ex viverra iaculis. Fusce semper dignissim porta. Pellentesque bibendum elit feugiat orci pellentesque, sed vulputate tortor pulvinar. Donec lacus sapien, congue id tristique ac, auctor et turpis. Mauris venenatis ligula velit, non molestie sapien consectetur sit amet. Suspendisse non facilisis magna. Etiam efficitur id massa vel fermentum. Quisque at suscipit odio."
                ),
                Puppy(
                    name = "NIKU",
                    breed = "Bull Terrier",
                    imageUrl = "https://images.pexels.com/photos/1078089/pexels-photo-1078089.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    description = "The Meiryo-tei's Dog."
                ),
            )
        }
    }
}
