package frc.robot;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import ca.team3161.lib.robot.subsystem.RepeatingPooledSubsystem;
import ca.team3161.lib.robot.BlinkinLEDController;
import ca.team3161.lib.robot.BlinkinLEDController.Pattern;

public class LEDTest extends RepeatingPooledSubsystem {

    private final BlinkinLEDController led;
    private int idx;
    private int frames;

    LEDTest(int pwmPort) {
        super (20, TimeUnit.MILLISECONDS);
        led = new BlinkinLEDController(pwmPort);
        idx = 0;
	frames = 0;
    }

    public void task(){
	
        this.led.setLEDPattern(Arrays.asList(Pattern.values()).get(idx));
	frames += 1;
	if(frames > 500){
		frames = 0;
		idx += 1;
        	if (idx == Pattern.values().length) { idx = 0; };
	}
    }

    @Override
    public void defineResources() {
    }

}
