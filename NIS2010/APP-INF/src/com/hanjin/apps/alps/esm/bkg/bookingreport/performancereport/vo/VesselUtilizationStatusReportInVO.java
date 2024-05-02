/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselUtilizationStatusReportInVO.java
*@FileTitle : VesselUtilizationStatusReportInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.11.16 강동윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VesselUtilizationStatusReportInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VesselUtilizationStatusReportInVO> models = new ArrayList<VesselUtilizationStatusReportInVO>();
	
	/* Column Info */
	private String costYear = null;
	/* Column Info */
	private String dtTp = null;
	/* Column Info */
	private String etdFromDt = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String etdToDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String costMonth = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String vslSlanDirCd = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VesselUtilizationStatusReportInVO() {}

	public VesselUtilizationStatusReportInVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String vslSlanDirCd, String slanCd, String vvd, String etdFromDt, String etdToDt, String costYrmon, String costYear, String costMonth, String costWk, String fCmd, String dtTp) {
		this.costYear = costYear;
		this.dtTp = dtTp;
		this.etdFromDt = etdFromDt;
		this.fCmd = fCmd;
		this.trdCd = trdCd;
		this.etdToDt = etdToDt;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.costMonth = costMonth;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.costYrmon = costYrmon;
		this.costWk = costWk;
		this.vslSlanDirCd = vslSlanDirCd;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cost_year", getCostYear());
		this.hashColumns.put("dt_tp", getDtTp());
		this.hashColumns.put("etd_from_dt", getEtdFromDt());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("etd_to_dt", getEtdToDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cost_month", getCostMonth());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("vsl_slan_dir_cd", getVslSlanDirCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cost_year", "costYear");
		this.hashFields.put("dt_tp", "dtTp");
		this.hashFields.put("etd_from_dt", "etdFromDt");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("etd_to_dt", "etdToDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cost_month", "costMonth");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("vsl_slan_dir_cd", "vslSlanDirCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return costYear
	 */
	public String getCostYear() {
		return this.costYear;
	}
	
	/**
	 * Column Info
	 * @return dtTp
	 */
	public String getDtTp() {
		return this.dtTp;
	}
	
	/**
	 * Column Info
	 * @return etdFromDt
	 */
	public String getEtdFromDt() {
		return this.etdFromDt;
	}
	
	/**
	 * Column Info
	 * @return fCmd
	 */
	public String getFCmd() {
		return this.fCmd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return etdToDt
	 */
	public String getEtdToDt() {
		return this.etdToDt;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return costMonth
	 */
	public String getCostMonth() {
		return this.costMonth;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return vslSlanDirCd
	 */
	public String getVslSlanDirCd() {
		return this.vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param costYear
	 */
	public void setCostYear(String costYear) {
		this.costYear = costYear;
	}
	
	/**
	 * Column Info
	 * @param dtTp
	 */
	public void setDtTp(String dtTp) {
		this.dtTp = dtTp;
	}
	
	/**
	 * Column Info
	 * @param etdFromDt
	 */
	public void setEtdFromDt(String etdFromDt) {
		this.etdFromDt = etdFromDt;
	}
	
	/**
	 * Column Info
	 * @param fCmd
	 */
	public void setFCmd(String fCmd) {
		this.fCmd = fCmd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param etdToDt
	 */
	public void setEtdToDt(String etdToDt) {
		this.etdToDt = etdToDt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param costMonth
	 */
	public void setCostMonth(String costMonth) {
		this.costMonth = costMonth;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param vslSlanDirCd
	 */
	public void setVslSlanDirCd(String vslSlanDirCd) {
		this.vslSlanDirCd = vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCostYear(JSPUtil.getParameter(request, "cost_year", ""));
		setDtTp(JSPUtil.getParameter(request, "dt_tp", ""));
		setEtdFromDt(JSPUtil.getParameter(request, "etd_from_dt", ""));
		setFCmd(JSPUtil.getParameter(request, "f_cmd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setEtdToDt(JSPUtil.getParameter(request, "etd_to_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setCostMonth(JSPUtil.getParameter(request, "cost_month", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
		setVslSlanDirCd(JSPUtil.getParameter(request, "vsl_slan_dir_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VesselUtilizationStatusReportInVO[]
	 */
	public VesselUtilizationStatusReportInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VesselUtilizationStatusReportInVO[]
	 */
	public VesselUtilizationStatusReportInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VesselUtilizationStatusReportInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] costYear = (JSPUtil.getParameter(request, prefix	+ "cost_year", length));
			String[] dtTp = (JSPUtil.getParameter(request, prefix	+ "dt_tp", length));
			String[] etdFromDt = (JSPUtil.getParameter(request, prefix	+ "etd_from_dt", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] etdToDt = (JSPUtil.getParameter(request, prefix	+ "etd_to_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] costMonth = (JSPUtil.getParameter(request, prefix	+ "cost_month", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] vslSlanDirCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_dir_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new VesselUtilizationStatusReportInVO();
				if (costYear[i] != null)
					model.setCostYear(costYear[i]);
				if (dtTp[i] != null)
					model.setDtTp(dtTp[i]);
				if (etdFromDt[i] != null)
					model.setEtdFromDt(etdFromDt[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (etdToDt[i] != null)
					model.setEtdToDt(etdToDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (costMonth[i] != null)
					model.setCostMonth(costMonth[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (vslSlanDirCd[i] != null)
					model.setVslSlanDirCd(vslSlanDirCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVesselUtilizationStatusReportInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VesselUtilizationStatusReportInVO[]
	 */
	public VesselUtilizationStatusReportInVO[] getVesselUtilizationStatusReportInVOs(){
		VesselUtilizationStatusReportInVO[] vos = (VesselUtilizationStatusReportInVO[])models.toArray(new VesselUtilizationStatusReportInVO[models.size()]);
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
		this.costYear = this.costYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtTp = this.dtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdFromDt = this.etdFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdToDt = this.etdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costMonth = this.costMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanDirCd = this.vslSlanDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
