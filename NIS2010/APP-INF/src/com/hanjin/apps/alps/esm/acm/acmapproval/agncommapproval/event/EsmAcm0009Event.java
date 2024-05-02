/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0009Event.java
*@FileTitle : Commission Agreement Creation_Master
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.09 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.event;

import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalMasterVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommAsaNoVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintMasterVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommVendorVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_ACM_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM YOUNG-OH
 * @see ESM_ACM_0009HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmAcm0009Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AGNCommApprovalVO agnCommApprovalVO = null;

	/** Table Value Object Multi Data 처리 */
	private AGNCommApprovalVO[] agnCommApprovalVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AGNCommApprovalMasterVO agnCommApprovalMasterVO = null;

	/** Table Value Object Multi Data 처리 */
	private AGNCommApprovalMasterVO[] agnCommApprovalMasterVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AGNCommApprovalDetailVO agnCommApprovalDetailVO = null;

	/** Table Value Object Multi Data 처리 */
	private AGNCommApprovalDetailVO[] agnCommApprovalDetailVOs = null;

	//////////RD Print
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AGNCommInfoPrintMasterVO agnCommInfoPrintMasterVO = null;

	/** Table Value Object Multi Data 처리 */
	private AGNCommInfoPrintMasterVO[] agnCommInfoPrintMasterVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AGNCommInfoPrintDetailVO agnCommInfoPrintDetailVO = null;

	/** Table Value Object Multi Data 처리 */
	private AGNCommInfoPrintDetailVO[] agnCommInfoPrintDetailVOs = null;

	//////////ASA NO
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AGNCommAsaNoVO agnCommAsaNoVO = null;

	/** Table Value Object Multi Data 처리 */
	private AGNCommAsaNoVO[] agnCommAsaNoVOs = null;

	//////////VendorInfo
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AGNCommVendorVO agnCommVendorVO = null;

	/** Table Value Object Multi Data 처리 */
	private AGNCommVendorVO[] agnCommVendorVOs = null;

	public EsmAcm0009Event() {}

	public AGNCommApprovalVO getAgnCommApprovalVO() {
		return agnCommApprovalVO;
	}

	public void setAgnCommApprovalVO(AGNCommApprovalVO agnCommApprovalVO) {
		this.agnCommApprovalVO = agnCommApprovalVO;
	}

	public AGNCommApprovalVO[] getAgnCommApprovalVOs() {
		return agnCommApprovalVOs;
	}

	public void setAgnCommApprovalVOs(AGNCommApprovalVO[] agnCommApprovalVOs) {
		this.agnCommApprovalVOs = agnCommApprovalVOs;
	}

	public AGNCommApprovalMasterVO getAgnCommApprovalMasterVO() {
		return agnCommApprovalMasterVO;
	}

	public void setAgnCommApprovalMasterVO(
			AGNCommApprovalMasterVO agnCommApprovalMasterVO) {
		this.agnCommApprovalMasterVO = agnCommApprovalMasterVO;
	}

	public AGNCommApprovalMasterVO[] getAgnCommApprovalMasterVOs() {
		return agnCommApprovalMasterVOs;
	}

	public void setAgnCommApprovalMasterVOs(
			AGNCommApprovalMasterVO[] agnCommApprovalMasterVOs) {
		this.agnCommApprovalMasterVOs = agnCommApprovalMasterVOs;
	}

	public AGNCommApprovalDetailVO getAgnCommApprovalDetailVO() {
		return agnCommApprovalDetailVO;
	}

	public void setAgnCommApprovalDetailVO(
			AGNCommApprovalDetailVO agnCommApprovalDetailVO) {
		this.agnCommApprovalDetailVO = agnCommApprovalDetailVO;
	}

	public AGNCommApprovalDetailVO[] getAgnCommApprovalDetailVOs() {
		return agnCommApprovalDetailVOs;
	}

	public void setAgnCommApprovalDetailVOs(
			AGNCommApprovalDetailVO[] agnCommApprovalDetailVOs) {
		this.agnCommApprovalDetailVOs = agnCommApprovalDetailVOs;
	}

	public AGNCommInfoPrintMasterVO getAgnCommInfoPrintMasterVO() {
		return agnCommInfoPrintMasterVO;
	}

	public void setAgnCommInfoPrintMasterVO(
			AGNCommInfoPrintMasterVO agnCommInfoPrintMasterVO) {
		this.agnCommInfoPrintMasterVO = agnCommInfoPrintMasterVO;
	}

	public AGNCommInfoPrintMasterVO[] getAgnCommInfoPrintMasterVOs() {
		return agnCommInfoPrintMasterVOs;
	}

	public void setAgnCommInfoPrintMasterVOs(
			AGNCommInfoPrintMasterVO[] agnCommInfoPrintMasterVOs) {
		this.agnCommInfoPrintMasterVOs = agnCommInfoPrintMasterVOs;
	}

	public AGNCommInfoPrintDetailVO getAgnCommInfoPrintDetailVO() {
		return agnCommInfoPrintDetailVO;
	}

	public void setAgnCommInfoPrintDetailVO(
			AGNCommInfoPrintDetailVO agnCommInfoPrintDetailVO) {
		this.agnCommInfoPrintDetailVO = agnCommInfoPrintDetailVO;
	}

	public AGNCommInfoPrintDetailVO[] getAgnCommInfoPrintDetailVOs() {
		return agnCommInfoPrintDetailVOs;
	}

	public void setAgnCommInfoPrintDetailVOs(
			AGNCommInfoPrintDetailVO[] agnCommInfoPrintDetailVOs) {
		this.agnCommInfoPrintDetailVOs = agnCommInfoPrintDetailVOs;
	}

	public AGNCommAsaNoVO getAgnCommAsaNoVO() {
		return agnCommAsaNoVO;
	}

	public void setAgnCommAsaNoVO(AGNCommAsaNoVO agnCommAsaNoVO) {
		this.agnCommAsaNoVO = agnCommAsaNoVO;
	}

	public AGNCommAsaNoVO[] getAgnCommAsaNoVOs() {
		return agnCommAsaNoVOs;
	}

	public void setAgnCommAsaNoVOs(AGNCommAsaNoVO[] agnCommAsaNoVOs) {
		this.agnCommAsaNoVOs = agnCommAsaNoVOs;
	}

	public AGNCommVendorVO getAgnCommVendorVO() {
		return agnCommVendorVO;
	}

	public void setAgnCommVendorVO(AGNCommVendorVO agnCommVendorVO) {
		this.agnCommVendorVO = agnCommVendorVO;
	}

	public AGNCommVendorVO[] getAgnCommVendorVOs() {
		return agnCommVendorVOs;
	}

	public void setAgnCommVendorVOs(AGNCommVendorVO[] agnCommVendorVOs) {
		this.agnCommVendorVOs = agnCommVendorVOs;
	}

}