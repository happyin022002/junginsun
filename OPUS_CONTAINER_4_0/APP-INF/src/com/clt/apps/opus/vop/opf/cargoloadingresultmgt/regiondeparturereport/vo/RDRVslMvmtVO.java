/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RDRVslMvmtVO.java
*@FileTitle : RDRVslMvmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.05 장강철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RDRVslMvmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRVslMvmtVO> models = new ArrayList<RDRVslMvmtVO>();
	
	/* Column Info */
	private String depTime = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String callInd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String berthTime = null;
	/* Column Info */
	private String arrTime = null;
	/* Column Info */
	private String nextDate = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String unberthTime = null;
	/* Column Info */
	private String nextPort = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRVslMvmtVO() {}

	public RDRVslMvmtVO(String ibflag, String pagerows, String port, String arrTime, String berthTime, String unberthTime, String depTime, String portCd, String callInd, String nextDate, String nextPort) {
		this.depTime = depTime;
		this.port = port;
		this.callInd = callInd;
		this.ibflag = ibflag;
		this.berthTime = berthTime;
		this.arrTime = arrTime;
		this.nextDate = nextDate;
		this.portCd = portCd;
		this.unberthTime = unberthTime;
		this.nextPort = nextPort;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dep_time", getDepTime());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("call_ind", getCallInd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("berth_time", getBerthTime());
		this.hashColumns.put("arr_time", getArrTime());
		this.hashColumns.put("next_date", getNextDate());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("unberth_time", getUnberthTime());
		this.hashColumns.put("next_port", getNextPort());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dep_time", "depTime");
		this.hashFields.put("port", "port");
		this.hashFields.put("call_ind", "callInd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("berth_time", "berthTime");
		this.hashFields.put("arr_time", "arrTime");
		this.hashFields.put("next_date", "nextDate");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("unberth_time", "unberthTime");
		this.hashFields.put("next_port", "nextPort");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return depTime
	 */
	public String getDepTime() {
		return this.depTime;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return callInd
	 */
	public String getCallInd() {
		return this.callInd;
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
	 * @return berthTime
	 */
	public String getBerthTime() {
		return this.berthTime;
	}
	
	/**
	 * Column Info
	 * @return arrTime
	 */
	public String getArrTime() {
		return this.arrTime;
	}
	
	/**
	 * Column Info
	 * @return nextDate
	 */
	public String getNextDate() {
		return this.nextDate;
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
	 * @return unberthTime
	 */
	public String getUnberthTime() {
		return this.unberthTime;
	}
	
	/**
	 * Column Info
	 * @return nextPort
	 */
	public String getNextPort() {
		return this.nextPort;
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
	 * @param depTime
	 */
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	
	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param callInd
	 */
	public void setCallInd(String callInd) {
		this.callInd = callInd;
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
	 * @param berthTime
	 */
	public void setBerthTime(String berthTime) {
		this.berthTime = berthTime;
	}
	
	/**
	 * Column Info
	 * @param arrTime
	 */
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	
	/**
	 * Column Info
	 * @param nextDate
	 */
	public void setNextDate(String nextDate) {
		this.nextDate = nextDate;
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
	 * @param unberthTime
	 */
	public void setUnberthTime(String unberthTime) {
		this.unberthTime = unberthTime;
	}
	
	/**
	 * Column Info
	 * @param nextPort
	 */
	public void setNextPort(String nextPort) {
		this.nextPort = nextPort;
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
		setDepTime(JSPUtil.getParameter(request, "dep_time", ""));
		setPort(JSPUtil.getParameter(request, "port", ""));
		setCallInd(JSPUtil.getParameter(request, "call_ind", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBerthTime(JSPUtil.getParameter(request, "berth_time", ""));
		setArrTime(JSPUtil.getParameter(request, "arr_time", ""));
		setNextDate(JSPUtil.getParameter(request, "next_date", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setUnberthTime(JSPUtil.getParameter(request, "unberth_time", ""));
		setNextPort(JSPUtil.getParameter(request, "next_port", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRVslMvmtVO[]
	 */
	public RDRVslMvmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRVslMvmtVO[]
	 */
	public RDRVslMvmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRVslMvmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] depTime = (JSPUtil.getParameter(request, prefix	+ "dep_time", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] callInd = (JSPUtil.getParameter(request, prefix	+ "call_ind", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] berthTime = (JSPUtil.getParameter(request, prefix	+ "berth_time", length));
			String[] arrTime = (JSPUtil.getParameter(request, prefix	+ "arr_time", length));
			String[] nextDate = (JSPUtil.getParameter(request, prefix	+ "next_date", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] unberthTime = (JSPUtil.getParameter(request, prefix	+ "unberth_time", length));
			String[] nextPort = (JSPUtil.getParameter(request, prefix	+ "next_port", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRVslMvmtVO();
				if (depTime[i] != null)
					model.setDepTime(depTime[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (callInd[i] != null)
					model.setCallInd(callInd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (berthTime[i] != null)
					model.setBerthTime(berthTime[i]);
				if (arrTime[i] != null)
					model.setArrTime(arrTime[i]);
				if (nextDate[i] != null)
					model.setNextDate(nextDate[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (unberthTime[i] != null)
					model.setUnberthTime(unberthTime[i]);
				if (nextPort[i] != null)
					model.setNextPort(nextPort[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRVslMvmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRVslMvmtVO[]
	 */
	public RDRVslMvmtVO[] getRDRVslMvmtVOs(){
		RDRVslMvmtVO[] vos = (RDRVslMvmtVO[])models.toArray(new RDRVslMvmtVO[models.size()]);
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
		this.depTime = this.depTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callInd = this.callInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.berthTime = this.berthTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrTime = this.arrTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextDate = this.nextDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unberthTime = this.unberthTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPort = this.nextPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
