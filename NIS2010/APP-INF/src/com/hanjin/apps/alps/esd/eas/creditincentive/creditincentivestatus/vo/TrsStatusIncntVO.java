/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TrsStatusIncntVO.java
*@FileTitle : TrsStatusIncntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.15 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrsStatusIncntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrsStatusIncntVO> models = new ArrayList<TrsStatusIncntVO>();
	
	/* Column Info */
	private String decCntrVolQty = null;
	/* Column Info */
	private String incntDesc = null;
	/* Column Info */
	private String orgYdDesc = null;
	/* Column Info */
	private String invIssDtRmk = null;
	/* Column Info */
	private String atchFileLnkId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String junIncntAmt = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String destYdDesc = null;
	/* Column Info */
	private String julIncntAmt = null;
	/* Column Info */
	private String atch2Flg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ttlRcvAmt = null;
	/* Column Info */
	private String aprIncntAmt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String invTrnsModCd = null;
	/* Column Info */
	private String febCntrVolQty = null;
	/* Column Info */
	private String atchFlg = null;
	/* Column Info */
	private String atchN2ndFileLnkId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ttlRmnAmt = null;
	/* Column Info */
	private String ttlIncntUsdAmt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String augCntrVolQty = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String ttlIncntAmt = null;
	/* Column Info */
	private String incntUtCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ttlRcvUsdAmt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String incntNo = null;
	/* Column Info */
	private String janIncntAmt = null;
	/* Column Info */
	private String ttlRmnUsdAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String estmCntrVolQty = null;
	/* Column Info */
	private String cntrUtIncntAmt = null;
	/* Column Info */
	private String julCntrVolQty = null;
	/* Column Info */
	private String marCntrVolQty = null;
	/* Column Info */
	private String invCycCd = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String aprCntrVolQty = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String janCntrVolQty = null;
	/* Column Info */
	private String febIncntAmt = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String rctDtRmk = null;
	/* Column Info */
	private String junCntrVolQty = null;
	/* Column Info */
	private String mayCntrVolQty = null;
	/* Column Info */
	private String octIncntAmt = null;
	/* Column Info */
	private String augIncntAmt = null;
	/* Column Info */
	private String decIncntAmt = null;
	/* Column Info */
	private String usdRt = null;
	/* Column Info */
	private String marIncntAmt = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String sepCntrVolQty = null;
	/* Column Info */
	private String novCntrVolQty = null;
	/* Column Info */
	private String ttlCntrVolQty = null;
	/* Column Info */
	private String sepIncntAmt = null;
	/* Column Info */
	private String incntRmk = null;
	/* Column Info */
	private String octCntrVolQty = null;
	/* Column Info */
	private String novIncntAmt = null;
	/* Column Info */
	private String mayIncntAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TrsStatusIncntVO() {}

	public TrsStatusIncntVO(String ibflag, String pagerows, String bseYr, String incntNo, String rhqCd, String invOfcCd, String invTrnsModCd, String vndrSeq, String vndrNm, String orgYdDesc, String destYdDesc, String effFmDt, String effToDt, String invCycCd, String invIssDtRmk, String fullMtyCd, String lgsCostCd, String incntUtCd, String janCntrVolQty, String febCntrVolQty, String marCntrVolQty, String aprCntrVolQty, String mayCntrVolQty, String junCntrVolQty, String julCntrVolQty, String augCntrVolQty, String sepCntrVolQty, String octCntrVolQty, String novCntrVolQty, String decCntrVolQty, String ttlCntrVolQty, String estmCntrVolQty, String currCd, String cntrUtIncntAmt, String janIncntAmt, String febIncntAmt, String marIncntAmt, String aprIncntAmt, String mayIncntAmt, String junIncntAmt, String julIncntAmt, String augIncntAmt, String sepIncntAmt, String octIncntAmt, String novIncntAmt, String decIncntAmt, String ttlIncntAmt, String ttlRcvAmt, String ttlRmnAmt, String ttlIncntUsdAmt, String ttlRcvUsdAmt, String ttlRmnUsdAmt, String rctDtRmk, String incntDesc, String incntRmk, String atch2Flg, String atchN2ndFileLnkId, String atchFlg, String atchFileLnkId, String usdRt, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.decCntrVolQty = decCntrVolQty;
		this.incntDesc = incntDesc;
		this.orgYdDesc = orgYdDesc;
		this.invIssDtRmk = invIssDtRmk;
		this.atchFileLnkId = atchFileLnkId;
		this.pagerows = pagerows;
		this.junIncntAmt = junIncntAmt;
		this.vndrNm = vndrNm;
		this.destYdDesc = destYdDesc;
		this.julIncntAmt = julIncntAmt;
		this.atch2Flg = atch2Flg;
		this.updUsrId = updUsrId;
		this.ttlRcvAmt = ttlRcvAmt;
		this.aprIncntAmt = aprIncntAmt;
		this.rhqCd = rhqCd;
		this.invTrnsModCd = invTrnsModCd;
		this.febCntrVolQty = febCntrVolQty;
		this.atchFlg = atchFlg;
		this.atchN2ndFileLnkId = atchN2ndFileLnkId;
		this.creUsrId = creUsrId;
		this.ttlRmnAmt = ttlRmnAmt;
		this.ttlIncntUsdAmt = ttlIncntUsdAmt;
		this.vndrSeq = vndrSeq;
		this.fullMtyCd = fullMtyCd;
		this.augCntrVolQty = augCntrVolQty;
		this.effToDt = effToDt;
		this.ttlIncntAmt = ttlIncntAmt;
		this.incntUtCd = incntUtCd;
		this.currCd = currCd;
		this.ttlRcvUsdAmt = ttlRcvUsdAmt;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.incntNo = incntNo;
		this.janIncntAmt = janIncntAmt;
		this.ttlRmnUsdAmt = ttlRmnUsdAmt;
		this.ibflag = ibflag;
		this.estmCntrVolQty = estmCntrVolQty;
		this.cntrUtIncntAmt = cntrUtIncntAmt;
		this.julCntrVolQty = julCntrVolQty;
		this.marCntrVolQty = marCntrVolQty;
		this.invCycCd = invCycCd;
		this.effFmDt = effFmDt;
		this.aprCntrVolQty = aprCntrVolQty;
		this.invOfcCd = invOfcCd;
		this.updDt = updDt;
		this.janCntrVolQty = janCntrVolQty;
		this.febIncntAmt = febIncntAmt;
		this.bseYr = bseYr;
		this.rctDtRmk = rctDtRmk;
		this.junCntrVolQty = junCntrVolQty;
		this.mayCntrVolQty = mayCntrVolQty;
		this.octIncntAmt = octIncntAmt;
		this.augIncntAmt = augIncntAmt;
		this.decIncntAmt = decIncntAmt;
		this.usdRt = usdRt;
		this.marIncntAmt = marIncntAmt;
		this.lgsCostCd = lgsCostCd;
		this.sepCntrVolQty = sepCntrVolQty;
		this.novCntrVolQty = novCntrVolQty;
		this.ttlCntrVolQty = ttlCntrVolQty;
		this.sepIncntAmt = sepIncntAmt;
		this.incntRmk = incntRmk;
		this.octCntrVolQty = octCntrVolQty;
		this.novIncntAmt = novIncntAmt;
		this.mayIncntAmt = mayIncntAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dec_cntr_vol_qty", getDecCntrVolQty());
		this.hashColumns.put("incnt_desc", getIncntDesc());
		this.hashColumns.put("org_yd_desc", getOrgYdDesc());
		this.hashColumns.put("inv_iss_dt_rmk", getInvIssDtRmk());
		this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("jun_incnt_amt", getJunIncntAmt());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("dest_yd_desc", getDestYdDesc());
		this.hashColumns.put("jul_incnt_amt", getJulIncntAmt());
		this.hashColumns.put("atch2_flg", getAtch2Flg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ttl_rcv_amt", getTtlRcvAmt());
		this.hashColumns.put("apr_incnt_amt", getAprIncntAmt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("inv_trns_mod_cd", getInvTrnsModCd());
		this.hashColumns.put("feb_cntr_vol_qty", getFebCntrVolQty());
		this.hashColumns.put("atch_flg", getAtchFlg());
		this.hashColumns.put("atch_n2nd_file_lnk_id", getAtchN2ndFileLnkId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ttl_rmn_amt", getTtlRmnAmt());
		this.hashColumns.put("ttl_incnt_usd_amt", getTtlIncntUsdAmt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("aug_cntr_vol_qty", getAugCntrVolQty());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("ttl_incnt_amt", getTtlIncntAmt());
		this.hashColumns.put("incnt_ut_cd", getIncntUtCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ttl_rcv_usd_amt", getTtlRcvUsdAmt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("incnt_no", getIncntNo());
		this.hashColumns.put("jan_incnt_amt", getJanIncntAmt());
		this.hashColumns.put("ttl_rmn_usd_amt", getTtlRmnUsdAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("estm_cntr_vol_qty", getEstmCntrVolQty());
		this.hashColumns.put("cntr_ut_incnt_amt", getCntrUtIncntAmt());
		this.hashColumns.put("jul_cntr_vol_qty", getJulCntrVolQty());
		this.hashColumns.put("mar_cntr_vol_qty", getMarCntrVolQty());
		this.hashColumns.put("inv_cyc_cd", getInvCycCd());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("apr_cntr_vol_qty", getAprCntrVolQty());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("jan_cntr_vol_qty", getJanCntrVolQty());
		this.hashColumns.put("feb_incnt_amt", getFebIncntAmt());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("rct_dt_rmk", getRctDtRmk());
		this.hashColumns.put("jun_cntr_vol_qty", getJunCntrVolQty());
		this.hashColumns.put("may_cntr_vol_qty", getMayCntrVolQty());
		this.hashColumns.put("oct_incnt_amt", getOctIncntAmt());
		this.hashColumns.put("aug_incnt_amt", getAugIncntAmt());
		this.hashColumns.put("dec_incnt_amt", getDecIncntAmt());
		this.hashColumns.put("usd_rt", getUsdRt());
		this.hashColumns.put("mar_incnt_amt", getMarIncntAmt());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("sep_cntr_vol_qty", getSepCntrVolQty());
		this.hashColumns.put("nov_cntr_vol_qty", getNovCntrVolQty());
		this.hashColumns.put("ttl_cntr_vol_qty", getTtlCntrVolQty());
		this.hashColumns.put("sep_incnt_amt", getSepIncntAmt());
		this.hashColumns.put("incnt_rmk", getIncntRmk());
		this.hashColumns.put("oct_cntr_vol_qty", getOctCntrVolQty());
		this.hashColumns.put("nov_incnt_amt", getNovIncntAmt());
		this.hashColumns.put("may_incnt_amt", getMayIncntAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dec_cntr_vol_qty", "decCntrVolQty");
		this.hashFields.put("incnt_desc", "incntDesc");
		this.hashFields.put("org_yd_desc", "orgYdDesc");
		this.hashFields.put("inv_iss_dt_rmk", "invIssDtRmk");
		this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("jun_incnt_amt", "junIncntAmt");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("dest_yd_desc", "destYdDesc");
		this.hashFields.put("jul_incnt_amt", "julIncntAmt");
		this.hashFields.put("atch2_flg", "atch2Flg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ttl_rcv_amt", "ttlRcvAmt");
		this.hashFields.put("apr_incnt_amt", "aprIncntAmt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("inv_trns_mod_cd", "invTrnsModCd");
		this.hashFields.put("feb_cntr_vol_qty", "febCntrVolQty");
		this.hashFields.put("atch_flg", "atchFlg");
		this.hashFields.put("atch_n2nd_file_lnk_id", "atchN2ndFileLnkId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ttl_rmn_amt", "ttlRmnAmt");
		this.hashFields.put("ttl_incnt_usd_amt", "ttlIncntUsdAmt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("aug_cntr_vol_qty", "augCntrVolQty");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("ttl_incnt_amt", "ttlIncntAmt");
		this.hashFields.put("incnt_ut_cd", "incntUtCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ttl_rcv_usd_amt", "ttlRcvUsdAmt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("incnt_no", "incntNo");
		this.hashFields.put("jan_incnt_amt", "janIncntAmt");
		this.hashFields.put("ttl_rmn_usd_amt", "ttlRmnUsdAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("estm_cntr_vol_qty", "estmCntrVolQty");
		this.hashFields.put("cntr_ut_incnt_amt", "cntrUtIncntAmt");
		this.hashFields.put("jul_cntr_vol_qty", "julCntrVolQty");
		this.hashFields.put("mar_cntr_vol_qty", "marCntrVolQty");
		this.hashFields.put("inv_cyc_cd", "invCycCd");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("apr_cntr_vol_qty", "aprCntrVolQty");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("jan_cntr_vol_qty", "janCntrVolQty");
		this.hashFields.put("feb_incnt_amt", "febIncntAmt");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("rct_dt_rmk", "rctDtRmk");
		this.hashFields.put("jun_cntr_vol_qty", "junCntrVolQty");
		this.hashFields.put("may_cntr_vol_qty", "mayCntrVolQty");
		this.hashFields.put("oct_incnt_amt", "octIncntAmt");
		this.hashFields.put("aug_incnt_amt", "augIncntAmt");
		this.hashFields.put("dec_incnt_amt", "decIncntAmt");
		this.hashFields.put("usd_rt", "usdRt");
		this.hashFields.put("mar_incnt_amt", "marIncntAmt");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("sep_cntr_vol_qty", "sepCntrVolQty");
		this.hashFields.put("nov_cntr_vol_qty", "novCntrVolQty");
		this.hashFields.put("ttl_cntr_vol_qty", "ttlCntrVolQty");
		this.hashFields.put("sep_incnt_amt", "sepIncntAmt");
		this.hashFields.put("incnt_rmk", "incntRmk");
		this.hashFields.put("oct_cntr_vol_qty", "octCntrVolQty");
		this.hashFields.put("nov_incnt_amt", "novIncntAmt");
		this.hashFields.put("may_incnt_amt", "mayIncntAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return decCntrVolQty
	 */
	public String getDecCntrVolQty() {
		return this.decCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return incntDesc
	 */
	public String getIncntDesc() {
		return this.incntDesc;
	}
	
	/**
	 * Column Info
	 * @return orgYdDesc
	 */
	public String getOrgYdDesc() {
		return this.orgYdDesc;
	}
	
	/**
	 * Column Info
	 * @return invIssDtRmk
	 */
	public String getInvIssDtRmk() {
		return this.invIssDtRmk;
	}
	
	/**
	 * Column Info
	 * @return atchFileLnkId
	 */
	public String getAtchFileLnkId() {
		return this.atchFileLnkId;
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
	 * @return junIncntAmt
	 */
	public String getJunIncntAmt() {
		return this.junIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return destYdDesc
	 */
	public String getDestYdDesc() {
		return this.destYdDesc;
	}
	
	/**
	 * Column Info
	 * @return julIncntAmt
	 */
	public String getJulIncntAmt() {
		return this.julIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return atch2Flg
	 */
	public String getAtch2Flg() {
		return this.atch2Flg;
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
	 * @return ttlRcvAmt
	 */
	public String getTtlRcvAmt() {
		return this.ttlRcvAmt;
	}
	
	/**
	 * Column Info
	 * @return aprIncntAmt
	 */
	public String getAprIncntAmt() {
		return this.aprIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return invTrnsModCd
	 */
	public String getInvTrnsModCd() {
		return this.invTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @return febCntrVolQty
	 */
	public String getFebCntrVolQty() {
		return this.febCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return atchFlg
	 */
	public String getAtchFlg() {
		return this.atchFlg;
	}
	
	/**
	 * Column Info
	 * @return atchN2ndFileLnkId
	 */
	public String getAtchN2ndFileLnkId() {
		return this.atchN2ndFileLnkId;
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
	 * @return ttlRmnAmt
	 */
	public String getTtlRmnAmt() {
		return this.ttlRmnAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlIncntUsdAmt
	 */
	public String getTtlIncntUsdAmt() {
		return this.ttlIncntUsdAmt;
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
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return augCntrVolQty
	 */
	public String getAugCntrVolQty() {
		return this.augCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
	}
	
	/**
	 * Column Info
	 * @return ttlIncntAmt
	 */
	public String getTtlIncntAmt() {
		return this.ttlIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return incntUtCd
	 */
	public String getIncntUtCd() {
		return this.incntUtCd;
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
	 * @return ttlRcvUsdAmt
	 */
	public String getTtlRcvUsdAmt() {
		return this.ttlRcvUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return incntNo
	 */
	public String getIncntNo() {
		return this.incntNo;
	}
	
	/**
	 * Column Info
	 * @return janIncntAmt
	 */
	public String getJanIncntAmt() {
		return this.janIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlRmnUsdAmt
	 */
	public String getTtlRmnUsdAmt() {
		return this.ttlRmnUsdAmt;
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
	 * @return estmCntrVolQty
	 */
	public String getEstmCntrVolQty() {
		return this.estmCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return cntrUtIncntAmt
	 */
	public String getCntrUtIncntAmt() {
		return this.cntrUtIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return julCntrVolQty
	 */
	public String getJulCntrVolQty() {
		return this.julCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return marCntrVolQty
	 */
	public String getMarCntrVolQty() {
		return this.marCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return invCycCd
	 */
	public String getInvCycCd() {
		return this.invCycCd;
	}
	
	/**
	 * Column Info
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
	}
	
	/**
	 * Column Info
	 * @return aprCntrVolQty
	 */
	public String getAprCntrVolQty() {
		return this.aprCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
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
	 * @return janCntrVolQty
	 */
	public String getJanCntrVolQty() {
		return this.janCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return febIncntAmt
	 */
	public String getFebIncntAmt() {
		return this.febIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return rctDtRmk
	 */
	public String getRctDtRmk() {
		return this.rctDtRmk;
	}
	
	/**
	 * Column Info
	 * @return junCntrVolQty
	 */
	public String getJunCntrVolQty() {
		return this.junCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return mayCntrVolQty
	 */
	public String getMayCntrVolQty() {
		return this.mayCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return octIncntAmt
	 */
	public String getOctIncntAmt() {
		return this.octIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return augIncntAmt
	 */
	public String getAugIncntAmt() {
		return this.augIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return decIncntAmt
	 */
	public String getDecIncntAmt() {
		return this.decIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return usdRt
	 */
	public String getUsdRt() {
		return this.usdRt;
	}
	
	/**
	 * Column Info
	 * @return marIncntAmt
	 */
	public String getMarIncntAmt() {
		return this.marIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return sepCntrVolQty
	 */
	public String getSepCntrVolQty() {
		return this.sepCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return novCntrVolQty
	 */
	public String getNovCntrVolQty() {
		return this.novCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return ttlCntrVolQty
	 */
	public String getTtlCntrVolQty() {
		return this.ttlCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return sepIncntAmt
	 */
	public String getSepIncntAmt() {
		return this.sepIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return incntRmk
	 */
	public String getIncntRmk() {
		return this.incntRmk;
	}
	
	/**
	 * Column Info
	 * @return octCntrVolQty
	 */
	public String getOctCntrVolQty() {
		return this.octCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return novIncntAmt
	 */
	public String getNovIncntAmt() {
		return this.novIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return mayIncntAmt
	 */
	public String getMayIncntAmt() {
		return this.mayIncntAmt;
	}
	

	/**
	 * Column Info
	 * @param decCntrVolQty
	 */
	public void setDecCntrVolQty(String decCntrVolQty) {
		this.decCntrVolQty = decCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param incntDesc
	 */
	public void setIncntDesc(String incntDesc) {
		this.incntDesc = incntDesc;
	}
	
	/**
	 * Column Info
	 * @param orgYdDesc
	 */
	public void setOrgYdDesc(String orgYdDesc) {
		this.orgYdDesc = orgYdDesc;
	}
	
	/**
	 * Column Info
	 * @param invIssDtRmk
	 */
	public void setInvIssDtRmk(String invIssDtRmk) {
		this.invIssDtRmk = invIssDtRmk;
	}
	
	/**
	 * Column Info
	 * @param atchFileLnkId
	 */
	public void setAtchFileLnkId(String atchFileLnkId) {
		this.atchFileLnkId = atchFileLnkId;
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
	 * @param junIncntAmt
	 */
	public void setJunIncntAmt(String junIncntAmt) {
		this.junIncntAmt = junIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param destYdDesc
	 */
	public void setDestYdDesc(String destYdDesc) {
		this.destYdDesc = destYdDesc;
	}
	
	/**
	 * Column Info
	 * @param julIncntAmt
	 */
	public void setJulIncntAmt(String julIncntAmt) {
		this.julIncntAmt = julIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param atch2Flg
	 */
	public void setAtch2Flg(String atch2Flg) {
		this.atch2Flg = atch2Flg;
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
	 * @param ttlRcvAmt
	 */
	public void setTtlRcvAmt(String ttlRcvAmt) {
		this.ttlRcvAmt = ttlRcvAmt;
	}
	
	/**
	 * Column Info
	 * @param aprIncntAmt
	 */
	public void setAprIncntAmt(String aprIncntAmt) {
		this.aprIncntAmt = aprIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param invTrnsModCd
	 */
	public void setInvTrnsModCd(String invTrnsModCd) {
		this.invTrnsModCd = invTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param febCntrVolQty
	 */
	public void setFebCntrVolQty(String febCntrVolQty) {
		this.febCntrVolQty = febCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param atchFlg
	 */
	public void setAtchFlg(String atchFlg) {
		this.atchFlg = atchFlg;
	}
	
	/**
	 * Column Info
	 * @param atchN2ndFileLnkId
	 */
	public void setAtchN2ndFileLnkId(String atchN2ndFileLnkId) {
		this.atchN2ndFileLnkId = atchN2ndFileLnkId;
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
	 * @param ttlRmnAmt
	 */
	public void setTtlRmnAmt(String ttlRmnAmt) {
		this.ttlRmnAmt = ttlRmnAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlIncntUsdAmt
	 */
	public void setTtlIncntUsdAmt(String ttlIncntUsdAmt) {
		this.ttlIncntUsdAmt = ttlIncntUsdAmt;
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
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param augCntrVolQty
	 */
	public void setAugCntrVolQty(String augCntrVolQty) {
		this.augCntrVolQty = augCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
	}
	
	/**
	 * Column Info
	 * @param ttlIncntAmt
	 */
	public void setTtlIncntAmt(String ttlIncntAmt) {
		this.ttlIncntAmt = ttlIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param incntUtCd
	 */
	public void setIncntUtCd(String incntUtCd) {
		this.incntUtCd = incntUtCd;
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
	 * @param ttlRcvUsdAmt
	 */
	public void setTtlRcvUsdAmt(String ttlRcvUsdAmt) {
		this.ttlRcvUsdAmt = ttlRcvUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param incntNo
	 */
	public void setIncntNo(String incntNo) {
		this.incntNo = incntNo;
	}
	
	/**
	 * Column Info
	 * @param janIncntAmt
	 */
	public void setJanIncntAmt(String janIncntAmt) {
		this.janIncntAmt = janIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlRmnUsdAmt
	 */
	public void setTtlRmnUsdAmt(String ttlRmnUsdAmt) {
		this.ttlRmnUsdAmt = ttlRmnUsdAmt;
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
	 * @param estmCntrVolQty
	 */
	public void setEstmCntrVolQty(String estmCntrVolQty) {
		this.estmCntrVolQty = estmCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param cntrUtIncntAmt
	 */
	public void setCntrUtIncntAmt(String cntrUtIncntAmt) {
		this.cntrUtIncntAmt = cntrUtIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param julCntrVolQty
	 */
	public void setJulCntrVolQty(String julCntrVolQty) {
		this.julCntrVolQty = julCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param marCntrVolQty
	 */
	public void setMarCntrVolQty(String marCntrVolQty) {
		this.marCntrVolQty = marCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param invCycCd
	 */
	public void setInvCycCd(String invCycCd) {
		this.invCycCd = invCycCd;
	}
	
	/**
	 * Column Info
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
	}
	
	/**
	 * Column Info
	 * @param aprCntrVolQty
	 */
	public void setAprCntrVolQty(String aprCntrVolQty) {
		this.aprCntrVolQty = aprCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
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
	 * @param janCntrVolQty
	 */
	public void setJanCntrVolQty(String janCntrVolQty) {
		this.janCntrVolQty = janCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param febIncntAmt
	 */
	public void setFebIncntAmt(String febIncntAmt) {
		this.febIncntAmt = febIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param rctDtRmk
	 */
	public void setRctDtRmk(String rctDtRmk) {
		this.rctDtRmk = rctDtRmk;
	}
	
	/**
	 * Column Info
	 * @param junCntrVolQty
	 */
	public void setJunCntrVolQty(String junCntrVolQty) {
		this.junCntrVolQty = junCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param mayCntrVolQty
	 */
	public void setMayCntrVolQty(String mayCntrVolQty) {
		this.mayCntrVolQty = mayCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param octIncntAmt
	 */
	public void setOctIncntAmt(String octIncntAmt) {
		this.octIncntAmt = octIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param augIncntAmt
	 */
	public void setAugIncntAmt(String augIncntAmt) {
		this.augIncntAmt = augIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param decIncntAmt
	 */
	public void setDecIncntAmt(String decIncntAmt) {
		this.decIncntAmt = decIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param usdRt
	 */
	public void setUsdRt(String usdRt) {
		this.usdRt = usdRt;
	}
	
	/**
	 * Column Info
	 * @param marIncntAmt
	 */
	public void setMarIncntAmt(String marIncntAmt) {
		this.marIncntAmt = marIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param sepCntrVolQty
	 */
	public void setSepCntrVolQty(String sepCntrVolQty) {
		this.sepCntrVolQty = sepCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param novCntrVolQty
	 */
	public void setNovCntrVolQty(String novCntrVolQty) {
		this.novCntrVolQty = novCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param ttlCntrVolQty
	 */
	public void setTtlCntrVolQty(String ttlCntrVolQty) {
		this.ttlCntrVolQty = ttlCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param sepIncntAmt
	 */
	public void setSepIncntAmt(String sepIncntAmt) {
		this.sepIncntAmt = sepIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param incntRmk
	 */
	public void setIncntRmk(String incntRmk) {
		this.incntRmk = incntRmk;
	}
	
	/**
	 * Column Info
	 * @param octCntrVolQty
	 */
	public void setOctCntrVolQty(String octCntrVolQty) {
		this.octCntrVolQty = octCntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param novIncntAmt
	 */
	public void setNovIncntAmt(String novIncntAmt) {
		this.novIncntAmt = novIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param mayIncntAmt
	 */
	public void setMayIncntAmt(String mayIncntAmt) {
		this.mayIncntAmt = mayIncntAmt;
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
		setDecCntrVolQty(JSPUtil.getParameter(request, prefix + "dec_cntr_vol_qty", ""));
		setIncntDesc(JSPUtil.getParameter(request, prefix + "incnt_desc", ""));
		setOrgYdDesc(JSPUtil.getParameter(request, prefix + "org_yd_desc", ""));
		setInvIssDtRmk(JSPUtil.getParameter(request, prefix + "inv_iss_dt_rmk", ""));
		setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setJunIncntAmt(JSPUtil.getParameter(request, prefix + "jun_incnt_amt", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setDestYdDesc(JSPUtil.getParameter(request, prefix + "dest_yd_desc", ""));
		setJulIncntAmt(JSPUtil.getParameter(request, prefix + "jul_incnt_amt", ""));
		setAtch2Flg(JSPUtil.getParameter(request, prefix + "atch2_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setTtlRcvAmt(JSPUtil.getParameter(request, prefix + "ttl_rcv_amt", ""));
		setAprIncntAmt(JSPUtil.getParameter(request, prefix + "apr_incnt_amt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setInvTrnsModCd(JSPUtil.getParameter(request, prefix + "inv_trns_mod_cd", ""));
		setFebCntrVolQty(JSPUtil.getParameter(request, prefix + "feb_cntr_vol_qty", ""));
		setAtchFlg(JSPUtil.getParameter(request, prefix + "atch_flg", ""));
		setAtchN2ndFileLnkId(JSPUtil.getParameter(request, prefix + "atch_n2nd_file_lnk_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTtlRmnAmt(JSPUtil.getParameter(request, prefix + "ttl_rmn_amt", ""));
		setTtlIncntUsdAmt(JSPUtil.getParameter(request, prefix + "ttl_incnt_usd_amt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setAugCntrVolQty(JSPUtil.getParameter(request, prefix + "aug_cntr_vol_qty", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setTtlIncntAmt(JSPUtil.getParameter(request, prefix + "ttl_incnt_amt", ""));
		setIncntUtCd(JSPUtil.getParameter(request, prefix + "incnt_ut_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTtlRcvUsdAmt(JSPUtil.getParameter(request, prefix + "ttl_rcv_usd_amt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setIncntNo(JSPUtil.getParameter(request, prefix + "incnt_no", ""));
		setJanIncntAmt(JSPUtil.getParameter(request, prefix + "jan_incnt_amt", ""));
		setTtlRmnUsdAmt(JSPUtil.getParameter(request, prefix + "ttl_rmn_usd_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEstmCntrVolQty(JSPUtil.getParameter(request, prefix + "estm_cntr_vol_qty", ""));
		setCntrUtIncntAmt(JSPUtil.getParameter(request, prefix + "cntr_ut_incnt_amt", ""));
		setJulCntrVolQty(JSPUtil.getParameter(request, prefix + "jul_cntr_vol_qty", ""));
		setMarCntrVolQty(JSPUtil.getParameter(request, prefix + "mar_cntr_vol_qty", ""));
		setInvCycCd(JSPUtil.getParameter(request, prefix + "inv_cyc_cd", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setAprCntrVolQty(JSPUtil.getParameter(request, prefix + "apr_cntr_vol_qty", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setJanCntrVolQty(JSPUtil.getParameter(request, prefix + "jan_cntr_vol_qty", ""));
		setFebIncntAmt(JSPUtil.getParameter(request, prefix + "feb_incnt_amt", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setRctDtRmk(JSPUtil.getParameter(request, prefix + "rct_dt_rmk", ""));
		setJunCntrVolQty(JSPUtil.getParameter(request, prefix + "jun_cntr_vol_qty", ""));
		setMayCntrVolQty(JSPUtil.getParameter(request, prefix + "may_cntr_vol_qty", ""));
		setOctIncntAmt(JSPUtil.getParameter(request, prefix + "oct_incnt_amt", ""));
		setAugIncntAmt(JSPUtil.getParameter(request, prefix + "aug_incnt_amt", ""));
		setDecIncntAmt(JSPUtil.getParameter(request, prefix + "dec_incnt_amt", ""));
		setUsdRt(JSPUtil.getParameter(request, prefix + "usd_rt", ""));
		setMarIncntAmt(JSPUtil.getParameter(request, prefix + "mar_incnt_amt", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setSepCntrVolQty(JSPUtil.getParameter(request, prefix + "sep_cntr_vol_qty", ""));
		setNovCntrVolQty(JSPUtil.getParameter(request, prefix + "nov_cntr_vol_qty", ""));
		setTtlCntrVolQty(JSPUtil.getParameter(request, prefix + "ttl_cntr_vol_qty", ""));
		setSepIncntAmt(JSPUtil.getParameter(request, prefix + "sep_incnt_amt", ""));
		setIncntRmk(JSPUtil.getParameter(request, prefix + "incnt_rmk", ""));
		setOctCntrVolQty(JSPUtil.getParameter(request, prefix + "oct_cntr_vol_qty", ""));
		setNovIncntAmt(JSPUtil.getParameter(request, prefix + "nov_incnt_amt", ""));
		setMayIncntAmt(JSPUtil.getParameter(request, prefix + "may_incnt_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrsStatusIncntVO[]
	 */
	public TrsStatusIncntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrsStatusIncntVO[]
	 */
	public TrsStatusIncntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsStatusIncntVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] decCntrVolQty = (JSPUtil.getParameter(request, prefix	+ "dec_cntr_vol_qty", length));
			String[] incntDesc = (JSPUtil.getParameter(request, prefix	+ "incnt_desc", length));
			String[] orgYdDesc = (JSPUtil.getParameter(request, prefix	+ "org_yd_desc", length));
			String[] invIssDtRmk = (JSPUtil.getParameter(request, prefix	+ "inv_iss_dt_rmk", length));
			String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] junIncntAmt = (JSPUtil.getParameter(request, prefix	+ "jun_incnt_amt", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] destYdDesc = (JSPUtil.getParameter(request, prefix	+ "dest_yd_desc", length));
			String[] julIncntAmt = (JSPUtil.getParameter(request, prefix	+ "jul_incnt_amt", length));
			String[] atch2Flg = (JSPUtil.getParameter(request, prefix	+ "atch2_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ttlRcvAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_rcv_amt", length));
			String[] aprIncntAmt = (JSPUtil.getParameter(request, prefix	+ "apr_incnt_amt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] invTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "inv_trns_mod_cd", length));
			String[] febCntrVolQty = (JSPUtil.getParameter(request, prefix	+ "feb_cntr_vol_qty", length));
			String[] atchFlg = (JSPUtil.getParameter(request, prefix	+ "atch_flg", length));
			String[] atchN2ndFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_n2nd_file_lnk_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ttlRmnAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_rmn_amt", length));
			String[] ttlIncntUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_incnt_usd_amt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] augCntrVolQty = (JSPUtil.getParameter(request, prefix	+ "aug_cntr_vol_qty", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] ttlIncntAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_incnt_amt", length));
			String[] incntUtCd = (JSPUtil.getParameter(request, prefix	+ "incnt_ut_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ttlRcvUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_rcv_usd_amt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] incntNo = (JSPUtil.getParameter(request, prefix	+ "incnt_no", length));
			String[] janIncntAmt = (JSPUtil.getParameter(request, prefix	+ "jan_incnt_amt", length));
			String[] ttlRmnUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_rmn_usd_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] estmCntrVolQty = (JSPUtil.getParameter(request, prefix	+ "estm_cntr_vol_qty", length));
			String[] cntrUtIncntAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_ut_incnt_amt", length));
			String[] julCntrVolQty = (JSPUtil.getParameter(request, prefix	+ "jul_cntr_vol_qty", length));
			String[] marCntrVolQty = (JSPUtil.getParameter(request, prefix	+ "mar_cntr_vol_qty", length));
			String[] invCycCd = (JSPUtil.getParameter(request, prefix	+ "inv_cyc_cd", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] aprCntrVolQty = (JSPUtil.getParameter(request, prefix	+ "apr_cntr_vol_qty", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] janCntrVolQty = (JSPUtil.getParameter(request, prefix	+ "jan_cntr_vol_qty", length));
			String[] febIncntAmt = (JSPUtil.getParameter(request, prefix	+ "feb_incnt_amt", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] rctDtRmk = (JSPUtil.getParameter(request, prefix	+ "rct_dt_rmk", length));
			String[] junCntrVolQty = (JSPUtil.getParameter(request, prefix	+ "jun_cntr_vol_qty", length));
			String[] mayCntrVolQty = (JSPUtil.getParameter(request, prefix	+ "may_cntr_vol_qty", length));
			String[] octIncntAmt = (JSPUtil.getParameter(request, prefix	+ "oct_incnt_amt", length));
			String[] augIncntAmt = (JSPUtil.getParameter(request, prefix	+ "aug_incnt_amt", length));
			String[] decIncntAmt = (JSPUtil.getParameter(request, prefix	+ "dec_incnt_amt", length));
			String[] usdRt = (JSPUtil.getParameter(request, prefix	+ "usd_rt", length));
			String[] marIncntAmt = (JSPUtil.getParameter(request, prefix	+ "mar_incnt_amt", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] sepCntrVolQty = (JSPUtil.getParameter(request, prefix	+ "sep_cntr_vol_qty", length));
			String[] novCntrVolQty = (JSPUtil.getParameter(request, prefix	+ "nov_cntr_vol_qty", length));
			String[] ttlCntrVolQty = (JSPUtil.getParameter(request, prefix	+ "ttl_cntr_vol_qty", length));
			String[] sepIncntAmt = (JSPUtil.getParameter(request, prefix	+ "sep_incnt_amt", length));
			String[] incntRmk = (JSPUtil.getParameter(request, prefix	+ "incnt_rmk", length));
			String[] octCntrVolQty = (JSPUtil.getParameter(request, prefix	+ "oct_cntr_vol_qty", length));
			String[] novIncntAmt = (JSPUtil.getParameter(request, prefix	+ "nov_incnt_amt", length));
			String[] mayIncntAmt = (JSPUtil.getParameter(request, prefix	+ "may_incnt_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrsStatusIncntVO();
				if (decCntrVolQty[i] != null)
					model.setDecCntrVolQty(decCntrVolQty[i]);
				if (incntDesc[i] != null)
					model.setIncntDesc(incntDesc[i]);
				if (orgYdDesc[i] != null)
					model.setOrgYdDesc(orgYdDesc[i]);
				if (invIssDtRmk[i] != null)
					model.setInvIssDtRmk(invIssDtRmk[i]);
				if (atchFileLnkId[i] != null)
					model.setAtchFileLnkId(atchFileLnkId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (junIncntAmt[i] != null)
					model.setJunIncntAmt(junIncntAmt[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (destYdDesc[i] != null)
					model.setDestYdDesc(destYdDesc[i]);
				if (julIncntAmt[i] != null)
					model.setJulIncntAmt(julIncntAmt[i]);
				if (atch2Flg[i] != null)
					model.setAtch2Flg(atch2Flg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ttlRcvAmt[i] != null)
					model.setTtlRcvAmt(ttlRcvAmt[i]);
				if (aprIncntAmt[i] != null)
					model.setAprIncntAmt(aprIncntAmt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (invTrnsModCd[i] != null)
					model.setInvTrnsModCd(invTrnsModCd[i]);
				if (febCntrVolQty[i] != null)
					model.setFebCntrVolQty(febCntrVolQty[i]);
				if (atchFlg[i] != null)
					model.setAtchFlg(atchFlg[i]);
				if (atchN2ndFileLnkId[i] != null)
					model.setAtchN2ndFileLnkId(atchN2ndFileLnkId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ttlRmnAmt[i] != null)
					model.setTtlRmnAmt(ttlRmnAmt[i]);
				if (ttlIncntUsdAmt[i] != null)
					model.setTtlIncntUsdAmt(ttlIncntUsdAmt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (augCntrVolQty[i] != null)
					model.setAugCntrVolQty(augCntrVolQty[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (ttlIncntAmt[i] != null)
					model.setTtlIncntAmt(ttlIncntAmt[i]);
				if (incntUtCd[i] != null)
					model.setIncntUtCd(incntUtCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ttlRcvUsdAmt[i] != null)
					model.setTtlRcvUsdAmt(ttlRcvUsdAmt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (incntNo[i] != null)
					model.setIncntNo(incntNo[i]);
				if (janIncntAmt[i] != null)
					model.setJanIncntAmt(janIncntAmt[i]);
				if (ttlRmnUsdAmt[i] != null)
					model.setTtlRmnUsdAmt(ttlRmnUsdAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (estmCntrVolQty[i] != null)
					model.setEstmCntrVolQty(estmCntrVolQty[i]);
				if (cntrUtIncntAmt[i] != null)
					model.setCntrUtIncntAmt(cntrUtIncntAmt[i]);
				if (julCntrVolQty[i] != null)
					model.setJulCntrVolQty(julCntrVolQty[i]);
				if (marCntrVolQty[i] != null)
					model.setMarCntrVolQty(marCntrVolQty[i]);
				if (invCycCd[i] != null)
					model.setInvCycCd(invCycCd[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (aprCntrVolQty[i] != null)
					model.setAprCntrVolQty(aprCntrVolQty[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (janCntrVolQty[i] != null)
					model.setJanCntrVolQty(janCntrVolQty[i]);
				if (febIncntAmt[i] != null)
					model.setFebIncntAmt(febIncntAmt[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (rctDtRmk[i] != null)
					model.setRctDtRmk(rctDtRmk[i]);
				if (junCntrVolQty[i] != null)
					model.setJunCntrVolQty(junCntrVolQty[i]);
				if (mayCntrVolQty[i] != null)
					model.setMayCntrVolQty(mayCntrVolQty[i]);
				if (octIncntAmt[i] != null)
					model.setOctIncntAmt(octIncntAmt[i]);
				if (augIncntAmt[i] != null)
					model.setAugIncntAmt(augIncntAmt[i]);
				if (decIncntAmt[i] != null)
					model.setDecIncntAmt(decIncntAmt[i]);
				if (usdRt[i] != null)
					model.setUsdRt(usdRt[i]);
				if (marIncntAmt[i] != null)
					model.setMarIncntAmt(marIncntAmt[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (sepCntrVolQty[i] != null)
					model.setSepCntrVolQty(sepCntrVolQty[i]);
				if (novCntrVolQty[i] != null)
					model.setNovCntrVolQty(novCntrVolQty[i]);
				if (ttlCntrVolQty[i] != null)
					model.setTtlCntrVolQty(ttlCntrVolQty[i]);
				if (sepIncntAmt[i] != null)
					model.setSepIncntAmt(sepIncntAmt[i]);
				if (incntRmk[i] != null)
					model.setIncntRmk(incntRmk[i]);
				if (octCntrVolQty[i] != null)
					model.setOctCntrVolQty(octCntrVolQty[i]);
				if (novIncntAmt[i] != null)
					model.setNovIncntAmt(novIncntAmt[i]);
				if (mayIncntAmt[i] != null)
					model.setMayIncntAmt(mayIncntAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsStatusIncntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrsStatusIncntVO[]
	 */
	public TrsStatusIncntVO[] getTrsStatusIncntVOs(){
		TrsStatusIncntVO[] vos = (TrsStatusIncntVO[])models.toArray(new TrsStatusIncntVO[models.size()]);
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
		this.decCntrVolQty = this.decCntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incntDesc = this.incntDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdDesc = this.orgYdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssDtRmk = this.invIssDtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkId = this.atchFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.junIncntAmt = this.junIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdDesc = this.destYdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.julIncntAmt = this.julIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atch2Flg = this.atch2Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlRcvAmt = this.ttlRcvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aprIncntAmt = this.aprIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTrnsModCd = this.invTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.febCntrVolQty = this.febCntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFlg = this.atchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchN2ndFileLnkId = this.atchN2ndFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlRmnAmt = this.ttlRmnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlIncntUsdAmt = this.ttlIncntUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.augCntrVolQty = this.augCntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlIncntAmt = this.ttlIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incntUtCd = this.incntUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlRcvUsdAmt = this.ttlRcvUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incntNo = this.incntNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.janIncntAmt = this.janIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlRmnUsdAmt = this.ttlRmnUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCntrVolQty = this.estmCntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrUtIncntAmt = this.cntrUtIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.julCntrVolQty = this.julCntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.marCntrVolQty = this.marCntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCycCd = this.invCycCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aprCntrVolQty = this.aprCntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.janCntrVolQty = this.janCntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.febIncntAmt = this.febIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDtRmk = this.rctDtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.junCntrVolQty = this.junCntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mayCntrVolQty = this.mayCntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.octIncntAmt = this.octIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.augIncntAmt = this.augIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.decIncntAmt = this.decIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdRt = this.usdRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.marIncntAmt = this.marIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sepCntrVolQty = this.sepCntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.novCntrVolQty = this.novCntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCntrVolQty = this.ttlCntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sepIncntAmt = this.sepIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incntRmk = this.incntRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.octCntrVolQty = this.octCntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.novIncntAmt = this.novIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mayIncntAmt = this.mayIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
