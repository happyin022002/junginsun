/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : HbarInquiryByHistoryVO.java
*@FileTitle : HbarInquiryByHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.mnraud.vo;

import java.lang.reflect.Field;
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

public class HbarInquiryByHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HbarInquiryByHistoryVO> models = new ArrayList<HbarInquiryByHistoryVO>();
	
	/* Column Info */
	private String woCurrCd = null;
	/* Column Info */
	private String regOfcCd = null;
	/* Column Info */
	private String hngrBarAmdQty = null;
	/* Column Info */
	private String oftIn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgScgMixFlg = null;
	/* Column Info */
	private String sToDt = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String sEacIf = null;
	/* Column Info */
	private String sCntCd = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String sFmDt = null;
	/* Column Info */
	private String bkgScgAmt = null;
	/* Column Info */
	private String sYdCd = null;
	/* Column Info */
	private String woAmt = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String sLocCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String bkgCurrCd = null;
	/* Column Info */
	private String mnrFlgYdCd = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String sCntrNo = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String sRegOfcCd = null;
	/* Column Info */
	private String sWoFlg = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String seq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public HbarInquiryByHistoryVO() {}

	public HbarInquiryByHistoryVO(String ibflag, String pagerows, String sFmDt, String sToDt, String sCntCd, String sLocCd, String sYdCd, String sCntrNo, String sWoFlg, String sEacIf, String sRegOfcCd, String chk, String seq, String rhqCd, String mnrFlgYdCd, String regOfcCd, String eqNo, String eqTpszCd, String hngrBarAmdQty, String woNo, String woCurrCd, String woAmt, String vndrSeq, String vndrNm, String bkgNo, String bkgCurrCd, String bkgScgAmt, String bkgScgMixFlg, String porNodCd, String polNodCd, String oftIn) {
		this.woCurrCd = woCurrCd;
		this.regOfcCd = regOfcCd;
		this.hngrBarAmdQty = hngrBarAmdQty;
		this.oftIn = oftIn;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.ibflag = ibflag;
		this.bkgScgMixFlg = bkgScgMixFlg;
		this.sToDt = sToDt;
		this.eqNo = eqNo;
		this.sEacIf = sEacIf;
		this.sCntCd = sCntCd;
		this.woNo = woNo;
		this.sFmDt = sFmDt;
		this.bkgScgAmt = bkgScgAmt;
		this.sYdCd = sYdCd;
		this.woAmt = woAmt;
		this.porNodCd = porNodCd;
		this.sLocCd = sLocCd;
		this.rhqCd = rhqCd;
		this.bkgCurrCd = bkgCurrCd;
		this.mnrFlgYdCd = mnrFlgYdCd;
		this.polNodCd = polNodCd;
		this.sCntrNo = sCntrNo;
		this.eqTpszCd = eqTpszCd;
		this.bkgNo = bkgNo;
		this.chk = chk;
		this.sRegOfcCd = sRegOfcCd;
		this.sWoFlg = sWoFlg;
		this.vndrSeq = vndrSeq;
		this.seq = seq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("wo_curr_cd", getWoCurrCd());
		this.hashColumns.put("reg_ofc_cd", getRegOfcCd());
		this.hashColumns.put("hngr_bar_amd_qty", getHngrBarAmdQty());
		this.hashColumns.put("oft_in", getOftIn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_scg_mix_flg", getBkgScgMixFlg());
		this.hashColumns.put("s_to_dt", getSToDt());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("s_eac_if", getSEacIf());
		this.hashColumns.put("s_cnt_cd", getSCntCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("s_fm_dt", getSFmDt());
		this.hashColumns.put("bkg_scg_amt", getBkgScgAmt());
		this.hashColumns.put("s_yd_cd", getSYdCd());
		this.hashColumns.put("wo_amt", getWoAmt());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("s_loc_cd", getSLocCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("bkg_curr_cd", getBkgCurrCd());
		this.hashColumns.put("mnr_flg_yd_cd", getMnrFlgYdCd());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("s_cntr_no", getSCntrNo());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("s_reg_ofc_cd", getSRegOfcCd());
		this.hashColumns.put("s_wo_flg", getSWoFlg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("seq", getSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("wo_curr_cd", "woCurrCd");
		this.hashFields.put("reg_ofc_cd", "regOfcCd");
		this.hashFields.put("hngr_bar_amd_qty", "hngrBarAmdQty");
		this.hashFields.put("oft_in", "oftIn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_scg_mix_flg", "bkgScgMixFlg");
		this.hashFields.put("s_to_dt", "sToDt");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("s_eac_if", "sEacIf");
		this.hashFields.put("s_cnt_cd", "sCntCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("s_fm_dt", "sFmDt");
		this.hashFields.put("bkg_scg_amt", "bkgScgAmt");
		this.hashFields.put("s_yd_cd", "sYdCd");
		this.hashFields.put("wo_amt", "woAmt");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("s_loc_cd", "sLocCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bkg_curr_cd", "bkgCurrCd");
		this.hashFields.put("mnr_flg_yd_cd", "mnrFlgYdCd");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("s_cntr_no", "sCntrNo");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("s_reg_ofc_cd", "sRegOfcCd");
		this.hashFields.put("s_wo_flg", "sWoFlg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("seq", "seq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return woCurrCd
	 */
	public String getWoCurrCd() {
		return this.woCurrCd;
	}
	
	/**
	 * Column Info
	 * @return regOfcCd
	 */
	public String getRegOfcCd() {
		return this.regOfcCd;
	}
	
	/**
	 * Column Info
	 * @return hngrBarAmdQty
	 */
	public String getHngrBarAmdQty() {
		return this.hngrBarAmdQty;
	}
	
	/**
	 * Column Info
	 * @return oftIn
	 */
	public String getOftIn() {
		return this.oftIn;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
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
	 * @return sCntCd
	 */
	public String getSCntCd() {
		return this.sCntCd;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
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
	 * @return sYdCd
	 */
	public String getSYdCd() {
		return this.sYdCd;
	}
	
	/**
	 * Column Info
	 * @return woAmt
	 */
	public String getWoAmt() {
		return this.woAmt;
	}
	
	/**
	 * Column Info
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}
	
	/**
	 * Column Info
	 * @return sLocCd
	 */
	public String getSLocCd() {
		return this.sLocCd;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCurrCd
	 */
	public String getBkgCurrCd() {
		return this.bkgCurrCd;
	}
	
	/**
	 * Column Info
	 * @return mnrFlgYdCd
	 */
	public String getMnrFlgYdCd() {
		return this.mnrFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return sRegOfcCd
	 */
	public String getSRegOfcCd() {
		return this.sRegOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sWoFlg
	 */
	public String getSWoFlg() {
		return this.sWoFlg;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @param woCurrCd
	 */
	public void setWoCurrCd(String woCurrCd) {
		this.woCurrCd = woCurrCd;
	}
	
	/**
	 * Column Info
	 * @param regOfcCd
	 */
	public void setRegOfcCd(String regOfcCd) {
		this.regOfcCd = regOfcCd;
	}
	
	/**
	 * Column Info
	 * @param hngrBarAmdQty
	 */
	public void setHngrBarAmdQty(String hngrBarAmdQty) {
		this.hngrBarAmdQty = hngrBarAmdQty;
	}
	
	/**
	 * Column Info
	 * @param oftIn
	 */
	public void setOftIn(String oftIn) {
		this.oftIn = oftIn;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
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
	 * @param sCntCd
	 */
	public void setSCntCd(String sCntCd) {
		this.sCntCd = sCntCd;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
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
	 * @param sYdCd
	 */
	public void setSYdCd(String sYdCd) {
		this.sYdCd = sYdCd;
	}
	
	/**
	 * Column Info
	 * @param woAmt
	 */
	public void setWoAmt(String woAmt) {
		this.woAmt = woAmt;
	}
	
	/**
	 * Column Info
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}
	
	/**
	 * Column Info
	 * @param sLocCd
	 */
	public void setSLocCd(String sLocCd) {
		this.sLocCd = sLocCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCurrCd
	 */
	public void setBkgCurrCd(String bkgCurrCd) {
		this.bkgCurrCd = bkgCurrCd;
	}
	
	/**
	 * Column Info
	 * @param mnrFlgYdCd
	 */
	public void setMnrFlgYdCd(String mnrFlgYdCd) {
		this.mnrFlgYdCd = mnrFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param sRegOfcCd
	 */
	public void setSRegOfcCd(String sRegOfcCd) {
		this.sRegOfcCd = sRegOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sWoFlg
	 */
	public void setSWoFlg(String sWoFlg) {
		this.sWoFlg = sWoFlg;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
		setWoCurrCd(JSPUtil.getParameter(request, prefix + "wo_curr_cd", ""));
		setRegOfcCd(JSPUtil.getParameter(request, prefix + "reg_ofc_cd", ""));
		setHngrBarAmdQty(JSPUtil.getParameter(request, prefix + "hngr_bar_amd_qty", ""));
		setOftIn(JSPUtil.getParameter(request, prefix + "oft_in", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgScgMixFlg(JSPUtil.getParameter(request, prefix + "bkg_scg_mix_flg", ""));
		setSToDt(JSPUtil.getParameter(request, prefix + "s_to_dt", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setSEacIf(JSPUtil.getParameter(request, prefix + "s_eac_if", ""));
		setSCntCd(JSPUtil.getParameter(request, prefix + "s_cnt_cd", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setSFmDt(JSPUtil.getParameter(request, prefix + "s_fm_dt", ""));
		setBkgScgAmt(JSPUtil.getParameter(request, prefix + "bkg_scg_amt", ""));
		setSYdCd(JSPUtil.getParameter(request, prefix + "s_yd_cd", ""));
		setWoAmt(JSPUtil.getParameter(request, prefix + "wo_amt", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setSLocCd(JSPUtil.getParameter(request, prefix + "s_loc_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setBkgCurrCd(JSPUtil.getParameter(request, prefix + "bkg_curr_cd", ""));
		setMnrFlgYdCd(JSPUtil.getParameter(request, prefix + "mnr_flg_yd_cd", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setSCntrNo(JSPUtil.getParameter(request, prefix + "s_cntr_no", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setSRegOfcCd(JSPUtil.getParameter(request, prefix + "s_reg_ofc_cd", ""));
		setSWoFlg(JSPUtil.getParameter(request, prefix + "s_wo_flg", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HbarInquiryByHistoryVO[]
	 */
	public HbarInquiryByHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HbarInquiryByHistoryVO[]
	 */
	public HbarInquiryByHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HbarInquiryByHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] woCurrCd = (JSPUtil.getParameter(request, prefix	+ "wo_curr_cd", length));
			String[] regOfcCd = (JSPUtil.getParameter(request, prefix	+ "reg_ofc_cd", length));
			String[] hngrBarAmdQty = (JSPUtil.getParameter(request, prefix	+ "hngr_bar_amd_qty", length));
			String[] oftIn = (JSPUtil.getParameter(request, prefix	+ "oft_in", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgScgMixFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_scg_mix_flg", length));
			String[] sToDt = (JSPUtil.getParameter(request, prefix	+ "s_to_dt", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] sEacIf = (JSPUtil.getParameter(request, prefix	+ "s_eac_if", length));
			String[] sCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cnt_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] sFmDt = (JSPUtil.getParameter(request, prefix	+ "s_fm_dt", length));
			String[] bkgScgAmt = (JSPUtil.getParameter(request, prefix	+ "bkg_scg_amt", length));
			String[] sYdCd = (JSPUtil.getParameter(request, prefix	+ "s_yd_cd", length));
			String[] woAmt = (JSPUtil.getParameter(request, prefix	+ "wo_amt", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] sLocCd = (JSPUtil.getParameter(request, prefix	+ "s_loc_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] bkgCurrCd = (JSPUtil.getParameter(request, prefix	+ "bkg_curr_cd", length));
			String[] mnrFlgYdCd = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_yd_cd", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] sCntrNo = (JSPUtil.getParameter(request, prefix	+ "s_cntr_no", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] sRegOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_reg_ofc_cd", length));
			String[] sWoFlg = (JSPUtil.getParameter(request, prefix	+ "s_wo_flg", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new HbarInquiryByHistoryVO();
				if (woCurrCd[i] != null)
					model.setWoCurrCd(woCurrCd[i]);
				if (regOfcCd[i] != null)
					model.setRegOfcCd(regOfcCd[i]);
				if (hngrBarAmdQty[i] != null)
					model.setHngrBarAmdQty(hngrBarAmdQty[i]);
				if (oftIn[i] != null)
					model.setOftIn(oftIn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgScgMixFlg[i] != null)
					model.setBkgScgMixFlg(bkgScgMixFlg[i]);
				if (sToDt[i] != null)
					model.setSToDt(sToDt[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (sEacIf[i] != null)
					model.setSEacIf(sEacIf[i]);
				if (sCntCd[i] != null)
					model.setSCntCd(sCntCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (sFmDt[i] != null)
					model.setSFmDt(sFmDt[i]);
				if (bkgScgAmt[i] != null)
					model.setBkgScgAmt(bkgScgAmt[i]);
				if (sYdCd[i] != null)
					model.setSYdCd(sYdCd[i]);
				if (woAmt[i] != null)
					model.setWoAmt(woAmt[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (sLocCd[i] != null)
					model.setSLocCd(sLocCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (bkgCurrCd[i] != null)
					model.setBkgCurrCd(bkgCurrCd[i]);
				if (mnrFlgYdCd[i] != null)
					model.setMnrFlgYdCd(mnrFlgYdCd[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (sCntrNo[i] != null)
					model.setSCntrNo(sCntrNo[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (sRegOfcCd[i] != null)
					model.setSRegOfcCd(sRegOfcCd[i]);
				if (sWoFlg[i] != null)
					model.setSWoFlg(sWoFlg[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHbarInquiryByHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HbarInquiryByHistoryVO[]
	 */
	public HbarInquiryByHistoryVO[] getHbarInquiryByHistoryVOs(){
		HbarInquiryByHistoryVO[] vos = (HbarInquiryByHistoryVO[])models.toArray(new HbarInquiryByHistoryVO[models.size()]);
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
		this.woCurrCd = this.woCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regOfcCd = this.regOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrBarAmdQty = this.hngrBarAmdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftIn = this.oftIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgScgMixFlg = this.bkgScgMixFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToDt = this.sToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacIf = this.sEacIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntCd = this.sCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmDt = this.sFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgScgAmt = this.bkgScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sYdCd = this.sYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woAmt = this.woAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLocCd = this.sLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCurrCd = this.bkgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgYdCd = this.mnrFlgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrNo = this.sCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRegOfcCd = this.sRegOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sWoFlg = this.sWoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
