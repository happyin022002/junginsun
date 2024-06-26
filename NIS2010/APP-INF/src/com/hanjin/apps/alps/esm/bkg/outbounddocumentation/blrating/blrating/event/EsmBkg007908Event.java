/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg007908Event.java
*@FileTitle : Freight & Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.26 이진서
* 1.0 Creation
* 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0079_08 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0079_08HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0079_08HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg007908Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String bkgNo = null;
	private String blNo = null;
	private String caflag = null;
	private String autoRate = null;
	private String removeAll = null; // [추가사항] removeAll 들어온 상황  
	private String coveredBl = null;
	private String applicationDate = null;
	private String ctrtType = null;
	private String ctrtNo = null;
	private RateMainInfoVO[] rateMainInfoVOs = null;
	private BkgChgRateVO[] bkgChgRateVOs = null;
	private BkgChgRateVO[] bkgChgRateHisVOs = null;

	private String ctrtOfcCd = null;
	private String ctrtSrepCd = null;
	
    private String bkgPolCd = null;
    private String bkgCtrtTpCd = null;
	
	/**
	 * @return the ctrtType
	 */
	public String getCtrtType() {
		return ctrtType;
	}
	/**
	 * @param ctrtType the ctrtType to set
	 */
	public void setCtrtType(String ctrtType) {
		this.ctrtType = ctrtType;
	}
	/**
	 * @return the ctrtNo
	 */
	public String getCtrtNo() {
		return ctrtNo;
	}
	/**
	 * @param ctrtNo the removeAll to set
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
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
	 * @return the bkgChgRateHisVOs
	 */
	public BkgChgRateVO[] getBkgChgRateHisVOs() {
		BkgChgRateVO[] rtnVOs = null;
		if (this.bkgChgRateHisVOs != null) {
			rtnVOs = Arrays.copyOf(bkgChgRateHisVOs, bkgChgRateHisVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param bkgChgRateHisVOs the bkgChgRateHisVOs to set
	 */
	public void setBkgChgRateHisVOs(BkgChgRateVO[] bkgChgRateHisVOs){
		if(bkgChgRateHisVOs != null){
			BkgChgRateVO[] tmpVOs = Arrays.copyOf(bkgChgRateHisVOs, bkgChgRateHisVOs.length);
			this.bkgChgRateHisVOs = tmpVOs;
		}
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
		return coveredBl;
	}
	/**
	 * @param covered_bl the covered_bl to set
	 */
	public void setCovered_bl(String covered_bl) {
		this.coveredBl = covered_bl;
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
	 * @return the application_date
	 */
	public String getApplication_date() {
		return applicationDate;
	}
	/**
	 * @param application_date the application_date to set
	 */
	public void setApplication_date(String application_date) {
		this.applicationDate = application_date;
	}

	/**
	 * @return the rateMainInfoVOs
	 */
	public RateMainInfoVO[] getRateMainInfoVOs() {
		RateMainInfoVO[] rtnVOs = null;
		if (this.rateMainInfoVOs != null) {
			rtnVOs = Arrays.copyOf(rateMainInfoVOs, rateMainInfoVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param rateMainInfoVOs the rateMainInfoVOs to set
	 */
	public void setRateMainInfoVOs(RateMainInfoVO[] rateMainInfoVOs){
		if(rateMainInfoVOs != null){
			RateMainInfoVO[] tmpVOs = Arrays.copyOf(rateMainInfoVOs, rateMainInfoVOs.length);
			this.rateMainInfoVOs = tmpVOs;
		}
	}
	/**
	 * @return the bkgChgRateVOs
	 */
	public BkgChgRateVO[] getBkgChgRateVOs() {
		BkgChgRateVO[] rtnVOs = null;
		if (this.bkgChgRateVOs != null) {
			rtnVOs = Arrays.copyOf(bkgChgRateVOs, bkgChgRateVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param bkgChgRateVOs the bkgChgRateVOs to set
	 */
	public void setBkgChgRateVOs(BkgChgRateVO[] bkgChgRateVOs){
		if(bkgChgRateVOs != null){
			BkgChgRateVO[] tmpVOs = Arrays.copyOf(bkgChgRateVOs, bkgChgRateVOs.length);
			this.bkgChgRateVOs = tmpVOs;
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
	 * @return String
	 */
	public String getCtrtOfcCd() {
		return ctrtOfcCd;
	}
	/**
	 * @param String ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	/**
	 * @return String
	 */
	public String getCtrtSrepCd() {
		return ctrtSrepCd;
	}
	/**
	 * @param String ctrtSrepCd
	 */
	public void setCtrtSrepCd(String ctrtSrepCd) {
		this.ctrtSrepCd = ctrtSrepCd;
	}
	
    public String getBkgPolCd() {
        return bkgPolCd;
    }
    public void setBkgPolCd(String bkgPolCd) {
        this.bkgPolCd = bkgPolCd;
    }
    public String getBkgCtrtTpCd() {
        return bkgCtrtTpCd;
    }
    public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
        this.bkgCtrtTpCd = bkgCtrtTpCd;
    }	
	
}