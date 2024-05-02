/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PfSkdEotpDetailVO.java
*@FileTitle : PfSkdEotpDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.08.06 서창열 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo;

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
 * @author 서창열
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PfSkdEotpDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PfSkdEotpDtlVO> models = new ArrayList<PfSkdEotpDtlVO>();
	
	/* Column Info */
	private String chkEotp01 = null;
	/* Column Info */
	private String chkEotp02 = null;
	/* Column Info */
	private String histYr = null;
	/* Column Info */
	private String lnkSpd = null;
	/* Column Info */
	private String seaBufHrs = null;
	/* Column Info */
	private String tmlProdQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String maxSpd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String newSeaTm1 = null;
	/* Column Info */
	private String ibIpcgoQty = null;
	/* Column Info */
	private String obIpcgoQty = null;
	/* Column Info */
	private String n3rdVslClssCd = null;
	/* Column Info */
	private String obOcnCgoQty = null;
	/* Column Info */
	private String lnkDist = null;
	/* Column Info */
	private String ibOcnCgoQty = null;
	/* Column Info */
	private String bfPortCd = null;
	/* Column Info */
	private String vslClass = null;
	/* Column Info */
	private String recoveryTm = null;
	/* Column Info */
	private String actSailTm = null;
	/* Column Info */
	private String actSpd = null;
	/* Column Info */
	private String onTm = null;
	/* Column Info */
	private String toPortCd = null;
	/* Column Info */
	private String n2ndVslClssCd = null;
	/* Column Info */
	private String n1stVslClssCd = null;
	/* Column Info */
	private String onTmYn = null;
	/* Column Info */
	private String oldPortTm = null;
	/* Column Info */
	private String newPortTm = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String newSeaBufTm = null;
	/* Column Info */
	private String newPortBufTm = null;
	/* Column Info */
	private String eotp01 = null;
	/* Column Info */
	private String eotp02 = null;
	/* Column Info */


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PfSkdEotpDtlVO() {}

	public PfSkdEotpDtlVO(
			String ibflag, String pagerows, String vslClass, String maxSpd, String actSpd, String actSailTm, String newSeaTm1,
			String chkEotp01, String recoveryTm, String chkEotp02, String onTm, String bfPortCd, String toPortCd, String lnkDist,
			String lnkSpd, String ibIpcgoQty, String obIpcgoQty, String ibOcnCgoQty, String obOcnCgoQty, String tmlProdQty, 
			String seaBufHrs, String n1stVslClssCd, String n2ndVslClssCd, String n3rdVslClssCd, String histYr, String onTmYn, 
			String oldPortTm, String newPortTm, String vvd, String newSeaBufTm, String newPortBufTm, String eotp01, String eotp02
			) {
		this.chkEotp01 		= chkEotp01;
		this.chkEotp02 		= chkEotp02;
		this.histYr 		= histYr;
		this.lnkSpd 		= lnkSpd;
		this.seaBufHrs 		= seaBufHrs;
		this.tmlProdQty 	= tmlProdQty;
		this.pagerows 		= pagerows;
		this.maxSpd 		= maxSpd;
		this.ibflag 		= ibflag;
		this.newSeaTm1 		= newSeaTm1;
		this.ibIpcgoQty 	= ibIpcgoQty;
		this.obIpcgoQty 	= obIpcgoQty;
		this.n3rdVslClssCd 	= n3rdVslClssCd;
		this.obOcnCgoQty 	= obOcnCgoQty;
		this.lnkDist 		= lnkDist;
		this.ibOcnCgoQty 	= ibOcnCgoQty;
		this.bfPortCd 		= bfPortCd;
		this.vslClass 		= vslClass;
		this.recoveryTm 	= recoveryTm;
		this.actSailTm 		= actSailTm;
		this.actSpd 		= actSpd;
		this.onTm 			= onTm;
		this.toPortCd 		= toPortCd;
		this.n2ndVslClssCd 	= n2ndVslClssCd;
		this.n1stVslClssCd 	= n1stVslClssCd;
		this.onTmYn 		= onTmYn;
		this.oldPortTm 		= oldPortTm;
		this.newPortTm 		= newPortTm;
		this.vvd 			= vvd;
		this.newSeaBufTm	= newSeaBufTm;
		this.newPortBufTm	= newPortBufTm;
		this.eotp01			= eotp01;
		this.eotp02			= eotp02;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chk_eotp01", 			getChkEotp01());
		this.hashColumns.put("chk_eotp02", 			getChkEotp02());
		this.hashColumns.put("hist_yr", 			getHistYr());
		this.hashColumns.put("lnk_spd", 			getLnkSpd());
		this.hashColumns.put("sea_buf_hrs", 		getSeaBufHrs());
		this.hashColumns.put("tml_prod_qty", 		getTmlProdQty());
		this.hashColumns.put("pagerows", 			getPagerows());
		this.hashColumns.put("max_spd", 			getMaxSpd());
		this.hashColumns.put("ibflag", 				getIbflag());
		this.hashColumns.put("new_sea_tm1", 		getNewSeaTm1());
		this.hashColumns.put("ib_ipcgo_qty", 		getIbIpcgoQty());
		this.hashColumns.put("ob_ipcgo_qty", 		getObIpcgoQty());
		this.hashColumns.put("n3rd_vsl_clss_cd", 	getN3rdVslClssCd());
		this.hashColumns.put("ob_ocn_cgo_qty", 		getObOcnCgoQty());
		this.hashColumns.put("lnk_dist", 			getLnkDist());
		this.hashColumns.put("ib_ocn_cgo_qty", 		getIbOcnCgoQty());
		this.hashColumns.put("bf_port_cd", 			getBfPortCd());
		this.hashColumns.put("vsl_class", 			getVslClass());
		this.hashColumns.put("recovery_tm", 		getRecoveryTm());
		this.hashColumns.put("act_sail_tm", 		getActSailTm());
		this.hashColumns.put("act_spd", 			getActSpd());
		this.hashColumns.put("on_tm", 				getOnTm());
		this.hashColumns.put("to_port_cd", 			getToPortCd());
		this.hashColumns.put("n2nd_vsl_clss_cd", 	getN2ndVslClssCd());
		this.hashColumns.put("n1st_vsl_clss_cd", 	getN1stVslClssCd());
		this.hashColumns.put("on_tm_yn", 			getOnTmYn());
		this.hashColumns.put("old_port_tm", 		getOldPortTm());
		this.hashColumns.put("new_port_tm", 		getNewPortTm());
		this.hashColumns.put("vvd", 				getVvd());
		this.hashColumns.put("new_sea_buf_tm", 		getNewSeaBufTm());
		this.hashColumns.put("new_port_buf_tm", 	getNewPortBufTm());		
		this.hashColumns.put("eotp01", 				getEotp01());
		this.hashColumns.put("eotp02", 				getEotp02());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chk_eotp01", 		"chkEotp01");
		this.hashFields.put("chk_eotp02", 		"chkEotp02");
		this.hashFields.put("hist_yr", 			"histYr");
		this.hashFields.put("lnk_spd", 			"lnkSpd");
		this.hashFields.put("sea_buf_hrs", 		"seaBufHrs");
		this.hashFields.put("tml_prod_qty", 	"tmlProdQty");
		this.hashFields.put("pagerows", 		"pagerows");
		this.hashFields.put("max_spd", 			"maxSpd");
		this.hashFields.put("ibflag", 			"ibflag");
		this.hashFields.put("new_sea_tm1", 		"newSeaTm1");
		this.hashFields.put("ib_ipcgo_qty", 	"ibIpcgoQty");
		this.hashFields.put("ob_ipcgo_qty", 	"obIpcgoQty");
		this.hashFields.put("n3rd_vsl_clss_cd", "n3rdVslClssCd");
		this.hashFields.put("ob_ocn_cgo_qty", 	"obOcnCgoQty");
		this.hashFields.put("lnk_dist", 		"lnkDist");
		this.hashFields.put("ib_ocn_cgo_qty", 	"ibOcnCgoQty");
		this.hashFields.put("bf_port_cd", 		"bfPortCd");
		this.hashFields.put("vsl_class", 		"vslClass");
		this.hashFields.put("recovery_tm", 		"recoveryTm");
		this.hashFields.put("act_sail_tm", 		"actSailTm");
		this.hashFields.put("act_spd", 			"actSpd");
		this.hashFields.put("on_tm", 			"onTm");
		this.hashFields.put("to_port_cd", 		"toPortCd");
		this.hashFields.put("n2nd_vsl_clss_cd", "n2ndVslClssCd");
		this.hashFields.put("n1st_vsl_clss_cd", "n1stVslClssCd");
		this.hashFields.put("on_tm_yn", 		"onTmYn");
		this.hashFields.put("old_port_tm", 		"oldPortTm");
		this.hashFields.put("new_port_tm", 		"newPortTm");
		this.hashFields.put("vvd", 				"vvd");
		this.hashFields.put("new_sea_buf_tm", 	"newSeaBufTm");
		this.hashFields.put("eotp01", 			"eotp01");
		this.hashFields.put("eotp02", 			"eotp02");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chkEotp01
	 */
	public String getChkEotp01() {
		return this.chkEotp01;
	}
	
	/**
	 * Column Info
	 * @return chkEotp02
	 */
	public String getChkEotp02() {
		return this.chkEotp02;
	}
	
	/**
	 * Column Info
	 * @return histYr
	 */
	public String getHistYr() {
		return this.histYr;
	}
	
	/**
	 * Column Info
	 * @return lnkSpd
	 */
	public String getLnkSpd() {
		return this.lnkSpd;
	}
	
	/**
	 * Column Info
	 * @return seaBufHrs
	 */
	public String getSeaBufHrs() {
		return this.seaBufHrs;
	}
	
	/**
	 * Column Info
	 * @return tmlProdQty
	 */
	public String getTmlProdQty() {
		return this.tmlProdQty;
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
	 * @return maxSpd
	 */
	public String getMaxSpd() {
		return this.maxSpd;
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
	 * @return newSeaTm1
	 */
	public String getNewSeaTm1() {
		return this.newSeaTm1;
	}
	
	/**
	 * Column Info
	 * @return ibIpcgoQty
	 */
	public String getIbIpcgoQty() {
		return this.ibIpcgoQty;
	}
	
	/**
	 * Column Info
	 * @return obIpcgoQty
	 */
	public String getObIpcgoQty() {
		return this.obIpcgoQty;
	}
	
	/**
	 * Column Info
	 * @return n3rdVslClssCd
	 */
	public String getN3rdVslClssCd() {
		return this.n3rdVslClssCd;
	}
	
	/**
	 * Column Info
	 * @return obOcnCgoQty
	 */
	public String getObOcnCgoQty() {
		return this.obOcnCgoQty;
	}
	
	/**
	 * Column Info
	 * @return lnkDist
	 */
	public String getLnkDist() {
		return this.lnkDist;
	}
	
	/**
	 * Column Info
	 * @return ibOcnCgoQty
	 */
	public String getIbOcnCgoQty() {
		return this.ibOcnCgoQty;
	}
	
	/**
	 * Column Info
	 * @return bfPortCd
	 */
	public String getBfPortCd() {
		return this.bfPortCd;
	}
	
	/**
	 * Column Info
	 * @return class
	 */
	public String getVslClass() {
		return this.vslClass;
	}
	
	/**
	 * Column Info
	 * @return recoveryTm
	 */
	public String getRecoveryTm() {
		return this.recoveryTm;
	}
	
	/**
	 * Column Info
	 * @return actSailTm
	 */
	public String getActSailTm() {
		return this.actSailTm;
	}
	
	/**
	 * Column Info
	 * @return actSpd
	 */
	public String getActSpd() {
		return this.actSpd;
	}
	
	/**
	 * Column Info
	 * @return onTm
	 */
	public String getOnTm() {
		return this.onTm;
	}
	
	/**
	 * Column Info
	 * @return toPortCd
	 */
	public String getToPortCd() {
		return this.toPortCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndVslClssCd
	 */
	public String getN2ndVslClssCd() {
		return this.n2ndVslClssCd;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getN1stVslClssCd() {
		return this.n1stVslClssCd;
	}
	
	/**
	 * Column Info
	 * @return onTmYn
	 */
	public String getOnTmYn() {
		return this.onTmYn;
	}
	
	/**
	 * Column Info
	 * @return oldPortTm
	 */
	public String getOldPortTm() {
		return this.oldPortTm;
	}
	
	/**
	 * Column Info
	 * @return newPortTm
	 */
	public String getNewPortTm() {
		return this.newPortTm;
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
	 * @return newSeaBufTm
	 */
	public String getNewSeaBufTm() {
		return this.newSeaBufTm;
	}
	
	/**
	 * Column Info
	 * @return newPortBufTm
	 */
	public String getNewPortBufTm() {
		return this.newPortBufTm;
	}
	
	/**
	 * Column Info
	 * @return eotp01
	 */
	public String getEotp01() {		
		return this.eotp01;
	}
	
	/**
	 * Column Info
	 * @return eotp02
	 */
	public String getEotp02() {
		return this.eotp02;
	}

	/**
	 * Column Info
	 * @param chkEotp01
	 */
	public void setChkEotp01(String chkEotp01) {
		this.chkEotp01 = chkEotp01;
	}
	
	/**
	 * Column Info
	 * @param chkEotp02
	 */
	public void setChkEotp02(String chkEotp02) {
		this.chkEotp02 = chkEotp02;
	}
	
	/**
	 * Column Info
	 * @param histYr
	 */
	public void setHistYr(String histYr) {
		this.histYr = histYr;
	}
	
	/**
	 * Column Info
	 * @param lnkSpd
	 */
	public void setLnkSpd(String lnkSpd) {
		this.lnkSpd = lnkSpd;
	}
	
	/**
	 * Column Info
	 * @param seaBufHrs
	 */
	public void setSeaBufHrs(String seaBufHrs) {
		this.seaBufHrs = seaBufHrs;
	}
	
	/**
	 * Column Info
	 * @param tmlProdQty
	 */
	public void setTmlProdQty(String tmlProdQty) {
		this.tmlProdQty = tmlProdQty;
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
	 * @param maxSpd
	 */
	public void setMaxSpd(String maxSpd) {
		this.maxSpd = maxSpd;
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
	 * @param newSeaTm1
	 */
	public void setNewSeaTm1(String newSeaTm1) {
		this.newSeaTm1 = newSeaTm1;
	}
	
	/**
	 * Column Info
	 * @param ibIpcgoQty
	 */
	public void setIbIpcgoQty(String ibIpcgoQty) {
		this.ibIpcgoQty = ibIpcgoQty;
	}
	
	/**
	 * Column Info
	 * @param obIpcgoQty
	 */
	public void setObIpcgoQty(String obIpcgoQty) {
		this.obIpcgoQty = obIpcgoQty;
	}
	
	/**
	 * Column Info
	 * @param n3rdVslClssCd
	 */
	public void setN3rdVslClssCd(String n3rdVslClssCd) {
		this.n3rdVslClssCd = n3rdVslClssCd;
	}
	
	/**
	 * Column Info
	 * @param obOcnCgoQty
	 */
	public void setObOcnCgoQty(String obOcnCgoQty) {
		this.obOcnCgoQty = obOcnCgoQty;
	}
	
	/**
	 * Column Info
	 * @param lnkDist
	 */
	public void setLnkDist(String lnkDist) {
		this.lnkDist = lnkDist;
	}
	
	/**
	 * Column Info
	 * @param ibOcnCgoQty
	 */
	public void setIbOcnCgoQty(String ibOcnCgoQty) {
		this.ibOcnCgoQty = ibOcnCgoQty;
	}
	
	/**
	 * Column Info
	 * @param bfPortCd
	 */
	public void setBfPortCd(String bfPortCd) {
		this.bfPortCd = bfPortCd;
	}
	
	/**
	 * Column Info
	 * @param class
	 */
	public void setVslClass(String vslClass) {
		this.vslClass = vslClass;
	}
	
	/**
	 * Column Info
	 * @param recoveryTm
	 */
	public void setRecoveryTm(String recoveryTm) {
		this.recoveryTm = recoveryTm;
	}
	
	/**
	 * Column Info
	 * @param actSailTm
	 */
	public void setActSailTm(String actSailTm) {
		this.actSailTm = actSailTm;
	}
	
	/**
	 * Column Info
	 * @param actSpd
	 */
	public void setActSpd(String actSpd) {
		this.actSpd = actSpd;
	}
	
	/**
	 * Column Info
	 * @param onTm
	 */
	public void setOnTm(String onTm) {
		this.onTm = onTm;
	}
	
	/**
	 * Column Info
	 * @param toPortCd
	 */
	public void setToPortCd(String toPortCd) {
		this.toPortCd = toPortCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndVslClssCd
	 */
	public void setN2ndVslClssCd(String n2ndVslClssCd) {
		this.n2ndVslClssCd = n2ndVslClssCd;
	}
	
	/**
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setN1stVslClssCd(String n1stVslClssCd) {
		this.n1stVslClssCd = n1stVslClssCd;
	}
	
	/**
	 * Column Info
	 * @param onTmYn
	 */
	public void setOnTmYn(String onTmYn) {
		this.onTmYn = onTmYn;
	}
	
	/**
	 * Column Info
	 * @param oldPortTm
	 */
	public void setOldPortTm(String oldPortTm) {
		this.oldPortTm = oldPortTm;
	}
	
	/**
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setNewPortTm(String newPortTm) {
		this.newPortTm = newPortTm;
	}

	/**
	 * Column Info
	 * @return vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @return newSeaBufTm
	 */
	public void setNewSeaBufTm(String newSeaBufTm) {
		this.newSeaBufTm = newSeaBufTm;
	}
	
	/**
	 * Column Info
	 * @return newPortBufTm
	 */
	public void setNewPortBufTm(String newPortBufTm) {
		this.newPortBufTm = newPortBufTm;
	}
	
	/**
	 * Column Info
	 * @return eotp01
	 */
	public void setEotp01(String eotp01) {		
		this.eotp01 = eotp01;
	}
	
	/**
	 * Column Info
	 * @return eotp02
	 */
	public void setEotp02(String eotp02) {
		this.eotp02 = eotp02;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setChkEotp01		(JSPUtil.getParameter(request, "chk_eotp01", ""));
		setChkEotp02		(JSPUtil.getParameter(request, "chk_eotp02", ""));
		setHistYr			(JSPUtil.getParameter(request, "hist_yr", ""));
		setLnkSpd			(JSPUtil.getParameter(request, "lnk_spd", ""));
		setSeaBufHrs		(JSPUtil.getParameter(request, "sea_buf_hrs", ""));
		setTmlProdQty		(JSPUtil.getParameter(request, "tml_prod_qty", ""));
		setPagerows			(JSPUtil.getParameter(request, "pagerows", ""));
		setMaxSpd			(JSPUtil.getParameter(request, "max_spd", ""));
		setIbflag			(JSPUtil.getParameter(request, "ibflag", ""));
		setNewSeaTm1		(JSPUtil.getParameter(request, "new_sea_tm1", ""));
		setIbIpcgoQty		(JSPUtil.getParameter(request, "ib_ipcgo_qty", ""));
		setObIpcgoQty		(JSPUtil.getParameter(request, "ob_ipcgo_qty", ""));
		setN3rdVslClssCd	(JSPUtil.getParameter(request, "n3rd_vsl_clss_cd", ""));
		setObOcnCgoQty		(JSPUtil.getParameter(request, "ob_ocn_cgo_qty", ""));
		setLnkDist			(JSPUtil.getParameter(request, "lnk_dist", ""));
		setIbOcnCgoQty		(JSPUtil.getParameter(request, "ib_ocn_cgo_qty", ""));
		setBfPortCd			(JSPUtil.getParameter(request, "bf_port_cd", ""));
		setVslClass			(JSPUtil.getParameter(request, "vsl_class", ""));
		setRecoveryTm		(JSPUtil.getParameter(request, "recovery_tm", ""));
		setActSailTm		(JSPUtil.getParameter(request, "act_sail_tm", ""));
		setActSpd			(JSPUtil.getParameter(request, "act_spd", ""));
		setOnTm				(JSPUtil.getParameter(request, "on_tm", ""));
		setToPortCd			(JSPUtil.getParameter(request, "to_port_cd", ""));
		setN2ndVslClssCd	(JSPUtil.getParameter(request, "n2nd_vsl_clss_cd", ""));
		setN1stVslClssCd	(JSPUtil.getParameter(request, "n1st_vsl_clss_cd", ""));
		setOnTmYn			(JSPUtil.getParameter(request, "on_tm_yn", ""));
		setOldPortTm		(JSPUtil.getParameter(request, "old_port_tm", ""));
		setNewPortTm		(JSPUtil.getParameter(request, "new_port_tm", ""));
		setVvd				(JSPUtil.getParameter(request, "vvd", ""));
		setNewSeaBufTm		(JSPUtil.getParameter(request, "new_sea_buf_tm", ""));
		setNewPortBufTm		(JSPUtil.getParameter(request, "new_port_buf_tm", ""));
		setEotp01			(JSPUtil.getParameter(request, "eotp01", ""));
		setEotp02			(JSPUtil.getParameter(request, "eotp02", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PfSkdEotpDetailVO[]
	 */
	public PfSkdEotpDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PfSkdEotpDetailVO[]
	 */
	public PfSkdEotpDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PfSkdEotpDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chkEotp01 		= (JSPUtil.getParameter(request, prefix	+ "chk_eotp01", 		length));
			String[] chkEotp02 		= (JSPUtil.getParameter(request, prefix	+ "chk_eotp02", 		length));
			String[] histYr 		= (JSPUtil.getParameter(request, prefix	+ "hist_yr", 			length));
			String[] lnkSpd 		= (JSPUtil.getParameter(request, prefix	+ "lnk_spd", 			length));
			String[] seaBufHrs 		= (JSPUtil.getParameter(request, prefix	+ "sea_buf_hrs", 		length));
			String[] tmlProdQty 	= (JSPUtil.getParameter(request, prefix	+ "tml_prod_qty", 		length));
			String[] pagerows 		= (JSPUtil.getParameter(request, prefix	+ "pagerows", 			length));
			String[] maxSpd 		= (JSPUtil.getParameter(request, prefix	+ "max_spd", 			length));
			String[] ibflag 		= (JSPUtil.getParameter(request, prefix	+ "ibflag", 			length));
			String[] newSeaTm1 		= (JSPUtil.getParameter(request, prefix	+ "new_sea_tm1", 		length));
			String[] ibIpcgoQty 	= (JSPUtil.getParameter(request, prefix	+ "ib_ipcgo_qty", 		length));
			String[] obIpcgoQty 	= (JSPUtil.getParameter(request, prefix	+ "ob_ipcgo_qty", 		length));
			String[] n3rdVslClssCd 	= (JSPUtil.getParameter(request, prefix	+ "n3rd_vsl_clss_cd", 	length));
			String[] obOcnCgoQty 	= (JSPUtil.getParameter(request, prefix	+ "ob_ocn_cgo_qty", 	length));
			String[] lnkDist 		= (JSPUtil.getParameter(request, prefix	+ "lnk_dist", 			length));
			String[] ibOcnCgoQty 	= (JSPUtil.getParameter(request, prefix	+ "ib_ocn_cgo_qty", 	length));
			String[] bfPortCd 		= (JSPUtil.getParameter(request, prefix	+ "bf_port_cd", 		length));
			String[] vslClass 		= (JSPUtil.getParameter(request, prefix	+ "vsl_class", 			length));
			String[] recoveryTm 	= (JSPUtil.getParameter(request, prefix	+ "recovery_tm", 		length));
			String[] actSailTm 		= (JSPUtil.getParameter(request, prefix	+ "act_sail_tm", 		length));
			String[] actSpd 		= (JSPUtil.getParameter(request, prefix	+ "act_spd", 			length));
			String[] onTm 			= (JSPUtil.getParameter(request, prefix	+ "on_tm", 				length));
			String[] toPortCd 		= (JSPUtil.getParameter(request, prefix	+ "to_port_cd", 		length));
			String[] n2ndVslClssCd 	= (JSPUtil.getParameter(request, prefix	+ "n2nd_vsl_clss_cd", 	length));
			String[] n1stVslClssCd 	= (JSPUtil.getParameter(request, prefix	+ "n1st_vsl_clss_cd", 	length));
			String[] onTmYn 		= (JSPUtil.getParameter(request, prefix	+ "on_tm_yn", 			length));
			String[] oldPortTm 		= (JSPUtil.getParameter(request, prefix	+ "old_port_tm", 		length));
			String[] newPortTm 		= (JSPUtil.getParameter(request, prefix	+ "new_port_tm", 		length));
			String[] vvd 			= (JSPUtil.getParameter(request, prefix	+ "vvd", 				length));
			String[] newSeaBufTm	= (JSPUtil.getParameter(request, prefix	+ "new_sea_buf_tm", 	length));
			String[] newPortBufTm	= (JSPUtil.getParameter(request, prefix	+ "new_port_buf_tm", 	length));
			String[] eotp01 		= (JSPUtil.getParameter(request, prefix	+ "eotp01", 			length));
			String[] eotp02 		= (JSPUtil.getParameter(request, prefix	+ "eotp02", 			length));
			
			for (int i = 0; i < length; i++) {
				model = new PfSkdEotpDtlVO();
				if (chkEotp01[i] != null)
					model.setChkEotp01(chkEotp01[i]);
				if (chkEotp02[i] != null)
					model.setChkEotp02(chkEotp02[i]);
				if (histYr[i] != null)
					model.setHistYr(histYr[i]);
				if (lnkSpd[i] != null)
					model.setLnkSpd(lnkSpd[i]);
				if (seaBufHrs[i] != null)
					model.setSeaBufHrs(seaBufHrs[i]);
				if (tmlProdQty[i] != null)
					model.setTmlProdQty(tmlProdQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (maxSpd[i] != null)
					model.setMaxSpd(maxSpd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (newSeaTm1[i] != null)
					model.setNewSeaTm1(newSeaTm1[i]);
				if (ibIpcgoQty[i] != null)
					model.setIbIpcgoQty(ibIpcgoQty[i]);
				if (obIpcgoQty[i] != null)
					model.setObIpcgoQty(obIpcgoQty[i]);
				if (n3rdVslClssCd[i] != null)
					model.setN3rdVslClssCd(n3rdVslClssCd[i]);
				if (obOcnCgoQty[i] != null)
					model.setObOcnCgoQty(obOcnCgoQty[i]);
				if (lnkDist[i] != null)
					model.setLnkDist(lnkDist[i]);
				if (ibOcnCgoQty[i] != null)
					model.setIbOcnCgoQty(ibOcnCgoQty[i]);
				if (bfPortCd[i] != null)
					model.setBfPortCd(bfPortCd[i]);
				if (vslClass[i] != null)
					model.setVslClass(vslClass[i]);
				if (recoveryTm[i] != null)
					model.setRecoveryTm(recoveryTm[i]);
				if (actSailTm[i] != null)
					model.setActSailTm(actSailTm[i]);
				if (actSpd[i] != null)
					model.setActSpd(actSpd[i]);
				if (onTm[i] != null)
					model.setOnTm(onTm[i]);
				if (toPortCd[i] != null)
					model.setToPortCd(toPortCd[i]);
				if (n2ndVslClssCd[i] != null)
					model.setN2ndVslClssCd(n2ndVslClssCd[i]);
				if (n1stVslClssCd[i] != null)
					model.setN1stVslClssCd(n1stVslClssCd[i]);
				if (onTmYn[i] != null)
					model.setOnTmYn(onTmYn[i]);
				if (oldPortTm[i] != null)
					model.setOldPortTm(oldPortTm[i]);
				if (newPortTm[i] != null)
					model.setNewPortTm(newPortTm[i]);				
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (newSeaBufTm[i] != null)
					model.setNewSeaBufTm(newSeaBufTm[i]);
				if (newPortBufTm[i] != null)
					model.setNewPortBufTm(newPortBufTm[i]);
				if (eotp01[i] != null)
					model.setEotp01(eotp01[i]);
				if (eotp02[i] != null)
					model.setEotp02(eotp02[i]);
				
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPfSkdEotpDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PfSkdEotpDetailVO[]
	 */
	public PfSkdEotpDtlVO[] getPfSkdEotpDetailVOs(){
		PfSkdEotpDtlVO[] vos = (PfSkdEotpDtlVO[])models.toArray(new PfSkdEotpDtlVO[models.size()]);
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
		this.chkEotp01 		= this.chkEotp01 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkEotp02 		= this.chkEotp02 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.histYr 		= this.histYr 		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkSpd 		= this.lnkSpd 		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufHrs 		= this.seaBufHrs 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlProdQty 	= this.tmlProdQty 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows 		= this.pagerows 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSpd 		= this.maxSpd 		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag 		= this.ibflag 		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newSeaTm1 		= this.newSeaTm1 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibIpcgoQty 	= this.ibIpcgoQty 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obIpcgoQty 	= this.obIpcgoQty 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVslClssCd 	= this.n3rdVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obOcnCgoQty 	= this.obOcnCgoQty 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDist 		= this.lnkDist 		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibOcnCgoQty 	= this.ibOcnCgoQty 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfPortCd 		= this.bfPortCd 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClass 		= this.vslClass 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recoveryTm 	= this.recoveryTm 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actSailTm 		= this.actSailTm 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actSpd 		= this.actSpd 		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onTm 			= this.onTm 		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPortCd 		= this.toPortCd 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVslClssCd 	= this.n2ndVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVslClssCd 	= this.n1stVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onTmYn 		= this.onTmYn 		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPortTm 		= this.oldPortTm 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPortTm 		= this.newPortTm 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd 			= this.vvd 			.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newSeaBufTm 	= this.newSeaBufTm 	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPortBufTm 	= this.newPortBufTm	.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eotp01 		= this.eotp01 		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eotp02 		= this.eotp02 		.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
