/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : RsltPriRpScpTrspAddChgVO.java
 *@FileTitle : RsltPriRpScpTrspAddChgVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.03.17
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2016.03.17 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo;

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
public class RsltPriRpScpTrspAddChgVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<RsltPriRpScpTrspAddChgVO>  models =	new	ArrayList<RsltPriRpScpTrspAddChgVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String addChgSeq = null;
	/*	Column Info	*/
	private String currCd = null;
	/*	Column Info	*/
	private String prcCgoTpCd = null;
	/*	Column Info	*/
	private String griApplAmt = null;
	/*	Column Info	*/
	private String amdtSeq = null;
	/*	Column Info	*/
	private String svcScpCd = null;
	/*	Column Info	*/
	private String routPntLocDefCd = null;
	/*	Column Info	*/
	private String coffrFrtRtAmt = null;
	/*	Column Info	*/
	private String noteDpSeq = null;
	/*	Column Info	*/
	private String fnlFrtRtAmt = null;
	/*	Column Info	*/
	private String prcProgStsCd = null;
	/*	Column Info	*/
	private String bsePortTpCd = null;
	/*	Column Info	*/
	private String addChgNoteCtnt = null;
	/*	Column Info	*/
	private String rcvDeTermCd = null;
	/*	Column Info	*/
	private String maxCgoWgt = null;
	/*	Column Info	*/
	private String custCntCd = null;
	/*	Column Info	*/
	private String routPntLocTpCd = null;
	/*	Column Info	*/
	private String addChgTpCd = null;
	/*	Column Info	*/
	private String griApplTpCd = null;
	/*	Column Info	*/
	private String srcInfoCd = null;
	/*	Column Info	*/
	private String orgDestTpCd = null;
	/*	Column Info	*/
	private String custDefCd = null;
	/*	Column Info	*/
	private String ratUtCd = null;
	/*	Column Info	*/
	private String propFrtRtAmt = null;
	/*	Column Info	*/
	private String custSeq = null;
	/*	Column Info	*/
	private String bsePortDefCd = null;
	/*	Column Info	*/
	private String propNo = null;
	/*	Column Info	*/
	private String minCgoWgt = null;
	/*	Column Info	*/
	private String routPntLocDefDesc = null;
	/*	Column Info	*/
	private String prcTrspModCd = null;
	/*	Column Info	*/
	private String n1stCmncDt = null;
	/*	Column Info	*/
	private String totErrCnt = null;
	/*	Column Info	*/
	private String chkLenRoutPntLocDefCd = null;
	/*	Column Info	*/
	private String chkLenBsePortDefCd = null;
	/*	Column Info	*/
	private String chkRcvDeTermCd = null;
	/*	Column Info	*/
	private String chkRatUtCd = null;
	/*	Column Info	*/
	private String chkCurrCd = null;
	/*	Column Info	*/
	private String chkMinCgoWgt = null;
	/*	Column Info	*/
	private String chkMaxCgoWgt = null;
	/*	Column Info	*/
	private String chkPropFrtRtAmt = null;
	/*	Column Info	*/
	private String chkTermPntPort = null;
	/*	Column Info	*/
	private String ukey = null;
	/*	Column Info	*/
	private String dupCnt = null;
	/*	Column Info	*/
	private String chkRoutPntLocDefCd = null;
	/*	Column Info	*/
	private String chkBsePortDefCd = null;
	/*	Column Info	*/
	private String rowErrCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public RsltPriRpScpTrspAddChgVO(){}

	public RsltPriRpScpTrspAddChgVO(String ibflag,String pagerows,String addChgSeq,String currCd,String prcCgoTpCd,String griApplAmt,String amdtSeq,String svcScpCd,String routPntLocDefCd,String coffrFrtRtAmt,String noteDpSeq,String fnlFrtRtAmt,String prcProgStsCd,String bsePortTpCd,String addChgNoteCtnt,String rcvDeTermCd,String maxCgoWgt,String custCntCd,String routPntLocTpCd,String addChgTpCd,String griApplTpCd,String srcInfoCd,String orgDestTpCd,String custDefCd,String ratUtCd,String propFrtRtAmt,String custSeq,String bsePortDefCd,String propNo,String minCgoWgt,String routPntLocDefDesc,String prcTrspModCd,String n1stCmncDt,String totErrCnt,String chkLenRoutPntLocDefCd,String chkLenBsePortDefCd,String chkRcvDeTermCd,String chkRatUtCd,String chkCurrCd,String chkMinCgoWgt,String chkMaxCgoWgt,String chkPropFrtRtAmt,String chkTermPntPort,String ukey,String dupCnt,String chkRoutPntLocDefCd,String chkBsePortDefCd,String rowErrCnt)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.addChgSeq = addChgSeq;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.griApplAmt = griApplAmt;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.routPntLocDefCd = routPntLocDefCd;
		this.coffrFrtRtAmt = coffrFrtRtAmt;
		this.noteDpSeq = noteDpSeq;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.prcProgStsCd = prcProgStsCd;
		this.bsePortTpCd = bsePortTpCd;
		this.addChgNoteCtnt = addChgNoteCtnt;
		this.rcvDeTermCd = rcvDeTermCd;
		this.maxCgoWgt = maxCgoWgt;
		this.custCntCd = custCntCd;
		this.routPntLocTpCd = routPntLocTpCd;
		this.addChgTpCd = addChgTpCd;
		this.griApplTpCd = griApplTpCd;
		this.srcInfoCd = srcInfoCd;
		this.orgDestTpCd = orgDestTpCd;
		this.custDefCd = custDefCd;
		this.ratUtCd = ratUtCd;
		this.propFrtRtAmt = propFrtRtAmt;
		this.custSeq = custSeq;
		this.bsePortDefCd = bsePortDefCd;
		this.propNo = propNo;
		this.minCgoWgt = minCgoWgt;
		this.routPntLocDefDesc = routPntLocDefDesc;
		this.prcTrspModCd = prcTrspModCd;
		this.n1stCmncDt = n1stCmncDt;
		this.totErrCnt = totErrCnt;
		this.chkLenRoutPntLocDefCd = chkLenRoutPntLocDefCd;
		this.chkLenBsePortDefCd = chkLenBsePortDefCd;
		this.chkRcvDeTermCd = chkRcvDeTermCd;
		this.chkRatUtCd = chkRatUtCd;
		this.chkCurrCd = chkCurrCd;
		this.chkMinCgoWgt = chkMinCgoWgt;
		this.chkMaxCgoWgt = chkMaxCgoWgt;
		this.chkPropFrtRtAmt = chkPropFrtRtAmt;
		this.chkTermPntPort = chkTermPntPort;
		this.ukey = ukey;
		this.dupCnt = dupCnt;
		this.chkRoutPntLocDefCd = chkRoutPntLocDefCd;
		this.chkBsePortDefCd = chkBsePortDefCd;
		this.rowErrCnt = rowErrCnt;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("add_chg_seq", getAddChgSeq());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("gri_appl_amt", getGriApplAmt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rout_pnt_loc_def_cd", getRoutPntLocDefCd());
		this.hashColumns.put("coffr_frt_rt_amt", getCoffrFrtRtAmt());
		this.hashColumns.put("note_dp_seq", getNoteDpSeq());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("prc_prog_sts_cd", getPrcProgStsCd());
		this.hashColumns.put("bse_port_tp_cd", getBsePortTpCd());
		this.hashColumns.put("add_chg_note_ctnt", getAddChgNoteCtnt());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("max_cgo_wgt", getMaxCgoWgt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("rout_pnt_loc_tp_cd", getRoutPntLocTpCd());
		this.hashColumns.put("add_chg_tp_cd", getAddChgTpCd());
		this.hashColumns.put("gri_appl_tp_cd", getGriApplTpCd());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("cust_def_cd", getCustDefCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("prop_frt_rt_amt", getPropFrtRtAmt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bse_port_def_cd", getBsePortDefCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("min_cgo_wgt", getMinCgoWgt());
		this.hashColumns.put("rout_pnt_loc_def_desc", getRoutPntLocDefDesc());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("n1st_cmnc_dt", getN1stCmncDt());
		this.hashColumns.put("tot_err_cnt", getTotErrCnt());
		this.hashColumns.put("chk_len_rout_pnt_loc_def_cd", getChkLenRoutPntLocDefCd());
		this.hashColumns.put("chk_len_bse_port_def_cd", getChkLenBsePortDefCd());
		this.hashColumns.put("chk_rcv_de_term_cd", getChkRcvDeTermCd());
		this.hashColumns.put("chk_rat_ut_cd", getChkRatUtCd());
		this.hashColumns.put("chk_curr_cd", getChkCurrCd());
		this.hashColumns.put("chk_min_cgo_wgt", getChkMinCgoWgt());
		this.hashColumns.put("chk_max_cgo_wgt", getChkMaxCgoWgt());
		this.hashColumns.put("chk_prop_frt_rt_amt", getChkPropFrtRtAmt());
		this.hashColumns.put("chk_term_pnt_port", getChkTermPntPort());
		this.hashColumns.put("ukey", getUkey());
		this.hashColumns.put("dup_cnt", getDupCnt());
		this.hashColumns.put("chk_rout_pnt_loc_def_cd", getChkRoutPntLocDefCd());
		this.hashColumns.put("chk_bse_port_def_cd", getChkBsePortDefCd());
		this.hashColumns.put("row_err_cnt", getRowErrCnt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("add_chg_seq", "addChgSeq");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("gri_appl_amt", "griApplAmt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rout_pnt_loc_def_cd", "routPntLocDefCd");
		this.hashFields.put("coffr_frt_rt_amt", "coffrFrtRtAmt");
		this.hashFields.put("note_dp_seq", "noteDpSeq");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("prc_prog_sts_cd", "prcProgStsCd");
		this.hashFields.put("bse_port_tp_cd", "bsePortTpCd");
		this.hashFields.put("add_chg_note_ctnt", "addChgNoteCtnt");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("max_cgo_wgt", "maxCgoWgt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("rout_pnt_loc_tp_cd", "routPntLocTpCd");
		this.hashFields.put("add_chg_tp_cd", "addChgTpCd");
		this.hashFields.put("gri_appl_tp_cd", "griApplTpCd");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("cust_def_cd", "custDefCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("prop_frt_rt_amt", "propFrtRtAmt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bse_port_def_cd", "bsePortDefCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("min_cgo_wgt", "minCgoWgt");
		this.hashFields.put("rout_pnt_loc_def_desc", "routPntLocDefDesc");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("n1st_cmnc_dt", "n1stCmncDt");
		this.hashFields.put("tot_err_cnt", "totErrCnt");
		this.hashFields.put("chk_len_rout_pnt_loc_def_cd", "chkLenRoutPntLocDefCd");
		this.hashFields.put("chk_len_bse_port_def_cd", "chkLenBsePortDefCd");
		this.hashFields.put("chk_rcv_de_term_cd", "chkRcvDeTermCd");
		this.hashFields.put("chk_rat_ut_cd", "chkRatUtCd");
		this.hashFields.put("chk_curr_cd", "chkCurrCd");
		this.hashFields.put("chk_min_cgo_wgt", "chkMinCgoWgt");
		this.hashFields.put("chk_max_cgo_wgt", "chkMaxCgoWgt");
		this.hashFields.put("chk_prop_frt_rt_amt", "chkPropFrtRtAmt");
		this.hashFields.put("chk_term_pnt_port", "chkTermPntPort");
		this.hashFields.put("ukey", "ukey");
		this.hashFields.put("dup_cnt", "dupCnt");
		this.hashFields.put("chk_rout_pnt_loc_def_cd", "chkRoutPntLocDefCd");
		this.hashFields.put("chk_bse_port_def_cd", "chkBsePortDefCd");
		this.hashFields.put("row_err_cnt", "rowErrCnt");
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
	 * @return addChgSeq
	 */
	public	String getAddChgSeq() {
		return	this.addChgSeq;
	}

	/**
	 * Column Info
	 * @return currCd
	 */
	public	String getCurrCd() {
		return	this.currCd;
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
	 * @return griApplAmt
	 */
	public	String getGriApplAmt() {
		return	this.griApplAmt;
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
	 * @return routPntLocDefCd
	 */
	public	String getRoutPntLocDefCd() {
		return	this.routPntLocDefCd;
	}

	/**
	 * Column Info
	 * @return coffrFrtRtAmt
	 */
	public	String getCoffrFrtRtAmt() {
		return	this.coffrFrtRtAmt;
	}

	/**
	 * Column Info
	 * @return noteDpSeq
	 */
	public	String getNoteDpSeq() {
		return	this.noteDpSeq;
	}

	/**
	 * Column Info
	 * @return fnlFrtRtAmt
	 */
	public	String getFnlFrtRtAmt() {
		return	this.fnlFrtRtAmt;
	}

	/**
	 * Column Info
	 * @return prcProgStsCd
	 */
	public	String getPrcProgStsCd() {
		return	this.prcProgStsCd;
	}

	/**
	 * Column Info
	 * @return bsePortTpCd
	 */
	public	String getBsePortTpCd() {
		return	this.bsePortTpCd;
	}

	/**
	 * Column Info
	 * @return addChgNoteCtnt
	 */
	public	String getAddChgNoteCtnt() {
		return	this.addChgNoteCtnt;
	}

	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public	String getRcvDeTermCd() {
		return	this.rcvDeTermCd;
	}

	/**
	 * Column Info
	 * @return maxCgoWgt
	 */
	public	String getMaxCgoWgt() {
		return	this.maxCgoWgt;
	}

	/**
	 * Column Info
	 * @return custCntCd
	 */
	public	String getCustCntCd() {
		return	this.custCntCd;
	}

	/**
	 * Column Info
	 * @return routPntLocTpCd
	 */
	public	String getRoutPntLocTpCd() {
		return	this.routPntLocTpCd;
	}

	/**
	 * Column Info
	 * @return addChgTpCd
	 */
	public	String getAddChgTpCd() {
		return	this.addChgTpCd;
	}

	/**
	 * Column Info
	 * @return griApplTpCd
	 */
	public	String getGriApplTpCd() {
		return	this.griApplTpCd;
	}

	/**
	 * Column Info
	 * @return srcInfoCd
	 */
	public	String getSrcInfoCd() {
		return	this.srcInfoCd;
	}

	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public	String getOrgDestTpCd() {
		return	this.orgDestTpCd;
	}

	/**
	 * Column Info
	 * @return custDefCd
	 */
	public	String getCustDefCd() {
		return	this.custDefCd;
	}

	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public	String getRatUtCd() {
		return	this.ratUtCd;
	}

	/**
	 * Column Info
	 * @return propFrtRtAmt
	 */
	public	String getPropFrtRtAmt() {
		return	this.propFrtRtAmt;
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
	 * @return bsePortDefCd
	 */
	public	String getBsePortDefCd() {
		return	this.bsePortDefCd;
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
	 * @return minCgoWgt
	 */
	public	String getMinCgoWgt() {
		return	this.minCgoWgt;
	}

	/**
	 * Column Info
	 * @return routPntLocDefDesc
	 */
	public	String getRoutPntLocDefDesc() {
		return	this.routPntLocDefDesc;
	}

	/**
	 * Column Info
	 * @return prcTrspModCd
	 */
	public	String getPrcTrspModCd() {
		return	this.prcTrspModCd;
	}

	/**
	 * Column Info
	 * @return n1stCmncDt
	 */
	public	String getN1stCmncDt() {
		return	this.n1stCmncDt;
	}

	/**
	 * Column Info
	 * @return totErrCnt
	 */
	public	String getTotErrCnt() {
		return	this.totErrCnt;
	}

	/**
	 * Column Info
	 * @return chkLenRoutPntLocDefCd
	 */
	public	String getChkLenRoutPntLocDefCd() {
		return	this.chkLenRoutPntLocDefCd;
	}

	/**
	 * Column Info
	 * @return chkLenBsePortDefCd
	 */
	public	String getChkLenBsePortDefCd() {
		return	this.chkLenBsePortDefCd;
	}

	/**
	 * Column Info
	 * @return chkRcvDeTermCd
	 */
	public	String getChkRcvDeTermCd() {
		return	this.chkRcvDeTermCd;
	}

	/**
	 * Column Info
	 * @return chkRatUtCd
	 */
	public	String getChkRatUtCd() {
		return	this.chkRatUtCd;
	}

	/**
	 * Column Info
	 * @return chkCurrCd
	 */
	public	String getChkCurrCd() {
		return	this.chkCurrCd;
	}

	/**
	 * Column Info
	 * @return chkMinCgoWgt
	 */
	public	String getChkMinCgoWgt() {
		return	this.chkMinCgoWgt;
	}

	/**
	 * Column Info
	 * @return chkMaxCgoWgt
	 */
	public	String getChkMaxCgoWgt() {
		return	this.chkMaxCgoWgt;
	}

	/**
	 * Column Info
	 * @return chkPropFrtRtAmt
	 */
	public	String getChkPropFrtRtAmt() {
		return	this.chkPropFrtRtAmt;
	}

	/**
	 * Column Info
	 * @return chkTermPntPort
	 */
	public	String getChkTermPntPort() {
		return	this.chkTermPntPort;
	}

	/**
	 * Column Info
	 * @return ukey
	 */
	public	String getUkey() {
		return	this.ukey;
	}

	/**
	 * Column Info
	 * @return dupCnt
	 */
	public	String getDupCnt() {
		return	this.dupCnt;
	}

	/**
	 * Column Info
	 * @return chkRoutPntLocDefCd
	 */
	public	String getChkRoutPntLocDefCd() {
		return	this.chkRoutPntLocDefCd;
	}

	/**
	 * Column Info
	 * @return chkBsePortDefCd
	 */
	public	String getChkBsePortDefCd() {
		return	this.chkBsePortDefCd;
	}

	/**
	 * Column Info
	 * @return rowErrCnt
	 */
	public	String getRowErrCnt() {
		return	this.rowErrCnt;
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
	 * @param  addChgSeq
 	 */
	public void	setAddChgSeq(String addChgSeq ) {
		this.addChgSeq =	addChgSeq;
	}
 	/**
	 * Column Info
	 * @param  currCd
 	 */
	public void	setCurrCd(String currCd ) {
		this.currCd =	currCd;
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
	 * @param  griApplAmt
 	 */
	public void	setGriApplAmt(String griApplAmt ) {
		this.griApplAmt =	griApplAmt;
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
	 * @param  routPntLocDefCd
 	 */
	public void	setRoutPntLocDefCd(String routPntLocDefCd ) {
		this.routPntLocDefCd =	routPntLocDefCd;
	}
 	/**
	 * Column Info
	 * @param  coffrFrtRtAmt
 	 */
	public void	setCoffrFrtRtAmt(String coffrFrtRtAmt ) {
		this.coffrFrtRtAmt =	coffrFrtRtAmt;
	}
 	/**
	 * Column Info
	 * @param  noteDpSeq
 	 */
	public void	setNoteDpSeq(String noteDpSeq ) {
		this.noteDpSeq =	noteDpSeq;
	}
 	/**
	 * Column Info
	 * @param  fnlFrtRtAmt
 	 */
	public void	setFnlFrtRtAmt(String fnlFrtRtAmt ) {
		this.fnlFrtRtAmt =	fnlFrtRtAmt;
	}
 	/**
	 * Column Info
	 * @param  prcProgStsCd
 	 */
	public void	setPrcProgStsCd(String prcProgStsCd ) {
		this.prcProgStsCd =	prcProgStsCd;
	}
 	/**
	 * Column Info
	 * @param  bsePortTpCd
 	 */
	public void	setBsePortTpCd(String bsePortTpCd ) {
		this.bsePortTpCd =	bsePortTpCd;
	}
 	/**
	 * Column Info
	 * @param  addChgNoteCtnt
 	 */
	public void	setAddChgNoteCtnt(String addChgNoteCtnt ) {
		this.addChgNoteCtnt =	addChgNoteCtnt;
	}
 	/**
	 * Column Info
	 * @param  rcvDeTermCd
 	 */
	public void	setRcvDeTermCd(String rcvDeTermCd ) {
		this.rcvDeTermCd =	rcvDeTermCd;
	}
 	/**
	 * Column Info
	 * @param  maxCgoWgt
 	 */
	public void	setMaxCgoWgt(String maxCgoWgt ) {
		this.maxCgoWgt =	maxCgoWgt;
	}
 	/**
	 * Column Info
	 * @param  custCntCd
 	 */
	public void	setCustCntCd(String custCntCd ) {
		this.custCntCd =	custCntCd;
	}
 	/**
	 * Column Info
	 * @param  routPntLocTpCd
 	 */
	public void	setRoutPntLocTpCd(String routPntLocTpCd ) {
		this.routPntLocTpCd =	routPntLocTpCd;
	}
 	/**
	 * Column Info
	 * @param  addChgTpCd
 	 */
	public void	setAddChgTpCd(String addChgTpCd ) {
		this.addChgTpCd =	addChgTpCd;
	}
 	/**
	 * Column Info
	 * @param  griApplTpCd
 	 */
	public void	setGriApplTpCd(String griApplTpCd ) {
		this.griApplTpCd =	griApplTpCd;
	}
 	/**
	 * Column Info
	 * @param  srcInfoCd
 	 */
	public void	setSrcInfoCd(String srcInfoCd ) {
		this.srcInfoCd =	srcInfoCd;
	}
 	/**
	 * Column Info
	 * @param  orgDestTpCd
 	 */
	public void	setOrgDestTpCd(String orgDestTpCd ) {
		this.orgDestTpCd =	orgDestTpCd;
	}
 	/**
	 * Column Info
	 * @param  custDefCd
 	 */
	public void	setCustDefCd(String custDefCd ) {
		this.custDefCd =	custDefCd;
	}
 	/**
	 * Column Info
	 * @param  ratUtCd
 	 */
	public void	setRatUtCd(String ratUtCd ) {
		this.ratUtCd =	ratUtCd;
	}
 	/**
	 * Column Info
	 * @param  propFrtRtAmt
 	 */
	public void	setPropFrtRtAmt(String propFrtRtAmt ) {
		this.propFrtRtAmt =	propFrtRtAmt;
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
	 * @param  bsePortDefCd
 	 */
	public void	setBsePortDefCd(String bsePortDefCd ) {
		this.bsePortDefCd =	bsePortDefCd;
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
	 * @param  minCgoWgt
 	 */
	public void	setMinCgoWgt(String minCgoWgt ) {
		this.minCgoWgt =	minCgoWgt;
	}
 	/**
	 * Column Info
	 * @param  routPntLocDefDesc
 	 */
	public void	setRoutPntLocDefDesc(String routPntLocDefDesc ) {
		this.routPntLocDefDesc =	routPntLocDefDesc;
	}
 	/**
	 * Column Info
	 * @param  prcTrspModCd
 	 */
	public void	setPrcTrspModCd(String prcTrspModCd ) {
		this.prcTrspModCd =	prcTrspModCd;
	}
 	/**
	 * Column Info
	 * @param  n1stCmncDt
 	 */
	public void	setN1stCmncDt(String n1stCmncDt ) {
		this.n1stCmncDt =	n1stCmncDt;
	}
 	/**
	 * Column Info
	 * @param  totErrCnt
 	 */
	public void	setTotErrCnt(String totErrCnt ) {
		this.totErrCnt =	totErrCnt;
	}
 	/**
	 * Column Info
	 * @param  chkLenRoutPntLocDefCd
 	 */
	public void	setChkLenRoutPntLocDefCd(String chkLenRoutPntLocDefCd ) {
		this.chkLenRoutPntLocDefCd =	chkLenRoutPntLocDefCd;
	}
 	/**
	 * Column Info
	 * @param  chkLenBsePortDefCd
 	 */
	public void	setChkLenBsePortDefCd(String chkLenBsePortDefCd ) {
		this.chkLenBsePortDefCd =	chkLenBsePortDefCd;
	}
 	/**
	 * Column Info
	 * @param  chkRcvDeTermCd
 	 */
	public void	setChkRcvDeTermCd(String chkRcvDeTermCd ) {
		this.chkRcvDeTermCd =	chkRcvDeTermCd;
	}
 	/**
	 * Column Info
	 * @param  chkRatUtCd
 	 */
	public void	setChkRatUtCd(String chkRatUtCd ) {
		this.chkRatUtCd =	chkRatUtCd;
	}
 	/**
	 * Column Info
	 * @param  chkCurrCd
 	 */
	public void	setChkCurrCd(String chkCurrCd ) {
		this.chkCurrCd =	chkCurrCd;
	}
 	/**
	 * Column Info
	 * @param  chkMinCgoWgt
 	 */
	public void	setChkMinCgoWgt(String chkMinCgoWgt ) {
		this.chkMinCgoWgt =	chkMinCgoWgt;
	}
 	/**
	 * Column Info
	 * @param  chkMaxCgoWgt
 	 */
	public void	setChkMaxCgoWgt(String chkMaxCgoWgt ) {
		this.chkMaxCgoWgt =	chkMaxCgoWgt;
	}
 	/**
	 * Column Info
	 * @param  chkPropFrtRtAmt
 	 */
	public void	setChkPropFrtRtAmt(String chkPropFrtRtAmt ) {
		this.chkPropFrtRtAmt =	chkPropFrtRtAmt;
	}
 	/**
	 * Column Info
	 * @param  chkTermPntPort
 	 */
	public void	setChkTermPntPort(String chkTermPntPort ) {
		this.chkTermPntPort =	chkTermPntPort;
	}
 	/**
	 * Column Info
	 * @param  ukey
 	 */
	public void	setUkey(String ukey ) {
		this.ukey =	ukey;
	}
 	/**
	 * Column Info
	 * @param  dupCnt
 	 */
	public void	setDupCnt(String dupCnt ) {
		this.dupCnt =	dupCnt;
	}
 	/**
	 * Column Info
	 * @param  chkRoutPntLocDefCd
 	 */
	public void	setChkRoutPntLocDefCd(String chkRoutPntLocDefCd ) {
		this.chkRoutPntLocDefCd =	chkRoutPntLocDefCd;
	}
 	/**
	 * Column Info
	 * @param  chkBsePortDefCd
 	 */
	public void	setChkBsePortDefCd(String chkBsePortDefCd ) {
		this.chkBsePortDefCd =	chkBsePortDefCd;
	}
 	/**
	 * Column Info
	 * @param  rowErrCnt
 	 */
	public void	setRowErrCnt(String rowErrCnt ) {
		this.rowErrCnt =	rowErrCnt;
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
		setAddChgSeq(JSPUtil.getParameter(request,	prefix + "add_chg_seq", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request,	prefix + "prc_cgo_tp_cd", ""));
		setGriApplAmt(JSPUtil.getParameter(request,	prefix + "gri_appl_amt", ""));
		setAmdtSeq(JSPUtil.getParameter(request,	prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setRoutPntLocDefCd(JSPUtil.getParameter(request,	prefix + "rout_pnt_loc_def_cd", ""));
		setCoffrFrtRtAmt(JSPUtil.getParameter(request,	prefix + "coffr_frt_rt_amt", ""));
		setNoteDpSeq(JSPUtil.getParameter(request,	prefix + "note_dp_seq", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request,	prefix + "fnl_frt_rt_amt", ""));
		setPrcProgStsCd(JSPUtil.getParameter(request,	prefix + "prc_prog_sts_cd", ""));
		setBsePortTpCd(JSPUtil.getParameter(request,	prefix + "bse_port_tp_cd", ""));
		setAddChgNoteCtnt(JSPUtil.getParameter(request,	prefix + "add_chg_note_ctnt", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request,	prefix + "rcv_de_term_cd", ""));
		setMaxCgoWgt(JSPUtil.getParameter(request,	prefix + "max_cgo_wgt", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setRoutPntLocTpCd(JSPUtil.getParameter(request,	prefix + "rout_pnt_loc_tp_cd", ""));
		setAddChgTpCd(JSPUtil.getParameter(request,	prefix + "add_chg_tp_cd", ""));
		setGriApplTpCd(JSPUtil.getParameter(request,	prefix + "gri_appl_tp_cd", ""));
		setSrcInfoCd(JSPUtil.getParameter(request,	prefix + "src_info_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request,	prefix + "org_dest_tp_cd", ""));
		setCustDefCd(JSPUtil.getParameter(request,	prefix + "cust_def_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request,	prefix + "rat_ut_cd", ""));
		setPropFrtRtAmt(JSPUtil.getParameter(request,	prefix + "prop_frt_rt_amt", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setBsePortDefCd(JSPUtil.getParameter(request,	prefix + "bse_port_def_cd", ""));
		setPropNo(JSPUtil.getParameter(request,	prefix + "prop_no", ""));
		setMinCgoWgt(JSPUtil.getParameter(request,	prefix + "min_cgo_wgt", ""));
		setRoutPntLocDefDesc(JSPUtil.getParameter(request,	prefix + "rout_pnt_loc_def_desc", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request,	prefix + "prc_trsp_mod_cd", ""));
		setN1stCmncDt(JSPUtil.getParameter(request,	prefix + "n1st_cmnc_dt", ""));
		setTotErrCnt(JSPUtil.getParameter(request,	prefix + "tot_err_cnt", ""));
		setChkLenRoutPntLocDefCd(JSPUtil.getParameter(request,	prefix + "chk_len_rout_pnt_loc_def_cd", ""));
		setChkLenBsePortDefCd(JSPUtil.getParameter(request,	prefix + "chk_len_bse_port_def_cd", ""));
		setChkRcvDeTermCd(JSPUtil.getParameter(request,	prefix + "chk_rcv_de_term_cd", ""));
		setChkRatUtCd(JSPUtil.getParameter(request,	prefix + "chk_rat_ut_cd", ""));
		setChkCurrCd(JSPUtil.getParameter(request,	prefix + "chk_curr_cd", ""));
		setChkMinCgoWgt(JSPUtil.getParameter(request,	prefix + "chk_min_cgo_wgt", ""));
		setChkMaxCgoWgt(JSPUtil.getParameter(request,	prefix + "chk_max_cgo_wgt", ""));
		setChkPropFrtRtAmt(JSPUtil.getParameter(request,	prefix + "chk_prop_frt_rt_amt", ""));
		setChkTermPntPort(JSPUtil.getParameter(request,	prefix + "chk_term_pnt_port", ""));
		setUkey(JSPUtil.getParameter(request,	prefix + "ukey", ""));
		setDupCnt(JSPUtil.getParameter(request,	prefix + "dup_cnt", ""));
		setChkRoutPntLocDefCd(JSPUtil.getParameter(request,	prefix + "chk_rout_pnt_loc_def_cd", ""));
		setChkBsePortDefCd(JSPUtil.getParameter(request,	prefix + "chk_bse_port_def_cd", ""));
		setRowErrCnt(JSPUtil.getParameter(request,	prefix + "row_err_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriRpScpTrspAddChgVO[]
	 */
	public RsltPriRpScpTrspAddChgVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return RsltPriRpScpTrspAddChgVO[]
	 */
	public RsltPriRpScpTrspAddChgVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		RsltPriRpScpTrspAddChgVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] addChgSeq =	(JSPUtil.getParameter(request, prefix +	"add_chg_seq",	length));
			String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd",	length));
			String[] prcCgoTpCd =	(JSPUtil.getParameter(request, prefix +	"prc_cgo_tp_cd",	length));
			String[] griApplAmt =	(JSPUtil.getParameter(request, prefix +	"gri_appl_amt",	length));
			String[] amdtSeq =	(JSPUtil.getParameter(request, prefix +	"amdt_seq",	length));
			String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd",	length));
			String[] routPntLocDefCd =	(JSPUtil.getParameter(request, prefix +	"rout_pnt_loc_def_cd",	length));
			String[] coffrFrtRtAmt =	(JSPUtil.getParameter(request, prefix +	"coffr_frt_rt_amt",	length));
			String[] noteDpSeq =	(JSPUtil.getParameter(request, prefix +	"note_dp_seq",	length));
			String[] fnlFrtRtAmt =	(JSPUtil.getParameter(request, prefix +	"fnl_frt_rt_amt",	length));
			String[] prcProgStsCd =	(JSPUtil.getParameter(request, prefix +	"prc_prog_sts_cd",	length));
			String[] bsePortTpCd =	(JSPUtil.getParameter(request, prefix +	"bse_port_tp_cd",	length));
			String[] addChgNoteCtnt =	(JSPUtil.getParameter(request, prefix +	"add_chg_note_ctnt",	length));
			String[] rcvDeTermCd =	(JSPUtil.getParameter(request, prefix +	"rcv_de_term_cd",	length));
			String[] maxCgoWgt =	(JSPUtil.getParameter(request, prefix +	"max_cgo_wgt",	length));
			String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd",	length));
			String[] routPntLocTpCd =	(JSPUtil.getParameter(request, prefix +	"rout_pnt_loc_tp_cd",	length));
			String[] addChgTpCd =	(JSPUtil.getParameter(request, prefix +	"add_chg_tp_cd",	length));
			String[] griApplTpCd =	(JSPUtil.getParameter(request, prefix +	"gri_appl_tp_cd",	length));
			String[] srcInfoCd =	(JSPUtil.getParameter(request, prefix +	"src_info_cd",	length));
			String[] orgDestTpCd =	(JSPUtil.getParameter(request, prefix +	"org_dest_tp_cd",	length));
			String[] custDefCd =	(JSPUtil.getParameter(request, prefix +	"cust_def_cd",	length));
			String[] ratUtCd =	(JSPUtil.getParameter(request, prefix +	"rat_ut_cd",	length));
			String[] propFrtRtAmt =	(JSPUtil.getParameter(request, prefix +	"prop_frt_rt_amt",	length));
			String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq",	length));
			String[] bsePortDefCd =	(JSPUtil.getParameter(request, prefix +	"bse_port_def_cd",	length));
			String[] propNo =	(JSPUtil.getParameter(request, prefix +	"prop_no",	length));
			String[] minCgoWgt =	(JSPUtil.getParameter(request, prefix +	"min_cgo_wgt",	length));
			String[] routPntLocDefDesc =	(JSPUtil.getParameter(request, prefix +	"rout_pnt_loc_def_desc",	length));
			String[] prcTrspModCd =	(JSPUtil.getParameter(request, prefix +	"prc_trsp_mod_cd",	length));
			String[] n1stCmncDt =	(JSPUtil.getParameter(request, prefix +	"n1st_cmnc_dt",	length));
			String[] totErrCnt =	(JSPUtil.getParameter(request, prefix +	"tot_err_cnt",	length));
			String[] chkLenRoutPntLocDefCd =	(JSPUtil.getParameter(request, prefix +	"chk_len_rout_pnt_loc_def_cd",	length));
			String[] chkLenBsePortDefCd =	(JSPUtil.getParameter(request, prefix +	"chk_len_bse_port_def_cd",	length));
			String[] chkRcvDeTermCd =	(JSPUtil.getParameter(request, prefix +	"chk_rcv_de_term_cd",	length));
			String[] chkRatUtCd =	(JSPUtil.getParameter(request, prefix +	"chk_rat_ut_cd",	length));
			String[] chkCurrCd =	(JSPUtil.getParameter(request, prefix +	"chk_curr_cd",	length));
			String[] chkMinCgoWgt =	(JSPUtil.getParameter(request, prefix +	"chk_min_cgo_wgt",	length));
			String[] chkMaxCgoWgt =	(JSPUtil.getParameter(request, prefix +	"chk_max_cgo_wgt",	length));
			String[] chkPropFrtRtAmt =	(JSPUtil.getParameter(request, prefix +	"chk_prop_frt_rt_amt",	length));
			String[] chkTermPntPort =	(JSPUtil.getParameter(request, prefix +	"chk_term_pnt_port",	length));
			String[] ukey =	(JSPUtil.getParameter(request, prefix +	"ukey",	length));
			String[] dupCnt =	(JSPUtil.getParameter(request, prefix +	"dup_cnt",	length));
			String[] chkRoutPntLocDefCd =	(JSPUtil.getParameter(request, prefix +	"chk_rout_pnt_loc_def_cd",	length));
			String[] chkBsePortDefCd =	(JSPUtil.getParameter(request, prefix +	"chk_bse_port_def_cd",	length));
			String[] rowErrCnt =	(JSPUtil.getParameter(request, prefix +	"row_err_cnt",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	RsltPriRpScpTrspAddChgVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( addChgSeq[i] !=	null)
					model.setAddChgSeq( addChgSeq[i]);
				if ( currCd[i] !=	null)
					model.setCurrCd( currCd[i]);
				if ( prcCgoTpCd[i] !=	null)
					model.setPrcCgoTpCd( prcCgoTpCd[i]);
				if ( griApplAmt[i] !=	null)
					model.setGriApplAmt( griApplAmt[i]);
				if ( amdtSeq[i] !=	null)
					model.setAmdtSeq( amdtSeq[i]);
				if ( svcScpCd[i] !=	null)
					model.setSvcScpCd( svcScpCd[i]);
				if ( routPntLocDefCd[i] !=	null)
					model.setRoutPntLocDefCd( routPntLocDefCd[i]);
				if ( coffrFrtRtAmt[i] !=	null)
					model.setCoffrFrtRtAmt( coffrFrtRtAmt[i]);
				if ( noteDpSeq[i] !=	null)
					model.setNoteDpSeq( noteDpSeq[i]);
				if ( fnlFrtRtAmt[i] !=	null)
					model.setFnlFrtRtAmt( fnlFrtRtAmt[i]);
				if ( prcProgStsCd[i] !=	null)
					model.setPrcProgStsCd( prcProgStsCd[i]);
				if ( bsePortTpCd[i] !=	null)
					model.setBsePortTpCd( bsePortTpCd[i]);
				if ( addChgNoteCtnt[i] !=	null)
					model.setAddChgNoteCtnt( addChgNoteCtnt[i]);
				if ( rcvDeTermCd[i] !=	null)
					model.setRcvDeTermCd( rcvDeTermCd[i]);
				if ( maxCgoWgt[i] !=	null)
					model.setMaxCgoWgt( maxCgoWgt[i]);
				if ( custCntCd[i] !=	null)
					model.setCustCntCd( custCntCd[i]);
				if ( routPntLocTpCd[i] !=	null)
					model.setRoutPntLocTpCd( routPntLocTpCd[i]);
				if ( addChgTpCd[i] !=	null)
					model.setAddChgTpCd( addChgTpCd[i]);
				if ( griApplTpCd[i] !=	null)
					model.setGriApplTpCd( griApplTpCd[i]);
				if ( srcInfoCd[i] !=	null)
					model.setSrcInfoCd( srcInfoCd[i]);
				if ( orgDestTpCd[i] !=	null)
					model.setOrgDestTpCd( orgDestTpCd[i]);
				if ( custDefCd[i] !=	null)
					model.setCustDefCd( custDefCd[i]);
				if ( ratUtCd[i] !=	null)
					model.setRatUtCd( ratUtCd[i]);
				if ( propFrtRtAmt[i] !=	null)
					model.setPropFrtRtAmt( propFrtRtAmt[i]);
				if ( custSeq[i] !=	null)
					model.setCustSeq( custSeq[i]);
				if ( bsePortDefCd[i] !=	null)
					model.setBsePortDefCd( bsePortDefCd[i]);
				if ( propNo[i] !=	null)
					model.setPropNo( propNo[i]);
				if ( minCgoWgt[i] !=	null)
					model.setMinCgoWgt( minCgoWgt[i]);
				if ( routPntLocDefDesc[i] !=	null)
					model.setRoutPntLocDefDesc( routPntLocDefDesc[i]);
				if ( prcTrspModCd[i] !=	null)
					model.setPrcTrspModCd( prcTrspModCd[i]);
				if ( n1stCmncDt[i] !=	null)
					model.setN1stCmncDt( n1stCmncDt[i]);
				if ( totErrCnt[i] !=	null)
					model.setTotErrCnt( totErrCnt[i]);
				if ( chkLenRoutPntLocDefCd[i] !=	null)
					model.setChkLenRoutPntLocDefCd( chkLenRoutPntLocDefCd[i]);
				if ( chkLenBsePortDefCd[i] !=	null)
					model.setChkLenBsePortDefCd( chkLenBsePortDefCd[i]);
				if ( chkRcvDeTermCd[i] !=	null)
					model.setChkRcvDeTermCd( chkRcvDeTermCd[i]);
				if ( chkRatUtCd[i] !=	null)
					model.setChkRatUtCd( chkRatUtCd[i]);
				if ( chkCurrCd[i] !=	null)
					model.setChkCurrCd( chkCurrCd[i]);
				if ( chkMinCgoWgt[i] !=	null)
					model.setChkMinCgoWgt( chkMinCgoWgt[i]);
				if ( chkMaxCgoWgt[i] !=	null)
					model.setChkMaxCgoWgt( chkMaxCgoWgt[i]);
				if ( chkPropFrtRtAmt[i] !=	null)
					model.setChkPropFrtRtAmt( chkPropFrtRtAmt[i]);
				if ( chkTermPntPort[i] !=	null)
					model.setChkTermPntPort( chkTermPntPort[i]);
				if ( ukey[i] !=	null)
					model.setUkey( ukey[i]);
				if ( dupCnt[i] !=	null)
					model.setDupCnt( dupCnt[i]);
				if ( chkRoutPntLocDefCd[i] !=	null)
					model.setChkRoutPntLocDefCd( chkRoutPntLocDefCd[i]);
				if ( chkBsePortDefCd[i] !=	null)
					model.setChkBsePortDefCd( chkBsePortDefCd[i]);
				if ( rowErrCnt[i] !=	null)
					model.setRowErrCnt( rowErrCnt[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getRsltPriRpScpTrspAddChgVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return RsltPriRpScpTrspAddChgVO[]
	 */
	public RsltPriRpScpTrspAddChgVO[]	 getRsltPriRpScpTrspAddChgVOs(){
		RsltPriRpScpTrspAddChgVO[] vos = (RsltPriRpScpTrspAddChgVO[])models.toArray(new	RsltPriRpScpTrspAddChgVO[models.size()]);
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
		this.addChgSeq =	this.addChgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd =	this.prcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplAmt =	this.griApplAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq =	this.amdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCd =	this.routPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coffrFrtRtAmt =	this.coffrFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteDpSeq =	this.noteDpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt =	this.fnlFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsCd =	this.prcProgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortTpCd =	this.bsePortTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addChgNoteCtnt =	this.addChgNoteCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd =	this.rcvDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxCgoWgt =	this.maxCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocTpCd =	this.routPntLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addChgTpCd =	this.addChgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplTpCd =	this.griApplTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd =	this.srcInfoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd =	this.orgDestTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custDefCd =	this.custDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd =	this.ratUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtRtAmt =	this.propFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortDefCd =	this.bsePortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo =	this.propNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCgoWgt =	this.minCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefDesc =	this.routPntLocDefDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd =	this.prcTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncDt =	this.n1stCmncDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totErrCnt =	this.totErrCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkLenRoutPntLocDefCd =	this.chkLenRoutPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkLenBsePortDefCd =	this.chkLenBsePortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkRcvDeTermCd =	this.chkRcvDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkRatUtCd =	this.chkRatUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCurrCd =	this.chkCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkMinCgoWgt =	this.chkMinCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkMaxCgoWgt =	this.chkMaxCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPropFrtRtAmt =	this.chkPropFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkTermPntPort =	this.chkTermPntPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ukey =	this.ukey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupCnt =	this.dupCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkRoutPntLocDefCd =	this.chkRoutPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkBsePortDefCd =	this.chkBsePortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowErrCnt =	this.rowErrCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}