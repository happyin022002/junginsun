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
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0649 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0649HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0649HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg007909Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsmBkg007909Event(){}
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BlIssInfoVO blIssInfoVO = null;
	/** Table Value Object Multi Data 처리 */
	private BlIssInfoVO[] blIssInfoVOs = null;
	
	private String bkgNo = null;
	private String blNo = null;
	private String setupfocoblflag = null;
	private String buttonType = null;
	private String fileDownPath=null;
	private String ofcCd = null;
	private String totalpage = null;
	private String totalunrated = null;
	
	/**
	 * @return the buttonType
	 */
	public String getButtonType() {
		return buttonType;
	}

	/**
	 * @param buttonType the buttonType to set
	 */
	public void setButtonType(String buttonType) {
		this.buttonType = buttonType;
	}

	/**
	 * @return the setupfocoblflag
	 */
	public String getSetupfocoblflag() {
		return setupfocoblflag;
	}

	/**
	 * @param setupfocoblflag the setupfocoblflag to set
	 */
	public void setSetupfocoblflag(String setupfocoblflag) {
		this.setupfocoblflag = setupfocoblflag;
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

	/**
	 * @return the blIssInfoVO
	 */
	public BlIssInfoVO getBlIssInfoVO() {
		return blIssInfoVO;
	}

	/**
	 * @param blIssInfoVO the blIssInfoVO to set
	 */
	public void setBlIssInfoVO(BlIssInfoVO blIssInfoVO) {
		this.blIssInfoVO = blIssInfoVO;
	}

	public BlIssInfoVO[] getBlIssInfoVOs() {
		BlIssInfoVO[] rtnVOs = null;
		if (this.blIssInfoVOs != null) {
			rtnVOs = Arrays.copyOf(blIssInfoVOs, blIssInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setBlIssInfoVOs(BlIssInfoVO[] blIssInfoVOs) {
		if (blIssInfoVOs != null) {
			BlIssInfoVO[] tmpVOs = Arrays.copyOf(blIssInfoVOs, blIssInfoVOs.length);
			this.blIssInfoVOs = tmpVOs;
		}
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
	 * @return the ofc_cd
	 */
	public String getOfc_cd() {
		return ofcCd;
	}

	/**
	 * @param bkg_no the bkg_no to set
	 */
	public void setOfc_cd(String ofc_cd) {
		this.ofcCd = ofc_cd;
	}

	public String getFileDownPath() {
		return fileDownPath;
	}

	public void setFileDownPath(String fileDownPath) {
		this.fileDownPath = fileDownPath;
	}

	/**
	 * @return the totalpage
	 */
	public String getTotalpage() {
		return totalpage;
	}

	/**
	 * @param totalpage the totalpage to set
	 */
	public void setTotalpage(String totalpage) {
		this.totalpage = totalpage;
	}

	/**
	 * @return the totalunrated
	 */
	public String getTotalunrated() {
		return totalunrated;
	}

	/**
	 * @param totalunrated the totalunrated to set
	 */
	public void setTotalunrated(String totalunrated) {
		this.totalunrated = totalunrated;
	}

}