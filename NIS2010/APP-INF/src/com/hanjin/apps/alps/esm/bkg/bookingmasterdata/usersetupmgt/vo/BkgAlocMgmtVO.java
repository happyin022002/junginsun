/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgAlocMgmtVO.java
*@FileTitle : BkgAlocMgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo;

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

public class BkgAlocMgmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgAlocMgmtVO> models = new ArrayList<BkgAlocMgmtVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String bkgDelSccCd = null;
	/* Column Info */
	private String n1stTsPodCd = null;
	/* Column Info */
	private String n2ndTsSlanCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String laneCnt = null;
	/* Column Info */
	private String alocLodQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cmdtCnt = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String scgGrpCmdtSeq = null;
	/* Column Info */
	private String scgGrpCmdtDesc = null;
	/* Column Info */
	private String n2ndTsPodCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String trnkSlanCd = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String n1stTsSlanCd = null;
	/* Column Info */
	private String bkgAlocTpCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String alocLodQtyRto = null;
	/* Column Info */
	private String ctrtCustSeq = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String alocSvcCd = null;
	/* Column Info */
	private String trnkDirCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String n1stTsPolCd = null;
	/* Column Info */
	private String n1stTsDirCd = null;
	/* Column Info */
	private String n1stTsPolCntCd = null;
	/* Column Info */
	private String n1stTsPodCntCd = null;
	/* Column Info */
	private String n2ndTsPolCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgPorSccCd = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String bkgAlocSeq = null;
	/* Column Info */
	private String dirCnt = null;
	/* Column Info */
	private String bkgAlocRmk = null;
	/* Column Info */
	private String alocUseFlg = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String valType = null;
	/* Column Info */
	private String valValue = null;
	/* Column Info */
	private String valCnt = null;
	/* Column Info */
	private String bkgPorCntCd = null;
	/* Column Info */
	private String bkgPolCntCd = null;
	/* Column Info */
	private String bkgPodCntCd = null;
	/* Column Info */
	private String bkgDelCntCd = null;
	/* Column Info */
	private String trunkPolCd = null;
	/* Column Info */
	private String trunkPodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgAlocMgmtVO() {}

	public BkgAlocMgmtVO(String ibflag, String pagerows, String bkgAlocSeq, String valType, String n1stTsDirCd, String n1stTsPolCntCd, String n1stTsPodCntCd, String valValue, String valCnt, String bkgPorCntCd, String bkgPolCntCd, String bkgPodCntCd, String bkgDelCntCd, String trunkPodCd, String trunkPolCd, String bkgAlocTpCd, String vvd, String slsRhqCd, String trnkSlanCd, String trnkDirCd, String obSlsOfcCd, String porCd, String porNodCd, String bkgPorSccCd, String polCd, String polNodCd, String n1stTsSlanCd, String n1stTsPolCd, String n1stTsPodCd, String n2ndTsSlanCd, String n2ndTsPolCd, String n2ndTsPodCd, String podCd, String podNodCd, String delCd, String delNodCd, String bkgDelSccCd, String scNo, String rfaNo, String ctrtCustCntCd, String ctrtCustSeq, String custCntCd, String custSeq, String cntrTpszCd, String cmdtCd, String scgGrpCmdtSeq, String scgGrpCmdtDesc, String cmdtNm, String alocLodQty, String alocLodQtyRto, String alocSvcCd, String bkgAlocRmk, String alocUseFlg, String creUsrId, String creDt, String updUsrId, String updDt, String laneCnt, String dirCnt, String cmdtCnt) {
		this.porCd = porCd;
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.bkgDelSccCd = bkgDelSccCd;
		this.n1stTsPodCd = n1stTsPodCd;
		this.n2ndTsSlanCd = n2ndTsSlanCd;
		this.creDt = creDt;
		this.laneCnt = laneCnt;
		this.alocLodQty = alocLodQty;
		this.pagerows = pagerows;
		this.cmdtCnt = cmdtCnt;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.scgGrpCmdtSeq = scgGrpCmdtSeq;
		this.scgGrpCmdtDesc = scgGrpCmdtDesc;
		this.n2ndTsPodCd = n2ndTsPodCd;
		this.scNo = scNo;
		this.rfaNo = rfaNo;
		this.cntrTpszCd = cntrTpszCd;
		this.trnkSlanCd = trnkSlanCd;
		this.obSlsOfcCd = obSlsOfcCd;
		this.delNodCd = delNodCd;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.n1stTsSlanCd = n1stTsSlanCd;
		this.bkgAlocTpCd = bkgAlocTpCd;
		this.updDt = updDt;
		this.alocLodQtyRto = alocLodQtyRto;
		this.ctrtCustSeq = ctrtCustSeq;
		this.porNodCd = porNodCd;
		this.alocSvcCd = alocSvcCd;
		this.trnkDirCd = trnkDirCd;
		this.delCd = delCd;
		this.polNodCd = polNodCd;
		this.custSeq = custSeq;
		this.cmdtNm = cmdtNm;
		this.n1stTsPolCd = n1stTsPolCd;
		this.n1stTsDirCd = n1stTsDirCd;
		this.n1stTsPolCntCd = n1stTsPolCntCd;
		this.n1stTsPodCntCd = n1stTsPodCntCd;
		this.n2ndTsPolCd = n2ndTsPolCd;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.bkgPorSccCd = bkgPorSccCd;
		this.podNodCd = podNodCd;
		this.bkgAlocSeq = bkgAlocSeq;
		this.dirCnt = dirCnt;
		this.bkgAlocRmk = bkgAlocRmk;
		this.alocUseFlg = alocUseFlg;
		this.vvd = vvd;
		this.slsRhqCd = slsRhqCd;
		this.valType = valType;
		this.valValue = valValue;
		this.valCnt = valCnt;
		this.bkgPorCntCd = bkgPorCntCd;
		this.bkgPolCntCd = bkgPolCntCd;
		this.bkgPodCntCd = bkgPodCntCd;
		this.bkgDelCntCd = bkgDelCntCd;
		this.trunkPolCd = trunkPolCd;
		this.trunkPodCd = trunkPodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("bkg_del_scc_cd", getBkgDelSccCd());
		this.hashColumns.put("n1st_ts_pod_cd", getN1stTsPodCd());
		this.hashColumns.put("n2nd_ts_slan_cd", getN2ndTsSlanCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("lane_cnt", getLaneCnt());
		this.hashColumns.put("aloc_lod_qty", getAlocLodQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cmdt_cnt", getCmdtCnt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("scg_grp_cmdt_seq", getScgGrpCmdtSeq());
		this.hashColumns.put("scg_grp_cmdt_desc", getScgGrpCmdtDesc());
		this.hashColumns.put("n2nd_ts_pod_cd", getN2ndTsPodCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("trnk_slan_cd", getTrnkSlanCd());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("n1st_ts_slan_cd", getN1stTsSlanCd());
		this.hashColumns.put("bkg_aloc_tp_cd", getBkgAlocTpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("aloc_lod_qty_rto", getAlocLodQtyRto());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("aloc_svc_cd", getAlocSvcCd());
		this.hashColumns.put("trnk_dir_cd", getTrnkDirCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("n1st_ts_pol_cd", getN1stTsPolCd());
		this.hashColumns.put("n1st_ts_dir_cd", getN1stTsDirCd());
		this.hashColumns.put("n1st_ts_pol_cnt_cd", getN1stTsPolCntCd());
		this.hashColumns.put("n1st_ts_pod_cnt_cd", getN1stTsPodCntCd());
		this.hashColumns.put("n2nd_ts_pol_cd", getN2ndTsPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_por_scc_cd", getBkgPorSccCd());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("bkg_aloc_seq", getBkgAlocSeq());
		this.hashColumns.put("dir_cnt", getDirCnt());
		this.hashColumns.put("bkg_aloc_rmk", getBkgAlocRmk());
		this.hashColumns.put("aloc_use_flg", getAlocUseFlg());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("val_type", getValType());
		this.hashColumns.put("val_value", getValValue());
		this.hashColumns.put("val_cnt", getValCnt());
		this.hashColumns.put("bkg_por_cnt_cd", getBkgPorCntCd());
		this.hashColumns.put("bkg_pol_cnt_cd", getBkgPolCntCd());
		this.hashColumns.put("bkg_pod_cnt_cd", getBkgPodCntCd());
		this.hashColumns.put("bkg_del_cnt_cd", getBkgDelCntCd());
		this.hashColumns.put("trunk_pol_cd", getTrunkPolCd());
		this.hashColumns.put("trunk_pod_cd", getTrunkPodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("bkg_del_scc_cd", "bkgDelSccCd");
		this.hashFields.put("n1st_ts_pod_cd", "n1stTsPodCd");
		this.hashFields.put("n2nd_ts_slan_cd", "n2ndTsSlanCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("lane_cnt", "laneCnt");
		this.hashFields.put("aloc_lod_qty", "alocLodQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cmdt_cnt", "cmdtCnt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("scg_grp_cmdt_seq", "scgGrpCmdtSeq");
		this.hashFields.put("scg_grp_cmdt_desc", "scgGrpCmdtDesc");
		this.hashFields.put("n2nd_ts_pod_cd", "n2ndTsPodCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("trnk_slan_cd", "trnkSlanCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("n1st_ts_slan_cd", "n1stTsSlanCd");
		this.hashFields.put("bkg_aloc_tp_cd", "bkgAlocTpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("aloc_lod_qty_rto", "alocLodQtyRto");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("aloc_svc_cd", "alocSvcCd");
		this.hashFields.put("trnk_dir_cd", "trnkDirCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("n1st_ts_pol_cd", "n1stTsPolCd");
		this.hashFields.put("n1st_ts_dir_cd", "n1stTsDirCd");
		this.hashFields.put("n1st_ts_pol_cnt_cd", "n1stTsPolCntCd");
		this.hashFields.put("n1st_ts_pod_cnt_cd", "n1stTsPodCntCd");
		this.hashFields.put("n2nd_ts_pol_cd", "n2ndTsPolCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_por_scc_cd", "bkgPorSccCd");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("bkg_aloc_seq", "bkgAlocSeq");
		this.hashFields.put("dir_cnt", "dirCnt");
		this.hashFields.put("bkg_aloc_rmk", "bkgAlocRmk");
		this.hashFields.put("aloc_use_flg", "alocUseFlg");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("val_type", "valType");
		this.hashFields.put("val_value", "valValue");
		this.hashFields.put("val_cnt", "valCnt");
		this.hashFields.put("bkg_por_cnt_cd", "bkgPorCntCd");
		this.hashFields.put("bkg_pol_cnt_cd", "bkgPolCntCd");
		this.hashFields.put("bkg_pod_cnt_cd", "bkgPodCntCd");
		this.hashFields.put("bkg_del_cnt_cd", "bkgDelCntCd");
		this.hashFields.put("trunk_pol_cd", "trunkPolCd");
		this.hashFields.put("trunk_pod_cd", "trunkPodCd");
		return this.hashFields;
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
	 * @return n1stTsPodCd
	 */
	public String getN1stTsPodCd() {
		return this.n1stTsPodCd;
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
	 * @return laneCnt
	 */
	public String getLaneCnt() {
		return this.laneCnt;
	}
	
	/**
	 * Column Info
	 * @return alocLodQty
	 */
	public String getAlocLodQty() {
		return this.alocLodQty;
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
	 * @return cmdtCnt
	 */
	public String getCmdtCnt() {
		return this.cmdtCnt;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
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
	 * @return scgGrpCmdtDesc
	 */
	public String getScgGrpCmdtDesc() {
		return this.scgGrpCmdtDesc;
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
	 * @return trnkSlanCd
	 */
	public String getTrnkSlanCd() {
		return this.trnkSlanCd;
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
	 * @return n1stTsSlanCd
	 */
	public String getN1stTsSlanCd() {
		return this.n1stTsSlanCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return ctrtCustSeq
	 */
	public String getCtrtCustSeq() {
		return this.ctrtCustSeq;
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
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return n1stTsDirCd
	 */
	public String getN1stTsDirCd() {
		return this.n1stTsDirCd;
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
	 * @return n1stTsPodCntCd
	 */
	public String getN1stTsPodCntCd() {
		return this.n1stTsPodCntCd;
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
	 * @return bkgPorSccCd
	 */
	public String getBkgPorSccCd() {
		return this.bkgPorSccCd;
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
	 * @return bkgAlocSeq
	 */
	public String getBkgAlocSeq() {
		return this.bkgAlocSeq;
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
	 * @return bkgAlocRmk
	 */
	public String getBkgAlocRmk() {
		return this.bkgAlocRmk;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return valType
	 */
	public String getValType() {
		return this.valType;
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
	 * @return valCnt
	 */
	public String getValCnt() {
		return this.valCnt;
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
	 * @return bkgPolCntCd
	 */
	public String getBkgPolCntCd() {
		return this.bkgPolCntCd;
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
	 * @return bkgDelCntCd
	 */
	public String getBkgDelCntCd() {
		return this.bkgDelCntCd;
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
	 * @return trunkPodCd
	 */
	public String getTrunkPodCd() {
		return this.trunkPodCd;
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
	 * @param n1stTsPodCd
	 */
	public void setN1stTsPodCd(String n1stTsPodCd) {
		this.n1stTsPodCd = n1stTsPodCd;
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
	 * @param laneCnt
	 */
	public void setLaneCnt(String laneCnt) {
		this.laneCnt = laneCnt;
	}
	
	/**
	 * Column Info
	 * @param alocLodQty
	 */
	public void setAlocLodQty(String alocLodQty) {
		this.alocLodQty = alocLodQty;
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
	 * @param cmdtCnt
	 */
	public void setCmdtCnt(String cmdtCnt) {
		this.cmdtCnt = cmdtCnt;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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
	 * @param scgGrpCmdtDesc
	 */
	public void setScgGrpCmdtDesc(String scgGrpCmdtDesc) {
		this.scgGrpCmdtDesc = scgGrpCmdtDesc;
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
	 * @param trnkSlanCd
	 */
	public void setTrnkSlanCd(String trnkSlanCd) {
		this.trnkSlanCd = trnkSlanCd;
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
	 * @param n1stTsSlanCd
	 */
	public void setN1stTsSlanCd(String n1stTsSlanCd) {
		this.n1stTsSlanCd = n1stTsSlanCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param ctrtCustSeq
	 */
	public void setCtrtCustSeq(String ctrtCustSeq) {
		this.ctrtCustSeq = ctrtCustSeq;
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
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param n1stTsDirCd
	 */
	public void setN1stTsDirCd(String n1stTsDirCd) {
		this.n1stTsDirCd = n1stTsDirCd;
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
	 * @param n1stTsPodCntCd
	 */
	public void setN1stTsPodCntCd(String n1stTsPodCntCd) {
		this.n1stTsPodCntCd = n1stTsPodCntCd;
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
	 * @param bkgPorSccCd
	 */
	public void setBkgPorSccCd(String bkgPorSccCd) {
		this.bkgPorSccCd = bkgPorSccCd;
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
	 * @param bkgAlocSeq
	 */
	public void setBkgAlocSeq(String bkgAlocSeq) {
		this.bkgAlocSeq = bkgAlocSeq;
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
	 * @param bkgAlocRmk
	 */
	public void setBkgAlocRmk(String bkgAlocRmk) {
		this.bkgAlocRmk = bkgAlocRmk;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param valType
	 */
	public void setValType(String valType) {
		this.valType = valType;
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
	 * @param valCnt
	 */
	public void setValCnt(String valCnt) {
		this.valCnt = valCnt;
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
	 * @param bkgPolCntCd
	 */
	public void setBkgPolCntCd(String bkgPolCntCd) {
		this.bkgPolCntCd = bkgPolCntCd;
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
	 * @param bkgDelCntCd
	 */
	public void setBkgDelCntCd(String bkgDelCntCd) {
		this.bkgDelCntCd = bkgDelCntCd;
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
	 * @param trunkPodCd
	 */
	public void setTrunkPodCd(String trunkPodCd) {
		this.trunkPodCd = trunkPodCd;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCtrtCustCntCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_cd", ""));
		setBkgDelSccCd(JSPUtil.getParameter(request, prefix + "bkg_del_scc_cd", ""));
		setN1stTsPodCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pod_cd", ""));
		setN2ndTsSlanCd(JSPUtil.getParameter(request, prefix + "n2nd_ts_slan_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setLaneCnt(JSPUtil.getParameter(request, prefix + "lane_cnt", ""));
		setAlocLodQty(JSPUtil.getParameter(request, prefix + "aloc_lod_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCmdtCnt(JSPUtil.getParameter(request, prefix + "cmdt_cnt", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setScgGrpCmdtSeq(JSPUtil.getParameter(request, prefix + "scg_grp_cmdt_seq", ""));
		setScgGrpCmdtDesc(JSPUtil.getParameter(request, prefix + "scg_grp_cmdt_desc", ""));
		setN2ndTsPodCd(JSPUtil.getParameter(request, prefix + "n2nd_ts_pod_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setTrnkSlanCd(JSPUtil.getParameter(request, prefix + "trnk_slan_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setN1stTsSlanCd(JSPUtil.getParameter(request, prefix + "n1st_ts_slan_cd", ""));
		setBkgAlocTpCd(JSPUtil.getParameter(request, prefix + "bkg_aloc_tp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setAlocLodQtyRto(JSPUtil.getParameter(request, prefix + "aloc_lod_qty_rto", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, prefix + "ctrt_cust_seq", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setAlocSvcCd(JSPUtil.getParameter(request, prefix + "aloc_svc_cd", ""));
		setTrnkDirCd(JSPUtil.getParameter(request, prefix + "trnk_dir_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setN1stTsPolCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pol_cd", ""));
		setN1stTsDirCd(JSPUtil.getParameter(request, prefix + "n1st_ts_dir_cd", ""));
		setN1stTsPolCntCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pol_cnt_cd", ""));
		setN1stTsPodCntCd(JSPUtil.getParameter(request, prefix + "n1st_ts_pod_cnt_cd", ""));
		setN2ndTsPolCd(JSPUtil.getParameter(request, prefix + "n2nd_ts_pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgPorSccCd(JSPUtil.getParameter(request, prefix + "bkg_por_scc_cd", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setBkgAlocSeq(JSPUtil.getParameter(request, prefix + "bkg_aloc_seq", ""));
		setDirCnt(JSPUtil.getParameter(request, prefix + "dir_cnt", ""));
		setBkgAlocRmk(JSPUtil.getParameter(request, prefix + "bkg_aloc_rmk", ""));
		setAlocUseFlg(JSPUtil.getParameter(request, prefix + "aloc_use_flg", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setValType(JSPUtil.getParameter(request, prefix + "val_type", ""));
		setValValue(JSPUtil.getParameter(request, prefix + "val_value", ""));
		setValCnt(JSPUtil.getParameter(request, prefix + "val_cnt", "")); 
		setBkgPorCntCd(JSPUtil.getParameter(request, prefix + "bkg_por_cnt_cd", ""));
		setBkgPolCntCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cnt_cd", ""));
		setBkgPodCntCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cnt_cd", ""));
		setBkgDelCntCd(JSPUtil.getParameter(request, prefix + "bkg_del_cnt_cd", ""));
		setTrunkPolCd(JSPUtil.getParameter(request, prefix + "trunk_pol_cd", ""));
		setTrunkPodCd(JSPUtil.getParameter(request, prefix + "trunk_pod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgAlocMgmtVO[]
	 */
	public BkgAlocMgmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgAlocMgmtVO[]
	 */
	public BkgAlocMgmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgAlocMgmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] bkgDelSccCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_scc_cd", length));
			String[] n1stTsPodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pod_cd", length));
			String[] n2ndTsSlanCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_slan_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] laneCnt = (JSPUtil.getParameter(request, prefix	+ "lane_cnt", length));
			String[] alocLodQty = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cmdtCnt = (JSPUtil.getParameter(request, prefix	+ "cmdt_cnt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] scgGrpCmdtSeq = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_seq", length));
			String[] scgGrpCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_desc", length));
			String[] n2ndTsPodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_pod_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] trnkSlanCd = (JSPUtil.getParameter(request, prefix	+ "trnk_slan_cd", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] n1stTsSlanCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_slan_cd", length));
			String[] bkgAlocTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_tp_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] alocLodQtyRto = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty_rto", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] alocSvcCd = (JSPUtil.getParameter(request, prefix	+ "aloc_svc_cd", length));
			String[] trnkDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_dir_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] n1stTsPolCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pol_cd", length));
			String[] n1stTsDirCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_dir_cd", length));
			String[] n1stTsPolCntCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pol_cnt_cd", length));
			String[] n1stTsPodCntCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_pod_cnt_cd", length));
			String[] n2ndTsPolCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgPorSccCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_scc_cd", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] bkgAlocSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_seq", length));
			String[] dirCnt = (JSPUtil.getParameter(request, prefix	+ "dir_cnt", length));
			String[] bkgAlocRmk = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_rmk", length));
			String[] alocUseFlg = (JSPUtil.getParameter(request, prefix	+ "aloc_use_flg", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] valType = (JSPUtil.getParameter(request, prefix	+ "val_type", length));
			String[] valValue = (JSPUtil.getParameter(request, prefix	+ "val_value", length));
			String[] valCnt = (JSPUtil.getParameter(request, prefix	+ "val_cnt", length));
			String[] bkgPorCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cnt_cd", length));
			String[] bkgPolCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cnt_cd", length));
			String[] bkgPodCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cnt_cd", length));
			String[] bkgDelCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cnt_cd", length));
			String[] trunkPolCd = (JSPUtil.getParameter(request, prefix	+ "trunk_pol_cd", length));
			String[] trunkPodCd = (JSPUtil.getParameter(request, prefix	+ "trunk_pod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgAlocMgmtVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (bkgDelSccCd[i] != null)
					model.setBkgDelSccCd(bkgDelSccCd[i]);
				if (n1stTsPodCd[i] != null)
					model.setN1stTsPodCd(n1stTsPodCd[i]);
				if (n2ndTsSlanCd[i] != null)
					model.setN2ndTsSlanCd(n2ndTsSlanCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (laneCnt[i] != null)
					model.setLaneCnt(laneCnt[i]);
				if (alocLodQty[i] != null)
					model.setAlocLodQty(alocLodQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cmdtCnt[i] != null)
					model.setCmdtCnt(cmdtCnt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (scgGrpCmdtSeq[i] != null)
					model.setScgGrpCmdtSeq(scgGrpCmdtSeq[i]);
				if (scgGrpCmdtDesc[i] != null)
					model.setScgGrpCmdtDesc(scgGrpCmdtDesc[i]);
				if (n2ndTsPodCd[i] != null)
					model.setN2ndTsPodCd(n2ndTsPodCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (trnkSlanCd[i] != null)
					model.setTrnkSlanCd(trnkSlanCd[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (n1stTsSlanCd[i] != null)
					model.setN1stTsSlanCd(n1stTsSlanCd[i]);
				if (bkgAlocTpCd[i] != null)
					model.setBkgAlocTpCd(bkgAlocTpCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (alocLodQtyRto[i] != null)
					model.setAlocLodQtyRto(alocLodQtyRto[i]);
				if (ctrtCustSeq[i] != null)
					model.setCtrtCustSeq(ctrtCustSeq[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (alocSvcCd[i] != null)
					model.setAlocSvcCd(alocSvcCd[i]);
				if (trnkDirCd[i] != null)
					model.setTrnkDirCd(trnkDirCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (n1stTsPolCd[i] != null)
					model.setN1stTsPolCd(n1stTsPolCd[i]);
				if (n1stTsDirCd[i] != null)
					model.setN1stTsDirCd(n1stTsDirCd[i]);
				if (n1stTsPolCntCd[i] != null)
					model.setN1stTsPolCntCd(n1stTsPolCntCd[i]);
				if (n1stTsPodCntCd[i] != null)
					model.setN1stTsPodCntCd(n1stTsPodCntCd[i]);
				if (n2ndTsPolCd[i] != null)
					model.setN2ndTsPolCd(n2ndTsPolCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgPorSccCd[i] != null)
					model.setBkgPorSccCd(bkgPorSccCd[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (bkgAlocSeq[i] != null)
					model.setBkgAlocSeq(bkgAlocSeq[i]);
				if (dirCnt[i] != null)
					model.setDirCnt(dirCnt[i]);
				if (bkgAlocRmk[i] != null)
					model.setBkgAlocRmk(bkgAlocRmk[i]);
				if (alocUseFlg[i] != null)
					model.setAlocUseFlg(alocUseFlg[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (valType[i] != null)
					model.setValType(valType[i]);
				if (valValue[i] != null)
					model.setValValue(valValue[i]);
				if (valCnt[i] != null)
					model.setValCnt(valCnt[i]);
				if (bkgPorCntCd[i] != null)
					model.setBkgPorCntCd(bkgPorCntCd[i]);
				if (bkgPolCntCd[i] != null)
					model.setBkgPolCntCd(bkgPolCntCd[i]);
				if (bkgPodCntCd[i] != null)
					model.setBkgPodCntCd(bkgPodCntCd[i]);
				if (bkgDelCntCd[i] != null)
					model.setBkgDelCntCd(bkgDelCntCd[i]);
				if (trunkPolCd[i] != null)
					model.setTrunkPolCd(trunkPolCd[i]);
				if (trunkPodCd[i] != null)
					model.setTrunkPodCd(trunkPodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgAlocMgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgAlocMgmtVO[]
	 */
	public BkgAlocMgmtVO[] getBkgAlocMgmtVOs(){
		BkgAlocMgmtVO[] vos = (BkgAlocMgmtVO[])models.toArray(new BkgAlocMgmtVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelSccCd = this.bkgDelSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPodCd = this.n1stTsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsSlanCd = this.n2ndTsSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCnt = this.laneCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQty = this.alocLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCnt = this.cmdtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtSeq = this.scgGrpCmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtDesc = this.scgGrpCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsPodCd = this.n2ndTsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSlanCd = this.trnkSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsSlanCd = this.n1stTsSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocTpCd = this.bkgAlocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQtyRto = this.alocLodQtyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocSvcCd = this.alocSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkDirCd = this.trnkDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPolCd = this.n1stTsPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsDirCd = this.n1stTsDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPolCntCd = this.n1stTsPolCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPodCntCd = this.n1stTsPodCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsPolCd = this.n2ndTsPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorSccCd = this.bkgPorSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocSeq = this.bkgAlocSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCnt = this.dirCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocRmk = this.bkgAlocRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocUseFlg = this.alocUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valType = this.valType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valValue = this.valValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valCnt = this.valCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCntCd = this.bkgPorCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCntCd = this.bkgPolCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCntCd = this.bkgPodCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCntCd = this.bkgDelCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPolCd = this.trunkPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPodCd = this.trunkPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
