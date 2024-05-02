/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSInventoryDtlINVO.java
*@FileTitle : CHSInventoryDtlINVO
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

public class CHSInventoryDtlINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSInventoryDtlINVO> models = new ArrayList<CHSInventoryDtlINVO>();
	
	/* Column Info */
	private String oldAgmtOfcCtyCd = null;
	/* Column Info */
	private String newAgmtOfcCtyCd = null;
	/* Column Info */
	private String includeOutGated = null;
	/* Column Info */
	private String newAgmtLstmCd = null;
	/* Column Info */
	private String lsdays = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String s2Group1 = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String newAgmtSeq = null;
	/* Column Info */
	private String inqToDys = null;
	/* Column Info */
	private String s2Group2 = null;
	/* Column Info */
	private String s2Group3 = null;
	/* Column Info */
	private String stsEvntYdCd = null;
	/* Column Info */
	private String s2Group1Val = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chssMvmtDt = null;
	/* Column Info */
	private String eqAsetStsCd = null;
	/* Column Info */
	private String oldAgmtNo = null;
	/* Column Info */
	private String stsEvntDtTo = null;
	/* Column Info */
	private String stsEvntDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String s2EqTpszCd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String sAgmtLstmCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String groupValue2 = null;
	/* Column Info */
	private String groupValue3 = null;
	/* Column Info */
	private String dmgSnd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sGroup1Val = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String s2Group2Val = null;
	/* Column Info */
	private String mvmtDt = null;
	/* Column Info */
	private String s2Group3Val = null;
	/* Column Info */
	private String stsEvntDtFr = null;
	/* Column Info */
	private String includeStatusLst = null;
	/* Column Info */
	private String oldAgmtLstmCd = null;
	/* Column Info */
	private String includeNp = null;
	/* Column Info */
	private String newAgmtNo = null;
	/* Column Info */
	private String groupValue1 = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String kind = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String programId = null;
	/* Column Info */
	private String group3 = null;
	/* Column Info */
	private String group1 = null;
	/* Column Info */
	private String group2 = null;
	/* Column Info */
	private String stsEvntOfcCd = null;
	/* Column Info */
	private String mvmtsDt = null;
	/* Column Info */
	private String atchBare = null;
	/* Column Info */
	private String inqFmDys = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String oldAgmtSeq = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String stsEvntLocCd = null;
	/* Column Info */
	private String stayingDays = null;
	/* Column Info */
	private String chssMvmtStsCd = null;
	/* Column Info */
	private String crntLocCd = null;
	/* Column Info */
	private String s3Gtotal = null;
	/* Column Info */
	private String sGroup1 = null;
	/* Column Info */
	private String sysSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSInventoryDtlINVO() {}

	public CHSInventoryDtlINVO(String ibflag, String pagerows, String inqFmDys, String inqToDys, String programId, String eqKndCd, String stsEvntDtFr, String stsEvntDtTo, String stsEvntOfcCd, String oldAgmtOfcCtyCd, String oldAgmtSeq, String oldAgmtNo, String newAgmtOfcCtyCd, String newAgmtSeq, String newAgmtNo, String eqNo, String eqTpszCd, String s2EqTpszCd, String agmtLstmCd,String sAgmtLstmCd, String agmtNo, String vndrAbbrNm, String chssMvmtStsCd, String lccCd, String sccCd, String crntYdCd, String onhDt, String chssMvmtDt, String lsdays, String crntLocCd, String aciacDivCd, String chssPoolCd, String includeNp, String stayingDays, String group1, String group2, String group3, String groupValue1, String groupValue2, String groupValue3, String vndrSeq, String vndrLglEngNm, String eqAsetStsCd, String stsEvntYdCd, String mvmtsDt, String stsEvntDt, String creUsrId, String mvmtDt, String sysSeq, String updUsrId, String location, String stsEvntLocCd, String kind, String includeStatusLst, String includeOutGated, String sGroup1, String sGroup1Val, String s2Group1, String s2Group1Val, String s2Group2, String s2Group2Val, String s2Group3, String s2Group3Val, String s3Gtotal, String oldAgmtLstmCd, String newAgmtLstmCd, String atchBare, String dmgSnd) {
		this.oldAgmtOfcCtyCd = oldAgmtOfcCtyCd;
		this.newAgmtOfcCtyCd = newAgmtOfcCtyCd;
		this.includeOutGated = includeOutGated;
		this.newAgmtLstmCd = newAgmtLstmCd;
		this.lsdays = lsdays;
		this.chssPoolCd = chssPoolCd;
		this.s2Group1 = s2Group1;
		this.location = location;
		this.newAgmtSeq = newAgmtSeq;
		this.inqToDys = inqToDys;
		this.s2Group2 = s2Group2;
		this.s2Group3 = s2Group3;
		this.stsEvntYdCd = stsEvntYdCd;
		this.s2Group1Val = s2Group1Val;
		this.pagerows = pagerows;
		this.chssMvmtDt = chssMvmtDt;
		this.eqAsetStsCd = eqAsetStsCd;
		this.oldAgmtNo = oldAgmtNo;
		this.stsEvntDtTo = stsEvntDtTo;
		this.stsEvntDt = stsEvntDt;
		this.updUsrId = updUsrId;
		this.s2EqTpszCd = s2EqTpszCd;
		this.agmtNo = agmtNo;
		this.agmtLstmCd = agmtLstmCd;
		this.sAgmtLstmCd = sAgmtLstmCd;
		this.aciacDivCd = aciacDivCd;
		this.eqTpszCd = eqTpszCd;
		this.groupValue2 = groupValue2;
		this.groupValue3 = groupValue3;
		this.dmgSnd = dmgSnd;
		this.creUsrId = creUsrId;
		this.sGroup1Val = sGroup1Val;
		this.vndrSeq = vndrSeq;
		this.vndrAbbrNm = vndrAbbrNm;
		this.s2Group2Val = s2Group2Val;
		this.mvmtDt = mvmtDt;
		this.s2Group3Val = s2Group3Val;
		this.stsEvntDtFr = stsEvntDtFr;
		this.includeStatusLst = includeStatusLst;
		this.oldAgmtLstmCd = oldAgmtLstmCd;
		this.includeNp = includeNp;
		this.newAgmtNo = newAgmtNo;
		this.groupValue1 = groupValue1;
		this.vndrLglEngNm = vndrLglEngNm;
		this.crntYdCd = crntYdCd;
		this.onhDt = onhDt;
		this.kind = kind;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.programId = programId;
		this.group3 = group3;
		this.group1 = group1;
		this.group2 = group2;
		this.stsEvntOfcCd = stsEvntOfcCd;
		this.mvmtsDt = mvmtsDt;
		this.atchBare = atchBare;
		this.inqFmDys = inqFmDys;
		this.eqKndCd = eqKndCd;
		this.oldAgmtSeq = oldAgmtSeq;
		this.lccCd = lccCd;
		this.sccCd = sccCd;
		this.stsEvntLocCd = stsEvntLocCd;
		this.stayingDays = stayingDays;
		this.chssMvmtStsCd = chssMvmtStsCd;
		this.crntLocCd = crntLocCd;
		this.s3Gtotal = s3Gtotal;
		this.sGroup1 = sGroup1;
		this.sysSeq = sysSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("old_agmt_ofc_cty_cd", getOldAgmtOfcCtyCd());
		this.hashColumns.put("new_agmt_ofc_cty_cd", getNewAgmtOfcCtyCd());
		this.hashColumns.put("include_out_gated", getIncludeOutGated());
		this.hashColumns.put("new_agmt_lstm_cd", getNewAgmtLstmCd());
		this.hashColumns.put("lsdays", getLsdays());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("s2_group1", getS2Group1());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("new_agmt_seq", getNewAgmtSeq());
		this.hashColumns.put("inq_to_dys", getInqToDys());
		this.hashColumns.put("s2_group2", getS2Group2());
		this.hashColumns.put("s2_group3", getS2Group3());
		this.hashColumns.put("sts_evnt_yd_cd", getStsEvntYdCd());
		this.hashColumns.put("s2_group1_val", getS2Group1Val());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chss_mvmt_dt", getChssMvmtDt());
		this.hashColumns.put("eq_aset_sts_cd", getEqAsetStsCd());
		this.hashColumns.put("old_agmt_no", getOldAgmtNo());
		this.hashColumns.put("sts_evnt_dt_to", getStsEvntDtTo());
		this.hashColumns.put("sts_evnt_dt", getStsEvntDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("s2_eq_tpsz_cd", getS2EqTpszCd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("s_agmt_lstm_cd", getSAgmtLstmCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("group_value2", getGroupValue2());
		this.hashColumns.put("group_value3", getGroupValue3());
		this.hashColumns.put("dmg_snd", getDmgSnd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("s_group1_val", getSGroup1Val());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("s2_group2_val", getS2Group2Val());
		this.hashColumns.put("mvmt_dt", getMvmtDt());
		this.hashColumns.put("s2_group3_val", getS2Group3Val());
		this.hashColumns.put("sts_evnt_dt_fr", getStsEvntDtFr());
		this.hashColumns.put("include_status_lst", getIncludeStatusLst());
		this.hashColumns.put("old_agmt_lstm_cd", getOldAgmtLstmCd());
		this.hashColumns.put("include_np", getIncludeNp());
		this.hashColumns.put("new_agmt_no", getNewAgmtNo());
		this.hashColumns.put("group_value1", getGroupValue1());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("program_id", getProgramId());
		this.hashColumns.put("group3", getGroup3());
		this.hashColumns.put("group1", getGroup1());
		this.hashColumns.put("group2", getGroup2());
		this.hashColumns.put("sts_evnt_ofc_cd", getStsEvntOfcCd());
		this.hashColumns.put("mvmts_dt", getMvmtsDt());
		this.hashColumns.put("atch_bare", getAtchBare());
		this.hashColumns.put("inq_fm_dys", getInqFmDys());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("old_agmt_seq", getOldAgmtSeq());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("sts_evnt_loc_cd", getStsEvntLocCd());
		this.hashColumns.put("staying_days", getStayingDays());
		this.hashColumns.put("chss_mvmt_sts_cd", getChssMvmtStsCd());
		this.hashColumns.put("crnt_loc_cd", getCrntLocCd());
		this.hashColumns.put("s3_gtotal", getS3Gtotal());
		this.hashColumns.put("s_group1", getSGroup1());
		this.hashColumns.put("sys_seq", getSysSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("old_agmt_ofc_cty_cd", "oldAgmtOfcCtyCd");
		this.hashFields.put("new_agmt_ofc_cty_cd", "newAgmtOfcCtyCd");
		this.hashFields.put("include_out_gated", "includeOutGated");
		this.hashFields.put("new_agmt_lstm_cd", "newAgmtLstmCd");
		this.hashFields.put("lsdays", "lsdays");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("s2_group1", "s2Group1");
		this.hashFields.put("location", "location");
		this.hashFields.put("new_agmt_seq", "newAgmtSeq");
		this.hashFields.put("inq_to_dys", "inqToDys");
		this.hashFields.put("s2_group2", "s2Group2");
		this.hashFields.put("s2_group3", "s2Group3");
		this.hashFields.put("sts_evnt_yd_cd", "stsEvntYdCd");
		this.hashFields.put("s2_group1_val", "s2Group1Val");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chss_mvmt_dt", "chssMvmtDt");
		this.hashFields.put("eq_aset_sts_cd", "eqAsetStsCd");
		this.hashFields.put("old_agmt_no", "oldAgmtNo");
		this.hashFields.put("sts_evnt_dt_to", "stsEvntDtTo");
		this.hashFields.put("sts_evnt_dt", "stsEvntDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("s2_eq_tpsz_cd", "s2EqTpszCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("s_agmt_lstm_cd", "sAgmtLstmCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("group_value2", "groupValue2");
		this.hashFields.put("group_value3", "groupValue3");
		this.hashFields.put("dmg_snd", "dmgSnd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("s_group1_val", "sGroup1Val");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("s2_group2_val", "s2Group2Val");
		this.hashFields.put("mvmt_dt", "mvmtDt");
		this.hashFields.put("s2_group3_val", "s2Group3Val");
		this.hashFields.put("sts_evnt_dt_fr", "stsEvntDtFr");
		this.hashFields.put("include_status_lst", "includeStatusLst");
		this.hashFields.put("old_agmt_lstm_cd", "oldAgmtLstmCd");
		this.hashFields.put("include_np", "includeNp");
		this.hashFields.put("new_agmt_no", "newAgmtNo");
		this.hashFields.put("group_value1", "groupValue1");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("program_id", "programId");
		this.hashFields.put("group3", "group3");
		this.hashFields.put("group1", "group1");
		this.hashFields.put("group2", "group2");
		this.hashFields.put("sts_evnt_ofc_cd", "stsEvntOfcCd");
		this.hashFields.put("mvmts_dt", "mvmtsDt");
		this.hashFields.put("atch_bare", "atchBare");
		this.hashFields.put("inq_fm_dys", "inqFmDys");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("old_agmt_seq", "oldAgmtSeq");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("sts_evnt_loc_cd", "stsEvntLocCd");
		this.hashFields.put("staying_days", "stayingDays");
		this.hashFields.put("chss_mvmt_sts_cd", "chssMvmtStsCd");
		this.hashFields.put("crnt_loc_cd", "crntLocCd");
		this.hashFields.put("s3_gtotal", "s3Gtotal");
		this.hashFields.put("s_group1", "sGroup1");
		this.hashFields.put("sys_seq", "sysSeq");
		return this.hashFields;
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
	 * @return newAgmtOfcCtyCd
	 */
	public String getNewAgmtOfcCtyCd() {
		return this.newAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return includeOutGated
	 */
	public String getIncludeOutGated() {
		return this.includeOutGated;
	}
	
	/**
	 * Column Info
	 * @return newAgmtLstmCd
	 */
	public String getNewAgmtLstmCd() {
		return this.newAgmtLstmCd;
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
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
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
	 * @return location
	 */
	public String getLocation() {
		return this.location;
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
	 * @return inqToDys
	 */
	public String getInqToDys() {
		return this.inqToDys;
	}
	
	/**
	 * Column Info
	 * @return s2Group2
	 */
	public String getS2Group2() {
		return this.s2Group2;
	}
	
	/**
	 * Column Info
	 * @return s2Group3
	 */
	public String getS2Group3() {
		return this.s2Group3;
	}
	
	/**
	 * Column Info
	 * @return stsEvntYdCd
	 */
	public String getStsEvntYdCd() {
		return this.stsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @return s2Group1Val
	 */
	public String getS2Group1Val() {
		return this.s2Group1Val;
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
	 * @return chssMvmtDt
	 */
	public String getChssMvmtDt() {
		return this.chssMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return eqAsetStsCd
	 */
	public String getEqAsetStsCd() {
		return this.eqAsetStsCd;
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
	 * @return stsEvntDt
	 */
	public String getStsEvntDt() {
		return this.stsEvntDt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
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
	 * @return sAgmtLstmCd
	 */
	public String getSAgmtLstmCd() {
		return this.sAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
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
	 * @return groupValue2
	 */
	public String getGroupValue2() {
		return this.groupValue2;
	}
	
	/**
	 * Column Info
	 * @return groupValue3
	 */
	public String getGroupValue3() {
		return this.groupValue3;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return s2Group2Val
	 */
	public String getS2Group2Val() {
		return this.s2Group2Val;
	}
	
	/**
	 * Column Info
	 * @return mvmtDt
	 */
	public String getMvmtDt() {
		return this.mvmtDt;
	}
	
	/**
	 * Column Info
	 * @return s2Group3Val
	 */
	public String getS2Group3Val() {
		return this.s2Group3Val;
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
	 * @return includeStatusLst
	 */
	public String getIncludeStatusLst() {
		return this.includeStatusLst;
	}
	
	/**
	 * Column Info
	 * @return oldAgmtLstmCd
	 */
	public String getOldAgmtLstmCd() {
		return this.oldAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return includeNp
	 */
	public String getIncludeNp() {
		return this.includeNp;
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
	 * @return groupValue1
	 */
	public String getGroupValue1() {
		return this.groupValue1;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
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
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
	}
	
	/**
	 * Column Info
	 * @return kind
	 */
	public String getKind() {
		return this.kind;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
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
	 * @return group3
	 */
	public String getGroup3() {
		return this.group3;
	}
	
	/**
	 * Column Info
	 * @return group1
	 */
	public String getGroup1() {
		return this.group1;
	}
	
	/**
	 * Column Info
	 * @return group2
	 */
	public String getGroup2() {
		return this.group2;
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
	 * @return mvmtsDt
	 */
	public String getMvmtsDt() {
		return this.mvmtsDt;
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
	 * @return inqFmDys
	 */
	public String getInqFmDys() {
		return this.inqFmDys;
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
	 * @return stsEvntLocCd
	 */
	public String getStsEvntLocCd() {
		return this.stsEvntLocCd;
	}
	
	/**
	 * Column Info
	 * @return stayingDays
	 */
	public String getStayingDays() {
		return this.stayingDays;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtStsCd
	 */
	public String getChssMvmtStsCd() {
		return this.chssMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return crntLocCd
	 */
	public String getCrntLocCd() {
		return this.crntLocCd;
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
	 * @return sysSeq
	 */
	public String getSysSeq() {
		return this.sysSeq;
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
	 * @param newAgmtOfcCtyCd
	 */
	public void setNewAgmtOfcCtyCd(String newAgmtOfcCtyCd) {
		this.newAgmtOfcCtyCd = newAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param includeOutGated
	 */
	public void setIncludeOutGated(String includeOutGated) {
		this.includeOutGated = includeOutGated;
	}
	
	/**
	 * Column Info
	 * @param newAgmtLstmCd
	 */
	public void setNewAgmtLstmCd(String newAgmtLstmCd) {
		this.newAgmtLstmCd = newAgmtLstmCd;
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
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
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
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
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
	 * @param inqToDys
	 */
	public void setInqToDys(String inqToDys) {
		this.inqToDys = inqToDys;
	}
	
	/**
	 * Column Info
	 * @param s2Group2
	 */
	public void setS2Group2(String s2Group2) {
		this.s2Group2 = s2Group2;
	}
	
	/**
	 * Column Info
	 * @param s2Group3
	 */
	public void setS2Group3(String s2Group3) {
		this.s2Group3 = s2Group3;
	}
	
	/**
	 * Column Info
	 * @param stsEvntYdCd
	 */
	public void setStsEvntYdCd(String stsEvntYdCd) {
		this.stsEvntYdCd = stsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @param s2Group1Val
	 */
	public void setS2Group1Val(String s2Group1Val) {
		this.s2Group1Val = s2Group1Val;
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
	 * @param chssMvmtDt
	 */
	public void setChssMvmtDt(String chssMvmtDt) {
		this.chssMvmtDt = chssMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param eqAsetStsCd
	 */
	public void setEqAsetStsCd(String eqAsetStsCd) {
		this.eqAsetStsCd = eqAsetStsCd;
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
	 * @param stsEvntDt
	 */
	public void setStsEvntDt(String stsEvntDt) {
		this.stsEvntDt = stsEvntDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
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
	 * @param agmtLstmCd
	 */
	public void setSAgmtLstmCd(String sAgmtLstmCd) {
		this.sAgmtLstmCd = sAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
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
	 * @param groupValue2
	 */
	public void setGroupValue2(String groupValue2) {
		this.groupValue2 = groupValue2;
	}
	
	/**
	 * Column Info
	 * @param groupValue3
	 */
	public void setGroupValue3(String groupValue3) {
		this.groupValue3 = groupValue3;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param s2Group2Val
	 */
	public void setS2Group2Val(String s2Group2Val) {
		this.s2Group2Val = s2Group2Val;
	}
	
	/**
	 * Column Info
	 * @param mvmtDt
	 */
	public void setMvmtDt(String mvmtDt) {
		this.mvmtDt = mvmtDt;
	}
	
	/**
	 * Column Info
	 * @param s2Group3Val
	 */
	public void setS2Group3Val(String s2Group3Val) {
		this.s2Group3Val = s2Group3Val;
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
	 * @param includeStatusLst
	 */
	public void setIncludeStatusLst(String includeStatusLst) {
		this.includeStatusLst = includeStatusLst;
	}
	
	/**
	 * Column Info
	 * @param oldAgmtLstmCd
	 */
	public void setOldAgmtLstmCd(String oldAgmtLstmCd) {
		this.oldAgmtLstmCd = oldAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param includeNp
	 */
	public void setIncludeNp(String includeNp) {
		this.includeNp = includeNp;
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
	 * @param groupValue1
	 */
	public void setGroupValue1(String groupValue1) {
		this.groupValue1 = groupValue1;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
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
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
	}
	
	/**
	 * Column Info
	 * @param kind
	 */
	public void setKind(String kind) {
		this.kind = kind;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
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
	 * @param group3
	 */
	public void setGroup3(String group3) {
		this.group3 = group3;
	}
	
	/**
	 * Column Info
	 * @param group1
	 */
	public void setGroup1(String group1) {
		this.group1 = group1;
	}
	
	/**
	 * Column Info
	 * @param group2
	 */
	public void setGroup2(String group2) {
		this.group2 = group2;
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
	 * @param mvmtsDt
	 */
	public void setMvmtsDt(String mvmtsDt) {
		this.mvmtsDt = mvmtsDt;
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
	 * @param inqFmDys
	 */
	public void setInqFmDys(String inqFmDys) {
		this.inqFmDys = inqFmDys;
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
	 * @param stsEvntLocCd
	 */
	public void setStsEvntLocCd(String stsEvntLocCd) {
		this.stsEvntLocCd = stsEvntLocCd;
	}
	
	/**
	 * Column Info
	 * @param stayingDays
	 */
	public void setStayingDays(String stayingDays) {
		this.stayingDays = stayingDays;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtStsCd
	 */
	public void setChssMvmtStsCd(String chssMvmtStsCd) {
		this.chssMvmtStsCd = chssMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param crntLocCd
	 */
	public void setCrntLocCd(String crntLocCd) {
		this.crntLocCd = crntLocCd;
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
	 * Column Info
	 * @param sysSeq
	 */
	public void setSysSeq(String sysSeq) {
		this.sysSeq = sysSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOldAgmtOfcCtyCd(JSPUtil.getParameter(request, "old_agmt_ofc_cty_cd", ""));
		setNewAgmtOfcCtyCd(JSPUtil.getParameter(request, "new_agmt_ofc_cty_cd", ""));
		setIncludeOutGated(JSPUtil.getParameter(request, "include_out_gated", ""));
		setNewAgmtLstmCd(JSPUtil.getParameter(request, "new_agmt_lstm_cd", ""));
		setLsdays(JSPUtil.getParameter(request, "lsdays", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setS2Group1(JSPUtil.getParameter(request, "s2_group1", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setNewAgmtSeq(JSPUtil.getParameter(request, "new_agmt_seq", ""));
		setInqToDys(JSPUtil.getParameter(request, "inq_to_dys", ""));
		setS2Group2(JSPUtil.getParameter(request, "s2_group2", ""));
		setS2Group3(JSPUtil.getParameter(request, "s2_group3", ""));
		setStsEvntYdCd(JSPUtil.getParameter(request, "sts_evnt_yd_cd", ""));
		setS2Group1Val(JSPUtil.getParameter(request, "s2_group1_val", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setChssMvmtDt(JSPUtil.getParameter(request, "chss_mvmt_dt", ""));
		setEqAsetStsCd(JSPUtil.getParameter(request, "eq_aset_sts_cd", ""));
		setOldAgmtNo(JSPUtil.getParameter(request, "old_agmt_no", ""));
		setStsEvntDtTo(JSPUtil.getParameter(request, "sts_evnt_dt_to", ""));
		setStsEvntDt(JSPUtil.getParameter(request, "sts_evnt_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setS2EqTpszCd(JSPUtil.getParameter(request, "s2_eq_tpsz_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setSAgmtLstmCd(JSPUtil.getParameter(request, "s_agmt_lstm_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, "aciac_div_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setGroupValue2(JSPUtil.getParameter(request, "group_value2", ""));
		setGroupValue3(JSPUtil.getParameter(request, "group_value3", ""));
		setDmgSnd(JSPUtil.getParameter(request, "dmg_snd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSGroup1Val(JSPUtil.getParameter(request, "s_group1_val", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setS2Group2Val(JSPUtil.getParameter(request, "s2_group2_val", ""));
		setMvmtDt(JSPUtil.getParameter(request, "mvmt_dt", ""));
		setS2Group3Val(JSPUtil.getParameter(request, "s2_group3_val", ""));
		setStsEvntDtFr(JSPUtil.getParameter(request, "sts_evnt_dt_fr", ""));
		setIncludeStatusLst(JSPUtil.getParameter(request, "include_status_lst", ""));
		setOldAgmtLstmCd(JSPUtil.getParameter(request, "old_agmt_lstm_cd", ""));
		setIncludeNp(JSPUtil.getParameter(request, "include_np", ""));
		setNewAgmtNo(JSPUtil.getParameter(request, "new_agmt_no", ""));
		setGroupValue1(JSPUtil.getParameter(request, "group_value1", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setKind(JSPUtil.getParameter(request, "kind", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setProgramId(JSPUtil.getParameter(request, "program_id", ""));
		setGroup3(JSPUtil.getParameter(request, "group3", ""));
		setGroup1(JSPUtil.getParameter(request, "group1", ""));
		setGroup2(JSPUtil.getParameter(request, "group2", ""));
		setStsEvntOfcCd(JSPUtil.getParameter(request, "sts_evnt_ofc_cd", ""));
		setMvmtsDt(JSPUtil.getParameter(request, "mvmts_dt", ""));
		setAtchBare(JSPUtil.getParameter(request, "atch_bare", ""));
		setInqFmDys(JSPUtil.getParameter(request, "inq_fm_dys", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setOldAgmtSeq(JSPUtil.getParameter(request, "old_agmt_seq", ""));
		setLccCd(JSPUtil.getParameter(request, "lcc_cd", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setStsEvntLocCd(JSPUtil.getParameter(request, "sts_evnt_loc_cd", ""));
		setStayingDays(JSPUtil.getParameter(request, "staying_days", ""));
		setChssMvmtStsCd(JSPUtil.getParameter(request, "chss_mvmt_sts_cd", ""));
		setCrntLocCd(JSPUtil.getParameter(request, "crnt_loc_cd", ""));
		setS3Gtotal(JSPUtil.getParameter(request, "s3_gtotal", ""));
		setSGroup1(JSPUtil.getParameter(request, "s_group1", ""));
		setSysSeq(JSPUtil.getParameter(request, "sys_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSInventoryDtlINVO[]
	 */
	public CHSInventoryDtlINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSInventoryDtlINVO[]
	 */
	public CHSInventoryDtlINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSInventoryDtlINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] oldAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "old_agmt_ofc_cty_cd", length));
			String[] newAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "new_agmt_ofc_cty_cd", length));
			String[] includeOutGated = (JSPUtil.getParameter(request, prefix	+ "include_out_gated", length));
			String[] newAgmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "new_agmt_lstm_cd", length));
			String[] lsdays = (JSPUtil.getParameter(request, prefix	+ "lsdays", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] s2Group1 = (JSPUtil.getParameter(request, prefix	+ "s2_group1", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] newAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "new_agmt_seq", length));
			String[] inqToDys = (JSPUtil.getParameter(request, prefix	+ "inq_to_dys", length));
			String[] s2Group2 = (JSPUtil.getParameter(request, prefix	+ "s2_group2", length));
			String[] s2Group3 = (JSPUtil.getParameter(request, prefix	+ "s2_group3", length));
			String[] stsEvntYdCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_yd_cd", length));
			String[] s2Group1Val = (JSPUtil.getParameter(request, prefix	+ "s2_group1_val", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chssMvmtDt = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt", length));
			String[] eqAsetStsCd = (JSPUtil.getParameter(request, prefix	+ "eq_aset_sts_cd", length));
			String[] oldAgmtNo = (JSPUtil.getParameter(request, prefix	+ "old_agmt_no", length));
			String[] stsEvntDtTo = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_dt_to", length));
			String[] stsEvntDt = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] s2EqTpszCd = (JSPUtil.getParameter(request, prefix	+ "s2_eq_tpsz_cd", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] sAgmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "s_agmt_lstm_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] groupValue2 = (JSPUtil.getParameter(request, prefix	+ "group_value2", length));
			String[] groupValue3 = (JSPUtil.getParameter(request, prefix	+ "group_value3", length));
			String[] dmgSnd = (JSPUtil.getParameter(request, prefix	+ "dmg_snd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sGroup1Val = (JSPUtil.getParameter(request, prefix	+ "s_group1_val", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] s2Group2Val = (JSPUtil.getParameter(request, prefix	+ "s2_group2_val", length));
			String[] mvmtDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt", length));
			String[] s2Group3Val = (JSPUtil.getParameter(request, prefix	+ "s2_group3_val", length));
			String[] stsEvntDtFr = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_dt_fr", length));
			String[] includeStatusLst = (JSPUtil.getParameter(request, prefix	+ "include_status_lst", length));
			String[] oldAgmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "old_agmt_lstm_cd", length));
			String[] includeNp = (JSPUtil.getParameter(request, prefix	+ "include_np", length));
			String[] newAgmtNo = (JSPUtil.getParameter(request, prefix	+ "new_agmt_no", length));
			String[] groupValue1 = (JSPUtil.getParameter(request, prefix	+ "group_value1", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] programId = (JSPUtil.getParameter(request, prefix	+ "program_id", length));
			String[] group3 = (JSPUtil.getParameter(request, prefix	+ "group3", length));
			String[] group1 = (JSPUtil.getParameter(request, prefix	+ "group1", length));
			String[] group2 = (JSPUtil.getParameter(request, prefix	+ "group2", length));
			String[] stsEvntOfcCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_ofc_cd", length));
			String[] mvmtsDt = (JSPUtil.getParameter(request, prefix	+ "mvmts_dt", length));
			String[] atchBare = (JSPUtil.getParameter(request, prefix	+ "atch_bare", length));
			String[] inqFmDys = (JSPUtil.getParameter(request, prefix	+ "inq_fm_dys", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] oldAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "old_agmt_seq", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] stsEvntLocCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_loc_cd", length));
			String[] stayingDays = (JSPUtil.getParameter(request, prefix	+ "staying_days", length));
			String[] chssMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_sts_cd", length));
			String[] crntLocCd = (JSPUtil.getParameter(request, prefix	+ "crnt_loc_cd", length));
			String[] s3Gtotal = (JSPUtil.getParameter(request, prefix	+ "s3_gtotal", length));
			String[] sGroup1 = (JSPUtil.getParameter(request, prefix	+ "s_group1", length));
			String[] sysSeq = (JSPUtil.getParameter(request, prefix	+ "sys_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSInventoryDtlINVO();
				if (oldAgmtOfcCtyCd[i] != null)
					model.setOldAgmtOfcCtyCd(oldAgmtOfcCtyCd[i]);
				if (newAgmtOfcCtyCd[i] != null)
					model.setNewAgmtOfcCtyCd(newAgmtOfcCtyCd[i]);
				if (includeOutGated[i] != null)
					model.setIncludeOutGated(includeOutGated[i]);
				if (newAgmtLstmCd[i] != null)
					model.setNewAgmtLstmCd(newAgmtLstmCd[i]);
				if (lsdays[i] != null)
					model.setLsdays(lsdays[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (s2Group1[i] != null)
					model.setS2Group1(s2Group1[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (newAgmtSeq[i] != null)
					model.setNewAgmtSeq(newAgmtSeq[i]);
				if (inqToDys[i] != null)
					model.setInqToDys(inqToDys[i]);
				if (s2Group2[i] != null)
					model.setS2Group2(s2Group2[i]);
				if (s2Group3[i] != null)
					model.setS2Group3(s2Group3[i]);
				if (stsEvntYdCd[i] != null)
					model.setStsEvntYdCd(stsEvntYdCd[i]);
				if (s2Group1Val[i] != null)
					model.setS2Group1Val(s2Group1Val[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chssMvmtDt[i] != null)
					model.setChssMvmtDt(chssMvmtDt[i]);
				if (eqAsetStsCd[i] != null)
					model.setEqAsetStsCd(eqAsetStsCd[i]);
				if (oldAgmtNo[i] != null)
					model.setOldAgmtNo(oldAgmtNo[i]);
				if (stsEvntDtTo[i] != null)
					model.setStsEvntDtTo(stsEvntDtTo[i]);
				if (stsEvntDt[i] != null)
					model.setStsEvntDt(stsEvntDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (s2EqTpszCd[i] != null)
					model.setS2EqTpszCd(s2EqTpszCd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (sAgmtLstmCd[i] != null)
					model.setSAgmtLstmCd(sAgmtLstmCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (groupValue2[i] != null)
					model.setGroupValue2(groupValue2[i]);
				if (groupValue3[i] != null)
					model.setGroupValue3(groupValue3[i]);
				if (dmgSnd[i] != null)
					model.setDmgSnd(dmgSnd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sGroup1Val[i] != null)
					model.setSGroup1Val(sGroup1Val[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (s2Group2Val[i] != null)
					model.setS2Group2Val(s2Group2Val[i]);
				if (mvmtDt[i] != null)
					model.setMvmtDt(mvmtDt[i]);
				if (s2Group3Val[i] != null)
					model.setS2Group3Val(s2Group3Val[i]);
				if (stsEvntDtFr[i] != null)
					model.setStsEvntDtFr(stsEvntDtFr[i]);
				if (includeStatusLst[i] != null)
					model.setIncludeStatusLst(includeStatusLst[i]);
				if (oldAgmtLstmCd[i] != null)
					model.setOldAgmtLstmCd(oldAgmtLstmCd[i]);
				if (includeNp[i] != null)
					model.setIncludeNp(includeNp[i]);
				if (newAgmtNo[i] != null)
					model.setNewAgmtNo(newAgmtNo[i]);
				if (groupValue1[i] != null)
					model.setGroupValue1(groupValue1[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (programId[i] != null)
					model.setProgramId(programId[i]);
				if (group3[i] != null)
					model.setGroup3(group3[i]);
				if (group1[i] != null)
					model.setGroup1(group1[i]);
				if (group2[i] != null)
					model.setGroup2(group2[i]);
				if (stsEvntOfcCd[i] != null)
					model.setStsEvntOfcCd(stsEvntOfcCd[i]);
				if (mvmtsDt[i] != null)
					model.setMvmtsDt(mvmtsDt[i]);
				if (atchBare[i] != null)
					model.setAtchBare(atchBare[i]);
				if (inqFmDys[i] != null)
					model.setInqFmDys(inqFmDys[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (oldAgmtSeq[i] != null)
					model.setOldAgmtSeq(oldAgmtSeq[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (stsEvntLocCd[i] != null)
					model.setStsEvntLocCd(stsEvntLocCd[i]);
				if (stayingDays[i] != null)
					model.setStayingDays(stayingDays[i]);
				if (chssMvmtStsCd[i] != null)
					model.setChssMvmtStsCd(chssMvmtStsCd[i]);
				if (crntLocCd[i] != null)
					model.setCrntLocCd(crntLocCd[i]);
				if (s3Gtotal[i] != null)
					model.setS3Gtotal(s3Gtotal[i]);
				if (sGroup1[i] != null)
					model.setSGroup1(sGroup1[i]);
				if (sysSeq[i] != null)
					model.setSysSeq(sysSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSInventoryDtlINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSInventoryDtlINVO[]
	 */
	public CHSInventoryDtlINVO[] getCHSInventoryDtlINVOs(){
		CHSInventoryDtlINVO[] vos = (CHSInventoryDtlINVO[])models.toArray(new CHSInventoryDtlINVO[models.size()]);
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
		this.oldAgmtOfcCtyCd = this.oldAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtOfcCtyCd = this.newAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.includeOutGated = this.includeOutGated .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtLstmCd = this.newAgmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsdays = this.lsdays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Group1 = this.s2Group1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtSeq = this.newAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inqToDys = this.inqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Group2 = this.s2Group2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Group3 = this.s2Group3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntYdCd = this.stsEvntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Group1Val = this.s2Group1Val .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt = this.chssMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAsetStsCd = this.eqAsetStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtNo = this.oldAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDtTo = this.stsEvntDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDt = this.stsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2EqTpszCd = this.s2EqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAgmtLstmCd = this.sAgmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupValue2 = this.groupValue2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupValue3 = this.groupValue3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgSnd = this.dmgSnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sGroup1Val = this.sGroup1Val .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Group2Val = this.s2Group2Val .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt = this.mvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Group3Val = this.s2Group3Val .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDtFr = this.stsEvntDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.includeStatusLst = this.includeStatusLst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtLstmCd = this.oldAgmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.includeNp = this.includeNp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtNo = this.newAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupValue1 = this.groupValue1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.programId = this.programId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.group3 = this.group3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.group1 = this.group1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.group2 = this.group2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntOfcCd = this.stsEvntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtsDt = this.mvmtsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchBare = this.atchBare .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inqFmDys = this.inqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtSeq = this.oldAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntLocCd = this.stsEvntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayingDays = this.stayingDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtStsCd = this.chssMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntLocCd = this.crntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s3Gtotal = this.s3Gtotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sGroup1 = this.sGroup1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSeq = this.sysSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
