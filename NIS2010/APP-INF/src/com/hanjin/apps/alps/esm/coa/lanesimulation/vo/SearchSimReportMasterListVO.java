/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSimReportMasterListVO.java
*@FileTitle : SearchSimReportMasterListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.10.28 윤진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.lanesimulation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSimReportMasterListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSimReportMasterListVO> models = new ArrayList<SearchSimReportMasterListVO>();
	
	/* Column Info */
	private String bnkCostAmt = null;
	/* Column Info */
	private String simDt = null;
	/* Column Info */
	private String sectNo = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String simNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ldfRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String simRmk = null;
	/* Column Info */
	private String simRptNo = null;
	/* Column Info */
	private String grsRpbRev = null;
	/* Column Info */
	private String simulationNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSimReportMasterListVO() {}

	public SearchSimReportMasterListVO(String ibflag, String pagerows, String simDt, String simNo, String simulationNo, String sectNo, String simRptNo, String rlaneCd, String skdDirCd, String ldfRto, String grsRpbRev, String bnkCostAmt, String simRmk) {
		this.bnkCostAmt = bnkCostAmt;
		this.simDt = simDt;
		this.sectNo = sectNo;
		this.rlaneCd = rlaneCd;
		this.simNo = simNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.ldfRto = ldfRto;
		this.ibflag = ibflag;
		this.simRmk = simRmk;
		this.simRptNo = simRptNo;
		this.grsRpbRev = grsRpbRev;
		this.simulationNo = simulationNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bnk_cost_amt", getBnkCostAmt());
		this.hashColumns.put("sim_dt", getSimDt());
		this.hashColumns.put("sect_no", getSectNo());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ldf_rto", getLdfRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sim_rmk", getSimRmk());
		this.hashColumns.put("sim_rpt_no", getSimRptNo());
		this.hashColumns.put("grs_rpb_rev", getGrsRpbRev());
		this.hashColumns.put("simulation_no", getSimulationNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bnk_cost_amt", "bnkCostAmt");
		this.hashFields.put("sim_dt", "simDt");
		this.hashFields.put("sect_no", "sectNo");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ldf_rto", "ldfRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sim_rmk", "simRmk");
		this.hashFields.put("sim_rpt_no", "simRptNo");
		this.hashFields.put("grs_rpb_rev", "grsRpbRev");
		this.hashFields.put("simulation_no", "simulationNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bnkCostAmt
	 */
	public String getBnkCostAmt() {
		return this.bnkCostAmt;
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
	 * @return sectNo
	 */
	public String getSectNo() {
		return this.sectNo;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
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
	 * @return ldfRto
	 */
	public String getLdfRto() {
		return this.ldfRto;
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
	 * @return grsRpbRev
	 */
	public String getGrsRpbRev() {
		return this.grsRpbRev;
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
	 * @param bnkCostAmt
	 */
	public void setBnkCostAmt(String bnkCostAmt) {
		this.bnkCostAmt = bnkCostAmt;
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
	 * @param sectNo
	 */
	public void setSectNo(String sectNo) {
		this.sectNo = sectNo;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
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
	 * @param ldfRto
	 */
	public void setLdfRto(String ldfRto) {
		this.ldfRto = ldfRto;
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
	 * @param grsRpbRev
	 */
	public void setGrsRpbRev(String grsRpbRev) {
		this.grsRpbRev = grsRpbRev;
	}
	
	/**
	 * Column Info
	 * @param simulationNo
	 */
	public void setSimulationNo(String simulationNo) {
		this.simulationNo = simulationNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBnkCostAmt(JSPUtil.getParameter(request, "bnk_cost_amt", ""));
		setSimDt(JSPUtil.getParameter(request, "sim_dt", ""));
		setSectNo(JSPUtil.getParameter(request, "sect_no", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setSimNo(JSPUtil.getParameter(request, "sim_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLdfRto(JSPUtil.getParameter(request, "ldf_rto", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSimRmk(JSPUtil.getParameter(request, "sim_rmk", ""));
		setSimRptNo(JSPUtil.getParameter(request, "sim_rpt_no", ""));
		setGrsRpbRev(JSPUtil.getParameter(request, "grs_rpb_rev", ""));
		setSimulationNo(JSPUtil.getParameter(request, "simulation_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSimReportMasterListVO[]
	 */
	public SearchSimReportMasterListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSimReportMasterListVO[]
	 */
	public SearchSimReportMasterListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSimReportMasterListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bnkCostAmt = (JSPUtil.getParameter(request, prefix	+ "bnk_cost_amt", length));
			String[] simDt = (JSPUtil.getParameter(request, prefix	+ "sim_dt", length));
			String[] sectNo = (JSPUtil.getParameter(request, prefix	+ "sect_no", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ldfRto = (JSPUtil.getParameter(request, prefix	+ "ldf_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] simRmk = (JSPUtil.getParameter(request, prefix	+ "sim_rmk", length));
			String[] simRptNo = (JSPUtil.getParameter(request, prefix	+ "sim_rpt_no", length));
			String[] grsRpbRev = (JSPUtil.getParameter(request, prefix	+ "grs_rpb_rev", length));
			String[] simulationNo = (JSPUtil.getParameter(request, prefix	+ "simulation_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSimReportMasterListVO();
				if (bnkCostAmt[i] != null)
					model.setBnkCostAmt(bnkCostAmt[i]);
				if (simDt[i] != null)
					model.setSimDt(simDt[i]);
				if (sectNo[i] != null)
					model.setSectNo(sectNo[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ldfRto[i] != null)
					model.setLdfRto(ldfRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (simRmk[i] != null)
					model.setSimRmk(simRmk[i]);
				if (simRptNo[i] != null)
					model.setSimRptNo(simRptNo[i]);
				if (grsRpbRev[i] != null)
					model.setGrsRpbRev(grsRpbRev[i]);
				if (simulationNo[i] != null)
					model.setSimulationNo(simulationNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSimReportMasterListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSimReportMasterListVO[]
	 */
	public SearchSimReportMasterListVO[] getSearchSimReportMasterListVOs(){
		SearchSimReportMasterListVO[] vos = (SearchSimReportMasterListVO[])models.toArray(new SearchSimReportMasterListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.bnkCostAmt = this.bnkCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simDt = this.simDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sectNo = this.sectNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldfRto = this.ldfRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simRmk = this.simRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simRptNo = this.simRptNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRpbRev = this.grsRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simulationNo = this.simulationNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
