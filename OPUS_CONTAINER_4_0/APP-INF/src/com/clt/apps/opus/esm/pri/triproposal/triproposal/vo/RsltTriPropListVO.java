/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RsltTriPropListVO.java
*@FileTitle : RsltTriPropListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.25
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2011.02.25 송민석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.triproposal.triproposal.vo;

import java.lang.reflect.Field;
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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltTriPropListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltTriPropListVO> models = new ArrayList<RsltTriPropListVO>();
	
	/* Column Info */
	private String destRoutPntLocNm = null;
	/* Column Info */
	private String destRoutViaPortNmSnd = null;
	/* Column Info */
	private String triRmk = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String griApplAmt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String pubDt = null;
	/* Column Info */
	private String triPropNo = null;
	/* Column Info */
	private String noteCtnt = null;
	/* Column Info */
	private String coffrFrtRtAmt = null;
	/* Column Info */
	private String fnlFrtRtAmt = null;
	/* Column Info */
	private String destRoutViaPortNm = null;
	/* Column Info */
	private String triRqstUsrId = null;
	/* Column Info */
	private String trfCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgRoutViaPortNmSnd = null;
	/* Column Info */
	private String triAproUsrId = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String curStatus = null;
	/* Column Info */
	private String propStsCd = null;
	/* Column Info */
	private String orgRoutPntLocNmSnd = null;
	/* Column Info */
	private String orgRoutViaPortNm = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String trfPfxCd = null;
	/* Column Info */
	private String triRqstOfcCd = null;
	/* Column Info */
	private String triAproOfcCd = null;
	/* Column Info */
	private String griApplTpCd = null;
	/* Column Info */
	private String destRoutPntLocNmSnd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String propFrtRtAmt = null;
	/* Column Info */
	private String lastPubDt = null;
	/* Column Info */
	private String orgRoutPntLocNm = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String noteConvMapgId = null;
	/* Column Info */
	private String propStsNm = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String triNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltTriPropListVO() {}

	public RsltTriPropListVO(String ibflag, String pagerows, String triPropNo, String trfCd, String trfPfxCd, String trfNo, String triNo, String amdtSeq, String curStatus, String pubDt, String cmdtCd, String cmdtNm, String orgRoutPntLocNm, String orgRoutPntLocNmSnd, String orgRoutViaPortNm, String orgRoutViaPortNmSnd, String destRoutViaPortNm, String destRoutViaPortNmSnd, String destRoutPntLocNm, String destRoutPntLocNmSnd, String ratUtCd, String prcCgoTpCd, String currCd, String propFrtRtAmt, String coffrFrtRtAmt, String fnlFrtRtAmt, String noteCtnt, String noteConvMapgId, String effDt, String expDt, String propStsCd, String propStsNm, String griApplTpCd, String griApplAmt, String triRqstOfcCd, String triAproOfcCd, String triRqstUsrId, String triAproUsrId, String lastPubDt, String triRmk) {
		this.destRoutPntLocNm = destRoutPntLocNm;
		this.destRoutViaPortNmSnd = destRoutViaPortNmSnd;
		this.triRmk = triRmk;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.griApplAmt = griApplAmt;
		this.amdtSeq = amdtSeq;
		this.pubDt = pubDt;
		this.triPropNo = triPropNo;
		this.noteCtnt = noteCtnt;
		this.coffrFrtRtAmt = coffrFrtRtAmt;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.destRoutViaPortNm = destRoutViaPortNm;
		this.triRqstUsrId = triRqstUsrId;
		this.trfCd = trfCd;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.orgRoutViaPortNmSnd = orgRoutViaPortNmSnd;
		this.triAproUsrId = triAproUsrId;
		this.cmdtCd = cmdtCd;
		this.curStatus = curStatus;
		this.propStsCd = propStsCd;
		this.orgRoutPntLocNmSnd = orgRoutPntLocNmSnd;
		this.orgRoutViaPortNm = orgRoutViaPortNm;
		this.expDt = expDt;
		this.trfPfxCd = trfPfxCd;
		this.triRqstOfcCd = triRqstOfcCd;
		this.triAproOfcCd = triAproOfcCd;
		this.griApplTpCd = griApplTpCd;
		this.destRoutPntLocNmSnd = destRoutPntLocNmSnd;
		this.ratUtCd = ratUtCd;
		this.propFrtRtAmt = propFrtRtAmt;
		this.lastPubDt = lastPubDt;
		this.orgRoutPntLocNm = orgRoutPntLocNm;
		this.cmdtNm = cmdtNm;
		this.noteConvMapgId = noteConvMapgId;
		this.propStsNm = propStsNm;
		this.trfNo = trfNo;
		this.triNo = triNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dest_rout_pnt_loc_nm", getDestRoutPntLocNm());
		this.hashColumns.put("dest_rout_via_port_nm_snd", getDestRoutViaPortNmSnd());
		this.hashColumns.put("tri_rmk", getTriRmk());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("gri_appl_amt", getGriApplAmt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("pub_dt", getPubDt());
		this.hashColumns.put("tri_prop_no", getTriPropNo());
		this.hashColumns.put("note_ctnt", getNoteCtnt());
		this.hashColumns.put("coffr_frt_rt_amt", getCoffrFrtRtAmt());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("dest_rout_via_port_nm", getDestRoutViaPortNm());
		this.hashColumns.put("tri_rqst_usr_id", getTriRqstUsrId());
		this.hashColumns.put("trf_cd", getTrfCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_rout_via_port_nm_snd", getOrgRoutViaPortNmSnd());
		this.hashColumns.put("tri_apro_usr_id", getTriAproUsrId());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cur_status", getCurStatus());
		this.hashColumns.put("prop_sts_cd", getPropStsCd());
		this.hashColumns.put("org_rout_pnt_loc_nm_snd", getOrgRoutPntLocNmSnd());
		this.hashColumns.put("org_rout_via_port_nm", getOrgRoutViaPortNm());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("trf_pfx_cd", getTrfPfxCd());
		this.hashColumns.put("tri_rqst_ofc_cd", getTriRqstOfcCd());
		this.hashColumns.put("tri_apro_ofc_cd", getTriAproOfcCd());
		this.hashColumns.put("gri_appl_tp_cd", getGriApplTpCd());
		this.hashColumns.put("dest_rout_pnt_loc_nm_snd", getDestRoutPntLocNmSnd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("prop_frt_rt_amt", getPropFrtRtAmt());
		this.hashColumns.put("last_pub_dt", getLastPubDt());
		this.hashColumns.put("org_rout_pnt_loc_nm", getOrgRoutPntLocNm());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("note_conv_mapg_id", getNoteConvMapgId());
		this.hashColumns.put("prop_sts_nm", getPropStsNm());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("tri_no", getTriNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dest_rout_pnt_loc_nm", "destRoutPntLocNm");
		this.hashFields.put("dest_rout_via_port_nm_snd", "destRoutViaPortNmSnd");
		this.hashFields.put("tri_rmk", "triRmk");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("gri_appl_amt", "griApplAmt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("pub_dt", "pubDt");
		this.hashFields.put("tri_prop_no", "triPropNo");
		this.hashFields.put("note_ctnt", "noteCtnt");
		this.hashFields.put("coffr_frt_rt_amt", "coffrFrtRtAmt");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("dest_rout_via_port_nm", "destRoutViaPortNm");
		this.hashFields.put("tri_rqst_usr_id", "triRqstUsrId");
		this.hashFields.put("trf_cd", "trfCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_rout_via_port_nm_snd", "orgRoutViaPortNmSnd");
		this.hashFields.put("tri_apro_usr_id", "triAproUsrId");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cur_status", "curStatus");
		this.hashFields.put("prop_sts_cd", "propStsCd");
		this.hashFields.put("org_rout_pnt_loc_nm_snd", "orgRoutPntLocNmSnd");
		this.hashFields.put("org_rout_via_port_nm", "orgRoutViaPortNm");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("trf_pfx_cd", "trfPfxCd");
		this.hashFields.put("tri_rqst_ofc_cd", "triRqstOfcCd");
		this.hashFields.put("tri_apro_ofc_cd", "triAproOfcCd");
		this.hashFields.put("gri_appl_tp_cd", "griApplTpCd");
		this.hashFields.put("dest_rout_pnt_loc_nm_snd", "destRoutPntLocNmSnd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("prop_frt_rt_amt", "propFrtRtAmt");
		this.hashFields.put("last_pub_dt", "lastPubDt");
		this.hashFields.put("org_rout_pnt_loc_nm", "orgRoutPntLocNm");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("note_conv_mapg_id", "noteConvMapgId");
		this.hashFields.put("prop_sts_nm", "propStsNm");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("tri_no", "triNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocNm
	 */
	public String getDestRoutPntLocNm() {
		return this.destRoutPntLocNm;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortNmSnd
	 */
	public String getDestRoutViaPortNmSnd() {
		return this.destRoutViaPortNmSnd;
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
	 * @return fnlFrtRtAmt
	 */
	public String getFnlFrtRtAmt() {
		return this.fnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortNm
	 */
	public String getDestRoutViaPortNm() {
		return this.destRoutViaPortNm;
	}
	
	/**
	 * Column Info
	 * @return triRqstUsrId
	 */
	public String getTriRqstUsrId() {
		return this.triRqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return trfCd
	 */
	public String getTrfCd() {
		return this.trfCd;
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
	 * @return orgRoutViaPortNmSnd
	 */
	public String getOrgRoutViaPortNmSnd() {
		return this.orgRoutViaPortNmSnd;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return curStatus
	 */
	public String getCurStatus() {
		return this.curStatus;
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
	 * @return orgRoutPntLocNmSnd
	 */
	public String getOrgRoutPntLocNmSnd() {
		return this.orgRoutPntLocNmSnd;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortNm
	 */
	public String getOrgRoutViaPortNm() {
		return this.orgRoutViaPortNm;
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
	 * @return trfPfxCd
	 */
	public String getTrfPfxCd() {
		return this.trfPfxCd;
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
	 * @return destRoutPntLocNmSnd
	 */
	public String getDestRoutPntLocNmSnd() {
		return this.destRoutPntLocNmSnd;
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
	 * @return propFrtRtAmt
	 */
	public String getPropFrtRtAmt() {
		return this.propFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return lastPubDt
	 */
	public String getLastPubDt() {
		return this.lastPubDt;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocNm
	 */
	public String getOrgRoutPntLocNm() {
		return this.orgRoutPntLocNm;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return propStsNm
	 */
	public String getPropStsNm() {
		return this.propStsNm;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
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
	 * @param destRoutPntLocNm
	 */
	public void setDestRoutPntLocNm(String destRoutPntLocNm) {
		this.destRoutPntLocNm = destRoutPntLocNm;
	}
	
	/**
	 * Column Info
	 * @param destRoutViaPortNmSnd
	 */
	public void setDestRoutViaPortNmSnd(String destRoutViaPortNmSnd) {
		this.destRoutViaPortNmSnd = destRoutViaPortNmSnd;
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
	 * @param fnlFrtRtAmt
	 */
	public void setFnlFrtRtAmt(String fnlFrtRtAmt) {
		this.fnlFrtRtAmt = fnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param destRoutViaPortNm
	 */
	public void setDestRoutViaPortNm(String destRoutViaPortNm) {
		this.destRoutViaPortNm = destRoutViaPortNm;
	}
	
	/**
	 * Column Info
	 * @param triRqstUsrId
	 */
	public void setTriRqstUsrId(String triRqstUsrId) {
		this.triRqstUsrId = triRqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param trfCd
	 */
	public void setTrfCd(String trfCd) {
		this.trfCd = trfCd;
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
	 * @param orgRoutViaPortNmSnd
	 */
	public void setOrgRoutViaPortNmSnd(String orgRoutViaPortNmSnd) {
		this.orgRoutViaPortNmSnd = orgRoutViaPortNmSnd;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param curStatus
	 */
	public void setCurStatus(String curStatus) {
		this.curStatus = curStatus;
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
	 * @param orgRoutPntLocNmSnd
	 */
	public void setOrgRoutPntLocNmSnd(String orgRoutPntLocNmSnd) {
		this.orgRoutPntLocNmSnd = orgRoutPntLocNmSnd;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortNm
	 */
	public void setOrgRoutViaPortNm(String orgRoutViaPortNm) {
		this.orgRoutViaPortNm = orgRoutViaPortNm;
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
	 * @param trfPfxCd
	 */
	public void setTrfPfxCd(String trfPfxCd) {
		this.trfPfxCd = trfPfxCd;
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
	 * @param destRoutPntLocNmSnd
	 */
	public void setDestRoutPntLocNmSnd(String destRoutPntLocNmSnd) {
		this.destRoutPntLocNmSnd = destRoutPntLocNmSnd;
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
	 * @param propFrtRtAmt
	 */
	public void setPropFrtRtAmt(String propFrtRtAmt) {
		this.propFrtRtAmt = propFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param lastPubDt
	 */
	public void setLastPubDt(String lastPubDt) {
		this.lastPubDt = lastPubDt;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocNm
	 */
	public void setOrgRoutPntLocNm(String orgRoutPntLocNm) {
		this.orgRoutPntLocNm = orgRoutPntLocNm;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param propStsNm
	 */
	public void setPropStsNm(String propStsNm) {
		this.propStsNm = propStsNm;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
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
		setDestRoutPntLocNm(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_nm", ""));
		setDestRoutViaPortNmSnd(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_nm_snd", ""));
		setTriRmk(JSPUtil.getParameter(request, prefix + "tri_rmk", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setGriApplAmt(JSPUtil.getParameter(request, prefix + "gri_appl_amt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setPubDt(JSPUtil.getParameter(request, prefix + "pub_dt", ""));
		setTriPropNo(JSPUtil.getParameter(request, prefix + "tri_prop_no", ""));
		setNoteCtnt(JSPUtil.getParameter(request, prefix + "note_ctnt", ""));
		setCoffrFrtRtAmt(JSPUtil.getParameter(request, prefix + "coffr_frt_rt_amt", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt", ""));
		setDestRoutViaPortNm(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_nm", ""));
		setTriRqstUsrId(JSPUtil.getParameter(request, prefix + "tri_rqst_usr_id", ""));
		setTrfCd(JSPUtil.getParameter(request, prefix + "trf_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOrgRoutViaPortNmSnd(JSPUtil.getParameter(request, prefix + "org_rout_via_port_nm_snd", ""));
		setTriAproUsrId(JSPUtil.getParameter(request, prefix + "tri_apro_usr_id", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCurStatus(JSPUtil.getParameter(request, prefix + "cur_status", ""));
		setPropStsCd(JSPUtil.getParameter(request, prefix + "prop_sts_cd", ""));
		setOrgRoutPntLocNmSnd(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_nm_snd", ""));
		setOrgRoutViaPortNm(JSPUtil.getParameter(request, prefix + "org_rout_via_port_nm", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setTrfPfxCd(JSPUtil.getParameter(request, prefix + "trf_pfx_cd", ""));
		setTriRqstOfcCd(JSPUtil.getParameter(request, prefix + "tri_rqst_ofc_cd", ""));
		setTriAproOfcCd(JSPUtil.getParameter(request, prefix + "tri_apro_ofc_cd", ""));
		setGriApplTpCd(JSPUtil.getParameter(request, prefix + "gri_appl_tp_cd", ""));
		setDestRoutPntLocNmSnd(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_nm_snd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setPropFrtRtAmt(JSPUtil.getParameter(request, prefix + "prop_frt_rt_amt", ""));
		setLastPubDt(JSPUtil.getParameter(request, prefix + "last_pub_dt", ""));
		setOrgRoutPntLocNm(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_nm", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setNoteConvMapgId(JSPUtil.getParameter(request, prefix + "note_conv_mapg_id", ""));
		setPropStsNm(JSPUtil.getParameter(request, prefix + "prop_sts_nm", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setTriNo(JSPUtil.getParameter(request, prefix + "tri_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltTriPropListVO[]
	 */
	public RsltTriPropListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltTriPropListVO[]
	 */
	public RsltTriPropListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltTriPropListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] destRoutPntLocNm = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_nm", length));
			String[] destRoutViaPortNmSnd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_nm_snd", length));
			String[] triRmk = (JSPUtil.getParameter(request, prefix	+ "tri_rmk", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] griApplAmt = (JSPUtil.getParameter(request, prefix	+ "gri_appl_amt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] pubDt = (JSPUtil.getParameter(request, prefix	+ "pub_dt", length));
			String[] triPropNo = (JSPUtil.getParameter(request, prefix	+ "tri_prop_no", length));
			String[] noteCtnt = (JSPUtil.getParameter(request, prefix	+ "note_ctnt", length));
			String[] coffrFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "coffr_frt_rt_amt", length));
			String[] fnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt", length));
			String[] destRoutViaPortNm = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_nm", length));
			String[] triRqstUsrId = (JSPUtil.getParameter(request, prefix	+ "tri_rqst_usr_id", length));
			String[] trfCd = (JSPUtil.getParameter(request, prefix	+ "trf_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgRoutViaPortNmSnd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_nm_snd", length));
			String[] triAproUsrId = (JSPUtil.getParameter(request, prefix	+ "tri_apro_usr_id", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] curStatus = (JSPUtil.getParameter(request, prefix	+ "cur_status", length));
			String[] propStsCd = (JSPUtil.getParameter(request, prefix	+ "prop_sts_cd", length));
			String[] orgRoutPntLocNmSnd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_nm_snd", length));
			String[] orgRoutViaPortNm = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_nm", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] trfPfxCd = (JSPUtil.getParameter(request, prefix	+ "trf_pfx_cd", length));
			String[] triRqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "tri_rqst_ofc_cd", length));
			String[] triAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "tri_apro_ofc_cd", length));
			String[] griApplTpCd = (JSPUtil.getParameter(request, prefix	+ "gri_appl_tp_cd", length));
			String[] destRoutPntLocNmSnd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_nm_snd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] propFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_frt_rt_amt", length));
			String[] lastPubDt = (JSPUtil.getParameter(request, prefix	+ "last_pub_dt", length));
			String[] orgRoutPntLocNm = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_nm", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] noteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "note_conv_mapg_id", length));
			String[] propStsNm = (JSPUtil.getParameter(request, prefix	+ "prop_sts_nm", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] triNo = (JSPUtil.getParameter(request, prefix	+ "tri_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltTriPropListVO();
				if (destRoutPntLocNm[i] != null)
					model.setDestRoutPntLocNm(destRoutPntLocNm[i]);
				if (destRoutViaPortNmSnd[i] != null)
					model.setDestRoutViaPortNmSnd(destRoutViaPortNmSnd[i]);
				if (triRmk[i] != null)
					model.setTriRmk(triRmk[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (griApplAmt[i] != null)
					model.setGriApplAmt(griApplAmt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (pubDt[i] != null)
					model.setPubDt(pubDt[i]);
				if (triPropNo[i] != null)
					model.setTriPropNo(triPropNo[i]);
				if (noteCtnt[i] != null)
					model.setNoteCtnt(noteCtnt[i]);
				if (coffrFrtRtAmt[i] != null)
					model.setCoffrFrtRtAmt(coffrFrtRtAmt[i]);
				if (fnlFrtRtAmt[i] != null)
					model.setFnlFrtRtAmt(fnlFrtRtAmt[i]);
				if (destRoutViaPortNm[i] != null)
					model.setDestRoutViaPortNm(destRoutViaPortNm[i]);
				if (triRqstUsrId[i] != null)
					model.setTriRqstUsrId(triRqstUsrId[i]);
				if (trfCd[i] != null)
					model.setTrfCd(trfCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgRoutViaPortNmSnd[i] != null)
					model.setOrgRoutViaPortNmSnd(orgRoutViaPortNmSnd[i]);
				if (triAproUsrId[i] != null)
					model.setTriAproUsrId(triAproUsrId[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (curStatus[i] != null)
					model.setCurStatus(curStatus[i]);
				if (propStsCd[i] != null)
					model.setPropStsCd(propStsCd[i]);
				if (orgRoutPntLocNmSnd[i] != null)
					model.setOrgRoutPntLocNmSnd(orgRoutPntLocNmSnd[i]);
				if (orgRoutViaPortNm[i] != null)
					model.setOrgRoutViaPortNm(orgRoutViaPortNm[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (trfPfxCd[i] != null)
					model.setTrfPfxCd(trfPfxCd[i]);
				if (triRqstOfcCd[i] != null)
					model.setTriRqstOfcCd(triRqstOfcCd[i]);
				if (triAproOfcCd[i] != null)
					model.setTriAproOfcCd(triAproOfcCd[i]);
				if (griApplTpCd[i] != null)
					model.setGriApplTpCd(griApplTpCd[i]);
				if (destRoutPntLocNmSnd[i] != null)
					model.setDestRoutPntLocNmSnd(destRoutPntLocNmSnd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (propFrtRtAmt[i] != null)
					model.setPropFrtRtAmt(propFrtRtAmt[i]);
				if (lastPubDt[i] != null)
					model.setLastPubDt(lastPubDt[i]);
				if (orgRoutPntLocNm[i] != null)
					model.setOrgRoutPntLocNm(orgRoutPntLocNm[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (noteConvMapgId[i] != null)
					model.setNoteConvMapgId(noteConvMapgId[i]);
				if (propStsNm[i] != null)
					model.setPropStsNm(propStsNm[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (triNo[i] != null)
					model.setTriNo(triNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltTriPropListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltTriPropListVO[]
	 */
	public RsltTriPropListVO[] getRsltTriPropListVOs(){
		RsltTriPropListVO[] vos = (RsltTriPropListVO[])models.toArray(new RsltTriPropListVO[models.size()]);
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
		this.destRoutPntLocNm = this.destRoutPntLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortNmSnd = this.destRoutViaPortNmSnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triRmk = this.triRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplAmt = this.griApplAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubDt = this.pubDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triPropNo = this.triPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt = this.noteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coffrFrtRtAmt = this.coffrFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt = this.fnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortNm = this.destRoutViaPortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triRqstUsrId = this.triRqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCd = this.trfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortNmSnd = this.orgRoutViaPortNmSnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triAproUsrId = this.triAproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curStatus = this.curStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsCd = this.propStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocNmSnd = this.orgRoutPntLocNmSnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortNm = this.orgRoutViaPortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfPfxCd = this.trfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triRqstOfcCd = this.triRqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triAproOfcCd = this.triAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplTpCd = this.griApplTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocNmSnd = this.destRoutPntLocNmSnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtRtAmt = this.propFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPubDt = this.lastPubDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocNm = this.orgRoutPntLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvMapgId = this.noteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsNm = this.propStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triNo = this.triNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
