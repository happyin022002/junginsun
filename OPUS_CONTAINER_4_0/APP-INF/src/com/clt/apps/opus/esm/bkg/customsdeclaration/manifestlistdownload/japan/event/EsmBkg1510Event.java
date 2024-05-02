/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmBkg1510Event.java
*@FileTitle : EsmBkg1510Event
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.08
*@LastModifier :
*@LastVersion : 1.0
* 2014.10.08
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.ApprovalCstmsCdVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1510에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1510HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_1510HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1510Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ApprovalCstmsCdVO approvalCstmsCdVO = null;

	public EsmBkg1510Event() {}

	public ApprovalCstmsCdVO getApprovalCstmsCdVO() {
		return approvalCstmsCdVO;
	}

	public void setApprovalCstmsCdVO(ApprovalCstmsCdVO approvalCstmsCdVO) {
		this.approvalCstmsCdVO = approvalCstmsCdVO;
	}

}
