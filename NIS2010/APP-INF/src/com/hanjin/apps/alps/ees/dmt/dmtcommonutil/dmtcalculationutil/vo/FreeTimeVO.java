/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FreeTimeVO.java
*@FileTitle : FreeTimeVO
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

public class FreeTimeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FreeTimeVO> models = new ArrayList<FreeTimeVO>();
	
	/* Column Info */
	private String weekOfDay = null;
	/* Column Info */
	private String msgCd = null;
	/* Column Info */
	private String ftimeCmnc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String msgDesc = null;
	/* Column Info */
	private String rtnFtimeCmnc = null;
	/* Column Info */
	private String cstopNo = null;
	/* Column Info */
	private String cstopIdx = null;
	/* Column Info */
	private String ftimeEnd = null;
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
	
	public FreeTimeVO() {}

	public FreeTimeVO(String ibflag, String pagerows, String ftimeCmnc, String ftimeEnd, String cstopIdx, String cstopNo, String msgCd, String msgDesc, String weekOfDay, String rtnFtimeCmnc) {
		this.weekOfDay = weekOfDay;
		this.msgCd = msgCd;
		this.ftimeCmnc = ftimeCmnc;
		this.ibflag = ibflag;
		this.msgDesc = msgDesc;
		this.rtnFtimeCmnc = rtnFtimeCmnc;
		this.cstopNo = cstopNo;
		this.cstopIdx = cstopIdx;
		this.ftimeEnd = ftimeEnd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("week_of_day", getWeekOfDay());
		this.hashColumns.put("msg_cd", getMsgCd());
		this.hashColumns.put("ftime_cmnc", getFtimeCmnc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("msg_desc", getMsgDesc());
		this.hashColumns.put("rtn_ftime_cmnc", getRtnFtimeCmnc());
		this.hashColumns.put("cstop_no", getCstopNo());
		this.hashColumns.put("cstop_idx", getCstopIdx());
		this.hashColumns.put("ftime_end", getFtimeEnd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("week_of_day", "weekOfDay");
		this.hashFields.put("msg_cd", "msgCd");
		this.hashFields.put("ftime_cmnc", "ftimeCmnc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("msg_desc", "msgDesc");
		this.hashFields.put("rtn_ftime_cmnc", "rtnFtimeCmnc");
		this.hashFields.put("cstop_no", "cstopNo");
		this.hashFields.put("cstop_idx", "cstopIdx");
		this.hashFields.put("ftime_end", "ftimeEnd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return weekOfDay
	 */
	public String getWeekOfDay() {
		return this.weekOfDay;
	}
	
	/**
	 * Column Info
	 * @return msgCd
	 */
	public String getMsgCd() {
		return this.msgCd;
	}
	
	/**
	 * Column Info
	 * @return ftimeCmnc
	 */
	public String getFtimeCmnc() {
		return this.ftimeCmnc;
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
	 * @return msgDesc
	 */
	public String getMsgDesc() {
		return this.msgDesc;
	}
	
	/**
	 * Column Info
	 * @return rtnFtimeCmnc
	 */
	public String getRtnFtimeCmnc() {
		return this.rtnFtimeCmnc;
	}
	
	/**
	 * Column Info
	 * @return cstopNo
	 */
	public String getCstopNo() {
		return this.cstopNo;
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
	 * @return ftimeEnd
	 */
	public String getFtimeEnd() {
		return this.ftimeEnd;
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
	 * @param weekOfDay
	 */
	public void setWeekOfDay(String weekOfDay) {
		this.weekOfDay = weekOfDay;
	}
	
	/**
	 * Column Info
	 * @param msgCd
	 */
	public void setMsgCd(String msgCd) {
		this.msgCd = msgCd;
	}
	
	/**
	 * Column Info
	 * @param ftimeCmnc
	 */
	public void setFtimeCmnc(String ftimeCmnc) {
		this.ftimeCmnc = ftimeCmnc;
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
	 * @param msgDesc
	 */
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}
	
	/**
	 * Column Info
	 * @param rtnFtimeCmnc
	 */
	public void setRtnFtimeCmnc(String rtnFtimeCmnc) {
		this.rtnFtimeCmnc = rtnFtimeCmnc;
	}
	
	/**
	 * Column Info
	 * @param cstopNo
	 */
	public void setCstopNo(String cstopNo) {
		this.cstopNo = cstopNo;
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
	 * @param ftimeEnd
	 */
	public void setFtimeEnd(String ftimeEnd) {
		this.ftimeEnd = ftimeEnd;
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
		setWeekOfDay(JSPUtil.getParameter(request, prefix + "week_of_day", ""));
		setMsgCd(JSPUtil.getParameter(request, prefix + "msg_cd", ""));
		setFtimeCmnc(JSPUtil.getParameter(request, prefix + "ftime_cmnc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMsgDesc(JSPUtil.getParameter(request, prefix + "msg_desc", ""));
		setRtnFtimeCmnc(JSPUtil.getParameter(request, prefix + "rtn_ftime_cmnc", ""));
		setCstopNo(JSPUtil.getParameter(request, prefix + "cstop_no", ""));
		setCstopIdx(JSPUtil.getParameter(request, prefix + "cstop_idx", ""));
		setFtimeEnd(JSPUtil.getParameter(request, prefix + "ftime_end", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FreeTimeVO[]
	 */
	public FreeTimeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FreeTimeVO[]
	 */
	public FreeTimeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FreeTimeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] weekOfDay = (JSPUtil.getParameter(request, prefix	+ "week_of_day", length));
			String[] msgCd = (JSPUtil.getParameter(request, prefix	+ "msg_cd", length));
			String[] ftimeCmnc = (JSPUtil.getParameter(request, prefix	+ "ftime_cmnc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] msgDesc = (JSPUtil.getParameter(request, prefix	+ "msg_desc", length));
			String[] rtnFtimeCmnc = (JSPUtil.getParameter(request, prefix	+ "rtn_ftime_cmnc", length));
			String[] cstopNo = (JSPUtil.getParameter(request, prefix	+ "cstop_no", length));
			String[] cstopIdx = (JSPUtil.getParameter(request, prefix	+ "cstop_idx", length));
			String[] ftimeEnd = (JSPUtil.getParameter(request, prefix	+ "ftime_end", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new FreeTimeVO();
				if (weekOfDay[i] != null)
					model.setWeekOfDay(weekOfDay[i]);
				if (msgCd[i] != null)
					model.setMsgCd(msgCd[i]);
				if (ftimeCmnc[i] != null)
					model.setFtimeCmnc(ftimeCmnc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (msgDesc[i] != null)
					model.setMsgDesc(msgDesc[i]);
				if (rtnFtimeCmnc[i] != null)
					model.setRtnFtimeCmnc(rtnFtimeCmnc[i]);
				if (cstopNo[i] != null)
					model.setCstopNo(cstopNo[i]);
				if (cstopIdx[i] != null)
					model.setCstopIdx(cstopIdx[i]);
				if (ftimeEnd[i] != null)
					model.setFtimeEnd(ftimeEnd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFreeTimeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FreeTimeVO[]
	 */
	public FreeTimeVO[] getFreeTimeVOs(){
		FreeTimeVO[] vos = (FreeTimeVO[])models.toArray(new FreeTimeVO[models.size()]);
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
		this.weekOfDay = this.weekOfDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgCd = this.msgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftimeCmnc = this.ftimeCmnc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgDesc = this.msgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnFtimeCmnc = this.rtnFtimeCmnc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstopNo = this.cstopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstopIdx = this.cstopIdx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftimeEnd = this.ftimeEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
