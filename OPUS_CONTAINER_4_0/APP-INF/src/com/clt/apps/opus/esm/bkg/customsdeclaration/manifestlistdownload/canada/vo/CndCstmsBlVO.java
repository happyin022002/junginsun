/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CndCstmsBlVO.java
 *@FileTitle : CndCstmsBlVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.11
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.05.11 김민정 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김민정
 * @since J2EE 1.5
 * @see ..
 */
public class CndCstmsBlVO extends CstmsBlVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndCstmsBlVO> models = new ArrayList<CndCstmsBlVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String cstmsFileTpCd = null;
	/* Column Info */
	private String inTzYdCntCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String inTzYdSteCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mfStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cstmsMfTpCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inTzYdAddr = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String amsPckTpCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String hblCount = null;
	/* Column Info */
	private String inTzYdCtyNm = null;
	/* Column Info */
	private String cgoWgt = null;
	/* Column Info */
	private String mBlNo = null;
	/* Column Info */
	private String ccnNo = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String trspTpId = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String cstmsTrsmStsCd = null;
	/* Column Info */
	private String inTzYdNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String ibdLocGdsDesc = null;
	/* Column Info */
	private String inTzYdZipId = null;
	/* Column Info */
	private String inTzYdCd1 = null;
	/* Column Info */
	private String inTzYdCd2 = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String hubLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndCstmsBlVO() {}

	public CndCstmsBlVO(String ibflag, String pagerows, String blNo, String cstmsFileTpCd, String mfStsCd, String cstmsMfTpCd, String cstmsTrsmStsCd, String mBlNo, String vvdCd, String porCd, String polCd, String podCd, String vpsEtaDt, String delCd, String pckQty, String amsPckTpCd, String cgoWgt, String wgtUtCd, String hubLocCd, String ibdLocGdsDesc, String bkgNo, String bkgNoSplit, String frtCltFlg, String oblRdemFlg, String trspTpId, String bdrFlg, String fullMtyCd, String hblCount, String ccnNo, String inTzYdCd1, String inTzYdCd2, String inTzYdZipId, String inTzYdNm, String inTzYdAddr, String inTzYdCtyNm, String inTzYdSteCd, String inTzYdCntCd, String diffRmk) {
		this.porCd = porCd;
		this.cstmsFileTpCd = cstmsFileTpCd;
		this.inTzYdCntCd = inTzYdCntCd;
		this.bdrFlg = bdrFlg;
		this.inTzYdSteCd = inTzYdSteCd;
		this.vpsEtaDt = vpsEtaDt;
		this.blNo = blNo;
		this.mfStsCd = mfStsCd;
		this.pagerows = pagerows;
		this.cstmsMfTpCd = cstmsMfTpCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.inTzYdAddr = inTzYdAddr;
		this.frtCltFlg = frtCltFlg;
		this.vvdCd = vvdCd;
		this.amsPckTpCd = amsPckTpCd;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.hblCount = hblCount;
		this.inTzYdCtyNm = inTzYdCtyNm;
		this.cgoWgt = cgoWgt;
		this.mBlNo = mBlNo;
		this.ccnNo = ccnNo;
		this.bkgNoSplit = bkgNoSplit;
		this.delCd = delCd;
		this.trspTpId = trspTpId;
		this.oblRdemFlg = oblRdemFlg;
		this.cstmsTrsmStsCd = cstmsTrsmStsCd;
		this.inTzYdNm = inTzYdNm;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.diffRmk = diffRmk;
		this.ibdLocGdsDesc = ibdLocGdsDesc;
		this.inTzYdZipId = inTzYdZipId;
		this.inTzYdCd1 = inTzYdCd1;
		this.inTzYdCd2 = inTzYdCd2;
		this.fullMtyCd = fullMtyCd;
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cstms_file_tp_cd", getCstmsFileTpCd());
		this.hashColumns.put("in_tz_yd_cnt_cd", getInTzYdCntCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("in_tz_yd_ste_cd", getInTzYdSteCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mf_sts_cd", getMfStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cstms_mf_tp_cd", getCstmsMfTpCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_tz_yd_addr", getInTzYdAddr());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("ams_pck_tp_cd", getAmsPckTpCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("hbl_count", getHblCount());
		this.hashColumns.put("in_tz_yd_cty_nm", getInTzYdCtyNm());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		this.hashColumns.put("m_bl_no", getMBlNo());
		this.hashColumns.put("ccn_no", getCcnNo());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("trsp_tp_id", getTrspTpId());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("cstms_trsm_sts_cd", getCstmsTrsmStsCd());
		this.hashColumns.put("in_tz_yd_nm", getInTzYdNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("ibd_loc_gds_desc", getIbdLocGdsDesc());
		this.hashColumns.put("in_tz_yd_zip_id", getInTzYdZipId());
		this.hashColumns.put("in_tz_yd_cd1", getInTzYdCd1());
		this.hashColumns.put("in_tz_yd_cd2", getInTzYdCd2());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cstms_file_tp_cd", "cstmsFileTpCd");
		this.hashFields.put("in_tz_yd_cnt_cd", "inTzYdCntCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("in_tz_yd_ste_cd", "inTzYdSteCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mf_sts_cd", "mfStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cstms_mf_tp_cd", "cstmsMfTpCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_tz_yd_addr", "inTzYdAddr");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("ams_pck_tp_cd", "amsPckTpCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("hbl_count", "hblCount");
		this.hashFields.put("in_tz_yd_cty_nm", "inTzYdCtyNm");
		this.hashFields.put("cgo_wgt", "cgoWgt");
		this.hashFields.put("m_bl_no", "mBlNo");
		this.hashFields.put("ccn_no", "ccnNo");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("trsp_tp_id", "trspTpId");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("cstms_trsm_sts_cd", "cstmsTrsmStsCd");
		this.hashFields.put("in_tz_yd_nm", "inTzYdNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("ibd_loc_gds_desc", "ibdLocGdsDesc");
		this.hashFields.put("in_tz_yd_zip_id", "inTzYdZipId");
		this.hashFields.put("in_tz_yd_cd1", "inTzYdCd1");
		this.hashFields.put("in_tz_yd_cd2", "inTzYdCd2");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		return this.hashFields;
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
	 * @return cstmsFileTpCd
	 */
	public String getCstmsFileTpCd() {
		return this.cstmsFileTpCd;
	}
	
	/**
	 * Column Info
	 * @return inTzYdCntCd
	 */
	public String getInTzYdCntCd() {
		return this.inTzYdCntCd;
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
	 * @return inTzYdSteCd
	 */
	public String getInTzYdSteCd() {
		return this.inTzYdSteCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return inTzYdAddr
	 */
	public String getInTzYdAddr() {
		return this.inTzYdAddr;
	}
	
	/**
	 * Column Info
	 * @return frtCltFlg
	 */
	public String getFrtCltFlg() {
		return this.frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return amsPckTpCd
	 */
	public String getAmsPckTpCd() {
		return this.amsPckTpCd;
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
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return hblCount
	 */
	public String getHblCount() {
		return this.hblCount;
	}
	
	/**
	 * Column Info
	 * @return inTzYdCtyNm
	 */
	public String getInTzYdCtyNm() {
		return this.inTzYdCtyNm;
	}
	
	/**
	 * Column Info
	 * @return cgoWgt
	 */
	public String getCgoWgt() {
		return this.cgoWgt;
	}
	
	/**
	 * Column Info
	 * @return mBlNo
	 */
	public String getMBlNo() {
		return this.mBlNo;
	}
	
	/**
	 * Column Info
	 * @return ccnNo
	 */
	public String getCcnNo() {
		return this.ccnNo;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
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
	 * @return trspTpId
	 */
	public String getTrspTpId() {
		return this.trspTpId;
	}
	
	/**
	 * Column Info
	 * @return oblRdemFlg
	 */
	public String getOblRdemFlg() {
		return this.oblRdemFlg;
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
	 * @return inTzYdNm
	 */
	public String getInTzYdNm() {
		return this.inTzYdNm;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return ibdLocGdsDesc
	 */
	public String getIbdLocGdsDesc() {
		return this.ibdLocGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return inTzYdZipId
	 */
	public String getInTzYdZipId() {
		return this.inTzYdZipId;
	}
	
	/**
	 * Column Info
	 * @return inTzYdCd1
	 */
	public String getInTzYdCd1() {
		return this.inTzYdCd1;
	}
	
	/**
	 * Column Info
	 * @return inTzYdCd2
	 */
	public String getInTzYdCd2() {
		return this.inTzYdCd2;
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
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
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
	 * @param cstmsFileTpCd
	 */
	public void setCstmsFileTpCd(String cstmsFileTpCd) {
		this.cstmsFileTpCd = cstmsFileTpCd;
	}
	
	/**
	 * Column Info
	 * @param inTzYdCntCd
	 */
	public void setInTzYdCntCd(String inTzYdCntCd) {
		this.inTzYdCntCd = inTzYdCntCd;
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
	 * @param inTzYdSteCd
	 */
	public void setInTzYdSteCd(String inTzYdSteCd) {
		this.inTzYdSteCd = inTzYdSteCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param inTzYdAddr
	 */
	public void setInTzYdAddr(String inTzYdAddr) {
		this.inTzYdAddr = inTzYdAddr;
	}
	
	/**
	 * Column Info
	 * @param frtCltFlg
	 */
	public void setFrtCltFlg(String frtCltFlg) {
		this.frtCltFlg = frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param amsPckTpCd
	 */
	public void setAmsPckTpCd(String amsPckTpCd) {
		this.amsPckTpCd = amsPckTpCd;
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
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param hblCount
	 */
	public void setHblCount(String hblCount) {
		this.hblCount = hblCount;
	}
	
	/**
	 * Column Info
	 * @param inTzYdCtyNm
	 */
	public void setInTzYdCtyNm(String inTzYdCtyNm) {
		this.inTzYdCtyNm = inTzYdCtyNm;
	}
	
	/**
	 * Column Info
	 * @param cgoWgt
	 */
	public void setCgoWgt(String cgoWgt) {
		this.cgoWgt = cgoWgt;
	}
	
	/**
	 * Column Info
	 * @param mBlNo
	 */
	public void setMBlNo(String mBlNo) {
		this.mBlNo = mBlNo;
	}
	
	/**
	 * Column Info
	 * @param ccnNo
	 */
	public void setCcnNo(String ccnNo) {
		this.ccnNo = ccnNo;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
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
	 * @param trspTpId
	 */
	public void setTrspTpId(String trspTpId) {
		this.trspTpId = trspTpId;
	}
	
	/**
	 * Column Info
	 * @param oblRdemFlg
	 */
	public void setOblRdemFlg(String oblRdemFlg) {
		this.oblRdemFlg = oblRdemFlg;
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
	 * @param inTzYdNm
	 */
	public void setInTzYdNm(String inTzYdNm) {
		this.inTzYdNm = inTzYdNm;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param ibdLocGdsDesc
	 */
	public void setIbdLocGdsDesc(String ibdLocGdsDesc) {
		this.ibdLocGdsDesc = ibdLocGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param inTzYdZipId
	 */
	public void setInTzYdZipId(String inTzYdZipId) {
		this.inTzYdZipId = inTzYdZipId;
	}
	
	/**
	 * Column Info
	 * @param inTzYdCd1
	 */
	public void setInTzYdCd1(String inTzYdCd1) {
		this.inTzYdCd1 = inTzYdCd1;
	}
	
	/**
	 * Column Info
	 * @param inTzYdCd2
	 */
	public void setInTzYdCd2(String inTzYdCd2) {
		this.inTzYdCd2 = inTzYdCd2;
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
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCstmsFileTpCd(JSPUtil.getParameter(request, "cstms_file_tp_cd", ""));
		setInTzYdCntCd(JSPUtil.getParameter(request, "in_tz_yd_cnt_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, "bdr_flg", ""));
		setInTzYdSteCd(JSPUtil.getParameter(request, "in_tz_yd_ste_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setMfStsCd(JSPUtil.getParameter(request, "mf_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCstmsMfTpCd(JSPUtil.getParameter(request, "cstms_mf_tp_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInTzYdAddr(JSPUtil.getParameter(request, "in_tz_yd_addr", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, "frt_clt_flg", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setAmsPckTpCd(JSPUtil.getParameter(request, "ams_pck_tp_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setHblCount(JSPUtil.getParameter(request, "hbl_count", ""));
		setInTzYdCtyNm(JSPUtil.getParameter(request, "in_tz_yd_cty_nm", ""));
		setCgoWgt(JSPUtil.getParameter(request, "cgo_wgt", ""));
		setMBlNo(JSPUtil.getParameter(request, "m_bl_no", ""));
		setCcnNo(JSPUtil.getParameter(request, "ccn_no", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setTrspTpId(JSPUtil.getParameter(request, "trsp_tp_id", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, "obl_rdem_flg", ""));
		setCstmsTrsmStsCd(JSPUtil.getParameter(request, "cstms_trsm_sts_cd", ""));
		setInTzYdNm(JSPUtil.getParameter(request, "in_tz_yd_nm", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setIbdLocGdsDesc(JSPUtil.getParameter(request, "ibd_loc_gds_desc", ""));
		setInTzYdZipId(JSPUtil.getParameter(request, "in_tz_yd_zip_id", ""));
		setInTzYdCd1(JSPUtil.getParameter(request, "in_tz_yd_cd1", ""));
		setInTzYdCd2(JSPUtil.getParameter(request, "in_tz_yd_cd2", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setHubLocCd(JSPUtil.getParameter(request, "hub_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsBlVO[]
	 */
	public CndCstmsBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsBlVO[]
	 */
	public CndCstmsBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd".trim(), length));
			String[] cstmsFileTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_file_tp_cd".trim(), length));
			String[] inTzYdCntCd = (JSPUtil.getParameter(request, prefix	+ "in_tz_yd_cnt_cd".trim(), length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg".trim(), length));
			String[] inTzYdSteCd = (JSPUtil.getParameter(request, prefix	+ "in_tz_yd_ste_cd".trim(), length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] mfStsCd = (JSPUtil.getParameter(request, prefix	+ "mf_sts_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] cstmsMfTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_mf_tp_cd".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] inTzYdAddr = (JSPUtil.getParameter(request, prefix	+ "in_tz_yd_addr".trim(), length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg".trim(), length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd".trim(), length));
			String[] amsPckTpCd = (JSPUtil.getParameter(request, prefix	+ "ams_pck_tp_cd".trim(), length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd".trim(), length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty".trim(), length));
			String[] hblCount = (JSPUtil.getParameter(request, prefix	+ "hbl_count".trim(), length));
			String[] inTzYdCtyNm = (JSPUtil.getParameter(request, prefix	+ "in_tz_yd_cty_nm".trim(), length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt".trim(), length));
			String[] mBlNo = (JSPUtil.getParameter(request, prefix	+ "m_bl_no".trim(), length));
			String[] ccnNo = (JSPUtil.getParameter(request, prefix	+ "ccn_no".trim(), length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split".trim(), length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd".trim(), length));
			String[] trspTpId = (JSPUtil.getParameter(request, prefix	+ "trsp_tp_id".trim(), length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg".trim(), length));
			String[] cstmsTrsmStsCd = (JSPUtil.getParameter(request, prefix	+ "cstms_trsm_sts_cd".trim(), length));
			String[] inTzYdNm = (JSPUtil.getParameter(request, prefix	+ "in_tz_yd_nm".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk".trim(), length));
			String[] ibdLocGdsDesc = (JSPUtil.getParameter(request, prefix	+ "ibd_loc_gds_desc".trim(), length));
			String[] inTzYdZipId = (JSPUtil.getParameter(request, prefix	+ "in_tz_yd_zip_id".trim(), length));
			String[] inTzYdCd1 = (JSPUtil.getParameter(request, prefix	+ "in_tz_yd_cd1".trim(), length));
			String[] inTzYdCd2 = (JSPUtil.getParameter(request, prefix	+ "in_tz_yd_cd2".trim(), length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd".trim(), length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsBlVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (cstmsFileTpCd[i] != null)
					model.setCstmsFileTpCd(cstmsFileTpCd[i]);
				if (inTzYdCntCd[i] != null)
					model.setInTzYdCntCd(inTzYdCntCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (inTzYdSteCd[i] != null)
					model.setInTzYdSteCd(inTzYdSteCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mfStsCd[i] != null)
					model.setMfStsCd(mfStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cstmsMfTpCd[i] != null)
					model.setCstmsMfTpCd(cstmsMfTpCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inTzYdAddr[i] != null)
					model.setInTzYdAddr(inTzYdAddr[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (amsPckTpCd[i] != null)
					model.setAmsPckTpCd(amsPckTpCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (hblCount[i] != null)
					model.setHblCount(hblCount[i]);
				if (inTzYdCtyNm[i] != null)
					model.setInTzYdCtyNm(inTzYdCtyNm[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				if (mBlNo[i] != null)
					model.setMBlNo(mBlNo[i]);
				if (ccnNo[i] != null)
					model.setCcnNo(ccnNo[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (trspTpId[i] != null)
					model.setTrspTpId(trspTpId[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (cstmsTrsmStsCd[i] != null)
					model.setCstmsTrsmStsCd(cstmsTrsmStsCd[i]);
				if (inTzYdNm[i] != null)
					model.setInTzYdNm(inTzYdNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (ibdLocGdsDesc[i] != null)
					model.setIbdLocGdsDesc(ibdLocGdsDesc[i]);
				if (inTzYdZipId[i] != null)
					model.setInTzYdZipId(inTzYdZipId[i]);
				if (inTzYdCd1[i] != null)
					model.setInTzYdCd1(inTzYdCd1[i]);
				if (inTzYdCd2[i] != null)
					model.setInTzYdCd2(inTzYdCd2[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsBlVO[]
	 */
	public CndCstmsBlVO[] getCndCstmsBlVOs(){
		CndCstmsBlVO[] vos = (CndCstmsBlVO[])models.toArray(new CndCstmsBlVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsFileTpCd = this.cstmsFileTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTzYdCntCd = this.inTzYdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTzYdSteCd = this.inTzYdSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfStsCd = this.mfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsMfTpCd = this.cstmsMfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTzYdAddr = this.inTzYdAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amsPckTpCd = this.amsPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblCount = this.hblCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTzYdCtyNm = this.inTzYdCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mBlNo = this.mBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccnNo = this.ccnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspTpId = this.trspTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsTrsmStsCd = this.cstmsTrsmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTzYdNm = this.inTzYdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdLocGdsDesc = this.ibdLocGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTzYdZipId = this.inTzYdZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTzYdCd1 = this.inTzYdCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTzYdCd2 = this.inTzYdCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}