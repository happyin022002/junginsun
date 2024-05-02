/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0649Event.java
*@FileTitle : Cancel Issue Release
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.20 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgDocIssHisVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgDocIssRdemVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ReIssueInfoVO;


/**
 * ESM_BKG_0649 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0649HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0649HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0649Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	public EsmBkg0649Event(){}
	
	private ReIssueInfoVO 	reIssueInfoVO = null;
	private BkgDocIssHisVO[]  bkgDocIssHisVOs = null;
	private BkgDocIssRdemVO[] bkgDocIssRdemVOs = null;
	private String bkgNo = null;
	private String blNo = null;
	private String hisSeq = null;

	private String released = null;
	private String issued = null;
	private String setupfocoblflag = null;

	
	/**
	 * @return the buttonType
	 */
	public String getSetupfocoblflag() {
		return setupfocoblflag;
	}

	/**
	 * @param buttonType the buttonType to set
	 */
	public void setSetupfocoblflag(String setupfocoblflag) {
		this.setupfocoblflag = setupfocoblflag;
	}


	
	/**
	 * @return the released
	 */
	public String getReleased() {
		return released;
	}
	/**
	 * @param released the released to set
	 */
	public void setReleased(String released) {
		this.released = released;
	}
	/**
	 * @return the issued
	 */
	public String getIssued() {
		return issued;
	}
	/**
	 * @param issued the issued to set
	 */
	public void setIssued(String issued) {
		this.issued = issued;
	}
	/**
	 * @return the his_seq
	 */
	public String getHis_seq() {
		return hisSeq;
	}
	/**
	 * @param his_seq the his_seq to set
	 */
	public void setHis_seq(String his_seq) {
		this.hisSeq = his_seq;
	}
	/**
	 * @return the reIssueInfoVO
	 */
	public ReIssueInfoVO getReIssueInfoVO() {
		return reIssueInfoVO;
	}
	/**
	 * @param reIssueInfoVO the reIssueInfoVO to set
	 */
	public void setReIssueInfoVO(ReIssueInfoVO reIssueInfoVO) {
		this.reIssueInfoVO = reIssueInfoVO;
	}
	/**
	 * @return the bkgDocIssHisVOs
	 */
	public BkgDocIssHisVO[] getBkgDocIssHisVOs() {
		return bkgDocIssHisVOs;
	}
	/**
	 * @param bkgDocIssHisVOs the bkgDocIssHisVOs to set
	 */
	public void setBkgDocIssHisVOs(BkgDocIssHisVO[] bkgDocIssHisVOs) {
		this.bkgDocIssHisVOs = bkgDocIssHisVOs;
	}
	/**
	 * @return the bkgDocIssRdemVOs
	 */
	public BkgDocIssRdemVO[] getBkgDocIssRdemVOs() {
		return bkgDocIssRdemVOs;
	}
	/**
	 * @param bkgDocIssRdemVOs the bkgDocIssRdemVOs to set
	 */
	public void setBkgDocIssRdemVOs(BkgDocIssRdemVO[] bkgDocIssRdemVOs) {
		this.bkgDocIssRdemVOs = bkgDocIssRdemVOs;
	}
	/**
	 * @return the bkg_no
	 */
	public String getBkg_no() {
		return bkgNo;
	}
	/**
	 * @param bkg_no the bkg_no to set
	 */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
	}
	/**
	 * @return the bl_no
	 */
	public String getBl_no() {
		return blNo;
	}
	/**
	 * @param bl_no the bl_no to set
	 */
	public void setBl_no(String bl_no) {
		this.blNo = bl_no;
	}



	


	
}