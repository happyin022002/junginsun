/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1080Event.java
*@FileTitle : Audit by Hanger Installation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.22 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByHangerInstallationListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh, Kim
 * @see ESM_BKG_1080HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1080Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchAuditByHangerInstallationListVO rsltSearchAuditByHangerInstallationListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltSearchAuditByHangerInstallationListVO[] rsltSearchAuditByHangerInstallationListVOs = null;

	
	public void setRsltSearchAuditByHangerInstallationListVO(RsltSearchAuditByHangerInstallationListVO rsltSearchAuditByHangerInstallationListVO){
		this. rsltSearchAuditByHangerInstallationListVO = rsltSearchAuditByHangerInstallationListVO;
	}

	public RsltSearchAuditByHangerInstallationListVO getRsltSearchAuditByHangerInstallationListVO(){
		return rsltSearchAuditByHangerInstallationListVO;
	}

	public RsltSearchAuditByHangerInstallationListVO[] getRsltSearchAuditByHangerInstallationListVOs() {
		RsltSearchAuditByHangerInstallationListVO[] rtnVOs = null;
		if (this.rsltSearchAuditByHangerInstallationListVOs != null) {
			rtnVOs = Arrays.copyOf(rsltSearchAuditByHangerInstallationListVOs,rsltSearchAuditByHangerInstallationListVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltSearchAuditByHangerInstallationListVOs(RsltSearchAuditByHangerInstallationListVO[] rsltSearchAuditByHangerInstallationListVOs) {
		if (rsltSearchAuditByHangerInstallationListVOs != null) {
			RsltSearchAuditByHangerInstallationListVO[] tmpVOs = Arrays.copyOf(rsltSearchAuditByHangerInstallationListVOs,rsltSearchAuditByHangerInstallationListVOs.length);
			this.rsltSearchAuditByHangerInstallationListVOs = tmpVOs;
		}
	}
	
	public RsltSearchAuditByHangerInstallationListVO[] getRsltSearchAuditByHangerInstallationListVOS() {
		RsltSearchAuditByHangerInstallationListVO[] rtnVOs = null;
		if (this.rsltSearchAuditByHangerInstallationListVOs != null) {
			rtnVOs = Arrays.copyOf(rsltSearchAuditByHangerInstallationListVOs,rsltSearchAuditByHangerInstallationListVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltSearchAuditByHangerInstallationListVOS(RsltSearchAuditByHangerInstallationListVO[] rsltSearchAuditByHangerInstallationListVOs) {
		if (rsltSearchAuditByHangerInstallationListVOs != null) {
			RsltSearchAuditByHangerInstallationListVO[] tmpVOs = Arrays.copyOf(rsltSearchAuditByHangerInstallationListVOs,rsltSearchAuditByHangerInstallationListVOs.length);
			this.rsltSearchAuditByHangerInstallationListVOs = tmpVOs;
		}
	}
//	public RsltSearchAuditByHangerInstallationListVO[] getRsltSearchAuditByHangerInstallationListVOS(){
//		return rsltSearchAuditByHangerInstallationListVOs;
//	}

	/**
	 * @return the bkgRevUmchBkgVOs
	 */
//	public RsltSearchAuditByHangerInstallationListVO[] getRsltSearchAuditByHangerInstallationListVOs() {
//		return rsltSearchAuditByHangerInstallationListVOs;
//	}

//	public void setRsltSearchAuditByHangerInstallationListVOS(RsltSearchAuditByHangerInstallationListVO[] rsltSearchAuditByHangerInstallationListVOs){
//	this. rsltSearchAuditByHangerInstallationListVOs = rsltSearchAuditByHangerInstallationListVOs;
//}


	/**
	 * @param bkgRevUmchBkgVOs the bkgRevUmchBkgVOs to set
	 */
//	public void setRsltSearchAuditByHangerInstallationListVOs(RsltSearchAuditByHangerInstallationListVO[] rsltSearchAuditByHangerInstallationListVOs) {
//		this.rsltSearchAuditByHangerInstallationListVOs = rsltSearchAuditByHangerInstallationListVOs;
//	}
	
	
	
	
}