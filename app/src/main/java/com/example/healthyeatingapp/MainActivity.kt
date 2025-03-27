package com.example.healthyeatingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthyeatingapp.ui.theme.BackgroundColor
import com.example.healthyeatingapp.ui.theme.HealthyEatingAppTheme
import com.example.healthyeatingapp.ui.theme.Lato
import com.example.healthyeatingapp.ui.theme.Poppins
import com.example.healthyeatingapp.ui.theme.PrimaryColor
import com.example.healthyeatingapp.ui.theme.TertiaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthyEatingAppTheme {
                HealthyEatingApp()
            }
        }
    }
}

@Composable
fun HealthyEatingApp() {
    // Full list of 30 healthy tips for the 30 days
    val daySuggestions = List(size = 30) {
        when (it + 1) {
            1 -> DayTip("Day ${it + 1}: Drink more water and stay hydrated!", "Staying hydrated is crucial for your health. Water aids in digestion, helps regulate body temperature, and supports overall bodily functions. Try to drink at least 8 glasses of water daily to stay properly hydrated.")
            2 -> DayTip("Day ${it + 1}: Add more fruits and vegetables to your diet.", "Fruits and vegetables are packed with vitamins, minerals, and fiber that are essential for overall health. They also contain antioxidants that help fight inflammation and oxidative stress. Aim for a variety of colors on your plate!")
            3 -> DayTip("Day ${it + 1}: Include healthy fats in your meals, like avocado or nuts.", "Healthy fats, such as those found in avocados, nuts, and olive oil, support brain health, hormone production, and heart health. They also provide long-lasting energy and help your body absorb fat-soluble vitamins.")
            4 -> DayTip("Day ${it + 1}: Start your day with a healthy breakfast to fuel your body.", "A nutritious breakfast helps jump-start your metabolism, improves focus, and provides energy for your day. Include protein, fiber, and healthy fats in your morning meal to feel full and satisfied throughout the day.")
            5 -> DayTip("Day ${it + 1}: Choose whole grains instead of refined grains (e.g., brown rice).", "Whole grains retain more nutrients and fiber than refined grains, making them a better option for digestion and keeping you full longer. Swap white rice for brown rice, quinoa, or oats for a nutritious boost.")
            6 -> DayTip("Day ${it + 1}: Limit sugary drinks like sodas and fruit juices.", "Sugary drinks are a major contributor to weight gain, type 2 diabetes, and heart disease. Choose water, unsweetened herbal tea, or infused water for a healthier alternative that won't spike your blood sugar levels.")
            7 -> DayTip("Day ${it + 1}: Incorporate plant-based protein sources like beans and lentils.", "Plant-based proteins such as beans, lentils, and tofu are rich in fiber and nutrients that support digestion, heart health, and muscle growth. These plant proteins are also lower in saturated fat than animal-based options.")
            8 -> DayTip("Day ${it + 1}: Control portion sizes to avoid overeating.", "Portion control is key to maintaining a healthy weight. Use smaller plates and be mindful of how much food you're consuming, especially with high-calorie foods. This will help you maintain balance in your diet without overeating.")
            9 -> DayTip("Day ${it + 1}: Try to eat slowly and mindfully to improve digestion.", "Eating slowly allows your brain to register fullness, preventing overeating. Mindful eating helps you savor your food and improves digestion by stimulating the release of digestive enzymes.")
            10 -> DayTip("Day ${it + 1}: Include more fiber in your diet with whole fruits and vegetables.", "Fiber supports digestion, helps maintain blood sugar levels, and keeps you full longer. Whole fruits and vegetables are some of the best sources of fiber, so aim to fill half your plate with them at each meal.")
            11 -> DayTip("Day ${it + 1}: Reduce your intake of processed foods.", "Processed foods are often high in sodium, unhealthy fats, and sugar, contributing to chronic diseases like hypertension and heart disease. Focus on whole, natural foods like fruits, vegetables, lean proteins, and whole grains.")
            12 -> DayTip("Day ${it + 1}: Eat a variety of colorful fruits and vegetables for balanced nutrition.", "Colorful fruits and vegetables provide a range of nutrients, including vitamins, minerals, and antioxidants. Try to eat a variety of colors daily to get a broad spectrum of nutrients that support your immune system and overall health.")
            13 -> DayTip("Day ${it + 1}: Swap out unhealthy snacks for nuts, seeds, or yogurt.", "Swapping out sugary or salty snacks for healthy options like nuts, seeds, or yogurt can help curb cravings while providing essential nutrients and healthy fats. They're great for a mid-day energy boost!")
            14 -> DayTip("Day ${it + 1}: Choose healthy cooking methods like baking, grilling, or steaming.", "Opt for cooking methods that preserve the nutrients in your food and reduce added fats. Baking, grilling, and steaming are healthier alternatives to frying, which can add unnecessary calories and unhealthy fats.")
            15 -> DayTip("Day ${it + 1}: Limit your consumption of red meat, and opt for lean protein.", "Red meat is high in saturated fat, which can contribute to heart disease. Choose lean proteins like chicken, turkey, fish, or plant-based sources like beans and tofu for a heart-healthy diet.")
            16 -> DayTip("Day ${it + 1}: Don't skip meals; aim for 3 balanced meals a day.", "Skipping meals can lead to overeating later in the day. Eating regular, balanced meals helps stabilize blood sugar and keeps your energy levels consistent throughout the day.")
            17 -> DayTip("Day ${it + 1}: Make sure to get enough calcium for strong bones (e.g., leafy greens or dairy).", "Calcium is essential for maintaining strong bones and teeth. Include calcium-rich foods like leafy greens, dairy products, fortified plant milks, or tofu in your diet for bone health.")
            18 -> DayTip("Day ${it + 1}: Stay active by including exercise in your daily routine.", "Physical activity supports heart health, muscle strength, and mental well-being. Aim for at least 30 minutes of moderate exercise most days of the week, whether it's walking, cycling, or yoga.")
            19 -> DayTip("Day ${it + 1}: Try a new healthy recipe and experiment with fresh ingredients.", "Exploring new healthy recipes and cooking with fresh ingredients can keep your meals exciting and packed with nutrients. Challenge yourself to try a new recipe each week!")
            20 -> DayTip("Day ${it + 1}: Drink green tea or herbal teas instead of sugary beverages.", "Green tea is rich in antioxidants that can support metabolism and overall health. Herbal teas like chamomile or peppermint are great for relaxation. Replace sugary drinks with these to reduce calorie intake.")
            21 -> DayTip("Day ${it + 1}: Focus on reducing your sodium intake by avoiding excessive salt.", "Excessive sodium intake can lead to high blood pressure and increase the risk of heart disease. Use herbs and spices to flavor your food instead of salt, and check food labels for hidden sodium content.")
            22 -> DayTip("Day ${it + 1}: Choose healthy snacks like fruit, vegetables, or hummus.", "Healthy snacks like fresh fruits, vegetables, or hummus are rich in vitamins and fiber. They provide a satisfying and nutritious way to curb hunger between meals.")
            23 -> DayTip("Day ${it + 1}: Practice mindful eating by focusing on the flavors and textures of your food.", "Mindful eating involves paying attention to the experience of eating—how food looks, tastes, and feels. This can help you enjoy your meals more and prevent overeating by slowing down your eating habits.")
            24 -> DayTip("Day ${it + 1}: Try intermittent fasting or smaller meals throughout the day.", "Intermittent fasting involves cycling between periods of eating and fasting. It can help with weight management and improve metabolic health. Alternatively, eating smaller, balanced meals throughout the day keeps energy levels stable.")
            25 -> DayTip("Day ${it + 1}: Keep track of your food intake to understand your eating habits.", "Tracking your food intake can help you understand your eating patterns and make more mindful decisions. Use a food diary or an app to log your meals and snacks.")
            26 -> DayTip("Day ${it + 1}: Add fermented foods (yogurt, kimchi, etc.) for gut health.", "Fermented foods like yogurt, kimchi, and sauerkraut are rich in probiotics, which support gut health and digestion. Including them in your diet can promote a healthy balance of bacteria in your digestive system.")
            27 -> DayTip("Day ${it + 1}: Limit alcohol consumption, as it can be high in empty calories.", "Alcoholic drinks are often high in empty calories that provide little nutritional value. Limiting alcohol consumption can help with weight management and improve overall health.")
            28 -> DayTip("Day ${it + 1}: Include antioxidants in your diet (e.g., berries, dark chocolate).", "Antioxidants help fight free radicals that cause oxidative stress and contribute to aging and disease. Include antioxidant-rich foods like berries, dark chocolate, and green tea in your diet.")
            29 -> DayTip("Day ${it + 1}: Focus on whole foods and minimize processed ingredients.", "Whole foods like fruits, vegetables, and whole grains are minimally processed and provide essential nutrients. Avoid foods that are heavily processed and high in added sugars, preservatives, and unhealthy fats.")
            30 -> DayTip("Day ${it + 1}: Celebrate your healthy eating journey and continue making small improvements!", "Congratulations on completing the 30 days of healthy eating! Continue making small changes in your diet, and celebrate your progress. Keep nourishing your body and mind with wholesome foods.")
            else -> DayTip("Day ${it + 1}: Healthy Eating Tip", "This is a placeholder description.")
        }
    }

    val imageResources = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10,
        R.drawable.image11,
        R.drawable.image12,
        R.drawable.image13,
        R.drawable.image14,
        R.drawable.image15,
        R.drawable.image16,
        R.drawable.image17,
        R.drawable.image18,
        R.drawable.image19,
        R.drawable.image20,
        R.drawable.image21,
        R.drawable.image22,
        R.drawable.image23,
        R.drawable.image24,
        R.drawable.image25,
        R.drawable.image26,
        R.drawable.image27,
        R.drawable.image28,
        R.drawable.image29,
        R.drawable.image30,
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "30 Days of Healthy Eating",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = BackgroundColor
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(PrimaryColor)
                .padding(top = 40.dp, start = 16.dp, end = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display the list of suggestions in a LazyColumn
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(daySuggestions) { index, dayTip ->
                DayCard(
                    day = dayTip.day,
                    imageRes = imageResources.getOrElse(index) { R.drawable.image1 },
                    expandedText = dayTip.expandedText
                )
            }
        }
    }
}

data class DayTip(val day: String, val expandedText: String)

@Composable
fun DayCard(day: String, imageRes: Int, expandedText: String) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { isExpanded = !isExpanded },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = TertiaryColor)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = day.substringBefore(":"),
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = PrimaryColor
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = day.substringAfter(":").trim(),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = Lato,
                    fontWeight = FontWeight.Normal,
                    fontSize = 19.sp,
                    color = Color.Black
                ),
                modifier = Modifier.padding(bottom = 4.dp)
            )

            // Example Image for each day
            Image(
                painter = painterResource(id = imageRes ),
                contentDescription = "Healthy Tip Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .padding(bottom = 1.dp)
            )

            // Additional Information (example text)
            if (isExpanded) {
                Text(
                    text = expandedText,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontFamily = Lato,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(top = 8.dp),
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HealthyEatingAppTheme {
        HealthyEatingApp()
    }
}