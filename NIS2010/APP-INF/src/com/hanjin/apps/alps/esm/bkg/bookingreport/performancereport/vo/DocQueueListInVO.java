/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : DocQueueListInVO.java
 *@FileTitle : DocQueueListInVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.01.06
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.01.06  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class DocQueueListInVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<DocQueueListInVO>  models =	new	ArrayList<DocQueueListInVO>();


	/*	Column Info	*/
	private  String	 region   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 svrCd   =  null;
	/*	Column Info	*/
	private  String	 srepCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 srKndCd   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 rowsPerPage   =  null;
	/*	Column Info	*/
	private  String	 splitOnlyFlg   =  null;
	/*	Column Info	*/
	private  String	 rate   =  null;
	/*	Column Info	*/
	private  String	 currPage   =  null;
	/*	Column Info	*/
	private  String	 vvdCd   =  null;
	/*	Column Info	*/
	private  String	 returnTo   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 duraToDt   =  null;
	/*	Column Info	*/
	private  String	 srAmdTpCd   =  null;
	/*	Column Info	*/
	private  String	 curQueue   =  null;
	/*	Column Info	*/
	private  String	 setQryWhere   =  null;
	/*	Column Info	*/
	private  String	 bkgCustTpCd   =  null;
	/*	Column Info	*/
	private  String	 custCntCd   =  null;
	/*	Column Info	*/
	private  String	 duraFromDt   =  null;
	/*	Column Info	*/
	private  String	 bkgOfcCd   =  null;
	/*	Column Info	*/
	private  String	 srcCd   =  null;
	/*	Column Info	*/
	private  String	 fax   =  null;
	/*	Column Info	*/
	private  String	 pendingOnly   =  null;
	/*	Column Info	*/
	private  String	 custSeq   =  null;
	/*	Column Info	*/
	private  String	 qa   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 queueStatus   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 input   =  null;
	/*	Column Info	*/
	private  String	 slanCd   =  null;
	/*	Column Info	*/
	private  String	 sts   =  null;
	/*	Column Info	*/
	private  String	 setSlctFlg   =  null;
	/*	Column Info	*/
	private  String	 prtCd   =  null;
	/*	Column Info	*/
	private  String	 picId   =  null;
	/*	Column Info	*/
	private  String	 picCngId   =  null;
	/*	Column Info	*/
	private  String	 prdFlg   =  null;
	/*	Column Info	*/
	private  String	 dpcsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 bkgCtrtTpCd   =  null;
	/*	Column Info	*/
	private  String	 contractNo   =  null;
	/*	Column Info	*/
	private  String	 returnTpCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public DocQueueListInVO(){}

	public DocQueueListInVO(String region,String custNm,String svrCd,String srepCd,String pagerows,String srKndCd,String polCd,String ibflag,String rowsPerPage,String splitOnlyFlg,String rate,String currPage,String vvdCd,String returnTo,String usrId,String duraToDt,String srAmdTpCd,String curQueue,String setQryWhere,String bkgCustTpCd,String custCntCd,String duraFromDt,String bkgOfcCd,String srcCd,String fax,String pendingOnly,String custSeq,String qa,String podCd,String ofcCd,String queueStatus,String bkgNo,String input,String slanCd,String sts,String setSlctFlg,String prtCd,String picId,String picCngId,String prdFlg,String dpcsOfcCd,String bkgCtrtTpCd,String contractNo,String returnTpCd)	{
		this.region  = region ;
		this.custNm  = custNm ;
		this.svrCd  = svrCd ;
		this.srepCd  = srepCd ;
		this.pagerows  = pagerows ;
		this.srKndCd  = srKndCd ;
		this.polCd  = polCd ;
		this.ibflag  = ibflag ;
		this.rowsPerPage  = rowsPerPage ;
		this.splitOnlyFlg  = splitOnlyFlg ;
		this.rate  = rate ;
		this.currPage  = currPage ;
		this.vvdCd  = vvdCd ;
		this.returnTo  = returnTo ;
		this.usrId  = usrId ;
		this.duraToDt  = duraToDt ;
		this.srAmdTpCd  = srAmdTpCd ;
		this.curQueue  = curQueue ;
		this.setQryWhere  = setQryWhere ;
		this.bkgCustTpCd  = bkgCustTpCd ;
		this.custCntCd  = custCntCd ;
		this.duraFromDt  = duraFromDt ;
		this.bkgOfcCd  = bkgOfcCd ;
		this.srcCd  = srcCd ;
		this.fax  = fax ;
		this.pendingOnly  = pendingOnly ;
		this.custSeq  = custSeq ;
		this.qa  = qa ;
		this.podCd  = podCd ;
		this.ofcCd  = ofcCd ;
		this.queueStatus  = queueStatus ;
		this.bkgNo  = bkgNo ;
		this.input  = input ;
		this.slanCd  = slanCd ;
		this.sts  = sts ;
		this.setSlctFlg  = setSlctFlg ;
		this.prtCd  = prtCd ;
		this.picId  = picId ;
		this.picCngId  = picCngId ;
		this.prdFlg  = prdFlg ;
		this.dpcsOfcCd  = dpcsOfcCd ;
		this.bkgCtrtTpCd  = bkgCtrtTpCd ;
		this.contractNo  = contractNo ;
		this.returnTpCd  = returnTpCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("region", getRegion());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("svr_cd", getSvrCd());		
		this.hashColumns.put("srep_cd", getSrepCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("sr_knd_cd", getSrKndCd());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("rows_per_page", getRowsPerPage());		
		this.hashColumns.put("split_only_flg", getSplitOnlyFlg());		
		this.hashColumns.put("rate", getRate());		
		this.hashColumns.put("curr_page", getCurrPage());		
		this.hashColumns.put("vvd_cd", getVvdCd());		
		this.hashColumns.put("return_to", getReturnTo());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("dura_to_dt", getDuraToDt());		
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());		
		this.hashColumns.put("cur_queue", getCurQueue());		
		this.hashColumns.put("set_qry_where", getSetQryWhere());		
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());		
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());		
		this.hashColumns.put("dura_from_dt", getDuraFromDt());		
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());		
		this.hashColumns.put("src_cd", getSrcCd());		
		this.hashColumns.put("fax", getFax());		
		this.hashColumns.put("pending_only", getPendingOnly());		
		this.hashColumns.put("cust_seq", getCustSeq());		
		this.hashColumns.put("qa", getQa());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("queue_status", getQueueStatus());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("input", getInput());		
		this.hashColumns.put("slan_cd", getSlanCd());		
		this.hashColumns.put("sts", getSts());		
		this.hashColumns.put("set_slct_flg", getSetSlctFlg());		
		this.hashColumns.put("prt_cd", getPrtCd());		
		this.hashColumns.put("pic_id", getPicId());		
		this.hashColumns.put("pic_cng_id", getPicCngId());		
		this.hashColumns.put("prd_flg", getPrdFlg());		
		this.hashColumns.put("dpcs_ofc_cd", getDpcsOfcCd());		
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());		
		this.hashColumns.put("contract_no", getContractNo());		
		this.hashColumns.put("return_tp_cd", getReturnTpCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("region", "region");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("svr_cd", "svrCd");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("split_only_flg", "splitOnlyFlg");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("return_to", "returnTo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("dura_to_dt", "duraToDt");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("cur_queue", "curQueue");
		this.hashFields.put("set_qry_where", "setQryWhere");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("dura_from_dt", "duraFromDt");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("src_cd", "srcCd");
		this.hashFields.put("fax", "fax");
		this.hashFields.put("pending_only", "pendingOnly");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("qa", "qa");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("queue_status", "queueStatus");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("input", "input");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("sts", "sts");
		this.hashFields.put("set_slct_flg", "setSlctFlg");
		this.hashFields.put("prt_cd", "prtCd");
		this.hashFields.put("pic_id", "picId");
		this.hashFields.put("pic_cng_id", "picCngId");
		this.hashFields.put("prd_flg", "prdFlg");
		this.hashFields.put("dpcs_ofc_cd", "dpcsOfcCd");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("contract_no", "contractNo");
		this.hashFields.put("return_tp_cd", "returnTpCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  region
	*/
	public void	setRegion( String	region ) {
		this.region =	region;
	}
 
	/**
	 * Column Info
	 * @return	region
	 */
	 public	 String	getRegion() {
		 return	this.region;
	 } 
 	/**
	* Column Info
	* @param  custNm
	*/
	public void	setCustNm( String	custNm ) {
		this.custNm =	custNm;
	}
 
	/**
	 * Column Info
	 * @return	custNm
	 */
	 public	 String	getCustNm() {
		 return	this.custNm;
	 } 
 	/**
	* Column Info
	* @param  svrCd
	*/
	public void	setSvrCd( String	svrCd ) {
		this.svrCd =	svrCd;
	}
 
	/**
	 * Column Info
	 * @return	svrCd
	 */
	 public	 String	getSvrCd() {
		 return	this.svrCd;
	 } 
 	/**
	* Column Info
	* @param  srepCd
	*/
	public void	setSrepCd( String	srepCd ) {
		this.srepCd =	srepCd;
	}
 
	/**
	 * Column Info
	 * @return	srepCd
	 */
	 public	 String	getSrepCd() {
		 return	this.srepCd;
	 } 
 	/**
	* Column Info
	* @param  pagerows
	*/
	public void	setPagerows( String	pagerows ) {
		this.pagerows =	pagerows;
	}
 
	/**
	 * Column Info
	 * @return	pagerows
	 */
	 public	 String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  srKndCd
	*/
	public void	setSrKndCd( String	srKndCd ) {
		this.srKndCd =	srKndCd;
	}
 
	/**
	 * Column Info
	 * @return	srKndCd
	 */
	 public	 String	getSrKndCd() {
		 return	this.srKndCd;
	 } 
 	/**
	* Column Info
	* @param  polCd
	*/
	public void	setPolCd( String	polCd ) {
		this.polCd =	polCd;
	}
 
	/**
	 * Column Info
	 * @return	polCd
	 */
	 public	 String	getPolCd() {
		 return	this.polCd;
	 } 
 	/**
	* Column Info
	* @param  ibflag
	*/
	public void	setIbflag( String	ibflag ) {
		this.ibflag =	ibflag;
	}
 
	/**
	 * Column Info
	 * @return	ibflag
	 */
	 public	 String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  rowsPerPage
	*/
	public void	setRowsPerPage( String	rowsPerPage ) {
		this.rowsPerPage =	rowsPerPage;
	}
 
	/**
	 * Column Info
	 * @return	rowsPerPage
	 */
	 public	 String	getRowsPerPage() {
		 return	this.rowsPerPage;
	 } 
 	/**
	* Column Info
	* @param  splitOnlyFlg
	*/
	public void	setSplitOnlyFlg( String	splitOnlyFlg ) {
		this.splitOnlyFlg =	splitOnlyFlg;
	}
 
	/**
	 * Column Info
	 * @return	splitOnlyFlg
	 */
	 public	 String	getSplitOnlyFlg() {
		 return	this.splitOnlyFlg;
	 } 
 	/**
	* Column Info
	* @param  rate
	*/
	public void	setRate( String	rate ) {
		this.rate =	rate;
	}
 
	/**
	 * Column Info
	 * @return	rate
	 */
	 public	 String	getRate() {
		 return	this.rate;
	 } 
 	/**
	* Column Info
	* @param  currPage
	*/
	public void	setCurrPage( String	currPage ) {
		this.currPage =	currPage;
	}
 
	/**
	 * Column Info
	 * @return	currPage
	 */
	 public	 String	getCurrPage() {
		 return	this.currPage;
	 } 
 	/**
	* Column Info
	* @param  vvdCd
	*/
	public void	setVvdCd( String	vvdCd ) {
		this.vvdCd =	vvdCd;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd
	 */
	 public	 String	getVvdCd() {
		 return	this.vvdCd;
	 } 
 	/**
	* Column Info
	* @param  returnTo
	*/
	public void	setReturnTo( String	returnTo ) {
		this.returnTo =	returnTo;
	}
 
	/**
	 * Column Info
	 * @return	returnTo
	 */
	 public	 String	getReturnTo() {
		 return	this.returnTo;
	 } 
 	/**
	* Column Info
	* @param  usrId
	*/
	public void	setUsrId( String	usrId ) {
		this.usrId =	usrId;
	}
 
	/**
	 * Column Info
	 * @return	usrId
	 */
	 public	 String	getUsrId() {
		 return	this.usrId;
	 } 
 	/**
	* Column Info
	* @param  duraToDt
	*/
	public void	setDuraToDt( String	duraToDt ) {
		this.duraToDt =	duraToDt;
	}
 
	/**
	 * Column Info
	 * @return	duraToDt
	 */
	 public	 String	getDuraToDt() {
		 return	this.duraToDt;
	 } 
 	/**
	* Column Info
	* @param  srAmdTpCd
	*/
	public void	setSrAmdTpCd( String	srAmdTpCd ) {
		this.srAmdTpCd =	srAmdTpCd;
	}
 
	/**
	 * Column Info
	 * @return	srAmdTpCd
	 */
	 public	 String	getSrAmdTpCd() {
		 return	this.srAmdTpCd;
	 } 
 	/**
	* Column Info
	* @param  curQueue
	*/
	public void	setCurQueue( String	curQueue ) {
		this.curQueue =	curQueue;
	}
 
	/**
	 * Column Info
	 * @return	curQueue
	 */
	 public	 String	getCurQueue() {
		 return	this.curQueue;
	 } 
 	/**
	* Column Info
	* @param  setQryWhere
	*/
	public void	setSetQryWhere( String	setQryWhere ) {
		this.setQryWhere =	setQryWhere;
	}
 
	/**
	 * Column Info
	 * @return	setQryWhere
	 */
	 public	 String	getSetQryWhere() {
		 return	this.setQryWhere;
	 } 
 	/**
	* Column Info
	* @param  bkgCustTpCd
	*/
	public void	setBkgCustTpCd( String	bkgCustTpCd ) {
		this.bkgCustTpCd =	bkgCustTpCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgCustTpCd
	 */
	 public	 String	getBkgCustTpCd() {
		 return	this.bkgCustTpCd;
	 } 
 	/**
	* Column Info
	* @param  custCntCd
	*/
	public void	setCustCntCd( String	custCntCd ) {
		this.custCntCd =	custCntCd;
	}
 
	/**
	 * Column Info
	 * @return	custCntCd
	 */
	 public	 String	getCustCntCd() {
		 return	this.custCntCd;
	 } 
 	/**
	* Column Info
	* @param  duraFromDt
	*/
	public void	setDuraFromDt( String	duraFromDt ) {
		this.duraFromDt =	duraFromDt;
	}
 
	/**
	 * Column Info
	 * @return	duraFromDt
	 */
	 public	 String	getDuraFromDt() {
		 return	this.duraFromDt;
	 } 
 	/**
	* Column Info
	* @param  bkgOfcCd
	*/
	public void	setBkgOfcCd( String	bkgOfcCd ) {
		this.bkgOfcCd =	bkgOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgOfcCd
	 */
	 public	 String	getBkgOfcCd() {
		 return	this.bkgOfcCd;
	 } 
 	/**
	* Column Info
	* @param  srcCd
	*/
	public void	setSrcCd( String	srcCd ) {
		this.srcCd =	srcCd;
	}
 
	/**
	 * Column Info
	 * @return	srcCd
	 */
	 public	 String	getSrcCd() {
		 return	this.srcCd;
	 } 
 	/**
	* Column Info
	* @param  fax
	*/
	public void	setFax( String	fax ) {
		this.fax =	fax;
	}
 
	/**
	 * Column Info
	 * @return	fax
	 */
	 public	 String	getFax() {
		 return	this.fax;
	 } 
 	/**
	* Column Info
	* @param  pendingOnly
	*/
	public void	setPendingOnly( String	pendingOnly ) {
		this.pendingOnly =	pendingOnly;
	}
 
	/**
	 * Column Info
	 * @return	pendingOnly
	 */
	 public	 String	getPendingOnly() {
		 return	this.pendingOnly;
	 } 
 	/**
	* Column Info
	* @param  custSeq
	*/
	public void	setCustSeq( String	custSeq ) {
		this.custSeq =	custSeq;
	}
 
	/**
	 * Column Info
	 * @return	custSeq
	 */
	 public	 String	getCustSeq() {
		 return	this.custSeq;
	 } 
 	/**
	* Column Info
	* @param  qa
	*/
	public void	setQa( String	qa ) {
		this.qa =	qa;
	}
 
	/**
	 * Column Info
	 * @return	qa
	 */
	 public	 String	getQa() {
		 return	this.qa;
	 } 
 	/**
	* Column Info
	* @param  podCd
	*/
	public void	setPodCd( String	podCd ) {
		this.podCd =	podCd;
	}
 
	/**
	 * Column Info
	 * @return	podCd
	 */
	 public	 String	getPodCd() {
		 return	this.podCd;
	 } 
 	/**
	* Column Info
	* @param  ofcCd
	*/
	public void	setOfcCd( String	ofcCd ) {
		this.ofcCd =	ofcCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcCd
	 */
	 public	 String	getOfcCd() {
		 return	this.ofcCd;
	 } 
 	/**
	* Column Info
	* @param  queueStatus
	*/
	public void	setQueueStatus( String	queueStatus ) {
		this.queueStatus =	queueStatus;
	}
 
	/**
	 * Column Info
	 * @return	queueStatus
	 */
	 public	 String	getQueueStatus() {
		 return	this.queueStatus;
	 } 
 	/**
	* Column Info
	* @param  bkgNo
	*/
	public void	setBkgNo( String	bkgNo ) {
		this.bkgNo =	bkgNo;
	}
 
	/**
	 * Column Info
	 * @return	bkgNo
	 */
	 public	 String	getBkgNo() {
		 return	this.bkgNo;
	 } 
 	/**
	* Column Info
	* @param  input
	*/
	public void	setInput( String	input ) {
		this.input =	input;
	}
 
	/**
	 * Column Info
	 * @return	input
	 */
	 public	 String	getInput() {
		 return	this.input;
	 } 
 	/**
	* Column Info
	* @param  slanCd
	*/
	public void	setSlanCd( String	slanCd ) {
		this.slanCd =	slanCd;
	}
 
	/**
	 * Column Info
	 * @return	slanCd
	 */
	 public	 String	getSlanCd() {
		 return	this.slanCd;
	 } 
 	/**
	* Column Info
	* @param  sts
	*/
	public void	setSts( String	sts ) {
		this.sts =	sts;
	}
 
	/**
	 * Column Info
	 * @return	sts
	 */
	 public	 String	getSts() {
		 return	this.sts;
	 } 
 	/**
	* Column Info
	* @param  setSlctFlg
	*/
	public void	setSetSlctFlg( String	setSlctFlg ) {
		this.setSlctFlg =	setSlctFlg;
	}
 
	/**
	 * Column Info
	 * @return	setSlctFlg
	 */
	 public	 String	getSetSlctFlg() {
		 return	this.setSlctFlg;
	 } 
 	/**
	* Column Info
	* @param  prtCd
	*/
	public void	setPrtCd( String	prtCd ) {
		this.prtCd =	prtCd;
	}
 
	/**
	 * Column Info
	 * @return	prtCd
	 */
	 public	 String	getPrtCd() {
		 return	this.prtCd;
	 } 
 	/**
	* Column Info
	* @param  picId
	*/
	public void	setPicId( String	picId ) {
		this.picId =	picId;
	}
 
	/**
	 * Column Info
	 * @return	picId
	 */
	 public	 String	getPicId() {
		 return	this.picId;
	 } 
 	/**
	* Column Info
	* @param  picCngId
	*/
	public void	setPicCngId( String	picCngId ) {
		this.picCngId =	picCngId;
	}
 
	/**
	 * Column Info
	 * @return	picCngId
	 */
	 public	 String	getPicCngId() {
		 return	this.picCngId;
	 } 
 	/**
	* Column Info
	* @param  prdFlg
	*/
	public void	setPrdFlg( String	prdFlg ) {
		this.prdFlg =	prdFlg;
	}
 
	/**
	 * Column Info
	 * @return	prdFlg
	 */
	 public	 String	getPrdFlg() {
		 return	this.prdFlg;
	 } 
 	/**
	* Column Info
	* @param  dpcsOfcCd
	*/
	public void	setDpcsOfcCd( String	dpcsOfcCd ) {
		this.dpcsOfcCd =	dpcsOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	dpcsOfcCd
	 */
	 public	 String	getDpcsOfcCd() {
		 return	this.dpcsOfcCd;
	 } 
 	/**
	* Column Info
	* @param  bkgCtrtTpCd
	*/
	public void	setBkgCtrtTpCd( String	bkgCtrtTpCd ) {
		this.bkgCtrtTpCd =	bkgCtrtTpCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgCtrtTpCd
	 */
	 public	 String	getBkgCtrtTpCd() {
		 return	this.bkgCtrtTpCd;
	 } 
 	/**
	* Column Info
	* @param  contractNo
	*/
	public void	setContractNo( String	contractNo ) {
		this.contractNo =	contractNo;
	}
 
	/**
	 * Column Info
	 * @return	contractNo
	 */
	 public	 String	getContractNo() {
		 return	this.contractNo;
	 } 
 	/**
	* Column Info
	* @param  returnTpCd
	*/
	public void	setReturnTpCd( String	returnTpCd ) {
		this.returnTpCd =	returnTpCd;
	}
 
	/**
	 * Column Info
	 * @return	returnTpCd
	 */
	 public	 String	getReturnTpCd() {
		 return	this.returnTpCd;
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
		setRegion(JSPUtil.getParameter(request,	prefix + "region", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setSvrCd(JSPUtil.getParameter(request,	prefix + "svr_cd", ""));
		setSrepCd(JSPUtil.getParameter(request,	prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setSrKndCd(JSPUtil.getParameter(request,	prefix + "sr_knd_cd", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setRowsPerPage(JSPUtil.getParameter(request,	prefix + "rows_per_page", ""));
		setSplitOnlyFlg(JSPUtil.getParameter(request,	prefix + "split_only_flg", ""));
		setRate(JSPUtil.getParameter(request,	prefix + "rate", ""));
		setCurrPage(JSPUtil.getParameter(request,	prefix + "curr_page", ""));
		setVvdCd(JSPUtil.getParameter(request,	prefix + "vvd_cd", ""));
		setReturnTo(JSPUtil.getParameter(request,	prefix + "return_to", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setDuraToDt(JSPUtil.getParameter(request,	prefix + "dura_to_dt", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request,	prefix + "sr_amd_tp_cd", ""));
		setCurQueue(JSPUtil.getParameter(request,	prefix + "cur_queue", ""));
		setSetQryWhere(JSPUtil.getParameter(request,	prefix + "set_qry_where", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request,	prefix + "bkg_cust_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setDuraFromDt(JSPUtil.getParameter(request,	prefix + "dura_from_dt", ""));
		setBkgOfcCd(JSPUtil.getParameter(request,	prefix + "bkg_ofc_cd", ""));
		setSrcCd(JSPUtil.getParameter(request,	prefix + "src_cd", ""));
		setFax(JSPUtil.getParameter(request,	prefix + "fax", ""));
		setPendingOnly(JSPUtil.getParameter(request,	prefix + "pending_only", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setQa(JSPUtil.getParameter(request,	prefix + "qa", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setQueueStatus(JSPUtil.getParameter(request,	prefix + "queue_status", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setInput(JSPUtil.getParameter(request,	prefix + "input", ""));
		setSlanCd(JSPUtil.getParameter(request,	prefix + "slan_cd", ""));
		setSts(JSPUtil.getParameter(request,	prefix + "sts", ""));
		setSetSlctFlg(JSPUtil.getParameter(request,	prefix + "set_slct_flg", ""));
		setPrtCd(JSPUtil.getParameter(request,	prefix + "prt_cd", ""));
		setPicId(JSPUtil.getParameter(request,	prefix + "pic_id", ""));
		setPicCngId(JSPUtil.getParameter(request,	prefix + "pic_cng_id", ""));
		setPrdFlg(JSPUtil.getParameter(request,	prefix + "prd_flg", ""));
		setDpcsOfcCd(JSPUtil.getParameter(request,	prefix + "dpcs_ofc_cd", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request,	prefix + "bkg_ctrt_tp_cd", ""));
		setContractNo(JSPUtil.getParameter(request,	prefix + "contract_no", ""));
		setReturnTpCd(JSPUtil.getParameter(request,	prefix + "return_tp_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocQueueListInVO[]
	 */
	public DocQueueListInVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DocQueueListInVO[]
	 */
	public DocQueueListInVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		DocQueueListInVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] region =	(JSPUtil.getParameter(request, prefix +	"region".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] svrCd =	(JSPUtil.getParameter(request, prefix +	"svr_cd".trim(),	length));
				String[] srepCd =	(JSPUtil.getParameter(request, prefix +	"srep_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] srKndCd =	(JSPUtil.getParameter(request, prefix +	"sr_knd_cd".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] rowsPerPage =	(JSPUtil.getParameter(request, prefix +	"rows_per_page".trim(),	length));
				String[] splitOnlyFlg =	(JSPUtil.getParameter(request, prefix +	"split_only_flg".trim(),	length));
				String[] rate =	(JSPUtil.getParameter(request, prefix +	"rate".trim(),	length));
				String[] currPage =	(JSPUtil.getParameter(request, prefix +	"curr_page".trim(),	length));
				String[] vvdCd =	(JSPUtil.getParameter(request, prefix +	"vvd_cd".trim(),	length));
				String[] returnTo =	(JSPUtil.getParameter(request, prefix +	"return_to".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] duraToDt =	(JSPUtil.getParameter(request, prefix +	"dura_to_dt".trim(),	length));
				String[] srAmdTpCd =	(JSPUtil.getParameter(request, prefix +	"sr_amd_tp_cd".trim(),	length));
				String[] curQueue =	(JSPUtil.getParameter(request, prefix +	"cur_queue".trim(),	length));
				String[] setQryWhere =	(JSPUtil.getParameter(request, prefix +	"set_qry_where".trim(),	length));
				String[] bkgCustTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_cust_tp_cd".trim(),	length));
				String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd".trim(),	length));
				String[] duraFromDt =	(JSPUtil.getParameter(request, prefix +	"dura_from_dt".trim(),	length));
				String[] bkgOfcCd =	(JSPUtil.getParameter(request, prefix +	"bkg_ofc_cd".trim(),	length));
				String[] srcCd =	(JSPUtil.getParameter(request, prefix +	"src_cd".trim(),	length));
				String[] fax =	(JSPUtil.getParameter(request, prefix +	"fax".trim(),	length));
				String[] pendingOnly =	(JSPUtil.getParameter(request, prefix +	"pending_only".trim(),	length));
				String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq".trim(),	length));
				String[] qa =	(JSPUtil.getParameter(request, prefix +	"qa".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] queueStatus =	(JSPUtil.getParameter(request, prefix +	"queue_status".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] input =	(JSPUtil.getParameter(request, prefix +	"input".trim(),	length));
				String[] slanCd =	(JSPUtil.getParameter(request, prefix +	"slan_cd".trim(),	length));
				String[] sts =	(JSPUtil.getParameter(request, prefix +	"sts".trim(),	length));
				String[] setSlctFlg =	(JSPUtil.getParameter(request, prefix +	"set_slct_flg".trim(),	length));
				String[] prtCd =	(JSPUtil.getParameter(request, prefix +	"prt_cd".trim(),	length));
				String[] picId =	(JSPUtil.getParameter(request, prefix +	"pic_id".trim(),	length));
				String[] picCngId =	(JSPUtil.getParameter(request, prefix +	"pic_cng_id".trim(),	length));
				String[] prdFlg =	(JSPUtil.getParameter(request, prefix +	"prd_flg".trim(),	length));
				String[] dpcsOfcCd =	(JSPUtil.getParameter(request, prefix +	"dpcs_ofc_cd".trim(),	length));
				String[] bkgCtrtTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_ctrt_tp_cd".trim(),	length));
				String[] contractNo =	(JSPUtil.getParameter(request, prefix +	"contract_no".trim(),	length));
				String[] returnTpCd =	(JSPUtil.getParameter(request, prefix +	"return_tp_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	DocQueueListInVO();
						if ( region[i] !=	null)
						model.setRegion( region[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( svrCd[i] !=	null)
						model.setSvrCd( svrCd[i]);
						if ( srepCd[i] !=	null)
						model.setSrepCd( srepCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( srKndCd[i] !=	null)
						model.setSrKndCd( srKndCd[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( rowsPerPage[i] !=	null)
						model.setRowsPerPage( rowsPerPage[i]);
						if ( splitOnlyFlg[i] !=	null)
						model.setSplitOnlyFlg( splitOnlyFlg[i]);
						if ( rate[i] !=	null)
						model.setRate( rate[i]);
						if ( currPage[i] !=	null)
						model.setCurrPage( currPage[i]);
						if ( vvdCd[i] !=	null)
						model.setVvdCd( vvdCd[i]);
						if ( returnTo[i] !=	null)
						model.setReturnTo( returnTo[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( duraToDt[i] !=	null)
						model.setDuraToDt( duraToDt[i]);
						if ( srAmdTpCd[i] !=	null)
						model.setSrAmdTpCd( srAmdTpCd[i]);
						if ( curQueue[i] !=	null)
						model.setCurQueue( curQueue[i]);
						if ( setQryWhere[i] !=	null)
						model.setSetQryWhere( setQryWhere[i]);
						if ( bkgCustTpCd[i] !=	null)
						model.setBkgCustTpCd( bkgCustTpCd[i]);
						if ( custCntCd[i] !=	null)
						model.setCustCntCd( custCntCd[i]);
						if ( duraFromDt[i] !=	null)
						model.setDuraFromDt( duraFromDt[i]);
						if ( bkgOfcCd[i] !=	null)
						model.setBkgOfcCd( bkgOfcCd[i]);
						if ( srcCd[i] !=	null)
						model.setSrcCd( srcCd[i]);
						if ( fax[i] !=	null)
						model.setFax( fax[i]);
						if ( pendingOnly[i] !=	null)
						model.setPendingOnly( pendingOnly[i]);
						if ( custSeq[i] !=	null)
						model.setCustSeq( custSeq[i]);
						if ( qa[i] !=	null)
						model.setQa( qa[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( queueStatus[i] !=	null)
						model.setQueueStatus( queueStatus[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( input[i] !=	null)
						model.setInput( input[i]);
						if ( slanCd[i] !=	null)
						model.setSlanCd( slanCd[i]);
						if ( sts[i] !=	null)
						model.setSts( sts[i]);
						if ( setSlctFlg[i] !=	null)
						model.setSetSlctFlg( setSlctFlg[i]);
						if ( prtCd[i] !=	null)
						model.setPrtCd( prtCd[i]);
						if ( picId[i] !=	null)
						model.setPicId( picId[i]);
						if ( picCngId[i] !=	null)
						model.setPicCngId( picCngId[i]);
						if ( prdFlg[i] !=	null)
						model.setPrdFlg( prdFlg[i]);
						if ( dpcsOfcCd[i] !=	null)
						model.setDpcsOfcCd( dpcsOfcCd[i]);
						if ( bkgCtrtTpCd[i] !=	null)
						model.setBkgCtrtTpCd( bkgCtrtTpCd[i]);
						if ( contractNo[i] !=	null)
						model.setContractNo( contractNo[i]);
						if ( returnTpCd[i] !=	null)
						model.setReturnTpCd( returnTpCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getDocQueueListInVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return DocQueueListInVO[]
	 */
	public DocQueueListInVO[]	 getDocQueueListInVOs(){
		DocQueueListInVO[] vos = (DocQueueListInVO[])models.toArray(new	DocQueueListInVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.region =	this.region.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrCd =	this.svrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd =	this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd =	this.srKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage =	this.rowsPerPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitOnlyFlg =	this.splitOnlyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate =	this.rate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage =	this.currPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd =	this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnTo =	this.returnTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duraToDt =	this.duraToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd =	this.srAmdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curQueue =	this.curQueue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.setQryWhere =	this.setQryWhere.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd =	this.bkgCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duraFromDt =	this.duraFromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd =	this.bkgOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCd =	this.srcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax =	this.fax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pendingOnly =	this.pendingOnly.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qa =	this.qa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.queueStatus =	this.queueStatus.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.input =	this.input.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd =	this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts =	this.sts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.setSlctFlg =	this.setSlctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtCd =	this.prtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picId =	this.picId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picCngId =	this.picCngId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prdFlg =	this.prdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsOfcCd =	this.dpcsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd =	this.bkgCtrtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractNo =	this.contractNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnTpCd =	this.returnTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}