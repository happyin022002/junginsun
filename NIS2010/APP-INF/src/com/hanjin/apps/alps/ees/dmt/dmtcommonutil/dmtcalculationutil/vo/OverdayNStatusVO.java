/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OverdayNStatusVO.java
*@FileTitle : OverdayNStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.07.15 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OverdayNStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OverdayNStatusVO> models = new ArrayList<OverdayNStatusVO>();
	
	/* Column Info */
	private String msgCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String prmToDate = null;
	/* Column Info */
	private String checkNum = null;
	/* Column Info */
	private String msgDesc = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String overDay = null;
	/* Column Info */
	private String cstopIdx = null;
	/* Column Info */
	private String checkGrace = null;
	/* Column Info */
	private String prmFtimeEnd = null;
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private List<String> cstopNoList = null;

	/**
	 * Column Info
	 * @return this.cstopNoVOS
	 */
	public void setCStopNoList(List<String> cstopNoList) {
		this.cstopNoList = cstopNoList;
	}
	
	/**
	 * Column Info
	 * @return List<String>
	 */
	public List<String> getCStopNoList() {
		return cstopNoList;
	}
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OverdayNStatusVO() {}

	public OverdayNStatusVO(String ibflag, String pagerows, String overDay, String status, String cstopIdx, String msgCd, String msgDesc, String prmToDate, String prmFtimeEnd, String checkNum, String checkGrace) {
		this.msgCd = msgCd;
		this.ibflag = ibflag;
		this.prmToDate = prmToDate;
		this.checkNum = checkNum;
		this.msgDesc = msgDesc;
		this.status = status;
		this.overDay = overDay;
		this.cstopIdx = cstopIdx;
		this.checkGrace = checkGrace;
		this.prmFtimeEnd = prmFtimeEnd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("msg_cd", getMsgCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prm_to_date", getPrmToDate());
		this.hashColumns.put("check_num", getCheckNum());
		this.hashColumns.put("msg_desc", getMsgDesc());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("over_day", getOverDay());
		this.hashColumns.put("cstop_idx", getCstopIdx());
		this.hashColumns.put("check_grace", getCheckGrace());
		this.hashColumns.put("prm_ftime_end", getPrmFtimeEnd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("msg_cd", "msgCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prm_to_date", "prmToDate");
		this.hashFields.put("check_num", "checkNum");
		this.hashFields.put("msg_desc", "msgDesc");
		this.hashFields.put("status", "status");
		this.hashFields.put("over_day", "overDay");
		this.hashFields.put("cstop_idx", "cstopIdx");
		this.hashFields.put("check_grace", "checkGrace");
		this.hashFields.put("prm_ftime_end", "prmFtimeEnd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return msgCd
	 */
	public String getMsgCd() {
		return this.msgCd;
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
	 * @return prmToDate
	 */
	public String getPrmToDate() {
		return this.prmToDate;
	}
	
	/**
	 * Column Info
	 * @return checkNum
	 */
	public String getCheckNum() {
		return this.checkNum;
	}
	
	/**
	 * Column Info
	 * @return msgDesc
	 */
	public String getMsgDesc() {
		return this.msgDesc;
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
	 * @return overDay
	 */
	public String getOverDay() {
		return this.overDay;
	}
	
	/**
	 * Column Info
	 * @return cstopIdx
	 */
	public String getCstopIdx() {
		return this.cstopIdx;
	}
	
	/**
	 * Column Info
	 * @return checkGrace
	 */
	public String getCheckGrace() {
		return this.checkGrace;
	}
	
	/**
	 * Column Info
	 * @return prmFtimeEnd
	 */
	public String getPrmFtimeEnd() {
		return this.prmFtimeEnd;
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
	 * @param msgCd
	 */
	public void setMsgCd(String msgCd) {
		this.msgCd = msgCd;
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
	 * @param prmToDate
	 */
	public void setPrmToDate(String prmToDate) {
		this.prmToDate = prmToDate;
	}
	
	/**
	 * Column Info
	 * @param checkNum
	 */
	public void setCheckNum(String checkNum) {
		this.checkNum = checkNum;
	}
	
	/**
	 * Column Info
	 * @param msgDesc
	 */
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
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
	 * @param overDay
	 */
	public void setOverDay(String overDay) {
		this.overDay = overDay;
	}
	
	/**
	 * Column Info
	 * @param cstopIdx
	 */
	public void setCstopIdx(String cstopIdx) {
		this.cstopIdx = cstopIdx;
	}
	
	/**
	 * Column Info
	 * @param checkGrace
	 */
	public void setCheckGrace(String checkGrace) {
		this.checkGrace = checkGrace;
	}
	
	/**
	 * Column Info
	 * @param prmFtimeEnd
	 */
	public void setPrmFtimeEnd(String prmFtimeEnd) {
		this.prmFtimeEnd = prmFtimeEnd;
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
		setMsgCd(JSPUtil.getParameter(request, prefix + "msg_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPrmToDate(JSPUtil.getParameter(request, prefix + "prm_to_date", ""));
		setCheckNum(JSPUtil.getParameter(request, prefix + "check_num", ""));
		setMsgDesc(JSPUtil.getParameter(request, prefix + "msg_desc", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setOverDay(JSPUtil.getParameter(request, prefix + "over_day", ""));
		setCstopIdx(JSPUtil.getParameter(request, prefix + "cstop_idx", ""));
		setCheckGrace(JSPUtil.getParameter(request, prefix + "check_grace", ""));
		setPrmFtimeEnd(JSPUtil.getParameter(request, prefix + "prm_ftime_end", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OverdayNStatusVO[]
	 */
	public OverdayNStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OverdayNStatusVO[]
	 */
	public OverdayNStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OverdayNStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] msgCd = (JSPUtil.getParameter(request, prefix	+ "msg_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] prmToDate = (JSPUtil.getParameter(request, prefix	+ "prm_to_date", length));
			String[] checkNum = (JSPUtil.getParameter(request, prefix	+ "check_num", length));
			String[] msgDesc = (JSPUtil.getParameter(request, prefix	+ "msg_desc", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] overDay = (JSPUtil.getParameter(request, prefix	+ "over_day", length));
			String[] cstopIdx = (JSPUtil.getParameter(request, prefix	+ "cstop_idx", length));
			String[] checkGrace = (JSPUtil.getParameter(request, prefix	+ "check_grace", length));
			String[] prmFtimeEnd = (JSPUtil.getParameter(request, prefix	+ "prm_ftime_end", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new OverdayNStatusVO();
				if (msgCd[i] != null)
					model.setMsgCd(msgCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prmToDate[i] != null)
					model.setPrmToDate(prmToDate[i]);
				if (checkNum[i] != null)
					model.setCheckNum(checkNum[i]);
				if (msgDesc[i] != null)
					model.setMsgDesc(msgDesc[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (overDay[i] != null)
					model.setOverDay(overDay[i]);
				if (cstopIdx[i] != null)
					model.setCstopIdx(cstopIdx[i]);
				if (checkGrace[i] != null)
					model.setCheckGrace(checkGrace[i]);
				if (prmFtimeEnd[i] != null)
					model.setPrmFtimeEnd(prmFtimeEnd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOverdayNStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OverdayNStatusVO[]
	 */
	public OverdayNStatusVO[] getOverdayNStatusVOs(){
		OverdayNStatusVO[] vos = (OverdayNStatusVO[])models.toArray(new OverdayNStatusVO[models.size()]);
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
		this.msgCd = this.msgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prmToDate = this.prmToDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkNum = this.checkNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgDesc = this.msgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDay = this.overDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstopIdx = this.cstopIdx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkGrace = this.checkGrace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prmFtimeEnd = this.prmFtimeEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
