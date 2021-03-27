package org.cf.smalivm.emulate

import org.cf.smalivm.dex.CommonTypes
import org.cf.smalivm2.ExecutionNode
import org.cf.smalivm2.ExecutionState
import org.cf.smalivm2.VirtualMachine2
import org.slf4j.LoggerFactory

internal class java_lang_Object_getClass : EmulatedMethodCall(), UnknownValuesMethod {
    override fun execute(state: ExecutionState, callerNode: ExecutionNode, vm: VirtualMachine2) {
        val argumentType = state.peekParameter(0)!!.type
        val virtualType = vm.classManager.getVirtualType(argumentType)
        try {
            val value = vm.classLoader.loadClass(virtualType.binaryName)
            state.assignReturnRegister(value, RETURN_TYPE)
        } catch (e: ClassNotFoundException) {
            throw RuntimeException("Class not found: $argumentType", e)
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(java_lang_Object_getClass::class.java.simpleName)
        private const val RETURN_TYPE = CommonTypes.CLASS
    }
}