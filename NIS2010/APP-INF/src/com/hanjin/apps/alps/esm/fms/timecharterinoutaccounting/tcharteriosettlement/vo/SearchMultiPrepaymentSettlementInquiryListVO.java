/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchMultiPrepaymentSettlementInquiryListVO.java
*@FileTitle : SearchMultiPrepaymentSettlementInquiryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.22
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.22 손진환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 손진환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMultiPrepaymentSettlementInquiryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMultiPrepaymentSettlementInquiryListVO> models = new ArrayList<SearchMultiPrepaymentSettlementInquiryListVO>();
	
	/* Column Info */
	private String rqstAmt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String screenGubun = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String evidTp = null;
	/* Column Info */
	private String fromEffDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String diffDesc = null;
	/* Column Info */
	private String requestTeam = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cxlDesc = null;
	/* Column Info */
	private String ownrCd = null;
	/* Column Info */
	private String deduction = null;
	/* Column Info */
	private String newCsrNo = null;
	/* Column Info */
	private String producedBy = null;
	/* Column Info */
	private String csrDt = null;
	/* Column Info */
	private String vslEngName = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String orgSlipNo = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String ownrNm = null;
	/* Column Info */
	private String csrType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchMultiPrepaymentSettlementInquiryListVO() {}

	public SearchMultiPrepaymentSettlementInquiryListVO(String ibflag, String pagerows, String usrId, String csrType, String screenGubun, String fromEffDt, String toEffDt, String vslCd, String newCsrNo, String requestTeam, String csrDt, String producedBy, String csrDesc, String ownrCd, String ownrNm, String csrCurrCd, String csrAmt, String evidTp, String deduction, String rqstAmt, String diffDesc, String cxlFlg, String cxlDesc, String orgSlipNo, String vslEngName) {
		this.rqstAmt = rqstAmt;
		this.vslCd = vslCd;
		this.screenGubun = screenGubun;
		this.csrDesc = csrDesc;
		this.csrCurrCd = csrCurrCd;
		this.cxlFlg = cxlFlg;
		this.evidTp = evidTp;
		this.fromEffDt = fromEffDt;
		this.pagerows = pagerows;
		this.diffDesc = diffDesc;
		this.requestTeam = requestTeam;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.cxlDesc = cxlDesc;
		this.ownrCd = ownrCd;
		this.deduction = deduction;
		this.newCsrNo = newCsrNo;
		this.producedBy = producedBy;
		this.csrDt = csrDt;
		this.vslEngName = vslEngName;
		this.toEffDt = toEffDt;
		this.orgSlipNo = orgSlipNo;
		this.csrAmt = csrAmt;
		this.ownrNm = ownrNm;
		this.csrType = csrType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_amt", getRqstAmt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("screen_gubun", getScreenGubun());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("evid_tp", getEvidTp());
		this.hashColumns.put("from_eff_dt", getFromEffDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("diff_desc", getDiffDesc());
		this.hashColumns.put("request_team", getRequestTeam());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cxl_desc", getCxlDesc());
		this.hashColumns.put("ownr_cd", getOwnrCd());
		this.hashColumns.put("deduction", getDeduction());
		this.hashColumns.put("new_csr_no", getNewCsrNo());
		this.hashColumns.put("produced_by", getProducedBy());
		this.hashColumns.put("csr_dt", getCsrDt());
		this.hashColumns.put("vsl_eng_name", getVslEngName());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("org_slip_no", getOrgSlipNo());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("csr_type", getCsrType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_amt", "rqstAmt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("screen_gubun", "screenGubun");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("evid_tp", "evidTp");
		this.hashFields.put("from_eff_dt", "fromEffDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("diff_desc", "diffDesc");
		this.hashFields.put("request_team", "requestTeam");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cxl_desc", "cxlDesc");
		this.hashFields.put("ownr_cd", "ownrCd");
		this.hashFields.put("deduction", "deduction");
		this.hashFields.put("new_csr_no", "newCsrNo");
		this.hashFields.put("produced_by", "producedBy");
		this.hashFields.put("csr_dt", "csrDt");
		this.hashFields.put("vsl_eng_name", "vslEngName");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("org_slip_no", "orgSlipNo");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("csr_type", "csrType");
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
	 * @return screenGubun
	 */
	public String getScreenGubun() {
		return this.screenGubun;
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
	 * @return evidTp
	 */
	public String getEvidTp() {
		return this.evidTp;
	}
	
	/**
	 * Column Info
	 * @return fromEffDt
	 */
	public String getFromEffDt() {
		return this.fromEffDt;
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
	 * @return diffDesc
	 */
	public String getDiffDesc() {
		return this.diffDesc;
	}
	
	/**
	 * Column Info
	 * @return requestTeam
	 */
	public String getRequestTeam() {
		return this.requestTeam;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return newCsrNo
	 */
	public String getNewCsrNo() {
		return this.newCsrNo;
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
	 * @return vslEngName
	 */
	public String getVslEngName() {
		return this.vslEngName;
	}
	
	/**
	 * Column Info
	 * @return toDffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
	}
	
	/**
	 * Column Info
	 * @return orgSlipNo
	 */
	public String getOrgSlipNo() {
		return this.orgSlipNo;
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
	 * @return csrType
	 */
	public String getCsrType() {
		return this.csrType;
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
	 * @param screenGubun
	 */
	public void setScreenGubun(String screenGubun) {
		this.screenGubun = screenGubun;
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
	 * @param evidTp
	 */
	public void setEvidTp(String evidTp) {
		this.evidTp = evidTp;
	}
	
	/**
	 * Column Info
	 * @param fromEffDt
	 */
	public void setFromEffDt(String fromEffDt) {
		this.fromEffDt = fromEffDt;
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
	 * @param diffDesc
	 */
	public void setDiffDesc(String diffDesc) {
		this.diffDesc = diffDesc;
	}
	
	/**
	 * Column Info
	 * @param requestTeam
	 */
	public void setRequestTeam(String requestTeam) {
		this.requestTeam = requestTeam;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param newCsrNo
	 */
	public void setNewCsrNo(String newCsrNo) {
		this.newCsrNo = newCsrNo;
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
	 * @param vslEngName
	 */
	public void setVslEngName(String vslEngName) {
		this.vslEngName = vslEngName;
	}
	
	/**
	 * Column Info
	 * @param toDffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}
	
	/**
	 * Column Info
	 * @param orgSlipNo
	 */
	public void setOrgSlipNo(String orgSlipNo) {
		this.orgSlipNo = orgSlipNo;
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
	 * @param csrType
	 */
	public void setCsrType(String csrType) {
		this.csrType = csrType;
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
		setRqstAmt(JSPUtil.getParameter(request, prefix + "rqst_amt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setScreenGubun(JSPUtil.getParameter(request, prefix + "screen_gubun", ""));
		setCsrDesc(JSPUtil.getParameter(request, prefix + "csr_desc", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, prefix + "csr_curr_cd", ""));
		setCxlFlg(JSPUtil.getParameter(request, prefix + "cxl_flg", ""));
		setEvidTp(JSPUtil.getParameter(request, prefix + "evid_tp", ""));
		setFromEffDt(JSPUtil.getParameter(request, prefix + "from_eff_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDiffDesc(JSPUtil.getParameter(request, prefix + "diff_desc", ""));
		setRequestTeam(JSPUtil.getParameter(request, prefix + "request_team", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCxlDesc(JSPUtil.getParameter(request, prefix + "cxl_desc", ""));
		setOwnrCd(JSPUtil.getParameter(request, prefix + "ownr_cd", ""));
		setDeduction(JSPUtil.getParameter(request, prefix + "deduction", ""));
		setNewCsrNo(JSPUtil.getParameter(request, prefix + "new_csr_no", ""));
		setProducedBy(JSPUtil.getParameter(request, prefix + "produced_by", ""));
		setCsrDt(JSPUtil.getParameter(request, prefix + "csr_dt", ""));
		setVslEngName(JSPUtil.getParameter(request, prefix + "vsl_eng_name", ""));
		setToEffDt(JSPUtil.getParameter(request, prefix + "to_eff_dt", ""));
		setOrgSlipNo(JSPUtil.getParameter(request, prefix + "org_slip_no", ""));
		setCsrAmt(JSPUtil.getParameter(request, prefix + "csr_amt", ""));
		setOwnrNm(JSPUtil.getParameter(request, prefix + "ownr_nm", ""));
		setCsrType(JSPUtil.getParameter(request, prefix + "csr_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMultiPrepaymentSettlementInquiryListVO[]
	 */
	public SearchMultiPrepaymentSettlementInquiryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMultiPrepaymentSettlementInquiryListVO[]
	 */
	public SearchMultiPrepaymentSettlementInquiryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMultiPrepaymentSettlementInquiryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_amt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] screenGubun = (JSPUtil.getParameter(request, prefix	+ "screen_gubun", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] evidTp = (JSPUtil.getParameter(request, prefix	+ "evid_tp", length));
			String[] fromEffDt = (JSPUtil.getParameter(request, prefix	+ "from_eff_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] diffDesc = (JSPUtil.getParameter(request, prefix	+ "diff_desc", length));
			String[] requestTeam = (JSPUtil.getParameter(request, prefix	+ "request_team", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cxlDesc = (JSPUtil.getParameter(request, prefix	+ "cxl_desc", length));
			String[] ownrCd = (JSPUtil.getParameter(request, prefix	+ "ownr_cd", length));
			String[] deduction = (JSPUtil.getParameter(request, prefix	+ "deduction", length));
			String[] newCsrNo = (JSPUtil.getParameter(request, prefix	+ "new_csr_no", length));
			String[] producedBy = (JSPUtil.getParameter(request, prefix	+ "produced_by", length));
			String[] csrDt = (JSPUtil.getParameter(request, prefix	+ "csr_dt", length));
			String[] vslEngName = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_name", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] orgSlipNo = (JSPUtil.getParameter(request, prefix	+ "org_slip_no", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm", length));
			String[] csrType = (JSPUtil.getParameter(request, prefix	+ "csr_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMultiPrepaymentSettlementInquiryListVO();
				if (rqstAmt[i] != null)
					model.setRqstAmt(rqstAmt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (screenGubun[i] != null)
					model.setScreenGubun(screenGubun[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (evidTp[i] != null)
					model.setEvidTp(evidTp[i]);
				if (fromEffDt[i] != null)
					model.setFromEffDt(fromEffDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (diffDesc[i] != null)
					model.setDiffDesc(diffDesc[i]);
				if (requestTeam[i] != null)
					model.setRequestTeam(requestTeam[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cxlDesc[i] != null)
					model.setCxlDesc(cxlDesc[i]);
				if (ownrCd[i] != null)
					model.setOwnrCd(ownrCd[i]);
				if (deduction[i] != null)
					model.setDeduction(deduction[i]);
				if (newCsrNo[i] != null)
					model.setNewCsrNo(newCsrNo[i]);
				if (producedBy[i] != null)
					model.setProducedBy(producedBy[i]);
				if (csrDt[i] != null)
					model.setCsrDt(csrDt[i]);
				if (vslEngName[i] != null)
					model.setVslEngName(vslEngName[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (orgSlipNo[i] != null)
					model.setOrgSlipNo(orgSlipNo[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (csrType[i] != null)
					model.setCsrType(csrType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMultiPrepaymentSettlementInquiryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMultiPrepaymentSettlementInquiryListVO[]
	 */
	public SearchMultiPrepaymentSettlementInquiryListVO[] getSearchMultiPrepaymentSettlementInquiryListVOs(){
		SearchMultiPrepaymentSettlementInquiryListVO[] vos = (SearchMultiPrepaymentSettlementInquiryListVO[])models.toArray(new SearchMultiPrepaymentSettlementInquiryListVO[models.size()]);
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
		this.screenGubun = this.screenGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evidTp = this.evidTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromEffDt = this.fromEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffDesc = this.diffDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.requestTeam = this.requestTeam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlDesc = this.cxlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrCd = this.ownrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deduction = this.deduction .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCsrNo = this.newCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.producedBy = this.producedBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDt = this.csrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngName = this.vslEngName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlipNo = this.orgSlipNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrType = this.csrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
