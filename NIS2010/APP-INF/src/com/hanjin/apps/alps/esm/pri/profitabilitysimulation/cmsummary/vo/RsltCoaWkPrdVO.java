/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltCoaWkPrdVO.java
*@FileTitle : RsltCoaWkPrdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.10.07 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltCoaWkPrdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltCoaWkPrdVO> models = new ArrayList<RsltCoaWkPrdVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slsFmDt = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String wkTp = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String slsToDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltCoaWkPrdVO() {}

	public RsltCoaWkPrdVO(String ibflag, String pagerows, String costYr, String costWk, String slsFmDt, String slsToDt, String wkTp) {
		this.ibflag = ibflag;
		this.slsFmDt = slsFmDt;
		this.costYr = costYr;
		this.wkTp = wkTp;
		this.costWk = costWk;
		this.slsToDt = slsToDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sls_fm_dt", getSlsFmDt());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("wk_tp", getWkTp());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("sls_to_dt", getSlsToDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sls_fm_dt", "slsFmDt");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("wk_tp", "wkTp");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("sls_to_dt", "slsToDt");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return slsFmDt
	 */
	public String getSlsFmDt() {
		return this.slsFmDt;
	}
	
	/**
	 * Column Info
	 * @return costYr
	 */
	public String getCostYr() {
		return this.costYr;
	}
	
	/**
	 * Column Info
	 * @return wkTp
	 */
	public String getWkTp() {
		return this.wkTp;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return slsToDt
	 */
	public String getSlsToDt() {
		return this.slsToDt;
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
	 * @param slsFmDt
	 */
	public void setSlsFmDt(String slsFmDt) {
		this.slsFmDt = slsFmDt;
	}
	
	/**
	 * Column Info
	 * @param costYr
	 */
	public void setCostYr(String costYr) {
		this.costYr = costYr;
	}
	
	/**
	 * Column Info
	 * @param wkTp
	 */
	public void setWkTp(String wkTp) {
		this.wkTp = wkTp;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param slsToDt
	 */
	public void setSlsToDt(String slsToDt) {
		this.slsToDt = slsToDt;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlsFmDt(JSPUtil.getParameter(request, "sls_fm_dt", ""));
		setCostYr(JSPUtil.getParameter(request, "cost_yr", ""));
		setWkTp(JSPUtil.getParameter(request, "wk_tp", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
		setSlsToDt(JSPUtil.getParameter(request, "sls_to_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltCoaWkPrdVO[]
	 */
	public RsltCoaWkPrdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltCoaWkPrdVO[]
	 */
	public RsltCoaWkPrdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltCoaWkPrdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slsFmDt = (JSPUtil.getParameter(request, prefix	+ "sls_fm_dt", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] wkTp = (JSPUtil.getParameter(request, prefix	+ "wk_tp", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] slsToDt = (JSPUtil.getParameter(request, prefix	+ "sls_to_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltCoaWkPrdVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slsFmDt[i] != null)
					model.setSlsFmDt(slsFmDt[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (wkTp[i] != null)
					model.setWkTp(wkTp[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (slsToDt[i] != null)
					model.setSlsToDt(slsToDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltCoaWkPrdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltCoaWkPrdVO[]
	 */
	public RsltCoaWkPrdVO[] getRsltCoaWkPrdVOs(){
		RsltCoaWkPrdVO[] vos = (RsltCoaWkPrdVO[])models.toArray(new RsltCoaWkPrdVO[models.size()]);
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
		this.slsFmDt = this.slsFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkTp = this.wkTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsToDt = this.slsToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
