/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCllModifyVO.java
*@FileTitle : KorCllModifyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier :
*@LastVersion : 1.0
* 2009.08.14
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorCllModifyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorCllModifyVO> models = new ArrayList<KorCllModifyVO>();

	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cntrListNo = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Column Info */
	private String minTemp = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String blWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tsSkdDirCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String aPodCd = null;
	/* Column Info */
	private String krTmlPrctId = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String mrnPolutFlg = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String inKtmlCd = null;
	/* Column Info */
	private String mtyBkgCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String inCllType = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String xterRmk = null;
	/* Column Info */
	private String cllRmk2 = null;
	/* Column Info */
	private String cllRmk1 = null;
	/* Column Info */
	private String cntrVentCd = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String ovrWgtQty = null;
	/* Column Info */
	private String tsSkdVoyNo = null;
	/* Column Info */
	private String tsFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ovrHgtQty = null;
	/* Column Info */
	private String ovrLenQty = null;
	/* Column Info */
	private String tsVvdCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String inPolYdCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String maxTemp = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String cdoTemp = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String tsVslCd = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String tVslCd = null;
	/* Column Info */
	private String inBlCllData = null;
	/* Column Info */
	private String selectRow = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String vgmWgtUtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorCllModifyVO() {}

	public KorCllModifyVO(String ibflag, String pagerows, String inVvdCd, String inPolCd, String inPolYdCd, String inKtmlCd, String inCllType, String cntrListNo, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String bkgPolCd, String cntrNo, String blNo, String bkgNo, String cntrTpszCd, String mtyBkgCd, String sealNo, String blWgt, String wgtUtCd, String rcvTermCd, String deTermCd, String tsFlg, String imdgClssCd, String imdgUnNo, String cdoTemp, String cntrVentCd, String cllRmk1, String cllRmk2, String podCd, String blckStwgCd, String tsVslCd, String tsSkdVoyNo, String tsSkdDirCd, String tsVvdCd, String ovrLenQty, String ovrWgtQty, String ovrHgtQty, String minTemp, String maxTemp, String krTmlPrctId, String podYdCd, String polYdCd, String mrnPolutFlg, String stwgCd, String xterRmk, String aPodCd, String tVslCd, String creUsrId, String inBlCllData, String selectRow, String vgmWgt, String vgmWgtUtCd) {
		this.vslCd = vslCd;
		this.cntrListNo = cntrListNo;
		this.blckStwgCd = blckStwgCd;
		this.minTemp = minTemp;
		this.blNo = blNo;
		this.blWgt = blWgt;
		this.pagerows = pagerows;
		this.tsSkdDirCd = tsSkdDirCd;
		this.polCd = polCd;
		this.aPodCd = aPodCd;
		this.krTmlPrctId = krTmlPrctId;
		this.wgtUtCd = wgtUtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.stwgCd = stwgCd;
		this.mrnPolutFlg = mrnPolutFlg;
		this.imdgUnNo = imdgUnNo;
		this.inKtmlCd = inKtmlCd;
		this.mtyBkgCd = mtyBkgCd;
		this.skdVoyNo = skdVoyNo;
		this.inCllType = inCllType;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.inVvdCd = inVvdCd;
		this.xterRmk = xterRmk;
		this.cllRmk2 = cllRmk2;
		this.cllRmk1 = cllRmk1;
		this.cntrVentCd = cntrVentCd;
		this.imdgClssCd = imdgClssCd;
		this.ovrWgtQty = ovrWgtQty;
		this.tsSkdVoyNo = tsSkdVoyNo;
		this.tsFlg = tsFlg;
		this.ibflag = ibflag;
		this.ovrHgtQty = ovrHgtQty;
		this.ovrLenQty = ovrLenQty;
		this.tsVvdCd = tsVvdCd;
		this.rcvTermCd = rcvTermCd;
		this.podYdCd = podYdCd;
		this.sealNo = sealNo;
		this.bkgPolCd = bkgPolCd;
		this.inPolYdCd = inPolYdCd;
		this.skdDirCd = skdDirCd;
		this.maxTemp = maxTemp;
		this.deTermCd = deTermCd;
		this.cdoTemp = cdoTemp;
		this.cntrNo = cntrNo;
		this.tsVslCd = tsVslCd;
		this.polYdCd = polYdCd;
		this.inPolCd = inPolCd;
		this.tVslCd = tVslCd;
		this.inBlCllData = inBlCllData;
		this.selectRow = selectRow;
		this.vgmWgt = vgmWgt;
		this.vgmWgtUtCd = vgmWgtUtCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cntr_list_no", getCntrListNo());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("min_temp", getMinTemp());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_wgt", getBlWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ts_skd_dir_cd", getTsSkdDirCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("a_pod_cd", getAPodCd());
		this.hashColumns.put("kr_tml_prct_id", getKrTmlPrctId());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("in_ktml_cd", getInKtmlCd());
		this.hashColumns.put("mty_bkg_cd", getMtyBkgCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("in_cll_type", getInCllType());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("cll_rmk2", getCllRmk2());
		this.hashColumns.put("cll_rmk1", getCllRmk1());
		this.hashColumns.put("cntr_vent_cd", getCntrVentCd());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("ovr_wgt_qty", getOvrWgtQty());
		this.hashColumns.put("ts_skd_voy_no", getTsSkdVoyNo());
		this.hashColumns.put("ts_flg", getTsFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ovr_hgt_qty", getOvrHgtQty());
		this.hashColumns.put("ovr_len_qty", getOvrLenQty());
		this.hashColumns.put("ts_vvd_cd", getTsVvdCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("in_pol_yd_cd", getInPolYdCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("max_temp", getMaxTemp());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("cdo_temp", getCdoTemp());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ts_vsl_cd", getTsVslCd());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("t_vsl_cd", getTVslCd());
		this.hashColumns.put("in_bl_cll_data", getInBlCllData());
		this.hashColumns.put("select_row", getSelectRow());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cntr_list_no", "cntrListNo");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("min_temp", "minTemp");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_wgt", "blWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ts_skd_dir_cd", "tsSkdDirCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("a_pod_cd", "aPodCd");
		this.hashFields.put("kr_tml_prct_id", "krTmlPrctId");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("in_ktml_cd", "inKtmlCd");
		this.hashFields.put("mty_bkg_cd", "mtyBkgCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("in_cll_type", "inCllType");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("cll_rmk2", "cllRmk2");
		this.hashFields.put("cll_rmk1", "cllRmk1");
		this.hashFields.put("cntr_vent_cd", "cntrVentCd");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("ovr_wgt_qty", "ovrWgtQty");
		this.hashFields.put("ts_skd_voy_no", "tsSkdVoyNo");
		this.hashFields.put("ts_flg", "tsFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ovr_hgt_qty", "ovrHgtQty");
		this.hashFields.put("ovr_len_qty", "ovrLenQty");
		this.hashFields.put("ts_vvd_cd", "tsVvdCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("in_pol_yd_cd", "inPolYdCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("max_temp", "maxTemp");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cdo_temp", "cdoTemp");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ts_vsl_cd", "tsVslCd");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("t_vsl_cd", "tVslCd");
		this.hashFields.put("in_bl_cll_data", "inBlCllData");
		this.hashFields.put("select_row", "selectRow");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
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
	 * @return cntrListNo
	 */
	public String getCntrListNo() {
		return this.cntrListNo;
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
	 * @return minTemp
	 */
	public String getMinTemp() {
		return this.minTemp;
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
	 * @return blWgt
	 */
	public String getBlWgt() {
		return this.blWgt;
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
	 * @return tsSkdDirCd
	 */
	public String getTsSkdDirCd() {
		return this.tsSkdDirCd;
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
	 * @return aPodCd
	 */
	public String getAPodCd() {
		return this.aPodCd;
	}

	/**
	 * Column Info
	 * @return krTmlPrctId
	 */
	public String getKrTmlPrctId() {
		return this.krTmlPrctId;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	/**
	 * Column Info
	 * @return stwgCd
	 */
	public String getStwgCd() {
		return this.stwgCd;
	}

	/**
	 * Column Info
	 * @return mrnPolutFlg
	 */
	public String getMrnPolutFlg() {
		return this.mrnPolutFlg;
	}

	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}

	/**
	 * Column Info
	 * @return inKtmlCd
	 */
	public String getInKtmlCd() {
		return this.inKtmlCd;
	}

	/**
	 * Column Info
	 * @return mtyBkgCd
	 */
	public String getMtyBkgCd() {
		return this.mtyBkgCd;
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
	 * @return inCllType
	 */
	public String getInCllType() {
		return this.inCllType;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}

	/**
	 * Column Info
	 * @return xterRmk
	 */
	public String getXterRmk() {
		return this.xterRmk;
	}

	/**
	 * Column Info
	 * @return cllRmk2
	 */
	public String getCllRmk2() {
		return this.cllRmk2;
	}

	/**
	 * Column Info
	 * @return cllRmk1
	 */
	public String getCllRmk1() {
		return this.cllRmk1;
	}

	/**
	 * Column Info
	 * @return cntrVentCd
	 */
	public String getCntrVentCd() {
		return this.cntrVentCd;
	}

	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}

	/**
	 * Column Info
	 * @return ovrWgtQty
	 */
	public String getOvrWgtQty() {
		return this.ovrWgtQty;
	}

	/**
	 * Column Info
	 * @return tsSkdVoyNo
	 */
	public String getTsSkdVoyNo() {
		return this.tsSkdVoyNo;
	}

	/**
	 * Column Info
	 * @return tsFlg
	 */
	public String getTsFlg() {
		return this.tsFlg;
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
	 * @return ovrHgtQty
	 */
	public String getOvrHgtQty() {
		return this.ovrHgtQty;
	}

	/**
	 * Column Info
	 * @return ovrLenQty
	 */
	public String getOvrLenQty() {
		return this.ovrLenQty;
	}

	/**
	 * Column Info
	 * @return tsVvdCd
	 */
	public String getTsVvdCd() {
		return this.tsVvdCd;
	}

	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}

	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}

	/**
	 * Column Info
	 * @return sealNo
	 */
	public String getSealNo() {
		return this.sealNo;
	}

	/**
	 * Column Info
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
	}

	/**
	 * Column Info
	 * @return inPolYdCd
	 */
	public String getInPolYdCd() {
		return this.inPolYdCd;
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
	 * @return maxTemp
	 */
	public String getMaxTemp() {
		return this.maxTemp;
	}

	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}

	/**
	 * Column Info
	 * @return cdoTemp
	 */
	public String getCdoTemp() {
		return this.cdoTemp;
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
	 * @return tsVslCd
	 */
	public String getTsVslCd() {
		return this.tsVslCd;
	}

	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}

	/**
	 * Column Info
	 * @return inPolCd
	 */
	public String getInPolCd() {
		return this.inPolCd;
	}

	/**
	 * Column Info
	 * @return tVslCd
	 */
	public String getTVslCd() {
		return this.tVslCd;
	}
	
	/**
	 * Column Info
	 * @return inBlCllData
	 */
	public String getInBlCllData() {
		return this.inBlCllData;
	}
	
	/**
	 * Column Info
	 * @return selectRow
	 */
	public String getSelectRow() {
		return this.selectRow;
	}
	
	/**
	 * Column Info
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUtCd
	 */
	public String getVgmWgtUtCd() {
		return this.vgmWgtUtCd;
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
	 * @param cntrListNo
	 */
	public void setCntrListNo(String cntrListNo) {
		this.cntrListNo = cntrListNo;
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
	 * @param minTemp
	 */
	public void setMinTemp(String minTemp) {
		this.minTemp = minTemp;
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
	 * @param blWgt
	 */
	public void setBlWgt(String blWgt) {
		this.blWgt = blWgt;
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
	 * @param tsSkdDirCd
	 */
	public void setTsSkdDirCd(String tsSkdDirCd) {
		this.tsSkdDirCd = tsSkdDirCd;
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
	 * @param aPodCd
	 */
	public void setAPodCd(String aPodCd) {
		this.aPodCd = aPodCd;
	}

	/**
	 * Column Info
	 * @param krTmlPrctId
	 */
	public void setKrTmlPrctId(String krTmlPrctId) {
		this.krTmlPrctId = krTmlPrctId;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * Column Info
	 * @param stwgCd
	 */
	public void setStwgCd(String stwgCd) {
		this.stwgCd = stwgCd;
	}

	/**
	 * Column Info
	 * @param mrnPolutFlg
	 */
	public void setMrnPolutFlg(String mrnPolutFlg) {
		this.mrnPolutFlg = mrnPolutFlg;
	}

	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}

	/**
	 * Column Info
	 * @param inKtmlCd
	 */
	public void setInKtmlCd(String inKtmlCd) {
		this.inKtmlCd = inKtmlCd;
	}

	/**
	 * Column Info
	 * @param mtyBkgCd
	 */
	public void setMtyBkgCd(String mtyBkgCd) {
		this.mtyBkgCd = mtyBkgCd;
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
	 * @param inCllType
	 */
	public void setInCllType(String inCllType) {
		this.inCllType = inCllType;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}

	/**
	 * Column Info
	 * @param xterRmk
	 */
	public void setXterRmk(String xterRmk) {
		this.xterRmk = xterRmk;
	}

	/**
	 * Column Info
	 * @param cllRmk2
	 */
	public void setCllRmk2(String cllRmk2) {
		this.cllRmk2 = cllRmk2;
	}

	/**
	 * Column Info
	 * @param cllRmk1
	 */
	public void setCllRmk1(String cllRmk1) {
		this.cllRmk1 = cllRmk1;
	}

	/**
	 * Column Info
	 * @param cntrVentCd
	 */
	public void setCntrVentCd(String cntrVentCd) {
		this.cntrVentCd = cntrVentCd;
	}

	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}

	/**
	 * Column Info
	 * @param ovrWgtQty
	 */
	public void setOvrWgtQty(String ovrWgtQty) {
		this.ovrWgtQty = ovrWgtQty;
	}

	/**
	 * Column Info
	 * @param tsSkdVoyNo
	 */
	public void setTsSkdVoyNo(String tsSkdVoyNo) {
		this.tsSkdVoyNo = tsSkdVoyNo;
	}

	/**
	 * Column Info
	 * @param tsFlg
	 */
	public void setTsFlg(String tsFlg) {
		this.tsFlg = tsFlg;
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
	 * @param ovrHgtQty
	 */
	public void setOvrHgtQty(String ovrHgtQty) {
		this.ovrHgtQty = ovrHgtQty;
	}

	/**
	 * Column Info
	 * @param ovrLenQty
	 */
	public void setOvrLenQty(String ovrLenQty) {
		this.ovrLenQty = ovrLenQty;
	}

	/**
	 * Column Info
	 * @param tsVvdCd
	 */
	public void setTsVvdCd(String tsVvdCd) {
		this.tsVvdCd = tsVvdCd;
	}

	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}

	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}

	/**
	 * Column Info
	 * @param sealNo
	 */
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}

	/**
	 * Column Info
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}

	/**
	 * Column Info
	 * @param inPolYdCd
	 */
	public void setInPolYdCd(String inPolYdCd) {
		this.inPolYdCd = inPolYdCd;
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
	 * @param maxTemp
	 */
	public void setMaxTemp(String maxTemp) {
		this.maxTemp = maxTemp;
	}

	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}

	/**
	 * Column Info
	 * @param cdoTemp
	 */
	public void setCdoTemp(String cdoTemp) {
		this.cdoTemp = cdoTemp;
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
	 * @param tsVslCd
	 */
	public void setTsVslCd(String tsVslCd) {
		this.tsVslCd = tsVslCd;
	}

	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}

	/**
	 * Column Info
	 * @param inPolCd
	 */
	public void setInPolCd(String inPolCd) {
		this.inPolCd = inPolCd;
	}

	/**
	 * Column Info
	 * @param tVslCd
	 */
	public void setTVslCd(String tVslCd) {
		this.tVslCd = tVslCd;
	}
	
	/**
	 * Column Info
	 * @param inBlCllData
	 */
	public void setInBlCllData(String inBlCllData) {
		this.inBlCllData = inBlCllData;
	}
	
	/**
	 * Column Info
	 * @param delChk
	 */
	public void setSelectRow(String selectRow) {
		this.selectRow = selectRow;
	}
	
	/**
	 * Column Info
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCntrListNo(JSPUtil.getParameter(request, "cntr_list_no", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, "blck_stwg_cd", ""));
		setMinTemp(JSPUtil.getParameter(request, "min_temp", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setBlWgt(JSPUtil.getParameter(request, "bl_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTsSkdDirCd(JSPUtil.getParameter(request, "ts_skd_dir_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setAPodCd(JSPUtil.getParameter(request, "a_pod_cd", ""));
		setKrTmlPrctId(JSPUtil.getParameter(request, "kr_tml_prct_id", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setStwgCd(JSPUtil.getParameter(request, "stwg_cd", ""));
		setMrnPolutFlg(JSPUtil.getParameter(request, "mrn_polut_flg", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setInKtmlCd(JSPUtil.getParameter(request, "in_ktml_cd", ""));
		setMtyBkgCd(JSPUtil.getParameter(request, "mty_bkg_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setInCllType(JSPUtil.getParameter(request, "in_cll_type", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setInVvdCd(JSPUtil.getParameter(request, "in_vvd_cd", ""));
		setXterRmk(JSPUtil.getParameter(request, "xter_rmk", ""));
		setCllRmk2(JSPUtil.getParameter(request, "cll_rmk2", ""));
		setCllRmk1(JSPUtil.getParameter(request, "cll_rmk1", ""));
		setCntrVentCd(JSPUtil.getParameter(request, "cntr_vent_cd", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setOvrWgtQty(JSPUtil.getParameter(request, "ovr_wgt_qty", ""));
		setTsSkdVoyNo(JSPUtil.getParameter(request, "ts_skd_voy_no", ""));
		setTsFlg(JSPUtil.getParameter(request, "ts_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOvrHgtQty(JSPUtil.getParameter(request, "ovr_hgt_qty", ""));
		setOvrLenQty(JSPUtil.getParameter(request, "ovr_len_qty", ""));
		setTsVvdCd(JSPUtil.getParameter(request, "ts_vvd_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
		setSealNo(JSPUtil.getParameter(request, "seal_no", ""));
		setBkgPolCd(JSPUtil.getParameter(request, "bkg_pol_cd", ""));
		setInPolYdCd(JSPUtil.getParameter(request, "in_pol_yd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setMaxTemp(JSPUtil.getParameter(request, "max_temp", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setCdoTemp(JSPUtil.getParameter(request, "cdo_temp", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setTsVslCd(JSPUtil.getParameter(request, "ts_vsl_cd", ""));
		setPolYdCd(JSPUtil.getParameter(request, "pol_yd_cd", ""));
		setInPolCd(JSPUtil.getParameter(request, "in_pol_cd", ""));
		setTVslCd(JSPUtil.getParameter(request, "t_vsl_cd", ""));
		setInBlCllData(JSPUtil.getParameter(request, "in_bl_cll_data", ""));
		setSelectRow(JSPUtil.getParameter(request, "select_row", ""));
		setVgmWgt(JSPUtil.getParameter(request, "vgm_wgt", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, "vgm_wgt_ut_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCllModifyVO[]
	 */
	public KorCllModifyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorCllModifyVO[]
	 */
	public KorCllModifyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCllModifyVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cntrListNo = (JSPUtil.getParameter(request, prefix	+ "cntr_list_no", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] minTemp = (JSPUtil.getParameter(request, prefix	+ "min_temp", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] blWgt = (JSPUtil.getParameter(request, prefix	+ "bl_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tsSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "ts_skd_dir_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] aPodCd = (JSPUtil.getParameter(request, prefix	+ "a_pod_cd", length));
			String[] krTmlPrctId = (JSPUtil.getParameter(request, prefix	+ "kr_tml_prct_id", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix	+ "mrn_polut_flg", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] inKtmlCd = (JSPUtil.getParameter(request, prefix	+ "in_ktml_cd", length));
			String[] mtyBkgCd = (JSPUtil.getParameter(request, prefix	+ "mty_bkg_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] inCllType = (JSPUtil.getParameter(request, prefix	+ "in_cll_type", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] cllRmk2 = (JSPUtil.getParameter(request, prefix	+ "cll_rmk2", length));
			String[] cllRmk1 = (JSPUtil.getParameter(request, prefix	+ "cll_rmk1", length));
			String[] cntrVentCd = (JSPUtil.getParameter(request, prefix	+ "cntr_vent_cd", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] ovrWgtQty = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_qty", length));
			String[] tsSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "ts_skd_voy_no", length));
			String[] tsFlg = (JSPUtil.getParameter(request, prefix	+ "ts_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ovrHgtQty = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt_qty", length));
			String[] ovrLenQty = (JSPUtil.getParameter(request, prefix	+ "ovr_len_qty", length));
			String[] tsVvdCd = (JSPUtil.getParameter(request, prefix	+ "ts_vvd_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] inPolYdCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_yd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] maxTemp = (JSPUtil.getParameter(request, prefix	+ "max_temp", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] cdoTemp = (JSPUtil.getParameter(request, prefix	+ "cdo_temp", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] tsVslCd = (JSPUtil.getParameter(request, prefix	+ "ts_vsl_cd", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] tVslCd = (JSPUtil.getParameter(request, prefix	+ "t_vsl_cd", length));
			String[] inBlCllData = (JSPUtil.getParameter(request, prefix + "in_bl_cll_data", length));
			String[] selectRow = (JSPUtil.getParameter(request, prefix + "select_row", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix + "vgm_wgt", length));
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", length));

			for (int i = 0; i < length; i++) {
				model = new KorCllModifyVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cntrListNo[i] != null)
					model.setCntrListNo(cntrListNo[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (minTemp[i] != null)
					model.setMinTemp(minTemp[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (blWgt[i] != null)
					model.setBlWgt(blWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tsSkdDirCd[i] != null)
					model.setTsSkdDirCd(tsSkdDirCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (aPodCd[i] != null)
					model.setAPodCd(aPodCd[i]);
				if (krTmlPrctId[i] != null)
					model.setKrTmlPrctId(krTmlPrctId[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (mrnPolutFlg[i] != null)
					model.setMrnPolutFlg(mrnPolutFlg[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (inKtmlCd[i] != null)
					model.setInKtmlCd(inKtmlCd[i]);
				if (mtyBkgCd[i] != null)
					model.setMtyBkgCd(mtyBkgCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (inCllType[i] != null)
					model.setInCllType(inCllType[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (xterRmk[i] != null)
					model.setXterRmk(xterRmk[i]);
				if (cllRmk2[i] != null)
					model.setCllRmk2(cllRmk2[i]);
				if (cllRmk1[i] != null)
					model.setCllRmk1(cllRmk1[i]);
				if (cntrVentCd[i] != null)
					model.setCntrVentCd(cntrVentCd[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (ovrWgtQty[i] != null)
					model.setOvrWgtQty(ovrWgtQty[i]);
				if (tsSkdVoyNo[i] != null)
					model.setTsSkdVoyNo(tsSkdVoyNo[i]);
				if (tsFlg[i] != null)
					model.setTsFlg(tsFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ovrHgtQty[i] != null)
					model.setOvrHgtQty(ovrHgtQty[i]);
				if (ovrLenQty[i] != null)
					model.setOvrLenQty(ovrLenQty[i]);
				if (tsVvdCd[i] != null)
					model.setTsVvdCd(tsVvdCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (inPolYdCd[i] != null)
					model.setInPolYdCd(inPolYdCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (maxTemp[i] != null)
					model.setMaxTemp(maxTemp[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (cdoTemp[i] != null)
					model.setCdoTemp(cdoTemp[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (tsVslCd[i] != null)
					model.setTsVslCd(tsVslCd[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (tVslCd[i] != null)
					model.setTVslCd(tVslCd[i]);
				if (inBlCllData[i] != null)
					model.setInBlCllData(inBlCllData[i]);
				if (selectRow[i] != null)
					model.setSelectRow(selectRow[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCllModifyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCllModifyVO[]
	 */
	public KorCllModifyVO[] getKorCllModifyVOs(){
		KorCllModifyVO[] vos = (KorCllModifyVO[])models.toArray(new KorCllModifyVO[models.size()]);
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
		this.cntrListNo = this.cntrListNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minTemp = this.minTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blWgt = this.blWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsSkdDirCd = this.tsSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aPodCd = this.aPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krTmlPrctId = this.krTmlPrctId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPolutFlg = this.mrnPolutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inKtmlCd = this.inKtmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgCd = this.mtyBkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCllType = this.inCllType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cllRmk2 = this.cllRmk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cllRmk1 = this.cllRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVentCd = this.cntrVentCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtQty = this.ovrWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsSkdVoyNo = this.tsSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsFlg = this.tsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgtQty = this.ovrHgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrLenQty = this.ovrLenQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVvdCd = this.tsVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolYdCd = this.inPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxTemp = this.maxTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdoTemp = this.cdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVslCd = this.tsVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVslCd = this.tVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBlCllData = this.inBlCllData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selectRow = this.selectRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
