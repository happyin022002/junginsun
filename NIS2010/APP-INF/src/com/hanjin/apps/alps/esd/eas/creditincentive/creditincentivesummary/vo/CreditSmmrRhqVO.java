/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditSmmrRhqVO.java
*@FileTitle : CreditSmmrRhqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.10
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.10 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.vo;

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
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CreditSmmrRhqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CreditSmmrRhqVO> models = new ArrayList<CreditSmmrRhqVO>();
	
	/* Column Info */
	private String balAmt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String orderSeq = null;
	/* Column Info */
	private String rcvAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String crSrc = null;
	/* Column Info */
	private String estmAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CreditSmmrRhqVO() {}

	public CreditSmmrRhqVO(String ibflag, String pagerows, String orderSeq, String balAmt, String ofcCd, String rcvAmt, String rhqCd, String crSrc, String estmAmt) {
		this.balAmt = balAmt;
		this.ofcCd = ofcCd;
		this.orderSeq = orderSeq;
		this.rcvAmt = rcvAmt;
		this.ibflag = ibflag;
		this.rhqCd = rhqCd;
		this.crSrc = crSrc;
		this.estmAmt = estmAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bal_amt", getBalAmt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("order_seq", getOrderSeq());
		this.hashColumns.put("rcv_amt", getRcvAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("cr_src", getCrSrc());
		this.hashColumns.put("estm_amt", getEstmAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bal_amt", "balAmt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("order_seq", "orderSeq");
		this.hashFields.put("rcv_amt", "rcvAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("cr_src", "crSrc");
		this.hashFields.put("estm_amt", "estmAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return balAmt
	 */
	public String getBalAmt() {
		return this.balAmt;
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
	 * @return orderSeq
	 */
	public String getOrderSeq() {
		return this.orderSeq;
	}
	
	/**
	 * Column Info
	 * @return rcvAmt
	 */
	public String getRcvAmt() {
		return this.rcvAmt;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return crSrc
	 */
	public String getCrSrc() {
		return this.crSrc;
	}
	
	/**
	 * Column Info
	 * @return estmAmt
	 */
	public String getEstmAmt() {
		return this.estmAmt;
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
	 * @param balAmt
	 */
	public void setBalAmt(String balAmt) {
		this.balAmt = balAmt;
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
	 * @param orderSeq
	 */
	public void setOrderSeq(String orderSeq) {
		this.orderSeq = orderSeq;
	}
	
	/**
	 * Column Info
	 * @param rcvAmt
	 */
	public void setRcvAmt(String rcvAmt) {
		this.rcvAmt = rcvAmt;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param crSrc
	 */
	public void setCrSrc(String crSrc) {
		this.crSrc = crSrc;
	}
	
	/**
	 * Column Info
	 * @param estmAmt
	 */
	public void setEstmAmt(String estmAmt) {
		this.estmAmt = estmAmt;
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
		setBalAmt(JSPUtil.getParameter(request, prefix + "bal_amt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setOrderSeq(JSPUtil.getParameter(request, prefix + "order_seq", ""));
		setRcvAmt(JSPUtil.getParameter(request, prefix + "rcv_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setCrSrc(JSPUtil.getParameter(request, prefix + "cr_src", ""));
		setEstmAmt(JSPUtil.getParameter(request, prefix + "estm_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreditSmmrRhqVO[]
	 */
	public CreditSmmrRhqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreditSmmrRhqVO[]
	 */
	public CreditSmmrRhqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreditSmmrRhqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] balAmt = (JSPUtil.getParameter(request, prefix	+ "bal_amt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] orderSeq = (JSPUtil.getParameter(request, prefix	+ "order_seq", length));
			String[] rcvAmt = (JSPUtil.getParameter(request, prefix	+ "rcv_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] crSrc = (JSPUtil.getParameter(request, prefix	+ "cr_src", length));
			String[] estmAmt = (JSPUtil.getParameter(request, prefix	+ "estm_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CreditSmmrRhqVO();
				if (balAmt[i] != null)
					model.setBalAmt(balAmt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (orderSeq[i] != null)
					model.setOrderSeq(orderSeq[i]);
				if (rcvAmt[i] != null)
					model.setRcvAmt(rcvAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (crSrc[i] != null)
					model.setCrSrc(crSrc[i]);
				if (estmAmt[i] != null)
					model.setEstmAmt(estmAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreditSmmrRhqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreditSmmrRhqVO[]
	 */
	public CreditSmmrRhqVO[] getCreditSmmrRhqVOs(){
		CreditSmmrRhqVO[] vos = (CreditSmmrRhqVO[])models.toArray(new CreditSmmrRhqVO[models.size()]);
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
		this.balAmt = this.balAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderSeq = this.orderSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvAmt = this.rcvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crSrc = this.crSrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmAmt = this.estmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
