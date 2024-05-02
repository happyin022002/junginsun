/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VSLPerformanceVO.java
*@FileTitle : VSLPerformanceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.05  
* 1.0 Creation
* 
* 2014.03.17 박다은 [CHM-201428939-01] vessel particular - performance
* 2014.04.16 박다은 [CHM-201429675-01] Voyage Performance내 Lane Code 구분
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VSLPerformanceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VSLPerformanceVO> models = new ArrayList<VSLPerformanceVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String pfFocQty = null;
	
	/* Column Info */
	private String dailyFocQty = null;
	/* Column Info */
	private String hourlyFocQty = null;
	
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String pfSkdTpCd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String avgSlip = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String skdStsCd = null;
	/* Column Info */
	private String psdoVvdCd = null;
	/* Column Info */
	private String dlsEdiSndTgtFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String skdUsdIndCd = null;
	/* Column Info */
	private String pfSpd = null;
	/* Column Info */
	private String skdVoyTpCd = null;
	/* Column Info */
	private String skdRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String avgActFocQty = null;
	/* Column Info */
	private String n1stPortBrthDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String skdStsMnlFlg = null;
	/* Column Info */
	private String actCrrCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ruseProhiFlg = null;
	/* Column Info */
	private String pfNetSpd = null;
	/* Column Info */
	private String stPortCd = null;
	/* Column Info */
	private String bowHgt = null;
	/* Column Info */
	private String shpIdxScre = null;
	/* Column Info */
	private String slwStmngFlg = null;
	/* Column Info */
	private String ctclRpmNo = null;
	/* Column Info */
	private String ctclToRpmNo = null;
	/* Column Info */
	private String opMinSpd = null;
	/* Column Info */
	private String onDeckPerTrKnt = null;
	/* Column Info */
	private String trsmHgt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String onDeckPerRowKnt = null;
	/* Column Info */
	private String htchCvrInHldKnt = null;
	/* Column Info */
	private String fuelSavEqFlg = null;
	/* Column Info */
	private String opMinRpmNo = null;
	/* Column Info */
	private String inHldPerRowKnt = null;
	/* Column Info */
	private String sprSlwStmngFlg = null;
	/* Column Info */
	private String inHldPerTrKnt = null;
	/* Column Info */
	private String totSeaTimeHrs = null;
	/* Column Info */
	private String vslLodRto = null;
	/* Column Info */
	private String ampTpCd = null;	
	
	public LowestListVO[] getLowestListVOs() {
		return lowestListVOs;
	}

	public void setLowestListVOs(LowestListVO[] lowestListVOs) {
		this.lowestListVOs = lowestListVOs;
	}

	public List<LowestListVO> getLowestListVOl() {
		return lowestListVOl;
	}

	public void setLowestListVOl(List<LowestListVO> lowestListVOl) {
		this.lowestListVOl = lowestListVOl;
	}

	/* VO Info */
	private LowestListVO[] lowestListVOs = null;
	private List<LowestListVO> lowestListVOl = null;

	public LoadFactorListVO[] getLoadFactorListVOs() {
		return loadFactorListVOs;
	}

	public void setLoadFactorListVOs(LoadFactorListVO[] loadFactorListVOs) {
		this.loadFactorListVOs = loadFactorListVOs;
	}

	public List<LoadFactorListVO> getLoadFactorListVOl() {
		return loadFactorListVOl;
	}

	public void setLoadFactorListVOl(List<LoadFactorListVO> loadFactorListVOl) {
		this.loadFactorListVOl = loadFactorListVOl;
	}

	private LoadFactorListVO[] loadFactorListVOs = null;
	private List<LoadFactorListVO> loadFactorListVOl = null;

	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VSLPerformanceVO() {}

	public VSLPerformanceVO(String ibflag, String pagerows, String vslSlanCd, String pfSkdTpCd, String pfSpd, String avgSlip, String pfNetSpd, String pfFocQty, String avgActFocQty, String vslCd, String skdVoyNo, String skdDirCd, String skdStsCd, String ruseProhiFlg, String skdStsMnlFlg, String skdVoyTpCd, String skdUsdIndCd, String stPortCd, String n1stPortBrthDt, String psdoVvdCd, String coCd, String skdRmk, String creUsrId, String creDt, String updUsrId, String updDt, String dlsEdiSndTgtFlg, String actCrrCd
						,String ctclRpmNo, String ctclToRpmNo,String opMinRpmNo, String opMinSpd, String slwStmngFlg, String sprSlwStmngFlg, String fuelSavEqFlg, String inHldPerTrKnt, String inHldPerRowKnt, String htchCvrInHldKnt, String onDeckPerTrKnt, String onDeckPerRowKnt, String bowHgt, String trsmHgt, String shpIdxScre, String usrId, String vslLodRto, String ampTpCd) {
		this.vslCd = vslCd;
		this.pfFocQty = pfFocQty;
		this.creDt = creDt;
		this.pfSkdTpCd = pfSkdTpCd;
		this.vslSlanCd = vslSlanCd;
		this.avgSlip = avgSlip;
		this.pagerows = pagerows;
		this.skdStsCd = skdStsCd;
		this.psdoVvdCd = psdoVvdCd;
		this.dlsEdiSndTgtFlg = dlsEdiSndTgtFlg;
		this.ibflag = ibflag;
		this.skdUsdIndCd = skdUsdIndCd;
		this.pfSpd = pfSpd;
		this.skdVoyTpCd = skdVoyTpCd;
		this.skdRmk = skdRmk;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.coCd = coCd;
		this.avgActFocQty = avgActFocQty;
		this.n1stPortBrthDt = n1stPortBrthDt;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.skdStsMnlFlg = skdStsMnlFlg;
		this.actCrrCd = actCrrCd;
		this.creUsrId = creUsrId;
		this.ruseProhiFlg = ruseProhiFlg;
		this.pfNetSpd = pfNetSpd;
		this.stPortCd = stPortCd;
		this.bowHgt = bowHgt;
		this.shpIdxScre = shpIdxScre;
		this.slwStmngFlg = slwStmngFlg;
		this.ctclRpmNo = ctclRpmNo;
		this.ctclToRpmNo = ctclToRpmNo;
		this.opMinSpd = opMinSpd;
		this.onDeckPerTrKnt = onDeckPerTrKnt;
		this.trsmHgt = trsmHgt;
		this.onDeckPerRowKnt = onDeckPerRowKnt;
		this.htchCvrInHldKnt = htchCvrInHldKnt;
		this.fuelSavEqFlg = fuelSavEqFlg;
		this.opMinRpmNo = opMinRpmNo;
		this.inHldPerRowKnt = inHldPerRowKnt;
		this.sprSlwStmngFlg = sprSlwStmngFlg;
		this.inHldPerTrKnt = inHldPerTrKnt;
		this.vslLodRto = vslLodRto;
		this.ampTpCd = ampTpCd;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("pf_foc_qty", getPfFocQty());
		
		this.hashColumns.put("daily_foc_qty", getDailyFocQty());
		this.hashColumns.put("hourly_foc_qty", getHourlyFocQty());
		
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pf_skd_tp_cd", getPfSkdTpCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("avg_slip", getAvgSlip());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("skd_sts_cd", getSkdStsCd());
		this.hashColumns.put("psdo_vvd_cd", getPsdoVvdCd());
		this.hashColumns.put("dls_edi_snd_tgt_flg", getDlsEdiSndTgtFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("skd_usd_ind_cd", getSkdUsdIndCd());
		this.hashColumns.put("pf_spd", getPfSpd());
		this.hashColumns.put("skd_voy_tp_cd", getSkdVoyTpCd());
		this.hashColumns.put("skd_rmk", getSkdRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("avg_act_foc_qty", getAvgActFocQty());
		this.hashColumns.put("n1st_port_brth_dt", getN1stPortBrthDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("skd_sts_mnl_flg", getSkdStsMnlFlg());
		this.hashColumns.put("act_crr_cd", getActCrrCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ruse_prohi_flg", getRuseProhiFlg());
		this.hashColumns.put("pf_net_spd", getPfNetSpd());
		this.hashColumns.put("st_port_cd", getStPortCd());
		this.hashColumns.put("bow_hgt", getBowHgt());
		this.hashColumns.put("shp_idx_scre", getShpIdxScre());
		this.hashColumns.put("slw_stmng_flg", getSlwStmngFlg());
		this.hashColumns.put("ctcl_rpm_no", getCtclRpmNo());
		this.hashColumns.put("ctcl_to_rpm_no", getCtclToRpmNo());
		this.hashColumns.put("op_min_spd", getOpMinSpd());
		this.hashColumns.put("on_deck_per_tr_knt", getOnDeckPerTrKnt());
		this.hashColumns.put("trsm_hgt", getTrsmHgt());
		this.hashColumns.put("on_deck_per_row_knt", getOnDeckPerRowKnt());
		this.hashColumns.put("htch_cvr_in_hld_knt", getHtchCvrInHldKnt());
		this.hashColumns.put("fuel_sav_eq_flg", getFuelSavEqFlg());
		this.hashColumns.put("op_min_rpm_no", getOpMinRpmNo());
		this.hashColumns.put("in_hld_per_row_knt", getInHldPerRowKnt());
		this.hashColumns.put("spr_slw_stmng_flg", getSprSlwStmngFlg());
		this.hashColumns.put("in_hld_per_tr_knt", getInHldPerTrKnt());
		this.hashColumns.put("tot_sea_time_hrs", getTotSeaTimeHrs());
		this.hashColumns.put("vsl_lod_rto", getVslLodRto());
		this.hashColumns.put("amp_tp_cd", getAmpTpCd());

		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("pf_foc_qty", "pfFocQty");
		
		this.hashFields.put("daily_foc_qty", "dailyFocQty");
		this.hashFields.put("hourly_foc_qty", "hourlyFocQty");
		
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pf_skd_tp_cd", "pfSkdTpCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("avg_slip", "avgSlip");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("skd_sts_cd", "skdStsCd");
		this.hashFields.put("psdo_vvd_cd", "psdoVvdCd");
		this.hashFields.put("dls_edi_snd_tgt_flg", "dlsEdiSndTgtFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("skd_usd_ind_cd", "skdUsdIndCd");
		this.hashFields.put("pf_spd", "pfSpd");
		this.hashFields.put("skd_voy_tp_cd", "skdVoyTpCd");
		this.hashFields.put("skd_rmk", "skdRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("avg_act_foc_qty", "avgActFocQty");
		this.hashFields.put("n1st_port_brth_dt", "n1stPortBrthDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("skd_sts_mnl_flg", "skdStsMnlFlg");
		this.hashFields.put("act_crr_cd", "actCrrCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ruse_prohi_flg", "ruseProhiFlg");
		this.hashFields.put("pf_net_spd", "pfNetSpd");
		this.hashFields.put("st_port_cd", "stPortCd");
		this.hashFields.put("bow_hgt", "bowHgt");
		this.hashFields.put("shp_idx_scre", "shpIdxScre");
		this.hashFields.put("slw_stmng_flg", "slwStmngFlg");
		this.hashFields.put("ctcl_rpm_no", "ctclRpmNo");
		this.hashFields.put("ctcl_to_rpm_no", "ctclToRpmNo");
		this.hashFields.put("op_min_spd", "opMinSpd");
		this.hashFields.put("on_deck_per_tr_knt", "onDeckPerTrKnt");
		this.hashFields.put("trsm_hgt", "trsmHgt");
		this.hashFields.put("on_deck_per_row_knt", "onDeckPerRowKnt");
		this.hashFields.put("htch_cvr_in_hld_knt", "htchCvrInHldKnt");
		this.hashFields.put("fuel_sav_eq_flg", "fuelSavEqFlg");
		this.hashFields.put("op_min_rpm_no", "opMinRpmNo");
		this.hashFields.put("in_hld_per_row_knt", "inHldPerRowKnt");
		this.hashFields.put("spr_slw_stmng_flg", "sprSlwStmngFlg");
		this.hashFields.put("in_hld_per_tr_knt", "inHldPerTrKnt");
		this.hashFields.put("tot_sea_time_hrs", "totSeaTimeHrs");
		this.hashFields.put("vsl_lod_rto", "vslLodRto");
		this.hashFields.put("amp_tp_cd", "ampTpCd");

		
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
	 * @return pfFocQty
	 */
	public String getPfFocQty() {
		return this.pfFocQty;
	}
	
	/**
	 * Column Info
	 * @return dailyFocQty
	 */
	public String getDailyFocQty() {
		return this.dailyFocQty;
	}
	/**
	 * Column Info
	 * @return hourlyFocQty
	 */
	public String getHourlyFocQty() {
		return this.hourlyFocQty;
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
	 * @return pfSkdTpCd
	 */
	public String getPfSkdTpCd() {
		return this.pfSkdTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return avgSlip
	 */
	public String getAvgSlip() {
		return this.avgSlip;
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
	 * @return skdStsCd
	 */
	public String getSkdStsCd() {
		return this.skdStsCd;
	}
	
	/**
	 * Column Info
	 * @return psdoVvdCd
	 */
	public String getPsdoVvdCd() {
		return this.psdoVvdCd;
	}
	
	/**
	 * Column Info
	 * @return dlsEdiSndTgtFlg
	 */
	public String getDlsEdiSndTgtFlg() {
		return this.dlsEdiSndTgtFlg;
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
	 * @return skdUsdIndCd
	 */
	public String getSkdUsdIndCd() {
		return this.skdUsdIndCd;
	}
	
	/**
	 * Column Info
	 * @return pfSpd
	 */
	public String getPfSpd() {
		return this.pfSpd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyTpCd
	 */
	public String getSkdVoyTpCd() {
		return this.skdVoyTpCd;
	}
	
	/**
	 * Column Info
	 * @return skdRmk
	 */
	public String getSkdRmk() {
		return this.skdRmk;
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
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return avgActFocQty
	 */
	public String getAvgActFocQty() {
		return this.avgActFocQty;
	}
	
	/**
	 * Column Info
	 * @return n1stPortBrthDt
	 */
	public String getN1stPortBrthDt() {
		return this.n1stPortBrthDt;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return skdStsMnlFlg
	 */
	public String getSkdStsMnlFlg() {
		return this.skdStsMnlFlg;
	}
	
	/**
	 * Column Info
	 * @return actCrrCd
	 */
	public String getActCrrCd() {
		return this.actCrrCd;
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
	 * @return ruseProhiFlg
	 */
	public String getRuseProhiFlg() {
		return this.ruseProhiFlg;
	}
	
	/**
	 * Column Info
	 * @return pfNetSpd
	 */
	public String getPfNetSpd() {
		return this.pfNetSpd;
	}
	
	/**
	 * Column Info
	 * @return stPortCd
	 */
	public String getStPortCd() {
		return this.stPortCd;
	}
	
	/**
	 * Column Info
	 * @return bowHgt
	 */
	public String getBowHgt() {
		return this.bowHgt;
	}
	
	/**
	 * Column Info
	 * @return shpIdxScre
	 */
	public String getShpIdxScre() {
		return this.shpIdxScre;
	}
	
	/**
	 * Column Info
	 * @return slwStmngFlg
	 */
	public String getSlwStmngFlg() {
		return this.slwStmngFlg;
	}
	
	/**
	 * Column Info
	 * @return ctclRpmNo
	 */
	public String getCtclRpmNo() {
		return this.ctclRpmNo;
	}
	
	/**
	 * Column Info
	 * @return ctclToRpmNo
	 */
	public String getCtclToRpmNo() {
		return this.ctclToRpmNo;
	}
	
	/**
	 * Column Info
	 * @return opMinSpd
	 */
	public String getOpMinSpd() {
		return this.opMinSpd;
	}
	
	/**
	 * Column Info
	 * @return onDeckPerTrKnt
	 */
	public String getOnDeckPerTrKnt() {
		return this.onDeckPerTrKnt;
	}
	
	
	/**
	 * Column Info
	 * @return trsmHgt
	 */
	public String getTrsmHgt() {
		return this.trsmHgt;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return onDeckPerRowKnt
	 */
	public String getOnDeckPerRowKnt() {
		return this.onDeckPerRowKnt;
	}
	
	/**
	 * Column Info
	 * @return htchCvrInHldKnt
	 */
	public String getHtchCvrInHldKnt() {
		return this.htchCvrInHldKnt;
	}
	
	/**
	 * Column Info
	 * @return fuelSavEqFlg
	 */
	public String getFuelSavEqFlg() {
		return this.fuelSavEqFlg;
	}
	
	/**
	 * Column Info
	 * @return opMinRpmNo
	 */
	public String getOpMinRpmNo() {
		return this.opMinRpmNo;
	}
	
	
	/**
	 * Column Info
	 * @return inHldPerRowKnt
	 */
	public String getInHldPerRowKnt() {
		return this.inHldPerRowKnt;
	}
	
	/**
	 * Column Info
	 * @return sprSlwStmngFlg
	 */
	public String getSprSlwStmngFlg() {
		return this.sprSlwStmngFlg;
	}
	
	/**
	 * Column Info
	 * @return inHldPerTrKnt
	 */
	public String getInHldPerTrKnt() {
		return this.inHldPerTrKnt;
	}
	
	/**
	 * Column Info
	 * @return totSeaTimeHrs
	 */
	public String getTotSeaTimeHrs() {
		return this.totSeaTimeHrs;
	}
	
	/**
	 * Column Info
	 * @return vslLodRto
	 */
	public String getVslLodRto() {
		return this.vslLodRto;
	}
	
	/**
	 * Column Info
	 * @return ampTpCd
	 */
	public String getAmpTpCd() {
		return this.ampTpCd;
	}
	
	/**
	 * Column Info
	 * @param pfFocQty
	 */
	public void setPfFocQty(String pfFocQty) {
		this.pfFocQty = pfFocQty;
	}
	
	
	/**
	 * Column Info
	 * @param dailyFocQty
	 */
	public void setDailyFocQty(String dailyFocQty) {
		this.dailyFocQty = dailyFocQty;
	}
	/**
	 * Column Info
	 * @param hourlyFocQty
	 */
	public void setHourlyFocQty(String hourlyFocQty) {
		this.hourlyFocQty = hourlyFocQty;
	}
	
	
	/**
	 * Column Info
	 * @param pfSkdTpCd
	 */
	public void setPfSkdTpCd(String pfSkdTpCd) {
		this.pfSkdTpCd = pfSkdTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param avgSlip
	 */
	public void setAvgSlip(String avgSlip) {
		this.avgSlip = avgSlip;
	}
	
	/**
	 * Column Info
	 * @param skdStsCd
	 */
	public void setSkdStsCd(String skdStsCd) {
		this.skdStsCd = skdStsCd;
	}
	
	/**
	 * Column Info
	 * @param psdoVvdCd
	 */
	public void setPsdoVvdCd(String psdoVvdCd) {
		this.psdoVvdCd = psdoVvdCd;
	}
	
	/**
	 * Column Info
	 * @param dlsEdiSndTgtFlg
	 */
	public void setDlsEdiSndTgtFlg(String dlsEdiSndTgtFlg) {
		this.dlsEdiSndTgtFlg = dlsEdiSndTgtFlg;
	}
	
	/**
	 * Column Info
	 * @param skdUsdIndCd
	 */
	public void setSkdUsdIndCd(String skdUsdIndCd) {
		this.skdUsdIndCd = skdUsdIndCd;
	}
	
	/**
	 * Column Info
	 * @param pfSpd
	 */
	public void setPfSpd(String pfSpd) {
		this.pfSpd = pfSpd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyTpCd
	 */
	public void setSkdVoyTpCd(String skdVoyTpCd) {
		this.skdVoyTpCd = skdVoyTpCd;
	}
	
	/**
	 * Column Info
	 * @param skdRmk
	 */
	public void setSkdRmk(String skdRmk) {
		this.skdRmk = skdRmk;
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
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param avgActFocQty
	 */
	public void setAvgActFocQty(String avgActFocQty) {
		this.avgActFocQty = avgActFocQty;
	}
	
	/**
	 * Column Info
	 * @param n1stPortBrthDt
	 */
	public void setN1stPortBrthDt(String n1stPortBrthDt) {
		this.n1stPortBrthDt = n1stPortBrthDt;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param skdStsMnlFlg
	 */
	public void setSkdStsMnlFlg(String skdStsMnlFlg) {
		this.skdStsMnlFlg = skdStsMnlFlg;
	}
	
	/**
	 * Column Info
	 * @param actCrrCd
	 */
	public void setActCrrCd(String actCrrCd) {
		this.actCrrCd = actCrrCd;
	}
	
	/**
	 * Column Info
	 * @param ruseProhiFlg
	 */
	public void setRuseProhiFlg(String ruseProhiFlg) {
		this.ruseProhiFlg = ruseProhiFlg;
	}
	
	/**
	 * Column Info
	 * @param pfNetSpd
	 */
	public void setPfNetSpd(String pfNetSpd) {
		this.pfNetSpd = pfNetSpd;
	}
	
	/**
	 * Column Info
	 * @param stPortCd
	 */
	public void setStPortCd(String stPortCd) {
		this.stPortCd = stPortCd;
	}
	
	/**
	 * Column Info
	 * @param bowHgt
	 */
	public void setBowHgt(String bowHgt) {
		this.bowHgt = bowHgt;
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
	 * @param shpIdxScre
	 */
	public void setShpIdxScre(String shpIdxScre) {
		this.shpIdxScre = shpIdxScre;
	}
	
	/**
	 * Column Info
	 * @param slwStmngFlg
	 */
	public void setSlwStmngFlg(String slwStmngFlg) {
		this.slwStmngFlg = slwStmngFlg;
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
	 * @param ctclRpmNo
	 */
	public void setCtclRpmNo(String ctclRpmNo) {
		this.ctclRpmNo = ctclRpmNo;
	}
	
	/**
	 * Column Info
	 * @param ctclToRpmNo
	 */
	public void setCtclToRpmNo(String ctclToRpmNo) {
		this.ctclToRpmNo = ctclToRpmNo;
	}
	
	/**
	 * Column Info
	 * @param opMinSpd
	 */
	public void setOpMinSpd(String opMinSpd) {
		this.opMinSpd = opMinSpd;
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
	 * @param onDeckPerTrKnt
	 */
	public void setOnDeckPerTrKnt(String onDeckPerTrKnt) {
		this.onDeckPerTrKnt = onDeckPerTrKnt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param trsmHgt
	 */
	public void setTrsmHgt(String trsmHgt) {
		this.trsmHgt = trsmHgt;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param onDeckPerRowKnt
	 */
	public void setOnDeckPerRowKnt(String onDeckPerRowKnt) {
		this.onDeckPerRowKnt = onDeckPerRowKnt;
	}
	
	/**
	 * Column Info
	 * @param htchCvrInHldKnt
	 */
	public void setHtchCvrInHldKnt(String htchCvrInHldKnt) {
		this.htchCvrInHldKnt = htchCvrInHldKnt;
	}
	
	/**
	 * Column Info
	 * @param fuelSavEqFlg
	 */
	public void setFuelSavEqFlg(String fuelSavEqFlg) {
		this.fuelSavEqFlg = fuelSavEqFlg;
	}
	
	/**
	 * Column Info
	 * @param opMinRpmNo
	 */
	public void setOpMinRpmNo(String opMinRpmNo) {
		this.opMinRpmNo = opMinRpmNo;
	}
	
	/**
	 * Column Info
	 * @param inHldPerRowKnt
	 */
	public void setInHldPerRowKnt(String inHldPerRowKnt) {
		this.inHldPerRowKnt = inHldPerRowKnt;
	}
	
	/**
	 * Column Info
	 * @param sprSlwStmngFlg
	 */
	public void setSprSlwStmngFlg(String sprSlwStmngFlg) {
		this.sprSlwStmngFlg = sprSlwStmngFlg;
	}
	
	/**
	 * Column Info
	 * @param inHldPerTrKnt
	 */
	public void setInHldPerTrKnt(String inHldPerTrKnt) {
		this.inHldPerTrKnt = inHldPerTrKnt;
	}
	
	/**
	 * Column Info
	 * @param totSeaTimeHrs
	 */
	public void setTotSeaTimeHrs(String totSeaTimeHrs) {
		this.totSeaTimeHrs = totSeaTimeHrs;
	}
	
	/**
	 * Column Info
	 * @param vslLodRto
	 */
	public void setVslLodRto(String vslLodRto) {
		this.vslLodRto = vslLodRto;
	}
	
	/**
	 * Column Info
	 * @param ampTpCd
	 */
	public void setAmpTpCd(String ampTpCd) {
		this.ampTpCd = ampTpCd;
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
		setPfFocQty(JSPUtil.getParameter(request, prefix + "pf_foc_qty", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPfSkdTpCd(JSPUtil.getParameter(request, prefix + "pf_skd_tp_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setAvgSlip(JSPUtil.getParameter(request, prefix + "avg_slip", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSkdStsCd(JSPUtil.getParameter(request, prefix + "skd_sts_cd", ""));
		setPsdoVvdCd(JSPUtil.getParameter(request, prefix + "psdo_vvd_cd", ""));
		setDlsEdiSndTgtFlg(JSPUtil.getParameter(request, prefix + "dls_edi_snd_tgt_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSkdUsdIndCd(JSPUtil.getParameter(request, prefix + "skd_usd_ind_cd", ""));
		setPfSpd(JSPUtil.getParameter(request, prefix + "pf_spd", ""));
		setSkdVoyTpCd(JSPUtil.getParameter(request, prefix + "skd_voy_tp_cd", ""));
		setSkdRmk(JSPUtil.getParameter(request, prefix + "skd_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCoCd(JSPUtil.getParameter(request, prefix + "co_cd", ""));
		setAvgActFocQty(JSPUtil.getParameter(request, prefix + "avg_act_foc_qty", ""));
		setN1stPortBrthDt(JSPUtil.getParameter(request, prefix + "n1st_port_brth_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setSkdStsMnlFlg(JSPUtil.getParameter(request, prefix + "skd_sts_mnl_flg", ""));
		setActCrrCd(JSPUtil.getParameter(request, prefix + "act_crr_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRuseProhiFlg(JSPUtil.getParameter(request, prefix + "ruse_prohi_flg", ""));
		setPfNetSpd(JSPUtil.getParameter(request, prefix + "pf_net_spd", ""));
		setStPortCd(JSPUtil.getParameter(request, prefix + "st_port_cd", ""));
		setBowHgt(JSPUtil.getParameter(request, prefix + "bow_hgt", ""));
		setShpIdxScre(JSPUtil.getParameter(request, prefix + "shp_idx_scre", ""));
		setSlwStmngFlg(JSPUtil.getParameter(request, prefix + "slw_stmng_flg", ""));
		setCtclRpmNo(JSPUtil.getParameter(request, prefix + "ctcl_rpm_no", ""));
		setCtclToRpmNo(JSPUtil.getParameter(request, prefix + "ctcl_to_rpm_no", ""));
		setOpMinSpd(JSPUtil.getParameter(request, prefix + "op_min_spd", ""));
		setOnDeckPerTrKnt(JSPUtil.getParameter(request, prefix + "on_deck_per_tr_knt", ""));
		setTrsmHgt(JSPUtil.getParameter(request, prefix + "trsm_hgt", ""));
		setOnDeckPerRowKnt(JSPUtil.getParameter(request, prefix + "on_deck_per_row_knt", ""));
		setHtchCvrInHldKnt(JSPUtil.getParameter(request, prefix + "htch_cvr_in_hld_knt", ""));
		setFuelSavEqFlg(JSPUtil.getParameter(request, prefix + "fuel_sav_eq_flg", ""));
		setOpMinRpmNo(JSPUtil.getParameter(request, prefix + "op_min_rpm_no", ""));
		setInHldPerRowKnt(JSPUtil.getParameter(request, prefix + "in_hld_per_row_knt", ""));
		setSprSlwStmngFlg(JSPUtil.getParameter(request, prefix + "spr_slw_stmng_flg", ""));
		setInHldPerTrKnt(JSPUtil.getParameter(request, prefix + "in_hld_per_tr_knt", ""));
		setTotSeaTimeHrs(JSPUtil.getParameter(request, prefix + "tot_sea_time_hrs", ""));
		setVslLodRto(JSPUtil.getParameter(request, prefix + "vsl_lod_rto", ""));
		setAmpTpCd(JSPUtil.getParameter(request, prefix + "amp_tp_cd", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VSLPerformanceVO[]
	 */
	public VSLPerformanceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VSLPerformanceVO[]
	 */
	public VSLPerformanceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VSLPerformanceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] pfFocQty = (JSPUtil.getParameter(request, prefix	+ "pf_foc_qty", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pfSkdTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_skd_tp_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] avgSlip = (JSPUtil.getParameter(request, prefix	+ "avg_slip", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] skdStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_sts_cd", length));
			String[] psdoVvdCd = (JSPUtil.getParameter(request, prefix	+ "psdo_vvd_cd", length));
			String[] dlsEdiSndTgtFlg = (JSPUtil.getParameter(request, prefix	+ "dls_edi_snd_tgt_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] skdUsdIndCd = (JSPUtil.getParameter(request, prefix	+ "skd_usd_ind_cd", length));
			String[] pfSpd = (JSPUtil.getParameter(request, prefix	+ "pf_spd", length));
			String[] skdVoyTpCd = (JSPUtil.getParameter(request, prefix	+ "skd_voy_tp_cd", length));
			String[] skdRmk = (JSPUtil.getParameter(request, prefix	+ "skd_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] avgActFocQty = (JSPUtil.getParameter(request, prefix	+ "avg_act_foc_qty", length));
			String[] n1stPortBrthDt = (JSPUtil.getParameter(request, prefix	+ "n1st_port_brth_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] skdStsMnlFlg = (JSPUtil.getParameter(request, prefix	+ "skd_sts_mnl_flg", length));
			String[] actCrrCd = (JSPUtil.getParameter(request, prefix	+ "act_crr_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ruseProhiFlg = (JSPUtil.getParameter(request, prefix	+ "ruse_prohi_flg", length));
			String[] pfNetSpd = (JSPUtil.getParameter(request, prefix	+ "pf_net_spd", length));
			String[] stPortCd = (JSPUtil.getParameter(request, prefix	+ "st_port_cd", length));
			String[] bowHgt = (JSPUtil.getParameter(request, prefix	+ "bow_hgt", length));
			String[] shpIdxScre = (JSPUtil.getParameter(request, prefix	+ "shp_idx_scre", length));
			String[] slwStmngFlg = (JSPUtil.getParameter(request, prefix	+ "slw_stmng_flg", length));
			String[] ctclRpmNo = (JSPUtil.getParameter(request, prefix	+ "ctcl_rpm_no", length));
			String[] ctclToRpmNo = (JSPUtil.getParameter(request, prefix	+ "ctcl_to_rpm_no", length));
			String[] opMinSpd = (JSPUtil.getParameter(request, prefix	+ "op_min_spd", length));
			String[] onDeckPerTrKnt = (JSPUtil.getParameter(request, prefix	+ "on_deck_per_tr_knt", length));
			String[] trsmHgt = (JSPUtil.getParameter(request, prefix	+ "trsm_hgt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] onDeckPerRowKnt = (JSPUtil.getParameter(request, prefix	+ "on_deck_per_row_knt", length));
			String[] htchCvrInHldKnt = (JSPUtil.getParameter(request, prefix	+ "htch_cvr_in_hld_knt", length));
			String[] fuelSavEqFlg = (JSPUtil.getParameter(request, prefix	+ "fuel_sav_eq_flg", length));
			String[] opMinRpmNo = (JSPUtil.getParameter(request, prefix	+ "op_min_rpm_no", length));
			String[] inHldPerRowKnt = (JSPUtil.getParameter(request, prefix	+ "in_hld_per_row_knt", length));
			String[] sprSlwStmngFlg = (JSPUtil.getParameter(request, prefix	+ "spr_slw_stmng_flg", length));
			String[] inHldPerTrKnt = (JSPUtil.getParameter(request, prefix	+ "in_hld_per_tr_knt", length));
			String[] totSeaTimeHrs = (JSPUtil.getParameter(request, prefix	+ "tot_sea_time_hrs", length));
			String[] vslLodRto = (JSPUtil.getParameter(request, prefix	+ "vsl_lod_rto", length));
			String[] ampTpCd = (JSPUtil.getParameter(request, prefix	+ "amp_tp_cd", length));	

			
			for (int i = 0; i < length; i++) {
				model = new VSLPerformanceVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (pfFocQty[i] != null)
					model.setPfFocQty(pfFocQty[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pfSkdTpCd[i] != null)
					model.setPfSkdTpCd(pfSkdTpCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (avgSlip[i] != null)
					model.setAvgSlip(avgSlip[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (skdStsCd[i] != null)
					model.setSkdStsCd(skdStsCd[i]);
				if (psdoVvdCd[i] != null)
					model.setPsdoVvdCd(psdoVvdCd[i]);
				if (dlsEdiSndTgtFlg[i] != null)
					model.setDlsEdiSndTgtFlg(dlsEdiSndTgtFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (skdUsdIndCd[i] != null)
					model.setSkdUsdIndCd(skdUsdIndCd[i]);
				if (pfSpd[i] != null)
					model.setPfSpd(pfSpd[i]);
				if (skdVoyTpCd[i] != null)
					model.setSkdVoyTpCd(skdVoyTpCd[i]);
				if (skdRmk[i] != null)
					model.setSkdRmk(skdRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (avgActFocQty[i] != null)
					model.setAvgActFocQty(avgActFocQty[i]);
				if (n1stPortBrthDt[i] != null)
					model.setN1stPortBrthDt(n1stPortBrthDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (skdStsMnlFlg[i] != null)
					model.setSkdStsMnlFlg(skdStsMnlFlg[i]);
				if (actCrrCd[i] != null)
					model.setActCrrCd(actCrrCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ruseProhiFlg[i] != null)
					model.setRuseProhiFlg(ruseProhiFlg[i]);
				if (pfNetSpd[i] != null)
					model.setPfNetSpd(pfNetSpd[i]);
				if (stPortCd[i] != null)
					model.setStPortCd(stPortCd[i]);

				
				
				if (bowHgt[i] != null)
					model.setBowHgt(bowHgt[i]);
				if (shpIdxScre[i] != null)
					model.setShpIdxScre(shpIdxScre[i]);
				if (slwStmngFlg[i] != null)
					model.setSlwStmngFlg(slwStmngFlg[i]);
				if (ctclRpmNo[i] != null)
					model.setCtclRpmNo(ctclRpmNo[i]);
				if (ctclToRpmNo[i] != null)
					model.setCtclToRpmNo(ctclToRpmNo[i]);
				if (opMinSpd[i] != null)
					model.setOpMinSpd(opMinSpd[i]);
				if (onDeckPerTrKnt[i] != null)
					model.setOnDeckPerTrKnt(onDeckPerTrKnt[i]);
				if (trsmHgt[i] != null)
					model.setTrsmHgt(trsmHgt[i]);
				if (onDeckPerRowKnt[i] != null)
					model.setOnDeckPerRowKnt(onDeckPerRowKnt[i]);
				if (htchCvrInHldKnt[i] != null)
					model.setHtchCvrInHldKnt(htchCvrInHldKnt[i]);
				if (fuelSavEqFlg[i] != null)
					model.setFuelSavEqFlg(fuelSavEqFlg[i]);
				if (opMinRpmNo[i] != null)
					model.setOpMinRpmNo(opMinRpmNo[i]);
				if (inHldPerRowKnt[i] != null)
					model.setInHldPerRowKnt(inHldPerRowKnt[i]);
				if (sprSlwStmngFlg[i] != null)
					model.setSprSlwStmngFlg(sprSlwStmngFlg[i]);
				if (inHldPerTrKnt[i] != null)
					model.setInHldPerTrKnt(inHldPerTrKnt[i]);
				
				if (totSeaTimeHrs[i] != null)
					model.setTotSeaTimeHrs(totSeaTimeHrs[i]);
				if (vslLodRto[i] != null)
					model.setVslLodRto(vslLodRto[i]);
				if (ampTpCd[i] != null)
					model.setAmpTpCd(ampTpCd[i]);	
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVSLPerformanceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VSLPerformanceVO[]
	 */
	public VSLPerformanceVO[] getVSLPerformanceVOs(){
		VSLPerformanceVO[] vos = (VSLPerformanceVO[])models.toArray(new VSLPerformanceVO[models.size()]);
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
		this.pfFocQty = this.pfFocQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSkdTpCd = this.pfSkdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgSlip = this.avgSlip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdStsCd = this.skdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psdoVvdCd = this.psdoVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlsEdiSndTgtFlg = this.dlsEdiSndTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdUsdIndCd = this.skdUsdIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSpd = this.pfSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyTpCd = this.skdVoyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdRmk = this.skdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgActFocQty = this.avgActFocQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPortBrthDt = this.n1stPortBrthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdStsMnlFlg = this.skdStsMnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCrrCd = this.actCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ruseProhiFlg = this.ruseProhiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfNetSpd = this.pfNetSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stPortCd = this.stPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bowHgt = this.bowHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpIdxScre = this.shpIdxScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slwStmngFlg = this.slwStmngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctclRpmNo = this.ctclRpmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctclToRpmNo = this.ctclToRpmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opMinSpd = this.opMinSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onDeckPerTrKnt = this.onDeckPerTrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmHgt = this.trsmHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onDeckPerRowKnt = this.onDeckPerRowKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htchCvrInHldKnt = this.htchCvrInHldKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelSavEqFlg = this.fuelSavEqFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opMinRpmNo = this.opMinRpmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inHldPerRowKnt = this.inHldPerRowKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprSlwStmngFlg = this.sprSlwStmngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inHldPerTrKnt = this.inHldPerTrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLodRto = this.vslLodRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ampTpCd = this.ampTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
