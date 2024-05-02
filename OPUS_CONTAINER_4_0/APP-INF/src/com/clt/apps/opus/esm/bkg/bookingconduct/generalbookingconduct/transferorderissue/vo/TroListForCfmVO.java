/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TroListForCfmVO.java
*@FileTitle : TroListForCfmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.12.23 이남경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이남경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TroListForCfmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TroListForCfmVO> models = new ArrayList<TroListForCfmVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String trnsRevAmt = null;
	/* Column Info */
	private String cntrPkupYdCd = null;
	/* Column Info */
	private String znCd = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String payerSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrRtnYdCd = null;
	/* Column Info */
	private String allInRtCd = null;
	/* Column Info */
	private String vatFlg = null;
	/* Column Info */
	private String t1DocFlg = null;
	/* Column Info */
	private String hlgTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String corrNo = null;
	/* Column Info */
	private String bkgTrspMzdCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cfmFlgOld = null;
	/* Column Info */
	private String troSeqDisp = null;
	/* Column Info */
	private String payerCntCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String addRevAmt = null;
	/* Column Info */
	private String addRevChgCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TroListForCfmVO() {}

	public TroListForCfmVO(String ibflag, String pagerows, String troSeq, String troSeqDisp, String cntrNo, String cfmFlg, String currCd, String corrNo, String trnsRevAmt, String allInRtCd, String t1DocFlg, String vatFlg, String cxlFlg, String updUsrId, String updDt, String bkgNo, String ioBndCd, String hlgTpCd, String cfmDt, String payerCntCd, String payerSeq, String cfmFlgOld, String bkgTrspMzdCd, String cntrPkupYdCd, String cntrRtnYdCd, String znCd, String cntrTpszCd, String addRevAmt, String addRevChgCd) {
		this.currCd = currCd;
		this.trnsRevAmt = trnsRevAmt;
		this.cntrPkupYdCd = cntrPkupYdCd;
		this.znCd = znCd;
		this.cxlFlg = cxlFlg;
		this.payerSeq = payerSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntrRtnYdCd = cntrRtnYdCd;
		this.allInRtCd = allInRtCd;
		this.vatFlg = vatFlg;
		this.t1DocFlg = t1DocFlg;
		this.hlgTpCd = hlgTpCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.troSeq = troSeq;
		this.cfmDt = cfmDt;
		this.corrNo = corrNo;
		this.bkgTrspMzdCd = bkgTrspMzdCd;
		this.ioBndCd = ioBndCd;
		this.cfmFlg = cfmFlg;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.cfmFlgOld = cfmFlgOld;
		this.troSeqDisp = troSeqDisp;
		this.payerCntCd = payerCntCd;
		this.cntrTpszCd = cntrTpszCd;
		this.addRevAmt = addRevAmt;
		this.addRevChgCd = addRevChgCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("trns_rev_amt", getTrnsRevAmt());
		this.hashColumns.put("cntr_pkup_yd_cd", getCntrPkupYdCd());
		this.hashColumns.put("zn_cd", getZnCd());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("payer_seq", getPayerSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_rtn_yd_cd", getCntrRtnYdCd());
		this.hashColumns.put("all_in_rt_cd", getAllInRtCd());
		this.hashColumns.put("vat_flg", getVatFlg());
		this.hashColumns.put("t1_doc_flg", getT1DocFlg());
		this.hashColumns.put("hlg_tp_cd", getHlgTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("corr_no", getCorrNo());
		this.hashColumns.put("bkg_trsp_mzd_cd", getBkgTrspMzdCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cfm_flg_old", getCfmFlgOld());
		this.hashColumns.put("tro_seq_disp", getTroSeqDisp());
		this.hashColumns.put("payer_cnt_cd", getPayerCntCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("add_rev_amt", getAddRevAmt());
		this.hashColumns.put("add_rev_chg_cd", getAddRevChgCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("trns_rev_amt", "trnsRevAmt");
		this.hashFields.put("cntr_pkup_yd_cd", "cntrPkupYdCd");
		this.hashFields.put("zn_cd", "znCd");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("payer_seq", "payerSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_rtn_yd_cd", "cntrRtnYdCd");
		this.hashFields.put("all_in_rt_cd", "allInRtCd");
		this.hashFields.put("vat_flg", "vatFlg");
		this.hashFields.put("t1_doc_flg", "t1DocFlg");
		this.hashFields.put("hlg_tp_cd", "hlgTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("corr_no", "corrNo");
		this.hashFields.put("bkg_trsp_mzd_cd", "bkgTrspMzdCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cfm_flg_old", "cfmFlgOld");
		this.hashFields.put("tro_seq_disp", "troSeqDisp");
		this.hashFields.put("payer_cnt_cd", "payerCntCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("add_rev_amt", "addRevAmt");
		this.hashFields.put("add_rev_chg_cd", "addRevChgCd");
		return this.hashFields;
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
	 * @return trnsRevAmt
	 */
	public String getTrnsRevAmt() {
		return this.trnsRevAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrPkupYdCd
	 */
	public String getCntrPkupYdCd() {
		return this.cntrPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return znCd
	 */
	public String getZnCd() {
		return this.znCd;
	}
	
	/**
	 * Column Info
	 * @return cxlFlg
	 */
	public String getCxlFlg() {
		return this.cxlFlg;
	}
	
	/**
	 * Column Info
	 * @return payerSeq
	 */
	public String getPayerSeq() {
		return this.payerSeq;
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
	 * @return cntrRtnYdCd
	 */
	public String getCntrRtnYdCd() {
		return this.cntrRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return allInRtCd
	 */
	public String getAllInRtCd() {
		return this.allInRtCd;
	}
	
	/**
	 * Column Info
	 * @return vatFlg
	 */
	public String getVatFlg() {
		return this.vatFlg;
	}
	
	/**
	 * Column Info
	 * @return t1DocFlg
	 */
	public String getT1DocFlg() {
		return this.t1DocFlg;
	}
	
	/**
	 * Column Info
	 * @return hlgTpCd
	 */
	public String getHlgTpCd() {
		return this.hlgTpCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
	}
	
	/**
	 * Column Info
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
	}
	
	/**
	 * Column Info
	 * @return corrNo
	 */
	public String getCorrNo() {
		return this.corrNo;
	}
	
	/**
	 * Column Info
	 * @return bkgTrspMzdCd
	 */
	public String getBkgTrspMzdCd() {
		return this.bkgTrspMzdCd;
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
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cfmFlgOld
	 */
	public String getCfmFlgOld() {
		return this.cfmFlgOld;
	}
	
	/**
	 * Column Info
	 * @return troSeqDisp
	 */
	public String getTroSeqDisp() {
		return this.troSeqDisp;
	}
	
	/**
	 * Column Info
	 * @return payerCntCd
	 */
	public String getPayerCntCd() {
		return this.payerCntCd;
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
	 * @return addRevAmt
	 */
	public String getAddRevAmt() {
		return this.addRevAmt;
	}
	
	/**
	 * Column Info
	 * @return addRevAmt
	 */
	public String getAddRevChgCd() {
		return this.addRevChgCd;
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
	 * @param trnsRevAmt
	 */
	public void setTrnsRevAmt(String trnsRevAmt) {
		this.trnsRevAmt = trnsRevAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrPkupYdCd
	 */
	public void setCntrPkupYdCd(String cntrPkupYdCd) {
		this.cntrPkupYdCd = cntrPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param znCd
	 */
	public void setZnCd(String znCd) {
		this.znCd = znCd;
	}
	
	/**
	 * Column Info
	 * @param cxlFlg
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
	}
	
	/**
	 * Column Info
	 * @param payerSeq
	 */
	public void setPayerSeq(String payerSeq) {
		this.payerSeq = payerSeq;
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
	 * @param cntrRtnYdCd
	 */
	public void setCntrRtnYdCd(String cntrRtnYdCd) {
		this.cntrRtnYdCd = cntrRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param allInRtCd
	 */
	public void setAllInRtCd(String allInRtCd) {
		this.allInRtCd = allInRtCd;
	}
	
	/**
	 * Column Info
	 * @param vatFlg
	 */
	public void setVatFlg(String vatFlg) {
		this.vatFlg = vatFlg;
	}
	
	/**
	 * Column Info
	 * @param t1DocFlg
	 */
	public void setT1DocFlg(String t1DocFlg) {
		this.t1DocFlg = t1DocFlg;
	}
	
	/**
	 * Column Info
	 * @param hlgTpCd
	 */
	public void setHlgTpCd(String hlgTpCd) {
		this.hlgTpCd = hlgTpCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}
	
	/**
	 * Column Info
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
	}
	
	/**
	 * Column Info
	 * @param corrNo
	 */
	public void setCorrNo(String corrNo) {
		this.corrNo = corrNo;
	}
	
	/**
	 * Column Info
	 * @param bkgTrspMzdCd
	 */
	public void setBkgTrspMzdCd(String bkgTrspMzdCd) {
		this.bkgTrspMzdCd = bkgTrspMzdCd;
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
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cfmFlgOld
	 */
	public void setCfmFlgOld(String cfmFlgOld) {
		this.cfmFlgOld = cfmFlgOld;
	}
	
	/**
	 * Column Info
	 * @param troSeqDisp
	 */
	public void setTroSeqDisp(String troSeqDisp) {
		this.troSeqDisp = troSeqDisp;
	}
	
	/**
	 * Column Info
	 * @param payerCntCd
	 */
	public void setPayerCntCd(String payerCntCd) {
		this.payerCntCd = payerCntCd;
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
	 * @param addRevAmt
	 */
	public void setAddRevAmt(String addRevAmt) {
		this.addRevAmt = addRevAmt;
	}
	
	/**
	 * Column Info
	 * @param addRevChgCd
	 */
	public void setAddRevChgCd(String addRevChgCd) {
		this.addRevChgCd = addRevChgCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setTrnsRevAmt(JSPUtil.getParameter(request, "trns_rev_amt", ""));
		setCntrPkupYdCd(JSPUtil.getParameter(request, "cntr_pkup_yd_cd", ""));
		setZnCd(JSPUtil.getParameter(request, "zn_cd", ""));
		setCxlFlg(JSPUtil.getParameter(request, "cxl_flg", ""));
		setPayerSeq(JSPUtil.getParameter(request, "payer_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrRtnYdCd(JSPUtil.getParameter(request, "cntr_rtn_yd_cd", ""));
		setAllInRtCd(JSPUtil.getParameter(request, "all_in_rt_cd", ""));
		setVatFlg(JSPUtil.getParameter(request, "vat_flg", ""));
		setT1DocFlg(JSPUtil.getParameter(request, "t1_doc_flg", ""));
		setHlgTpCd(JSPUtil.getParameter(request, "hlg_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setTroSeq(JSPUtil.getParameter(request, "tro_seq", ""));
		setCfmDt(JSPUtil.getParameter(request, "cfm_dt", ""));
		setCorrNo(JSPUtil.getParameter(request, "corr_no", ""));
		setBkgTrspMzdCd(JSPUtil.getParameter(request, "bkg_trsp_mzd_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setCfmFlg(JSPUtil.getParameter(request, "cfm_flg", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCfmFlgOld(JSPUtil.getParameter(request, "cfm_flg_old", ""));
		setTroSeqDisp(JSPUtil.getParameter(request, "tro_seq_disp", ""));
		setPayerCntCd(JSPUtil.getParameter(request, "payer_cnt_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setAddRevAmt(JSPUtil.getParameter(request, "add_rev_amt", ""));
		setAddRevChgCd(JSPUtil.getParameter(request, "add_rev_chg_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TroListForCfmVO[]
	 */
	public TroListForCfmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TroListForCfmVO[]
	 */
	public TroListForCfmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TroListForCfmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] trnsRevAmt = (JSPUtil.getParameter(request, prefix	+ "trns_rev_amt", length));
			String[] cntrPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_yd_cd", length));
			String[] znCd = (JSPUtil.getParameter(request, prefix	+ "zn_cd", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] payerSeq = (JSPUtil.getParameter(request, prefix	+ "payer_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_yd_cd", length));
			String[] allInRtCd = (JSPUtil.getParameter(request, prefix	+ "all_in_rt_cd", length));
			String[] vatFlg = (JSPUtil.getParameter(request, prefix	+ "vat_flg", length));
			String[] t1DocFlg = (JSPUtil.getParameter(request, prefix	+ "t1_doc_flg", length));
			String[] hlgTpCd = (JSPUtil.getParameter(request, prefix	+ "hlg_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] corrNo = (JSPUtil.getParameter(request, prefix	+ "corr_no", length));
			String[] bkgTrspMzdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_trsp_mzd_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cfmFlgOld = (JSPUtil.getParameter(request, prefix	+ "cfm_flg_old", length));
			String[] troSeqDisp = (JSPUtil.getParameter(request, prefix	+ "tro_seq_disp", length));
			String[] payerCntCd = (JSPUtil.getParameter(request, prefix	+ "payer_cnt_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] addRevAmt = (JSPUtil.getParameter(request, prefix	+ "add_rev_amt", length));
			String[] addRevChgCd = (JSPUtil.getParameter(request, prefix+ "add_rev_chg_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TroListForCfmVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (trnsRevAmt[i] != null)
					model.setTrnsRevAmt(trnsRevAmt[i]);
				if (cntrPkupYdCd[i] != null)
					model.setCntrPkupYdCd(cntrPkupYdCd[i]);
				if (znCd[i] != null)
					model.setZnCd(znCd[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (payerSeq[i] != null)
					model.setPayerSeq(payerSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrRtnYdCd[i] != null)
					model.setCntrRtnYdCd(cntrRtnYdCd[i]);
				if (allInRtCd[i] != null)
					model.setAllInRtCd(allInRtCd[i]);
				if (vatFlg[i] != null)
					model.setVatFlg(vatFlg[i]);
				if (t1DocFlg[i] != null)
					model.setT1DocFlg(t1DocFlg[i]);
				if (hlgTpCd[i] != null)
					model.setHlgTpCd(hlgTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (corrNo[i] != null)
					model.setCorrNo(corrNo[i]);
				if (bkgTrspMzdCd[i] != null)
					model.setBkgTrspMzdCd(bkgTrspMzdCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cfmFlgOld[i] != null)
					model.setCfmFlgOld(cfmFlgOld[i]);
				if (troSeqDisp[i] != null)
					model.setTroSeqDisp(troSeqDisp[i]);
				if (payerCntCd[i] != null)
					model.setPayerCntCd(payerCntCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (addRevAmt[i] != null)
					model.setAddRevAmt(addRevAmt[i]);
				if (addRevChgCd[i] != null)
					model.setAddRevChgCd(addRevChgCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTroListForCfmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TroListForCfmVO[]
	 */
	public TroListForCfmVO[] getTroListForCfmVOs(){
		TroListForCfmVO[] vos = (TroListForCfmVO[])models.toArray(new TroListForCfmVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsRevAmt = this.trnsRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupYdCd = this.cntrPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znCd = this.znCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerSeq = this.payerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnYdCd = this.cntrRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allInRtCd = this.allInRtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatFlg = this.vatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t1DocFlg = this.t1DocFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hlgTpCd = this.hlgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrNo = this.corrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrspMzdCd = this.bkgTrspMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlgOld = this.cfmFlgOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeqDisp = this.troSeqDisp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerCntCd = this.payerCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addRevAmt = this.addRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addRevChgCd = this.addRevChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
