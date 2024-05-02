/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBSPortInfoVO.java
*@FileTitle : SearchBSPortInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.13 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo;

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
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBSPortInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBSPortInfoVO> models = new ArrayList<SearchBSPortInfoVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String vesselPortSpace1 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String toYearWeek = null;
	/* Column Info */
	private String tradeCode = null;
	/* Column Info */
	private String companyCode = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vesselPortCode = null;
	/* Column Info */
	private String vesselPortSpace = null;
	/* Column Info */
	private String vesselPortAverageWeight = null;
	/* Column Info */
	private String vesselPortCode1 = null;
	/* Column Info */
	private String vesselPortCallSequence = null;
	/* Column Info */
	private String vesselPortAverageWeight1 = null;
	/* Column Info */
	private String fromYearWeek = null;
	/* Column Info */
	private String checked = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBSPortInfoVO() {}

	public SearchBSPortInfoVO(String ibflag, String pagerows, String vesselPortCallSequence, String vesselPortCode, String vesselPortSpace, String vesselPortAverageWeight, String vesselPortCode1, String vesselPortSpace1, String vesselPortAverageWeight1, String scnrId, String fromYearWeek, String toYearWeek, String vslCd, String skdVoyNo, String skdDirCd, String companyCode, String tradeCode, String checked) {
		this.vslCd = vslCd;
		this.scnrId = scnrId;
		this.vesselPortSpace1 = vesselPortSpace1;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.toYearWeek = toYearWeek;
		this.tradeCode = tradeCode;
		this.companyCode = companyCode;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.vesselPortCode = vesselPortCode;
		this.vesselPortSpace = vesselPortSpace;
		this.vesselPortAverageWeight = vesselPortAverageWeight;
		this.vesselPortCode1 = vesselPortCode1;
		this.vesselPortCallSequence = vesselPortCallSequence;
		this.vesselPortAverageWeight1 = vesselPortAverageWeight1;
		this.fromYearWeek = fromYearWeek;
		this.checked = checked;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("vessel_port_space1", getVesselPortSpace1());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("to_year_week", getToYearWeek());
		this.hashColumns.put("trade_code", getTradeCode());
		this.hashColumns.put("company_code", getCompanyCode());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vessel_port_code", getVesselPortCode());
		this.hashColumns.put("vessel_port_space", getVesselPortSpace());
		this.hashColumns.put("vessel_port_average_weight", getVesselPortAverageWeight());
		this.hashColumns.put("vessel_port_code1", getVesselPortCode1());
		this.hashColumns.put("vessel_port_call_sequence", getVesselPortCallSequence());
		this.hashColumns.put("vessel_port_average_weight1", getVesselPortAverageWeight1());
		this.hashColumns.put("from_year_week", getFromYearWeek());
		this.hashColumns.put("checked", getChecked());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("vessel_port_space1", "vesselPortSpace1");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("to_year_week", "toYearWeek");
		this.hashFields.put("trade_code", "tradeCode");
		this.hashFields.put("company_code", "companyCode");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vessel_port_code", "vesselPortCode");
		this.hashFields.put("vessel_port_space", "vesselPortSpace");
		this.hashFields.put("vessel_port_average_weight", "vesselPortAverageWeight");
		this.hashFields.put("vessel_port_code1", "vesselPortCode1");
		this.hashFields.put("vessel_port_call_sequence", "vesselPortCallSequence");
		this.hashFields.put("vessel_port_average_weight1", "vesselPortAverageWeight1");
		this.hashFields.put("from_year_week", "fromYearWeek");
		this.hashFields.put("checked", "checked");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
	}
	
	/**
	 * Column Info
	 * @return vesselPortSpace1
	 */
	public String getVesselPortSpace1() {
		return this.vesselPortSpace1;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return toYearWeek
	 */
	public String getToYearWeek() {
		return this.toYearWeek;
	}
	
	/**
	 * Column Info
	 * @return tradeCode
	 */
	public String getTradeCode() {
		return this.tradeCode;
	}
	
	/**
	 * Column Info
	 * @return companyCode
	 */
	public String getCompanyCode() {
		return this.companyCode;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return vesselPortCode
	 */
	public String getVesselPortCode() {
		return this.vesselPortCode;
	}
	
	/**
	 * Column Info
	 * @return vesselPortSpace
	 */
	public String getVesselPortSpace() {
		return this.vesselPortSpace;
	}
	
	/**
	 * Column Info
	 * @return vesselPortAverageWeight
	 */
	public String getVesselPortAverageWeight() {
		return this.vesselPortAverageWeight;
	}
	
	/**
	 * Column Info
	 * @return vesselPortCode1
	 */
	public String getVesselPortCode1() {
		return this.vesselPortCode1;
	}
	
	/**
	 * Column Info
	 * @return vesselPortCallSequence
	 */
	public String getVesselPortCallSequence() {
		return this.vesselPortCallSequence;
	}
	
	/**
	 * Column Info
	 * @return vesselPortAverageWeight1
	 */
	public String getVesselPortAverageWeight1() {
		return this.vesselPortAverageWeight1;
	}
	
	/**
	 * Column Info
	 * @return fromYearWeek
	 */
	public String getFromYearWeek() {
		return this.fromYearWeek;
	}
	
	/**
	 * Column Info
	 * @return checked
	 */
	public String getChecked() {
		return this.checked;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}
	
	/**
	 * Column Info
	 * @param vesselPortSpace1
	 */
	public void setVesselPortSpace1(String vesselPortSpace1) {
		this.vesselPortSpace1 = vesselPortSpace1;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param toYearWeek
	 */
	public void setToYearWeek(String toYearWeek) {
		this.toYearWeek = toYearWeek;
	}
	
	/**
	 * Column Info
	 * @param tradeCode
	 */
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	
	/**
	 * Column Info
	 * @param companyCode
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param vesselPortCode
	 */
	public void setVesselPortCode(String vesselPortCode) {
		this.vesselPortCode = vesselPortCode;
	}
	
	/**
	 * Column Info
	 * @param vesselPortSpace
	 */
	public void setVesselPortSpace(String vesselPortSpace) {
		this.vesselPortSpace = vesselPortSpace;
	}
	
	/**
	 * Column Info
	 * @param vesselPortAverageWeight
	 */
	public void setVesselPortAverageWeight(String vesselPortAverageWeight) {
		this.vesselPortAverageWeight = vesselPortAverageWeight;
	}
	
	/**
	 * Column Info
	 * @param vesselPortCode1
	 */
	public void setVesselPortCode1(String vesselPortCode1) {
		this.vesselPortCode1 = vesselPortCode1;
	}
	
	/**
	 * Column Info
	 * @param vesselPortCallSequence
	 */
	public void setVesselPortCallSequence(String vesselPortCallSequence) {
		this.vesselPortCallSequence = vesselPortCallSequence;
	}
	
	/**
	 * Column Info
	 * @param vesselPortAverageWeight1
	 */
	public void setVesselPortAverageWeight1(String vesselPortAverageWeight1) {
		this.vesselPortAverageWeight1 = vesselPortAverageWeight1;
	}
	
	/**
	 * Column Info
	 * @param fromYearWeek
	 */
	public void setFromYearWeek(String fromYearWeek) {
		this.fromYearWeek = fromYearWeek;
	}
	
	/**
	 * Column Info
	 * @param checked
	 */
	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setVesselPortSpace1(JSPUtil.getParameter(request, "vessel_port_space1", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setToYearWeek(JSPUtil.getParameter(request, "to_year_week", ""));
		setTradeCode(JSPUtil.getParameter(request, "trade_code", ""));
		setCompanyCode(JSPUtil.getParameter(request, "company_code", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVesselPortCode(JSPUtil.getParameter(request, "vessel_port_code", ""));
		setVesselPortSpace(JSPUtil.getParameter(request, "vessel_port_space", ""));
		setVesselPortAverageWeight(JSPUtil.getParameter(request, "vessel_port_average_weight", ""));
		setVesselPortCode1(JSPUtil.getParameter(request, "vessel_port_code1", ""));
		setVesselPortCallSequence(JSPUtil.getParameter(request, "vessel_port_call_sequence", ""));
		setVesselPortAverageWeight1(JSPUtil.getParameter(request, "vessel_port_average_weight1", ""));
		setFromYearWeek(JSPUtil.getParameter(request, "from_year_week", ""));
		setChecked(JSPUtil.getParameter(request, "checked", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBSPortInfoVO[]
	 */
	public SearchBSPortInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBSPortInfoVO[]
	 */
	public SearchBSPortInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBSPortInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] vesselPortSpace1 = (JSPUtil.getParameter(request, prefix	+ "vessel_port_space1", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] toYearWeek = (JSPUtil.getParameter(request, prefix	+ "to_year_week", length));
			String[] tradeCode = (JSPUtil.getParameter(request, prefix	+ "trade_code", length));
			String[] companyCode = (JSPUtil.getParameter(request, prefix	+ "company_code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vesselPortCode = (JSPUtil.getParameter(request, prefix	+ "vessel_port_code", length));
			String[] vesselPortSpace = (JSPUtil.getParameter(request, prefix	+ "vessel_port_space", length));
			String[] vesselPortAverageWeight = (JSPUtil.getParameter(request, prefix	+ "vessel_port_average_weight", length));
			String[] vesselPortCode1 = (JSPUtil.getParameter(request, prefix	+ "vessel_port_code1", length));
			String[] vesselPortCallSequence = (JSPUtil.getParameter(request, prefix	+ "vessel_port_call_sequence", length));
			String[] vesselPortAverageWeight1 = (JSPUtil.getParameter(request, prefix	+ "vessel_port_average_weight1", length));
			String[] fromYearWeek = (JSPUtil.getParameter(request, prefix	+ "from_year_week", length));
			String[] checked = (JSPUtil.getParameter(request, prefix	+ "checked", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBSPortInfoVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (vesselPortSpace1[i] != null)
					model.setVesselPortSpace1(vesselPortSpace1[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (toYearWeek[i] != null)
					model.setToYearWeek(toYearWeek[i]);
				if (tradeCode[i] != null)
					model.setTradeCode(tradeCode[i]);
				if (companyCode[i] != null)
					model.setCompanyCode(companyCode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vesselPortCode[i] != null)
					model.setVesselPortCode(vesselPortCode[i]);
				if (vesselPortSpace[i] != null)
					model.setVesselPortSpace(vesselPortSpace[i]);
				if (vesselPortAverageWeight[i] != null)
					model.setVesselPortAverageWeight(vesselPortAverageWeight[i]);
				if (vesselPortCode1[i] != null)
					model.setVesselPortCode1(vesselPortCode1[i]);
				if (vesselPortCallSequence[i] != null)
					model.setVesselPortCallSequence(vesselPortCallSequence[i]);
				if (vesselPortAverageWeight1[i] != null)
					model.setVesselPortAverageWeight1(vesselPortAverageWeight1[i]);
				if (fromYearWeek[i] != null)
					model.setFromYearWeek(fromYearWeek[i]);
				if (checked[i] != null)
					model.setChecked(checked[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBSPortInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBSPortInfoVO[]
	 */
	public SearchBSPortInfoVO[] getSearchBSPortInfoVOs(){
		SearchBSPortInfoVO[] vos = (SearchBSPortInfoVO[])models.toArray(new SearchBSPortInfoVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselPortSpace1 = this.vesselPortSpace1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYearWeek = this.toYearWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeCode = this.tradeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.companyCode = this.companyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselPortCode = this.vesselPortCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselPortSpace = this.vesselPortSpace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselPortAverageWeight = this.vesselPortAverageWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselPortCode1 = this.vesselPortCode1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselPortCallSequence = this.vesselPortCallSequence .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselPortAverageWeight1 = this.vesselPortAverageWeight1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromYearWeek = this.fromYearWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checked = this.checked .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
