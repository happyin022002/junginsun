/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0058Event.java
*@FileTitle : 실행 계획 Feedback 기준 설정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	jungran yang		2006-10-16		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.16		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.16
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrRepoExePlnFbExptVO;
import com.hanjin.syscommon.common.table.EqrRepoExePlnFbVO;


/**
 * EES_EQR_0058 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0058HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0058HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0058Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Multi Data 처리 */
	public EqrRepoExePlnFbVO[] eqrRepoExePlnFbVOS = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrRepoExePlnFbExptVO[] eqrRepoExePlnFbExptVOS = null;
	
	private String tpszall = null;

	public EesEqr0058Event(){}

	/**
	 * @return the tpszall
	 */
	public String getTpszall() {
		return tpszall;
	}

	/**
	 * @param tpszall the tpszall to set
	 */
	public void setTpszall(String tpszall) {
		this.tpszall = tpszall;
	}

	/**
	 * @return the eqrRepoExePlnFbExptVOS
	 */
	public EqrRepoExePlnFbExptVO[] getEqrRepoExePlnFbExptVOS() {
		return eqrRepoExePlnFbExptVOS;
	}

	/**
	 * @param eqrRepoExePlnFbExptVOS the eqrRepoExePlnFbExptVOS to set
	 */
	public void setEqrRepoExePlnFbExptVOS(
			EqrRepoExePlnFbExptVO[] eqrRepoExePlnFbExptVOS) {
		this.eqrRepoExePlnFbExptVOS = eqrRepoExePlnFbExptVOS;
	}

	/**
	 * @return the eqrRepoExePlnFbVOS
	 */
	public EqrRepoExePlnFbVO[] getEqrRepoExePlnFbVOS() {
		return eqrRepoExePlnFbVOS;
	}

	/**
	 * @param eqrRepoExePlnFbVOS the eqrRepoExePlnFbVOS to set
	 */
	public void setEqrRepoExePlnFbVOS(EqrRepoExePlnFbVO[] eqrRepoExePlnFbVOS) {
		this.eqrRepoExePlnFbVOS = eqrRepoExePlnFbVOS;
	}

}