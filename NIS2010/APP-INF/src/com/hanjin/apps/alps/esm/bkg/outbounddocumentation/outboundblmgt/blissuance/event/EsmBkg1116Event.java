/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1116Event.java
*@FileTitle : e-B/L Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.08
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.04.29 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.EBLIssueVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.EBLIssueInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_1116 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_1116HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Joon Yong Park
 * @see esm_bkg_1116HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1116Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EBLIssueInputVO eBLIssueInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EBLIssueVO[] eBLIssueVOs = null;
	
	private String bkgNo = null;
	
	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * @return the eBLIssueInputVO
	 */
	public EBLIssueInputVO getEBLIssueInputVO() {
		return eBLIssueInputVO;
	}

	/**
	 * @param issueInputVO the eBLIssueInputVO to set
	 */
	public void setEBLIssueInputVO(EBLIssueInputVO issueInputVO) {
		eBLIssueInputVO = issueInputVO;
	}

	/**
	 * @return the eBLIssueVOs
	 */
	public EBLIssueVO[] getEBLIssueVOs() {
		return eBLIssueVOs;
	}

	/**
	 * @param issueVOs the eBLIssueVOs to set
	 */
	public void setEBLIssueVOs(EBLIssueVO[] issueVOs) {
		eBLIssueVOs = issueVOs;
	}

	
	

}