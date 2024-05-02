/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DodDrpOffChgVO.java
*@FileTitle : DodDrpOffChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.28 손진환 
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
 * @author 손진환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DodDrpOffChgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DodDrpOffChgVO> models = new ArrayList<DodDrpOffChgVO>();
	
	/* Column Info */
	private String genTrfAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String spclCustCntCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String troIbCfmOfcCd = null;
	/* Column Info */
	private String drpOffChgMnlFlg = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String dcRmk = null;
	/* Column Info */
	private String drpOffChgTrfSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dcAmt = null;
	/* Column Info */
	private String cntrRtnYdCd = null;
	/* Column Info */
	private String drpOffChgSeq = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String cntrRtnDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String spclTrfAmt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String invSrcNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String svcFeeAmt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String spclCustSeq = null;
	/* Column Info */
	private String troIbCfmDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DodDrpOffChgVO() {}

	public DodDrpOffChgVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String drpOffChgSeq, String invSrcNo, String arIfNo, String drpOffChgTrfSeq, String drpOffChgMnlFlg, String cntrTpszCd, String troIbCfmOfcCd, String troIbCfmDt, String delCd, String cntrRtnYdCd, String cntrRtnDt, String custCntCd, String custSeq, String spclCustCntCd, String spclCustSeq, String currCd, String genTrfAmt, String spclTrfAmt, String dcAmt, String svcFeeAmt, String ttlAmt, String dcRmk, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.genTrfAmt = genTrfAmt;
		this.currCd = currCd;
		this.deltFlg = deltFlg;
		this.spclCustCntCd = spclCustCntCd;
		this.creDt = creDt;
		this.troIbCfmOfcCd = troIbCfmOfcCd;
		this.drpOffChgMnlFlg = drpOffChgMnlFlg;
		this.ttlAmt = ttlAmt;
		this.dcRmk = dcRmk;
		this.drpOffChgTrfSeq = drpOffChgTrfSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.dcAmt = dcAmt;
		this.cntrRtnYdCd = cntrRtnYdCd;
		this.drpOffChgSeq = drpOffChgSeq;
		this.arIfNo = arIfNo;
		this.cntrTpszCd = cntrTpszCd;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.cntrRtnDt = cntrRtnDt;
		this.updDt = updDt;
		this.delCd = delCd;
		this.spclTrfAmt = spclTrfAmt;
		this.custSeq = custSeq;
		this.invSrcNo = invSrcNo;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.svcFeeAmt = svcFeeAmt;
		this.cntrNo = cntrNo;
		this.spclCustSeq = spclCustSeq;
		this.troIbCfmDt = troIbCfmDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gen_trf_amt", getGenTrfAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("spcl_cust_cnt_cd", getSpclCustCntCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("tro_ib_cfm_ofc_cd", getTroIbCfmOfcCd());
		this.hashColumns.put("drp_off_chg_mnl_flg", getDrpOffChgMnlFlg());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("dc_rmk", getDcRmk());
		this.hashColumns.put("drp_off_chg_trf_seq", getDrpOffChgTrfSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("cntr_rtn_yd_cd", getCntrRtnYdCd());
		this.hashColumns.put("drp_off_chg_seq", getDrpOffChgSeq());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cntr_rtn_dt", getCntrRtnDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("spcl_trf_amt", getSpclTrfAmt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("inv_src_no", getInvSrcNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("svc_fee_amt", getSvcFeeAmt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("spcl_cust_seq", getSpclCustSeq());
		this.hashColumns.put("tro_ib_cfm_dt", getTroIbCfmDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gen_trf_amt", "genTrfAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("spcl_cust_cnt_cd", "spclCustCntCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("tro_ib_cfm_ofc_cd", "troIbCfmOfcCd");
		this.hashFields.put("drp_off_chg_mnl_flg", "drpOffChgMnlFlg");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("dc_rmk", "dcRmk");
		this.hashFields.put("drp_off_chg_trf_seq", "drpOffChgTrfSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("cntr_rtn_yd_cd", "cntrRtnYdCd");
		this.hashFields.put("drp_off_chg_seq", "drpOffChgSeq");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cntr_rtn_dt", "cntrRtnDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("spcl_trf_amt", "spclTrfAmt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("inv_src_no", "invSrcNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("svc_fee_amt", "svcFeeAmt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("spcl_cust_seq", "spclCustSeq");
		this.hashFields.put("tro_ib_cfm_dt", "troIbCfmDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return genTrfAmt
	 */
	public String getGenTrfAmt() {
		return this.genTrfAmt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return spclCustCntCd
	 */
	public String getSpclCustCntCd() {
		return this.spclCustCntCd;
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
	 * @return troIbCfmOfcCd
	 */
	public String getTroIbCfmOfcCd() {
		return this.troIbCfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return drpOffChgMnlFlg
	 */
	public String getDrpOffChgMnlFlg() {
		return this.drpOffChgMnlFlg;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return dcRmk
	 */
	public String getDcRmk() {
		return this.dcRmk;
	}
	
	/**
	 * Column Info
	 * @return drpOffChgTrfSeq
	 */
	public String getDrpOffChgTrfSeq() {
		return this.drpOffChgTrfSeq;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return dcAmt
	 */
	public String getDcAmt() {
		return this.dcAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrRtnYdCd
	 */
	public String getCntrRtnYdCd() {
		return this.cntrRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return drpOffChgSeq
	 */
	public String getDrpOffChgSeq() {
		return this.drpOffChgSeq;
	}
	
	/**
	 * Column Info
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
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
	 * @return cntrRtnDt
	 */
	public String getCntrRtnDt() {
		return this.cntrRtnDt;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return spclTrfAmt
	 */
	public String getSpclTrfAmt() {
		return this.spclTrfAmt;
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
	 * @return invSrcNo
	 */
	public String getInvSrcNo() {
		return this.invSrcNo;
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
	 * @return svcFeeAmt
	 */
	public String getSvcFeeAmt() {
		return this.svcFeeAmt;
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
	 * @return spclCustSeq
	 */
	public String getSpclCustSeq() {
		return this.spclCustSeq;
	}
	
	/**
	 * Column Info
	 * @return troIbCfmDt
	 */
	public String getTroIbCfmDt() {
		return this.troIbCfmDt;
	}
	

	/**
	 * Column Info
	 * @param genTrfAmt
	 */
	public void setGenTrfAmt(String genTrfAmt) {
		this.genTrfAmt = genTrfAmt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param spclCustCntCd
	 */
	public void setSpclCustCntCd(String spclCustCntCd) {
		this.spclCustCntCd = spclCustCntCd;
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
	 * @param troIbCfmOfcCd
	 */
	public void setTroIbCfmOfcCd(String troIbCfmOfcCd) {
		this.troIbCfmOfcCd = troIbCfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param drpOffChgMnlFlg
	 */
	public void setDrpOffChgMnlFlg(String drpOffChgMnlFlg) {
		this.drpOffChgMnlFlg = drpOffChgMnlFlg;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param dcRmk
	 */
	public void setDcRmk(String dcRmk) {
		this.dcRmk = dcRmk;
	}
	
	/**
	 * Column Info
	 * @param drpOffChgTrfSeq
	 */
	public void setDrpOffChgTrfSeq(String drpOffChgTrfSeq) {
		this.drpOffChgTrfSeq = drpOffChgTrfSeq;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param dcAmt
	 */
	public void setDcAmt(String dcAmt) {
		this.dcAmt = dcAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrRtnYdCd
	 */
	public void setCntrRtnYdCd(String cntrRtnYdCd) {
		this.cntrRtnYdCd = cntrRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param drpOffChgSeq
	 */
	public void setDrpOffChgSeq(String drpOffChgSeq) {
		this.drpOffChgSeq = drpOffChgSeq;
	}
	
	/**
	 * Column Info
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
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
	 * @param cntrRtnDt
	 */
	public void setCntrRtnDt(String cntrRtnDt) {
		this.cntrRtnDt = cntrRtnDt;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param spclTrfAmt
	 */
	public void setSpclTrfAmt(String spclTrfAmt) {
		this.spclTrfAmt = spclTrfAmt;
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
	 * @param invSrcNo
	 */
	public void setInvSrcNo(String invSrcNo) {
		this.invSrcNo = invSrcNo;
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
	 * @param svcFeeAmt
	 */
	public void setSvcFeeAmt(String svcFeeAmt) {
		this.svcFeeAmt = svcFeeAmt;
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
	 * @param spclCustSeq
	 */
	public void setSpclCustSeq(String spclCustSeq) {
		this.spclCustSeq = spclCustSeq;
	}
	
	/**
	 * Column Info
	 * @param troIbCfmDt
	 */
	public void setTroIbCfmDt(String troIbCfmDt) {
		this.troIbCfmDt = troIbCfmDt;
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
		setGenTrfAmt(JSPUtil.getParameter(request, prefix + "gen_trf_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setSpclCustCntCd(JSPUtil.getParameter(request, prefix + "spcl_cust_cnt_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTroIbCfmOfcCd(JSPUtil.getParameter(request, prefix + "tro_ib_cfm_ofc_cd", ""));
		setDrpOffChgMnlFlg(JSPUtil.getParameter(request, prefix + "drp_off_chg_mnl_flg", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setDcRmk(JSPUtil.getParameter(request, prefix + "dc_rmk", ""));
		setDrpOffChgTrfSeq(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDcAmt(JSPUtil.getParameter(request, prefix + "dc_amt", ""));
		setCntrRtnYdCd(JSPUtil.getParameter(request, prefix + "cntr_rtn_yd_cd", ""));
		setDrpOffChgSeq(JSPUtil.getParameter(request, prefix + "drp_off_chg_seq", ""));
		setArIfNo(JSPUtil.getParameter(request, prefix + "ar_if_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCntrRtnDt(JSPUtil.getParameter(request, prefix + "cntr_rtn_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSpclTrfAmt(JSPUtil.getParameter(request, prefix + "spcl_trf_amt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setInvSrcNo(JSPUtil.getParameter(request, prefix + "inv_src_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSvcFeeAmt(JSPUtil.getParameter(request, prefix + "svc_fee_amt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSpclCustSeq(JSPUtil.getParameter(request, prefix + "spcl_cust_seq", ""));
		setTroIbCfmDt(JSPUtil.getParameter(request, prefix + "tro_ib_cfm_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DodDrpOffChgVO[]
	 */
	public DodDrpOffChgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DodDrpOffChgVO[]
	 */
	public DodDrpOffChgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DodDrpOffChgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] genTrfAmt = (JSPUtil.getParameter(request, prefix	+ "gen_trf_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] spclCustCntCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cust_cnt_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] troIbCfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "tro_ib_cfm_ofc_cd", length));
			String[] drpOffChgMnlFlg = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_mnl_flg", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] dcRmk = (JSPUtil.getParameter(request, prefix	+ "dc_rmk", length));
			String[] drpOffChgTrfSeq = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] cntrRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_yd_cd", length));
			String[] drpOffChgSeq = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_seq", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] cntrRtnDt = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] spclTrfAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_trf_amt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] invSrcNo = (JSPUtil.getParameter(request, prefix	+ "inv_src_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] svcFeeAmt = (JSPUtil.getParameter(request, prefix	+ "svc_fee_amt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] spclCustSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cust_seq", length));
			String[] troIbCfmDt = (JSPUtil.getParameter(request, prefix	+ "tro_ib_cfm_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DodDrpOffChgVO();
				if (genTrfAmt[i] != null)
					model.setGenTrfAmt(genTrfAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (spclCustCntCd[i] != null)
					model.setSpclCustCntCd(spclCustCntCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (troIbCfmOfcCd[i] != null)
					model.setTroIbCfmOfcCd(troIbCfmOfcCd[i]);
				if (drpOffChgMnlFlg[i] != null)
					model.setDrpOffChgMnlFlg(drpOffChgMnlFlg[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (dcRmk[i] != null)
					model.setDcRmk(dcRmk[i]);
				if (drpOffChgTrfSeq[i] != null)
					model.setDrpOffChgTrfSeq(drpOffChgTrfSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dcAmt[i] != null)
					model.setDcAmt(dcAmt[i]);
				if (cntrRtnYdCd[i] != null)
					model.setCntrRtnYdCd(cntrRtnYdCd[i]);
				if (drpOffChgSeq[i] != null)
					model.setDrpOffChgSeq(drpOffChgSeq[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (cntrRtnDt[i] != null)
					model.setCntrRtnDt(cntrRtnDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (spclTrfAmt[i] != null)
					model.setSpclTrfAmt(spclTrfAmt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (invSrcNo[i] != null)
					model.setInvSrcNo(invSrcNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (svcFeeAmt[i] != null)
					model.setSvcFeeAmt(svcFeeAmt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (spclCustSeq[i] != null)
					model.setSpclCustSeq(spclCustSeq[i]);
				if (troIbCfmDt[i] != null)
					model.setTroIbCfmDt(troIbCfmDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDodDrpOffChgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DodDrpOffChgVO[]
	 */
	public DodDrpOffChgVO[] getDodDrpOffChgVOs(){
		DodDrpOffChgVO[] vos = (DodDrpOffChgVO[])models.toArray(new DodDrpOffChgVO[models.size()]);
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
		this.genTrfAmt = this.genTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustCntCd = this.spclCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troIbCfmOfcCd = this.troIbCfmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgMnlFlg = this.drpOffChgMnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcRmk = this.dcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfSeq = this.drpOffChgTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnYdCd = this.cntrRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgSeq = this.drpOffChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnDt = this.cntrRtnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclTrfAmt = this.spclTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSrcNo = this.invSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcFeeAmt = this.svcFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustSeq = this.spclCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troIbCfmDt = this.troIbCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
