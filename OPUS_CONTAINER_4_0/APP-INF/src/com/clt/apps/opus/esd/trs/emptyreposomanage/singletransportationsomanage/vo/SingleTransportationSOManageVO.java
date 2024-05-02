/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SingleTransportationSOManageVO.java
 *@FileTitle : SingleTransportationSOManageVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.09.22  
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SingleTransportationSOManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SingleTransportationSOManageVO> models = new ArrayList<SingleTransportationSOManageVO>();

	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String eventDate = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String eqUsed = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String spclInstrRmk = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ownrCoCd = null;
	/* Column Info */
	private String lessor = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String trspMtyRqstDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String refSeq = null;
	/* Column Info */
	private String trspCostDtlModName = null;
	/* Column Info */
	private String movementSts = null;
	/* Column Info */
	private String creationYard = null;
	/* Column Info */
	private String repoPurpRmk = null;
	/* Column Info */
	private String trspSoCmbSeq = null;
	/* Column Info */
	private String trspSoCmbSrtNo = null;
	/* Column Info */
	private String trspSoStsCd = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SingleTransportationSOManageVO() {
	}

	public SingleTransportationSOManageVO(String ibflag, String pagerows, String repoPlnId, String plnYrwk, String refId, String refSeq, String trspSoOfcCtyCd, String trspSoSeq, String repoPurpRmk, String fmNodCd, String toNodCd, String trspSoCmbSeq, String trspCostDtlModName, String eqNo,
			String eqTpszCd, String trspCrrModCd, String lessor, String lstmCd, String ownrCoCd, String eqUsed, String movementSts, String creationYard, String eventDate, String trspMtyRqstDt, String interRmk, String spclInstrRmk, String creUsrId, String updUsrId, String trspSoCmbSrtNo,
			String trspSoStsCd) {
		this.toNodCd = toNodCd;
		this.eventDate = eventDate;
		this.trspSoSeq = trspSoSeq;
		this.refId = refId;
		this.plnYrwk = plnYrwk;
		this.eqUsed = eqUsed;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.interRmk = interRmk;
		this.spclInstrRmk = spclInstrRmk;
		this.lstmCd = lstmCd;
		this.trspCrrModCd = trspCrrModCd;
		this.updUsrId = updUsrId;
		this.ownrCoCd = ownrCoCd;
		this.lessor = lessor;
		this.eqTpszCd = eqTpszCd;
		this.fmNodCd = fmNodCd;
		this.repoPlnId = repoPlnId;
		this.trspMtyRqstDt = trspMtyRqstDt;
		this.creUsrId = creUsrId;
		this.refSeq = refSeq;
		this.trspCostDtlModName = trspCostDtlModName;
		this.movementSts = movementSts;
		this.creationYard = creationYard;
		this.repoPurpRmk = repoPurpRmk;
		this.trspSoCmbSeq = trspSoCmbSeq;
		this.trspSoCmbSrtNo = trspSoCmbSrtNo;
		this.trspSoStsCd = trspSoStsCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("event_date", getEventDate());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("eq_used", getEqUsed());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("spcl_instr_rmk", getSpclInstrRmk());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ownr_co_cd", getOwnrCoCd());
		this.hashColumns.put("lessor", getLessor());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("trsp_mty_rqst_dt", getTrspMtyRqstDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ref_seq", getRefSeq());
		this.hashColumns.put("trsp_cost_dtl_mod_name", getTrspCostDtlModName());
		this.hashColumns.put("movement_sts", getMovementSts());
		this.hashColumns.put("creation_yard", getCreationYard());
		this.hashColumns.put("repo_purp_rmk", getRepoPurpRmk());
		this.hashColumns.put("trsp_so_cmb_seq", getTrspSoCmbSeq());
		this.hashColumns.put("trsp_so_cmb_srt_no", getTrspSoCmbSrtNo());
		this.hashColumns.put("trsp_so_sts_cd", getTrspSoStsCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("event_date", "eventDate");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("eq_used", "eqUsed");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("spcl_instr_rmk", "spclInstrRmk");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ownr_co_cd", "ownrCoCd");
		this.hashFields.put("lessor", "lessor");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("trsp_mty_rqst_dt", "trspMtyRqstDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ref_seq", "refSeq");
		this.hashFields.put("trsp_cost_dtl_mod_name", "trspCostDtlModName");
		this.hashFields.put("movement_sts", "movementSts");
		this.hashFields.put("creation_yard", "creationYard");
		this.hashFields.put("repo_purp_rmk", "repoPurpRmk");
		this.hashFields.put("trsp_so_cmb_seq", "trspSoCmbSeq");
		this.hashFields.put("trsp_so_cmb_srt_no", trspSoCmbSrtNo);
		this.hashFields.put("trsp_so_sts_cd", trspSoStsCd);
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return eventDate
	 */
	public String getEventDate() {
		return this.eventDate;
	}

	/**
	 * Column Info
	 * 
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return refId
	 */
	public String getRefId() {
		return this.refId;
	}

	/**
	 * Column Info
	 * 
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}

	/**
	 * Column Info
	 * 
	 * @return eqUsed
	 */
	public String getEqUsed() {
		return this.eqUsed;
	}

	/**
	 * Column Info
	 * 
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}

	/**
	 * Column Info
	 * 
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}

	/**
	 * Column Info
	 * 
	 * @return spclInstrRmk
	 */
	public String getSpclInstrRmk() {
		return this.spclInstrRmk;
	}

	/**
	 * Column Info
	 * 
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}

	/**
	 * Column Info
	 * 
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}

	/**
	 * Column Info
	 * 
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return ownrCoCd
	 */
	public String getOwnrCoCd() {
		return this.ownrCoCd;
	}

	/**
	 * Column Info
	 * 
	 * @return lessor
	 */
	public String getLessor() {
		return this.lessor;
	}

	/**
	 * Column Info
	 * 
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}

	/**
	 * Column Info
	 * 
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
	}

	/**
	 * Column Info
	 * 
	 * @return trspMtyRqstDt
	 */
	public String getTrspMtyRqstDt() {
		return this.trspMtyRqstDt;
	}

	/**
	 * Column Info
	 * 
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return refSeq
	 */
	public String getRefSeq() {
		return this.refSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return trspCostDtlModName
	 */
	public String getTrspCostDtlModName() {
		return this.trspCostDtlModName;
	}

	/**
	 * Column Info
	 * 
	 * @return movementSts
	 */
	public String getMovementSts() {
		return this.movementSts;
	}

	/**
	 * Column Info
	 * 
	 * @return creationYard
	 */
	public String getCreationYard() {
		return this.creationYard;
	}

	/**
	 * Column Info
	 * 
	 * @return repoPurpRmk
	 */
	public String getRepoPurpRmk() {
		return this.repoPurpRmk;
	}

	/**
	 * Column Info
	 * 
	 * @return trspSoCmbSeq
	 */
	public String getTrspSoCmbSeq() {
		return this.trspSoCmbSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param eventDate
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * Column Info
	 * 
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param refId
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}

	/**
	 * Column Info
	 * 
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}

	/**
	 * Column Info
	 * 
	 * @param eqUsed
	 */
	public void setEqUsed(String eqUsed) {
		this.eqUsed = eqUsed;
	}

	/**
	 * Column Info
	 * 
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}

	/**
	 * Column Info
	 * 
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}

	/**
	 * Column Info
	 * 
	 * @param spclInstrRmk
	 */
	public void setSpclInstrRmk(String spclInstrRmk) {
		this.spclInstrRmk = spclInstrRmk;
	}

	/**
	 * Column Info
	 * 
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	/**
	 * Column Info
	 * 
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}

	/**
	 * Column Info
	 * 
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param ownrCoCd
	 */
	public void setOwnrCoCd(String ownrCoCd) {
		this.ownrCoCd = ownrCoCd;
	}

	/**
	 * Column Info
	 * 
	 * @param lessor
	 */
	public void setLessor(String lessor) {
		this.lessor = lessor;
	}

	/**
	 * Column Info
	 * 
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}

	/**
	 * Column Info
	 * 
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}

	/**
	 * Column Info
	 * 
	 * @param trspMtyRqstDt
	 */
	public void setTrspMtyRqstDt(String trspMtyRqstDt) {
		this.trspMtyRqstDt = trspMtyRqstDt;
	}

	/**
	 * Column Info
	 * 
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param refSeq
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param trspCostDtlModName
	 */
	public void setTrspCostDtlModName(String trspCostDtlModName) {
		this.trspCostDtlModName = trspCostDtlModName;
	}

	/**
	 * Column Info
	 * 
	 * @param movementSts
	 */
	public void setMovementSts(String movementSts) {
		this.movementSts = movementSts;
	}

	/**
	 * Column Info
	 * 
	 * @param creationYard
	 */
	public void setCreationYard(String creationYard) {
		this.creationYard = creationYard;
	}

	/**
	 * Column Info
	 * 
	 * @param repoPurpRmk
	 */
	public void setRepoPurpRmk(String repoPurpRmk) {
		this.repoPurpRmk = repoPurpRmk;
	}

	/**
	 * Column Info
	 * 
	 * @param trspSoCmbSeq
	 */
	public void setTrspSoCmbSeq(String trspSoCmbSeq) {
		this.trspSoCmbSeq = trspSoCmbSeq;
	}

	/**
	 * 
	 * @return
	 */
	public String getTrspSoCmbSrtNo() {
		return trspSoCmbSrtNo;
	}

	/**
	 * Column Info
	 * 
	 * @param trspSoCmbSeq
	 */
	public void setTrspSoCmbSrtNo(String trspSoCmbSrtNo) {
		this.trspSoCmbSrtNo = trspSoCmbSrtNo;
	}

	/**
	 * 
	 * @return
	 */
	public String getTrspSoStsCd() {
		return trspSoStsCd;
	}

	/**
	 * 
	 * @param trspSoStsCd
	 */
	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToNodCd(JSPUtil.getParameter(request, "to_nod_cd", ""));
		setEventDate(JSPUtil.getParameter(request, "event_date", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, "trsp_so_seq", ""));
		setRefId(JSPUtil.getParameter(request, "ref_id", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setEqUsed(JSPUtil.getParameter(request, "eq_used", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setInterRmk(JSPUtil.getParameter(request, "inter_rmk", ""));
		setSpclInstrRmk(JSPUtil.getParameter(request, "spcl_instr_rmk", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, "trsp_crr_mod_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setOwnrCoCd(JSPUtil.getParameter(request, "ownr_co_cd", ""));
		setLessor(JSPUtil.getParameter(request, "lessor", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, "fm_nod_cd", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setTrspMtyRqstDt(JSPUtil.getParameter(request, "trsp_mty_rqst_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setRefSeq(JSPUtil.getParameter(request, "ref_seq", ""));
		setTrspCostDtlModName(JSPUtil.getParameter(request, "trsp_cost_dtl_mod_name", ""));
		setMovementSts(JSPUtil.getParameter(request, "movement_sts", ""));
		setCreationYard(JSPUtil.getParameter(request, "creation_yard", ""));
		setRepoPurpRmk(JSPUtil.getParameter(request, "repo_purp_rmk", ""));
		setTrspSoCmbSeq(JSPUtil.getParameter(request, "trsp_so_cmb_seq", ""));
		setTrspSoCmbSeq(JSPUtil.getParameter(request, "trsp_so_cmb_srt_no", ""));
		setTrspSoStsCd(JSPUtil.getParameter(request, "trsp_so_sts_cd", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return SingleTransportationSOManageVO[]
	 */
	public SingleTransportationSOManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return SingleTransportationSOManageVO[]
	 */
	public SingleTransportationSOManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SingleTransportationSOManageVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix + "to_nod_cd", length));
			String[] eventDate = (JSPUtil.getParameter(request, prefix + "event_date", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix + "trsp_so_seq", length));
			String[] refId = (JSPUtil.getParameter(request, prefix + "ref_id", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix + "pln_yrwk", length));
			String[] eqUsed = (JSPUtil.getParameter(request, prefix + "eq_used", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix + "eq_no", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix + "inter_rmk", length));
			String[] spclInstrRmk = (JSPUtil.getParameter(request, prefix + "spcl_instr_rmk", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix + "lstm_cd", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
			String[] ownrCoCd = (JSPUtil.getParameter(request, prefix + "ownr_co_cd", length));
			String[] lessor = (JSPUtil.getParameter(request, prefix + "lessor", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix + "fm_nod_cd", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix + "repo_pln_id", length));
			String[] trspMtyRqstDt = (JSPUtil.getParameter(request, prefix + "trsp_mty_rqst_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
			String[] refSeq = (JSPUtil.getParameter(request, prefix + "ref_seq", length));
			String[] trspCostDtlModName = (JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_name", length));
			String[] movementSts = (JSPUtil.getParameter(request, prefix + "movement_sts", length));
			String[] creationYard = (JSPUtil.getParameter(request, prefix + "creation_yard", length));
			String[] repoPurpRmk = (JSPUtil.getParameter(request, prefix + "repo_purp_rmk", length));
			String[] trspSoCmbSeq = (JSPUtil.getParameter(request, prefix + "trsp_so_cmb_seq", length));
			String[] trspSoCmbSrtNo = (JSPUtil.getParameter(request, prefix + "trsp_so_cmb_srt_no", length));
			String[] trspSoStsCd = (JSPUtil.getParameter(request, prefix + "trsp_so_sts_cd", length));

			for (int i = 0; i < length; i++) {
				model = new SingleTransportationSOManageVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (eventDate[i] != null)
					model.setEventDate(eventDate[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (eqUsed[i] != null)
					model.setEqUsed(eqUsed[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (spclInstrRmk[i] != null)
					model.setSpclInstrRmk(spclInstrRmk[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ownrCoCd[i] != null)
					model.setOwnrCoCd(ownrCoCd[i]);
				if (lessor[i] != null)
					model.setLessor(lessor[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (trspMtyRqstDt[i] != null)
					model.setTrspMtyRqstDt(trspMtyRqstDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (refSeq[i] != null)
					model.setRefSeq(refSeq[i]);
				if (trspCostDtlModName[i] != null)
					model.setTrspCostDtlModName(trspCostDtlModName[i]);
				if (movementSts[i] != null)
					model.setMovementSts(movementSts[i]);
				if (creationYard[i] != null)
					model.setCreationYard(creationYard[i]);
				if (repoPurpRmk[i] != null)
					model.setRepoPurpRmk(repoPurpRmk[i]);
				if (trspSoCmbSeq[i] != null)
					model.setTrspSoCmbSeq(trspSoCmbSeq[i]);
				if (trspSoCmbSrtNo[i] != null)
					model.setTrspSoCmbSrtNo(trspSoCmbSrtNo[i]);
				if (trspSoStsCd[i] != null)
					model.setTrspSoStsCd(trspSoStsCd[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSingleTransportationSOManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return SingleTransportationSOManageVO[]
	 */
	public SingleTransportationSOManageVO[] getSingleTransportationSOManageVOs() {
		SingleTransportationSOManageVO[] vos = (SingleTransportationSOManageVO[]) models.toArray(new SingleTransportationSOManageVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
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
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = null;
		}
		return arr;
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.toNodCd = this.toNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventDate = this.eventDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqUsed = this.eqUsed.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInstrRmk = this.spclInstrRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrCoCd = this.ownrCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessor = this.lessor.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspMtyRqstDt = this.trspMtyRqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSeq = this.refSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModName = this.trspCostDtlModName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.movementSts = this.movementSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creationYard = this.creationYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPurpRmk = this.repoPurpRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbSeq = this.trspSoCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbSrtNo = this.trspSoCmbSrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoStsCd = this.trspSoStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
