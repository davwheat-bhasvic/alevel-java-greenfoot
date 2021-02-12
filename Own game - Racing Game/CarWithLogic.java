import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CarWithLogic extends Car {
    public final int playerNumber;
    protected boolean canMove = false;
    
    protected final String fwdKey;
    protected final String leftKey;
    protected final String rightKey;
    protected final String slowKey;
    
    protected double currentSpeed = 0;
    protected double maxSpeed = 2.5;
    protected int currentTurnSpeed;
    
    protected boolean wasOnStartFinishLineLastCheck = true;
    
    /**
     * 1 = S1, 2 = S2, 3 = S3, 4 = Error
     */
    protected int circuitSection = 0;
    protected int lastSection = 0;
    
    int progress = 0;
    
    protected int currentLap = 0;
    
    public int getCurrentLap() { return currentLap; }
    public int getCurrentSector() { return circuitSection; }
    
    public CarWithLogic(int carNumber, int playerNumber) {
        super(carNumber);
        
        // 50% size
        GreenfootImage bg = getImage();
        bg.scale(62, 25);
        setImage(bg);
        
        if (playerNumber == 1) {
            fwdKey = "w";
            leftKey = "a";
            rightKey = "d";
            slowKey = "s";
        } else {
            fwdKey = "up";
            leftKey = "left";
            rightKey = "right";
            slowKey = "down";
        }
        
        this.playerNumber = playerNumber;
    }
    
    public void enableMovement() {
        canMove = true;
    }
    
    public void disableMovement() {
        canMove = false;
    }
    
    public boolean canMove() {
        return canMove;
    }
    
    public boolean isOnStartFinishLine(World world) {
        int x = getX();
        int y = getY();
        
        Color col = world.getColorAt(getX(), getY());
        
        return col.equals(new Color(168, 168, 168));
    }
    
    protected int getSector() {
        int x = getX();
        int y = getY();
        
        int xBound1, xBound2, yBound1, yBound2;
        
        RaceCircuit world = (RaceCircuit) getWorld();
        CircuitData circuitData = world.getCircuitData();
        
        // S1 bounds
        xBound1 = circuitData.sector1bounds.x.x;
        yBound1 = circuitData.sector1bounds.x.y;
        xBound2 = circuitData.sector1bounds.y.x;
        yBound2 = circuitData.sector1bounds.y.y;
        
        int xMean = (xBound1 + xBound2) / 2;
        int yMean = (yBound1 + yBound2) / 2;
        if (Math.abs(x-xMean) <= (Math.abs(xBound1-xMean)) && Math.abs(y-yMean) <= (Math.abs(yBound1-yMean))) return 1;
        
        // S2 bounds
        xBound1 = circuitData.sector2bounds.x.x;
        yBound1 = circuitData.sector2bounds.x.y;
        xBound2 = circuitData.sector2bounds.y.x;
        yBound2 = circuitData.sector2bounds.y.y;
        
        xMean = (xBound1 + xBound2) / 2;
        yMean = (yBound1 + yBound2) / 2;
        if (Math.abs(x-xMean) <= (Math.abs(xBound1-xMean)) && Math.abs(y-yMean) <= (Math.abs(yBound1-yMean))) return 2;
        
        // S3 bounds
        xBound1 = circuitData.sector3bounds.x.x;
        yBound1 = circuitData.sector3bounds.x.y;
        xBound2 = circuitData.sector3bounds.y.x;
        yBound2 = circuitData.sector3bounds.y.y;
        
        xMean = (xBound1 + xBound2) / 2;
        yMean = (yBound1 + yBound2) / 2;
        if (Math.abs(x-xMean) <= (Math.abs(xBound1-xMean)) && Math.abs(y-yMean) <= (Math.abs(yBound1-yMean))) return 3;
        
        return 4;
    }
    
    @Override
    public void act() 
    {
        double prevX = getExactX();
        double prevY = getExactY();
        
        if (!canMove) return;
        
        if (currentSpeed > 0.1) currentSpeed -= 0.1;
        else if (currentSpeed < -0.1) currentSpeed += 0.1;
        else currentSpeed = 0.0;
        
        if (Greenfoot.isKeyDown(fwdKey)) {
            currentSpeed = currentSpeed + 1 / (Math.abs(currentSpeed) + 1);
            
            if (currentSpeed > maxSpeed) currentSpeed = maxSpeed;
        }
        
        if (Greenfoot.isKeyDown(slowKey)) {
            if (currentSpeed > 0) currentSpeed = currentSpeed - 0.6 / (Math.abs(currentSpeed) + 0.1);
            else currentSpeed = currentSpeed - 0.2 / (Math.abs(currentSpeed) + 0.1);
            
            if (currentSpeed < -maxSpeed) {
                currentSpeed = -maxSpeed;
            }
        }
        
        currentTurnSpeed = (int) Math.round(3 / ((currentSpeed + 0.1) / 3));
        if (currentTurnSpeed > 4) currentTurnSpeed = 4;
        
        int currentRot = getRot();
        
        if (Greenfoot.isKeyDown(leftKey)) {
            currentRot -= currentTurnSpeed;
        }
        
        if (Greenfoot.isKeyDown(rightKey)) {
            currentRot += currentTurnSpeed;
        }
        
        move(currentSpeed);
        setRot(currentRot);
        
        World world = getWorld();
        Color col = world.getColorAt(getX(), getY());
        
        if (col.equals(new Color(73, 142, 45)) || col.equals(new Color(255, 255, 255)) || col.equals(new Color(255, 0, 0))) {
            setLocation(prevX, prevY);
        }
        
        if (isOnStartFinishLine(world) && !wasOnStartFinishLineLastCheck && progress == 3 && lastSection == 2 && circuitSection == 3 && progress == 3) {
            wasOnStartFinishLineLastCheck = true;
            currentLap++;
        } else if (!isOnStartFinishLine(world) && wasOnStartFinishLineLastCheck && progress == 3) {
            wasOnStartFinishLineLastCheck = false;
        }
        
        int sector = getSector();
        if (sector != circuitSection) {
            lastSection = circuitSection;
            circuitSection = sector;
            
            if (lastSection == circuitSection - 1) {
                progress = circuitSection;
            } else if (lastSection == 3 && circuitSection == 1) {
                progress = 1;
            }
        }
    }
}
