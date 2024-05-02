/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceEntryCondVO.java
*@FileTitle : InvoiceEntryCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo;

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

public class InvoiceEntryCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceEntryCondVO> models = new ArrayList<InvoiceEntryCondVO>();
	
	/* Column Info */
	private String invFrDt = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String apPayGrpLuCd = null;
	/* Column Info */
	private String attrCtnt1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrNo = null;
	/* Column Info */
	private String invTpLuCd = null;
	/* Column Info */
	private String apInvSrcCd = null;
	/* Column Info */
	private String glFrDt = null;
	/* Column Info */
	private String invToDt = null;
	/* Column Info */
	private String glToDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvoiceEntryCondVO() {}

	public InvoiceEntryCondVO(String ibflag, String pagerows, String invFrDt, String invCurrCd, String invNo, String ofcCd, String apPayGrpLuCd, String attrCtnt1, String vndrNo, String apInvSrcCd, String glFrDt, String invToDt, String glToDt, String invTpLuCd) {
		this.invFrDt = invFrDt;
		this.invCurrCd = invCurrCd;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.ofcCd = ofcCd;
		this.apPayGrpLuCd = apPayGrpLuCd;
		this.attrCtnt1 = attrCtnt1;
		this.ibflag = ibflag;
		this.vndrNo = vndrNo;
		this.invTpLuCd = invTpLuCd;
		this.apInvSrcCd = apInvSrcCd;
		this.glFrDt = glFrDt;
		this.invToDt = invToDt;
		this.glToDt = glToDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_fr_dt", getInvFrDt());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ap_pay_grp_lu_cd", getApPayGrpLuCd());
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("inv_tp_lu_cd", getInvTpLuCd());
		this.hashColumns.put("ap_inv_src_cd", getApInvSrcCd());
		this.hashColumns.put("gl_fr_dt", getGlFrDt());
		this.hashColumns.put("inv_to_dt", getInvToDt());
		this.hashColumns.put("gl_to_dt", getGlToDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_fr_dt", "invFrDt");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ap_pay_grp_lu_cd", "apPayGrpLuCd");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("inv_tp_lu_cd", "invTpLuCd");
		this.hashFields.put("ap_inv_src_cd", "apInvSrcCd");
		this.hashFields.put("gl_fr_dt", "glFrDt");
		this.hashFields.put("inv_to_dt", "invToDt");
		this.hashFields.put("gl_to_dt", "glToDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invFrDt
	 */
	public String getInvFrDt() {
		return this.invFrDt;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return apPayGrpLuCd
	 */
	public String getApPayGrpLuCd() {
		return this.apPayGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt1
	 */
	public String getAttrCtnt1() {
		return this.attrCtnt1;
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
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
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
	 * @return apInvSrcCd
	 */
	public String getApInvSrcCd() {
		return this.apInvSrcCd;
	}
	
	/**
	 * Column Info
	 * @return glFrDt
	 */
	public String getGlFrDt() {
		return this.glFrDt;
	}
	
	/**
	 * Column Info
	 * @return invToDt
	 */
	public String getInvToDt() {
		return this.invToDt;
	}
	
	/**
	 * Column Info
	 * @return glToDt
	 */
	public String getGlToDt() {
		return this.glToDt;
	}
	

	/**
	 * Column Info
	 * @param invFrDt
	 */
	public void setInvFrDt(String invFrDt) {
		this.invFrDt = invFrDt;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param apPayGrpLuCd
	 */
	public void setApPayGrpLuCd(String apPayGrpLuCd) {
		this.apPayGrpLuCd = apPayGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt1
	 */
	public void setAttrCtnt1(String attrCtnt1) {
		this.attrCtnt1 = attrCtnt1;
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
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
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
	 * @param apInvSrcCd
	 */
	public void setApInvSrcCd(String apInvSrcCd) {
		this.apInvSrcCd = apInvSrcCd;
	}
	
	/**
	 * Column Info
	 * @param glFrDt
	 */
	public void setGlFrDt(String glFrDt) {
		this.glFrDt = glFrDt;
	}
	
	/**
	 * Column Info
	 * @param invToDt
	 */
	public void setInvToDt(String invToDt) {
		this.invToDt = invToDt;
	}
	
	/**
	 * Column Info
	 * @param glToDt
	 */
	public void setGlToDt(String glToDt) {
		this.glToDt = glToDt;
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
		setInvFrDt(JSPUtil.getParameter(request, prefix + "inv_fr_dt", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setApPayGrpLuCd(JSPUtil.getParameter(request, prefix + "ap_pay_grp_lu_cd", ""));
		setAttrCtnt1(JSPUtil.getParameter(request, prefix + "attr_ctnt1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setInvTpLuCd(JSPUtil.getParameter(request, prefix + "inv_tp_lu_cd", ""));
		setApInvSrcCd(JSPUtil.getParameter(request, prefix + "ap_inv_src_cd", ""));
		setGlFrDt(JSPUtil.getParameter(request, prefix + "gl_fr_dt", ""));
		setInvToDt(JSPUtil.getParameter(request, prefix + "inv_to_dt", ""));
		setGlToDt(JSPUtil.getParameter(request, prefix + "gl_to_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceEntryCondVO[]
	 */
	public InvoiceEntryCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceEntryCondVO[]
	 */
	public InvoiceEntryCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceEntryCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invFrDt = (JSPUtil.getParameter(request, prefix	+ "inv_fr_dt", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] apPayGrpLuCd = (JSPUtil.getParameter(request, prefix	+ "ap_pay_grp_lu_cd", length));
			String[] attrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] invTpLuCd = (JSPUtil.getParameter(request, prefix	+ "inv_tp_lu_cd", length));
			String[] apInvSrcCd = (JSPUtil.getParameter(request, prefix	+ "ap_inv_src_cd", length));
			String[] glFrDt = (JSPUtil.getParameter(request, prefix	+ "gl_fr_dt", length));
			String[] invToDt = (JSPUtil.getParameter(request, prefix	+ "inv_to_dt", length));
			String[] glToDt = (JSPUtil.getParameter(request, prefix	+ "gl_to_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceEntryCondVO();
				if (invFrDt[i] != null)
					model.setInvFrDt(invFrDt[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (apPayGrpLuCd[i] != null)
					model.setApPayGrpLuCd(apPayGrpLuCd[i]);
				if (attrCtnt1[i] != null)
					model.setAttrCtnt1(attrCtnt1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (invTpLuCd[i] != null)
					model.setInvTpLuCd(invTpLuCd[i]);
				if (apInvSrcCd[i] != null)
					model.setApInvSrcCd(apInvSrcCd[i]);
				if (glFrDt[i] != null)
					model.setGlFrDt(glFrDt[i]);
				if (invToDt[i] != null)
					model.setInvToDt(invToDt[i]);
				if (glToDt[i] != null)
					model.setGlToDt(glToDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceEntryCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceEntryCondVO[]
	 */
	public InvoiceEntryCondVO[] getInvoiceEntryCondVOs(){
		InvoiceEntryCondVO[] vos = (InvoiceEntryCondVO[])models.toArray(new InvoiceEntryCondVO[models.size()]);
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
		this.invFrDt = this.invFrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayGrpLuCd = this.apPayGrpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 = this.attrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTpLuCd = this.invTpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apInvSrcCd = this.apInvSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glFrDt = this.glFrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invToDt = this.invToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glToDt = this.glToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
