/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchReportByRaterUserGroupListVO.java
*@FileTitle : SearchReportByRaterUserGroupListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2011.06.09  
* 1.0 Creation
* 2012.01.06 정선용 [CHM-201115386] DPCS System 보완 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
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

public class SearchReportByRaterUserGroupListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchReportByRaterUserGroupListVO> models = new ArrayList<SearchReportByRaterUserGroupListVO>();
	
	/* Column Info */
	private String usrScFlgBkg = null;
	/* Column Info */
	private String usrPreFlgBkg = null;
	/* Column Info */
	private String usrRfaFlgBkg = null;
	/* Column Info */
	private String tttPoint = null;
	/* Column Info */
	private String totUsrOriTime = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String userNm = null;
	/* Column Info */
	private String totOriSiCnt = null;
	/* Column Info */
	private String usrSelfFlgBkg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String addPoint = null;
	/* Column Info */
	private String totOriPnt = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String ttTime = null;
	/* Column Info */
	private String usrTaaFlgBkg = null;
	/* Column Info */
	private String totAmendCnt = null;
	/* Column Info */
	private String averTime = null;
	/* Column Info */
	private String blCnt = null;
	/* Column Info */
	private String hisCount = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchReportByRaterUserGroupListVO() {}

	public SearchReportByRaterUserGroupListVO(String ibflag, String pagerows, String userId, String userNm, String blCnt, String totOriSiCnt, String totUsrOriTime, String totOriPnt, String usrScFlgBkg, String usrRfaFlgBkg, String usrTaaFlgBkg, String usrSelfFlgBkg, String usrPreFlgBkg, String totAmendCnt, String addPoint, String tttPoint, String averTime, String ttTime, String hisCount) {
		this.usrScFlgBkg = usrScFlgBkg;
		this.usrPreFlgBkg = usrPreFlgBkg;
		this.usrRfaFlgBkg = usrRfaFlgBkg;
		this.tttPoint = tttPoint;
		this.totUsrOriTime = totUsrOriTime;
		this.pagerows = pagerows;
		this.userNm = userNm;
		this.totOriSiCnt = totOriSiCnt;
		this.usrSelfFlgBkg = usrSelfFlgBkg;
		this.ibflag = ibflag;
		this.addPoint = addPoint;
		this.totOriPnt = totOriPnt;
		this.userId = userId;
		this.ttTime = ttTime;
		this.usrTaaFlgBkg = usrTaaFlgBkg;
		this.totAmendCnt = totAmendCnt;
		this.averTime = averTime;
		this.blCnt = blCnt;
		this.hisCount = hisCount;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("usr_sc_flg_bkg", getUsrScFlgBkg());
		this.hashColumns.put("usr_pre_flg_bkg", getUsrPreFlgBkg());
		this.hashColumns.put("usr_rfa_flg_bkg", getUsrRfaFlgBkg());
		this.hashColumns.put("ttt_point", getTttPoint());
		this.hashColumns.put("tot_usr_ori_time", getTotUsrOriTime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("user_nm", getUserNm());
		this.hashColumns.put("tot_ori_si_cnt", getTotOriSiCnt());
		this.hashColumns.put("usr_self_flg_bkg", getUsrSelfFlgBkg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("add_point", getAddPoint());
		this.hashColumns.put("tot_ori_pnt", getTotOriPnt());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("tt_time", getTtTime());
		this.hashColumns.put("usr_taa_flg_bkg", getUsrTaaFlgBkg());
		this.hashColumns.put("tot_amend_cnt", getTotAmendCnt());
		this.hashColumns.put("aver_time", getAverTime());
		this.hashColumns.put("bl_cnt", getBlCnt());
		this.hashColumns.put("his_count", getHisCount());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("usr_sc_flg_bkg", "usrScFlgBkg");
		this.hashFields.put("usr_pre_flg_bkg", "usrPreFlgBkg");
		this.hashFields.put("usr_rfa_flg_bkg", "usrRfaFlgBkg");
		this.hashFields.put("ttt_point", "tttPoint");
		this.hashFields.put("tot_usr_ori_time", "totUsrOriTime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("user_nm", "userNm");
		this.hashFields.put("tot_ori_si_cnt", "totOriSiCnt");
		this.hashFields.put("usr_self_flg_bkg", "usrSelfFlgBkg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("add_point", "addPoint");
		this.hashFields.put("tot_ori_pnt", "totOriPnt");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("tt_time", "ttTime");
		this.hashFields.put("usr_taa_flg_bkg", "usrTaaFlgBkg");
		this.hashFields.put("tot_amend_cnt", "totAmendCnt");
		this.hashFields.put("aver_time", "averTime");
		this.hashFields.put("bl_cnt", "blCnt");
		this.hashFields.put("his_count", "hisCount");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return usrScFlgBkg
	 */
	public String getUsrScFlgBkg() {
		return this.usrScFlgBkg;
	}
	
	/**
	 * Column Info
	 * @return usrPreFlgBkg
	 */
	public String getUsrPreFlgBkg() {
		return this.usrPreFlgBkg;
	}
	
	/**
	 * Column Info
	 * @return usrRfaFlgBkg
	 */
	public String getUsrRfaFlgBkg() {
		return this.usrRfaFlgBkg;
	}
	
	/**
	 * Column Info
	 * @return tttPoint
	 */
	public String getTttPoint() {
		return this.tttPoint;
	}
	
	/**
	 * Column Info
	 * @return totUsrOriTime
	 */
	public String getTotUsrOriTime() {
		return this.totUsrOriTime;
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
	 * @return userNm
	 */
	public String getUserNm() {
		return this.userNm;
	}
	
	/**
	 * Column Info
	 * @return totOriSiCnt
	 */
	public String getTotOriSiCnt() {
		return this.totOriSiCnt;
	}
	
	/**
	 * Column Info
	 * @return usrSelfFlgBkg
	 */
	public String getUsrSelfFlgBkg() {
		return this.usrSelfFlgBkg;
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
	 * @return addPoint
	 */
	public String getAddPoint() {
		return this.addPoint;
	}
	
	/**
	 * Column Info
	 * @return totOriPnt
	 */
	public String getTotOriPnt() {
		return this.totOriPnt;
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
	 * @return ttTime
	 */
	public String getTtTime() {
		return this.ttTime;
	}
	
	/**
	 * Column Info
	 * @return usrTaaFlgBkg
	 */
	public String getUsrTaaFlgBkg() {
		return this.usrTaaFlgBkg;
	}
	
	/**
	 * Column Info
	 * @return totAmendCnt
	 */
	public String getTotAmendCnt() {
		return this.totAmendCnt;
	}
	
	/**
	 * Column Info
	 * @return averTime
	 */
	public String getAverTime() {
		return this.averTime;
	}
	
	/**
	 * Column Info
	 * @return blCnt
	 */
	public String getBlCnt() {
		return this.blCnt;
	}
	

	public String getHisCount() {
		return hisCount;
	}

	public void setHisCount(String hisCount) {
		this.hisCount = hisCount;
	}

	/**
	 * Column Info
	 * @param usrScFlgBkg
	 */
	public void setUsrScFlgBkg(String usrScFlgBkg) {
		this.usrScFlgBkg = usrScFlgBkg;
	}
	
	/**
	 * Column Info
	 * @param usrPreFlgBkg
	 */
	public void setUsrPreFlgBkg(String usrPreFlgBkg) {
		this.usrPreFlgBkg = usrPreFlgBkg;
	}
	
	/**
	 * Column Info
	 * @param usrRfaFlgBkg
	 */
	public void setUsrRfaFlgBkg(String usrRfaFlgBkg) {
		this.usrRfaFlgBkg = usrRfaFlgBkg;
	}
	
	/**
	 * Column Info
	 * @param tttPoint
	 */
	public void setTttPoint(String tttPoint) {
		this.tttPoint = tttPoint;
	}
	
	/**
	 * Column Info
	 * @param totUsrOriTime
	 */
	public void setTotUsrOriTime(String totUsrOriTime) {
		this.totUsrOriTime = totUsrOriTime;
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
	 * @param userNm
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	/**
	 * Column Info
	 * @param totOriSiCnt
	 */
	public void setTotOriSiCnt(String totOriSiCnt) {
		this.totOriSiCnt = totOriSiCnt;
	}
	
	/**
	 * Column Info
	 * @param usrSelfFlgBkg
	 */
	public void setUsrSelfFlgBkg(String usrSelfFlgBkg) {
		this.usrSelfFlgBkg = usrSelfFlgBkg;
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
	 * @param addPoint
	 */
	public void setAddPoint(String addPoint) {
		this.addPoint = addPoint;
	}
	
	/**
	 * Column Info
	 * @param totOriPnt
	 */
	public void setTotOriPnt(String totOriPnt) {
		this.totOriPnt = totOriPnt;
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
	 * @param ttTime
	 */
	public void setTtTime(String ttTime) {
		this.ttTime = ttTime;
	}
	
	/**
	 * Column Info
	 * @param usrTaaFlgBkg
	 */
	public void setUsrTaaFlgBkg(String usrTaaFlgBkg) {
		this.usrTaaFlgBkg = usrTaaFlgBkg;
	}
	
	/**
	 * Column Info
	 * @param totAmendCnt
	 */
	public void setTotAmendCnt(String totAmendCnt) {
		this.totAmendCnt = totAmendCnt;
	}
	
	/**
	 * Column Info
	 * @param averTime
	 */
	public void setAverTime(String averTime) {
		this.averTime = averTime;
	}
	
	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
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
		setUsrScFlgBkg(JSPUtil.getParameter(request, prefix + "usr_sc_flg_bkg", ""));
		setUsrPreFlgBkg(JSPUtil.getParameter(request, prefix + "usr_pre_flg_bkg", ""));
		setUsrRfaFlgBkg(JSPUtil.getParameter(request, prefix + "usr_rfa_flg_bkg", ""));
		setTttPoint(JSPUtil.getParameter(request, prefix + "ttt_point", ""));
		setTotUsrOriTime(JSPUtil.getParameter(request, prefix + "tot_usr_ori_time", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUserNm(JSPUtil.getParameter(request, prefix + "user_nm", ""));
		setTotOriSiCnt(JSPUtil.getParameter(request, prefix + "tot_ori_si_cnt", ""));
		setUsrSelfFlgBkg(JSPUtil.getParameter(request, prefix + "usr_self_flg_bkg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAddPoint(JSPUtil.getParameter(request, prefix + "add_point", ""));
		setTotOriPnt(JSPUtil.getParameter(request, prefix + "tot_ori_pnt", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setTtTime(JSPUtil.getParameter(request, prefix + "tt_time", ""));
		setUsrTaaFlgBkg(JSPUtil.getParameter(request, prefix + "usr_taa_flg_bkg", ""));
		setTotAmendCnt(JSPUtil.getParameter(request, prefix + "tot_amend_cnt", ""));
		setAverTime(JSPUtil.getParameter(request, prefix + "aver_time", ""));
		setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
		setHisCount(JSPUtil.getParameter(request, prefix + "his_count", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchReportByRaterUserGroupListVO[]
	 */
	public SearchReportByRaterUserGroupListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchReportByRaterUserGroupListVO[]
	 */
	public SearchReportByRaterUserGroupListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchReportByRaterUserGroupListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] usrScFlgBkg = (JSPUtil.getParameter(request, prefix	+ "usr_sc_flg_bkg", length));
			String[] usrPreFlgBkg = (JSPUtil.getParameter(request, prefix	+ "usr_pre_flg_bkg", length));
			String[] usrRfaFlgBkg = (JSPUtil.getParameter(request, prefix	+ "usr_rfa_flg_bkg", length));
			String[] tttPoint = (JSPUtil.getParameter(request, prefix	+ "ttt_point", length));
			String[] totUsrOriTime = (JSPUtil.getParameter(request, prefix	+ "tot_usr_ori_time", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] userNm = (JSPUtil.getParameter(request, prefix	+ "user_nm", length));
			String[] totOriSiCnt = (JSPUtil.getParameter(request, prefix	+ "tot_ori_si_cnt", length));
			String[] usrSelfFlgBkg = (JSPUtil.getParameter(request, prefix	+ "usr_self_flg_bkg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] addPoint = (JSPUtil.getParameter(request, prefix	+ "add_point", length));
			String[] totOriPnt = (JSPUtil.getParameter(request, prefix	+ "tot_ori_pnt", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] ttTime = (JSPUtil.getParameter(request, prefix	+ "tt_time", length));
			String[] usrTaaFlgBkg = (JSPUtil.getParameter(request, prefix	+ "usr_taa_flg_bkg", length));
			String[] totAmendCnt = (JSPUtil.getParameter(request, prefix	+ "tot_amend_cnt", length));
			String[] averTime = (JSPUtil.getParameter(request, prefix	+ "aver_time", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			String[] hisCount = (JSPUtil.getParameter(request, prefix	+ "his_count", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchReportByRaterUserGroupListVO();
				if (usrScFlgBkg[i] != null)
					model.setUsrScFlgBkg(usrScFlgBkg[i]);
				if (usrPreFlgBkg[i] != null)
					model.setUsrPreFlgBkg(usrPreFlgBkg[i]);
				if (usrRfaFlgBkg[i] != null)
					model.setUsrRfaFlgBkg(usrRfaFlgBkg[i]);
				if (tttPoint[i] != null)
					model.setTttPoint(tttPoint[i]);
				if (totUsrOriTime[i] != null)
					model.setTotUsrOriTime(totUsrOriTime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (userNm[i] != null)
					model.setUserNm(userNm[i]);
				if (totOriSiCnt[i] != null)
					model.setTotOriSiCnt(totOriSiCnt[i]);
				if (usrSelfFlgBkg[i] != null)
					model.setUsrSelfFlgBkg(usrSelfFlgBkg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (addPoint[i] != null)
					model.setAddPoint(addPoint[i]);
				if (totOriPnt[i] != null)
					model.setTotOriPnt(totOriPnt[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (ttTime[i] != null)
					model.setTtTime(ttTime[i]);
				if (usrTaaFlgBkg[i] != null)
					model.setUsrTaaFlgBkg(usrTaaFlgBkg[i]);
				if (totAmendCnt[i] != null)
					model.setTotAmendCnt(totAmendCnt[i]);
				if (averTime[i] != null)
					model.setAverTime(averTime[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				if (hisCount[i] != null)
					model.setHisCount(hisCount[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchReportByRaterUserGroupListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchReportByRaterUserGroupListVO[]
	 */
	public SearchReportByRaterUserGroupListVO[] getSearchReportByRaterUserGroupListVOs(){
		SearchReportByRaterUserGroupListVO[] vos = (SearchReportByRaterUserGroupListVO[])models.toArray(new SearchReportByRaterUserGroupListVO[models.size()]);
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
		this.usrScFlgBkg = this.usrScFlgBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrPreFlgBkg = this.usrPreFlgBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRfaFlgBkg = this.usrRfaFlgBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tttPoint = this.tttPoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totUsrOriTime = this.totUsrOriTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userNm = this.userNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriSiCnt = this.totOriSiCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrSelfFlgBkg = this.usrSelfFlgBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addPoint = this.addPoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriPnt = this.totOriPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttTime = this.ttTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrTaaFlgBkg = this.usrTaaFlgBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmendCnt = this.totAmendCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.averTime = this.averTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisCount = this.hisCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
