/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestSpclStowRqstByPodDetailVO.java
*@FileTitle : CLLCDLManifestSpclStowRqstByPodDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.29 김승민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author 김승민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CLLCDLManifestSpclStowRqstByPodDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CLLCDLManifestSpclStowRqstByPodDetailVO> models = new ArrayList<CLLCDLManifestSpclStowRqstByPodDetailVO>();
	
	/* Column Info */
	private String udav40 = null;
	/* Column Info */
	private String udav20 = null;
	/* Column Info */
	private String udbw40h = null;
	/* Column Info */
	private String pcod40h = null;
	/* Column Info */
	private String udhg40h = null;
	/* Column Info */
	private String od40 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ud40h = null;
	/* Column Info */
	private String udts40 = null;
	/* Column Info */
	private String udts20 = null;
	/* Column Info */
	private String od20 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String odtb40 = null;
	/* Column Info */
	private String udts40h = null;
	/* Column Info */
	private String odts40h = null;
	/* Column Info */
	private String od40h = null;
	/* Column Info */
	private String udab40h = null;
	/* Column Info */
	private String ud40 = null;
	/* Column Info */
	private String odet40h = null;
	/* Column Info */
	private String ud20 = null;
	/* Column Info */
	private String odhd40 = null;
	/* Column Info */
	private String udab20 = null;
	/* Column Info */
	private String udhg20 = null;
	/* Column Info */
	private String podCd3 = null;
	/* Column Info */
	private String udab40 = null;
	/* Column Info */
	private String udhg40 = null;
	/* Column Info */
	private String odhd20 = null;
	/* Column Info */
	private String odtb20 = null;
	/* Column Info */
	private String odet40 = null;
	/* Column Info */
	private String odtb40h = null;
	/* Column Info */
	private String odet20 = null;
	/* Column Info */
	private String udbw20 = null;
	/* Column Info */
	private String pcod40 = null;
	/* Column Info */
	private String odhd40h = null;
	/* Column Info */
	private String odts40 = null;
	/* Column Info */
	private String odts20 = null;
	/* Column Info */
	private String pcod20 = null;
	/* Column Info */
	private String udbw40 = null;
	/* Column Info */
	private String udav40h = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CLLCDLManifestSpclStowRqstByPodDetailVO() {}

	public CLLCDLManifestSpclStowRqstByPodDetailVO(String ibflag, String pagerows, String podCd3, String od20, String od40, String od40h, String odet20, String odet40, String odet40h, String odhd20, String odhd40, String odhd40h, String odtb20, String odtb40, String odtb40h, String odts20, String odts40, String odts40h, String ud20, String ud40, String ud40h, String udab20, String udab40, String udab40h, String udav20, String udav40, String udav40h, String udbw20, String udbw40, String udbw40h, String udhg20, String udhg40, String udhg40h, String udts20, String udts40, String udts40h, String pcod20, String pcod40, String pcod40h) {
		this.udav40 = udav40;
		this.udav20 = udav20;
		this.udbw40h = udbw40h;
		this.pcod40h = pcod40h;
		this.udhg40h = udhg40h;
		this.od40 = od40;
		this.pagerows = pagerows;
		this.ud40h = ud40h;
		this.udts40 = udts40;
		this.udts20 = udts20;
		this.od20 = od20;
		this.ibflag = ibflag;
		this.odtb40 = odtb40;
		this.udts40h = udts40h;
		this.odts40h = odts40h;
		this.od40h = od40h;
		this.udab40h = udab40h;
		this.ud40 = ud40;
		this.odet40h = odet40h;
		this.ud20 = ud20;
		this.odhd40 = odhd40;
		this.udab20 = udab20;
		this.udhg20 = udhg20;
		this.podCd3 = podCd3;
		this.udab40 = udab40;
		this.udhg40 = udhg40;
		this.odhd20 = odhd20;
		this.odtb20 = odtb20;
		this.odet40 = odet40;
		this.odtb40h = odtb40h;
		this.odet20 = odet20;
		this.udbw20 = udbw20;
		this.pcod40 = pcod40;
		this.odhd40h = odhd40h;
		this.odts40 = odts40;
		this.odts20 = odts20;
		this.pcod20 = pcod20;
		this.udbw40 = udbw40;
		this.udav40h = udav40h;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("udav_40", getUdav40());
		this.hashColumns.put("udav_20", getUdav20());
		this.hashColumns.put("udbw_40h", getUdbw40h());
		this.hashColumns.put("pcod_40h", getPcod40h());
		this.hashColumns.put("udhg_40h", getUdhg40h());
		this.hashColumns.put("od_40", getOd40());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ud_40h", getUd40h());
		this.hashColumns.put("udts_40", getUdts40());
		this.hashColumns.put("udts_20", getUdts20());
		this.hashColumns.put("od_20", getOd20());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("odtb_40", getOdtb40());
		this.hashColumns.put("udts_40h", getUdts40h());
		this.hashColumns.put("odts_40h", getOdts40h());
		this.hashColumns.put("od_40h", getOd40h());
		this.hashColumns.put("udab_40h", getUdab40h());
		this.hashColumns.put("ud_40", getUd40());
		this.hashColumns.put("odet_40h", getOdet40h());
		this.hashColumns.put("ud_20", getUd20());
		this.hashColumns.put("odhd_40", getOdhd40());
		this.hashColumns.put("udab_20", getUdab20());
		this.hashColumns.put("udhg_20", getUdhg20());
		this.hashColumns.put("pod_cd3", getPodCd3());
		this.hashColumns.put("udab_40", getUdab40());
		this.hashColumns.put("udhg_40", getUdhg40());
		this.hashColumns.put("odhd_20", getOdhd20());
		this.hashColumns.put("odtb_20", getOdtb20());
		this.hashColumns.put("odet_40", getOdet40());
		this.hashColumns.put("odtb_40h", getOdtb40h());
		this.hashColumns.put("odet_20", getOdet20());
		this.hashColumns.put("udbw_20", getUdbw20());
		this.hashColumns.put("pcod_40", getPcod40());
		this.hashColumns.put("odhd_40h", getOdhd40h());
		this.hashColumns.put("odts_40", getOdts40());
		this.hashColumns.put("odts_20", getOdts20());
		this.hashColumns.put("pcod_20", getPcod20());
		this.hashColumns.put("udbw_40", getUdbw40());
		this.hashColumns.put("udav_40h", getUdav40h());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("udav_40", "udav40");
		this.hashFields.put("udav_20", "udav20");
		this.hashFields.put("udbw_40h", "udbw40h");
		this.hashFields.put("pcod_40h", "pcod40h");
		this.hashFields.put("udhg_40h", "udhg40h");
		this.hashFields.put("od_40", "od40");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ud_40h", "ud40h");
		this.hashFields.put("udts_40", "udts40");
		this.hashFields.put("udts_20", "udts20");
		this.hashFields.put("od_20", "od20");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("odtb_40", "odtb40");
		this.hashFields.put("udts_40h", "udts40h");
		this.hashFields.put("odts_40h", "odts40h");
		this.hashFields.put("od_40h", "od40h");
		this.hashFields.put("udab_40h", "udab40h");
		this.hashFields.put("ud_40", "ud40");
		this.hashFields.put("odet_40h", "odet40h");
		this.hashFields.put("ud_20", "ud20");
		this.hashFields.put("odhd_40", "odhd40");
		this.hashFields.put("udab_20", "udab20");
		this.hashFields.put("udhg_20", "udhg20");
		this.hashFields.put("pod_cd3", "podCd3");
		this.hashFields.put("udab_40", "udab40");
		this.hashFields.put("udhg_40", "udhg40");
		this.hashFields.put("odhd_20", "odhd20");
		this.hashFields.put("odtb_20", "odtb20");
		this.hashFields.put("odet_40", "odet40");
		this.hashFields.put("odtb_40h", "odtb40h");
		this.hashFields.put("odet_20", "odet20");
		this.hashFields.put("udbw_20", "udbw20");
		this.hashFields.put("pcod_40", "pcod40");
		this.hashFields.put("odhd_40h", "odhd40h");
		this.hashFields.put("odts_40", "odts40");
		this.hashFields.put("odts_20", "odts20");
		this.hashFields.put("pcod_20", "pcod20");
		this.hashFields.put("udbw_40", "udbw40");
		this.hashFields.put("udav_40h", "udav40h");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return udav40
	 */
	public String getUdav40() {
		return this.udav40;
	}
	
	/**
	 * Column Info
	 * @return udav20
	 */
	public String getUdav20() {
		return this.udav20;
	}
	
	/**
	 * Column Info
	 * @return udbw40h
	 */
	public String getUdbw40h() {
		return this.udbw40h;
	}
	
	/**
	 * Column Info
	 * @return pcod40h
	 */
	public String getPcod40h() {
		return this.pcod40h;
	}
	
	/**
	 * Column Info
	 * @return udhg40h
	 */
	public String getUdhg40h() {
		return this.udhg40h;
	}
	
	/**
	 * Column Info
	 * @return od40
	 */
	public String getOd40() {
		return this.od40;
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
	 * @return ud40h
	 */
	public String getUd40h() {
		return this.ud40h;
	}
	
	/**
	 * Column Info
	 * @return udts40
	 */
	public String getUdts40() {
		return this.udts40;
	}
	
	/**
	 * Column Info
	 * @return udts20
	 */
	public String getUdts20() {
		return this.udts20;
	}
	
	/**
	 * Column Info
	 * @return od20
	 */
	public String getOd20() {
		return this.od20;
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
	 * @return odtb40
	 */
	public String getOdtb40() {
		return this.odtb40;
	}
	
	/**
	 * Column Info
	 * @return udts40h
	 */
	public String getUdts40h() {
		return this.udts40h;
	}
	
	/**
	 * Column Info
	 * @return odts40h
	 */
	public String getOdts40h() {
		return this.odts40h;
	}
	
	/**
	 * Column Info
	 * @return od40h
	 */
	public String getOd40h() {
		return this.od40h;
	}
	
	/**
	 * Column Info
	 * @return udab40h
	 */
	public String getUdab40h() {
		return this.udab40h;
	}
	
	/**
	 * Column Info
	 * @return ud40
	 */
	public String getUd40() {
		return this.ud40;
	}
	
	/**
	 * Column Info
	 * @return odet40h
	 */
	public String getOdet40h() {
		return this.odet40h;
	}
	
	/**
	 * Column Info
	 * @return ud20
	 */
	public String getUd20() {
		return this.ud20;
	}
	
	/**
	 * Column Info
	 * @return odhd40
	 */
	public String getOdhd40() {
		return this.odhd40;
	}
	
	/**
	 * Column Info
	 * @return udab20
	 */
	public String getUdab20() {
		return this.udab20;
	}
	
	/**
	 * Column Info
	 * @return udhg20
	 */
	public String getUdhg20() {
		return this.udhg20;
	}
	
	/**
	 * Column Info
	 * @return podCd3
	 */
	public String getPodCd3() {
		return this.podCd3;
	}
	
	/**
	 * Column Info
	 * @return udab40
	 */
	public String getUdab40() {
		return this.udab40;
	}
	
	/**
	 * Column Info
	 * @return udhg40
	 */
	public String getUdhg40() {
		return this.udhg40;
	}
	
	/**
	 * Column Info
	 * @return odhd20
	 */
	public String getOdhd20() {
		return this.odhd20;
	}
	
	/**
	 * Column Info
	 * @return odtb20
	 */
	public String getOdtb20() {
		return this.odtb20;
	}
	
	/**
	 * Column Info
	 * @return odet40
	 */
	public String getOdet40() {
		return this.odet40;
	}
	
	/**
	 * Column Info
	 * @return odtb40h
	 */
	public String getOdtb40h() {
		return this.odtb40h;
	}
	
	/**
	 * Column Info
	 * @return odet20
	 */
	public String getOdet20() {
		return this.odet20;
	}
	
	/**
	 * Column Info
	 * @return udbw20
	 */
	public String getUdbw20() {
		return this.udbw20;
	}
	
	/**
	 * Column Info
	 * @return pcod40
	 */
	public String getPcod40() {
		return this.pcod40;
	}
	
	/**
	 * Column Info
	 * @return odhd40h
	 */
	public String getOdhd40h() {
		return this.odhd40h;
	}
	
	/**
	 * Column Info
	 * @return odts40
	 */
	public String getOdts40() {
		return this.odts40;
	}
	
	/**
	 * Column Info
	 * @return odts20
	 */
	public String getOdts20() {
		return this.odts20;
	}
	
	/**
	 * Column Info
	 * @return pcod20
	 */
	public String getPcod20() {
		return this.pcod20;
	}
	
	/**
	 * Column Info
	 * @return udbw40
	 */
	public String getUdbw40() {
		return this.udbw40;
	}
	
	/**
	 * Column Info
	 * @return udav40h
	 */
	public String getUdav40h() {
		return this.udav40h;
	}
	

	/**
	 * Column Info
	 * @param udav40
	 */
	public void setUdav40(String udav40) {
		this.udav40 = udav40;
	}
	
	/**
	 * Column Info
	 * @param udav20
	 */
	public void setUdav20(String udav20) {
		this.udav20 = udav20;
	}
	
	/**
	 * Column Info
	 * @param udbw40h
	 */
	public void setUdbw40h(String udbw40h) {
		this.udbw40h = udbw40h;
	}
	
	/**
	 * Column Info
	 * @param pcod40h
	 */
	public void setPcod40h(String pcod40h) {
		this.pcod40h = pcod40h;
	}
	
	/**
	 * Column Info
	 * @param udhg40h
	 */
	public void setUdhg40h(String udhg40h) {
		this.udhg40h = udhg40h;
	}
	
	/**
	 * Column Info
	 * @param od40
	 */
	public void setOd40(String od40) {
		this.od40 = od40;
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
	 * @param ud40h
	 */
	public void setUd40h(String ud40h) {
		this.ud40h = ud40h;
	}
	
	/**
	 * Column Info
	 * @param udts40
	 */
	public void setUdts40(String udts40) {
		this.udts40 = udts40;
	}
	
	/**
	 * Column Info
	 * @param udts20
	 */
	public void setUdts20(String udts20) {
		this.udts20 = udts20;
	}
	
	/**
	 * Column Info
	 * @param od20
	 */
	public void setOd20(String od20) {
		this.od20 = od20;
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
	 * @param odtb40
	 */
	public void setOdtb40(String odtb40) {
		this.odtb40 = odtb40;
	}
	
	/**
	 * Column Info
	 * @param udts40h
	 */
	public void setUdts40h(String udts40h) {
		this.udts40h = udts40h;
	}
	
	/**
	 * Column Info
	 * @param odts40h
	 */
	public void setOdts40h(String odts40h) {
		this.odts40h = odts40h;
	}
	
	/**
	 * Column Info
	 * @param od40h
	 */
	public void setOd40h(String od40h) {
		this.od40h = od40h;
	}
	
	/**
	 * Column Info
	 * @param udab40h
	 */
	public void setUdab40h(String udab40h) {
		this.udab40h = udab40h;
	}
	
	/**
	 * Column Info
	 * @param ud40
	 */
	public void setUd40(String ud40) {
		this.ud40 = ud40;
	}
	
	/**
	 * Column Info
	 * @param odet40h
	 */
	public void setOdet40h(String odet40h) {
		this.odet40h = odet40h;
	}
	
	/**
	 * Column Info
	 * @param ud20
	 */
	public void setUd20(String ud20) {
		this.ud20 = ud20;
	}
	
	/**
	 * Column Info
	 * @param odhd40
	 */
	public void setOdhd40(String odhd40) {
		this.odhd40 = odhd40;
	}
	
	/**
	 * Column Info
	 * @param udab20
	 */
	public void setUdab20(String udab20) {
		this.udab20 = udab20;
	}
	
	/**
	 * Column Info
	 * @param udhg20
	 */
	public void setUdhg20(String udhg20) {
		this.udhg20 = udhg20;
	}
	
	/**
	 * Column Info
	 * @param podCd3
	 */
	public void setPodCd3(String podCd3) {
		this.podCd3 = podCd3;
	}
	
	/**
	 * Column Info
	 * @param udab40
	 */
	public void setUdab40(String udab40) {
		this.udab40 = udab40;
	}
	
	/**
	 * Column Info
	 * @param udhg40
	 */
	public void setUdhg40(String udhg40) {
		this.udhg40 = udhg40;
	}
	
	/**
	 * Column Info
	 * @param odhd20
	 */
	public void setOdhd20(String odhd20) {
		this.odhd20 = odhd20;
	}
	
	/**
	 * Column Info
	 * @param odtb20
	 */
	public void setOdtb20(String odtb20) {
		this.odtb20 = odtb20;
	}
	
	/**
	 * Column Info
	 * @param odet40
	 */
	public void setOdet40(String odet40) {
		this.odet40 = odet40;
	}
	
	/**
	 * Column Info
	 * @param odtb40h
	 */
	public void setOdtb40h(String odtb40h) {
		this.odtb40h = odtb40h;
	}
	
	/**
	 * Column Info
	 * @param odet20
	 */
	public void setOdet20(String odet20) {
		this.odet20 = odet20;
	}
	
	/**
	 * Column Info
	 * @param udbw20
	 */
	public void setUdbw20(String udbw20) {
		this.udbw20 = udbw20;
	}
	
	/**
	 * Column Info
	 * @param pcod40
	 */
	public void setPcod40(String pcod40) {
		this.pcod40 = pcod40;
	}
	
	/**
	 * Column Info
	 * @param odhd40h
	 */
	public void setOdhd40h(String odhd40h) {
		this.odhd40h = odhd40h;
	}
	
	/**
	 * Column Info
	 * @param odts40
	 */
	public void setOdts40(String odts40) {
		this.odts40 = odts40;
	}
	
	/**
	 * Column Info
	 * @param odts20
	 */
	public void setOdts20(String odts20) {
		this.odts20 = odts20;
	}
	
	/**
	 * Column Info
	 * @param pcod20
	 */
	public void setPcod20(String pcod20) {
		this.pcod20 = pcod20;
	}
	
	/**
	 * Column Info
	 * @param udbw40
	 */
	public void setUdbw40(String udbw40) {
		this.udbw40 = udbw40;
	}
	
	/**
	 * Column Info
	 * @param udav40h
	 */
	public void setUdav40h(String udav40h) {
		this.udav40h = udav40h;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUdav40(JSPUtil.getParameter(request, "udav_40", ""));
		setUdav20(JSPUtil.getParameter(request, "udav_20", ""));
		setUdbw40h(JSPUtil.getParameter(request, "udbw_40h", ""));
		setPcod40h(JSPUtil.getParameter(request, "pcod_40h", ""));
		setUdhg40h(JSPUtil.getParameter(request, "udhg_40h", ""));
		setOd40(JSPUtil.getParameter(request, "od_40", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUd40h(JSPUtil.getParameter(request, "ud_40h", ""));
		setUdts40(JSPUtil.getParameter(request, "udts_40", ""));
		setUdts20(JSPUtil.getParameter(request, "udts_20", ""));
		setOd20(JSPUtil.getParameter(request, "od_20", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOdtb40(JSPUtil.getParameter(request, "odtb_40", ""));
		setUdts40h(JSPUtil.getParameter(request, "udts_40h", ""));
		setOdts40h(JSPUtil.getParameter(request, "odts_40h", ""));
		setOd40h(JSPUtil.getParameter(request, "od_40h", ""));
		setUdab40h(JSPUtil.getParameter(request, "udab_40h", ""));
		setUd40(JSPUtil.getParameter(request, "ud_40", ""));
		setOdet40h(JSPUtil.getParameter(request, "odet_40h", ""));
		setUd20(JSPUtil.getParameter(request, "ud_20", ""));
		setOdhd40(JSPUtil.getParameter(request, "odhd_40", ""));
		setUdab20(JSPUtil.getParameter(request, "udab_20", ""));
		setUdhg20(JSPUtil.getParameter(request, "udhg_20", ""));
		setPodCd3(JSPUtil.getParameter(request, "pod_cd3", ""));
		setUdab40(JSPUtil.getParameter(request, "udab_40", ""));
		setUdhg40(JSPUtil.getParameter(request, "udhg_40", ""));
		setOdhd20(JSPUtil.getParameter(request, "odhd_20", ""));
		setOdtb20(JSPUtil.getParameter(request, "odtb_20", ""));
		setOdet40(JSPUtil.getParameter(request, "odet_40", ""));
		setOdtb40h(JSPUtil.getParameter(request, "odtb_40h", ""));
		setOdet20(JSPUtil.getParameter(request, "odet_20", ""));
		setUdbw20(JSPUtil.getParameter(request, "udbw_20", ""));
		setPcod40(JSPUtil.getParameter(request, "pcod_40", ""));
		setOdhd40h(JSPUtil.getParameter(request, "odhd_40h", ""));
		setOdts40(JSPUtil.getParameter(request, "odts_40", ""));
		setOdts20(JSPUtil.getParameter(request, "odts_20", ""));
		setPcod20(JSPUtil.getParameter(request, "pcod_20", ""));
		setUdbw40(JSPUtil.getParameter(request, "udbw_40", ""));
		setUdav40h(JSPUtil.getParameter(request, "udav_40h", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CLLCDLManifestSpclStowRqstByPodDetailVO[]
	 */
	public CLLCDLManifestSpclStowRqstByPodDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CLLCDLManifestSpclStowRqstByPodDetailVO[]
	 */
	public CLLCDLManifestSpclStowRqstByPodDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CLLCDLManifestSpclStowRqstByPodDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] udav40 = (JSPUtil.getParameter(request, prefix	+ "udav_40", length));
			String[] udav20 = (JSPUtil.getParameter(request, prefix	+ "udav_20", length));
			String[] udbw40h = (JSPUtil.getParameter(request, prefix	+ "udbw_40h", length));
			String[] pcod40h = (JSPUtil.getParameter(request, prefix	+ "pcod_40h", length));
			String[] udhg40h = (JSPUtil.getParameter(request, prefix	+ "udhg_40h", length));
			String[] od40 = (JSPUtil.getParameter(request, prefix	+ "od_40", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ud40h = (JSPUtil.getParameter(request, prefix	+ "ud_40h", length));
			String[] udts40 = (JSPUtil.getParameter(request, prefix	+ "udts_40", length));
			String[] udts20 = (JSPUtil.getParameter(request, prefix	+ "udts_20", length));
			String[] od20 = (JSPUtil.getParameter(request, prefix	+ "od_20", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] odtb40 = (JSPUtil.getParameter(request, prefix	+ "odtb_40", length));
			String[] udts40h = (JSPUtil.getParameter(request, prefix	+ "udts_40h", length));
			String[] odts40h = (JSPUtil.getParameter(request, prefix	+ "odts_40h", length));
			String[] od40h = (JSPUtil.getParameter(request, prefix	+ "od_40h", length));
			String[] udab40h = (JSPUtil.getParameter(request, prefix	+ "udab_40h", length));
			String[] ud40 = (JSPUtil.getParameter(request, prefix	+ "ud_40", length));
			String[] odet40h = (JSPUtil.getParameter(request, prefix	+ "odet_40h", length));
			String[] ud20 = (JSPUtil.getParameter(request, prefix	+ "ud_20", length));
			String[] odhd40 = (JSPUtil.getParameter(request, prefix	+ "odhd_40", length));
			String[] udab20 = (JSPUtil.getParameter(request, prefix	+ "udab_20", length));
			String[] udhg20 = (JSPUtil.getParameter(request, prefix	+ "udhg_20", length));
			String[] podCd3 = (JSPUtil.getParameter(request, prefix	+ "pod_cd3", length));
			String[] udab40 = (JSPUtil.getParameter(request, prefix	+ "udab_40", length));
			String[] udhg40 = (JSPUtil.getParameter(request, prefix	+ "udhg_40", length));
			String[] odhd20 = (JSPUtil.getParameter(request, prefix	+ "odhd_20", length));
			String[] odtb20 = (JSPUtil.getParameter(request, prefix	+ "odtb_20", length));
			String[] odet40 = (JSPUtil.getParameter(request, prefix	+ "odet_40", length));
			String[] odtb40h = (JSPUtil.getParameter(request, prefix	+ "odtb_40h", length));
			String[] odet20 = (JSPUtil.getParameter(request, prefix	+ "odet_20", length));
			String[] udbw20 = (JSPUtil.getParameter(request, prefix	+ "udbw_20", length));
			String[] pcod40 = (JSPUtil.getParameter(request, prefix	+ "pcod_40", length));
			String[] odhd40h = (JSPUtil.getParameter(request, prefix	+ "odhd_40h", length));
			String[] odts40 = (JSPUtil.getParameter(request, prefix	+ "odts_40", length));
			String[] odts20 = (JSPUtil.getParameter(request, prefix	+ "odts_20", length));
			String[] pcod20 = (JSPUtil.getParameter(request, prefix	+ "pcod_20", length));
			String[] udbw40 = (JSPUtil.getParameter(request, prefix	+ "udbw_40", length));
			String[] udav40h = (JSPUtil.getParameter(request, prefix	+ "udav_40h", length));
			
			for (int i = 0; i < length; i++) {
				model = new CLLCDLManifestSpclStowRqstByPodDetailVO();
				if (udav40[i] != null)
					model.setUdav40(udav40[i]);
				if (udav20[i] != null)
					model.setUdav20(udav20[i]);
				if (udbw40h[i] != null)
					model.setUdbw40h(udbw40h[i]);
				if (pcod40h[i] != null)
					model.setPcod40h(pcod40h[i]);
				if (udhg40h[i] != null)
					model.setUdhg40h(udhg40h[i]);
				if (od40[i] != null)
					model.setOd40(od40[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ud40h[i] != null)
					model.setUd40h(ud40h[i]);
				if (udts40[i] != null)
					model.setUdts40(udts40[i]);
				if (udts20[i] != null)
					model.setUdts20(udts20[i]);
				if (od20[i] != null)
					model.setOd20(od20[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (odtb40[i] != null)
					model.setOdtb40(odtb40[i]);
				if (udts40h[i] != null)
					model.setUdts40h(udts40h[i]);
				if (odts40h[i] != null)
					model.setOdts40h(odts40h[i]);
				if (od40h[i] != null)
					model.setOd40h(od40h[i]);
				if (udab40h[i] != null)
					model.setUdab40h(udab40h[i]);
				if (ud40[i] != null)
					model.setUd40(ud40[i]);
				if (odet40h[i] != null)
					model.setOdet40h(odet40h[i]);
				if (ud20[i] != null)
					model.setUd20(ud20[i]);
				if (odhd40[i] != null)
					model.setOdhd40(odhd40[i]);
				if (udab20[i] != null)
					model.setUdab20(udab20[i]);
				if (udhg20[i] != null)
					model.setUdhg20(udhg20[i]);
				if (podCd3[i] != null)
					model.setPodCd3(podCd3[i]);
				if (udab40[i] != null)
					model.setUdab40(udab40[i]);
				if (udhg40[i] != null)
					model.setUdhg40(udhg40[i]);
				if (odhd20[i] != null)
					model.setOdhd20(odhd20[i]);
				if (odtb20[i] != null)
					model.setOdtb20(odtb20[i]);
				if (odet40[i] != null)
					model.setOdet40(odet40[i]);
				if (odtb40h[i] != null)
					model.setOdtb40h(odtb40h[i]);
				if (odet20[i] != null)
					model.setOdet20(odet20[i]);
				if (udbw20[i] != null)
					model.setUdbw20(udbw20[i]);
				if (pcod40[i] != null)
					model.setPcod40(pcod40[i]);
				if (odhd40h[i] != null)
					model.setOdhd40h(odhd40h[i]);
				if (odts40[i] != null)
					model.setOdts40(odts40[i]);
				if (odts20[i] != null)
					model.setOdts20(odts20[i]);
				if (pcod20[i] != null)
					model.setPcod20(pcod20[i]);
				if (udbw40[i] != null)
					model.setUdbw40(udbw40[i]);
				if (udav40h[i] != null)
					model.setUdav40h(udav40h[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCLLCDLManifestSpclStowRqstByPodDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CLLCDLManifestSpclStowRqstByPodDetailVO[]
	 */
	public CLLCDLManifestSpclStowRqstByPodDetailVO[] getCLLCDLManifestSpclStowRqstByPodDetailVOs(){
		CLLCDLManifestSpclStowRqstByPodDetailVO[] vos = (CLLCDLManifestSpclStowRqstByPodDetailVO[])models.toArray(new CLLCDLManifestSpclStowRqstByPodDetailVO[models.size()]);
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
		this.udav40 = this.udav40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udav20 = this.udav20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udbw40h = this.udbw40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcod40h = this.pcod40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udhg40h = this.udhg40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.od40 = this.od40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ud40h = this.ud40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udts40 = this.udts40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udts20 = this.udts20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.od20 = this.od20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odtb40 = this.odtb40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udts40h = this.udts40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odts40h = this.odts40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.od40h = this.od40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udab40h = this.udab40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ud40 = this.ud40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odet40h = this.odet40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ud20 = this.ud20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odhd40 = this.odhd40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udab20 = this.udab20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udhg20 = this.udhg20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd3 = this.podCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udab40 = this.udab40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udhg40 = this.udhg40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odhd20 = this.odhd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odtb20 = this.odtb20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odet40 = this.odet40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odtb40h = this.odtb40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odet20 = this.odet20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udbw20 = this.udbw20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcod40 = this.pcod40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odhd40h = this.odhd40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odts40 = this.odts40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odts20 = this.odts20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcod20 = this.pcod20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udbw40 = this.udbw40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udav40h = this.udav40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
