/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FcmVslCntrRgstVO.java
*@FileTitle : FcmVslCntrRgstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.13 진마리아 
* 1.0 Creation
* 
* History
* 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
* 2012.04.19 진마리아 CHM-201217192-01 Vessel Registration내 선박 추가 로직 변경 요청건 - crrCd 추가
=========================================================*/
/*

SELECT
'' VSL_CD,
'' VSL_ENG_NM,
'' OWNR_NM,
'' VSL_BLD_DT,
'' VSL_DZND_CAPA,
'' BSE_14TON_VSL_CAPA,
'' FM_DT,
'' TO_DT,
'' DWT_WGT,
'' GRS_RGST_TONG_WGT,
'' NET_RGST_TONG_WGT,
'' LLOYD_NO,
'' CNTR_VSL_CLSS_CAPA,
'' VSL_CLSS_SUB_CD,
'' MN_ENG_MKR_NM,
'' MN_ENG_TP_DESC,
'' MN_ENG_RPM_PWR,
'' MN_ENG_BHP_PWR,
'' TBCGR_NO,
'' TBCGR_MKR_NM,
'' TBCGR_TP_DESC,
'' TBCGR_RPM_PWR,
'' TBCGR_COFF_FLG,
'' SPR_AUX_BLW_MKR_NM,
'' SPR_AUX_BLW_TP_DESC,
'' SPR_AUX_BLW_NO,
'' FOIL_ADTV_CD,
'' HL_PNT_CD,
'' GNR_CSM_WGT,
'' FOIL_TNK_CBM_CAPA,
'' FOIL_TNK_MT_CAPA,
'' FOIL_STL_SVC_TNK_MT_CAPA,
'' OP_MAX_SPD,
'' OP_MIN_SPD,
'' CRE_DT,
'' CRE_USR_ID,
'' UPD_DT,
'' UPD_USR_ID
FROM DUAL

 */
package com.clt.apps.opus.vop.fcm.setup.setup.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmVslCntrRgstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmVslCntrRgstVO> models = new ArrayList<FcmVslCntrRgstVO>();
	
	/* Column Info */
	private String vslDzndCapa = null;
	/* Column Info */
	private String mnEngTpDesc = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String tbcgrTpDesc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dwtWgt = null;
	/* Column Info */
	private String mnEngMkrNm = null;
	/* Column Info */
	private String mnEngRpmPwr = null;
	/* Column Info */
	private String foilTnkCbmCapa = null;
	/* Column Info */
	private String gnrCsmWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tbcgrCoffFlg = null;
	/* Column Info */
	private String vslBldDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String sprAuxBlwTpDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String netRgstTongWgt = null;
	/* Column Info */
	private String foilTnkMtCapa = null;
	/* Column Info */
	private String sprAuxBlwNo = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String sprAuxBlwMkrNm = null;
	/* Column Info */
	private String grsRgstTongWgt = null;
	/* Column Info */
	private String tbcgrRpmPwr = null;
	/* Column Info */
	private String opMinSpd = null;
	/* Column Info */
	private String mnEngBhpPwr = null;
	/* Column Info */
	private String cntrVslClssCapa = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String foilAdtvCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String foilStlSvcTnkMtCapa = null;
	/* Column Info */
	private String bse14tonVslCapa = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String tbcgrNo = null;
	/* Column Info */
	private String vslClssSubCd = null;
	/* Column Info */
	private String ownrNm = null;
	/* Column Info */
	private String tbcgrMkrNm = null;
	/* Column Info */
	private String opMaxSpd = null;
	/* Column Info */
	private String hlPntCd = null;
	/* Column Info */
	private String opGnrSpd = null;
	/* Column Info */
	private String trndLineUseFlg = null;
	/* Column Info */
	private String mnvrCsmWgt = null;
	/* Column Info */
	private String crrCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmVslCntrRgstVO() {}

	public FcmVslCntrRgstVO(String ibflag, String pagerows, String vslCd, String vslEngNm, String ownrNm, String vslBldDt, String vslDzndCapa, String bse14tonVslCapa, String fmDt, String toDt, String dwtWgt, String grsRgstTongWgt, String netRgstTongWgt, String lloydNo, String cntrVslClssCapa, String vslClssSubCd, String mnEngMkrNm, String mnEngTpDesc, String mnEngRpmPwr, String mnEngBhpPwr, String tbcgrNo, String tbcgrMkrNm, String tbcgrTpDesc, String tbcgrRpmPwr, String tbcgrCoffFlg, String sprAuxBlwMkrNm, String sprAuxBlwTpDesc, String sprAuxBlwNo, String foilAdtvCd, String hlPntCd, String gnrCsmWgt, String foilTnkCbmCapa, String foilTnkMtCapa, String foilStlSvcTnkMtCapa, String opMaxSpd, String opMinSpd, String creDt, String creUsrId, String updDt, String updUsrId, String opGnrSpd, String trndLineUseFlg, String mnvrCsmWgt, String crrCd) {
		this.vslDzndCapa = vslDzndCapa;
		this.mnEngTpDesc = mnEngTpDesc;
		this.vslCd = vslCd;
		this.tbcgrTpDesc = tbcgrTpDesc;
		this.creDt = creDt;
		this.dwtWgt = dwtWgt;
		this.mnEngMkrNm = mnEngMkrNm;
		this.mnEngRpmPwr = mnEngRpmPwr;
		this.foilTnkCbmCapa = foilTnkCbmCapa;
		this.gnrCsmWgt = gnrCsmWgt;
		this.pagerows = pagerows;
		this.tbcgrCoffFlg = tbcgrCoffFlg;
		this.vslBldDt = vslBldDt;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.sprAuxBlwTpDesc = sprAuxBlwTpDesc;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.netRgstTongWgt = netRgstTongWgt;
		this.foilTnkMtCapa = foilTnkMtCapa;
		this.sprAuxBlwNo = sprAuxBlwNo;
		this.fmDt = fmDt;
		this.sprAuxBlwMkrNm = sprAuxBlwMkrNm;
		this.grsRgstTongWgt = grsRgstTongWgt;
		this.tbcgrRpmPwr = tbcgrRpmPwr;
		this.opMinSpd = opMinSpd;
		this.mnEngBhpPwr = mnEngBhpPwr;
		this.cntrVslClssCapa = cntrVslClssCapa;
		this.toDt = toDt;
		this.foilAdtvCd = foilAdtvCd;
		this.creUsrId = creUsrId;
		this.foilStlSvcTnkMtCapa = foilStlSvcTnkMtCapa;
		this.bse14tonVslCapa = bse14tonVslCapa;
		this.lloydNo = lloydNo;
		this.tbcgrNo = tbcgrNo;
		this.vslClssSubCd = vslClssSubCd;
		this.ownrNm = ownrNm;
		this.tbcgrMkrNm = tbcgrMkrNm;
		this.opMaxSpd = opMaxSpd;
		this.hlPntCd = hlPntCd;
		this.opGnrSpd = opGnrSpd;
		this.trndLineUseFlg = trndLineUseFlg;
		this.mnvrCsmWgt = mnvrCsmWgt;
		this.crrCd = crrCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_dznd_capa", getVslDzndCapa());
		this.hashColumns.put("mn_eng_tp_desc", getMnEngTpDesc());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("tbcgr_tp_desc", getTbcgrTpDesc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dwt_wgt", getDwtWgt());
		this.hashColumns.put("mn_eng_mkr_nm", getMnEngMkrNm());
		this.hashColumns.put("mn_eng_rpm_pwr", getMnEngRpmPwr());
		this.hashColumns.put("foil_tnk_cbm_capa", getFoilTnkCbmCapa());
		this.hashColumns.put("gnr_csm_wgt", getGnrCsmWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tbcgr_coff_flg", getTbcgrCoffFlg());
		this.hashColumns.put("vsl_bld_dt", getVslBldDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("spr_aux_blw_tp_desc", getSprAuxBlwTpDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("net_rgst_tong_wgt", getNetRgstTongWgt());
		this.hashColumns.put("foil_tnk_mt_capa", getFoilTnkMtCapa());
		this.hashColumns.put("spr_aux_blw_no", getSprAuxBlwNo());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("spr_aux_blw_mkr_nm", getSprAuxBlwMkrNm());
		this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
		this.hashColumns.put("tbcgr_rpm_pwr", getTbcgrRpmPwr());
		this.hashColumns.put("op_min_spd", getOpMinSpd());
		this.hashColumns.put("mn_eng_bhp_pwr", getMnEngBhpPwr());
		this.hashColumns.put("cntr_vsl_clss_capa", getCntrVslClssCapa());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("foil_adtv_cd", getFoilAdtvCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("foil_stl_svc_tnk_mt_capa", getFoilStlSvcTnkMtCapa());
		this.hashColumns.put("bse_14ton_vsl_capa", getBse14tonVslCapa());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("tbcgr_no", getTbcgrNo());
		this.hashColumns.put("vsl_clss_sub_cd", getVslClssSubCd());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("tbcgr_mkr_nm", getTbcgrMkrNm());
		this.hashColumns.put("op_max_spd", getOpMaxSpd());
		this.hashColumns.put("hl_pnt_cd", getHlPntCd());
		this.hashColumns.put("op_gnr_spd", getOpGnrSpd());
		this.hashColumns.put("trnd_line_use_flg", getTrndLineUseFlg());
		this.hashColumns.put("mnvr_csm_wgt", getMnvrCsmWgt());
		this.hashColumns.put("crr_cd", getCrrCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_dznd_capa", "vslDzndCapa");
		this.hashFields.put("mn_eng_tp_desc", "mnEngTpDesc");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("tbcgr_tp_desc", "tbcgrTpDesc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dwt_wgt", "dwtWgt");
		this.hashFields.put("mn_eng_mkr_nm", "mnEngMkrNm");
		this.hashFields.put("mn_eng_rpm_pwr", "mnEngRpmPwr");
		this.hashFields.put("foil_tnk_cbm_capa", "foilTnkCbmCapa");
		this.hashFields.put("gnr_csm_wgt", "gnrCsmWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tbcgr_coff_flg", "tbcgrCoffFlg");
		this.hashFields.put("vsl_bld_dt", "vslBldDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("spr_aux_blw_tp_desc", "sprAuxBlwTpDesc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("net_rgst_tong_wgt", "netRgstTongWgt");
		this.hashFields.put("foil_tnk_mt_capa", "foilTnkMtCapa");
		this.hashFields.put("spr_aux_blw_no", "sprAuxBlwNo");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("spr_aux_blw_mkr_nm", "sprAuxBlwMkrNm");
		this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
		this.hashFields.put("tbcgr_rpm_pwr", "tbcgrRpmPwr");
		this.hashFields.put("op_min_spd", "opMinSpd");
		this.hashFields.put("mn_eng_bhp_pwr", "mnEngBhpPwr");
		this.hashFields.put("cntr_vsl_clss_capa", "cntrVslClssCapa");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("foil_adtv_cd", "foilAdtvCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("foil_stl_svc_tnk_mt_capa", "foilStlSvcTnkMtCapa");
		this.hashFields.put("bse_14ton_vsl_capa", "bse14tonVslCapa");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("tbcgr_no", "tbcgrNo");
		this.hashFields.put("vsl_clss_sub_cd", "vslClssSubCd");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("tbcgr_mkr_nm", "tbcgrMkrNm");
		this.hashFields.put("op_max_spd", "opMaxSpd");
		this.hashFields.put("hl_pnt_cd", "hlPntCd");
		this.hashFields.put("op_gnr_spd", "opGnrSpd");
		this.hashFields.put("trnd_line_use_flg", "trndLineUseFlg");
		this.hashFields.put("mnvr_csm_wgt", "mnvrCsmWgt");
		this.hashFields.put("crr_cd", "crrCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslDzndCapa
	 */
	public String getVslDzndCapa() {
		return this.vslDzndCapa;
	}
	
	/**
	 * Column Info
	 * @return mnEngTpDesc
	 */
	public String getMnEngTpDesc() {
		return this.mnEngTpDesc;
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
	 * @return tbcgrTpDesc
	 */
	public String getTbcgrTpDesc() {
		return this.tbcgrTpDesc;
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
	 * @return dwtWgt
	 */
	public String getDwtWgt() {
		return this.dwtWgt;
	}
	
	/**
	 * Column Info
	 * @return mnEngMkrNm
	 */
	public String getMnEngMkrNm() {
		return this.mnEngMkrNm;
	}
	
	/**
	 * Column Info
	 * @return mnEngRpmPwr
	 */
	public String getMnEngRpmPwr() {
		return this.mnEngRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return foilTnkCbmCapa
	 */
	public String getFoilTnkCbmCapa() {
		return this.foilTnkCbmCapa;
	}
	
	/**
	 * Column Info
	 * @return gnrCsmWgt
	 */
	public String getGnrCsmWgt() {
		return this.gnrCsmWgt;
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
	 * @return tbcgrCoffFlg
	 */
	public String getTbcgrCoffFlg() {
		return this.tbcgrCoffFlg;
	}
	
	/**
	 * Column Info
	 * @return vslBldDt
	 */
	public String getVslBldDt() {
		return this.vslBldDt;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return sprAuxBlwTpDesc
	 */
	public String getSprAuxBlwTpDesc() {
		return this.sprAuxBlwTpDesc;
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
	 * @return netRgstTongWgt
	 */
	public String getNetRgstTongWgt() {
		return this.netRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return foilTnkMtCapa
	 */
	public String getFoilTnkMtCapa() {
		return this.foilTnkMtCapa;
	}
	
	/**
	 * Column Info
	 * @return sprAuxBlwNo
	 */
	public String getSprAuxBlwNo() {
		return this.sprAuxBlwNo;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return sprAuxBlwMkrNm
	 */
	public String getSprAuxBlwMkrNm() {
		return this.sprAuxBlwMkrNm;
	}
	
	/**
	 * Column Info
	 * @return grsRgstTongWgt
	 */
	public String getGrsRgstTongWgt() {
		return this.grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return tbcgrRpmPwr
	 */
	public String getTbcgrRpmPwr() {
		return this.tbcgrRpmPwr;
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
	 * @return mnEngBhpPwr
	 */
	public String getMnEngBhpPwr() {
		return this.mnEngBhpPwr;
	}
	
	/**
	 * Column Info
	 * @return cntrVslClssCapa
	 */
	public String getCntrVslClssCapa() {
		return this.cntrVslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return foilAdtvCd
	 */
	public String getFoilAdtvCd() {
		return this.foilAdtvCd;
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
	 * @return foilStlSvcTnkMtCapa
	 */
	public String getFoilStlSvcTnkMtCapa() {
		return this.foilStlSvcTnkMtCapa;
	}
	
	/**
	 * Column Info
	 * @return bse14tonVslCapa
	 */
	public String getBse14tonVslCapa() {
		return this.bse14tonVslCapa;
	}
	
	/**
	 * Column Info
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return tbcgrNo
	 */
	public String getTbcgrNo() {
		return this.tbcgrNo;
	}
	
	/**
	 * Column Info
	 * @return vslClssSubCd
	 */
	public String getVslClssSubCd() {
		return this.vslClssSubCd;
	}
	
	/**
	 * Column Info
	 * @return ownrNm
	 */
	public String getOwnrNm() {
		return this.ownrNm;
	}
	
	/**
	 * Column Info
	 * @return tbcgrMkrNm
	 */
	public String getTbcgrMkrNm() {
		return this.tbcgrMkrNm;
	}
	
	/**
	 * Column Info
	 * @return opMaxSpd
	 */
	public String getOpMaxSpd() {
		return this.opMaxSpd;
	}
	
	/**
	 * Column Info
	 * @return hlPntCd
	 */
	public String getHlPntCd() {
		return this.hlPntCd;
	}
	
	/**
	 * Column Info
	 * @return opGnrSpd
	 */
	public String getOpGnrSpd() {
		return this.opGnrSpd;
	}
	
	/**
	 * Column Info
	 * @return trndLineUseFlg
	 */
	public String getTrndLineUseFlg() {
		return this.trndLineUseFlg;
	}
	
	/**
	 * Column Info
	 * @return mnvrCsmWgt
	 */
	public String getMnvrCsmWgt() {
		return this.mnvrCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}

	/**
	 * Column Info
	 * @param vslDzndCapa
	 */
	public void setVslDzndCapa(String vslDzndCapa) {
		this.vslDzndCapa = vslDzndCapa;
	}
	
	/**
	 * Column Info
	 * @param mnEngTpDesc
	 */
	public void setMnEngTpDesc(String mnEngTpDesc) {
		this.mnEngTpDesc = mnEngTpDesc;
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
	 * @param tbcgrTpDesc
	 */
	public void setTbcgrTpDesc(String tbcgrTpDesc) {
		this.tbcgrTpDesc = tbcgrTpDesc;
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
	 * @param dwtWgt
	 */
	public void setDwtWgt(String dwtWgt) {
		this.dwtWgt = dwtWgt;
	}
	
	/**
	 * Column Info
	 * @param mnEngMkrNm
	 */
	public void setMnEngMkrNm(String mnEngMkrNm) {
		this.mnEngMkrNm = mnEngMkrNm;
	}
	
	/**
	 * Column Info
	 * @param mnEngRpmPwr
	 */
	public void setMnEngRpmPwr(String mnEngRpmPwr) {
		this.mnEngRpmPwr = mnEngRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param foilTnkCbmCapa
	 */
	public void setFoilTnkCbmCapa(String foilTnkCbmCapa) {
		this.foilTnkCbmCapa = foilTnkCbmCapa;
	}
	
	/**
	 * Column Info
	 * @param gnrCsmWgt
	 */
	public void setGnrCsmWgt(String gnrCsmWgt) {
		this.gnrCsmWgt = gnrCsmWgt;
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
	 * @param tbcgrCoffFlg
	 */
	public void setTbcgrCoffFlg(String tbcgrCoffFlg) {
		this.tbcgrCoffFlg = tbcgrCoffFlg;
	}
	
	/**
	 * Column Info
	 * @param vslBldDt
	 */
	public void setVslBldDt(String vslBldDt) {
		this.vslBldDt = vslBldDt;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param sprAuxBlwTpDesc
	 */
	public void setSprAuxBlwTpDesc(String sprAuxBlwTpDesc) {
		this.sprAuxBlwTpDesc = sprAuxBlwTpDesc;
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
	 * @param netRgstTongWgt
	 */
	public void setNetRgstTongWgt(String netRgstTongWgt) {
		this.netRgstTongWgt = netRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param foilTnkMtCapa
	 */
	public void setFoilTnkMtCapa(String foilTnkMtCapa) {
		this.foilTnkMtCapa = foilTnkMtCapa;
	}
	
	/**
	 * Column Info
	 * @param sprAuxBlwNo
	 */
	public void setSprAuxBlwNo(String sprAuxBlwNo) {
		this.sprAuxBlwNo = sprAuxBlwNo;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param sprAuxBlwMkrNm
	 */
	public void setSprAuxBlwMkrNm(String sprAuxBlwMkrNm) {
		this.sprAuxBlwMkrNm = sprAuxBlwMkrNm;
	}
	
	/**
	 * Column Info
	 * @param grsRgstTongWgt
	 */
	public void setGrsRgstTongWgt(String grsRgstTongWgt) {
		this.grsRgstTongWgt = grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param tbcgrRpmPwr
	 */
	public void setTbcgrRpmPwr(String tbcgrRpmPwr) {
		this.tbcgrRpmPwr = tbcgrRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param opMinSpd
	 */
	public void setOpMinSpd(String opMinSpd) {
		this.opMinSpd = opMinSpd;
	}
	
	/**
	 * Column Info
	 * @param mnEngBhpPwr
	 */
	public void setMnEngBhpPwr(String mnEngBhpPwr) {
		this.mnEngBhpPwr = mnEngBhpPwr;
	}
	
	/**
	 * Column Info
	 * @param cntrVslClssCapa
	 */
	public void setCntrVslClssCapa(String cntrVslClssCapa) {
		this.cntrVslClssCapa = cntrVslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param foilAdtvCd
	 */
	public void setFoilAdtvCd(String foilAdtvCd) {
		this.foilAdtvCd = foilAdtvCd;
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
	 * @param foilStlSvcTnkMtCapa
	 */
	public void setFoilStlSvcTnkMtCapa(String foilStlSvcTnkMtCapa) {
		this.foilStlSvcTnkMtCapa = foilStlSvcTnkMtCapa;
	}
	
	/**
	 * Column Info
	 * @param bse14tonVslCapa
	 */
	public void setBse14tonVslCapa(String bse14tonVslCapa) {
		this.bse14tonVslCapa = bse14tonVslCapa;
	}
	
	/**
	 * Column Info
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param tbcgrNo
	 */
	public void setTbcgrNo(String tbcgrNo) {
		this.tbcgrNo = tbcgrNo;
	}
	
	/**
	 * Column Info
	 * @param vslClssSubCd
	 */
	public void setVslClssSubCd(String vslClssSubCd) {
		this.vslClssSubCd = vslClssSubCd;
	}
	
	/**
	 * Column Info
	 * @param ownrNm
	 */
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
	}
	
	/**
	 * Column Info
	 * @param tbcgrMkrNm
	 */
	public void setTbcgrMkrNm(String tbcgrMkrNm) {
		this.tbcgrMkrNm = tbcgrMkrNm;
	}
	
	/**
	 * Column Info
	 * @param opMaxSpd
	 */
	public void setOpMaxSpd(String opMaxSpd) {
		this.opMaxSpd = opMaxSpd;
	}
	
	/**
	 * Column Info
	 * @param hlPntCd
	 */
	public void setHlPntCd(String hlPntCd) {
		this.hlPntCd = hlPntCd;
	}
	
	/**
	 * Column Info
	 * @param opGnrSpd
	 */
	public void setOpGnrSpd(String opGnrSpd) {
		this.opGnrSpd = opGnrSpd;
	}
	
	/**
	 * Column Info
	 * @param trndLineUseFlg
	 */
	public void setTrndLineUseFlg(String trndLineUseFlg) {
		this.trndLineUseFlg = trndLineUseFlg;
	}
	
	/**
	 * Column Info
	 * @param mnvrCsmWgt
	 */
	public void setMnvrCsmWgt(String mnvrCsmWgt) {
		this.mnvrCsmWgt = mnvrCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
		setVslDzndCapa(JSPUtil.getParameter(request, prefix + "vsl_dznd_capa", ""));
		setMnEngTpDesc(JSPUtil.getParameter(request, prefix + "mn_eng_tp_desc", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setTbcgrTpDesc(JSPUtil.getParameter(request, prefix + "tbcgr_tp_desc", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDwtWgt(JSPUtil.getParameter(request, prefix + "dwt_wgt", ""));
		setMnEngMkrNm(JSPUtil.getParameter(request, prefix + "mn_eng_mkr_nm", ""));
		setMnEngRpmPwr(JSPUtil.getParameter(request, prefix + "mn_eng_rpm_pwr", ""));
		setFoilTnkCbmCapa(JSPUtil.getParameter(request, prefix + "foil_tnk_cbm_capa", ""));
		setGnrCsmWgt(JSPUtil.getParameter(request, prefix + "gnr_csm_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTbcgrCoffFlg(JSPUtil.getParameter(request, prefix + "tbcgr_coff_flg", ""));
		setVslBldDt(JSPUtil.getParameter(request, prefix + "vsl_bld_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setSprAuxBlwTpDesc(JSPUtil.getParameter(request, prefix + "spr_aux_blw_tp_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setNetRgstTongWgt(JSPUtil.getParameter(request, prefix + "net_rgst_tong_wgt", ""));
		setFoilTnkMtCapa(JSPUtil.getParameter(request, prefix + "foil_tnk_mt_capa", ""));
		setSprAuxBlwNo(JSPUtil.getParameter(request, prefix + "spr_aux_blw_no", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setSprAuxBlwMkrNm(JSPUtil.getParameter(request, prefix + "spr_aux_blw_mkr_nm", ""));
		setGrsRgstTongWgt(JSPUtil.getParameter(request, prefix + "grs_rgst_tong_wgt", ""));
		setTbcgrRpmPwr(JSPUtil.getParameter(request, prefix + "tbcgr_rpm_pwr", ""));
		setOpMinSpd(JSPUtil.getParameter(request, prefix + "op_min_spd", ""));
		setMnEngBhpPwr(JSPUtil.getParameter(request, prefix + "mn_eng_bhp_pwr", ""));
		setCntrVslClssCapa(JSPUtil.getParameter(request, prefix + "cntr_vsl_clss_capa", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setFoilAdtvCd(JSPUtil.getParameter(request, prefix + "foil_adtv_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFoilStlSvcTnkMtCapa(JSPUtil.getParameter(request, prefix + "foil_stl_svc_tnk_mt_capa", ""));
		setBse14tonVslCapa(JSPUtil.getParameter(request, prefix + "bse_14ton_vsl_capa", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setTbcgrNo(JSPUtil.getParameter(request, prefix + "tbcgr_no", ""));
		setVslClssSubCd(JSPUtil.getParameter(request, prefix + "vsl_clss_sub_cd", ""));
		setOwnrNm(JSPUtil.getParameter(request, prefix + "ownr_nm", ""));
		setTbcgrMkrNm(JSPUtil.getParameter(request, prefix + "tbcgr_mkr_nm", ""));
		setOpMaxSpd(JSPUtil.getParameter(request, prefix + "op_max_spd", ""));
		setHlPntCd(JSPUtil.getParameter(request, prefix + "hl_pnt_cd", ""));
		setOpGnrSpd(JSPUtil.getParameter(request, prefix + "op_gnr_spd", ""));
		setTrndLineUseFlg(JSPUtil.getParameter(request, prefix + "trnd_line_use_flg", ""));
		setMnvrCsmWgt(JSPUtil.getParameter(request, prefix + "mnvr_csm_wgt", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmVslCntrRgstVO[]
	 */
	public FcmVslCntrRgstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmVslCntrRgstVO[]
	 */
	public FcmVslCntrRgstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmVslCntrRgstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslDzndCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_dznd_capa", length));
			String[] mnEngTpDesc = (JSPUtil.getParameter(request, prefix	+ "mn_eng_tp_desc", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] tbcgrTpDesc = (JSPUtil.getParameter(request, prefix	+ "tbcgr_tp_desc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dwtWgt = (JSPUtil.getParameter(request, prefix	+ "dwt_wgt", length));
			String[] mnEngMkrNm = (JSPUtil.getParameter(request, prefix	+ "mn_eng_mkr_nm", length));
			String[] mnEngRpmPwr = (JSPUtil.getParameter(request, prefix	+ "mn_eng_rpm_pwr", length));
			String[] foilTnkCbmCapa = (JSPUtil.getParameter(request, prefix	+ "foil_tnk_cbm_capa", length));
			String[] gnrCsmWgt = (JSPUtil.getParameter(request, prefix	+ "gnr_csm_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tbcgrCoffFlg = (JSPUtil.getParameter(request, prefix	+ "tbcgr_coff_flg", length));
			String[] vslBldDt = (JSPUtil.getParameter(request, prefix	+ "vsl_bld_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] sprAuxBlwTpDesc = (JSPUtil.getParameter(request, prefix	+ "spr_aux_blw_tp_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] netRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "net_rgst_tong_wgt", length));
			String[] foilTnkMtCapa = (JSPUtil.getParameter(request, prefix	+ "foil_tnk_mt_capa", length));
			String[] sprAuxBlwNo = (JSPUtil.getParameter(request, prefix	+ "spr_aux_blw_no", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] sprAuxBlwMkrNm = (JSPUtil.getParameter(request, prefix	+ "spr_aux_blw_mkr_nm", length));
			String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "grs_rgst_tong_wgt", length));
			String[] tbcgrRpmPwr = (JSPUtil.getParameter(request, prefix	+ "tbcgr_rpm_pwr", length));
			String[] opMinSpd = (JSPUtil.getParameter(request, prefix	+ "op_min_spd", length));
			String[] mnEngBhpPwr = (JSPUtil.getParameter(request, prefix	+ "mn_eng_bhp_pwr", length));
			String[] cntrVslClssCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_vsl_clss_capa", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] foilAdtvCd = (JSPUtil.getParameter(request, prefix	+ "foil_adtv_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] foilStlSvcTnkMtCapa = (JSPUtil.getParameter(request, prefix	+ "foil_stl_svc_tnk_mt_capa", length));
			String[] bse14tonVslCapa = (JSPUtil.getParameter(request, prefix	+ "bse_14ton_vsl_capa", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] tbcgrNo = (JSPUtil.getParameter(request, prefix	+ "tbcgr_no", length));
			String[] vslClssSubCd = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_sub_cd", length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm", length));
			String[] tbcgrMkrNm = (JSPUtil.getParameter(request, prefix	+ "tbcgr_mkr_nm", length));
			String[] opMaxSpd = (JSPUtil.getParameter(request, prefix	+ "op_max_spd", length));
			String[] hlPntCd = (JSPUtil.getParameter(request, prefix	+ "hl_pnt_cd", length));
			String[] opGnrSpd = (JSPUtil.getParameter(request, prefix	+ "op_gnr_spd", length));
			String[] trndLineUseFlg = (JSPUtil.getParameter(request, prefix	+ "trnd_line_use_flg", length));
			String[] mnvrCsmWgt = (JSPUtil.getParameter(request, prefix	+ "mnvr_csm_wgt", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmVslCntrRgstVO();
				if (vslDzndCapa[i] != null)
					model.setVslDzndCapa(vslDzndCapa[i]);
				if (mnEngTpDesc[i] != null)
					model.setMnEngTpDesc(mnEngTpDesc[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (tbcgrTpDesc[i] != null)
					model.setTbcgrTpDesc(tbcgrTpDesc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dwtWgt[i] != null)
					model.setDwtWgt(dwtWgt[i]);
				if (mnEngMkrNm[i] != null)
					model.setMnEngMkrNm(mnEngMkrNm[i]);
				if (mnEngRpmPwr[i] != null)
					model.setMnEngRpmPwr(mnEngRpmPwr[i]);
				if (foilTnkCbmCapa[i] != null)
					model.setFoilTnkCbmCapa(foilTnkCbmCapa[i]);
				if (gnrCsmWgt[i] != null)
					model.setGnrCsmWgt(gnrCsmWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tbcgrCoffFlg[i] != null)
					model.setTbcgrCoffFlg(tbcgrCoffFlg[i]);
				if (vslBldDt[i] != null)
					model.setVslBldDt(vslBldDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (sprAuxBlwTpDesc[i] != null)
					model.setSprAuxBlwTpDesc(sprAuxBlwTpDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (netRgstTongWgt[i] != null)
					model.setNetRgstTongWgt(netRgstTongWgt[i]);
				if (foilTnkMtCapa[i] != null)
					model.setFoilTnkMtCapa(foilTnkMtCapa[i]);
				if (sprAuxBlwNo[i] != null)
					model.setSprAuxBlwNo(sprAuxBlwNo[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (sprAuxBlwMkrNm[i] != null)
					model.setSprAuxBlwMkrNm(sprAuxBlwMkrNm[i]);
				if (grsRgstTongWgt[i] != null)
					model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
				if (tbcgrRpmPwr[i] != null)
					model.setTbcgrRpmPwr(tbcgrRpmPwr[i]);
				if (opMinSpd[i] != null)
					model.setOpMinSpd(opMinSpd[i]);
				if (mnEngBhpPwr[i] != null)
					model.setMnEngBhpPwr(mnEngBhpPwr[i]);
				if (cntrVslClssCapa[i] != null)
					model.setCntrVslClssCapa(cntrVslClssCapa[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (foilAdtvCd[i] != null)
					model.setFoilAdtvCd(foilAdtvCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (foilStlSvcTnkMtCapa[i] != null)
					model.setFoilStlSvcTnkMtCapa(foilStlSvcTnkMtCapa[i]);
				if (bse14tonVslCapa[i] != null)
					model.setBse14tonVslCapa(bse14tonVslCapa[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (tbcgrNo[i] != null)
					model.setTbcgrNo(tbcgrNo[i]);
				if (vslClssSubCd[i] != null)
					model.setVslClssSubCd(vslClssSubCd[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (tbcgrMkrNm[i] != null)
					model.setTbcgrMkrNm(tbcgrMkrNm[i]);
				if (opMaxSpd[i] != null)
					model.setOpMaxSpd(opMaxSpd[i]);
				if (hlPntCd[i] != null)
					model.setHlPntCd(hlPntCd[i]);
				if (opGnrSpd[i] != null)
					model.setOpGnrSpd(opGnrSpd[i]);
				if (trndLineUseFlg[i] != null)
					model.setTrndLineUseFlg(trndLineUseFlg[i]);
				if (mnvrCsmWgt[i] != null)
					model.setMnvrCsmWgt(mnvrCsmWgt[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmVslCntrRgstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmVslCntrRgstVO[]
	 */
	public FcmVslCntrRgstVO[] getFcmVslCntrRgstVOs(){
		FcmVslCntrRgstVO[] vos = (FcmVslCntrRgstVO[])models.toArray(new FcmVslCntrRgstVO[models.size()]);
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
		this.vslDzndCapa = this.vslDzndCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngTpDesc = this.mnEngTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tbcgrTpDesc = this.tbcgrTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwtWgt = this.dwtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngMkrNm = this.mnEngMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngRpmPwr = this.mnEngRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilTnkCbmCapa = this.foilTnkCbmCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnrCsmWgt = this.gnrCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tbcgrCoffFlg = this.tbcgrCoffFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBldDt = this.vslBldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprAuxBlwTpDesc = this.sprAuxBlwTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netRgstTongWgt = this.netRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilTnkMtCapa = this.foilTnkMtCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprAuxBlwNo = this.sprAuxBlwNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprAuxBlwMkrNm = this.sprAuxBlwMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRgstTongWgt = this.grsRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tbcgrRpmPwr = this.tbcgrRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opMinSpd = this.opMinSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngBhpPwr = this.mnEngBhpPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVslClssCapa = this.cntrVslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilAdtvCd = this.foilAdtvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilStlSvcTnkMtCapa = this.foilStlSvcTnkMtCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bse14tonVslCapa = this.bse14tonVslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tbcgrNo = this.tbcgrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssSubCd = this.vslClssSubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tbcgrMkrNm = this.tbcgrMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opMaxSpd = this.opMaxSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hlPntCd = this.hlPntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opGnrSpd = this.opGnrSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineUseFlg = this.trndLineUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrCsmWgt = this.mnvrCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
