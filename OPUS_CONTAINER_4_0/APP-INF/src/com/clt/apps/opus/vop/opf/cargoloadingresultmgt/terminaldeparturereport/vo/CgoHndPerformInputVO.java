/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgoHndPerformInputVO.java
*@FileTitle : CgoHndPerformInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.08.06 김종옥 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CgoHndPerformInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CgoHndPerformInputVO> models = new ArrayList<CgoHndPerformInputVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String ldEt4h = null;
	/* Column Info */
	private String tlEt20 = null;
	/* Column Info */
	private String dsFl45 = null;
	/* Column Info */
	private String dsFl4h = null;
	/* Column Info */
	private String dsFl20 = null;
	/* Column Info */
	private String dsFl40 = null;
	/* Column Info */
	private String tlEt4h = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tlFl45 = null;
	/* Column Info */
	private String tlFl4h = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wt40 = null;
	/* Column Info */
	private String wt45 = null;
	/* Column Info */
	private String tlFl20 = null;
	/* Column Info */
	private String dsFl2h = null;
	/* Column Info */
	private String tlFl40 = null;
	/* Column Info */
	private String wt2h = null;
	/* Column Info */
	private String tlFl2h = null;
	/* Column Info */
	private String opr = null;
	/* Column Info */
	private String ldEt2h = null;
	/* Column Info */
	private String wt4h = null;
	/* Column Info */
	private String ldFl2h = null;
	/* Column Info */
	private String ldEt20 = null;
	/* Column Info */
	private String ldFl20 = null;
	/* Column Info */
	private String wt20 = null;
	/* Column Info */
	private String ldFl40 = null;
	/* Column Info */
	private String ldFl4h = null;
	/* Column Info */
	private String ldFl45 = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String dsEt40 = null;
	/* Column Info */
	private String tlEt2h = null;
	/* Column Info */
	private String ldEt45 = null;
	/* Column Info */
	private String dsEt45 = null;
	/* Column Info */
	private String tlEt40 = null;
	/* Column Info */
	private String dsEt20 = null;
	/* Column Info */
	private String dsEt4h = null;
	/* Column Info */
	private String tlEt45 = null;
	/* Column Info */
	private String dsEt2h = null;
	/* Column Info */
	private String ldEt40 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CgoHndPerformInputVO() {}

	public CgoHndPerformInputVO(String ibflag, String pagerows, String port, String lane, String vvd, String opr, String dsFl20, String dsFl2h, String dsFl40, String dsFl4h, String dsFl45, String dsEt20, String dsEt2h, String dsEt40, String dsEt4h, String dsEt45, String ldFl20, String ldFl2h, String ldFl40, String ldFl4h, String ldFl45, String ldEt20, String ldEt2h, String ldEt40, String ldEt4h, String ldEt45, String tlFl20, String tlFl2h, String tlFl40, String tlFl4h, String tlFl45, String tlEt20, String tlEt2h, String tlEt40, String tlEt4h, String tlEt45, String wt20, String wt2h, String wt40, String wt4h, String wt45) {
		this.port = port;
		this.ldEt4h = ldEt4h;
		this.tlEt20 = tlEt20;
		this.dsFl45 = dsFl45;
		this.dsFl4h = dsFl4h;
		this.dsFl20 = dsFl20;
		this.dsFl40 = dsFl40;
		this.tlEt4h = tlEt4h;
		this.lane = lane;
		this.pagerows = pagerows;
		this.tlFl45 = tlFl45;
		this.tlFl4h = tlFl4h;
		this.ibflag = ibflag;
		this.wt40 = wt40;
		this.wt45 = wt45;
		this.tlFl20 = tlFl20;
		this.dsFl2h = dsFl2h;
		this.tlFl40 = tlFl40;
		this.wt2h = wt2h;
		this.tlFl2h = tlFl2h;
		this.opr = opr;
		this.ldEt2h = ldEt2h;
		this.wt4h = wt4h;
		this.ldFl2h = ldFl2h;
		this.ldEt20 = ldEt20;
		this.ldFl20 = ldFl20;
		this.wt20 = wt20;
		this.ldFl40 = ldFl40;
		this.ldFl4h = ldFl4h;
		this.ldFl45 = ldFl45;
		this.vvd = vvd;
		this.dsEt40 = dsEt40;
		this.tlEt2h = tlEt2h;
		this.ldEt45 = ldEt45;
		this.dsEt45 = dsEt45;
		this.tlEt40 = tlEt40;
		this.dsEt20 = dsEt20;
		this.dsEt4h = dsEt4h;
		this.tlEt45 = tlEt45;
		this.dsEt2h = dsEt2h;
		this.ldEt40 = ldEt40;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("ld_et_4h", getLdEt4h());
		this.hashColumns.put("tl_et_20", getTlEt20());
		this.hashColumns.put("ds_fl_45", getDsFl45());
		this.hashColumns.put("ds_fl_4h", getDsFl4h());
		this.hashColumns.put("ds_fl_20", getDsFl20());
		this.hashColumns.put("ds_fl_40", getDsFl40());
		this.hashColumns.put("tl_et_4h", getTlEt4h());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tl_fl_45", getTlFl45());
		this.hashColumns.put("tl_fl_4h", getTlFl4h());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wt_40", getWt40());
		this.hashColumns.put("wt_45", getWt45());
		this.hashColumns.put("tl_fl_20", getTlFl20());
		this.hashColumns.put("ds_fl_2h", getDsFl2h());
		this.hashColumns.put("tl_fl_40", getTlFl40());
		this.hashColumns.put("wt_2h", getWt2h());
		this.hashColumns.put("tl_fl_2h", getTlFl2h());
		this.hashColumns.put("opr", getOpr());
		this.hashColumns.put("ld_et_2h", getLdEt2h());
		this.hashColumns.put("wt_4h", getWt4h());
		this.hashColumns.put("ld_fl_2h", getLdFl2h());
		this.hashColumns.put("ld_et_20", getLdEt20());
		this.hashColumns.put("ld_fl_20", getLdFl20());
		this.hashColumns.put("wt_20", getWt20());
		this.hashColumns.put("ld_fl_40", getLdFl40());
		this.hashColumns.put("ld_fl_4h", getLdFl4h());
		this.hashColumns.put("ld_fl_45", getLdFl45());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ds_et_40", getDsEt40());
		this.hashColumns.put("tl_et_2h", getTlEt2h());
		this.hashColumns.put("ld_et_45", getLdEt45());
		this.hashColumns.put("ds_et_45", getDsEt45());
		this.hashColumns.put("tl_et_40", getTlEt40());
		this.hashColumns.put("ds_et_20", getDsEt20());
		this.hashColumns.put("ds_et_4h", getDsEt4h());
		this.hashColumns.put("tl_et_45", getTlEt45());
		this.hashColumns.put("ds_et_2h", getDsEt2h());
		this.hashColumns.put("ld_et_40", getLdEt40());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("ld_et_4h", "ldEt4h");
		this.hashFields.put("tl_et_20", "tlEt20");
		this.hashFields.put("ds_fl_45", "dsFl45");
		this.hashFields.put("ds_fl_4h", "dsFl4h");
		this.hashFields.put("ds_fl_20", "dsFl20");
		this.hashFields.put("ds_fl_40", "dsFl40");
		this.hashFields.put("tl_et_4h", "tlEt4h");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tl_fl_45", "tlFl45");
		this.hashFields.put("tl_fl_4h", "tlFl4h");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wt_40", "wt40");
		this.hashFields.put("wt_45", "wt45");
		this.hashFields.put("tl_fl_20", "tlFl20");
		this.hashFields.put("ds_fl_2h", "dsFl2h");
		this.hashFields.put("tl_fl_40", "tlFl40");
		this.hashFields.put("wt_2h", "wt2h");
		this.hashFields.put("tl_fl_2h", "tlFl2h");
		this.hashFields.put("opr", "opr");
		this.hashFields.put("ld_et_2h", "ldEt2h");
		this.hashFields.put("wt_4h", "wt4h");
		this.hashFields.put("ld_fl_2h", "ldFl2h");
		this.hashFields.put("ld_et_20", "ldEt20");
		this.hashFields.put("ld_fl_20", "ldFl20");
		this.hashFields.put("wt_20", "wt20");
		this.hashFields.put("ld_fl_40", "ldFl40");
		this.hashFields.put("ld_fl_4h", "ldFl4h");
		this.hashFields.put("ld_fl_45", "ldFl45");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ds_et_40", "dsEt40");
		this.hashFields.put("tl_et_2h", "tlEt2h");
		this.hashFields.put("ld_et_45", "ldEt45");
		this.hashFields.put("ds_et_45", "dsEt45");
		this.hashFields.put("tl_et_40", "tlEt40");
		this.hashFields.put("ds_et_20", "dsEt20");
		this.hashFields.put("ds_et_4h", "dsEt4h");
		this.hashFields.put("tl_et_45", "tlEt45");
		this.hashFields.put("ds_et_2h", "dsEt2h");
		this.hashFields.put("ld_et_40", "ldEt40");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return ldEt4h
	 */
	public String getLdEt4h() {
		return this.ldEt4h;
	}
	
	/**
	 * Column Info
	 * @return tlEt20
	 */
	public String getTlEt20() {
		return this.tlEt20;
	}
	
	/**
	 * Column Info
	 * @return dsFl45
	 */
	public String getDsFl45() {
		return this.dsFl45;
	}
	
	/**
	 * Column Info
	 * @return dsFl4h
	 */
	public String getDsFl4h() {
		return this.dsFl4h;
	}
	
	/**
	 * Column Info
	 * @return dsFl20
	 */
	public String getDsFl20() {
		return this.dsFl20;
	}
	
	/**
	 * Column Info
	 * @return dsFl40
	 */
	public String getDsFl40() {
		return this.dsFl40;
	}
	
	/**
	 * Column Info
	 * @return tlEt4h
	 */
	public String getTlEt4h() {
		return this.tlEt4h;
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
	 * @return tlFl45
	 */
	public String getTlFl45() {
		return this.tlFl45;
	}
	
	/**
	 * Column Info
	 * @return tlFl4h
	 */
	public String getTlFl4h() {
		return this.tlFl4h;
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
	 * @return wt40
	 */
	public String getWt40() {
		return this.wt40;
	}
	
	/**
	 * Column Info
	 * @return wt45
	 */
	public String getWt45() {
		return this.wt45;
	}
	
	/**
	 * Column Info
	 * @return tlFl20
	 */
	public String getTlFl20() {
		return this.tlFl20;
	}
	
	/**
	 * Column Info
	 * @return dsFl2h
	 */
	public String getDsFl2h() {
		return this.dsFl2h;
	}
	
	/**
	 * Column Info
	 * @return tlFl40
	 */
	public String getTlFl40() {
		return this.tlFl40;
	}
	
	/**
	 * Column Info
	 * @return wt2h
	 */
	public String getWt2h() {
		return this.wt2h;
	}
	
	/**
	 * Column Info
	 * @return tlFl2h
	 */
	public String getTlFl2h() {
		return this.tlFl2h;
	}
	
	/**
	 * Column Info
	 * @return opr
	 */
	public String getOpr() {
		return this.opr;
	}
	
	/**
	 * Column Info
	 * @return ldEt2h
	 */
	public String getLdEt2h() {
		return this.ldEt2h;
	}
	
	/**
	 * Column Info
	 * @return wt4h
	 */
	public String getWt4h() {
		return this.wt4h;
	}
	
	/**
	 * Column Info
	 * @return ldFl2h
	 */
	public String getLdFl2h() {
		return this.ldFl2h;
	}
	
	/**
	 * Column Info
	 * @return ldEt20
	 */
	public String getLdEt20() {
		return this.ldEt20;
	}
	
	/**
	 * Column Info
	 * @return ldFl20
	 */
	public String getLdFl20() {
		return this.ldFl20;
	}
	
	/**
	 * Column Info
	 * @return wt20
	 */
	public String getWt20() {
		return this.wt20;
	}
	
	/**
	 * Column Info
	 * @return ldFl40
	 */
	public String getLdFl40() {
		return this.ldFl40;
	}
	
	/**
	 * Column Info
	 * @return ldFl4h
	 */
	public String getLdFl4h() {
		return this.ldFl4h;
	}
	
	/**
	 * Column Info
	 * @return ldFl45
	 */
	public String getLdFl45() {
		return this.ldFl45;
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
	 * @return dsEt40
	 */
	public String getDsEt40() {
		return this.dsEt40;
	}
	
	/**
	 * Column Info
	 * @return tlEt2h
	 */
	public String getTlEt2h() {
		return this.tlEt2h;
	}
	
	/**
	 * Column Info
	 * @return ldEt45
	 */
	public String getLdEt45() {
		return this.ldEt45;
	}
	
	/**
	 * Column Info
	 * @return dsEt45
	 */
	public String getDsEt45() {
		return this.dsEt45;
	}
	
	/**
	 * Column Info
	 * @return tlEt40
	 */
	public String getTlEt40() {
		return this.tlEt40;
	}
	
	/**
	 * Column Info
	 * @return dsEt20
	 */
	public String getDsEt20() {
		return this.dsEt20;
	}
	
	/**
	 * Column Info
	 * @return dsEt4h
	 */
	public String getDsEt4h() {
		return this.dsEt4h;
	}
	
	/**
	 * Column Info
	 * @return tlEt45
	 */
	public String getTlEt45() {
		return this.tlEt45;
	}
	
	/**
	 * Column Info
	 * @return dsEt2h
	 */
	public String getDsEt2h() {
		return this.dsEt2h;
	}
	
	/**
	 * Column Info
	 * @return ldEt40
	 */
	public String getLdEt40() {
		return this.ldEt40;
	}
	

	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param ldEt4h
	 */
	public void setLdEt4h(String ldEt4h) {
		this.ldEt4h = ldEt4h;
	}
	
	/**
	 * Column Info
	 * @param tlEt20
	 */
	public void setTlEt20(String tlEt20) {
		this.tlEt20 = tlEt20;
	}
	
	/**
	 * Column Info
	 * @param dsFl45
	 */
	public void setDsFl45(String dsFl45) {
		this.dsFl45 = dsFl45;
	}
	
	/**
	 * Column Info
	 * @param dsFl4h
	 */
	public void setDsFl4h(String dsFl4h) {
		this.dsFl4h = dsFl4h;
	}
	
	/**
	 * Column Info
	 * @param dsFl20
	 */
	public void setDsFl20(String dsFl20) {
		this.dsFl20 = dsFl20;
	}
	
	/**
	 * Column Info
	 * @param dsFl40
	 */
	public void setDsFl40(String dsFl40) {
		this.dsFl40 = dsFl40;
	}
	
	/**
	 * Column Info
	 * @param tlEt4h
	 */
	public void setTlEt4h(String tlEt4h) {
		this.tlEt4h = tlEt4h;
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
	 * @param tlFl45
	 */
	public void setTlFl45(String tlFl45) {
		this.tlFl45 = tlFl45;
	}
	
	/**
	 * Column Info
	 * @param tlFl4h
	 */
	public void setTlFl4h(String tlFl4h) {
		this.tlFl4h = tlFl4h;
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
	 * @param wt40
	 */
	public void setWt40(String wt40) {
		this.wt40 = wt40;
	}
	
	/**
	 * Column Info
	 * @param wt45
	 */
	public void setWt45(String wt45) {
		this.wt45 = wt45;
	}
	
	/**
	 * Column Info
	 * @param tlFl20
	 */
	public void setTlFl20(String tlFl20) {
		this.tlFl20 = tlFl20;
	}
	
	/**
	 * Column Info
	 * @param dsFl2h
	 */
	public void setDsFl2h(String dsFl2h) {
		this.dsFl2h = dsFl2h;
	}
	
	/**
	 * Column Info
	 * @param tlFl40
	 */
	public void setTlFl40(String tlFl40) {
		this.tlFl40 = tlFl40;
	}
	
	/**
	 * Column Info
	 * @param wt2h
	 */
	public void setWt2h(String wt2h) {
		this.wt2h = wt2h;
	}
	
	/**
	 * Column Info
	 * @param tlFl2h
	 */
	public void setTlFl2h(String tlFl2h) {
		this.tlFl2h = tlFl2h;
	}
	
	/**
	 * Column Info
	 * @param opr
	 */
	public void setOpr(String opr) {
		this.opr = opr;
	}
	
	/**
	 * Column Info
	 * @param ldEt2h
	 */
	public void setLdEt2h(String ldEt2h) {
		this.ldEt2h = ldEt2h;
	}
	
	/**
	 * Column Info
	 * @param wt4h
	 */
	public void setWt4h(String wt4h) {
		this.wt4h = wt4h;
	}
	
	/**
	 * Column Info
	 * @param ldFl2h
	 */
	public void setLdFl2h(String ldFl2h) {
		this.ldFl2h = ldFl2h;
	}
	
	/**
	 * Column Info
	 * @param ldEt20
	 */
	public void setLdEt20(String ldEt20) {
		this.ldEt20 = ldEt20;
	}
	
	/**
	 * Column Info
	 * @param ldFl20
	 */
	public void setLdFl20(String ldFl20) {
		this.ldFl20 = ldFl20;
	}
	
	/**
	 * Column Info
	 * @param wt20
	 */
	public void setWt20(String wt20) {
		this.wt20 = wt20;
	}
	
	/**
	 * Column Info
	 * @param ldFl40
	 */
	public void setLdFl40(String ldFl40) {
		this.ldFl40 = ldFl40;
	}
	
	/**
	 * Column Info
	 * @param ldFl4h
	 */
	public void setLdFl4h(String ldFl4h) {
		this.ldFl4h = ldFl4h;
	}
	
	/**
	 * Column Info
	 * @param ldFl45
	 */
	public void setLdFl45(String ldFl45) {
		this.ldFl45 = ldFl45;
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
	 * @param dsEt40
	 */
	public void setDsEt40(String dsEt40) {
		this.dsEt40 = dsEt40;
	}
	
	/**
	 * Column Info
	 * @param tlEt2h
	 */
	public void setTlEt2h(String tlEt2h) {
		this.tlEt2h = tlEt2h;
	}
	
	/**
	 * Column Info
	 * @param ldEt45
	 */
	public void setLdEt45(String ldEt45) {
		this.ldEt45 = ldEt45;
	}
	
	/**
	 * Column Info
	 * @param dsEt45
	 */
	public void setDsEt45(String dsEt45) {
		this.dsEt45 = dsEt45;
	}
	
	/**
	 * Column Info
	 * @param tlEt40
	 */
	public void setTlEt40(String tlEt40) {
		this.tlEt40 = tlEt40;
	}
	
	/**
	 * Column Info
	 * @param dsEt20
	 */
	public void setDsEt20(String dsEt20) {
		this.dsEt20 = dsEt20;
	}
	
	/**
	 * Column Info
	 * @param dsEt4h
	 */
	public void setDsEt4h(String dsEt4h) {
		this.dsEt4h = dsEt4h;
	}
	
	/**
	 * Column Info
	 * @param tlEt45
	 */
	public void setTlEt45(String tlEt45) {
		this.tlEt45 = tlEt45;
	}
	
	/**
	 * Column Info
	 * @param dsEt2h
	 */
	public void setDsEt2h(String dsEt2h) {
		this.dsEt2h = dsEt2h;
	}
	
	/**
	 * Column Info
	 * @param ldEt40
	 */
	public void setLdEt40(String ldEt40) {
		this.ldEt40 = ldEt40;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPort(JSPUtil.getParameter(request, "port", ""));
		setLdEt4h(JSPUtil.getParameter(request, "ld_et_4h", ""));
		setTlEt20(JSPUtil.getParameter(request, "tl_et_20", ""));
		setDsFl45(JSPUtil.getParameter(request, "ds_fl_45", ""));
		setDsFl4h(JSPUtil.getParameter(request, "ds_fl_4h", ""));
		setDsFl20(JSPUtil.getParameter(request, "ds_fl_20", ""));
		setDsFl40(JSPUtil.getParameter(request, "ds_fl_40", ""));
		setTlEt4h(JSPUtil.getParameter(request, "tl_et_4h", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTlFl45(JSPUtil.getParameter(request, "tl_fl_45", ""));
		setTlFl4h(JSPUtil.getParameter(request, "tl_fl_4h", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWt40(JSPUtil.getParameter(request, "wt_40", ""));
		setWt45(JSPUtil.getParameter(request, "wt_45", ""));
		setTlFl20(JSPUtil.getParameter(request, "tl_fl_20", ""));
		setDsFl2h(JSPUtil.getParameter(request, "ds_fl_2h", ""));
		setTlFl40(JSPUtil.getParameter(request, "tl_fl_40", ""));
		setWt2h(JSPUtil.getParameter(request, "wt_2h", ""));
		setTlFl2h(JSPUtil.getParameter(request, "tl_fl_2h", ""));
		setOpr(JSPUtil.getParameter(request, "opr", ""));
		setLdEt2h(JSPUtil.getParameter(request, "ld_et_2h", ""));
		setWt4h(JSPUtil.getParameter(request, "wt_4h", ""));
		setLdFl2h(JSPUtil.getParameter(request, "ld_fl_2h", ""));
		setLdEt20(JSPUtil.getParameter(request, "ld_et_20", ""));
		setLdFl20(JSPUtil.getParameter(request, "ld_fl_20", ""));
		setWt20(JSPUtil.getParameter(request, "wt_20", ""));
		setLdFl40(JSPUtil.getParameter(request, "ld_fl_40", ""));
		setLdFl4h(JSPUtil.getParameter(request, "ld_fl_4h", ""));
		setLdFl45(JSPUtil.getParameter(request, "ld_fl_45", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setDsEt40(JSPUtil.getParameter(request, "ds_et_40", ""));
		setTlEt2h(JSPUtil.getParameter(request, "tl_et_2h", ""));
		setLdEt45(JSPUtil.getParameter(request, "ld_et_45", ""));
		setDsEt45(JSPUtil.getParameter(request, "ds_et_45", ""));
		setTlEt40(JSPUtil.getParameter(request, "tl_et_40", ""));
		setDsEt20(JSPUtil.getParameter(request, "ds_et_20", ""));
		setDsEt4h(JSPUtil.getParameter(request, "ds_et_4h", ""));
		setTlEt45(JSPUtil.getParameter(request, "tl_et_45", ""));
		setDsEt2h(JSPUtil.getParameter(request, "ds_et_2h", ""));
		setLdEt40(JSPUtil.getParameter(request, "ld_et_40", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CgoHndPerformInputVO[]
	 */
	public CgoHndPerformInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CgoHndPerformInputVO[]
	 */
	public CgoHndPerformInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CgoHndPerformInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] ldEt4h = (JSPUtil.getParameter(request, prefix	+ "ld_et_4h", length));
			String[] tlEt20 = (JSPUtil.getParameter(request, prefix	+ "tl_et_20", length));
			String[] dsFl45 = (JSPUtil.getParameter(request, prefix	+ "ds_fl_45", length));
			String[] dsFl4h = (JSPUtil.getParameter(request, prefix	+ "ds_fl_4h", length));
			String[] dsFl20 = (JSPUtil.getParameter(request, prefix	+ "ds_fl_20", length));
			String[] dsFl40 = (JSPUtil.getParameter(request, prefix	+ "ds_fl_40", length));
			String[] tlEt4h = (JSPUtil.getParameter(request, prefix	+ "tl_et_4h", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tlFl45 = (JSPUtil.getParameter(request, prefix	+ "tl_fl_45", length));
			String[] tlFl4h = (JSPUtil.getParameter(request, prefix	+ "tl_fl_4h", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wt40 = (JSPUtil.getParameter(request, prefix	+ "wt_40", length));
			String[] wt45 = (JSPUtil.getParameter(request, prefix	+ "wt_45", length));
			String[] tlFl20 = (JSPUtil.getParameter(request, prefix	+ "tl_fl_20", length));
			String[] dsFl2h = (JSPUtil.getParameter(request, prefix	+ "ds_fl_2h", length));
			String[] tlFl40 = (JSPUtil.getParameter(request, prefix	+ "tl_fl_40", length));
			String[] wt2h = (JSPUtil.getParameter(request, prefix	+ "wt_2h", length));
			String[] tlFl2h = (JSPUtil.getParameter(request, prefix	+ "tl_fl_2h", length));
			String[] opr = (JSPUtil.getParameter(request, prefix	+ "opr", length));
			String[] ldEt2h = (JSPUtil.getParameter(request, prefix	+ "ld_et_2h", length));
			String[] wt4h = (JSPUtil.getParameter(request, prefix	+ "wt_4h", length));
			String[] ldFl2h = (JSPUtil.getParameter(request, prefix	+ "ld_fl_2h", length));
			String[] ldEt20 = (JSPUtil.getParameter(request, prefix	+ "ld_et_20", length));
			String[] ldFl20 = (JSPUtil.getParameter(request, prefix	+ "ld_fl_20", length));
			String[] wt20 = (JSPUtil.getParameter(request, prefix	+ "wt_20", length));
			String[] ldFl40 = (JSPUtil.getParameter(request, prefix	+ "ld_fl_40", length));
			String[] ldFl4h = (JSPUtil.getParameter(request, prefix	+ "ld_fl_4h", length));
			String[] ldFl45 = (JSPUtil.getParameter(request, prefix	+ "ld_fl_45", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] dsEt40 = (JSPUtil.getParameter(request, prefix	+ "ds_et_40", length));
			String[] tlEt2h = (JSPUtil.getParameter(request, prefix	+ "tl_et_2h", length));
			String[] ldEt45 = (JSPUtil.getParameter(request, prefix	+ "ld_et_45", length));
			String[] dsEt45 = (JSPUtil.getParameter(request, prefix	+ "ds_et_45", length));
			String[] tlEt40 = (JSPUtil.getParameter(request, prefix	+ "tl_et_40", length));
			String[] dsEt20 = (JSPUtil.getParameter(request, prefix	+ "ds_et_20", length));
			String[] dsEt4h = (JSPUtil.getParameter(request, prefix	+ "ds_et_4h", length));
			String[] tlEt45 = (JSPUtil.getParameter(request, prefix	+ "tl_et_45", length));
			String[] dsEt2h = (JSPUtil.getParameter(request, prefix	+ "ds_et_2h", length));
			String[] ldEt40 = (JSPUtil.getParameter(request, prefix	+ "ld_et_40", length));
			
			for (int i = 0; i < length; i++) {
				model = new CgoHndPerformInputVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (ldEt4h[i] != null)
					model.setLdEt4h(ldEt4h[i]);
				if (tlEt20[i] != null)
					model.setTlEt20(tlEt20[i]);
				if (dsFl45[i] != null)
					model.setDsFl45(dsFl45[i]);
				if (dsFl4h[i] != null)
					model.setDsFl4h(dsFl4h[i]);
				if (dsFl20[i] != null)
					model.setDsFl20(dsFl20[i]);
				if (dsFl40[i] != null)
					model.setDsFl40(dsFl40[i]);
				if (tlEt4h[i] != null)
					model.setTlEt4h(tlEt4h[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tlFl45[i] != null)
					model.setTlFl45(tlFl45[i]);
				if (tlFl4h[i] != null)
					model.setTlFl4h(tlFl4h[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wt40[i] != null)
					model.setWt40(wt40[i]);
				if (wt45[i] != null)
					model.setWt45(wt45[i]);
				if (tlFl20[i] != null)
					model.setTlFl20(tlFl20[i]);
				if (dsFl2h[i] != null)
					model.setDsFl2h(dsFl2h[i]);
				if (tlFl40[i] != null)
					model.setTlFl40(tlFl40[i]);
				if (wt2h[i] != null)
					model.setWt2h(wt2h[i]);
				if (tlFl2h[i] != null)
					model.setTlFl2h(tlFl2h[i]);
				if (opr[i] != null)
					model.setOpr(opr[i]);
				if (ldEt2h[i] != null)
					model.setLdEt2h(ldEt2h[i]);
				if (wt4h[i] != null)
					model.setWt4h(wt4h[i]);
				if (ldFl2h[i] != null)
					model.setLdFl2h(ldFl2h[i]);
				if (ldEt20[i] != null)
					model.setLdEt20(ldEt20[i]);
				if (ldFl20[i] != null)
					model.setLdFl20(ldFl20[i]);
				if (wt20[i] != null)
					model.setWt20(wt20[i]);
				if (ldFl40[i] != null)
					model.setLdFl40(ldFl40[i]);
				if (ldFl4h[i] != null)
					model.setLdFl4h(ldFl4h[i]);
				if (ldFl45[i] != null)
					model.setLdFl45(ldFl45[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (dsEt40[i] != null)
					model.setDsEt40(dsEt40[i]);
				if (tlEt2h[i] != null)
					model.setTlEt2h(tlEt2h[i]);
				if (ldEt45[i] != null)
					model.setLdEt45(ldEt45[i]);
				if (dsEt45[i] != null)
					model.setDsEt45(dsEt45[i]);
				if (tlEt40[i] != null)
					model.setTlEt40(tlEt40[i]);
				if (dsEt20[i] != null)
					model.setDsEt20(dsEt20[i]);
				if (dsEt4h[i] != null)
					model.setDsEt4h(dsEt4h[i]);
				if (tlEt45[i] != null)
					model.setTlEt45(tlEt45[i]);
				if (dsEt2h[i] != null)
					model.setDsEt2h(dsEt2h[i]);
				if (ldEt40[i] != null)
					model.setLdEt40(ldEt40[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCgoHndPerformInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CgoHndPerformInputVO[]
	 */
	public CgoHndPerformInputVO[] getCgoHndPerformInputVOs(){
		CgoHndPerformInputVO[] vos = (CgoHndPerformInputVO[])models.toArray(new CgoHndPerformInputVO[models.size()]);
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
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldEt4h = this.ldEt4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlEt20 = this.tlEt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsFl45 = this.dsFl45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsFl4h = this.dsFl4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsFl20 = this.dsFl20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsFl40 = this.dsFl40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlEt4h = this.tlEt4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlFl45 = this.tlFl45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlFl4h = this.tlFl4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wt40 = this.wt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wt45 = this.wt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlFl20 = this.tlFl20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsFl2h = this.dsFl2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlFl40 = this.tlFl40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wt2h = this.wt2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlFl2h = this.tlFl2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr = this.opr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldEt2h = this.ldEt2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wt4h = this.wt4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldFl2h = this.ldFl2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldEt20 = this.ldEt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldFl20 = this.ldFl20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wt20 = this.wt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldFl40 = this.ldFl40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldFl4h = this.ldFl4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldFl45 = this.ldFl45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsEt40 = this.dsEt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlEt2h = this.tlEt2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldEt45 = this.ldEt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsEt45 = this.dsEt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlEt40 = this.tlEt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsEt20 = this.dsEt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsEt4h = this.dsEt4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlEt45 = this.tlEt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsEt2h = this.dsEt2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldEt40 = this.ldEt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
