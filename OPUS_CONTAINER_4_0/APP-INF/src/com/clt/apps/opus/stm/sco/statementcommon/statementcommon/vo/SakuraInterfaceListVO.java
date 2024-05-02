/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SakuraInterfaceListVO.java
 *@FileTitle : SakuraInterfaceListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.04.20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.04.20  
 * 1.0 Creation
=========================================================*/

//package	 com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo;
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo;

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
public class SakuraInterfaceListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SakuraInterfaceListVO>  models =	new	ArrayList<SakuraInterfaceListVO>();


	/*	Column Info	*/
	private  String	 ifDt   =  null;
	/*	Column Info	*/
	private  String	 pstKeyCd   =  null;
	/*	Column Info	*/
	private  String	 custNo   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 asgnNo   =  null;
	/*	Column Info	*/
	private  String	 docDt   =  null;
	/*	Column Info	*/
	private  String	 refDocNo   =  null;
	/*	Column Info	*/
	private  String	 recTpCd   =  null;
	/*	Column Info	*/
	private  String	 loclAmt   =  null;
	/*	Column Info	*/
	private  String	 ifFlg   =  null;
	/*	Column Info	*/
	private  String	 pstDt   =  null;
	/*	Column Info	*/
	private  String	 glAcctNo   =  null;
	/*	Column Info	*/
	private  String	 erpIfErrFlg   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ifDocTpCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 docAmt   =  null;
	/*	Column Info	*/
	private  String	 vatTaxCd   =  null;
	/*	Column Info	*/
	private  String	 erpIfErrRsn   =  null;
	/*	Column Info	*/
	private  String	 ifFileId   =  null;
	/*	Column Info	*/
	private  String	 totalCnt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public SakuraInterfaceListVO(){}

	public SakuraInterfaceListVO(String ifDt,String pstKeyCd,String custNo,String currCd,String asgnNo,String docDt,String refDocNo,String recTpCd,String loclAmt,String ifFlg,String pstDt,String glAcctNo,String erpIfErrFlg,String pagerows,String ifDocTpCd,String ibflag,String docAmt,String vatTaxCd,String erpIfErrRsn,String ifFileId,String totalCnt)	{
		this.ifDt  = ifDt ;
		this.pstKeyCd  = pstKeyCd ;
		this.custNo  = custNo ;
		this.currCd  = currCd ;
		this.asgnNo  = asgnNo ;
		this.docDt  = docDt ;
		this.refDocNo  = refDocNo ;
		this.recTpCd  = recTpCd ;
		this.loclAmt  = loclAmt ;
		this.ifFlg  = ifFlg ;
		this.pstDt  = pstDt ;
		this.glAcctNo  = glAcctNo ;
		this.erpIfErrFlg  = erpIfErrFlg ;
		this.pagerows  = pagerows ;
		this.ifDocTpCd  = ifDocTpCd ;
		this.ibflag  = ibflag ;
		this.docAmt  = docAmt ;
		this.vatTaxCd  = vatTaxCd ;
		this.erpIfErrRsn  = erpIfErrRsn ;
		this.ifFileId  = ifFileId ;
		this.totalCnt  = totalCnt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());		
		this.hashColumns.put("pst_key_cd", getPstKeyCd());		
		this.hashColumns.put("cust_no", getCustNo());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("asgn_no", getAsgnNo());		
		this.hashColumns.put("doc_dt", getDocDt());		
		this.hashColumns.put("ref_doc_no", getRefDocNo());		
		this.hashColumns.put("rec_tp_cd", getRecTpCd());		
		this.hashColumns.put("locl_amt", getLoclAmt());		
		this.hashColumns.put("if_flg", getIfFlg());		
		this.hashColumns.put("pst_dt", getPstDt());		
		this.hashColumns.put("gl_acct_no", getGlAcctNo());		
		this.hashColumns.put("erp_if_err_flg", getErpIfErrFlg());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("if_doc_tp_cd", getIfDocTpCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("doc_amt", getDocAmt());		
		this.hashColumns.put("vat_tax_cd", getVatTaxCd());		
		this.hashColumns.put("erp_if_err_rsn", getErpIfErrRsn());		
		this.hashColumns.put("if_file_id", getIfFileId());		
		this.hashColumns.put("total_cnt", getTotalCnt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("pst_key_cd", "pstKeyCd");
		this.hashFields.put("cust_no", "custNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("asgn_no", "asgnNo");
		this.hashFields.put("doc_dt", "docDt");
		this.hashFields.put("ref_doc_no", "refDocNo");
		this.hashFields.put("rec_tp_cd", "recTpCd");
		this.hashFields.put("locl_amt", "loclAmt");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("pst_dt", "pstDt");
		this.hashFields.put("gl_acct_no", "glAcctNo");
		this.hashFields.put("erp_if_err_flg", "erpIfErrFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("if_doc_tp_cd", "ifDocTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("doc_amt", "docAmt");
		this.hashFields.put("vat_tax_cd", "vatTaxCd");
		this.hashFields.put("erp_if_err_rsn", "erpIfErrRsn");
		this.hashFields.put("if_file_id", "ifFileId");
		this.hashFields.put("total_cnt", "totalCnt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  ifDt
	*/
	public void	setIfDt( String	ifDt ) {
		this.ifDt =	ifDt;
	}
 
	/**
	 * Column Info
	 * @return	ifDt
	 */
	 public	 String	getIfDt() {
		 return	this.ifDt;
	 } 
 	/**
	* Column Info
	* @param  pstKeyCd
	*/
	public void	setPstKeyCd( String	pstKeyCd ) {
		this.pstKeyCd =	pstKeyCd;
	}
 
	/**
	 * Column Info
	 * @return	pstKeyCd
	 */
	 public	 String	getPstKeyCd() {
		 return	this.pstKeyCd;
	 } 
 	/**
	* Column Info
	* @param  custNo
	*/
	public void	setCustNo( String	custNo ) {
		this.custNo =	custNo;
	}
 
	/**
	 * Column Info
	 * @return	custNo
	 */
	 public	 String	getCustNo() {
		 return	this.custNo;
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
	* @param  asgnNo
	*/
	public void	setAsgnNo( String	asgnNo ) {
		this.asgnNo =	asgnNo;
	}
 
	/**
	 * Column Info
	 * @return	asgnNo
	 */
	 public	 String	getAsgnNo() {
		 return	this.asgnNo;
	 } 
 	/**
	* Column Info
	* @param  docDt
	*/
	public void	setDocDt( String	docDt ) {
		this.docDt =	docDt;
	}
 
	/**
	 * Column Info
	 * @return	docDt
	 */
	 public	 String	getDocDt() {
		 return	this.docDt;
	 } 
 	/**
	* Column Info
	* @param  refDocNo
	*/
	public void	setRefDocNo( String	refDocNo ) {
		this.refDocNo =	refDocNo;
	}
 
	/**
	 * Column Info
	 * @return	refDocNo
	 */
	 public	 String	getRefDocNo() {
		 return	this.refDocNo;
	 } 
 	/**
	* Column Info
	* @param  recTpCd
	*/
	public void	setRecTpCd( String	recTpCd ) {
		this.recTpCd =	recTpCd;
	}
 
	/**
	 * Column Info
	 * @return	recTpCd
	 */
	 public	 String	getRecTpCd() {
		 return	this.recTpCd;
	 } 
 	/**
	* Column Info
	* @param  loclAmt
	*/
	public void	setLoclAmt( String	loclAmt ) {
		this.loclAmt =	loclAmt;
	}
 
	/**
	 * Column Info
	 * @return	loclAmt
	 */
	 public	 String	getLoclAmt() {
		 return	this.loclAmt;
	 } 
 	/**
	* Column Info
	* @param  ifFlg
	*/
	public void	setIfFlg( String	ifFlg ) {
		this.ifFlg =	ifFlg;
	}
 
	/**
	 * Column Info
	 * @return	ifFlg
	 */
	 public	 String	getIfFlg() {
		 return	this.ifFlg;
	 } 
 	/**
	* Column Info
	* @param  pstDt
	*/
	public void	setPstDt( String	pstDt ) {
		this.pstDt =	pstDt;
	}
 
	/**
	 * Column Info
	 * @return	pstDt
	 */
	 public	 String	getPstDt() {
		 return	this.pstDt;
	 } 
 	/**
	* Column Info
	* @param  glAcctNo
	*/
	public void	setGlAcctNo( String	glAcctNo ) {
		this.glAcctNo =	glAcctNo;
	}
 
	/**
	 * Column Info
	 * @return	glAcctNo
	 */
	 public	 String	getGlAcctNo() {
		 return	this.glAcctNo;
	 } 
 	/**
	* Column Info
	* @param  erpIfErrFlg
	*/
	public void	setErpIfErrFlg( String	erpIfErrFlg ) {
		this.erpIfErrFlg =	erpIfErrFlg;
	}
 
	/**
	 * Column Info
	 * @return	erpIfErrFlg
	 */
	 public	 String	getErpIfErrFlg() {
		 return	this.erpIfErrFlg;
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
	* @param  ifDocTpCd
	*/
	public void	setIfDocTpCd( String	ifDocTpCd ) {
		this.ifDocTpCd =	ifDocTpCd;
	}
 
	/**
	 * Column Info
	 * @return	ifDocTpCd
	 */
	 public	 String	getIfDocTpCd() {
		 return	this.ifDocTpCd;
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
	* @param  docAmt
	*/
	public void	setDocAmt( String	docAmt ) {
		this.docAmt =	docAmt;
	}
 
	/**
	 * Column Info
	 * @return	docAmt
	 */
	 public	 String	getDocAmt() {
		 return	this.docAmt;
	 } 
 	/**
	* Column Info
	* @param  vatTaxCd
	*/
	public void	setVatTaxCd( String	vatTaxCd ) {
		this.vatTaxCd =	vatTaxCd;
	}
 
	/**
	 * Column Info
	 * @return	vatTaxCd
	 */
	 public	 String	getVatTaxCd() {
		 return	this.vatTaxCd;
	 } 
 	/**
	* Column Info
	* @param  erpIfErrRsn
	*/
	public void	setErpIfErrRsn( String	erpIfErrRsn ) {
		this.erpIfErrRsn =	erpIfErrRsn;
	}
 
	/**
	 * Column Info
	 * @return	erpIfErrRsn
	 */
	 public	 String	getErpIfErrRsn() {
		 return	this.erpIfErrRsn;
	 } 
 	/**
	* Column Info
	* @param  ifFileId
	*/
	public void	setIfFileId( String	ifFileId ) {
		this.ifFileId =	ifFileId;
	}
 
	/**
	 * Column Info
	 * @return	ifFileId
	 */
	 public	 String	getIfFileId() {
		 return	this.ifFileId;
	 } 
 	/**
	* Column Info
	* @param  totalCnt
	*/
	public void	setTotalCnt( String	totalCnt ) {
		this.totalCnt =	totalCnt;
	}
 
	/**
	 * Column Info
	 * @return	totalCnt
	 */
	 public	 String	getTotalCnt() {
		 return	this.totalCnt;
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
		setIfDt(JSPUtil.getParameter(request,	prefix + "if_dt", ""));
		setPstKeyCd(JSPUtil.getParameter(request,	prefix + "pst_key_cd", ""));
		setCustNo(JSPUtil.getParameter(request,	prefix + "cust_no", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setAsgnNo(JSPUtil.getParameter(request,	prefix + "asgn_no", ""));
		setDocDt(JSPUtil.getParameter(request,	prefix + "doc_dt", ""));
		setRefDocNo(JSPUtil.getParameter(request,	prefix + "ref_doc_no", ""));
		setRecTpCd(JSPUtil.getParameter(request,	prefix + "rec_tp_cd", ""));
		setLoclAmt(JSPUtil.getParameter(request,	prefix + "locl_amt", ""));
		setIfFlg(JSPUtil.getParameter(request,	prefix + "if_flg", ""));
		setPstDt(JSPUtil.getParameter(request,	prefix + "pst_dt", ""));
		setGlAcctNo(JSPUtil.getParameter(request,	prefix + "gl_acct_no", ""));
		setErpIfErrFlg(JSPUtil.getParameter(request,	prefix + "erp_if_err_flg", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIfDocTpCd(JSPUtil.getParameter(request,	prefix + "if_doc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setDocAmt(JSPUtil.getParameter(request,	prefix + "doc_amt", ""));
		setVatTaxCd(JSPUtil.getParameter(request,	prefix + "vat_tax_cd", ""));
		setErpIfErrRsn(JSPUtil.getParameter(request,	prefix + "erp_if_err_rsn", ""));
		setIfFileId(JSPUtil.getParameter(request,	prefix + "if_file_id", ""));
		setTotalCnt(JSPUtil.getParameter(request,	prefix + "total_cnt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SakuraInterfaceListVO[]
	 */
	public SakuraInterfaceListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SakuraInterfaceListVO[]
	 */
	public SakuraInterfaceListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SakuraInterfaceListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ifDt =	(JSPUtil.getParameter(request, prefix +	"if_dt".trim(),	length));
				String[] pstKeyCd =	(JSPUtil.getParameter(request, prefix +	"pst_key_cd".trim(),	length));
				String[] custNo =	(JSPUtil.getParameter(request, prefix +	"cust_no".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] asgnNo =	(JSPUtil.getParameter(request, prefix +	"asgn_no".trim(),	length));
				String[] docDt =	(JSPUtil.getParameter(request, prefix +	"doc_dt".trim(),	length));
				String[] refDocNo =	(JSPUtil.getParameter(request, prefix +	"ref_doc_no".trim(),	length));
				String[] recTpCd =	(JSPUtil.getParameter(request, prefix +	"rec_tp_cd".trim(),	length));
				String[] loclAmt =	(JSPUtil.getParameter(request, prefix +	"locl_amt".trim(),	length));
				String[] ifFlg =	(JSPUtil.getParameter(request, prefix +	"if_flg".trim(),	length));
				String[] pstDt =	(JSPUtil.getParameter(request, prefix +	"pst_dt".trim(),	length));
				String[] glAcctNo =	(JSPUtil.getParameter(request, prefix +	"gl_acct_no".trim(),	length));
				String[] erpIfErrFlg =	(JSPUtil.getParameter(request, prefix +	"erp_if_err_flg".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ifDocTpCd =	(JSPUtil.getParameter(request, prefix +	"if_doc_tp_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] docAmt =	(JSPUtil.getParameter(request, prefix +	"doc_amt".trim(),	length));
				String[] vatTaxCd =	(JSPUtil.getParameter(request, prefix +	"vat_tax_cd".trim(),	length));
				String[] erpIfErrRsn =	(JSPUtil.getParameter(request, prefix +	"erp_if_err_rsn".trim(),	length));
				String[] ifFileId =	(JSPUtil.getParameter(request, prefix +	"if_file_id".trim(),	length));
				String[] totalCnt =	(JSPUtil.getParameter(request, prefix +	"total_cnt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	SakuraInterfaceListVO();
						if ( ifDt[i] !=	null)
						model.setIfDt( ifDt[i]);
						if ( pstKeyCd[i] !=	null)
						model.setPstKeyCd( pstKeyCd[i]);
						if ( custNo[i] !=	null)
						model.setCustNo( custNo[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( asgnNo[i] !=	null)
						model.setAsgnNo( asgnNo[i]);
						if ( docDt[i] !=	null)
						model.setDocDt( docDt[i]);
						if ( refDocNo[i] !=	null)
						model.setRefDocNo( refDocNo[i]);
						if ( recTpCd[i] !=	null)
						model.setRecTpCd( recTpCd[i]);
						if ( loclAmt[i] !=	null)
						model.setLoclAmt( loclAmt[i]);
						if ( ifFlg[i] !=	null)
						model.setIfFlg( ifFlg[i]);
						if ( pstDt[i] !=	null)
						model.setPstDt( pstDt[i]);
						if ( glAcctNo[i] !=	null)
						model.setGlAcctNo( glAcctNo[i]);
						if ( erpIfErrFlg[i] !=	null)
						model.setErpIfErrFlg( erpIfErrFlg[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ifDocTpCd[i] !=	null)
						model.setIfDocTpCd( ifDocTpCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( docAmt[i] !=	null)
						model.setDocAmt( docAmt[i]);
						if ( vatTaxCd[i] !=	null)
						model.setVatTaxCd( vatTaxCd[i]);
						if ( erpIfErrRsn[i] !=	null)
						model.setErpIfErrRsn( erpIfErrRsn[i]);
						if ( ifFileId[i] !=	null)
						model.setIfFileId( ifFileId[i]);
						if ( totalCnt[i] !=	null)
						model.setTotalCnt( totalCnt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getSakuraInterfaceListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return SakuraInterfaceListVO[]
	 */
	public SakuraInterfaceListVO[]	 getSakuraInterfaceListVOs(){
		SakuraInterfaceListVO[] vos = (SakuraInterfaceListVO[])models.toArray(new	SakuraInterfaceListVO[models.size()]);
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
		this.ifDt =	this.ifDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstKeyCd =	this.pstKeyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNo =	this.custNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnNo =	this.asgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docDt =	this.docDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refDocNo =	this.refDocNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recTpCd =	this.recTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAmt =	this.loclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg =	this.ifFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstDt =	this.pstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glAcctNo =	this.glAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfErrFlg =	this.erpIfErrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifDocTpCd =	this.ifDocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docAmt =	this.docAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatTaxCd =	this.vatTaxCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfErrRsn =	this.erpIfErrRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFileId =	this.ifFileId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt =	this.totalCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}