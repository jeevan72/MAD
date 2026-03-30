package com.example.wallpaper 
import android.graphics.Bitmap 
import android.graphics.BitmapFactory 
import androidx.appcompat.app.AppCompatActivity 
import android.os.Bundle 
import android.widget.Button 
import android.widget.Toast 
import java.util.* 
import android.app.WallpaperManager 
import kotlin.concurrent.schedule 
import kotlin.concurrent.timerTask 
class MainActivity : AppCompatActivity() { 
var myWallpaperlist = arrayOf( R.drawable.one,R.drawable.two, R.drawable.three, R.drawable.four) 
private lateinit var changeWallpaper: Button 
override fun onCreate(savedInstanceState: Bundle?) { 
super.onCreate(savedInstanceState) 
setContentView(R.layout.activity_main) 
changeWallpaper = findViewById(R.id.set_wallpaper) 
changeWallpaper.setOnClickListener { setWallpapper() } 
} 
fun setWallpapper() { 
Toast.makeText(this, "Setting  Wallpaper  please wait", Toast.LENGTH_SHORT).show() 
Timer().schedule(200) 
{ 
for (i in myWallpaperlist) { 
val Bitmap = BitmapFactory.decodeResource(resources, i) 
val wallpapermanager = WallpaperManager.getInstance(baseContext) 
wallpapermanager.setBitmap(Bitmap) 
} 
} 
} 
} 
androidmanifest.xml 
<uses-permissionandroid:name="android.permission.SET_WALLPAPER"/> 
Actvitymain.xml 
<?xml version="1.0" encoding="utf-8"?> 
<androidx.constraintlayout.widget.ConstraintLayout 
xmlns:android="http://schemas.android.com/apk/res/android" 
xmlns:app="http://schemas.android.com/apk/res-auto" 
xmlns:tools="http://schemas.android.com/tools" 
android:layout_width="match_parent" 
android:layout_height="match_parent" 
tools:context=".MainActivity"> 
<Button 
android:id="@+id/set_wallpaper" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:text="set wallpaper" 
tools:layout_editor_absoluteX="141dp" 
tools:layout_editor_absoluteY="310dp" /> 
</androidx.constraintlayout.widget.ConstraintLayout>
