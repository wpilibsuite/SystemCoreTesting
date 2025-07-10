// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.PWM.OutputPeriod;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Timer;

///////////// SYSTEMCORE PWM OUTPUT TEST /////////////
// REQUIRES ALPHA 4
// while disabled, pulse widths are locked at 1500us and you will only see changes to the period.
// enable to observe changing pulse widths.
// change the team number in .wpilib/wpilib_preferences.json to match that of your systemcore and ds.

public class Robot extends TimedRobot 
{
  private static final PWM P0 = new PWM(0);
  private static final PWM P1 = new PWM(1);
  private static final PWM P2 = new PWM(2);
  private static final PWM P3 = new PWM(3);
  private static final PWM P4 = new PWM(4);
  private static final PWM P5 = new PWM(5);

  private double startTime = 0;
  private int currentPeriodIndex = 0;
  private double lastPeriodChangeTime =0;
  private final OutputPeriod[] periods = {OutputPeriod.k5Ms, OutputPeriod.k10Ms, OutputPeriod.k20Ms};

  public Robot() 
  {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void robotPeriodic() 
  {
    double currentTime = Timer.getFPGATimestamp();
    
    if (currentTime - lastPeriodChangeTime >= 1.0) 
    {
      currentPeriodIndex = (currentPeriodIndex + 1) % periods.length;
      lastPeriodChangeTime = currentTime;
    }
    
    P0.setOutputPeriod(periods[currentPeriodIndex]);
    P1.setOutputPeriod(periods[(currentPeriodIndex + 1) % periods.length]);
    P2.setOutputPeriod(periods[(currentPeriodIndex + 2) % periods.length]);
    P3.setOutputPeriod(periods[(currentPeriodIndex + 3) % periods.length]);
    P4.setOutputPeriod(periods[(currentPeriodIndex + 4) % periods.length]);
    P5.setOutputPeriod(periods[(currentPeriodIndex + 5) % periods.length]);
    //fixed periods:
    //P0.setOutputPeriod(periods[0]);
    //P1.setOutputPeriod(periods[0]);
    //P2.setOutputPeriod(periods[0]);
    //P3.setOutputPeriod(periods[0]);
    //P4.setOutputPeriod(periods[0]);
    //P5.setOutputPeriod(periods[0]);

    double timeElapsed = currentTime - startTime;
    double center = 2000;
    double range = 2000;

    double sinP0 = Math.sin(timeElapsed);
    double sinP1 = Math.sin(timeElapsed); 
    double sinP2 = Math.sin(timeElapsed);
    double sinP3 = Math.sin(timeElapsed);
    double sinP4 = Math.sin(timeElapsed);
    double sinP5 = Math.sin(timeElapsed);
    //double sinP0 = Math.sin(timeElapsed);
    //double sinP1 = Math.sin(timeElapsed + (2*Math.PI)*(1.0/6.0)); 
    //double sinP2 = Math.sin(timeElapsed + (2*Math.PI)*(2.0/6.0));
    //double sinP3 = Math.sin(timeElapsed + (2*Math.PI)*(3.0/6.0));
    //double sinP4 = Math.sin(timeElapsed + (2*Math.PI)*(4.0/6.0));
    //double sinP5 = Math.sin(timeElapsed + (2*Math.PI)*(5.0/6.0));
    
    int p0PulseWidth = (int)(center + range*sinP0);
    int p1PulseWidth = (int)(center + range*sinP1);
    int p2PulseWidth = (int)(center + range*sinP2);
    int p3PulseWidth = (int)(center + range*sinP3);
    int p4PulseWidth = (int)(center + range*sinP4);
    int p5PulseWidth = (int)(center + range*sinP5);
    
    P0.setPulseTimeMicroseconds(p0PulseWidth);
    P1.setPulseTimeMicroseconds(p1PulseWidth);
    P2.setPulseTimeMicroseconds(p2PulseWidth);
    P3.setPulseTimeMicroseconds(p3PulseWidth);
    P4.setPulseTimeMicroseconds(p4PulseWidth);
    P5.setPulseTimeMicroseconds(p5PulseWidth);
  }
}