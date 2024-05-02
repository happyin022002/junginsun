/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : RsltRtListHorizontalExcelVO.java
 *@FileTitle : RsltRtListHorizontalExcelVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.02.05
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2016.02.05 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author jaewonLee
 * @since J2EE 1.6
 * @see	..
 */
public class RsltRtListHorizontalExcelVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<RsltRtListHorizontalExcelVO>  models =	new	ArrayList<RsltRtListHorizontalExcelVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String rowIdx = null;
	/*	Column Info	*/
	private String propNo = null;
	/*	Column Info	*/
	private String amdtSeq = null;
	/*	Column Info	*/
	private String svcScpCd = null;
	/*	Column Info	*/
	private String type = null;
	/*	Column Info	*/
	private String cmdtHdrSeq = null;
	/*	Column Info	*/
	private String prcCmdtDefCd = null;
	/*	Column Info	*/
	private String prcCmdtDefNm = null;
	/*	Column Info	*/
	private String custSeq = null;
	/*	Column Info	*/
	private String custLglEngNm = null;
	/*	Column Info	*/
	private String routSeq = null;
	/*	Column Info	*/
	private String orgRoutPntLocDefCd = null;
	/*	Column Info	*/
	private String orgRoutPntLocDefNm = null;
	/*	Column Info	*/
	private String orgRcvDeTermNm = null;
	/*	Column Info	*/
	private String orgPrcTrspModNm = null;
	/*	Column Info	*/
	private String orgRoutViaPortDefCd = null;
	/*	Column Info	*/
	private String destRoutViaPortDefCd = null;
	/*	Column Info	*/
	private String destRoutPntLocDefCd = null;
	/*	Column Info	*/
	private String destRoutPntLocDefNm = null;
	/*	Column Info	*/
	private String destRcvDeTermNm = null;
	/*	Column Info	*/
	private String destPrcTrspModNm = null;
	/*	Column Info	*/
	private String prefixNm = null;
	/*	Column Info	*/
	private String prcCgoTpCd = null;
	/*	Column Info	*/
	private String rate20 = null;
	/*	Column Info	*/
	private String rate40 = null;
	/*	Column Info	*/
	private String rate40hc = null;
	/*	Column Info	*/
	private String rate45 = null;
	/*	Column Info	*/
	private String cnoteDesc = null;
	/*	Column Info	*/
	private String rnoteDesc = null;
	/*	Column Info	*/
	private String chkPrcCmdtDefCd = null;
	/*	Column Info	*/
	private String chkCustSeq = null;
	/*	Column Info	*/
	private String chkOrgRoutPntLocDefCd = null;
	/*	Column Info	*/
	private String chkDestRoutPntLocDefCd = null;
	/*	Column Info	*/
	private String chkOrgRoutViaPortDefCd = null;
	/*	Column Info	*/
	private String chkDestRoutViaPortDefCd = null;
	/*	Column Info	*/
	private String chkOrgRcvDeTermNm = null;
	/*	Column Info	*/
	private String chkOrgPrcTrspModNm = null;
	/*	Column Info	*/
	private String chkDestRcvDeTermNm = null;
	/*	Column Info	*/
	private String chkDestPrcTrspModNm = null;
	/*	Column Info	*/
	private String chkPrcCmdtDefDup = null;
	/*	Column Info	*/
	private String chkOrgDestDup = null;
	/*	Column Info	*/
	private String chkCmdtHdrSeq = null;
	/*	Column Info	*/
	private String chkRoutSeq = null;
	/*	Column Info	*/
	private String chkOrgSemi = null;
	/*	Column Info	*/
	private String chkDestSemi = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public RsltRtListHorizontalExcelVO(){}

	public RsltRtListHorizontalExcelVO(String ibflag,String pagerows,String rowIdx,String propNo,String amdtSeq,String svcScpCd,String type,String cmdtHdrSeq,String prcCmdtDefCd,String prcCmdtDefNm,String custSeq,String custLglEngNm,String routSeq,String orgRoutPntLocDefCd,String orgRoutPntLocDefNm,String orgRcvDeTermNm,String orgPrcTrspModNm,String orgRoutViaPortDefCd,String destRoutViaPortDefCd,String destRoutPntLocDefCd,String destRoutPntLocDefNm,String destRcvDeTermNm,String destPrcTrspModNm,String prefixNm,String prcCgoTpCd,String rate20,String rate40,String rate40hc,String rate45,String cnoteDesc,String rnoteDesc,String chkPrcCmdtDefCd,String chkCustSeq,String chkOrgRoutPntLocDefCd,String chkDestRoutPntLocDefCd,String chkOrgRoutViaPortDefCd,String chkDestRoutViaPortDefCd,String chkOrgRcvDeTermNm,String chkOrgPrcTrspModNm,String chkDestRcvDeTermNm,String chkDestPrcTrspModNm,String chkPrcCmdtDefDup,String chkOrgDestDup,String chkCmdtHdrSeq,String chkRoutSeq,String chkOrgSemi,String chkDestSemi)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.rowIdx = rowIdx;
		this.propNo = propNo;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.type = type;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.prcCmdtDefNm = prcCmdtDefNm;
		this.custSeq = custSeq;
		this.custLglEngNm = custLglEngNm;
		this.routSeq = routSeq;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
		this.orgRcvDeTermNm = orgRcvDeTermNm;
		this.orgPrcTrspModNm = orgPrcTrspModNm;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
		this.destRcvDeTermNm = destRcvDeTermNm;
		this.destPrcTrspModNm = destPrcTrspModNm;
		this.prefixNm = prefixNm;
		this.prcCgoTpCd = prcCgoTpCd;
		this.rate20 = rate20;
		this.rate40 = rate40;
		this.rate40hc = rate40hc;
		this.rate45 = rate45;
		this.cnoteDesc = cnoteDesc;
		this.rnoteDesc = rnoteDesc;
		this.chkPrcCmdtDefCd = chkPrcCmdtDefCd;
		this.chkCustSeq = chkCustSeq;
		this.chkOrgRoutPntLocDefCd = chkOrgRoutPntLocDefCd;
		this.chkDestRoutPntLocDefCd = chkDestRoutPntLocDefCd;
		this.chkOrgRoutViaPortDefCd = chkOrgRoutViaPortDefCd;
		this.chkDestRoutViaPortDefCd = chkDestRoutViaPortDefCd;
		this.chkOrgRcvDeTermNm = chkOrgRcvDeTermNm;
		this.chkOrgPrcTrspModNm = chkOrgPrcTrspModNm;
		this.chkDestRcvDeTermNm = chkDestRcvDeTermNm;
		this.chkDestPrcTrspModNm = chkDestPrcTrspModNm;
		this.chkPrcCmdtDefDup = chkPrcCmdtDefDup;
		this.chkOrgDestDup = chkOrgDestDup;
		this.chkCmdtHdrSeq = chkCmdtHdrSeq;
		this.chkRoutSeq = chkRoutSeq;
		this.chkOrgSemi = chkOrgSemi;
		this.chkDestSemi = chkDestSemi;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("row_idx", getRowIdx());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("prc_cmdt_def_nm", getPrcCmdtDefNm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("org_rout_pnt_loc_def_nm", getOrgRoutPntLocDefNm());
		this.hashColumns.put("org_rcv_de_term_nm", getOrgRcvDeTermNm());
		this.hashColumns.put("org_prc_trsp_mod_nm", getOrgPrcTrspModNm());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("dest_rout_pnt_loc_def_nm", getDestRoutPntLocDefNm());
		this.hashColumns.put("dest_rcv_de_term_nm", getDestRcvDeTermNm());
		this.hashColumns.put("dest_prc_trsp_mod_nm", getDestPrcTrspModNm());
		this.hashColumns.put("prefix_nm", getPrefixNm());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("rate_20", getRate20());
		this.hashColumns.put("rate_40", getRate40());
		this.hashColumns.put("rate_40hc", getRate40hc());
		this.hashColumns.put("rate_45", getRate45());
		this.hashColumns.put("cnote_desc", getCnoteDesc());
		this.hashColumns.put("rnote_desc", getRnoteDesc());
		this.hashColumns.put("chk_prc_cmdt_def_cd", getChkPrcCmdtDefCd());
		this.hashColumns.put("chk_cust_seq", getChkCustSeq());
		this.hashColumns.put("chk_org_rout_pnt_loc_def_cd", getChkOrgRoutPntLocDefCd());
		this.hashColumns.put("chk_dest_rout_pnt_loc_def_cd", getChkDestRoutPntLocDefCd());
		this.hashColumns.put("chk_org_rout_via_port_def_cd", getChkOrgRoutViaPortDefCd());
		this.hashColumns.put("chk_dest_rout_via_port_def_cd", getChkDestRoutViaPortDefCd());
		this.hashColumns.put("chk_org_rcv_de_term_nm", getChkOrgRcvDeTermNm());
		this.hashColumns.put("chk_org_prc_trsp_mod_nm", getChkOrgPrcTrspModNm());
		this.hashColumns.put("chk_dest_rcv_de_term_nm", getChkDestRcvDeTermNm());
		this.hashColumns.put("chk_dest_prc_trsp_mod_nm", getChkDestPrcTrspModNm());
		this.hashColumns.put("chk_prc_cmdt_def_dup", getChkPrcCmdtDefDup());
		this.hashColumns.put("chk_org_dest_dup", getChkOrgDestDup());
		this.hashColumns.put("chk_cmdt_hdr_seq", getChkCmdtHdrSeq());
		this.hashColumns.put("chk_rout_seq", getChkRoutSeq());
		this.hashColumns.put("chk_org_semi", getChkOrgSemi());
		this.hashColumns.put("chk_dest_semi", getChkDestSemi());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("row_idx", "rowIdx");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("type", "type");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("prc_cmdt_def_nm", "prcCmdtDefNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("org_rout_pnt_loc_def_nm", "orgRoutPntLocDefNm");
		this.hashFields.put("org_rcv_de_term_nm", "orgRcvDeTermNm");
		this.hashFields.put("org_prc_trsp_mod_nm", "orgPrcTrspModNm");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("dest_rout_pnt_loc_def_nm", "destRoutPntLocDefNm");
		this.hashFields.put("dest_rcv_de_term_nm", "destRcvDeTermNm");
		this.hashFields.put("dest_prc_trsp_mod_nm", "destPrcTrspModNm");
		this.hashFields.put("prefix_nm", "prefixNm");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("rate_20", "rate20");
		this.hashFields.put("rate_40", "rate40");
		this.hashFields.put("rate_40hc", "rate40hc");
		this.hashFields.put("rate_45", "rate45");
		this.hashFields.put("cnote_desc", "cnoteDesc");
		this.hashFields.put("rnote_desc", "rnoteDesc");
		this.hashFields.put("chk_prc_cmdt_def_cd", "chkPrcCmdtDefCd");
		this.hashFields.put("chk_cust_seq", "chkCustSeq");
		this.hashFields.put("chk_org_rout_pnt_loc_def_cd", "chkOrgRoutPntLocDefCd");
		this.hashFields.put("chk_dest_rout_pnt_loc_def_cd", "chkDestRoutPntLocDefCd");
		this.hashFields.put("chk_org_rout_via_port_def_cd", "chkOrgRoutViaPortDefCd");
		this.hashFields.put("chk_dest_rout_via_port_def_cd", "chkDestRoutViaPortDefCd");
		this.hashFields.put("chk_org_rcv_de_term_nm", "chkOrgRcvDeTermNm");
		this.hashFields.put("chk_org_prc_trsp_mod_nm", "chkOrgPrcTrspModNm");
		this.hashFields.put("chk_dest_rcv_de_term_nm", "chkDestRcvDeTermNm");
		this.hashFields.put("chk_dest_prc_trsp_mod_nm", "chkDestPrcTrspModNm");
		this.hashFields.put("chk_prc_cmdt_def_dup", "chkPrcCmdtDefDup");
		this.hashFields.put("chk_org_dest_dup", "chkOrgDestDup");
		this.hashFields.put("chk_cmdt_hdr_seq", "chkCmdtHdrSeq");
		this.hashFields.put("chk_rout_seq", "chkRoutSeq");
		this.hashFields.put("chk_org_semi", "chkOrgSemi");
		this.hashFields.put("chk_dest_semi", "chkDestSemi");
		return this.hashFields;
	}

	//	Getters	and	Setters

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public	String getIbflag() {
		return	this.ibflag;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public	String getPagerows() {
		return	this.pagerows;
	}

	/**
	 * Column Info
	 * @return rowIdx
	 */
	public	String getRowIdx() {
		return	this.rowIdx;
	}

	/**
	 * Column Info
	 * @return propNo
	 */
	public	String getPropNo() {
		return	this.propNo;
	}

	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public	String getAmdtSeq() {
		return	this.amdtSeq;
	}

	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public	String getSvcScpCd() {
		return	this.svcScpCd;
	}

	/**
	 * Column Info
	 * @return type
	 */
	public	String getType() {
		return	this.type;
	}

	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public	String getCmdtHdrSeq() {
		return	this.cmdtHdrSeq;
	}

	/**
	 * Column Info
	 * @return prcCmdtDefCd
	 */
	public	String getPrcCmdtDefCd() {
		return	this.prcCmdtDefCd;
	}

	/**
	 * Column Info
	 * @return prcCmdtDefNm
	 */
	public	String getPrcCmdtDefNm() {
		return	this.prcCmdtDefNm;
	}

	/**
	 * Column Info
	 * @return custSeq
	 */
	public	String getCustSeq() {
		return	this.custSeq;
	}

	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public	String getCustLglEngNm() {
		return	this.custLglEngNm;
	}

	/**
	 * Column Info
	 * @return routSeq
	 */
	public	String getRoutSeq() {
		return	this.routSeq;
	}

	/**
	 * Column Info
	 * @return orgRoutPntLocDefCd
	 */
	public	String getOrgRoutPntLocDefCd() {
		return	this.orgRoutPntLocDefCd;
	}

	/**
	 * Column Info
	 * @return orgRoutPntLocDefNm
	 */
	public	String getOrgRoutPntLocDefNm() {
		return	this.orgRoutPntLocDefNm;
	}

	/**
	 * Column Info
	 * @return orgRcvDeTermNm
	 */
	public	String getOrgRcvDeTermNm() {
		return	this.orgRcvDeTermNm;
	}

	/**
	 * Column Info
	 * @return orgPrcTrspModNm
	 */
	public	String getOrgPrcTrspModNm() {
		return	this.orgPrcTrspModNm;
	}

	/**
	 * Column Info
	 * @return orgRoutViaPortDefCd
	 */
	public	String getOrgRoutViaPortDefCd() {
		return	this.orgRoutViaPortDefCd;
	}

	/**
	 * Column Info
	 * @return destRoutViaPortDefCd
	 */
	public	String getDestRoutViaPortDefCd() {
		return	this.destRoutViaPortDefCd;
	}

	/**
	 * Column Info
	 * @return destRoutPntLocDefCd
	 */
	public	String getDestRoutPntLocDefCd() {
		return	this.destRoutPntLocDefCd;
	}

	/**
	 * Column Info
	 * @return destRoutPntLocDefNm
	 */
	public	String getDestRoutPntLocDefNm() {
		return	this.destRoutPntLocDefNm;
	}

	/**
	 * Column Info
	 * @return destRcvDeTermNm
	 */
	public	String getDestRcvDeTermNm() {
		return	this.destRcvDeTermNm;
	}

	/**
	 * Column Info
	 * @return destPrcTrspModNm
	 */
	public	String getDestPrcTrspModNm() {
		return	this.destPrcTrspModNm;
	}

	/**
	 * Column Info
	 * @return prefixNm
	 */
	public	String getPrefixNm() {
		return	this.prefixNm;
	}

	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public	String getPrcCgoTpCd() {
		return	this.prcCgoTpCd;
	}

	/**
	 * Column Info
	 * @return rate20
	 */
	public	String getRate20() {
		return	this.rate20;
	}

	/**
	 * Column Info
	 * @return rate40
	 */
	public	String getRate40() {
		return	this.rate40;
	}

	/**
	 * Column Info
	 * @return rate40hc
	 */
	public	String getRate40hc() {
		return	this.rate40hc;
	}

	/**
	 * Column Info
	 * @return rate45
	 */
	public	String getRate45() {
		return	this.rate45;
	}

	/**
	 * Column Info
	 * @return cnoteDesc
	 */
	public	String getCnoteDesc() {
		return	this.cnoteDesc;
	}

	/**
	 * Column Info
	 * @return rnoteDesc
	 */
	public	String getRnoteDesc() {
		return	this.rnoteDesc;
	}

	/**
	 * Column Info
	 * @return chkPrcCmdtDefCd
	 */
	public	String getChkPrcCmdtDefCd() {
		return	this.chkPrcCmdtDefCd;
	}

	/**
	 * Column Info
	 * @return chkCustSeq
	 */
	public	String getChkCustSeq() {
		return	this.chkCustSeq;
	}

	/**
	 * Column Info
	 * @return chkOrgRoutPntLocDefCd
	 */
	public	String getChkOrgRoutPntLocDefCd() {
		return	this.chkOrgRoutPntLocDefCd;
	}

	/**
	 * Column Info
	 * @return chkDestRoutPntLocDefCd
	 */
	public	String getChkDestRoutPntLocDefCd() {
		return	this.chkDestRoutPntLocDefCd;
	}

	/**
	 * Column Info
	 * @return chkOrgRoutViaPortDefCd
	 */
	public	String getChkOrgRoutViaPortDefCd() {
		return	this.chkOrgRoutViaPortDefCd;
	}

	/**
	 * Column Info
	 * @return chkDestRoutViaPortDefCd
	 */
	public	String getChkDestRoutViaPortDefCd() {
		return	this.chkDestRoutViaPortDefCd;
	}

	/**
	 * Column Info
	 * @return chkOrgRcvDeTermNm
	 */
	public	String getChkOrgRcvDeTermNm() {
		return	this.chkOrgRcvDeTermNm;
	}

	/**
	 * Column Info
	 * @return chkOrgPrcTrspModNm
	 */
	public	String getChkOrgPrcTrspModNm() {
		return	this.chkOrgPrcTrspModNm;
	}

	/**
	 * Column Info
	 * @return chkDestRcvDeTermNm
	 */
	public	String getChkDestRcvDeTermNm() {
		return	this.chkDestRcvDeTermNm;
	}

	/**
	 * Column Info
	 * @return chkDestPrcTrspModNm
	 */
	public	String getChkDestPrcTrspModNm() {
		return	this.chkDestPrcTrspModNm;
	}

	/**
	 * Column Info
	 * @return chkPrcCmdtDefDup
	 */
	public	String getChkPrcCmdtDefDup() {
		return	this.chkPrcCmdtDefDup;
	}

	/**
	 * Column Info
	 * @return chkOrgDestDup
	 */
	public	String getChkOrgDestDup() {
		return	this.chkOrgDestDup;
	}

	/**
	 * Column Info
	 * @return chkCmdtHdrSeq
	 */
	public	String getChkCmdtHdrSeq() {
		return	this.chkCmdtHdrSeq;
	}

	/**
	 * Column Info
	 * @return chkRoutSeq
	 */
	public	String getChkRoutSeq() {
		return	this.chkRoutSeq;
	}

	/**
	 * Column Info
	 * @return chkOrgSemi
	 */
	public	String getChkOrgSemi() {
		return	this.chkOrgSemi;
	}

	/**
	 * Column Info
	 * @return chkDestSemi
	 */
	public	String getChkDestSemi() {
		return	this.chkDestSemi;
	}

 	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
	public void	setIbflag(String ibflag ) {
		this.ibflag =	ibflag;
	}
 	/**
	 * Page Number
	 * @param  pagerows
 	 */
	public void	setPagerows(String pagerows ) {
		this.pagerows =	pagerows;
	}
 	/**
	 * Column Info
	 * @param  rowIdx
 	 */
	public void	setRowIdx(String rowIdx ) {
		this.rowIdx =	rowIdx;
	}
 	/**
	 * Column Info
	 * @param  propNo
 	 */
	public void	setPropNo(String propNo ) {
		this.propNo =	propNo;
	}
 	/**
	 * Column Info
	 * @param  amdtSeq
 	 */
	public void	setAmdtSeq(String amdtSeq ) {
		this.amdtSeq =	amdtSeq;
	}
 	/**
	 * Column Info
	 * @param  svcScpCd
 	 */
	public void	setSvcScpCd(String svcScpCd ) {
		this.svcScpCd =	svcScpCd;
	}
 	/**
	 * Column Info
	 * @param  type
 	 */
	public void	setType(String type ) {
		this.type =	type;
	}
 	/**
	 * Column Info
	 * @param  cmdtHdrSeq
 	 */
	public void	setCmdtHdrSeq(String cmdtHdrSeq ) {
		this.cmdtHdrSeq =	cmdtHdrSeq;
	}
 	/**
	 * Column Info
	 * @param  prcCmdtDefCd
 	 */
	public void	setPrcCmdtDefCd(String prcCmdtDefCd ) {
		this.prcCmdtDefCd =	prcCmdtDefCd;
	}
 	/**
	 * Column Info
	 * @param  prcCmdtDefNm
 	 */
	public void	setPrcCmdtDefNm(String prcCmdtDefNm ) {
		this.prcCmdtDefNm =	prcCmdtDefNm;
	}
 	/**
	 * Column Info
	 * @param  custSeq
 	 */
	public void	setCustSeq(String custSeq ) {
		this.custSeq =	custSeq;
	}
 	/**
	 * Column Info
	 * @param  custLglEngNm
 	 */
	public void	setCustLglEngNm(String custLglEngNm ) {
		this.custLglEngNm =	custLglEngNm;
	}
 	/**
	 * Column Info
	 * @param  routSeq
 	 */
	public void	setRoutSeq(String routSeq ) {
		this.routSeq =	routSeq;
	}
 	/**
	 * Column Info
	 * @param  orgRoutPntLocDefCd
 	 */
	public void	setOrgRoutPntLocDefCd(String orgRoutPntLocDefCd ) {
		this.orgRoutPntLocDefCd =	orgRoutPntLocDefCd;
	}
 	/**
	 * Column Info
	 * @param  orgRoutPntLocDefNm
 	 */
	public void	setOrgRoutPntLocDefNm(String orgRoutPntLocDefNm ) {
		this.orgRoutPntLocDefNm =	orgRoutPntLocDefNm;
	}
 	/**
	 * Column Info
	 * @param  orgRcvDeTermNm
 	 */
	public void	setOrgRcvDeTermNm(String orgRcvDeTermNm ) {
		this.orgRcvDeTermNm =	orgRcvDeTermNm;
	}
 	/**
	 * Column Info
	 * @param  orgPrcTrspModNm
 	 */
	public void	setOrgPrcTrspModNm(String orgPrcTrspModNm ) {
		this.orgPrcTrspModNm =	orgPrcTrspModNm;
	}
 	/**
	 * Column Info
	 * @param  orgRoutViaPortDefCd
 	 */
	public void	setOrgRoutViaPortDefCd(String orgRoutViaPortDefCd ) {
		this.orgRoutViaPortDefCd =	orgRoutViaPortDefCd;
	}
 	/**
	 * Column Info
	 * @param  destRoutViaPortDefCd
 	 */
	public void	setDestRoutViaPortDefCd(String destRoutViaPortDefCd ) {
		this.destRoutViaPortDefCd =	destRoutViaPortDefCd;
	}
 	/**
	 * Column Info
	 * @param  destRoutPntLocDefCd
 	 */
	public void	setDestRoutPntLocDefCd(String destRoutPntLocDefCd ) {
		this.destRoutPntLocDefCd =	destRoutPntLocDefCd;
	}
 	/**
	 * Column Info
	 * @param  destRoutPntLocDefNm
 	 */
	public void	setDestRoutPntLocDefNm(String destRoutPntLocDefNm ) {
		this.destRoutPntLocDefNm =	destRoutPntLocDefNm;
	}
 	/**
	 * Column Info
	 * @param  destRcvDeTermNm
 	 */
	public void	setDestRcvDeTermNm(String destRcvDeTermNm ) {
		this.destRcvDeTermNm =	destRcvDeTermNm;
	}
 	/**
	 * Column Info
	 * @param  destPrcTrspModNm
 	 */
	public void	setDestPrcTrspModNm(String destPrcTrspModNm ) {
		this.destPrcTrspModNm =	destPrcTrspModNm;
	}
 	/**
	 * Column Info
	 * @param  prefixNm
 	 */
	public void	setPrefixNm(String prefixNm ) {
		this.prefixNm =	prefixNm;
	}
 	/**
	 * Column Info
	 * @param  prcCgoTpCd
 	 */
	public void	setPrcCgoTpCd(String prcCgoTpCd ) {
		this.prcCgoTpCd =	prcCgoTpCd;
	}
 	/**
	 * Column Info
	 * @param  rate20
 	 */
	public void	setRate20(String rate20 ) {
		this.rate20 =	rate20;
	}
 	/**
	 * Column Info
	 * @param  rate40
 	 */
	public void	setRate40(String rate40 ) {
		this.rate40 =	rate40;
	}
 	/**
	 * Column Info
	 * @param  rate40hc
 	 */
	public void	setRate40hc(String rate40hc ) {
		this.rate40hc =	rate40hc;
	}
 	/**
	 * Column Info
	 * @param  rate45
 	 */
	public void	setRate45(String rate45 ) {
		this.rate45 =	rate45;
	}
 	/**
	 * Column Info
	 * @param  cnoteDesc
 	 */
	public void	setCnoteDesc(String cnoteDesc ) {
		this.cnoteDesc =	cnoteDesc;
	}
 	/**
	 * Column Info
	 * @param  rnoteDesc
 	 */
	public void	setRnoteDesc(String rnoteDesc ) {
		this.rnoteDesc =	rnoteDesc;
	}
 	/**
	 * Column Info
	 * @param  chkPrcCmdtDefCd
 	 */
	public void	setChkPrcCmdtDefCd(String chkPrcCmdtDefCd ) {
		this.chkPrcCmdtDefCd =	chkPrcCmdtDefCd;
	}
 	/**
	 * Column Info
	 * @param  chkCustSeq
 	 */
	public void	setChkCustSeq(String chkCustSeq ) {
		this.chkCustSeq =	chkCustSeq;
	}
 	/**
	 * Column Info
	 * @param  chkOrgRoutPntLocDefCd
 	 */
	public void	setChkOrgRoutPntLocDefCd(String chkOrgRoutPntLocDefCd ) {
		this.chkOrgRoutPntLocDefCd =	chkOrgRoutPntLocDefCd;
	}
 	/**
	 * Column Info
	 * @param  chkDestRoutPntLocDefCd
 	 */
	public void	setChkDestRoutPntLocDefCd(String chkDestRoutPntLocDefCd ) {
		this.chkDestRoutPntLocDefCd =	chkDestRoutPntLocDefCd;
	}
 	/**
	 * Column Info
	 * @param  chkOrgRoutViaPortDefCd
 	 */
	public void	setChkOrgRoutViaPortDefCd(String chkOrgRoutViaPortDefCd ) {
		this.chkOrgRoutViaPortDefCd =	chkOrgRoutViaPortDefCd;
	}
 	/**
	 * Column Info
	 * @param  chkDestRoutViaPortDefCd
 	 */
	public void	setChkDestRoutViaPortDefCd(String chkDestRoutViaPortDefCd ) {
		this.chkDestRoutViaPortDefCd =	chkDestRoutViaPortDefCd;
	}
 	/**
	 * Column Info
	 * @param  chkOrgRcvDeTermNm
 	 */
	public void	setChkOrgRcvDeTermNm(String chkOrgRcvDeTermNm ) {
		this.chkOrgRcvDeTermNm =	chkOrgRcvDeTermNm;
	}
 	/**
	 * Column Info
	 * @param  chkOrgPrcTrspModNm
 	 */
	public void	setChkOrgPrcTrspModNm(String chkOrgPrcTrspModNm ) {
		this.chkOrgPrcTrspModNm =	chkOrgPrcTrspModNm;
	}
 	/**
	 * Column Info
	 * @param  chkDestRcvDeTermNm
 	 */
	public void	setChkDestRcvDeTermNm(String chkDestRcvDeTermNm ) {
		this.chkDestRcvDeTermNm =	chkDestRcvDeTermNm;
	}
 	/**
	 * Column Info
	 * @param  chkDestPrcTrspModNm
 	 */
	public void	setChkDestPrcTrspModNm(String chkDestPrcTrspModNm ) {
		this.chkDestPrcTrspModNm =	chkDestPrcTrspModNm;
	}
 	/**
	 * Column Info
	 * @param  chkPrcCmdtDefDup
 	 */
	public void	setChkPrcCmdtDefDup(String chkPrcCmdtDefDup ) {
		this.chkPrcCmdtDefDup =	chkPrcCmdtDefDup;
	}
 	/**
	 * Column Info
	 * @param  chkOrgDestDup
 	 */
	public void	setChkOrgDestDup(String chkOrgDestDup ) {
		this.chkOrgDestDup =	chkOrgDestDup;
	}
 	/**
	 * Column Info
	 * @param  chkCmdtHdrSeq
 	 */
	public void	setChkCmdtHdrSeq(String chkCmdtHdrSeq ) {
		this.chkCmdtHdrSeq =	chkCmdtHdrSeq;
	}
 	/**
	 * Column Info
	 * @param  chkRoutSeq
 	 */
	public void	setChkRoutSeq(String chkRoutSeq ) {
		this.chkRoutSeq =	chkRoutSeq;
	}
 	/**
	 * Column Info
	 * @param  chkOrgSemi
 	 */
	public void	setChkOrgSemi(String chkOrgSemi ) {
		this.chkOrgSemi =	chkOrgSemi;
	}
 	/**
	 * Column Info
	 * @param  chkDestSemi
 	 */
	public void	setChkDestSemi(String chkDestSemi ) {
		this.chkDestSemi =	chkDestSemi;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setRowIdx(JSPUtil.getParameter(request,	prefix + "row_idx", ""));
		setPropNo(JSPUtil.getParameter(request,	prefix + "prop_no", ""));
		setAmdtSeq(JSPUtil.getParameter(request,	prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setType(JSPUtil.getParameter(request,	prefix + "type", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request,	prefix + "cmdt_hdr_seq", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request,	prefix + "prc_cmdt_def_cd", ""));
		setPrcCmdtDefNm(JSPUtil.getParameter(request,	prefix + "prc_cmdt_def_nm", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setCustLglEngNm(JSPUtil.getParameter(request,	prefix + "cust_lgl_eng_nm", ""));
		setRoutSeq(JSPUtil.getParameter(request,	prefix + "rout_seq", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request,	prefix + "org_rout_pnt_loc_def_cd", ""));
		setOrgRoutPntLocDefNm(JSPUtil.getParameter(request,	prefix + "org_rout_pnt_loc_def_nm", ""));
		setOrgRcvDeTermNm(JSPUtil.getParameter(request,	prefix + "org_rcv_de_term_nm", ""));
		setOrgPrcTrspModNm(JSPUtil.getParameter(request,	prefix + "org_prc_trsp_mod_nm", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request,	prefix + "org_rout_via_port_def_cd", ""));
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request,	prefix + "dest_rout_via_port_def_cd", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request,	prefix + "dest_rout_pnt_loc_def_cd", ""));
		setDestRoutPntLocDefNm(JSPUtil.getParameter(request,	prefix + "dest_rout_pnt_loc_def_nm", ""));
		setDestRcvDeTermNm(JSPUtil.getParameter(request,	prefix + "dest_rcv_de_term_nm", ""));
		setDestPrcTrspModNm(JSPUtil.getParameter(request,	prefix + "dest_prc_trsp_mod_nm", ""));
		setPrefixNm(JSPUtil.getParameter(request,	prefix + "prefix_nm", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request,	prefix + "prc_cgo_tp_cd", ""));
		setRate20(JSPUtil.getParameter(request,	prefix + "rate_20", ""));
		setRate40(JSPUtil.getParameter(request,	prefix + "rate_40", ""));
		setRate40hc(JSPUtil.getParameter(request,	prefix + "rate_40hc", ""));
		setRate45(JSPUtil.getParameter(request,	prefix + "rate_45", ""));
		setCnoteDesc(JSPUtil.getParameter(request,	prefix + "cnote_desc", ""));
		setRnoteDesc(JSPUtil.getParameter(request,	prefix + "rnote_desc", ""));
		setChkPrcCmdtDefCd(JSPUtil.getParameter(request,	prefix + "chk_prc_cmdt_def_cd", ""));
		setChkCustSeq(JSPUtil.getParameter(request,	prefix + "chk_cust_seq", ""));
		setChkOrgRoutPntLocDefCd(JSPUtil.getParameter(request,	prefix + "chk_org_rout_pnt_loc_def_cd", ""));
		setChkDestRoutPntLocDefCd(JSPUtil.getParameter(request,	prefix + "chk_dest_rout_pnt_loc_def_cd", ""));
		setChkOrgRoutViaPortDefCd(JSPUtil.getParameter(request,	prefix + "chk_org_rout_via_port_def_cd", ""));
		setChkDestRoutViaPortDefCd(JSPUtil.getParameter(request,	prefix + "chk_dest_rout_via_port_def_cd", ""));
		setChkOrgRcvDeTermNm(JSPUtil.getParameter(request,	prefix + "chk_org_rcv_de_term_nm", ""));
		setChkOrgPrcTrspModNm(JSPUtil.getParameter(request,	prefix + "chk_org_prc_trsp_mod_nm", ""));
		setChkDestRcvDeTermNm(JSPUtil.getParameter(request,	prefix + "chk_dest_rcv_de_term_nm", ""));
		setChkDestPrcTrspModNm(JSPUtil.getParameter(request,	prefix + "chk_dest_prc_trsp_mod_nm", ""));
		setChkPrcCmdtDefDup(JSPUtil.getParameter(request,	prefix + "chk_prc_cmdt_def_dup", ""));
		setChkOrgDestDup(JSPUtil.getParameter(request,	prefix + "chk_org_dest_dup", ""));
		setChkCmdtHdrSeq(JSPUtil.getParameter(request,	prefix + "chk_cmdt_hdr_seq", ""));
		setChkRoutSeq(JSPUtil.getParameter(request,	prefix + "chk_rout_seq", ""));
		setChkOrgSemi(JSPUtil.getParameter(request,	prefix + "chk_org_semi", ""));
		setChkDestSemi(JSPUtil.getParameter(request,	prefix + "chk_dest_semi", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRtListHorizontalExcelVO[]
	 */
	public RsltRtListHorizontalExcelVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return RsltRtListHorizontalExcelVO[]
	 */
	public RsltRtListHorizontalExcelVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		RsltRtListHorizontalExcelVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] rowIdx =	(JSPUtil.getParameter(request, prefix +	"row_idx",	length));
			String[] propNo =	(JSPUtil.getParameter(request, prefix +	"prop_no",	length));
			String[] amdtSeq =	(JSPUtil.getParameter(request, prefix +	"amdt_seq",	length));
			String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd",	length));
			String[] type =	(JSPUtil.getParameter(request, prefix +	"type",	length));
			String[] cmdtHdrSeq =	(JSPUtil.getParameter(request, prefix +	"cmdt_hdr_seq",	length));
			String[] prcCmdtDefCd =	(JSPUtil.getParameter(request, prefix +	"prc_cmdt_def_cd",	length));
			String[] prcCmdtDefNm =	(JSPUtil.getParameter(request, prefix +	"prc_cmdt_def_nm",	length));
			String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq",	length));
			String[] custLglEngNm =	(JSPUtil.getParameter(request, prefix +	"cust_lgl_eng_nm",	length));
			String[] routSeq =	(JSPUtil.getParameter(request, prefix +	"rout_seq",	length));
			String[] orgRoutPntLocDefCd =	(JSPUtil.getParameter(request, prefix +	"org_rout_pnt_loc_def_cd",	length));
			String[] orgRoutPntLocDefNm =	(JSPUtil.getParameter(request, prefix +	"org_rout_pnt_loc_def_nm",	length));
			String[] orgRcvDeTermNm =	(JSPUtil.getParameter(request, prefix +	"org_rcv_de_term_nm",	length));
			String[] orgPrcTrspModNm =	(JSPUtil.getParameter(request, prefix +	"org_prc_trsp_mod_nm",	length));
			String[] orgRoutViaPortDefCd =	(JSPUtil.getParameter(request, prefix +	"org_rout_via_port_def_cd",	length));
			String[] destRoutViaPortDefCd =	(JSPUtil.getParameter(request, prefix +	"dest_rout_via_port_def_cd",	length));
			String[] destRoutPntLocDefCd =	(JSPUtil.getParameter(request, prefix +	"dest_rout_pnt_loc_def_cd",	length));
			String[] destRoutPntLocDefNm =	(JSPUtil.getParameter(request, prefix +	"dest_rout_pnt_loc_def_nm",	length));
			String[] destRcvDeTermNm =	(JSPUtil.getParameter(request, prefix +	"dest_rcv_de_term_nm",	length));
			String[] destPrcTrspModNm =	(JSPUtil.getParameter(request, prefix +	"dest_prc_trsp_mod_nm",	length));
			String[] prefixNm =	(JSPUtil.getParameter(request, prefix +	"prefix_nm",	length));
			String[] prcCgoTpCd =	(JSPUtil.getParameter(request, prefix +	"prc_cgo_tp_cd",	length));
			String[] rate20 =	(JSPUtil.getParameter(request, prefix +	"rate_20",	length));
			String[] rate40 =	(JSPUtil.getParameter(request, prefix +	"rate_40",	length));
			String[] rate40hc =	(JSPUtil.getParameter(request, prefix +	"rate_40hc",	length));
			String[] rate45 =	(JSPUtil.getParameter(request, prefix +	"rate_45",	length));
			String[] cnoteDesc =	(JSPUtil.getParameter(request, prefix +	"cnote_desc",	length));
			String[] rnoteDesc =	(JSPUtil.getParameter(request, prefix +	"rnote_desc",	length));
			String[] chkPrcCmdtDefCd =	(JSPUtil.getParameter(request, prefix +	"chk_prc_cmdt_def_cd",	length));
			String[] chkCustSeq =	(JSPUtil.getParameter(request, prefix +	"chk_cust_seq",	length));
			String[] chkOrgRoutPntLocDefCd =	(JSPUtil.getParameter(request, prefix +	"chk_org_rout_pnt_loc_def_cd",	length));
			String[] chkDestRoutPntLocDefCd =	(JSPUtil.getParameter(request, prefix +	"chk_dest_rout_pnt_loc_def_cd",	length));
			String[] chkOrgRoutViaPortDefCd =	(JSPUtil.getParameter(request, prefix +	"chk_org_rout_via_port_def_cd",	length));
			String[] chkDestRoutViaPortDefCd =	(JSPUtil.getParameter(request, prefix +	"chk_dest_rout_via_port_def_cd",	length));
			String[] chkOrgRcvDeTermNm =	(JSPUtil.getParameter(request, prefix +	"chk_org_rcv_de_term_nm",	length));
			String[] chkOrgPrcTrspModNm =	(JSPUtil.getParameter(request, prefix +	"chk_org_prc_trsp_mod_nm",	length));
			String[] chkDestRcvDeTermNm =	(JSPUtil.getParameter(request, prefix +	"chk_dest_rcv_de_term_nm",	length));
			String[] chkDestPrcTrspModNm =	(JSPUtil.getParameter(request, prefix +	"chk_dest_prc_trsp_mod_nm",	length));
			String[] chkPrcCmdtDefDup =	(JSPUtil.getParameter(request, prefix +	"chk_prc_cmdt_def_dup",	length));
			String[] chkOrgDestDup =	(JSPUtil.getParameter(request, prefix +	"chk_org_dest_dup",	length));
			String[] chkCmdtHdrSeq =	(JSPUtil.getParameter(request, prefix +	"chk_cmdt_hdr_seq",	length));
			String[] chkRoutSeq =	(JSPUtil.getParameter(request, prefix +	"chk_rout_seq",	length));
			String[] chkOrgSemi =	(JSPUtil.getParameter(request, prefix +	"chk_org_semi",	length));
			String[] chkDestSemi =	(JSPUtil.getParameter(request, prefix +	"chk_dest_semi",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	RsltRtListHorizontalExcelVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( rowIdx[i] !=	null)
					model.setRowIdx( rowIdx[i]);
				if ( propNo[i] !=	null)
					model.setPropNo( propNo[i]);
				if ( amdtSeq[i] !=	null)
					model.setAmdtSeq( amdtSeq[i]);
				if ( svcScpCd[i] !=	null)
					model.setSvcScpCd( svcScpCd[i]);
				if ( type[i] !=	null)
					model.setType( type[i]);
				if ( cmdtHdrSeq[i] !=	null)
					model.setCmdtHdrSeq( cmdtHdrSeq[i]);
				if ( prcCmdtDefCd[i] !=	null)
					model.setPrcCmdtDefCd( prcCmdtDefCd[i]);
				if ( prcCmdtDefNm[i] !=	null)
					model.setPrcCmdtDefNm( prcCmdtDefNm[i]);
				if ( custSeq[i] !=	null)
					model.setCustSeq( custSeq[i]);
				if ( custLglEngNm[i] !=	null)
					model.setCustLglEngNm( custLglEngNm[i]);
				if ( routSeq[i] !=	null)
					model.setRoutSeq( routSeq[i]);
				if ( orgRoutPntLocDefCd[i] !=	null)
					model.setOrgRoutPntLocDefCd( orgRoutPntLocDefCd[i]);
				if ( orgRoutPntLocDefNm[i] !=	null)
					model.setOrgRoutPntLocDefNm( orgRoutPntLocDefNm[i]);
				if ( orgRcvDeTermNm[i] !=	null)
					model.setOrgRcvDeTermNm( orgRcvDeTermNm[i]);
				if ( orgPrcTrspModNm[i] !=	null)
					model.setOrgPrcTrspModNm( orgPrcTrspModNm[i]);
				if ( orgRoutViaPortDefCd[i] !=	null)
					model.setOrgRoutViaPortDefCd( orgRoutViaPortDefCd[i]);
				if ( destRoutViaPortDefCd[i] !=	null)
					model.setDestRoutViaPortDefCd( destRoutViaPortDefCd[i]);
				if ( destRoutPntLocDefCd[i] !=	null)
					model.setDestRoutPntLocDefCd( destRoutPntLocDefCd[i]);
				if ( destRoutPntLocDefNm[i] !=	null)
					model.setDestRoutPntLocDefNm( destRoutPntLocDefNm[i]);
				if ( destRcvDeTermNm[i] !=	null)
					model.setDestRcvDeTermNm( destRcvDeTermNm[i]);
				if ( destPrcTrspModNm[i] !=	null)
					model.setDestPrcTrspModNm( destPrcTrspModNm[i]);
				if ( prefixNm[i] !=	null)
					model.setPrefixNm( prefixNm[i]);
				if ( prcCgoTpCd[i] !=	null)
					model.setPrcCgoTpCd( prcCgoTpCd[i]);
				if ( rate20[i] !=	null)
					model.setRate20( rate20[i]);
				if ( rate40[i] !=	null)
					model.setRate40( rate40[i]);
				if ( rate40hc[i] !=	null)
					model.setRate40hc( rate40hc[i]);
				if ( rate45[i] !=	null)
					model.setRate45( rate45[i]);
				if ( cnoteDesc[i] !=	null)
					model.setCnoteDesc( cnoteDesc[i]);
				if ( rnoteDesc[i] !=	null)
					model.setRnoteDesc( rnoteDesc[i]);
				if ( chkPrcCmdtDefCd[i] !=	null)
					model.setChkPrcCmdtDefCd( chkPrcCmdtDefCd[i]);
				if ( chkCustSeq[i] !=	null)
					model.setChkCustSeq( chkCustSeq[i]);
				if ( chkOrgRoutPntLocDefCd[i] !=	null)
					model.setChkOrgRoutPntLocDefCd( chkOrgRoutPntLocDefCd[i]);
				if ( chkDestRoutPntLocDefCd[i] !=	null)
					model.setChkDestRoutPntLocDefCd( chkDestRoutPntLocDefCd[i]);
				if ( chkOrgRoutViaPortDefCd[i] !=	null)
					model.setChkOrgRoutViaPortDefCd( chkOrgRoutViaPortDefCd[i]);
				if ( chkDestRoutViaPortDefCd[i] !=	null)
					model.setChkDestRoutViaPortDefCd( chkDestRoutViaPortDefCd[i]);
				if ( chkOrgRcvDeTermNm[i] !=	null)
					model.setChkOrgRcvDeTermNm( chkOrgRcvDeTermNm[i]);
				if ( chkOrgPrcTrspModNm[i] !=	null)
					model.setChkOrgPrcTrspModNm( chkOrgPrcTrspModNm[i]);
				if ( chkDestRcvDeTermNm[i] !=	null)
					model.setChkDestRcvDeTermNm( chkDestRcvDeTermNm[i]);
				if ( chkDestPrcTrspModNm[i] !=	null)
					model.setChkDestPrcTrspModNm( chkDestPrcTrspModNm[i]);
				if ( chkPrcCmdtDefDup[i] !=	null)
					model.setChkPrcCmdtDefDup( chkPrcCmdtDefDup[i]);
				if ( chkOrgDestDup[i] !=	null)
					model.setChkOrgDestDup( chkOrgDestDup[i]);
				if ( chkCmdtHdrSeq[i] !=	null)
					model.setChkCmdtHdrSeq( chkCmdtHdrSeq[i]);
				if ( chkRoutSeq[i] !=	null)
					model.setChkRoutSeq( chkRoutSeq[i]);
				if ( chkOrgSemi[i] !=	null)
					model.setChkOrgSemi( chkOrgSemi[i]);
				if ( chkDestSemi[i] !=	null)
					model.setChkDestSemi( chkDestSemi[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getRsltRtListHorizontalExcelVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return RsltRtListHorizontalExcelVO[]
	 */
	public RsltRtListHorizontalExcelVO[]	 getRsltRtListHorizontalExcelVOs(){
		RsltRtListHorizontalExcelVO[] vos = (RsltRtListHorizontalExcelVO[])models.toArray(new	RsltRtListHorizontalExcelVO[models.size()]);
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
	public void	unDataFormat(){
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowIdx =	this.rowIdx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo =	this.propNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq =	this.amdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type =	this.type.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq =	this.cmdtHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd =	this.prcCmdtDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefNm =	this.prcCmdtDefNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm =	this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq =	this.routSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd =	this.orgRoutPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefNm =	this.orgRoutPntLocDefNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRcvDeTermNm =	this.orgRcvDeTermNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPrcTrspModNm =	this.orgPrcTrspModNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd =	this.orgRoutViaPortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefCd =	this.destRoutViaPortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd =	this.destRoutPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefNm =	this.destRoutPntLocDefNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRcvDeTermNm =	this.destRcvDeTermNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destPrcTrspModNm =	this.destPrcTrspModNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prefixNm =	this.prefixNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd =	this.prcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate20 =	this.rate20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate40 =	this.rate40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate40hc =	this.rate40hc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate45 =	this.rate45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnoteDesc =	this.cnoteDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnoteDesc =	this.rnoteDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPrcCmdtDefCd =	this.chkPrcCmdtDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCustSeq =	this.chkCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOrgRoutPntLocDefCd =	this.chkOrgRoutPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDestRoutPntLocDefCd =	this.chkDestRoutPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOrgRoutViaPortDefCd =	this.chkOrgRoutViaPortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDestRoutViaPortDefCd =	this.chkDestRoutViaPortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOrgRcvDeTermNm =	this.chkOrgRcvDeTermNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOrgPrcTrspModNm =	this.chkOrgPrcTrspModNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDestRcvDeTermNm =	this.chkDestRcvDeTermNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDestPrcTrspModNm =	this.chkDestPrcTrspModNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPrcCmdtDefDup =	this.chkPrcCmdtDefDup.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOrgDestDup =	this.chkOrgDestDup.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCmdtHdrSeq =	this.chkCmdtHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkRoutSeq =	this.chkRoutSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOrgSemi =	this.chkOrgSemi.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDestSemi =	this.chkDestSemi.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}