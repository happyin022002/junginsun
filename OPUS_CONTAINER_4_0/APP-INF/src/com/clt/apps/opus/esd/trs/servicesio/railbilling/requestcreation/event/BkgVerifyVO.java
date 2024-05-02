/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BkgVerifyVO.java
*@FileTitle : BkgVerifyVO Info
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event;

import org.apache.commons.lang.StringEscapeUtils;

import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.Constants;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class BkgVerifyVO implements java.io.Serializable {
	/** (Param 객체) */
	private String bkgVrfyRstCd = Constants.VRFY_GOOD;
	private String bkgVrfyErrCd = "";
	private String bkgVrfyErrLangTpCd = "ENG";
	private String bkgVrfyErrMsg = "";
	private boolean noWrsFlag = false;
	private String noWrsErrCode = "";
	
	/**
	 * @return Returns the bkgVrfyErrLangTpCd.
	 */
	public String getBkgVrfyErrLangTpCd() {
		return bkgVrfyErrLangTpCd;
	}
	/**
	 * @param bkgVrfyErrLangTpCd The bkgVrfyErrLangTpCd to set.
	 */
	public void setBkgVrfyErrLangTpCd(String bkgVrfyErrLangTpCd) {
		this.bkgVrfyErrLangTpCd = bkgVrfyErrLangTpCd;
	}
	/**
	 * @return Returns the bkgVrfyErrMsg.
	 */
	public String getBkgVrfyErrMsg() {
		return bkgVrfyErrMsg;
	}
	/**
	 * @param bkgVrfyErrMsg The bkgVrfyErrMsg to set.
	 */
	public void setBkgVrfyErrMsg(String bkgVrfyErrMsg) {
		this.bkgVrfyErrMsg = StringEscapeUtils.escapeXml(bkgVrfyErrMsg);
	}
	/**
	 * @return Returns the bkgVrfyErrCd.
	 */
	public String getBkgVrfyErrCd() {
		return bkgVrfyErrCd;
	}
	/**
	 * @param bkgVrfyErrCd The bkgVrfyErrCd to set.
	 */
	public void setBkgVrfyErrCd(String bkgVrfyErrCd) {
		this.bkgVrfyErrCd = bkgVrfyErrCd;
	}

	/**
	 * @return Returns the bkgVrfyRstCd.
	 */
	public String getBkgVrfyRstCd() {
		return bkgVrfyRstCd;
	}
	/**
	 * @param bkgVrfyRstCd The bkgVrfyRstCd to set.
	 */
	public void setBkgVrfyRstCd(String bkgVrfyRstCd) {
		this.bkgVrfyRstCd = bkgVrfyRstCd;
	}
	/**
	 * @return Returns the noWrsFlag.
	 */
	public boolean isNoWrsFlag() {
		return noWrsFlag;
	}
	/**
	 * @param noWrsFlag The noWrsFlag to set.
	 */
	public void setNoWrsFlag(boolean noWrsFlag) {
		this.noWrsFlag = noWrsFlag;
	}
	/**
	 * @return Returns the noWrsErrCode.
	 */
	public String getNoWrsErrCode() {
		return noWrsErrCode;
	}
	/**
	 * @param noWrsErrCode The noWrsErrCode to set.
	 */
	public void setNoWrsErrCode(String noWrsErrCode) {
		this.noWrsErrCode = noWrsErrCode;
	}
	
	
	
}
