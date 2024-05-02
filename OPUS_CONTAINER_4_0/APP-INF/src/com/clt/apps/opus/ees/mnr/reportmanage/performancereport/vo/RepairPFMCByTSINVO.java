/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairPFMCByTSINVO.java
*@FileTitle : RepairPFMCByTSINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.28
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.05.28 박명신 
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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairPFMCByTSINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairPFMCByTSINVO> models = new ArrayList<RepairPFMCByTSINVO>();
	
	/* Column Info */
	private String reportType = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String mkrNm = null;
	/* Column Info */
	private String tpSzCd = null;
	/* Column Info */
	private String reportPeriodType = null;
	/* Column Info */
	private String eqType = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String manuYrTo = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String mnrWarrFlg = null;
	/* Column Info */
	private String manuYrFr = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RepairPFMCByTSINVO() {}

	public RepairPFMCByTSINVO(String ibflag, String pagerows, String reportType, String currCd, String fmDt, String tpSzCd, String reportPeriodType, String eqType, String toDt, String ofcCd, String vndrSeq, String manuYrTo, String mnrWarrFlg, String lstmCd, String rhq, String manuYrFr, String mkrNm) {
		this.reportType = reportType;
		this.currCd = currCd;
		this.fmDt = fmDt;
		this.mkrNm = mkrNm;
		this.tpSzCd = tpSzCd;
		this.reportPeriodType = reportPeriodType;
		this.eqType = eqType;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.manuYrTo = manuYrTo;
		this.lstmCd = lstmCd;
		this.mnrWarrFlg = mnrWarrFlg;
		this.manuYrFr = manuYrFr;
		this.rhq = rhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("report_type", getReportType());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("mkr_nm", getMkrNm());
		this.hashColumns.put("tp_sz_cd", getTpSzCd());
		this.hashColumns.put("report_period_type", getReportPeriodType());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("manu_yr_to", getManuYrTo());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("mnr_warr_flg", getMnrWarrFlg());
		this.hashColumns.put("manu_yr_fr", getManuYrFr());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("report_type", "reportType");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("mkr_nm", "mkrNm");
		this.hashFields.put("tp_sz_cd", "tpSzCd");
		this.hashFields.put("report_period_type", "reportPeriodType");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("manu_yr_to", "manuYrTo");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("mnr_warr_flg", "mnrWarrFlg");
		this.hashFields.put("manu_yr_fr", "manuYrFr");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return reportType
	 */
	public String getReportType() {
		return this.reportType;
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
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return mkrNm
	 */
	public String getMkrNm() {
		return this.mkrNm;
	}
	
	/**
	 * Column Info
	 * @return tpSzCd
	 */
	public String getTpSzCd() {
		return this.tpSzCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return manuYrTo
	 */
	public String getManuYrTo() {
		return this.manuYrTo;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return mnrWarrFlg
	 */
	public String getMnrWarrFlg() {
		return this.mnrWarrFlg;
	}
	
	/**
	 * Column Info
	 * @return manuYrFr
	 */
	public String getManuYrFr() {
		return this.manuYrFr;
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
	 * @param reportType
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
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
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param mkrNm
	 */
	public void setMkrNm(String mkrNm) {
		this.mkrNm = mkrNm;
	}
	
	/**
	 * Column Info
	 * @param tpSzCd
	 */
	public void setTpSzCd(String tpSzCd) {
		this.tpSzCd = tpSzCd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param manuYrTo
	 */
	public void setManuYrTo(String manuYrTo) {
		this.manuYrTo = manuYrTo;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param mnrWarrFlg
	 */
	public void setMnrWarrFlg(String mnrWarrFlg) {
		this.mnrWarrFlg = mnrWarrFlg;
	}
	
	/**
	 * Column Info
	 * @param manuYrFr
	 */
	public void setManuYrFr(String manuYrFr) {
		this.manuYrFr = manuYrFr;
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
		setReportType(JSPUtil.getParameter(request, prefix + "report_type", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setMkrNm(JSPUtil.getParameter(request, prefix + "mkr_nm", ""));
		setTpSzCd(JSPUtil.getParameter(request, prefix + "tp_sz_cd", ""));
		setReportPeriodType(JSPUtil.getParameter(request, prefix + "report_period_type", ""));
		setEqType(JSPUtil.getParameter(request, prefix + "eq_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setManuYrTo(JSPUtil.getParameter(request, prefix + "manu_yr_to", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setMnrWarrFlg(JSPUtil.getParameter(request, prefix + "mnr_warr_flg", ""));
		setManuYrFr(JSPUtil.getParameter(request, prefix + "manu_yr_fr", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairPFMCByTSINVO[]
	 */
	public RepairPFMCByTSINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairPFMCByTSINVO[]
	 */
	public RepairPFMCByTSINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairPFMCByTSINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] reportType = (JSPUtil.getParameter(request, prefix	+ "report_type", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] mkrNm = (JSPUtil.getParameter(request, prefix	+ "mkr_nm", length));
			String[] tpSzCd = (JSPUtil.getParameter(request, prefix	+ "tp_sz_cd", length));
			String[] reportPeriodType = (JSPUtil.getParameter(request, prefix	+ "report_period_type", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] manuYrTo = (JSPUtil.getParameter(request, prefix	+ "manu_yr_to", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] mnrWarrFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_warr_flg", length));
			String[] manuYrFr = (JSPUtil.getParameter(request, prefix	+ "manu_yr_fr", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairPFMCByTSINVO();
				if (reportType[i] != null)
					model.setReportType(reportType[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (mkrNm[i] != null)
					model.setMkrNm(mkrNm[i]);
				if (tpSzCd[i] != null)
					model.setTpSzCd(tpSzCd[i]);
				if (reportPeriodType[i] != null)
					model.setReportPeriodType(reportPeriodType[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (manuYrTo[i] != null)
					model.setManuYrTo(manuYrTo[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (mnrWarrFlg[i] != null)
					model.setMnrWarrFlg(mnrWarrFlg[i]);
				if (manuYrFr[i] != null)
					model.setManuYrFr(manuYrFr[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairPFMCByTSINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairPFMCByTSINVO[]
	 */
	public RepairPFMCByTSINVO[] getRepairPFMCByTSINVOs(){
		RepairPFMCByTSINVO[] vos = (RepairPFMCByTSINVO[])models.toArray(new RepairPFMCByTSINVO[models.size()]);
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
		this.reportType = this.reportType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkrNm = this.mkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpSzCd = this.tpSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportPeriodType = this.reportPeriodType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manuYrTo = this.manuYrTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWarrFlg = this.mnrWarrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manuYrFr = this.manuYrFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
