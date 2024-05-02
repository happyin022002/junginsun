/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTes0078Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-10-30 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event;

import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.vo.CARIssueTransferSlipManageCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ApInvHdrVO;
import com.clt.syscommon.common.table.ApTaxVO;

/**
 * ESD_TES_078 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_078HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jongbaemoon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0078Event extends EventSupport {
	
	private ApInvHdrVO 		apInvHdrVO 	= null;
	private ApTaxVO			apTaxVO		= null;
	private CARIssueTransferSlipManageCommonVO cARIssueTransferSlipManageCommonVO = null;
	
	/**
	 * @return the apInvHdrVO
	 */
	public ApInvHdrVO getApInvHdrVO() {
		return apInvHdrVO;
	}
	/**
	 * @param apInvHdrVO the apInvHdrVO to set
	 */
	public void setApInvHdrVO(ApInvHdrVO apInvHdrVO) {
		this.apInvHdrVO = apInvHdrVO;
	}
	/**
	 * @return the cARIssueTransferSlipManageCommonVO
	 */
	public CARIssueTransferSlipManageCommonVO getCARIssueTransferSlipManageCommonVO() {
		return cARIssueTransferSlipManageCommonVO;
	}
	/**
	 * @param issueTransferSlipManageCommonVO the cARIssueTransferSlipManageCommonVO to set
	 */
	public void setCARIssueTransferSlipManageCommonVO(
			CARIssueTransferSlipManageCommonVO issueTransferSlipManageCommonVO) {
		this.cARIssueTransferSlipManageCommonVO = issueTransferSlipManageCommonVO;
	}
	/**
	 * @return the apTaxVO
	 */
	public ApTaxVO getApTaxVO() {
		return apTaxVO;
	}
	/**
	 * @param apTaxVO the apTaxVO to set
	 */
	public void setApTaxVO(ApTaxVO apTaxVO) {
		this.apTaxVO = apTaxVO;
	}

}