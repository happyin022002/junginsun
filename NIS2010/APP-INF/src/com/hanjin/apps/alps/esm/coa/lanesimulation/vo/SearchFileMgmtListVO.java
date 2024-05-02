/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchFileMgmtListVO.java
*@FileTitle : SearchFileMgmtListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.01.14 윤진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.lanesimulation.vo;

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
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFileMgmtListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFileMgmtListVO> models = new ArrayList<SearchFileMgmtListVO>();
	
	/* Column Info */
	private String num = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String simRmk = null;
	/* Column Info */
	private String simRptNo = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String report = null;
	/* Column Info */
	private String simDt = null;
	/* Column Info */
	private String simulationNo = null;
	/* Column Info */
	private String simNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchFileMgmtListVO() {}

	public SearchFileMgmtListVO(String ibflag, String pagerows, String slanCd, String simulationNo, String simRptNo, String simRmk, String simDt, String simNo, String num, String report, String userId) {
		this.num = num;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.simRmk = simRmk;
		this.simRptNo = simRptNo;
		this.userId = userId;
		this.report = report;
		this.simDt = simDt;
		this.simulationNo = simulationNo;
		this.simNo = simNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("num", getNum());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("sim_rmk", getSimRmk());
		this.hashColumns.put("sim_rpt_no", getSimRptNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("report", getReport());
		this.hashColumns.put("sim_dt", getSimDt());
		this.hashColumns.put("simulation_no", getSimulationNo());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("num", "num");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("sim_rmk", "simRmk");
		this.hashFields.put("sim_rpt_no", "simRptNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("report", "report");
		this.hashFields.put("sim_dt", "simDt");
		this.hashFields.put("simulation_no", "simulationNo");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return num
	 */
	public String getNum() {
		return this.num;
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
	 * @return simRmk
	 */
	public String getSimRmk() {
		return this.simRmk;
	}
	
	/**
	 * Column Info
	 * @return simRptNo
	 */
	public String getSimRptNo() {
		return this.simRptNo;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return report
	 */
	public String getReport() {
		return this.report;
	}
	
	/**
	 * Column Info
	 * @return simDt
	 */
	public String getSimDt() {
		return this.simDt;
	}
	
	/**
	 * Column Info
	 * @return simulationNo
	 */
	public String getSimulationNo() {
		return this.simulationNo;
	}
	
	/**
	 * Column Info
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
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
	 * @param num
	 */
	public void setNum(String num) {
		this.num = num;
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
	 * @param simRmk
	 */
	public void setSimRmk(String simRmk) {
		this.simRmk = simRmk;
	}
	
	/**
	 * Column Info
	 * @param simRptNo
	 */
	public void setSimRptNo(String simRptNo) {
		this.simRptNo = simRptNo;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param report
	 */
	public void setReport(String report) {
		this.report = report;
	}
	
	/**
	 * Column Info
	 * @param simDt
	 */
	public void setSimDt(String simDt) {
		this.simDt = simDt;
	}
	
	/**
	 * Column Info
	 * @param simulationNo
	 */
	public void setSimulationNo(String simulationNo) {
		this.simulationNo = simulationNo;
	}
	
	/**
	 * Column Info
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
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
		setNum(JSPUtil.getParameter(request, "num", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, "f_slan_cd", ""));
		setSimRmk(JSPUtil.getParameter(request, "sim_rmk", ""));
		setSimRptNo(JSPUtil.getParameter(request, "sim_rpt_no", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setReport(JSPUtil.getParameter(request, "report", ""));
		setSimDt(JSPUtil.getParameter(request, "sim_dt", ""));
		setSimulationNo(JSPUtil.getParameter(request, "simulation_no", ""));
		setSimNo(JSPUtil.getParameter(request, "sim_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFileMgmtListVO[]
	 */
	public SearchFileMgmtListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFileMgmtListVO[]
	 */
	public SearchFileMgmtListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFileMgmtListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] num = (JSPUtil.getParameter(request, prefix	+ "num", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] simRmk = (JSPUtil.getParameter(request, prefix	+ "sim_rmk", length));
			String[] simRptNo = (JSPUtil.getParameter(request, prefix	+ "sim_rpt_no", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] report = (JSPUtil.getParameter(request, prefix	+ "report", length));
			String[] simDt = (JSPUtil.getParameter(request, prefix	+ "sim_dt", length));
			String[] simulationNo = (JSPUtil.getParameter(request, prefix	+ "simulation_no", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFileMgmtListVO();
				if (num[i] != null)
					model.setNum(num[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (simRmk[i] != null)
					model.setSimRmk(simRmk[i]);
				if (simRptNo[i] != null)
					model.setSimRptNo(simRptNo[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (report[i] != null)
					model.setReport(report[i]);
				if (simDt[i] != null)
					model.setSimDt(simDt[i]);
				if (simulationNo[i] != null)
					model.setSimulationNo(simulationNo[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFileMgmtListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFileMgmtListVO[]
	 */
	public SearchFileMgmtListVO[] getSearchFileMgmtListVOs(){
		SearchFileMgmtListVO[] vos = (SearchFileMgmtListVO[])models.toArray(new SearchFileMgmtListVO[models.size()]);
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
		this.num = this.num .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simRmk = this.simRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simRptNo = this.simRptNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.report = this.report .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simDt = this.simDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simulationNo = this.simulationNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
