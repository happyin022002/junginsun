/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchEqManufacturePlanListVO.java
*@FileTitle : SearchEqManufacturePlanListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.03.22 남궁진호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EqMftPlanOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqMftPlanOptionVO> models = new ArrayList<EqMftPlanOptionVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String plnYr2 = null;
	/* Column Info */
	private String eqTpCd = null;
	/* Column Info */
	private String cntrHngrRckCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String cntrFlrMtrlCd = null;
	/* Column Info */
	private String rfTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EqMftPlanOptionVO() {}

	public EqMftPlanOptionVO(String ibflag, String pagerows, String plnYr,String plnYr2, String eqTpCd, String eqTpszCd, 
								   String cntrHngrRckCd, String cntrFlrMtrlCd, String rfTpCd) {
		this.cntrFlrMtrlCd = cntrFlrMtrlCd;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.ibflag = ibflag;
		this.plnYr = plnYr;
		this.plnYr2 = plnYr2;
		this.eqTpCd = eqTpCd;
		this.rfTpCd = rfTpCd;
		this.cntrHngrRckCd = cntrHngrRckCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_flr_mtrl_cd", getCntrFlrMtrlCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("pln_yr2", getPlnYr2());
		this.hashColumns.put("eq_tp_cd", getEqTpCd());
		this.hashColumns.put("rf_tp_cd", getRfTpCd());
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_flr_mtrl_cd", "cntrFlrMtrlCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("pln_yr2", "plnYr2");
		this.hashFields.put("eq_tp_cd", "eqTpCd");
		this.hashFields.put("rf_tp_cd", "rfTpCd");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		return this.hashFields;
	}
	
	
	/**
	 * Column Info
	 * @return cntrFlrMtrlCd
	 */
	public String getCntrFlrMtrlCd() {
		return this.cntrFlrMtrlCd;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return plnYr
	 */
	public String getPlnYr() {
		return this.plnYr;
	}
	
	/**
	 * Column Info
	 * @return plnYr2
	 */
	public String getPlnYr2() {
		return this.plnYr2;
	}
	
	
	/**
	 * Column Info
	 * @return eqTpCd
	 */
	public String getEqTpCd() {
		return this.eqTpCd;
	}
	
	
	/**
	 * Column Info
	 * @return rfTpCd
	 */
	public String getRfTpCd() {
		return this.rfTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrRckCd
	 */
	public String getCntrHngrRckCd() {
		return this.cntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @param cntrFlrMtrlCd
	 */
	public void setCntrFlrMtrlCd(String cntrFlrMtrlCd) {
		this.cntrFlrMtrlCd = cntrFlrMtrlCd;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param plnYr
	 */
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}
	
	/**
	 * Column Info
	 * @param plnYr2
	 */
	public void setPlnYr2(String plnYr2) {
		this.plnYr2 = plnYr2;
	}
	
	/**
	 * Column Info
	 * @param eqTpCd
	 */
	public void setEqTpCd(String eqTpCd) {
		this.eqTpCd = eqTpCd;
	}
	
	/**
	 * Column Info
	 * @param rfTpCd
	 */
	public void setRfTpCd(String rfTpCd) {
		this.rfTpCd = rfTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrRckCd
	 */
	public void setCntrHngrRckCd(String cntrHngrRckCd) {
		this.cntrHngrRckCd = cntrHngrRckCd;
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
		setCntrFlrMtrlCd(JSPUtil.getParameter(request, prefix + "cntr_flr_mtrl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPlnYr(JSPUtil.getParameter(request, prefix + "pln_yr", ""));
		setPlnYr2(JSPUtil.getParameter(request, prefix + "pln_yr2", ""));
		setEqTpCd(JSPUtil.getParameter(request, prefix + "eq_tp_cd", ""));
		setRfTpCd(JSPUtil.getParameter(request, prefix + "rf_tp_cd", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request, prefix + "cntr_hngr_rck_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEqManufacturePlanListVO[]
	 */
	public EqMftPlanOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEqManufacturePlanListVO[]
	 */
	public EqMftPlanOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqMftPlanOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrFlrMtrlCd = (JSPUtil.getParameter(request, prefix	+ "cntr_flr_mtrl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr", length));
			String[] plnYr2 = (JSPUtil.getParameter(request, prefix	+ "pln_yr2", length));
			String[] eqTpCd = (JSPUtil.getParameter(request, prefix	+ "eq_tp_cd", length));
			String[] rfTpCd = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd", length));
			String[] cntrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqMftPlanOptionVO();
				if (cntrFlrMtrlCd[i] != null)
					model.setCntrFlrMtrlCd(cntrFlrMtrlCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (plnYr2[i] != null)
					model.setPlnYr2(plnYr2[i]);
				if (eqTpCd[i] != null)
					model.setEqTpCd(eqTpCd[i]);
				if (rfTpCd[i] != null)
					model.setRfTpCd(rfTpCd[i]);
				if (cntrHngrRckCd[i] != null)
					model.setCntrHngrRckCd(cntrHngrRckCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEqManufacturePlanListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEqManufacturePlanListVO[]
	 */
	public EqMftPlanOptionVO[] getSearchEqManufacturePlanListVOs(){
		EqMftPlanOptionVO[] vos = (EqMftPlanOptionVO[])models.toArray(new EqMftPlanOptionVO[models.size()]);
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
		this.cntrFlrMtrlCd = this.cntrFlrMtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr2 = this.plnYr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpCd = this.eqTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCd = this.rfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd = this.cntrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
