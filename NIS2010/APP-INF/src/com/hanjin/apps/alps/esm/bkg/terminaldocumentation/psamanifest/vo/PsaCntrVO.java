/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PsaCntrVO.java
*@FileTitle : PsaCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.11 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PsaCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsaCntrVO> models = new ArrayList<PsaCntrVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String ovrRtDimWdt = null;
	/* Column Info */
	private String cntrOprCd = null;
	/* Column Info */
	private String psaVslNm = null;
	/* Column Info */
	private String ovrDimHgt = null;
	/* Column Info */
	private String dptSvcTpCd = null;
	/* Column Info */
	private String rfCntrPreTrdInspTpCd = null;
	/* Column Info */
	private String dchgOvrSzFlg = null;
	/* Column Info */
	private String obSltOprCd = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String ibSltOprCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String tsTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ovrLfDimWdt = null;
	/* Column Info */
	private String stwgTpCd = null;
	/* Column Info */
	private String dimWdt = null;
	/* Column Info */
	private String dimLen = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String psaBatNo = null;
	/* Column Info */
	private String n1stPodCd = null;
	/* Column Info */
	private String psaVoyDirCd = null;
	/* Column Info */
	private String ovrBakDimLen = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String cfsTpCd = null;
	/* Column Info */
	private String dimHgt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cgoDesc = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rcTemp = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ovrFntDimLen = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String dirDeFlg = null;	
	/* Column Info */
	private String vgmInd = null;
	/* Column Info */
	private String vgmMzdTpCd = null;
	/* Column Info */
	private String vgmVrfySigCtnt = null;
	/* Column Info */
	private String vgmRefNo = null;
	/* Column Info */
	private String vgmVrfyDt = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PsaCntrVO() {}

	public PsaCntrVO(String ibflag, String pagerows, String tsTpCd, String sndDt, String cntrNo, String bkgNo, String fullMtyCd, String cntrWgt, String cntrOprCd, String ibSltOprCd, String rcTemp, String dcgoFlg, String ovrDimHgt, String ovrFntDimLen, String ovrBakDimLen, String ovrLfDimWdt, String ovrRtDimWdt, String dimHgt, String dimWdt, String dimLen, String cgoDesc, String cfsTpCd, String dptSvcTpCd, String rfCntrPreTrdInspTpCd, String stwgTpCd, String obSltOprCd, String psaBatNo, String n1stPodCd, String podCd, String polCd, String dchgOvrSzFlg, String dirDeFlg, String cntrSealNo, String psaVslNm, String psaVoyDirCd, String vslCd, String skdVoyNo, String skdDirCd, String vgmInd, String vgmMzdTpCd,  String vgmVrfySigCtnt, String vgmRefNo, String vgmVrfyDt) {
		this.vslCd = vslCd;
		this.ovrRtDimWdt = ovrRtDimWdt;
		this.cntrOprCd = cntrOprCd;
		this.psaVslNm = psaVslNm;
		this.ovrDimHgt = ovrDimHgt;
		this.dptSvcTpCd = dptSvcTpCd;
		this.rfCntrPreTrdInspTpCd = rfCntrPreTrdInspTpCd;
		this.dchgOvrSzFlg = dchgOvrSzFlg;
		this.obSltOprCd = obSltOprCd;
		this.sndDt = sndDt;
		this.ibSltOprCd = ibSltOprCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.tsTpCd = tsTpCd;
		this.ibflag = ibflag;
		this.ovrLfDimWdt = ovrLfDimWdt;
		this.stwgTpCd = stwgTpCd;
		this.dimWdt = dimWdt;
		this.dimLen = dimLen;
		this.dcgoFlg = dcgoFlg;
		this.psaBatNo = psaBatNo;
		this.n1stPodCd = n1stPodCd;
		this.psaVoyDirCd = psaVoyDirCd;
		this.ovrBakDimLen = ovrBakDimLen;
		this.cntrWgt = cntrWgt;
		this.cfsTpCd = cfsTpCd;
		this.dimHgt = dimHgt;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.cgoDesc = cgoDesc;
		this.bkgNo = bkgNo;
		this.rcTemp = rcTemp;
		this.cntrNo = cntrNo;
		this.ovrFntDimLen = ovrFntDimLen;
		this.fullMtyCd = fullMtyCd;
		this.cntrSealNo = cntrSealNo;
		this.dirDeFlg = dirDeFlg;		
		this.vgmInd = vgmInd;
		this.vgmMzdTpCd = vgmMzdTpCd;
		this.vgmVrfySigCtnt = vgmVrfySigCtnt;
		this.vgmRefNo = vgmRefNo;
		this.vgmVrfyDt = vgmVrfyDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ovr_rt_dim_wdt", getOvrRtDimWdt());
		this.hashColumns.put("cntr_opr_cd", getCntrOprCd());
		this.hashColumns.put("psa_vsl_nm", getPsaVslNm());
		this.hashColumns.put("ovr_dim_hgt", getOvrDimHgt());
		this.hashColumns.put("dpt_svc_tp_cd", getDptSvcTpCd());
		this.hashColumns.put("rf_cntr_pre_trd_insp_tp_cd", getRfCntrPreTrdInspTpCd());
		this.hashColumns.put("dchg_ovr_sz_flg", getDchgOvrSzFlg());
		this.hashColumns.put("ob_slt_opr_cd", getObSltOprCd());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("ib_slt_opr_cd", getIbSltOprCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ts_tp_cd", getTsTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ovr_lf_dim_wdt", getOvrLfDimWdt());
		this.hashColumns.put("stwg_tp_cd", getStwgTpCd());
		this.hashColumns.put("dim_wdt", getDimWdt());
		this.hashColumns.put("dim_len", getDimLen());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("psa_bat_no", getPsaBatNo());
		this.hashColumns.put("n1st_pod_cd", getN1stPodCd());
		this.hashColumns.put("psa_voy_dir_cd", getPsaVoyDirCd());
		this.hashColumns.put("ovr_bak_dim_len", getOvrBakDimLen());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("cfs_tp_cd", getCfsTpCd());
		this.hashColumns.put("dim_hgt", getDimHgt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cgo_desc", getCgoDesc());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rc_temp", getRcTemp());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ovr_fnt_dim_len", getOvrFntDimLen());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("dir_de_flg", getDirDeFlg());
		this.hashColumns.put("vgm_ind",getVgmInd());
		this.hashColumns.put("vgm_mzd_tp_cd",getVgmMzdTpCd());
		this.hashColumns.put("vgm_vrfy_sig_ctnt",getVgmVrfySigCtnt());
		this.hashColumns.put("vgm_ref_no",getVgmRefNo());
		this.hashColumns.put("vgm_vrfy_dt",getVgmVrfyDt());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ovr_rt_dim_wdt", "ovrRtDimWdt");
		this.hashFields.put("cntr_opr_cd", "cntrOprCd");
		this.hashFields.put("psa_vsl_nm", "psaVslNm");
		this.hashFields.put("ovr_dim_hgt", "ovrDimHgt");
		this.hashFields.put("dpt_svc_tp_cd", "dptSvcTpCd");
		this.hashFields.put("rf_cntr_pre_trd_insp_tp_cd", "rfCntrPreTrdInspTpCd");
		this.hashFields.put("dchg_ovr_sz_flg", "dchgOvrSzFlg");
		this.hashFields.put("ob_slt_opr_cd", "obSltOprCd");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("ib_slt_opr_cd", "ibSltOprCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ts_tp_cd", "tsTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ovr_lf_dim_wdt", "ovrLfDimWdt");
		this.hashFields.put("stwg_tp_cd", "stwgTpCd");
		this.hashFields.put("dim_wdt", "dimWdt");
		this.hashFields.put("dim_len", "dimLen");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("psa_bat_no", "psaBatNo");
		this.hashFields.put("n1st_pod_cd", "n1stPodCd");
		this.hashFields.put("psa_voy_dir_cd", "psaVoyDirCd");
		this.hashFields.put("ovr_bak_dim_len", "ovrBakDimLen");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("cfs_tp_cd", "cfsTpCd");
		this.hashFields.put("dim_hgt", "dimHgt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cgo_desc", "cgoDesc");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rc_temp", "rcTemp");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ovr_fnt_dim_len", "ovrFntDimLen");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("dir_de_flg", "dirDeFlg");
		this.hashFields.put("vgm_ind","vgmInd");
		this.hashFields.put("vgm_mzd_tp_cd","vgmMzdTpCd");
		this.hashFields.put("vgm_vrfy_sig_ctnt","vgmVrfySigCtnt");
		this.hashFields.put("vgm_ref_no","vgmRefNo");
		this.hashFields.put("vgm_vrfy_dt","vgmVrfyDt");		
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
	 * @return ovrRtDimWdt
	 */
	public String getOvrRtDimWdt() {
		return this.ovrRtDimWdt;
	}
	
	/**
	 * Column Info
	 * @return cntrOprCd
	 */
	public String getCntrOprCd() {
		return this.cntrOprCd;
	}
	
	/**
	 * Column Info
	 * @return psaVslNm
	 */
	public String getPsaVslNm() {
		return this.psaVslNm;
	}
	
	/**
	 * Column Info
	 * @return ovrDimHgt
	 */
	public String getOvrDimHgt() {
		return this.ovrDimHgt;
	}
	
	/**
	 * Column Info
	 * @return dptSvcTpCd
	 */
	public String getDptSvcTpCd() {
		return this.dptSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return rfCntrPreTrdInspTpCd
	 */
	public String getRfCntrPreTrdInspTpCd() {
		return this.rfCntrPreTrdInspTpCd;
	}
	
	/**
	 * Column Info
	 * @return dchgOvrSzFlg
	 */
	public String getDchgOvrSzFlg() {
		return this.dchgOvrSzFlg;
	}
	
	/**
	 * Column Info
	 * @return obSltOprCd
	 */
	public String getObSltOprCd() {
		return this.obSltOprCd;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return ibSltOprCd
	 */
	public String getIbSltOprCd() {
		return this.ibSltOprCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return tsTpCd
	 */
	public String getTsTpCd() {
		return this.tsTpCd;
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
	 * @return ovrLfDimWdt
	 */
	public String getOvrLfDimWdt() {
		return this.ovrLfDimWdt;
	}
	
	/**
	 * Column Info
	 * @return stwgTpCd
	 */
	public String getStwgTpCd() {
		return this.stwgTpCd;
	}
	
	/**
	 * Column Info
	 * @return dimWdt
	 */
	public String getDimWdt() {
		return this.dimWdt;
	}
	
	/**
	 * Column Info
	 * @return dimLen
	 */
	public String getDimLen() {
		return this.dimLen;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return psaBatNo
	 */
	public String getPsaBatNo() {
		return this.psaBatNo;
	}
	
	/**
	 * Column Info
	 * @return n1stPodCd
	 */
	public String getN1stPodCd() {
		return this.n1stPodCd;
	}
	
	/**
	 * Column Info
	 * @return psaVoyDirCd
	 */
	public String getPsaVoyDirCd() {
		return this.psaVoyDirCd;
	}
	
	/**
	 * Column Info
	 * @return ovrBakDimLen
	 */
	public String getOvrBakDimLen() {
		return this.ovrBakDimLen;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return cfsTpCd
	 */
	public String getCfsTpCd() {
		return this.cfsTpCd;
	}
	
	/**
	 * Column Info
	 * @return dimHgt
	 */
	public String getDimHgt() {
		return this.dimHgt;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return cgoDesc
	 */
	public String getCgoDesc() {
		return this.cgoDesc;
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
	 * @return rcTemp
	 */
	public String getRcTemp() {
		return this.rcTemp;
	}
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return ovrFntDimLen
	 */
	public String getOvrFntDimLen() {
		return this.ovrFntDimLen;
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
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return dirDeFlg
	 */
	public String getDirDeFlg() {
		return this.dirDeFlg;
	}
	
	/**
	 * Column Info
	 * @return vgmInd
	 */
	public String getVgmInd() {
		return this.vgmInd;
	}
	
	/**
	 * Column Info
	 * @return vgmMzdTpCd
	 */
	public String getVgmMzdTpCd() {
		return this.vgmMzdTpCd;
	}
	
	/**
	 * Column Info
	 * @return vgmVrfySigCtnt
	 */
	public String getVgmVrfySigCtnt() {
		return this.vgmVrfySigCtnt;
	}
	
	/**
	 * Column Info
	 * @return vgmRefNo
	 */
	public String getVgmRefNo() {
		return this.vgmRefNo;
	}
	
	/**
	 * Column Info
	 * @return vgmVrfyDt
	 */
	public String getVgmVrfyDt() {
		return this.vgmVrfyDt;
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
	 * @param ovrRtDimWdt
	 */
	public void setOvrRtDimWdt(String ovrRtDimWdt) {
		this.ovrRtDimWdt = ovrRtDimWdt;
	}
	
	/**
	 * Column Info
	 * @param cntrOprCd
	 */
	public void setCntrOprCd(String cntrOprCd) {
		this.cntrOprCd = cntrOprCd;
	}
	
	/**
	 * Column Info
	 * @param psaVslNm
	 */
	public void setPsaVslNm(String psaVslNm) {
		this.psaVslNm = psaVslNm;
	}
	
	/**
	 * Column Info
	 * @param ovrDimHgt
	 */
	public void setOvrDimHgt(String ovrDimHgt) {
		this.ovrDimHgt = ovrDimHgt;
	}
	
	/**
	 * Column Info
	 * @param dptSvcTpCd
	 */
	public void setDptSvcTpCd(String dptSvcTpCd) {
		this.dptSvcTpCd = dptSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param rfCntrPreTrdInspTpCd
	 */
	public void setRfCntrPreTrdInspTpCd(String rfCntrPreTrdInspTpCd) {
		this.rfCntrPreTrdInspTpCd = rfCntrPreTrdInspTpCd;
	}
	
	/**
	 * Column Info
	 * @param dchgOvrSzFlg
	 */
	public void setDchgOvrSzFlg(String dchgOvrSzFlg) {
		this.dchgOvrSzFlg = dchgOvrSzFlg;
	}
	
	/**
	 * Column Info
	 * @param obSltOprCd
	 */
	public void setObSltOprCd(String obSltOprCd) {
		this.obSltOprCd = obSltOprCd;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param ibSltOprCd
	 */
	public void setIbSltOprCd(String ibSltOprCd) {
		this.ibSltOprCd = ibSltOprCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param tsTpCd
	 */
	public void setTsTpCd(String tsTpCd) {
		this.tsTpCd = tsTpCd;
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
	 * @param ovrLfDimWdt
	 */
	public void setOvrLfDimWdt(String ovrLfDimWdt) {
		this.ovrLfDimWdt = ovrLfDimWdt;
	}
	
	/**
	 * Column Info
	 * @param stwgTpCd
	 */
	public void setStwgTpCd(String stwgTpCd) {
		this.stwgTpCd = stwgTpCd;
	}
	
	/**
	 * Column Info
	 * @param dimWdt
	 */
	public void setDimWdt(String dimWdt) {
		this.dimWdt = dimWdt;
	}
	
	/**
	 * Column Info
	 * @param dimLen
	 */
	public void setDimLen(String dimLen) {
		this.dimLen = dimLen;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param psaBatNo
	 */
	public void setPsaBatNo(String psaBatNo) {
		this.psaBatNo = psaBatNo;
	}
	
	/**
	 * Column Info
	 * @param n1stPodCd
	 */
	public void setN1stPodCd(String n1stPodCd) {
		this.n1stPodCd = n1stPodCd;
	}
	
	/**
	 * Column Info
	 * @param psaVoyDirCd
	 */
	public void setPsaVoyDirCd(String psaVoyDirCd) {
		this.psaVoyDirCd = psaVoyDirCd;
	}
	
	/**
	 * Column Info
	 * @param ovrBakDimLen
	 */
	public void setOvrBakDimLen(String ovrBakDimLen) {
		this.ovrBakDimLen = ovrBakDimLen;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param cfsTpCd
	 */
	public void setCfsTpCd(String cfsTpCd) {
		this.cfsTpCd = cfsTpCd;
	}
	
	/**
	 * Column Info
	 * @param dimHgt
	 */
	public void setDimHgt(String dimHgt) {
		this.dimHgt = dimHgt;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param cgoDesc
	 */
	public void setCgoDesc(String cgoDesc) {
		this.cgoDesc = cgoDesc;
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
	 * @param rcTemp
	 */
	public void setRcTemp(String rcTemp) {
		this.rcTemp = rcTemp;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param ovrFntDimLen
	 */
	public void setOvrFntDimLen(String ovrFntDimLen) {
		this.ovrFntDimLen = ovrFntDimLen;
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
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param dirDeFlg
	 */
	public void setDirDeFlg(String dirDeFlg) {
		this.dirDeFlg = dirDeFlg;
	}
	

	
	/**
	 * Column Info
	 * @param vgmInd
	 */
	public void setVgmInd(String vgmInd) {
		this.vgmInd = vgmInd;
	}
	
	/**
	 * Column Info
	 * @param vgmMzdTpCd
	 */
	public void setVgmMzdTpCd(String vgmMzdTpCd) {
		this.vgmMzdTpCd = vgmMzdTpCd;
	}
	
	/**
	 * Column Info
	 * @param vgmVrfySigCtnt
	 */
	public void setVgmVrfySigCtnt(String vgmVrfySigCtnt) {
		this.vgmVrfySigCtnt = vgmVrfySigCtnt;
	}
	
	/**
	 * Column Info
	 * @param vgmRefNo
	 */
	public void setVgmRefNo(String vgmRefNo) {
		this.vgmRefNo = vgmRefNo;
	}
	
	/**
	 * Column Info
	 * @param vgmVrfyDt
	 */
	public void setVgmVrfyDt(String vgmVrfyDt) {
		this.vgmVrfyDt = vgmVrfyDt;
	}	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setOvrRtDimWdt(JSPUtil.getParameter(request, "ovr_rt_dim_wdt", ""));
		setCntrOprCd(JSPUtil.getParameter(request, "cntr_opr_cd", ""));
		setPsaVslNm(JSPUtil.getParameter(request, "psa_vsl_nm", ""));
		setOvrDimHgt(JSPUtil.getParameter(request, "ovr_dim_hgt", ""));
		setDptSvcTpCd(JSPUtil.getParameter(request, "dpt_svc_tp_cd", ""));
		setRfCntrPreTrdInspTpCd(JSPUtil.getParameter(request, "rf_cntr_pre_trd_insp_tp_cd", ""));
		setDchgOvrSzFlg(JSPUtil.getParameter(request, "dchg_ovr_sz_flg", ""));
		setObSltOprCd(JSPUtil.getParameter(request, "ob_slt_opr_cd", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setIbSltOprCd(JSPUtil.getParameter(request, "ib_slt_opr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setTsTpCd(JSPUtil.getParameter(request, "ts_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOvrLfDimWdt(JSPUtil.getParameter(request, "ovr_lf_dim_wdt", ""));
		setStwgTpCd(JSPUtil.getParameter(request, "stwg_tp_cd", ""));
		setDimWdt(JSPUtil.getParameter(request, "dim_wdt", ""));
		setDimLen(JSPUtil.getParameter(request, "dim_len", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setPsaBatNo(JSPUtil.getParameter(request, "psa_bat_no", ""));
		setN1stPodCd(JSPUtil.getParameter(request, "n1st_pod_cd", ""));
		setPsaVoyDirCd(JSPUtil.getParameter(request, "psa_voy_dir_cd", ""));
		setOvrBakDimLen(JSPUtil.getParameter(request, "ovr_bak_dim_len", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setCfsTpCd(JSPUtil.getParameter(request, "cfs_tp_cd", ""));
		setDimHgt(JSPUtil.getParameter(request, "dim_hgt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCgoDesc(JSPUtil.getParameter(request, "cgo_desc", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setRcTemp(JSPUtil.getParameter(request, "rc_temp", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setOvrFntDimLen(JSPUtil.getParameter(request, "ovr_fnt_dim_len", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setDirDeFlg(JSPUtil.getParameter(request, "dir_de_flg", ""));
		setVgmInd(JSPUtil.getParameter(request, "vgm_ind", ""));
		setVgmMzdTpCd(JSPUtil.getParameter(request, "vgm_mzd_tp_cd", ""));
		setVgmVrfySigCtnt(JSPUtil.getParameter(request, "vgm_vrfy_sig_ctnt", ""));
		setVgmRefNo(JSPUtil.getParameter(request, "vgm_ref_no", ""));
		setVgmVrfyDt(JSPUtil.getParameter(request, "vgm_vrfy_dt", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaCntrVO[]
	 */
	public PsaCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsaCntrVO[]
	 */
	public PsaCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ovrRtDimWdt = (JSPUtil.getParameter(request, prefix	+ "ovr_rt_dim_wdt", length));
			String[] cntrOprCd = (JSPUtil.getParameter(request, prefix	+ "cntr_opr_cd", length));
			String[] psaVslNm = (JSPUtil.getParameter(request, prefix	+ "psa_vsl_nm", length));
			String[] ovrDimHgt = (JSPUtil.getParameter(request, prefix	+ "ovr_dim_hgt", length));
			String[] dptSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "dpt_svc_tp_cd", length));
			String[] rfCntrPreTrdInspTpCd = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_pre_trd_insp_tp_cd", length));
			String[] dchgOvrSzFlg = (JSPUtil.getParameter(request, prefix	+ "dchg_ovr_sz_flg", length));
			String[] obSltOprCd = (JSPUtil.getParameter(request, prefix	+ "ob_slt_opr_cd", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] ibSltOprCd = (JSPUtil.getParameter(request, prefix	+ "ib_slt_opr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] tsTpCd = (JSPUtil.getParameter(request, prefix	+ "ts_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ovrLfDimWdt = (JSPUtil.getParameter(request, prefix	+ "ovr_lf_dim_wdt", length));
			String[] stwgTpCd = (JSPUtil.getParameter(request, prefix	+ "stwg_tp_cd", length));
			String[] dimWdt = (JSPUtil.getParameter(request, prefix	+ "dim_wdt", length));
			String[] dimLen = (JSPUtil.getParameter(request, prefix	+ "dim_len", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] psaBatNo = (JSPUtil.getParameter(request, prefix	+ "psa_bat_no", length));
			String[] n1stPodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_cd", length));
			String[] psaVoyDirCd = (JSPUtil.getParameter(request, prefix	+ "psa_voy_dir_cd", length));
			String[] ovrBakDimLen = (JSPUtil.getParameter(request, prefix	+ "ovr_bak_dim_len", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] cfsTpCd = (JSPUtil.getParameter(request, prefix	+ "cfs_tp_cd", length));
			String[] dimHgt = (JSPUtil.getParameter(request, prefix	+ "dim_hgt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cgoDesc = (JSPUtil.getParameter(request, prefix	+ "cgo_desc", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rcTemp = (JSPUtil.getParameter(request, prefix	+ "rc_temp", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ovrFntDimLen = (JSPUtil.getParameter(request, prefix	+ "ovr_fnt_dim_len", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] dirDeFlg = (JSPUtil.getParameter(request, prefix	+ "dir_de_flg", length));
			String[] vgmInd = (JSPUtil.getParameter(request, prefix	+ "vgm_ind", length));
			String[] vgmMzdTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_mzd_tp_cd", length));
			String[] vgmVrfySigCtnt = (JSPUtil.getParameter(request, prefix	+ "vgm_vrfy_sig_ctnt", length));
			String[] vgmRefNo = (JSPUtil.getParameter(request, prefix	+ "vgm_ref_no", length));
			String[] vgmVrfyDt = (JSPUtil.getParameter(request, prefix	+ "vgm_vrfy_dt", length));			
			
			for (int i = 0; i < length; i++) {
				model = new PsaCntrVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ovrRtDimWdt[i] != null)
					model.setOvrRtDimWdt(ovrRtDimWdt[i]);
				if (cntrOprCd[i] != null)
					model.setCntrOprCd(cntrOprCd[i]);
				if (psaVslNm[i] != null)
					model.setPsaVslNm(psaVslNm[i]);
				if (ovrDimHgt[i] != null)
					model.setOvrDimHgt(ovrDimHgt[i]);
				if (dptSvcTpCd[i] != null)
					model.setDptSvcTpCd(dptSvcTpCd[i]);
				if (rfCntrPreTrdInspTpCd[i] != null)
					model.setRfCntrPreTrdInspTpCd(rfCntrPreTrdInspTpCd[i]);
				if (dchgOvrSzFlg[i] != null)
					model.setDchgOvrSzFlg(dchgOvrSzFlg[i]);
				if (obSltOprCd[i] != null)
					model.setObSltOprCd(obSltOprCd[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (ibSltOprCd[i] != null)
					model.setIbSltOprCd(ibSltOprCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (tsTpCd[i] != null)
					model.setTsTpCd(tsTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ovrLfDimWdt[i] != null)
					model.setOvrLfDimWdt(ovrLfDimWdt[i]);
				if (stwgTpCd[i] != null)
					model.setStwgTpCd(stwgTpCd[i]);
				if (dimWdt[i] != null)
					model.setDimWdt(dimWdt[i]);
				if (dimLen[i] != null)
					model.setDimLen(dimLen[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (psaBatNo[i] != null)
					model.setPsaBatNo(psaBatNo[i]);
				if (n1stPodCd[i] != null)
					model.setN1stPodCd(n1stPodCd[i]);
				if (psaVoyDirCd[i] != null)
					model.setPsaVoyDirCd(psaVoyDirCd[i]);
				if (ovrBakDimLen[i] != null)
					model.setOvrBakDimLen(ovrBakDimLen[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (cfsTpCd[i] != null)
					model.setCfsTpCd(cfsTpCd[i]);
				if (dimHgt[i] != null)
					model.setDimHgt(dimHgt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cgoDesc[i] != null)
					model.setCgoDesc(cgoDesc[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rcTemp[i] != null)
					model.setRcTemp(rcTemp[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ovrFntDimLen[i] != null)
					model.setOvrFntDimLen(ovrFntDimLen[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (dirDeFlg[i] != null)
					model.setDirDeFlg(dirDeFlg[i]);
				if (vgmInd[i] != null)
					model.setVgmInd(vgmInd[i]);
				if (vgmMzdTpCd[i] != null)
					model.setVgmMzdTpCd(vgmMzdTpCd[i]);
				if (vgmVrfySigCtnt[i] != null)
					model.setVgmVrfySigCtnt(vgmVrfySigCtnt[i]);
				if (vgmRefNo[i] != null)
					model.setVgmRefNo(vgmRefNo[i]);
				if (vgmVrfyDt[i] != null)
					model.setVgmVrfyDt(vgmVrfyDt[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaCntrVO[]
	 */
	public PsaCntrVO[] getPsaCntrVOs(){
		PsaCntrVO[] vos = (PsaCntrVO[])models.toArray(new PsaCntrVO[models.size()]);
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
		this.ovrRtDimWdt = this.ovrRtDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOprCd = this.cntrOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaVslNm = this.psaVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDimHgt = this.ovrDimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dptSvcTpCd = this.dptSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrPreTrdInspTpCd = this.rfCntrPreTrdInspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgOvrSzFlg = this.dchgOvrSzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSltOprCd = this.obSltOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSltOprCd = this.ibSltOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsTpCd = this.tsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrLfDimWdt = this.ovrLfDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgTpCd = this.stwgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimWdt = this.dimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimLen = this.dimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaBatNo = this.psaBatNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPodCd = this.n1stPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaVoyDirCd = this.psaVoyDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrBakDimLen = this.ovrBakDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfsTpCd = this.cfsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimHgt = this.dimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc = this.cgoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcTemp = this.rcTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrFntDimLen = this.ovrFntDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirDeFlg = this.dirDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmInd = this.vgmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmMzdTpCd = this.vgmMzdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfySigCtnt = this.vgmVrfySigCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmRefNo = this.vgmRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfyDt = this.vgmVrfyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
