/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DisposalPFMCByRCCVO.java
*@FileTitle : DisposalPFMCByRCCVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.07
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.10.07 장준우
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DisposalPFMCByRCCVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<DisposalPFMCByRCCVO> models = new ArrayList<DisposalPFMCByRCCVO>();

	/* Column Info */
	private String level = null;
	/* Column Info */
	private String tpszDp19 = null;
	/* Column Info */
	private String tpszDp18 = null;
	/* Column Info */
	private String tpszDp17 = null;
	/* Column Info */
	private String tpszDp16 = null;
	/* Column Info */
	private String tpszDp15 = null;
	/* Column Info */
	private String tpszDp14 = null;
	/* Column Info */
	private String tpszDp13 = null;
	/* Column Info */
	private String tpszDp12 = null;
	/* Column Info */
	private String pEndEvntDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String pLocTp = null;
	/* Column Info */
	private String tpszDp10 = null;
	/* Column Info */
	private String tpszDp11 = null;
	/* Column Info */
	private String tpszDp06 = null;
	/* Column Info */
	private String tpszDp05 = null;
	/* Column Info */
	private String tpszDp08 = null;
	/* Column Info */
	private String tpszDp07 = null;
	/* Column Info */
	private String tpszDp02 = null;
	/* Column Info */
	private String tpszDp01 = null;
	/* Column Info */
	private String tpszDp04 = null;
	/* Column Info */
	private String tpszDp03 = null;
	/* Column Info */
	private String pStrEvntDt = null;
	/* Column Info */
	private String pDispRsnCd = null;
	/* Column Info */
	private String pDispTpCd = null;
	/* Column Info */
	private String tpszDp09 = null;
	/* Column Info */
	private String dispQtyTot = null;
	/* Column Info */
	private String pEqKndCd = null;
	/* Column Info */
	private String dispQtyCnt = null;
	/* Column Info */
	private String pLocCd = null;
	/* Column Info */
	private String calPartAmtTot = null;
	/* Column Info */
	private String dispQtyRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpszDp30 = null;
	/* Column Info */
	private String tpszDp24 = null;
	/* Column Info */
	private String tpszDp23 = null;
	/* Column Info */
	private String tpszDp26 = null;
	/* Column Info */
	private String tpszDp25 = null;
	/* Column Info */
	private String tpszDp28 = null;
	/* Column Info */
	private String tpszDp27 = null;
	/* Column Info */
	private String tpszDp29 = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String levelNo = null;
	/* Column Info */
	private String pCustCd = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String tpszDp20 = null;
	/* Column Info */
	private String tpszDp21 = null;
	/* Column Info */
	private String tpszDp22 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public DisposalPFMCByRCCVO() {}

	public DisposalPFMCByRCCVO(String ibflag, String pagerows, String level, String pStrEvntDt, String pEndEvntDt, String pEqKndCd, String pLocTp, String pLocCd, String pDispRsnCd, String pDispTpCd, String pCustCd, String levelNo, String locCd, String rccCd, String lccCd, String sccCd, String dispQtyTot, String dispQtyCnt, String dispQtyRto, String calPartAmtTot, String tpszDp01, String tpszDp02, String tpszDp03, String tpszDp04, String tpszDp05, String tpszDp06, String tpszDp07, String tpszDp08, String tpszDp09, String tpszDp10, String tpszDp11, String tpszDp12, String tpszDp13, String tpszDp14, String tpszDp15, String tpszDp16, String tpszDp17, String tpszDp18, String tpszDp19, String tpszDp20, String tpszDp21, String tpszDp22, String tpszDp23, String tpszDp24, String tpszDp25, String tpszDp26, String tpszDp27, String tpszDp28, String tpszDp29, String tpszDp30) {
		this.level = level;
		this.tpszDp19 = tpszDp19;
		this.tpszDp18 = tpszDp18;
		this.tpszDp17 = tpszDp17;
		this.tpszDp16 = tpszDp16;
		this.tpszDp15 = tpszDp15;
		this.tpszDp14 = tpszDp14;
		this.tpszDp13 = tpszDp13;
		this.tpszDp12 = tpszDp12;
		this.pEndEvntDt = pEndEvntDt;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.pLocTp = pLocTp;
		this.tpszDp10 = tpszDp10;
		this.tpszDp11 = tpszDp11;
		this.tpszDp06 = tpszDp06;
		this.tpszDp05 = tpszDp05;
		this.tpszDp08 = tpszDp08;
		this.tpszDp07 = tpszDp07;
		this.tpszDp02 = tpszDp02;
		this.tpszDp01 = tpszDp01;
		this.tpszDp04 = tpszDp04;
		this.tpszDp03 = tpszDp03;
		this.pStrEvntDt = pStrEvntDt;
		this.pDispRsnCd = pDispRsnCd;
		this.pDispTpCd = pDispTpCd;
		this.tpszDp09 = tpszDp09;
		this.dispQtyTot = dispQtyTot;
		this.pEqKndCd = pEqKndCd;
		this.dispQtyCnt = dispQtyCnt;
		this.pLocCd = pLocCd;
		this.calPartAmtTot = calPartAmtTot;
		this.dispQtyRto = dispQtyRto;
		this.ibflag = ibflag;
		this.tpszDp30 = tpszDp30;
		this.tpszDp24 = tpszDp24;
		this.tpszDp23 = tpszDp23;
		this.tpszDp26 = tpszDp26;
		this.tpszDp25 = tpszDp25;
		this.tpszDp28 = tpszDp28;
		this.tpszDp27 = tpszDp27;
		this.tpszDp29 = tpszDp29;
		this.rccCd = rccCd;
		this.levelNo = levelNo;
		this.pCustCd = pCustCd;
		this.lccCd = lccCd;
		this.sccCd = sccCd;
		this.tpszDp20 = tpszDp20;
		this.tpszDp21 = tpszDp21;
		this.tpszDp22 = tpszDp22;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("level", getLevel());
		this.hashColumns.put("tpsz_dp19", getTpszDp19());
		this.hashColumns.put("tpsz_dp18", getTpszDp18());
		this.hashColumns.put("tpsz_dp17", getTpszDp17());
		this.hashColumns.put("tpsz_dp16", getTpszDp16());
		this.hashColumns.put("tpsz_dp15", getTpszDp15());
		this.hashColumns.put("tpsz_dp14", getTpszDp14());
		this.hashColumns.put("tpsz_dp13", getTpszDp13());
		this.hashColumns.put("tpsz_dp12", getTpszDp12());
		this.hashColumns.put("p_end_evnt_dt", getPEndEvntDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("p_loc_tp", getPLocTp());
		this.hashColumns.put("tpsz_dp10", getTpszDp10());
		this.hashColumns.put("tpsz_dp11", getTpszDp11());
		this.hashColumns.put("tpsz_dp06", getTpszDp06());
		this.hashColumns.put("tpsz_dp05", getTpszDp05());
		this.hashColumns.put("tpsz_dp08", getTpszDp08());
		this.hashColumns.put("tpsz_dp07", getTpszDp07());
		this.hashColumns.put("tpsz_dp02", getTpszDp02());
		this.hashColumns.put("tpsz_dp01", getTpszDp01());
		this.hashColumns.put("tpsz_dp04", getTpszDp04());
		this.hashColumns.put("tpsz_dp03", getTpszDp03());
		this.hashColumns.put("p_str_evnt_dt", getPStrEvntDt());
		this.hashColumns.put("p_disp_rsn_cd", getPDispRsnCd());
		this.hashColumns.put("p_disp_tp_cd", getPDispTpCd());
		this.hashColumns.put("tpsz_dp09", getTpszDp09());
		this.hashColumns.put("disp_qty_tot", getDispQtyTot());
		this.hashColumns.put("p_eq_knd_cd", getPEqKndCd());
		this.hashColumns.put("disp_qty_cnt", getDispQtyCnt());
		this.hashColumns.put("p_loc_cd", getPLocCd());
		this.hashColumns.put("cal_part_amt_tot", getCalPartAmtTot());
		this.hashColumns.put("disp_qty_rto", getDispQtyRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsz_dp30", getTpszDp30());
		this.hashColumns.put("tpsz_dp24", getTpszDp24());
		this.hashColumns.put("tpsz_dp23", getTpszDp23());
		this.hashColumns.put("tpsz_dp26", getTpszDp26());
		this.hashColumns.put("tpsz_dp25", getTpszDp25());
		this.hashColumns.put("tpsz_dp28", getTpszDp28());
		this.hashColumns.put("tpsz_dp27", getTpszDp27());
		this.hashColumns.put("tpsz_dp29", getTpszDp29());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("level_no", getLevelNo());
		this.hashColumns.put("p_cust_cd", getPCustCd());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("tpsz_dp20", getTpszDp20());
		this.hashColumns.put("tpsz_dp21", getTpszDp21());
		this.hashColumns.put("tpsz_dp22", getTpszDp22());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("level", "level");
		this.hashFields.put("tpsz_dp19", "tpszDp19");
		this.hashFields.put("tpsz_dp18", "tpszDp18");
		this.hashFields.put("tpsz_dp17", "tpszDp17");
		this.hashFields.put("tpsz_dp16", "tpszDp16");
		this.hashFields.put("tpsz_dp15", "tpszDp15");
		this.hashFields.put("tpsz_dp14", "tpszDp14");
		this.hashFields.put("tpsz_dp13", "tpszDp13");
		this.hashFields.put("tpsz_dp12", "tpszDp12");
		this.hashFields.put("p_end_evnt_dt", "pEndEvntDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("p_loc_tp", "pLocTp");
		this.hashFields.put("tpsz_dp10", "tpszDp10");
		this.hashFields.put("tpsz_dp11", "tpszDp11");
		this.hashFields.put("tpsz_dp06", "tpszDp06");
		this.hashFields.put("tpsz_dp05", "tpszDp05");
		this.hashFields.put("tpsz_dp08", "tpszDp08");
		this.hashFields.put("tpsz_dp07", "tpszDp07");
		this.hashFields.put("tpsz_dp02", "tpszDp02");
		this.hashFields.put("tpsz_dp01", "tpszDp01");
		this.hashFields.put("tpsz_dp04", "tpszDp04");
		this.hashFields.put("tpsz_dp03", "tpszDp03");
		this.hashFields.put("p_str_evnt_dt", "pStrEvntDt");
		this.hashFields.put("p_disp_rsn_cd", "pDispRsnCd");
		this.hashFields.put("p_disp_tp_cd", "pDispTpCd");
		this.hashFields.put("tpsz_dp09", "tpszDp09");
		this.hashFields.put("disp_qty_tot", "dispQtyTot");
		this.hashFields.put("p_eq_knd_cd", "pEqKndCd");
		this.hashFields.put("disp_qty_cnt", "dispQtyCnt");
		this.hashFields.put("p_loc_cd", "pLocCd");
		this.hashFields.put("cal_part_amt_tot", "calPartAmtTot");
		this.hashFields.put("disp_qty_rto", "dispQtyRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsz_dp30", "tpszDp30");
		this.hashFields.put("tpsz_dp24", "tpszDp24");
		this.hashFields.put("tpsz_dp23", "tpszDp23");
		this.hashFields.put("tpsz_dp26", "tpszDp26");
		this.hashFields.put("tpsz_dp25", "tpszDp25");
		this.hashFields.put("tpsz_dp28", "tpszDp28");
		this.hashFields.put("tpsz_dp27", "tpszDp27");
		this.hashFields.put("tpsz_dp29", "tpszDp29");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("level_no", "levelNo");
		this.hashFields.put("p_cust_cd", "pCustCd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("tpsz_dp20", "tpszDp20");
		this.hashFields.put("tpsz_dp21", "tpszDp21");
		this.hashFields.put("tpsz_dp22", "tpszDp22");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return tpszDp19
	 */
	public String getTpszDp19() {
		return this.tpszDp19;
	}

	/**
	 * Column Info
	 * @return tpszDp18
	 */
	public String getTpszDp18() {
		return this.tpszDp18;
	}

	/**
	 * Column Info
	 * @return tpszDp17
	 */
	public String getTpszDp17() {
		return this.tpszDp17;
	}

	/**
	 * Column Info
	 * @return tpszDp16
	 */
	public String getTpszDp16() {
		return this.tpszDp16;
	}

	/**
	 * Column Info
	 * @return tpszDp15
	 */
	public String getTpszDp15() {
		return this.tpszDp15;
	}

	/**
	 * Column Info
	 * @return tpszDp14
	 */
	public String getTpszDp14() {
		return this.tpszDp14;
	}

	/**
	 * Column Info
	 * @return tpszDp13
	 */
	public String getTpszDp13() {
		return this.tpszDp13;
	}

	/**
	 * Column Info
	 * @return tpszDp12
	 */
	public String getTpszDp12() {
		return this.tpszDp12;
	}

	/**
	 * Column Info
	 * @return pEndEvntDt
	 */
	public String getPEndEvntDt() {
		return this.pEndEvntDt;
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
	 * @return pLocTp
	 */
	public String getPLocTp() {
		return this.pLocTp;
	}

	/**
	 * Column Info
	 * @return tpszDp10
	 */
	public String getTpszDp10() {
		return this.tpszDp10;
	}

	/**
	 * Column Info
	 * @return tpszDp11
	 */
	public String getTpszDp11() {
		return this.tpszDp11;
	}

	/**
	 * Column Info
	 * @return tpszDp06
	 */
	public String getTpszDp06() {
		return this.tpszDp06;
	}

	/**
	 * Column Info
	 * @return tpszDp05
	 */
	public String getTpszDp05() {
		return this.tpszDp05;
	}

	/**
	 * Column Info
	 * @return tpszDp08
	 */
	public String getTpszDp08() {
		return this.tpszDp08;
	}

	/**
	 * Column Info
	 * @return tpszDp07
	 */
	public String getTpszDp07() {
		return this.tpszDp07;
	}

	/**
	 * Column Info
	 * @return tpszDp02
	 */
	public String getTpszDp02() {
		return this.tpszDp02;
	}

	/**
	 * Column Info
	 * @return tpszDp01
	 */
	public String getTpszDp01() {
		return this.tpszDp01;
	}

	/**
	 * Column Info
	 * @return tpszDp04
	 */
	public String getTpszDp04() {
		return this.tpszDp04;
	}

	/**
	 * Column Info
	 * @return tpszDp03
	 */
	public String getTpszDp03() {
		return this.tpszDp03;
	}

	/**
	 * Column Info
	 * @return pStrEvntDt
	 */
	public String getPStrEvntDt() {
		return this.pStrEvntDt;
	}

	/**
	 * Column Info
	 * @return pDispRsnCd
	 */
	public String getPDispRsnCd() {
		return this.pDispRsnCd;
	}

	/**
	 * Column Info
	 * @return pDispTpCd
	 */
	public String getPDispTpCd() {
		return this.pDispTpCd;
	}

	/**
	 * Column Info
	 * @return tpszDp09
	 */
	public String getTpszDp09() {
		return this.tpszDp09;
	}

	/**
	 * Column Info
	 * @return dispQtyTot
	 */
	public String getDispQtyTot() {
		return this.dispQtyTot;
	}

	/**
	 * Column Info
	 * @return pEqKndCd
	 */
	public String getPEqKndCd() {
		return this.pEqKndCd;
	}

	/**
	 * Column Info
	 * @return dispQtyCnt
	 */
	public String getDispQtyCnt() {
		return this.dispQtyCnt;
	}

	/**
	 * Column Info
	 * @return pLocCd
	 */
	public String getPLocCd() {
		return this.pLocCd;
	}

	/**
	 * Column Info
	 * @return calPartAmtTot
	 */
	public String getCalPartAmtTot() {
		return this.calPartAmtTot;
	}

	/**
	 * Column Info
	 * @return dispQtyRto
	 */
	public String getDispQtyRto() {
		return this.dispQtyRto;
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
	 * @return tpszDp30
	 */
	public String getTpszDp30() {
		return this.tpszDp30;
	}

	/**
	 * Column Info
	 * @return tpszDp24
	 */
	public String getTpszDp24() {
		return this.tpszDp24;
	}

	/**
	 * Column Info
	 * @return tpszDp23
	 */
	public String getTpszDp23() {
		return this.tpszDp23;
	}

	/**
	 * Column Info
	 * @return tpszDp26
	 */
	public String getTpszDp26() {
		return this.tpszDp26;
	}

	/**
	 * Column Info
	 * @return tpszDp25
	 */
	public String getTpszDp25() {
		return this.tpszDp25;
	}

	/**
	 * Column Info
	 * @return tpszDp28
	 */
	public String getTpszDp28() {
		return this.tpszDp28;
	}

	/**
	 * Column Info
	 * @return tpszDp27
	 */
	public String getTpszDp27() {
		return this.tpszDp27;
	}

	/**
	 * Column Info
	 * @return tpszDp29
	 */
	public String getTpszDp29() {
		return this.tpszDp29;
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
	 * @return levelNo
	 */
	public String getLevelNo() {
		return this.levelNo;
	}

	/**
	 * Column Info
	 * @return pCustCd
	 */
	public String getPCustCd() {
		return this.pCustCd;
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
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}

	/**
	 * Column Info
	 * @return tpszDp20
	 */
	public String getTpszDp20() {
		return this.tpszDp20;
	}

	/**
	 * Column Info
	 * @return tpszDp21
	 */
	public String getTpszDp21() {
		return this.tpszDp21;
	}

	/**
	 * Column Info
	 * @return tpszDp22
	 */
	public String getTpszDp22() {
		return this.tpszDp22;
	}


	/**
	 * Column Info
	 * @param tpszDp19
	 */
	public void setTpszDp19(String tpszDp19) {
		this.tpszDp19 = tpszDp19;
	}

	/**
	 * Column Info
	 * @param tpszDp18
	 */
	public void setTpszDp18(String tpszDp18) {
		this.tpszDp18 = tpszDp18;
	}

	/**
	 * Column Info
	 * @param tpszDp17
	 */
	public void setTpszDp17(String tpszDp17) {
		this.tpszDp17 = tpszDp17;
	}

	/**
	 * Column Info
	 * @param tpszDp16
	 */
	public void setTpszDp16(String tpszDp16) {
		this.tpszDp16 = tpszDp16;
	}

	/**
	 * Column Info
	 * @param tpszDp15
	 */
	public void setTpszDp15(String tpszDp15) {
		this.tpszDp15 = tpszDp15;
	}

	/**
	 * Column Info
	 * @param tpszDp14
	 */
	public void setTpszDp14(String tpszDp14) {
		this.tpszDp14 = tpszDp14;
	}

	/**
	 * Column Info
	 * @param tpszDp13
	 */
	public void setTpszDp13(String tpszDp13) {
		this.tpszDp13 = tpszDp13;
	}

	/**
	 * Column Info
	 * @param tpszDp12
	 */
	public void setTpszDp12(String tpszDp12) {
		this.tpszDp12 = tpszDp12;
	}

	/**
	 * Column Info
	 * @param pEndEvntDt
	 */
	public void setPEndEvntDt(String pEndEvntDt) {
		this.pEndEvntDt = pEndEvntDt;
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
	 * @param pLocTp
	 */
	public void setPLocTp(String pLocTp) {
		this.pLocTp = pLocTp;
	}

	/**
	 * Column Info
	 * @param tpszDp10
	 */
	public void setTpszDp10(String tpszDp10) {
		this.tpszDp10 = tpszDp10;
	}

	/**
	 * Column Info
	 * @param tpszDp11
	 */
	public void setTpszDp11(String tpszDp11) {
		this.tpszDp11 = tpszDp11;
	}

	/**
	 * Column Info
	 * @param tpszDp06
	 */
	public void setTpszDp06(String tpszDp06) {
		this.tpszDp06 = tpszDp06;
	}

	/**
	 * Column Info
	 * @param tpszDp05
	 */
	public void setTpszDp05(String tpszDp05) {
		this.tpszDp05 = tpszDp05;
	}

	/**
	 * Column Info
	 * @param tpszDp08
	 */
	public void setTpszDp08(String tpszDp08) {
		this.tpszDp08 = tpszDp08;
	}

	/**
	 * Column Info
	 * @param tpszDp07
	 */
	public void setTpszDp07(String tpszDp07) {
		this.tpszDp07 = tpszDp07;
	}

	/**
	 * Column Info
	 * @param tpszDp02
	 */
	public void setTpszDp02(String tpszDp02) {
		this.tpszDp02 = tpszDp02;
	}

	/**
	 * Column Info
	 * @param tpszDp01
	 */
	public void setTpszDp01(String tpszDp01) {
		this.tpszDp01 = tpszDp01;
	}

	/**
	 * Column Info
	 * @param tpszDp04
	 */
	public void setTpszDp04(String tpszDp04) {
		this.tpszDp04 = tpszDp04;
	}

	/**
	 * Column Info
	 * @param tpszDp03
	 */
	public void setTpszDp03(String tpszDp03) {
		this.tpszDp03 = tpszDp03;
	}

	/**
	 * Column Info
	 * @param pStrEvntDt
	 */
	public void setPStrEvntDt(String pStrEvntDt) {
		this.pStrEvntDt = pStrEvntDt;
	}

	/**
	 * Column Info
	 * @param pDispRsnCd
	 */
	public void setPDispRsnCd(String pDispRsnCd) {
		this.pDispRsnCd = pDispRsnCd;
	}

	/**
	 * Column Info
	 * @param pDispTpCd
	 */
	public void setPDispTpCd(String pDispTpCd) {
		this.pDispTpCd = pDispTpCd;
	}

	/**
	 * Column Info
	 * @param tpszDp09
	 */
	public void setTpszDp09(String tpszDp09) {
		this.tpszDp09 = tpszDp09;
	}

	/**
	 * Column Info
	 * @param dispQtyTot
	 */
	public void setDispQtyTot(String dispQtyTot) {
		this.dispQtyTot = dispQtyTot;
	}

	/**
	 * Column Info
	 * @param pEqKndCd
	 */
	public void setPEqKndCd(String pEqKndCd) {
		this.pEqKndCd = pEqKndCd;
	}

	/**
	 * Column Info
	 * @param dispQtyCnt
	 */
	public void setDispQtyCnt(String dispQtyCnt) {
		this.dispQtyCnt = dispQtyCnt;
	}

	/**
	 * Column Info
	 * @param pLocCd
	 */
	public void setPLocCd(String pLocCd) {
		this.pLocCd = pLocCd;
	}

	/**
	 * Column Info
	 * @param calPartAmtTot
	 */
	public void setCalPartAmtTot(String calPartAmtTot) {
		this.calPartAmtTot = calPartAmtTot;
	}

	/**
	 * Column Info
	 * @param dispQtyRto
	 */
	public void setDispQtyRto(String dispQtyRto) {
		this.dispQtyRto = dispQtyRto;
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
	 * @param tpszDp30
	 */
	public void setTpszDp30(String tpszDp30) {
		this.tpszDp30 = tpszDp30;
	}

	/**
	 * Column Info
	 * @param tpszDp24
	 */
	public void setTpszDp24(String tpszDp24) {
		this.tpszDp24 = tpszDp24;
	}

	/**
	 * Column Info
	 * @param tpszDp23
	 */
	public void setTpszDp23(String tpszDp23) {
		this.tpszDp23 = tpszDp23;
	}

	/**
	 * Column Info
	 * @param tpszDp26
	 */
	public void setTpszDp26(String tpszDp26) {
		this.tpszDp26 = tpszDp26;
	}

	/**
	 * Column Info
	 * @param tpszDp25
	 */
	public void setTpszDp25(String tpszDp25) {
		this.tpszDp25 = tpszDp25;
	}

	/**
	 * Column Info
	 * @param tpszDp28
	 */
	public void setTpszDp28(String tpszDp28) {
		this.tpszDp28 = tpszDp28;
	}

	/**
	 * Column Info
	 * @param tpszDp27
	 */
	public void setTpszDp27(String tpszDp27) {
		this.tpszDp27 = tpszDp27;
	}

	/**
	 * Column Info
	 * @param tpszDp29
	 */
	public void setTpszDp29(String tpszDp29) {
		this.tpszDp29 = tpszDp29;
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
	 * @param levelNo
	 */
	public void setLevelNo(String levelNo) {
		this.level = levelNo;
		this.levelNo = levelNo;
	}

	/**
	 * Column Info
	 * @param pCustCd
	 */
	public void setPCustCd(String pCustCd) {
		this.pCustCd = pCustCd;
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
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}

	/**
	 * Column Info
	 * @param tpszDp20
	 */
	public void setTpszDp20(String tpszDp20) {
		this.tpszDp20 = tpszDp20;
	}

	/**
	 * Column Info
	 * @param tpszDp21
	 */
	public void setTpszDp21(String tpszDp21) {
		this.tpszDp21 = tpszDp21;
	}

	/**
	 * Column Info
	 * @param tpszDp22
	 */
	public void setTpszDp22(String tpszDp22) {
		this.tpszDp22 = tpszDp22;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return levelNo;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
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
		setLevel(JSPUtil.getParameter(request, prefix + "level", ""));
		setTpszDp19(JSPUtil.getParameter(request, prefix + "tpsz_dp19", ""));
		setTpszDp18(JSPUtil.getParameter(request, prefix + "tpsz_dp18", ""));
		setTpszDp17(JSPUtil.getParameter(request, prefix + "tpsz_dp17", ""));
		setTpszDp16(JSPUtil.getParameter(request, prefix + "tpsz_dp16", ""));
		setTpszDp15(JSPUtil.getParameter(request, prefix + "tpsz_dp15", ""));
		setTpszDp14(JSPUtil.getParameter(request, prefix + "tpsz_dp14", ""));
		setTpszDp13(JSPUtil.getParameter(request, prefix + "tpsz_dp13", ""));
		setTpszDp12(JSPUtil.getParameter(request, prefix + "tpsz_dp12", ""));
		setPEndEvntDt(JSPUtil.getParameter(request, prefix + "p_end_evnt_dt", "").replaceAll("-", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setPLocTp(JSPUtil.getParameter(request, prefix + "p_loc_tp", ""));
		setTpszDp10(JSPUtil.getParameter(request, prefix + "tpsz_dp10", ""));
		setTpszDp11(JSPUtil.getParameter(request, prefix + "tpsz_dp11", ""));
		setTpszDp06(JSPUtil.getParameter(request, prefix + "tpsz_dp06", ""));
		setTpszDp05(JSPUtil.getParameter(request, prefix + "tpsz_dp05", ""));
		setTpszDp08(JSPUtil.getParameter(request, prefix + "tpsz_dp08", ""));
		setTpszDp07(JSPUtil.getParameter(request, prefix + "tpsz_dp07", ""));
		setTpszDp02(JSPUtil.getParameter(request, prefix + "tpsz_dp02", ""));
		setTpszDp01(JSPUtil.getParameter(request, prefix + "tpsz_dp01", ""));
		setTpszDp04(JSPUtil.getParameter(request, prefix + "tpsz_dp04", ""));
		setTpszDp03(JSPUtil.getParameter(request, prefix + "tpsz_dp03", ""));
		setPStrEvntDt(JSPUtil.getParameter(request, prefix + "p_str_evnt_dt", "").replaceAll("-", ""));
		setPDispRsnCd(JSPUtil.getParameter(request, prefix + "p_disp_rsn_cd", ""));
		setPDispTpCd(JSPUtil.getParameter(request, prefix + "p_disp_tp_cd", ""));
		setTpszDp09(JSPUtil.getParameter(request, prefix + "tpsz_dp09", ""));
		setDispQtyTot(JSPUtil.getParameter(request, prefix + "disp_qty_tot", ""));
		setPEqKndCd(JSPUtil.getParameter(request, prefix + "p_eq_knd_cd", ""));
		setDispQtyCnt(JSPUtil.getParameter(request, prefix + "disp_qty_cnt", ""));
		setPLocCd(JSPUtil.getParameter(request, prefix + "p_loc_cd", ""));
		setCalPartAmtTot(JSPUtil.getParameter(request, prefix + "cal_part_amt_tot", ""));
		setDispQtyRto(JSPUtil.getParameter(request, prefix + "disp_qty_rto", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTpszDp30(JSPUtil.getParameter(request, prefix + "tpsz_dp30", ""));
		setTpszDp24(JSPUtil.getParameter(request, prefix + "tpsz_dp24", ""));
		setTpszDp23(JSPUtil.getParameter(request, prefix + "tpsz_dp23", ""));
		setTpszDp26(JSPUtil.getParameter(request, prefix + "tpsz_dp26", ""));
		setTpszDp25(JSPUtil.getParameter(request, prefix + "tpsz_dp25", ""));
		setTpszDp28(JSPUtil.getParameter(request, prefix + "tpsz_dp28", ""));
		setTpszDp27(JSPUtil.getParameter(request, prefix + "tpsz_dp27", ""));
		setTpszDp29(JSPUtil.getParameter(request, prefix + "tpsz_dp29", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setLevelNo(JSPUtil.getParameter(request, prefix + "level_no", ""));
		setPCustCd(JSPUtil.getParameter(request, prefix + "p_cust_cd", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setTpszDp20(JSPUtil.getParameter(request, prefix + "tpsz_dp20", ""));
		setTpszDp21(JSPUtil.getParameter(request, prefix + "tpsz_dp21", ""));
		setTpszDp22(JSPUtil.getParameter(request, prefix + "tpsz_dp22", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalPFMCByRCCVO[]
	 */
	public DisposalPFMCByRCCVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DisposalPFMCByRCCVO[]
	 */
	public DisposalPFMCByRCCVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalPFMCByRCCVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] level = (JSPUtil.getParameter(request, prefix	+ "level", length));
			String[] tpszDp19 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp19", length));
			String[] tpszDp18 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp18", length));
			String[] tpszDp17 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp17", length));
			String[] tpszDp16 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp16", length));
			String[] tpszDp15 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp15", length));
			String[] tpszDp14 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp14", length));
			String[] tpszDp13 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp13", length));
			String[] tpszDp12 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp12", length));
			String[] pEndEvntDt = (JSPUtil.getParameter(request, prefix	+ "p_end_evnt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] pLocTp = (JSPUtil.getParameter(request, prefix	+ "p_loc_tp", length));
			String[] tpszDp10 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp10", length));
			String[] tpszDp11 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp11", length));
			String[] tpszDp06 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp06", length));
			String[] tpszDp05 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp05", length));
			String[] tpszDp08 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp08", length));
			String[] tpszDp07 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp07", length));
			String[] tpszDp02 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp02", length));
			String[] tpszDp01 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp01", length));
			String[] tpszDp04 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp04", length));
			String[] tpszDp03 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp03", length));
			String[] pStrEvntDt = (JSPUtil.getParameter(request, prefix	+ "p_str_evnt_dt", length));
			String[] pDispRsnCd = (JSPUtil.getParameter(request, prefix	+ "p_disp_rsn_cd", length));
			String[] pDispTpCd = (JSPUtil.getParameter(request, prefix	+ "p_disp_tp_cd", length));
			String[] tpszDp09 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp09", length));
			String[] dispQtyTot = (JSPUtil.getParameter(request, prefix	+ "disp_qty_tot", length));
			String[] pEqKndCd = (JSPUtil.getParameter(request, prefix	+ "p_eq_knd_cd", length));
			String[] dispQtyCnt = (JSPUtil.getParameter(request, prefix	+ "disp_qty_cnt", length));
			String[] pLocCd = (JSPUtil.getParameter(request, prefix	+ "p_loc_cd", length));
			String[] calPartAmtTot = (JSPUtil.getParameter(request, prefix	+ "cal_part_amt_tot", length));
			String[] dispQtyRto = (JSPUtil.getParameter(request, prefix	+ "disp_qty_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tpszDp30 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp30", length));
			String[] tpszDp24 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp24", length));
			String[] tpszDp23 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp23", length));
			String[] tpszDp26 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp26", length));
			String[] tpszDp25 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp25", length));
			String[] tpszDp28 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp28", length));
			String[] tpszDp27 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp27", length));
			String[] tpszDp29 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp29", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] levelNo = (JSPUtil.getParameter(request, prefix	+ "level_no", length));
			String[] pCustCd = (JSPUtil.getParameter(request, prefix	+ "p_cust_cd", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] tpszDp20 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp20", length));
			String[] tpszDp21 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp21", length));
			String[] tpszDp22 = (JSPUtil.getParameter(request, prefix	+ "tpsz_dp22", length));

			for (int i = 0; i < length; i++) {
				model = new DisposalPFMCByRCCVO();
				if (level[i] != null)
					model.setLevel(level[i]);
				if (tpszDp19[i] != null)
					model.setTpszDp19(tpszDp19[i]);
				if (tpszDp18[i] != null)
					model.setTpszDp18(tpszDp18[i]);
				if (tpszDp17[i] != null)
					model.setTpszDp17(tpszDp17[i]);
				if (tpszDp16[i] != null)
					model.setTpszDp16(tpszDp16[i]);
				if (tpszDp15[i] != null)
					model.setTpszDp15(tpszDp15[i]);
				if (tpszDp14[i] != null)
					model.setTpszDp14(tpszDp14[i]);
				if (tpszDp13[i] != null)
					model.setTpszDp13(tpszDp13[i]);
				if (tpszDp12[i] != null)
					model.setTpszDp12(tpszDp12[i]);
				if (pEndEvntDt[i] != null)
					model.setPEndEvntDt(pEndEvntDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (pLocTp[i] != null)
					model.setPLocTp(pLocTp[i]);
				if (tpszDp10[i] != null)
					model.setTpszDp10(tpszDp10[i]);
				if (tpszDp11[i] != null)
					model.setTpszDp11(tpszDp11[i]);
				if (tpszDp06[i] != null)
					model.setTpszDp06(tpszDp06[i]);
				if (tpszDp05[i] != null)
					model.setTpszDp05(tpszDp05[i]);
				if (tpszDp08[i] != null)
					model.setTpszDp08(tpszDp08[i]);
				if (tpszDp07[i] != null)
					model.setTpszDp07(tpszDp07[i]);
				if (tpszDp02[i] != null)
					model.setTpszDp02(tpszDp02[i]);
				if (tpszDp01[i] != null)
					model.setTpszDp01(tpszDp01[i]);
				if (tpszDp04[i] != null)
					model.setTpszDp04(tpszDp04[i]);
				if (tpszDp03[i] != null)
					model.setTpszDp03(tpszDp03[i]);
				if (pStrEvntDt[i] != null)
					model.setPStrEvntDt(pStrEvntDt[i]);
				if (pDispRsnCd[i] != null)
					model.setPDispRsnCd(pDispRsnCd[i]);
				if (pDispTpCd[i] != null)
					model.setPDispTpCd(pDispTpCd[i]);
				if (tpszDp09[i] != null)
					model.setTpszDp09(tpszDp09[i]);
				if (dispQtyTot[i] != null)
					model.setDispQtyTot(dispQtyTot[i]);
				if (pEqKndCd[i] != null)
					model.setPEqKndCd(pEqKndCd[i]);
				if (dispQtyCnt[i] != null)
					model.setDispQtyCnt(dispQtyCnt[i]);
				if (pLocCd[i] != null)
					model.setPLocCd(pLocCd[i]);
				if (calPartAmtTot[i] != null)
					model.setCalPartAmtTot(calPartAmtTot[i]);
				if (dispQtyRto[i] != null)
					model.setDispQtyRto(dispQtyRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpszDp30[i] != null)
					model.setTpszDp30(tpszDp30[i]);
				if (tpszDp24[i] != null)
					model.setTpszDp24(tpszDp24[i]);
				if (tpszDp23[i] != null)
					model.setTpszDp23(tpszDp23[i]);
				if (tpszDp26[i] != null)
					model.setTpszDp26(tpszDp26[i]);
				if (tpszDp25[i] != null)
					model.setTpszDp25(tpszDp25[i]);
				if (tpszDp28[i] != null)
					model.setTpszDp28(tpszDp28[i]);
				if (tpszDp27[i] != null)
					model.setTpszDp27(tpszDp27[i]);
				if (tpszDp29[i] != null)
					model.setTpszDp29(tpszDp29[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (levelNo[i] != null)
					model.setLevelNo(levelNo[i]);
				if (pCustCd[i] != null)
					model.setPCustCd(pCustCd[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (tpszDp20[i] != null)
					model.setTpszDp20(tpszDp20[i]);
				if (tpszDp21[i] != null)
					model.setTpszDp21(tpszDp21[i]);
				if (tpszDp22[i] != null)
					model.setTpszDp22(tpszDp22[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDisposalPFMCByRCCVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalPFMCByRCCVO[]
	 */
	public DisposalPFMCByRCCVO[] getDisposalPFMCByRCCVOs(){
		DisposalPFMCByRCCVO[] vos = (DisposalPFMCByRCCVO[])models.toArray(new DisposalPFMCByRCCVO[models.size()]);
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
		this.level = this.level .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp19 = this.tpszDp19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp18 = this.tpszDp18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp17 = this.tpszDp17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp16 = this.tpszDp16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp15 = this.tpszDp15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp14 = this.tpszDp14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp13 = this.tpszDp13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp12 = this.tpszDp12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEndEvntDt = this.pEndEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLocTp = this.pLocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp10 = this.tpszDp10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp11 = this.tpszDp11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp06 = this.tpszDp06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp05 = this.tpszDp05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp08 = this.tpszDp08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp07 = this.tpszDp07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp02 = this.tpszDp02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp01 = this.tpszDp01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp04 = this.tpszDp04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp03 = this.tpszDp03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pStrEvntDt = this.pStrEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDispRsnCd = this.pDispRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDispTpCd = this.pDispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp09 = this.tpszDp09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispQtyTot = this.dispQtyTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEqKndCd = this.pEqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispQtyCnt = this.dispQtyCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLocCd = this.pLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calPartAmtTot = this.calPartAmtTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispQtyRto = this.dispQtyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp30 = this.tpszDp30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp24 = this.tpszDp24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp23 = this.tpszDp23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp26 = this.tpszDp26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp25 = this.tpszDp25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp28 = this.tpszDp28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp27 = this.tpszDp27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp29 = this.tpszDp29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.levelNo = this.levelNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCustCd = this.pCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp20 = this.tpszDp20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp21 = this.tpszDp21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszDp22 = this.tpszDp22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
