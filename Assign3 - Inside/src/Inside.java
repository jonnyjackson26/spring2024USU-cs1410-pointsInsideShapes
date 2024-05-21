/**
 * Assignment 3 for CS 1410
 * This program determines if points are contained within circles or rectangles.
 */
public class Inside {
    /**
     * This is the primary driver code to test the "inside" capabilities of the
     * various functions.
     */
    public static void main(String[] args) {
        double[] ptX = { 1, 2, 3, 4 };
        double[] ptY = { 1, 2, 3, 4 };
        double[] circleX = { 0, 5 };
        double[] circleY = { 0, 5 };
        double[] circleRadius = { 3, 3 };
        double[] rectLeft = { -2.5, -2.5 };
        double[] rectTop = { 2.5, 5.0 };
        double[] rectWidth = { 6.0, 5.0 };
        double[] rectHeight = { 5.0, 2.5 };

        // Report of Points and Circles
        System.out.println("--- Report of Points and Circles ---");
        for (int i = 0; i < circleX.length; i++) {
            reportPointAndCircle(ptX[i], ptY[i], circleX[i], circleY[i], circleRadius[i]);
        }

        // Report of Points and Rectangles
        System.out.println("--- Report of Points and Circles ---");
        for (int i = 0; i < rectLeft.length; i++) {
            reportPointAndRectangle(ptX[i], ptY[i], rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i]);
        }
//
    }

    public static boolean isPointInsideCircle(double ptX, double ptY, double circleX, double circleY, double circleRadius) {
        double distance = Math.sqrt(Math.pow(ptX - circleX, 2) + Math.pow(ptY - circleY, 2));
        return distance <= circleRadius;
    }

    public static boolean isPointInsideRectangle(double ptX, double ptY, double rLeft, double rTop, double rWidth, double rHeight) {
        //return ptX >= rLeft && ptX <= rLeft + rWidth && ptY >= rTop && ptY <= rTop + rHeight; //or is it top-height??
        // Check if the point is within the rectangle boundaries
        boolean withinX = ptX >= rLeft && ptX <= (rLeft + rWidth);
        boolean withinY = ptY <= rTop && ptY >= (rTop - rHeight);

        // Return true if the point is within both X and Y boundaries
        return withinX && withinY;
    }


    public static void reportRectangle(double left, double top, double width, double height) {
        System.out.printf("Rectangle(%.1f,%.1f,%.1f,%.1f)",left,top, left+width,height+top);
    }

    public static void reportCircle(double x, double y, double r) {
        System.out.printf("Circle(%.1f,%.1f) Radius: %.1f",x,y,r);
    }

    public static void reportPoint(double x, double y) {
        System.out.printf("Point(%.1f,%.1f)",x,y);
    }

    public static void reportPointAndCircle(double ptX, double ptY, double circleX, double circleY, double circleRadius) {
        reportPoint(ptX, ptY);
        if (isPointInsideCircle(ptX, ptY, circleX, circleY, circleRadius)) {
            System.out.printf(" is inside ");
        } else {
            System.out.printf(" is outside ");
        }
        reportCircle(circleX, circleY, circleRadius);
        System.out.println();
    }

    public static void reportPointAndRectangle(double ptX, double ptY, double rLeft, double rTop, double rWidth, double rHeight) {
        reportPoint(ptX, ptY);
        if (isPointInsideRectangle(ptX, ptY, rLeft, rTop, rWidth, rHeight)) {
            System.out.printf(" is inside ");
        } else {
            System.out.printf(" is outside ");
        }
        reportRectangle(rLeft, rTop, rWidth, rHeight);
        System.out.println();
    }
}
