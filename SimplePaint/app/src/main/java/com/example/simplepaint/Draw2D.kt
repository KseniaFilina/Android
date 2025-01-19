package com.example.simplepaint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View

class Draw2D(context: Context?) : View(context) {
    private val paint: Paint = Paint()
    private val rect: Rect = Rect()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.apply {
            style = Paint.Style.FILL
            color = Color.WHITE
        }
        canvas?.drawPaint(paint)

        paint.apply {
            isAntiAlias = true
            color = Color.YELLOW
        }
        canvas?.drawCircle(950F, 300F, 100F, paint)

        paint.color = Color.GREEN
        canvas?.drawRect(20F, 650F, 950F, 680F, paint)

        paint.apply {
            color = Color.BLUE
            style = Paint.Style.FILL
            isAntiAlias = true
            textSize = 32F
        }
        canvas?.drawText("Лужайка только для котов", 30F, 648F, paint)

        paint.apply {
            color = Color.GRAY
            style = Paint.Style.FILL
            textSize = 27F
        }

        val str2rotate = "Лучик солнца!"

        canvas?.save()
        canvas?.rotate(-45F, 810F + rect.exactCenterX(), 190F + rect.exactCenterY())
        canvas?.drawText(str2rotate, 810F, 190F, paint)

        canvas?.restore()
    }
}