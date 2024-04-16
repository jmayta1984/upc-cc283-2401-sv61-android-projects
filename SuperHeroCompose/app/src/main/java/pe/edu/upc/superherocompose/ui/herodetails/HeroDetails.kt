package pe.edu.upc.superherocompose.ui.herodetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.superherocompose.model.data.Biography
import pe.edu.upc.superherocompose.model.data.Hero
import pe.edu.upc.superherocompose.model.data.PowerStats
import pe.edu.upc.superherocompose.repositories.HeroRepository
import pe.edu.upc.superherocompose.ui.heroessearch.HeroImage
import pe.edu.upc.superherocompose.ui.theme.SuperHeroComposeTheme

@Composable
fun HeroDetails(id: String) {

    val hero = remember {
        mutableStateOf<Hero?>(null)
    }

    HeroRepository().getHeroById(id) {
        hero.value = it
    }

    hero.value?.let {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeroImage(url = it.image.url, 256.dp)
                HeroHeader(it.name)
                HeroBiography(it.biography)
                HeroPowerStats(it.powerStats)
            }
        }
    }
}

@Composable
fun HeroPowerStats(powerStats: PowerStats) {
    Card(modifier = Modifier.padding(4.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                "Power Stats",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            HeroStat("Intelligence", powerStats.intelligence)
            HeroStat("Strength", powerStats.strength)
            HeroStat("Speed", powerStats.speed)
            HeroStat("Durability", powerStats.durability)
            HeroStat("Power", powerStats.power)
            HeroStat("Combat", powerStats.combat)


        }
    }
}

@Composable
fun HeroStat(stat: String, powerStat: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = stat, modifier = Modifier.weight(1f))

        powerStat.toFloatOrNull()?.let {
            Slider(
                modifier = Modifier.weight(3f),
                value = it, onValueChange = {}, valueRange = 0f..100f
            )

        }
    }
}

@Composable
fun HeroBiography(biography: Biography) {
    Card(modifier = Modifier.padding(4.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                "Biography",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Text("Full name: ${biography.fullName}")
            Text("Place of birth: ${biography.placeOfBirth}")
            Text("Publisher: ${biography.publisher}")


        }
    }

}


@Composable
fun HeroHeader(name: String) {
    Text(text = name, style = MaterialTheme.typography.headlineLarge)
}

