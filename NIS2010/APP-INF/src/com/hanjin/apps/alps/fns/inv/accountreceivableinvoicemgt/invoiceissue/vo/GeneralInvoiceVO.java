/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : GeneralInvoiceVO.java
 *@FileTitle : GeneralInvoiceVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.07.20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.07.20  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
 * - 愿��젴	Event�뿉�꽌	�옉�꽦,	�꽌踰꾩떎�뻾�슂泥��떆	PDTO�쓽 �뿭�븷�쓣 �닔�뻾�븯�뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class GeneralInvoiceVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<GeneralInvoiceVO>  models =	new	ArrayList<GeneralInvoiceVO>();


	/*	Column Info	*/
	private  String	 scp   =  null;
	/*	Column Info	*/
	private  String	 port   =  null;
	/*	Column Info	*/
	private  String	 xchRtDt   =  null;
	/*	Column Info	*/
	private  String	 totInvCnt   =  null;
	/*	Column Info	*/
	private  String	 fromDt   =  null;
	/*	Column Info	*/
	private  String	 ifUserId   =  null;
	/*	Column Info	*/
	private  String	 chkVvd   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 invDupFlg   =  null;
	/*	Column Info	*/
	private  String	 otsSmryCd   =  null;
	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 fromInvNo   =  null;
	/*	Column Info	*/
	private  String	 custRgstNo   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invMltBlIssFlg   =  null;
	/*	Column Info	*/
	private  String	 svrId   =  null;
	/*	Column Info	*/
	private  String	 loginOfcCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 chkCust   =  null;
	/*	Column Info	*/
	private  String	 blNos   =  null;
	/*	Column Info	*/
	private  String	 copyCnt   =  null;
	/*	Column Info	*/
	private  String	 crAmt   =  null;
	/*	Column Info	*/
	private  String	 vvdCd   =  null;
	/*	Column Info	*/
	private  String	 invType   =  null;
	/*	Column Info	*/
	private  String	 cntcPsonNm   =  null;
	/*	Column Info	*/
	private  String	 userId   =  null;
	/*	Column Info	*/
	private  String	 portCd   =  null;
	/*	Column Info	*/
	private  String	 custCntCd   =  null;
	/*	Column Info	*/
	private  String	 phnNo   =  null;
	/*	Column Info	*/
	private  String	 xchRt   =  null;
	/*	Column Info	*/
	private  String	 custSeq   =  null;
	/*	Column Info	*/
	private  String	 bnd   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 crCurrCd   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd2   =  null;
	/*	Column Info	*/
	private  String	 issOpt   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 dtOpt   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 toDt   =  null;
	/*	Column Info	*/
	private  String	 chkUserid   =  null;
	/*	Column Info	*/
	private  String	 dtOption   =  null;
	/*	Column Info	*/
	private  String	 chkBlno   =  null;
	/*	Column Info	*/
	private  String	 faxNo   =  null;
	/*	Column Info	*/
	private  String	 toInvNo   =  null;
	/*	Column Info	*/
	private  String	 chkAll   =  null;
	/*	Column Info	*/
	private  String	 wrkNo   =  null;
	/*	Column Info	*/
	private  String	 issueType   =  null;
	/*	Column Info	*/
	private  String	 emailFlag   =  null;
	/*	Column Info	*/
	private  String	 revType   =  null;
	/*	Column Info	*/
	private  String	 vnInvPayMzdCd   =  null;
	/*	Column Info	*/
	private  String	 autoInvIssFlg   =  null;
	/*	Column Info	*/
	private  String	 indIssTpCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public GeneralInvoiceVO(){}

	public GeneralInvoiceVO(String scp,String port,String xchRtDt,String totInvCnt,String fromDt,String ifUserId,String chkVvd,String custNm,String invDupFlg,String otsSmryCd,String svcScpCd,String fromInvNo,String custRgstNo,String blNo,String pagerows,String invMltBlIssFlg,String svrId,String loginOfcCd,String ibflag,String chkCust,String blNos,String copyCnt,String crAmt,String vvdCd,String invType,String cntcPsonNm,String userId,String portCd,String custCntCd,String phnNo,String xchRt,String custSeq,String bnd,String ioBndCd,String crCurrCd,String arOfcCd2,String issOpt,String arOfcCd,String dtOpt,String vvd,String toDt,String chkUserid,String dtOption,String chkBlno,String faxNo,String toInvNo,String chkAll,String wrkNo,String issueType,String emailFlag,String revType,String vnInvPayMzdCd,String autoInvIssFlg,String indIssTpCd)	{
		this.scp  = scp ;
		this.port  = port ;
		this.xchRtDt  = xchRtDt ;
		this.totInvCnt  = totInvCnt ;
		this.fromDt  = fromDt ;
		this.ifUserId  = ifUserId ;
		this.chkVvd  = chkVvd ;
		this.custNm  = custNm ;
		this.invDupFlg  = invDupFlg ;
		this.otsSmryCd  = otsSmryCd ;
		this.svcScpCd  = svcScpCd ;
		this.fromInvNo  = fromInvNo ;
		this.custRgstNo  = custRgstNo ;
		this.blNo  = blNo ;
		this.pagerows  = pagerows ;
		this.invMltBlIssFlg  = invMltBlIssFlg ;
		this.svrId  = svrId ;
		this.loginOfcCd  = loginOfcCd ;
		this.ibflag  = ibflag ;
		this.chkCust  = chkCust ;
		this.blNos  = blNos ;
		this.copyCnt  = copyCnt ;
		this.crAmt  = crAmt ;
		this.vvdCd  = vvdCd ;
		this.invType  = invType ;
		this.cntcPsonNm  = cntcPsonNm ;
		this.userId  = userId ;
		this.portCd  = portCd ;
		this.custCntCd  = custCntCd ;
		this.phnNo  = phnNo ;
		this.xchRt  = xchRt ;
		this.custSeq  = custSeq ;
		this.bnd  = bnd ;
		this.ioBndCd  = ioBndCd ;
		this.crCurrCd  = crCurrCd ;
		this.arOfcCd2  = arOfcCd2 ;
		this.issOpt  = issOpt ;
		this.arOfcCd  = arOfcCd ;
		this.dtOpt  = dtOpt ;
		this.vvd  = vvd ;
		this.toDt  = toDt ;
		this.chkUserid  = chkUserid ;
		this.dtOption  = dtOption ;
		this.chkBlno  = chkBlno ;
		this.faxNo  = faxNo ;
		this.toInvNo  = toInvNo ;
		this.chkAll  = chkAll ;
		this.wrkNo  = wrkNo ;
		this.issueType  = issueType ;
		this.emailFlag  = emailFlag ;
		this.revType  = revType ;
		this.vnInvPayMzdCd  = vnInvPayMzdCd ;
		this.autoInvIssFlg  = autoInvIssFlg ;
		this.indIssTpCd  = indIssTpCd ;
	}


	/**
	 * �뀒�씠釉� 而щ읆�뿉 ���옣�븷 媛믪쓣 Hashtable<"column_name", "value">	濡� 諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scp", getScp());		
		this.hashColumns.put("port", getPort());		
		this.hashColumns.put("xch_rt_dt", getXchRtDt());		
		this.hashColumns.put("tot_inv_cnt", getTotInvCnt());		
		this.hashColumns.put("from_dt", getFromDt());		
		this.hashColumns.put("if_user_id", getIfUserId());		
		this.hashColumns.put("chk_vvd", getChkVvd());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("inv_dup_flg", getInvDupFlg());		
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());		
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
		this.hashColumns.put("from_inv_no", getFromInvNo());		
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_mlt_bl_iss_flg", getInvMltBlIssFlg());		
		this.hashColumns.put("svr_id", getSvrId());		
		this.hashColumns.put("login_ofc_cd", getLoginOfcCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("chk_cust", getChkCust());		
		this.hashColumns.put("bl_nos", getBlNos());		
		this.hashColumns.put("copy_cnt", getCopyCnt());		
		this.hashColumns.put("cr_amt", getCrAmt());		
		this.hashColumns.put("vvd_cd", getVvdCd());		
		this.hashColumns.put("inv_type", getInvType());		
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());		
		this.hashColumns.put("user_id", getUserId());		
		this.hashColumns.put("port_cd", getPortCd());		
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());		
		this.hashColumns.put("phn_no", getPhnNo());		
		this.hashColumns.put("xch_rt", getXchRt());		
		this.hashColumns.put("cust_seq", getCustSeq());		
		this.hashColumns.put("bnd", getBnd());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("cr_curr_cd", getCrCurrCd());		
		this.hashColumns.put("ar_ofc_cd2", getArOfcCd2());		
		this.hashColumns.put("iss_opt", getIssOpt());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("dt_opt", getDtOpt());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("to_dt", getToDt());		
		this.hashColumns.put("chk_userid", getChkUserid());		
		this.hashColumns.put("dt_option", getDtOption());		
		this.hashColumns.put("chk_blno", getChkBlno());		
		this.hashColumns.put("fax_no", getFaxNo());		
		this.hashColumns.put("to_inv_no", getToInvNo());		
		this.hashColumns.put("chk_all", getChkAll());		
		this.hashColumns.put("wrk_no", getWrkNo());		
		this.hashColumns.put("issue_type", getIssueType());		
		this.hashColumns.put("email_flag", getEmailFlag());		
		this.hashColumns.put("rev_type", getRevType());		
		this.hashColumns.put("vn_inv_pay_mzd_cd", getVnInvPayMzdCd());		
		this.hashColumns.put("auto_inv_iss_flg", getAutoInvIssFlg());		
		this.hashColumns.put("ind_iss_tp_cd", getIndIssTpCd());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	���쓳�릺�뒗 硫ㅻ쾭蹂��닔紐낆쓣	���옣�븯�뿬 Hashtable<"column_name", "variable"> 濡� 諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("scp", "scp");
		this.hashFields.put("port", "port");
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("tot_inv_cnt", "totInvCnt");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("if_user_id", "ifUserId");
		this.hashFields.put("chk_vvd", "chkVvd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("inv_dup_flg", "invDupFlg");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("from_inv_no", "fromInvNo");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_mlt_bl_iss_flg", "invMltBlIssFlg");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("login_ofc_cd", "loginOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chk_cust", "chkCust");
		this.hashFields.put("bl_nos", "blNos");
		this.hashFields.put("copy_cnt", "copyCnt");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("inv_type", "invType");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("xch_rt", "xchRt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bnd", "bnd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cr_curr_cd", "crCurrCd");
		this.hashFields.put("ar_ofc_cd2", "arOfcCd2");
		this.hashFields.put("iss_opt", "issOpt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("dt_opt", "dtOpt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("chk_userid", "chkUserid");
		this.hashFields.put("dt_option", "dtOption");
		this.hashFields.put("chk_blno", "chkBlno");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("to_inv_no", "toInvNo");
		this.hashFields.put("chk_all", "chkAll");
		this.hashFields.put("wrk_no", "wrkNo");
		this.hashFields.put("issue_type", "issueType");
		this.hashFields.put("email_flag", "emailFlag");
		this.hashFields.put("rev_type", "revType");
		this.hashFields.put("vn_inv_pay_mzd_cd", "vnInvPayMzdCd");
		this.hashFields.put("auto_inv_iss_flg", "autoInvIssFlg");
		this.hashFields.put("ind_iss_tp_cd", "indIssTpCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  scp
	*/
	public void	setScp( String	scp ) {
		this.scp =	scp;
	}
 
	/**
	 * Column Info
	 * @return	scp
	 */
	 public	 String	getScp() {
		 return	this.scp;
	 } 
 	/**
	* Column Info
	* @param  port
	*/
	public void	setPort( String	port ) {
		this.port =	port;
	}
 
	/**
	 * Column Info
	 * @return	port
	 */
	 public	 String	getPort() {
		 return	this.port;
	 } 
 	/**
	* Column Info
	* @param  xchRtDt
	*/
	public void	setXchRtDt( String	xchRtDt ) {
		this.xchRtDt =	xchRtDt;
	}
 
	/**
	 * Column Info
	 * @return	xchRtDt
	 */
	 public	 String	getXchRtDt() {
		 return	this.xchRtDt;
	 } 
 	/**
	* Column Info
	* @param  totInvCnt
	*/
	public void	setTotInvCnt( String	totInvCnt ) {
		this.totInvCnt =	totInvCnt;
	}
 
	/**
	 * Column Info
	 * @return	totInvCnt
	 */
	 public	 String	getTotInvCnt() {
		 return	this.totInvCnt;
	 } 
 	/**
	* Column Info
	* @param  fromDt
	*/
	public void	setFromDt( String	fromDt ) {
		this.fromDt =	fromDt;
	}
 
	/**
	 * Column Info
	 * @return	fromDt
	 */
	 public	 String	getFromDt() {
		 return	this.fromDt;
	 } 
 	/**
	* Column Info
	* @param  ifUserId
	*/
	public void	setIfUserId( String	ifUserId ) {
		this.ifUserId =	ifUserId;
	}
 
	/**
	 * Column Info
	 * @return	ifUserId
	 */
	 public	 String	getIfUserId() {
		 return	this.ifUserId;
	 } 
 	/**
	* Column Info
	* @param  chkVvd
	*/
	public void	setChkVvd( String	chkVvd ) {
		this.chkVvd =	chkVvd;
	}
 
	/**
	 * Column Info
	 * @return	chkVvd
	 */
	 public	 String	getChkVvd() {
		 return	this.chkVvd;
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
	* @param  invDupFlg
	*/
	public void	setInvDupFlg( String	invDupFlg ) {
		this.invDupFlg =	invDupFlg;
	}
 
	/**
	 * Column Info
	 * @return	invDupFlg
	 */
	 public	 String	getInvDupFlg() {
		 return	this.invDupFlg;
	 } 
 	/**
	* Column Info
	* @param  otsSmryCd
	*/
	public void	setOtsSmryCd( String	otsSmryCd ) {
		this.otsSmryCd =	otsSmryCd;
	}
 
	/**
	 * Column Info
	 * @return	otsSmryCd
	 */
	 public	 String	getOtsSmryCd() {
		 return	this.otsSmryCd;
	 } 
 	/**
	* Column Info
	* @param  svcScpCd
	*/
	public void	setSvcScpCd( String	svcScpCd ) {
		this.svcScpCd =	svcScpCd;
	}
 
	/**
	 * Column Info
	 * @return	svcScpCd
	 */
	 public	 String	getSvcScpCd() {
		 return	this.svcScpCd;
	 } 
 	/**
	* Column Info
	* @param  fromInvNo
	*/
	public void	setFromInvNo( String	fromInvNo ) {
		this.fromInvNo =	fromInvNo;
	}
 
	/**
	 * Column Info
	 * @return	fromInvNo
	 */
	 public	 String	getFromInvNo() {
		 return	this.fromInvNo;
	 } 
 	/**
	* Column Info
	* @param  custRgstNo
	*/
	public void	setCustRgstNo( String	custRgstNo ) {
		this.custRgstNo =	custRgstNo;
	}
 
	/**
	 * Column Info
	 * @return	custRgstNo
	 */
	 public	 String	getCustRgstNo() {
		 return	this.custRgstNo;
	 } 
 	/**
	* Column Info
	* @param  blNo
	*/
	public void	setBlNo( String	blNo ) {
		this.blNo =	blNo;
	}
 
	/**
	 * Column Info
	 * @return	blNo
	 */
	 public	 String	getBlNo() {
		 return	this.blNo;
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
	* @param  invMltBlIssFlg
	*/
	public void	setInvMltBlIssFlg( String	invMltBlIssFlg ) {
		this.invMltBlIssFlg =	invMltBlIssFlg;
	}
 
	/**
	 * Column Info
	 * @return	invMltBlIssFlg
	 */
	 public	 String	getInvMltBlIssFlg() {
		 return	this.invMltBlIssFlg;
	 } 
 	/**
	* Column Info
	* @param  svrId
	*/
	public void	setSvrId( String	svrId ) {
		this.svrId =	svrId;
	}
 
	/**
	 * Column Info
	 * @return	svrId
	 */
	 public	 String	getSvrId() {
		 return	this.svrId;
	 } 
 	/**
	* Column Info
	* @param  loginOfcCd
	*/
	public void	setLoginOfcCd( String	loginOfcCd ) {
		this.loginOfcCd =	loginOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	loginOfcCd
	 */
	 public	 String	getLoginOfcCd() {
		 return	this.loginOfcCd;
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
	* @param  chkCust
	*/
	public void	setChkCust( String	chkCust ) {
		this.chkCust =	chkCust;
	}
 
	/**
	 * Column Info
	 * @return	chkCust
	 */
	 public	 String	getChkCust() {
		 return	this.chkCust;
	 } 
 	/**
	* Column Info
	* @param  blNos
	*/
	public void	setBlNos( String	blNos ) {
		this.blNos =	blNos;
	}
 
	/**
	 * Column Info
	 * @return	blNos
	 */
	 public	 String	getBlNos() {
		 return	this.blNos;
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
	* @param  crAmt
	*/
	public void	setCrAmt( String	crAmt ) {
		this.crAmt =	crAmt;
	}
 
	/**
	 * Column Info
	 * @return	crAmt
	 */
	 public	 String	getCrAmt() {
		 return	this.crAmt;
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
	* @param  invType
	*/
	public void	setInvType( String	invType ) {
		this.invType =	invType;
	}
 
	/**
	 * Column Info
	 * @return	invType
	 */
	 public	 String	getInvType() {
		 return	this.invType;
	 } 
 	/**
	* Column Info
	* @param  cntcPsonNm
	*/
	public void	setCntcPsonNm( String	cntcPsonNm ) {
		this.cntcPsonNm =	cntcPsonNm;
	}
 
	/**
	 * Column Info
	 * @return	cntcPsonNm
	 */
	 public	 String	getCntcPsonNm() {
		 return	this.cntcPsonNm;
	 } 
 	/**
	* Column Info
	* @param  userId
	*/
	public void	setUserId( String	userId ) {
		this.userId =	userId;
	}
 
	/**
	 * Column Info
	 * @return	userId
	 */
	 public	 String	getUserId() {
		 return	this.userId;
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
	* @param  phnNo
	*/
	public void	setPhnNo( String	phnNo ) {
		this.phnNo =	phnNo;
	}
 
	/**
	 * Column Info
	 * @return	phnNo
	 */
	 public	 String	getPhnNo() {
		 return	this.phnNo;
	 } 
 	/**
	* Column Info
	* @param  xchRt
	*/
	public void	setXchRt( String	xchRt ) {
		this.xchRt =	xchRt;
	}
 
	/**
	 * Column Info
	 * @return	xchRt
	 */
	 public	 String	getXchRt() {
		 return	this.xchRt;
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
	* @param  bnd
	*/
	public void	setBnd( String	bnd ) {
		this.bnd =	bnd;
	}
 
	/**
	 * Column Info
	 * @return	bnd
	 */
	 public	 String	getBnd() {
		 return	this.bnd;
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
	* @param  crCurrCd
	*/
	public void	setCrCurrCd( String	crCurrCd ) {
		this.crCurrCd =	crCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	crCurrCd
	 */
	 public	 String	getCrCurrCd() {
		 return	this.crCurrCd;
	 } 
 	/**
	* Column Info
	* @param  arOfcCd2
	*/
	public void	setArOfcCd2( String	arOfcCd2 ) {
		this.arOfcCd2 =	arOfcCd2;
	}
 
	/**
	 * Column Info
	 * @return	arOfcCd2
	 */
	 public	 String	getArOfcCd2() {
		 return	this.arOfcCd2;
	 } 
 	/**
	* Column Info
	* @param  issOpt
	*/
	public void	setIssOpt( String	issOpt ) {
		this.issOpt =	issOpt;
	}
 
	/**
	 * Column Info
	 * @return	issOpt
	 */
	 public	 String	getIssOpt() {
		 return	this.issOpt;
	 } 
 	/**
	* Column Info
	* @param  arOfcCd
	*/
	public void	setArOfcCd( String	arOfcCd ) {
		this.arOfcCd =	arOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	arOfcCd
	 */
	 public	 String	getArOfcCd() {
		 return	this.arOfcCd;
	 } 
 	/**
	* Column Info
	* @param  dtOpt
	*/
	public void	setDtOpt( String	dtOpt ) {
		this.dtOpt =	dtOpt;
	}
 
	/**
	 * Column Info
	 * @return	dtOpt
	 */
	 public	 String	getDtOpt() {
		 return	this.dtOpt;
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
	* @param  toDt
	*/
	public void	setToDt( String	toDt ) {
		this.toDt =	toDt;
	}
 
	/**
	 * Column Info
	 * @return	toDt
	 */
	 public	 String	getToDt() {
		 return	this.toDt;
	 } 
 	/**
	* Column Info
	* @param  chkUserid
	*/
	public void	setChkUserid( String	chkUserid ) {
		this.chkUserid =	chkUserid;
	}
 
	/**
	 * Column Info
	 * @return	chkUserid
	 */
	 public	 String	getChkUserid() {
		 return	this.chkUserid;
	 } 
 	/**
	* Column Info
	* @param  dtOption
	*/
	public void	setDtOption( String	dtOption ) {
		this.dtOption =	dtOption;
	}
 
	/**
	 * Column Info
	 * @return	dtOption
	 */
	 public	 String	getDtOption() {
		 return	this.dtOption;
	 } 
 	/**
	* Column Info
	* @param  chkBlno
	*/
	public void	setChkBlno( String	chkBlno ) {
		this.chkBlno =	chkBlno;
	}
 
	/**
	 * Column Info
	 * @return	chkBlno
	 */
	 public	 String	getChkBlno() {
		 return	this.chkBlno;
	 } 
 	/**
	* Column Info
	* @param  faxNo
	*/
	public void	setFaxNo( String	faxNo ) {
		this.faxNo =	faxNo;
	}
 
	/**
	 * Column Info
	 * @return	faxNo
	 */
	 public	 String	getFaxNo() {
		 return	this.faxNo;
	 } 
 	/**
	* Column Info
	* @param  toInvNo
	*/
	public void	setToInvNo( String	toInvNo ) {
		this.toInvNo =	toInvNo;
	}
 
	/**
	 * Column Info
	 * @return	toInvNo
	 */
	 public	 String	getToInvNo() {
		 return	this.toInvNo;
	 } 
 	/**
	* Column Info
	* @param  chkAll
	*/
	public void	setChkAll( String	chkAll ) {
		this.chkAll =	chkAll;
	}
 
	/**
	 * Column Info
	 * @return	chkAll
	 */
	 public	 String	getChkAll() {
		 return	this.chkAll;
	 } 
 	/**
	* Column Info
	* @param  wrkNo
	*/
	public void	setWrkNo( String	wrkNo ) {
		this.wrkNo =	wrkNo;
	}
 
	/**
	 * Column Info
	 * @return	wrkNo
	 */
	 public	 String	getWrkNo() {
		 return	this.wrkNo;
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
	* @param  emailFlag
	*/
	public void	setEmailFlag( String	emailFlag ) {
		this.emailFlag =	emailFlag;
	}
 
	/**
	 * Column Info
	 * @return	emailFlag
	 */
	 public	 String	getEmailFlag() {
		 return	this.emailFlag;
	 } 
 	/**
	* Column Info
	* @param  revType
	*/
	public void	setRevType( String	revType ) {
		this.revType =	revType;
	}
 
	/**
	 * Column Info
	 * @return	revType
	 */
	 public	 String	getRevType() {
		 return	this.revType;
	 } 
 	/**
	* Column Info
	* @param  vnInvPayMzdCd
	*/
	public void	setVnInvPayMzdCd( String	vnInvPayMzdCd ) {
		this.vnInvPayMzdCd =	vnInvPayMzdCd;
	}
 
	/**
	 * Column Info
	 * @return	vnInvPayMzdCd
	 */
	 public	 String	getVnInvPayMzdCd() {
		 return	this.vnInvPayMzdCd;
	 } 
 	/**
	* Column Info
	* @param  autoInvIssFlg
	*/
	public void	setAutoInvIssFlg( String	autoInvIssFlg ) {
		this.autoInvIssFlg =	autoInvIssFlg;
	}
 
	/**
	 * Column Info
	 * @return	autoInvIssFlg
	 */
	 public	 String	getAutoInvIssFlg() {
		 return	this.autoInvIssFlg;
	 } 
 	/**
	* Column Info
	* @param  indIssTpCd
	*/
	public void	setIndIssTpCd( String	indIssTpCd ) {
		this.indIssTpCd =	indIssTpCd;
	}
 
	/**
	 * Column Info
	 * @return	indIssTpCd
	 */
	 public	 String	getIndIssTpCd() {
		 return	this.indIssTpCd;
	 } 

	/**
	 * Request �쓽 �뜲�씠�꽣瑜� 異붿텧�븯�뿬 VO �쓽	硫ㅻ쾭蹂��닔�뿉 �꽕�젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request �쓽 �뜲�씠�꽣瑜� 異붿텧�븯�뿬 VO �쓽	硫ㅻ쾭蹂��닔�뿉 �꽕�젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setScp(JSPUtil.getParameter(request,	prefix + "scp", ""));
		setPort(JSPUtil.getParameter(request,	prefix + "port", ""));
		setXchRtDt(JSPUtil.getParameter(request,	prefix + "xch_rt_dt", ""));
		setTotInvCnt(JSPUtil.getParameter(request,	prefix + "tot_inv_cnt", ""));
		setFromDt(JSPUtil.getParameter(request,	prefix + "from_dt", ""));
		setIfUserId(JSPUtil.getParameter(request,	prefix + "if_user_id", ""));
		setChkVvd(JSPUtil.getParameter(request,	prefix + "chk_vvd", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setInvDupFlg(JSPUtil.getParameter(request,	prefix + "inv_dup_flg", ""));
		setOtsSmryCd(JSPUtil.getParameter(request,	prefix + "ots_smry_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setFromInvNo(JSPUtil.getParameter(request,	prefix + "from_inv_no", ""));
		setCustRgstNo(JSPUtil.getParameter(request,	prefix + "cust_rgst_no", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvMltBlIssFlg(JSPUtil.getParameter(request,	prefix + "inv_mlt_bl_iss_flg", ""));
		setSvrId(JSPUtil.getParameter(request,	prefix + "svr_id", ""));
		setLoginOfcCd(JSPUtil.getParameter(request,	prefix + "login_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setChkCust(JSPUtil.getParameter(request,	prefix + "chk_cust", ""));
		setBlNos(JSPUtil.getParameter(request,	prefix + "bl_nos", ""));
		setCopyCnt(JSPUtil.getParameter(request,	prefix + "copy_cnt", ""));
		setCrAmt(JSPUtil.getParameter(request,	prefix + "cr_amt", ""));
		setVvdCd(JSPUtil.getParameter(request,	prefix + "vvd_cd", ""));
		setInvType(JSPUtil.getParameter(request,	prefix + "inv_type", ""));
		setCntcPsonNm(JSPUtil.getParameter(request,	prefix + "cntc_pson_nm", ""));
		setUserId(JSPUtil.getParameter(request,	prefix + "user_id", ""));
		setPortCd(JSPUtil.getParameter(request,	prefix + "port_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setPhnNo(JSPUtil.getParameter(request,	prefix + "phn_no", ""));
		setXchRt(JSPUtil.getParameter(request,	prefix + "xch_rt", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setBnd(JSPUtil.getParameter(request,	prefix + "bnd", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setCrCurrCd(JSPUtil.getParameter(request,	prefix + "cr_curr_cd", ""));
		setArOfcCd2(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd2", ""));
		setIssOpt(JSPUtil.getParameter(request,	prefix + "iss_opt", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setDtOpt(JSPUtil.getParameter(request,	prefix + "dt_opt", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setToDt(JSPUtil.getParameter(request,	prefix + "to_dt", ""));
		setChkUserid(JSPUtil.getParameter(request,	prefix + "chk_userid", ""));
		setDtOption(JSPUtil.getParameter(request,	prefix + "dt_option", ""));
		setChkBlno(JSPUtil.getParameter(request,	prefix + "chk_blno", ""));
		setFaxNo(JSPUtil.getParameter(request,	prefix + "fax_no", ""));
		setToInvNo(JSPUtil.getParameter(request,	prefix + "to_inv_no", ""));
		setChkAll(JSPUtil.getParameter(request,	prefix + "chk_all", ""));
		setWrkNo(JSPUtil.getParameter(request,	prefix + "wrk_no", ""));
		setIssueType(JSPUtil.getParameter(request,	prefix + "issue_type", ""));
		setEmailFlag(JSPUtil.getParameter(request,	prefix + "email_flag", ""));
		setRevType(JSPUtil.getParameter(request,	prefix + "rev_type", ""));
		setVnInvPayMzdCd(JSPUtil.getParameter(request,	prefix + "vn_inv_pay_mzd_cd", ""));
		setAutoInvIssFlg(JSPUtil.getParameter(request,	prefix + "auto_inv_iss_flg", ""));
		setIndIssTpCd(JSPUtil.getParameter(request,	prefix + "ind_iss_tp_cd", ""));
	}
	
	/**
	 * Request �쓽 �뜲�씠�꽣瑜� VO 諛곗뿴濡� 蹂��솚�븯�뿬 諛섑솚.
	 * @param request
	 * @return GeneralInvoiceVO[]
	 */
	public GeneralInvoiceVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �꽆�뼱�삩 �뿬�윭 嫄�	DATA瑜� VO Class �뿉 �떞�뒗�떎.
	 * @param request
	 * @param prefix
	 * @return GeneralInvoiceVO[]
	 */
	public GeneralInvoiceVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		GeneralInvoiceVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] scp =	(JSPUtil.getParameter(request, prefix +	"scp".trim(),	length));
				String[] port =	(JSPUtil.getParameter(request, prefix +	"port".trim(),	length));
				String[] xchRtDt =	(JSPUtil.getParameter(request, prefix +	"xch_rt_dt".trim(),	length));
				String[] totInvCnt =	(JSPUtil.getParameter(request, prefix +	"tot_inv_cnt".trim(),	length));
				String[] fromDt =	(JSPUtil.getParameter(request, prefix +	"from_dt".trim(),	length));
				String[] ifUserId =	(JSPUtil.getParameter(request, prefix +	"if_user_id".trim(),	length));
				String[] chkVvd =	(JSPUtil.getParameter(request, prefix +	"chk_vvd".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] invDupFlg =	(JSPUtil.getParameter(request, prefix +	"inv_dup_flg".trim(),	length));
				String[] otsSmryCd =	(JSPUtil.getParameter(request, prefix +	"ots_smry_cd".trim(),	length));
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] fromInvNo =	(JSPUtil.getParameter(request, prefix +	"from_inv_no".trim(),	length));
				String[] custRgstNo =	(JSPUtil.getParameter(request, prefix +	"cust_rgst_no".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invMltBlIssFlg =	(JSPUtil.getParameter(request, prefix +	"inv_mlt_bl_iss_flg".trim(),	length));
				String[] svrId =	(JSPUtil.getParameter(request, prefix +	"svr_id".trim(),	length));
				String[] loginOfcCd =	(JSPUtil.getParameter(request, prefix +	"login_ofc_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] chkCust =	(JSPUtil.getParameter(request, prefix +	"chk_cust".trim(),	length));
				String[] blNos =	(JSPUtil.getParameter(request, prefix +	"bl_nos".trim(),	length));
				String[] copyCnt =	(JSPUtil.getParameter(request, prefix +	"copy_cnt".trim(),	length));
				String[] crAmt =	(JSPUtil.getParameter(request, prefix +	"cr_amt".trim(),	length));
				String[] vvdCd =	(JSPUtil.getParameter(request, prefix +	"vvd_cd".trim(),	length));
				String[] invType =	(JSPUtil.getParameter(request, prefix +	"inv_type".trim(),	length));
				String[] cntcPsonNm =	(JSPUtil.getParameter(request, prefix +	"cntc_pson_nm".trim(),	length));
				String[] userId =	(JSPUtil.getParameter(request, prefix +	"user_id".trim(),	length));
				String[] portCd =	(JSPUtil.getParameter(request, prefix +	"port_cd".trim(),	length));
				String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd".trim(),	length));
				String[] phnNo =	(JSPUtil.getParameter(request, prefix +	"phn_no".trim(),	length));
				String[] xchRt =	(JSPUtil.getParameter(request, prefix +	"xch_rt".trim(),	length));
				String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq".trim(),	length));
				String[] bnd =	(JSPUtil.getParameter(request, prefix +	"bnd".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] crCurrCd =	(JSPUtil.getParameter(request, prefix +	"cr_curr_cd".trim(),	length));
				String[] arOfcCd2 =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd2".trim(),	length));
				String[] issOpt =	(JSPUtil.getParameter(request, prefix +	"iss_opt".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] dtOpt =	(JSPUtil.getParameter(request, prefix +	"dt_opt".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] toDt =	(JSPUtil.getParameter(request, prefix +	"to_dt".trim(),	length));
				String[] chkUserid =	(JSPUtil.getParameter(request, prefix +	"chk_userid".trim(),	length));
				String[] dtOption =	(JSPUtil.getParameter(request, prefix +	"dt_option".trim(),	length));
				String[] chkBlno =	(JSPUtil.getParameter(request, prefix +	"chk_blno".trim(),	length));
				String[] faxNo =	(JSPUtil.getParameter(request, prefix +	"fax_no".trim(),	length));
				String[] toInvNo =	(JSPUtil.getParameter(request, prefix +	"to_inv_no".trim(),	length));
				String[] chkAll =	(JSPUtil.getParameter(request, prefix +	"chk_all".trim(),	length));
				String[] wrkNo =	(JSPUtil.getParameter(request, prefix +	"wrk_no".trim(),	length));
				String[] issueType =	(JSPUtil.getParameter(request, prefix +	"issue_type".trim(),	length));
				String[] emailFlag =	(JSPUtil.getParameter(request, prefix +	"email_flag".trim(),	length));
				String[] revType =	(JSPUtil.getParameter(request, prefix +	"rev_type".trim(),	length));
				String[] vnInvPayMzdCd =	(JSPUtil.getParameter(request, prefix +	"vn_inv_pay_mzd_cd".trim(),	length));
				String[] autoInvIssFlg =	(JSPUtil.getParameter(request, prefix +	"auto_inv_iss_flg".trim(),	length));
				String[] indIssTpCd =	(JSPUtil.getParameter(request, prefix +	"ind_iss_tp_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	GeneralInvoiceVO();
						if ( scp[i] !=	null)
						model.setScp( scp[i]);
						if ( port[i] !=	null)
						model.setPort( port[i]);
						if ( xchRtDt[i] !=	null)
						model.setXchRtDt( xchRtDt[i]);
						if ( totInvCnt[i] !=	null)
						model.setTotInvCnt( totInvCnt[i]);
						if ( fromDt[i] !=	null)
						model.setFromDt( fromDt[i]);
						if ( ifUserId[i] !=	null)
						model.setIfUserId( ifUserId[i]);
						if ( chkVvd[i] !=	null)
						model.setChkVvd( chkVvd[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( invDupFlg[i] !=	null)
						model.setInvDupFlg( invDupFlg[i]);
						if ( otsSmryCd[i] !=	null)
						model.setOtsSmryCd( otsSmryCd[i]);
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( fromInvNo[i] !=	null)
						model.setFromInvNo( fromInvNo[i]);
						if ( custRgstNo[i] !=	null)
						model.setCustRgstNo( custRgstNo[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invMltBlIssFlg[i] !=	null)
						model.setInvMltBlIssFlg( invMltBlIssFlg[i]);
						if ( svrId[i] !=	null)
						model.setSvrId( svrId[i]);
						if ( loginOfcCd[i] !=	null)
						model.setLoginOfcCd( loginOfcCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( chkCust[i] !=	null)
						model.setChkCust( chkCust[i]);
						if ( blNos[i] !=	null)
						model.setBlNos( blNos[i]);
						if ( copyCnt[i] !=	null)
						model.setCopyCnt( copyCnt[i]);
						if ( crAmt[i] !=	null)
						model.setCrAmt( crAmt[i]);
						if ( vvdCd[i] !=	null)
						model.setVvdCd( vvdCd[i]);
						if ( invType[i] !=	null)
						model.setInvType( invType[i]);
						if ( cntcPsonNm[i] !=	null)
						model.setCntcPsonNm( cntcPsonNm[i]);
						if ( userId[i] !=	null)
						model.setUserId( userId[i]);
						if ( portCd[i] !=	null)
						model.setPortCd( portCd[i]);
						if ( custCntCd[i] !=	null)
						model.setCustCntCd( custCntCd[i]);
						if ( phnNo[i] !=	null)
						model.setPhnNo( phnNo[i]);
						if ( xchRt[i] !=	null)
						model.setXchRt( xchRt[i]);
						if ( custSeq[i] !=	null)
						model.setCustSeq( custSeq[i]);
						if ( bnd[i] !=	null)
						model.setBnd( bnd[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( crCurrCd[i] !=	null)
						model.setCrCurrCd( crCurrCd[i]);
						if ( arOfcCd2[i] !=	null)
						model.setArOfcCd2( arOfcCd2[i]);
						if ( issOpt[i] !=	null)
						model.setIssOpt( issOpt[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( dtOpt[i] !=	null)
						model.setDtOpt( dtOpt[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( toDt[i] !=	null)
						model.setToDt( toDt[i]);
						if ( chkUserid[i] !=	null)
						model.setChkUserid( chkUserid[i]);
						if ( dtOption[i] !=	null)
						model.setDtOption( dtOption[i]);
						if ( chkBlno[i] !=	null)
						model.setChkBlno( chkBlno[i]);
						if ( faxNo[i] !=	null)
						model.setFaxNo( faxNo[i]);
						if ( toInvNo[i] !=	null)
						model.setToInvNo( toInvNo[i]);
						if ( chkAll[i] !=	null)
						model.setChkAll( chkAll[i]);
						if ( wrkNo[i] !=	null)
						model.setWrkNo( wrkNo[i]);
						if ( issueType[i] !=	null)
						model.setIssueType( issueType[i]);
						if ( emailFlag[i] !=	null)
						model.setEmailFlag( emailFlag[i]);
						if ( revType[i] !=	null)
						model.setRevType( revType[i]);
						if ( vnInvPayMzdCd[i] !=	null)
						model.setVnInvPayMzdCd( vnInvPayMzdCd[i]);
						if ( autoInvIssFlg[i] !=	null)
						model.setAutoInvIssFlg( autoInvIssFlg[i]);
						if ( indIssTpCd[i] !=	null)
						model.setIndIssTpCd( indIssTpCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getGeneralInvoiceVOs();
	}

	/**
	 *  VO 諛곗뿴�쓣 諛섑솚
	 * @return GeneralInvoiceVO[]
	 */
	public GeneralInvoiceVO[]	 getGeneralInvoiceVOs(){
		GeneralInvoiceVO[] vos = (GeneralInvoiceVO[])models.toArray(new	GeneralInvoiceVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class�쓽 �궡�슜�쓣 String�쑝濡� 蹂��솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �룷留룻똿�맂 臾몄옄�뿴�뿉�꽌 �듅�닔臾몄옄 �젣嫄�("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.scp =	this.scp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port =	this.port.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtDt =	this.xchRtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totInvCnt =	this.totInvCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt =	this.fromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifUserId =	this.ifUserId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkVvd =	this.chkVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDupFlg =	this.invDupFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd =	this.otsSmryCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromInvNo =	this.fromInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo =	this.custRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invMltBlIssFlg =	this.invMltBlIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId =	this.svrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOfcCd =	this.loginOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCust =	this.chkCust.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNos =	this.blNos.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copyCnt =	this.copyCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt =	this.crAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd =	this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invType =	this.invType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm =	this.cntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId =	this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd =	this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo =	this.phnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRt =	this.xchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnd =	this.bnd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCurrCd =	this.crCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd2 =	this.arOfcCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOpt =	this.issOpt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtOpt =	this.dtOpt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt =	this.toDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkUserid =	this.chkUserid.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtOption =	this.dtOption.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkBlno =	this.chkBlno.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo =	this.faxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvNo =	this.toInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkAll =	this.chkAll.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkNo =	this.wrkNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueType =	this.issueType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emailFlag =	this.emailFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revType =	this.revType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnInvPayMzdCd =	this.vnInvPayMzdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIssFlg =	this.autoInvIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indIssTpCd =	this.indIssTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}