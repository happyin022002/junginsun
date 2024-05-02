/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : IHCGuidelineMainVO.java
*@FileTitle : IHCGuidelineMainVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.14
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.11.14 CHLOE MIJIN SEO 
* 1.0 Creation
* 2013.02.04 전윤주 [CHM-201322884]confirm staff-team, Creation staff-team 보이도록 변경  
* 2013.04.24 전윤주 [CHM-201324375]IHC_TRF_AMDT_TP_CD 추가
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author CHLOE MIJIN SEO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IHCGuidelineMainVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IHCGuidelineMainVO> models = new ArrayList<IHCGuidelineMainVO>();
	
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String ihcTrfAmdtTpCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String trfCurrCd = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String creUsr = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String cfmUsr = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String ficPropStsCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ihcTrfNo = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String spclCount = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cfmOfcCd = null;
	/* Column Info */
	private String costCntCd = null;
	/* Column Info */
	private String ficPropStsNm = null;
	/* Column Info */
	private String usaScpBndFlg = null;
	/* Column Info */
	private String amdtEff = null;
	/* Column Info */
	private String tobeAmdtSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IHCGuidelineMainVO() {}

	public IHCGuidelineMainVO(String ibflag, String pagerows, String ihcTrfNo, String amdtSeq, String ihcTrfAmdtTpCd, String creDt, String effDt, String cfmDt, String expDt, String creUsrId, String creOfcCd, String creUsr, String ficPropStsCd, String ficPropStsNm, String svcScpCd, String updUsrId, String updDt, String trfCurrCd, String loclCurrCd, String cfmUsrId, String cfmUsr, String cfmOfcCd, String orgDestTpCd, String costCntCd, String usaScpBndFlg, String rhqCd, String amdtEff, String tobeAmdtSeq, String costTrfNo, String spclCount) {
		this.amdtSeq = amdtSeq;
		this.ihcTrfAmdtTpCd = ihcTrfAmdtTpCd;
		this.svcScpCd = svcScpCd;
		this.trfCurrCd = trfCurrCd;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.creUsr = creUsr;
		this.cfmUsrId = cfmUsrId;
		this.cfmUsr = cfmUsr;
		this.expDt = expDt;
		this.ficPropStsCd = ficPropStsCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.ihcTrfNo = ihcTrfNo;
		this.rhqCd = rhqCd;
		this.costTrfNo = costTrfNo;
		this.cfmDt = cfmDt;
		this.loclCurrCd = loclCurrCd;
		this.spclCount = spclCount;
		this.orgDestTpCd = orgDestTpCd;
		this.creUsrId = creUsrId;
		this.cfmOfcCd = cfmOfcCd;
		this.costCntCd = costCntCd;
		this.ficPropStsNm = ficPropStsNm;
		this.usaScpBndFlg = usaScpBndFlg;
		this.amdtEff = amdtEff;
		this.tobeAmdtSeq = tobeAmdtSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("ihc_trf_amdt_tp_cd", getIhcTrfAmdtTpCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("trf_curr_cd", getTrfCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cre_usr", getCreUsr());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("cfm_usr", getCfmUsr());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("fic_prop_sts_cd", getFicPropStsCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ihc_trf_no", getIhcTrfNo());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("spcl_count", getSpclCount());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cfm_ofc_cd", getCfmOfcCd());
		this.hashColumns.put("cost_cnt_cd", getCostCntCd());
		this.hashColumns.put("fic_prop_sts_nm", getFicPropStsNm());
		this.hashColumns.put("usa_scp_bnd_flg", getUsaScpBndFlg());
		this.hashColumns.put("amdt_eff", getAmdtEff());
		this.hashColumns.put("tobe_amdt_seq", getTobeAmdtSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("ihc_trf_amdt_tp_cd", "ihcTrfAmdtTpCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("trf_curr_cd", "trfCurrCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cre_usr", "creUsr");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("cfm_usr", "cfmUsr");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("fic_prop_sts_cd", "ficPropStsCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ihc_trf_no", "ihcTrfNo");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("spcl_count", "spclCount");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cfm_ofc_cd", "cfmOfcCd");
		this.hashFields.put("cost_cnt_cd", "costCntCd");
		this.hashFields.put("fic_prop_sts_nm", "ficPropStsNm");
		this.hashFields.put("usa_scp_bnd_flg", "usaScpBndFlg");
		this.hashFields.put("amdt_eff", "amdtEff");
		this.hashFields.put("tobe_amdt_seq", "tobeAmdtSeq");
		return this.hashFields;
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
	 * @return ihcTrfAmdtTpCd
	 */
	public String getIhcTrfAmdtTpCd() {
		return this.ihcTrfAmdtTpCd;
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
	 * @return trfCurrCd
	 */
	public String getTrfCurrCd() {
		return this.trfCurrCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return creUsr
	 */
	public String getCreUsr() {
		return this.creUsr;
	}
	
	/**
	 * Column Info
	 * @return cfmUsrId
	 */
	public String getCfmUsrId() {
		return this.cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @return cfmUsr
	 */
	public String getCfmUsr() {
		return this.cfmUsr;
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
	 * @return ficPropStsCd
	 */
	public String getFicPropStsCd() {
		return this.ficPropStsCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return ihcTrfNo
	 */
	public String getIhcTrfNo() {
		return this.ihcTrfNo;
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
	 * @return costTrfNo
	 */
	public String getCostTrfNo() {
		return this.costTrfNo;
	}
	
	/**
	 * Column Info
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return spclCount
	 */
	public String getSpclCount() {
		return this.spclCount;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return cfmOfcCd
	 */
	public String getCfmOfcCd() {
		return this.cfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return costCntCd
	 */
	public String getCostCntCd() {
		return this.costCntCd;
	}
	
	/**
	 * Column Info
	 * @return ficPropStsNm
	 */
	public String getFicPropStsNm() {
		return this.ficPropStsNm;
	}
	
	/**
	 * Column Info
	 * @return usaScpBndFlg
	 */
	public String getUsaScpBndFlg() {
		return this.usaScpBndFlg;
	}
	
	/**
	 * Column Info
	 * @return amdtEff
	 */
	public String getAmdtEff() {
		return this.amdtEff;
	}
	
	/**
	 * Column Info
	 * @return tobeAmdtSeq
	 */
	public String getTobeAmdtSeq() {
		return this.tobeAmdtSeq;
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
	 * @param ihcTrfAmdtTpCd
	 */
	public void setIhcTrfAmdtTpCd(String ihcTrfAmdtTpCd) {
		this.ihcTrfAmdtTpCd = ihcTrfAmdtTpCd;
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
	 * @param trfCurrCd
	 */
	public void setTrfCurrCd(String trfCurrCd) {
		this.trfCurrCd = trfCurrCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param creUsr
	 */
	public void setCreUsr(String creUsr) {
		this.creUsr = creUsr;
	}
	
	/**
	 * Column Info
	 * @param cfmUsrId
	 */
	public void setCfmUsrId(String cfmUsrId) {
		this.cfmUsrId = cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @param cfmUsr
	 */
	public void setCfmUsr(String cfmUsr) {
		this.cfmUsr = cfmUsr;
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
	 * @param ficPropStsCd
	 */
	public void setFicPropStsCd(String ficPropStsCd) {
		this.ficPropStsCd = ficPropStsCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param ihcTrfNo
	 */
	public void setIhcTrfNo(String ihcTrfNo) {
		this.ihcTrfNo = ihcTrfNo;
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
	 * @param costTrfNo
	 */
	public void setCostTrfNo(String costTrfNo) {
		this.costTrfNo = costTrfNo;
	}
	
	/**
	 * Column Info
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param spclCount
	 */
	public void setSpclCount(String spclCount) {
		this.spclCount = spclCount;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cfmOfcCd
	 */
	public void setCfmOfcCd(String cfmOfcCd) {
		this.cfmOfcCd = cfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param costCntCd
	 */
	public void setCostCntCd(String costCntCd) {
		this.costCntCd = costCntCd;
	}
	
	/**
	 * Column Info
	 * @param ficPropStsNm
	 */
	public void setFicPropStsNm(String ficPropStsNm) {
		this.ficPropStsNm = ficPropStsNm;
	}
	
	/**
	 * Column Info
	 * @param usaScpBndFlg
	 */
	public void setUsaScpBndFlg(String usaScpBndFlg) {
		this.usaScpBndFlg = usaScpBndFlg;
	}
	
	/**
	 * Column Info
	 * @param amdtEff
	 */
	public void setAmdtEff(String amdtEff) {
		this.amdtEff = amdtEff;
	}
	
	/**
	 * Column Info
	 * @param tobeAmdtSeq
	 */
	public void setTobeAmdtSeq(String tobeAmdtSeq) {
		this.tobeAmdtSeq = tobeAmdtSeq;
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
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setIhcTrfAmdtTpCd(JSPUtil.getParameter(request, prefix + "ihc_trf_amdt_tp_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setTrfCurrCd(JSPUtil.getParameter(request, prefix + "trf_curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCreUsr(JSPUtil.getParameter(request, prefix + "cre_usr", ""));
		setCfmUsrId(JSPUtil.getParameter(request, prefix + "cfm_usr_id", ""));
		setCfmUsr(JSPUtil.getParameter(request, prefix + "cfm_usr", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setFicPropStsCd(JSPUtil.getParameter(request, prefix + "fic_prop_sts_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setIhcTrfNo(JSPUtil.getParameter(request, prefix + "ihc_trf_no", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setSpclCount(JSPUtil.getParameter(request, prefix + "spcl_count", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCfmOfcCd(JSPUtil.getParameter(request, prefix + "cfm_ofc_cd", ""));
		setCostCntCd(JSPUtil.getParameter(request, prefix + "cost_cnt_cd", ""));
		setFicPropStsNm(JSPUtil.getParameter(request, prefix + "fic_prop_sts_nm", ""));
		setUsaScpBndFlg(JSPUtil.getParameter(request, prefix + "usa_scp_bnd_flg", ""));
		setAmdtEff(JSPUtil.getParameter(request, prefix + "amdt_eff", ""));
		setTobeAmdtSeq(JSPUtil.getParameter(request, prefix + "tobe_amdt_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IHCGuidelineMainVO[]
	 */
	public IHCGuidelineMainVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IHCGuidelineMainVO[]
	 */
	public IHCGuidelineMainVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IHCGuidelineMainVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] ihcTrfAmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "ihcTrfAmdtTpCd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] trfCurrCd = (JSPUtil.getParameter(request, prefix	+ "trf_curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] creUsr = (JSPUtil.getParameter(request, prefix	+ "cre_usr", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] cfmUsr = (JSPUtil.getParameter(request, prefix	+ "cfm_usr", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] ficPropStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_prop_sts_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ihcTrfNo = (JSPUtil.getParameter(request, prefix	+ "ihc_trf_no", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] spclCount = (JSPUtil.getParameter(request, prefix	+ "spcl_count", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "cfm_ofc_cd", length));
			String[] costCntCd = (JSPUtil.getParameter(request, prefix	+ "cost_cnt_cd", length));
			String[] ficPropStsNm = (JSPUtil.getParameter(request, prefix	+ "fic_prop_sts_nm", length));
			String[] usaScpBndFlg = (JSPUtil.getParameter(request, prefix	+ "usa_scp_bnd_flg", length));
			String[] amdtEff = (JSPUtil.getParameter(request, prefix	+ "amdt_eff", length));
			String[] tobeAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "tobe_amdt_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new IHCGuidelineMainVO();
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (ihcTrfAmdtTpCd[i] != null)
					model.setIhcTrfAmdtTpCd(ihcTrfAmdtTpCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (trfCurrCd[i] != null)
					model.setTrfCurrCd(trfCurrCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (creUsr[i] != null)
					model.setCreUsr(creUsr[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (cfmUsr[i] != null)
					model.setCfmUsr(cfmUsr[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (ficPropStsCd[i] != null)
					model.setFicPropStsCd(ficPropStsCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ihcTrfNo[i] != null)
					model.setIhcTrfNo(ihcTrfNo[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (spclCount[i] != null)
					model.setSpclCount(spclCount[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cfmOfcCd[i] != null)
					model.setCfmOfcCd(cfmOfcCd[i]);
				if (costCntCd[i] != null)
					model.setCostCntCd(costCntCd[i]);
				if (ficPropStsNm[i] != null)
					model.setFicPropStsNm(ficPropStsNm[i]);
				if (usaScpBndFlg[i] != null)
					model.setUsaScpBndFlg(usaScpBndFlg[i]);
				if (amdtEff[i] != null)
					model.setAmdtEff(amdtEff[i]);
				if (tobeAmdtSeq[i] != null)
					model.setTobeAmdtSeq(tobeAmdtSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIHCGuidelineMainVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IHCGuidelineMainVO[]
	 */
	public IHCGuidelineMainVO[] getIHCGuidelineMainVOs(){
		IHCGuidelineMainVO[] vos = (IHCGuidelineMainVO[])models.toArray(new IHCGuidelineMainVO[models.size()]);
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
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfAmdtTpCd = this.ihcTrfAmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCurrCd = this.trfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsr = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsr = this.cfmUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficPropStsCd = this.ficPropStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfNo = this.ihcTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCount = this.spclCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmOfcCd = this.cfmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCntCd = this.costCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficPropStsNm = this.ficPropStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaScpBndFlg = this.usaScpBndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtEff = this.amdtEff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tobeAmdtSeq = this.tobeAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
