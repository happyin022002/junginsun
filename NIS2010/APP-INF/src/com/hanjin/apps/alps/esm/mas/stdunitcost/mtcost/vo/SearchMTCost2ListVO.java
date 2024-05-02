/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchMTCost2ListVO.java
*@FileTitle : SearchMTCost2ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.12
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.07.12 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMTCost2ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMTCost2ListVO> models = new ArrayList<SearchMTCost2ListVO>();
	
	/* Column Info */
	private String fOriDest = null;
	/* Column Info */
	private String eqStatus = null;
	/* Column Info */
	private String fCostYrmon = null;
	/* Column Info */
	private String cntrImbalRto = null;
	/* Column Info */
	private String fEccCd2 = null;
	/* Column Info */
	private String cntrObQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrImbalQty = null;
	/* Column Info */
	private String fcntrEccCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String oriDestCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrIbQty = null;
	/* Column Info */
	private String fCntrTpszCd2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMTCost2ListVO() {}

	public SearchMTCost2ListVO(String ibflag, String pagerows, String costYrmon, String fcntrEccCd, String oriDestCd, String cntrTpszCd, String eqStatus, String cntrImbalRto, String cntrImbalQty, String cntrIbQty, String cntrObQty, String fCntrTpszCd2, String fCostYrmon, String fEccCd2, String fOriDest) {
		this.fOriDest = fOriDest;
		this.eqStatus = eqStatus;
		this.fCostYrmon = fCostYrmon;
		this.cntrImbalRto = cntrImbalRto;
		this.fEccCd2 = fEccCd2;
		this.cntrObQty = cntrObQty;
		this.pagerows = pagerows;
		this.cntrImbalQty = cntrImbalQty;
		this.fcntrEccCd = fcntrEccCd;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.oriDestCd = oriDestCd;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrIbQty = cntrIbQty;
		this.fCntrTpszCd2 = fCntrTpszCd2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_ori_dest", getFOriDest());
		this.hashColumns.put("eq_status", getEqStatus());
		this.hashColumns.put("f_cost_yrmon", getFCostYrmon());
		this.hashColumns.put("cntr_imbal_rto", getCntrImbalRto());
		this.hashColumns.put("f_ecc_cd2", getFEccCd2());
		this.hashColumns.put("cntr_ob_qty", getCntrObQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_imbal_qty", getCntrImbalQty());
		this.hashColumns.put("fcntr_ecc_cd", getFcntrEccCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("ori_dest_cd", getOriDestCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_ib_qty", getCntrIbQty());
		this.hashColumns.put("f_cntr_tpsz_cd2", getFCntrTpszCd2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_ori_dest", "fOriDest");
		this.hashFields.put("eq_status", "eqStatus");
		this.hashFields.put("f_cost_yrmon", "fCostYrmon");
		this.hashFields.put("cntr_imbal_rto", "cntrImbalRto");
		this.hashFields.put("f_ecc_cd2", "fEccCd2");
		this.hashFields.put("cntr_ob_qty", "cntrObQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_imbal_qty", "cntrImbalQty");
		this.hashFields.put("fcntr_ecc_cd", "fcntrEccCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("ori_dest_cd", "oriDestCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_ib_qty", "cntrIbQty");
		this.hashFields.put("f_cntr_tpsz_cd2", "fCntrTpszCd2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fOriDest
	 */
	public String getFOriDest() {
		return this.fOriDest;
	}
	
	/**
	 * Column Info
	 * @return eqStatus
	 */
	public String getEqStatus() {
		return this.eqStatus;
	}
	
	/**
	 * Column Info
	 * @return fCostYrmon
	 */
	public String getFCostYrmon() {
		return this.fCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return cntrImbalRto
	 */
	public String getCntrImbalRto() {
		return this.cntrImbalRto;
	}
	
	/**
	 * Column Info
	 * @return fEccCd2
	 */
	public String getFEccCd2() {
		return this.fEccCd2;
	}
	
	/**
	 * Column Info
	 * @return cntrObQty
	 */
	public String getCntrObQty() {
		return this.cntrObQty;
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
	 * @return cntrImbalQty
	 */
	public String getCntrImbalQty() {
		return this.cntrImbalQty;
	}
	
	/**
	 * Column Info
	 * @return fcntrEccCd
	 */
	public String getFcntrEccCd() {
		return this.fcntrEccCd;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return oriDestCd
	 */
	public String getOriDestCd() {
		return this.oriDestCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrIbQty
	 */
	public String getCntrIbQty() {
		return this.cntrIbQty;
	}
	
	/**
	 * Column Info
	 * @return fCntrTpszCd2
	 */
	public String getFCntrTpszCd2() {
		return this.fCntrTpszCd2;
	}
	

	/**
	 * Column Info
	 * @param fOriDest
	 */
	public void setFOriDest(String fOriDest) {
		this.fOriDest = fOriDest;
	}
	
	/**
	 * Column Info
	 * @param eqStatus
	 */
	public void setEqStatus(String eqStatus) {
		this.eqStatus = eqStatus;
	}
	
	/**
	 * Column Info
	 * @param fCostYrmon
	 */
	public void setFCostYrmon(String fCostYrmon) {
		this.fCostYrmon = fCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param cntrImbalRto
	 */
	public void setCntrImbalRto(String cntrImbalRto) {
		this.cntrImbalRto = cntrImbalRto;
	}
	
	/**
	 * Column Info
	 * @param fEccCd2
	 */
	public void setFEccCd2(String fEccCd2) {
		this.fEccCd2 = fEccCd2;
	}
	
	/**
	 * Column Info
	 * @param cntrObQty
	 */
	public void setCntrObQty(String cntrObQty) {
		this.cntrObQty = cntrObQty;
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
	 * @param cntrImbalQty
	 */
	public void setCntrImbalQty(String cntrImbalQty) {
		this.cntrImbalQty = cntrImbalQty;
	}
	
	/**
	 * Column Info
	 * @param fcntrEccCd
	 */
	public void setFcntrEccCd(String fcntrEccCd) {
		this.fcntrEccCd = fcntrEccCd;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param oriDestCd
	 */
	public void setOriDestCd(String oriDestCd) {
		this.oriDestCd = oriDestCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrIbQty
	 */
	public void setCntrIbQty(String cntrIbQty) {
		this.cntrIbQty = cntrIbQty;
	}
	
	/**
	 * Column Info
	 * @param fCntrTpszCd2
	 */
	public void setFCntrTpszCd2(String fCntrTpszCd2) {
		this.fCntrTpszCd2 = fCntrTpszCd2;
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
		setFOriDest(JSPUtil.getParameter(request, prefix + "f_ori_dest", ""));
		setEqStatus(JSPUtil.getParameter(request, prefix + "eq_status", ""));
		setFCostYrmon(JSPUtil.getParameter(request, prefix + "f_cost_yrmon", ""));
		setCntrImbalRto(JSPUtil.getParameter(request, prefix + "cntr_imbal_rto", ""));
		setFEccCd2(JSPUtil.getParameter(request, prefix + "f_ecc_cd2", ""));
		setCntrObQty(JSPUtil.getParameter(request, prefix + "cntr_ob_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrImbalQty(JSPUtil.getParameter(request, prefix + "cntr_imbal_qty", ""));
		setFcntrEccCd(JSPUtil.getParameter(request, prefix + "fcntr_ecc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setOriDestCd(JSPUtil.getParameter(request, prefix + "ori_dest_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCntrIbQty(JSPUtil.getParameter(request, prefix + "cntr_ib_qty", ""));
		setFCntrTpszCd2(JSPUtil.getParameter(request, prefix + "f_cntr_tpsz_cd2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMTCost2ListVO[]
	 */
	public SearchMTCost2ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMTCost2ListVO[]
	 */
	public SearchMTCost2ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMTCost2ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fOriDest = (JSPUtil.getParameter(request, prefix	+ "f_ori_dest", length));
			String[] eqStatus = (JSPUtil.getParameter(request, prefix	+ "eq_status", length));
			String[] fCostYrmon = (JSPUtil.getParameter(request, prefix	+ "f_cost_yrmon", length));
			String[] cntrImbalRto = (JSPUtil.getParameter(request, prefix	+ "cntr_imbal_rto", length));
			String[] fEccCd2 = (JSPUtil.getParameter(request, prefix	+ "f_ecc_cd2", length));
			String[] cntrObQty = (JSPUtil.getParameter(request, prefix	+ "cntr_ob_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrImbalQty = (JSPUtil.getParameter(request, prefix	+ "cntr_imbal_qty", length));
			String[] fcntrEccCd = (JSPUtil.getParameter(request, prefix	+ "fcntr_ecc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] oriDestCd = (JSPUtil.getParameter(request, prefix	+ "ori_dest_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrIbQty = (JSPUtil.getParameter(request, prefix	+ "cntr_ib_qty", length));
			String[] fCntrTpszCd2 = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tpsz_cd2", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMTCost2ListVO();
				if (fOriDest[i] != null)
					model.setFOriDest(fOriDest[i]);
				if (eqStatus[i] != null)
					model.setEqStatus(eqStatus[i]);
				if (fCostYrmon[i] != null)
					model.setFCostYrmon(fCostYrmon[i]);
				if (cntrImbalRto[i] != null)
					model.setCntrImbalRto(cntrImbalRto[i]);
				if (fEccCd2[i] != null)
					model.setFEccCd2(fEccCd2[i]);
				if (cntrObQty[i] != null)
					model.setCntrObQty(cntrObQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrImbalQty[i] != null)
					model.setCntrImbalQty(cntrImbalQty[i]);
				if (fcntrEccCd[i] != null)
					model.setFcntrEccCd(fcntrEccCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (oriDestCd[i] != null)
					model.setOriDestCd(oriDestCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrIbQty[i] != null)
					model.setCntrIbQty(cntrIbQty[i]);
				if (fCntrTpszCd2[i] != null)
					model.setFCntrTpszCd2(fCntrTpszCd2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMTCost2ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMTCost2ListVO[]
	 */
	public SearchMTCost2ListVO[] getSearchMTCost2ListVOs(){
		SearchMTCost2ListVO[] vos = (SearchMTCost2ListVO[])models.toArray(new SearchMTCost2ListVO[models.size()]);
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
		this.fOriDest = this.fOriDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqStatus = this.eqStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostYrmon = this.fCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrImbalRto = this.cntrImbalRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEccCd2 = this.fEccCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrObQty = this.cntrObQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrImbalQty = this.cntrImbalQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrEccCd = this.fcntrEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriDestCd = this.oriDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrIbQty = this.cntrIbQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpszCd2 = this.fCntrTpszCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
