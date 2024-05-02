/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDetailVO.java
*@FileTitle : UsaManifestListDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.07 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaManifestListDetailVO extends ManifestListDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaManifestListDetailVO> models = new ArrayList<UsaManifestListDetailVO>();
	
	/* Column Info */
	private String actFileSkdDirCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String ediFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String vPol = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mfStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cstmsMfTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String blNos = null;
	/* Column Info */
	private String vPod = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String caFlg = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String shprAd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String errCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String filer = null;
	/* Column Info */
	private String blType = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cstmsTrsmStsCd = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String cntrMfNo = null;
	/* Column Info */
	private String ntfyAd = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String caIssDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cneeAd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String empFlg = null;
	/* Column Info */
	private String caNo = null;
	/* Column Info */
	private String ediSndDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaManifestListDetailVO() {}

	public UsaManifestListDetailVO(String ibflag, String pagerows, String blNo, String blNos, String cntrMfNo, String filer, String bkgCgoTpCd, String empFlg, String ifFlg, String actFileSkdDirCd, String bkgNo, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd, String delCd, String podNodCd, String delNodCd, String pckQty, String pckTpCd, String actWgt, String wgtUtCd, String shprNm, String shprAd, String cneeNm, String cneeAd, String ntfyNm, String ntfyAd, String bdrFlg, String caNo, String ediFlg, String ediSndDt, String bkgStsCd, String blType, String errCd, String vPol, String mfStsCd, String cstmsMfTpCd, String vPod, String caFlg, String cstmsTrsmStsCd, String caIssDt) {
		this.actFileSkdDirCd = actFileSkdDirCd;
		this.vslCd = vslCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.ediFlg = ediFlg;
		this.bkgStsCd = bkgStsCd;
		this.bdrFlg = bdrFlg;
		this.vPol = vPol;
		this.blNo = blNo;
		this.mfStsCd = mfStsCd;
		this.pagerows = pagerows;
		this.cstmsMfTpCd = cstmsMfTpCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.blNos = blNos;
		this.vPod = vPod;
		this.wgtUtCd = wgtUtCd;
		this.caFlg = caFlg;
		this.pckQty = pckQty;
		this.shprAd = shprAd;
		this.delNodCd = delNodCd;
		this.shprNm = shprNm;
		this.errCd = errCd;
		this.pckTpCd = pckTpCd;
		this.filer = filer;
		this.blType = blType;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.cstmsTrsmStsCd = cstmsTrsmStsCd;
		this.ifFlg = ifFlg;
		this.cntrMfNo = cntrMfNo;
		this.ntfyAd = ntfyAd;
		this.ntfyNm = ntfyNm;
		this.skdDirCd = skdDirCd;
		this.actWgt = actWgt;
		this.caIssDt = caIssDt;
		this.podCd = podCd;
		this.cneeAd = cneeAd;
		this.cneeNm = cneeNm;
		this.bkgNo = bkgNo;
		this.podNodCd = podNodCd;
		this.empFlg = empFlg;
		this.caNo = caNo;
		this.ediSndDt = ediSndDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_file_skd_dir_cd", getActFileSkdDirCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("edi_flg", getEdiFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("v_pol", getVPol());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mf_sts_cd", getMfStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cstms_mf_tp_cd", getCstmsMfTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bl_nos", getBlNos());
		this.hashColumns.put("v_pod", getVPod());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("ca_flg", getCaFlg());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("shpr_ad", getShprAd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("err_cd", getErrCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("filer", getFiler());
		this.hashColumns.put("bl_type", getBlType());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cstms_trsm_sts_cd", getCstmsTrsmStsCd());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("cntr_mf_no", getCntrMfNo());
		this.hashColumns.put("ntfy_ad", getNtfyAd());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("ca_iss_dt", getCaIssDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cnee_ad", getCneeAd());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("emp_flg", getEmpFlg());
		this.hashColumns.put("ca_no", getCaNo());
		this.hashColumns.put("edi_snd_dt", getEdiSndDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_file_skd_dir_cd", "actFileSkdDirCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("edi_flg", "ediFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("v_pol", "vPol");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mf_sts_cd", "mfStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cstms_mf_tp_cd", "cstmsMfTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bl_nos", "blNos");
		this.hashFields.put("v_pod", "vPod");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("ca_flg", "caFlg");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("shpr_ad", "shprAd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("err_cd", "errCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("filer", "filer");
		this.hashFields.put("bl_type", "blType");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cstms_trsm_sts_cd", "cstmsTrsmStsCd");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("cntr_mf_no", "cntrMfNo");
		this.hashFields.put("ntfy_ad", "ntfyAd");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("ca_iss_dt", "caIssDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cnee_ad", "cneeAd");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("emp_flg", "empFlg");
		this.hashFields.put("ca_no", "caNo");
		this.hashFields.put("edi_snd_dt", "ediSndDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return actFileSkdDirCd
	 */
	public String getActFileSkdDirCd() {
		return this.actFileSkdDirCd;
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
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return ediFlg
	 */
	public String getEdiFlg() {
		return this.ediFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return vPol
	 */
	public String getVPol() {
		return this.vPol;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return mfStsCd
	 */
	public String getMfStsCd() {
		return this.mfStsCd;
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
	 * @return cstmsMfTpCd
	 */
	public String getCstmsMfTpCd() {
		return this.cstmsMfTpCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return blNos
	 */
	public String getBlNos() {
		return this.blNos;
	}
	
	/**
	 * Column Info
	 * @return vPod
	 */
	public String getVPod() {
		return this.vPod;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return caFlg
	 */
	public String getCaFlg() {
		return this.caFlg;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return shprAd
	 */
	public String getShprAd() {
		return this.shprAd;
	}
	
	/**
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return errCd
	 */
	public String getErrCd() {
		return this.errCd;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return filer
	 */
	public String getFiler() {
		return this.filer;
	}
	
	/**
	 * Column Info
	 * @return blType
	 */
	public String getBlType() {
		return this.blType;
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
	 * @return cstmsTrsmStsCd
	 */
	public String getCstmsTrsmStsCd() {
		return this.cstmsTrsmStsCd;
	}
	
	/**
	 * Column Info
	 * @return ifFlg
	 */
	public String getIfFlg() {
		return this.ifFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrMfNo
	 */
	public String getCntrMfNo() {
		return this.cntrMfNo;
	}
	
	/**
	 * Column Info
	 * @return ntfyAd
	 */
	public String getNtfyAd() {
		return this.ntfyAd;
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
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}
	
	/**
	 * Column Info
	 * @return caIssDt
	 */
	public String getCaIssDt() {
		return this.caIssDt;
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
	 * @return cneeAd
	 */
	public String getCneeAd() {
		return this.cneeAd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
	}
	
	/**
	 * Column Info
	 * @return empFlg
	 */
	public String getEmpFlg() {
		return this.empFlg;
	}
	
	/**
	 * Column Info
	 * @return caNo
	 */
	public String getCaNo() {
		return this.caNo;
	}
	
	/**
	 * Column Info
	 * @return ediSndDt
	 */
	public String getEdiSndDt() {
		return this.ediSndDt;
	}
	

	/**
	 * Column Info
	 * @param actFileSkdDirCd
	 */
	public void setActFileSkdDirCd(String actFileSkdDirCd) {
		this.actFileSkdDirCd = actFileSkdDirCd;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param ediFlg
	 */
	public void setEdiFlg(String ediFlg) {
		this.ediFlg = ediFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param vPol
	 */
	public void setVPol(String vPol) {
		this.vPol = vPol;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param mfStsCd
	 */
	public void setMfStsCd(String mfStsCd) {
		this.mfStsCd = mfStsCd;
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
	 * @param cstmsMfTpCd
	 */
	public void setCstmsMfTpCd(String cstmsMfTpCd) {
		this.cstmsMfTpCd = cstmsMfTpCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param blNos
	 */
	public void setBlNos(String blNos) {
		this.blNos = blNos;
	}
	
	/**
	 * Column Info
	 * @param vPod
	 */
	public void setVPod(String vPod) {
		this.vPod = vPod;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param caFlg
	 */
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param shprAd
	 */
	public void setShprAd(String shprAd) {
		this.shprAd = shprAd;
	}
	
	/**
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param errCd
	 */
	public void setErrCd(String errCd) {
		this.errCd = errCd;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param filer
	 */
	public void setFiler(String filer) {
		this.filer = filer;
	}
	
	/**
	 * Column Info
	 * @param blType
	 */
	public void setBlType(String blType) {
		this.blType = blType;
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
	 * @param cstmsTrsmStsCd
	 */
	public void setCstmsTrsmStsCd(String cstmsTrsmStsCd) {
		this.cstmsTrsmStsCd = cstmsTrsmStsCd;
	}
	
	/**
	 * Column Info
	 * @param ifFlg
	 */
	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrMfNo
	 */
	public void setCntrMfNo(String cntrMfNo) {
		this.cntrMfNo = cntrMfNo;
	}
	
	/**
	 * Column Info
	 * @param ntfyAd
	 */
	public void setNtfyAd(String ntfyAd) {
		this.ntfyAd = ntfyAd;
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
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}
	
	/**
	 * Column Info
	 * @param caIssDt
	 */
	public void setCaIssDt(String caIssDt) {
		this.caIssDt = caIssDt;
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
	 * @param cneeAd
	 */
	public void setCneeAd(String cneeAd) {
		this.cneeAd = cneeAd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}
	
	/**
	 * Column Info
	 * @param empFlg
	 */
	public void setEmpFlg(String empFlg) {
		this.empFlg = empFlg;
	}
	
	/**
	 * Column Info
	 * @param caNo
	 */
	public void setCaNo(String caNo) {
		this.caNo = caNo;
	}
	
	/**
	 * Column Info
	 * @param ediSndDt
	 */
	public void setEdiSndDt(String ediSndDt) {
		this.ediSndDt = ediSndDt;
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
		setActFileSkdDirCd(JSPUtil.getParameter(request, prefix + "act_file_skd_dir_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setEdiFlg(JSPUtil.getParameter(request, prefix + "edi_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setVPol(JSPUtil.getParameter(request, prefix + "v_pol", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setMfStsCd(JSPUtil.getParameter(request, prefix + "mf_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCstmsMfTpCd(JSPUtil.getParameter(request, prefix + "cstms_mf_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBlNos(JSPUtil.getParameter(request, prefix + "bl_nos", ""));
		setVPod(JSPUtil.getParameter(request, prefix + "v_pod", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setCaFlg(JSPUtil.getParameter(request, prefix + "ca_flg", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setShprAd(JSPUtil.getParameter(request, prefix + "shpr_ad", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setErrCd(JSPUtil.getParameter(request, prefix + "err_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setFiler(JSPUtil.getParameter(request, prefix + "filer", ""));
		setBlType(JSPUtil.getParameter(request, prefix + "bl_type", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCstmsTrsmStsCd(JSPUtil.getParameter(request, prefix + "cstms_trsm_sts_cd", ""));
		setIfFlg(JSPUtil.getParameter(request, prefix + "if_flg", ""));
		setCntrMfNo(JSPUtil.getParameter(request, prefix + "cntr_mf_no", ""));
		setNtfyAd(JSPUtil.getParameter(request, prefix + "ntfy_ad", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setCaIssDt(JSPUtil.getParameter(request, prefix + "ca_iss_dt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCneeAd(JSPUtil.getParameter(request, prefix + "cnee_ad", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setEmpFlg(JSPUtil.getParameter(request, prefix + "emp_flg", ""));
		setCaNo(JSPUtil.getParameter(request, prefix + "ca_no", ""));
		setEdiSndDt(JSPUtil.getParameter(request, prefix + "edi_snd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaManifestListDetailVO[]
	 */
	public UsaManifestListDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaManifestListDetailVO[]
	 */
	public UsaManifestListDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaManifestListDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actFileSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "act_file_skd_dir_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] ediFlg = (JSPUtil.getParameter(request, prefix	+ "edi_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] vPol = (JSPUtil.getParameter(request, prefix	+ "v_pol", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mfStsCd = (JSPUtil.getParameter(request, prefix	+ "mf_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cstmsMfTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_mf_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] blNos = (JSPUtil.getParameter(request, prefix	+ "bl_nos", length));
			String[] vPod = (JSPUtil.getParameter(request, prefix	+ "v_pod", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] shprAd = (JSPUtil.getParameter(request, prefix	+ "shpr_ad", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] errCd = (JSPUtil.getParameter(request, prefix	+ "err_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] filer = (JSPUtil.getParameter(request, prefix	+ "filer", length));
			String[] blType = (JSPUtil.getParameter(request, prefix	+ "bl_type", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cstmsTrsmStsCd = (JSPUtil.getParameter(request, prefix	+ "cstms_trsm_sts_cd", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] cntrMfNo = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_no", length));
			String[] ntfyAd = (JSPUtil.getParameter(request, prefix	+ "ntfy_ad", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] caIssDt = (JSPUtil.getParameter(request, prefix	+ "ca_iss_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cneeAd = (JSPUtil.getParameter(request, prefix	+ "cnee_ad", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] empFlg = (JSPUtil.getParameter(request, prefix	+ "emp_flg", length));
			String[] caNo = (JSPUtil.getParameter(request, prefix	+ "ca_no", length));
			String[] ediSndDt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaManifestListDetailVO();
				if (actFileSkdDirCd[i] != null)
					model.setActFileSkdDirCd(actFileSkdDirCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (ediFlg[i] != null)
					model.setEdiFlg(ediFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (vPol[i] != null)
					model.setVPol(vPol[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mfStsCd[i] != null)
					model.setMfStsCd(mfStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cstmsMfTpCd[i] != null)
					model.setCstmsMfTpCd(cstmsMfTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (blNos[i] != null)
					model.setBlNos(blNos[i]);
				if (vPod[i] != null)
					model.setVPod(vPod[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (shprAd[i] != null)
					model.setShprAd(shprAd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (errCd[i] != null)
					model.setErrCd(errCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (filer[i] != null)
					model.setFiler(filer[i]);
				if (blType[i] != null)
					model.setBlType(blType[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cstmsTrsmStsCd[i] != null)
					model.setCstmsTrsmStsCd(cstmsTrsmStsCd[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (cntrMfNo[i] != null)
					model.setCntrMfNo(cntrMfNo[i]);
				if (ntfyAd[i] != null)
					model.setNtfyAd(ntfyAd[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (caIssDt[i] != null)
					model.setCaIssDt(caIssDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cneeAd[i] != null)
					model.setCneeAd(cneeAd[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (empFlg[i] != null)
					model.setEmpFlg(empFlg[i]);
				if (caNo[i] != null)
					model.setCaNo(caNo[i]);
				if (ediSndDt[i] != null)
					model.setEdiSndDt(ediSndDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaManifestListDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaManifestListDetailVO[]
	 */
	public UsaManifestListDetailVO[] getUsaManifestListDetailVOs(){
		UsaManifestListDetailVO[] vos = (UsaManifestListDetailVO[])models.toArray(new UsaManifestListDetailVO[models.size()]);
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
		this.actFileSkdDirCd = this.actFileSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediFlg = this.ediFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vPol = this.vPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfStsCd = this.mfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsMfTpCd = this.cstmsMfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNos = this.blNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vPod = this.vPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAd = this.shprAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCd = this.errCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filer = this.filer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blType = this.blType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsTrsmStsCd = this.cstmsTrsmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfNo = this.cntrMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAd = this.ntfyAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caIssDt = this.caIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAd = this.cneeAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empFlg = this.empFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caNo = this.caNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndDt = this.ediSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	// 다운로드 상단 그리드
	private UsaDownloadSummaryVO[] usaDownloadSummaryVOs = null;
	
	public UsaDownloadSummaryVO[] getUsaDownloadSummaryVOs() {
		return usaDownloadSummaryVOs;
	}

	public void setUsaDownloadSummaryVOs(
			UsaDownloadSummaryVO[] usaDownloadSummaryVOs) {
		this.usaDownloadSummaryVOs = usaDownloadSummaryVOs;
	}
}
