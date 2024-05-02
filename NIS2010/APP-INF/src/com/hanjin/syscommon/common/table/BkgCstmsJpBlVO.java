/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCstmsJpBlVO.java
*@FileTitle : BkgCstmsJpBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCstmsJpBlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsJpBlVO> models = new ArrayList<BkgCstmsJpBlVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cyOprCd = null;
	/* Column Info */
	private String pstRlyPodCd = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String pstVslCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String jpEdiTrsmStgTpCd = null;
	/* Column Info */
	private String lmtNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pstSkdDirCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgDelCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String bdrDt = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String jpBlStsCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String blSplitNo = null;
	/* Column Info */
	private String loclTsFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String bkgPorCd = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String netWgt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String oftTpCd = null;
	/* Column Info */
	private String caDt = null;
	/* Column Info */
	private String jpCstmsTrnsCd = null;
	/* Column Info */
	private String caNo = null;
	/* Column Info */
	private String pstSkdVoyNo = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String grsWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCstmsJpBlVO() {}

	public BkgCstmsJpBlVO(String ibflag, String pagerows, String blNo, String blSplitNo, String jpEdiTrsmStgTpCd, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd, String bkgPorCd, String bkgPolCd, String bkgDelCd, String pstRlyPodCd, String pstVslCd, String pstSkdVoyNo, String pstSkdDirCd, String splitFlg, String pckQty, String pckTpCd, String grsWgt, String netWgt, String wgtUtCd, String measQty, String measUtCd, String rcvTermCd, String deTermCd, String dcgoFlg, String bdrFlg, String bdrDt, String caDt, String caNo, String jpBlStsCd, String ifDt, String loclTsFlg, String jpCstmsTrnsCd, String lmtNo, String cyOprCd, String fullMtyCd, String oftTpCd, String callSgnNo, String etaDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.ifDt = ifDt;
		this.splitFlg = splitFlg;
		this.vslCd = vslCd;
		this.cyOprCd = cyOprCd;
		this.pstRlyPodCd = pstRlyPodCd;
		this.etaDt = etaDt;
		this.bdrFlg = bdrFlg;
		this.pstVslCd = pstVslCd;
		this.creDt = creDt;
		this.jpEdiTrsmStgTpCd = jpEdiTrsmStgTpCd;
		this.lmtNo = lmtNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.pstSkdDirCd = pstSkdDirCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bkgDelCd = bkgDelCd;
		this.dcgoFlg = dcgoFlg;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.bdrDt = bdrDt;
		this.pckQty = pckQty;
		this.jpBlStsCd = jpBlStsCd;
		this.rcvTermCd = rcvTermCd;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.updUsrId = updUsrId;
		this.blSplitNo = blSplitNo;
		this.loclTsFlg = loclTsFlg;
		this.updDt = updDt;
		this.bkgPolCd = bkgPolCd;
		this.bkgPorCd = bkgPorCd;
		this.callSgnNo = callSgnNo;
		this.netWgt = netWgt;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.deTermCd = deTermCd;
		this.creUsrId = creUsrId;
		this.oftTpCd = oftTpCd;
		this.caDt = caDt;
		this.jpCstmsTrnsCd = jpCstmsTrnsCd;
		this.caNo = caNo;
		this.pstSkdVoyNo = pstSkdVoyNo;
		this.fullMtyCd = fullMtyCd;
		this.grsWgt = grsWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cy_opr_cd", getCyOprCd());
		this.hashColumns.put("pst_rly_pod_cd", getPstRlyPodCd());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("pst_vsl_cd", getPstVslCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("jp_edi_trsm_stg_tp_cd", getJpEdiTrsmStgTpCd());
		this.hashColumns.put("lmt_no", getLmtNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pst_skd_dir_cd", getPstSkdDirCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("bdr_dt", getBdrDt());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("jp_bl_sts_cd", getJpBlStsCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bl_split_no", getBlSplitNo());
		this.hashColumns.put("locl_ts_flg", getLoclTsFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("bkg_por_cd", getBkgPorCd());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("oft_tp_cd", getOftTpCd());
		this.hashColumns.put("ca_dt", getCaDt());
		this.hashColumns.put("jp_cstms_trns_cd", getJpCstmsTrnsCd());
		this.hashColumns.put("ca_no", getCaNo());
		this.hashColumns.put("pst_skd_voy_no", getPstSkdVoyNo());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cy_opr_cd", "cyOprCd");
		this.hashFields.put("pst_rly_pod_cd", "pstRlyPodCd");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("pst_vsl_cd", "pstVslCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("jp_edi_trsm_stg_tp_cd", "jpEdiTrsmStgTpCd");
		this.hashFields.put("lmt_no", "lmtNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pst_skd_dir_cd", "pstSkdDirCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("bdr_dt", "bdrDt");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("jp_bl_sts_cd", "jpBlStsCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bl_split_no", "blSplitNo");
		this.hashFields.put("locl_ts_flg", "loclTsFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("bkg_por_cd", "bkgPorCd");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("oft_tp_cd", "oftTpCd");
		this.hashFields.put("ca_dt", "caDt");
		this.hashFields.put("jp_cstms_trns_cd", "jpCstmsTrnsCd");
		this.hashFields.put("ca_no", "caNo");
		this.hashFields.put("pst_skd_voy_no", "pstSkdVoyNo");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("grs_wgt", "grsWgt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
	}
	
	/**
	 * Column Info
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
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
	 * @return cyOprCd
	 */
	public String getCyOprCd() {
		return this.cyOprCd;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPodCd
	 */
	public String getPstRlyPodCd() {
		return this.pstRlyPodCd;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
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
	 * @return pstVslCd
	 */
	public String getPstVslCd() {
		return this.pstVslCd;
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
	 * @return jpEdiTrsmStgTpCd
	 */
	public String getJpEdiTrsmStgTpCd() {
		return this.jpEdiTrsmStgTpCd;
	}
	
	/**
	 * Column Info
	 * @return lmtNo
	 */
	public String getLmtNo() {
		return this.lmtNo;
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
	 * @return pstSkdDirCd
	 */
	public String getPstSkdDirCd() {
		return this.pstSkdDirCd;
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
	 * @return bkgDelCd
	 */
	public String getBkgDelCd() {
		return this.bkgDelCd;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return bdrDt
	 */
	public String getBdrDt() {
		return this.bdrDt;
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
	 * @return jpBlStsCd
	 */
	public String getJpBlStsCd() {
		return this.jpBlStsCd;
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
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
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
	 * @return blSplitNo
	 */
	public String getBlSplitNo() {
		return this.blSplitNo;
	}
	
	/**
	 * Column Info
	 * @return loclTsFlg
	 */
	public String getLoclTsFlg() {
		return this.loclTsFlg;
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
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPorCd
	 */
	public String getBkgPorCd() {
		return this.bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return netWgt
	 */
	public String getNetWgt() {
		return this.netWgt;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return oftTpCd
	 */
	public String getOftTpCd() {
		return this.oftTpCd;
	}
	
	/**
	 * Column Info
	 * @return caDt
	 */
	public String getCaDt() {
		return this.caDt;
	}
	
	/**
	 * Column Info
	 * @return jpCstmsTrnsCd
	 */
	public String getJpCstmsTrnsCd() {
		return this.jpCstmsTrnsCd;
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
	 * @return pstSkdVoyNo
	 */
	public String getPstSkdVoyNo() {
		return this.pstSkdVoyNo;
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
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	

	/**
	 * Column Info
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
	}
	
	/**
	 * Column Info
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
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
	 * @param cyOprCd
	 */
	public void setCyOprCd(String cyOprCd) {
		this.cyOprCd = cyOprCd;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPodCd
	 */
	public void setPstRlyPodCd(String pstRlyPodCd) {
		this.pstRlyPodCd = pstRlyPodCd;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
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
	 * @param pstVslCd
	 */
	public void setPstVslCd(String pstVslCd) {
		this.pstVslCd = pstVslCd;
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
	 * @param jpEdiTrsmStgTpCd
	 */
	public void setJpEdiTrsmStgTpCd(String jpEdiTrsmStgTpCd) {
		this.jpEdiTrsmStgTpCd = jpEdiTrsmStgTpCd;
	}
	
	/**
	 * Column Info
	 * @param lmtNo
	 */
	public void setLmtNo(String lmtNo) {
		this.lmtNo = lmtNo;
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
	 * @param pstSkdDirCd
	 */
	public void setPstSkdDirCd(String pstSkdDirCd) {
		this.pstSkdDirCd = pstSkdDirCd;
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
	 * @param bkgDelCd
	 */
	public void setBkgDelCd(String bkgDelCd) {
		this.bkgDelCd = bkgDelCd;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param bdrDt
	 */
	public void setBdrDt(String bdrDt) {
		this.bdrDt = bdrDt;
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
	 * @param jpBlStsCd
	 */
	public void setJpBlStsCd(String jpBlStsCd) {
		this.jpBlStsCd = jpBlStsCd;
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
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
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
	 * @param blSplitNo
	 */
	public void setBlSplitNo(String blSplitNo) {
		this.blSplitNo = blSplitNo;
	}
	
	/**
	 * Column Info
	 * @param loclTsFlg
	 */
	public void setLoclTsFlg(String loclTsFlg) {
		this.loclTsFlg = loclTsFlg;
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
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPorCd
	 */
	public void setBkgPorCd(String bkgPorCd) {
		this.bkgPorCd = bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param netWgt
	 */
	public void setNetWgt(String netWgt) {
		this.netWgt = netWgt;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param oftTpCd
	 */
	public void setOftTpCd(String oftTpCd) {
		this.oftTpCd = oftTpCd;
	}
	
	/**
	 * Column Info
	 * @param caDt
	 */
	public void setCaDt(String caDt) {
		this.caDt = caDt;
	}
	
	/**
	 * Column Info
	 * @param jpCstmsTrnsCd
	 */
	public void setJpCstmsTrnsCd(String jpCstmsTrnsCd) {
		this.jpCstmsTrnsCd = jpCstmsTrnsCd;
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
	 * @param pstSkdVoyNo
	 */
	public void setPstSkdVoyNo(String pstSkdVoyNo) {
		this.pstSkdVoyNo = pstSkdVoyNo;
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
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIfDt(JSPUtil.getParameter(request, "if_dt", ""));
		setSplitFlg(JSPUtil.getParameter(request, "split_flg", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCyOprCd(JSPUtil.getParameter(request, "cy_opr_cd", ""));
		setPstRlyPodCd(JSPUtil.getParameter(request, "pst_rly_pod_cd", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setBdrFlg(JSPUtil.getParameter(request, "bdr_flg", ""));
		setPstVslCd(JSPUtil.getParameter(request, "pst_vsl_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setJpEdiTrsmStgTpCd(JSPUtil.getParameter(request, "jp_edi_trsm_stg_tp_cd", ""));
		setLmtNo(JSPUtil.getParameter(request, "lmt_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPstSkdDirCd(JSPUtil.getParameter(request, "pst_skd_dir_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgDelCd(JSPUtil.getParameter(request, "bkg_del_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setBdrDt(JSPUtil.getParameter(request, "bdr_dt", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setJpBlStsCd(JSPUtil.getParameter(request, "jp_bl_sts_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setBlSplitNo(JSPUtil.getParameter(request, "bl_split_no", ""));
		setLoclTsFlg(JSPUtil.getParameter(request, "locl_ts_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setBkgPolCd(JSPUtil.getParameter(request, "bkg_pol_cd", ""));
		setBkgPorCd(JSPUtil.getParameter(request, "bkg_por_cd", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setNetWgt(JSPUtil.getParameter(request, "net_wgt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setOftTpCd(JSPUtil.getParameter(request, "oft_tp_cd", ""));
		setCaDt(JSPUtil.getParameter(request, "ca_dt", ""));
		setJpCstmsTrnsCd(JSPUtil.getParameter(request, "jp_cstms_trns_cd", ""));
		setCaNo(JSPUtil.getParameter(request, "ca_no", ""));
		setPstSkdVoyNo(JSPUtil.getParameter(request, "pst_skd_voy_no", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setGrsWgt(JSPUtil.getParameter(request, "grs_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsJpBlVO[]
	 */
	public BkgCstmsJpBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsJpBlVO[]
	 */
	public BkgCstmsJpBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsJpBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cyOprCd = (JSPUtil.getParameter(request, prefix	+ "cy_opr_cd", length));
			String[] pstRlyPodCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_pod_cd", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] pstVslCd = (JSPUtil.getParameter(request, prefix	+ "pst_vsl_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] jpEdiTrsmStgTpCd = (JSPUtil.getParameter(request, prefix	+ "jp_edi_trsm_stg_tp_cd", length));
			String[] lmtNo = (JSPUtil.getParameter(request, prefix	+ "lmt_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pstSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "pst_skd_dir_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgDelCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] bdrDt = (JSPUtil.getParameter(request, prefix	+ "bdr_dt", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] jpBlStsCd = (JSPUtil.getParameter(request, prefix	+ "jp_bl_sts_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] blSplitNo = (JSPUtil.getParameter(request, prefix	+ "bl_split_no", length));
			String[] loclTsFlg = (JSPUtil.getParameter(request, prefix	+ "locl_ts_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] bkgPorCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cd", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] oftTpCd = (JSPUtil.getParameter(request, prefix	+ "oft_tp_cd", length));
			String[] caDt = (JSPUtil.getParameter(request, prefix	+ "ca_dt", length));
			String[] jpCstmsTrnsCd = (JSPUtil.getParameter(request, prefix	+ "jp_cstms_trns_cd", length));
			String[] caNo = (JSPUtil.getParameter(request, prefix	+ "ca_no", length));
			String[] pstSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "pst_skd_voy_no", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsJpBlVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cyOprCd[i] != null)
					model.setCyOprCd(cyOprCd[i]);
				if (pstRlyPodCd[i] != null)
					model.setPstRlyPodCd(pstRlyPodCd[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (pstVslCd[i] != null)
					model.setPstVslCd(pstVslCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (jpEdiTrsmStgTpCd[i] != null)
					model.setJpEdiTrsmStgTpCd(jpEdiTrsmStgTpCd[i]);
				if (lmtNo[i] != null)
					model.setLmtNo(lmtNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pstSkdDirCd[i] != null)
					model.setPstSkdDirCd(pstSkdDirCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgDelCd[i] != null)
					model.setBkgDelCd(bkgDelCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (bdrDt[i] != null)
					model.setBdrDt(bdrDt[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (jpBlStsCd[i] != null)
					model.setJpBlStsCd(jpBlStsCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (blSplitNo[i] != null)
					model.setBlSplitNo(blSplitNo[i]);
				if (loclTsFlg[i] != null)
					model.setLoclTsFlg(loclTsFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (bkgPorCd[i] != null)
					model.setBkgPorCd(bkgPorCd[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (netWgt[i] != null)
					model.setNetWgt(netWgt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (oftTpCd[i] != null)
					model.setOftTpCd(oftTpCd[i]);
				if (caDt[i] != null)
					model.setCaDt(caDt[i]);
				if (jpCstmsTrnsCd[i] != null)
					model.setJpCstmsTrnsCd(jpCstmsTrnsCd[i]);
				if (caNo[i] != null)
					model.setCaNo(caNo[i]);
				if (pstSkdVoyNo[i] != null)
					model.setPstSkdVoyNo(pstSkdVoyNo[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsJpBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsJpBlVO[]
	 */
	public BkgCstmsJpBlVO[] getBkgCstmsJpBlVOs(){
		BkgCstmsJpBlVO[] vos = (BkgCstmsJpBlVO[])models.toArray(new BkgCstmsJpBlVO[models.size()]);
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
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cyOprCd = this.cyOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPodCd = this.pstRlyPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstVslCd = this.pstVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpEdiTrsmStgTpCd = this.jpEdiTrsmStgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtNo = this.lmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstSkdDirCd = this.pstSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd = this.bkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrDt = this.bdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpBlStsCd = this.jpBlStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSplitNo = this.blSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTsFlg = this.loclTsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCd = this.bkgPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftTpCd = this.oftTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caDt = this.caDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpCstmsTrnsCd = this.jpCstmsTrnsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caNo = this.caNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstSkdVoyNo = this.pstSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
