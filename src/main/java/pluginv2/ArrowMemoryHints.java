package pluginv2;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.apache.arrow.memory.DefaultAllocationManagerOption;
import org.apache.arrow.memory.netty.NettyAllocationManager;

@Configuration
public class ArrowMemoryHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.reflection().registerType(
            DefaultAllocationManagerOption.class,
            builder -> builder.withMembers()
        );
        hints.reflection().registerType(
            NettyAllocationManager.class,
            builder -> builder.withMembers()
        );
    }
}

