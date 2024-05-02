/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AssetsOptionVO.java
*@FileTitle : AssetsOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.22
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.12.22 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AssetsOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AssetsOptionVO> models = new ArrayList<AssetsOptionVO>();
	
	/* Column Info */
	private String selMftrVndrSeq = null;
	/* Column Info */
	private String tllQty = null;
	/* Column Info */
	private String fmSerNo = null;
	/* Column Info */
	private String selLstmCd = null;
	/* Column Info */
	private String selMnfrYr = null;
	/* Column Info */
	private String muoQty = null;
	/* Column Info */
	private String donQty = null;
	/* Column Info */
	private String selColNm = null;
	/* Column Info */
	private String asetQty = null;
	/* Column Info */
	private String ctrtQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lstQty = null;
	/* Column Info */
	private String selToPrd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrPfxCd = null;
	/* Column Info */
	private String selFmPrd = null;
	/* Column Info */
	private String lotCntrPfxCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String selToSerNo = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String toSerNo = null;
	/* Column Info */
	private String selCntrTpszCd = null;
	/* Column Info */
	private String mftrVndrSeq = null;
	/* Column Info */
	private String fmPrd = null;
	/* Column Info */
	private String toPrd = null;
	/* Column Info */
	private String dioQty = null;
	/* Column Info */
	private String selLocTpCd = null;
	/* Column Info */
	private String scrQty = null;
	/* Column Info */
	private String lsoQty = null;
	/* Column Info */
	private String selFmSerNo = null;
	/* Column Info */
	private String mftDt = null;
	/* Column Info */
	private String selLocCd = null;
	/* Column Info */
	private String actQty = null;
	/* Column Info */
	private String sldQty = null;
	/* Column Info */
	private String selCntrPfxCd = null;
	/* Column Info */
	private String sboQty = null;
	/* Column Info */
	private String locTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AssetsOptionVO() {}

	public AssetsOptionVO(String ibflag, String pagerows, String tllQty, String fmSerNo, String donQty, String muoQty, String asetQty, String ctrtQty, String lstQty, String locCd, String cntrPfxCd, String lotCntrPfxCd, String cntrTpszCd, String lstmCd, String toSerNo, String mftrVndrSeq, String fmPrd, String toPrd, String dioQty, String scrQty, String lsoQty, String mftDt, String actQty, String sldQty, String sboQty, String locTpCd, String selMnfrYr, String selFmPrd, String selToPrd, String selCntrTpszCd, String selLstmCd, String selCntrPfxCd, String selFmSerNo, String selToSerNo, String selMftrVndrSeq, String selLocTpCd, String selLocCd, String selColNm) {
		this.selMftrVndrSeq = selMftrVndrSeq;
		this.tllQty = tllQty;
		this.fmSerNo = fmSerNo;
		this.selLstmCd = selLstmCd;
		this.selMnfrYr = selMnfrYr;
		this.muoQty = muoQty;
		this.donQty = donQty;
		this.selColNm = selColNm;
		this.asetQty = asetQty;
		this.ctrtQty = ctrtQty;
		this.pagerows = pagerows;
		this.lstQty = lstQty;
		this.selToPrd = selToPrd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.cntrPfxCd = cntrPfxCd;
		this.selFmPrd = selFmPrd;
		this.lotCntrPfxCd = lotCntrPfxCd;
		this.cntrTpszCd = cntrTpszCd;
		this.selToSerNo = selToSerNo;
		this.lstmCd = lstmCd;
		this.toSerNo = toSerNo;
		this.selCntrTpszCd = selCntrTpszCd;
		this.mftrVndrSeq = mftrVndrSeq;
		this.fmPrd = fmPrd;
		this.toPrd = toPrd;
		this.dioQty = dioQty;
		this.selLocTpCd = selLocTpCd;
		this.scrQty = scrQty;
		this.lsoQty = lsoQty;
		this.selFmSerNo = selFmSerNo;
		this.mftDt = mftDt;
		this.selLocCd = selLocCd;
		this.actQty = actQty;
		this.sldQty = sldQty;
		this.selCntrPfxCd = selCntrPfxCd;
		this.sboQty = sboQty;
		this.locTpCd = locTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sel_mftr_vndr_seq", getSelMftrVndrSeq());
		this.hashColumns.put("tll_qty", getTllQty());
		this.hashColumns.put("fm_ser_no", getFmSerNo());
		this.hashColumns.put("sel_lstm_cd", getSelLstmCd());
		this.hashColumns.put("sel_mnfr_yr", getSelMnfrYr());
		this.hashColumns.put("muo_qty", getMuoQty());
		this.hashColumns.put("don_qty", getDonQty());
		this.hashColumns.put("sel_col_nm", getSelColNm());
		this.hashColumns.put("aset_qty", getAsetQty());
		this.hashColumns.put("ctrt_qty", getCtrtQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lst_qty", getLstQty());
		this.hashColumns.put("sel_to_prd", getSelToPrd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_pfx_cd", getCntrPfxCd());
		this.hashColumns.put("sel_fm_prd", getSelFmPrd());
		this.hashColumns.put("lot_cntr_pfx_cd", getLotCntrPfxCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("sel_to_ser_no", getSelToSerNo());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("to_ser_no", getToSerNo());
		this.hashColumns.put("sel_cntr_tpsz_cd", getSelCntrTpszCd());
		this.hashColumns.put("mftr_vndr_seq", getMftrVndrSeq());
		this.hashColumns.put("fm_prd", getFmPrd());
		this.hashColumns.put("to_prd", getToPrd());
		this.hashColumns.put("dio_qty", getDioQty());
		this.hashColumns.put("sel_loc_tp_cd", getSelLocTpCd());
		this.hashColumns.put("scr_qty", getScrQty());
		this.hashColumns.put("lso_qty", getLsoQty());
		this.hashColumns.put("sel_fm_ser_no", getSelFmSerNo());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("sel_loc_cd", getSelLocCd());
		this.hashColumns.put("act_qty", getActQty());
		this.hashColumns.put("sld_qty", getSldQty());
		this.hashColumns.put("sel_cntr_pfx_cd", getSelCntrPfxCd());
		this.hashColumns.put("sbo_qty", getSboQty());
		this.hashColumns.put("loc_tp_cd", getLocTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sel_mftr_vndr_seq", "selMftrVndrSeq");
		this.hashFields.put("tll_qty", "tllQty");
		this.hashFields.put("fm_ser_no", "fmSerNo");
		this.hashFields.put("sel_lstm_cd", "selLstmCd");
		this.hashFields.put("sel_mnfr_yr", "selMnfrYr");
		this.hashFields.put("muo_qty", "muoQty");
		this.hashFields.put("don_qty", "donQty");
		this.hashFields.put("sel_col_nm", "selColNm");
		this.hashFields.put("aset_qty", "asetQty");
		this.hashFields.put("ctrt_qty", "ctrtQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lst_qty", "lstQty");
		this.hashFields.put("sel_to_prd", "selToPrd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_pfx_cd", "cntrPfxCd");
		this.hashFields.put("sel_fm_prd", "selFmPrd");
		this.hashFields.put("lot_cntr_pfx_cd", "lotCntrPfxCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("sel_to_ser_no", "selToSerNo");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("to_ser_no", "toSerNo");
		this.hashFields.put("sel_cntr_tpsz_cd", "selCntrTpszCd");
		this.hashFields.put("mftr_vndr_seq", "mftrVndrSeq");
		this.hashFields.put("fm_prd", "fmPrd");
		this.hashFields.put("to_prd", "toPrd");
		this.hashFields.put("dio_qty", "dioQty");
		this.hashFields.put("sel_loc_tp_cd", "selLocTpCd");
		this.hashFields.put("scr_qty", "scrQty");
		this.hashFields.put("lso_qty", "lsoQty");
		this.hashFields.put("sel_fm_ser_no", "selFmSerNo");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("sel_loc_cd", "selLocCd");
		this.hashFields.put("act_qty", "actQty");
		this.hashFields.put("sld_qty", "sldQty");
		this.hashFields.put("sel_cntr_pfx_cd", "selCntrPfxCd");
		this.hashFields.put("sbo_qty", "sboQty");
		this.hashFields.put("loc_tp_cd", "locTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return selMftrVndrSeq
	 */
	public String getSelMftrVndrSeq() {
		return this.selMftrVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return tllQty
	 */
	public String getTllQty() {
		return this.tllQty;
	}
	
	/**
	 * Column Info
	 * @return fmSerNo
	 */
	public String getFmSerNo() {
		return this.fmSerNo;
	}
	
	/**
	 * Column Info
	 * @return selLstmCd
	 */
	public String getSelLstmCd() {
		return this.selLstmCd;
	}
	
	/**
	 * Column Info
	 * @return selMnfrYr
	 */
	public String getSelMnfrYr() {
		return this.selMnfrYr;
	}
	
	/**
	 * Column Info
	 * @return muoQty
	 */
	public String getMuoQty() {
		return this.muoQty;
	}
	
	/**
	 * Column Info
	 * @return donQty
	 */
	public String getDonQty() {
		return this.donQty;
	}
	
	/**
	 * Column Info
	 * @return selColNm
	 */
	public String getSelColNm() {
		return this.selColNm;
	}
	
	/**
	 * Column Info
	 * @return asetQty
	 */
	public String getAsetQty() {
		return this.asetQty;
	}
	
	/**
	 * Column Info
	 * @return ctrtQty
	 */
	public String getCtrtQty() {
		return this.ctrtQty;
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
	 * @return lstQty
	 */
	public String getLstQty() {
		return this.lstQty;
	}
	
	/**
	 * Column Info
	 * @return selToPrd
	 */
	public String getSelToPrd() {
		return this.selToPrd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return cntrPfxCd
	 */
	public String getCntrPfxCd() {
		return this.cntrPfxCd;
	}
	
	/**
	 * Column Info
	 * @return selFmPrd
	 */
	public String getSelFmPrd() {
		return this.selFmPrd;
	}
	
	/**
	 * Column Info
	 * @return lotCntrPfxCd
	 */
	public String getLotCntrPfxCd() {
		return this.lotCntrPfxCd;
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
	 * @return selToSerNo
	 */
	public String getSelToSerNo() {
		return this.selToSerNo;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return toSerNo
	 */
	public String getToSerNo() {
		return this.toSerNo;
	}
	
	/**
	 * Column Info
	 * @return selCntrTpszCd
	 */
	public String getSelCntrTpszCd() {
		return this.selCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return mftrVndrSeq
	 */
	public String getMftrVndrSeq() {
		return this.mftrVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return fmPrd
	 */
	public String getFmPrd() {
		return this.fmPrd;
	}
	
	/**
	 * Column Info
	 * @return toPrd
	 */
	public String getToPrd() {
		return this.toPrd;
	}
	
	/**
	 * Column Info
	 * @return dioQty
	 */
	public String getDioQty() {
		return this.dioQty;
	}
	
	/**
	 * Column Info
	 * @return selLocTpCd
	 */
	public String getSelLocTpCd() {
		return this.selLocTpCd;
	}
	
	/**
	 * Column Info
	 * @return scrQty
	 */
	public String getScrQty() {
		return this.scrQty;
	}
	
	/**
	 * Column Info
	 * @return lsoQty
	 */
	public String getLsoQty() {
		return this.lsoQty;
	}
	
	/**
	 * Column Info
	 * @return selFmSerNo
	 */
	public String getSelFmSerNo() {
		return this.selFmSerNo;
	}
	
	/**
	 * Column Info
	 * @return mftDt
	 */
	public String getMftDt() {
		return this.mftDt;
	}
	
	/**
	 * Column Info
	 * @return selLocCd
	 */
	public String getSelLocCd() {
		return this.selLocCd;
	}
	
	/**
	 * Column Info
	 * @return actQty
	 */
	public String getActQty() {
		return this.actQty;
	}
	
	/**
	 * Column Info
	 * @return sldQty
	 */
	public String getSldQty() {
		return this.sldQty;
	}
	
	/**
	 * Column Info
	 * @return selCntrPfxCd
	 */
	public String getSelCntrPfxCd() {
		return this.selCntrPfxCd;
	}
	
	/**
	 * Column Info
	 * @return sboQty
	 */
	public String getSboQty() {
		return this.sboQty;
	}
	
	/**
	 * Column Info
	 * @return locTpCd
	 */
	public String getLocTpCd() {
		return this.locTpCd;
	}
	

	/**
	 * Column Info
	 * @param selMftrVndrSeq
	 */
	public void setSelMftrVndrSeq(String selMftrVndrSeq) {
		this.selMftrVndrSeq = selMftrVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param tllQty
	 */
	public void setTllQty(String tllQty) {
		this.tllQty = tllQty;
	}
	
	/**
	 * Column Info
	 * @param fmSerNo
	 */
	public void setFmSerNo(String fmSerNo) {
		this.fmSerNo = fmSerNo;
	}
	
	/**
	 * Column Info
	 * @param selLstmCd
	 */
	public void setSelLstmCd(String selLstmCd) {
		this.selLstmCd = selLstmCd;
	}
	
	/**
	 * Column Info
	 * @param selMnfrYr
	 */
	public void setSelMnfrYr(String selMnfrYr) {
		this.selMnfrYr = selMnfrYr;
	}
	
	/**
	 * Column Info
	 * @param muoQty
	 */
	public void setMuoQty(String muoQty) {
		this.muoQty = muoQty;
	}
	
	/**
	 * Column Info
	 * @param donQty
	 */
	public void setDonQty(String donQty) {
		this.donQty = donQty;
	}
	
	/**
	 * Column Info
	 * @param selColNm
	 */
	public void setSelColNm(String selColNm) {
		this.selColNm = selColNm;
	}
	
	/**
	 * Column Info
	 * @param asetQty
	 */
	public void setAsetQty(String asetQty) {
		this.asetQty = asetQty;
	}
	
	/**
	 * Column Info
	 * @param ctrtQty
	 */
	public void setCtrtQty(String ctrtQty) {
		this.ctrtQty = ctrtQty;
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
	 * @param lstQty
	 */
	public void setLstQty(String lstQty) {
		this.lstQty = lstQty;
	}
	
	/**
	 * Column Info
	 * @param selToPrd
	 */
	public void setSelToPrd(String selToPrd) {
		this.selToPrd = selToPrd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param cntrPfxCd
	 */
	public void setCntrPfxCd(String cntrPfxCd) {
		this.cntrPfxCd = cntrPfxCd;
	}
	
	/**
	 * Column Info
	 * @param selFmPrd
	 */
	public void setSelFmPrd(String selFmPrd) {
		this.selFmPrd = selFmPrd;
	}
	
	/**
	 * Column Info
	 * @param lotCntrPfxCd
	 */
	public void setLotCntrPfxCd(String lotCntrPfxCd) {
		this.lotCntrPfxCd = lotCntrPfxCd;
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
	 * @param selToSerNo
	 */
	public void setSelToSerNo(String selToSerNo) {
		this.selToSerNo = selToSerNo;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param toSerNo
	 */
	public void setToSerNo(String toSerNo) {
		this.toSerNo = toSerNo;
	}
	
	/**
	 * Column Info
	 * @param selCntrTpszCd
	 */
	public void setSelCntrTpszCd(String selCntrTpszCd) {
		this.selCntrTpszCd = selCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param mftrVndrSeq
	 */
	public void setMftrVndrSeq(String mftrVndrSeq) {
		this.mftrVndrSeq = mftrVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param fmPrd
	 */
	public void setFmPrd(String fmPrd) {
		this.fmPrd = fmPrd;
	}
	
	/**
	 * Column Info
	 * @param toPrd
	 */
	public void setToPrd(String toPrd) {
		this.toPrd = toPrd;
	}
	
	/**
	 * Column Info
	 * @param dioQty
	 */
	public void setDioQty(String dioQty) {
		this.dioQty = dioQty;
	}
	
	/**
	 * Column Info
	 * @param selLocTpCd
	 */
	public void setSelLocTpCd(String selLocTpCd) {
		this.selLocTpCd = selLocTpCd;
	}
	
	/**
	 * Column Info
	 * @param scrQty
	 */
	public void setScrQty(String scrQty) {
		this.scrQty = scrQty;
	}
	
	/**
	 * Column Info
	 * @param lsoQty
	 */
	public void setLsoQty(String lsoQty) {
		this.lsoQty = lsoQty;
	}
	
	/**
	 * Column Info
	 * @param selFmSerNo
	 */
	public void setSelFmSerNo(String selFmSerNo) {
		this.selFmSerNo = selFmSerNo;
	}
	
	/**
	 * Column Info
	 * @param mftDt
	 */
	public void setMftDt(String mftDt) {
		this.mftDt = mftDt;
	}
	
	/**
	 * Column Info
	 * @param selLocCd
	 */
	public void setSelLocCd(String selLocCd) {
		this.selLocCd = selLocCd;
	}
	
	/**
	 * Column Info
	 * @param actQty
	 */
	public void setActQty(String actQty) {
		this.actQty = actQty;
	}
	
	/**
	 * Column Info
	 * @param sldQty
	 */
	public void setSldQty(String sldQty) {
		this.sldQty = sldQty;
	}
	
	/**
	 * Column Info
	 * @param selCntrPfxCd
	 */
	public void setSelCntrPfxCd(String selCntrPfxCd) {
		this.selCntrPfxCd = selCntrPfxCd;
	}
	
	/**
	 * Column Info
	 * @param sboQty
	 */
	public void setSboQty(String sboQty) {
		this.sboQty = sboQty;
	}
	
	/**
	 * Column Info
	 * @param locTpCd
	 */
	public void setLocTpCd(String locTpCd) {
		this.locTpCd = locTpCd;
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
		setSelMftrVndrSeq(JSPUtil.getParameter(request, prefix + "sel_mftr_vndr_seq", ""));
		setTllQty(JSPUtil.getParameter(request, prefix + "tll_qty", ""));
		setFmSerNo(JSPUtil.getParameter(request, prefix + "fm_ser_no", ""));
		setSelLstmCd(JSPUtil.getParameter(request, prefix + "sel_lstm_cd", ""));
		setSelMnfrYr(JSPUtil.getParameter(request, prefix + "sel_mnfr_yr", ""));
		setMuoQty(JSPUtil.getParameter(request, prefix + "muo_qty", ""));
		setDonQty(JSPUtil.getParameter(request, prefix + "don_qty", ""));
		setSelColNm(JSPUtil.getParameter(request, prefix + "sel_col_nm", ""));
		setAsetQty(JSPUtil.getParameter(request, prefix + "aset_qty", ""));
		setCtrtQty(JSPUtil.getParameter(request, prefix + "ctrt_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLstQty(JSPUtil.getParameter(request, prefix + "lst_qty", ""));
		setSelToPrd(JSPUtil.getParameter(request, prefix + "sel_to_prd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrPfxCd(JSPUtil.getParameter(request, prefix + "cntr_pfx_cd", ""));
		setSelFmPrd(JSPUtil.getParameter(request, prefix + "sel_fm_prd", ""));
		setLotCntrPfxCd(JSPUtil.getParameter(request, prefix + "lot_cntr_pfx_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setSelToSerNo(JSPUtil.getParameter(request, prefix + "sel_to_ser_no", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setToSerNo(JSPUtil.getParameter(request, prefix + "to_ser_no", ""));
		setSelCntrTpszCd(JSPUtil.getParameter(request, prefix + "sel_cntr_tpsz_cd", ""));
		setMftrVndrSeq(JSPUtil.getParameter(request, prefix + "mftr_vndr_seq", ""));
		setFmPrd(JSPUtil.getParameter(request, prefix + "fm_prd", ""));
		setToPrd(JSPUtil.getParameter(request, prefix + "to_prd", ""));
		setDioQty(JSPUtil.getParameter(request, prefix + "dio_qty", ""));
		setSelLocTpCd(JSPUtil.getParameter(request, prefix + "sel_loc_tp_cd", ""));
		setScrQty(JSPUtil.getParameter(request, prefix + "scr_qty", ""));
		setLsoQty(JSPUtil.getParameter(request, prefix + "lso_qty", ""));
		setSelFmSerNo(JSPUtil.getParameter(request, prefix + "sel_fm_ser_no", ""));
		setMftDt(JSPUtil.getParameter(request, prefix + "mft_dt", ""));
		setSelLocCd(JSPUtil.getParameter(request, prefix + "sel_loc_cd", ""));
		setActQty(JSPUtil.getParameter(request, prefix + "act_qty", ""));
		setSldQty(JSPUtil.getParameter(request, prefix + "sld_qty", ""));
		setSelCntrPfxCd(JSPUtil.getParameter(request, prefix + "sel_cntr_pfx_cd", ""));
		setSboQty(JSPUtil.getParameter(request, prefix + "sbo_qty", ""));
		setLocTpCd(JSPUtil.getParameter(request, prefix + "loc_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AssetsOptionVO[]
	 */
	public AssetsOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AssetsOptionVO[]
	 */
	public AssetsOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AssetsOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] selMftrVndrSeq = (JSPUtil.getParameter(request, prefix	+ "sel_mftr_vndr_seq", length));
			String[] tllQty = (JSPUtil.getParameter(request, prefix	+ "tll_qty", length));
			String[] fmSerNo = (JSPUtil.getParameter(request, prefix	+ "fm_ser_no", length));
			String[] selLstmCd = (JSPUtil.getParameter(request, prefix	+ "sel_lstm_cd", length));
			String[] selMnfrYr = (JSPUtil.getParameter(request, prefix	+ "sel_mnfr_yr", length));
			String[] muoQty = (JSPUtil.getParameter(request, prefix	+ "muo_qty", length));
			String[] donQty = (JSPUtil.getParameter(request, prefix	+ "don_qty", length));
			String[] selColNm = (JSPUtil.getParameter(request, prefix	+ "sel_col_nm", length));
			String[] asetQty = (JSPUtil.getParameter(request, prefix	+ "aset_qty", length));
			String[] ctrtQty = (JSPUtil.getParameter(request, prefix	+ "ctrt_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lstQty = (JSPUtil.getParameter(request, prefix	+ "lst_qty", length));
			String[] selToPrd = (JSPUtil.getParameter(request, prefix	+ "sel_to_prd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrPfxCd = (JSPUtil.getParameter(request, prefix	+ "cntr_pfx_cd", length));
			String[] selFmPrd = (JSPUtil.getParameter(request, prefix	+ "sel_fm_prd", length));
			String[] lotCntrPfxCd = (JSPUtil.getParameter(request, prefix	+ "lot_cntr_pfx_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] selToSerNo = (JSPUtil.getParameter(request, prefix	+ "sel_to_ser_no", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] toSerNo = (JSPUtil.getParameter(request, prefix	+ "to_ser_no", length));
			String[] selCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "sel_cntr_tpsz_cd", length));
			String[] mftrVndrSeq = (JSPUtil.getParameter(request, prefix	+ "mftr_vndr_seq", length));
			String[] fmPrd = (JSPUtil.getParameter(request, prefix	+ "fm_prd", length));
			String[] toPrd = (JSPUtil.getParameter(request, prefix	+ "to_prd", length));
			String[] dioQty = (JSPUtil.getParameter(request, prefix	+ "dio_qty", length));
			String[] selLocTpCd = (JSPUtil.getParameter(request, prefix	+ "sel_loc_tp_cd", length));
			String[] scrQty = (JSPUtil.getParameter(request, prefix	+ "scr_qty", length));
			String[] lsoQty = (JSPUtil.getParameter(request, prefix	+ "lso_qty", length));
			String[] selFmSerNo = (JSPUtil.getParameter(request, prefix	+ "sel_fm_ser_no", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] selLocCd = (JSPUtil.getParameter(request, prefix	+ "sel_loc_cd", length));
			String[] actQty = (JSPUtil.getParameter(request, prefix	+ "act_qty", length));
			String[] sldQty = (JSPUtil.getParameter(request, prefix	+ "sld_qty", length));
			String[] selCntrPfxCd = (JSPUtil.getParameter(request, prefix	+ "sel_cntr_pfx_cd", length));
			String[] sboQty = (JSPUtil.getParameter(request, prefix	+ "sbo_qty", length));
			String[] locTpCd = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AssetsOptionVO();
				if (selMftrVndrSeq[i] != null)
					model.setSelMftrVndrSeq(selMftrVndrSeq[i]);
				if (tllQty[i] != null)
					model.setTllQty(tllQty[i]);
				if (fmSerNo[i] != null)
					model.setFmSerNo(fmSerNo[i]);
				if (selLstmCd[i] != null)
					model.setSelLstmCd(selLstmCd[i]);
				if (selMnfrYr[i] != null)
					model.setSelMnfrYr(selMnfrYr[i]);
				if (muoQty[i] != null)
					model.setMuoQty(muoQty[i]);
				if (donQty[i] != null)
					model.setDonQty(donQty[i]);
				if (selColNm[i] != null)
					model.setSelColNm(selColNm[i]);
				if (asetQty[i] != null)
					model.setAsetQty(asetQty[i]);
				if (ctrtQty[i] != null)
					model.setCtrtQty(ctrtQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lstQty[i] != null)
					model.setLstQty(lstQty[i]);
				if (selToPrd[i] != null)
					model.setSelToPrd(selToPrd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrPfxCd[i] != null)
					model.setCntrPfxCd(cntrPfxCd[i]);
				if (selFmPrd[i] != null)
					model.setSelFmPrd(selFmPrd[i]);
				if (lotCntrPfxCd[i] != null)
					model.setLotCntrPfxCd(lotCntrPfxCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (selToSerNo[i] != null)
					model.setSelToSerNo(selToSerNo[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (toSerNo[i] != null)
					model.setToSerNo(toSerNo[i]);
				if (selCntrTpszCd[i] != null)
					model.setSelCntrTpszCd(selCntrTpszCd[i]);
				if (mftrVndrSeq[i] != null)
					model.setMftrVndrSeq(mftrVndrSeq[i]);
				if (fmPrd[i] != null)
					model.setFmPrd(fmPrd[i]);
				if (toPrd[i] != null)
					model.setToPrd(toPrd[i]);
				if (dioQty[i] != null)
					model.setDioQty(dioQty[i]);
				if (selLocTpCd[i] != null)
					model.setSelLocTpCd(selLocTpCd[i]);
				if (scrQty[i] != null)
					model.setScrQty(scrQty[i]);
				if (lsoQty[i] != null)
					model.setLsoQty(lsoQty[i]);
				if (selFmSerNo[i] != null)
					model.setSelFmSerNo(selFmSerNo[i]);
				if (mftDt[i] != null)
					model.setMftDt(mftDt[i]);
				if (selLocCd[i] != null)
					model.setSelLocCd(selLocCd[i]);
				if (actQty[i] != null)
					model.setActQty(actQty[i]);
				if (sldQty[i] != null)
					model.setSldQty(sldQty[i]);
				if (selCntrPfxCd[i] != null)
					model.setSelCntrPfxCd(selCntrPfxCd[i]);
				if (sboQty[i] != null)
					model.setSboQty(sboQty[i]);
				if (locTpCd[i] != null)
					model.setLocTpCd(locTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAssetsOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AssetsOptionVO[]
	 */
	public AssetsOptionVO[] getAssetsOptionVOs(){
		AssetsOptionVO[] vos = (AssetsOptionVO[])models.toArray(new AssetsOptionVO[models.size()]);
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
		this.selMftrVndrSeq = this.selMftrVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tllQty = this.tllQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSerNo = this.fmSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selLstmCd = this.selLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selMnfrYr = this.selMnfrYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.muoQty = this.muoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.donQty = this.donQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selColNm = this.selColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetQty = this.asetQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtQty = this.ctrtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstQty = this.lstQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selToPrd = this.selToPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPfxCd = this.cntrPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selFmPrd = this.selFmPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotCntrPfxCd = this.lotCntrPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selToSerNo = this.selToSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSerNo = this.toSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selCntrTpszCd = this.selCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftrVndrSeq = this.mftrVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrd = this.fmPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrd = this.toPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dioQty = this.dioQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selLocTpCd = this.selLocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrQty = this.scrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsoQty = this.lsoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selFmSerNo = this.selFmSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selLocCd = this.selLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actQty = this.actQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sldQty = this.sldQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selCntrPfxCd = this.selCntrPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sboQty = this.sboQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCd = this.locTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
