/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorCllDetailVO.java
*@FileTitle : KorCllDetailVO
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

public class KorCllDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorCllDetailVO> models = new ArrayList<KorCllDetailVO>();
	
	/* Column Info */
	private String vgmWgtUtCd = null;
	/* Column Info */
	private String vslCd = null;
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
	private String aPodCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String krTmlPrctId = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String cmdtHsCd = null;
	/* Column Info */
	private String mrnPolutFlg = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String mtyBkgCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String xterRmk = null;
	/* Column Info */
	private String cllRmk3 = null;
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
	private String maxEdiSndDt = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String vgmKgs = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bcCd = null;
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
	private String vvdCdNm = null;
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String hamoTrfCd = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String vgmMzdTpCd = null;
	/* Column Info */
	private String vpsEtd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String maxTemp = null;
	/* Column Info */
	private String cdoTemp = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String vgmVrfySigCtnt = null;
	/* Column Info */
	private String polCdPrint = null;
	/* Column Info */
	private String tVslCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public KorCllDetailVO() {}

	public KorCllDetailVO(String ibflag, String pagerows, String vslCd, String blckStwgCd, String minTemp, String blNo, String blWgt, String aPodCd, String polCd, String krTmlPrctId, String wgtUtCd, String cntrTpszCd, String stwgCd, String cmdtHsCd, String mrnPolutFlg, String imdgUnNo, String skdVoyNo, String mtyBkgCd, String podCd, String bkgNo, String xterRmk, String cllRmk3, String cllRmk2, String cllRmk1, String cntrVentCd, String imdgClssCd, String ovrWgtQty, String maxEdiSndDt, String vgmWgt, String vgmKgs, String bcCd, String tsFlg, String ovrHgtQty, String ovrLenQty, String tsVvdCd, String rcvTermCd, String podYdCd, String vvdCdNm, String sealNo, String hamoTrfCd, String bkgPolCd, String vpsEtd, String skdDirCd, String maxTemp, String cdoTemp, String cntrNo, String polYdCd, String seq, String polCdPrint, String tVslCd, String vgmWgtUtCd, String vgmMzdTpCd, String vgmVrfySigCtnt) {
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.vslCd = vslCd;
		this.blckStwgCd = blckStwgCd;
		this.minTemp = minTemp;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.blWgt = blWgt;
		this.aPodCd = aPodCd;
		this.polCd = polCd;
		this.krTmlPrctId = krTmlPrctId;
		this.wgtUtCd = wgtUtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.stwgCd = stwgCd;
		this.cmdtHsCd = cmdtHsCd;
		this.mrnPolutFlg = mrnPolutFlg;
		this.imdgUnNo = imdgUnNo;
		this.mtyBkgCd = mtyBkgCd;
		this.skdVoyNo = skdVoyNo;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.xterRmk = xterRmk;
		this.cllRmk3 = cllRmk3;
		this.cllRmk2 = cllRmk2;
		this.cllRmk1 = cllRmk1;
		this.cntrVentCd = cntrVentCd;
		this.imdgClssCd = imdgClssCd;
		this.ovrWgtQty = ovrWgtQty;
		this.maxEdiSndDt = maxEdiSndDt;
		this.vgmWgt = vgmWgt;
		this.vgmKgs = vgmKgs;
		this.ibflag = ibflag;
		this.bcCd = bcCd;
		this.tsFlg = tsFlg;
		this.ovrHgtQty = ovrHgtQty;
		this.ovrLenQty = ovrLenQty;
		this.tsVvdCd = tsVvdCd;
		this.rcvTermCd = rcvTermCd;
		this.podYdCd = podYdCd;
		this.vvdCdNm = vvdCdNm;
		this.sealNo = sealNo;
		this.hamoTrfCd = hamoTrfCd;
		this.bkgPolCd = bkgPolCd;
		this.vgmMzdTpCd = vgmMzdTpCd;
		this.vpsEtd = vpsEtd;
		this.skdDirCd = skdDirCd;
		this.maxTemp = maxTemp;
		this.cdoTemp = cdoTemp;
		this.cntrNo = cntrNo;
		this.polYdCd = polYdCd;
		this.seq = seq;
		this.vgmVrfySigCtnt = vgmVrfySigCtnt;
		this.polCdPrint = polCdPrint;
		this.tVslCd = tVslCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("min_temp", getMinTemp());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_wgt", getBlWgt());
		this.hashColumns.put("a_pod_cd", getAPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("kr_tml_prct_id", getKrTmlPrctId());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
		this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("mty_bkg_cd", getMtyBkgCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("cll_rmk3", getCllRmk3());
		this.hashColumns.put("cll_rmk2", getCllRmk2());
		this.hashColumns.put("cll_rmk1", getCllRmk1());
		this.hashColumns.put("cntr_vent_cd", getCntrVentCd());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("ovr_wgt_qty", getOvrWgtQty());
		this.hashColumns.put("max_edi_snd_dt", getMaxEdiSndDt());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("vgm_kgs", getVgmKgs());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bc_cd", getBcCd());
		this.hashColumns.put("ts_flg", getTsFlg());
		this.hashColumns.put("ovr_hgt_qty", getOvrHgtQty());
		this.hashColumns.put("ovr_len_qty", getOvrLenQty());
		this.hashColumns.put("ts_vvd_cd", getTsVvdCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("vvd_cd_nm", getVvdCdNm());
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("hamo_trf_cd", getHamoTrfCd());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("vgm_mzd_tp_cd", getVgmMzdTpCd());
		this.hashColumns.put("vps_etd", getVpsEtd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("max_temp", getMaxTemp());
		this.hashColumns.put("cdo_temp", getCdoTemp());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("vgm_vrfy_sig_ctnt", getVgmVrfySigCtnt());
		this.hashColumns.put("pol_cd_print", getPolCdPrint());
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
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("min_temp", "minTemp");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_wgt", "blWgt");
		this.hashFields.put("a_pod_cd", "aPodCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("kr_tml_prct_id", "krTmlPrctId");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
		this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("mty_bkg_cd", "mtyBkgCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("cll_rmk3", "cllRmk3");
		this.hashFields.put("cll_rmk2", "cllRmk2");
		this.hashFields.put("cll_rmk1", "cllRmk1");
		this.hashFields.put("cntr_vent_cd", "cntrVentCd");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("ovr_wgt_qty", "ovrWgtQty");
		this.hashFields.put("max_edi_snd_dt", "maxEdiSndDt");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("vgm_kgs", "vgmKgs");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bc_cd", "bcCd");
		this.hashFields.put("ts_flg", "tsFlg");
		this.hashFields.put("ovr_hgt_qty", "ovrHgtQty");
		this.hashFields.put("ovr_len_qty", "ovrLenQty");
		this.hashFields.put("ts_vvd_cd", "tsVvdCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("vvd_cd_nm", "vvdCdNm");
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("hamo_trf_cd", "hamoTrfCd");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("vgm_mzd_tp_cd", "vgmMzdTpCd");
		this.hashFields.put("vps_etd", "vpsEtd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("max_temp", "maxTemp");
		this.hashFields.put("cdo_temp", "cdoTemp");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("vgm_vrfy_sig_ctnt", "vgmVrfySigCtnt");
		this.hashFields.put("pol_cd_print", "polCdPrint");
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
	 * @return aPodCd
	 */
	public String getAPodCd() {
		return this.aPodCd;
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
	 * @return cmdtHsCd
	 */
	public String getCmdtHsCd() {
		return this.cmdtHsCd;
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
	 * @return xterRmk
	 */
	public String getXterRmk() {
		return this.xterRmk;
	}
	
	/**
	 * Column Info
	 * @return cllRmk3
	 */
	public String getCllRmk3() {
		return this.cllRmk3;
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
	 * @return maxEdiSndDt
	 */
	public String getMaxEdiSndDt() {
		return this.maxEdiSndDt;
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
	 * @return bcCd
	 */
	public String getBcCd() {
		return this.bcCd;
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
	 * @return vvdCdNm
	 */
	public String getVvdCdNm() {
		return this.vvdCdNm;
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
	 * @return hamoTrfCd
	 */
	public String getHamoTrfCd() {
		return this.hamoTrfCd;
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
	 * @return vpsEtd
	 */
	public String getVpsEtd() {
		return this.vpsEtd;
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
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
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
	 * @return polCdPrint
	 */
	public String getPolCdPrint() {
		return this.polCdPrint;
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
	 * @param aPodCd
	 */
	public void setAPodCd(String aPodCd) {
		this.aPodCd = aPodCd;
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
	 * @param cmdtHsCd
	 */
	public void setCmdtHsCd(String cmdtHsCd) {
		this.cmdtHsCd = cmdtHsCd;
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
	 * @param xterRmk
	 */
	public void setXterRmk(String xterRmk) {
		this.xterRmk = xterRmk;
	}
	
	/**
	 * Column Info
	 * @param cllRmk3
	 */
	public void setCllRmk3(String cllRmk3) {
		this.cllRmk3 = cllRmk3;
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
	 * @param maxEdiSndDt
	 */
	public void setMaxEdiSndDt(String maxEdiSndDt) {
		this.maxEdiSndDt = maxEdiSndDt;
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
	 * @param bcCd
	 */
	public void setBcCd(String bcCd) {
		this.bcCd = bcCd;
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
	 * @param vvdCdNm
	 */
	public void setVvdCdNm(String vvdCdNm) {
		this.vvdCdNm = vvdCdNm;
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
	 * @param hamoTrfCd
	 */
	public void setHamoTrfCd(String hamoTrfCd) {
		this.hamoTrfCd = hamoTrfCd;
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
	 * @param vpsEtd
	 */
	public void setVpsEtd(String vpsEtd) {
		this.vpsEtd = vpsEtd;
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
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
	 * @param polCdPrint
	 */
	public void setPolCdPrint(String polCdPrint) {
		this.polCdPrint = polCdPrint;
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
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setMinTemp(JSPUtil.getParameter(request, prefix + "min_temp", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlWgt(JSPUtil.getParameter(request, prefix + "bl_wgt", ""));
		setAPodCd(JSPUtil.getParameter(request, prefix + "a_pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setKrTmlPrctId(JSPUtil.getParameter(request, prefix + "kr_tml_prct_id", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
		setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
		setMrnPolutFlg(JSPUtil.getParameter(request, prefix + "mrn_polut_flg", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setMtyBkgCd(JSPUtil.getParameter(request, prefix + "mty_bkg_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
		setCllRmk3(JSPUtil.getParameter(request, prefix + "cll_rmk3", ""));
		setCllRmk2(JSPUtil.getParameter(request, prefix + "cll_rmk2", ""));
		setCllRmk1(JSPUtil.getParameter(request, prefix + "cll_rmk1", ""));
		setCntrVentCd(JSPUtil.getParameter(request, prefix + "cntr_vent_cd", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setOvrWgtQty(JSPUtil.getParameter(request, prefix + "ovr_wgt_qty", ""));
		setMaxEdiSndDt(JSPUtil.getParameter(request, prefix + "max_edi_snd_dt", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setVgmKgs(JSPUtil.getParameter(request, prefix + "vgm_kgs", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBcCd(JSPUtil.getParameter(request, prefix + "bc_cd", ""));
		setTsFlg(JSPUtil.getParameter(request, prefix + "ts_flg", ""));
		setOvrHgtQty(JSPUtil.getParameter(request, prefix + "ovr_hgt_qty", ""));
		setOvrLenQty(JSPUtil.getParameter(request, prefix + "ovr_len_qty", ""));
		setTsVvdCd(JSPUtil.getParameter(request, prefix + "ts_vvd_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setVvdCdNm(JSPUtil.getParameter(request, prefix + "vvd_cd_nm", ""));
		setSealNo(JSPUtil.getParameter(request, prefix + "seal_no", ""));
		setHamoTrfCd(JSPUtil.getParameter(request, prefix + "hamo_trf_cd", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setVgmMzdTpCd(JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", ""));
		setVpsEtd(JSPUtil.getParameter(request, prefix + "vps_etd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setMaxTemp(JSPUtil.getParameter(request, prefix + "max_temp", ""));
		setCdoTemp(JSPUtil.getParameter(request, prefix + "cdo_temp", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setVgmVrfySigCtnt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_sig_ctnt", ""));
		setPolCdPrint(JSPUtil.getParameter(request, prefix + "pol_cd_print", ""));
		setTVslCd(JSPUtil.getParameter(request, prefix + "t_vsl_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCllDetailVO[]
	 */
	public KorCllDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorCllDetailVO[]
	 */
	public KorCllDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCllDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] minTemp = (JSPUtil.getParameter(request, prefix	+ "min_temp", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blWgt = (JSPUtil.getParameter(request, prefix	+ "bl_wgt", length));
			String[] aPodCd = (JSPUtil.getParameter(request, prefix	+ "a_pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] krTmlPrctId = (JSPUtil.getParameter(request, prefix	+ "kr_tml_prct_id", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_cd", length));
			String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix	+ "mrn_polut_flg", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] mtyBkgCd = (JSPUtil.getParameter(request, prefix	+ "mty_bkg_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] cllRmk3 = (JSPUtil.getParameter(request, prefix	+ "cll_rmk3", length));
			String[] cllRmk2 = (JSPUtil.getParameter(request, prefix	+ "cll_rmk2", length));
			String[] cllRmk1 = (JSPUtil.getParameter(request, prefix	+ "cll_rmk1", length));
			String[] cntrVentCd = (JSPUtil.getParameter(request, prefix	+ "cntr_vent_cd", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] ovrWgtQty = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_qty", length));
			String[] maxEdiSndDt = (JSPUtil.getParameter(request, prefix	+ "max_edi_snd_dt", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] vgmKgs = (JSPUtil.getParameter(request, prefix	+ "vgm_kgs", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bcCd = (JSPUtil.getParameter(request, prefix	+ "bc_cd", length));
			String[] tsFlg = (JSPUtil.getParameter(request, prefix	+ "ts_flg", length));
			String[] ovrHgtQty = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt_qty", length));
			String[] ovrLenQty = (JSPUtil.getParameter(request, prefix	+ "ovr_len_qty", length));
			String[] tsVvdCd = (JSPUtil.getParameter(request, prefix	+ "ts_vvd_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] vvdCdNm = (JSPUtil.getParameter(request, prefix	+ "vvd_cd_nm", length));
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] hamoTrfCd = (JSPUtil.getParameter(request, prefix	+ "hamo_trf_cd", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] vgmMzdTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_mzd_tp_cd", length));
			String[] vpsEtd = (JSPUtil.getParameter(request, prefix	+ "vps_etd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] maxTemp = (JSPUtil.getParameter(request, prefix	+ "max_temp", length));
			String[] cdoTemp = (JSPUtil.getParameter(request, prefix	+ "cdo_temp", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] vgmVrfySigCtnt = (JSPUtil.getParameter(request, prefix	+ "vgm_vrfy_sig_ctnt", length));
			String[] polCdPrint = (JSPUtil.getParameter(request, prefix	+ "pol_cd_print", length));
			String[] tVslCd = (JSPUtil.getParameter(request, prefix	+ "t_vsl_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorCllDetailVO();
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
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
				if (aPodCd[i] != null)
					model.setAPodCd(aPodCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (krTmlPrctId[i] != null)
					model.setKrTmlPrctId(krTmlPrctId[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (cmdtHsCd[i] != null)
					model.setCmdtHsCd(cmdtHsCd[i]);
				if (mrnPolutFlg[i] != null)
					model.setMrnPolutFlg(mrnPolutFlg[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (mtyBkgCd[i] != null)
					model.setMtyBkgCd(mtyBkgCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (xterRmk[i] != null)
					model.setXterRmk(xterRmk[i]);
				if (cllRmk3[i] != null)
					model.setCllRmk3(cllRmk3[i]);
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
				if (maxEdiSndDt[i] != null)
					model.setMaxEdiSndDt(maxEdiSndDt[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (vgmKgs[i] != null)
					model.setVgmKgs(vgmKgs[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bcCd[i] != null)
					model.setBcCd(bcCd[i]);
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
				if (vvdCdNm[i] != null)
					model.setVvdCdNm(vvdCdNm[i]);
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (hamoTrfCd[i] != null)
					model.setHamoTrfCd(hamoTrfCd[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (vgmMzdTpCd[i] != null)
					model.setVgmMzdTpCd(vgmMzdTpCd[i]);
				if (vpsEtd[i] != null)
					model.setVpsEtd(vpsEtd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (maxTemp[i] != null)
					model.setMaxTemp(maxTemp[i]);
				if (cdoTemp[i] != null)
					model.setCdoTemp(cdoTemp[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (vgmVrfySigCtnt[i] != null)
					model.setVgmVrfySigCtnt(vgmVrfySigCtnt[i]);
				if (polCdPrint[i] != null)
					model.setPolCdPrint(polCdPrint[i]);
				if (tVslCd[i] != null)
					model.setTVslCd(tVslCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCllDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCllDetailVO[]
	 */
	public KorCllDetailVO[] getKorCllDetailVOs(){
		KorCllDetailVO[] vos = (KorCllDetailVO[])models.toArray(new KorCllDetailVO[models.size()]);
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
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minTemp = this.minTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blWgt = this.blWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aPodCd = this.aPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krTmlPrctId = this.krTmlPrctId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCd = this.cmdtHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPolutFlg = this.mrnPolutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgCd = this.mtyBkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cllRmk3 = this.cllRmk3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cllRmk2 = this.cllRmk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cllRmk1 = this.cllRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVentCd = this.cntrVentCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtQty = this.ovrWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxEdiSndDt = this.maxEdiSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmKgs = this.vgmKgs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bcCd = this.bcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsFlg = this.tsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgtQty = this.ovrHgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrLenQty = this.ovrLenQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVvdCd = this.tsVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCdNm = this.vvdCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hamoTrfCd = this.hamoTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmMzdTpCd = this.vgmMzdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtd = this.vpsEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxTemp = this.maxTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdoTemp = this.cdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfySigCtnt = this.vgmVrfySigCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCdPrint = this.polCdPrint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVslCd = this.tVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
