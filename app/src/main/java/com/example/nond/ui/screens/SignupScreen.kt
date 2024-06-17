package com.example.nond.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nond.R
import com.example.nond.ui.components.AlreadyHave
import com.example.nond.ui.components.CButton
import com.example.nond.ui.components.CTextField
import com.example.nond.ui.theme.AlegreyaFontFamily


@Composable
fun SignUpScreen(
    navController: NavHostController
) {
    val (username,setUsername) = rememberSaveable {
        mutableStateOf("")
    }
    val (password,setPassword) = rememberSaveable {
        mutableStateOf("")
    }
    val (email,setEmail) = rememberSaveable {
        mutableStateOf("")
    }

    Surface(
        color = Color(48, 48, 48),
        modifier = Modifier.fillMaxSize()
    ) {


        Box(modifier =  Modifier.fillMaxSize()){
            /// Background Image
            Image(painter = painterResource(id = R.drawable.bg1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .align(Alignment.BottomCenter)
            )

            /// Content

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 28.dp)
            ) {
                // Logo
                Image(painter = painterResource(id = R.drawable.logo200),
                    contentDescription = "App logo",
                    modifier = Modifier
                        .padding(top = 54.dp)
                        .height(100.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "Sign Up",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(255, 250, 240)
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 24.dp)
                )

                // Text Field
                CTextField(hint = "Username", value = username, onValueChange = setUsername, keyboardType = KeyboardType.Text )

                CTextField(hint = "Email Address", value = email , onValueChange = setEmail, keyboardType = KeyboardType.Email)

                CTextField(hint = "Password", value = password, onValueChange = setPassword, keyboardType = KeyboardType.Password , visualTransformation = PasswordVisualTransformation())

                Spacer(modifier = Modifier.height(24.dp))

                CButton(text = "Register")

                AlreadyHave(
                    onSignInTap = {
                        navController.navigate("login")
                    }
                )

            }

        }

    }

}


@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(rememberNavController())
}