/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtFaxEmlSndHisParmVO.java
*@FileTitle : DmtFaxEmlSndHisParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.12.10 문중철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtFaxEmlSndHisParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtFaxEmlSndHisParmVO> models = new ArrayList<DmtFaxEmlSndHisParmVO>();
	
	/* Column Info */
	private String sndrcdd = null;
	/* Column Info */
	private String sndfrdt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String seloptt = null;
	/* Column Info */
	private String invoice = null;
	/* Column Info */
	private String payercd = null;
	/* Column Info */
	private String sndtodt = null;
	/* Column Info */
	private String payernm = null;
	/* Column Info */
	private String sndrnmm = null;
	/* Column Info */
	private String sndoffc = null;
	/* Column Info */
	private String shttppp = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String popupYn = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtFaxEmlSndHisParmVO() {}

	public DmtFaxEmlSndHisParmVO(String ibflag, String pagerows, String sndrcdd, String sndfrdt, String seloptt, String invoice, String payercd, String sndtodt, String payernm, String sndrnmm, String sndoffc, String shttppp, String popupYn) {
		this.sndrcdd = sndrcdd;
		this.sndfrdt = sndfrdt;
		this.ibflag = ibflag;
		this.seloptt = seloptt;
		this.invoice = invoice;
		this.payercd = payercd;
		this.sndtodt = sndtodt;
		this.payernm = payernm;
		this.sndrnmm = sndrnmm;
		this.sndoffc = sndoffc;
		this.shttppp = shttppp;
		this.popupYn = popupYn;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sndrcdd", getSndrcdd());
		this.hashColumns.put("sndfrdt", getSndfrdt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("seloptt", getSeloptt());
		this.hashColumns.put("invoice", getInvoice());
		this.hashColumns.put("payercd", getPayercd());
		this.hashColumns.put("sndtodt", getSndtodt());
		this.hashColumns.put("payernm", getPayernm());
		this.hashColumns.put("sndrnmm", getSndrnmm());
		this.hashColumns.put("sndoffc", getSndoffc());
		this.hashColumns.put("shttppp", getShttppp());
		this.hashColumns.put("popup_yn", getPopupYn());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sndrcdd", "sndrcdd");
		this.hashFields.put("sndfrdt", "sndfrdt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("seloptt", "seloptt");
		this.hashFields.put("invoice", "invoice");
		this.hashFields.put("payercd", "payercd");
		this.hashFields.put("sndtodt", "sndtodt");
		this.hashFields.put("payernm", "payernm");
		this.hashFields.put("sndrnmm", "sndrnmm");
		this.hashFields.put("sndoffc", "sndoffc");
		this.hashFields.put("shttppp", "shttppp");
		this.hashFields.put("popup_yn", "popupYn");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sndrcdd
	 */
	public String getSndrcdd() {
		return this.sndrcdd;
	}
	
	/**
	 * Column Info
	 * @return sndfrdt
	 */
	public String getSndfrdt() {
		return this.sndfrdt;
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
	 * @return seloptt
	 */
	public String getSeloptt() {
		return this.seloptt;
	}
	
	/**
	 * Column Info
	 * @return invoice
	 */
	public String getInvoice() {
		return this.invoice;
	}
	
	/**
	 * Column Info
	 * @return payercd
	 */
	public String getPayercd() {
		return this.payercd;
	}
	
	/**
	 * Column Info
	 * @return sndtodt
	 */
	public String getSndtodt() {
		return this.sndtodt;
	}
	
	/**
	 * Column Info
	 * @return payernm
	 */
	public String getPayernm() {
		return this.payernm;
	}
	
	/**
	 * Column Info
	 * @return sndrnmm
	 */
	public String getSndrnmm() {
		return this.sndrnmm;
	}
	
	/**
	 * Column Info
	 * @return sndoffc
	 */
	public String getSndoffc() {
		return this.sndoffc;
	}
	
	/**
	 * Column Info
	 * @return shttppp
	 */
	public String getShttppp() {
		return this.shttppp;
	}
	
	/**
	 * Column Info
	 * @return popupYn
	 */
	public String getPopupYn() {
		return this.popupYn;
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
	 * @param sndrcdd
	 */
	public void setSndrcdd(String sndrcdd) {
		this.sndrcdd = sndrcdd;
	}
	
	/**
	 * Column Info
	 * @param sndfrdt
	 */
	public void setSndfrdt(String sndfrdt) {
		this.sndfrdt = sndfrdt;
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
	 * @param seloptt
	 */
	public void setSeloptt(String seloptt) {
		this.seloptt = seloptt;
	}
	
	/**
	 * Column Info
	 * @param invoice
	 */
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	
	/**
	 * Column Info
	 * @param payercd
	 */
	public void setPayercd(String payercd) {
		this.payercd = payercd;
	}
	
	/**
	 * Column Info
	 * @param sndtodt
	 */
	public void setSndtodt(String sndtodt) {
		this.sndtodt = sndtodt;
	}
	
	/**
	 * Column Info
	 * @param payernm
	 */
	public void setPayernm(String payernm) {
		this.payernm = payernm;
	}
	
	/**
	 * Column Info
	 * @param sndrnmm
	 */
	public void setSndrnmm(String sndrnmm) {
		this.sndrnmm = sndrnmm;
	}
	
	/**
	 * Column Info
	 * @param sndoffc
	 */
	public void setSndoffc(String sndoffc) {
		this.sndoffc = sndoffc;
	}
	
	/**
	 * Column Info
	 * @param shttppp
	 */
	public void setShttppp(String shttppp) {
		this.shttppp = shttppp;
	}
	
	/**
	 * Column Info
	 * @param popupYn
	 */
	public void setPopupYn(String popupYn) {
		this.popupYn = popupYn;
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
		setSndrcdd(JSPUtil.getParameter(request, "sndrcdd", ""));
		setSndfrdt(JSPUtil.getParameter(request, "sndfrdt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSeloptt(JSPUtil.getParameter(request, "seloptt", ""));
		setInvoice(JSPUtil.getParameter(request, "invoice", ""));
		setPayercd(JSPUtil.getParameter(request, "payercd", ""));
		setSndtodt(JSPUtil.getParameter(request, "sndtodt", ""));
		setPayernm(JSPUtil.getParameter(request, "payernm", ""));
		setSndrnmm(JSPUtil.getParameter(request, "sndrnmm", ""));
		setSndoffc(JSPUtil.getParameter(request, "sndoffc", ""));
		setShttppp(JSPUtil.getParameter(request, "shttppp", ""));
		setPopupYn(JSPUtil.getParameter(request, "popup_yn", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtFaxEmlSndHisParmVO[]
	 */
	public DmtFaxEmlSndHisParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtFaxEmlSndHisParmVO[]
	 */
	public DmtFaxEmlSndHisParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtFaxEmlSndHisParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sndrcdd = (JSPUtil.getParameter(request, prefix	+ "sndrcdd", length));
			String[] sndfrdt = (JSPUtil.getParameter(request, prefix	+ "sndfrdt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] seloptt = (JSPUtil.getParameter(request, prefix	+ "seloptt", length));
			String[] invoice = (JSPUtil.getParameter(request, prefix	+ "invoice", length));
			String[] payercd = (JSPUtil.getParameter(request, prefix	+ "payercd", length));
			String[] sndtodt = (JSPUtil.getParameter(request, prefix	+ "sndtodt", length));
			String[] payernm = (JSPUtil.getParameter(request, prefix	+ "payernm", length));
			String[] sndrnmm = (JSPUtil.getParameter(request, prefix	+ "sndrnmm", length));
			String[] sndoffc = (JSPUtil.getParameter(request, prefix	+ "sndoffc", length));
			String[] shttppp = (JSPUtil.getParameter(request, prefix	+ "shttppp", length));
			String[] popupYn = (JSPUtil.getParameter(request, prefix	+ "popup_yn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtFaxEmlSndHisParmVO();
				if (sndrcdd[i] != null)
					model.setSndrcdd(sndrcdd[i]);
				if (sndfrdt[i] != null)
					model.setSndfrdt(sndfrdt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (seloptt[i] != null)
					model.setSeloptt(seloptt[i]);
				if (invoice[i] != null)
					model.setInvoice(invoice[i]);
				if (payercd[i] != null)
					model.setPayercd(payercd[i]);
				if (sndtodt[i] != null)
					model.setSndtodt(sndtodt[i]);
				if (payernm[i] != null)
					model.setPayernm(payernm[i]);
				if (sndrnmm[i] != null)
					model.setSndrnmm(sndrnmm[i]);
				if (sndoffc[i] != null)
					model.setSndoffc(sndoffc[i]);
				if (shttppp[i] != null)
					model.setShttppp(shttppp[i]);
				if (popupYn[i] != null)
					model.setPopupYn(popupYn[i]);				
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtFaxEmlSndHisParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtFaxEmlSndHisParmVO[]
	 */
	public DmtFaxEmlSndHisParmVO[] getDmtFaxEmlSndHisParmVOs(){
		DmtFaxEmlSndHisParmVO[] vos = (DmtFaxEmlSndHisParmVO[])models.toArray(new DmtFaxEmlSndHisParmVO[models.size()]);
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
		this.sndrcdd = this.sndrcdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndfrdt = this.sndfrdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seloptt = this.seloptt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoice = this.invoice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payercd = this.payercd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndtodt = this.sndtodt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payernm = this.payernm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrnmm = this.sndrnmm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndoffc = this.sndoffc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shttppp = this.shttppp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.popupYn = this.popupYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
