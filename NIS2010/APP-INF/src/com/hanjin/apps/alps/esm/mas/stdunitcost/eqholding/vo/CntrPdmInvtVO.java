/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrPdmInvtVO.java
*@FileTitle : CntrPdmInvtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo;

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

public class CntrPdmInvtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrPdmInvtVO> models = new ArrayList<CntrPdmInvtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String frYear = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String pdCostAmt = null;
	/* Column Info */
	private String toYear = null;
	/* Column Info */
	private String toQtr = null;
	/* Column Info */
	private String frQtr = null;
	/* Column Info */
	private String tpszCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String costYrQtr = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String invtCntrQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String costAmt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CntrPdmInvtVO() {}

	public CntrPdmInvtVO(String ibflag, String pagerows, String costYr, String bseQtrCd, String costYrQtr, String tpszCd, String invtCntrQty, String costAmt, String pdCostAmt, String creUsrId, String creDt, String updUsrId, String updDt, String frYear, String frQtr, String toYear, String toQtr) {
		this.updDt = updDt;
		this.frYear = frYear;
		this.creDt = creDt;
		this.pdCostAmt = pdCostAmt;
		this.toYear = toYear;
		this.toQtr = toQtr;
		this.frQtr = frQtr;
		this.tpszCd = tpszCd;
		this.pagerows = pagerows;
		this.costYrQtr = costYrQtr;
		this.bseQtrCd = bseQtrCd;
		this.invtCntrQty = invtCntrQty;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.costYr = costYr;
		this.costAmt = costAmt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("fr_year", getFrYear());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pd_cost_amt", getPdCostAmt());
		this.hashColumns.put("to_year", getToYear());
		this.hashColumns.put("to_qtr", getToQtr());
		this.hashColumns.put("fr_qtr", getFrQtr());
		this.hashColumns.put("tpsz_cd", getTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cost_yr_qtr", getCostYrQtr());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("invt_cntr_qty", getInvtCntrQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("cost_amt", getCostAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("fr_year", "frYear");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pd_cost_amt", "pdCostAmt");
		this.hashFields.put("to_year", "toYear");
		this.hashFields.put("to_qtr", "toQtr");
		this.hashFields.put("fr_qtr", "frQtr");
		this.hashFields.put("tpsz_cd", "tpszCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_yr_qtr", "costYrQtr");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("invt_cntr_qty", "invtCntrQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return frYear
	 */
	public String getFrYear() {
		return this.frYear;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return pdCostAmt
	 */
	public String getPdCostAmt() {
		return this.pdCostAmt;
	}
	
	/**
	 * Column Info
	 * @return toYear
	 */
	public String getToYear() {
		return this.toYear;
	}
	
	/**
	 * Column Info
	 * @return toQtr
	 */
	public String getToQtr() {
		return this.toQtr;
	}
	
	/**
	 * Column Info
	 * @return frQtr
	 */
	public String getFrQtr() {
		return this.frQtr;
	}
	
	/**
	 * Column Info
	 * @return tpszCd
	 */
	public String getTpszCd() {
		return this.tpszCd;
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
	 * @return costYrQtr
	 */
	public String getCostYrQtr() {
		return this.costYrQtr;
	}
	
	/**
	 * Column Info
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return invtCntrQty
	 */
	public String getInvtCntrQty() {
		return this.invtCntrQty;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return costAmt
	 */
	public String getCostAmt() {
		return this.costAmt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param frYear
	 */
	public void setFrYear(String frYear) {
		this.frYear = frYear;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param pdCostAmt
	 */
	public void setPdCostAmt(String pdCostAmt) {
		this.pdCostAmt = pdCostAmt;
	}
	
	/**
	 * Column Info
	 * @param toYear
	 */
	public void setToYear(String toYear) {
		this.toYear = toYear;
	}
	
	/**
	 * Column Info
	 * @param toQtr
	 */
	public void setToQtr(String toQtr) {
		this.toQtr = toQtr;
	}
	
	/**
	 * Column Info
	 * @param frQtr
	 */
	public void setFrQtr(String frQtr) {
		this.frQtr = frQtr;
	}
	
	/**
	 * Column Info
	 * @param tpszCd
	 */
	public void setTpszCd(String tpszCd) {
		this.tpszCd = tpszCd;
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
	 * @param costYrQtr
	 */
	public void setCostYrQtr(String costYrQtr) {
		this.costYrQtr = costYrQtr;
	}
	
	/**
	 * Column Info
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param invtCntrQty
	 */
	public void setInvtCntrQty(String invtCntrQty) {
		this.invtCntrQty = invtCntrQty;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param costAmt
	 */
	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setFrYear(JSPUtil.getParameter(request, prefix + "fr_year", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPdCostAmt(JSPUtil.getParameter(request, prefix + "pd_cost_amt", ""));
		setToYear(JSPUtil.getParameter(request, prefix + "to_year", ""));
		setToQtr(JSPUtil.getParameter(request, prefix + "to_qtr", ""));
		setFrQtr(JSPUtil.getParameter(request, prefix + "fr_qtr", ""));
		setTpszCd(JSPUtil.getParameter(request, prefix + "tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCostYrQtr(JSPUtil.getParameter(request, prefix + "cost_yr_qtr", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setInvtCntrQty(JSPUtil.getParameter(request, prefix + "invt_cntr_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCostYr(JSPUtil.getParameter(request, prefix + "cost_yr", ""));
		setCostAmt(JSPUtil.getParameter(request, prefix + "cost_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrPdmInvtVO[]
	 */
	public CntrPdmInvtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrPdmInvtVO[]
	 */
	public CntrPdmInvtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrPdmInvtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] frYear = (JSPUtil.getParameter(request, prefix	+ "fr_year", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pdCostAmt = (JSPUtil.getParameter(request, prefix	+ "pd_cost_amt", length));
			String[] toYear = (JSPUtil.getParameter(request, prefix	+ "to_year", length));
			String[] toQtr = (JSPUtil.getParameter(request, prefix	+ "to_qtr", length));
			String[] frQtr = (JSPUtil.getParameter(request, prefix	+ "fr_qtr", length));
			String[] tpszCd = (JSPUtil.getParameter(request, prefix	+ "tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] costYrQtr = (JSPUtil.getParameter(request, prefix	+ "cost_yr_qtr", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] invtCntrQty = (JSPUtil.getParameter(request, prefix	+ "invt_cntr_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] costAmt = (JSPUtil.getParameter(request, prefix	+ "cost_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrPdmInvtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (frYear[i] != null)
					model.setFrYear(frYear[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pdCostAmt[i] != null)
					model.setPdCostAmt(pdCostAmt[i]);
				if (toYear[i] != null)
					model.setToYear(toYear[i]);
				if (toQtr[i] != null)
					model.setToQtr(toQtr[i]);
				if (frQtr[i] != null)
					model.setFrQtr(frQtr[i]);
				if (tpszCd[i] != null)
					model.setTpszCd(tpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (costYrQtr[i] != null)
					model.setCostYrQtr(costYrQtr[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (invtCntrQty[i] != null)
					model.setInvtCntrQty(invtCntrQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (costAmt[i] != null)
					model.setCostAmt(costAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrPdmInvtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrPdmInvtVO[]
	 */
	public CntrPdmInvtVO[] getCntrPdmInvtVOs(){
		CntrPdmInvtVO[] vos = (CntrPdmInvtVO[])models.toArray(new CntrPdmInvtVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frYear = this.frYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdCostAmt = this.pdCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYear = this.toYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toQtr = this.toQtr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frQtr = this.frQtr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCd = this.tpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrQtr = this.costYrQtr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invtCntrQty = this.invtCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt = this.costAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
