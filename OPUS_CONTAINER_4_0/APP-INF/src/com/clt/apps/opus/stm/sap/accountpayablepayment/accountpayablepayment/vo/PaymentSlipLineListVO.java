/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PaymentSlipLineListVO.java
*@FileTitle : PaymentSlipLineListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo;

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

public class PaymentSlipLineListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentSlipLineListVO> models = new ArrayList<PaymentSlipLineListVO>();
	
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String glDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String post = null;
	/* Column Info */
	private String invTpLuCd = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String paySeq = null;
	/* Column Info */
	private String invDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PaymentSlipLineListVO() {}

	public PaymentSlipLineListVO(String ibflag, String pagerows, String paySeq, String glDt, String post, String payAmt, String invNo, String invTpLuCd, String invDt, String currCd, String invAmt, String invDesc) {
		this.invNo = invNo;
		this.invDesc = invDesc;
		this.glDt = glDt;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.post = post;
		this.invTpLuCd = invTpLuCd;
		this.payAmt = payAmt;
		this.invAmt = invAmt;
		this.paySeq = paySeq;
		this.invDt = invDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("post", getPost());
		this.hashColumns.put("inv_tp_lu_cd", getInvTpLuCd());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("pay_seq", getPaySeq());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("post", "post");
		this.hashFields.put("inv_tp_lu_cd", "invTpLuCd");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("pay_seq", "paySeq");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return invDesc
	 */
	public String getInvDesc() {
		return this.invDesc;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
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
	 * @return post
	 */
	public String getPost() {
		return this.post;
	}
	
	/**
	 * Column Info
	 * @return invTpLuCd
	 */
	public String getInvTpLuCd() {
		return this.invTpLuCd;
	}
	
	/**
	 * Column Info
	 * @return payAmt
	 */
	public String getPayAmt() {
		return this.payAmt;
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
	 * @return paySeq
	 */
	public String getPaySeq() {
		return this.paySeq;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
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
	 * @param post
	 */
	public void setPost(String post) {
		this.post = post;
	}
	
	/**
	 * Column Info
	 * @param invTpLuCd
	 */
	public void setInvTpLuCd(String invTpLuCd) {
		this.invTpLuCd = invTpLuCd;
	}
	
	/**
	 * Column Info
	 * @param payAmt
	 */
	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
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
	 * @param paySeq
	 */
	public void setPaySeq(String paySeq) {
		this.paySeq = paySeq;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
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
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPost(JSPUtil.getParameter(request, prefix + "post", ""));
		setInvTpLuCd(JSPUtil.getParameter(request, prefix + "inv_tp_lu_cd", ""));
		setPayAmt(JSPUtil.getParameter(request, prefix + "pay_amt", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setPaySeq(JSPUtil.getParameter(request, prefix + "pay_seq", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentSlipLineListVO[]
	 */
	public PaymentSlipLineListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentSlipLineListVO[]
	 */
	public PaymentSlipLineListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentSlipLineListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] post = (JSPUtil.getParameter(request, prefix	+ "post", length));
			String[] invTpLuCd = (JSPUtil.getParameter(request, prefix	+ "inv_tp_lu_cd", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	+ "pay_amt", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] paySeq = (JSPUtil.getParameter(request, prefix	+ "pay_seq", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentSlipLineListVO();
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (post[i] != null)
					model.setPost(post[i]);
				if (invTpLuCd[i] != null)
					model.setInvTpLuCd(invTpLuCd[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (paySeq[i] != null)
					model.setPaySeq(paySeq[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentSlipLineListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentSlipLineListVO[]
	 */
	public PaymentSlipLineListVO[] getPaymentSlipLineListVOs(){
		PaymentSlipLineListVO[] vos = (PaymentSlipLineListVO[])models.toArray(new PaymentSlipLineListVO[models.size()]);
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
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.post = this.post .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTpLuCd = this.invTpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paySeq = this.paySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
