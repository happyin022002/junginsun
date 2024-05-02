/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomInsuranceVO.java
*@FileTitle : CustomInsuranceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.13 윤세영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.insurance.insurance.vo;

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
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomInsuranceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomInsuranceVO> models = new ArrayList<CustomInsuranceVO>();
	
	/* Column Info */
	private String insCtnt = null;
	/* Column Info */
	private String intDesc = null;
	/* Column Info */
	private String lmtInsUsdAmt = null;
	/* Column Info */
	private String insClmPtyNo = null;
	/* Column Info */
	private String insCurrCd = null;
	/* Column Info */
	private String broClmPtyNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String insurCtrtEffDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String insLoclAmt = null;
	/* Column Info */
	private String rinsClmPtyNo = null;
	/* Column Info */
	private String insurRmk = null;
	/* Column Info */
	private String insurCtrtExpDt = null;
	/* Column Info */
	private String rinsCtnt = null;
	/* Column Info */
	private String insurPlcyYr = null;
	/* Column Info */
	private String cinsCtnt = null;
	/* Column Info */
	private String lmtInsCurrCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String insurTpCd = null;
	/* Column Info */
	private String lmtInsLoclAmt = null;
	/* Column Info */
	private String lmtInsXchRt = null;
	/* Column Info */
	private String insUsdAmt = null;
	/* Column Info */
	private String insXchRt = null;
	/* Column Info */
	private String cinsClmPtyNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String subjMatInsDesc = null;
	/* Column Info */
	private String insurCtnt = null;
	/* Column Info */
	private String insurClmPtyNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomInsuranceVO() {}

	public CustomInsuranceVO(String ibflag, String pagerows, String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurCtnt, String rinsClmPtyNo, String rinsCtnt, String insClmPtyNo, String insCtnt, String cinsClmPtyNo, String cinsCtnt, String broClmPtyNo, String intDesc, String insurCtrtEffDt, String insurCtrtExpDt, String subjMatInsDesc, String insCurrCd, String insLoclAmt, String insXchRt, String insUsdAmt, String lmtInsCurrCd, String lmtInsLoclAmt, String lmtInsXchRt, String lmtInsUsdAmt, String insurRmk, String creUsrId, String updUsrId) {
		this.insCtnt = insCtnt;
		this.intDesc = intDesc;
		this.lmtInsUsdAmt = lmtInsUsdAmt;
		this.insClmPtyNo = insClmPtyNo;
		this.insCurrCd = insCurrCd;
		this.broClmPtyNo = broClmPtyNo;
		this.pagerows = pagerows;
		this.insurCtrtEffDt = insurCtrtEffDt;
		this.ibflag = ibflag;
		this.insLoclAmt = insLoclAmt;
		this.rinsClmPtyNo = rinsClmPtyNo;
		this.insurRmk = insurRmk;
		this.insurCtrtExpDt = insurCtrtExpDt;
		this.rinsCtnt = rinsCtnt;
		this.insurPlcyYr = insurPlcyYr;
		this.cinsCtnt = cinsCtnt;
		this.lmtInsCurrCd = lmtInsCurrCd;
		this.updUsrId = updUsrId;
		this.insurTpCd = insurTpCd;
		this.lmtInsLoclAmt = lmtInsLoclAmt;
		this.lmtInsXchRt = lmtInsXchRt;
		this.insUsdAmt = insUsdAmt;
		this.insXchRt = insXchRt;
		this.cinsClmPtyNo = cinsClmPtyNo;
		this.creUsrId = creUsrId;
		this.subjMatInsDesc = subjMatInsDesc;
		this.insurCtnt = insurCtnt;
		this.insurClmPtyNo = insurClmPtyNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ins_ctnt", getInsCtnt());
		this.hashColumns.put("int_desc", getIntDesc());
		this.hashColumns.put("lmt_ins_usd_amt", getLmtInsUsdAmt());
		this.hashColumns.put("ins_clm_pty_no", getInsClmPtyNo());
		this.hashColumns.put("ins_curr_cd", getInsCurrCd());
		this.hashColumns.put("bro_clm_pty_no", getBroClmPtyNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("insur_ctrt_eff_dt", getInsurCtrtEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ins_locl_amt", getInsLoclAmt());
		this.hashColumns.put("rins_clm_pty_no", getRinsClmPtyNo());
		this.hashColumns.put("insur_rmk", getInsurRmk());
		this.hashColumns.put("insur_ctrt_exp_dt", getInsurCtrtExpDt());
		this.hashColumns.put("rins_ctnt", getRinsCtnt());
		this.hashColumns.put("insur_plcy_yr", getInsurPlcyYr());
		this.hashColumns.put("cins_ctnt", getCinsCtnt());
		this.hashColumns.put("lmt_ins_curr_cd", getLmtInsCurrCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("insur_tp_cd", getInsurTpCd());
		this.hashColumns.put("lmt_ins_locl_amt", getLmtInsLoclAmt());
		this.hashColumns.put("lmt_ins_xch_rt", getLmtInsXchRt());
		this.hashColumns.put("ins_usd_amt", getInsUsdAmt());
		this.hashColumns.put("ins_xch_rt", getInsXchRt());
		this.hashColumns.put("cins_clm_pty_no", getCinsClmPtyNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("subj_mat_ins_desc", getSubjMatInsDesc());
		this.hashColumns.put("insur_ctnt", getInsurCtnt());
		this.hashColumns.put("insur_clm_pty_no", getInsurClmPtyNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ins_ctnt", "insCtnt");
		this.hashFields.put("int_desc", "intDesc");
		this.hashFields.put("lmt_ins_usd_amt", "lmtInsUsdAmt");
		this.hashFields.put("ins_clm_pty_no", "insClmPtyNo");
		this.hashFields.put("ins_curr_cd", "insCurrCd");
		this.hashFields.put("bro_clm_pty_no", "broClmPtyNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("insur_ctrt_eff_dt", "insurCtrtEffDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ins_locl_amt", "insLoclAmt");
		this.hashFields.put("rins_clm_pty_no", "rinsClmPtyNo");
		this.hashFields.put("insur_rmk", "insurRmk");
		this.hashFields.put("insur_ctrt_exp_dt", "insurCtrtExpDt");
		this.hashFields.put("rins_ctnt", "rinsCtnt");
		this.hashFields.put("insur_plcy_yr", "insurPlcyYr");
		this.hashFields.put("cins_ctnt", "cinsCtnt");
		this.hashFields.put("lmt_ins_curr_cd", "lmtInsCurrCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("insur_tp_cd", "insurTpCd");
		this.hashFields.put("lmt_ins_locl_amt", "lmtInsLoclAmt");
		this.hashFields.put("lmt_ins_xch_rt", "lmtInsXchRt");
		this.hashFields.put("ins_usd_amt", "insUsdAmt");
		this.hashFields.put("ins_xch_rt", "insXchRt");
		this.hashFields.put("cins_clm_pty_no", "cinsClmPtyNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("subj_mat_ins_desc", "subjMatInsDesc");
		this.hashFields.put("insur_ctnt", "insurCtnt");
		this.hashFields.put("insur_clm_pty_no", "insurClmPtyNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return insCtnt
	 */
	public String getInsCtnt() {
		return this.insCtnt;
	}
	
	/**
	 * Column Info
	 * @return intDesc
	 */
	public String getIntDesc() {
		return this.intDesc;
	}
	
	/**
	 * Column Info
	 * @return lmtInsUsdAmt
	 */
	public String getLmtInsUsdAmt() {
		return this.lmtInsUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return insClmPtyNo
	 */
	public String getInsClmPtyNo() {
		return this.insClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return insCurrCd
	 */
	public String getInsCurrCd() {
		return this.insCurrCd;
	}
	
	/**
	 * Column Info
	 * @return broClmPtyNo
	 */
	public String getBroClmPtyNo() {
		return this.broClmPtyNo;
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
	 * @return insurCtrtEffDt
	 */
	public String getInsurCtrtEffDt() {
		return this.insurCtrtEffDt;
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
	 * @return insLoclAmt
	 */
	public String getInsLoclAmt() {
		return this.insLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return rinsClmPtyNo
	 */
	public String getRinsClmPtyNo() {
		return this.rinsClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return insurRmk
	 */
	public String getInsurRmk() {
		return this.insurRmk;
	}
	
	/**
	 * Column Info
	 * @return insurCtrtExpDt
	 */
	public String getInsurCtrtExpDt() {
		return this.insurCtrtExpDt;
	}
	
	/**
	 * Column Info
	 * @return rinsCtnt
	 */
	public String getRinsCtnt() {
		return this.rinsCtnt;
	}
	
	/**
	 * Column Info
	 * @return insurPlcyYr
	 */
	public String getInsurPlcyYr() {
		return this.insurPlcyYr;
	}
	
	/**
	 * Column Info
	 * @return cinsCtnt
	 */
	public String getCinsCtnt() {
		return this.cinsCtnt;
	}
	
	/**
	 * Column Info
	 * @return lmtInsCurrCd
	 */
	public String getLmtInsCurrCd() {
		return this.lmtInsCurrCd;
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
	 * @return insurTpCd
	 */
	public String getInsurTpCd() {
		return this.insurTpCd;
	}
	
	/**
	 * Column Info
	 * @return lmtInsLoclAmt
	 */
	public String getLmtInsLoclAmt() {
		return this.lmtInsLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return lmtInsXchRt
	 */
	public String getLmtInsXchRt() {
		return this.lmtInsXchRt;
	}
	
	/**
	 * Column Info
	 * @return insUsdAmt
	 */
	public String getInsUsdAmt() {
		return this.insUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return insXchRt
	 */
	public String getInsXchRt() {
		return this.insXchRt;
	}
	
	/**
	 * Column Info
	 * @return cinsClmPtyNo
	 */
	public String getCinsClmPtyNo() {
		return this.cinsClmPtyNo;
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
	 * @return subjMatInsDesc
	 */
	public String getSubjMatInsDesc() {
		return this.subjMatInsDesc;
	}
	
	/**
	 * Column Info
	 * @return insurCtnt
	 */
	public String getInsurCtnt() {
		return this.insurCtnt;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyNo
	 */
	public String getInsurClmPtyNo() {
		return this.insurClmPtyNo;
	}
	

	/**
	 * Column Info
	 * @param insCtnt
	 */
	public void setInsCtnt(String insCtnt) {
		this.insCtnt = insCtnt;
	}
	
	/**
	 * Column Info
	 * @param intDesc
	 */
	public void setIntDesc(String intDesc) {
		this.intDesc = intDesc;
	}
	
	/**
	 * Column Info
	 * @param lmtInsUsdAmt
	 */
	public void setLmtInsUsdAmt(String lmtInsUsdAmt) {
		this.lmtInsUsdAmt = lmtInsUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param insClmPtyNo
	 */
	public void setInsClmPtyNo(String insClmPtyNo) {
		this.insClmPtyNo = insClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param insCurrCd
	 */
	public void setInsCurrCd(String insCurrCd) {
		this.insCurrCd = insCurrCd;
	}
	
	/**
	 * Column Info
	 * @param broClmPtyNo
	 */
	public void setBroClmPtyNo(String broClmPtyNo) {
		this.broClmPtyNo = broClmPtyNo;
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
	 * @param insurCtrtEffDt
	 */
	public void setInsurCtrtEffDt(String insurCtrtEffDt) {
		this.insurCtrtEffDt = insurCtrtEffDt;
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
	 * @param insLoclAmt
	 */
	public void setInsLoclAmt(String insLoclAmt) {
		this.insLoclAmt = insLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param rinsClmPtyNo
	 */
	public void setRinsClmPtyNo(String rinsClmPtyNo) {
		this.rinsClmPtyNo = rinsClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param insurRmk
	 */
	public void setInsurRmk(String insurRmk) {
		this.insurRmk = insurRmk;
	}
	
	/**
	 * Column Info
	 * @param insurCtrtExpDt
	 */
	public void setInsurCtrtExpDt(String insurCtrtExpDt) {
		this.insurCtrtExpDt = insurCtrtExpDt;
	}
	
	/**
	 * Column Info
	 * @param rinsCtnt
	 */
	public void setRinsCtnt(String rinsCtnt) {
		this.rinsCtnt = rinsCtnt;
	}
	
	/**
	 * Column Info
	 * @param insurPlcyYr
	 */
	public void setInsurPlcyYr(String insurPlcyYr) {
		this.insurPlcyYr = insurPlcyYr;
	}
	
	/**
	 * Column Info
	 * @param cinsCtnt
	 */
	public void setCinsCtnt(String cinsCtnt) {
		this.cinsCtnt = cinsCtnt;
	}
	
	/**
	 * Column Info
	 * @param lmtInsCurrCd
	 */
	public void setLmtInsCurrCd(String lmtInsCurrCd) {
		this.lmtInsCurrCd = lmtInsCurrCd;
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
	 * @param insurTpCd
	 */
	public void setInsurTpCd(String insurTpCd) {
		this.insurTpCd = insurTpCd;
	}
	
	/**
	 * Column Info
	 * @param lmtInsLoclAmt
	 */
	public void setLmtInsLoclAmt(String lmtInsLoclAmt) {
		this.lmtInsLoclAmt = lmtInsLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param lmtInsXchRt
	 */
	public void setLmtInsXchRt(String lmtInsXchRt) {
		this.lmtInsXchRt = lmtInsXchRt;
	}
	
	/**
	 * Column Info
	 * @param insUsdAmt
	 */
	public void setInsUsdAmt(String insUsdAmt) {
		this.insUsdAmt = insUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param insXchRt
	 */
	public void setInsXchRt(String insXchRt) {
		this.insXchRt = insXchRt;
	}
	
	/**
	 * Column Info
	 * @param cinsClmPtyNo
	 */
	public void setCinsClmPtyNo(String cinsClmPtyNo) {
		this.cinsClmPtyNo = cinsClmPtyNo;
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
	 * @param subjMatInsDesc
	 */
	public void setSubjMatInsDesc(String subjMatInsDesc) {
		this.subjMatInsDesc = subjMatInsDesc;
	}
	
	/**
	 * Column Info
	 * @param insurCtnt
	 */
	public void setInsurCtnt(String insurCtnt) {
		this.insurCtnt = insurCtnt;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyNo
	 */
	public void setInsurClmPtyNo(String insurClmPtyNo) {
		this.insurClmPtyNo = insurClmPtyNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInsCtnt(JSPUtil.getParameter(request, "ins_ctnt", ""));
		setIntDesc(JSPUtil.getParameter(request, "int_desc", ""));
		setLmtInsUsdAmt(JSPUtil.getParameter(request, "lmt_ins_usd_amt", ""));
		setInsClmPtyNo(JSPUtil.getParameter(request, "ins_clm_pty_no", ""));
		setInsCurrCd(JSPUtil.getParameter(request, "ins_curr_cd", ""));
		setBroClmPtyNo(JSPUtil.getParameter(request, "bro_clm_pty_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInsurCtrtEffDt(JSPUtil.getParameter(request, "insur_ctrt_eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInsLoclAmt(JSPUtil.getParameter(request, "ins_locl_amt", ""));
		setRinsClmPtyNo(JSPUtil.getParameter(request, "rins_clm_pty_no", ""));
		setInsurRmk(JSPUtil.getParameter(request, "insur_rmk", ""));
		setInsurCtrtExpDt(JSPUtil.getParameter(request, "insur_ctrt_exp_dt", ""));
		setRinsCtnt(JSPUtil.getParameter(request, "rins_ctnt", ""));
		setInsurPlcyYr(JSPUtil.getParameter(request, "insur_plcy_yr", ""));
		setCinsCtnt(JSPUtil.getParameter(request, "cins_ctnt", ""));
		setLmtInsCurrCd(JSPUtil.getParameter(request, "lmt_ins_curr_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setInsurTpCd(JSPUtil.getParameter(request, "insur_tp_cd", ""));
		setLmtInsLoclAmt(JSPUtil.getParameter(request, "lmt_ins_locl_amt", ""));
		setLmtInsXchRt(JSPUtil.getParameter(request, "lmt_ins_xch_rt", ""));
		setInsUsdAmt(JSPUtil.getParameter(request, "ins_usd_amt", ""));
		setInsXchRt(JSPUtil.getParameter(request, "ins_xch_rt", ""));
		setCinsClmPtyNo(JSPUtil.getParameter(request, "cins_clm_pty_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSubjMatInsDesc(JSPUtil.getParameter(request, "subj_mat_ins_desc", ""));
		setInsurCtnt(JSPUtil.getParameter(request, "insur_ctnt", ""));
		setInsurClmPtyNo(JSPUtil.getParameter(request, "insur_clm_pty_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomInsuranceVO[]
	 */
	public CustomInsuranceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomInsuranceVO[]
	 */
	public CustomInsuranceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomInsuranceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] insCtnt = (JSPUtil.getParameter(request, prefix	+ "ins_ctnt", length));
			String[] intDesc = (JSPUtil.getParameter(request, prefix	+ "int_desc", length));
			String[] lmtInsUsdAmt = (JSPUtil.getParameter(request, prefix	+ "lmt_ins_usd_amt", length));
			String[] insClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "ins_clm_pty_no", length));
			String[] insCurrCd = (JSPUtil.getParameter(request, prefix	+ "ins_curr_cd", length));
			String[] broClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "bro_clm_pty_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] insurCtrtEffDt = (JSPUtil.getParameter(request, prefix	+ "insur_ctrt_eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] insLoclAmt = (JSPUtil.getParameter(request, prefix	+ "ins_locl_amt", length));
			String[] rinsClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "rins_clm_pty_no", length));
			String[] insurRmk = (JSPUtil.getParameter(request, prefix	+ "insur_rmk", length));
			String[] insurCtrtExpDt = (JSPUtil.getParameter(request, prefix	+ "insur_ctrt_exp_dt", length));
			String[] rinsCtnt = (JSPUtil.getParameter(request, prefix	+ "rins_ctnt", length));
			String[] insurPlcyYr = (JSPUtil.getParameter(request, prefix	+ "insur_plcy_yr", length));
			String[] cinsCtnt = (JSPUtil.getParameter(request, prefix	+ "cins_ctnt", length));
			String[] lmtInsCurrCd = (JSPUtil.getParameter(request, prefix	+ "lmt_ins_curr_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] insurTpCd = (JSPUtil.getParameter(request, prefix	+ "insur_tp_cd", length));
			String[] lmtInsLoclAmt = (JSPUtil.getParameter(request, prefix	+ "lmt_ins_locl_amt", length));
			String[] lmtInsXchRt = (JSPUtil.getParameter(request, prefix	+ "lmt_ins_xch_rt", length));
			String[] insUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ins_usd_amt", length));
			String[] insXchRt = (JSPUtil.getParameter(request, prefix	+ "ins_xch_rt", length));
			String[] cinsClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "cins_clm_pty_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] subjMatInsDesc = (JSPUtil.getParameter(request, prefix	+ "subj_mat_ins_desc", length));
			String[] insurCtnt = (JSPUtil.getParameter(request, prefix	+ "insur_ctnt", length));
			String[] insurClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomInsuranceVO();
				if (insCtnt[i] != null)
					model.setInsCtnt(insCtnt[i]);
				if (intDesc[i] != null)
					model.setIntDesc(intDesc[i]);
				if (lmtInsUsdAmt[i] != null)
					model.setLmtInsUsdAmt(lmtInsUsdAmt[i]);
				if (insClmPtyNo[i] != null)
					model.setInsClmPtyNo(insClmPtyNo[i]);
				if (insCurrCd[i] != null)
					model.setInsCurrCd(insCurrCd[i]);
				if (broClmPtyNo[i] != null)
					model.setBroClmPtyNo(broClmPtyNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (insurCtrtEffDt[i] != null)
					model.setInsurCtrtEffDt(insurCtrtEffDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (insLoclAmt[i] != null)
					model.setInsLoclAmt(insLoclAmt[i]);
				if (rinsClmPtyNo[i] != null)
					model.setRinsClmPtyNo(rinsClmPtyNo[i]);
				if (insurRmk[i] != null)
					model.setInsurRmk(insurRmk[i]);
				if (insurCtrtExpDt[i] != null)
					model.setInsurCtrtExpDt(insurCtrtExpDt[i]);
				if (rinsCtnt[i] != null)
					model.setRinsCtnt(rinsCtnt[i]);
				if (insurPlcyYr[i] != null)
					model.setInsurPlcyYr(insurPlcyYr[i]);
				if (cinsCtnt[i] != null)
					model.setCinsCtnt(cinsCtnt[i]);
				if (lmtInsCurrCd[i] != null)
					model.setLmtInsCurrCd(lmtInsCurrCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (insurTpCd[i] != null)
					model.setInsurTpCd(insurTpCd[i]);
				if (lmtInsLoclAmt[i] != null)
					model.setLmtInsLoclAmt(lmtInsLoclAmt[i]);
				if (lmtInsXchRt[i] != null)
					model.setLmtInsXchRt(lmtInsXchRt[i]);
				if (insUsdAmt[i] != null)
					model.setInsUsdAmt(insUsdAmt[i]);
				if (insXchRt[i] != null)
					model.setInsXchRt(insXchRt[i]);
				if (cinsClmPtyNo[i] != null)
					model.setCinsClmPtyNo(cinsClmPtyNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (subjMatInsDesc[i] != null)
					model.setSubjMatInsDesc(subjMatInsDesc[i]);
				if (insurCtnt[i] != null)
					model.setInsurCtnt(insurCtnt[i]);
				if (insurClmPtyNo[i] != null)
					model.setInsurClmPtyNo(insurClmPtyNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomInsuranceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomInsuranceVO[]
	 */
	public CustomInsuranceVO[] getCustomInsuranceVOs(){
		CustomInsuranceVO[] vos = (CustomInsuranceVO[])models.toArray(new CustomInsuranceVO[models.size()]);
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
		this.insCtnt = this.insCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intDesc = this.intDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtInsUsdAmt = this.lmtInsUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insClmPtyNo = this.insClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insCurrCd = this.insCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.broClmPtyNo = this.broClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurCtrtEffDt = this.insurCtrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insLoclAmt = this.insLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rinsClmPtyNo = this.rinsClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRmk = this.insurRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurCtrtExpDt = this.insurCtrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rinsCtnt = this.rinsCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurPlcyYr = this.insurPlcyYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cinsCtnt = this.cinsCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtInsCurrCd = this.lmtInsCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurTpCd = this.insurTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtInsLoclAmt = this.lmtInsLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtInsXchRt = this.lmtInsXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insUsdAmt = this.insUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insXchRt = this.insXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cinsClmPtyNo = this.cinsClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subjMatInsDesc = this.subjMatInsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurCtnt = this.insurCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNo = this.insurClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
