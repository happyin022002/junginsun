/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ApprovalInqueryVO.java
 *@FileTitle : ApprovalInqueryVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2018.01.23
 *@LastModifier : ApprovalInqueryVO
 *@LastVersion : 1.0
 * 2018.01.23 ApprovalInqueryVO 
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.bizcommon.approval.vo;

import java.lang.reflect.Field;
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
 * - 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author ApprovalInqueryVO
 * @since J2EE 1.6
 * @see	..
 */
public class ApprovalInqueryVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ApprovalInqueryVO>  models =	new	ArrayList<ApprovalInqueryVO>();


	/*	Column Info	*/
	private  String	 aproStep   =  null;
	/*	Column Info	*/
	private  String	 payDt   =  null;
	/*	Column Info	*/
	private  String	 aproTtlAmt   =  null;
	/*	Column Info	*/
	private  String	 apstsCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 aproSeqKey   =  null;
	/*	Column Info	*/
	private  String	 csrNo   =  null;
	/*	Column Info	*/
	private  String	 subSysCd   =  null;
	/*	Column Info	*/
	private  String	 agmtDocCfmCd   =  null;
	/*	Column Info	*/
	private  String	 aproRmk   =  null;
	/*	Column Info	*/
	private  String	 aproRqstSeq   =  null;
	/*	Column Info	*/
	private  String	 usrNm   =  null;
	/*	Column Info	*/
	private  String	 fileUpldFlg   =  null;
	/*	Column Info	*/
	private  String	 invSubSysCd   =  null;
	/*	Column Info	*/
	private  String	 asaNo   =  null;
	/*	Column Info	*/
	private  String	 frstAproUsrId   =  null;
	/*	Column Info	*/
	private  String	 asaAmt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 costOfcCd   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 agmtFileCfmCd   =  null;
	/*	Column Info	*/
	private  String	 invKnt   =  null;
	/*	Column Info	*/
	private  String	 payDueDt   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 aproRqstNo   =  null;
	/*	Column Info	*/
	private  String	 vndrNm   =  null;
	/*	Column Info	*/
	private  String	 rqstStDt   =  null;
	/*	Column Info	*/
	private  String	 crntAproSeq   =  null;
	/*	Column Info	*/
	private  String	 appyn   =  null;
	/*	Column Info	*/
	private  String	 alpsStatus   =  null;
	/*	Column Info	*/
	private  String	 ifStatus   =  null;
	/*	Column Info	*/
	private  String	 sCsrNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ApprovalInqueryVO(){}

	public ApprovalInqueryVO(String aproStep,String payDt,String aproTtlAmt,String apstsCd,String ibflag,String aproSeqKey,String csrNo,String subSysCd,String agmtDocCfmCd,String aproRmk,String aproRqstSeq,String usrNm,String fileUpldFlg,String invSubSysCd,String asaNo,String frstAproUsrId,String asaAmt,String pagerows,String costOfcCd,String ofcCd,String currCd,String usrId,String agmtFileCfmCd,String invKnt,String payDueDt,String vndrSeq,String aproRqstNo,String vndrNm,String rqstStDt,String crntAproSeq,String appyn,String alpsStatus,String ifStatus,String sCsrNo)	{
		this.aproStep  = aproStep ;
		this.payDt  = payDt ;
		this.aproTtlAmt  = aproTtlAmt ;
		this.apstsCd  = apstsCd ;
		this.ibflag  = ibflag ;
		this.aproSeqKey  = aproSeqKey ;
		this.csrNo  = csrNo ;
		this.subSysCd  = subSysCd ;
		this.agmtDocCfmCd  = agmtDocCfmCd ;
		this.aproRmk  = aproRmk ;
		this.aproRqstSeq  = aproRqstSeq ;
		this.usrNm  = usrNm ;
		this.fileUpldFlg  = fileUpldFlg ;
		this.invSubSysCd  = invSubSysCd ;
		this.asaNo  = asaNo ;
		this.frstAproUsrId  = frstAproUsrId ;
		this.asaAmt  = asaAmt ;
		this.pagerows  = pagerows ;
		this.costOfcCd  = costOfcCd ;
		this.ofcCd  = ofcCd ;
		this.currCd  = currCd ;
		this.usrId  = usrId ;
		this.agmtFileCfmCd  = agmtFileCfmCd ;
		this.invKnt  = invKnt ;
		this.payDueDt  = payDueDt ;
		this.vndrSeq  = vndrSeq ;
		this.aproRqstNo  = aproRqstNo ;
		this.vndrNm  = vndrNm ;
		this.rqstStDt  = rqstStDt ;
		this.crntAproSeq  = crntAproSeq ;
		this.appyn  = appyn ;
		this.alpsStatus  = alpsStatus ;
		this.ifStatus  = ifStatus ;
		this.sCsrNo = sCsrNo;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apro_step", getAproStep());		
		this.hashColumns.put("pay_dt", getPayDt());		
		this.hashColumns.put("apro_ttl_amt", getAproTtlAmt());		
		this.hashColumns.put("apsts_cd", getApstsCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("apro_seq_key", getAproSeqKey());		
		this.hashColumns.put("csr_no", getCsrNo());		
		this.hashColumns.put("sub_sys_cd", getSubSysCd());		
		this.hashColumns.put("agmt_doc_cfm_cd", getAgmtDocCfmCd());		
		this.hashColumns.put("apro_rmk", getAproRmk());		
		this.hashColumns.put("apro_rqst_seq", getAproRqstSeq());		
		this.hashColumns.put("usr_nm", getUsrNm());		
		this.hashColumns.put("file_upld_flg", getFileUpldFlg());		
		this.hashColumns.put("inv_sub_sys_cd", getInvSubSysCd());		
		this.hashColumns.put("asa_no", getAsaNo());		
		this.hashColumns.put("frst_apro_usr_id", getFrstAproUsrId());		
		this.hashColumns.put("asa_amt", getAsaAmt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("agmt_file_cfm_cd", getAgmtFileCfmCd());		
		this.hashColumns.put("inv_knt", getInvKnt());		
		this.hashColumns.put("pay_due_dt", getPayDueDt());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("apro_rqst_no", getAproRqstNo());		
		this.hashColumns.put("vndr_nm", getVndrNm());		
		this.hashColumns.put("rqst_st_dt", getRqstStDt());		
		this.hashColumns.put("crnt_apro_seq", getCrntAproSeq());		
		this.hashColumns.put("appyn", getAppyn());		
		this.hashColumns.put("alps_status", getAlpsStatus());		
		this.hashColumns.put("if_status", getIfStatus());		
		this.hashColumns.put("s_csr_no", getSCsrNo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("apro_step", "aproStep");
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("apro_ttl_amt", "aproTtlAmt");
		this.hashFields.put("apsts_cd", "apstsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("apro_seq_key", "aproSeqKey");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("sub_sys_cd", "subSysCd");
		this.hashFields.put("agmt_doc_cfm_cd", "agmtDocCfmCd");
		this.hashFields.put("apro_rmk", "aproRmk");
		this.hashFields.put("apro_rqst_seq", "aproRqstSeq");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("file_upld_flg", "fileUpldFlg");
		this.hashFields.put("inv_sub_sys_cd", "invSubSysCd");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("frst_apro_usr_id", "frstAproUsrId");
		this.hashFields.put("asa_amt", "asaAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("agmt_file_cfm_cd", "agmtFileCfmCd");
		this.hashFields.put("inv_knt", "invKnt");
		this.hashFields.put("pay_due_dt", "payDueDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("apro_rqst_no", "aproRqstNo");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("rqst_st_dt", "rqstStDt");
		this.hashFields.put("crnt_apro_seq", "crntAproSeq");
		this.hashFields.put("appyn", "appyn");
		this.hashFields.put("alps_status", "alpsStatus");
		this.hashFields.put("if_status", "ifStatus");
		this.hashFields.put("s_csr_no", "sCsrNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  aproStep
	*/
	public void	setAproStep( String	aproStep ) {
		this.aproStep =	aproStep;
	}
 
	/**
	 * Column Info
	 * @return	aproStep
	 */
	 public	 String	getAproStep() {
		 return	this.aproStep;
	 } 
 	/**
	* Column Info
	* @param  payDt
	*/
	public void	setPayDt( String	payDt ) {
		this.payDt =	payDt;
	}
 
	/**
	 * Column Info
	 * @return	payDt
	 */
	 public	 String	getPayDt() {
		 return	this.payDt;
	 } 
 	/**
	* Column Info
	* @param  aproTtlAmt
	*/
	public void	setAproTtlAmt( String	aproTtlAmt ) {
		this.aproTtlAmt =	aproTtlAmt;
	}
 
	/**
	 * Column Info
	 * @return	aproTtlAmt
	 */
	 public	 String	getAproTtlAmt() {
		 return	this.aproTtlAmt;
	 } 
 	/**
	* Column Info
	* @param  apstsCd
	*/
	public void	setApstsCd( String	apstsCd ) {
		this.apstsCd =	apstsCd;
	}
 
	/**
	 * Column Info
	 * @return	apstsCd
	 */
	 public	 String	getApstsCd() {
		 return	this.apstsCd;
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
	* @param  aproSeqKey
	*/
	public void	setAproSeqKey( String	aproSeqKey ) {
		this.aproSeqKey =	aproSeqKey;
	}
 
	/**
	 * Column Info
	 * @return	aproSeqKey
	 */
	 public	 String	getAproSeqKey() {
		 return	this.aproSeqKey;
	 } 
 	/**
	* Column Info
	* @param  csrNo
	*/
	public void	setCsrNo( String	csrNo ) {
		this.csrNo =	csrNo;
	}
 
	/**
	 * Column Info
	 * @return	csrNo
	 */
	 public	 String	getCsrNo() {
		 return	this.csrNo;
	 } 
 	/**
	* Column Info
	* @param  subSysCd
	*/
	public void	setSubSysCd( String	subSysCd ) {
		this.subSysCd =	subSysCd;
	}
 
	/**
	 * Column Info
	 * @return	subSysCd
	 */
	 public	 String	getSubSysCd() {
		 return	this.subSysCd;
	 } 
 	/**
	* Column Info
	* @param  agmtDocCfmCd
	*/
	public void	setAgmtDocCfmCd( String	agmtDocCfmCd ) {
		this.agmtDocCfmCd =	agmtDocCfmCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtDocCfmCd
	 */
	 public	 String	getAgmtDocCfmCd() {
		 return	this.agmtDocCfmCd;
	 } 
 	/**
	* Column Info
	* @param  aproRmk
	*/
	public void	setAproRmk( String	aproRmk ) {
		this.aproRmk =	aproRmk;
	}
 
	/**
	 * Column Info
	 * @return	aproRmk
	 */
	 public	 String	getAproRmk() {
		 return	this.aproRmk;
	 } 
 	/**
	* Column Info
	* @param  aproRqstSeq
	*/
	public void	setAproRqstSeq( String	aproRqstSeq ) {
		this.aproRqstSeq =	aproRqstSeq;
	}
 
	/**
	 * Column Info
	 * @return	aproRqstSeq
	 */
	 public	 String	getAproRqstSeq() {
		 return	this.aproRqstSeq;
	 } 
 	/**
	* Column Info
	* @param  usrNm
	*/
	public void	setUsrNm( String	usrNm ) {
		this.usrNm =	usrNm;
	}
 
	/**
	 * Column Info
	 * @return	usrNm
	 */
	 public	 String	getUsrNm() {
		 return	this.usrNm;
	 } 
 	/**
	* Column Info
	* @param  fileUpldFlg
	*/
	public void	setFileUpldFlg( String	fileUpldFlg ) {
		this.fileUpldFlg =	fileUpldFlg;
	}
 
	/**
	 * Column Info
	 * @return	fileUpldFlg
	 */
	 public	 String	getFileUpldFlg() {
		 return	this.fileUpldFlg;
	 } 
 	/**
	* Column Info
	* @param  invSubSysCd
	*/
	public void	setInvSubSysCd( String	invSubSysCd ) {
		this.invSubSysCd =	invSubSysCd;
	}
 
	/**
	 * Column Info
	 * @return	invSubSysCd
	 */
	 public	 String	getInvSubSysCd() {
		 return	this.invSubSysCd;
	 } 
 	/**
	* Column Info
	* @param  asaNo
	*/
	public void	setAsaNo( String	asaNo ) {
		this.asaNo =	asaNo;
	}
 
	/**
	 * Column Info
	 * @return	asaNo
	 */
	 public	 String	getAsaNo() {
		 return	this.asaNo;
	 } 
 	/**
	* Column Info
	* @param  frstAproUsrId
	*/
	public void	setFrstAproUsrId( String	frstAproUsrId ) {
		this.frstAproUsrId =	frstAproUsrId;
	}
 
	/**
	 * Column Info
	 * @return	frstAproUsrId
	 */
	 public	 String	getFrstAproUsrId() {
		 return	this.frstAproUsrId;
	 } 
 	/**
	* Column Info
	* @param  asaAmt
	*/
	public void	setAsaAmt( String	asaAmt ) {
		this.asaAmt =	asaAmt;
	}
 
	/**
	 * Column Info
	 * @return	asaAmt
	 */
	 public	 String	getAsaAmt() {
		 return	this.asaAmt;
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
	* @param  costOfcCd
	*/
	public void	setCostOfcCd( String	costOfcCd ) {
		this.costOfcCd =	costOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	costOfcCd
	 */
	 public	 String	getCostOfcCd() {
		 return	this.costOfcCd;
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
	* @param  currCd
	*/
	public void	setCurrCd( String	currCd ) {
		this.currCd =	currCd;
	}
 
	/**
	 * Column Info
	 * @return	currCd
	 */
	 public	 String	getCurrCd() {
		 return	this.currCd;
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
	* @param  agmtFileCfmCd
	*/
	public void	setAgmtFileCfmCd( String	agmtFileCfmCd ) {
		this.agmtFileCfmCd =	agmtFileCfmCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtFileCfmCd
	 */
	 public	 String	getAgmtFileCfmCd() {
		 return	this.agmtFileCfmCd;
	 } 
 	/**
	* Column Info
	* @param  invKnt
	*/
	public void	setInvKnt( String	invKnt ) {
		this.invKnt =	invKnt;
	}
 
	/**
	 * Column Info
	 * @return	invKnt
	 */
	 public	 String	getInvKnt() {
		 return	this.invKnt;
	 } 
 	/**
	* Column Info
	* @param  payDueDt
	*/
	public void	setPayDueDt( String	payDueDt ) {
		this.payDueDt =	payDueDt;
	}
 
	/**
	 * Column Info
	 * @return	payDueDt
	 */
	 public	 String	getPayDueDt() {
		 return	this.payDueDt;
	 } 
 	/**
	* Column Info
	* @param  vndrSeq
	*/
	public void	setVndrSeq( String	vndrSeq ) {
		this.vndrSeq =	vndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	vndrSeq
	 */
	 public	 String	getVndrSeq() {
		 return	this.vndrSeq;
	 } 
 	/**
	* Column Info
	* @param  aproRqstNo
	*/
	public void	setAproRqstNo( String	aproRqstNo ) {
		this.aproRqstNo =	aproRqstNo;
	}
 
	/**
	 * Column Info
	 * @return	aproRqstNo
	 */
	 public	 String	getAproRqstNo() {
		 return	this.aproRqstNo;
	 } 
 	/**
	* Column Info
	* @param  vndrNm
	*/
	public void	setVndrNm( String	vndrNm ) {
		this.vndrNm =	vndrNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrNm
	 */
	 public	 String	getVndrNm() {
		 return	this.vndrNm;
	 } 
 	/**
	* Column Info
	* @param  rqstStDt
	*/
	public void	setRqstStDt( String	rqstStDt ) {
		this.rqstStDt =	rqstStDt;
	}
 
	/**
	 * Column Info
	 * @return	rqstStDt
	 */
	 public	 String	getRqstStDt() {
		 return	this.rqstStDt;
	 } 
 	/**
	* Column Info
	* @param  crntAproSeq
	*/
	public void	setCrntAproSeq( String	crntAproSeq ) {
		this.crntAproSeq =	crntAproSeq;
	}
 
	/**
	 * Column Info
	 * @return	crntAproSeq
	 */
	 public	 String	getCrntAproSeq() {
		 return	this.crntAproSeq;
	 } 
 	/**
	* Column Info
	* @param  appyn
	*/
	public void	setAppyn( String	appyn ) {
		this.appyn =	appyn;
	}
 
	/**
	 * Column Info
	 * @return	appyn
	 */
	 public	 String	getAppyn() {
		 return	this.appyn;
	 } 
 	/**
	* Column Info
	* @param  alpsStatus
	*/
	public void	setAlpsStatus( String	alpsStatus ) {
		this.alpsStatus =	alpsStatus;
	}
 
	/**
	 * Column Info
	 * @return	alpsStatus
	 */
	 public	 String	getAlpsStatus() {
		 return	this.alpsStatus;
	 } 
 	/**
	* Column Info
	* @param  ifStatus
	*/
	public void	setIfStatus( String	ifStatus ) {
		this.ifStatus =	ifStatus;
	}
 
	/**
	 * Column Info
	 * @return	ifStatus
	 */
	 public	 String	getIfStatus() {
		 return	this.ifStatus;
	 } 
	 
	/**
	 * Column Info
	 * @param  sCsrNo
	 */
	public void	setSCsrNo( String	sCsrNo ) {
		this.sCsrNo =	sCsrNo;
	}
	 
	/**
	 * Column Info
  	 * @return	sCsrNo
	 */
	public	 String	getSCsrNo() {
		return	this.sCsrNo;
	} 

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setAproStep(JSPUtil.getParameter(request,	prefix + "apro_step", ""));
		setPayDt(JSPUtil.getParameter(request,	prefix + "pay_dt", ""));
		setAproTtlAmt(JSPUtil.getParameter(request,	prefix + "apro_ttl_amt", ""));
		setApstsCd(JSPUtil.getParameter(request,	prefix + "apsts_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAproSeqKey(JSPUtil.getParameter(request,	prefix + "apro_seq_key", ""));
		setCsrNo(JSPUtil.getParameter(request,	prefix + "csr_no", ""));
		setSubSysCd(JSPUtil.getParameter(request,	prefix + "sub_sys_cd", ""));
		setAgmtDocCfmCd(JSPUtil.getParameter(request,	prefix + "agmt_doc_cfm_cd", ""));
		setAproRmk(JSPUtil.getParameter(request,	prefix + "apro_rmk", ""));
		setAproRqstSeq(JSPUtil.getParameter(request,	prefix + "apro_rqst_seq", ""));
		setUsrNm(JSPUtil.getParameter(request,	prefix + "usr_nm", ""));
		setFileUpldFlg(JSPUtil.getParameter(request,	prefix + "file_upld_flg", ""));
		setInvSubSysCd(JSPUtil.getParameter(request,	prefix + "inv_sub_sys_cd", ""));
		setAsaNo(JSPUtil.getParameter(request,	prefix + "asa_no", ""));
		setFrstAproUsrId(JSPUtil.getParameter(request,	prefix + "frst_apro_usr_id", ""));
		setAsaAmt(JSPUtil.getParameter(request,	prefix + "asa_amt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCostOfcCd(JSPUtil.getParameter(request,	prefix + "cost_ofc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setAgmtFileCfmCd(JSPUtil.getParameter(request,	prefix + "agmt_file_cfm_cd", ""));
		setInvKnt(JSPUtil.getParameter(request,	prefix + "inv_knt", ""));
		setPayDueDt(JSPUtil.getParameter(request,	prefix + "pay_due_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setAproRqstNo(JSPUtil.getParameter(request,	prefix + "apro_rqst_no", ""));
		setVndrNm(JSPUtil.getParameter(request,	prefix + "vndr_nm", ""));
		setRqstStDt(JSPUtil.getParameter(request,	prefix + "rqst_st_dt", ""));
		setCrntAproSeq(JSPUtil.getParameter(request,	prefix + "crnt_apro_seq", ""));
		setAppyn(JSPUtil.getParameter(request,	prefix + "appyn", ""));
		setAlpsStatus(JSPUtil.getParameter(request,	prefix + "alps_status", ""));
		setIfStatus(JSPUtil.getParameter(request,	prefix + "if_status", ""));
		setSCsrNo(JSPUtil.getParameter(request,	prefix + "s_csr_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ApprovalInqueryVO[]
	 */
	public ApprovalInqueryVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ApprovalInqueryVO[]
	 */
	public ApprovalInqueryVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ApprovalInqueryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] aproStep =	(JSPUtil.getParameter(request, prefix +	"apro_step".trim(),	length));
				String[] payDt =	(JSPUtil.getParameter(request, prefix +	"pay_dt".trim(),	length));
				String[] aproTtlAmt =	(JSPUtil.getParameter(request, prefix +	"apro_ttl_amt".trim(),	length));
				String[] apstsCd =	(JSPUtil.getParameter(request, prefix +	"apsts_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] aproSeqKey =	(JSPUtil.getParameter(request, prefix +	"apro_seq_key".trim(),	length));
				String[] csrNo =	(JSPUtil.getParameter(request, prefix +	"csr_no".trim(),	length));
				String[] subSysCd =	(JSPUtil.getParameter(request, prefix +	"sub_sys_cd".trim(),	length));
				String[] agmtDocCfmCd =	(JSPUtil.getParameter(request, prefix +	"agmt_doc_cfm_cd".trim(),	length));
				String[] aproRmk =	(JSPUtil.getParameter(request, prefix +	"apro_rmk".trim(),	length));
				String[] aproRqstSeq =	(JSPUtil.getParameter(request, prefix +	"apro_rqst_seq".trim(),	length));
				String[] usrNm =	(JSPUtil.getParameter(request, prefix +	"usr_nm".trim(),	length));
				String[] fileUpldFlg =	(JSPUtil.getParameter(request, prefix +	"file_upld_flg".trim(),	length));
				String[] invSubSysCd =	(JSPUtil.getParameter(request, prefix +	"inv_sub_sys_cd".trim(),	length));
				String[] asaNo =	(JSPUtil.getParameter(request, prefix +	"asa_no".trim(),	length));
				String[] frstAproUsrId =	(JSPUtil.getParameter(request, prefix +	"frst_apro_usr_id".trim(),	length));
				String[] asaAmt =	(JSPUtil.getParameter(request, prefix +	"asa_amt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] costOfcCd =	(JSPUtil.getParameter(request, prefix +	"cost_ofc_cd".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] agmtFileCfmCd =	(JSPUtil.getParameter(request, prefix +	"agmt_file_cfm_cd".trim(),	length));
				String[] invKnt =	(JSPUtil.getParameter(request, prefix +	"inv_knt".trim(),	length));
				String[] payDueDt =	(JSPUtil.getParameter(request, prefix +	"pay_due_dt".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] aproRqstNo =	(JSPUtil.getParameter(request, prefix +	"apro_rqst_no".trim(),	length));
				String[] vndrNm =	(JSPUtil.getParameter(request, prefix +	"vndr_nm".trim(),	length));
				String[] rqstStDt =	(JSPUtil.getParameter(request, prefix +	"rqst_st_dt".trim(),	length));
				String[] crntAproSeq =	(JSPUtil.getParameter(request, prefix +	"crnt_apro_seq".trim(),	length));
				String[] appyn =	(JSPUtil.getParameter(request, prefix +	"appyn".trim(),	length));
				String[] alpsStatus =	(JSPUtil.getParameter(request, prefix +	"alps_status".trim(),	length));
				String[] ifStatus =	(JSPUtil.getParameter(request, prefix +	"if_status".trim(),	length));
				String[] sCsrNo =	(JSPUtil.getParameter(request, prefix +	"s_csr_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ApprovalInqueryVO();
						if ( aproStep[i] !=	null)
						model.setAproStep( aproStep[i]);
						if ( payDt[i] !=	null)
						model.setPayDt( payDt[i]);
						if ( aproTtlAmt[i] !=	null)
						model.setAproTtlAmt( aproTtlAmt[i]);
						if ( apstsCd[i] !=	null)
						model.setApstsCd( apstsCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( aproSeqKey[i] !=	null)
						model.setAproSeqKey( aproSeqKey[i]);
						if ( csrNo[i] !=	null)
						model.setCsrNo( csrNo[i]);
						if ( subSysCd[i] !=	null)
						model.setSubSysCd( subSysCd[i]);
						if ( agmtDocCfmCd[i] !=	null)
						model.setAgmtDocCfmCd( agmtDocCfmCd[i]);
						if ( aproRmk[i] !=	null)
						model.setAproRmk( aproRmk[i]);
						if ( aproRqstSeq[i] !=	null)
						model.setAproRqstSeq( aproRqstSeq[i]);
						if ( usrNm[i] !=	null)
						model.setUsrNm( usrNm[i]);
						if ( fileUpldFlg[i] !=	null)
						model.setFileUpldFlg( fileUpldFlg[i]);
						if ( invSubSysCd[i] !=	null)
						model.setInvSubSysCd( invSubSysCd[i]);
						if ( asaNo[i] !=	null)
						model.setAsaNo( asaNo[i]);
						if ( frstAproUsrId[i] !=	null)
						model.setFrstAproUsrId( frstAproUsrId[i]);
						if ( asaAmt[i] !=	null)
						model.setAsaAmt( asaAmt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( costOfcCd[i] !=	null)
						model.setCostOfcCd( costOfcCd[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( agmtFileCfmCd[i] !=	null)
						model.setAgmtFileCfmCd( agmtFileCfmCd[i]);
						if ( invKnt[i] !=	null)
						model.setInvKnt( invKnt[i]);
						if ( payDueDt[i] !=	null)
						model.setPayDueDt( payDueDt[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( aproRqstNo[i] !=	null)
						model.setAproRqstNo( aproRqstNo[i]);
						if ( vndrNm[i] !=	null)
						model.setVndrNm( vndrNm[i]);
						if ( rqstStDt[i] !=	null)
						model.setRqstStDt( rqstStDt[i]);
						if ( crntAproSeq[i] !=	null)
						model.setCrntAproSeq( crntAproSeq[i]);
						if ( appyn[i] !=	null)
						model.setAppyn( appyn[i]);
						if ( alpsStatus[i] !=	null)
						model.setAlpsStatus( alpsStatus[i]);
						if ( ifStatus[i] !=	null)
						model.setIfStatus( ifStatus[i]);
						if ( sCsrNo[i] !=	null)
						model.setSCsrNo( sCsrNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getApprovalInqueryVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ApprovalInqueryVO[]
	 */
	public ApprovalInqueryVO[]	 getApprovalInqueryVOs(){
		ApprovalInqueryVO[] vos = (ApprovalInqueryVO[])models.toArray(new	ApprovalInqueryVO[models.size()]);
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
		this.aproStep =	this.aproStep.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDt =	this.payDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproTtlAmt =	this.aproTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apstsCd =	this.apstsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproSeqKey =	this.aproSeqKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo =	this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysCd =	this.subSysCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocCfmCd =	this.agmtDocCfmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRmk =	this.aproRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstSeq =	this.aproRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm =	this.usrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileUpldFlg =	this.fileUpldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSubSysCd =	this.invSubSysCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo =	this.asaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frstAproUsrId =	this.frstAproUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaAmt =	this.asaAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd =	this.costOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtFileCfmCd =	this.agmtFileCfmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invKnt =	this.invKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDueDt =	this.payDueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstNo =	this.aproRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm =	this.vndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstStDt =	this.rqstStDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntAproSeq =	this.crntAproSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appyn =	this.appyn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alpsStatus =	this.alpsStatus.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifStatus =	this.ifStatus.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCsrNo =	this.sCsrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}