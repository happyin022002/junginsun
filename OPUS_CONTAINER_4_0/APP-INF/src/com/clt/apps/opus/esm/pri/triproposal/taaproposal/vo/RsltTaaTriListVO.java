/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltTaaTriListVO.java
*@FileTitle : RsltTaaTriListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.02.23 문동규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo;

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
 * @author 문동규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltTaaTriListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltTaaTriListVO> models = new ArrayList<RsltTaaTriListVO>();
	
	/* Column Info */
	private String orgPntLocNm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String frmDestPntLocCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String taaPropNo = null;
	/* Column Info */
	private String orgViaPortNm = null;
	/* Column Info */
	private String frmCmdtCd = null;
	/* Column Info */
	private String triPropNo = null;
	/* Column Info */
	private String pubDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String noteCtnt = null;
	/* Column Info */
	private String fnlFrtRtAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trfCd = null;
	/* Column Info */
	private String frmTrfCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String orgViaPortCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String trfPfxCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String triAmdtSeq = null;
	/* Column Info */
	private String destPntLocCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String destPntLocNm = null;
	/* Column Info */
	private String frmOrgViaPortCd = null;
	/* Column Info */
	private String frmDestViaPortCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String noteConvMapgId = null;
	/* Column Info */
	private String frmTriNo = null;
	/* Column Info */
	private String destViaPortNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String frmTrfNm = null;
	/* Column Info */
	private String trfNm = null;
	/* Column Info */
	private String frmTrfPfxCd = null;
	/* Column Info */
	private String frmTrfNo = null;
	/* Column Info */
	private String orgPntLocCd = null;
	/* Column Info */
	private String frmOrgPntLocCd = null;
	/* Column Info */
	private String triNo = null;
	/* Column Info */
	private String destViaPortCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltTaaTriListVO() {}

	public RsltTaaTriListVO(String ibflag, String pagerows, String orgPntLocNm, String frmDestPntLocCd, String currCd, String prcCgoTpCd, String amdtSeq, String taaPropNo, String frmCmdtCd, String orgViaPortNm, String creDt, String pubDt, String triPropNo, String noteCtnt, String fnlFrtRtAmt, String trfCd, String frmTrfCd, String effDt, String cmdtCd, String cmdtNm, String orgViaPortCd, String expDt, String trfPfxCd, String updUsrId, String updDt, String destPntLocCd, String triAmdtSeq, String destPntLocNm, String frmOrgViaPortCd, String frmDestViaPortCd, String ratUtCd, String frmTriNo, String noteConvMapgId, String creUsrId, String destViaPortNm, String taaNo, String trfNo, String frmTrfNm, String trfNm, String frmTrfNo, String frmTrfPfxCd, String orgPntLocCd, String frmOrgPntLocCd, String triNo, String destViaPortCd) {
		this.orgPntLocNm = orgPntLocNm;
		this.currCd = currCd;
		this.frmDestPntLocCd = frmDestPntLocCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.amdtSeq = amdtSeq;
		this.taaPropNo = taaPropNo;
		this.orgViaPortNm = orgViaPortNm;
		this.frmCmdtCd = frmCmdtCd;
		this.triPropNo = triPropNo;
		this.pubDt = pubDt;
		this.creDt = creDt;
		this.noteCtnt = noteCtnt;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.pagerows = pagerows;
		this.trfCd = trfCd;
		this.frmTrfCd = frmTrfCd;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.cmdtCd = cmdtCd;
		this.orgViaPortCd = orgViaPortCd;
		this.expDt = expDt;
		this.trfPfxCd = trfPfxCd;
		this.updUsrId = updUsrId;
		this.triAmdtSeq = triAmdtSeq;
		this.destPntLocCd = destPntLocCd;
		this.updDt = updDt;
		this.destPntLocNm = destPntLocNm;
		this.frmOrgViaPortCd = frmOrgViaPortCd;
		this.frmDestViaPortCd = frmDestViaPortCd;
		this.ratUtCd = ratUtCd;
		this.cmdtNm = cmdtNm;
		this.noteConvMapgId = noteConvMapgId;
		this.frmTriNo = frmTriNo;
		this.destViaPortNm = destViaPortNm;
		this.creUsrId = creUsrId;
		this.taaNo = taaNo;
		this.trfNo = trfNo;
		this.frmTrfNm = frmTrfNm;
		this.trfNm = trfNm;
		this.frmTrfPfxCd = frmTrfPfxCd;
		this.frmTrfNo = frmTrfNo;
		this.orgPntLocCd = orgPntLocCd;
		this.frmOrgPntLocCd = frmOrgPntLocCd;
		this.triNo = triNo;
		this.destViaPortCd = destViaPortCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_pnt_loc_nm", getOrgPntLocNm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("frm_dest_pnt_loc_cd", getFrmDestPntLocCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("taa_prop_no", getTaaPropNo());
		this.hashColumns.put("org_via_port_nm", getOrgViaPortNm());
		this.hashColumns.put("frm_cmdt_cd", getFrmCmdtCd());
		this.hashColumns.put("tri_prop_no", getTriPropNo());
		this.hashColumns.put("pub_dt", getPubDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("note_ctnt", getNoteCtnt());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trf_cd", getTrfCd());
		this.hashColumns.put("frm_trf_cd", getFrmTrfCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("org_via_port_cd", getOrgViaPortCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("trf_pfx_cd", getTrfPfxCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("tri_amdt_seq", getTriAmdtSeq());
		this.hashColumns.put("dest_pnt_loc_cd", getDestPntLocCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dest_pnt_loc_nm", getDestPntLocNm());
		this.hashColumns.put("frm_org_via_port_cd", getFrmOrgViaPortCd());
		this.hashColumns.put("frm_dest_via_port_cd", getFrmDestViaPortCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("note_conv_mapg_id", getNoteConvMapgId());
		this.hashColumns.put("frm_tri_no", getFrmTriNo());
		this.hashColumns.put("dest_via_port_nm", getDestViaPortNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("frm_trf_nm", getFrmTrfNm());
		this.hashColumns.put("trf_nm", getTrfNm());
		this.hashColumns.put("frm_trf_pfx_cd", getFrmTrfPfxCd());
		this.hashColumns.put("frm_trf_no", getFrmTrfNo());
		this.hashColumns.put("org_pnt_loc_cd", getOrgPntLocCd());
		this.hashColumns.put("frm_org_pnt_loc_cd", getFrmOrgPntLocCd());
		this.hashColumns.put("tri_no", getTriNo());
		this.hashColumns.put("dest_via_port_cd", getDestViaPortCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_pnt_loc_nm", "orgPntLocNm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("frm_dest_pnt_loc_cd", "frmDestPntLocCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("taa_prop_no", "taaPropNo");
		this.hashFields.put("org_via_port_nm", "orgViaPortNm");
		this.hashFields.put("frm_cmdt_cd", "frmCmdtCd");
		this.hashFields.put("tri_prop_no", "triPropNo");
		this.hashFields.put("pub_dt", "pubDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("note_ctnt", "noteCtnt");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trf_cd", "trfCd");
		this.hashFields.put("frm_trf_cd", "frmTrfCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("org_via_port_cd", "orgViaPortCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("trf_pfx_cd", "trfPfxCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("tri_amdt_seq", "triAmdtSeq");
		this.hashFields.put("dest_pnt_loc_cd", "destPntLocCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dest_pnt_loc_nm", "destPntLocNm");
		this.hashFields.put("frm_org_via_port_cd", "frmOrgViaPortCd");
		this.hashFields.put("frm_dest_via_port_cd", "frmDestViaPortCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("note_conv_mapg_id", "noteConvMapgId");
		this.hashFields.put("frm_tri_no", "frmTriNo");
		this.hashFields.put("dest_via_port_nm", "destViaPortNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("frm_trf_nm", "frmTrfNm");
		this.hashFields.put("trf_nm", "trfNm");
		this.hashFields.put("frm_trf_pfx_cd", "frmTrfPfxCd");
		this.hashFields.put("frm_trf_no", "frmTrfNo");
		this.hashFields.put("org_pnt_loc_cd", "orgPntLocCd");
		this.hashFields.put("frm_org_pnt_loc_cd", "frmOrgPntLocCd");
		this.hashFields.put("tri_no", "triNo");
		this.hashFields.put("dest_via_port_cd", "destViaPortCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orgPntLocNm
	 */
	public String getOrgPntLocNm() {
		return this.orgPntLocNm;
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
	 * @return frmDestPntLocCd
	 */
	public String getFrmDestPntLocCd() {
		return this.frmDestPntLocCd;
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return taaPropNo
	 */
	public String getTaaPropNo() {
		return this.taaPropNo;
	}
	
	/**
	 * Column Info
	 * @return orgViaPortNm
	 */
	public String getOrgViaPortNm() {
		return this.orgViaPortNm;
	}
	
	/**
	 * Column Info
	 * @return frmCmdtCd
	 */
	public String getFrmCmdtCd() {
		return this.frmCmdtCd;
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
	 * @return pubDt
	 */
	public String getPubDt() {
		return this.pubDt;
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
	 * @return noteCtnt
	 */
	public String getNoteCtnt() {
		return this.noteCtnt;
	}
	
	/**
	 * Column Info
	 * @return fnlFrtRtAmt
	 */
	public String getFnlFrtRtAmt() {
		return this.fnlFrtRtAmt;
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
	 * @return trfCd
	 */
	public String getTrfCd() {
		return this.trfCd;
	}
	
	/**
	 * Column Info
	 * @return frmTrfCd
	 */
	public String getFrmTrfCd() {
		return this.frmTrfCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return orgViaPortCd
	 */
	public String getOrgViaPortCd() {
		return this.orgViaPortCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return triAmdtSeq
	 */
	public String getTriAmdtSeq() {
		return this.triAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return destPntLocCd
	 */
	public String getDestPntLocCd() {
		return this.destPntLocCd;
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
	 * @return destPntLocNm
	 */
	public String getDestPntLocNm() {
		return this.destPntLocNm;
	}
	
	/**
	 * Column Info
	 * @return frmOrgViaPortCd
	 */
	public String getFrmOrgViaPortCd() {
		return this.frmOrgViaPortCd;
	}
	
	/**
	 * Column Info
	 * @return frmDestViaPortCd
	 */
	public String getFrmDestViaPortCd() {
		return this.frmDestViaPortCd;
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
	 * @return frmTriNo
	 */
	public String getFrmTriNo() {
		return this.frmTriNo;
	}
	
	/**
	 * Column Info
	 * @return destViaPortNm
	 */
	public String getDestViaPortNm() {
		return this.destViaPortNm;
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
	 * @return taaNo
	 */
	public String getTaaNo() {
		return this.taaNo;
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
	 * @return frmTrfNm
	 */
	public String getFrmTrfNm() {
		return this.frmTrfNm;
	}
	
	/**
	 * Column Info
	 * @return trfNm
	 */
	public String getTrfNm() {
		return this.trfNm;
	}
	
	/**
	 * Column Info
	 * @return frmTrfPfxCd
	 */
	public String getFrmTrfPfxCd() {
		return this.frmTrfPfxCd;
	}
	
	/**
	 * Column Info
	 * @return frmTrfNo
	 */
	public String getFrmTrfNo() {
		return this.frmTrfNo;
	}
	
	/**
	 * Column Info
	 * @return orgPntLocCd
	 */
	public String getOrgPntLocCd() {
		return this.orgPntLocCd;
	}
	
	/**
	 * Column Info
	 * @return frmOrgPntLocCd
	 */
	public String getFrmOrgPntLocCd() {
		return this.frmOrgPntLocCd;
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
	 * @return destViaPortCd
	 */
	public String getDestViaPortCd() {
		return this.destViaPortCd;
	}
	

	/**
	 * Column Info
	 * @param orgPntLocNm
	 */
	public void setOrgPntLocNm(String orgPntLocNm) {
		this.orgPntLocNm = orgPntLocNm;
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
	 * @param frmDestPntLocCd
	 */
	public void setFrmDestPntLocCd(String frmDestPntLocCd) {
		this.frmDestPntLocCd = frmDestPntLocCd;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param taaPropNo
	 */
	public void setTaaPropNo(String taaPropNo) {
		this.taaPropNo = taaPropNo;
	}
	
	/**
	 * Column Info
	 * @param orgViaPortNm
	 */
	public void setOrgViaPortNm(String orgViaPortNm) {
		this.orgViaPortNm = orgViaPortNm;
	}
	
	/**
	 * Column Info
	 * @param frmCmdtCd
	 */
	public void setFrmCmdtCd(String frmCmdtCd) {
		this.frmCmdtCd = frmCmdtCd;
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
	 * @param pubDt
	 */
	public void setPubDt(String pubDt) {
		this.pubDt = pubDt;
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
	 * @param noteCtnt
	 */
	public void setNoteCtnt(String noteCtnt) {
		this.noteCtnt = noteCtnt;
	}
	
	/**
	 * Column Info
	 * @param fnlFrtRtAmt
	 */
	public void setFnlFrtRtAmt(String fnlFrtRtAmt) {
		this.fnlFrtRtAmt = fnlFrtRtAmt;
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
	 * @param trfCd
	 */
	public void setTrfCd(String trfCd) {
		this.trfCd = trfCd;
	}
	
	/**
	 * Column Info
	 * @param frmTrfCd
	 */
	public void setFrmTrfCd(String frmTrfCd) {
		this.frmTrfCd = frmTrfCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param orgViaPortCd
	 */
	public void setOrgViaPortCd(String orgViaPortCd) {
		this.orgViaPortCd = orgViaPortCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param triAmdtSeq
	 */
	public void setTriAmdtSeq(String triAmdtSeq) {
		this.triAmdtSeq = triAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param destPntLocCd
	 */
	public void setDestPntLocCd(String destPntLocCd) {
		this.destPntLocCd = destPntLocCd;
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
	 * @param destPntLocNm
	 */
	public void setDestPntLocNm(String destPntLocNm) {
		this.destPntLocNm = destPntLocNm;
	}
	
	/**
	 * Column Info
	 * @param frmOrgViaPortCd
	 */
	public void setFrmOrgViaPortCd(String frmOrgViaPortCd) {
		this.frmOrgViaPortCd = frmOrgViaPortCd;
	}
	
	/**
	 * Column Info
	 * @param frmDestViaPortCd
	 */
	public void setFrmDestViaPortCd(String frmDestViaPortCd) {
		this.frmDestViaPortCd = frmDestViaPortCd;
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
	 * @param frmTriNo
	 */
	public void setFrmTriNo(String frmTriNo) {
		this.frmTriNo = frmTriNo;
	}
	
	/**
	 * Column Info
	 * @param destViaPortNm
	 */
	public void setDestViaPortNm(String destViaPortNm) {
		this.destViaPortNm = destViaPortNm;
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
	 * @param taaNo
	 */
	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
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
	 * @param frmTrfNm
	 */
	public void setFrmTrfNm(String frmTrfNm) {
		this.frmTrfNm = frmTrfNm;
	}
	
	/**
	 * Column Info
	 * @param trfNm
	 */
	public void setTrfNm(String trfNm) {
		this.trfNm = trfNm;
	}
	
	/**
	 * Column Info
	 * @param frmTrfPfxCd
	 */
	public void setFrmTrfPfxCd(String frmTrfPfxCd) {
		this.frmTrfPfxCd = frmTrfPfxCd;
	}
	
	/**
	 * Column Info
	 * @param frmTrfNo
	 */
	public void setFrmTrfNo(String frmTrfNo) {
		this.frmTrfNo = frmTrfNo;
	}
	
	/**
	 * Column Info
	 * @param orgPntLocCd
	 */
	public void setOrgPntLocCd(String orgPntLocCd) {
		this.orgPntLocCd = orgPntLocCd;
	}
	
	/**
	 * Column Info
	 * @param frmOrgPntLocCd
	 */
	public void setFrmOrgPntLocCd(String frmOrgPntLocCd) {
		this.frmOrgPntLocCd = frmOrgPntLocCd;
	}
	
	/**
	 * Column Info
	 * @param triNo
	 */
	public void setTriNo(String triNo) {
		this.triNo = triNo;
	}
	
	/**
	 * Column Info
	 * @param destViaPortCd
	 */
	public void setDestViaPortCd(String destViaPortCd) {
		this.destViaPortCd = destViaPortCd;
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
		setOrgPntLocNm(JSPUtil.getParameter(request, prefix + "org_pnt_loc_nm", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setFrmDestPntLocCd(JSPUtil.getParameter(request, prefix + "frm_dest_pnt_loc_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setTaaPropNo(JSPUtil.getParameter(request, prefix + "taa_prop_no", ""));
		setOrgViaPortNm(JSPUtil.getParameter(request, prefix + "org_via_port_nm", ""));
		setFrmCmdtCd(JSPUtil.getParameter(request, prefix + "frm_cmdt_cd", ""));
		setTriPropNo(JSPUtil.getParameter(request, prefix + "tri_prop_no", ""));
		setPubDt(JSPUtil.getParameter(request, prefix + "pub_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setNoteCtnt(JSPUtil.getParameter(request, prefix + "note_ctnt", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrfCd(JSPUtil.getParameter(request, prefix + "trf_cd", ""));
		setFrmTrfCd(JSPUtil.getParameter(request, prefix + "frm_trf_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setOrgViaPortCd(JSPUtil.getParameter(request, prefix + "org_via_port_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setTrfPfxCd(JSPUtil.getParameter(request, prefix + "trf_pfx_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setTriAmdtSeq(JSPUtil.getParameter(request, prefix + "tri_amdt_seq", ""));
		setDestPntLocCd(JSPUtil.getParameter(request, prefix + "dest_pnt_loc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDestPntLocNm(JSPUtil.getParameter(request, prefix + "dest_pnt_loc_nm", ""));
		setFrmOrgViaPortCd(JSPUtil.getParameter(request, prefix + "frm_org_via_port_cd", ""));
		setFrmDestViaPortCd(JSPUtil.getParameter(request, prefix + "frm_dest_via_port_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setNoteConvMapgId(JSPUtil.getParameter(request, prefix + "note_conv_mapg_id", ""));
		setFrmTriNo(JSPUtil.getParameter(request, prefix + "frm_tri_no", ""));
		setDestViaPortNm(JSPUtil.getParameter(request, prefix + "dest_via_port_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setFrmTrfNm(JSPUtil.getParameter(request, prefix + "frm_trf_nm", ""));
		setTrfNm(JSPUtil.getParameter(request, prefix + "trf_nm", ""));
		setFrmTrfPfxCd(JSPUtil.getParameter(request, prefix + "frm_trf_pfx_cd", ""));
		setFrmTrfNo(JSPUtil.getParameter(request, prefix + "frm_trf_no", ""));
		setOrgPntLocCd(JSPUtil.getParameter(request, prefix + "org_pnt_loc_cd", ""));
		setFrmOrgPntLocCd(JSPUtil.getParameter(request, prefix + "frm_org_pnt_loc_cd", ""));
		setTriNo(JSPUtil.getParameter(request, prefix + "tri_no", ""));
		setDestViaPortCd(JSPUtil.getParameter(request, prefix + "dest_via_port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltTaaTriListVO[]
	 */
	public RsltTaaTriListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltTaaTriListVO[]
	 */
	public RsltTaaTriListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltTaaTriListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgPntLocNm = (JSPUtil.getParameter(request, prefix	+ "org_pnt_loc_nm", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] frmDestPntLocCd = (JSPUtil.getParameter(request, prefix	+ "frm_dest_pnt_loc_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] taaPropNo = (JSPUtil.getParameter(request, prefix	+ "taa_prop_no", length));
			String[] orgViaPortNm = (JSPUtil.getParameter(request, prefix	+ "org_via_port_nm", length));
			String[] frmCmdtCd = (JSPUtil.getParameter(request, prefix	+ "frm_cmdt_cd", length));
			String[] triPropNo = (JSPUtil.getParameter(request, prefix	+ "tri_prop_no", length));
			String[] pubDt = (JSPUtil.getParameter(request, prefix	+ "pub_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] noteCtnt = (JSPUtil.getParameter(request, prefix	+ "note_ctnt", length));
			String[] fnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trfCd = (JSPUtil.getParameter(request, prefix	+ "trf_cd", length));
			String[] frmTrfCd = (JSPUtil.getParameter(request, prefix	+ "frm_trf_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] orgViaPortCd = (JSPUtil.getParameter(request, prefix	+ "org_via_port_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] trfPfxCd = (JSPUtil.getParameter(request, prefix	+ "trf_pfx_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] triAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "tri_amdt_seq", length));
			String[] destPntLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_pnt_loc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] destPntLocNm = (JSPUtil.getParameter(request, prefix	+ "dest_pnt_loc_nm", length));
			String[] frmOrgViaPortCd = (JSPUtil.getParameter(request, prefix	+ "frm_org_via_port_cd", length));
			String[] frmDestViaPortCd = (JSPUtil.getParameter(request, prefix	+ "frm_dest_via_port_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] noteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "note_conv_mapg_id", length));
			String[] frmTriNo = (JSPUtil.getParameter(request, prefix	+ "frm_tri_no", length));
			String[] destViaPortNm = (JSPUtil.getParameter(request, prefix	+ "dest_via_port_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] frmTrfNm = (JSPUtil.getParameter(request, prefix	+ "frm_trf_nm", length));
			String[] trfNm = (JSPUtil.getParameter(request, prefix	+ "trf_nm", length));
			String[] frmTrfPfxCd = (JSPUtil.getParameter(request, prefix	+ "frm_trf_pfx_cd", length));
			String[] frmTrfNo = (JSPUtil.getParameter(request, prefix	+ "frm_trf_no", length));
			String[] orgPntLocCd = (JSPUtil.getParameter(request, prefix	+ "org_pnt_loc_cd", length));
			String[] frmOrgPntLocCd = (JSPUtil.getParameter(request, prefix	+ "frm_org_pnt_loc_cd", length));
			String[] triNo = (JSPUtil.getParameter(request, prefix	+ "tri_no", length));
			String[] destViaPortCd = (JSPUtil.getParameter(request, prefix	+ "dest_via_port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltTaaTriListVO();
				if (orgPntLocNm[i] != null)
					model.setOrgPntLocNm(orgPntLocNm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (frmDestPntLocCd[i] != null)
					model.setFrmDestPntLocCd(frmDestPntLocCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (taaPropNo[i] != null)
					model.setTaaPropNo(taaPropNo[i]);
				if (orgViaPortNm[i] != null)
					model.setOrgViaPortNm(orgViaPortNm[i]);
				if (frmCmdtCd[i] != null)
					model.setFrmCmdtCd(frmCmdtCd[i]);
				if (triPropNo[i] != null)
					model.setTriPropNo(triPropNo[i]);
				if (pubDt[i] != null)
					model.setPubDt(pubDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (noteCtnt[i] != null)
					model.setNoteCtnt(noteCtnt[i]);
				if (fnlFrtRtAmt[i] != null)
					model.setFnlFrtRtAmt(fnlFrtRtAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trfCd[i] != null)
					model.setTrfCd(trfCd[i]);
				if (frmTrfCd[i] != null)
					model.setFrmTrfCd(frmTrfCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (orgViaPortCd[i] != null)
					model.setOrgViaPortCd(orgViaPortCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (trfPfxCd[i] != null)
					model.setTrfPfxCd(trfPfxCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (triAmdtSeq[i] != null)
					model.setTriAmdtSeq(triAmdtSeq[i]);
				if (destPntLocCd[i] != null)
					model.setDestPntLocCd(destPntLocCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (destPntLocNm[i] != null)
					model.setDestPntLocNm(destPntLocNm[i]);
				if (frmOrgViaPortCd[i] != null)
					model.setFrmOrgViaPortCd(frmOrgViaPortCd[i]);
				if (frmDestViaPortCd[i] != null)
					model.setFrmDestViaPortCd(frmDestViaPortCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (noteConvMapgId[i] != null)
					model.setNoteConvMapgId(noteConvMapgId[i]);
				if (frmTriNo[i] != null)
					model.setFrmTriNo(frmTriNo[i]);
				if (destViaPortNm[i] != null)
					model.setDestViaPortNm(destViaPortNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (frmTrfNm[i] != null)
					model.setFrmTrfNm(frmTrfNm[i]);
				if (trfNm[i] != null)
					model.setTrfNm(trfNm[i]);
				if (frmTrfPfxCd[i] != null)
					model.setFrmTrfPfxCd(frmTrfPfxCd[i]);
				if (frmTrfNo[i] != null)
					model.setFrmTrfNo(frmTrfNo[i]);
				if (orgPntLocCd[i] != null)
					model.setOrgPntLocCd(orgPntLocCd[i]);
				if (frmOrgPntLocCd[i] != null)
					model.setFrmOrgPntLocCd(frmOrgPntLocCd[i]);
				if (triNo[i] != null)
					model.setTriNo(triNo[i]);
				if (destViaPortCd[i] != null)
					model.setDestViaPortCd(destViaPortCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltTaaTriListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltTaaTriListVO[]
	 */
	public RsltTaaTriListVO[] getRsltTaaTriListVOs(){
		RsltTaaTriListVO[] vos = (RsltTaaTriListVO[])models.toArray(new RsltTaaTriListVO[models.size()]);
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
		this.orgPntLocNm = this.orgPntLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmDestPntLocCd = this.frmDestPntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaPropNo = this.taaPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgViaPortNm = this.orgViaPortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCmdtCd = this.frmCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triPropNo = this.triPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubDt = this.pubDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt = this.noteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt = this.fnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCd = this.trfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmTrfCd = this.frmTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgViaPortCd = this.orgViaPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfPfxCd = this.trfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triAmdtSeq = this.triAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destPntLocCd = this.destPntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destPntLocNm = this.destPntLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmOrgViaPortCd = this.frmOrgViaPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmDestViaPortCd = this.frmDestViaPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvMapgId = this.noteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmTriNo = this.frmTriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destViaPortNm = this.destViaPortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmTrfNm = this.frmTrfNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNm = this.trfNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmTrfPfxCd = this.frmTrfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmTrfNo = this.frmTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPntLocCd = this.orgPntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmOrgPntLocCd = this.frmOrgPntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triNo = this.triNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destViaPortCd = this.destViaPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
