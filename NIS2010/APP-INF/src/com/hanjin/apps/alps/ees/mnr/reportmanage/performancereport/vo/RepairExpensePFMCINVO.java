/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairExpensePFMCINVO.java
*@FileTitle : RepairExpensePFMCINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.29
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.09.29 박명신 
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

public class RepairExpensePFMCINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairExpensePFMCINVO> models = new ArrayList<RepairExpensePFMCINVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String toMon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String reportType = null;
	/* Column Info */
	private String backendjobKey = null;
	/* Column Info */
	private String fromMon = null;
	/* Column Info */
	private String rhq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepairExpensePFMCINVO() {}

	public RepairExpensePFMCINVO(String ibflag, String pagerows, String backendjobKey, String fromMon, String toMon, String ofcCd, String reportType, String rhq) {
		this.ofcCd = ofcCd;
		this.toMon = toMon;
		this.ibflag = ibflag;
		this.reportType = reportType;
		this.backendjobKey = backendjobKey;
		this.fromMon = fromMon;
		this.rhq = rhq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("to_mon", getToMon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("report_type", getReportType());
		this.hashColumns.put("backendjob_key", getBackendjobKey());
		this.hashColumns.put("from_mon", getFromMon());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("to_mon", "toMon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("report_type", "reportType");
		this.hashFields.put("backendjob_key", "backendjobKey");
		this.hashFields.put("from_mon", "fromMon");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return backendjobKey
	 */
	public String getBackendjobKey() {
		return this.backendjobKey;
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
	 * @param backendjobKey
	 */
	public void setBackendjobKey(String backendjobKey) {
		this.backendjobKey = backendjobKey;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setToMon(JSPUtil.getParameter(request, prefix + "to_mon", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setReportType(JSPUtil.getParameter(request, prefix + "report_type", ""));
		setBackendjobKey(JSPUtil.getParameter(request, prefix + "backendjob_key", ""));
		setFromMon(JSPUtil.getParameter(request, prefix + "from_mon", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairExpensePFMCINVO[]
	 */
	public RepairExpensePFMCINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairExpensePFMCINVO[]
	 */
	public RepairExpensePFMCINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairExpensePFMCINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] toMon = (JSPUtil.getParameter(request, prefix	+ "to_mon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] reportType = (JSPUtil.getParameter(request, prefix	+ "report_type", length));
			String[] backendjobKey = (JSPUtil.getParameter(request, prefix	+ "backendjob_key", length));
			String[] fromMon = (JSPUtil.getParameter(request, prefix	+ "from_mon", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairExpensePFMCINVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (toMon[i] != null)
					model.setToMon(toMon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (reportType[i] != null)
					model.setReportType(reportType[i]);
				if (backendjobKey[i] != null)
					model.setBackendjobKey(backendjobKey[i]);
				if (fromMon[i] != null)
					model.setFromMon(fromMon[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairExpensePFMCINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairExpensePFMCINVO[]
	 */
	public RepairExpensePFMCINVO[] getRepairExpensePFMCINVOs(){
		RepairExpensePFMCINVO[] vos = (RepairExpensePFMCINVO[])models.toArray(new RepairExpensePFMCINVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMon = this.toMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportType = this.reportType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backendjobKey = this.backendjobKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromMon = this.fromMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
