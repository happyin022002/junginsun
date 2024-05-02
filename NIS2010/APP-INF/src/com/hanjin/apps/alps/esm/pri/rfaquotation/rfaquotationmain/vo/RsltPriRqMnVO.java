/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriRqMnVO.java
*@FileTitle : RsltPriRqMnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.24 이승준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo;

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
 * @author 이승준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriRqMnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriRqMnVO> models = new ArrayList<RsltPriRqMnVO>();
	
	/* Column Info */
	private String qttnSrepCd = null;
	/* Column Info */
	private String prsXchRtYrmon = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String qttnVerNoRead = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String estmMqcQty = null;
	/* Column Info */
	private String creDtTo = null;
	/* Column Info */
	private String svcScpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String qttnStsNm = null;
	/* Column Info */
	private String qttnVerNoHidden = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String prcCustTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String qttnSrepNm = null;
	/* Column Info */
	private String qttnStsCd = null;
	/* Column Info */
	private String creDtFrom = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cntrLodUtCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String qttnStatus = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String qttnNoHidden = null;
	/* Column Info */
	private String qttnVerNo = null;
	/* Column Info */
	private String qttnNo = null;
	/* Column Info */
	private String estmCmAmt = null;
	/* Column Info */
	private String qttnNoRead = null;
	/* Column Info */
	private String iscopy = null;
	/* Column Info */
	private String qttnOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriRqMnVO() {}

	public RsltPriRqMnVO(String ibflag, String pagerows, String qttnNo, String qttnVerNo, String effDt, String expDt, String svcScpCd, String custCntCd, String custSeq, String custNm, String cntrLodUtCd, String estmMqcQty, String estmCmAmt, String prcCustTpCd, String qttnSrepCd, String propNo, String prsXchRtYrmon, String qttnOfcCd, String qttnStsCd, String qttnStsNm, String creUsrId, String creDt, String updUsrId, String updDt, String qttnSrepNm, String svcScpNm, String iscopy, String qttnNoHidden, String qttnVerNoHidden, String creDtFrom, String creDtTo, String qttnNoRead, String qttnVerNoRead, String qttnStatus) {
		this.qttnSrepCd = qttnSrepCd;
		this.prsXchRtYrmon = prsXchRtYrmon;
		this.custNm = custNm;
		this.qttnVerNoRead = qttnVerNoRead;
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.estmMqcQty = estmMqcQty;
		this.creDtTo = creDtTo;
		this.svcScpNm = svcScpNm;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.qttnStsNm = qttnStsNm;
		this.qttnVerNoHidden = qttnVerNoHidden;
		this.expDt = expDt;
		this.prcCustTpCd = prcCustTpCd;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.qttnSrepNm = qttnSrepNm;
		this.qttnStsCd = qttnStsCd;
		this.creDtFrom = creDtFrom;
		this.custSeq = custSeq;
		this.cntrLodUtCd = cntrLodUtCd;
		this.creUsrId = creUsrId;
		this.qttnStatus = qttnStatus;
		this.propNo = propNo;
		this.qttnNoHidden = qttnNoHidden;
		this.qttnVerNo = qttnVerNo;
		this.qttnNo = qttnNo;
		this.estmCmAmt = estmCmAmt;
		this.qttnNoRead = qttnNoRead;
		this.iscopy = iscopy;
		this.qttnOfcCd = qttnOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("qttn_srep_cd", getQttnSrepCd());
		this.hashColumns.put("prs_xch_rt_yrmon", getPrsXchRtYrmon());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("qttn_ver_no_read", getQttnVerNoRead());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("estm_mqc_qty", getEstmMqcQty());
		this.hashColumns.put("cre_dt_to", getCreDtTo());
		this.hashColumns.put("svc_scp_nm", getSvcScpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("qttn_sts_nm", getQttnStsNm());
		this.hashColumns.put("qttn_ver_no_hidden", getQttnVerNoHidden());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("prc_cust_tp_cd", getPrcCustTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("qttn_srep_nm", getQttnSrepNm());
		this.hashColumns.put("qttn_sts_cd", getQttnStsCd());
		this.hashColumns.put("cre_dt_from", getCreDtFrom());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cntr_lod_ut_cd", getCntrLodUtCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("qttn_status", getQttnStatus());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("qttn_no_hidden", getQttnNoHidden());
		this.hashColumns.put("qttn_ver_no", getQttnVerNo());
		this.hashColumns.put("qttn_no", getQttnNo());
		this.hashColumns.put("estm_cm_amt", getEstmCmAmt());
		this.hashColumns.put("qttn_no_read", getQttnNoRead());
		this.hashColumns.put("iscopy", getIscopy());
		this.hashColumns.put("qttn_ofc_cd", getQttnOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("qttn_srep_cd", "qttnSrepCd");
		this.hashFields.put("prs_xch_rt_yrmon", "prsXchRtYrmon");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("qttn_ver_no_read", "qttnVerNoRead");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("estm_mqc_qty", "estmMqcQty");
		this.hashFields.put("cre_dt_to", "creDtTo");
		this.hashFields.put("svc_scp_nm", "svcScpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("qttn_sts_nm", "qttnStsNm");
		this.hashFields.put("qttn_ver_no_hidden", "qttnVerNoHidden");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("prc_cust_tp_cd", "prcCustTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("qttn_srep_nm", "qttnSrepNm");
		this.hashFields.put("qttn_sts_cd", "qttnStsCd");
		this.hashFields.put("cre_dt_from", "creDtFrom");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cntr_lod_ut_cd", "cntrLodUtCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("qttn_status", "qttnStatus");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("qttn_no_hidden", "qttnNoHidden");
		this.hashFields.put("qttn_ver_no", "qttnVerNo");
		this.hashFields.put("qttn_no", "qttnNo");
		this.hashFields.put("estm_cm_amt", "estmCmAmt");
		this.hashFields.put("qttn_no_read", "qttnNoRead");
		this.hashFields.put("iscopy", "iscopy");
		this.hashFields.put("qttn_ofc_cd", "qttnOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return qttnSrepCd
	 */
	public String getQttnSrepCd() {
		return this.qttnSrepCd;
	}
	
	/**
	 * Column Info
	 * @return prsXchRtYrmon
	 */
	public String getPrsXchRtYrmon() {
		return this.prsXchRtYrmon;
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
	 * @return qttnVerNoRead
	 */
	public String getQttnVerNoRead() {
		return this.qttnVerNoRead;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return estmMqcQty
	 */
	public String getEstmMqcQty() {
		return this.estmMqcQty;
	}
	
	/**
	 * Column Info
	 * @return creDtTo
	 */
	public String getCreDtTo() {
		return this.creDtTo;
	}
	
	/**
	 * Column Info
	 * @return svcScpNm
	 */
	public String getSvcScpNm() {
		return this.svcScpNm;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return qttnStsNm
	 */
	public String getQttnStsNm() {
		return this.qttnStsNm;
	}
	
	/**
	 * Column Info
	 * @return qttnVerNoHidden
	 */
	public String getQttnVerNoHidden() {
		return this.qttnVerNoHidden;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return prcCustTpCd
	 */
	public String getPrcCustTpCd() {
		return this.prcCustTpCd;
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
	 * @return qttnSrepNm
	 */
	public String getQttnSrepNm() {
		return this.qttnSrepNm;
	}
	
	/**
	 * Column Info
	 * @return qttnStsCd
	 */
	public String getQttnStsCd() {
		return this.qttnStsCd;
	}
	
	/**
	 * Column Info
	 * @return creDtFrom
	 */
	public String getCreDtFrom() {
		return this.creDtFrom;
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
	 * @return cntrLodUtCd
	 */
	public String getCntrLodUtCd() {
		return this.cntrLodUtCd;
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
	 * @return qttnStatus
	 */
	public String getQttnStatus() {
		return this.qttnStatus;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return qttnNoHidden
	 */
	public String getQttnNoHidden() {
		return this.qttnNoHidden;
	}
	
	/**
	 * Column Info
	 * @return qttnVerNo
	 */
	public String getQttnVerNo() {
		return this.qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @return qttnNo
	 */
	public String getQttnNo() {
		return this.qttnNo;
	}
	
	/**
	 * Column Info
	 * @return estmCmAmt
	 */
	public String getEstmCmAmt() {
		return this.estmCmAmt;
	}
	
	/**
	 * Column Info
	 * @return qttnNoRead
	 */
	public String getQttnNoRead() {
		return this.qttnNoRead;
	}
	
	/**
	 * Column Info
	 * @return iscopy
	 */
	public String getIscopy() {
		return this.iscopy;
	}
	
	/**
	 * Column Info
	 * @return qttnOfcCd
	 */
	public String getQttnOfcCd() {
		return this.qttnOfcCd;
	}
	

	/**
	 * Column Info
	 * @param qttnSrepCd
	 */
	public void setQttnSrepCd(String qttnSrepCd) {
		this.qttnSrepCd = qttnSrepCd;
	}
	
	/**
	 * Column Info
	 * @param prsXchRtYrmon
	 */
	public void setPrsXchRtYrmon(String prsXchRtYrmon) {
		this.prsXchRtYrmon = prsXchRtYrmon;
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
	 * @param qttnVerNoRead
	 */
	public void setQttnVerNoRead(String qttnVerNoRead) {
		this.qttnVerNoRead = qttnVerNoRead;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param estmMqcQty
	 */
	public void setEstmMqcQty(String estmMqcQty) {
		this.estmMqcQty = estmMqcQty;
	}
	
	/**
	 * Column Info
	 * @param creDtTo
	 */
	public void setCreDtTo(String creDtTo) {
		this.creDtTo = creDtTo;
	}
	
	/**
	 * Column Info
	 * @param svcScpNm
	 */
	public void setSvcScpNm(String svcScpNm) {
		this.svcScpNm = svcScpNm;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param qttnStsNm
	 */
	public void setQttnStsNm(String qttnStsNm) {
		this.qttnStsNm = qttnStsNm;
	}
	
	/**
	 * Column Info
	 * @param qttnVerNoHidden
	 */
	public void setQttnVerNoHidden(String qttnVerNoHidden) {
		this.qttnVerNoHidden = qttnVerNoHidden;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param prcCustTpCd
	 */
	public void setPrcCustTpCd(String prcCustTpCd) {
		this.prcCustTpCd = prcCustTpCd;
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
	 * @param qttnSrepNm
	 */
	public void setQttnSrepNm(String qttnSrepNm) {
		this.qttnSrepNm = qttnSrepNm;
	}
	
	/**
	 * Column Info
	 * @param qttnStsCd
	 */
	public void setQttnStsCd(String qttnStsCd) {
		this.qttnStsCd = qttnStsCd;
	}
	
	/**
	 * Column Info
	 * @param creDtFrom
	 */
	public void setCreDtFrom(String creDtFrom) {
		this.creDtFrom = creDtFrom;
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
	 * @param cntrLodUtCd
	 */
	public void setCntrLodUtCd(String cntrLodUtCd) {
		this.cntrLodUtCd = cntrLodUtCd;
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
	 * @param qttnStatus
	 */
	public void setQttnStatus(String qttnStatus) {
		this.qttnStatus = qttnStatus;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param qttnNoHidden
	 */
	public void setQttnNoHidden(String qttnNoHidden) {
		this.qttnNoHidden = qttnNoHidden;
	}
	
	/**
	 * Column Info
	 * @param qttnVerNo
	 */
	public void setQttnVerNo(String qttnVerNo) {
		this.qttnVerNo = qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @param qttnNo
	 */
	public void setQttnNo(String qttnNo) {
		this.qttnNo = qttnNo;
	}
	
	/**
	 * Column Info
	 * @param estmCmAmt
	 */
	public void setEstmCmAmt(String estmCmAmt) {
		this.estmCmAmt = estmCmAmt;
	}
	
	/**
	 * Column Info
	 * @param qttnNoRead
	 */
	public void setQttnNoRead(String qttnNoRead) {
		this.qttnNoRead = qttnNoRead;
	}
	
	/**
	 * Column Info
	 * @param iscopy
	 */
	public void setIscopy(String iscopy) {
		this.iscopy = iscopy;
	}
	
	/**
	 * Column Info
	 * @param qttnOfcCd
	 */
	public void setQttnOfcCd(String qttnOfcCd) {
		this.qttnOfcCd = qttnOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setQttnSrepCd(JSPUtil.getParameter(request, "qttn_srep_cd", ""));
		setPrsXchRtYrmon(JSPUtil.getParameter(request, "prs_xch_rt_yrmon", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setQttnVerNoRead(JSPUtil.getParameter(request, "qttn_ver_no_read", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setEstmMqcQty(JSPUtil.getParameter(request, "estm_mqc_qty", ""));
		setCreDtTo(JSPUtil.getParameter(request, "cre_dt_to", ""));
		setSvcScpNm(JSPUtil.getParameter(request, "svc_scp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setQttnStsNm(JSPUtil.getParameter(request, "qttn_sts_nm", ""));
		setQttnVerNoHidden(JSPUtil.getParameter(request, "qttn_ver_no_hidden", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setPrcCustTpCd(JSPUtil.getParameter(request, "prc_cust_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setQttnSrepNm(JSPUtil.getParameter(request, "qttn_srep_nm", ""));
		setQttnStsCd(JSPUtil.getParameter(request, "qttn_sts_cd", ""));
		setCreDtFrom(JSPUtil.getParameter(request, "cre_dt_from", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCntrLodUtCd(JSPUtil.getParameter(request, "cntr_lod_ut_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setQttnStatus(JSPUtil.getParameter(request, "qttn_status", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setQttnNoHidden(JSPUtil.getParameter(request, "qttn_no_hidden", ""));
		setQttnVerNo(JSPUtil.getParameter(request, "qttn_ver_no", ""));
		setQttnNo(JSPUtil.getParameter(request, "qttn_no", ""));
		setEstmCmAmt(JSPUtil.getParameter(request, "estm_cm_amt", ""));
		setQttnNoRead(JSPUtil.getParameter(request, "qttn_no_read", ""));
		setIscopy(JSPUtil.getParameter(request, "iscopy", ""));
		setQttnOfcCd(JSPUtil.getParameter(request, "qttn_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriRqMnVO[]
	 */
	public RsltPriRqMnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriRqMnVO[]
	 */
	public RsltPriRqMnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriRqMnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] qttnSrepCd = (JSPUtil.getParameter(request, prefix	+ "qttn_srep_cd", length));
			String[] prsXchRtYrmon = (JSPUtil.getParameter(request, prefix	+ "prs_xch_rt_yrmon", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] qttnVerNoRead = (JSPUtil.getParameter(request, prefix	+ "qttn_ver_no_read", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] estmMqcQty = (JSPUtil.getParameter(request, prefix	+ "estm_mqc_qty", length));
			String[] creDtTo = (JSPUtil.getParameter(request, prefix	+ "cre_dt_to", length));
			String[] svcScpNm = (JSPUtil.getParameter(request, prefix	+ "svc_scp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] qttnStsNm = (JSPUtil.getParameter(request, prefix	+ "qttn_sts_nm", length));
			String[] qttnVerNoHidden = (JSPUtil.getParameter(request, prefix	+ "qttn_ver_no_hidden", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] prcCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cust_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] qttnSrepNm = (JSPUtil.getParameter(request, prefix	+ "qttn_srep_nm", length));
			String[] qttnStsCd = (JSPUtil.getParameter(request, prefix	+ "qttn_sts_cd", length));
			String[] creDtFrom = (JSPUtil.getParameter(request, prefix	+ "cre_dt_from", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] cntrLodUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_lod_ut_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] qttnStatus = (JSPUtil.getParameter(request, prefix	+ "qttn_status", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] qttnNoHidden = (JSPUtil.getParameter(request, prefix	+ "qttn_no_hidden", length));
			String[] qttnVerNo = (JSPUtil.getParameter(request, prefix	+ "qttn_ver_no", length));
			String[] qttnNo = (JSPUtil.getParameter(request, prefix	+ "qttn_no", length));
			String[] estmCmAmt = (JSPUtil.getParameter(request, prefix	+ "estm_cm_amt", length));
			String[] qttnNoRead = (JSPUtil.getParameter(request, prefix	+ "qttn_no_read", length));
			String[] iscopy = (JSPUtil.getParameter(request, prefix	+ "iscopy", length));
			String[] qttnOfcCd = (JSPUtil.getParameter(request, prefix	+ "qttn_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriRqMnVO();
				if (qttnSrepCd[i] != null)
					model.setQttnSrepCd(qttnSrepCd[i]);
				if (prsXchRtYrmon[i] != null)
					model.setPrsXchRtYrmon(prsXchRtYrmon[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (qttnVerNoRead[i] != null)
					model.setQttnVerNoRead(qttnVerNoRead[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (estmMqcQty[i] != null)
					model.setEstmMqcQty(estmMqcQty[i]);
				if (creDtTo[i] != null)
					model.setCreDtTo(creDtTo[i]);
				if (svcScpNm[i] != null)
					model.setSvcScpNm(svcScpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (qttnStsNm[i] != null)
					model.setQttnStsNm(qttnStsNm[i]);
				if (qttnVerNoHidden[i] != null)
					model.setQttnVerNoHidden(qttnVerNoHidden[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (prcCustTpCd[i] != null)
					model.setPrcCustTpCd(prcCustTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (qttnSrepNm[i] != null)
					model.setQttnSrepNm(qttnSrepNm[i]);
				if (qttnStsCd[i] != null)
					model.setQttnStsCd(qttnStsCd[i]);
				if (creDtFrom[i] != null)
					model.setCreDtFrom(creDtFrom[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cntrLodUtCd[i] != null)
					model.setCntrLodUtCd(cntrLodUtCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (qttnStatus[i] != null)
					model.setQttnStatus(qttnStatus[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (qttnNoHidden[i] != null)
					model.setQttnNoHidden(qttnNoHidden[i]);
				if (qttnVerNo[i] != null)
					model.setQttnVerNo(qttnVerNo[i]);
				if (qttnNo[i] != null)
					model.setQttnNo(qttnNo[i]);
				if (estmCmAmt[i] != null)
					model.setEstmCmAmt(estmCmAmt[i]);
				if (qttnNoRead[i] != null)
					model.setQttnNoRead(qttnNoRead[i]);
				if (iscopy[i] != null)
					model.setIscopy(iscopy[i]);
				if (qttnOfcCd[i] != null)
					model.setQttnOfcCd(qttnOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriRqMnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriRqMnVO[]
	 */
	public RsltPriRqMnVO[] getRsltPriRqMnVOs(){
		RsltPriRqMnVO[] vos = (RsltPriRqMnVO[])models.toArray(new RsltPriRqMnVO[models.size()]);
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
		this.qttnSrepCd = this.qttnSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsXchRtYrmon = this.prsXchRtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNoRead = this.qttnVerNoRead .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmMqcQty = this.estmMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtTo = this.creDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpNm = this.svcScpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnStsNm = this.qttnStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNoHidden = this.qttnVerNoHidden .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCustTpCd = this.prcCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnSrepNm = this.qttnSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnStsCd = this.qttnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtFrom = this.creDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLodUtCd = this.cntrLodUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnStatus = this.qttnStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNoHidden = this.qttnNoHidden .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNo = this.qttnVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNo = this.qttnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCmAmt = this.estmCmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNoRead = this.qttnNoRead .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iscopy = this.iscopy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnOfcCd = this.qttnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
