/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DisposalPFMCByRegionGRPVO.java
*@FileTitle : DisposalPFMCByRegionGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.01.11 김완규 
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
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DisposalPFMCByRegionGRPVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DisposalPFMCByRegionGRPVO> models = new ArrayList<DisposalPFMCByRegionGRPVO>();
	
	/* Column Info */
	private String dispTpCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String toMon = null;
	/* Column Info */
	private String buyerCode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String reportType = null;
	/* Column Info */
	private String fromMon = null;
	/* Column Info */
	private String eqKind = null;
	/* Column Info */
	private String usdOnly = null;
	/* Column Info */
	private String rhq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DisposalPFMCByRegionGRPVO() {}

	public DisposalPFMCByRegionGRPVO(String ibflag, String pagerows, String ofcCd, String buyerCode, String toMon, String reportType, String fromMon, String eqKind, String rhq, String dispTpCd, String usdOnly) {
		this.dispTpCd = dispTpCd;
		this.ofcCd = ofcCd;
		this.toMon = toMon;
		this.buyerCode = buyerCode;
		this.ibflag = ibflag;
		this.reportType = reportType;
		this.fromMon = fromMon;
		this.eqKind = eqKind;
		this.usdOnly = usdOnly;
		this.rhq = rhq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("disp_tp_cd", getDispTpCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("to_mon", getToMon());
		this.hashColumns.put("buyer_code", getBuyerCode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("report_type", getReportType());
		this.hashColumns.put("from_mon", getFromMon());
		this.hashColumns.put("eq_kind", getEqKind());
		this.hashColumns.put("usd_only", getUsdOnly());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("disp_tp_cd", "dispTpCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("to_mon", "toMon");
		this.hashFields.put("buyer_code", "buyerCode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("report_type", "reportType");
		this.hashFields.put("from_mon", "fromMon");
		this.hashFields.put("eq_kind", "eqKind");
		this.hashFields.put("usd_only", "usdOnly");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dispTpCd
	 */
	public String getDispTpCd() {
		return this.dispTpCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return toMon
	 */
	public String getToMon() {
		return this.toMon;
	}
	
	/**
	 * Column Info
	 * @return buyerCode
	 */
	public String getBuyerCode() {
		return this.buyerCode;
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
	 * @return reportType
	 */
	public String getReportType() {
		return this.reportType;
	}
	
	/**
	 * Column Info
	 * @return fromMon
	 */
	public String getFromMon() {
		return this.fromMon;
	}
	
	/**
	 * Column Info
	 * @return eqKind
	 */
	public String getEqKind() {
		return this.eqKind;
	}
	
	/**
	 * Column Info
	 * @return usdOnly
	 */
	public String getUsdOnly() {
		return this.usdOnly;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
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
	 * @param dispTpCd
	 */
	public void setDispTpCd(String dispTpCd) {
		this.dispTpCd = dispTpCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param toMon
	 */
	public void setToMon(String toMon) {
		this.toMon = toMon;
	}
	
	/**
	 * Column Info
	 * @param buyerCode
	 */
	public void setBuyerCode(String buyerCode) {
		this.buyerCode = buyerCode;
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
	 * @param reportType
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	
	/**
	 * Column Info
	 * @param fromMon
	 */
	public void setFromMon(String fromMon) {
		this.fromMon = fromMon;
	}
	
	/**
	 * Column Info
	 * @param eqKind
	 */
	public void setEqKind(String eqKind) {
		this.eqKind = eqKind;
	}
	
	/**
	 * Column Info
	 * @param usdOnly
	 */
	public void setUsdOnly(String usdOnly) {
		this.usdOnly = usdOnly;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
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
		setDispTpCd(JSPUtil.getParameter(request, "disp_tp_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setToMon(JSPUtil.getParameter(request, "to_mon", ""));
		setBuyerCode(JSPUtil.getParameter(request, "buyer_code", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setReportType(JSPUtil.getParameter(request, "report_type", ""));
		setFromMon(JSPUtil.getParameter(request, "from_mon", ""));
		setEqKind(JSPUtil.getParameter(request, "eq_kind", ""));
		setUsdOnly(JSPUtil.getParameter(request, "usd_only", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalPFMCByRegionGRPVO[]
	 */
	public DisposalPFMCByRegionGRPVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DisposalPFMCByRegionGRPVO[]
	 */
	public DisposalPFMCByRegionGRPVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalPFMCByRegionGRPVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dispTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_tp_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] toMon = (JSPUtil.getParameter(request, prefix	+ "to_mon", length));
			String[] buyerCode = (JSPUtil.getParameter(request, prefix	+ "buyer_code", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] reportType = (JSPUtil.getParameter(request, prefix	+ "report_type", length));
			String[] fromMon = (JSPUtil.getParameter(request, prefix	+ "from_mon", length));
			String[] eqKind = (JSPUtil.getParameter(request, prefix	+ "eq_kind", length));
			String[] usdOnly = (JSPUtil.getParameter(request, prefix	+ "usd_only", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DisposalPFMCByRegionGRPVO();
				if (dispTpCd[i] != null)
					model.setDispTpCd(dispTpCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (toMon[i] != null)
					model.setToMon(toMon[i]);
				if (buyerCode[i] != null)
					model.setBuyerCode(buyerCode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (reportType[i] != null)
					model.setReportType(reportType[i]);
				if (fromMon[i] != null)
					model.setFromMon(fromMon[i]);
				if (eqKind[i] != null)
					model.setEqKind(eqKind[i]);
				if (usdOnly[i] != null)
					model.setUsdOnly(usdOnly[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDisposalPFMCByRegionGRPVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalPFMCByRegionGRPVO[]
	 */
	public DisposalPFMCByRegionGRPVO[] getDisposalPFMCByRegionGRPVOs(){
		DisposalPFMCByRegionGRPVO[] vos = (DisposalPFMCByRegionGRPVO[])models.toArray(new DisposalPFMCByRegionGRPVO[models.size()]);
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
		this.dispTpCd = this.dispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMon = this.toMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyerCode = this.buyerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportType = this.reportType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromMon = this.fromMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKind = this.eqKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdOnly = this.usdOnly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
