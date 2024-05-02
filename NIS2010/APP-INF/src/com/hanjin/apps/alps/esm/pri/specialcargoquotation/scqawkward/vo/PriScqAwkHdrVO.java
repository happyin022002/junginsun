/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PriScqAwkHdrVO.java
*@FileTitle : PriScqAwkHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.21
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.21 송호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo;

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
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriScqAwkHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriScqAwkHdrVO> models = new ArrayList<PriScqAwkHdrVO>();
	
	/* Column Info */
	private String auth = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String preProgStsCd = null;
	/* Column Info */
	private String progUsrNm = null;
	/* Column Info */
	private String scqRqstNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String progDt = null;
	/* Column Info */
	private String propEffDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String scqRqstNoTmp = null;
	/* Column Info */
	private String progUsrId = null;
	/* Column Info */
	private String aproExpDt = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String progSeq = null;
	/* Column Info */
	private String scqBidFlg = null;
	/* Column Info */
	private String scqVerNoTmp = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rqstSrepCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String progStsNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String measSysCdVw = null;
	/* Column Info */
	private String propExpDt = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String scqVerNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String rqstSrepNm = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String aproEffDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String progRmk = null;
	/* Column Info */
	private String lastFlg = null;
	/* Column Info */
	private String measSysCd = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String spclCgoTpCd = null;
	/* Column Info */
	private String pgProgStsCd = null;
	/* Column Info */
	private String progOfcCd = null;
	/* Column Info */
	private String progStsCd = null;
	/* Column Info */
	private String rsltFlg = null;
	/* Column Info */
	private String actCustNm = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String podYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PriScqAwkHdrVO() {}

	public PriScqAwkHdrVO(String ibflag, String pagerows, String scqRqstNo, String scqVerNo, String progStsCd, String rqstOfcCd, String rqstSrepCd, String porCd, String polCd, String polYdCd, String podCd, String podYdCd, String delCd, String svcScpCd, String custCntCd, String custSeq, String rcvTermCd, String deTermCd, String propEffDt, String propExpDt, String aproEffDt, String aproExpDt, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String aproOfcCd, String spclCgoTpCd, String progSeq, String pgProgStsCd, String progOfcCd, String progUsrNm, String progUsrId, String progDt, String progRmk, String rqstSrepNm, String custLglEngNm, String progStsNm, String auth, String lastFlg, String actCustCntCd, String actCustSeq, String actCustNm, String scqBidFlg, String measSysCd, String measSysCdVw, String preProgStsCd, String rsltFlg, String scqRqstNoTmp, String scqVerNoTmp) {
		this.auth = auth;
		this.polYdCd = polYdCd;
		this.preProgStsCd = preProgStsCd;
		this.progUsrNm = progUsrNm;
		this.scqRqstNo = scqRqstNo;
		this.updUsrId = updUsrId;
		this.progDt = progDt;
		this.propEffDt = propEffDt;
		this.pagerows = pagerows;
		this.custLglEngNm = custLglEngNm;
		this.scqRqstNoTmp = scqRqstNoTmp;
		this.progUsrId = progUsrId;
		this.aproExpDt = aproExpDt;
		this.deTermCd = deTermCd;
		this.deltFlg = deltFlg;
		this.rqstOfcCd = rqstOfcCd;
		this.progSeq = progSeq;
		this.scqBidFlg = scqBidFlg;
		this.scqVerNoTmp = scqVerNoTmp;
		this.creDt = creDt;
		this.rqstSrepCd = rqstSrepCd;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.actCustCntCd = actCustCntCd;
		this.updDt = updDt;
		this.progStsNm = progStsNm;
		this.ibflag = ibflag;
		this.measSysCdVw = measSysCdVw;
		this.propExpDt = propExpDt;
		this.porCd = porCd;
		this.aproOfcCd = aproOfcCd;
		this.scqVerNo = scqVerNo;
		this.creUsrId = creUsrId;
		this.polCd = polCd;
		this.rqstSrepNm = rqstSrepNm;
		this.svcScpCd = svcScpCd;
		this.aproEffDt = aproEffDt;
		this.podCd = podCd;
		this.progRmk = progRmk;
		this.lastFlg = lastFlg;
		this.measSysCd = measSysCd;
		this.actCustSeq = actCustSeq;
		this.spclCgoTpCd = spclCgoTpCd;
		this.pgProgStsCd = pgProgStsCd;
		this.progOfcCd = progOfcCd;
		this.progStsCd = progStsCd;
		this.rsltFlg = rsltFlg;
		this.actCustNm = actCustNm;
		this.rcvTermCd = rcvTermCd;
		this.delCd = delCd;
		this.podYdCd = podYdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("auth", getAuth());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("pre_prog_sts_cd", getPreProgStsCd());
		this.hashColumns.put("prog_usr_nm", getProgUsrNm());
		this.hashColumns.put("scq_rqst_no", getScqRqstNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("prog_dt", getProgDt());
		this.hashColumns.put("prop_eff_dt", getPropEffDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("scq_rqst_no_tmp", getScqRqstNoTmp());
		this.hashColumns.put("prog_usr_id", getProgUsrId());
		this.hashColumns.put("apro_exp_dt", getAproExpDt());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("prog_seq", getProgSeq());
		this.hashColumns.put("scq_bid_flg", getScqBidFlg());
		this.hashColumns.put("scq_ver_no_tmp", getScqVerNoTmp());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rqst_srep_cd", getRqstSrepCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("prog_sts_nm", getProgStsNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("meas_sys_cd_vw", getMeasSysCdVw());
		this.hashColumns.put("prop_exp_dt", getPropExpDt());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("scq_ver_no", getScqVerNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("rqst_srep_nm", getRqstSrepNm());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("apro_eff_dt", getAproEffDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("prog_rmk", getProgRmk());
		this.hashColumns.put("last_flg", getLastFlg());
		this.hashColumns.put("meas_sys_cd", getMeasSysCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("spcl_cgo_tp_cd", getSpclCgoTpCd());
		this.hashColumns.put("pg_prog_sts_cd", getPgProgStsCd());
		this.hashColumns.put("prog_ofc_cd", getProgOfcCd());
		this.hashColumns.put("prog_sts_cd", getProgStsCd());
		this.hashColumns.put("rslt_flg", getRsltFlg());
		this.hashColumns.put("act_cust_nm", getActCustNm());
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
		this.hashFields.put("auth", "auth");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("pre_prog_sts_cd", "preProgStsCd");
		this.hashFields.put("prog_usr_nm", "progUsrNm");
		this.hashFields.put("scq_rqst_no", "scqRqstNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("prog_dt", "progDt");
		this.hashFields.put("prop_eff_dt", "propEffDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("scq_rqst_no_tmp", "scqRqstNoTmp");
		this.hashFields.put("prog_usr_id", "progUsrId");
		this.hashFields.put("apro_exp_dt", "aproExpDt");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("prog_seq", "progSeq");
		this.hashFields.put("scq_bid_flg", "scqBidFlg");
		this.hashFields.put("scq_ver_no_tmp", "scqVerNoTmp");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rqst_srep_cd", "rqstSrepCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("prog_sts_nm", "progStsNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("meas_sys_cd_vw", "measSysCdVw");
		this.hashFields.put("prop_exp_dt", "propExpDt");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("scq_ver_no", "scqVerNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rqst_srep_nm", "rqstSrepNm");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("apro_eff_dt", "aproEffDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("prog_rmk", "progRmk");
		this.hashFields.put("last_flg", "lastFlg");
		this.hashFields.put("meas_sys_cd", "measSysCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("spcl_cgo_tp_cd", "spclCgoTpCd");
		this.hashFields.put("pg_prog_sts_cd", "pgProgStsCd");
		this.hashFields.put("prog_ofc_cd", "progOfcCd");
		this.hashFields.put("prog_sts_cd", "progStsCd");
		this.hashFields.put("rslt_flg", "rsltFlg");
		this.hashFields.put("act_cust_nm", "actCustNm");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return auth
	 */
	public String getAuth() {
		return this.auth;
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
	 * @return preProgStsCd
	 */
	public String getPreProgStsCd() {
		return this.preProgStsCd;
	}
	
	/**
	 * Column Info
	 * @return progUsrNm
	 */
	public String getProgUsrNm() {
		return this.progUsrNm;
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
	 * @return propEffDt
	 */
	public String getPropEffDt() {
		return this.propEffDt;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return scqRqstNoTmp
	 */
	public String getScqRqstNoTmp() {
		return this.scqRqstNoTmp;
	}
	
	/**
	 * Column Info
	 * @return progUsrId
	 */
	public String getProgUsrId() {
		return this.progUsrId;
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
	 * @return progSeq
	 */
	public String getProgSeq() {
		return this.progSeq;
	}
	
	/**
	 * Column Info
	 * @return scqBidFlg
	 */
	public String getScqBidFlg() {
		return this.scqBidFlg;
	}
	
	/**
	 * Column Info
	 * @return scqVerNoTmp
	 */
	public String getScqVerNoTmp() {
		return this.scqVerNoTmp;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return progStsNm
	 */
	public String getProgStsNm() {
		return this.progStsNm;
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
	 * @return measSysCdVw
	 */
	public String getMeasSysCdVw() {
		return this.measSysCdVw;
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return rqstSrepNm
	 */
	public String getRqstSrepNm() {
		return this.rqstSrepNm;
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
	 * @return aproEffDt
	 */
	public String getAproEffDt() {
		return this.aproEffDt;
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
	 * @return progRmk
	 */
	public String getProgRmk() {
		return this.progRmk;
	}
	
	/**
	 * Column Info
	 * @return lastFlg
	 */
	public String getLastFlg() {
		return this.lastFlg;
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
	 * @return spclCgoTpCd
	 */
	public String getSpclCgoTpCd() {
		return this.spclCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return pgProgStsCd
	 */
	public String getPgProgStsCd() {
		return this.pgProgStsCd;
	}
	
	/**
	 * Column Info
	 * @return progOfcCd
	 */
	public String getProgOfcCd() {
		return this.progOfcCd;
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
	 * @return rsltFlg
	 */
	public String getRsltFlg() {
		return this.rsltFlg;
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
	 * @param auth
	 */
	public void setAuth(String auth) {
		this.auth = auth;
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
	 * @param preProgStsCd
	 */
	public void setPreProgStsCd(String preProgStsCd) {
		this.preProgStsCd = preProgStsCd;
	}
	
	/**
	 * Column Info
	 * @param progUsrNm
	 */
	public void setProgUsrNm(String progUsrNm) {
		this.progUsrNm = progUsrNm;
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
	 * @param propEffDt
	 */
	public void setPropEffDt(String propEffDt) {
		this.propEffDt = propEffDt;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param scqRqstNoTmp
	 */
	public void setScqRqstNoTmp(String scqRqstNoTmp) {
		this.scqRqstNoTmp = scqRqstNoTmp;
	}
	
	/**
	 * Column Info
	 * @param progUsrId
	 */
	public void setProgUsrId(String progUsrId) {
		this.progUsrId = progUsrId;
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
	 * @param progSeq
	 */
	public void setProgSeq(String progSeq) {
		this.progSeq = progSeq;
	}
	
	/**
	 * Column Info
	 * @param scqBidFlg
	 */
	public void setScqBidFlg(String scqBidFlg) {
		this.scqBidFlg = scqBidFlg;
	}
	
	/**
	 * Column Info
	 * @param scqVerNoTmp
	 */
	public void setScqVerNoTmp(String scqVerNoTmp) {
		this.scqVerNoTmp = scqVerNoTmp;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param progStsNm
	 */
	public void setProgStsNm(String progStsNm) {
		this.progStsNm = progStsNm;
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
	 * @param measSysCdVw
	 */
	public void setMeasSysCdVw(String measSysCdVw) {
		this.measSysCdVw = measSysCdVw;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param rqstSrepNm
	 */
	public void setRqstSrepNm(String rqstSrepNm) {
		this.rqstSrepNm = rqstSrepNm;
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
	 * @param aproEffDt
	 */
	public void setAproEffDt(String aproEffDt) {
		this.aproEffDt = aproEffDt;
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
	 * @param progRmk
	 */
	public void setProgRmk(String progRmk) {
		this.progRmk = progRmk;
	}
	
	/**
	 * Column Info
	 * @param lastFlg
	 */
	public void setLastFlg(String lastFlg) {
		this.lastFlg = lastFlg;
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
	 * @param spclCgoTpCd
	 */
	public void setSpclCgoTpCd(String spclCgoTpCd) {
		this.spclCgoTpCd = spclCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param pgProgStsCd
	 */
	public void setPgProgStsCd(String pgProgStsCd) {
		this.pgProgStsCd = pgProgStsCd;
	}
	
	/**
	 * Column Info
	 * @param progOfcCd
	 */
	public void setProgOfcCd(String progOfcCd) {
		this.progOfcCd = progOfcCd;
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
	 * @param rsltFlg
	 */
	public void setRsltFlg(String rsltFlg) {
		this.rsltFlg = rsltFlg;
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
		setAuth(JSPUtil.getParameter(request, prefix + "auth", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setPreProgStsCd(JSPUtil.getParameter(request, prefix + "pre_prog_sts_cd", ""));
		setProgUsrNm(JSPUtil.getParameter(request, prefix + "prog_usr_nm", ""));
		setScqRqstNo(JSPUtil.getParameter(request, prefix + "scq_rqst_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setProgDt(JSPUtil.getParameter(request, prefix + "prog_dt", ""));
		setPropEffDt(JSPUtil.getParameter(request, prefix + "prop_eff_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setScqRqstNoTmp(JSPUtil.getParameter(request, prefix + "scq_rqst_no_tmp", ""));
		setProgUsrId(JSPUtil.getParameter(request, prefix + "prog_usr_id", ""));
		setAproExpDt(JSPUtil.getParameter(request, prefix + "apro_exp_dt", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setProgSeq(JSPUtil.getParameter(request, prefix + "prog_seq", ""));
		setScqBidFlg(JSPUtil.getParameter(request, prefix + "scq_bid_flg", ""));
		setScqVerNoTmp(JSPUtil.getParameter(request, prefix + "scq_ver_no_tmp", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRqstSrepCd(JSPUtil.getParameter(request, prefix + "rqst_srep_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setActCustCntCd(JSPUtil.getParameter(request, prefix + "act_cust_cnt_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setProgStsNm(JSPUtil.getParameter(request, prefix + "prog_sts_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMeasSysCdVw(JSPUtil.getParameter(request, prefix + "meas_sys_cd_vw", ""));
		setPropExpDt(JSPUtil.getParameter(request, prefix + "prop_exp_dt", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setScqVerNo(JSPUtil.getParameter(request, prefix + "scq_ver_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setRqstSrepNm(JSPUtil.getParameter(request, prefix + "rqst_srep_nm", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setAproEffDt(JSPUtil.getParameter(request, prefix + "apro_eff_dt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setProgRmk(JSPUtil.getParameter(request, prefix + "prog_rmk", ""));
		setLastFlg(JSPUtil.getParameter(request, prefix + "last_flg", ""));
		setMeasSysCd(JSPUtil.getParameter(request, prefix + "meas_sys_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setSpclCgoTpCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_tp_cd", ""));
		setPgProgStsCd(JSPUtil.getParameter(request, prefix + "pg_prog_sts_cd", ""));
		setProgOfcCd(JSPUtil.getParameter(request, prefix + "prog_ofc_cd", ""));
		setProgStsCd(JSPUtil.getParameter(request, prefix + "prog_sts_cd", ""));
		setRsltFlg(JSPUtil.getParameter(request, prefix + "rslt_flg", ""));
		setActCustNm(JSPUtil.getParameter(request, prefix + "act_cust_nm", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriScqAwkHdrVO[]
	 */
	public PriScqAwkHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriScqAwkHdrVO[]
	 */
	public PriScqAwkHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriScqAwkHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] auth = (JSPUtil.getParameter(request, prefix	+ "auth", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] preProgStsCd = (JSPUtil.getParameter(request, prefix	+ "pre_prog_sts_cd", length));
			String[] progUsrNm = (JSPUtil.getParameter(request, prefix	+ "prog_usr_nm", length));
			String[] scqRqstNo = (JSPUtil.getParameter(request, prefix	+ "scq_rqst_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] progDt = (JSPUtil.getParameter(request, prefix	+ "prog_dt", length));
			String[] propEffDt = (JSPUtil.getParameter(request, prefix	+ "prop_eff_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] scqRqstNoTmp = (JSPUtil.getParameter(request, prefix	+ "scq_rqst_no_tmp", length));
			String[] progUsrId = (JSPUtil.getParameter(request, prefix	+ "prog_usr_id", length));
			String[] aproExpDt = (JSPUtil.getParameter(request, prefix	+ "apro_exp_dt", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] progSeq = (JSPUtil.getParameter(request, prefix	+ "prog_seq", length));
			String[] scqBidFlg = (JSPUtil.getParameter(request, prefix	+ "scq_bid_flg", length));
			String[] scqVerNoTmp = (JSPUtil.getParameter(request, prefix	+ "scq_ver_no_tmp", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rqstSrepCd = (JSPUtil.getParameter(request, prefix	+ "rqst_srep_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] progStsNm = (JSPUtil.getParameter(request, prefix	+ "prog_sts_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] measSysCdVw = (JSPUtil.getParameter(request, prefix	+ "meas_sys_cd_vw", length));
			String[] propExpDt = (JSPUtil.getParameter(request, prefix	+ "prop_exp_dt", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] scqVerNo = (JSPUtil.getParameter(request, prefix	+ "scq_ver_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] rqstSrepNm = (JSPUtil.getParameter(request, prefix	+ "rqst_srep_nm", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] aproEffDt = (JSPUtil.getParameter(request, prefix	+ "apro_eff_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] progRmk = (JSPUtil.getParameter(request, prefix	+ "prog_rmk", length));
			String[] lastFlg = (JSPUtil.getParameter(request, prefix	+ "last_flg", length));
			String[] measSysCd = (JSPUtil.getParameter(request, prefix	+ "meas_sys_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] spclCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_tp_cd", length));
			String[] pgProgStsCd = (JSPUtil.getParameter(request, prefix	+ "pg_prog_sts_cd", length));
			String[] progOfcCd = (JSPUtil.getParameter(request, prefix	+ "prog_ofc_cd", length));
			String[] progStsCd = (JSPUtil.getParameter(request, prefix	+ "prog_sts_cd", length));
			String[] rsltFlg = (JSPUtil.getParameter(request, prefix	+ "rslt_flg", length));
			String[] actCustNm = (JSPUtil.getParameter(request, prefix	+ "act_cust_nm", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriScqAwkHdrVO();
				if (auth[i] != null)
					model.setAuth(auth[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (preProgStsCd[i] != null)
					model.setPreProgStsCd(preProgStsCd[i]);
				if (progUsrNm[i] != null)
					model.setProgUsrNm(progUsrNm[i]);
				if (scqRqstNo[i] != null)
					model.setScqRqstNo(scqRqstNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (progDt[i] != null)
					model.setProgDt(progDt[i]);
				if (propEffDt[i] != null)
					model.setPropEffDt(propEffDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (scqRqstNoTmp[i] != null)
					model.setScqRqstNoTmp(scqRqstNoTmp[i]);
				if (progUsrId[i] != null)
					model.setProgUsrId(progUsrId[i]);
				if (aproExpDt[i] != null)
					model.setAproExpDt(aproExpDt[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (progSeq[i] != null)
					model.setProgSeq(progSeq[i]);
				if (scqBidFlg[i] != null)
					model.setScqBidFlg(scqBidFlg[i]);
				if (scqVerNoTmp[i] != null)
					model.setScqVerNoTmp(scqVerNoTmp[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rqstSrepCd[i] != null)
					model.setRqstSrepCd(rqstSrepCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (progStsNm[i] != null)
					model.setProgStsNm(progStsNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (measSysCdVw[i] != null)
					model.setMeasSysCdVw(measSysCdVw[i]);
				if (propExpDt[i] != null)
					model.setPropExpDt(propExpDt[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (scqVerNo[i] != null)
					model.setScqVerNo(scqVerNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (rqstSrepNm[i] != null)
					model.setRqstSrepNm(rqstSrepNm[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (aproEffDt[i] != null)
					model.setAproEffDt(aproEffDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (progRmk[i] != null)
					model.setProgRmk(progRmk[i]);
				if (lastFlg[i] != null)
					model.setLastFlg(lastFlg[i]);
				if (measSysCd[i] != null)
					model.setMeasSysCd(measSysCd[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (spclCgoTpCd[i] != null)
					model.setSpclCgoTpCd(spclCgoTpCd[i]);
				if (pgProgStsCd[i] != null)
					model.setPgProgStsCd(pgProgStsCd[i]);
				if (progOfcCd[i] != null)
					model.setProgOfcCd(progOfcCd[i]);
				if (progStsCd[i] != null)
					model.setProgStsCd(progStsCd[i]);
				if (rsltFlg[i] != null)
					model.setRsltFlg(rsltFlg[i]);
				if (actCustNm[i] != null)
					model.setActCustNm(actCustNm[i]);
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
		return getPriScqAwkHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriScqAwkHdrVO[]
	 */
	public PriScqAwkHdrVO[] getPriScqAwkHdrVOs(){
		PriScqAwkHdrVO[] vos = (PriScqAwkHdrVO[])models.toArray(new PriScqAwkHdrVO[models.size()]);
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
		this.auth = this.auth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preProgStsCd = this.preProgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progUsrNm = this.progUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqRqstNo = this.scqRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progDt = this.progDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propEffDt = this.propEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqRqstNoTmp = this.scqRqstNoTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progUsrId = this.progUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproExpDt = this.aproExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progSeq = this.progSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqBidFlg = this.scqBidFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqVerNoTmp = this.scqVerNoTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstSrepCd = this.rqstSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progStsNm = this.progStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measSysCdVw = this.measSysCdVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propExpDt = this.propExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqVerNo = this.scqVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstSrepNm = this.rqstSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproEffDt = this.aproEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progRmk = this.progRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastFlg = this.lastFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measSysCd = this.measSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoTpCd = this.spclCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgProgStsCd = this.pgProgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progOfcCd = this.progOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progStsCd = this.progStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltFlg = this.rsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustNm = this.actCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
