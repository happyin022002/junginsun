/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0030Event.java
*@FileTitle : EsmAcm0030Event
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.03 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.event;

import com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalMasterVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalPrintDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalPrintMasterVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM YOUNG-OH
 * @see ESM_ACM_0030HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	//Master
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO = null;

	/** Table Value Object Multi Data 처리 */
	private FFCmpnApprovalMasterVO[] ffCmpnApprovalMasterVOs = null;
	
	//Detail
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FFCmpnApprovalDetailVO ffCmpnApprovalDetailVO = null;

	/** Table Value Object Multi Data 처리 */
	private FFCmpnApprovalDetailVO[] ffCmpnApprovalDetailVOs = null;
	
	///////////////RD Print
	//Master
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FFCmpnApprovalPrintMasterVO ffCmpnApprovalPrintMasterVO = null;

	/** Table Value Object Multi Data 처리 */
	private FFCmpnApprovalPrintMasterVO[] ffCmpnApprovalPrintMasterVOs = null;
	
	//Detail
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FFCmpnApprovalPrintDetailVO ffCmpnApprovalPrintDetailVO = null;

	/** Table Value Object Multi Data 처리 */
	private FFCmpnApprovalPrintDetailVO[] ffCmpnApprovalPrintDetailVOs = null;
	
	
	public FFCmpnApprovalPrintMasterVO getFfCmpnApprovalPrintMasterVO() {
		return ffCmpnApprovalPrintMasterVO;
	}

	public void setFfCmpnApprovalPrintMasterVO(
			FFCmpnApprovalPrintMasterVO ffCmpnApprovalPrintMasterVO) {
		this.ffCmpnApprovalPrintMasterVO = ffCmpnApprovalPrintMasterVO;
	}

	public FFCmpnApprovalPrintMasterVO[] getFfCmpnApprovalPrintMasterVOs() {
		return ffCmpnApprovalPrintMasterVOs;
	}

	public void setFfCmpnApprovalPrintMasterVOs(
			FFCmpnApprovalPrintMasterVO[] ffCmpnApprovalPrintMasterVOs) {
		this.ffCmpnApprovalPrintMasterVOs = ffCmpnApprovalPrintMasterVOs;
	}

	public FFCmpnApprovalPrintDetailVO getFfCmpnApprovalPrintDetailVO() {
		return ffCmpnApprovalPrintDetailVO;
	}

	public void setFfCmpnApprovalPrintDetailVO(
			FFCmpnApprovalPrintDetailVO ffCmpnApprovalPrintDetailVO) {
		this.ffCmpnApprovalPrintDetailVO = ffCmpnApprovalPrintDetailVO;
	}

	public FFCmpnApprovalPrintDetailVO[] getFfCmpnApprovalPrintDetailVOs() {
		return ffCmpnApprovalPrintDetailVOs;
	}

	public void setFfCmpnApprovalPrintDetailVOs(
			FFCmpnApprovalPrintDetailVO[] ffCmpnApprovalPrintDetailVOs) {
		this.ffCmpnApprovalPrintDetailVOs = ffCmpnApprovalPrintDetailVOs;
	}

	public EsmAcm0030Event() {}

	public FFCmpnApprovalMasterVO getFfCmpnApprovalMasterVO() {
		return ffCmpnApprovalMasterVO;
	}

	public void setFfCmpnApprovalMasterVO(
			FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO) {
		this.ffCmpnApprovalMasterVO = ffCmpnApprovalMasterVO;
	}

	public FFCmpnApprovalMasterVO[] getFfCmpnApprovalMasterVOs() {
		return ffCmpnApprovalMasterVOs;
	}

	public void setFfCmpnApprovalMasterVOs(
			FFCmpnApprovalMasterVO[] ffCmpnApprovalMasterVOs) {
		this.ffCmpnApprovalMasterVOs = ffCmpnApprovalMasterVOs;
	}

	public FFCmpnApprovalDetailVO getFfCmpnApprovalDetailVO() {
		return ffCmpnApprovalDetailVO;
	}

	public void setFfCmpnApprovalDetailVO(
			FFCmpnApprovalDetailVO ffCmpnApprovalDetailVO) {
		this.ffCmpnApprovalDetailVO = ffCmpnApprovalDetailVO;
	}

	public FFCmpnApprovalDetailVO[] getFfCmpnApprovalDetailVOs() {
		return ffCmpnApprovalDetailVOs;
	}

	public void setFfCmpnApprovalDetailVOs(
			FFCmpnApprovalDetailVO[] ffCmpnApprovalDetailVOs) {
		this.ffCmpnApprovalDetailVOs = ffCmpnApprovalDetailVOs;
	}
	
}