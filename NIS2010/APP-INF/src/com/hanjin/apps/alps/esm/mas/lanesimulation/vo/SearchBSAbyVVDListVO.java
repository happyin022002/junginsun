/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBSAbyVVDListVO.java
*@FileTitle : SearchBSAbyVVDListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.09.03 윤진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.lanesimulation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBSAbyVVDListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBSAbyVVDListVO> models = new ArrayList<SearchBSAbyVVDListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bsa00305 = null;
	/* Column Info */
	private String bsa00304 = null;
	/* Column Info */
	private String bsa00303 = null;
	/* Column Info */
	private String bsa00201 = null;
	/* Column Info */
	private String bsa00302 = null;
	/* Column Info */
	private String bsa00301 = null;
	/* Column Info */
	private String amt00302 = null;
	/* Column Info */
	private String bsa00204 = null;
	/* Column Info */
	private String amt00301 = null;
	/* Column Info */
	private String bsa00205 = null;
	/* Column Info */
	private String amt00304 = null;
	/* Column Info */
	private String bsa00202 = null;
	/* Column Info */
	private String amt00303 = null;
	/* Column Info */
	private String bsa00203 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String amt00305 = null;
	/* Column Info */
	private String bsa00105 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bsa00103 = null;
	/* Column Info */
	private String bsa00104 = null;
	/* Column Info */
	private String bsa00101 = null;
	/* Column Info */
	private String bsa00102 = null;
	/* Column Info */
	private String portClssCapa = null;
	/* Column Info */
	private String chkFlag = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String amt00102 = null;
	/* Column Info */
	private String amt00101 = null;
	/* Column Info */
	private String amt00104 = null;
	/* Column Info */
	private String amt00103 = null;
	/* Column Info */
	private String amt00105 = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String vslCapa = null;
	/* Column Info */
	private String amt00204 = null;
	/* Column Info */
	private String bsaCapa = null;
	/* Column Info */
	private String amt00205 = null;
	/* Column Info */
	private String amt00202 = null;
	/* Column Info */
	private String amt00203 = null;
	/* Column Info */
	private String amt00201 = null;
	/* Column Info */
	private String vslOshpCd = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String fnlHjsBsaCapa = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBSAbyVVDListVO() {}

	public SearchBSAbyVVDListVO(String ibflag, String pagerows, String vslCd, String chkFlag, String dirCd, String vslOshpCd, String vopCd, String vslCapa, String bsaCapa, String vslClssCapa, String portClssCapa, String fnlHjsBsaCapa, String bsa00101, String amt00101, String bsa00102, String amt00102, String bsa00103, String amt00103, String bsa00104, String amt00104, String bsa00105, String amt00105, String bsa00201, String amt00201, String bsa00202, String amt00202, String bsa00203, String amt00203, String bsa00204, String amt00204, String bsa00205, String amt00205, String bsa00301, String amt00301, String bsa00302, String amt00302, String bsa00303, String amt00303, String bsa00304, String amt00304, String bsa00305, String amt00305) {
		this.vslCd = vslCd;
		this.bsa00305 = bsa00305;
		this.bsa00304 = bsa00304;
		this.bsa00303 = bsa00303;
		this.bsa00201 = bsa00201;
		this.bsa00302 = bsa00302;
		this.bsa00301 = bsa00301;
		this.amt00302 = amt00302;
		this.bsa00204 = bsa00204;
		this.amt00301 = amt00301;
		this.bsa00205 = bsa00205;
		this.amt00304 = amt00304;
		this.bsa00202 = bsa00202;
		this.amt00303 = amt00303;
		this.bsa00203 = bsa00203;
		this.pagerows = pagerows;
		this.amt00305 = amt00305;
		this.bsa00105 = bsa00105;
		this.ibflag = ibflag;
		this.bsa00103 = bsa00103;
		this.bsa00104 = bsa00104;
		this.bsa00101 = bsa00101;
		this.bsa00102 = bsa00102;
		this.portClssCapa = portClssCapa;
		this.chkFlag = chkFlag;
		this.dirCd = dirCd;
		this.amt00102 = amt00102;
		this.amt00101 = amt00101;
		this.amt00104 = amt00104;
		this.amt00103 = amt00103;
		this.amt00105 = amt00105;
		this.vopCd = vopCd;
		this.vslCapa = vslCapa;
		this.amt00204 = amt00204;
		this.bsaCapa = bsaCapa;
		this.amt00205 = amt00205;
		this.amt00202 = amt00202;
		this.amt00203 = amt00203;
		this.amt00201 = amt00201;
		this.vslOshpCd = vslOshpCd;
		this.vslClssCapa = vslClssCapa;
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bsa00305", getBsa00305());
		this.hashColumns.put("bsa00304", getBsa00304());
		this.hashColumns.put("bsa00303", getBsa00303());
		this.hashColumns.put("bsa00201", getBsa00201());
		this.hashColumns.put("bsa00302", getBsa00302());
		this.hashColumns.put("bsa00301", getBsa00301());
		this.hashColumns.put("amt00302", getAmt00302());
		this.hashColumns.put("bsa00204", getBsa00204());
		this.hashColumns.put("amt00301", getAmt00301());
		this.hashColumns.put("bsa00205", getBsa00205());
		this.hashColumns.put("amt00304", getAmt00304());
		this.hashColumns.put("bsa00202", getBsa00202());
		this.hashColumns.put("amt00303", getAmt00303());
		this.hashColumns.put("bsa00203", getBsa00203());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amt00305", getAmt00305());
		this.hashColumns.put("bsa00105", getBsa00105());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bsa00103", getBsa00103());
		this.hashColumns.put("bsa00104", getBsa00104());
		this.hashColumns.put("bsa00101", getBsa00101());
		this.hashColumns.put("bsa00102", getBsa00102());
		this.hashColumns.put("port_clss_capa", getPortClssCapa());
		this.hashColumns.put("chk_flag", getChkFlag());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("amt00102", getAmt00102());
		this.hashColumns.put("amt00101", getAmt00101());
		this.hashColumns.put("amt00104", getAmt00104());
		this.hashColumns.put("amt00103", getAmt00103());
		this.hashColumns.put("amt00105", getAmt00105());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("vsl_capa", getVslCapa());
		this.hashColumns.put("amt00204", getAmt00204());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("amt00205", getAmt00205());
		this.hashColumns.put("amt00202", getAmt00202());
		this.hashColumns.put("amt00203", getAmt00203());
		this.hashColumns.put("amt00201", getAmt00201());
		this.hashColumns.put("vsl_oshp_cd", getVslOshpCd());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("fnl_hjs_bsa_capa", getFnlHjsBsaCapa());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bsa00305", "bsa00305");
		this.hashFields.put("bsa00304", "bsa00304");
		this.hashFields.put("bsa00303", "bsa00303");
		this.hashFields.put("bsa00201", "bsa00201");
		this.hashFields.put("bsa00302", "bsa00302");
		this.hashFields.put("bsa00301", "bsa00301");
		this.hashFields.put("amt00302", "amt00302");
		this.hashFields.put("bsa00204", "bsa00204");
		this.hashFields.put("amt00301", "amt00301");
		this.hashFields.put("bsa00205", "bsa00205");
		this.hashFields.put("amt00304", "amt00304");
		this.hashFields.put("bsa00202", "bsa00202");
		this.hashFields.put("amt00303", "amt00303");
		this.hashFields.put("bsa00203", "bsa00203");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amt00305", "amt00305");
		this.hashFields.put("bsa00105", "bsa00105");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bsa00103", "bsa00103");
		this.hashFields.put("bsa00104", "bsa00104");
		this.hashFields.put("bsa00101", "bsa00101");
		this.hashFields.put("bsa00102", "bsa00102");
		this.hashFields.put("port_clss_capa", "portClssCapa");
		this.hashFields.put("chk_flag", "chkFlag");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("amt00102", "amt00102");
		this.hashFields.put("amt00101", "amt00101");
		this.hashFields.put("amt00104", "amt00104");
		this.hashFields.put("amt00103", "amt00103");
		this.hashFields.put("amt00105", "amt00105");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("vsl_capa", "vslCapa");
		this.hashFields.put("amt00204", "amt00204");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("amt00205", "amt00205");
		this.hashFields.put("amt00202", "amt00202");
		this.hashFields.put("amt00203", "amt00203");
		this.hashFields.put("amt00201", "amt00201");
		this.hashFields.put("vsl_oshp_cd", "vslOshpCd");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("fnl_hjs_bsa_capa", "fnlHjsBsaCapa");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return bsa00305
	 */
	public String getBsa00305() {
		return this.bsa00305;
	}
	
	/**
	 * Column Info
	 * @return bsa00304
	 */
	public String getBsa00304() {
		return this.bsa00304;
	}
	
	/**
	 * Column Info
	 * @return bsa00303
	 */
	public String getBsa00303() {
		return this.bsa00303;
	}
	
	/**
	 * Column Info
	 * @return bsa00201
	 */
	public String getBsa00201() {
		return this.bsa00201;
	}
	
	/**
	 * Column Info
	 * @return bsa00302
	 */
	public String getBsa00302() {
		return this.bsa00302;
	}
	
	/**
	 * Column Info
	 * @return bsa00301
	 */
	public String getBsa00301() {
		return this.bsa00301;
	}
	
	/**
	 * Column Info
	 * @return amt00302
	 */
	public String getAmt00302() {
		return this.amt00302;
	}
	
	/**
	 * Column Info
	 * @return bsa00204
	 */
	public String getBsa00204() {
		return this.bsa00204;
	}
	
	/**
	 * Column Info
	 * @return amt00301
	 */
	public String getAmt00301() {
		return this.amt00301;
	}
	
	/**
	 * Column Info
	 * @return bsa00205
	 */
	public String getBsa00205() {
		return this.bsa00205;
	}
	
	/**
	 * Column Info
	 * @return amt00304
	 */
	public String getAmt00304() {
		return this.amt00304;
	}
	
	/**
	 * Column Info
	 * @return bsa00202
	 */
	public String getBsa00202() {
		return this.bsa00202;
	}
	
	/**
	 * Column Info
	 * @return amt00303
	 */
	public String getAmt00303() {
		return this.amt00303;
	}
	
	/**
	 * Column Info
	 * @return bsa00203
	 */
	public String getBsa00203() {
		return this.bsa00203;
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
	 * @return amt00305
	 */
	public String getAmt00305() {
		return this.amt00305;
	}
	
	/**
	 * Column Info
	 * @return bsa00105
	 */
	public String getBsa00105() {
		return this.bsa00105;
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
	 * @return bsa00103
	 */
	public String getBsa00103() {
		return this.bsa00103;
	}
	
	/**
	 * Column Info
	 * @return bsa00104
	 */
	public String getBsa00104() {
		return this.bsa00104;
	}
	
	/**
	 * Column Info
	 * @return bsa00101
	 */
	public String getBsa00101() {
		return this.bsa00101;
	}
	
	/**
	 * Column Info
	 * @return bsa00102
	 */
	public String getBsa00102() {
		return this.bsa00102;
	}
	
	/**
	 * Column Info
	 * @return portClssCapa
	 */
	public String getPortClssCapa() {
		return this.portClssCapa;
	}
	
	/**
	 * Column Info
	 * @return chkFlag
	 */
	public String getChkFlag() {
		return this.chkFlag;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return amt00102
	 */
	public String getAmt00102() {
		return this.amt00102;
	}
	
	/**
	 * Column Info
	 * @return amt00101
	 */
	public String getAmt00101() {
		return this.amt00101;
	}
	
	/**
	 * Column Info
	 * @return amt00104
	 */
	public String getAmt00104() {
		return this.amt00104;
	}
	
	/**
	 * Column Info
	 * @return amt00103
	 */
	public String getAmt00103() {
		return this.amt00103;
	}
	
	/**
	 * Column Info
	 * @return amt00105
	 */
	public String getAmt00105() {
		return this.amt00105;
	}
	
	/**
	 * Column Info
	 * @return vopCd
	 */
	public String getVopCd() {
		return this.vopCd;
	}
	
	/**
	 * Column Info
	 * @return vslCapa
	 */
	public String getVslCapa() {
		return this.vslCapa;
	}
	
	/**
	 * Column Info
	 * @return amt00204
	 */
	public String getAmt00204() {
		return this.amt00204;
	}
	
	/**
	 * Column Info
	 * @return bsaCapa
	 */
	public String getBsaCapa() {
		return this.bsaCapa;
	}
	
	/**
	 * Column Info
	 * @return amt00205
	 */
	public String getAmt00205() {
		return this.amt00205;
	}
	
	/**
	 * Column Info
	 * @return amt00202
	 */
	public String getAmt00202() {
		return this.amt00202;
	}
	
	/**
	 * Column Info
	 * @return amt00203
	 */
	public String getAmt00203() {
		return this.amt00203;
	}
	
	/**
	 * Column Info
	 * @return amt00201
	 */
	public String getAmt00201() {
		return this.amt00201;
	}
	
	/**
	 * Column Info
	 * @return vslOshpCd
	 */
	public String getVslOshpCd() {
		return this.vslOshpCd;
	}
	
	/**
	 * Column Info
	 * @return vslClssCapa
	 */
	public String getVslClssCapa() {
		return this.vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return fnlHjsBsaCapa
	 */
	public String getFnlHjsBsaCapa() {
		return this.fnlHjsBsaCapa;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param bsa00305
	 */
	public void setBsa00305(String bsa00305) {
		this.bsa00305 = bsa00305;
	}
	
	/**
	 * Column Info
	 * @param bsa00304
	 */
	public void setBsa00304(String bsa00304) {
		this.bsa00304 = bsa00304;
	}
	
	/**
	 * Column Info
	 * @param bsa00303
	 */
	public void setBsa00303(String bsa00303) {
		this.bsa00303 = bsa00303;
	}
	
	/**
	 * Column Info
	 * @param bsa00201
	 */
	public void setBsa00201(String bsa00201) {
		this.bsa00201 = bsa00201;
	}
	
	/**
	 * Column Info
	 * @param bsa00302
	 */
	public void setBsa00302(String bsa00302) {
		this.bsa00302 = bsa00302;
	}
	
	/**
	 * Column Info
	 * @param bsa00301
	 */
	public void setBsa00301(String bsa00301) {
		this.bsa00301 = bsa00301;
	}
	
	/**
	 * Column Info
	 * @param amt00302
	 */
	public void setAmt00302(String amt00302) {
		this.amt00302 = amt00302;
	}
	
	/**
	 * Column Info
	 * @param bsa00204
	 */
	public void setBsa00204(String bsa00204) {
		this.bsa00204 = bsa00204;
	}
	
	/**
	 * Column Info
	 * @param amt00301
	 */
	public void setAmt00301(String amt00301) {
		this.amt00301 = amt00301;
	}
	
	/**
	 * Column Info
	 * @param bsa00205
	 */
	public void setBsa00205(String bsa00205) {
		this.bsa00205 = bsa00205;
	}
	
	/**
	 * Column Info
	 * @param amt00304
	 */
	public void setAmt00304(String amt00304) {
		this.amt00304 = amt00304;
	}
	
	/**
	 * Column Info
	 * @param bsa00202
	 */
	public void setBsa00202(String bsa00202) {
		this.bsa00202 = bsa00202;
	}
	
	/**
	 * Column Info
	 * @param amt00303
	 */
	public void setAmt00303(String amt00303) {
		this.amt00303 = amt00303;
	}
	
	/**
	 * Column Info
	 * @param bsa00203
	 */
	public void setBsa00203(String bsa00203) {
		this.bsa00203 = bsa00203;
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
	 * @param amt00305
	 */
	public void setAmt00305(String amt00305) {
		this.amt00305 = amt00305;
	}
	
	/**
	 * Column Info
	 * @param bsa00105
	 */
	public void setBsa00105(String bsa00105) {
		this.bsa00105 = bsa00105;
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
	 * @param bsa00103
	 */
	public void setBsa00103(String bsa00103) {
		this.bsa00103 = bsa00103;
	}
	
	/**
	 * Column Info
	 * @param bsa00104
	 */
	public void setBsa00104(String bsa00104) {
		this.bsa00104 = bsa00104;
	}
	
	/**
	 * Column Info
	 * @param bsa00101
	 */
	public void setBsa00101(String bsa00101) {
		this.bsa00101 = bsa00101;
	}
	
	/**
	 * Column Info
	 * @param bsa00102
	 */
	public void setBsa00102(String bsa00102) {
		this.bsa00102 = bsa00102;
	}
	
	/**
	 * Column Info
	 * @param portClssCapa
	 */
	public void setPortClssCapa(String portClssCapa) {
		this.portClssCapa = portClssCapa;
	}
	
	/**
	 * Column Info
	 * @param chkFlag
	 */
	public void setChkFlag(String chkFlag) {
		this.chkFlag = chkFlag;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param amt00102
	 */
	public void setAmt00102(String amt00102) {
		this.amt00102 = amt00102;
	}
	
	/**
	 * Column Info
	 * @param amt00101
	 */
	public void setAmt00101(String amt00101) {
		this.amt00101 = amt00101;
	}
	
	/**
	 * Column Info
	 * @param amt00104
	 */
	public void setAmt00104(String amt00104) {
		this.amt00104 = amt00104;
	}
	
	/**
	 * Column Info
	 * @param amt00103
	 */
	public void setAmt00103(String amt00103) {
		this.amt00103 = amt00103;
	}
	
	/**
	 * Column Info
	 * @param amt00105
	 */
	public void setAmt00105(String amt00105) {
		this.amt00105 = amt00105;
	}
	
	/**
	 * Column Info
	 * @param vopCd
	 */
	public void setVopCd(String vopCd) {
		this.vopCd = vopCd;
	}
	
	/**
	 * Column Info
	 * @param vslCapa
	 */
	public void setVslCapa(String vslCapa) {
		this.vslCapa = vslCapa;
	}
	
	/**
	 * Column Info
	 * @param amt00204
	 */
	public void setAmt00204(String amt00204) {
		this.amt00204 = amt00204;
	}
	
	/**
	 * Column Info
	 * @param bsaCapa
	 */
	public void setBsaCapa(String bsaCapa) {
		this.bsaCapa = bsaCapa;
	}
	
	/**
	 * Column Info
	 * @param amt00205
	 */
	public void setAmt00205(String amt00205) {
		this.amt00205 = amt00205;
	}
	
	/**
	 * Column Info
	 * @param amt00202
	 */
	public void setAmt00202(String amt00202) {
		this.amt00202 = amt00202;
	}
	
	/**
	 * Column Info
	 * @param amt00203
	 */
	public void setAmt00203(String amt00203) {
		this.amt00203 = amt00203;
	}
	
	/**
	 * Column Info
	 * @param amt00201
	 */
	public void setAmt00201(String amt00201) {
		this.amt00201 = amt00201;
	}
	
	/**
	 * Column Info
	 * @param vslOshpCd
	 */
	public void setVslOshpCd(String vslOshpCd) {
		this.vslOshpCd = vslOshpCd;
	}
	
	/**
	 * Column Info
	 * @param vslClssCapa
	 */
	public void setVslClssCapa(String vslClssCapa) {
		this.vslClssCapa = vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param fnlHjsBsaCapa
	 */
	public void setFnlHjsBsaCapa(String fnlHjsBsaCapa) {
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBsa00305(JSPUtil.getParameter(request, "bsa00305", ""));
		setBsa00304(JSPUtil.getParameter(request, "bsa00304", ""));
		setBsa00303(JSPUtil.getParameter(request, "bsa00303", ""));
		setBsa00201(JSPUtil.getParameter(request, "bsa00201", ""));
		setBsa00302(JSPUtil.getParameter(request, "bsa00302", ""));
		setBsa00301(JSPUtil.getParameter(request, "bsa00301", ""));
		setAmt00302(JSPUtil.getParameter(request, "amt00302", ""));
		setBsa00204(JSPUtil.getParameter(request, "bsa00204", ""));
		setAmt00301(JSPUtil.getParameter(request, "amt00301", ""));
		setBsa00205(JSPUtil.getParameter(request, "bsa00205", ""));
		setAmt00304(JSPUtil.getParameter(request, "amt00304", ""));
		setBsa00202(JSPUtil.getParameter(request, "bsa00202", ""));
		setAmt00303(JSPUtil.getParameter(request, "amt00303", ""));
		setBsa00203(JSPUtil.getParameter(request, "bsa00203", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAmt00305(JSPUtil.getParameter(request, "amt00305", ""));
		setBsa00105(JSPUtil.getParameter(request, "bsa00105", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBsa00103(JSPUtil.getParameter(request, "bsa00103", ""));
		setBsa00104(JSPUtil.getParameter(request, "bsa00104", ""));
		setBsa00101(JSPUtil.getParameter(request, "bsa00101", ""));
		setBsa00102(JSPUtil.getParameter(request, "bsa00102", ""));
		setPortClssCapa(JSPUtil.getParameter(request, "port_clss_capa", ""));
		setChkFlag(JSPUtil.getParameter(request, "chk_flag", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setAmt00102(JSPUtil.getParameter(request, "amt00102", ""));
		setAmt00101(JSPUtil.getParameter(request, "amt00101", ""));
		setAmt00104(JSPUtil.getParameter(request, "amt00104", ""));
		setAmt00103(JSPUtil.getParameter(request, "amt00103", ""));
		setAmt00105(JSPUtil.getParameter(request, "amt00105", ""));
		setVopCd(JSPUtil.getParameter(request, "vop_cd", ""));
		setVslCapa(JSPUtil.getParameter(request, "vsl_capa", ""));
		setAmt00204(JSPUtil.getParameter(request, "amt00204", ""));
		setBsaCapa(JSPUtil.getParameter(request, "bsa_capa", ""));
		setAmt00205(JSPUtil.getParameter(request, "amt00205", ""));
		setAmt00202(JSPUtil.getParameter(request, "amt00202", ""));
		setAmt00203(JSPUtil.getParameter(request, "amt00203", ""));
		setAmt00201(JSPUtil.getParameter(request, "amt00201", ""));
		setVslOshpCd(JSPUtil.getParameter(request, "vsl_oshp_cd", ""));
		setVslClssCapa(JSPUtil.getParameter(request, "vsl_clss_capa", ""));
		setFnlHjsBsaCapa(JSPUtil.getParameter(request, "fnl_hjs_bsa_capa", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBSAbyVVDListVO[]
	 */
	public SearchBSAbyVVDListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBSAbyVVDListVO[]
	 */
	public SearchBSAbyVVDListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBSAbyVVDListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bsa00305 = (JSPUtil.getParameter(request, prefix	+ "bsa00305", length));
			String[] bsa00304 = (JSPUtil.getParameter(request, prefix	+ "bsa00304", length));
			String[] bsa00303 = (JSPUtil.getParameter(request, prefix	+ "bsa00303", length));
			String[] bsa00201 = (JSPUtil.getParameter(request, prefix	+ "bsa00201", length));
			String[] bsa00302 = (JSPUtil.getParameter(request, prefix	+ "bsa00302", length));
			String[] bsa00301 = (JSPUtil.getParameter(request, prefix	+ "bsa00301", length));
			String[] amt00302 = (JSPUtil.getParameter(request, prefix	+ "amt00302", length));
			String[] bsa00204 = (JSPUtil.getParameter(request, prefix	+ "bsa00204", length));
			String[] amt00301 = (JSPUtil.getParameter(request, prefix	+ "amt00301", length));
			String[] bsa00205 = (JSPUtil.getParameter(request, prefix	+ "bsa00205", length));
			String[] amt00304 = (JSPUtil.getParameter(request, prefix	+ "amt00304", length));
			String[] bsa00202 = (JSPUtil.getParameter(request, prefix	+ "bsa00202", length));
			String[] amt00303 = (JSPUtil.getParameter(request, prefix	+ "amt00303", length));
			String[] bsa00203 = (JSPUtil.getParameter(request, prefix	+ "bsa00203", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amt00305 = (JSPUtil.getParameter(request, prefix	+ "amt00305", length));
			String[] bsa00105 = (JSPUtil.getParameter(request, prefix	+ "bsa00105", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bsa00103 = (JSPUtil.getParameter(request, prefix	+ "bsa00103", length));
			String[] bsa00104 = (JSPUtil.getParameter(request, prefix	+ "bsa00104", length));
			String[] bsa00101 = (JSPUtil.getParameter(request, prefix	+ "bsa00101", length));
			String[] bsa00102 = (JSPUtil.getParameter(request, prefix	+ "bsa00102", length));
			String[] portClssCapa = (JSPUtil.getParameter(request, prefix	+ "port_clss_capa", length));
			String[] chkFlag = (JSPUtil.getParameter(request, prefix	+ "chk_flag", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] amt00102 = (JSPUtil.getParameter(request, prefix	+ "amt00102", length));
			String[] amt00101 = (JSPUtil.getParameter(request, prefix	+ "amt00101", length));
			String[] amt00104 = (JSPUtil.getParameter(request, prefix	+ "amt00104", length));
			String[] amt00103 = (JSPUtil.getParameter(request, prefix	+ "amt00103", length));
			String[] amt00105 = (JSPUtil.getParameter(request, prefix	+ "amt00105", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] vslCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_capa", length));
			String[] amt00204 = (JSPUtil.getParameter(request, prefix	+ "amt00204", length));
			String[] bsaCapa = (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] amt00205 = (JSPUtil.getParameter(request, prefix	+ "amt00205", length));
			String[] amt00202 = (JSPUtil.getParameter(request, prefix	+ "amt00202", length));
			String[] amt00203 = (JSPUtil.getParameter(request, prefix	+ "amt00203", length));
			String[] amt00201 = (JSPUtil.getParameter(request, prefix	+ "amt00201", length));
			String[] vslOshpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cd", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] fnlHjsBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_hjs_bsa_capa", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBSAbyVVDListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bsa00305[i] != null)
					model.setBsa00305(bsa00305[i]);
				if (bsa00304[i] != null)
					model.setBsa00304(bsa00304[i]);
				if (bsa00303[i] != null)
					model.setBsa00303(bsa00303[i]);
				if (bsa00201[i] != null)
					model.setBsa00201(bsa00201[i]);
				if (bsa00302[i] != null)
					model.setBsa00302(bsa00302[i]);
				if (bsa00301[i] != null)
					model.setBsa00301(bsa00301[i]);
				if (amt00302[i] != null)
					model.setAmt00302(amt00302[i]);
				if (bsa00204[i] != null)
					model.setBsa00204(bsa00204[i]);
				if (amt00301[i] != null)
					model.setAmt00301(amt00301[i]);
				if (bsa00205[i] != null)
					model.setBsa00205(bsa00205[i]);
				if (amt00304[i] != null)
					model.setAmt00304(amt00304[i]);
				if (bsa00202[i] != null)
					model.setBsa00202(bsa00202[i]);
				if (amt00303[i] != null)
					model.setAmt00303(amt00303[i]);
				if (bsa00203[i] != null)
					model.setBsa00203(bsa00203[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (amt00305[i] != null)
					model.setAmt00305(amt00305[i]);
				if (bsa00105[i] != null)
					model.setBsa00105(bsa00105[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bsa00103[i] != null)
					model.setBsa00103(bsa00103[i]);
				if (bsa00104[i] != null)
					model.setBsa00104(bsa00104[i]);
				if (bsa00101[i] != null)
					model.setBsa00101(bsa00101[i]);
				if (bsa00102[i] != null)
					model.setBsa00102(bsa00102[i]);
				if (portClssCapa[i] != null)
					model.setPortClssCapa(portClssCapa[i]);
				if (chkFlag[i] != null)
					model.setChkFlag(chkFlag[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (amt00102[i] != null)
					model.setAmt00102(amt00102[i]);
				if (amt00101[i] != null)
					model.setAmt00101(amt00101[i]);
				if (amt00104[i] != null)
					model.setAmt00104(amt00104[i]);
				if (amt00103[i] != null)
					model.setAmt00103(amt00103[i]);
				if (amt00105[i] != null)
					model.setAmt00105(amt00105[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (vslCapa[i] != null)
					model.setVslCapa(vslCapa[i]);
				if (amt00204[i] != null)
					model.setAmt00204(amt00204[i]);
				if (bsaCapa[i] != null)
					model.setBsaCapa(bsaCapa[i]);
				if (amt00205[i] != null)
					model.setAmt00205(amt00205[i]);
				if (amt00202[i] != null)
					model.setAmt00202(amt00202[i]);
				if (amt00203[i] != null)
					model.setAmt00203(amt00203[i]);
				if (amt00201[i] != null)
					model.setAmt00201(amt00201[i]);
				if (vslOshpCd[i] != null)
					model.setVslOshpCd(vslOshpCd[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (fnlHjsBsaCapa[i] != null)
					model.setFnlHjsBsaCapa(fnlHjsBsaCapa[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBSAbyVVDListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBSAbyVVDListVO[]
	 */
	public SearchBSAbyVVDListVO[] getSearchBSAbyVVDListVOs(){
		SearchBSAbyVVDListVO[] vos = (SearchBSAbyVVDListVO[])models.toArray(new SearchBSAbyVVDListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa00305 = this.bsa00305 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa00304 = this.bsa00304 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa00303 = this.bsa00303 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa00201 = this.bsa00201 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa00302 = this.bsa00302 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa00301 = this.bsa00301 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt00302 = this.amt00302 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa00204 = this.bsa00204 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt00301 = this.amt00301 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa00205 = this.bsa00205 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt00304 = this.amt00304 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa00202 = this.bsa00202 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt00303 = this.amt00303 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa00203 = this.bsa00203 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt00305 = this.amt00305 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa00105 = this.bsa00105 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa00103 = this.bsa00103 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa00104 = this.bsa00104 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa00101 = this.bsa00101 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa00102 = this.bsa00102 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portClssCapa = this.portClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkFlag = this.chkFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt00102 = this.amt00102 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt00101 = this.amt00101 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt00104 = this.amt00104 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt00103 = this.amt00103 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt00105 = this.amt00105 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCapa = this.vslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt00204 = this.amt00204 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt00205 = this.amt00205 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt00202 = this.amt00202 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt00203 = this.amt00203 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt00201 = this.amt00201 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCd = this.vslOshpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlHjsBsaCapa = this.fnlHjsBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	// 추가 
	//
	/* DB RowSet 객체  */
	private DBRowSet rowSet = null;
	
	/* DB RowSet 객체  */
	private DBRowSet[] rowSetArray = null;	
	
	/* DB List 객체  */
	List<SearchSimConditionVO> list = null;	
	
	/** DBRowSet Getter */
	public DBRowSet getRowSet() {
		return rowSet;
	}
	/** DBRowSet Setter */
	public void setRowSet(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}
	
	/** DBRowSet Array Getter */
	public DBRowSet[] getRowSetArray() {
		return rowSetArray;
	}
	/** DBRowSet Array Setter */
	public void setRowSetArray(DBRowSet[] rowSetArray) {
		this.rowSetArray = rowSetArray;
	}	
	 
}
