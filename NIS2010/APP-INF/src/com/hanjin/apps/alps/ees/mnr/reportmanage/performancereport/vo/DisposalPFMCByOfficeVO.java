/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DisposalPFMCByOfficeVO.java
*@FileTitle : DisposalPFMCByOfficeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.20
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.10.20 장준우
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

public class DisposalPFMCByOfficeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<DisposalPFMCByOfficeVO> models = new ArrayList<DisposalPFMCByOfficeVO>();

	/* Column Info */
	private String qutaTpszDp07 = null;
	/* Column Info */
	private String qutaTpszDp06 = null;
	/* Column Info */
	private String qutaTpszDp05 = null;
	/* Column Info */
	private String qutaTpszDp04 = null;
	/* Column Info */
	private String qutaTpszDp03 = null;
	/* Column Info */
	private String qutaTpszDp02 = null;
	/* Column Info */
	private String qutaTpszDp01 = null;
	/* Column Info */
	private String qutaTpszDp00 = null;
	/* Column Info */
	private String pEndEvntDt = null;
	/* Column Info */
	private String qutaTpszDp09 = null;
	/* Column Info */
	private String qutaTpszDp08 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String qutaTpszDp10 = null;
	/* Column Info */
	private String qutaTpszDp16 = null;
	/* Column Info */
	private String qutaTpszDp15 = null;
	/* Column Info */
	private String qutaTpszDp18 = null;
	/* Column Info */
	private String qutaTpszDp17 = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String qutaTpszDp12 = null;
	/* Column Info */
	private String qutaTpszDp11 = null;
	/* Column Info */
	private String qutaTpszDp14 = null;
	/* Column Info */
	private String qutaTpszDp13 = null;
	/* Column Info */
	private String pfmcTpszDp27 = null;
	/* Column Info */
	private String pfmcTpszDp28 = null;
	/* Column Info */
	private String pfmcTpszDp29 = null;
	/* Column Info */
	private String pDispTpCd = null;
	/* Column Info */
	private String pDispRsnCd = null;
	/* Column Info */
	private String rsltTpSeq = null;
	/* Column Info */
	private String qutaTpszDp19 = null;
	/* Column Info */
	private String pfmcTpszDp30 = null;
	/* Column Info */
	private String qutaTpszDp21 = null;
	/* Column Info */
	private String rsltTpNm = null;
	/* Column Info */
	private String ratoTpszDp09 = null;
	/* Column Info */
	private String ratoTpszDp08 = null;
	/* Column Info */
	private String ratoTpszDp07 = null;
	/* Column Info */
	private String ratoTpszDp12 = null;
	/* Column Info */
	private String ratoTpszDp13 = null;
	/* Column Info */
	private String ratoTpszDp10 = null;
	/* Column Info */
	private String ratoTpszDp11 = null;
	/* Column Info */
	private String ratoTpszDp16 = null;
	/* Column Info */
	private String ratoTpszDp17 = null;
	/* Column Info */
	private String ratoTpszDp14 = null;
	/* Column Info */
	private String ratoTpszDp15 = null;
	/* Column Info */
	private String pfmcTpszDp00 = null;
	/* Column Info */
	private String pfmcTpszDp03 = null;
	/* Column Info */
	private String pfmcTpszDp04 = null;
	/* Column Info */
	private String pRhqCd = null;
	/* Column Info */
	private String pfmcTpszDp01 = null;
	/* Column Info */
	private String pfmcTpszDp02 = null;
	/* Column Info */
	private String pStrEvntDt = null;
	/* Column Info */
	private String ratoTpszDp00 = null;
	/* Column Info */
	private String ratoTpszDp01 = null;
	/* Column Info */
	private String ratoTpszDp02 = null;
	/* Column Info */
	private String ratoTpszDp03 = null;
	/* Column Info */
	private String ratoTpszDp04 = null;
	/* Column Info */
	private String ratoTpszDp05 = null;
	/* Column Info */
	private String ratoTpszDp06 = null;
	/* Column Info */
	private String pEqKndCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String qutaTpszDp30 = null;
	/* Column Info */
	private String pfmcTpszDp19 = null;
	/* Column Info */
	private String pfmcTpszDp18 = null;
	/* Column Info */
	private String pfmcTpszDp17 = null;
	/* Column Info */
	private String pfmcTpszDp16 = null;
	/* Column Info */
	private String ratoTpszDp29 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pOfcCd = null;
	/* Column Info */
	private String ratoTpszDp30 = null;
	/* Column Info */
	private String qutaTpszDp22 = null;
	/* Column Info */
	private String pfmcTpszDp25 = null;
	/* Column Info */
	private String qutaTpszDp23 = null;
	/* Column Info */
	private String pfmcTpszDp26 = null;
	/* Column Info */
	private String pfmcTpszDp23 = null;
	/* Column Info */
	private String qutaTpszDp24 = null;
	/* Column Info */
	private String pfmcTpszDp24 = null;
	/* Column Info */
	private String qutaTpszDp25 = null;
	/* Column Info */
	private String pfmcTpszDp21 = null;
	/* Column Info */
	private String qutaTpszDp26 = null;
	/* Column Info */
	private String pfmcTpszDp22 = null;
	/* Column Info */
	private String qutaTpszDp27 = null;
	/* Column Info */
	private String qutaTpszDp28 = null;
	/* Column Info */
	private String qutaTpszDp29 = null;
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
	private String ratoTpszDp19 = null;
	/* Column Info */
	private String ratoTpszDp18 = null;
	/* Column Info */
	private String pCustCd = null;
	/* Column Info */
	private String ratoTpszDp25 = null;
	/* Column Info */
	private String ratoTpszDp26 = null;
	/* Column Info */
	private String ratoTpszDp27 = null;
	/* Column Info */
	private String ratoTpszDp28 = null;
	/* Column Info */
	private String ratoTpszDp21 = null;
	/* Column Info */
	private String ratoTpszDp22 = null;
	/* Column Info */
	private String ratoTpszDp23 = null;
	/* Column Info */
	private String ratoTpszDp24 = null;
	/* Column Info */
	private String rqstOfcCd = null;
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

	public DisposalPFMCByOfficeVO() {}

	public DisposalPFMCByOfficeVO(String ibflag, String pagerows, String pRhqCd, String pOfcCd, String pDispRsnCd, String pStrEvntDt, String pEndEvntDt, String pEqKndCd, String pDispTpCd, String pCustCd, String rhqCd, String rqstOfcCd, String currCd, String rsltTpSeq, String rsltTpNm, String qutaTpszDp00, String pfmcTpszDp00, String ratoTpszDp00, String qutaTpszDp01, String pfmcTpszDp01, String ratoTpszDp01, String qutaTpszDp02, String pfmcTpszDp02, String ratoTpszDp02, String qutaTpszDp03, String pfmcTpszDp03, String ratoTpszDp03, String qutaTpszDp04, String pfmcTpszDp04, String ratoTpszDp04, String qutaTpszDp05, String pfmcTpszDp05, String ratoTpszDp05, String qutaTpszDp06, String pfmcTpszDp06, String ratoTpszDp06, String qutaTpszDp07, String pfmcTpszDp07, String ratoTpszDp07, String qutaTpszDp08, String pfmcTpszDp08, String ratoTpszDp08, String qutaTpszDp09, String pfmcTpszDp09, String ratoTpszDp09, String qutaTpszDp10, String pfmcTpszDp10, String ratoTpszDp10, String qutaTpszDp11, String pfmcTpszDp11, String ratoTpszDp11, String qutaTpszDp12, String pfmcTpszDp12, String ratoTpszDp12, String qutaTpszDp13, String pfmcTpszDp13, String ratoTpszDp13, String qutaTpszDp14, String pfmcTpszDp14, String ratoTpszDp14, String qutaTpszDp15, String pfmcTpszDp15, String ratoTpszDp15, String qutaTpszDp16, String pfmcTpszDp16, String ratoTpszDp16, String qutaTpszDp17, String pfmcTpszDp17, String ratoTpszDp17, String qutaTpszDp18, String pfmcTpszDp18, String ratoTpszDp18, String qutaTpszDp19, String pfmcTpszDp19, String ratoTpszDp19, String qutaTpszDp21, String pfmcTpszDp21, String ratoTpszDp21, String qutaTpszDp22, String pfmcTpszDp22, String ratoTpszDp22, String qutaTpszDp23, String pfmcTpszDp23, String ratoTpszDp23, String qutaTpszDp24, String pfmcTpszDp24, String ratoTpszDp24, String qutaTpszDp25, String pfmcTpszDp25, String ratoTpszDp25, String qutaTpszDp26, String pfmcTpszDp26, String ratoTpszDp26, String qutaTpszDp27, String pfmcTpszDp27, String ratoTpszDp27, String qutaTpszDp28, String pfmcTpszDp28, String ratoTpszDp28, String qutaTpszDp29, String pfmcTpszDp29, String ratoTpszDp29, String qutaTpszDp30, String pfmcTpszDp30, String ratoTpszDp30) {
		this.qutaTpszDp07 = qutaTpszDp07;
		this.qutaTpszDp06 = qutaTpszDp06;
		this.qutaTpszDp05 = qutaTpszDp05;
		this.qutaTpszDp04 = qutaTpszDp04;
		this.qutaTpszDp03 = qutaTpszDp03;
		this.qutaTpszDp02 = qutaTpszDp02;
		this.qutaTpszDp01 = qutaTpszDp01;
		this.qutaTpszDp00 = qutaTpszDp00;
		this.pEndEvntDt = pEndEvntDt;
		this.qutaTpszDp09 = qutaTpszDp09;
		this.qutaTpszDp08 = qutaTpszDp08;
		this.pagerows = pagerows;
		this.qutaTpszDp10 = qutaTpszDp10;
		this.qutaTpszDp16 = qutaTpszDp16;
		this.qutaTpszDp15 = qutaTpszDp15;
		this.qutaTpszDp18 = qutaTpszDp18;
		this.qutaTpszDp17 = qutaTpszDp17;
		this.rhqCd = rhqCd;
		this.qutaTpszDp12 = qutaTpszDp12;
		this.qutaTpszDp11 = qutaTpszDp11;
		this.qutaTpszDp14 = qutaTpszDp14;
		this.qutaTpszDp13 = qutaTpszDp13;
		this.pfmcTpszDp27 = pfmcTpszDp27;
		this.pfmcTpszDp28 = pfmcTpszDp28;
		this.pfmcTpszDp29 = pfmcTpszDp29;
		this.pDispTpCd = pDispTpCd;
		this.pDispRsnCd = pDispRsnCd;
		this.rsltTpSeq = rsltTpSeq;
		this.qutaTpszDp19 = qutaTpszDp19;
		this.pfmcTpszDp30 = pfmcTpszDp30;
		this.qutaTpszDp21 = qutaTpszDp21;
		this.rsltTpNm = rsltTpNm;
		this.ratoTpszDp09 = ratoTpszDp09;
		this.ratoTpszDp08 = ratoTpszDp08;
		this.ratoTpszDp07 = ratoTpszDp07;
		this.ratoTpszDp12 = ratoTpszDp12;
		this.ratoTpszDp13 = ratoTpszDp13;
		this.ratoTpszDp10 = ratoTpszDp10;
		this.ratoTpszDp11 = ratoTpszDp11;
		this.ratoTpszDp16 = ratoTpszDp16;
		this.ratoTpszDp17 = ratoTpszDp17;
		this.ratoTpszDp14 = ratoTpszDp14;
		this.ratoTpszDp15 = ratoTpszDp15;
		this.pfmcTpszDp00 = pfmcTpszDp00;
		this.pfmcTpszDp03 = pfmcTpszDp03;
		this.pfmcTpszDp04 = pfmcTpszDp04;
		this.pRhqCd = pRhqCd;
		this.pfmcTpszDp01 = pfmcTpszDp01;
		this.pfmcTpszDp02 = pfmcTpszDp02;
		this.pStrEvntDt = pStrEvntDt;
		this.ratoTpszDp00 = ratoTpszDp00;
		this.ratoTpszDp01 = ratoTpszDp01;
		this.ratoTpszDp02 = ratoTpszDp02;
		this.ratoTpszDp03 = ratoTpszDp03;
		this.ratoTpszDp04 = ratoTpszDp04;
		this.ratoTpszDp05 = ratoTpszDp05;
		this.ratoTpszDp06 = ratoTpszDp06;
		this.pEqKndCd = pEqKndCd;
		this.currCd = currCd;
		this.qutaTpszDp30 = qutaTpszDp30;
		this.pfmcTpszDp19 = pfmcTpszDp19;
		this.pfmcTpszDp18 = pfmcTpszDp18;
		this.pfmcTpszDp17 = pfmcTpszDp17;
		this.pfmcTpszDp16 = pfmcTpszDp16;
		this.ratoTpszDp29 = ratoTpszDp29;
		this.ibflag = ibflag;
		this.pOfcCd = pOfcCd;
		this.ratoTpszDp30 = ratoTpszDp30;
		this.qutaTpszDp22 = qutaTpszDp22;
		this.pfmcTpszDp25 = pfmcTpszDp25;
		this.qutaTpszDp23 = qutaTpszDp23;
		this.pfmcTpszDp26 = pfmcTpszDp26;
		this.pfmcTpszDp23 = pfmcTpszDp23;
		this.qutaTpszDp24 = qutaTpszDp24;
		this.pfmcTpszDp24 = pfmcTpszDp24;
		this.qutaTpszDp25 = qutaTpszDp25;
		this.pfmcTpszDp21 = pfmcTpszDp21;
		this.qutaTpszDp26 = qutaTpszDp26;
		this.pfmcTpszDp22 = pfmcTpszDp22;
		this.qutaTpszDp27 = qutaTpszDp27;
		this.qutaTpszDp28 = qutaTpszDp28;
		this.qutaTpszDp29 = qutaTpszDp29;
		this.pfmcTpszDp09 = pfmcTpszDp09;
		this.pfmcTpszDp06 = pfmcTpszDp06;
		this.pfmcTpszDp05 = pfmcTpszDp05;
		this.pfmcTpszDp08 = pfmcTpszDp08;
		this.pfmcTpszDp07 = pfmcTpszDp07;
		this.ratoTpszDp19 = ratoTpszDp19;
		this.ratoTpszDp18 = ratoTpszDp18;
		this.pCustCd = pCustCd;
		this.ratoTpszDp25 = ratoTpszDp25;
		this.ratoTpszDp26 = ratoTpszDp26;
		this.ratoTpszDp27 = ratoTpszDp27;
		this.ratoTpszDp28 = ratoTpszDp28;
		this.ratoTpszDp21 = ratoTpszDp21;
		this.ratoTpszDp22 = ratoTpszDp22;
		this.ratoTpszDp23 = ratoTpszDp23;
		this.ratoTpszDp24 = ratoTpszDp24;
		this.rqstOfcCd = rqstOfcCd;
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
		this.hashColumns.put("quta_tpsz_dp07", getQutaTpszDp07());
		this.hashColumns.put("quta_tpsz_dp06", getQutaTpszDp06());
		this.hashColumns.put("quta_tpsz_dp05", getQutaTpszDp05());
		this.hashColumns.put("quta_tpsz_dp04", getQutaTpszDp04());
		this.hashColumns.put("quta_tpsz_dp03", getQutaTpszDp03());
		this.hashColumns.put("quta_tpsz_dp02", getQutaTpszDp02());
		this.hashColumns.put("quta_tpsz_dp01", getQutaTpszDp01());
		this.hashColumns.put("quta_tpsz_dp00", getQutaTpszDp00());
		this.hashColumns.put("p_end_evnt_dt", getPEndEvntDt());
		this.hashColumns.put("quta_tpsz_dp09", getQutaTpszDp09());
		this.hashColumns.put("quta_tpsz_dp08", getQutaTpszDp08());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("quta_tpsz_dp10", getQutaTpszDp10());
		this.hashColumns.put("quta_tpsz_dp16", getQutaTpszDp16());
		this.hashColumns.put("quta_tpsz_dp15", getQutaTpszDp15());
		this.hashColumns.put("quta_tpsz_dp18", getQutaTpszDp18());
		this.hashColumns.put("quta_tpsz_dp17", getQutaTpszDp17());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("quta_tpsz_dp12", getQutaTpszDp12());
		this.hashColumns.put("quta_tpsz_dp11", getQutaTpszDp11());
		this.hashColumns.put("quta_tpsz_dp14", getQutaTpszDp14());
		this.hashColumns.put("quta_tpsz_dp13", getQutaTpszDp13());
		this.hashColumns.put("pfmc_tpsz_dp27", getPfmcTpszDp27());
		this.hashColumns.put("pfmc_tpsz_dp28", getPfmcTpszDp28());
		this.hashColumns.put("pfmc_tpsz_dp29", getPfmcTpszDp29());
		this.hashColumns.put("p_disp_tp_cd", getPDispTpCd());
		this.hashColumns.put("p_disp_rsn_cd", getPDispRsnCd());
		this.hashColumns.put("rslt_tp_seq", getRsltTpSeq());
		this.hashColumns.put("quta_tpsz_dp19", getQutaTpszDp19());
		this.hashColumns.put("pfmc_tpsz_dp30", getPfmcTpszDp30());
		this.hashColumns.put("quta_tpsz_dp21", getQutaTpszDp21());
		this.hashColumns.put("rslt_tp_nm", getRsltTpNm());
		this.hashColumns.put("rato_tpsz_dp09", getRatoTpszDp09());
		this.hashColumns.put("rato_tpsz_dp08", getRatoTpszDp08());
		this.hashColumns.put("rato_tpsz_dp07", getRatoTpszDp07());
		this.hashColumns.put("rato_tpsz_dp12", getRatoTpszDp12());
		this.hashColumns.put("rato_tpsz_dp13", getRatoTpszDp13());
		this.hashColumns.put("rato_tpsz_dp10", getRatoTpszDp10());
		this.hashColumns.put("rato_tpsz_dp11", getRatoTpszDp11());
		this.hashColumns.put("rato_tpsz_dp16", getRatoTpszDp16());
		this.hashColumns.put("rato_tpsz_dp17", getRatoTpszDp17());
		this.hashColumns.put("rato_tpsz_dp14", getRatoTpszDp14());
		this.hashColumns.put("rato_tpsz_dp15", getRatoTpszDp15());
		this.hashColumns.put("pfmc_tpsz_dp00", getPfmcTpszDp00());
		this.hashColumns.put("pfmc_tpsz_dp03", getPfmcTpszDp03());
		this.hashColumns.put("pfmc_tpsz_dp04", getPfmcTpszDp04());
		this.hashColumns.put("p_rhq_cd", getPRhqCd());
		this.hashColumns.put("pfmc_tpsz_dp01", getPfmcTpszDp01());
		this.hashColumns.put("pfmc_tpsz_dp02", getPfmcTpszDp02());
		this.hashColumns.put("p_str_evnt_dt", getPStrEvntDt());
		this.hashColumns.put("rato_tpsz_dp00", getRatoTpszDp00());
		this.hashColumns.put("rato_tpsz_dp01", getRatoTpszDp01());
		this.hashColumns.put("rato_tpsz_dp02", getRatoTpszDp02());
		this.hashColumns.put("rato_tpsz_dp03", getRatoTpszDp03());
		this.hashColumns.put("rato_tpsz_dp04", getRatoTpszDp04());
		this.hashColumns.put("rato_tpsz_dp05", getRatoTpszDp05());
		this.hashColumns.put("rato_tpsz_dp06", getRatoTpszDp06());
		this.hashColumns.put("p_eq_knd_cd", getPEqKndCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("quta_tpsz_dp30", getQutaTpszDp30());
		this.hashColumns.put("pfmc_tpsz_dp19", getPfmcTpszDp19());
		this.hashColumns.put("pfmc_tpsz_dp18", getPfmcTpszDp18());
		this.hashColumns.put("pfmc_tpsz_dp17", getPfmcTpszDp17());
		this.hashColumns.put("pfmc_tpsz_dp16", getPfmcTpszDp16());
		this.hashColumns.put("rato_tpsz_dp29", getRatoTpszDp29());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_ofc_cd", getPOfcCd());
		this.hashColumns.put("rato_tpsz_dp30", getRatoTpszDp30());
		this.hashColumns.put("quta_tpsz_dp22", getQutaTpszDp22());
		this.hashColumns.put("pfmc_tpsz_dp25", getPfmcTpszDp25());
		this.hashColumns.put("quta_tpsz_dp23", getQutaTpszDp23());
		this.hashColumns.put("pfmc_tpsz_dp26", getPfmcTpszDp26());
		this.hashColumns.put("pfmc_tpsz_dp23", getPfmcTpszDp23());
		this.hashColumns.put("quta_tpsz_dp24", getQutaTpszDp24());
		this.hashColumns.put("pfmc_tpsz_dp24", getPfmcTpszDp24());
		this.hashColumns.put("quta_tpsz_dp25", getQutaTpszDp25());
		this.hashColumns.put("pfmc_tpsz_dp21", getPfmcTpszDp21());
		this.hashColumns.put("quta_tpsz_dp26", getQutaTpszDp26());
		this.hashColumns.put("pfmc_tpsz_dp22", getPfmcTpszDp22());
		this.hashColumns.put("quta_tpsz_dp27", getQutaTpszDp27());
		this.hashColumns.put("quta_tpsz_dp28", getQutaTpszDp28());
		this.hashColumns.put("quta_tpsz_dp29", getQutaTpszDp29());
		this.hashColumns.put("pfmc_tpsz_dp09", getPfmcTpszDp09());
		this.hashColumns.put("pfmc_tpsz_dp06", getPfmcTpszDp06());
		this.hashColumns.put("pfmc_tpsz_dp05", getPfmcTpszDp05());
		this.hashColumns.put("pfmc_tpsz_dp08", getPfmcTpszDp08());
		this.hashColumns.put("pfmc_tpsz_dp07", getPfmcTpszDp07());
		this.hashColumns.put("rato_tpsz_dp19", getRatoTpszDp19());
		this.hashColumns.put("rato_tpsz_dp18", getRatoTpszDp18());
		this.hashColumns.put("p_cust_cd", getPCustCd());
		this.hashColumns.put("rato_tpsz_dp25", getRatoTpszDp25());
		this.hashColumns.put("rato_tpsz_dp26", getRatoTpszDp26());
		this.hashColumns.put("rato_tpsz_dp27", getRatoTpszDp27());
		this.hashColumns.put("rato_tpsz_dp28", getRatoTpszDp28());
		this.hashColumns.put("rato_tpsz_dp21", getRatoTpszDp21());
		this.hashColumns.put("rato_tpsz_dp22", getRatoTpszDp22());
		this.hashColumns.put("rato_tpsz_dp23", getRatoTpszDp23());
		this.hashColumns.put("rato_tpsz_dp24", getRatoTpszDp24());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
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
		this.hashFields.put("quta_tpsz_dp07", "qutaTpszDp07");
		this.hashFields.put("quta_tpsz_dp06", "qutaTpszDp06");
		this.hashFields.put("quta_tpsz_dp05", "qutaTpszDp05");
		this.hashFields.put("quta_tpsz_dp04", "qutaTpszDp04");
		this.hashFields.put("quta_tpsz_dp03", "qutaTpszDp03");
		this.hashFields.put("quta_tpsz_dp02", "qutaTpszDp02");
		this.hashFields.put("quta_tpsz_dp01", "qutaTpszDp01");
		this.hashFields.put("quta_tpsz_dp00", "qutaTpszDp00");
		this.hashFields.put("p_end_evnt_dt", "pEndEvntDt");
		this.hashFields.put("quta_tpsz_dp09", "qutaTpszDp09");
		this.hashFields.put("quta_tpsz_dp08", "qutaTpszDp08");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("quta_tpsz_dp10", "qutaTpszDp10");
		this.hashFields.put("quta_tpsz_dp16", "qutaTpszDp16");
		this.hashFields.put("quta_tpsz_dp15", "qutaTpszDp15");
		this.hashFields.put("quta_tpsz_dp18", "qutaTpszDp18");
		this.hashFields.put("quta_tpsz_dp17", "qutaTpszDp17");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("quta_tpsz_dp12", "qutaTpszDp12");
		this.hashFields.put("quta_tpsz_dp11", "qutaTpszDp11");
		this.hashFields.put("quta_tpsz_dp14", "qutaTpszDp14");
		this.hashFields.put("quta_tpsz_dp13", "qutaTpszDp13");
		this.hashFields.put("pfmc_tpsz_dp27", "pfmcTpszDp27");
		this.hashFields.put("pfmc_tpsz_dp28", "pfmcTpszDp28");
		this.hashFields.put("pfmc_tpsz_dp29", "pfmcTpszDp29");
		this.hashFields.put("p_disp_tp_cd", "pDispTpCd");
		this.hashFields.put("p_disp_rsn_cd", "pDispRsnCd");
		this.hashFields.put("rslt_tp_seq", "rsltTpSeq");
		this.hashFields.put("quta_tpsz_dp19", "qutaTpszDp19");
		this.hashFields.put("pfmc_tpsz_dp30", "pfmcTpszDp30");
		this.hashFields.put("quta_tpsz_dp21", "qutaTpszDp21");
		this.hashFields.put("rslt_tp_nm", "rsltTpNm");
		this.hashFields.put("rato_tpsz_dp09", "ratoTpszDp09");
		this.hashFields.put("rato_tpsz_dp08", "ratoTpszDp08");
		this.hashFields.put("rato_tpsz_dp07", "ratoTpszDp07");
		this.hashFields.put("rato_tpsz_dp12", "ratoTpszDp12");
		this.hashFields.put("rato_tpsz_dp13", "ratoTpszDp13");
		this.hashFields.put("rato_tpsz_dp10", "ratoTpszDp10");
		this.hashFields.put("rato_tpsz_dp11", "ratoTpszDp11");
		this.hashFields.put("rato_tpsz_dp16", "ratoTpszDp16");
		this.hashFields.put("rato_tpsz_dp17", "ratoTpszDp17");
		this.hashFields.put("rato_tpsz_dp14", "ratoTpszDp14");
		this.hashFields.put("rato_tpsz_dp15", "ratoTpszDp15");
		this.hashFields.put("pfmc_tpsz_dp00", "pfmcTpszDp00");
		this.hashFields.put("pfmc_tpsz_dp03", "pfmcTpszDp03");
		this.hashFields.put("pfmc_tpsz_dp04", "pfmcTpszDp04");
		this.hashFields.put("p_rhq_cd", "pRhqCd");
		this.hashFields.put("pfmc_tpsz_dp01", "pfmcTpszDp01");
		this.hashFields.put("pfmc_tpsz_dp02", "pfmcTpszDp02");
		this.hashFields.put("p_str_evnt_dt", "pStrEvntDt");
		this.hashFields.put("rato_tpsz_dp00", "ratoTpszDp00");
		this.hashFields.put("rato_tpsz_dp01", "ratoTpszDp01");
		this.hashFields.put("rato_tpsz_dp02", "ratoTpszDp02");
		this.hashFields.put("rato_tpsz_dp03", "ratoTpszDp03");
		this.hashFields.put("rato_tpsz_dp04", "ratoTpszDp04");
		this.hashFields.put("rato_tpsz_dp05", "ratoTpszDp05");
		this.hashFields.put("rato_tpsz_dp06", "ratoTpszDp06");
		this.hashFields.put("p_eq_knd_cd", "pEqKndCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("quta_tpsz_dp30", "qutaTpszDp30");
		this.hashFields.put("pfmc_tpsz_dp19", "pfmcTpszDp19");
		this.hashFields.put("pfmc_tpsz_dp18", "pfmcTpszDp18");
		this.hashFields.put("pfmc_tpsz_dp17", "pfmcTpszDp17");
		this.hashFields.put("pfmc_tpsz_dp16", "pfmcTpszDp16");
		this.hashFields.put("rato_tpsz_dp29", "ratoTpszDp29");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_ofc_cd", "pOfcCd");
		this.hashFields.put("rato_tpsz_dp30", "ratoTpszDp30");
		this.hashFields.put("quta_tpsz_dp22", "qutaTpszDp22");
		this.hashFields.put("pfmc_tpsz_dp25", "pfmcTpszDp25");
		this.hashFields.put("quta_tpsz_dp23", "qutaTpszDp23");
		this.hashFields.put("pfmc_tpsz_dp26", "pfmcTpszDp26");
		this.hashFields.put("pfmc_tpsz_dp23", "pfmcTpszDp23");
		this.hashFields.put("quta_tpsz_dp24", "qutaTpszDp24");
		this.hashFields.put("pfmc_tpsz_dp24", "pfmcTpszDp24");
		this.hashFields.put("quta_tpsz_dp25", "qutaTpszDp25");
		this.hashFields.put("pfmc_tpsz_dp21", "pfmcTpszDp21");
		this.hashFields.put("quta_tpsz_dp26", "qutaTpszDp26");
		this.hashFields.put("pfmc_tpsz_dp22", "pfmcTpszDp22");
		this.hashFields.put("quta_tpsz_dp27", "qutaTpszDp27");
		this.hashFields.put("quta_tpsz_dp28", "qutaTpszDp28");
		this.hashFields.put("quta_tpsz_dp29", "qutaTpszDp29");
		this.hashFields.put("pfmc_tpsz_dp09", "pfmcTpszDp09");
		this.hashFields.put("pfmc_tpsz_dp06", "pfmcTpszDp06");
		this.hashFields.put("pfmc_tpsz_dp05", "pfmcTpszDp05");
		this.hashFields.put("pfmc_tpsz_dp08", "pfmcTpszDp08");
		this.hashFields.put("pfmc_tpsz_dp07", "pfmcTpszDp07");
		this.hashFields.put("rato_tpsz_dp19", "ratoTpszDp19");
		this.hashFields.put("rato_tpsz_dp18", "ratoTpszDp18");
		this.hashFields.put("p_cust_cd", "pCustCd");
		this.hashFields.put("rato_tpsz_dp25", "ratoTpszDp25");
		this.hashFields.put("rato_tpsz_dp26", "ratoTpszDp26");
		this.hashFields.put("rato_tpsz_dp27", "ratoTpszDp27");
		this.hashFields.put("rato_tpsz_dp28", "ratoTpszDp28");
		this.hashFields.put("rato_tpsz_dp21", "ratoTpszDp21");
		this.hashFields.put("rato_tpsz_dp22", "ratoTpszDp22");
		this.hashFields.put("rato_tpsz_dp23", "ratoTpszDp23");
		this.hashFields.put("rato_tpsz_dp24", "ratoTpszDp24");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
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
	 * @return qutaTpszDp07
	 */
	public String getQutaTpszDp07() {
		return this.qutaTpszDp07;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp06
	 */
	public String getQutaTpszDp06() {
		return this.qutaTpszDp06;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp05
	 */
	public String getQutaTpszDp05() {
		return this.qutaTpszDp05;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp04
	 */
	public String getQutaTpszDp04() {
		return this.qutaTpszDp04;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp03
	 */
	public String getQutaTpszDp03() {
		return this.qutaTpszDp03;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp02
	 */
	public String getQutaTpszDp02() {
		return this.qutaTpszDp02;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp01
	 */
	public String getQutaTpszDp01() {
		return this.qutaTpszDp01;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp00
	 */
	public String getQutaTpszDp00() {
		return this.qutaTpszDp00;
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
	 * @return qutaTpszDp09
	 */
	public String getQutaTpszDp09() {
		return this.qutaTpszDp09;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp08
	 */
	public String getQutaTpszDp08() {
		return this.qutaTpszDp08;
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
	 * @return qutaTpszDp10
	 */
	public String getQutaTpszDp10() {
		return this.qutaTpszDp10;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp16
	 */
	public String getQutaTpszDp16() {
		return this.qutaTpszDp16;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp15
	 */
	public String getQutaTpszDp15() {
		return this.qutaTpszDp15;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp18
	 */
	public String getQutaTpszDp18() {
		return this.qutaTpszDp18;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp17
	 */
	public String getQutaTpszDp17() {
		return this.qutaTpszDp17;
	}

	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp12
	 */
	public String getQutaTpszDp12() {
		return this.qutaTpszDp12;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp11
	 */
	public String getQutaTpszDp11() {
		return this.qutaTpszDp11;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp14
	 */
	public String getQutaTpszDp14() {
		return this.qutaTpszDp14;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp13
	 */
	public String getQutaTpszDp13() {
		return this.qutaTpszDp13;
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
	 * @return pDispTpCd
	 */
	public String getPDispTpCd() {
		return this.pDispTpCd;
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
	 * @return rsltTpSeq
	 */
	public String getRsltTpSeq() {
		return this.rsltTpSeq;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp19
	 */
	public String getQutaTpszDp19() {
		return this.qutaTpszDp19;
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
	 * @return qutaTpszDp21
	 */
	public String getQutaTpszDp21() {
		return this.qutaTpszDp21;
	}

	/**
	 * Column Info
	 * @return rsltTpNm
	 */
	public String getRsltTpNm() {
		return this.rsltTpNm;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp09
	 */
	public String getRatoTpszDp09() {
		return this.ratoTpszDp09;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp08
	 */
	public String getRatoTpszDp08() {
		return this.ratoTpszDp08;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp07
	 */
	public String getRatoTpszDp07() {
		return this.ratoTpszDp07;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp12
	 */
	public String getRatoTpszDp12() {
		return this.ratoTpszDp12;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp13
	 */
	public String getRatoTpszDp13() {
		return this.ratoTpszDp13;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp10
	 */
	public String getRatoTpszDp10() {
		return this.ratoTpszDp10;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp11
	 */
	public String getRatoTpszDp11() {
		return this.ratoTpszDp11;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp16
	 */
	public String getRatoTpszDp16() {
		return this.ratoTpszDp16;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp17
	 */
	public String getRatoTpszDp17() {
		return this.ratoTpszDp17;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp14
	 */
	public String getRatoTpszDp14() {
		return this.ratoTpszDp14;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp15
	 */
	public String getRatoTpszDp15() {
		return this.ratoTpszDp15;
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
	 * @return pfmcTpszDp03
	 */
	public String getPfmcTpszDp03() {
		return this.pfmcTpszDp03;
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
	 * @return pRhqCd
	 */
	public String getPRhqCd() {
		return this.pRhqCd;
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
	 * @return pfmcTpszDp02
	 */
	public String getPfmcTpszDp02() {
		return this.pfmcTpszDp02;
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
	 * @return ratoTpszDp00
	 */
	public String getRatoTpszDp00() {
		return this.ratoTpszDp00;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp01
	 */
	public String getRatoTpszDp01() {
		return this.ratoTpszDp01;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp02
	 */
	public String getRatoTpszDp02() {
		return this.ratoTpszDp02;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp03
	 */
	public String getRatoTpszDp03() {
		return this.ratoTpszDp03;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp04
	 */
	public String getRatoTpszDp04() {
		return this.ratoTpszDp04;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp05
	 */
	public String getRatoTpszDp05() {
		return this.ratoTpszDp05;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp06
	 */
	public String getRatoTpszDp06() {
		return this.ratoTpszDp06;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp30
	 */
	public String getQutaTpszDp30() {
		return this.qutaTpszDp30;
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
	 * @return ratoTpszDp29
	 */
	public String getRatoTpszDp29() {
		return this.ratoTpszDp29;
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
	 * @return ratoTpszDp30
	 */
	public String getRatoTpszDp30() {
		return this.ratoTpszDp30;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp22
	 */
	public String getQutaTpszDp22() {
		return this.qutaTpszDp22;
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
	 * @return qutaTpszDp23
	 */
	public String getQutaTpszDp23() {
		return this.qutaTpszDp23;
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
	 * @return pfmcTpszDp23
	 */
	public String getPfmcTpszDp23() {
		return this.pfmcTpszDp23;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp24
	 */
	public String getQutaTpszDp24() {
		return this.qutaTpszDp24;
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
	 * @return qutaTpszDp25
	 */
	public String getQutaTpszDp25() {
		return this.qutaTpszDp25;
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
	 * @return qutaTpszDp26
	 */
	public String getQutaTpszDp26() {
		return this.qutaTpszDp26;
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
	 * @return qutaTpszDp27
	 */
	public String getQutaTpszDp27() {
		return this.qutaTpszDp27;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp28
	 */
	public String getQutaTpszDp28() {
		return this.qutaTpszDp28;
	}

	/**
	 * Column Info
	 * @return qutaTpszDp29
	 */
	public String getQutaTpszDp29() {
		return this.qutaTpszDp29;
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
	 * @return ratoTpszDp19
	 */
	public String getRatoTpszDp19() {
		return this.ratoTpszDp19;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp18
	 */
	public String getRatoTpszDp18() {
		return this.ratoTpszDp18;
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
	 * @return ratoTpszDp25
	 */
	public String getRatoTpszDp25() {
		return this.ratoTpszDp25;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp26
	 */
	public String getRatoTpszDp26() {
		return this.ratoTpszDp26;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp27
	 */
	public String getRatoTpszDp27() {
		return this.ratoTpszDp27;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp28
	 */
	public String getRatoTpszDp28() {
		return this.ratoTpszDp28;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp21
	 */
	public String getRatoTpszDp21() {
		return this.ratoTpszDp21;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp22
	 */
	public String getRatoTpszDp22() {
		return this.ratoTpszDp22;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp23
	 */
	public String getRatoTpszDp23() {
		return this.ratoTpszDp23;
	}

	/**
	 * Column Info
	 * @return ratoTpszDp24
	 */
	public String getRatoTpszDp24() {
		return this.ratoTpszDp24;
	}

	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
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
	 * @param qutaTpszDp07
	 */
	public void setQutaTpszDp07(String qutaTpszDp07) {
		this.qutaTpszDp07 = qutaTpszDp07;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp06
	 */
	public void setQutaTpszDp06(String qutaTpszDp06) {
		this.qutaTpszDp06 = qutaTpszDp06;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp05
	 */
	public void setQutaTpszDp05(String qutaTpszDp05) {
		this.qutaTpszDp05 = qutaTpszDp05;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp04
	 */
	public void setQutaTpszDp04(String qutaTpszDp04) {
		this.qutaTpszDp04 = qutaTpszDp04;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp03
	 */
	public void setQutaTpszDp03(String qutaTpszDp03) {
		this.qutaTpszDp03 = qutaTpszDp03;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp02
	 */
	public void setQutaTpszDp02(String qutaTpszDp02) {
		this.qutaTpszDp02 = qutaTpszDp02;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp01
	 */
	public void setQutaTpszDp01(String qutaTpszDp01) {
		this.qutaTpszDp01 = qutaTpszDp01;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp00
	 */
	public void setQutaTpszDp00(String qutaTpszDp00) {
		this.qutaTpszDp00 = qutaTpszDp00;
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
	 * @param qutaTpszDp09
	 */
	public void setQutaTpszDp09(String qutaTpszDp09) {
		this.qutaTpszDp09 = qutaTpszDp09;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp08
	 */
	public void setQutaTpszDp08(String qutaTpszDp08) {
		this.qutaTpszDp08 = qutaTpszDp08;
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
	 * @param qutaTpszDp10
	 */
	public void setQutaTpszDp10(String qutaTpszDp10) {
		this.qutaTpszDp10 = qutaTpszDp10;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp16
	 */
	public void setQutaTpszDp16(String qutaTpszDp16) {
		this.qutaTpszDp16 = qutaTpszDp16;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp15
	 */
	public void setQutaTpszDp15(String qutaTpszDp15) {
		this.qutaTpszDp15 = qutaTpszDp15;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp18
	 */
	public void setQutaTpszDp18(String qutaTpszDp18) {
		this.qutaTpszDp18 = qutaTpszDp18;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp17
	 */
	public void setQutaTpszDp17(String qutaTpszDp17) {
		this.qutaTpszDp17 = qutaTpszDp17;
	}

	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp12
	 */
	public void setQutaTpszDp12(String qutaTpszDp12) {
		this.qutaTpszDp12 = qutaTpszDp12;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp11
	 */
	public void setQutaTpszDp11(String qutaTpszDp11) {
		this.qutaTpszDp11 = qutaTpszDp11;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp14
	 */
	public void setQutaTpszDp14(String qutaTpszDp14) {
		this.qutaTpszDp14 = qutaTpszDp14;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp13
	 */
	public void setQutaTpszDp13(String qutaTpszDp13) {
		this.qutaTpszDp13 = qutaTpszDp13;
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
	 * @param pDispTpCd
	 */
	public void setPDispTpCd(String pDispTpCd) {
		this.pDispTpCd = pDispTpCd;
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
	 * @param rsltTpSeq
	 */
	public void setRsltTpSeq(String rsltTpSeq) {
		this.rsltTpSeq = rsltTpSeq;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp19
	 */
	public void setQutaTpszDp19(String qutaTpszDp19) {
		this.qutaTpszDp19 = qutaTpszDp19;
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
	 * @param qutaTpszDp21
	 */
	public void setQutaTpszDp21(String qutaTpszDp21) {
		this.qutaTpszDp21 = qutaTpszDp21;
	}

	/**
	 * Column Info
	 * @param rsltTpNm
	 */
	public void setRsltTpNm(String rsltTpNm) {
		this.rsltTpNm = rsltTpNm;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp09
	 */
	public void setRatoTpszDp09(String ratoTpszDp09) {
		this.ratoTpszDp09 = ratoTpszDp09;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp08
	 */
	public void setRatoTpszDp08(String ratoTpszDp08) {
		this.ratoTpszDp08 = ratoTpszDp08;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp07
	 */
	public void setRatoTpszDp07(String ratoTpszDp07) {
		this.ratoTpszDp07 = ratoTpszDp07;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp12
	 */
	public void setRatoTpszDp12(String ratoTpszDp12) {
		this.ratoTpszDp12 = ratoTpszDp12;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp13
	 */
	public void setRatoTpszDp13(String ratoTpszDp13) {
		this.ratoTpszDp13 = ratoTpszDp13;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp10
	 */
	public void setRatoTpszDp10(String ratoTpszDp10) {
		this.ratoTpszDp10 = ratoTpszDp10;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp11
	 */
	public void setRatoTpszDp11(String ratoTpszDp11) {
		this.ratoTpszDp11 = ratoTpszDp11;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp16
	 */
	public void setRatoTpszDp16(String ratoTpszDp16) {
		this.ratoTpszDp16 = ratoTpszDp16;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp17
	 */
	public void setRatoTpszDp17(String ratoTpszDp17) {
		this.ratoTpszDp17 = ratoTpszDp17;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp14
	 */
	public void setRatoTpszDp14(String ratoTpszDp14) {
		this.ratoTpszDp14 = ratoTpszDp14;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp15
	 */
	public void setRatoTpszDp15(String ratoTpszDp15) {
		this.ratoTpszDp15 = ratoTpszDp15;
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
	 * @param pfmcTpszDp03
	 */
	public void setPfmcTpszDp03(String pfmcTpszDp03) {
		this.pfmcTpszDp03 = pfmcTpszDp03;
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
	 * @param pRhqCd
	 */
	public void setPRhqCd(String pRhqCd) {
		this.pRhqCd = pRhqCd;
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
	 * @param pfmcTpszDp02
	 */
	public void setPfmcTpszDp02(String pfmcTpszDp02) {
		this.pfmcTpszDp02 = pfmcTpszDp02;
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
	 * @param ratoTpszDp00
	 */
	public void setRatoTpszDp00(String ratoTpszDp00) {
		this.ratoTpszDp00 = ratoTpszDp00;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp01
	 */
	public void setRatoTpszDp01(String ratoTpszDp01) {
		this.ratoTpszDp01 = ratoTpszDp01;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp02
	 */
	public void setRatoTpszDp02(String ratoTpszDp02) {
		this.ratoTpszDp02 = ratoTpszDp02;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp03
	 */
	public void setRatoTpszDp03(String ratoTpszDp03) {
		this.ratoTpszDp03 = ratoTpszDp03;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp04
	 */
	public void setRatoTpszDp04(String ratoTpszDp04) {
		this.ratoTpszDp04 = ratoTpszDp04;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp05
	 */
	public void setRatoTpszDp05(String ratoTpszDp05) {
		this.ratoTpszDp05 = ratoTpszDp05;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp06
	 */
	public void setRatoTpszDp06(String ratoTpszDp06) {
		this.ratoTpszDp06 = ratoTpszDp06;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp30
	 */
	public void setQutaTpszDp30(String qutaTpszDp30) {
		this.qutaTpszDp30 = qutaTpszDp30;
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
	 * @param ratoTpszDp29
	 */
	public void setRatoTpszDp29(String ratoTpszDp29) {
		this.ratoTpszDp29 = ratoTpszDp29;
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
	 * @param ratoTpszDp30
	 */
	public void setRatoTpszDp30(String ratoTpszDp30) {
		this.ratoTpszDp30 = ratoTpszDp30;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp22
	 */
	public void setQutaTpszDp22(String qutaTpszDp22) {
		this.qutaTpszDp22 = qutaTpszDp22;
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
	 * @param qutaTpszDp23
	 */
	public void setQutaTpszDp23(String qutaTpszDp23) {
		this.qutaTpszDp23 = qutaTpszDp23;
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
	 * @param pfmcTpszDp23
	 */
	public void setPfmcTpszDp23(String pfmcTpszDp23) {
		this.pfmcTpszDp23 = pfmcTpszDp23;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp24
	 */
	public void setQutaTpszDp24(String qutaTpszDp24) {
		this.qutaTpszDp24 = qutaTpszDp24;
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
	 * @param qutaTpszDp25
	 */
	public void setQutaTpszDp25(String qutaTpszDp25) {
		this.qutaTpszDp25 = qutaTpszDp25;
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
	 * @param qutaTpszDp26
	 */
	public void setQutaTpszDp26(String qutaTpszDp26) {
		this.qutaTpszDp26 = qutaTpszDp26;
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
	 * @param qutaTpszDp27
	 */
	public void setQutaTpszDp27(String qutaTpszDp27) {
		this.qutaTpszDp27 = qutaTpszDp27;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp28
	 */
	public void setQutaTpszDp28(String qutaTpszDp28) {
		this.qutaTpszDp28 = qutaTpszDp28;
	}

	/**
	 * Column Info
	 * @param qutaTpszDp29
	 */
	public void setQutaTpszDp29(String qutaTpszDp29) {
		this.qutaTpszDp29 = qutaTpszDp29;
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
	 * @param ratoTpszDp19
	 */
	public void setRatoTpszDp19(String ratoTpszDp19) {
		this.ratoTpszDp19 = ratoTpszDp19;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp18
	 */
	public void setRatoTpszDp18(String ratoTpszDp18) {
		this.ratoTpszDp18 = ratoTpszDp18;
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
	 * @param ratoTpszDp25
	 */
	public void setRatoTpszDp25(String ratoTpszDp25) {
		this.ratoTpszDp25 = ratoTpszDp25;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp26
	 */
	public void setRatoTpszDp26(String ratoTpszDp26) {
		this.ratoTpszDp26 = ratoTpszDp26;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp27
	 */
	public void setRatoTpszDp27(String ratoTpszDp27) {
		this.ratoTpszDp27 = ratoTpszDp27;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp28
	 */
	public void setRatoTpszDp28(String ratoTpszDp28) {
		this.ratoTpszDp28 = ratoTpszDp28;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp21
	 */
	public void setRatoTpszDp21(String ratoTpszDp21) {
		this.ratoTpszDp21 = ratoTpszDp21;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp22
	 */
	public void setRatoTpszDp22(String ratoTpszDp22) {
		this.ratoTpszDp22 = ratoTpszDp22;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp23
	 */
	public void setRatoTpszDp23(String ratoTpszDp23) {
		this.ratoTpszDp23 = ratoTpszDp23;
	}

	/**
	 * Column Info
	 * @param ratoTpszDp24
	 */
	public void setRatoTpszDp24(String ratoTpszDp24) {
		this.ratoTpszDp24 = ratoTpszDp24;
	}

	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
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
		setQutaTpszDp07(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp07", ""));
		setQutaTpszDp06(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp06", ""));
		setQutaTpszDp05(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp05", ""));
		setQutaTpszDp04(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp04", ""));
		setQutaTpszDp03(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp03", ""));
		setQutaTpszDp02(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp02", ""));
		setQutaTpszDp01(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp01", ""));
		setQutaTpszDp00(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp00", ""));
		setPEndEvntDt(JSPUtil.getParameter(request, prefix + "p_end_evnt_dt", "").replaceAll("-", ""));
		setQutaTpszDp09(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp09", ""));
		setQutaTpszDp08(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp08", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setQutaTpszDp10(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp10", ""));
		setQutaTpszDp16(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp16", ""));
		setQutaTpszDp15(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp15", ""));
		setQutaTpszDp18(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp18", ""));
		setQutaTpszDp17(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp17", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setQutaTpszDp12(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp12", ""));
		setQutaTpszDp11(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp11", ""));
		setQutaTpszDp14(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp14", ""));
		setQutaTpszDp13(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp13", ""));
		setPfmcTpszDp27(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp27", ""));
		setPfmcTpszDp28(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp28", ""));
		setPfmcTpszDp29(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp29", ""));
		setPDispTpCd(JSPUtil.getParameter(request, prefix + "p_disp_tp_cd", ""));
		setPDispRsnCd(JSPUtil.getParameter(request, prefix + "p_disp_rsn_cd", ""));
		setRsltTpSeq(JSPUtil.getParameter(request, prefix + "rslt_tp_seq", ""));
		setQutaTpszDp19(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp19", ""));
		setPfmcTpszDp30(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp30", ""));
		setQutaTpszDp21(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp21", ""));
		setRsltTpNm(JSPUtil.getParameter(request, prefix + "rslt_tp_nm", ""));
		setRatoTpszDp09(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp09", ""));
		setRatoTpszDp08(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp08", ""));
		setRatoTpszDp07(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp07", ""));
		setRatoTpszDp12(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp12", ""));
		setRatoTpszDp13(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp13", ""));
		setRatoTpszDp10(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp10", ""));
		setRatoTpszDp11(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp11", ""));
		setRatoTpszDp16(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp16", ""));
		setRatoTpszDp17(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp17", ""));
		setRatoTpszDp14(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp14", ""));
		setRatoTpszDp15(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp15", ""));
		setPfmcTpszDp00(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp00", ""));
		setPfmcTpszDp03(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp03", ""));
		setPfmcTpszDp04(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp04", ""));
		setPRhqCd(JSPUtil.getParameter(request, prefix + "p_rhq_cd", ""));
		setPfmcTpszDp01(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp01", ""));
		setPfmcTpszDp02(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp02", ""));
		setPStrEvntDt(JSPUtil.getParameter(request, prefix + "p_str_evnt_dt", "").replaceAll("-", ""));
		setRatoTpszDp00(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp00", ""));
		setRatoTpszDp01(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp01", ""));
		setRatoTpszDp02(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp02", ""));
		setRatoTpszDp03(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp03", ""));
		setRatoTpszDp04(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp04", ""));
		setRatoTpszDp05(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp05", ""));
		setRatoTpszDp06(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp06", ""));
		setPEqKndCd(JSPUtil.getParameter(request, prefix + "p_eq_knd_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setQutaTpszDp30(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp30", ""));
		setPfmcTpszDp19(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp19", ""));
		setPfmcTpszDp18(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp18", ""));
		setPfmcTpszDp17(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp17", ""));
		setPfmcTpszDp16(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp16", ""));
		setRatoTpszDp29(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp29", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPOfcCd(JSPUtil.getParameter(request, prefix + "p_ofc_cd", ""));
		setRatoTpszDp30(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp30", ""));
		setQutaTpszDp22(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp22", ""));
		setPfmcTpszDp25(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp25", ""));
		setQutaTpszDp23(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp23", ""));
		setPfmcTpszDp26(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp26", ""));
		setPfmcTpszDp23(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp23", ""));
		setQutaTpszDp24(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp24", ""));
		setPfmcTpszDp24(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp24", ""));
		setQutaTpszDp25(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp25", ""));
		setPfmcTpszDp21(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp21", ""));
		setQutaTpszDp26(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp26", ""));
		setPfmcTpszDp22(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp22", ""));
		setQutaTpszDp27(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp27", ""));
		setQutaTpszDp28(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp28", ""));
		setQutaTpszDp29(JSPUtil.getParameter(request, prefix + "quta_tpsz_dp29", ""));
		setPfmcTpszDp09(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp09", ""));
		setPfmcTpszDp06(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp06", ""));
		setPfmcTpszDp05(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp05", ""));
		setPfmcTpszDp08(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp08", ""));
		setPfmcTpszDp07(JSPUtil.getParameter(request, prefix + "pfmc_tpsz_dp07", ""));
		setRatoTpszDp19(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp19", ""));
		setRatoTpszDp18(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp18", ""));
		setPCustCd(JSPUtil.getParameter(request, prefix + "p_cust_cd", ""));
		setRatoTpszDp25(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp25", ""));
		setRatoTpszDp26(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp26", ""));
		setRatoTpszDp27(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp27", ""));
		setRatoTpszDp28(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp28", ""));
		setRatoTpszDp21(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp21", ""));
		setRatoTpszDp22(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp22", ""));
		setRatoTpszDp23(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp23", ""));
		setRatoTpszDp24(JSPUtil.getParameter(request, prefix + "rato_tpsz_dp24", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
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
	 * @return DisposalPFMCByOfficeVO[]
	 */
	public DisposalPFMCByOfficeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DisposalPFMCByOfficeVO[]
	 */
	public DisposalPFMCByOfficeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalPFMCByOfficeVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] qutaTpszDp07 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp07", length));
			String[] qutaTpszDp06 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp06", length));
			String[] qutaTpszDp05 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp05", length));
			String[] qutaTpszDp04 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp04", length));
			String[] qutaTpszDp03 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp03", length));
			String[] qutaTpszDp02 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp02", length));
			String[] qutaTpszDp01 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp01", length));
			String[] qutaTpszDp00 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp00", length));
			String[] pEndEvntDt = (JSPUtil.getParameter(request, prefix	+ "p_end_evnt_dt", length));
			String[] qutaTpszDp09 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp09", length));
			String[] qutaTpszDp08 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp08", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] qutaTpszDp10 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp10", length));
			String[] qutaTpszDp16 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp16", length));
			String[] qutaTpszDp15 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp15", length));
			String[] qutaTpszDp18 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp18", length));
			String[] qutaTpszDp17 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp17", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] qutaTpszDp12 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp12", length));
			String[] qutaTpszDp11 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp11", length));
			String[] qutaTpszDp14 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp14", length));
			String[] qutaTpszDp13 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp13", length));
			String[] pfmcTpszDp27 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp27", length));
			String[] pfmcTpszDp28 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp28", length));
			String[] pfmcTpszDp29 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp29", length));
			String[] pDispTpCd = (JSPUtil.getParameter(request, prefix	+ "p_disp_tp_cd", length));
			String[] pDispRsnCd = (JSPUtil.getParameter(request, prefix	+ "p_disp_rsn_cd", length));
			String[] rsltTpSeq = (JSPUtil.getParameter(request, prefix	+ "rslt_tp_seq", length));
			String[] qutaTpszDp19 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp19", length));
			String[] pfmcTpszDp30 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp30", length));
			String[] qutaTpszDp21 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp21", length));
			String[] rsltTpNm = (JSPUtil.getParameter(request, prefix	+ "rslt_tp_nm", length));
			String[] ratoTpszDp09 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp09", length));
			String[] ratoTpszDp08 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp08", length));
			String[] ratoTpszDp07 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp07", length));
			String[] ratoTpszDp12 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp12", length));
			String[] ratoTpszDp13 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp13", length));
			String[] ratoTpszDp10 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp10", length));
			String[] ratoTpszDp11 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp11", length));
			String[] ratoTpszDp16 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp16", length));
			String[] ratoTpszDp17 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp17", length));
			String[] ratoTpszDp14 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp14", length));
			String[] ratoTpszDp15 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp15", length));
			String[] pfmcTpszDp00 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp00", length));
			String[] pfmcTpszDp03 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp03", length));
			String[] pfmcTpszDp04 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp04", length));
			String[] pRhqCd = (JSPUtil.getParameter(request, prefix	+ "p_rhq_cd", length));
			String[] pfmcTpszDp01 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp01", length));
			String[] pfmcTpszDp02 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp02", length));
			String[] pStrEvntDt = (JSPUtil.getParameter(request, prefix	+ "p_str_evnt_dt", length));
			String[] ratoTpszDp00 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp00", length));
			String[] ratoTpszDp01 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp01", length));
			String[] ratoTpszDp02 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp02", length));
			String[] ratoTpszDp03 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp03", length));
			String[] ratoTpszDp04 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp04", length));
			String[] ratoTpszDp05 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp05", length));
			String[] ratoTpszDp06 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp06", length));
			String[] pEqKndCd = (JSPUtil.getParameter(request, prefix	+ "p_eq_knd_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] qutaTpszDp30 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp30", length));
			String[] pfmcTpszDp19 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp19", length));
			String[] pfmcTpszDp18 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp18", length));
			String[] pfmcTpszDp17 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp17", length));
			String[] pfmcTpszDp16 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp16", length));
			String[] ratoTpszDp29 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp29", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_ofc_cd", length));
			String[] ratoTpszDp30 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp30", length));
			String[] qutaTpszDp22 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp22", length));
			String[] pfmcTpszDp25 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp25", length));
			String[] qutaTpszDp23 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp23", length));
			String[] pfmcTpszDp26 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp26", length));
			String[] pfmcTpszDp23 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp23", length));
			String[] qutaTpszDp24 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp24", length));
			String[] pfmcTpszDp24 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp24", length));
			String[] qutaTpszDp25 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp25", length));
			String[] pfmcTpszDp21 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp21", length));
			String[] qutaTpszDp26 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp26", length));
			String[] pfmcTpszDp22 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp22", length));
			String[] qutaTpszDp27 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp27", length));
			String[] qutaTpszDp28 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp28", length));
			String[] qutaTpszDp29 = (JSPUtil.getParameter(request, prefix	+ "quta_tpsz_dp29", length));
			String[] pfmcTpszDp09 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp09", length));
			String[] pfmcTpszDp06 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp06", length));
			String[] pfmcTpszDp05 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp05", length));
			String[] pfmcTpszDp08 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp08", length));
			String[] pfmcTpszDp07 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp07", length));
			String[] ratoTpszDp19 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp19", length));
			String[] ratoTpszDp18 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp18", length));
			String[] pCustCd = (JSPUtil.getParameter(request, prefix	+ "p_cust_cd", length));
			String[] ratoTpszDp25 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp25", length));
			String[] ratoTpszDp26 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp26", length));
			String[] ratoTpszDp27 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp27", length));
			String[] ratoTpszDp28 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp28", length));
			String[] ratoTpszDp21 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp21", length));
			String[] ratoTpszDp22 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp22", length));
			String[] ratoTpszDp23 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp23", length));
			String[] ratoTpszDp24 = (JSPUtil.getParameter(request, prefix	+ "rato_tpsz_dp24", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] pfmcTpszDp12 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp12", length));
			String[] pfmcTpszDp13 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp13", length));
			String[] pfmcTpszDp14 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp14", length));
			String[] pfmcTpszDp15 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp15", length));
			String[] pfmcTpszDp10 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp10", length));
			String[] pfmcTpszDp11 = (JSPUtil.getParameter(request, prefix	+ "pfmc_tpsz_dp11", length));

			for (int i = 0; i < length; i++) {
				model = new DisposalPFMCByOfficeVO();
				if (qutaTpszDp07[i] != null)
					model.setQutaTpszDp07(qutaTpszDp07[i]);
				if (qutaTpszDp06[i] != null)
					model.setQutaTpszDp06(qutaTpszDp06[i]);
				if (qutaTpszDp05[i] != null)
					model.setQutaTpszDp05(qutaTpszDp05[i]);
				if (qutaTpszDp04[i] != null)
					model.setQutaTpszDp04(qutaTpszDp04[i]);
				if (qutaTpszDp03[i] != null)
					model.setQutaTpszDp03(qutaTpszDp03[i]);
				if (qutaTpszDp02[i] != null)
					model.setQutaTpszDp02(qutaTpszDp02[i]);
				if (qutaTpszDp01[i] != null)
					model.setQutaTpszDp01(qutaTpszDp01[i]);
				if (qutaTpszDp00[i] != null)
					model.setQutaTpszDp00(qutaTpszDp00[i]);
				if (pEndEvntDt[i] != null)
					model.setPEndEvntDt(pEndEvntDt[i]);
				if (qutaTpszDp09[i] != null)
					model.setQutaTpszDp09(qutaTpszDp09[i]);
				if (qutaTpszDp08[i] != null)
					model.setQutaTpszDp08(qutaTpszDp08[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (qutaTpszDp10[i] != null)
					model.setQutaTpszDp10(qutaTpszDp10[i]);
				if (qutaTpszDp16[i] != null)
					model.setQutaTpszDp16(qutaTpszDp16[i]);
				if (qutaTpszDp15[i] != null)
					model.setQutaTpszDp15(qutaTpszDp15[i]);
				if (qutaTpszDp18[i] != null)
					model.setQutaTpszDp18(qutaTpszDp18[i]);
				if (qutaTpszDp17[i] != null)
					model.setQutaTpszDp17(qutaTpszDp17[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (qutaTpszDp12[i] != null)
					model.setQutaTpszDp12(qutaTpszDp12[i]);
				if (qutaTpszDp11[i] != null)
					model.setQutaTpszDp11(qutaTpszDp11[i]);
				if (qutaTpszDp14[i] != null)
					model.setQutaTpszDp14(qutaTpszDp14[i]);
				if (qutaTpszDp13[i] != null)
					model.setQutaTpszDp13(qutaTpszDp13[i]);
				if (pfmcTpszDp27[i] != null)
					model.setPfmcTpszDp27(pfmcTpszDp27[i]);
				if (pfmcTpszDp28[i] != null)
					model.setPfmcTpszDp28(pfmcTpszDp28[i]);
				if (pfmcTpszDp29[i] != null)
					model.setPfmcTpszDp29(pfmcTpszDp29[i]);
				if (pDispTpCd[i] != null)
					model.setPDispTpCd(pDispTpCd[i]);
				if (pDispRsnCd[i] != null)
					model.setPDispRsnCd(pDispRsnCd[i]);
				if (rsltTpSeq[i] != null)
					model.setRsltTpSeq(rsltTpSeq[i]);
				if (qutaTpszDp19[i] != null)
					model.setQutaTpszDp19(qutaTpszDp19[i]);
				if (pfmcTpszDp30[i] != null)
					model.setPfmcTpszDp30(pfmcTpszDp30[i]);
				if (qutaTpszDp21[i] != null)
					model.setQutaTpszDp21(qutaTpszDp21[i]);
				if (rsltTpNm[i] != null)
					model.setRsltTpNm(rsltTpNm[i]);
				if (ratoTpszDp09[i] != null)
					model.setRatoTpszDp09(ratoTpszDp09[i]);
				if (ratoTpszDp08[i] != null)
					model.setRatoTpszDp08(ratoTpszDp08[i]);
				if (ratoTpszDp07[i] != null)
					model.setRatoTpszDp07(ratoTpszDp07[i]);
				if (ratoTpszDp12[i] != null)
					model.setRatoTpszDp12(ratoTpszDp12[i]);
				if (ratoTpszDp13[i] != null)
					model.setRatoTpszDp13(ratoTpszDp13[i]);
				if (ratoTpszDp10[i] != null)
					model.setRatoTpszDp10(ratoTpszDp10[i]);
				if (ratoTpszDp11[i] != null)
					model.setRatoTpszDp11(ratoTpszDp11[i]);
				if (ratoTpszDp16[i] != null)
					model.setRatoTpszDp16(ratoTpszDp16[i]);
				if (ratoTpszDp17[i] != null)
					model.setRatoTpszDp17(ratoTpszDp17[i]);
				if (ratoTpszDp14[i] != null)
					model.setRatoTpszDp14(ratoTpszDp14[i]);
				if (ratoTpszDp15[i] != null)
					model.setRatoTpszDp15(ratoTpszDp15[i]);
				if (pfmcTpszDp00[i] != null)
					model.setPfmcTpszDp00(pfmcTpszDp00[i]);
				if (pfmcTpszDp03[i] != null)
					model.setPfmcTpszDp03(pfmcTpszDp03[i]);
				if (pfmcTpszDp04[i] != null)
					model.setPfmcTpszDp04(pfmcTpszDp04[i]);
				if (pRhqCd[i] != null)
					model.setPRhqCd(pRhqCd[i]);
				if (pfmcTpszDp01[i] != null)
					model.setPfmcTpszDp01(pfmcTpszDp01[i]);
				if (pfmcTpszDp02[i] != null)
					model.setPfmcTpszDp02(pfmcTpszDp02[i]);
				if (pStrEvntDt[i] != null)
					model.setPStrEvntDt(pStrEvntDt[i]);
				if (ratoTpszDp00[i] != null)
					model.setRatoTpszDp00(ratoTpszDp00[i]);
				if (ratoTpszDp01[i] != null)
					model.setRatoTpszDp01(ratoTpszDp01[i]);
				if (ratoTpszDp02[i] != null)
					model.setRatoTpszDp02(ratoTpszDp02[i]);
				if (ratoTpszDp03[i] != null)
					model.setRatoTpszDp03(ratoTpszDp03[i]);
				if (ratoTpszDp04[i] != null)
					model.setRatoTpszDp04(ratoTpszDp04[i]);
				if (ratoTpszDp05[i] != null)
					model.setRatoTpszDp05(ratoTpszDp05[i]);
				if (ratoTpszDp06[i] != null)
					model.setRatoTpszDp06(ratoTpszDp06[i]);
				if (pEqKndCd[i] != null)
					model.setPEqKndCd(pEqKndCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (qutaTpszDp30[i] != null)
					model.setQutaTpszDp30(qutaTpszDp30[i]);
				if (pfmcTpszDp19[i] != null)
					model.setPfmcTpszDp19(pfmcTpszDp19[i]);
				if (pfmcTpszDp18[i] != null)
					model.setPfmcTpszDp18(pfmcTpszDp18[i]);
				if (pfmcTpszDp17[i] != null)
					model.setPfmcTpszDp17(pfmcTpszDp17[i]);
				if (pfmcTpszDp16[i] != null)
					model.setPfmcTpszDp16(pfmcTpszDp16[i]);
				if (ratoTpszDp29[i] != null)
					model.setRatoTpszDp29(ratoTpszDp29[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pOfcCd[i] != null)
					model.setPOfcCd(pOfcCd[i]);
				if (ratoTpszDp30[i] != null)
					model.setRatoTpszDp30(ratoTpszDp30[i]);
				if (qutaTpszDp22[i] != null)
					model.setQutaTpszDp22(qutaTpszDp22[i]);
				if (pfmcTpszDp25[i] != null)
					model.setPfmcTpszDp25(pfmcTpszDp25[i]);
				if (qutaTpszDp23[i] != null)
					model.setQutaTpszDp23(qutaTpszDp23[i]);
				if (pfmcTpszDp26[i] != null)
					model.setPfmcTpszDp26(pfmcTpszDp26[i]);
				if (pfmcTpszDp23[i] != null)
					model.setPfmcTpszDp23(pfmcTpszDp23[i]);
				if (qutaTpszDp24[i] != null)
					model.setQutaTpszDp24(qutaTpszDp24[i]);
				if (pfmcTpszDp24[i] != null)
					model.setPfmcTpszDp24(pfmcTpszDp24[i]);
				if (qutaTpszDp25[i] != null)
					model.setQutaTpszDp25(qutaTpszDp25[i]);
				if (pfmcTpszDp21[i] != null)
					model.setPfmcTpszDp21(pfmcTpszDp21[i]);
				if (qutaTpszDp26[i] != null)
					model.setQutaTpszDp26(qutaTpszDp26[i]);
				if (pfmcTpszDp22[i] != null)
					model.setPfmcTpszDp22(pfmcTpszDp22[i]);
				if (qutaTpszDp27[i] != null)
					model.setQutaTpszDp27(qutaTpszDp27[i]);
				if (qutaTpszDp28[i] != null)
					model.setQutaTpszDp28(qutaTpszDp28[i]);
				if (qutaTpszDp29[i] != null)
					model.setQutaTpszDp29(qutaTpszDp29[i]);
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
				if (ratoTpszDp19[i] != null)
					model.setRatoTpszDp19(ratoTpszDp19[i]);
				if (ratoTpszDp18[i] != null)
					model.setRatoTpszDp18(ratoTpszDp18[i]);
				if (pCustCd[i] != null)
					model.setPCustCd(pCustCd[i]);
				if (ratoTpszDp25[i] != null)
					model.setRatoTpszDp25(ratoTpszDp25[i]);
				if (ratoTpszDp26[i] != null)
					model.setRatoTpszDp26(ratoTpszDp26[i]);
				if (ratoTpszDp27[i] != null)
					model.setRatoTpszDp27(ratoTpszDp27[i]);
				if (ratoTpszDp28[i] != null)
					model.setRatoTpszDp28(ratoTpszDp28[i]);
				if (ratoTpszDp21[i] != null)
					model.setRatoTpszDp21(ratoTpszDp21[i]);
				if (ratoTpszDp22[i] != null)
					model.setRatoTpszDp22(ratoTpszDp22[i]);
				if (ratoTpszDp23[i] != null)
					model.setRatoTpszDp23(ratoTpszDp23[i]);
				if (ratoTpszDp24[i] != null)
					model.setRatoTpszDp24(ratoTpszDp24[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
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
		return getDisposalPFMCByOfficeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalPFMCByOfficeVO[]
	 */
	public DisposalPFMCByOfficeVO[] getDisposalPFMCByOfficeVOs(){
		DisposalPFMCByOfficeVO[] vos = (DisposalPFMCByOfficeVO[])models.toArray(new DisposalPFMCByOfficeVO[models.size()]);
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
		this.qutaTpszDp07 = this.qutaTpszDp07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp06 = this.qutaTpszDp06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp05 = this.qutaTpszDp05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp04 = this.qutaTpszDp04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp03 = this.qutaTpszDp03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp02 = this.qutaTpszDp02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp01 = this.qutaTpszDp01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp00 = this.qutaTpszDp00 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEndEvntDt = this.pEndEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp09 = this.qutaTpszDp09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp08 = this.qutaTpszDp08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp10 = this.qutaTpszDp10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp16 = this.qutaTpszDp16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp15 = this.qutaTpszDp15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp18 = this.qutaTpszDp18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp17 = this.qutaTpszDp17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp12 = this.qutaTpszDp12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp11 = this.qutaTpszDp11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp14 = this.qutaTpszDp14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp13 = this.qutaTpszDp13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp27 = this.pfmcTpszDp27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp28 = this.pfmcTpszDp28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp29 = this.pfmcTpszDp29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDispTpCd = this.pDispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDispRsnCd = this.pDispRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltTpSeq = this.rsltTpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp19 = this.qutaTpszDp19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp30 = this.pfmcTpszDp30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp21 = this.qutaTpszDp21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltTpNm = this.rsltTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp09 = this.ratoTpszDp09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp08 = this.ratoTpszDp08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp07 = this.ratoTpszDp07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp12 = this.ratoTpszDp12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp13 = this.ratoTpszDp13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp10 = this.ratoTpszDp10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp11 = this.ratoTpszDp11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp16 = this.ratoTpszDp16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp17 = this.ratoTpszDp17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp14 = this.ratoTpszDp14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp15 = this.ratoTpszDp15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp00 = this.pfmcTpszDp00 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp03 = this.pfmcTpszDp03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp04 = this.pfmcTpszDp04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pRhqCd = this.pRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp01 = this.pfmcTpszDp01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp02 = this.pfmcTpszDp02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pStrEvntDt = this.pStrEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp00 = this.ratoTpszDp00 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp01 = this.ratoTpszDp01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp02 = this.ratoTpszDp02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp03 = this.ratoTpszDp03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp04 = this.ratoTpszDp04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp05 = this.ratoTpszDp05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp06 = this.ratoTpszDp06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEqKndCd = this.pEqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp30 = this.qutaTpszDp30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp19 = this.pfmcTpszDp19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp18 = this.pfmcTpszDp18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp17 = this.pfmcTpszDp17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp16 = this.pfmcTpszDp16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp29 = this.ratoTpszDp29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pOfcCd = this.pOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp30 = this.ratoTpszDp30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp22 = this.qutaTpszDp22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp25 = this.pfmcTpszDp25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp23 = this.qutaTpszDp23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp26 = this.pfmcTpszDp26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp23 = this.pfmcTpszDp23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp24 = this.qutaTpszDp24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp24 = this.pfmcTpszDp24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp25 = this.qutaTpszDp25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp21 = this.pfmcTpszDp21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp26 = this.qutaTpszDp26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp22 = this.pfmcTpszDp22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp27 = this.qutaTpszDp27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp28 = this.qutaTpszDp28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qutaTpszDp29 = this.qutaTpszDp29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp09 = this.pfmcTpszDp09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp06 = this.pfmcTpszDp06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp05 = this.pfmcTpszDp05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp08 = this.pfmcTpszDp08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp07 = this.pfmcTpszDp07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp19 = this.ratoTpszDp19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp18 = this.ratoTpszDp18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCustCd = this.pCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp25 = this.ratoTpszDp25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp26 = this.ratoTpszDp26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp27 = this.ratoTpszDp27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp28 = this.ratoTpszDp28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp21 = this.ratoTpszDp21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp22 = this.ratoTpszDp22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp23 = this.ratoTpszDp23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratoTpszDp24 = this.ratoTpszDp24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp12 = this.pfmcTpszDp12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp13 = this.pfmcTpszDp13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp14 = this.pfmcTpszDp14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp15 = this.pfmcTpszDp15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp10 = this.pfmcTpszDp10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTpszDp11 = this.pfmcTpszDp11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
