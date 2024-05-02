/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpScpGlineCopyVO.java
*@FileTitle : SpScpGlineCopyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.08.09 문동규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 문동규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpScpGlineCopyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpScpGlineCopyVO> models = new ArrayList<SpScpGlineCopyVO>();
	
	/* Column Info */
	private String cmdtTpwChk = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String cmdtTpwMst = null;
	/* Column Info */
	private String svcScpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String grpCmdtDtlSeq = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String noteHdrSeq = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String prcCustTpCd = null;
	/* Column Info */
	private String newGrpCmdtSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String gohChk = null;
	/* Column Info */
	private String arbOrgChk = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String cmdtTpwDtl = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String oldCmdtChk = null;
	/* Column Info */
	private String newGrpCmdtDtlSeq = null;
	/* Column Info */
	private String noteChk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mqcQty = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String oldLocChk = null;
	/* Column Info */
	private String locChk = null;
	/* Column Info */
	private String cmdtChk = null;
	/* Column Info */
	private String arbDesChk = null;
	/* Column Info */
	private String rateChk = null;
	/* Column Info */
	private String grpCmdtSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpScpGlineCopyVO() {}

	public SpScpGlineCopyVO(String ibflag, String pagerows, String cmdtTpwChk, String amdtSeq, String svcScpCd, String glineSeq, String svcScpNm, String cmdtTpwMst, String grpCmdtDtlSeq, String effDt, String scNo, String noteHdrSeq, String expDt, String prcCustTpCd, String updUsrId, String gohChk, String arbOrgChk, String cmdtHdrSeq, String cmdtTpwDtl, String orgDestTpCd, String noteChk, String creUsrId, String mqcQty, String propNo, String locChk, String cmdtChk, String rateChk, String arbDesChk, String grpCmdtSeq, String newGrpCmdtSeq, String newGrpCmdtDtlSeq, String oldLocChk, String oldCmdtChk) {
		this.cmdtTpwChk = cmdtTpwChk;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.glineSeq = glineSeq;
		this.cmdtTpwMst = cmdtTpwMst;
		this.svcScpNm = svcScpNm;
		this.pagerows = pagerows;
		this.grpCmdtDtlSeq = grpCmdtDtlSeq;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.scNo = scNo;
		this.noteHdrSeq = noteHdrSeq;
		this.expDt = expDt;
		this.prcCustTpCd = prcCustTpCd;
		this.newGrpCmdtSeq = newGrpCmdtSeq;
		this.updUsrId = updUsrId;
		this.gohChk = gohChk;
		this.arbOrgChk = arbOrgChk;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.cmdtTpwDtl = cmdtTpwDtl;
		this.orgDestTpCd = orgDestTpCd;
		this.oldCmdtChk = oldCmdtChk;
		this.newGrpCmdtDtlSeq = newGrpCmdtDtlSeq;
		this.noteChk = noteChk;
		this.creUsrId = creUsrId;
		this.mqcQty = mqcQty;
		this.propNo = propNo;
		this.oldLocChk = oldLocChk;
		this.locChk = locChk;
		this.cmdtChk = cmdtChk;
		this.arbDesChk = arbDesChk;
		this.rateChk = rateChk;
		this.grpCmdtSeq = grpCmdtSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cmdt_tpw_chk", getCmdtTpwChk());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("cmdt_tpw_mst", getCmdtTpwMst());
		this.hashColumns.put("svc_scp_nm", getSvcScpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("grp_cmdt_dtl_seq", getGrpCmdtDtlSeq());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("note_hdr_seq", getNoteHdrSeq());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("prc_cust_tp_cd", getPrcCustTpCd());
		this.hashColumns.put("new_grp_cmdt_seq", getNewGrpCmdtSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("goh_chk", getGohChk());
		this.hashColumns.put("arb_org_chk", getArbOrgChk());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("cmdt_tpw_dtl", getCmdtTpwDtl());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("old_cmdt_chk", getOldCmdtChk());
		this.hashColumns.put("new_grp_cmdt_dtl_seq", getNewGrpCmdtDtlSeq());
		this.hashColumns.put("note_chk", getNoteChk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mqc_qty", getMqcQty());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("old_loc_chk", getOldLocChk());
		this.hashColumns.put("loc_chk", getLocChk());
		this.hashColumns.put("cmdt_chk", getCmdtChk());
		this.hashColumns.put("arb_des_chk", getArbDesChk());
		this.hashColumns.put("rate_chk", getRateChk());
		this.hashColumns.put("grp_cmdt_seq", getGrpCmdtSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cmdt_tpw_chk", "cmdtTpwChk");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("cmdt_tpw_mst", "cmdtTpwMst");
		this.hashFields.put("svc_scp_nm", "svcScpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("grp_cmdt_dtl_seq", "grpCmdtDtlSeq");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("note_hdr_seq", "noteHdrSeq");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("prc_cust_tp_cd", "prcCustTpCd");
		this.hashFields.put("new_grp_cmdt_seq", "newGrpCmdtSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("goh_chk", "gohChk");
		this.hashFields.put("arb_org_chk", "arbOrgChk");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("cmdt_tpw_dtl", "cmdtTpwDtl");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("old_cmdt_chk", "oldCmdtChk");
		this.hashFields.put("new_grp_cmdt_dtl_seq", "newGrpCmdtDtlSeq");
		this.hashFields.put("note_chk", "noteChk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mqc_qty", "mqcQty");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("old_loc_chk", "oldLocChk");
		this.hashFields.put("loc_chk", "locChk");
		this.hashFields.put("cmdt_chk", "cmdtChk");
		this.hashFields.put("arb_des_chk", "arbDesChk");
		this.hashFields.put("rate_chk", "rateChk");
		this.hashFields.put("grp_cmdt_seq", "grpCmdtSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cmdtTpwChk
	 */
	public String getCmdtTpwChk() {
		return this.cmdtTpwChk;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return glineSeq
	 */
	public String getGlineSeq() {
		return this.glineSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtTpwMst
	 */
	public String getCmdtTpwMst() {
		return this.cmdtTpwMst;
	}
	
	/**
	 * Column Info
	 * @return svcScpNm
	 */
	public String getSvcScpNm() {
		return this.svcScpNm;
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
	 * @return grpCmdtDtlSeq
	 */
	public String getGrpCmdtDtlSeq() {
		return this.grpCmdtDtlSeq;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return noteHdrSeq
	 */
	public String getNoteHdrSeq() {
		return this.noteHdrSeq;
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
	 * @return prcCustTpCd
	 */
	public String getPrcCustTpCd() {
		return this.prcCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return newGrpCmdtSeq
	 */
	public String getNewGrpCmdtSeq() {
		return this.newGrpCmdtSeq;
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
	 * @return gohChk
	 */
	public String getGohChk() {
		return this.gohChk;
	}
	
	/**
	 * Column Info
	 * @return arbOrgChk
	 */
	public String getArbOrgChk() {
		return this.arbOrgChk;
	}
	
	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtTpwDtl
	 */
	public String getCmdtTpwDtl() {
		return this.cmdtTpwDtl;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return oldCmdtChk
	 */
	public String getOldCmdtChk() {
		return this.oldCmdtChk;
	}
	
	/**
	 * Column Info
	 * @return newGrpCmdtDtlSeq
	 */
	public String getNewGrpCmdtDtlSeq() {
		return this.newGrpCmdtDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return noteChk
	 */
	public String getNoteChk() {
		return this.noteChk;
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
	 * @return mqcQty
	 */
	public String getMqcQty() {
		return this.mqcQty;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return oldLocChk
	 */
	public String getOldLocChk() {
		return this.oldLocChk;
	}
	
	/**
	 * Column Info
	 * @return locChk
	 */
	public String getLocChk() {
		return this.locChk;
	}
	
	/**
	 * Column Info
	 * @return cmdtChk
	 */
	public String getCmdtChk() {
		return this.cmdtChk;
	}
	
	/**
	 * Column Info
	 * @return arbDesChk
	 */
	public String getArbDesChk() {
		return this.arbDesChk;
	}
	
	/**
	 * Column Info
	 * @return rateChk
	 */
	public String getRateChk() {
		return this.rateChk;
	}
	
	/**
	 * Column Info
	 * @return grpCmdtSeq
	 */
	public String getGrpCmdtSeq() {
		return this.grpCmdtSeq;
	}
	

	/**
	 * Column Info
	 * @param cmdtTpwChk
	 */
	public void setCmdtTpwChk(String cmdtTpwChk) {
		this.cmdtTpwChk = cmdtTpwChk;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param glineSeq
	 */
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtTpwMst
	 */
	public void setCmdtTpwMst(String cmdtTpwMst) {
		this.cmdtTpwMst = cmdtTpwMst;
	}
	
	/**
	 * Column Info
	 * @param svcScpNm
	 */
	public void setSvcScpNm(String svcScpNm) {
		this.svcScpNm = svcScpNm;
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
	 * @param grpCmdtDtlSeq
	 */
	public void setGrpCmdtDtlSeq(String grpCmdtDtlSeq) {
		this.grpCmdtDtlSeq = grpCmdtDtlSeq;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param noteHdrSeq
	 */
	public void setNoteHdrSeq(String noteHdrSeq) {
		this.noteHdrSeq = noteHdrSeq;
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
	 * @param prcCustTpCd
	 */
	public void setPrcCustTpCd(String prcCustTpCd) {
		this.prcCustTpCd = prcCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param newGrpCmdtSeq
	 */
	public void setNewGrpCmdtSeq(String newGrpCmdtSeq) {
		this.newGrpCmdtSeq = newGrpCmdtSeq;
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
	 * @param gohChk
	 */
	public void setGohChk(String gohChk) {
		this.gohChk = gohChk;
	}
	
	/**
	 * Column Info
	 * @param arbOrgChk
	 */
	public void setArbOrgChk(String arbOrgChk) {
		this.arbOrgChk = arbOrgChk;
	}
	
	/**
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtTpwDtl
	 */
	public void setCmdtTpwDtl(String cmdtTpwDtl) {
		this.cmdtTpwDtl = cmdtTpwDtl;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param oldCmdtChk
	 */
	public void setOldCmdtChk(String oldCmdtChk) {
		this.oldCmdtChk = oldCmdtChk;
	}
	
	/**
	 * Column Info
	 * @param newGrpCmdtDtlSeq
	 */
	public void setNewGrpCmdtDtlSeq(String newGrpCmdtDtlSeq) {
		this.newGrpCmdtDtlSeq = newGrpCmdtDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param noteChk
	 */
	public void setNoteChk(String noteChk) {
		this.noteChk = noteChk;
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
	 * @param mqcQty
	 */
	public void setMqcQty(String mqcQty) {
		this.mqcQty = mqcQty;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param oldLocChk
	 */
	public void setOldLocChk(String oldLocChk) {
		this.oldLocChk = oldLocChk;
	}
	
	/**
	 * Column Info
	 * @param locChk
	 */
	public void setLocChk(String locChk) {
		this.locChk = locChk;
	}
	
	/**
	 * Column Info
	 * @param cmdtChk
	 */
	public void setCmdtChk(String cmdtChk) {
		this.cmdtChk = cmdtChk;
	}
	
	/**
	 * Column Info
	 * @param arbDesChk
	 */
	public void setArbDesChk(String arbDesChk) {
		this.arbDesChk = arbDesChk;
	}
	
	/**
	 * Column Info
	 * @param rateChk
	 */
	public void setRateChk(String rateChk) {
		this.rateChk = rateChk;
	}
	
	/**
	 * Column Info
	 * @param grpCmdtSeq
	 */
	public void setGrpCmdtSeq(String grpCmdtSeq) {
		this.grpCmdtSeq = grpCmdtSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCmdtTpwChk(JSPUtil.getParameter(request, "cmdt_tpw_chk", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setCmdtTpwMst(JSPUtil.getParameter(request, "cmdt_tpw_mst", ""));
		setSvcScpNm(JSPUtil.getParameter(request, "svc_scp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setGrpCmdtDtlSeq(JSPUtil.getParameter(request, "grp_cmdt_dtl_seq", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setNoteHdrSeq(JSPUtil.getParameter(request, "note_hdr_seq", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setPrcCustTpCd(JSPUtil.getParameter(request, "prc_cust_tp_cd", ""));
		setNewGrpCmdtSeq(JSPUtil.getParameter(request, "new_grp_cmdt_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setGohChk(JSPUtil.getParameter(request, "goh_chk", ""));
		setArbOrgChk(JSPUtil.getParameter(request, "arb_org_chk", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setCmdtTpwDtl(JSPUtil.getParameter(request, "cmdt_tpw_dtl", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
		setOldCmdtChk(JSPUtil.getParameter(request, "old_cmdt_chk", ""));
		setNewGrpCmdtDtlSeq(JSPUtil.getParameter(request, "new_grp_cmdt_dtl_seq", ""));
		setNoteChk(JSPUtil.getParameter(request, "note_chk", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setMqcQty(JSPUtil.getParameter(request, "mqc_qty", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setOldLocChk(JSPUtil.getParameter(request, "old_loc_chk", ""));
		setLocChk(JSPUtil.getParameter(request, "loc_chk", ""));
		setCmdtChk(JSPUtil.getParameter(request, "cmdt_chk", ""));
		setArbDesChk(JSPUtil.getParameter(request, "arb_des_chk", ""));
		setRateChk(JSPUtil.getParameter(request, "rate_chk", ""));
		setGrpCmdtSeq(JSPUtil.getParameter(request, "grp_cmdt_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpScpGlineCopyVO[]
	 */
	public SpScpGlineCopyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpScpGlineCopyVO[]
	 */
	public SpScpGlineCopyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpScpGlineCopyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cmdtTpwChk = (JSPUtil.getParameter(request, prefix	+ "cmdt_tpw_chk", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq", length));
			String[] cmdtTpwMst = (JSPUtil.getParameter(request, prefix	+ "cmdt_tpw_mst", length));
			String[] svcScpNm = (JSPUtil.getParameter(request, prefix	+ "svc_scp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] grpCmdtDtlSeq = (JSPUtil.getParameter(request, prefix	+ "grp_cmdt_dtl_seq", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] noteHdrSeq = (JSPUtil.getParameter(request, prefix	+ "note_hdr_seq", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] prcCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cust_tp_cd", length));
			String[] newGrpCmdtSeq = (JSPUtil.getParameter(request, prefix	+ "new_grp_cmdt_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] gohChk = (JSPUtil.getParameter(request, prefix	+ "goh_chk", length));
			String[] arbOrgChk = (JSPUtil.getParameter(request, prefix	+ "arb_org_chk", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] cmdtTpwDtl = (JSPUtil.getParameter(request, prefix	+ "cmdt_tpw_dtl", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] oldCmdtChk = (JSPUtil.getParameter(request, prefix	+ "old_cmdt_chk", length));
			String[] newGrpCmdtDtlSeq = (JSPUtil.getParameter(request, prefix	+ "new_grp_cmdt_dtl_seq", length));
			String[] noteChk = (JSPUtil.getParameter(request, prefix	+ "note_chk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mqcQty = (JSPUtil.getParameter(request, prefix	+ "mqc_qty", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] oldLocChk = (JSPUtil.getParameter(request, prefix	+ "old_loc_chk", length));
			String[] locChk = (JSPUtil.getParameter(request, prefix	+ "loc_chk", length));
			String[] cmdtChk = (JSPUtil.getParameter(request, prefix	+ "cmdt_chk", length));
			String[] arbDesChk = (JSPUtil.getParameter(request, prefix	+ "arb_des_chk", length));
			String[] rateChk = (JSPUtil.getParameter(request, prefix	+ "rate_chk", length));
			String[] grpCmdtSeq = (JSPUtil.getParameter(request, prefix	+ "grp_cmdt_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpScpGlineCopyVO();
				if (cmdtTpwChk[i] != null)
					model.setCmdtTpwChk(cmdtTpwChk[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (cmdtTpwMst[i] != null)
					model.setCmdtTpwMst(cmdtTpwMst[i]);
				if (svcScpNm[i] != null)
					model.setSvcScpNm(svcScpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (grpCmdtDtlSeq[i] != null)
					model.setGrpCmdtDtlSeq(grpCmdtDtlSeq[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (noteHdrSeq[i] != null)
					model.setNoteHdrSeq(noteHdrSeq[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (prcCustTpCd[i] != null)
					model.setPrcCustTpCd(prcCustTpCd[i]);
				if (newGrpCmdtSeq[i] != null)
					model.setNewGrpCmdtSeq(newGrpCmdtSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (gohChk[i] != null)
					model.setGohChk(gohChk[i]);
				if (arbOrgChk[i] != null)
					model.setArbOrgChk(arbOrgChk[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (cmdtTpwDtl[i] != null)
					model.setCmdtTpwDtl(cmdtTpwDtl[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (oldCmdtChk[i] != null)
					model.setOldCmdtChk(oldCmdtChk[i]);
				if (newGrpCmdtDtlSeq[i] != null)
					model.setNewGrpCmdtDtlSeq(newGrpCmdtDtlSeq[i]);
				if (noteChk[i] != null)
					model.setNoteChk(noteChk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mqcQty[i] != null)
					model.setMqcQty(mqcQty[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (oldLocChk[i] != null)
					model.setOldLocChk(oldLocChk[i]);
				if (locChk[i] != null)
					model.setLocChk(locChk[i]);
				if (cmdtChk[i] != null)
					model.setCmdtChk(cmdtChk[i]);
				if (arbDesChk[i] != null)
					model.setArbDesChk(arbDesChk[i]);
				if (rateChk[i] != null)
					model.setRateChk(rateChk[i]);
				if (grpCmdtSeq[i] != null)
					model.setGrpCmdtSeq(grpCmdtSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpScpGlineCopyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpScpGlineCopyVO[]
	 */
	public SpScpGlineCopyVO[] getSpScpGlineCopyVOs(){
		SpScpGlineCopyVO[] vos = (SpScpGlineCopyVO[])models.toArray(new SpScpGlineCopyVO[models.size()]);
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
		this.cmdtTpwChk = this.cmdtTpwChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTpwMst = this.cmdtTpwMst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpNm = this.svcScpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCmdtDtlSeq = this.grpCmdtDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteHdrSeq = this.noteHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCustTpCd = this.prcCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newGrpCmdtSeq = this.newGrpCmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gohChk = this.gohChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arbOrgChk = this.arbOrgChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTpwDtl = this.cmdtTpwDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCmdtChk = this.oldCmdtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newGrpCmdtDtlSeq = this.newGrpCmdtDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteChk = this.noteChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqcQty = this.mqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldLocChk = this.oldLocChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locChk = this.locChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtChk = this.cmdtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arbDesChk = this.arbDesChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateChk = this.rateChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCmdtSeq = this.grpCmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
