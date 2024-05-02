/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0927Event.java
*@FileTitle : Cancel Issue Release
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.09.01 박준용
* 1.0 Creation
* History
* 2012.08.22 김기택 [CHM-201219155-01j] B/L Preview 기능 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event;

//import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BisDblWblVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BIS_0927 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BIS_0927HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BIS_0927HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBis0927Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsmBis0927Event(){}
	
	private String bkgNo = null;
	private String blNo = null;
	private String blTpCd = null;
	private String hiddenData = null;
	private String mfFlag = null;
	private String grpFlag = null;
	private String rdFormId = null;
	private String formCntr = null;
	private String formCorrNo = null;
	private String formLevel = null;

	/**
	 * @return the formLevel
	 */
	public String getFormLevel() {
		return formLevel;
	}

	/**
	 * @param blTpCd the formLevel to set
	 */
	public void setFormLevel(String formLevel) {
		this.formLevel = formLevel;
	}

	/**
	 * @return the blTpCd
	 */
	public String getBlTpCd() {
		return blTpCd;
	}

	public String getForm_corr_no() {
		return formCorrNo;
	}

	public void setForm_corr_no(String formCorrNo) {
		this.formCorrNo = formCorrNo;
	}

	/**
	 * @param blTpCd the blTpCd to set
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
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
	public void setBl_no(String blNo) {
		this.blNo = blNo;
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
	public void setBkg_no(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getMfFlag() {
		return mfFlag;
	}

	public void setMfFlag(String mfFlag) {
		this.mfFlag = mfFlag;
	}

	public String getGrpFlag() {
		return grpFlag;
	}

	public void setGrpFlag(String grpFlag) {
		this.grpFlag = grpFlag;
	}

	public String getRdFormId() {
		return rdFormId;
	}

	public void setRdFormId(String rdFormId) {
		this.rdFormId = rdFormId;
	}

	public String getHiddenData() {
		return hiddenData;
	}

	public void setHiddenData(String hiddenData) {
		this.hiddenData = hiddenData;
	}

	public String getForm_Cntr() {
		return formCntr;
	}

	public void setForm_Cntr(String formCntr) {
		this.formCntr = formCntr;
	}

}