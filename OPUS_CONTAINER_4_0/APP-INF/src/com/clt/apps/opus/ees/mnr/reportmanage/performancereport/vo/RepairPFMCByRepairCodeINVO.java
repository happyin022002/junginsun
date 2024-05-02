/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairPFMCByRepairCodeINVO.java
*@FileTitle : RepairPFMCByRepairCodeINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.04.20 김완규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairPFMCByRepairCodeINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairPFMCByRepairCodeINVO> models = new ArrayList<RepairPFMCByRepairCodeINVO>();
	
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String damage = null;
	/* Column Info */
	private String qty = null;
	/* Column Info */
	private String reportPeriodType = null;
	/* Column Info */
	private String eqType = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String currency = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String division = null;
	/* Column Info */
	private String component = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String locationCd = null;
	/* Column Info */
	private String repair = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RepairPFMCByRepairCodeINVO() {}

	public RepairPFMCByRepairCodeINVO(String ibflag, String pagerows, String fmDt, String damage, String reportPeriodType, String eqType, String currency, String toDt, String ofcCd, String division, String component, String vndrSeq, String locationCd, String repair, String rhq, String qty) {
		this.fmDt = fmDt;
		this.damage = damage;
		this.qty = qty;
		this.reportPeriodType = reportPeriodType;
		this.eqType = eqType;
		this.pagerows = pagerows;
		this.currency = currency;
		this.toDt = toDt;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.division = division;
		this.component = component;
		this.vndrSeq = vndrSeq;
		this.locationCd = locationCd;
		this.repair = repair;
		this.rhq = rhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("damage", getDamage());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("report_period_type", getReportPeriodType());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("currency", getCurrency());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("division", getDivision());
		this.hashColumns.put("component", getComponent());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("location_cd", getLocationCd());
		this.hashColumns.put("repair", getRepair());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("damage", "damage");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("report_period_type", "reportPeriodType");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("currency", "currency");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("division", "division");
		this.hashFields.put("component", "component");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("location_cd", "locationCd");
		this.hashFields.put("repair", "repair");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return damage
	 */
	public String getDamage() {
		return this.damage;
	}
	
	/**
	 * Column Info
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
	}
	
	/**
	 * Column Info
	 * @return reportPeriodType
	 */
	public String getReportPeriodType() {
		return this.reportPeriodType;
	}
	
	/**
	 * Column Info
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
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
	 * @return currency
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return division
	 */
	public String getDivision() {
		return this.division;
	}
	
	/**
	 * Column Info
	 * @return component
	 */
	public String getComponent() {
		return this.component;
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
	 * @return locationCd
	 */
	public String getLocationCd() {
		return this.locationCd;
	}
	
	/**
	 * Column Info
	 * @return repair
	 */
	public String getRepair() {
		return this.repair;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	

	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param damage
	 */
	public void setDamage(String damage) {
		this.damage = damage;
	}
	
	/**
	 * Column Info
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	/**
	 * Column Info
	 * @param reportPeriodType
	 */
	public void setReportPeriodType(String reportPeriodType) {
		this.reportPeriodType = reportPeriodType;
	}
	
	/**
	 * Column Info
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
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
	 * @param currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param division
	 */
	public void setDivision(String division) {
		this.division = division;
	}
	
	/**
	 * Column Info
	 * @param component
	 */
	public void setComponent(String component) {
		this.component = component;
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
	 * @param locationCd
	 */
	public void setLocationCd(String locationCd) {
		this.locationCd = locationCd;
	}
	
	/**
	 * Column Info
	 * @param repair
	 */
	public void setRepair(String repair) {
		this.repair = repair;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setDamage(JSPUtil.getParameter(request, "damage", ""));
		setQty(JSPUtil.getParameter(request, "qty", ""));
		setReportPeriodType(JSPUtil.getParameter(request, "report_period_type", ""));
		setEqType(JSPUtil.getParameter(request, "eq_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCurrency(JSPUtil.getParameter(request, "currency", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDivision(JSPUtil.getParameter(request, "division", ""));
		setComponent(JSPUtil.getParameter(request, "component", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setLocationCd(JSPUtil.getParameter(request, "location_cd", ""));
		setRepair(JSPUtil.getParameter(request, "repair", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairPFMCByRepairCodeINVO[]
	 */
	public RepairPFMCByRepairCodeINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairPFMCByRepairCodeINVO[]
	 */
	public RepairPFMCByRepairCodeINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairPFMCByRepairCodeINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] damage = (JSPUtil.getParameter(request, prefix	+ "damage", length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty", length));
			String[] reportPeriodType = (JSPUtil.getParameter(request, prefix	+ "report_period_type", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] currency = (JSPUtil.getParameter(request, prefix	+ "currency", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] division = (JSPUtil.getParameter(request, prefix	+ "division", length));
			String[] component = (JSPUtil.getParameter(request, prefix	+ "component", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] locationCd = (JSPUtil.getParameter(request, prefix	+ "location_cd", length));
			String[] repair = (JSPUtil.getParameter(request, prefix	+ "repair", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairPFMCByRepairCodeINVO();
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (damage[i] != null)
					model.setDamage(damage[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (reportPeriodType[i] != null)
					model.setReportPeriodType(reportPeriodType[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (currency[i] != null)
					model.setCurrency(currency[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (division[i] != null)
					model.setDivision(division[i]);
				if (component[i] != null)
					model.setComponent(component[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (locationCd[i] != null)
					model.setLocationCd(locationCd[i]);
				if (repair[i] != null)
					model.setRepair(repair[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairPFMCByRepairCodeINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairPFMCByRepairCodeINVO[]
	 */
	public RepairPFMCByRepairCodeINVO[] getRepairPFMCByRepairCodeINVOs(){
		RepairPFMCByRepairCodeINVO[] vos = (RepairPFMCByRepairCodeINVO[])models.toArray(new RepairPFMCByRepairCodeINVO[models.size()]);
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
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.damage = this.damage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportPeriodType = this.reportPeriodType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currency = this.currency .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.division = this.division .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.component = this.component .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCd = this.locationCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repair = this.repair .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
