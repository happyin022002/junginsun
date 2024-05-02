/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiBookingUtilEvent.java
 *@FileTitle : Booking Page
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.23
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.23 김영출
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgCstmsHrdCdgCtntVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * UI_Booking_Util 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_Booking_UtilHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Youngchul
 * @see ESM_Booking_UtilHTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBookingUtilEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** Table Value Object Multi Data 처리 */
	private BkgBlNoVO[] bkgBlNoVOs = null;
	/** Table Value Object 조회 조건 및 단건 처리 */
	private BkgBlNoVO bkgBlNoVO = null;
	private String comboCd = null;
	private String bkgNo = null;
	private String bkgTrunkVvd = null;
	private String polCd = null;
	private String podCd = null;
	private String rfaNo = null;
	private String scNo = null;
	private String taaNo = null;
	private String inputText = null; // by leejinseo 
	private String sql = null; // input Sql  
	private String caFlg = null; 
	private String ofcCd = null; 
	private String cntrTpszCd = null;
	private String jobId = null;
	private String chgCd = null;
	private String pgmNo = null;
	private String currCd = null;
	private String vvd = null;
	private String locCd = null;
	
	private BkgVvdBdrLogVO bkgVvdBdrLogVO = null;
	private BkgVvdBdrLogVO[] bkgVvdBdrLogVOs = null;
	
	private BkgCstmsHrdCdgCtntVO bkgCstmsHrdCdgCtntVO = null;
	
	/**
	 * @return String
	 */
	public String getSql() {
		return sql;
	}
	/**
	 * @param String sql
	 */
	public void setSql(String sql) {
		this.sql = sql;
	}
	/**
	 * @return String
	 */
	public String getInputText() {
		return inputText;
	}
	/**
	 * the inputText to set
	 * @param String inputText
	 */
	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

	public EsmBookingUtilEvent() {
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public void setBkgBlNoVOS(BkgBlNoVO[] bkgBlNoVOs) {
		if(bkgBlNoVOs != null){
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs.length);
			this.bkgBlNoVOs = tmpVOs;
		}
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public BkgBlNoVO[] getBkgBlNoVOS() {
		BkgBlNoVO[] rtnVOs = null;
		if(this.bkgBlNoVOs != null){
			rtnVOs= Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs.length);
		}
		return rtnVOs;
	}

	public void setComboCd(String comboCd) {
		this.comboCd = comboCd;
	}

	public String getComboCd() {
		return comboCd;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getBkgNo() {
		return bkgNo;
	}
	public String getCaFlg() {
		return caFlg;
	}

	public void setBkgTrunkVvd(String bkgTrunkVvd) {
		this.bkgTrunkVvd = bkgTrunkVvd;
	}

	public String getBkgTrunkVvd() {
		return bkgTrunkVvd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	public String getPolCd() {
		return polCd;
	}

	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	public String getPodCd() {
		return podCd;
	}

	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}

	public String getRfaNo() {
		return rfaNo;
	}

	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	public String getScNo() {
		return scNo;
	}
	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
	}

	public String getTaaNo() {
		return taaNo;
	}
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}
	public BkgVvdBdrLogVO getBkgVvdBdrLogVO() {
		return bkgVvdBdrLogVO;
	}
	public void setBkgVvdBdrLogVO(BkgVvdBdrLogVO bkgVvdBdrLogVO) {
		this.bkgVvdBdrLogVO = bkgVvdBdrLogVO;
	}
	public BkgVvdBdrLogVO[] getBkgVvdBdrLogVOs() {
		BkgVvdBdrLogVO[] rtnVOs = null;
		if(this.bkgVvdBdrLogVOs != null){
			rtnVOs= Arrays.copyOf(bkgVvdBdrLogVOs, bkgVvdBdrLogVOs.length);
		}
		return rtnVOs;
	}
	public void setBkgVvdBdrLogVOs(BkgVvdBdrLogVO[] bkgVvdBdrLogVOs) {
		if(bkgVvdBdrLogVOs != null){
			BkgVvdBdrLogVO[] tmpVOs = Arrays.copyOf(bkgVvdBdrLogVOs, bkgVvdBdrLogVOs.length);
			this.bkgVvdBdrLogVOs = tmpVOs;
		}
	}
	public BkgCstmsHrdCdgCtntVO getBkgCstmsHrdCdgCtntVO() {
		return bkgCstmsHrdCdgCtntVO;
	}
	public void setBkgCstmsHrdCdgCtntVO(BkgCstmsHrdCdgCtntVO bkgCstmsHrdCdgCtntVO) {
		this.bkgCstmsHrdCdgCtntVO = bkgCstmsHrdCdgCtntVO;
	}
	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the jobId
	 */
	public String getJobId() {
		return jobId;
	}
	public String getOfcCd() {
		return ofcCd;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	/**
	 * 
	 * @return
	 */
	public String getCntrTpszCd() {
		return cntrTpszCd;
	}
	
	/**
	 * 
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	public String getPgmNo() {
		return pgmNo;
	}
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}
	public String getCurrCd() {
		return currCd;
	}
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	public String getVvd() {
		return vvd;
	}
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	public String getLocCd() {
		return locCd;
	}
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
}