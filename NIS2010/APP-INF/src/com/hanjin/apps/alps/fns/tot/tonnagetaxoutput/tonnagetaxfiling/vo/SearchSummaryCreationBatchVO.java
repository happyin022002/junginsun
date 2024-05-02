/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchSummaryCreationBatchVO.java
*@FileTitle : SearchSummaryCreationBatchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2010.12.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo;

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

public class SearchSummaryCreationBatchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSummaryCreationBatchVO> models = new ArrayList<SearchSummaryCreationBatchVO>();
	
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String jobId = null;
	/* Column Info */
	private String batItmNm = null;
	/* Column Info */
	private String jbToYrmon = null;
	/* Column Info */
	private String jbFmYrmon = null;
	/* Column Info */
	private String jbStatus = null;
	/* Column Info */
	private String batId = null;
	/* Column Info */
	private String jbEndDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSummaryCreationBatchVO() {}

	public SearchSummaryCreationBatchVO(String ibflag, String pagerows, String jbFmYrmon, String jbToYrmon, String batItmNm, String batId, String jbStatus, String effDt, String jbEndDt, String jobId) {
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.jobId = jobId;
		this.batItmNm = batItmNm;
		this.jbToYrmon = jbToYrmon;
		this.jbFmYrmon = jbFmYrmon;
		this.jbStatus = jbStatus;
		this.batId = batId;
		this.jbEndDt = jbEndDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("job_id", getJobId());
		this.hashColumns.put("bat_itm_nm", getBatItmNm());
		this.hashColumns.put("jb_to_yrmon", getJbToYrmon());
		this.hashColumns.put("jb_fm_yrmon", getJbFmYrmon());
		this.hashColumns.put("jb_status", getJbStatus());
		this.hashColumns.put("bat_id", getBatId());
		this.hashColumns.put("jb_end_dt", getJbEndDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("job_id", "jobId");
		this.hashFields.put("bat_itm_nm", "batItmNm");
		this.hashFields.put("jb_to_yrmon", "jbToYrmon");
		this.hashFields.put("jb_fm_yrmon", "jbFmYrmon");
		this.hashFields.put("jb_status", "jbStatus");
		this.hashFields.put("bat_id", "batId");
		this.hashFields.put("jb_end_dt", "jbEndDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return jobId
	 */
	public String getJobId() {
		return this.jobId;
	}
	
	/**
	 * Column Info
	 * @return batItmNm
	 */
	public String getBatItmNm() {
		return this.batItmNm;
	}
	
	/**
	 * Column Info
	 * @return jbToYrmon
	 */
	public String getJbToYrmon() {
		return this.jbToYrmon;
	}
	
	/**
	 * Column Info
	 * @return jbFmYrmon
	 */
	public String getJbFmYrmon() {
		return this.jbFmYrmon;
	}
	
	/**
	 * Column Info
	 * @return jbStatus
	 */
	public String getJbStatus() {
		return this.jbStatus;
	}
	
	/**
	 * Column Info
	 * @return batId
	 */
	public String getBatId() {
		return this.batId;
	}
	
	/**
	 * Column Info
	 * @return jbEndDt
	 */
	public String getJbEndDt() {
		return this.jbEndDt;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param jobId
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	
	/**
	 * Column Info
	 * @param batItmNm
	 */
	public void setBatItmNm(String batItmNm) {
		this.batItmNm = batItmNm;
	}
	
	/**
	 * Column Info
	 * @param jbToYrmon
	 */
	public void setJbToYrmon(String jbToYrmon) {
		this.jbToYrmon = jbToYrmon;
	}
	
	/**
	 * Column Info
	 * @param jbFmYrmon
	 */
	public void setJbFmYrmon(String jbFmYrmon) {
		this.jbFmYrmon = jbFmYrmon;
	}
	
	/**
	 * Column Info
	 * @param jbStatus
	 */
	public void setJbStatus(String jbStatus) {
		this.jbStatus = jbStatus;
	}
	
	/**
	 * Column Info
	 * @param batId
	 */
	public void setBatId(String batId) {
		this.batId = batId;
	}
	
	/**
	 * Column Info
	 * @param jbEndDt
	 */
	public void setJbEndDt(String jbEndDt) {
		this.jbEndDt = jbEndDt;
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
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setJobId(JSPUtil.getParameter(request, prefix + "job_id", ""));
		setBatItmNm(JSPUtil.getParameter(request, prefix + "bat_itm_nm", ""));
		setJbToYrmon(JSPUtil.getParameter(request, prefix + "jb_to_yrmon", ""));
		setJbFmYrmon(JSPUtil.getParameter(request, prefix + "jb_fm_yrmon", ""));
		setJbStatus(JSPUtil.getParameter(request, prefix + "jb_status", ""));
		setBatId(JSPUtil.getParameter(request, prefix + "bat_id", ""));
		setJbEndDt(JSPUtil.getParameter(request, prefix + "jb_end_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSummaryCreationBatchVO[]
	 */
	public SearchSummaryCreationBatchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSummaryCreationBatchVO[]
	 */
	public SearchSummaryCreationBatchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSummaryCreationBatchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] jobId = (JSPUtil.getParameter(request, prefix	+ "job_id", length));
			String[] batItmNm = (JSPUtil.getParameter(request, prefix	+ "bat_itm_nm", length));
			String[] jbToYrmon = (JSPUtil.getParameter(request, prefix	+ "jb_to_yrmon", length));
			String[] jbFmYrmon = (JSPUtil.getParameter(request, prefix	+ "jb_fm_yrmon", length));
			String[] jbStatus = (JSPUtil.getParameter(request, prefix	+ "jb_status", length));
			String[] batId = (JSPUtil.getParameter(request, prefix	+ "bat_id", length));
			String[] jbEndDt = (JSPUtil.getParameter(request, prefix	+ "jb_end_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSummaryCreationBatchVO();
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (jobId[i] != null)
					model.setJobId(jobId[i]);
				if (batItmNm[i] != null)
					model.setBatItmNm(batItmNm[i]);
				if (jbToYrmon[i] != null)
					model.setJbToYrmon(jbToYrmon[i]);
				if (jbFmYrmon[i] != null)
					model.setJbFmYrmon(jbFmYrmon[i]);
				if (jbStatus[i] != null)
					model.setJbStatus(jbStatus[i]);
				if (batId[i] != null)
					model.setBatId(batId[i]);
				if (jbEndDt[i] != null)
					model.setJbEndDt(jbEndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSummaryCreationBatchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSummaryCreationBatchVO[]
	 */
	public SearchSummaryCreationBatchVO[] getSearchSummaryCreationBatchVOs(){
		SearchSummaryCreationBatchVO[] vos = (SearchSummaryCreationBatchVO[])models.toArray(new SearchSummaryCreationBatchVO[models.size()]);
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
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jobId = this.jobId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batItmNm = this.batItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbToYrmon = this.jbToYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbFmYrmon = this.jbFmYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbStatus = this.jbStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batId = this.batId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbEndDt = this.jbEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
