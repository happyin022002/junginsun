/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0105Event.java
*@FileTitle : data edit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.03 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0105 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0105HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0105HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0105Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String status	= "";
	
	private String location = "";


	public EesEqr0105Event(){}
	

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

}