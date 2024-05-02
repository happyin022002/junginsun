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
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class RateInVO {

	private BkgChgRateVO[] bkgChgRateVOs = null;
	private RateMainInfoVO[] rateMainInfoVOs = null;

	private SignOnUserAccount account = null;
	private String bkg_no = null;
	private String bl_no = null;
	private String covered_bl = null;
	private String application_date = null;
	private String caflag = null; // [추가사항] C/A NO로 조회 쿼리를 나눈다. 
	private String autoRate = null; // [추가사항] autoRate에서 들어온 상황  
	private String removeAll = null; // [추가사항] removeAll 들어온 상황  
	
	/**
	 * @return the removeAll
	 */
	public String getRemoveAll() {
		return removeAll;
	}
	/**
	 * @param removeAll the removeAll to set
	 */
	public void setRemoveAll(String removeAll) {
		this.removeAll = removeAll;
	}
	/**
	 * @return the autoRate
	 */
	public String getAutoRate() {
		return autoRate;
	}
	/**
	 * @param autoRate the autoRate to set
	 */
	public void setAutoRate(String autoRate) {
		this.autoRate = autoRate;
	}
	/**
	 * @return the covered_bl
	 */
	public String getCovered_bl() {
		return covered_bl;
	}
	/**
	 * @param covered_bl the covered_bl to set
	 */
	public void setCovered_bl(String covered_bl) {
		this.covered_bl = covered_bl;
	}
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
	 * @return the rateMainInfoVOs
	 */
	public RateMainInfoVO[] getRateMainInfoVOs() {
		return rateMainInfoVOs;
	}
	/**
	 * @param rateMainInfoVOs the rateMainInfoVOs to set
	 */
	public void setRateMainInfoVOs(RateMainInfoVO[] rateMainInfoVOs) {
		this.rateMainInfoVOs = rateMainInfoVOs;
	}
	/**
	 * @return the bkgChgRateVOs
	 */
	public BkgChgRateVO[] getBkgChgRateVOs() {
		return bkgChgRateVOs;
	}
	/**
	 * @param bkgChgRateVOs the bkgChgRateVOs to set
	 */
	public void setBkgChgRateVOs(BkgChgRateVO[] bkgChgRateVOs) {
		this.bkgChgRateVOs = bkgChgRateVOs;
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
	 * @return the bkg_no
	 */
	public String getBkg_no() {
		return bkg_no;
	}
	/**
	 * @param bkg_no the bkg_no to set
	 */
	public void setBkg_no(String bkg_no) {
		this.bkg_no = bkg_no;
	}
	/**
	 * @return the bl_no
	 */
	public String getBl_no() {
		return bl_no;
	}
	/**
	 * @param bl_no the bl_no to set
	 */
	public void setBl_no(String bl_no) {
		this.bl_no = bl_no;
	}
	/**
	 * @return the application_date
	 */
	public String getApplication_date() {
		return application_date;
	}
	/**
	 * @param application_date the application_date to set
	 */
	public void setApplication_date(String application_date) {
		this.application_date = application_date;
	}
	
	
	
}