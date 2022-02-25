package frc.robot;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import ca.team3161.lib.robot.subsystem.RepeatingPooledSubsystem;
import ca.team3161.lib.robot.BlinkinLEDController;
import ca.team3161.lib.robot.BlinkinLEDController.Pattern;

public class LEDTest extends RepeatingPooledSubsystem {

    private final BlinkinLEDController led;

    LEDTest(int pwmPort) {
        super (3, TimeUnit.SECONDS);
        led = new BlinkinLEDController(pwmPort);
    }

    public void  task(){
        Arrays.asList(Pattern.values()).forEach(pattern -> this.led.setLEDPattern(pattern));
    }

    @Override
    public void defineResources() {
    }

}
