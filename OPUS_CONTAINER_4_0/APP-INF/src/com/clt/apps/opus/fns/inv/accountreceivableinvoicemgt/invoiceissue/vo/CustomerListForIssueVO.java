/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomerListForIssueVO.java
*@FileTitle : CustomerListForIssueVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomerListForIssueVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomerListForIssueVO> models = new ArrayList<CustomerListForIssueVO>();
	
	/* Column Info */
	private String blSrcNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String targetYn = null;
	/* Column Info */
	private String dfltInvCurrDivCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomerListForIssueVO() {}

	public CustomerListForIssueVO(String ibflag, String pagerows, String actCustCntCd, String actCustSeq, String dfltInvCurrDivCd, String blSrcNo, String targetYn) {
		this.blSrcNo = blSrcNo;
		this.ibflag = ibflag;
		this.actCustSeq = actCustSeq;
		this.actCustCntCd = actCustCntCd;
		this.targetYn = targetYn;
		this.dfltInvCurrDivCd = dfltInvCurrDivCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("target_yn", getTargetYn());
		this.hashColumns.put("dflt_inv_curr_div_cd", getDfltInvCurrDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("target_yn", "targetYn");
		this.hashFields.put("dflt_inv_curr_div_cd", "dfltInvCurrDivCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
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
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return targetYn
	 */
	public String getTargetYn() {
		return this.targetYn;
	}
	
	/**
	 * Column Info
	 * @return dfltInvCurrDivCd
	 */
	public String getDfltInvCurrDivCd() {
		return this.dfltInvCurrDivCd;
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
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
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
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param targetYn
	 */
	public void setTargetYn(String targetYn) {
		this.targetYn = targetYn;
	}
	
	/**
	 * Column Info
	 * @param dfltInvCurrDivCd
	 */
	public void setDfltInvCurrDivCd(String dfltInvCurrDivCd) {
		this.dfltInvCurrDivCd = dfltInvCurrDivCd;
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
		setBlSrcNo(JSPUtil.getParameter(request, prefix + "bl_src_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setActCustCntCd(JSPUtil.getParameter(request, prefix + "act_cust_cnt_cd", ""));
		setTargetYn(JSPUtil.getParameter(request, prefix + "target_yn", ""));
		setDfltInvCurrDivCd(JSPUtil.getParameter(request, prefix + "dflt_inv_curr_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomerListForIssueVO[]
	 */
	public CustomerListForIssueVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomerListForIssueVO[]
	 */
	public CustomerListForIssueVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomerListForIssueVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] targetYn = (JSPUtil.getParameter(request, prefix	+ "target_yn", length));
			String[] dfltInvCurrDivCd = (JSPUtil.getParameter(request, prefix	+ "dflt_inv_curr_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomerListForIssueVO();
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (targetYn[i] != null)
					model.setTargetYn(targetYn[i]);
				if (dfltInvCurrDivCd[i] != null)
					model.setDfltInvCurrDivCd(dfltInvCurrDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomerListForIssueVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomerListForIssueVO[]
	 */
	public CustomerListForIssueVO[] getCustomerListForIssueVOs(){
		CustomerListForIssueVO[] vos = (CustomerListForIssueVO[])models.toArray(new CustomerListForIssueVO[models.size()]);
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
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetYn = this.targetYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltInvCurrDivCd = this.dfltInvCurrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
