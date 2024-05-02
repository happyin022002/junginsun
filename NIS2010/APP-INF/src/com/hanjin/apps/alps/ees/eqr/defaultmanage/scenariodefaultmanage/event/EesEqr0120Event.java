/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0120Event.java
*@FileTitle : L/T Off-Hire 정보 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.07.10		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.10
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrLongTermOffhCondVO;


/**
 * EES_EQR_0120 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0120HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0120HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0120Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Multi Data 처리 */
	public EqrLongTermOffhCondVO[] eqrLongTermOffhCondVOs = null;
	
	private String status = null;
	
	private String location = null;
	
	private String tpsztype = null;

	/**
	 * Default Constructor
	 */
	public EesEqr0120Event(){}

	public void setEqrLongTermOffhCondVOS(EqrLongTermOffhCondVO[] eqrLongTermOffhCondVOs){
		this. eqrLongTermOffhCondVOs = eqrLongTermOffhCondVOs;
	}

	public EqrLongTermOffhCondVO[] getEqrLongTermOffhCondVOS(){
		return eqrLongTermOffhCondVOs;
	}

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

	/**
	 * @return the tpsztype
	 */
	public String getTpsztype() {
		return tpsztype;
	}

	/**
	 * @param tpsztype the tpsztype to set
	 */
	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}

}