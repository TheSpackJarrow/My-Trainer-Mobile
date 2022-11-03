package com.example.mytrainermobile.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.mytrainermobile.components.DefaultButton
import com.example.mytrainermobile.components.DefaultTextField
import com.example.mytrainermobile.R
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme

@Preview(showBackground = true)
@Composable
fun ShowSignupScreen() {
    MyTrainerMobileTheme() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DefaultBackground)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(state = ScrollState(initial = 0))
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
//                ShowImage()
                    SignupText()
                }
                ShowSignUpForm()
            }
        }
    }
}

@Composable
fun ShowImage() {
    Image(
        painter = painterResource(id = R.drawable.arms),
        contentDescription = ""/*TODO*/,
        modifier = Modifier.size(width = 30.dp, height = 40.dp)
    )
}

@Composable
fun SignupText() {
    Text(
        text = stringResource(id = R.string.signUpText),
        style = Typography().h3.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(vertical = 30.dp),
        color = Color.White
    )
}

@Composable
fun ShowSignUpForm() {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var email2 by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var password2 by remember { mutableStateOf("") }

    DefaultTextField(
        value = name,
        callback = { name = it },
        placeholder = stringResource(id = R.string.signup_insert_name)
    )
    DefaultTextField(
        value = surname,
        callback = { surname = it },
        placeholder = stringResource(id = R.string.signup_insert_surname)
    )
    DefaultTextField(
        value = email,
        callback = { email = it },
        placeholder = stringResource(id = R.string.signup_insert_email)
    )
    DefaultTextField(
        value = email2,
        callback = { email2 = it },
        placeholder = stringResource(id = R.string.signup_reinsert_email)
    )
    DefaultTextField(
        value = password,
        callback = { password = it },
        placeholder = stringResource(id = R.string.signup_insert_password)
    )
    DefaultTextField(
        value = password2,
        callback = { password2 = it },
        placeholder = stringResource(id = R.string.signup_reinsert_password)
    )

    DefaultButton(text = stringResource(id = R.string.signUpText), onClick = {SignUp()})
    DefaultButton(text = stringResource(id = R.string.signup_goto_signin), onClick = { GoToSignIn()})
    //aca iria el datepicker


}

fun SignUp() {/*TODO*/}

fun GoToSignIn() {}