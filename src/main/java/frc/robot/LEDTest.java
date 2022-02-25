package frc.robot;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import ca.team3161.lib.robot.subsystem.RepeatingPooledSubsystem;
import ca.team3161.lib.robot.BlinkinLEDController;
import ca.team3161.lib.robot.BlinkinLEDController.Pattern;

public class LEDTest extends RepeatingPooledSubsystem {

    private final BlinkinLEDController led;
    private int idx;

    LEDTest(int pwmPort) {
        super (3, TimeUnit.SECONDS);
        led = new BlinkinLEDController(pwmPort);
        idx = 0;
    }

    public void  task(){
        this.led.setLEDPattern(Arrays.asList(Pattern.values()).get(idx));
        if (idx == Pattern.values().length) { idx = 0; };
        idx += 1;
    }

    @Override
    public void defineResources() {
    }

}
