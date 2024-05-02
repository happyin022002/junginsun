/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchGeneralExpenseByVesselVO.java
*@FileTitle : SearchGeneralExpenseByVesselVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.22
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.03.22 최성민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.genexpense.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchGeneralExpenseByVesselVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchGeneralExpenseByVesselVO> models = new ArrayList<SearchGeneralExpenseByVesselVO>();
	
	/* Column Info */
	private String dhirAmt3 = null;
	/* Column Info */
	private String vslCd3 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon3 = null;
	/* Column Info */
	private String vslClssCapa3 = null;
	/* Page Number */
	private String pagerows = null;
	//SJH.20141229.ADD
	private String costYrmon4 = null;
	private String vslClssCapa4 = null;	
	private String dhirAmt4 = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchGeneralExpenseByVesselVO() {}

	public SearchGeneralExpenseByVesselVO(String ibflag, String pagerows, String costYrmon3, String vslCd3, String vslClssCapa3, String dhirAmt3, String costYrmon4, String vslClssCapa4, String dhirAmt4) {
		this.dhirAmt3 = dhirAmt3;
		this.vslCd3 = vslCd3;
		this.ibflag = ibflag;
		this.costYrmon3 = costYrmon3;
		this.vslClssCapa3 = vslClssCapa3;
		this.pagerows = pagerows;
		//SJH.20141229.ADD
		this.costYrmon4 = costYrmon4;
		this.vslClssCapa4 = vslClssCapa4;
		this.dhirAmt4 = dhirAmt4;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dhir_amt3", getDhirAmt33());
		this.hashColumns.put("vsl_cd3", getVslCd33());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon3", getCostYrmon33());
		this.hashColumns.put("vsl_clss_capa3", getVslClssCapa33());
		this.hashColumns.put("pagerows", getPagerows());
		//SJH.20141229.ADD
		this.hashColumns.put("cost_yrmon4", getCostYrmon4());
		this.hashColumns.put("vsl_clss_capa4", getVslClssCapa4());
		this.hashColumns.put("dhir_amt4", getDhirAmt4());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dhir_amt3", "dhirAmt3");
		this.hashFields.put("vsl_cd3", "vslCd3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon3", "costYrmon3");
		this.hashFields.put("vsl_clss_capa3", "vslClssCapa3");
		this.hashFields.put("pagerows", "pagerows");
		//SJH.20141229.ADD
		this.hashFields.put("cost_yrmon4", "costYrmon4");
		this.hashFields.put("vsl_clss_capa4", "vslClssCapa4");
		this.hashFields.put("dhir_amt4", "dhirAmt4");		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dhirAmt3
	 */
	public String getDhirAmt33() {
		return this.dhirAmt3;
	}
	
	/**
	 * Column Info
	 * @return vslCd3
	 */
	public String getVslCd33() {
		return this.vslCd3;
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
	 * @return costYrmon3
	 */
	public String getCostYrmon33() {
		return this.costYrmon3;
	}
	
	/**
	 * Column Info
	 * @return vslClssCapa3
	 */
	public String getVslClssCapa33() {
		return this.vslClssCapa3;
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
	 * @return costYrmon4
	 * @author SJH.20141229.ADD
	 */
	public String getCostYrmon4() {
		return this.costYrmon4;
	}
	
	/**
	 * Column Info
	 * @return vslClssCapa4
	 * @author SJH.20141229.ADD
	 */
	public String getVslClssCapa4() {
		return this.vslClssCapa4;
	}
	
	/**
	 * Column Info
	 * @return dhirAmt4
	 * @author SJH.20141229.ADD
	 */
	public String getDhirAmt4() {
		return this.dhirAmt4;
	}	
	

	/**
	 * Column Info
	 * @param dhirAmt3
	 */
	public void setDhirAmt33(String dhirAmt3) {
		this.dhirAmt3 = dhirAmt3;
	}
	
	/**
	 * Column Info
	 * @param vslCd3
	 */
	public void setVslCd33(String vslCd3) {
		this.vslCd3 = vslCd3;
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
	 * @param costYrmon3
	 */
	public void setCostYrmon33(String costYrmon3) {
		this.costYrmon3 = costYrmon3;
	}
	
	/**
	 * Column Info
	 * @param vslClssCapa3
	 */
	public void setVslClssCapa33(String vslClssCapa3) {
		this.vslClssCapa3 = vslClssCapa3;
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
	 * @param costYrmon4
	 * @author SJH.20141229.ADD
	 */
	public void setCostYrmon4(String costYrmon4) {
		this.costYrmon4 = costYrmon4;
	}
	
	/**
	 * Column Info
	 * @param vslClssCapa4
	 * @author SJH.20141229.ADD
	 */
	public void setVslClssCapa4(String vslClssCapa4) {
		this.vslClssCapa4 = vslClssCapa4;
	}		
	
	/**
	 * Column Info
	 * @param dhirAmt4
	 * @author SJH.20141229.ADD
	 */
	public void setDhirAmt4(String dhirAmt4) {
		this.dhirAmt4 = dhirAmt4;
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
		setDhirAmt33(JSPUtil.getParameter(request, prefix + "dhir_amt3", ""));
		setVslCd33(JSPUtil.getParameter(request, prefix + "vsl_cd3", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon33(JSPUtil.getParameter(request, prefix + "cost_yrmon3", ""));
		setVslClssCapa33(JSPUtil.getParameter(request, prefix + "vsl_clss_capa3", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		//SJH.20141229.ADD
		setCostYrmon4(JSPUtil.getParameter(request, "cost_yrmon4", ""));
		setVslClssCapa4(JSPUtil.getParameter(request, "vsl_clss_capa4", ""));
		setDhirAmt4(JSPUtil.getParameter(request, "dhir_amt4", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchGeneralExpenseByVesselVO[]
	 */
	public SearchGeneralExpenseByVesselVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchGeneralExpenseByVesselVO[]
	 */
	public SearchGeneralExpenseByVesselVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchGeneralExpenseByVesselVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dhirAmt3 = (JSPUtil.getParameter(request, prefix	+ "dhir_amt3", length));
			String[] vslCd3 = (JSPUtil.getParameter(request, prefix	+ "vsl_cd3", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon3 = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon3", length));
			String[] vslClssCapa3 = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa3", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			//SJH.20141229.ADD
			String[] costYrmon4 = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon4", length));
			String[] vslClssCapa4 = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa4", length));
			String[] dhirAmt4 = (JSPUtil.getParameter(request, prefix	+ "dhir_amt4", length));			
			
			for (int i = 0; i < length; i++) {
				model = new SearchGeneralExpenseByVesselVO();
				if (dhirAmt3[i] != null)
					model.setDhirAmt33(dhirAmt3[i]);
				if (vslCd3[i] != null)
					model.setVslCd33(vslCd3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon3[i] != null)
					model.setCostYrmon33(costYrmon3[i]);
				if (vslClssCapa3[i] != null)
					model.setVslClssCapa33(vslClssCapa3[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				//SJH.20141229.ADD
				if (costYrmon4[i] != null)
					model.setCostYrmon4(costYrmon4[i]);
				if (vslClssCapa4[i] != null)
					model.setVslClssCapa4(vslClssCapa4[i]);
				if (dhirAmt4[i] != null)
					model.setDhirAmt4(dhirAmt4[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchGeneralExpenseByVesselVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchGeneralExpenseByVesselVO[]
	 */
	public SearchGeneralExpenseByVesselVO[] getSearchGeneralExpenseByVesselVOs(){
		SearchGeneralExpenseByVesselVO[] vos = (SearchGeneralExpenseByVesselVO[])models.toArray(new SearchGeneralExpenseByVesselVO[models.size()]);
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
		this.dhirAmt3 = this.dhirAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd3 = this.vslCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon3 = this.costYrmon3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa3 = this.vslClssCapa3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//SJH.20141229.ADD
		this.costYrmon4 = this.costYrmon4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa4 = this.vslClssCapa4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dhirAmt4 = this.dhirAmt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
