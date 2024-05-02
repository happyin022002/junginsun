/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ReceiptForAPInterfaceVO.java
 *@FileTitle : ReceiptForAPInterfaceVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.01.22  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo;

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
 * - 愿�젴	Event�먯꽌	�묒꽦,	�쒕쾭�ㅽ뻾�붿껌��PDTO����븷���섑뻾�섎뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class ReceiptForAPInterfaceVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ReceiptForAPInterfaceVO>  models =	new	ArrayList<ReceiptForAPInterfaceVO>();


	/*	Column Info	*/
	private  String	 glDt   =  null;
	/*	Column Info	*/
	private  String	 apPayMzdLuCd   =  null;
	/*	Column Info	*/
	private  String	 invRcvDt   =  null;
	/*	Column Info	*/
	private  String	 dtrbCdCmbSeq   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 invDesc   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt3   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt4   =  null;
	/*	Column Info	*/
	private  String	 liabCdCmbSeq   =  null;
	/*	Column Info	*/
	private  String	 invAmt   =  null;
	/*	Column Info	*/
	private  String	 attrCateNm   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 rcvCdCmbSeq   =  null;
	/*	Column Info	*/
	private  String	 payGrpLuCd   =  null;
	/*	Column Info	*/
	private  String	 invXchDt   =  null;
	/*	Column Info	*/
	private  String	 acctCtnt3   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 rctAplyDtlSeq   =  null;
	/*	Column Info	*/
	private  String	 invTpLuCd   =  null;
	/*	Column Info	*/
	private  String	 clrAcctCd   =  null;
	/*	Column Info	*/
	private  String	 invXchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 payAcctCd   =  null;
	/*	Column Info	*/
	private  String	 invTermNm   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt11   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ReceiptForAPInterfaceVO(){}

	public ReceiptForAPInterfaceVO(String glDt,String apPayMzdLuCd,String invRcvDt,String dtrbCdCmbSeq,String pagerows,String vndrNo,String invDesc,String ibflag,String attrCtnt3,String attrCtnt4,String liabCdCmbSeq,String invAmt,String attrCateNm,String invXchRt,String invDt,String rcvCdCmbSeq,String payGrpLuCd,String invXchDt,String acctCtnt3,String invCurrCd,String invNo,String ofcCd,String rctAplyDtlSeq,String invTpLuCd,String clrAcctCd,String invXchRtTpCd,String payAcctCd,String invTermNm,String attrCtnt11)	{
		this.glDt  = glDt ;
		this.apPayMzdLuCd  = apPayMzdLuCd ;
		this.invRcvDt  = invRcvDt ;
		this.dtrbCdCmbSeq  = dtrbCdCmbSeq ;
		this.pagerows  = pagerows ;
		this.vndrNo  = vndrNo ;
		this.invDesc  = invDesc ;
		this.ibflag  = ibflag ;
		this.attrCtnt3  = attrCtnt3 ;
		this.attrCtnt4  = attrCtnt4 ;
		this.liabCdCmbSeq  = liabCdCmbSeq ;
		this.invAmt  = invAmt ;
		this.attrCateNm  = attrCateNm ;
		this.invXchRt  = invXchRt ;
		this.invDt  = invDt ;
		this.rcvCdCmbSeq  = rcvCdCmbSeq ;
		this.payGrpLuCd  = payGrpLuCd ;
		this.invXchDt  = invXchDt ;
		this.acctCtnt3  = acctCtnt3 ;
		this.invCurrCd  = invCurrCd ;
		this.invNo  = invNo ;
		this.ofcCd  = ofcCd ;
		this.rctAplyDtlSeq  = rctAplyDtlSeq ;
		this.invTpLuCd  = invTpLuCd ;
		this.clrAcctCd  = clrAcctCd ;
		this.invXchRtTpCd  = invXchRtTpCd ;
		this.payAcctCd  = payAcctCd ;
		this.invTermNm  = invTermNm ;
		this.attrCtnt11  = attrCtnt11 ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gl_dt", getGlDt());		
		this.hashColumns.put("ap_pay_mzd_lu_cd", getApPayMzdLuCd());		
		this.hashColumns.put("inv_rcv_dt", getInvRcvDt());		
		this.hashColumns.put("dtrb_cd_cmb_seq", getDtrbCdCmbSeq());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("inv_desc", getInvDesc());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());		
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());		
		this.hashColumns.put("liab_cd_cmb_seq", getLiabCdCmbSeq());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("attr_cate_nm", getAttrCateNm());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("rcv_cd_cmb_seq", getRcvCdCmbSeq());		
		this.hashColumns.put("pay_grp_lu_cd", getPayGrpLuCd());		
		this.hashColumns.put("inv_xch_dt", getInvXchDt());		
		this.hashColumns.put("acct_ctnt3", getAcctCtnt3());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("rct_aply_dtl_seq", getRctAplyDtlSeq());		
		this.hashColumns.put("inv_tp_lu_cd", getInvTpLuCd());		
		this.hashColumns.put("clr_acct_cd", getClrAcctCd());		
		this.hashColumns.put("inv_xch_rt_tp_cd", getInvXchRtTpCd());		
		this.hashColumns.put("pay_acct_cd", getPayAcctCd());		
		this.hashColumns.put("inv_term_nm", getInvTermNm());		
		this.hashColumns.put("attr_ctnt11", getAttrCtnt11());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("ap_pay_mzd_lu_cd", "apPayMzdLuCd");
		this.hashFields.put("inv_rcv_dt", "invRcvDt");
		this.hashFields.put("dtrb_cd_cmb_seq", "dtrbCdCmbSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("liab_cd_cmb_seq", "liabCdCmbSeq");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("attr_cate_nm", "attrCateNm");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("rcv_cd_cmb_seq", "rcvCdCmbSeq");
		this.hashFields.put("pay_grp_lu_cd", "payGrpLuCd");
		this.hashFields.put("inv_xch_dt", "invXchDt");
		this.hashFields.put("acct_ctnt3", "acctCtnt3");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("rct_aply_dtl_seq", "rctAplyDtlSeq");
		this.hashFields.put("inv_tp_lu_cd", "invTpLuCd");
		this.hashFields.put("clr_acct_cd", "clrAcctCd");
		this.hashFields.put("inv_xch_rt_tp_cd", "invXchRtTpCd");
		this.hashFields.put("pay_acct_cd", "payAcctCd");
		this.hashFields.put("inv_term_nm", "invTermNm");
		this.hashFields.put("attr_ctnt11", "attrCtnt11");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  glDt
	*/
	public void	setGlDt( String	glDt ) {
		this.glDt =	glDt;
	}
 
	/**
	 * Column Info
	 * @return	glDt
	 */
	 public	 String	getGlDt() {
		 return	this.glDt;
	 } 
 	/**
	* Column Info
	* @param  apPayMzdLuCd
	*/
	public void	setApPayMzdLuCd( String	apPayMzdLuCd ) {
		this.apPayMzdLuCd =	apPayMzdLuCd;
	}
 
	/**
	 * Column Info
	 * @return	apPayMzdLuCd
	 */
	 public	 String	getApPayMzdLuCd() {
		 return	this.apPayMzdLuCd;
	 } 
 	/**
	* Column Info
	* @param  invRcvDt
	*/
	public void	setInvRcvDt( String	invRcvDt ) {
		this.invRcvDt =	invRcvDt;
	}
 
	/**
	 * Column Info
	 * @return	invRcvDt
	 */
	 public	 String	getInvRcvDt() {
		 return	this.invRcvDt;
	 } 
 	/**
	* Column Info
	* @param  dtrbCdCmbSeq
	*/
	public void	setDtrbCdCmbSeq( String	dtrbCdCmbSeq ) {
		this.dtrbCdCmbSeq =	dtrbCdCmbSeq;
	}
 
	/**
	 * Column Info
	 * @return	dtrbCdCmbSeq
	 */
	 public	 String	getDtrbCdCmbSeq() {
		 return	this.dtrbCdCmbSeq;
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
	* @param  vndrNo
	*/
	public void	setVndrNo( String	vndrNo ) {
		this.vndrNo =	vndrNo;
	}
 
	/**
	 * Column Info
	 * @return	vndrNo
	 */
	 public	 String	getVndrNo() {
		 return	this.vndrNo;
	 } 
 	/**
	* Column Info
	* @param  invDesc
	*/
	public void	setInvDesc( String	invDesc ) {
		this.invDesc =	invDesc;
	}
 
	/**
	 * Column Info
	 * @return	invDesc
	 */
	 public	 String	getInvDesc() {
		 return	this.invDesc;
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
	* @param  attrCtnt3
	*/
	public void	setAttrCtnt3( String	attrCtnt3 ) {
		this.attrCtnt3 =	attrCtnt3;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt3
	 */
	 public	 String	getAttrCtnt3() {
		 return	this.attrCtnt3;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt4
	*/
	public void	setAttrCtnt4( String	attrCtnt4 ) {
		this.attrCtnt4 =	attrCtnt4;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt4
	 */
	 public	 String	getAttrCtnt4() {
		 return	this.attrCtnt4;
	 } 
 	/**
	* Column Info
	* @param  liabCdCmbSeq
	*/
	public void	setLiabCdCmbSeq( String	liabCdCmbSeq ) {
		this.liabCdCmbSeq =	liabCdCmbSeq;
	}
 
	/**
	 * Column Info
	 * @return	liabCdCmbSeq
	 */
	 public	 String	getLiabCdCmbSeq() {
		 return	this.liabCdCmbSeq;
	 } 
 	/**
	* Column Info
	* @param  invAmt
	*/
	public void	setInvAmt( String	invAmt ) {
		this.invAmt =	invAmt;
	}
 
	/**
	 * Column Info
	 * @return	invAmt
	 */
	 public	 String	getInvAmt() {
		 return	this.invAmt;
	 } 
 	/**
	* Column Info
	* @param  attrCateNm
	*/
	public void	setAttrCateNm( String	attrCateNm ) {
		this.attrCateNm =	attrCateNm;
	}
 
	/**
	 * Column Info
	 * @return	attrCateNm
	 */
	 public	 String	getAttrCateNm() {
		 return	this.attrCateNm;
	 } 
 	/**
	* Column Info
	* @param  invXchRt
	*/
	public void	setInvXchRt( String	invXchRt ) {
		this.invXchRt =	invXchRt;
	}
 
	/**
	 * Column Info
	 * @return	invXchRt
	 */
	 public	 String	getInvXchRt() {
		 return	this.invXchRt;
	 } 
 	/**
	* Column Info
	* @param  invDt
	*/
	public void	setInvDt( String	invDt ) {
		this.invDt =	invDt;
	}
 
	/**
	 * Column Info
	 * @return	invDt
	 */
	 public	 String	getInvDt() {
		 return	this.invDt;
	 } 
 	/**
	* Column Info
	* @param  rcvCdCmbSeq
	*/
	public void	setRcvCdCmbSeq( String	rcvCdCmbSeq ) {
		this.rcvCdCmbSeq =	rcvCdCmbSeq;
	}
 
	/**
	 * Column Info
	 * @return	rcvCdCmbSeq
	 */
	 public	 String	getRcvCdCmbSeq() {
		 return	this.rcvCdCmbSeq;
	 } 
 	/**
	* Column Info
	* @param  payGrpLuCd
	*/
	public void	setPayGrpLuCd( String	payGrpLuCd ) {
		this.payGrpLuCd =	payGrpLuCd;
	}
 
	/**
	 * Column Info
	 * @return	payGrpLuCd
	 */
	 public	 String	getPayGrpLuCd() {
		 return	this.payGrpLuCd;
	 } 
 	/**
	* Column Info
	* @param  invXchDt
	*/
	public void	setInvXchDt( String	invXchDt ) {
		this.invXchDt =	invXchDt;
	}
 
	/**
	 * Column Info
	 * @return	invXchDt
	 */
	 public	 String	getInvXchDt() {
		 return	this.invXchDt;
	 } 
 	/**
	* Column Info
	* @param  acctCtnt3
	*/
	public void	setAcctCtnt3( String	acctCtnt3 ) {
		this.acctCtnt3 =	acctCtnt3;
	}
 
	/**
	 * Column Info
	 * @return	acctCtnt3
	 */
	 public	 String	getAcctCtnt3() {
		 return	this.acctCtnt3;
	 } 
 	/**
	* Column Info
	* @param  invCurrCd
	*/
	public void	setInvCurrCd( String	invCurrCd ) {
		this.invCurrCd =	invCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	invCurrCd
	 */
	 public	 String	getInvCurrCd() {
		 return	this.invCurrCd;
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
	* @param  rctAplyDtlSeq
	*/
	public void	setRctAplyDtlSeq( String	rctAplyDtlSeq ) {
		this.rctAplyDtlSeq =	rctAplyDtlSeq;
	}
 
	/**
	 * Column Info
	 * @return	rctAplyDtlSeq
	 */
	 public	 String	getRctAplyDtlSeq() {
		 return	this.rctAplyDtlSeq;
	 } 
 	/**
	* Column Info
	* @param  invTpLuCd
	*/
	public void	setInvTpLuCd( String	invTpLuCd ) {
		this.invTpLuCd =	invTpLuCd;
	}
 
	/**
	 * Column Info
	 * @return	invTpLuCd
	 */
	 public	 String	getInvTpLuCd() {
		 return	this.invTpLuCd;
	 } 
 	/**
	* Column Info
	* @param  clrAcctCd
	*/
	public void	setClrAcctCd( String	clrAcctCd ) {
		this.clrAcctCd =	clrAcctCd;
	}
 
	/**
	 * Column Info
	 * @return	clrAcctCd
	 */
	 public	 String	getClrAcctCd() {
		 return	this.clrAcctCd;
	 } 
 	/**
	* Column Info
	* @param  invXchRtTpCd
	*/
	public void	setInvXchRtTpCd( String	invXchRtTpCd ) {
		this.invXchRtTpCd =	invXchRtTpCd;
	}
 
	/**
	 * Column Info
	 * @return	invXchRtTpCd
	 */
	 public	 String	getInvXchRtTpCd() {
		 return	this.invXchRtTpCd;
	 } 
 	/**
	* Column Info
	* @param  payAcctCd
	*/
	public void	setPayAcctCd( String	payAcctCd ) {
		this.payAcctCd =	payAcctCd;
	}
 
	/**
	 * Column Info
	 * @return	payAcctCd
	 */
	 public	 String	getPayAcctCd() {
		 return	this.payAcctCd;
	 } 
 	/**
	* Column Info
	* @param  invTermNm
	*/
	public void	setInvTermNm( String	invTermNm ) {
		this.invTermNm =	invTermNm;
	}
 
	/**
	 * Column Info
	 * @return	invTermNm
	 */
	 public	 String	getInvTermNm() {
		 return	this.invTermNm;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt11
	*/
	public void	setAttrCtnt11( String	attrCtnt11 ) {
		this.attrCtnt11 =	attrCtnt11;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt11
	 */
	 public	 String	getAttrCtnt11() {
		 return	this.attrCtnt11;
	 } 

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setGlDt(JSPUtil.getParameter(request,	prefix + "gl_dt", ""));
		setApPayMzdLuCd(JSPUtil.getParameter(request,	prefix + "ap_pay_mzd_lu_cd", ""));
		setInvRcvDt(JSPUtil.getParameter(request,	prefix + "inv_rcv_dt", ""));
		setDtrbCdCmbSeq(JSPUtil.getParameter(request,	prefix + "dtrb_cd_cmb_seq", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setInvDesc(JSPUtil.getParameter(request,	prefix + "inv_desc", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAttrCtnt3(JSPUtil.getParameter(request,	prefix + "attr_ctnt3", ""));
		setAttrCtnt4(JSPUtil.getParameter(request,	prefix + "attr_ctnt4", ""));
		setLiabCdCmbSeq(JSPUtil.getParameter(request,	prefix + "liab_cd_cmb_seq", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setAttrCateNm(JSPUtil.getParameter(request,	prefix + "attr_cate_nm", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setRcvCdCmbSeq(JSPUtil.getParameter(request,	prefix + "rcv_cd_cmb_seq", ""));
		setPayGrpLuCd(JSPUtil.getParameter(request,	prefix + "pay_grp_lu_cd", ""));
		setInvXchDt(JSPUtil.getParameter(request,	prefix + "inv_xch_dt", ""));
		setAcctCtnt3(JSPUtil.getParameter(request,	prefix + "acct_ctnt3", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setRctAplyDtlSeq(JSPUtil.getParameter(request,	prefix + "rct_aply_dtl_seq", ""));
		setInvTpLuCd(JSPUtil.getParameter(request,	prefix + "inv_tp_lu_cd", ""));
		setClrAcctCd(JSPUtil.getParameter(request,	prefix + "clr_acct_cd", ""));
		setInvXchRtTpCd(JSPUtil.getParameter(request,	prefix + "inv_xch_rt_tp_cd", ""));
		setPayAcctCd(JSPUtil.getParameter(request,	prefix + "pay_acct_cd", ""));
		setInvTermNm(JSPUtil.getParameter(request,	prefix + "inv_term_nm", ""));
		setAttrCtnt11(JSPUtil.getParameter(request,	prefix + "attr_ctnt11", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return ReceiptForAPInterfaceVO[]
	 */
	public ReceiptForAPInterfaceVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return ReceiptForAPInterfaceVO[]
	 */
	public ReceiptForAPInterfaceVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ReceiptForAPInterfaceVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] glDt =	(JSPUtil.getParameter(request, prefix +	"gl_dt".trim(),	length));
				String[] apPayMzdLuCd =	(JSPUtil.getParameter(request, prefix +	"ap_pay_mzd_lu_cd".trim(),	length));
				String[] invRcvDt =	(JSPUtil.getParameter(request, prefix +	"inv_rcv_dt".trim(),	length));
				String[] dtrbCdCmbSeq =	(JSPUtil.getParameter(request, prefix +	"dtrb_cd_cmb_seq".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] invDesc =	(JSPUtil.getParameter(request, prefix +	"inv_desc".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] attrCtnt3 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt3".trim(),	length));
				String[] attrCtnt4 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt4".trim(),	length));
				String[] liabCdCmbSeq =	(JSPUtil.getParameter(request, prefix +	"liab_cd_cmb_seq".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] attrCateNm =	(JSPUtil.getParameter(request, prefix +	"attr_cate_nm".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] rcvCdCmbSeq =	(JSPUtil.getParameter(request, prefix +	"rcv_cd_cmb_seq".trim(),	length));
				String[] payGrpLuCd =	(JSPUtil.getParameter(request, prefix +	"pay_grp_lu_cd".trim(),	length));
				String[] invXchDt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_dt".trim(),	length));
				String[] acctCtnt3 =	(JSPUtil.getParameter(request, prefix +	"acct_ctnt3".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] rctAplyDtlSeq =	(JSPUtil.getParameter(request, prefix +	"rct_aply_dtl_seq".trim(),	length));
				String[] invTpLuCd =	(JSPUtil.getParameter(request, prefix +	"inv_tp_lu_cd".trim(),	length));
				String[] clrAcctCd =	(JSPUtil.getParameter(request, prefix +	"clr_acct_cd".trim(),	length));
				String[] invXchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt_tp_cd".trim(),	length));
				String[] payAcctCd =	(JSPUtil.getParameter(request, prefix +	"pay_acct_cd".trim(),	length));
				String[] invTermNm =	(JSPUtil.getParameter(request, prefix +	"inv_term_nm".trim(),	length));
				String[] attrCtnt11 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt11".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ReceiptForAPInterfaceVO();
						if ( glDt[i] !=	null)
						model.setGlDt( glDt[i]);
						if ( apPayMzdLuCd[i] !=	null)
						model.setApPayMzdLuCd( apPayMzdLuCd[i]);
						if ( invRcvDt[i] !=	null)
						model.setInvRcvDt( invRcvDt[i]);
						if ( dtrbCdCmbSeq[i] !=	null)
						model.setDtrbCdCmbSeq( dtrbCdCmbSeq[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( invDesc[i] !=	null)
						model.setInvDesc( invDesc[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( attrCtnt3[i] !=	null)
						model.setAttrCtnt3( attrCtnt3[i]);
						if ( attrCtnt4[i] !=	null)
						model.setAttrCtnt4( attrCtnt4[i]);
						if ( liabCdCmbSeq[i] !=	null)
						model.setLiabCdCmbSeq( liabCdCmbSeq[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
						if ( attrCateNm[i] !=	null)
						model.setAttrCateNm( attrCateNm[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( rcvCdCmbSeq[i] !=	null)
						model.setRcvCdCmbSeq( rcvCdCmbSeq[i]);
						if ( payGrpLuCd[i] !=	null)
						model.setPayGrpLuCd( payGrpLuCd[i]);
						if ( invXchDt[i] !=	null)
						model.setInvXchDt( invXchDt[i]);
						if ( acctCtnt3[i] !=	null)
						model.setAcctCtnt3( acctCtnt3[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( rctAplyDtlSeq[i] !=	null)
						model.setRctAplyDtlSeq( rctAplyDtlSeq[i]);
						if ( invTpLuCd[i] !=	null)
						model.setInvTpLuCd( invTpLuCd[i]);
						if ( clrAcctCd[i] !=	null)
						model.setClrAcctCd( clrAcctCd[i]);
						if ( invXchRtTpCd[i] !=	null)
						model.setInvXchRtTpCd( invXchRtTpCd[i]);
						if ( payAcctCd[i] !=	null)
						model.setPayAcctCd( payAcctCd[i]);
						if ( invTermNm[i] !=	null)
						model.setInvTermNm( invTermNm[i]);
						if ( attrCtnt11[i] !=	null)
						model.setAttrCtnt11( attrCtnt11[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getReceiptForAPInterfaceVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return ReceiptForAPInterfaceVO[]
	 */
	public ReceiptForAPInterfaceVO[]	 getReceiptForAPInterfaceVOs(){
		ReceiptForAPInterfaceVO[] vos = (ReceiptForAPInterfaceVO[])models.toArray(new	ReceiptForAPInterfaceVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class���댁슜��String�쇰줈 蹂�솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �щ㎎�낅맂 臾몄옄�댁뿉���뱀닔臾몄옄 �쒓굅("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.glDt =	this.glDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayMzdLuCd =	this.apPayMzdLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRcvDt =	this.invRcvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCdCmbSeq =	this.dtrbCdCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc =	this.invDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 =	this.attrCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 =	this.attrCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCdCmbSeq =	this.liabCdCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCateNm =	this.attrCateNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvCdCmbSeq =	this.rcvCdCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payGrpLuCd =	this.payGrpLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchDt =	this.invXchDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt3 =	this.acctCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyDtlSeq =	this.rctAplyDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTpLuCd =	this.invTpLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clrAcctCd =	this.clrAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtTpCd =	this.invXchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAcctCd =	this.payAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTermNm =	this.invTermNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt11 =	this.attrCtnt11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}