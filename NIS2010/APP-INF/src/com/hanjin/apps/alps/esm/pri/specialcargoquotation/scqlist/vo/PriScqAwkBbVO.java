/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PriScqAwkBbVO.java
*@FileTitle : PriScqAwkBbVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.12
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.12 송호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriScqAwkBbVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriScqAwkBbVO> models = new ArrayList<PriScqAwkBbVO>();
	
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String ttlDimWdt = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String ovrVoidSltQty = null;
	/* Column Info */
	private String scqRqstNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String progDt = null;
	/* Column Info */
	private String propBsrtAmt = null;
	/* Column Info */
	private String ttlDimHgt = null;
	/* Column Info */
	private String propEffDt = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String propRt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ovrBkwdLen = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String aproExpDt = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String cntrTpSz = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String grsWgi = null;
	/* Column Info */
	private String podSum = null;
	/* Column Info */
	private String rqstSrepCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String ovrLfLen = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String toperiod = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ovrFwrdLen = null;
	/* Column Info */
	private String scqRqstNo2 = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String propExpDt = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String ovrRtLen = null;
	/* Column Info */
	private String tpCd = null;
	/* Column Info */
	private String scqVerNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String aproBsrtAmt = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String polSum = null;
	/* Column Info */
	private String rqstUsrNm = null;
	/* Column Info */
	private String ttlDimLen = null;
	/* Column Info */
	private String aproEffDt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String measSysCd = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String aproVoidRtAmt = null;
	/* Column Info */
	private String aproUsrNm = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String fmperiod = null;
	/* Column Info */
	private String propVoidRtAmt = null;
	/* Column Info */
	private String aproRt = null;
	/* Column Info */
	private String progStsCd = null;
	/* Column Info */
	private String actCustNm = null;
	/* Column Info */
	private String cgoType = null;
	/* Column Info */
	private String ovrHgt = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String podYdCd = null;

	/* Column Info */
	private List<PriScqBbCntrVO> priScqBbCntrVOs = null;
	/* Column Info */
	private List<PriScqBbCgoDtlVO> priScqBbCgoDtlVos = null;
	/* Column Info */
	private List<PriScqBbHandlingCstVO> priScqBbHandlingCstVos = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PriScqAwkBbVO() {}

	public PriScqAwkBbVO(String ibflag, String pagerows, String actCustCntCd, String actCustNm, String actCustSeq, String aproBsrtAmt, String aproEffDt, String aproExpDt, String aproOfcCd, String aproRt, String aproVoidRtAmt, String cgoType, String cmdtCd, String cmdtNm, String cntrQty, String cntrTpSz, String cntrTpszCd, String creDt, String creUsrId, String custCd, String custCntCd, String custNm, String custSeq, String deTermCd, String delCd, String deltFlg, String fmperiod, String grsWgi, String grsWgt, String ovrBkwdLen, String ovrFwrdLen, String ovrHgt, String ovrLfLen, String ovrRtLen, String ovrVoidSltQty, String podCd, String podSum, String podYdCd, String polCd, String polSum, String polYdCd, String porCd, String progDt, String progStsCd, String propBsrtAmt, String propEffDt, String propExpDt, String propRt, String propVoidRtAmt, String rcvTermCd, String rqstOfcCd, String rqstSrepCd, String scqRqstNo, String scqRqstNo2, String scqVerNo, String stsCd, String svcScpCd, String toperiod, String tpCd, String ttlDimHgt, String ttlDimLen, String ttlDimWdt, String updDt, String updUsrId, String measSysCd, String rqstUsrNm, String rqstDt, String aproUsrNm, String aproDt) {
		this.custCd = custCd;
		this.ttlDimWdt = ttlDimWdt;
		this.polYdCd = polYdCd;
		this.ovrVoidSltQty = ovrVoidSltQty;
		this.scqRqstNo = scqRqstNo;
		this.updUsrId = updUsrId;
		this.progDt = progDt;
		this.propBsrtAmt = propBsrtAmt;
		this.ttlDimHgt = ttlDimHgt;
		this.propEffDt = propEffDt;
		this.cntrQty = cntrQty;
		this.propRt = propRt;
		this.pagerows = pagerows;
		this.ovrBkwdLen = ovrBkwdLen;
		this.grsWgt = grsWgt;
		this.aproExpDt = aproExpDt;
		this.deTermCd = deTermCd;
		this.deltFlg = deltFlg;
		this.rqstOfcCd = rqstOfcCd;
		this.cntrTpSz = cntrTpSz;
		this.creDt = creDt;
		this.grsWgi = grsWgi;
		this.podSum = podSum;
		this.rqstSrepCd = rqstSrepCd;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.actCustCntCd = actCustCntCd;
		this.ovrLfLen = ovrLfLen;
		this.stsCd = stsCd;
		this.cntrTpszCd = cntrTpszCd;
		this.aproDt = aproDt;
		this.updDt = updDt;
		this.toperiod = toperiod;
		this.ibflag = ibflag;
		this.ovrFwrdLen = ovrFwrdLen;
		this.scqRqstNo2 = scqRqstNo2;
		this.cmdtNm = cmdtNm;
		this.propExpDt = propExpDt;
		this.aproOfcCd = aproOfcCd;
		this.porCd = porCd;
		this.ovrRtLen = ovrRtLen;
		this.tpCd = tpCd;
		this.scqVerNo = scqVerNo;
		this.creUsrId = creUsrId;
		this.aproBsrtAmt = aproBsrtAmt;
		this.polCd = polCd;
		this.polSum = polSum;
		this.rqstUsrNm = rqstUsrNm;
		this.ttlDimLen = ttlDimLen;
		this.aproEffDt = aproEffDt;
		this.svcScpCd = svcScpCd;
		this.podCd = podCd;
		this.measSysCd = measSysCd;
		this.actCustSeq = actCustSeq;
		this.aproVoidRtAmt = aproVoidRtAmt;
		this.aproUsrNm = aproUsrNm;
		this.custNm = custNm;
		this.cmdtCd = cmdtCd;
		this.rqstDt = rqstDt;
		this.fmperiod = fmperiod;
		this.propVoidRtAmt = propVoidRtAmt;
		this.aproRt = aproRt;
		this.progStsCd = progStsCd;
		this.actCustNm = actCustNm;
		this.cgoType = cgoType;
		this.ovrHgt = ovrHgt;
		this.rcvTermCd = rcvTermCd;
		this.delCd = delCd;
		this.podYdCd = podYdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("ttl_dim_wdt", getTtlDimWdt());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("ovr_void_slt_qty", getOvrVoidSltQty());
		this.hashColumns.put("scq_rqst_no", getScqRqstNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("prog_dt", getProgDt());
		this.hashColumns.put("prop_bsrt_amt", getPropBsrtAmt());
		this.hashColumns.put("ttl_dim_hgt", getTtlDimHgt());
		this.hashColumns.put("prop_eff_dt", getPropEffDt());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("prop_rt", getPropRt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ovr_bkwd_len", getOvrBkwdLen());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("apro_exp_dt", getAproExpDt());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("cntr_tp_sz", getCntrTpSz());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("grs_wgi", getGrsWgi());
		this.hashColumns.put("pod_sum", getPodSum());
		this.hashColumns.put("rqst_srep_cd", getRqstSrepCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("ovr_lf_len", getOvrLfLen());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("toperiod", getToperiod());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ovr_fwrd_len", getOvrFwrdLen());
		this.hashColumns.put("scq_rqst_no2", getScqRqstNo2());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("prop_exp_dt", getPropExpDt());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("ovr_rt_len", getOvrRtLen());
		this.hashColumns.put("tp_cd", getTpCd());
		this.hashColumns.put("scq_ver_no", getScqVerNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("apro_bsrt_amt", getAproBsrtAmt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pol_sum", getPolSum());
		this.hashColumns.put("rqst_usr_nm", getRqstUsrNm());
		this.hashColumns.put("ttl_dim_len", getTtlDimLen());
		this.hashColumns.put("apro_eff_dt", getAproEffDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("meas_sys_cd", getMeasSysCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("apro_void_rt_amt", getAproVoidRtAmt());
		this.hashColumns.put("apro_usr_nm", getAproUsrNm());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("fmperiod", getFmperiod());
		this.hashColumns.put("prop_void_rt_amt", getPropVoidRtAmt());
		this.hashColumns.put("apro_rt", getAproRt());
		this.hashColumns.put("prog_sts_cd", getProgStsCd());
		this.hashColumns.put("act_cust_nm", getActCustNm());
		this.hashColumns.put("cgo_type", getCgoType());
		this.hashColumns.put("ovr_hgt", getOvrHgt());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("ttl_dim_wdt", "ttlDimWdt");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("ovr_void_slt_qty", "ovrVoidSltQty");
		this.hashFields.put("scq_rqst_no", "scqRqstNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("prog_dt", "progDt");
		this.hashFields.put("prop_bsrt_amt", "propBsrtAmt");
		this.hashFields.put("ttl_dim_hgt", "ttlDimHgt");
		this.hashFields.put("prop_eff_dt", "propEffDt");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("prop_rt", "propRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ovr_bkwd_len", "ovrBkwdLen");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("apro_exp_dt", "aproExpDt");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("cntr_tp_sz", "cntrTpSz");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("grs_wgi", "grsWgi");
		this.hashFields.put("pod_sum", "podSum");
		this.hashFields.put("rqst_srep_cd", "rqstSrepCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("ovr_lf_len", "ovrLfLen");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("toperiod", "toperiod");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ovr_fwrd_len", "ovrFwrdLen");
		this.hashFields.put("scq_rqst_no2", "scqRqstNo2");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("prop_exp_dt", "propExpDt");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("ovr_rt_len", "ovrRtLen");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("scq_ver_no", "scqVerNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("apro_bsrt_amt", "aproBsrtAmt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pol_sum", "polSum");
		this.hashFields.put("rqst_usr_nm", "rqstUsrNm");
		this.hashFields.put("ttl_dim_len", "ttlDimLen");
		this.hashFields.put("apro_eff_dt", "aproEffDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("meas_sys_cd", "measSysCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("apro_void_rt_amt", "aproVoidRtAmt");
		this.hashFields.put("apro_usr_nm", "aproUsrNm");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("fmperiod", "fmperiod");
		this.hashFields.put("prop_void_rt_amt", "propVoidRtAmt");
		this.hashFields.put("apro_rt", "aproRt");
		this.hashFields.put("prog_sts_cd", "progStsCd");
		this.hashFields.put("act_cust_nm", "actCustNm");
		this.hashFields.put("cgo_type", "cgoType");
		this.hashFields.put("ovr_hgt", "ovrHgt");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return ttlDimWdt
	 */
	public String getTtlDimWdt() {
		return this.ttlDimWdt;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return ovrVoidSltQty
	 */
	public String getOvrVoidSltQty() {
		return this.ovrVoidSltQty;
	}
	
	/**
	 * Column Info
	 * @return scqRqstNo
	 */
	public String getScqRqstNo() {
		return this.scqRqstNo;
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
	 * @return progDt
	 */
	public String getProgDt() {
		return this.progDt;
	}
	
	/**
	 * Column Info
	 * @return propBsrtAmt
	 */
	public String getPropBsrtAmt() {
		return this.propBsrtAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlDimHgt
	 */
	public String getTtlDimHgt() {
		return this.ttlDimHgt;
	}
	
	/**
	 * Column Info
	 * @return propEffDt
	 */
	public String getPropEffDt() {
		return this.propEffDt;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return propRt
	 */
	public String getPropRt() {
		return this.propRt;
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
	 * @return ovrBkwdLen
	 */
	public String getOvrBkwdLen() {
		return this.ovrBkwdLen;
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
	 * @return aproExpDt
	 */
	public String getAproExpDt() {
		return this.aproExpDt;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpSz
	 */
	public String getCntrTpSz() {
		return this.cntrTpSz;
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
	 * @return grsWgi
	 */
	public String getGrsWgi() {
		return this.grsWgi;
	}
	
	/**
	 * Column Info
	 * @return podSum
	 */
	public String getPodSum() {
		return this.podSum;
	}
	
	/**
	 * Column Info
	 * @return rqstSrepCd
	 */
	public String getRqstSrepCd() {
		return this.rqstSrepCd;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return ovrLfLen
	 */
	public String getOvrLfLen() {
		return this.ovrLfLen;
	}
	
	/**
	 * Column Info
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
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
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
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
	 * @return toperiod
	 */
	public String getToperiod() {
		return this.toperiod;
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
	 * @return ovrFwrdLen
	 */
	public String getOvrFwrdLen() {
		return this.ovrFwrdLen;
	}
	
	/**
	 * Column Info
	 * @return scqRqstNo2
	 */
	public String getScqRqstNo2() {
		return this.scqRqstNo2;
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
	 * @return propExpDt
	 */
	public String getPropExpDt() {
		return this.propExpDt;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
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
	 * @return ovrRtLen
	 */
	public String getOvrRtLen() {
		return this.ovrRtLen;
	}
	
	/**
	 * Column Info
	 * @return tpCd
	 */
	public String getTpCd() {
		return this.tpCd;
	}
	
	/**
	 * Column Info
	 * @return scqVerNo
	 */
	public String getScqVerNo() {
		return this.scqVerNo;
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
	 * @return aproBsrtAmt
	 */
	public String getAproBsrtAmt() {
		return this.aproBsrtAmt;
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
	 * @return polSum
	 */
	public String getPolSum() {
		return this.polSum;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrNm
	 */
	public String getRqstUsrNm() {
		return this.rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @return ttlDimLen
	 */
	public String getTtlDimLen() {
		return this.ttlDimLen;
	}
	
	/**
	 * Column Info
	 * @return aproEffDt
	 */
	public String getAproEffDt() {
		return this.aproEffDt;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return measSysCd
	 */
	public String getMeasSysCd() {
		return this.measSysCd;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return aproVoidRtAmt
	 */
	public String getAproVoidRtAmt() {
		return this.aproVoidRtAmt;
	}
	
	/**
	 * Column Info
	 * @return aproUsrNm
	 */
	public String getAproUsrNm() {
		return this.aproUsrNm;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return fmperiod
	 */
	public String getFmperiod() {
		return this.fmperiod;
	}
	
	/**
	 * Column Info
	 * @return propVoidRtAmt
	 */
	public String getPropVoidRtAmt() {
		return this.propVoidRtAmt;
	}
	
	/**
	 * Column Info
	 * @return aproRt
	 */
	public String getAproRt() {
		return this.aproRt;
	}
	
	/**
	 * Column Info
	 * @return progStsCd
	 */
	public String getProgStsCd() {
		return this.progStsCd;
	}
	
	/**
	 * Column Info
	 * @return actCustNm
	 */
	public String getActCustNm() {
		return this.actCustNm;
	}
	
	/**
	 * Column Info
	 * @return cgoType
	 */
	public String getCgoType() {
		return this.cgoType;
	}
	
	/**
	 * Column Info
	 * @return ovrHgt
	 */
	public String getOvrHgt() {
		return this.ovrHgt;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	

	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param ttlDimWdt
	 */
	public void setTtlDimWdt(String ttlDimWdt) {
		this.ttlDimWdt = ttlDimWdt;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param ovrVoidSltQty
	 */
	public void setOvrVoidSltQty(String ovrVoidSltQty) {
		this.ovrVoidSltQty = ovrVoidSltQty;
	}
	
	/**
	 * Column Info
	 * @param scqRqstNo
	 */
	public void setScqRqstNo(String scqRqstNo) {
		this.scqRqstNo = scqRqstNo;
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
	 * @param progDt
	 */
	public void setProgDt(String progDt) {
		this.progDt = progDt;
	}
	
	/**
	 * Column Info
	 * @param propBsrtAmt
	 */
	public void setPropBsrtAmt(String propBsrtAmt) {
		this.propBsrtAmt = propBsrtAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlDimHgt
	 */
	public void setTtlDimHgt(String ttlDimHgt) {
		this.ttlDimHgt = ttlDimHgt;
	}
	
	/**
	 * Column Info
	 * @param propEffDt
	 */
	public void setPropEffDt(String propEffDt) {
		this.propEffDt = propEffDt;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param propRt
	 */
	public void setPropRt(String propRt) {
		this.propRt = propRt;
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
	 * @param ovrBkwdLen
	 */
	public void setOvrBkwdLen(String ovrBkwdLen) {
		this.ovrBkwdLen = ovrBkwdLen;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
	/**
	 * Column Info
	 * @param aproExpDt
	 */
	public void setAproExpDt(String aproExpDt) {
		this.aproExpDt = aproExpDt;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpSz
	 */
	public void setCntrTpSz(String cntrTpSz) {
		this.cntrTpSz = cntrTpSz;
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
	 * @param grsWgi
	 */
	public void setGrsWgi(String grsWgi) {
		this.grsWgi = grsWgi;
	}
	
	/**
	 * Column Info
	 * @param podSum
	 */
	public void setPodSum(String podSum) {
		this.podSum = podSum;
	}
	
	/**
	 * Column Info
	 * @param rqstSrepCd
	 */
	public void setRqstSrepCd(String rqstSrepCd) {
		this.rqstSrepCd = rqstSrepCd;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param ovrLfLen
	 */
	public void setOvrLfLen(String ovrLfLen) {
		this.ovrLfLen = ovrLfLen;
	}
	
	/**
	 * Column Info
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
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
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
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
	 * @param toperiod
	 */
	public void setToperiod(String toperiod) {
		this.toperiod = toperiod;
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
	 * @param ovrFwrdLen
	 */
	public void setOvrFwrdLen(String ovrFwrdLen) {
		this.ovrFwrdLen = ovrFwrdLen;
	}
	
	/**
	 * Column Info
	 * @param scqRqstNo2
	 */
	public void setScqRqstNo2(String scqRqstNo2) {
		this.scqRqstNo2 = scqRqstNo2;
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
	 * @param propExpDt
	 */
	public void setPropExpDt(String propExpDt) {
		this.propExpDt = propExpDt;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
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
	 * @param ovrRtLen
	 */
	public void setOvrRtLen(String ovrRtLen) {
		this.ovrRtLen = ovrRtLen;
	}
	
	/**
	 * Column Info
	 * @param tpCd
	 */
	public void setTpCd(String tpCd) {
		this.tpCd = tpCd;
	}
	
	/**
	 * Column Info
	 * @param scqVerNo
	 */
	public void setScqVerNo(String scqVerNo) {
		this.scqVerNo = scqVerNo;
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
	 * @param aproBsrtAmt
	 */
	public void setAproBsrtAmt(String aproBsrtAmt) {
		this.aproBsrtAmt = aproBsrtAmt;
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
	 * @param polSum
	 */
	public void setPolSum(String polSum) {
		this.polSum = polSum;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrNm
	 */
	public void setRqstUsrNm(String rqstUsrNm) {
		this.rqstUsrNm = rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @param ttlDimLen
	 */
	public void setTtlDimLen(String ttlDimLen) {
		this.ttlDimLen = ttlDimLen;
	}
	
	/**
	 * Column Info
	 * @param aproEffDt
	 */
	public void setAproEffDt(String aproEffDt) {
		this.aproEffDt = aproEffDt;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param measSysCd
	 */
	public void setMeasSysCd(String measSysCd) {
		this.measSysCd = measSysCd;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param aproVoidRtAmt
	 */
	public void setAproVoidRtAmt(String aproVoidRtAmt) {
		this.aproVoidRtAmt = aproVoidRtAmt;
	}
	
	/**
	 * Column Info
	 * @param aproUsrNm
	 */
	public void setAproUsrNm(String aproUsrNm) {
		this.aproUsrNm = aproUsrNm;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param fmperiod
	 */
	public void setFmperiod(String fmperiod) {
		this.fmperiod = fmperiod;
	}
	
	/**
	 * Column Info
	 * @param propVoidRtAmt
	 */
	public void setPropVoidRtAmt(String propVoidRtAmt) {
		this.propVoidRtAmt = propVoidRtAmt;
	}
	
	/**
	 * Column Info
	 * @param aproRt
	 */
	public void setAproRt(String aproRt) {
		this.aproRt = aproRt;
	}
	
	/**
	 * Column Info
	 * @param progStsCd
	 */
	public void setProgStsCd(String progStsCd) {
		this.progStsCd = progStsCd;
	}
	
	/**
	 * Column Info
	 * @param actCustNm
	 */
	public void setActCustNm(String actCustNm) {
		this.actCustNm = actCustNm;
	}
	
	/**
	 * Column Info
	 * @param cgoType
	 */
	public void setCgoType(String cgoType) {
		this.cgoType = cgoType;
	}
	
	/**
	 * Column Info
	 * @param ovrHgt
	 */
	public void setOvrHgt(String ovrHgt) {
		this.ovrHgt = ovrHgt;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
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
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setTtlDimWdt(JSPUtil.getParameter(request, prefix + "ttl_dim_wdt", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setOvrVoidSltQty(JSPUtil.getParameter(request, prefix + "ovr_void_slt_qty", ""));
		setScqRqstNo(JSPUtil.getParameter(request, prefix + "scq_rqst_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setProgDt(JSPUtil.getParameter(request, prefix + "prog_dt", ""));
		setPropBsrtAmt(JSPUtil.getParameter(request, prefix + "prop_bsrt_amt", ""));
		setTtlDimHgt(JSPUtil.getParameter(request, prefix + "ttl_dim_hgt", ""));
		setPropEffDt(JSPUtil.getParameter(request, prefix + "prop_eff_dt", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setPropRt(JSPUtil.getParameter(request, prefix + "prop_rt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOvrBkwdLen(JSPUtil.getParameter(request, prefix + "ovr_bkwd_len", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setAproExpDt(JSPUtil.getParameter(request, prefix + "apro_exp_dt", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setCntrTpSz(JSPUtil.getParameter(request, prefix + "cntr_tp_sz", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setGrsWgi(JSPUtil.getParameter(request, prefix + "grs_wgi", ""));
		setPodSum(JSPUtil.getParameter(request, prefix + "pod_sum", ""));
		setRqstSrepCd(JSPUtil.getParameter(request, prefix + "rqst_srep_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setActCustCntCd(JSPUtil.getParameter(request, prefix + "act_cust_cnt_cd", ""));
		setOvrLfLen(JSPUtil.getParameter(request, prefix + "ovr_lf_len", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setToperiod(JSPUtil.getParameter(request, prefix + "toperiod", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOvrFwrdLen(JSPUtil.getParameter(request, prefix + "ovr_fwrd_len", ""));
		setScqRqstNo2(JSPUtil.getParameter(request, prefix + "scq_rqst_no2", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setPropExpDt(JSPUtil.getParameter(request, prefix + "prop_exp_dt", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setOvrRtLen(JSPUtil.getParameter(request, prefix + "ovr_rt_len", ""));
		setTpCd(JSPUtil.getParameter(request, prefix + "tp_cd", ""));
		setScqVerNo(JSPUtil.getParameter(request, prefix + "scq_ver_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAproBsrtAmt(JSPUtil.getParameter(request, prefix + "apro_bsrt_amt", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPolSum(JSPUtil.getParameter(request, prefix + "pol_sum", ""));
		setRqstUsrNm(JSPUtil.getParameter(request, prefix + "rqst_usr_nm", ""));
		setTtlDimLen(JSPUtil.getParameter(request, prefix + "ttl_dim_len", ""));
		setAproEffDt(JSPUtil.getParameter(request, prefix + "apro_eff_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setMeasSysCd(JSPUtil.getParameter(request, prefix + "meas_sys_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setAproVoidRtAmt(JSPUtil.getParameter(request, prefix + "apro_void_rt_amt", ""));
		setAproUsrNm(JSPUtil.getParameter(request, prefix + "apro_usr_nm", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setFmperiod(JSPUtil.getParameter(request, prefix + "fmperiod", ""));
		setPropVoidRtAmt(JSPUtil.getParameter(request, prefix + "prop_void_rt_amt", ""));
		setAproRt(JSPUtil.getParameter(request, prefix + "apro_rt", ""));
		setProgStsCd(JSPUtil.getParameter(request, prefix + "prog_sts_cd", ""));
		setActCustNm(JSPUtil.getParameter(request, prefix + "act_cust_nm", ""));
		setCgoType(JSPUtil.getParameter(request, prefix + "cgo_type", ""));
		setOvrHgt(JSPUtil.getParameter(request, prefix + "ovr_hgt", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriScqAwkBbVO[]
	 */
	public PriScqAwkBbVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriScqAwkBbVO[]
	 */
	public PriScqAwkBbVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriScqAwkBbVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] ttlDimWdt = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_wdt", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] ovrVoidSltQty = (JSPUtil.getParameter(request, prefix	+ "ovr_void_slt_qty", length));
			String[] scqRqstNo = (JSPUtil.getParameter(request, prefix	+ "scq_rqst_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] progDt = (JSPUtil.getParameter(request, prefix	+ "prog_dt", length));
			String[] propBsrtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_bsrt_amt", length));
			String[] ttlDimHgt = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_hgt", length));
			String[] propEffDt = (JSPUtil.getParameter(request, prefix	+ "prop_eff_dt", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] propRt = (JSPUtil.getParameter(request, prefix	+ "prop_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ovrBkwdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_bkwd_len", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] aproExpDt = (JSPUtil.getParameter(request, prefix	+ "apro_exp_dt", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] cntrTpSz = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_sz", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] grsWgi = (JSPUtil.getParameter(request, prefix	+ "grs_wgi", length));
			String[] podSum = (JSPUtil.getParameter(request, prefix	+ "pod_sum", length));
			String[] rqstSrepCd = (JSPUtil.getParameter(request, prefix	+ "rqst_srep_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] ovrLfLen = (JSPUtil.getParameter(request, prefix	+ "ovr_lf_len", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] toperiod = (JSPUtil.getParameter(request, prefix	+ "toperiod", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ovrFwrdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_fwrd_len", length));
			String[] scqRqstNo2 = (JSPUtil.getParameter(request, prefix	+ "scq_rqst_no2", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] propExpDt = (JSPUtil.getParameter(request, prefix	+ "prop_exp_dt", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] ovrRtLen = (JSPUtil.getParameter(request, prefix	+ "ovr_rt_len", length));
			String[] tpCd = (JSPUtil.getParameter(request, prefix	+ "tp_cd", length));
			String[] scqVerNo = (JSPUtil.getParameter(request, prefix	+ "scq_ver_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] aproBsrtAmt = (JSPUtil.getParameter(request, prefix	+ "apro_bsrt_amt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] polSum = (JSPUtil.getParameter(request, prefix	+ "pol_sum", length));
			String[] rqstUsrNm = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_nm", length));
			String[] ttlDimLen = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_len", length));
			String[] aproEffDt = (JSPUtil.getParameter(request, prefix	+ "apro_eff_dt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] measSysCd = (JSPUtil.getParameter(request, prefix	+ "meas_sys_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] aproVoidRtAmt = (JSPUtil.getParameter(request, prefix	+ "apro_void_rt_amt", length));
			String[] aproUsrNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_nm", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] fmperiod = (JSPUtil.getParameter(request, prefix	+ "fmperiod", length));
			String[] propVoidRtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_void_rt_amt", length));
			String[] aproRt = (JSPUtil.getParameter(request, prefix	+ "apro_rt", length));
			String[] progStsCd = (JSPUtil.getParameter(request, prefix	+ "prog_sts_cd", length));
			String[] actCustNm = (JSPUtil.getParameter(request, prefix	+ "act_cust_nm", length));
			String[] cgoType = (JSPUtil.getParameter(request, prefix	+ "cgo_type", length));
			String[] ovrHgt = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriScqAwkBbVO();
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (ttlDimWdt[i] != null)
					model.setTtlDimWdt(ttlDimWdt[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (ovrVoidSltQty[i] != null)
					model.setOvrVoidSltQty(ovrVoidSltQty[i]);
				if (scqRqstNo[i] != null)
					model.setScqRqstNo(scqRqstNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (progDt[i] != null)
					model.setProgDt(progDt[i]);
				if (propBsrtAmt[i] != null)
					model.setPropBsrtAmt(propBsrtAmt[i]);
				if (ttlDimHgt[i] != null)
					model.setTtlDimHgt(ttlDimHgt[i]);
				if (propEffDt[i] != null)
					model.setPropEffDt(propEffDt[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (propRt[i] != null)
					model.setPropRt(propRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ovrBkwdLen[i] != null)
					model.setOvrBkwdLen(ovrBkwdLen[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (aproExpDt[i] != null)
					model.setAproExpDt(aproExpDt[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (cntrTpSz[i] != null)
					model.setCntrTpSz(cntrTpSz[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (grsWgi[i] != null)
					model.setGrsWgi(grsWgi[i]);
				if (podSum[i] != null)
					model.setPodSum(podSum[i]);
				if (rqstSrepCd[i] != null)
					model.setRqstSrepCd(rqstSrepCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (ovrLfLen[i] != null)
					model.setOvrLfLen(ovrLfLen[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (toperiod[i] != null)
					model.setToperiod(toperiod[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ovrFwrdLen[i] != null)
					model.setOvrFwrdLen(ovrFwrdLen[i]);
				if (scqRqstNo2[i] != null)
					model.setScqRqstNo2(scqRqstNo2[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (propExpDt[i] != null)
					model.setPropExpDt(propExpDt[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (ovrRtLen[i] != null)
					model.setOvrRtLen(ovrRtLen[i]);
				if (tpCd[i] != null)
					model.setTpCd(tpCd[i]);
				if (scqVerNo[i] != null)
					model.setScqVerNo(scqVerNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (aproBsrtAmt[i] != null)
					model.setAproBsrtAmt(aproBsrtAmt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (polSum[i] != null)
					model.setPolSum(polSum[i]);
				if (rqstUsrNm[i] != null)
					model.setRqstUsrNm(rqstUsrNm[i]);
				if (ttlDimLen[i] != null)
					model.setTtlDimLen(ttlDimLen[i]);
				if (aproEffDt[i] != null)
					model.setAproEffDt(aproEffDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (measSysCd[i] != null)
					model.setMeasSysCd(measSysCd[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (aproVoidRtAmt[i] != null)
					model.setAproVoidRtAmt(aproVoidRtAmt[i]);
				if (aproUsrNm[i] != null)
					model.setAproUsrNm(aproUsrNm[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (fmperiod[i] != null)
					model.setFmperiod(fmperiod[i]);
				if (propVoidRtAmt[i] != null)
					model.setPropVoidRtAmt(propVoidRtAmt[i]);
				if (aproRt[i] != null)
					model.setAproRt(aproRt[i]);
				if (progStsCd[i] != null)
					model.setProgStsCd(progStsCd[i]);
				if (actCustNm[i] != null)
					model.setActCustNm(actCustNm[i]);
				if (cgoType[i] != null)
					model.setCgoType(cgoType[i]);
				if (ovrHgt[i] != null)
					model.setOvrHgt(ovrHgt[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriScqAwkBbVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriScqAwkBbVO[]
	 */
	public PriScqAwkBbVO[] getPriScqAwkBbVOs(){
		PriScqAwkBbVO[] vos = (PriScqAwkBbVO[])models.toArray(new PriScqAwkBbVO[models.size()]);
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
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimWdt = this.ttlDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrVoidSltQty = this.ovrVoidSltQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqRqstNo = this.scqRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progDt = this.progDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propBsrtAmt = this.propBsrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimHgt = this.ttlDimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propEffDt = this.propEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propRt = this.propRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrBkwdLen = this.ovrBkwdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproExpDt = this.aproExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpSz = this.cntrTpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgi = this.grsWgi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSum = this.podSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstSrepCd = this.rqstSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrLfLen = this.ovrLfLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toperiod = this.toperiod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrFwrdLen = this.ovrFwrdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqRqstNo2 = this.scqRqstNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propExpDt = this.propExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrRtLen = this.ovrRtLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd = this.tpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqVerNo = this.scqVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproBsrtAmt = this.aproBsrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSum = this.polSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrNm = this.rqstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimLen = this.ttlDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproEffDt = this.aproEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measSysCd = this.measSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproVoidRtAmt = this.aproVoidRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrNm = this.aproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmperiod = this.fmperiod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propVoidRtAmt = this.propVoidRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRt = this.aproRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progStsCd = this.progStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustNm = this.actCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoType = this.cgoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgt = this.ovrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	


	/**
	 * @return the priScqBbCntrVOs
	 */
	public List<PriScqBbCntrVO> getPriScqBbCntrVOs() {
		return priScqBbCntrVOs;
	}

	/**
	 * @param priScqBbCntrVOs the priScqBbCntrVOs to set
	 */
	public void setPriScqBbCntrVOs(List<PriScqBbCntrVO> priScqBbCntrVOs) {
		this.priScqBbCntrVOs = priScqBbCntrVOs;
	}

	/**
	 * @return the priScqBbCgoDtlVos
	 */
	public List<PriScqBbCgoDtlVO> getPriScqBbCgoDtlVos() {
		return priScqBbCgoDtlVos;
	}

	/**
	 * @param priScqBbCgoDtlVos the priScqBbCgoDtlVos to set
	 */
	public void setPriScqBbCgoDtlVos(List<PriScqBbCgoDtlVO> priScqBbCgoDtlVos) {
		this.priScqBbCgoDtlVos = priScqBbCgoDtlVos;
	}

	/**
	 * @return the priScqBbHandlingCstVos
	 */
	public List<PriScqBbHandlingCstVO> getPriScqBbHandlingCstVos() {
		return priScqBbHandlingCstVos;
	}

	/**
	 * @param priScqBbHandlingCstVos the priScqBbHandlingCstVos to set
	 */
	public void setPriScqBbHandlingCstVos(
			List<PriScqBbHandlingCstVO> priScqBbHandlingCstVos) {
		this.priScqBbHandlingCstVos = priScqBbHandlingCstVos;
	}
	
}
