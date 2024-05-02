/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0221Event.java
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;


import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0221 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0221HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Byung Kyu
 * @see ESM_BKG_0221HTMLAction에서 참조
 * @since J2EE 1.6
 */

public class EsmBkg0221Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsmBkg0221Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DblWblVO dblwblvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private DblWblVO[] dblwblvos = null;
	
	private String bkgNo = null;
	private String blNo = null;
	private String blTpCd = null;
	private String hiddenData = null;
	private String mfFlag = null;
	private String grpFlag = null;
	private String rdFormId = null;
	private String formRate = null;
	private String formCntr = null;
	private String formCorrNo = null;

	/**
	 * @return the bl_tp_cd
	 */
	public String getBl_tp_cd() {
		return blTpCd;
	}

	public String getForm_corr_no() {
		return formCorrNo;
	}

	public void setForm_corr_no(String formCorrNo) {
		this.formCorrNo = formCorrNo;
	}

	/**
	 * @param blTpCd the bl_tp_cd to set
	 */
	public void setBl_tp_cd(String blTpCd) {
		this.blTpCd = blTpCd;
	}

	/**
	 * @return the bl_no
	 */
	public String getBl_no() {
		return blNo;
	}

	/**
	 * @param blNo the bl_no to set
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
	 * @param bkgNo the bkg_no to set
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

	public DblWblVO getDblwblvo() {
		return dblwblvo;
	}

	public void setDblwblvo(DblWblVO dblwblvo) {
		this.dblwblvo = dblwblvo;
	}

	public DblWblVO[] getDblwblvos() {
		return dblwblvos;
	}

	public void setDblwblvos(DblWblVO[] dblwblvos) {
		this.dblwblvos = dblwblvos;
	}
	
	public String getForm_Rate() {
		return formRate;
	}

	public void setForm_Rate(String formRate) {
		this.formRate = formRate;
	}

	public String getForm_Cntr() {
		return formCntr;
	}

	public void setForm_Cntr(String formCntr) {
		this.formCntr = formCntr;
	}

}