package com.jaysdevapp.mycomposepractice.features.ui

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.jaysdevapp.mycomposepractice.features.viewmodel.NameViewmodel
import com.jaysdevapp.mycomposepractice.navigation.Screen


@Composable
fun InputName(navController: NavHostController,
              nameViewmodel: NameViewmodel = viewModel()) {

    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
//    val nameList = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = if (name.isEmpty()) "input your name." else "Hello $name!",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.padding(20.dp))

        TextField(
            value = name,
            onValueChange = { newText ->
                name = newText
            },
            label = { Text("name") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        Button(
            onClick = {
                if (name.isNotEmpty()) {
                    nameViewmodel.addNameList(name)
                    name = "";
                } else {
                    Toast.makeText(context, "이름을 입력해 주세요.", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text("Confirm")
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            // items Or itemsIndexed
            itemsIndexed(nameViewmodel.nameList) { index, item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp)
                        .clickable {
//                            navController.navigate("detail/${item}")
                            navController.navigate(Screen.Detail.createRoute(item))

                        },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth().padding(1.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = item,
                            modifier = Modifier.padding(16.dp).weight(1f)
                        )

                        IconButton(onClick = {
                           nameViewmodel.removeName(index)
                        }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "delete",
                                tint = Color.Gray
                            )
                        }
                    }
                }

            }

        }

    }
}