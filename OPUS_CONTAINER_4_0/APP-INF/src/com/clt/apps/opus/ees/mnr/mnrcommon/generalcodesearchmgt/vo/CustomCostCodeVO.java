/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomCostCodeVO.java
*@FileTitle : CustomCostCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

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

public class CustomCostCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomCostCodeVO> models = new ArrayList<CustomCostCodeVO>();
	
	/* Column Info */
	private String eqCmpoDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String costCdNm = null;
	/* Column Info */
	private String eqCmpoCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomCostCodeVO() {}

	public CustomCostCodeVO(String ibflag, String pagerows, String eqCmpoCd, String eqCmpoDesc, String costCd, String costCdNm) {
		this.eqCmpoDesc = eqCmpoDesc;
		this.ibflag = ibflag;
		this.costCd = costCd;
		this.costCdNm = costCdNm;
		this.eqCmpoCd = eqCmpoCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eq_cmpo_desc", getEqCmpoDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("cost_cd_nm", getCostCdNm());
		this.hashColumns.put("eq_cmpo_cd", getEqCmpoCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eq_cmpo_desc", "eqCmpoDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("cost_cd_nm", "costCdNm");
		this.hashFields.put("eq_cmpo_cd", "eqCmpoCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eqCmpoDesc
	 */
	public String getEqCmpoDesc() {
		return this.eqCmpoDesc;
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
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return costCdNm
	 */
	public String getCostCdNm() {
		return this.costCdNm;
	}
	
	/**
	 * Column Info
	 * @return eqCmpoCd
	 */
	public String getEqCmpoCd() {
		return this.eqCmpoCd;
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
	 * @param eqCmpoDesc
	 */
	public void setEqCmpoDesc(String eqCmpoDesc) {
		this.eqCmpoDesc = eqCmpoDesc;
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
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param costCdNm
	 */
	public void setCostCdNm(String costCdNm) {
		this.costCdNm = costCdNm;
	}
	
	/**
	 * Column Info
	 * @param eqCmpoCd
	 */
	public void setEqCmpoCd(String eqCmpoCd) {
		this.eqCmpoCd = eqCmpoCd;
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
		setEqCmpoDesc(JSPUtil.getParameter(request, prefix + "eq_cmpo_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setCostCdNm(JSPUtil.getParameter(request, prefix + "cost_cd_nm", ""));
		setEqCmpoCd(JSPUtil.getParameter(request, prefix + "eq_cmpo_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomCostCodeVO[]
	 */
	public CustomCostCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomCostCodeVO[]
	 */
	public CustomCostCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomCostCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eqCmpoDesc = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] costCdNm = (JSPUtil.getParameter(request, prefix	+ "cost_cd_nm", length));
			String[] eqCmpoCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomCostCodeVO();
				if (eqCmpoDesc[i] != null)
					model.setEqCmpoDesc(eqCmpoDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (costCdNm[i] != null)
					model.setCostCdNm(costCdNm[i]);
				if (eqCmpoCd[i] != null)
					model.setEqCmpoCd(eqCmpoCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomCostCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomCostCodeVO[]
	 */
	public CustomCostCodeVO[] getCustomCostCodeVOs(){
		CustomCostCodeVO[] vos = (CustomCostCodeVO[])models.toArray(new CustomCostCodeVO[models.size()]);
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
		this.eqCmpoDesc = this.eqCmpoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCdNm = this.costCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCd = this.eqCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
