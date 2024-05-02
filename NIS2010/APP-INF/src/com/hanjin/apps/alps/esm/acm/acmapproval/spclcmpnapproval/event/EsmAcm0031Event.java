/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0031Event.java
*@FileTitle : EsmAcm0031Event
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.03 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.event;

import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalMasterVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalPrintDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalPrintMasterVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM YOUNG-OH
 * @see ESM_ACM_0031HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0031Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	//private SPCLCmpnApprovalVO spclCmpnApproval = null;

	//Master
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO = null;

	/** Table Value Object Multi Data 처리 */
	private SPCLCmpnApprovalMasterVO[] spCLCmpnApprovalMasterVOs = null;
	
	//Detail
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SPCLCmpnApprovalDetailVO spCLCmpnApprovalDetailVO = null;

	/** Table Value Object Multi Data 처리 */
	private SPCLCmpnApprovalDetailVO[] spCLCmpnApprovalDetailVOs = null;
	
	///////////////RD Print
	//Master
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SPCLCmpnApprovalPrintMasterVO spCLCmpnApprovalPrintMasterVO = null;

	/** Table Value Object Multi Data 처리 */
	private SPCLCmpnApprovalPrintMasterVO[] spCLCmpnApprovalPrintMasterVOs = null;
	
	//Detail
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SPCLCmpnApprovalPrintDetailVO spCLCmpnApprovalPrintDetailVO = null;

	/** Table Value Object Multi Data 처리 */
	private SPCLCmpnApprovalPrintDetailVO[] spCLCmpnApprovalPrintDetailVOs = null;

	public SPCLCmpnApprovalMasterVO getSpCLCmpnApprovalMasterVO() {
		return spCLCmpnApprovalMasterVO;
	}

	public void setSpCLCmpnApprovalMasterVO(
			SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO) {
		this.spCLCmpnApprovalMasterVO = spCLCmpnApprovalMasterVO;
	}

	public SPCLCmpnApprovalMasterVO[] getSpCLCmpnApprovalMasterVOs() {
		return spCLCmpnApprovalMasterVOs;
	}

	public void setSpCLCmpnApprovalMasterVOs(
			SPCLCmpnApprovalMasterVO[] spCLCmpnApprovalMasterVOs) {
		this.spCLCmpnApprovalMasterVOs = spCLCmpnApprovalMasterVOs;
	}

	public SPCLCmpnApprovalDetailVO getSpCLCmpnApprovalDetailVO() {
		return spCLCmpnApprovalDetailVO;
	}

	public void setSpCLCmpnApprovalDetailVO(
			SPCLCmpnApprovalDetailVO spCLCmpnApprovalDetailVO) {
		this.spCLCmpnApprovalDetailVO = spCLCmpnApprovalDetailVO;
	}

	public SPCLCmpnApprovalDetailVO[] getSpCLCmpnApprovalDetailVOs() {
		return spCLCmpnApprovalDetailVOs;
	}

	public void setSpCLCmpnApprovalDetailVOs(
			SPCLCmpnApprovalDetailVO[] spCLCmpnApprovalDetailVOs) {
		this.spCLCmpnApprovalDetailVOs = spCLCmpnApprovalDetailVOs;
	}

	public SPCLCmpnApprovalPrintMasterVO getSpCLCmpnApprovalPrintMasterVO() {
		return spCLCmpnApprovalPrintMasterVO;
	}

	public void setSpCLCmpnApprovalPrintMasterVO(
			SPCLCmpnApprovalPrintMasterVO spCLCmpnApprovalPrintMasterVO) {
		this.spCLCmpnApprovalPrintMasterVO = spCLCmpnApprovalPrintMasterVO;
	}

	public SPCLCmpnApprovalPrintMasterVO[] getSpCLCmpnApprovalPrintMasterVOs() {
		return spCLCmpnApprovalPrintMasterVOs;
	}

	public void setSpCLCmpnApprovalPrintMasterVOs(
			SPCLCmpnApprovalPrintMasterVO[] spCLCmpnApprovalPrintMasterVOs) {
		this.spCLCmpnApprovalPrintMasterVOs = spCLCmpnApprovalPrintMasterVOs;
	}

	public SPCLCmpnApprovalPrintDetailVO getSpCLCmpnApprovalPrintDetailVO() {
		return spCLCmpnApprovalPrintDetailVO;
	}

	public void setSpCLCmpnApprovalPrintDetailVO(
			SPCLCmpnApprovalPrintDetailVO spCLCmpnApprovalPrintDetailVO) {
		this.spCLCmpnApprovalPrintDetailVO = spCLCmpnApprovalPrintDetailVO;
	}

	public SPCLCmpnApprovalPrintDetailVO[] getSpCLCmpnApprovalPrintDetailVOs() {
		return spCLCmpnApprovalPrintDetailVOs;
	}

	public void setSpCLCmpnApprovalPrintDetailVOs(
			SPCLCmpnApprovalPrintDetailVO[] spCLCmpnApprovalPrintDetailVOs) {
		this.spCLCmpnApprovalPrintDetailVOs = spCLCmpnApprovalPrintDetailVOs;
	}
}