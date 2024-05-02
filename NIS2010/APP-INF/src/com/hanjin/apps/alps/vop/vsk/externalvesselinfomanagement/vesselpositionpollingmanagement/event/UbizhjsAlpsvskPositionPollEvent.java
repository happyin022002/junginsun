/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UbizhjsAlpsvskPositionPollingEvent.java
*@FileTitle : EDI from WNI 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.20
*@LastModifier : LIM YE-JI
*@LastVersion : 1.0
* 2014.05.20 LIM YE-JI
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.event;



import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * Receive from EDI MQ<br>
 * @author LIM YE-JI
 * @see 
 * @since J2EE 1.6
 */
public class UbizhjsAlpsvskPositionPollEvent extends EventSupport{

	private static final long serialVersionUID = 1L;
	public String flatFile = null;

	public String getFlatFile() {
		return flatFile;
	}

	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}

}
