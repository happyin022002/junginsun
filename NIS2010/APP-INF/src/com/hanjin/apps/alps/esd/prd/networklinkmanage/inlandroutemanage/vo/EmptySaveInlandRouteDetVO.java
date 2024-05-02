/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptySaveInlandRouteDetVO.java
*@FileTitle : EmptySaveInlandRouteDetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.25 김귀진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EmptySaveInlandRouteDetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EmptySaveInlandRouteDetVO> models = new ArrayList<EmptySaveInlandRouteDetVO>();
	
	/* Column Info */
	private String ioGb = null;
	/* Column Info */
	private String iRoutDestNodCd = null;
	/* Column Info */
	private String iWrsMtCd = null;
	/* Column Info */
	private String railCrrTpCd = null;
	/* Column Info */
	private String lnkDestType = null;
	/* Column Info */
	private String iRoutOrgNodCd = null;
	/* Column Info */
	private String trspModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String iRoutSeq = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String iRoutPlnCd = null;
	/* Column Info */
	private String iNewRouteCd = null;
	/* Column Info */
	private String lnkDestLoc = null;
	/* Column Info */
	private String inlndRoutCmbFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String wrsChk = null;
	/* Column Info */
	private String lnkOrgType = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String iBkgFlg = null;
	/* Column Info */
	private String iInv = null;
	/* Column Info */
	private String lnkOrgLoc = null;
	/* Column Info */
	private String routDtlSeq = null;
	/* Column Info */
	private String iAgmtSeq = null;
	/* Column Info */
	private String inlndRoutJuncNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String nodTpCd1 = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String nodTpCd2 = null;
	/* Column Info */
	private String rInbound = null;
	/* Column Info */
	private String iRouteRmk = null;
	/* Column Info */
	private String prioSeq = null;
	/* Column Info */
	private String ctyCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EmptySaveInlandRouteDetVO() {}

	public EmptySaveInlandRouteDetVO(String ibflag, String pagerows, String wrsChk, String iRoutSeq, String iRouteRmk, String rInbound, String nodTpCd1, String nodTpCd2, String iInv, String iWrsMtCd, String iBkgFlg, String iNewRouteCd, String iRoutPlnCd, String prioSeq, String routDtlSeq, String ctyCd, String agmtSeq, String iAgmtSeq, String iRoutOrgNodCd, String iRoutDestNodCd, String ioGb, String lnkOrgLoc, String lnkOrgType, String lnkDestLoc, String lnkDestType, String trspModCd, String vndrSeq, String inlndRoutJuncNm, String inlndRoutCmbFlg, String railCrrTpCd, String agmtNo, String creUsrId, String updUsrId, String creOfcCd) {
		this.ioGb = ioGb;
		this.iRoutDestNodCd = iRoutDestNodCd;
		this.iWrsMtCd = iWrsMtCd;
		this.railCrrTpCd = railCrrTpCd;
		this.lnkDestType = lnkDestType;
		this.iRoutOrgNodCd = iRoutOrgNodCd;
		this.trspModCd = trspModCd;
		this.pagerows = pagerows;
		this.iRoutSeq = iRoutSeq;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.iRoutPlnCd = iRoutPlnCd;
		this.iNewRouteCd = iNewRouteCd;
		this.lnkDestLoc = lnkDestLoc;
		this.inlndRoutCmbFlg = inlndRoutCmbFlg;
		this.updUsrId = updUsrId;
		this.wrsChk = wrsChk;
		this.lnkOrgType = lnkOrgType;
		this.agmtSeq = agmtSeq;
		this.agmtNo = agmtNo;
		this.iBkgFlg = iBkgFlg;
		this.iInv = iInv;
		this.lnkOrgLoc = lnkOrgLoc;
		this.routDtlSeq = routDtlSeq;
		this.iAgmtSeq = iAgmtSeq;
		this.inlndRoutJuncNm = inlndRoutJuncNm;
		this.creUsrId = creUsrId;
		this.nodTpCd1 = nodTpCd1;
		this.vndrSeq = vndrSeq;
		this.nodTpCd2 = nodTpCd2;
		this.rInbound = rInbound;
		this.iRouteRmk = iRouteRmk;
		this.prioSeq = prioSeq;
		this.ctyCd = ctyCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("io_gb", getIoGb());
		this.hashColumns.put("i_rout_dest_nod_cd", getIRoutDestNodCd());
		this.hashColumns.put("i_wrs_mt_cd", getIWrsMtCd());
		this.hashColumns.put("rail_crr_tp_cd", getRailCrrTpCd());
		this.hashColumns.put("lnk_dest_type", getLnkDestType());
		this.hashColumns.put("i_rout_org_nod_cd", getIRoutOrgNodCd());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("i_rout_seq", getIRoutSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("i_rout_pln_cd", getIRoutPlnCd());
		this.hashColumns.put("i_new_route_cd", getINewRouteCd());
		this.hashColumns.put("lnk_dest_loc", getLnkDestLoc());
		this.hashColumns.put("inlnd_rout_cmb_flg", getInlndRoutCmbFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("wrs_chk", getWrsChk());
		this.hashColumns.put("lnk_org_type", getLnkOrgType());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("i_bkg_flg", getIBkgFlg());
		this.hashColumns.put("i_inv", getIInv());
		this.hashColumns.put("lnk_org_loc", getLnkOrgLoc());
		this.hashColumns.put("rout_dtl_seq", getRoutDtlSeq());
		this.hashColumns.put("i_agmt_seq", getIAgmtSeq());
		this.hashColumns.put("inlnd_rout_junc_nm", getInlndRoutJuncNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("nod_tp_cd1", getNodTpCd1());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("nod_tp_cd2", getNodTpCd2());
		this.hashColumns.put("r_inbound", getRInbound());
		this.hashColumns.put("i_route_rmk", getIRouteRmk());
		this.hashColumns.put("prio_seq", getPrioSeq());
		this.hashColumns.put("cty_cd", getCtyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("io_gb", "ioGb");
		this.hashFields.put("i_rout_dest_nod_cd", "iRoutDestNodCd");
		this.hashFields.put("i_wrs_mt_cd", "iWrsMtCd");
		this.hashFields.put("rail_crr_tp_cd", "railCrrTpCd");
		this.hashFields.put("lnk_dest_type", "lnkDestType");
		this.hashFields.put("i_rout_org_nod_cd", "iRoutOrgNodCd");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("i_rout_seq", "iRoutSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("i_rout_pln_cd", "iRoutPlnCd");
		this.hashFields.put("i_new_route_cd", "iNewRouteCd");
		this.hashFields.put("lnk_dest_loc", "lnkDestLoc");
		this.hashFields.put("inlnd_rout_cmb_flg", "inlndRoutCmbFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("wrs_chk", "wrsChk");
		this.hashFields.put("lnk_org_type", "lnkOrgType");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("i_bkg_flg", "iBkgFlg");
		this.hashFields.put("i_inv", "iInv");
		this.hashFields.put("lnk_org_loc", "lnkOrgLoc");
		this.hashFields.put("rout_dtl_seq", "routDtlSeq");
		this.hashFields.put("i_agmt_seq", "iAgmtSeq");
		this.hashFields.put("inlnd_rout_junc_nm", "inlndRoutJuncNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("nod_tp_cd1", "nodTpCd1");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("nod_tp_cd2", "nodTpCd2");
		this.hashFields.put("r_inbound", "rInbound");
		this.hashFields.put("i_route_rmk", "iRouteRmk");
		this.hashFields.put("prio_seq", "prioSeq");
		this.hashFields.put("cty_cd", "ctyCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ioGb
	 */
	public String getIoGb() {
		return this.ioGb;
	}
	
	/**
	 * Column Info
	 * @return iRoutDestNodCd
	 */
	public String getIRoutDestNodCd() {
		return this.iRoutDestNodCd;
	}
	
	/**
	 * Column Info
	 * @return iWrsMtCd
	 */
	public String getIWrsMtCd() {
		return this.iWrsMtCd;
	}
	
	/**
	 * Column Info
	 * @return railCrrTpCd
	 */
	public String getRailCrrTpCd() {
		return this.railCrrTpCd;
	}
	
	/**
	 * Column Info
	 * @return lnkDestType
	 */
	public String getLnkDestType() {
		return this.lnkDestType;
	}
	
	/**
	 * Column Info
	 * @return iRoutOrgNodCd
	 */
	public String getIRoutOrgNodCd() {
		return this.iRoutOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
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
	 * @return iRoutSeq
	 */
	public String getIRoutSeq() {
		return this.iRoutSeq;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return iRoutPlnCd
	 */
	public String getIRoutPlnCd() {
		return this.iRoutPlnCd;
	}
	
	/**
	 * Column Info
	 * @return iNewRouteCd
	 */
	public String getINewRouteCd() {
		return this.iNewRouteCd;
	}
	
	/**
	 * Column Info
	 * @return lnkDestLoc
	 */
	public String getLnkDestLoc() {
		return this.lnkDestLoc;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutCmbFlg
	 */
	public String getInlndRoutCmbFlg() {
		return this.inlndRoutCmbFlg;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return wrsChk
	 */
	public String getWrsChk() {
		return this.wrsChk;
	}
	
	/**
	 * Column Info
	 * @return lnkOrgType
	 */
	public String getLnkOrgType() {
		return this.lnkOrgType;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return iBkgFlg
	 */
	public String getIBkgFlg() {
		return this.iBkgFlg;
	}
	
	/**
	 * Column Info
	 * @return iInv
	 */
	public String getIInv() {
		return this.iInv;
	}
	
	/**
	 * Column Info
	 * @return lnkOrgLoc
	 */
	public String getLnkOrgLoc() {
		return this.lnkOrgLoc;
	}
	
	/**
	 * Column Info
	 * @return routDtlSeq
	 */
	public String getRoutDtlSeq() {
		return this.routDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return iAgmtSeq
	 */
	public String getIAgmtSeq() {
		return this.iAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutJuncNm
	 */
	public String getInlndRoutJuncNm() {
		return this.inlndRoutJuncNm;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return nodTpCd1
	 */
	public String getNodTpCd1() {
		return this.nodTpCd1;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return nodTpCd2
	 */
	public String getNodTpCd2() {
		return this.nodTpCd2;
	}
	
	/**
	 * Column Info
	 * @return rInbound
	 */
	public String getRInbound() {
		return this.rInbound;
	}
	
	/**
	 * Column Info
	 * @return iRouteRmk
	 */
	public String getIRouteRmk() {
		return this.iRouteRmk;
	}
	
	/**
	 * Column Info
	 * @return prioSeq
	 */
	public String getPrioSeq() {
		return this.prioSeq;
	}
	
	/**
	 * Column Info
	 * @return ctyCd
	 */
	public String getCtyCd() {
		return this.ctyCd;
	}
	

	/**
	 * Column Info
	 * @param ioGb
	 */
	public void setIoGb(String ioGb) {
		this.ioGb = ioGb;
	}
	
	/**
	 * Column Info
	 * @param iRoutDestNodCd
	 */
	public void setIRoutDestNodCd(String iRoutDestNodCd) {
		this.iRoutDestNodCd = iRoutDestNodCd;
	}
	
	/**
	 * Column Info
	 * @param iWrsMtCd
	 */
	public void setIWrsMtCd(String iWrsMtCd) {
		this.iWrsMtCd = iWrsMtCd;
	}
	
	/**
	 * Column Info
	 * @param railCrrTpCd
	 */
	public void setRailCrrTpCd(String railCrrTpCd) {
		this.railCrrTpCd = railCrrTpCd;
	}
	
	/**
	 * Column Info
	 * @param lnkDestType
	 */
	public void setLnkDestType(String lnkDestType) {
		this.lnkDestType = lnkDestType;
	}
	
	/**
	 * Column Info
	 * @param iRoutOrgNodCd
	 */
	public void setIRoutOrgNodCd(String iRoutOrgNodCd) {
		this.iRoutOrgNodCd = iRoutOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
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
	 * @param iRoutSeq
	 */
	public void setIRoutSeq(String iRoutSeq) {
		this.iRoutSeq = iRoutSeq;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param iRoutPlnCd
	 */
	public void setIRoutPlnCd(String iRoutPlnCd) {
		this.iRoutPlnCd = iRoutPlnCd;
	}
	
	/**
	 * Column Info
	 * @param iNewRouteCd
	 */
	public void setINewRouteCd(String iNewRouteCd) {
		this.iNewRouteCd = iNewRouteCd;
	}
	
	/**
	 * Column Info
	 * @param lnkDestLoc
	 */
	public void setLnkDestLoc(String lnkDestLoc) {
		this.lnkDestLoc = lnkDestLoc;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutCmbFlg
	 */
	public void setInlndRoutCmbFlg(String inlndRoutCmbFlg) {
		this.inlndRoutCmbFlg = inlndRoutCmbFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param wrsChk
	 */
	public void setWrsChk(String wrsChk) {
		this.wrsChk = wrsChk;
	}
	
	/**
	 * Column Info
	 * @param lnkOrgType
	 */
	public void setLnkOrgType(String lnkOrgType) {
		this.lnkOrgType = lnkOrgType;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param iBkgFlg
	 */
	public void setIBkgFlg(String iBkgFlg) {
		this.iBkgFlg = iBkgFlg;
	}
	
	/**
	 * Column Info
	 * @param iInv
	 */
	public void setIInv(String iInv) {
		this.iInv = iInv;
	}
	
	/**
	 * Column Info
	 * @param lnkOrgLoc
	 */
	public void setLnkOrgLoc(String lnkOrgLoc) {
		this.lnkOrgLoc = lnkOrgLoc;
	}
	
	/**
	 * Column Info
	 * @param routDtlSeq
	 */
	public void setRoutDtlSeq(String routDtlSeq) {
		this.routDtlSeq = routDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param iAgmtSeq
	 */
	public void setIAgmtSeq(String iAgmtSeq) {
		this.iAgmtSeq = iAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutJuncNm
	 */
	public void setInlndRoutJuncNm(String inlndRoutJuncNm) {
		this.inlndRoutJuncNm = inlndRoutJuncNm;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param nodTpCd1
	 */
	public void setNodTpCd1(String nodTpCd1) {
		this.nodTpCd1 = nodTpCd1;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param nodTpCd2
	 */
	public void setNodTpCd2(String nodTpCd2) {
		this.nodTpCd2 = nodTpCd2;
	}
	
	/**
	 * Column Info
	 * @param rInbound
	 */
	public void setRInbound(String rInbound) {
		this.rInbound = rInbound;
	}
	
	/**
	 * Column Info
	 * @param iRouteRmk
	 */
	public void setIRouteRmk(String iRouteRmk) {
		this.iRouteRmk = iRouteRmk;
	}
	
	/**
	 * Column Info
	 * @param prioSeq
	 */
	public void setPrioSeq(String prioSeq) {
		this.prioSeq = prioSeq;
	}
	
	/**
	 * Column Info
	 * @param ctyCd
	 */
	public void setCtyCd(String ctyCd) {
		this.ctyCd = ctyCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIoGb(JSPUtil.getParameter(request, "io_gb", ""));
		setIRoutDestNodCd(JSPUtil.getParameter(request, "i_rout_dest_nod_cd", ""));
		setIWrsMtCd(JSPUtil.getParameter(request, "i_wrs_mt_cd", ""));
		setRailCrrTpCd(JSPUtil.getParameter(request, "rail_crr_tp_cd", ""));
		setLnkDestType(JSPUtil.getParameter(request, "lnk_dest_type", ""));
		setIRoutOrgNodCd(JSPUtil.getParameter(request, "i_rout_org_nod_cd", ""));
		setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIRoutSeq(JSPUtil.getParameter(request, "i_rout_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setIRoutPlnCd(JSPUtil.getParameter(request, "i_rout_pln_cd", ""));
		setINewRouteCd(JSPUtil.getParameter(request, "i_new_route_cd", ""));
		setLnkDestLoc(JSPUtil.getParameter(request, "lnk_dest_loc", ""));
		setInlndRoutCmbFlg(JSPUtil.getParameter(request, "inlnd_rout_cmb_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setWrsChk(JSPUtil.getParameter(request, "wrs_chk", ""));
		setLnkOrgType(JSPUtil.getParameter(request, "lnk_org_type", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setIBkgFlg(JSPUtil.getParameter(request, "i_bkg_flg", ""));
		setIInv(JSPUtil.getParameter(request, "i_inv", ""));
		setLnkOrgLoc(JSPUtil.getParameter(request, "lnk_org_loc", ""));
		setRoutDtlSeq(JSPUtil.getParameter(request, "rout_dtl_seq", ""));
		setIAgmtSeq(JSPUtil.getParameter(request, "i_agmt_seq", ""));
		setInlndRoutJuncNm(JSPUtil.getParameter(request, "inlnd_rout_junc_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setNodTpCd1(JSPUtil.getParameter(request, "nod_tp_cd1", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setNodTpCd2(JSPUtil.getParameter(request, "nod_tp_cd2", ""));
		setRInbound(JSPUtil.getParameter(request, "r_inbound", ""));
		setIRouteRmk(JSPUtil.getParameter(request, "i_route_rmk", ""));
		setPrioSeq(JSPUtil.getParameter(request, "prio_seq", ""));
		setCtyCd(JSPUtil.getParameter(request, "cty_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EmptySaveInlandRouteDetVO[]
	 */
	public EmptySaveInlandRouteDetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EmptySaveInlandRouteDetVO[]
	 */
	public EmptySaveInlandRouteDetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EmptySaveInlandRouteDetVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ioGb = (JSPUtil.getParameter(request, prefix	+ "io_gb", length));
			String[] iRoutDestNodCd = (JSPUtil.getParameter(request, prefix	+ "i_rout_dest_nod_cd", length));
			String[] iWrsMtCd = (JSPUtil.getParameter(request, prefix	+ "i_wrs_mt_cd", length));
			String[] railCrrTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_crr_tp_cd", length));
			String[] lnkDestType = (JSPUtil.getParameter(request, prefix	+ "lnk_dest_type", length));
			String[] iRoutOrgNodCd = (JSPUtil.getParameter(request, prefix	+ "i_rout_org_nod_cd", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] iRoutSeq = (JSPUtil.getParameter(request, prefix	+ "i_rout_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] iRoutPlnCd = (JSPUtil.getParameter(request, prefix	+ "i_rout_pln_cd", length));
			String[] iNewRouteCd = (JSPUtil.getParameter(request, prefix	+ "i_new_route_cd", length));
			String[] lnkDestLoc = (JSPUtil.getParameter(request, prefix	+ "lnk_dest_loc", length));
			String[] inlndRoutCmbFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_cmb_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] wrsChk = (JSPUtil.getParameter(request, prefix	+ "wrs_chk", length));
			String[] lnkOrgType = (JSPUtil.getParameter(request, prefix	+ "lnk_org_type", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] iBkgFlg = (JSPUtil.getParameter(request, prefix	+ "i_bkg_flg", length));
			String[] iInv = (JSPUtil.getParameter(request, prefix	+ "i_inv", length));
			String[] lnkOrgLoc = (JSPUtil.getParameter(request, prefix	+ "lnk_org_loc", length));
			String[] routDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rout_dtl_seq", length));
			String[] iAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "i_agmt_seq", length));
			String[] inlndRoutJuncNm = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_junc_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] nodTpCd1 = (JSPUtil.getParameter(request, prefix	+ "nod_tp_cd1", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] nodTpCd2 = (JSPUtil.getParameter(request, prefix	+ "nod_tp_cd2", length));
			String[] rInbound = (JSPUtil.getParameter(request, prefix	+ "r_inbound", length));
			String[] iRouteRmk = (JSPUtil.getParameter(request, prefix	+ "i_route_rmk", length));
			String[] prioSeq = (JSPUtil.getParameter(request, prefix	+ "prio_seq", length));
			String[] ctyCd = (JSPUtil.getParameter(request, prefix	+ "cty_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EmptySaveInlandRouteDetVO();
				if (ioGb[i] != null)
					model.setIoGb(ioGb[i]);
				if (iRoutDestNodCd[i] != null)
					model.setIRoutDestNodCd(iRoutDestNodCd[i]);
				if (iWrsMtCd[i] != null)
					model.setIWrsMtCd(iWrsMtCd[i]);
				if (railCrrTpCd[i] != null)
					model.setRailCrrTpCd(railCrrTpCd[i]);
				if (lnkDestType[i] != null)
					model.setLnkDestType(lnkDestType[i]);
				if (iRoutOrgNodCd[i] != null)
					model.setIRoutOrgNodCd(iRoutOrgNodCd[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (iRoutSeq[i] != null)
					model.setIRoutSeq(iRoutSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (iRoutPlnCd[i] != null)
					model.setIRoutPlnCd(iRoutPlnCd[i]);
				if (iNewRouteCd[i] != null)
					model.setINewRouteCd(iNewRouteCd[i]);
				if (lnkDestLoc[i] != null)
					model.setLnkDestLoc(lnkDestLoc[i]);
				if (inlndRoutCmbFlg[i] != null)
					model.setInlndRoutCmbFlg(inlndRoutCmbFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (wrsChk[i] != null)
					model.setWrsChk(wrsChk[i]);
				if (lnkOrgType[i] != null)
					model.setLnkOrgType(lnkOrgType[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (iBkgFlg[i] != null)
					model.setIBkgFlg(iBkgFlg[i]);
				if (iInv[i] != null)
					model.setIInv(iInv[i]);
				if (lnkOrgLoc[i] != null)
					model.setLnkOrgLoc(lnkOrgLoc[i]);
				if (routDtlSeq[i] != null)
					model.setRoutDtlSeq(routDtlSeq[i]);
				if (iAgmtSeq[i] != null)
					model.setIAgmtSeq(iAgmtSeq[i]);
				if (inlndRoutJuncNm[i] != null)
					model.setInlndRoutJuncNm(inlndRoutJuncNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (nodTpCd1[i] != null)
					model.setNodTpCd1(nodTpCd1[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (nodTpCd2[i] != null)
					model.setNodTpCd2(nodTpCd2[i]);
				if (rInbound[i] != null)
					model.setRInbound(rInbound[i]);
				if (iRouteRmk[i] != null)
					model.setIRouteRmk(iRouteRmk[i]);
				if (prioSeq[i] != null)
					model.setPrioSeq(prioSeq[i]);
				if (ctyCd[i] != null)
					model.setCtyCd(ctyCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEmptySaveInlandRouteDetVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EmptySaveInlandRouteDetVO[]
	 */
	public EmptySaveInlandRouteDetVO[] getEmptySaveInlandRouteDetVOs(){
		EmptySaveInlandRouteDetVO[] vos = (EmptySaveInlandRouteDetVO[])models.toArray(new EmptySaveInlandRouteDetVO[models.size()]);
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
		this.ioGb = this.ioGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRoutDestNodCd = this.iRoutDestNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iWrsMtCd = this.iWrsMtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCrrTpCd = this.railCrrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDestType = this.lnkDestType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRoutOrgNodCd = this.iRoutOrgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRoutSeq = this.iRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRoutPlnCd = this.iRoutPlnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iNewRouteCd = this.iNewRouteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDestLoc = this.lnkDestLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutCmbFlg = this.inlndRoutCmbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrsChk = this.wrsChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkOrgType = this.lnkOrgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iBkgFlg = this.iBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iInv = this.iInv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkOrgLoc = this.lnkOrgLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDtlSeq = this.routDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iAgmtSeq = this.iAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutJuncNm = this.inlndRoutJuncNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodTpCd1 = this.nodTpCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodTpCd2 = this.nodTpCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rInbound = this.rInbound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRouteRmk = this.iRouteRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prioSeq = this.prioSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyCd = this.ctyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
