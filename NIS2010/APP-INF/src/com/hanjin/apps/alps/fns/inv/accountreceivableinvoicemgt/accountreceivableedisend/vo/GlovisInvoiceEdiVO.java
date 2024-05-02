/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GlovisInvoiceEdiVO.java
*@FileTitle : GlovisInvoiceEdiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.17
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.12.17 이석준 
* 1.0 Creation
* History
* 2011.11.30 권 민 [CHM-201114839] [INV] Glovis Invoice EDI 전송 기능 보완
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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
 * @author 이석준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GlovisInvoiceEdiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GlovisInvoiceEdiVO> models = new ArrayList<GlovisInvoiceEdiVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String chkInd = null;
	/* Column Info */
	private String loclNm = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String chgKrw = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ifSeq = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String frtUsd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String usrLoclNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ediType = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String chgRmk = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String ttlAmtKrw = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custEml = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String postCxlFlg = null;
	/* Column Info */
	private String ediSndDt = null;
	/* Column Info */
	private String reTpCd = null;
	/* Column Info */
	private String glovisTtlAmtKrw = null;
	/* Column Info */
	private String euroLoclXchRt = null;
	/* Column Info */
	private String frtEur = null;
	/* Column Info */
	private String eurGubun = null;
	/* Column Info */
	private String ttlUsdKrwAmt = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GlovisInvoiceEdiVO() {}

	public GlovisInvoiceEdiVO(String ibflag, String pagerows, String porCd, String chkInd, String custNm, String loclNm, String cxlFlg, String chgKrw, String creDt, String ifSeq, String custRgstNo, String sailArrDt, String frtUsd, String usrLoclNm, String polCd, String usrId, String arIfNo, String ediType, String invXchRt, String blSrcNo, String usrEml, String ttlAmtKrw, String delCd, String ioBndCd, String custSeq, String custEml, String invNo, String vvd, String podCd, String custCd, String invRmk, String postCxlFlg, String ediSndDt, String reTpCd, String creUsrId, String updUsrId, String invSeq, String chgRmk, String arOfcCd,String glovisTtlAmtKrw,String euroLoclXchRt,String frtEur,String eurGubun,String ttlUsdKrwAmt) {
		this.porCd = porCd;
		this.chkInd = chkInd;
		this.loclNm = loclNm;
		this.custNm = custNm;
		this.chgKrw = chgKrw;
		this.cxlFlg = cxlFlg;
		this.creDt = creDt;
		this.ifSeq = ifSeq;
		this.invSeq = invSeq;
		this.custRgstNo = custRgstNo;
		this.sailArrDt = sailArrDt;
		this.frtUsd = frtUsd;
		this.pagerows = pagerows;
		this.usrLoclNm = usrLoclNm;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.usrId = usrId;
		this.arIfNo = arIfNo;
		this.updUsrId = updUsrId;
		this.ediType = ediType;
		this.invXchRt = invXchRt;
		this.chgRmk = chgRmk;
		this.blSrcNo = blSrcNo;
		this.usrEml = usrEml;
		this.ttlAmtKrw = ttlAmtKrw;
		this.delCd = delCd;
		this.ioBndCd = ioBndCd;
		this.custSeq = custSeq;
		this.custEml = custEml;
		this.arOfcCd = arOfcCd;
		this.podCd = podCd;
		this.vvd = vvd;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.invRmk = invRmk;
		this.custCd = custCd;
		this.postCxlFlg = postCxlFlg;
		this.ediSndDt = ediSndDt;
		this.reTpCd = reTpCd;
		this.glovisTtlAmtKrw = glovisTtlAmtKrw;
		this.euroLoclXchRt = euroLoclXchRt;
		this.frtEur = frtEur;
		this.eurGubun = eurGubun;
		this.ttlUsdKrwAmt = ttlUsdKrwAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("chk_ind", getChkInd());
		this.hashColumns.put("locl_nm", getLoclNm());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("chg_krw", getChgKrw());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("if_seq", getIfSeq());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("frt_usd", getFrtUsd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("usr_locl_nm", getUsrLoclNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("edi_type", getEdiType());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("chg_rmk", getChgRmk());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("ttl_amt_krw", getTtlAmtKrw());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("post_cxl_flg", getPostCxlFlg());
		this.hashColumns.put("edi_snd_dt", getEdiSndDt());
		this.hashColumns.put("re_tp_cd", getReTpCd());
		this.hashColumns.put("glovis_ttl_amt_krw", getGlovisTtlAmtKrw());
		this.hashColumns.put("euro_locl_xch_rt", getEuroLoclXchRt());
		this.hashColumns.put("frt_eur", getFrtEur());
		this.hashColumns.put("eur_gubun", getEurGubun());
		this.hashColumns.put("ttl_usd_krw_amt", getTtlUsdKrwAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("chk_ind", "chkInd");
		this.hashFields.put("locl_nm", "loclNm");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("chg_krw", "chgKrw");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("if_seq", "ifSeq");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("frt_usd", "frtUsd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usr_locl_nm", "usrLoclNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("edi_type", "ediType");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("chg_rmk", "chgRmk");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("ttl_amt_krw", "ttlAmtKrw");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("post_cxl_flg", "postCxlFlg");
		this.hashFields.put("edi_snd_dt", "ediSndDt");
		this.hashFields.put("re_tp_cd", "reTpCd");
		this.hashFields.put("glovis_ttl_amt_krw", "glovisTtlAmtKrw");
		this.hashFields.put("euro_locl_xch_rt", "euroLoclXchRt");
		this.hashFields.put("frt_eur", "frtEur");
		this.hashFields.put("eur_gubun", "eurGubun");
		this.hashFields.put("ttl_usd_krw_amt", "ttlUsdKrwAmt");
		return this.hashFields;
	}
	
	
	/**
	 * @return the glovisTtlAmtKrw
	 */
	public String getGlovisTtlAmtKrw() {
		return glovisTtlAmtKrw;
	}

	/**
	 * @param glovisTtlAmtKrw the glovisTtlAmtKrw to set
	 */
	public void setGlovisTtlAmtKrw(String glovisTtlAmtKrw) {
		this.glovisTtlAmtKrw = glovisTtlAmtKrw;
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
	 * @return chkInd
	 */
	public String getChkInd() {
		return this.chkInd;
	}
	
	/**
	 * Column Info
	 * @return loclNm
	 */
	public String getLoclNm() {
		return this.loclNm;
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
	 * @return chgKrw
	 */
	public String getChgKrw() {
		return this.chgKrw;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return ifSeq
	 */
	public String getIfSeq() {
		return this.ifSeq;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return custRgstNo
	 */
	public String getCustRgstNo() {
		return this.custRgstNo;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return frtUsd
	 */
	public String getFrtUsd() {
		return this.frtUsd;
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
	 * @return usrLoclNm
	 */
	public String getUsrLoclNm() {
		return this.usrLoclNm;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return ediType
	 */
	public String getEdiType() {
		return this.ediType;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return chgRmk
	 */
	public String getChgRmk() {
		return this.chgRmk;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
	}
	
	/**
	 * Column Info
	 * @return ttlAmtKrw
	 */
	public String getTtlAmtKrw() {
		return this.ttlAmtKrw;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return custEml
	 */
	public String getCustEml() {
		return this.custEml;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return invRmk
	 */
	public String getInvRmk() {
		return this.invRmk;
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
	 * @return postCxlFlg
	 */
	public String getPostCxlFlg() {
		return this.postCxlFlg;
	}
	
	/**
	 * Column Info
	 * @return ediSndDt
	 */
	public String getEdiSndDt() {
		return this.ediSndDt;
	}
	
	/**
	 * Column Info
	 * @return reTpCd
	 */
	public String getReTpCd() {
		return this.reTpCd;
	}
	
	/**
	 * Column Info
	 * @return euroLoclXchRt
	 */
	public String getEuroLoclXchRt() {
		return euroLoclXchRt;
	}

	/**
	 * Column Info
	 * @return frtEur
	 */
	public String getFrtEur() {
		return frtEur;
	}

	/**
	 * Column Info
	 * @return eurGubun
	 */
	public String getEurGubun() {
		return eurGubun;
	}

	/**
	 * Column Info
	 * @return ttlUsdKrwAmt
	 */
	public String getTtlUsdKrwAmt() {
		return ttlUsdKrwAmt;
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
	 * @param chkInd
	 */
	public void setChkInd(String chkInd) {
		this.chkInd = chkInd;
	}
	
	/**
	 * Column Info
	 * @param loclNm
	 */
	public void setLoclNm(String loclNm) {
		this.loclNm = loclNm;
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
	 * @param chgKrw
	 */
	public void setChgKrw(String chgKrw) {
		this.chgKrw = chgKrw;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param ifSeq
	 */
	public void setIfSeq(String ifSeq) {
		this.ifSeq = ifSeq;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param custRgstNo
	 */
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param frtUsd
	 */
	public void setFrtUsd(String frtUsd) {
		this.frtUsd = frtUsd;
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
	 * @param usrLoclNm
	 */
	public void setUsrLoclNm(String usrLoclNm) {
		this.usrLoclNm = usrLoclNm;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param ediType
	 */
	public void setEdiType(String ediType) {
		this.ediType = ediType;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param chgRmk
	 */
	public void setChgRmk(String chgRmk) {
		this.chgRmk = chgRmk;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
	
	/**
	 * Column Info
	 * @param ttlAmtKrw
	 */
	public void setTtlAmtKrw(String ttlAmtKrw) {
		this.ttlAmtKrw = ttlAmtKrw;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param custEml
	 */
	public void setCustEml(String custEml) {
		this.custEml = custEml;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param invRmk
	 */
	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
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
	 * @param postCxlFlg
	 */
	public void setPostCxlFlg(String postCxlFlg) {
		this.postCxlFlg = postCxlFlg;
	}
	
	/**
	 * Column Info
	 * @param ediSndDt
	 */
	public void setEdiSndDt(String ediSndDt) {
		this.ediSndDt = ediSndDt;
	}
	
	/**
	 * Column Info
	 * @param reTpCd
	 */
	public void setReTpCd(String reTpCd) {
		this.reTpCd = reTpCd;
	}	
	
	/**
	 * Column Info
	 * @param euroLoclXchRt
	 */
	public void setEuroLoclXchRt(String euroLoclXchRt) {
		this.euroLoclXchRt = euroLoclXchRt;
	}

	/**
	 * Column Info
	 * @param frtEur
	 */
	public void setFrtEur(String frtEur) {
		this.frtEur = frtEur;
	}

	/**
	 * Column Info
	 * @param eurGubun
	 */
	public void setEurGubun(String eurGubun) {
		this.eurGubun = eurGubun;
	}

	/**
	 * Column Info
	 * @param ttlUsdKrwAmt
	 */
	public void setTtlUsdKrwAmt(String ttlUsdKrwAmt) {
		this.ttlUsdKrwAmt = ttlUsdKrwAmt;
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
		setChkInd(JSPUtil.getParameter(request, prefix + "chk_ind", ""));
		setLoclNm(JSPUtil.getParameter(request, prefix + "locl_nm", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setChgKrw(JSPUtil.getParameter(request, prefix + "chg_krw", ""));
		setCxlFlg(JSPUtil.getParameter(request, prefix + "cxl_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setIfSeq(JSPUtil.getParameter(request, prefix + "if_seq", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setCustRgstNo(JSPUtil.getParameter(request, prefix + "cust_rgst_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setFrtUsd(JSPUtil.getParameter(request, prefix + "frt_usd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUsrLoclNm(JSPUtil.getParameter(request, prefix + "usr_locl_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setArIfNo(JSPUtil.getParameter(request, prefix + "ar_if_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEdiType(JSPUtil.getParameter(request, prefix + "edi_type", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setChgRmk(JSPUtil.getParameter(request, prefix + "chg_rmk", ""));
		setBlSrcNo(JSPUtil.getParameter(request, prefix + "bl_src_no", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setTtlAmtKrw(JSPUtil.getParameter(request, prefix + "ttl_amt_krw", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setInvRmk(JSPUtil.getParameter(request, prefix + "inv_rmk", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setPostCxlFlg(JSPUtil.getParameter(request, prefix + "post_cxl_flg", ""));
		setEdiSndDt(JSPUtil.getParameter(request, prefix + "edi_snd_dt", ""));
		setReTpCd(JSPUtil.getParameter(request, prefix + "re_tp_cd", ""));
		setGlovisTtlAmtKrw(JSPUtil.getParameter(request, prefix + "glovis_ttl_amt_krw", ""));
		setEuroLoclXchRt(JSPUtil.getParameter(request, prefix + "euro_locl_xch_rt", ""));
		setFrtEur(JSPUtil.getParameter(request, prefix + "frt_eur", ""));
		setEurGubun(JSPUtil.getParameter(request, prefix + "eur_gubun", ""));
		setTtlUsdKrwAmt(JSPUtil.getParameter(request, prefix + "ttl_usd_krw_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GlovisInvoiceEdiVO[]
	 */
	public GlovisInvoiceEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GlovisInvoiceEdiVO[]
	 */
	public GlovisInvoiceEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GlovisInvoiceEdiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] chkInd = (JSPUtil.getParameter(request, prefix	+ "chk_ind", length));
			String[] loclNm = (JSPUtil.getParameter(request, prefix	+ "locl_nm", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] chgKrw = (JSPUtil.getParameter(request, prefix	+ "chg_krw", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ifSeq = (JSPUtil.getParameter(request, prefix	+ "if_seq", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] frtUsd = (JSPUtil.getParameter(request, prefix	+ "frt_usd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] usrLoclNm = (JSPUtil.getParameter(request, prefix	+ "usr_locl_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ediType = (JSPUtil.getParameter(request, prefix	+ "edi_type", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] chgRmk = (JSPUtil.getParameter(request, prefix	+ "chg_rmk", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] ttlAmtKrw = (JSPUtil.getParameter(request, prefix	+ "ttl_amt_krw", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] postCxlFlg = (JSPUtil.getParameter(request, prefix	+ "post_cxl_flg", length));
			String[] ediSndDt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_dt", length));
			String[] reTpCd = (JSPUtil.getParameter(request, prefix	+ "re_tp_cd", length));
			String[] glovisTtlAmtKrw = (JSPUtil.getParameter(request, prefix	+ "glovis_ttl_amt_krw", length));
			String[] euroLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "euro_locl_xch_rt", length));
			String[] frtEur = (JSPUtil.getParameter(request, prefix	+ "frt_eur", length));
			String[] eurGubun = (JSPUtil.getParameter(request, prefix	+ "eur_gubun", length));
			String[] ttlUsdKrwAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_usd_krw_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new GlovisInvoiceEdiVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (chkInd[i] != null)
					model.setChkInd(chkInd[i]);
				if (loclNm[i] != null)
					model.setLoclNm(loclNm[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (chgKrw[i] != null)
					model.setChgKrw(chgKrw[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ifSeq[i] != null)
					model.setIfSeq(ifSeq[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (frtUsd[i] != null)
					model.setFrtUsd(frtUsd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (usrLoclNm[i] != null)
					model.setUsrLoclNm(usrLoclNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ediType[i] != null)
					model.setEdiType(ediType[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (chgRmk[i] != null)
					model.setChgRmk(chgRmk[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (ttlAmtKrw[i] != null)
					model.setTtlAmtKrw(ttlAmtKrw[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (postCxlFlg[i] != null)
					model.setPostCxlFlg(postCxlFlg[i]);
				if (ediSndDt[i] != null)
					model.setEdiSndDt(ediSndDt[i]);
				if (reTpCd[i] != null)
					model.setReTpCd(reTpCd[i]);
				if (glovisTtlAmtKrw[i] != null)
					model.setGlovisTtlAmtKrw(glovisTtlAmtKrw[i]);
				if (euroLoclXchRt[i] != null)
					model.setEuroLoclXchRt(euroLoclXchRt[i]);
				if (frtEur[i] != null)
					model.setFrtEur(frtEur[i]);
				if (eurGubun[i] != null)
					model.setEurGubun(eurGubun[i]);
				if (ttlUsdKrwAmt[i] != null)
					model.setTtlUsdKrwAmt(ttlUsdKrwAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGlovisInvoiceEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GlovisInvoiceEdiVO[]
	 */
	public GlovisInvoiceEdiVO[] getGlovisInvoiceEdiVOs(){
		GlovisInvoiceEdiVO[] vos = (GlovisInvoiceEdiVO[])models.toArray(new GlovisInvoiceEdiVO[models.size()]);
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
		this.chkInd = this.chkInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclNm = this.loclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgKrw = this.chgKrw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSeq = this.ifSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtUsd = this.frtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrLoclNm = this.usrLoclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediType = this.ediType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRmk = this.chgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmtKrw = this.ttlAmtKrw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postCxlFlg = this.postCxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndDt = this.ediSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reTpCd = this.reTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glovisTtlAmtKrw = this.glovisTtlAmtKrw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euroLoclXchRt = this.euroLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtEur = this.frtEur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurGubun = this.eurGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlUsdKrwAmt = this.ttlUsdKrwAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
