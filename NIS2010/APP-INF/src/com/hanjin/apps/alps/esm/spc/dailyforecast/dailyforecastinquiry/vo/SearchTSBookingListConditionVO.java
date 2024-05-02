/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchTSBookingListConditionVO.java
*@FileTitle : SearchTSBookingListConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.04
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.11.04 신자영 
* 1.0 Creation
* 2014.11.14 신자영 [CHM-201432770] T/S Booking Report 개선 
=========================================================*/

package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 신자영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTSBookingListConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTSBookingListConditionVO> models = new ArrayList<SearchTSBookingListConditionVO>();
	
	/* Column Info */
	private String postVvd2 = null;
	/* Column Info */
	private String postVvd1 = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String preVvd = null;
	/* Column Info */
	private String prePstFlg = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String year = null;
	/* Column Info */
	private String postVvd = null;
	/* Column Info */
	private String tsLane3 = null;
	/* Column Info */
	private String tsLane4 = null;
	/* Column Info */
	private String tsLane5 = null;
	/* Column Info */
	private String tsPort = null;
	/* Column Info */
	private String tsLane6 = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String pol6 = null;
	/* Column Info */
	private String pol5 = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String pol4 = null;
	/* Column Info */
	private String pol3 = null;
	/* Column Info */
	private String pol2 = null;
	/* Column Info */
	private String pol1 = null;
	/* Column Info */
	private String pod5 = null;
	/* Column Info */
	private String pod6 = null;
	/* Column Info */
	private String tsLane1 = null;
	/* Column Info */
	private String tsLane2 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String pod2 = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String pod1 = null;
	/* Column Info */
	private String duration = null;
	/* Column Info */
	private String pod4 = null;
	/* Column Info */
	private String pod3 = null;
	/* Column Info */
	private String tsConti = null;
	/* Column Info */
	private String week = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchTSBookingListConditionVO() {}

	public SearchTSBookingListConditionVO(String ibflag, String pagerows, String lane, String prePstFlg, String year, String tsLane3, String tsLane4, String tsLane5, String tsLane6, String rhqCd, String pol6, String pol5, String pol4, String pol3, String pol2, String pol1, String pod5, String pod6, String tsLane1, String tsLane2, String vvd, String pod2, String ofcCd, String pod1, String pod4, String duration, String pod3, String week, String tsConti, String del, String type, String preVvd, String postVvd, String polCd, String podCd, String delCd, String tsPort, String slsOfcCd, String postVvd1, String postVvd2) {
		this.postVvd2 = postVvd2;
		this.postVvd1 = postVvd1;
		this.type = type;
		this.lane = lane;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.preVvd = preVvd;
		this.prePstFlg = prePstFlg;
		this.slsOfcCd = slsOfcCd;
		this.del = del;
		this.year = year;
		this.postVvd = postVvd;
		this.tsLane3 = tsLane3;
		this.tsLane4 = tsLane4;
		this.tsLane5 = tsLane5;
		this.tsPort = tsPort;
		this.tsLane6 = tsLane6;
		this.rhqCd = rhqCd;
		this.pol6 = pol6;
		this.pol5 = pol5;
		this.delCd = delCd;
		this.pol4 = pol4;
		this.pol3 = pol3;
		this.pol2 = pol2;
		this.pol1 = pol1;
		this.pod5 = pod5;
		this.pod6 = pod6;
		this.tsLane1 = tsLane1;
		this.tsLane2 = tsLane2;
		this.podCd = podCd;
		this.vvd = vvd;
		this.pod2 = pod2;
		this.ofcCd = ofcCd;
		this.pod1 = pod1;
		this.duration = duration;
		this.pod4 = pod4;
		this.pod3 = pod3;
		this.tsConti = tsConti;
		this.week = week;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("post_vvd2", getPostVvd2());
		this.hashColumns.put("post_vvd1", getPostVvd1());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pre_vvd", getPreVvd());
		this.hashColumns.put("pre_pst_flg", getPrePstFlg());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("year", getYear());
		this.hashColumns.put("post_vvd", getPostVvd());
		this.hashColumns.put("ts_lane3", getTsLane3());
		this.hashColumns.put("ts_lane4", getTsLane4());
		this.hashColumns.put("ts_lane5", getTsLane5());
		this.hashColumns.put("ts_port", getTsPort());
		this.hashColumns.put("ts_lane6", getTsLane6());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("pol6", getPol6());
		this.hashColumns.put("pol5", getPol5());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pol4", getPol4());
		this.hashColumns.put("pol3", getPol3());
		this.hashColumns.put("pol2", getPol2());
		this.hashColumns.put("pol1", getPol1());
		this.hashColumns.put("pod5", getPod5());
		this.hashColumns.put("pod6", getPod6());
		this.hashColumns.put("ts_lane1", getTsLane1());
		this.hashColumns.put("ts_lane2", getTsLane2());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod2", getPod2());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("pod1", getPod1());
		this.hashColumns.put("duration", getDuration());
		this.hashColumns.put("pod4", getPod4());
		this.hashColumns.put("pod3", getPod3());
		this.hashColumns.put("ts_conti", getTsConti());
		this.hashColumns.put("week", getWeek());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("post_vvd2", "postVvd2");
		this.hashFields.put("post_vvd1", "postVvd1");
		this.hashFields.put("type", "type");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pre_vvd", "preVvd");
		this.hashFields.put("pre_pst_flg", "prePstFlg");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("del", "del");
		this.hashFields.put("year", "year");
		this.hashFields.put("post_vvd", "postVvd");
		this.hashFields.put("ts_lane3", "tsLane3");
		this.hashFields.put("ts_lane4", "tsLane4");
		this.hashFields.put("ts_lane5", "tsLane5");
		this.hashFields.put("ts_port", "tsPort");
		this.hashFields.put("ts_lane6", "tsLane6");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("pol6", "pol6");
		this.hashFields.put("pol5", "pol5");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pol4", "pol4");
		this.hashFields.put("pol3", "pol3");
		this.hashFields.put("pol2", "pol2");
		this.hashFields.put("pol1", "pol1");
		this.hashFields.put("pod5", "pod5");
		this.hashFields.put("pod6", "pod6");
		this.hashFields.put("ts_lane1", "tsLane1");
		this.hashFields.put("ts_lane2", "tsLane2");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod2", "pod2");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("pod1", "pod1");
		this.hashFields.put("duration", "duration");
		this.hashFields.put("pod4", "pod4");
		this.hashFields.put("pod3", "pod3");
		this.hashFields.put("ts_conti", "tsConti");
		this.hashFields.put("week", "week");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return postVvd2
	 */
	public String getPostVvd2() {
		return this.postVvd2;
	}
	
	/**
	 * Column Info
	 * @return postVvd1
	 */
	public String getPostVvd1() {
		return this.postVvd1;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return preVvd
	 */
	public String getPreVvd() {
		return this.preVvd;
	}
	
	/**
	 * Column Info
	 * @return prePstFlg
	 */
	public String getPrePstFlg() {
		return this.prePstFlg;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return year
	 */
	public String getYear() {
		return this.year;
	}
	
	/**
	 * Column Info
	 * @return postVvd
	 */
	public String getPostVvd() {
		return this.postVvd;
	}
	
	/**
	 * Column Info
	 * @return tsLane3
	 */
	public String getTsLane3() {
		return this.tsLane3;
	}
	
	/**
	 * Column Info
	 * @return tsLane4
	 */
	public String getTsLane4() {
		return this.tsLane4;
	}
	
	/**
	 * Column Info
	 * @return tsLane5
	 */
	public String getTsLane5() {
		return this.tsLane5;
	}
	
	/**
	 * Column Info
	 * @return tsPort
	 */
	public String getTsPort() {
		return this.tsPort;
	}
	
	/**
	 * Column Info
	 * @return tsLane6
	 */
	public String getTsLane6() {
		return this.tsLane6;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return pol6
	 */
	public String getPol6() {
		return this.pol6;
	}
	
	/**
	 * Column Info
	 * @return pol5
	 */
	public String getPol5() {
		return this.pol5;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return pol4
	 */
	public String getPol4() {
		return this.pol4;
	}
	
	/**
	 * Column Info
	 * @return pol3
	 */
	public String getPol3() {
		return this.pol3;
	}
	
	/**
	 * Column Info
	 * @return pol2
	 */
	public String getPol2() {
		return this.pol2;
	}
	
	/**
	 * Column Info
	 * @return pol1
	 */
	public String getPol1() {
		return this.pol1;
	}
	
	/**
	 * Column Info
	 * @return pod5
	 */
	public String getPod5() {
		return this.pod5;
	}
	
	/**
	 * Column Info
	 * @return pod6
	 */
	public String getPod6() {
		return this.pod6;
	}
	
	/**
	 * Column Info
	 * @return tsLane1
	 */
	public String getTsLane1() {
		return this.tsLane1;
	}
	
	/**
	 * Column Info
	 * @return tsLane2
	 */
	public String getTsLane2() {
		return this.tsLane2;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return pod2
	 */
	public String getPod2() {
		return this.pod2;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return pod1
	 */
	public String getPod1() {
		return this.pod1;
	}
	
	/**
	 * Column Info
	 * @return duration
	 */
	public String getDuration() {
		return this.duration;
	}
	
	/**
	 * Column Info
	 * @return pod4
	 */
	public String getPod4() {
		return this.pod4;
	}
	
	/**
	 * Column Info
	 * @return pod3
	 */
	public String getPod3() {
		return this.pod3;
	}
	
	/**
	 * Column Info
	 * @return tsConti
	 */
	public String getTsConti() {
		return this.tsConti;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
	}
	

	/**
	 * Column Info
	 * @param postVvd2
	 */
	public void setPostVvd2(String postVvd2) {
		this.postVvd2 = postVvd2;
	}
	
	/**
	 * Column Info
	 * @param postVvd1
	 */
	public void setPostVvd1(String postVvd1) {
		this.postVvd1 = postVvd1;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param preVvd
	 */
	public void setPreVvd(String preVvd) {
		this.preVvd = preVvd;
	}
	
	/**
	 * Column Info
	 * @param prePstFlg
	 */
	public void setPrePstFlg(String prePstFlg) {
		this.prePstFlg = prePstFlg;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * Column Info
	 * @param postVvd
	 */
	public void setPostVvd(String postVvd) {
		this.postVvd = postVvd;
	}
	
	/**
	 * Column Info
	 * @param tsLane3
	 */
	public void setTsLane3(String tsLane3) {
		this.tsLane3 = tsLane3;
	}
	
	/**
	 * Column Info
	 * @param tsLane4
	 */
	public void setTsLane4(String tsLane4) {
		this.tsLane4 = tsLane4;
	}
	
	/**
	 * Column Info
	 * @param tsLane5
	 */
	public void setTsLane5(String tsLane5) {
		this.tsLane5 = tsLane5;
	}
	
	/**
	 * Column Info
	 * @param tsPort
	 */
	public void setTsPort(String tsPort) {
		this.tsPort = tsPort;
	}
	
	/**
	 * Column Info
	 * @param tsLane6
	 */
	public void setTsLane6(String tsLane6) {
		this.tsLane6 = tsLane6;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param pol6
	 */
	public void setPol6(String pol6) {
		this.pol6 = pol6;
	}
	
	/**
	 * Column Info
	 * @param pol5
	 */
	public void setPol5(String pol5) {
		this.pol5 = pol5;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param pol4
	 */
	public void setPol4(String pol4) {
		this.pol4 = pol4;
	}
	
	/**
	 * Column Info
	 * @param pol3
	 */
	public void setPol3(String pol3) {
		this.pol3 = pol3;
	}
	
	/**
	 * Column Info
	 * @param pol2
	 */
	public void setPol2(String pol2) {
		this.pol2 = pol2;
	}
	
	/**
	 * Column Info
	 * @param pol1
	 */
	public void setPol1(String pol1) {
		this.pol1 = pol1;
	}
	
	/**
	 * Column Info
	 * @param pod5
	 */
	public void setPod5(String pod5) {
		this.pod5 = pod5;
	}
	
	/**
	 * Column Info
	 * @param pod6
	 */
	public void setPod6(String pod6) {
		this.pod6 = pod6;
	}
	
	/**
	 * Column Info
	 * @param tsLane1
	 */
	public void setTsLane1(String tsLane1) {
		this.tsLane1 = tsLane1;
	}
	
	/**
	 * Column Info
	 * @param tsLane2
	 */
	public void setTsLane2(String tsLane2) {
		this.tsLane2 = tsLane2;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param pod2
	 */
	public void setPod2(String pod2) {
		this.pod2 = pod2;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param pod1
	 */
	public void setPod1(String pod1) {
		this.pod1 = pod1;
	}
	
	/**
	 * Column Info
	 * @param duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	/**
	 * Column Info
	 * @param pod4
	 */
	public void setPod4(String pod4) {
		this.pod4 = pod4;
	}
	
	/**
	 * Column Info
	 * @param pod3
	 */
	public void setPod3(String pod3) {
		this.pod3 = pod3;
	}
	
	/**
	 * Column Info
	 * @param tsConti
	 */
	public void setTsConti(String tsConti) {
		this.tsConti = tsConti;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
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
		setPostVvd2(JSPUtil.getParameter(request, prefix + "post_vvd2", ""));
		setPostVvd1(JSPUtil.getParameter(request, prefix + "post_vvd1", ""));
		setType(JSPUtil.getParameter(request, prefix + "type", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPreVvd(JSPUtil.getParameter(request, prefix + "pre_vvd", ""));
		setPrePstFlg(JSPUtil.getParameter(request, prefix + "pre_pst_flg", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setYear(JSPUtil.getParameter(request, prefix + "year", ""));
		setPostVvd(JSPUtil.getParameter(request, prefix + "post_vvd", ""));
		setTsLane3(JSPUtil.getParameter(request, prefix + "ts_lane3", ""));
		setTsLane4(JSPUtil.getParameter(request, prefix + "ts_lane4", ""));
		setTsLane5(JSPUtil.getParameter(request, prefix + "ts_lane5", ""));
		setTsPort(JSPUtil.getParameter(request, prefix + "ts_port", ""));
		setTsLane6(JSPUtil.getParameter(request, prefix + "ts_lane6", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setPol6(JSPUtil.getParameter(request, prefix + "pol6", ""));
		setPol5(JSPUtil.getParameter(request, prefix + "pol5", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPol4(JSPUtil.getParameter(request, prefix + "pol4", ""));
		setPol3(JSPUtil.getParameter(request, prefix + "pol3", ""));
		setPol2(JSPUtil.getParameter(request, prefix + "pol2", ""));
		setPol1(JSPUtil.getParameter(request, prefix + "pol1", ""));
		setPod5(JSPUtil.getParameter(request, prefix + "pod5", ""));
		setPod6(JSPUtil.getParameter(request, prefix + "pod6", ""));
		setTsLane1(JSPUtil.getParameter(request, prefix + "ts_lane1", ""));
		setTsLane2(JSPUtil.getParameter(request, prefix + "ts_lane2", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPod2(JSPUtil.getParameter(request, prefix + "pod2", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setPod1(JSPUtil.getParameter(request, prefix + "pod1", ""));
		setDuration(JSPUtil.getParameter(request, prefix + "duration", ""));
		setPod4(JSPUtil.getParameter(request, prefix + "pod4", ""));
		setPod3(JSPUtil.getParameter(request, prefix + "pod3", ""));
		setTsConti(JSPUtil.getParameter(request, prefix + "ts_conti", ""));
		setWeek(JSPUtil.getParameter(request, prefix + "week", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTSBookingListConditionVO[]
	 */
	public SearchTSBookingListConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTSBookingListConditionVO[]
	 */
	public SearchTSBookingListConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTSBookingListConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] postVvd2 = (JSPUtil.getParameter(request, prefix	+ "post_vvd2", length));
			String[] postVvd1 = (JSPUtil.getParameter(request, prefix	+ "post_vvd1", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] preVvd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd", length));
			String[] prePstFlg = (JSPUtil.getParameter(request, prefix	+ "pre_pst_flg", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] year = (JSPUtil.getParameter(request, prefix	+ "year", length));
			String[] postVvd = (JSPUtil.getParameter(request, prefix	+ "post_vvd", length));
			String[] tsLane3 = (JSPUtil.getParameter(request, prefix	+ "ts_lane3", length));
			String[] tsLane4 = (JSPUtil.getParameter(request, prefix	+ "ts_lane4", length));
			String[] tsLane5 = (JSPUtil.getParameter(request, prefix	+ "ts_lane5", length));
			String[] tsPort = (JSPUtil.getParameter(request, prefix	+ "ts_port", length));
			String[] tsLane6 = (JSPUtil.getParameter(request, prefix	+ "ts_lane6", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] pol6 = (JSPUtil.getParameter(request, prefix	+ "pol6", length));
			String[] pol5 = (JSPUtil.getParameter(request, prefix	+ "pol5", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] pol4 = (JSPUtil.getParameter(request, prefix	+ "pol4", length));
			String[] pol3 = (JSPUtil.getParameter(request, prefix	+ "pol3", length));
			String[] pol2 = (JSPUtil.getParameter(request, prefix	+ "pol2", length));
			String[] pol1 = (JSPUtil.getParameter(request, prefix	+ "pol1", length));
			String[] pod5 = (JSPUtil.getParameter(request, prefix	+ "pod5", length));
			String[] pod6 = (JSPUtil.getParameter(request, prefix	+ "pod6", length));
			String[] tsLane1 = (JSPUtil.getParameter(request, prefix	+ "ts_lane1", length));
			String[] tsLane2 = (JSPUtil.getParameter(request, prefix	+ "ts_lane2", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] pod2 = (JSPUtil.getParameter(request, prefix	+ "pod2", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] pod1 = (JSPUtil.getParameter(request, prefix	+ "pod1", length));
			String[] duration = (JSPUtil.getParameter(request, prefix	+ "duration", length));
			String[] pod4 = (JSPUtil.getParameter(request, prefix	+ "pod4", length));
			String[] pod3 = (JSPUtil.getParameter(request, prefix	+ "pod3", length));
			String[] tsConti = (JSPUtil.getParameter(request, prefix	+ "ts_conti", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTSBookingListConditionVO();
				if (postVvd2[i] != null)
					model.setPostVvd2(postVvd2[i]);
				if (postVvd1[i] != null)
					model.setPostVvd1(postVvd1[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (preVvd[i] != null)
					model.setPreVvd(preVvd[i]);
				if (prePstFlg[i] != null)
					model.setPrePstFlg(prePstFlg[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (year[i] != null)
					model.setYear(year[i]);
				if (postVvd[i] != null)
					model.setPostVvd(postVvd[i]);
				if (tsLane3[i] != null)
					model.setTsLane3(tsLane3[i]);
				if (tsLane4[i] != null)
					model.setTsLane4(tsLane4[i]);
				if (tsLane5[i] != null)
					model.setTsLane5(tsLane5[i]);
				if (tsPort[i] != null)
					model.setTsPort(tsPort[i]);
				if (tsLane6[i] != null)
					model.setTsLane6(tsLane6[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (pol6[i] != null)
					model.setPol6(pol6[i]);
				if (pol5[i] != null)
					model.setPol5(pol5[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (pol4[i] != null)
					model.setPol4(pol4[i]);
				if (pol3[i] != null)
					model.setPol3(pol3[i]);
				if (pol2[i] != null)
					model.setPol2(pol2[i]);
				if (pol1[i] != null)
					model.setPol1(pol1[i]);
				if (pod5[i] != null)
					model.setPod5(pod5[i]);
				if (pod6[i] != null)
					model.setPod6(pod6[i]);
				if (tsLane1[i] != null)
					model.setTsLane1(tsLane1[i]);
				if (tsLane2[i] != null)
					model.setTsLane2(tsLane2[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (pod2[i] != null)
					model.setPod2(pod2[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (pod1[i] != null)
					model.setPod1(pod1[i]);
				if (duration[i] != null)
					model.setDuration(duration[i]);
				if (pod4[i] != null)
					model.setPod4(pod4[i]);
				if (pod3[i] != null)
					model.setPod3(pod3[i]);
				if (tsConti[i] != null)
					model.setTsConti(tsConti[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTSBookingListConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTSBookingListConditionVO[]
	 */
	public SearchTSBookingListConditionVO[] getSearchTSBookingListConditionVOs(){
		SearchTSBookingListConditionVO[] vos = (SearchTSBookingListConditionVO[])models.toArray(new SearchTSBookingListConditionVO[models.size()]);
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
		this.postVvd2 = this.postVvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postVvd1 = this.postVvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd = this.preVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePstFlg = this.prePstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year = this.year .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postVvd = this.postVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsLane3 = this.tsLane3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsLane4 = this.tsLane4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsLane5 = this.tsLane5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPort = this.tsPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsLane6 = this.tsLane6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol6 = this.pol6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol5 = this.pol5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol4 = this.pol4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3 = this.pol3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2 = this.pol2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1 = this.pol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod5 = this.pod5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod6 = this.pod6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsLane1 = this.tsLane1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsLane2 = this.tsLane2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2 = this.pod2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1 = this.pod1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration = this.duration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod4 = this.pod4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod3 = this.pod3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsConti = this.tsConti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
