/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PsaCntrVO.java
*@FileTitle : PsaCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PsaCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsaCntrVO> models = new ArrayList<PsaCntrVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String dptSvcTpCd = null;
	/* Column Info */
	private String ovrDimHgt = null;
	/* Column Info */
	private String psaVslNm = null;
	/* Column Info */
	private String dchgOvrSzFlg = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Column Info */
	private String n2ndPodCd = null;
	/* Column Info */
	private String obSltOprCd = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tsTpCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String dimWdt = null;
	/* Column Info */
	private String cmdtHsCd = null;
	/* Column Info */
	private String psaBatNo = null;
	/* Column Info */
	private String n1stPodCd = null;
	/* Column Info */
	private String ovrBakDimLen = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String cfsTpCd = null;
	/* Column Info */
	private String dimHgt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cntrTpsz = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rcTemp = null;
	/* Column Info */
	private String ovrFntDimLen = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String cbmPerHrQty = null;
	/* Column Info */
	private String psaCreTpCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String ovrRtDimWdt = null;
	/* Column Info */
	private String socInd = null;
	/* Column Info */
	private String cntrOprCd = null;
	/* Column Info */
	private String rfCntrPreTrdInspTpCd = null;
	/* Column Info */
	private String ibSltOprCd = null;
	/* Column Info */
	private String stwgTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ovrLfDimWdt = null;
	/* Column Info */
	private String dimLen = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String psaVoyDirCd = null;
	/* Column Info */
	private String cntrClass = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String n3rdPodCd = null;
	/* Column Info */
	private String cgoDesc = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String dirDeFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PsaCntrVO() {}

	public PsaCntrVO(String ibflag, String pagerows, String bkgNo, String blckStwgCd, String blNo, String cbmPerHrQty, String cfsTpCd, String cgoDesc, String cmdtHsCd, String cneeNm, String cntrClass, String cntrNo, String cntrOprCd, String cntrSealNo, String cntrTpsz, String cntrWgt, String dcgoFlg, String dchgOvrSzFlg, String delCd, String dimHgt, String dimLen, String dimWdt, String dirDeFlg, String dptSvcTpCd, String fullMtyCd, String ibSltOprCd, String n1stPodCd, String n2ndPodCd, String n3rdPodCd, String ntfyNm, String obSltOprCd, String ovrBakDimLen, String ovrDimHgt, String ovrFntDimLen, String ovrLfDimWdt, String ovrRtDimWdt, String podCd, String polCd, String porCd, String psaBatNo, String psaCreTpCd, String psaVoyDirCd, String psaVslNm, String rcTemp, String rfCntrPreTrdInspTpCd, String skdDirCd, String skdVoyNo, String slanCd, String sndDt, String socInd, String stwgTpCd, String tsTpCd, String vslCd) {
		this.vslCd = vslCd;
		this.dptSvcTpCd = dptSvcTpCd;
		this.ovrDimHgt = ovrDimHgt;
		this.psaVslNm = psaVslNm;
		this.dchgOvrSzFlg = dchgOvrSzFlg;
		this.blckStwgCd = blckStwgCd;
		this.n2ndPodCd = n2ndPodCd;
		this.obSltOprCd = obSltOprCd;
		this.sndDt = sndDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.tsTpCd = tsTpCd;
		this.polCd = polCd;
		this.dimWdt = dimWdt;
		this.cmdtHsCd = cmdtHsCd;
		this.psaBatNo = psaBatNo;
		this.n1stPodCd = n1stPodCd;
		this.ovrBakDimLen = ovrBakDimLen;
		this.cntrWgt = cntrWgt;
		this.cfsTpCd = cfsTpCd;
		this.dimHgt = dimHgt;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.cntrTpsz = cntrTpsz;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.rcTemp = rcTemp;
		this.ovrFntDimLen = ovrFntDimLen;
		this.fullMtyCd = fullMtyCd;
		this.cbmPerHrQty = cbmPerHrQty;
		this.psaCreTpCd = psaCreTpCd;
		this.porCd = porCd;
		this.ovrRtDimWdt = ovrRtDimWdt;
		this.socInd = socInd;
		this.cntrOprCd = cntrOprCd;
		this.rfCntrPreTrdInspTpCd = rfCntrPreTrdInspTpCd;
		this.ibSltOprCd = ibSltOprCd;
		this.stwgTpCd = stwgTpCd;
		this.ibflag = ibflag;
		this.ovrLfDimWdt = ovrLfDimWdt;
		this.dimLen = dimLen;
		this.dcgoFlg = dcgoFlg;
		this.psaVoyDirCd = psaVoyDirCd;
		this.cntrClass = cntrClass;
		this.ntfyNm = ntfyNm;
		this.skdDirCd = skdDirCd;
		this.n3rdPodCd = n3rdPodCd;
		this.cgoDesc = cgoDesc;
		this.cneeNm = cneeNm;
		this.slanCd = slanCd;
		this.cntrNo = cntrNo;
		this.cntrSealNo = cntrSealNo;
		this.dirDeFlg = dirDeFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("dpt_svc_tp_cd", getDptSvcTpCd());
		this.hashColumns.put("ovr_dim_hgt", getOvrDimHgt());
		this.hashColumns.put("psa_vsl_nm", getPsaVslNm());
		this.hashColumns.put("dchg_ovr_sz_flg", getDchgOvrSzFlg());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("n2nd_pod_cd", getN2ndPodCd());
		this.hashColumns.put("ob_slt_opr_cd", getObSltOprCd());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ts_tp_cd", getTsTpCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("dim_wdt", getDimWdt());
		this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
		this.hashColumns.put("psa_bat_no", getPsaBatNo());
		this.hashColumns.put("n1st_pod_cd", getN1stPodCd());
		this.hashColumns.put("ovr_bak_dim_len", getOvrBakDimLen());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("cfs_tp_cd", getCfsTpCd());
		this.hashColumns.put("dim_hgt", getDimHgt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cntr_tpsz", getCntrTpsz());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rc_temp", getRcTemp());
		this.hashColumns.put("ovr_fnt_dim_len", getOvrFntDimLen());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("cbm_per_hr_qty", getCbmPerHrQty());
		this.hashColumns.put("psa_cre_tp_cd", getPsaCreTpCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("ovr_rt_dim_wdt", getOvrRtDimWdt());
		this.hashColumns.put("soc_ind", getSocInd());
		this.hashColumns.put("cntr_opr_cd", getCntrOprCd());
		this.hashColumns.put("rf_cntr_pre_trd_insp_tp_cd", getRfCntrPreTrdInspTpCd());
		this.hashColumns.put("ib_slt_opr_cd", getIbSltOprCd());
		this.hashColumns.put("stwg_tp_cd", getStwgTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ovr_lf_dim_wdt", getOvrLfDimWdt());
		this.hashColumns.put("dim_len", getDimLen());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("psa_voy_dir_cd", getPsaVoyDirCd());
		this.hashColumns.put("cntr_class", getCntrClass());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("n3rd_pod_cd", getN3rdPodCd());
		this.hashColumns.put("cgo_desc", getCgoDesc());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("dir_de_flg", getDirDeFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("dpt_svc_tp_cd", "dptSvcTpCd");
		this.hashFields.put("ovr_dim_hgt", "ovrDimHgt");
		this.hashFields.put("psa_vsl_nm", "psaVslNm");
		this.hashFields.put("dchg_ovr_sz_flg", "dchgOvrSzFlg");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("n2nd_pod_cd", "n2ndPodCd");
		this.hashFields.put("ob_slt_opr_cd", "obSltOprCd");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ts_tp_cd", "tsTpCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("dim_wdt", "dimWdt");
		this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
		this.hashFields.put("psa_bat_no", "psaBatNo");
		this.hashFields.put("n1st_pod_cd", "n1stPodCd");
		this.hashFields.put("ovr_bak_dim_len", "ovrBakDimLen");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("cfs_tp_cd", "cfsTpCd");
		this.hashFields.put("dim_hgt", "dimHgt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cntr_tpsz", "cntrTpsz");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rc_temp", "rcTemp");
		this.hashFields.put("ovr_fnt_dim_len", "ovrFntDimLen");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("cbm_per_hr_qty", "cbmPerHrQty");
		this.hashFields.put("psa_cre_tp_cd", "psaCreTpCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("ovr_rt_dim_wdt", "ovrRtDimWdt");
		this.hashFields.put("soc_ind", "socInd");
		this.hashFields.put("cntr_opr_cd", "cntrOprCd");
		this.hashFields.put("rf_cntr_pre_trd_insp_tp_cd", "rfCntrPreTrdInspTpCd");
		this.hashFields.put("ib_slt_opr_cd", "ibSltOprCd");
		this.hashFields.put("stwg_tp_cd", "stwgTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ovr_lf_dim_wdt", "ovrLfDimWdt");
		this.hashFields.put("dim_len", "dimLen");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("psa_voy_dir_cd", "psaVoyDirCd");
		this.hashFields.put("cntr_class", "cntrClass");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("n3rd_pod_cd", "n3rdPodCd");
		this.hashFields.put("cgo_desc", "cgoDesc");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("dir_de_flg", "dirDeFlg");
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
	 * @return dptSvcTpCd
	 */
	public String getDptSvcTpCd() {
		return this.dptSvcTpCd;
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
	 * @return psaVslNm
	 */
	public String getPsaVslNm() {
		return this.psaVslNm;
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
	 * @return blckStwgCd
	 */
	public String getBlckStwgCd() {
		return this.blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndPodCd
	 */
	public String getN2ndPodCd() {
		return this.n2ndPodCd;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return tsTpCd
	 */
	public String getTsTpCd() {
		return this.tsTpCd;
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
	 * @return dimWdt
	 */
	public String getDimWdt() {
		return this.dimWdt;
	}
	
	/**
	 * Column Info
	 * @return cmdtHsCd
	 */
	public String getCmdtHsCd() {
		return this.cmdtHsCd;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return cntrTpsz
	 */
	public String getCntrTpsz() {
		return this.cntrTpsz;
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
	 * @return rcTemp
	 */
	public String getRcTemp() {
		return this.rcTemp;
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
	 * @return cbmPerHrQty
	 */
	public String getCbmPerHrQty() {
		return this.cbmPerHrQty;
	}
	
	/**
	 * Column Info
	 * @return psaCreTpCd
	 */
	public String getPsaCreTpCd() {
		return this.psaCreTpCd;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return socInd
	 */
	public String getSocInd() {
		return this.socInd;
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
	 * @return rfCntrPreTrdInspTpCd
	 */
	public String getRfCntrPreTrdInspTpCd() {
		return this.rfCntrPreTrdInspTpCd;
	}
	
	/**
	 * Column Info
	 * @return ibSltOprCd
	 */
	public String getIbSltOprCd() {
		return this.ibSltOprCd;
	}
	
	/**
	 * Column Info
	 * @return stwgTpCd
	 */
	public String getStwgTpCd() {
		return this.stwgTpCd;
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
	 * @return psaVoyDirCd
	 */
	public String getPsaVoyDirCd() {
		return this.psaVoyDirCd;
	}
	
	/**
	 * Column Info
	 * @return cntrClass
	 */
	public String getCntrClass() {
		return this.cntrClass;
	}
	
	/**
	 * Column Info
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
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
	 * @return n3rdPodCd
	 */
	public String getN3rdPodCd() {
		return this.n3rdPodCd;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param ovrDimHgt
	 */
	public void setOvrDimHgt(String ovrDimHgt) {
		this.ovrDimHgt = ovrDimHgt;
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
	 * @param dchgOvrSzFlg
	 */
	public void setDchgOvrSzFlg(String dchgOvrSzFlg) {
		this.dchgOvrSzFlg = dchgOvrSzFlg;
	}
	
	/**
	 * Column Info
	 * @param blckStwgCd
	 */
	public void setBlckStwgCd(String blckStwgCd) {
		this.blckStwgCd = blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndPodCd
	 */
	public void setN2ndPodCd(String n2ndPodCd) {
		this.n2ndPodCd = n2ndPodCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param tsTpCd
	 */
	public void setTsTpCd(String tsTpCd) {
		this.tsTpCd = tsTpCd;
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
	 * @param dimWdt
	 */
	public void setDimWdt(String dimWdt) {
		this.dimWdt = dimWdt;
	}
	
	/**
	 * Column Info
	 * @param cmdtHsCd
	 */
	public void setCmdtHsCd(String cmdtHsCd) {
		this.cmdtHsCd = cmdtHsCd;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param cntrTpsz
	 */
	public void setCntrTpsz(String cntrTpsz) {
		this.cntrTpsz = cntrTpsz;
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
	 * @param rcTemp
	 */
	public void setRcTemp(String rcTemp) {
		this.rcTemp = rcTemp;
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
	 * @param cbmPerHrQty
	 */
	public void setCbmPerHrQty(String cbmPerHrQty) {
		this.cbmPerHrQty = cbmPerHrQty;
	}
	
	/**
	 * Column Info
	 * @param psaCreTpCd
	 */
	public void setPsaCreTpCd(String psaCreTpCd) {
		this.psaCreTpCd = psaCreTpCd;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
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
	 * @param socInd
	 */
	public void setSocInd(String socInd) {
		this.socInd = socInd;
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
	 * @param rfCntrPreTrdInspTpCd
	 */
	public void setRfCntrPreTrdInspTpCd(String rfCntrPreTrdInspTpCd) {
		this.rfCntrPreTrdInspTpCd = rfCntrPreTrdInspTpCd;
	}
	
	/**
	 * Column Info
	 * @param ibSltOprCd
	 */
	public void setIbSltOprCd(String ibSltOprCd) {
		this.ibSltOprCd = ibSltOprCd;
	}
	
	/**
	 * Column Info
	 * @param stwgTpCd
	 */
	public void setStwgTpCd(String stwgTpCd) {
		this.stwgTpCd = stwgTpCd;
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
	 * @param psaVoyDirCd
	 */
	public void setPsaVoyDirCd(String psaVoyDirCd) {
		this.psaVoyDirCd = psaVoyDirCd;
	}
	
	/**
	 * Column Info
	 * @param cntrClass
	 */
	public void setCntrClass(String cntrClass) {
		this.cntrClass = cntrClass;
	}
	
	/**
	 * Column Info
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
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
	 * @param n3rdPodCd
	 */
	public void setN3rdPodCd(String n3rdPodCd) {
		this.n3rdPodCd = n3rdPodCd;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
		setDptSvcTpCd(JSPUtil.getParameter(request, prefix + "dpt_svc_tp_cd", ""));
		setOvrDimHgt(JSPUtil.getParameter(request, prefix + "ovr_dim_hgt", ""));
		setPsaVslNm(JSPUtil.getParameter(request, prefix + "psa_vsl_nm", ""));
		setDchgOvrSzFlg(JSPUtil.getParameter(request, prefix + "dchg_ovr_sz_flg", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setN2ndPodCd(JSPUtil.getParameter(request, prefix + "n2nd_pod_cd", ""));
		setObSltOprCd(JSPUtil.getParameter(request, prefix + "ob_slt_opr_cd", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTsTpCd(JSPUtil.getParameter(request, prefix + "ts_tp_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setDimWdt(JSPUtil.getParameter(request, prefix + "dim_wdt", ""));
		setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
		setPsaBatNo(JSPUtil.getParameter(request, prefix + "psa_bat_no", ""));
		setN1stPodCd(JSPUtil.getParameter(request, prefix + "n1st_pod_cd", ""));
		setOvrBakDimLen(JSPUtil.getParameter(request, prefix + "ovr_bak_dim_len", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setCfsTpCd(JSPUtil.getParameter(request, prefix + "cfs_tp_cd", ""));
		setDimHgt(JSPUtil.getParameter(request, prefix + "dim_hgt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCntrTpsz(JSPUtil.getParameter(request, prefix + "cntr_tpsz", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRcTemp(JSPUtil.getParameter(request, prefix + "rc_temp", ""));
		setOvrFntDimLen(JSPUtil.getParameter(request, prefix + "ovr_fnt_dim_len", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setCbmPerHrQty(JSPUtil.getParameter(request, prefix + "cbm_per_hr_qty", ""));
		setPsaCreTpCd(JSPUtil.getParameter(request, prefix + "psa_cre_tp_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setOvrRtDimWdt(JSPUtil.getParameter(request, prefix + "ovr_rt_dim_wdt", ""));
		setSocInd(JSPUtil.getParameter(request, prefix + "soc_ind", ""));
		setCntrOprCd(JSPUtil.getParameter(request, prefix + "cntr_opr_cd", ""));
		setRfCntrPreTrdInspTpCd(JSPUtil.getParameter(request, prefix + "rf_cntr_pre_trd_insp_tp_cd", ""));
		setIbSltOprCd(JSPUtil.getParameter(request, prefix + "ib_slt_opr_cd", ""));
		setStwgTpCd(JSPUtil.getParameter(request, prefix + "stwg_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOvrLfDimWdt(JSPUtil.getParameter(request, prefix + "ovr_lf_dim_wdt", ""));
		setDimLen(JSPUtil.getParameter(request, prefix + "dim_len", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setPsaVoyDirCd(JSPUtil.getParameter(request, prefix + "psa_voy_dir_cd", ""));
		setCntrClass(JSPUtil.getParameter(request, prefix + "cntr_class", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setN3rdPodCd(JSPUtil.getParameter(request, prefix + "n3rd_pod_cd", ""));
		setCgoDesc(JSPUtil.getParameter(request, prefix + "cgo_desc", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setDirDeFlg(JSPUtil.getParameter(request, prefix + "dir_de_flg", ""));
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
			String[] dptSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "dpt_svc_tp_cd", length));
			String[] ovrDimHgt = (JSPUtil.getParameter(request, prefix	+ "ovr_dim_hgt", length));
			String[] psaVslNm = (JSPUtil.getParameter(request, prefix	+ "psa_vsl_nm", length));
			String[] dchgOvrSzFlg = (JSPUtil.getParameter(request, prefix	+ "dchg_ovr_sz_flg", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] n2ndPodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pod_cd", length));
			String[] obSltOprCd = (JSPUtil.getParameter(request, prefix	+ "ob_slt_opr_cd", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tsTpCd = (JSPUtil.getParameter(request, prefix	+ "ts_tp_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] dimWdt = (JSPUtil.getParameter(request, prefix	+ "dim_wdt", length));
			String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_cd", length));
			String[] psaBatNo = (JSPUtil.getParameter(request, prefix	+ "psa_bat_no", length));
			String[] n1stPodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_cd", length));
			String[] ovrBakDimLen = (JSPUtil.getParameter(request, prefix	+ "ovr_bak_dim_len", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] cfsTpCd = (JSPUtil.getParameter(request, prefix	+ "cfs_tp_cd", length));
			String[] dimHgt = (JSPUtil.getParameter(request, prefix	+ "dim_hgt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cntrTpsz = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rcTemp = (JSPUtil.getParameter(request, prefix	+ "rc_temp", length));
			String[] ovrFntDimLen = (JSPUtil.getParameter(request, prefix	+ "ovr_fnt_dim_len", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] cbmPerHrQty = (JSPUtil.getParameter(request, prefix	+ "cbm_per_hr_qty", length));
			String[] psaCreTpCd = (JSPUtil.getParameter(request, prefix	+ "psa_cre_tp_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] ovrRtDimWdt = (JSPUtil.getParameter(request, prefix	+ "ovr_rt_dim_wdt", length));
			String[] socInd = (JSPUtil.getParameter(request, prefix	+ "soc_ind", length));
			String[] cntrOprCd = (JSPUtil.getParameter(request, prefix	+ "cntr_opr_cd", length));
			String[] rfCntrPreTrdInspTpCd = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_pre_trd_insp_tp_cd", length));
			String[] ibSltOprCd = (JSPUtil.getParameter(request, prefix	+ "ib_slt_opr_cd", length));
			String[] stwgTpCd = (JSPUtil.getParameter(request, prefix	+ "stwg_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ovrLfDimWdt = (JSPUtil.getParameter(request, prefix	+ "ovr_lf_dim_wdt", length));
			String[] dimLen = (JSPUtil.getParameter(request, prefix	+ "dim_len", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] psaVoyDirCd = (JSPUtil.getParameter(request, prefix	+ "psa_voy_dir_cd", length));
			String[] cntrClass = (JSPUtil.getParameter(request, prefix	+ "cntr_class", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] n3rdPodCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pod_cd", length));
			String[] cgoDesc = (JSPUtil.getParameter(request, prefix	+ "cgo_desc", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] dirDeFlg = (JSPUtil.getParameter(request, prefix	+ "dir_de_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsaCntrVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (dptSvcTpCd[i] != null)
					model.setDptSvcTpCd(dptSvcTpCd[i]);
				if (ovrDimHgt[i] != null)
					model.setOvrDimHgt(ovrDimHgt[i]);
				if (psaVslNm[i] != null)
					model.setPsaVslNm(psaVslNm[i]);
				if (dchgOvrSzFlg[i] != null)
					model.setDchgOvrSzFlg(dchgOvrSzFlg[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (n2ndPodCd[i] != null)
					model.setN2ndPodCd(n2ndPodCd[i]);
				if (obSltOprCd[i] != null)
					model.setObSltOprCd(obSltOprCd[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tsTpCd[i] != null)
					model.setTsTpCd(tsTpCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (dimWdt[i] != null)
					model.setDimWdt(dimWdt[i]);
				if (cmdtHsCd[i] != null)
					model.setCmdtHsCd(cmdtHsCd[i]);
				if (psaBatNo[i] != null)
					model.setPsaBatNo(psaBatNo[i]);
				if (n1stPodCd[i] != null)
					model.setN1stPodCd(n1stPodCd[i]);
				if (ovrBakDimLen[i] != null)
					model.setOvrBakDimLen(ovrBakDimLen[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (cfsTpCd[i] != null)
					model.setCfsTpCd(cfsTpCd[i]);
				if (dimHgt[i] != null)
					model.setDimHgt(dimHgt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cntrTpsz[i] != null)
					model.setCntrTpsz(cntrTpsz[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rcTemp[i] != null)
					model.setRcTemp(rcTemp[i]);
				if (ovrFntDimLen[i] != null)
					model.setOvrFntDimLen(ovrFntDimLen[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (cbmPerHrQty[i] != null)
					model.setCbmPerHrQty(cbmPerHrQty[i]);
				if (psaCreTpCd[i] != null)
					model.setPsaCreTpCd(psaCreTpCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (ovrRtDimWdt[i] != null)
					model.setOvrRtDimWdt(ovrRtDimWdt[i]);
				if (socInd[i] != null)
					model.setSocInd(socInd[i]);
				if (cntrOprCd[i] != null)
					model.setCntrOprCd(cntrOprCd[i]);
				if (rfCntrPreTrdInspTpCd[i] != null)
					model.setRfCntrPreTrdInspTpCd(rfCntrPreTrdInspTpCd[i]);
				if (ibSltOprCd[i] != null)
					model.setIbSltOprCd(ibSltOprCd[i]);
				if (stwgTpCd[i] != null)
					model.setStwgTpCd(stwgTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ovrLfDimWdt[i] != null)
					model.setOvrLfDimWdt(ovrLfDimWdt[i]);
				if (dimLen[i] != null)
					model.setDimLen(dimLen[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (psaVoyDirCd[i] != null)
					model.setPsaVoyDirCd(psaVoyDirCd[i]);
				if (cntrClass[i] != null)
					model.setCntrClass(cntrClass[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (n3rdPodCd[i] != null)
					model.setN3rdPodCd(n3rdPodCd[i]);
				if (cgoDesc[i] != null)
					model.setCgoDesc(cgoDesc[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (dirDeFlg[i] != null)
					model.setDirDeFlg(dirDeFlg[i]);
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
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dptSvcTpCd = this.dptSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDimHgt = this.ovrDimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaVslNm = this.psaVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgOvrSzFlg = this.dchgOvrSzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPodCd = this.n2ndPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSltOprCd = this.obSltOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsTpCd = this.tsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimWdt = this.dimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCd = this.cmdtHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaBatNo = this.psaBatNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPodCd = this.n1stPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrBakDimLen = this.ovrBakDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfsTpCd = this.cfsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimHgt = this.dimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpsz = this.cntrTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcTemp = this.rcTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrFntDimLen = this.ovrFntDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbmPerHrQty = this.cbmPerHrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaCreTpCd = this.psaCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrRtDimWdt = this.ovrRtDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socInd = this.socInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOprCd = this.cntrOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrPreTrdInspTpCd = this.rfCntrPreTrdInspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSltOprCd = this.ibSltOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgTpCd = this.stwgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrLfDimWdt = this.ovrLfDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimLen = this.dimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaVoyDirCd = this.psaVoyDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrClass = this.cntrClass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPodCd = this.n3rdPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc = this.cgoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirDeFlg = this.dirDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
