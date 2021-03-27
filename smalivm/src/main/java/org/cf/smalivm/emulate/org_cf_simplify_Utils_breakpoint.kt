package org.cf.smalivm.emulate

import org.cf.smalivm2.ExecutionNode
import org.cf.smalivm2.ExecutionState
import org.cf.smalivm2.VirtualMachine2
import org.slf4j.LoggerFactory

internal class org_cf_simplify_Utils_breakpoint : EmulatedMethodCall() {
    override fun execute(state: ExecutionState, callerNode: ExecutionNode, vm: VirtualMachine2) {
        // Add invoke-static {}, Lorg/cf/simplify/Utils;->breakpoint()V, and set an IDE breakpoint here.
        log.trace("For a good time, set a breakpoint here!")
    }

    companion object {
        private val log = LoggerFactory.getLogger(org_cf_simplify_Utils_breakpoint::class.java.simpleName)
    }
}