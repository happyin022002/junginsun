/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : HbarInquiryByBkgVO.java
*@FileTitle : HbarInquiryByBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.mnraud.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HbarInquiryByBkgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HbarInquiryByBkgVO> models = new ArrayList<HbarInquiryByBkgVO>();
	
	/* Column Info */
	private String crrHngrSglBarQty = null;
	/* Column Info */
	private String mnrBarQty = null;
	/* Column Info */
	private String sBkgNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String crrHngrDblBarQty = null;
	/* Column Info */
	private String porYdCd = null;
	/* Column Info */
	private String sPolYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrFlgInpDt = null;
	/* Column Info */
	private String bkgScgMixFlg = null;
	/* Column Info */
	private String sToDt = null;
	/* Column Info */
	private String sEacIf = null;
	/* Column Info */
	private String eacIfFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String sCntrTpszCd = null;
	/* Column Info */
	private String sFmDt = null;
	/* Column Info */
	private String bkgScgAmt = null;
	/* Column Info */
	private String merHngrQty = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String polDt = null;
	/* Column Info */
	private String bkgScgCurCd = null;
	/* Column Info */
	private String crrHngrQty = null;
	/* Column Info */
	private String sBkgChgFlg = null;
	/* Column Info */
	private String sCntrNo = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String sPolLocCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String mnrWoNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String hngrFlg = null;
	/* Column Info */
	private String mnrFlgRmk = null;
	/* Column Info */
	private String crrHngrTplBarQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public HbarInquiryByBkgVO() {}

	public HbarInquiryByBkgVO(String ibflag, String pagerows, String sFmDt, String sToDt, String sVvd, String sPolLocCd, String sPolYdCd, String sBkgNo, String sCntrTpszCd, String sCntrNo, String sBkgChgFlg, String sEacIf, String chk, String seq, String cntrNo, String cntrTpszCd, String bkgNo, String polDt, String vvd, String slanCd, String porYdCd, String polYdCd, String bkgOfcCd, String hngrFlg, String crrHngrSglBarQty, String crrHngrDblBarQty, String crrHngrTplBarQty, String crrHngrQty, String merHngrQty, String bkgScgCurCd, String bkgScgAmt, String bkgScgMixFlg, String mnrFlgInpDt, String mnrWoNo, String mnrBarQty, String mnrFlgRmk, String eacIfFlg) {
		this.crrHngrSglBarQty = crrHngrSglBarQty;
		this.mnrBarQty = mnrBarQty;
		this.sBkgNo = sBkgNo;
		this.pagerows = pagerows;
		this.crrHngrDblBarQty = crrHngrDblBarQty;
		this.porYdCd = porYdCd;
		this.sPolYdCd = sPolYdCd;
		this.ibflag = ibflag;
		this.mnrFlgInpDt = mnrFlgInpDt;
		this.bkgScgMixFlg = bkgScgMixFlg;
		this.sToDt = sToDt;
		this.sEacIf = sEacIf;
		this.eacIfFlg = eacIfFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.sCntrTpszCd = sCntrTpszCd;
		this.sFmDt = sFmDt;
		this.bkgScgAmt = bkgScgAmt;
		this.merHngrQty = merHngrQty;
		this.bkgOfcCd = bkgOfcCd;
		this.polDt = polDt;
		this.bkgScgCurCd = bkgScgCurCd;
		this.crrHngrQty = crrHngrQty;
		this.sBkgChgFlg = sBkgChgFlg;
		this.sCntrNo = sCntrNo;
		this.sVvd = sVvd;
		this.vvd = vvd;
		this.sPolLocCd = sPolLocCd;
		this.bkgNo = bkgNo;
		this.slanCd = slanCd;
		this.chk = chk;
		this.mnrWoNo = mnrWoNo;
		this.cntrNo = cntrNo;
		this.polYdCd = polYdCd;
		this.seq = seq;
		this.hngrFlg = hngrFlg;
		this.mnrFlgRmk = mnrFlgRmk;
		this.crrHngrTplBarQty = crrHngrTplBarQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("crr_hngr_sgl_bar_qty", getCrrHngrSglBarQty());
		this.hashColumns.put("mnr_bar_qty", getMnrBarQty());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("crr_hngr_dbl_bar_qty", getCrrHngrDblBarQty());
		this.hashColumns.put("por_yd_cd", getPorYdCd());
		this.hashColumns.put("s_pol_yd_cd", getSPolYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_flg_inp_dt", getMnrFlgInpDt());
		this.hashColumns.put("bkg_scg_mix_flg", getBkgScgMixFlg());
		this.hashColumns.put("s_to_dt", getSToDt());
		this.hashColumns.put("s_eac_if", getSEacIf());
		this.hashColumns.put("eac_if_flg", getEacIfFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("s_cntr_tpsz_cd", getSCntrTpszCd());
		this.hashColumns.put("s_fm_dt", getSFmDt());
		this.hashColumns.put("bkg_scg_amt", getBkgScgAmt());
		this.hashColumns.put("mer_hngr_qty", getMerHngrQty());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("pol_dt", getPolDt());
		this.hashColumns.put("bkg_scg_cur_cd", getBkgScgCurCd());
		this.hashColumns.put("crr_hngr_qty", getCrrHngrQty());
		this.hashColumns.put("s_bkg_chg_flg", getSBkgChgFlg());
		this.hashColumns.put("s_cntr_no", getSCntrNo());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("s_pol_loc_cd", getSPolLocCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("mnr_wo_no", getMnrWoNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("hngr_flg", getHngrFlg());
		this.hashColumns.put("mnr_flg_rmk", getMnrFlgRmk());
		this.hashColumns.put("crr_hngr_tpl_bar_qty", getCrrHngrTplBarQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("crr_hngr_sgl_bar_qty", "crrHngrSglBarQty");
		this.hashFields.put("mnr_bar_qty", "mnrBarQty");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("crr_hngr_dbl_bar_qty", "crrHngrDblBarQty");
		this.hashFields.put("por_yd_cd", "porYdCd");
		this.hashFields.put("s_pol_yd_cd", "sPolYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_flg_inp_dt", "mnrFlgInpDt");
		this.hashFields.put("bkg_scg_mix_flg", "bkgScgMixFlg");
		this.hashFields.put("s_to_dt", "sToDt");
		this.hashFields.put("s_eac_if", "sEacIf");
		this.hashFields.put("eac_if_flg", "eacIfFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("s_cntr_tpsz_cd", "sCntrTpszCd");
		this.hashFields.put("s_fm_dt", "sFmDt");
		this.hashFields.put("bkg_scg_amt", "bkgScgAmt");
		this.hashFields.put("mer_hngr_qty", "merHngrQty");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("pol_dt", "polDt");
		this.hashFields.put("bkg_scg_cur_cd", "bkgScgCurCd");
		this.hashFields.put("crr_hngr_qty", "crrHngrQty");
		this.hashFields.put("s_bkg_chg_flg", "sBkgChgFlg");
		this.hashFields.put("s_cntr_no", "sCntrNo");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("s_pol_loc_cd", "sPolLocCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("mnr_wo_no", "mnrWoNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("hngr_flg", "hngrFlg");
		this.hashFields.put("mnr_flg_rmk", "mnrFlgRmk");
		this.hashFields.put("crr_hngr_tpl_bar_qty", "crrHngrTplBarQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return crrHngrSglBarQty
	 */
	public String getCrrHngrSglBarQty() {
		return this.crrHngrSglBarQty;
	}
	
	/**
	 * Column Info
	 * @return mnrBarQty
	 */
	public String getMnrBarQty() {
		return this.mnrBarQty;
	}
	
	/**
	 * Column Info
	 * @return sBkgNo
	 */
	public String getSBkgNo() {
		return this.sBkgNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return crrHngrDblBarQty
	 */
	public String getCrrHngrDblBarQty() {
		return this.crrHngrDblBarQty;
	}
	
	/**
	 * Column Info
	 * @return porYdCd
	 */
	public String getPorYdCd() {
		return this.porYdCd;
	}
	
	/**
	 * Column Info
	 * @return sPolYdCd
	 */
	public String getSPolYdCd() {
		return this.sPolYdCd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return mnrFlgInpDt
	 */
	public String getMnrFlgInpDt() {
		return this.mnrFlgInpDt;
	}
	
	/**
	 * Column Info
	 * @return bkgScgMixFlg
	 */
	public String getBkgScgMixFlg() {
		return this.bkgScgMixFlg;
	}
	
	/**
	 * Column Info
	 * @return sToDt
	 */
	public String getSToDt() {
		return this.sToDt;
	}
	
	/**
	 * Column Info
	 * @return sEacIf
	 */
	public String getSEacIf() {
		return this.sEacIf;
	}
	
	/**
	 * Column Info
	 * @return eacIfFlg
	 */
	public String getEacIfFlg() {
		return this.eacIfFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return sCntrTpszCd
	 */
	public String getSCntrTpszCd() {
		return this.sCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return sFmDt
	 */
	public String getSFmDt() {
		return this.sFmDt;
	}
	
	/**
	 * Column Info
	 * @return bkgScgAmt
	 */
	public String getBkgScgAmt() {
		return this.bkgScgAmt;
	}
	
	/**
	 * Column Info
	 * @return merHngrQty
	 */
	public String getMerHngrQty() {
		return this.merHngrQty;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return polDt
	 */
	public String getPolDt() {
		return this.polDt;
	}
	
	/**
	 * Column Info
	 * @return bkgScgCurCd
	 */
	public String getBkgScgCurCd() {
		return this.bkgScgCurCd;
	}
	
	/**
	 * Column Info
	 * @return crrHngrQty
	 */
	public String getCrrHngrQty() {
		return this.crrHngrQty;
	}
	
	/**
	 * Column Info
	 * @return sBkgChgFlg
	 */
	public String getSBkgChgFlg() {
		return this.sBkgChgFlg;
	}
	
	/**
	 * Column Info
	 * @return sCntrNo
	 */
	public String getSCntrNo() {
		return this.sCntrNo;
	}
	
	/**
	 * Column Info
	 * @return sVvd
	 */
	public String getSVvd() {
		return this.sVvd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return sPolLocCd
	 */
	public String getSPolLocCd() {
		return this.sPolLocCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return mnrWoNo
	 */
	public String getMnrWoNo() {
		return this.mnrWoNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return hngrFlg
	 */
	public String getHngrFlg() {
		return this.hngrFlg;
	}
	
	/**
	 * Column Info
	 * @return mnrFlgRmk
	 */
	public String getMnrFlgRmk() {
		return this.mnrFlgRmk;
	}
	
	/**
	 * Column Info
	 * @return crrHngrTplBarQty
	 */
	public String getCrrHngrTplBarQty() {
		return this.crrHngrTplBarQty;
	}
	

	/**
	 * Column Info
	 * @param crrHngrSglBarQty
	 */
	public void setCrrHngrSglBarQty(String crrHngrSglBarQty) {
		this.crrHngrSglBarQty = crrHngrSglBarQty;
	}
	
	/**
	 * Column Info
	 * @param mnrBarQty
	 */
	public void setMnrBarQty(String mnrBarQty) {
		this.mnrBarQty = mnrBarQty;
	}
	
	/**
	 * Column Info
	 * @param sBkgNo
	 */
	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param crrHngrDblBarQty
	 */
	public void setCrrHngrDblBarQty(String crrHngrDblBarQty) {
		this.crrHngrDblBarQty = crrHngrDblBarQty;
	}
	
	/**
	 * Column Info
	 * @param porYdCd
	 */
	public void setPorYdCd(String porYdCd) {
		this.porYdCd = porYdCd;
	}
	
	/**
	 * Column Info
	 * @param sPolYdCd
	 */
	public void setSPolYdCd(String sPolYdCd) {
		this.sPolYdCd = sPolYdCd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param mnrFlgInpDt
	 */
	public void setMnrFlgInpDt(String mnrFlgInpDt) {
		this.mnrFlgInpDt = mnrFlgInpDt;
	}
	
	/**
	 * Column Info
	 * @param bkgScgMixFlg
	 */
	public void setBkgScgMixFlg(String bkgScgMixFlg) {
		this.bkgScgMixFlg = bkgScgMixFlg;
	}
	
	/**
	 * Column Info
	 * @param sToDt
	 */
	public void setSToDt(String sToDt) {
		this.sToDt = sToDt;
	}
	
	/**
	 * Column Info
	 * @param sEacIf
	 */
	public void setSEacIf(String sEacIf) {
		this.sEacIf = sEacIf;
	}
	
	/**
	 * Column Info
	 * @param eacIfFlg
	 */
	public void setEacIfFlg(String eacIfFlg) {
		this.eacIfFlg = eacIfFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param sCntrTpszCd
	 */
	public void setSCntrTpszCd(String sCntrTpszCd) {
		this.sCntrTpszCd = sCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param sFmDt
	 */
	public void setSFmDt(String sFmDt) {
		this.sFmDt = sFmDt;
	}
	
	/**
	 * Column Info
	 * @param bkgScgAmt
	 */
	public void setBkgScgAmt(String bkgScgAmt) {
		this.bkgScgAmt = bkgScgAmt;
	}
	
	/**
	 * Column Info
	 * @param merHngrQty
	 */
	public void setMerHngrQty(String merHngrQty) {
		this.merHngrQty = merHngrQty;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param polDt
	 */
	public void setPolDt(String polDt) {
		this.polDt = polDt;
	}
	
	/**
	 * Column Info
	 * @param bkgScgCurCd
	 */
	public void setBkgScgCurCd(String bkgScgCurCd) {
		this.bkgScgCurCd = bkgScgCurCd;
	}
	
	/**
	 * Column Info
	 * @param crrHngrQty
	 */
	public void setCrrHngrQty(String crrHngrQty) {
		this.crrHngrQty = crrHngrQty;
	}
	
	/**
	 * Column Info
	 * @param sBkgChgFlg
	 */
	public void setSBkgChgFlg(String sBkgChgFlg) {
		this.sBkgChgFlg = sBkgChgFlg;
	}
	
	/**
	 * Column Info
	 * @param sCntrNo
	 */
	public void setSCntrNo(String sCntrNo) {
		this.sCntrNo = sCntrNo;
	}
	
	/**
	 * Column Info
	 * @param sVvd
	 */
	public void setSVvd(String sVvd) {
		this.sVvd = sVvd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param sPolLocCd
	 */
	public void setSPolLocCd(String sPolLocCd) {
		this.sPolLocCd = sPolLocCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param mnrWoNo
	 */
	public void setMnrWoNo(String mnrWoNo) {
		this.mnrWoNo = mnrWoNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param hngrFlg
	 */
	public void setHngrFlg(String hngrFlg) {
		this.hngrFlg = hngrFlg;
	}
	
	/**
	 * Column Info
	 * @param mnrFlgRmk
	 */
	public void setMnrFlgRmk(String mnrFlgRmk) {
		this.mnrFlgRmk = mnrFlgRmk;
	}
	
	/**
	 * Column Info
	 * @param crrHngrTplBarQty
	 */
	public void setCrrHngrTplBarQty(String crrHngrTplBarQty) {
		this.crrHngrTplBarQty = crrHngrTplBarQty;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCrrHngrSglBarQty(JSPUtil.getParameter(request, prefix + "crr_hngr_sgl_bar_qty", ""));
		setMnrBarQty(JSPUtil.getParameter(request, prefix + "mnr_bar_qty", ""));
		setSBkgNo(JSPUtil.getParameter(request, prefix + "s_bkg_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCrrHngrDblBarQty(JSPUtil.getParameter(request, prefix + "crr_hngr_dbl_bar_qty", ""));
		setPorYdCd(JSPUtil.getParameter(request, prefix + "por_yd_cd", ""));
		setSPolYdCd(JSPUtil.getParameter(request, prefix + "s_pol_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMnrFlgInpDt(JSPUtil.getParameter(request, prefix + "mnr_flg_inp_dt", ""));
		setBkgScgMixFlg(JSPUtil.getParameter(request, prefix + "bkg_scg_mix_flg", ""));
		setSToDt(JSPUtil.getParameter(request, prefix + "s_to_dt", ""));
		setSEacIf(JSPUtil.getParameter(request, prefix + "s_eac_if", ""));
		setEacIfFlg(JSPUtil.getParameter(request, prefix + "eac_if_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setSCntrTpszCd(JSPUtil.getParameter(request, prefix + "s_cntr_tpsz_cd", ""));
		setSFmDt(JSPUtil.getParameter(request, prefix + "s_fm_dt", ""));
		setBkgScgAmt(JSPUtil.getParameter(request, prefix + "bkg_scg_amt", ""));
		setMerHngrQty(JSPUtil.getParameter(request, prefix + "mer_hngr_qty", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setPolDt(JSPUtil.getParameter(request, prefix + "pol_dt", ""));
		setBkgScgCurCd(JSPUtil.getParameter(request, prefix + "bkg_scg_cur_cd", ""));
		setCrrHngrQty(JSPUtil.getParameter(request, prefix + "crr_hngr_qty", ""));
		setSBkgChgFlg(JSPUtil.getParameter(request, prefix + "s_bkg_chg_flg", ""));
		setSCntrNo(JSPUtil.getParameter(request, prefix + "s_cntr_no", ""));
		setSVvd(JSPUtil.getParameter(request, prefix + "s_vvd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSPolLocCd(JSPUtil.getParameter(request, prefix + "s_pol_loc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setMnrWoNo(JSPUtil.getParameter(request, prefix + "mnr_wo_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
		setMnrFlgRmk(JSPUtil.getParameter(request, prefix + "mnr_flg_rmk", ""));
		setCrrHngrTplBarQty(JSPUtil.getParameter(request, prefix + "crr_hngr_tpl_bar_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HbarInquiryByBkgVO[]
	 */
	public HbarInquiryByBkgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HbarInquiryByBkgVO[]
	 */
	public HbarInquiryByBkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HbarInquiryByBkgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] crrHngrSglBarQty = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_sgl_bar_qty", length));
			String[] mnrBarQty = (JSPUtil.getParameter(request, prefix	+ "mnr_bar_qty", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] crrHngrDblBarQty = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_dbl_bar_qty", length));
			String[] porYdCd = (JSPUtil.getParameter(request, prefix	+ "por_yd_cd", length));
			String[] sPolYdCd = (JSPUtil.getParameter(request, prefix	+ "s_pol_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrFlgInpDt = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_inp_dt", length));
			String[] bkgScgMixFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_scg_mix_flg", length));
			String[] sToDt = (JSPUtil.getParameter(request, prefix	+ "s_to_dt", length));
			String[] sEacIf = (JSPUtil.getParameter(request, prefix	+ "s_eac_if", length));
			String[] eacIfFlg = (JSPUtil.getParameter(request, prefix	+ "eac_if_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] sCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "s_cntr_tpsz_cd", length));
			String[] sFmDt = (JSPUtil.getParameter(request, prefix	+ "s_fm_dt", length));
			String[] bkgScgAmt = (JSPUtil.getParameter(request, prefix	+ "bkg_scg_amt", length));
			String[] merHngrQty = (JSPUtil.getParameter(request, prefix	+ "mer_hngr_qty", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] polDt = (JSPUtil.getParameter(request, prefix	+ "pol_dt", length));
			String[] bkgScgCurCd = (JSPUtil.getParameter(request, prefix	+ "bkg_scg_cur_cd", length));
			String[] crrHngrQty = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_qty", length));
			String[] sBkgChgFlg = (JSPUtil.getParameter(request, prefix	+ "s_bkg_chg_flg", length));
			String[] sCntrNo = (JSPUtil.getParameter(request, prefix	+ "s_cntr_no", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] sPolLocCd = (JSPUtil.getParameter(request, prefix	+ "s_pol_loc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] mnrWoNo = (JSPUtil.getParameter(request, prefix	+ "mnr_wo_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] hngrFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_flg", length));
			String[] mnrFlgRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_rmk", length));
			String[] crrHngrTplBarQty = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_tpl_bar_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new HbarInquiryByBkgVO();
				if (crrHngrSglBarQty[i] != null)
					model.setCrrHngrSglBarQty(crrHngrSglBarQty[i]);
				if (mnrBarQty[i] != null)
					model.setMnrBarQty(mnrBarQty[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (crrHngrDblBarQty[i] != null)
					model.setCrrHngrDblBarQty(crrHngrDblBarQty[i]);
				if (porYdCd[i] != null)
					model.setPorYdCd(porYdCd[i]);
				if (sPolYdCd[i] != null)
					model.setSPolYdCd(sPolYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrFlgInpDt[i] != null)
					model.setMnrFlgInpDt(mnrFlgInpDt[i]);
				if (bkgScgMixFlg[i] != null)
					model.setBkgScgMixFlg(bkgScgMixFlg[i]);
				if (sToDt[i] != null)
					model.setSToDt(sToDt[i]);
				if (sEacIf[i] != null)
					model.setSEacIf(sEacIf[i]);
				if (eacIfFlg[i] != null)
					model.setEacIfFlg(eacIfFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (sCntrTpszCd[i] != null)
					model.setSCntrTpszCd(sCntrTpszCd[i]);
				if (sFmDt[i] != null)
					model.setSFmDt(sFmDt[i]);
				if (bkgScgAmt[i] != null)
					model.setBkgScgAmt(bkgScgAmt[i]);
				if (merHngrQty[i] != null)
					model.setMerHngrQty(merHngrQty[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (polDt[i] != null)
					model.setPolDt(polDt[i]);
				if (bkgScgCurCd[i] != null)
					model.setBkgScgCurCd(bkgScgCurCd[i]);
				if (crrHngrQty[i] != null)
					model.setCrrHngrQty(crrHngrQty[i]);
				if (sBkgChgFlg[i] != null)
					model.setSBkgChgFlg(sBkgChgFlg[i]);
				if (sCntrNo[i] != null)
					model.setSCntrNo(sCntrNo[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (sPolLocCd[i] != null)
					model.setSPolLocCd(sPolLocCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (mnrWoNo[i] != null)
					model.setMnrWoNo(mnrWoNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (hngrFlg[i] != null)
					model.setHngrFlg(hngrFlg[i]);
				if (mnrFlgRmk[i] != null)
					model.setMnrFlgRmk(mnrFlgRmk[i]);
				if (crrHngrTplBarQty[i] != null)
					model.setCrrHngrTplBarQty(crrHngrTplBarQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHbarInquiryByBkgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HbarInquiryByBkgVO[]
	 */
	public HbarInquiryByBkgVO[] getHbarInquiryByBkgVOs(){
		HbarInquiryByBkgVO[] vos = (HbarInquiryByBkgVO[])models.toArray(new HbarInquiryByBkgVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.crrHngrSglBarQty = this.crrHngrSglBarQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrBarQty = this.mnrBarQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrDblBarQty = this.crrHngrDblBarQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porYdCd = this.porYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPolYdCd = this.sPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgInpDt = this.mnrFlgInpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgScgMixFlg = this.bkgScgMixFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToDt = this.sToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacIf = this.sEacIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacIfFlg = this.eacIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrTpszCd = this.sCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmDt = this.sFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgScgAmt = this.bkgScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.merHngrQty = this.merHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDt = this.polDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgScgCurCd = this.bkgScgCurCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrQty = this.crrHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgChgFlg = this.sBkgChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrNo = this.sCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPolLocCd = this.sPolLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWoNo = this.mnrWoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlg = this.hngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgRmk = this.mnrFlgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrTplBarQty = this.crrHngrTplBarQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}