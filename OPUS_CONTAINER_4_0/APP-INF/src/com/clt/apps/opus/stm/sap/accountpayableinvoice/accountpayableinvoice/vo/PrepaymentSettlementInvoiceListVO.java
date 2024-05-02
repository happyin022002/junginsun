/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PrepaymentSettlementInvoiceListVO.java
 *@FileTitle : PrepaymentSettlementInvoiceListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.04.28
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.04.28  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class PrepaymentSettlementInvoiceListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PrepaymentSettlementInvoiceListVO>  models =	new	ArrayList<PrepaymentSettlementInvoiceListVO>();


	/*	Column Info	*/
	private  String	 glDt   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 invVatCd   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invDesc   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 prepayRmnTotAmt   =  null;
	/*	Column Info	*/
	private  String	 invCurrPrcs   =  null;
	/*	Column Info	*/
	private  String	 liabCdCmbSeq   =  null;
	/*	Column Info	*/
	private  String	 payStsFlg   =  null;
	/*	Column Info	*/
	private  String	 invAmt   =  null;
	/*	Column Info	*/
	private  String	 attrCateNm   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
	/*	Column Info	*/
	private  String	 eryStlDt   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 invPayAmt   =  null;
	/*	Column Info	*/
	private  String	 invVatAmt   =  null;
	/*	Column Info	*/
	private  String	 dtrbSetSeq   =  null;
	/*	Column Info	*/
	private  String	 invPayCurrCd   =  null;
	/*	Column Info	*/
	private  String	 invAproRdyFlg   =  null;
	/*	Column Info	*/
	private  String	 invCxlAmt   =  null;
	/*	Column Info	*/
	private  String	 invXchDt   =  null;
	/*	Column Info	*/
	private  String	 xterBankAcctSeq   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCateNm   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 payCurrInvAmt   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 apPayGrpLuCd   =  null;
	/*	Column Info	*/
	private  String	 apApstsCd   =  null;
	/*	Column Info	*/
	private  String	 invCxlDt   =  null;
	/*	Column Info	*/
	private  String	 invTpLuCd   =  null;
	/*	Column Info	*/
	private  String	 invTermDt   =  null;
	/*	Column Info	*/
	private  String	 payMzdLuCd   =  null;
	/*	Column Info	*/
	private  String	 apInvSrcCd   =  null;
	/*	Column Info	*/
	private  String	 batSeq   =  null;
	/*	Column Info	*/
	private  String	 invXchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 cxlUsrId   =  null;
	/*	Column Info	*/
	private  String	 invTermNm   =  null;
	/*	Column Info	*/
	private  String	 invFuncAmt   =  null;
	/*	Column Info	*/
	private  String	 functionalCurrency   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public PrepaymentSettlementInvoiceListVO(){}

	public PrepaymentSettlementInvoiceListVO(String glDt,String vndrLglEngNm,String invVatCd,String invSeq,String pagerows,String invDesc,String vndrNo,String ibflag,String prepayRmnTotAmt,String invCurrPrcs,String liabCdCmbSeq,String payStsFlg,String invAmt,String attrCateNm,String invXchRt,String eryStlDt,String invDt,String invPayAmt,String invVatAmt,String dtrbSetSeq,String invPayCurrCd,String invAproRdyFlg,String invCxlAmt,String invXchDt,String xterBankAcctSeq,String gloAttrCateNm,String invCurrCd,String invNo,String payCurrInvAmt,String ofcCd,String apPayGrpLuCd,String apApstsCd,String invCxlDt,String invTpLuCd,String invTermDt,String payMzdLuCd,String apInvSrcCd,String batSeq,String invXchRtTpCd,String cxlUsrId,String invTermNm,String invFuncAmt,String functionalCurrency)	{
		this.glDt  = glDt ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.invVatCd  = invVatCd ;
		this.invSeq  = invSeq ;
		this.pagerows  = pagerows ;
		this.invDesc  = invDesc ;
		this.vndrNo  = vndrNo ;
		this.ibflag  = ibflag ;
		this.prepayRmnTotAmt  = prepayRmnTotAmt ;
		this.invCurrPrcs  = invCurrPrcs ;
		this.liabCdCmbSeq  = liabCdCmbSeq ;
		this.payStsFlg  = payStsFlg ;
		this.invAmt  = invAmt ;
		this.attrCateNm  = attrCateNm ;
		this.invXchRt  = invXchRt ;
		this.eryStlDt  = eryStlDt ;
		this.invDt  = invDt ;
		this.invPayAmt  = invPayAmt ;
		this.invVatAmt  = invVatAmt ;
		this.dtrbSetSeq  = dtrbSetSeq ;
		this.invPayCurrCd  = invPayCurrCd ;
		this.invAproRdyFlg  = invAproRdyFlg ;
		this.invCxlAmt  = invCxlAmt ;
		this.invXchDt  = invXchDt ;
		this.xterBankAcctSeq  = xterBankAcctSeq ;
		this.gloAttrCateNm  = gloAttrCateNm ;
		this.invCurrCd  = invCurrCd ;
		this.invNo  = invNo ;
		this.payCurrInvAmt  = payCurrInvAmt ;
		this.ofcCd  = ofcCd ;
		this.apPayGrpLuCd  = apPayGrpLuCd ;
		this.apApstsCd  = apApstsCd ;
		this.invCxlDt  = invCxlDt ;
		this.invTpLuCd  = invTpLuCd ;
		this.invTermDt  = invTermDt ;
		this.payMzdLuCd  = payMzdLuCd ;
		this.apInvSrcCd  = apInvSrcCd ;
		this.batSeq  = batSeq ;
		this.invXchRtTpCd  = invXchRtTpCd ;
		this.cxlUsrId  = cxlUsrId ;
		this.invTermNm  = invTermNm ;
		this.invFuncAmt  = invFuncAmt ;
		this.functionalCurrency  = functionalCurrency ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gl_dt", getGlDt());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("inv_vat_cd", getInvVatCd());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_desc", getInvDesc());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("prepay_rmn_tot_amt", getPrepayRmnTotAmt());		
		this.hashColumns.put("inv_curr_prcs", getInvCurrPrcs());		
		this.hashColumns.put("liab_cd_cmb_seq", getLiabCdCmbSeq());		
		this.hashColumns.put("pay_sts_flg", getPayStsFlg());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("attr_cate_nm", getAttrCateNm());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("ery_stl_dt", getEryStlDt());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("inv_pay_amt", getInvPayAmt());		
		this.hashColumns.put("inv_vat_amt", getInvVatAmt());		
		this.hashColumns.put("dtrb_set_seq", getDtrbSetSeq());		
		this.hashColumns.put("inv_pay_curr_cd", getInvPayCurrCd());		
		this.hashColumns.put("inv_apro_rdy_flg", getInvAproRdyFlg());		
		this.hashColumns.put("inv_cxl_amt", getInvCxlAmt());		
		this.hashColumns.put("inv_xch_dt", getInvXchDt());		
		this.hashColumns.put("xter_bank_acct_seq", getXterBankAcctSeq());		
		this.hashColumns.put("glo_attr_cate_nm", getGloAttrCateNm());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("pay_curr_inv_amt", getPayCurrInvAmt());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ap_pay_grp_lu_cd", getApPayGrpLuCd());		
		this.hashColumns.put("ap_apsts_cd", getApApstsCd());		
		this.hashColumns.put("inv_cxl_dt", getInvCxlDt());		
		this.hashColumns.put("inv_tp_lu_cd", getInvTpLuCd());		
		this.hashColumns.put("inv_term_dt", getInvTermDt());		
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());		
		this.hashColumns.put("ap_inv_src_cd", getApInvSrcCd());		
		this.hashColumns.put("bat_seq", getBatSeq());		
		this.hashColumns.put("inv_xch_rt_tp_cd", getInvXchRtTpCd());		
		this.hashColumns.put("cxl_usr_id", getCxlUsrId());		
		this.hashColumns.put("inv_term_nm", getInvTermNm());		
		this.hashColumns.put("inv_func_amt", getInvFuncAmt());		
		this.hashColumns.put("functional_currency", getFunctionalCurrency());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("inv_vat_cd", "invVatCd");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prepay_rmn_tot_amt", "prepayRmnTotAmt");
		this.hashFields.put("inv_curr_prcs", "invCurrPrcs");
		this.hashFields.put("liab_cd_cmb_seq", "liabCdCmbSeq");
		this.hashFields.put("pay_sts_flg", "payStsFlg");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("attr_cate_nm", "attrCateNm");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("ery_stl_dt", "eryStlDt");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("inv_pay_amt", "invPayAmt");
		this.hashFields.put("inv_vat_amt", "invVatAmt");
		this.hashFields.put("dtrb_set_seq", "dtrbSetSeq");
		this.hashFields.put("inv_pay_curr_cd", "invPayCurrCd");
		this.hashFields.put("inv_apro_rdy_flg", "invAproRdyFlg");
		this.hashFields.put("inv_cxl_amt", "invCxlAmt");
		this.hashFields.put("inv_xch_dt", "invXchDt");
		this.hashFields.put("xter_bank_acct_seq", "xterBankAcctSeq");
		this.hashFields.put("glo_attr_cate_nm", "gloAttrCateNm");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("pay_curr_inv_amt", "payCurrInvAmt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ap_pay_grp_lu_cd", "apPayGrpLuCd");
		this.hashFields.put("ap_apsts_cd", "apApstsCd");
		this.hashFields.put("inv_cxl_dt", "invCxlDt");
		this.hashFields.put("inv_tp_lu_cd", "invTpLuCd");
		this.hashFields.put("inv_term_dt", "invTermDt");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("ap_inv_src_cd", "apInvSrcCd");
		this.hashFields.put("bat_seq", "batSeq");
		this.hashFields.put("inv_xch_rt_tp_cd", "invXchRtTpCd");
		this.hashFields.put("cxl_usr_id", "cxlUsrId");
		this.hashFields.put("inv_term_nm", "invTermNm");
		this.hashFields.put("inv_func_amt", "invFuncAmt");
		this.hashFields.put("functional_currency", "functionalCurrency");
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
	 public	String	getGlDt() {
		 return	this.glDt;
	 } 
 	/**
	* Column Info
	* @param  vndrLglEngNm
	*/
	public void	setVndrLglEngNm( String	vndrLglEngNm ) {
		this.vndrLglEngNm =	vndrLglEngNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrLglEngNm
	 */
	 public	String	getVndrLglEngNm() {
		 return	this.vndrLglEngNm;
	 } 
 	/**
	* Column Info
	* @param  invVatCd
	*/
	public void	setInvVatCd( String	invVatCd ) {
		this.invVatCd =	invVatCd;
	}
 
	/**
	 * Column Info
	 * @return	invVatCd
	 */
	 public	String	getInvVatCd() {
		 return	this.invVatCd;
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
	 public	String	getInvSeq() {
		 return	this.invSeq;
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
	 public	String	getPagerows() {
		 return	this.pagerows;
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
	 public	String	getInvDesc() {
		 return	this.invDesc;
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
	 public	String	getVndrNo() {
		 return	this.vndrNo;
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
	 public	String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  prepayRmnTotAmt
	*/
	public void	setPrepayRmnTotAmt( String	prepayRmnTotAmt ) {
		this.prepayRmnTotAmt =	prepayRmnTotAmt;
	}
 
	/**
	 * Column Info
	 * @return	prepayRmnTotAmt
	 */
	 public	String	getPrepayRmnTotAmt() {
		 return	this.prepayRmnTotAmt;
	 } 
 	/**
	* Column Info
	* @param  invCurrPrcs
	*/
	public void	setInvCurrPrcs( String	invCurrPrcs ) {
		this.invCurrPrcs =	invCurrPrcs;
	}
 
	/**
	 * Column Info
	 * @return	invCurrPrcs
	 */
	 public	String	getInvCurrPrcs() {
		 return	this.invCurrPrcs;
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
	 public	String	getLiabCdCmbSeq() {
		 return	this.liabCdCmbSeq;
	 } 
 	/**
	* Column Info
	* @param  payStsFlg
	*/
	public void	setPayStsFlg( String	payStsFlg ) {
		this.payStsFlg =	payStsFlg;
	}
 
	/**
	 * Column Info
	 * @return	payStsFlg
	 */
	 public	String	getPayStsFlg() {
		 return	this.payStsFlg;
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
	 public	String	getInvAmt() {
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
	 public	String	getAttrCateNm() {
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
	 public	String	getInvXchRt() {
		 return	this.invXchRt;
	 } 
 	/**
	* Column Info
	* @param  eryStlDt
	*/
	public void	setEryStlDt( String	eryStlDt ) {
		this.eryStlDt =	eryStlDt;
	}
 
	/**
	 * Column Info
	 * @return	eryStlDt
	 */
	 public	String	getEryStlDt() {
		 return	this.eryStlDt;
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
	 public	String	getInvDt() {
		 return	this.invDt;
	 } 
 	/**
	* Column Info
	* @param  invPayAmt
	*/
	public void	setInvPayAmt( String	invPayAmt ) {
		this.invPayAmt =	invPayAmt;
	}
 
	/**
	 * Column Info
	 * @return	invPayAmt
	 */
	 public	String	getInvPayAmt() {
		 return	this.invPayAmt;
	 } 
 	/**
	* Column Info
	* @param  invVatAmt
	*/
	public void	setInvVatAmt( String	invVatAmt ) {
		this.invVatAmt =	invVatAmt;
	}
 
	/**
	 * Column Info
	 * @return	invVatAmt
	 */
	 public	String	getInvVatAmt() {
		 return	this.invVatAmt;
	 } 
 	/**
	* Column Info
	* @param  dtrbSetSeq
	*/
	public void	setDtrbSetSeq( String	dtrbSetSeq ) {
		this.dtrbSetSeq =	dtrbSetSeq;
	}
 
	/**
	 * Column Info
	 * @return	dtrbSetSeq
	 */
	 public	String	getDtrbSetSeq() {
		 return	this.dtrbSetSeq;
	 } 
 	/**
	* Column Info
	* @param  invPayCurrCd
	*/
	public void	setInvPayCurrCd( String	invPayCurrCd ) {
		this.invPayCurrCd =	invPayCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	invPayCurrCd
	 */
	 public	String	getInvPayCurrCd() {
		 return	this.invPayCurrCd;
	 } 
 	/**
	* Column Info
	* @param  invAproRdyFlg
	*/
	public void	setInvAproRdyFlg( String	invAproRdyFlg ) {
		this.invAproRdyFlg =	invAproRdyFlg;
	}
 
	/**
	 * Column Info
	 * @return	invAproRdyFlg
	 */
	 public	String	getInvAproRdyFlg() {
		 return	this.invAproRdyFlg;
	 } 
 	/**
	* Column Info
	* @param  invCxlAmt
	*/
	public void	setInvCxlAmt( String	invCxlAmt ) {
		this.invCxlAmt =	invCxlAmt;
	}
 
	/**
	 * Column Info
	 * @return	invCxlAmt
	 */
	 public	String	getInvCxlAmt() {
		 return	this.invCxlAmt;
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
	 public	String	getInvXchDt() {
		 return	this.invXchDt;
	 } 
 	/**
	* Column Info
	* @param  xterBankAcctSeq
	*/
	public void	setXterBankAcctSeq( String	xterBankAcctSeq ) {
		this.xterBankAcctSeq =	xterBankAcctSeq;
	}
 
	/**
	 * Column Info
	 * @return	xterBankAcctSeq
	 */
	 public	String	getXterBankAcctSeq() {
		 return	this.xterBankAcctSeq;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCateNm
	*/
	public void	setGloAttrCateNm( String	gloAttrCateNm ) {
		this.gloAttrCateNm =	gloAttrCateNm;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCateNm
	 */
	 public	String	getGloAttrCateNm() {
		 return	this.gloAttrCateNm;
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
	 public	String	getInvCurrCd() {
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
	 public	String	getInvNo() {
		 return	this.invNo;
	 } 
 	/**
	* Column Info
	* @param  payCurrInvAmt
	*/
	public void	setPayCurrInvAmt( String	payCurrInvAmt ) {
		this.payCurrInvAmt =	payCurrInvAmt;
	}
 
	/**
	 * Column Info
	 * @return	payCurrInvAmt
	 */
	 public	String	getPayCurrInvAmt() {
		 return	this.payCurrInvAmt;
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
	 public	String	getOfcCd() {
		 return	this.ofcCd;
	 } 
 	/**
	* Column Info
	* @param  apPayGrpLuCd
	*/
	public void	setApPayGrpLuCd( String	apPayGrpLuCd ) {
		this.apPayGrpLuCd =	apPayGrpLuCd;
	}
 
	/**
	 * Column Info
	 * @return	apPayGrpLuCd
	 */
	 public	String	getApPayGrpLuCd() {
		 return	this.apPayGrpLuCd;
	 } 
 	/**
	* Column Info
	* @param  apApstsCd
	*/
	public void	setApApstsCd( String	apApstsCd ) {
		this.apApstsCd =	apApstsCd;
	}
 
	/**
	 * Column Info
	 * @return	apApstsCd
	 */
	 public	String	getApApstsCd() {
		 return	this.apApstsCd;
	 } 
 	/**
	* Column Info
	* @param  invCxlDt
	*/
	public void	setInvCxlDt( String	invCxlDt ) {
		this.invCxlDt =	invCxlDt;
	}
 
	/**
	 * Column Info
	 * @return	invCxlDt
	 */
	 public	String	getInvCxlDt() {
		 return	this.invCxlDt;
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
	 public	String	getInvTpLuCd() {
		 return	this.invTpLuCd;
	 } 
 	/**
	* Column Info
	* @param  invTermDt
	*/
	public void	setInvTermDt( String	invTermDt ) {
		this.invTermDt =	invTermDt;
	}
 
	/**
	 * Column Info
	 * @return	invTermDt
	 */
	 public	String	getInvTermDt() {
		 return	this.invTermDt;
	 } 
 	/**
	* Column Info
	* @param  payMzdLuCd
	*/
	public void	setPayMzdLuCd( String	payMzdLuCd ) {
		this.payMzdLuCd =	payMzdLuCd;
	}
 
	/**
	 * Column Info
	 * @return	payMzdLuCd
	 */
	 public	String	getPayMzdLuCd() {
		 return	this.payMzdLuCd;
	 } 
 	/**
	* Column Info
	* @param  apInvSrcCd
	*/
	public void	setApInvSrcCd( String	apInvSrcCd ) {
		this.apInvSrcCd =	apInvSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	apInvSrcCd
	 */
	 public	String	getApInvSrcCd() {
		 return	this.apInvSrcCd;
	 } 
 	/**
	* Column Info
	* @param  batSeq
	*/
	public void	setBatSeq( String	batSeq ) {
		this.batSeq =	batSeq;
	}
 
	/**
	 * Column Info
	 * @return	batSeq
	 */
	 public	String	getBatSeq() {
		 return	this.batSeq;
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
	 public	String	getInvXchRtTpCd() {
		 return	this.invXchRtTpCd;
	 } 
 	/**
	* Column Info
	* @param  cxlUsrId
	*/
	public void	setCxlUsrId( String	cxlUsrId ) {
		this.cxlUsrId =	cxlUsrId;
	}
 
	/**
	 * Column Info
	 * @return	cxlUsrId
	 */
	 public	String	getCxlUsrId() {
		 return	this.cxlUsrId;
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
	 public	String	getInvTermNm() {
		 return	this.invTermNm;
	 } 
 	/**
	* Column Info
	* @param  invFuncAmt
	*/
	public void	setInvFuncAmt( String	invFuncAmt ) {
		this.invFuncAmt =	invFuncAmt;
	}
 
	/**
	 * Column Info
	 * @return	invFuncAmt
	 */
	 public	String	getInvFuncAmt() {
		 return	this.invFuncAmt;
	 } 
 	/**
	* Column Info
	* @param  functionalCurrency
	*/
	public void	setFunctionalCurrency( String	functionalCurrency ) {
		this.functionalCurrency =	functionalCurrency;
	}
 
	/**
	 * Column Info
	 * @return	functionalCurrency
	 */
	 public	String	getFunctionalCurrency() {
		 return	this.functionalCurrency;
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
		setGlDt(JSPUtil.getParameter(request,	prefix + "gl_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setInvVatCd(JSPUtil.getParameter(request,	prefix + "inv_vat_cd", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvDesc(JSPUtil.getParameter(request,	prefix + "inv_desc", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPrepayRmnTotAmt(JSPUtil.getParameter(request,	prefix + "prepay_rmn_tot_amt", ""));
		setInvCurrPrcs(JSPUtil.getParameter(request,	prefix + "inv_curr_prcs", ""));
		setLiabCdCmbSeq(JSPUtil.getParameter(request,	prefix + "liab_cd_cmb_seq", ""));
		setPayStsFlg(JSPUtil.getParameter(request,	prefix + "pay_sts_flg", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setAttrCateNm(JSPUtil.getParameter(request,	prefix + "attr_cate_nm", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setEryStlDt(JSPUtil.getParameter(request,	prefix + "ery_stl_dt", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setInvPayAmt(JSPUtil.getParameter(request,	prefix + "inv_pay_amt", ""));
		setInvVatAmt(JSPUtil.getParameter(request,	prefix + "inv_vat_amt", ""));
		setDtrbSetSeq(JSPUtil.getParameter(request,	prefix + "dtrb_set_seq", ""));
		setInvPayCurrCd(JSPUtil.getParameter(request,	prefix + "inv_pay_curr_cd", ""));
		setInvAproRdyFlg(JSPUtil.getParameter(request,	prefix + "inv_apro_rdy_flg", ""));
		setInvCxlAmt(JSPUtil.getParameter(request,	prefix + "inv_cxl_amt", ""));
		setInvXchDt(JSPUtil.getParameter(request,	prefix + "inv_xch_dt", ""));
		setXterBankAcctSeq(JSPUtil.getParameter(request,	prefix + "xter_bank_acct_seq", ""));
		setGloAttrCateNm(JSPUtil.getParameter(request,	prefix + "glo_attr_cate_nm", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setPayCurrInvAmt(JSPUtil.getParameter(request,	prefix + "pay_curr_inv_amt", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setApPayGrpLuCd(JSPUtil.getParameter(request,	prefix + "ap_pay_grp_lu_cd", ""));
		setApApstsCd(JSPUtil.getParameter(request,	prefix + "ap_apsts_cd", ""));
		setInvCxlDt(JSPUtil.getParameter(request,	prefix + "inv_cxl_dt", ""));
		setInvTpLuCd(JSPUtil.getParameter(request,	prefix + "inv_tp_lu_cd", ""));
		setInvTermDt(JSPUtil.getParameter(request,	prefix + "inv_term_dt", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request,	prefix + "pay_mzd_lu_cd", ""));
		setApInvSrcCd(JSPUtil.getParameter(request,	prefix + "ap_inv_src_cd", ""));
		setBatSeq(JSPUtil.getParameter(request,	prefix + "bat_seq", ""));
		setInvXchRtTpCd(JSPUtil.getParameter(request,	prefix + "inv_xch_rt_tp_cd", ""));
		setCxlUsrId(JSPUtil.getParameter(request,	prefix + "cxl_usr_id", ""));
		setInvTermNm(JSPUtil.getParameter(request,	prefix + "inv_term_nm", ""));
		setInvFuncAmt(JSPUtil.getParameter(request,	prefix + "inv_func_amt", ""));
		setFunctionalCurrency(JSPUtil.getParameter(request,	prefix + "functional_currency", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrepaymentSettlementInvoiceListVO[]
	 */
	public PrepaymentSettlementInvoiceListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PrepaymentSettlementInvoiceListVO[]
	 */
	public PrepaymentSettlementInvoiceListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PrepaymentSettlementInvoiceListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] glDt =	(JSPUtil.getParameter(request, prefix +	"gl_dt".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] invVatCd =	(JSPUtil.getParameter(request, prefix +	"inv_vat_cd".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invDesc =	(JSPUtil.getParameter(request, prefix +	"inv_desc".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] prepayRmnTotAmt =	(JSPUtil.getParameter(request, prefix +	"prepay_rmn_tot_amt".trim(),	length));
				String[] invCurrPrcs =	(JSPUtil.getParameter(request, prefix +	"inv_curr_prcs".trim(),	length));
				String[] liabCdCmbSeq =	(JSPUtil.getParameter(request, prefix +	"liab_cd_cmb_seq".trim(),	length));
				String[] payStsFlg =	(JSPUtil.getParameter(request, prefix +	"pay_sts_flg".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] attrCateNm =	(JSPUtil.getParameter(request, prefix +	"attr_cate_nm".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] eryStlDt =	(JSPUtil.getParameter(request, prefix +	"ery_stl_dt".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] invPayAmt =	(JSPUtil.getParameter(request, prefix +	"inv_pay_amt".trim(),	length));
				String[] invVatAmt =	(JSPUtil.getParameter(request, prefix +	"inv_vat_amt".trim(),	length));
				String[] dtrbSetSeq =	(JSPUtil.getParameter(request, prefix +	"dtrb_set_seq".trim(),	length));
				String[] invPayCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_pay_curr_cd".trim(),	length));
				String[] invAproRdyFlg =	(JSPUtil.getParameter(request, prefix +	"inv_apro_rdy_flg".trim(),	length));
				String[] invCxlAmt =	(JSPUtil.getParameter(request, prefix +	"inv_cxl_amt".trim(),	length));
				String[] invXchDt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_dt".trim(),	length));
				String[] xterBankAcctSeq =	(JSPUtil.getParameter(request, prefix +	"xter_bank_acct_seq".trim(),	length));
				String[] gloAttrCateNm =	(JSPUtil.getParameter(request, prefix +	"glo_attr_cate_nm".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] payCurrInvAmt =	(JSPUtil.getParameter(request, prefix +	"pay_curr_inv_amt".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] apPayGrpLuCd =	(JSPUtil.getParameter(request, prefix +	"ap_pay_grp_lu_cd".trim(),	length));
				String[] apApstsCd =	(JSPUtil.getParameter(request, prefix +	"ap_apsts_cd".trim(),	length));
				String[] invCxlDt =	(JSPUtil.getParameter(request, prefix +	"inv_cxl_dt".trim(),	length));
				String[] invTpLuCd =	(JSPUtil.getParameter(request, prefix +	"inv_tp_lu_cd".trim(),	length));
				String[] invTermDt =	(JSPUtil.getParameter(request, prefix +	"inv_term_dt".trim(),	length));
				String[] payMzdLuCd =	(JSPUtil.getParameter(request, prefix +	"pay_mzd_lu_cd".trim(),	length));
				String[] apInvSrcCd =	(JSPUtil.getParameter(request, prefix +	"ap_inv_src_cd".trim(),	length));
				String[] batSeq =	(JSPUtil.getParameter(request, prefix +	"bat_seq".trim(),	length));
				String[] invXchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt_tp_cd".trim(),	length));
				String[] cxlUsrId =	(JSPUtil.getParameter(request, prefix +	"cxl_usr_id".trim(),	length));
				String[] invTermNm =	(JSPUtil.getParameter(request, prefix +	"inv_term_nm".trim(),	length));
				String[] invFuncAmt =	(JSPUtil.getParameter(request, prefix +	"inv_func_amt".trim(),	length));
				String[] functionalCurrency =	(JSPUtil.getParameter(request, prefix +	"functional_currency".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	PrepaymentSettlementInvoiceListVO();
						if ( glDt[i] !=	null)
						model.setGlDt( glDt[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( invVatCd[i] !=	null)
						model.setInvVatCd( invVatCd[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invDesc[i] !=	null)
						model.setInvDesc( invDesc[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( prepayRmnTotAmt[i] !=	null)
						model.setPrepayRmnTotAmt( prepayRmnTotAmt[i]);
						if ( invCurrPrcs[i] !=	null)
						model.setInvCurrPrcs( invCurrPrcs[i]);
						if ( liabCdCmbSeq[i] !=	null)
						model.setLiabCdCmbSeq( liabCdCmbSeq[i]);
						if ( payStsFlg[i] !=	null)
						model.setPayStsFlg( payStsFlg[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
						if ( attrCateNm[i] !=	null)
						model.setAttrCateNm( attrCateNm[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( eryStlDt[i] !=	null)
						model.setEryStlDt( eryStlDt[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( invPayAmt[i] !=	null)
						model.setInvPayAmt( invPayAmt[i]);
						if ( invVatAmt[i] !=	null)
						model.setInvVatAmt( invVatAmt[i]);
						if ( dtrbSetSeq[i] !=	null)
						model.setDtrbSetSeq( dtrbSetSeq[i]);
						if ( invPayCurrCd[i] !=	null)
						model.setInvPayCurrCd( invPayCurrCd[i]);
						if ( invAproRdyFlg[i] !=	null)
						model.setInvAproRdyFlg( invAproRdyFlg[i]);
						if ( invCxlAmt[i] !=	null)
						model.setInvCxlAmt( invCxlAmt[i]);
						if ( invXchDt[i] !=	null)
						model.setInvXchDt( invXchDt[i]);
						if ( xterBankAcctSeq[i] !=	null)
						model.setXterBankAcctSeq( xterBankAcctSeq[i]);
						if ( gloAttrCateNm[i] !=	null)
						model.setGloAttrCateNm( gloAttrCateNm[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( payCurrInvAmt[i] !=	null)
						model.setPayCurrInvAmt( payCurrInvAmt[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( apPayGrpLuCd[i] !=	null)
						model.setApPayGrpLuCd( apPayGrpLuCd[i]);
						if ( apApstsCd[i] !=	null)
						model.setApApstsCd( apApstsCd[i]);
						if ( invCxlDt[i] !=	null)
						model.setInvCxlDt( invCxlDt[i]);
						if ( invTpLuCd[i] !=	null)
						model.setInvTpLuCd( invTpLuCd[i]);
						if ( invTermDt[i] !=	null)
						model.setInvTermDt( invTermDt[i]);
						if ( payMzdLuCd[i] !=	null)
						model.setPayMzdLuCd( payMzdLuCd[i]);
						if ( apInvSrcCd[i] !=	null)
						model.setApInvSrcCd( apInvSrcCd[i]);
						if ( batSeq[i] !=	null)
						model.setBatSeq( batSeq[i]);
						if ( invXchRtTpCd[i] !=	null)
						model.setInvXchRtTpCd( invXchRtTpCd[i]);
						if ( cxlUsrId[i] !=	null)
						model.setCxlUsrId( cxlUsrId[i]);
						if ( invTermNm[i] !=	null)
						model.setInvTermNm( invTermNm[i]);
						if ( invFuncAmt[i] !=	null)
						model.setInvFuncAmt( invFuncAmt[i]);
						if ( functionalCurrency[i] !=	null)
						model.setFunctionalCurrency( functionalCurrency[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getPrepaymentSettlementInvoiceListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PrepaymentSettlementInvoiceListVO[]
	 */
	public PrepaymentSettlementInvoiceListVO[]	 getPrepaymentSettlementInvoiceListVOs(){
		PrepaymentSettlementInvoiceListVO[] vos = (PrepaymentSettlementInvoiceListVO[])models.toArray(new	PrepaymentSettlementInvoiceListVO[models.size()]);
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
		this.glDt =	this.glDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatCd =	this.invVatCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc =	this.invDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prepayRmnTotAmt =	this.prepayRmnTotAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrPrcs =	this.invCurrPrcs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCdCmbSeq =	this.liabCdCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payStsFlg =	this.payStsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCateNm =	this.attrCateNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eryStlDt =	this.eryStlDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayAmt =	this.invPayAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatAmt =	this.invVatAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbSetSeq =	this.dtrbSetSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayCurrCd =	this.invPayCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAproRdyFlg =	this.invAproRdyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCxlAmt =	this.invCxlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchDt =	this.invXchDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBankAcctSeq =	this.xterBankAcctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCateNm =	this.gloAttrCateNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCurrInvAmt =	this.payCurrInvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayGrpLuCd =	this.apPayGrpLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apApstsCd =	this.apApstsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCxlDt =	this.invCxlDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTpLuCd =	this.invTpLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTermDt =	this.invTermDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd =	this.payMzdLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apInvSrcCd =	this.apInvSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batSeq =	this.batSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtTpCd =	this.invXchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlUsrId =	this.cxlUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTermNm =	this.invTermNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invFuncAmt =	this.invFuncAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.functionalCurrency =	this.functionalCurrency.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}