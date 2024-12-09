package pluginv2;

import org.apache.arrow.memory.netty.NettyAllocationManager;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;

// TODO: remove - this was an attempt to fix the issue with Arrow memory allocation
// by creating a RootAllocator and NettyAllocationManager
// seeems just setting the env var ARROW_MEMORY_ALLOCATION=true is enough
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
}

