/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgDtlVO.java
*@FileTitle : ScgDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.report.scgreport.vo;

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

public class ScgDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgDtlVO> models = new ArrayList<ScgDtlVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String consignee = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String amt1 = null;
	/* Column Info */
	private String amt3 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amt2 = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String moreThan3 = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String shipper = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String scg3 = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String scg1 = null;
	/* Column Info */
	private String scg2 = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String month = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ScgDtlVO() {}

	public ScgDtlVO(String ibflag, String pagerows, String soNo, String woNo, String invNo, String bkgNo, String currCd, String scg1, String amt1, String scg2, String amt2, String scg3, String amt3, String moreThan3, String trspCrrModCd, String fmNodCd, String viaNodCd, String toNodCd, String dorNodCd, String rmk, String month, String eqNo, String eqTpszCd, String invRmk, String creOfcCd, String vndrSeq, String vndrNm, String ctrtNo, String shipper, String consignee) {
		this.toNodCd = toNodCd;
		this.currCd = currCd;
		this.consignee = consignee;
		this.pagerows = pagerows;
		this.ctrtNo = ctrtNo;
		this.vndrNm = vndrNm;
		this.amt1 = amt1;
		this.amt3 = amt3;
		this.ibflag = ibflag;
		this.amt2 = amt2;
		this.eqNo = eqNo;
		this.creOfcCd = creOfcCd;
		this.dorNodCd = dorNodCd;
		this.woNo = woNo;
		this.trspCrrModCd = trspCrrModCd;
		this.rmk = rmk;
		this.moreThan3 = moreThan3;
		this.soNo = soNo;
		this.shipper = shipper;
		this.eqTpszCd = eqTpszCd;
		this.invNo = invNo;
		this.fmNodCd = fmNodCd;
		this.scg3 = scg3;
		this.bkgNo = bkgNo;
		this.scg1 = scg1;
		this.scg2 = scg2;
		this.vndrSeq = vndrSeq;
		this.invRmk = invRmk;
		this.viaNodCd = viaNodCd;
		this.month = month;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("consignee", getConsignee());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("amt1", getAmt1());
		this.hashColumns.put("amt3", getAmt3());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amt2", getAmt2());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("more_than_3", getMoreThan3());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("shipper", getShipper());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("scg3", getScg3());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("scg1", getScg1());
		this.hashColumns.put("scg2", getScg2());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("month", getMonth());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("consignee", "consignee");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("amt1", "amt1");
		this.hashFields.put("amt3", "amt3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amt2", "amt2");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("more_than_3", "moreThan3");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("shipper", "shipper");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("scg3", "scg3");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("scg1", "scg1");
		this.hashFields.put("scg2", "scg2");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("month", "month");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return consignee
	 */
	public String getConsignee() {
		return this.consignee;
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
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return amt1
	 */
	public String getAmt1() {
		return this.amt1;
	}
	
	/**
	 * Column Info
	 * @return amt3
	 */
	public String getAmt3() {
		return this.amt3;
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
	 * @return amt2
	 */
	public String getAmt2() {
		return this.amt2;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
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
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
	}
	
	/**
	 * Column Info
	 * @return moreThan3
	 */
	public String getMoreThan3() {
		return this.moreThan3;
	}
	
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return shipper
	 */
	public String getShipper() {
		return this.shipper;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return scg3
	 */
	public String getScg3() {
		return this.scg3;
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
	 * @return scg1
	 */
	public String getScg1() {
		return this.scg1;
	}
	
	/**
	 * Column Info
	 * @return scg2
	 */
	public String getScg2() {
		return this.scg2;
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
	 * @return invRmk
	 */
	public String getInvRmk() {
		return this.invRmk;
	}
	
	/**
	 * Column Info
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
	}
	
	/**
	 * Column Info
	 * @return month
	 */
	public String getMonth() {
		return this.month;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param consignee
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
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
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param amt1
	 */
	public void setAmt1(String amt1) {
		this.amt1 = amt1;
	}
	
	/**
	 * Column Info
	 * @param amt3
	 */
	public void setAmt3(String amt3) {
		this.amt3 = amt3;
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
	 * @param amt2
	 */
	public void setAmt2(String amt2) {
		this.amt2 = amt2;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
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
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	/**
	 * Column Info
	 * @param moreThan3
	 */
	public void setMoreThan3(String moreThan3) {
		this.moreThan3 = moreThan3;
	}
	
	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * Column Info
	 * @param shipper
	 */
	public void setShipper(String shipper) {
		this.shipper = shipper;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param scg3
	 */
	public void setScg3(String scg3) {
		this.scg3 = scg3;
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
	 * @param scg1
	 */
	public void setScg1(String scg1) {
		this.scg1 = scg1;
	}
	
	/**
	 * Column Info
	 * @param scg2
	 */
	public void setScg2(String scg2) {
		this.scg2 = scg2;
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
	 * @param invRmk
	 */
	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
	}
	
	/**
	 * Column Info
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * Column Info
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setConsignee(JSPUtil.getParameter(request, prefix + "consignee", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setAmt1(JSPUtil.getParameter(request, prefix + "amt1", ""));
		setAmt3(JSPUtil.getParameter(request, prefix + "amt3", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAmt2(JSPUtil.getParameter(request, prefix + "amt2", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
		setMoreThan3(JSPUtil.getParameter(request, prefix + "more_than_3", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setShipper(JSPUtil.getParameter(request, prefix + "shipper", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setScg3(JSPUtil.getParameter(request, prefix + "scg3", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setScg1(JSPUtil.getParameter(request, prefix + "scg1", ""));
		setScg2(JSPUtil.getParameter(request, prefix + "scg2", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setInvRmk(JSPUtil.getParameter(request, prefix + "inv_rmk", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setMonth(JSPUtil.getParameter(request, prefix + "month", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgDtlVO[]
	 */
	public ScgDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgDtlVO[]
	 */
	public ScgDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] consignee = (JSPUtil.getParameter(request, prefix	+ "consignee", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] amt1 = (JSPUtil.getParameter(request, prefix	+ "amt1", length));
			String[] amt3 = (JSPUtil.getParameter(request, prefix	+ "amt3", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amt2 = (JSPUtil.getParameter(request, prefix	+ "amt2", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] moreThan3 = (JSPUtil.getParameter(request, prefix	+ "more_than_3", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] shipper = (JSPUtil.getParameter(request, prefix	+ "shipper", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] scg3 = (JSPUtil.getParameter(request, prefix	+ "scg3", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] scg1 = (JSPUtil.getParameter(request, prefix	+ "scg1", length));
			String[] scg2 = (JSPUtil.getParameter(request, prefix	+ "scg2", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] month = (JSPUtil.getParameter(request, prefix	+ "month", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgDtlVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (consignee[i] != null)
					model.setConsignee(consignee[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (amt1[i] != null)
					model.setAmt1(amt1[i]);
				if (amt3[i] != null)
					model.setAmt3(amt3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amt2[i] != null)
					model.setAmt2(amt2[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (moreThan3[i] != null)
					model.setMoreThan3(moreThan3[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (shipper[i] != null)
					model.setShipper(shipper[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (scg3[i] != null)
					model.setScg3(scg3[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (scg1[i] != null)
					model.setScg1(scg1[i]);
				if (scg2[i] != null)
					model.setScg2(scg2[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (month[i] != null)
					model.setMonth(month[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgDtlVO[]
	 */
	public ScgDtlVO[] getScgDtlVOs(){
		ScgDtlVO[] vos = (ScgDtlVO[])models.toArray(new ScgDtlVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignee = this.consignee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt1 = this.amt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt3 = this.amt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt2 = this.amt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.moreThan3 = this.moreThan3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipper = this.shipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scg3 = this.scg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scg1 = this.scg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scg2 = this.scg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.month = this.month .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
