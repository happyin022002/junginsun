/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OtsInquiryBySummaryVO.java
*@FileTitle : OtsInquiryBySummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.16  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OtsInquiryBySummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OtsInquiryBySummaryVO> models = new ArrayList<OtsInquiryBySummaryVO>();
	
	/* Column Info */
	private String cticyn = null;
	/* Column Info */
	private String dmofyn = null;
	/* Column Info */
	private String payern = null;
	/* Column Info */
	private String bllamt = null;
	/* Column Info */
	private String useflg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctocyn = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invocr = null;
	/* Column Info */
	private String payerc = null;
	/* Column Info */
	private String invocn = null;
	/* Column Info */
	private String taxamt = null;
	/* Column Info */
	private String dticyn = null;
	/* Column Info */
	private String dtocyn = null;
	/* Column Info */
	private String totamt = null;
	/* Column Info */
	private String dmifyn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OtsInquiryBySummaryVO() {}

	public OtsInquiryBySummaryVO(String ibflag, String pagerows, String payerc, String payern, String invocn, String invocr, String bllamt, String taxamt, String totamt, String useflg, String dmifyn, String dticyn, String dmofyn, String dtocyn, String cticyn, String ctocyn) {
		this.cticyn = cticyn;
		this.dmofyn = dmofyn;
		this.payern = payern;
		this.bllamt = bllamt;
		this.useflg = useflg;
		this.pagerows = pagerows;
		this.ctocyn = ctocyn;
		this.ibflag = ibflag;
		this.invocr = invocr;
		this.payerc = payerc;
		this.invocn = invocn;
		this.taxamt = taxamt;
		this.dticyn = dticyn;
		this.dtocyn = dtocyn;
		this.totamt = totamt;
		this.dmifyn = dmifyn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cticyn", getCticyn());
		this.hashColumns.put("dmofyn", getDmofyn());
		this.hashColumns.put("payern", getPayern());
		this.hashColumns.put("bllamt", getBllamt());
		this.hashColumns.put("useflg", getUseflg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctocyn", getCtocyn());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("invocr", getInvocr());
		this.hashColumns.put("payerc", getPayerc());
		this.hashColumns.put("invocn", getInvocn());
		this.hashColumns.put("taxamt", getTaxamt());
		this.hashColumns.put("dticyn", getDticyn());
		this.hashColumns.put("dtocyn", getDtocyn());
		this.hashColumns.put("totamt", getTotamt());
		this.hashColumns.put("dmifyn", getDmifyn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cticyn", "cticyn");
		this.hashFields.put("dmofyn", "dmofyn");
		this.hashFields.put("payern", "payern");
		this.hashFields.put("bllamt", "bllamt");
		this.hashFields.put("useflg", "useflg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctocyn", "ctocyn");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("invocr", "invocr");
		this.hashFields.put("payerc", "payerc");
		this.hashFields.put("invocn", "invocn");
		this.hashFields.put("taxamt", "taxamt");
		this.hashFields.put("dticyn", "dticyn");
		this.hashFields.put("dtocyn", "dtocyn");
		this.hashFields.put("totamt", "totamt");
		this.hashFields.put("dmifyn", "dmifyn");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cticyn
	 */
	public String getCticyn() {
		return this.cticyn;
	}
	
	/**
	 * Column Info
	 * @return dmofyn
	 */
	public String getDmofyn() {
		return this.dmofyn;
	}
	
	/**
	 * Column Info
	 * @return payern
	 */
	public String getPayern() {
		return this.payern;
	}
	
	/**
	 * Column Info
	 * @return bllamt
	 */
	public String getBllamt() {
		return this.bllamt;
	}
	
	/**
	 * Column Info
	 * @return useflg
	 */
	public String getUseflg() {
		return this.useflg;
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
	 * @return ctocyn
	 */
	public String getCtocyn() {
		return this.ctocyn;
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
	 * @return invocr
	 */
	public String getInvocr() {
		return this.invocr;
	}
	
	/**
	 * Column Info
	 * @return payerc
	 */
	public String getPayerc() {
		return this.payerc;
	}
	
	/**
	 * Column Info
	 * @return invocn
	 */
	public String getInvocn() {
		return this.invocn;
	}
	
	/**
	 * Column Info
	 * @return taxamt
	 */
	public String getTaxamt() {
		return this.taxamt;
	}
	
	/**
	 * Column Info
	 * @return dticyn
	 */
	public String getDticyn() {
		return this.dticyn;
	}
	
	/**
	 * Column Info
	 * @return dtocyn
	 */
	public String getDtocyn() {
		return this.dtocyn;
	}
	
	/**
	 * Column Info
	 * @return totamt
	 */
	public String getTotamt() {
		return this.totamt;
	}
	
	/**
	 * Column Info
	 * @return dmifyn
	 */
	public String getDmifyn() {
		return this.dmifyn;
	}
	

	/**
	 * Column Info
	 * @param cticyn
	 */
	public void setCticyn(String cticyn) {
		this.cticyn = cticyn;
	}
	
	/**
	 * Column Info
	 * @param dmofyn
	 */
	public void setDmofyn(String dmofyn) {
		this.dmofyn = dmofyn;
	}
	
	/**
	 * Column Info
	 * @param payern
	 */
	public void setPayern(String payern) {
		this.payern = payern;
	}
	
	/**
	 * Column Info
	 * @param bllamt
	 */
	public void setBllamt(String bllamt) {
		this.bllamt = bllamt;
	}
	
	/**
	 * Column Info
	 * @param useflg
	 */
	public void setUseflg(String useflg) {
		this.useflg = useflg;
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
	 * @param ctocyn
	 */
	public void setCtocyn(String ctocyn) {
		this.ctocyn = ctocyn;
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
	 * @param invocr
	 */
	public void setInvocr(String invocr) {
		this.invocr = invocr;
	}
	
	/**
	 * Column Info
	 * @param payerc
	 */
	public void setPayerc(String payerc) {
		this.payerc = payerc;
	}
	
	/**
	 * Column Info
	 * @param invocn
	 */
	public void setInvocn(String invocn) {
		this.invocn = invocn;
	}
	
	/**
	 * Column Info
	 * @param taxamt
	 */
	public void setTaxamt(String taxamt) {
		this.taxamt = taxamt;
	}
	
	/**
	 * Column Info
	 * @param dticyn
	 */
	public void setDticyn(String dticyn) {
		this.dticyn = dticyn;
	}
	
	/**
	 * Column Info
	 * @param dtocyn
	 */
	public void setDtocyn(String dtocyn) {
		this.dtocyn = dtocyn;
	}
	
	/**
	 * Column Info
	 * @param totamt
	 */
	public void setTotamt(String totamt) {
		this.totamt = totamt;
	}
	
	/**
	 * Column Info
	 * @param dmifyn
	 */
	public void setDmifyn(String dmifyn) {
		this.dmifyn = dmifyn;
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
		setCticyn(JSPUtil.getParameter(request, prefix + "cticyn", ""));
		setDmofyn(JSPUtil.getParameter(request, prefix + "dmofyn", ""));
		setPayern(JSPUtil.getParameter(request, prefix + "payern", ""));
		setBllamt(JSPUtil.getParameter(request, prefix + "bllamt", ""));
		setUseflg(JSPUtil.getParameter(request, prefix + "useflg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtocyn(JSPUtil.getParameter(request, prefix + "ctocyn", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvocr(JSPUtil.getParameter(request, prefix + "invocr", ""));
		setPayerc(JSPUtil.getParameter(request, prefix + "payerc", ""));
		setInvocn(JSPUtil.getParameter(request, prefix + "invocn", ""));
		setTaxamt(JSPUtil.getParameter(request, prefix + "taxamt", ""));
		setDticyn(JSPUtil.getParameter(request, prefix + "dticyn", ""));
		setDtocyn(JSPUtil.getParameter(request, prefix + "dtocyn", ""));
		setTotamt(JSPUtil.getParameter(request, prefix + "totamt", ""));
		setDmifyn(JSPUtil.getParameter(request, prefix + "dmifyn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OtsInquiryBySummaryVO[]
	 */
	public OtsInquiryBySummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OtsInquiryBySummaryVO[]
	 */
	public OtsInquiryBySummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OtsInquiryBySummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cticyn = (JSPUtil.getParameter(request, prefix	+ "cticyn", length));
			String[] dmofyn = (JSPUtil.getParameter(request, prefix	+ "dmofyn", length));
			String[] payern = (JSPUtil.getParameter(request, prefix	+ "payern", length));
			String[] bllamt = (JSPUtil.getParameter(request, prefix	+ "bllamt", length));
			String[] useflg = (JSPUtil.getParameter(request, prefix	+ "useflg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctocyn = (JSPUtil.getParameter(request, prefix	+ "ctocyn", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invocr = (JSPUtil.getParameter(request, prefix	+ "invocr", length));
			String[] payerc = (JSPUtil.getParameter(request, prefix	+ "payerc", length));
			String[] invocn = (JSPUtil.getParameter(request, prefix	+ "invocn", length));
			String[] taxamt = (JSPUtil.getParameter(request, prefix	+ "taxamt", length));
			String[] dticyn = (JSPUtil.getParameter(request, prefix	+ "dticyn", length));
			String[] dtocyn = (JSPUtil.getParameter(request, prefix	+ "dtocyn", length));
			String[] totamt = (JSPUtil.getParameter(request, prefix	+ "totamt", length));
			String[] dmifyn = (JSPUtil.getParameter(request, prefix	+ "dmifyn", length));
			
			for (int i = 0; i < length; i++) {
				model = new OtsInquiryBySummaryVO();
				if (cticyn[i] != null)
					model.setCticyn(cticyn[i]);
				if (dmofyn[i] != null)
					model.setDmofyn(dmofyn[i]);
				if (payern[i] != null)
					model.setPayern(payern[i]);
				if (bllamt[i] != null)
					model.setBllamt(bllamt[i]);
				if (useflg[i] != null)
					model.setUseflg(useflg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctocyn[i] != null)
					model.setCtocyn(ctocyn[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invocr[i] != null)
					model.setInvocr(invocr[i]);
				if (payerc[i] != null)
					model.setPayerc(payerc[i]);
				if (invocn[i] != null)
					model.setInvocn(invocn[i]);
				if (taxamt[i] != null)
					model.setTaxamt(taxamt[i]);
				if (dticyn[i] != null)
					model.setDticyn(dticyn[i]);
				if (dtocyn[i] != null)
					model.setDtocyn(dtocyn[i]);
				if (totamt[i] != null)
					model.setTotamt(totamt[i]);
				if (dmifyn[i] != null)
					model.setDmifyn(dmifyn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOtsInquiryBySummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OtsInquiryBySummaryVO[]
	 */
	public OtsInquiryBySummaryVO[] getOtsInquiryBySummaryVOs(){
		OtsInquiryBySummaryVO[] vos = (OtsInquiryBySummaryVO[])models.toArray(new OtsInquiryBySummaryVO[models.size()]);
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
		this.cticyn = this.cticyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmofyn = this.dmofyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payern = this.payern .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bllamt = this.bllamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useflg = this.useflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctocyn = this.ctocyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invocr = this.invocr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerc = this.payerc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invocn = this.invocn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxamt = this.taxamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dticyn = this.dticyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtocyn = this.dtocyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totamt = this.totamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmifyn = this.dmifyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
