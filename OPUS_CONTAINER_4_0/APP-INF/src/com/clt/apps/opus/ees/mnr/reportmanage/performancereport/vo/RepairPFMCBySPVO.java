/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairPFMCBySPVO.java
*@FileTitle : RepairPFMCBySPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.26
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.05.26 함형석 
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
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairPFMCBySPVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairPFMCBySPVO> models = new ArrayList<RepairPFMCBySPVO>();
	
	/* Column Info */
	private String lessor = null;
	/* Column Info */
	private String loc = null;
	/* Column Info */
	private String fqaQty = null;
	/* Column Info */
	private String avgDays = null;
	/* Column Info */
	private String compo = null;
	/* Column Info */
	private String lessorCd = null;
	/* Column Info */
	private String eqType = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String spCd = null;
	/* Column Info */
	private String amt = null;
	/* Column Info */
	private String unit = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String yardCd = null;
	/* Column Info */
	private String spNm = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String fqaDt = null;
	/* Column Info */
	private String avgAmt = null;
	/* Column Info */
	private String curr = null;
	/* Column Info */
	private String lessorNm = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RepairPFMCBySPVO() {}

	public RepairPFMCBySPVO(String ibflag, String pagerows, String lessor, String loc, String fqaQty, String avgDays, String compo, String lessorCd, String eqType, String spCd, String amt, String unit, String ofcCd, String yardCd, String tpsz, String spNm, String avgAmt, String fqaDt, String curr, String lessorNm, String rhq, String vndrSeq) {
		this.lessor = lessor;
		this.loc = loc;
		this.fqaQty = fqaQty;
		this.avgDays = avgDays;
		this.compo = compo;
		this.lessorCd = lessorCd;
		this.eqType = eqType;
		this.pagerows = pagerows;
		this.spCd = spCd;
		this.amt = amt;
		this.unit = unit;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.tpsz = tpsz;
		this.yardCd = yardCd;
		this.spNm = spNm;
		this.vndrSeq = vndrSeq;
		this.fqaDt = fqaDt;
		this.avgAmt = avgAmt;
		this.curr = curr;
		this.lessorNm = lessorNm;
		this.rhq = rhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lessor", getLessor());
		this.hashColumns.put("loc", getLoc());
		this.hashColumns.put("fqa_qty", getFqaQty());
		this.hashColumns.put("avg_days", getAvgDays());
		this.hashColumns.put("compo", getCompo());
		this.hashColumns.put("lessor_cd", getLessorCd());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sp_cd", getSpCd());
		this.hashColumns.put("amt", getAmt());
		this.hashColumns.put("unit", getUnit());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("yard_cd", getYardCd());
		this.hashColumns.put("sp_nm", getSpNm());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("fqa_dt", getFqaDt());
		this.hashColumns.put("avg_amt", getAvgAmt());
		this.hashColumns.put("curr", getCurr());
		this.hashColumns.put("lessor_nm", getLessorNm());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lessor", "lessor");
		this.hashFields.put("loc", "loc");
		this.hashFields.put("fqa_qty", "fqaQty");
		this.hashFields.put("avg_days", "avgDays");
		this.hashFields.put("compo", "compo");
		this.hashFields.put("lessor_cd", "lessorCd");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sp_cd", "spCd");
		this.hashFields.put("amt", "amt");
		this.hashFields.put("unit", "unit");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("yard_cd", "yardCd");
		this.hashFields.put("sp_nm", "spNm");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("fqa_dt", "fqaDt");
		this.hashFields.put("avg_amt", "avgAmt");
		this.hashFields.put("curr", "curr");
		this.hashFields.put("lessor_nm", "lessorNm");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lessor
	 */
	public String getLessor() {
		return this.lessor;
	}
	
	/**
	 * Column Info
	 * @return loc
	 */
	public String getLoc() {
		return this.loc;
	}
	
	/**
	 * Column Info
	 * @return fqaQty
	 */
	public String getFqaQty() {
		return this.fqaQty;
	}
	
	/**
	 * Column Info
	 * @return avgDays
	 */
	public String getAvgDays() {
		return this.avgDays;
	}
	
	/**
	 * Column Info
	 * @return compo
	 */
	public String getCompo() {
		return this.compo;
	}
	
	/**
	 * Column Info
	 * @return lessorCd
	 */
	public String getLessorCd() {
		return this.lessorCd;
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
	 * @return spCd
	 */
	public String getSpCd() {
		return this.spCd;
	}
	
	/**
	 * Column Info
	 * @return amt
	 */
	public String getAmt() {
		return this.amt;
	}
	
	/**
	 * Column Info
	 * @return unit
	 */
	public String getUnit() {
		return this.unit;
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
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return yardCd
	 */
	public String getYardCd() {
		return this.yardCd;
	}
	
	/**
	 * Column Info
	 * @return spNm
	 */
	public String getSpNm() {
		return this.spNm;
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
	 * @return fqaDt
	 */
	public String getFqaDt() {
		return this.fqaDt;
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
	 * @return curr
	 */
	public String getCurr() {
		return this.curr;
	}
	
	/**
	 * Column Info
	 * @return lessorNm
	 */
	public String getLessorNm() {
		return this.lessorNm;
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
	 * @param lessor
	 */
	public void setLessor(String lessor) {
		this.lessor = lessor;
	}
	
	/**
	 * Column Info
	 * @param loc
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	/**
	 * Column Info
	 * @param fqaQty
	 */
	public void setFqaQty(String fqaQty) {
		this.fqaQty = fqaQty;
	}
	
	/**
	 * Column Info
	 * @param avgDays
	 */
	public void setAvgDays(String avgDays) {
		this.avgDays = avgDays;
	}
	
	/**
	 * Column Info
	 * @param compo
	 */
	public void setCompo(String compo) {
		this.compo = compo;
	}
	
	/**
	 * Column Info
	 * @param lessorCd
	 */
	public void setLessorCd(String lessorCd) {
		this.lessorCd = lessorCd;
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
	 * @param spCd
	 */
	public void setSpCd(String spCd) {
		this.spCd = spCd;
	}
	
	/**
	 * Column Info
	 * @param amt
	 */
	public void setAmt(String amt) {
		this.amt = amt;
	}
	
	/**
	 * Column Info
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
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
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	
	/**
	 * Column Info
	 * @param yardCd
	 */
	public void setYardCd(String yardCd) {
		this.yardCd = yardCd;
	}
	
	/**
	 * Column Info
	 * @param spNm
	 */
	public void setSpNm(String spNm) {
		this.spNm = spNm;
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
	 * @param fqaDt
	 */
	public void setFqaDt(String fqaDt) {
		this.fqaDt = fqaDt;
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
	 * @param curr
	 */
	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	/**
	 * Column Info
	 * @param lessorNm
	 */
	public void setLessorNm(String lessorNm) {
		this.lessorNm = lessorNm;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setLessor(JSPUtil.getParameter(request, prefix + "lessor", ""));
		setLoc(JSPUtil.getParameter(request, prefix + "loc", ""));
		setFqaQty(JSPUtil.getParameter(request, prefix + "fqa_qty", ""));
		setAvgDays(JSPUtil.getParameter(request, prefix + "avg_days", ""));
		setCompo(JSPUtil.getParameter(request, prefix + "compo", ""));
		setLessorCd(JSPUtil.getParameter(request, prefix + "lessor_cd", ""));
		setEqType(JSPUtil.getParameter(request, prefix + "eq_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSpCd(JSPUtil.getParameter(request, prefix + "sp_cd", ""));
		setAmt(JSPUtil.getParameter(request, prefix + "amt", ""));
		setUnit(JSPUtil.getParameter(request, prefix + "unit", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTpsz(JSPUtil.getParameter(request, prefix + "tpsz", ""));
		setYardCd(JSPUtil.getParameter(request, prefix + "yard_cd", ""));
		setSpNm(JSPUtil.getParameter(request, prefix + "sp_nm", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setFqaDt(JSPUtil.getParameter(request, prefix + "fqa_dt", ""));
		setAvgAmt(JSPUtil.getParameter(request, prefix + "avg_amt", ""));
		setCurr(JSPUtil.getParameter(request, prefix + "curr", ""));
		setLessorNm(JSPUtil.getParameter(request, prefix + "lessor_nm", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairPFMCBySPVO[]
	 */
	public RepairPFMCBySPVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairPFMCBySPVO[]
	 */
	public RepairPFMCBySPVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairPFMCBySPVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lessor = (JSPUtil.getParameter(request, prefix	+ "lessor", length));
			String[] loc = (JSPUtil.getParameter(request, prefix	+ "loc", length));
			String[] fqaQty = (JSPUtil.getParameter(request, prefix	+ "fqa_qty", length));
			String[] avgDays = (JSPUtil.getParameter(request, prefix	+ "avg_days", length));
			String[] compo = (JSPUtil.getParameter(request, prefix	+ "compo", length));
			String[] lessorCd = (JSPUtil.getParameter(request, prefix	+ "lessor_cd", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] spCd = (JSPUtil.getParameter(request, prefix	+ "sp_cd", length));
			String[] amt = (JSPUtil.getParameter(request, prefix	+ "amt", length));
			String[] unit = (JSPUtil.getParameter(request, prefix	+ "unit", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] yardCd = (JSPUtil.getParameter(request, prefix	+ "yard_cd", length));
			String[] spNm = (JSPUtil.getParameter(request, prefix	+ "sp_nm", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] fqaDt = (JSPUtil.getParameter(request, prefix	+ "fqa_dt", length));
			String[] avgAmt = (JSPUtil.getParameter(request, prefix	+ "avg_amt", length));
			String[] curr = (JSPUtil.getParameter(request, prefix	+ "curr", length));
			String[] lessorNm = (JSPUtil.getParameter(request, prefix	+ "lessor_nm", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairPFMCBySPVO();
				if (lessor[i] != null)
					model.setLessor(lessor[i]);
				if (loc[i] != null)
					model.setLoc(loc[i]);
				if (fqaQty[i] != null)
					model.setFqaQty(fqaQty[i]);
				if (avgDays[i] != null)
					model.setAvgDays(avgDays[i]);
				if (compo[i] != null)
					model.setCompo(compo[i]);
				if (lessorCd[i] != null)
					model.setLessorCd(lessorCd[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (spCd[i] != null)
					model.setSpCd(spCd[i]);
				if (amt[i] != null)
					model.setAmt(amt[i]);
				if (unit[i] != null)
					model.setUnit(unit[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (yardCd[i] != null)
					model.setYardCd(yardCd[i]);
				if (spNm[i] != null)
					model.setSpNm(spNm[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (fqaDt[i] != null)
					model.setFqaDt(fqaDt[i]);
				if (avgAmt[i] != null)
					model.setAvgAmt(avgAmt[i]);
				if (curr[i] != null)
					model.setCurr(curr[i]);
				if (lessorNm[i] != null)
					model.setLessorNm(lessorNm[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairPFMCBySPVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairPFMCBySPVO[]
	 */
	public RepairPFMCBySPVO[] getRepairPFMCBySPVOs(){
		RepairPFMCBySPVO[] vos = (RepairPFMCBySPVO[])models.toArray(new RepairPFMCBySPVO[models.size()]);
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
		this.lessor = this.lessor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loc = this.loc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fqaQty = this.fqaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgDays = this.avgDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.compo = this.compo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessorCd = this.lessorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCd = this.spCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt = this.amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit = this.unit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCd = this.yardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spNm = this.spNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fqaDt = this.fqaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgAmt = this.avgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curr = this.curr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessorNm = this.lessorNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
