/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0013Event.java
*@FileTitle : Returned CSR Reprocess
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.26 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.event;

import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.ReturnCSRDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.ReturnCSRMasterVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_ACM_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0013HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmAcm0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReturnCSRMasterVO returnCSRMasterVO = null;

	/** Table Value Object Multi Data 처리 */
	private ReturnCSRMasterVO[] returnCSRMasterVOs = null;

	/** Table Value Object Multi Data 처리 */
	private ReturnCSRDetailVO[] returnCSRDetailVOs = null;

	public EsmAcm0013Event() {}

	public ReturnCSRMasterVO getReturnCSRMasterVO() {
		return returnCSRMasterVO;
	}

	public void setReturnCSRMasterVO(ReturnCSRMasterVO returnCSRMasterVO) {
		this.returnCSRMasterVO = returnCSRMasterVO;
	}

	public ReturnCSRMasterVO[] getReturnCSRMasterVOs() {
		return returnCSRMasterVOs;
	}

	public void setReturnCSRMasterVOs(ReturnCSRMasterVO[] returnCSRMasterVOs) {
		this.returnCSRMasterVOs = returnCSRMasterVOs;
	}

	public ReturnCSRDetailVO[] getReturnCSRDetailVOs() {
		return returnCSRDetailVOs;
	}

	public void setReturnCSRDetailVOs(ReturnCSRDetailVO[] returnCSRDetailVOs) {
		this.returnCSRDetailVOs = returnCSRDetailVOs;
	}

}