/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairPFMCByACCTVO.java
*@FileTitle : RepairPFMCByACCTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.08
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.10.08 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairPFMCByACCTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairPFMCByACCTVO> models = new ArrayList<RepairPFMCByACCTVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String costCdNm = null;
	/* Column Info */
	private String costDtlCd = null;
	/* Column Info */
	private String totalAmt = null;
	/* Column Info */
	private String totalQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String cntNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rhqCostOfcCd = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String avgAmt = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String costDtlCdNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepairPFMCByACCTVO() {}

	public RepairPFMCByACCTVO(String ibflag, String pagerows, String currCd, String costOfcCd, String costCdNm, String costDtlCd, String totalAmt, String totalQty, String eqTpszCd, String vndrNm, String rhqCostOfcCd, String costCd, String vndrSeq, String acctCd, String avgAmt, String costDtlCdNm, String cntNm) {
		this.currCd = currCd;
		this.costOfcCd = costOfcCd;
		this.costCdNm = costCdNm;
		this.costDtlCd = costDtlCd;
		this.totalAmt = totalAmt;
		this.totalQty = totalQty;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.vndrNm = vndrNm;
		this.cntNm = cntNm;
		this.ibflag = ibflag;
		this.rhqCostOfcCd = rhqCostOfcCd;
		this.costCd = costCd;
		this.vndrSeq = vndrSeq;
		this.avgAmt = avgAmt;
		this.acctCd = acctCd;
		this.costDtlCdNm = costDtlCdNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("cost_cd_nm", getCostCdNm());
		this.hashColumns.put("cost_dtl_cd", getCostDtlCd());
		this.hashColumns.put("total_amt", getTotalAmt());
		this.hashColumns.put("total_qty", getTotalQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rhq_cost_ofc_cd", getRhqCostOfcCd());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("avg_amt", getAvgAmt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("cost_dtl_cd_nm", getCostDtlCdNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("cost_cd_nm", "costCdNm");
		this.hashFields.put("cost_dtl_cd", "costDtlCd");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("total_qty", "totalQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rhq_cost_ofc_cd", "rhqCostOfcCd");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("avg_amt", "avgAmt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("cost_dtl_cd_nm", "costDtlCdNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
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
	 * @return costDtlCd
	 */
	public String getCostDtlCd() {
		return this.costDtlCd;
	}
	
	/**
	 * Column Info
	 * @return totalAmt
	 */
	public String getTotalAmt() {
		return this.totalAmt;
	}
	
	/**
	 * Column Info
	 * @return totalQty
	 */
	public String getTotalQty() {
		return this.totalQty;
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
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
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
	 * @return rhqCostOfcCd
	 */
	public String getRhqCostOfcCd() {
		return this.rhqCostOfcCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return avgAmt
	 */
	public String getAvgAmt() {
		return this.avgAmt;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return costDtlCdNm
	 */
	public String getCostDtlCdNm() {
		return this.costDtlCdNm;
	}
	

	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
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
	 * @param costDtlCd
	 */
	public void setCostDtlCd(String costDtlCd) {
		this.costDtlCd = costDtlCd;
	}
	
	/**
	 * Column Info
	 * @param totalAmt
	 */
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	/**
	 * Column Info
	 * @param totalQty
	 */
	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
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
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
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
	 * @param rhqCostOfcCd
	 */
	public void setRhqCostOfcCd(String rhqCostOfcCd) {
		this.rhqCostOfcCd = rhqCostOfcCd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param avgAmt
	 */
	public void setAvgAmt(String avgAmt) {
		this.avgAmt = avgAmt;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param costDtlCdNm
	 */
	public void setCostDtlCdNm(String costDtlCdNm) {
		this.costDtlCdNm = costDtlCdNm;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setCostCdNm(JSPUtil.getParameter(request, prefix + "cost_cd_nm", ""));
		setCostDtlCd(JSPUtil.getParameter(request, prefix + "cost_dtl_cd", ""));
		setTotalAmt(JSPUtil.getParameter(request, prefix + "total_amt", ""));
		setTotalQty(JSPUtil.getParameter(request, prefix + "total_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRhqCostOfcCd(JSPUtil.getParameter(request, prefix + "rhq_cost_ofc_cd", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setAvgAmt(JSPUtil.getParameter(request, prefix + "avg_amt", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setCostDtlCdNm(JSPUtil.getParameter(request, prefix + "cost_dtl_cd_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairPFMCByACCTVO[]
	 */
	public RepairPFMCByACCTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairPFMCByACCTVO[]
	 */
	public RepairPFMCByACCTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairPFMCByACCTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] costCdNm = (JSPUtil.getParameter(request, prefix	+ "cost_cd_nm", length));
			String[] costDtlCd = (JSPUtil.getParameter(request, prefix	+ "cost_dtl_cd", length));
			String[] totalAmt = (JSPUtil.getParameter(request, prefix	+ "total_amt", length));
			String[] totalQty = (JSPUtil.getParameter(request, prefix	+ "total_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rhqCostOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cost_ofc_cd", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] avgAmt = (JSPUtil.getParameter(request, prefix	+ "avg_amt", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] costDtlCdNm = (JSPUtil.getParameter(request, prefix	+ "cost_dtl_cd_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairPFMCByACCTVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (costCdNm[i] != null)
					model.setCostCdNm(costCdNm[i]);
				if (costDtlCd[i] != null)
					model.setCostDtlCd(costDtlCd[i]);
				if (totalAmt[i] != null)
					model.setTotalAmt(totalAmt[i]);
				if (totalQty[i] != null)
					model.setTotalQty(totalQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rhqCostOfcCd[i] != null)
					model.setRhqCostOfcCd(rhqCostOfcCd[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (avgAmt[i] != null)
					model.setAvgAmt(avgAmt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (costDtlCdNm[i] != null)
					model.setCostDtlCdNm(costDtlCdNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairPFMCByACCTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairPFMCByACCTVO[]
	 */
	public RepairPFMCByACCTVO[] getRepairPFMCByACCTVOs(){
		RepairPFMCByACCTVO[] vos = (RepairPFMCByACCTVO[])models.toArray(new RepairPFMCByACCTVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCdNm = this.costCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDtlCd = this.costDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt = this.totalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalQty = this.totalQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCostOfcCd = this.rhqCostOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgAmt = this.avgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDtlCdNm = this.costDtlCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
