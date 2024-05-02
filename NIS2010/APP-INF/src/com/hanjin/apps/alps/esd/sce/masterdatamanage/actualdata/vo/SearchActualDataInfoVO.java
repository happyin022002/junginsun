/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchActualDataInfoVO.java
*@FileTitle : SearchActualDataInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.05.20 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchActualDataInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchActualDataInfoVO> models = new ArrayList<SearchActualDataInfoVO>();
	
	/* Column Info */
	private String onTime = null;
	/* Column Info */
	private String actCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actDt2 = null;
	/* Column Info */
	private String scCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String actRcvTpCd = null;
	/* Column Info */
	private String actualReceiving = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String actDt1 = null;
	/* Column Info */
	private String actStsMapgCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchActualDataInfoVO() {}

	public SearchActualDataInfoVO(String ibflag, String pagerows, String actualReceiving, String actCd, String actDt1, String actDt2, String actRcvTpCd, String actStsMapgCd, String cntrNo, String nodCd, String onTime, String scCd) {
		this.onTime = onTime;
		this.actCd = actCd;
		this.ibflag = ibflag;
		this.actDt2 = actDt2;
		this.scCd = scCd;
		this.cntrNo = cntrNo;
		this.actRcvTpCd = actRcvTpCd;
		this.actualReceiving = actualReceiving;
		this.nodCd = nodCd;
		this.actDt1 = actDt1;
		this.actStsMapgCd = actStsMapgCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("on_time", getOnTime());
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_dt2", getActDt2());
		this.hashColumns.put("sc_cd", getScCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("act_rcv_tp_cd", getActRcvTpCd());
		this.hashColumns.put("actual_receiving", getActualReceiving());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("act_dt1", getActDt1());
		this.hashColumns.put("act_sts_mapg_cd", getActStsMapgCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("on_time", "onTime");
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_dt2", "actDt2");
		this.hashFields.put("sc_cd", "scCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("act_rcv_tp_cd", "actRcvTpCd");
		this.hashFields.put("actual_receiving", "actualReceiving");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("act_dt1", "actDt1");
		this.hashFields.put("act_sts_mapg_cd", "actStsMapgCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return onTime
	 */
	public String getOnTime() {
		return this.onTime;
	}
	
	/**
	 * Column Info
	 * @return actCd
	 */
	public String getActCd() {
		return this.actCd;
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
	 * @return actDt2
	 */
	public String getActDt2() {
		return this.actDt2;
	}
	
	/**
	 * Column Info
	 * @return scCd
	 */
	public String getScCd() {
		return this.scCd;
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
	 * @return actRcvTpCd
	 */
	public String getActRcvTpCd() {
		return this.actRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @return actualReceiving
	 */
	public String getActualReceiving() {
		return this.actualReceiving;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return actDt1
	 */
	public String getActDt1() {
		return this.actDt1;
	}
	
	/**
	 * Column Info
	 * @return actStsMapgCd
	 */
	public String getActStsMapgCd() {
		return this.actStsMapgCd;
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
	 * @param onTime
	 */
	public void setOnTime(String onTime) {
		this.onTime = onTime;
	}
	
	/**
	 * Column Info
	 * @param actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
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
	 * @param actDt2
	 */
	public void setActDt2(String actDt2) {
		this.actDt2 = actDt2;
	}
	
	/**
	 * Column Info
	 * @param scCd
	 */
	public void setScCd(String scCd) {
		this.scCd = scCd;
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
	 * @param actRcvTpCd
	 */
	public void setActRcvTpCd(String actRcvTpCd) {
		this.actRcvTpCd = actRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @param actualReceiving
	 */
	public void setActualReceiving(String actualReceiving) {
		this.actualReceiving = actualReceiving;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param actDt1
	 */
	public void setActDt1(String actDt1) {
		this.actDt1 = actDt1;
	}
	
	/**
	 * Column Info
	 * @param actStsMapgCd
	 */
	public void setActStsMapgCd(String actStsMapgCd) {
		this.actStsMapgCd = actStsMapgCd;
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
		setOnTime(JSPUtil.getParameter(request, prefix + "on_time", ""));
		setActCd(JSPUtil.getParameter(request, prefix + "act_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActDt2(JSPUtil.getParameter(request, prefix + "act_dt2", ""));
		setScCd(JSPUtil.getParameter(request, prefix + "sc_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setActRcvTpCd(JSPUtil.getParameter(request, prefix + "act_rcv_tp_cd", ""));
		setActualReceiving(JSPUtil.getParameter(request, prefix + "actual_receiving", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setActDt1(JSPUtil.getParameter(request, prefix + "act_dt1", ""));
		setActStsMapgCd(JSPUtil.getParameter(request, prefix + "act_sts_mapg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchActualDataInfoVO[]
	 */
	public SearchActualDataInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchActualDataInfoVO[]
	 */
	public SearchActualDataInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchActualDataInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] onTime = (JSPUtil.getParameter(request, prefix	+ "on_time", length));
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actDt2 = (JSPUtil.getParameter(request, prefix	+ "act_dt2", length));
			String[] scCd = (JSPUtil.getParameter(request, prefix	+ "sc_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] actRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "act_rcv_tp_cd", length));
			String[] actualReceiving = (JSPUtil.getParameter(request, prefix	+ "actual_receiving", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] actDt1 = (JSPUtil.getParameter(request, prefix	+ "act_dt1", length));
			String[] actStsMapgCd = (JSPUtil.getParameter(request, prefix	+ "act_sts_mapg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchActualDataInfoVO();
				if (onTime[i] != null)
					model.setOnTime(onTime[i]);
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actDt2[i] != null)
					model.setActDt2(actDt2[i]);
				if (scCd[i] != null)
					model.setScCd(scCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (actRcvTpCd[i] != null)
					model.setActRcvTpCd(actRcvTpCd[i]);
				if (actualReceiving[i] != null)
					model.setActualReceiving(actualReceiving[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (actDt1[i] != null)
					model.setActDt1(actDt1[i]);
				if (actStsMapgCd[i] != null)
					model.setActStsMapgCd(actStsMapgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchActualDataInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchActualDataInfoVO[]
	 */
	public SearchActualDataInfoVO[] getSearchActualDataInfoVOs(){
		SearchActualDataInfoVO[] vos = (SearchActualDataInfoVO[])models.toArray(new SearchActualDataInfoVO[models.size()]);
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
		this.onTime = this.onTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt2 = this.actDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scCd = this.scCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvTpCd = this.actRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actualReceiving = this.actualReceiving .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt1 = this.actDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsMapgCd = this.actStsMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
