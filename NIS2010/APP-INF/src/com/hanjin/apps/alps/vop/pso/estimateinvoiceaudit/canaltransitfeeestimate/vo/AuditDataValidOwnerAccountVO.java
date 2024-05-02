/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AuditDataValidOwnerAccountVO.java
*@FileTitle : AuditDataValidOwnerAccountVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.01
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.11.19 김진일 
* 1.0 Creation
* 
* History
* 2012.02.01 진마리아 CHM-201215859-01 전도금 비용 수정 기능 추가 요청건(spp로부터 입력받는 전도금을 alps 화면을 통해 수정하여 저장 가능하도록)
=========================================================*/

package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo;

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
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AuditDataValidOwnerAccountVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AuditDataValidOwnerAccountVO> models = new ArrayList<AuditDataValidOwnerAccountVO>();
	
	/* Column Info */
	private String rqstAmt = null;
	/* Column Info */
	private String callSeq = null;
	/* Column Info */
	private String cnlTzBztpCd = null;
	/* Column Info */
	private String credits = null;
	/* Column Info */
	private String formlDesc = null;
	/* Column Info */
	private String rqstAmtSum = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dfltXprDesc = null;
	/* Column Info */
	private String ydChgVerSeq = null;
	/* Column Info */
	private String ydChgNo = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sysXprDesc = null;
	/* Column Info */
	private String calcAmt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String xprDesc = null;
	/* Column Info */
	private String calcAmtSum = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String orgRqstAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AuditDataValidOwnerAccountVO() {}

	public AuditDataValidOwnerAccountVO(String ibflag, String pagerows, String vndrSeq, String vvd, String callSeq, String cnlTzBztpCd, String invNo, String lgsCostCd, String calcAmt, String rqstAmt, String rqstAmtSum, String calcAmtSum, String xprDesc, String formlDesc, String dfltXprDesc, String sysXprDesc, String ydChgNo, String ydChgVerSeq, String ydCd, String creUsrId, String updUsrId, String ofcCd, String dueDt, String credits, String diffRmk, String revYrmon, String orgRqstAmt) {
		this.rqstAmt = rqstAmt;
		this.callSeq = callSeq;
		this.cnlTzBztpCd = cnlTzBztpCd;
		this.credits = credits;
		this.formlDesc = formlDesc;
		this.rqstAmtSum = rqstAmtSum;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.dfltXprDesc = dfltXprDesc;
		this.ydChgVerSeq = ydChgVerSeq;
		this.ydChgNo = ydChgNo;
		this.dueDt = dueDt;
		this.updUsrId = updUsrId;
		this.sysXprDesc = sysXprDesc;
		this.calcAmt = calcAmt;
		this.invNo = invNo;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.diffRmk = diffRmk;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.lgsCostCd = lgsCostCd;
		this.xprDesc = xprDesc;
		this.calcAmtSum = calcAmtSum;
		this.revYrmon = revYrmon;
		this.orgRqstAmt = orgRqstAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_amt", getRqstAmt());
		this.hashColumns.put("call_seq", getCallSeq());
		this.hashColumns.put("cnl_tz_bztp_cd", getCnlTzBztpCd());
		this.hashColumns.put("credits", getCredits());
		this.hashColumns.put("forml_desc", getFormlDesc());
		this.hashColumns.put("rqst_amt_sum", getRqstAmtSum());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dflt_xpr_desc", getDfltXprDesc());
		this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
		this.hashColumns.put("yd_chg_no", getYdChgNo());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sys_xpr_desc", getSysXprDesc());
		this.hashColumns.put("calc_amt", getCalcAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("xpr_desc", getXprDesc());
		this.hashColumns.put("calc_amt_sum", getCalcAmtSum());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("org_rqst_amt", getOrgRqstAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_amt", "rqstAmt");
		this.hashFields.put("call_seq", "callSeq");
		this.hashFields.put("cnl_tz_bztp_cd", "cnlTzBztpCd");
		this.hashFields.put("credits", "credits");
		this.hashFields.put("forml_desc", "formlDesc");
		this.hashFields.put("rqst_amt_sum", "rqstAmtSum");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dflt_xpr_desc", "dfltXprDesc");
		this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
		this.hashFields.put("yd_chg_no", "ydChgNo");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sys_xpr_desc", "sysXprDesc");
		this.hashFields.put("calc_amt", "calcAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("xpr_desc", "xprDesc");
		this.hashFields.put("calc_amt_sum", "calcAmtSum");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("org_rqst_amt", "orgRqstAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rqstAmt
	 */
	public String getRqstAmt() {
		return this.rqstAmt;
	}
	
	/**
	 * Column Info
	 * @return callSeq
	 */
	public String getCallSeq() {
		return this.callSeq;
	}
	
	/**
	 * Column Info
	 * @return cnlTzBztpCd
	 */
	public String getCnlTzBztpCd() {
		return this.cnlTzBztpCd;
	}
	
	/**
	 * Column Info
	 * @return credits
	 */
	public String getCredits() {
		return this.credits;
	}
	
	/**
	 * Column Info
	 * @return formlDesc
	 */
	public String getFormlDesc() {
		return this.formlDesc;
	}
	
	/**
	 * Column Info
	 * @return rqstAmtSum
	 */
	public String getRqstAmtSum() {
		return this.rqstAmtSum;
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
	 * @return dfltXprDesc
	 */
	public String getDfltXprDesc() {
		return this.dfltXprDesc;
	}
	
	/**
	 * Column Info
	 * @return ydChgVerSeq
	 */
	public String getYdChgVerSeq() {
		return this.ydChgVerSeq;
	}
	
	/**
	 * Column Info
	 * @return ydChgNo
	 */
	public String getYdChgNo() {
		return this.ydChgNo;
	}
	
	/**
	 * Column Info
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
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
	 * @return sysXprDesc
	 */
	public String getSysXprDesc() {
		return this.sysXprDesc;
	}
	
	/**
	 * Column Info
	 * @return calcAmt
	 */
	public String getCalcAmt() {
		return this.calcAmt;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return xprDesc
	 */
	public String getXprDesc() {
		return this.xprDesc;
	}
	
	/**
	 * Column Info
	 * @return calcAmtSum
	 */
	public String getCalcAmtSum() {
		return this.calcAmtSum;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return orgRqstAmt
	 */
	public String getOrgRqstAmt() {
		return this.orgRqstAmt;
	}

	/**
	 * Column Info
	 * @param rqstAmt
	 */
	public void setRqstAmt(String rqstAmt) {
		this.rqstAmt = rqstAmt;
	}
	
	/**
	 * Column Info
	 * @param callSeq
	 */
	public void setCallSeq(String callSeq) {
		this.callSeq = callSeq;
	}
	
	/**
	 * Column Info
	 * @param cnlTzBztpCd
	 */
	public void setCnlTzBztpCd(String cnlTzBztpCd) {
		this.cnlTzBztpCd = cnlTzBztpCd;
	}
	
	/**
	 * Column Info
	 * @param credits
	 */
	public void setCredits(String credits) {
		this.credits = credits;
	}
	
	/**
	 * Column Info
	 * @param formlDesc
	 */
	public void setFormlDesc(String formlDesc) {
		this.formlDesc = formlDesc;
	}
	
	/**
	 * Column Info
	 * @param rqstAmtSum
	 */
	public void setRqstAmtSum(String rqstAmtSum) {
		this.rqstAmtSum = rqstAmtSum;
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
	 * @param dfltXprDesc
	 */
	public void setDfltXprDesc(String dfltXprDesc) {
		this.dfltXprDesc = dfltXprDesc;
	}
	
	/**
	 * Column Info
	 * @param ydChgVerSeq
	 */
	public void setYdChgVerSeq(String ydChgVerSeq) {
		this.ydChgVerSeq = ydChgVerSeq;
	}
	
	/**
	 * Column Info
	 * @param ydChgNo
	 */
	public void setYdChgNo(String ydChgNo) {
		this.ydChgNo = ydChgNo;
	}
	
	/**
	 * Column Info
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
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
	 * @param sysXprDesc
	 */
	public void setSysXprDesc(String sysXprDesc) {
		this.sysXprDesc = sysXprDesc;
	}
	
	/**
	 * Column Info
	 * @param calcAmt
	 */
	public void setCalcAmt(String calcAmt) {
		this.calcAmt = calcAmt;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param xprDesc
	 */
	public void setXprDesc(String xprDesc) {
		this.xprDesc = xprDesc;
	}
	
	/**
	 * Column Info
	 * @param calcAmtSum
	 */
	public void setCalcAmtSum(String calcAmtSum) {
		this.calcAmtSum = calcAmtSum;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param orgRqstAmt
	 */
	public void setOrgRqstAmt(String orgRqstAmt) {
		this.orgRqstAmt = orgRqstAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRqstAmt(JSPUtil.getParameter(request, "rqst_amt", ""));
		setCallSeq(JSPUtil.getParameter(request, "call_seq", ""));
		setCnlTzBztpCd(JSPUtil.getParameter(request, "cnl_tz_bztp_cd", ""));
		setCredits(JSPUtil.getParameter(request, "credits", ""));
		setFormlDesc(JSPUtil.getParameter(request, "forml_desc", ""));
		setRqstAmtSum(JSPUtil.getParameter(request, "rqst_amt_sum", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDfltXprDesc(JSPUtil.getParameter(request, "dflt_xpr_desc", ""));
		setYdChgVerSeq(JSPUtil.getParameter(request, "yd_chg_ver_seq", ""));
		setYdChgNo(JSPUtil.getParameter(request, "yd_chg_no", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSysXprDesc(JSPUtil.getParameter(request, "sys_xpr_desc", ""));
		setCalcAmt(JSPUtil.getParameter(request, "calc_amt", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setLgsCostCd(JSPUtil.getParameter(request, "lgs_cost_cd", ""));
		setXprDesc(JSPUtil.getParameter(request, "xpr_desc", ""));
		setCalcAmtSum(JSPUtil.getParameter(request, "calc_amt_sum", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setOrgRqstAmt(JSPUtil.getParameter(request, "org_rqst_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AuditDataValidOwnerAccountVO[]
	 */
	public AuditDataValidOwnerAccountVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AuditDataValidOwnerAccountVO[]
	 */
	public AuditDataValidOwnerAccountVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AuditDataValidOwnerAccountVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_amt", length));
			String[] callSeq = (JSPUtil.getParameter(request, prefix	+ "call_seq", length));
			String[] cnlTzBztpCd = (JSPUtil.getParameter(request, prefix	+ "cnl_tz_bztp_cd", length));
			String[] credits = (JSPUtil.getParameter(request, prefix	+ "credits", length));
			String[] formlDesc = (JSPUtil.getParameter(request, prefix	+ "forml_desc", length));
			String[] rqstAmtSum = (JSPUtil.getParameter(request, prefix	+ "rqst_amt_sum", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dfltXprDesc = (JSPUtil.getParameter(request, prefix	+ "dflt_xpr_desc", length));
			String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix	+ "yd_chg_ver_seq", length));
			String[] ydChgNo = (JSPUtil.getParameter(request, prefix	+ "yd_chg_no", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] sysXprDesc = (JSPUtil.getParameter(request, prefix	+ "sys_xpr_desc", length));
			String[] calcAmt = (JSPUtil.getParameter(request, prefix	+ "calc_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] xprDesc = (JSPUtil.getParameter(request, prefix	+ "xpr_desc", length));
			String[] calcAmtSum = (JSPUtil.getParameter(request, prefix	+ "calc_amt_sum", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] orgRqstAmt = (JSPUtil.getParameter(request, prefix	+ "org_rqst_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new AuditDataValidOwnerAccountVO();
				if (rqstAmt[i] != null)
					model.setRqstAmt(rqstAmt[i]);
				if (callSeq[i] != null)
					model.setCallSeq(callSeq[i]);
				if (cnlTzBztpCd[i] != null)
					model.setCnlTzBztpCd(cnlTzBztpCd[i]);
				if (credits[i] != null)
					model.setCredits(credits[i]);
				if (formlDesc[i] != null)
					model.setFormlDesc(formlDesc[i]);
				if (rqstAmtSum[i] != null)
					model.setRqstAmtSum(rqstAmtSum[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dfltXprDesc[i] != null)
					model.setDfltXprDesc(dfltXprDesc[i]);
				if (ydChgVerSeq[i] != null)
					model.setYdChgVerSeq(ydChgVerSeq[i]);
				if (ydChgNo[i] != null)
					model.setYdChgNo(ydChgNo[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sysXprDesc[i] != null)
					model.setSysXprDesc(sysXprDesc[i]);
				if (calcAmt[i] != null)
					model.setCalcAmt(calcAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (xprDesc[i] != null)
					model.setXprDesc(xprDesc[i]);
				if (calcAmtSum[i] != null)
					model.setCalcAmtSum(calcAmtSum[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (orgRqstAmt[i] != null)
					model.setOrgRqstAmt(orgRqstAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAuditDataValidOwnerAccountVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AuditDataValidOwnerAccountVO[]
	 */
	public AuditDataValidOwnerAccountVO[] getAuditDataValidOwnerAccountVOs(){
		AuditDataValidOwnerAccountVO[] vos = (AuditDataValidOwnerAccountVO[])models.toArray(new AuditDataValidOwnerAccountVO[models.size()]);
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
		this.rqstAmt = this.rqstAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSeq = this.callSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzBztpCd = this.cnlTzBztpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.credits = this.credits .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formlDesc = this.formlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstAmtSum = this.rqstAmtSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltXprDesc = this.dfltXprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgVerSeq = this.ydChgVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgNo = this.ydChgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysXprDesc = this.sysXprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcAmt = this.calcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xprDesc = this.xprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcAmtSum = this.calcAmtSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRqstAmt = this.orgRqstAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
