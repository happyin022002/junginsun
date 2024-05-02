/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : searchBkgForSplitVO.java
*@FileTitle : searchBkgForSplitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.07
*@LastModifier : 최문환
*@LastVersion : 1.0
* 2013.05.07 최문환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo;

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
 * @author 최문환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class searchBkgForSplitVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<searchBkgForSplitVO> models = new ArrayList<searchBkgForSplitVO>();
	
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String stopOffLocCd = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String fdGrdFlg = null;
	/* Column Info */
	private String rf = null;
	/* Column Info */
	private String advShtgCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String pctlNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hotDeFlg = null;
	/* Column Info */
	private String dg = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String railBlkCd = null;
	/* Column Info */
	private String prctFlg = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String bb = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String troFlg = null;
	/* Column Info */
	private String troTp = null;
	/* Column Info */
	private String oblIssFlg = null;
	/* Column Info */
	private String firstVvd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String tvvd = null;
	/* Column Info */
	private String ltFlg = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String bkgClose = null;
	/* Column Info */
	private String ak = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ediHldFlg = null;
	/* Column Info */
	private String spclHideFlg = null;
	/* Column Info */
	private String hngrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public searchBkgForSplitVO() {}

	public searchBkgForSplitVO(String ibflag, String pagerows, String bkgNo, String blNo, String bkgCgoTpCd, String tvvd, String firstVvd, String porCd, String polCd, String podCd, String delCd, String stwgCd, String hngrFlg, String stopOffLocCd, String railBlkCd, String hotDeFlg, String spclHideFlg, String fdGrdFlg, String prctFlg, String remark, String actWgt, String wgtUtCd, String pckQty, String pckTpCd, String measQty, String measUtCd, String dg, String rf, String ak, String bb, String pctlNo, String bdrFlg, String troFlg, String advShtgCd, String splitFlg, String bkgStsCd, String troTp, String bkgClose, String oblIssFlg, String ediHldFlg, String ltFlg) {
		this.splitFlg = splitFlg;
		this.porCd = porCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.stopOffLocCd = stopOffLocCd;
		this.remark = remark;
		this.bkgStsCd = bkgStsCd;
		this.bdrFlg = bdrFlg;
		this.fdGrdFlg = fdGrdFlg;
		this.rf = rf;
		this.advShtgCd = advShtgCd;
		this.blNo = blNo;
		this.pctlNo = pctlNo;
		this.pagerows = pagerows;
		this.hotDeFlg = hotDeFlg;
		this.dg = dg;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.railBlkCd = railBlkCd;
		this.prctFlg = prctFlg;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.stwgCd = stwgCd;
		this.bb = bb;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.troFlg = troFlg;
		this.troTp = troTp;
		this.oblIssFlg = oblIssFlg;
		this.firstVvd = firstVvd;
		this.delCd = delCd;
		this.tvvd = tvvd;
		this.ltFlg = ltFlg;
		this.actWgt = actWgt;
		this.bkgClose = bkgClose;
		this.ak = ak;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.ediHldFlg = ediHldFlg;
		this.spclHideFlg = spclHideFlg;
		this.hngrFlg = hngrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("stop_off_loc_cd", getStopOffLocCd());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("fd_grd_flg", getFdGrdFlg());
		this.hashColumns.put("rf", getRf());
		this.hashColumns.put("adv_shtg_cd", getAdvShtgCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hot_de_flg", getHotDeFlg());
		this.hashColumns.put("dg", getDg());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rail_blk_cd", getRailBlkCd());
		this.hashColumns.put("prct_flg", getPrctFlg());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("bb", getBb());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("tro_flg", getTroFlg());
		this.hashColumns.put("tro_tp", getTroTp());
		this.hashColumns.put("obl_iss_flg", getOblIssFlg());
		this.hashColumns.put("first_vvd", getFirstVvd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("tvvd", getTvvd());
		this.hashColumns.put("lt_flg", getLtFlg());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("bkg_close", getBkgClose());
		this.hashColumns.put("ak", getAk());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("edi_hld_flg", getEdiHldFlg());
		this.hashColumns.put("spcl_hide_flg", getSpclHideFlg());
		this.hashColumns.put("hngr_flg", getHngrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("stop_off_loc_cd", "stopOffLocCd");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("fd_grd_flg", "fdGrdFlg");
		this.hashFields.put("rf", "rf");
		this.hashFields.put("adv_shtg_cd", "advShtgCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hot_de_flg", "hotDeFlg");
		this.hashFields.put("dg", "dg");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rail_blk_cd", "railBlkCd");
		this.hashFields.put("prct_flg", "prctFlg");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("bb", "bb");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("tro_flg", "troFlg");
		this.hashFields.put("tro_tp", "troTp");
		this.hashFields.put("obl_iss_flg", "oblIssFlg");
		this.hashFields.put("first_vvd", "firstVvd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("lt_flg", "ltFlg");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("bkg_close", "bkgClose");
		this.hashFields.put("ak", "ak");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("edi_hld_flg", "ediHldFlg");
		this.hashFields.put("spcl_hide_flg", "spclHideFlg");
		this.hashFields.put("hngr_flg", "hngrFlg");
		return this.hashFields;
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return stopOffLocCd
	 */
	public String getStopOffLocCd() {
		return this.stopOffLocCd;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
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
	 * @return fdGrdFlg
	 */
	public String getFdGrdFlg() {
		return this.fdGrdFlg;
	}
	
	/**
	 * Column Info
	 * @return rf
	 */
	public String getRf() {
		return this.rf;
	}
	
	/**
	 * Column Info
	 * @return advShtgCd
	 */
	public String getAdvShtgCd() {
		return this.advShtgCd;
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
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
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
	 * @return hotDeFlg
	 */
	public String getHotDeFlg() {
		return this.hotDeFlg;
	}
	
	/**
	 * Column Info
	 * @return dg
	 */
	public String getDg() {
		return this.dg;
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
	 * @return railBlkCd
	 */
	public String getRailBlkCd() {
		return this.railBlkCd;
	}
	
	/**
	 * Column Info
	 * @return prctFlg
	 */
	public String getPrctFlg() {
		return this.prctFlg;
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
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
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
	 * @return bb
	 */
	public String getBb() {
		return this.bb;
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
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return troFlg
	 */
	public String getTroFlg() {
		return this.troFlg;
	}
	
	/**
	 * Column Info
	 * @return troTp
	 */
	public String getTroTp() {
		return this.troTp;
	}
	
	/**
	 * Column Info
	 * @return oblIssFlg
	 */
	public String getOblIssFlg() {
		return this.oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @return firstVvd
	 */
	public String getFirstVvd() {
		return this.firstVvd;
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
	 * @return tvvd
	 */
	public String getTvvd() {
		return this.tvvd;
	}
	
	/**
	 * Column Info
	 * @return ltFlg
	 */
	public String getLtFlg() {
		return this.ltFlg;
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
	 * @return bkgClose
	 */
	public String getBkgClose() {
		return this.bkgClose;
	}
	
	/**
	 * Column Info
	 * @return ak
	 */
	public String getAk() {
		return this.ak;
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
	 * @return ediHldFlg
	 */
	public String getEdiHldFlg() {
		return this.ediHldFlg;
	}
	
	/**
	 * Column Info
	 * @return spclHideFlg
	 */
	public String getSpclHideFlg() {
		return this.spclHideFlg;
	}
	
	/**
	 * Column Info
	 * @return hngrFlg
	 */
	public String getHngrFlg() {
		return this.hngrFlg;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
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
	 * @param stopOffLocCd
	 */
	public void setStopOffLocCd(String stopOffLocCd) {
		this.stopOffLocCd = stopOffLocCd;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * @param fdGrdFlg
	 */
	public void setFdGrdFlg(String fdGrdFlg) {
		this.fdGrdFlg = fdGrdFlg;
	}
	
	/**
	 * Column Info
	 * @param rf
	 */
	public void setRf(String rf) {
		this.rf = rf;
	}
	
	/**
	 * Column Info
	 * @param advShtgCd
	 */
	public void setAdvShtgCd(String advShtgCd) {
		this.advShtgCd = advShtgCd;
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
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
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
	 * @param hotDeFlg
	 */
	public void setHotDeFlg(String hotDeFlg) {
		this.hotDeFlg = hotDeFlg;
	}
	
	/**
	 * Column Info
	 * @param dg
	 */
	public void setDg(String dg) {
		this.dg = dg;
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
	 * @param railBlkCd
	 */
	public void setRailBlkCd(String railBlkCd) {
		this.railBlkCd = railBlkCd;
	}
	
	/**
	 * Column Info
	 * @param prctFlg
	 */
	public void setPrctFlg(String prctFlg) {
		this.prctFlg = prctFlg;
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
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
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
	 * @param bb
	 */
	public void setBb(String bb) {
		this.bb = bb;
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
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param troFlg
	 */
	public void setTroFlg(String troFlg) {
		this.troFlg = troFlg;
	}
	
	/**
	 * Column Info
	 * @param troTp
	 */
	public void setTroTp(String troTp) {
		this.troTp = troTp;
	}
	
	/**
	 * Column Info
	 * @param oblIssFlg
	 */
	public void setOblIssFlg(String oblIssFlg) {
		this.oblIssFlg = oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @param firstVvd
	 */
	public void setFirstVvd(String firstVvd) {
		this.firstVvd = firstVvd;
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
	 * @param tvvd
	 */
	public void setTvvd(String tvvd) {
		this.tvvd = tvvd;
	}
	
	/**
	 * Column Info
	 * @param ltFlg
	 */
	public void setLtFlg(String ltFlg) {
		this.ltFlg = ltFlg;
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
	 * @param bkgClose
	 */
	public void setBkgClose(String bkgClose) {
		this.bkgClose = bkgClose;
	}
	
	/**
	 * Column Info
	 * @param ak
	 */
	public void setAk(String ak) {
		this.ak = ak;
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
	 * @param ediHldFlg
	 */
	public void setEdiHldFlg(String ediHldFlg) {
		this.ediHldFlg = ediHldFlg;
	}
	
	/**
	 * Column Info
	 * @param spclHideFlg
	 */
	public void setSpclHideFlg(String spclHideFlg) {
		this.spclHideFlg = spclHideFlg;
	}
	
	/**
	 * Column Info
	 * @param hngrFlg
	 */
	public void setHngrFlg(String hngrFlg) {
		this.hngrFlg = hngrFlg;
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
		setSplitFlg(JSPUtil.getParameter(request, prefix + "split_flg", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setStopOffLocCd(JSPUtil.getParameter(request, prefix + "stop_off_loc_cd", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setFdGrdFlg(JSPUtil.getParameter(request, prefix + "fd_grd_flg", ""));
		setRf(JSPUtil.getParameter(request, prefix + "rf", ""));
		setAdvShtgCd(JSPUtil.getParameter(request, prefix + "adv_shtg_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setHotDeFlg(JSPUtil.getParameter(request, prefix + "hot_de_flg", ""));
		setDg(JSPUtil.getParameter(request, prefix + "dg", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRailBlkCd(JSPUtil.getParameter(request, prefix + "rail_blk_cd", ""));
		setPrctFlg(JSPUtil.getParameter(request, prefix + "prct_flg", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
		setBb(JSPUtil.getParameter(request, prefix + "bb", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setTroFlg(JSPUtil.getParameter(request, prefix + "tro_flg", ""));
		setTroTp(JSPUtil.getParameter(request, prefix + "tro_tp", ""));
		setOblIssFlg(JSPUtil.getParameter(request, prefix + "obl_iss_flg", ""));
		setFirstVvd(JSPUtil.getParameter(request, prefix + "first_vvd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setTvvd(JSPUtil.getParameter(request, prefix + "tvvd", ""));
		setLtFlg(JSPUtil.getParameter(request, prefix + "lt_flg", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setBkgClose(JSPUtil.getParameter(request, prefix + "bkg_close", ""));
		setAk(JSPUtil.getParameter(request, prefix + "ak", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setEdiHldFlg(JSPUtil.getParameter(request, prefix + "edi_hld_flg", ""));
		setSpclHideFlg(JSPUtil.getParameter(request, prefix + "spcl_hide_flg", ""));
		setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchBkgForSplitVO[]
	 */
	public searchBkgForSplitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchBkgForSplitVO[]
	 */
	public searchBkgForSplitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		searchBkgForSplitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] stopOffLocCd = (JSPUtil.getParameter(request, prefix	+ "stop_off_loc_cd", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] fdGrdFlg = (JSPUtil.getParameter(request, prefix	+ "fd_grd_flg", length));
			String[] rf = (JSPUtil.getParameter(request, prefix	+ "rf", length));
			String[] advShtgCd = (JSPUtil.getParameter(request, prefix	+ "adv_shtg_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hotDeFlg = (JSPUtil.getParameter(request, prefix	+ "hot_de_flg", length));
			String[] dg = (JSPUtil.getParameter(request, prefix	+ "dg", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] railBlkCd = (JSPUtil.getParameter(request, prefix	+ "rail_blk_cd", length));
			String[] prctFlg = (JSPUtil.getParameter(request, prefix	+ "prct_flg", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] bb = (JSPUtil.getParameter(request, prefix	+ "bb", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] troFlg = (JSPUtil.getParameter(request, prefix	+ "tro_flg", length));
			String[] troTp = (JSPUtil.getParameter(request, prefix	+ "tro_tp", length));
			String[] oblIssFlg = (JSPUtil.getParameter(request, prefix	+ "obl_iss_flg", length));
			String[] firstVvd = (JSPUtil.getParameter(request, prefix	+ "first_vvd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] tvvd = (JSPUtil.getParameter(request, prefix	+ "tvvd", length));
			String[] ltFlg = (JSPUtil.getParameter(request, prefix	+ "lt_flg", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] bkgClose = (JSPUtil.getParameter(request, prefix	+ "bkg_close", length));
			String[] ak = (JSPUtil.getParameter(request, prefix	+ "ak", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ediHldFlg = (JSPUtil.getParameter(request, prefix	+ "edi_hld_flg", length));
			String[] spclHideFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_hide_flg", length));
			String[] hngrFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new searchBkgForSplitVO();
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (stopOffLocCd[i] != null)
					model.setStopOffLocCd(stopOffLocCd[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (fdGrdFlg[i] != null)
					model.setFdGrdFlg(fdGrdFlg[i]);
				if (rf[i] != null)
					model.setRf(rf[i]);
				if (advShtgCd[i] != null)
					model.setAdvShtgCd(advShtgCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hotDeFlg[i] != null)
					model.setHotDeFlg(hotDeFlg[i]);
				if (dg[i] != null)
					model.setDg(dg[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (railBlkCd[i] != null)
					model.setRailBlkCd(railBlkCd[i]);
				if (prctFlg[i] != null)
					model.setPrctFlg(prctFlg[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (bb[i] != null)
					model.setBb(bb[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (troFlg[i] != null)
					model.setTroFlg(troFlg[i]);
				if (troTp[i] != null)
					model.setTroTp(troTp[i]);
				if (oblIssFlg[i] != null)
					model.setOblIssFlg(oblIssFlg[i]);
				if (firstVvd[i] != null)
					model.setFirstVvd(firstVvd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (tvvd[i] != null)
					model.setTvvd(tvvd[i]);
				if (ltFlg[i] != null)
					model.setLtFlg(ltFlg[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (bkgClose[i] != null)
					model.setBkgClose(bkgClose[i]);
				if (ak[i] != null)
					model.setAk(ak[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ediHldFlg[i] != null)
					model.setEdiHldFlg(ediHldFlg[i]);
				if (spclHideFlg[i] != null)
					model.setSpclHideFlg(spclHideFlg[i]);
				if (hngrFlg[i] != null)
					model.setHngrFlg(hngrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchBkgForSplitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchBkgForSplitVO[]
	 */
	public searchBkgForSplitVO[] getsearchBkgForSplitVOs(){
		searchBkgForSplitVO[] vos = (searchBkgForSplitVO[])models.toArray(new searchBkgForSplitVO[models.size()]);
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
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stopOffLocCd = this.stopOffLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdGrdFlg = this.fdGrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf = this.rf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advShtgCd = this.advShtgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hotDeFlg = this.hotDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg = this.dg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railBlkCd = this.railBlkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prctFlg = this.prctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb = this.bb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troFlg = this.troFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troTp = this.troTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssFlg = this.oblIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstVvd = this.firstVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvd = this.tvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltFlg = this.ltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgClose = this.bkgClose .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak = this.ak .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediHldFlg = this.ediHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclHideFlg = this.spclHideFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlg = this.hngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
