package app;

import io.github.humbleui.skija.Canvas;
import io.github.humbleui.skija.Paint;
import misc.CoordinateSystem2d;
import misc.CoordinateSystem2i;
import misc.Vector2d;
import misc.Vector2i;


public class Circle {
    Vector2d center;
    Vector2d p;

    double r;

    public Circle(Vector2d center, Vector2d p) {
        this.center = center;
        this.p = p;
        this.r = Math.sqrt((center.x-p.x)*(center.x-p.x)+((center.y-p.y)*(center.y-p.y)));

        System.out.println("конструктор "+center+" "+p);
    }

    public void render(Canvas canvas, CoordinateSystem2i windowCS, CoordinateSystem2d ownCS){
        try (var p = new Paint()) {
// центр окружности
            Vector2i center = new Vector2i(350, 350);
            // радиус окружности
            int rad = 200;
            // радиус вдоль оси x
            int radX = (int) (rad * 1.3);
            // радиус вдоль оси y
            int radY = (int) (rad * 0.9);
            // кол-во отсчётов цикла
            int loopCnt = 40;
            // создаём массив координат опорных точек
            float[] points = new float[loopCnt * 4];
            // запускаем цикл
            for (int i = 0; i < loopCnt; i++) {
                // x координата первой точки
                points[i * 4] = (float) (center.x + radX * Math.cos(Math.PI / 20 * i));
                // y координата первой точки
                points[i * 4 + 1] = (float) (center.x + radY * Math.sin(Math.PI / 20 * i));

                // x координата второй точки
                points[i * 4 + 2] = (float) (center.x + radX * Math.cos(Math.PI / 20 * (i + 1)));
                // y координата второй точки
                points[i * 4 + 3] = (float) (center.x + radY * Math.sin(Math.PI / 20 * (i + 1)));
            }
            // рисуем линии
            canvas.drawLines(points, p);
        }
    }

    public boolean contains(Vector2d pos){


        double d = Math.sqrt((center.x-pos.x)*(center.x-pos.x)+(center.y-p.y)*(center.y-p.y));
        return d<=r;
    }
}
