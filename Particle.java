public class Particle {
    private double x;
    private double y;
    private double radius;
    private double velocityX;
    private double velocityY;
    private double gravity;

    public Particle(double xPos, double yPos, double r) {
        this.x = xPos;
        this.y = yPos;
        this.radius = r;
        this.velocityX = 0.0;
        velocityY = 0.0;
        gravity = -1.0;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getRadius() { return radius; }
    public double getVelocityX() { return velocityX; }
    public double getVelocityY() { return velocityY; }
    public double getGravity() { return gravity; }

    public void setX(double xPos) {this.x = xPos; }
    public void setY(double yPos) {this.y = yPos; } 
    public void setRadius(double r) {
        if(r > 0) {
            this.radius = r;
        }
        else {
            System.out.println("Radius must be positive");
        }
     }
    public void setVelocityX(double vx) {this.velocityX = vx; }
    public void setVelocityY(double vy) {this.velocityY = vy; }
    public void setGravity(double g) {this.gravity = g; }

    public void update(double dt) {
        velocityY = velocityY + gravity*dt;

        x = x + velocityX*dt;
        y = y + velocityY*dt;

        if (y<=radius) {
            y = radius;

            velocityY = -1.0*velocityY*0.6;
        }
    }

    public void handleCollision(Obstacle obstacle) {
        if (obstacle.checkCollision(this)) {
            double[] normal = obstacle.collide(this);

            if (Vector2DMath.magnitude(velocityX, velocityY) < 0.2) {
                velocityX = normal[0]*0.5;
                velocityY = normal[1]*0.5;

            }
            else {
            double[] reflect = Vector2DMath.reflect(normal, velocityX, velocityY);
            velocityX = reflect[0]*0.5;
            velocityY = reflect[1]*0.5;
        }
    }
    }

    public void setVelocity(double vx, double vy) {
        velocityX = vx;
        velocityY = vy;
    }
    public void respawn() {
        this.x = Math.random() * maxX;
        this.y = Math.random() * maxY;
        this.velocityX = (Math.random() * 2 - 1) * 5; 
        this.velocityY = (Math.random() * 2 - 1) * 5
}
}