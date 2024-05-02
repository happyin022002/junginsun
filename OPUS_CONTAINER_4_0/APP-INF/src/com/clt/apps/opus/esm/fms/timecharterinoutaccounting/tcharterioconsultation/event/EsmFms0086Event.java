/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0086Event.java
*@FileTitle : Tax Evidence / Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.03 정윤태
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0086 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0086HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung, Yoon-Tae
 * @see ESM_FMS_0086HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0086Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/* CSR No */
	private String csrNo = "";

	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
}