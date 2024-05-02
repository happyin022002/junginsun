/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvIssMainVO.java
 *@FileTitle : InvIssMainVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.05.27
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.05.27  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class InvIssMainVO	extends	 AbstractValueObject 
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvIssMainVO>  models =	new	ArrayList<InvIssMainVO>();


	/*	Column Info	*/
	private  String	 titleFlag   =  null;
	/*	Column Info	*/
	private  String	 fKey   =  null;
	/*	Column Info	*/
	private  String	 attach2   =  null;
	/*	Column Info	*/
	private  String	 emlSndDt   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 rissDt   =  null;
	/*	Column Info	*/
	private  String	 issueType   =  null;
	/*	Column Info	*/
	private  String	 usdXchRt   =  null;
	/*	Column Info	*/
	private  String	 issOfcCd   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 attachView   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invIssCmbFlg   =  null;
	/*	Column Info	*/
	private  String	 issDt   =  null;
	/*	Column Info	*/
	private  String	 loclPoNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 fSaveId   =  null;
	/*	Column Info	*/
	private  String	 copyCnt   =  null;
	/*	Column Info	*/
	private  String	 rdName   =  null;
	/*	Column Info	*/
	private  String	 invIssRmk   =  null;
	/*	Column Info	*/
	private  String	 invXchRtDt   =  null;
	/*	Column Info	*/
	private  String	 custFaxNo   =  null;
	/*	Column Info	*/
	private  String	 portCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 sendFlag   =  null;
	/*	Column Info	*/
	private  String	 blSrcNo   =  null;
	/*	Column Info	*/
	private  String	 actInvNo   =  null;
	/*	Column Info	*/
	private  String	 attachView2   =  null;
	/*	Column Info	*/
	private  String	 emlSndNo   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 custEml   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 issueGubn   =  null;
	/*	Column Info	*/
	private  String	 nameFlag   =  null;
	/*	Column Info	*/
	private  String	 custCd   =  null;
	/*	Column Info	*/
	private  String	 attach   =  null;
	/*	Column Info	*/
	private  String	 faxSndDt   =  null;
	/*	Column Info	*/
	private  String	 faxSndNo   =  null;
	/*	Column Info	*/
	private  String	 issGrpTpCd   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 usrNm   =  null;
	/*	Column Info	*/
	private  String	 accountCreUsrId   =  null;
	/*	Column Info	*/
	private  String	 accountUpdUsrId   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvIssMainVO(){}

	public InvIssMainVO(String titleFlag,String fKey,String attach2,String emlSndDt,String custNm,String rissDt,String issueType,String usdXchRt,String issOfcCd,String creDt,String invSeq,String attachView,String pagerows,String invIssCmbFlg,String issDt,String loclPoNo,String ibflag,String fSaveId,String copyCnt,String rdName,String invIssRmk,String invXchRtDt,String custFaxNo,String portCd,String updUsrId,String updDt,String sendFlag,String blSrcNo,String actInvNo,String attachView2,String emlSndNo,String ioBndCd,String custEml,String invNo,String vvd,String creUsrId,String issueGubn,String nameFlag,String custCd,String attach,String faxSndDt,String faxSndNo,String issGrpTpCd,String usrId,String usrNm,String accountCreUsrId,String accountUpdUsrId)	{
		this.titleFlag  = titleFlag ;
		this.fKey  = fKey ;
		this.attach2  = attach2 ;
		this.emlSndDt  = emlSndDt ;
		this.custNm  = custNm ;
		this.rissDt  = rissDt ;
		this.issueType  = issueType ;
		this.usdXchRt  = usdXchRt ;
		this.issOfcCd  = issOfcCd ;
		this.creDt  = creDt ;
		this.invSeq  = invSeq ;
		this.attachView  = attachView ;
		this.pagerows  = pagerows ;
		this.invIssCmbFlg  = invIssCmbFlg ;
		this.issDt  = issDt ;
		this.loclPoNo  = loclPoNo ;
		this.ibflag  = ibflag ;
		this.fSaveId  = fSaveId ;
		this.copyCnt  = copyCnt ;
		this.rdName  = rdName ;
		this.invIssRmk  = invIssRmk ;
		this.invXchRtDt  = invXchRtDt ;
		this.custFaxNo  = custFaxNo ;
		this.portCd  = portCd ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.sendFlag  = sendFlag ;
		this.blSrcNo  = blSrcNo ;
		this.actInvNo  = actInvNo ;
		this.attachView2  = attachView2 ;
		this.emlSndNo  = emlSndNo ;
		this.ioBndCd  = ioBndCd ;
		this.custEml  = custEml ;
		this.invNo  = invNo ;
		this.vvd  = vvd ;
		this.creUsrId  = creUsrId ;
		this.issueGubn  = issueGubn ;
		this.nameFlag  = nameFlag ;
		this.custCd  = custCd ;
		this.attach  = attach ;
		this.faxSndDt  = faxSndDt ;
		this.faxSndNo  = faxSndNo ;
		this.issGrpTpCd  = issGrpTpCd ;
		this.usrId  = usrId ;
		this.usrNm  = usrNm ;
		this.accountCreUsrId  = accountCreUsrId ;
		this.accountUpdUsrId  = accountUpdUsrId ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("title_flag", getTitleFlag());		
		this.hashColumns.put("f_key", getFKey());		
		this.hashColumns.put("attach2", getAttach2());		
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("riss_dt", getRissDt());		
		this.hashColumns.put("issue_type", getIssueType());		
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());		
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("attach_view", getAttachView());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_iss_cmb_flg", getInvIssCmbFlg());		
		this.hashColumns.put("iss_dt", getIssDt());		
		this.hashColumns.put("locl_po_no", getLoclPoNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("f_save_id", getFSaveId());		
		this.hashColumns.put("copy_cnt", getCopyCnt());		
		this.hashColumns.put("rd_name", getRdName());		
		this.hashColumns.put("inv_iss_rmk", getInvIssRmk());		
		this.hashColumns.put("inv_xch_rt_dt", getInvXchRtDt());		
		this.hashColumns.put("cust_fax_no", getCustFaxNo());		
		this.hashColumns.put("port_cd", getPortCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("send_flag", getSendFlag());		
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		this.hashColumns.put("act_inv_no", getActInvNo());		
		this.hashColumns.put("attach_view2", getAttachView2());		
		this.hashColumns.put("eml_snd_no", getEmlSndNo());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("cust_eml", getCustEml());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("issue_gubn", getIssueGubn());		
		this.hashColumns.put("name_flag", getNameFlag());		
		this.hashColumns.put("cust_cd", getCustCd());		
		this.hashColumns.put("attach", getAttach());		
		this.hashColumns.put("fax_snd_dt", getFaxSndDt());		
		this.hashColumns.put("fax_snd_no", getFaxSndNo());		
		this.hashColumns.put("iss_grp_tp_cd", getIssGrpTpCd());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("usr_nm", getUsrNm());		
		this.hashColumns.put("account_cre_usr_id", getAccountCreUsrId());		
		this.hashColumns.put("account_upd_usr_id", getAccountUpdUsrId());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("title_flag", "titleFlag");
		this.hashFields.put("f_key", "fKey");
		this.hashFields.put("attach2", "attach2");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("riss_dt", "rissDt");
		this.hashFields.put("issue_type", "issueType");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("attach_view", "attachView");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_iss_cmb_flg", "invIssCmbFlg");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("locl_po_no", "loclPoNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_save_id", "fSaveId");
		this.hashFields.put("copy_cnt", "copyCnt");
		this.hashFields.put("rd_name", "rdName");
		this.hashFields.put("inv_iss_rmk", "invIssRmk");
		this.hashFields.put("inv_xch_rt_dt", "invXchRtDt");
		this.hashFields.put("cust_fax_no", "custFaxNo");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("send_flag", "sendFlag");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("act_inv_no", "actInvNo");
		this.hashFields.put("attach_view2", "attachView2");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("issue_gubn", "issueGubn");
		this.hashFields.put("name_flag", "nameFlag");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("attach", "attach");
		this.hashFields.put("fax_snd_dt", "faxSndDt");
		this.hashFields.put("fax_snd_no", "faxSndNo");
		this.hashFields.put("iss_grp_tp_cd", "issGrpTpCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("account_cre_usr_id", "accountCreUsrId");
		this.hashFields.put("account_upd_usr_id", "accountUpdUsrId");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  titleFlag
	*/
	public void	setTitleFlag( String	titleFlag ) {
		this.titleFlag =	titleFlag;
	}
 
	/**
	 * Column Info
	 * @return	titleFlag
	 */
	 public	 String	getTitleFlag() {
		 return	this.titleFlag;
	 } 
 	/**
	* Column Info
	* @param  fKey
	*/
	public void	setFKey( String	fKey ) {
		this.fKey =	fKey;
	}
 
	/**
	 * Column Info
	 * @return	fKey
	 */
	 public	 String	getFKey() {
		 return	this.fKey;
	 } 
 	/**
	* Column Info
	* @param  attach2
	*/
	public void	setAttach2( String	attach2 ) {
		this.attach2 =	attach2;
	}
 
	/**
	 * Column Info
	 * @return	attach2
	 */
	 public	 String	getAttach2() {
		 return	this.attach2;
	 } 
 	/**
	* Column Info
	* @param  emlSndDt
	*/
	public void	setEmlSndDt( String	emlSndDt ) {
		this.emlSndDt =	emlSndDt;
	}
 
	/**
	 * Column Info
	 * @return	emlSndDt
	 */
	 public	 String	getEmlSndDt() {
		 return	this.emlSndDt;
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
	* @param  rissDt
	*/
	public void	setRissDt( String	rissDt ) {
		this.rissDt =	rissDt;
	}
 
	/**
	 * Column Info
	 * @return	rissDt
	 */
	 public	 String	getRissDt() {
		 return	this.rissDt;
	 } 
 	/**
	* Column Info
	* @param  issueType
	*/
	public void	setIssueType( String	issueType ) {
		this.issueType =	issueType;
	}
 
	/**
	 * Column Info
	 * @return	issueType
	 */
	 public	 String	getIssueType() {
		 return	this.issueType;
	 } 
 	/**
	* Column Info
	* @param  usdXchRt
	*/
	public void	setUsdXchRt( String	usdXchRt ) {
		this.usdXchRt =	usdXchRt;
	}
 
	/**
	 * Column Info
	 * @return	usdXchRt
	 */
	 public	 String	getUsdXchRt() {
		 return	this.usdXchRt;
	 } 
 	/**
	* Column Info
	* @param  issOfcCd
	*/
	public void	setIssOfcCd( String	issOfcCd ) {
		this.issOfcCd =	issOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	issOfcCd
	 */
	 public	 String	getIssOfcCd() {
		 return	this.issOfcCd;
	 } 
 	/**
	* Column Info
	* @param  creDt
	*/
	public void	setCreDt( String	creDt ) {
		this.creDt =	creDt;
	}
 
	/**
	 * Column Info
	 * @return	creDt
	 */
	 public	 String	getCreDt() {
		 return	this.creDt;
	 } 
 	/**
	* Column Info
	* @param  invSeq
	*/
	public void	setInvSeq( String	invSeq ) {
		this.invSeq =	invSeq;
	}
 
	/**
	 * Column Info
	 * @return	invSeq
	 */
	 public	 String	getInvSeq() {
		 return	this.invSeq;
	 } 
 	/**
	* Column Info
	* @param  attachView
	*/
	public void	setAttachView( String	attachView ) {
		this.attachView =	attachView;
	}
 
	/**
	 * Column Info
	 * @return	attachView
	 */
	 public	 String	getAttachView() {
		 return	this.attachView;
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
	* @param  invIssCmbFlg
	*/
	public void	setInvIssCmbFlg( String	invIssCmbFlg ) {
		this.invIssCmbFlg =	invIssCmbFlg;
	}
 
	/**
	 * Column Info
	 * @return	invIssCmbFlg
	 */
	 public	 String	getInvIssCmbFlg() {
		 return	this.invIssCmbFlg;
	 } 
 	/**
	* Column Info
	* @param  issDt
	*/
	public void	setIssDt( String	issDt ) {
		this.issDt =	issDt;
	}
 
	/**
	 * Column Info
	 * @return	issDt
	 */
	 public	 String	getIssDt() {
		 return	this.issDt;
	 } 
 	/**
	* Column Info
	* @param  loclPoNo
	*/
	public void	setLoclPoNo( String	loclPoNo ) {
		this.loclPoNo =	loclPoNo;
	}
 
	/**
	 * Column Info
	 * @return	loclPoNo
	 */
	 public	 String	getLoclPoNo() {
		 return	this.loclPoNo;
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
	* @param  fSaveId
	*/
	public void	setFSaveId( String	fSaveId ) {
		this.fSaveId =	fSaveId;
	}
 
	/**
	 * Column Info
	 * @return	fSaveId
	 */
	 public	 String	getFSaveId() {
		 return	this.fSaveId;
	 } 
 	/**
	* Column Info
	* @param  copyCnt
	*/
	public void	setCopyCnt( String	copyCnt ) {
		this.copyCnt =	copyCnt;
	}
 
	/**
	 * Column Info
	 * @return	copyCnt
	 */
	 public	 String	getCopyCnt() {
		 return	this.copyCnt;
	 } 
 	/**
	* Column Info
	* @param  rdName
	*/
	public void	setRdName( String	rdName ) {
		this.rdName =	rdName;
	}
 
	/**
	 * Column Info
	 * @return	rdName
	 */
	 public	 String	getRdName() {
		 return	this.rdName;
	 } 
 	/**
	* Column Info
	* @param  invIssRmk
	*/
	public void	setInvIssRmk( String	invIssRmk ) {
		this.invIssRmk =	invIssRmk;
	}
 
	/**
	 * Column Info
	 * @return	invIssRmk
	 */
	 public	 String	getInvIssRmk() {
		 return	this.invIssRmk;
	 } 
 	/**
	* Column Info
	* @param  invXchRtDt
	*/
	public void	setInvXchRtDt( String	invXchRtDt ) {
		this.invXchRtDt =	invXchRtDt;
	}
 
	/**
	 * Column Info
	 * @return	invXchRtDt
	 */
	 public	 String	getInvXchRtDt() {
		 return	this.invXchRtDt;
	 } 
 	/**
	* Column Info
	* @param  custFaxNo
	*/
	public void	setCustFaxNo( String	custFaxNo ) {
		this.custFaxNo =	custFaxNo;
	}
 
	/**
	 * Column Info
	 * @return	custFaxNo
	 */
	 public	 String	getCustFaxNo() {
		 return	this.custFaxNo;
	 } 
 	/**
	* Column Info
	* @param  portCd
	*/
	public void	setPortCd( String	portCd ) {
		this.portCd =	portCd;
	}
 
	/**
	 * Column Info
	 * @return	portCd
	 */
	 public	 String	getPortCd() {
		 return	this.portCd;
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
	* @param  updDt
	*/
	public void	setUpdDt( String	updDt ) {
		this.updDt =	updDt;
	}
 
	/**
	 * Column Info
	 * @return	updDt
	 */
	 public	 String	getUpdDt() {
		 return	this.updDt;
	 } 
 	/**
	* Column Info
	* @param  sendFlag
	*/
	public void	setSendFlag( String	sendFlag ) {
		this.sendFlag =	sendFlag;
	}
 
	/**
	 * Column Info
	 * @return	sendFlag
	 */
	 public	 String	getSendFlag() {
		 return	this.sendFlag;
	 } 
 	/**
	* Column Info
	* @param  blSrcNo
	*/
	public void	setBlSrcNo( String	blSrcNo ) {
		this.blSrcNo =	blSrcNo;
	}
 
	/**
	 * Column Info
	 * @return	blSrcNo
	 */
	 public	 String	getBlSrcNo() {
		 return	this.blSrcNo;
	 } 
 	/**
	* Column Info
	* @param  actInvNo
	*/
	public void	setActInvNo( String	actInvNo ) {
		this.actInvNo =	actInvNo;
	}
 
	/**
	 * Column Info
	 * @return	actInvNo
	 */
	 public	 String	getActInvNo() {
		 return	this.actInvNo;
	 } 
 	/**
	* Column Info
	* @param  attachView2
	*/
	public void	setAttachView2( String	attachView2 ) {
		this.attachView2 =	attachView2;
	}
 
	/**
	 * Column Info
	 * @return	attachView2
	 */
	 public	 String	getAttachView2() {
		 return	this.attachView2;
	 } 
 	/**
	* Column Info
	* @param  emlSndNo
	*/
	public void	setEmlSndNo( String	emlSndNo ) {
		this.emlSndNo =	emlSndNo;
	}
 
	/**
	 * Column Info
	 * @return	emlSndNo
	 */
	 public	 String	getEmlSndNo() {
		 return	this.emlSndNo;
	 } 
 	/**
	* Column Info
	* @param  ioBndCd
	*/
	public void	setIoBndCd( String	ioBndCd ) {
		this.ioBndCd =	ioBndCd;
	}
 
	/**
	 * Column Info
	 * @return	ioBndCd
	 */
	 public	 String	getIoBndCd() {
		 return	this.ioBndCd;
	 } 
 	/**
	* Column Info
	* @param  custEml
	*/
	public void	setCustEml( String	custEml ) {
		this.custEml =	custEml;
	}
 
	/**
	 * Column Info
	 * @return	custEml
	 */
	 public	 String	getCustEml() {
		 return	this.custEml;
	 } 
 	/**
	* Column Info
	* @param  invNo
	*/
	public void	setInvNo( String	invNo ) {
		this.invNo =	invNo;
	}
 
	/**
	 * Column Info
	 * @return	invNo
	 */
	 public	 String	getInvNo() {
		 return	this.invNo;
	 } 
 	/**
	* Column Info
	* @param  vvd
	*/
	public void	setVvd( String	vvd ) {
		this.vvd =	vvd;
	}
 
	/**
	 * Column Info
	 * @return	vvd
	 */
	 public	 String	getVvd() {
		 return	this.vvd;
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
	* @param  issueGubn
	*/
	public void	setIssueGubn( String	issueGubn ) {
		this.issueGubn =	issueGubn;
	}
 
	/**
	 * Column Info
	 * @return	issueGubn
	 */
	 public	 String	getIssueGubn() {
		 return	this.issueGubn;
	 } 
 	/**
	* Column Info
	* @param  nameFlag
	*/
	public void	setNameFlag( String	nameFlag ) {
		this.nameFlag =	nameFlag;
	}
 
	/**
	 * Column Info
	 * @return	nameFlag
	 */
	 public	 String	getNameFlag() {
		 return	this.nameFlag;
	 } 
 	/**
	* Column Info
	* @param  custCd
	*/
	public void	setCustCd( String	custCd ) {
		this.custCd =	custCd;
	}
 
	/**
	 * Column Info
	 * @return	custCd
	 */
	 public	 String	getCustCd() {
		 return	this.custCd;
	 } 
 	/**
	* Column Info
	* @param  attach
	*/
	public void	setAttach( String	attach ) {
		this.attach =	attach;
	}
 
	/**
	 * Column Info
	 * @return	attach
	 */
	 public	 String	getAttach() {
		 return	this.attach;
	 } 
 	/**
	* Column Info
	* @param  faxSndDt
	*/
	public void	setFaxSndDt( String	faxSndDt ) {
		this.faxSndDt =	faxSndDt;
	}
 
	/**
	 * Column Info
	 * @return	faxSndDt
	 */
	 public	 String	getFaxSndDt() {
		 return	this.faxSndDt;
	 } 
 	/**
	* Column Info
	* @param  faxSndNo
	*/
	public void	setFaxSndNo( String	faxSndNo ) {
		this.faxSndNo =	faxSndNo;
	}
 
	/**
	 * Column Info
	 * @return	faxSndNo
	 */
	 public	 String	getFaxSndNo() {
		 return	this.faxSndNo;
	 } 
 	/**
	* Column Info
	* @param  issGrpTpCd
	*/
	public void	setIssGrpTpCd( String	issGrpTpCd ) {
		this.issGrpTpCd =	issGrpTpCd;
	}
 
	/**
	 * Column Info
	 * @return	issGrpTpCd
	 */
	 public	 String	getIssGrpTpCd() {
		 return	this.issGrpTpCd;
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
	* @param  accountCreUsrId
	*/
	public void	setAccountCreUsrId( String	accountCreUsrId ) {
		this.accountCreUsrId =	accountCreUsrId;
	}
 
	/**
	 * Column Info
	 * @return	accountCreUsrId
	 */
	 public	 String	getAccountCreUsrId() {
		 return	this.accountCreUsrId;
	 } 
 	/**
	* Column Info
	* @param  accountUpdUsrId
	*/
	public void	setAccountUpdUsrId( String	accountUpdUsrId ) {
		this.accountUpdUsrId =	accountUpdUsrId;
	}
 
	/**
	 * Column Info
	 * @return	accountUpdUsrId
	 */
	 public	 String	getAccountUpdUsrId() {
		 return	this.accountUpdUsrId;
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
		setTitleFlag(JSPUtil.getParameter(request,	prefix + "title_flag", ""));
		setFKey(JSPUtil.getParameter(request,	prefix + "f_key", ""));
		setAttach2(JSPUtil.getParameter(request,	prefix + "attach2", ""));
		setEmlSndDt(JSPUtil.getParameter(request,	prefix + "eml_snd_dt", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setRissDt(JSPUtil.getParameter(request,	prefix + "riss_dt", ""));
		setIssueType(JSPUtil.getParameter(request,	prefix + "issue_type", ""));
		setUsdXchRt(JSPUtil.getParameter(request,	prefix + "usd_xch_rt", ""));
		setIssOfcCd(JSPUtil.getParameter(request,	prefix + "iss_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setAttachView(JSPUtil.getParameter(request,	prefix + "attach_view", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvIssCmbFlg(JSPUtil.getParameter(request,	prefix + "inv_iss_cmb_flg", ""));
		setIssDt(JSPUtil.getParameter(request,	prefix + "iss_dt", ""));
		setLoclPoNo(JSPUtil.getParameter(request,	prefix + "locl_po_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setFSaveId(JSPUtil.getParameter(request,	prefix + "f_save_id", ""));
		setCopyCnt(JSPUtil.getParameter(request,	prefix + "copy_cnt", ""));
		setRdName(JSPUtil.getParameter(request,	prefix + "rd_name", ""));
		setInvIssRmk(JSPUtil.getParameter(request,	prefix + "inv_iss_rmk", ""));
		setInvXchRtDt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt_dt", ""));
		setCustFaxNo(JSPUtil.getParameter(request,	prefix + "cust_fax_no", ""));
		setPortCd(JSPUtil.getParameter(request,	prefix + "port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setSendFlag(JSPUtil.getParameter(request,	prefix + "send_flag", ""));
		setBlSrcNo(JSPUtil.getParameter(request,	prefix + "bl_src_no", ""));
		setActInvNo(JSPUtil.getParameter(request,	prefix + "act_inv_no", ""));
		setAttachView2(JSPUtil.getParameter(request,	prefix + "attach_view2", ""));
		setEmlSndNo(JSPUtil.getParameter(request,	prefix + "eml_snd_no", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setCustEml(JSPUtil.getParameter(request,	prefix + "cust_eml", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setIssueGubn(JSPUtil.getParameter(request,	prefix + "issue_gubn", ""));
		setNameFlag(JSPUtil.getParameter(request,	prefix + "name_flag", ""));
		setCustCd(JSPUtil.getParameter(request,	prefix + "cust_cd", ""));
		setAttach(JSPUtil.getParameter(request,	prefix + "attach", ""));
		setFaxSndDt(JSPUtil.getParameter(request,	prefix + "fax_snd_dt", ""));
		setFaxSndNo(JSPUtil.getParameter(request,	prefix + "fax_snd_no", ""));
		setIssGrpTpCd(JSPUtil.getParameter(request,	prefix + "iss_grp_tp_cd", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request,	prefix + "usr_nm", ""));
		setAccountCreUsrId(JSPUtil.getParameter(request,	prefix + "account_cre_usr_id", ""));
		setAccountUpdUsrId(JSPUtil.getParameter(request,	prefix + "account_upd_usr_id", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvIssMainVO[]
	 */
	public InvIssMainVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvIssMainVO[]
	 */
	public InvIssMainVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvIssMainVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] titleFlag =	(JSPUtil.getParameter(request, prefix +	"title_flag".trim(),	length));
				String[] fKey =	(JSPUtil.getParameter(request, prefix +	"f_key".trim(),	length));
				String[] attach2 =	(JSPUtil.getParameter(request, prefix +	"attach2".trim(),	length));
				String[] emlSndDt =	(JSPUtil.getParameter(request, prefix +	"eml_snd_dt".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] rissDt =	(JSPUtil.getParameter(request, prefix +	"riss_dt".trim(),	length));
				String[] issueType =	(JSPUtil.getParameter(request, prefix +	"issue_type".trim(),	length));
				String[] usdXchRt =	(JSPUtil.getParameter(request, prefix +	"usd_xch_rt".trim(),	length));
				String[] issOfcCd =	(JSPUtil.getParameter(request, prefix +	"iss_ofc_cd".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] attachView =	(JSPUtil.getParameter(request, prefix +	"attach_view".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invIssCmbFlg =	(JSPUtil.getParameter(request, prefix +	"inv_iss_cmb_flg".trim(),	length));
				String[] issDt =	(JSPUtil.getParameter(request, prefix +	"iss_dt".trim(),	length));
				String[] loclPoNo =	(JSPUtil.getParameter(request, prefix +	"locl_po_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] fSaveId =	(JSPUtil.getParameter(request, prefix +	"f_save_id".trim(),	length));
				String[] copyCnt =	(JSPUtil.getParameter(request, prefix +	"copy_cnt".trim(),	length));
				String[] rdName =	(JSPUtil.getParameter(request, prefix +	"rd_name".trim(),	length));
				String[] invIssRmk =	(JSPUtil.getParameter(request, prefix +	"inv_iss_rmk".trim(),	length));
				String[] invXchRtDt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt_dt".trim(),	length));
				String[] custFaxNo =	(JSPUtil.getParameter(request, prefix +	"cust_fax_no".trim(),	length));
				String[] portCd =	(JSPUtil.getParameter(request, prefix +	"port_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] sendFlag =	(JSPUtil.getParameter(request, prefix +	"send_flag".trim(),	length));
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				String[] actInvNo =	(JSPUtil.getParameter(request, prefix +	"act_inv_no".trim(),	length));
				String[] attachView2 =	(JSPUtil.getParameter(request, prefix +	"attach_view2".trim(),	length));
				String[] emlSndNo =	(JSPUtil.getParameter(request, prefix +	"eml_snd_no".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] custEml =	(JSPUtil.getParameter(request, prefix +	"cust_eml".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] issueGubn =	(JSPUtil.getParameter(request, prefix +	"issue_gubn".trim(),	length));
				String[] nameFlag =	(JSPUtil.getParameter(request, prefix +	"name_flag".trim(),	length));
				String[] custCd =	(JSPUtil.getParameter(request, prefix +	"cust_cd".trim(),	length));
				String[] attach =	(JSPUtil.getParameter(request, prefix +	"attach".trim(),	length));
				String[] faxSndDt =	(JSPUtil.getParameter(request, prefix +	"fax_snd_dt".trim(),	length));
				String[] faxSndNo =	(JSPUtil.getParameter(request, prefix +	"fax_snd_no".trim(),	length));
				String[] issGrpTpCd =	(JSPUtil.getParameter(request, prefix +	"iss_grp_tp_cd".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] usrNm =	(JSPUtil.getParameter(request, prefix +	"usr_nm".trim(),	length));
				String[] accountCreUsrId =	(JSPUtil.getParameter(request, prefix +	"account_cre_usr_id".trim(),	length));
				String[] accountUpdUsrId =	(JSPUtil.getParameter(request, prefix +	"account_upd_usr_id".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvIssMainVO();
						if ( titleFlag[i] !=	null)
						model.setTitleFlag( titleFlag[i]);
						if ( fKey[i] !=	null)
						model.setFKey( fKey[i]);
						if ( attach2[i] !=	null)
						model.setAttach2( attach2[i]);
						if ( emlSndDt[i] !=	null)
						model.setEmlSndDt( emlSndDt[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( rissDt[i] !=	null)
						model.setRissDt( rissDt[i]);
						if ( issueType[i] !=	null)
						model.setIssueType( issueType[i]);
						if ( usdXchRt[i] !=	null)
						model.setUsdXchRt( usdXchRt[i]);
						if ( issOfcCd[i] !=	null)
						model.setIssOfcCd( issOfcCd[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( attachView[i] !=	null)
						model.setAttachView( attachView[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invIssCmbFlg[i] !=	null)
						model.setInvIssCmbFlg( invIssCmbFlg[i]);
						if ( issDt[i] !=	null)
						model.setIssDt( issDt[i]);
						if ( loclPoNo[i] !=	null)
						model.setLoclPoNo( loclPoNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( fSaveId[i] !=	null)
						model.setFSaveId( fSaveId[i]);
						if ( copyCnt[i] !=	null)
						model.setCopyCnt( copyCnt[i]);
						if ( rdName[i] !=	null)
						model.setRdName( rdName[i]);
						if ( invIssRmk[i] !=	null)
						model.setInvIssRmk( invIssRmk[i]);
						if ( invXchRtDt[i] !=	null)
						model.setInvXchRtDt( invXchRtDt[i]);
						if ( custFaxNo[i] !=	null)
						model.setCustFaxNo( custFaxNo[i]);
						if ( portCd[i] !=	null)
						model.setPortCd( portCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( sendFlag[i] !=	null)
						model.setSendFlag( sendFlag[i]);
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
						if ( actInvNo[i] !=	null)
						model.setActInvNo( actInvNo[i]);
						if ( attachView2[i] !=	null)
						model.setAttachView2( attachView2[i]);
						if ( emlSndNo[i] !=	null)
						model.setEmlSndNo( emlSndNo[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( custEml[i] !=	null)
						model.setCustEml( custEml[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( issueGubn[i] !=	null)
						model.setIssueGubn( issueGubn[i]);
						if ( nameFlag[i] !=	null)
						model.setNameFlag( nameFlag[i]);
						if ( custCd[i] !=	null)
						model.setCustCd( custCd[i]);
						if ( attach[i] !=	null)
						model.setAttach( attach[i]);
						if ( faxSndDt[i] !=	null)
						model.setFaxSndDt( faxSndDt[i]);
						if ( faxSndNo[i] !=	null)
						model.setFaxSndNo( faxSndNo[i]);
						if ( issGrpTpCd[i] !=	null)
						model.setIssGrpTpCd( issGrpTpCd[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( usrNm[i] !=	null)
						model.setUsrNm( usrNm[i]);
						if ( accountCreUsrId[i] !=	null)
						model.setAccountCreUsrId( accountCreUsrId[i]);
						if ( accountUpdUsrId[i] !=	null)
						model.setAccountUpdUsrId( accountUpdUsrId[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvIssMainVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvIssMainVO[]
	 */
	public InvIssMainVO[]	 getInvIssMainVOs(){
		InvIssMainVO[] vos = (InvIssMainVO[])models.toArray(new	InvIssMainVO[models.size()]);
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
		this.titleFlag =	this.titleFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fKey =	this.fKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attach2 =	this.attach2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt =	this.emlSndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rissDt =	this.rissDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueType =	this.issueType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt =	this.usdXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd =	this.issOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachView =	this.attachView.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssCmbFlg =	this.invIssCmbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt =	this.issDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclPoNo =	this.loclPoNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSaveId =	this.fSaveId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copyCnt =	this.copyCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdName =	this.rdName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssRmk =	this.invIssRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtDt =	this.invXchRtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFaxNo =	this.custFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd =	this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendFlag =	this.sendFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo =	this.blSrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvNo =	this.actInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachView2 =	this.attachView2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo =	this.emlSndNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml =	this.custEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueGubn =	this.issueGubn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nameFlag =	this.nameFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd =	this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attach =	this.attach.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndDt =	this.faxSndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndNo =	this.faxSndNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issGrpTpCd =	this.issGrpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm =	this.usrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountCreUsrId =	this.accountCreUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountUpdUsrId =	this.accountUpdUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}