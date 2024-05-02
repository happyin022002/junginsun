/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CreateSurchargeInputVO.java
*@FileTitle : CreateSurchargeInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.06 김대호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo;

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
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CreateSurchargeInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CreateSurchargeInputVO> models = new ArrayList<CreateSurchargeInputVO>();
	
	/* Column Info */
	private String dryCgoFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String dihFlg = null;
	/* Column Info */
	private String daCurrCd = null;
	/* Column Info */
	private String daCalcFrtRtAmt = null;
	/* Column Info */
	private String triPropNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String prcCmdtHdrSeq = null;
	/* Column Info */
	private String porMtchFlg = null;
	/* Column Info */
	private String daAddChgSeq = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String oaCurrCd = null;
	/* Column Info */
	private String oaCalcFrtRtAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cgoCateCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String prcGenSpclRtTpCd = null;
	/* Column Info */
	private String ofrtSeq = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String oaAddChgSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String oihFlg = null;
	/* Column Info */
	private String bkgBqOccrSeq = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String prcRoutSeq = null;
	/* Column Info */
	private String eqSubstCntrTpszCd = null;
	/* Column Info */
	private String ctrtCntrTpszCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String delMtchFlg = null;
	/* Column Info */
	private String oftCmbSeq = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rtCalcFrtRtAmt = null;
	/* Column Info */
	private String prcRtSeq = null;
	/* Column Info */
	private String bkgBqSeq = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String ratAsQty = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String inclOftFlg = null;
	/* Column Info */
	private String fnlFrtRtAmt = null;
	/* Column Info */
	private String oiCurrCd = null;
	/* Column Info */
	private String oiCalcFrtRtAmt = null;
	/* Column Info */
	private String diCurrCd = null;
	/* Column Info */
	private String diCalcFrtRtAmt = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CreateSurchargeInputVO() {}

	public CreateSurchargeInputVO(String ibflag, String pagerows, String oaAddChgSeq, String porMtchFlg, String oihFlg, String daAddChgSeq, String delMtchFlg, String dihFlg, String bkgBqSeq, String bkgBqOccrSeq, String bkgNo, String oftCmbSeq, String usrId, String ofrtSeq, String cntrTpszCd, String eqSubstCntrTpszCd, String ctrtCntrTpszCd, String rcvTermCd, String deTermCd, String dryCgoFlg, String awkCgoFlg, String dcgoFlg, String rcFlg, String bbCgoFlg, String socFlg, String imdgClssCd, String prcGenSpclRtTpCd, String prcCmdtHdrSeq, String prcRoutSeq, String prcRtSeq, String opCntrQty, String chgCd, String currCd, String chgUtAmt, String rtCalcFrtRtAmt, String oaCurrCd, String oaCalcFrtRtAmt, String daCurrCd, String daCalcFrtRtAmt, String ratAsQty, String chgAmt, String ratUtCd, String cgoCateCd, String creUsrId, String creDt, String updUsrId, String updDt, String triPropNo, String inclOftFlg, String fnlFrtRtAmt, String oiCurrCd, String oiCalcFrtRtAmt,String diCurrCd, String diCalcFrtRtAmt) {
		this.dryCgoFlg = dryCgoFlg;
		this.currCd = currCd;
		this.dihFlg = dihFlg;
		this.daCurrCd = daCurrCd;
		this.daCalcFrtRtAmt = daCalcFrtRtAmt;
		this.triPropNo = triPropNo;
		this.creDt = creDt;
		this.prcCmdtHdrSeq = prcCmdtHdrSeq;
		this.porMtchFlg = porMtchFlg;
		this.daAddChgSeq = daAddChgSeq;
		this.chgCd = chgCd;
		this.oaCurrCd = oaCurrCd;
		this.oaCalcFrtRtAmt = oaCalcFrtRtAmt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cgoCateCd = cgoCateCd;
		this.usrId = usrId;
		this.bbCgoFlg = bbCgoFlg;
		this.chgAmt = chgAmt;
		this.cntrTpszCd = cntrTpszCd;
		this.dcgoFlg = dcgoFlg;
		this.prcGenSpclRtTpCd = prcGenSpclRtTpCd;
		this.ofrtSeq = ofrtSeq;
		this.rcvTermCd = rcvTermCd;
		this.updUsrId = updUsrId;
		this.oaAddChgSeq = oaAddChgSeq;
		this.updDt = updDt;
		this.chgUtAmt = chgUtAmt;
		this.oihFlg = oihFlg;
		this.bkgBqOccrSeq = bkgBqOccrSeq;
		this.awkCgoFlg = awkCgoFlg;
		this.prcRoutSeq = prcRoutSeq;
		this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
		this.ctrtCntrTpszCd = ctrtCntrTpszCd;
		this.ratUtCd = ratUtCd;
		this.delMtchFlg = delMtchFlg;
		this.oftCmbSeq = oftCmbSeq;
		this.socFlg = socFlg;
		this.deTermCd = deTermCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.rtCalcFrtRtAmt = rtCalcFrtRtAmt;
		this.prcRtSeq = prcRtSeq;
		this.bkgBqSeq = bkgBqSeq;
		this.opCntrQty = opCntrQty;
		this.ratAsQty = ratAsQty;
		this.rcFlg = rcFlg;
		this.imdgClssCd = imdgClssCd;
		this.inclOftFlg = inclOftFlg;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.oiCalcFrtRtAmt = oiCalcFrtRtAmt;
		this.oiCurrCd = oiCurrCd;
		this.diCalcFrtRtAmt = diCalcFrtRtAmt;
		this.diCurrCd = diCurrCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dry_cgo_flg", getDryCgoFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("dih_flg", getDihFlg());
		this.hashColumns.put("da_curr_cd", getDaCurrCd());
		this.hashColumns.put("da_calc_frt_rt_amt", getDaCalcFrtRtAmt());
		this.hashColumns.put("tri_prop_no", getTriPropNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("prc_cmdt_hdr_seq", getPrcCmdtHdrSeq());
		this.hashColumns.put("por_mtch_flg", getPorMtchFlg());
		this.hashColumns.put("da_add_chg_seq", getDaAddChgSeq());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("oa_curr_cd", getOaCurrCd());
		this.hashColumns.put("oa_calc_frt_rt_amt", getOaCalcFrtRtAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cgo_cate_cd", getCgoCateCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("prc_gen_spcl_rt_tp_cd", getPrcGenSpclRtTpCd());
		this.hashColumns.put("ofrt_seq", getOfrtSeq());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("oa_add_chg_seq", getOaAddChgSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("oih_flg", getOihFlg());
		this.hashColumns.put("bkg_bq_occr_seq", getBkgBqOccrSeq());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("prc_rout_seq", getPrcRoutSeq());
		this.hashColumns.put("eq_subst_cntr_tpsz_cd", getEqSubstCntrTpszCd());
		this.hashColumns.put("ctrt_cntr_tpsz_cd", getCtrtCntrTpszCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("del_mtch_flg", getDelMtchFlg());
		this.hashColumns.put("oft_cmb_seq", getOftCmbSeq());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rt_calc_frt_rt_amt", getRtCalcFrtRtAmt());
		this.hashColumns.put("prc_rt_seq", getPrcRtSeq());
		this.hashColumns.put("bkg_bq_seq", getBkgBqSeq());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("incl_oft_flg", getInclOftFlg());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("oi_curr_cd", getOiCurrCd());
		this.hashColumns.put("oi_calc_frt_rt_amt", getOiCalcFrtRtAmt());
		this.hashColumns.put("di_curr_cd", getDiCurrCd());
		this.hashColumns.put("di_calc_frt_rt_amt", getDiCalcFrtRtAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dry_cgo_flg", "dryCgoFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("dih_flg", "dihFlg");
		this.hashFields.put("da_curr_cd", "daCurrCd");
		this.hashFields.put("da_calc_frt_rt_amt", "daCalcFrtRtAmt");
		this.hashFields.put("tri_prop_no", "triPropNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("prc_cmdt_hdr_seq", "prcCmdtHdrSeq");
		this.hashFields.put("por_mtch_flg", "porMtchFlg");
		this.hashFields.put("da_add_chg_seq", "daAddChgSeq");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("oa_curr_cd", "oaCurrCd");
		this.hashFields.put("oa_calc_frt_rt_amt", "oaCalcFrtRtAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cgo_cate_cd", "cgoCateCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("prc_gen_spcl_rt_tp_cd", "prcGenSpclRtTpCd");
		this.hashFields.put("ofrt_seq", "ofrtSeq");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("oa_add_chg_seq", "oaAddChgSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("oih_flg", "oihFlg");
		this.hashFields.put("bkg_bq_occr_seq", "bkgBqOccrSeq");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("prc_rout_seq", "prcRoutSeq");
		this.hashFields.put("eq_subst_cntr_tpsz_cd", "eqSubstCntrTpszCd");
		this.hashFields.put("ctrt_cntr_tpsz_cd", "ctrtCntrTpszCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("del_mtch_flg", "delMtchFlg");
		this.hashFields.put("oft_cmb_seq", "oftCmbSeq");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rt_calc_frt_rt_amt", "rtCalcFrtRtAmt");
		this.hashFields.put("prc_rt_seq", "prcRtSeq");
		this.hashFields.put("bkg_bq_seq", "bkgBqSeq");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("incl_oft_flg", "inclOftFlg");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("oi_curr_cd", "oiCurrCd");
		this.hashFields.put("oi_calc_frt_rt_amt", "oiCalcFrtRtAmt");
		this.hashFields.put("di_curr_cd", "diCurrCd");
		this.hashFields.put("di_calc_frt_rt_amt", "diCalcFrtRtAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dryCgoFlg
	 */
	public String getDryCgoFlg() {
		return this.dryCgoFlg;
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
	 * @return dihFlg
	 */
	public String getDihFlg() {
		return this.dihFlg;
	}

	/**
	 * Column Info
	 * @return daCurrCd
	 */
	public String getDaCurrCd() {
		return this.daCurrCd;
	}

	/**
	 * Column Info
	 * @return daCalcFrtRtAmt
	 */
	public String getDaCalcFrtRtAmt() {
		return this.daCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return triPropNo
	 */
	public String getTriPropNo() {
		return this.triPropNo;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtHdrSeq
	 */
	public String getPrcCmdtHdrSeq() {
		return this.prcCmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return porMtchFlg
	 */
	public String getPorMtchFlg() {
		return this.porMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return daAddChgSeq
	 */
	public String getDaAddChgSeq() {
		return this.daAddChgSeq;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}

	/**
	 * Column Info
	 * @return oaCurrCd
	 */
	public String getOaCurrCd() {
		return this.oaCurrCd;
	}

	/**
	 * Column Info
	 * @return oaCalcFrtRtAmt
	 */
	public String getOaCalcFrtRtAmt() {
		return this.oaCalcFrtRtAmt;
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
	 * @return cgoCateCd
	 */
	public String getCgoCateCd() {
		return this.cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
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
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return prcGenSpclRtTpCd
	 */
	public String getPrcGenSpclRtTpCd() {
		return this.prcGenSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return ofrtSeq
	 */
	public String getOfrtSeq() {
		return this.ofrtSeq;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
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
	 * @return oaAddChgSeq
	 */
	public String getOaAddChgSeq() {
		return this.oaAddChgSeq;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return chgUtAmt
	 */
	public String getChgUtAmt() {
		return this.chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @return oihFlg
	 */
	public String getOihFlg() {
		return this.oihFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgBqOccrSeq
	 */
	public String getBkgBqOccrSeq() {
		return this.bkgBqOccrSeq;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return prcRoutSeq
	 */
	public String getPrcRoutSeq() {
		return this.prcRoutSeq;
	}

	/**
	 * Column Info
	 * @return eqSubstCntrTpszCd
	 */
	public String getEqSubstCntrTpszCd() {
		return this.eqSubstCntrTpszCd;
	}

	/**
	 * Column Info
	 * @return ctrtCntrTpszCd
	 */
	public String getCtrtCntrTpszCd() {
		return this.ctrtCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return delMtchFlg
	 */
	public String getDelMtchFlg() {
		return this.delMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return oftCmbSeq
	 */
	public String getOftCmbSeq() {
		return this.oftCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return rtCalcFrtRtAmt
	 */
	public String getRtCalcFrtRtAmt() {
		return this.rtCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return prcRtSeq
	 */
	public String getPrcRtSeq() {
		return this.prcRtSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgBqSeq
	 */
	public String getBkgBqSeq() {
		return this.bkgBqSeq;
	}
	
	/**
	 * Column Info
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return ratAsQty
	 */
	public String getRatAsQty() {
		return this.ratAsQty;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return fnlFrtRtAmt
	 */
	public String getFnlFrtRtAmt() {
		return this.fnlFrtRtAmt;
	}

	/**
	 * Column Info
	 * @return inclOftFlg
	 */
	public String getInclOftFlg() {
		return this.inclOftFlg;
	}
	
	/**
	 * Column Info
	 * @return oiCurrCd
	 */
	public String getOiCurrCd() {
		return this.oiCurrCd;
	}
	
	/**
	 * Column Info
	 * @return oiCalcFrtRtAmt
	 */
	public String getOiCalcFrtRtAmt() {
		return this.oiCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return diCurrCd
	 */
	public String getDiCurrCd() {
		return this.diCurrCd;
	}
	
	/**
	 * Column Info
	 * @return diCalcFrtRtAmt
	 */
	public String getDiCalcFrtRtAmt() {
		return this.diCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param dryCgoFlg
	 */
	public void setDryCgoFlg(String dryCgoFlg) {
		this.dryCgoFlg = dryCgoFlg;
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
	 * @param dihFlg
	 */
	public void setDihFlg(String dihFlg) {
		this.dihFlg = dihFlg;
	}

	/**
	 * Column Info
	 * @param daCurrCd
	 */
	public void setDaCurrCd(String daCurrCd) {
		this.daCurrCd = daCurrCd;
	}

	/**
	 * Column Info
	 * @param daCalcFrtRtAmt
	 */
	public void setDaCalcFrtRtAmt(String daCalcFrtRtAmt) {
		this.daCalcFrtRtAmt = daCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param triPropNo
	 */
	public void setTriPropNo(String triPropNo) {
		this.triPropNo = triPropNo;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtHdrSeq
	 */
	public void setPrcCmdtHdrSeq(String prcCmdtHdrSeq) {
		this.prcCmdtHdrSeq = prcCmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param porMtchFlg
	 */
	public void setPorMtchFlg(String porMtchFlg) {
		this.porMtchFlg = porMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param daAddChgSeq
	 */
	public void setDaAddChgSeq(String daAddChgSeq) {
		this.daAddChgSeq = daAddChgSeq;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}

	/**
	 * Column Info
	 * @param oaCurrCd
	 */
	public void setOaCurrCd(String oaCurrCd) {
		this.oaCurrCd = oaCurrCd;
	}

	/**
	 * Column Info
	 * @param oaCalcFrtRtAmt
	 */
	public void setOaCalcFrtRtAmt(String oaCalcFrtRtAmt) {
		this.oaCalcFrtRtAmt = oaCalcFrtRtAmt;
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
	 * @param cgoCateCd
	 */
	public void setCgoCateCd(String cgoCateCd) {
		this.cgoCateCd = cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
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
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param prcGenSpclRtTpCd
	 */
	public void setPrcGenSpclRtTpCd(String prcGenSpclRtTpCd) {
		this.prcGenSpclRtTpCd = prcGenSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param ofrtSeq
	 */
	public void setOfrtSeq(String ofrtSeq) {
		this.ofrtSeq = ofrtSeq;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
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
	 * @param oaAddChgSeq
	 */
	public void setOaAddChgSeq(String oaAddChgSeq) {
		this.oaAddChgSeq = oaAddChgSeq;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param chgUtAmt
	 */
	public void setChgUtAmt(String chgUtAmt) {
		this.chgUtAmt = chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @param oihFlg
	 */
	public void setOihFlg(String oihFlg) {
		this.oihFlg = oihFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgBqOccrSeq
	 */
	public void setBkgBqOccrSeq(String bkgBqOccrSeq) {
		this.bkgBqOccrSeq = bkgBqOccrSeq;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param prcRoutSeq
	 */
	public void setPrcRoutSeq(String prcRoutSeq) {
		this.prcRoutSeq = prcRoutSeq;
	}

	/**
	 * Column Info
	 * @param eqSubstCntrTpszCd
	 */
	public void setEqSubstCntrTpszCd(String eqSubstCntrTpszCd) {
		this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
	}

	/**
	 * Column Info
	 * @param ctrtCntrTpszCd
	 */
	public void setCtrtCntrTpszCd(String ctrtCntrTpszCd) {
		this.ctrtCntrTpszCd = ctrtCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param delMtchFlg
	 */
	public void setDelMtchFlg(String delMtchFlg) {
		this.delMtchFlg = delMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param oftCmbSeq
	 */
	public void setOftCmbSeq(String oftCmbSeq) {
		this.oftCmbSeq = oftCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param rtCalcFrtRtAmt
	 */
	public void setRtCalcFrtRtAmt(String rtCalcFrtRtAmt) {
		this.rtCalcFrtRtAmt = rtCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param prcRtSeq
	 */
	public void setPrcRtSeq(String prcRtSeq) {
		this.prcRtSeq = prcRtSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgBqSeq
	 */
	public void setBkgBqSeq(String bkgBqSeq) {
		this.bkgBqSeq = bkgBqSeq;
	}
	
	/**
	 * Column Info
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param ratAsQty
	 */
	public void setRatAsQty(String ratAsQty) {
		this.ratAsQty = ratAsQty;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param fnlFrtRtAmt
	 */
	public void setFnlFrtRtAmt(String fnlFrtRtAmt) {
		this.fnlFrtRtAmt = fnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param inclOftFlg
	 */
	public void setInclOftFlg(String inclOftFlg) {
		this.inclOftFlg = inclOftFlg;
	}
	
	/**
	 * Column Info
	 * @param oiCalcFrtRtAmt
	 */
	public void setOiCalcFrtRtAmt(String oiCalcFrtRtAmt) {
		this.oiCalcFrtRtAmt = oiCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param oiCurrCd
	 */
	public void setOiCurrCd(String oiCurrCd) {
		this.oiCurrCd = oiCurrCd;
	}
	
	/**
	 * Column Info
	 * @param diCalcFrtRtAmt
	 */
	public void setDiCalcFrtRtAmt(String diCalcFrtRtAmt) {
		this.diCalcFrtRtAmt = diCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param diCurrCd
	 */
	public void setDiCurrCd(String diCurrCd) {
		this.diCurrCd = diCurrCd;
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
		setDryCgoFlg(JSPUtil.getParameter(request, prefix + "dry_cgo_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDihFlg(JSPUtil.getParameter(request, prefix + "dih_flg", ""));
		setDaCurrCd(JSPUtil.getParameter(request, prefix + "da_curr_cd", ""));
		setDaCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "da_calc_frt_rt_amt", ""));
		setTriPropNo(JSPUtil.getParameter(request, prefix + "tri_prop_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPrcCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "prc_cmdt_hdr_seq", ""));
		setPorMtchFlg(JSPUtil.getParameter(request, prefix + "por_mtch_flg", ""));
		setDaAddChgSeq(JSPUtil.getParameter(request, prefix + "da_add_chg_seq", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setOaCurrCd(JSPUtil.getParameter(request, prefix + "oa_curr_cd", ""));
		setOaCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "oa_calc_frt_rt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCgoCateCd(JSPUtil.getParameter(request, prefix + "cgo_cate_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setPrcGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "prc_gen_spcl_rt_tp_cd", ""));
		setOfrtSeq(JSPUtil.getParameter(request, prefix + "ofrt_seq", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOaAddChgSeq(JSPUtil.getParameter(request, prefix + "oa_add_chg_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setChgUtAmt(JSPUtil.getParameter(request, prefix + "chg_ut_amt", ""));
		setOihFlg(JSPUtil.getParameter(request, prefix + "oih_flg", ""));
		setBkgBqOccrSeq(JSPUtil.getParameter(request, prefix + "bkg_bq_occr_seq", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setPrcRoutSeq(JSPUtil.getParameter(request, prefix + "prc_rout_seq", ""));
		setEqSubstCntrTpszCd(JSPUtil.getParameter(request, prefix + "eq_subst_cntr_tpsz_cd", ""));
		setCtrtCntrTpszCd(JSPUtil.getParameter(request, prefix + "ctrt_cntr_tpsz_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setDelMtchFlg(JSPUtil.getParameter(request, prefix + "del_mtch_flg", ""));
		setOftCmbSeq(JSPUtil.getParameter(request, prefix + "oft_cmb_seq", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRtCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_calc_frt_rt_amt", ""));
		setPrcRtSeq(JSPUtil.getParameter(request, prefix + "prc_rt_seq", ""));
		setBkgBqSeq(JSPUtil.getParameter(request, prefix + "bkg_bq_seq", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setRatAsQty(JSPUtil.getParameter(request, prefix + "rat_as_qty", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt", ""));
		setInclOftFlg(JSPUtil.getParameter(request, prefix + "incl_oft_flg", ""));
		setOiCurrCd(JSPUtil.getParameter(request, prefix + "oi_curr_cd", ""));
		setOiCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "oi_calc_frt_rt_amt", ""));
		setDiCurrCd(JSPUtil.getParameter(request, prefix + "di_curr_cd", ""));
		setDiCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "di_calc_frt_rt_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreateSurchargeInputVO[]
	 */
	public CreateSurchargeInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreateSurchargeInputVO[]
	 */
	public CreateSurchargeInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreateSurchargeInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dryCgoFlg = (JSPUtil.getParameter(request, prefix	+ "dry_cgo_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] dihFlg = (JSPUtil.getParameter(request, prefix	+ "dih_flg", length));
			String[] daCurrCd = (JSPUtil.getParameter(request, prefix	+ "da_curr_cd", length));
			String[] daCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "da_calc_frt_rt_amt", length));
			String[] triPropNo = (JSPUtil.getParameter(request, prefix	+ "tri_prop_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] prcCmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_hdr_seq", length));
			String[] porMtchFlg = (JSPUtil.getParameter(request, prefix	+ "por_mtch_flg", length));
			String[] daAddChgSeq = (JSPUtil.getParameter(request, prefix	+ "da_add_chg_seq", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] oaCurrCd = (JSPUtil.getParameter(request, prefix	+ "oa_curr_cd", length));
			String[] oaCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "oa_calc_frt_rt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cgoCateCd = (JSPUtil.getParameter(request, prefix	+ "cgo_cate_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] prcGenSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_gen_spcl_rt_tp_cd", length));
			String[] ofrtSeq = (JSPUtil.getParameter(request, prefix	+ "ofrt_seq", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] oaAddChgSeq = (JSPUtil.getParameter(request, prefix	+ "oa_add_chg_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] oihFlg = (JSPUtil.getParameter(request, prefix	+ "oih_flg", length));
			String[] bkgBqOccrSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_bq_occr_seq", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] prcRoutSeq = (JSPUtil.getParameter(request, prefix	+ "prc_rout_seq", length));
			String[] eqSubstCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_subst_cntr_tpsz_cd", length));
			String[] ctrtCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cntr_tpsz_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] delMtchFlg = (JSPUtil.getParameter(request, prefix	+ "del_mtch_flg", length));
			String[] oftCmbSeq = (JSPUtil.getParameter(request, prefix	+ "oft_cmb_seq", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rtCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_calc_frt_rt_amt", length));
			String[] prcRtSeq = (JSPUtil.getParameter(request, prefix	+ "prc_rt_seq", length));
			String[] bkgBqSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_bq_seq", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] fnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt", length));
			String[] inclOftFlg = (JSPUtil.getParameter(request, prefix	+ "incl_oft_flg", length));
			String[] oiCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "oi_calc_frt_rt_amt", length));
			String[] oiCurrCd = (JSPUtil.getParameter(request, prefix	+ "oi_curr_cd", length));
			String[] diCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "di_calc_frt_rt_amt", length));
			String[] diCurrCd = (JSPUtil.getParameter(request, prefix	+ "di_curr_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CreateSurchargeInputVO();
				if (dryCgoFlg[i] != null)
					model.setDryCgoFlg(dryCgoFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (dihFlg[i] != null)
					model.setDihFlg(dihFlg[i]);
				if (daCurrCd[i] != null)
					model.setDaCurrCd(daCurrCd[i]);
				if (daCalcFrtRtAmt[i] != null)
					model.setDaCalcFrtRtAmt(daCalcFrtRtAmt[i]);
				if (triPropNo[i] != null)
					model.setTriPropNo(triPropNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (prcCmdtHdrSeq[i] != null)
					model.setPrcCmdtHdrSeq(prcCmdtHdrSeq[i]);
				if (porMtchFlg[i] != null)
					model.setPorMtchFlg(porMtchFlg[i]);
				if (daAddChgSeq[i] != null)
					model.setDaAddChgSeq(daAddChgSeq[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (oaCurrCd[i] != null)
					model.setOaCurrCd(oaCurrCd[i]);
				if (oaCalcFrtRtAmt[i] != null)
					model.setOaCalcFrtRtAmt(oaCalcFrtRtAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cgoCateCd[i] != null)
					model.setCgoCateCd(cgoCateCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (prcGenSpclRtTpCd[i] != null)
					model.setPrcGenSpclRtTpCd(prcGenSpclRtTpCd[i]);
				if (ofrtSeq[i] != null)
					model.setOfrtSeq(ofrtSeq[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (oaAddChgSeq[i] != null)
					model.setOaAddChgSeq(oaAddChgSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (oihFlg[i] != null)
					model.setOihFlg(oihFlg[i]);
				if (bkgBqOccrSeq[i] != null)
					model.setBkgBqOccrSeq(bkgBqOccrSeq[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (prcRoutSeq[i] != null)
					model.setPrcRoutSeq(prcRoutSeq[i]);
				if (eqSubstCntrTpszCd[i] != null)
					model.setEqSubstCntrTpszCd(eqSubstCntrTpszCd[i]);
				if (ctrtCntrTpszCd[i] != null)
					model.setCtrtCntrTpszCd(ctrtCntrTpszCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (delMtchFlg[i] != null)
					model.setDelMtchFlg(delMtchFlg[i]);
				if (oftCmbSeq[i] != null)
					model.setOftCmbSeq(oftCmbSeq[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rtCalcFrtRtAmt[i] != null)
					model.setRtCalcFrtRtAmt(rtCalcFrtRtAmt[i]);
				if (prcRtSeq[i] != null)
					model.setPrcRtSeq(prcRtSeq[i]);
				if (bkgBqSeq[i] != null)
					model.setBkgBqSeq(bkgBqSeq[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (fnlFrtRtAmt[i] != null)
					model.setFnlFrtRtAmt(fnlFrtRtAmt[i]);
				if (inclOftFlg[i] != null)
					model.setInclOftFlg(inclOftFlg[i]);
				if (oiCalcFrtRtAmt[i] != null)
					model.setOiCalcFrtRtAmt(oiCalcFrtRtAmt[i]);
				if (oiCurrCd[i] != null)
					model.setOiCurrCd(oiCurrCd[i]);
				if (diCalcFrtRtAmt[i] != null)
					model.setDiCalcFrtRtAmt(diCalcFrtRtAmt[i]);
				if (diCurrCd[i] != null)
					model.setDiCurrCd(diCurrCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreateSurchargeInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreateSurchargeInputVO[]
	 */
	public CreateSurchargeInputVO[] getCreateSurchargeInputVOs(){
		CreateSurchargeInputVO[] vos = (CreateSurchargeInputVO[])models.toArray(new CreateSurchargeInputVO[models.size()]);
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
		this.dryCgoFlg = this.dryCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dihFlg = this.dihFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daCurrCd = this.daCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daCalcFrtRtAmt = this.daCalcFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triPropNo = this.triPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtHdrSeq = this.prcCmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porMtchFlg = this.porMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daAddChgSeq = this.daAddChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaCurrCd = this.oaCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaCalcFrtRtAmt = this.oaCalcFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCateCd = this.cgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcGenSpclRtTpCd = this.prcGenSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofrtSeq = this.ofrtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaAddChgSeq = this.oaAddChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oihFlg = this.oihFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBqOccrSeq = this.bkgBqOccrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRoutSeq = this.prcRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstCntrTpszCd = this.eqSubstCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCntrTpszCd = this.ctrtCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delMtchFlg = this.delMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftCmbSeq = this.oftCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCalcFrtRtAmt = this.rtCalcFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRtSeq = this.prcRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBqSeq = this.bkgBqSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt = this.fnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclOftFlg = this.inclOftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiCurrCd = this.oiCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiCalcFrtRtAmt = this.oiCalcFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diCurrCd = this.diCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diCalcFrtRtAmt = this.diCalcFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
