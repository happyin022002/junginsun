/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SearchEmptyInlandRouteMasterListVO.java
 *@FileTitle : SearchEmptyInlandRouteMasterListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.21
 *@LastModifier : 김귀진
 *@LastVersion : 1.0
 * 2009.08.21 김귀진 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEmptyInlandRouteMasterListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchEmptyInlandRouteMasterListVO> models = new ArrayList<SearchEmptyInlandRouteMasterListVO>();

	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String railCrrTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String wrsMtyCmdtCd = null;
	/* Column Info */
	private String routOrgNodCd = null;
	/* Column Info */
	private String a2Flg = null;
	/* Column Info */
	private String d4Flg = null;
	/* Column Info */
	private String a4Flg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String d5Flg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String o2Flg = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String routDestNodCd = null;
	/* Column Info */
	private String orgLoc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String r5Flg = null;
	/* Column Info */
	private String d2Flg = null;
	/* Column Info */
	private String destLocType = null;
	/* Column Info */
	private String destLoc = null;
	/* Column Info */
	private String routPlnCd = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String inlndRoutJuncNm = null;
	/* Column Info */
	private String inlndRoutInvBilPattCd = null;
	/* Column Info */
	private String inlndRoutRmk = null;
	/* Column Info */
	private String o4Flg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String d7Flg = null;
	/* Column Info */
	private String prioSeq = null;
	/* Column Info */
	private String r2Flg = null;
	/* Column Info */
	private String orgLocType = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchEmptyInlandRouteMasterListVO() {
	}

	public SearchEmptyInlandRouteMasterListVO(String ibflag, String pagerows, String rn, String routOrgNodCd, String routDestNodCd, String orgLoc, String orgLocType, String destLoc,
			String destLocType, String routSeq, String prioSeq, String inlndRoutInvBilPattCd, String routPlnCd, String creUsrId, String creOfcCd, String creDt, String inlndRoutRmk,
			String railCrrTpCd, String inlndRoutJuncNm, String d2Flg, String d4Flg, String d5Flg, String d7Flg, String o2Flg, String o4Flg, String a2Flg, String a4Flg, String r5Flg, String r2Flg,
			String updUsrId, String updDt, String wrsMtyCmdtCd) {
		this.rn = rn;
		this.railCrrTpCd = railCrrTpCd;
		this.creDt = creDt;
		this.wrsMtyCmdtCd = wrsMtyCmdtCd;
		this.routOrgNodCd = routOrgNodCd;
		this.a2Flg = a2Flg;
		this.d4Flg = d4Flg;
		this.a4Flg = a4Flg;
		this.pagerows = pagerows;
		this.d5Flg = d5Flg;
		this.ibflag = ibflag;
		this.o2Flg = o2Flg;
		this.creOfcCd = creOfcCd;
		this.routDestNodCd = routDestNodCd;
		this.orgLoc = orgLoc;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.r5Flg = r5Flg;
		this.d2Flg = d2Flg;
		this.destLocType = destLocType;
		this.destLoc = destLoc;
		this.routPlnCd = routPlnCd;
		this.routSeq = routSeq;
		this.inlndRoutJuncNm = inlndRoutJuncNm;
		this.inlndRoutInvBilPattCd = inlndRoutInvBilPattCd;
		this.inlndRoutRmk = inlndRoutRmk;
		this.o4Flg = o4Flg;
		this.creUsrId = creUsrId;
		this.d7Flg = d7Flg;
		this.prioSeq = prioSeq;
		this.r2Flg = r2Flg;
		this.orgLocType = orgLocType;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("rail_crr_tp_cd", getRailCrrTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("wrs_mty_cmdt_cd", getWrsMtyCmdtCd());
		this.hashColumns.put("rout_org_nod_cd", getRoutOrgNodCd());
		this.hashColumns.put("a2_flg", getA2Flg());
		this.hashColumns.put("d4_flg", getD4Flg());
		this.hashColumns.put("a4_flg", getA4Flg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("d5_flg", getD5Flg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("o2_flg", getO2Flg());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("rout_dest_nod_cd", getRoutDestNodCd());
		this.hashColumns.put("org_loc", getOrgLoc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("r5_flg", getR5Flg());
		this.hashColumns.put("d2_flg", getD2Flg());
		this.hashColumns.put("dest_loc_type", getDestLocType());
		this.hashColumns.put("dest_loc", getDestLoc());
		this.hashColumns.put("rout_pln_cd", getRoutPlnCd());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("inlnd_rout_junc_nm", getInlndRoutJuncNm());
		this.hashColumns.put("inlnd_rout_inv_bil_patt_cd", getInlndRoutInvBilPattCd());
		this.hashColumns.put("inlnd_rout_rmk", getInlndRoutRmk());
		this.hashColumns.put("o4_flg", getO4Flg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("d7_flg", getD7Flg());
		this.hashColumns.put("prio_seq", getPrioSeq());
		this.hashColumns.put("r2_flg", getR2Flg());
		this.hashColumns.put("org_loc_type", getOrgLocType());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("rn", "rn");
		this.hashFields.put("rail_crr_tp_cd", "railCrrTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("wrs_mty_cmdt_cd", "wrsMtyCmdtCd");
		this.hashFields.put("rout_org_nod_cd", "routOrgNodCd");
		this.hashFields.put("a2_flg", "a2Flg");
		this.hashFields.put("d4_flg", "d4Flg");
		this.hashFields.put("a4_flg", "a4Flg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("d5_flg", "d5Flg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("o2_flg", "o2Flg");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("rout_dest_nod_cd", "routDestNodCd");
		this.hashFields.put("org_loc", "orgLoc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("r5_flg", "r5Flg");
		this.hashFields.put("d2_flg", "d2Flg");
		this.hashFields.put("dest_loc_type", "destLocType");
		this.hashFields.put("dest_loc", "destLoc");
		this.hashFields.put("rout_pln_cd", "routPlnCd");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("inlnd_rout_junc_nm", "inlndRoutJuncNm");
		this.hashFields.put("inlnd_rout_inv_bil_patt_cd", "inlndRoutInvBilPattCd");
		this.hashFields.put("inlnd_rout_rmk", "inlndRoutRmk");
		this.hashFields.put("o4_flg", "o4Flg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("d7_flg", "d7Flg");
		this.hashFields.put("prio_seq", "prioSeq");
		this.hashFields.put("r2_flg", "r2Flg");
		this.hashFields.put("org_loc_type", "orgLocType");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}

	/**
	 * Column Info
	 * @return routOrgNodCd
	 */
	public String getRoutOrgNodCd() {
		return this.routOrgNodCd;
	}

	/**
	 * Column Info
	 * @return a2Flg
	 */
	public String getA2Flg() {
		return this.a2Flg;
	}

	/**
	 * Column Info
	 * @return d4Flg
	 */
	public String getD4Flg() {
		return this.d4Flg;
	}

	/**
	 * Column Info
	 * @return a4Flg
	 */
	public String getA4Flg() {
		return this.a4Flg;
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
	 * @return d5Flg
	 */
	public String getD5Flg() {
		return this.d5Flg;
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
	 * @return o2Flg
	 */
	public String getO2Flg() {
		return this.o2Flg;
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
	 * @return routDestNodCd
	 */
	public String getRoutDestNodCd() {
		return this.routDestNodCd;
	}

	/**
	 * Column Info
	 * @return orgLoc
	 */
	public String getOrgLoc() {
		return this.orgLoc;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * Column Info
	 * @return r5Flg
	 */
	public String getR5Flg() {
		return this.r5Flg;
	}

	/**
	 * Column Info
	 * @return d2Flg
	 */
	public String getD2Flg() {
		return this.d2Flg;
	}

	/**
	 * Column Info
	 * @return destLocType
	 */
	public String getDestLocType() {
		return this.destLocType;
	}

	/**
	 * Column Info
	 * @return destLoc
	 */
	public String getDestLoc() {
		return this.destLoc;
	}

	/**
	 * Column Info
	 * @return routPlnCd
	 */
	public String getRoutPlnCd() {
		return this.routPlnCd;
	}

	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
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
	 * @return inlndRoutInvBilPattCd
	 */
	public String getInlndRoutInvBilPattCd() {
		return this.inlndRoutInvBilPattCd;
	}

	/**
	 * Column Info
	 * @return inlndRoutRmk
	 */
	public String getInlndRoutRmk() {
		return this.inlndRoutRmk;
	}

	/**
	 * Column Info
	 * @return o4Flg
	 */
	public String getO4Flg() {
		return this.o4Flg;
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
	 * @return d7Flg
	 */
	public String getD7Flg() {
		return this.d7Flg;
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
	 * @return r2Flg
	 */
	public String getR2Flg() {
		return this.r2Flg;
	}

	/**
	 * Column Info
	 * @return orgLocType
	 */
	public String getOrgLocType() {
		return this.orgLocType;
	}

	/**
	 * Column Info
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * Column Info
	 * @param routOrgNodCd
	 */
	public void setRoutOrgNodCd(String routOrgNodCd) {
		this.routOrgNodCd = routOrgNodCd;
	}

	/**
	 * Column Info
	 * @param a2Flg
	 */
	public void setA2Flg(String a2Flg) {
		this.a2Flg = a2Flg;
	}

	/**
	 * Column Info
	 * @param d4Flg
	 */
	public void setD4Flg(String d4Flg) {
		this.d4Flg = d4Flg;
	}

	/**
	 * Column Info
	 * @param a4Flg
	 */
	public void setA4Flg(String a4Flg) {
		this.a4Flg = a4Flg;
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
	 * @param d5Flg
	 */
	public void setD5Flg(String d5Flg) {
		this.d5Flg = d5Flg;
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
	 * @param o2Flg
	 */
	public void setO2Flg(String o2Flg) {
		this.o2Flg = o2Flg;
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
	 * @param routDestNodCd
	 */
	public void setRoutDestNodCd(String routDestNodCd) {
		this.routDestNodCd = routDestNodCd;
	}

	/**
	 * Column Info
	 * @param orgLoc
	 */
	public void setOrgLoc(String orgLoc) {
		this.orgLoc = orgLoc;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * @param r5Flg
	 */
	public void setR5Flg(String r5Flg) {
		this.r5Flg = r5Flg;
	}

	/**
	 * Column Info
	 * @param d2Flg
	 */
	public void setD2Flg(String d2Flg) {
		this.d2Flg = d2Flg;
	}

	/**
	 * Column Info
	 * @param destLocType
	 */
	public void setDestLocType(String destLocType) {
		this.destLocType = destLocType;
	}

	/**
	 * Column Info
	 * @param destLoc
	 */
	public void setDestLoc(String destLoc) {
		this.destLoc = destLoc;
	}

	/**
	 * Column Info
	 * @param routPlnCd
	 */
	public void setRoutPlnCd(String routPlnCd) {
		this.routPlnCd = routPlnCd;
	}

	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
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
	 * @param inlndRoutInvBilPattCd
	 */
	public void setInlndRoutInvBilPattCd(String inlndRoutInvBilPattCd) {
		this.inlndRoutInvBilPattCd = inlndRoutInvBilPattCd;
	}

	/**
	 * Column Info
	 * @param inlndRoutRmk
	 */
	public void setInlndRoutRmk(String inlndRoutRmk) {
		this.inlndRoutRmk = inlndRoutRmk;
	}

	/**
	 * Column Info
	 * @param o4Flg
	 */
	public void setO4Flg(String o4Flg) {
		this.o4Flg = o4Flg;
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
	 * @param d7Flg
	 */
	public void setD7Flg(String d7Flg) {
		this.d7Flg = d7Flg;
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
	 * @param r2Flg
	 */
	public void setR2Flg(String r2Flg) {
		this.r2Flg = r2Flg;
	}

	/**
	 * Column Info
	 * @param orgLocType
	 */
	public void setOrgLocType(String orgLocType) {
		this.orgLocType = orgLocType;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getWrsMtyCmdtCd() {
		return wrsMtyCmdtCd;
	}

	/**
	 * Column Info
	 * @param wrsMtyCmdtCd
	 */
	public void setWrsMtyCmdtCd(String wrsMtyCmdtCd) {
		this.wrsMtyCmdtCd = wrsMtyCmdtCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRn(JSPUtil.getParameter(request, "rn", ""));
		setRailCrrTpCd(JSPUtil.getParameter(request, "rail_crr_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setWrsMtyCmdtCd(JSPUtil.getParameter(request, "wrs_mty_cmdt_cd", ""));
		setRoutOrgNodCd(JSPUtil.getParameter(request, "rout_org_nod_cd", ""));
		setA2Flg(JSPUtil.getParameter(request, "a2_flg", ""));
		setD4Flg(JSPUtil.getParameter(request, "d4_flg", ""));
		setA4Flg(JSPUtil.getParameter(request, "a4_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setD5Flg(JSPUtil.getParameter(request, "d5_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setO2Flg(JSPUtil.getParameter(request, "o2_flg", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setRoutDestNodCd(JSPUtil.getParameter(request, "rout_dest_nod_cd", ""));
		setOrgLoc(JSPUtil.getParameter(request, "org_loc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setR5Flg(JSPUtil.getParameter(request, "r5_flg", ""));
		setD2Flg(JSPUtil.getParameter(request, "d2_flg", ""));
		setDestLocType(JSPUtil.getParameter(request, "dest_loc_type", ""));
		setDestLoc(JSPUtil.getParameter(request, "dest_loc", ""));
		setRoutPlnCd(JSPUtil.getParameter(request, "rout_pln_cd", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setInlndRoutJuncNm(JSPUtil.getParameter(request, "inlnd_rout_junc_nm", ""));
		setInlndRoutInvBilPattCd(JSPUtil.getParameter(request, "inlnd_rout_inv_bil_patt_cd", ""));
		setInlndRoutRmk(JSPUtil.getParameter(request, "inlnd_rout_rmk", ""));
		setO4Flg(JSPUtil.getParameter(request, "o4_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setD7Flg(JSPUtil.getParameter(request, "d7_flg", ""));
		setPrioSeq(JSPUtil.getParameter(request, "prio_seq", ""));
		setR2Flg(JSPUtil.getParameter(request, "r2_flg", ""));
		setOrgLocType(JSPUtil.getParameter(request, "org_loc_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEmptyInlandRouteMasterListVO[]
	 */
	public SearchEmptyInlandRouteMasterListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchEmptyInlandRouteMasterListVO[]
	 */
	public SearchEmptyInlandRouteMasterListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEmptyInlandRouteMasterListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] rn = (JSPUtil.getParameter(request, prefix + "rn", length));
			String[] railCrrTpCd = (JSPUtil.getParameter(request, prefix + "rail_crr_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
			String[] wrsMtyCmdtCd = (JSPUtil.getParameter(request, prefix + "wrs_mty_cmdt_cd", length));
			String[] routOrgNodCd = (JSPUtil.getParameter(request, prefix + "rout_org_nod_cd", length));
			String[] a2Flg = (JSPUtil.getParameter(request, prefix + "a2_flg", length));
			String[] d4Flg = (JSPUtil.getParameter(request, prefix + "d4_flg", length));
			String[] a4Flg = (JSPUtil.getParameter(request, prefix + "a4_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] d5Flg = (JSPUtil.getParameter(request, prefix + "d5_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] o2Flg = (JSPUtil.getParameter(request, prefix + "o2_flg", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
			String[] routDestNodCd = (JSPUtil.getParameter(request, prefix + "rout_dest_nod_cd", length));
			String[] orgLoc = (JSPUtil.getParameter(request, prefix + "org_loc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
			String[] r5Flg = (JSPUtil.getParameter(request, prefix + "r5_flg", length));
			String[] d2Flg = (JSPUtil.getParameter(request, prefix + "d2_flg", length));
			String[] destLocType = (JSPUtil.getParameter(request, prefix + "dest_loc_type", length));
			String[] destLoc = (JSPUtil.getParameter(request, prefix + "dest_loc", length));
			String[] routPlnCd = (JSPUtil.getParameter(request, prefix + "rout_pln_cd", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix + "rout_seq", length));
			String[] inlndRoutJuncNm = (JSPUtil.getParameter(request, prefix + "inlnd_rout_junc_nm", length));
			String[] inlndRoutInvBilPattCd = (JSPUtil.getParameter(request, prefix + "inlnd_rout_inv_bil_patt_cd", length));
			String[] inlndRoutRmk = (JSPUtil.getParameter(request, prefix + "inlnd_rout_rmk", length));
			String[] o4Flg = (JSPUtil.getParameter(request, prefix + "o4_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
			String[] d7Flg = (JSPUtil.getParameter(request, prefix + "d7_flg", length));
			String[] prioSeq = (JSPUtil.getParameter(request, prefix + "prio_seq", length));
			String[] r2Flg = (JSPUtil.getParameter(request, prefix + "r2_flg", length));
			String[] orgLocType = (JSPUtil.getParameter(request, prefix + "org_loc_type", length));

			for (int i = 0; i < length; i++) {
				model = new SearchEmptyInlandRouteMasterListVO();
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (railCrrTpCd[i] != null)
					model.setRailCrrTpCd(railCrrTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (wrsMtyCmdtCd[i] != null)
					model.setWrsMtyCmdtCd(wrsMtyCmdtCd[i]);
				if (routOrgNodCd[i] != null)
					model.setRoutOrgNodCd(routOrgNodCd[i]);
				if (a2Flg[i] != null)
					model.setA2Flg(a2Flg[i]);
				if (d4Flg[i] != null)
					model.setD4Flg(d4Flg[i]);
				if (a4Flg[i] != null)
					model.setA4Flg(a4Flg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (d5Flg[i] != null)
					model.setD5Flg(d5Flg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (o2Flg[i] != null)
					model.setO2Flg(o2Flg[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (routDestNodCd[i] != null)
					model.setRoutDestNodCd(routDestNodCd[i]);
				if (orgLoc[i] != null)
					model.setOrgLoc(orgLoc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (r5Flg[i] != null)
					model.setR5Flg(r5Flg[i]);
				if (d2Flg[i] != null)
					model.setD2Flg(d2Flg[i]);
				if (destLocType[i] != null)
					model.setDestLocType(destLocType[i]);
				if (destLoc[i] != null)
					model.setDestLoc(destLoc[i]);
				if (routPlnCd[i] != null)
					model.setRoutPlnCd(routPlnCd[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (inlndRoutJuncNm[i] != null)
					model.setInlndRoutJuncNm(inlndRoutJuncNm[i]);
				if (inlndRoutInvBilPattCd[i] != null)
					model.setInlndRoutInvBilPattCd(inlndRoutInvBilPattCd[i]);
				if (inlndRoutRmk[i] != null)
					model.setInlndRoutRmk(inlndRoutRmk[i]);
				if (o4Flg[i] != null)
					model.setO4Flg(o4Flg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (d7Flg[i] != null)
					model.setD7Flg(d7Flg[i]);
				if (prioSeq[i] != null)
					model.setPrioSeq(prioSeq[i]);
				if (r2Flg[i] != null)
					model.setR2Flg(r2Flg[i]);
				if (orgLocType[i] != null)
					model.setOrgLocType(orgLocType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEmptyInlandRouteMasterListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEmptyInlandRouteMasterListVO[]
	 */
	public SearchEmptyInlandRouteMasterListVO[] getSearchEmptyInlandRouteMasterListVOs() {
		SearchEmptyInlandRouteMasterListVO[] vos = (SearchEmptyInlandRouteMasterListVO[]) models.toArray(new SearchEmptyInlandRouteMasterListVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
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
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = null;
		}
		return arr;
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.rn = this.rn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCrrTpCd = this.railCrrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrsMtyCmdtCd = this.wrsMtyCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routOrgNodCd = this.routOrgNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2Flg = this.a2Flg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Flg = this.d4Flg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4Flg = this.a4Flg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Flg = this.d5Flg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2Flg = this.o2Flg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDestNodCd = this.routDestNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLoc = this.orgLoc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5Flg = this.r5Flg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Flg = this.d2Flg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocType = this.destLocType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLoc = this.destLoc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPlnCd = this.routPlnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutJuncNm = this.inlndRoutJuncNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutInvBilPattCd = this.inlndRoutInvBilPattCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutRmk = this.inlndRoutRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4Flg = this.o4Flg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Flg = this.d7Flg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prioSeq = this.prioSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2Flg = this.r2Flg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLocType = this.orgLocType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
