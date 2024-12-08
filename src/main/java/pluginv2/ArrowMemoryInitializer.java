package pluginv2;

import org.apache.arrow.memory.netty.NettyAllocationManager;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.DefaultAllocationManagerOption;
import org.apache.arrow.memory.RootAllocator;

@RegisterReflectionForBinding(NettyAllocationManager.class)
public class ArrowMemoryInitializer {
    public static BufferAllocator initialize() {
        // Create a RootAllocator for managing memory
        System.out.println("Creating RootAllocator");
        BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE);  // Adjust size as needed
        NettyAllocationManager.FACTORY.create(allocator, Long.MAX_VALUE);
        System.out.println("Created RootAllocator");
        return allocator;
    }

    // public static void initializeAllocator() {
    //     DefaultAllocationManagerOption.FACTORY = NettyAllocationManager.FACTORY;
    //     // Ensure that the DefaultAllocationManagerOption is available
    //     if (DefaultAllocationManagerOption.getDefaultAllocationManagerFactory() == null) {
    //         // Use NettyAllocationManager explicitly or set a custom memory manager
    //         DefaultAllocationManagerOption.setDefaultAllocationManagerFactory(new NettyAllocationManager.Factory());
    //     }
    // }
}

