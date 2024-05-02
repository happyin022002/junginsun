/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchApprovalVO.java
*@FileTitle : SearchApprovalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.09.23 진준성 
* 1.0 Creation
* =======================================================
* 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 진준성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchApprovalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchApprovalVO> models = new ArrayList<SearchApprovalVO>();
	
	
	/* Column Info */
	private String t2 = null;
	/* Column Info */
	private String dw = null;
	/* Column Info */
	private String p4 = null;
	/* Column Info */
	private String dx = null;
	/* Column Info */
	private String p2 = null;
	/* Column Info */
	private String d9 = null;
	/* Column Info */
	private String d8 = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String periodStdt = null;
	/* Column Info */
	private String d7 = null;
	/* Column Info */
	private String newVanTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tysz = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String d2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String d3 = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String a2 = null;
	/* Column Info */
	private String a4 = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String f2 = null;
	/* Column Info */
	private String f5 = null;
	/* Column Info */
	private String s4 = null;
	/* Column Info */
	private String f4 = null;
	/* Column Info */
	private String locTp = null;
	/* Column Info */
	private String s2 = null;
	/* Column Info */
	private String o2 = null;
	/* Column Info */
	private String q2 = null;
	/* Column Info */
	private String o4 = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String q4 = null;
	/* Column Info */
	private String pkupDueDt = null;
	/* Column Info */
	private String qtyTotal = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String authNo = null;
	/* Column Info */
	private String t4 = null;
	/* Column Info */
	private String r7 = null;
	/* Column Info */
	private String divsion = null;
	/* Column Info */
	private String r2 = null;
	/* Column Info */
	private String r4 = null;
	/* Column Info */
	private String periodEddt = null;
	/* Column Info */
	private String r5 = null;
	/* Column Info */
	private String a5 = null;
	/* Column Info */
	private String d1 = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String balTp = null;
	/* Column Info */
	private String ctrtNo = null;
  	/* RowSet Info */
	private DBRowSet dbRowset = null;  
    
	/**
	 * rowset을 담기위한 변수
	 */
    public DBRowSet getDbRowset() {
		return dbRowset;
	}

	public void setDbRowset(DBRowSet dbRowset) {
		this.dbRowset = dbRowset;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchApprovalVO() {}

	public SearchApprovalVO(String ibflag, String pagerows, String q4, String q2, String d2, String o2, String s2, String r2, String a2, String t2, String f2, String p2, String d5, String d4, String o4, String s4, String a4, String f5, String t4, String f4, String r5, String p4, String r4, String d7, String r7, String d9, String d8, String dx, String dw, String d3, String periodStdt, String newVanTpCd, String locCd, String cntrTpszCd, String agmtCtyCd, String lstmCd, String locTp, String agmtSeq, String authNo, String agmtNo, String qtyTotal, String pkupDueDt, String divsion, String periodEddt, String tysz, String refNo, String vndrAbbrNm, String balTp, String ctrtNo, String a5, String d1) {
		this.t2 = t2;
		this.dw = dw;
		this.p4 = p4;
		this.dx = dx;
		this.p2 = p2;
		this.d9 = d9;
		this.d8 = d8;
		this.d5 = d5;
		this.d4 = d4;
		this.periodStdt = periodStdt;
		this.d7 = d7;
		this.newVanTpCd = newVanTpCd;
		this.pagerows = pagerows;
		this.tysz = tysz;
		this.locCd = locCd;
		this.d2 = d2;
		this.ibflag = ibflag;
		this.d3 = d3;
		this.agmtCtyCd = agmtCtyCd;
		this.cntrTpszCd = cntrTpszCd;
		this.a2 = a2;
		this.a4 = a4;
		this.lstmCd = lstmCd;
		this.f2 = f2;
		this.f5 = f5;
		this.s4 = s4;
		this.f4 = f4;
		this.locTp = locTp;
		this.s2 = s2;
		this.o2 = o2;
		this.q2 = q2;
		this.o4 = o4;
		this.agmtSeq = agmtSeq;
		this.q4 = q4;
		this.pkupDueDt = pkupDueDt;
		this.qtyTotal = qtyTotal;
		this.agmtNo = agmtNo;
		this.authNo = authNo;
		this.t4 = t4;
		this.r7 = r7;
		this.divsion = divsion;
		this.r2 = r2;
		this.r4 = r4;
		this.periodEddt = periodEddt;
		this.r5 = r5;
		this.a5 = a5;
		this.d1 = d1;
		this.refNo = refNo;
		this.vndrAbbrNm = vndrAbbrNm;
		this.balTp = balTp;
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("t2", getT2());
		this.hashColumns.put("dw", getDw());
		this.hashColumns.put("p4", getP4());
		this.hashColumns.put("dx", getDx());
		this.hashColumns.put("p2", getP2());
		this.hashColumns.put("d9", getD9());
		this.hashColumns.put("d8", getD8());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("period_stdt", getPeriodStdt());
		this.hashColumns.put("d7", getD7());
		this.hashColumns.put("new_van_tp_cd", getNewVanTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tysz", getTysz());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("d3", getD3());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("a2", getA2());
		this.hashColumns.put("a4", getA4());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("f2", getF2());
		this.hashColumns.put("f5", getF5());
		this.hashColumns.put("s4", getS4());
		this.hashColumns.put("f4", getF4());
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("s2", getS2());
		this.hashColumns.put("o2", getO2());
		this.hashColumns.put("q2", getQ2());
		this.hashColumns.put("o4", getO4());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("q4", getQ4());
		this.hashColumns.put("pkup_due_dt", getPkupDueDt());
		this.hashColumns.put("qty_total", getQtyTotal());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("auth_no", getAuthNo());
		this.hashColumns.put("t4", getT4());
		this.hashColumns.put("r7", getR7());
		this.hashColumns.put("divsion", getDivsion());
		this.hashColumns.put("r2", getR2());
		this.hashColumns.put("r4", getR4());
		this.hashColumns.put("period_eddt", getPeriodEddt());
		this.hashColumns.put("r5", getR5());
		this.hashColumns.put("a5", getA5());
		this.hashColumns.put("d1", getD1());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("bal_tp", getBalTp());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("t2", "t2");
		this.hashFields.put("dw", "dw");
		this.hashFields.put("p4", "p4");
		this.hashFields.put("dx", "dx");
		this.hashFields.put("p2", "p2");
		this.hashFields.put("d9", "d9");
		this.hashFields.put("d8", "d8");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("period_stdt", "periodStdt");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("new_van_tp_cd", "newVanTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tysz", "tysz");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("d3", "d3");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("a2", "a2");
		this.hashFields.put("a4", "a4");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("f5", "f5");
		this.hashFields.put("s4", "s4");
		this.hashFields.put("f4", "f4");
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("s2", "s2");
		this.hashFields.put("o2", "o2");
		this.hashFields.put("q2", "q2");
		this.hashFields.put("o4", "o4");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("q4", "q4");
		this.hashFields.put("pkup_due_dt", "pkupDueDt");
		this.hashFields.put("qty_total", "qtyTotal");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("auth_no", "authNo");
		this.hashFields.put("t4", "t4");
		this.hashFields.put("r7", "r7");
		this.hashFields.put("divsion", "divsion");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("r4", "r4");
		this.hashFields.put("period_eddt", "periodEddt");
		this.hashFields.put("r5", "r5");
		this.hashFields.put("a5", "a5");
		this.hashFields.put("d1", "d1");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("bal_tp", "balTp");
		this.hashFields.put("ctrt_no", "ctrtNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return t2
	 */
	public String getT2() {
		return this.t2;
	}
	
	/**
	 * Column Info
	 * @return dw
	 */
	public String getDw() {
		return this.dw;
	}
	
	/**
	 * Column Info
	 * @return p4
	 */
	public String getP4() {
		return this.p4;
	}
	
	/**
	 * Column Info
	 * @return dx
	 */
	public String getDx() {
		return this.dx;
	}
	
	/**
	 * Column Info
	 * @return p2
	 */
	public String getP2() {
		return this.p2;
	}
	
	/**
	 * Column Info
	 * @return d9
	 */
	public String getD9() {
		return this.d9;
	}
	
	/**
	 * Column Info
	 * @return d8
	 */
	public String getD8() {
		return this.d8;
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
	 * @return d4
	 */
	public String getD4() {
		return this.d4;
	}
	
	/**
	 * Column Info
	 * @return periodStdt
	 */
	public String getPeriodStdt() {
		return this.periodStdt;
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
	 * @return newVanTpCd
	 */
	public String getNewVanTpCd() {
		return this.newVanTpCd;
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
	 * @return tysz
	 */
	public String getTysz() {
		return this.tysz;
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
	 * @return d2
	 */
	public String getD2() {
		return this.d2;
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
	 * @return d3
	 */
	public String getD3() {
		return this.d3;
	}
	
	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
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
	 * @return a2
	 */
	public String getA2() {
		return this.a2;
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
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return locTp
	 */
	public String getLocTp() {
		return this.locTp;
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
	 * @return q2
	 */
	public String getQ2() {
		return this.q2;
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
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return q4
	 */
	public String getQ4() {
		return this.q4;
	}
	
	/**
	 * Column Info
	 * @return pkupDueDt
	 */
	public String getPkupDueDt() {
		return this.pkupDueDt;
	}
	
	/**
	 * Column Info
	 * @return qtyTotal
	 */
	public String getQtyTotal() {
		return this.qtyTotal;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return authNo
	 */
	public String getAuthNo() {
		return this.authNo;
	}
	
	/**
	 * Column Info
	 * @return t4
	 */
	public String getT4() {
		return this.t4;
	}
	
	/**
	 * Column Info
	 * @return r7
	 */
	public String getR7() {
		return this.r7;
	}
	
	/**
	 * Column Info
	 * @return divsion
	 */
	public String getDivsion() {
		return this.divsion;
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
	 * @return periodEddt
	 */
	public String getPeriodEddt() {
		return this.periodEddt;
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
	 * @return a5
	 */
	public String getA5() {
		return this.a5;
	}
	
	/**
	 * Column Info
	 * @return d1
	 */
	public String getD1() {
		return this.d1;
	}
	
	/**
	 * Column Info
	 * @return ref_no
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return balTp
	 */
	public String getBalTp() {
		return this.balTp;
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
	 * @param t2
	 */
	public void setT2(String t2) {
		this.t2 = t2;
	}
	
	/**
	 * Column Info
	 * @param dw
	 */
	public void setDw(String dw) {
		this.dw = dw;
	}
	
	/**
	 * Column Info
	 * @param p4
	 */
	public void setP4(String p4) {
		this.p4 = p4;
	}
	
	/**
	 * Column Info
	 * @param dx
	 */
	public void setDx(String dx) {
		this.dx = dx;
	}
	
	/**
	 * Column Info
	 * @param p2
	 */
	public void setP2(String p2) {
		this.p2 = p2;
	}
	
	/**
	 * Column Info
	 * @param d9
	 */
	public void setD9(String d9) {
		this.d9 = d9;
	}
	
	/**
	 * Column Info
	 * @param d8
	 */
	public void setD8(String d8) {
		this.d8 = d8;
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
	 * @param d4
	 */
	public void setD4(String d4) {
		this.d4 = d4;
	}
	
	/**
	 * Column Info
	 * @param periodStdt
	 */
	public void setPeriodStdt(String periodStdt) {
		this.periodStdt = periodStdt;
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
	 * @param newVanTpCd
	 */
	public void setNewVanTpCd(String newVanTpCd) {
		this.newVanTpCd = newVanTpCd;
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
	 * @param tysz
	 */
	public void setTysz(String tysz) {
		this.tysz = tysz;
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
	 * @param d2
	 */
	public void setD2(String d2) {
		this.d2 = d2;
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
	 * @param d3
	 */
	public void setD3(String d3) {
		this.d3 = d3;
	}
	
	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
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
	 * @param a2
	 */
	public void setA2(String a2) {
		this.a2 = a2;
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
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param locTp
	 */
	public void setLocTp(String locTp) {
		this.locTp = locTp;
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
	 * @param q2
	 */
	public void setQ2(String q2) {
		this.q2 = q2;
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
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param q4
	 */
	public void setQ4(String q4) {
		this.q4 = q4;
	}
	
	/**
	 * Column Info
	 * @param pkupDueDt
	 */
	public void setPkupDueDt(String pkupDueDt) {
		this.pkupDueDt = pkupDueDt;
	}
	
	/**
	 * Column Info
	 * @param qtyTotal
	 */
	public void setQtyTotal(String qtyTotal) {
		this.qtyTotal = qtyTotal;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param authNo
	 */
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	
	/**
	 * Column Info
	 * @param t4
	 */
	public void setT4(String t4) {
		this.t4 = t4;
	}
	
	/**
	 * Column Info
	 * @param r7
	 */
	public void setR7(String r7) {
		this.r7 = r7;
	}
	
	/**
	 * Column Info
	 * @param divsion
	 */
	public void setDivsion(String divsion) {
		this.divsion = divsion;
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
	 * @param periodEddt
	 */
	public void setPeriodEddt(String periodEddt) {
		this.periodEddt = periodEddt;
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
	 * @param a5
	 */
	public void setA5(String a5) {
		this.a5 = a5;
	}
	
	/**
	 * Column Info
	 * @param d1
	 */
	public void setD1(String d1) {
		this.d1 = d1;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param balTp
	 */
	public void setBalTp(String balTp) {
		this.balTp = balTp;
	}
	
	/**
	 * Column Info
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setT2(JSPUtil.getParameter(request, "t2", ""));
		setDw(JSPUtil.getParameter(request, "dw", ""));
		setP4(JSPUtil.getParameter(request, "p4", ""));
		setDx(JSPUtil.getParameter(request, "dx", ""));
		setP2(JSPUtil.getParameter(request, "p2", ""));
		setD9(JSPUtil.getParameter(request, "d9", ""));
		setD8(JSPUtil.getParameter(request, "d8", ""));
		setD5(JSPUtil.getParameter(request, "d5", ""));
		setD4(JSPUtil.getParameter(request, "d4", ""));
		setPeriodStdt(JSPUtil.getParameter(request, "period_stdt", ""));
		setD7(JSPUtil.getParameter(request, "d7", ""));
		setNewVanTpCd(JSPUtil.getParameter(request, "new_van_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTysz(JSPUtil.getParameter(request, "tysz", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setD2(JSPUtil.getParameter(request, "d2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setD3(JSPUtil.getParameter(request, "d3", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setA2(JSPUtil.getParameter(request, "a2", ""));
		setA4(JSPUtil.getParameter(request, "a4", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setF2(JSPUtil.getParameter(request, "f2", ""));
		setF5(JSPUtil.getParameter(request, "f5", ""));
		setS4(JSPUtil.getParameter(request, "s4", ""));
		setF4(JSPUtil.getParameter(request, "f4", ""));
		setLocTp(JSPUtil.getParameter(request, "loc_tp", ""));
		setS2(JSPUtil.getParameter(request, "s2", ""));
		setO2(JSPUtil.getParameter(request, "o2", ""));
		setQ2(JSPUtil.getParameter(request, "q2", ""));
		setO4(JSPUtil.getParameter(request, "o4", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setQ4(JSPUtil.getParameter(request, "q4", ""));
		setPkupDueDt(JSPUtil.getParameter(request, "pkup_due_dt", ""));
		setQtyTotal(JSPUtil.getParameter(request, "qty_total", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setAuthNo(JSPUtil.getParameter(request, "auth_no", ""));
		setT4(JSPUtil.getParameter(request, "t4", ""));
		setR7(JSPUtil.getParameter(request, "r7", ""));
		setDivsion(JSPUtil.getParameter(request, "divsion", ""));
		setR2(JSPUtil.getParameter(request, "r2", ""));
		setR4(JSPUtil.getParameter(request, "r4", ""));
		setPeriodEddt(JSPUtil.getParameter(request, "period_eddt", ""));
		setR5(JSPUtil.getParameter(request, "r5", ""));
		setA5(JSPUtil.getParameter(request, "a5", ""));
		setD1(JSPUtil.getParameter(request, "d1", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setBalTp(JSPUtil.getParameter(request, "bal_tp", ""));
		setCtrtNo(JSPUtil.getParameter(request, "ctrt_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchApprovalVO[]
	 */
	public SearchApprovalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchApprovalVO[]
	 */
	public SearchApprovalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchApprovalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] t2 = (JSPUtil.getParameter(request, prefix	+ "t2", length));
			String[] dw = (JSPUtil.getParameter(request, prefix	+ "dw", length));
			String[] p4 = (JSPUtil.getParameter(request, prefix	+ "p4", length));
			String[] dx = (JSPUtil.getParameter(request, prefix	+ "dx", length));
			String[] p2 = (JSPUtil.getParameter(request, prefix	+ "p2", length));
			String[] d9 = (JSPUtil.getParameter(request, prefix	+ "d9", length));
			String[] d8 = (JSPUtil.getParameter(request, prefix	+ "d8", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4", length));
			String[] periodStdt = (JSPUtil.getParameter(request, prefix	+ "period_stdt", length));
			String[] d7 = (JSPUtil.getParameter(request, prefix	+ "d7", length));
			String[] newVanTpCd = (JSPUtil.getParameter(request, prefix	+ "new_van_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tysz = (JSPUtil.getParameter(request, prefix	+ "tysz", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] d3 = (JSPUtil.getParameter(request, prefix	+ "d3", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] a2 = (JSPUtil.getParameter(request, prefix	+ "a2", length));
			String[] a4 = (JSPUtil.getParameter(request, prefix	+ "a4", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] f2 = (JSPUtil.getParameter(request, prefix	+ "f2", length));
			String[] f5 = (JSPUtil.getParameter(request, prefix	+ "f5", length));
			String[] s4 = (JSPUtil.getParameter(request, prefix	+ "s4", length));
			String[] f4 = (JSPUtil.getParameter(request, prefix	+ "f4", length));
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp", length));
			String[] s2 = (JSPUtil.getParameter(request, prefix	+ "s2", length));
			String[] o2 = (JSPUtil.getParameter(request, prefix	+ "o2", length));
			String[] q2 = (JSPUtil.getParameter(request, prefix	+ "q2", length));
			String[] o4 = (JSPUtil.getParameter(request, prefix	+ "o4", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] q4 = (JSPUtil.getParameter(request, prefix	+ "q4", length));
			String[] pkupDueDt = (JSPUtil.getParameter(request, prefix	+ "pkup_due_dt", length));
			String[] qtyTotal = (JSPUtil.getParameter(request, prefix	+ "qty_total", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] authNo = (JSPUtil.getParameter(request, prefix	+ "auth_no", length));
			String[] t4 = (JSPUtil.getParameter(request, prefix	+ "t4", length));
			String[] r7 = (JSPUtil.getParameter(request, prefix	+ "r7", length));
			String[] divsion = (JSPUtil.getParameter(request, prefix	+ "divsion", length));
			String[] r2 = (JSPUtil.getParameter(request, prefix	+ "r2", length));
			String[] r4 = (JSPUtil.getParameter(request, prefix	+ "r4", length));
			String[] periodEddt = (JSPUtil.getParameter(request, prefix	+ "period_eddt", length));
			String[] r5 = (JSPUtil.getParameter(request, prefix	+ "r5", length));
			String[] a5 = (JSPUtil.getParameter(request, prefix	+ "a5", length));
			String[] d1 = (JSPUtil.getParameter(request, prefix	+ "d1", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] balTp = (JSPUtil.getParameter(request, prefix	+ "bal_tp", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchApprovalVO();
				if (t2[i] != null)
					model.setT2(t2[i]);
				if (dw[i] != null)
					model.setDw(dw[i]);
				if (p4[i] != null)
					model.setP4(p4[i]);
				if (dx[i] != null)
					model.setDx(dx[i]);
				if (p2[i] != null)
					model.setP2(p2[i]);
				if (d9[i] != null)
					model.setD9(d9[i]);
				if (d8[i] != null)
					model.setD8(d8[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (periodStdt[i] != null)
					model.setPeriodStdt(periodStdt[i]);
				if (d7[i] != null)
					model.setD7(d7[i]);
				if (newVanTpCd[i] != null)
					model.setNewVanTpCd(newVanTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tysz[i] != null)
					model.setTysz(tysz[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (d3[i] != null)
					model.setD3(d3[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (a2[i] != null)
					model.setA2(a2[i]);
				if (a4[i] != null)
					model.setA4(a4[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (f2[i] != null)
					model.setF2(f2[i]);
				if (f5[i] != null)
					model.setF5(f5[i]);
				if (s4[i] != null)
					model.setS4(s4[i]);
				if (f4[i] != null)
					model.setF4(f4[i]);
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (s2[i] != null)
					model.setS2(s2[i]);
				if (o2[i] != null)
					model.setO2(o2[i]);
				if (q2[i] != null)
					model.setQ2(q2[i]);
				if (o4[i] != null)
					model.setO4(o4[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (q4[i] != null)
					model.setQ4(q4[i]);
				if (pkupDueDt[i] != null)
					model.setPkupDueDt(pkupDueDt[i]);
				if (qtyTotal[i] != null)
					model.setQtyTotal(qtyTotal[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (authNo[i] != null)
					model.setAuthNo(authNo[i]);
				if (t4[i] != null)
					model.setT4(t4[i]);
				if (r7[i] != null)
					model.setR7(r7[i]);
				if (divsion[i] != null)
					model.setDivsion(divsion[i]);
				if (r2[i] != null)
					model.setR2(r2[i]);
				if (r4[i] != null)
					model.setR4(r4[i]);
				if (periodEddt[i] != null)
					model.setPeriodEddt(periodEddt[i]);
				if (r5[i] != null)
					model.setR5(r5[i]);
				if (a5[i] != null)
					model.setA5(a5[i]);
				if (d1[i] != null)
					model.setD1(d1[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (balTp[i] != null)
					model.setBalTp(balTp[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchApprovalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchApprovalVO[]
	 */
	public SearchApprovalVO[] getSearchApprovalVOs(){
		SearchApprovalVO[] vos = (SearchApprovalVO[])models.toArray(new SearchApprovalVO[models.size()]);
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
		this.t2 = this.t2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dw = this.dw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p4 = this.p4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dx = this.dx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p2 = this.p2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d9 = this.d9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d8 = this.d8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodStdt = this.periodStdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 = this.d7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVanTpCd = this.newVanTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tysz = this.tysz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d3 = this.d3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2 = this.a2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4 = this.a4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2 = this.f2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5 = this.f5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4 = this.s4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4 = this.f4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2 = this.s2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2 = this.o2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.q2 = this.q2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4 = this.o4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.q4 = this.q4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupDueDt = this.pkupDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyTotal = this.qtyTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authNo = this.authNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t4 = this.t4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r7 = this.r7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divsion = this.divsion .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2 = this.r2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r4 = this.r4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodEddt = this.periodEddt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 = this.r5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a5 = this.a5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d1 = this.d1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balTp = this.balTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
