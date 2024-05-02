/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GraphPerformanceListVO.java
*@FileTitle : GraphPerformanceListVO
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

public class GraphPerformanceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GraphPerformanceListVO> models = new ArrayList<GraphPerformanceListVO>();
	
	/* Column Info */
	private String stmInHrs = null;
	/* Column Info */
	private String grossCraneProd = null;
	/* Column Info */
	private String departureTime = null;
	/* Column Info */
	private String ttlMvs = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String grsCrnProdHrs = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String steamInTime = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String arrivalTime = null;
	/* Column Info */
	private String vslDepHrs = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String operationTimeT = null;
	/* Column Info */
	private String vslArrHrs = null;
	/* Column Info */
	private String tmlOpHrs = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GraphPerformanceListVO() {}

	public GraphPerformanceListVO(String ibflag, String pagerows, String rhq, String portCd, String clptIndSeq, String skdDirCd, String ydCd, String slanCd, String vvdCd, String ttlMvs, String steamInTime, String arrivalTime, String operationTimeT, String departureTime, String grossCraneProd, String stmInHrs, String vslArrHrs, String tmlOpHrs, String vslDepHrs, String grsCrnProdHrs) {
		this.stmInHrs = stmInHrs;
		this.grossCraneProd = grossCraneProd;
		this.departureTime = departureTime;
		this.ttlMvs = ttlMvs;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.grsCrnProdHrs = grsCrnProdHrs;
		this.ibflag = ibflag;
		this.steamInTime = steamInTime;
		this.slanCd = slanCd;
		this.arrivalTime = arrivalTime;
		this.vslDepHrs = vslDepHrs;
		this.vvdCd = vvdCd;
		this.ydCd = ydCd;
		this.clptIndSeq = clptIndSeq;
		this.operationTimeT = operationTimeT;
		this.vslArrHrs = vslArrHrs;
		this.tmlOpHrs = tmlOpHrs;
		this.portCd = portCd;
		this.rhq = rhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("stm_in_hrs", getStmInHrs());
		this.hashColumns.put("gross_crane_prod", getGrossCraneProd());
		this.hashColumns.put("departure_time", getDepartureTime());
		this.hashColumns.put("ttl_mvs", getTtlMvs());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("grs_crn_prod_hrs", getGrsCrnProdHrs());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("steam_in_time", getSteamInTime());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("arrival_time", getArrivalTime());
		this.hashColumns.put("vsl_dep_hrs", getVslDepHrs());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("operation_time_t", getOperationTimeT());
		this.hashColumns.put("vsl_arr_hrs", getVslArrHrs());
		this.hashColumns.put("tml_op_hrs", getTmlOpHrs());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("stm_in_hrs", "stmInHrs");
		this.hashFields.put("gross_crane_prod", "grossCraneProd");
		this.hashFields.put("departure_time", "departureTime");
		this.hashFields.put("ttl_mvs", "ttlMvs");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("grs_crn_prod_hrs", "grsCrnProdHrs");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("steam_in_time", "steamInTime");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("arrival_time", "arrivalTime");
		this.hashFields.put("vsl_dep_hrs", "vslDepHrs");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("operation_time_t", "operationTimeT");
		this.hashFields.put("vsl_arr_hrs", "vslArrHrs");
		this.hashFields.put("tml_op_hrs", "tmlOpHrs");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stmInHrs
	 */
	public String getStmInHrs() {
		return this.stmInHrs;
	}
	
	/**
	 * Column Info
	 * @return grossCraneProd
	 */
	public String getGrossCraneProd() {
		return this.grossCraneProd;
	}
	
	/**
	 * Column Info
	 * @return departureTime
	 */
	public String getDepartureTime() {
		return this.departureTime;
	}
	
	/**
	 * Column Info
	 * @return ttlMvs
	 */
	public String getTtlMvs() {
		return this.ttlMvs;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return grsCrnProdHrs
	 */
	public String getGrsCrnProdHrs() {
		return this.grsCrnProdHrs;
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
	 * @return steamInTime
	 */
	public String getSteamInTime() {
		return this.steamInTime;
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
	 * @return arrivalTime
	 */
	public String getArrivalTime() {
		return this.arrivalTime;
	}
	
	/**
	 * Column Info
	 * @return vslDepHrs
	 */
	public String getVslDepHrs() {
		return this.vslDepHrs;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return operationTimeT
	 */
	public String getOperationTimeT() {
		return this.operationTimeT;
	}
	
	/**
	 * Column Info
	 * @return vslArrHrs
	 */
	public String getVslArrHrs() {
		return this.vslArrHrs;
	}
	
	/**
	 * Column Info
	 * @return tmlOpHrs
	 */
	public String getTmlOpHrs() {
		return this.tmlOpHrs;
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
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	

	/**
	 * Column Info
	 * @param stmInHrs
	 */
	public void setStmInHrs(String stmInHrs) {
		this.stmInHrs = stmInHrs;
	}
	
	/**
	 * Column Info
	 * @param grossCraneProd
	 */
	public void setGrossCraneProd(String grossCraneProd) {
		this.grossCraneProd = grossCraneProd;
	}
	
	/**
	 * Column Info
	 * @param departureTime
	 */
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	/**
	 * Column Info
	 * @param ttlMvs
	 */
	public void setTtlMvs(String ttlMvs) {
		this.ttlMvs = ttlMvs;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param grsCrnProdHrs
	 */
	public void setGrsCrnProdHrs(String grsCrnProdHrs) {
		this.grsCrnProdHrs = grsCrnProdHrs;
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
	 * @param steamInTime
	 */
	public void setSteamInTime(String steamInTime) {
		this.steamInTime = steamInTime;
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
	 * @param arrivalTime
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	/**
	 * Column Info
	 * @param vslDepHrs
	 */
	public void setVslDepHrs(String vslDepHrs) {
		this.vslDepHrs = vslDepHrs;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param operationTimeT
	 */
	public void setOperationTimeT(String operationTimeT) {
		this.operationTimeT = operationTimeT;
	}
	
	/**
	 * Column Info
	 * @param vslArrHrs
	 */
	public void setVslArrHrs(String vslArrHrs) {
		this.vslArrHrs = vslArrHrs;
	}
	
	/**
	 * Column Info
	 * @param tmlOpHrs
	 */
	public void setTmlOpHrs(String tmlOpHrs) {
		this.tmlOpHrs = tmlOpHrs;
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
		setStmInHrs(JSPUtil.getParameter(request, prefix + "stm_in_hrs", ""));
		setGrossCraneProd(JSPUtil.getParameter(request, prefix + "gross_crane_prod", ""));
		setDepartureTime(JSPUtil.getParameter(request, prefix + "departure_time", ""));
		setTtlMvs(JSPUtil.getParameter(request, prefix + "ttl_mvs", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setGrsCrnProdHrs(JSPUtil.getParameter(request, prefix + "grs_crn_prod_hrs", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSteamInTime(JSPUtil.getParameter(request, prefix + "steam_in_time", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setArrivalTime(JSPUtil.getParameter(request, prefix + "arrival_time", ""));
		setVslDepHrs(JSPUtil.getParameter(request, prefix + "vsl_dep_hrs", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setOperationTimeT(JSPUtil.getParameter(request, prefix + "operation_time_t", ""));
		setVslArrHrs(JSPUtil.getParameter(request, prefix + "vsl_arr_hrs", ""));
		setTmlOpHrs(JSPUtil.getParameter(request, prefix + "tml_op_hrs", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GraphPerformanceListVO[]
	 */
	public GraphPerformanceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GraphPerformanceListVO[]
	 */
	public GraphPerformanceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GraphPerformanceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stmInHrs = (JSPUtil.getParameter(request, prefix	+ "stm_in_hrs", length));
			String[] grossCraneProd = (JSPUtil.getParameter(request, prefix	+ "gross_crane_prod", length));
			String[] departureTime = (JSPUtil.getParameter(request, prefix	+ "departure_time", length));
			String[] ttlMvs = (JSPUtil.getParameter(request, prefix	+ "ttl_mvs", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] grsCrnProdHrs = (JSPUtil.getParameter(request, prefix	+ "grs_crn_prod_hrs", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] steamInTime = (JSPUtil.getParameter(request, prefix	+ "steam_in_time", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] arrivalTime = (JSPUtil.getParameter(request, prefix	+ "arrival_time", length));
			String[] vslDepHrs = (JSPUtil.getParameter(request, prefix	+ "vsl_dep_hrs", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] operationTimeT = (JSPUtil.getParameter(request, prefix	+ "operation_time_t", length));
			String[] vslArrHrs = (JSPUtil.getParameter(request, prefix	+ "vsl_arr_hrs", length));
			String[] tmlOpHrs = (JSPUtil.getParameter(request, prefix	+ "tml_op_hrs", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new GraphPerformanceListVO();
				if (stmInHrs[i] != null)
					model.setStmInHrs(stmInHrs[i]);
				if (grossCraneProd[i] != null)
					model.setGrossCraneProd(grossCraneProd[i]);
				if (departureTime[i] != null)
					model.setDepartureTime(departureTime[i]);
				if (ttlMvs[i] != null)
					model.setTtlMvs(ttlMvs[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (grsCrnProdHrs[i] != null)
					model.setGrsCrnProdHrs(grsCrnProdHrs[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (steamInTime[i] != null)
					model.setSteamInTime(steamInTime[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (arrivalTime[i] != null)
					model.setArrivalTime(arrivalTime[i]);
				if (vslDepHrs[i] != null)
					model.setVslDepHrs(vslDepHrs[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (operationTimeT[i] != null)
					model.setOperationTimeT(operationTimeT[i]);
				if (vslArrHrs[i] != null)
					model.setVslArrHrs(vslArrHrs[i]);
				if (tmlOpHrs[i] != null)
					model.setTmlOpHrs(tmlOpHrs[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGraphPerformanceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GraphPerformanceListVO[]
	 */
	public GraphPerformanceListVO[] getGraphPerformanceListVOs(){
		GraphPerformanceListVO[] vos = (GraphPerformanceListVO[])models.toArray(new GraphPerformanceListVO[models.size()]);
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
		this.stmInHrs = this.stmInHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grossCraneProd = this.grossCraneProd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.departureTime = this.departureTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMvs = this.ttlMvs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsCrnProdHrs = this.grsCrnProdHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steamInTime = this.steamInTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrivalTime = this.arrivalTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDepHrs = this.vslDepHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.operationTimeT = this.operationTimeT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslArrHrs = this.vslArrHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlOpHrs = this.tmlOpHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
