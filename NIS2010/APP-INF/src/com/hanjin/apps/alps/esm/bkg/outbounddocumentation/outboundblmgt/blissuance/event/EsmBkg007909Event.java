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

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchChgRateByLBPVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
	
	private SearchChgRateByLBPVO searchChgRateByLBPVO = null;
	
	private SearchChgRateByLBPVO[] searchChgRateByLBPVOs = null;
	
	private String bkgNo = null;
	private String blNo = null;
	private String setupfocoblflag = null;
	private String buttonType = null;
	private String lbpFlg = null;
	
	private String hrdCdgId = null;
	private String attrCtnt1 = null;
	private String attrCtnt2 = null;
	private String attrCtnt3 = null;
	

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
	 * @return the blIssInfoVO
	 */
	public SearchChgRateByLBPVO getSearchChgRateByLBPVO() {
		return searchChgRateByLBPVO;
	}

	/**
	 * @param blIssInfoVO the blIssInfoVO to set
	 */
	public void setBlIssInfoVO(BlIssInfoVO blIssInfoVO) {
		this.blIssInfoVO = blIssInfoVO;
	}
	
	/**
	 * @param blIssInfoVO the blIssInfoVO to set
	 */
	public void setSearchChgRateByLBPVO(SearchChgRateByLBPVO searchChgRateByLBPVO) {
		this.searchChgRateByLBPVO = searchChgRateByLBPVO;
	}

	/**
	 * @return the blIssInfoVOs
	 */
	public BlIssInfoVO[] getBlIssInfoVOs() {
		return blIssInfoVOs;
	}
	
	/**
	 * @return the blIssInfoVOs
	 */
	public SearchChgRateByLBPVO[] getSearchChgRateByLBPVOs() {
		return searchChgRateByLBPVOs;
	}

	/**
	 * @param blIssInfoVOs the blIssInfoVOs to set
	 */
	public void setBlIssInfoVOs(BlIssInfoVO[] blIssInfoVOs) {
		this.blIssInfoVOs = blIssInfoVOs;
	}
	
	/**
	 * @param blIssInfoVOs the blIssInfoVOs to set
	 */
	public void setSearchChgRateByLBPVOs(SearchChgRateByLBPVO[] searchChgRateByLBPVOs) {
		this.searchChgRateByLBPVOs = searchChgRateByLBPVOs;
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
	 * @return
	 */
	public String getLbpFlg() {
		return lbpFlg;
	}

	public void setLbpFlg(String lbpFlg) {
		this.lbpFlg = lbpFlg;
	}

	/**
	 * @return hrdCdgId
	 */
	public String getHrdCdgId() {
		return hrdCdgId;
	}

	/**
	 * @param hrdCdgId the hrdCdgId to set
	 */
	public void setHrdCdgId(String hrdCdgId) {
		this.hrdCdgId = hrdCdgId;
	}

	/**
	 * @return attrCtnt1
	 */
	public String getAttrCtnt1() {
		return attrCtnt1;
	}

	/**
	 * @param attrCtnt1 the attrCtnt1 to set
	 */
	public void setAttrCtnt1(String attrCtnt1) {
		this.attrCtnt1 = attrCtnt1;
	}

	/**
	 * @return attrCtnt2
	 */
	public String getAttrCtnt2() {
		return attrCtnt2;
	}

	/**
	 * @param attrCtnt2 the attrCtnt2 to set
	 */
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
	}

	/**
	 * @return attrCtnt3
	 */
	public String getAttrCtnt3() {
		return attrCtnt3;
	}

	/**
	 * @param attrCtnt3 the attrCtnt3 to set
	 */
	public void setAttrCtnt3(String attrCtnt3) {
		this.attrCtnt3 = attrCtnt3;
	}
	
}