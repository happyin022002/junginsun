/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltTriRtListVO.java
*@FileTitle : RsltTriRtListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.21
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2010.12.21 송호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo;

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
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltTriRtListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltTriRtListVO> models = new ArrayList<RsltTriRtListVO>();
	
	/* Column Info */
	private String prsScgAmt = null;
	/* Column Info */
	private String prsRespbCmUcAmt = null;
	/* Column Info */
	private String triRmk = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String griApplAmt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String diff = null;
	/* Column Info */
	private String pubDt = null;
	/* Column Info */
	private String triPropNo = null;
	/* Column Info */
	private String noteCtnt = null;
	/* Column Info */
	private String coffrFrtRtAmt = null;
	/* Column Info */
	private String prsUpdDt = null;
	/* Column Info */
	private String fnlFrtRtAmt = null;
	/* Column Info */
	private String triRqstUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prsRtCmpbCalcFlg = null;
	/* Column Info */
	private String prsPfitCmpbAmt = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String triAproUsrId = null;
	/* Column Info */
	private String prsRespbOpfitUcAmt = null;
	/* Column Info */
	private String propStsCd = null;
	/* Column Info */
	private String triRqstUsrNm = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String prsPfitCmUcAmt = null;
	/* Column Info */
	private String triRqstOfcCd = null;
	/* Column Info */
	private String triAproOfcCd = null;
	/* Column Info */
	private String griApplTpCd = null;
	/* Column Info */
	private String propFrtRtAmt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String prsRespbCmpbAmt = null;
	/* Column Info */
	private String noteConvMapgId = null;
	/* Column Info */
	private String prsGidCmpbAmt = null;
	/* Column Info */
	private String prsRespbOpbAmt = null;
	/* Column Info */
	private String propStsNm = null;
	/* Column Info */
	private String triAproUsrNm = null;
	/* Column Info */
	private String triNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltTriRtListVO() {}

	public RsltTriRtListVO(String ibflag, String pagerows, String triPropNo, String amdtSeq, String ratUtCd, String prcCgoTpCd, String currCd, String propFrtRtAmt, String coffrFrtRtAmt, String fnlFrtRtAmt, String noteCtnt, String noteConvMapgId, String effDt, String expDt, String prsScgAmt, String prsRespbCmUcAmt, String prsRespbOpfitUcAmt, String prsRespbCmpbAmt, String prsGidCmpbAmt, String prsRespbOpbAmt, String diff, String prsPfitCmUcAmt, String prsPfitCmpbAmt, String prsUpdDt, String triRqstOfcCd, String triRqstUsrId, String triRqstUsrNm, String triAproOfcCd, String triAproUsrId, String triAproUsrNm, String propStsCd, String propStsNm, String pubDt, String griApplTpCd, String griApplAmt, String emlSndDt, String triNo, String cmdtCd, String prsRtCmpbCalcFlg, String triRmk) {
		this.prsScgAmt = prsScgAmt;
		this.prsRespbCmUcAmt = prsRespbCmUcAmt;
		this.triRmk = triRmk;
		this.emlSndDt = emlSndDt;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.griApplAmt = griApplAmt;
		this.amdtSeq = amdtSeq;
		this.diff = diff;
		this.pubDt = pubDt;
		this.triPropNo = triPropNo;
		this.noteCtnt = noteCtnt;
		this.coffrFrtRtAmt = coffrFrtRtAmt;
		this.prsUpdDt = prsUpdDt;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.triRqstUsrId = triRqstUsrId;
		this.pagerows = pagerows;
		this.prsRtCmpbCalcFlg = prsRtCmpbCalcFlg;
		this.prsPfitCmpbAmt = prsPfitCmpbAmt;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.triAproUsrId = triAproUsrId;
		this.prsRespbOpfitUcAmt = prsRespbOpfitUcAmt;
		this.propStsCd = propStsCd;
		this.triRqstUsrNm = triRqstUsrNm;
		this.expDt = expDt;
		this.prsPfitCmUcAmt = prsPfitCmUcAmt;
		this.triRqstOfcCd = triRqstOfcCd;
		this.triAproOfcCd = triAproOfcCd;
		this.griApplTpCd = griApplTpCd;
		this.propFrtRtAmt = propFrtRtAmt;
		this.ratUtCd = ratUtCd;
		this.prsRespbCmpbAmt = prsRespbCmpbAmt;
		this.noteConvMapgId = noteConvMapgId;
		this.prsGidCmpbAmt = prsGidCmpbAmt;
		this.prsRespbOpbAmt = prsRespbOpbAmt;
		this.propStsNm = propStsNm;
		this.triAproUsrNm = triAproUsrNm;
		this.triNo = triNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prs_scg_amt", getPrsScgAmt());
		this.hashColumns.put("prs_respb_cm_uc_amt", getPrsRespbCmUcAmt());
		this.hashColumns.put("tri_rmk", getTriRmk());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("gri_appl_amt", getGriApplAmt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("diff", getDiff());
		this.hashColumns.put("pub_dt", getPubDt());
		this.hashColumns.put("tri_prop_no", getTriPropNo());
		this.hashColumns.put("note_ctnt", getNoteCtnt());
		this.hashColumns.put("coffr_frt_rt_amt", getCoffrFrtRtAmt());
		this.hashColumns.put("prs_upd_dt", getPrsUpdDt());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("tri_rqst_usr_id", getTriRqstUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prs_rt_cmpb_calc_flg", getPrsRtCmpbCalcFlg());
		this.hashColumns.put("prs_pfit_cmpb_amt", getPrsPfitCmpbAmt());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("tri_apro_usr_id", getTriAproUsrId());
		this.hashColumns.put("prs_respb_opfit_uc_amt", getPrsRespbOpfitUcAmt());
		this.hashColumns.put("prop_sts_cd", getPropStsCd());
		this.hashColumns.put("tri_rqst_usr_nm", getTriRqstUsrNm());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("prs_pfit_cm_uc_amt", getPrsPfitCmUcAmt());
		this.hashColumns.put("tri_rqst_ofc_cd", getTriRqstOfcCd());
		this.hashColumns.put("tri_apro_ofc_cd", getTriAproOfcCd());
		this.hashColumns.put("gri_appl_tp_cd", getGriApplTpCd());
		this.hashColumns.put("prop_frt_rt_amt", getPropFrtRtAmt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("prs_respb_cmpb_amt", getPrsRespbCmpbAmt());
		this.hashColumns.put("note_conv_mapg_id", getNoteConvMapgId());
		this.hashColumns.put("prs_gid_cmpb_amt", getPrsGidCmpbAmt());
		this.hashColumns.put("prs_respb_opb_amt", getPrsRespbOpbAmt());
		this.hashColumns.put("prop_sts_nm", getPropStsNm());
		this.hashColumns.put("tri_apro_usr_nm", getTriAproUsrNm());
		this.hashColumns.put("tri_no", getTriNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prs_scg_amt", "prsScgAmt");
		this.hashFields.put("prs_respb_cm_uc_amt", "prsRespbCmUcAmt");
		this.hashFields.put("tri_rmk", "triRmk");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("gri_appl_amt", "griApplAmt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("diff", "diff");
		this.hashFields.put("pub_dt", "pubDt");
		this.hashFields.put("tri_prop_no", "triPropNo");
		this.hashFields.put("note_ctnt", "noteCtnt");
		this.hashFields.put("coffr_frt_rt_amt", "coffrFrtRtAmt");
		this.hashFields.put("prs_upd_dt", "prsUpdDt");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("tri_rqst_usr_id", "triRqstUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prs_rt_cmpb_calc_flg", "prsRtCmpbCalcFlg");
		this.hashFields.put("prs_pfit_cmpb_amt", "prsPfitCmpbAmt");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("tri_apro_usr_id", "triAproUsrId");
		this.hashFields.put("prs_respb_opfit_uc_amt", "prsRespbOpfitUcAmt");
		this.hashFields.put("prop_sts_cd", "propStsCd");
		this.hashFields.put("tri_rqst_usr_nm", "triRqstUsrNm");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("prs_pfit_cm_uc_amt", "prsPfitCmUcAmt");
		this.hashFields.put("tri_rqst_ofc_cd", "triRqstOfcCd");
		this.hashFields.put("tri_apro_ofc_cd", "triAproOfcCd");
		this.hashFields.put("gri_appl_tp_cd", "griApplTpCd");
		this.hashFields.put("prop_frt_rt_amt", "propFrtRtAmt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("prs_respb_cmpb_amt", "prsRespbCmpbAmt");
		this.hashFields.put("note_conv_mapg_id", "noteConvMapgId");
		this.hashFields.put("prs_gid_cmpb_amt", "prsGidCmpbAmt");
		this.hashFields.put("prs_respb_opb_amt", "prsRespbOpbAmt");
		this.hashFields.put("prop_sts_nm", "propStsNm");
		this.hashFields.put("tri_apro_usr_nm", "triAproUsrNm");
		this.hashFields.put("tri_no", "triNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return prsScgAmt
	 */
	public String getPrsScgAmt() {
		return this.prsScgAmt;
	}
	
	/**
	 * Column Info
	 * @return prsRespbCmUcAmt
	 */
	public String getPrsRespbCmUcAmt() {
		return this.prsRespbCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return triRmk
	 */
	public String getTriRmk() {
		return this.triRmk;
	}
	
	/**
	 * Column Info
	 * @return emlSndDt
	 */
	public String getEmlSndDt() {
		return this.emlSndDt;
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
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return griApplAmt
	 */
	public String getGriApplAmt() {
		return this.griApplAmt;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return diff
	 */
	public String getDiff() {
		return this.diff;
	}
	
	/**
	 * Column Info
	 * @return pubDt
	 */
	public String getPubDt() {
		return this.pubDt;
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
	 * @return noteCtnt
	 */
	public String getNoteCtnt() {
		return this.noteCtnt;
	}
	
	/**
	 * Column Info
	 * @return coffrFrtRtAmt
	 */
	public String getCoffrFrtRtAmt() {
		return this.coffrFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return prsUpdDt
	 */
	public String getPrsUpdDt() {
		return this.prsUpdDt;
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
	 * @return triRqstUsrId
	 */
	public String getTriRqstUsrId() {
		return this.triRqstUsrId;
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
	 * @return prsRtCmpbCalcFlg
	 */
	public String getPrsRtCmpbCalcFlg() {
		return this.prsRtCmpbCalcFlg;
	}
	
	/**
	 * Column Info
	 * @return prsPfitCmpbAmt
	 */
	public String getPrsPfitCmpbAmt() {
		return this.prsPfitCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return triAproUsrId
	 */
	public String getTriAproUsrId() {
		return this.triAproUsrId;
	}
	
	/**
	 * Column Info
	 * @return prsRespbOpfitUcAmt
	 */
	public String getPrsRespbOpfitUcAmt() {
		return this.prsRespbOpfitUcAmt;
	}
	
	/**
	 * Column Info
	 * @return propStsCd
	 */
	public String getPropStsCd() {
		return this.propStsCd;
	}
	
	/**
	 * Column Info
	 * @return triRqstUsrNm
	 */
	public String getTriRqstUsrNm() {
		return this.triRqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return prsPfitCmUcAmt
	 */
	public String getPrsPfitCmUcAmt() {
		return this.prsPfitCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return triRqstOfcCd
	 */
	public String getTriRqstOfcCd() {
		return this.triRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return triAproOfcCd
	 */
	public String getTriAproOfcCd() {
		return this.triAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return griApplTpCd
	 */
	public String getGriApplTpCd() {
		return this.griApplTpCd;
	}
	
	/**
	 * Column Info
	 * @return propFrtRtAmt
	 */
	public String getPropFrtRtAmt() {
		return this.propFrtRtAmt;
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
	 * @return prsRespbCmpbAmt
	 */
	public String getPrsRespbCmpbAmt() {
		return this.prsRespbCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return noteConvMapgId
	 */
	public String getNoteConvMapgId() {
		return this.noteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @return prsGidCmpbAmt
	 */
	public String getPrsGidCmpbAmt() {
		return this.prsGidCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return prsRespbOpbAmt
	 */
	public String getPrsRespbOpbAmt() {
		return this.prsRespbOpbAmt;
	}
	
	/**
	 * Column Info
	 * @return propStsNm
	 */
	public String getPropStsNm() {
		return this.propStsNm;
	}
	
	/**
	 * Column Info
	 * @return triAproUsrNm
	 */
	public String getTriAproUsrNm() {
		return this.triAproUsrNm;
	}
	
	/**
	 * Column Info
	 * @return triNo
	 */
	public String getTriNo() {
		return this.triNo;
	}
	

	/**
	 * Column Info
	 * @param prsScgAmt
	 */
	public void setPrsScgAmt(String prsScgAmt) {
		this.prsScgAmt = prsScgAmt;
	}
	
	/**
	 * Column Info
	 * @param prsRespbCmUcAmt
	 */
	public void setPrsRespbCmUcAmt(String prsRespbCmUcAmt) {
		this.prsRespbCmUcAmt = prsRespbCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param triRmk
	 */
	public void setTriRmk(String triRmk) {
		this.triRmk = triRmk;
	}
	
	/**
	 * Column Info
	 * @param emlSndDt
	 */
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
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
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param griApplAmt
	 */
	public void setGriApplAmt(String griApplAmt) {
		this.griApplAmt = griApplAmt;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param diff
	 */
	public void setDiff(String diff) {
		this.diff = diff;
	}
	
	/**
	 * Column Info
	 * @param pubDt
	 */
	public void setPubDt(String pubDt) {
		this.pubDt = pubDt;
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
	 * @param noteCtnt
	 */
	public void setNoteCtnt(String noteCtnt) {
		this.noteCtnt = noteCtnt;
	}
	
	/**
	 * Column Info
	 * @param coffrFrtRtAmt
	 */
	public void setCoffrFrtRtAmt(String coffrFrtRtAmt) {
		this.coffrFrtRtAmt = coffrFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param prsUpdDt
	 */
	public void setPrsUpdDt(String prsUpdDt) {
		this.prsUpdDt = prsUpdDt;
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
	 * @param triRqstUsrId
	 */
	public void setTriRqstUsrId(String triRqstUsrId) {
		this.triRqstUsrId = triRqstUsrId;
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
	 * @param prsRtCmpbCalcFlg
	 */
	public void setPrsRtCmpbCalcFlg(String prsRtCmpbCalcFlg) {
		this.prsRtCmpbCalcFlg = prsRtCmpbCalcFlg;
	}
	
	/**
	 * Column Info
	 * @param prsPfitCmpbAmt
	 */
	public void setPrsPfitCmpbAmt(String prsPfitCmpbAmt) {
		this.prsPfitCmpbAmt = prsPfitCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param triAproUsrId
	 */
	public void setTriAproUsrId(String triAproUsrId) {
		this.triAproUsrId = triAproUsrId;
	}
	
	/**
	 * Column Info
	 * @param prsRespbOpfitUcAmt
	 */
	public void setPrsRespbOpfitUcAmt(String prsRespbOpfitUcAmt) {
		this.prsRespbOpfitUcAmt = prsRespbOpfitUcAmt;
	}
	
	/**
	 * Column Info
	 * @param propStsCd
	 */
	public void setPropStsCd(String propStsCd) {
		this.propStsCd = propStsCd;
	}
	
	/**
	 * Column Info
	 * @param triRqstUsrNm
	 */
	public void setTriRqstUsrNm(String triRqstUsrNm) {
		this.triRqstUsrNm = triRqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param prsPfitCmUcAmt
	 */
	public void setPrsPfitCmUcAmt(String prsPfitCmUcAmt) {
		this.prsPfitCmUcAmt = prsPfitCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param triRqstOfcCd
	 */
	public void setTriRqstOfcCd(String triRqstOfcCd) {
		this.triRqstOfcCd = triRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param triAproOfcCd
	 */
	public void setTriAproOfcCd(String triAproOfcCd) {
		this.triAproOfcCd = triAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param griApplTpCd
	 */
	public void setGriApplTpCd(String griApplTpCd) {
		this.griApplTpCd = griApplTpCd;
	}
	
	/**
	 * Column Info
	 * @param propFrtRtAmt
	 */
	public void setPropFrtRtAmt(String propFrtRtAmt) {
		this.propFrtRtAmt = propFrtRtAmt;
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
	 * @param prsRespbCmpbAmt
	 */
	public void setPrsRespbCmpbAmt(String prsRespbCmpbAmt) {
		this.prsRespbCmpbAmt = prsRespbCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param noteConvMapgId
	 */
	public void setNoteConvMapgId(String noteConvMapgId) {
		this.noteConvMapgId = noteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @param prsGidCmpbAmt
	 */
	public void setPrsGidCmpbAmt(String prsGidCmpbAmt) {
		this.prsGidCmpbAmt = prsGidCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param prsRespbOpbAmt
	 */
	public void setPrsRespbOpbAmt(String prsRespbOpbAmt) {
		this.prsRespbOpbAmt = prsRespbOpbAmt;
	}
	
	/**
	 * Column Info
	 * @param propStsNm
	 */
	public void setPropStsNm(String propStsNm) {
		this.propStsNm = propStsNm;
	}
	
	/**
	 * Column Info
	 * @param triAproUsrNm
	 */
	public void setTriAproUsrNm(String triAproUsrNm) {
		this.triAproUsrNm = triAproUsrNm;
	}
	
	/**
	 * Column Info
	 * @param triNo
	 */
	public void setTriNo(String triNo) {
		this.triNo = triNo;
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
		setPrsScgAmt(JSPUtil.getParameter(request, prefix + "prs_scg_amt", ""));
		setPrsRespbCmUcAmt(JSPUtil.getParameter(request, prefix + "prs_respb_cm_uc_amt", ""));
		setTriRmk(JSPUtil.getParameter(request, prefix + "tri_rmk", ""));
		setEmlSndDt(JSPUtil.getParameter(request, prefix + "eml_snd_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setGriApplAmt(JSPUtil.getParameter(request, prefix + "gri_appl_amt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setDiff(JSPUtil.getParameter(request, prefix + "diff", ""));
		setPubDt(JSPUtil.getParameter(request, prefix + "pub_dt", ""));
		setTriPropNo(JSPUtil.getParameter(request, prefix + "tri_prop_no", ""));
		setNoteCtnt(JSPUtil.getParameter(request, prefix + "note_ctnt", ""));
		setCoffrFrtRtAmt(JSPUtil.getParameter(request, prefix + "coffr_frt_rt_amt", ""));
		setPrsUpdDt(JSPUtil.getParameter(request, prefix + "prs_upd_dt", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt", ""));
		setTriRqstUsrId(JSPUtil.getParameter(request, prefix + "tri_rqst_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrsRtCmpbCalcFlg(JSPUtil.getParameter(request, prefix + "prs_rt_cmpb_calc_flg", ""));
		setPrsPfitCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_pfit_cmpb_amt", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setTriAproUsrId(JSPUtil.getParameter(request, prefix + "tri_apro_usr_id", ""));
		setPrsRespbOpfitUcAmt(JSPUtil.getParameter(request, prefix + "prs_respb_opfit_uc_amt", ""));
		setPropStsCd(JSPUtil.getParameter(request, prefix + "prop_sts_cd", ""));
		setTriRqstUsrNm(JSPUtil.getParameter(request, prefix + "tri_rqst_usr_nm", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setPrsPfitCmUcAmt(JSPUtil.getParameter(request, prefix + "prs_pfit_cm_uc_amt", ""));
		setTriRqstOfcCd(JSPUtil.getParameter(request, prefix + "tri_rqst_ofc_cd", ""));
		setTriAproOfcCd(JSPUtil.getParameter(request, prefix + "tri_apro_ofc_cd", ""));
		setGriApplTpCd(JSPUtil.getParameter(request, prefix + "gri_appl_tp_cd", ""));
		setPropFrtRtAmt(JSPUtil.getParameter(request, prefix + "prop_frt_rt_amt", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setPrsRespbCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_respb_cmpb_amt", ""));
		setNoteConvMapgId(JSPUtil.getParameter(request, prefix + "note_conv_mapg_id", ""));
		setPrsGidCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_gid_cmpb_amt", ""));
		setPrsRespbOpbAmt(JSPUtil.getParameter(request, prefix + "prs_respb_opb_amt", ""));
		setPropStsNm(JSPUtil.getParameter(request, prefix + "prop_sts_nm", ""));
		setTriAproUsrNm(JSPUtil.getParameter(request, prefix + "tri_apro_usr_nm", ""));
		setTriNo(JSPUtil.getParameter(request, prefix + "tri_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltTriRtListVO[]
	 */
	public RsltTriRtListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltTriRtListVO[]
	 */
	public RsltTriRtListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltTriRtListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] prsScgAmt = (JSPUtil.getParameter(request, prefix	+ "prs_scg_amt", length));
			String[] prsRespbCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_cm_uc_amt", length));
			String[] triRmk = (JSPUtil.getParameter(request, prefix	+ "tri_rmk", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] griApplAmt = (JSPUtil.getParameter(request, prefix	+ "gri_appl_amt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] diff = (JSPUtil.getParameter(request, prefix	+ "diff", length));
			String[] pubDt = (JSPUtil.getParameter(request, prefix	+ "pub_dt", length));
			String[] triPropNo = (JSPUtil.getParameter(request, prefix	+ "tri_prop_no", length));
			String[] noteCtnt = (JSPUtil.getParameter(request, prefix	+ "note_ctnt", length));
			String[] coffrFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "coffr_frt_rt_amt", length));
			String[] prsUpdDt = (JSPUtil.getParameter(request, prefix	+ "prs_upd_dt", length));
			String[] fnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt", length));
			String[] triRqstUsrId = (JSPUtil.getParameter(request, prefix	+ "tri_rqst_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prsRtCmpbCalcFlg = (JSPUtil.getParameter(request, prefix	+ "prs_rt_cmpb_calc_flg", length));
			String[] prsPfitCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_pfit_cmpb_amt", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] triAproUsrId = (JSPUtil.getParameter(request, prefix	+ "tri_apro_usr_id", length));
			String[] prsRespbOpfitUcAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_opfit_uc_amt", length));
			String[] propStsCd = (JSPUtil.getParameter(request, prefix	+ "prop_sts_cd", length));
			String[] triRqstUsrNm = (JSPUtil.getParameter(request, prefix	+ "tri_rqst_usr_nm", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] prsPfitCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "prs_pfit_cm_uc_amt", length));
			String[] triRqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "tri_rqst_ofc_cd", length));
			String[] triAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "tri_apro_ofc_cd", length));
			String[] griApplTpCd = (JSPUtil.getParameter(request, prefix	+ "gri_appl_tp_cd", length));
			String[] propFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_frt_rt_amt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] prsRespbCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_cmpb_amt", length));
			String[] noteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "note_conv_mapg_id", length));
			String[] prsGidCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_gid_cmpb_amt", length));
			String[] prsRespbOpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_opb_amt", length));
			String[] propStsNm = (JSPUtil.getParameter(request, prefix	+ "prop_sts_nm", length));
			String[] triAproUsrNm = (JSPUtil.getParameter(request, prefix	+ "tri_apro_usr_nm", length));
			String[] triNo = (JSPUtil.getParameter(request, prefix	+ "tri_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltTriRtListVO();
				if (prsScgAmt[i] != null)
					model.setPrsScgAmt(prsScgAmt[i]);
				if (prsRespbCmUcAmt[i] != null)
					model.setPrsRespbCmUcAmt(prsRespbCmUcAmt[i]);
				if (triRmk[i] != null)
					model.setTriRmk(triRmk[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (griApplAmt[i] != null)
					model.setGriApplAmt(griApplAmt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (diff[i] != null)
					model.setDiff(diff[i]);
				if (pubDt[i] != null)
					model.setPubDt(pubDt[i]);
				if (triPropNo[i] != null)
					model.setTriPropNo(triPropNo[i]);
				if (noteCtnt[i] != null)
					model.setNoteCtnt(noteCtnt[i]);
				if (coffrFrtRtAmt[i] != null)
					model.setCoffrFrtRtAmt(coffrFrtRtAmt[i]);
				if (prsUpdDt[i] != null)
					model.setPrsUpdDt(prsUpdDt[i]);
				if (fnlFrtRtAmt[i] != null)
					model.setFnlFrtRtAmt(fnlFrtRtAmt[i]);
				if (triRqstUsrId[i] != null)
					model.setTriRqstUsrId(triRqstUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prsRtCmpbCalcFlg[i] != null)
					model.setPrsRtCmpbCalcFlg(prsRtCmpbCalcFlg[i]);
				if (prsPfitCmpbAmt[i] != null)
					model.setPrsPfitCmpbAmt(prsPfitCmpbAmt[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (triAproUsrId[i] != null)
					model.setTriAproUsrId(triAproUsrId[i]);
				if (prsRespbOpfitUcAmt[i] != null)
					model.setPrsRespbOpfitUcAmt(prsRespbOpfitUcAmt[i]);
				if (propStsCd[i] != null)
					model.setPropStsCd(propStsCd[i]);
				if (triRqstUsrNm[i] != null)
					model.setTriRqstUsrNm(triRqstUsrNm[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (prsPfitCmUcAmt[i] != null)
					model.setPrsPfitCmUcAmt(prsPfitCmUcAmt[i]);
				if (triRqstOfcCd[i] != null)
					model.setTriRqstOfcCd(triRqstOfcCd[i]);
				if (triAproOfcCd[i] != null)
					model.setTriAproOfcCd(triAproOfcCd[i]);
				if (griApplTpCd[i] != null)
					model.setGriApplTpCd(griApplTpCd[i]);
				if (propFrtRtAmt[i] != null)
					model.setPropFrtRtAmt(propFrtRtAmt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (prsRespbCmpbAmt[i] != null)
					model.setPrsRespbCmpbAmt(prsRespbCmpbAmt[i]);
				if (noteConvMapgId[i] != null)
					model.setNoteConvMapgId(noteConvMapgId[i]);
				if (prsGidCmpbAmt[i] != null)
					model.setPrsGidCmpbAmt(prsGidCmpbAmt[i]);
				if (prsRespbOpbAmt[i] != null)
					model.setPrsRespbOpbAmt(prsRespbOpbAmt[i]);
				if (propStsNm[i] != null)
					model.setPropStsNm(propStsNm[i]);
				if (triAproUsrNm[i] != null)
					model.setTriAproUsrNm(triAproUsrNm[i]);
				if (triNo[i] != null)
					model.setTriNo(triNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltTriRtListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltTriRtListVO[]
	 */
	public RsltTriRtListVO[] getRsltTriRtListVOs(){
		RsltTriRtListVO[] vos = (RsltTriRtListVO[])models.toArray(new RsltTriRtListVO[models.size()]);
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
		this.prsScgAmt = this.prsScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbCmUcAmt = this.prsRespbCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triRmk = this.triRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplAmt = this.griApplAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff = this.diff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubDt = this.pubDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triPropNo = this.triPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt = this.noteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coffrFrtRtAmt = this.coffrFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsUpdDt = this.prsUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt = this.fnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triRqstUsrId = this.triRqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRtCmpbCalcFlg = this.prsRtCmpbCalcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsPfitCmpbAmt = this.prsPfitCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triAproUsrId = this.triAproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbOpfitUcAmt = this.prsRespbOpfitUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsCd = this.propStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triRqstUsrNm = this.triRqstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsPfitCmUcAmt = this.prsPfitCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triRqstOfcCd = this.triRqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triAproOfcCd = this.triAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplTpCd = this.griApplTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtRtAmt = this.propFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbCmpbAmt = this.prsRespbCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvMapgId = this.noteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsGidCmpbAmt = this.prsGidCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbOpbAmt = this.prsRespbOpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsNm = this.propStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triAproUsrNm = this.triAproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triNo = this.triNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
