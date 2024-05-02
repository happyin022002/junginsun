/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairPFMCByTSVO.java
*@FileTitle : RepairPFMCByTSVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.02.02 김완규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairPFMCByTSVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairPFMCByTSVO> models = new ArrayList<RepairPFMCByTSVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ts21 = null;
	/* Column Info */
	private String ts22 = null;
	/* Column Info */
	private String ts20 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String title = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ts15 = null;
	/* Column Info */
	private String ts14 = null;
	/* Column Info */
	private String ts13 = null;
	/* Column Info */
	private String ts12 = null;
	/* Column Info */
	private String ts19 = null;
	/* Column Info */
	private String ts18 = null;
	/* Column Info */
	private String dcol = null;
	/* Column Info */
	private String ts17 = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String ts16 = null;
	/* Column Info */
	private String ts29 = null;
	/* Column Info */
	private String ts27 = null;
	/* Column Info */
	private String ts28 = null;
	/* Column Info */
	private String ts25 = null;
	/* Column Info */
	private String ts26 = null;
	/* Column Info */
	private String ts23 = null;
	/* Column Info */
	private String ts10 = null;
	/* Column Info */
	private String ts24 = null;
	/* Column Info */
	private String ts11 = null;
	/* Column Info */
	private String spCd = null;
	/* Column Info */
	private String ts09 = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String spNm = null;
	/* Column Info */
	private String ts02 = null;
	/* Column Info */
	private String ts01 = null;
	/* Column Info */
	private String ts04 = null;
	/* Column Info */
	private String ts03 = null;
	/* Column Info */
	private String ts30 = null;
	/* Column Info */
	private String ts06 = null;
	/* Column Info */
	private String ts05 = null;
	/* Column Info */
	private String ts08 = null;
	/* Column Info */
	private String ts07 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepairPFMCByTSVO() {}

	public RepairPFMCByTSVO(String ibflag, String pagerows, String ts21, String ts22, String ts20, String title, String ts15, String ts14, String ts13, String ts12, String ts19, String ts18, String dcol, String ts17, String rhq, String ts16, String ts29, String ts27, String ts28, String ts25, String ts26, String ts23, String ts10, String ts24, String ts11, String spCd, String ofcCd, String ts09, String spNm, String ts02, String ts01, String ts04, String ts30, String ts03, String ts06, String ts05, String ts08, String ts07, String currCd) {
		this.currCd = currCd;
		this.ts21 = ts21;
		this.ts22 = ts22;
		this.ts20 = ts20;
		this.pagerows = pagerows;
		this.title = title;
		this.ibflag = ibflag;
		this.ts15 = ts15;
		this.ts14 = ts14;
		this.ts13 = ts13;
		this.ts12 = ts12;
		this.ts19 = ts19;
		this.ts18 = ts18;
		this.dcol = dcol;
		this.ts17 = ts17;
		this.rhq = rhq;
		this.ts16 = ts16;
		this.ts29 = ts29;
		this.ts27 = ts27;
		this.ts28 = ts28;
		this.ts25 = ts25;
		this.ts26 = ts26;
		this.ts23 = ts23;
		this.ts10 = ts10;
		this.ts24 = ts24;
		this.ts11 = ts11;
		this.spCd = spCd;
		this.ts09 = ts09;
		this.ofcCd = ofcCd;
		this.spNm = spNm;
		this.ts02 = ts02;
		this.ts01 = ts01;
		this.ts04 = ts04;
		this.ts03 = ts03;
		this.ts30 = ts30;
		this.ts06 = ts06;
		this.ts05 = ts05;
		this.ts08 = ts08;
		this.ts07 = ts07;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ts21", getTs21());
		this.hashColumns.put("ts22", getTs22());
		this.hashColumns.put("ts20", getTs20());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ts15", getTs15());
		this.hashColumns.put("ts14", getTs14());
		this.hashColumns.put("ts13", getTs13());
		this.hashColumns.put("ts12", getTs12());
		this.hashColumns.put("ts19", getTs19());
		this.hashColumns.put("ts18", getTs18());
		this.hashColumns.put("dcol", getDcol());
		this.hashColumns.put("ts17", getTs17());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("ts16", getTs16());
		this.hashColumns.put("ts29", getTs29());
		this.hashColumns.put("ts27", getTs27());
		this.hashColumns.put("ts28", getTs28());
		this.hashColumns.put("ts25", getTs25());
		this.hashColumns.put("ts26", getTs26());
		this.hashColumns.put("ts23", getTs23());
		this.hashColumns.put("ts10", getTs10());
		this.hashColumns.put("ts24", getTs24());
		this.hashColumns.put("ts11", getTs11());
		this.hashColumns.put("sp_cd", getSpCd());
		this.hashColumns.put("ts09", getTs09());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("sp_nm", getSpNm());
		this.hashColumns.put("ts02", getTs02());
		this.hashColumns.put("ts01", getTs01());
		this.hashColumns.put("ts04", getTs04());
		this.hashColumns.put("ts03", getTs03());
		this.hashColumns.put("ts30", getTs30());
		this.hashColumns.put("ts06", getTs06());
		this.hashColumns.put("ts05", getTs05());
		this.hashColumns.put("ts08", getTs08());
		this.hashColumns.put("ts07", getTs07());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ts21", "ts21");
		this.hashFields.put("ts22", "ts22");
		this.hashFields.put("ts20", "ts20");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("title", "title");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ts15", "ts15");
		this.hashFields.put("ts14", "ts14");
		this.hashFields.put("ts13", "ts13");
		this.hashFields.put("ts12", "ts12");
		this.hashFields.put("ts19", "ts19");
		this.hashFields.put("ts18", "ts18");
		this.hashFields.put("dcol", "dcol");
		this.hashFields.put("ts17", "ts17");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("ts16", "ts16");
		this.hashFields.put("ts29", "ts29");
		this.hashFields.put("ts27", "ts27");
		this.hashFields.put("ts28", "ts28");
		this.hashFields.put("ts25", "ts25");
		this.hashFields.put("ts26", "ts26");
		this.hashFields.put("ts23", "ts23");
		this.hashFields.put("ts10", "ts10");
		this.hashFields.put("ts24", "ts24");
		this.hashFields.put("ts11", "ts11");
		this.hashFields.put("sp_cd", "spCd");
		this.hashFields.put("ts09", "ts09");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("sp_nm", "spNm");
		this.hashFields.put("ts02", "ts02");
		this.hashFields.put("ts01", "ts01");
		this.hashFields.put("ts04", "ts04");
		this.hashFields.put("ts03", "ts03");
		this.hashFields.put("ts30", "ts30");
		this.hashFields.put("ts06", "ts06");
		this.hashFields.put("ts05", "ts05");
		this.hashFields.put("ts08", "ts08");
		this.hashFields.put("ts07", "ts07");
		return this.hashFields;
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
	 * @return ts21
	 */
	public String getTs21() {
		return this.ts21;
	}
	
	/**
	 * Column Info
	 * @return ts22
	 */
	public String getTs22() {
		return this.ts22;
	}
	
	/**
	 * Column Info
	 * @return ts20
	 */
	public String getTs20() {
		return this.ts20;
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
	 * @return title
	 */
	public String getTitle() {
		return this.title;
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
	 * @return ts15
	 */
	public String getTs15() {
		return this.ts15;
	}
	
	/**
	 * Column Info
	 * @return ts14
	 */
	public String getTs14() {
		return this.ts14;
	}
	
	/**
	 * Column Info
	 * @return ts13
	 */
	public String getTs13() {
		return this.ts13;
	}
	
	/**
	 * Column Info
	 * @return ts12
	 */
	public String getTs12() {
		return this.ts12;
	}
	
	/**
	 * Column Info
	 * @return ts19
	 */
	public String getTs19() {
		return this.ts19;
	}
	
	/**
	 * Column Info
	 * @return ts18
	 */
	public String getTs18() {
		return this.ts18;
	}
	
	/**
	 * Column Info
	 * @return dcol
	 */
	public String getDcol() {
		return this.dcol;
	}
	
	/**
	 * Column Info
	 * @return ts17
	 */
	public String getTs17() {
		return this.ts17;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return ts16
	 */
	public String getTs16() {
		return this.ts16;
	}
	
	/**
	 * Column Info
	 * @return ts29
	 */
	public String getTs29() {
		return this.ts29;
	}
	
	/**
	 * Column Info
	 * @return ts27
	 */
	public String getTs27() {
		return this.ts27;
	}
	
	/**
	 * Column Info
	 * @return ts28
	 */
	public String getTs28() {
		return this.ts28;
	}
	
	/**
	 * Column Info
	 * @return ts25
	 */
	public String getTs25() {
		return this.ts25;
	}
	
	/**
	 * Column Info
	 * @return ts26
	 */
	public String getTs26() {
		return this.ts26;
	}
	
	/**
	 * Column Info
	 * @return ts23
	 */
	public String getTs23() {
		return this.ts23;
	}
	
	/**
	 * Column Info
	 * @return ts10
	 */
	public String getTs10() {
		return this.ts10;
	}
	
	/**
	 * Column Info
	 * @return ts24
	 */
	public String getTs24() {
		return this.ts24;
	}
	
	/**
	 * Column Info
	 * @return ts11
	 */
	public String getTs11() {
		return this.ts11;
	}
	
	/**
	 * Column Info
	 * @return spCd
	 */
	public String getSpCd() {
		return this.spCd;
	}
	
	/**
	 * Column Info
	 * @return ts09
	 */
	public String getTs09() {
		return this.ts09;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return spNm
	 */
	public String getSpNm() {
		return this.spNm;
	}
	
	/**
	 * Column Info
	 * @return ts02
	 */
	public String getTs02() {
		return this.ts02;
	}
	
	/**
	 * Column Info
	 * @return ts01
	 */
	public String getTs01() {
		return this.ts01;
	}
	
	/**
	 * Column Info
	 * @return ts04
	 */
	public String getTs04() {
		return this.ts04;
	}
	
	/**
	 * Column Info
	 * @return ts03
	 */
	public String getTs03() {
		return this.ts03;
	}
	
	/**
	 * Column Info
	 * @return ts30
	 */
	public String getTs30() {
		return this.ts30;
	}
	
	/**
	 * Column Info
	 * @return ts06
	 */
	public String getTs06() {
		return this.ts06;
	}
	
	/**
	 * Column Info
	 * @return ts05
	 */
	public String getTs05() {
		return this.ts05;
	}
	
	/**
	 * Column Info
	 * @return ts08
	 */
	public String getTs08() {
		return this.ts08;
	}
	
	/**
	 * Column Info
	 * @return ts07
	 */
	public String getTs07() {
		return this.ts07;
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
	 * @param ts21
	 */
	public void setTs21(String ts21) {
		this.ts21 = ts21;
	}
	
	/**
	 * Column Info
	 * @param ts22
	 */
	public void setTs22(String ts22) {
		this.ts22 = ts22;
	}
	
	/**
	 * Column Info
	 * @param ts20
	 */
	public void setTs20(String ts20) {
		this.ts20 = ts20;
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
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @param ts15
	 */
	public void setTs15(String ts15) {
		this.ts15 = ts15;
	}
	
	/**
	 * Column Info
	 * @param ts14
	 */
	public void setTs14(String ts14) {
		this.ts14 = ts14;
	}
	
	/**
	 * Column Info
	 * @param ts13
	 */
	public void setTs13(String ts13) {
		this.ts13 = ts13;
	}
	
	/**
	 * Column Info
	 * @param ts12
	 */
	public void setTs12(String ts12) {
		this.ts12 = ts12;
	}
	
	/**
	 * Column Info
	 * @param ts19
	 */
	public void setTs19(String ts19) {
		this.ts19 = ts19;
	}
	
	/**
	 * Column Info
	 * @param ts18
	 */
	public void setTs18(String ts18) {
		this.ts18 = ts18;
	}
	
	/**
	 * Column Info
	 * @param dcol
	 */
	public void setDcol(String dcol) {
		this.dcol = dcol;
	}
	
	/**
	 * Column Info
	 * @param ts17
	 */
	public void setTs17(String ts17) {
		this.ts17 = ts17;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param ts16
	 */
	public void setTs16(String ts16) {
		this.ts16 = ts16;
	}
	
	/**
	 * Column Info
	 * @param ts29
	 */
	public void setTs29(String ts29) {
		this.ts29 = ts29;
	}
	
	/**
	 * Column Info
	 * @param ts27
	 */
	public void setTs27(String ts27) {
		this.ts27 = ts27;
	}
	
	/**
	 * Column Info
	 * @param ts28
	 */
	public void setTs28(String ts28) {
		this.ts28 = ts28;
	}
	
	/**
	 * Column Info
	 * @param ts25
	 */
	public void setTs25(String ts25) {
		this.ts25 = ts25;
	}
	
	/**
	 * Column Info
	 * @param ts26
	 */
	public void setTs26(String ts26) {
		this.ts26 = ts26;
	}
	
	/**
	 * Column Info
	 * @param ts23
	 */
	public void setTs23(String ts23) {
		this.ts23 = ts23;
	}
	
	/**
	 * Column Info
	 * @param ts10
	 */
	public void setTs10(String ts10) {
		this.ts10 = ts10;
	}
	
	/**
	 * Column Info
	 * @param ts24
	 */
	public void setTs24(String ts24) {
		this.ts24 = ts24;
	}
	
	/**
	 * Column Info
	 * @param ts11
	 */
	public void setTs11(String ts11) {
		this.ts11 = ts11;
	}
	
	/**
	 * Column Info
	 * @param spCd
	 */
	public void setSpCd(String spCd) {
		this.spCd = spCd;
	}
	
	/**
	 * Column Info
	 * @param ts09
	 */
	public void setTs09(String ts09) {
		this.ts09 = ts09;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param spNm
	 */
	public void setSpNm(String spNm) {
		this.spNm = spNm;
	}
	
	/**
	 * Column Info
	 * @param ts02
	 */
	public void setTs02(String ts02) {
		this.ts02 = ts02;
	}
	
	/**
	 * Column Info
	 * @param ts01
	 */
	public void setTs01(String ts01) {
		this.ts01 = ts01;
	}
	
	/**
	 * Column Info
	 * @param ts04
	 */
	public void setTs04(String ts04) {
		this.ts04 = ts04;
	}
	
	/**
	 * Column Info
	 * @param ts03
	 */
	public void setTs03(String ts03) {
		this.ts03 = ts03;
	}
	
	/**
	 * Column Info
	 * @param ts30
	 */
	public void setTs30(String ts30) {
		this.ts30 = ts30;
	}
	
	/**
	 * Column Info
	 * @param ts06
	 */
	public void setTs06(String ts06) {
		this.ts06 = ts06;
	}
	
	/**
	 * Column Info
	 * @param ts05
	 */
	public void setTs05(String ts05) {
		this.ts05 = ts05;
	}
	
	/**
	 * Column Info
	 * @param ts08
	 */
	public void setTs08(String ts08) {
		this.ts08 = ts08;
	}
	
	/**
	 * Column Info
	 * @param ts07
	 */
	public void setTs07(String ts07) {
		this.ts07 = ts07;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setTs21(JSPUtil.getParameter(request, "ts21", ""));
		setTs22(JSPUtil.getParameter(request, "ts22", ""));
		setTs20(JSPUtil.getParameter(request, "ts20", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTitle(JSPUtil.getParameter(request, "title", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTs15(JSPUtil.getParameter(request, "ts15", ""));
		setTs14(JSPUtil.getParameter(request, "ts14", ""));
		setTs13(JSPUtil.getParameter(request, "ts13", ""));
		setTs12(JSPUtil.getParameter(request, "ts12", ""));
		setTs19(JSPUtil.getParameter(request, "ts19", ""));
		setTs18(JSPUtil.getParameter(request, "ts18", ""));
		setDcol(JSPUtil.getParameter(request, "dcol", ""));
		setTs17(JSPUtil.getParameter(request, "ts17", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
		setTs16(JSPUtil.getParameter(request, "ts16", ""));
		setTs29(JSPUtil.getParameter(request, "ts29", ""));
		setTs27(JSPUtil.getParameter(request, "ts27", ""));
		setTs28(JSPUtil.getParameter(request, "ts28", ""));
		setTs25(JSPUtil.getParameter(request, "ts25", ""));
		setTs26(JSPUtil.getParameter(request, "ts26", ""));
		setTs23(JSPUtil.getParameter(request, "ts23", ""));
		setTs10(JSPUtil.getParameter(request, "ts10", ""));
		setTs24(JSPUtil.getParameter(request, "ts24", ""));
		setTs11(JSPUtil.getParameter(request, "ts11", ""));
		setSpCd(JSPUtil.getParameter(request, "sp_cd", ""));
		setTs09(JSPUtil.getParameter(request, "ts09", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSpNm(JSPUtil.getParameter(request, "sp_nm", ""));
		setTs02(JSPUtil.getParameter(request, "ts02", ""));
		setTs01(JSPUtil.getParameter(request, "ts01", ""));
		setTs04(JSPUtil.getParameter(request, "ts04", ""));
		setTs03(JSPUtil.getParameter(request, "ts03", ""));
		setTs30(JSPUtil.getParameter(request, "ts30", ""));
		setTs06(JSPUtil.getParameter(request, "ts06", ""));
		setTs05(JSPUtil.getParameter(request, "ts05", ""));
		setTs08(JSPUtil.getParameter(request, "ts08", ""));
		setTs07(JSPUtil.getParameter(request, "ts07", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairPFMCByTSVO[]
	 */
	public RepairPFMCByTSVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairPFMCByTSVO[]
	 */
	public RepairPFMCByTSVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairPFMCByTSVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ts21 = (JSPUtil.getParameter(request, prefix	+ "ts21", length));
			String[] ts22 = (JSPUtil.getParameter(request, prefix	+ "ts22", length));
			String[] ts20 = (JSPUtil.getParameter(request, prefix	+ "ts20", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ts15 = (JSPUtil.getParameter(request, prefix	+ "ts15", length));
			String[] ts14 = (JSPUtil.getParameter(request, prefix	+ "ts14", length));
			String[] ts13 = (JSPUtil.getParameter(request, prefix	+ "ts13", length));
			String[] ts12 = (JSPUtil.getParameter(request, prefix	+ "ts12", length));
			String[] ts19 = (JSPUtil.getParameter(request, prefix	+ "ts19", length));
			String[] ts18 = (JSPUtil.getParameter(request, prefix	+ "ts18", length));
			String[] dcol = (JSPUtil.getParameter(request, prefix	+ "dcol", length));
			String[] ts17 = (JSPUtil.getParameter(request, prefix	+ "ts17", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] ts16 = (JSPUtil.getParameter(request, prefix	+ "ts16", length));
			String[] ts29 = (JSPUtil.getParameter(request, prefix	+ "ts29", length));
			String[] ts27 = (JSPUtil.getParameter(request, prefix	+ "ts27", length));
			String[] ts28 = (JSPUtil.getParameter(request, prefix	+ "ts28", length));
			String[] ts25 = (JSPUtil.getParameter(request, prefix	+ "ts25", length));
			String[] ts26 = (JSPUtil.getParameter(request, prefix	+ "ts26", length));
			String[] ts23 = (JSPUtil.getParameter(request, prefix	+ "ts23", length));
			String[] ts10 = (JSPUtil.getParameter(request, prefix	+ "ts10", length));
			String[] ts24 = (JSPUtil.getParameter(request, prefix	+ "ts24", length));
			String[] ts11 = (JSPUtil.getParameter(request, prefix	+ "ts11", length));
			String[] spCd = (JSPUtil.getParameter(request, prefix	+ "sp_cd", length));
			String[] ts09 = (JSPUtil.getParameter(request, prefix	+ "ts09", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] spNm = (JSPUtil.getParameter(request, prefix	+ "sp_nm", length));
			String[] ts02 = (JSPUtil.getParameter(request, prefix	+ "ts02", length));
			String[] ts01 = (JSPUtil.getParameter(request, prefix	+ "ts01", length));
			String[] ts04 = (JSPUtil.getParameter(request, prefix	+ "ts04", length));
			String[] ts03 = (JSPUtil.getParameter(request, prefix	+ "ts03", length));
			String[] ts30 = (JSPUtil.getParameter(request, prefix	+ "ts30", length));
			String[] ts06 = (JSPUtil.getParameter(request, prefix	+ "ts06", length));
			String[] ts05 = (JSPUtil.getParameter(request, prefix	+ "ts05", length));
			String[] ts08 = (JSPUtil.getParameter(request, prefix	+ "ts08", length));
			String[] ts07 = (JSPUtil.getParameter(request, prefix	+ "ts07", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairPFMCByTSVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ts21[i] != null)
					model.setTs21(ts21[i]);
				if (ts22[i] != null)
					model.setTs22(ts22[i]);
				if (ts20[i] != null)
					model.setTs20(ts20[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ts15[i] != null)
					model.setTs15(ts15[i]);
				if (ts14[i] != null)
					model.setTs14(ts14[i]);
				if (ts13[i] != null)
					model.setTs13(ts13[i]);
				if (ts12[i] != null)
					model.setTs12(ts12[i]);
				if (ts19[i] != null)
					model.setTs19(ts19[i]);
				if (ts18[i] != null)
					model.setTs18(ts18[i]);
				if (dcol[i] != null)
					model.setDcol(dcol[i]);
				if (ts17[i] != null)
					model.setTs17(ts17[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (ts16[i] != null)
					model.setTs16(ts16[i]);
				if (ts29[i] != null)
					model.setTs29(ts29[i]);
				if (ts27[i] != null)
					model.setTs27(ts27[i]);
				if (ts28[i] != null)
					model.setTs28(ts28[i]);
				if (ts25[i] != null)
					model.setTs25(ts25[i]);
				if (ts26[i] != null)
					model.setTs26(ts26[i]);
				if (ts23[i] != null)
					model.setTs23(ts23[i]);
				if (ts10[i] != null)
					model.setTs10(ts10[i]);
				if (ts24[i] != null)
					model.setTs24(ts24[i]);
				if (ts11[i] != null)
					model.setTs11(ts11[i]);
				if (spCd[i] != null)
					model.setSpCd(spCd[i]);
				if (ts09[i] != null)
					model.setTs09(ts09[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (spNm[i] != null)
					model.setSpNm(spNm[i]);
				if (ts02[i] != null)
					model.setTs02(ts02[i]);
				if (ts01[i] != null)
					model.setTs01(ts01[i]);
				if (ts04[i] != null)
					model.setTs04(ts04[i]);
				if (ts03[i] != null)
					model.setTs03(ts03[i]);
				if (ts30[i] != null)
					model.setTs30(ts30[i]);
				if (ts06[i] != null)
					model.setTs06(ts06[i]);
				if (ts05[i] != null)
					model.setTs05(ts05[i]);
				if (ts08[i] != null)
					model.setTs08(ts08[i]);
				if (ts07[i] != null)
					model.setTs07(ts07[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairPFMCByTSVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairPFMCByTSVO[]
	 */
	public RepairPFMCByTSVO[] getRepairPFMCByTSVOs(){
		RepairPFMCByTSVO[] vos = (RepairPFMCByTSVO[])models.toArray(new RepairPFMCByTSVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts21 = this.ts21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts22 = this.ts22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts20 = this.ts20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts15 = this.ts15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts14 = this.ts14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts13 = this.ts13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts12 = this.ts12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts19 = this.ts19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts18 = this.ts18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcol = this.dcol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts17 = this.ts17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts16 = this.ts16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts29 = this.ts29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts27 = this.ts27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts28 = this.ts28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts25 = this.ts25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts26 = this.ts26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts23 = this.ts23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts10 = this.ts10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts24 = this.ts24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts11 = this.ts11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCd = this.spCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts09 = this.ts09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spNm = this.spNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts02 = this.ts02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts01 = this.ts01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts04 = this.ts04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts03 = this.ts03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts30 = this.ts30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts06 = this.ts06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts05 = this.ts05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts08 = this.ts08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts07 = this.ts07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
