/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgInfoListVO.java
*@FileTitle : BkgInfoListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.23
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2015.10.23 최성민 
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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgInfoListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgInfoListVO> models = new ArrayList<BkgInfoListVO>();
	
	/* Column Info */
	private String aplyFmYrwk = null;
	/* Column Info */
	private String agmtActCntCd = null;
	/* Column Info */
	private String asgnWgtRtoYn = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String alocRtoYn = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String agmtActCustCode = null;
	/* Column Info */
	private String bkgPorCntCd = null;
	/* Column Info */
	private String bkgPorSccYn = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String asgnTtlWgt = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String n1stTsDirCd = null;
	/* Column Info */
	private String polYn = null;
	/* Column Info */
	private String shprCustCntCd = null;
	/* Column Info */
	private String trnkPolYn = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String bkgAlocTpCd = null;
	/* Column Info */
	private String alocLodQtyRto = null;
	/* Column Info */
	private String alocLodYn = null;
	/* Column Info */
	private String agmtYn = null;
	/* Column Info */
	private String bkgDelCntCd = null;
	/* Column Info */
	private String n1stTsPodCntCd = null;
	/* Column Info */
	private String cmpbAmt = null;
	/* Column Info */
	private String porNm = null;
	/* Column Info */
	private String hngrFlg = null;
	/* Column Info */
	private String shprCustCode = null;
	/* Column Info */
	private String ctrtCustLglEngNm = null;
	/* Column Info */
	private String delYn = null;
	/* Column Info */
	private String cmdtYn = null;
	/* Column Info */
	private String cmpbYn = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String fHeadernm = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String trnkDirYn = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bkgPodCntCd = null;
	/* Column Info */
	private String n1stTsPolYn = null;
	/* Column Info */
	private String shprCustLglEngNm = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String cneeCustCntCd = null;
	/* Column Info */
	private String bkgPolCntYn = null;
	/* Column Info */
	private String n1stTsPolCntCd = null;
	/* Column Info */
	private String n1stTsPodYn = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String tsNodCd = null;
	/* Column Info */
	private String bkgPorCntYn = null;
	/* Column Info */
	private String asgnWgtRto = null;
	/* Column Info */
	private String rptFomNm = null;
	/* Column Info */
	private String scgGrpCmdtYn = null;
	/* Column Info */
	private String oftChgAmt = null;
	/* Column Info */
	private String pgm = null;
	/* Column Info */
	private String trnkPodYn = null;
	/* Column Info */
	private String fwdrCustCntCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String usYn = null;
	/* Column Info */
	private String trnkDirCd = null;
	/* Column Info */
	private String vvdYn = null;
	/* Column Info */
	private String ctrtYn = null;
	/* Column Info */
	private String dgFlg = null;
	/* Column Info */
	private String scgGrpCmdtDesc = null;
	/* Column Info */
	private String delNodYn = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String dgRdYn = null;
	/* Column Info */
	private String asgnTtlWgtYn = null;
	/* Column Info */
	private String ctrtCustCode = null;
	/* Column Info */
	private String tsPodNodCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String podNodYn = null;
	/* Column Info */
	private String obSlsOfcYn = null;
	/* Column Info */
	private String subTrdYn = null;
	/* Column Info */
	private String tsPolNodYn = null;
	/* Column Info */
	private String alocLodQty = null;
	/* Column Info */
	private String bkgPolCntCd = null;
	/* Column Info */
	private String alocUseFlg = null;
	/* Column Info */
	private String orgDestTrnsModCd = null;
	/* Column Info */
	private String porYn = null;
	/* Column Info */
	private String delNm = null;
	/* Column Info */
	private String alocSvcCd = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String n1stTsPodCntYn = null;
	/* Column Info */
	private String trnkSlanCd = null;
	/* Column Info */
	private String bkgDelSccCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String shprYn = null;
	/* Column Info */
	private String stwgFlg = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String n1stTsDirYn = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String scYn = null;
	/* Column Info */
	private String scgGrpCmdtSeq = null;
	/* Column Info */
	private String n1stTsSlanYn = null;
	/* Column Info */
	private String polNm = null;
	/* Column Info */
	private String ctrtCustSeq = null;
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String rdFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fHeader = null;
	/* Column Info */
	private String n1stTsSlanCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String tsPodNodYn = null;
	/* Column Info */
	private String polNodYn = null;
	/* Column Info */
	private String bkgCtrlTpCd = null;
	/* Column Info */
	private String shprCustSeq = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String rfaYn = null;
	/* Column Info */
	private String aplyToYrwk = null;
	/* Column Info */
	private String obSlsOfcNm = null;
	/* Column Info */
	private String tsPolNodCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgAlocSeq = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String agmtActCustSeq = null;
	/* Column Info */
	private String bkgPorSccCd = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String bkgDelSccYn = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String usaBkgModCd = null;
	/* Column Info */
	private String bkgAlocRmk = null;
	/* Column Info */
	private String trnkSlanYn = null;
	/* Column Info */
	private String agmtCustLglEngNm = null;
	/* Column Info */
	private String bkgDelCntYn = null;
	/* Column Info */
	private String oftChgYn = null;
	/* Column Info */
	private String n1stTsPolCntYn = null;
	/* Column Info */
	private String trunkPolCd = null;
	/* Column Info */
	private String cntrTpszYn = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String bkgPodCntYn = null;
	/* Column Info */
	private String n1stTsPolCd = null;
	/* Column Info */
	private String tsNodYn = null;
	/* Column Info */
	private String porNodYn = null;
	/* Column Info */
	private String trunkPodCd = null;
	/* Column Info */
	private String n1stTsPodCd = null;
	/* Column Info */
	private String podCdYn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgInfoListVO() {}

	public BkgInfoListVO(String ibflag, String pagerows, String agmtActCntCd, String agmtActCustCode, String agmtActCustSeq, String agmtCustLglEngNm, String agmtYn, String alocLodQty, String alocLodQtyRto, String alocLodYn, String alocRtoYn, String alocSvcCd, String alocUseFlg, String aplyFmYrwk, String aplyToYrwk, String asgnTtlWgt, String asgnTtlWgtYn, String asgnWgtRto, String asgnWgtRtoYn, String awkCgoFlg, String bkgAlocRmk, String bkgAlocSeq, String bkgAlocTpCd, String bkgCtrlTpCd, String bkgDelCntCd, String bkgDelCntYn, String bkgDelSccCd, String bkgDelSccYn, String bkgNo, String bkgPodCntCd, String bkgPodCntYn, String bkgPolCntCd, String bkgPolCntYn, String bkgPorCntCd, String bkgPorCntYn, String bkgPorSccCd, String bkgPorSccYn, String bkgTeuQty, String blNo, String cmdtCd, String cmdtNm, String cmdtYn, String cmpbAmt, String cmpbYn, String cneeCustCntCd, String cntrTpszCd, String cntrTpszYn, String ctrtCustCntCd, String ctrtCustCode, String ctrtCustLglEngNm, String ctrtCustSeq, String ctrtOfcCd, String ctrtYn, String delCd, String delNm, String delNodCd, String delNodYn, String delYn, String dgFlg, String dgRdYn, String fHeader, String fHeadernm, String fwdrCustCntCd, String hngrFlg, String n1stTsDirCd, String n1stTsDirYn, String n1stTsPodCd, String n1stTsPodCntCd, String n1stTsPodCntYn, String n1stTsPodYn, String n1stTsPolCd, String n1stTsPolCntCd, String n1stTsPolCntYn, String n1stTsPolYn, String n1stTsSlanCd, String n1stTsSlanYn, String obSlsOfcCd, String obSlsOfcNm, String obSlsOfcYn, String oftChgAmt, String oftChgYn, String opCntrQty, String orgDestTrnsModCd, String pgm, String podCd, String podCdYn, String podNm, String podNodCd, String podNodYn, String polCd, String polNm, String polNodCd, String polNodYn, String polYn, String porCd, String porNm, String porNodCd, String porNodYn, String porYn, String rcFlg, String rcvDeTermCd, String rdFlg, String repCmdtCd, String rfaNo, String rfaYn, String rptFomNm, String scNo, String scYn, String scgGrpCmdtDesc, String scgGrpCmdtSeq, String scgGrpCmdtYn, String shprCustCntCd, String shprCustCode, String shprCustLglEngNm, String shprCustSeq, String shprYn, String slsRhqCd, String stwgFlg, String subTrdCd, String subTrdYn, String taaNo, String trnkDirCd, String trnkDirYn, String trnkPodYn, String trnkPolYn, String trnkSlanCd, String trnkSlanYn, String trunkPodCd, String trunkPolCd, String updDt, String updUsrId, String usYn, String usaBkgModCd, String vvd, String vvdYn, String tsNodCd, String tsNodYn, String tsPolNodCd, String tsPolNodYn, String tsPodNodCd, String tsPodNodYn) {
		this.aplyFmYrwk = aplyFmYrwk;
		this.agmtActCntCd = agmtActCntCd;
		this.asgnWgtRtoYn = asgnWgtRtoYn;
		this.rcFlg = rcFlg;
		this.scNo = scNo;
		this.bkgNo = bkgNo;
		this.alocRtoYn = alocRtoYn;
		this.updUsrId = updUsrId;
		this.agmtActCustCode = agmtActCustCode;
		this.bkgPorCntCd = bkgPorCntCd;
		this.bkgPorSccYn = bkgPorSccYn;
		this.opCntrQty = opCntrQty;
		this.asgnTtlWgt = asgnTtlWgt;
		this.polNodCd = polNodCd;
		this.n1stTsDirCd = n1stTsDirCd;
		this.polYn = polYn;
		this.shprCustCntCd = shprCustCntCd;
		this.trnkPolYn = trnkPolYn;
		this.awkCgoFlg = awkCgoFlg;
		this.bkgAlocTpCd = bkgAlocTpCd;
		this.alocLodQtyRto = alocLodQtyRto;
		this.alocLodYn = alocLodYn;
		this.agmtYn = agmtYn;
		this.bkgDelCntCd = bkgDelCntCd;
		this.n1stTsPodCntCd = n1stTsPodCntCd;
		this.cmpbAmt = cmpbAmt;
		this.porNm = porNm;
		this.hngrFlg = hngrFlg;
		this.shprCustCode = shprCustCode;
		this.ctrtCustLglEngNm = ctrtCustLglEngNm;
		this.delYn = delYn;
		this.cmdtYn = cmdtYn;
		this.cmpbYn = cmpbYn;
		this.obSlsOfcCd = obSlsOfcCd;
		this.fHeadernm = fHeadernm;
		this.subTrdCd = subTrdCd;
		this.rfaNo = rfaNo;
		this.cntrTpszCd = cntrTpszCd;
		this.trnkDirYn = trnkDirYn;
		this.updDt = updDt;
		this.bkgPodCntCd = bkgPodCntCd;
		this.n1stTsPolYn = n1stTsPolYn;
		this.shprCustLglEngNm = shprCustLglEngNm;
		this.podNodCd = podNodCd;
		this.cneeCustCntCd = cneeCustCntCd;
		this.bkgPolCntYn = bkgPolCntYn;
		this.n1stTsPolCntCd = n1stTsPolCntCd;
		this.n1stTsPodYn = n1stTsPodYn;
		this.porCd = porCd;
		this.tsNodCd = tsNodCd;
		this.bkgPorCntYn = bkgPorCntYn;
		this.asgnWgtRto = asgnWgtRto;
		this.rptFomNm = rptFomNm;
		this.scgGrpCmdtYn = scgGrpCmdtYn;
		this.oftChgAmt = oftChgAmt;
		this.pgm = pgm;
		this.trnkPodYn = trnkPodYn;
		this.fwdrCustCntCd = fwdrCustCntCd;
		this.cmdtCd = cmdtCd;
		this.usYn = usYn;
		this.trnkDirCd = trnkDirCd;
		this.vvdYn = vvdYn;
		this.ctrtYn = ctrtYn;
		this.dgFlg = dgFlg;
		this.scgGrpCmdtDesc = scgGrpCmdtDesc;
		this.delNodYn = delNodYn;
		this.delCd = delCd;
		this.dgRdYn = dgRdYn;
		this.asgnTtlWgtYn = asgnTtlWgtYn;
		this.ctrtCustCode = ctrtCustCode;
		this.tsPodNodCd = tsPodNodCd;
		this.blNo = blNo;
		this.podNodYn = podNodYn;
		this.obSlsOfcYn = obSlsOfcYn;
		this.subTrdYn = subTrdYn;
		this.tsPolNodYn = tsPolNodYn;
		this.alocLodQty = alocLodQty;
		this.bkgPolCntCd = bkgPolCntCd;
		this.alocUseFlg = alocUseFlg;
		this.orgDestTrnsModCd = orgDestTrnsModCd;
		this.porYn = porYn;
		this.delNm = delNm;
		this.alocSvcCd = alocSvcCd;
		this.slsRhqCd = slsRhqCd;
		this.n1stTsPodCntYn = n1stTsPodCntYn;
		this.trnkSlanCd = trnkSlanCd;
		this.bkgDelSccCd = bkgDelSccCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.shprYn = shprYn;
		this.stwgFlg = stwgFlg;
		this.delNodCd = delNodCd;
		this.n1stTsDirYn = n1stTsDirYn;
		this.porNodCd = porNodCd;
		this.scYn = scYn;
		this.scgGrpCmdtSeq = scgGrpCmdtSeq;
		this.n1stTsSlanYn = n1stTsSlanYn;
		this.polNm = polNm;
		this.ctrtCustSeq = ctrtCustSeq;
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.podNm = podNm;
		this.rdFlg = rdFlg;
		this.ibflag = ibflag;
		this.fHeader = fHeader;
		this.n1stTsSlanCd = n1stTsSlanCd;
		this.cmdtNm = cmdtNm;
		this.tsPodNodYn = tsPodNodYn;
		this.polNodYn = polNodYn;
		this.bkgCtrlTpCd = bkgCtrlTpCd;
		this.shprCustSeq = shprCustSeq;
		this.polCd = polCd;
		this.rfaYn = rfaYn;
		this.aplyToYrwk = aplyToYrwk;
		this.obSlsOfcNm = obSlsOfcNm;
		this.tsPolNodCd = tsPolNodCd;
		this.podCd = podCd;
		this.bkgAlocSeq = bkgAlocSeq;
		this.rcvDeTermCd = rcvDeTermCd;
		this.agmtActCustSeq = agmtActCustSeq;
		this.bkgPorSccCd = bkgPorSccCd;
		this.bkgTeuQty = bkgTeuQty;
		this.bkgDelSccYn = bkgDelSccYn;
		this.taaNo = taaNo;
		this.usaBkgModCd = usaBkgModCd;
		this.bkgAlocRmk = bkgAlocRmk;
		this.trnkSlanYn = trnkSlanYn;
		this.agmtCustLglEngNm = agmtCustLglEngNm;
		this.bkgDelCntYn = bkgDelCntYn;
		this.oftChgYn = oftChgYn;
		this.n1stTsPolCntYn = n1stTsPolCntYn;
		this.trunkPolCd = trunkPolCd;
		this.cntrTpszYn = cntrTpszYn;
		this.repCmdtCd = repCmdtCd;
		this.bkgPodCntYn = bkgPodCntYn;
		this.n1stTsPolCd = n1stTsPolCd;
		this.tsNodYn = tsNodYn;
		this.porNodYn = porNodYn;
		this.trunkPodCd = trunkPodCd;
		this.n1stTsPodCd = n1stTsPodCd;
		this.podCdYn = podCdYn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aply_fm_yrwk", getAplyFmYrwk());
		this.hashColumns.put("agmt_act_cnt_cd", getAgmtActCntCd());
		this.hashColumns.put("asgn_wgt_rto_yn", getAsgnWgtRtoYn());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("aloc_rto_yn", getAlocRtoYn());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("agmt_act_cust_code", getAgmtActCustCode());
		this.hashColumns.put("bkg_por_cnt_cd", getBkgPorCntCd());
		this.hashColumns.put("bkg_por_scc_yn", getBkgPorSccYn());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("asgn_ttl_wgt", getAsgnTtlWgt());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("n1st_ts_dir_cd", getN1stTsDirCd());
		this.hashColumns.put("pol_yn", getPolYn());
		this.hashColumns.put("shpr_cust_cnt_cd", getShprCustCntCd());
		this.hashColumns.put("trnk_pol_yn", getTrnkPolYn());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("bkg_aloc_tp_cd", getBkgAlocTpCd());
		this.hashColumns.put("aloc_lod_qty_rto", getAlocLodQtyRto());
		this.hashColumns.put("aloc_lod_yn", getAlocLodYn());
		this.hashColumns.put("agmt_yn", getAgmtYn());
		this.hashColumns.put("bkg_del_cnt_cd", getBkgDelCntCd());
		this.hashColumns.put("n1st_ts_pod_cnt_cd", getN1stTsPodCntCd());
		this.hashColumns.put("cmpb_amt", getCmpbAmt());
		this.hashColumns.put("por_nm", getPorNm());
		this.hashColumns.put("hngr_flg", getHngrFlg());
		this.hashColumns.put("shpr_cust_code", getShprCustCode());
		this.hashColumns.put("ctrt_cust_lgl_eng_nm", getCtrtCustLglEngNm());
		this.hashColumns.put("del_yn", getDelYn());
		this.hashColumns.put("cmdt_yn", getCmdtYn());
		this.hashColumns.put("cmpb_yn", getCmpbYn());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("f_headernm", getFHeadernm());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("trnk_dir_yn", getTrnkDirYn());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bkg_pod_cnt_cd", getBkgPodCntCd());
		this.hashColumns.put("n1st_ts_pol_yn", getN1stTsPolYn());
		this.hashColumns.put("shpr_cust_lgl_eng_nm", getShprCustLglEngNm());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("cnee_cust_cnt_cd", getCneeCustCntCd());
		this.hashColumns.put("bkg_pol_cnt_yn", getBkgPolCntYn());
		this.hashColumns.put("n1st_ts_pol_cnt_cd", getN1stTsPolCntCd());
		this.hashColumns.put("n1st_ts_pod_yn", getN1stTsPodYn());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("ts_nod_cd", getTsNodCd());
		this.hashColumns.put("bkg_por_cnt_yn", getBkgPorCntYn());
		this.hashColumns.put("asgn_wgt_rto", getAsgnWgtRto());
		this.hashColumns.put("rpt_fom_nm", getRptFomNm());
		this.hashColumns.put("scg_grp_cmdt_yn", getScgGrpCmdtYn());
		this.hashColumns.put("oft_chg_amt", getOftChgAmt());
		this.hashColumns.put("pgm", getPgm());
		this.hashColumns.put("trnk_pod_yn", getTrnkPodYn());
		this.hashColumns.put("fwdr_cust_cnt_cd", getFwdrCustCntCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("us_yn", getUsYn());
		this.hashColumns.put("trnk_dir_cd", getTrnkDirCd());
		this.hashColumns.put("vvd_yn", getVvdYn());
		this.hashColumns.put("ctrt_yn", getCtrtYn());
		this.hashColumns.put("dg_flg", getDgFlg());
		this.hashColumns.put("scg_grp_cmdt_desc", getScgGrpCmdtDesc());
		this.hashColumns.put("del_nod_yn", getDelNodYn());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("dg_rd_yn", getDgRdYn());
		this.hashColumns.put("asgn_ttl_wgt_yn", getAsgnTtlWgtYn());
		this.hashColumns.put("ctrt_cust_code", getCtrtCustCode());
		this.hashColumns.put("ts_pod_nod_cd", getTsPodNodCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pod_nod_yn", getPodNodYn());
		this.hashColumns.put("ob_sls_ofc_yn", getObSlsOfcYn());
		this.hashColumns.put("sub_trd_yn", getSubTrdYn());
		this.hashColumns.put("ts_pol_nod_yn", getTsPolNodYn());
		this.hashColumns.put("aloc_lod_qty", getAlocLodQty());
		this.hashColumns.put("bkg_pol_cnt_cd", getBkgPolCntCd());
		this.hashColumns.put("aloc_use_flg", getAlocUseFlg());
		this.hashColumns.put("org_dest_trns_mod_cd", getOrgDestTrnsModCd());
		this.hashColumns.put("por_yn", getPorYn());
		this.hashColumns.put("del_nm", getDelNm());
		this.hashColumns.put("aloc_svc_cd", getAlocSvcCd());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("n1st_ts_pod_cnt_yn", getN1stTsPodCntYn());
		this.hashColumns.put("trnk_slan_cd", getTrnkSlanCd());
		this.hashColumns.put("bkg_del_scc_cd", getBkgDelSccCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("shpr_yn", getShprYn());
		this.hashColumns.put("stwg_flg", getStwgFlg());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("n1st_ts_dir_yn", getN1stTsDirYn());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("sc_yn", getScYn());
		this.hashColumns.put("scg_grp_cmdt_seq", getScgGrpCmdtSeq());
		this.hashColumns.put("n1st_ts_slan_yn", getN1stTsSlanYn());
		this.hashColumns.put("pol_nm", getPolNm());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("rd_flg", getRdFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_header", getFHeader());
		this.hashColumns.put("n1st_ts_slan_cd", getN1stTsSlanCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("ts_pod_nod_yn", getTsPodNodYn());
		this.hashColumns.put("pol_nod_yn", getPolNodYn());
		this.hashColumns.put("bkg_ctrl_tp_cd", getBkgCtrlTpCd());
		this.hashColumns.put("shpr_cust_seq", getShprCustSeq());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("rfa_yn", getRfaYn());
		this.hashColumns.put("aply_to_yrwk", getAplyToYrwk());
		this.hashColumns.put("ob_sls_ofc_nm", getObSlsOfcNm());
		this.hashColumns.put("ts_pol_nod_cd", getTsPolNodCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_aloc_seq", getBkgAlocSeq());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("agmt_act_cust_seq", getAgmtActCustSeq());
		this.hashColumns.put("bkg_por_scc_cd", getBkgPorSccCd());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("bkg_del_scc_yn", getBkgDelSccYn());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("usa_bkg_mod_cd", getUsaBkgModCd());
		this.hashColumns.put("bkg_aloc_rmk", getBkgAlocRmk());
		this.hashColumns.put("trnk_slan_yn", getTrnkSlanYn());
		this.hashColumns.put("agmt_cust_lgl_eng_nm", getAgmtCustLglEngNm());
		this.hashColumns.put("bkg_del_cnt_yn", getBkgDelCntYn());
		this.hashColumns.put("oft_chg_yn", getOftChgYn());
		this.hashColumns.put("n1st_ts_pol_cnt_yn", getN1stTsPolCntYn());
		this.hashColumns.put("trunk_pol_cd", getTrunkPolCd());
		this.hashColumns.put("cntr_tpsz_yn", getCntrTpszYn());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("bkg_pod_cnt_yn", getBkgPodCntYn());
		this.hashColumns.put("n1st_ts_pol_cd", getN1stTsPolCd());
		this.hashColumns.put("ts_nod_yn", getTsNodYn());
		this.hashColumns.put("por_nod_yn", getPorNodYn());
		this.hashColumns.put("trunk_pod_cd", getTrunkPodCd());
		this.hashColumns.put("n1st_ts_pod_cd", getN1stTsPodCd());
		this.hashColumns.put("pod_cd_yn", getPodCdYn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("aply_fm_yrwk", "aplyFmYrwk");
		this.hashFields.put("agmt_act_cnt_cd", "agmtActCntCd");
		this.hashFields.put("asgn_wgt_rto_yn", "asgnWgtRtoYn");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("aloc_rto_yn", "alocRtoYn");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("agmt_act_cust_code", "agmtActCustCode");
		this.hashFields.put("bkg_por_cnt_cd", "bkgPorCntCd");
		this.hashFields.put("bkg_por_scc_yn", "bkgPorSccYn");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("asgn_ttl_wgt", "asgnTtlWgt");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("n1st_ts_dir_cd", "n1stTsDirCd");
		this.hashFields.put("pol_yn", "polYn");
		this.hashFields.put("shpr_cust_cnt_cd", "shprCustCntCd");
		this.hashFields.put("trnk_pol_yn", "trnkPolYn");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("bkg_aloc_tp_cd", "bkgAlocTpCd");
		this.hashFields.put("aloc_lod_qty_rto", "alocLodQtyRto");
		this.hashFields.put("aloc_lod_yn", "alocLodYn");
		this.hashFields.put("agmt_yn", "agmtYn");
		this.hashFields.put("bkg_del_cnt_cd", "bkgDelCntCd");
		this.hashFields.put("n1st_ts_pod_cnt_cd", "n1stTsPodCntCd");
		this.hashFields.put("cmpb_amt", "cmpbAmt");
		this.hashFields.put("por_nm", "porNm");
		this.hashFields.put("hngr_flg", "hngrFlg");
		this.hashFields.put("shpr_cust_code", "shprCustCode");
		this.hashFields.put("ctrt_cust_lgl_eng_nm", "ctrtCustLglEngNm");
		this.hashFields.put("del_yn", "delYn");
		this.hashFields.put("cmdt_yn", "cmdtYn");
		this.hashFields.put("cmpb_yn", "cmpbYn");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("f_headernm", "fHeadernm");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("trnk_dir_yn", "trnkDirYn");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bkg_pod_cnt_cd", "bkgPodCntCd");
		this.hashFields.put("n1st_ts_pol_yn", "n1stTsPolYn");
		this.hashFields.put("shpr_cust_lgl_eng_nm", "shprCustLglEngNm");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("cnee_cust_cnt_cd", "cneeCustCntCd");
		this.hashFields.put("bkg_pol_cnt_yn", "bkgPolCntYn");
		this.hashFields.put("n1st_ts_pol_cnt_cd", "n1stTsPolCntCd");
		this.hashFields.put("n1st_ts_pod_yn", "n1stTsPodYn");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("ts_nod_cd", "tsNodCd");
		this.hashFields.put("bkg_por_cnt_yn", "bkgPorCntYn");
		this.hashFields.put("asgn_wgt_rto", "asgnWgtRto");
		this.hashFields.put("rpt_fom_nm", "rptFomNm");
		this.hashFields.put("scg_grp_cmdt_yn", "scgGrpCmdtYn");
		this.hashFields.put("oft_chg_amt", "oftChgAmt");
		this.hashFields.put("pgm", "pgm");
		this.hashFields.put("trnk_pod_yn", "trnkPodYn");
		this.hashFields.put("fwdr_cust_cnt_cd", "fwdrCustCntCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("us_yn", "usYn");
		this.hashFields.put("trnk_dir_cd", "trnkDirCd");
		this.hashFields.put("vvd_yn", "vvdYn");
		this.hashFields.put("ctrt_yn", "ctrtYn");
		this.hashFields.put("dg_flg", "dgFlg");
		this.hashFields.put("scg_grp_cmdt_desc", "scgGrpCmdtDesc");
		this.hashFields.put("del_nod_yn", "delNodYn");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("dg_rd_yn", "dgRdYn");
		this.hashFields.put("asgn_ttl_wgt_yn", "asgnTtlWgtYn");
		this.hashFields.put("ctrt_cust_code", "ctrtCustCode");
		this.hashFields.put("ts_pod_nod_cd", "tsPodNodCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pod_nod_yn", "podNodYn");
		this.hashFields.put("ob_sls_ofc_yn", "obSlsOfcYn");
		this.hashFields.put("sub_trd_yn", "subTrdYn");
		this.hashFields.put("ts_pol_nod_yn", "tsPolNodYn");
		this.hashFields.put("aloc_lod_qty", "alocLodQty");
		this.hashFields.put("bkg_pol_cnt_cd", "bkgPolCntCd");
		this.hashFields.put("aloc_use_flg", "alocUseFlg");
		this.hashFields.put("org_dest_trns_mod_cd", "orgDestTrnsModCd");
		this.hashFields.put("por_yn", "porYn");
		this.hashFields.put("del_nm", "delNm");
		this.hashFields.put("aloc_svc_cd", "alocSvcCd");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("n1st_ts_pod_cnt_yn", "n1stTsPodCntYn");
		this.hashFields.put("trnk_slan_cd", "trnkSlanCd");
		this.hashFields.put("bkg_del_scc_cd", "bkgDelSccCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("shpr_yn", "shprYn");
		this.hashFields.put("stwg_flg", "stwgFlg");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("n1st_ts_dir_yn", "n1stTsDirYn");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("sc_yn", "scYn");
		this.hashFields.put("scg_grp_cmdt_seq", "scgGrpCmdtSeq");
		this.hashFields.put("n1st_ts_slan_yn", "n1stTsSlanYn");
		this.hashFields.put("pol_nm", "polNm");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("rd_flg", "rdFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_header", "fHeader");
		this.hashFields.put("n1st_ts_slan_cd", "n1stTsSlanCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("ts_pod_nod_yn", "tsPodNodYn");
		this.hashFields.put("pol_nod_yn", "polNodYn");
		this.hashFields.put("bkg_ctrl_tp_cd", "bkgCtrlTpCd");
		this.hashFields.put("shpr_cust_seq", "shprCustSeq");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rfa_yn", "rfaYn");
		this.hashFields.put("aply_to_yrwk", "aplyToYrwk");
		this.hashFields.put("ob_sls_ofc_nm", "obSlsOfcNm");
		this.hashFields.put("ts_pol_nod_cd", "tsPolNodCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_aloc_seq", "bkgAlocSeq");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("agmt_act_cust_seq", "agmtActCustSeq");
		this.hashFields.put("bkg_por_scc_cd", "bkgPorSccCd");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("bkg_del_scc_yn", "bkgDelSccYn");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("usa_bkg_mod_cd", "usaBkgModCd");
		this.hashFields.put("bkg_aloc_rmk", "bkgAlocRmk");
		this.hashFields.put("trnk_slan_yn", "trnkSlanYn");
		this.hashFields.put("agmt_cust_lgl_eng_nm", "agmtCustLglEngNm");
		this.hashFields.put("bkg_del_cnt_yn", "bkgDelCntYn");
		this.hashFields.put("oft_chg_yn", "oftChgYn");
		this.hashFields.put("n1st_ts_pol_cnt_yn", "n1stTsPolCntYn");
		this.hashFields.put("trunk_pol_cd", "trunkPolCd");
		this.hashFields.put("cntr_tpsz_yn", "cntrTpszYn");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("bkg_pod_cnt_yn", "bkgPodCntYn");
		this.hashFields.put("n1st_ts_pol_cd", "n1stTsPolCd");
		this.hashFields.put("ts_nod_yn", "tsNodYn");
		this.hashFields.put("por_nod_yn", "porNodYn");
		this.hashFields.put("trunk_pod_cd", "trunkPodCd");
		this.hashFields.put("n1st_ts_pod_cd", "n1stTsPodCd");
		this.hashFields.put("pod_cd_yn", "podCdYn");
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
	 * @return asgnWgtRtoYn
	 */
	public String getAsgnWgtRtoYn() {
		return this.asgnWgtRtoYn;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return alocRtoYn
	 */
	public String getAlocRtoYn() {
		return this.alocRtoYn;
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
	 * @return agmtActCustCode
	 */
	public String getAgmtActCustCode() {
		return this.agmtActCustCode;
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
	 * @return bkgPorSccYn
	 */
	public String getBkgPorSccYn() {
		return this.bkgPorSccYn;
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
	 * @return n1stTsDirCd
	 */
	public String getN1stTsDirCd() {
		return this.n1stTsDirCd;
	}
	
	/**
	 * Column Info
	 * @return polYn
	 */
	public String getPolYn() {
		return this.polYn;
	}
	
	/**
	 * Column Info
	 * @return shprCustCntCd
	 */
	public String getShprCustCntCd() {
		return this.shprCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return trnkPolYn
	 */
	public String getTrnkPolYn() {
		return this.trnkPolYn;
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
	 * @return alocLodYn
	 */
	public String getAlocLodYn() {
		return this.alocLodYn;
	}
	
	/**
	 * Column Info
	 * @return agmtYn
	 */
	public String getAgmtYn() {
		return this.agmtYn;
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
	 * @return n1stTsPodCntCd
	 */
	public String getN1stTsPodCntCd() {
		return this.n1stTsPodCntCd;
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
	 * @return porNm
	 */
	public String getPorNm() {
		return this.porNm;
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
	 * @return shprCustCode
	 */
	public String getShprCustCode() {
		return this.shprCustCode;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustLglEngNm
	 */
	public String getCtrtCustLglEngNm() {
		return this.ctrtCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return delYn
	 */
	public String getDelYn() {
		return this.delYn;
	}
	
	/**
	 * Column Info
	 * @return cmdtYn
	 */
	public String getCmdtYn() {
		return this.cmdtYn;
	}
	
	/**
	 * Column Info
	 * @return cmpbYn
	 */
	public String getCmpbYn() {
		return this.cmpbYn;
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
	 * @return fHeadernm
	 */
	public String getFHeadernm() {
		return this.fHeadernm;
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
	 * @return trnkDirYn
	 */
	public String getTrnkDirYn() {
		return this.trnkDirYn;
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
	 * @return bkgPodCntCd
	 */
	public String getBkgPodCntCd() {
		return this.bkgPodCntCd;
	}
	
	/**
	 * Column Info
	 * @return n1stTsPolYn
	 */
	public String getN1stTsPolYn() {
		return this.n1stTsPolYn;
	}
	
	/**
	 * Column Info
	 * @return shprCustLglEngNm
	 */
	public String getShprCustLglEngNm() {
		return this.shprCustLglEngNm;
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
	 * @return cneeCustCntCd
	 */
	public String getCneeCustCntCd() {
		return this.cneeCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPolCntYn
	 */
	public String getBkgPolCntYn() {
		return this.bkgPolCntYn;
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
	 * @return n1stTsPodYn
	 */
	public String getN1stTsPodYn() {
		return this.n1stTsPodYn;
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
	 * @return bkgPorCntYn
	 */
	public String getBkgPorCntYn() {
		return this.bkgPorCntYn;
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
	 * @return rptFomNm
	 */
	public String getRptFomNm() {
		return this.rptFomNm;
	}
	
	/**
	 * Column Info
	 * @return scgGrpCmdtYn
	 */
	public String getScgGrpCmdtYn() {
		return this.scgGrpCmdtYn;
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
	 * @return pgm
	 */
	public String getPgm() {
		return this.pgm;
	}
	
	/**
	 * Column Info
	 * @return trnkPodYn
	 */
	public String getTrnkPodYn() {
		return this.trnkPodYn;
	}
	
	/**
	 * Column Info
	 * @return fwdrCustCntCd
	 */
	public String getFwdrCustCntCd() {
		return this.fwdrCustCntCd;
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
	 * @return usYn
	 */
	public String getUsYn() {
		return this.usYn;
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
	 * @return vvdYn
	 */
	public String getVvdYn() {
		return this.vvdYn;
	}
	
	/**
	 * Column Info
	 * @return ctrtYn
	 */
	public String getCtrtYn() {
		return this.ctrtYn;
	}
	
	/**
	 * Column Info
	 * @return dgFlg
	 */
	public String getDgFlg() {
		return this.dgFlg;
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
	 * @return delNodYn
	 */
	public String getDelNodYn() {
		return this.delNodYn;
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
	 * @return dgRdYn
	 */
	public String getDgRdYn() {
		return this.dgRdYn;
	}
	
	/**
	 * Column Info
	 * @return asgnTtlWgtYn
	 */
	public String getAsgnTtlWgtYn() {
		return this.asgnTtlWgtYn;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustCode
	 */
	public String getCtrtCustCode() {
		return this.ctrtCustCode;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return podNodYn
	 */
	public String getPodNodYn() {
		return this.podNodYn;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcYn
	 */
	public String getObSlsOfcYn() {
		return this.obSlsOfcYn;
	}
	
	/**
	 * Column Info
	 * @return subTrdYn
	 */
	public String getSubTrdYn() {
		return this.subTrdYn;
	}
	
	/**
	 * Column Info
	 * @return tsPolNodYn
	 */
	public String getTsPolNodYn() {
		return this.tsPolNodYn;
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
	 * @return orgDestTrnsModCd
	 */
	public String getOrgDestTrnsModCd() {
		return this.orgDestTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @return porYn
	 */
	public String getPorYn() {
		return this.porYn;
	}
	
	/**
	 * Column Info
	 * @return delNm
	 */
	public String getDelNm() {
		return this.delNm;
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
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @return n1stTsPodCntYn
	 */
	public String getN1stTsPodCntYn() {
		return this.n1stTsPodCntYn;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return shprYn
	 */
	public String getShprYn() {
		return this.shprYn;
	}
	
	/**
	 * Column Info
	 * @return stwgFlg
	 */
	public String getStwgFlg() {
		return this.stwgFlg;
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
	 * @return n1stTsDirYn
	 */
	public String getN1stTsDirYn() {
		return this.n1stTsDirYn;
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
	 * @return scYn
	 */
	public String getScYn() {
		return this.scYn;
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
	 * @return n1stTsSlanYn
	 */
	public String getN1stTsSlanYn() {
		return this.n1stTsSlanYn;
	}
	
	/**
	 * Column Info
	 * @return polNm
	 */
	public String getPolNm() {
		return this.polNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSeq
	 */
	public String getCtrtCustSeq() {
		return this.ctrtCustSeq;
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
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return podNm
	 */
	public String getPodNm() {
		return this.podNm;
	}
	
	/**
	 * Column Info
	 * @return rdFlg
	 */
	public String getRdFlg() {
		return this.rdFlg;
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
	 * @return fHeader
	 */
	public String getFHeader() {
		return this.fHeader;
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
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return tsPodNodYn
	 */
	public String getTsPodNodYn() {
		return this.tsPodNodYn;
	}
	
	/**
	 * Column Info
	 * @return polNodYn
	 */
	public String getPolNodYn() {
		return this.polNodYn;
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
	 * @return shprCustSeq
	 */
	public String getShprCustSeq() {
		return this.shprCustSeq;
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
	 * @return rfaYn
	 */
	public String getRfaYn() {
		return this.rfaYn;
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
	 * @return obSlsOfcNm
	 */
	public String getObSlsOfcNm() {
		return this.obSlsOfcNm;
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
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return agmtActCustSeq
	 */
	public String getAgmtActCustSeq() {
		return this.agmtActCustSeq;
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
	 * @return bkgTeuQty
	 */
	public String getBkgTeuQty() {
		return this.bkgTeuQty;
	}
	
	/**
	 * Column Info
	 * @return bkgDelSccYn
	 */
	public String getBkgDelSccYn() {
		return this.bkgDelSccYn;
	}
	
	/**
	 * Column Info
	 * @return taaNo
	 */
	public String getTaaNo() {
		return this.taaNo;
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
	 * @return bkgAlocRmk
	 */
	public String getBkgAlocRmk() {
		return this.bkgAlocRmk;
	}
	
	/**
	 * Column Info
	 * @return trnkSlanYn
	 */
	public String getTrnkSlanYn() {
		return this.trnkSlanYn;
	}
	
	/**
	 * Column Info
	 * @return agmtCustLglEngNm
	 */
	public String getAgmtCustLglEngNm() {
		return this.agmtCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return bkgDelCntYn
	 */
	public String getBkgDelCntYn() {
		return this.bkgDelCntYn;
	}
	
	/**
	 * Column Info
	 * @return oftChgYn
	 */
	public String getOftChgYn() {
		return this.oftChgYn;
	}
	
	/**
	 * Column Info
	 * @return n1stTsPolCntYn
	 */
	public String getN1stTsPolCntYn() {
		return this.n1stTsPolCntYn;
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
	 * @return cntrTpszYn
	 */
	public String getCntrTpszYn() {
		return this.cntrTpszYn;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPodCntYn
	 */
	public String getBkgPodCntYn() {
		return this.bkgPodCntYn;
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
	 * @return tsNodYn
	 */
	public String getTsNodYn() {
		return this.tsNodYn;
	}
	
	/**
	 * Column Info
	 * @return porNodYn
	 */
	public String getPorNodYn() {
		return this.porNodYn;
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
	 * @return n1stTsPodCd
	 */
	public String getN1stTsPodCd() {
		return this.n1stTsPodCd;
	}
	
	/**
	 * Column Info
	 * @return podCdYn
	 */
	public String getPodCdYn() {
		return this.podCdYn;
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
	 * @param asgnWgtRtoYn
	 */
	public void setAsgnWgtRtoYn(String asgnWgtRtoYn) {
		this.asgnWgtRtoYn = asgnWgtRtoYn;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param alocRtoYn
	 */
	public void setAlocRtoYn(String alocRtoYn) {
		this.alocRtoYn = alocRtoYn;
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
	 * @param agmtActCustCode
	 */
	public void setAgmtActCustCode(String agmtActCustCode) {
		this.agmtActCustCode = agmtActCustCode;
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
	 * @param bkgPorSccYn
	 */
	public void setBkgPorSccYn(String bkgPorSccYn) {
		this.bkgPorSccYn = bkgPorSccYn;
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
	 * @param n1stTsDirCd
	 */
	public void setN1stTsDirCd(String n1stTsDirCd) {
		this.n1stTsDirCd = n1stTsDirCd;
	}
	
	/**
	 * Column Info
	 * @param polYn
	 */
	public void setPolYn(String polYn) {
		this.polYn = polYn;
	}
	
	/**
	 * Column Info
	 * @param shprCustCntCd
	 */
	public void setShprCustCntCd(String shprCustCntCd) {
		this.shprCustCntCd = shprCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param trnkPolYn
	 */
	public void setTrnkPolYn(String trnkPolYn) {
		this.trnkPolYn = trnkPolYn;
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
	 * @param alocLodYn
	 */
	public void setAlocLodYn(String alocLodYn) {
		this.alocLodYn = alocLodYn;
	}
	
	/**
	 * Column Info
	 * @param agmtYn
	 */
	public void setAgmtYn(String agmtYn) {
		this.agmtYn = agmtYn;
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
	 * @param n1stTsPodCntCd
	 */
	public void setN1stTsPodCntCd(String n1stTsPodCntCd) {
		this.n1stTsPodCntCd = n1stTsPodCntCd;
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
	 * @param porNm
	 */
	public void setPorNm(String porNm) {
		this.porNm = porNm;
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
	 * @param shprCustCode
	 */
	public void setShprCustCode(String shprCustCode) {
		this.shprCustCode = shprCustCode;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustLglEngNm
	 */
	public void setCtrtCustLglEngNm(String ctrtCustLglEngNm) {
		this.ctrtCustLglEngNm = ctrtCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param delYn
	 */
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	
	/**
	 * Column Info
	 * @param cmdtYn
	 */
	public void setCmdtYn(String cmdtYn) {
		this.cmdtYn = cmdtYn;
	}
	
	/**
	 * Column Info
	 * @param cmpbYn
	 */
	public void setCmpbYn(String cmpbYn) {
		this.cmpbYn = cmpbYn;
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
	 * @param fHeadernm
	 */
	public void setFHeadernm(String fHeadernm) {
		this.fHeadernm = fHeadernm;
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
	 * @param trnkDirYn
	 */
	public void setTrnkDirYn(String trnkDirYn) {
		this.trnkDirYn = trnkDirYn;
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
	 * @param bkgPodCntCd
	 */
	public void setBkgPodCntCd(String bkgPodCntCd) {
		this.bkgPodCntCd = bkgPodCntCd;
	}
	
	/**
	 * Column Info
	 * @param n1stTsPolYn
	 */
	public void setN1stTsPolYn(String n1stTsPolYn) {
		this.n1stTsPolYn = n1stTsPolYn;
	}
	
	/**
	 * Column Info
	 * @param shprCustLglEngNm
	 */
	public void setShprCustLglEngNm(String shprCustLglEngNm) {
		this.shprCustLglEngNm = shprCustLglEngNm;
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
	 * @param cneeCustCntCd
	 */
	public void setCneeCustCntCd(String cneeCustCntCd) {
		this.cneeCustCntCd = cneeCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPolCntYn
	 */
	public void setBkgPolCntYn(String bkgPolCntYn) {
		this.bkgPolCntYn = bkgPolCntYn;
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
	 * @param n1stTsPodYn
	 */
	public void setN1stTsPodYn(String n1stTsPodYn) {
		this.n1stTsPodYn = n1stTsPodYn;
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
	 * @param bkgPorCntYn
	 */
	public void setBkgPorCntYn(String bkgPorCntYn) {
		this.bkgPorCntYn = bkgPorCntYn;
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
	 * @param rptFomNm
	 */
	public void setRptFomNm(String rptFomNm) {
		this.rptFomNm = rptFomNm;
	}
	
	/**
	 * Column Info
	 * @param scgGrpCmdtYn
	 */
	public void setScgGrpCmdtYn(String scgGrpCmdtYn) {
		this.scgGrpCmdtYn = scgGrpCmdtYn;
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
	 * @param pgm
	 */
	public void setPgm(String pgm) {
		this.pgm = pgm;
	}
	
	/**
	 * Column Info
	 * @param trnkPodYn
	 */
	public void setTrnkPodYn(String trnkPodYn) {
		this.trnkPodYn = trnkPodYn;
	}
	
	/**
	 * Column Info
	 * @param fwdrCustCntCd
	 */
	public void setFwdrCustCntCd(String fwdrCustCntCd) {
		this.fwdrCustCntCd = fwdrCustCntCd;
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
	 * @param usYn
	 */
	public void setUsYn(String usYn) {
		this.usYn = usYn;
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
	 * @param vvdYn
	 */
	public void setVvdYn(String vvdYn) {
		this.vvdYn = vvdYn;
	}
	
	/**
	 * Column Info
	 * @param ctrtYn
	 */
	public void setCtrtYn(String ctrtYn) {
		this.ctrtYn = ctrtYn;
	}
	
	/**
	 * Column Info
	 * @param dgFlg
	 */
	public void setDgFlg(String dgFlg) {
		this.dgFlg = dgFlg;
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
	 * @param delNodYn
	 */
	public void setDelNodYn(String delNodYn) {
		this.delNodYn = delNodYn;
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
	 * @param dgRdYn
	 */
	public void setDgRdYn(String dgRdYn) {
		this.dgRdYn = dgRdYn;
	}
	
	/**
	 * Column Info
	 * @param asgnTtlWgtYn
	 */
	public void setAsgnTtlWgtYn(String asgnTtlWgtYn) {
		this.asgnTtlWgtYn = asgnTtlWgtYn;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustCode
	 */
	public void setCtrtCustCode(String ctrtCustCode) {
		this.ctrtCustCode = ctrtCustCode;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param podNodYn
	 */
	public void setPodNodYn(String podNodYn) {
		this.podNodYn = podNodYn;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcYn
	 */
	public void setObSlsOfcYn(String obSlsOfcYn) {
		this.obSlsOfcYn = obSlsOfcYn;
	}
	
	/**
	 * Column Info
	 * @param subTrdYn
	 */
	public void setSubTrdYn(String subTrdYn) {
		this.subTrdYn = subTrdYn;
	}
	
	/**
	 * Column Info
	 * @param tsPolNodYn
	 */
	public void setTsPolNodYn(String tsPolNodYn) {
		this.tsPolNodYn = tsPolNodYn;
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
	 * @param orgDestTrnsModCd
	 */
	public void setOrgDestTrnsModCd(String orgDestTrnsModCd) {
		this.orgDestTrnsModCd = orgDestTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param porYn
	 */
	public void setPorYn(String porYn) {
		this.porYn = porYn;
	}
	
	/**
	 * Column Info
	 * @param delNm
	 */
	public void setDelNm(String delNm) {
		this.delNm = delNm;
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
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @param n1stTsPodCntYn
	 */
	public void setN1stTsPodCntYn(String n1stTsPodCntYn) {
		this.n1stTsPodCntYn = n1stTsPodCntYn;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param shprYn
	 */
	public void setShprYn(String shprYn) {
		this.shprYn = shprYn;
	}
	
	/**
	 * Column Info
	 * @param stwgFlg
	 */
	public void setStwgFlg(String stwgFlg) {
		this.stwgFlg = stwgFlg;
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
	 * @param n1stTsDirYn
	 */
	public void setN1stTsDirYn(String n1stTsDirYn) {
		this.n1stTsDirYn = n1stTsDirYn;
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
	 * @param scYn
	 */
	public void setScYn(String scYn) {
		this.scYn = scYn;
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
	 * @param n1stTsSlanYn
	 */
	public void setN1stTsSlanYn(String n1stTsSlanYn) {
		this.n1stTsSlanYn = n1stTsSlanYn;
	}
	
	/**
	 * Column Info
	 * @param polNm
	 */
	public void setPolNm(String polNm) {
		this.polNm = polNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSeq
	 */
	public void setCtrtCustSeq(String ctrtCustSeq) {
		this.ctrtCustSeq = ctrtCustSeq;
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
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	
	/**
	 * Column Info
	 * @param rdFlg
	 */
	public void setRdFlg(String rdFlg) {
		this.rdFlg = rdFlg;
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
	 * @param fHeader
	 */
	public void setFHeader(String fHeader) {
		this.fHeader = fHeader;
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
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param tsPodNodYn
	 */
	public void setTsPodNodYn(String tsPodNodYn) {
		this.tsPodNodYn = tsPodNodYn;
	}
	
	/**
	 * Column Info
	 * @param polNodYn
	 */
	public void setPolNodYn(String polNodYn) {
		this.polNodYn = polNodYn;
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
	 * @param shprCustSeq
	 */
	public void setShprCustSeq(String shprCustSeq) {
		this.shprCustSeq = shprCustSeq;
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
	 * @param rfaYn
	 */
	public void setRfaYn(String rfaYn) {
		this.rfaYn = rfaYn;
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
	 * @param obSlsOfcNm
	 */
	public void setObSlsOfcNm(String obSlsOfcNm) {
		this.obSlsOfcNm = obSlsOfcNm;
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
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param agmtActCustSeq
	 */
	public void setAgmtActCustSeq(String agmtActCustSeq) {
		this.agmtActCustSeq = agmtActCustSeq;
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
	 * @param bkgTeuQty
	 */
	public void setBkgTeuQty(String bkgTeuQty) {
		this.bkgTeuQty = bkgTeuQty;
	}
	
	/**
	 * Column Info
	 * @param bkgDelSccYn
	 */
	public void setBkgDelSccYn(String bkgDelSccYn) {
		this.bkgDelSccYn = bkgDelSccYn;
	}
	
	/**
	 * Column Info
	 * @param taaNo
	 */
	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
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
	 * @param bkgAlocRmk
	 */
	public void setBkgAlocRmk(String bkgAlocRmk) {
		this.bkgAlocRmk = bkgAlocRmk;
	}
	
	/**
	 * Column Info
	 * @param trnkSlanYn
	 */
	public void setTrnkSlanYn(String trnkSlanYn) {
		this.trnkSlanYn = trnkSlanYn;
	}
	
	/**
	 * Column Info
	 * @param agmtCustLglEngNm
	 */
	public void setAgmtCustLglEngNm(String agmtCustLglEngNm) {
		this.agmtCustLglEngNm = agmtCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param bkgDelCntYn
	 */
	public void setBkgDelCntYn(String bkgDelCntYn) {
		this.bkgDelCntYn = bkgDelCntYn;
	}
	
	/**
	 * Column Info
	 * @param oftChgYn
	 */
	public void setOftChgYn(String oftChgYn) {
		this.oftChgYn = oftChgYn;
	}
	
	/**
	 * Column Info
	 * @param n1stTsPolCntYn
	 */
	public void setN1stTsPolCntYn(String n1stTsPolCntYn) {
		this.n1stTsPolCntYn = n1stTsPolCntYn;
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
	 * @param cntrTpszYn
	 */
	public void setCntrTpszYn(String cntrTpszYn) {
		this.cntrTpszYn = cntrTpszYn;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPodCntYn
	 */
	public void setBkgPodCntYn(String bkgPodCntYn) {
		this.bkgPodCntYn = bkgPodCntYn;
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
	 * @param tsNodYn
	 */
	public void setTsNodYn(String tsNodYn) {
		this.tsNodYn = tsNodYn;
	}
	
	/**
	 * Column Info
	 * @param porNodYn
	 */
	public void setPorNodYn(String porNodYn) {
		this.porNodYn = porNodYn;
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
	 * @param n1stTsPodCd
	 */
	public void setN1stTsPodCd(String n1stTsPodCd) {
		this.n1stTsPodCd = n1stTsPodCd;
	}
	
	/**
	 * Column Info
	 * @param podCdYn
	 */
	public void setPodCdYn(String podCdYn) {
		this.podCdYn = podCdYn;
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
		setAsgnWgtRtoYn(JSPUtil.getParameter(request, prefix + "asgn_wgt_rto_yn", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setAlocRtoYn(JSPUtil.getParameter(request, prefix + "aloc_rto_yn", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAgmtActCustCode(JSPUtil.getParameter(request, prefix + "agmt_act_cust_code", ""));
		setBkgPorCntCd(JSPUtil.getParameter(request, prefix + "bkg_por_cnt_cd", ""));
		setBkgPorSccYn(JSPUtil.getParameter(request, prefix + "bkg_por_scc_yn", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setAsgnTtlWgt(JSPUtil.getParameter(request, prefix + "asgn_ttl_wgt", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setN1stTsDirCd(JSPUtil.getParameter(request, prefix + "n1st_ts_dir_cd", ""));
		setPolYn(JSPUtil.getParameter(request, prefix + "pol_yn", ""));
		setShprCustCntCd(JSPUtil.getParameter(request, prefix + "shpr_cust_cnt_cd", ""));
		setTrnkPolYn(JSPUtil.getParameter(request, prefix + "trnk_pol_yn", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setBkgAlocTpCd(JSPUtil.getParameter(request, prefix + "bkg_aloc_tp_cd", ""));
		setAlocLodQtyRto(JSPUtil.getParameter(request, prefix + "aloc_lod_qty_rto", ""));
		setAlocLodYn(JSPUtil.getParameter(request, prefix + "aloc_lod_yn", ""));
		setAgmtYn(JSPUtil.getParameter(request, prefix + "agmt_yn", ""));
		setBkgDelCntCd(JSPUtil.getParameter(request, prefix + "bkg_del_cnt_cd", ""));
		setN1stTsPodCntCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pod_cnt_cd", ""));
		setCmpbAmt(JSPUtil.getParameter(request, prefix + "cmpb_amt", ""));
		setPorNm(JSPUtil.getParameter(request, prefix + "por_nm", ""));
		setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
		setShprCustCode(JSPUtil.getParameter(request, prefix + "shpr_cust_code", ""));
		setCtrtCustLglEngNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_lgl_eng_nm", ""));
		setDelYn(JSPUtil.getParameter(request, prefix + "del_yn", ""));
		setCmdtYn(JSPUtil.getParameter(request, prefix + "cmdt_yn", ""));
		setCmpbYn(JSPUtil.getParameter(request, prefix + "cmpb_yn", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setFHeadernm(JSPUtil.getParameter(request, prefix + "f_headernm", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setTrnkDirYn(JSPUtil.getParameter(request, prefix + "trnk_dir_yn", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setBkgPodCntCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cnt_cd", ""));
		setN1stTsPolYn(JSPUtil.getParameter(request, prefix + "n1st_ts_pol_yn", ""));
		setShprCustLglEngNm(JSPUtil.getParameter(request, prefix + "shpr_cust_lgl_eng_nm", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setCneeCustCntCd(JSPUtil.getParameter(request, prefix + "cnee_cust_cnt_cd", ""));
		setBkgPolCntYn(JSPUtil.getParameter(request, prefix + "bkg_pol_cnt_yn", ""));
		setN1stTsPolCntCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pol_cnt_cd", ""));
		setN1stTsPodYn(JSPUtil.getParameter(request, prefix + "n1st_ts_pod_yn", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setTsNodCd(JSPUtil.getParameter(request, prefix + "ts_nod_cd", ""));
		setBkgPorCntYn(JSPUtil.getParameter(request, prefix + "bkg_por_cnt_yn", ""));
		setAsgnWgtRto(JSPUtil.getParameter(request, prefix + "asgn_wgt_rto", ""));
		setRptFomNm(JSPUtil.getParameter(request, prefix + "rpt_fom_nm", ""));
		setScgGrpCmdtYn(JSPUtil.getParameter(request, prefix + "scg_grp_cmdt_yn", ""));
		setOftChgAmt(JSPUtil.getParameter(request, prefix + "oft_chg_amt", ""));
		setPgm(JSPUtil.getParameter(request, prefix + "pgm", ""));
		setTrnkPodYn(JSPUtil.getParameter(request, prefix + "trnk_pod_yn", ""));
		setFwdrCustCntCd(JSPUtil.getParameter(request, prefix + "fwdr_cust_cnt_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setUsYn(JSPUtil.getParameter(request, prefix + "us_yn", ""));
		setTrnkDirCd(JSPUtil.getParameter(request, prefix + "trnk_dir_cd", ""));
		setVvdYn(JSPUtil.getParameter(request, prefix + "vvd_yn", ""));
		setCtrtYn(JSPUtil.getParameter(request, prefix + "ctrt_yn", ""));
		setDgFlg(JSPUtil.getParameter(request, prefix + "dg_flg", ""));
		setScgGrpCmdtDesc(JSPUtil.getParameter(request, prefix + "scg_grp_cmdt_desc", ""));
		setDelNodYn(JSPUtil.getParameter(request, prefix + "del_nod_yn", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setDgRdYn(JSPUtil.getParameter(request, prefix + "dg_rd_yn", ""));
		setAsgnTtlWgtYn(JSPUtil.getParameter(request, prefix + "asgn_ttl_wgt_yn", ""));
		setCtrtCustCode(JSPUtil.getParameter(request, prefix + "ctrt_cust_code", ""));
		setTsPodNodCd(JSPUtil.getParameter(request, prefix + "ts_pod_nod_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPodNodYn(JSPUtil.getParameter(request, prefix + "pod_nod_yn", ""));
		setObSlsOfcYn(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_yn", ""));
		setSubTrdYn(JSPUtil.getParameter(request, prefix + "sub_trd_yn", ""));
		setTsPolNodYn(JSPUtil.getParameter(request, prefix + "ts_pol_nod_yn", ""));
		setAlocLodQty(JSPUtil.getParameter(request, prefix + "aloc_lod_qty", ""));
		setBkgPolCntCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cnt_cd", ""));
		setAlocUseFlg(JSPUtil.getParameter(request, prefix + "aloc_use_flg", ""));
		setOrgDestTrnsModCd(JSPUtil.getParameter(request, prefix + "org_dest_trns_mod_cd", ""));
		setPorYn(JSPUtil.getParameter(request, prefix + "por_yn", ""));
		setDelNm(JSPUtil.getParameter(request, prefix + "del_nm", ""));
		setAlocSvcCd(JSPUtil.getParameter(request, prefix + "aloc_svc_cd", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setN1stTsPodCntYn(JSPUtil.getParameter(request, prefix + "n1st_ts_pod_cnt_yn", ""));
		setTrnkSlanCd(JSPUtil.getParameter(request, prefix + "trnk_slan_cd", ""));
		setBkgDelSccCd(JSPUtil.getParameter(request, prefix + "bkg_del_scc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setShprYn(JSPUtil.getParameter(request, prefix + "shpr_yn", ""));
		setStwgFlg(JSPUtil.getParameter(request, prefix + "stwg_flg", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setN1stTsDirYn(JSPUtil.getParameter(request, prefix + "n1st_ts_dir_yn", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setScYn(JSPUtil.getParameter(request, prefix + "sc_yn", ""));
		setScgGrpCmdtSeq(JSPUtil.getParameter(request, prefix + "scg_grp_cmdt_seq", ""));
		setN1stTsSlanYn(JSPUtil.getParameter(request, prefix + "n1st_ts_slan_yn", ""));
		setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, prefix + "ctrt_cust_seq", ""));
		setCtrtCustCntCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
		setRdFlg(JSPUtil.getParameter(request, prefix + "rd_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFHeader(JSPUtil.getParameter(request, prefix + "f_header", ""));
		setN1stTsSlanCd(JSPUtil.getParameter(request, prefix + "n1st_ts_slan_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setTsPodNodYn(JSPUtil.getParameter(request, prefix + "ts_pod_nod_yn", ""));
		setPolNodYn(JSPUtil.getParameter(request, prefix + "pol_nod_yn", ""));
		setBkgCtrlTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrl_tp_cd", ""));
		setShprCustSeq(JSPUtil.getParameter(request, prefix + "shpr_cust_seq", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setRfaYn(JSPUtil.getParameter(request, prefix + "rfa_yn", ""));
		setAplyToYrwk(JSPUtil.getParameter(request, prefix + "aply_to_yrwk", ""));
		setObSlsOfcNm(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_nm", ""));
		setTsPolNodCd(JSPUtil.getParameter(request, prefix + "ts_pol_nod_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgAlocSeq(JSPUtil.getParameter(request, prefix + "bkg_aloc_seq", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setAgmtActCustSeq(JSPUtil.getParameter(request, prefix + "agmt_act_cust_seq", ""));
		setBkgPorSccCd(JSPUtil.getParameter(request, prefix + "bkg_por_scc_cd", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, prefix + "bkg_teu_qty", ""));
		setBkgDelSccYn(JSPUtil.getParameter(request, prefix + "bkg_del_scc_yn", ""));
		setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
		setUsaBkgModCd(JSPUtil.getParameter(request, prefix + "usa_bkg_mod_cd", ""));
		setBkgAlocRmk(JSPUtil.getParameter(request, prefix + "bkg_aloc_rmk", ""));
		setTrnkSlanYn(JSPUtil.getParameter(request, prefix + "trnk_slan_yn", ""));
		setAgmtCustLglEngNm(JSPUtil.getParameter(request, prefix + "agmt_cust_lgl_eng_nm", ""));
		setBkgDelCntYn(JSPUtil.getParameter(request, prefix + "bkg_del_cnt_yn", ""));
		setOftChgYn(JSPUtil.getParameter(request, prefix + "oft_chg_yn", ""));
		setN1stTsPolCntYn(JSPUtil.getParameter(request, prefix + "n1st_ts_pol_cnt_yn", ""));
		setTrunkPolCd(JSPUtil.getParameter(request, prefix + "trunk_pol_cd", ""));
		setCntrTpszYn(JSPUtil.getParameter(request, prefix + "cntr_tpsz_yn", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
		setBkgPodCntYn(JSPUtil.getParameter(request, prefix + "bkg_pod_cnt_yn", ""));
		setN1stTsPolCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pol_cd", ""));
		setTsNodYn(JSPUtil.getParameter(request, prefix + "ts_nod_yn", ""));
		setPorNodYn(JSPUtil.getParameter(request, prefix + "por_nod_yn", ""));
		setTrunkPodCd(JSPUtil.getParameter(request, prefix + "trunk_pod_cd", ""));
		setN1stTsPodCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pod_cd", ""));
		setPodCdYn(JSPUtil.getParameter(request, prefix + "pod_cd_yn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgInfoListVO[]
	 */
	public BkgInfoListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgInfoListVO[]
	 */
	public BkgInfoListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgInfoListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aplyFmYrwk = (JSPUtil.getParameter(request, prefix	+ "aply_fm_yrwk", length));
			String[] agmtActCntCd = (JSPUtil.getParameter(request, prefix	+ "agmt_act_cnt_cd", length));
			String[] asgnWgtRtoYn = (JSPUtil.getParameter(request, prefix	+ "asgn_wgt_rto_yn", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] alocRtoYn = (JSPUtil.getParameter(request, prefix	+ "aloc_rto_yn", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] agmtActCustCode = (JSPUtil.getParameter(request, prefix	+ "agmt_act_cust_code", length));
			String[] bkgPorCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cnt_cd", length));
			String[] bkgPorSccYn = (JSPUtil.getParameter(request, prefix	+ "bkg_por_scc_yn", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] asgnTtlWgt = (JSPUtil.getParameter(request, prefix	+ "asgn_ttl_wgt", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] n1stTsDirCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_dir_cd", length));
			String[] polYn = (JSPUtil.getParameter(request, prefix	+ "pol_yn", length));
			String[] shprCustCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_cnt_cd", length));
			String[] trnkPolYn = (JSPUtil.getParameter(request, prefix	+ "trnk_pol_yn", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] bkgAlocTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_tp_cd", length));
			String[] alocLodQtyRto = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty_rto", length));
			String[] alocLodYn = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_yn", length));
			String[] agmtYn = (JSPUtil.getParameter(request, prefix	+ "agmt_yn", length));
			String[] bkgDelCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cnt_cd", length));
			String[] n1stTsPodCntCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pod_cnt_cd", length));
			String[] cmpbAmt = (JSPUtil.getParameter(request, prefix	+ "cmpb_amt", length));
			String[] porNm = (JSPUtil.getParameter(request, prefix	+ "por_nm", length));
			String[] hngrFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_flg", length));
			String[] shprCustCode = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_code", length));
			String[] ctrtCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_lgl_eng_nm", length));
			String[] delYn = (JSPUtil.getParameter(request, prefix	+ "del_yn", length));
			String[] cmdtYn = (JSPUtil.getParameter(request, prefix	+ "cmdt_yn", length));
			String[] cmpbYn = (JSPUtil.getParameter(request, prefix	+ "cmpb_yn", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] fHeadernm = (JSPUtil.getParameter(request, prefix	+ "f_headernm", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] trnkDirYn = (JSPUtil.getParameter(request, prefix	+ "trnk_dir_yn", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bkgPodCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cnt_cd", length));
			String[] n1stTsPolYn = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pol_yn", length));
			String[] shprCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_lgl_eng_nm", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] cneeCustCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cust_cnt_cd", length));
			String[] bkgPolCntYn = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cnt_yn", length));
			String[] n1stTsPolCntCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pol_cnt_cd", length));
			String[] n1stTsPodYn = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pod_yn", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] tsNodCd = (JSPUtil.getParameter(request, prefix	+ "ts_nod_cd", length));
			String[] bkgPorCntYn = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cnt_yn", length));
			String[] asgnWgtRto = (JSPUtil.getParameter(request, prefix	+ "asgn_wgt_rto", length));
			String[] rptFomNm = (JSPUtil.getParameter(request, prefix	+ "rpt_fom_nm", length));
			String[] scgGrpCmdtYn = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_yn", length));
			String[] oftChgAmt = (JSPUtil.getParameter(request, prefix	+ "oft_chg_amt", length));
			String[] pgm = (JSPUtil.getParameter(request, prefix	+ "pgm", length));
			String[] trnkPodYn = (JSPUtil.getParameter(request, prefix	+ "trnk_pod_yn", length));
			String[] fwdrCustCntCd = (JSPUtil.getParameter(request, prefix	+ "fwdr_cust_cnt_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] usYn = (JSPUtil.getParameter(request, prefix	+ "us_yn", length));
			String[] trnkDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_dir_cd", length));
			String[] vvdYn = (JSPUtil.getParameter(request, prefix	+ "vvd_yn", length));
			String[] ctrtYn = (JSPUtil.getParameter(request, prefix	+ "ctrt_yn", length));
			String[] dgFlg = (JSPUtil.getParameter(request, prefix	+ "dg_flg", length));
			String[] scgGrpCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_desc", length));
			String[] delNodYn = (JSPUtil.getParameter(request, prefix	+ "del_nod_yn", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] dgRdYn = (JSPUtil.getParameter(request, prefix	+ "dg_rd_yn", length));
			String[] asgnTtlWgtYn = (JSPUtil.getParameter(request, prefix	+ "asgn_ttl_wgt_yn", length));
			String[] ctrtCustCode = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_code", length));
			String[] tsPodNodCd = (JSPUtil.getParameter(request, prefix	+ "ts_pod_nod_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] podNodYn = (JSPUtil.getParameter(request, prefix	+ "pod_nod_yn", length));
			String[] obSlsOfcYn = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_yn", length));
			String[] subTrdYn = (JSPUtil.getParameter(request, prefix	+ "sub_trd_yn", length));
			String[] tsPolNodYn = (JSPUtil.getParameter(request, prefix	+ "ts_pol_nod_yn", length));
			String[] alocLodQty = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty", length));
			String[] bkgPolCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cnt_cd", length));
			String[] alocUseFlg = (JSPUtil.getParameter(request, prefix	+ "aloc_use_flg", length));
			String[] orgDestTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_trns_mod_cd", length));
			String[] porYn = (JSPUtil.getParameter(request, prefix	+ "por_yn", length));
			String[] delNm = (JSPUtil.getParameter(request, prefix	+ "del_nm", length));
			String[] alocSvcCd = (JSPUtil.getParameter(request, prefix	+ "aloc_svc_cd", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] n1stTsPodCntYn = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pod_cnt_yn", length));
			String[] trnkSlanCd = (JSPUtil.getParameter(request, prefix	+ "trnk_slan_cd", length));
			String[] bkgDelSccCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_scc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] shprYn = (JSPUtil.getParameter(request, prefix	+ "shpr_yn", length));
			String[] stwgFlg = (JSPUtil.getParameter(request, prefix	+ "stwg_flg", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] n1stTsDirYn = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_dir_yn", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] scYn = (JSPUtil.getParameter(request, prefix	+ "sc_yn", length));
			String[] scgGrpCmdtSeq = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_seq", length));
			String[] n1stTsSlanYn = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_slan_yn", length));
			String[] polNm = (JSPUtil.getParameter(request, prefix	+ "pol_nm", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] rdFlg = (JSPUtil.getParameter(request, prefix	+ "rd_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fHeader = (JSPUtil.getParameter(request, prefix	+ "f_header", length));
			String[] n1stTsSlanCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_slan_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] tsPodNodYn = (JSPUtil.getParameter(request, prefix	+ "ts_pod_nod_yn", length));
			String[] polNodYn = (JSPUtil.getParameter(request, prefix	+ "pol_nod_yn", length));
			String[] bkgCtrlTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_tp_cd", length));
			String[] shprCustSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_seq", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] rfaYn = (JSPUtil.getParameter(request, prefix	+ "rfa_yn", length));
			String[] aplyToYrwk = (JSPUtil.getParameter(request, prefix	+ "aply_to_yrwk", length));
			String[] obSlsOfcNm = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_nm", length));
			String[] tsPolNodCd = (JSPUtil.getParameter(request, prefix	+ "ts_pol_nod_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgAlocSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_seq", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] agmtActCustSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_act_cust_seq", length));
			String[] bkgPorSccCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_scc_cd", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] bkgDelSccYn = (JSPUtil.getParameter(request, prefix	+ "bkg_del_scc_yn", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] usaBkgModCd = (JSPUtil.getParameter(request, prefix	+ "usa_bkg_mod_cd", length));
			String[] bkgAlocRmk = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_rmk", length));
			String[] trnkSlanYn = (JSPUtil.getParameter(request, prefix	+ "trnk_slan_yn", length));
			String[] agmtCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "agmt_cust_lgl_eng_nm", length));
			String[] bkgDelCntYn = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cnt_yn", length));
			String[] oftChgYn = (JSPUtil.getParameter(request, prefix	+ "oft_chg_yn", length));
			String[] n1stTsPolCntYn = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pol_cnt_yn", length));
			String[] trunkPolCd = (JSPUtil.getParameter(request, prefix	+ "trunk_pol_cd", length));
			String[] cntrTpszYn = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_yn", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] bkgPodCntYn = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cnt_yn", length));
			String[] n1stTsPolCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pol_cd", length));
			String[] tsNodYn = (JSPUtil.getParameter(request, prefix	+ "ts_nod_yn", length));
			String[] porNodYn = (JSPUtil.getParameter(request, prefix	+ "por_nod_yn", length));
			String[] trunkPodCd = (JSPUtil.getParameter(request, prefix	+ "trunk_pod_cd", length));
			String[] n1stTsPodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pod_cd", length));
			String[] podCdYn = (JSPUtil.getParameter(request, prefix	+ "pod_cd_yn", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgInfoListVO();
				if (aplyFmYrwk[i] != null)
					model.setAplyFmYrwk(aplyFmYrwk[i]);
				if (agmtActCntCd[i] != null)
					model.setAgmtActCntCd(agmtActCntCd[i]);
				if (asgnWgtRtoYn[i] != null)
					model.setAsgnWgtRtoYn(asgnWgtRtoYn[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (alocRtoYn[i] != null)
					model.setAlocRtoYn(alocRtoYn[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (agmtActCustCode[i] != null)
					model.setAgmtActCustCode(agmtActCustCode[i]);
				if (bkgPorCntCd[i] != null)
					model.setBkgPorCntCd(bkgPorCntCd[i]);
				if (bkgPorSccYn[i] != null)
					model.setBkgPorSccYn(bkgPorSccYn[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (asgnTtlWgt[i] != null)
					model.setAsgnTtlWgt(asgnTtlWgt[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (n1stTsDirCd[i] != null)
					model.setN1stTsDirCd(n1stTsDirCd[i]);
				if (polYn[i] != null)
					model.setPolYn(polYn[i]);
				if (shprCustCntCd[i] != null)
					model.setShprCustCntCd(shprCustCntCd[i]);
				if (trnkPolYn[i] != null)
					model.setTrnkPolYn(trnkPolYn[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (bkgAlocTpCd[i] != null)
					model.setBkgAlocTpCd(bkgAlocTpCd[i]);
				if (alocLodQtyRto[i] != null)
					model.setAlocLodQtyRto(alocLodQtyRto[i]);
				if (alocLodYn[i] != null)
					model.setAlocLodYn(alocLodYn[i]);
				if (agmtYn[i] != null)
					model.setAgmtYn(agmtYn[i]);
				if (bkgDelCntCd[i] != null)
					model.setBkgDelCntCd(bkgDelCntCd[i]);
				if (n1stTsPodCntCd[i] != null)
					model.setN1stTsPodCntCd(n1stTsPodCntCd[i]);
				if (cmpbAmt[i] != null)
					model.setCmpbAmt(cmpbAmt[i]);
				if (porNm[i] != null)
					model.setPorNm(porNm[i]);
				if (hngrFlg[i] != null)
					model.setHngrFlg(hngrFlg[i]);
				if (shprCustCode[i] != null)
					model.setShprCustCode(shprCustCode[i]);
				if (ctrtCustLglEngNm[i] != null)
					model.setCtrtCustLglEngNm(ctrtCustLglEngNm[i]);
				if (delYn[i] != null)
					model.setDelYn(delYn[i]);
				if (cmdtYn[i] != null)
					model.setCmdtYn(cmdtYn[i]);
				if (cmpbYn[i] != null)
					model.setCmpbYn(cmpbYn[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (fHeadernm[i] != null)
					model.setFHeadernm(fHeadernm[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (trnkDirYn[i] != null)
					model.setTrnkDirYn(trnkDirYn[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bkgPodCntCd[i] != null)
					model.setBkgPodCntCd(bkgPodCntCd[i]);
				if (n1stTsPolYn[i] != null)
					model.setN1stTsPolYn(n1stTsPolYn[i]);
				if (shprCustLglEngNm[i] != null)
					model.setShprCustLglEngNm(shprCustLglEngNm[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (cneeCustCntCd[i] != null)
					model.setCneeCustCntCd(cneeCustCntCd[i]);
				if (bkgPolCntYn[i] != null)
					model.setBkgPolCntYn(bkgPolCntYn[i]);
				if (n1stTsPolCntCd[i] != null)
					model.setN1stTsPolCntCd(n1stTsPolCntCd[i]);
				if (n1stTsPodYn[i] != null)
					model.setN1stTsPodYn(n1stTsPodYn[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (tsNodCd[i] != null)
					model.setTsNodCd(tsNodCd[i]);
				if (bkgPorCntYn[i] != null)
					model.setBkgPorCntYn(bkgPorCntYn[i]);
				if (asgnWgtRto[i] != null)
					model.setAsgnWgtRto(asgnWgtRto[i]);
				if (rptFomNm[i] != null)
					model.setRptFomNm(rptFomNm[i]);
				if (scgGrpCmdtYn[i] != null)
					model.setScgGrpCmdtYn(scgGrpCmdtYn[i]);
				if (oftChgAmt[i] != null)
					model.setOftChgAmt(oftChgAmt[i]);
				if (pgm[i] != null)
					model.setPgm(pgm[i]);
				if (trnkPodYn[i] != null)
					model.setTrnkPodYn(trnkPodYn[i]);
				if (fwdrCustCntCd[i] != null)
					model.setFwdrCustCntCd(fwdrCustCntCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (usYn[i] != null)
					model.setUsYn(usYn[i]);
				if (trnkDirCd[i] != null)
					model.setTrnkDirCd(trnkDirCd[i]);
				if (vvdYn[i] != null)
					model.setVvdYn(vvdYn[i]);
				if (ctrtYn[i] != null)
					model.setCtrtYn(ctrtYn[i]);
				if (dgFlg[i] != null)
					model.setDgFlg(dgFlg[i]);
				if (scgGrpCmdtDesc[i] != null)
					model.setScgGrpCmdtDesc(scgGrpCmdtDesc[i]);
				if (delNodYn[i] != null)
					model.setDelNodYn(delNodYn[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (dgRdYn[i] != null)
					model.setDgRdYn(dgRdYn[i]);
				if (asgnTtlWgtYn[i] != null)
					model.setAsgnTtlWgtYn(asgnTtlWgtYn[i]);
				if (ctrtCustCode[i] != null)
					model.setCtrtCustCode(ctrtCustCode[i]);
				if (tsPodNodCd[i] != null)
					model.setTsPodNodCd(tsPodNodCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (podNodYn[i] != null)
					model.setPodNodYn(podNodYn[i]);
				if (obSlsOfcYn[i] != null)
					model.setObSlsOfcYn(obSlsOfcYn[i]);
				if (subTrdYn[i] != null)
					model.setSubTrdYn(subTrdYn[i]);
				if (tsPolNodYn[i] != null)
					model.setTsPolNodYn(tsPolNodYn[i]);
				if (alocLodQty[i] != null)
					model.setAlocLodQty(alocLodQty[i]);
				if (bkgPolCntCd[i] != null)
					model.setBkgPolCntCd(bkgPolCntCd[i]);
				if (alocUseFlg[i] != null)
					model.setAlocUseFlg(alocUseFlg[i]);
				if (orgDestTrnsModCd[i] != null)
					model.setOrgDestTrnsModCd(orgDestTrnsModCd[i]);
				if (porYn[i] != null)
					model.setPorYn(porYn[i]);
				if (delNm[i] != null)
					model.setDelNm(delNm[i]);
				if (alocSvcCd[i] != null)
					model.setAlocSvcCd(alocSvcCd[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (n1stTsPodCntYn[i] != null)
					model.setN1stTsPodCntYn(n1stTsPodCntYn[i]);
				if (trnkSlanCd[i] != null)
					model.setTrnkSlanCd(trnkSlanCd[i]);
				if (bkgDelSccCd[i] != null)
					model.setBkgDelSccCd(bkgDelSccCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (shprYn[i] != null)
					model.setShprYn(shprYn[i]);
				if (stwgFlg[i] != null)
					model.setStwgFlg(stwgFlg[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (n1stTsDirYn[i] != null)
					model.setN1stTsDirYn(n1stTsDirYn[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (scYn[i] != null)
					model.setScYn(scYn[i]);
				if (scgGrpCmdtSeq[i] != null)
					model.setScgGrpCmdtSeq(scgGrpCmdtSeq[i]);
				if (n1stTsSlanYn[i] != null)
					model.setN1stTsSlanYn(n1stTsSlanYn[i]);
				if (polNm[i] != null)
					model.setPolNm(polNm[i]);
				if (ctrtCustSeq[i] != null)
					model.setCtrtCustSeq(ctrtCustSeq[i]);
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (rdFlg[i] != null)
					model.setRdFlg(rdFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fHeader[i] != null)
					model.setFHeader(fHeader[i]);
				if (n1stTsSlanCd[i] != null)
					model.setN1stTsSlanCd(n1stTsSlanCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (tsPodNodYn[i] != null)
					model.setTsPodNodYn(tsPodNodYn[i]);
				if (polNodYn[i] != null)
					model.setPolNodYn(polNodYn[i]);
				if (bkgCtrlTpCd[i] != null)
					model.setBkgCtrlTpCd(bkgCtrlTpCd[i]);
				if (shprCustSeq[i] != null)
					model.setShprCustSeq(shprCustSeq[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (rfaYn[i] != null)
					model.setRfaYn(rfaYn[i]);
				if (aplyToYrwk[i] != null)
					model.setAplyToYrwk(aplyToYrwk[i]);
				if (obSlsOfcNm[i] != null)
					model.setObSlsOfcNm(obSlsOfcNm[i]);
				if (tsPolNodCd[i] != null)
					model.setTsPolNodCd(tsPolNodCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgAlocSeq[i] != null)
					model.setBkgAlocSeq(bkgAlocSeq[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (agmtActCustSeq[i] != null)
					model.setAgmtActCustSeq(agmtActCustSeq[i]);
				if (bkgPorSccCd[i] != null)
					model.setBkgPorSccCd(bkgPorSccCd[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (bkgDelSccYn[i] != null)
					model.setBkgDelSccYn(bkgDelSccYn[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (usaBkgModCd[i] != null)
					model.setUsaBkgModCd(usaBkgModCd[i]);
				if (bkgAlocRmk[i] != null)
					model.setBkgAlocRmk(bkgAlocRmk[i]);
				if (trnkSlanYn[i] != null)
					model.setTrnkSlanYn(trnkSlanYn[i]);
				if (agmtCustLglEngNm[i] != null)
					model.setAgmtCustLglEngNm(agmtCustLglEngNm[i]);
				if (bkgDelCntYn[i] != null)
					model.setBkgDelCntYn(bkgDelCntYn[i]);
				if (oftChgYn[i] != null)
					model.setOftChgYn(oftChgYn[i]);
				if (n1stTsPolCntYn[i] != null)
					model.setN1stTsPolCntYn(n1stTsPolCntYn[i]);
				if (trunkPolCd[i] != null)
					model.setTrunkPolCd(trunkPolCd[i]);
				if (cntrTpszYn[i] != null)
					model.setCntrTpszYn(cntrTpszYn[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (bkgPodCntYn[i] != null)
					model.setBkgPodCntYn(bkgPodCntYn[i]);
				if (n1stTsPolCd[i] != null)
					model.setN1stTsPolCd(n1stTsPolCd[i]);
				if (tsNodYn[i] != null)
					model.setTsNodYn(tsNodYn[i]);
				if (porNodYn[i] != null)
					model.setPorNodYn(porNodYn[i]);
				if (trunkPodCd[i] != null)
					model.setTrunkPodCd(trunkPodCd[i]);
				if (n1stTsPodCd[i] != null)
					model.setN1stTsPodCd(n1stTsPodCd[i]);
				if (podCdYn[i] != null)
					model.setPodCdYn(podCdYn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgInfoListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgInfoListVO[]
	 */
	public BkgInfoListVO[] getBkgInfoListVOs(){
		BkgInfoListVO[] vos = (BkgInfoListVO[])models.toArray(new BkgInfoListVO[models.size()]);
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
		this.asgnWgtRtoYn = this.asgnWgtRtoYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocRtoYn = this.alocRtoYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtActCustCode = this.agmtActCustCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCntCd = this.bkgPorCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorSccYn = this.bkgPorSccYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnTtlWgt = this.asgnTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsDirCd = this.n1stTsDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYn = this.polYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustCntCd = this.shprCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkPolYn = this.trnkPolYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocTpCd = this.bkgAlocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQtyRto = this.alocLodQtyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodYn = this.alocLodYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtYn = this.agmtYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCntCd = this.bkgDelCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPodCntCd = this.n1stTsPodCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbAmt = this.cmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNm = this.porNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlg = this.hngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustCode = this.shprCustCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustLglEngNm = this.ctrtCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delYn = this.delYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtYn = this.cmdtYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbYn = this.cmpbYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fHeadernm = this.fHeadernm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkDirYn = this.trnkDirYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCntCd = this.bkgPodCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPolYn = this.n1stTsPolYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustLglEngNm = this.shprCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCustCntCd = this.cneeCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCntYn = this.bkgPolCntYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPolCntCd = this.n1stTsPolCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPodYn = this.n1stTsPodYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsNodCd = this.tsNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCntYn = this.bkgPorCntYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnWgtRto = this.asgnWgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptFomNm = this.rptFomNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtYn = this.scgGrpCmdtYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftChgAmt = this.oftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgm = this.pgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkPodYn = this.trnkPodYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdrCustCntCd = this.fwdrCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usYn = this.usYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkDirCd = this.trnkDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdYn = this.vvdYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtYn = this.ctrtYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFlg = this.dgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtDesc = this.scgGrpCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodYn = this.delNodYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgRdYn = this.dgRdYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnTtlWgtYn = this.asgnTtlWgtYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCode = this.ctrtCustCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPodNodCd = this.tsPodNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodYn = this.podNodYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcYn = this.obSlsOfcYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdYn = this.subTrdYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPolNodYn = this.tsPolNodYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQty = this.alocLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCntCd = this.bkgPolCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocUseFlg = this.alocUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTrnsModCd = this.orgDestTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porYn = this.porYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNm = this.delNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocSvcCd = this.alocSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPodCntYn = this.n1stTsPodCntYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSlanCd = this.trnkSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelSccCd = this.bkgDelSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprYn = this.shprYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgFlg = this.stwgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsDirYn = this.n1stTsDirYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scYn = this.scYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtSeq = this.scgGrpCmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsSlanYn = this.n1stTsSlanYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNm = this.polNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFlg = this.rdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fHeader = this.fHeader .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsSlanCd = this.n1stTsSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPodNodYn = this.tsPodNodYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodYn = this.polNodYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlTpCd = this.bkgCtrlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustSeq = this.shprCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaYn = this.rfaYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyToYrwk = this.aplyToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcNm = this.obSlsOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPolNodCd = this.tsPolNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocSeq = this.bkgAlocSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtActCustSeq = this.agmtActCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorSccCd = this.bkgPorSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelSccYn = this.bkgDelSccYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaBkgModCd = this.usaBkgModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocRmk = this.bkgAlocRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSlanYn = this.trnkSlanYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCustLglEngNm = this.agmtCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCntYn = this.bkgDelCntYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftChgYn = this.oftChgYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPolCntYn = this.n1stTsPolCntYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPolCd = this.trunkPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszYn = this.cntrTpszYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCntYn = this.bkgPodCntYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPolCd = this.n1stTsPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsNodYn = this.tsNodYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodYn = this.porNodYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPodCd = this.trunkPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPodCd = this.n1stTsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCdYn = this.podCdYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
