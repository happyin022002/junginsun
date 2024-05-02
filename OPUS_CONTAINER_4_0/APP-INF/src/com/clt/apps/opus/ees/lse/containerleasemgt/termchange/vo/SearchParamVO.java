/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchParamVO.java
*@FileTitle : SearchParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.30 장준우 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Search Param VO Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see ..
 */
public class SearchParamVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;
	
	private Collection<SearchParamVO> models = new ArrayList<SearchParamVO>();
	
	private Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo");

		
	/* Status */
	private String ibflag = null;	
	/* Column Info */
	private String diFlag = null;	
	/* Column Info */
	private String curAgmtCtyCd = null;
	/* Column Info */
	private String curAgmtSeq = null;
	/* Column Info */
	private String aftAgmtCtyCd = null;
	/* Column Info */
	private String aftAgmtSeq = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */	
	private String dcondTp = null;
	/* Column Info */
	private String stsFlag = null;	
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtSeq1 = null;
	/* Column Info */
	private String vndrSeq1 = null;
	/* Column Info */
	private String vndrSeq2 = null;	
	/* Column Info */
	private String curLstmCd = null;
	/* Column Info */
	private String aftLstmCd = null;
	/* Column Info */
	private String aftVndrSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String cntrList = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private  String	 tmpSeq   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 tmpDtlSeq   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 cntrPkupPsvAmt   =  null;
	/*	Column Info	*/
	private  String	 cntrPkupNgvAmt   =  null;
	/*	Column Info	*/
	private  String	 cntrMinOnhDys   =  null;
	/*	Column Info	*/
	private  String	 rntlChgFreeDys   =  null;
	/*	Column Info	*/
	private  String	 diiFee   =  null;
	
	/**
	 * @return the ibflag
	 */
	public String getIbflag() {
		return ibflag;
	}

	/**
	 * @param ibflag the ibflag to set
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * @return the diFlag
	 */
	public String getDiFlag() {
		return diFlag;
	}

	/**
	 * @param diFlag the diFlag to set
	 */
	public void setDiFlag(String diFlag) {
		this.diFlag = diFlag;
	}
	
	/**
	 * @return the aftAgmtCtyCd
	 */
	public String getAftAgmtCtyCd() {
		return aftAgmtCtyCd;
	}

	/**
	 * @param aftAgmtCtyCd the aftAgmtCtyCd to set
	 */
	public void setAftAgmtCtyCd(String aftAgmtCtyCd) {
		this.aftAgmtCtyCd = aftAgmtCtyCd;
	}

	/**
	 * @return the aftAgmtSeq
	 */
	public String getAftAgmtSeq() {
		return aftAgmtSeq;
	}

	/**
	 * @param aftAgmtSeq the aftAgmtSeq to set
	 */
	public void setAftAgmtSeq(String aftAgmtSeq) {
		this.aftAgmtSeq = aftAgmtSeq;
	}

	/**
	 * @return the actDt
	 */
	public String getActDt() {
		return actDt;
	}

	/**
	 * @param actDt the actDt to set
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}

	/**
	 * @return the pagerows
	 */
	public String getPagerows() {
		return pagerows;
	}

	/**
	 * @param pagerows the pagerows to set
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * @return the curAgmtCtyCd
	 */
	public String getCurAgmtCtyCd() {
		return curAgmtCtyCd;
	}

	/**
	 * @param curAgmtCtyCd the curAgmtCtyCd to set
	 */
	public void setCurAgmtCtyCd(String curAgmtCtyCd) {
		this.curAgmtCtyCd = curAgmtCtyCd;
	}

	/**
	 * @return the curAgmtSeq
	 */
	public String getCurAgmtSeq() {
		return curAgmtSeq;
	}

	/**
	 * @param curAgmtSeq the curAgmtSeq to set
	 */
	public void setCurAgmtSeq(String curAgmtSeq) {
		this.curAgmtSeq = curAgmtSeq;
	}

	/**
	 * @return the iPage
	 */
	public int getIPage() {
		return iPage;
	}

	/**
	 * @param page the iPage to set
	 */
	public void setIPage(int page) {
		iPage = page;
	}
	
	/**
	 * @return the stsFlag
	 */
	public String getStsFlag() {
		return stsFlag;
	}

	/**
	 * @param stsFlag the stsFlag to set
	 */
	public void setStsFlag(String stsFlag) {
		this.stsFlag = stsFlag;
	}

	/**
	 * @return the agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return agmtCtyCd;
	}

	/**
	 * @param agmtCtyCd the agmtCtyCd to set
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	/**
	 * @return the agmtSeq
	 */
	public String getAgmtSeq() {
		return agmtSeq;
	}

	/**
	 * @param agmtSeq the agmtSeq to set
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	/**
	 * @return the vndrSeq
	 */
	public String getVndrSeq() {
		return vndrSeq;
	}

	/**
	 * @param vndrSeq the vndrSeq to set
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}	

	/**
	 * @return the dcondTp
	 */
	public String getDcondTp() {
		return dcondTp;
	}

	/**
	 * @param dcondTp the dcondTp to set
	 */
	public void setDcondTp(String dcondTp) {
		this.dcondTp = dcondTp;
	}

	/**
	 * @return the agmtSeq1
	 */
	public String getAgmtSeq1() {
		return agmtSeq1;
	}

	/**
	 * @param agmtSeq1 the agmtSeq1 to set
	 */
	public void setAgmtSeq1(String agmtSeq1) {
		this.agmtSeq1 = agmtSeq1;
	}

	/**
	 * @return the vndrSeq1
	 */
	public String getVndrSeq1() {
		return vndrSeq1;
	}

	/**
	 * @param vndrSeq1 the vndrSeq1 to set
	 */
	public void setVndrSeq1(String vndrSeq1) {
		this.vndrSeq1 = vndrSeq1;
	}

	/**
	 * @return the vndrSeq2
	 */
	public String getVndrSeq2() {
		return vndrSeq2;
	}

	/**
	 * @param vndrSeq2 the vndrSeq2 to set
	 */
	public void setVndrSeq2(String vndrSeq2) {
		this.vndrSeq2 = vndrSeq2;
	}
	
	/**
	 * @return the curLstmCd
	 */
	public String getCurLstmCd() {
		return curLstmCd;
	}

	/**
	 * @param curLstmCd the curLstmCd to set
	 */
	public void setCurLstmCd(String curLstmCd) {
		this.curLstmCd = curLstmCd;
	}
	
	/**
	 * @return the aftLstmCd
	 */
	public String getAftLstmCd() {
		return aftLstmCd;
	}

	/**
	 * @param aftLstmCd the aftLstmCd to set
	 */
	public void setAftLstmCd(String aftLstmCd) {
		this.aftLstmCd = aftLstmCd;
	}
	
	/**
	 * @return the aftVndrSeq
	 */
	public String getAftVndrSeq() {
		return aftVndrSeq;
	}

	/**
	 * @param aftVndrSeq the aftVndrSeq to set
	 */
	public void setAftVndrSeq(String aftVndrSeq) {
		this.aftVndrSeq = aftVndrSeq;
	}
	
	/**
	 * @return the cntrList
	 */
	public String getcntrList() {
		return cntrList;
	}

	/**
	 * @param cntrList the cntrList to set
	 */
	public void setcntrList(String cntrList) {
		this.cntrList = cntrList;
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
	* Column Info
	* @param  tmpSeq
	*/
	public void	setTmpSeq( String	tmpSeq ) {
		this.tmpSeq =	tmpSeq;
	}
 
	/**
	 * Column Info
	 * @return	tmpSeq
	 */
	 public	 String	getTmpSeq() {
		 return	this.tmpSeq;
	 } 
 	/**
	* Column Info
	* @param  creUsrId
	*/
	public void	setCreUsrId( String	creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 
	/**
	 * Column Info
	 * @return	creUsrId
	 */
	 public	 String	getCreUsrId() {
		 return	this.creUsrId;
	 } 
 	/**
	* Column Info
	* @param  updUsrId
	*/
	public void	setUpdUsrId( String	updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 
	/**
	 * Column Info
	 * @return	updUsrId
	 */
	 public	 String	getUpdUsrId() {
		 return	this.updUsrId;
	 } 
 	/**
	* Column Info
	* @param  tmpDtlSeq
	*/
	public void	setTmpDtlSeq( String	tmpDtlSeq ) {
		this.tmpDtlSeq =	tmpDtlSeq;
	}
 
	/**
	 * Column Info
	 * @return	tmpDtlSeq
	 */
	 public	 String	getTmpDtlSeq() {
		 return	this.tmpDtlSeq;
	 } 

	 /**
	* Column Info
	* @param  cntrNo
	*/
	public void	setCntrNo( String	cntrNo ) {
		this.cntrNo =	cntrNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrNo
	 */
	 public	 String	getCntrNo() {
		 return	this.cntrNo;
	 } 
	 
	 /**
	* Column Info
	* @param  cntrPkupPsvAmt
	*/
	public void	setCntrPkupPsvAmt( String	cntrPkupPsvAmt ) {
		this.cntrPkupPsvAmt =	cntrPkupPsvAmt;
	}
 
	/**
	 * Column Info
	 * @return	cntrPkupPsvAmt
	 */
	 public	 String	getCntrPkupPsvAmt() {
		 return	this.cntrPkupPsvAmt;
	 } 
 	/**
	* Column Info
	* @param  cntrPkupNgvAmt
	*/
	public void	setCntrPkupNgvAmt( String	cntrPkupNgvAmt ) {
		this.cntrPkupNgvAmt =	cntrPkupNgvAmt;
	}
 
	/**
	 * Column Info
	 * @return	cntrPkupNgvAmt
	 */
	 public	 String	getCntrPkupNgvAmt() {
		 return	this.cntrPkupNgvAmt;
	 } 
 	/**
	* Column Info
	* @param  cntrMinOnhDys
	*/
	public void	setCntrMinOnhDys( String	cntrMinOnhDys ) {
		this.cntrMinOnhDys =	cntrMinOnhDys;
	}
 
	/**
	 * Column Info
	 * @return	cntrMinOnhDys
	 */
	 public	 String	getCntrMinOnhDys() {
		 return	this.cntrMinOnhDys;
	 } 
 	/**
	* Column Info
	* @param  rntlChgFreeDys
	*/
	public void	setRntlChgFreeDys( String	rntlChgFreeDys ) {
		this.rntlChgFreeDys =	rntlChgFreeDys;
	}
 
	/**
	 * Column Info
	 * @return	rntlChgFreeDys
	 */
	 public	 String	getRntlChgFreeDys() {
		 return	this.rntlChgFreeDys;
	 } 
 	/**
	* Column Info
	* @param  diiFee
	*/
	public void	setDiiFee( String	diiFee ) {
		this.diiFee =	diiFee;
	}
 
	/**
	 * Column Info
	 * @return	diiFee
	 */
	 public	 String	getDiiFee() {
		 return	this.diiFee;
	 } 


	/* Column Info */
	private int iPage = 1;
	
	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * Constructor
	 */
	public SearchParamVO() {}

	/**
	 * Constructor
	 */
	public SearchParamVO(String ibflag, String pagerows, String diFlag, String curAgmtCtyCd, String curAgmtSeq, String aftAgmtCtyCd, String aftAgmtSeq, String actDt,
					String dcondTp, String stsFlag, String agmtCtyCd, String agmtSeq, String vndrSeq,
					String agmtSeq1, String vndrSeq1, String vndrSeq2, String curLstmCd, String aftLstmCd, String aftVndrSeq, String ofcCd, String cntrList,String tmpSeq,String creUsrId,String updUsrId,String tmpDtlSeq,String cntrNo
					,String cntrPkupPsvAmt,String cntrPkupNgvAmt,String cntrMinOnhDys,String rntlChgFreeDys,String diiFee) {
		this.diFlag = diFlag;
		this.ibflag = ibflag;
		this.curAgmtCtyCd = curAgmtCtyCd;
		this.curAgmtSeq = curAgmtSeq;
		this.aftAgmtCtyCd = aftAgmtCtyCd;
		this.aftAgmtSeq = aftAgmtSeq;
		this.actDt = actDt;
		this.dcondTp = dcondTp;
		this.stsFlag = stsFlag;
		this.agmtCtyCd = agmtCtyCd;
		this.agmtSeq = agmtSeq;
		this.vndrSeq = vndrSeq;		
		this.agmtSeq1 = agmtSeq1;
		this.vndrSeq1 = vndrSeq1;
		this.vndrSeq2 = vndrSeq2;	
		this.curLstmCd = curLstmCd;
		this.aftLstmCd = aftLstmCd;
		this.aftVndrSeq = aftVndrSeq;
		this.ofcCd = ofcCd;
		this.cntrList = cntrList;
		this.pagerows = pagerows;
		this.tmpSeq  = tmpSeq ;
		this.creUsrId  = creUsrId ;
		this.updUsrId  = updUsrId ;
		this.tmpDtlSeq  = tmpDtlSeq ;
		this.cntrNo  = cntrNo ;
		this.cntrPkupPsvAmt  = cntrPkupPsvAmt ;
		this.cntrPkupNgvAmt  = cntrPkupNgvAmt ;
		this.cntrMinOnhDys  = cntrMinOnhDys ;
		this.rntlChgFreeDys  = rntlChgFreeDys ;
		this.diiFee  = diiFee ;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("di_flag", getDiFlag());
		this.hashColumns.put("cur_agmt_cty_cd", getCurAgmtCtyCd());
		this.hashColumns.put("cur_agmt_seq", getCurAgmtSeq());
		this.hashColumns.put("aft_agmt_cty_cd", getAftAgmtCtyCd());
		this.hashColumns.put("aft_agmt_seq", getAftAgmtSeq());
		this.hashColumns.put("act_dt", getActDt());		
		this.hashColumns.put("dcond_tp", getDcondTp());
		this.hashColumns.put("sts_flag", getStsFlag());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("agmt_seq1", getAgmtSeq1());
		this.hashColumns.put("vndr_seq1", getVndrSeq1());
		this.hashColumns.put("vndr_seq2", getVndrSeq2());	
		this.hashColumns.put("cur_lstm_cd", getCurLstmCd());
		this.hashColumns.put("aft_lstm_cd", getAftLstmCd());		
		this.hashColumns.put("aft_vndr_seq", getAftVndrSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cntr_list", getcntrList());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tmp_seq", getTmpSeq());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("tmp_dtl_seq", getTmpDtlSeq());	
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("cntr_pkup_psv_amt", getCntrPkupPsvAmt());		
		this.hashColumns.put("cntr_pkup_ngv_amt", getCntrPkupNgvAmt());		
		this.hashColumns.put("cntr_min_onh_dys", getCntrMinOnhDys());		
		this.hashColumns.put("rntl_chg_free_dys", getRntlChgFreeDys());		
		this.hashColumns.put("dii_fee", getDiiFee());		
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("di_flag", "diFlag");
		this.hashFields.put("cur_agmt_cty_cd", "curAgmtCtyCd");
		this.hashFields.put("cur_agmt_seq", "curAgmtSeq");
		this.hashFields.put("aft_agmt_cty_cd", "aftAgmtCtyCd");
		this.hashFields.put("aft_agmt_seq", "aftAgmtSeq");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("dcond_tp", "dcondTp");
		this.hashFields.put("sts_flag", "stsFlag");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_seq1", "agmtSeq1");
		this.hashFields.put("vndr_seq1", "vndrSeq1");
		this.hashFields.put("vndr_seq2", "vndrSeq2");	
		this.hashFields.put("cur_lstm_cd", "curLstmCd");
		this.hashFields.put("aft_lstm_cd", "aftLstmCd");
		this.hashFields.put("aft_vndr_seq", "aftVndrSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashColumns.put("cntr_list", getcntrList());
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tmp_seq", "tmpSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("tmp_dtl_seq", "tmpDtlSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_pkup_psv_amt", "cntrPkupPsvAmt");
		this.hashFields.put("cntr_pkup_ngv_amt", "cntrPkupNgvAmt");
		this.hashFields.put("cntr_min_onh_dys", "cntrMinOnhDys");
		this.hashFields.put("rntl_chg_free_dys", "rntlChgFreeDys");
		this.hashFields.put("dii_fee", "diiFee");
		return this.hashFields;
	}
	
	/**
	 * hasHttpServletRequestInfo
	 * @return
	 */
	public void fromRequest(HttpServletRequest request) {
		
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDiFlag(JSPUtil.getParameter(request, "di_flag", ""));
		setCurAgmtCtyCd(JSPUtil.getParameter(request, "cur_agmt_cty_cd", ""));
		setCurAgmtSeq(JSPUtil.getParameter(request, "cur_agmt_seq", ""));
		setAftAgmtCtyCd(JSPUtil.getParameter(request, "aft_agmt_cty_cd", ""));
		setAftAgmtSeq(JSPUtil.getParameter(request, "aft_agmt_seq", ""));
		setActDt(JSPUtil.getParameter(request, "act_dt", "").replaceAll("-", ""));		
		setDcondTp(JSPUtil.getParameter(request, "dcond_tp", ""));
		setStsFlag(JSPUtil.getParameter(request, "sts_flag", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtSeq1(JSPUtil.getParameter(request, "agmt_seq1", ""));
		setVndrSeq1(JSPUtil.getParameter(request, "vndr_seq1", ""));
		setVndrSeq2(JSPUtil.getParameter(request, "vndr_seq2", ""));	
		setCurLstmCd(JSPUtil.getParameter(request, "cur_lstm_cd", ""));
		setAftLstmCd(JSPUtil.getParameter(request, "aft_lstm_cd", ""));
		setAftVndrSeq(JSPUtil.getParameter(request, "aft_vndr_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setcntrList(JSPUtil.getParameter(request, "cntr_list", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIPage(JSPUtil.getParameterAsInt(request, "iPage", 1));
		setTmpSeq(JSPUtil.getParameter(request,	 "tmp_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request,	 "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	 "upd_usr_id", ""));
		setTmpDtlSeq(JSPUtil.getParameter(request,	 "tmp_dtl_seq", ""));
		setCntrNo(JSPUtil.getParameter(request,	 "cntr_no", ""));
		setCntrPkupPsvAmt(JSPUtil.getParameter(request,	 "cntr_pkup_psv_amt", ""));
		setCntrPkupNgvAmt(JSPUtil.getParameter(request,	 "cntr_pkup_ngv_amt", ""));
		setCntrMinOnhDys(JSPUtil.getParameter(request,	 "cntr_min_onh_dys", ""));
		setRntlChgFreeDys(JSPUtil.getParameter(request,	 "rntl_chg_free_dys", ""));
		setDiiFee(JSPUtil.getParameter(request,	 "dii_fee", ""));
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public SearchParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}
	
	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public SearchParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] diFlag = (JSPUtil.getParameter(request, prefix	+ "di_flag".trim(), length));
			String[] curAgmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "cur_agmt_cty_cd".trim(), length));
			String[] curAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "cur_agmt_seq".trim(), length));
			String[] aftAgmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "aft_agmt_cty_cd".trim(), length));
			String[] aftAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "aft_agmt_seq".trim(), length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt".trim(), length));			
			String[] dcondTp = (JSPUtil.getParameter(request, prefix	+ "dcond_tp".trim(), length));
			String[] stsFlag = (JSPUtil.getParameter(request, prefix	+ "sts_flag".trim(), length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd".trim(), length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq".trim(), length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq".trim(), length));
			String[] agmtSeq1 = (JSPUtil.getParameter(request, prefix	+ "agmt_seq1".trim(), length));
			String[] vndrSeq1 = (JSPUtil.getParameter(request, prefix	+ "vndr_seq1".trim(), length));
			String[] vndrSeq2 = (JSPUtil.getParameter(request, prefix	+ "vndr_seq2".trim(), length));	
			String[] curLstmCd = (JSPUtil.getParameter(request, prefix	+ "cur_lstm_cd".trim(), length));
			String[] aftLstmCd = (JSPUtil.getParameter(request, prefix	+ "aft_lstm_cd".trim(), length));
			String[] aftVndrSeq = (JSPUtil.getParameter(request, prefix	+ "aft_vndr_seq".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] cntrList = (JSPUtil.getParameter(request, prefix	+ "cntr_list".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] tmpSeq =	(JSPUtil.getParameter(request, prefix +	"tmp_seq".trim(),	length));
			String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
			String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
			String[] tmpDtlSeq =	(JSPUtil.getParameter(request, prefix +	"tmp_dtl_seq".trim(),	length));
			String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
			String[] cntrPkupPsvAmt =	(JSPUtil.getParameter(request, prefix +	"cntr_pkup_psv_amt".trim(),	length));
			String[] cntrPkupNgvAmt =	(JSPUtil.getParameter(request, prefix +	"cntr_pkup_ngv_amt".trim(),	length));
			String[] cntrMinOnhDys =	(JSPUtil.getParameter(request, prefix +	"cntr_min_onh_dys".trim(),	length));
			String[] rntlChgFreeDys =	(JSPUtil.getParameter(request, prefix +	"rntl_chg_free_dys".trim(),	length));
			String[] diiFee =	(JSPUtil.getParameter(request, prefix +	"dii_fee".trim(),	length));
			for (int i = 0; i < length; i++) {
				model = new SearchParamVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diFlag[i] != null)				
					model.setDiFlag(diFlag[i]);
				if (curAgmtCtyCd[i] != null)
					model.setCurAgmtCtyCd(curAgmtCtyCd[i]);
				if (curAgmtSeq[i] != null)
					model.setCurAgmtSeq(curAgmtSeq[i]);
				if (aftAgmtCtyCd[i] != null)
					model.setAftAgmtCtyCd(aftAgmtCtyCd[i]);
				if (aftAgmtSeq[i] != null)
					model.setAftAgmtSeq(aftAgmtSeq[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (dcondTp[i] != null)
					model.setDcondTp(dcondTp[i]);
				if (stsFlag[i] != null)
					model.setStsFlag(stsFlag[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtSeq1[i] != null)
					model.setAgmtSeq1(agmtSeq1[i]);
				if (vndrSeq1[i] != null)
					model.setVndrSeq1(vndrSeq1[i]);
				if (vndrSeq2[i] != null)
					model.setVndrSeq2(vndrSeq2[i]);	
				if (curLstmCd[i] != null)
					model.setCurLstmCd(curLstmCd[i]);
				if (aftLstmCd[i] != null)
					model.setAftLstmCd(aftLstmCd[i]);
				if (aftVndrSeq[i] != null)
					model.setVndrSeq(aftVndrSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (cntrList[i] != null)
					model.setcntrList(cntrList[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if ( tmpSeq[i] !=	null)
					model.setTmpSeq( tmpSeq[i]);
				if ( creUsrId[i] !=	null)
					model.setCreUsrId( creUsrId[i]);
				if ( updUsrId[i] !=	null)
					model.setUpdUsrId( updUsrId[i]);
				if ( tmpDtlSeq[i] !=	null)
					model.setTmpDtlSeq( tmpDtlSeq[i]);
				if ( cntrNo[i] !=	null)
					model.setCntrNo( cntrNo[i]);
				if ( cntrPkupPsvAmt[i] !=	null)
					model.setCntrPkupPsvAmt( cntrPkupPsvAmt[i]);
				if ( cntrPkupNgvAmt[i] !=	null)
					model.setCntrPkupNgvAmt( cntrPkupNgvAmt[i]);
				if ( cntrMinOnhDys[i] !=	null)
					model.setCntrMinOnhDys( cntrMinOnhDys[i]);
				if ( rntlChgFreeDys[i] !=	null)
					model.setRntlChgFreeDys( rntlChgFreeDys[i]);
				if ( diiFee[i] !=	null)
					model.setDiiFee( diiFee[i]);
				models.add(model);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return getSearchParamVOs();
	}

	public SearchParamVO[] getSearchParamVOs(){
		SearchParamVO[] vos = (SearchParamVO[])models.toArray(new SearchParamVO[models.size()]);
		return vos;
	}
	
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
			log.error(ex.getMessage(), ex);
		}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
			log.error(ex.getMessage(), ex);
			throw new IllegalAccessException(ex.getMessage());
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){		
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diFlag = this.diFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curAgmtCtyCd = this.curAgmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curAgmtSeq = this.curAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftAgmtCtyCd = this.aftAgmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftAgmtSeq = this.aftAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.dcondTp = this.dcondTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsFlag = this.stsFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq1 = this.agmtSeq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq1 = this.vndrSeq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq2 = this.vndrSeq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.curLstmCd = this.curLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftLstmCd = this.aftLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftVndrSeq = this.aftVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrList = this.cntrList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpSeq =	this.tmpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpDtlSeq =	this.tmpDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupPsvAmt =	this.cntrPkupPsvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupNgvAmt =	this.cntrPkupNgvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMinOnhDys =	this.cntrMinOnhDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlChgFreeDys =	this.rntlChgFreeDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diiFee =	this.diiFee.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}