/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyBkgListVO.java
*@FileTitle : EmptyBkgListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2010.01.19 김병규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EmptyBkgListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L; 
	
	private Collection<EmptyBkgListVO> models = new ArrayList<EmptyBkgListVO>();
	
	/* Column Info */
	private String cntrAttachDate = null;
	/* Column Info */
	private String emtDesc = null;
	/* Column Info */
	private String ts = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String emt = null;
	/* Column Info */
	private String indDesc = null;
	/* Column Info */
	private String cntrVolumn = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String d7 = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String d2 = null;
	/* Column Info */
	private String ind = null;
	/* Column Info */
	private String a2 = null;
	/* Column Info */
	private String bundle = null;
	/* Column Info */
	private String a4 = null;
	/* Column Info */
	private String f2 = null;
	/* Column Info */
	private String f5 = null;
	/* Column Info */
	private String s4 = null;
	/* Column Info */
	private String f4 = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String feu = null;
	/* Column Info */
	private String s2 = null;
	/* Column Info */
	private String o2 = null;
	/* Column Info */
	private String bookingDate = null;
	/* Column Info */
	private String o4 = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String r2 = null;
	/* Column Info */
	private String r4 = null;
	/* Column Info */
	private String r5 = null;
	/* Column Info */
	private String rsmOfcCd = null;
	/* Column Info */
	private String polEtdDt = null;
	/* Column Info */
	private String polAtdDt = null;
	/* Column Info */
	private String podEtaDt = null;
	/* Column Info */
	private String podAtaDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EmptyBkgListVO() {}

	public EmptyBkgListVO(String ibflag, String pagerows, String bkgNo, String blNo, String ind, String indDesc, String bundle, String ts, String vvd, String lane, String emt, String emtDesc, String polCd, String podCd, String teu, String feu, String bkgOfcCd, String cntrVolumn, String bookingDate, String cntrAttachDate, String d2, String d4, String d5, String d7, String r2, String r4, String r5, String f2, String f4, String f5, String o2, String o4, String a2, String a4, String s2, String s4, String remark, String rsmOfcCd
			, String polEtdDt, String polAtdDt, String podEtaDt, String podAtaDt) {
		this.cntrAttachDate = cntrAttachDate;
		this.emtDesc = emtDesc;
		this.ts = ts;
		this.remark = remark;
		this.emt = emt;
		this.indDesc = indDesc;
		this.cntrVolumn = cntrVolumn;
		this.d5 = d5;
		this.blNo = blNo;
		this.d4 = d4;
		this.d7 = d7;
		this.lane = lane;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.d2 = d2;
		this.ind = ind;
		this.a2 = a2;
		this.bundle = bundle;
		this.a4 = a4;
		this.f2 = f2;
		this.f5 = f5;
		this.s4 = s4;
		this.f4 = f4;
		this.bkgOfcCd = bkgOfcCd;
		this.feu = feu;
		this.s2 = s2;
		this.o2 = o2;
		this.bookingDate = bookingDate;
		this.o4 = o4;
		this.vvd = vvd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.teu = teu;
		this.r2 = r2;
		this.r4 = r4;
		this.r5 = r5;
		this.rsmOfcCd = rsmOfcCd;
		this.polEtdDt = polEtdDt;
		this.polAtdDt = polAtdDt;
		this.podEtaDt = podEtaDt;
		this.podAtaDt = podAtaDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_attach_date", getCntrAttachDate());
		this.hashColumns.put("emt_desc", getEmtDesc());
		this.hashColumns.put("ts", getTs());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("emt", getEmt());
		this.hashColumns.put("ind_desc", getIndDesc());
		this.hashColumns.put("cntr_volumn", getCntrVolumn());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("d7", getD7());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("ind", getInd());
		this.hashColumns.put("a2", getA2());
		this.hashColumns.put("bundle", getBundle());
		this.hashColumns.put("a4", getA4());
		this.hashColumns.put("f2", getF2());
		this.hashColumns.put("f5", getF5());
		this.hashColumns.put("s4", getS4());
		this.hashColumns.put("f4", getF4());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("feu", getFeu());
		this.hashColumns.put("s2", getS2());
		this.hashColumns.put("o2", getO2());
		this.hashColumns.put("booking_date", getBookingDate());
		this.hashColumns.put("o4", getO4());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("r2", getR2());
		this.hashColumns.put("r4", getR4());
		this.hashColumns.put("r5", getR5());
		this.hashColumns.put("rsm_ofc_cd", getRsmOfcCd());
		this.hashColumns.put("pol_etd_dt", getPolEtdDt());
		this.hashColumns.put("pol_atd_dt", getPolAtdDt());
		this.hashColumns.put("pod_eta_dt", getPodEtaDt());
		this.hashColumns.put("pod_ata_dt", getPodAtaDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_attach_date", "cntrAttachDate");
		this.hashFields.put("emt_desc", "emtDesc");
		this.hashFields.put("ts", "ts");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("emt", "emt");
		this.hashFields.put("ind_desc", "indDesc");
		this.hashFields.put("cntr_volumn", "cntrVolumn");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("ind", "ind");
		this.hashFields.put("a2", "a2");
		this.hashFields.put("bundle", "bundle");
		this.hashFields.put("a4", "a4");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("f5", "f5");
		this.hashFields.put("s4", "s4");
		this.hashFields.put("f4", "f4");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("feu", "feu");
		this.hashFields.put("s2", "s2");
		this.hashFields.put("o2", "o2");
		this.hashFields.put("booking_date", "bookingDate");
		this.hashFields.put("o4", "o4");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("r4", "r4");
		this.hashFields.put("r5", "r5");
		this.hashFields.put("rsm_ofc_cd", "rsmOfcCd");
		this.hashFields.put("pol_etd_dt", "polEtdDt");
		this.hashFields.put("pol_atd_dt", "polAtdDt");
		this.hashFields.put("pod_eta_dt", "podEtaDt");
		this.hashFields.put("pod_ata_dt", "podAtaDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrAttachDate
	 */
	public String getCntrAttachDate() {
		return this.cntrAttachDate;
	}
	
	/**
	 * Column Info
	 * @return emtDesc
	 */
	public String getEmtDesc() {
		return this.emtDesc;
	}
	
	/**
	 * Column Info
	 * @return ts
	 */
	public String getTs() {
		return this.ts;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return emt
	 */
	public String getEmt() {
		return this.emt;
	}
	
	/**
	 * Column Info
	 * @return indDesc
	 */
	public String getIndDesc() {
		return this.indDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrVolumn
	 */
	public String getCntrVolumn() {
		return this.cntrVolumn;
	}
	
	/**
	 * Column Info
	 * @return d5
	 */
	public String getD5() {
		return this.d5;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return d4
	 */
	public String getD4() {
		return this.d4;
	}
	
	/**
	 * Column Info
	 * @return d7
	 */
	public String getD7() {
		return this.d7;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return d2
	 */
	public String getD2() {
		return this.d2;
	}
	
	/**
	 * Column Info
	 * @return ind
	 */
	public String getInd() {
		return this.ind;
	}
	
	/**
	 * Column Info
	 * @return a2
	 */
	public String getA2() {
		return this.a2;
	}
	
	/**
	 * Column Info
	 * @return bundle
	 */
	public String getBundle() {
		return this.bundle;
	}
	
	/**
	 * Column Info
	 * @return a4
	 */
	public String getA4() {
		return this.a4;
	}
	
	/**
	 * Column Info
	 * @return f2
	 */
	public String getF2() {
		return this.f2;
	}
	
	/**
	 * Column Info
	 * @return f5
	 */
	public String getF5() {
		return this.f5;
	}
	
	/**
	 * Column Info
	 * @return s4
	 */
	public String getS4() {
		return this.s4;
	}
	
	/**
	 * Column Info
	 * @return f4
	 */
	public String getF4() {
		return this.f4;
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
	 * @return feu
	 */
	public String getFeu() {
		return this.feu;
	}
	
	/**
	 * Column Info
	 * @return s2
	 */
	public String getS2() {
		return this.s2;
	}
	
	/**
	 * Column Info
	 * @return o2
	 */
	public String getO2() {
		return this.o2;
	}
	
	/**
	 * Column Info
	 * @return bookingDate
	 */
	public String getBookingDate() {
		return this.bookingDate;
	}
	
	/**
	 * Column Info
	 * @return o4
	 */
	public String getO4() {
		return this.o4;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	
	/**
	 * Column Info
	 * @return r2
	 */
	public String getR2() {
		return this.r2;
	}
	
	/**
	 * Column Info
	 * @return r4
	 */
	public String getR4() {
		return this.r4;
	}
	
	/**
	 * Column Info
	 * @return r5
	 */
	public String getR5() {
		return this.r5;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getRsmOfcCd() {
		return this.rsmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return polEtdDt
	 */
	public String getPolEtdDt() {
		return this.polEtdDt;
	}
	
	/**
	 * Column Info
	 * @return polAtdDt
	 */
	public String getPolAtdDt() {
		return this.polAtdDt;
	}
	
	/**
	 * Column Info
	 * @return podEtaDt
	 */
	public String getPodEtaDt() {
		return this.podEtaDt;
	}
	
	/**
	 * Column Info
	 * @return podAtaDt
	 */
	public String getPodAtaDt() {
		return this.podAtaDt;
	}
	
	

	/**
	 * Column Info
	 * @param cntrAttachDate
	 */
	public void setCntrAttachDate(String cntrAttachDate) {
		this.cntrAttachDate = cntrAttachDate;
	}
	
	/**
	 * Column Info
	 * @param emtDesc
	 */
	public void setEmtDesc(String emtDesc) {
		this.emtDesc = emtDesc;
	}
	
	/**
	 * Column Info
	 * @param ts
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param emt
	 */
	public void setEmt(String emt) {
		this.emt = emt;
	}
	
	/**
	 * Column Info
	 * @param indDesc
	 */
	public void setIndDesc(String indDesc) {
		this.indDesc = indDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrVolumn
	 */
	public void setCntrVolumn(String cntrVolumn) {
		this.cntrVolumn = cntrVolumn;
	}
	
	/**
	 * Column Info
	 * @param d5
	 */
	public void setD5(String d5) {
		this.d5 = d5;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param d4
	 */
	public void setD4(String d4) {
		this.d4 = d4;
	}
	
	/**
	 * Column Info
	 * @param d7
	 */
	public void setD7(String d7) {
		this.d7 = d7;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param d2
	 */
	public void setD2(String d2) {
		this.d2 = d2;
	}
	
	/**
	 * Column Info
	 * @param ind
	 */
	public void setInd(String ind) {
		this.ind = ind;
	}
	
	/**
	 * Column Info
	 * @param a2
	 */
	public void setA2(String a2) {
		this.a2 = a2;
	}
	
	/**
	 * Column Info
	 * @param bundle
	 */
	public void setBundle(String bundle) {
		this.bundle = bundle;
	}
	
	/**
	 * Column Info
	 * @param a4
	 */
	public void setA4(String a4) {
		this.a4 = a4;
	}
	
	/**
	 * Column Info
	 * @param f2
	 */
	public void setF2(String f2) {
		this.f2 = f2;
	}
	
	/**
	 * Column Info
	 * @param f5
	 */
	public void setF5(String f5) {
		this.f5 = f5;
	}
	
	/**
	 * Column Info
	 * @param s4
	 */
	public void setS4(String s4) {
		this.s4 = s4;
	}
	
	/**
	 * Column Info
	 * @param f4
	 */
	public void setF4(String f4) {
		this.f4 = f4;
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
	 * @param feu
	 */
	public void setFeu(String feu) {
		this.feu = feu;
	}
	
	/**
	 * Column Info
	 * @param s2
	 */
	public void setS2(String s2) {
		this.s2 = s2;
	}
	
	/**
	 * Column Info
	 * @param o2
	 */
	public void setO2(String o2) {
		this.o2 = o2;
	}
	
	/**
	 * Column Info
	 * @param bookingDate
	 */
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	/**
	 * Column Info
	 * @param o4
	 */
	public void setO4(String o4) {
		this.o4 = o4;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Column Info
	 * @param r2
	 */
	public void setR2(String r2) {
		this.r2 = r2;
	}
	
	/**
	 * Column Info
	 * @param r4
	 */
	public void setR4(String r4) {
		this.r4 = r4;
	}
	
	/**
	 * Column Info
	 * @param r5
	 */
	public void setR5(String r5) {
		this.r5 = r5;
	}
	
	/**
	 * Column Info
	 * @param rsmOfcCd
	 */
	public void setRsmOfcCd(String rsmOfcCd) {
		this.rsmOfcCd = rsmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param polEtdDt
	 */
	public void setPolEtdDt(String polEtdDt) {
		this.polEtdDt = polEtdDt;
	}
	
	/**
	 * Column Info
	 * @param polAtdDt
	 */
	public void setPolAtdDt(String polAtdDt) {
		this.polAtdDt = polAtdDt;
	}
	
	/**
	 * Column Info
	 * @param podEtaDt
	 */
	public void setPodEtaDt(String podEtaDt) {
		this.podEtaDt = podEtaDt;
	}
	
	/**
	 * Column Info
	 * @param podAtaDt
	 */
	public void setPodAtaDt(String podAtaDt) {
		this.podAtaDt = podAtaDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrAttachDate(JSPUtil.getParameter(request, "cntr_attach_date", ""));
		setEmtDesc(JSPUtil.getParameter(request, "emt_desc", ""));
		setTs(JSPUtil.getParameter(request, "ts", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setEmt(JSPUtil.getParameter(request, "emt", ""));
		setIndDesc(JSPUtil.getParameter(request, "ind_desc", ""));
		setCntrVolumn(JSPUtil.getParameter(request, "cntr_volumn", ""));
		setD5(JSPUtil.getParameter(request, "d5", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setD4(JSPUtil.getParameter(request, "d4", ""));
		setD7(JSPUtil.getParameter(request, "d7", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setD2(JSPUtil.getParameter(request, "d2", ""));
		setInd(JSPUtil.getParameter(request, "ind", ""));
		setA2(JSPUtil.getParameter(request, "a2", ""));
		setBundle(JSPUtil.getParameter(request, "bundle", ""));
		setA4(JSPUtil.getParameter(request, "a4", ""));
		setF2(JSPUtil.getParameter(request, "f2", ""));
		setF5(JSPUtil.getParameter(request, "f5", ""));
		setS4(JSPUtil.getParameter(request, "s4", ""));
		setF4(JSPUtil.getParameter(request, "f4", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setFeu(JSPUtil.getParameter(request, "feu", ""));
		setS2(JSPUtil.getParameter(request, "s2", ""));
		setO2(JSPUtil.getParameter(request, "o2", ""));
		setBookingDate(JSPUtil.getParameter(request, "booking_date", ""));
		setO4(JSPUtil.getParameter(request, "o4", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setTeu(JSPUtil.getParameter(request, "teu", ""));
		setR2(JSPUtil.getParameter(request, "r2", ""));
		setR4(JSPUtil.getParameter(request, "r4", ""));
		setR5(JSPUtil.getParameter(request, "r5", ""));
		setRsmOfcCd(JSPUtil.getParameter(request, "rsm_ofc_cd", ""));
		setPolEtdDt(JSPUtil.getParameter(request, "pol_etd_dt", ""));
		setPolAtdDt(JSPUtil.getParameter(request, "pol_atd_dt", ""));
		setPodEtaDt(JSPUtil.getParameter(request, "pod_eta_dt", ""));
		setPodAtaDt(JSPUtil.getParameter(request, "pod_ata_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EmptyBkgListVO[]
	 */
	public EmptyBkgListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EmptyBkgListVO[]
	 */
	public EmptyBkgListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EmptyBkgListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrAttachDate = (JSPUtil.getParameter(request, prefix	+ "cntr_attach_date", length));
			String[] emtDesc = (JSPUtil.getParameter(request, prefix	+ "emt_desc", length));
			String[] ts = (JSPUtil.getParameter(request, prefix	+ "ts", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] emt = (JSPUtil.getParameter(request, prefix	+ "emt", length));
			String[] indDesc = (JSPUtil.getParameter(request, prefix	+ "ind_desc", length));
			String[] cntrVolumn = (JSPUtil.getParameter(request, prefix	+ "cntr_volumn", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4", length));
			String[] d7 = (JSPUtil.getParameter(request, prefix	+ "d7", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2", length));
			String[] ind = (JSPUtil.getParameter(request, prefix	+ "ind", length));
			String[] a2 = (JSPUtil.getParameter(request, prefix	+ "a2", length));
			String[] bundle = (JSPUtil.getParameter(request, prefix	+ "bundle", length));
			String[] a4 = (JSPUtil.getParameter(request, prefix	+ "a4", length));
			String[] f2 = (JSPUtil.getParameter(request, prefix	+ "f2", length));
			String[] f5 = (JSPUtil.getParameter(request, prefix	+ "f5", length));
			String[] s4 = (JSPUtil.getParameter(request, prefix	+ "s4", length));
			String[] f4 = (JSPUtil.getParameter(request, prefix	+ "f4", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] feu = (JSPUtil.getParameter(request, prefix	+ "feu", length));
			String[] s2 = (JSPUtil.getParameter(request, prefix	+ "s2", length));
			String[] o2 = (JSPUtil.getParameter(request, prefix	+ "o2", length));
			String[] bookingDate = (JSPUtil.getParameter(request, prefix	+ "booking_date", length));
			String[] o4 = (JSPUtil.getParameter(request, prefix	+ "o4", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] r2 = (JSPUtil.getParameter(request, prefix	+ "r2", length));
			String[] r4 = (JSPUtil.getParameter(request, prefix	+ "r4", length));
			String[] r5 = (JSPUtil.getParameter(request, prefix	+ "r5", length));
			String[] rsmOfcCd = (JSPUtil.getParameter(request, prefix	+ "rsm_ofc_cd", length));
			String[] polEtdDt = (JSPUtil.getParameter(request, prefix	+ "pol_etd_dt", length));
			String[] polAtdDt = (JSPUtil.getParameter(request, prefix	+ "pol_atd_dt", length));
			String[] podEtaDt = (JSPUtil.getParameter(request, prefix	+ "pod_eta_dt", length));
			String[] podAtaDt = (JSPUtil.getParameter(request, prefix	+ "pod_ata_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new EmptyBkgListVO();
				if (cntrAttachDate[i] != null)
					model.setCntrAttachDate(cntrAttachDate[i]);
				if (emtDesc[i] != null)
					model.setEmtDesc(emtDesc[i]);
				if (ts[i] != null)
					model.setTs(ts[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (emt[i] != null)
					model.setEmt(emt[i]);
				if (indDesc[i] != null)
					model.setIndDesc(indDesc[i]);
				if (cntrVolumn[i] != null)
					model.setCntrVolumn(cntrVolumn[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (d7[i] != null)
					model.setD7(d7[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (ind[i] != null)
					model.setInd(ind[i]);
				if (a2[i] != null)
					model.setA2(a2[i]);
				if (bundle[i] != null)
					model.setBundle(bundle[i]);
				if (a4[i] != null)
					model.setA4(a4[i]);
				if (f2[i] != null)
					model.setF2(f2[i]);
				if (f5[i] != null)
					model.setF5(f5[i]);
				if (s4[i] != null)
					model.setS4(s4[i]);
				if (f4[i] != null)
					model.setF4(f4[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (feu[i] != null)
					model.setFeu(feu[i]);
				if (s2[i] != null)
					model.setS2(s2[i]);
				if (o2[i] != null)
					model.setO2(o2[i]);
				if (bookingDate[i] != null)
					model.setBookingDate(bookingDate[i]);
				if (o4[i] != null)
					model.setO4(o4[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (r2[i] != null)
					model.setR2(r2[i]);
				if (r4[i] != null)
					model.setR4(r4[i]);
				if (r5[i] != null)
					model.setR5(r5[i]);
				if (rsmOfcCd[i] != null)
					model.setRsmOfcCd(rsmOfcCd[i]);
				if (polEtdDt[i] != null)
					model.setPolEtdDt(polEtdDt[i]);
				if (polAtdDt[i] != null)
					model.setPolAtdDt(polAtdDt[i]);
				if (podEtaDt[i] != null)
					model.setPodEtaDt(podEtaDt[i]);
				if (podAtaDt[i] != null)
					model.setPodAtaDt(podAtaDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEmptyBkgListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EmptyBkgListVO[]
	 */
	public EmptyBkgListVO[] getEmptyBkgListVOs(){
		EmptyBkgListVO[] vos = (EmptyBkgListVO[])models.toArray(new EmptyBkgListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.cntrAttachDate = this.cntrAttachDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emtDesc = this.emtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts = this.ts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emt = this.emt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indDesc = this.indDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolumn = this.cntrVolumn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 = this.d7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ind = this.ind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2 = this.a2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bundle = this.bundle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4 = this.a4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2 = this.f2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5 = this.f5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4 = this.s4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4 = this.f4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feu = this.feu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2 = this.s2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2 = this.o2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingDate = this.bookingDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4 = this.o4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2 = this.r2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r4 = this.r4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 = this.r5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsmOfcCd = this.rsmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdDt = this.polEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAtdDt = this.polAtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtaDt = this.podEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtaDt = this.podAtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
