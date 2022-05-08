package com.example.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.Calendar

/**
 * Implementation of App Widget functionality.
 */
class MyWidget : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        // There may be multiple widgets active, so update all of them

        for (appWidgetId in appWidgetIds) {
            /*var intent = Intent(context, MainActivity::class.java)
            var pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
            var remoteViews = RemoteViews(context.packageName, R.layout.my_widget)
            remoteViews.setOnClickPendingIntent(R.id.btnAbrirApp, pendingIntent)

            var simpleDateFormat = SimpleDateFormat("HH:mm:ss")
            var strDate = simpleDateFormat.format(Calendar.getInstance().time)
            remoteViews.setTextViewText(R.id.horaUltimaActualizacion, strDate)*/

            /*if (MainActivity.numImage == 0) {
                remoteViews.setImageViewResource(R.id.imagenWidget,R.drawable.img_1)
            }*/
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
    val widgetText = context.getString(R.string.appwidget_text)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.my_widget)

    val intent = Intent(context, MainActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
    views.setOnClickPendingIntent(R.id.btnAbrirApp,pendingIntent)

    var simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
    var strDate = simpleDateFormat.format(Calendar.getInstance().time)
    views.setTextViewText(R.id.horaUltimaActualizacion, strDate)

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}