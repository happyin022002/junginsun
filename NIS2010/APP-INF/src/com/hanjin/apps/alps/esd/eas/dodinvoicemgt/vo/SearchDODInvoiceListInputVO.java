/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchDODInvoiceListInputVO.java
*@FileTitle : SearchDODInvoiceListInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.09.12 이혜민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이혜민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDODInvoiceListInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDODInvoiceListInputVO> models = new ArrayList<SearchDODInvoiceListInputVO>();
	
	/* Column Info */
	private String fmCreDt = null;
	/* Column Info */
	private String custCntcPntSeq = null;
	/* Column Info */
	private String cntcPntEml = null;
	/* Column Info */
	private String dodInvStsCd = null;
	/* Column Info */
	private String cntcPntFaxNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String ifUsrNm = null;
	/* Column Info */
	private String arIfDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String fTpCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String chkCancel = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cxlDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cntcPntPhnNo = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String arIfUsrId = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntcPntNm = null;
	/* Column Info */
	private String dodInvNo = null;
	/* Column Info */
	private String dodLocCd = null;
	/* Column Info */
	private String arIfFlg = null;
	/* Column Info */
	private String cxlUsrId = null;
	/* Column Info */
	private String ttlInvAmt = null;
	/* Column Info */
	private String bkgDeTermCd = null;
	/* Column Info */
	private String toCreDt = null;
	/*	Column Info	*/
	private  String	 payerCd   =  null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDODInvoiceListInputVO() {}

	public SearchDODInvoiceListInputVO(String ibflag, String pagerows, String fTpCd, String fmCreDt, String toCreDt, String chkCancel, String dodLocCd, String dodInvNo, String bkgNo, String blNo, String custCntCd, String custSeq, String cntcPntNm, String cntcPntPhnNo, String cntcPntFaxNo, String cntcPntEml, String custCntcPntSeq, String podCd, String delCd, String bkgDeTermCd, String invCurrCd, String ttlInvAmt, String creOfcCd, String dodInvStsCd, String cxlDt, String cxlUsrId, String arIfFlg, String arIfDt, String arIfUsrId, String creUsrId, String creDt, String updUsrId, String updDt, String arIfNo, String ifUsrNm,String payerCd)	{
		this.fmCreDt = fmCreDt;
		this.custCntcPntSeq = custCntcPntSeq;
		this.cntcPntEml = cntcPntEml;
		this.dodInvStsCd = dodInvStsCd;
		this.cntcPntFaxNo = cntcPntFaxNo;
		this.creDt = creDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.arIfNo = arIfNo;
		this.creOfcCd = creOfcCd;
		this.ifUsrNm = ifUsrNm;
		this.arIfDt = arIfDt;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.fTpCd = fTpCd;
		this.updDt = updDt;
		this.chkCancel = chkCancel;
		this.delCd = delCd;
		this.cxlDt = cxlDt;
		this.custSeq = custSeq;
		this.cntcPntPhnNo = cntcPntPhnNo;
		this.invCurrCd = invCurrCd;
		this.arIfUsrId = arIfUsrId;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.cntcPntNm = cntcPntNm;
		this.dodInvNo = dodInvNo;
		this.dodLocCd = dodLocCd;
		this.arIfFlg = arIfFlg;
		this.cxlUsrId = cxlUsrId;
		this.ttlInvAmt = ttlInvAmt;
		this.bkgDeTermCd = bkgDeTermCd;
		this.toCreDt = toCreDt;
		this.payerCd  = payerCd ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_cre_dt", getFmCreDt());
		this.hashColumns.put("cust_cntc_pnt_seq", getCustCntcPntSeq());
		this.hashColumns.put("cntc_pnt_eml", getCntcPntEml());
		this.hashColumns.put("dod_inv_sts_cd", getDodInvStsCd());
		this.hashColumns.put("cntc_pnt_fax_no", getCntcPntFaxNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("if_usr_nm", getIfUsrNm());
		this.hashColumns.put("ar_if_dt", getArIfDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("f_tp_cd", getFTpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("chk_cancel", getChkCancel());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cxl_dt", getCxlDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cntc_pnt_phn_no", getCntcPntPhnNo());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("ar_if_usr_id", getArIfUsrId());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntc_pnt_nm", getCntcPntNm());
		this.hashColumns.put("dod_inv_no", getDodInvNo());
		this.hashColumns.put("dod_loc_cd", getDodLocCd());
		this.hashColumns.put("ar_if_flg", getArIfFlg());
		this.hashColumns.put("cxl_usr_id", getCxlUsrId());
		this.hashColumns.put("ttl_inv_amt", getTtlInvAmt());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		this.hashColumns.put("to_cre_dt", getToCreDt());
		this.hashColumns.put("payer_cd", getPayerCd());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_cre_dt", "fmCreDt");
		this.hashFields.put("cust_cntc_pnt_seq", "custCntcPntSeq");
		this.hashFields.put("cntc_pnt_eml", "cntcPntEml");
		this.hashFields.put("dod_inv_sts_cd", "dodInvStsCd");
		this.hashFields.put("cntc_pnt_fax_no", "cntcPntFaxNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("if_usr_nm", "ifUsrNm");
		this.hashFields.put("ar_if_dt", "arIfDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("f_tp_cd", "fTpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("chk_cancel", "chkCancel");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cxl_dt", "cxlDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cntc_pnt_phn_no", "cntcPntPhnNo");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("ar_if_usr_id", "arIfUsrId");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntc_pnt_nm", "cntcPntNm");
		this.hashFields.put("dod_inv_no", "dodInvNo");
		this.hashFields.put("dod_loc_cd", "dodLocCd");
		this.hashFields.put("ar_if_flg", "arIfFlg");
		this.hashFields.put("cxl_usr_id", "cxlUsrId");
		this.hashFields.put("ttl_inv_amt", "ttlInvAmt");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		this.hashFields.put("to_cre_dt", "toCreDt");
		this.hashFields.put("payer_cd", "payerCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmCreDt
	 */
	public String getFmCreDt() {
		return this.fmCreDt;
	}
	
	/**
	 * Column Info
	 * @return custCntcPntSeq
	 */
	public String getCustCntcPntSeq() {
		return this.custCntcPntSeq;
	}
	
	/**
	 * Column Info
	 * @return cntcPntEml
	 */
	public String getCntcPntEml() {
		return this.cntcPntEml;
	}
	
	/**
	 * Column Info
	 * @return dodInvStsCd
	 */
	public String getDodInvStsCd() {
		return this.dodInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return cntcPntFaxNo
	 */
	public String getCntcPntFaxNo() {
		return this.cntcPntFaxNo;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ifUsrNm
	 */
	public String getIfUsrNm() {
		return this.ifUsrNm;
	}
	
	/**
	 * Column Info
	 * @return arIfDt
	 */
	public String getArIfDt() {
		return this.arIfDt;
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
	 * @return fTpCd
	 */
	public String getFTpCd() {
		return this.fTpCd;
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
	 * @return chkCancel
	 */
	public String getChkCancel() {
		return this.chkCancel;
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
	 * @return cxlDt
	 */
	public String getCxlDt() {
		return this.cxlDt;
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
	 * @return cntcPntPhnNo
	 */
	public String getCntcPntPhnNo() {
		return this.cntcPntPhnNo;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return arIfUsrId
	 */
	public String getArIfUsrId() {
		return this.arIfUsrId;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cntcPntNm
	 */
	public String getCntcPntNm() {
		return this.cntcPntNm;
	}
	
	/**
	 * Column Info
	 * @return dodInvNo
	 */
	public String getDodInvNo() {
		return this.dodInvNo;
	}
	
	/**
	 * Column Info
	 * @return dodLocCd
	 */
	public String getDodLocCd() {
		return this.dodLocCd;
	}
	
	/**
	 * Column Info
	 * @return arIfFlg
	 */
	public String getArIfFlg() {
		return this.arIfFlg;
	}
	
	/**
	 * Column Info
	 * @return cxlUsrId
	 */
	public String getCxlUsrId() {
		return this.cxlUsrId;
	}
	
	/**
	 * Column Info
	 * @return ttlInvAmt
	 */
	public String getTtlInvAmt() {
		return this.ttlInvAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgDeTermCd
	 */
	public String getBkgDeTermCd() {
		return this.bkgDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return toCreDt
	 */
	public String getToCreDt() {
		return this.toCreDt;
	}
	

	/**
	 * Column Info
	 * @param fmCreDt
	 */
	public void setFmCreDt(String fmCreDt) {
		this.fmCreDt = fmCreDt;
	}
	
	/**
	 * Column Info
	 * @param custCntcPntSeq
	 */
	public void setCustCntcPntSeq(String custCntcPntSeq) {
		this.custCntcPntSeq = custCntcPntSeq;
	}
	
	/**
	 * Column Info
	 * @param cntcPntEml
	 */
	public void setCntcPntEml(String cntcPntEml) {
		this.cntcPntEml = cntcPntEml;
	}
	
	/**
	 * Column Info
	 * @param dodInvStsCd
	 */
	public void setDodInvStsCd(String dodInvStsCd) {
		this.dodInvStsCd = dodInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param cntcPntFaxNo
	 */
	public void setCntcPntFaxNo(String cntcPntFaxNo) {
		this.cntcPntFaxNo = cntcPntFaxNo;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ifUsrNm
	 */
	public void setIfUsrNm(String ifUsrNm) {
		this.ifUsrNm = ifUsrNm;
	}
	
	/**
	 * Column Info
	 * @param arIfDt
	 */
	public void setArIfDt(String arIfDt) {
		this.arIfDt = arIfDt;
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
	 * @param fTpCd
	 */
	public void setFTpCd(String fTpCd) {
		this.fTpCd = fTpCd;
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
	 * @param chkCancel
	 */
	public void setChkCancel(String chkCancel) {
		this.chkCancel = chkCancel;
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
	 * @param cxlDt
	 */
	public void setCxlDt(String cxlDt) {
		this.cxlDt = cxlDt;
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
	 * @param cntcPntPhnNo
	 */
	public void setCntcPntPhnNo(String cntcPntPhnNo) {
		this.cntcPntPhnNo = cntcPntPhnNo;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param arIfUsrId
	 */
	public void setArIfUsrId(String arIfUsrId) {
		this.arIfUsrId = arIfUsrId;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cntcPntNm
	 */
	public void setCntcPntNm(String cntcPntNm) {
		this.cntcPntNm = cntcPntNm;
	}
	
	/**
	 * Column Info
	 * @param dodInvNo
	 */
	public void setDodInvNo(String dodInvNo) {
		this.dodInvNo = dodInvNo;
	}
	
	/**
	 * Column Info
	 * @param dodLocCd
	 */
	public void setDodLocCd(String dodLocCd) {
		this.dodLocCd = dodLocCd;
	}
	
	/**
	 * Column Info
	 * @param arIfFlg
	 */
	public void setArIfFlg(String arIfFlg) {
		this.arIfFlg = arIfFlg;
	}
	
	/**
	 * Column Info
	 * @param cxlUsrId
	 */
	public void setCxlUsrId(String cxlUsrId) {
		this.cxlUsrId = cxlUsrId;
	}
	
	/**
	 * Column Info
	 * @param ttlInvAmt
	 */
	public void setTtlInvAmt(String ttlInvAmt) {
		this.ttlInvAmt = ttlInvAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgDeTermCd
	 */
	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param toCreDt
	 */
	public void setToCreDt(String toCreDt) {
		this.toCreDt = toCreDt;
	}
	/**
	* Column Info
	* @param  payerCd
	*/
	public void	setPayerCd( String	payerCd ) {
		this.payerCd =	payerCd;
	}
 
	/**
	 * Column Info
	 * @return	payerCd
	 */
	 public	String	getPayerCd() {
		 return	this.payerCd;
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
		setFmCreDt(JSPUtil.getParameter(request, prefix + "fm_cre_dt", ""));
		setCustCntcPntSeq(JSPUtil.getParameter(request, prefix + "cust_cntc_pnt_seq", ""));
		setCntcPntEml(JSPUtil.getParameter(request, prefix + "cntc_pnt_eml", ""));
		setDodInvStsCd(JSPUtil.getParameter(request, prefix + "dod_inv_sts_cd", ""));
		setCntcPntFaxNo(JSPUtil.getParameter(request, prefix + "cntc_pnt_fax_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setArIfNo(JSPUtil.getParameter(request, prefix + "ar_if_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setIfUsrNm(JSPUtil.getParameter(request, prefix + "if_usr_nm", ""));
		setArIfDt(JSPUtil.getParameter(request, prefix + "ar_if_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setFTpCd(JSPUtil.getParameter(request, prefix + "f_tp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setChkCancel(JSPUtil.getParameter(request, prefix + "chk_cancel", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCxlDt(JSPUtil.getParameter(request, prefix + "cxl_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCntcPntPhnNo(JSPUtil.getParameter(request, prefix + "cntc_pnt_phn_no", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setArIfUsrId(JSPUtil.getParameter(request, prefix + "ar_if_usr_id", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntcPntNm(JSPUtil.getParameter(request, prefix + "cntc_pnt_nm", ""));
		setDodInvNo(JSPUtil.getParameter(request, prefix + "dod_inv_no", ""));
		setDodLocCd(JSPUtil.getParameter(request, prefix + "dod_loc_cd", ""));
		setArIfFlg(JSPUtil.getParameter(request, prefix + "ar_if_flg", ""));
		setCxlUsrId(JSPUtil.getParameter(request, prefix + "cxl_usr_id", ""));
		setTtlInvAmt(JSPUtil.getParameter(request, prefix + "ttl_inv_amt", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", ""));
		setToCreDt(JSPUtil.getParameter(request, prefix + "to_cre_dt", ""));
		setPayerCd(JSPUtil.getParameter(request,	prefix + "payer_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDODInvoiceListInputVO[]
	 */
	public SearchDODInvoiceListInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDODInvoiceListInputVO[]
	 */
	public SearchDODInvoiceListInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDODInvoiceListInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmCreDt = (JSPUtil.getParameter(request, prefix	+ "fm_cre_dt", length));
			String[] custCntcPntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_pnt_seq", length));
			String[] cntcPntEml = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_eml", length));
			String[] dodInvStsCd = (JSPUtil.getParameter(request, prefix	+ "dod_inv_sts_cd", length));
			String[] cntcPntFaxNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_fax_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] ifUsrNm = (JSPUtil.getParameter(request, prefix	+ "if_usr_nm", length));
			String[] arIfDt = (JSPUtil.getParameter(request, prefix	+ "ar_if_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] fTpCd = (JSPUtil.getParameter(request, prefix	+ "f_tp_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] chkCancel = (JSPUtil.getParameter(request, prefix	+ "chk_cancel", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cxlDt = (JSPUtil.getParameter(request, prefix	+ "cxl_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] cntcPntPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_phn_no", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] arIfUsrId = (JSPUtil.getParameter(request, prefix	+ "ar_if_usr_id", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntcPntNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_nm", length));
			String[] dodInvNo = (JSPUtil.getParameter(request, prefix	+ "dod_inv_no", length));
			String[] dodLocCd = (JSPUtil.getParameter(request, prefix	+ "dod_loc_cd", length));
			String[] arIfFlg = (JSPUtil.getParameter(request, prefix	+ "ar_if_flg", length));
			String[] cxlUsrId = (JSPUtil.getParameter(request, prefix	+ "cxl_usr_id", length));
			String[] ttlInvAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_inv_amt", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_de_term_cd", length));
			String[] toCreDt = (JSPUtil.getParameter(request, prefix	+ "to_cre_dt", length));
			String[] payerCd =	(JSPUtil.getParameter(request, prefix +	"payer_cd".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDODInvoiceListInputVO();
				if (fmCreDt[i] != null)
					model.setFmCreDt(fmCreDt[i]);
				if (custCntcPntSeq[i] != null)
					model.setCustCntcPntSeq(custCntcPntSeq[i]);
				if (cntcPntEml[i] != null)
					model.setCntcPntEml(cntcPntEml[i]);
				if (dodInvStsCd[i] != null)
					model.setDodInvStsCd(dodInvStsCd[i]);
				if (cntcPntFaxNo[i] != null)
					model.setCntcPntFaxNo(cntcPntFaxNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (ifUsrNm[i] != null)
					model.setIfUsrNm(ifUsrNm[i]);
				if (arIfDt[i] != null)
					model.setArIfDt(arIfDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (fTpCd[i] != null)
					model.setFTpCd(fTpCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (chkCancel[i] != null)
					model.setChkCancel(chkCancel[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cxlDt[i] != null)
					model.setCxlDt(cxlDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cntcPntPhnNo[i] != null)
					model.setCntcPntPhnNo(cntcPntPhnNo[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (arIfUsrId[i] != null)
					model.setArIfUsrId(arIfUsrId[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntcPntNm[i] != null)
					model.setCntcPntNm(cntcPntNm[i]);
				if (dodInvNo[i] != null)
					model.setDodInvNo(dodInvNo[i]);
				if (dodLocCd[i] != null)
					model.setDodLocCd(dodLocCd[i]);
				if (arIfFlg[i] != null)
					model.setArIfFlg(arIfFlg[i]);
				if (cxlUsrId[i] != null)
					model.setCxlUsrId(cxlUsrId[i]);
				if (ttlInvAmt[i] != null)
					model.setTtlInvAmt(ttlInvAmt[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				if (toCreDt[i] != null)
					model.setToCreDt(toCreDt[i]);
				if ( payerCd[i] !=	null)
					model.setPayerCd( payerCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDODInvoiceListInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDODInvoiceListInputVO[]
	 */
	public SearchDODInvoiceListInputVO[] getSearchDODInvoiceListInputVOs(){
		SearchDODInvoiceListInputVO[] vos = (SearchDODInvoiceListInputVO[])models.toArray(new SearchDODInvoiceListInputVO[models.size()]);
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
		this.fmCreDt = this.fmCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcPntSeq = this.custCntcPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntEml = this.cntcPntEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dodInvStsCd = this.dodInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntFaxNo = this.cntcPntFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifUsrNm = this.ifUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfDt = this.arIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTpCd = this.fTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCancel = this.chkCancel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlDt = this.cxlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntPhnNo = this.cntcPntPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfUsrId = this.arIfUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntNm = this.cntcPntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dodInvNo = this.dodInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dodLocCd = this.dodLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfFlg = this.arIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlUsrId = this.cxlUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlInvAmt = this.ttlInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCreDt = this.toCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerCd =	this.payerCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
