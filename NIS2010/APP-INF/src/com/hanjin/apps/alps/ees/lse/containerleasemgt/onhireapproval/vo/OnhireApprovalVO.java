/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OnhireApprovalVO.java
 *@FileTitle : OnhireApprovalVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.23
 *@LastModifier : 진준성
 *@LastVersion : 1.0
 * 2009.09.23 진준성 
 * 1.0 Creation
 * ================================
 * 2010.12.01 남궁진호 [CHM-201007443-01] REF_NO 항목 추가
 * 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
 * 2013.08.13 채창호 [CHM-201325598]Split 02-EQR T/F 관련 LEGACY 연계 방안 및 일정
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

public class OnhireApprovalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<OnhireApprovalVO> models = new ArrayList<OnhireApprovalVO>();

	
	/* Column Info */
	private String s4Old = null;
	/* Column Info */
	private String d3Lon = null;
	/* Column Info */
	private String d2New = null;
	/* Column Info */
	private String a5New = null;
	/* Column Info */
	private String a5Lon = null;
	/* Column Info */
	private String a5Old = null;
	/* Column Info */
	private String d4Lon = null;
	/* Column Info */
	private String s2Lon = null;
	/* Column Info */
	private String o2Old = null;
	/* Column Info */
	private String a2New = null;
	/* Column Info */
	private String f4Lon = null;
	/* Column Info */
	private String p4New = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tysz = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String s4Lon = null;
	/* Column Info */
	private String divTotalNew = null;
	/* Column Info */
	private String d7Lon = null;
	/* Column Info */
	private String d4Old = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String d5Lon = null;
	/* Column Info */
	private String r5New = null;
	/* Column Info */
	private String dpp = null;
	/* Column Info */
	private String lessor = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String q2New = null;
	/* Column Info */
	private String t2Old = null;
	/* Column Info */
	private String p2Old = null;
	/* Column Info */
	private String o4New = null;
	/* Column Info */
	private String t4Lon = null;
	/* Column Info */
	private String minOnhDys = null;
	/* Column Info */
	private String pUpCharge = null;
	/* Column Info */
	private String o4Old = null;
	/* Column Info */
	private String q4Lon = null;
	/* Column Info */
	private String o2Lon = null;
	/* Column Info */
	private String a4Lon = null;
	/* Column Info */
	private String a2Old = null;
	/* Column Info */
	private String mftYr = null;
	/* Column Info */
	private String r4Lon = null;
	/* Column Info */
	private String s2New = null;
	/* Column Info */
	private String mYear = null;
	/* Column Info */
	private String r2Old = null;
	/* Column Info */
	private String p4Old = null;
	/* Column Info */
	private String f4New = null;
	/* Column Info */
	private String q4Old = null;
	/* Column Info */
	private String d7New = null;
	/* Column Info */
	private String f5Lon = null;
	/* Column Info */
	private String r2Lon = null;
	/* Column Info */
	private String s4New = null;
	/* Column Info */
	private String r7New = null;
	/* Column Info */
	private String divTotalOld = null;
	/* Column Info */
	private String leaseTerm = null;
	/* Column Info */
	private String p2Lon = null;
	/* Column Info */
	private String t4New = null;
	/* Column Info */
	private String dxLon = null;
	/* Column Info */
	private String r4New = null;
	/* Column Info */
	private String d9Old = null;
	/* Column Info */
	private String r4Old = null;
	/* Column Info */
	private String r2New = null;
	/* Column Info */
	private String dwOld = null;
	/* Column Info */
	private String freeDay = null;
	/* Column Info */
	private String q4New = null;
	/* Column Info */
	private String a4New = null;
	/* Column Info */
	private String freeDys = null;
	/* Column Info */
	private String f2New = null;
	/* Column Info */
	private String pkupChgAmt = null;
	/* Column Info */
	private String p4Lon = null;
	/* Column Info */
	private String dppFreeDay = null;
	/* Column Info */
	private String f5New = null;
	/* Column Info */
	private String f4Old = null;
	/* Column Info */
	private String d8New = null;
	/* Column Info */
	private String q2Lon = null;
	/* Column Info */
	private String cntrOnhAuthNo = null;
	/* Column Info */
	private String s2Old = null;
	/* Column Info */
	private String t2Lon = null;
	/* Column Info */
	private String d7Old = null;
	/* Column Info */
	private String lstm = null;
	/* Column Info */
	private String d2Lon = null;
	/* Column Info */
	private String r5Lon = null;
	/* Column Info */
	private String dwLon = null;
	/* Column Info */
	private String p2New = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String aproRmk = null;
	/* Column Info */
	private String r7Old = null;
	/* Column Info */
	private String f2Lon = null;
	/* Column Info */
	private String d3Old = null;
	/* Column Info */
	private String a2Lon = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String t4Old = null;
	/* Column Info */
	private String dwNew = null;
	/* Column Info */
	private String dxNew = null;
	/* Column Info */
	private String d9Lon = null;
	/* Column Info */
	private String n1stChgAmt = null;
	/* Column Info */
	private String pUpCredit = null;
	/* Column Info */
	private String r7Lon = null;
	/* Column Info */
	private String f2Old = null;
	/* Column Info */
	private String o4Lon = null;
	/* Column Info */
	private String minOnhDays = null;
	/* Column Info */
	private String sPkupDueDt = null;
	/* Column Info */
	private String pkupChgCrAmt = null;
	/* Column Info */
	private String d9New = null;
	/* Column Info */
	private String dxOld = null;
	/* Column Info */
	private String a4Old = null;
	/* Column Info */
	private String d5New = null;
	/* Column Info */
	private String f5Old = null;
	/* Column Info */
	private String d2Old = null;
	/* Column Info */
	private String tpszCd = null;
	/* Column Info */
	private String d3New = null;
	/* Column Info */
	private String d4New = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String q2Old = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String d8Old = null;
	/* Column Info */
	private String o2New = null;
	/* Column Info */
	private String d8Lon = null;
	/* Column Info */
	private String pkupDueDt = null;
	/* Column Info */
	private String sAproRmk = null;
	/* Column Info */
	private String t2New = null;
	/* Column Info */
	private String divTotal = null;
	/* Column Info */
	private String r5Old = null;
	/* Column Info */
	private String cntrTpszCd2 = null;
	/* Column Info */
	private String cntrTpszCd1 = null;
	/* Column Info */
	private String d5Old = null;
	/* Column Info */
	private String arrOld = null;
	/* Column Info */
	private String arrNew = null;
	/* Column Info */
	private String arrLon = null;
	/* RowSet Info */
	private DBRowSet dbRowset = null;
	/* RowSet Info */
	private String  reqNo = null;
	/* RowSet Info */
	private String  totalList = null;
	/* RowSet Info */
	private String  onhOrdYr = null;
	/* RowSet Info */
	private String  d1New = null;
	/* RowSet Info */
	private String  d1Lon = null;
	/* RowSet Info */
	private String  d1Old = null;
	/* RowSet Info */
	private String  eccCd = null;
	/* RowSet Info */
	private String  lccCd = null;
	/* RowSet Info */
	private String  locCod = null;

	/**
	 * rowset을 담기위한 변수
	 */
	public DBRowSet getDbRowset() {
		return dbRowset;
	}

	public void setDbRowset(DBRowSet dbRowset) {
		this.dbRowset = dbRowset;
	}

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public OnhireApprovalVO() {
	}

	public OnhireApprovalVO(String ibflag, String pagerows, String locCd,
			String divTotalNew, String cntrTpszCd, String dpp, String lessor,
			String agmtNo, String refNo, String minOnhDys, String pUpCharge,
			String mftYr, String mYear, String divTotalOld, String leaseTerm,
			String freeDay, String freeDys, String pkupChgAmt,
			String dppFreeDay, String cntrOnhAuthNo, String lstm,
			String lstmCd, String aproRmk, String agmtSeq, String n1stChgAmt,
			String pUpCredit, String sPkupDueDt, String minOnhDays,
			String pkupChgCrAmt, String tpszCd, String agmtCtyCd,
			String pkupDueDt, String sAproRmk, String divTotal,
			String cntrTpszCd2, String cntrTpszCd1, String q4Old, String q4New,
			String q4Lon, String q2Old, String q2New, String q2Lon,
			String d2Old, String d2New, String d2Lon, String o2Old,
			String o2New, String o2Lon, String s2Old, String s2New,
			String s2Lon, String r2Old, String r2New, String r2Lon,
			String a2Old, String a2New, String a2Lon, String t2Old,
			String t2New, String t2Lon, String f2Old, String f2New,
			String f2Lon, String p2Old, String p2New, String p2Lon,
			String d5Old, String d5New, String d5Lon, String d4Old,
			String d4New, String d4Lon, String o4Old, String o4New,
			String o4Lon, String s4Old, String s4New, String s4Lon,
			String a4Old, String a4New, String a4Lon, String f5Old,
			String f5New, String f5Lon, String t4Old, String t4New,
			String t4Lon, String f4Old, String f4New, String f4Lon,
			String r5Old, String r5New, String r5Lon, String p4Old,
			String p4New, String p4Lon, String r4Old, String r4New,
			String r4Lon, String d7Old, String d7New, String d7Lon,
			String r7Old, String r7New, String r7Lon, String d9Old,
			String d9New, String d9Lon, String d8Old, String d8New,
			String d8Lon, String dxOld, String dxNew, String dxLon,
			String dwOld, String dwNew, String dwLon, String d3Old,
			String d3New, String d3Lon, String tysz, String arrOld,
			String a5New, String a5Lon, String a5Old,
			String arrNew, String arrLon ,String reqNo ,String totalList ,String  onhOrdYr
			,String  d1New ,String  d1Lon ,String  d1Old, String eccCd, String lccCd, String locCod) {
		this.s4Old = s4Old;
		this.d3Lon = d3Lon;
		this.d2New = d2New;
		this.a5New = a5New;
		this.a5Lon = a5Lon;
		this.a5Old = a5Old;
		this.d4Lon = d4Lon;
		this.s2Lon = s2Lon;
		this.o2Old = o2Old;
		this.a2New = a2New;
		this.f4Lon = f4Lon;
		this.p4New = p4New;
		this.pagerows = pagerows;
		this.tysz = tysz;
		this.locCd = locCd;
		this.s4Lon = s4Lon;
		this.divTotalNew = divTotalNew;
		this.d7Lon = d7Lon;
		this.d4Old = d4Old;
		this.cntrTpszCd = cntrTpszCd;
		this.d5Lon = d5Lon;
		this.r5New = r5New;
		this.dpp = dpp;
		this.lessor = lessor;
		this.agmtNo = agmtNo;
		this.refNo = refNo;
		this.q2New = q2New;
		this.t2Old = t2Old;
		this.p2Old = p2Old;
		this.o4New = o4New;
		this.t4Lon = t4Lon;
		this.minOnhDys = minOnhDys;
		this.pUpCharge = pUpCharge;
		this.o4Old = o4Old;
		this.q4Lon = q4Lon;
		this.o2Lon = o2Lon;
		this.a4Lon = a4Lon;
		this.a2Old = a2Old;
		this.mftYr = mftYr;
		this.r4Lon = r4Lon;
		this.s2New = s2New;
		this.mYear = mYear;
		this.r2Old = r2Old;
		this.p4Old = p4Old;
		this.f4New = f4New;
		this.q4Old = q4Old;
		this.d7New = d7New;
		this.f5Lon = f5Lon;
		this.r2Lon = r2Lon;
		this.s4New = s4New;
		this.r7New = r7New;
		this.divTotalOld = divTotalOld;
		this.leaseTerm = leaseTerm;
		this.p2Lon = p2Lon;
		this.t4New = t4New;
		this.dxLon = dxLon;
		this.r4New = r4New;
		this.d9Old = d9Old;
		this.r4Old = r4Old;
		this.r2New = r2New;
		this.dwOld = dwOld;
		this.freeDay = freeDay;
		this.q4New = q4New;
		this.a4New = a4New;
		this.freeDys = freeDys;
		this.f2New = f2New;
		this.pkupChgAmt = pkupChgAmt;
		this.p4Lon = p4Lon;
		this.dppFreeDay = dppFreeDay;
		this.f5New = f5New;
		this.f4Old = f4Old;
		this.d8New = d8New;
		this.q2Lon = q2Lon;
		this.cntrOnhAuthNo = cntrOnhAuthNo;
		this.s2Old = s2Old;
		this.t2Lon = t2Lon;
		this.d7Old = d7Old;
		this.lstm = lstm;
		this.d2Lon = d2Lon;
		this.r5Lon = r5Lon;
		this.dwLon = dwLon;
		this.p2New = p2New;
		this.lstmCd = lstmCd;
		this.aproRmk = aproRmk;
		this.r7Old = r7Old;
		this.f2Lon = f2Lon;
		this.d3Old = d3Old;
		this.a2Lon = a2Lon;
		this.agmtSeq = agmtSeq;
		this.t4Old = t4Old;
		this.dwNew = dwNew;
		this.dxNew = dxNew;
		this.d9Lon = d9Lon;
		this.n1stChgAmt = n1stChgAmt;
		this.pUpCredit = pUpCredit;
		this.r7Lon = r7Lon;
		this.f2Old = f2Old;
		this.o4Lon = o4Lon;
		this.minOnhDays = minOnhDays;
		this.sPkupDueDt = sPkupDueDt;
		this.pkupChgCrAmt = pkupChgCrAmt;
		this.d9New = d9New;
		this.dxOld = dxOld;
		this.a4Old = a4Old;
		this.d5New = d5New;
		this.f5Old = f5Old;
		this.d2Old = d2Old;
		this.tpszCd = tpszCd;
		this.d3New = d3New;
		this.d4New = d4New;
		this.ibflag = ibflag;
		this.q2Old = q2Old;
		this.agmtCtyCd = agmtCtyCd;
		this.d8Old = d8Old;
		this.o2New = o2New;
		this.d8Lon = d8Lon;
		this.pkupDueDt = pkupDueDt;
		this.sAproRmk = sAproRmk;
		this.t2New = t2New;
		this.divTotal = divTotal;
		this.r5Old = r5Old;
		this.cntrTpszCd2 = cntrTpszCd2;
		this.cntrTpszCd1 = cntrTpszCd1;
		this.d5Old = d5Old;
		this.arrOld = arrOld;
		this.arrNew = arrNew;
		this.arrLon = arrLon;
		this.reqNo  = reqNo;
		this.totalList = totalList;
		this.onhOrdYr = onhOrdYr;
		this.d1New = d1New;
		this.d1Lon = d1Lon;
		this.d1Old = d1Old;
		this.eccCd = eccCd;
		this.lccCd = lccCd;
		this.locCod = locCod;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("s4_old", getS4Old());
		this.hashColumns.put("d3_lon", getD3Lon());
		this.hashColumns.put("d2_new", getD2New());
		this.hashColumns.put("a5_new", getA5New());
		this.hashColumns.put("a5_lon", getA5Lon());
		this.hashColumns.put("a5_old", getA5Old());
		this.hashColumns.put("d4_lon", getD4Lon());
		this.hashColumns.put("s2_lon", getS2Lon());
		this.hashColumns.put("o2_old", getO2Old());
		this.hashColumns.put("a2_new", getA2New());
		this.hashColumns.put("f4_lon", getF4Lon());
		this.hashColumns.put("p4_new", getP4New());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tysz", getTysz());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("s4_lon", getS4Lon());
		this.hashColumns.put("div_total_new", getDivTotalNew());
		this.hashColumns.put("d7_lon", getD7Lon());
		this.hashColumns.put("d4_old", getD4Old());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("d5_lon", getD5Lon());
		this.hashColumns.put("r5_new", getR5New());
		this.hashColumns.put("dpp", getDpp());
		this.hashColumns.put("lessor", getLessor());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("q2_new", getQ2New());
		this.hashColumns.put("t2_old", getT2Old());
		this.hashColumns.put("p2_old", getP2Old());
		this.hashColumns.put("o4_new", getO4New());
		this.hashColumns.put("t4_lon", getT4Lon());
		this.hashColumns.put("min_onh_dys", getMinOnhDys());
		this.hashColumns.put("p_up_charge", getPUpCharge());
		this.hashColumns.put("o4_old", getO4Old());
		this.hashColumns.put("q4_lon", getQ4Lon());
		this.hashColumns.put("o2_lon", getO2Lon());
		this.hashColumns.put("a4_lon", getA4Lon());
		this.hashColumns.put("a2_old", getA2Old());
		this.hashColumns.put("mft_yr", getMftYr());
		this.hashColumns.put("r4_lon", getR4Lon());
		this.hashColumns.put("s2_new", getS2New());
		this.hashColumns.put("m_year", getMYear());
		this.hashColumns.put("r2_old", getR2Old());
		this.hashColumns.put("p4_old", getP4Old());
		this.hashColumns.put("f4_new", getF4New());
		this.hashColumns.put("q4_old", getQ4Old());
		this.hashColumns.put("d7_new", getD7New());
		this.hashColumns.put("f5_lon", getF5Lon());
		this.hashColumns.put("r2_lon", getR2Lon());
		this.hashColumns.put("s4_new", getS4New());
		this.hashColumns.put("r7_new", getR7New());
		this.hashColumns.put("div_total_old", getDivTotalOld());
		this.hashColumns.put("lease_term", getLeaseTerm());
		this.hashColumns.put("p2_lon", getP2Lon());
		this.hashColumns.put("t4_new", getT4New());
		this.hashColumns.put("dx_lon", getDxLon());
		this.hashColumns.put("r4_new", getR4New());
		this.hashColumns.put("d9_old", getD9Old());
		this.hashColumns.put("r4_old", getR4Old());
		this.hashColumns.put("r2_new", getR2New());
		this.hashColumns.put("dw_old", getDwOld());
		this.hashColumns.put("free_day", getFreeDay());
		this.hashColumns.put("q4_new", getQ4New());
		this.hashColumns.put("a4_new", getA4New());
		this.hashColumns.put("free_dys", getFreeDys());
		this.hashColumns.put("f2_new", getF2New());
		this.hashColumns.put("pkup_chg_amt", getPkupChgAmt());
		this.hashColumns.put("p4_lon", getP4Lon());
		this.hashColumns.put("dpp_free_day", getDppFreeDay());
		this.hashColumns.put("f5_new", getF5New());
		this.hashColumns.put("f4_old", getF4Old());
		this.hashColumns.put("d8_new", getD8New());
		this.hashColumns.put("q2_lon", getQ2Lon());
		this.hashColumns.put("cntr_onh_auth_no", getCntrOnhAuthNo());
		this.hashColumns.put("s2_old", getS2Old());
		this.hashColumns.put("t2_lon", getT2Lon());
		this.hashColumns.put("d7_old", getD7Old());
		this.hashColumns.put("lstm", getLstm());
		this.hashColumns.put("d2_lon", getD2Lon());
		this.hashColumns.put("r5_lon", getR5Lon());
		this.hashColumns.put("dw_lon", getDwLon());
		this.hashColumns.put("p2_new", getP2New());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("apro_rmk", getAproRmk());
		this.hashColumns.put("r7_old", getR7Old());
		this.hashColumns.put("f2_lon", getF2Lon());
		this.hashColumns.put("d3_old", getD3Old());
		this.hashColumns.put("a2_lon", getA2Lon());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("t4_old", getT4Old());
		this.hashColumns.put("dw_new", getDwNew());
		this.hashColumns.put("dx_new", getDxNew());
		this.hashColumns.put("d9_lon", getD9Lon());
		this.hashColumns.put("n1st_chg_amt", getN1stChgAmt());
		this.hashColumns.put("p_up_credit", getPUpCredit());
		this.hashColumns.put("r7_lon", getR7Lon());
		this.hashColumns.put("f2_old", getF2Old());
		this.hashColumns.put("o4_lon", getO4Lon());
		this.hashColumns.put("min_onh_days", getMinOnhDays());
		this.hashColumns.put("s_pkup_due_dt", getSPkupDueDt());
		this.hashColumns.put("pkup_chg_cr_amt", getPkupChgCrAmt());
		this.hashColumns.put("d9_new", getD9New());
		this.hashColumns.put("dx_old", getDxOld());
		this.hashColumns.put("a4_old", getA4Old());
		this.hashColumns.put("d5_new", getD5New());
		this.hashColumns.put("f5_old", getF5Old());
		this.hashColumns.put("d2_old", getD2Old());
		this.hashColumns.put("tpsz_cd", getTpszCd());
		this.hashColumns.put("d3_new", getD3New());
		this.hashColumns.put("d4_new", getD4New());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("q2_old", getQ2Old());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("d8_old", getD8Old());
		this.hashColumns.put("o2_new", getO2New());
		this.hashColumns.put("d8_lon", getD8Lon());
		this.hashColumns.put("pkup_due_dt", getPkupDueDt());
		this.hashColumns.put("s_apro_rmk", getSAproRmk());
		this.hashColumns.put("t2_new", getT2New());
		this.hashColumns.put("div_total", getDivTotal());
		this.hashColumns.put("r5_old", getR5Old());
		this.hashColumns.put("cntr_tpsz_cd2", getCntrTpszCd2());
		this.hashColumns.put("cntr_tpsz_cd1", getCntrTpszCd1());
		this.hashColumns.put("d5_old", getD5Old());
		this.hashColumns.put("arr_old", getArrOld());
		this.hashColumns.put("arr_new", getArrNew());
		this.hashColumns.put("arr_lon", getArrLon());
		this.hashColumns.put("reqno", getReqNo());
		this.hashColumns.put("totallist", getTotalList());
		this.hashColumns.put("onh_ord_yr", getOnhOrdYr());
		this.hashColumns.put("d1_new", getD1New());
		this.hashColumns.put("d1_lon", getD1Lon());
		this.hashColumns.put("d1_old", getD1Old());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("loc_cod", getLocCod());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("s4_old", "s4Old");
		this.hashFields.put("d3_lon", "d3Lon");
		this.hashFields.put("d2_new", "d2New");
		this.hashFields.put("a5_new", "a5New");
		this.hashFields.put("a5_lon", "a5Lon");
		this.hashFields.put("a5_old", "a5Old");
		this.hashFields.put("d4_lon", "d4Lon");
		this.hashFields.put("s2_lon", "s2Lon");
		this.hashFields.put("o2_old", "o2Old");
		this.hashFields.put("a2_new", "a2New");
		this.hashFields.put("f4_lon", "f4Lon");
		this.hashFields.put("p4_new", "p4New");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tysz", "tysz");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("s4_lon", "s4Lon");
		this.hashFields.put("div_total_new", "divTotalNew");
		this.hashFields.put("d7_lon", "d7Lon");
		this.hashFields.put("d4_old", "d4Old");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("d5_lon", "d5Lon");
		this.hashFields.put("r5_new", "r5New");
		this.hashFields.put("dpp", "dpp");
		this.hashFields.put("lessor", "lessor");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("q2_new", "q2New");
		this.hashFields.put("t2_old", "t2Old");
		this.hashFields.put("p2_old", "p2Old");
		this.hashFields.put("o4_new", "o4New");
		this.hashFields.put("t4_lon", "t4Lon");
		this.hashFields.put("min_onh_dys", "minOnhDys");
		this.hashFields.put("p_up_charge", "pUpCharge");
		this.hashFields.put("o4_old", "o4Old");
		this.hashFields.put("q4_lon", "q4Lon");
		this.hashFields.put("o2_lon", "o2Lon");
		this.hashFields.put("a4_lon", "a4Lon");
		this.hashFields.put("a2_old", "a2Old");
		this.hashFields.put("mft_yr", "mftYr");
		this.hashFields.put("r4_lon", "r4Lon");
		this.hashFields.put("s2_new", "s2New");
		this.hashFields.put("m_year", "mYear");
		this.hashFields.put("r2_old", "r2Old");
		this.hashFields.put("p4_old", "p4Old");
		this.hashFields.put("f4_new", "f4New");
		this.hashFields.put("q4_old", "q4Old");
		this.hashFields.put("d7_new", "d7New");
		this.hashFields.put("f5_lon", "f5Lon");
		this.hashFields.put("r2_lon", "r2Lon");
		this.hashFields.put("s4_new", "s4New");
		this.hashFields.put("r7_new", "r7New");
		this.hashFields.put("div_total_old", "divTotalOld");
		this.hashFields.put("lease_term", "leaseTerm");
		this.hashFields.put("p2_lon", "p2Lon");
		this.hashFields.put("t4_new", "t4New");
		this.hashFields.put("dx_lon", "dxLon");
		this.hashFields.put("r4_new", "r4New");
		this.hashFields.put("d9_old", "d9Old");
		this.hashFields.put("r4_old", "r4Old");
		this.hashFields.put("r2_new", "r2New");
		this.hashFields.put("dw_old", "dwOld");
		this.hashFields.put("free_day", "freeDay");
		this.hashFields.put("q4_new", "q4New");
		this.hashFields.put("a4_new", "a4New");
		this.hashFields.put("free_dys", "freeDys");
		this.hashFields.put("f2_new", "f2New");
		this.hashFields.put("pkup_chg_amt", "pkupChgAmt");
		this.hashFields.put("p4_lon", "p4Lon");
		this.hashFields.put("dpp_free_day", "dppFreeDay");
		this.hashFields.put("f5_new", "f5New");
		this.hashFields.put("f4_old", "f4Old");
		this.hashFields.put("d8_new", "d8New");
		this.hashFields.put("q2_lon", "q2Lon");
		this.hashFields.put("cntr_onh_auth_no", "cntrOnhAuthNo");
		this.hashFields.put("s2_old", "s2Old");
		this.hashFields.put("t2_lon", "t2Lon");
		this.hashFields.put("d7_old", "d7Old");
		this.hashFields.put("lstm", "lstm");
		this.hashFields.put("d2_lon", "d2Lon");
		this.hashFields.put("r5_lon", "r5Lon");
		this.hashFields.put("dw_lon", "dwLon");
		this.hashFields.put("p2_new", "p2New");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("apro_rmk", "aproRmk");
		this.hashFields.put("r7_old", "r7Old");
		this.hashFields.put("f2_lon", "f2Lon");
		this.hashFields.put("d3_old", "d3Old");
		this.hashFields.put("a2_lon", "a2Lon");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("t4_old", "t4Old");
		this.hashFields.put("dw_new", "dwNew");
		this.hashFields.put("dx_new", "dxNew");
		this.hashFields.put("d9_lon", "d9Lon");
		this.hashFields.put("n1st_chg_amt", "n1stChgAmt");
		this.hashFields.put("p_up_credit", "pUpCredit");
		this.hashFields.put("r7_lon", "r7Lon");
		this.hashFields.put("f2_old", "f2Old");
		this.hashFields.put("o4_lon", "o4Lon");
		this.hashFields.put("min_onh_days", "minOnhDays");
		this.hashFields.put("s_pkup_due_dt", "sPkupDueDt");
		this.hashFields.put("pkup_chg_cr_amt", "pkupChgCrAmt");
		this.hashFields.put("d9_new", "d9New");
		this.hashFields.put("dx_old", "dxOld");
		this.hashFields.put("a4_old", "a4Old");
		this.hashFields.put("d5_new", "d5New");
		this.hashFields.put("f5_old", "f5Old");
		this.hashFields.put("d2_old", "d2Old");
		this.hashFields.put("tpsz_cd", "tpszCd");
		this.hashFields.put("d3_new", "d3New");
		this.hashFields.put("d4_new", "d4New");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("q2_old", "q2Old");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("d8_old", "d8Old");
		this.hashFields.put("o2_new", "o2New");
		this.hashFields.put("d8_lon", "d8Lon");
		this.hashFields.put("pkup_due_dt", "pkupDueDt");
		this.hashFields.put("s_apro_rmk", "sAproRmk");
		this.hashFields.put("t2_new", "t2New");
		this.hashFields.put("div_total", "divTotal");
		this.hashFields.put("r5_old", "r5Old");
		this.hashFields.put("cntr_tpsz_cd2", "cntrTpszCd2");
		this.hashFields.put("cntr_tpsz_cd1", "cntrTpszCd1");
		this.hashFields.put("d5_old", "d5Old");
		this.hashFields.put("arr_old", "arrOld");
		this.hashFields.put("arr_new", "arrNew");
		this.hashFields.put("arr_lon", "arrLon");
		this.hashFields.put("reqno", "reqNo");
		this.hashFields.put("totallist", "totalList");
		this.hashFields.put("onh_ord_yr", "onhOrdYr");
		this.hashFields.put("d1_new", "d1New");
		this.hashFields.put("d1_lon", "d1Lon");
		this.hashFields.put("d1_old", "d1Old");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("loc_cod", "locCod");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return s4Old
	 */
	public String getS4Old() {
		return this.s4Old;
	}

	/**
	 * Column Info
	 * 
	 * @return d3Lon
	 */
	public String getD3Lon() {
		return this.d3Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return d2New
	 */
	public String getD2New() {
		return this.d2New;
	}
	
	/**
	 * Column Info
	 * 
	 * @return a5New
	 */
	public String getA5New() {
		return this.a5New;
	}
	
	/**
	 * Column Info
	 * 
	 * @return a5Lon
	 */
	public String getA5Lon() {
		return this.a5Lon;
	}
	
	/**
	 * Column Info
	 * 
	 * @return a5Old
	 */
	public String getA5Old() {
		return this.a5Old;
	}	

	/**
	 * Column Info
	 * 
	 * @return d4Lon
	 */
	public String getD4Lon() {
		return this.d4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return s2Lon
	 */
	public String getS2Lon() {
		return this.s2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return o2Old
	 */
	public String getO2Old() {
		return this.o2Old;
	}

	/**
	 * Column Info
	 * 
	 * @return a2New
	 */
	public String getA2New() {
		return this.a2New;
	}

	/**
	 * Column Info
	 * 
	 * @return f4Lon
	 */
	public String getF4Lon() {
		return this.f4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return p4New
	 */
	public String getP4New() {
		return this.p4New;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return tysz
	 */
	public String getTysz() {
		return this.tysz;
	}

	/**
	 * Column Info
	 * 
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}

	/**
	 * Column Info
	 * 
	 * @return s4Lon
	 */
	public String getS4Lon() {
		return this.s4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return divTotalNew
	 */
	public String getDivTotalNew() {
		return this.divTotalNew;
	}

	/**
	 * Column Info
	 * 
	 * @return d7Lon
	 */
	public String getD7Lon() {
		return this.d7Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return d4Old
	 */
	public String getD4Old() {
		return this.d4Old;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	/**
	 * Column Info
	 * 
	 * @return d5Lon
	 */
	public String getD5Lon() {
		return this.d5Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return r5New
	 */
	public String getR5New() {
		return this.r5New;
	}

	/**
	 * Column Info
	 * 
	 * @return dpp
	 */
	public String getDpp() {
		return this.dpp;
	}

	/**
	 * Column Info
	 * 
	 * @return lessor
	 */
	public String getLessor() {
		return this.lessor;
	}

	/**
	 * Column Info
	 * 
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}

	/**
	 * Column Info
	 * 
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}

	/**
	 * Column Info
	 * 
	 * @return q2New
	 */
	public String getQ2New() {
		return this.q2New;
	}

	/**
	 * Column Info
	 * 
	 * @return t2Old
	 */
	public String getT2Old() {
		return this.t2Old;
	}

	/**
	 * Column Info
	 * 
	 * @return p2Old
	 */
	public String getP2Old() {
		return this.p2Old;
	}

	/**
	 * Column Info
	 * 
	 * @return o4New
	 */
	public String getO4New() {
		return this.o4New;
	}

	/**
	 * Column Info
	 * 
	 * @return t4Lon
	 */
	public String getT4Lon() {
		return this.t4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return minOnhDys
	 */
	public String getMinOnhDys() {
		return this.minOnhDys;
	}

	/**
	 * Column Info
	 * 
	 * @return pUpCharge
	 */
	public String getPUpCharge() {
		return this.pUpCharge;
	}

	/**
	 * Column Info
	 * 
	 * @return o4Old
	 */
	public String getO4Old() {
		return this.o4Old;
	}

	/**
	 * Column Info
	 * 
	 * @return q4Lon
	 */
	public String getQ4Lon() {
		return this.q4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return o2Lon
	 */
	public String getO2Lon() {
		return this.o2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return a4Lon
	 */
	public String getA4Lon() {
		return this.a4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return a2Old
	 */
	public String getA2Old() {
		return this.a2Old;
	}

	/**
	 * Column Info
	 * 
	 * @return mftYr
	 */
	public String getMftYr() {
		return this.mftYr;
	}

	/**
	 * Column Info
	 * 
	 * @return r4Lon
	 */
	public String getR4Lon() {
		return this.r4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return s2New
	 */
	public String getS2New() {
		return this.s2New;
	}

	/**
	 * Column Info
	 * 
	 * @return mYear
	 */
	public String getMYear() {
		return this.mYear;
	}

	/**
	 * Column Info
	 * 
	 * @return r2Old
	 */
	public String getR2Old() {
		return this.r2Old;
	}

	/**
	 * Column Info
	 * 
	 * @return p4Old
	 */
	public String getP4Old() {
		return this.p4Old;
	}

	/**
	 * Column Info
	 * 
	 * @return f4New
	 */
	public String getF4New() {
		return this.f4New;
	}

	/**
	 * Column Info
	 * 
	 * @return q4Old
	 */
	public String getQ4Old() {
		return this.q4Old;
	}

	/**
	 * Column Info
	 * 
	 * @return d7New
	 */
	public String getD7New() {
		return this.d7New;
	}

	/**
	 * Column Info
	 * 
	 * @return f5Lon
	 */
	public String getF5Lon() {
		return this.f5Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return r2Lon
	 */
	public String getR2Lon() {
		return this.r2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return s4New
	 */
	public String getS4New() {
		return this.s4New;
	}

	/**
	 * Column Info
	 * 
	 * @return r7New
	 */
	public String getR7New() {
		return this.r7New;
	}

	/**
	 * Column Info
	 * 
	 * @return divTotalOld
	 */
	public String getDivTotalOld() {
		return this.divTotalOld;
	}

	/**
	 * Column Info
	 * 
	 * @return leaseTerm
	 */
	public String getLeaseTerm() {
		return this.leaseTerm;
	}

	/**
	 * Column Info
	 * 
	 * @return p2Lon
	 */
	public String getP2Lon() {
		return this.p2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return t4New
	 */
	public String getT4New() {
		return this.t4New;
	}

	/**
	 * Column Info
	 * 
	 * @return dxLon
	 */
	public String getDxLon() {
		return this.dxLon;
	}

	/**
	 * Column Info
	 * 
	 * @return r4New
	 */
	public String getR4New() {
		return this.r4New;
	}

	/**
	 * Column Info
	 * 
	 * @return d9Old
	 */
	public String getD9Old() {
		return this.d9Old;
	}

	/**
	 * Column Info
	 * 
	 * @return r4Old
	 */
	public String getR4Old() {
		return this.r4Old;
	}

	/**
	 * Column Info
	 * 
	 * @return r2New
	 */
	public String getR2New() {
		return this.r2New;
	}

	/**
	 * Column Info
	 * 
	 * @return dwOld
	 */
	public String getDwOld() {
		return this.dwOld;
	}

	/**
	 * Column Info
	 * 
	 * @return freeDay
	 */
	public String getFreeDay() {
		return this.freeDay;
	}

	/**
	 * Column Info
	 * 
	 * @return q4New
	 */
	public String getQ4New() {
		return this.q4New;
	}

	/**
	 * Column Info
	 * 
	 * @return a4New
	 */
	public String getA4New() {
		return this.a4New;
	}

	/**
	 * Column Info
	 * 
	 * @return freeDys
	 */
	public String getFreeDys() {
		return this.freeDys;
	}

	/**
	 * Column Info
	 * 
	 * @return f2New
	 */
	public String getF2New() {
		return this.f2New;
	}

	/**
	 * Column Info
	 * 
	 * @return pkupChgAmt
	 */
	public String getPkupChgAmt() {
		return this.pkupChgAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return p4Lon
	 */
	public String getP4Lon() {
		return this.p4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return dppFreeDay
	 */
	public String getDppFreeDay() {
		return this.dppFreeDay;
	}

	/**
	 * Column Info
	 * 
	 * @return f5New
	 */
	public String getF5New() {
		return this.f5New;
	}

	/**
	 * Column Info
	 * 
	 * @return f4Old
	 */
	public String getF4Old() {
		return this.f4Old;
	}

	/**
	 * Column Info
	 * 
	 * @return d8New
	 */
	public String getD8New() {
		return this.d8New;
	}

	/**
	 * Column Info
	 * 
	 * @return q2Lon
	 */
	public String getQ2Lon() {
		return this.q2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrOnhAuthNo
	 */
	public String getCntrOnhAuthNo() {
		return this.cntrOnhAuthNo;
	}

	/**
	 * Column Info
	 * 
	 * @return s2Old
	 */
	public String getS2Old() {
		return this.s2Old;
	}

	/**
	 * Column Info
	 * 
	 * @return t2Lon
	 */
	public String getT2Lon() {
		return this.t2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return d7Old
	 */
	public String getD7Old() {
		return this.d7Old;
	}

	/**
	 * Column Info
	 * 
	 * @return lstm
	 */
	public String getLstm() {
		return this.lstm;
	}

	/**
	 * Column Info
	 * 
	 * @return d2Lon
	 */
	public String getD2Lon() {
		return this.d2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return r5Lon
	 */
	public String getR5Lon() {
		return this.r5Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return dwLon
	 */
	public String getDwLon() {
		return this.dwLon;
	}

	/**
	 * Column Info
	 * 
	 * @return p2New
	 */
	public String getP2New() {
		return this.p2New;
	}

	/**
	 * Column Info
	 * 
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}

	/**
	 * Column Info
	 * 
	 * @return aproRmk
	 */
	public String getAproRmk() {
		return this.aproRmk;
	}

	/**
	 * Column Info
	 * 
	 * @return r7Old
	 */
	public String getR7Old() {
		return this.r7Old;
	}

	/**
	 * Column Info
	 * 
	 * @return f2Lon
	 */
	public String getF2Lon() {
		return this.f2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return d3Old
	 */
	public String getD3Old() {
		return this.d3Old;
	}

	/**
	 * Column Info
	 * 
	 * @return a2Lon
	 */
	public String getA2Lon() {
		return this.a2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return t4Old
	 */
	public String getT4Old() {
		return this.t4Old;
	}

	/**
	 * Column Info
	 * 
	 * @return dwNew
	 */
	public String getDwNew() {
		return this.dwNew;
	}

	/**
	 * Column Info
	 * 
	 * @return dxNew
	 */
	public String getDxNew() {
		return this.dxNew;
	}

	/**
	 * Column Info
	 * 
	 * @return d9Lon
	 */
	public String getD9Lon() {
		return this.d9Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return n1stChgAmt
	 */
	public String getN1stChgAmt() {
		return this.n1stChgAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return pUpCredit
	 */
	public String getPUpCredit() {
		return this.pUpCredit;
	}

	/**
	 * Column Info
	 * 
	 * @return r7Lon
	 */
	public String getR7Lon() {
		return this.r7Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return f2Old
	 */
	public String getF2Old() {
		return this.f2Old;
	}

	/**
	 * Column Info
	 * 
	 * @return o4Lon
	 */
	public String getO4Lon() {
		return this.o4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return minOnhDays
	 */
	public String getMinOnhDays() {
		return this.minOnhDays;
	}

	/**
	 * Column Info
	 * 
	 * @return sPkupDueDt
	 */
	public String getSPkupDueDt() {
		return this.sPkupDueDt;
	}

	/**
	 * Column Info
	 * 
	 * @return pkupChgCrAmt
	 */
	public String getPkupChgCrAmt() {
		return this.pkupChgCrAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return d9New
	 */
	public String getD9New() {
		return this.d9New;
	}

	/**
	 * Column Info
	 * 
	 * @return dxOld
	 */
	public String getDxOld() {
		return this.dxOld;
	}

	/**
	 * Column Info
	 * 
	 * @return a4Old
	 */
	public String getA4Old() {
		return this.a4Old;
	}

	/**
	 * Column Info
	 * 
	 * @return d5New
	 */
	public String getD5New() {
		return this.d5New;
	}

	/**
	 * Column Info
	 * 
	 * @return f5Old
	 */
	public String getF5Old() {
		return this.f5Old;
	}

	/**
	 * Column Info
	 * 
	 * @return d2Old
	 */
	public String getD2Old() {
		return this.d2Old;
	}

	/**
	 * Column Info
	 * 
	 * @return tpszCd
	 */
	public String getTpszCd() {
		return this.tpszCd;
	}

	/**
	 * Column Info
	 * 
	 * @return d3New
	 */
	public String getD3New() {
		return this.d3New;
	}

	/**
	 * Column Info
	 * 
	 * @return d4New
	 */
	public String getD4New() {
		return this.d4New;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return q2Old
	 */
	public String getQ2Old() {
		return this.q2Old;
	}

	/**
	 * Column Info
	 * 
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}

	/**
	 * Column Info
	 * 
	 * @return d8Old
	 */
	public String getD8Old() {
		return this.d8Old;
	}

	/**
	 * Column Info
	 * 
	 * @return o2New
	 */
	public String getO2New() {
		return this.o2New;
	}

	/**
	 * Column Info
	 * 
	 * @return d8Lon
	 */
	public String getD8Lon() {
		return this.d8Lon;
	}

	/**
	 * Column Info
	 * 
	 * @return pkupDueDt
	 */
	public String getPkupDueDt() {
		return this.pkupDueDt;
	}

	/**
	 * Column Info
	 * 
	 * @return sAproRmk
	 */
	public String getSAproRmk() {
		return this.sAproRmk;
	}

	/**
	 * Column Info
	 * 
	 * @return t2New
	 */
	public String getT2New() {
		return this.t2New;
	}

	/**
	 * Column Info
	 * 
	 * @return divTotal
	 */
	public String getDivTotal() {
		return this.divTotal;
	}

	/**
	 * Column Info
	 * 
	 * @return r5Old
	 */
	public String getR5Old() {
		return this.r5Old;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrTpszCd2
	 */
	public String getCntrTpszCd2() {
		return this.cntrTpszCd2;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrTpszCd1
	 */
	public String getCntrTpszCd1() {
		return this.cntrTpszCd1;
	}

	/**
	 * Column Info
	 * 
	 * @return d5Old
	 */
	public String getD5Old() {
		return this.d5Old;
	}

	/**
	 * Column Info
	 * 
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}

	/**
	 * Column Info
	 * 
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}

	/**
	 * Column Info
	 * 
	 * @return locCod
	 */
	public String getLocCod() {
		return this.locCod;
	}

	/**
	 * Column Info
	 * 
	 * @param s4Old
	 */
	public void setS4Old(String s4Old) {
		this.s4Old = s4Old;
	}

	/**
	 * Column Info
	 * 
	 * @param d3Lon
	 */
	public void setD3Lon(String d3Lon) {
		this.d3Lon = d3Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param a5New
	 */
	public void setA5New(String a5New) {
		this.a5New = a5New;
	}
	
	/**
	 * Column Info
	 * 
	 * @param a5Lon
	 */
	public void setA5Lon(String a5Lon) {
		this.a5Lon = a5Lon;
	}
	
	/**
	 * Column Info
	 * 
	 * @param a5Old
	 */
	public void setA5Old(String a5Old) {
		this.a5Old = a5Old;
	}
	
	/**
	 * Column Info
	 * 
	 * @param d2New
	 */
	public void setD2New(String d2New) {
		this.d2New = d2New;
	}	

	/**
	 * Column Info
	 * 
	 * @param d4Lon
	 */
	public void setD4Lon(String d4Lon) {
		this.d4Lon = d4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param s2Lon
	 */
	public void setS2Lon(String s2Lon) {
		this.s2Lon = s2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param o2Old
	 */
	public void setO2Old(String o2Old) {
		this.o2Old = o2Old;
	}

	/**
	 * Column Info
	 * 
	 * @param a2New
	 */
	public void setA2New(String a2New) {
		this.a2New = a2New;
	}

	/**
	 * Column Info
	 * 
	 * @param f4Lon
	 */
	public void setF4Lon(String f4Lon) {
		this.f4Lon = f4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param p4New
	 */
	public void setP4New(String p4New) {
		this.p4New = p4New;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param tysz
	 */
	public void setTysz(String tysz) {
		this.tysz = tysz;
	}

	/**
	 * Column Info
	 * 
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	/**
	 * Column Info
	 * 
	 * @param s4Lon
	 */
	public void setS4Lon(String s4Lon) {
		this.s4Lon = s4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param divTotalNew
	 */
	public void setDivTotalNew(String divTotalNew) {
		this.divTotalNew = divTotalNew;
	}

	/**
	 * Column Info
	 * 
	 * @param d7Lon
	 */
	public void setD7Lon(String d7Lon) {
		this.d7Lon = d7Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param d4Old
	 */
	public void setD4Old(String d4Old) {
		this.d4Old = d4Old;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * Column Info
	 * 
	 * @param d5Lon
	 */
	public void setD5Lon(String d5Lon) {
		this.d5Lon = d5Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param r5New
	 */
	public void setR5New(String r5New) {
		this.r5New = r5New;
	}

	/**
	 * Column Info
	 * 
	 * @param dpp
	 */
	public void setDpp(String dpp) {
		this.dpp = dpp;
	}

	/**
	 * Column Info
	 * 
	 * @param lessor
	 */
	public void setLessor(String lessor) {
		this.lessor = lessor;
	}

	/**
	 * Column Info
	 * 
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	/**
	 * Column Info
	 * 
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * Column Info
	 * 
	 * @param q2New
	 */
	public void setQ2New(String q2New) {
		this.q2New = q2New;
	}

	/**
	 * Column Info
	 * 
	 * @param t2Old
	 */
	public void setT2Old(String t2Old) {
		this.t2Old = t2Old;
	}

	/**
	 * Column Info
	 * 
	 * @param p2Old
	 */
	public void setP2Old(String p2Old) {
		this.p2Old = p2Old;
	}

	/**
	 * Column Info
	 * 
	 * @param o4New
	 */
	public void setO4New(String o4New) {
		this.o4New = o4New;
	}

	/**
	 * Column Info
	 * 
	 * @param t4Lon
	 */
	public void setT4Lon(String t4Lon) {
		this.t4Lon = t4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param minOnhDys
	 */
	public void setMinOnhDys(String minOnhDys) {
		this.minOnhDys = minOnhDys;
	}

	/**
	 * Column Info
	 * 
	 * @param pUpCharge
	 */
	public void setPUpCharge(String pUpCharge) {
		this.pUpCharge = pUpCharge;
	}

	/**
	 * Column Info
	 * 
	 * @param o4Old
	 */
	public void setO4Old(String o4Old) {
		this.o4Old = o4Old;
	}

	/**
	 * Column Info
	 * 
	 * @param q4Lon
	 */
	public void setQ4Lon(String q4Lon) {
		this.q4Lon = q4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param o2Lon
	 */
	public void setO2Lon(String o2Lon) {
		this.o2Lon = o2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param a4Lon
	 */
	public void setA4Lon(String a4Lon) {
		this.a4Lon = a4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param a2Old
	 */
	public void setA2Old(String a2Old) {
		this.a2Old = a2Old;
	}

	/**
	 * Column Info
	 * 
	 * @param mftYr
	 */
	public void setMftYr(String mftYr) {
		this.mftYr = mftYr;
	}

	/**
	 * Column Info
	 * 
	 * @param r4Lon
	 */
	public void setR4Lon(String r4Lon) {
		this.r4Lon = r4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param s2New
	 */
	public void setS2New(String s2New) {
		this.s2New = s2New;
	}

	/**
	 * Column Info
	 * 
	 * @param mYear
	 */
	public void setMYear(String mYear) {
		this.mYear = mYear;
	}

	/**
	 * Column Info
	 * 
	 * @param r2Old
	 */
	public void setR2Old(String r2Old) {
		this.r2Old = r2Old;
	}

	/**
	 * Column Info
	 * 
	 * @param p4Old
	 */
	public void setP4Old(String p4Old) {
		this.p4Old = p4Old;
	}

	/**
	 * Column Info
	 * 
	 * @param f4New
	 */
	public void setF4New(String f4New) {
		this.f4New = f4New;
	}

	/**
	 * Column Info
	 * 
	 * @param q4Old
	 */
	public void setQ4Old(String q4Old) {
		this.q4Old = q4Old;
	}

	/**
	 * Column Info
	 * 
	 * @param d7New
	 */
	public void setD7New(String d7New) {
		this.d7New = d7New;
	}

	/**
	 * Column Info
	 * 
	 * @param f5Lon
	 */
	public void setF5Lon(String f5Lon) {
		this.f5Lon = f5Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param r2Lon
	 */
	public void setR2Lon(String r2Lon) {
		this.r2Lon = r2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param s4New
	 */
	public void setS4New(String s4New) {
		this.s4New = s4New;
	}

	/**
	 * Column Info
	 * 
	 * @param r7New
	 */
	public void setR7New(String r7New) {
		this.r7New = r7New;
	}

	/**
	 * Column Info
	 * 
	 * @param divTotalOld
	 */
	public void setDivTotalOld(String divTotalOld) {
		this.divTotalOld = divTotalOld;
	}

	/**
	 * Column Info
	 * 
	 * @param leaseTerm
	 */
	public void setLeaseTerm(String leaseTerm) {
		this.leaseTerm = leaseTerm;
	}

	/**
	 * Column Info
	 * 
	 * @param p2Lon
	 */
	public void setP2Lon(String p2Lon) {
		this.p2Lon = p2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param t4New
	 */
	public void setT4New(String t4New) {
		this.t4New = t4New;
	}

	/**
	 * Column Info
	 * 
	 * @param dxLon
	 */
	public void setDxLon(String dxLon) {
		this.dxLon = dxLon;
	}

	/**
	 * Column Info
	 * 
	 * @param r4New
	 */
	public void setR4New(String r4New) {
		this.r4New = r4New;
	}

	/**
	 * Column Info
	 * 
	 * @param d9Old
	 */
	public void setD9Old(String d9Old) {
		this.d9Old = d9Old;
	}

	/**
	 * Column Info
	 * 
	 * @param r4Old
	 */
	public void setR4Old(String r4Old) {
		this.r4Old = r4Old;
	}

	/**
	 * Column Info
	 * 
	 * @param r2New
	 */
	public void setR2New(String r2New) {
		this.r2New = r2New;
	}

	/**
	 * Column Info
	 * 
	 * @param dwOld
	 */
	public void setDwOld(String dwOld) {
		this.dwOld = dwOld;
	}

	/**
	 * Column Info
	 * 
	 * @param freeDay
	 */
	public void setFreeDay(String freeDay) {
		this.freeDay = freeDay;
	}

	/**
	 * Column Info
	 * 
	 * @param q4New
	 */
	public void setQ4New(String q4New) {
		this.q4New = q4New;
	}

	/**
	 * Column Info
	 * 
	 * @param a4New
	 */
	public void setA4New(String a4New) {
		this.a4New = a4New;
	}

	/**
	 * Column Info
	 * 
	 * @param freeDys
	 */
	public void setFreeDys(String freeDys) {
		this.freeDys = freeDys;
	}

	/**
	 * Column Info
	 * 
	 * @param f2New
	 */
	public void setF2New(String f2New) {
		this.f2New = f2New;
	}

	/**
	 * Column Info
	 * 
	 * @param pkupChgAmt
	 */
	public void setPkupChgAmt(String pkupChgAmt) {
		this.pkupChgAmt = pkupChgAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param p4Lon
	 */
	public void setP4Lon(String p4Lon) {
		this.p4Lon = p4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param dppFreeDay
	 */
	public void setDppFreeDay(String dppFreeDay) {
		this.dppFreeDay = dppFreeDay;
	}

	/**
	 * Column Info
	 * 
	 * @param f5New
	 */
	public void setF5New(String f5New) {
		this.f5New = f5New;
	}

	/**
	 * Column Info
	 * 
	 * @param f4Old
	 */
	public void setF4Old(String f4Old) {
		this.f4Old = f4Old;
	}

	/**
	 * Column Info
	 * 
	 * @param d8New
	 */
	public void setD8New(String d8New) {
		this.d8New = d8New;
	}

	/**
	 * Column Info
	 * 
	 * @param q2Lon
	 */
	public void setQ2Lon(String q2Lon) {
		this.q2Lon = q2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrOnhAuthNo
	 */
	public void setCntrOnhAuthNo(String cntrOnhAuthNo) {
		this.cntrOnhAuthNo = cntrOnhAuthNo;
	}

	/**
	 * Column Info
	 * 
	 * @param s2Old
	 */
	public void setS2Old(String s2Old) {
		this.s2Old = s2Old;
	}

	/**
	 * Column Info
	 * 
	 * @param t2Lon
	 */
	public void setT2Lon(String t2Lon) {
		this.t2Lon = t2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param d7Old
	 */
	public void setD7Old(String d7Old) {
		this.d7Old = d7Old;
	}

	/**
	 * Column Info
	 * 
	 * @param lstm
	 */
	public void setLstm(String lstm) {
		this.lstm = lstm;
	}

	/**
	 * Column Info
	 * 
	 * @param d2Lon
	 */
	public void setD2Lon(String d2Lon) {
		this.d2Lon = d2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param r5Lon
	 */
	public void setR5Lon(String r5Lon) {
		this.r5Lon = r5Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param dwLon
	 */
	public void setDwLon(String dwLon) {
		this.dwLon = dwLon;
	}

	/**
	 * Column Info
	 * 
	 * @param p2New
	 */
	public void setP2New(String p2New) {
		this.p2New = p2New;
	}

	/**
	 * Column Info
	 * 
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	/**
	 * Column Info
	 * 
	 * @param aproRmk
	 */
	public void setAproRmk(String aproRmk) {
		this.aproRmk = aproRmk;
	}

	/**
	 * Column Info
	 * 
	 * @param r7Old
	 */
	public void setR7Old(String r7Old) {
		this.r7Old = r7Old;
	}

	/**
	 * Column Info
	 * 
	 * @param f2Lon
	 */
	public void setF2Lon(String f2Lon) {
		this.f2Lon = f2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param d3Old
	 */
	public void setD3Old(String d3Old) {
		this.d3Old = d3Old;
	}

	/**
	 * Column Info
	 * 
	 * @param a2Lon
	 */
	public void setA2Lon(String a2Lon) {
		this.a2Lon = a2Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param t4Old
	 */
	public void setT4Old(String t4Old) {
		this.t4Old = t4Old;
	}

	/**
	 * Column Info
	 * 
	 * @param dwNew
	 */
	public void setDwNew(String dwNew) {
		this.dwNew = dwNew;
	}

	/**
	 * Column Info
	 * 
	 * @param dxNew
	 */
	public void setDxNew(String dxNew) {
		this.dxNew = dxNew;
	}

	/**
	 * Column Info
	 * 
	 * @param d9Lon
	 */
	public void setD9Lon(String d9Lon) {
		this.d9Lon = d9Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param n1stChgAmt
	 */
	public void setN1stChgAmt(String n1stChgAmt) {
		this.n1stChgAmt = n1stChgAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param pUpCredit
	 */
	public void setPUpCredit(String pUpCredit) {
		this.pUpCredit = pUpCredit;
	}

	/**
	 * Column Info
	 * 
	 * @param r7Lon
	 */
	public void setR7Lon(String r7Lon) {
		this.r7Lon = r7Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param f2Old
	 */
	public void setF2Old(String f2Old) {
		this.f2Old = f2Old;
	}

	/**
	 * Column Info
	 * 
	 * @param o4Lon
	 */
	public void setO4Lon(String o4Lon) {
		this.o4Lon = o4Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param minOnhDays
	 */
	public void setMinOnhDays(String minOnhDays) {
		this.minOnhDays = minOnhDays;
	}

	/**
	 * Column Info
	 * 
	 * @param sPkupDueDt
	 */
	public void setSPkupDueDt(String sPkupDueDt) {
		this.sPkupDueDt = sPkupDueDt;
	}

	/**
	 * Column Info
	 * 
	 * @param pkupChgCrAmt
	 */
	public void setPkupChgCrAmt(String pkupChgCrAmt) {
		this.pkupChgCrAmt = pkupChgCrAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param d9New
	 */
	public void setD9New(String d9New) {
		this.d9New = d9New;
	}

	/**
	 * Column Info
	 * 
	 * @param dxOld
	 */
	public void setDxOld(String dxOld) {
		this.dxOld = dxOld;
	}

	/**
	 * Column Info
	 * 
	 * @param a4Old
	 */
	public void setA4Old(String a4Old) {
		this.a4Old = a4Old;
	}

	/**
	 * Column Info
	 * 
	 * @param d5New
	 */
	public void setD5New(String d5New) {
		this.d5New = d5New;
	}

	/**
	 * Column Info
	 * 
	 * @param f5Old
	 */
	public void setF5Old(String f5Old) {
		this.f5Old = f5Old;
	}

	/**
	 * Column Info
	 * 
	 * @param d2Old
	 */
	public void setD2Old(String d2Old) {
		this.d2Old = d2Old;
	}

	/**
	 * Column Info
	 * 
	 * @param tpszCd
	 */
	public void setTpszCd(String tpszCd) {
		this.tpszCd = tpszCd;
	}

	/**
	 * Column Info
	 * 
	 * @param d3New
	 */
	public void setD3New(String d3New) {
		this.d3New = d3New;
	}

	/**
	 * Column Info
	 * 
	 * @param d4New
	 */
	public void setD4New(String d4New) {
		this.d4New = d4New;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param q2Old
	 */
	public void setQ2Old(String q2Old) {
		this.q2Old = q2Old;
	}

	/**
	 * Column Info
	 * 
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	/**
	 * Column Info
	 * 
	 * @param d8Old
	 */
	public void setD8Old(String d8Old) {
		this.d8Old = d8Old;
	}

	/**
	 * Column Info
	 * 
	 * @param o2New
	 */
	public void setO2New(String o2New) {
		this.o2New = o2New;
	}

	/**
	 * Column Info
	 * 
	 * @param d8Lon
	 */
	public void setD8Lon(String d8Lon) {
		this.d8Lon = d8Lon;
	}

	/**
	 * Column Info
	 * 
	 * @param pkupDueDt
	 */
	public void setPkupDueDt(String pkupDueDt) {
		this.pkupDueDt = pkupDueDt;
	}

	/**
	 * Column Info
	 * 
	 * @param sAproRmk
	 */
	public void setSAproRmk(String sAproRmk) {
		this.sAproRmk = sAproRmk;
	}

	/**
	 * Column Info
	 * 
	 * @param t2New
	 */
	public void setT2New(String t2New) {
		this.t2New = t2New;
	}

	/**
	 * Column Info
	 * 
	 * @param divTotal
	 */
	public void setDivTotal(String divTotal) {
		this.divTotal = divTotal;
	}

	/**
	 * Column Info
	 * 
	 * @param r5Old
	 */
	public void setR5Old(String r5Old) {
		this.r5Old = r5Old;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrTpszCd2
	 */
	public void setCntrTpszCd2(String cntrTpszCd2) {
		this.cntrTpszCd2 = cntrTpszCd2;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrTpszCd1
	 */
	public void setCntrTpszCd1(String cntrTpszCd1) {
		this.cntrTpszCd1 = cntrTpszCd1;
	}

	/**
	 * Column Info
	 * 
	 * @param d5Old
	 */
	public void setD5Old(String d5Old) {
		this.d5Old = d5Old;
	}

	/**
	 * Column Info
	 * 
	 * @return arrOld
	 */
	public String getArrOld() {
		return arrOld;
	}

	/**
	 * Column Info
	 * 
	 * @param arrOld
	 */
	public void setArrOld(String arrOld) {
		this.arrOld = arrOld;
	}

	/**
	 * Column Info
	 * 
	 * @return arrNew
	 */
	public String getArrNew() {
		return arrNew;
	}

	/**
	 * Column Info
	 * 
	 * @param arrNew
	 */
	public void setArrNew(String arrNew) {
		this.arrNew = arrNew;
	}

	/**
	 * Column Info
	 * 
	 * @return arrLon
	 */
	public String getArrLon() {
		return arrLon;
	}

	/**
	 * Column Info
	 * 
	 * @param arrLon
	 */
	public void setArrLon(String arrLon) {
		this.arrLon = arrLon;
	}
	
	

	/**
	 * @return the reqNo
	 */
	public String getReqNo() {
		return reqNo;
	}

	/**
	 * @param reqNo the reqNo to set
	 */
	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}

	
	/**
	 * @return the totalList
	 */
	public String getTotalList() {
		return totalList;
	}

	/**
	 * @param totalList the totalList to set
	 */
	public void setTotalList(String totalList) {
		this.totalList = totalList;
	}

	
	/**
	 * @return the onhOrdYr
	 */
	public String getOnhOrdYr() {
		return onhOrdYr;
	}
	
	/**
	 * @return the d1New
	 */
	public String getD1New() {
		return d1New;
	}
	
	/**
	 * @return the d1Lon
	 */
	public String getD1Lon() {
		return d1Lon;
	}
	
	/**
	 * @return the d1Old
	 */
	public String getD1Old() {
		return d1Old;
	}	

	/**
	 * @param onhOrdYr the onhOrdYr to set
	 */
	public void setOnhOrdYr(String onhOrdYr) {
		this.onhOrdYr = onhOrdYr;
	}
	
	/**
	 * @param d1New the d1New to set
	 */
	public void setD1New(String d1New) {
		this.d1New = d1New;
	}
	
	/**
	 * @param d1Lon the d1Lon to set
	 */
	public void setD1Lon(String d1Lon) {
		this.d1Lon = d1Lon;
	}
	
	/**
	 * @param d1Old the d1Old to set
	 */
	public void setD1Old(String d1Old) {
		this.d1Old = d1Old;
	}	

	/**
	 * @param eccCd the eccCd to set
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}	

	/**
	 * @param lccCd the lccCd to set
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}	

	/**
	 * @param locCod the locCod to set
	 */
	public void setLocCod(String locCod) {
		this.locCod = locCod;
	}	

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setS4Old(JSPUtil.getParameter(request, "s4_old", ""));
		setD3Lon(JSPUtil.getParameter(request, "d3_lon", ""));
		setD2New(JSPUtil.getParameter(request, "d2_new", ""));
		setA5New(JSPUtil.getParameter(request, "a5_new", ""));
		setA5Lon(JSPUtil.getParameter(request, "a5_lon", ""));
		setA5Old(JSPUtil.getParameter(request, "a5_old", ""));
		setD4Lon(JSPUtil.getParameter(request, "d4_lon", ""));
		setS2Lon(JSPUtil.getParameter(request, "s2_lon", ""));
		setO2Old(JSPUtil.getParameter(request, "o2_old", ""));
		setA2New(JSPUtil.getParameter(request, "a2_new", ""));
		setF4Lon(JSPUtil.getParameter(request, "f4_lon", ""));
		setP4New(JSPUtil.getParameter(request, "p4_new", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTysz(JSPUtil.getParameter(request, "tysz", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setS4Lon(JSPUtil.getParameter(request, "s4_lon", ""));
		setDivTotalNew(JSPUtil.getParameter(request, "div_total_new", ""));
		setD7Lon(JSPUtil.getParameter(request, "d7_lon", ""));
		setD4Old(JSPUtil.getParameter(request, "d4_old", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setD5Lon(JSPUtil.getParameter(request, "d5_lon", ""));
		setR5New(JSPUtil.getParameter(request, "r5_new", ""));
		setDpp(JSPUtil.getParameter(request, "dpp", ""));
		setLessor(JSPUtil.getParameter(request, "lessor", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setQ2New(JSPUtil.getParameter(request, "q2_new", ""));
		setT2Old(JSPUtil.getParameter(request, "t2_old", ""));
		setP2Old(JSPUtil.getParameter(request, "p2_old", ""));
		setO4New(JSPUtil.getParameter(request, "o4_new", ""));
		setT4Lon(JSPUtil.getParameter(request, "t4_lon", ""));
		setMinOnhDys(JSPUtil.getParameter(request, "min_onh_dys", ""));
		setPUpCharge(JSPUtil.getParameter(request, "p_up_charge", ""));
		setO4Old(JSPUtil.getParameter(request, "o4_old", ""));
		setQ4Lon(JSPUtil.getParameter(request, "q4_lon", ""));
		setO2Lon(JSPUtil.getParameter(request, "o2_lon", ""));
		setA4Lon(JSPUtil.getParameter(request, "a4_lon", ""));
		setA2Old(JSPUtil.getParameter(request, "a2_old", ""));
		setMftYr(JSPUtil.getParameter(request, "mft_yr", ""));
		setR4Lon(JSPUtil.getParameter(request, "r4_lon", ""));
		setS2New(JSPUtil.getParameter(request, "s2_new", ""));
		setMYear(JSPUtil.getParameter(request, "m_year", ""));
		setR2Old(JSPUtil.getParameter(request, "r2_old", ""));
		setP4Old(JSPUtil.getParameter(request, "p4_old", ""));
		setF4New(JSPUtil.getParameter(request, "f4_new", ""));
		setQ4Old(JSPUtil.getParameter(request, "q4_old", ""));
		setD7New(JSPUtil.getParameter(request, "d7_new", ""));
		setF5Lon(JSPUtil.getParameter(request, "f5_lon", ""));
		setR2Lon(JSPUtil.getParameter(request, "r2_lon", ""));
		setS4New(JSPUtil.getParameter(request, "s4_new", ""));
		setR7New(JSPUtil.getParameter(request, "r7_new", ""));
		setDivTotalOld(JSPUtil.getParameter(request, "div_total_old", ""));
		setLeaseTerm(JSPUtil.getParameter(request, "lease_term", ""));
		setP2Lon(JSPUtil.getParameter(request, "p2_lon", ""));
		setT4New(JSPUtil.getParameter(request, "t4_new", ""));
		setDxLon(JSPUtil.getParameter(request, "dx_lon", ""));
		setR4New(JSPUtil.getParameter(request, "r4_new", ""));
		setD9Old(JSPUtil.getParameter(request, "d9_old", ""));
		setR4Old(JSPUtil.getParameter(request, "r4_old", ""));
		setR2New(JSPUtil.getParameter(request, "r2_new", ""));
		setDwOld(JSPUtil.getParameter(request, "dw_old", ""));
		setFreeDay(JSPUtil.getParameter(request, "free_day", ""));
		setQ4New(JSPUtil.getParameter(request, "q4_new", ""));
		setA4New(JSPUtil.getParameter(request, "a4_new", ""));
		setFreeDys(JSPUtil.getParameter(request, "free_dys", ""));
		setF2New(JSPUtil.getParameter(request, "f2_new", ""));
		setPkupChgAmt(JSPUtil.getParameter(request, "pkup_chg_amt", ""));
		setP4Lon(JSPUtil.getParameter(request, "p4_lon", ""));
		setDppFreeDay(JSPUtil.getParameter(request, "dpp_free_day", ""));
		setF5New(JSPUtil.getParameter(request, "f5_new", ""));
		setF4Old(JSPUtil.getParameter(request, "f4_old", ""));
		setD8New(JSPUtil.getParameter(request, "d8_new", ""));
		setQ2Lon(JSPUtil.getParameter(request, "q2_lon", ""));
		setCntrOnhAuthNo(JSPUtil.getParameter(request, "cntr_onh_auth_no", ""));
		setS2Old(JSPUtil.getParameter(request, "s2_old", ""));
		setT2Lon(JSPUtil.getParameter(request, "t2_lon", ""));
		setD7Old(JSPUtil.getParameter(request, "d7_old", ""));
		setLstm(JSPUtil.getParameter(request, "lstm", ""));
		setD2Lon(JSPUtil.getParameter(request, "d2_lon", ""));
		setR5Lon(JSPUtil.getParameter(request, "r5_lon", ""));
		setDwLon(JSPUtil.getParameter(request, "dw_lon", ""));
		setP2New(JSPUtil.getParameter(request, "p2_new", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setAproRmk(JSPUtil.getParameter(request, "apro_rmk", ""));
		setR7Old(JSPUtil.getParameter(request, "r7_old", ""));
		setF2Lon(JSPUtil.getParameter(request, "f2_lon", ""));
		setD3Old(JSPUtil.getParameter(request, "d3_old", ""));
		setA2Lon(JSPUtil.getParameter(request, "a2_lon", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setT4Old(JSPUtil.getParameter(request, "t4_old", ""));
		setDwNew(JSPUtil.getParameter(request, "dw_new", ""));
		setDxNew(JSPUtil.getParameter(request, "dx_new", ""));
		setD9Lon(JSPUtil.getParameter(request, "d9_lon", ""));
		setN1stChgAmt(JSPUtil.getParameter(request, "n1st_chg_amt", ""));
		setPUpCredit(JSPUtil.getParameter(request, "p_up_credit", ""));
		setR7Lon(JSPUtil.getParameter(request, "r7_lon", ""));
		setF2Old(JSPUtil.getParameter(request, "f2_old", ""));
		setO4Lon(JSPUtil.getParameter(request, "o4_lon", ""));
		setMinOnhDays(JSPUtil.getParameter(request, "min_onh_days", ""));
		setSPkupDueDt(JSPUtil.getParameter(request, "s_pkup_due_dt", ""));
		setPkupChgCrAmt(JSPUtil.getParameter(request, "pkup_chg_cr_amt", ""));
		setD9New(JSPUtil.getParameter(request, "d9_new", ""));
		setDxOld(JSPUtil.getParameter(request, "dx_old", ""));
		setA4Old(JSPUtil.getParameter(request, "a4_old", ""));
		setD5New(JSPUtil.getParameter(request, "d5_new", ""));
		setF5Old(JSPUtil.getParameter(request, "f5_old", ""));
		setD2Old(JSPUtil.getParameter(request, "d2_old", ""));
		setTpszCd(JSPUtil.getParameter(request, "tpsz_cd", ""));
		setD3New(JSPUtil.getParameter(request, "d3_new", ""));
		setD4New(JSPUtil.getParameter(request, "d4_new", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setQ2Old(JSPUtil.getParameter(request, "q2_old", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setD8Old(JSPUtil.getParameter(request, "d8_old", ""));
		setO2New(JSPUtil.getParameter(request, "o2_new", ""));
		setD8Lon(JSPUtil.getParameter(request, "d8_lon", ""));
		setPkupDueDt(JSPUtil.getParameter(request, "pkup_due_dt", ""));
		setSAproRmk(JSPUtil.getParameter(request, "s_apro_rmk", ""));
		setT2New(JSPUtil.getParameter(request, "t2_new", ""));
		setDivTotal(JSPUtil.getParameter(request, "div_total", ""));
		setR5Old(JSPUtil.getParameter(request, "r5_old", ""));
		setCntrTpszCd2(JSPUtil.getParameter(request, "cntr_tpsz_cd2", ""));
		setCntrTpszCd1(JSPUtil.getParameter(request, "cntr_tpsz_cd1", ""));
		setD5Old(JSPUtil.getParameter(request, "d5_old", ""));
		setReqNo(JSPUtil.getParameter(request, "reqno", ""));
		setTotalList(JSPUtil.getParameter(request, "totallist", ""));
		setOnhOrdYr(JSPUtil.getParameter(request, "onh_ord_yr", ""));
		setD1New(JSPUtil.getParameter(request, "d1_new", ""));
		setD1Lon(JSPUtil.getParameter(request, "d1_lon", ""));
		setD1Old(JSPUtil.getParameter(request, "d1_old", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setLccCd(JSPUtil.getParameter(request, "lcc_cd", ""));
		setLocCod(JSPUtil.getParameter(request, "loc_cod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return OnhireApprovalVO[]
	 */
	public OnhireApprovalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return OnhireApprovalVO[]
	 */
	public OnhireApprovalVO[] fromRequestGrid(HttpServletRequest request,String prefix) {
		OnhireApprovalVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
	    String[] arrTpSz =null;
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;
		setTpszCd(JSPUtil.getParameter(request, "tpsz_cd", ""));
		tpszCd = getTpszCd().toLowerCase();
  		
		arrTpSz = tpszCd.split("[,]");

		try {
			String[] s4Old = (JSPUtil.getParameter(request, prefix + "s4_old", length));
			String[] d3Lon = (JSPUtil.getParameter(request, prefix + "d3_lon", length));
			String[] d2New = (JSPUtil.getParameter(request, prefix + "d2_new", length));
			String[] a5New = (JSPUtil.getParameter(request, prefix + "a5_new", length));
			String[] a5Lon = (JSPUtil.getParameter(request, prefix + "a5_lon", length));
			String[] a5Old = (JSPUtil.getParameter(request, prefix + "a5_old", length));
			String[] d4Lon = (JSPUtil.getParameter(request, prefix + "d4_lon", length));
			String[] s2Lon = (JSPUtil.getParameter(request, prefix + "s2_lon", length));
			String[] o2Old = (JSPUtil.getParameter(request, prefix + "o2_old", length));
			String[] a2New = (JSPUtil.getParameter(request, prefix + "a2_new", length));
			String[] f4Lon = (JSPUtil.getParameter(request, prefix + "f4_lon", length));
			String[] p4New = (JSPUtil.getParameter(request, prefix + "p4_new", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] tysz = (JSPUtil.getParameter(request, prefix + "tysz", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
			String[] s4Lon = (JSPUtil.getParameter(request, prefix + "s4_lon", length));
			String[] divTotalNew = (JSPUtil.getParameter(request, prefix + "div_total_new", length));
			String[] d7Lon = (JSPUtil.getParameter(request, prefix + "d7_lon", length));
			String[] d4Old = (JSPUtil.getParameter(request, prefix + "d4_old", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] d5Lon = (JSPUtil.getParameter(request, prefix + "d5_lon", length));
			String[] r5New = (JSPUtil.getParameter(request, prefix + "r5_new", length));
			String[] dpp = (JSPUtil.getParameter(request, prefix + "dpp", length));
			String[] lessor = (JSPUtil.getParameter(request, prefix + "lessor",	length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix + "agmt_no", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix + "ref_no",	length));
			String[] q2New = (JSPUtil.getParameter(request, prefix + "q2_new",	length));
			String[] t2Old = (JSPUtil.getParameter(request, prefix + "t2_old",	length));
			String[] p2Old = (JSPUtil.getParameter(request, prefix + "p2_old",	length));
			String[] o4New = (JSPUtil.getParameter(request, prefix + "o4_new",	length));
			String[] t4Lon = (JSPUtil.getParameter(request, prefix + "t4_lon",	length));
			String[] minOnhDys = (JSPUtil.getParameter(request, prefix + "min_onh_dys", length));
			String[] pUpCharge = (JSPUtil.getParameter(request, prefix + "p_up_charge", length));
			String[] o4Old = (JSPUtil.getParameter(request, prefix + "o4_old", length));
			String[] q4Lon = (JSPUtil.getParameter(request, prefix + "q4_lon", length));
			String[] o2Lon = (JSPUtil.getParameter(request, prefix + "o2_lon", length));
			String[] a4Lon = (JSPUtil.getParameter(request, prefix + "a4_lon", length));
			String[] a2Old = (JSPUtil.getParameter(request, prefix + "a2_old", length));
			String[] mftYr = (JSPUtil.getParameter(request, prefix + "mft_yr", length));
			String[] r4Lon = (JSPUtil.getParameter(request, prefix + "r4_lon", length));
			String[] s2New = (JSPUtil.getParameter(request, prefix + "s2_new", length));
			String[] mYear = (JSPUtil.getParameter(request, prefix + "m_year", length));
			String[] r2Old = (JSPUtil.getParameter(request, prefix + "r2_old", length));
			String[] p4Old = (JSPUtil.getParameter(request, prefix + "p4_old", length));
			String[] f4New = (JSPUtil.getParameter(request, prefix + "f4_new", length));
			String[] q4Old = (JSPUtil.getParameter(request, prefix + "q4_old", length));
			String[] d7New = (JSPUtil.getParameter(request, prefix + "d7_new", length));
			String[] f5Lon = (JSPUtil.getParameter(request, prefix + "f5_lon", length));
			String[] r2Lon = (JSPUtil.getParameter(request, prefix + "r2_lon", length));
			String[] s4New = (JSPUtil.getParameter(request, prefix + "s4_new", length));
			String[] r7New = (JSPUtil.getParameter(request, prefix + "r7_new", length));
			String[] divTotalOld = (JSPUtil.getParameter(request, prefix + "div_total_old", length));
			String[] leaseTerm = (JSPUtil.getParameter(request, prefix + "lease_term", length));
			String[] p2Lon = (JSPUtil.getParameter(request, prefix + "p2_lon", length));
			String[] t4New = (JSPUtil.getParameter(request, prefix + "t4_new", length));
			String[] dxLon = (JSPUtil.getParameter(request, prefix + "dx_lon", length));
			String[] r4New = (JSPUtil.getParameter(request, prefix + "r4_new", length));
			String[] d9Old = (JSPUtil.getParameter(request, prefix + "d9_old", length));
			String[] r4Old = (JSPUtil.getParameter(request, prefix + "r4_old", length));
			String[] r2New = (JSPUtil.getParameter(request, prefix + "r2_new", length));
			String[] dwOld = (JSPUtil.getParameter(request, prefix + "dw_old", length));
			String[] freeDay = (JSPUtil.getParameter(request, prefix + "free_day", length));
			String[] q4New = (JSPUtil.getParameter(request, prefix + "q4_new", length));
			String[] a4New = (JSPUtil.getParameter(request, prefix + "a4_new", length));
			String[] freeDys = (JSPUtil.getParameter(request, prefix + "free_dys", length));
			String[] f2New = (JSPUtil.getParameter(request, prefix + "f2_new", length));
			String[] pkupChgAmt = (JSPUtil.getParameter(request, prefix	+ "pkup_chg_amt", length));
			String[] p4Lon = (JSPUtil.getParameter(request, prefix + "p4_lon", length));
			String[] dppFreeDay = (JSPUtil.getParameter(request, prefix + "dpp_free_day", length));
			String[] f5New = (JSPUtil.getParameter(request, prefix + "f5_new", length));
			String[] f4Old = (JSPUtil.getParameter(request, prefix + "f4_old", length));
			String[] d8New = (JSPUtil.getParameter(request, prefix + "d8_new", length));
			String[] q2Lon = (JSPUtil.getParameter(request, prefix + "q2_lon", length));
			String[] cntrOnhAuthNo = (JSPUtil.getParameter(request, prefix + "cntr_onh_auth_no", length));
			String[] s2Old = (JSPUtil.getParameter(request, prefix + "s2_old", length));
			String[] t2Lon = (JSPUtil.getParameter(request, prefix + "t2_lon", length));
			String[] d7Old = (JSPUtil.getParameter(request, prefix + "d7_old", length));
			String[] lstm = (JSPUtil.getParameter(request, prefix + "lstm",	length));
			String[] d2Lon = (JSPUtil.getParameter(request, prefix + "d2_lon", length));
			String[] r5Lon = (JSPUtil.getParameter(request, prefix + "r5_lon", length));
			String[] dwLon = (JSPUtil.getParameter(request, prefix + "dw_lon", length));
			String[] p2New = (JSPUtil.getParameter(request, prefix + "p2_new", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix + "lstm_cd", length));
			String[] aproRmk = (JSPUtil.getParameter(request, prefix + "apro_rmk", length));
			String[] r7Old = (JSPUtil.getParameter(request, prefix + "r7_old", length));
			String[] f2Lon = (JSPUtil.getParameter(request, prefix + "f2_lon", length));
			String[] d3Old = (JSPUtil.getParameter(request, prefix + "d3_old", length));
			String[] a2Lon = (JSPUtil.getParameter(request, prefix + "a2_lon", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix + "agmt_seq", length));
			String[] t4Old = (JSPUtil.getParameter(request, prefix + "t4_old", length));
			String[] dwNew = (JSPUtil.getParameter(request, prefix + "dw_new", length));
			String[] dxNew = (JSPUtil.getParameter(request, prefix + "dx_new", length));
			String[] d9Lon = (JSPUtil.getParameter(request, prefix + "d9_lon", length));
			String[] n1stChgAmt = (JSPUtil.getParameter(request, prefix	+ "n1st_chg_amt", length));
			String[] pUpCredit = (JSPUtil.getParameter(request, prefix	+ "p_up_credit", length));
			String[] r7Lon = (JSPUtil.getParameter(request, prefix + "r7_lon", length));
			String[] f2Old = (JSPUtil.getParameter(request, prefix + "f2_old", length));
			String[] o4Lon = (JSPUtil.getParameter(request, prefix + "o4_lon", length));
			String[] minOnhDays = (JSPUtil.getParameter(request, prefix	+ "min_onh_days", length));
			String[] sPkupDueDt = (JSPUtil.getParameter(request, prefix	+ "s_pkup_due_dt", length));
			String[] pkupChgCrAmt = (JSPUtil.getParameter(request, prefix + "pkup_chg_cr_amt", length));
			String[] d9New = (JSPUtil.getParameter(request, prefix + "d9_new", length));
			String[] dxOld = (JSPUtil.getParameter(request, prefix + "dx_old", length));
			String[] a4Old = (JSPUtil.getParameter(request, prefix + "a4_old", length));
			String[] d5New = (JSPUtil.getParameter(request, prefix + "d5_new", length));
			String[] f5Old = (JSPUtil.getParameter(request, prefix + "f5_old", length));
			String[] d2Old = (JSPUtil.getParameter(request, prefix + "d2_old", length));
			String[] tpszCd = (JSPUtil.getParameter(request, prefix + "tpsz_cd", length));
			String[] d3New = (JSPUtil.getParameter(request, prefix + "d3_new",	length));
			String[] d4New = (JSPUtil.getParameter(request, prefix + "d4_new",	length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag",	length));
			String[] q2Old = (JSPUtil.getParameter(request, prefix + "q2_old",	length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] d8Old = (JSPUtil.getParameter(request, prefix + "d8_old",	length));
			String[] o2New = (JSPUtil.getParameter(request, prefix + "o2_new",	length));
			String[] d8Lon = (JSPUtil.getParameter(request, prefix + "d8_lon",	length));
			String[] pkupDueDt = (JSPUtil.getParameter(request, prefix	+ "pkup_due_dt", length));
			String[] sAproRmk = (JSPUtil.getParameter(request, prefix	+ "s_apro_rmk", length));
			String[] t2New = (JSPUtil.getParameter(request, prefix + "t2_new",	length));
			String[] divTotal = (JSPUtil.getParameter(request, prefix + "div_total", length));
			String[] r5Old = (JSPUtil.getParameter(request, prefix + "r5_old",	length));
			String[] cntrTpszCd2 = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd2", length));
			String[] cntrTpszCd1 = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd1", length));
			String[] d5Old = (JSPUtil.getParameter(request, prefix + "d5_old",	length));
			String[] reqNo = (JSPUtil.getParameter(request, prefix + "reqno",	length));
			String[] totalList = (JSPUtil.getParameter(request, prefix + "totallist",	length));
			String[] onhOrdYr = (JSPUtil.getParameter(request, prefix + "onh_ord_yr",	length));
			String[] d1New = (JSPUtil.getParameter(request, prefix + "d1_new",	length));
			String[] d1Lon = (JSPUtil.getParameter(request, prefix + "d1_lon",	length));
			String[] d1Old = (JSPUtil.getParameter(request, prefix + "d1_old",	length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix + "ecc_cd",	length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix + "lcc_cd",	length));
			String[] locCod = (JSPUtil.getParameter(request, prefix + "loc_cod",	length));

			for (int i = 0; i < length; i++) {
				model = new OnhireApprovalVO();
				String strOld 		= "";
				String strLon 		= "";
				String strNew 		= "";
				for (int j = 0; j < arrTpSz.length; j++) {
					 String[] arrOld 		= (JSPUtil.getParameter(request, arrTpSz[j]+ "_old", length));
					 String[] arrLon 		= (JSPUtil.getParameter(request, arrTpSz[j]+ "_lon", length));
					 String[] arrNew 		= (JSPUtil.getParameter(request, arrTpSz[j]+ "_new", length));
					 
					 strOld 	= 	strOld 		+ arrOld[i] 	+  "|";
					 strLon 	= 	strLon 		+ arrLon[i]		+  "|";
					 strNew 	= 	strNew 		+ arrNew[i]		+  "|";
					}
				if (strOld != null)
					model.setArrOld(strOld);
				if (strLon != null)
					model.setArrLon(strLon);
				if (strNew != null)
					model.setArrNew(strNew);
				if (s4Old[i] != null)
					model.setS4Old(s4Old[i]);
				if (d3Lon[i] != null)
					model.setD3Lon(d3Lon[i]);
				if (d2New[i] != null)
					model.setD2New(d2New[i]);
				if (a5New[i] != null)
					model.setA5New(a5New[i]);
				if (a5Lon[i] != null)
					model.setA5Lon(a5Lon[i]);
				if (a5Old[i] != null)
					model.setA5Old(a5Old[i]);
				if (d4Lon[i] != null)
					model.setD4Lon(d4Lon[i]);
				if (s2Lon[i] != null)
					model.setS2Lon(s2Lon[i]);
				if (o2Old[i] != null)
					model.setO2Old(o2Old[i]);
				if (a2New[i] != null)
					model.setA2New(a2New[i]);
				if (f4Lon[i] != null)
					model.setF4Lon(f4Lon[i]);
				if (p4New[i] != null)
					model.setP4New(p4New[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tysz[i] != null)
					model.setTysz(tysz[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (s4Lon[i] != null)
					model.setS4Lon(s4Lon[i]);
				if (divTotalNew[i] != null)
					model.setDivTotalNew(divTotalNew[i]);
				if (d7Lon[i] != null)
					model.setD7Lon(d7Lon[i]);
				if (d4Old[i] != null)
					model.setD4Old(d4Old[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (d5Lon[i] != null)
					model.setD5Lon(d5Lon[i]);
				if (r5New[i] != null)
					model.setR5New(r5New[i]);
				if (dpp[i] != null)
					model.setDpp(dpp[i]);
				if (lessor[i] != null)
					model.setLessor(lessor[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (q2New[i] != null)
					model.setQ2New(q2New[i]);
				if (t2Old[i] != null)
					model.setT2Old(t2Old[i]);
				if (p2Old[i] != null)
					model.setP2Old(p2Old[i]);
				if (o4New[i] != null)
					model.setO4New(o4New[i]);
				if (t4Lon[i] != null)
					model.setT4Lon(t4Lon[i]);
				if (minOnhDys[i] != null)
					model.setMinOnhDys(minOnhDys[i]);
				if (pUpCharge[i] != null)
					model.setPUpCharge(pUpCharge[i]);
				if (o4Old[i] != null)
					model.setO4Old(o4Old[i]);
				if (q4Lon[i] != null)
					model.setQ4Lon(q4Lon[i]);
				if (o2Lon[i] != null)
					model.setO2Lon(o2Lon[i]);
				if (a4Lon[i] != null)
					model.setA4Lon(a4Lon[i]);
				if (a2Old[i] != null)
					model.setA2Old(a2Old[i]);
				if (mftYr[i] != null)
					model.setMftYr(mftYr[i]);
				if (r4Lon[i] != null)
					model.setR4Lon(r4Lon[i]);
				if (s2New[i] != null)
					model.setS2New(s2New[i]);
				if (mYear[i] != null)
					model.setMYear(mYear[i]);
				if (r2Old[i] != null)
					model.setR2Old(r2Old[i]);
				if (p4Old[i] != null)
					model.setP4Old(p4Old[i]);
				if (f4New[i] != null)
					model.setF4New(f4New[i]);
				if (q4Old[i] != null)
					model.setQ4Old(q4Old[i]);
				if (d7New[i] != null)
					model.setD7New(d7New[i]);
				if (f5Lon[i] != null)
					model.setF5Lon(f5Lon[i]);
				if (r2Lon[i] != null)
					model.setR2Lon(r2Lon[i]);
				if (s4New[i] != null)
					model.setS4New(s4New[i]);
				if (r7New[i] != null)
					model.setR7New(r7New[i]);
				if (divTotalOld[i] != null)
					model.setDivTotalOld(divTotalOld[i]);
				if (leaseTerm[i] != null)
					model.setLeaseTerm(leaseTerm[i]);
				if (p2Lon[i] != null)
					model.setP2Lon(p2Lon[i]);
				if (t4New[i] != null)
					model.setT4New(t4New[i]);
				if (dxLon[i] != null)
					model.setDxLon(dxLon[i]);
				if (r4New[i] != null)
					model.setR4New(r4New[i]);
				if (d9Old[i] != null)
					model.setD9Old(d9Old[i]);
				if (r4Old[i] != null)
					model.setR4Old(r4Old[i]);
				if (r2New[i] != null)
					model.setR2New(r2New[i]);
				if (dwOld[i] != null)
					model.setDwOld(dwOld[i]);
				if (freeDay[i] != null)
					model.setFreeDay(freeDay[i]);
				if (q4New[i] != null)
					model.setQ4New(q4New[i]);
				if (a4New[i] != null)
					model.setA4New(a4New[i]);
				if (freeDys[i] != null)
					model.setFreeDys(freeDys[i]);
				if (f2New[i] != null)
					model.setF2New(f2New[i]);
				if (pkupChgAmt[i] != null)
					model.setPkupChgAmt(pkupChgAmt[i]);
				if (p4Lon[i] != null)
					model.setP4Lon(p4Lon[i]);
				if (dppFreeDay[i] != null)
					model.setDppFreeDay(dppFreeDay[i]);
				if (f5New[i] != null)
					model.setF5New(f5New[i]);
				if (f4Old[i] != null)
					model.setF4Old(f4Old[i]);
				if (d8New[i] != null)
					model.setD8New(d8New[i]);
				if (q2Lon[i] != null)
					model.setQ2Lon(q2Lon[i]);
				if (cntrOnhAuthNo[i] != null)
					model.setCntrOnhAuthNo(cntrOnhAuthNo[i]);
				if (s2Old[i] != null)
					model.setS2Old(s2Old[i]);
				if (t2Lon[i] != null)
					model.setT2Lon(t2Lon[i]);
				if (d7Old[i] != null)
					model.setD7Old(d7Old[i]);
				if (lstm[i] != null)
					model.setLstm(lstm[i]);
				if (d2Lon[i] != null)
					model.setD2Lon(d2Lon[i]);
				if (r5Lon[i] != null)
					model.setR5Lon(r5Lon[i]);
				if (dwLon[i] != null)
					model.setDwLon(dwLon[i]);
				if (p2New[i] != null)
					model.setP2New(p2New[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (aproRmk[i] != null)
					model.setAproRmk(aproRmk[i]);
				if (r7Old[i] != null)
					model.setR7Old(r7Old[i]);
				if (f2Lon[i] != null)
					model.setF2Lon(f2Lon[i]);
				if (d3Old[i] != null)
					model.setD3Old(d3Old[i]);
				if (a2Lon[i] != null)
					model.setA2Lon(a2Lon[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (t4Old[i] != null)
					model.setT4Old(t4Old[i]);
				if (dwNew[i] != null)
					model.setDwNew(dwNew[i]);
				if (dxNew[i] != null)
					model.setDxNew(dxNew[i]);
				if (d9Lon[i] != null)
					model.setD9Lon(d9Lon[i]);
				if (n1stChgAmt[i] != null)
					model.setN1stChgAmt(n1stChgAmt[i]);
				if (pUpCredit[i] != null)
					model.setPUpCredit(pUpCredit[i]);
				if (r7Lon[i] != null)
					model.setR7Lon(r7Lon[i]);
				if (f2Old[i] != null)
					model.setF2Old(f2Old[i]);
				if (o4Lon[i] != null)
					model.setO4Lon(o4Lon[i]);
				if (minOnhDays[i] != null)
					model.setMinOnhDays(minOnhDays[i]);
				if (sPkupDueDt[i] != null)
					model.setSPkupDueDt(sPkupDueDt[i]);
				if (pkupChgCrAmt[i] != null)
					model.setPkupChgCrAmt(pkupChgCrAmt[i]);
				if (d9New[i] != null)
					model.setD9New(d9New[i]);
				if (dxOld[i] != null)
					model.setDxOld(dxOld[i]);
				if (a4Old[i] != null)
					model.setA4Old(a4Old[i]);
				if (d5New[i] != null)
					model.setD5New(d5New[i]);
				if (f5Old[i] != null)
					model.setF5Old(f5Old[i]);
				if (d2Old[i] != null)
					model.setD2Old(d2Old[i]);
				if (tpszCd[i] != null)
					model.setTpszCd(tpszCd[i]);
				if (d3New[i] != null)
					model.setD3New(d3New[i]);
				if (d4New[i] != null)
					model.setD4New(d4New[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (q2Old[i] != null)
					model.setQ2Old(q2Old[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (d8Old[i] != null)
					model.setD8Old(d8Old[i]);
				if (o2New[i] != null)
					model.setO2New(o2New[i]);
				if (d8Lon[i] != null)
					model.setD8Lon(d8Lon[i]);
				if (pkupDueDt[i] != null)
					model.setPkupDueDt(pkupDueDt[i]);
				if (sAproRmk[i] != null)
					model.setSAproRmk(sAproRmk[i]);
				if (t2New[i] != null)
					model.setT2New(t2New[i]);
				if (divTotal[i] != null)
					model.setDivTotal(divTotal[i]);
				if (r5Old[i] != null)
					model.setR5Old(r5Old[i]);
				if (cntrTpszCd2[i] != null)
					model.setCntrTpszCd2(cntrTpszCd2[i]);
				if (cntrTpszCd1[i] != null)
					model.setCntrTpszCd1(cntrTpszCd1[i]);
				if (d5Old[i] != null)
					model.setD5Old(d5Old[i]);
				if (reqNo[i] != null)
					model.setReqNo(reqNo[i]);
				if (totalList[i] != null)
					model.setTotalList(totalList[i]);
				if (onhOrdYr[i] != null)
					model.setOnhOrdYr(onhOrdYr[i]);
				if (d1New[i] != null)
					model.setD1New(d1New[i]);
				if (d1Lon[i] != null)
					model.setD1Lon(d1Lon[i]);
				if (d1Old[i] != null)
					model.setD1Old(d1Old[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (locCod[i] != null)
					model.setLocCod(locCod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOnhireApprovalVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return OnhireApprovalVO[]
	 */
	public OnhireApprovalVO[] getOnhireApprovalVOs() {
		OnhireApprovalVO[] vos = (OnhireApprovalVO[]) models
				.toArray(new OnhireApprovalVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(
								0, 30).concat("= ")
								+ arr[j] + "\n");
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
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = null;
		}
		return arr;
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.s4Old = this.s4Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d3Lon = this.d3Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d2New = this.d2New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.a5New = this.a5New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.a5Lon = this.a5Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.a5Old = this.a5Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d4Lon = this.d4Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.s2Lon = this.s2Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.o2Old = this.o2Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.a2New = this.a2New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.f4Lon = this.f4Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.p4New = this.p4New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.tysz = this.tysz.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.s4Lon = this.s4Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.divTotalNew = this.divTotalNew.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.d7Lon = this.d7Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d4Old = this.d4Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.d5Lon = this.d5Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.r5New = this.r5New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.dpp = this.dpp.replaceAll(",", "").replaceAll("-", "").replaceAll(
				"/", "").replaceAll(":", "");
		this.lessor = this.lessor.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.q2New = this.q2New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.t2Old = this.t2Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.p2Old = this.p2Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.o4New = this.o4New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.t4Lon = this.t4Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.minOnhDys = this.minOnhDys.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.pUpCharge = this.pUpCharge.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.o4Old = this.o4Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.q4Lon = this.q4Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.o2Lon = this.o2Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.a4Lon = this.a4Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.a2Old = this.a2Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.mftYr = this.mftYr.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.r4Lon = this.r4Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.s2New = this.s2New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.mYear = this.mYear.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.r2Old = this.r2Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.p4Old = this.p4Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.f4New = this.f4New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.q4Old = this.q4Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d7New = this.d7New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.f5Lon = this.f5Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.r2Lon = this.r2Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.s4New = this.s4New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.r7New = this.r7New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.divTotalOld = this.divTotalOld.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.leaseTerm = this.leaseTerm.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.p2Lon = this.p2Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.t4New = this.t4New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.dxLon = this.dxLon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.r4New = this.r4New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d9Old = this.d9Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.r4Old = this.r4Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.r2New = this.r2New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.dwOld = this.dwOld.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.freeDay = this.freeDay.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.q4New = this.q4New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.a4New = this.a4New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.freeDys = this.freeDys.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.f2New = this.f2New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.pkupChgAmt = this.pkupChgAmt.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.p4Lon = this.p4Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.dppFreeDay = this.dppFreeDay.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.f5New = this.f5New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.f4Old = this.f4Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d8New = this.d8New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.q2Lon = this.q2Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cntrOnhAuthNo = this.cntrOnhAuthNo.replaceAll(",", "").replaceAll(
				"-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Old = this.s2Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.t2Lon = this.t2Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d7Old = this.d7Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.lstm = this.lstm.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d2Lon = this.d2Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.r5Lon = this.r5Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.dwLon = this.dwLon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.p2New = this.p2New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.aproRmk = this.aproRmk.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.r7Old = this.r7Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.f2Lon = this.f2Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d3Old = this.d3Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.a2Lon = this.a2Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.t4Old = this.t4Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.dwNew = this.dwNew.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.dxNew = this.dxNew.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d9Lon = this.d9Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.n1stChgAmt = this.n1stChgAmt.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.pUpCredit = this.pUpCredit.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.r7Lon = this.r7Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.f2Old = this.f2Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.o4Lon = this.o4Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.minOnhDays = this.minOnhDays.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.sPkupDueDt = this.sPkupDueDt.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.pkupChgCrAmt = this.pkupChgCrAmt.replaceAll(",", "").replaceAll(
				"-", "").replaceAll("/", "").replaceAll(":", "");
		this.d9New = this.d9New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.dxOld = this.dxOld.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.a4Old = this.a4Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d5New = this.d5New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.f5Old = this.f5Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d2Old = this.d2Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.tpszCd = this.tpszCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d3New = this.d3New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d4New = this.d4New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.q2Old = this.q2Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d8Old = this.d8Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.o2New = this.o2New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.d8Lon = this.d8Lon.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.pkupDueDt = this.pkupDueDt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.sAproRmk = this.sAproRmk.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.t2New = this.t2New.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.divTotal = this.divTotal.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.r5Old = this.r5Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd2 = this.cntrTpszCd2.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd1 = this.cntrTpszCd1.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.d5Old = this.d5Old.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.reqNo = this.reqNo.replaceAll(",", "").replaceAll("-", "")
		        .replaceAll("/", "").replaceAll(":", "");
		this.totalList = this.totalList.replaceAll(",", "").replaceAll("-", "")
        .replaceAll("/", "").replaceAll(":", "");
		this.onhOrdYr = this.onhOrdYr.replaceAll(",", "").replaceAll("-", "")
        .replaceAll("/", "").replaceAll(":", "");
		this.d1New = this.d1New.replaceAll(",", "").replaceAll("-", "")
		        .replaceAll("/", "").replaceAll(":", "");
		this.d1Lon = this.d1Lon.replaceAll(",", "").replaceAll("-", "")
		        .replaceAll("/", "").replaceAll(":", "");
		this.d1Old = this.d1Old.replaceAll(",", "").replaceAll("-", "")
		        .replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd.replaceAll(",", "").replaceAll("-", "")
		        .replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd.replaceAll(",", "").replaceAll("-", "")
		        .replaceAll("/", "").replaceAll(":", "");
		this.locCod = this.locCod.replaceAll(",", "").replaceAll("-", "")
		        .replaceAll("/", "").replaceAll(":", "");
	}
}
