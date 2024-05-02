/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceivableInvoiceCostVO.java
*@FileTitle : ReceivableInvoiceCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.09 장준우
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ReceivableInvoiceCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ReceivableInvoiceCostVO> models = new ArrayList<ReceivableInvoiceCostVO>();

	/* Column Info */
	private String offhLocCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String onhDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String rgstOfcCd = null;
	/* Column Info */
	private String costAmt = null;
	/* Column Info */
	private String bilDys = null;
	/* Column Info */
	private String lseRcvChgCreCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String bilToDt = null;
	/* Column Info */
	private String offhDt = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rgstDt = null;
	/* Column Info */
	private String rcvRntlSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rcvRntlDtlSeq = null;
	/* Column Info */
	private String bilFmDt = null;
	/* Column Info */
	private String rgstUsrId = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String autoInpFlg = null;
	/* Column Info */
	private String lseRcvChgTpCd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String onhLocCd = null;
	/* Column Info */
	private String ttlDys = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String freeDys = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String chgRtAmt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String crAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ReceivableInvoiceCostVO() {}

	public ReceivableInvoiceCostVO(String ibflag, String pagerows, String crAmt, String ofcCd, String costYrmon, String agmtCtyCd, String agmtSeq, String rcvRntlSeq, String rcvRntlDtlSeq, String agmtNo, String lstmCd, String cntrNo, String cntrTpszCd, String lseRcvChgTpCd, String onhDt, String onhLocCd, String offhDt, String offhLocCd, String ttlDys, String freeDys, String bilDys, String chgRtAmt, String costAmt, String bilFmDt, String bilToDt, String lseRcvChgCreCd, String autoInpFlg, String rgstOfcCd, String rgstUsrId, String rgstDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.offhLocCd = offhLocCd;
		this.creDt = creDt;
		this.onhDt = onhDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.rgstOfcCd = rgstOfcCd;
		this.costAmt = costAmt;
		this.bilDys = bilDys;
		this.lseRcvChgCreCd = lseRcvChgCreCd;
		this.cntrTpszCd = cntrTpszCd;
		this.agmtCtyCd = agmtCtyCd;
		this.bilToDt = bilToDt;
		this.offhDt = offhDt;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.rgstDt = rgstDt;
		this.rcvRntlSeq = rcvRntlSeq;
		this.updDt = updDt;
		this.rcvRntlDtlSeq = rcvRntlDtlSeq;
		this.bilFmDt = bilFmDt;
		this.rgstUsrId = rgstUsrId;
		this.agmtSeq = agmtSeq;
		this.autoInpFlg = autoInpFlg;
		this.lseRcvChgTpCd = lseRcvChgTpCd;
		this.agmtNo = agmtNo;
		this.onhLocCd = onhLocCd;
		this.ttlDys = ttlDys;
		this.creUsrId = creUsrId;
		this.freeDys = freeDys;
		this.cntrNo = cntrNo;
		this.chgRtAmt = chgRtAmt;
		this.ofcCd = ofcCd;
		this.crAmt = crAmt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("offh_loc_cd", getOffhLocCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("rgst_ofc_cd", getRgstOfcCd());
		this.hashColumns.put("cost_amt", getCostAmt());
		this.hashColumns.put("bil_dys", getBilDys());
		this.hashColumns.put("lse_rcv_chg_cre_cd", getLseRcvChgCreCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("bil_to_dt", getBilToDt());
		this.hashColumns.put("offh_dt", getOffhDt());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rgst_dt", getRgstDt());
		this.hashColumns.put("rcv_rntl_seq", getRcvRntlSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rcv_rntl_dtl_seq", getRcvRntlDtlSeq());
		this.hashColumns.put("bil_fm_dt", getBilFmDt());
		this.hashColumns.put("rgst_usr_id", getRgstUsrId());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("auto_inp_flg", getAutoInpFlg());
		this.hashColumns.put("lse_rcv_chg_tp_cd", getLseRcvChgTpCd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("onh_loc_cd", getOnhLocCd());
		this.hashColumns.put("ttl_dys", getTtlDys());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("free_dys", getFreeDys());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("chg_rt_amt", getChgRtAmt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cr_amt", getCrAmt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("offh_loc_cd", "offhLocCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("rgst_ofc_cd", "rgstOfcCd");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("bil_dys", "bilDys");
		this.hashFields.put("lse_rcv_chg_cre_cd", "lseRcvChgCreCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("bil_to_dt", "bilToDt");
		this.hashFields.put("offh_dt", "offhDt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rgst_dt", "rgstDt");
		this.hashFields.put("rcv_rntl_seq", "rcvRntlSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rcv_rntl_dtl_seq", "rcvRntlDtlSeq");
		this.hashFields.put("bil_fm_dt", "bilFmDt");
		this.hashFields.put("rgst_usr_id", "rgstUsrId");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("auto_inp_flg", "autoInpFlg");
		this.hashFields.put("lse_rcv_chg_tp_cd", "lseRcvChgTpCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("onh_loc_cd", "onhLocCd");
		this.hashFields.put("ttl_dys", "ttlDys");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("free_dys", "freeDys");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("chg_rt_amt", "chgRtAmt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cr_amt", "crAmt");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return offhLocCd
	 */
	public String getOffhLocCd() {
		return this.offhLocCd;
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
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}

	/**
	 * Column Info
	 * @return rgstOfcCd
	 */
	public String getRgstOfcCd() {
		return this.rgstOfcCd;
	}

	/**
	 * Column Info
	 * @return costAmt
	 */
	public String getCostAmt() {
		return this.costAmt;
	}

	/**
	 * Column Info
	 * @return bilDys
	 */
	public String getBilDys() {
		return this.bilDys;
	}

	/**
	 * Column Info
	 * @return lseRcvChgCreCd
	 */
	public String getLseRcvChgCreCd() {
		return this.lseRcvChgCreCd;
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
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}

	/**
	 * Column Info
	 * @return bilToDt
	 */
	public String getBilToDt() {
		return this.bilToDt;
	}

	/**
	 * Column Info
	 * @return offhDt
	 */
	public String getOffhDt() {
		return this.offhDt;
	}

	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return rgstDt
	 */
	public String getRgstDt() {
		return this.rgstDt;
	}

	/**
	 * Column Info
	 * @return rcvRntlSeq
	 */
	public String getRcvRntlSeq() {
		return this.rcvRntlSeq;
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
	 * @return rcvRntlDtlSeq
	 */
	public String getRcvRntlDtlSeq() {
		return this.rcvRntlDtlSeq;
	}

	/**
	 * Column Info
	 * @return bilFmDt
	 */
	public String getBilFmDt() {
		return this.bilFmDt;
	}

	/**
	 * Column Info
	 * @return rgstUsrId
	 */
	public String getRgstUsrId() {
		return this.rgstUsrId;
	}

	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}

	/**
	 * Column Info
	 * @return autoInpFlg
	 */
	public String getAutoInpFlg() {
		return this.autoInpFlg;
	}

	/**
	 * Column Info
	 * @return lseRcvChgTpCd
	 */
	public String getLseRcvChgTpCd() {
		return this.lseRcvChgTpCd;
	}

	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}

	/**
	 * Column Info
	 * @return onhLocCd
	 */
	public String getOnhLocCd() {
		return this.onhLocCd;
	}

	/**
	 * Column Info
	 * @return ttlDys
	 */
	public String getTtlDys() {
		return this.ttlDys;
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
	 * @return freeDys
	 */
	public String getFreeDys() {
		return this.freeDys;
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
	 * @return chgRtAmt
	 */
	public String getChgRtAmt() {
		return this.chgRtAmt;
	}


	/**
	 * Column Info
	 * @param offhLocCd
	 */
	public void setOffhLocCd(String offhLocCd) {
		this.offhLocCd = offhLocCd;
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
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}

	/**
	 * Column Info
	 * @param rgstOfcCd
	 */
	public void setRgstOfcCd(String rgstOfcCd) {
		this.rgstOfcCd = rgstOfcCd;
	}

	/**
	 * Column Info
	 * @param costAmt
	 */
	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
	}

	/**
	 * Column Info
	 * @param bilDys
	 */
	public void setBilDys(String bilDys) {
		this.bilDys = bilDys;
	}

	/**
	 * Column Info
	 * @param lseRcvChgCreCd
	 */
	public void setLseRcvChgCreCd(String lseRcvChgCreCd) {
		this.lseRcvChgCreCd = lseRcvChgCreCd;
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
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	/**
	 * Column Info
	 * @param bilToDt
	 */
	public void setBilToDt(String bilToDt) {
		this.bilToDt = bilToDt;
	}

	/**
	 * Column Info
	 * @param offhDt
	 */
	public void setOffhDt(String offhDt) {
		this.offhDt = offhDt;
	}

	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param rgstDt
	 */
	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}

	/**
	 * Column Info
	 * @param rcvRntlSeq
	 */
	public void setRcvRntlSeq(String rcvRntlSeq) {
		this.rcvRntlSeq = rcvRntlSeq;
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
	 * @param rcvRntlDtlSeq
	 */
	public void setRcvRntlDtlSeq(String rcvRntlDtlSeq) {
		this.rcvRntlDtlSeq = rcvRntlDtlSeq;
	}

	/**
	 * Column Info
	 * @param bilFmDt
	 */
	public void setBilFmDt(String bilFmDt) {
		this.bilFmDt = bilFmDt;
	}

	/**
	 * Column Info
	 * @param rgstUsrId
	 */
	public void setRgstUsrId(String rgstUsrId) {
		this.rgstUsrId = rgstUsrId;
	}

	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	/**
	 * Column Info
	 * @param autoInpFlg
	 */
	public void setAutoInpFlg(String autoInpFlg) {
		this.autoInpFlg = autoInpFlg;
	}

	/**
	 * Column Info
	 * @param lseRcvChgTpCd
	 */
	public void setLseRcvChgTpCd(String lseRcvChgTpCd) {
		this.lseRcvChgTpCd = lseRcvChgTpCd;
	}

	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	/**
	 * Column Info
	 * @param onhLocCd
	 */
	public void setOnhLocCd(String onhLocCd) {
		this.onhLocCd = onhLocCd;
	}

	/**
	 * Column Info
	 * @param ttlDys
	 */
	public void setTtlDys(String ttlDys) {
		this.ttlDys = ttlDys;
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
	 * @param freeDys
	 */
	public void setFreeDys(String freeDys) {
		this.freeDys = freeDys;
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
	 * @param chgRtAmt
	 */
	public void setChgRtAmt(String chgRtAmt) {
		this.chgRtAmt = chgRtAmt;
	}


	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @return the crAmt
	 */
	public String getCrAmt() {
		return crAmt;
	}

	/**
	 * @param crAmt the crAmt to set
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOffhLocCd(JSPUtil.getParameter(request, "offh_loc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setRgstOfcCd(JSPUtil.getParameter(request, "rgst_ofc_cd", ""));
		setCostAmt(JSPUtil.getParameter(request, "cost_amt", ""));
		setBilDys(JSPUtil.getParameter(request, "bil_dys", ""));
		setLseRcvChgCreCd(JSPUtil.getParameter(request, "lse_rcv_chg_cre_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setBilToDt(JSPUtil.getParameter(request, "bil_to_dt", ""));
		setOffhDt(JSPUtil.getParameter(request, "offh_dt", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRgstDt(JSPUtil.getParameter(request, "rgst_dt", ""));
		setRcvRntlSeq(JSPUtil.getParameter(request, "rcv_rntl_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRcvRntlDtlSeq(JSPUtil.getParameter(request, "rcv_rntl_dtl_seq", ""));
		setBilFmDt(JSPUtil.getParameter(request, "bil_fm_dt", ""));
		setRgstUsrId(JSPUtil.getParameter(request, "rgst_usr_id", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAutoInpFlg(JSPUtil.getParameter(request, "auto_inp_flg", ""));
		setLseRcvChgTpCd(JSPUtil.getParameter(request, "lse_rcv_chg_tp_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setOnhLocCd(JSPUtil.getParameter(request, "onh_loc_cd", ""));
		setTtlDys(JSPUtil.getParameter(request, "ttl_dys", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setFreeDys(JSPUtil.getParameter(request, "free_dys", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setChgRtAmt(JSPUtil.getParameter(request, "chg_rt_amt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceivableInvoiceCostVO[]
	 */
	public ReceivableInvoiceCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ReceivableInvoiceCostVO[]
	 */
	public ReceivableInvoiceCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReceivableInvoiceCostVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] offhLocCd = (JSPUtil.getParameter(request, prefix	+ "offh_loc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] rgstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgst_ofc_cd", length));
			String[] costAmt = (JSPUtil.getParameter(request, prefix	+ "cost_amt", length));
			String[] bilDys = (JSPUtil.getParameter(request, prefix	+ "bil_dys", length));
			String[] lseRcvChgCreCd = (JSPUtil.getParameter(request, prefix	+ "lse_rcv_chg_cre_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] bilToDt = (JSPUtil.getParameter(request, prefix	+ "bil_to_dt", length));
			String[] offhDt = (JSPUtil.getParameter(request, prefix	+ "offh_dt", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rgstDt = (JSPUtil.getParameter(request, prefix	+ "rgst_dt", length));
			String[] rcvRntlSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_rntl_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rcvRntlDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_rntl_dtl_seq", length));
			String[] bilFmDt = (JSPUtil.getParameter(request, prefix	+ "bil_fm_dt", length));
			String[] rgstUsrId = (JSPUtil.getParameter(request, prefix	+ "rgst_usr_id", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] autoInpFlg = (JSPUtil.getParameter(request, prefix	+ "auto_inp_flg", length));
			String[] lseRcvChgTpCd = (JSPUtil.getParameter(request, prefix	+ "lse_rcv_chg_tp_cd", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] onhLocCd = (JSPUtil.getParameter(request, prefix	+ "onh_loc_cd", length));
			String[] ttlDys = (JSPUtil.getParameter(request, prefix	+ "ttl_dys", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] freeDys = (JSPUtil.getParameter(request, prefix	+ "free_dys", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] chgRtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_rt_amt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));

			for (int i = 0; i < length; i++) {
				model = new ReceivableInvoiceCostVO();
				if (offhLocCd[i] != null)
					model.setOffhLocCd(offhLocCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (rgstOfcCd[i] != null)
					model.setRgstOfcCd(rgstOfcCd[i]);
				if (costAmt[i] != null)
					model.setCostAmt(costAmt[i]);
				if (bilDys[i] != null)
					model.setBilDys(bilDys[i]);
				if (lseRcvChgCreCd[i] != null)
					model.setLseRcvChgCreCd(lseRcvChgCreCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (bilToDt[i] != null)
					model.setBilToDt(bilToDt[i]);
				if (offhDt[i] != null)
					model.setOffhDt(offhDt[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rgstDt[i] != null)
					model.setRgstDt(rgstDt[i]);
				if (rcvRntlSeq[i] != null)
					model.setRcvRntlSeq(rcvRntlSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rcvRntlDtlSeq[i] != null)
					model.setRcvRntlDtlSeq(rcvRntlDtlSeq[i]);
				if (bilFmDt[i] != null)
					model.setBilFmDt(bilFmDt[i]);
				if (rgstUsrId[i] != null)
					model.setRgstUsrId(rgstUsrId[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (autoInpFlg[i] != null)
					model.setAutoInpFlg(autoInpFlg[i]);
				if (lseRcvChgTpCd[i] != null)
					model.setLseRcvChgTpCd(lseRcvChgTpCd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (onhLocCd[i] != null)
					model.setOnhLocCd(onhLocCd[i]);
				if (ttlDys[i] != null)
					model.setTtlDys(ttlDys[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (freeDys[i] != null)
					model.setFreeDys(freeDys[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (chgRtAmt[i] != null)
					model.setChgRtAmt(chgRtAmt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReceivableInvoiceContainerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReceivableInvoiceCostVO[]
	 */
	public ReceivableInvoiceCostVO[] getReceivableInvoiceContainerVOs(){
		ReceivableInvoiceCostVO[] vos = (ReceivableInvoiceCostVO[])models.toArray(new ReceivableInvoiceCostVO[models.size()]);
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
		this.offhLocCd = this.offhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstOfcCd = this.rgstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt = this.costAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilDys = this.bilDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseRcvChgCreCd = this.lseRcvChgCreCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToDt = this.bilToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDt = this.offhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstDt = this.rgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvRntlSeq = this.rcvRntlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvRntlDtlSeq = this.rcvRntlDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilFmDt = this.bilFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstUsrId = this.rgstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInpFlg = this.autoInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseRcvChgTpCd = this.lseRcvChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhLocCd = this.onhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDys = this.ttlDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDys = this.freeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRtAmt = this.chgRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
