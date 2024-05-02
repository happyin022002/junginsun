/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GraphYtdListVO.java
*@FileTitle : GraphYtdListVO
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

public class GraphYtdListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GraphYtdListVO> models = new ArrayList<GraphYtdListVO>();
	
	/* Column Info */
	private String grossCraneProd = null;
	/* Column Info */
	private String steamInTime = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arrivalTime = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String operationTimeT = null;
	/* Column Info */
	private String departureTime = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String rhq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GraphYtdListVO() {}

	public GraphYtdListVO(String ibflag, String pagerows, String rhq, String portCd, String skdDirCd, String slanCd, String steamInTime, String arrivalTime, String operationTimeT, String departureTime, String grossCraneProd) {
		this.grossCraneProd = grossCraneProd;
		this.steamInTime = steamInTime;
		this.ibflag = ibflag;
		this.arrivalTime = arrivalTime;
		this.slanCd = slanCd;
		this.operationTimeT = operationTimeT;
		this.departureTime = departureTime;
		this.portCd = portCd;
		this.skdDirCd = skdDirCd;
		this.rhq = rhq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gross_crane_prod", getGrossCraneProd());
		this.hashColumns.put("steam_in_time", getSteamInTime());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("arrival_time", getArrivalTime());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("operation_time_t", getOperationTimeT());
		this.hashColumns.put("departure_time", getDepartureTime());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gross_crane_prod", "grossCraneProd");
		this.hashFields.put("steam_in_time", "steamInTime");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("arrival_time", "arrivalTime");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("operation_time_t", "operationTimeT");
		this.hashFields.put("departure_time", "departureTime");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return steamInTime
	 */
	public String getSteamInTime() {
		return this.steamInTime;
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
	 * @return arrivalTime
	 */
	public String getArrivalTime() {
		return this.arrivalTime;
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
	 * @return operationTimeT
	 */
	public String getOperationTimeT() {
		return this.operationTimeT;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @param grossCraneProd
	 */
	public void setGrossCraneProd(String grossCraneProd) {
		this.grossCraneProd = grossCraneProd;
	}
	
	/**
	 * Column Info
	 * @param steamInTime
	 */
	public void setSteamInTime(String steamInTime) {
		this.steamInTime = steamInTime;
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
	 * @param arrivalTime
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
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
	 * @param operationTimeT
	 */
	public void setOperationTimeT(String operationTimeT) {
		this.operationTimeT = operationTimeT;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
		setGrossCraneProd(JSPUtil.getParameter(request, prefix + "gross_crane_prod", ""));
		setSteamInTime(JSPUtil.getParameter(request, prefix + "steam_in_time", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setArrivalTime(JSPUtil.getParameter(request, prefix + "arrival_time", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setOperationTimeT(JSPUtil.getParameter(request, prefix + "operation_time_t", ""));
		setDepartureTime(JSPUtil.getParameter(request, prefix + "departure_time", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GraphYtdListVO[]
	 */
	public GraphYtdListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GraphYtdListVO[]
	 */
	public GraphYtdListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GraphYtdListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] grossCraneProd = (JSPUtil.getParameter(request, prefix	+ "gross_crane_prod", length));
			String[] steamInTime = (JSPUtil.getParameter(request, prefix	+ "steam_in_time", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arrivalTime = (JSPUtil.getParameter(request, prefix	+ "arrival_time", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] operationTimeT = (JSPUtil.getParameter(request, prefix	+ "operation_time_t", length));
			String[] departureTime = (JSPUtil.getParameter(request, prefix	+ "departure_time", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GraphYtdListVO();
				if (grossCraneProd[i] != null)
					model.setGrossCraneProd(grossCraneProd[i]);
				if (steamInTime[i] != null)
					model.setSteamInTime(steamInTime[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arrivalTime[i] != null)
					model.setArrivalTime(arrivalTime[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (operationTimeT[i] != null)
					model.setOperationTimeT(operationTimeT[i]);
				if (departureTime[i] != null)
					model.setDepartureTime(departureTime[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGraphYtdListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GraphYtdListVO[]
	 */
	public GraphYtdListVO[] getGraphYtdListVOs(){
		GraphYtdListVO[] vos = (GraphYtdListVO[])models.toArray(new GraphYtdListVO[models.size()]);
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
		this.grossCraneProd = this.grossCraneProd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steamInTime = this.steamInTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrivalTime = this.arrivalTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.operationTimeT = this.operationTimeT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.departureTime = this.departureTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
