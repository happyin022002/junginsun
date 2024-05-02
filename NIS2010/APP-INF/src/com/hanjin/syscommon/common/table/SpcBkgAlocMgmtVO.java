/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpcBkgAlocMgmtVO.java
*@FileTitle : SpcBkgAlocMgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.29
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.05.29 Arie 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author Arie
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpcBkgAlocMgmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcBkgAlocMgmtVO> models = new ArrayList<SpcBkgAlocMgmtVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String asgnTtlWgt = null;
	/* Column Info */
	private String raplyCfmFlg = null;
	/* Column Info */
	private String n1stTsPodCntCd = null;
	/* Column Info */
	private String bkgCtrlTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String n2ndTsPodCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String alocAplyFmDt = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String aplyToYrwk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String ctrtCustSeq = null;
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
	private String skdVoyNo = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String n1stTsPolCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String n1stTsDirCd = null;
	/* Column Info */
	private String bkgAlocRmk = null;
	/* Column Info */
	private String subTrdCd = null;
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
	private String creDt = null;
	/* Column Info */
	private String alocLodQty = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String bkgDelCntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cmpbAmt = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String trnkSlanCd = null;
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
	private String polNodCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String alocAplyToDt = null;
	/* Column Info */
	private String n2ndTsPolCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String n1stTsPolCntCd = null;
	/* Column Info */
	private String bkgPorSccCd = null;
	/* Column Info */
	private String bkgAlocSeq = null;
	/* Column Info */
	private String bkgPorCntCd = null;
	/* Column Info */
	private String bkgPodCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpcBkgAlocMgmtVO() {}

	public SpcBkgAlocMgmtVO(String ibflag, String pagerows, String bkgAlocSeq, String bkgAlocTpCd, String trnkSlanCd, String trnkDirCd, String obSlsOfcCd, String porCd, String porNodCd, String bkgPorSccCd, String polCd, String polNodCd, String n1stTsSlanCd, String n1stTsPolCd, String n1stTsPodCd, String n1stTsDirCd, String n1stTsPolCntCd, String n1stTsPodCntCd, String n2ndTsSlanCd, String n2ndTsPolCd, String n2ndTsPodCd, String podCd, String podNodCd, String delCd, String delNodCd, String bkgDelSccCd, String scNo, String rfaNo, String ctrtCustCntCd, String ctrtCustSeq, String custCntCd, String custSeq, String cntrTpszCd, String cmdtCd, String alocLodQty, String alocLodQtyRto, String alocSvcCd, String bkgAlocRmk, String alocUseFlg, String vslCd, String skdVoyNo, String skdDirCd, String slsRhqCd, String scgGrpCmdtSeq, String bkgPorCntCd, String bkgPolCntCd, String bkgPodCntCd, String bkgDelCntCd, String cmpbAmt, String bkgCtrlTpCd, String dcgoFlg, String rdCgoFlg, String creUsrId, String creDt, String updUsrId, String updDt, String alocAplyFmDt, String alocAplyToDt, String subTrdCd, String oftChgAmt, String raplyCfmFlg, String usaBkgModCd, String hulBndCd, String aplyFmYrwk, String aplyToYrwk, String asgnTtlWgt, String asgnWgtRto) {
		this.vslCd = vslCd;
		this.asgnTtlWgt = asgnTtlWgt;
		this.raplyCfmFlg = raplyCfmFlg;
		this.n1stTsPodCntCd = n1stTsPodCntCd;
		this.bkgCtrlTpCd = bkgCtrlTpCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.n2ndTsPodCd = n2ndTsPodCd;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.alocAplyFmDt = alocAplyFmDt;
		this.delNodCd = delNodCd;
		this.obSlsOfcCd = obSlsOfcCd;
		this.aplyToYrwk = aplyToYrwk;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.hulBndCd = hulBndCd;
		this.ctrtCustSeq = ctrtCustSeq;
		this.alocLodQtyRto = alocLodQtyRto;
		this.aplyFmYrwk = aplyFmYrwk;
		this.scgGrpCmdtSeq = scgGrpCmdtSeq;
		this.trnkDirCd = trnkDirCd;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.slsRhqCd = slsRhqCd;
		this.n1stTsPolCd = n1stTsPolCd;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.podNodCd = podNodCd;
		this.n1stTsDirCd = n1stTsDirCd;
		this.bkgAlocRmk = bkgAlocRmk;
		this.subTrdCd = subTrdCd;
		this.alocUseFlg = alocUseFlg;
		this.porCd = porCd;
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.bkgDelSccCd = bkgDelSccCd;
		this.usaBkgModCd = usaBkgModCd;
		this.n1stTsPodCd = n1stTsPodCd;
		this.rdCgoFlg = rdCgoFlg;
		this.n2ndTsSlanCd = n2ndTsSlanCd;
		this.creDt = creDt;
		this.alocLodQty = alocLodQty;
		this.rfaNo = rfaNo;
		this.bkgDelCntCd = bkgDelCntCd;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.cmpbAmt = cmpbAmt;
		this.dcgoFlg = dcgoFlg;
		this.trnkSlanCd = trnkSlanCd;
		this.bkgPolCntCd = bkgPolCntCd;
		this.asgnWgtRto = asgnWgtRto;
		this.bkgAlocTpCd = bkgAlocTpCd;
		this.n1stTsSlanCd = n1stTsSlanCd;
		this.updDt = updDt;
		this.porNodCd = porNodCd;
		this.alocSvcCd = alocSvcCd;
		this.oftChgAmt = oftChgAmt;
		this.polNodCd = polNodCd;
		this.custSeq = custSeq;
		this.alocAplyToDt = alocAplyToDt;
		this.n2ndTsPolCd = n2ndTsPolCd;
		this.skdDirCd = skdDirCd;
		this.n1stTsPolCntCd = n1stTsPolCntCd;
		this.bkgPorSccCd = bkgPorSccCd;
		this.bkgAlocSeq = bkgAlocSeq;
		this.bkgPorCntCd = bkgPorCntCd;
		this.bkgPodCntCd = bkgPodCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("asgn_ttl_wgt", getAsgnTtlWgt());
		this.hashColumns.put("raply_cfm_flg", getRaplyCfmFlg());
		this.hashColumns.put("n1st_ts_pod_cnt_cd", getN1stTsPodCntCd());
		this.hashColumns.put("bkg_ctrl_tp_cd", getBkgCtrlTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("n2nd_ts_pod_cd", getN2ndTsPodCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("aloc_aply_fm_dt", getAlocAplyFmDt());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("aply_to_yrwk", getAplyToYrwk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("aloc_lod_qty_rto", getAlocLodQtyRto());
		this.hashColumns.put("aply_fm_yrwk", getAplyFmYrwk());
		this.hashColumns.put("scg_grp_cmdt_seq", getScgGrpCmdtSeq());
		this.hashColumns.put("trnk_dir_cd", getTrnkDirCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("n1st_ts_pol_cd", getN1stTsPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("n1st_ts_dir_cd", getN1stTsDirCd());
		this.hashColumns.put("bkg_aloc_rmk", getBkgAlocRmk());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("aloc_use_flg", getAlocUseFlg());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("bkg_del_scc_cd", getBkgDelSccCd());
		this.hashColumns.put("usa_bkg_mod_cd", getUsaBkgModCd());
		this.hashColumns.put("n1st_ts_pod_cd", getN1stTsPodCd());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("n2nd_ts_slan_cd", getN2ndTsSlanCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("aloc_lod_qty", getAlocLodQty());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("bkg_del_cnt_cd", getBkgDelCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cmpb_amt", getCmpbAmt());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("trnk_slan_cd", getTrnkSlanCd());
		this.hashColumns.put("bkg_pol_cnt_cd", getBkgPolCntCd());
		this.hashColumns.put("asgn_wgt_rto", getAsgnWgtRto());
		this.hashColumns.put("bkg_aloc_tp_cd", getBkgAlocTpCd());
		this.hashColumns.put("n1st_ts_slan_cd", getN1stTsSlanCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("aloc_svc_cd", getAlocSvcCd());
		this.hashColumns.put("oft_chg_amt", getOftChgAmt());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("aloc_aply_to_dt", getAlocAplyToDt());
		this.hashColumns.put("n2nd_ts_pol_cd", getN2ndTsPolCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("n1st_ts_pol_cnt_cd", getN1stTsPolCntCd());
		this.hashColumns.put("bkg_por_scc_cd", getBkgPorSccCd());
		this.hashColumns.put("bkg_aloc_seq", getBkgAlocSeq());
		this.hashColumns.put("bkg_por_cnt_cd", getBkgPorCntCd());
		this.hashColumns.put("bkg_pod_cnt_cd", getBkgPodCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("asgn_ttl_wgt", "asgnTtlWgt");
		this.hashFields.put("raply_cfm_flg", "raplyCfmFlg");
		this.hashFields.put("n1st_ts_pod_cnt_cd", "n1stTsPodCntCd");
		this.hashFields.put("bkg_ctrl_tp_cd", "bkgCtrlTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("n2nd_ts_pod_cd", "n2ndTsPodCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("aloc_aply_fm_dt", "alocAplyFmDt");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("aply_to_yrwk", "aplyToYrwk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("aloc_lod_qty_rto", "alocLodQtyRto");
		this.hashFields.put("aply_fm_yrwk", "aplyFmYrwk");
		this.hashFields.put("scg_grp_cmdt_seq", "scgGrpCmdtSeq");
		this.hashFields.put("trnk_dir_cd", "trnkDirCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("n1st_ts_pol_cd", "n1stTsPolCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("n1st_ts_dir_cd", "n1stTsDirCd");
		this.hashFields.put("bkg_aloc_rmk", "bkgAlocRmk");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("aloc_use_flg", "alocUseFlg");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("bkg_del_scc_cd", "bkgDelSccCd");
		this.hashFields.put("usa_bkg_mod_cd", "usaBkgModCd");
		this.hashFields.put("n1st_ts_pod_cd", "n1stTsPodCd");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("n2nd_ts_slan_cd", "n2ndTsSlanCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("aloc_lod_qty", "alocLodQty");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("bkg_del_cnt_cd", "bkgDelCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cmpb_amt", "cmpbAmt");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("trnk_slan_cd", "trnkSlanCd");
		this.hashFields.put("bkg_pol_cnt_cd", "bkgPolCntCd");
		this.hashFields.put("asgn_wgt_rto", "asgnWgtRto");
		this.hashFields.put("bkg_aloc_tp_cd", "bkgAlocTpCd");
		this.hashFields.put("n1st_ts_slan_cd", "n1stTsSlanCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("aloc_svc_cd", "alocSvcCd");
		this.hashFields.put("oft_chg_amt", "oftChgAmt");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("aloc_aply_to_dt", "alocAplyToDt");
		this.hashFields.put("n2nd_ts_pol_cd", "n2ndTsPolCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("n1st_ts_pol_cnt_cd", "n1stTsPolCntCd");
		this.hashFields.put("bkg_por_scc_cd", "bkgPorSccCd");
		this.hashFields.put("bkg_aloc_seq", "bkgAlocSeq");
		this.hashFields.put("bkg_por_cnt_cd", "bkgPorCntCd");
		this.hashFields.put("bkg_pod_cnt_cd", "bkgPodCntCd");
		return this.hashFields;
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
	 * @return asgnTtlWgt
	 */
	public String getAsgnTtlWgt() {
		return this.asgnTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return raplyCfmFlg
	 */
	public String getRaplyCfmFlg() {
		return this.raplyCfmFlg;
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
	 * @return bkgCtrlTpCd
	 */
	public String getBkgCtrlTpCd() {
		return this.bkgCtrlTpCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
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
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return n1stTsPolCd
	 */
	public String getN1stTsPolCd() {
		return this.n1stTsPolCd;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return bkgDelCntCd
	 */
	public String getBkgDelCntCd() {
		return this.bkgDelCntCd;
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
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
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
	 * @return alocAplyToDt
	 */
	public String getAlocAplyToDt() {
		return this.alocAplyToDt;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return bkgAlocSeq
	 */
	public String getBkgAlocSeq() {
		return this.bkgAlocSeq;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param raplyCfmFlg
	 */
	public void setRaplyCfmFlg(String raplyCfmFlg) {
		this.raplyCfmFlg = raplyCfmFlg;
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
	 * @param bkgCtrlTpCd
	 */
	public void setBkgCtrlTpCd(String bkgCtrlTpCd) {
		this.bkgCtrlTpCd = bkgCtrlTpCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
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
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param n1stTsPolCd
	 */
	public void setN1stTsPolCd(String n1stTsPolCd) {
		this.n1stTsPolCd = n1stTsPolCd;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param bkgDelCntCd
	 */
	public void setBkgDelCntCd(String bkgDelCntCd) {
		this.bkgDelCntCd = bkgDelCntCd;
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
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
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
	 * @param alocAplyToDt
	 */
	public void setAlocAplyToDt(String alocAplyToDt) {
		this.alocAplyToDt = alocAplyToDt;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param bkgAlocSeq
	 */
	public void setBkgAlocSeq(String bkgAlocSeq) {
		this.bkgAlocSeq = bkgAlocSeq;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setAsgnTtlWgt(JSPUtil.getParameter(request, prefix + "asgn_ttl_wgt", ""));
		setRaplyCfmFlg(JSPUtil.getParameter(request, prefix + "raply_cfm_flg", ""));
		setN1stTsPodCntCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pod_cnt_cd", ""));
		setBkgCtrlTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrl_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setN2ndTsPodCd(JSPUtil.getParameter(request, prefix + "n2nd_ts_pod_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setAlocAplyFmDt(JSPUtil.getParameter(request, prefix + "aloc_aply_fm_dt", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setAplyToYrwk(JSPUtil.getParameter(request, prefix + "aply_to_yrwk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, prefix + "ctrt_cust_seq", ""));
		setAlocLodQtyRto(JSPUtil.getParameter(request, prefix + "aloc_lod_qty_rto", ""));
		setAplyFmYrwk(JSPUtil.getParameter(request, prefix + "aply_fm_yrwk", ""));
		setScgGrpCmdtSeq(JSPUtil.getParameter(request, prefix + "scg_grp_cmdt_seq", ""));
		setTrnkDirCd(JSPUtil.getParameter(request, prefix + "trnk_dir_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setN1stTsPolCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setN1stTsDirCd(JSPUtil.getParameter(request, prefix + "n1st_ts_dir_cd", ""));
		setBkgAlocRmk(JSPUtil.getParameter(request, prefix + "bkg_aloc_rmk", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setAlocUseFlg(JSPUtil.getParameter(request, prefix + "aloc_use_flg", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCtrtCustCntCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_cd", ""));
		setBkgDelSccCd(JSPUtil.getParameter(request, prefix + "bkg_del_scc_cd", ""));
		setUsaBkgModCd(JSPUtil.getParameter(request, prefix + "usa_bkg_mod_cd", ""));
		setN1stTsPodCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pod_cd", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setN2ndTsSlanCd(JSPUtil.getParameter(request, prefix + "n2nd_ts_slan_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAlocLodQty(JSPUtil.getParameter(request, prefix + "aloc_lod_qty", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setBkgDelCntCd(JSPUtil.getParameter(request, prefix + "bkg_del_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCmpbAmt(JSPUtil.getParameter(request, prefix + "cmpb_amt", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setTrnkSlanCd(JSPUtil.getParameter(request, prefix + "trnk_slan_cd", ""));
		setBkgPolCntCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cnt_cd", ""));
		setAsgnWgtRto(JSPUtil.getParameter(request, prefix + "asgn_wgt_rto", ""));
		setBkgAlocTpCd(JSPUtil.getParameter(request, prefix + "bkg_aloc_tp_cd", ""));
		setN1stTsSlanCd(JSPUtil.getParameter(request, prefix + "n1st_ts_slan_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setAlocSvcCd(JSPUtil.getParameter(request, prefix + "aloc_svc_cd", ""));
		setOftChgAmt(JSPUtil.getParameter(request, prefix + "oft_chg_amt", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setAlocAplyToDt(JSPUtil.getParameter(request, prefix + "aloc_aply_to_dt", ""));
		setN2ndTsPolCd(JSPUtil.getParameter(request, prefix + "n2nd_ts_pol_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setN1stTsPolCntCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pol_cnt_cd", ""));
		setBkgPorSccCd(JSPUtil.getParameter(request, prefix + "bkg_por_scc_cd", ""));
		setBkgAlocSeq(JSPUtil.getParameter(request, prefix + "bkg_aloc_seq", ""));
		setBkgPorCntCd(JSPUtil.getParameter(request, prefix + "bkg_por_cnt_cd", ""));
		setBkgPodCntCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcBkgAlocMgmtVO[]
	 */
	public SpcBkgAlocMgmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcBkgAlocMgmtVO[]
	 */
	public SpcBkgAlocMgmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcBkgAlocMgmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] asgnTtlWgt = (JSPUtil.getParameter(request, prefix	+ "asgn_ttl_wgt", length));
			String[] raplyCfmFlg = (JSPUtil.getParameter(request, prefix	+ "raply_cfm_flg", length));
			String[] n1stTsPodCntCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pod_cnt_cd", length));
			String[] bkgCtrlTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] n2ndTsPodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_pod_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] alocAplyFmDt = (JSPUtil.getParameter(request, prefix	+ "aloc_aply_fm_dt", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] aplyToYrwk = (JSPUtil.getParameter(request, prefix	+ "aply_to_yrwk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] alocLodQtyRto = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty_rto", length));
			String[] aplyFmYrwk = (JSPUtil.getParameter(request, prefix	+ "aply_fm_yrwk", length));
			String[] scgGrpCmdtSeq = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_seq", length));
			String[] trnkDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_dir_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] n1stTsPolCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] n1stTsDirCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_dir_cd", length));
			String[] bkgAlocRmk = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_rmk", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] alocUseFlg = (JSPUtil.getParameter(request, prefix	+ "aloc_use_flg", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] bkgDelSccCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_scc_cd", length));
			String[] usaBkgModCd = (JSPUtil.getParameter(request, prefix	+ "usa_bkg_mod_cd", length));
			String[] n1stTsPodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pod_cd", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] n2ndTsSlanCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_slan_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] alocLodQty = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] bkgDelCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cmpbAmt = (JSPUtil.getParameter(request, prefix	+ "cmpb_amt", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] trnkSlanCd = (JSPUtil.getParameter(request, prefix	+ "trnk_slan_cd", length));
			String[] bkgPolCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cnt_cd", length));
			String[] asgnWgtRto = (JSPUtil.getParameter(request, prefix	+ "asgn_wgt_rto", length));
			String[] bkgAlocTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_tp_cd", length));
			String[] n1stTsSlanCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_slan_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] alocSvcCd = (JSPUtil.getParameter(request, prefix	+ "aloc_svc_cd", length));
			String[] oftChgAmt = (JSPUtil.getParameter(request, prefix	+ "oft_chg_amt", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] alocAplyToDt = (JSPUtil.getParameter(request, prefix	+ "aloc_aply_to_dt", length));
			String[] n2ndTsPolCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_pol_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] n1stTsPolCntCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pol_cnt_cd", length));
			String[] bkgPorSccCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_scc_cd", length));
			String[] bkgAlocSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_seq", length));
			String[] bkgPorCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cnt_cd", length));
			String[] bkgPodCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpcBkgAlocMgmtVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (asgnTtlWgt[i] != null)
					model.setAsgnTtlWgt(asgnTtlWgt[i]);
				if (raplyCfmFlg[i] != null)
					model.setRaplyCfmFlg(raplyCfmFlg[i]);
				if (n1stTsPodCntCd[i] != null)
					model.setN1stTsPodCntCd(n1stTsPodCntCd[i]);
				if (bkgCtrlTpCd[i] != null)
					model.setBkgCtrlTpCd(bkgCtrlTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (n2ndTsPodCd[i] != null)
					model.setN2ndTsPodCd(n2ndTsPodCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (alocAplyFmDt[i] != null)
					model.setAlocAplyFmDt(alocAplyFmDt[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (aplyToYrwk[i] != null)
					model.setAplyToYrwk(aplyToYrwk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (ctrtCustSeq[i] != null)
					model.setCtrtCustSeq(ctrtCustSeq[i]);
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
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (n1stTsPolCd[i] != null)
					model.setN1stTsPolCd(n1stTsPolCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (n1stTsDirCd[i] != null)
					model.setN1stTsDirCd(n1stTsDirCd[i]);
				if (bkgAlocRmk[i] != null)
					model.setBkgAlocRmk(bkgAlocRmk[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
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
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (alocLodQty[i] != null)
					model.setAlocLodQty(alocLodQty[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (bkgDelCntCd[i] != null)
					model.setBkgDelCntCd(bkgDelCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cmpbAmt[i] != null)
					model.setCmpbAmt(cmpbAmt[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (trnkSlanCd[i] != null)
					model.setTrnkSlanCd(trnkSlanCd[i]);
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
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (alocAplyToDt[i] != null)
					model.setAlocAplyToDt(alocAplyToDt[i]);
				if (n2ndTsPolCd[i] != null)
					model.setN2ndTsPolCd(n2ndTsPolCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (n1stTsPolCntCd[i] != null)
					model.setN1stTsPolCntCd(n1stTsPolCntCd[i]);
				if (bkgPorSccCd[i] != null)
					model.setBkgPorSccCd(bkgPorSccCd[i]);
				if (bkgAlocSeq[i] != null)
					model.setBkgAlocSeq(bkgAlocSeq[i]);
				if (bkgPorCntCd[i] != null)
					model.setBkgPorCntCd(bkgPorCntCd[i]);
				if (bkgPodCntCd[i] != null)
					model.setBkgPodCntCd(bkgPodCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpcBkgAlocMgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpcBkgAlocMgmtVO[]
	 */
	public SpcBkgAlocMgmtVO[] getSpcBkgAlocMgmtVOs(){
		SpcBkgAlocMgmtVO[] vos = (SpcBkgAlocMgmtVO[])models.toArray(new SpcBkgAlocMgmtVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnTtlWgt = this.asgnTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raplyCfmFlg = this.raplyCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPodCntCd = this.n1stTsPodCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlTpCd = this.bkgCtrlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsPodCd = this.n2ndTsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocAplyFmDt = this.alocAplyFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyToYrwk = this.aplyToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQtyRto = this.alocLodQtyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyFmYrwk = this.aplyFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtSeq = this.scgGrpCmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkDirCd = this.trnkDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPolCd = this.n1stTsPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsDirCd = this.n1stTsDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocRmk = this.bkgAlocRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocUseFlg = this.alocUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelSccCd = this.bkgDelSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaBkgModCd = this.usaBkgModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPodCd = this.n1stTsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsSlanCd = this.n2ndTsSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQty = this.alocLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCntCd = this.bkgDelCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbAmt = this.cmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSlanCd = this.trnkSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCntCd = this.bkgPolCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnWgtRto = this.asgnWgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocTpCd = this.bkgAlocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsSlanCd = this.n1stTsSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocSvcCd = this.alocSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftChgAmt = this.oftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocAplyToDt = this.alocAplyToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsPolCd = this.n2ndTsPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPolCntCd = this.n1stTsPolCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorSccCd = this.bkgPorSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocSeq = this.bkgAlocSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCntCd = this.bkgPorCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCntCd = this.bkgPodCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
