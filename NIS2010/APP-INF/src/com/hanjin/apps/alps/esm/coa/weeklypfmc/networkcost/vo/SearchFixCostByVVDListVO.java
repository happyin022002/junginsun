/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchFixCostByVVDListVO.java
*@FileTitle : SearchFixCostByVVDListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.02.22 김상수 
* 1.0 Creation
 *=========================================================
 * History
 * 2011.02.21 김상수 [CHM-201108827-01] * R.month/Week 및 OPR/OPR2 정보 보여주는 칼럼 추가
=========================================================*/

package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo;

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

public class SearchFixCostByVVDListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFixCostByVVDListVO> models = new ArrayList<SearchFixCostByVVDListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String amt03 = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String amt02 = null;
	/* Column Info */
	private String amt01 = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String amt07 = null;
	/* Column Info */
	private String amt06 = null;
	/* Column Info */
	private String amt05 = null;
	/* Column Info */
	private String amt04 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String vslDblCallSeq = null;
	/* Column Info */
	private String amt08 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String amt09 = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String subsumCode = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String portDys = null;
	/* Column Info */
	private String amt10 = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String amt12 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String amt11 = null;
	/* Column Info */
	private String amt13 = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String seaDys = null;
	/* Column Info */
	private String aplyVoyRto = null;
	/* Column Info */
	private String ttlTzDys = null;
	/* Column Info */
	private String contiNm = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String vslOshpCd = null;
	/* Column Info */
	private String vslClssCapa = null;
	/*	Column Info	*/
	private	String	 hulBndCd ;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchFixCostByVVDListVO() {}

	public SearchFixCostByVVDListVO(String vslCd,String amt03,String trdCd,String amt02,String amt01,String rlaneCd,String amt07,String amt06,String amt05,String amt04,String pagerows,String clptSeq,String vslDblCallSeq,String amt08,String ibflag,String locCd,String amt09,String costYrmon,String subsumCode,String dirCd,String iocCd,String portDys,String amt10,String vopCd,String amt12,String skdVoyNo,String amt11,String amt13,String slsYrmon,String seaDys,String aplyVoyRto,String ttlTzDys,String contiNm,String costWk,String vslOshpCd,String vslClssCapa,String hulBndCd)	{
		this.vslCd  = vslCd ;
		this.amt03  = amt03 ;
		this.trdCd  = trdCd ;
		this.amt02  = amt02 ;
		this.amt01  = amt01 ;
		this.rlaneCd  = rlaneCd ;
		this.amt07  = amt07 ;
		this.amt06  = amt06 ;
		this.amt05  = amt05 ;
		this.amt04  = amt04 ;
		this.pagerows  = pagerows ;
		this.clptSeq  = clptSeq ;
		this.vslDblCallSeq  = vslDblCallSeq ;
		this.amt08  = amt08 ;
		this.ibflag  = ibflag ;
		this.locCd  = locCd ;
		this.amt09  = amt09 ;
		this.costYrmon  = costYrmon ;
		this.subsumCode  = subsumCode ;
		this.dirCd  = dirCd ;
		this.iocCd  = iocCd ;
		this.portDys  = portDys ;
		this.amt10  = amt10 ;
		this.vopCd  = vopCd ;
		this.amt12  = amt12 ;
		this.skdVoyNo  = skdVoyNo ;
		this.amt11  = amt11 ;
		this.amt13  = amt13 ;
		this.slsYrmon  = slsYrmon ;
		this.seaDys  = seaDys ;
		this.aplyVoyRto  = aplyVoyRto ;
		this.ttlTzDys  = ttlTzDys ;
		this.contiNm  = contiNm ;
		this.costWk  = costWk ;
		this.vslOshpCd  = vslOshpCd ;
		this.vslClssCapa  = vslClssCapa ;
		this.hulBndCd  = hulBndCd ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("amt_03", getAmt03());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("amt_02", getAmt02());
		this.hashColumns.put("amt_01", getAmt01());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("amt_07", getAmt07());
		this.hashColumns.put("amt_06", getAmt06());
		this.hashColumns.put("amt_05", getAmt05());
		this.hashColumns.put("amt_04", getAmt04());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("vsl_dbl_call_seq", getVslDblCallSeq());
		this.hashColumns.put("amt_08", getAmt08());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("amt_09", getAmt09());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("subsum_code", getSubsumCode());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("port_dys", getPortDys());
		this.hashColumns.put("amt_10", getAmt10());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("amt_12", getAmt12());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("amt_11", getAmt11());
		this.hashColumns.put("amt_13", getAmt13());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("sea_dys", getSeaDys());
		this.hashColumns.put("aply_voy_rto", getAplyVoyRto());
		this.hashColumns.put("ttl_tz_dys", getTtlTzDys());
		this.hashColumns.put("conti_nm", getContiNm());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("vsl_oshp_cd", getVslOshpCd());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());	
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("amt_03", "amt03");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("amt_02", "amt02");
		this.hashFields.put("amt_01", "amt01");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("amt_07", "amt07");
		this.hashFields.put("amt_06", "amt06");
		this.hashFields.put("amt_05", "amt05");
		this.hashFields.put("amt_04", "amt04");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("vsl_dbl_call_seq", "vslDblCallSeq");
		this.hashFields.put("amt_08", "amt08");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("amt_09", "amt09");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("subsum_code", "subsumCode");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("port_dys", "portDys");
		this.hashFields.put("amt_10", "amt10");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("amt_12", "amt12");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("amt_11", "amt11");
		this.hashFields.put("amt_13", "amt13");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("sea_dys", "seaDys");
		this.hashFields.put("aply_voy_rto", "aplyVoyRto");
		this.hashFields.put("ttl_tz_dys", "ttlTzDys");
		this.hashFields.put("conti_nm", "contiNm");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("vsl_oshp_cd", "vslOshpCd");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
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
	 * @return amt03
	 */
	public String getAmt03() {
		return this.amt03;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return amt02
	 */
	public String getAmt02() {
		return this.amt02;
	}
	
	/**
	 * Column Info
	 * @return amt01
	 */
	public String getAmt01() {
		return this.amt01;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return amt07
	 */
	public String getAmt07() {
		return this.amt07;
	}
	
	/**
	 * Column Info
	 * @return amt06
	 */
	public String getAmt06() {
		return this.amt06;
	}
	
	/**
	 * Column Info
	 * @return amt05
	 */
	public String getAmt05() {
		return this.amt05;
	}
	
	/**
	 * Column Info
	 * @return amt04
	 */
	public String getAmt04() {
		return this.amt04;
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
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
	}
	
	/**
	 * Column Info
	 * @return vslDblCallSeq
	 */
	public String getVslDblCallSeq() {
		return this.vslDblCallSeq;
	}
	
	/**
	 * Column Info
	 * @return amt08
	 */
	public String getAmt08() {
		return this.amt08;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return amt09
	 */
	public String getAmt09() {
		return this.amt09;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return subsumCode
	 */
	public String getSubsumCode() {
		return this.subsumCode;
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
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return portDys
	 */
	public String getPortDys() {
		return this.portDys;
	}
	
	/**
	 * Column Info
	 * @return amt10
	 */
	public String getAmt10() {
		return this.amt10;
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
	 * @return amt12
	 */
	public String getAmt12() {
		return this.amt12;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return amt11
	 */
	public String getAmt11() {
		return this.amt11;
	}
	
	/**
	 * Column Info
	 * @return amt13
	 */
	public String getAmt13() {
		return this.amt13;
	}
	
	/**
	 * Column Info
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
	}
	
	/**
	 * Column Info
	 * @return seaDys
	 */
	public String getSeaDys() {
		return this.seaDys;
	}
	
	/**
	 * Column Info
	 * @return aplyVoyRto
	 */
	public String getAplyVoyRto() {
		return this.aplyVoyRto;
	}
	
	/**
	 * Column Info
	 * @return ttlTzDys
	 */
	public String getTtlTzDys() {
		return this.ttlTzDys;
	}
	
	/**
	 * Column Info
	 * @return contiNm
	 */
	public String getContiNm() {
		return this.contiNm;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param amt03
	 */
	public void setAmt03(String amt03) {
		this.amt03 = amt03;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param amt02
	 */
	public void setAmt02(String amt02) {
		this.amt02 = amt02;
	}
	
	/**
	 * Column Info
	 * @param amt01
	 */
	public void setAmt01(String amt01) {
		this.amt01 = amt01;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param amt07
	 */
	public void setAmt07(String amt07) {
		this.amt07 = amt07;
	}
	
	/**
	 * Column Info
	 * @param amt06
	 */
	public void setAmt06(String amt06) {
		this.amt06 = amt06;
	}
	
	/**
	 * Column Info
	 * @param amt05
	 */
	public void setAmt05(String amt05) {
		this.amt05 = amt05;
	}
	
	/**
	 * Column Info
	 * @param amt04
	 */
	public void setAmt04(String amt04) {
		this.amt04 = amt04;
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
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
	}
	
	/**
	 * Column Info
	 * @param vslDblCallSeq
	 */
	public void setVslDblCallSeq(String vslDblCallSeq) {
		this.vslDblCallSeq = vslDblCallSeq;
	}
	
	/**
	 * Column Info
	 * @param amt08
	 */
	public void setAmt08(String amt08) {
		this.amt08 = amt08;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param amt09
	 */
	public void setAmt09(String amt09) {
		this.amt09 = amt09;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param subsumCode
	 */
	public void setSubsumCode(String subsumCode) {
		this.subsumCode = subsumCode;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param portDys
	 */
	public void setPortDys(String portDys) {
		this.portDys = portDys;
	}
	
	/**
	 * Column Info
	 * @param amt10
	 */
	public void setAmt10(String amt10) {
		this.amt10 = amt10;
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
	 * @param amt12
	 */
	public void setAmt12(String amt12) {
		this.amt12 = amt12;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param amt11
	 */
	public void setAmt11(String amt11) {
		this.amt11 = amt11;
	}
	
	/**
	 * Column Info
	 * @param amt13
	 */
	public void setAmt13(String amt13) {
		this.amt13 = amt13;
	}
	
	/**
	 * Column Info
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
	}
	
	/**
	 * Column Info
	 * @param seaDys
	 */
	public void setSeaDys(String seaDys) {
		this.seaDys = seaDys;
	}
	
	/**
	 * Column Info
	 * @param aplyVoyRto
	 */
	public void setAplyVoyRto(String aplyVoyRto) {
		this.aplyVoyRto = aplyVoyRto;
	}
	
	/**
	 * Column Info
	 * @param ttlTzDys
	 */
	public void setTtlTzDys(String ttlTzDys) {
		this.ttlTzDys = ttlTzDys;
	}
	
	/**
	 * Column Info
	 * @param contiNm
	 */
	public void setContiNm(String contiNm) {
		this.contiNm = contiNm;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
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
	* @param  hulBndCd
	*/
	public void	setHulBndCd( String	hulBndCd ) {
		this.hulBndCd =	hulBndCd;
	}
 
	/**
	 * Column Info
	 * @return	hulBndCd
	 */
	 public	String	getHulBndCd() {
		 return	this.hulBndCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setAmt03(JSPUtil.getParameter(request, prefix + "amt_03", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setAmt02(JSPUtil.getParameter(request, prefix + "amt_02", ""));
		setAmt01(JSPUtil.getParameter(request, prefix + "amt_01", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setAmt07(JSPUtil.getParameter(request, prefix + "amt_07", ""));
		setAmt06(JSPUtil.getParameter(request, prefix + "amt_06", ""));
		setAmt05(JSPUtil.getParameter(request, prefix + "amt_05", ""));
		setAmt04(JSPUtil.getParameter(request, prefix + "amt_04", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setVslDblCallSeq(JSPUtil.getParameter(request, prefix + "vsl_dbl_call_seq", ""));
		setAmt08(JSPUtil.getParameter(request, prefix + "amt_08", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setAmt09(JSPUtil.getParameter(request, prefix + "amt_09", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setSubsumCode(JSPUtil.getParameter(request, prefix + "subsum_code", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setPortDys(JSPUtil.getParameter(request, prefix + "port_dys", ""));
		setAmt10(JSPUtil.getParameter(request, prefix + "amt_10", ""));
		setVopCd(JSPUtil.getParameter(request, prefix + "vop_cd", ""));
		setAmt12(JSPUtil.getParameter(request, prefix + "amt_12", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setAmt11(JSPUtil.getParameter(request, prefix + "amt_11", ""));
		setAmt13(JSPUtil.getParameter(request, prefix + "amt_13", ""));
		setSlsYrmon(JSPUtil.getParameter(request, prefix + "sls_yrmon", ""));
		setSeaDys(JSPUtil.getParameter(request, prefix + "sea_dys", ""));
		setAplyVoyRto(JSPUtil.getParameter(request, prefix + "aply_voy_rto", ""));
		setTtlTzDys(JSPUtil.getParameter(request, prefix + "ttl_tz_dys", ""));
		setContiNm(JSPUtil.getParameter(request, prefix + "conti_nm", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setVslOshpCd(JSPUtil.getParameter(request, prefix + "vsl_oshp_cd", ""));
		setVslClssCapa(JSPUtil.getParameter(request, prefix + "vsl_clss_capa", ""));
		setHulBndCd(JSPUtil.getParameter(request,	prefix + "hul_bnd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFixCostByVVDListVO[]
	 */
	public SearchFixCostByVVDListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFixCostByVVDListVO[]
	 */
	public SearchFixCostByVVDListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFixCostByVVDListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] amt03 = (JSPUtil.getParameter(request, prefix	+ "amt_03", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] amt02 = (JSPUtil.getParameter(request, prefix	+ "amt_02", length));
			String[] amt01 = (JSPUtil.getParameter(request, prefix	+ "amt_01", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] amt07 = (JSPUtil.getParameter(request, prefix	+ "amt_07", length));
			String[] amt06 = (JSPUtil.getParameter(request, prefix	+ "amt_06", length));
			String[] amt05 = (JSPUtil.getParameter(request, prefix	+ "amt_05", length));
			String[] amt04 = (JSPUtil.getParameter(request, prefix	+ "amt_04", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] vslDblCallSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_dbl_call_seq", length));
			String[] amt08 = (JSPUtil.getParameter(request, prefix	+ "amt_08", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] amt09 = (JSPUtil.getParameter(request, prefix	+ "amt_09", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] subsumCode = (JSPUtil.getParameter(request, prefix	+ "subsum_code", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] portDys = (JSPUtil.getParameter(request, prefix	+ "port_dys", length));
			String[] amt10 = (JSPUtil.getParameter(request, prefix	+ "amt_10", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] amt12 = (JSPUtil.getParameter(request, prefix	+ "amt_12", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] amt11 = (JSPUtil.getParameter(request, prefix	+ "amt_11", length));
			String[] amt13 = (JSPUtil.getParameter(request, prefix	+ "amt_13", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] seaDys = (JSPUtil.getParameter(request, prefix	+ "sea_dys", length));
			String[] aplyVoyRto = (JSPUtil.getParameter(request, prefix	+ "aply_voy_rto", length));
			String[] ttlTzDys = (JSPUtil.getParameter(request, prefix	+ "ttl_tz_dys", length));
			String[] contiNm = (JSPUtil.getParameter(request, prefix	+ "conti_nm", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] vslOshpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cd", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] hulBndCd =	(JSPUtil.getParameter(request, prefix +	"hul_bnd_cd".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFixCostByVVDListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (amt03[i] != null)
					model.setAmt03(amt03[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (amt02[i] != null)
					model.setAmt02(amt02[i]);
				if (amt01[i] != null)
					model.setAmt01(amt01[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (amt07[i] != null)
					model.setAmt07(amt07[i]);
				if (amt06[i] != null)
					model.setAmt06(amt06[i]);
				if (amt05[i] != null)
					model.setAmt05(amt05[i]);
				if (amt04[i] != null)
					model.setAmt04(amt04[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (vslDblCallSeq[i] != null)
					model.setVslDblCallSeq(vslDblCallSeq[i]);
				if (amt08[i] != null)
					model.setAmt08(amt08[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (amt09[i] != null)
					model.setAmt09(amt09[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (subsumCode[i] != null)
					model.setSubsumCode(subsumCode[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (portDys[i] != null)
					model.setPortDys(portDys[i]);
				if (amt10[i] != null)
					model.setAmt10(amt10[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (amt12[i] != null)
					model.setAmt12(amt12[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (amt11[i] != null)
					model.setAmt11(amt11[i]);
				if (amt13[i] != null)
					model.setAmt13(amt13[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (seaDys[i] != null)
					model.setSeaDys(seaDys[i]);
				if (aplyVoyRto[i] != null)
					model.setAplyVoyRto(aplyVoyRto[i]);
				if (ttlTzDys[i] != null)
					model.setTtlTzDys(ttlTzDys[i]);
				if (contiNm[i] != null)
					model.setContiNm(contiNm[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (vslOshpCd[i] != null)
					model.setVslOshpCd(vslOshpCd[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if ( hulBndCd[i] !=	null)
					model.setHulBndCd( hulBndCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFixCostByVVDListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFixCostByVVDListVO[]
	 */
	public SearchFixCostByVVDListVO[] getSearchFixCostByVVDListVOs(){
		SearchFixCostByVVDListVO[] vos = (SearchFixCostByVVDListVO[])models.toArray(new SearchFixCostByVVDListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt03 = this.amt03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt02 = this.amt02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt01 = this.amt01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt07 = this.amt07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt06 = this.amt06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt05 = this.amt05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt04 = this.amt04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDblCallSeq = this.vslDblCallSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt08 = this.amt08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt09 = this.amt09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsumCode = this.subsumCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDys = this.portDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt10 = this.amt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt12 = this.amt12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt11 = this.amt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt13 = this.amt13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDys = this.seaDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyVoyRto = this.aplyVoyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTzDys = this.ttlTzDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiNm = this.contiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCd = this.vslOshpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd =	this.hulBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
