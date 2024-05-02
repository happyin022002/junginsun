/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CmBkgRptVO.java
*@FileTitle : CmBkgRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
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

public class CmBkgRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CmBkgRptVO> models = new ArrayList<CmBkgRptVO>();
	
	/* Column Info */
	private String porCd2 = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String holding = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String arrFromDt = null;
	/* Column Info */
	private String sailFromDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trfCd = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String spCargoGh = null;
	/* Column Info */
	private String spCargoSc = null;
	/* Column Info */
	private String vvdCd2 = null;
	/* Column Info */
	private String bkgStaffType = null;
	/* Column Info */
	private String spCargoPc = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String oblIssUsrId = null;
	/* Column Info */
	private String polYardCd = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String vslSlanDirCd = null;
	/* Column Info */
	private String bkgStsCdW = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String dTerm = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String blSrndToDt = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String spCargoBb = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String podYardCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blSrndFromDt = null;
	/* Column Info */
	private String rptid = null;
	/* Column Info */
	private String bkgStsCdF = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String trunkFlag = null;
	/* Column Info */
	private String spCargoAk = null;
	/* Column Info */
	private String polCd2 = null;
	/* Column Info */
	private String podTs = null;
	/* Column Info */
	private String rptId = null;
	/* Column Info */
	private String arrToDt = null;
	/* Column Info */
	private String sailToDt = null;
	/* Column Info */
	private String orderby = null;
	/* Column Info */
	private String nonSpCargo = null;
	/* Column Info */
	private String spCargoSt = null;
	/* Column Info */
	private String scRfaGbn = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String blSrndOfcCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String rfFlg = null;
	/* Column Info */
	private String internetBl = null;
	/* Column Info */
	private String blStsCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String localTs = null;
	/* Column Info */
	private String blRlseOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spCargoRf = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String bkgToDt = null;
	/* Column Info */
	private String spCargoRd = null;
	/* Column Info */
	private String polLocal = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String deliMode = null;
	/* Column Info */
	private String custTpCdS = null;
	/* Column Info */
	private String polTs = null;
	/* Column Info */
	private String custTpCdN = null;
	/* Column Info */
	private String frtChgTpCd = null;
	/* Column Info */
	private String podCd2 = null;
	/* Column Info */
	private String blPrnFromDt = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String custTpCdF = null;
	/* Column Info */
	private String pBkgRptKndCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custTpCdC = null;
	/* Column Info */
	private String eqType = null;
	/* Column Info */
	private String custTpCdA = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String cptrOfcCd = null;
	/* Column Info */
	private String spCargoHp = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String delCd2 = null;
	/* Column Info */
	private String hngrFlg = null;
	/* Column Info */
	private String bkgFromDt = null;
	/* Column Info */
	private String podLocal = null;
	/* Column Info */
	private String blPrnToDt = null;
	/* Column Info */
	private String spCargoDg = null;
	/* Column Info */
	private String bkgStaff = null;
	/* Column Info */
	private String cgoRlseStsCd = null;
	/* Column Info */
	private String rTerm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CmBkgRptVO() {}

	public CmBkgRptVO(String ibflag, String pagerows, String rptid, String blPrnFromDt, String blPrnToDt, String blSrndFromDt, String blSrndToDt, String trfCd, String cgoRlseStsCd, String crrCd, String oblIssUsrId, String blStsCd, String blTpCd, String internetBl, String vvdCd2, String blRlseOfcCd, String blSrndOfcCd, String cptrOfcCd, String custTpCdS, String custTpCdC, String custTpCdN, String custTpCdF, String custTpCdA, String custCntCd, String custSeq, String custNm, String custGrpId, String vvdCd, String trunkFlag, String laneCd, String dirCd, String bkgCgoTpCd, String polCd, String polYardCd, String polLocal, String polTs, String podCd, String podYardCd, String podLocal, String podTs, String eqType, String porCd, String delCd, String rTerm, String dTerm, String eccCd, String bkgOfcCd, String bkgStsCd, String spCargoDg, String spCargoRf, String spCargoAk, String spCargoBb, String spCargoSt, String spCargoHp, String spCargoRd, String spCargoSc, String spCargoPc, String spCargoGh, String deliMode, String localTs, String sailFromDt, String sailToDt, String arrFromDt, String arrToDt, String bkgFromDt, String bkgToDt, String bkgNo, String blNo, String obSrepCd, String bkgStaffType, String bkgStaff, String bkgStsCdF, String bkgStsCdW, String nonSpCargo, String holding, String porCd2, String polCd2, String podCd2, String delCd2, String vslSlanDirCd, String trdCd, String subTrdCd, String ioBndCd, String scRfaGbn, String scRfaNo, String obSlsOfcCd, String frtChgTpCd, String dcgoFlg, String rfFlg, String awkCgoFlg, String bbCgoFlg, String hngrFlg, String pBkgRptKndCd, String orderby, String rptId) {
		this.porCd2 = porCd2;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.holding = holding;
		this.trdCd = trdCd;
		this.arrFromDt = arrFromDt;
		this.sailFromDt = sailFromDt;
		this.blNo = blNo;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.trfCd = trfCd;
		this.obSrepCd = obSrepCd;
		this.spCargoGh = spCargoGh;
		this.spCargoSc = spCargoSc;
		this.vvdCd2 = vvdCd2;
		this.bkgStaffType = bkgStaffType;
		this.spCargoPc = spCargoPc;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.oblIssUsrId = oblIssUsrId;
		this.polYardCd = polYardCd;
		this.obSlsOfcCd = obSlsOfcCd;
		this.vslSlanDirCd = vslSlanDirCd;
		this.bkgStsCdW = bkgStsCdW;
		this.custCntCd = custCntCd;
		this.dTerm = dTerm;
		this.bkgOfcCd = bkgOfcCd;
		this.blSrndToDt = blSrndToDt;
		this.custGrpId = custGrpId;
		this.spCargoBb = spCargoBb;
		this.awkCgoFlg = awkCgoFlg;
		this.podYardCd = podYardCd;
		this.delCd = delCd;
		this.blSrndFromDt = blSrndFromDt;
		this.rptid = rptid;
		this.bkgStsCdF = bkgStsCdF;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.trunkFlag = trunkFlag;
		this.spCargoAk = spCargoAk;
		this.polCd2 = polCd2;
		this.podTs = podTs;
		this.rptId = rptId;
		this.arrToDt = arrToDt;
		this.sailToDt = sailToDt;
		this.orderby = orderby;
		this.nonSpCargo = nonSpCargo;
		this.spCargoSt = spCargoSt;
		this.scRfaGbn = scRfaGbn;
		this.subTrdCd = subTrdCd;
		this.blSrndOfcCd = blSrndOfcCd;
		this.porCd = porCd;
		this.laneCd = laneCd;
		this.rfFlg = rfFlg;
		this.internetBl = internetBl;
		this.blStsCd = blStsCd;
		this.custNm = custNm;
		this.bkgStsCd = bkgStsCd;
		this.localTs = localTs;
		this.blRlseOfcCd = blRlseOfcCd;
		this.ibflag = ibflag;
		this.spCargoRf = spCargoRf;
		this.bbCgoFlg = bbCgoFlg;
		this.bkgToDt = bkgToDt;
		this.spCargoRd = spCargoRd;
		this.polLocal = polLocal;
		this.dcgoFlg = dcgoFlg;
		this.dirCd = dirCd;
		this.deliMode = deliMode;
		this.custTpCdS = custTpCdS;
		this.polTs = polTs;
		this.custTpCdN = custTpCdN;
		this.frtChgTpCd = frtChgTpCd;
		this.podCd2 = podCd2;
		this.blPrnFromDt = blPrnFromDt;
		this.eccCd = eccCd;
		this.custTpCdF = custTpCdF;
		this.pBkgRptKndCd = pBkgRptKndCd;
		this.ioBndCd = ioBndCd;
		this.custSeq = custSeq;
		this.custTpCdC = custTpCdC;
		this.eqType = eqType;
		this.custTpCdA = custTpCdA;
		this.blTpCd = blTpCd;
		this.cptrOfcCd = cptrOfcCd;
		this.spCargoHp = spCargoHp;
		this.scRfaNo = scRfaNo;
		this.delCd2 = delCd2;
		this.hngrFlg = hngrFlg;
		this.bkgFromDt = bkgFromDt;
		this.podLocal = podLocal;
		this.blPrnToDt = blPrnToDt;
		this.spCargoDg = spCargoDg;
		this.bkgStaff = bkgStaff;
		this.cgoRlseStsCd = cgoRlseStsCd;
		this.rTerm = rTerm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd2", getPorCd2());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("holding", getHolding());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("arr_from_dt", getArrFromDt());
		this.hashColumns.put("sail_from_dt", getSailFromDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trf_cd", getTrfCd());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("sp_cargo_gh", getSpCargoGh());
		this.hashColumns.put("sp_cargo_sc", getSpCargoSc());
		this.hashColumns.put("vvd_cd2", getVvdCd2());
		this.hashColumns.put("bkg_staff_type", getBkgStaffType());
		this.hashColumns.put("sp_cargo_pc", getSpCargoPc());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("obl_iss_usr_id", getOblIssUsrId());
		this.hashColumns.put("pol_yard_cd", getPolYardCd());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("vsl_slan_dir_cd", getVslSlanDirCd());
		this.hashColumns.put("bkg_sts_cd_w", getBkgStsCdW());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("d_term", getDTerm());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("bl_srnd_to_dt", getBlSrndToDt());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("sp_cargo_bb", getSpCargoBb());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("pod_yard_cd", getPodYardCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_srnd_from_dt", getBlSrndFromDt());
		this.hashColumns.put("rptid", getRptid());
		this.hashColumns.put("bkg_sts_cd_f", getBkgStsCdF());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("trunk_flag", getTrunkFlag());
		this.hashColumns.put("sp_cargo_ak", getSpCargoAk());
		this.hashColumns.put("pol_cd2", getPolCd2());
		this.hashColumns.put("pod_ts", getPodTs());
		this.hashColumns.put("rpt_id", getRptId());
		this.hashColumns.put("arr_to_dt", getArrToDt());
		this.hashColumns.put("sail_to_dt", getSailToDt());
		this.hashColumns.put("orderby", getOrderby());
		this.hashColumns.put("non_sp_cargo", getNonSpCargo());
		this.hashColumns.put("sp_cargo_st", getSpCargoSt());
		this.hashColumns.put("sc_rfa_gbn", getScRfaGbn());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("bl_srnd_ofc_cd", getBlSrndOfcCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("rf_flg", getRfFlg());
		this.hashColumns.put("internet_bl", getInternetBl());
		this.hashColumns.put("bl_sts_cd", getBlStsCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("local_ts", getLocalTs());
		this.hashColumns.put("bl_rlse_ofc_cd", getBlRlseOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sp_cargo_rf", getSpCargoRf());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("bkg_to_dt", getBkgToDt());
		this.hashColumns.put("sp_cargo_rd", getSpCargoRd());
		this.hashColumns.put("pol_local", getPolLocal());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("deli_mode", getDeliMode());
		this.hashColumns.put("cust_tp_cd_s", getCustTpCdS());
		this.hashColumns.put("pol_ts", getPolTs());
		this.hashColumns.put("cust_tp_cd_n", getCustTpCdN());
		this.hashColumns.put("frt_chg_tp_cd", getFrtChgTpCd());
		this.hashColumns.put("pod_cd2", getPodCd2());
		this.hashColumns.put("bl_prn_from_dt", getBlPrnFromDt());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("cust_tp_cd_f", getCustTpCdF());
		this.hashColumns.put("p_bkg_rpt_knd_cd", getPBkgRptKndCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_tp_cd_c", getCustTpCdC());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("cust_tp_cd_a", getCustTpCdA());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("cptr_ofc_cd", getCptrOfcCd());
		this.hashColumns.put("sp_cargo_hp", getSpCargoHp());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("del_cd2", getDelCd2());
		this.hashColumns.put("hngr_flg", getHngrFlg());
		this.hashColumns.put("bkg_from_dt", getBkgFromDt());
		this.hashColumns.put("pod_local", getPodLocal());
		this.hashColumns.put("bl_prn_to_dt", getBlPrnToDt());
		this.hashColumns.put("sp_cargo_dg", getSpCargoDg());
		this.hashColumns.put("bkg_staff", getBkgStaff());
		this.hashColumns.put("cgo_rlse_sts_cd", getCgoRlseStsCd());
		this.hashColumns.put("r_term", getRTerm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd2", "porCd2");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("holding", "holding");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("arr_from_dt", "arrFromDt");
		this.hashFields.put("sail_from_dt", "sailFromDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trf_cd", "trfCd");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("sp_cargo_gh", "spCargoGh");
		this.hashFields.put("sp_cargo_sc", "spCargoSc");
		this.hashFields.put("vvd_cd2", "vvdCd2");
		this.hashFields.put("bkg_staff_type", "bkgStaffType");
		this.hashFields.put("sp_cargo_pc", "spCargoPc");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("obl_iss_usr_id", "oblIssUsrId");
		this.hashFields.put("pol_yard_cd", "polYardCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("vsl_slan_dir_cd", "vslSlanDirCd");
		this.hashFields.put("bkg_sts_cd_w", "bkgStsCdW");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("d_term", "dTerm");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("bl_srnd_to_dt", "blSrndToDt");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("sp_cargo_bb", "spCargoBb");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("pod_yard_cd", "podYardCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_srnd_from_dt", "blSrndFromDt");
		this.hashFields.put("rptid", "rptid");
		this.hashFields.put("bkg_sts_cd_f", "bkgStsCdF");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("trunk_flag", "trunkFlag");
		this.hashFields.put("sp_cargo_ak", "spCargoAk");
		this.hashFields.put("pol_cd2", "polCd2");
		this.hashFields.put("pod_ts", "podTs");
		this.hashFields.put("rpt_id", "rptId");
		this.hashFields.put("arr_to_dt", "arrToDt");
		this.hashFields.put("sail_to_dt", "sailToDt");
		this.hashFields.put("orderby", "orderby");
		this.hashFields.put("non_sp_cargo", "nonSpCargo");
		this.hashFields.put("sp_cargo_st", "spCargoSt");
		this.hashFields.put("sc_rfa_gbn", "scRfaGbn");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("bl_srnd_ofc_cd", "blSrndOfcCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("rf_flg", "rfFlg");
		this.hashFields.put("internet_bl", "internetBl");
		this.hashFields.put("bl_sts_cd", "blStsCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("local_ts", "localTs");
		this.hashFields.put("bl_rlse_ofc_cd", "blRlseOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sp_cargo_rf", "spCargoRf");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("bkg_to_dt", "bkgToDt");
		this.hashFields.put("sp_cargo_rd", "spCargoRd");
		this.hashFields.put("pol_local", "polLocal");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("deli_mode", "deliMode");
		this.hashFields.put("cust_tp_cd_s", "custTpCdS");
		this.hashFields.put("pol_ts", "polTs");
		this.hashFields.put("cust_tp_cd_n", "custTpCdN");
		this.hashFields.put("frt_chg_tp_cd", "frtChgTpCd");
		this.hashFields.put("pod_cd2", "podCd2");
		this.hashFields.put("bl_prn_from_dt", "blPrnFromDt");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("cust_tp_cd_f", "custTpCdF");
		this.hashFields.put("p_bkg_rpt_knd_cd", "pBkgRptKndCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_tp_cd_c", "custTpCdC");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("cust_tp_cd_a", "custTpCdA");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("cptr_ofc_cd", "cptrOfcCd");
		this.hashFields.put("sp_cargo_hp", "spCargoHp");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("del_cd2", "delCd2");
		this.hashFields.put("hngr_flg", "hngrFlg");
		this.hashFields.put("bkg_from_dt", "bkgFromDt");
		this.hashFields.put("pod_local", "podLocal");
		this.hashFields.put("bl_prn_to_dt", "blPrnToDt");
		this.hashFields.put("sp_cargo_dg", "spCargoDg");
		this.hashFields.put("bkg_staff", "bkgStaff");
		this.hashFields.put("cgo_rlse_sts_cd", "cgoRlseStsCd");
		this.hashFields.put("r_term", "rTerm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd2
	 */
	public String getPorCd2() {
		return this.porCd2;
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
	 * @return holding
	 */
	public String getHolding() {
		return this.holding;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return arrFromDt
	 */
	public String getArrFromDt() {
		return this.arrFromDt;
	}
	
	/**
	 * Column Info
	 * @return sailFromDt
	 */
	public String getSailFromDt() {
		return this.sailFromDt;
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
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return trfCd
	 */
	public String getTrfCd() {
		return this.trfCd;
	}
	
	/**
	 * Column Info
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	
	/**
	 * Column Info
	 * @return spCargoGh
	 */
	public String getSpCargoGh() {
		return this.spCargoGh;
	}
	
	/**
	 * Column Info
	 * @return spCargoSc
	 */
	public String getSpCargoSc() {
		return this.spCargoSc;
	}
	
	/**
	 * Column Info
	 * @return vvdCd2
	 */
	public String getVvdCd2() {
		return this.vvdCd2;
	}
	
	/**
	 * Column Info
	 * @return bkgStaffType
	 */
	public String getBkgStaffType() {
		return this.bkgStaffType;
	}
	
	/**
	 * Column Info
	 * @return spCargoPc
	 */
	public String getSpCargoPc() {
		return this.spCargoPc;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return oblIssUsrId
	 */
	public String getOblIssUsrId() {
		return this.oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @return polYardCd
	 */
	public String getPolYardCd() {
		return this.polYardCd;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanDirCd
	 */
	public String getVslSlanDirCd() {
		return this.vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCdW
	 */
	public String getBkgStsCdW() {
		return this.bkgStsCdW;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return dTerm
	 */
	public String getDTerm() {
		return this.dTerm;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blSrndToDt
	 */
	public String getBlSrndToDt() {
		return this.blSrndToDt;
	}
	
	/**
	 * Column Info
	 * @return custGrpId
	 */
	public String getCustGrpId() {
		return this.custGrpId;
	}
	
	/**
	 * Column Info
	 * @return spCargoBb
	 */
	public String getSpCargoBb() {
		return this.spCargoBb;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return podYardCd
	 */
	public String getPodYardCd() {
		return this.podYardCd;
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
	 * @return blSrndFromDt
	 */
	public String getBlSrndFromDt() {
		return this.blSrndFromDt;
	}
	
	/**
	 * Column Info
	 * @return rptid
	 */
	public String getRptid() {
		return this.rptid;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCdF
	 */
	public String getBkgStsCdF() {
		return this.bkgStsCdF;
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
	 * @return trunkFlag
	 */
	public String getTrunkFlag() {
		return this.trunkFlag;
	}
	
	/**
	 * Column Info
	 * @return spCargoAk
	 */
	public String getSpCargoAk() {
		return this.spCargoAk;
	}
	
	/**
	 * Column Info
	 * @return polCd2
	 */
	public String getPolCd2() {
		return this.polCd2;
	}
	
	/**
	 * Column Info
	 * @return podTs
	 */
	public String getPodTs() {
		return this.podTs;
	}
	
	/**
	 * Column Info
	 * @return rptId
	 */
	public String getRptId() {
		return this.rptId;
	}
	
	/**
	 * Column Info
	 * @return arrToDt
	 */
	public String getArrToDt() {
		return this.arrToDt;
	}
	
	/**
	 * Column Info
	 * @return sailToDt
	 */
	public String getSailToDt() {
		return this.sailToDt;
	}
	
	/**
	 * Column Info
	 * @return orderby
	 */
	public String getOrderby() {
		return this.orderby;
	}
	
	/**
	 * Column Info
	 * @return nonSpCargo
	 */
	public String getNonSpCargo() {
		return this.nonSpCargo;
	}
	
	/**
	 * Column Info
	 * @return spCargoSt
	 */
	public String getSpCargoSt() {
		return this.spCargoSt;
	}
	
	/**
	 * Column Info
	 * @return scRfaGbn
	 */
	public String getScRfaGbn() {
		return this.scRfaGbn;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return blSrndOfcCd
	 */
	public String getBlSrndOfcCd() {
		return this.blSrndOfcCd;
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
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return rfFlg
	 */
	public String getRfFlg() {
		return this.rfFlg;
	}
	
	/**
	 * Column Info
	 * @return internetBl
	 */
	public String getInternetBl() {
		return this.internetBl;
	}
	
	/**
	 * Column Info
	 * @return blStsCd
	 */
	public String getBlStsCd() {
		return this.blStsCd;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return localTs
	 */
	public String getLocalTs() {
		return this.localTs;
	}
	
	/**
	 * Column Info
	 * @return blRlseOfcCd
	 */
	public String getBlRlseOfcCd() {
		return this.blRlseOfcCd;
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
	 * @return spCargoRf
	 */
	public String getSpCargoRf() {
		return this.spCargoRf;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgToDt
	 */
	public String getBkgToDt() {
		return this.bkgToDt;
	}
	
	/**
	 * Column Info
	 * @return spCargoRd
	 */
	public String getSpCargoRd() {
		return this.spCargoRd;
	}
	
	/**
	 * Column Info
	 * @return polLocal
	 */
	public String getPolLocal() {
		return this.polLocal;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return deliMode
	 */
	public String getDeliMode() {
		return this.deliMode;
	}
	
	/**
	 * Column Info
	 * @return custTpCdS
	 */
	public String getCustTpCdS() {
		return this.custTpCdS;
	}
	
	/**
	 * Column Info
	 * @return polTs
	 */
	public String getPolTs() {
		return this.polTs;
	}
	
	/**
	 * Column Info
	 * @return custTpCdN
	 */
	public String getCustTpCdN() {
		return this.custTpCdN;
	}
	
	/**
	 * Column Info
	 * @return frtChgTpCd
	 */
	public String getFrtChgTpCd() {
		return this.frtChgTpCd;
	}
	
	/**
	 * Column Info
	 * @return podCd2
	 */
	public String getPodCd2() {
		return this.podCd2;
	}
	
	/**
	 * Column Info
	 * @return blPrnFromDt
	 */
	public String getBlPrnFromDt() {
		return this.blPrnFromDt;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}
	
	/**
	 * Column Info
	 * @return custTpCdF
	 */
	public String getCustTpCdF() {
		return this.custTpCdF;
	}
	
	/**
	 * Column Info
	 * @return pBkgRptKndCd
	 */
	public String getPBkgRptKndCd() {
		return this.pBkgRptKndCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return custTpCdC
	 */
	public String getCustTpCdC() {
		return this.custTpCdC;
	}
	
	/**
	 * Column Info
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
	}
	
	/**
	 * Column Info
	 * @return custTpCdA
	 */
	public String getCustTpCdA() {
		return this.custTpCdA;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return cptrOfcCd
	 */
	public String getCptrOfcCd() {
		return this.cptrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return spCargoHp
	 */
	public String getSpCargoHp() {
		return this.spCargoHp;
	}
	
	/**
	 * Column Info
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
	}
	
	/**
	 * Column Info
	 * @return delCd2
	 */
	public String getDelCd2() {
		return this.delCd2;
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
	 * @return bkgFromDt
	 */
	public String getBkgFromDt() {
		return this.bkgFromDt;
	}
	
	/**
	 * Column Info
	 * @return podLocal
	 */
	public String getPodLocal() {
		return this.podLocal;
	}
	
	/**
	 * Column Info
	 * @return blPrnToDt
	 */
	public String getBlPrnToDt() {
		return this.blPrnToDt;
	}
	
	/**
	 * Column Info
	 * @return spCargoDg
	 */
	public String getSpCargoDg() {
		return this.spCargoDg;
	}
	
	/**
	 * Column Info
	 * @return bkgStaff
	 */
	public String getBkgStaff() {
		return this.bkgStaff;
	}
	
	/**
	 * Column Info
	 * @return cgoRlseStsCd
	 */
	public String getCgoRlseStsCd() {
		return this.cgoRlseStsCd;
	}
	
	/**
	 * Column Info
	 * @return rTerm
	 */
	public String getRTerm() {
		return this.rTerm;
	}
	

	/**
	 * Column Info
	 * @param porCd2
	 */
	public void setPorCd2(String porCd2) {
		this.porCd2 = porCd2;
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
	 * @param holding
	 */
	public void setHolding(String holding) {
		this.holding = holding;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param arrFromDt
	 */
	public void setArrFromDt(String arrFromDt) {
		this.arrFromDt = arrFromDt;
	}
	
	/**
	 * Column Info
	 * @param sailFromDt
	 */
	public void setSailFromDt(String sailFromDt) {
		this.sailFromDt = sailFromDt;
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
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param trfCd
	 */
	public void setTrfCd(String trfCd) {
		this.trfCd = trfCd;
	}
	
	/**
	 * Column Info
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	
	/**
	 * Column Info
	 * @param spCargoGh
	 */
	public void setSpCargoGh(String spCargoGh) {
		this.spCargoGh = spCargoGh;
	}
	
	/**
	 * Column Info
	 * @param spCargoSc
	 */
	public void setSpCargoSc(String spCargoSc) {
		this.spCargoSc = spCargoSc;
	}
	
	/**
	 * Column Info
	 * @param vvdCd2
	 */
	public void setVvdCd2(String vvdCd2) {
		this.vvdCd2 = vvdCd2;
	}
	
	/**
	 * Column Info
	 * @param bkgStaffType
	 */
	public void setBkgStaffType(String bkgStaffType) {
		this.bkgStaffType = bkgStaffType;
	}
	
	/**
	 * Column Info
	 * @param spCargoPc
	 */
	public void setSpCargoPc(String spCargoPc) {
		this.spCargoPc = spCargoPc;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param oblIssUsrId
	 */
	public void setOblIssUsrId(String oblIssUsrId) {
		this.oblIssUsrId = oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @param polYardCd
	 */
	public void setPolYardCd(String polYardCd) {
		this.polYardCd = polYardCd;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanDirCd
	 */
	public void setVslSlanDirCd(String vslSlanDirCd) {
		this.vslSlanDirCd = vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCdW
	 */
	public void setBkgStsCdW(String bkgStsCdW) {
		this.bkgStsCdW = bkgStsCdW;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param dTerm
	 */
	public void setDTerm(String dTerm) {
		this.dTerm = dTerm;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blSrndToDt
	 */
	public void setBlSrndToDt(String blSrndToDt) {
		this.blSrndToDt = blSrndToDt;
	}
	
	/**
	 * Column Info
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
	}
	
	/**
	 * Column Info
	 * @param spCargoBb
	 */
	public void setSpCargoBb(String spCargoBb) {
		this.spCargoBb = spCargoBb;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param podYardCd
	 */
	public void setPodYardCd(String podYardCd) {
		this.podYardCd = podYardCd;
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
	 * @param blSrndFromDt
	 */
	public void setBlSrndFromDt(String blSrndFromDt) {
		this.blSrndFromDt = blSrndFromDt;
	}
	
	/**
	 * Column Info
	 * @param rptid
	 */
	public void setRptid(String rptid) {
		this.rptid = rptid;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCdF
	 */
	public void setBkgStsCdF(String bkgStsCdF) {
		this.bkgStsCdF = bkgStsCdF;
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
	 * @param trunkFlag
	 */
	public void setTrunkFlag(String trunkFlag) {
		this.trunkFlag = trunkFlag;
	}
	
	/**
	 * Column Info
	 * @param spCargoAk
	 */
	public void setSpCargoAk(String spCargoAk) {
		this.spCargoAk = spCargoAk;
	}
	
	/**
	 * Column Info
	 * @param polCd2
	 */
	public void setPolCd2(String polCd2) {
		this.polCd2 = polCd2;
	}
	
	/**
	 * Column Info
	 * @param podTs
	 */
	public void setPodTs(String podTs) {
		this.podTs = podTs;
	}
	
	/**
	 * Column Info
	 * @param rptId
	 */
	public void setRptId(String rptId) {
		this.rptId = rptId;
	}
	
	/**
	 * Column Info
	 * @param arrToDt
	 */
	public void setArrToDt(String arrToDt) {
		this.arrToDt = arrToDt;
	}
	
	/**
	 * Column Info
	 * @param sailToDt
	 */
	public void setSailToDt(String sailToDt) {
		this.sailToDt = sailToDt;
	}
	
	/**
	 * Column Info
	 * @param orderby
	 */
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	
	/**
	 * Column Info
	 * @param nonSpCargo
	 */
	public void setNonSpCargo(String nonSpCargo) {
		this.nonSpCargo = nonSpCargo;
	}
	
	/**
	 * Column Info
	 * @param spCargoSt
	 */
	public void setSpCargoSt(String spCargoSt) {
		this.spCargoSt = spCargoSt;
	}
	
	/**
	 * Column Info
	 * @param scRfaGbn
	 */
	public void setScRfaGbn(String scRfaGbn) {
		this.scRfaGbn = scRfaGbn;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param blSrndOfcCd
	 */
	public void setBlSrndOfcCd(String blSrndOfcCd) {
		this.blSrndOfcCd = blSrndOfcCd;
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
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param rfFlg
	 */
	public void setRfFlg(String rfFlg) {
		this.rfFlg = rfFlg;
	}
	
	/**
	 * Column Info
	 * @param internetBl
	 */
	public void setInternetBl(String internetBl) {
		this.internetBl = internetBl;
	}
	
	/**
	 * Column Info
	 * @param blStsCd
	 */
	public void setBlStsCd(String blStsCd) {
		this.blStsCd = blStsCd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param localTs
	 */
	public void setLocalTs(String localTs) {
		this.localTs = localTs;
	}
	
	/**
	 * Column Info
	 * @param blRlseOfcCd
	 */
	public void setBlRlseOfcCd(String blRlseOfcCd) {
		this.blRlseOfcCd = blRlseOfcCd;
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
	 * @param spCargoRf
	 */
	public void setSpCargoRf(String spCargoRf) {
		this.spCargoRf = spCargoRf;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgToDt
	 */
	public void setBkgToDt(String bkgToDt) {
		this.bkgToDt = bkgToDt;
	}
	
	/**
	 * Column Info
	 * @param spCargoRd
	 */
	public void setSpCargoRd(String spCargoRd) {
		this.spCargoRd = spCargoRd;
	}
	
	/**
	 * Column Info
	 * @param polLocal
	 */
	public void setPolLocal(String polLocal) {
		this.polLocal = polLocal;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param deliMode
	 */
	public void setDeliMode(String deliMode) {
		this.deliMode = deliMode;
	}
	
	/**
	 * Column Info
	 * @param custTpCdS
	 */
	public void setCustTpCdS(String custTpCdS) {
		this.custTpCdS = custTpCdS;
	}
	
	/**
	 * Column Info
	 * @param polTs
	 */
	public void setPolTs(String polTs) {
		this.polTs = polTs;
	}
	
	/**
	 * Column Info
	 * @param custTpCdN
	 */
	public void setCustTpCdN(String custTpCdN) {
		this.custTpCdN = custTpCdN;
	}
	
	/**
	 * Column Info
	 * @param frtChgTpCd
	 */
	public void setFrtChgTpCd(String frtChgTpCd) {
		this.frtChgTpCd = frtChgTpCd;
	}
	
	/**
	 * Column Info
	 * @param podCd2
	 */
	public void setPodCd2(String podCd2) {
		this.podCd2 = podCd2;
	}
	
	/**
	 * Column Info
	 * @param blPrnFromDt
	 */
	public void setBlPrnFromDt(String blPrnFromDt) {
		this.blPrnFromDt = blPrnFromDt;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	
	/**
	 * Column Info
	 * @param custTpCdF
	 */
	public void setCustTpCdF(String custTpCdF) {
		this.custTpCdF = custTpCdF;
	}
	
	/**
	 * Column Info
	 * @param pBkgRptKndCd
	 */
	public void setPBkgRptKndCd(String pBkgRptKndCd) {
		this.pBkgRptKndCd = pBkgRptKndCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param custTpCdC
	 */
	public void setCustTpCdC(String custTpCdC) {
		this.custTpCdC = custTpCdC;
	}
	
	/**
	 * Column Info
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
	}
	
	/**
	 * Column Info
	 * @param custTpCdA
	 */
	public void setCustTpCdA(String custTpCdA) {
		this.custTpCdA = custTpCdA;
	}
	
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param cptrOfcCd
	 */
	public void setCptrOfcCd(String cptrOfcCd) {
		this.cptrOfcCd = cptrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param spCargoHp
	 */
	public void setSpCargoHp(String spCargoHp) {
		this.spCargoHp = spCargoHp;
	}
	
	/**
	 * Column Info
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
	}
	
	/**
	 * Column Info
	 * @param delCd2
	 */
	public void setDelCd2(String delCd2) {
		this.delCd2 = delCd2;
	}
	
	/**
	 * Column Info
	 * @param hngrFlg
	 */
	public void setHngrFlg(String hngrFlg) {
		this.hngrFlg = hngrFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgFromDt
	 */
	public void setBkgFromDt(String bkgFromDt) {
		this.bkgFromDt = bkgFromDt;
	}
	
	/**
	 * Column Info
	 * @param podLocal
	 */
	public void setPodLocal(String podLocal) {
		this.podLocal = podLocal;
	}
	
	/**
	 * Column Info
	 * @param blPrnToDt
	 */
	public void setBlPrnToDt(String blPrnToDt) {
		this.blPrnToDt = blPrnToDt;
	}
	
	/**
	 * Column Info
	 * @param spCargoDg
	 */
	public void setSpCargoDg(String spCargoDg) {
		this.spCargoDg = spCargoDg;
	}
	
	/**
	 * Column Info
	 * @param bkgStaff
	 */
	public void setBkgStaff(String bkgStaff) {
		this.bkgStaff = bkgStaff;
	}
	
	/**
	 * Column Info
	 * @param cgoRlseStsCd
	 */
	public void setCgoRlseStsCd(String cgoRlseStsCd) {
		this.cgoRlseStsCd = cgoRlseStsCd;
	}
	
	/**
	 * Column Info
	 * @param rTerm
	 */
	public void setRTerm(String rTerm) {
		this.rTerm = rTerm;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd2(JSPUtil.getParameter(request, "por_cd2", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setHolding(JSPUtil.getParameter(request, "holding", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setArrFromDt(JSPUtil.getParameter(request, "arr_from_dt", ""));
		setSailFromDt(JSPUtil.getParameter(request, "sail_from_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTrfCd(JSPUtil.getParameter(request, "trf_cd", ""));
		setObSrepCd(JSPUtil.getParameter(request, "ob_srep_cd", ""));
		setSpCargoGh(JSPUtil.getParameter(request, "sp_cargo_gh", ""));
		setSpCargoSc(JSPUtil.getParameter(request, "sp_cargo_sc", ""));
		setVvdCd2(JSPUtil.getParameter(request, "vvd_cd2", ""));
		setBkgStaffType(JSPUtil.getParameter(request, "bkg_staff_type", ""));
		setSpCargoPc(JSPUtil.getParameter(request, "sp_cargo_pc", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setOblIssUsrId(JSPUtil.getParameter(request, "obl_iss_usr_id", ""));
		setPolYardCd(JSPUtil.getParameter(request, "pol_yard_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, "ob_sls_ofc_cd", ""));
		setVslSlanDirCd(JSPUtil.getParameter(request, "vsl_slan_dir_cd", ""));
		setBkgStsCdW(JSPUtil.getParameter(request, "bkg_sts_cd_w", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setDTerm(JSPUtil.getParameter(request, "d_term", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setBlSrndToDt(JSPUtil.getParameter(request, "bl_srnd_to_dt", ""));
		setCustGrpId(JSPUtil.getParameter(request, "cust_grp_id", ""));
		setSpCargoBb(JSPUtil.getParameter(request, "sp_cargo_bb", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setPodYardCd(JSPUtil.getParameter(request, "pod_yard_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBlSrndFromDt(JSPUtil.getParameter(request, "bl_srnd_from_dt", ""));
		setRptid(JSPUtil.getParameter(request, "rptid", ""));
		setBkgStsCdF(JSPUtil.getParameter(request, "bkg_sts_cd_f", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setTrunkFlag(JSPUtil.getParameter(request, "trunk_flag", ""));
		setSpCargoAk(JSPUtil.getParameter(request, "sp_cargo_ak", ""));
		setPolCd2(JSPUtil.getParameter(request, "pol_cd2", ""));
		setPodTs(JSPUtil.getParameter(request, "pod_ts", ""));
		setRptId(JSPUtil.getParameter(request, "rpt_id", ""));
		setArrToDt(JSPUtil.getParameter(request, "arr_to_dt", ""));
		setSailToDt(JSPUtil.getParameter(request, "sail_to_dt", ""));
		setOrderby(JSPUtil.getParameter(request, "orderby", ""));
		setNonSpCargo(JSPUtil.getParameter(request, "non_sp_cargo", ""));
		setSpCargoSt(JSPUtil.getParameter(request, "sp_cargo_st", ""));
		setScRfaGbn(JSPUtil.getParameter(request, "sc_rfa_gbn", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setBlSrndOfcCd(JSPUtil.getParameter(request, "bl_srnd_ofc_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setRfFlg(JSPUtil.getParameter(request, "rf_flg", ""));
		setInternetBl(JSPUtil.getParameter(request, "internet_bl", ""));
		setBlStsCd(JSPUtil.getParameter(request, "bl_sts_cd", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setLocalTs(JSPUtil.getParameter(request, "local_ts", ""));
		setBlRlseOfcCd(JSPUtil.getParameter(request, "bl_rlse_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSpCargoRf(JSPUtil.getParameter(request, "sp_cargo_rf", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setBkgToDt(JSPUtil.getParameter(request, "bkg_to_dt", ""));
		setSpCargoRd(JSPUtil.getParameter(request, "sp_cargo_rd", ""));
		setPolLocal(JSPUtil.getParameter(request, "pol_local", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setDeliMode(JSPUtil.getParameter(request, "deli_mode", ""));
		setCustTpCdS(JSPUtil.getParameter(request, "cust_tp_cd_s", ""));
		setPolTs(JSPUtil.getParameter(request, "pol_ts", ""));
		setCustTpCdN(JSPUtil.getParameter(request, "cust_tp_cd_n", ""));
		setFrtChgTpCd(JSPUtil.getParameter(request, "frt_chg_tp_cd", ""));
		setPodCd2(JSPUtil.getParameter(request, "pod_cd2", ""));
		setBlPrnFromDt(JSPUtil.getParameter(request, "bl_prn_from_dt", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setCustTpCdF(JSPUtil.getParameter(request, "cust_tp_cd_f", ""));
		setPBkgRptKndCd(JSPUtil.getParameter(request, "p_bkg_rpt_knd_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustTpCdC(JSPUtil.getParameter(request, "cust_tp_cd_c", ""));
		setEqType(JSPUtil.getParameter(request, "eq_type", ""));
		setCustTpCdA(JSPUtil.getParameter(request, "cust_tp_cd_a", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setCptrOfcCd(JSPUtil.getParameter(request, "cptr_ofc_cd", ""));
		setSpCargoHp(JSPUtil.getParameter(request, "sp_cargo_hp", ""));
		setScRfaNo(JSPUtil.getParameter(request, "sc_rfa_no", ""));
		setDelCd2(JSPUtil.getParameter(request, "del_cd2", ""));
		setHngrFlg(JSPUtil.getParameter(request, "hngr_flg", ""));
		setBkgFromDt(JSPUtil.getParameter(request, "bkg_from_dt", ""));
		setPodLocal(JSPUtil.getParameter(request, "pod_local", ""));
		setBlPrnToDt(JSPUtil.getParameter(request, "bl_prn_to_dt", ""));
		setSpCargoDg(JSPUtil.getParameter(request, "sp_cargo_dg", ""));
		setBkgStaff(JSPUtil.getParameter(request, "bkg_staff", ""));
		setCgoRlseStsCd(JSPUtil.getParameter(request, "cgo_rlse_sts_cd", ""));
		setRTerm(JSPUtil.getParameter(request, "r_term", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CmBkgRptVO[]
	 */
	public CmBkgRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CmBkgRptVO[]
	 */
	public CmBkgRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CmBkgRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd2 = (JSPUtil.getParameter(request, prefix	+ "por_cd2", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] holding = (JSPUtil.getParameter(request, prefix	+ "holding", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] arrFromDt = (JSPUtil.getParameter(request, prefix	+ "arr_from_dt", length));
			String[] sailFromDt = (JSPUtil.getParameter(request, prefix	+ "sail_from_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trfCd = (JSPUtil.getParameter(request, prefix	+ "trf_cd", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] spCargoGh = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_gh", length));
			String[] spCargoSc = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_sc", length));
			String[] vvdCd2 = (JSPUtil.getParameter(request, prefix	+ "vvd_cd2", length));
			String[] bkgStaffType = (JSPUtil.getParameter(request, prefix	+ "bkg_staff_type", length));
			String[] spCargoPc = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_pc", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] oblIssUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_iss_usr_id", length));
			String[] polYardCd = (JSPUtil.getParameter(request, prefix	+ "pol_yard_cd", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] vslSlanDirCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_dir_cd", length));
			String[] bkgStsCdW = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd_w", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] dTerm = (JSPUtil.getParameter(request, prefix	+ "d_term", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] blSrndToDt = (JSPUtil.getParameter(request, prefix	+ "bl_srnd_to_dt", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] spCargoBb = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_bb", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] podYardCd = (JSPUtil.getParameter(request, prefix	+ "pod_yard_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blSrndFromDt = (JSPUtil.getParameter(request, prefix	+ "bl_srnd_from_dt", length));
			String[] rptid = (JSPUtil.getParameter(request, prefix	+ "rptid", length));
			String[] bkgStsCdF = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd_f", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] trunkFlag = (JSPUtil.getParameter(request, prefix	+ "trunk_flag", length));
			String[] spCargoAk = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_ak", length));
			String[] polCd2 = (JSPUtil.getParameter(request, prefix	+ "pol_cd2", length));
			String[] podTs = (JSPUtil.getParameter(request, prefix	+ "pod_ts", length));
			String[] rptId = (JSPUtil.getParameter(request, prefix	+ "rpt_id", length));
			String[] arrToDt = (JSPUtil.getParameter(request, prefix	+ "arr_to_dt", length));
			String[] sailToDt = (JSPUtil.getParameter(request, prefix	+ "sail_to_dt", length));
			String[] orderby = (JSPUtil.getParameter(request, prefix	+ "orderby", length));
			String[] nonSpCargo = (JSPUtil.getParameter(request, prefix	+ "non_sp_cargo", length));
			String[] spCargoSt = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_st", length));
			String[] scRfaGbn = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_gbn", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] blSrndOfcCd = (JSPUtil.getParameter(request, prefix	+ "bl_srnd_ofc_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] rfFlg = (JSPUtil.getParameter(request, prefix	+ "rf_flg", length));
			String[] internetBl = (JSPUtil.getParameter(request, prefix	+ "internet_bl", length));
			String[] blStsCd = (JSPUtil.getParameter(request, prefix	+ "bl_sts_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] localTs = (JSPUtil.getParameter(request, prefix	+ "local_ts", length));
			String[] blRlseOfcCd = (JSPUtil.getParameter(request, prefix	+ "bl_rlse_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spCargoRf = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_rf", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] bkgToDt = (JSPUtil.getParameter(request, prefix	+ "bkg_to_dt", length));
			String[] spCargoRd = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_rd", length));
			String[] polLocal = (JSPUtil.getParameter(request, prefix	+ "pol_local", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] deliMode = (JSPUtil.getParameter(request, prefix	+ "deli_mode", length));
			String[] custTpCdS = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_s", length));
			String[] polTs = (JSPUtil.getParameter(request, prefix	+ "pol_ts", length));
			String[] custTpCdN = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_n", length));
			String[] frtChgTpCd = (JSPUtil.getParameter(request, prefix	+ "frt_chg_tp_cd", length));
			String[] podCd2 = (JSPUtil.getParameter(request, prefix	+ "pod_cd2", length));
			String[] blPrnFromDt = (JSPUtil.getParameter(request, prefix	+ "bl_prn_from_dt", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] custTpCdF = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_f", length));
			String[] pBkgRptKndCd = (JSPUtil.getParameter(request, prefix	+ "p_bkg_rpt_knd_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custTpCdC = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_c", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] custTpCdA = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_a", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] cptrOfcCd = (JSPUtil.getParameter(request, prefix	+ "cptr_ofc_cd", length));
			String[] spCargoHp = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_hp", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] delCd2 = (JSPUtil.getParameter(request, prefix	+ "del_cd2", length));
			String[] hngrFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_flg", length));
			String[] bkgFromDt = (JSPUtil.getParameter(request, prefix	+ "bkg_from_dt", length));
			String[] podLocal = (JSPUtil.getParameter(request, prefix	+ "pod_local", length));
			String[] blPrnToDt = (JSPUtil.getParameter(request, prefix	+ "bl_prn_to_dt", length));
			String[] spCargoDg = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_dg", length));
			String[] bkgStaff = (JSPUtil.getParameter(request, prefix	+ "bkg_staff", length));
			String[] cgoRlseStsCd = (JSPUtil.getParameter(request, prefix	+ "cgo_rlse_sts_cd", length));
			String[] rTerm = (JSPUtil.getParameter(request, prefix	+ "r_term", length));
			
			for (int i = 0; i < length; i++) {
				model = new CmBkgRptVO();
				if (porCd2[i] != null)
					model.setPorCd2(porCd2[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (holding[i] != null)
					model.setHolding(holding[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (arrFromDt[i] != null)
					model.setArrFromDt(arrFromDt[i]);
				if (sailFromDt[i] != null)
					model.setSailFromDt(sailFromDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trfCd[i] != null)
					model.setTrfCd(trfCd[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (spCargoGh[i] != null)
					model.setSpCargoGh(spCargoGh[i]);
				if (spCargoSc[i] != null)
					model.setSpCargoSc(spCargoSc[i]);
				if (vvdCd2[i] != null)
					model.setVvdCd2(vvdCd2[i]);
				if (bkgStaffType[i] != null)
					model.setBkgStaffType(bkgStaffType[i]);
				if (spCargoPc[i] != null)
					model.setSpCargoPc(spCargoPc[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (oblIssUsrId[i] != null)
					model.setOblIssUsrId(oblIssUsrId[i]);
				if (polYardCd[i] != null)
					model.setPolYardCd(polYardCd[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (vslSlanDirCd[i] != null)
					model.setVslSlanDirCd(vslSlanDirCd[i]);
				if (bkgStsCdW[i] != null)
					model.setBkgStsCdW(bkgStsCdW[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (dTerm[i] != null)
					model.setDTerm(dTerm[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (blSrndToDt[i] != null)
					model.setBlSrndToDt(blSrndToDt[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (spCargoBb[i] != null)
					model.setSpCargoBb(spCargoBb[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (podYardCd[i] != null)
					model.setPodYardCd(podYardCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blSrndFromDt[i] != null)
					model.setBlSrndFromDt(blSrndFromDt[i]);
				if (rptid[i] != null)
					model.setRptid(rptid[i]);
				if (bkgStsCdF[i] != null)
					model.setBkgStsCdF(bkgStsCdF[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (trunkFlag[i] != null)
					model.setTrunkFlag(trunkFlag[i]);
				if (spCargoAk[i] != null)
					model.setSpCargoAk(spCargoAk[i]);
				if (polCd2[i] != null)
					model.setPolCd2(polCd2[i]);
				if (podTs[i] != null)
					model.setPodTs(podTs[i]);
				if (rptId[i] != null)
					model.setRptId(rptId[i]);
				if (arrToDt[i] != null)
					model.setArrToDt(arrToDt[i]);
				if (sailToDt[i] != null)
					model.setSailToDt(sailToDt[i]);
				if (orderby[i] != null)
					model.setOrderby(orderby[i]);
				if (nonSpCargo[i] != null)
					model.setNonSpCargo(nonSpCargo[i]);
				if (spCargoSt[i] != null)
					model.setSpCargoSt(spCargoSt[i]);
				if (scRfaGbn[i] != null)
					model.setScRfaGbn(scRfaGbn[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (blSrndOfcCd[i] != null)
					model.setBlSrndOfcCd(blSrndOfcCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (rfFlg[i] != null)
					model.setRfFlg(rfFlg[i]);
				if (internetBl[i] != null)
					model.setInternetBl(internetBl[i]);
				if (blStsCd[i] != null)
					model.setBlStsCd(blStsCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (localTs[i] != null)
					model.setLocalTs(localTs[i]);
				if (blRlseOfcCd[i] != null)
					model.setBlRlseOfcCd(blRlseOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spCargoRf[i] != null)
					model.setSpCargoRf(spCargoRf[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (bkgToDt[i] != null)
					model.setBkgToDt(bkgToDt[i]);
				if (spCargoRd[i] != null)
					model.setSpCargoRd(spCargoRd[i]);
				if (polLocal[i] != null)
					model.setPolLocal(polLocal[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (deliMode[i] != null)
					model.setDeliMode(deliMode[i]);
				if (custTpCdS[i] != null)
					model.setCustTpCdS(custTpCdS[i]);
				if (polTs[i] != null)
					model.setPolTs(polTs[i]);
				if (custTpCdN[i] != null)
					model.setCustTpCdN(custTpCdN[i]);
				if (frtChgTpCd[i] != null)
					model.setFrtChgTpCd(frtChgTpCd[i]);
				if (podCd2[i] != null)
					model.setPodCd2(podCd2[i]);
				if (blPrnFromDt[i] != null)
					model.setBlPrnFromDt(blPrnFromDt[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (custTpCdF[i] != null)
					model.setCustTpCdF(custTpCdF[i]);
				if (pBkgRptKndCd[i] != null)
					model.setPBkgRptKndCd(pBkgRptKndCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custTpCdC[i] != null)
					model.setCustTpCdC(custTpCdC[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (custTpCdA[i] != null)
					model.setCustTpCdA(custTpCdA[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (cptrOfcCd[i] != null)
					model.setCptrOfcCd(cptrOfcCd[i]);
				if (spCargoHp[i] != null)
					model.setSpCargoHp(spCargoHp[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (delCd2[i] != null)
					model.setDelCd2(delCd2[i]);
				if (hngrFlg[i] != null)
					model.setHngrFlg(hngrFlg[i]);
				if (bkgFromDt[i] != null)
					model.setBkgFromDt(bkgFromDt[i]);
				if (podLocal[i] != null)
					model.setPodLocal(podLocal[i]);
				if (blPrnToDt[i] != null)
					model.setBlPrnToDt(blPrnToDt[i]);
				if (spCargoDg[i] != null)
					model.setSpCargoDg(spCargoDg[i]);
				if (bkgStaff[i] != null)
					model.setBkgStaff(bkgStaff[i]);
				if (cgoRlseStsCd[i] != null)
					model.setCgoRlseStsCd(cgoRlseStsCd[i]);
				if (rTerm[i] != null)
					model.setRTerm(rTerm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCmBkgRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CmBkgRptVO[]
	 */
	public CmBkgRptVO[] getCmBkgRptVOs(){
		CmBkgRptVO[] vos = (CmBkgRptVO[])models.toArray(new CmBkgRptVO[models.size()]);
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
		this.porCd2 = this.porCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holding = this.holding .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFromDt = this.arrFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailFromDt = this.sailFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCd = this.trfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoGh = this.spCargoGh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoSc = this.spCargoSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd2 = this.vvdCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStaffType = this.bkgStaffType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoPc = this.spCargoPc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssUsrId = this.oblIssUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYardCd = this.polYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanDirCd = this.vslSlanDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCdW = this.bkgStsCdW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTerm = this.dTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrndToDt = this.blSrndToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoBb = this.spCargoBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYardCd = this.podYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrndFromDt = this.blSrndFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptid = this.rptid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCdF = this.bkgStsCdF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkFlag = this.trunkFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoAk = this.spCargoAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd2 = this.polCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTs = this.podTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptId = this.rptId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrToDt = this.arrToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailToDt = this.sailToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderby = this.orderby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonSpCargo = this.nonSpCargo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoSt = this.spCargoSt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaGbn = this.scRfaGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrndOfcCd = this.blSrndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfFlg = this.rfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.internetBl = this.internetBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blStsCd = this.blStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localTs = this.localTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRlseOfcCd = this.blRlseOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoRf = this.spCargoRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgToDt = this.bkgToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoRd = this.spCargoRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLocal = this.polLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deliMode = this.deliMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdS = this.custTpCdS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polTs = this.polTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdN = this.custTpCdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtChgTpCd = this.frtChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd2 = this.podCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPrnFromDt = this.blPrnFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdF = this.custTpCdF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBkgRptKndCd = this.pBkgRptKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdC = this.custTpCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdA = this.custTpCdA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cptrOfcCd = this.cptrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoHp = this.spCargoHp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd2 = this.delCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlg = this.hngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFromDt = this.bkgFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLocal = this.podLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPrnToDt = this.blPrnToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoDg = this.spCargoDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStaff = this.bkgStaff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoRlseStsCd = this.cgoRlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rTerm = this.rTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
