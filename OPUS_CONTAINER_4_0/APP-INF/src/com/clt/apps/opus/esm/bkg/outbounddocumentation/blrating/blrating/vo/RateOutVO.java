/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RateOutVO.java
 *@FileTitle : RateOutVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.13
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.07.13 이진서 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class RateOutVO {

	private List<RateMainInfoVO> rateMainInfoVOs = null;
	private List<BkgChgRateVO> bkgChgRateVOs = null;
	private List<RateEtcInfoVO> rateEtcInfoVOs = null;
	private List<RateEtcInfo1VO> rateEtcInfo1VOs = null;
	private List<RateCntrInfoVO> rateCntrInfoVOs = null;
	private String rOfc_cd ="";
	private String caflag = null; // [추가사항] C/A NO로 조회 쿼리를 나눈다. 
	private String bdrflag = null; // [추가사항] BDR FLAG로 조회 쿼리를 나눈다. 
	
	/**
	 * @return the bdrflag
	 */
	public String getBdrflag() {
		return bdrflag;
	}
	/**
	 * @param bdrflag the bdrflag to set
	 */
	public void setBdrflag(String bdrflag) {
		this.bdrflag = bdrflag;
	}
	/**
	 * @return the rOfc_cd
	 */
	public String getROfc_cd() {
		return rOfc_cd;
	}
	/**
	 * @param ofc_cd the rOfc_cd to set
	 */
	public void setROfc_cd(String ofc_cd) {
		rOfc_cd = ofc_cd;
	}
	/**
	 * @return the rateEtcInfo1VOs
	 */
	public List<RateEtcInfo1VO> getRateEtcInfo1VOs() {
		return rateEtcInfo1VOs;
	}
	/**
	 * @param rateEtcInfo1VOs the rateEtcInfo1VOs to set
	 */
	public void setRateEtcInfo1VOs(List<RateEtcInfo1VO> rateEtcInfo1VOs) {
		this.rateEtcInfo1VOs = rateEtcInfo1VOs;
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
	public List<RateMainInfoVO> getRateMainInfoVOs() {
		return rateMainInfoVOs;
	}

	/**
	 * @param rateMainInfoVOs
	 *            the rateMainInfoVOs to set
	 */
	public void setRateMainInfoVOs(List<RateMainInfoVO> rateMainInfoVOs) {
		this.rateMainInfoVOs = rateMainInfoVOs;
	}
	
	/**
	 * @return the rateCntrInfoVOs
	 */
	public List<RateCntrInfoVO> getRateCntrInfoVOs() {
		return rateCntrInfoVOs;
	}

	/**
	 * @param rateCntrInfoVOs
	 *            the rateCntrInfoVOs to set
	 */
	public void setRateCntrInfoVOs(List<RateCntrInfoVO> rateCntrInfoVOs) {
		this.rateCntrInfoVOs = rateCntrInfoVOs;
	}
	

	/**
	 * @return the bkgChgRateVOs
	 */
	public List<BkgChgRateVO> getBkgChgRateVOs() {
		return bkgChgRateVOs;
	}

	/**
	 * @param bkgChgRateVOs
	 *            the bkgChgRateVOs to set
	 */
	public void setBkgChgRateVOs(List<BkgChgRateVO> bkgChgRateVOs) {
		this.bkgChgRateVOs = bkgChgRateVOs;
	}

	/**
	 * @return the rateEtcInfoVOs
	 */
	public List<RateEtcInfoVO> getRateEtcInfoVOs() {
		return rateEtcInfoVOs;
	}

	/**
	 * @param rateEtcInfoVOs
	 *            the rateEtcInfoVOs to set
	 */
	public void setRateEtcInfoVOs(List<RateEtcInfoVO> rateEtcInfoVOs) {
		this.rateEtcInfoVOs = rateEtcInfoVOs;
	}
}