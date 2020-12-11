import java.util.ArrayList;
public class SWCharacter{
    private String name;
    private boolean jedi;
    private boolean droid;
    private boolean humanLike;
    private boolean wookie;
    private boolean darkSide;
    private boolean lightSide;
    private boolean bountyHunter;
    private boolean smuggler;
    private byte kesselSpeed;
    private boolean empire;
    private boolean rebel;
    private boolean resistance;
    private boolean firstOrder;
    private boolean separatist;
    private boolean galacticRepublic;
    private boolean ewok;
    private boolean fluffy;
    private boolean slimey;
    private byte lightsaberColor;
    private boolean tall;
    private boolean shortH;
    private boolean pilot;
    private boolean annoying;
    private boolean cute;
    private boolean bandersFav;
    private boolean gotButtWhooped;
    private boolean insideATauntaun;
    private boolean stillLiving;
    private boolean lostALimb;
    private boolean spaceBallsCharacter;

/*
 * Really there is not mucto say here
 * this is all just set up for all the 
 * characteristics for each character
 * 
*/

    public SWCharacter(String charInfo){
        String optionsString[] = charInfo.split(",");
        this.name = optionsString[0];
        this.jedi = Byte.valueOf(optionsString[1]) == 1;
        this.droid = Byte.valueOf(optionsString[2]) == 1;
        this.humanLike = Byte.valueOf(optionsString[3]) == 1;
        this.wookie = Byte.valueOf(optionsString[4]) == 1;
        this.darkSide = Byte.valueOf(optionsString[5]) == 1;
        this.lightSide = Byte.valueOf(optionsString[6]) == 1;
        this.bountyHunter = Byte.valueOf(optionsString[7]) == 1;
        this.smuggler = Byte.valueOf(optionsString[8]) == 1;
        this.kesselSpeed = Byte.valueOf(optionsString[9]);     
        this.empire = Byte.valueOf(optionsString[10]) == 1;
        this.rebel = Byte.valueOf(optionsString[11]) == 1;
        this.resistance = Byte.valueOf(optionsString[12]) == 1;
        this.firstOrder = Byte.valueOf(optionsString[13]) == 1;
        this.separatist = Byte.valueOf(optionsString[14] )== 1;
        this.galacticRepublic = Byte.valueOf(optionsString[15]) == 1;
        this.ewok = Byte.valueOf(optionsString[16]) == 1;
        this.fluffy = Byte.valueOf(optionsString[17]) == 1;
        this.slimey = Byte.valueOf(optionsString[18]) == 1;
        this.lightsaberColor = Byte.valueOf(optionsString[19]);
        this.tall = Byte.valueOf(optionsString[20]) == 1;
        this.shortH = Byte.valueOf(optionsString[21]) == 1;
        this.pilot = Byte.valueOf(optionsString[22]) == 1;
        this.annoying = Byte.valueOf(optionsString[23]) == 1;
        this.cute = Byte.valueOf(optionsString[24]) == 1;
        this.bandersFav = Byte.valueOf(optionsString[25]) == 1;
        this.gotButtWhooped = Byte.valueOf(optionsString[26]) == 1;
        this.insideATauntaun = Byte.valueOf(optionsString[27]) == 1;
        this.stillLiving = Byte.valueOf(optionsString[28]) == 1;
        this.lostALimb = Byte.valueOf(optionsString[29]) == 1;
        this.spaceBallsCharacter = Byte.valueOf(optionsString[30]) == 1;

    }

    public String toString(){return name;}

    public String getName() { return name; }
    public byte getKesselSpeed() { return kesselSpeed; }
    public byte getLightsaberColor() { return lightsaberColor; }
    public boolean isAnnoying() { return annoying; }
    public boolean isBandersFav() { return bandersFav; }
    public boolean isBountyHunter() { return bountyHunter; }
    public boolean isCute() { return cute; }
    public boolean isDarkSide() { return darkSide; }
    public boolean isDroid() { return droid; }
    public boolean isEmpire() { return empire; }
    public boolean isEwok() { return ewok; }
    public boolean isFirstOrder() { return firstOrder; }
    public boolean isFluffy() { return fluffy; }
    public boolean isGalacticRepublic() { return galacticRepublic; }
    public boolean isGotButtWhooped() { return gotButtWhooped; }
    public boolean isHumanLike() { return humanLike; }
    public boolean isInsideATauntaun() { return insideATauntaun; }
    public boolean isJedi() { return jedi; }
    public boolean isLightSide() { return lightSide; }
    public boolean isLostALimb() { return lostALimb; }
    public boolean isPilot() { return pilot; }
    public boolean isRebel() { return rebel; }
    public boolean isResistance() { return resistance; }
    public boolean isSeparatist() { return separatist; }
    public boolean isShortH() { return shortH; }
    public boolean isSlimey() { return slimey; }
    public boolean isSmuggler() { return smuggler; }
    public boolean isSpaceBallsCharacter() { return spaceBallsCharacter; }
    public boolean isStillLiving() { return stillLiving; }
    public boolean isTall() { return tall; }
    public boolean isWookie() { return wookie; }

/*
 * the following code is made from using this stackoverflow post
 * https://stackoverflow.com/questions/4280727/java-creating-an-array-of-methods
 * I do not know how it works, but it makes running the actual code much cleaner
 * because I only have to call the index that a person puts in instead of many if and else-if
 * statements
 * 
 * My understanding of the need for the @Overrides on everything is due to the interface returning two data types
 */

    interface QuestionsToAsk{
        boolean questionB();
        byte questionI();
    }

    
    private QuestionsToAsk[] questionsToAsks = new QuestionsToAsk[]{
        new QuestionsToAsk(){public boolean questionB() { return isJedi(); }
            @Override public byte questionI() {return 0;}}, //I Do not know why I need these, but the JVM is very unhappy if i do not have these}},
        new QuestionsToAsk(){public boolean questionB() { return isDroid(); }
            @Override public byte questionI() {return 0;}},
        new QuestionsToAsk(){public boolean questionB() { return isHumanLike(); }
            @Override public byte questionI() {return 0;}},
        new QuestionsToAsk(){public boolean questionB() { return isWookie(); }
            @Override public byte questionI() {return 0;}}, ,
        new QuestionsToAsk(){public boolean questionB() { return isDarkSide(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isLightSide(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isBountyHunter(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isSmuggler(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public byte questionI() { return getKesselSpeed(); }
            @Override public boolean questionB() {return false;}},
        new QuestionsToAsk(){public boolean questionB() { return isEmpire(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isRebel(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isResistance(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isFirstOrder(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isSeparatist(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isGalacticRepublic(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isEwok(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isSlimey(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public byte questionI(){return getLightsaberColor();}
            @Override public boolean questionB() {return false;}},
        new QuestionsToAsk(){public boolean questionB() { return isTall(); }
             @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isShortH(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isPilot(); }
            @Override public byte questionI() {return 0;}},
        new QuestionsToAsk(){public boolean questionB() { return isAnnoying(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isCute(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isBandersFav(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isGotButtWhooped(); }
            @Override public byte questionI() {return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isInsideATauntaun(); }
            @Override public byte questionI() { return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isStillLiving(); }
            @Override public byte questionI() { return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isLostALimb(); }
            @Override public byte questionI() { return 0;}}, 
        new QuestionsToAsk(){public boolean questionB() { return isSpaceBallsCharacter(); }
            @Override public byte questionI() {return 0;}}};

        public boolean questionB(int index){return questionsToAsks[index].questionB();}
        public byte questionI(int index){return questionsToAsks[index].questionI();}
    }