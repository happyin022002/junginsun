/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OutBdMovementStsListInVO.java
*@FileTitle : OutBdMovementStsListInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.24  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OutBdMovementStsListInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OutBdMovementStsListInVO> models = new ArrayList<OutBdMovementStsListInVO>();
	
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String pre1Vvd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgDtTo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String destTrnsSvcModCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String chkIncClm = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String eqSubstTpszCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String xterBkgRqstCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String bkgDtFr = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String arrSteCd = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String bkgRank = null;
	/* Column Info */
	private String chkLtType = null;
	/* Column Info */
	private String cntrVolQty = null;
	/* Column Info */
	private String arrLocNm = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String ofcIncSub = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String arrDt = null;
	/* Column Info */
	private String trunkVvd = null;
	/* Column Info */
	private String deTermCdMv = null;
	/* Column Info */
	private String rf = null;
	/* Column Info */
	private String advShtgCd = null;
	/* Column Info */
	private String rcvTermCdMv = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dg = null;
	/* Column Info */
	private String clmSghtCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String keyPolCd = null;
	/* Column Info */
	private String cntrTpszCdMv = null;
	/* Column Info */
	private String subgroupTitle = null;
	/* Column Info */
	private String cntrCfmFlg = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String depDt = null;
	/* Column Info */
	private String ak = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String pre1PolCd = null;
	/* Column Info */
	private String vpsCctDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String dgSts = null;
	/* Column Info */
	private String rfSts = null;
	/* Column Info */
	private String akSts = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String cbkgNo = null;
	/* Column Info */
	private String clmDt = null;
	/* Column Info */
	private String cntrCheck = null;
	/* Column Info */
	private String chkDupVvd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String comboFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OutBdMovementStsListInVO() {}

	public OutBdMovementStsListInVO(String ibflag, String pagerows, String rnum, String trunkVvd, String bkgNo, String bkgRank, String bkgStsCd, String custNm, String bkgCgoTpCd, String porCd, String podCd, String polCd, String delCd, String cntrTpszCd, String opCntrQty, String rcvTermCd, String deTermCd, String cntrNo, String cntrTpszCdMv, String cntrVolQty, String eqSubstTpszCd, String advShtgCd, String cnmvStsCd, String orgYdCd, String cnmvEvntDt, String vpsCctDt, String vpsEtdDt, String pre1Vvd, String rcvTermCdMv, String deTermCdMv, String bkgCreDt, String cntrPrtFlg, String cntrCfmFlg, String cnmvYr, String cnmvIdNo, String cnmvCycNo, String destTrnsSvcModCd, String xterBkgRqstCd, String pre1PolCd, String keyPolCd, String clmSghtCd, String arrLocNm, String arrSteCd, String arrDt, String depDt, String vslPrePstCd, String dg, String rf, String ak, String subgroupTitle, String vvdCd, String ofcIncSub, String custTpCd, String custCntCd, String custSeq, String chkLtType, String chkIncClm, String bkgDtFr, String bkgDtTo, String bkgOfcCd, String dgSts, String rfSts, String akSts, String copNo, String cbkgNo, String clmDt, String cntrCheck, String chkDupVvd, String trdCd, String subTrdCd, String rlaneCd, String comboFlg) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.pre1Vvd = pre1Vvd;
		this.pagerows = pagerows;
		this.bkgDtTo = bkgDtTo;
		this.polCd = polCd;
		this.delCd = delCd;
		this.destTrnsSvcModCd = destTrnsSvcModCd;
		this.vvdCd = vvdCd;
		this.rnum = rnum;
		this.chkIncClm = chkIncClm;
		this.cntrTpszCd = cntrTpszCd;
		this.bkgCreDt = bkgCreDt;
		this.custCntCd = custCntCd;
		this.eqSubstTpszCd = eqSubstTpszCd;
		this.bkgOfcCd = bkgOfcCd;
		this.cntrPrtFlg = cntrPrtFlg;
		this.xterBkgRqstCd = xterBkgRqstCd;
		this.vpsEtdDt = vpsEtdDt;
		this.cnmvEvntDt = cnmvEvntDt;
		this.bkgDtFr = bkgDtFr;
		this.cnmvIdNo = cnmvIdNo;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.arrSteCd = arrSteCd;
		this.opCntrQty = opCntrQty;
		this.bkgRank = bkgRank;
		this.chkLtType = chkLtType;
		this.cntrVolQty = cntrVolQty;
		this.arrLocNm = arrLocNm;
		this.porCd = porCd;
		this.cnmvCycNo = cnmvCycNo;
		this.custNm = custNm;
		this.ofcIncSub = ofcIncSub;
		this.bkgStsCd = bkgStsCd;
		this.arrDt = arrDt;
		this.trunkVvd = trunkVvd;
		this.deTermCdMv = deTermCdMv;
		this.rf = rf;
		this.advShtgCd = advShtgCd;
		this.rcvTermCdMv = rcvTermCdMv;
		this.cnmvStsCd = cnmvStsCd;
		this.ibflag = ibflag;
		this.dg = dg;
		this.clmSghtCd = clmSghtCd;
		this.rcvTermCd = rcvTermCd;
		this.vslPrePstCd = vslPrePstCd;
		this.custTpCd = custTpCd;
		this.keyPolCd = keyPolCd;
		this.cntrTpszCdMv = cntrTpszCdMv;
		this.subgroupTitle = subgroupTitle;
		this.cntrCfmFlg = cntrCfmFlg;
		this.custSeq = custSeq;
		this.orgYdCd = orgYdCd;
		this.depDt = depDt;
		this.ak = ak;
		this.deTermCd = deTermCd;
		this.pre1PolCd = pre1PolCd;
		this.vpsCctDt = vpsCctDt;
		this.cntrNo = cntrNo;
		this.cnmvYr = cnmvYr;
		this.dgSts = dgSts;
		this.rfSts = rfSts;
		this.akSts = akSts;
		this.copNo = copNo;
		this.cbkgNo = cbkgNo;
		this.clmDt = clmDt;
		this.cntrCheck = cntrCheck;
		this.chkDupVvd = chkDupVvd;
		this.trdCd = trdCd;
		this.subTrdCd = subTrdCd;
		this.rlaneCd = rlaneCd;
		this.comboFlg = comboFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("pre_1_vvd", getPre1Vvd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_dt_to", getBkgDtTo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("dest_trns_svc_mod_cd", getDestTrnsSvcModCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("chk_inc_clm", getChkIncClm());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("eq_subst_tpsz_cd", getEqSubstTpszCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("xter_bkg_rqst_cd", getXterBkgRqstCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("bkg_dt_fr", getBkgDtFr());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("arr_ste_cd", getArrSteCd());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("bkg_rank", getBkgRank());
		this.hashColumns.put("chk_lt_type", getChkLtType());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		this.hashColumns.put("arr_loc_nm", getArrLocNm());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("ofc_inc_sub", getOfcIncSub());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("arr_dt", getArrDt());
		this.hashColumns.put("trunk_vvd", getTrunkVvd());
		this.hashColumns.put("de_term_cd_mv", getDeTermCdMv());
		this.hashColumns.put("rf", getRf());
		this.hashColumns.put("adv_shtg_cd", getAdvShtgCd());
		this.hashColumns.put("rcv_term_cd_mv", getRcvTermCdMv());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dg", getDg());
		this.hashColumns.put("clm_sght_cd", getClmSghtCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("key_pol_cd", getKeyPolCd());
		this.hashColumns.put("cntr_tpsz_cd_mv", getCntrTpszCdMv());
		this.hashColumns.put("subgroup_title", getSubgroupTitle());
		this.hashColumns.put("cntr_cfm_flg", getCntrCfmFlg());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("dep_dt", getDepDt());
		this.hashColumns.put("ak", getAk());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("pre_1_pol_cd", getPre1PolCd());
		this.hashColumns.put("vps_cct_dt", getVpsCctDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("dg_sts", getDgSts());
		this.hashColumns.put("rf_sts", getRfSts());
		this.hashColumns.put("ak_sts", getAkSts());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("cbkg_no", getCbkgNo());
		this.hashColumns.put("clm_dt", getClmDt());
		this.hashColumns.put("cntr_check", getCntrCheck());
		this.hashColumns.put("chk_dup_vvd", getChkDupVvd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("combo_flg", getComboFlg());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("pre_1_vvd", "pre1Vvd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_dt_to", "bkgDtTo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("dest_trns_svc_mod_cd", "destTrnsSvcModCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("chk_inc_clm", "chkIncClm");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("eq_subst_tpsz_cd", "eqSubstTpszCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("xter_bkg_rqst_cd", "xterBkgRqstCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("bkg_dt_fr", "bkgDtFr");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("arr_ste_cd", "arrSteCd");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("bkg_rank", "bkgRank");
		this.hashFields.put("chk_lt_type", "chkLtType");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		this.hashFields.put("arr_loc_nm", "arrLocNm");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("ofc_inc_sub", "ofcIncSub");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("arr_dt", "arrDt");
		this.hashFields.put("trunk_vvd", "trunkVvd");
		this.hashFields.put("de_term_cd_mv", "deTermCdMv");
		this.hashFields.put("rf", "rf");
		this.hashFields.put("adv_shtg_cd", "advShtgCd");
		this.hashFields.put("rcv_term_cd_mv", "rcvTermCdMv");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dg", "dg");
		this.hashFields.put("clm_sght_cd", "clmSghtCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("key_pol_cd", "keyPolCd");
		this.hashFields.put("cntr_tpsz_cd_mv", "cntrTpszCdMv");
		this.hashFields.put("subgroup_title", "subgroupTitle");
		this.hashFields.put("cntr_cfm_flg", "cntrCfmFlg");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("dep_dt", "depDt");
		this.hashFields.put("ak", "ak");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("pre_1_pol_cd", "pre1PolCd");
		this.hashFields.put("vps_cct_dt", "vpsCctDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("dg_sts", "dgSts");
		this.hashFields.put("rf_sts", "rfSts");
		this.hashFields.put("ak_sts", "akSts");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("cbkg_no", "cbkgNo");
		this.hashFields.put("clm_dt", "clmDt");
		this.hashFields.put("cntr_check", "cntrCheck");
		this.hashFields.put("chk_dup_vvd", "chkDupVvd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("combo_flg", "comboFlg");
		
		return this.hashFields;
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
	 * @return pre1Vvd
	 */
	public String getPre1Vvd() {
		return this.pre1Vvd;
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
	 * @return bkgDtTo
	 */
	public String getBkgDtTo() {
		return this.bkgDtTo;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return destTrnsSvcModCd
	 */
	public String getDestTrnsSvcModCd() {
		return this.destTrnsSvcModCd;
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
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return chkIncClm
	 */
	public String getChkIncClm() {
		return this.chkIncClm;
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
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
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
	 * @return eqSubstTpszCd
	 */
	public String getEqSubstTpszCd() {
		return this.eqSubstTpszCd;
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
	 * @return cntrPrtFlg
	 */
	public String getCntrPrtFlg() {
		return this.cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @return xterBkgRqstCd
	 */
	public String getXterBkgRqstCd() {
		return this.xterBkgRqstCd;
	}
	
	/**
	 * Column Info
	 * @return chkDupVvd
	 */
	public String getChkDupVvd() {
		return this.chkDupVvd;
	}
	
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return bkgDtFr
	 */
	public String getBkgDtFr() {
		return this.bkgDtFr;
	}
	
	/**
	 * Column Info
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
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
	 * @return cbkgNo
	 */
	public String getCbkgNo() {
		return this.cbkgNo;
	}
	
	/**
	 * Column Info
	 * @return arrSteCd
	 */
	public String getArrSteCd() {
		return this.arrSteCd;
	}
	
	/**
	 * Column Info
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return bkgRank
	 */
	public String getBkgRank() {
		return this.bkgRank;
	}
	
	/**
	 * Column Info
	 * @return chkLtType
	 */
	public String getChkLtType() {
		return this.chkLtType;
	}
	
	/**
	 * Column Info
	 * @return cntrVolQty
	 */
	public String getCntrVolQty() {
		return this.cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return arrLocNm
	 */
	public String getArrLocNm() {
		return this.arrLocNm;
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
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
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
	 * @return ofcIncSub
	 */
	public String getOfcIncSub() {
		return this.ofcIncSub;
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
	 * @return arrDt
	 */
	public String getArrDt() {
		return this.arrDt;
	}
	
	/**
	 * Column Info
	 * @return trunkVvd
	 */
	public String getTrunkVvd() {
		return this.trunkVvd;
	}
	
	/**
	 * Column Info
	 * @return deTermCdMv
	 */
	public String getDeTermCdMv() {
		return this.deTermCdMv;
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
	 * @return rcvTermCdMv
	 */
	public String getRcvTermCdMv() {
		return this.rcvTermCdMv;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return dg
	 */
	public String getDg() {
		return this.dg;
	}
	
	/**
	 * Column Info
	 * @return clmSghtCd
	 */
	public String getClmSghtCd() {
		return this.clmSghtCd;
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
	 * @return vslPrePstCd
	 */
	public String getVslPrePstCd() {
		return this.vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return keyPolCd
	 */
	public String getKeyPolCd() {
		return this.keyPolCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCdMv
	 */
	public String getCntrTpszCdMv() {
		return this.cntrTpszCdMv;
	}
	
	/**
	 * Column Info
	 * @return subgroupTitle
	 */
	public String getSubgroupTitle() {
		return this.subgroupTitle;
	}
	
	/**
	 * Column Info
	 * @return cntrCfmFlg
	 */
	public String getCntrCfmFlg() {
		return this.cntrCfmFlg;
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
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return depDt
	 */
	public String getDepDt() {
		return this.depDt;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return pre1PolCd
	 */
	public String getPre1PolCd() {
		return this.pre1PolCd;
	}
	
	/**
	 * Column Info
	 * @return vpsCctDt
	 */
	public String getVpsCctDt() {
		return this.vpsCctDt;
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
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return dgSts
	 */
	public String getDgSts() {
		return this.dgSts;
	}
	
	/**
	 * Column Info
	 * @return rfSts
	 */
	public String getRfSts() {
		return this.rfSts;
	}
	
	/**
	 * Column Info
	 * @return akSts
	 */
	public String getAkSts() {
		return this.akSts;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
		
	}
	
	/**
	 * Column Info
	 * @return clmDt
	 */
	public String getClmDt() {
		return this.clmDt;
		
	}
	
	/**
	 * Column Info
	 * @return cntrCheck
	 */
	public String getCntrCheck() {
		return this.cntrCheck;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return comboFlg
	 */
	public String getComboFlg() {
		return this.comboFlg;
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
	 * @param pre1Vvd
	 */
	public void setPre1Vvd(String pre1Vvd) {
		this.pre1Vvd = pre1Vvd;
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
	 * @param bkgDtTo
	 */
	public void setBkgDtTo(String bkgDtTo) {
		this.bkgDtTo = bkgDtTo;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param destTrnsSvcModCd
	 */
	public void setDestTrnsSvcModCd(String destTrnsSvcModCd) {
		this.destTrnsSvcModCd = destTrnsSvcModCd;
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
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param chkIncClm
	 */
	public void setChkIncClm(String chkIncClm) {
		this.chkIncClm = chkIncClm;
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
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
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
	 * @param eqSubstTpszCd
	 */
	public void setEqSubstTpszCd(String eqSubstTpszCd) {
		this.eqSubstTpszCd = eqSubstTpszCd;
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
	 * @param cntrPrtFlg
	 */
	public void setCntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @param xterBkgRqstCd
	 */
	public void setXterBkgRqstCd(String xterBkgRqstCd) {
		this.xterBkgRqstCd = xterBkgRqstCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param bkgDtFr
	 */
	public void setBkgDtFr(String bkgDtFr) {
		this.bkgDtFr = bkgDtFr;
	}
	
	/**
	 * Column Info
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
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
	 * @param cbkgNo
	 */
	public void setCbkgNo(String cbkgNo) {
		this.cbkgNo = cbkgNo;
	}
	
	/**
	 * Column Info
	 * @param arrSteCd
	 */
	public void setArrSteCd(String arrSteCd) {
		this.arrSteCd = arrSteCd;
	}
	
	/**
	 * Column Info
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param bkgRank
	 */
	public void setBkgRank(String bkgRank) {
		this.bkgRank = bkgRank;
	}
	
	/**
	 * Column Info
	 * @param chkLtType
	 */
	public void setChkLtType(String chkLtType) {
		this.chkLtType = chkLtType;
	}
	
	/**
	 * Column Info
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param arrLocNm
	 */
	public void setArrLocNm(String arrLocNm) {
		this.arrLocNm = arrLocNm;
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
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
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
	 * @param ofcIncSub
	 */
	public void setOfcIncSub(String ofcIncSub) {
		this.ofcIncSub = ofcIncSub;
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
	 * @param arrDt
	 */
	public void setArrDt(String arrDt) {
		this.arrDt = arrDt;
	}
	
	/**
	 * Column Info
	 * @param trunkVvd
	 */
	public void setTrunkVvd(String trunkVvd) {
		this.trunkVvd = trunkVvd;
	}
	
	/**
	 * Column Info
	 * @param deTermCdMv
	 */
	public void setDeTermCdMv(String deTermCdMv) {
		this.deTermCdMv = deTermCdMv;
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
	 * @param rcvTermCdMv
	 */
	public void setRcvTermCdMv(String rcvTermCdMv) {
		this.rcvTermCdMv = rcvTermCdMv;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param dg
	 */
	public void setDg(String dg) {
		this.dg = dg;
	}
	
	/**
	 * Column Info
	 * @param clmSghtCd
	 */
	public void setClmSghtCd(String clmSghtCd) {
		this.clmSghtCd = clmSghtCd;
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
	 * @param vslPrePstCd
	 */
	public void setVslPrePstCd(String vslPrePstCd) {
		this.vslPrePstCd = vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param keyPolCd
	 */
	public void setKeyPolCd(String keyPolCd) {
		this.keyPolCd = keyPolCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCdMv
	 */
	public void setCntrTpszCdMv(String cntrTpszCdMv) {
		this.cntrTpszCdMv = cntrTpszCdMv;
	}
	
	/**
	 * Column Info
	 * @param subgroupTitle
	 */
	public void setSubgroupTitle(String subgroupTitle) {
		this.subgroupTitle = subgroupTitle;
	}
	
	/**
	 * Column Info
	 * @param cntrCfmFlg
	 */
	public void setCntrCfmFlg(String cntrCfmFlg) {
		this.cntrCfmFlg = cntrCfmFlg;
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
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param depDt
	 */
	public void setDepDt(String depDt) {
		this.depDt = depDt;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param pre1PolCd
	 */
	public void setPre1PolCd(String pre1PolCd) {
		this.pre1PolCd = pre1PolCd;
	}
	
	/**
	 * Column Info
	 * @param vpsCctDt
	 */
	public void setVpsCctDt(String vpsCctDt) {
		this.vpsCctDt = vpsCctDt;
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
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param dgSts
	 */
	public void setDgSts(String dgSts) {
		this.dgSts = dgSts;
	}
	
	/**
	 * Column Info
	 * @param rfSts
	 */
	public void setRfSts(String rfSts) {
		this.rfSts = rfSts;
	}
	
	/**
	 * Column Info
	 * @param akSts
	 */
	public void setAkSts(String akSts) {
		this.akSts = akSts;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param clmDt
	 */
	public void setClmDt(String clmDt) {
		this.clmDt = clmDt;
	}
	
	/**
	 * Column Info
	 * @param cntrCheck
	 */
	public void setCntrCheck(String cntrCheck) {
		this.cntrCheck = cntrCheck;
	}
	
	/**
	 * Column Info
	 * @param chkDupVvd
	 */
	public void setChkDupVvd(String chkDupVvd) {
		this.chkDupVvd = chkDupVvd;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param comboFlg
	 */
	public void setComboFlg(String comboFlg) {
		this.comboFlg = comboFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setPre1Vvd(JSPUtil.getParameter(request, "pre_1_vvd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBkgDtTo(JSPUtil.getParameter(request, "bkg_dt_to", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setDestTrnsSvcModCd(JSPUtil.getParameter(request, "dest_trns_svc_mod_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setRnum(JSPUtil.getParameter(request, "rnum", ""));
		setChkIncClm(JSPUtil.getParameter(request, "chk_inc_clm", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setBkgCreDt(JSPUtil.getParameter(request, "bkg_cre_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setEqSubstTpszCd(JSPUtil.getParameter(request, "eq_subst_tpsz_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, "cntr_prt_flg", ""));
		setXterBkgRqstCd(JSPUtil.getParameter(request, "xter_bkg_rqst_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, "cnmv_evnt_dt", ""));
		setBkgDtFr(JSPUtil.getParameter(request, "bkg_dt_fr", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, "cnmv_id_no", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCbkgNo(JSPUtil.getParameter(request, "cbkg_no", ""));
		setArrSteCd(JSPUtil.getParameter(request, "arr_ste_cd", ""));
		setOpCntrQty(JSPUtil.getParameter(request, "op_cntr_qty", ""));
		setBkgRank(JSPUtil.getParameter(request, "bkg_rank", ""));
		setChkLtType(JSPUtil.getParameter(request, "chk_lt_type", ""));
		setCntrVolQty(JSPUtil.getParameter(request, "cntr_vol_qty", ""));
		setArrLocNm(JSPUtil.getParameter(request, "arr_loc_nm", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, "cnmv_cyc_no", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setOfcIncSub(JSPUtil.getParameter(request, "ofc_inc_sub", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setArrDt(JSPUtil.getParameter(request, "arr_dt", ""));
		setTrunkVvd(JSPUtil.getParameter(request, "trunk_vvd", ""));
		setDeTermCdMv(JSPUtil.getParameter(request, "de_term_cd_mv", ""));
		setRf(JSPUtil.getParameter(request, "rf", ""));
		setAdvShtgCd(JSPUtil.getParameter(request, "adv_shtg_cd", ""));
		setRcvTermCdMv(JSPUtil.getParameter(request, "rcv_term_cd_mv", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDg(JSPUtil.getParameter(request, "dg", ""));
		setClmSghtCd(JSPUtil.getParameter(request, "clm_sght_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, "vsl_pre_pst_cd", ""));
		setCustTpCd(JSPUtil.getParameter(request, "cust_tp_cd", ""));
		setKeyPolCd(JSPUtil.getParameter(request, "key_pol_cd", ""));
		setCntrTpszCdMv(JSPUtil.getParameter(request, "cntr_tpsz_cd_mv", ""));
		setSubgroupTitle(JSPUtil.getParameter(request, "subgroup_title", ""));
		setCntrCfmFlg(JSPUtil.getParameter(request, "cntr_cfm_flg", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setDepDt(JSPUtil.getParameter(request, "dep_dt", ""));
		setAk(JSPUtil.getParameter(request, "ak", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setPre1PolCd(JSPUtil.getParameter(request, "pre_1_pol_cd", ""));
		setVpsCctDt(JSPUtil.getParameter(request, "vps_cct_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setDgSts(JSPUtil.getParameter(request, "dg_sts", ""));
		setRfSts(JSPUtil.getParameter(request, "rf_sts", ""));
		setAkSts(JSPUtil.getParameter(request, "ak_sts", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setClmDt(JSPUtil.getParameter(request, "clm_dt", ""));
		setCntrCheck(JSPUtil.getParameter(request, "cntr_check", ""));
		setChkDupVvd(JSPUtil.getParameter(request, "chk_dup_vvd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setComboFlg(JSPUtil.getParameter(request, "combo_flg", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OutBdMovementStsListInVO[]
	 */
	public OutBdMovementStsListInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OutBdMovementStsListInVO[]
	 */
	public OutBdMovementStsListInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OutBdMovementStsListInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] pre1Vvd = (JSPUtil.getParameter(request, prefix	+ "pre_1_vvd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgDtTo = (JSPUtil.getParameter(request, prefix	+ "bkg_dt_to", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] destTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_svc_mod_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] chkIncClm = (JSPUtil.getParameter(request, prefix	+ "chk_inc_clm", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] eqSubstTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_subst_tpsz_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] xterBkgRqstCd = (JSPUtil.getParameter(request, prefix	+ "xter_bkg_rqst_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] bkgDtFr = (JSPUtil.getParameter(request, prefix	+ "bkg_dt_fr", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cbkgNo = (JSPUtil.getParameter(request, prefix	+ "cbkg_no", length));
			String[] arrSteCd = (JSPUtil.getParameter(request, prefix	+ "arr_ste_cd", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] bkgRank = (JSPUtil.getParameter(request, prefix	+ "bkg_rank", length));
			String[] chkLtType = (JSPUtil.getParameter(request, prefix	+ "chk_lt_type", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			String[] arrLocNm = (JSPUtil.getParameter(request, prefix	+ "arr_loc_nm", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] ofcIncSub = (JSPUtil.getParameter(request, prefix	+ "ofc_inc_sub", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] arrDt = (JSPUtil.getParameter(request, prefix	+ "arr_dt", length));
			String[] trunkVvd = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd", length));
			String[] deTermCdMv = (JSPUtil.getParameter(request, prefix	+ "de_term_cd_mv", length));
			String[] rf = (JSPUtil.getParameter(request, prefix	+ "rf", length));
			String[] advShtgCd = (JSPUtil.getParameter(request, prefix	+ "adv_shtg_cd", length));
			String[] rcvTermCdMv = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd_mv", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dg = (JSPUtil.getParameter(request, prefix	+ "dg", length));
			String[] clmSghtCd = (JSPUtil.getParameter(request, prefix	+ "clm_sght_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] keyPolCd = (JSPUtil.getParameter(request, prefix	+ "key_pol_cd", length));
			String[] cntrTpszCdMv = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd_mv", length));
			String[] subgroupTitle = (JSPUtil.getParameter(request, prefix	+ "subgroup_title", length));
			String[] cntrCfmFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_cfm_flg", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] depDt = (JSPUtil.getParameter(request, prefix	+ "dep_dt", length));
			String[] ak = (JSPUtil.getParameter(request, prefix	+ "ak", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] pre1PolCd = (JSPUtil.getParameter(request, prefix	+ "pre_1_pol_cd", length));
			String[] vpsCctDt = (JSPUtil.getParameter(request, prefix	+ "vps_cct_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] dgSts = (JSPUtil.getParameter(request, prefix	+ "dg_sts", length));
			String[] rfSts = (JSPUtil.getParameter(request, prefix	+ "rf_sts", length));
			String[] akSts = (JSPUtil.getParameter(request, prefix	+ "ak_sts", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] clmDt = (JSPUtil.getParameter(request, prefix	+ "clm_dt", length));
			String[] cntrCheck = (JSPUtil.getParameter(request, prefix	+ "cntr_check", length));
			String[] chkDupVvd = (JSPUtil.getParameter(request, prefix	+ "chk_dup_vvd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] comboFlg = (JSPUtil.getParameter(request, prefix	+ "combo_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new OutBdMovementStsListInVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (pre1Vvd[i] != null)
					model.setPre1Vvd(pre1Vvd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgDtTo[i] != null)
					model.setBkgDtTo(bkgDtTo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (destTrnsSvcModCd[i] != null)
					model.setDestTrnsSvcModCd(destTrnsSvcModCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (chkIncClm[i] != null)
					model.setChkIncClm(chkIncClm[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (eqSubstTpszCd[i] != null)
					model.setEqSubstTpszCd(eqSubstTpszCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (xterBkgRqstCd[i] != null)
					model.setXterBkgRqstCd(xterBkgRqstCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (bkgDtFr[i] != null)
					model.setBkgDtFr(bkgDtFr[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cbkgNo[i] != null)
					model.setCbkgNo(cbkgNo[i]);
				if (arrSteCd[i] != null)
					model.setArrSteCd(arrSteCd[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (bkgRank[i] != null)
					model.setBkgRank(bkgRank[i]);
				if (chkLtType[i] != null)
					model.setChkLtType(chkLtType[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				if (arrLocNm[i] != null)
					model.setArrLocNm(arrLocNm[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (ofcIncSub[i] != null)
					model.setOfcIncSub(ofcIncSub[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (arrDt[i] != null)
					model.setArrDt(arrDt[i]);
				if (trunkVvd[i] != null)
					model.setTrunkVvd(trunkVvd[i]);
				if (deTermCdMv[i] != null)
					model.setDeTermCdMv(deTermCdMv[i]);
				if (rf[i] != null)
					model.setRf(rf[i]);
				if (advShtgCd[i] != null)
					model.setAdvShtgCd(advShtgCd[i]);
				if (rcvTermCdMv[i] != null)
					model.setRcvTermCdMv(rcvTermCdMv[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dg[i] != null)
					model.setDg(dg[i]);
				if (clmSghtCd[i] != null)
					model.setClmSghtCd(clmSghtCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (keyPolCd[i] != null)
					model.setKeyPolCd(keyPolCd[i]);
				if (cntrTpszCdMv[i] != null)
					model.setCntrTpszCdMv(cntrTpszCdMv[i]);
				if (subgroupTitle[i] != null)
					model.setSubgroupTitle(subgroupTitle[i]);
				if (cntrCfmFlg[i] != null)
					model.setCntrCfmFlg(cntrCfmFlg[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (depDt[i] != null)
					model.setDepDt(depDt[i]);
				if (ak[i] != null)
					model.setAk(ak[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (pre1PolCd[i] != null)
					model.setPre1PolCd(pre1PolCd[i]);
				if (vpsCctDt[i] != null)
					model.setVpsCctDt(vpsCctDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (dgSts[i] != null)
					model.setDgSts(dgSts[i]);
				if (rfSts[i] != null)
					model.setRfSts(rfSts[i]);
				if (akSts[i] != null)
					model.setAkSts(akSts[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (clmDt[i] != null)
					model.setClmDt(clmDt[i]);
				if (cntrCheck[i] != null)
					model.setCntrCheck(cntrCheck[i]);
				if (chkDupVvd[i] != null)
					model.setChkDupVvd(chkDupVvd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (comboFlg[i] != null)
					model.setComboFlg(comboFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOutBdMovementStsListInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OutBdMovementStsListInVO[]
	 */
	public OutBdMovementStsListInVO[] getOutBdMovementStsListInVOs(){
		OutBdMovementStsListInVO[] vos = (OutBdMovementStsListInVO[])models.toArray(new OutBdMovementStsListInVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre1Vvd = this.pre1Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDtTo = this.bkgDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsSvcModCd = this.destTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkIncClm = this.chkIncClm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstTpszCd = this.eqSubstTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBkgRqstCd = this.xterBkgRqstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDtFr = this.bkgDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbkgNo = this.cbkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrSteCd = this.arrSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRank = this.bkgRank .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkLtType = this.chkLtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLocNm = this.arrLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcIncSub = this.ofcIncSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDt = this.arrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvd = this.trunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCdMv = this.deTermCdMv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf = this.rf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advShtgCd = this.advShtgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCdMv = this.rcvTermCdMv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg = this.dg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmSghtCd = this.clmSghtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyPolCd = this.keyPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCdMv = this.cntrTpszCdMv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subgroupTitle = this.subgroupTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCfmFlg = this.cntrCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDt = this.depDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak = this.ak .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre1PolCd = this.pre1PolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsCctDt = this.vpsCctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgSts = this.dgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfSts = this.rfSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akSts = this.akSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmDt = this.clmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCheck = this.cntrCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDupVvd = this.chkDupVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboFlg = this.comboFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
