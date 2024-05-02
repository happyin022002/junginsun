/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchIndiaGstRateVO.java
*@FileTitle : SearchIndiaGstRateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.23
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.05.23 KIM HYUN HWA 
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
 * @author KIM HYUN HWA
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchIndiaGstRateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchIndiaGstRateVO> models = new ArrayList<SearchIndiaGstRateVO>();
	
	/* Column Info */
	private String idaHighEduTaxRt = null;
	/* Column Info */
	private String idaExpnTaxRt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String idaEduTaxRt = null;
	/* Column Info */
	private String taxRgstNo = null;
	/* Column Info */
	private String pmntAcctNo = null;
	/* Column Info */
	private String svcCateRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String idaN2ndLoclTaxRt = null;
	/* Column Info */
	private String idaLoclTaxRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchIndiaGstRateVO() {}

	public SearchIndiaGstRateVO(String ibflag, String pagerows, String idaExpnTaxRt, String idaEduTaxRt, String idaHighEduTaxRt, String taxRgstNo, String svcCateRmk, String pmntAcctNo, String idaLoclTaxRt, String idaN2ndLoclTaxRt) {
		this.idaHighEduTaxRt = idaHighEduTaxRt;
		this.idaExpnTaxRt = idaExpnTaxRt;
		this.ibflag = ibflag;
		this.idaEduTaxRt = idaEduTaxRt;
		this.taxRgstNo = taxRgstNo;
		this.pmntAcctNo = pmntAcctNo;
		this.svcCateRmk = svcCateRmk;
		this.pagerows = pagerows;
		this.idaLoclTaxRt = idaLoclTaxRt;
		this.idaN2ndLoclTaxRt = idaN2ndLoclTaxRt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ida_high_edu_tax_rt", getIdaHighEduTaxRt());
		this.hashColumns.put("ida_expn_tax_rt", getIdaExpnTaxRt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ida_edu_tax_rt", getIdaEduTaxRt());
		this.hashColumns.put("tax_rgst_no", getTaxRgstNo());
		this.hashColumns.put("pmnt_acct_no", getPmntAcctNo());
		this.hashColumns.put("svc_cate_rmk", getSvcCateRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ida_locl_tax_rt", getIdaLoclTaxRt());
		this.hashColumns.put("ida_n2nd_locl_tax_rt", getIdaN2ndLoclTaxRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ida_high_edu_tax_rt", "idaHighEduTaxRt");
		this.hashFields.put("ida_expn_tax_rt", "idaExpnTaxRt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ida_edu_tax_rt", "idaEduTaxRt");
		this.hashFields.put("tax_rgst_no", "taxRgstNo");
		this.hashFields.put("pmnt_acct_no", "pmntAcctNo");
		this.hashFields.put("svc_cate_rmk", "svcCateRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ida_locl_tax_rt", "idaLoclTaxRt");
		this.hashFields.put("ida_N2nd_locl_tax_rt", "idaN2ndLoclTaxRt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return idaHighEduTaxRt
	 */
	public String getIdaHighEduTaxRt() {
		return this.idaHighEduTaxRt;
	}
	
	/**
	 * Column Info
	 * @return idaExpnTaxRt
	 */
	public String getIdaExpnTaxRt() {
		return this.idaExpnTaxRt;
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
	 * @return idaEduTaxRt
	 */
	public String getIdaEduTaxRt() {
		return this.idaEduTaxRt;
	}
	
	/**
	 * Column Info
	 * @return taxRgstNo
	 */
	public String getTaxRgstNo() {
		return this.taxRgstNo;
	}
	
	/**
	 * Column Info
	 * @return pmntAcctNo
	 */
	public String getPmntAcctNo() {
		return this.pmntAcctNo;
	}
	
	/**
	 * Column Info
	 * @return svcCateRmk
	 */
	public String getSvcCateRmk() {
		return this.svcCateRmk;
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
	 * @param idaHighEduTaxRt
	 */
	public void setIdaHighEduTaxRt(String idaHighEduTaxRt) {
		this.idaHighEduTaxRt = idaHighEduTaxRt;
	}
	
	/**
	 * Column Info
	 * @param idaExpnTaxRt
	 */
	public void setIdaExpnTaxRt(String idaExpnTaxRt) {
		this.idaExpnTaxRt = idaExpnTaxRt;
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
	 * @param idaEduTaxRt
	 */
	public void setIdaEduTaxRt(String idaEduTaxRt) {
		this.idaEduTaxRt = idaEduTaxRt;
	}
	
	/**
	 * Column Info
	 * @param taxRgstNo
	 */
	public void setTaxRgstNo(String taxRgstNo) {
		this.taxRgstNo = taxRgstNo;
	}
	
	/**
	 * Column Info
	 * @param pmntAcctNo
	 */
	public void setPmntAcctNo(String pmntAcctNo) {
		this.pmntAcctNo = pmntAcctNo;
	}
	
	/**
	 * Column Info
	 * @param svcCateRmk
	 */
	public void setSvcCateRmk(String svcCateRmk) {
		this.svcCateRmk = svcCateRmk;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getIdaLoclTaxRt() {
		return idaLoclTaxRt;
	}

	public void setIdaLoclTaxRt(String idaLoclTaxRt) {
		this.idaLoclTaxRt = idaLoclTaxRt;
	}

	public String getIdaN2ndLoclTaxRt() {
		return idaN2ndLoclTaxRt;
	}

	public void setIdaN2ndLoclTaxRt(String idaN2ndLoclTaxRt) {
		this.idaN2ndLoclTaxRt = idaN2ndLoclTaxRt;
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
		setIdaHighEduTaxRt(JSPUtil.getParameter(request, prefix + "ida_high_edu_tax_rt", ""));
		setIdaExpnTaxRt(JSPUtil.getParameter(request, prefix + "ida_expn_tax_rt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setIdaEduTaxRt(JSPUtil.getParameter(request, prefix + "ida_edu_tax_rt", ""));
		setTaxRgstNo(JSPUtil.getParameter(request, prefix + "tax_rgst_no", ""));
		setPmntAcctNo(JSPUtil.getParameter(request, prefix + "pmnt_acct_no", ""));
		setSvcCateRmk(JSPUtil.getParameter(request, prefix + "svc_cate_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIdaLoclTaxRt(JSPUtil.getParameter(request, prefix + "ida_locl_tax_rt", ""));
		setIdaN2ndLoclTaxRt(JSPUtil.getParameter(request, prefix + "ida_n2nd_locl_tax_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchIndiaGstRateVO[]
	 */
	public SearchIndiaGstRateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchIndiaGstRateVO[]
	 */
	public SearchIndiaGstRateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchIndiaGstRateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] idaHighEduTaxRt = (JSPUtil.getParameter(request, prefix	+ "ida_high_edu_tax_rt", length));
			String[] idaExpnTaxRt = (JSPUtil.getParameter(request, prefix	+ "ida_expn_tax_rt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] idaEduTaxRt = (JSPUtil.getParameter(request, prefix	+ "ida_edu_tax_rt", length));
			String[] taxRgstNo = (JSPUtil.getParameter(request, prefix	+ "tax_rgst_no", length));
			String[] pmntAcctNo = (JSPUtil.getParameter(request, prefix	+ "pmnt_acct_no", length));
			String[] svcCateRmk = (JSPUtil.getParameter(request, prefix	+ "svc_cate_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] idaLoclTaxRt = (JSPUtil.getParameter(request, prefix	+ "ida_locl_tax_rt", length));
			String[] idaN2ndLoclTaxRt = (JSPUtil.getParameter(request, prefix	+ "ida_n2nd_locl_tax_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchIndiaGstRateVO();
				if (idaHighEduTaxRt[i] != null)
					model.setIdaHighEduTaxRt(idaHighEduTaxRt[i]);
				if (idaExpnTaxRt[i] != null)
					model.setIdaExpnTaxRt(idaExpnTaxRt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (idaEduTaxRt[i] != null)
					model.setIdaEduTaxRt(idaEduTaxRt[i]);
				if (taxRgstNo[i] != null)
					model.setTaxRgstNo(taxRgstNo[i]);
				if (pmntAcctNo[i] != null)
					model.setPmntAcctNo(pmntAcctNo[i]);
				if (svcCateRmk[i] != null)
					model.setSvcCateRmk(svcCateRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (idaLoclTaxRt[i] != null)
					model.setIdaLoclTaxRt(idaLoclTaxRt[i]);
				if (idaN2ndLoclTaxRt[i] != null)
					model.setIdaN2ndLoclTaxRt(idaN2ndLoclTaxRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchIndiaGstRateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchIndiaGstRateVO[]
	 */
	public SearchIndiaGstRateVO[] getSearchIndiaGstRateVOs(){
		SearchIndiaGstRateVO[] vos = (SearchIndiaGstRateVO[])models.toArray(new SearchIndiaGstRateVO[models.size()]);
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
		this.idaHighEduTaxRt = this.idaHighEduTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaExpnTaxRt = this.idaExpnTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaEduTaxRt = this.idaEduTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxRgstNo = this.taxRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmntAcctNo = this.pmntAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateRmk = this.svcCateRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaLoclTaxRt = this.idaLoclTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaN2ndLoclTaxRt = this.idaN2ndLoclTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
