package pe.edu.upc.superherocompose.ui.heroessearch

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import pe.edu.upc.superherocompose.model.data.Hero
import pe.edu.upc.superherocompose.repositories.HeroRepository

@Composable
fun HeroesSearch(selectHero: (String) -> Unit) {

    val heroes = remember {
        mutableStateOf(emptyList<Hero>())
    }
    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            HeroSearch(heroes)
            HeroList(heroes, selectHero)
        }
    }
}

@Composable
fun HeroList(heroes: MutableState<List<Hero>>, selectHero: (String) -> Unit) {

    LazyColumn {
        items(heroes.value) { hero ->
            HeroItem(hero, selectHero)
        }
    }

}

@Composable
fun HeroItem(hero: Hero, selectHero: (String) -> Unit) {

    val isFavorite = remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), onClick = {
                selectHero(hero.id)
        }
    ) {
        Row {
            HeroImage(hero.image.url, 92.dp)
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(4f)
            ) {
                Text(text = hero.name)
                Text(text = hero.biography.fullName)
            }
            IconButton(onClick = {
                isFavorite.value = !isFavorite.value
            }, modifier = Modifier.weight(1f)) {
                Icon(
                    Icons.Filled.Favorite,
                    "Favorite",
                    tint = if (isFavorite.value) MaterialTheme.colorScheme.primary else Color.Gray
                )
            }
        }
    }
}

@Composable
fun HeroImage(url: String, size: Dp) {
    GlideImage(imageModel = { url }, modifier = Modifier.size(size),)
}

@Composable
fun HeroSearch(heroes: MutableState<List<Hero>>) {

    val search = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = search.value,
        onValueChange = {
            search.value = it
        },
        placeholder = {
            Text(text = "Search hero")
        },
        leadingIcon = {
            Icon(Icons.Filled.Search, "Search")
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(onSearch = {
            HeroRepository().getHeroes(search.value) {
                heroes.value = it
            }
        }),
        modifier = Modifier.fillMaxWidth()
    )
}
