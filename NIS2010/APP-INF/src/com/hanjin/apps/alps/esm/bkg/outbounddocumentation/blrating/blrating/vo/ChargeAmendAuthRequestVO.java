/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RateInVO.java
 *@FileTitle : RateInVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.13
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.07.13 이진서 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *  
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ChargeAmendAuthRequestVO {

	private ChargeAmendAuthVO chargeAmendAuthVO = null;
	private ChargeAmendAuthDetailVO[] chargeAmendAuthDetailVOs = null;
	private ChargeAmendAuthRefUserVO[] chargeAmendAuthRefUserVOs = null;

	private SignOnUserAccount account = null;
	private String bkgNo = null;
	private String caflag = null; // [추가사항] C/A NO로 조회 쿼리를 나눈다. 
	private String chgCd = null;
	private String mailBody = null;
	
	/**
	 * @return the caflag
	 */
	public String getCaflag() {
		return caflag;
	}
	/**
	 * @param caflag the caflag to set
	 */
	public void setCaflag(String caflag) {
		this.caflag = caflag;
	}
	/**
	 * @return the chargeAmendAuthVO
	 */
	public ChargeAmendAuthVO getChargeAmendAuthVO() {
		return chargeAmendAuthVO;
	}
	/**
	 * @param chargeAmendAuthVO the chargeAmendAuthVO to set
	 */
	public void setChargeAmendAuthVO(ChargeAmendAuthVO chargeAmendAuthVO) {
		this.chargeAmendAuthVO = chargeAmendAuthVO;
	}
	/**
	 * @return the chargeAmendAuthDetailVOs
	 */
	public ChargeAmendAuthDetailVO[] getChargeAmendAuthDetailVOs() {
		return chargeAmendAuthDetailVOs;
	}
	/**
	 * @param chargeAmendAuthDetailVOs the chargeAmendAuthDetailVOs to set
	 */
	public void setChargeAmendAuthDetailVOs(ChargeAmendAuthDetailVO[] chargeAmendAuthDetailVOs) {
		this.chargeAmendAuthDetailVOs = chargeAmendAuthDetailVOs;
	}
	/**
	 * @return the chargeAmendAuthRefUserVOs
	 */
	public ChargeAmendAuthRefUserVO[] getChargeAmendAuthRefUserVOs() {
		return chargeAmendAuthRefUserVOs;
	}
	/**
	 * @param chargeAmendAuthRefUserVOs the chargeAmendAuthRefUserVOs to set
	 */
	public void setChargeAmendAuthRefUserVOs(ChargeAmendAuthRefUserVO[] chargeAmendAuthRefUserVOs) {
		this.chargeAmendAuthRefUserVOs = chargeAmendAuthRefUserVOs;
	}
	/**
	 * @return the account
	 */
	public SignOnUserAccount getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}
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
	 * @return the chgCd
	 */
	public String getChgCd() {
		return chgCd;
	}
	/**
	 * @param chgCd the chgCd to set
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	/**
	 * @return the mailBody
	 */
	public String getMailBody() {
		return mailBody;
	}
	/**
	 * @param mailBody the mailBody to set
	 */
	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}
	
}