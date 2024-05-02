/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SpcAlocMgmtVO.java
*@FileTitle : SpcAlocMgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.19  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpcAlocMgmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcAlocMgmtVO> models = new ArrayList<SpcAlocMgmtVO>();
	
	/* Column Info */
	private String aplyFmYrwk = null;
	/* Column Info */
	private String agmtActCntCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String bkgPorCntCd = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String tabRhqCd = null;
	/* Column Info */
	private String asgnTtlWgt = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String subtrade = null;
	/* Column Info */
	private String n1stTsDirCd = null;
	/* Column Info */
	private String oldAlocLodQty = null;
	/* Column Info */
	private String scNm = null;
	/* Column Info */
	private String ctrtCustCntNm = null;
	/* Column Info */
	private String bkgAlocTpCd = null;
	/* Column Info */
	private String alocLodQtyRto = null;
	/* Column Info */
	private String alocAplyFmDt = null;
	/* Column Info */
	private String bkgDelCntCd = null;
	/* Column Info */
	private String oldOpCntrQty = null;
	/* Column Info */
	private String n1stTsPodCntCd = null;
	/* Column Info */
	private String valValue2 = null;
	/* Column Info */
	private String cmpbAmt = null;
	/* Column Info */
	private String custGrpNm = null;
	/* Column Info */
	private String oldOpCntrQtyRto = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String opCntrQtyRto = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String laneCnt = null;
	/* Column Info */
	private String dgRd = null;
	/* Column Info */
	private String rfaNm = null;
	/* Column Info */
	private String cmpbPerWgt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dirCnt = null;
	/* Column Info */
	private String bkgPodCntCd = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String valType = null;
	/* Column Info */
	private String n1stTsPolCntCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String tsNodCd = null;
	/* Column Info */
	private String asgnWgtRto = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cmdtCnt = null;
	/* Column Info */
	private String oftChgAmt = null;
	/* Column Info */
	private String sinwaSeq = null;
	/* Column Info */
	private String n2ndTsSlanCd = null;
	/* Column Info */
	private String ofcTy = null;
	/* Column Info */
	private String shaasSeq = null;
	/* Column Info */
	private String oldCmpbAmt = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String trnkDirCd = null;
	/* Column Info */
	private String valCnt = null;
	/* Column Info */
	private String scgGrpCmdtDesc = null;
	/* Column Info */
	private String oldAsgnTtlWgt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String rfaCtrtTpCd = null;
	/* Column Info */
	private String chkOp = null;
	/* Column Info */
	private String vvdSig = null;
	/* Column Info */
	private String tsPodNodCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String wgtPerTeu = null;
	/* Column Info */
	private String alocLodQty = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String bkgPolCntCd = null;
	/* Column Info */
	private String alocUseFlg = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String alocSvcCd = null;
	/* Column Info */
	private String trnkSlanCd = null;
	/* Column Info */
	private String bkgDelSccCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String oldOftChgAmt = null;
	/* Column Info */
	private String crrNm = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String scgGrpCmdtSeq = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n1stTsSlanCd = null;
	/* Column Info */
	private String cmpbOnyFlg = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String acctTp = null;
	/* Column Info */
	private String oldAasgnWgtRto = null;
	/* Column Info */
	private String bkgCtrlTpCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String aplyToYrwk = null;
	/* Column Info */
	private String custCntNm = null;
	/* Column Info */
	private String tsPolNodCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgAlocSeq = null;
	/* Column Info */
	private String bkgPorSccCd = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String usaBkgModCd = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String bkgAlocRmk = null;
	/* Column Info */
	private String n2ndTsPolCd = null;
	/* Column Info */
	private String valValue = null;
	/* Column Info */
	private String n2ndTsPodCd = null;
	/* Column Info */
	private String trunkPolCd = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String n1stTsPolCd = null;
	/* Column Info */
	private String alocAplyToDt = null;
	/* Column Info */
	private String trunkPodCd = null;
	/* Column Info */
	private String oldAlocLodQtyRto = null;
	/* Column Info */
	private String n1stTsPodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpcAlocMgmtVO() {}

	public SpcAlocMgmtVO(String ibflag, String pagerows, String bkgAlocSeq, String shaasSeq, String sinwaSeq, String bkgAlocTpCd, String trnkSlanCd, String trnkDirCd, String vvd, String slsRhqCd, String obSlsOfcCd, String bkgPorCntCd, String porCd, String porNodCd, String bkgPorSccCd, String bkgPolCntCd, String polCd, String polNodCd, String n1stTsSlanCd, String n1stTsPolCd, String n1stTsPodCd, String n1stTsDirCd, String n1stTsPolCntCd, String n1stTsPodCntCd, String n2ndTsSlanCd, String n2ndTsPolCd, String n2ndTsPodCd, String bkgPodCntCd, String podCd, String podNodCd, String bkgDelCntCd, String delCd, String delNodCd, String bkgDelSccCd, String scNo, String rfaNo, String ctrtCustCntCd, String custCntCd, String cntrTpszCd, String cmdtCd, String cmdtNm, String scgGrpCmdtSeq, String scgGrpCmdtDesc, String alocLodQty, String oldAlocLodQty, String alocLodQtyRto, String oldAlocLodQtyRto, String asgnTtlWgt, String oldAsgnTtlWgt, String asgnWgtRto, String oldAasgnWgtRto, String alocSvcCd, String bkgAlocRmk, String alocUseFlg, String creUsrId, String creDt, String updUsrId, String updDt, String trunkPolCd, String trunkPodCd, String cmpbAmt, String oldCmpbAmt, String bkgCtrlTpCd, String dcgoFlg, String rdCgoFlg, String agmtActCntCd, String alocAplyFmDt, String alocAplyToDt, String subTrdCd, String dgRd, String oftChgAmt, String oldOftChgAmt, String usaBkgModCd, String hulBndCd, String aplyFmYrwk, String aplyToYrwk, String cmpbOnyFlg, String laneCnt, String dirCnt, String cmdtCnt, String valValue, String valType, String valCnt, String subtrade, String lane, String bound, String trade, String tabRhqCd, String ofcTy, String chkOp, String vvdSig, String ofcCd, String stwgCd, String opCntrQty, String oldOpCntrQty, String opCntrQtyRto, String oldOpCntrQtyRto, String scNm, String ctrtCustCntNm, String rfaNm, String tsNodCd, String tsPodNodCd, String acctTp, String custCntNm, String tsPolNodCd, String valValue2, String custGrpId, String custGrpNm, String cmpbPerWgt, String wgtPerTeu, String rfaCtrtTpCd, String crrCd, String crrNm, String locCd) {
		this.aplyFmYrwk = aplyFmYrwk;
		this.agmtActCntCd = agmtActCntCd;
		this.scNo = scNo;
		this.crrCd = crrCd;
		this.updUsrId = updUsrId;
		this.bkgPorCntCd = bkgPorCntCd;
		this.opCntrQty = opCntrQty;
		this.tabRhqCd = tabRhqCd;
		this.asgnTtlWgt = asgnTtlWgt;
		this.polNodCd = polNodCd;
		this.subtrade = subtrade;
		this.n1stTsDirCd = n1stTsDirCd;
		this.oldAlocLodQty = oldAlocLodQty;
		this.scNm = scNm;
		this.ctrtCustCntNm = ctrtCustCntNm;
		this.bkgAlocTpCd = bkgAlocTpCd;
		this.alocLodQtyRto = alocLodQtyRto;
		this.alocAplyFmDt = alocAplyFmDt;
		this.bkgDelCntCd = bkgDelCntCd;
		this.oldOpCntrQty = oldOpCntrQty;
		this.n1stTsPodCntCd = n1stTsPodCntCd;
		this.valValue2 = valValue2;
		this.cmpbAmt = cmpbAmt;
		this.custGrpNm = custGrpNm;
		this.oldOpCntrQtyRto = oldOpCntrQtyRto;
		this.obSlsOfcCd = obSlsOfcCd;
		this.opCntrQtyRto = opCntrQtyRto;
		this.subTrdCd = subTrdCd;
		this.rfaNo = rfaNo;
		this.cntrTpszCd = cntrTpszCd;
		this.laneCnt = laneCnt;
		this.dgRd = dgRd;
		this.rfaNm = rfaNm;
		this.cmpbPerWgt = cmpbPerWgt;
		this.updDt = updDt;
		this.dirCnt = dirCnt;
		this.bkgPodCntCd = bkgPodCntCd;
		this.podNodCd = podNodCd;
		this.valType = valType;
		this.n1stTsPolCntCd = n1stTsPolCntCd;
		this.porCd = porCd;
		this.tsNodCd = tsNodCd;
		this.asgnWgtRto = asgnWgtRto;
		this.creUsrId = creUsrId;
		this.cmdtCnt = cmdtCnt;
		this.oftChgAmt = oftChgAmt;
		this.sinwaSeq = sinwaSeq;
		this.n2ndTsSlanCd = n2ndTsSlanCd;
		this.ofcTy = ofcTy;
		this.shaasSeq = shaasSeq;
		this.oldCmpbAmt = oldCmpbAmt;
		this.cmdtCd = cmdtCd;
		this.trnkDirCd = trnkDirCd;
		this.valCnt = valCnt;
		this.scgGrpCmdtDesc = scgGrpCmdtDesc;
		this.oldAsgnTtlWgt = oldAsgnTtlWgt;
		this.delCd = delCd;
		this.rfaCtrtTpCd = rfaCtrtTpCd;
		this.chkOp = chkOp;
		this.vvdSig = vvdSig;
		this.tsPodNodCd = tsPodNodCd;
		this.dcgoFlg = dcgoFlg;
		this.wgtPerTeu = wgtPerTeu;
		this.alocLodQty = alocLodQty;
		this.hulBndCd = hulBndCd;
		this.custGrpId = custGrpId;
		this.bkgPolCntCd = bkgPolCntCd;
		this.alocUseFlg = alocUseFlg;
		this.slsRhqCd = slsRhqCd;
		this.alocSvcCd = alocSvcCd;
		this.trnkSlanCd = trnkSlanCd;
		this.bkgDelSccCd = bkgDelSccCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.vvd = vvd;
		this.oldOftChgAmt = oldOftChgAmt;
		this.crrNm = crrNm;
		this.delNodCd = delNodCd;
		this.creDt = creDt;
		this.porNodCd = porNodCd;
		this.scgGrpCmdtSeq = scgGrpCmdtSeq;
		this.custCntCd = custCntCd;
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.rdCgoFlg = rdCgoFlg;
		this.ibflag = ibflag;
		this.n1stTsSlanCd = n1stTsSlanCd;
		this.cmpbOnyFlg = cmpbOnyFlg;
		this.cmdtNm = cmdtNm;
		this.acctTp = acctTp;
		this.oldAasgnWgtRto = oldAasgnWgtRto;
		this.bkgCtrlTpCd = bkgCtrlTpCd;
		this.polCd = polCd;
		this.aplyToYrwk = aplyToYrwk;
		this.custCntNm = custCntNm;
		this.tsPolNodCd = tsPolNodCd;
		this.podCd = podCd;
		this.bkgAlocSeq = bkgAlocSeq;
		this.bkgPorSccCd = bkgPorSccCd;
		this.lane = lane;
		this.locCd = locCd;
		this.stwgCd = stwgCd;
		this.usaBkgModCd = usaBkgModCd;
		this.bound = bound;
		this.bkgAlocRmk = bkgAlocRmk;
		this.n2ndTsPolCd = n2ndTsPolCd;
		this.valValue = valValue;
		this.n2ndTsPodCd = n2ndTsPodCd;
		this.trunkPolCd = trunkPolCd;
		this.trade = trade;
		this.n1stTsPolCd = n1stTsPolCd;
		this.alocAplyToDt = alocAplyToDt;
		this.trunkPodCd = trunkPodCd;
		this.oldAlocLodQtyRto = oldAlocLodQtyRto;
		this.n1stTsPodCd = n1stTsPodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aply_fm_yrwk", getAplyFmYrwk());
		this.hashColumns.put("agmt_act_cnt_cd", getAgmtActCntCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bkg_por_cnt_cd", getBkgPorCntCd());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("tab_rhq_cd", getTabRhqCd());
		this.hashColumns.put("asgn_ttl_wgt", getAsgnTtlWgt());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("subtrade", getSubtrade());
		this.hashColumns.put("n1st_ts_dir_cd", getN1stTsDirCd());
		this.hashColumns.put("old_aloc_lod_qty", getOldAlocLodQty());
		this.hashColumns.put("sc_nm", getScNm());
		this.hashColumns.put("ctrt_cust_cnt_nm", getCtrtCustCntNm());
		this.hashColumns.put("bkg_aloc_tp_cd", getBkgAlocTpCd());
		this.hashColumns.put("aloc_lod_qty_rto", getAlocLodQtyRto());
		this.hashColumns.put("aloc_aply_fm_dt", getAlocAplyFmDt());
		this.hashColumns.put("bkg_del_cnt_cd", getBkgDelCntCd());
		this.hashColumns.put("old_op_cntr_qty", getOldOpCntrQty());
		this.hashColumns.put("n1st_ts_pod_cnt_cd", getN1stTsPodCntCd());
		this.hashColumns.put("val_value2", getValValue2());
		this.hashColumns.put("cmpb_amt", getCmpbAmt());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("old_op_cntr_qty_rto", getOldOpCntrQtyRto());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("op_cntr_qty_rto", getOpCntrQtyRto());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("lane_cnt", getLaneCnt());
		this.hashColumns.put("dg_rd", getDgRd());
		this.hashColumns.put("rfa_nm", getRfaNm());
		this.hashColumns.put("cmpb_per_wgt", getCmpbPerWgt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dir_cnt", getDirCnt());
		this.hashColumns.put("bkg_pod_cnt_cd", getBkgPodCntCd());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("val_type", getValType());
		this.hashColumns.put("n1st_ts_pol_cnt_cd", getN1stTsPolCntCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("ts_nod_cd", getTsNodCd());
		this.hashColumns.put("asgn_wgt_rto", getAsgnWgtRto());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cmdt_cnt", getCmdtCnt());
		this.hashColumns.put("oft_chg_amt", getOftChgAmt());
		this.hashColumns.put("sinwa_seq", getSinwaSeq());
		this.hashColumns.put("n2nd_ts_slan_cd", getN2ndTsSlanCd());
		this.hashColumns.put("ofc_ty", getOfcTy());
		this.hashColumns.put("shaas_seq", getShaasSeq());
		this.hashColumns.put("old_cmpb_amt", getOldCmpbAmt());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("trnk_dir_cd", getTrnkDirCd());
		this.hashColumns.put("val_cnt", getValCnt());
		this.hashColumns.put("scg_grp_cmdt_desc", getScgGrpCmdtDesc());
		this.hashColumns.put("old_asgn_ttl_wgt", getOldAsgnTtlWgt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("rfa_ctrt_tp_cd", getRfaCtrtTpCd());
		this.hashColumns.put("chk_op", getChkOp());
		this.hashColumns.put("vvd_sig", getVvdSig());
		this.hashColumns.put("ts_pod_nod_cd", getTsPodNodCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("wgt_per_teu", getWgtPerTeu());
		this.hashColumns.put("aloc_lod_qty", getAlocLodQty());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("bkg_pol_cnt_cd", getBkgPolCntCd());
		this.hashColumns.put("aloc_use_flg", getAlocUseFlg());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("aloc_svc_cd", getAlocSvcCd());
		this.hashColumns.put("trnk_slan_cd", getTrnkSlanCd());
		this.hashColumns.put("bkg_del_scc_cd", getBkgDelSccCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("old_oft_chg_amt", getOldOftChgAmt());
		this.hashColumns.put("crr_nm", getCrrNm());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("scg_grp_cmdt_seq", getScgGrpCmdtSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n1st_ts_slan_cd", getN1stTsSlanCd());
		this.hashColumns.put("cmpb_ony_flg", getCmpbOnyFlg());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("acct_tp", getAcctTp());
		this.hashColumns.put("old_aasgn_wgt_rto", getOldAasgnWgtRto());
		this.hashColumns.put("bkg_ctrl_tp_cd", getBkgCtrlTpCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("aply_to_yrwk", getAplyToYrwk());
		this.hashColumns.put("cust_cnt_nm", getCustCntNm());
		this.hashColumns.put("ts_pol_nod_cd", getTsPolNodCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_aloc_seq", getBkgAlocSeq());
		this.hashColumns.put("bkg_por_scc_cd", getBkgPorSccCd());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("usa_bkg_mod_cd", getUsaBkgModCd());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("bkg_aloc_rmk", getBkgAlocRmk());
		this.hashColumns.put("n2nd_ts_pol_cd", getN2ndTsPolCd());
		this.hashColumns.put("val_value", getValValue());
		this.hashColumns.put("n2nd_ts_pod_cd", getN2ndTsPodCd());
		this.hashColumns.put("trunk_pol_cd", getTrunkPolCd());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("n1st_ts_pol_cd", getN1stTsPolCd());
		this.hashColumns.put("aloc_aply_to_dt", getAlocAplyToDt());
		this.hashColumns.put("trunk_pod_cd", getTrunkPodCd());
		this.hashColumns.put("old_aloc_lod_qty_rto", getOldAlocLodQtyRto());
		this.hashColumns.put("n1st_ts_pod_cd", getN1stTsPodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("aply_fm_yrwk", "aplyFmYrwk");
		this.hashFields.put("agmt_act_cnt_cd", "agmtActCntCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bkg_por_cnt_cd", "bkgPorCntCd");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("tab_rhq_cd", "tabRhqCd");
		this.hashFields.put("asgn_ttl_wgt", "asgnTtlWgt");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("subtrade", "subtrade");
		this.hashFields.put("n1st_ts_dir_cd", "n1stTsDirCd");
		this.hashFields.put("old_aloc_lod_qty", "oldAlocLodQty");
		this.hashFields.put("sc_nm", "scNm");
		this.hashFields.put("ctrt_cust_cnt_nm", "ctrtCustCntNm");
		this.hashFields.put("bkg_aloc_tp_cd", "bkgAlocTpCd");
		this.hashFields.put("aloc_lod_qty_rto", "alocLodQtyRto");
		this.hashFields.put("aloc_aply_fm_dt", "alocAplyFmDt");
		this.hashFields.put("bkg_del_cnt_cd", "bkgDelCntCd");
		this.hashFields.put("old_op_cntr_qty", "oldOpCntrQty");
		this.hashFields.put("n1st_ts_pod_cnt_cd", "n1stTsPodCntCd");
		this.hashFields.put("val_value2", "valValue2");
		this.hashFields.put("cmpb_amt", "cmpbAmt");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("old_op_cntr_qty_rto", "oldOpCntrQtyRto");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("op_cntr_qty_rto", "opCntrQtyRto");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("lane_cnt", "laneCnt");
		this.hashFields.put("dg_rd", "dgRd");
		this.hashFields.put("rfa_nm", "rfaNm");
		this.hashFields.put("cmpb_per_wgt", "cmpbPerWgt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dir_cnt", "dirCnt");
		this.hashFields.put("bkg_pod_cnt_cd", "bkgPodCntCd");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("val_type", "valType");
		this.hashFields.put("n1st_ts_pol_cnt_cd", "n1stTsPolCntCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("ts_nod_cd", "tsNodCd");
		this.hashFields.put("asgn_wgt_rto", "asgnWgtRto");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cmdt_cnt", "cmdtCnt");
		this.hashFields.put("oft_chg_amt", "oftChgAmt");
		this.hashFields.put("sinwa_seq", "sinwaSeq");
		this.hashFields.put("n2nd_ts_slan_cd", "n2ndTsSlanCd");
		this.hashFields.put("ofc_ty", "ofcTy");
		this.hashFields.put("shaas_seq", "shaasSeq");
		this.hashFields.put("old_cmpb_amt", "oldCmpbAmt");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("trnk_dir_cd", "trnkDirCd");
		this.hashFields.put("val_cnt", "valCnt");
		this.hashFields.put("scg_grp_cmdt_desc", "scgGrpCmdtDesc");
		this.hashFields.put("old_asgn_ttl_wgt", "oldAsgnTtlWgt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("rfa_ctrt_tp_cd", "rfaCtrtTpCd");
		this.hashFields.put("chk_op", "chkOp");
		this.hashFields.put("vvd_sig", "vvdSig");
		this.hashFields.put("ts_pod_nod_cd", "tsPodNodCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("wgt_per_teu", "wgtPerTeu");
		this.hashFields.put("aloc_lod_qty", "alocLodQty");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("bkg_pol_cnt_cd", "bkgPolCntCd");
		this.hashFields.put("aloc_use_flg", "alocUseFlg");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("aloc_svc_cd", "alocSvcCd");
		this.hashFields.put("trnk_slan_cd", "trnkSlanCd");
		this.hashFields.put("bkg_del_scc_cd", "bkgDelSccCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("old_oft_chg_amt", "oldOftChgAmt");
		this.hashFields.put("crr_nm", "crrNm");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("scg_grp_cmdt_seq", "scgGrpCmdtSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n1st_ts_slan_cd", "n1stTsSlanCd");
		this.hashFields.put("cmpb_ony_flg", "cmpbOnyFlg");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("acct_tp", "acctTp");
		this.hashFields.put("old_aasgn_wgt_rto", "oldAasgnWgtRto");
		this.hashFields.put("bkg_ctrl_tp_cd", "bkgCtrlTpCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("aply_to_yrwk", "aplyToYrwk");
		this.hashFields.put("cust_cnt_nm", "custCntNm");
		this.hashFields.put("ts_pol_nod_cd", "tsPolNodCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_aloc_seq", "bkgAlocSeq");
		this.hashFields.put("bkg_por_scc_cd", "bkgPorSccCd");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("usa_bkg_mod_cd", "usaBkgModCd");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("bkg_aloc_rmk", "bkgAlocRmk");
		this.hashFields.put("n2nd_ts_pol_cd", "n2ndTsPolCd");
		this.hashFields.put("val_value", "valValue");
		this.hashFields.put("n2nd_ts_pod_cd", "n2ndTsPodCd");
		this.hashFields.put("trunk_pol_cd", "trunkPolCd");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("n1st_ts_pol_cd", "n1stTsPolCd");
		this.hashFields.put("aloc_aply_to_dt", "alocAplyToDt");
		this.hashFields.put("trunk_pod_cd", "trunkPodCd");
		this.hashFields.put("old_aloc_lod_qty_rto", "oldAlocLodQtyRto");
		this.hashFields.put("n1st_ts_pod_cd", "n1stTsPodCd");
		return this.hashFields;
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
	 * @return agmtActCntCd
	 */
	public String getAgmtActCntCd() {
		return this.agmtActCntCd;
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
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return bkgPorCntCd
	 */
	public String getBkgPorCntCd() {
		return this.bkgPorCntCd;
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
	 * @return tabRhqCd
	 */
	public String getTabRhqCd() {
		return this.tabRhqCd;
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
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}
	
	/**
	 * Column Info
	 * @return subtrade
	 */
	public String getSubtrade() {
		return this.subtrade;
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
	 * @return oldAlocLodQty
	 */
	public String getOldAlocLodQty() {
		return this.oldAlocLodQty;
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
	 * @return ctrtCustCntNm
	 */
	public String getCtrtCustCntNm() {
		return this.ctrtCustCntNm;
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
	 * @return alocLodQtyRto
	 */
	public String getAlocLodQtyRto() {
		return this.alocLodQtyRto;
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
	 * @return bkgDelCntCd
	 */
	public String getBkgDelCntCd() {
		return this.bkgDelCntCd;
	}
	
	/**
	 * Column Info
	 * @return oldOpCntrQty
	 */
	public String getOldOpCntrQty() {
		return this.oldOpCntrQty;
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
	 * @return valValue2
	 */
	public String getValValue2() {
		return this.valValue2;
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
	 * @return custGrpNm
	 */
	public String getCustGrpNm() {
		return this.custGrpNm;
	}
	
	/**
	 * Column Info
	 * @return oldOpCntrQtyRto
	 */
	public String getOldOpCntrQtyRto() {
		return this.oldOpCntrQtyRto;
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
	 * @return opCntrQtyRto
	 */
	public String getOpCntrQtyRto() {
		return this.opCntrQtyRto;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return laneCnt
	 */
	public String getLaneCnt() {
		return this.laneCnt;
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
	 * @return rfaNm
	 */
	public String getRfaNm() {
		return this.rfaNm;
	}
	
	/**
	 * Column Info
	 * @return cmpbPerWgt
	 */
	public String getCmpbPerWgt() {
		return this.cmpbPerWgt;
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
	 * @return dirCnt
	 */
	public String getDirCnt() {
		return this.dirCnt;
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
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
	}
	
	/**
	 * Column Info
	 * @return valType
	 */
	public String getValType() {
		return this.valType;
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return tsNodCd
	 */
	public String getTsNodCd() {
		return this.tsNodCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return cmdtCnt
	 */
	public String getCmdtCnt() {
		return this.cmdtCnt;
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
	 * @return sinwaSeq
	 */
	public String getSinwaSeq() {
		return this.sinwaSeq;
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
	 * @return ofcTy
	 */
	public String getOfcTy() {
		return this.ofcTy;
	}
	
	/**
	 * Column Info
	 * @return shaasSeq
	 */
	public String getShaasSeq() {
		return this.shaasSeq;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
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
	 * @return valCnt
	 */
	public String getValCnt() {
		return this.valCnt;
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
	 * @return oldAsgnTtlWgt
	 */
	public String getOldAsgnTtlWgt() {
		return this.oldAsgnTtlWgt;
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
	 * @return rfaCtrtTpCd
	 */
	public String getRfaCtrtTpCd() {
		return this.rfaCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return chkOp
	 */
	public String getChkOp() {
		return this.chkOp;
	}
	
	/**
	 * Column Info
	 * @return vvdSig
	 */
	public String getVvdSig() {
		return this.vvdSig;
	}
	
	/**
	 * Column Info
	 * @return tsPodNodCd
	 */
	public String getTsPodNodCd() {
		return this.tsPodNodCd;
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
	 * @return wgtPerTeu
	 */
	public String getWgtPerTeu() {
		return this.wgtPerTeu;
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
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
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
	 * @return bkgPolCntCd
	 */
	public String getBkgPolCntCd() {
		return this.bkgPolCntCd;
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
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
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
	 * @return trnkSlanCd
	 */
	public String getTrnkSlanCd() {
		return this.trnkSlanCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDelSccCd
	 */
	public String getBkgDelSccCd() {
		return this.bkgDelSccCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return oldOftChgAmt
	 */
	public String getOldOftChgAmt() {
		return this.oldOftChgAmt;
	}
	
	/**
	 * Column Info
	 * @return crrNm
	 */
	public String getCrrNm() {
		return this.crrNm;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return scgGrpCmdtSeq
	 */
	public String getScgGrpCmdtSeq() {
		return this.scgGrpCmdtSeq;
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
	 * @return ctrtCustCntCd
	 */
	public String getCtrtCustCntCd() {
		return this.ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
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
	 * @return n1stTsSlanCd
	 */
	public String getN1stTsSlanCd() {
		return this.n1stTsSlanCd;
	}
	
	/**
	 * Column Info
	 * @return cmpbOnyFlg
	 */
	public String getCmpbOnyFlg() {
		return this.cmpbOnyFlg;
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
	 * @return acctTp
	 */
	public String getAcctTp() {
		return this.acctTp;
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
	 * @return bkgCtrlTpCd
	 */
	public String getBkgCtrlTpCd() {
		return this.bkgCtrlTpCd;
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
	 * @return aplyToYrwk
	 */
	public String getAplyToYrwk() {
		return this.aplyToYrwk;
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
	 * @return tsPolNodCd
	 */
	public String getTsPolNodCd() {
		return this.tsPolNodCd;
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
	 * @return bkgAlocSeq
	 */
	public String getBkgAlocSeq() {
		return this.bkgAlocSeq;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return usaBkgModCd
	 */
	public String getUsaBkgModCd() {
		return this.usaBkgModCd;
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
	 * @return bkgAlocRmk
	 */
	public String getBkgAlocRmk() {
		return this.bkgAlocRmk;
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
	 * @return valValue
	 */
	public String getValValue() {
		return this.valValue;
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
	 * @return trunkPolCd
	 */
	public String getTrunkPolCd() {
		return this.trunkPolCd;
	}
	
	/**
	 * Column Info
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
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
	 * @return alocAplyToDt
	 */
	public String getAlocAplyToDt() {
		return this.alocAplyToDt;
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
	 * @return oldAlocLodQtyRto
	 */
	public String getOldAlocLodQtyRto() {
		return this.oldAlocLodQtyRto;
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
	 * @param aplyFmYrwk
	 */
	public void setAplyFmYrwk(String aplyFmYrwk) {
		this.aplyFmYrwk = aplyFmYrwk;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param bkgPorCntCd
	 */
	public void setBkgPorCntCd(String bkgPorCntCd) {
		this.bkgPorCntCd = bkgPorCntCd;
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
	 * @param tabRhqCd
	 */
	public void setTabRhqCd(String tabRhqCd) {
		this.tabRhqCd = tabRhqCd;
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
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	/**
	 * Column Info
	 * @param subtrade
	 */
	public void setSubtrade(String subtrade) {
		this.subtrade = subtrade;
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
	 * @param oldAlocLodQty
	 */
	public void setOldAlocLodQty(String oldAlocLodQty) {
		this.oldAlocLodQty = oldAlocLodQty;
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
	 * @param ctrtCustCntNm
	 */
	public void setCtrtCustCntNm(String ctrtCustCntNm) {
		this.ctrtCustCntNm = ctrtCustCntNm;
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
	 * @param alocLodQtyRto
	 */
	public void setAlocLodQtyRto(String alocLodQtyRto) {
		this.alocLodQtyRto = alocLodQtyRto;
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
	 * @param bkgDelCntCd
	 */
	public void setBkgDelCntCd(String bkgDelCntCd) {
		this.bkgDelCntCd = bkgDelCntCd;
	}
	
	/**
	 * Column Info
	 * @param oldOpCntrQty
	 */
	public void setOldOpCntrQty(String oldOpCntrQty) {
		this.oldOpCntrQty = oldOpCntrQty;
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
	 * @param valValue2
	 */
	public void setValValue2(String valValue2) {
		this.valValue2 = valValue2;
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
	 * @param custGrpNm
	 */
	public void setCustGrpNm(String custGrpNm) {
		this.custGrpNm = custGrpNm;
	}
	
	/**
	 * Column Info
	 * @param oldOpCntrQtyRto
	 */
	public void setOldOpCntrQtyRto(String oldOpCntrQtyRto) {
		this.oldOpCntrQtyRto = oldOpCntrQtyRto;
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
	 * @param opCntrQtyRto
	 */
	public void setOpCntrQtyRto(String opCntrQtyRto) {
		this.opCntrQtyRto = opCntrQtyRto;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param laneCnt
	 */
	public void setLaneCnt(String laneCnt) {
		this.laneCnt = laneCnt;
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
	 * @param rfaNm
	 */
	public void setRfaNm(String rfaNm) {
		this.rfaNm = rfaNm;
	}
	
	/**
	 * Column Info
	 * @param cmpbPerWgt
	 */
	public void setCmpbPerWgt(String cmpbPerWgt) {
		this.cmpbPerWgt = cmpbPerWgt;
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
	 * @param dirCnt
	 */
	public void setDirCnt(String dirCnt) {
		this.dirCnt = dirCnt;
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
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}
	
	/**
	 * Column Info
	 * @param valType
	 */
	public void setValType(String valType) {
		this.valType = valType;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param tsNodCd
	 */
	public void setTsNodCd(String tsNodCd) {
		this.tsNodCd = tsNodCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cmdtCnt
	 */
	public void setCmdtCnt(String cmdtCnt) {
		this.cmdtCnt = cmdtCnt;
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
	 * @param sinwaSeq
	 */
	public void setSinwaSeq(String sinwaSeq) {
		this.sinwaSeq = sinwaSeq;
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
	 * @param ofcTy
	 */
	public void setOfcTy(String ofcTy) {
		this.ofcTy = ofcTy;
	}
	
	/**
	 * Column Info
	 * @param shaasSeq
	 */
	public void setShaasSeq(String shaasSeq) {
		this.shaasSeq = shaasSeq;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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
	 * @param valCnt
	 */
	public void setValCnt(String valCnt) {
		this.valCnt = valCnt;
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
	 * @param oldAsgnTtlWgt
	 */
	public void setOldAsgnTtlWgt(String oldAsgnTtlWgt) {
		this.oldAsgnTtlWgt = oldAsgnTtlWgt;
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
	 * @param rfaCtrtTpCd
	 */
	public void setRfaCtrtTpCd(String rfaCtrtTpCd) {
		this.rfaCtrtTpCd = rfaCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param chkOp
	 */
	public void setChkOp(String chkOp) {
		this.chkOp = chkOp;
	}
	
	/**
	 * Column Info
	 * @param vvdSig
	 */
	public void setVvdSig(String vvdSig) {
		this.vvdSig = vvdSig;
	}
	
	/**
	 * Column Info
	 * @param tsPodNodCd
	 */
	public void setTsPodNodCd(String tsPodNodCd) {
		this.tsPodNodCd = tsPodNodCd;
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
	 * @param wgtPerTeu
	 */
	public void setWgtPerTeu(String wgtPerTeu) {
		this.wgtPerTeu = wgtPerTeu;
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
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
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
	 * @param bkgPolCntCd
	 */
	public void setBkgPolCntCd(String bkgPolCntCd) {
		this.bkgPolCntCd = bkgPolCntCd;
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
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
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
	 * @param trnkSlanCd
	 */
	public void setTrnkSlanCd(String trnkSlanCd) {
		this.trnkSlanCd = trnkSlanCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDelSccCd
	 */
	public void setBkgDelSccCd(String bkgDelSccCd) {
		this.bkgDelSccCd = bkgDelSccCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param oldOftChgAmt
	 */
	public void setOldOftChgAmt(String oldOftChgAmt) {
		this.oldOftChgAmt = oldOftChgAmt;
	}
	
	/**
	 * Column Info
	 * @param crrNm
	 */
	public void setCrrNm(String crrNm) {
		this.crrNm = crrNm;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param scgGrpCmdtSeq
	 */
	public void setScgGrpCmdtSeq(String scgGrpCmdtSeq) {
		this.scgGrpCmdtSeq = scgGrpCmdtSeq;
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
	 * @param ctrtCustCntCd
	 */
	public void setCtrtCustCntCd(String ctrtCustCntCd) {
		this.ctrtCustCntCd = ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
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
	 * @param n1stTsSlanCd
	 */
	public void setN1stTsSlanCd(String n1stTsSlanCd) {
		this.n1stTsSlanCd = n1stTsSlanCd;
	}
	
	/**
	 * Column Info
	 * @param cmpbOnyFlg
	 */
	public void setCmpbOnyFlg(String cmpbOnyFlg) {
		this.cmpbOnyFlg = cmpbOnyFlg;
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
	 * @param acctTp
	 */
	public void setAcctTp(String acctTp) {
		this.acctTp = acctTp;
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
	 * @param bkgCtrlTpCd
	 */
	public void setBkgCtrlTpCd(String bkgCtrlTpCd) {
		this.bkgCtrlTpCd = bkgCtrlTpCd;
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
	 * @param aplyToYrwk
	 */
	public void setAplyToYrwk(String aplyToYrwk) {
		this.aplyToYrwk = aplyToYrwk;
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
	 * @param tsPolNodCd
	 */
	public void setTsPolNodCd(String tsPolNodCd) {
		this.tsPolNodCd = tsPolNodCd;
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
	 * @param bkgAlocSeq
	 */
	public void setBkgAlocSeq(String bkgAlocSeq) {
		this.bkgAlocSeq = bkgAlocSeq;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param usaBkgModCd
	 */
	public void setUsaBkgModCd(String usaBkgModCd) {
		this.usaBkgModCd = usaBkgModCd;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
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
	 * @param n2ndTsPolCd
	 */
	public void setN2ndTsPolCd(String n2ndTsPolCd) {
		this.n2ndTsPolCd = n2ndTsPolCd;
	}
	
	/**
	 * Column Info
	 * @param valValue
	 */
	public void setValValue(String valValue) {
		this.valValue = valValue;
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
	 * @param trunkPolCd
	 */
	public void setTrunkPolCd(String trunkPolCd) {
		this.trunkPolCd = trunkPolCd;
	}
	
	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
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
	 * @param alocAplyToDt
	 */
	public void setAlocAplyToDt(String alocAplyToDt) {
		this.alocAplyToDt = alocAplyToDt;
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
	 * @param oldAlocLodQtyRto
	 */
	public void setOldAlocLodQtyRto(String oldAlocLodQtyRto) {
		this.oldAlocLodQtyRto = oldAlocLodQtyRto;
	}
	
	/**
	 * Column Info
	 * @param n1stTsPodCd
	 */
	public void setN1stTsPodCd(String n1stTsPodCd) {
		this.n1stTsPodCd = n1stTsPodCd;
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
		setAplyFmYrwk(JSPUtil.getParameter(request, prefix + "aply_fm_yrwk", ""));
		setAgmtActCntCd(JSPUtil.getParameter(request, prefix + "agmt_act_cnt_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBkgPorCntCd(JSPUtil.getParameter(request, prefix + "bkg_por_cnt_cd", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setTabRhqCd(JSPUtil.getParameter(request, prefix + "tab_rhq_cd", ""));
		setAsgnTtlWgt(JSPUtil.getParameter(request, prefix + "asgn_ttl_wgt", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setSubtrade(JSPUtil.getParameter(request, prefix + "subtrade", ""));
		setN1stTsDirCd(JSPUtil.getParameter(request, prefix + "n1st_ts_dir_cd", ""));
		setOldAlocLodQty(JSPUtil.getParameter(request, prefix + "old_aloc_lod_qty", ""));
		setScNm(JSPUtil.getParameter(request, prefix + "sc_nm", ""));
		setCtrtCustCntNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_nm", ""));
		setBkgAlocTpCd(JSPUtil.getParameter(request, prefix + "bkg_aloc_tp_cd", ""));
		setAlocLodQtyRto(JSPUtil.getParameter(request, prefix + "aloc_lod_qty_rto", ""));
		setAlocAplyFmDt(JSPUtil.getParameter(request, prefix + "aloc_aply_fm_dt", ""));
		setBkgDelCntCd(JSPUtil.getParameter(request, prefix + "bkg_del_cnt_cd", ""));
		setOldOpCntrQty(JSPUtil.getParameter(request, prefix + "old_op_cntr_qty", ""));
		setN1stTsPodCntCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pod_cnt_cd", ""));
		setValValue2(JSPUtil.getParameter(request, prefix + "val_value2", ""));
		setCmpbAmt(JSPUtil.getParameter(request, prefix + "cmpb_amt", ""));
		setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
		setOldOpCntrQtyRto(JSPUtil.getParameter(request, prefix + "old_op_cntr_qty_rto", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setOpCntrQtyRto(JSPUtil.getParameter(request, prefix + "op_cntr_qty_rto", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setLaneCnt(JSPUtil.getParameter(request, prefix + "lane_cnt", ""));
		setDgRd(JSPUtil.getParameter(request, prefix + "dg_rd", ""));
		setRfaNm(JSPUtil.getParameter(request, prefix + "rfa_nm", ""));
		setCmpbPerWgt(JSPUtil.getParameter(request, prefix + "cmpb_per_wgt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDirCnt(JSPUtil.getParameter(request, prefix + "dir_cnt", ""));
		setBkgPodCntCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cnt_cd", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setValType(JSPUtil.getParameter(request, prefix + "val_type", ""));
		setN1stTsPolCntCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pol_cnt_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setTsNodCd(JSPUtil.getParameter(request, prefix + "ts_nod_cd", ""));
		setAsgnWgtRto(JSPUtil.getParameter(request, prefix + "asgn_wgt_rto", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCmdtCnt(JSPUtil.getParameter(request, prefix + "cmdt_cnt", ""));
		setOftChgAmt(JSPUtil.getParameter(request, prefix + "oft_chg_amt", ""));
		setSinwaSeq(JSPUtil.getParameter(request, prefix + "sinwa_seq", ""));
		setN2ndTsSlanCd(JSPUtil.getParameter(request, prefix + "n2nd_ts_slan_cd", ""));
		setOfcTy(JSPUtil.getParameter(request, prefix + "ofc_ty", ""));
		setShaasSeq(JSPUtil.getParameter(request, prefix + "shaas_seq", ""));
		setOldCmpbAmt(JSPUtil.getParameter(request, prefix + "old_cmpb_amt", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setTrnkDirCd(JSPUtil.getParameter(request, prefix + "trnk_dir_cd", ""));
		setValCnt(JSPUtil.getParameter(request, prefix + "val_cnt", ""));
		setScgGrpCmdtDesc(JSPUtil.getParameter(request, prefix + "scg_grp_cmdt_desc", ""));
		setOldAsgnTtlWgt(JSPUtil.getParameter(request, prefix + "old_asgn_ttl_wgt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setRfaCtrtTpCd(JSPUtil.getParameter(request, prefix + "rfa_ctrt_tp_cd", ""));
		setChkOp(JSPUtil.getParameter(request, prefix + "chk_op", ""));
		setVvdSig(JSPUtil.getParameter(request, prefix + "vvd_sig", ""));
		setTsPodNodCd(JSPUtil.getParameter(request, prefix + "ts_pod_nod_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setWgtPerTeu(JSPUtil.getParameter(request, prefix + "wgt_per_teu", ""));
		setAlocLodQty(JSPUtil.getParameter(request, prefix + "aloc_lod_qty", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setBkgPolCntCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cnt_cd", ""));
		setAlocUseFlg(JSPUtil.getParameter(request, prefix + "aloc_use_flg", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setAlocSvcCd(JSPUtil.getParameter(request, prefix + "aloc_svc_cd", ""));
		setTrnkSlanCd(JSPUtil.getParameter(request, prefix + "trnk_slan_cd", ""));
		setBkgDelSccCd(JSPUtil.getParameter(request, prefix + "bkg_del_scc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOldOftChgAmt(JSPUtil.getParameter(request, prefix + "old_oft_chg_amt", ""));
		setCrrNm(JSPUtil.getParameter(request, prefix + "crr_nm", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setScgGrpCmdtSeq(JSPUtil.getParameter(request, prefix + "scg_grp_cmdt_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCtrtCustCntCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_cd", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setN1stTsSlanCd(JSPUtil.getParameter(request, prefix + "n1st_ts_slan_cd", ""));
		setCmpbOnyFlg(JSPUtil.getParameter(request, prefix + "cmpb_ony_flg", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setAcctTp(JSPUtil.getParameter(request, prefix + "acct_tp", ""));
		setOldAasgnWgtRto(JSPUtil.getParameter(request, prefix + "old_aasgn_wgt_rto", ""));
		setBkgCtrlTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrl_tp_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setAplyToYrwk(JSPUtil.getParameter(request, prefix + "aply_to_yrwk", ""));
		setCustCntNm(JSPUtil.getParameter(request, prefix + "cust_cnt_nm", ""));
		setTsPolNodCd(JSPUtil.getParameter(request, prefix + "ts_pol_nod_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgAlocSeq(JSPUtil.getParameter(request, prefix + "bkg_aloc_seq", ""));
		setBkgPorSccCd(JSPUtil.getParameter(request, prefix + "bkg_por_scc_cd", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
		setUsaBkgModCd(JSPUtil.getParameter(request, prefix + "usa_bkg_mod_cd", ""));
		setBound(JSPUtil.getParameter(request, prefix + "bound", ""));
		setBkgAlocRmk(JSPUtil.getParameter(request, prefix + "bkg_aloc_rmk", ""));
		setN2ndTsPolCd(JSPUtil.getParameter(request, prefix + "n2nd_ts_pol_cd", ""));
		setValValue(JSPUtil.getParameter(request, prefix + "val_value", ""));
		setN2ndTsPodCd(JSPUtil.getParameter(request, prefix + "n2nd_ts_pod_cd", ""));
		setTrunkPolCd(JSPUtil.getParameter(request, prefix + "trunk_pol_cd", ""));
		setTrade(JSPUtil.getParameter(request, prefix + "trade", ""));
		setN1stTsPolCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pol_cd", ""));
		setAlocAplyToDt(JSPUtil.getParameter(request, prefix + "aloc_aply_to_dt", ""));
		setTrunkPodCd(JSPUtil.getParameter(request, prefix + "trunk_pod_cd", ""));
		setOldAlocLodQtyRto(JSPUtil.getParameter(request, prefix + "old_aloc_lod_qty_rto", ""));
		setN1stTsPodCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcAlocMgmtVO[]
	 */
	public SpcAlocMgmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcAlocMgmtVO[]
	 */
	public SpcAlocMgmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcAlocMgmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aplyFmYrwk = (JSPUtil.getParameter(request, prefix	+ "aply_fm_yrwk", length));
			String[] agmtActCntCd = (JSPUtil.getParameter(request, prefix	+ "agmt_act_cnt_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bkgPorCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cnt_cd", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] tabRhqCd = (JSPUtil.getParameter(request, prefix	+ "tab_rhq_cd", length));
			String[] asgnTtlWgt = (JSPUtil.getParameter(request, prefix	+ "asgn_ttl_wgt", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] subtrade = (JSPUtil.getParameter(request, prefix	+ "subtrade", length));
			String[] n1stTsDirCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_dir_cd", length));
			String[] oldAlocLodQty = (JSPUtil.getParameter(request, prefix	+ "old_aloc_lod_qty", length));
			String[] scNm = (JSPUtil.getParameter(request, prefix	+ "sc_nm", length));
			String[] ctrtCustCntNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_nm", length));
			String[] bkgAlocTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_tp_cd", length));
			String[] alocLodQtyRto = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty_rto", length));
			String[] alocAplyFmDt = (JSPUtil.getParameter(request, prefix	+ "aloc_aply_fm_dt", length));
			String[] bkgDelCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cnt_cd", length));
			String[] oldOpCntrQty = (JSPUtil.getParameter(request, prefix	+ "old_op_cntr_qty", length));
			String[] n1stTsPodCntCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pod_cnt_cd", length));
			String[] valValue2 = (JSPUtil.getParameter(request, prefix	+ "val_value2", length));
			String[] cmpbAmt = (JSPUtil.getParameter(request, prefix	+ "cmpb_amt", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] oldOpCntrQtyRto = (JSPUtil.getParameter(request, prefix	+ "old_op_cntr_qty_rto", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] opCntrQtyRto = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty_rto", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] laneCnt = (JSPUtil.getParameter(request, prefix	+ "lane_cnt", length));
			String[] dgRd = (JSPUtil.getParameter(request, prefix	+ "dg_rd", length));
			String[] rfaNm = (JSPUtil.getParameter(request, prefix	+ "rfa_nm", length));
			String[] cmpbPerWgt = (JSPUtil.getParameter(request, prefix	+ "cmpb_per_wgt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dirCnt = (JSPUtil.getParameter(request, prefix	+ "dir_cnt", length));
			String[] bkgPodCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cnt_cd", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] valType = (JSPUtil.getParameter(request, prefix	+ "val_type", length));
			String[] n1stTsPolCntCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pol_cnt_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] tsNodCd = (JSPUtil.getParameter(request, prefix	+ "ts_nod_cd", length));
			String[] asgnWgtRto = (JSPUtil.getParameter(request, prefix	+ "asgn_wgt_rto", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cmdtCnt = (JSPUtil.getParameter(request, prefix	+ "cmdt_cnt", length));
			String[] oftChgAmt = (JSPUtil.getParameter(request, prefix	+ "oft_chg_amt", length));
			String[] sinwaSeq = (JSPUtil.getParameter(request, prefix	+ "sinwa_seq", length));
			String[] n2ndTsSlanCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_slan_cd", length));
			String[] ofcTy = (JSPUtil.getParameter(request, prefix	+ "ofc_ty", length));
			String[] shaasSeq = (JSPUtil.getParameter(request, prefix	+ "shaas_seq", length));
			String[] oldCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "old_cmpb_amt", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] trnkDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_dir_cd", length));
			String[] valCnt = (JSPUtil.getParameter(request, prefix	+ "val_cnt", length));
			String[] scgGrpCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_desc", length));
			String[] oldAsgnTtlWgt = (JSPUtil.getParameter(request, prefix	+ "old_asgn_ttl_wgt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] rfaCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "rfa_ctrt_tp_cd", length));
			String[] chkOp = (JSPUtil.getParameter(request, prefix	+ "chk_op", length));
			String[] vvdSig = (JSPUtil.getParameter(request, prefix	+ "vvd_sig", length));
			String[] tsPodNodCd = (JSPUtil.getParameter(request, prefix	+ "ts_pod_nod_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] wgtPerTeu = (JSPUtil.getParameter(request, prefix	+ "wgt_per_teu", length));
			String[] alocLodQty = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] bkgPolCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cnt_cd", length));
			String[] alocUseFlg = (JSPUtil.getParameter(request, prefix	+ "aloc_use_flg", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] alocSvcCd = (JSPUtil.getParameter(request, prefix	+ "aloc_svc_cd", length));
			String[] trnkSlanCd = (JSPUtil.getParameter(request, prefix	+ "trnk_slan_cd", length));
			String[] bkgDelSccCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_scc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] oldOftChgAmt = (JSPUtil.getParameter(request, prefix	+ "old_oft_chg_amt", length));
			String[] crrNm = (JSPUtil.getParameter(request, prefix	+ "crr_nm", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] scgGrpCmdtSeq = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_seq", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n1stTsSlanCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_slan_cd", length));
			String[] cmpbOnyFlg = (JSPUtil.getParameter(request, prefix	+ "cmpb_ony_flg", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] acctTp = (JSPUtil.getParameter(request, prefix	+ "acct_tp", length));
			String[] oldAasgnWgtRto = (JSPUtil.getParameter(request, prefix	+ "old_aasgn_wgt_rto", length));
			String[] bkgCtrlTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_tp_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] aplyToYrwk = (JSPUtil.getParameter(request, prefix	+ "aply_to_yrwk", length));
			String[] custCntNm = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_nm", length));
			String[] tsPolNodCd = (JSPUtil.getParameter(request, prefix	+ "ts_pol_nod_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgAlocSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_seq", length));
			String[] bkgPorSccCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_scc_cd", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] usaBkgModCd = (JSPUtil.getParameter(request, prefix	+ "usa_bkg_mod_cd", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] bkgAlocRmk = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_rmk", length));
			String[] n2ndTsPolCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_pol_cd", length));
			String[] valValue = (JSPUtil.getParameter(request, prefix	+ "val_value", length));
			String[] n2ndTsPodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_pod_cd", length));
			String[] trunkPolCd = (JSPUtil.getParameter(request, prefix	+ "trunk_pol_cd", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] n1stTsPolCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pol_cd", length));
			String[] alocAplyToDt = (JSPUtil.getParameter(request, prefix	+ "aloc_aply_to_dt", length));
			String[] trunkPodCd = (JSPUtil.getParameter(request, prefix	+ "trunk_pod_cd", length));
			String[] oldAlocLodQtyRto = (JSPUtil.getParameter(request, prefix	+ "old_aloc_lod_qty_rto", length));
			String[] n1stTsPodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpcAlocMgmtVO();
				if (aplyFmYrwk[i] != null)
					model.setAplyFmYrwk(aplyFmYrwk[i]);
				if (agmtActCntCd[i] != null)
					model.setAgmtActCntCd(agmtActCntCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bkgPorCntCd[i] != null)
					model.setBkgPorCntCd(bkgPorCntCd[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (tabRhqCd[i] != null)
					model.setTabRhqCd(tabRhqCd[i]);
				if (asgnTtlWgt[i] != null)
					model.setAsgnTtlWgt(asgnTtlWgt[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (subtrade[i] != null)
					model.setSubtrade(subtrade[i]);
				if (n1stTsDirCd[i] != null)
					model.setN1stTsDirCd(n1stTsDirCd[i]);
				if (oldAlocLodQty[i] != null)
					model.setOldAlocLodQty(oldAlocLodQty[i]);
				if (scNm[i] != null)
					model.setScNm(scNm[i]);
				if (ctrtCustCntNm[i] != null)
					model.setCtrtCustCntNm(ctrtCustCntNm[i]);
				if (bkgAlocTpCd[i] != null)
					model.setBkgAlocTpCd(bkgAlocTpCd[i]);
				if (alocLodQtyRto[i] != null)
					model.setAlocLodQtyRto(alocLodQtyRto[i]);
				if (alocAplyFmDt[i] != null)
					model.setAlocAplyFmDt(alocAplyFmDt[i]);
				if (bkgDelCntCd[i] != null)
					model.setBkgDelCntCd(bkgDelCntCd[i]);
				if (oldOpCntrQty[i] != null)
					model.setOldOpCntrQty(oldOpCntrQty[i]);
				if (n1stTsPodCntCd[i] != null)
					model.setN1stTsPodCntCd(n1stTsPodCntCd[i]);
				if (valValue2[i] != null)
					model.setValValue2(valValue2[i]);
				if (cmpbAmt[i] != null)
					model.setCmpbAmt(cmpbAmt[i]);
				if (custGrpNm[i] != null)
					model.setCustGrpNm(custGrpNm[i]);
				if (oldOpCntrQtyRto[i] != null)
					model.setOldOpCntrQtyRto(oldOpCntrQtyRto[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (opCntrQtyRto[i] != null)
					model.setOpCntrQtyRto(opCntrQtyRto[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (laneCnt[i] != null)
					model.setLaneCnt(laneCnt[i]);
				if (dgRd[i] != null)
					model.setDgRd(dgRd[i]);
				if (rfaNm[i] != null)
					model.setRfaNm(rfaNm[i]);
				if (cmpbPerWgt[i] != null)
					model.setCmpbPerWgt(cmpbPerWgt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dirCnt[i] != null)
					model.setDirCnt(dirCnt[i]);
				if (bkgPodCntCd[i] != null)
					model.setBkgPodCntCd(bkgPodCntCd[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (valType[i] != null)
					model.setValType(valType[i]);
				if (n1stTsPolCntCd[i] != null)
					model.setN1stTsPolCntCd(n1stTsPolCntCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (tsNodCd[i] != null)
					model.setTsNodCd(tsNodCd[i]);
				if (asgnWgtRto[i] != null)
					model.setAsgnWgtRto(asgnWgtRto[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cmdtCnt[i] != null)
					model.setCmdtCnt(cmdtCnt[i]);
				if (oftChgAmt[i] != null)
					model.setOftChgAmt(oftChgAmt[i]);
				if (sinwaSeq[i] != null)
					model.setSinwaSeq(sinwaSeq[i]);
				if (n2ndTsSlanCd[i] != null)
					model.setN2ndTsSlanCd(n2ndTsSlanCd[i]);
				if (ofcTy[i] != null)
					model.setOfcTy(ofcTy[i]);
				if (shaasSeq[i] != null)
					model.setShaasSeq(shaasSeq[i]);
				if (oldCmpbAmt[i] != null)
					model.setOldCmpbAmt(oldCmpbAmt[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (trnkDirCd[i] != null)
					model.setTrnkDirCd(trnkDirCd[i]);
				if (valCnt[i] != null)
					model.setValCnt(valCnt[i]);
				if (scgGrpCmdtDesc[i] != null)
					model.setScgGrpCmdtDesc(scgGrpCmdtDesc[i]);
				if (oldAsgnTtlWgt[i] != null)
					model.setOldAsgnTtlWgt(oldAsgnTtlWgt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (rfaCtrtTpCd[i] != null)
					model.setRfaCtrtTpCd(rfaCtrtTpCd[i]);
				if (chkOp[i] != null)
					model.setChkOp(chkOp[i]);
				if (vvdSig[i] != null)
					model.setVvdSig(vvdSig[i]);
				if (tsPodNodCd[i] != null)
					model.setTsPodNodCd(tsPodNodCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (wgtPerTeu[i] != null)
					model.setWgtPerTeu(wgtPerTeu[i]);
				if (alocLodQty[i] != null)
					model.setAlocLodQty(alocLodQty[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (bkgPolCntCd[i] != null)
					model.setBkgPolCntCd(bkgPolCntCd[i]);
				if (alocUseFlg[i] != null)
					model.setAlocUseFlg(alocUseFlg[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (alocSvcCd[i] != null)
					model.setAlocSvcCd(alocSvcCd[i]);
				if (trnkSlanCd[i] != null)
					model.setTrnkSlanCd(trnkSlanCd[i]);
				if (bkgDelSccCd[i] != null)
					model.setBkgDelSccCd(bkgDelSccCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (oldOftChgAmt[i] != null)
					model.setOldOftChgAmt(oldOftChgAmt[i]);
				if (crrNm[i] != null)
					model.setCrrNm(crrNm[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (scgGrpCmdtSeq[i] != null)
					model.setScgGrpCmdtSeq(scgGrpCmdtSeq[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n1stTsSlanCd[i] != null)
					model.setN1stTsSlanCd(n1stTsSlanCd[i]);
				if (cmpbOnyFlg[i] != null)
					model.setCmpbOnyFlg(cmpbOnyFlg[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (acctTp[i] != null)
					model.setAcctTp(acctTp[i]);
				if (oldAasgnWgtRto[i] != null)
					model.setOldAasgnWgtRto(oldAasgnWgtRto[i]);
				if (bkgCtrlTpCd[i] != null)
					model.setBkgCtrlTpCd(bkgCtrlTpCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (aplyToYrwk[i] != null)
					model.setAplyToYrwk(aplyToYrwk[i]);
				if (custCntNm[i] != null)
					model.setCustCntNm(custCntNm[i]);
				if (tsPolNodCd[i] != null)
					model.setTsPolNodCd(tsPolNodCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgAlocSeq[i] != null)
					model.setBkgAlocSeq(bkgAlocSeq[i]);
				if (bkgPorSccCd[i] != null)
					model.setBkgPorSccCd(bkgPorSccCd[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (usaBkgModCd[i] != null)
					model.setUsaBkgModCd(usaBkgModCd[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (bkgAlocRmk[i] != null)
					model.setBkgAlocRmk(bkgAlocRmk[i]);
				if (n2ndTsPolCd[i] != null)
					model.setN2ndTsPolCd(n2ndTsPolCd[i]);
				if (valValue[i] != null)
					model.setValValue(valValue[i]);
				if (n2ndTsPodCd[i] != null)
					model.setN2ndTsPodCd(n2ndTsPodCd[i]);
				if (trunkPolCd[i] != null)
					model.setTrunkPolCd(trunkPolCd[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (n1stTsPolCd[i] != null)
					model.setN1stTsPolCd(n1stTsPolCd[i]);
				if (alocAplyToDt[i] != null)
					model.setAlocAplyToDt(alocAplyToDt[i]);
				if (trunkPodCd[i] != null)
					model.setTrunkPodCd(trunkPodCd[i]);
				if (oldAlocLodQtyRto[i] != null)
					model.setOldAlocLodQtyRto(oldAlocLodQtyRto[i]);
				if (n1stTsPodCd[i] != null)
					model.setN1stTsPodCd(n1stTsPodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpcAlocMgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpcAlocMgmtVO[]
	 */
	public SpcAlocMgmtVO[] getSpcAlocMgmtVOs(){
		SpcAlocMgmtVO[] vos = (SpcAlocMgmtVO[])models.toArray(new SpcAlocMgmtVO[models.size()]);
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
		this.aplyFmYrwk = this.aplyFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtActCntCd = this.agmtActCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCntCd = this.bkgPorCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabRhqCd = this.tabRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnTtlWgt = this.asgnTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrade = this.subtrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsDirCd = this.n1stTsDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAlocLodQty = this.oldAlocLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNm = this.scNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCntNm = this.ctrtCustCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocTpCd = this.bkgAlocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQtyRto = this.alocLodQtyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocAplyFmDt = this.alocAplyFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCntCd = this.bkgDelCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldOpCntrQty = this.oldOpCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPodCntCd = this.n1stTsPodCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valValue2 = this.valValue2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbAmt = this.cmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldOpCntrQtyRto = this.oldOpCntrQtyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQtyRto = this.opCntrQtyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCnt = this.laneCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgRd = this.dgRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNm = this.rfaNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbPerWgt = this.cmpbPerWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCnt = this.dirCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCntCd = this.bkgPodCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valType = this.valType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPolCntCd = this.n1stTsPolCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsNodCd = this.tsNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnWgtRto = this.asgnWgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCnt = this.cmdtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftChgAmt = this.oftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sinwaSeq = this.sinwaSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsSlanCd = this.n2ndTsSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTy = this.ofcTy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shaasSeq = this.shaasSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCmpbAmt = this.oldCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkDirCd = this.trnkDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valCnt = this.valCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtDesc = this.scgGrpCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAsgnTtlWgt = this.oldAsgnTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaCtrtTpCd = this.rfaCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOp = this.chkOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSig = this.vvdSig .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPodNodCd = this.tsPodNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtPerTeu = this.wgtPerTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQty = this.alocLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCntCd = this.bkgPolCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocUseFlg = this.alocUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocSvcCd = this.alocSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSlanCd = this.trnkSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelSccCd = this.bkgDelSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldOftChgAmt = this.oldOftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrNm = this.crrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtSeq = this.scgGrpCmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsSlanCd = this.n1stTsSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbOnyFlg = this.cmpbOnyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctTp = this.acctTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAasgnWgtRto = this.oldAasgnWgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlTpCd = this.bkgCtrlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyToYrwk = this.aplyToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntNm = this.custCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPolNodCd = this.tsPolNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocSeq = this.bkgAlocSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorSccCd = this.bkgPorSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaBkgModCd = this.usaBkgModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocRmk = this.bkgAlocRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsPolCd = this.n2ndTsPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valValue = this.valValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsPodCd = this.n2ndTsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPolCd = this.trunkPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPolCd = this.n1stTsPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocAplyToDt = this.alocAplyToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPodCd = this.trunkPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAlocLodQtyRto = this.oldAlocLodQtyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPodCd = this.n1stTsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
