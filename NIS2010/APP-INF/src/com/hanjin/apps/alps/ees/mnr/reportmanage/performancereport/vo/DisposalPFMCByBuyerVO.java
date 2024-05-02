/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DisposalPFMCByBuyerVO.java
*@FileTitle : DisposalPFMCByBuyerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.02
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.11.02 장준우
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DisposalPFMCByBuyerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<DisposalPFMCByBuyerVO> models = new ArrayList<DisposalPFMCByBuyerVO>();

	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String pfmcTpszDp19 = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String pfmcTpszDp18 = null;
	/* Column Info */
	private String pfmcTpszDp17 = null;
	/* Column Info */
	private String pfmcTpszDp16 = null;
	/* Column Info */
	private String pEndEvntDt = null;
	/* Column Info */
	private String rsltTpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pOfcCd = null;
	/* Column Info */
	private String pfmcTpszDp25 = null;
	/* Column Info */
	private String pfmcTpszDp26 = null;
	/* Column Info */
	private String pfmcTpszDp00 = null;
	/* Column Info */
	private String pfmcTpszDp23 = null;
	/* Column Info */
	private String pfmcTpszDp24 = null;
	/* Column Info */
	private String pfmcTpszDp21 = null;
	/* Column Info */
	private String pfmcTpszDp03 = null;
	/* Column Info */
	private String pfmcTpszDp22 = null;
	/* Column Info */
	private String pRhqCd = null;
	/* Column Info */
	private String pfmcTpszDp04 = null;
	/* Column Info */
	private String pfmcTpszDp01 = null;
	/* Column Info */
	private String pfmcTpszDp20 = null;
	/* Column Info */
	private String pfmcTpszDp02 = null;
	/* Column Info */
	private String pfmcTpszDp09 = null;
	/* Column Info */
	private String pfmcTpszDp06 = null;
	/* Column Info */
	private String pfmcTpszDp05 = null;
	/* Column Info */
	private String pfmcTpszDp08 = null;
	/* Column Info */
	private String pfmcTpszDp07 = null;
	/* Column Info */
	private String pfmcTpszDp27 = null;
	/* Column Info */
	private String pStrEvntDt = null;
	/* Column Info */
	private String pfmcTpszDp28 = null;
	/* Column Info */
	private String pfmcTpszDp29 = null;
	/* Column Info */
	private String pDispRsnCd = null;
	/* Column Info */
	private String pDispTpCd = null;
	/* Column Info */
	private String rsltTpSeq = null;
	/* Column Info */
	private String pCustCd = null;
	/* Column Info */
	private String pfmcTpszDp30 = null;
	/* Column Info */
	private String ratoTpszDp00 = null;
	/* Column Info */
	private String currCnt = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String pEqKndCd = null;
	/* Column Info */
	private String pfmcTpszDp12 = null;
	/* Column Info */
	private String pfmcTpszDp13 = null;
	/* Column Info */
	private String pfmcTpszDp14 = null;
	/* Column Info */
	private String pfmcTpszDp15 = null;
	/* Column Info */
	private String pfmcTpszDp10 = null;
	/* Column Info */
	private String pfmcTpszDp11 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public DisposalPFMCByBuyerVO() {}

	public DisposalPFMCByBuyerVO(String ibflag, String pagerows, String pStrEvntDt, String pEndEvntDt, String pEqKndCd, String pRhqCd, String pOfcCd, String pDispTpCd, String pDispRsnCd, String pCustCd, String custCd, String custNm, String currCd, String currCnt, String rsltTpSeq, String rsltTpNm, String pfmcTpszDp00, String ratoTpszDp00, String pfmcTpszDp01, String pfmcTpszDp02, String pfmcTpszDp03, String pfmcTpszDp04, String pfmcTpszDp05, String pfmcTpszDp06, String pfmcTpszDp07, String pfmcTpszDp08, String pfmcTpszDp09, String pfmcTpszDp10, String pfmcTpszDp11, String pfmcTpszDp12, String pfmcTpszDp13, String pfmcTpszDp14, String pfmcTpszDp15, String pfmcTpszDp16, String pfmcTpszDp17, String pfmcTpszDp18, String pfmcTpszDp19, String pfmcTpszDp20, String pfmcTpszDp21, String pfmcTpszDp22, String pfmcTpszDp23, String pfmcTpszDp24, String pfmcTpszDp25, String pfmcTpszDp26, String pfmcTpszDp27, String pfmcTpszDp28, String pfmcTpszDp29, String pfmcTpszDp30) {
		this.currCd = currCd;
		this.pfmcTpszDp19 = pfmcTpszDp19;
		this.custNm = custNm;
		this.pfmcTpszDp18 = pfmcTpszDp18;
		this.pfmcTpszDp17 = pfmcTpszDp17;
		this.pfmcTpszDp16 = pfmcTpszDp16;
		this.pEndEvntDt = pEndEvntDt;
		this.rsltTpNm = rsltTpNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.pOfcCd = pOfcCd;
		this.pfmcTpszDp25 = pfmcTpszDp25;
		this.pfmcTpszDp26 = pfmcTpszDp26;
		this.pfmcTpszDp00 = pfmcTpszDp00;
		this.pfmcTpszDp23 = pfmcTpszDp23;
		this.pfmcTpszDp24 = pfmcTpszDp24;
		this.pfmcTpszDp21 = pfmcTpszDp21;
		this.pfmcTpszDp03 = pfmcTpszDp03;
		this.pfmcTpszDp22 = pfmcTpszDp22;
		this.pRhqCd = pRhqCd;
		this.pfmcTpszDp04 = pfmcTpszDp04;
		this.pfmcTpszDp01 = pfmcTpszDp01;
		this.pfmcTpszDp20 = pfmcTpszDp20;
		this.pfmcTpszDp02 = pfmcTpszDp02;
		this.pfmcTpszDp09 = pfmcTpszDp09;
		this.pfmcTpszDp06 = pfmcTpszDp06;
		this.pfmcTpszDp05 = pfmcTpszDp05;
		this.pfmcTpszDp08 = pfmcTpszDp08;
		this.pfmcTpszDp07 = pfmcTpszDp07;
		this.pfmcTpszDp27 = pfmcTpszDp27;
		this.pStrEvntDt = pStrEvntDt;
		this.pfmcTpszDp28 = pfmcTpszDp28;
		this.pfmcTpszDp29 = pfmcTpszDp29;
		this.pDispRsnCd = pDispRsnCd;
		this.pDispTpCd = pDispTpCd;
		this.rsltTpSeq = rsltTpSeq;
		this.pCustCd = pCustCd;
		this.pfmcTpszDp30 = pfmcTpszDp30;
		this.ratoTpszDp00 = ratoTpszDp00;
		this.currCnt = currCnt;
		this.custCd = custCd;
		this.pEqKndCd = pEqKndCd;
		this.pfmcTpszDp12 = pfmcTpszDp12;
		this.pfmcTpszDp13 = pfmcTpszDp13;
		this.pfmcTpszDp14 = pfmcTpszDp14;
		this.pfmcTpszDp15 = pfmcTpszDp15;
		this.pfmcTpszDp10 = pfmcTpszDp10;
		this.pfmcTpszDp11 = pfmcTpszDp11;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pfmc_tpsz_dp19", getPfmcTpszDp19());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("pfmc_tpsz_dp18", getPfmcTpszDp18());
		this.hashColumns.put("pfmc_tpsz_dp17", getPfmcTpszDp17());
		this.hashColumns.put("pfmc_tpsz_dp16", getPfmcTpszDp16());
		this.hashColumns.put("p_end_evnt_dt", getPEndEvntDt());
		this.hashColumns.put("rslt_tp_nm", getRsltTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_ofc_cd", getPOfcCd());
		this.hashColumns.put("pfmc_tpsz_dp25", getPfmcTpszDp25());
		this.hashColumns.put("pfmc_tpsz_dp26", getPfmcTpszDp26());
		this.hashColumns.put("pfmc_tpsz_dp00", getPfmcTpszDp00());
		this.hashColumns.put("pfmc_tpsz_dp23", getPfmcTpszDp23());
		this.hashColumns.put("pfmc_tpsz_dp24", getPfmcTpszDp24());
		this.hashColumns.put("pfmc_tpsz_dp21", getPfmcTpszDp21());
		this.hashColumns.put("pfmc_tpsz_dp03", getPfmcTpszDp03());
		this.hashColumns.put("pfmc_tpsz_dp22", getPfmcTpszDp22());
		this.hashColumns.put("p_rhq_cd", getPRhqCd());
		this.hashColumns.put("pfmc_tpsz_dp04", getPfmcTpszDp04());
		this.hashColumns.put("pfmc_tpsz_dp01", getPfmcTpszDp01());
		this.hashColumns.put("pfmc_tpsz_dp20", getPfmcTpszDp20());
		this.hashColumns.put("pfmc_tpsz_dp02", getPfmcTpszDp02());
		this.hashColumns.put("pfmc_tpsz_dp09", getPfmcTpszDp09());
		this.hashColumns.put("pfmc_tpsz_dp06", getPfmcTpszDp06());
		this.hashColumns.put("pfmc_tpsz_dp05", getPfmcTpszDp05());
		this.hashColumns.put("pfmc_tpsz_dp08", getPfmcTpszDp08());
		this.hashColumns.put("pfmc_tpsz_dp07", getPfmcTpszDp07());
		this.hashColumns.put("pfmc_tpsz_dp27", getPfmcTpszDp27());
		this.hashColumns.put("p_str_evnt_dt", getPStrEvntDt());
		this.hashColumns.put("pfmc_tpsz_dp28", getPfmcTpszDp28());
		this.hashColumns.put("pfmc_tpsz_dp29", getPfmcTpszDp29());
		this.hashColumns.put("p_disp_rsn_cd", getPDispRsnCd());
		this.hashColumns.put("p_disp_tp_cd", getPDispTpCd());
		this.hashColumns.put("rslt_tp_seq", getRsltTpSeq());
		this.hashColumns.put("p_cust_cd", getPCustCd());
		this.hashColumns.put("pfmc_tpsz_dp30", getPfmcTpszDp30());
		this.hashColumns.put("rato_tpsz_dp00", getRatoTpszDp00());
		this.hashColumns.put("curr_cnt", getCurrCnt());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("p_eq_knd_cd", getPEqKndCd());
		this.hashColumns.put("pfmc_tpsz_dp12", getPfmcTpszDp12());
		this.hashColumns.put("pfmc_tpsz_dp13", getPfmcTpszDp13());
		this.hashColumns.put("pfmc_tpsz_dp14", getPfmcTpszDp14());
		this.hashColumns.put("pfmc_tpsz_dp15", getPfmcTpszDp15());
		this.hashColumns.put("pfmc_tpsz_dp10", getPfmcTpszDp10());
		this.hashColumns.put("pfmc_tpsz_dp11", getPfmcTpszDp11());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pfmc_tpsz_dp19", "pfmcTpszDp19");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("pfmc_tpsz_dp18", "pfmcTpszDp18");
		this.hashFields.put("pfmc_tpsz_dp17", "pfmcTpszDp17");
		this.hashFields.put("pfmc_tpsz_dp16", "pfmcTpszDp16");
		this.hashFields.put("p_end_evnt_dt", "pEndEvntDt");
		this.hashFields.put("rslt_tp_nm", "rsltTpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_ofc_cd", "pOfcCd");
		this.hashFields.put("pfmc_tpsz_dp25", "pfmcTpszDp25");
		this.hashFields.put("pfmc_tpsz_dp26", "pfmcTpszDp26");
		this.hashFields.put("pfmc_tpsz_dp00", "pfmcTpszDp00");
		this.hashFields.put("pfmc_tpsz_dp23", "pfmcTpszDp23");
		this.hashFields.put("pfmc_tpsz_dp24", "pfmcTpszDp24");
		this.hashFields.put("pfmc_tpsz_dp21", "pfmcTpszDp21");
		this.hashFields.put("pfmc_tpsz_dp03", "pfmcTpszDp03");
		this.hashFields.put("pfmc_tpsz_dp22", "pfmcTpszDp22");
		this.hashFields.put("p_rhq_cd", "pRhqCd");
		this.hashFields.put("pfmc_tpsz_dp04", "pfmcTpszDp04");
		this.hashFields.put("pfmc_tpsz_dp01", "pfmcTpszDp01");
		this.hashFields.put("pfmc_tpsz_dp20", "pfmcTpszDp20");
		this.hashFields.put("pfmc_tpsz_dp02", "pfmcTpszDp02");
		this.hashFields.put("pfmc_tpsz_dp09", "pfmcTpszDp09");
		this.hashFields.put("pfmc_tpsz_dp06", "pfmcTpszDp06");
		this.hashFields.put("pfmc_tpsz_dp05", "pfmcTpszDp05");
		this.hashFields.put("pfmc_tpsz_dp08", "pfmcTpszDp08");
		this.hashFields.put("pfmc_tpsz_dp07", "pfmcTpszDp07");
		this.hashFields.put("pfmc_tpsz_dp27", "pfmcTpszDp27");
		this.hashFields.put("p_str_evnt_dt", "pStrEvntDt");
		this.hashFields.put("pfmc_tpsz_dp28", "pfmcTpszDp28");
		this.hashFields.put("pfmc_tpsz_dp29", "pfmcTpszDp29");
		this.hashFields.put("p_disp_rsn_cd", "pDispRsnCd");
		this.hashFields.put("p_disp_tp_cd", "pDispTpCd");
		this.hashFields.put("rslt_tp_seq", "rsltTpSeq");
		this.hashFields.put("p_cust_cd", "pCustCd");
		this.hashFields.put("pfmc_tpsz_dp30", "pfmcTpszDp30");
		this.hashFields.put("rato_tpsz_dp00", "ratoTpszDp00");
		this.hashFields.put("curr_cnt", "currCnt");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("p_eq_knd_cd", "pEqKndCd");
		this.hashFields.put("pfmc_tpsz_dp12", "pfmcTpszDp12");
		this.hashFields.put("pfmc_tpsz_dp13", "pfmcTpszDp13");
		this.hashFields.put("pfmc_tpsz_dp14", "pfmcTpszDp14");
		this.hashFields.put("pfmc_tpsz_dp15", "pfmcTpszDp15");
		this.hashFields.put("pfmc_tpsz_dp10", "pfmcTpszDp10");
		this.hashFields.put("pfmc_tpsz_dp11", "pfmcTpszDp11");
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
	 * @return pfmcTpszDp19
	 */
	public String getPfmcTpszDp19() {
		return this.pfmcTpszDp19;
	}

	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp18
	 */
	public String getPfmcTpszDp18() {
		return this.pfmcTpszDp18;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp17
	 */
	public String getPfmcTpszDp17() {
		return this.pfmcTpszDp17;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp16
	 */
	public String getPfmcTpszDp16() {
		return this.pfmcTpszDp16;
	}

	/**
	 * Column Info
	 * @return pEndEvntDt
	 */
	public String getPEndEvntDt() {
		return this.pEndEvntDt;
	}

	/**
	 * Column Info
	 * @return rsltTpNm
	 */
	public String getRsltTpNm() {
		return this.rsltTpNm;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return pOfcCd
	 */
	public String getPOfcCd() {
		return this.pOfcCd;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp25
	 */
	public String getPfmcTpszDp25() {
		return this.pfmcTpszDp25;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp26
	 */
	public String getPfmcTpszDp26() {
		return this.pfmcTpszDp26;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp00
	 */
	public String getPfmcTpszDp00() {
		return this.pfmcTpszDp00;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp23
	 */
	public String getPfmcTpszDp23() {
		return this.pfmcTpszDp23;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp24
	 */
	public String getPfmcTpszDp24() {
		return this.pfmcTpszDp24;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp21
	 */
	public String getPfmcTpszDp21() {
		return this.pfmcTpszDp21;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp03
	 */
	public String getPfmcTpszDp03() {
		return this.pfmcTpszDp03;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp22
	 */
	public String getPfmcTpszDp22() {
		return this.pfmcTpszDp22;
	}

	/**
	 * Column Info
	 * @return pRhqCd
	 */
	public String getPRhqCd() {
		return this.pRhqCd;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp04
	 */
	public String getPfmcTpszDp04() {
		return this.pfmcTpszDp04;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp01
	 */
	public String getPfmcTpszDp01() {
		return this.pfmcTpszDp01;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp20
	 */
	public String getPfmcTpszDp20() {
		return this.pfmcTpszDp20;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp02
	 */
	public String getPfmcTpszDp02() {
		return this.pfmcTpszDp02;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp09
	 */
	public String getPfmcTpszDp09() {
		return this.pfmcTpszDp09;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp06
	 */
	public String getPfmcTpszDp06() {
		return this.pfmcTpszDp06;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp05
	 */
	public String getPfmcTpszDp05() {
		return this.pfmcTpszDp05;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp08
	 */
	public String getPfmcTpszDp08() {
		return this.pfmcTpszDp08;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp07
	 */
	public String getPfmcTpszDp07() {
		return this.pfmcTpszDp07;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp27
	 */
	public String getPfmcTpszDp27() {
		return this.pfmcTpszDp27;
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
	 * @return pfmcTpszDp28
	 */
	public String getPfmcTpszDp28() {
		return this.pfmcTpszDp28;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp29
	 */
	public String getPfmcTpszDp29() {
		return this.pfmcTpszDp29;
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
	 * @return rsltTpSeq
	 */
	public String getRsltTpSeq() {
		return this.rsltTpSeq;
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
	 * @return pfmcTpszDp30
	 */
	public String getPfmcTpszDp30() {
		return this.pfmcTpszDp30;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp00
	 */
	public String getRatoTpszDp00() {
		return this.ratoTpszDp00;
	}

	/**
	 * Column Info
	 * @return currCnt
	 */
	public String getCurrCnt() {
		return this.currCnt;
	}

	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
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
	 * @return pfmcTpszDp12
	 */
	public String getPfmcTpszDp12() {
		return this.pfmcTpszDp12;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp13
	 */
	public String getPfmcTpszDp13() {
		return this.pfmcTpszDp13;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp14
	 */
	public String getPfmcTpszDp14() {
		return this.pfmcTpszDp14;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp15
	 */
	public String getPfmcTpszDp15() {
		return this.pfmcTpszDp15;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp10
	 */
	public String getPfmcTpszDp10() {
		return this.pfmcTpszDp10;
	}

	/**
	 * Column Info
	 * @return pfmcTpszDp11
	 */
	public String getPfmcTpszDp11() {
		return this.pfmcTpszDp11;
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
	 * @param pfmcTpszDp19
	 */
	public void setPfmcTpszDp19(String pfmcTpszDp19) {
		this.pfmcTpszDp19 = pfmcTpszDp19;
	}

	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp18
	 */
	public void setPfmcTpszDp18(String pfmcTpszDp18) {
		this.pfmcTpszDp18 = pfmcTpszDp18;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp17
	 */
	public void setPfmcTpszDp17(String pfmcTpszDp17) {
		this.pfmcTpszDp17 = pfmcTpszDp17;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp16
	 */
	public void setPfmcTpszDp16(String pfmcTpszDp16) {
		this.pfmcTpszDp16 = pfmcTpszDp16;
	}

	/**
	 * Column Info
	 * @param pEndEvntDt
	 */
	public void setPEndEvntDt(String pEndEvntDt) {
		this.pEndEvntDt = pEndEvntDt;
	}

	/**
	 * Column Info
	 * @param rsltTpNm
	 */
	public void setRsltTpNm(String rsltTpNm) {
		this.rsltTpNm = rsltTpNm;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param pOfcCd
	 */
	public void setPOfcCd(String pOfcCd) {
		this.pOfcCd = pOfcCd;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp25
	 */
	public void setPfmcTpszDp25(String pfmcTpszDp25) {
		this.pfmcTpszDp25 = pfmcTpszDp25;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp26
	 */
	public void setPfmcTpszDp26(String pfmcTpszDp26) {
		this.pfmcTpszDp26 = pfmcTpszDp26;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp00
	 */
	public void setPfmcTpszDp00(String pfmcTpszDp00) {
		this.pfmcTpszDp00 = pfmcTpszDp00;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp23
	 */
	public void setPfmcTpszDp23(String pfmcTpszDp23) {
		this.pfmcTpszDp23 = pfmcTpszDp23;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp24
	 */
	public void setPfmcTpszDp24(String pfmcTpszDp24) {
		this.pfmcTpszDp24 = pfmcTpszDp24;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp21
	 */
	public void setPfmcTpszDp21(String pfmcTpszDp21) {
		this.pfmcTpszDp21 = pfmcTpszDp21;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp03
	 */
	public void setPfmcTpszDp03(String pfmcTpszDp03) {
		this.pfmcTpszDp03 = pfmcTpszDp03;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp22
	 */
	public void setPfmcTpszDp22(String pfmcTpszDp22) {
		this.pfmcTpszDp22 = pfmcTpszDp22;
	}

	/**
	 * Column Info
	 * @param pRhqCd
	 */
	public void setPRhqCd(String pRhqCd) {
		this.pRhqCd = pRhqCd;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp04
	 */
	public void setPfmcTpszDp04(String pfmcTpszDp04) {
		this.pfmcTpszDp04 = pfmcTpszDp04;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp01
	 */
	public void setPfmcTpszDp01(String pfmcTpszDp01) {
		this.pfmcTpszDp01 = pfmcTpszDp01;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp20
	 */
	public void setPfmcTpszDp20(String pfmcTpszDp20) {
		this.pfmcTpszDp20 = pfmcTpszDp20;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp02
	 */
	public void setPfmcTpszDp02(String pfmcTpszDp02) {
		this.pfmcTpszDp02 = pfmcTpszDp02;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp09
	 */
	public void setPfmcTpszDp09(String pfmcTpszDp09) {
		this.pfmcTpszDp09 = pfmcTpszDp09;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp06
	 */
	public void setPfmcTpszDp06(String pfmcTpszDp06) {
		this.pfmcTpszDp06 = pfmcTpszDp06;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp05
	 */
	public void setPfmcTpszDp05(String pfmcTpszDp05) {
		this.pfmcTpszDp05 = pfmcTpszDp05;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp08
	 */
	public void setPfmcTpszDp08(String pfmcTpszDp08) {
		this.pfmcTpszDp08 = pfmcTpszDp08;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp07
	 */
	public void setPfmcTpszDp07(String pfmcTpszDp07) {
		this.pfmcTpszDp07 = pfmcTpszDp07;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp27
	 */
	public void setPfmcTpszDp27(String pfmcTpszDp27) {
		this.pfmcTpszDp27 = pfmcTpszDp27;
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
	 * @param pfmcTpszDp28
	 */
	public void setPfmcTpszDp28(String pfmcTpszDp28) {
		this.pfmcTpszDp28 = pfmcTpszDp28;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp29
	 */
	public void setPfmcTpszDp29(String pfmcTpszDp29) {
		this.pfmcTpszDp29 = pfmcTpszDp29;
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
	 * @param rsltTpSeq
	 */
	public void setRsltTpSeq(String rsltTpSeq) {
		this.rsltTpSeq = rsltTpSeq;
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
	 * @param pfmcTpszDp30
	 */
	public void setPfmcTpszDp30(String pfmcTpszDp30) {
		this.pfmcTpszDp30 = pfmcTpszDp30;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp00
	 */
	public void setRatoTpszDp00(String ratoTpszDp00) {
		this.ratoTpszDp00 = ratoTpszDp00;
	}

	/**
	 * Column Info
	 * @param currCnt
	 */
	public void setCurrCnt(String currCnt) {
		this.currCnt = currCnt;
	}

	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
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
	 * @param pfmcTpszDp12
	 */
	public void setPfmcTpszDp12(String pfmcTpszDp12) {
		this.pfmcTpszDp12 = pfmcTpszDp12;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp13
	 */
	public void setPfmcTpszDp13(String pfmcTpszDp13) {
		this.pfmcTpszDp13 = pfmcTpszDp13;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp14
	 */
	public void setPfmcTpszDp14(String pfmcTpszDp14) {
		this.pfmcTpszDp14 = pfmcTpszDp14;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp15
	 */
	public void setPfmcTpszDp15(String pfmcTpszDp15) {
		this.pfmcTpszDp15 = pfmcTpszDp15;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp10
	 */
	public void setPfmcTpszDp10(String pfmcTpszDp10) {
		this.pfmcTpszDp10 = pfmcTpszDp10;
	}

	/**
	 * Column Info
	 * @param pfmcTpszDp11
	 */
	public void setPfmcTpszDp11(String pfmcTpszDp11) {
		this.pfmcTpszDp11 = pfmcTpszDp11;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPfmcTpszDp19(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp19", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setPfmcTpszDp18(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp18", ""));
		setPfmcTpszDp17(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp17", ""));
		setPfmcTpszDp16(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp16", ""));
		setPEndEvntDt(JSPUtil.getParameter(request, prefix + "p_end_evnt_dt", "").replaceAll("-", ""));
		setRsltTpNm(JSPUtil.getParameter(request, prefix + "rslt_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPOfcCd(JSPUtil.getParameter(request, prefix + "p_ofc_cd", ""));
		setPfmcTpszDp25(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp25", ""));
		setPfmcTpszDp26(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp26", ""));
		setPfmcTpszDp00(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp00", ""));
		setPfmcTpszDp23(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp23", ""));
		setPfmcTpszDp24(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp24", ""));
		setPfmcTpszDp21(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp21", ""));
		setPfmcTpszDp03(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp03", ""));
		setPfmcTpszDp22(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp22", ""));
		setPRhqCd(JSPUtil.getParameter(request, prefix + "p_rhq_cd", ""));
		setPfmcTpszDp04(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp04", ""));
		setPfmcTpszDp01(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp01", ""));
		setPfmcTpszDp20(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp20", ""));
		setPfmcTpszDp02(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp02", ""));
		setPfmcTpszDp09(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp09", ""));
		setPfmcTpszDp06(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp06", ""));
		setPfmcTpszDp05(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp05", ""));
		setPfmcTpszDp08(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp08", ""));
		setPfmcTpszDp07(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp07", ""));
		setPfmcTpszDp27(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp27", ""));
		setPStrEvntDt(JSPUtil.getParameter(request, prefix + "p_str_evnt_dt", "").replaceAll("-", ""));
		setPfmcTpszDp28(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp28", ""));
		setPfmcTpszDp29(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp29", ""));
		setPDispRsnCd(JSPUtil.getParameter(request, prefix + "p_disp_rsn_cd", ""));
		setPDispTpCd(JSPUtil.getParameter(request, prefix + "p_disp_tp_cd", ""));
		setRsltTpSeq(JSPUtil.getParameter(request, prefix + "rslt_tp_seq", ""));
		setPCustCd(JSPUtil.getParameter(request, prefix + "p_cust_cd", ""));
		setPfmcTpszDp30(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp30", ""));
		setRatoTpszDp00(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp00", ""));
		setCurrCnt(JSPUtil.getParameter(request, prefix + "curr_cnt", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setPEqKndCd(JSPUtil.getParameter(request, prefix + "p_eq_knd_cd", ""));
		setPfmcTpszDp12(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp12", ""));
		setPfmcTpszDp13(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp13", ""));
		setPfmcTpszDp14(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp14", ""));
		setPfmcTpszDp15(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp15", ""));
		setPfmcTpszDp10(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp10", ""));
		setPfmcTpszDp11(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp11", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalPFMCByBuyerVO[]
	 */
	public DisposalPFMCByBuyerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DisposalPFMCByBuyerVO[]
	 */
	public DisposalPFMCByBuyerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalPFMCByBuyerVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] pfmcTpszDp19 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp19", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] pfmcTpszDp18 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp18", length));
			String[] pfmcTpszDp17 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp17", length));
			String[] pfmcTpszDp16 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp16", length));
			String[] pEndEvntDt = (JSPUtil.getParameter(request, prefix	+ "p_end_evnt_dt", length));
			String[] rsltTpNm = (JSPUtil.getParameter(request, prefix	+ "rslt_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_ofc_cd", length));
			String[] pfmcTpszDp25 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp25", length));
			String[] pfmcTpszDp26 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp26", length));
			String[] pfmcTpszDp00 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp00", length));
			String[] pfmcTpszDp23 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp23", length));
			String[] pfmcTpszDp24 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp24", length));
			String[] pfmcTpszDp21 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp21", length));
			String[] pfmcTpszDp03 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp03", length));
			String[] pfmcTpszDp22 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp22", length));
			String[] pRhqCd = (JSPUtil.getParameter(request, prefix	+ "p_rhq_cd", length));
			String[] pfmcTpszDp04 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp04", length));
			String[] pfmcTpszDp01 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp01", length));
			String[] pfmcTpszDp20 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp20", length));
			String[] pfmcTpszDp02 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp02", length));
			String[] pfmcTpszDp09 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp09", length));
			String[] pfmcTpszDp06 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp06", length));
			String[] pfmcTpszDp05 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp05", length));
			String[] pfmcTpszDp08 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp08", length));
			String[] pfmcTpszDp07 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp07", length));
			String[] pfmcTpszDp27 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp27", length));
			String[] pStrEvntDt = (JSPUtil.getParameter(request, prefix	+ "p_str_evnt_dt", length));
			String[] pfmcTpszDp28 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp28", length));
			String[] pfmcTpszDp29 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp29", length));
			String[] pDispRsnCd = (JSPUtil.getParameter(request, prefix	+ "p_disp_rsn_cd", length));
			String[] pDispTpCd = (JSPUtil.getParameter(request, prefix	+ "p_disp_tp_cd", length));
			String[] rsltTpSeq = (JSPUtil.getParameter(request, prefix	+ "rslt_tp_seq", length));
			String[] pCustCd = (JSPUtil.getParameter(request, prefix	+ "p_cust_cd", length));
			String[] pfmcTpszDp30 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp30", length));
			String[] ratoTpszDp00 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp00", length));
			String[] currCnt = (JSPUtil.getParameter(request, prefix	+ "curr_cnt", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] pEqKndCd = (JSPUtil.getParameter(request, prefix	+ "p_eq_knd_cd", length));
			String[] pfmcTpszDp12 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp12", length));
			String[] pfmcTpszDp13 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp13", length));
			String[] pfmcTpszDp14 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp14", length));
			String[] pfmcTpszDp15 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp15", length));
			String[] pfmcTpszDp10 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp10", length));
			String[] pfmcTpszDp11 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp11", length));

			for (int i = 0; i < length; i++) {
				model = new DisposalPFMCByBuyerVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (pfmcTpszDp19[i] != null)
					model.setPfmcTpszDp19(pfmcTpszDp19[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (pfmcTpszDp18[i] != null)
					model.setPfmcTpszDp18(pfmcTpszDp18[i]);
				if (pfmcTpszDp17[i] != null)
					model.setPfmcTpszDp17(pfmcTpszDp17[i]);
				if (pfmcTpszDp16[i] != null)
					model.setPfmcTpszDp16(pfmcTpszDp16[i]);
				if (pEndEvntDt[i] != null)
					model.setPEndEvntDt(pEndEvntDt[i]);
				if (rsltTpNm[i] != null)
					model.setRsltTpNm(rsltTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pOfcCd[i] != null)
					model.setPOfcCd(pOfcCd[i]);
				if (pfmcTpszDp25[i] != null)
					model.setPfmcTpszDp25(pfmcTpszDp25[i]);
				if (pfmcTpszDp26[i] != null)
					model.setPfmcTpszDp26(pfmcTpszDp26[i]);
				if (pfmcTpszDp00[i] != null)
					model.setPfmcTpszDp00(pfmcTpszDp00[i]);
				if (pfmcTpszDp23[i] != null)
					model.setPfmcTpszDp23(pfmcTpszDp23[i]);
				if (pfmcTpszDp24[i] != null)
					model.setPfmcTpszDp24(pfmcTpszDp24[i]);
				if (pfmcTpszDp21[i] != null)
					model.setPfmcTpszDp21(pfmcTpszDp21[i]);
				if (pfmcTpszDp03[i] != null)
					model.setPfmcTpszDp03(pfmcTpszDp03[i]);
				if (pfmcTpszDp22[i] != null)
					model.setPfmcTpszDp22(pfmcTpszDp22[i]);
				if (pRhqCd[i] != null)
					model.setPRhqCd(pRhqCd[i]);
				if (pfmcTpszDp04[i] != null)
					model.setPfmcTpszDp04(pfmcTpszDp04[i]);
				if (pfmcTpszDp01[i] != null)
					model.setPfmcTpszDp01(pfmcTpszDp01[i]);
				if (pfmcTpszDp20[i] != null)
					model.setPfmcTpszDp20(pfmcTpszDp20[i]);
				if (pfmcTpszDp02[i] != null)
					model.setPfmcTpszDp02(pfmcTpszDp02[i]);
				if (pfmcTpszDp09[i] != null)
					model.setPfmcTpszDp09(pfmcTpszDp09[i]);
				if (pfmcTpszDp06[i] != null)
					model.setPfmcTpszDp06(pfmcTpszDp06[i]);
				if (pfmcTpszDp05[i] != null)
					model.setPfmcTpszDp05(pfmcTpszDp05[i]);
				if (pfmcTpszDp08[i] != null)
					model.setPfmcTpszDp08(pfmcTpszDp08[i]);
				if (pfmcTpszDp07[i] != null)
					model.setPfmcTpszDp07(pfmcTpszDp07[i]);
				if (pfmcTpszDp27[i] != null)
					model.setPfmcTpszDp27(pfmcTpszDp27[i]);
				if (pStrEvntDt[i] != null)
					model.setPStrEvntDt(pStrEvntDt[i]);
				if (pfmcTpszDp28[i] != null)
					model.setPfmcTpszDp28(pfmcTpszDp28[i]);
				if (pfmcTpszDp29[i] != null)
					model.setPfmcTpszDp29(pfmcTpszDp29[i]);
				if (pDispRsnCd[i] != null)
					model.setPDispRsnCd(pDispRsnCd[i]);
				if (pDispTpCd[i] != null)
					model.setPDispTpCd(pDispTpCd[i]);
				if (rsltTpSeq[i] != null)
					model.setRsltTpSeq(rsltTpSeq[i]);
				if (pCustCd[i] != null)
					model.setPCustCd(pCustCd[i]);
				if (pfmcTpszDp30[i] != null)
					model.setPfmcTpszDp30(pfmcTpszDp30[i]);
				if (ratoTpszDp00[i] != null)
					model.setRatoTpszDp00(ratoTpszDp00[i]);
				if (currCnt[i] != null)
					model.setCurrCnt(currCnt[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (pEqKndCd[i] != null)
					model.setPEqKndCd(pEqKndCd[i]);
				if (pfmcTpszDp12[i] != null)
					model.setPfmcTpszDp12(pfmcTpszDp12[i]);
				if (pfmcTpszDp13[i] != null)
					model.setPfmcTpszDp13(pfmcTpszDp13[i]);
				if (pfmcTpszDp14[i] != null)
					model.setPfmcTpszDp14(pfmcTpszDp14[i]);
				if (pfmcTpszDp15[i] != null)
					model.setPfmcTpszDp15(pfmcTpszDp15[i]);
				if (pfmcTpszDp10[i] != null)
					model.setPfmcTpszDp10(pfmcTpszDp10[i]);
				if (pfmcTpszDp11[i] != null)
					model.setPfmcTpszDp11(pfmcTpszDp11[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDisposalPFMCByBuyerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalPFMCByBuyerVO[]
	 */
	public DisposalPFMCByBuyerVO[] getDisposalPFMCByBuyerVOs(){
		DisposalPFMCByBuyerVO[] vos = (DisposalPFMCByBuyerVO[])models.toArray(new DisposalPFMCByBuyerVO[models.size()]);
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
		this.pfmcTpszDp19 = this.pfmcTpszDp19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp18 = this.pfmcTpszDp18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp17 = this.pfmcTpszDp17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp16 = this.pfmcTpszDp16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEndEvntDt = this.pEndEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltTpNm = this.rsltTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pOfcCd = this.pOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp25 = this.pfmcTpszDp25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp26 = this.pfmcTpszDp26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp00 = this.pfmcTpszDp00 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp23 = this.pfmcTpszDp23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp24 = this.pfmcTpszDp24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp21 = this.pfmcTpszDp21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp03 = this.pfmcTpszDp03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp22 = this.pfmcTpszDp22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pRhqCd = this.pRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp04 = this.pfmcTpszDp04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp01 = this.pfmcTpszDp01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp20 = this.pfmcTpszDp20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp02 = this.pfmcTpszDp02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp09 = this.pfmcTpszDp09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp06 = this.pfmcTpszDp06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp05 = this.pfmcTpszDp05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp08 = this.pfmcTpszDp08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp07 = this.pfmcTpszDp07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp27 = this.pfmcTpszDp27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pStrEvntDt = this.pStrEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp28 = this.pfmcTpszDp28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp29 = this.pfmcTpszDp29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDispRsnCd = this.pDispRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDispTpCd = this.pDispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltTpSeq = this.rsltTpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCustCd = this.pCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp30 = this.pfmcTpszDp30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp00 = this.ratoTpszDp00 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCnt = this.currCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEqKndCd = this.pEqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp12 = this.pfmcTpszDp12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp13 = this.pfmcTpszDp13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp14 = this.pfmcTpszDp14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp15 = this.pfmcTpszDp15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp10 = this.pfmcTpszDp10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp11 = this.pfmcTpszDp11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
