/**
 * An obstacle in the simulation that can move and detect particles away from obstacles
 */

public class Obstacle {
    private double x; // x coordinate of obstacle
    private double y; // y coordinate of obstacle
    private double radius; // radius of obstacle

    /**
     * Constructor for obstable at given position with given radiuss
     * @param x x the x coordinate
     * @param y y coordinate of the obstacle
     * @param r radius of the obstacle
     */
    public Obstacle(double x, double y, double r) {
        this.x = x;
        this.y = r;
        this.radius = r;

    }
    /**
     * gets x coordinate of the obstacle
     * @return x coordinate
     */
    public double getX() { return x; }
    /**
     * gets y coordinate of the obstacle
     * @return y coordinate of the obstacle
     */
    public double getY() { return y; }
    /**
     * gets radius of the obstacle
     * @return radius of the obstacle
     */
    public double getRadius() { return radius; }
 
    /**
     * sets x coordinate of obstacle
     * @param xPos new x coordinate for obstacle
     */
    public void setX(double xPos) {this.x = xPos; }
      /**
     * sets y coordinate of obstacle
     * @param yPos new y coordinate for obstacle
     */
    public void setY(double yPos) {this.y = yPos; } 
    /**
     * sets radius of obstacle that needs to be positive
     * @param r new radius for obstacle
     */
    public void setRadius(double r) {
        if(r > 0) {
            this.radius = r;
        }
        else {
            System.out.println("Radius must be positive");
        }
     }

     /**
      * Checks for collision of the obstacle with particle
      * @param p p particle that checks collision
      * @return return true if obstacle collision occurs and false if it doesnt
      */
     public boolean checkCollision(Particle p){
        double distance = Vector2DMath.magnitude(x-p.getX(), y-p.getY());
        return distance <= radius + p.getRadius();
     }
     /**
      * For the collision of particle and obstacle
      * particle moved to new position and normal vector of collision return
      * @param p particle that collides with obstacle
      * @return normal vecotor of collision
      */

     public double[] collide(Particle p) {
        double[] normal = Vector2DMath.normal(p.getX() - this.x, p.getY() - this.y);
        double distance = radius + p.getRadius();
        p.setX(x + normal[0] * distance);
        p.setY(y + normal[1] * distance);
        return normal;
     }
     
}