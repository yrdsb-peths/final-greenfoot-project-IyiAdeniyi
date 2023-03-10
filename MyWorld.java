import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main game screen, fairy attempts to get to world tree, while 
 * collecting coins along the way and attempting to avoid the 
 * ice fairies.
 * 
 * @author Iyi Adeniyi 
 * @version 2023-01-18
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public int coins = 0;
    Label scoreLabel;
    public int level = 1;
    public static int levels = 1;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1);
        
        setCoins();
        setLabel();
        
        spawnIceFairy();
        
        LevelOneLabel labelOne = new LevelOneLabel();
        addObject(labelOne,400,25);
        
        prepare();
        setPaintOrder(FairyTree.class, IceFairy.class);
    }
    
    /**
     * Increases level when is called
     */
    public void setNextLevel()
    {
        level+=1;
        levels+=1;
    }
    
    /**
     * Sets the label to it's proper level.
     */
    public void setLabel()
    {
        LevelOneLabel labelOne = new LevelOneLabel();
        LevelTwoLabel labelTwo = new LevelTwoLabel();
        LevelThreeLabel labelThree = new LevelThreeLabel();
        LevelFourLabel labelFour = new LevelFourLabel();
        LevelFiveLabel labelFive = new LevelFiveLabel();
        LevelSixLabel labelSix = new LevelSixLabel();

        
        if(level ==2)
        {
            removeObject(labelOne);
            addObject(labelTwo,400,25);
        }
        
        if(level ==3)
        {
            removeObject(labelTwo);
            addObject(labelThree,400,25);
        }
        
        if(level ==4)
        {
            removeObject(labelThree);
            addObject(labelFour,400,25);
        }
        
        if(level ==5)
        {
            removeObject(labelFour);
            addObject(labelFive,400,25);
        }
        
        if(level ==6)
        {
            removeObject(labelFive);
            addObject(labelSix,400,25);
        }
    }
    
    /**
     * Adds coins to world after each level.
     */
    public void setCoins()
    {
        Coin coin = new Coin();
        addObject(coin,230,368);
        
        Coin coin2 = new Coin();
        addObject(coin2,401,369);
        
        Coin coin3 = new Coin();
        addObject(coin3,556,370);
    }
    
    /**
     * Create new icefairy once level increases
     */
    public void spawnIceFairy()
    {
        IceFairy icefairy = new IceFairy();
        icefairy.setSpeed(-level);
        addObject(icefairy, 710,372);
    }
    
    /**
     * Once called, increases coins once collected
     */
    public void increaseCoin()
    {
        coins++;
        scoreLabel.setValue(coins);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 750, 45);
        
        Fairy fairy = new Fairy();
        addObject(fairy,95,340);
        
        FairyTree fairyTree = new FairyTree();
        addObject(fairyTree,710,307);

        BackButton backButton = new BackButton();
        addObject(backButton,39,27);

        GameTile gameTile = new GameTile();
        addObject(gameTile,44,419);

        GameTile gameTile2 = new GameTile();
        addObject(gameTile2,121,419);

        GameTile gameTile3 = new GameTile();
        addObject(gameTile3,198,419);

        GameTile gameTile4 = new GameTile();
        addObject(gameTile4,276,419);

        GameTile gameTile5 = new GameTile();
        addObject(gameTile5,355,419);

        GameTile gameTile6 = new GameTile();
        addObject(gameTile6,435,419);

        GameTile gameTile7 = new GameTile();
        addObject(gameTile7,513,419);

        GameTile gameTile8 = new GameTile();
        addObject(gameTile8,592,419);

        GameTile gameTile9 = new GameTile();
        addObject(gameTile9,671,419);

        GameTile gameTile10 = new GameTile();
        addObject(gameTile10,749,419);
    }
}