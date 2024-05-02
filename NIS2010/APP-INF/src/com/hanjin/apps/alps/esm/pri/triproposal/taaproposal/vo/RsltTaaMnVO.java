/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltTaaMnVO.java
*@FileTitle : RsltTaaMnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.12.16 문동규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo;

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
 * @author 문동규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltTaaMnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltTaaMnVO> models = new ArrayList<RsltTaaMnVO>();
	
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String taaPropNo = null;
	/* Column Info */
	private String cfmExpDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String svcScpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String respbSlsOfcCd = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtCustNm = null;
	/* Column Info */
	private String respbSrepNm = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String taaSts = null;
	/* Column Info */
	private String ctrtCustSeq = null;
	/* Column Info */
	private String cfmNm = null;
	/* Column Info */
	private String respbSrepCd = null;
	/* Column Info */
	private String ctrtCustCd = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String oldAmdtSeq = null;
	/* Column Info */
	private String ctrtCustValSgmCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltTaaMnVO() {}

	public RsltTaaMnVO(String ibflag, String pagerows, String taaNo, String taaPropNo, String amdtSeq, String svcScpCd, String svcScpNm, String effDt, String expDt, String cfmExpDt, String ctrtCustCntCd, String ctrtCustSeq, String prcCtrtCustTpCd, String ctrtCustNm, String ctrtCustValSgmCd, String respbSlsOfcCd, String respbSrepCd, String respbSrepNm, String cfmFlg, String cfmNm, String creUsrId, String creDt, String updUsrId, String updDt, String oldAmdtSeq, String ctrtCustCd, String taaSts) {
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.taaPropNo = taaPropNo;
		this.cfmExpDt = cfmExpDt;
		this.creDt = creDt;
		this.svcScpNm = svcScpNm;
		this.pagerows = pagerows;
		this.respbSlsOfcCd = respbSlsOfcCd;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.ctrtCustNm = ctrtCustNm;
		this.respbSrepNm = respbSrepNm;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.taaSts = taaSts;
		this.ctrtCustSeq = ctrtCustSeq;
		this.cfmNm = cfmNm;
		this.respbSrepCd = respbSrepCd;
		this.ctrtCustCd = ctrtCustCd;
		this.cfmFlg = cfmFlg;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.creUsrId = creUsrId;
		this.taaNo = taaNo;
		this.oldAmdtSeq = oldAmdtSeq;
		this.ctrtCustValSgmCd = ctrtCustValSgmCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("taa_prop_no", getTaaPropNo());
		this.hashColumns.put("cfm_exp_dt", getCfmExpDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("svc_scp_nm", getSvcScpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("respb_sls_ofc_cd", getRespbSlsOfcCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_cust_nm", getCtrtCustNm());
		this.hashColumns.put("respb_srep_nm", getRespbSrepNm());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("taa_sts", getTaaSts());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("cfm_nm", getCfmNm());
		this.hashColumns.put("respb_srep_cd", getRespbSrepCd());
		this.hashColumns.put("ctrt_cust_cd", getCtrtCustCd());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("old_amdt_seq", getOldAmdtSeq());
		this.hashColumns.put("ctrt_cust_val_sgm_cd", getCtrtCustValSgmCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("taa_prop_no", "taaPropNo");
		this.hashFields.put("cfm_exp_dt", "cfmExpDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("svc_scp_nm", "svcScpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("respb_sls_ofc_cd", "respbSlsOfcCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_cust_nm", "ctrtCustNm");
		this.hashFields.put("respb_srep_nm", "respbSrepNm");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("taa_sts", "taaSts");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("cfm_nm", "cfmNm");
		this.hashFields.put("respb_srep_cd", "respbSrepCd");
		this.hashFields.put("ctrt_cust_cd", "ctrtCustCd");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("old_amdt_seq", "oldAmdtSeq");
		this.hashFields.put("ctrt_cust_val_sgm_cd", "ctrtCustValSgmCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustCntCd
	 */
	public String getCtrtCustCntCd() {
		return this.ctrtCustCntCd;
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
	 * @return taaPropNo
	 */
	public String getTaaPropNo() {
		return this.taaPropNo;
	}
	
	/**
	 * Column Info
	 * @return cfmExpDt
	 */
	public String getCfmExpDt() {
		return this.cfmExpDt;
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
	 * @return respbSlsOfcCd
	 */
	public String getRespbSlsOfcCd() {
		return this.respbSlsOfcCd;
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
	 * @return ctrtCustNm
	 */
	public String getCtrtCustNm() {
		return this.ctrtCustNm;
	}
	
	/**
	 * Column Info
	 * @return respbSrepNm
	 */
	public String getRespbSrepNm() {
		return this.respbSrepNm;
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
	 * @return taaSts
	 */
	public String getTaaSts() {
		return this.taaSts;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSeq
	 */
	public String getCtrtCustSeq() {
		return this.ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @return cfmNm
	 */
	public String getCfmNm() {
		return this.cfmNm;
	}
	
	/**
	 * Column Info
	 * @return respbSrepCd
	 */
	public String getRespbSrepCd() {
		return this.respbSrepCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustCd
	 */
	public String getCtrtCustCd() {
		return this.ctrtCustCd;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return prcCtrtCustTpCd
	 */
	public String getPrcCtrtCustTpCd() {
		return this.prcCtrtCustTpCd;
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
	 * @return oldAmdtSeq
	 */
	public String getOldAmdtSeq() {
		return this.oldAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustValSgmCd
	 */
	public String getCtrtCustValSgmCd() {
		return this.ctrtCustValSgmCd;
	}
	

	/**
	 * Column Info
	 * @param ctrtCustCntCd
	 */
	public void setCtrtCustCntCd(String ctrtCustCntCd) {
		this.ctrtCustCntCd = ctrtCustCntCd;
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
	 * @param taaPropNo
	 */
	public void setTaaPropNo(String taaPropNo) {
		this.taaPropNo = taaPropNo;
	}
	
	/**
	 * Column Info
	 * @param cfmExpDt
	 */
	public void setCfmExpDt(String cfmExpDt) {
		this.cfmExpDt = cfmExpDt;
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
	 * @param respbSlsOfcCd
	 */
	public void setRespbSlsOfcCd(String respbSlsOfcCd) {
		this.respbSlsOfcCd = respbSlsOfcCd;
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
	 * @param ctrtCustNm
	 */
	public void setCtrtCustNm(String ctrtCustNm) {
		this.ctrtCustNm = ctrtCustNm;
	}
	
	/**
	 * Column Info
	 * @param respbSrepNm
	 */
	public void setRespbSrepNm(String respbSrepNm) {
		this.respbSrepNm = respbSrepNm;
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
	 * @param taaSts
	 */
	public void setTaaSts(String taaSts) {
		this.taaSts = taaSts;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSeq
	 */
	public void setCtrtCustSeq(String ctrtCustSeq) {
		this.ctrtCustSeq = ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @param cfmNm
	 */
	public void setCfmNm(String cfmNm) {
		this.cfmNm = cfmNm;
	}
	
	/**
	 * Column Info
	 * @param respbSrepCd
	 */
	public void setRespbSrepCd(String respbSrepCd) {
		this.respbSrepCd = respbSrepCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustCd
	 */
	public void setCtrtCustCd(String ctrtCustCd) {
		this.ctrtCustCd = ctrtCustCd;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param prcCtrtCustTpCd
	 */
	public void setPrcCtrtCustTpCd(String prcCtrtCustTpCd) {
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
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
	 * @param oldAmdtSeq
	 */
	public void setOldAmdtSeq(String oldAmdtSeq) {
		this.oldAmdtSeq = oldAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustValSgmCd
	 */
	public void setCtrtCustValSgmCd(String ctrtCustValSgmCd) {
		this.ctrtCustValSgmCd = ctrtCustValSgmCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCtrtCustCntCd(JSPUtil.getParameter(request, "ctrt_cust_cnt_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setTaaPropNo(JSPUtil.getParameter(request, "taa_prop_no", ""));
		setCfmExpDt(JSPUtil.getParameter(request, "cfm_exp_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSvcScpNm(JSPUtil.getParameter(request, "svc_scp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRespbSlsOfcCd(JSPUtil.getParameter(request, "respb_sls_ofc_cd", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrtCustNm(JSPUtil.getParameter(request, "ctrt_cust_nm", ""));
		setRespbSrepNm(JSPUtil.getParameter(request, "respb_srep_nm", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setTaaSts(JSPUtil.getParameter(request, "taa_sts", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, "ctrt_cust_seq", ""));
		setCfmNm(JSPUtil.getParameter(request, "cfm_nm", ""));
		setRespbSrepCd(JSPUtil.getParameter(request, "respb_srep_cd", ""));
		setCtrtCustCd(JSPUtil.getParameter(request, "ctrt_cust_cd", ""));
		setCfmFlg(JSPUtil.getParameter(request, "cfm_flg", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, "prc_ctrt_cust_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setTaaNo(JSPUtil.getParameter(request, "taa_no", ""));
		setOldAmdtSeq(JSPUtil.getParameter(request, "old_amdt_seq", ""));
		setCtrtCustValSgmCd(JSPUtil.getParameter(request, "ctrt_cust_val_sgm_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltTaaMnVO[]
	 */
	public RsltTaaMnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltTaaMnVO[]
	 */
	public RsltTaaMnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltTaaMnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] taaPropNo = (JSPUtil.getParameter(request, prefix	+ "taa_prop_no", length));
			String[] cfmExpDt = (JSPUtil.getParameter(request, prefix	+ "cfm_exp_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] svcScpNm = (JSPUtil.getParameter(request, prefix	+ "svc_scp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] respbSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "respb_sls_ofc_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtCustNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_nm", length));
			String[] respbSrepNm = (JSPUtil.getParameter(request, prefix	+ "respb_srep_nm", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] taaSts = (JSPUtil.getParameter(request, prefix	+ "taa_sts", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] cfmNm = (JSPUtil.getParameter(request, prefix	+ "cfm_nm", length));
			String[] respbSrepCd = (JSPUtil.getParameter(request, prefix	+ "respb_srep_cd", length));
			String[] ctrtCustCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cd", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] oldAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "old_amdt_seq", length));
			String[] ctrtCustValSgmCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_val_sgm_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltTaaMnVO();
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (taaPropNo[i] != null)
					model.setTaaPropNo(taaPropNo[i]);
				if (cfmExpDt[i] != null)
					model.setCfmExpDt(cfmExpDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (svcScpNm[i] != null)
					model.setSvcScpNm(svcScpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (respbSlsOfcCd[i] != null)
					model.setRespbSlsOfcCd(respbSlsOfcCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtCustNm[i] != null)
					model.setCtrtCustNm(ctrtCustNm[i]);
				if (respbSrepNm[i] != null)
					model.setRespbSrepNm(respbSrepNm[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (taaSts[i] != null)
					model.setTaaSts(taaSts[i]);
				if (ctrtCustSeq[i] != null)
					model.setCtrtCustSeq(ctrtCustSeq[i]);
				if (cfmNm[i] != null)
					model.setCfmNm(cfmNm[i]);
				if (respbSrepCd[i] != null)
					model.setRespbSrepCd(respbSrepCd[i]);
				if (ctrtCustCd[i] != null)
					model.setCtrtCustCd(ctrtCustCd[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (oldAmdtSeq[i] != null)
					model.setOldAmdtSeq(oldAmdtSeq[i]);
				if (ctrtCustValSgmCd[i] != null)
					model.setCtrtCustValSgmCd(ctrtCustValSgmCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltTaaMnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltTaaMnVO[]
	 */
	public RsltTaaMnVO[] getRsltTaaMnVOs(){
		RsltTaaMnVO[] vos = (RsltTaaMnVO[])models.toArray(new RsltTaaMnVO[models.size()]);
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
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaPropNo = this.taaPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmExpDt = this.cfmExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpNm = this.svcScpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbSlsOfcCd = this.respbSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustNm = this.ctrtCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbSrepNm = this.respbSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaSts = this.taaSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmNm = this.cfmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbSrepCd = this.respbSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCd = this.ctrtCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAmdtSeq = this.oldAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustValSgmCd = this.ctrtCustValSgmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
