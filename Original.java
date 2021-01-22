package strong;
import robocode.*;
import static robocode.util.Utils.normalRelativeAngleDegrees;
import java.awt.Color;
/**
 * Original - a robot by (e175765)
 */
public class Original extends Robot
{
	int flag = 0;
	double moveAmount;
	boolean go = false;
	public void run() {
		setBodyColor(Color.green);
		setGunColor(Color.green);
		setRadarColor(Color.green);
		setScanColor(Color.green);
		setBulletColor(Color.green);
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
		turnLeft(getHeading() % 90);
		ahead(moveAmount);
		//turnGunRight(90);
		turnRight(90);
		//turnGunRight(180);
		//turnGunLeft(180);
		while(true) {
			if (flag == 1)
				doNothing();
			else
				go = false;
				back(moveAmount);
				turnGunRight(180);
				go = true;
				ahead(moveAmount);
				turnGunLeft(180);
				
				
		}
	}
	
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(1);
	}

	public void onHitByBullet(HitByBulletEvent e) {
		//double ba = e.getHeading() - 180 
		double diff = e.getHeading() - getGunHeading();
		//flag = 0;
		if (flag == 0)
			//turnRight(90+e.getHeading());
			if (diff < 0)
				if (diff < -180)
					turnGunRight(180 - Math.abs(diff));
				else
					turnGunLeft(Math.abs(diff) - 180);
			else
				if (diff < 180)
					turnGunLeft(180 - diff);
				else 
					turnGunRight(diff - 180);
			//ahead(50);
			fire(1);
			if (diff < 0)
				if (diff < -180)
					turnGunRight(-(180 - Math.abs(diff)));
				else
					turnGunLeft(-(Math.abs(diff) - 180));
			else
				if (diff < 180)
					turnGunLeft(-(180 - diff));
				else 
					turnGunRight(-(diff - 180));
			//flag = 1;		
		
	}
	
	public void onHitRobot(HitRobotEvent e){
		flag = 1;
		/*if (e.getBearing() < 0 )
			turnGunLeft(Math.abs(e.getBearing()));
		else
			turnGunRight(e.getBearing());*/
		/*
		if (go)
			back(20);
		else
			ahead(20);
		*/
		if (go)
			back(20);
			//turnRight(90);
			//ahead(moveAmount);
			//turnRight(90);
		else
			ahead(20);
			//turnRight(90);
			//ahead(moveAmount);
			//turnRight(90);
		turnRight(90);
		ahead(moveAmount);
		turnRight(90);
			
		//fire(1);
	}
}
