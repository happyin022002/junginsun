/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MyBiddingINVO.java
*@FileTitle : MyBiddingINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.02.19 김완규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MyBiddingINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MyBiddingINVO> models = new ArrayList<MyBiddingINVO>();
	
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String selectedDispNo = null;
	/* Column Info */
	private String dispStDtFm = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String spPtalId = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String programId = null;
	/* Column Info */
	private String biddingStatus = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String dispUtTpCd = null;
	/* Column Info */
	private String dispStDtTo = null;
	/* Column Info */
	private String locationType = null;
	/* Column Info */
	private String locationCountryCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MyBiddingINVO() {}

	public MyBiddingINVO(String ibflag, String pagerows, String result, String selectedDispNo, String dispStDtFm, String dispNo, String spPtalId, String eqKndCd, String biddingStatus, String eqNo, String dispUtTpCd, String dispStDtTo, String locationType, String locationCountryCd, String programId) {
		this.result = result;
		this.selectedDispNo = selectedDispNo;
		this.dispStDtFm = dispStDtFm;
		this.dispNo = dispNo;
		this.spPtalId = spPtalId;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.programId = programId;
		this.biddingStatus = biddingStatus;
		this.eqNo = eqNo;
		this.dispUtTpCd = dispUtTpCd;
		this.dispStDtTo = dispStDtTo;
		this.locationType = locationType;
		this.locationCountryCd = locationCountryCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("selected_disp_no", getSelectedDispNo());
		this.hashColumns.put("disp_st_dt_fm", getDispStDtFm());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("sp_ptal_id", getSpPtalId());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("program_id", getProgramId());
		this.hashColumns.put("bidding_status", getBiddingStatus());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("disp_ut_tp_cd", getDispUtTpCd());
		this.hashColumns.put("disp_st_dt_to", getDispStDtTo());
		this.hashColumns.put("location_type", getLocationType());
		this.hashColumns.put("location_country_cd", getLocationCountryCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("result", "result");
		this.hashFields.put("selected_disp_no", "selectedDispNo");
		this.hashFields.put("disp_st_dt_fm", "dispStDtFm");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("sp_ptal_id", "spPtalId");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("program_id", "programId");
		this.hashFields.put("bidding_status", "biddingStatus");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("disp_ut_tp_cd", "dispUtTpCd");
		this.hashFields.put("disp_st_dt_to", "dispStDtTo");
		this.hashFields.put("location_type", "locationType");
		this.hashFields.put("location_country_cd", "locationCountryCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return selectedDispNo
	 */
	public String getSelectedDispNo() {
		return this.selectedDispNo;
	}
	
	/**
	 * Column Info
	 * @return dispStDtFm
	 */
	public String getDispStDtFm() {
		return this.dispStDtFm;
	}
	
	/**
	 * Column Info
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return spPtalId
	 */
	public String getSpPtalId() {
		return this.spPtalId;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return programId
	 */
	public String getProgramId() {
		return this.programId;
	}
	
	/**
	 * Column Info
	 * @return biddingStatus
	 */
	public String getBiddingStatus() {
		return this.biddingStatus;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return dispUtTpCd
	 */
	public String getDispUtTpCd() {
		return this.dispUtTpCd;
	}
	
	/**
	 * Column Info
	 * @return dispStDtTo
	 */
	public String getDispStDtTo() {
		return this.dispStDtTo;
	}
	
	/**
	 * Column Info
	 * @return locationType
	 */
	public String getLocationType() {
		return this.locationType;
	}
	
	/**
	 * Column Info
	 * @return locationCountryCd
	 */
	public String getLocationCountryCd() {
		return this.locationCountryCd;
	}
	

	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param selectedDispNo
	 */
	public void setSelectedDispNo(String selectedDispNo) {
		this.selectedDispNo = selectedDispNo;
	}
	
	/**
	 * Column Info
	 * @param dispStDtFm
	 */
	public void setDispStDtFm(String dispStDtFm) {
		this.dispStDtFm = dispStDtFm;
	}
	
	/**
	 * Column Info
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param spPtalId
	 */
	public void setSpPtalId(String spPtalId) {
		this.spPtalId = spPtalId;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param programId
	 */
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	
	/**
	 * Column Info
	 * @param biddingStatus
	 */
	public void setBiddingStatus(String biddingStatus) {
		this.biddingStatus = biddingStatus;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param dispUtTpCd
	 */
	public void setDispUtTpCd(String dispUtTpCd) {
		this.dispUtTpCd = dispUtTpCd;
	}
	
	/**
	 * Column Info
	 * @param dispStDtTo
	 */
	public void setDispStDtTo(String dispStDtTo) {
		this.dispStDtTo = dispStDtTo;
	}
	
	/**
	 * Column Info
	 * @param locationType
	 */
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	
	/**
	 * Column Info
	 * @param locationCountryCd
	 */
	public void setLocationCountryCd(String locationCountryCd) {
		this.locationCountryCd = locationCountryCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setResult(JSPUtil.getParameter(request, "result", ""));
		setSelectedDispNo(JSPUtil.getParameter(request, "selected_disp_no", ""));
		setDispStDtFm(JSPUtil.getParameter(request, "disp_st_dt_fm", ""));
		setDispNo(JSPUtil.getParameter(request, "disp_no", ""));
		setSpPtalId(JSPUtil.getParameter(request, "sp_ptal_id", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setProgramId(JSPUtil.getParameter(request, "program_id", ""));
		setBiddingStatus(JSPUtil.getParameter(request, "bidding_status", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setDispUtTpCd(JSPUtil.getParameter(request, "disp_ut_tp_cd", ""));
		setDispStDtTo(JSPUtil.getParameter(request, "disp_st_dt_to", ""));
		setLocationType(JSPUtil.getParameter(request, "location_type", ""));
		setLocationCountryCd(JSPUtil.getParameter(request, "location_country_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MyBiddingINVO[]
	 */
	public MyBiddingINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MyBiddingINVO[]
	 */
	public MyBiddingINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MyBiddingINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] selectedDispNo = (JSPUtil.getParameter(request, prefix	+ "selected_disp_no", length));
			String[] dispStDtFm = (JSPUtil.getParameter(request, prefix	+ "disp_st_dt_fm", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] spPtalId = (JSPUtil.getParameter(request, prefix	+ "sp_ptal_id", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] programId = (JSPUtil.getParameter(request, prefix	+ "program_id", length));
			String[] biddingStatus = (JSPUtil.getParameter(request, prefix	+ "bidding_status", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] dispUtTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_ut_tp_cd", length));
			String[] dispStDtTo = (JSPUtil.getParameter(request, prefix	+ "disp_st_dt_to", length));
			String[] locationType = (JSPUtil.getParameter(request, prefix	+ "location_type", length));
			String[] locationCountryCd = (JSPUtil.getParameter(request, prefix	+ "location_country_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MyBiddingINVO();
				if (result[i] != null)
					model.setResult(result[i]);
				if (selectedDispNo[i] != null)
					model.setSelectedDispNo(selectedDispNo[i]);
				if (dispStDtFm[i] != null)
					model.setDispStDtFm(dispStDtFm[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (spPtalId[i] != null)
					model.setSpPtalId(spPtalId[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (programId[i] != null)
					model.setProgramId(programId[i]);
				if (biddingStatus[i] != null)
					model.setBiddingStatus(biddingStatus[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (dispUtTpCd[i] != null)
					model.setDispUtTpCd(dispUtTpCd[i]);
				if (dispStDtTo[i] != null)
					model.setDispStDtTo(dispStDtTo[i]);
				if (locationType[i] != null)
					model.setLocationType(locationType[i]);
				if (locationCountryCd[i] != null)
					model.setLocationCountryCd(locationCountryCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMyBiddingINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MyBiddingINVO[]
	 */
	public MyBiddingINVO[] getMyBiddingINVOs(){
		MyBiddingINVO[] vos = (MyBiddingINVO[])models.toArray(new MyBiddingINVO[models.size()]);
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
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selectedDispNo = this.selectedDispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStDtFm = this.dispStDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spPtalId = this.spPtalId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.programId = this.programId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.biddingStatus = this.biddingStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtTpCd = this.dispUtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStDtTo = this.dispStDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationType = this.locationType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCountryCd = this.locationCountryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
