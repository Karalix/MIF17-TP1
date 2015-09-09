package logo;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author p1410147
 */
public class TortueBalle extends Tortue{
    public TortueBalle(){

    }
    @Override
    public void drawTurtle (Graphics graph) {
        if (graph==null)
			return;

		Point p = new Point(x,y);
		Polygon arrow = new Polygon();

		Point p1 = new Point(x-3,y+3);
		Point p11 = new Point(x-5, y);
            Point p2 = new Point(x-3,y-3);
            Point p21 = new Point(x, y-5);
            Point p3 = new Point(x+3,y-3);
            Point p31 = new Point(x+5, y);
            Point p4 = new Point(x+3,y+3);
            Point p41 = new Point(x, y+5);


		arrow.addPoint(p1.x,p1.y);
		arrow.addPoint(p11.x,p11.y);
            arrow.addPoint(p2.x,p2.y);
            arrow.addPoint(p21.x,p21.y);
            arrow.addPoint(p3.x,p3.y);
            arrow.addPoint(p31.x,p31.y);
            arrow.addPoint(p4.x,p4.y);
            arrow.addPoint(p41.x,p41.y);

		graph.setColor(Color.red);
		graph.fillPolygon(arrow);
    }

}
