/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0050Event.java
*@FileTitle : engine monitor
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.08.17 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.event;

import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * EES_EQR_0050 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0050HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0050HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0050Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	// 화면에서의 조건값을 받기
	private String runIdNo = null;
	
	private String percentage = null;
	
	private String cancel    = null;
	
	public EesEqr0050Event(){}
	
	/**
	 * @return the runIdNo
	 */
	public String getRunIdNo() {
		return runIdNo;
	}

	/**
	 * @param runIdNo the runIdNo to set
	 */
	public void setRunIdNo(String runIdNo) {
		this.runIdNo = runIdNo;
	}

	/**
	 * @return the percentage
	 */
	public String getPercentage() {
		return percentage;
	}

	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	/**
	 * @return the cancel
	 */
	public String getCancel() {
		return cancel;
	}

	/**
	 * @param cancel the cancel to set
	 */
	public void setCancel(String cancel) {
		this.cancel = cancel;
	}

	
}