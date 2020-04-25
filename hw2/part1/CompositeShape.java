package hw2;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.*;

public class CompositeShape implements Shape{
    
    private ArrayList <Shape> shapes;
    Rectangle2D rect2D;
    Rectangle rect;
    
    public CompositeShape() {
        shapes = new ArrayList<Shape>();
        rect2D = new Rectangle();
        rect = new Rectangle();
    }
    
    @Override
    public Rectangle getBounds() {
        for(int i=0; i<shapes.size();i++) {
            rect.union(shapes.get(i).getBounds());
        }
        return rect;
    }

    @Override
    public Rectangle2D getBounds2D() {
        for(int i=0;i<shapes.size();i++) {
            Rectangle2D.union(shapes.get(i).getBounds2D(),shapes.get(i).getBounds2D(), rect2D);
        }
        return rect2D;
    }

    @Override
    public boolean contains(double x, double y) {
        boolean status = false;
        for(int i=0;i<shapes.size();i++) {
            if(shapes.get(i).contains(x,y)) {
                status = true;
            }
        }
        return status;
    }

    @Override
    public boolean contains(Point2D p) {
        boolean status = false;
        for(int i=0;i<shapes.size();i++) {
            if(shapes.get(i).contains(p)) {
                status = true;
            }
        }
        return status;
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        boolean status = false;
        for(int i=0;i<shapes.size();i++) {
            if(shapes.get(i).intersects(x, y, w, h)) {
                status = true;
            }
        }
        return status;
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        boolean status = false;
        for(int i=0;i<shapes.size();i++) {
            if(shapes.get(i).contains(r)) {
                status = true;
            }
        }
        return status;
    }   


    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return new PathIterator() {
            private PathIterator currentPathIterator;
            private Iterator<Shape> shapesIterator;

            // Constructor for an anonymous class
            {
                shapesIterator = shapes.iterator();
                nextShape();
            }

            private void nextShape() {
                if (shapesIterator.hasNext()) {
                    currentPathIterator = shapesIterator.next().getPathIterator(at);
                } else {
                    currentPathIterator = null;
                }
            }

            @Override
            public int getWindingRule() {
                return WIND_NON_ZERO;
            }

            @Override
            public boolean isDone() {
                if (currentPathIterator == null)
                    return true;
                if (!currentPathIterator.isDone())
                    return false;
                nextShape();
                return isDone(); // using recursion here but you can just loop through it too
            }

            @Override
            public void next() {
                currentPathIterator.next();
            }

            @Override
            public int currentSegment(float[] coords) {
                return currentPathIterator.currentSegment(coords);
            }

            @Override
            public int currentSegment(double[] coords) {
                return currentPathIterator.currentSegment(coords);
            }
        };

    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return new PathIterator() {
            private PathIterator currentPathIterator;
            private Iterator<Shape> shapesIterator;

            // Constructor for an anonymous class
            {
                shapesIterator = shapes.iterator();
                nextShape();
            }

            private void nextShape() {
                if (shapesIterator.hasNext()) {
                    currentPathIterator = shapesIterator.next().getPathIterator(at, flatness);
                } else {
                    currentPathIterator = null;
                }
            }

            @Override
            public int getWindingRule() {
                return WIND_NON_ZERO;
            }

            @Override
            public boolean isDone() {
                if (currentPathIterator == null)
                    return true;
                if (!currentPathIterator.isDone())
                    return false;
                nextShape();
                return isDone(); // using recursion here but you can just loop through it too
            }

            @Override
            public void next() {
                currentPathIterator.next();
            }

            @Override
            public int currentSegment(float[] coords) {
                return currentPathIterator.currentSegment(coords);
            }

            @Override
            public int currentSegment(double[] coords) {
                return currentPathIterator.currentSegment(coords);
            }
        };
    }
    
   public void add(Shape shape) {
      shapes.add(shape);
   }

}
