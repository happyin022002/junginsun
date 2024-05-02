/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvtSmryVO.java
*@FileTitle : InvtSmryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.05.21 김종준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종준
 * @since J2EE 1.5
 * @see AbstractValueObject
 */


public class InvtSmryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvtSmryVO> models = new ArrayList<InvtSmryVO>();
	
	/* Column Info */
	private String qty11 = null;
	/* Column Info */
	private String qty12 = null;
	/* Column Info */
	private String qty10 = null;
	/* Column Info */
	private String qty30 = null;
	/* Column Info */
	private String qty19 = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String qty17 = null;
	/* Column Info */
	private String qty18 = null;
	/* Column Info */
	private String qty15 = null;
	/* Column Info */
	private String qty16 = null;
	/* Column Info */
	private String qty13 = null;
	/* Column Info */
	private String qty14 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String ydNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lvl0 = null;
	/* Column Info */
	private String division = null;
	/* Column Info */
	private String qty1 = null;
	/* Column Info */
	private String qty3 = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String leaseTerm = null;
	/* Column Info */
	private String qty2 = null;
	/* Column Info */
	private String qty5 = null;
	/* Column Info */
	private String qty4 = null;
	/* Column Info */
	private String qty20 = null;
	/* Column Info */
	private String qty21 = null;
	/* Column Info */
	private String qty22 = null;
	/* Column Info */
	private String qty23 = null;
	/* Column Info */
	private String qty8 = null;
	/* Column Info */
	private String qty9 = null;
	/* Column Info */
	private String qty6 = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String qty7 = null;
	/* Column Info */
	private String qty28 = null;
	/* Column Info */
	private String qty29 = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String qty24 = null;
	/* Column Info */
	private String qty25 = null;
	/* Column Info */
	private String qty26 = null;
	/* Column Info */
	private String qty27 = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String level = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String period = null;	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String locTypeCode = null;	
	//2011.03.29 추가 [CHM-201109765-01]
	/* Column Info */
	private String etdDt = null;	
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String tpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntrTpCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvtSmryVO() {}
	/*	InvtSmryVO */
	public InvtSmryVO(String level,String ibflag, String pagerows, String division, String leaseTerm, 
					  String totalCnt, String rccCd, String lccCd, String eccCd, String sccCd, 
					  String locCd, String ydNm, String crntYdCd, String lvl, String lvl0, String qty1, 
					  String qty2, String qty3, String qty4, String qty5, String qty6, String qty7, 
					  String qty8, String qty9, String qty10, String qty11, String qty12, 
					  String qty13, String qty14, String qty15, String qty16, String qty17, 
					  String qty18, String qty19, String qty20, String qty21, String qty22, 
					  String qty23, String qty24, String qty25, String qty26, String qty27, 
					  String qty28, String qty29, String qty30, String vvd, String lstmCd, 
					  String pol, String pod, String period, String ofcCd, String locTypeCode, String etdDt, String etaDt, String tpCd, String updUsrId, String cntrTpCd) {
		this.level = level;
		this.qty11 = qty11;
		this.qty12 = qty12;
		this.qty10 = qty10;
		this.qty30 = qty30;
		this.qty19 = qty19;
		this.crntYdCd = crntYdCd;
		this.qty17 = qty17;
		this.qty18 = qty18;
		this.qty15 = qty15;
		this.qty16 = qty16;
		this.qty13 = qty13;
		this.qty14 = qty14;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.ydNm = ydNm;
		this.ibflag = ibflag;
		this.lvl0 = lvl0;
		this.division = division;
		this.qty1 = qty1;
		this.qty3 = qty3;
		this.totalCnt = totalCnt;
		this.leaseTerm = leaseTerm;
		this.qty2 = qty2;
		this.qty5 = qty5;
		this.qty4 = qty4;
		this.qty20 = qty20;
		this.qty21 = qty21;
		this.qty22 = qty22;
		this.qty23 = qty23;
		this.qty8 = qty8;
		this.qty9 = qty9;
		this.qty6 = qty6;
		this.eccCd = eccCd;
		this.qty7 = qty7;
		this.qty28 = qty28;
		this.qty29 = qty29;
		this.rccCd = rccCd;
		this.qty24 = qty24;
		this.qty25 = qty25;
		this.qty26 = qty26;
		this.qty27 = qty27;
		this.lccCd = lccCd;
		this.lvl = lvl;
		this.sccCd = sccCd;
		this.vvd = vvd;
		this.lstmCd = lstmCd;
		this.pol = pol;
		this.pod = pod;
		this.period = period;
		this.ofcCd = ofcCd;
		this.locTypeCode = locTypeCode;
		this.etdDt = etdDt;
		this.etaDt = etaDt;
		this.tpCd = tpCd;
		this.updUsrId = updUsrId;
		this.cntrTpCd = cntrTpCd;
}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("qty11", getQty11());
		this.hashColumns.put("qty12", getQty12());
		this.hashColumns.put("qty10", getQty10());
		this.hashColumns.put("qty30", getQty30());
		this.hashColumns.put("qty19", getQty19());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("qty17", getQty17());
		this.hashColumns.put("qty18", getQty18());
		this.hashColumns.put("qty15", getQty15());
		this.hashColumns.put("qty16", getQty16());
		this.hashColumns.put("qty13", getQty13());
		this.hashColumns.put("qty14", getQty14());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lvl0", getLvl0());
		this.hashColumns.put("division", getDivision());
		this.hashColumns.put("qty1", getQty1());
		this.hashColumns.put("qty3", getQty3());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("lease_term", getLeaseTerm());
		this.hashColumns.put("qty2", getQty2());
		this.hashColumns.put("qty5", getQty5());
		this.hashColumns.put("qty4", getQty4());
		this.hashColumns.put("qty20", getQty20());
		this.hashColumns.put("qty21", getQty21());
		this.hashColumns.put("qty22", getQty22());
		this.hashColumns.put("qty23", getQty23());
		this.hashColumns.put("qty8", getQty8());
		this.hashColumns.put("qty9", getQty9());
		this.hashColumns.put("qty6", getQty6());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("qty7", getQty7());
		this.hashColumns.put("qty28", getQty28());
		this.hashColumns.put("qty29", getQty29());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("qty24", getQty24());
		this.hashColumns.put("qty25", getQty25());
		this.hashColumns.put("qty26", getQty26());
		this.hashColumns.put("qty27", getQty27());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("level", getLevel());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("lstm_cd", getLstmCd());

		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("loc_type_code", getLocTypeCode());
		
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("tp_cd", getTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("qty11", "qty11");
		this.hashFields.put("qty12", "qty12");
		this.hashFields.put("qty10", "qty10");
		this.hashFields.put("qty30", "qty30");
		this.hashFields.put("qty19", "qty19");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("qty17", "qty17");
		this.hashFields.put("qty18", "qty18");
		this.hashFields.put("qty15", "qty15");
		this.hashFields.put("qty16", "qty16");
		this.hashFields.put("qty13", "qty13");
		this.hashFields.put("qty14", "qty14");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lvl0", "lvl0");
		this.hashFields.put("division", "division");
		this.hashFields.put("qty1", "qty1");
		this.hashFields.put("qty3", "qty3");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("lease_term", "leaseTerm");
		this.hashFields.put("qty2", "qty2");
		this.hashFields.put("qty5", "qty5");
		this.hashFields.put("qty4", "qty4");
		this.hashFields.put("qty20", "qty20");
		this.hashFields.put("qty21", "qty21");
		this.hashFields.put("qty22", "qty22");
		this.hashFields.put("qty23", "qty23");
		this.hashFields.put("qty8", "qty8");
		this.hashFields.put("qty9", "qty9");
		this.hashFields.put("qty6", "qty6");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("qty7", "qty7");
		this.hashFields.put("qty28", "qty28");
		this.hashFields.put("qty29", "qty29");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("qty24", "qty24");
		this.hashFields.put("qty25", "qty25");
		this.hashFields.put("qty26", "qty26");
		this.hashFields.put("qty27", "qty27");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("level", "level");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("period", "period");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("loc_type_code", "locTypeCode");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return level
	 */
	public String getLevel() {
		return this.level;
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
	 * @return qty10
	 */
	public String getQty10() {
		return this.qty10;
	}
	
	/**
	 * Column Info
	 * @return qty30
	 */
	public String getQty30() {
		return this.qty30;
	}
	
	/**
	 * Column Info
	 * @return qty19
	 */
	public String getQty19() {
		return this.qty19;
	}
	
	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return qty17
	 */
	public String getQty17() {
		return this.qty17;
	}
	
	/**
	 * Column Info
	 * @return qty18
	 */
	public String getQty18() {
		return this.qty18;
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
	 * @return qty16
	 */
	public String getQty16() {
		return this.qty16;
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
	 * @return qty14
	 */
	public String getQty14() {
		return this.qty14;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
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
	 * @return lvl0
	 */
	public String getLvl0() {
		return this.lvl0;
	}
	
	/**
	 * Column Info
	 * @return division
	 */
	public String getDivision() {
		return this.division;
	}
	
	/**
	 * Column Info
	 * @return qty1
	 */
	public String getQty1() {
		return this.qty1;
	}
	
	/**
	 * Column Info
	 * @return qty3
	 */
	public String getQty3() {
		return this.qty3;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}
	
	/**
	 * Column Info
	 * @return leaseTerm
	 */
	public String getLeaseTerm() {
		return this.leaseTerm;
	}
	
	/**
	 * Column Info
	 * @return qty2
	 */
	public String getQty2() {
		return this.qty2;
	}
	
	/**
	 * Column Info
	 * @return qty5
	 */
	public String getQty5() {
		return this.qty5;
	}
	
	/**
	 * Column Info
	 * @return qty4
	 */
	public String getQty4() {
		return this.qty4;
	}
	
	/**
	 * Column Info
	 * @return qty20
	 */
	public String getQty20() {
		return this.qty20;
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
	 * @return qty8
	 */
	public String getQty8() {
		return this.qty8;
	}
	
	/**
	 * Column Info
	 * @return qty9
	 */
	public String getQty9() {
		return this.qty9;
	}
	
	/**
	 * Column Info
	 * @return qty6
	 */
	public String getQty6() {
		return this.qty6;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}
	
	/**
	 * Column Info
	 * @return qty7
	 */
	public String getQty7() {
		return this.qty7;
	}
	
	/**
	 * Column Info
	 * @return qty28
	 */
	public String getQty28() {
		return this.qty28;
	}
	
	/**
	 * Column Info
	 * @return qty29
	 */
	public String getQty29() {
		return this.qty29;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
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
	 * @return qty25
	 */
	public String getQty25() {
		return this.qty25;
	}
	
	/**
	 * Column Info
	 * @return qty26
	 */
	public String getQty26() {
		return this.qty26;
	}
	
	/**
	 * Column Info
	 * @return qty27
	 */
	public String getQty27() {
		return this.qty27;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Column Info
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
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
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}	

	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}	
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
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
	 * @return locTypeCode
	 */
	public String getLocTypeCode() {
		return this.locTypeCode;
	}		
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return etdDt;
	}

	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return etaDt;
	}
	
	/**
	 * Column Info
	 * @return tpCd
	 */
	public String getTpCd() {
		return tpCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}	
	
	/**
	 * Column Info
	 * @return cntrTpCd
	 */
	public String getCntrTpCd() {
		return cntrTpCd;
	}	

	/**
	 * Column Info
	 * @param level
	 */
	public void setLevel(String level) {
		this.level = level;
		//this.level=true;
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
	 * @param qty10
	 */
	public void setQty10(String qty10) {
		this.qty10 = qty10;
	}
	
	/**
	 * Column Info
	 * @param qty30
	 */
	public void setQty30(String qty30) {
		this.qty30 = qty30;
	}
	
	/**
	 * Column Info
	 * @param qty19
	 */
	public void setQty19(String qty19) {
		this.qty19 = qty19;
	}
	
	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param qty17
	 */
	public void setQty17(String qty17) {
		this.qty17 = qty17;
	}
	
	/**
	 * Column Info
	 * @param qty18
	 */
	public void setQty18(String qty18) {
		this.qty18 = qty18;
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
	 * @param qty16
	 */
	public void setQty16(String qty16) {
		this.qty16 = qty16;
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
	 * @param qty14
	 */
	public void setQty14(String qty14) {
		this.qty14 = qty14;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
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
	 * @param lvl0
	 */
	public void setLvl0(String lvl0) {
		this.lvl0 = lvl0;
	}
	
	/**
	 * Column Info
	 * @param division
	 */
	public void setDivision(String division) {
		this.division = division;
	}
	
	/**
	 * Column Info
	 * @param qty1
	 */
	public void setQty1(String qty1) {
		this.qty1 = qty1;
	}
	
	/**
	 * Column Info
	 * @param qty3
	 */
	public void setQty3(String qty3) {
		this.qty3 = qty3;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Column Info
	 * @param leaseTerm
	 */
	public void setLeaseTerm(String leaseTerm) {
		this.leaseTerm = leaseTerm;
	}
	
	/**
	 * Column Info
	 * @param qty2
	 */
	public void setQty2(String qty2) {
		this.qty2 = qty2;
	}
	
	/**
	 * Column Info
	 * @param qty5
	 */
	public void setQty5(String qty5) {
		this.qty5 = qty5;
	}
	
	/**
	 * Column Info
	 * @param qty4
	 */
	public void setQty4(String qty4) {
		this.qty4 = qty4;
	}
	
	/**
	 * Column Info
	 * @param qty20
	 */
	public void setQty20(String qty20) {
		this.qty20 = qty20;
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
	 * @param qty8
	 */
	public void setQty8(String qty8) {
		this.qty8 = qty8;
	}
	
	/**
	 * Column Info
	 * @param qty9
	 */
	public void setQty9(String qty9) {
		this.qty9 = qty9;
	}
	
	/**
	 * Column Info
	 * @param qty6
	 */
	public void setQty6(String qty6) {
		this.qty6 = qty6;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	
	/**
	 * Column Info
	 * @param qty7
	 */
	public void setQty7(String qty7) {
		this.qty7 = qty7;
	}
	
	/**
	 * Column Info
	 * @param qty28
	 */
	public void setQty28(String qty28) {
		this.qty28 = qty28;
	}
	
	/**
	 * Column Info
	 * @param qty29
	 */
	public void setQty29(String qty29) {
		this.qty29 = qty29;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
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
	 * @param qty25
	 */
	public void setQty25(String qty25) {
		this.qty25 = qty25;
	}
	
	/**
	 * Column Info
	 * @param qty26
	 */
	public void setQty26(String qty26) {
		this.qty26 = qty26;
	}
	
	/**
	 * Column Info
	 * @param qty27
	 */
	public void setQty27(String qty27) {
		this.qty27 = qty27;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Column Info
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}

	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
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
	 * @param locTypeCode
	 */
	public void setLocTypeCode(String locTypeCode) {
		this.locTypeCode = locTypeCode;
	}		
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	/**
	 * Column Info
	 * @return etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	/**
	 * Column Info
	 * @return tpCd
	 */
	public void setTpCd(String tpCd) {
		this.tpCd = tpCd;
	}
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}	
	/**
	 * Column Info
	 * @return cntrTpCd
	 */
	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
	}	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLevel(JSPUtil.getParameter(request, "level", ""));
		setQty11(JSPUtil.getParameter(request, "qty11", ""));
		setQty12(JSPUtil.getParameter(request, "qty12", ""));
		setQty10(JSPUtil.getParameter(request, "qty10", ""));
		setQty30(JSPUtil.getParameter(request, "qty30", ""));
		setQty19(JSPUtil.getParameter(request, "qty19", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setQty17(JSPUtil.getParameter(request, "qty17", ""));
		setQty18(JSPUtil.getParameter(request, "qty18", ""));
		setQty15(JSPUtil.getParameter(request, "qty15", ""));
		setQty16(JSPUtil.getParameter(request, "qty16", ""));
		setQty13(JSPUtil.getParameter(request, "qty13", ""));
		setQty14(JSPUtil.getParameter(request, "qty14", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setYdNm(JSPUtil.getParameter(request, "yd_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLvl0(JSPUtil.getParameter(request, "lvl0", ""));
		setDivision(JSPUtil.getParameter(request, "division", ""));
		setQty1(JSPUtil.getParameter(request, "qty1", ""));
		setQty3(JSPUtil.getParameter(request, "qty3", ""));
		setTotalCnt(JSPUtil.getParameter(request, "total_cnt", ""));
		setLeaseTerm(JSPUtil.getParameter(request, "lease_term", ""));
		setQty2(JSPUtil.getParameter(request, "qty2", ""));
		setQty5(JSPUtil.getParameter(request, "qty5", ""));
		setQty4(JSPUtil.getParameter(request, "qty4", ""));
		setQty20(JSPUtil.getParameter(request, "qty20", ""));
		setQty21(JSPUtil.getParameter(request, "qty21", ""));
		setQty22(JSPUtil.getParameter(request, "qty22", ""));
		setQty23(JSPUtil.getParameter(request, "qty23", ""));
		setQty8(JSPUtil.getParameter(request, "qty8", ""));
		setQty9(JSPUtil.getParameter(request, "qty9", ""));
		setQty6(JSPUtil.getParameter(request, "qty6", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setQty7(JSPUtil.getParameter(request, "qty7", ""));
		setQty28(JSPUtil.getParameter(request, "qty28", ""));
		setQty29(JSPUtil.getParameter(request, "qty29", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
		setQty24(JSPUtil.getParameter(request, "qty24", ""));
		setQty25(JSPUtil.getParameter(request, "qty25", ""));
		setQty26(JSPUtil.getParameter(request, "qty26", ""));
		setQty27(JSPUtil.getParameter(request, "qty27", ""));
		setLccCd(JSPUtil.getParameter(request, "lcc_cd", ""));
		setLvl(JSPUtil.getParameter(request, "lvl", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setPol(JSPUtil.getParameter(request, "pod", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setLocTypeCode(JSPUtil.getParameter(request, "loc_type_code", ""));
		setPod(JSPUtil.getParameter(request, "pol", ""));
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setEtdDt(JSPUtil.getParameter(request, "etdDt", ""));
		setEtaDt(JSPUtil.getParameter(request, "etaDtt", ""));
		setTpCd(JSPUtil.getParameter(request, "tpCd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "updUsrId", ""));
		setCntrTpCd(JSPUtil.getParameter(request, "cntrTpCd", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvtSmryVO[]
	 */
	public InvtSmryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvtSmryVO[]
	 */
	public InvtSmryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvtSmryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] level = (JSPUtil.getParameter(request, prefix	+ "level".trim(), length));
			String[] qty11 = (JSPUtil.getParameter(request, prefix	+ "qty11".trim(), length));
			String[] qty12 = (JSPUtil.getParameter(request, prefix	+ "qty12".trim(), length));
			String[] qty10 = (JSPUtil.getParameter(request, prefix	+ "qty10".trim(), length));
			String[] qty30 = (JSPUtil.getParameter(request, prefix	+ "qty30".trim(), length));
			String[] qty19 = (JSPUtil.getParameter(request, prefix	+ "qty19".trim(), length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd".trim(), length));
			String[] qty17 = (JSPUtil.getParameter(request, prefix	+ "qty17".trim(), length));
			String[] qty18 = (JSPUtil.getParameter(request, prefix	+ "qty18".trim(), length));
			String[] qty15 = (JSPUtil.getParameter(request, prefix	+ "qty15".trim(), length));
			String[] qty16 = (JSPUtil.getParameter(request, prefix	+ "qty16".trim(), length));
			String[] qty13 = (JSPUtil.getParameter(request, prefix	+ "qty13".trim(), length));
			String[] qty14 = (JSPUtil.getParameter(request, prefix	+ "qty14".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] lvl0 = (JSPUtil.getParameter(request, prefix	+ "lvl0".trim(), length));
			String[] division = (JSPUtil.getParameter(request, prefix	+ "division".trim(), length));
			String[] qty1 = (JSPUtil.getParameter(request, prefix	+ "qty1".trim(), length));
			String[] qty3 = (JSPUtil.getParameter(request, prefix	+ "qty3".trim(), length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt".trim(), length));
			String[] leaseTerm = (JSPUtil.getParameter(request, prefix	+ "lease_term".trim(), length));
			String[] qty2 = (JSPUtil.getParameter(request, prefix	+ "qty2".trim(), length));
			String[] qty5 = (JSPUtil.getParameter(request, prefix	+ "qty5".trim(), length));
			String[] qty4 = (JSPUtil.getParameter(request, prefix	+ "qty4".trim(), length));
			String[] qty20 = (JSPUtil.getParameter(request, prefix	+ "qty20".trim(), length));
			String[] qty21 = (JSPUtil.getParameter(request, prefix	+ "qty21".trim(), length));
			String[] qty22 = (JSPUtil.getParameter(request, prefix	+ "qty22".trim(), length));
			String[] qty23 = (JSPUtil.getParameter(request, prefix	+ "qty23".trim(), length));
			String[] qty8 = (JSPUtil.getParameter(request, prefix	+ "qty8".trim(), length));
			String[] qty9 = (JSPUtil.getParameter(request, prefix	+ "qty9".trim(), length));
			String[] qty6 = (JSPUtil.getParameter(request, prefix	+ "qty6".trim(), length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd".trim(), length));
			String[] qty7 = (JSPUtil.getParameter(request, prefix	+ "qty7".trim(), length));
			String[] qty28 = (JSPUtil.getParameter(request, prefix	+ "qty28".trim(), length));
			String[] qty29 = (JSPUtil.getParameter(request, prefix	+ "qty29".trim(), length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd".trim(), length));
			String[] qty24 = (JSPUtil.getParameter(request, prefix	+ "qty24".trim(), length));
			String[] qty25 = (JSPUtil.getParameter(request, prefix	+ "qty25".trim(), length));
			String[] qty26 = (JSPUtil.getParameter(request, prefix	+ "qty26".trim(), length));
			String[] qty27 = (JSPUtil.getParameter(request, prefix	+ "qty27".trim(), length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd".trim(), length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl".trim(), length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd".trim(), length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol".trim(), length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod".trim(), length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] locTypeCode = (JSPUtil.getParameter(request, prefix	+ "loc_type_code".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new InvtSmryVO();
				if (level[i] != null)
					model.setLevel(level[i]);
				if (qty11[i] != null)
					model.setQty11(qty11[i]);
				if (qty12[i] != null)
					model.setQty12(qty12[i]);
				if (qty10[i] != null)
					model.setQty10(qty10[i]);
				if (qty30[i] != null)
					model.setQty30(qty30[i]);
				if (qty19[i] != null)
					model.setQty19(qty19[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (qty17[i] != null)
					model.setQty17(qty17[i]);
				if (qty18[i] != null)
					model.setQty18(qty18[i]);
				if (qty15[i] != null)
					model.setQty15(qty15[i]);
				if (qty16[i] != null)
					model.setQty16(qty16[i]);
				if (qty13[i] != null)
					model.setQty13(qty13[i]);
				if (qty14[i] != null)
					model.setQty14(qty14[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lvl0[i] != null)
					model.setLvl0(lvl0[i]);
				if (division[i] != null)
					model.setDivision(division[i]);
				if (qty1[i] != null)
					model.setQty1(qty1[i]);
				if (qty3[i] != null)
					model.setQty3(qty3[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (leaseTerm[i] != null)
					model.setLeaseTerm(leaseTerm[i]);
				if (qty2[i] != null)
					model.setQty2(qty2[i]);
				if (qty5[i] != null)
					model.setQty5(qty5[i]);
				if (qty4[i] != null)
					model.setQty4(qty4[i]);
				if (qty20[i] != null)
					model.setQty20(qty20[i]);
				if (qty21[i] != null)
					model.setQty21(qty21[i]);
				if (qty22[i] != null)
					model.setQty22(qty22[i]);
				if (qty23[i] != null)
					model.setQty23(qty23[i]);
				if (qty8[i] != null)
					model.setQty8(qty8[i]);
				if (qty9[i] != null)
					model.setQty9(qty9[i]);
				if (qty6[i] != null)
					model.setQty6(qty6[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (qty7[i] != null)
					model.setQty7(qty7[i]);
				if (qty28[i] != null)
					model.setQty28(qty28[i]);
				if (qty29[i] != null)
					model.setQty29(qty29[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (qty24[i] != null)
					model.setQty24(qty24[i]);
				if (qty25[i] != null)
					model.setQty25(qty25[i]);
				if (qty26[i] != null)
					model.setQty26(qty26[i]);
				if (qty27[i] != null)
					model.setQty27(qty27[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (locTypeCode[i] != null)
					model.setLocTypeCode(locTypeCode[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvtSmryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvtSmryVO[]
	 */
	public InvtSmryVO[] getInvtSmryVOs(){
		InvtSmryVO[] vos = (InvtSmryVO[])models.toArray(new InvtSmryVO[models.size()]);
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
		this.qty11 = this.qty11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty12 = this.qty12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty10 = this.qty10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty30 = this.qty30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty19 = this.qty19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty17 = this.qty17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty18 = this.qty18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty15 = this.qty15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty16 = this.qty16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty13 = this.qty13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty14 = this.qty14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl0 = this.lvl0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.division = this.division .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty1 = this.qty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty3 = this.qty3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leaseTerm = this.leaseTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty2 = this.qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty5 = this.qty5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty4 = this.qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty20 = this.qty20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty21 = this.qty21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty22 = this.qty22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty23 = this.qty23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty8 = this.qty8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty9 = this.qty9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty6 = this.qty6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty7 = this.qty7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty28 = this.qty28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty29 = this.qty29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty24 = this.qty24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty25 = this.qty25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty26 = this.qty26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty27 = this.qty27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level = this.level .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTypeCode = this.locTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
} 
