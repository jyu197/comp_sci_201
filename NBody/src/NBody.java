import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import princeton.StdAudio;
import princeton.StdDraw;

public class NBody{
	
    public static final double G = 6.67E-11;

    /**
     * returns Euclidean distance between (x1, y1) and (x2, y2)
     *
     * @param x1
     *            x-coordinate of point 1
     * @param y1
     *            y-coordinate of point 1
     * @param x2
     *            x-coordinate of point 2
     * @param y2
     *            y-coordinate of point 2
     * @return Euclidean distance between (x1, y1) and (x2, y2)
     */
    public double distance(double x1, double y1, double x2, double y2) {
    	return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
    
    
    /**
     * return the magnitude of the gravitational force between two bodies of
     * mass m1 and m2 that are distance r apart
     *
     * @param m1
     *            mass of body 1 in kg
     * @param m2
     *            mass of body 2 in kg
     * @param r
     *            distance in m
     * @return force between m1 and m2 that are distance r apart
     */
    public double force(double m1, double m2, double r) {
        return G * m1 * m2 / Math.pow(r, 2);
    }


    /**
     * Returns the x positions and y positions of bodies
     * @param totalTime The total amount of universe time to run for
     * @param timeStep The value of delta t in the equations to calculate position
     * @param info The scanner with info about the initial conditions of the
     * bodies
     * @return an array whose first element is the x and y position of the first body, and so on
     * t = totalTime
     */
    public double[][] positions(Scanner info, int totalTime, int timeStep) {
    	int numBodies = info.nextInt();
    	double radius = info.nextDouble();
    	double[] px = new double[numBodies];
    	double[] py = new double[numBodies];
    	double[] vx = new double[numBodies];
    	double[] vy = new double[numBodies];
    	double[] mass = new double[numBodies];
    	String[] image = new String[numBodies];
    	for (int i = 0; i < numBodies; i++) {
    		px[i] = info.nextDouble();
    		py[i] = info.nextDouble();
    		vx[i] = info.nextDouble();
    		vy[i] = info.nextDouble();
    		mass[i] = info.nextDouble();
    		image[i] = "data/" + info.next();
    	}
    	
    	StdDraw.setXscale(-radius, radius);
    	StdDraw.setYscale(-radius, radius);
    	for (int i = 0; i < totalTime; i += timeStep) {
    		double[] fx = new double[numBodies];
        	double[] fy = new double[numBodies];
        	for (int j = 0; j < numBodies; j++) {
        		fx[j] = 0.0;
        		fy[j] = 0.0;
        	}
        	for (int j = 0; j < numBodies; j++) {
        		for (int k = 0; k < numBodies; k++) {
        			if (j == k) {
        				continue;
        			}
        			double dist = distance(px[j], py[j], px[k], py[k]);
        			double mag = force(mass[j], mass[k], dist);
        			fx[j] += mag * (px[k] - px[j]) / dist;
        			fy[j] += mag * (py[k] - py[j]) / dist;
        		}
        	}
    		
    		for (int j = 0; j < numBodies; j++) {
    			vx[j] += fx[j] / mass[j] * timeStep;
    			vy[j] += fy[j] / mass[j] * timeStep;
	    		px[j] += vx[j] * timeStep;
	    		py[j] += vy[j] * timeStep;
	    	}
    		
	    	StdDraw.picture(0, 0, "data/starfield.jpg");
	    	for (int j = 0; j < numBodies; j++) {
	    		StdDraw.picture(px[j], py[j], image[j]);
	    	}
	    	StdDraw.show(30);
    	}
    	    	
        double[][] output = new double[numBodies][2];
        for (int i = 0; i < numBodies; i++){
        	output[i][0] = px[i];
        	output[i][1] = py[i];
        }
        return output;	
    }

    public static void main(String[] args) {
        Scanner info = openFile();
        int time = 10000000;
        int dt = 25000;
        
        if (info != null) {
            //StdAudio.play("data/2001.mid");
            NBody myNBody = new NBody();
            double[][] results = myNBody.positions(info, time, dt);
            for(int i = 0; i < results.length; i++) {
                for(int j = 0; j < results[i].length; j++) {
                    System.out.print(results[i][j]+" ");
                }
                System.out.println();
            }
            StdAudio.close();
        }
    }
    /**
     * Displays file chooser for browsing in the project directory. and opens
     * the selected file
     *
     * @return a new Scanner that produces values scanned from the selected
     *         file. null if file could not be opened or was not selected
     */
    
    public static Scanner openFile() {
        Scanner scan = null;
        System.out.println("Opening file dialog.");
        JFileChooser openChooser = new JFileChooser(System.getProperties()
                                                    .getProperty("user.dir"));
        
        int retval = openChooser.showOpenDialog(null);
        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = openChooser.getSelectedFile();
            System.out.println(file.getAbsolutePath());
            try {
                scan = new Scanner(file);
                System.out.println("Opening: " + file.getName() + ".");
            } catch (FileNotFoundException e) {
                System.out.println("Could not open selected file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("File open canceled.");
            System.exit(0);
        }
        
        return scan;
    }
}