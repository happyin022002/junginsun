/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsTot0027ConditionVO.java
*@FileTitle : FnsTot0027ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2010.12.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FnsTot0027ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FnsTot0027ConditionVO> models = new ArrayList<FnsTot0027ConditionVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String batchYear = null;
	/* Column Info */
	private String updChk = null;
	/* Column Info */
	private String stDate = null;
	/* Column Info */
	private String runJob = null;
	/* Column Info */
	private String jobId = null;
	/* Column Info */
	private String batId = null;
	/* Column Info */
	private String searchYear = null;
	/* Column Info */
	private String batItmNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FnsTot0027ConditionVO() {}

	public FnsTot0027ConditionVO(String ibflag, String updChk, String batchYear, String stDate, String runJob, String jobId, String batId, String searchYear, String batItmNm) {
		this.ibflag = ibflag;
		this.updChk = updChk;
		this.batchYear = batchYear;
		this.stDate = stDate;
		this.runJob = runJob;
		this.jobId = jobId;
		this.batId = batId;
		this.searchYear = searchYear;
		this.batItmNm = batItmNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("upd_chk", getUpdChk());
		this.hashColumns.put("batch_year", getBatchYear());
		this.hashColumns.put("st_date", getStDate());
		this.hashColumns.put("run_job", getRunJob());
		this.hashColumns.put("job_id", getJobId());
		this.hashColumns.put("bat_id", getBatId());
		this.hashColumns.put("search_year", getSearchYear());
		this.hashColumns.put("bat_itm_nm", getBatItmNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("updChk", "updChk");
		this.hashFields.put("batchYear", "batchYear");
		this.hashFields.put("stDate", "stDate");
		this.hashFields.put("runJob", "runJob");
		this.hashFields.put("jobId", "jobId");
		this.hashFields.put("batId", "batId");
		this.hashFields.put("searchYear", "searchYear");
		this.hashFields.put("batItmNm", "batItmNm");
		return this.hashFields;
	}
	
	/**
	 * @return the ibflag
	 */
	public String getIbflag() {
		return ibflag;
	}

	/**
	 * @param ibflag the ibflag to set
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * @return the updChk
	 */
	public String getUpdChk() {
		return updChk;
	}

	/**
	 * @param updChk the updChk to set
	 */
	public void setUpdChk(String updChk) {
		this.updChk = updChk;
	}

	/**
	 * @return the batchYear
	 */
	public String getBatchYear() {
		return batchYear;
	}

	/**
	 * @param batchYear the batchYear to set
	 */
	public void setBatchYear(String batchYear) {
		this.batchYear = batchYear;
	}

	/**
	 * @return the stDate
	 */
	public String getStDate() {
		return stDate;
	}

	/**
	 * @param stDate the stDate to set
	 */
	public void setStDate(String stDate) {
		this.stDate = stDate;
	}

	/**
	 * @return the runJob
	 */
	public String getRunJob() {
		return runJob;
	}

	/**
	 * @param runJob the runJob to set
	 */
	public void setRunJob(String runJob) {
		this.runJob = runJob;
	}

	/**
	 * @return the jobId
	 */
	public String getJobId() {
		return jobId;
	}

	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the batId
	 */
	public String getBatId() {
		return batId;
	}

	/**
	 * @param batId the batId to set
	 */
	public void setBatId(String batId) {
		this.batId = batId;
	}

	/**
	 * @return the searchYear
	 */
	public String getSearchYear() {
		return searchYear;
	}

	/**
	 * @param searchYear the searchYear to set
	 */
	public void setSearchYear(String searchYear) {
		this.searchYear = searchYear;
	}
	
	/**
	 * @return the batItmNm
	 */
	public String getBatItmNm() {
		return batItmNm;
	}
	
	/**
	 * @param batItmNm the batItmNm to set
	 */
	public void setBatItmNm(String batItmNm) {
		this.batItmNm = batItmNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUpdChk(JSPUtil.getParameter(request, "upd_chk", ""));
		setBatchYear(JSPUtil.getParameter(request, "batch_year", ""));
		setRunJob(JSPUtil.getParameter(request, "run_job", ""));
		setJobId(JSPUtil.getParameter(request, "job_id", ""));
		setBatId(JSPUtil.getParameter(request, "bat_id", ""));
		setSearchYear(JSPUtil.getParameter(request, "search_year", ""));
		setBatItmNm(JSPUtil.getParameter(request, "bat_itm_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FnsTot0027ConditionVO[]
	 */
	public FnsTot0027ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FnsTot0027ConditionVO[]
	 */
	public FnsTot0027ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FnsTot0027ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] updChk = (JSPUtil.getParameter(request, prefix	+ "upd_chk", length));
			String[] jobId = (JSPUtil.getParameter(request, prefix	+ "job_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new FnsTot0027ConditionVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (updChk[i] != null)
					model.setUpdChk(updChk[i]);
				if (jobId[i] != null)
					model.setJobId(jobId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFnsTot0027ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FnsTot0027ConditionVO[]
	 */
	public FnsTot0027ConditionVO[] getFnsTot0027ConditionVOs(){
		FnsTot0027ConditionVO[] vos = (FnsTot0027ConditionVO[])models.toArray(new FnsTot0027ConditionVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchYear = this.batchYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updChk = this.updChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stDate = this.stDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.runJob = this.runJob .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jobId = this.jobId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batId = this.batId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchYear = this.searchYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batItmNm = this.batItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

}
