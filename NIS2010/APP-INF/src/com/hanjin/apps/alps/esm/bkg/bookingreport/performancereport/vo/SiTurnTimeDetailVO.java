/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SiTurnTimeDetailVO.java
*@FileTitle : SiTurnTimeDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.22  
* 1.0 Creation
* 2012.01.05 정선용 [CHM-201115236-01] DPCS S/I Turn Time Report 수정 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SiTurnTimeDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SiTurnTimeDetailVO> models = new ArrayList<SiTurnTimeDetailVO>();
		
	/* Column Info */
	private String idOvt = null;
	/* Column Info */
	private String rtStDt = null;
	/* Column Info */
	private String blAudFlg = null;
	/* Column Info */
	private String pnEndDt = null;
	/* Column Info */
	private String blRtFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rtOvt = null;
	/* Column Info */
	private String srDueDt = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String srCrntInfoCd = null;
	/* Column Info */
	private String pnBizTm = null;
	/* Column Info */
	private String adOvt = null;
	/* Column Info */
	private String cmCnt = null;
	/* Column Info */
	private String adBizTm = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String xterSndrId = null;
	/* Column Info */
	private String blDocInpFlg = null;
	/* Column Info */
	private String idStDt = null;
	/* Column Info */
	private String rdEndDt = null;
	/* Column Info */
	private String tvvd = null;
	/* Column Info */
	private String rdOvt = null;
	/* Column Info */
	private String pnStDt = null;
	/* Column Info */
	private String rdStDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String idEndDt = null;
	/* Column Info */
	private String pnActTm = null;
	/* Column Info */
	private String pndFlg = null;
	/* Column Info */
	private String srCrntStsCd = null;
	/* Column Info */
	private String adActTm = null;
	/* Column Info */
	private String idActTm = null;
	/* Column Info */
	private String rtActTm = null;
	/* Column Info */
	private String hblCnt = null;
	/* Column Info */
	private String rdActTm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String adStDt = null;
	/* Column Info */
	private String srWrkStsCd = null;
	/* Column Info */
	private String rtEndDt = null;
	/* Column Info */
	private String rtBizTm = null;
	/* Column Info */
	private String fntOfcTrnsDt = null;
	/* Column Info */
	private String srAmdTpCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String adEndDt = null;
	/* Column Info */
	private String idBizTm = null;
	/* Column Info */
	private String blDrftFaxOutFlg = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String rdBizTm = null;
	/* Column Info */
	private String holCnt = null;
	/* Column Info */
	private String idSrIdleHrs = null;
	/* Column Info */
	private String idSrWrkTmIdleHrs = null;
	/* Column Info */
	private String idSrOvtIdleHrs = null;
	/* Column Info */
	private String rdSrIdleHrs = null;
	/* Column Info */
	private String rdSrWrkTmIdleHrs = null;
	/* Column Info */
	private String rdSrOvtIdleHrs = null;
	/* Column Info */
	private String adSrIdleHrs = null;
	/* Column Info */
	private String adSrWrkTmIdleHrs = null;
	/* Column Info */
	private String adSrOvtIdleHrs = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SiTurnTimeDetailVO() {}

	public SiTurnTimeDetailVO(String ibflag, String pagerows, String srNo, String bkgNo, String srAmdTpCd, String bkgOfcCd, String tvvd, String polCd, String podCd, String srKndCd, String cmCnt, String hblCnt, String fntOfcTrnsDt, String srDueDt, String rgnOfcCd, String idStDt, String idEndDt, String idBizTm, String idActTm, String idOvt, String rdStDt, String rdEndDt, String rdBizTm, String rdActTm, String rdOvt, String adStDt, String adEndDt, String adBizTm, String adActTm, String adOvt, String pnStDt, String pnEndDt, String pnBizTm, String pnActTm, String rtStDt, String rtEndDt, String rtBizTm, String rtActTm, String rtOvt, String holCnt, String pndFlg, String srCrntInfoCd, String srCrntStsCd, String blDocInpFlg, String blRtFlg, String blAudFlg, String blDrftFaxOutFlg, String srWrkStsCd, String xterSndrId, String idSrIdleHrs, String idSrWrkTmIdleHrs, String idSrOvtIdleHrs, String rdSrIdleHrs, String rdSrWrkTmIdleHrs, String rdSrOvtIdleHrs, String adSrIdleHrs, String adSrWrkTmIdleHrs, String adSrOvtIdleHrs) {
		this.idOvt = idOvt;
		this.rtStDt = rtStDt;
		this.blAudFlg = blAudFlg;
		this.pnEndDt = pnEndDt;
		this.blRtFlg = blRtFlg;
		this.pagerows = pagerows;
		this.rtOvt = rtOvt;
		this.srDueDt = srDueDt;
		this.polCd = polCd;
		this.srCrntInfoCd = srCrntInfoCd;
		this.pnBizTm = pnBizTm;
		this.adOvt = adOvt;
		this.cmCnt = cmCnt;
		this.adBizTm = adBizTm;
		this.bkgOfcCd = bkgOfcCd;
		this.xterSndrId = xterSndrId;
		this.blDocInpFlg = blDocInpFlg;
		this.idStDt = idStDt;
		this.rdEndDt = rdEndDt;
		this.tvvd = tvvd;
		this.rdOvt = rdOvt;
		this.pnStDt = pnStDt;
		this.rdStDt = rdStDt;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.idEndDt = idEndDt;
		this.pnActTm = pnActTm;
		this.pndFlg = pndFlg;
		this.srCrntStsCd = srCrntStsCd;
		this.adActTm = adActTm;
		this.idActTm = idActTm;
		this.rtActTm = rtActTm;
		this.hblCnt = hblCnt;
		this.rdActTm = rdActTm;
		this.ibflag = ibflag;
		this.srKndCd = srKndCd;
		this.adStDt = adStDt;
		this.srWrkStsCd = srWrkStsCd;
		this.rtEndDt = rtEndDt;
		this.rtBizTm = rtBizTm;
		this.fntOfcTrnsDt = fntOfcTrnsDt;
		this.srAmdTpCd = srAmdTpCd;
		this.rgnOfcCd = rgnOfcCd;
		this.adEndDt = adEndDt;
		this.idBizTm = idBizTm;
		this.blDrftFaxOutFlg = blDrftFaxOutFlg;
		this.srNo = srNo;
		this.rdBizTm = rdBizTm;
		this.holCnt = holCnt;
		this.idSrIdleHrs = idSrIdleHrs;
		this.idSrWrkTmIdleHrs = idSrWrkTmIdleHrs;
		this.idSrOvtIdleHrs = idSrOvtIdleHrs;
		this.rdSrIdleHrs = rdSrIdleHrs;
		this.rdSrWrkTmIdleHrs = rdSrWrkTmIdleHrs;
		this.rdSrOvtIdleHrs = rdSrOvtIdleHrs;
		this.adSrIdleHrs = adSrIdleHrs;
		this.adSrWrkTmIdleHrs = adSrWrkTmIdleHrs;
		this.adSrOvtIdleHrs = adSrOvtIdleHrs;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("id_ovt", getIdOvt());
		this.hashColumns.put("rt_st_dt", getRtStDt());
		this.hashColumns.put("bl_aud_flg", getBlAudFlg());
		this.hashColumns.put("pn_end_dt", getPnEndDt());
		this.hashColumns.put("bl_rt_flg", getBlRtFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rt_ovt", getRtOvt());
		this.hashColumns.put("sr_due_dt", getSrDueDt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sr_crnt_info_cd", getSrCrntInfoCd());
		this.hashColumns.put("pn_biz_tm", getPnBizTm());
		this.hashColumns.put("ad_ovt", getAdOvt());
		this.hashColumns.put("cm_cnt", getCmCnt());
		this.hashColumns.put("ad_biz_tm", getAdBizTm());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("bl_doc_inp_flg", getBlDocInpFlg());
		this.hashColumns.put("id_st_dt", getIdStDt());
		this.hashColumns.put("rd_end_dt", getRdEndDt());
		this.hashColumns.put("tvvd", getTvvd());
		this.hashColumns.put("rd_ovt", getRdOvt());
		this.hashColumns.put("pn_st_dt", getPnStDt());
		this.hashColumns.put("rd_st_dt", getRdStDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("id_end_dt", getIdEndDt());
		this.hashColumns.put("pn_act_tm", getPnActTm());
		this.hashColumns.put("pnd_flg", getPndFlg());
		this.hashColumns.put("sr_crnt_sts_cd", getSrCrntStsCd());
		this.hashColumns.put("ad_act_tm", getAdActTm());
		this.hashColumns.put("id_act_tm", getIdActTm());
		this.hashColumns.put("rt_act_tm", getRtActTm());
		this.hashColumns.put("hbl_cnt", getHblCnt());
		this.hashColumns.put("rd_act_tm", getRdActTm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("ad_st_dt", getAdStDt());
		this.hashColumns.put("sr_wrk_sts_cd", getSrWrkStsCd());
		this.hashColumns.put("rt_end_dt", getRtEndDt());
		this.hashColumns.put("rt_biz_tm", getRtBizTm());
		this.hashColumns.put("fnt_ofc_trns_dt", getFntOfcTrnsDt());
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("ad_end_dt", getAdEndDt());
		this.hashColumns.put("id_biz_tm", getIdBizTm());
		this.hashColumns.put("bl_drft_fax_out_flg", getBlDrftFaxOutFlg());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("rd_biz_tm", getRdBizTm());
		this.hashColumns.put("hol_cnt", getHolCnt());
		this.hashColumns.put("id_sr_idle_hrs", getIdSrIdleHrs());
		this.hashColumns.put("id_sr_wrk_tm_idle_hrs", getIdSrWrkTmIdleHrs());
		this.hashColumns.put("id_sr_ovt_idle_hrs", getIdSrOvtIdleHrs());
		this.hashColumns.put("rd_sr_idle_hrs", getRdSrIdleHrs());
		this.hashColumns.put("rd_sr_wrk_tm_idle_hrs", getRdSrWrkTmIdleHrs());
		this.hashColumns.put("rd_sr_ovt_idle_hrs", getRdSrOvtIdleHrs());
		this.hashColumns.put("ad_sr_idle_hrs", getAdSrIdleHrs());
		this.hashColumns.put("ad_sr_wrk_tm_idle_hrs", getAdSrWrkTmIdleHrs());
		this.hashColumns.put("ad_sr_ovt_idle_hrs", getAdSrOvtIdleHrs());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("id_ovt", "idOvt");
		this.hashFields.put("rt_st_dt", "rtStDt");
		this.hashFields.put("bl_aud_flg", "blAudFlg");
		this.hashFields.put("pn_end_dt", "pnEndDt");
		this.hashFields.put("bl_rt_flg", "blRtFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rt_ovt", "rtOvt");
		this.hashFields.put("sr_due_dt", "srDueDt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sr_crnt_info_cd", "srCrntInfoCd");
		this.hashFields.put("pn_biz_tm", "pnBizTm");
		this.hashFields.put("ad_ovt", "adOvt");
		this.hashFields.put("cm_cnt", "cmCnt");
		this.hashFields.put("ad_biz_tm", "adBizTm");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("bl_doc_inp_flg", "blDocInpFlg");
		this.hashFields.put("id_st_dt", "idStDt");
		this.hashFields.put("rd_end_dt", "rdEndDt");
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("rd_ovt", "rdOvt");
		this.hashFields.put("pn_st_dt", "pnStDt");
		this.hashFields.put("rd_st_dt", "rdStDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("id_end_dt", "idEndDt");
		this.hashFields.put("pn_act_tm", "pnActTm");
		this.hashFields.put("pnd_flg", "pndFlg");
		this.hashFields.put("sr_crnt_sts_cd", "srCrntStsCd");
		this.hashFields.put("ad_act_tm", "adActTm");
		this.hashFields.put("id_act_tm", "idActTm");
		this.hashFields.put("rt_act_tm", "rtActTm");
		this.hashFields.put("hbl_cnt", "hblCnt");
		this.hashFields.put("rd_act_tm", "rdActTm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("ad_st_dt", "adStDt");
		this.hashFields.put("sr_wrk_sts_cd", "srWrkStsCd");
		this.hashFields.put("rt_end_dt", "rtEndDt");
		this.hashFields.put("rt_biz_tm", "rtBizTm");
		this.hashFields.put("fnt_ofc_trns_dt", "fntOfcTrnsDt");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("ad_end_dt", "adEndDt");
		this.hashFields.put("id_biz_tm", "idBizTm");
		this.hashFields.put("bl_drft_fax_out_flg", "blDrftFaxOutFlg");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("rd_biz_tm", "rdBizTm");
		this.hashFields.put("hol_cnt", "holCnt");
		this.hashFields.put("id_sr_idle_hrs", "idSrIdleHrs");
		this.hashFields.put("id_sr_wrk_tm_idle_hrs", "idSrWrkTmIdleHrs");
		this.hashFields.put("id_sr_ovt_idle_hrs", "idSrOvtIdleHrs");
		this.hashFields.put("rd_sr_idle_hrs", "rdSrIdleHrs");
		this.hashFields.put("rd_sr_wrk_tm_idle_hrs", "rdSrWrkTmIdleHrs");
		this.hashFields.put("rd_sr_ovt_idle_hrs", "rdSrOvtIdleHrs");
		this.hashFields.put("ad_sr_idle_hrs", "adSrIdleHrs");
		this.hashFields.put("ad_sr_wrk_tm_idle_hrs", "adSrWrkTmIdleHrs");
		this.hashFields.put("ad_sr_ovt_idle_hrs", "adSrOvtIdleHrs");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return idOvt
	 */
	public String getIdOvt() {
		return this.idOvt;
	}
	
	/**
	 * Column Info
	 * @return rtStDt
	 */
	public String getRtStDt() {
		return this.rtStDt;
	}
	
	/**
	 * Column Info
	 * @return blAudFlg
	 */
	public String getBlAudFlg() {
		return this.blAudFlg;
	}
	
	/**
	 * Column Info
	 * @return pnEndDt
	 */
	public String getPnEndDt() {
		return this.pnEndDt;
	}
	
	/**
	 * Column Info
	 * @return blRtFlg
	 */
	public String getBlRtFlg() {
		return this.blRtFlg;
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
	 * @return rtOvt
	 */
	public String getRtOvt() {
		return this.rtOvt;
	}
	
	/**
	 * Column Info
	 * @return srDueDt
	 */
	public String getSrDueDt() {
		return this.srDueDt;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return srCrntInfoCd
	 */
	public String getSrCrntInfoCd() {
		return this.srCrntInfoCd;
	}
	
	/**
	 * Column Info
	 * @return pnBizTm
	 */
	public String getPnBizTm() {
		return this.pnBizTm;
	}
	
	/**
	 * Column Info
	 * @return adOvt
	 */
	public String getAdOvt() {
		return this.adOvt;
	}
	
	/**
	 * Column Info
	 * @return cmCnt
	 */
	public String getCmCnt() {
		return this.cmCnt;
	}
	
	/**
	 * Column Info
	 * @return adBizTm
	 */
	public String getAdBizTm() {
		return this.adBizTm;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return xterSndrId
	 */
	public String getXterSndrId() {
		return this.xterSndrId;
	}
	
	/**
	 * Column Info
	 * @return blDocInpFlg
	 */
	public String getBlDocInpFlg() {
		return this.blDocInpFlg;
	}
	
	/**
	 * Column Info
	 * @return idStDt
	 */
	public String getIdStDt() {
		return this.idStDt;
	}
	
	/**
	 * Column Info
	 * @return rdEndDt
	 */
	public String getRdEndDt() {
		return this.rdEndDt;
	}
	
	/**
	 * Column Info
	 * @return tvvd
	 */
	public String getTvvd() {
		return this.tvvd;
	}
	
	/**
	 * Column Info
	 * @return rdOvt
	 */
	public String getRdOvt() {
		return this.rdOvt;
	}
	
	/**
	 * Column Info
	 * @return pnStDt
	 */
	public String getPnStDt() {
		return this.pnStDt;
	}
	
	/**
	 * Column Info
	 * @return rdStDt
	 */
	public String getRdStDt() {
		return this.rdStDt;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return idEndDt
	 */
	public String getIdEndDt() {
		return this.idEndDt;
	}
	
	/**
	 * Column Info
	 * @return pnActTm
	 */
	public String getPnActTm() {
		return this.pnActTm;
	}
	
	/**
	 * Column Info
	 * @return pndFlg
	 */
	public String getPndFlg() {
		return this.pndFlg;
	}
	
	/**
	 * Column Info
	 * @return srCrntStsCd
	 */
	public String getSrCrntStsCd() {
		return this.srCrntStsCd;
	}
	
	/**
	 * Column Info
	 * @return adActTm
	 */
	public String getAdActTm() {
		return this.adActTm;
	}
	
	/**
	 * Column Info
	 * @return idActTm
	 */
	public String getIdActTm() {
		return this.idActTm;
	}
	
	/**
	 * Column Info
	 * @return rtActTm
	 */
	public String getRtActTm() {
		return this.rtActTm;
	}
	
	/**
	 * Column Info
	 * @return hblCnt
	 */
	public String getHblCnt() {
		return this.hblCnt;
	}
	
	/**
	 * Column Info
	 * @return rdActTm
	 */
	public String getRdActTm() {
		return this.rdActTm;
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
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
	}
	
	/**
	 * Column Info
	 * @return adStDt
	 */
	public String getAdStDt() {
		return this.adStDt;
	}
	
	/**
	 * Column Info
	 * @return srWrkStsCd
	 */
	public String getSrWrkStsCd() {
		return this.srWrkStsCd;
	}
	
	/**
	 * Column Info
	 * @return rtEndDt
	 */
	public String getRtEndDt() {
		return this.rtEndDt;
	}
	
	/**
	 * Column Info
	 * @return rtBizTm
	 */
	public String getRtBizTm() {
		return this.rtBizTm;
	}
	
	/**
	 * Column Info
	 * @return fntOfcTrnsDt
	 */
	public String getFntOfcTrnsDt() {
		return this.fntOfcTrnsDt;
	}
	
	/**
	 * Column Info
	 * @return srAmdTpCd
	 */
	public String getSrAmdTpCd() {
		return this.srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return adEndDt
	 */
	public String getAdEndDt() {
		return this.adEndDt;
	}
	
	/**
	 * Column Info
	 * @return idBizTm
	 */
	public String getIdBizTm() {
		return this.idBizTm;
	}
	
	/**
	 * Column Info
	 * @return blDrftFaxOutFlg
	 */
	public String getBlDrftFaxOutFlg() {
		return this.blDrftFaxOutFlg;
	}
	
	/**
	 * Column Info
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
	}
	
	/**
	 * Column Info
	 * @return rdBizTm
	 */
	public String getRdBizTm() {
		return this.rdBizTm;
	}
	
	/**
	 * Column Info
	 * @return holCnt
	 */
	public String getHolCnt() {
		return this.holCnt;
	}
	
	/**
	 * Column Info
	 * @return idSrIdleHrs
	 */
	public String getIdSrIdleHrs() {
		return this.idSrIdleHrs;
	}
	
	/**
	 * Column Info
	 * @return idSrWrkTmIdleHrs
	 */
	public String getIdSrWrkTmIdleHrs() {
		return this.idSrWrkTmIdleHrs;
	}
	
	/**
	 * Column Info
	 * @return idSrOvtIdleHrs
	 */
	public String getIdSrOvtIdleHrs() {
		return this.idSrOvtIdleHrs;
	}
	
	/**
	 * Column Info
	 * @return rdSrIdleHrs
	 */
	public String getRdSrIdleHrs() {
		return this.rdSrIdleHrs;
	}
	
	/**
	 * Column Info
	 * @return rdSrWrkTmIdleHrs
	 */
	public String getRdSrWrkTmIdleHrs() {
		return this.rdSrWrkTmIdleHrs;
	}
	
	/**
	 * Column Info
	 * @return rdSrOvtIdleHrs
	 */
	public String getRdSrOvtIdleHrs() {
		return this.rdSrOvtIdleHrs;
	}
	
	/**
	 * Column Info
	 * @return adSrIdleHrs
	 */
	public String getAdSrIdleHrs() {
		return this.adSrIdleHrs;
	}
	
	/**
	 * Column Info
	 * @return adSrWrkTmIdleHrs
	 */
	public String getAdSrWrkTmIdleHrs() {
		return this.adSrWrkTmIdleHrs;
	}
	
	/**
	 * Column Info
	 * @return adSrOvtIdleHrs
	 */
	public String getAdSrOvtIdleHrs() {
		return this.adSrOvtIdleHrs;
	}
	

	/**
	 * Column Info
	 * @param idOvt
	 */
	public void setIdOvt(String idOvt) {
		this.idOvt = idOvt;
	}
	
	/**
	 * Column Info
	 * @param rtStDt
	 */
	public void setRtStDt(String rtStDt) {
		this.rtStDt = rtStDt;
	}
	
	/**
	 * Column Info
	 * @param blAudFlg
	 */
	public void setBlAudFlg(String blAudFlg) {
		this.blAudFlg = blAudFlg;
	}
	
	/**
	 * Column Info
	 * @param pnEndDt
	 */
	public void setPnEndDt(String pnEndDt) {
		this.pnEndDt = pnEndDt;
	}
	
	/**
	 * Column Info
	 * @param blRtFlg
	 */
	public void setBlRtFlg(String blRtFlg) {
		this.blRtFlg = blRtFlg;
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
	 * @param rtOvt
	 */
	public void setRtOvt(String rtOvt) {
		this.rtOvt = rtOvt;
	}
	
	/**
	 * Column Info
	 * @param srDueDt
	 */
	public void setSrDueDt(String srDueDt) {
		this.srDueDt = srDueDt;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param srCrntInfoCd
	 */
	public void setSrCrntInfoCd(String srCrntInfoCd) {
		this.srCrntInfoCd = srCrntInfoCd;
	}
	
	/**
	 * Column Info
	 * @param pnBizTm
	 */
	public void setPnBizTm(String pnBizTm) {
		this.pnBizTm = pnBizTm;
	}
	
	/**
	 * Column Info
	 * @param adOvt
	 */
	public void setAdOvt(String adOvt) {
		this.adOvt = adOvt;
	}
	
	/**
	 * Column Info
	 * @param cmCnt
	 */
	public void setCmCnt(String cmCnt) {
		this.cmCnt = cmCnt;
	}
	
	/**
	 * Column Info
	 * @param adBizTm
	 */
	public void setAdBizTm(String adBizTm) {
		this.adBizTm = adBizTm;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param xterSndrId
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
	}
	
	/**
	 * Column Info
	 * @param blDocInpFlg
	 */
	public void setBlDocInpFlg(String blDocInpFlg) {
		this.blDocInpFlg = blDocInpFlg;
	}
	
	/**
	 * Column Info
	 * @param idStDt
	 */
	public void setIdStDt(String idStDt) {
		this.idStDt = idStDt;
	}
	
	/**
	 * Column Info
	 * @param rdEndDt
	 */
	public void setRdEndDt(String rdEndDt) {
		this.rdEndDt = rdEndDt;
	}
	
	/**
	 * Column Info
	 * @param tvvd
	 */
	public void setTvvd(String tvvd) {
		this.tvvd = tvvd;
	}
	
	/**
	 * Column Info
	 * @param rdOvt
	 */
	public void setRdOvt(String rdOvt) {
		this.rdOvt = rdOvt;
	}
	
	/**
	 * Column Info
	 * @param pnStDt
	 */
	public void setPnStDt(String pnStDt) {
		this.pnStDt = pnStDt;
	}
	
	/**
	 * Column Info
	 * @param rdStDt
	 */
	public void setRdStDt(String rdStDt) {
		this.rdStDt = rdStDt;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param idEndDt
	 */
	public void setIdEndDt(String idEndDt) {
		this.idEndDt = idEndDt;
	}
	
	/**
	 * Column Info
	 * @param pnActTm
	 */
	public void setPnActTm(String pnActTm) {
		this.pnActTm = pnActTm;
	}
	
	/**
	 * Column Info
	 * @param pndFlg
	 */
	public void setPndFlg(String pndFlg) {
		this.pndFlg = pndFlg;
	}
	
	/**
	 * Column Info
	 * @param srCrntStsCd
	 */
	public void setSrCrntStsCd(String srCrntStsCd) {
		this.srCrntStsCd = srCrntStsCd;
	}
	
	/**
	 * Column Info
	 * @param adActTm
	 */
	public void setAdActTm(String adActTm) {
		this.adActTm = adActTm;
	}
	
	/**
	 * Column Info
	 * @param idActTm
	 */
	public void setIdActTm(String idActTm) {
		this.idActTm = idActTm;
	}
	
	/**
	 * Column Info
	 * @param rtActTm
	 */
	public void setRtActTm(String rtActTm) {
		this.rtActTm = rtActTm;
	}
	
	/**
	 * Column Info
	 * @param hblCnt
	 */
	public void setHblCnt(String hblCnt) {
		this.hblCnt = hblCnt;
	}
	
	/**
	 * Column Info
	 * @param rdActTm
	 */
	public void setRdActTm(String rdActTm) {
		this.rdActTm = rdActTm;
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
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
	}
	
	/**
	 * Column Info
	 * @param adStDt
	 */
	public void setAdStDt(String adStDt) {
		this.adStDt = adStDt;
	}
	
	/**
	 * Column Info
	 * @param srWrkStsCd
	 */
	public void setSrWrkStsCd(String srWrkStsCd) {
		this.srWrkStsCd = srWrkStsCd;
	}
	
	/**
	 * Column Info
	 * @param rtEndDt
	 */
	public void setRtEndDt(String rtEndDt) {
		this.rtEndDt = rtEndDt;
	}
	
	/**
	 * Column Info
	 * @param rtBizTm
	 */
	public void setRtBizTm(String rtBizTm) {
		this.rtBizTm = rtBizTm;
	}
	
	/**
	 * Column Info
	 * @param fntOfcTrnsDt
	 */
	public void setFntOfcTrnsDt(String fntOfcTrnsDt) {
		this.fntOfcTrnsDt = fntOfcTrnsDt;
	}
	
	/**
	 * Column Info
	 * @param srAmdTpCd
	 */
	public void setSrAmdTpCd(String srAmdTpCd) {
		this.srAmdTpCd = srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param adEndDt
	 */
	public void setAdEndDt(String adEndDt) {
		this.adEndDt = adEndDt;
	}
	
	/**
	 * Column Info
	 * @param idBizTm
	 */
	public void setIdBizTm(String idBizTm) {
		this.idBizTm = idBizTm;
	}
	
	/**
	 * Column Info
	 * @param blDrftFaxOutFlg
	 */
	public void setBlDrftFaxOutFlg(String blDrftFaxOutFlg) {
		this.blDrftFaxOutFlg = blDrftFaxOutFlg;
	}
	
	/**
	 * Column Info
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	
	/**
	 * Column Info
	 * @param rdBizTm
	 */
	public void setRdBizTm(String rdBizTm) {
		this.rdBizTm = rdBizTm;
	}
	
	/**
	 * Column Info
	 * @param holCnt
	 */
	public void setHolCnt(String holCnt) {
		this.holCnt = holCnt;
	}
	
	/**
	 * Column Info
	 * @param idSrIdleHrs
	 */
	public void setIdSrIdleHrs(String idSrIdleHrs) {
		this.idSrIdleHrs = idSrIdleHrs;
	}
	
	/**
	 * Column Info
	 * @param idSrWrkTmIdleHrs
	 */
	public void setIdSrWrkTmIdleHrs(String idSrWrkTmIdleHrs) {
		this.idSrWrkTmIdleHrs = idSrWrkTmIdleHrs;
	}
	
	/**
	 * Column Info
	 * @param idSrOvtIdleHrs
	 */
	public void setIdSrOvtIdleHrs(String idSrOvtIdleHrs) {
		this.idSrOvtIdleHrs = idSrOvtIdleHrs;
	}
	
	/**
	 * Column Info
	 * @param rdSrIdleHrs
	 */
	public void setRdSrIdleHrs(String rdSrIdleHrs) {
		this.rdSrIdleHrs = rdSrIdleHrs;
	}
	
	/**
	 * Column Info
	 * @param holCnt
	 */
	public void setRdSrWrkTmIdleHrs(String rdSrWrkTmIdleHrs) {
		this.rdSrWrkTmIdleHrs = rdSrWrkTmIdleHrs;
	}
	
	/**
	 * Column Info
	 * @param rdSrOvtIdleHrs
	 */
	public void setRdSrOvtIdleHrs(String rdSrOvtIdleHrs) {
		this.rdSrOvtIdleHrs = rdSrOvtIdleHrs;
	}
	
	/**
	 * Column Info
	 * @param adSrIdleHrs
	 */
	public void setAdSrIdleHrs(String adSrIdleHrs) {
		this.adSrIdleHrs = adSrIdleHrs;
	}
	
	/**
	 * Column Info
	 * @param adSrWrkTmIdleHrs
	 */
	public void setAdSrWrkTmIdleHrs(String adSrWrkTmIdleHrs) {
		this.adSrWrkTmIdleHrs = adSrWrkTmIdleHrs;
	}
	
	/**
	 * Column Info
	 * @param adSrOvtIdleHrs
	 */
	public void setAdSrOvtIdleHrs(String adSrOvtIdleHrs) {
		this.adSrOvtIdleHrs = adSrOvtIdleHrs;
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
		setIdOvt(JSPUtil.getParameter(request, prefix + "id_ovt", ""));
		setRtStDt(JSPUtil.getParameter(request, prefix + "rt_st_dt", ""));
		setBlAudFlg(JSPUtil.getParameter(request, prefix + "bl_aud_flg", ""));
		setPnEndDt(JSPUtil.getParameter(request, prefix + "pn_end_dt", ""));
		setBlRtFlg(JSPUtil.getParameter(request, prefix + "bl_rt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRtOvt(JSPUtil.getParameter(request, prefix + "rt_ovt", ""));
		setSrDueDt(JSPUtil.getParameter(request, prefix + "sr_due_dt", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setSrCrntInfoCd(JSPUtil.getParameter(request, prefix + "sr_crnt_info_cd", ""));
		setPnBizTm(JSPUtil.getParameter(request, prefix + "pn_biz_tm", ""));
		setAdOvt(JSPUtil.getParameter(request, prefix + "ad_ovt", ""));
		setCmCnt(JSPUtil.getParameter(request, prefix + "cm_cnt", ""));
		setAdBizTm(JSPUtil.getParameter(request, prefix + "ad_biz_tm", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
		setBlDocInpFlg(JSPUtil.getParameter(request, prefix + "bl_doc_inp_flg", ""));
		setIdStDt(JSPUtil.getParameter(request, prefix + "id_st_dt", ""));
		setRdEndDt(JSPUtil.getParameter(request, prefix + "rd_end_dt", ""));
		setTvvd(JSPUtil.getParameter(request, prefix + "tvvd", ""));
		setRdOvt(JSPUtil.getParameter(request, prefix + "rd_ovt", ""));
		setPnStDt(JSPUtil.getParameter(request, prefix + "pn_st_dt", ""));
		setRdStDt(JSPUtil.getParameter(request, prefix + "rd_st_dt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIdEndDt(JSPUtil.getParameter(request, prefix + "id_end_dt", ""));
		setPnActTm(JSPUtil.getParameter(request, prefix + "pn_act_tm", ""));
		setPndFlg(JSPUtil.getParameter(request, prefix + "pnd_flg", ""));
		setSrCrntStsCd(JSPUtil.getParameter(request, prefix + "sr_crnt_sts_cd", ""));
		setAdActTm(JSPUtil.getParameter(request, prefix + "ad_act_tm", ""));
		setIdActTm(JSPUtil.getParameter(request, prefix + "id_act_tm", ""));
		setRtActTm(JSPUtil.getParameter(request, prefix + "rt_act_tm", ""));
		setHblCnt(JSPUtil.getParameter(request, prefix + "hbl_cnt", ""));
		setRdActTm(JSPUtil.getParameter(request, prefix + "rd_act_tm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrKndCd(JSPUtil.getParameter(request, prefix + "sr_knd_cd", ""));
		setAdStDt(JSPUtil.getParameter(request, prefix + "ad_st_dt", ""));
		setSrWrkStsCd(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_cd", ""));
		setRtEndDt(JSPUtil.getParameter(request, prefix + "rt_end_dt", ""));
		setRtBizTm(JSPUtil.getParameter(request, prefix + "rt_biz_tm", ""));
		setFntOfcTrnsDt(JSPUtil.getParameter(request, prefix + "fnt_ofc_trns_dt", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request, prefix + "sr_amd_tp_cd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setAdEndDt(JSPUtil.getParameter(request, prefix + "ad_end_dt", ""));
		setIdBizTm(JSPUtil.getParameter(request, prefix + "id_biz_tm", ""));
		setBlDrftFaxOutFlg(JSPUtil.getParameter(request, prefix + "bl_drft_fax_out_flg", ""));
		setSrNo(JSPUtil.getParameter(request, prefix + "sr_no", ""));
		setRdBizTm(JSPUtil.getParameter(request, prefix + "rd_biz_tm", ""));
		setHolCnt(JSPUtil.getParameter(request, prefix + "hol_cnt", ""));
		setIdSrIdleHrs(JSPUtil.getParameter(request, prefix + "id_sr_idle_hrs", ""));
		setIdSrWrkTmIdleHrs(JSPUtil.getParameter(request, prefix + "id_sr_wrk_tm_idle_hrs", ""));
		setIdSrOvtIdleHrs(JSPUtil.getParameter(request, prefix + "id_sr_ovt_idle_hrs", ""));
		setRdSrIdleHrs(JSPUtil.getParameter(request, prefix + "rd_sr_idle_hrs", ""));
		setRdSrWrkTmIdleHrs(JSPUtil.getParameter(request, prefix + "rd_sr_wrk_tm_idle_hrs", ""));
		setRdSrOvtIdleHrs(JSPUtil.getParameter(request, prefix + "rd_sr_ovt_idle_hrs", ""));
		setAdSrIdleHrs(JSPUtil.getParameter(request, prefix + "ad_sr_idle_hrs", ""));
		setAdSrWrkTmIdleHrs(JSPUtil.getParameter(request, prefix + "ad_sr_wrk_tm_idle_hrs", ""));
		setAdSrOvtIdleHrs(JSPUtil.getParameter(request, prefix + "hol_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SiTurnTimeDetailVO[]
	 */
	public SiTurnTimeDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SiTurnTimeDetailVO[]
	 */
	public SiTurnTimeDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SiTurnTimeDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] idOvt = (JSPUtil.getParameter(request, prefix	+ "id_ovt", length));
			String[] rtStDt = (JSPUtil.getParameter(request, prefix	+ "rt_st_dt", length));
			String[] blAudFlg = (JSPUtil.getParameter(request, prefix	+ "bl_aud_flg", length));
			String[] pnEndDt = (JSPUtil.getParameter(request, prefix	+ "pn_end_dt", length));
			String[] blRtFlg = (JSPUtil.getParameter(request, prefix	+ "bl_rt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rtOvt = (JSPUtil.getParameter(request, prefix	+ "rt_ovt", length));
			String[] srDueDt = (JSPUtil.getParameter(request, prefix	+ "sr_due_dt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] srCrntInfoCd = (JSPUtil.getParameter(request, prefix	+ "sr_crnt_info_cd", length));
			String[] pnBizTm = (JSPUtil.getParameter(request, prefix	+ "pn_biz_tm", length));
			String[] adOvt = (JSPUtil.getParameter(request, prefix	+ "ad_ovt", length));
			String[] cmCnt = (JSPUtil.getParameter(request, prefix	+ "cm_cnt", length));
			String[] adBizTm = (JSPUtil.getParameter(request, prefix	+ "ad_biz_tm", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] blDocInpFlg = (JSPUtil.getParameter(request, prefix	+ "bl_doc_inp_flg", length));
			String[] idStDt = (JSPUtil.getParameter(request, prefix	+ "id_st_dt", length));
			String[] rdEndDt = (JSPUtil.getParameter(request, prefix	+ "rd_end_dt", length));
			String[] tvvd = (JSPUtil.getParameter(request, prefix	+ "tvvd", length));
			String[] rdOvt = (JSPUtil.getParameter(request, prefix	+ "rd_ovt", length));
			String[] pnStDt = (JSPUtil.getParameter(request, prefix	+ "pn_st_dt", length));
			String[] rdStDt = (JSPUtil.getParameter(request, prefix	+ "rd_st_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] idEndDt = (JSPUtil.getParameter(request, prefix	+ "id_end_dt", length));
			String[] pnActTm = (JSPUtil.getParameter(request, prefix	+ "pn_act_tm", length));
			String[] pndFlg = (JSPUtil.getParameter(request, prefix	+ "pnd_flg", length));
			String[] srCrntStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_crnt_sts_cd", length));
			String[] adActTm = (JSPUtil.getParameter(request, prefix	+ "ad_act_tm", length));
			String[] idActTm = (JSPUtil.getParameter(request, prefix	+ "id_act_tm", length));
			String[] rtActTm = (JSPUtil.getParameter(request, prefix	+ "rt_act_tm", length));
			String[] hblCnt = (JSPUtil.getParameter(request, prefix	+ "hbl_cnt", length));
			String[] rdActTm = (JSPUtil.getParameter(request, prefix	+ "rd_act_tm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] adStDt = (JSPUtil.getParameter(request, prefix	+ "ad_st_dt", length));
			String[] srWrkStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_cd", length));
			String[] rtEndDt = (JSPUtil.getParameter(request, prefix	+ "rt_end_dt", length));
			String[] rtBizTm = (JSPUtil.getParameter(request, prefix	+ "rt_biz_tm", length));
			String[] fntOfcTrnsDt = (JSPUtil.getParameter(request, prefix	+ "fnt_ofc_trns_dt", length));
			String[] srAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_cd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] adEndDt = (JSPUtil.getParameter(request, prefix	+ "ad_end_dt", length));
			String[] idBizTm = (JSPUtil.getParameter(request, prefix	+ "id_biz_tm", length));
			String[] blDrftFaxOutFlg = (JSPUtil.getParameter(request, prefix	+ "bl_drft_fax_out_flg", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] rdBizTm = (JSPUtil.getParameter(request, prefix	+ "rd_biz_tm", length));
			String[] holCnt = (JSPUtil.getParameter(request, prefix	+ "hol_cnt", length));
			String[] idSrIdleHrs = (JSPUtil.getParameter(request, prefix	+ "id_sr_idle_hrs", length));
			String[] idSrWrkTmIdleHrs = (JSPUtil.getParameter(request, prefix	+ "id_sr_wrk_tm_idle_hrs", length));
			String[] idSrOvtIdleHrs = (JSPUtil.getParameter(request, prefix	+ "id_sr_ovt_idle_hrs", length));
			String[] rdSrIdleHrs = (JSPUtil.getParameter(request, prefix	+ "rd_sr_idle_hrs", length));
			String[] rdSrWrkTmIdleHrs = (JSPUtil.getParameter(request, prefix	+ "rd_sr_wrk_tm_idle_hrs", length));
			String[] rdSrOvtIdleHrs = (JSPUtil.getParameter(request, prefix	+ "rd_sr_ovt_idle_hrs", length));
			String[] adSrIdleHrs = (JSPUtil.getParameter(request, prefix	+ "ad_sr_idle_hrs", length));
			String[] adSrWrkTmIdleHrs = (JSPUtil.getParameter(request, prefix	+ "ad_sr_wrk_tm_idle_hrs", length));
			String[] adSrOvtIdleHrs = (JSPUtil.getParameter(request, prefix	+ "ad_sr_ovt_idle_hrs", length));
			
			for (int i = 0; i < length; i++) {
				model = new SiTurnTimeDetailVO();
				if (idOvt[i] != null)
					model.setIdOvt(idOvt[i]);
				if (rtStDt[i] != null)
					model.setRtStDt(rtStDt[i]);
				if (blAudFlg[i] != null)
					model.setBlAudFlg(blAudFlg[i]);
				if (pnEndDt[i] != null)
					model.setPnEndDt(pnEndDt[i]);
				if (blRtFlg[i] != null)
					model.setBlRtFlg(blRtFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rtOvt[i] != null)
					model.setRtOvt(rtOvt[i]);
				if (srDueDt[i] != null)
					model.setSrDueDt(srDueDt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (srCrntInfoCd[i] != null)
					model.setSrCrntInfoCd(srCrntInfoCd[i]);
				if (pnBizTm[i] != null)
					model.setPnBizTm(pnBizTm[i]);
				if (adOvt[i] != null)
					model.setAdOvt(adOvt[i]);
				if (cmCnt[i] != null)
					model.setCmCnt(cmCnt[i]);
				if (adBizTm[i] != null)
					model.setAdBizTm(adBizTm[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (xterSndrId[i] != null)
					model.setXterSndrId(xterSndrId[i]);
				if (blDocInpFlg[i] != null)
					model.setBlDocInpFlg(blDocInpFlg[i]);
				if (idStDt[i] != null)
					model.setIdStDt(idStDt[i]);
				if (rdEndDt[i] != null)
					model.setRdEndDt(rdEndDt[i]);
				if (tvvd[i] != null)
					model.setTvvd(tvvd[i]);
				if (rdOvt[i] != null)
					model.setRdOvt(rdOvt[i]);
				if (pnStDt[i] != null)
					model.setPnStDt(pnStDt[i]);
				if (rdStDt[i] != null)
					model.setRdStDt(rdStDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (idEndDt[i] != null)
					model.setIdEndDt(idEndDt[i]);
				if (pnActTm[i] != null)
					model.setPnActTm(pnActTm[i]);
				if (pndFlg[i] != null)
					model.setPndFlg(pndFlg[i]);
				if (srCrntStsCd[i] != null)
					model.setSrCrntStsCd(srCrntStsCd[i]);
				if (adActTm[i] != null)
					model.setAdActTm(adActTm[i]);
				if (idActTm[i] != null)
					model.setIdActTm(idActTm[i]);
				if (rtActTm[i] != null)
					model.setRtActTm(rtActTm[i]);
				if (hblCnt[i] != null)
					model.setHblCnt(hblCnt[i]);
				if (rdActTm[i] != null)
					model.setRdActTm(rdActTm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (adStDt[i] != null)
					model.setAdStDt(adStDt[i]);
				if (srWrkStsCd[i] != null)
					model.setSrWrkStsCd(srWrkStsCd[i]);
				if (rtEndDt[i] != null)
					model.setRtEndDt(rtEndDt[i]);
				if (rtBizTm[i] != null)
					model.setRtBizTm(rtBizTm[i]);
				if (fntOfcTrnsDt[i] != null)
					model.setFntOfcTrnsDt(fntOfcTrnsDt[i]);
				if (srAmdTpCd[i] != null)
					model.setSrAmdTpCd(srAmdTpCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (adEndDt[i] != null)
					model.setAdEndDt(adEndDt[i]);
				if (idBizTm[i] != null)
					model.setIdBizTm(idBizTm[i]);
				if (blDrftFaxOutFlg[i] != null)
					model.setBlDrftFaxOutFlg(blDrftFaxOutFlg[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (rdBizTm[i] != null)
					model.setRdBizTm(rdBizTm[i]);
				if (holCnt[i] != null)
					model.setHolCnt(holCnt[i]);
				if (idSrIdleHrs[i] != null)
					model.setIdSrIdleHrs(idSrIdleHrs[i]);
				if (idSrWrkTmIdleHrs[i] != null)
					model.setIdSrWrkTmIdleHrs(idSrWrkTmIdleHrs[i]);
				if (idSrOvtIdleHrs[i] != null)
					model.setIdSrOvtIdleHrs(idSrOvtIdleHrs[i]);
				if (rdSrIdleHrs[i] != null)
					model.setRdSrIdleHrs(rdSrIdleHrs[i]);
				if (rdSrWrkTmIdleHrs[i] != null)
					model.setRdSrWrkTmIdleHrs(rdSrWrkTmIdleHrs[i]);
				if (rdSrOvtIdleHrs[i] != null)
					model.setRdSrOvtIdleHrs(rdSrOvtIdleHrs[i]);
				if (adSrIdleHrs[i] != null)
					model.setAdSrIdleHrs(adSrIdleHrs[i]);
				if (adSrWrkTmIdleHrs[i] != null)
					model.setAdSrWrkTmIdleHrs(adSrWrkTmIdleHrs[i]);
				if (adSrOvtIdleHrs[i] != null)
					model.setAdSrOvtIdleHrs(adSrOvtIdleHrs[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSiTurnTimeDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SiTurnTimeDetailVO[]
	 */
	public SiTurnTimeDetailVO[] getSiTurnTimeDetailVOs(){
		SiTurnTimeDetailVO[] vos = (SiTurnTimeDetailVO[])models.toArray(new SiTurnTimeDetailVO[models.size()]);
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
		this.idOvt = this.idOvt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtStDt = this.rtStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blAudFlg = this.blAudFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnEndDt = this.pnEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRtFlg = this.blRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtOvt = this.rtOvt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srDueDt = this.srDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srCrntInfoCd = this.srCrntInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnBizTm = this.pnBizTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adOvt = this.adOvt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCnt = this.cmCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adBizTm = this.adBizTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDocInpFlg = this.blDocInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idStDt = this.idStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdEndDt = this.rdEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvd = this.tvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdOvt = this.rdOvt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnStDt = this.pnStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdStDt = this.rdStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idEndDt = this.idEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnActTm = this.pnActTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pndFlg = this.pndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srCrntStsCd = this.srCrntStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adActTm = this.adActTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idActTm = this.idActTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtActTm = this.rtActTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblCnt = this.hblCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdActTm = this.rdActTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adStDt = this.adStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsCd = this.srWrkStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtEndDt = this.rtEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtBizTm = this.rtBizTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fntOfcTrnsDt = this.fntOfcTrnsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd = this.srAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adEndDt = this.adEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idBizTm = this.idBizTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDrftFaxOutFlg = this.blDrftFaxOutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdBizTm = this.rdBizTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holCnt = this.holCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idSrIdleHrs = this.idSrIdleHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idSrWrkTmIdleHrs = this.idSrWrkTmIdleHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idSrOvtIdleHrs = this.idSrOvtIdleHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdSrIdleHrs = this.rdSrIdleHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdSrWrkTmIdleHrs = this.rdSrWrkTmIdleHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdSrOvtIdleHrs = this.rdSrOvtIdleHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adSrIdleHrs = this.adSrIdleHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adSrWrkTmIdleHrs = this.adSrWrkTmIdleHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adSrOvtIdleHrs = this.adSrOvtIdleHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
