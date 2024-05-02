/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchCustomerVO.java
*@FileTitle : SearchCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.28
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.02.28 서미진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo;

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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCustomerVO> models = new ArrayList<SearchCustomerVO>();
	
	/* Column Info */
	private String indivCorpDivCd = null;
	/* Column Info */
	private String customerCd = null;
	/* Column Info */
	private String jbTitRmk = null;
	/* Column Info */
	private String bzetAddr = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String custGrpNm = null;
	/* Column Info */
	private String kmanNlstNm = null;
	/* Column Info */
	private String customerCode = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String custGrpName = null;
	/* Column Info */
	private String custKmanSeq = null;
	/* Column Info */
	private String telNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String cntrCustTpCd = null;
	/* Column Info */
	private String primarySrepCd = null;
	/* Column Info */
	private String custOffice = null;
	/* Column Info */
	private String flg = null;
	/* Column Info */
	private String custEml = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String salesRep = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String custTotal = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String custAbbrNm = null;
	/* Column Info */
	private String ofcEngNm = null;
	/* Column Info */
	private String kmanOfcFaxNo = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Column Info */
	private String custStsCd = null;
	/* Column Info */
	private String keyAcctFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String kmanGndCd = null;
	/* Column Info */
	private String intlFaxNo = null;
	/* Column Info */
	private String kmanN1stNm = null;
	/* Column Info */
	private String opnPg = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String kmanLstNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ctsNo = null;
	/* Column Info */
	private String mltTrdAcctFlg = null;
	/* Column Info */
	private String intlPhnNo = null;

	/* Column Info */
	private String lstUpdDt = null;
	/* Column Info */
	private String srepPrmryFlg = null;
	
	/* Column Info */
	private String preSrepCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCustomerVO() {}

	public SearchCustomerVO(String ibflag, String pagerows, String indivCorpDivCd, String customerCd, String custNm, String jbTitRmk, String ofcEngNm, String kmanOfcFaxNo, String custRgstNo, String custStsCd, String bzetAddr, String srepCd, String cntrCustTpCd, String keyAcctFlg, String locCd, String usrNm, String kmanNlstNm, String custGrpNm, String srepNm, String creOfcCd, String userId, String customerCode, String custGrpName, String kmanGndCd, String intlFaxNo, String kmanN1stNm, String custKmanSeq, String telNo, String custCntCd, String phnNo, String custGrpId, String primarySrepCd, String custOffice, String flg, String custSeq, String custEml, String kmanLstNm, String custLglEngNm, String ofcCd, String salesRep, String creUsrId, String custTotal, String zipCd, String custCd, String ctsNo, String faxNo, String mltTrdAcctFlg, String intlPhnNo, String opnPg, String updUsrId, String custAbbrNm,String lstUpdDt,String srepPrmryFlg, String preSrepCd) {
		this.indivCorpDivCd = indivCorpDivCd;
		this.customerCd = customerCd;
		this.jbTitRmk = jbTitRmk;
		this.bzetAddr = bzetAddr;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.custGrpNm = custGrpNm;
		this.kmanNlstNm = kmanNlstNm;
		this.customerCode = customerCode;
		this.userId = userId;
		this.custGrpName = custGrpName;
		this.custKmanSeq = custKmanSeq;
		this.telNo = telNo;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.phnNo = phnNo;
		this.custGrpId = custGrpId;
		this.cntrCustTpCd = cntrCustTpCd;
		this.primarySrepCd = primarySrepCd;
		this.custOffice = custOffice;
		this.flg = flg;
		this.custEml = custEml;
		this.custLglEngNm = custLglEngNm;
		this.salesRep = salesRep;
		this.creUsrId = creUsrId;
		this.custTotal = custTotal;
		this.zipCd = zipCd;
		this.custCd = custCd;
		this.faxNo = faxNo;
		this.custNm = custNm;
		this.custAbbrNm = custAbbrNm;
		this.ofcEngNm = ofcEngNm;
		this.kmanOfcFaxNo = kmanOfcFaxNo;
		this.custRgstNo = custRgstNo;
		this.custStsCd = custStsCd;
		this.keyAcctFlg = keyAcctFlg;
		this.ibflag = ibflag;
		this.usrNm = usrNm;
		this.creOfcCd = creOfcCd;
		this.srepNm = srepNm;
		this.kmanGndCd = kmanGndCd;
		this.intlFaxNo = intlFaxNo;
		this.kmanN1stNm = kmanN1stNm;
		this.opnPg = opnPg;
		this.custSeq = custSeq;
		this.kmanLstNm = kmanLstNm;
		this.ofcCd = ofcCd;
		this.ctsNo = ctsNo;
		this.mltTrdAcctFlg = mltTrdAcctFlg;
		this.intlPhnNo = intlPhnNo;
		this.lstUpdDt = lstUpdDt;
		this.srepPrmryFlg = srepPrmryFlg;
		this.preSrepCd = preSrepCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("indiv_corp_div_cd", getIndivCorpDivCd());
		this.hashColumns.put("customer_cd", getCustomerCd());
		this.hashColumns.put("jb_tit_rmk", getJbTitRmk());
		this.hashColumns.put("bzet_addr", getBzetAddr());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("kman_nlst_nm", getKmanNlstNm());
		this.hashColumns.put("customer_code", getCustomerCode());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("cust_grp_name", getCustGrpName());
		this.hashColumns.put("cust_kman_seq", getCustKmanSeq());
		this.hashColumns.put("tel_no", getTelNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("cntr_cust_tp_cd", getCntrCustTpCd());
		this.hashColumns.put("primary_srep_cd", getPrimarySrepCd());
		this.hashColumns.put("cust_office", getCustOffice());
		this.hashColumns.put("flg", getFlg());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("sales_rep", getSalesRep());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cust_total", getCustTotal());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cust_abbr_nm", getCustAbbrNm());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("kman_ofc_fax_no", getKmanOfcFaxNo());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("cust_sts_cd", getCustStsCd());
		this.hashColumns.put("key_acct_flg", getKeyAcctFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("kman_gnd_cd", getKmanGndCd());
		this.hashColumns.put("intl_fax_no", getIntlFaxNo());
		this.hashColumns.put("kman_n1st_nm", getKmanN1stNm());
		this.hashColumns.put("opn_pg", getOpnPg());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("kman_lst_nm", getKmanLstNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cts_no", getCtsNo());
		this.hashColumns.put("mlt_trd_acct_flg", getMltTrdAcctFlg());
		this.hashColumns.put("intl_phn_no", getIntlPhnNo());
		this.hashColumns.put("lst_upd_dt", getLstUpdDt());
		this.hashColumns.put("srep_prmry_flg", getSrepPrmryFlg());
		
		this.hashColumns.put("pre_srep_cd", getPreSrepCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("indiv_corp_div_cd", "indivCorpDivCd");
		this.hashFields.put("customer_cd", "customerCd");
		this.hashFields.put("jb_tit_rmk", "jbTitRmk");
		this.hashFields.put("bzet_addr", "bzetAddr");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("kman_nlst_nm", "kmanNlstNm");
		this.hashFields.put("customer_code", "customerCode");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("cust_grp_name", "custGrpName");
		this.hashFields.put("cust_kman_seq", "custKmanSeq");
		this.hashFields.put("tel_no", "telNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("cntr_cust_tp_cd", "cntrCustTpCd");
		this.hashFields.put("primary_srep_cd", "primarySrepCd");
		this.hashFields.put("cust_office", "custOffice");
		this.hashFields.put("flg", "flg");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("sales_rep", "salesRep");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cust_total", "custTotal");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cust_abbr_nm", "custAbbrNm");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("kman_ofc_fax_no", "kmanOfcFaxNo");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("cust_sts_cd", "custStsCd");
		this.hashFields.put("key_acct_flg", "keyAcctFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("kman_gnd_cd", "kmanGndCd");
		this.hashFields.put("intl_fax_no", "intlFaxNo");
		this.hashFields.put("kman_n1st_nm", "kmanN1stNm");
		this.hashFields.put("opn_pg", "opnPg");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("kman_lst_nm", "kmanLstNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cts_no", "ctsNo");
		this.hashFields.put("mlt_trd_acct_flg", "mltTrdAcctFlg");
		this.hashFields.put("intl_phn_no", "intlPhnNo");
		this.hashFields.put("lst_upd_dt", "lstUpdDt");
		this.hashFields.put("srep_prmry_flg", "srepPrmryFlg");
		
		this.hashFields.put("pre_srep_cd", "preSrepCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return indivCorpDivCd
	 */
	public String getIndivCorpDivCd() {
		return this.indivCorpDivCd;
	}
	
	/**
	 * Column Info
	 * @return customerCd
	 */
	public String getCustomerCd() {
		return this.customerCd;
	}
	
	/**
	 * Column Info
	 * @return jbTitRmk
	 */
	public String getJbTitRmk() {
		return this.jbTitRmk;
	}
	
	/**
	 * Column Info
	 * @return bzetAddr
	 */
	public String getBzetAddr() {
		return this.bzetAddr;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return custGrpNm
	 */
	public String getCustGrpNm() {
		return this.custGrpNm;
	}
	
	/**
	 * Column Info
	 * @return kmanNlstNm
	 */
	public String getKmanNlstNm() {
		return this.kmanNlstNm;
	}
	
	/**
	 * Column Info
	 * @return customerCode
	 */
	public String getCustomerCode() {
		return this.customerCode;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return custGrpName
	 */
	public String getCustGrpName() {
		return this.custGrpName;
	}
	
	/**
	 * Column Info
	 * @return custKmanSeq
	 */
	public String getCustKmanSeq() {
		return this.custKmanSeq;
	}
	
	/**
	 * Column Info
	 * @return telNo
	 */
	public String getTelNo() {
		return this.telNo;
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
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return custGrpId
	 */
	public String getCustGrpId() {
		return this.custGrpId;
	}
	
	/**
	 * Column Info
	 * @return cntrCustTpCd
	 */
	public String getCntrCustTpCd() {
		return this.cntrCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return primarySrepCd
	 */
	public String getPrimarySrepCd() {
		return this.primarySrepCd;
	}
	
	/**
	 * Column Info
	 * @return custOffice
	 */
	public String getCustOffice() {
		return this.custOffice;
	}
	
	/**
	 * Column Info
	 * @return flg
	 */
	public String getFlg() {
		return this.flg;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return salesRep
	 */
	public String getSalesRep() {
		return this.salesRep;
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
	 * @return custTotal
	 */
	public String getCustTotal() {
		return this.custTotal;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
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
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
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
	 * @return custAbbrNm
	 */
	public String getCustAbbrNm() {
		return this.custAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return ofcEngNm
	 */
	public String getOfcEngNm() {
		return this.ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @return kmanOfcFaxNo
	 */
	public String getKmanOfcFaxNo() {
		return this.kmanOfcFaxNo;
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
	 * @return custStsCd
	 */
	public String getCustStsCd() {
		return this.custStsCd;
	}
	
	/**
	 * Column Info
	 * @return keyAcctFlg
	 */
	public String getKeyAcctFlg() {
		return this.keyAcctFlg;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
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
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
	}
	
	/**
	 * Column Info
	 * @return kmanGndCd
	 */
	public String getKmanGndCd() {
		return this.kmanGndCd;
	}
	
	/**
	 * Column Info
	 * @return intlFaxNo
	 */
	public String getIntlFaxNo() {
		return this.intlFaxNo;
	}
	
	/**
	 * Column Info
	 * @return kmanN1stNm
	 */
	public String getKmanN1stNm() {
		return this.kmanN1stNm;
	}
	
	/**
	 * Column Info
	 * @return opnPg
	 */
	public String getOpnPg() {
		return this.opnPg;
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
	 * @return kmanLstNm
	 */
	public String getKmanLstNm() {
		return this.kmanLstNm;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return ctsNo
	 */
	public String getCtsNo() {
		return this.ctsNo;
	}
	
	/**
	 * Column Info
	 * @return mltTrdAcctFlg
	 */
	public String getMltTrdAcctFlg() {
		return this.mltTrdAcctFlg;
	}
	
	/**
	 * Column Info
	 * @return intlPhnNo
	 */
	public String getIntlPhnNo() {
		return this.intlPhnNo;
	}

	/**
	 * Column Info
	 * @return lstUpdDt
	 */
	public String getLstUpdDt() {
		return this.lstUpdDt;
	}

	/**
	 * Column Info
	 * @return srepPrmryFlg
	 */
	public String getSrepPrmryFlg() {
		return this.srepPrmryFlg;
	}

	/**
	 * Column Info
	 * @return preSrepCd
	 */
	public String getPreSrepCd() {
		return this.preSrepCd;
	}
	

	/**
	 * Column Info
	 * @param indivCorpDivCd
	 */
	public void setIndivCorpDivCd(String indivCorpDivCd) {
		this.indivCorpDivCd = indivCorpDivCd;
	}
	
	/**
	 * Column Info
	 * @param customerCd
	 */
	public void setCustomerCd(String customerCd) {
		this.customerCd = customerCd;
	}
	
	/**
	 * Column Info
	 * @param jbTitRmk
	 */
	public void setJbTitRmk(String jbTitRmk) {
		this.jbTitRmk = jbTitRmk;
	}
	
	/**
	 * Column Info
	 * @param bzetAddr
	 */
	public void setBzetAddr(String bzetAddr) {
		this.bzetAddr = bzetAddr;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param custGrpNm
	 */
	public void setCustGrpNm(String custGrpNm) {
		this.custGrpNm = custGrpNm;
	}
	
	/**
	 * Column Info
	 * @param kmanNlstNm
	 */
	public void setKmanNlstNm(String kmanNlstNm) {
		this.kmanNlstNm = kmanNlstNm;
	}
	
	/**
	 * Column Info
	 * @param customerCode
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param custGrpName
	 */
	public void setCustGrpName(String custGrpName) {
		this.custGrpName = custGrpName;
	}
	
	/**
	 * Column Info
	 * @param custKmanSeq
	 */
	public void setCustKmanSeq(String custKmanSeq) {
		this.custKmanSeq = custKmanSeq;
	}
	
	/**
	 * Column Info
	 * @param telNo
	 */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
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
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
	}
	
	/**
	 * Column Info
	 * @param cntrCustTpCd
	 */
	public void setCntrCustTpCd(String cntrCustTpCd) {
		this.cntrCustTpCd = cntrCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param primarySrepCd
	 */
	public void setPrimarySrepCd(String primarySrepCd) {
		this.primarySrepCd = primarySrepCd;
	}
	
	/**
	 * Column Info
	 * @param custOffice
	 */
	public void setCustOffice(String custOffice) {
		this.custOffice = custOffice;
	}
	
	/**
	 * Column Info
	 * @param flg
	 */
	public void setFlg(String flg) {
		this.flg = flg;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param salesRep
	 */
	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
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
	 * @param custTotal
	 */
	public void setCustTotal(String custTotal) {
		this.custTotal = custTotal;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
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
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
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
	 * @param custAbbrNm
	 */
	public void setCustAbbrNm(String custAbbrNm) {
		this.custAbbrNm = custAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param ofcEngNm
	 */
	public void setOfcEngNm(String ofcEngNm) {
		this.ofcEngNm = ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @param kmanOfcFaxNo
	 */
	public void setKmanOfcFaxNo(String kmanOfcFaxNo) {
		this.kmanOfcFaxNo = kmanOfcFaxNo;
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
	 * @param custStsCd
	 */
	public void setCustStsCd(String custStsCd) {
		this.custStsCd = custStsCd;
	}
	
	/**
	 * Column Info
	 * @param keyAcctFlg
	 */
	public void setKeyAcctFlg(String keyAcctFlg) {
		this.keyAcctFlg = keyAcctFlg;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * Column Info
	 * @param kmanGndCd
	 */
	public void setKmanGndCd(String kmanGndCd) {
		this.kmanGndCd = kmanGndCd;
	}
	
	/**
	 * Column Info
	 * @param intlFaxNo
	 */
	public void setIntlFaxNo(String intlFaxNo) {
		this.intlFaxNo = intlFaxNo;
	}
	
	/**
	 * Column Info
	 * @param kmanN1stNm
	 */
	public void setKmanN1stNm(String kmanN1stNm) {
		this.kmanN1stNm = kmanN1stNm;
	}
	
	/**
	 * Column Info
	 * @param opnPg
	 */
	public void setOpnPg(String opnPg) {
		this.opnPg = opnPg;
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
	 * @param kmanLstNm
	 */
	public void setKmanLstNm(String kmanLstNm) {
		this.kmanLstNm = kmanLstNm;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param ctsNo
	 */
	public void setCtsNo(String ctsNo) {
		this.ctsNo = ctsNo;
	}
	
	/**
	 * Column Info
	 * @param mltTrdAcctFlg
	 */
	public void setMltTrdAcctFlg(String mltTrdAcctFlg) {
		this.mltTrdAcctFlg = mltTrdAcctFlg;
	}
	
	/**
	 * Column Info
	 * @param intlPhnNo
	 */
	public void setIntlPhnNo(String intlPhnNo) {
		this.intlPhnNo = intlPhnNo;
	}
	/**
	 * Column Info
	 * @param lstUpdDt
	 */
	public void setLstUpdDt(String lstUpdDt) {
		this.lstUpdDt = lstUpdDt;
	}

	
	/**
	 * Column Info
	 * @param srepPrmryFlg
	 */
	public void setSrepPrmryFlg(String srepPrmryFlg) {
		this.srepPrmryFlg = srepPrmryFlg;
	}
	
	/**
	 * Column Info
	 * @param preSrepCd
	 */
	public void setPreSrepCd(String preSrepCd) {
		this.preSrepCd = preSrepCd;
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
		setIndivCorpDivCd(JSPUtil.getParameter(request, prefix + "indiv_corp_div_cd", ""));
		setCustomerCd(JSPUtil.getParameter(request, prefix + "customer_cd", ""));
		setJbTitRmk(JSPUtil.getParameter(request, prefix + "jb_tit_rmk", ""));
		setBzetAddr(JSPUtil.getParameter(request, prefix + "bzet_addr", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
		setKmanNlstNm(JSPUtil.getParameter(request, prefix + "kman_nlst_nm", ""));
		setCustomerCode(JSPUtil.getParameter(request, prefix + "customer_code", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setCustGrpName(JSPUtil.getParameter(request, prefix + "cust_grp_name", ""));
		setCustKmanSeq(JSPUtil.getParameter(request, prefix + "cust_kman_seq", ""));
		setTelNo(JSPUtil.getParameter(request, prefix + "tel_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setCntrCustTpCd(JSPUtil.getParameter(request, prefix + "cntr_cust_tp_cd", ""));
		setPrimarySrepCd(JSPUtil.getParameter(request, prefix + "primary_srep_cd", ""));
		setCustOffice(JSPUtil.getParameter(request, prefix + "cust_office", ""));
		setFlg(JSPUtil.getParameter(request, prefix + "flg", ""));
		setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setSalesRep(JSPUtil.getParameter(request, prefix + "sales_rep", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCustTotal(JSPUtil.getParameter(request, prefix + "cust_total", ""));
		setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCustAbbrNm(JSPUtil.getParameter(request, prefix + "cust_abbr_nm", ""));
		setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
		setKmanOfcFaxNo(JSPUtil.getParameter(request, prefix + "kman_ofc_fax_no", ""));
		setCustRgstNo(JSPUtil.getParameter(request, prefix + "cust_rgst_no", ""));
		setCustStsCd(JSPUtil.getParameter(request, prefix + "cust_sts_cd", ""));
		setKeyAcctFlg(JSPUtil.getParameter(request, prefix + "key_acct_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setKmanGndCd(JSPUtil.getParameter(request, prefix + "kman_gnd_cd", ""));
		setIntlFaxNo(JSPUtil.getParameter(request, prefix + "intl_fax_no", ""));
		setKmanN1stNm(JSPUtil.getParameter(request, prefix + "kman_n1st_nm", ""));
		setOpnPg(JSPUtil.getParameter(request, prefix + "opn_pg", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setKmanLstNm(JSPUtil.getParameter(request, prefix + "kman_lst_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCtsNo(JSPUtil.getParameter(request, prefix + "cts_no", ""));
		setMltTrdAcctFlg(JSPUtil.getParameter(request, prefix + "mlt_trd_acct_flg", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
		
		setLstUpdDt(JSPUtil.getParameter(request, prefix + "lst_upd_dt", ""));
		setSrepPrmryFlg(JSPUtil.getParameter(request, prefix + "srep_prmry_flg", ""));
		
		setPreSrepCd(JSPUtil.getParameter(request, prefix + "pre_srep_cd", ""));	
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCustomerVO[]
	 */
	public SearchCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCustomerVO[]
	 */
	public SearchCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] indivCorpDivCd = (JSPUtil.getParameter(request, prefix	+ "indiv_corp_div_cd", length));
			String[] customerCd = (JSPUtil.getParameter(request, prefix	+ "customer_cd", length));
			String[] jbTitRmk = (JSPUtil.getParameter(request, prefix	+ "jb_tit_rmk", length));
			String[] bzetAddr = (JSPUtil.getParameter(request, prefix	+ "bzet_addr", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] kmanNlstNm = (JSPUtil.getParameter(request, prefix	+ "kman_nlst_nm", length));
			String[] customerCode = (JSPUtil.getParameter(request, prefix	+ "customer_code", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] custGrpName = (JSPUtil.getParameter(request, prefix	+ "cust_grp_name", length));
			String[] custKmanSeq = (JSPUtil.getParameter(request, prefix	+ "cust_kman_seq", length));
			String[] telNo = (JSPUtil.getParameter(request, prefix	+ "tel_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] cntrCustTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_cust_tp_cd", length));
			String[] primarySrepCd = (JSPUtil.getParameter(request, prefix	+ "primary_srep_cd", length));
			String[] custOffice = (JSPUtil.getParameter(request, prefix	+ "cust_office", length));
			String[] flg = (JSPUtil.getParameter(request, prefix	+ "flg", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] salesRep = (JSPUtil.getParameter(request, prefix	+ "sales_rep", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] custTotal = (JSPUtil.getParameter(request, prefix	+ "cust_total", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] custAbbrNm = (JSPUtil.getParameter(request, prefix	+ "cust_abbr_nm", length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm", length));
			String[] kmanOfcFaxNo = (JSPUtil.getParameter(request, prefix	+ "kman_ofc_fax_no", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] custStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_sts_cd", length));
			String[] keyAcctFlg = (JSPUtil.getParameter(request, prefix	+ "key_acct_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] kmanGndCd = (JSPUtil.getParameter(request, prefix	+ "kman_gnd_cd", length));
			String[] intlFaxNo = (JSPUtil.getParameter(request, prefix	+ "intl_fax_no", length));
			String[] kmanN1stNm = (JSPUtil.getParameter(request, prefix	+ "kman_n1st_nm", length));
			String[] opnPg = (JSPUtil.getParameter(request, prefix	+ "opn_pg", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] kmanLstNm = (JSPUtil.getParameter(request, prefix	+ "kman_lst_nm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ctsNo = (JSPUtil.getParameter(request, prefix	+ "cts_no", length));
			String[] mltTrdAcctFlg = (JSPUtil.getParameter(request, prefix	+ "mlt_trd_acct_flg", length));
			String[] intlPhnNo = (JSPUtil.getParameter(request, prefix	+ "intl_phn_no", length));
			
			String[] lstUpdDt = (JSPUtil.getParameter(request, prefix	+ "lst_upd_dt", length));
			String[] srepPrmryFlg = (JSPUtil.getParameter(request, prefix	+ "srep_prmry_flg", length));
			
			String[] preSrepCd = (JSPUtil.getParameter(request, prefix	+ "pre_srep_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCustomerVO();
				if (indivCorpDivCd[i] != null)
					model.setIndivCorpDivCd(indivCorpDivCd[i]);
				if (customerCd[i] != null)
					model.setCustomerCd(customerCd[i]);
				if (jbTitRmk[i] != null)
					model.setJbTitRmk(jbTitRmk[i]);
				if (bzetAddr[i] != null)
					model.setBzetAddr(bzetAddr[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (custGrpNm[i] != null)
					model.setCustGrpNm(custGrpNm[i]);
				if (kmanNlstNm[i] != null)
					model.setKmanNlstNm(kmanNlstNm[i]);
				if (customerCode[i] != null)
					model.setCustomerCode(customerCode[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (custGrpName[i] != null)
					model.setCustGrpName(custGrpName[i]);
				if (custKmanSeq[i] != null)
					model.setCustKmanSeq(custKmanSeq[i]);
				if (telNo[i] != null)
					model.setTelNo(telNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (cntrCustTpCd[i] != null)
					model.setCntrCustTpCd(cntrCustTpCd[i]);
				if (primarySrepCd[i] != null)
					model.setPrimarySrepCd(primarySrepCd[i]);
				if (custOffice[i] != null)
					model.setCustOffice(custOffice[i]);
				if (flg[i] != null)
					model.setFlg(flg[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (salesRep[i] != null)
					model.setSalesRep(salesRep[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (custTotal[i] != null)
					model.setCustTotal(custTotal[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (custAbbrNm[i] != null)
					model.setCustAbbrNm(custAbbrNm[i]);
				if (ofcEngNm[i] != null)
					model.setOfcEngNm(ofcEngNm[i]);
				if (kmanOfcFaxNo[i] != null)
					model.setKmanOfcFaxNo(kmanOfcFaxNo[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (custStsCd[i] != null)
					model.setCustStsCd(custStsCd[i]);
				if (keyAcctFlg[i] != null)
					model.setKeyAcctFlg(keyAcctFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (kmanGndCd[i] != null)
					model.setKmanGndCd(kmanGndCd[i]);
				if (intlFaxNo[i] != null)
					model.setIntlFaxNo(intlFaxNo[i]);
				if (kmanN1stNm[i] != null)
					model.setKmanN1stNm(kmanN1stNm[i]);
				if (opnPg[i] != null)
					model.setOpnPg(opnPg[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (kmanLstNm[i] != null)
					model.setKmanLstNm(kmanLstNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ctsNo[i] != null)
					model.setCtsNo(ctsNo[i]);
				if (mltTrdAcctFlg[i] != null)
					model.setMltTrdAcctFlg(mltTrdAcctFlg[i]);
				if (intlPhnNo[i] != null)
					model.setIntlPhnNo(intlPhnNo[i]);
				
				if (lstUpdDt[i] != null)
					model.setLstUpdDt(lstUpdDt[i]);
				if (srepPrmryFlg[i] != null)
					model.setSrepPrmryFlg(srepPrmryFlg[i]);
				
				if (preSrepCd[i] != null)
					model.setPreSrepCd(preSrepCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCustomerVO[]
	 */
	public SearchCustomerVO[] getSearchCustomerVOs(){
		SearchCustomerVO[] vos = (SearchCustomerVO[])models.toArray(new SearchCustomerVO[models.size()]);
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
		this.indivCorpDivCd = this.indivCorpDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerCd = this.customerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbTitRmk = this.jbTitRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetAddr = this.bzetAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanNlstNm = this.kmanNlstNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerCode = this.customerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpName = this.custGrpName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custKmanSeq = this.custKmanSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.telNo = this.telNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCustTpCd = this.cntrCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.primarySrepCd = this.primarySrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custOffice = this.custOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flg = this.flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesRep = this.salesRep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTotal = this.custTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAbbrNm = this.custAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanOfcFaxNo = this.kmanOfcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStsCd = this.custStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyAcctFlg = this.keyAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanGndCd = this.kmanGndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlFaxNo = this.intlFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanN1stNm = this.kmanN1stNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opnPg = this.opnPg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanLstNm = this.kmanLstNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctsNo = this.ctsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mltTrdAcctFlg = this.mltTrdAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlPhnNo = this.intlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.lstUpdDt = this.lstUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepPrmryFlg = this.srepPrmryFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.preSrepCd = this.preSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
