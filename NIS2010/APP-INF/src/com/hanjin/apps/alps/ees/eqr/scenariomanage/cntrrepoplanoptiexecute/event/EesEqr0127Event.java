/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0127Event.java
*@FileTitle : Repo Plan Remark Save
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.14 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0127 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0127HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0127HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0127Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String scnrId = null;

	public EesEqr0127Event(){}
	
	public String getScnrId() {
		return scnrId;
	}

	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}

}