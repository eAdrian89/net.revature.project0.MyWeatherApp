import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;

public class Arguments  extends OptionsBase {

    @Option(
            name = "tomcat",
            abbrev = 't',
            help = "Open Tomcat Server.",
            category = "startup",
            defaultValue = "true"
    )
    public String tomcat;


}
