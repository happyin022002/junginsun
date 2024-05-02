/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBRKGInfoForPrint2VO.java
*@FileTitle : SearchBRKGInfoForPrint2VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.10.23 이호진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo;

import java.lang.reflect.Field;
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
 * @author 이호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BRKGInfoForPrint2VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BRKGInfoForPrint2VO> models = new ArrayList<BRKGInfoForPrint2VO>();
	
	/* Column Info */
	private String dtlChtAcct = null;
	/* Column Info */
	private String dtlGlDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dtlDesc = null;
	/* Column Info */
	private String dtlInvNo = null;
	/* Column Info */
	private String dtlCity = null;
	/* Column Info */
	private String dtlDebit = null;
	/* Column Info */
	private String dtlAcctNm = null;
	/* Column Info */
	private String dtlSeq = null;
	/* Column Info */
	private String hCsrno = null;
	/* Column Info */
	private String dtlCredit = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BRKGInfoForPrint2VO() {}

	public BRKGInfoForPrint2VO(String ibflag, String pagerows, String dtlSeq, String dtlChtAcct, String dtlAcctNm, String dtlGlDt, String dtlCity, String dtlInvNo, String dtlDesc, String dtlDebit, String dtlCredit, String hCsrno) {
		this.dtlChtAcct = dtlChtAcct;
		this.dtlGlDt = dtlGlDt;
		this.ibflag = ibflag;
		this.dtlDesc = dtlDesc;
		this.dtlInvNo = dtlInvNo;
		this.dtlCity = dtlCity;
		this.dtlDebit = dtlDebit;
		this.dtlAcctNm = dtlAcctNm;
		this.dtlSeq = dtlSeq;
		this.hCsrno = hCsrno;
		this.dtlCredit = dtlCredit;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dtl_cht_acct", getDtlChtAcct());
		this.hashColumns.put("dtl_gl_dt", getDtlGlDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dtl_desc", getDtlDesc());
		this.hashColumns.put("dtl_inv_no", getDtlInvNo());
		this.hashColumns.put("dtl_city", getDtlCity());
		this.hashColumns.put("dtl_debit", getDtlDebit());
		this.hashColumns.put("dtl_acct_nm", getDtlAcctNm());
		this.hashColumns.put("dtl_seq", getDtlSeq());
		this.hashColumns.put("h_csrno", getHCsrno());
		this.hashColumns.put("dtl_credit", getDtlCredit());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dtl_cht_acct", "dtlChtAcct");
		this.hashFields.put("dtl_gl_dt", "dtlGlDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dtl_desc", "dtlDesc");
		this.hashFields.put("dtl_inv_no", "dtlInvNo");
		this.hashFields.put("dtl_city", "dtlCity");
		this.hashFields.put("dtl_debit", "dtlDebit");
		this.hashFields.put("dtl_acct_nm", "dtlAcctNm");
		this.hashFields.put("dtl_seq", "dtlSeq");
		this.hashFields.put("h_csrno", "hCsrno");
		this.hashFields.put("dtl_credit", "dtlCredit");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dtlChtAcct
	 */
	public String getDtlChtAcct() {
		return this.dtlChtAcct;
	}
	
	/**
	 * Column Info
	 * @return dtlGlDt
	 */
	public String getDtlGlDt() {
		return this.dtlGlDt;
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
	 * @return dtlDesc
	 */
	public String getDtlDesc() {
		return this.dtlDesc;
	}
	
	/**
	 * Column Info
	 * @return dtlInvNo
	 */
	public String getDtlInvNo() {
		return this.dtlInvNo;
	}
	
	/**
	 * Column Info
	 * @return dtlCity
	 */
	public String getDtlCity() {
		return this.dtlCity;
	}
	
	/**
	 * Column Info
	 * @return dtlDebit
	 */
	public String getDtlDebit() {
		return this.dtlDebit;
	}
	
	/**
	 * Column Info
	 * @return dtlAcctNm
	 */
	public String getDtlAcctNm() {
		return this.dtlAcctNm;
	}
	
	/**
	 * Column Info
	 * @return dtlSeq
	 */
	public String getDtlSeq() {
		return this.dtlSeq;
	}
	
	/**
	 * Column Info
	 * @return hCsrno
	 */
	public String getHCsrno() {
		return this.hCsrno;
	}
	
	/**
	 * Column Info
	 * @return dtlCredit
	 */
	public String getDtlCredit() {
		return this.dtlCredit;
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
	 * @param dtlChtAcct
	 */
	public void setDtlChtAcct(String dtlChtAcct) {
		this.dtlChtAcct = dtlChtAcct;
	}
	
	/**
	 * Column Info
	 * @param dtlGlDt
	 */
	public void setDtlGlDt(String dtlGlDt) {
		this.dtlGlDt = dtlGlDt;
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
	 * @param dtlDesc
	 */
	public void setDtlDesc(String dtlDesc) {
		this.dtlDesc = dtlDesc;
	}
	
	/**
	 * Column Info
	 * @param dtlInvNo
	 */
	public void setDtlInvNo(String dtlInvNo) {
		this.dtlInvNo = dtlInvNo;
	}
	
	/**
	 * Column Info
	 * @param dtlCity
	 */
	public void setDtlCity(String dtlCity) {
		this.dtlCity = dtlCity;
	}
	
	/**
	 * Column Info
	 * @param dtlDebit
	 */
	public void setDtlDebit(String dtlDebit) {
		this.dtlDebit = dtlDebit;
	}
	
	/**
	 * Column Info
	 * @param dtlAcctNm
	 */
	public void setDtlAcctNm(String dtlAcctNm) {
		this.dtlAcctNm = dtlAcctNm;
	}
	
	/**
	 * Column Info
	 * @param dtlSeq
	 */
	public void setDtlSeq(String dtlSeq) {
		this.dtlSeq = dtlSeq;
	}
	
	/**
	 * Column Info
	 * @param hCsrno
	 */
	public void setHCsrno(String hCsrno) {
		this.hCsrno = hCsrno;
	}
	
	/**
	 * Column Info
	 * @param dtlCredit
	 */
	public void setDtlCredit(String dtlCredit) {
		this.dtlCredit = dtlCredit;
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
		setDtlChtAcct(JSPUtil.getParameter(request, "dtl_cht_acct", ""));
		setDtlGlDt(JSPUtil.getParameter(request, "dtl_gl_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDtlDesc(JSPUtil.getParameter(request, "dtl_desc", ""));
		setDtlInvNo(JSPUtil.getParameter(request, "dtl_inv_no", ""));
		setDtlCity(JSPUtil.getParameter(request, "dtl_city", ""));
		setDtlDebit(JSPUtil.getParameter(request, "dtl_debit", ""));
		setDtlAcctNm(JSPUtil.getParameter(request, "dtl_acct_nm", ""));
		setDtlSeq(JSPUtil.getParameter(request, "dtl_seq", ""));
		setHCsrno(JSPUtil.getParameter(request, "h_csrno", ""));
		setDtlCredit(JSPUtil.getParameter(request, "dtl_credit", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBRKGInfoForPrint2VO[]
	 */
	public BRKGInfoForPrint2VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBRKGInfoForPrint2VO[]
	 */
	public BRKGInfoForPrint2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BRKGInfoForPrint2VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dtlChtAcct = (JSPUtil.getParameter(request, prefix	+ "dtl_cht_acct", length));
			String[] dtlGlDt = (JSPUtil.getParameter(request, prefix	+ "dtl_gl_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dtlDesc = (JSPUtil.getParameter(request, prefix	+ "dtl_desc", length));
			String[] dtlInvNo = (JSPUtil.getParameter(request, prefix	+ "dtl_inv_no", length));
			String[] dtlCity = (JSPUtil.getParameter(request, prefix	+ "dtl_city", length));
			String[] dtlDebit = (JSPUtil.getParameter(request, prefix	+ "dtl_debit", length));
			String[] dtlAcctNm = (JSPUtil.getParameter(request, prefix	+ "dtl_acct_nm", length));
			String[] dtlSeq = (JSPUtil.getParameter(request, prefix	+ "dtl_seq", length));
			String[] hCsrno = (JSPUtil.getParameter(request, prefix	+ "h_csrno", length));
			String[] dtlCredit = (JSPUtil.getParameter(request, prefix	+ "dtl_credit", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BRKGInfoForPrint2VO();
				if (dtlChtAcct[i] != null)
					model.setDtlChtAcct(dtlChtAcct[i]);
				if (dtlGlDt[i] != null)
					model.setDtlGlDt(dtlGlDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dtlDesc[i] != null)
					model.setDtlDesc(dtlDesc[i]);
				if (dtlInvNo[i] != null)
					model.setDtlInvNo(dtlInvNo[i]);
				if (dtlCity[i] != null)
					model.setDtlCity(dtlCity[i]);
				if (dtlDebit[i] != null)
					model.setDtlDebit(dtlDebit[i]);
				if (dtlAcctNm[i] != null)
					model.setDtlAcctNm(dtlAcctNm[i]);
				if (dtlSeq[i] != null)
					model.setDtlSeq(dtlSeq[i]);
				if (hCsrno[i] != null)
					model.setHCsrno(hCsrno[i]);
				if (dtlCredit[i] != null)
					model.setDtlCredit(dtlCredit[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBRKGInfoForPrint2VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBRKGInfoForPrint2VO[]
	 */
	public BRKGInfoForPrint2VO[] getSearchBRKGInfoForPrint2VOs(){
		BRKGInfoForPrint2VO[] vos = (BRKGInfoForPrint2VO[])models.toArray(new BRKGInfoForPrint2VO[models.size()]);
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
		this.dtlChtAcct = this.dtlChtAcct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlGlDt = this.dtlGlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlDesc = this.dtlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlInvNo = this.dtlInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlCity = this.dtlCity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlDebit = this.dtlDebit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlAcctNm = this.dtlAcctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSeq = this.dtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hCsrno = this.hCsrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlCredit = this.dtlCredit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
