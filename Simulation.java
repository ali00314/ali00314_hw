import java.util.ArrayList;
import java.util.List;
    
public class Simulation {
    private Particle[] particles;
    private int numParticles;
    private int fixedSize;
    private ObstacleNode obstacleList;

    public Simulation(int fixedSize) {
      
        this.fixedSize = fixedSize;
        this.particles = new Particle[fixedSize];
        this.numParticles = 0;
        this.obstacleList = null;
    }

    public Particle getParticles(int index) {
        if (index >= 0 && index < numParticles) {
            return particles[index];
        }
        return null;
    }

    public int getNumParticles() {
        return numParticles;
    }

    public void addParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            if (numParticles >= fixedSize) {
                fixedSize *= 2;
                Particle[] newParticles = new Particle[fixedSize];
                System.arraycopy(particles, 0, newParticles, 0, particles.length);
                particles = newParticles;
            }
            particles[numParticles++] = new Particle(0.0, 1.0, 0.05);
        }
    }

    public void removeParticles(int amount) {
        numParticles = Math.max(0, numParticles - amount);
    }

    public void addObstacle(Obstacle obstacle) {
        ObstacleNode newNode = new ObstacleNode(obstacle);
        if (obstacleList == null) {
            obstacleList = newNode; 
        } else {
            ObstacleNode current = obstacleList;
            while (current.getNext() != null) {
                current = current.getNext(); 
            }
            current.setNext(newNode); 
        }
    }

    public void removeObstacle(Obstacle obstacle) {
        if (obstacleList == null) 
            return; 

        if (obstacleList.getObstacle().equals(obstacle)) {
            obstacleList = obstacleList.getNext(); 
            return;
        }

        ObstacleNode current = obstacleList;
        while (current.getNext() != null) {
            if (current.getNext().getObstacle().equals(obstacle)) {
                current.setNext(current.getNext().getNext()); 
                return;
            }
            current = current.getNext(); 
        }
    }

    public ObstacleNode getObstacles() {
        return obstacleList;
    }
}
