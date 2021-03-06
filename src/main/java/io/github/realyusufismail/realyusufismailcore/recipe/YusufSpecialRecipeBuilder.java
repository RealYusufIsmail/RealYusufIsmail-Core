/*
 * BSD 3-Clause License
 *
 * Copyright (c) 2021, Yusuf Ismail
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions
 * and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other materials provided with
 * the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written permission.
 *
 *
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package io.github.realyusufismail.realyusufismailcore.recipe;

import com.google.gson.JsonObject;
import io.github.realyusufismail.realyusufismailcore.MinecraftClass;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Consumer;

@MinecraftClass
public class YusufSpecialRecipeBuilder {
    final SimpleRecipeSerializer<?> serializer;

    public YusufSpecialRecipeBuilder(SimpleRecipeSerializer<?> simpleRecipeSerializer) {
        this.serializer = simpleRecipeSerializer;
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull YusufSpecialRecipeBuilder special(
            SimpleRecipeSerializer<?> simpleRecipeSerializer) {
        return new YusufSpecialRecipeBuilder(simpleRecipeSerializer);
    }

    public void save(@NotNull Consumer<FinishedRecipe> finishedRecipeConsumer,
            final String resourceLocation) {
        finishedRecipeConsumer.accept(new FinishedRecipe() {
            public void serializeRecipeData(@NotNull JsonObject jsonObject) {
                // TODO document why this method is empty
            }

            public @NotNull RecipeSerializer<?> getType() {
                return YusufSpecialRecipeBuilder.this.serializer;
            }

            public @NotNull ResourceLocation getId() {
                return new ResourceLocation(resourceLocation);
            }

            @Nullable
            public JsonObject serializeAdvancement() {
                return null;
            }

            public ResourceLocation getAdvancementId() {
                return new ResourceLocation("");
            }
        });
    }
}
