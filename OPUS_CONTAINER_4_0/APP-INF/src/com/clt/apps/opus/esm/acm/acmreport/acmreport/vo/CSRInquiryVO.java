/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CSRInquiryVO.java
*@FileTitle : CSRInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.18
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.18 김봉균
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmreport.acmreport.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CSRInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CSRInquiryVO> models = new ArrayList<CSRInquiryVO>();

	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String commStndCostCd = null;
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String xchRt = null;
	/* Column Info */
	private String aproDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String audNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creUsrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String aproUsrNm = null;
	/* Column Info */
	private String dateDiv = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String payIfAmt = null;
	/* Column Info */
	private String revVvdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CSRInquiryVO() {}

	public CSRInquiryVO(String ibflag, String pagerows, String agnCd, String csrNo, String audNo, String invDesc, String commStndCostCd, String ifAmt, String payIfAmt, String revVvdCd, String xchRt, String currCd, String status, String creDt, String ifDt, String aproDt, String glDt, String payDt, String creUsrId, String aproUsrId, String creUsrNm, String aproUsrNm, String dateDiv, String dateFm, String dateTo, String stsCd) {
		this.dateFm = dateFm;
		this.ifDt = ifDt;
		this.commStndCostCd = commStndCostCd;
		this.payDt = payDt;
		this.csrNo = csrNo;
		this.glDt = glDt;
		this.currCd = currCd;
		this.status = status;
		this.dateTo = dateTo;
		this.creDt = creDt;
		this.xchRt = xchRt;
		this.aproDt = aproDt;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.agnCd = agnCd;
		this.audNo = audNo;
		this.creUsrId = creUsrId;
		this.creUsrNm = creUsrNm;
		this.ibflag = ibflag;
		this.invDesc = invDesc;
		this.aproUsrId = aproUsrId;
		this.aproUsrNm = aproUsrNm;
		this.dateDiv = dateDiv;
		this.ifAmt = ifAmt;
		this.payIfAmt = payIfAmt;
		this.revVvdCd = revVvdCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("comm_stnd_cost_cd", getCommStndCostCd());
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("xch_rt", getXchRt());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("aud_no", getAudNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("apro_usr_nm", getAproUsrNm());
		this.hashColumns.put("date_div", getDateDiv());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("pay_if_amt", getPayIfAmt());
		this.hashColumns.put("rev_vvd_cd", getRevVvdCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("comm_stnd_cost_cd", "commStndCostCd");
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("status", "status");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("xch_rt", "xchRt");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("aud_no", "audNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("apro_usr_nm", "aproUsrNm");
		this.hashFields.put("date_div", "dateDiv");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("pay_if_amt", "payIfAmt");
		this.hashFields.put("rev_vvd_cd", "revVvdCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return dateFm
	 */
	public String getDateFm() {
		return this.dateFm;
	}

	/**
	 * Column Info
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
	}

	/**
	 * Column Info
	 * @return commStndCostCd
	 */
	public String getCommStndCostCd() {
		return this.commStndCostCd;
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
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}

	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
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
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Column Info
	 * @return dateTo
	 */
	public String getDateTo() {
		return this.dateTo;
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
	 * @return xchRt
	 */
	public String getXchRt() {
		return this.xchRt;
	}

	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
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
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
	}

	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}

	/**
	 * Column Info
	 * @return audNo
	 */
	public String getAudNo() {
		return this.audNo;
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
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
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
	 * @return invDesc
	 */
	public String getInvDesc() {
		return this.invDesc;
	}

	/**
	 * Column Info
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return aproUsrNm
	 */
	public String getAproUsrNm() {
		return this.aproUsrNm;
	}

	/**
	 * Column Info
	 * @return dateDiv
	 */
	public String getDateDiv() {
		return this.dateDiv;
	}

	/**
	 * Column Info
	 * @return ifAmt
	 */
	public String getIfAmt() {
		return this.ifAmt;
	}

	/**
	 * Column Info
	 * @return payIfAmt
	 */
	public String getPayIfAmt() {
		return this.payIfAmt;
	}

	/**
	 * Column Info
	 * @return revVvdCd
	 */
	public String getRevVvdCd() {
		return this.revVvdCd;
	}


	/**
	 * Column Info
	 * @param dateFm
	 */
	public void setDateFm(String dateFm) {
		this.dateFm = dateFm;
	}

	/**
	 * Column Info
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
	}

	/**
	 * Column Info
	 * @param commStndCostCd
	 */
	public void setCommStndCostCd(String commStndCostCd) {
		this.commStndCostCd = commStndCostCd;
	}

	/**
	 * Column Info
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
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
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
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
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Column Info
	 * @param dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
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
	 * @param xchRt
	 */
	public void setXchRt(String xchRt) {
		this.xchRt = xchRt;
	}

	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}

	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}

	/**
	 * Column Info
	 * @param audNo
	 */
	public void setAudNo(String audNo) {
		this.audNo = audNo;
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
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
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
	 * @param invDesc
	 */
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
	}

	/**
	 * Column Info
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param aproUsrNm
	 */
	public void setAproUsrNm(String aproUsrNm) {
		this.aproUsrNm = aproUsrNm;
	}

	/**
	 * Column Info
	 * @param dateDiv
	 */
	public void setDateDiv(String dateDiv) {
		this.dateDiv = dateDiv;
	}

	/**
	 * Column Info
	 * @param ifAmt
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
	}

	/**
	 * Column Info
	 * @param payIfAmt
	 */
	public void setPayIfAmt(String payIfAmt) {
		this.payIfAmt = payIfAmt;
	}

	/**
	 * Column Info
	 * @param revVvdCd
	 */
	public void setRevVvdCd(String revVvdCd) {
		this.revVvdCd = revVvdCd;
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
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
		setCommStndCostCd(JSPUtil.getParameter(request, prefix + "comm_stnd_cost_cd", ""));
		setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setXchRt(JSPUtil.getParameter(request, prefix + "xch_rt", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setAudNo(JSPUtil.getParameter(request, prefix + "aud_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setAproUsrNm(JSPUtil.getParameter(request, prefix + "apro_usr_nm", ""));
		setDateDiv(JSPUtil.getParameter(request, prefix + "date_div", ""));
		setIfAmt(JSPUtil.getParameter(request, prefix + "if_amt", ""));
		setPayIfAmt(JSPUtil.getParameter(request, prefix + "pay_if_amt", ""));
		setRevVvdCd(JSPUtil.getParameter(request, prefix + "rev_vvd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CSRInquiryVO[]
	 */
	public CSRInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CSRInquiryVO[]
	 */
	public CSRInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CSRInquiryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] commStndCostCd = (JSPUtil.getParameter(request, prefix	+ "comm_stnd_cost_cd", length));
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] xchRt = (JSPUtil.getParameter(request, prefix	+ "xch_rt", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] audNo = (JSPUtil.getParameter(request, prefix	+ "aud_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] aproUsrNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_nm", length));
			String[] dateDiv = (JSPUtil.getParameter(request, prefix	+ "date_div", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] payIfAmt = (JSPUtil.getParameter(request, prefix	+ "pay_if_amt", length));
			String[] revVvdCd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_cd", length));

			for (int i = 0; i < length; i++) {
				model = new CSRInquiryVO();
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (commStndCostCd[i] != null)
					model.setCommStndCostCd(commStndCostCd[i]);
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (xchRt[i] != null)
					model.setXchRt(xchRt[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (audNo[i] != null)
					model.setAudNo(audNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (aproUsrNm[i] != null)
					model.setAproUsrNm(aproUsrNm[i]);
				if (dateDiv[i] != null)
					model.setDateDiv(dateDiv[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (payIfAmt[i] != null)
					model.setPayIfAmt(payIfAmt[i]);
				if (revVvdCd[i] != null)
					model.setRevVvdCd(revVvdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCSRInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CSRInquiryVO[]
	 */
	public CSRInquiryVO[] getCSRInquiryVOs(){
		CSRInquiryVO[] vos = (CSRInquiryVO[])models.toArray(new CSRInquiryVO[models.size()]);
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
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commStndCostCd = this.commStndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRt = this.xchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audNo = this.audNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrNm = this.aproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateDiv = this.dateDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payIfAmt = this.payIfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdCd = this.revVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
