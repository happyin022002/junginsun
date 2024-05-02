/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0132Event.java
*@FileTitle : Search Send History email / FAX
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.21 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0132 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0132HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChungEunHo
 * @see EES_EQR_0132HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0132Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String target = "";
	private String jobCd = "";
	private String userId = "";

	public EesEqr0132Event(){}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getJobCd() {
		return jobCd;
	}

	public void setJobCd(String jobCd) {
		this.jobCd = jobCd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}