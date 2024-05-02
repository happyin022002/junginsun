/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchStandbyBKGRPTMSTVO.java
*@FileTitle : SearchStandbyBKGRPTMSTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.29
*@LastModifier : Kim sung wook
*@LastVersion : 1.0
* 2015.07.29 Kim sung wook 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo;

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
 * @author Kim sung wook
 * @since J2EE 1.6 
 * @see AbstractValueObject
 */

public class SearchStandbyBKGRPTMSTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchStandbyBKGRPTMSTVO> models = new ArrayList<SearchStandbyBKGRPTMSTVO>();
	
	/* Column Info */
	private String oldOftChgAmt = null;
	/* Column Info */
	private String trunkPolCd = null;
	/* Column Info */
	private String asgnTtlWgt = null;
	/* Column Info */
	private String n1stTsPodCntCd = null;
	/* Column Info */
	private String scNm = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String ubTrdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String bkgCtrlTpCd = null;
	/* Column Info */
	private String agmtActCntCd = null;
	/* Column Info */
	private String oldAasgnWgtRto = null;
	/* Column Info */
	private String alocStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtCustCntNm = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String oldAlocLodQtyRto = null;
	/* Column Info */
	private String n2ndTsPodCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String alocAplyFmDt = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String aplyToYrwk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String feu = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String alocLodQtyRto = null;
	/* Column Info */
	private String aplyFmYrwk = null;
	/* Column Info */
	private String scgGrpCmdtSeq = null;
	/* Column Info */
	private String trnkDirCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String cmpb = null;
	/* Column Info */
	private String n1stTsPolCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String n1stTsDirCd = null;
	/* Column Info */
	private String bkgAlocRmk = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String alocUseFlg = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String bkgDelSccCd = null;
	/* Column Info */
	private String usaBkgModCd = null;
	/* Column Info */
	private String n1stTsPodCd = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String n2ndTsSlanCd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String oldCmpbAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String custCntNm = null;
	/* Column Info */
	private String alocLodQty = null;
	/* Column Info */
	private String bkgDelCntCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rfaNm = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cmpbAmt = null;
	/* Column Info */
	private String trunkPodCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String trnkSlanCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String bkgPolCntCd = null;
	/* Column Info */
	private String asgnWgtRto = null;
	/* Column Info */
	private String bkgAlocTpCd = null;
	/* Column Info */
	private String n1stTsSlanCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String alocSvcCd = null;
	/* Column Info */
	private String oftChgAmt = null;
	/* Column Info */
	private String dgRd = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String standbyType = null;
	/* Column Info */
	private String alocAplyToDt = null;
	/* Column Info */
	private String scgGrpCmdtDesc = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String n2ndTsPolCd = null;
	/* Column Info */
	private String n1stTsPolCntCd = null;
	/* Column Info */
	private String bkgPorSccCd = null;
	/* Column Info */
	private String oldAsgnTtlWgt = null;
	/* Column Info */
	private String oldAlocLodQty = null;
	/* Column Info */
	private String bkgPorCntCd = null;
	/* Column Info */
	private String bkgPodCntCd = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String standbyReason = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchStandbyBKGRPTMSTVO() {}

	public SearchStandbyBKGRPTMSTVO(String ibflag, String pagerows, String bkgNo, String alocSvcCd, String bkgStsCd, String alocStsCd, String bkgAlocTpCd, String teu, String feu, String trdCd, String ubTrdCd, String rlaneCd, String dirCd, String standbyType, String cmpb, String trnkSlanCd, String trnkDirCd, String vvd, String slsRhqCd, String obSlsOfcCd, String bkgPorCntCd, String porCd, String porNodCd, String bkgPorSccCd, String bkgPolCntCd, String polCd, String polNodCd, String n1stTsSlanCd, String n1stTsPolCd, String n1stTsPodCd, String n1stTsDirCd, String n1stTsPolCntCd, String n1stTsPodCntCd, String n2ndTsSlanCd, String n2ndTsPolCd, String n2ndTsPodCd, String bkgPodCntCd, String podCd, String podNodCd, String bkgDelCntCd, String delCd, String delNodCd, String bkgDelSccCd, String scNo, String rfaNo, String ctrtCustCntCd, String custCntCd, String cntrTpszCd, String cmdtCd, String cmdtNm, String scgGrpCmdtSeq, String scgGrpCmdtDesc, String alocLodQty, String oldAlocLodQty, String alocLodQtyRto, String oldAlocLodQtyRto, String asgnTtlWgt, String oldAsgnTtlWgt, String asgnWgtRto, String oldAasgnWgtRto, String bkgAlocRmk, String alocUseFlg, String creUsrId, String creDt, String updUsrId, String updDt, String trunkPolCd, String trunkPodCd, String cmpbAmt, String oldCmpbAmt, String bkgCtrlTpCd, String dcgoFlg, String rdCgoFlg, String agmtActCntCd, String alocAplyFmDt, String alocAplyToDt, String dgRd, String oftChgAmt, String oldOftChgAmt, String usaBkgModCd, String hulBndCd, String aplyFmYrwk, String aplyToYrwk, String ctrtCustCntNm, String custCntNm, String scNm, String rfaNm, String custCtrlCd, String subTrdCd, String standbyReason) {
		this.oldOftChgAmt = oldOftChgAmt;
		this.trunkPolCd = trunkPolCd;
		this.asgnTtlWgt = asgnTtlWgt;
		this.n1stTsPodCntCd = n1stTsPodCntCd;
		this.scNm = scNm;
		this.trdCd = trdCd;
		this.ubTrdCd = ubTrdCd;
		this.rlaneCd = rlaneCd;
		this.bkgCtrlTpCd = bkgCtrlTpCd;
		this.agmtActCntCd = agmtActCntCd;
		this.oldAasgnWgtRto = oldAasgnWgtRto;
		this.alocStsCd = alocStsCd;
		this.pagerows = pagerows;
		this.ctrtCustCntNm = ctrtCustCntNm;
		this.polCd = polCd;
		this.oldAlocLodQtyRto = oldAlocLodQtyRto;
		this.n2ndTsPodCd = n2ndTsPodCd;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.alocAplyFmDt = alocAplyFmDt;
		this.obSlsOfcCd = obSlsOfcCd;
		this.delNodCd = delNodCd;
		this.aplyToYrwk = aplyToYrwk;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.feu = feu;
		this.hulBndCd = hulBndCd;
		this.alocLodQtyRto = alocLodQtyRto;
		this.aplyFmYrwk = aplyFmYrwk;
		this.scgGrpCmdtSeq = scgGrpCmdtSeq;
		this.trnkDirCd = trnkDirCd;
		this.delCd = delCd;
		this.slsRhqCd = slsRhqCd;
		this.cmpb = cmpb;
		this.n1stTsPolCd = n1stTsPolCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.podNodCd = podNodCd;
		this.n1stTsDirCd = n1stTsDirCd;
		this.bkgAlocRmk = bkgAlocRmk;
		this.teu = teu;
		this.alocUseFlg = alocUseFlg;
		this.porCd = porCd;
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.bkgDelSccCd = bkgDelSccCd;
		this.usaBkgModCd = usaBkgModCd;
		this.n1stTsPodCd = n1stTsPodCd;
		this.rdCgoFlg = rdCgoFlg;
		this.n2ndTsSlanCd = n2ndTsSlanCd;
		this.bkgStsCd = bkgStsCd;
		this.oldCmpbAmt = oldCmpbAmt;
		this.creDt = creDt;
		this.custCntNm = custCntNm;
		this.alocLodQty = alocLodQty;
		this.bkgDelCntCd = bkgDelCntCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.rfaNm = rfaNm;
		this.cmdtCd = cmdtCd;
		this.cmpbAmt = cmpbAmt;
		this.trunkPodCd = trunkPodCd;
		this.dcgoFlg = dcgoFlg;
		this.trnkSlanCd = trnkSlanCd;
		this.dirCd = dirCd;
		this.bkgPolCntCd = bkgPolCntCd;
		this.asgnWgtRto = asgnWgtRto;
		this.bkgAlocTpCd = bkgAlocTpCd;
		this.n1stTsSlanCd = n1stTsSlanCd;
		this.updDt = updDt;
		this.porNodCd = porNodCd;
		this.alocSvcCd = alocSvcCd;
		this.oftChgAmt = oftChgAmt;
		this.dgRd = dgRd;
		this.polNodCd = polNodCd;
		this.standbyType = standbyType;
		this.alocAplyToDt = alocAplyToDt;
		this.scgGrpCmdtDesc = scgGrpCmdtDesc;
		this.cmdtNm = cmdtNm;
		this.n2ndTsPolCd = n2ndTsPolCd;
		this.n1stTsPolCntCd = n1stTsPolCntCd;
		this.bkgPorSccCd = bkgPorSccCd;
		this.oldAsgnTtlWgt = oldAsgnTtlWgt;
		this.oldAlocLodQty = oldAlocLodQty;
		this.bkgPorCntCd = bkgPorCntCd;
		this.bkgPodCntCd = bkgPodCntCd;
		this.custCtrlCd = custCtrlCd;
		this.subTrdCd = subTrdCd;
		this.standbyReason = standbyReason;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("old_oft_chg_amt", getOldOftChgAmt());
		this.hashColumns.put("trunk_pol_cd", getTrunkPolCd());
		this.hashColumns.put("asgn_ttl_wgt", getAsgnTtlWgt());
		this.hashColumns.put("n1st_ts_pod_cnt_cd", getN1stTsPodCntCd());
		this.hashColumns.put("sc_nm", getScNm());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("ub_trd_cd", getUbTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("bkg_ctrl_tp_cd", getBkgCtrlTpCd());
		this.hashColumns.put("agmt_act_cnt_cd", getAgmtActCntCd());
		this.hashColumns.put("old_aasgn_wgt_rto", getOldAasgnWgtRto());
		this.hashColumns.put("aloc_sts_cd", getAlocStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_cust_cnt_nm", getCtrtCustCntNm());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("old_aloc_lod_qty_rto", getOldAlocLodQtyRto());
		this.hashColumns.put("n2nd_ts_pod_cd", getN2ndTsPodCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("aloc_aply_fm_dt", getAlocAplyFmDt());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("aply_to_yrwk", getAplyToYrwk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("feu", getFeu());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("aloc_lod_qty_rto", getAlocLodQtyRto());
		this.hashColumns.put("aply_fm_yrwk", getAplyFmYrwk());
		this.hashColumns.put("scg_grp_cmdt_seq", getScgGrpCmdtSeq());
		this.hashColumns.put("trnk_dir_cd", getTrnkDirCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("cmpb", getCmpb());
		this.hashColumns.put("n1st_ts_pol_cd", getN1stTsPolCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("n1st_ts_dir_cd", getN1stTsDirCd());
		this.hashColumns.put("bkg_aloc_rmk", getBkgAlocRmk());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("aloc_use_flg", getAlocUseFlg());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("bkg_del_scc_cd", getBkgDelSccCd());
		this.hashColumns.put("usa_bkg_mod_cd", getUsaBkgModCd());
		this.hashColumns.put("n1st_ts_pod_cd", getN1stTsPodCd());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("n2nd_ts_slan_cd", getN2ndTsSlanCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("old_cmpb_amt", getOldCmpbAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cust_cnt_nm", getCustCntNm());
		this.hashColumns.put("aloc_lod_qty", getAlocLodQty());
		this.hashColumns.put("bkg_del_cnt_cd", getBkgDelCntCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rfa_nm", getRfaNm());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cmpb_amt", getCmpbAmt());
		this.hashColumns.put("trunk_pod_cd", getTrunkPodCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("trnk_slan_cd", getTrnkSlanCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("bkg_pol_cnt_cd", getBkgPolCntCd());
		this.hashColumns.put("asgn_wgt_rto", getAsgnWgtRto());
		this.hashColumns.put("bkg_aloc_tp_cd", getBkgAlocTpCd());
		this.hashColumns.put("n1st_ts_slan_cd", getN1stTsSlanCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("aloc_svc_cd", getAlocSvcCd());
		this.hashColumns.put("oft_chg_amt", getOftChgAmt());
		this.hashColumns.put("dg_rd", getDgRd());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("standby_type", getStandbyType());
		this.hashColumns.put("aloc_aply_to_dt", getAlocAplyToDt());
		this.hashColumns.put("scg_grp_cmdt_desc", getScgGrpCmdtDesc());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("n2nd_ts_pol_cd", getN2ndTsPolCd());
		this.hashColumns.put("n1st_ts_pol_cnt_cd", getN1stTsPolCntCd());
		this.hashColumns.put("bkg_por_scc_cd", getBkgPorSccCd());
		this.hashColumns.put("old_asgn_ttl_wgt", getOldAsgnTtlWgt());
		this.hashColumns.put("old_aloc_lod_qty", getOldAlocLodQty());
		this.hashColumns.put("bkg_por_cnt_cd", getBkgPorCntCd());
		this.hashColumns.put("bkg_pod_cnt_cd", getBkgPodCntCd());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("standby_reason", getStandbyReason());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("old_oft_chg_amt", "oldOftChgAmt");
		this.hashFields.put("trunk_pol_cd", "trunkPolCd");
		this.hashFields.put("asgn_ttl_wgt", "asgnTtlWgt");
		this.hashFields.put("n1st_ts_pod_cnt_cd", "n1stTsPodCntCd");
		this.hashFields.put("sc_nm", "scNm");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("ub_trd_cd", "ubTrdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("bkg_ctrl_tp_cd", "bkgCtrlTpCd");
		this.hashFields.put("agmt_act_cnt_cd", "agmtActCntCd");
		this.hashFields.put("old_aasgn_wgt_rto", "oldAasgnWgtRto");
		this.hashFields.put("aloc_sts_cd", "alocStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_cust_cnt_nm", "ctrtCustCntNm");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("old_aloc_lod_qty_rto", "oldAlocLodQtyRto");
		this.hashFields.put("n2nd_ts_pod_cd", "n2ndTsPodCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("aloc_aply_fm_dt", "alocAplyFmDt");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("aply_to_yrwk", "aplyToYrwk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("feu", "feu");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("aloc_lod_qty_rto", "alocLodQtyRto");
		this.hashFields.put("aply_fm_yrwk", "aplyFmYrwk");
		this.hashFields.put("scg_grp_cmdt_seq", "scgGrpCmdtSeq");
		this.hashFields.put("trnk_dir_cd", "trnkDirCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("cmpb", "cmpb");
		this.hashFields.put("n1st_ts_pol_cd", "n1stTsPolCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("n1st_ts_dir_cd", "n1stTsDirCd");
		this.hashFields.put("bkg_aloc_rmk", "bkgAlocRmk");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("aloc_use_flg", "alocUseFlg");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("bkg_del_scc_cd", "bkgDelSccCd");
		this.hashFields.put("usa_bkg_mod_cd", "usaBkgModCd");
		this.hashFields.put("n1st_ts_pod_cd", "n1stTsPodCd");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("n2nd_ts_slan_cd", "n2ndTsSlanCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("old_cmpb_amt", "oldCmpbAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cust_cnt_nm", "custCntNm");
		this.hashFields.put("aloc_lod_qty", "alocLodQty");
		this.hashFields.put("bkg_del_cnt_cd", "bkgDelCntCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rfa_nm", "rfaNm");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cmpb_amt", "cmpbAmt");
		this.hashFields.put("trunk_pod_cd", "trunkPodCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("trnk_slan_cd", "trnkSlanCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("bkg_pol_cnt_cd", "bkgPolCntCd");
		this.hashFields.put("asgn_wgt_rto", "asgnWgtRto");
		this.hashFields.put("bkg_aloc_tp_cd", "bkgAlocTpCd");
		this.hashFields.put("n1st_ts_slan_cd", "n1stTsSlanCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("aloc_svc_cd", "alocSvcCd");
		this.hashFields.put("oft_chg_amt", "oftChgAmt");
		this.hashFields.put("dg_rd", "dgRd");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("standby_type", "standbyType");
		this.hashFields.put("aloc_aply_to_dt", "alocAplyToDt");
		this.hashFields.put("scg_grp_cmdt_desc", "scgGrpCmdtDesc");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("n2nd_ts_pol_cd", "n2ndTsPolCd");
		this.hashFields.put("n1st_ts_pol_cnt_cd", "n1stTsPolCntCd");
		this.hashFields.put("bkg_por_scc_cd", "bkgPorSccCd");
		this.hashFields.put("old_asgn_ttl_wgt", "oldAsgnTtlWgt");
		this.hashFields.put("old_aloc_lod_qty", "oldAlocLodQty");
		this.hashFields.put("bkg_por_cnt_cd", "bkgPorCntCd");
		this.hashFields.put("bkg_pod_cnt_cd", "bkgPodCntCd");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("standby_reason", "standbyReason");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return oldOftChgAmt
	 */
	public String getOldOftChgAmt() {
		return this.oldOftChgAmt;
	}
	
	/**
	 * Column Info
	 * @return trunkPolCd
	 */
	public String getTrunkPolCd() {
		return this.trunkPolCd;
	}
	
	/**
	 * Column Info
	 * @return asgnTtlWgt
	 */
	public String getAsgnTtlWgt() {
		return this.asgnTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return n1stTsPodCntCd
	 */
	public String getN1stTsPodCntCd() {
		return this.n1stTsPodCntCd;
	}
	
	/**
	 * Column Info
	 * @return scNm
	 */
	public String getScNm() {
		return this.scNm;
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
	 * @return ubTrdCd
	 */
	public String getUbTrdCd() {
		return this.ubTrdCd;
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
	 * @return bkgCtrlTpCd
	 */
	public String getBkgCtrlTpCd() {
		return this.bkgCtrlTpCd;
	}
	
	/**
	 * Column Info
	 * @return agmtActCntCd
	 */
	public String getAgmtActCntCd() {
		return this.agmtActCntCd;
	}
	
	/**
	 * Column Info
	 * @return oldAasgnWgtRto
	 */
	public String getOldAasgnWgtRto() {
		return this.oldAasgnWgtRto;
	}
	
	/**
	 * Column Info
	 * @return alocStsCd
	 */
	public String getAlocStsCd() {
		return this.alocStsCd;
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
	 * @return ctrtCustCntNm
	 */
	public String getCtrtCustCntNm() {
		return this.ctrtCustCntNm;
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
	 * @return oldAlocLodQtyRto
	 */
	public String getOldAlocLodQtyRto() {
		return this.oldAlocLodQtyRto;
	}
	
	/**
	 * Column Info
	 * @return n2ndTsPodCd
	 */
	public String getN2ndTsPodCd() {
		return this.n2ndTsPodCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return alocAplyFmDt
	 */
	public String getAlocAplyFmDt() {
		return this.alocAplyFmDt;
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
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}
	
	/**
	 * Column Info
	 * @return aplyToYrwk
	 */
	public String getAplyToYrwk() {
		return this.aplyToYrwk;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return feu
	 */
	public String getFeu() {
		return this.feu;
	}
	
	/**
	 * Column Info
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
	}
	
	/**
	 * Column Info
	 * @return alocLodQtyRto
	 */
	public String getAlocLodQtyRto() {
		return this.alocLodQtyRto;
	}
	
	/**
	 * Column Info
	 * @return aplyFmYrwk
	 */
	public String getAplyFmYrwk() {
		return this.aplyFmYrwk;
	}
	
	/**
	 * Column Info
	 * @return scgGrpCmdtSeq
	 */
	public String getScgGrpCmdtSeq() {
		return this.scgGrpCmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return trnkDirCd
	 */
	public String getTrnkDirCd() {
		return this.trnkDirCd;
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
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @return cmpb
	 */
	public String getCmpb() {
		return this.cmpb;
	}
	
	/**
	 * Column Info
	 * @return n1stTsPolCd
	 */
	public String getN1stTsPolCd() {
		return this.n1stTsPolCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
	}
	
	/**
	 * Column Info
	 * @return n1stTsDirCd
	 */
	public String getN1stTsDirCd() {
		return this.n1stTsDirCd;
	}
	
	/**
	 * Column Info
	 * @return bkgAlocRmk
	 */
	public String getBkgAlocRmk() {
		return this.bkgAlocRmk;
	}
	
	/**
	 * Column Info
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	
	/**
	 * Column Info
	 * @return alocUseFlg
	 */
	public String getAlocUseFlg() {
		return this.alocUseFlg;
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
	 * @return ctrtCustCntCd
	 */
	public String getCtrtCustCntCd() {
		return this.ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDelSccCd
	 */
	public String getBkgDelSccCd() {
		return this.bkgDelSccCd;
	}
	
	/**
	 * Column Info
	 * @return usaBkgModCd
	 */
	public String getUsaBkgModCd() {
		return this.usaBkgModCd;
	}
	
	/**
	 * Column Info
	 * @return n1stTsPodCd
	 */
	public String getN1stTsPodCd() {
		return this.n1stTsPodCd;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return n2ndTsSlanCd
	 */
	public String getN2ndTsSlanCd() {
		return this.n2ndTsSlanCd;
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
	 * @return oldCmpbAmt
	 */
	public String getOldCmpbAmt() {
		return this.oldCmpbAmt;
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
	 * @return custCntNm
	 */
	public String getCustCntNm() {
		return this.custCntNm;
	}
	
	/**
	 * Column Info
	 * @return alocLodQty
	 */
	public String getAlocLodQty() {
		return this.alocLodQty;
	}
	
	/**
	 * Column Info
	 * @return bkgDelCntCd
	 */
	public String getBkgDelCntCd() {
		return this.bkgDelCntCd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return rfaNm
	 */
	public String getRfaNm() {
		return this.rfaNm;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return cmpbAmt
	 */
	public String getCmpbAmt() {
		return this.cmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return trunkPodCd
	 */
	public String getTrunkPodCd() {
		return this.trunkPodCd;
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
	 * @return trnkSlanCd
	 */
	public String getTrnkSlanCd() {
		return this.trnkSlanCd;
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
	 * @return bkgPolCntCd
	 */
	public String getBkgPolCntCd() {
		return this.bkgPolCntCd;
	}
	
	/**
	 * Column Info
	 * @return asgnWgtRto
	 */
	public String getAsgnWgtRto() {
		return this.asgnWgtRto;
	}
	
	/**
	 * Column Info
	 * @return bkgAlocTpCd
	 */
	public String getBkgAlocTpCd() {
		return this.bkgAlocTpCd;
	}
	
	/**
	 * Column Info
	 * @return n1stTsSlanCd
	 */
	public String getN1stTsSlanCd() {
		return this.n1stTsSlanCd;
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
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}
	
	/**
	 * Column Info
	 * @return alocSvcCd
	 */
	public String getAlocSvcCd() {
		return this.alocSvcCd;
	}
	
	/**
	 * Column Info
	 * @return oftChgAmt
	 */
	public String getOftChgAmt() {
		return this.oftChgAmt;
	}
	
	/**
	 * Column Info
	 * @return dgRd
	 */
	public String getDgRd() {
		return this.dgRd;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}
	
	/**
	 * Column Info
	 * @return standbyType
	 */
	public String getStandbyType() {
		return this.standbyType;
	}
	
	/**
	 * Column Info
	 * @return alocAplyToDt
	 */
	public String getAlocAplyToDt() {
		return this.alocAplyToDt;
	}
	
	/**
	 * Column Info
	 * @return scgGrpCmdtDesc
	 */
	public String getScgGrpCmdtDesc() {
		return this.scgGrpCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return n2ndTsPolCd
	 */
	public String getN2ndTsPolCd() {
		return this.n2ndTsPolCd;
	}
	
	/**
	 * Column Info
	 * @return n1stTsPolCntCd
	 */
	public String getN1stTsPolCntCd() {
		return this.n1stTsPolCntCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPorSccCd
	 */
	public String getBkgPorSccCd() {
		return this.bkgPorSccCd;
	}
	
	/**
	 * Column Info
	 * @return oldAsgnTtlWgt
	 */
	public String getOldAsgnTtlWgt() {
		return this.oldAsgnTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return oldAlocLodQty
	 */
	public String getOldAlocLodQty() {
		return this.oldAlocLodQty;
	}
	
	/**
	 * Column Info
	 * @return bkgPorCntCd
	 */
	public String getBkgPorCntCd() {
		return this.bkgPorCntCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPodCntCd
	 */
	public String getBkgPodCntCd() {
		return this.bkgPodCntCd;
	}
	
	/**
	 * Column Info
	 * @return custCtrlCd
	 */
	public String getCustCtrlCd() {
		return this.custCtrlCd;
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
	 * @return standbyReason
	 */
	public String getStandbyReason() {
		return this.standbyReason;
	}
	

	/**
	 * Column Info
	 * @param oldOftChgAmt
	 */
	public void setOldOftChgAmt(String oldOftChgAmt) {
		this.oldOftChgAmt = oldOftChgAmt;
	}
	
	/**
	 * Column Info
	 * @param trunkPolCd
	 */
	public void setTrunkPolCd(String trunkPolCd) {
		this.trunkPolCd = trunkPolCd;
	}
	
	/**
	 * Column Info
	 * @param asgnTtlWgt
	 */
	public void setAsgnTtlWgt(String asgnTtlWgt) {
		this.asgnTtlWgt = asgnTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param n1stTsPodCntCd
	 */
	public void setN1stTsPodCntCd(String n1stTsPodCntCd) {
		this.n1stTsPodCntCd = n1stTsPodCntCd;
	}
	
	/**
	 * Column Info
	 * @param scNm
	 */
	public void setScNm(String scNm) {
		this.scNm = scNm;
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
	 * @param ubTrdCd
	 */
	public void setUbTrdCd(String ubTrdCd) {
		this.ubTrdCd = ubTrdCd;
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
	 * @param bkgCtrlTpCd
	 */
	public void setBkgCtrlTpCd(String bkgCtrlTpCd) {
		this.bkgCtrlTpCd = bkgCtrlTpCd;
	}
	
	/**
	 * Column Info
	 * @param agmtActCntCd
	 */
	public void setAgmtActCntCd(String agmtActCntCd) {
		this.agmtActCntCd = agmtActCntCd;
	}
	
	/**
	 * Column Info
	 * @param oldAasgnWgtRto
	 */
	public void setOldAasgnWgtRto(String oldAasgnWgtRto) {
		this.oldAasgnWgtRto = oldAasgnWgtRto;
	}
	
	/**
	 * Column Info
	 * @param alocStsCd
	 */
	public void setAlocStsCd(String alocStsCd) {
		this.alocStsCd = alocStsCd;
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
	 * @param ctrtCustCntNm
	 */
	public void setCtrtCustCntNm(String ctrtCustCntNm) {
		this.ctrtCustCntNm = ctrtCustCntNm;
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
	 * @param oldAlocLodQtyRto
	 */
	public void setOldAlocLodQtyRto(String oldAlocLodQtyRto) {
		this.oldAlocLodQtyRto = oldAlocLodQtyRto;
	}
	
	/**
	 * Column Info
	 * @param n2ndTsPodCd
	 */
	public void setN2ndTsPodCd(String n2ndTsPodCd) {
		this.n2ndTsPodCd = n2ndTsPodCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param alocAplyFmDt
	 */
	public void setAlocAplyFmDt(String alocAplyFmDt) {
		this.alocAplyFmDt = alocAplyFmDt;
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
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}
	
	/**
	 * Column Info
	 * @param aplyToYrwk
	 */
	public void setAplyToYrwk(String aplyToYrwk) {
		this.aplyToYrwk = aplyToYrwk;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param feu
	 */
	public void setFeu(String feu) {
		this.feu = feu;
	}
	
	/**
	 * Column Info
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
	}
	
	/**
	 * Column Info
	 * @param alocLodQtyRto
	 */
	public void setAlocLodQtyRto(String alocLodQtyRto) {
		this.alocLodQtyRto = alocLodQtyRto;
	}
	
	/**
	 * Column Info
	 * @param aplyFmYrwk
	 */
	public void setAplyFmYrwk(String aplyFmYrwk) {
		this.aplyFmYrwk = aplyFmYrwk;
	}
	
	/**
	 * Column Info
	 * @param scgGrpCmdtSeq
	 */
	public void setScgGrpCmdtSeq(String scgGrpCmdtSeq) {
		this.scgGrpCmdtSeq = scgGrpCmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param trnkDirCd
	 */
	public void setTrnkDirCd(String trnkDirCd) {
		this.trnkDirCd = trnkDirCd;
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
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @param cmpb
	 */
	public void setCmpb(String cmpb) {
		this.cmpb = cmpb;
	}
	
	/**
	 * Column Info
	 * @param n1stTsPolCd
	 */
	public void setN1stTsPolCd(String n1stTsPolCd) {
		this.n1stTsPolCd = n1stTsPolCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}
	
	/**
	 * Column Info
	 * @param n1stTsDirCd
	 */
	public void setN1stTsDirCd(String n1stTsDirCd) {
		this.n1stTsDirCd = n1stTsDirCd;
	}
	
	/**
	 * Column Info
	 * @param bkgAlocRmk
	 */
	public void setBkgAlocRmk(String bkgAlocRmk) {
		this.bkgAlocRmk = bkgAlocRmk;
	}
	
	/**
	 * Column Info
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Column Info
	 * @param alocUseFlg
	 */
	public void setAlocUseFlg(String alocUseFlg) {
		this.alocUseFlg = alocUseFlg;
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
	 * @param ctrtCustCntCd
	 */
	public void setCtrtCustCntCd(String ctrtCustCntCd) {
		this.ctrtCustCntCd = ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDelSccCd
	 */
	public void setBkgDelSccCd(String bkgDelSccCd) {
		this.bkgDelSccCd = bkgDelSccCd;
	}
	
	/**
	 * Column Info
	 * @param usaBkgModCd
	 */
	public void setUsaBkgModCd(String usaBkgModCd) {
		this.usaBkgModCd = usaBkgModCd;
	}
	
	/**
	 * Column Info
	 * @param n1stTsPodCd
	 */
	public void setN1stTsPodCd(String n1stTsPodCd) {
		this.n1stTsPodCd = n1stTsPodCd;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param n2ndTsSlanCd
	 */
	public void setN2ndTsSlanCd(String n2ndTsSlanCd) {
		this.n2ndTsSlanCd = n2ndTsSlanCd;
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
	 * @param oldCmpbAmt
	 */
	public void setOldCmpbAmt(String oldCmpbAmt) {
		this.oldCmpbAmt = oldCmpbAmt;
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
	 * @param custCntNm
	 */
	public void setCustCntNm(String custCntNm) {
		this.custCntNm = custCntNm;
	}
	
	/**
	 * Column Info
	 * @param alocLodQty
	 */
	public void setAlocLodQty(String alocLodQty) {
		this.alocLodQty = alocLodQty;
	}
	
	/**
	 * Column Info
	 * @param bkgDelCntCd
	 */
	public void setBkgDelCntCd(String bkgDelCntCd) {
		this.bkgDelCntCd = bkgDelCntCd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param rfaNm
	 */
	public void setRfaNm(String rfaNm) {
		this.rfaNm = rfaNm;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param cmpbAmt
	 */
	public void setCmpbAmt(String cmpbAmt) {
		this.cmpbAmt = cmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param trunkPodCd
	 */
	public void setTrunkPodCd(String trunkPodCd) {
		this.trunkPodCd = trunkPodCd;
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
	 * @param trnkSlanCd
	 */
	public void setTrnkSlanCd(String trnkSlanCd) {
		this.trnkSlanCd = trnkSlanCd;
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
	 * @param bkgPolCntCd
	 */
	public void setBkgPolCntCd(String bkgPolCntCd) {
		this.bkgPolCntCd = bkgPolCntCd;
	}
	
	/**
	 * Column Info
	 * @param asgnWgtRto
	 */
	public void setAsgnWgtRto(String asgnWgtRto) {
		this.asgnWgtRto = asgnWgtRto;
	}
	
	/**
	 * Column Info
	 * @param bkgAlocTpCd
	 */
	public void setBkgAlocTpCd(String bkgAlocTpCd) {
		this.bkgAlocTpCd = bkgAlocTpCd;
	}
	
	/**
	 * Column Info
	 * @param n1stTsSlanCd
	 */
	public void setN1stTsSlanCd(String n1stTsSlanCd) {
		this.n1stTsSlanCd = n1stTsSlanCd;
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
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}
	
	/**
	 * Column Info
	 * @param alocSvcCd
	 */
	public void setAlocSvcCd(String alocSvcCd) {
		this.alocSvcCd = alocSvcCd;
	}
	
	/**
	 * Column Info
	 * @param oftChgAmt
	 */
	public void setOftChgAmt(String oftChgAmt) {
		this.oftChgAmt = oftChgAmt;
	}
	
	/**
	 * Column Info
	 * @param dgRd
	 */
	public void setDgRd(String dgRd) {
		this.dgRd = dgRd;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	/**
	 * Column Info
	 * @param standbyType
	 */
	public void setStandbyType(String standbyType) {
		this.standbyType = standbyType;
	}
	
	/**
	 * Column Info
	 * @param alocAplyToDt
	 */
	public void setAlocAplyToDt(String alocAplyToDt) {
		this.alocAplyToDt = alocAplyToDt;
	}
	
	/**
	 * Column Info
	 * @param scgGrpCmdtDesc
	 */
	public void setScgGrpCmdtDesc(String scgGrpCmdtDesc) {
		this.scgGrpCmdtDesc = scgGrpCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param n2ndTsPolCd
	 */
	public void setN2ndTsPolCd(String n2ndTsPolCd) {
		this.n2ndTsPolCd = n2ndTsPolCd;
	}
	
	/**
	 * Column Info
	 * @param n1stTsPolCntCd
	 */
	public void setN1stTsPolCntCd(String n1stTsPolCntCd) {
		this.n1stTsPolCntCd = n1stTsPolCntCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPorSccCd
	 */
	public void setBkgPorSccCd(String bkgPorSccCd) {
		this.bkgPorSccCd = bkgPorSccCd;
	}
	
	/**
	 * Column Info
	 * @param oldAsgnTtlWgt
	 */
	public void setOldAsgnTtlWgt(String oldAsgnTtlWgt) {
		this.oldAsgnTtlWgt = oldAsgnTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param oldAlocLodQty
	 */
	public void setOldAlocLodQty(String oldAlocLodQty) {
		this.oldAlocLodQty = oldAlocLodQty;
	}
	
	/**
	 * Column Info
	 * @param bkgPorCntCd
	 */
	public void setBkgPorCntCd(String bkgPorCntCd) {
		this.bkgPorCntCd = bkgPorCntCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPodCntCd
	 */
	public void setBkgPodCntCd(String bkgPodCntCd) {
		this.bkgPodCntCd = bkgPodCntCd;
	}
	
	/**
	 * Column Info
	 * @param custCtrlCd
	 */
	public void setCustCtrlCd(String custCtrlCd) {
		this.custCtrlCd = custCtrlCd;
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
	 * @param standbyReason
	 */
	public void setStandbyReason(String standbyReason) {
		this.standbyReason = standbyReason;
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
		setOldOftChgAmt(JSPUtil.getParameter(request, prefix + "old_oft_chg_amt", ""));
		setTrunkPolCd(JSPUtil.getParameter(request, prefix + "trunk_pol_cd", ""));
		setAsgnTtlWgt(JSPUtil.getParameter(request, prefix + "asgn_ttl_wgt", ""));
		setN1stTsPodCntCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pod_cnt_cd", ""));
		setScNm(JSPUtil.getParameter(request, prefix + "sc_nm", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setUbTrdCd(JSPUtil.getParameter(request, prefix + "ub_trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setBkgCtrlTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrl_tp_cd", ""));
		setAgmtActCntCd(JSPUtil.getParameter(request, prefix + "agmt_act_cnt_cd", ""));
		setOldAasgnWgtRto(JSPUtil.getParameter(request, prefix + "old_aasgn_wgt_rto", ""));
		setAlocStsCd(JSPUtil.getParameter(request, prefix + "aloc_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtCustCntNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_nm", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setOldAlocLodQtyRto(JSPUtil.getParameter(request, prefix + "old_aloc_lod_qty_rto", ""));
		setN2ndTsPodCd(JSPUtil.getParameter(request, prefix + "n2nd_ts_pod_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setAlocAplyFmDt(JSPUtil.getParameter(request, prefix + "aloc_aply_fm_dt", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setAplyToYrwk(JSPUtil.getParameter(request, prefix + "aply_to_yrwk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setFeu(JSPUtil.getParameter(request, prefix + "feu", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setAlocLodQtyRto(JSPUtil.getParameter(request, prefix + "aloc_lod_qty_rto", ""));
		setAplyFmYrwk(JSPUtil.getParameter(request, prefix + "aply_fm_yrwk", ""));
		setScgGrpCmdtSeq(JSPUtil.getParameter(request, prefix + "scg_grp_cmdt_seq", ""));
		setTrnkDirCd(JSPUtil.getParameter(request, prefix + "trnk_dir_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setCmpb(JSPUtil.getParameter(request, prefix + "cmpb", ""));
		setN1stTsPolCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pol_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setN1stTsDirCd(JSPUtil.getParameter(request, prefix + "n1st_ts_dir_cd", ""));
		setBkgAlocRmk(JSPUtil.getParameter(request, prefix + "bkg_aloc_rmk", ""));
		setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
		setAlocUseFlg(JSPUtil.getParameter(request, prefix + "aloc_use_flg", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCtrtCustCntCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_cd", ""));
		setBkgDelSccCd(JSPUtil.getParameter(request, prefix + "bkg_del_scc_cd", ""));
		setUsaBkgModCd(JSPUtil.getParameter(request, prefix + "usa_bkg_mod_cd", ""));
		setN1stTsPodCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pod_cd", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setN2ndTsSlanCd(JSPUtil.getParameter(request, prefix + "n2nd_ts_slan_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setOldCmpbAmt(JSPUtil.getParameter(request, prefix + "old_cmpb_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCustCntNm(JSPUtil.getParameter(request, prefix + "cust_cnt_nm", ""));
		setAlocLodQty(JSPUtil.getParameter(request, prefix + "aloc_lod_qty", ""));
		setBkgDelCntCd(JSPUtil.getParameter(request, prefix + "bkg_del_cnt_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRfaNm(JSPUtil.getParameter(request, prefix + "rfa_nm", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCmpbAmt(JSPUtil.getParameter(request, prefix + "cmpb_amt", ""));
		setTrunkPodCd(JSPUtil.getParameter(request, prefix + "trunk_pod_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setTrnkSlanCd(JSPUtil.getParameter(request, prefix + "trnk_slan_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setBkgPolCntCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cnt_cd", ""));
		setAsgnWgtRto(JSPUtil.getParameter(request, prefix + "asgn_wgt_rto", ""));
		setBkgAlocTpCd(JSPUtil.getParameter(request, prefix + "bkg_aloc_tp_cd", ""));
		setN1stTsSlanCd(JSPUtil.getParameter(request, prefix + "n1st_ts_slan_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setAlocSvcCd(JSPUtil.getParameter(request, prefix + "aloc_svc_cd", ""));
		setOftChgAmt(JSPUtil.getParameter(request, prefix + "oft_chg_amt", ""));
		setDgRd(JSPUtil.getParameter(request, prefix + "dg_rd", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setStandbyType(JSPUtil.getParameter(request, prefix + "standby_type", ""));
		setAlocAplyToDt(JSPUtil.getParameter(request, prefix + "aloc_aply_to_dt", ""));
		setScgGrpCmdtDesc(JSPUtil.getParameter(request, prefix + "scg_grp_cmdt_desc", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setN2ndTsPolCd(JSPUtil.getParameter(request, prefix + "n2nd_ts_pol_cd", ""));
		setN1stTsPolCntCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pol_cnt_cd", ""));
		setBkgPorSccCd(JSPUtil.getParameter(request, prefix + "bkg_por_scc_cd", ""));
		setOldAsgnTtlWgt(JSPUtil.getParameter(request, prefix + "old_asgn_ttl_wgt", ""));
		setOldAlocLodQty(JSPUtil.getParameter(request, prefix + "old_aloc_lod_qty", ""));
		setBkgPorCntCd(JSPUtil.getParameter(request, prefix + "bkg_por_cnt_cd", ""));
		setBkgPodCntCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cnt_cd", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setStandbyReason(JSPUtil.getParameter(request, prefix + "standby_reason", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchStandbyBKGRPTMSTVO[]
	 */
	public SearchStandbyBKGRPTMSTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchStandbyBKGRPTMSTVO[]
	 */
	public SearchStandbyBKGRPTMSTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchStandbyBKGRPTMSTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] oldOftChgAmt = (JSPUtil.getParameter(request, prefix	+ "old_oft_chg_amt", length));
			String[] trunkPolCd = (JSPUtil.getParameter(request, prefix	+ "trunk_pol_cd", length));
			String[] asgnTtlWgt = (JSPUtil.getParameter(request, prefix	+ "asgn_ttl_wgt", length));
			String[] n1stTsPodCntCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pod_cnt_cd", length));
			String[] scNm = (JSPUtil.getParameter(request, prefix	+ "sc_nm", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] ubTrdCd = (JSPUtil.getParameter(request, prefix	+ "ub_trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] bkgCtrlTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_tp_cd", length));
			String[] agmtActCntCd = (JSPUtil.getParameter(request, prefix	+ "agmt_act_cnt_cd", length));
			String[] oldAasgnWgtRto = (JSPUtil.getParameter(request, prefix	+ "old_aasgn_wgt_rto", length));
			String[] alocStsCd = (JSPUtil.getParameter(request, prefix	+ "aloc_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtCustCntNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_nm", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] oldAlocLodQtyRto = (JSPUtil.getParameter(request, prefix	+ "old_aloc_lod_qty_rto", length));
			String[] n2ndTsPodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_pod_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] alocAplyFmDt = (JSPUtil.getParameter(request, prefix	+ "aloc_aply_fm_dt", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] aplyToYrwk = (JSPUtil.getParameter(request, prefix	+ "aply_to_yrwk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] feu = (JSPUtil.getParameter(request, prefix	+ "feu", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] alocLodQtyRto = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty_rto", length));
			String[] aplyFmYrwk = (JSPUtil.getParameter(request, prefix	+ "aply_fm_yrwk", length));
			String[] scgGrpCmdtSeq = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_seq", length));
			String[] trnkDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_dir_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] cmpb = (JSPUtil.getParameter(request, prefix	+ "cmpb", length));
			String[] n1stTsPolCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pol_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] n1stTsDirCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_dir_cd", length));
			String[] bkgAlocRmk = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_rmk", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] alocUseFlg = (JSPUtil.getParameter(request, prefix	+ "aloc_use_flg", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] bkgDelSccCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_scc_cd", length));
			String[] usaBkgModCd = (JSPUtil.getParameter(request, prefix	+ "usa_bkg_mod_cd", length));
			String[] n1stTsPodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pod_cd", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] n2ndTsSlanCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_slan_cd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] oldCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "old_cmpb_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] custCntNm = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_nm", length));
			String[] alocLodQty = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty", length));
			String[] bkgDelCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cnt_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rfaNm = (JSPUtil.getParameter(request, prefix	+ "rfa_nm", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cmpbAmt = (JSPUtil.getParameter(request, prefix	+ "cmpb_amt", length));
			String[] trunkPodCd = (JSPUtil.getParameter(request, prefix	+ "trunk_pod_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] trnkSlanCd = (JSPUtil.getParameter(request, prefix	+ "trnk_slan_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] bkgPolCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cnt_cd", length));
			String[] asgnWgtRto = (JSPUtil.getParameter(request, prefix	+ "asgn_wgt_rto", length));
			String[] bkgAlocTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_tp_cd", length));
			String[] n1stTsSlanCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_slan_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] alocSvcCd = (JSPUtil.getParameter(request, prefix	+ "aloc_svc_cd", length));
			String[] oftChgAmt = (JSPUtil.getParameter(request, prefix	+ "oft_chg_amt", length));
			String[] dgRd = (JSPUtil.getParameter(request, prefix	+ "dg_rd", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] standbyType = (JSPUtil.getParameter(request, prefix	+ "standby_type", length));
			String[] alocAplyToDt = (JSPUtil.getParameter(request, prefix	+ "aloc_aply_to_dt", length));
			String[] scgGrpCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_desc", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] n2ndTsPolCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_pol_cd", length));
			String[] n1stTsPolCntCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pol_cnt_cd", length));
			String[] bkgPorSccCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_scc_cd", length));
			String[] oldAsgnTtlWgt = (JSPUtil.getParameter(request, prefix	+ "old_asgn_ttl_wgt", length));
			String[] oldAlocLodQty = (JSPUtil.getParameter(request, prefix	+ "old_aloc_lod_qty", length));
			String[] bkgPorCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cnt_cd", length));
			String[] bkgPodCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cnt_cd", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] standbyReason = (JSPUtil.getParameter(request, prefix	+ "standby_reason", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchStandbyBKGRPTMSTVO();
				if (oldOftChgAmt[i] != null)
					model.setOldOftChgAmt(oldOftChgAmt[i]);
				if (trunkPolCd[i] != null)
					model.setTrunkPolCd(trunkPolCd[i]);
				if (asgnTtlWgt[i] != null)
					model.setAsgnTtlWgt(asgnTtlWgt[i]);
				if (n1stTsPodCntCd[i] != null)
					model.setN1stTsPodCntCd(n1stTsPodCntCd[i]);
				if (scNm[i] != null)
					model.setScNm(scNm[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (ubTrdCd[i] != null)
					model.setUbTrdCd(ubTrdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (bkgCtrlTpCd[i] != null)
					model.setBkgCtrlTpCd(bkgCtrlTpCd[i]);
				if (agmtActCntCd[i] != null)
					model.setAgmtActCntCd(agmtActCntCd[i]);
				if (oldAasgnWgtRto[i] != null)
					model.setOldAasgnWgtRto(oldAasgnWgtRto[i]);
				if (alocStsCd[i] != null)
					model.setAlocStsCd(alocStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtCustCntNm[i] != null)
					model.setCtrtCustCntNm(ctrtCustCntNm[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (oldAlocLodQtyRto[i] != null)
					model.setOldAlocLodQtyRto(oldAlocLodQtyRto[i]);
				if (n2ndTsPodCd[i] != null)
					model.setN2ndTsPodCd(n2ndTsPodCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (alocAplyFmDt[i] != null)
					model.setAlocAplyFmDt(alocAplyFmDt[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (aplyToYrwk[i] != null)
					model.setAplyToYrwk(aplyToYrwk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (feu[i] != null)
					model.setFeu(feu[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (alocLodQtyRto[i] != null)
					model.setAlocLodQtyRto(alocLodQtyRto[i]);
				if (aplyFmYrwk[i] != null)
					model.setAplyFmYrwk(aplyFmYrwk[i]);
				if (scgGrpCmdtSeq[i] != null)
					model.setScgGrpCmdtSeq(scgGrpCmdtSeq[i]);
				if (trnkDirCd[i] != null)
					model.setTrnkDirCd(trnkDirCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (cmpb[i] != null)
					model.setCmpb(cmpb[i]);
				if (n1stTsPolCd[i] != null)
					model.setN1stTsPolCd(n1stTsPolCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (n1stTsDirCd[i] != null)
					model.setN1stTsDirCd(n1stTsDirCd[i]);
				if (bkgAlocRmk[i] != null)
					model.setBkgAlocRmk(bkgAlocRmk[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (alocUseFlg[i] != null)
					model.setAlocUseFlg(alocUseFlg[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (bkgDelSccCd[i] != null)
					model.setBkgDelSccCd(bkgDelSccCd[i]);
				if (usaBkgModCd[i] != null)
					model.setUsaBkgModCd(usaBkgModCd[i]);
				if (n1stTsPodCd[i] != null)
					model.setN1stTsPodCd(n1stTsPodCd[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (n2ndTsSlanCd[i] != null)
					model.setN2ndTsSlanCd(n2ndTsSlanCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (oldCmpbAmt[i] != null)
					model.setOldCmpbAmt(oldCmpbAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (custCntNm[i] != null)
					model.setCustCntNm(custCntNm[i]);
				if (alocLodQty[i] != null)
					model.setAlocLodQty(alocLodQty[i]);
				if (bkgDelCntCd[i] != null)
					model.setBkgDelCntCd(bkgDelCntCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rfaNm[i] != null)
					model.setRfaNm(rfaNm[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cmpbAmt[i] != null)
					model.setCmpbAmt(cmpbAmt[i]);
				if (trunkPodCd[i] != null)
					model.setTrunkPodCd(trunkPodCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (trnkSlanCd[i] != null)
					model.setTrnkSlanCd(trnkSlanCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (bkgPolCntCd[i] != null)
					model.setBkgPolCntCd(bkgPolCntCd[i]);
				if (asgnWgtRto[i] != null)
					model.setAsgnWgtRto(asgnWgtRto[i]);
				if (bkgAlocTpCd[i] != null)
					model.setBkgAlocTpCd(bkgAlocTpCd[i]);
				if (n1stTsSlanCd[i] != null)
					model.setN1stTsSlanCd(n1stTsSlanCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (alocSvcCd[i] != null)
					model.setAlocSvcCd(alocSvcCd[i]);
				if (oftChgAmt[i] != null)
					model.setOftChgAmt(oftChgAmt[i]);
				if (dgRd[i] != null)
					model.setDgRd(dgRd[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (standbyType[i] != null)
					model.setStandbyType(standbyType[i]);
				if (alocAplyToDt[i] != null)
					model.setAlocAplyToDt(alocAplyToDt[i]);
				if (scgGrpCmdtDesc[i] != null)
					model.setScgGrpCmdtDesc(scgGrpCmdtDesc[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (n2ndTsPolCd[i] != null)
					model.setN2ndTsPolCd(n2ndTsPolCd[i]);
				if (n1stTsPolCntCd[i] != null)
					model.setN1stTsPolCntCd(n1stTsPolCntCd[i]);
				if (bkgPorSccCd[i] != null)
					model.setBkgPorSccCd(bkgPorSccCd[i]);
				if (oldAsgnTtlWgt[i] != null)
					model.setOldAsgnTtlWgt(oldAsgnTtlWgt[i]);
				if (oldAlocLodQty[i] != null)
					model.setOldAlocLodQty(oldAlocLodQty[i]);
				if (bkgPorCntCd[i] != null)
					model.setBkgPorCntCd(bkgPorCntCd[i]);
				if (bkgPodCntCd[i] != null)
					model.setBkgPodCntCd(bkgPodCntCd[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (standbyReason[i] != null)
					model.setStandbyReason(standbyReason[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchStandbyBKGRPTMSTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchStandbyBKGRPTMSTVO[]
	 */
	public SearchStandbyBKGRPTMSTVO[] getSearchStandbyBKGRPTMSTVOs(){
		SearchStandbyBKGRPTMSTVO[] vos = (SearchStandbyBKGRPTMSTVO[])models.toArray(new SearchStandbyBKGRPTMSTVO[models.size()]);
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
		this.oldOftChgAmt = this.oldOftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPolCd = this.trunkPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnTtlWgt = this.asgnTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPodCntCd = this.n1stTsPodCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNm = this.scNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ubTrdCd = this.ubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlTpCd = this.bkgCtrlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtActCntCd = this.agmtActCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAasgnWgtRto = this.oldAasgnWgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocStsCd = this.alocStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCntNm = this.ctrtCustCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAlocLodQtyRto = this.oldAlocLodQtyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsPodCd = this.n2ndTsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocAplyFmDt = this.alocAplyFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyToYrwk = this.aplyToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feu = this.feu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQtyRto = this.alocLodQtyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyFmYrwk = this.aplyFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtSeq = this.scgGrpCmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkDirCd = this.trnkDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpb = this.cmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPolCd = this.n1stTsPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsDirCd = this.n1stTsDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocRmk = this.bkgAlocRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocUseFlg = this.alocUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelSccCd = this.bkgDelSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaBkgModCd = this.usaBkgModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPodCd = this.n1stTsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsSlanCd = this.n2ndTsSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCmpbAmt = this.oldCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntNm = this.custCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQty = this.alocLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCntCd = this.bkgDelCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNm = this.rfaNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbAmt = this.cmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPodCd = this.trunkPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSlanCd = this.trnkSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCntCd = this.bkgPolCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnWgtRto = this.asgnWgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocTpCd = this.bkgAlocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsSlanCd = this.n1stTsSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocSvcCd = this.alocSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftChgAmt = this.oftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgRd = this.dgRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.standbyType = this.standbyType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocAplyToDt = this.alocAplyToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtDesc = this.scgGrpCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsPolCd = this.n2ndTsPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPolCntCd = this.n1stTsPolCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorSccCd = this.bkgPorSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAsgnTtlWgt = this.oldAsgnTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAlocLodQty = this.oldAlocLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCntCd = this.bkgPorCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCntCd = this.bkgPodCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.standbyReason = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
