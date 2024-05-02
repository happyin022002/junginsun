/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MGSInventoryDtlMGTVO.java
*@FileTitle : MGSInventoryDtlMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.11.23 조재성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSInventoryDtlMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSInventoryDtlMGTVO> models = new ArrayList<MGSInventoryDtlMGTVO>();
	
	/* Column Info */
	private String newAgmtOfcCtyCd = null;
	/* Column Info */
	private String oldAgmtOfcCtyCd = null;
	/* Column Info */
	private String stsEvntDtFr = null;
	/* Column Info */
	private String lsdays = null;
	/* Column Info */
	private String sCrntLocCd = null;
	/* Column Info */
	private String s1InqFmDys = null;
	/* Column Info */
	private String s2Group1 = null;
	/* Column Info */
	private String newAgmtSeq = null;
	/* Column Info */
	private String sEqTpszCd = null;
	/* Column Info */
	private String sAgmtLstmCd = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String newAgmtNo = null;
	/* Column Info */
	private String s2LocCd = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String s2Group1Val = null;
	/* Column Info */
	private String sLocation = null;
	/* Column Info */
	private String s2AgmtLstmCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String s2AgmtNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String programId = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String sAciacDivCd = null;
	/* Column Info */
	private String s1InqToDys = null;
	/* Column Info */
	private String oldAgmtNo = null;
	/* Column Info */
	private String stsEvntDtTo = null;
	/* Column Info */
	private String s2AgmtRefNo = null;
	/* Column Info */
	private String stsEvntOfcCd = null;
	/* Column Info */
	private String atchBare = null;
	/* Column Info */
	private String s2EqTpszCd = null;
	/* Column Info */
	private String mvmtDate = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String mvmt = null;
	/* Column Info */
	private String sVndrSeq = null;
	/* Column Info */
	private String sCrntOfcCd = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String oldAgmtSeq = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String sCrntYdCd = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String dmgSnd = null;
	/* Column Info */
	private String sGroup1Val = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String s3Gtotal = null;
	/* Column Info */
	private String sGroup1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MGSInventoryDtlMGTVO() {}

	public MGSInventoryDtlMGTVO(String ibflag, String pagerows, String programId, String eqKndCd, String stsEvntDtFr, String stsEvntDtTo, String stsEvntOfcCd, String oldAgmtOfcCtyCd, String oldAgmtSeq, String oldAgmtNo, String newAgmtOfcCtyCd, String newAgmtSeq, String newAgmtNo, String eqNo, String eqTpszCd, String agmtLstmCd, String agmtNo, String vndrAbbrNm, String chssNo, String cntrNo, String lccCd, String sccCd, String crntYdCd, String mvmt, String mvmtDate, String lsdays, String sLocation, String sCrntLocCd, String sCrntYdCd, String sAciacDivCd, String sEqTpszCd, String sGroup1, String sGroup1Val, String s2Group1, String s2Group1Val, String s2AgmtLstmCd, String s2EqTpszCd, String sCrntOfcCd, String sVndrSeq, String sAgmtLstmCd, String s2AgmtNo, String s2AgmtRefNo, String s1InqFmDys, String s1InqToDys, String s2LocCd, String s3Gtotal, String atchBare, String dmgSnd) {
		this.newAgmtOfcCtyCd = newAgmtOfcCtyCd;
		this.oldAgmtOfcCtyCd = oldAgmtOfcCtyCd;
		this.stsEvntDtFr = stsEvntDtFr;
		this.lsdays = lsdays;
		this.sCrntLocCd = sCrntLocCd;
		this.s1InqFmDys = s1InqFmDys;
		this.s2Group1 = s2Group1;
		this.newAgmtSeq = newAgmtSeq;
		this.sEqTpszCd = sEqTpszCd;
		this.sAgmtLstmCd = sAgmtLstmCd;
		this.chssNo = chssNo;
		this.newAgmtNo = newAgmtNo;
		this.s2LocCd = s2LocCd;
		this.crntYdCd = crntYdCd;
		this.s2Group1Val = s2Group1Val;
		this.sLocation = sLocation;
		this.s2AgmtLstmCd = s2AgmtLstmCd;
		this.pagerows = pagerows;
		this.s2AgmtNo = s2AgmtNo;
		this.ibflag = ibflag;
		this.programId = programId;
		this.eqNo = eqNo;
		this.sAciacDivCd = sAciacDivCd;
		this.s1InqToDys = s1InqToDys;
		this.oldAgmtNo = oldAgmtNo;
		this.stsEvntDtTo = stsEvntDtTo;
		this.s2AgmtRefNo = s2AgmtRefNo;
		this.stsEvntOfcCd = stsEvntOfcCd;
		this.atchBare = atchBare;
		this.s2EqTpszCd = s2EqTpszCd;
		this.mvmtDate = mvmtDate;
		this.agmtNo = agmtNo;
		this.mvmt = mvmt;
		this.sVndrSeq = sVndrSeq;
		this.sCrntOfcCd = sCrntOfcCd;
		this.agmtLstmCd = agmtLstmCd;
		this.eqKndCd = eqKndCd;
		this.oldAgmtSeq = oldAgmtSeq;
		this.eqTpszCd = eqTpszCd;
		this.sCrntYdCd = sCrntYdCd;
		this.lccCd = lccCd;
		this.dmgSnd = dmgSnd;
		this.sGroup1Val = sGroup1Val;
		this.sccCd = sccCd;
		this.cntrNo = cntrNo;
		this.vndrAbbrNm = vndrAbbrNm;
		this.s3Gtotal = s3Gtotal;
		this.sGroup1 = sGroup1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("new_agmt_ofc_cty_cd", getNewAgmtOfcCtyCd());
		this.hashColumns.put("old_agmt_ofc_cty_cd", getOldAgmtOfcCtyCd());
		this.hashColumns.put("sts_evnt_dt_fr", getStsEvntDtFr());
		this.hashColumns.put("lsdays", getLsdays());
		this.hashColumns.put("s_crnt_loc_cd", getSCrntLocCd());
		this.hashColumns.put("s1_inq_fm_dys", getS1InqFmDys());
		this.hashColumns.put("s2_group1", getS2Group1());
		this.hashColumns.put("new_agmt_seq", getNewAgmtSeq());
		this.hashColumns.put("s_eq_tpsz_cd", getSEqTpszCd());
		this.hashColumns.put("s_agmt_lstm_cd", getSAgmtLstmCd());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("new_agmt_no", getNewAgmtNo());
		this.hashColumns.put("s2_loc_cd", getS2LocCd());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("s2_group1_val", getS2Group1Val());
		this.hashColumns.put("s_location", getSLocation());
		this.hashColumns.put("s2_agmt_lstm_cd", getS2AgmtLstmCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s2_agmt_no", getS2AgmtNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("program_id", getProgramId());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("s_aciac_div_cd", getSAciacDivCd());
		this.hashColumns.put("s1_inq_to_dys", getS1InqToDys());
		this.hashColumns.put("old_agmt_no", getOldAgmtNo());
		this.hashColumns.put("sts_evnt_dt_to", getStsEvntDtTo());
		this.hashColumns.put("s2_agmt_ref_no", getS2AgmtRefNo());
		this.hashColumns.put("sts_evnt_ofc_cd", getStsEvntOfcCd());
		this.hashColumns.put("atch_bare", getAtchBare());
		this.hashColumns.put("s2_eq_tpsz_cd", getS2EqTpszCd());
		this.hashColumns.put("mvmt_date", getMvmtDate());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("mvmt", getMvmt());
		this.hashColumns.put("s_vndr_seq", getSVndrSeq());
		this.hashColumns.put("s_crnt_ofc_cd", getSCrntOfcCd());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("old_agmt_seq", getOldAgmtSeq());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("s_crnt_yd_cd", getSCrntYdCd());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("dmg_snd", getDmgSnd());
		this.hashColumns.put("s_group1_val", getSGroup1Val());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("s3_gtotal", getS3Gtotal());
		this.hashColumns.put("s_group1", getSGroup1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("new_agmt_ofc_cty_cd", "newAgmtOfcCtyCd");
		this.hashFields.put("old_agmt_ofc_cty_cd", "oldAgmtOfcCtyCd");
		this.hashFields.put("sts_evnt_dt_fr", "stsEvntDtFr");
		this.hashFields.put("lsdays", "lsdays");
		this.hashFields.put("s_crnt_loc_cd", "sCrntLocCd");
		this.hashFields.put("s1_inq_fm_dys", "s1InqFmDys");
		this.hashFields.put("s2_group1", "s2Group1");
		this.hashFields.put("new_agmt_seq", "newAgmtSeq");
		this.hashFields.put("s_eq_tpsz_cd", "sEqTpszCd");
		this.hashFields.put("s_agmt_lstm_cd", "sAgmtLstmCd");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("new_agmt_no", "newAgmtNo");
		this.hashFields.put("s2_loc_cd", "s2LocCd");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("s2_group1_val", "s2Group1Val");
		this.hashFields.put("s_location", "sLocation");
		this.hashFields.put("s2_agmt_lstm_cd", "s2AgmtLstmCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s2_agmt_no", "s2AgmtNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("program_id", "programId");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("s_aciac_div_cd", "sAciacDivCd");
		this.hashFields.put("s1_inq_to_dys", "s1InqToDys");
		this.hashFields.put("old_agmt_no", "oldAgmtNo");
		this.hashFields.put("sts_evnt_dt_to", "stsEvntDtTo");
		this.hashFields.put("s2_agmt_ref_no", "s2AgmtRefNo");
		this.hashFields.put("sts_evnt_ofc_cd", "stsEvntOfcCd");
		this.hashFields.put("atch_bare", "atchBare");
		this.hashFields.put("s2_eq_tpsz_cd", "s2EqTpszCd");
		this.hashFields.put("mvmt_date", "mvmtDate");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("mvmt", "mvmt");
		this.hashFields.put("s_vndr_seq", "sVndrSeq");
		this.hashFields.put("s_crnt_ofc_cd", "sCrntOfcCd");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("old_agmt_seq", "oldAgmtSeq");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("s_crnt_yd_cd", "sCrntYdCd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("dmg_snd", "dmgSnd");
		this.hashFields.put("s_group1_val", "sGroup1Val");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("s3_gtotal", "s3Gtotal");
		this.hashFields.put("s_group1", "sGroup1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return newAgmtOfcCtyCd
	 */
	public String getNewAgmtOfcCtyCd() {
		return this.newAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return oldAgmtOfcCtyCd
	 */
	public String getOldAgmtOfcCtyCd() {
		return this.oldAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return stsEvntDtFr
	 */
	public String getStsEvntDtFr() {
		return this.stsEvntDtFr;
	}
	
	/**
	 * Column Info
	 * @return lsdays
	 */
	public String getLsdays() {
		return this.lsdays;
	}
	
	/**
	 * Column Info
	 * @return sCrntLocCd
	 */
	public String getSCrntLocCd() {
		return this.sCrntLocCd;
	}
	
	/**
	 * Column Info
	 * @return s1InqFmDys
	 */
	public String getS1InqFmDys() {
		return this.s1InqFmDys;
	}
	
	/**
	 * Column Info
	 * @return s2Group1
	 */
	public String getS2Group1() {
		return this.s2Group1;
	}
	
	/**
	 * Column Info
	 * @return newAgmtSeq
	 */
	public String getNewAgmtSeq() {
		return this.newAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return sEqTpszCd
	 */
	public String getSEqTpszCd() {
		return this.sEqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return sAgmtLstmCd
	 */
	public String getSAgmtLstmCd() {
		return this.sAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return newAgmtNo
	 */
	public String getNewAgmtNo() {
		return this.newAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return s2LocCd
	 */
	public String getS2LocCd() {
		return this.s2LocCd;
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
	 * @return s2Group1Val
	 */
	public String getS2Group1Val() {
		return this.s2Group1Val;
	}
	
	/**
	 * Column Info
	 * @return sLocation
	 */
	public String getSLocation() {
		return this.sLocation;
	}
	
	/**
	 * Column Info
	 * @return s2AgmtLstmCd
	 */
	public String getS2AgmtLstmCd() {
		return this.s2AgmtLstmCd;
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
	 * @return s2AgmtNo
	 */
	public String getS2AgmtNo() {
		return this.s2AgmtNo;
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
	 * @return programId
	 */
	public String getProgramId() {
		return this.programId;
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
	 * @return sAciacDivCd
	 */
	public String getSAciacDivCd() {
		return this.sAciacDivCd;
	}
	
	/**
	 * Column Info
	 * @return s1InqToDys
	 */
	public String getS1InqToDys() {
		return this.s1InqToDys;
	}
	
	/**
	 * Column Info
	 * @return oldAgmtNo
	 */
	public String getOldAgmtNo() {
		return this.oldAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return stsEvntDtTo
	 */
	public String getStsEvntDtTo() {
		return this.stsEvntDtTo;
	}
	
	/**
	 * Column Info
	 * @return s2AgmtRefNo
	 */
	public String getS2AgmtRefNo() {
		return this.s2AgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return stsEvntOfcCd
	 */
	public String getStsEvntOfcCd() {
		return this.stsEvntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return atchBare
	 */
	public String getAtchBare() {
		return this.atchBare;
	}
	
	/**
	 * Column Info
	 * @return s2EqTpszCd
	 */
	public String getS2EqTpszCd() {
		return this.s2EqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtDate
	 */
	public String getMvmtDate() {
		return this.mvmtDate;
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
	 * @return mvmt
	 */
	public String getMvmt() {
		return this.mvmt;
	}
	
	/**
	 * Column Info
	 * @return sVndrSeq
	 */
	public String getSVndrSeq() {
		return this.sVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return sCrntOfcCd
	 */
	public String getSCrntOfcCd() {
		return this.sCrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return agmtLstmCd
	 */
	public String getAgmtLstmCd() {
		return this.agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return oldAgmtSeq
	 */
	public String getOldAgmtSeq() {
		return this.oldAgmtSeq;
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
	 * @return sCrntYdCd
	 */
	public String getSCrntYdCd() {
		return this.sCrntYdCd;
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
	 * @return dmgSnd
	 */
	public String getDmgSnd() {
		return this.dmgSnd;
	}
	
	/**
	 * Column Info
	 * @return sGroup1Val
	 */
	public String getSGroup1Val() {
		return this.sGroup1Val;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return s3Gtotal
	 */
	public String getS3Gtotal() {
		return this.s3Gtotal;
	}
	
	/**
	 * Column Info
	 * @return sGroup1
	 */
	public String getSGroup1() {
		return this.sGroup1;
	}
	

	/**
	 * Column Info
	 * @param newAgmtOfcCtyCd
	 */
	public void setNewAgmtOfcCtyCd(String newAgmtOfcCtyCd) {
		this.newAgmtOfcCtyCd = newAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param oldAgmtOfcCtyCd
	 */
	public void setOldAgmtOfcCtyCd(String oldAgmtOfcCtyCd) {
		this.oldAgmtOfcCtyCd = oldAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param stsEvntDtFr
	 */
	public void setStsEvntDtFr(String stsEvntDtFr) {
		this.stsEvntDtFr = stsEvntDtFr;
	}
	
	/**
	 * Column Info
	 * @param lsdays
	 */
	public void setLsdays(String lsdays) {
		this.lsdays = lsdays;
	}
	
	/**
	 * Column Info
	 * @param sCrntLocCd
	 */
	public void setSCrntLocCd(String sCrntLocCd) {
		this.sCrntLocCd = sCrntLocCd;
	}
	
	/**
	 * Column Info
	 * @param s1InqFmDys
	 */
	public void setS1InqFmDys(String s1InqFmDys) {
		this.s1InqFmDys = s1InqFmDys;
	}
	
	/**
	 * Column Info
	 * @param s2Group1
	 */
	public void setS2Group1(String s2Group1) {
		this.s2Group1 = s2Group1;
	}
	
	/**
	 * Column Info
	 * @param newAgmtSeq
	 */
	public void setNewAgmtSeq(String newAgmtSeq) {
		this.newAgmtSeq = newAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param sEqTpszCd
	 */
	public void setSEqTpszCd(String sEqTpszCd) {
		this.sEqTpszCd = sEqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param sAgmtLstmCd
	 */
	public void setSAgmtLstmCd(String sAgmtLstmCd) {
		this.sAgmtLstmCd = sAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param newAgmtNo
	 */
	public void setNewAgmtNo(String newAgmtNo) {
		this.newAgmtNo = newAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param s2LocCd
	 */
	public void setS2LocCd(String s2LocCd) {
		this.s2LocCd = s2LocCd;
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
	 * @param s2Group1Val
	 */
	public void setS2Group1Val(String s2Group1Val) {
		this.s2Group1Val = s2Group1Val;
	}
	
	/**
	 * Column Info
	 * @param sLocation
	 */
	public void setSLocation(String sLocation) {
		this.sLocation = sLocation;
	}
	
	/**
	 * Column Info
	 * @param s2AgmtLstmCd
	 */
	public void setS2AgmtLstmCd(String s2AgmtLstmCd) {
		this.s2AgmtLstmCd = s2AgmtLstmCd;
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
	 * @param s2AgmtNo
	 */
	public void setS2AgmtNo(String s2AgmtNo) {
		this.s2AgmtNo = s2AgmtNo;
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
	 * @param programId
	 */
	public void setProgramId(String programId) {
		this.programId = programId;
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
	 * @param sAciacDivCd
	 */
	public void setSAciacDivCd(String sAciacDivCd) {
		this.sAciacDivCd = sAciacDivCd;
	}
	
	/**
	 * Column Info
	 * @param s1InqToDys
	 */
	public void setS1InqToDys(String s1InqToDys) {
		this.s1InqToDys = s1InqToDys;
	}
	
	/**
	 * Column Info
	 * @param oldAgmtNo
	 */
	public void setOldAgmtNo(String oldAgmtNo) {
		this.oldAgmtNo = oldAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param stsEvntDtTo
	 */
	public void setStsEvntDtTo(String stsEvntDtTo) {
		this.stsEvntDtTo = stsEvntDtTo;
	}
	
	/**
	 * Column Info
	 * @param s2AgmtRefNo
	 */
	public void setS2AgmtRefNo(String s2AgmtRefNo) {
		this.s2AgmtRefNo = s2AgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param stsEvntOfcCd
	 */
	public void setStsEvntOfcCd(String stsEvntOfcCd) {
		this.stsEvntOfcCd = stsEvntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param atchBare
	 */
	public void setAtchBare(String atchBare) {
		this.atchBare = atchBare;
	}
	
	/**
	 * Column Info
	 * @param s2EqTpszCd
	 */
	public void setS2EqTpszCd(String s2EqTpszCd) {
		this.s2EqTpszCd = s2EqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtDate
	 */
	public void setMvmtDate(String mvmtDate) {
		this.mvmtDate = mvmtDate;
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
	 * @param mvmt
	 */
	public void setMvmt(String mvmt) {
		this.mvmt = mvmt;
	}
	
	/**
	 * Column Info
	 * @param sVndrSeq
	 */
	public void setSVndrSeq(String sVndrSeq) {
		this.sVndrSeq = sVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param sCrntOfcCd
	 */
	public void setSCrntOfcCd(String sCrntOfcCd) {
		this.sCrntOfcCd = sCrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param agmtLstmCd
	 */
	public void setAgmtLstmCd(String agmtLstmCd) {
		this.agmtLstmCd = agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param oldAgmtSeq
	 */
	public void setOldAgmtSeq(String oldAgmtSeq) {
		this.oldAgmtSeq = oldAgmtSeq;
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
	 * @param sCrntYdCd
	 */
	public void setSCrntYdCd(String sCrntYdCd) {
		this.sCrntYdCd = sCrntYdCd;
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
	 * @param dmgSnd
	 */
	public void setDmgSnd(String dmgSnd) {
		this.dmgSnd = dmgSnd;
	}
	
	/**
	 * Column Info
	 * @param sGroup1Val
	 */
	public void setSGroup1Val(String sGroup1Val) {
		this.sGroup1Val = sGroup1Val;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param s3Gtotal
	 */
	public void setS3Gtotal(String s3Gtotal) {
		this.s3Gtotal = s3Gtotal;
	}
	
	/**
	 * Column Info
	 * @param sGroup1
	 */
	public void setSGroup1(String sGroup1) {
		this.sGroup1 = sGroup1;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNewAgmtOfcCtyCd(JSPUtil.getParameter(request, "new_agmt_ofc_cty_cd", ""));
		setOldAgmtOfcCtyCd(JSPUtil.getParameter(request, "old_agmt_ofc_cty_cd", ""));
		setStsEvntDtFr(JSPUtil.getParameter(request, "sts_evnt_dt_fr", ""));
		setLsdays(JSPUtil.getParameter(request, "lsdays", ""));
		setSCrntLocCd(JSPUtil.getParameter(request, "s_crnt_loc_cd", ""));
		setS1InqFmDys(JSPUtil.getParameter(request, "s1_inq_fm_dys", ""));
		setS2Group1(JSPUtil.getParameter(request, "s2_group1", ""));
		setNewAgmtSeq(JSPUtil.getParameter(request, "new_agmt_seq", ""));
		setSEqTpszCd(JSPUtil.getParameter(request, "s_eq_tpsz_cd", ""));
		setSAgmtLstmCd(JSPUtil.getParameter(request, "s_agmt_lstm_cd", ""));
		setChssNo(JSPUtil.getParameter(request, "chss_no", ""));
		setNewAgmtNo(JSPUtil.getParameter(request, "new_agmt_no", ""));
		setS2LocCd(JSPUtil.getParameter(request, "s2_loc_cd", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setS2Group1Val(JSPUtil.getParameter(request, "s2_group1_val", ""));
		setSLocation(JSPUtil.getParameter(request, "s_location", ""));
		setS2AgmtLstmCd(JSPUtil.getParameter(request, "s2_agmt_lstm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setS2AgmtNo(JSPUtil.getParameter(request, "s2_agmt_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setProgramId(JSPUtil.getParameter(request, "program_id", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setSAciacDivCd(JSPUtil.getParameter(request, "s_aciac_div_cd", ""));
		setS1InqToDys(JSPUtil.getParameter(request, "s1_inq_to_dys", ""));
		setOldAgmtNo(JSPUtil.getParameter(request, "old_agmt_no", ""));
		setStsEvntDtTo(JSPUtil.getParameter(request, "sts_evnt_dt_to", ""));
		setS2AgmtRefNo(JSPUtil.getParameter(request, "s2_agmt_ref_no", ""));
		setStsEvntOfcCd(JSPUtil.getParameter(request, "sts_evnt_ofc_cd", ""));
		setAtchBare(JSPUtil.getParameter(request, "atch_bare", ""));
		setS2EqTpszCd(JSPUtil.getParameter(request, "s2_eq_tpsz_cd", ""));
		setMvmtDate(JSPUtil.getParameter(request, "mvmt_date", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setMvmt(JSPUtil.getParameter(request, "mvmt", ""));
		setSVndrSeq(JSPUtil.getParameter(request, "s_vndr_seq", ""));
		setSCrntOfcCd(JSPUtil.getParameter(request, "s_crnt_ofc_cd", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setOldAgmtSeq(JSPUtil.getParameter(request, "old_agmt_seq", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setSCrntYdCd(JSPUtil.getParameter(request, "s_crnt_yd_cd", ""));
		setLccCd(JSPUtil.getParameter(request, "lcc_cd", ""));
		setDmgSnd(JSPUtil.getParameter(request, "dmg_snd", ""));
		setSGroup1Val(JSPUtil.getParameter(request, "s_group1_val", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setS3Gtotal(JSPUtil.getParameter(request, "s3_gtotal", ""));
		setSGroup1(JSPUtil.getParameter(request, "s_group1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MGSInventoryDtlMGTVO[]
	 */
	public MGSInventoryDtlMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MGSInventoryDtlMGTVO[]
	 */
	public MGSInventoryDtlMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSInventoryDtlMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] newAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "new_agmt_ofc_cty_cd", length));
			String[] oldAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "old_agmt_ofc_cty_cd", length));
			String[] stsEvntDtFr = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_dt_fr", length));
			String[] lsdays = (JSPUtil.getParameter(request, prefix	+ "lsdays", length));
			String[] sCrntLocCd = (JSPUtil.getParameter(request, prefix	+ "s_crnt_loc_cd", length));
			String[] s1InqFmDys = (JSPUtil.getParameter(request, prefix	+ "s1_inq_fm_dys", length));
			String[] s2Group1 = (JSPUtil.getParameter(request, prefix	+ "s2_group1", length));
			String[] newAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "new_agmt_seq", length));
			String[] sEqTpszCd = (JSPUtil.getParameter(request, prefix	+ "s_eq_tpsz_cd", length));
			String[] sAgmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "s_agmt_lstm_cd", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] newAgmtNo = (JSPUtil.getParameter(request, prefix	+ "new_agmt_no", length));
			String[] s2LocCd = (JSPUtil.getParameter(request, prefix	+ "s2_loc_cd", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] s2Group1Val = (JSPUtil.getParameter(request, prefix	+ "s2_group1_val", length));
			String[] sLocation = (JSPUtil.getParameter(request, prefix	+ "s_location", length));
			String[] s2AgmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "s2_agmt_lstm_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] s2AgmtNo = (JSPUtil.getParameter(request, prefix	+ "s2_agmt_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] programId = (JSPUtil.getParameter(request, prefix	+ "program_id", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] sAciacDivCd = (JSPUtil.getParameter(request, prefix	+ "s_aciac_div_cd", length));
			String[] s1InqToDys = (JSPUtil.getParameter(request, prefix	+ "s1_inq_to_dys", length));
			String[] oldAgmtNo = (JSPUtil.getParameter(request, prefix	+ "old_agmt_no", length));
			String[] stsEvntDtTo = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_dt_to", length));
			String[] s2AgmtRefNo = (JSPUtil.getParameter(request, prefix	+ "s2_agmt_ref_no", length));
			String[] stsEvntOfcCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_ofc_cd", length));
			String[] atchBare = (JSPUtil.getParameter(request, prefix	+ "atch_bare", length));
			String[] s2EqTpszCd = (JSPUtil.getParameter(request, prefix	+ "s2_eq_tpsz_cd", length));
			String[] mvmtDate = (JSPUtil.getParameter(request, prefix	+ "mvmt_date", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] mvmt = (JSPUtil.getParameter(request, prefix	+ "mvmt", length));
			String[] sVndrSeq = (JSPUtil.getParameter(request, prefix	+ "s_vndr_seq", length));
			String[] sCrntOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_crnt_ofc_cd", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] oldAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "old_agmt_seq", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] sCrntYdCd = (JSPUtil.getParameter(request, prefix	+ "s_crnt_yd_cd", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] dmgSnd = (JSPUtil.getParameter(request, prefix	+ "dmg_snd", length));
			String[] sGroup1Val = (JSPUtil.getParameter(request, prefix	+ "s_group1_val", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] s3Gtotal = (JSPUtil.getParameter(request, prefix	+ "s3_gtotal", length));
			String[] sGroup1 = (JSPUtil.getParameter(request, prefix	+ "s_group1", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSInventoryDtlMGTVO();
				if (newAgmtOfcCtyCd[i] != null)
					model.setNewAgmtOfcCtyCd(newAgmtOfcCtyCd[i]);
				if (oldAgmtOfcCtyCd[i] != null)
					model.setOldAgmtOfcCtyCd(oldAgmtOfcCtyCd[i]);
				if (stsEvntDtFr[i] != null)
					model.setStsEvntDtFr(stsEvntDtFr[i]);
				if (lsdays[i] != null)
					model.setLsdays(lsdays[i]);
				if (sCrntLocCd[i] != null)
					model.setSCrntLocCd(sCrntLocCd[i]);
				if (s1InqFmDys[i] != null)
					model.setS1InqFmDys(s1InqFmDys[i]);
				if (s2Group1[i] != null)
					model.setS2Group1(s2Group1[i]);
				if (newAgmtSeq[i] != null)
					model.setNewAgmtSeq(newAgmtSeq[i]);
				if (sEqTpszCd[i] != null)
					model.setSEqTpszCd(sEqTpszCd[i]);
				if (sAgmtLstmCd[i] != null)
					model.setSAgmtLstmCd(sAgmtLstmCd[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (newAgmtNo[i] != null)
					model.setNewAgmtNo(newAgmtNo[i]);
				if (s2LocCd[i] != null)
					model.setS2LocCd(s2LocCd[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (s2Group1Val[i] != null)
					model.setS2Group1Val(s2Group1Val[i]);
				if (sLocation[i] != null)
					model.setSLocation(sLocation[i]);
				if (s2AgmtLstmCd[i] != null)
					model.setS2AgmtLstmCd(s2AgmtLstmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (s2AgmtNo[i] != null)
					model.setS2AgmtNo(s2AgmtNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (programId[i] != null)
					model.setProgramId(programId[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (sAciacDivCd[i] != null)
					model.setSAciacDivCd(sAciacDivCd[i]);
				if (s1InqToDys[i] != null)
					model.setS1InqToDys(s1InqToDys[i]);
				if (oldAgmtNo[i] != null)
					model.setOldAgmtNo(oldAgmtNo[i]);
				if (stsEvntDtTo[i] != null)
					model.setStsEvntDtTo(stsEvntDtTo[i]);
				if (s2AgmtRefNo[i] != null)
					model.setS2AgmtRefNo(s2AgmtRefNo[i]);
				if (stsEvntOfcCd[i] != null)
					model.setStsEvntOfcCd(stsEvntOfcCd[i]);
				if (atchBare[i] != null)
					model.setAtchBare(atchBare[i]);
				if (s2EqTpszCd[i] != null)
					model.setS2EqTpszCd(s2EqTpszCd[i]);
				if (mvmtDate[i] != null)
					model.setMvmtDate(mvmtDate[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (mvmt[i] != null)
					model.setMvmt(mvmt[i]);
				if (sVndrSeq[i] != null)
					model.setSVndrSeq(sVndrSeq[i]);
				if (sCrntOfcCd[i] != null)
					model.setSCrntOfcCd(sCrntOfcCd[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (oldAgmtSeq[i] != null)
					model.setOldAgmtSeq(oldAgmtSeq[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (sCrntYdCd[i] != null)
					model.setSCrntYdCd(sCrntYdCd[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (dmgSnd[i] != null)
					model.setDmgSnd(dmgSnd[i]);
				if (sGroup1Val[i] != null)
					model.setSGroup1Val(sGroup1Val[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (s3Gtotal[i] != null)
					model.setS3Gtotal(s3Gtotal[i]);
				if (sGroup1[i] != null)
					model.setSGroup1(sGroup1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMGSInventoryDtlMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MGSInventoryDtlMGTVO[]
	 */
	public MGSInventoryDtlMGTVO[] getMGSInventoryDtlMGTVOs(){
		MGSInventoryDtlMGTVO[] vos = (MGSInventoryDtlMGTVO[])models.toArray(new MGSInventoryDtlMGTVO[models.size()]);
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
		this.newAgmtOfcCtyCd = this.newAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtOfcCtyCd = this.oldAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDtFr = this.stsEvntDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsdays = this.lsdays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCrntLocCd = this.sCrntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s1InqFmDys = this.s1InqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Group1 = this.s2Group1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtSeq = this.newAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqTpszCd = this.sEqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAgmtLstmCd = this.sAgmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtNo = this.newAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2LocCd = this.s2LocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Group1Val = this.s2Group1Val .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLocation = this.sLocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2AgmtLstmCd = this.s2AgmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2AgmtNo = this.s2AgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.programId = this.programId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAciacDivCd = this.sAciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s1InqToDys = this.s1InqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtNo = this.oldAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDtTo = this.stsEvntDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2AgmtRefNo = this.s2AgmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntOfcCd = this.stsEvntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchBare = this.atchBare .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2EqTpszCd = this.s2EqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDate = this.mvmtDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmt = this.mvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrSeq = this.sVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCrntOfcCd = this.sCrntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtSeq = this.oldAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCrntYdCd = this.sCrntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgSnd = this.dmgSnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sGroup1Val = this.sGroup1Val .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s3Gtotal = this.s3Gtotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sGroup1 = this.sGroup1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
