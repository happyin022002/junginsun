/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ARCustomerVO.java
 *@FileTitle : ARCustomerVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.08.09
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.08.09  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.invcommon.invcommon.vo;

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
public class ARCustomerVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ARCustomerVO>  models =	new	ArrayList<ARCustomerVO>();


	/*	Column Info	*/
	private  String	 indivCorpDivCd   =  null;
	/*	Column Info	*/
	private  String	 issDivCd   =  null;
	/*	Column Info	*/
	private  String	 bzctNm   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 deltFlg   =  null;
	/*	Column Info	*/
	private  String	 custEngNm   =  null;
	/*	Column Info	*/
	private  String	 bztpNm   =  null;
	/*	Column Info	*/
	private  String	 custRgstNo   =  null;
	/*	Column Info	*/
	private  String	 custSeq   =  null;
	/*	Column Info	*/
	private  String	 ibFaxNo   =  null;
	/*	Column Info	*/
	private  String	 obFaxNo   =  null;
	/*	Column Info	*/
	private  String	 crCurrCd   =  null;
	/*	Column Info	*/
	private  String	 obCrTermDys   =  null;
	/*	Column Info	*/
	private  String	 crCltOfcCd   =  null;
	/*	Column Info	*/
	private  String	 loclAddr   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ibCrTermDys   =  null;
	/*	Column Info	*/
	private  String	 obPhnNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 crAmt   =  null;
	/*	Column Info	*/
	private  String	 cntcPsonNm   =  null;
	/*	Column Info	*/
	private  String	 ibPhnNo   =  null;
	/*	Column Info	*/
	private  String	 custCntCd   =  null;
	/*	Column Info	*/
	private  String	 dfltInvCurrDivCd   =  null;
	/*	Column Info	*/
	private  String	 otsPayCd   =  null;
	/*	Column Info	*/
	private  String	 orgInvNo   =  null;
	/*	Column Info	*/
	private  String	 othLclVvd   =  null;
	/*	Column Info	*/
	private  String	 othPolCd   =  null;
	/*	Column Info	*/
	private  String	 othSvcScpCd   =  null;
	/*	Column Info	*/
	private  String	 othIoBndCd   =  null;
	/*	Column Info	*/
	private  String	 othSailDt   =  null;
	/*	Column Info	*/
	private  String	 othSailArrDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ARCustomerVO(){}

	public ARCustomerVO(String indivCorpDivCd,String issDivCd,String bzctNm,String custNm,String deltFlg,String custEngNm,String bztpNm,String custRgstNo,String custSeq,String ibFaxNo,String obFaxNo,String crCurrCd,String obCrTermDys,String crCltOfcCd,String loclAddr,String pagerows,String ibCrTermDys,String obPhnNo,String ibflag,String crAmt,String cntcPsonNm,String ibPhnNo,String custCntCd,String dfltInvCurrDivCd,String otsPayCd,String orgInvNo,String othLclVvd,String othPolCd,String othSvcScpCd,String othIoBndCd,String othSailDt,String othSailArrDt)	{
		this.indivCorpDivCd  = indivCorpDivCd ;
		this.issDivCd  = issDivCd ;
		this.bzctNm  = bzctNm ;
		this.custNm  = custNm ;
		this.deltFlg  = deltFlg ;
		this.custEngNm  = custEngNm ;
		this.bztpNm  = bztpNm ;
		this.custRgstNo  = custRgstNo ;
		this.custSeq  = custSeq ;
		this.ibFaxNo  = ibFaxNo ;
		this.obFaxNo  = obFaxNo ;
		this.crCurrCd  = crCurrCd ;
		this.obCrTermDys  = obCrTermDys ;
		this.crCltOfcCd  = crCltOfcCd ;
		this.loclAddr  = loclAddr ;
		this.pagerows  = pagerows ;
		this.ibCrTermDys  = ibCrTermDys ;
		this.obPhnNo  = obPhnNo ;
		this.ibflag  = ibflag ;
		this.crAmt  = crAmt ;
		this.cntcPsonNm  = cntcPsonNm ;
		this.ibPhnNo  = ibPhnNo ;
		this.custCntCd  = custCntCd ;
		this.dfltInvCurrDivCd  = dfltInvCurrDivCd ;
		this.otsPayCd  = otsPayCd ;
		this.orgInvNo  = orgInvNo ;
		this.othLclVvd  = othLclVvd ;
		this.othPolCd  = othPolCd ;
		this.othSvcScpCd  = othSvcScpCd ;
		this.othIoBndCd  = othIoBndCd ;
		this.othSailDt  = othSailDt ;
		this.othSailArrDt  = othSailArrDt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("indiv_corp_div_cd", getIndivCorpDivCd());		
		this.hashColumns.put("iss_div_cd", getIssDivCd());		
		this.hashColumns.put("bzct_nm", getBzctNm());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("delt_flg", getDeltFlg());		
		this.hashColumns.put("cust_eng_nm", getCustEngNm());		
		this.hashColumns.put("bztp_nm", getBztpNm());		
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());		
		this.hashColumns.put("cust_seq", getCustSeq());		
		this.hashColumns.put("ib_fax_no", getIbFaxNo());		
		this.hashColumns.put("ob_fax_no", getObFaxNo());		
		this.hashColumns.put("cr_curr_cd", getCrCurrCd());		
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());		
		this.hashColumns.put("cr_clt_ofc_cd", getCrCltOfcCd());		
		this.hashColumns.put("locl_addr", getLoclAddr());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());		
		this.hashColumns.put("ob_phn_no", getObPhnNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cr_amt", getCrAmt());		
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());		
		this.hashColumns.put("ib_phn_no", getIbPhnNo());		
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());		
		this.hashColumns.put("dflt_inv_curr_div_cd", getDfltInvCurrDivCd());		
		this.hashColumns.put("ots_pay_cd", getOtsPayCd());		
		this.hashColumns.put("org_inv_no", getOrgInvNo());		
		this.hashColumns.put("oth_lcl_vvd", getOthLclVvd());		
		this.hashColumns.put("oth_pol_cd", getOthPolCd());		
		this.hashColumns.put("oth_svc_scp_cd", getOthSvcScpCd());		
		this.hashColumns.put("oth_io_bnd_cd", getOthIoBndCd());		
		this.hashColumns.put("oth_sail_dt", getOthSailDt());		
		this.hashColumns.put("oth_sail_arr_dt", getOthSailArrDt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("indiv_corp_div_cd", "indivCorpDivCd");
		this.hashFields.put("iss_div_cd", "issDivCd");
		this.hashFields.put("bzct_nm", "bzctNm");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cust_eng_nm", "custEngNm");
		this.hashFields.put("bztp_nm", "bztpNm");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ib_fax_no", "ibFaxNo");
		this.hashFields.put("ob_fax_no", "obFaxNo");
		this.hashFields.put("cr_curr_cd", "crCurrCd");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("cr_clt_ofc_cd", "crCltOfcCd");
		this.hashFields.put("locl_addr", "loclAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("ob_phn_no", "obPhnNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("ib_phn_no", "ibPhnNo");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("dflt_inv_curr_div_cd", "dfltInvCurrDivCd");
		this.hashFields.put("ots_pay_cd", "otsPayCd");
		this.hashFields.put("org_inv_no", "orgInvNo");
		this.hashFields.put("oth_lcl_vvd", "othLclVvd");
		this.hashFields.put("oth_pol_cd", "othPolCd");
		this.hashFields.put("oth_svc_scp_cd", "othSvcScpCd");
		this.hashFields.put("oth_io_bnd_cd", "othIoBndCd");
		this.hashFields.put("oth_sail_dt", "othSailDt");
		this.hashFields.put("oth_sail_arr_dt", "othSailArrDt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  indivCorpDivCd
	*/
	public void	setIndivCorpDivCd( String	indivCorpDivCd ) {
		this.indivCorpDivCd =	indivCorpDivCd;
	}
 
	/**
	 * Column Info
	 * @return	indivCorpDivCd
	 */
	 public	 String	getIndivCorpDivCd() {
		 return	this.indivCorpDivCd;
	 } 
 	/**
	* Column Info
	* @param  issDivCd
	*/
	public void	setIssDivCd( String	issDivCd ) {
		this.issDivCd =	issDivCd;
	}
 
	/**
	 * Column Info
	 * @return	issDivCd
	 */
	 public	 String	getIssDivCd() {
		 return	this.issDivCd;
	 } 
 	/**
	* Column Info
	* @param  bzctNm
	*/
	public void	setBzctNm( String	bzctNm ) {
		this.bzctNm =	bzctNm;
	}
 
	/**
	 * Column Info
	 * @return	bzctNm
	 */
	 public	 String	getBzctNm() {
		 return	this.bzctNm;
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
	* @param  deltFlg
	*/
	public void	setDeltFlg( String	deltFlg ) {
		this.deltFlg =	deltFlg;
	}
 
	/**
	 * Column Info
	 * @return	deltFlg
	 */
	 public	 String	getDeltFlg() {
		 return	this.deltFlg;
	 } 
 	/**
	* Column Info
	* @param  custEngNm
	*/
	public void	setCustEngNm( String	custEngNm ) {
		this.custEngNm =	custEngNm;
	}
 
	/**
	 * Column Info
	 * @return	custEngNm
	 */
	 public	 String	getCustEngNm() {
		 return	this.custEngNm;
	 } 
 	/**
	* Column Info
	* @param  bztpNm
	*/
	public void	setBztpNm( String	bztpNm ) {
		this.bztpNm =	bztpNm;
	}
 
	/**
	 * Column Info
	 * @return	bztpNm
	 */
	 public	 String	getBztpNm() {
		 return	this.bztpNm;
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
	* @param  ibFaxNo
	*/
	public void	setIbFaxNo( String	ibFaxNo ) {
		this.ibFaxNo =	ibFaxNo;
	}
 
	/**
	 * Column Info
	 * @return	ibFaxNo
	 */
	 public	 String	getIbFaxNo() {
		 return	this.ibFaxNo;
	 } 
 	/**
	* Column Info
	* @param  obFaxNo
	*/
	public void	setObFaxNo( String	obFaxNo ) {
		this.obFaxNo =	obFaxNo;
	}
 
	/**
	 * Column Info
	 * @return	obFaxNo
	 */
	 public	 String	getObFaxNo() {
		 return	this.obFaxNo;
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
	* @param  obCrTermDys
	*/
	public void	setObCrTermDys( String	obCrTermDys ) {
		this.obCrTermDys =	obCrTermDys;
	}
 
	/**
	 * Column Info
	 * @return	obCrTermDys
	 */
	 public	 String	getObCrTermDys() {
		 return	this.obCrTermDys;
	 } 
 	/**
	* Column Info
	* @param  crCltOfcCd
	*/
	public void	setCrCltOfcCd( String	crCltOfcCd ) {
		this.crCltOfcCd =	crCltOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	crCltOfcCd
	 */
	 public	 String	getCrCltOfcCd() {
		 return	this.crCltOfcCd;
	 } 
 	/**
	* Column Info
	* @param  loclAddr
	*/
	public void	setLoclAddr( String	loclAddr ) {
		this.loclAddr =	loclAddr;
	}
 
	/**
	 * Column Info
	 * @return	loclAddr
	 */
	 public	 String	getLoclAddr() {
		 return	this.loclAddr;
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
	* @param  ibCrTermDys
	*/
	public void	setIbCrTermDys( String	ibCrTermDys ) {
		this.ibCrTermDys =	ibCrTermDys;
	}
 
	/**
	 * Column Info
	 * @return	ibCrTermDys
	 */
	 public	 String	getIbCrTermDys() {
		 return	this.ibCrTermDys;
	 } 
 	/**
	* Column Info
	* @param  obPhnNo
	*/
	public void	setObPhnNo( String	obPhnNo ) {
		this.obPhnNo =	obPhnNo;
	}
 
	/**
	 * Column Info
	 * @return	obPhnNo
	 */
	 public	 String	getObPhnNo() {
		 return	this.obPhnNo;
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
	* @param  ibPhnNo
	*/
	public void	setIbPhnNo( String	ibPhnNo ) {
		this.ibPhnNo =	ibPhnNo;
	}
 
	/**
	 * Column Info
	 * @return	ibPhnNo
	 */
	 public	 String	getIbPhnNo() {
		 return	this.ibPhnNo;
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
	* @param  dfltInvCurrDivCd
	*/
	public void	setDfltInvCurrDivCd( String	dfltInvCurrDivCd ) {
		this.dfltInvCurrDivCd =	dfltInvCurrDivCd;
	}
 
	/**
	 * Column Info
	 * @return	dfltInvCurrDivCd
	 */
	 public	 String	getDfltInvCurrDivCd() {
		 return	this.dfltInvCurrDivCd;
	 } 
 	/**
	* Column Info
	* @param  otsPayCd
	*/
	public void	setOtsPayCd( String	otsPayCd ) {
		this.otsPayCd =	otsPayCd;
	}
 
	/**
	 * Column Info
	 * @return	otsPayCd
	 */
	 public	 String	getOtsPayCd() {
		 return	this.otsPayCd;
	 } 
 	/**
	* Column Info
	* @param  orgInvNo
	*/
	public void	setOrgInvNo( String	orgInvNo ) {
		this.orgInvNo =	orgInvNo;
	}
 
	/**
	 * Column Info
	 * @return	orgInvNo
	 */
	 public	 String	getOrgInvNo() {
		 return	this.orgInvNo;
	 } 
 	/**
	* Column Info
	* @param  othLclVvd
	*/
	public void	setOthLclVvd( String	othLclVvd ) {
		this.othLclVvd =	othLclVvd;
	}
 
	/**
	 * Column Info
	 * @return	othLclVvd
	 */
	 public	 String	getOthLclVvd() {
		 return	this.othLclVvd;
	 } 
 	/**
	* Column Info
	* @param  othPolCd
	*/
	public void	setOthPolCd( String	othPolCd ) {
		this.othPolCd =	othPolCd;
	}
 
	/**
	 * Column Info
	 * @return	othPolCd
	 */
	 public	 String	getOthPolCd() {
		 return	this.othPolCd;
	 } 
 	/**
	* Column Info
	* @param  othSvcScpCd
	*/
	public void	setOthSvcScpCd( String	othSvcScpCd ) {
		this.othSvcScpCd =	othSvcScpCd;
	}
 
	/**
	 * Column Info
	 * @return	othSvcScpCd
	 */
	 public	 String	getOthSvcScpCd() {
		 return	this.othSvcScpCd;
	 } 
 	/**
	* Column Info
	* @param  othIoBndCd
	*/
	public void	setOthIoBndCd( String	othIoBndCd ) {
		this.othIoBndCd =	othIoBndCd;
	}
 
	/**
	 * Column Info
	 * @return	othIoBndCd
	 */
	 public	 String	getOthIoBndCd() {
		 return	this.othIoBndCd;
	 } 
 	/**
	* Column Info
	* @param  othSailDt
	*/
	public void	setOthSailDt( String	othSailDt ) {
		this.othSailDt =	othSailDt;
	}
 
	/**
	 * Column Info
	 * @return	othSailDt
	 */
	 public	 String	getOthSailDt() {
		 return	this.othSailDt;
	 } 
 	/**
	* Column Info
	* @param  othSailArrDt
	*/
	public void	setOthSailArrDt( String	othSailArrDt ) {
		this.othSailArrDt =	othSailArrDt;
	}
 
	/**
	 * Column Info
	 * @return	othSailArrDt
	 */
	 public	 String	getOthSailArrDt() {
		 return	this.othSailArrDt;
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
		setIndivCorpDivCd(JSPUtil.getParameter(request,	prefix + "indiv_corp_div_cd", ""));
		setIssDivCd(JSPUtil.getParameter(request,	prefix + "iss_div_cd", ""));
		setBzctNm(JSPUtil.getParameter(request,	prefix + "bzct_nm", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request,	prefix + "delt_flg", ""));
		setCustEngNm(JSPUtil.getParameter(request,	prefix + "cust_eng_nm", ""));
		setBztpNm(JSPUtil.getParameter(request,	prefix + "bztp_nm", ""));
		setCustRgstNo(JSPUtil.getParameter(request,	prefix + "cust_rgst_no", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setIbFaxNo(JSPUtil.getParameter(request,	prefix + "ib_fax_no", ""));
		setObFaxNo(JSPUtil.getParameter(request,	prefix + "ob_fax_no", ""));
		setCrCurrCd(JSPUtil.getParameter(request,	prefix + "cr_curr_cd", ""));
		setObCrTermDys(JSPUtil.getParameter(request,	prefix + "ob_cr_term_dys", ""));
		setCrCltOfcCd(JSPUtil.getParameter(request,	prefix + "cr_clt_ofc_cd", ""));
		setLoclAddr(JSPUtil.getParameter(request,	prefix + "locl_addr", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIbCrTermDys(JSPUtil.getParameter(request,	prefix + "ib_cr_term_dys", ""));
		setObPhnNo(JSPUtil.getParameter(request,	prefix + "ob_phn_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCrAmt(JSPUtil.getParameter(request,	prefix + "cr_amt", ""));
		setCntcPsonNm(JSPUtil.getParameter(request,	prefix + "cntc_pson_nm", ""));
		setIbPhnNo(JSPUtil.getParameter(request,	prefix + "ib_phn_no", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setDfltInvCurrDivCd(JSPUtil.getParameter(request,	prefix + "dflt_inv_curr_div_cd", ""));
		setOtsPayCd(JSPUtil.getParameter(request,	prefix + "ots_pay_cd", ""));
		setOrgInvNo(JSPUtil.getParameter(request,	prefix + "org_inv_no", ""));
		setOthLclVvd(JSPUtil.getParameter(request,	prefix + "oth_lcl_vvd", ""));
		setOthPolCd(JSPUtil.getParameter(request,	prefix + "oth_pol_cd", ""));
		setOthSvcScpCd(JSPUtil.getParameter(request,	prefix + "oth_svc_scp_cd", ""));
		setOthIoBndCd(JSPUtil.getParameter(request,	prefix + "oth_io_bnd_cd", ""));
		setOthSailDt(JSPUtil.getParameter(request,	prefix + "oth_sail_dt", ""));
		setOthSailArrDt(JSPUtil.getParameter(request,	prefix + "oth_sail_arr_dt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARCustomerVO[]
	 */
	public ARCustomerVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ARCustomerVO[]
	 */
	public ARCustomerVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ARCustomerVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] indivCorpDivCd =	(JSPUtil.getParameter(request, prefix +	"indiv_corp_div_cd".trim(),	length));
				String[] issDivCd =	(JSPUtil.getParameter(request, prefix +	"iss_div_cd".trim(),	length));
				String[] bzctNm =	(JSPUtil.getParameter(request, prefix +	"bzct_nm".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] deltFlg =	(JSPUtil.getParameter(request, prefix +	"delt_flg".trim(),	length));
				String[] custEngNm =	(JSPUtil.getParameter(request, prefix +	"cust_eng_nm".trim(),	length));
				String[] bztpNm =	(JSPUtil.getParameter(request, prefix +	"bztp_nm".trim(),	length));
				String[] custRgstNo =	(JSPUtil.getParameter(request, prefix +	"cust_rgst_no".trim(),	length));
				String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq".trim(),	length));
				String[] ibFaxNo =	(JSPUtil.getParameter(request, prefix +	"ib_fax_no".trim(),	length));
				String[] obFaxNo =	(JSPUtil.getParameter(request, prefix +	"ob_fax_no".trim(),	length));
				String[] crCurrCd =	(JSPUtil.getParameter(request, prefix +	"cr_curr_cd".trim(),	length));
				String[] obCrTermDys =	(JSPUtil.getParameter(request, prefix +	"ob_cr_term_dys".trim(),	length));
				String[] crCltOfcCd =	(JSPUtil.getParameter(request, prefix +	"cr_clt_ofc_cd".trim(),	length));
				String[] loclAddr =	(JSPUtil.getParameter(request, prefix +	"locl_addr".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ibCrTermDys =	(JSPUtil.getParameter(request, prefix +	"ib_cr_term_dys".trim(),	length));
				String[] obPhnNo =	(JSPUtil.getParameter(request, prefix +	"ob_phn_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] crAmt =	(JSPUtil.getParameter(request, prefix +	"cr_amt".trim(),	length));
				String[] cntcPsonNm =	(JSPUtil.getParameter(request, prefix +	"cntc_pson_nm".trim(),	length));
				String[] ibPhnNo =	(JSPUtil.getParameter(request, prefix +	"ib_phn_no".trim(),	length));
				String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd".trim(),	length));
				String[] dfltInvCurrDivCd =	(JSPUtil.getParameter(request, prefix +	"dflt_inv_curr_div_cd".trim(),	length));
				String[] otsPayCd =	(JSPUtil.getParameter(request, prefix +	"ots_pay_cd".trim(),	length));
				String[] orgInvNo =	(JSPUtil.getParameter(request, prefix +	"org_inv_no".trim(),	length));
				String[] othLclVvd =	(JSPUtil.getParameter(request, prefix +	"oth_lcl_vvd".trim(),	length));
				String[] othPolCd =	(JSPUtil.getParameter(request, prefix +	"oth_pol_cd".trim(),	length));
				String[] othSvcScpCd =	(JSPUtil.getParameter(request, prefix +	"oth_svc_scp_cd".trim(),	length));
				String[] othIoBndCd =	(JSPUtil.getParameter(request, prefix +	"oth_io_bnd_cd".trim(),	length));
				String[] othSailDt =	(JSPUtil.getParameter(request, prefix +	"oth_sail_dt".trim(),	length));
				String[] othSailArrDt =	(JSPUtil.getParameter(request, prefix +	"oth_sail_arr_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ARCustomerVO();
						if ( indivCorpDivCd[i] !=	null)
						model.setIndivCorpDivCd( indivCorpDivCd[i]);
						if ( issDivCd[i] !=	null)
						model.setIssDivCd( issDivCd[i]);
						if ( bzctNm[i] !=	null)
						model.setBzctNm( bzctNm[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( deltFlg[i] !=	null)
						model.setDeltFlg( deltFlg[i]);
						if ( custEngNm[i] !=	null)
						model.setCustEngNm( custEngNm[i]);
						if ( bztpNm[i] !=	null)
						model.setBztpNm( bztpNm[i]);
						if ( custRgstNo[i] !=	null)
						model.setCustRgstNo( custRgstNo[i]);
						if ( custSeq[i] !=	null)
						model.setCustSeq( custSeq[i]);
						if ( ibFaxNo[i] !=	null)
						model.setIbFaxNo( ibFaxNo[i]);
						if ( obFaxNo[i] !=	null)
						model.setObFaxNo( obFaxNo[i]);
						if ( crCurrCd[i] !=	null)
						model.setCrCurrCd( crCurrCd[i]);
						if ( obCrTermDys[i] !=	null)
						model.setObCrTermDys( obCrTermDys[i]);
						if ( crCltOfcCd[i] !=	null)
						model.setCrCltOfcCd( crCltOfcCd[i]);
						if ( loclAddr[i] !=	null)
						model.setLoclAddr( loclAddr[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ibCrTermDys[i] !=	null)
						model.setIbCrTermDys( ibCrTermDys[i]);
						if ( obPhnNo[i] !=	null)
						model.setObPhnNo( obPhnNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( crAmt[i] !=	null)
						model.setCrAmt( crAmt[i]);
						if ( cntcPsonNm[i] !=	null)
						model.setCntcPsonNm( cntcPsonNm[i]);
						if ( ibPhnNo[i] !=	null)
						model.setIbPhnNo( ibPhnNo[i]);
						if ( custCntCd[i] !=	null)
						model.setCustCntCd( custCntCd[i]);
						if ( dfltInvCurrDivCd[i] !=	null)
						model.setDfltInvCurrDivCd( dfltInvCurrDivCd[i]);
						if ( otsPayCd[i] !=	null)
						model.setOtsPayCd( otsPayCd[i]);
						if ( orgInvNo[i] !=	null)
						model.setOrgInvNo( orgInvNo[i]);
						if ( othLclVvd[i] !=	null)
						model.setOthLclVvd( othLclVvd[i]);
						if ( othPolCd[i] !=	null)
						model.setOthPolCd( othPolCd[i]);
						if ( othSvcScpCd[i] !=	null)
						model.setOthSvcScpCd( othSvcScpCd[i]);
						if ( othIoBndCd[i] !=	null)
						model.setOthIoBndCd( othIoBndCd[i]);
						if ( othSailDt[i] !=	null)
						model.setOthSailDt( othSailDt[i]);
						if ( othSailArrDt[i] !=	null)
						model.setOthSailArrDt( othSailArrDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getARCustomerVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ARCustomerVO[]
	 */
	public ARCustomerVO[]	 getARCustomerVOs(){
		ARCustomerVO[] vos = (ARCustomerVO[])models.toArray(new	ARCustomerVO[models.size()]);
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
		this.indivCorpDivCd =	this.indivCorpDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDivCd =	this.issDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzctNm =	this.bzctNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg =	this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEngNm =	this.custEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bztpNm =	this.bztpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo =	this.custRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibFaxNo =	this.ibFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obFaxNo =	this.obFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCurrCd =	this.crCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys =	this.obCrTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCltOfcCd =	this.crCltOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr =	this.loclAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys =	this.ibCrTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obPhnNo =	this.obPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt =	this.crAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm =	this.cntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibPhnNo =	this.ibPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltInvCurrDivCd =	this.dfltInvCurrDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsPayCd =	this.otsPayCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgInvNo =	this.orgInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othLclVvd =	this.othLclVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othPolCd =	this.othPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othSvcScpCd =	this.othSvcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othIoBndCd =	this.othIoBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othSailDt =	this.othSailDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othSailArrDt =	this.othSailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}