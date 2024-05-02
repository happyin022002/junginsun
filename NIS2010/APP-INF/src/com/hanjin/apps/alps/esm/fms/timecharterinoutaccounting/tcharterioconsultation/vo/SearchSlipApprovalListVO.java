/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchSlipApprovalListVO.java
*@FileTitle : SearchSlipApprovalListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.16
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.02.16 김영오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

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
 * @author 김영오 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSlipApprovalListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSlipApprovalListVO> models = new ArrayList<SearchSlipApprovalListVO>();
	
	/* Column Info */
	private String rqstAmt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String fletCtrtTpCd = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String interCoCd = null;
	/* Column Info */
	private String evidTp = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String slipType = null;
	/* Column Info */
	private String diffDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String requestTeam = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String cxlDesc = null;
	/* Column Info */
	private String ownrCd = null;
	/* Column Info */
	private String deduction = null;
	/* Column Info */
	private String aproFlg = null;
	/* Column Info */
	private String arInterCoCd = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String producedBy = null;
	/* Column Info */
	private String csrDt = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String ownrNm = null;
	/* Column Info */
	private String lstAproFlg = null;	
	/* Column Info */
	private String aproRqstNo = null;
	/* Column Info */
	private String aproRqstSeq = null;
	/* Column Info */
	private String urgPayYn = null;		
	/* Column Info */
	private String rqstAproStepFlg = null;
	/* Column Info */
	private String payDt = null;
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSlipApprovalListVO() {}

	public SearchSlipApprovalListVO(String ibflag, String pagerows, String rqstAmt, String vslCd, String csrNo, String rqstDt, String producedBy, String fletCtrtTpCd, String cxlFlg, String csrDt, String csrCurrCd, String csrDesc, String evidTp, String slipType, String diffDesc, String requestTeam, String vslEngNm, String cxlDesc, String ownrCd, String deduction, String csrAmt, String ownrNm, String aproFlg, String interCoCd, String arInterCoCd, String lstAproFlg, String aproRqstNo, String aproRqstSeq, String urgPayYn, String rqstAproStepFlg, String payDt) {
		this.rqstAmt = rqstAmt;
		this.vslCd = vslCd;
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.csrDesc = csrDesc;
		this.csrCurrCd = csrCurrCd;
		this.cxlFlg = cxlFlg;
		this.interCoCd = interCoCd;
		this.evidTp = evidTp;
		this.pagerows = pagerows;
		this.slipType = slipType;
		this.diffDesc = diffDesc;
		this.ibflag = ibflag;
		this.requestTeam = requestTeam;
		this.vslEngNm = vslEngNm;
		this.cxlDesc = cxlDesc;
		this.ownrCd = ownrCd;
		this.deduction = deduction;
		this.aproFlg = aproFlg;
		this.arInterCoCd = arInterCoCd;
		this.rqstDt = rqstDt;
		this.csrNo = csrNo;
		this.producedBy = producedBy;
		this.csrDt = csrDt;
		this.csrAmt = csrAmt;
		this.ownrNm = ownrNm;
		this.lstAproFlg = lstAproFlg;
		this.aproRqstNo = aproRqstNo;
		this.aproRqstSeq = aproRqstSeq;
		this.urgPayYn = urgPayYn;
		this.rqstAproStepFlg = rqstAproStepFlg;		
		this.payDt = payDt;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_amt", getRqstAmt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("inter_co_cd", getInterCoCd());
		this.hashColumns.put("evid_tp", getEvidTp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("slip_type", getSlipType());
		this.hashColumns.put("diff_desc", getDiffDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("request_team", getRequestTeam());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("cxl_desc", getCxlDesc());
		this.hashColumns.put("ownr_cd", getOwnrCd());
		this.hashColumns.put("deduction", getDeduction());
		this.hashColumns.put("apro_flg", getAproFlg());
		this.hashColumns.put("ar_inter_co_cd", getArInterCoCd());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("produced_by", getProducedBy());
		this.hashColumns.put("csr_dt", getCsrDt());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("lst_apro_flg", getLstAproFlg());		
		this.hashColumns.put("apro_rqst_no",getAproRqstNo());
		this.hashColumns.put("apro_rqst_seq",getAproRqstSeq());
		this.hashColumns.put("urg_pay_yn",getUrgPayYn());
		this.hashColumns.put("rqst_apro_step_flg",getRqstAproStepFlg());	
		this.hashColumns.put("pay_dt", getPayDt());
		
		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_amt", "rqstAmt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("inter_co_cd", "interCoCd");
		this.hashFields.put("evid_tp", "evidTp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("slip_type", "slipType");
		this.hashFields.put("diff_desc", "diffDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("request_team", "requestTeam");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("cxl_desc", "cxlDesc");
		this.hashFields.put("ownr_cd", "ownrCd");
		this.hashFields.put("deduction", "deduction");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("ar_inter_co_cd", "arInterCoCd");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("produced_by", "producedBy");
		this.hashFields.put("csr_dt", "csrDt");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("lst_apro_flg", "lstAproFlg");		
		this.hashFields.put("apro_rqst_no", "aproRqstNo");
		this.hashFields.put("apro_rqst_seq", "aproRqstSeq");		
		this.hashFields.put("urg_pay_yn", "urgPayYn");
		this.hashFields.put("rqst_apro_step_flg", "rqstAproStepFlg");	
		this.hashFields.put("pay_dt", "payDt");
		
				
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return fletCtrtTpCd
	 */
	public String getFletCtrtTpCd() {
		return this.fletCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return csrDesc
	 */
	public String getCsrDesc() {
		return this.csrDesc;
	}
	
	/**
	 * Column Info
	 * @return csrCurrCd
	 */
	public String getCsrCurrCd() {
		return this.csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @return cxlFlg
	 */
	public String getCxlFlg() {
		return this.cxlFlg;
	}
	
	/**
	 * Column Info
	 * @return interCoCd
	 */
	public String getInterCoCd() {
		return this.interCoCd;
	}
	
	/**
	 * Column Info
	 * @return evidTp
	 */
	public String getEvidTp() {
		return this.evidTp;
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
	 * @return slipType
	 */
	public String getSlipType() {
		return this.slipType;
	}
	
	/**
	 * Column Info
	 * @return diffDesc
	 */
	public String getDiffDesc() {
		return this.diffDesc;
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
	 * @return requestTeam
	 */
	public String getRequestTeam() {
		return this.requestTeam;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return cxlDesc
	 */
	public String getCxlDesc() {
		return this.cxlDesc;
	}
	
	/**
	 * Column Info
	 * @return ownrCd
	 */
	public String getOwnrCd() {
		return this.ownrCd;
	}
	
	/**
	 * Column Info
	 * @return deduction
	 */
	public String getDeduction() {
		return this.deduction;
	}
	
	/**
	 * Column Info
	 * @return aproFlg
	 */
	public String getAproFlg() {
		return this.aproFlg;
	}
	
	/**
	 * Column Info
	 * @return arInterCoCd
	 */
	public String getArInterCoCd() {
		return this.arInterCoCd;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return producedBy
	 */
	public String getProducedBy() {
		return this.producedBy;
	}
	
	/**
	 * Column Info
	 * @return csrDt
	 */
	public String getCsrDt() {
		return this.csrDt;
	}
	
	/**
	 * Column Info
	 * @return csrAmt
	 */
	public String getCsrAmt() {
		return this.csrAmt;
	}
	
	/**
	 * Column Info
	 * @return ownrNm
	 */
	public String getOwnrNm() {
		return this.ownrNm;
	}
	
	/**
	 * Column Info
	 * @return lstAproFlg
	 */
	public String getLstAproFlg() {
		return this.lstAproFlg;
	}
	
	/**
	 * Column Info
	 * @return aproRqstNo
	 */
	public String getAproRqstNo() {
		return this.aproRqstNo;
	}

	/**
	 * Column Info
	 * @return aproRqstSeq
	 */
	public String getAproRqstSeq() {
		return this.aproRqstSeq;
	}

	/**
	 * Column Info
	 * @return urgPayYn
	 */
	public String getUrgPayYn() {
		return this.urgPayYn;
	}	

	/**
	 * Column Info
	 * @return rqstAproStepFlg
	 */
	public String getRqstAproStepFlg() {
		return this.rqstAproStepFlg;
	}	

	/**
	 * Column Info
	 * @return payDt
	 */
	public String getPayDt() {
		return this.payDt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param fletCtrtTpCd
	 */
	public void setFletCtrtTpCd(String fletCtrtTpCd) {
		this.fletCtrtTpCd = fletCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param csrDesc
	 */
	public void setCsrDesc(String csrDesc) {
		this.csrDesc = csrDesc;
	}
	
	/**
	 * Column Info
	 * @param csrCurrCd
	 */
	public void setCsrCurrCd(String csrCurrCd) {
		this.csrCurrCd = csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @param cxlFlg
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
	}
	
	/**
	 * Column Info
	 * @param interCoCd
	 */
	public void setInterCoCd(String interCoCd) {
		this.interCoCd = interCoCd;
	}
	
	/**
	 * Column Info
	 * @param evidTp
	 */
	public void setEvidTp(String evidTp) {
		this.evidTp = evidTp;
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
	 * @param slipType
	 */
	public void setSlipType(String slipType) {
		this.slipType = slipType;
	}
	
	/**
	 * Column Info
	 * @param diffDesc
	 */
	public void setDiffDesc(String diffDesc) {
		this.diffDesc = diffDesc;
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
	 * @param requestTeam
	 */
	public void setRequestTeam(String requestTeam) {
		this.requestTeam = requestTeam;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param cxlDesc
	 */
	public void setCxlDesc(String cxlDesc) {
		this.cxlDesc = cxlDesc;
	}
	
	/**
	 * Column Info
	 * @param ownrCd
	 */
	public void setOwnrCd(String ownrCd) {
		this.ownrCd = ownrCd;
	}
	
	/**
	 * Column Info
	 * @param deduction
	 */
	public void setDeduction(String deduction) {
		this.deduction = deduction;
	}
	
	/**
	 * Column Info
	 * @param aproFlg
	 */
	public void setAproFlg(String aproFlg) {
		this.aproFlg = aproFlg;
	}
	
	/**
	 * Column Info
	 * @param arInterCoCd
	 */
	public void setArInterCoCd(String arInterCoCd) {
		this.arInterCoCd = arInterCoCd;
	}
	
	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param producedBy
	 */
	public void setProducedBy(String producedBy) {
		this.producedBy = producedBy;
	}
	
	/**
	 * Column Info
	 * @param csrDt
	 */
	public void setCsrDt(String csrDt) {
		this.csrDt = csrDt;
	}
	
	/**
	 * Column Info
	 * @param csrAmt
	 */
	public void setCsrAmt(String csrAmt) {
		this.csrAmt = csrAmt;
	}
	
	/**
	 * Column Info
	 * @param ownrNm
	 */
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
	}
	
	/**
	 * Column Info
	 * @param lstAproFlg
	 */
	public void setLstAproFlg(String lstAproFlg) {
		this.lstAproFlg = lstAproFlg;
	}
	
	/**
	 * Column Info
	 * @param aproRqstNo
	 */
	public void setAproRqstNo(String aproRqstNo) {
		this.aproRqstNo = aproRqstNo;
	}

	/**
	 * Column Info
	 * @param aproRqstSeq
	 */
	public void setAproRqstSeq(String aproRqstSeq) {
		this.aproRqstSeq = aproRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param urgPayYn
	 */
	public void setUrgPayYn(String urgPayYn) {
		this.urgPayYn = urgPayYn;
	}	

	/**
	 * Column Info
	 * @param rqstAproStepFlg
	 */
	public void setRqstAproStepFlg(String rqstAproStepFlg) {
		this.rqstAproStepFlg = rqstAproStepFlg;
	}	

	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}
	
	/**
	 * Column Info
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setRqstAmt(JSPUtil.getParameter(request, prefix + "rqst_amt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_cd", ""));
		setCsrDesc(JSPUtil.getParameter(request, prefix + "csr_desc", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, prefix + "csr_curr_cd", ""));
		setCxlFlg(JSPUtil.getParameter(request, prefix + "cxl_flg", ""));
		setInterCoCd(JSPUtil.getParameter(request, prefix + "inter_co_cd", ""));
		setEvidTp(JSPUtil.getParameter(request, prefix + "evid_tp", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSlipType(JSPUtil.getParameter(request, prefix + "slip_type", ""));
		setDiffDesc(JSPUtil.getParameter(request, prefix + "diff_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRequestTeam(JSPUtil.getParameter(request, prefix + "request_team", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setCxlDesc(JSPUtil.getParameter(request, prefix + "cxl_desc", ""));
		setOwnrCd(JSPUtil.getParameter(request, prefix + "ownr_cd", ""));
		setDeduction(JSPUtil.getParameter(request, prefix + "deduction", ""));
		setAproFlg(JSPUtil.getParameter(request, prefix + "apro_flg", ""));
		setArInterCoCd(JSPUtil.getParameter(request, prefix + "ar_inter_co_cd", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setProducedBy(JSPUtil.getParameter(request, prefix + "produced_by", ""));
		setCsrDt(JSPUtil.getParameter(request, prefix + "csr_dt", ""));
		setCsrAmt(JSPUtil.getParameter(request, prefix + "csr_amt", ""));
		setOwnrNm(JSPUtil.getParameter(request, prefix + "ownr_nm", ""));
		setLstAproFlg(JSPUtil.getParameter(request, prefix + "lst_apro_flg", ""));	
		setAproRqstNo(JSPUtil.getParameter(request, prefix + "apro_rqst_no", ""));
		setAproRqstSeq(JSPUtil.getParameter(request, prefix + "apro_rqst_seq", ""));		
		setUrgPayYn(JSPUtil.getParameter(request, prefix + "urg_pay_yn", ""));		
		setRqstAproStepFlg(JSPUtil.getParameter(request, prefix + "rqst_apro_step_flg", ""));	
		setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSlipApprovalListVO[]
	 */
	public SearchSlipApprovalListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSlipApprovalListVO[]
	 */
	public SearchSlipApprovalListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSlipApprovalListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_amt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_tp_cd", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] interCoCd = (JSPUtil.getParameter(request, prefix	+ "inter_co_cd", length));
			String[] evidTp = (JSPUtil.getParameter(request, prefix	+ "evid_tp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] slipType = (JSPUtil.getParameter(request, prefix	+ "slip_type", length));
			String[] diffDesc = (JSPUtil.getParameter(request, prefix	+ "diff_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] requestTeam = (JSPUtil.getParameter(request, prefix	+ "request_team", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] cxlDesc = (JSPUtil.getParameter(request, prefix	+ "cxl_desc", length));
			String[] ownrCd = (JSPUtil.getParameter(request, prefix	+ "ownr_cd", length));
			String[] deduction = (JSPUtil.getParameter(request, prefix	+ "deduction", length));
			String[] aproFlg = (JSPUtil.getParameter(request, prefix	+ "apro_flg", length));
			String[] arInterCoCd = (JSPUtil.getParameter(request, prefix	+ "ar_inter_co_cd", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] producedBy = (JSPUtil.getParameter(request, prefix	+ "produced_by", length));
			String[] csrDt = (JSPUtil.getParameter(request, prefix	+ "csr_dt", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm", length));
			String[] lstAproFlg = (JSPUtil.getParameter(request, prefix	+ "lst_apro_flg", length));			
			String[] aproRqstNo = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_no", length));
			String[] aproRqstSeq = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_seq", length));			
			String[] urgPayYn = (JSPUtil.getParameter(request, prefix	+ "urg_pay_yn", length));		
			String[] rqstAproStepFlg = (JSPUtil.getParameter(request, prefix	+ "rqst_apro_step_flg", length));	
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSlipApprovalListVO();
				if (rqstAmt[i] != null)
					model.setRqstAmt(rqstAmt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (fletCtrtTpCd[i] != null)
					model.setFletCtrtTpCd(fletCtrtTpCd[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (interCoCd[i] != null)
					model.setInterCoCd(interCoCd[i]);
				if (evidTp[i] != null)
					model.setEvidTp(evidTp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (slipType[i] != null)
					model.setSlipType(slipType[i]);
				if (diffDesc[i] != null)
					model.setDiffDesc(diffDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (requestTeam[i] != null)
					model.setRequestTeam(requestTeam[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (cxlDesc[i] != null)
					model.setCxlDesc(cxlDesc[i]);
				if (ownrCd[i] != null)
					model.setOwnrCd(ownrCd[i]);
				if (deduction[i] != null)
					model.setDeduction(deduction[i]);
				if (aproFlg[i] != null)
					model.setAproFlg(aproFlg[i]);
				if (arInterCoCd[i] != null)
					model.setArInterCoCd(arInterCoCd[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (producedBy[i] != null)
					model.setProducedBy(producedBy[i]);
				if (csrDt[i] != null)
					model.setCsrDt(csrDt[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (lstAproFlg[i] != null)
					model.setLstAproFlg(lstAproFlg[i]);
				if (aproRqstNo[i] != null)
					model.setAproRqstNo(aproRqstNo[i]);
				if (aproRqstSeq[i] != null)
					model.setAproRqstSeq(aproRqstSeq[i]);
				if (urgPayYn[i] != null)
					model.setUrgPayYn(urgPayYn[i]);
				if (rqstAproStepFlg[i] != null)
					model.setRqstAproStepFlg(rqstAproStepFlg[i]);
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);

				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSlipApprovalListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSlipApprovalListVO[]
	 */
	public SearchSlipApprovalListVO[] getSearchSlipApprovalListVOs(){
		SearchSlipApprovalListVO[] vos = (SearchSlipApprovalListVO[])models.toArray(new SearchSlipApprovalListVO[models.size()]);
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
		this.rqstAmt = this.rqstAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtTpCd = this.fletCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interCoCd = this.interCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evidTp = this.evidTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slipType = this.slipType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffDesc = this.diffDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.requestTeam = this.requestTeam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlDesc = this.cxlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrCd = this.ownrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deduction = this.deduction .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg = this.aproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arInterCoCd = this.arInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.producedBy = this.producedBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDt = this.csrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstAproFlg = this.lstAproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.aproRqstNo = this.aproRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstSeq = this.aproRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.urgPayYn = this.urgPayYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstAproStepFlg = this.rqstAproStepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
