/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceReceiptCondVO.java
*@FileTitle : InvoiceReceiptCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.14  
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

public class InvoiceReceiptCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceReceiptCondVO> models = new ArrayList<InvoiceReceiptCondVO>();
	
	/* Column Info */
	private String invDtFm = null;
	/* Column Info */
	private String glDtFm = null;
	/* Column Info */
	private String invDtTo = null;
	/* Column Info */
	private String attrCtnt15 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String apPayGrpLuCd = null;
	/* Column Info */
	private String currFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String glDtTo = null;
	/* Column Info */
	private String vndrNo = null;
	/* Column Info */
	private String rctFlg = null;
	/* Column Info */
	private String payStsFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvoiceReceiptCondVO() {}

	public InvoiceReceiptCondVO(String ibflag, String pagerows, String ofcCd, String apPayGrpLuCd, String invDtFm, String invDtTo, String invNo, String glDtFm, String glDtTo, String vndrNo, String rctFlg, String currFlg, String payStsFlg, String attrCtnt15) {
		this.invDtFm = invDtFm;
		this.glDtFm = glDtFm;
		this.invDtTo = invDtTo;
		this.attrCtnt15 = attrCtnt15;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.ofcCd = ofcCd;
		this.apPayGrpLuCd = apPayGrpLuCd;
		this.currFlg = currFlg;
		this.ibflag = ibflag;
		this.glDtTo = glDtTo;
		this.vndrNo = vndrNo;
		this.rctFlg = rctFlg;
		this.payStsFlg = payStsFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_dt_fm", getInvDtFm());
		this.hashColumns.put("gl_dt_fm", getGlDtFm());
		this.hashColumns.put("inv_dt_to", getInvDtTo());
		this.hashColumns.put("attr_ctnt15", getAttrCtnt15());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ap_pay_grp_lu_cd", getApPayGrpLuCd());
		this.hashColumns.put("curr_flg", getCurrFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gl_dt_to", getGlDtTo());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("rct_flg", getRctFlg());
		this.hashColumns.put("pay_sts_flg", getPayStsFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_dt_fm", "invDtFm");
		this.hashFields.put("gl_dt_fm", "glDtFm");
		this.hashFields.put("inv_dt_to", "invDtTo");
		this.hashFields.put("attr_ctnt15", "attrCtnt15");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ap_pay_grp_lu_cd", "apPayGrpLuCd");
		this.hashFields.put("curr_flg", "currFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gl_dt_to", "glDtTo");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("rct_flg", "rctFlg");
		this.hashFields.put("pay_sts_flg", "payStsFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invDtFm
	 */
	public String getInvDtFm() {
		return this.invDtFm;
	}
	
	/**
	 * Column Info
	 * @return glDtFm
	 */
	public String getGlDtFm() {
		return this.glDtFm;
	}
	
	/**
	 * Column Info
	 * @return invDtTo
	 */
	public String getInvDtTo() {
		return this.invDtTo;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt15
	 */
	public String getAttrCtnt15() {
		return this.attrCtnt15;
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
	 * @return currFlg
	 */
	public String getCurrFlg() {
		return this.currFlg;
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
	 * @return glDtTo
	 */
	public String getGlDtTo() {
		return this.glDtTo;
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
	 * @return rctFlg
	 */
	public String getRctFlg() {
		return this.rctFlg;
	}
	
	/**
	 * Column Info
	 * @return payStsFlg
	 */
	public String getPayStsFlg() {
		return this.payStsFlg;
	}
	

	/**
	 * Column Info
	 * @param invDtFm
	 */
	public void setInvDtFm(String invDtFm) {
		this.invDtFm = invDtFm;
	}
	
	/**
	 * Column Info
	 * @param glDtFm
	 */
	public void setGlDtFm(String glDtFm) {
		this.glDtFm = glDtFm;
	}
	
	/**
	 * Column Info
	 * @param invDtTo
	 */
	public void setInvDtTo(String invDtTo) {
		this.invDtTo = invDtTo;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt15
	 */
	public void setAttrCtnt15(String attrCtnt15) {
		this.attrCtnt15 = attrCtnt15;
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
	 * @param currFlg
	 */
	public void setCurrFlg(String currFlg) {
		this.currFlg = currFlg;
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
	 * @param glDtTo
	 */
	public void setGlDtTo(String glDtTo) {
		this.glDtTo = glDtTo;
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
	 * @param rctFlg
	 */
	public void setRctFlg(String rctFlg) {
		this.rctFlg = rctFlg;
	}
	
	/**
	 * Column Info
	 * @param payStsFlg
	 */
	public void setPayStsFlg(String payStsFlg) {
		this.payStsFlg = payStsFlg;
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
		setInvDtFm(JSPUtil.getParameter(request, prefix + "inv_dt_fm", ""));
		setGlDtFm(JSPUtil.getParameter(request, prefix + "gl_dt_fm", ""));
		setInvDtTo(JSPUtil.getParameter(request, prefix + "inv_dt_to", ""));
		setAttrCtnt15(JSPUtil.getParameter(request, prefix + "attr_ctnt15", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setApPayGrpLuCd(JSPUtil.getParameter(request, prefix + "ap_pay_grp_lu_cd", ""));
		setCurrFlg(JSPUtil.getParameter(request, prefix + "curr_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGlDtTo(JSPUtil.getParameter(request, prefix + "gl_dt_to", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setRctFlg(JSPUtil.getParameter(request, prefix + "rct_flg", ""));
		setPayStsFlg(JSPUtil.getParameter(request, prefix + "pay_sts_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceReceiptCondVO[]
	 */
	public InvoiceReceiptCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceReceiptCondVO[]
	 */
	public InvoiceReceiptCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceReceiptCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invDtFm = (JSPUtil.getParameter(request, prefix	+ "inv_dt_fm", length));
			String[] glDtFm = (JSPUtil.getParameter(request, prefix	+ "gl_dt_fm", length));
			String[] invDtTo = (JSPUtil.getParameter(request, prefix	+ "inv_dt_to", length));
			String[] attrCtnt15 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt15", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] apPayGrpLuCd = (JSPUtil.getParameter(request, prefix	+ "ap_pay_grp_lu_cd", length));
			String[] currFlg = (JSPUtil.getParameter(request, prefix	+ "curr_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] glDtTo = (JSPUtil.getParameter(request, prefix	+ "gl_dt_to", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] rctFlg = (JSPUtil.getParameter(request, prefix	+ "rct_flg", length));
			String[] payStsFlg = (JSPUtil.getParameter(request, prefix	+ "pay_sts_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceReceiptCondVO();
				if (invDtFm[i] != null)
					model.setInvDtFm(invDtFm[i]);
				if (glDtFm[i] != null)
					model.setGlDtFm(glDtFm[i]);
				if (invDtTo[i] != null)
					model.setInvDtTo(invDtTo[i]);
				if (attrCtnt15[i] != null)
					model.setAttrCtnt15(attrCtnt15[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (apPayGrpLuCd[i] != null)
					model.setApPayGrpLuCd(apPayGrpLuCd[i]);
				if (currFlg[i] != null)
					model.setCurrFlg(currFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (glDtTo[i] != null)
					model.setGlDtTo(glDtTo[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (rctFlg[i] != null)
					model.setRctFlg(rctFlg[i]);
				if (payStsFlg[i] != null)
					model.setPayStsFlg(payStsFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceReceiptCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceReceiptCondVO[]
	 */
	public InvoiceReceiptCondVO[] getInvoiceReceiptCondVOs(){
		InvoiceReceiptCondVO[] vos = (InvoiceReceiptCondVO[])models.toArray(new InvoiceReceiptCondVO[models.size()]);
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
		this.invDtFm = this.invDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDtFm = this.glDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtTo = this.invDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt15 = this.attrCtnt15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayGrpLuCd = this.apPayGrpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currFlg = this.currFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDtTo = this.glDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctFlg = this.rctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payStsFlg = this.payStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
