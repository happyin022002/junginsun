/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0014Event.java
*@FileTitle : Leased Container Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.07.07 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.ApprovalListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.LeasedCntrVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.MstEtcVO;
import com.clt.framework.support.layer.event.EventSupport;
/**
 * EES_MST_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Sun
 * @see EES_MST_0014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MstEtcVO mstEtcVO = null;
	
	private AgreementVO agreementVO = null;	

	/** Approval List 검색 리스트 **/
	private ApprovalListVO[] approvalListVOs = null;
	
	private AgreementVO[] agreementVOs = null;
	
	/** LeasedCntr 검색 리스트 **/
	private LeasedCntrVO[] leasedCntrVOs = null;
	
	private LeasedCntrVO leasedCntrVO = null;

	/**
	 * @return the leasedCntrVOs
	 */
	public LeasedCntrVO[] getLeasedCntrVOs() {
		LeasedCntrVO[] tmpVOs = null;
		  if (this.leasedCntrVOs != null) {
		   tmpVOs = new LeasedCntrVO[leasedCntrVOs.length];
		   System.arraycopy(leasedCntrVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}

	/**
	 * @param leasedCntrVOs the leasedCntrVOs to set
	 */
	public void setLeasedCntrVOs(LeasedCntrVO[] leasedCntrVOs) {
		  if (leasedCntrVOs != null) {
			  LeasedCntrVO[] tmpVOs = new LeasedCntrVO[leasedCntrVOs.length];
			   System.arraycopy(leasedCntrVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.leasedCntrVOs = tmpVOs;
			  }

	}

	/**
	 * @return the leasedCntrVO
	 */
	public LeasedCntrVO getLeasedCntrVO() {
		return leasedCntrVO;
	}

	/**
	 * @param leasedCntrVO the leasedCntrVO to set
	 */
	public void setLeasedCntrVO(LeasedCntrVO leasedCntrVO) {
		this.leasedCntrVO = leasedCntrVO;
	}

	/**
	 * @return the agreementVO
	 */
	public AgreementVO getAgreementVO() {
		return agreementVO;
	}

	/**
	 * @param agreementVO the agreementVO to set
	 */
	public void setAgreementVO(AgreementVO agreementVO) {
		this.agreementVO = agreementVO;
	}

	/**
	 * @return the agreementVOs
	 */
	public AgreementVO[] getAgreementVOs() {
		AgreementVO[] tmpVOs = null;
		  if (this.agreementVOs != null) {
		   tmpVOs = new AgreementVO[agreementVOs.length];
		   System.arraycopy(agreementVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}

	/**
	 * @param agreementVOs the agreementVOs to set
	 */
	public void setAgreementVOs(AgreementVO[] agreementVOs) {
		  if (agreementVOs != null) {
			  AgreementVO[] tmpVOs = new AgreementVO[agreementVOs.length];
			   System.arraycopy(agreementVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.agreementVOs = tmpVOs;
			  }

	}
	
	/**
	 * @return the mstEtcVO
	 */
	public MstEtcVO getMstEtcVO() {
		return mstEtcVO;
	}

	/**
	 * @return the approvalListVOs
	 */
	public ApprovalListVO[] getApprovalListVOs() {
		ApprovalListVO[] tmpVOs = null;
		  if (this.approvalListVOs != null) {
		   tmpVOs = new ApprovalListVO[approvalListVOs.length];
		   System.arraycopy(approvalListVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}

	/**
	 * @param approvalListVOs the approvalListVOs to set
	 */
	public void setApprovalListVOs(ApprovalListVO[] approvalListVOs) {
		  if (approvalListVOs != null) {
			  ApprovalListVO[] tmpVOs = new ApprovalListVO[approvalListVOs.length];
			   System.arraycopy(approvalListVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.approvalListVOs = tmpVOs;
			  }

	}

	/**
	 * @param mstEtcVO the mstEtcVO to set
	 */
	public void setMstEtcVO(MstEtcVO mstEtcVO) {
		this.mstEtcVO = mstEtcVO;
	}
}