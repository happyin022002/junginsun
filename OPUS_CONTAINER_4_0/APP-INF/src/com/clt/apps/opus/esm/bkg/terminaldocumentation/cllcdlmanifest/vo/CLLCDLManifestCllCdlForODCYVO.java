/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestCllCdlForODCYVO.java
*@FileTitle : CLLCDLManifestCllCdlForODCYVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.02
*@LastModifier :
*@LastVersion : 1.0
* 2010.08.02
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CLLCDLManifestCllCdlForODCYVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CLLCDLManifestCllCdlForODCYVO> models = new ArrayList<CLLCDLManifestCllCdlForODCYVO>();

	/* Column Info */
	private String marPol = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String bkgHotDelFlg = null;
	/* Column Info */
	private String dgCgoFlag = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String mstBkgNo = null;
	/* Column Info */
	private String cmdyNm = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dmgSts = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dstSvcRout = null;
	/* Column Info */
	private String depotCd = null;
	/* Column Info */
	private String subsiRskFlg = null;
	/* Column Info */
	private String bkgActWgtTpCd = null;
	/* Column Info */
	private String delLoc = null;
	/* Column Info */
	private String carrierVslCd = null;
	/* Column Info */
	private String podLoc = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String humidity = null;
	/* Column Info */
	private String bkgTp = null;
	/* Column Info */
	private String awkFront = null;
	/* Column Info */
	private String split = null;
	/* Column Info */
	private String cstmsRmk = null;
	/* Column Info */
	private String bkgPkgTpCd = null;
	/* Column Info */
	private String rfTemp = null;
	/* Column Info */
	private String cntrWgtQty = null;
	/* Column Info */
	private String bkgMeasQty = null;
	/* Column Info */
	private String awkLeft = null;
	/* Column Info */
	private String socInd = null;
	/* Column Info */
	private String cntrMeasQty = null;
	/* Column Info */
	private String carriersVoyNo = null;
	/* Column Info */
	private String polLoc = null;
	/* Column Info */
	private String atdDt = null;
	/* Column Info */
	private String extRemark = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String rdFlag = null;
	/* Column Info */
	private String bkgActWgt = null;
	/* Column Info */
	private String eqSubFlag = null;
	/* Column Info */
	private String ems = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrMeasTpCd = null;
	/* Column Info */
	private String ataDt = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String bkgMeasTpCd = null;
	/* Column Info */
	private String rfFlag = null;
	/* Column Info */
	private String cntrWgtTpCd = null;
	/* Column Info */
	private String unCd = null;
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String akFlag = null;
	/* Column Info */
	private String vent = null;
	/* Column Info */
	private String dgCls = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String awkHeight = null;
	/* Column Info */
	private String reCmmdNm = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String fshPoint = null;
	/* Column Info */
	private String awkRear = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String laneCode = null;
	/* Column Info */
	private String cntrPkgTpCd = null;
	/* Column Info */
	private String cntrPkgQty = null;
	/* Column Info */
	private String pkgGrp = null;
	/* Column Info */
	private String awkRight = null;
	/* Column Info */
	private String bkgPkgQty = null;
	/* Column Info */
	private String hgFlag = null;
	/* Column Info */
	private String bound = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CLLCDLManifestCllCdlForODCYVO() {}

	public CLLCDLManifestCllCdlForODCYVO(String ibflag, String pagerows, String bound, String bkgNo, String blNo, String split, String atdDt, String ataDt, String awkFront, String awkHeight, String awkLeft, String awkRear, String awkRight, String bkgActWgt, String bkgActWgtTpCd, String bkgCgoTpCd, String bkgHotDelFlg, String bkgMeasQty, String bkgMeasTpCd, String bkgStsCd, String carrierVslCd, String carriersVoyNo, String cmdyNm, String cneeNm, String cntrMeasQty, String cntrMeasTpCd, String cntrNo, String cntrTpszCd, String cntrWgtQty, String cntrWgtTpCd, String cstmsRmk, String delLoc, String depotCd, String dgCls, String dmgSts, String ems, String etaDt, String etdDt, String fshPoint, String humidity, String laneCode, String marPol, String pkgGrp, String bkgPkgQty, String bkgPkgTpCd, String podLoc, String polLoc, String reCmmdNm, String rfTemp, String vent, String sealNo, String shprNm, String socInd, String subsiRskFlg, String unCd, String cntrPkgQty, String cntrPkgTpCd, String dgCgoFlag, String rfFlag, String akFlag, String hgFlag, String eqSubFlag, String rdFlag, String dstSvcRout, String extRemark, String bkgTp, String mstBkgNo) {
		this.marPol = marPol;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.bkgHotDelFlg = bkgHotDelFlg;
		this.dgCgoFlag = dgCgoFlag;
		this.etaDt = etaDt;
		this.mstBkgNo = mstBkgNo;
		this.cmdyNm = cmdyNm;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.dmgSts = dmgSts;
		this.cntrTpszCd = cntrTpszCd;
		this.dstSvcRout = dstSvcRout;
		this.depotCd = depotCd;
		this.subsiRskFlg = subsiRskFlg;
		this.bkgActWgtTpCd = bkgActWgtTpCd;
		this.delLoc = delLoc;
		this.carrierVslCd = carrierVslCd;
		this.podLoc = podLoc;
		this.bkgNo = bkgNo;
		this.humidity = humidity;
		this.bkgTp = bkgTp;
		this.awkFront = awkFront;
		this.split = split;
		this.cstmsRmk = cstmsRmk;
		this.bkgPkgTpCd = bkgPkgTpCd;
		this.rfTemp = rfTemp;
		this.cntrWgtQty = cntrWgtQty;
		this.bkgMeasQty = bkgMeasQty;
		this.awkLeft = awkLeft;
		this.socInd = socInd;
		this.cntrMeasQty = cntrMeasQty;
		this.carriersVoyNo = carriersVoyNo;
		this.polLoc = polLoc;
		this.atdDt = atdDt;
		this.extRemark = extRemark;
		this.bkgStsCd = bkgStsCd;
		this.rdFlag = rdFlag;
		this.bkgActWgt = bkgActWgt;
		this.eqSubFlag = eqSubFlag;
		this.ems = ems;
		this.ibflag = ibflag;
		this.cntrMeasTpCd = cntrMeasTpCd;
		this.ataDt = ataDt;
		this.shprNm = shprNm;
		this.bkgMeasTpCd = bkgMeasTpCd;
		this.rfFlag = rfFlag;
		this.cntrWgtTpCd = cntrWgtTpCd;
		this.unCd = unCd;
		this.sealNo = sealNo;
		this.akFlag = akFlag;
		this.vent = vent;
		this.dgCls = dgCls;
		this.etdDt = etdDt;
		this.awkHeight = awkHeight;
		this.reCmmdNm = reCmmdNm;
		this.cneeNm = cneeNm;
		this.fshPoint = fshPoint;
		this.awkRear = awkRear;
		this.cntrNo = cntrNo;
		this.laneCode = laneCode;
		this.cntrPkgTpCd = cntrPkgTpCd;
		this.cntrPkgQty = cntrPkgQty;
		this.pkgGrp = pkgGrp;
		this.awkRight = awkRight;
		this.bkgPkgQty = bkgPkgQty;
		this.hgFlag = hgFlag;
		this.bound = bound;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mar_pol", getMarPol());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("bkg_hot_del_flg", getBkgHotDelFlg());
		this.hashColumns.put("dg_cgo_flag", getDgCgoFlag());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("mst_bkg_no", getMstBkgNo());
		this.hashColumns.put("cmdy_nm", getCmdyNm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dmg_sts", getDmgSts());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dst_svc_rout", getDstSvcRout());
		this.hashColumns.put("depot_cd", getDepotCd());
		this.hashColumns.put("subsi_rsk_flg", getSubsiRskFlg());
		this.hashColumns.put("bkg_act_wgt_tp_cd", getBkgActWgtTpCd());
		this.hashColumns.put("del_loc", getDelLoc());
		this.hashColumns.put("carrier_vsl_cd", getCarrierVslCd());
		this.hashColumns.put("pod_loc", getPodLoc());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("humidity", getHumidity());
		this.hashColumns.put("bkg_tp", getBkgTp());
		this.hashColumns.put("awk_front", getAwkFront());
		this.hashColumns.put("split", getSplit());
		this.hashColumns.put("cstms_rmk", getCstmsRmk());
		this.hashColumns.put("bkg_pkg_tp_cd", getBkgPkgTpCd());
		this.hashColumns.put("rf_temp", getRfTemp());
		this.hashColumns.put("cntr_wgt_qty", getCntrWgtQty());
		this.hashColumns.put("bkg_meas_qty", getBkgMeasQty());
		this.hashColumns.put("awk_left", getAwkLeft());
		this.hashColumns.put("soc_ind", getSocInd());
		this.hashColumns.put("cntr_meas_qty", getCntrMeasQty());
		this.hashColumns.put("carriers_voy_no", getCarriersVoyNo());
		this.hashColumns.put("pol_loc", getPolLoc());
		this.hashColumns.put("atd_dt", getAtdDt());
		this.hashColumns.put("ext_remark", getExtRemark());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("rd_flag", getRdFlag());
		this.hashColumns.put("bkg_act_wgt", getBkgActWgt());
		this.hashColumns.put("eq_sub_flag", getEqSubFlag());
		this.hashColumns.put("ems", getEms());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_meas_tp_cd", getCntrMeasTpCd());
		this.hashColumns.put("ata_dt", getAtaDt());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("bkg_meas_tp_cd", getBkgMeasTpCd());
		this.hashColumns.put("rf_flag", getRfFlag());
		this.hashColumns.put("cntr_wgt_tp_cd", getCntrWgtTpCd());
		this.hashColumns.put("un_cd", getUnCd());
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("ak_flag", getAkFlag());
		this.hashColumns.put("vent", getVent());
		this.hashColumns.put("dg_cls", getDgCls());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("awk_height", getAwkHeight());
		this.hashColumns.put("re_cmmd_nm", getReCmmdNm());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("fsh_point", getFshPoint());
		this.hashColumns.put("awk_rear", getAwkRear());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("lane_code", getLaneCode());
		this.hashColumns.put("cntr_pkg_tp_cd", getCntrPkgTpCd());
		this.hashColumns.put("cntr_pkg_qty", getCntrPkgQty());
		this.hashColumns.put("pkg_grp", getPkgGrp());
		this.hashColumns.put("awk_right", getAwkRight());
		this.hashColumns.put("bkg_pkg_qty", getBkgPkgQty());
		this.hashColumns.put("hg_flag", getHgFlag());
		this.hashColumns.put("bound", getBound());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mar_pol", "marPol");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("bkg_hot_del_flg", "bkgHotDelFlg");
		this.hashFields.put("dg_cgo_flag", "dgCgoFlag");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("mst_bkg_no", "mstBkgNo");
		this.hashFields.put("cmdy_nm", "cmdyNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dmg_sts", "dmgSts");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dst_svc_rout", "dstSvcRout");
		this.hashFields.put("depot_cd", "depotCd");
		this.hashFields.put("subsi_rsk_flg", "subsiRskFlg");
		this.hashFields.put("bkg_act_wgt_tp_cd", "bkgActWgtTpCd");
		this.hashFields.put("del_loc", "delLoc");
		this.hashFields.put("carrier_vsl_cd", "carrierVslCd");
		this.hashFields.put("pod_loc", "podLoc");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("humidity", "humidity");
		this.hashFields.put("bkg_tp", "bkgTp");
		this.hashFields.put("awk_front", "awkFront");
		this.hashFields.put("split", "split");
		this.hashFields.put("cstms_rmk", "cstmsRmk");
		this.hashFields.put("bkg_pkg_tp_cd", "bkgPkgTpCd");
		this.hashFields.put("rf_temp", "rfTemp");
		this.hashFields.put("cntr_wgt_qty", "cntrWgtQty");
		this.hashFields.put("bkg_meas_qty", "bkgMeasQty");
		this.hashFields.put("awk_left", "awkLeft");
		this.hashFields.put("soc_ind", "socInd");
		this.hashFields.put("cntr_meas_qty", "cntrMeasQty");
		this.hashFields.put("carriers_voy_no", "carriersVoyNo");
		this.hashFields.put("pol_loc", "polLoc");
		this.hashFields.put("atd_dt", "atdDt");
		this.hashFields.put("ext_remark", "extRemark");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("rd_flag", "rdFlag");
		this.hashFields.put("bkg_act_wgt", "bkgActWgt");
		this.hashFields.put("eq_sub_flag", "eqSubFlag");
		this.hashFields.put("ems", "ems");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_meas_tp_cd", "cntrMeasTpCd");
		this.hashFields.put("ata_dt", "ataDt");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("bkg_meas_tp_cd", "bkgMeasTpCd");
		this.hashFields.put("rf_flag", "rfFlag");
		this.hashFields.put("cntr_wgt_tp_cd", "cntrWgtTpCd");
		this.hashFields.put("un_cd", "unCd");
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("ak_flag", "akFlag");
		this.hashFields.put("vent", "vent");
		this.hashFields.put("dg_cls", "dgCls");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("awk_height", "awkHeight");
		this.hashFields.put("re_cmmd_nm", "reCmmdNm");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("fsh_point", "fshPoint");
		this.hashFields.put("awk_rear", "awkRear");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("lane_code", "laneCode");
		this.hashFields.put("cntr_pkg_tp_cd", "cntrPkgTpCd");
		this.hashFields.put("cntr_pkg_qty", "cntrPkgQty");
		this.hashFields.put("pkg_grp", "pkgGrp");
		this.hashFields.put("awk_right", "awkRight");
		this.hashFields.put("bkg_pkg_qty", "bkgPkgQty");
		this.hashFields.put("hg_flag", "hgFlag");
		this.hashFields.put("bound", "bound");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return marPol
	 */
	public String getMarPol() {
		return this.marPol;
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
	 * @return bkgHotDelFlg
	 */
	public String getBkgHotDelFlg() {
		return this.bkgHotDelFlg;
	}

	/**
	 * Column Info
	 * @return dgCgoFlag
	 */
	public String getDgCgoFlag() {
		return this.dgCgoFlag;
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
	 * @return mstBkgNo
	 */
	public String getMstBkgNo() {
		return this.mstBkgNo;
	}

	/**
	 * Column Info
	 * @return cmdyNm
	 */
	public String getCmdyNm() {
		return this.cmdyNm;
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
	 * @return dmgSts
	 */
	public String getDmgSts() {
		return this.dmgSts;
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
	 * @return dstSvcRout
	 */
	public String getDstSvcRout() {
		return this.dstSvcRout;
	}

	/**
	 * Column Info
	 * @return depotCd
	 */
	public String getDepotCd() {
		return this.depotCd;
	}

	/**
	 * Column Info
	 * @return subsiRskFlg
	 */
	public String getSubsiRskFlg() {
		return this.subsiRskFlg;
	}

	/**
	 * Column Info
	 * @return bkgActWgtTpCd
	 */
	public String getBkgActWgtTpCd() {
		return this.bkgActWgtTpCd;
	}

	/**
	 * Column Info
	 * @return delLoc
	 */
	public String getDelLoc() {
		return this.delLoc;
	}

	/**
	 * Column Info
	 * @return carrierVslCd
	 */
	public String getCarrierVslCd() {
		return this.carrierVslCd;
	}

	/**
	 * Column Info
	 * @return podLoc
	 */
	public String getPodLoc() {
		return this.podLoc;
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
	 * @return humidity
	 */
	public String getHumidity() {
		return this.humidity;
	}

	/**
	 * Column Info
	 * @return bkgTp
	 */
	public String getBkgTp() {
		return this.bkgTp;
	}

	/**
	 * Column Info
	 * @return awkFront
	 */
	public String getAwkFront() {
		return this.awkFront;
	}

	/**
	 * Column Info
	 * @return split
	 */
	public String getSplit() {
		return this.split;
	}

	/**
	 * Column Info
	 * @return cstmsRmk
	 */
	public String getCstmsRmk() {
		return this.cstmsRmk;
	}

	/**
	 * Column Info
	 * @return bkgPkgTpCd
	 */
	public String getBkgPkgTpCd() {
		return this.bkgPkgTpCd;
	}

	/**
	 * Column Info
	 * @return rfTemp
	 */
	public String getRfTemp() {
		return this.rfTemp;
	}

	/**
	 * Column Info
	 * @return cntrWgtQty
	 */
	public String getCntrWgtQty() {
		return this.cntrWgtQty;
	}

	/**
	 * Column Info
	 * @return bkgMeasQty
	 */
	public String getBkgMeasQty() {
		return this.bkgMeasQty;
	}

	/**
	 * Column Info
	 * @return awkLeft
	 */
	public String getAwkLeft() {
		return this.awkLeft;
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
	 * @return cntrMeasQty
	 */
	public String getCntrMeasQty() {
		return this.cntrMeasQty;
	}

	/**
	 * Column Info
	 * @return carriersVoyNo
	 */
	public String getCarriersVoyNo() {
		return this.carriersVoyNo;
	}

	/**
	 * Column Info
	 * @return polLoc
	 */
	public String getPolLoc() {
		return this.polLoc;
	}

	/**
	 * Column Info
	 * @return atdDt
	 */
	public String getAtdDt() {
		return this.atdDt;
	}

	/**
	 * Column Info
	 * @return extRemark
	 */
	public String getExtRemark() {
		return this.extRemark;
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
	 * @return rdFlag
	 */
	public String getRdFlag() {
		return this.rdFlag;
	}

	/**
	 * Column Info
	 * @return bkgActWgt
	 */
	public String getBkgActWgt() {
		return this.bkgActWgt;
	}

	/**
	 * Column Info
	 * @return eqSubFlag
	 */
	public String getEqSubFlag() {
		return this.eqSubFlag;
	}

	/**
	 * Column Info
	 * @return ems
	 */
	public String getEms() {
		return this.ems;
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
	 * @return cntrMeasTpCd
	 */
	public String getCntrMeasTpCd() {
		return this.cntrMeasTpCd;
	}

	/**
	 * Column Info
	 * @return ataDt
	 */
	public String getAtaDt() {
		return this.ataDt;
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
	 * @return bkgMeasTpCd
	 */
	public String getBkgMeasTpCd() {
		return this.bkgMeasTpCd;
	}

	/**
	 * Column Info
	 * @return rfFlag
	 */
	public String getRfFlag() {
		return this.rfFlag;
	}

	/**
	 * Column Info
	 * @return cntrWgtTpCd
	 */
	public String getCntrWgtTpCd() {
		return this.cntrWgtTpCd;
	}

	/**
	 * Column Info
	 * @return unCd
	 */
	public String getUnCd() {
		return this.unCd;
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
	 * @return akFlag
	 */
	public String getAkFlag() {
		return this.akFlag;
	}

	/**
	 * Column Info
	 * @return vent
	 */
	public String getVent() {
		return this.vent;
	}

	/**
	 * Column Info
	 * @return dgCls
	 */
	public String getDgCls() {
		return this.dgCls;
	}

	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}

	/**
	 * Column Info
	 * @return awkHeight
	 */
	public String getAwkHeight() {
		return this.awkHeight;
	}

	/**
	 * Column Info
	 * @return reCmmdNm
	 */
	public String getReCmmdNm() {
		return this.reCmmdNm;
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
	 * @return fshPoint
	 */
	public String getFshPoint() {
		return this.fshPoint;
	}

	/**
	 * Column Info
	 * @return awkRear
	 */
	public String getAwkRear() {
		return this.awkRear;
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
	 * @return laneCode
	 */
	public String getLaneCode() {
		return this.laneCode;
	}

	/**
	 * Column Info
	 * @return cntrPkgTpCd
	 */
	public String getCntrPkgTpCd() {
		return this.cntrPkgTpCd;
	}

	/**
	 * Column Info
	 * @return cntrPkgQty
	 */
	public String getCntrPkgQty() {
		return this.cntrPkgQty;
	}

	/**
	 * Column Info
	 * @return pkgGrp
	 */
	public String getPkgGrp() {
		return this.pkgGrp;
	}

	/**
	 * Column Info
	 * @return awkRight
	 */
	public String getAwkRight() {
		return this.awkRight;
	}

	/**
	 * Column Info
	 * @return bkgPkgQty
	 */
	public String getBkgPkgQty() {
		return this.bkgPkgQty;
	}

	/**
	 * Column Info
	 * @return hgFlag
	 */
	public String getHgFlag() {
		return this.hgFlag;
	}

	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}


	/**
	 * Column Info
	 * @param marPol
	 */
	public void setMarPol(String marPol) {
		this.marPol = marPol;
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
	 * @param bkgHotDelFlg
	 */
	public void setBkgHotDelFlg(String bkgHotDelFlg) {
		this.bkgHotDelFlg = bkgHotDelFlg;
	}

	/**
	 * Column Info
	 * @param dgCgoFlag
	 */
	public void setDgCgoFlag(String dgCgoFlag) {
		this.dgCgoFlag = dgCgoFlag;
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
	 * @param mstBkgNo
	 */
	public void setMstBkgNo(String mstBkgNo) {
		this.mstBkgNo = mstBkgNo;
	}

	/**
	 * Column Info
	 * @param cmdyNm
	 */
	public void setCmdyNm(String cmdyNm) {
		this.cmdyNm = cmdyNm;
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
	 * @param dmgSts
	 */
	public void setDmgSts(String dmgSts) {
		this.dmgSts = dmgSts;
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
	 * @param dstSvcRout
	 */
	public void setDstSvcRout(String dstSvcRout) {
		this.dstSvcRout = dstSvcRout;
	}

	/**
	 * Column Info
	 * @param depotCd
	 */
	public void setDepotCd(String depotCd) {
		this.depotCd = depotCd;
	}

	/**
	 * Column Info
	 * @param subsiRskFlg
	 */
	public void setSubsiRskFlg(String subsiRskFlg) {
		this.subsiRskFlg = subsiRskFlg;
	}

	/**
	 * Column Info
	 * @param bkgActWgtTpCd
	 */
	public void setBkgActWgtTpCd(String bkgActWgtTpCd) {
		this.bkgActWgtTpCd = bkgActWgtTpCd;
	}

	/**
	 * Column Info
	 * @param delLoc
	 */
	public void setDelLoc(String delLoc) {
		this.delLoc = delLoc;
	}

	/**
	 * Column Info
	 * @param carrierVslCd
	 */
	public void setCarrierVslCd(String carrierVslCd) {
		this.carrierVslCd = carrierVslCd;
	}

	/**
	 * Column Info
	 * @param podLoc
	 */
	public void setPodLoc(String podLoc) {
		this.podLoc = podLoc;
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
	 * @param humidity
	 */
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	/**
	 * Column Info
	 * @param bkgTp
	 */
	public void setBkgTp(String bkgTp) {
		this.bkgTp = bkgTp;
	}

	/**
	 * Column Info
	 * @param awkFront
	 */
	public void setAwkFront(String awkFront) {
		this.awkFront = awkFront;
	}

	/**
	 * Column Info
	 * @param split
	 */
	public void setSplit(String split) {
		this.split = split;
	}

	/**
	 * Column Info
	 * @param cstmsRmk
	 */
	public void setCstmsRmk(String cstmsRmk) {
		this.cstmsRmk = cstmsRmk;
	}

	/**
	 * Column Info
	 * @param bkgPkgTpCd
	 */
	public void setBkgPkgTpCd(String bkgPkgTpCd) {
		this.bkgPkgTpCd = bkgPkgTpCd;
	}

	/**
	 * Column Info
	 * @param rfTemp
	 */
	public void setRfTemp(String rfTemp) {
		this.rfTemp = rfTemp;
	}

	/**
	 * Column Info
	 * @param cntrWgtQty
	 */
	public void setCntrWgtQty(String cntrWgtQty) {
		this.cntrWgtQty = cntrWgtQty;
	}

	/**
	 * Column Info
	 * @param bkgMeasQty
	 */
	public void setBkgMeasQty(String bkgMeasQty) {
		this.bkgMeasQty = bkgMeasQty;
	}

	/**
	 * Column Info
	 * @param awkLeft
	 */
	public void setAwkLeft(String awkLeft) {
		this.awkLeft = awkLeft;
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
	 * @param cntrMeasQty
	 */
	public void setCntrMeasQty(String cntrMeasQty) {
		this.cntrMeasQty = cntrMeasQty;
	}

	/**
	 * Column Info
	 * @param carriersVoyNo
	 */
	public void setCarriersVoyNo(String carriersVoyNo) {
		this.carriersVoyNo = carriersVoyNo;
	}

	/**
	 * Column Info
	 * @param polLoc
	 */
	public void setPolLoc(String polLoc) {
		this.polLoc = polLoc;
	}

	/**
	 * Column Info
	 * @param atdDt
	 */
	public void setAtdDt(String atdDt) {
		this.atdDt = atdDt;
	}

	/**
	 * Column Info
	 * @param extRemark
	 */
	public void setExtRemark(String extRemark) {
		this.extRemark = extRemark;
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
	 * @param rdFlag
	 */
	public void setRdFlag(String rdFlag) {
		this.rdFlag = rdFlag;
	}

	/**
	 * Column Info
	 * @param bkgActWgt
	 */
	public void setBkgActWgt(String bkgActWgt) {
		this.bkgActWgt = bkgActWgt;
	}

	/**
	 * Column Info
	 * @param eqSubFlag
	 */
	public void setEqSubFlag(String eqSubFlag) {
		this.eqSubFlag = eqSubFlag;
	}

	/**
	 * Column Info
	 * @param ems
	 */
	public void setEms(String ems) {
		this.ems = ems;
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
	 * @param cntrMeasTpCd
	 */
	public void setCntrMeasTpCd(String cntrMeasTpCd) {
		this.cntrMeasTpCd = cntrMeasTpCd;
	}

	/**
	 * Column Info
	 * @param ataDt
	 */
	public void setAtaDt(String ataDt) {
		this.ataDt = ataDt;
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
	 * @param bkgMeasTpCd
	 */
	public void setBkgMeasTpCd(String bkgMeasTpCd) {
		this.bkgMeasTpCd = bkgMeasTpCd;
	}

	/**
	 * Column Info
	 * @param rfFlag
	 */
	public void setRfFlag(String rfFlag) {
		this.rfFlag = rfFlag;
	}

	/**
	 * Column Info
	 * @param cntrWgtTpCd
	 */
	public void setCntrWgtTpCd(String cntrWgtTpCd) {
		this.cntrWgtTpCd = cntrWgtTpCd;
	}

	/**
	 * Column Info
	 * @param unCd
	 */
	public void setUnCd(String unCd) {
		this.unCd = unCd;
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
	 * @param akFlag
	 */
	public void setAkFlag(String akFlag) {
		this.akFlag = akFlag;
	}

	/**
	 * Column Info
	 * @param vent
	 */
	public void setVent(String vent) {
		this.vent = vent;
	}

	/**
	 * Column Info
	 * @param dgCls
	 */
	public void setDgCls(String dgCls) {
		this.dgCls = dgCls;
	}

	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}

	/**
	 * Column Info
	 * @param awkHeight
	 */
	public void setAwkHeight(String awkHeight) {
		this.awkHeight = awkHeight;
	}

	/**
	 * Column Info
	 * @param reCmmdNm
	 */
	public void setReCmmdNm(String reCmmdNm) {
		this.reCmmdNm = reCmmdNm;
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
	 * @param fshPoint
	 */
	public void setFshPoint(String fshPoint) {
		this.fshPoint = fshPoint;
	}

	/**
	 * Column Info
	 * @param awkRear
	 */
	public void setAwkRear(String awkRear) {
		this.awkRear = awkRear;
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
	 * @param laneCode
	 */
	public void setLaneCode(String laneCode) {
		this.laneCode = laneCode;
	}

	/**
	 * Column Info
	 * @param cntrPkgTpCd
	 */
	public void setCntrPkgTpCd(String cntrPkgTpCd) {
		this.cntrPkgTpCd = cntrPkgTpCd;
	}

	/**
	 * Column Info
	 * @param cntrPkgQty
	 */
	public void setCntrPkgQty(String cntrPkgQty) {
		this.cntrPkgQty = cntrPkgQty;
	}

	/**
	 * Column Info
	 * @param pkgGrp
	 */
	public void setPkgGrp(String pkgGrp) {
		this.pkgGrp = pkgGrp;
	}

	/**
	 * Column Info
	 * @param awkRight
	 */
	public void setAwkRight(String awkRight) {
		this.awkRight = awkRight;
	}

	/**
	 * Column Info
	 * @param bkgPkgQty
	 */
	public void setBkgPkgQty(String bkgPkgQty) {
		this.bkgPkgQty = bkgPkgQty;
	}

	/**
	 * Column Info
	 * @param hgFlag
	 */
	public void setHgFlag(String hgFlag) {
		this.hgFlag = hgFlag;
	}

	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
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
		setMarPol(JSPUtil.getParameter(request, prefix + "mar_pol", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setBkgHotDelFlg(JSPUtil.getParameter(request, prefix + "bkg_hot_del_flg", ""));
		setDgCgoFlag(JSPUtil.getParameter(request, prefix + "dg_cgo_flag", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setMstBkgNo(JSPUtil.getParameter(request, prefix + "mst_bkg_no", ""));
		setCmdyNm(JSPUtil.getParameter(request, prefix + "cmdy_nm", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDmgSts(JSPUtil.getParameter(request, prefix + "dmg_sts", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDstSvcRout(JSPUtil.getParameter(request, prefix + "dst_svc_rout", ""));
		setDepotCd(JSPUtil.getParameter(request, prefix + "depot_cd", ""));
		setSubsiRskFlg(JSPUtil.getParameter(request, prefix + "subsi_rsk_flg", ""));
		setBkgActWgtTpCd(JSPUtil.getParameter(request, prefix + "bkg_act_wgt_tp_cd", ""));
		setDelLoc(JSPUtil.getParameter(request, prefix + "del_loc", ""));
		setCarrierVslCd(JSPUtil.getParameter(request, prefix + "carrier_vsl_cd", ""));
		setPodLoc(JSPUtil.getParameter(request, prefix + "pod_loc", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setHumidity(JSPUtil.getParameter(request, prefix + "humidity", ""));
		setBkgTp(JSPUtil.getParameter(request, prefix + "bkg_tp", ""));
		setAwkFront(JSPUtil.getParameter(request, prefix + "awk_front", ""));
		setSplit(JSPUtil.getParameter(request, prefix + "split", ""));
		setCstmsRmk(JSPUtil.getParameter(request, prefix + "cstms_rmk", ""));
		setBkgPkgTpCd(JSPUtil.getParameter(request, prefix + "bkg_pkg_tp_cd", ""));
		setRfTemp(JSPUtil.getParameter(request, prefix + "rf_temp", ""));
		setCntrWgtQty(JSPUtil.getParameter(request, prefix + "cntr_wgt_qty", ""));
		setBkgMeasQty(JSPUtil.getParameter(request, prefix + "bkg_meas_qty", ""));
		setAwkLeft(JSPUtil.getParameter(request, prefix + "awk_left", ""));
		setSocInd(JSPUtil.getParameter(request, prefix + "soc_ind", ""));
		setCntrMeasQty(JSPUtil.getParameter(request, prefix + "cntr_meas_qty", ""));
		setCarriersVoyNo(JSPUtil.getParameter(request, prefix + "carriers_voy_no", ""));
		setPolLoc(JSPUtil.getParameter(request, prefix + "pol_loc", ""));
		setAtdDt(JSPUtil.getParameter(request, prefix + "atd_dt", ""));
		setExtRemark(JSPUtil.getParameter(request, prefix + "ext_remark", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setRdFlag(JSPUtil.getParameter(request, prefix + "rd_flag", ""));
		setBkgActWgt(JSPUtil.getParameter(request, prefix + "bkg_act_wgt", ""));
		setEqSubFlag(JSPUtil.getParameter(request, prefix + "eq_sub_flag", ""));
		setEms(JSPUtil.getParameter(request, prefix + "ems", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrMeasTpCd(JSPUtil.getParameter(request, prefix + "cntr_meas_tp_cd", ""));
		setAtaDt(JSPUtil.getParameter(request, prefix + "ata_dt", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setBkgMeasTpCd(JSPUtil.getParameter(request, prefix + "bkg_meas_tp_cd", ""));
		setRfFlag(JSPUtil.getParameter(request, prefix + "rf_flag", ""));
		setCntrWgtTpCd(JSPUtil.getParameter(request, prefix + "cntr_wgt_tp_cd", ""));
		setUnCd(JSPUtil.getParameter(request, prefix + "un_cd", ""));
		setSealNo(JSPUtil.getParameter(request, prefix + "seal_no", ""));
		setAkFlag(JSPUtil.getParameter(request, prefix + "ak_flag", ""));
		setVent(JSPUtil.getParameter(request, prefix + "vent", ""));
		setDgCls(JSPUtil.getParameter(request, prefix + "dg_cls", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setAwkHeight(JSPUtil.getParameter(request, prefix + "awk_height", ""));
		setReCmmdNm(JSPUtil.getParameter(request, prefix + "re_cmmd_nm", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setFshPoint(JSPUtil.getParameter(request, prefix + "fsh_point", ""));
		setAwkRear(JSPUtil.getParameter(request, prefix + "awk_rear", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setLaneCode(JSPUtil.getParameter(request, prefix + "lane_code", ""));
		setCntrPkgTpCd(JSPUtil.getParameter(request, prefix + "cntr_pkg_tp_cd", ""));
		setCntrPkgQty(JSPUtil.getParameter(request, prefix + "cntr_pkg_qty", ""));
		setPkgGrp(JSPUtil.getParameter(request, prefix + "pkg_grp", ""));
		setAwkRight(JSPUtil.getParameter(request, prefix + "awk_right", ""));
		setBkgPkgQty(JSPUtil.getParameter(request, prefix + "bkg_pkg_qty", ""));
		setHgFlag(JSPUtil.getParameter(request, prefix + "hg_flag", ""));
		setBound(JSPUtil.getParameter(request, prefix + "bound", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CLLCDLManifestCllCdlForODCYVO[]
	 */
	public CLLCDLManifestCllCdlForODCYVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CLLCDLManifestCllCdlForODCYVO[]
	 */
	public CLLCDLManifestCllCdlForODCYVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CLLCDLManifestCllCdlForODCYVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] marPol = (JSPUtil.getParameter(request, prefix	+ "mar_pol", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] bkgHotDelFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_hot_del_flg", length));
			String[] dgCgoFlag = (JSPUtil.getParameter(request, prefix	+ "dg_cgo_flag", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] mstBkgNo = (JSPUtil.getParameter(request, prefix	+ "mst_bkg_no", length));
			String[] cmdyNm = (JSPUtil.getParameter(request, prefix	+ "cmdy_nm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dmgSts = (JSPUtil.getParameter(request, prefix	+ "dmg_sts", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dstSvcRout = (JSPUtil.getParameter(request, prefix	+ "dst_svc_rout", length));
			String[] depotCd = (JSPUtil.getParameter(request, prefix	+ "depot_cd", length));
			String[] subsiRskFlg = (JSPUtil.getParameter(request, prefix	+ "subsi_rsk_flg", length));
			String[] bkgActWgtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_act_wgt_tp_cd", length));
			String[] delLoc = (JSPUtil.getParameter(request, prefix	+ "del_loc", length));
			String[] carrierVslCd = (JSPUtil.getParameter(request, prefix	+ "carrier_vsl_cd", length));
			String[] podLoc = (JSPUtil.getParameter(request, prefix	+ "pod_loc", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] humidity = (JSPUtil.getParameter(request, prefix	+ "humidity", length));
			String[] bkgTp = (JSPUtil.getParameter(request, prefix	+ "bkg_tp", length));
			String[] awkFront = (JSPUtil.getParameter(request, prefix	+ "awk_front", length));
			String[] split = (JSPUtil.getParameter(request, prefix	+ "split", length));
			String[] cstmsRmk = (JSPUtil.getParameter(request, prefix	+ "cstms_rmk", length));
			String[] bkgPkgTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pkg_tp_cd", length));
			String[] rfTemp = (JSPUtil.getParameter(request, prefix	+ "rf_temp", length));
			String[] cntrWgtQty = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_qty", length));
			String[] bkgMeasQty = (JSPUtil.getParameter(request, prefix	+ "bkg_meas_qty", length));
			String[] awkLeft = (JSPUtil.getParameter(request, prefix	+ "awk_left", length));
			String[] socInd = (JSPUtil.getParameter(request, prefix	+ "soc_ind", length));
			String[] cntrMeasQty = (JSPUtil.getParameter(request, prefix	+ "cntr_meas_qty", length));
			String[] carriersVoyNo = (JSPUtil.getParameter(request, prefix	+ "carriers_voy_no", length));
			String[] polLoc = (JSPUtil.getParameter(request, prefix	+ "pol_loc", length));
			String[] atdDt = (JSPUtil.getParameter(request, prefix	+ "atd_dt", length));
			String[] extRemark = (JSPUtil.getParameter(request, prefix	+ "ext_remark", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] rdFlag = (JSPUtil.getParameter(request, prefix	+ "rd_flag", length));
			String[] bkgActWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_act_wgt", length));
			String[] eqSubFlag = (JSPUtil.getParameter(request, prefix	+ "eq_sub_flag", length));
			String[] ems = (JSPUtil.getParameter(request, prefix	+ "ems", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrMeasTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_meas_tp_cd", length));
			String[] ataDt = (JSPUtil.getParameter(request, prefix	+ "ata_dt", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] bkgMeasTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_meas_tp_cd", length));
			String[] rfFlag = (JSPUtil.getParameter(request, prefix	+ "rf_flag", length));
			String[] cntrWgtTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_tp_cd", length));
			String[] unCd = (JSPUtil.getParameter(request, prefix	+ "un_cd", length));
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] akFlag = (JSPUtil.getParameter(request, prefix	+ "ak_flag", length));
			String[] vent = (JSPUtil.getParameter(request, prefix	+ "vent", length));
			String[] dgCls = (JSPUtil.getParameter(request, prefix	+ "dg_cls", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] awkHeight = (JSPUtil.getParameter(request, prefix	+ "awk_height", length));
			String[] reCmmdNm = (JSPUtil.getParameter(request, prefix	+ "re_cmmd_nm", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] fshPoint = (JSPUtil.getParameter(request, prefix	+ "fsh_point", length));
			String[] awkRear = (JSPUtil.getParameter(request, prefix	+ "awk_rear", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] laneCode = (JSPUtil.getParameter(request, prefix	+ "lane_code", length));
			String[] cntrPkgTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_pkg_tp_cd", length));
			String[] cntrPkgQty = (JSPUtil.getParameter(request, prefix	+ "cntr_pkg_qty", length));
			String[] pkgGrp = (JSPUtil.getParameter(request, prefix	+ "pkg_grp", length));
			String[] awkRight = (JSPUtil.getParameter(request, prefix	+ "awk_right", length));
			String[] bkgPkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_pkg_qty", length));
			String[] hgFlag = (JSPUtil.getParameter(request, prefix	+ "hg_flag", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));

			for (int i = 0; i < length; i++) {
				model = new CLLCDLManifestCllCdlForODCYVO();
				if (marPol[i] != null)
					model.setMarPol(marPol[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (bkgHotDelFlg[i] != null)
					model.setBkgHotDelFlg(bkgHotDelFlg[i]);
				if (dgCgoFlag[i] != null)
					model.setDgCgoFlag(dgCgoFlag[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (mstBkgNo[i] != null)
					model.setMstBkgNo(mstBkgNo[i]);
				if (cmdyNm[i] != null)
					model.setCmdyNm(cmdyNm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dmgSts[i] != null)
					model.setDmgSts(dmgSts[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dstSvcRout[i] != null)
					model.setDstSvcRout(dstSvcRout[i]);
				if (depotCd[i] != null)
					model.setDepotCd(depotCd[i]);
				if (subsiRskFlg[i] != null)
					model.setSubsiRskFlg(subsiRskFlg[i]);
				if (bkgActWgtTpCd[i] != null)
					model.setBkgActWgtTpCd(bkgActWgtTpCd[i]);
				if (delLoc[i] != null)
					model.setDelLoc(delLoc[i]);
				if (carrierVslCd[i] != null)
					model.setCarrierVslCd(carrierVslCd[i]);
				if (podLoc[i] != null)
					model.setPodLoc(podLoc[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (humidity[i] != null)
					model.setHumidity(humidity[i]);
				if (bkgTp[i] != null)
					model.setBkgTp(bkgTp[i]);
				if (awkFront[i] != null)
					model.setAwkFront(awkFront[i]);
				if (split[i] != null)
					model.setSplit(split[i]);
				if (cstmsRmk[i] != null)
					model.setCstmsRmk(cstmsRmk[i]);
				if (bkgPkgTpCd[i] != null)
					model.setBkgPkgTpCd(bkgPkgTpCd[i]);
				if (rfTemp[i] != null)
					model.setRfTemp(rfTemp[i]);
				if (cntrWgtQty[i] != null)
					model.setCntrWgtQty(cntrWgtQty[i]);
				if (bkgMeasQty[i] != null)
					model.setBkgMeasQty(bkgMeasQty[i]);
				if (awkLeft[i] != null)
					model.setAwkLeft(awkLeft[i]);
				if (socInd[i] != null)
					model.setSocInd(socInd[i]);
				if (cntrMeasQty[i] != null)
					model.setCntrMeasQty(cntrMeasQty[i]);
				if (carriersVoyNo[i] != null)
					model.setCarriersVoyNo(carriersVoyNo[i]);
				if (polLoc[i] != null)
					model.setPolLoc(polLoc[i]);
				if (atdDt[i] != null)
					model.setAtdDt(atdDt[i]);
				if (extRemark[i] != null)
					model.setExtRemark(extRemark[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (rdFlag[i] != null)
					model.setRdFlag(rdFlag[i]);
				if (bkgActWgt[i] != null)
					model.setBkgActWgt(bkgActWgt[i]);
				if (eqSubFlag[i] != null)
					model.setEqSubFlag(eqSubFlag[i]);
				if (ems[i] != null)
					model.setEms(ems[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrMeasTpCd[i] != null)
					model.setCntrMeasTpCd(cntrMeasTpCd[i]);
				if (ataDt[i] != null)
					model.setAtaDt(ataDt[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (bkgMeasTpCd[i] != null)
					model.setBkgMeasTpCd(bkgMeasTpCd[i]);
				if (rfFlag[i] != null)
					model.setRfFlag(rfFlag[i]);
				if (cntrWgtTpCd[i] != null)
					model.setCntrWgtTpCd(cntrWgtTpCd[i]);
				if (unCd[i] != null)
					model.setUnCd(unCd[i]);
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (akFlag[i] != null)
					model.setAkFlag(akFlag[i]);
				if (vent[i] != null)
					model.setVent(vent[i]);
				if (dgCls[i] != null)
					model.setDgCls(dgCls[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (awkHeight[i] != null)
					model.setAwkHeight(awkHeight[i]);
				if (reCmmdNm[i] != null)
					model.setReCmmdNm(reCmmdNm[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (fshPoint[i] != null)
					model.setFshPoint(fshPoint[i]);
				if (awkRear[i] != null)
					model.setAwkRear(awkRear[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (laneCode[i] != null)
					model.setLaneCode(laneCode[i]);
				if (cntrPkgTpCd[i] != null)
					model.setCntrPkgTpCd(cntrPkgTpCd[i]);
				if (cntrPkgQty[i] != null)
					model.setCntrPkgQty(cntrPkgQty[i]);
				if (pkgGrp[i] != null)
					model.setPkgGrp(pkgGrp[i]);
				if (awkRight[i] != null)
					model.setAwkRight(awkRight[i]);
				if (bkgPkgQty[i] != null)
					model.setBkgPkgQty(bkgPkgQty[i]);
				if (hgFlag[i] != null)
					model.setHgFlag(hgFlag[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCLLCDLManifestCllCdlForODCYVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CLLCDLManifestCllCdlForODCYVO[]
	 */
	public CLLCDLManifestCllCdlForODCYVO[] getCLLCDLManifestCllCdlForODCYVOs(){
		CLLCDLManifestCllCdlForODCYVO[] vos = (CLLCDLManifestCllCdlForODCYVO[])models.toArray(new CLLCDLManifestCllCdlForODCYVO[models.size()]);
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
		this.marPol = this.marPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHotDelFlg = this.bkgHotDelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCgoFlag = this.dgCgoFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBkgNo = this.mstBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdyNm = this.cmdyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgSts = this.dmgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstSvcRout = this.dstSvcRout .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depotCd = this.depotCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsiRskFlg = this.subsiRskFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgActWgtTpCd = this.bkgActWgtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delLoc = this.delLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrierVslCd = this.carrierVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLoc = this.podLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.humidity = this.humidity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTp = this.bkgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkFront = this.awkFront .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.split = this.split .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRmk = this.cstmsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPkgTpCd = this.bkgPkgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTemp = this.rfTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtQty = this.cntrWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMeasQty = this.bkgMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkLeft = this.awkLeft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socInd = this.socInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMeasQty = this.cntrMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carriersVoyNo = this.carriersVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLoc = this.polLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atdDt = this.atdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.extRemark = this.extRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFlag = this.rdFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgActWgt = this.bkgActWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubFlag = this.eqSubFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ems = this.ems .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMeasTpCd = this.cntrMeasTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ataDt = this.ataDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMeasTpCd = this.bkgMeasTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfFlag = this.rfFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtTpCd = this.cntrWgtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unCd = this.unCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akFlag = this.akFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vent = this.vent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCls = this.dgCls .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkHeight = this.awkHeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reCmmdNm = this.reCmmdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fshPoint = this.fshPoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkRear = this.awkRear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCode = this.laneCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkgTpCd = this.cntrPkgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkgQty = this.cntrPkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgGrp = this.pkgGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkRight = this.awkRight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPkgQty = this.bkgPkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hgFlag = this.hgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
