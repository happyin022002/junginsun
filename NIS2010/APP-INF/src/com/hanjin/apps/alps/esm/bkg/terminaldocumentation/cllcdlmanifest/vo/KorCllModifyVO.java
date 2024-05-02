/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorCllModifyVO.java
*@FileTitle : KorCllModifyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorCllModifyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorCllModifyVO> models = new ArrayList<KorCllModifyVO>();
	
	/* Column Info */
	private String vgmWgtUtCd = null;
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
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blWgt = null;
	/* Column Info */
	private String tsSkdDirCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String aPodCd = null;
	/* Column Info */
	private String krTmlPrctId = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String mrnPolutFlg = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String inKtmlCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String mtyBkgCd = null;
	/* Column Info */
	private String inCllType = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
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
	private String vgmWgt = null;
	/* Column Info */
	private String vgmKgs = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tsFlg = null;
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
	private String vgmMzdTpCd = null;
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
	private String tsVslCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String vgmVrfySigCtnt = null;
	/* Column Info */
	private String tVslCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public KorCllModifyVO() {}

	public KorCllModifyVO(String ibflag, String pagerows, String vslCd, String cntrListNo, String blckStwgCd, String minTemp, String blNo, String blWgt, String tsSkdDirCd, String polCd, String aPodCd, String krTmlPrctId, String wgtUtCd, String cntrTpszCd, String stwgCd, String mrnPolutFlg, String imdgUnNo, String inKtmlCd, String mtyBkgCd, String skdVoyNo, String inCllType, String podCd, String creUsrId, String bkgNo, String inVvdCd, String xterRmk, String cllRmk2, String cllRmk1, String cntrVentCd, String imdgClssCd, String ovrWgtQty, String tsSkdVoyNo, String vgmWgt, String vgmKgs, String tsFlg, String ovrHgtQty, String ovrLenQty, String tsVvdCd, String rcvTermCd, String podYdCd, String sealNo, String bkgPolCd, String inPolYdCd, String skdDirCd, String maxTemp, String deTermCd, String cdoTemp, String polYdCd, String cntrNo, String tsVslCd, String inPolCd, String tVslCd, String vgmWgtUtCd, String vgmMzdTpCd, String vgmVrfySigCtnt) {
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.vslCd = vslCd;
		this.cntrListNo = cntrListNo;
		this.blckStwgCd = blckStwgCd;
		this.minTemp = minTemp;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.blWgt = blWgt;
		this.tsSkdDirCd = tsSkdDirCd;
		this.polCd = polCd;
		this.aPodCd = aPodCd;
		this.krTmlPrctId = krTmlPrctId;
		this.cntrTpszCd = cntrTpszCd;
		this.wgtUtCd = wgtUtCd;
		this.stwgCd = stwgCd;
		this.mrnPolutFlg = mrnPolutFlg;
		this.imdgUnNo = imdgUnNo;
		this.inKtmlCd = inKtmlCd;
		this.skdVoyNo = skdVoyNo;
		this.mtyBkgCd = mtyBkgCd;
		this.inCllType = inCllType;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.inVvdCd = inVvdCd;
		this.xterRmk = xterRmk;
		this.cllRmk2 = cllRmk2;
		this.cllRmk1 = cllRmk1;
		this.cntrVentCd = cntrVentCd;
		this.imdgClssCd = imdgClssCd;
		this.ovrWgtQty = ovrWgtQty;
		this.tsSkdVoyNo = tsSkdVoyNo;
		this.vgmWgt = vgmWgt;
		this.vgmKgs = vgmKgs;
		this.ibflag = ibflag;
		this.tsFlg = tsFlg;
		this.ovrHgtQty = ovrHgtQty;
		this.ovrLenQty = ovrLenQty;
		this.tsVvdCd = tsVvdCd;
		this.rcvTermCd = rcvTermCd;
		this.podYdCd = podYdCd;
		this.sealNo = sealNo;
		this.bkgPolCd = bkgPolCd;
		this.vgmMzdTpCd = vgmMzdTpCd;
		this.inPolYdCd = inPolYdCd;
		this.skdDirCd = skdDirCd;
		this.maxTemp = maxTemp;
		this.deTermCd = deTermCd;
		this.cdoTemp = cdoTemp;
		this.tsVslCd = tsVslCd;
		this.cntrNo = cntrNo;
		this.polYdCd = polYdCd;
		this.inPolCd = inPolCd;
		this.vgmVrfySigCtnt = vgmVrfySigCtnt;
		this.tVslCd = tVslCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cntr_list_no", getCntrListNo());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("min_temp", getMinTemp());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_wgt", getBlWgt());
		this.hashColumns.put("ts_skd_dir_cd", getTsSkdDirCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("a_pod_cd", getAPodCd());
		this.hashColumns.put("kr_tml_prct_id", getKrTmlPrctId());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("in_ktml_cd", getInKtmlCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("mty_bkg_cd", getMtyBkgCd());
		this.hashColumns.put("in_cll_type", getInCllType());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("cll_rmk2", getCllRmk2());
		this.hashColumns.put("cll_rmk1", getCllRmk1());
		this.hashColumns.put("cntr_vent_cd", getCntrVentCd());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("ovr_wgt_qty", getOvrWgtQty());
		this.hashColumns.put("ts_skd_voy_no", getTsSkdVoyNo());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("vgm_kgs", getVgmKgs());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ts_flg", getTsFlg());
		this.hashColumns.put("ovr_hgt_qty", getOvrHgtQty());
		this.hashColumns.put("ovr_len_qty", getOvrLenQty());
		this.hashColumns.put("ts_vvd_cd", getTsVvdCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("vgm_mzd_tp_cd", getVgmMzdTpCd());
		this.hashColumns.put("in_pol_yd_cd", getInPolYdCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("max_temp", getMaxTemp());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("cdo_temp", getCdoTemp());
		this.hashColumns.put("ts_vsl_cd", getTsVslCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("vgm_vrfy_sig_ctnt", getVgmVrfySigCtnt());
		this.hashColumns.put("t_vsl_cd", getTVslCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cntr_list_no", "cntrListNo");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("min_temp", "minTemp");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_wgt", "blWgt");
		this.hashFields.put("ts_skd_dir_cd", "tsSkdDirCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("a_pod_cd", "aPodCd");
		this.hashFields.put("kr_tml_prct_id", "krTmlPrctId");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("in_ktml_cd", "inKtmlCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("mty_bkg_cd", "mtyBkgCd");
		this.hashFields.put("in_cll_type", "inCllType");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("cll_rmk2", "cllRmk2");
		this.hashFields.put("cll_rmk1", "cllRmk1");
		this.hashFields.put("cntr_vent_cd", "cntrVentCd");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("ovr_wgt_qty", "ovrWgtQty");
		this.hashFields.put("ts_skd_voy_no", "tsSkdVoyNo");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("vgm_kgs", "vgmKgs");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ts_flg", "tsFlg");
		this.hashFields.put("ovr_hgt_qty", "ovrHgtQty");
		this.hashFields.put("ovr_len_qty", "ovrLenQty");
		this.hashFields.put("ts_vvd_cd", "tsVvdCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("vgm_mzd_tp_cd", "vgmMzdTpCd");
		this.hashFields.put("in_pol_yd_cd", "inPolYdCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("max_temp", "maxTemp");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cdo_temp", "cdoTemp");
		this.hashFields.put("ts_vsl_cd", "tsVslCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("vgm_vrfy_sig_ctnt", "vgmVrfySigCtnt");
		this.hashFields.put("t_vsl_cd", "tVslCd");
		return this.hashFields;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return blWgt
	 */
	public String getBlWgt() {
		return this.blWgt;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
	}
	
	/**
	 * Column Info
	 * @return vgmKgs
	 */
	public String getVgmKgs() {
		return this.vgmKgs;
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
	 * @return tsFlg
	 */
	public String getTsFlg() {
		return this.tsFlg;
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
	 * @return vgmMzdTpCd
	 */
	public String getVgmMzdTpCd() {
		return this.vgmMzdTpCd;
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
	 * @return tsVslCd
	 */
	public String getTsVslCd() {
		return this.tsVslCd;
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
	 * @return vgmVrfySigCtnt
	 */
	public String getVgmVrfySigCtnt() {
		return this.vgmVrfySigCtnt;
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
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param blWgt
	 */
	public void setBlWgt(String blWgt) {
		this.blWgt = blWgt;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
	}
	
	/**
	 * Column Info
	 * @param vgmKgs
	 */
	public void setVgmKgs(String vgmKgs) {
		this.vgmKgs = vgmKgs;
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
	 * @param tsFlg
	 */
	public void setTsFlg(String tsFlg) {
		this.tsFlg = tsFlg;
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
	 * @param vgmMzdTpCd
	 */
	public void setVgmMzdTpCd(String vgmMzdTpCd) {
		this.vgmMzdTpCd = vgmMzdTpCd;
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
	 * @param tsVslCd
	 */
	public void setTsVslCd(String tsVslCd) {
		this.tsVslCd = tsVslCd;
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
	 * @param vgmVrfySigCtnt
	 */
	public void setVgmVrfySigCtnt(String vgmVrfySigCtnt) {
		this.vgmVrfySigCtnt = vgmVrfySigCtnt;
	}
	
	/**
	 * Column Info
	 * @param tVslCd
	 */
	public void setTVslCd(String tVslCd) {
		this.tVslCd = tVslCd;
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
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCntrListNo(JSPUtil.getParameter(request, prefix + "cntr_list_no", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setMinTemp(JSPUtil.getParameter(request, prefix + "min_temp", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlWgt(JSPUtil.getParameter(request, prefix + "bl_wgt", ""));
		setTsSkdDirCd(JSPUtil.getParameter(request, prefix + "ts_skd_dir_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setAPodCd(JSPUtil.getParameter(request, prefix + "a_pod_cd", ""));
		setKrTmlPrctId(JSPUtil.getParameter(request, prefix + "kr_tml_prct_id", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
		setMrnPolutFlg(JSPUtil.getParameter(request, prefix + "mrn_polut_flg", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setInKtmlCd(JSPUtil.getParameter(request, prefix + "in_ktml_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setMtyBkgCd(JSPUtil.getParameter(request, prefix + "mty_bkg_cd", ""));
		setInCllType(JSPUtil.getParameter(request, prefix + "in_cll_type", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
		setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
		setCllRmk2(JSPUtil.getParameter(request, prefix + "cll_rmk2", ""));
		setCllRmk1(JSPUtil.getParameter(request, prefix + "cll_rmk1", ""));
		setCntrVentCd(JSPUtil.getParameter(request, prefix + "cntr_vent_cd", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setOvrWgtQty(JSPUtil.getParameter(request, prefix + "ovr_wgt_qty", ""));
		setTsSkdVoyNo(JSPUtil.getParameter(request, prefix + "ts_skd_voy_no", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setVgmKgs(JSPUtil.getParameter(request, prefix + "vgm_kgs", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTsFlg(JSPUtil.getParameter(request, prefix + "ts_flg", ""));
		setOvrHgtQty(JSPUtil.getParameter(request, prefix + "ovr_hgt_qty", ""));
		setOvrLenQty(JSPUtil.getParameter(request, prefix + "ovr_len_qty", ""));
		setTsVvdCd(JSPUtil.getParameter(request, prefix + "ts_vvd_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setSealNo(JSPUtil.getParameter(request, prefix + "seal_no", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setVgmMzdTpCd(JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", ""));
		setInPolYdCd(JSPUtil.getParameter(request, prefix + "in_pol_yd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setMaxTemp(JSPUtil.getParameter(request, prefix + "max_temp", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setCdoTemp(JSPUtil.getParameter(request, prefix + "cdo_temp", ""));
		setTsVslCd(JSPUtil.getParameter(request, prefix + "ts_vsl_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setInPolCd(JSPUtil.getParameter(request, prefix + "in_pol_cd", ""));
		setVgmVrfySigCtnt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_sig_ctnt", ""));
		setTVslCd(JSPUtil.getParameter(request, prefix + "t_vsl_cd", ""));
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
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cntrListNo = (JSPUtil.getParameter(request, prefix	+ "cntr_list_no", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] minTemp = (JSPUtil.getParameter(request, prefix	+ "min_temp", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blWgt = (JSPUtil.getParameter(request, prefix	+ "bl_wgt", length));
			String[] tsSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "ts_skd_dir_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] aPodCd = (JSPUtil.getParameter(request, prefix	+ "a_pod_cd", length));
			String[] krTmlPrctId = (JSPUtil.getParameter(request, prefix	+ "kr_tml_prct_id", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix	+ "mrn_polut_flg", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] inKtmlCd = (JSPUtil.getParameter(request, prefix	+ "in_ktml_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] mtyBkgCd = (JSPUtil.getParameter(request, prefix	+ "mty_bkg_cd", length));
			String[] inCllType = (JSPUtil.getParameter(request, prefix	+ "in_cll_type", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] cllRmk2 = (JSPUtil.getParameter(request, prefix	+ "cll_rmk2", length));
			String[] cllRmk1 = (JSPUtil.getParameter(request, prefix	+ "cll_rmk1", length));
			String[] cntrVentCd = (JSPUtil.getParameter(request, prefix	+ "cntr_vent_cd", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] ovrWgtQty = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_qty", length));
			String[] tsSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "ts_skd_voy_no", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] vgmKgs = (JSPUtil.getParameter(request, prefix	+ "vgm_kgs", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tsFlg = (JSPUtil.getParameter(request, prefix	+ "ts_flg", length));
			String[] ovrHgtQty = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt_qty", length));
			String[] ovrLenQty = (JSPUtil.getParameter(request, prefix	+ "ovr_len_qty", length));
			String[] tsVvdCd = (JSPUtil.getParameter(request, prefix	+ "ts_vvd_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] vgmMzdTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_mzd_tp_cd", length));
			String[] inPolYdCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_yd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] maxTemp = (JSPUtil.getParameter(request, prefix	+ "max_temp", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] cdoTemp = (JSPUtil.getParameter(request, prefix	+ "cdo_temp", length));
			String[] tsVslCd = (JSPUtil.getParameter(request, prefix	+ "ts_vsl_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] vgmVrfySigCtnt = (JSPUtil.getParameter(request, prefix	+ "vgm_vrfy_sig_ctnt", length));
			String[] tVslCd = (JSPUtil.getParameter(request, prefix	+ "t_vsl_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorCllModifyVO();
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
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
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blWgt[i] != null)
					model.setBlWgt(blWgt[i]);
				if (tsSkdDirCd[i] != null)
					model.setTsSkdDirCd(tsSkdDirCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (aPodCd[i] != null)
					model.setAPodCd(aPodCd[i]);
				if (krTmlPrctId[i] != null)
					model.setKrTmlPrctId(krTmlPrctId[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (mrnPolutFlg[i] != null)
					model.setMrnPolutFlg(mrnPolutFlg[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (inKtmlCd[i] != null)
					model.setInKtmlCd(inKtmlCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (mtyBkgCd[i] != null)
					model.setMtyBkgCd(mtyBkgCd[i]);
				if (inCllType[i] != null)
					model.setInCllType(inCllType[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
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
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (vgmKgs[i] != null)
					model.setVgmKgs(vgmKgs[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tsFlg[i] != null)
					model.setTsFlg(tsFlg[i]);
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
				if (vgmMzdTpCd[i] != null)
					model.setVgmMzdTpCd(vgmMzdTpCd[i]);
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
				if (tsVslCd[i] != null)
					model.setTsVslCd(tsVslCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (vgmVrfySigCtnt[i] != null)
					model.setVgmVrfySigCtnt(vgmVrfySigCtnt[i]);
				if (tVslCd[i] != null)
					model.setTVslCd(tVslCd[i]);
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
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrListNo = this.cntrListNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minTemp = this.minTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blWgt = this.blWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsSkdDirCd = this.tsSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aPodCd = this.aPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krTmlPrctId = this.krTmlPrctId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPolutFlg = this.mrnPolutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inKtmlCd = this.inKtmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgCd = this.mtyBkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCllType = this.inCllType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cllRmk2 = this.cllRmk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cllRmk1 = this.cllRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVentCd = this.cntrVentCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtQty = this.ovrWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsSkdVoyNo = this.tsSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmKgs = this.vgmKgs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsFlg = this.tsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgtQty = this.ovrHgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrLenQty = this.ovrLenQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVvdCd = this.tsVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmMzdTpCd = this.vgmMzdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolYdCd = this.inPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxTemp = this.maxTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdoTemp = this.cdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVslCd = this.tsVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfySigCtnt = this.vgmVrfySigCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVslCd = this.tVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
