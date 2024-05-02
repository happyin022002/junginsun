/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : RsltArbChgListVO.java
 *@FileTitle : RsltArbChgListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.02.19
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2016.02.19 jaewonLee 
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
public class RsltArbChgListVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<RsltArbChgListVO>  models =	new	ArrayList<RsltArbChgListVO>();
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
	private String custNm = null;
	/*	Column Info	*/
	private String amdtSeq = null;
	/*	Column Info	*/
	private String svcScpCd = null;
	/*	Column Info	*/
	private String creDt = null;
	/*	Column Info	*/
	private String routPntLocDefCd = null;
	/*	Column Info	*/
	private String coffrFrtRtAmt = null;
	/*	Column Info	*/
	private String fnlFrtRtAmt = null;
	/*	Column Info	*/
	private String prcProgStsCd = null;
	/*	Column Info	*/
	private String effDt = null;
	/*	Column Info	*/
	private String bsePortTpCd = null;
	/*	Column Info	*/
	private String rcvDeTermCd = null;
	/*	Column Info	*/
	private String expDt = null;
	/*	Column Info	*/
	private String updUsrId = null;
	/*	Column Info	*/
	private String maxCgoWgt = null;
	/*	Column Info	*/
	private String custCntCd = null;
	/*	Column Info	*/
	private String routPntLocTpCd = null;
	/*	Column Info	*/
	private String updDt = null;
	/*	Column Info	*/
	private String addChgTpCd = null;
	/*	Column Info	*/
	private String acptDt = null;
	/*	Column Info	*/
	private String acptOfcCd = null;
	/*	Column Info	*/
	private String routPntLocDefNm = null;
	/*	Column Info	*/
	private String acptUsrNm = null;
	/*	Column Info	*/
	private String acptUsrId = null;
	/*	Column Info	*/
	private String srcInfoCd = null;
	/*	Column Info	*/
	private String orgDestTpCd = null;
	/*	Column Info	*/
	private String ratUtCd = null;
	/*	Column Info	*/
	private String perType = null;
	/*	Column Info	*/
	private String propFrtRtAmt = null;
	/*	Column Info	*/
	private String bsePortDefCd = null;
	/*	Column Info	*/
	private String creUsrId = null;
	/*	Column Info	*/
	private String n1stCmncAmdtSeq = null;
	/*	Column Info	*/
	private String propNo = null;
	/*	Column Info	*/
	private String minCgoWgt = null;
	/*	Column Info	*/
	private String prcTrspModCd = null;
	/*	Column Info	*/
	private String noteDpSeq = null;
	/*	Column Info	*/
	private String addChgNoteCtnt = null;
	/*	Column Info	*/
	private String preNoteDpSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public RsltArbChgListVO(){}

	public RsltArbChgListVO(String ibflag,String pagerows,String addChgSeq,String currCd,String prcCgoTpCd,String custNm,String amdtSeq,String svcScpCd,String creDt,String routPntLocDefCd,String coffrFrtRtAmt,String fnlFrtRtAmt,String prcProgStsCd,String effDt,String bsePortTpCd,String rcvDeTermCd,String expDt,String updUsrId,String maxCgoWgt,String custCntCd,String routPntLocTpCd,String updDt,String addChgTpCd,String acptDt,String acptOfcCd,String routPntLocDefNm,String acptUsrNm,String acptUsrId,String srcInfoCd,String orgDestTpCd,String ratUtCd,String perType,String propFrtRtAmt,String bsePortDefCd,String creUsrId,String n1stCmncAmdtSeq,String propNo,String minCgoWgt,String prcTrspModCd,String noteDpSeq,String addChgNoteCtnt,String preNoteDpSeq)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.addChgSeq = addChgSeq;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.custNm = custNm;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.routPntLocDefCd = routPntLocDefCd;
		this.coffrFrtRtAmt = coffrFrtRtAmt;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.prcProgStsCd = prcProgStsCd;
		this.effDt = effDt;
		this.bsePortTpCd = bsePortTpCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
		this.maxCgoWgt = maxCgoWgt;
		this.custCntCd = custCntCd;
		this.routPntLocTpCd = routPntLocTpCd;
		this.updDt = updDt;
		this.addChgTpCd = addChgTpCd;
		this.acptDt = acptDt;
		this.acptOfcCd = acptOfcCd;
		this.routPntLocDefNm = routPntLocDefNm;
		this.acptUsrNm = acptUsrNm;
		this.acptUsrId = acptUsrId;
		this.srcInfoCd = srcInfoCd;
		this.orgDestTpCd = orgDestTpCd;
		this.ratUtCd = ratUtCd;
		this.perType = perType;
		this.propFrtRtAmt = propFrtRtAmt;
		this.bsePortDefCd = bsePortDefCd;
		this.creUsrId = creUsrId;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.propNo = propNo;
		this.minCgoWgt = minCgoWgt;
		this.prcTrspModCd = prcTrspModCd;
		this.noteDpSeq = noteDpSeq;
		this.addChgNoteCtnt = addChgNoteCtnt;
		this.preNoteDpSeq = preNoteDpSeq;
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
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rout_pnt_loc_def_cd", getRoutPntLocDefCd());
		this.hashColumns.put("coffr_frt_rt_amt", getCoffrFrtRtAmt());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("prc_prog_sts_cd", getPrcProgStsCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("bse_port_tp_cd", getBsePortTpCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("max_cgo_wgt", getMaxCgoWgt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("rout_pnt_loc_tp_cd", getRoutPntLocTpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("add_chg_tp_cd", getAddChgTpCd());
		this.hashColumns.put("acpt_dt", getAcptDt());
		this.hashColumns.put("acpt_ofc_cd", getAcptOfcCd());
		this.hashColumns.put("rout_pnt_loc_def_nm", getRoutPntLocDefNm());
		this.hashColumns.put("acpt_usr_nm", getAcptUsrNm());
		this.hashColumns.put("acpt_usr_id", getAcptUsrId());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("per_type", getPerType());
		this.hashColumns.put("prop_frt_rt_amt", getPropFrtRtAmt());
		this.hashColumns.put("bse_port_def_cd", getBsePortDefCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("min_cgo_wgt", getMinCgoWgt());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("note_dp_seq", getNoteDpSeq());
		this.hashColumns.put("add_chg_note_ctnt", getAddChgNoteCtnt());
		this.hashColumns.put("pre_note_dp_seq", getPreNoteDpSeq());
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
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rout_pnt_loc_def_cd", "routPntLocDefCd");
		this.hashFields.put("coffr_frt_rt_amt", "coffrFrtRtAmt");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("prc_prog_sts_cd", "prcProgStsCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("bse_port_tp_cd", "bsePortTpCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("max_cgo_wgt", "maxCgoWgt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("rout_pnt_loc_tp_cd", "routPntLocTpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("add_chg_tp_cd", "addChgTpCd");
		this.hashFields.put("acpt_dt", "acptDt");
		this.hashFields.put("acpt_ofc_cd", "acptOfcCd");
		this.hashFields.put("rout_pnt_loc_def_nm", "routPntLocDefNm");
		this.hashFields.put("acpt_usr_nm", "acptUsrNm");
		this.hashFields.put("acpt_usr_id", "acptUsrId");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("per_type", "perType");
		this.hashFields.put("prop_frt_rt_amt", "propFrtRtAmt");
		this.hashFields.put("bse_port_def_cd", "bsePortDefCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("min_cgo_wgt", "minCgoWgt");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("note_dp_seq", "noteDpSeq");
		this.hashFields.put("add_chg_note_ctnt", "addChgNoteCtnt");
		this.hashFields.put("pre_note_dp_seq", "preNoteDpSeq");
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
	 * @return custNm
	 */
	public	String getCustNm() {
		return	this.custNm;
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
	 * @return creDt
	 */
	public	String getCreDt() {
		return	this.creDt;
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
	 * @return effDt
	 */
	public	String getEffDt() {
		return	this.effDt;
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
	 * @return rcvDeTermCd
	 */
	public	String getRcvDeTermCd() {
		return	this.rcvDeTermCd;
	}

	/**
	 * Column Info
	 * @return expDt
	 */
	public	String getExpDt() {
		return	this.expDt;
	}

	/**
	 * Column Info
	 * @return updUsrId
	 */
	public	String getUpdUsrId() {
		return	this.updUsrId;
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
	 * @return updDt
	 */
	public	String getUpdDt() {
		return	this.updDt;
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
	 * @return acptDt
	 */
	public	String getAcptDt() {
		return	this.acptDt;
	}

	/**
	 * Column Info
	 * @return acptOfcCd
	 */
	public	String getAcptOfcCd() {
		return	this.acptOfcCd;
	}

	/**
	 * Column Info
	 * @return routPntLocDefNm
	 */
	public	String getRoutPntLocDefNm() {
		return	this.routPntLocDefNm;
	}

	/**
	 * Column Info
	 * @return acptUsrNm
	 */
	public	String getAcptUsrNm() {
		return	this.acptUsrNm;
	}

	/**
	 * Column Info
	 * @return acptUsrId
	 */
	public	String getAcptUsrId() {
		return	this.acptUsrId;
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
	 * @return ratUtCd
	 */
	public	String getRatUtCd() {
		return	this.ratUtCd;
	}

	/**
	 * Column Info
	 * @return perType
	 */
	public	String getPerType() {
		return	this.perType;
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
	 * @return bsePortDefCd
	 */
	public	String getBsePortDefCd() {
		return	this.bsePortDefCd;
	}

	/**
	 * Column Info
	 * @return creUsrId
	 */
	public	String getCreUsrId() {
		return	this.creUsrId;
	}

	/**
	 * Column Info
	 * @return n1stCmncAmdtSeq
	 */
	public	String getN1stCmncAmdtSeq() {
		return	this.n1stCmncAmdtSeq;
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
	 * @return prcTrspModCd
	 */
	public	String getPrcTrspModCd() {
		return	this.prcTrspModCd;
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
	 * @return addChgNoteCtnt
	 */
	public	String getAddChgNoteCtnt() {
		return	this.addChgNoteCtnt;
	}

	/**
	 * Column Info
	 * @return preNoteDpSeq
	 */
	public	String getPreNoteDpSeq() {
		return	this.preNoteDpSeq;
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
	 * @param  custNm
 	 */
	public void	setCustNm(String custNm ) {
		this.custNm =	custNm;
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
	 * @param  creDt
 	 */
	public void	setCreDt(String creDt ) {
		this.creDt =	creDt;
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
	 * @param  effDt
 	 */
	public void	setEffDt(String effDt ) {
		this.effDt =	effDt;
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
	 * @param  rcvDeTermCd
 	 */
	public void	setRcvDeTermCd(String rcvDeTermCd ) {
		this.rcvDeTermCd =	rcvDeTermCd;
	}
 	/**
	 * Column Info
	 * @param  expDt
 	 */
	public void	setExpDt(String expDt ) {
		this.expDt =	expDt;
	}
 	/**
	 * Column Info
	 * @param  updUsrId
 	 */
	public void	setUpdUsrId(String updUsrId ) {
		this.updUsrId =	updUsrId;
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
	 * @param  updDt
 	 */
	public void	setUpdDt(String updDt ) {
		this.updDt =	updDt;
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
	 * @param  acptDt
 	 */
	public void	setAcptDt(String acptDt ) {
		this.acptDt =	acptDt;
	}
 	/**
	 * Column Info
	 * @param  acptOfcCd
 	 */
	public void	setAcptOfcCd(String acptOfcCd ) {
		this.acptOfcCd =	acptOfcCd;
	}
 	/**
	 * Column Info
	 * @param  routPntLocDefNm
 	 */
	public void	setRoutPntLocDefNm(String routPntLocDefNm ) {
		this.routPntLocDefNm =	routPntLocDefNm;
	}
 	/**
	 * Column Info
	 * @param  acptUsrNm
 	 */
	public void	setAcptUsrNm(String acptUsrNm ) {
		this.acptUsrNm =	acptUsrNm;
	}
 	/**
	 * Column Info
	 * @param  acptUsrId
 	 */
	public void	setAcptUsrId(String acptUsrId ) {
		this.acptUsrId =	acptUsrId;
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
	 * @param  ratUtCd
 	 */
	public void	setRatUtCd(String ratUtCd ) {
		this.ratUtCd =	ratUtCd;
	}
 	/**
	 * Column Info
	 * @param  perType
 	 */
	public void	setPerType(String perType ) {
		this.perType =	perType;
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
	 * @param  bsePortDefCd
 	 */
	public void	setBsePortDefCd(String bsePortDefCd ) {
		this.bsePortDefCd =	bsePortDefCd;
	}
 	/**
	 * Column Info
	 * @param  creUsrId
 	 */
	public void	setCreUsrId(String creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 	/**
	 * Column Info
	 * @param  n1stCmncAmdtSeq
 	 */
	public void	setN1stCmncAmdtSeq(String n1stCmncAmdtSeq ) {
		this.n1stCmncAmdtSeq =	n1stCmncAmdtSeq;
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
	 * @param  prcTrspModCd
 	 */
	public void	setPrcTrspModCd(String prcTrspModCd ) {
		this.prcTrspModCd =	prcTrspModCd;
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
	 * @param  addChgNoteCtnt
 	 */
	public void	setAddChgNoteCtnt(String addChgNoteCtnt ) {
		this.addChgNoteCtnt =	addChgNoteCtnt;
	}
 	/**
	 * Column Info
	 * @param  preNoteDpSeq
 	 */
	public void	setPreNoteDpSeq(String preNoteDpSeq ) {
		this.preNoteDpSeq =	preNoteDpSeq;
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
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setAmdtSeq(JSPUtil.getParameter(request,	prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setRoutPntLocDefCd(JSPUtil.getParameter(request,	prefix + "rout_pnt_loc_def_cd", ""));
		setCoffrFrtRtAmt(JSPUtil.getParameter(request,	prefix + "coffr_frt_rt_amt", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request,	prefix + "fnl_frt_rt_amt", ""));
		setPrcProgStsCd(JSPUtil.getParameter(request,	prefix + "prc_prog_sts_cd", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setBsePortTpCd(JSPUtil.getParameter(request,	prefix + "bse_port_tp_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request,	prefix + "rcv_de_term_cd", ""));
		setExpDt(JSPUtil.getParameter(request,	prefix + "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setMaxCgoWgt(JSPUtil.getParameter(request,	prefix + "max_cgo_wgt", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setRoutPntLocTpCd(JSPUtil.getParameter(request,	prefix + "rout_pnt_loc_tp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setAddChgTpCd(JSPUtil.getParameter(request,	prefix + "add_chg_tp_cd", ""));
		setAcptDt(JSPUtil.getParameter(request,	prefix + "acpt_dt", ""));
		setAcptOfcCd(JSPUtil.getParameter(request,	prefix + "acpt_ofc_cd", ""));
		setRoutPntLocDefNm(JSPUtil.getParameter(request,	prefix + "rout_pnt_loc_def_nm", ""));
		setAcptUsrNm(JSPUtil.getParameter(request,	prefix + "acpt_usr_nm", ""));
		setAcptUsrId(JSPUtil.getParameter(request,	prefix + "acpt_usr_id", ""));
		setSrcInfoCd(JSPUtil.getParameter(request,	prefix + "src_info_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request,	prefix + "org_dest_tp_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request,	prefix + "rat_ut_cd", ""));
		setPerType(JSPUtil.getParameter(request,	prefix + "per_type", ""));
		setPropFrtRtAmt(JSPUtil.getParameter(request,	prefix + "prop_frt_rt_amt", ""));
		setBsePortDefCd(JSPUtil.getParameter(request,	prefix + "bse_port_def_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request,	prefix + "n1st_cmnc_amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request,	prefix + "prop_no", ""));
		setMinCgoWgt(JSPUtil.getParameter(request,	prefix + "min_cgo_wgt", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request,	prefix + "prc_trsp_mod_cd", ""));
		setNoteDpSeq(JSPUtil.getParameter(request,	prefix + "note_dp_seq", ""));
		setAddChgNoteCtnt(JSPUtil.getParameter(request,	prefix + "add_chg_note_ctnt", ""));
		setPreNoteDpSeq(JSPUtil.getParameter(request,	prefix + "pre_note_dp_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltArbChgListVO[]
	 */
	public RsltArbChgListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return RsltArbChgListVO[]
	 */
	public RsltArbChgListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		RsltArbChgListVO model = null;

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
			String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm",	length));
			String[] amdtSeq =	(JSPUtil.getParameter(request, prefix +	"amdt_seq",	length));
			String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd",	length));
			String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt",	length));
			String[] routPntLocDefCd =	(JSPUtil.getParameter(request, prefix +	"rout_pnt_loc_def_cd",	length));
			String[] coffrFrtRtAmt =	(JSPUtil.getParameter(request, prefix +	"coffr_frt_rt_amt",	length));
			String[] fnlFrtRtAmt =	(JSPUtil.getParameter(request, prefix +	"fnl_frt_rt_amt",	length));
			String[] prcProgStsCd =	(JSPUtil.getParameter(request, prefix +	"prc_prog_sts_cd",	length));
			String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt",	length));
			String[] bsePortTpCd =	(JSPUtil.getParameter(request, prefix +	"bse_port_tp_cd",	length));
			String[] rcvDeTermCd =	(JSPUtil.getParameter(request, prefix +	"rcv_de_term_cd",	length));
			String[] expDt =	(JSPUtil.getParameter(request, prefix +	"exp_dt",	length));
			String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id",	length));
			String[] maxCgoWgt =	(JSPUtil.getParameter(request, prefix +	"max_cgo_wgt",	length));
			String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd",	length));
			String[] routPntLocTpCd =	(JSPUtil.getParameter(request, prefix +	"rout_pnt_loc_tp_cd",	length));
			String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt",	length));
			String[] addChgTpCd =	(JSPUtil.getParameter(request, prefix +	"add_chg_tp_cd",	length));
			String[] acptDt =	(JSPUtil.getParameter(request, prefix +	"acpt_dt",	length));
			String[] acptOfcCd =	(JSPUtil.getParameter(request, prefix +	"acpt_ofc_cd",	length));
			String[] routPntLocDefNm =	(JSPUtil.getParameter(request, prefix +	"rout_pnt_loc_def_nm",	length));
			String[] acptUsrNm =	(JSPUtil.getParameter(request, prefix +	"acpt_usr_nm",	length));
			String[] acptUsrId =	(JSPUtil.getParameter(request, prefix +	"acpt_usr_id",	length));
			String[] srcInfoCd =	(JSPUtil.getParameter(request, prefix +	"src_info_cd",	length));
			String[] orgDestTpCd =	(JSPUtil.getParameter(request, prefix +	"org_dest_tp_cd",	length));
			String[] ratUtCd =	(JSPUtil.getParameter(request, prefix +	"rat_ut_cd",	length));
			String[] perType =	(JSPUtil.getParameter(request, prefix +	"per_type",	length));
			String[] propFrtRtAmt =	(JSPUtil.getParameter(request, prefix +	"prop_frt_rt_amt",	length));
			String[] bsePortDefCd =	(JSPUtil.getParameter(request, prefix +	"bse_port_def_cd",	length));
			String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id",	length));
			String[] n1stCmncAmdtSeq =	(JSPUtil.getParameter(request, prefix +	"n1st_cmnc_amdt_seq",	length));
			String[] propNo =	(JSPUtil.getParameter(request, prefix +	"prop_no",	length));
			String[] minCgoWgt =	(JSPUtil.getParameter(request, prefix +	"min_cgo_wgt",	length));
			String[] prcTrspModCd =	(JSPUtil.getParameter(request, prefix +	"prc_trsp_mod_cd",	length));
			String[] noteDpSeq =	(JSPUtil.getParameter(request, prefix +	"note_dp_seq",	length));
			String[] addChgNoteCtnt =	(JSPUtil.getParameter(request, prefix +	"add_chg_note_ctnt",	length));
			String[] preNoteDpSeq =	(JSPUtil.getParameter(request, prefix +	"pre_note_dp_seq",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	RsltArbChgListVO();
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
				if ( custNm[i] !=	null)
					model.setCustNm( custNm[i]);
				if ( amdtSeq[i] !=	null)
					model.setAmdtSeq( amdtSeq[i]);
				if ( svcScpCd[i] !=	null)
					model.setSvcScpCd( svcScpCd[i]);
				if ( creDt[i] !=	null)
					model.setCreDt( creDt[i]);
				if ( routPntLocDefCd[i] !=	null)
					model.setRoutPntLocDefCd( routPntLocDefCd[i]);
				if ( coffrFrtRtAmt[i] !=	null)
					model.setCoffrFrtRtAmt( coffrFrtRtAmt[i]);
				if ( fnlFrtRtAmt[i] !=	null)
					model.setFnlFrtRtAmt( fnlFrtRtAmt[i]);
				if ( prcProgStsCd[i] !=	null)
					model.setPrcProgStsCd( prcProgStsCd[i]);
				if ( effDt[i] !=	null)
					model.setEffDt( effDt[i]);
				if ( bsePortTpCd[i] !=	null)
					model.setBsePortTpCd( bsePortTpCd[i]);
				if ( rcvDeTermCd[i] !=	null)
					model.setRcvDeTermCd( rcvDeTermCd[i]);
				if ( expDt[i] !=	null)
					model.setExpDt( expDt[i]);
				if ( updUsrId[i] !=	null)
					model.setUpdUsrId( updUsrId[i]);
				if ( maxCgoWgt[i] !=	null)
					model.setMaxCgoWgt( maxCgoWgt[i]);
				if ( custCntCd[i] !=	null)
					model.setCustCntCd( custCntCd[i]);
				if ( routPntLocTpCd[i] !=	null)
					model.setRoutPntLocTpCd( routPntLocTpCd[i]);
				if ( updDt[i] !=	null)
					model.setUpdDt( updDt[i]);
				if ( addChgTpCd[i] !=	null)
					model.setAddChgTpCd( addChgTpCd[i]);
				if ( acptDt[i] !=	null)
					model.setAcptDt( acptDt[i]);
				if ( acptOfcCd[i] !=	null)
					model.setAcptOfcCd( acptOfcCd[i]);
				if ( routPntLocDefNm[i] !=	null)
					model.setRoutPntLocDefNm( routPntLocDefNm[i]);
				if ( acptUsrNm[i] !=	null)
					model.setAcptUsrNm( acptUsrNm[i]);
				if ( acptUsrId[i] !=	null)
					model.setAcptUsrId( acptUsrId[i]);
				if ( srcInfoCd[i] !=	null)
					model.setSrcInfoCd( srcInfoCd[i]);
				if ( orgDestTpCd[i] !=	null)
					model.setOrgDestTpCd( orgDestTpCd[i]);
				if ( ratUtCd[i] !=	null)
					model.setRatUtCd( ratUtCd[i]);
				if ( perType[i] !=	null)
					model.setPerType( perType[i]);
				if ( propFrtRtAmt[i] !=	null)
					model.setPropFrtRtAmt( propFrtRtAmt[i]);
				if ( bsePortDefCd[i] !=	null)
					model.setBsePortDefCd( bsePortDefCd[i]);
				if ( creUsrId[i] !=	null)
					model.setCreUsrId( creUsrId[i]);
				if ( n1stCmncAmdtSeq[i] !=	null)
					model.setN1stCmncAmdtSeq( n1stCmncAmdtSeq[i]);
				if ( propNo[i] !=	null)
					model.setPropNo( propNo[i]);
				if ( minCgoWgt[i] !=	null)
					model.setMinCgoWgt( minCgoWgt[i]);
				if ( prcTrspModCd[i] !=	null)
					model.setPrcTrspModCd( prcTrspModCd[i]);
				if ( noteDpSeq[i] !=	null)
					model.setNoteDpSeq( noteDpSeq[i]);
				if ( addChgNoteCtnt[i] !=	null)
					model.setAddChgNoteCtnt( addChgNoteCtnt[i]);
				if ( preNoteDpSeq[i] !=	null)
					model.setPreNoteDpSeq( preNoteDpSeq[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getRsltArbChgListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return RsltArbChgListVO[]
	 */
	public RsltArbChgListVO[]	 getRsltArbChgListVOs(){
		RsltArbChgListVO[] vos = (RsltArbChgListVO[])models.toArray(new	RsltArbChgListVO[models.size()]);
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
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq =	this.amdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCd =	this.routPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coffrFrtRtAmt =	this.coffrFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt =	this.fnlFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsCd =	this.prcProgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortTpCd =	this.bsePortTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd =	this.rcvDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt =	this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxCgoWgt =	this.maxCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocTpCd =	this.routPntLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addChgTpCd =	this.addChgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptDt =	this.acptDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptOfcCd =	this.acptOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefNm =	this.routPntLocDefNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrNm =	this.acptUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrId =	this.acptUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd =	this.srcInfoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd =	this.orgDestTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd =	this.ratUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perType =	this.perType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtRtAmt =	this.propFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortDefCd =	this.bsePortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq =	this.n1stCmncAmdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo =	this.propNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCgoWgt =	this.minCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd =	this.prcTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteDpSeq =	this.noteDpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addChgNoteCtnt =	this.addChgNoteCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preNoteDpSeq =	this.preNoteDpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}