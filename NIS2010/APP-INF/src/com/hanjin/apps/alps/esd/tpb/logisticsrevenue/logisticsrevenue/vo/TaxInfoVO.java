/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TaxInfoVO.java
*@FileTitle : TaxInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TaxInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TaxInfoVO> models = new ArrayList<TaxInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String loclTaxRt = null;
	/* Column Info */
	private String idaTaxSeq = null;
	/* Column Info */
	private String expnTax = null;
	/* Column Info */
	private String eduTax = null;
	/* Column Info */
	private String highEduTax = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n2ndLoclTaxRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TaxInfoVO() {}

	public TaxInfoVO(String ibflag, String pagerows, String idaTaxSeq, String expnTax, String eduTax, String highEduTax, String loclTaxRt, String n2ndLoclTaxRt) {
		this.ibflag = ibflag;
		this.loclTaxRt = loclTaxRt;
		this.idaTaxSeq = idaTaxSeq;
		this.expnTax = expnTax;
		this.eduTax = eduTax;
		this.highEduTax = highEduTax;
		this.pagerows = pagerows;
		this.n2ndLoclTaxRt = n2ndLoclTaxRt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("locl_tax_rt", getLoclTaxRt());
		this.hashColumns.put("ida_tax_seq", getIdaTaxSeq());
		this.hashColumns.put("expn_tax", getExpnTax());
		this.hashColumns.put("edu_tax", getEduTax());
		this.hashColumns.put("high_edu_tax", getHighEduTax());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n2nd_locl_tax_rt", getN2ndLoclTaxRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("locl_tax_rt", "loclTaxRt");
		this.hashFields.put("ida_tax_seq", "idaTaxSeq");
		this.hashFields.put("expn_tax", "expnTax");
		this.hashFields.put("edu_tax", "eduTax");
		this.hashFields.put("high_edu_tax", "highEduTax");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n2nd_locl_tax_rt", "n2ndLoclTaxRt");
		return this.hashFields;
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
	 * @return loclTaxRt
	 */
	public String getLoclTaxRt() {
		return this.loclTaxRt;
	}
	
	/**
	 * Column Info
	 * @return idaTaxSeq
	 */
	public String getIdaTaxSeq() {
		return this.idaTaxSeq;
	}
	
	/**
	 * Column Info
	 * @return expnTax
	 */
	public String getExpnTax() {
		return this.expnTax;
	}
	
	/**
	 * Column Info
	 * @return eduTax
	 */
	public String getEduTax() {
		return this.eduTax;
	}
	
	/**
	 * Column Info
	 * @return highEduTax
	 */
	public String getHighEduTax() {
		return this.highEduTax;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param loclTaxRt
	 */
	public void setLoclTaxRt(String loclTaxRt) {
		this.loclTaxRt = loclTaxRt;
	}
	
	/**
	 * Column Info
	 * @param idaTaxSeq
	 */
	public void setIdaTaxSeq(String idaTaxSeq) {
		this.idaTaxSeq = idaTaxSeq;
	}
	
	/**
	 * Column Info
	 * @param expnTax
	 */
	public void setExpnTax(String expnTax) {
		this.expnTax = expnTax;
	}
	
	/**
	 * Column Info
	 * @param eduTax
	 */
	public void setEduTax(String eduTax) {
		this.eduTax = eduTax;
	}
	
	/**
	 * Column Info
	 * @param highEduTax
	 */
	public void setHighEduTax(String highEduTax) {
		this.highEduTax = highEduTax;
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
	 * @return n2ndLoclTaxRt
	 */
	public String getN2ndLoclTaxRt() {
		return this.n2ndLoclTaxRt;
	}
	
	/**
	 * Column Info
	 * @param n2ndLoclTaxRt
	 */
	public void setN2ndLoclTaxRt(String n2ndLoclTaxRt) {
		this.n2ndLoclTaxRt = n2ndLoclTaxRt;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLoclTaxRt(JSPUtil.getParameter(request, prefix + "locl_tax_rt", ""));
		setIdaTaxSeq(JSPUtil.getParameter(request, prefix + "ida_tax_seq", ""));
		setExpnTax(JSPUtil.getParameter(request, prefix + "expn_tax", ""));
		setEduTax(JSPUtil.getParameter(request, prefix + "edu_tax", ""));
		setHighEduTax(JSPUtil.getParameter(request, prefix + "high_edu_tax", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN2ndLoclTaxRt(JSPUtil.getParameter(request, prefix +"n2nd_locl_tax_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TaxInfoVO[]
	 */
	public TaxInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TaxInfoVO[]
	 */
	public TaxInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TaxInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] loclTaxRt = (JSPUtil.getParameter(request, prefix	+ "locl_tax_rt", length));
			String[] idaTaxSeq = (JSPUtil.getParameter(request, prefix	+ "ida_tax_seq", length));
			String[] expnTax = (JSPUtil.getParameter(request, prefix	+ "expn_tax", length));
			String[] eduTax = (JSPUtil.getParameter(request, prefix	+ "edu_tax", length));
			String[] highEduTax = (JSPUtil.getParameter(request, prefix	+ "high_edu_tax", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n2ndLoclTaxRt = (JSPUtil.getParameter(request, prefix	+ "n2nd_locl_tax_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new TaxInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (loclTaxRt[i] != null)
					model.setLoclTaxRt(loclTaxRt[i]);
				if (idaTaxSeq[i] != null)
					model.setIdaTaxSeq(idaTaxSeq[i]);
				if (expnTax[i] != null)
					model.setExpnTax(expnTax[i]);
				if (eduTax[i] != null)
					model.setEduTax(eduTax[i]);
				if (highEduTax[i] != null)
					model.setHighEduTax(highEduTax[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n2ndLoclTaxRt[i] != null)
					model.setN2ndLoclTaxRt(n2ndLoclTaxRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTaxInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TaxInfoVO[]
	 */
	public TaxInfoVO[] getTaxInfoVOs(){
		TaxInfoVO[] vos = (TaxInfoVO[])models.toArray(new TaxInfoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTaxRt = this.loclTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaTaxSeq = this.idaTaxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnTax = this.expnTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eduTax = this.eduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.highEduTax = this.highEduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndLoclTaxRt = this.n2ndLoclTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
