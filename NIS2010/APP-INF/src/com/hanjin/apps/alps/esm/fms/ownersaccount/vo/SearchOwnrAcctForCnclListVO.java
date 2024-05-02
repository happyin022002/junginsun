/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchOwnrAcctForCnclListVO.java
*@FileTitle : SearchOwnrAcctForCnclListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.29  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.ownersaccount.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOwnrAcctForCnclListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOwnrAcctForCnclListVO> models = new ArrayList<SearchOwnrAcctForCnclListVO>();
	
	/* Column Info */
	private String acctItmNm = null;
	/* Column Info */
	private String csrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String atchFileOaLnkCnt = null;
	/* Column Info */
	private String atchFileOaLnkId = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String toInvNo = null;
	/* Column Info */
	private String oaLocCd = null;
	/* Column Info */
	private String oaInvDt = null;
	/* Column Info */
	private String stlCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchOwnrAcctForCnclListVO() {}

	public SearchOwnrAcctForCnclListVO(String ibflag, String pagerows, String csrNo, String acctItmNm, String vvdCd, String oaLocCd, String toInvNo, String oaInvDt, String csrCurrCd, String csrAmt, String csrDesc, String atchFileOaLnkCnt, String atchFileOaLnkId, String StlCd) {
		this.acctItmNm = acctItmNm;
		this.csrNo = csrNo;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.atchFileOaLnkCnt = atchFileOaLnkCnt;
		this.atchFileOaLnkId = atchFileOaLnkId;
		this.csrDesc = csrDesc;
		this.csrCurrCd = csrCurrCd;
		this.csrAmt = csrAmt;
		this.toInvNo = toInvNo;
		this.oaLocCd = oaLocCd;
		this.oaInvDt = oaInvDt;
		this.stlCd = stlCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acct_itm_nm", getAcctItmNm());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("atch_file_oa_lnk_cnt", getAtchFileOaLnkCnt());
		this.hashColumns.put("atch_file_oa_lnk_id", getAtchFileOaLnkId());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("to_inv_no", getToInvNo());
		this.hashColumns.put("oa_loc_cd", getOaLocCd());
		this.hashColumns.put("oa_inv_dt", getOaInvDt());
		this.hashColumns.put("oa_stl_sts_cd", getStlCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acct_itm_nm", "acctItmNm");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("atch_file_oa_lnk_cnt", "atchFileOaLnkCnt");
		this.hashFields.put("atch_file_oa_lnk_id", "atchFileOaLnkId");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("to_inv_no", "toInvNo");
		this.hashFields.put("oa_loc_cd", "oaLocCd");
		this.hashFields.put("oa_inv_dt", "oaInvDt");
		this.hashFields.put("oa_stl_sts_cd", "stlCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return acctItmNm
	 */
	public String getAcctItmNm() {
		return this.acctItmNm;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return atchFileOaLnkCnt
	 */
	public String getAtchFileOaLnkCnt() {
		return this.atchFileOaLnkCnt;
	}
	
	/**
	 * Column Info
	 * @return atchFileOaLnkId
	 */
	public String getAtchFileOaLnkId() {
		return this.atchFileOaLnkId;
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
	 * @return csrAmt
	 */
	public String getCsrAmt() {
		return this.csrAmt;
	}
	
	/**
	 * Column Info
	 * @return toInvNo
	 */
	public String getToInvNo() {
		return this.toInvNo;
	}
	
	/**
	 * Column Info
	 * @return oaLocCd
	 */
	public String getOaLocCd() {
		return this.oaLocCd;
	}
	
	/**
	 * Column Info
	 * @return oaInvDt
	 */
	public String getOaInvDt() {
		return this.oaInvDt;
	}
	
	/**
	 * Column Info
	 * @return stlCd
	 */
	public String getStlCd() {
		return this.stlCd;
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
	 * @param acctItmNm
	 */
	public void setAcctItmNm(String acctItmNm) {
		this.acctItmNm = acctItmNm;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param atchFileOaLnkCnt
	 */
	public void setAtchFileOaLnkCnt(String atchFileOaLnkCnt) {
		this.atchFileOaLnkCnt = atchFileOaLnkCnt;
	}
	
	/**
	 * Column Info
	 * @param atchFileOaLnkId
	 */
	public void setAtchFileOaLnkId(String atchFileOaLnkId) {
		this.atchFileOaLnkId = atchFileOaLnkId;
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
	 * @param csrAmt
	 */
	public void setCsrAmt(String csrAmt) {
		this.csrAmt = csrAmt;
	}
	
	/**
	 * Column Info
	 * @param toInvNo
	 */
	public void setToInvNo(String toInvNo) {
		this.toInvNo = toInvNo;
	}
	
	/**
	 * Column Info
	 * @param oaLocCd
	 */
	public void setOaLocCd(String oaLocCd) {
		this.oaLocCd = oaLocCd;
	}
	
	/**
	 * Column Info
	 * @param oaInvDt
	 */
	public void setOaInvDt(String oaInvDt) {
		this.oaInvDt = oaInvDt;
	}
	
	/**
	 * Column Info
	 * @param stlCd
	 */
	public void setStlCd(String stlCd) {
		this.stlCd = stlCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setAcctItmNm(JSPUtil.getParameter(request, prefix + "acct_itm_nm", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setAtchFileOaLnkCnt(JSPUtil.getParameter(request, prefix + "atch_file_oa_lnk_cnt", ""));
		setAtchFileOaLnkId(JSPUtil.getParameter(request, prefix + "atch_file_oa_lnk_id", ""));
		setCsrDesc(JSPUtil.getParameter(request, prefix + "csr_desc", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, prefix + "csr_curr_cd", ""));
		setCsrAmt(JSPUtil.getParameter(request, prefix + "csr_amt", ""));
		setToInvNo(JSPUtil.getParameter(request, prefix + "to_inv_no", ""));
		setOaLocCd(JSPUtil.getParameter(request, prefix + "oa_loc_cd", ""));
		setOaInvDt(JSPUtil.getParameter(request, prefix + "oa_inv_dt", ""));
		setStlCd(JSPUtil.getParameter(request, prefix + "oa_stl_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOwnrAcctForCnclListVO[]
	 */
	public SearchOwnrAcctForCnclListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOwnrAcctForCnclListVO[]
	 */
	public SearchOwnrAcctForCnclListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOwnrAcctForCnclListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acctItmNm = (JSPUtil.getParameter(request, prefix	+ "acct_itm_nm", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] atchFileOaLnkCnt = (JSPUtil.getParameter(request, prefix	+ "atch_file_oa_lnk_cnt", length));
			String[] atchFileOaLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_oa_lnk_id", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] toInvNo = (JSPUtil.getParameter(request, prefix	+ "to_inv_no", length));
			String[] oaLocCd = (JSPUtil.getParameter(request, prefix	+ "oa_loc_cd", length));
			String[] oaInvDt = (JSPUtil.getParameter(request, prefix	+ "oa_inv_dt", length));
			String[] stlCd = (JSPUtil.getParameter(request, prefix	+ "oa_stl_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOwnrAcctForCnclListVO();
				if (acctItmNm[i] != null)
					model.setAcctItmNm(acctItmNm[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (atchFileOaLnkCnt[i] != null)
					model.setAtchFileOaLnkCnt(atchFileOaLnkCnt[i]);
				if (atchFileOaLnkId[i] != null)
					model.setAtchFileOaLnkId(atchFileOaLnkId[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (toInvNo[i] != null)
					model.setToInvNo(toInvNo[i]);
				if (oaLocCd[i] != null)
					model.setOaLocCd(oaLocCd[i]);
				if (oaInvDt[i] != null)
					model.setOaInvDt(oaInvDt[i]);
				if (stlCd[i] != null)
					model.setStlCd(stlCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOwnrAcctForCnclListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOwnrAcctForCnclListVO[]
	 */
	public SearchOwnrAcctForCnclListVO[] getSearchOwnrAcctForCnclListVOs(){
		SearchOwnrAcctForCnclListVO[] vos = (SearchOwnrAcctForCnclListVO[])models.toArray(new SearchOwnrAcctForCnclListVO[models.size()]);
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
		this.acctItmNm = this.acctItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileOaLnkCnt = this.atchFileOaLnkCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileOaLnkId = this.atchFileOaLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvNo = this.toInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaLocCd = this.oaLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaInvDt = this.oaInvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCd = this.stlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
