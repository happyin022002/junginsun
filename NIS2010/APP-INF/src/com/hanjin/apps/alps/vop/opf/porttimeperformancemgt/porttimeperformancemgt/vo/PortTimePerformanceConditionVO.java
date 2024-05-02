/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortTimePerformanceConditionVO.java
*@FileTitle : PortTimePerformanceConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortTimePerformanceConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortTimePerformanceConditionVO> models = new ArrayList<PortTimePerformanceConditionVO>();
	
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String kpiVerSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String frDt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String kpiTgtYr = null;
	/* Column Info */
	private String portKpiDirCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortTimePerformanceConditionVO() {}

	public PortTimePerformanceConditionVO(String ibflag, String pagerows, String kpiVerSeq, String rhqOfcCd, String toDt, String gubun, String slanCd, String kpiTgtYr, String portCd, String frDt, String portKpiDirCd, String clptIndSeq) {
		this.toDt = toDt;
		this.rhqOfcCd = rhqOfcCd;
		this.kpiVerSeq = kpiVerSeq;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.gubun = gubun;
		this.clptIndSeq = clptIndSeq;
		this.frDt = frDt;
		this.portCd = portCd;
		this.kpiTgtYr = kpiTgtYr;
		this.portKpiDirCd = portKpiDirCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("kpi_ver_seq", getKpiVerSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("fr_dt", getFrDt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("kpi_tgt_yr", getKpiTgtYr());
		this.hashColumns.put("port_kpi_dir_cd", getPortKpiDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("kpi_ver_seq", "kpiVerSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("fr_dt", "frDt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("kpi_tgt_yr", "kpiTgtYr");
		this.hashFields.put("port_kpi_dir_cd", "portKpiDirCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return kpiVerSeq
	 */
	public String getKpiVerSeq() {
		return this.kpiVerSeq;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return frDt
	 */
	public String getFrDt() {
		return this.frDt;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return kpiTgtYr
	 */
	public String getKpiTgtYr() {
		return this.kpiTgtYr;
	}
	
	/**
	 * Column Info
	 * @return portKpiDirCd
	 */
	public String getPortKpiDirCd() {
		return this.portKpiDirCd;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param kpiVerSeq
	 */
	public void setKpiVerSeq(String kpiVerSeq) {
		this.kpiVerSeq = kpiVerSeq;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param frDt
	 */
	public void setFrDt(String frDt) {
		this.frDt = frDt;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param kpiTgtYr
	 */
	public void setKpiTgtYr(String kpiTgtYr) {
		this.kpiTgtYr = kpiTgtYr;
	}
	
	/**
	 * Column Info
	 * @param portKpiDirCd
	 */
	public void setPortKpiDirCd(String portKpiDirCd) {
		this.portKpiDirCd = portKpiDirCd;
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
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setKpiVerSeq(JSPUtil.getParameter(request, prefix + "kpi_ver_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setGubun(JSPUtil.getParameter(request, prefix + "gubun", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setFrDt(JSPUtil.getParameter(request, prefix + "fr_dt", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setKpiTgtYr(JSPUtil.getParameter(request, prefix + "kpi_tgt_yr", ""));
		setPortKpiDirCd(JSPUtil.getParameter(request, prefix + "port_kpi_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortTimePerformanceConditionVO[]
	 */
	public PortTimePerformanceConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortTimePerformanceConditionVO[]
	 */
	public PortTimePerformanceConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortTimePerformanceConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] kpiVerSeq = (JSPUtil.getParameter(request, prefix	+ "kpi_ver_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] frDt = (JSPUtil.getParameter(request, prefix	+ "fr_dt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] kpiTgtYr = (JSPUtil.getParameter(request, prefix	+ "kpi_tgt_yr", length));
			String[] portKpiDirCd = (JSPUtil.getParameter(request, prefix	+ "port_kpi_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortTimePerformanceConditionVO();
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (kpiVerSeq[i] != null)
					model.setKpiVerSeq(kpiVerSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (frDt[i] != null)
					model.setFrDt(frDt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (kpiTgtYr[i] != null)
					model.setKpiTgtYr(kpiTgtYr[i]);
				if (portKpiDirCd[i] != null)
					model.setPortKpiDirCd(portKpiDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortTimePerformanceConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortTimePerformanceConditionVO[]
	 */
	public PortTimePerformanceConditionVO[] getPortTimePerformanceConditionVOs(){
		PortTimePerformanceConditionVO[] vos = (PortTimePerformanceConditionVO[])models.toArray(new PortTimePerformanceConditionVO[models.size()]);
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
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiVerSeq = this.kpiVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frDt = this.frDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiTgtYr = this.kpiTgtYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portKpiDirCd = this.portKpiDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
