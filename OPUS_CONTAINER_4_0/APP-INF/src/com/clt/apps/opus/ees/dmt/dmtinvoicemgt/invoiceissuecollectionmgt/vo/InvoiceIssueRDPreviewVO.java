/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueRDPreviewVO.java
*@FileTitle : InvoiceIssueRDPreviewVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.12.30 김태균 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceIssueRDPreviewVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceIssueRDPreviewVO> models = new ArrayList<InvoiceIssueRDPreviewVO>();
	
	/* Column Info */
	private String invAmount = null;
	/* Column Info */
	private String invRtAmt = null;
	/* Column Info */
	private String ftCmncDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chgCurrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String rtOvrDys = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String ftOvrUndDys = null;
	/* Column Info */
	private String ftEndDt = null;
	/* Column Info */
	private String toMvmtDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceIssueRDPreviewVO() {}

	public InvoiceIssueRDPreviewVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String fmMvmtDt, String toMvmtDt, String ftCmncDt, String ftEndDt, String ftDys, String ftOvrUndDys, String invRtAmt, String rtOvrDys, String invAmount, String chgCurrCd) {
		this.invAmount = invAmount;
		this.invRtAmt = invRtAmt;
		this.ftCmncDt = ftCmncDt;
		this.pagerows = pagerows;
		this.chgCurrCd = chgCurrCd;
		this.ibflag = ibflag;
		this.ftDys = ftDys;
		this.rtOvrDys = rtOvrDys;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.fmMvmtDt = fmMvmtDt;
		this.ftOvrUndDys = ftOvrUndDys;
		this.ftEndDt = ftEndDt;
		this.toMvmtDt = toMvmtDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_amount", getInvAmount());
		this.hashColumns.put("inv_rt_amt", getInvRtAmt());
		this.hashColumns.put("ft_cmnc_dt", getFtCmncDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chg_curr_cd", getChgCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("rt_ovr_dys", getRtOvrDys());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("ft_ovr_und_dys", getFtOvrUndDys());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_amount", "invAmount");
		this.hashFields.put("inv_rt_amt", "invRtAmt");
		this.hashFields.put("ft_cmnc_dt", "ftCmncDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chg_curr_cd", "chgCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("rt_ovr_dys", "rtOvrDys");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("ft_ovr_und_dys", "ftOvrUndDys");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invAmount
	 */
	public String getInvAmount() {
		return this.invAmount;
	}
	
	/**
	 * Column Info
	 * @return invRtAmt
	 */
	public String getInvRtAmt() {
		return this.invRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ftCmncDt
	 */
	public String getFtCmncDt() {
		return this.ftCmncDt;
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
	 * @return chgCurrCd
	 */
	public String getChgCurrCd() {
		return this.chgCurrCd;
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
	 * @return ftDys
	 */
	public String getFtDys() {
		return this.ftDys;
	}
	
	/**
	 * Column Info
	 * @return rtOvrDys
	 */
	public String getRtOvrDys() {
		return this.rtOvrDys;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtDt
	 */
	public String getFmMvmtDt() {
		return this.fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return ftOvrUndDys
	 */
	public String getFtOvrUndDys() {
		return this.ftOvrUndDys;
	}
	
	/**
	 * Column Info
	 * @return ftEndDt
	 */
	public String getFtEndDt() {
		return this.ftEndDt;
	}
	
	/**
	 * Column Info
	 * @return toMvmtDt
	 */
	public String getToMvmtDt() {
		return this.toMvmtDt;
	}
	

	/**
	 * Column Info
	 * @param invAmount
	 */
	public void setInvAmount(String invAmount) {
		this.invAmount = invAmount;
	}
	
	/**
	 * Column Info
	 * @param invRtAmt
	 */
	public void setInvRtAmt(String invRtAmt) {
		this.invRtAmt = invRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ftCmncDt
	 */
	public void setFtCmncDt(String ftCmncDt) {
		this.ftCmncDt = ftCmncDt;
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
	 * @param chgCurrCd
	 */
	public void setChgCurrCd(String chgCurrCd) {
		this.chgCurrCd = chgCurrCd;
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
	 * @param ftDys
	 */
	public void setFtDys(String ftDys) {
		this.ftDys = ftDys;
	}
	
	/**
	 * Column Info
	 * @param rtOvrDys
	 */
	public void setRtOvrDys(String rtOvrDys) {
		this.rtOvrDys = rtOvrDys;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtDt
	 */
	public void setFmMvmtDt(String fmMvmtDt) {
		this.fmMvmtDt = fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param ftOvrUndDys
	 */
	public void setFtOvrUndDys(String ftOvrUndDys) {
		this.ftOvrUndDys = ftOvrUndDys;
	}
	
	/**
	 * Column Info
	 * @param ftEndDt
	 */
	public void setFtEndDt(String ftEndDt) {
		this.ftEndDt = ftEndDt;
	}
	
	/**
	 * Column Info
	 * @param toMvmtDt
	 */
	public void setToMvmtDt(String toMvmtDt) {
		this.toMvmtDt = toMvmtDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInvAmount(JSPUtil.getParameter(request, "inv_amount", ""));
		setInvRtAmt(JSPUtil.getParameter(request, "inv_rt_amt", ""));
		setFtCmncDt(JSPUtil.getParameter(request, "ft_cmnc_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setChgCurrCd(JSPUtil.getParameter(request, "chg_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFtDys(JSPUtil.getParameter(request, "ft_dys", ""));
		setRtOvrDys(JSPUtil.getParameter(request, "rt_ovr_dys", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, "fm_mvmt_dt", ""));
		setFtOvrUndDys(JSPUtil.getParameter(request, "ft_ovr_und_dys", ""));
		setFtEndDt(JSPUtil.getParameter(request, "ft_end_dt", ""));
		setToMvmtDt(JSPUtil.getParameter(request, "to_mvmt_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceIssueRDPreviewVO[]
	 */
	public InvoiceIssueRDPreviewVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceIssueRDPreviewVO[]
	 */
	public InvoiceIssueRDPreviewVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceIssueRDPreviewVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invAmount = (JSPUtil.getParameter(request, prefix	+ "inv_amount", length));
			String[] invRtAmt = (JSPUtil.getParameter(request, prefix	+ "inv_rt_amt", length));
			String[] ftCmncDt = (JSPUtil.getParameter(request, prefix	+ "ft_cmnc_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chgCurrCd = (JSPUtil.getParameter(request, prefix	+ "chg_curr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] rtOvrDys = (JSPUtil.getParameter(request, prefix	+ "rt_ovr_dys", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] ftOvrUndDys = (JSPUtil.getParameter(request, prefix	+ "ft_ovr_und_dys", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceIssueRDPreviewVO();
				if (invAmount[i] != null)
					model.setInvAmount(invAmount[i]);
				if (invRtAmt[i] != null)
					model.setInvRtAmt(invRtAmt[i]);
				if (ftCmncDt[i] != null)
					model.setFtCmncDt(ftCmncDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chgCurrCd[i] != null)
					model.setChgCurrCd(chgCurrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (rtOvrDys[i] != null)
					model.setRtOvrDys(rtOvrDys[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (ftOvrUndDys[i] != null)
					model.setFtOvrUndDys(ftOvrUndDys[i]);
				if (ftEndDt[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceIssueRDPreviewVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceIssueRDPreviewVO[]
	 */
	public InvoiceIssueRDPreviewVO[] getInvoiceIssueRDPreviewVOs(){
		InvoiceIssueRDPreviewVO[] vos = (InvoiceIssueRDPreviewVO[])models.toArray(new InvoiceIssueRDPreviewVO[models.size()]);
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
		this.invAmount = this.invAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRtAmt = this.invRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftCmncDt = this.ftCmncDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCurrCd = this.chgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtOvrDys = this.rtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftOvrUndDys = this.ftOvrUndDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
