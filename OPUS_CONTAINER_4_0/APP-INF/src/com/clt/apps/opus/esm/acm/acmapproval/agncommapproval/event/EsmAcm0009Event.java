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
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommAsaNoVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommVendorVO;
import com.clt.framework.support.layer.event.EventSupport;

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
		AGNCommApprovalVO[] rtnVOs = null;
		if (this.agnCommApprovalVOs != null) {
			rtnVOs = Arrays.copyOf(agnCommApprovalVOs, agnCommApprovalVOs.length);
		}
		return rtnVOs;
	}

	public void setAgnCommApprovalVOs(AGNCommApprovalVO[] agnCommApprovalVOs) {
		if(agnCommApprovalVOs != null){
			AGNCommApprovalVO[] tmpVOs = Arrays.copyOf(agnCommApprovalVOs, agnCommApprovalVOs.length);
			this.agnCommApprovalVOs  = tmpVOs;
		}
	}

	public AGNCommApprovalMasterVO getAgnCommApprovalMasterVO() {
		return agnCommApprovalMasterVO;
	}

	public void setAgnCommApprovalMasterVO(
			AGNCommApprovalMasterVO agnCommApprovalMasterVO) {
		this.agnCommApprovalMasterVO = agnCommApprovalMasterVO;
	}

	public AGNCommApprovalMasterVO[] getAgnCommApprovalMasterVOs() {
		AGNCommApprovalMasterVO[] rtnVOs = null;
		if (this.agnCommApprovalMasterVOs != null) {
			rtnVOs = Arrays.copyOf(agnCommApprovalMasterVOs, agnCommApprovalMasterVOs.length);
		}
		return rtnVOs;
	}

	public void setAgnCommApprovalMasterVOs(
			AGNCommApprovalMasterVO[] agnCommApprovalMasterVOs) {
		if(agnCommApprovalMasterVOs != null){
			AGNCommApprovalMasterVO[] tmpVOs = Arrays.copyOf(agnCommApprovalMasterVOs, agnCommApprovalMasterVOs.length);
			this.agnCommApprovalMasterVOs  = tmpVOs;
		}
	}

	public AGNCommApprovalDetailVO getAgnCommApprovalDetailVO() {
		return agnCommApprovalDetailVO;
	}

	public void setAgnCommApprovalDetailVO(
			AGNCommApprovalDetailVO agnCommApprovalDetailVO) {
		this.agnCommApprovalDetailVO = agnCommApprovalDetailVO;
	}

	public AGNCommApprovalDetailVO[] getAgnCommApprovalDetailVOs() {
		AGNCommApprovalDetailVO[] rtnVOs = null;
		if (this.agnCommApprovalDetailVOs != null) {
			rtnVOs = Arrays.copyOf(agnCommApprovalDetailVOs, agnCommApprovalDetailVOs.length);
		}
		return rtnVOs;
	}

	public void setAgnCommApprovalDetailVOs(
			AGNCommApprovalDetailVO[] agnCommApprovalDetailVOs) {
		if(agnCommApprovalDetailVOs != null){
			AGNCommApprovalDetailVO[] tmpVOs = Arrays.copyOf(agnCommApprovalDetailVOs, agnCommApprovalDetailVOs.length);
			this.agnCommApprovalDetailVOs  = tmpVOs;
		}
	}

	public AGNCommInfoPrintMasterVO getAgnCommInfoPrintMasterVO() {
		return agnCommInfoPrintMasterVO;
	}

	public void setAgnCommInfoPrintMasterVO(
			AGNCommInfoPrintMasterVO agnCommInfoPrintMasterVO) {
		this.agnCommInfoPrintMasterVO = agnCommInfoPrintMasterVO;
	}

	public AGNCommInfoPrintMasterVO[] getAgnCommInfoPrintMasterVOs() {
		AGNCommInfoPrintMasterVO[] rtnVOs = null;
		if (this.agnCommInfoPrintMasterVOs != null) {
			rtnVOs = Arrays.copyOf(agnCommInfoPrintMasterVOs, agnCommInfoPrintMasterVOs.length);
		}
		return rtnVOs;
	}

	public void setAgnCommInfoPrintMasterVOs(
			AGNCommInfoPrintMasterVO[] agnCommInfoPrintMasterVOs) {
		if(agnCommInfoPrintMasterVOs != null){
			AGNCommInfoPrintMasterVO[] tmpVOs = Arrays.copyOf(agnCommInfoPrintMasterVOs, agnCommInfoPrintMasterVOs.length);
			this.agnCommInfoPrintMasterVOs  = tmpVOs;
		}
	}

	public AGNCommInfoPrintDetailVO getAgnCommInfoPrintDetailVO() {
		return agnCommInfoPrintDetailVO;
	}

	public void setAgnCommInfoPrintDetailVO(
			AGNCommInfoPrintDetailVO agnCommInfoPrintDetailVO) {
		this.agnCommInfoPrintDetailVO = agnCommInfoPrintDetailVO;
	}

	public AGNCommInfoPrintDetailVO[] getAgnCommInfoPrintDetailVOs() {
		AGNCommInfoPrintDetailVO[] rtnVOs = null;
		if (this.agnCommInfoPrintDetailVOs != null) {
			rtnVOs = Arrays.copyOf(agnCommInfoPrintDetailVOs, agnCommInfoPrintDetailVOs.length);
		}
		return rtnVOs;
	}

	public void setAgnCommInfoPrintDetailVOs(
			AGNCommInfoPrintDetailVO[] agnCommInfoPrintDetailVOs) {
		if(agnCommInfoPrintDetailVOs != null){
			AGNCommInfoPrintDetailVO[] tmpVOs = Arrays.copyOf(agnCommInfoPrintDetailVOs, agnCommInfoPrintDetailVOs.length);
			this.agnCommInfoPrintDetailVOs  = tmpVOs;
		}
	}

	public AGNCommAsaNoVO getAgnCommAsaNoVO() {
		return agnCommAsaNoVO;
	}

	public void setAgnCommAsaNoVO(AGNCommAsaNoVO agnCommAsaNoVO) {
		this.agnCommAsaNoVO = agnCommAsaNoVO;
	}

	public AGNCommAsaNoVO[] getAgnCommAsaNoVOs() {
		AGNCommAsaNoVO[] rtnVOs = null;
		if (this.agnCommAsaNoVOs != null) {
			rtnVOs = Arrays.copyOf(agnCommAsaNoVOs, agnCommAsaNoVOs.length);
		}
		return rtnVOs;
	}

	public void setAgnCommAsaNoVOs(AGNCommAsaNoVO[] agnCommAsaNoVOs) {
		if(agnCommAsaNoVOs != null){
			AGNCommAsaNoVO[] tmpVOs = Arrays.copyOf(agnCommAsaNoVOs, agnCommAsaNoVOs.length);
			this.agnCommAsaNoVOs  = tmpVOs;
		}
	}

	public AGNCommVendorVO getAgnCommVendorVO() {
		return agnCommVendorVO;
	}

	public void setAgnCommVendorVO(AGNCommVendorVO agnCommVendorVO) {
		this.agnCommVendorVO = agnCommVendorVO;
	}

	public AGNCommVendorVO[] getAgnCommVendorVOs() {
		AGNCommVendorVO[] rtnVOs = null;
		if (this.agnCommVendorVOs != null) {
			rtnVOs = Arrays.copyOf(agnCommVendorVOs, agnCommVendorVOs.length);
		}
		return rtnVOs;
	}

	public void setAgnCommVendorVOs(AGNCommVendorVO[] agnCommVendorVOs) {
		if(agnCommVendorVOs != null){
			AGNCommVendorVO[] tmpVOs = Arrays.copyOf(agnCommVendorVOs, agnCommVendorVOs.length);
			this.agnCommVendorVOs  = tmpVOs;
		}
	}

}