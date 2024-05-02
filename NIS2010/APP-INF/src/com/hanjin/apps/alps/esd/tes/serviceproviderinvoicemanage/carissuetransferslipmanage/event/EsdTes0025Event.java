/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_025Event.java
*@FileTitle : Transfer Slip 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-02
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2007-01-02 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.vo.CARIssueTransferSlipManageCommonVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ApInvHdrVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0025Event extends EventSupport {
	
	private TesTmlSoHdrVO 		tesTmlSoHdrVO 	= null;
	private ApInvHdrVO			apInvHdrVO		= null;
	private CARIssueTransferSlipManageCommonVO[]	cARIssueTransferSlipManageCommonVOs	= null;
	
	private TesTmlSoHdrVO[] 	tesTmlSoHdrVOs 	= null;
	
	/**
	 * @return the tesTmlSoHdrVO
	 */
	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	/**
	 * @param tesTmlSoHdrVO the tesTmlSoHdrVO to set
	 */
	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}

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
	 * @return the tesTmlSoHdrVOs
	 */
	public TesTmlSoHdrVO[] getTesTmlSoHdrVOs() {
		return tesTmlSoHdrVOs;
	}

	/**
	 * @param tesTmlSoHdrVOs the tesTmlSoHdrVOs to set
	 */
	public void setTesTmlSoHdrVOs(TesTmlSoHdrVO[] tesTmlSoHdrVOs) {
		this.tesTmlSoHdrVOs = tesTmlSoHdrVOs;
	}

	/**
	 * @return the cARIssueTransferSlipManageCommonVOs
	 */
	public CARIssueTransferSlipManageCommonVO[] getCARIssueTransferSlipManageCommonVOs() {
		return cARIssueTransferSlipManageCommonVOs;
	}

	/**
	 * @param issueTransferSlipManageCommonVOs the cARIssueTransferSlipManageCommonVOs to set
	 */
	public void setCARIssueTransferSlipManageCommonVOs(
			CARIssueTransferSlipManageCommonVO[] issueTransferSlipManageCommonVOs) {
		cARIssueTransferSlipManageCommonVOs = issueTransferSlipManageCommonVOs;
	}

//	private TES_TML_SO_HDR tes_tml_so_hdr = null;
//
//	private Collection tes_tml_so_hdrs = null;
//		
//	private HashMap param_map = null;
//	
//	private String[] chks = null;

}
