import org.glassfish.hk2.utilities.binding.AbstractBinder;

import filiponegrao.twitter.LifecycleManager;
import filiponegrao.twitter.TweetLifecycleManager;

import javax.inject.Singleton;

public class InjectionBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(TweetLifecycleManager.class)
                .to(LifecycleManager.class)
                .in(Singleton.class);
    }
}