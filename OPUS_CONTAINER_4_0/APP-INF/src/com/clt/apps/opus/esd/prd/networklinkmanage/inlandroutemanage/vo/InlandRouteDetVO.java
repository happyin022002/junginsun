/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : InlandRouteDetVO.java
 *@FileTitle : InlandRouteDetVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.03
 *@LastModifier : 김귀진
 *@LastVersion : 1.0
 * 2009.08.03 김귀진 
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

public class InlandRouteDetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<InlandRouteDetVO> models = new ArrayList<InlandRouteDetVO>();

	/* Column Info */
	private String lnkDestType = null;
	/* Column Info */
	private String iFrontGb = null;
	/* Column Info */
	private String iSelrow = null;
	/* Column Info */
	private String iUndefineNod = null;
	/* Column Info */
	private String routOrgNodCd = null;
	/* Column Info */
	private String tztmHrs = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String lnkOrgNodCd = null;
	/* Column Info */
	private String mcntrRoutFlg = null;
	/* Column Info */
	private String lnkDestLoc = null;
	/* Column Info */
	private String distUtCd = null;
	/* Column Info */
	private String lnkOrgType = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String lnkDestNodCd = null;
	/* Column Info */
	private String lnkDist = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String sumTtTime = null;
	/* Column Info */
	private String lnkOrgLoc = null;
	/* Column Info */
	private String routDtlSeq = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String trspAgmtSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String cc = null;
	/* Column Info */
	private String inlndRoutBkgFlg = null;
	/* Column Info */
	private String iNewroutecd = null;
	/* Column Info */
	private String iRoutDestNodCd = null;
	/* Column Info */
	private String railCrrTpCd = null;
	/* Column Info */
	private String iRoutOrgNodCd = null;
	/* Column Info */
	private String iHubSearchGb = null;
	/* Column Info */
	private String trspAgmtOfcCtyCd = null;
	/* Column Info */
	private String trspModCd = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String iRoutSeq = null;
	/* Column Info */
	private String disableBkgFlg = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String routDestNodCd = null;
	/* Column Info */
	private String inlndRoutCmbFlg = null;
	/* Column Info */
	private String prioSeqCombo = null;
	/* Column Info */
	private String fmtTztmHrs = null;
	/* Column Info */
	private String cnt = null;
	/* Column Info */
	private String routPlnCd = null;
	/* Column Info */
	private String inlndRoutJuncNm = null;
	/* Column Info */
	private String fc = null;
	/* Column Info */
	private String inlndRoutInvBilPattCd = null;
	/* Column Info */
	private String inlndRoutRmk = null;
	/* Column Info */
	private String prioSeq = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String expToDt = null;

	/* Column Info */
	private String agreeRate = null;
	/* Column Info */
	private String wrsFullCmdtCd = null;
	/* Column Info */
	private String wrsMtyCmdtCd = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public InlandRouteDetVO() {
	}

	public InlandRouteDetVO(String ibflag, String pagerows, String routOrgNodCd, String routDestNodCd, String routSeq, String prioSeq, String lnkOrgNodCd, String lnkDestNodCd, String routDtlSeq,
			String trspModCd, String lnkOrgLoc, String lnkOrgType, String lnkDestLoc, String lnkDestType, String cnt, String sumTtTime, String vndrSeq, String lnkDist, String distUtCd,
			String creOfcCd, String railCrrTpCd, String inlndRoutInvBilPattCd, String routPlnCd, String mcntrRoutFlg, String tztmHrs, String inlndRoutRmk, String inlndRoutCmbFlg, String vndrAbbrNm,
			String inlndRoutJuncNm, String fmtTztmHrs, String fc, String cc, String inlndRoutBkgFlg, String trspAgmtOfcCtyCd, String trspAgmtSeq, String agmtNo, String agmtRefNo,
			String iRoutOrgNodCd, String iRoutDestNodCd, String iRoutSeq, String iHubSearchGb, String iFrontGb, String iUndefineNod, String iNewroutecd, String iSelrow, String disableBkgFlg,
			String prioSeqCombo, String currCd, String agreeRate, String expToDt, String wrsFullCmdtCd, String wrsMtyCmdtCd) {
		this.lnkDestType = lnkDestType;
		this.iFrontGb = iFrontGb;
		this.iSelrow = iSelrow;
		this.iUndefineNod = iUndefineNod;
		this.routOrgNodCd = routOrgNodCd;
		this.tztmHrs = tztmHrs;
		this.pagerows = pagerows;
		this.lnkOrgNodCd = lnkOrgNodCd;
		this.mcntrRoutFlg = mcntrRoutFlg;
		this.lnkDestLoc = lnkDestLoc;
		this.distUtCd = distUtCd;
		this.lnkOrgType = lnkOrgType;
		this.agmtRefNo = agmtRefNo;
		this.lnkDestNodCd = lnkDestNodCd;
		this.lnkDist = lnkDist;
		this.agmtNo = agmtNo;
		this.sumTtTime = sumTtTime;
		this.lnkOrgLoc = lnkOrgLoc;
		this.routDtlSeq = routDtlSeq;
		this.routSeq = routSeq;
		this.trspAgmtSeq = trspAgmtSeq;
		this.vndrSeq = vndrSeq;
		this.vndrAbbrNm = vndrAbbrNm;
		this.cc = cc;
		this.inlndRoutBkgFlg = inlndRoutBkgFlg;
		this.iNewroutecd = iNewroutecd;
		this.iRoutDestNodCd = iRoutDestNodCd;
		this.railCrrTpCd = railCrrTpCd;
		this.iRoutOrgNodCd = iRoutOrgNodCd;
		this.iHubSearchGb = iHubSearchGb;
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
		this.trspModCd = trspModCd;
		this.ibflag = ibflag;
		this.iRoutSeq = iRoutSeq;
		this.disableBkgFlg = disableBkgFlg;
		this.creOfcCd = creOfcCd;
		this.routDestNodCd = routDestNodCd;
		this.inlndRoutCmbFlg = inlndRoutCmbFlg;
		this.prioSeqCombo = prioSeqCombo;
		this.fmtTztmHrs = fmtTztmHrs;
		this.cnt = cnt;
		this.routPlnCd = routPlnCd;
		this.inlndRoutJuncNm = inlndRoutJuncNm;
		this.fc = fc;
		this.inlndRoutInvBilPattCd = inlndRoutInvBilPattCd;
		this.inlndRoutRmk = inlndRoutRmk;
		this.prioSeq = prioSeq;

		this.agreeRate = agreeRate;
		this.currCd = currCd;
		this.expToDt = expToDt;
		this.wrsFullCmdtCd = wrsFullCmdtCd;
		this.wrsMtyCmdtCd = wrsMtyCmdtCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("lnk_dest_type", getLnkDestType());
		this.hashColumns.put("i_front_gb", getIFrontGb());
		this.hashColumns.put("i_selrow", getISelrow());
		this.hashColumns.put("i_undefine_nod", getIUndefineNod());
		this.hashColumns.put("rout_org_nod_cd", getRoutOrgNodCd());
		this.hashColumns.put("tztm_hrs", getTztmHrs());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lnk_org_nod_cd", getLnkOrgNodCd());
		this.hashColumns.put("mcntr_rout_flg", getMcntrRoutFlg());
		this.hashColumns.put("lnk_dest_loc", getLnkDestLoc());
		this.hashColumns.put("dist_ut_cd", getDistUtCd());
		this.hashColumns.put("lnk_org_type", getLnkOrgType());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("lnk_dest_nod_cd", getLnkDestNodCd());
		this.hashColumns.put("lnk_dist", getLnkDist());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("sum_tt_time", getSumTtTime());
		this.hashColumns.put("lnk_org_loc", getLnkOrgLoc());
		this.hashColumns.put("rout_dtl_seq", getRoutDtlSeq());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("trsp_agmt_seq", getTrspAgmtSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("cc", getCc());
		this.hashColumns.put("inlnd_rout_bkg_flg", getInlndRoutBkgFlg());
		this.hashColumns.put("i_newroutecd", getINewroutecd());
		this.hashColumns.put("i_rout_dest_nod_cd", getIRoutDestNodCd());
		this.hashColumns.put("rail_crr_tp_cd", getRailCrrTpCd());
		this.hashColumns.put("i_rout_org_nod_cd", getIRoutOrgNodCd());
		this.hashColumns.put("i_hub_search_gb", getIHubSearchGb());
		this.hashColumns.put("trsp_agmt_ofc_cty_cd", getTrspAgmtOfcCtyCd());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("i_rout_seq", getIRoutSeq());
		this.hashColumns.put("disable_bkg_flg", getDisableBkgFlg());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("rout_dest_nod_cd", getRoutDestNodCd());
		this.hashColumns.put("inlnd_rout_cmb_flg", getInlndRoutCmbFlg());
		this.hashColumns.put("prio_seq_combo", getPrioSeqCombo());
		this.hashColumns.put("fmt_tztm_hrs", getFmtTztmHrs());
		this.hashColumns.put("cnt", getCnt());
		this.hashColumns.put("rout_pln_cd", getRoutPlnCd());
		this.hashColumns.put("inlnd_rout_junc_nm", getInlndRoutJuncNm());
		this.hashColumns.put("fc", getFc());
		this.hashColumns.put("inlnd_rout_inv_bil_patt_cd", getInlndRoutInvBilPattCd());
		this.hashColumns.put("inlnd_rout_rmk", getInlndRoutRmk());
		this.hashColumns.put("prio_seq", getPrioSeq());

		this.hashColumns.put("agree_rate", getAgreeRate());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("exp_to_dt", getExpToDt());
		this.hashColumns.put("wrs_full_cmdt_cd", getWrsFullCmdtCd());
		this.hashColumns.put("wrs_mty_cmdt_cd", getWrsMtyCmdtCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("lnk_dest_type", "lnkDestType");
		this.hashFields.put("i_front_gb", "iFrontGb");
		this.hashFields.put("i_selrow", "iSelrow");
		this.hashFields.put("i_undefine_nod", "iUndefineNod");
		this.hashFields.put("rout_org_nod_cd", "routOrgNodCd");
		this.hashFields.put("tztm_hrs", "tztmHrs");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lnk_org_nod_cd", "lnkOrgNodCd");
		this.hashFields.put("mcntr_rout_flg", "mcntrRoutFlg");
		this.hashFields.put("lnk_dest_loc", "lnkDestLoc");
		this.hashFields.put("dist_ut_cd", "distUtCd");
		this.hashFields.put("lnk_org_type", "lnkOrgType");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("lnk_dest_nod_cd", "lnkDestNodCd");
		this.hashFields.put("lnk_dist", "lnkDist");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("sum_tt_time", "sumTtTime");
		this.hashFields.put("lnk_org_loc", "lnkOrgLoc");
		this.hashFields.put("rout_dtl_seq", "routDtlSeq");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("trsp_agmt_seq", "trspAgmtSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("cc", "cc");
		this.hashFields.put("inlnd_rout_bkg_flg", "inlndRoutBkgFlg");
		this.hashFields.put("i_newroutecd", "iNewroutecd");
		this.hashFields.put("i_rout_dest_nod_cd", "iRoutDestNodCd");
		this.hashFields.put("rail_crr_tp_cd", "railCrrTpCd");
		this.hashFields.put("i_rout_org_nod_cd", "iRoutOrgNodCd");
		this.hashFields.put("i_hub_search_gb", "iHubSearchGb");
		this.hashFields.put("trsp_agmt_ofc_cty_cd", "trspAgmtOfcCtyCd");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("i_rout_seq", "iRoutSeq");
		this.hashFields.put("disable_bkg_flg", "disableBkgFlg");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("rout_dest_nod_cd", "routDestNodCd");
		this.hashFields.put("inlnd_rout_cmb_flg", "inlndRoutCmbFlg");
		this.hashFields.put("prio_seq_combo", "prioSeqCombo");
		this.hashFields.put("fmt_tztm_hrs", "fmtTztmHrs");
		this.hashFields.put("cnt", "cnt");
		this.hashFields.put("rout_pln_cd", "routPlnCd");
		this.hashFields.put("inlnd_rout_junc_nm", "inlndRoutJuncNm");
		this.hashFields.put("fc", "fc");
		this.hashFields.put("inlnd_rout_inv_bil_patt_cd", "inlndRoutInvBilPattCd");
		this.hashFields.put("inlnd_rout_rmk", "inlndRoutRmk");
		this.hashFields.put("prio_seq", "prioSeq");
		this.hashFields.put("agree_rate", "agreeRate");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("exp_to_dt", "expToDt");
		this.hashFields.put("wrs_full_cmdt_cd", "wrsFullCmdtCd");
		this.hashFields.put("wrs_mty_cmdt_cd", "wrsMtyCmdtCd");
		return this.hashFields;
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
	 * @return iFrontGb
	 */
	public String getIFrontGb() {
		return this.iFrontGb;
	}

	/**
	 * Column Info
	 * @return iSelrow
	 */
	public String getISelrow() {
		return this.iSelrow;
	}

	/**
	 * Column Info
	 * @return iUndefineNod
	 */
	public String getIUndefineNod() {
		return this.iUndefineNod;
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
	 * @return tztmHrs
	 */
	public String getTztmHrs() {
		return this.tztmHrs;
	}

	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * @return lnkOrgNodCd
	 */
	public String getLnkOrgNodCd() {
		return this.lnkOrgNodCd;
	}

	/**
	 * Column Info
	 * @return mcntrRoutFlg
	 */
	public String getMcntrRoutFlg() {
		return this.mcntrRoutFlg;
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
	 * @return distUtCd
	 */
	public String getDistUtCd() {
		return this.distUtCd;
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
	 * @return agmtRefNo
	 */
	public String getAgmtRefNo() {
		return this.agmtRefNo;
	}

	/**
	 * Column Info
	 * @return lnkDestNodCd
	 */
	public String getLnkDestNodCd() {
		return this.lnkDestNodCd;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}

	/**
	 * Column Info
	 * @return sumTtTime
	 */
	public String getSumTtTime() {
		return this.sumTtTime;
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
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}

	/**
	 * Column Info
	 * @return trspAgmtSeq
	 */
	public String getTrspAgmtSeq() {
		return this.trspAgmtSeq;
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
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}

	/**
	 * Column Info
	 * @return cc
	 */
	public String getCc() {
		return this.cc;
	}

	/**
	 * Column Info
	 * @return inlndRoutBkgFlg
	 */
	public String getInlndRoutBkgFlg() {
		return this.inlndRoutBkgFlg;
	}

	/**
	 * Column Info
	 * @return iNewroutecd
	 */
	public String getINewroutecd() {
		return this.iNewroutecd;
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
	 * @return railCrrTpCd
	 */
	public String getRailCrrTpCd() {
		return this.railCrrTpCd;
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
	 * @return iHubSearchGb
	 */
	public String getIHubSearchGb() {
		return this.iHubSearchGb;
	}

	/**
	 * Column Info
	 * @return trspAgmtOfcCtyCd
	 */
	public String getTrspAgmtOfcCtyCd() {
		return this.trspAgmtOfcCtyCd;
	}

	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
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
	 * @return iRoutSeq
	 */
	public String getIRoutSeq() {
		return this.iRoutSeq;
	}

	/**
	 * Column Info
	 * @return disableBkgFlg
	 */
	public String getDisableBkgFlg() {
		return this.disableBkgFlg;
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
	 * @return inlndRoutCmbFlg
	 */
	public String getInlndRoutCmbFlg() {
		return this.inlndRoutCmbFlg;
	}

	/**
	 * Column Info
	 * @return prioSeqCombo
	 */
	public String getPrioSeqCombo() {
		return this.prioSeqCombo;
	}

	/**
	 * Column Info
	 * @return fmtTztmHrs
	 */
	public String getFmtTztmHrs() {
		return this.fmtTztmHrs;
	}

	/**
	 * Column Info
	 * @return cnt
	 */
	public String getCnt() {
		return this.cnt;
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
	 * @return inlndRoutJuncNm
	 */
	public String getInlndRoutJuncNm() {
		return this.inlndRoutJuncNm;
	}

	/**
	 * Column Info
	 * @return fc
	 */
	public String getFc() {
		return this.fc;
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
	 * @return prioSeq
	 */
	public String getPrioSeq() {
		return this.prioSeq;
	}

	/**
	 * Column Info
	 * @return agreeRate
	 */
	public String getAgreeRate() {
		return this.agreeRate;
	}

	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}

	/**
	 * Column Info
	 * @return expToDt
	 */
	public String getExpToDt() {
		return this.expToDt;
	}

	/**
	 * Column Info
	 * @param agreeRate
	 */
	public void setAgreeRate(String agreeRate) {
		this.agreeRate = agreeRate;
	}

	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	/**
	 * Column Info
	 * @param expToDt
	 */
	public void setExpToDt(String expToDt) {
		this.expToDt = expToDt;
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
	 * @param iFrontGb
	 */
	public void setIFrontGb(String iFrontGb) {
		this.iFrontGb = iFrontGb;
	}

	/**
	 * Column Info
	 * @param iSelrow
	 */
	public void setISelrow(String iSelrow) {
		this.iSelrow = iSelrow;
	}

	/**
	 * Column Info
	 * @param iUndefineNod
	 */
	public void setIUndefineNod(String iUndefineNod) {
		this.iUndefineNod = iUndefineNod;
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
	 * @param tztmHrs
	 */
	public void setTztmHrs(String tztmHrs) {
		this.tztmHrs = tztmHrs;
	}

	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * @param lnkOrgNodCd
	 */
	public void setLnkOrgNodCd(String lnkOrgNodCd) {
		this.lnkOrgNodCd = lnkOrgNodCd;
	}

	/**
	 * Column Info
	 * @param mcntrRoutFlg
	 */
	public void setMcntrRoutFlg(String mcntrRoutFlg) {
		this.mcntrRoutFlg = mcntrRoutFlg;
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
	 * @param distUtCd
	 */
	public void setDistUtCd(String distUtCd) {
		this.distUtCd = distUtCd;
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
	 * @param agmtRefNo
	 */
	public void setAgmtRefNo(String agmtRefNo) {
		this.agmtRefNo = agmtRefNo;
	}

	/**
	 * Column Info
	 * @param lnkDestNodCd
	 */
	public void setLnkDestNodCd(String lnkDestNodCd) {
		this.lnkDestNodCd = lnkDestNodCd;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	/**
	 * Column Info
	 * @param sumTtTime
	 */
	public void setSumTtTime(String sumTtTime) {
		this.sumTtTime = sumTtTime;
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
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}

	/**
	 * Column Info
	 * @param trspAgmtSeq
	 */
	public void setTrspAgmtSeq(String trspAgmtSeq) {
		this.trspAgmtSeq = trspAgmtSeq;
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
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}

	/**
	 * Column Info
	 * @param cc
	 */
	public void setCc(String cc) {
		this.cc = cc;
	}

	/**
	 * Column Info
	 * @param inlndRoutBkgFlg
	 */
	public void setInlndRoutBkgFlg(String inlndRoutBkgFlg) {
		this.inlndRoutBkgFlg = inlndRoutBkgFlg;
	}

	/**
	 * Column Info
	 * @param iNewroutecd
	 */
	public void setINewroutecd(String iNewroutecd) {
		this.iNewroutecd = iNewroutecd;
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
	 * @param railCrrTpCd
	 */
	public void setRailCrrTpCd(String railCrrTpCd) {
		this.railCrrTpCd = railCrrTpCd;
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
	 * @param iHubSearchGb
	 */
	public void setIHubSearchGb(String iHubSearchGb) {
		this.iHubSearchGb = iHubSearchGb;
	}

	/**
	 * Column Info
	 * @param trspAgmtOfcCtyCd
	 */
	public void setTrspAgmtOfcCtyCd(String trspAgmtOfcCtyCd) {
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
	}

	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
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
	 * @param iRoutSeq
	 */
	public void setIRoutSeq(String iRoutSeq) {
		this.iRoutSeq = iRoutSeq;
	}

	/**
	 * Column Info
	 * @param disableBkgFlg
	 */
	public void setDisableBkgFlg(String disableBkgFlg) {
		this.disableBkgFlg = disableBkgFlg;
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
	 * @param inlndRoutCmbFlg
	 */
	public void setInlndRoutCmbFlg(String inlndRoutCmbFlg) {
		this.inlndRoutCmbFlg = inlndRoutCmbFlg;
	}

	/**
	 * Column Info
	 * @param prioSeqCombo
	 */
	public void setPrioSeqCombo(String prioSeqCombo) {
		this.prioSeqCombo = prioSeqCombo;
	}

	/**
	 * Column Info
	 * @param fmtTztmHrs
	 */
	public void setFmtTztmHrs(String fmtTztmHrs) {
		this.fmtTztmHrs = fmtTztmHrs;
	}

	/**
	 * Column Info
	 * @param cnt
	 */
	public void setCnt(String cnt) {
		this.cnt = cnt;
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
	 * @param inlndRoutJuncNm
	 */
	public void setInlndRoutJuncNm(String inlndRoutJuncNm) {
		this.inlndRoutJuncNm = inlndRoutJuncNm;
	}

	/**
	 * Column Info
	 * @param fc
	 */
	public void setFc(String fc) {
		this.fc = fc;
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
	 * @param prioSeq
	 */
	public void setPrioSeq(String prioSeq) {
		this.prioSeq = prioSeq;
	}

	/**
	 * @return
	 */
	public String getWrsFullCmdtCd() {
		return wrsFullCmdtCd;
	}

	/**
	 * @param wrsFullCmdtCd
	 */
	public void setWrsFullCmdtCd(String wrsFullCmdtCd) {
		this.wrsFullCmdtCd = wrsFullCmdtCd;
	}

	/**
	 * @return
	 */
	public String getWrsMtyCmdtCd() {
		return wrsMtyCmdtCd;
	}

	/**
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
		setLnkDestType(JSPUtil.getParameter(request, "lnk_dest_type", ""));
		setIFrontGb(JSPUtil.getParameter(request, "i_front_gb", ""));
		setISelrow(JSPUtil.getParameter(request, "i_selrow", ""));
		setIUndefineNod(JSPUtil.getParameter(request, "i_undefine_nod", ""));
		setRoutOrgNodCd(JSPUtil.getParameter(request, "rout_org_nod_cd", ""));
		setTztmHrs(JSPUtil.getParameter(request, "tztm_hrs", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLnkOrgNodCd(JSPUtil.getParameter(request, "lnk_org_nod_cd", ""));
		setMcntrRoutFlg(JSPUtil.getParameter(request, "mcntr_rout_flg", ""));
		setLnkDestLoc(JSPUtil.getParameter(request, "lnk_dest_loc", ""));
		setDistUtCd(JSPUtil.getParameter(request, "dist_ut_cd", ""));
		setLnkOrgType(JSPUtil.getParameter(request, "lnk_org_type", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, "agmt_ref_no", ""));
		setLnkDestNodCd(JSPUtil.getParameter(request, "lnk_dest_nod_cd", ""));
		setLnkDist(JSPUtil.getParameter(request, "lnk_dist", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setSumTtTime(JSPUtil.getParameter(request, "sum_tt_time", ""));
		setLnkOrgLoc(JSPUtil.getParameter(request, "lnk_org_loc", ""));
		setRoutDtlSeq(JSPUtil.getParameter(request, "rout_dtl_seq", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setTrspAgmtSeq(JSPUtil.getParameter(request, "trsp_agmt_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setCc(JSPUtil.getParameter(request, "cc", ""));
		setInlndRoutBkgFlg(JSPUtil.getParameter(request, "inlnd_rout_bkg_flg", ""));
		setINewroutecd(JSPUtil.getParameter(request, "i_newroutecd", ""));
		setIRoutDestNodCd(JSPUtil.getParameter(request, "i_rout_dest_nod_cd", ""));
		setRailCrrTpCd(JSPUtil.getParameter(request, "rail_crr_tp_cd", ""));
		setIRoutOrgNodCd(JSPUtil.getParameter(request, "i_rout_org_nod_cd", ""));
		setIHubSearchGb(JSPUtil.getParameter(request, "i_hub_search_gb", ""));
		setTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, "trsp_agmt_ofc_cty_cd", ""));
		setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIRoutSeq(JSPUtil.getParameter(request, "i_rout_seq", ""));
		setDisableBkgFlg(JSPUtil.getParameter(request, "disable_bkg_flg", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setRoutDestNodCd(JSPUtil.getParameter(request, "rout_dest_nod_cd", ""));
		setInlndRoutCmbFlg(JSPUtil.getParameter(request, "inlnd_rout_cmb_flg", ""));
		setPrioSeqCombo(JSPUtil.getParameter(request, "prio_seq_combo", ""));
		setFmtTztmHrs(JSPUtil.getParameter(request, "fmt_tztm_hrs", ""));
		setCnt(JSPUtil.getParameter(request, "cnt", ""));
		setRoutPlnCd(JSPUtil.getParameter(request, "rout_pln_cd", ""));
		setInlndRoutJuncNm(JSPUtil.getParameter(request, "inlnd_rout_junc_nm", ""));
		setFc(JSPUtil.getParameter(request, "fc", ""));
		setInlndRoutInvBilPattCd(JSPUtil.getParameter(request, "inlnd_rout_inv_bil_patt_cd", ""));
		setInlndRoutRmk(JSPUtil.getParameter(request, "inlnd_rout_rmk", ""));
		setPrioSeq(JSPUtil.getParameter(request, "prio_seq", ""));
		setAgreeRate(JSPUtil.getParameter(request, "agree_rate", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setExpToDt(JSPUtil.getParameter(request, "exp_to_dt", ""));
		setWrsFullCmdtCd(JSPUtil.getParameter(request, "wrs_full_cmdt_cd", ""));
		setWrsMtyCmdtCd(JSPUtil.getParameter(request, "wrs_mty_cmdt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InlandRouteDetVO[]
	 */
	public InlandRouteDetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InlandRouteDetVO[]
	 */
	public InlandRouteDetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InlandRouteDetVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] lnkDestType = (JSPUtil.getParameter(request, prefix + "lnk_dest_type", length));
			String[] iFrontGb = (JSPUtil.getParameter(request, prefix + "i_front_gb", length));
			String[] iSelrow = (JSPUtil.getParameter(request, prefix + "i_selrow", length));
			String[] iUndefineNod = (JSPUtil.getParameter(request, prefix + "i_undefine_nod", length));
			String[] routOrgNodCd = (JSPUtil.getParameter(request, prefix + "rout_org_nod_cd", length));
			String[] tztmHrs = (JSPUtil.getParameter(request, prefix + "tztm_hrs", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] lnkOrgNodCd = (JSPUtil.getParameter(request, prefix + "lnk_org_nod_cd", length));
			String[] mcntrRoutFlg = (JSPUtil.getParameter(request, prefix + "mcntr_rout_flg", length));
			String[] lnkDestLoc = (JSPUtil.getParameter(request, prefix + "lnk_dest_loc", length));
			String[] distUtCd = (JSPUtil.getParameter(request, prefix + "dist_ut_cd", length));
			String[] lnkOrgType = (JSPUtil.getParameter(request, prefix + "lnk_org_type", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix + "agmt_ref_no", length));
			String[] lnkDestNodCd = (JSPUtil.getParameter(request, prefix + "lnk_dest_nod_cd", length));
			String[] lnkDist = (JSPUtil.getParameter(request, prefix + "lnk_dist", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix + "agmt_no", length));
			String[] sumTtTime = (JSPUtil.getParameter(request, prefix + "sum_tt_time", length));
			String[] lnkOrgLoc = (JSPUtil.getParameter(request, prefix + "lnk_org_loc", length));
			String[] routDtlSeq = (JSPUtil.getParameter(request, prefix + "rout_dtl_seq", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix + "rout_seq", length));
			String[] trspAgmtSeq = (JSPUtil.getParameter(request, prefix + "trsp_agmt_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", length));
			String[] cc = (JSPUtil.getParameter(request, prefix + "cc", length));
			String[] inlndRoutBkgFlg = (JSPUtil.getParameter(request, prefix + "inlnd_rout_bkg_flg", length));
			String[] iNewroutecd = (JSPUtil.getParameter(request, prefix + "i_newroutecd", length));
			String[] iRoutDestNodCd = (JSPUtil.getParameter(request, prefix + "i_rout_dest_nod_cd", length));
			String[] railCrrTpCd = (JSPUtil.getParameter(request, prefix + "rail_crr_tp_cd", length));
			String[] iRoutOrgNodCd = (JSPUtil.getParameter(request, prefix + "i_rout_org_nod_cd", length));
			String[] iHubSearchGb = (JSPUtil.getParameter(request, prefix + "i_hub_search_gb", length));
			String[] trspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix + "trsp_agmt_ofc_cty_cd", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix + "trsp_mod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] iRoutSeq = (JSPUtil.getParameter(request, prefix + "i_rout_seq", length));
			String[] disableBkgFlg = (JSPUtil.getParameter(request, prefix + "disable_bkg_flg", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
			String[] routDestNodCd = (JSPUtil.getParameter(request, prefix + "rout_dest_nod_cd", length));
			String[] inlndRoutCmbFlg = (JSPUtil.getParameter(request, prefix + "inlnd_rout_cmb_flg", length));
			String[] prioSeqCombo = (JSPUtil.getParameter(request, prefix + "prio_seq_combo", length));
			String[] fmtTztmHrs = (JSPUtil.getParameter(request, prefix + "fmt_tztm_hrs", length));
			String[] cnt = (JSPUtil.getParameter(request, prefix + "cnt", length));
			String[] routPlnCd = (JSPUtil.getParameter(request, prefix + "rout_pln_cd", length));
			String[] inlndRoutJuncNm = (JSPUtil.getParameter(request, prefix + "inlnd_rout_junc_nm", length));
			String[] fc = (JSPUtil.getParameter(request, prefix + "fc", length));
			String[] inlndRoutInvBilPattCd = (JSPUtil.getParameter(request, prefix + "inlnd_rout_inv_bil_patt_cd", length));
			String[] inlndRoutRmk = (JSPUtil.getParameter(request, prefix + "inlnd_rout_rmk", length));
			String[] prioSeq = (JSPUtil.getParameter(request, prefix + "prio_seq", length));

			String[] agreeRate = (JSPUtil.getParameter(request, prefix + "agree_rate", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
			String[] expToDt = (JSPUtil.getParameter(request, prefix + "exp_to_dt", length));
			String[] wrsFullCmdtCd = (JSPUtil.getParameter(request, prefix + "wrs_full_cmdt_cd", length));
			String[] wrsMtyCmdtCd = (JSPUtil.getParameter(request, prefix + "wrs_mty_cmdt_cd", length));

			for (int i = 0; i < length; i++) {
				model = new InlandRouteDetVO();
				if (lnkDestType[i] != null)
					model.setLnkDestType(lnkDestType[i]);
				if (iFrontGb[i] != null)
					model.setIFrontGb(iFrontGb[i]);
				if (iSelrow[i] != null)
					model.setISelrow(iSelrow[i]);
				if (iUndefineNod[i] != null)
					model.setIUndefineNod(iUndefineNod[i]);
				if (routOrgNodCd[i] != null)
					model.setRoutOrgNodCd(routOrgNodCd[i]);
				if (tztmHrs[i] != null)
					model.setTztmHrs(tztmHrs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lnkOrgNodCd[i] != null)
					model.setLnkOrgNodCd(lnkOrgNodCd[i]);
				if (mcntrRoutFlg[i] != null)
					model.setMcntrRoutFlg(mcntrRoutFlg[i]);
				if (lnkDestLoc[i] != null)
					model.setLnkDestLoc(lnkDestLoc[i]);
				if (distUtCd[i] != null)
					model.setDistUtCd(distUtCd[i]);
				if (lnkOrgType[i] != null)
					model.setLnkOrgType(lnkOrgType[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (lnkDestNodCd[i] != null)
					model.setLnkDestNodCd(lnkDestNodCd[i]);
				if (lnkDist[i] != null)
					model.setLnkDist(lnkDist[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (sumTtTime[i] != null)
					model.setSumTtTime(sumTtTime[i]);
				if (lnkOrgLoc[i] != null)
					model.setLnkOrgLoc(lnkOrgLoc[i]);
				if (routDtlSeq[i] != null)
					model.setRoutDtlSeq(routDtlSeq[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (trspAgmtSeq[i] != null)
					model.setTrspAgmtSeq(trspAgmtSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (cc[i] != null)
					model.setCc(cc[i]);
				if (inlndRoutBkgFlg[i] != null)
					model.setInlndRoutBkgFlg(inlndRoutBkgFlg[i]);
				if (iNewroutecd[i] != null)
					model.setINewroutecd(iNewroutecd[i]);
				if (iRoutDestNodCd[i] != null)
					model.setIRoutDestNodCd(iRoutDestNodCd[i]);
				if (railCrrTpCd[i] != null)
					model.setRailCrrTpCd(railCrrTpCd[i]);
				if (iRoutOrgNodCd[i] != null)
					model.setIRoutOrgNodCd(iRoutOrgNodCd[i]);
				if (iHubSearchGb[i] != null)
					model.setIHubSearchGb(iHubSearchGb[i]);
				if (trspAgmtOfcCtyCd[i] != null)
					model.setTrspAgmtOfcCtyCd(trspAgmtOfcCtyCd[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (iRoutSeq[i] != null)
					model.setIRoutSeq(iRoutSeq[i]);
				if (disableBkgFlg[i] != null)
					model.setDisableBkgFlg(disableBkgFlg[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (routDestNodCd[i] != null)
					model.setRoutDestNodCd(routDestNodCd[i]);
				if (inlndRoutCmbFlg[i] != null)
					model.setInlndRoutCmbFlg(inlndRoutCmbFlg[i]);
				if (prioSeqCombo[i] != null)
					model.setPrioSeqCombo(prioSeqCombo[i]);
				if (fmtTztmHrs[i] != null)
					model.setFmtTztmHrs(fmtTztmHrs[i]);
				if (cnt[i] != null)
					model.setCnt(cnt[i]);
				if (routPlnCd[i] != null)
					model.setRoutPlnCd(routPlnCd[i]);
				if (inlndRoutJuncNm[i] != null)
					model.setInlndRoutJuncNm(inlndRoutJuncNm[i]);
				if (fc[i] != null)
					model.setFc(fc[i]);
				if (inlndRoutInvBilPattCd[i] != null)
					model.setInlndRoutInvBilPattCd(inlndRoutInvBilPattCd[i]);
				if (inlndRoutRmk[i] != null)
					model.setInlndRoutRmk(inlndRoutRmk[i]);
				if (prioSeq[i] != null)
					model.setPrioSeq(prioSeq[i]);

				if (agreeRate[i] != null)
					model.setAgreeRate(agreeRate[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (expToDt[i] != null)
					model.setExpToDt(expToDt[i]);
				if (wrsFullCmdtCd[i] != null)
					model.setWrsFullCmdtCd(wrsFullCmdtCd[i]);
				if (wrsMtyCmdtCd[i] != null)
					model.setWrsMtyCmdtCd(wrsMtyCmdtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInlandRouteDetVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InlandRouteDetVO[]
	 */
	public InlandRouteDetVO[] getInlandRouteDetVOs() {
		InlandRouteDetVO[] vos = (InlandRouteDetVO[]) models.toArray(new InlandRouteDetVO[models.size()]);
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
		this.lnkDestType = this.lnkDestType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iFrontGb = this.iFrontGb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iSelrow = this.iSelrow.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iUndefineNod = this.iUndefineNod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routOrgNodCd = this.routOrgNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tztmHrs = this.tztmHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkOrgNodCd = this.lnkOrgNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrRoutFlg = this.mcntrRoutFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDestLoc = this.lnkDestLoc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distUtCd = this.distUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkOrgType = this.lnkOrgType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDestNodCd = this.lnkDestNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDist = this.lnkDist.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTtTime = this.sumTtTime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkOrgLoc = this.lnkOrgLoc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDtlSeq = this.routDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtSeq = this.trspAgmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cc = this.cc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutBkgFlg = this.inlndRoutBkgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iNewroutecd = this.iNewroutecd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRoutDestNodCd = this.iRoutDestNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCrrTpCd = this.railCrrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRoutOrgNodCd = this.iRoutOrgNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iHubSearchGb = this.iHubSearchGb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtOfcCtyCd = this.trspAgmtOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRoutSeq = this.iRoutSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disableBkgFlg = this.disableBkgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDestNodCd = this.routDestNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutCmbFlg = this.inlndRoutCmbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prioSeqCombo = this.prioSeqCombo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTztmHrs = this.fmtTztmHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt = this.cnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPlnCd = this.routPlnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutJuncNm = this.inlndRoutJuncNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fc = this.fc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutInvBilPattCd = this.inlndRoutInvBilPattCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutRmk = this.inlndRoutRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prioSeq = this.prioSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.agreeRate = this.agreeRate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expToDt = this.expToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrsFullCmdtCd = this.wrsFullCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrsMtyCmdtCd = this.wrsMtyCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
