/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_079Event.java
*@FileTitle : Terminal invoice CSR Creation -계산서
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-28
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-12-28 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.vo.CARIssueTransferSlipManageCommonVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ApInvHdrVO;


/**
 * ESD_TES_079 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_079HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jongbaemoon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0079Event extends EventSupport {
	
	private ApInvHdrVO apInvHdrVO	= null;
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
		cARIssueTransferSlipManageCommonVO = issueTransferSlipManageCommonVO;
	}
	
//	/** ap_inv_hdr Table  Value Object */
//	private AP_INV_HDR ap_inv_hdr = null;
//
//	/** ap_inv_hdrs Multi Action을 위한 Collection */
//	private Collection ap_inv_hdrs = null;
	
	

}
