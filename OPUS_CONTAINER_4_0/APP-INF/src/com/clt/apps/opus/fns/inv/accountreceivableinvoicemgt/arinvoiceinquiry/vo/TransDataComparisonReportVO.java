/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransDataComparisonReportVO.java
*@FileTitle : TransDataComparisonReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.28
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.12.28 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TransDataComparisonReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TransDataComparisonReportVO> models = new ArrayList<TransDataComparisonReportVO>();
	
	/* Column Info */
	private String invCoaAcctCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String revSrcCd = null;
	/* Column Info */
	private String erpIfGlDt = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String acctKrnNm = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TransDataComparisonReportVO() {}

	public TransDataComparisonReportVO(String ibflag, String pagerows, String erpIfGlDt, String arHdQtrOfcCd, String arOfcCd, String revTpCd, String revSrcCd, String invCoaAcctCd, String acctKrnNm, String currCd, String invAmt) {
		this.invCoaAcctCd = invCoaAcctCd;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.revSrcCd = revSrcCd;
		this.erpIfGlDt = erpIfGlDt;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.invAmt = invAmt;
		this.acctKrnNm = acctKrnNm;
		this.revTpCd = revTpCd;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_coa_acct_cd", getInvCoaAcctCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rev_src_cd", getRevSrcCd());
		this.hashColumns.put("erp_if_gl_dt", getErpIfGlDt());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("acct_krn_nm", getAcctKrnNm());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_coa_acct_cd", "invCoaAcctCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		this.hashFields.put("erp_if_gl_dt", "erpIfGlDt");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("acct_krn_nm", "acctKrnNm");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invCoaAcctCd
	 */
	public String getInvCoaAcctCd() {
		return this.invCoaAcctCd;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return revSrcCd
	 */
	public String getRevSrcCd() {
		return this.revSrcCd;
	}
	
	/**
	 * Column Info
	 * @return erpIfGlDt
	 */
	public String getErpIfGlDt() {
		return this.erpIfGlDt;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return acctKrnNm
	 */
	public String getAcctKrnNm() {
		return this.acctKrnNm;
	}
	
	/**
	 * Column Info
	 * @return revTpCd
	 */
	public String getRevTpCd() {
		return this.revTpCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @param invCoaAcctCd
	 */
	public void setInvCoaAcctCd(String invCoaAcctCd) {
		this.invCoaAcctCd = invCoaAcctCd;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param revSrcCd
	 */
	public void setRevSrcCd(String revSrcCd) {
		this.revSrcCd = revSrcCd;
	}
	
	/**
	 * Column Info
	 * @param erpIfGlDt
	 */
	public void setErpIfGlDt(String erpIfGlDt) {
		this.erpIfGlDt = erpIfGlDt;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param acctKrnNm
	 */
	public void setAcctKrnNm(String acctKrnNm) {
		this.acctKrnNm = acctKrnNm;
	}
	
	/**
	 * Column Info
	 * @param revTpCd
	 */
	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
		setInvCoaAcctCd(JSPUtil.getParameter(request, prefix + "inv_coa_acct_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setRevSrcCd(JSPUtil.getParameter(request, prefix + "rev_src_cd", ""));
		setErpIfGlDt(JSPUtil.getParameter(request, prefix + "erp_if_gl_dt", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setAcctKrnNm(JSPUtil.getParameter(request, prefix + "acct_krn_nm", ""));
		setRevTpCd(JSPUtil.getParameter(request, prefix + "rev_tp_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TransDataComparisonReportVO[]
	 */
	public TransDataComparisonReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TransDataComparisonReportVO[]
	 */
	public TransDataComparisonReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TransDataComparisonReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invCoaAcctCd = (JSPUtil.getParameter(request, prefix	+ "inv_coa_acct_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] revSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_src_cd", length));
			String[] erpIfGlDt = (JSPUtil.getParameter(request, prefix	+ "erp_if_gl_dt", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] acctKrnNm = (JSPUtil.getParameter(request, prefix	+ "acct_krn_nm", length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TransDataComparisonReportVO();
				if (invCoaAcctCd[i] != null)
					model.setInvCoaAcctCd(invCoaAcctCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (revSrcCd[i] != null)
					model.setRevSrcCd(revSrcCd[i]);
				if (erpIfGlDt[i] != null)
					model.setErpIfGlDt(erpIfGlDt[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (acctKrnNm[i] != null)
					model.setAcctKrnNm(acctKrnNm[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTransDataComparisonReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TransDataComparisonReportVO[]
	 */
	public TransDataComparisonReportVO[] getTransDataComparisonReportVOs(){
		TransDataComparisonReportVO[] vos = (TransDataComparisonReportVO[])models.toArray(new TransDataComparisonReportVO[models.size()]);
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
		this.invCoaAcctCd = this.invCoaAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd = this.revSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfGlDt = this.erpIfGlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctKrnNm = this.acctKrnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
