/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchDryDockScheduleGraphListVO.java
*@FileTitle : SearchDryDockScheduleGraphListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.06 윤세영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.event.ESM_FMS_0055HTMLAction;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 윤세영
 * @since J2EE 1.5
 * @see ESM_FMS_0055HTMLAction
 */

public class SearchDryDockScheduleGraphListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDryDockScheduleGraphListVO> models = new ArrayList<SearchDryDockScheduleGraphListVO>();
	
	/* Column Info */
	private String ym102 = null;
	/* Column Info */
	private String ym204 = null;
	/* Column Info */
	private String ym312 = null;
	/* Column Info */
	private String ym210 = null;
	/* Column Info */
	private String ym112 = null;
	/* Column Info */
	private String ym205 = null;
	/* Column Info */
	private String ym101 = null;
	/* Column Info */
	private String ym303 = null;
	/* Column Info */
	private String ym202 = null;
	/* Column Info */
	private String ym308 = null;
	/* Column Info */
	private String ym104 = null;
	/* Column Info */
	private String ym109 = null;
	/* Column Info */
	private String ym212 = null;
	/* Column Info */
	private String ym306 = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String ym111 = null;
	/* Column Info */
	private String ym201 = null;
	/* Column Info */
	private String ym311 = null;
	/* Column Info */
	private String ym103 = null;
	/* Column Info */
	private String ym110 = null;
	/* Column Info */
	private String ym305 = null;
	/* Column Info */
	private String ym211 = null;
	/* Column Info */
	private String ym106 = null;
	/* Column Info */
	private String ym207 = null;
	/* Column Info */
	private String ym209 = null;
	/* Column Info */
	private String ym301 = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String ym304 = null;
	/* Column Info */
	private String ym309 = null;
	/* Column Info */
	private String ym107 = null;
	/* Column Info */
	private String ym208 = null;
	/* Column Info */
	private String ym108 = null;
	/* Column Info */
	private String ym307 = null;
	/* Column Info */
	private String ym206 = null;
	/* Column Info */
	private String vslDzndCapa = null;
	/* Column Info */
	private String ym310 = null;
	/* Column Info */
	private String ym302 = null;
	/* Column Info */
	private String ym105 = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String ym203 = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDryDockScheduleGraphListVO() {}

	public SearchDryDockScheduleGraphListVO(String ibflag, String pagerows, String vslCd, String slanCd, String vslDzndCapa, String ym101, String ym102, String ym103, String ym104, String ym105, String ym106, String ym107, String ym108, String ym109, String ym110, String ym111, String ym112, String ym201, String ym202, String ym203, String ym204, String ym205, String ym206, String ym207, String ym208, String ym209, String ym210, String ym211, String ym212, String ym301, String ym302, String ym303, String ym304, String ym305, String ym306, String ym307, String ym308, String ym309, String ym310, String ym311, String ym312) {
		this.ym102 = ym102;
		this.ym204 = ym204;
		this.ym312 = ym312;
		this.ym210 = ym210;
		this.ym112 = ym112;
		this.ym205 = ym205;
		this.ym101 = ym101;
		this.ym303 = ym303;
		this.ym202 = ym202;
		this.ym308 = ym308;
		this.ym104 = ym104;
		this.ym109 = ym109;
		this.ym212 = ym212;
		this.ym306 = ym306;
		this.vslCd = vslCd;
		this.ym111 = ym111;
		this.ym201 = ym201;
		this.ym311 = ym311;
		this.ym103 = ym103;
		this.ym110 = ym110;
		this.ym305 = ym305;
		this.ym211 = ym211;
		this.ym106 = ym106;
		this.ym207 = ym207;
		this.ym209 = ym209;
		this.ym301 = ym301;
		this.ibflag = ibflag;
		this.ym304 = ym304;
		this.ym309 = ym309;
		this.ym107 = ym107;
		this.ym208 = ym208;
		this.ym108 = ym108;
		this.ym307 = ym307;
		this.ym206 = ym206;
		this.vslDzndCapa = vslDzndCapa;
		this.ym310 = ym310;
		this.ym302 = ym302;
		this.ym105 = ym105;
		this.slanCd = slanCd;
		this.ym203 = ym203;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ym1_02", getYm102());
		this.hashColumns.put("ym2_04", getYm204());
		this.hashColumns.put("ym3_12", getYm312());
		this.hashColumns.put("ym2_10", getYm210());
		this.hashColumns.put("ym1_12", getYm112());
		this.hashColumns.put("ym2_05", getYm205());
		this.hashColumns.put("ym1_01", getYm101());
		this.hashColumns.put("ym3_03", getYm303());
		this.hashColumns.put("ym2_02", getYm202());
		this.hashColumns.put("ym3_08", getYm308());
		this.hashColumns.put("ym1_04", getYm104());
		this.hashColumns.put("ym1_09", getYm109());
		this.hashColumns.put("ym2_12", getYm212());
		this.hashColumns.put("ym3_06", getYm306());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ym1_11", getYm111());
		this.hashColumns.put("ym2_01", getYm201());
		this.hashColumns.put("ym3_11", getYm311());
		this.hashColumns.put("ym1_03", getYm103());
		this.hashColumns.put("ym1_10", getYm110());
		this.hashColumns.put("ym3_05", getYm305());
		this.hashColumns.put("ym2_11", getYm211());
		this.hashColumns.put("ym1_06", getYm106());
		this.hashColumns.put("ym2_07", getYm207());
		this.hashColumns.put("ym2_09", getYm209());
		this.hashColumns.put("ym3_01", getYm301());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ym3_04", getYm304());
		this.hashColumns.put("ym3_09", getYm309());
		this.hashColumns.put("ym1_07", getYm107());
		this.hashColumns.put("ym2_08", getYm208());
		this.hashColumns.put("ym1_08", getYm108());
		this.hashColumns.put("ym3_07", getYm307());
		this.hashColumns.put("ym2_06", getYm206());
		this.hashColumns.put("vsl_dznd_capa", getVslDzndCapa());
		this.hashColumns.put("ym3_10", getYm310());
		this.hashColumns.put("ym3_02", getYm302());
		this.hashColumns.put("ym1_05", getYm105());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("ym2_03", getYm203());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ym1_02", "ym102");
		this.hashFields.put("ym2_04", "ym204");
		this.hashFields.put("ym3_12", "ym312");
		this.hashFields.put("ym2_10", "ym210");
		this.hashFields.put("ym1_12", "ym112");
		this.hashFields.put("ym2_05", "ym205");
		this.hashFields.put("ym1_01", "ym101");
		this.hashFields.put("ym3_03", "ym303");
		this.hashFields.put("ym2_02", "ym202");
		this.hashFields.put("ym3_08", "ym308");
		this.hashFields.put("ym1_04", "ym104");
		this.hashFields.put("ym1_09", "ym109");
		this.hashFields.put("ym2_12", "ym212");
		this.hashFields.put("ym3_06", "ym306");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ym1_11", "ym111");
		this.hashFields.put("ym2_01", "ym201");
		this.hashFields.put("ym3_11", "ym311");
		this.hashFields.put("ym1_03", "ym103");
		this.hashFields.put("ym1_10", "ym110");
		this.hashFields.put("ym3_05", "ym305");
		this.hashFields.put("ym2_11", "ym211");
		this.hashFields.put("ym1_06", "ym106");
		this.hashFields.put("ym2_07", "ym207");
		this.hashFields.put("ym2_09", "ym209");
		this.hashFields.put("ym3_01", "ym301");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ym3_04", "ym304");
		this.hashFields.put("ym3_09", "ym309");
		this.hashFields.put("ym1_07", "ym107");
		this.hashFields.put("ym2_08", "ym208");
		this.hashFields.put("ym1_08", "ym108");
		this.hashFields.put("ym3_07", "ym307");
		this.hashFields.put("ym2_06", "ym206");
		this.hashFields.put("vsl_dznd_capa", "vslDzndCapa");
		this.hashFields.put("ym3_10", "ym310");
		this.hashFields.put("ym3_02", "ym302");
		this.hashFields.put("ym1_05", "ym105");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("ym2_03", "ym203");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getYm102() {
		return this.ym102;
	}
	public String getYm204() {
		return this.ym204;
	}
	public String getYm312() {
		return this.ym312;
	}
	public String getYm210() {
		return this.ym210;
	}
	public String getYm112() {
		return this.ym112;
	}
	public String getYm205() {
		return this.ym205;
	}
	public String getYm101() {
		return this.ym101;
	}
	public String getYm303() {
		return this.ym303;
	}
	public String getYm202() {
		return this.ym202;
	}
	public String getYm308() {
		return this.ym308;
	}
	public String getYm104() {
		return this.ym104;
	}
	public String getYm109() {
		return this.ym109;
	}
	public String getYm212() {
		return this.ym212;
	}
	public String getYm306() {
		return this.ym306;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getYm111() {
		return this.ym111;
	}
	public String getYm201() {
		return this.ym201;
	}
	public String getYm311() {
		return this.ym311;
	}
	public String getYm103() {
		return this.ym103;
	}
	public String getYm110() {
		return this.ym110;
	}
	public String getYm305() {
		return this.ym305;
	}
	public String getYm211() {
		return this.ym211;
	}
	public String getYm106() {
		return this.ym106;
	}
	public String getYm207() {
		return this.ym207;
	}
	public String getYm209() {
		return this.ym209;
	}
	public String getYm301() {
		return this.ym301;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getYm304() {
		return this.ym304;
	}
	public String getYm309() {
		return this.ym309;
	}
	public String getYm107() {
		return this.ym107;
	}
	public String getYm208() {
		return this.ym208;
	}
	public String getYm108() {
		return this.ym108;
	}
	public String getYm307() {
		return this.ym307;
	}
	public String getYm206() {
		return this.ym206;
	}
	public String getVslDzndCapa() {
		return this.vslDzndCapa;
	}
	public String getYm310() {
		return this.ym310;
	}
	public String getYm302() {
		return this.ym302;
	}
	public String getYm105() {
		return this.ym105;
	}
	public String getSlanCd() {
		return this.slanCd;
	}
	public String getYm203() {
		return this.ym203;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setYm102(String ym102) {
		this.ym102 = ym102;
		//this.ym102=true;
	}
	public void setYm204(String ym204) {
		this.ym204 = ym204;
		//this.ym204=true;
	}
	public void setYm312(String ym312) {
		this.ym312 = ym312;
		//this.ym312=true;
	}
	public void setYm210(String ym210) {
		this.ym210 = ym210;
		//this.ym210=true;
	}
	public void setYm112(String ym112) {
		this.ym112 = ym112;
		//this.ym112=true;
	}
	public void setYm205(String ym205) {
		this.ym205 = ym205;
		//this.ym205=true;
	}
	public void setYm101(String ym101) {
		this.ym101 = ym101;
		//this.ym101=true;
	}
	public void setYm303(String ym303) {
		this.ym303 = ym303;
		//this.ym303=true;
	}
	public void setYm202(String ym202) {
		this.ym202 = ym202;
		//this.ym202=true;
	}
	public void setYm308(String ym308) {
		this.ym308 = ym308;
		//this.ym308=true;
	}
	public void setYm104(String ym104) {
		this.ym104 = ym104;
		//this.ym104=true;
	}
	public void setYm109(String ym109) {
		this.ym109 = ym109;
		//this.ym109=true;
	}
	public void setYm212(String ym212) {
		this.ym212 = ym212;
		//this.ym212=true;
	}
	public void setYm306(String ym306) {
		this.ym306 = ym306;
		//this.ym306=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setYm111(String ym111) {
		this.ym111 = ym111;
		//this.ym111=true;
	}
	public void setYm201(String ym201) {
		this.ym201 = ym201;
		//this.ym201=true;
	}
	public void setYm311(String ym311) {
		this.ym311 = ym311;
		//this.ym311=true;
	}
	public void setYm103(String ym103) {
		this.ym103 = ym103;
		//this.ym103=true;
	}
	public void setYm110(String ym110) {
		this.ym110 = ym110;
		//this.ym110=true;
	}
	public void setYm305(String ym305) {
		this.ym305 = ym305;
		//this.ym305=true;
	}
	public void setYm211(String ym211) {
		this.ym211 = ym211;
		//this.ym211=true;
	}
	public void setYm106(String ym106) {
		this.ym106 = ym106;
		//this.ym106=true;
	}
	public void setYm207(String ym207) {
		this.ym207 = ym207;
		//this.ym207=true;
	}
	public void setYm209(String ym209) {
		this.ym209 = ym209;
		//this.ym209=true;
	}
	public void setYm301(String ym301) {
		this.ym301 = ym301;
		//this.ym301=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setYm304(String ym304) {
		this.ym304 = ym304;
		//this.ym304=true;
	}
	public void setYm309(String ym309) {
		this.ym309 = ym309;
		//this.ym309=true;
	}
	public void setYm107(String ym107) {
		this.ym107 = ym107;
		//this.ym107=true;
	}
	public void setYm208(String ym208) {
		this.ym208 = ym208;
		//this.ym208=true;
	}
	public void setYm108(String ym108) {
		this.ym108 = ym108;
		//this.ym108=true;
	}
	public void setYm307(String ym307) {
		this.ym307 = ym307;
		//this.ym307=true;
	}
	public void setYm206(String ym206) {
		this.ym206 = ym206;
		//this.ym206=true;
	}
	public void setVslDzndCapa(String vslDzndCapa) {
		this.vslDzndCapa = vslDzndCapa;
		//this.vslDzndCapa=true;
	}
	public void setYm310(String ym310) {
		this.ym310 = ym310;
		//this.ym310=true;
	}
	public void setYm302(String ym302) {
		this.ym302 = ym302;
		//this.ym302=true;
	}
	public void setYm105(String ym105) {
		this.ym105 = ym105;
		//this.ym105=true;
	}
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
		//this.vslSlanCd=true;
	}
	public void setYm203(String ym203) {
		this.ym203 = ym203;
		//this.ym203=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setYm102(JSPUtil.getParameter(request, "ym1_02", ""));
		setYm204(JSPUtil.getParameter(request, "ym2_04", ""));
		setYm312(JSPUtil.getParameter(request, "ym3_12", ""));
		setYm210(JSPUtil.getParameter(request, "ym2_10", ""));
		setYm112(JSPUtil.getParameter(request, "ym1_12", ""));
		setYm205(JSPUtil.getParameter(request, "ym2_05", ""));
		setYm101(JSPUtil.getParameter(request, "ym1_01", ""));
		setYm303(JSPUtil.getParameter(request, "ym3_03", ""));
		setYm202(JSPUtil.getParameter(request, "ym2_02", ""));
		setYm308(JSPUtil.getParameter(request, "ym3_08", ""));
		setYm104(JSPUtil.getParameter(request, "ym1_04", ""));
		setYm109(JSPUtil.getParameter(request, "ym1_09", ""));
		setYm212(JSPUtil.getParameter(request, "ym2_12", ""));
		setYm306(JSPUtil.getParameter(request, "ym3_06", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setYm111(JSPUtil.getParameter(request, "ym1_11", ""));
		setYm201(JSPUtil.getParameter(request, "ym2_01", ""));
		setYm311(JSPUtil.getParameter(request, "ym3_11", ""));
		setYm103(JSPUtil.getParameter(request, "ym1_03", ""));
		setYm110(JSPUtil.getParameter(request, "ym1_10", ""));
		setYm305(JSPUtil.getParameter(request, "ym3_05", ""));
		setYm211(JSPUtil.getParameter(request, "ym2_11", ""));
		setYm106(JSPUtil.getParameter(request, "ym1_06", ""));
		setYm207(JSPUtil.getParameter(request, "ym2_07", ""));
		setYm209(JSPUtil.getParameter(request, "ym2_09", ""));
		setYm301(JSPUtil.getParameter(request, "ym3_01", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYm304(JSPUtil.getParameter(request, "ym3_04", ""));
		setYm309(JSPUtil.getParameter(request, "ym3_09", ""));
		setYm107(JSPUtil.getParameter(request, "ym1_07", ""));
		setYm208(JSPUtil.getParameter(request, "ym2_08", ""));
		setYm108(JSPUtil.getParameter(request, "ym1_08", ""));
		setYm307(JSPUtil.getParameter(request, "ym3_07", ""));
		setYm206(JSPUtil.getParameter(request, "ym2_06", ""));
		setVslDzndCapa(JSPUtil.getParameter(request, "vsl_dznd_capa", ""));
		setYm310(JSPUtil.getParameter(request, "ym3_10", ""));
		setYm302(JSPUtil.getParameter(request, "ym3_02", ""));
		setYm105(JSPUtil.getParameter(request, "ym1_05", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setYm203(JSPUtil.getParameter(request, "ym2_03", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchDryDockScheduleGraphListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchDryDockScheduleGraphListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDryDockScheduleGraphListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ym102 = (JSPUtil.getParameter(request, prefix	+ "ym1_02".trim(), length));
			String[] ym204 = (JSPUtil.getParameter(request, prefix	+ "ym2_04".trim(), length));
			String[] ym312 = (JSPUtil.getParameter(request, prefix	+ "ym3_12".trim(), length));
			String[] ym210 = (JSPUtil.getParameter(request, prefix	+ "ym2_10".trim(), length));
			String[] ym112 = (JSPUtil.getParameter(request, prefix	+ "ym1_12".trim(), length));
			String[] ym205 = (JSPUtil.getParameter(request, prefix	+ "ym2_05".trim(), length));
			String[] ym101 = (JSPUtil.getParameter(request, prefix	+ "ym1_01".trim(), length));
			String[] ym303 = (JSPUtil.getParameter(request, prefix	+ "ym3_03".trim(), length));
			String[] ym202 = (JSPUtil.getParameter(request, prefix	+ "ym2_02".trim(), length));
			String[] ym308 = (JSPUtil.getParameter(request, prefix	+ "ym3_08".trim(), length));
			String[] ym104 = (JSPUtil.getParameter(request, prefix	+ "ym1_04".trim(), length));
			String[] ym109 = (JSPUtil.getParameter(request, prefix	+ "ym1_09".trim(), length));
			String[] ym212 = (JSPUtil.getParameter(request, prefix	+ "ym2_12".trim(), length));
			String[] ym306 = (JSPUtil.getParameter(request, prefix	+ "ym3_06".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] ym111 = (JSPUtil.getParameter(request, prefix	+ "ym1_11".trim(), length));
			String[] ym201 = (JSPUtil.getParameter(request, prefix	+ "ym2_01".trim(), length));
			String[] ym311 = (JSPUtil.getParameter(request, prefix	+ "ym3_11".trim(), length));
			String[] ym103 = (JSPUtil.getParameter(request, prefix	+ "ym1_03".trim(), length));
			String[] ym110 = (JSPUtil.getParameter(request, prefix	+ "ym1_10".trim(), length));
			String[] ym305 = (JSPUtil.getParameter(request, prefix	+ "ym3_05".trim(), length));
			String[] ym211 = (JSPUtil.getParameter(request, prefix	+ "ym2_11".trim(), length));
			String[] ym106 = (JSPUtil.getParameter(request, prefix	+ "ym1_06".trim(), length));
			String[] ym207 = (JSPUtil.getParameter(request, prefix	+ "ym2_07".trim(), length));
			String[] ym209 = (JSPUtil.getParameter(request, prefix	+ "ym2_09".trim(), length));
			String[] ym301 = (JSPUtil.getParameter(request, prefix	+ "ym3_01".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] ym304 = (JSPUtil.getParameter(request, prefix	+ "ym3_04".trim(), length));
			String[] ym309 = (JSPUtil.getParameter(request, prefix	+ "ym3_09".trim(), length));
			String[] ym107 = (JSPUtil.getParameter(request, prefix	+ "ym1_07".trim(), length));
			String[] ym208 = (JSPUtil.getParameter(request, prefix	+ "ym2_08".trim(), length));
			String[] ym108 = (JSPUtil.getParameter(request, prefix	+ "ym1_08".trim(), length));
			String[] ym307 = (JSPUtil.getParameter(request, prefix	+ "ym3_07".trim(), length));
			String[] ym206 = (JSPUtil.getParameter(request, prefix	+ "ym2_06".trim(), length));
			String[] vslDzndCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_dznd_capa".trim(), length));
			String[] ym310 = (JSPUtil.getParameter(request, prefix	+ "ym3_10".trim(), length));
			String[] ym302 = (JSPUtil.getParameter(request, prefix	+ "ym3_02".trim(), length));
			String[] ym105 = (JSPUtil.getParameter(request, prefix	+ "ym1_05".trim(), length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd".trim(), length));
			String[] ym203 = (JSPUtil.getParameter(request, prefix	+ "ym2_03".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDryDockScheduleGraphListVO();
				if (ym102[i] != null)
					model.setYm102(ym102[i]);
				if (ym204[i] != null)
					model.setYm204(ym204[i]);
				if (ym312[i] != null)
					model.setYm312(ym312[i]);
				if (ym210[i] != null)
					model.setYm210(ym210[i]);
				if (ym112[i] != null)
					model.setYm112(ym112[i]);
				if (ym205[i] != null)
					model.setYm205(ym205[i]);
				if (ym101[i] != null)
					model.setYm101(ym101[i]);
				if (ym303[i] != null)
					model.setYm303(ym303[i]);
				if (ym202[i] != null)
					model.setYm202(ym202[i]);
				if (ym308[i] != null)
					model.setYm308(ym308[i]);
				if (ym104[i] != null)
					model.setYm104(ym104[i]);
				if (ym109[i] != null)
					model.setYm109(ym109[i]);
				if (ym212[i] != null)
					model.setYm212(ym212[i]);
				if (ym306[i] != null)
					model.setYm306(ym306[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ym111[i] != null)
					model.setYm111(ym111[i]);
				if (ym201[i] != null)
					model.setYm201(ym201[i]);
				if (ym311[i] != null)
					model.setYm311(ym311[i]);
				if (ym103[i] != null)
					model.setYm103(ym103[i]);
				if (ym110[i] != null)
					model.setYm110(ym110[i]);
				if (ym305[i] != null)
					model.setYm305(ym305[i]);
				if (ym211[i] != null)
					model.setYm211(ym211[i]);
				if (ym106[i] != null)
					model.setYm106(ym106[i]);
				if (ym207[i] != null)
					model.setYm207(ym207[i]);
				if (ym209[i] != null)
					model.setYm209(ym209[i]);
				if (ym301[i] != null)
					model.setYm301(ym301[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ym304[i] != null)
					model.setYm304(ym304[i]);
				if (ym309[i] != null)
					model.setYm309(ym309[i]);
				if (ym107[i] != null)
					model.setYm107(ym107[i]);
				if (ym208[i] != null)
					model.setYm208(ym208[i]);
				if (ym108[i] != null)
					model.setYm108(ym108[i]);
				if (ym307[i] != null)
					model.setYm307(ym307[i]);
				if (ym206[i] != null)
					model.setYm206(ym206[i]);
				if (vslDzndCapa[i] != null)
					model.setVslDzndCapa(vslDzndCapa[i]);
				if (ym310[i] != null)
					model.setYm310(ym310[i]);
				if (ym302[i] != null)
					model.setYm302(ym302[i]);
				if (ym105[i] != null)
					model.setYm105(ym105[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (ym203[i] != null)
					model.setYm203(ym203[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchDryDockScheduleGraphListVOs();
	}

	public SearchDryDockScheduleGraphListVO[] getSearchDryDockScheduleGraphListVOs(){
		SearchDryDockScheduleGraphListVO[] vos = (SearchDryDockScheduleGraphListVO[])models.toArray(new SearchDryDockScheduleGraphListVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.ym102 = this.ym102 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym204 = this.ym204 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym312 = this.ym312 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym210 = this.ym210 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym112 = this.ym112 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym205 = this.ym205 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym101 = this.ym101 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym303 = this.ym303 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym202 = this.ym202 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym308 = this.ym308 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym104 = this.ym104 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym109 = this.ym109 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym212 = this.ym212 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym306 = this.ym306 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym111 = this.ym111 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym201 = this.ym201 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym311 = this.ym311 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym103 = this.ym103 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym110 = this.ym110 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym305 = this.ym305 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym211 = this.ym211 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym106 = this.ym106 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym207 = this.ym207 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym209 = this.ym209 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym301 = this.ym301 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym304 = this.ym304 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym309 = this.ym309 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym107 = this.ym107 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym208 = this.ym208 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym108 = this.ym108 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym307 = this.ym307 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym206 = this.ym206 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDzndCapa = this.vslDzndCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym310 = this.ym310 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym302 = this.ym302 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym105 = this.ym105 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ym203 = this.ym203 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
