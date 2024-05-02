/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MBDResultCOABKGVO.java
*@FileTitle : MBDResultCOABKGVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.22 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo;
	
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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MBDResultCOABKGVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MBDResultCOABKGVO> models = new ArrayList<MBDResultCOABKGVO>();
	
	/* Column Info */
	private String qty11 = null;
	/* Column Info */
	private String qty12 = null;
	/* Column Info */
	private String qty35 = null;
	/* Column Info */
	private String div = null;
	/* Column Info */
	private String qty55 = null;
	/* Column Info */
	private String qty54 = null;
	/* Column Info */
	private String qty53 = null;
	/* Column Info */
	private String qty34 = null;
	/* Column Info */
	private String qty15 = null;
	/* Column Info */
	private String qty52 = null;
	/* Column Info */
	private String qty33 = null;
	/* Column Info */
	private String qty51 = null;
	/* Column Info */
	private String qty13 = null;
	/* Column Info */
	private String qty32 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String qty14 = null;
	/* Column Info */
	private String qty31 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String qty0 = null;
	/* Column Info */
	private String qty21 = null;
	/* Column Info */
	private String qty22 = null;
	/* Column Info */
	private String qty23 = null;
	/* Column Info */
	private String qty75 = null;
	/* Column Info */
	private String qty65 = null;
	/* Column Info */
	private String qty64 = null;
	/* Column Info */
	private String qty41 = null;
	/* Column Info */
	private String qty43 = null;
	/* Column Info */
	private String qty24 = null;
	/* Column Info */
	private String qty61 = null;
	/* Column Info */
	private String qty71 = null;
	/* Column Info */
	private String qty42 = null;
	/* Column Info */
	private String qty25 = null;
	/* Column Info */
	private String qty72 = null;
	/* Column Info */
	private String qty45 = null;
	/* Column Info */
	private String qty63 = null;
	/* Column Info */
	private String qty73 = null;
	/* Column Info */
	private String qty44 = null;
	/* Column Info */
	private String qty62 = null;
	/* Column Info */
	private String qty74 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MBDResultCOABKGVO() {}

	public MBDResultCOABKGVO(String ibflag, String pagerows, String qty11, String qty12, String qty35, String qty55, String qty54, String qty53, String qty52, String qty15, String qty34, String qty51, String qty33, String qty13, String qty32, String qty14, String qty31, String locCd, String qty0, String qty21, String qty22, String qty23, String qty75, String qty65, String qty64, String qty41, String qty71, String qty61, String qty24, String qty43, String qty72, String qty25, String qty42, String qty73, String qty63, String qty45, String qty74, String qty62, String qty44, String div) {
		this.qty11 = qty11;
		this.qty12 = qty12;
		this.qty35 = qty35;
		this.div = div;
		this.qty55 = qty55;
		this.qty54 = qty54;
		this.qty53 = qty53;
		this.qty34 = qty34;
		this.qty15 = qty15;
		this.qty52 = qty52;
		this.qty33 = qty33;
		this.qty51 = qty51;
		this.qty13 = qty13;
		this.qty32 = qty32;
		this.pagerows = pagerows;
		this.qty14 = qty14;
		this.qty31 = qty31;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.qty0 = qty0;
		this.qty21 = qty21;
		this.qty22 = qty22;
		this.qty23 = qty23;
		this.qty75 = qty75;
		this.qty65 = qty65;
		this.qty64 = qty64;
		this.qty41 = qty41;
		this.qty43 = qty43;
		this.qty24 = qty24;
		this.qty61 = qty61;
		this.qty71 = qty71;
		this.qty42 = qty42;
		this.qty25 = qty25;
		this.qty72 = qty72;
		this.qty45 = qty45;
		this.qty63 = qty63;
		this.qty73 = qty73;
		this.qty44 = qty44;
		this.qty62 = qty62;
		this.qty74 = qty74;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("qty1_1", getQty11());
		this.hashColumns.put("qty1_2", getQty12());
		this.hashColumns.put("qty3_5", getQty35());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("qty5_5", getQty55());
		this.hashColumns.put("qty5_4", getQty54());
		this.hashColumns.put("qty5_3", getQty53());
		this.hashColumns.put("qty3_4", getQty34());
		this.hashColumns.put("qty1_5", getQty15());
		this.hashColumns.put("qty5_2", getQty52());
		this.hashColumns.put("qty3_3", getQty33());
		this.hashColumns.put("qty5_1", getQty51());
		this.hashColumns.put("qty1_3", getQty13());
		this.hashColumns.put("qty3_2", getQty32());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("qty1_4", getQty14());
		this.hashColumns.put("qty3_1", getQty31());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("qty0", getQty0());
		this.hashColumns.put("qty2_1", getQty21());
		this.hashColumns.put("qty2_2", getQty22());
		this.hashColumns.put("qty2_3", getQty23());
		this.hashColumns.put("qty7_5", getQty75());
		this.hashColumns.put("qty6_5", getQty65());
		this.hashColumns.put("qty6_4", getQty64());
		this.hashColumns.put("qty4_1", getQty41());
		this.hashColumns.put("qty4_3", getQty43());
		this.hashColumns.put("qty2_4", getQty24());
		this.hashColumns.put("qty6_1", getQty61());
		this.hashColumns.put("qty7_1", getQty71());
		this.hashColumns.put("qty4_2", getQty42());
		this.hashColumns.put("qty2_5", getQty25());
		this.hashColumns.put("qty7_2", getQty72());
		this.hashColumns.put("qty4_5", getQty45());
		this.hashColumns.put("qty6_3", getQty63());
		this.hashColumns.put("qty7_3", getQty73());
		this.hashColumns.put("qty4_4", getQty44());
		this.hashColumns.put("qty6_2", getQty62());
		this.hashColumns.put("qty7_4", getQty74());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("qty1_1", "qty11");
		this.hashFields.put("qty1_2", "qty12");
		this.hashFields.put("qty3_5", "qty35");
		this.hashFields.put("div", "div");
		this.hashFields.put("qty5_5", "qty55");
		this.hashFields.put("qty5_4", "qty54");
		this.hashFields.put("qty5_3", "qty53");
		this.hashFields.put("qty3_4", "qty34");
		this.hashFields.put("qty1_5", "qty15");
		this.hashFields.put("qty5_2", "qty52");
		this.hashFields.put("qty3_3", "qty33");
		this.hashFields.put("qty5_1", "qty51");
		this.hashFields.put("qty1_3", "qty13");
		this.hashFields.put("qty3_2", "qty32");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("qty1_4", "qty14");
		this.hashFields.put("qty3_1", "qty31");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("qty0", "qty0");
		this.hashFields.put("qty2_1", "qty21");
		this.hashFields.put("qty2_2", "qty22");
		this.hashFields.put("qty2_3", "qty23");
		this.hashFields.put("qty7_5", "qty75");
		this.hashFields.put("qty6_5", "qty65");
		this.hashFields.put("qty6_4", "qty64");
		this.hashFields.put("qty4_1", "qty41");
		this.hashFields.put("qty4_3", "qty43");
		this.hashFields.put("qty2_4", "qty24");
		this.hashFields.put("qty6_1", "qty61");
		this.hashFields.put("qty7_1", "qty71");
		this.hashFields.put("qty4_2", "qty42");
		this.hashFields.put("qty2_5", "qty25");
		this.hashFields.put("qty7_2", "qty72");
		this.hashFields.put("qty4_5", "qty45");
		this.hashFields.put("qty6_3", "qty63");
		this.hashFields.put("qty7_3", "qty73");
		this.hashFields.put("qty4_4", "qty44");
		this.hashFields.put("qty6_2", "qty62");
		this.hashFields.put("qty7_4", "qty74");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return qty11
	 */
	public String getQty11() {
		return this.qty11;
	}
	
	/**
	 * Column Info
	 * @return qty12
	 */
	public String getQty12() {
		return this.qty12;
	}
	
	/**
	 * Column Info
	 * @return qty35
	 */
	public String getQty35() {
		return this.qty35;
	}
	
	/**
	 * Column Info
	 * @return div
	 */
	public String getDiv() {
		return this.div;
	}
	
	/**
	 * Column Info
	 * @return qty55
	 */
	public String getQty55() {
		return this.qty55;
	}
	
	/**
	 * Column Info
	 * @return qty54
	 */
	public String getQty54() {
		return this.qty54;
	}
	
	/**
	 * Column Info
	 * @return qty53
	 */
	public String getQty53() {
		return this.qty53;
	}
	
	/**
	 * Column Info
	 * @return qty34
	 */
	public String getQty34() {
		return this.qty34;
	}
	
	/**
	 * Column Info
	 * @return qty15
	 */
	public String getQty15() {
		return this.qty15;
	}
	
	/**
	 * Column Info
	 * @return qty52
	 */
	public String getQty52() {
		return this.qty52;
	}
	
	/**
	 * Column Info
	 * @return qty33
	 */
	public String getQty33() {
		return this.qty33;
	}
	
	/**
	 * Column Info
	 * @return qty51
	 */
	public String getQty51() {
		return this.qty51;
	}
	
	/**
	 * Column Info
	 * @return qty13
	 */
	public String getQty13() {
		return this.qty13;
	}
	
	/**
	 * Column Info
	 * @return qty32
	 */
	public String getQty32() {
		return this.qty32;
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
	 * @return qty14
	 */
	public String getQty14() {
		return this.qty14;
	}
	
	/**
	 * Column Info
	 * @return qty31
	 */
	public String getQty31() {
		return this.qty31;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return qty0
	 */
	public String getQty0() {
		return this.qty0;
	}
	
	/**
	 * Column Info
	 * @return qty21
	 */
	public String getQty21() {
		return this.qty21;
	}
	
	/**
	 * Column Info
	 * @return qty22
	 */
	public String getQty22() {
		return this.qty22;
	}
	
	/**
	 * Column Info
	 * @return qty23
	 */
	public String getQty23() {
		return this.qty23;
	}
	
	/**
	 * Column Info
	 * @return qty75
	 */
	public String getQty75() {
		return this.qty75;
	}
	
	/**
	 * Column Info
	 * @return qty65
	 */
	public String getQty65() {
		return this.qty65;
	}
	
	/**
	 * Column Info
	 * @return qty64
	 */
	public String getQty64() {
		return this.qty64;
	}
	
	/**
	 * Column Info
	 * @return qty41
	 */
	public String getQty41() {
		return this.qty41;
	}
	
	/**
	 * Column Info
	 * @return qty43
	 */
	public String getQty43() {
		return this.qty43;
	}
	
	/**
	 * Column Info
	 * @return qty24
	 */
	public String getQty24() {
		return this.qty24;
	}
	
	/**
	 * Column Info
	 * @return qty61
	 */
	public String getQty61() {
		return this.qty61;
	}
	
	/**
	 * Column Info
	 * @return qty71
	 */
	public String getQty71() {
		return this.qty71;
	}
	
	/**
	 * Column Info
	 * @return qty42
	 */
	public String getQty42() {
		return this.qty42;
	}
	
	/**
	 * Column Info
	 * @return qty25
	 */
	public String getQty25() {
		return this.qty25;
	}
	
	/**
	 * Column Info
	 * @return qty72
	 */
	public String getQty72() {
		return this.qty72;
	}
	
	/**
	 * Column Info
	 * @return qty45
	 */
	public String getQty45() {
		return this.qty45;
	}
	
	/**
	 * Column Info
	 * @return qty63
	 */
	public String getQty63() {
		return this.qty63;
	}
	
	/**
	 * Column Info
	 * @return qty73
	 */
	public String getQty73() {
		return this.qty73;
	}
	
	/**
	 * Column Info
	 * @return qty44
	 */
	public String getQty44() {
		return this.qty44;
	}
	
	/**
	 * Column Info
	 * @return qty62
	 */
	public String getQty62() {
		return this.qty62;
	}
	
	/**
	 * Column Info
	 * @return qty74
	 */
	public String getQty74() {
		return this.qty74;
	}
	

	/**
	 * Column Info
	 * @param qty11
	 */
	public void setQty11(String qty11) {
		this.qty11 = qty11;
	}
	
	/**
	 * Column Info
	 * @param qty12
	 */
	public void setQty12(String qty12) {
		this.qty12 = qty12;
	}
	
	/**
	 * Column Info
	 * @param qty35
	 */
	public void setQty35(String qty35) {
		this.qty35 = qty35;
	}
	
	/**
	 * Column Info
	 * @param div
	 */
	public void setDiv(String div) {
		this.div = div;
	}
	
	/**
	 * Column Info
	 * @param qty55
	 */
	public void setQty55(String qty55) {
		this.qty55 = qty55;
	}
	
	/**
	 * Column Info
	 * @param qty54
	 */
	public void setQty54(String qty54) {
		this.qty54 = qty54;
	}
	
	/**
	 * Column Info
	 * @param qty53
	 */
	public void setQty53(String qty53) {
		this.qty53 = qty53;
	}
	
	/**
	 * Column Info
	 * @param qty34
	 */
	public void setQty34(String qty34) {
		this.qty34 = qty34;
	}
	
	/**
	 * Column Info
	 * @param qty15
	 */
	public void setQty15(String qty15) {
		this.qty15 = qty15;
	}
	
	/**
	 * Column Info
	 * @param qty52
	 */
	public void setQty52(String qty52) {
		this.qty52 = qty52;
	}
	
	/**
	 * Column Info
	 * @param qty33
	 */
	public void setQty33(String qty33) {
		this.qty33 = qty33;
	}
	
	/**
	 * Column Info
	 * @param qty51
	 */
	public void setQty51(String qty51) {
		this.qty51 = qty51;
	}
	
	/**
	 * Column Info
	 * @param qty13
	 */
	public void setQty13(String qty13) {
		this.qty13 = qty13;
	}
	
	/**
	 * Column Info
	 * @param qty32
	 */
	public void setQty32(String qty32) {
		this.qty32 = qty32;
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
	 * @param qty14
	 */
	public void setQty14(String qty14) {
		this.qty14 = qty14;
	}
	
	/**
	 * Column Info
	 * @param qty31
	 */
	public void setQty31(String qty31) {
		this.qty31 = qty31;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param qty0
	 */
	public void setQty0(String qty0) {
		this.qty0 = qty0;
	}
	
	/**
	 * Column Info
	 * @param qty21
	 */
	public void setQty21(String qty21) {
		this.qty21 = qty21;
	}
	
	/**
	 * Column Info
	 * @param qty22
	 */
	public void setQty22(String qty22) {
		this.qty22 = qty22;
	}
	
	/**
	 * Column Info
	 * @param qty23
	 */
	public void setQty23(String qty23) {
		this.qty23 = qty23;
	}
	
	/**
	 * Column Info
	 * @param qty75
	 */
	public void setQty75(String qty75) {
		this.qty75 = qty75;
	}
	
	/**
	 * Column Info
	 * @param qty65
	 */
	public void setQty65(String qty65) {
		this.qty65 = qty65;
	}
	
	/**
	 * Column Info
	 * @param qty64
	 */
	public void setQty64(String qty64) {
		this.qty64 = qty64;
	}
	
	/**
	 * Column Info
	 * @param qty41
	 */
	public void setQty41(String qty41) {
		this.qty41 = qty41;
	}
	
	/**
	 * Column Info
	 * @param qty43
	 */
	public void setQty43(String qty43) {
		this.qty43 = qty43;
	}
	
	/**
	 * Column Info
	 * @param qty24
	 */
	public void setQty24(String qty24) {
		this.qty24 = qty24;
	}
	
	/**
	 * Column Info
	 * @param qty61
	 */
	public void setQty61(String qty61) {
		this.qty61 = qty61;
	}
	
	/**
	 * Column Info
	 * @param qty71
	 */
	public void setQty71(String qty71) {
		this.qty71 = qty71;
	}
	
	/**
	 * Column Info
	 * @param qty42
	 */
	public void setQty42(String qty42) {
		this.qty42 = qty42;
	}
	
	/**
	 * Column Info
	 * @param qty25
	 */
	public void setQty25(String qty25) {
		this.qty25 = qty25;
	}
	
	/**
	 * Column Info
	 * @param qty72
	 */
	public void setQty72(String qty72) {
		this.qty72 = qty72;
	}
	
	/**
	 * Column Info
	 * @param qty45
	 */
	public void setQty45(String qty45) {
		this.qty45 = qty45;
	}
	
	/**
	 * Column Info
	 * @param qty63
	 */
	public void setQty63(String qty63) {
		this.qty63 = qty63;
	}
	
	/**
	 * Column Info
	 * @param qty73
	 */
	public void setQty73(String qty73) {
		this.qty73 = qty73;
	}
	
	/**
	 * Column Info
	 * @param qty44
	 */
	public void setQty44(String qty44) {
		this.qty44 = qty44;
	}
	
	/**
	 * Column Info
	 * @param qty62
	 */
	public void setQty62(String qty62) {
		this.qty62 = qty62;
	}
	
	/**
	 * Column Info
	 * @param qty74
	 */
	public void setQty74(String qty74) {
		this.qty74 = qty74;
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
		setQty11(JSPUtil.getParameter(request, prefix + "qty1_1", ""));
		setQty12(JSPUtil.getParameter(request, prefix + "qty1_2", ""));
		setQty35(JSPUtil.getParameter(request, prefix + "qty3_5", ""));
		setDiv(JSPUtil.getParameter(request, prefix + "div", ""));
		setQty55(JSPUtil.getParameter(request, prefix + "qty5_5", ""));
		setQty54(JSPUtil.getParameter(request, prefix + "qty5_4", ""));
		setQty53(JSPUtil.getParameter(request, prefix + "qty5_3", ""));
		setQty34(JSPUtil.getParameter(request, prefix + "qty3_4", ""));
		setQty15(JSPUtil.getParameter(request, prefix + "qty1_5", ""));
		setQty52(JSPUtil.getParameter(request, prefix + "qty5_2", ""));
		setQty33(JSPUtil.getParameter(request, prefix + "qty3_3", ""));
		setQty51(JSPUtil.getParameter(request, prefix + "qty5_1", ""));
		setQty13(JSPUtil.getParameter(request, prefix + "qty1_3", ""));
		setQty32(JSPUtil.getParameter(request, prefix + "qty3_2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setQty14(JSPUtil.getParameter(request, prefix + "qty1_4", ""));
		setQty31(JSPUtil.getParameter(request, prefix + "qty3_1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setQty0(JSPUtil.getParameter(request, prefix + "qty0", ""));
		setQty21(JSPUtil.getParameter(request, prefix + "qty2_1", ""));
		setQty22(JSPUtil.getParameter(request, prefix + "qty2_2", ""));
		setQty23(JSPUtil.getParameter(request, prefix + "qty2_3", ""));
		setQty75(JSPUtil.getParameter(request, prefix + "qty7_5", ""));
		setQty65(JSPUtil.getParameter(request, prefix + "qty6_5", ""));
		setQty64(JSPUtil.getParameter(request, prefix + "qty6_4", ""));
		setQty41(JSPUtil.getParameter(request, prefix + "qty4_1", ""));
		setQty43(JSPUtil.getParameter(request, prefix + "qty4_3", ""));
		setQty24(JSPUtil.getParameter(request, prefix + "qty2_4", ""));
		setQty61(JSPUtil.getParameter(request, prefix + "qty6_1", ""));
		setQty71(JSPUtil.getParameter(request, prefix + "qty7_1", ""));
		setQty42(JSPUtil.getParameter(request, prefix + "qty4_2", ""));
		setQty25(JSPUtil.getParameter(request, prefix + "qty2_5", ""));
		setQty72(JSPUtil.getParameter(request, prefix + "qty7_2", ""));
		setQty45(JSPUtil.getParameter(request, prefix + "qty4_5", ""));
		setQty63(JSPUtil.getParameter(request, prefix + "qty6_3", ""));
		setQty73(JSPUtil.getParameter(request, prefix + "qty7_3", ""));
		setQty44(JSPUtil.getParameter(request, prefix + "qty4_4", ""));
		setQty62(JSPUtil.getParameter(request, prefix + "qty6_2", ""));
		setQty74(JSPUtil.getParameter(request, prefix + "qty7_4", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MBDResultCOABKGVO[]
	 */
	public MBDResultCOABKGVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MBDResultCOABKGVO[]
	 */
	public MBDResultCOABKGVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MBDResultCOABKGVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] qty11 = (JSPUtil.getParameter(request, prefix	+ "qty1_1", length));
			String[] qty12 = (JSPUtil.getParameter(request, prefix	+ "qty1_2", length));
			String[] qty35 = (JSPUtil.getParameter(request, prefix	+ "qty3_5", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] qty55 = (JSPUtil.getParameter(request, prefix	+ "qty5_5", length));
			String[] qty54 = (JSPUtil.getParameter(request, prefix	+ "qty5_4", length));
			String[] qty53 = (JSPUtil.getParameter(request, prefix	+ "qty5_3", length));
			String[] qty34 = (JSPUtil.getParameter(request, prefix	+ "qty3_4", length));
			String[] qty15 = (JSPUtil.getParameter(request, prefix	+ "qty1_5", length));
			String[] qty52 = (JSPUtil.getParameter(request, prefix	+ "qty5_2", length));
			String[] qty33 = (JSPUtil.getParameter(request, prefix	+ "qty3_3", length));
			String[] qty51 = (JSPUtil.getParameter(request, prefix	+ "qty5_1", length));
			String[] qty13 = (JSPUtil.getParameter(request, prefix	+ "qty1_3", length));
			String[] qty32 = (JSPUtil.getParameter(request, prefix	+ "qty3_2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] qty14 = (JSPUtil.getParameter(request, prefix	+ "qty1_4", length));
			String[] qty31 = (JSPUtil.getParameter(request, prefix	+ "qty3_1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] qty0 = (JSPUtil.getParameter(request, prefix	+ "qty0", length));
			String[] qty21 = (JSPUtil.getParameter(request, prefix	+ "qty2_1", length));
			String[] qty22 = (JSPUtil.getParameter(request, prefix	+ "qty2_2", length));
			String[] qty23 = (JSPUtil.getParameter(request, prefix	+ "qty2_3", length));
			String[] qty75 = (JSPUtil.getParameter(request, prefix	+ "qty7_5", length));
			String[] qty65 = (JSPUtil.getParameter(request, prefix	+ "qty6_5", length));
			String[] qty64 = (JSPUtil.getParameter(request, prefix	+ "qty6_4", length));
			String[] qty41 = (JSPUtil.getParameter(request, prefix	+ "qty4_1", length));
			String[] qty43 = (JSPUtil.getParameter(request, prefix	+ "qty4_3", length));
			String[] qty24 = (JSPUtil.getParameter(request, prefix	+ "qty2_4", length));
			String[] qty61 = (JSPUtil.getParameter(request, prefix	+ "qty6_1", length));
			String[] qty71 = (JSPUtil.getParameter(request, prefix	+ "qty7_1", length));
			String[] qty42 = (JSPUtil.getParameter(request, prefix	+ "qty4_2", length));
			String[] qty25 = (JSPUtil.getParameter(request, prefix	+ "qty2_5", length));
			String[] qty72 = (JSPUtil.getParameter(request, prefix	+ "qty7_2", length));
			String[] qty45 = (JSPUtil.getParameter(request, prefix	+ "qty4_5", length));
			String[] qty63 = (JSPUtil.getParameter(request, prefix	+ "qty6_3", length));
			String[] qty73 = (JSPUtil.getParameter(request, prefix	+ "qty7_3", length));
			String[] qty44 = (JSPUtil.getParameter(request, prefix	+ "qty4_4", length));
			String[] qty62 = (JSPUtil.getParameter(request, prefix	+ "qty6_2", length));
			String[] qty74 = (JSPUtil.getParameter(request, prefix	+ "qty7_4", length));
			
			for (int i = 0; i < length; i++) {
				model = new MBDResultCOABKGVO();
				if (qty11[i] != null)
					model.setQty11(qty11[i]);
				if (qty12[i] != null)
					model.setQty12(qty12[i]);
				if (qty35[i] != null)
					model.setQty35(qty35[i]);
				if (div[i] != null)
					model.setDiv(div[i]);
				if (qty55[i] != null)
					model.setQty55(qty55[i]);
				if (qty54[i] != null)
					model.setQty54(qty54[i]);
				if (qty53[i] != null)
					model.setQty53(qty53[i]);
				if (qty34[i] != null)
					model.setQty34(qty34[i]);
				if (qty15[i] != null)
					model.setQty15(qty15[i]);
				if (qty52[i] != null)
					model.setQty52(qty52[i]);
				if (qty33[i] != null)
					model.setQty33(qty33[i]);
				if (qty51[i] != null)
					model.setQty51(qty51[i]);
				if (qty13[i] != null)
					model.setQty13(qty13[i]);
				if (qty32[i] != null)
					model.setQty32(qty32[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (qty14[i] != null)
					model.setQty14(qty14[i]);
				if (qty31[i] != null)
					model.setQty31(qty31[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (qty0[i] != null)
					model.setQty0(qty0[i]);
				if (qty21[i] != null)
					model.setQty21(qty21[i]);
				if (qty22[i] != null)
					model.setQty22(qty22[i]);
				if (qty23[i] != null)
					model.setQty23(qty23[i]);
				if (qty75[i] != null)
					model.setQty75(qty75[i]);
				if (qty65[i] != null)
					model.setQty65(qty65[i]);
				if (qty64[i] != null)
					model.setQty64(qty64[i]);
				if (qty41[i] != null)
					model.setQty41(qty41[i]);
				if (qty43[i] != null)
					model.setQty43(qty43[i]);
				if (qty24[i] != null)
					model.setQty24(qty24[i]);
				if (qty61[i] != null)
					model.setQty61(qty61[i]);
				if (qty71[i] != null)
					model.setQty71(qty71[i]);
				if (qty42[i] != null)
					model.setQty42(qty42[i]);
				if (qty25[i] != null)
					model.setQty25(qty25[i]);
				if (qty72[i] != null)
					model.setQty72(qty72[i]);
				if (qty45[i] != null)
					model.setQty45(qty45[i]);
				if (qty63[i] != null)
					model.setQty63(qty63[i]);
				if (qty73[i] != null)
					model.setQty73(qty73[i]);
				if (qty44[i] != null)
					model.setQty44(qty44[i]);
				if (qty62[i] != null)
					model.setQty62(qty62[i]);
				if (qty74[i] != null)
					model.setQty74(qty74[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMBDResultCOABKGVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MBDResultCOABKGVO[]
	 */
	public MBDResultCOABKGVO[] getMBDResultCOABKGVOs(){
		MBDResultCOABKGVO[] vos = (MBDResultCOABKGVO[])models.toArray(new MBDResultCOABKGVO[models.size()]);
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
		this.qty11 = this.qty11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty12 = this.qty12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty35 = this.qty35 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty55 = this.qty55 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty54 = this.qty54 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty53 = this.qty53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty34 = this.qty34 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty15 = this.qty15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty52 = this.qty52 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty33 = this.qty33 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty51 = this.qty51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty13 = this.qty13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty32 = this.qty32 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty14 = this.qty14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty31 = this.qty31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty0 = this.qty0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty21 = this.qty21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty22 = this.qty22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty23 = this.qty23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty75 = this.qty75 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty65 = this.qty65 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty64 = this.qty64 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty41 = this.qty41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty43 = this.qty43 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty24 = this.qty24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty61 = this.qty61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty71 = this.qty71 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty42 = this.qty42 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty25 = this.qty25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty72 = this.qty72 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty45 = this.qty45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty63 = this.qty63 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty73 = this.qty73 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty44 = this.qty44 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty62 = this.qty62 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty74 = this.qty74 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
