package factory_method_pattern;

import java.util.Arrays;
import java.util.List;

public class HawaiiAdGenerator implements IRegionalAdGenerator
{
    @Override
    public List<Advertisement> getApropriateAds()
    {
        return Arrays.asList(new Advertisement("McDonald's is better here!"),
                new Advertisement("Blue oceans and bright beaches!"),
                new Advertisement("Aloha!"));

    }
}
