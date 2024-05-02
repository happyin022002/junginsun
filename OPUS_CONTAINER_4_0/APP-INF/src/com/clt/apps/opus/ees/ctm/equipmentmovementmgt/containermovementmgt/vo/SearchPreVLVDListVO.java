/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchPreVLVDListVO.java
*@FileTitle : SearchPreVLVDListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.09.17 김상수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPreVLVDListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPreVLVDListVO> models = new ArrayList<SearchPreVLVDListVO>();
	
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String ts = null;
	/* Column Info */
	private String error = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String prebkgDt = null;
	/* Column Info */
	private String orgYard = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String orgEventDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String errorStatus = null;
	/* Column Info */
	private String userNm = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String eventDt = null;
	/* Column Info */
	private String fm = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pDate1 = null;
	/* Column Info */
	private String bkgKnt = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pYard2 = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String pYard1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPreVLVDListVO() {}

	public SearchPreVLVDListVO(String ibflag, String pagerows, String pDate1, String pDate2, String cntrNo, String ts, String status, String orgYard, String pYard1, String pYard2, String error, String errorStatus, String eventDt, String orgEventDt, String vvd, String bkgKnt, String bkgNo, String blNo, String fm, String prebkgDt, String office, String userNm, String userId, String remark) {
		this.office = office;
		this.ts = ts;
		this.error = error;
		this.remark = remark;
		this.status = status;
		this.prebkgDt = prebkgDt;
		this.orgYard = orgYard;
		this.blNo = blNo;
		this.orgEventDt = orgEventDt;
		this.pagerows = pagerows;
		this.errorStatus = errorStatus;
		this.userNm = userNm;
		this.vvd = vvd;
		this.eventDt = eventDt;
		this.fm = fm;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.pDate1 = pDate1;
		this.bkgKnt = bkgKnt;
		this.pDate2 = pDate2;
		this.cntrNo = cntrNo;
		this.pYard2 = pYard2;
		this.userId = userId;
		this.pYard1 = pYard1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("ts", getTs());
		this.hashColumns.put("error", getError());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("prebkg_dt", getPrebkgDt());
		this.hashColumns.put("org_yard", getOrgYard());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("org_event_dt", getOrgEventDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("error_status", getErrorStatus());
		this.hashColumns.put("user_nm", getUserNm());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("event_dt", getEventDt());
		this.hashColumns.put("fm", getFm());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("bkg_knt", getBkgKnt());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("p_yard2", getPYard2());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("p_yard1", getPYard1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("ts", "ts");
		this.hashFields.put("error", "error");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("status", "status");
		this.hashFields.put("prebkg_dt", "prebkgDt");
		this.hashFields.put("org_yard", "orgYard");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("org_event_dt", "orgEventDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("error_status", "errorStatus");
		this.hashFields.put("user_nm", "userNm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("event_dt", "eventDt");
		this.hashFields.put("fm", "fm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("bkg_knt", "bkgKnt");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("p_yard2", "pYard2");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("p_yard1", "pYard1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return ts
	 */
	public String getTs() {
		return this.ts;
	}
	
	/**
	 * Column Info
	 * @return error
	 */
	public String getError() {
		return this.error;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return prebkgDt
	 */
	public String getPrebkgDt() {
		return this.prebkgDt;
	}
	
	/**
	 * Column Info
	 * @return orgYard
	 */
	public String getOrgYard() {
		return this.orgYard;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return orgEventDt
	 */
	public String getOrgEventDt() {
		return this.orgEventDt;
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
	 * @return errorStatus
	 */
	public String getErrorStatus() {
		return this.errorStatus;
	}
	
	/**
	 * Column Info
	 * @return userNm
	 */
	public String getUserNm() {
		return this.userNm;
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
	 * @return eventDt
	 */
	public String getEventDt() {
		return this.eventDt;
	}
	
	/**
	 * Column Info
	 * @return fm
	 */
	public String getFm() {
		return this.fm;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
	}
	
	/**
	 * Column Info
	 * @return bkgKnt
	 */
	public String getBkgKnt() {
		return this.bkgKnt;
	}
	
	/**
	 * Column Info
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return pYard2
	 */
	public String getPYard2() {
		return this.pYard2;
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
	 * @return pYard1
	 */
	public String getPYard1() {
		return this.pYard1;
	}
	

	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param ts
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}
	
	/**
	 * Column Info
	 * @param error
	 */
	public void setError(String error) {
		this.error = error;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param prebkgDt
	 */
	public void setPrebkgDt(String prebkgDt) {
		this.prebkgDt = prebkgDt;
	}
	
	/**
	 * Column Info
	 * @param orgYard
	 */
	public void setOrgYard(String orgYard) {
		this.orgYard = orgYard;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param orgEventDt
	 */
	public void setOrgEventDt(String orgEventDt) {
		this.orgEventDt = orgEventDt;
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
	 * @param errorStatus
	 */
	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}
	
	/**
	 * Column Info
	 * @param userNm
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
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
	 * @param eventDt
	 */
	public void setEventDt(String eventDt) {
		this.eventDt = eventDt;
	}
	
	/**
	 * Column Info
	 * @param fm
	 */
	public void setFm(String fm) {
		this.fm = fm;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
	}
	
	/**
	 * Column Info
	 * @param bkgKnt
	 */
	public void setBkgKnt(String bkgKnt) {
		this.bkgKnt = bkgKnt;
	}
	
	/**
	 * Column Info
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param pYard2
	 */
	public void setPYard2(String pYard2) {
		this.pYard2 = pYard2;
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
	 * @param pYard1
	 */
	public void setPYard1(String pYard1) {
		this.pYard1 = pYard1;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setTs(JSPUtil.getParameter(request, "ts", ""));
		setError(JSPUtil.getParameter(request, "error", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setPrebkgDt(JSPUtil.getParameter(request, "prebkg_dt", ""));
		setOrgYard(JSPUtil.getParameter(request, "org_yard", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setOrgEventDt(JSPUtil.getParameter(request, "org_event_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setErrorStatus(JSPUtil.getParameter(request, "error_status", ""));
		setUserNm(JSPUtil.getParameter(request, "user_nm", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setEventDt(JSPUtil.getParameter(request, "event_dt", ""));
		setFm(JSPUtil.getParameter(request, "fm", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPDate1(JSPUtil.getParameter(request, "p_date1", ""));
		setBkgKnt(JSPUtil.getParameter(request, "bkg_knt", ""));
		setPDate2(JSPUtil.getParameter(request, "p_date2", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPYard2(JSPUtil.getParameter(request, "p_yard2", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setPYard1(JSPUtil.getParameter(request, "p_yard1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPreVLVDListVO[]
	 */
	public SearchPreVLVDListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPreVLVDListVO[]
	 */
	public SearchPreVLVDListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPreVLVDListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] ts = (JSPUtil.getParameter(request, prefix	+ "ts", length));
			String[] error = (JSPUtil.getParameter(request, prefix	+ "error", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] prebkgDt = (JSPUtil.getParameter(request, prefix	+ "prebkg_dt", length));
			String[] orgYard = (JSPUtil.getParameter(request, prefix	+ "org_yard", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] orgEventDt = (JSPUtil.getParameter(request, prefix	+ "org_event_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] errorStatus = (JSPUtil.getParameter(request, prefix	+ "error_status", length));
			String[] userNm = (JSPUtil.getParameter(request, prefix	+ "user_nm", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] eventDt = (JSPUtil.getParameter(request, prefix	+ "event_dt", length));
			String[] fm = (JSPUtil.getParameter(request, prefix	+ "fm", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] bkgKnt = (JSPUtil.getParameter(request, prefix	+ "bkg_knt", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pYard2 = (JSPUtil.getParameter(request, prefix	+ "p_yard2", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPreVLVDListVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (ts[i] != null)
					model.setTs(ts[i]);
				if (error[i] != null)
					model.setError(error[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (prebkgDt[i] != null)
					model.setPrebkgDt(prebkgDt[i]);
				if (orgYard[i] != null)
					model.setOrgYard(orgYard[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (orgEventDt[i] != null)
					model.setOrgEventDt(orgEventDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (errorStatus[i] != null)
					model.setErrorStatus(errorStatus[i]);
				if (userNm[i] != null)
					model.setUserNm(userNm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (eventDt[i] != null)
					model.setEventDt(eventDt[i]);
				if (fm[i] != null)
					model.setFm(fm[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (bkgKnt[i] != null)
					model.setBkgKnt(bkgKnt[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pYard2[i] != null)
					model.setPYard2(pYard2[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPreVLVDListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPreVLVDListVO[]
	 */
	public SearchPreVLVDListVO[] getSearchPreVLVDListVOs(){
		SearchPreVLVDListVO[] vos = (SearchPreVLVDListVO[])models.toArray(new SearchPreVLVDListVO[models.size()]);
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
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts = this.ts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.error = this.error .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prebkgDt = this.prebkgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYard = this.orgYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgEventDt = this.orgEventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorStatus = this.errorStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userNm = this.userNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventDt = this.eventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm = this.fm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgKnt = this.bkgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard2 = this.pYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
