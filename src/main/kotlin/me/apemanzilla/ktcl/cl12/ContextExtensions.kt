package me.apemanzilla.ktcl.cl12

import me.apemanzilla.ktcl.CLContext
import me.apemanzilla.ktcl.CLException
import me.apemanzilla.ktcl.CLImage
import me.apemanzilla.ktcl.cl10.KernelAccess.ReadWrite
import me.apemanzilla.ktcl.cl10.MemCacheType
import me.apemanzilla.ktcl.cl10.MemFlag
import org.lwjgl.opencl.CL12
import org.lwjgl.opencl.CLImageDesc
import org.lwjgl.opencl.CLImageFormat
import java.nio.ByteBuffer

fun CLContext.createImage(data: ByteBuffer, flags: MemFlag = ReadWrite) = CLException.checkErr { e ->
	val format = CLImageFormat.create()
	val desc = CLImageDesc.create()
	CLImage(CL12.clCreateImage(handle, flags.mask.toLong(), format, desc, data, e), false)
}
