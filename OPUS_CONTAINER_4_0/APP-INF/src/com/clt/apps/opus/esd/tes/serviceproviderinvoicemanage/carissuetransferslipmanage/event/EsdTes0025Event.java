/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTes0025Event.java
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

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.vo.CARIssueTransferSlipManageCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ApInvHdrVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;

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
		TesTmlSoHdrVO[] rtnVOs = null;
		if (this.tesTmlSoHdrVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoHdrVOs, tesTmlSoHdrVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesTmlSoHdrVOs the tesTmlSoHdrVOs to set
	 */
	public void setTesTmlSoHdrVOs(TesTmlSoHdrVO[] tesTmlSoHdrVOs){
		if(tesTmlSoHdrVOs != null){
			TesTmlSoHdrVO[] tmpVOs = Arrays.copyOf(tesTmlSoHdrVOs, tesTmlSoHdrVOs.length);
			this.tesTmlSoHdrVOs = tmpVOs;
		}
	}

	/**
	 * @return the cARIssueTransferSlipManageCommonVOs
	 */
	public CARIssueTransferSlipManageCommonVO[] getCARIssueTransferSlipManageCommonVOs() {
		CARIssueTransferSlipManageCommonVO[] rtnVOs = null;
		if (this.cARIssueTransferSlipManageCommonVOs != null) {
			rtnVOs = Arrays.copyOf(cARIssueTransferSlipManageCommonVOs, cARIssueTransferSlipManageCommonVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param issueTransferSlipManageCommonVOs the cARIssueTransferSlipManageCommonVOs to set
	 */
	public void setCARIssueTransferSlipManageCommonVOs(CARIssueTransferSlipManageCommonVO[] cARIssueTransferSlipManageCommonVOs) {
		if(cARIssueTransferSlipManageCommonVOs != null){
			CARIssueTransferSlipManageCommonVO[] tmpVOs = Arrays.copyOf(cARIssueTransferSlipManageCommonVOs, cARIssueTransferSlipManageCommonVOs.length);
			this.cARIssueTransferSlipManageCommonVOs = tmpVOs;
		}
	}

//	private TES_TML_SO_HDR tes_tml_so_hdr = null;
//
//	private Collection tes_tml_so_hdrs = null;
//		
//	private HashMap param_map = null;
//	
//	private String[] chks = null;

}