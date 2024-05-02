/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvoiceCustomerChangeVO.java
 *@FileTitle : InvoiceCustomerChangeVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.09
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.01.09  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

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
public class InvoiceCustomerChangeVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvoiceCustomerChangeVO>  models =	new	ArrayList<InvoiceCustomerChangeVO>();
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceCustomerChangeChargeVO invoiceCustomerChangeChargeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvoiceCustomerChangeChargeVO> invoiceCustomerChangeChargeVOs;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DueDateInputVO dueDateInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<DueDateInputVO> dueDateInputVOs;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceCustomerChangeListVO invoiceCustomerChangeListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvoiceCustomerChangeListVO> invoiceCustomerChangeListVOs;	

	/*	Column Info	*/
	private  String	 porCd   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 issDt   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 revSrcCd   =  null;
	/*	Column Info	*/
	private  String	 invCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 arIfNo   =  null;
	/*	Column Info	*/
	private  String	 actCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 invCustNm   =  null;
	/*	Column Info	*/
	private  String	 blSrcNo   =  null;
	/*	Column Info	*/
	private  String	 invRefNo   =  null;
	/*	Column Info	*/
	private  String	 glEffDt   =  null;
	/*	Column Info	*/
	private  String	 invCustSeq   =  null;
	/*	Column Info	*/
	private  String	 actCustSeq   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 revTpCd   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 dfltInvCurrDivCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvoiceCustomerChangeVO(){}

	public InvoiceCustomerChangeVO(String porCd,String custNm,String svcScpCd,String sailArrDt,String pagerows,String issDt,String polCd,String ibflag,String revSrcCd,String invCustCntCd,String arIfNo,String actCustCntCd,String invCustNm,String blSrcNo,String invRefNo,String glEffDt,String invCustSeq,String actCustSeq,String delCd,String ioBndCd,String revTpCd,String arOfcCd,String podCd,String vvd,String invNo,String bkgNo,String invCurrCd,String dfltInvCurrDivCd)	{
		this.porCd  = porCd ;
		this.custNm  = custNm ;
		this.svcScpCd  = svcScpCd ;
		this.sailArrDt  = sailArrDt ;
		this.pagerows  = pagerows ;
		this.issDt  = issDt ;
		this.polCd  = polCd ;
		this.ibflag  = ibflag ;
		this.revSrcCd  = revSrcCd ;
		this.invCustCntCd  = invCustCntCd ;
		this.arIfNo  = arIfNo ;
		this.actCustCntCd  = actCustCntCd ;
		this.invCustNm  = invCustNm ;
		this.blSrcNo  = blSrcNo ;
		this.invRefNo  = invRefNo ;
		this.glEffDt  = glEffDt ;
		this.invCustSeq  = invCustSeq ;
		this.actCustSeq  = actCustSeq ;
		this.delCd  = delCd ;
		this.ioBndCd  = ioBndCd ;
		this.revTpCd  = revTpCd ;
		this.arOfcCd  = arOfcCd ;
		this.podCd  = podCd ;
		this.vvd  = vvd ;
		this.invNo  = invNo ;
		this.bkgNo  = bkgNo ;
		this.invCurrCd  = invCurrCd ;
		this.dfltInvCurrDivCd  = dfltInvCurrDivCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("iss_dt", getIssDt());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("rev_src_cd", getRevSrcCd());		
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());		
		this.hashColumns.put("ar_if_no", getArIfNo());		
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());		
		this.hashColumns.put("inv_cust_nm", getInvCustNm());		
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		this.hashColumns.put("inv_ref_no", getInvRefNo());		
		this.hashColumns.put("gl_eff_dt", getGlEffDt());		
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());		
		this.hashColumns.put("act_cust_seq", getActCustSeq());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("rev_tp_cd", getRevTpCd());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("dflt_inv_curr_div_cd", getDfltInvCurrDivCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("inv_cust_nm", "invCustNm");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("dflt_inv_curr_div_cd", "dfltInvCurrDivCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  porCd
	*/
	public void	setPorCd( String	porCd ) {
		this.porCd =	porCd;
	}
 
	/**
	 * Column Info
	 * @return	porCd
	 */
	 public	 String	getPorCd() {
		 return	this.porCd;
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
	* @param  sailArrDt
	*/
	public void	setSailArrDt( String	sailArrDt ) {
		this.sailArrDt =	sailArrDt;
	}
 
	/**
	 * Column Info
	 * @return	sailArrDt
	 */
	 public	 String	getSailArrDt() {
		 return	this.sailArrDt;
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
	* @param  revSrcCd
	*/
	public void	setRevSrcCd( String	revSrcCd ) {
		this.revSrcCd =	revSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	revSrcCd
	 */
	 public	 String	getRevSrcCd() {
		 return	this.revSrcCd;
	 } 
 	/**
	* Column Info
	* @param  invCustCntCd
	*/
	public void	setInvCustCntCd( String	invCustCntCd ) {
		this.invCustCntCd =	invCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	invCustCntCd
	 */
	 public	 String	getInvCustCntCd() {
		 return	this.invCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  arIfNo
	*/
	public void	setArIfNo( String	arIfNo ) {
		this.arIfNo =	arIfNo;
	}
 
	/**
	 * Column Info
	 * @return	arIfNo
	 */
	 public	 String	getArIfNo() {
		 return	this.arIfNo;
	 } 
 	/**
	* Column Info
	* @param  actCustCntCd
	*/
	public void	setActCustCntCd( String	actCustCntCd ) {
		this.actCustCntCd =	actCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	actCustCntCd
	 */
	 public	 String	getActCustCntCd() {
		 return	this.actCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  invCustNm
	*/
	public void	setInvCustNm( String	invCustNm ) {
		this.invCustNm =	invCustNm;
	}
 
	/**
	 * Column Info
	 * @return	invCustNm
	 */
	 public	 String	getInvCustNm() {
		 return	this.invCustNm;
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
	* @param  invRefNo
	*/
	public void	setInvRefNo( String	invRefNo ) {
		this.invRefNo =	invRefNo;
	}
 
	/**
	 * Column Info
	 * @return	invRefNo
	 */
	 public	 String	getInvRefNo() {
		 return	this.invRefNo;
	 } 
 	/**
	* Column Info
	* @param  glEffDt
	*/
	public void	setGlEffDt( String	glEffDt ) {
		this.glEffDt =	glEffDt;
	}
 
	/**
	 * Column Info
	 * @return	glEffDt
	 */
	 public	 String	getGlEffDt() {
		 return	this.glEffDt;
	 } 
 	/**
	* Column Info
	* @param  invCustSeq
	*/
	public void	setInvCustSeq( String	invCustSeq ) {
		this.invCustSeq =	invCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	invCustSeq
	 */
	 public	 String	getInvCustSeq() {
		 return	this.invCustSeq;
	 } 
 	/**
	* Column Info
	* @param  actCustSeq
	*/
	public void	setActCustSeq( String	actCustSeq ) {
		this.actCustSeq =	actCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	actCustSeq
	 */
	 public	 String	getActCustSeq() {
		 return	this.actCustSeq;
	 } 
 	/**
	* Column Info
	* @param  delCd
	*/
	public void	setDelCd( String	delCd ) {
		this.delCd =	delCd;
	}
 
	/**
	 * Column Info
	 * @return	delCd
	 */
	 public	 String	getDelCd() {
		 return	this.delCd;
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
	* @param  revTpCd
	*/
	public void	setRevTpCd( String	revTpCd ) {
		this.revTpCd =	revTpCd;
	}
 
	/**
	 * Column Info
	 * @return	revTpCd
	 */
	 public	 String	getRevTpCd() {
		 return	this.revTpCd;
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

	public InvoiceCustomerChangeChargeVO getInvoiceCustomerChangeChargeVO() {
		return invoiceCustomerChangeChargeVO;
	}

	public void setInvoiceCustomerChangeChargeVO(
			InvoiceCustomerChangeChargeVO invoiceCustomerChangeChargeVO) {
		this.invoiceCustomerChangeChargeVO = invoiceCustomerChangeChargeVO;
	}

	public List<InvoiceCustomerChangeChargeVO> getInvoiceCustomerChangeChargeVOs() {
		return invoiceCustomerChangeChargeVOs;
	}

	public void setInvoiceCustomerChangeChargeVOs(
			List<InvoiceCustomerChangeChargeVO> invoiceCustomerChangeChargeVOs) {
		this.invoiceCustomerChangeChargeVOs = invoiceCustomerChangeChargeVOs;
	}

	public DueDateInputVO getDueDateInputVO() {
		return dueDateInputVO;
	}

	public void setDueDateInputVO(DueDateInputVO dueDateInputVO) {
		this.dueDateInputVO = dueDateInputVO;
	}

	public List<DueDateInputVO> getDueDateInputVOs() {
		return dueDateInputVOs;
	}

	public void setDueDateInputVOs(List<DueDateInputVO> dueDateInputVOs) {
		this.dueDateInputVOs = dueDateInputVOs;
	}

	public InvoiceCustomerChangeListVO getInvoiceCustomerChangeListVO() {
		return invoiceCustomerChangeListVO;
	}

	public void setInvoiceCustomerChangeListVO(
			InvoiceCustomerChangeListVO invoiceCustomerChangeListVO) {
		this.invoiceCustomerChangeListVO = invoiceCustomerChangeListVO;
	}

	public List<InvoiceCustomerChangeListVO> getInvoiceCustomerChangeListVOs() {
		return invoiceCustomerChangeListVOs;
	}

	public void setInvoiceCustomerChangeListVOs(
			List<InvoiceCustomerChangeListVO> invoiceCustomerChangeListVOs) {
		this.invoiceCustomerChangeListVOs = invoiceCustomerChangeListVOs;
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
		setPorCd(JSPUtil.getParameter(request,	prefix + "por_cd", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIssDt(JSPUtil.getParameter(request,	prefix + "iss_dt", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setRevSrcCd(JSPUtil.getParameter(request,	prefix + "rev_src_cd", ""));
		setInvCustCntCd(JSPUtil.getParameter(request,	prefix + "inv_cust_cnt_cd", ""));
		setArIfNo(JSPUtil.getParameter(request,	prefix + "ar_if_no", ""));
		setActCustCntCd(JSPUtil.getParameter(request,	prefix + "act_cust_cnt_cd", ""));
		setInvCustNm(JSPUtil.getParameter(request,	prefix + "inv_cust_nm", ""));
		setBlSrcNo(JSPUtil.getParameter(request,	prefix + "bl_src_no", ""));
		setInvRefNo(JSPUtil.getParameter(request,	prefix + "inv_ref_no", ""));
		setGlEffDt(JSPUtil.getParameter(request,	prefix + "gl_eff_dt", ""));
		setInvCustSeq(JSPUtil.getParameter(request,	prefix + "inv_cust_seq", ""));
		setActCustSeq(JSPUtil.getParameter(request,	prefix + "act_cust_seq", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setRevTpCd(JSPUtil.getParameter(request,	prefix + "rev_tp_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setDfltInvCurrDivCd(JSPUtil.getParameter(request,	prefix + "dflt_inv_curr_div_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceCustomerChangeVO[]
	 */
	public InvoiceCustomerChangeVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvoiceCustomerChangeVO[]
	 */
	public InvoiceCustomerChangeVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoiceCustomerChangeVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] porCd =	(JSPUtil.getParameter(request, prefix +	"por_cd".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] issDt =	(JSPUtil.getParameter(request, prefix +	"iss_dt".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] revSrcCd =	(JSPUtil.getParameter(request, prefix +	"rev_src_cd".trim(),	length));
				String[] invCustCntCd =	(JSPUtil.getParameter(request, prefix +	"inv_cust_cnt_cd".trim(),	length));
				String[] arIfNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_no".trim(),	length));
				String[] actCustCntCd =	(JSPUtil.getParameter(request, prefix +	"act_cust_cnt_cd".trim(),	length));
				String[] invCustNm =	(JSPUtil.getParameter(request, prefix +	"inv_cust_nm".trim(),	length));
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				String[] invRefNo =	(JSPUtil.getParameter(request, prefix +	"inv_ref_no".trim(),	length));
				String[] glEffDt =	(JSPUtil.getParameter(request, prefix +	"gl_eff_dt".trim(),	length));
				String[] invCustSeq =	(JSPUtil.getParameter(request, prefix +	"inv_cust_seq".trim(),	length));
				String[] actCustSeq =	(JSPUtil.getParameter(request, prefix +	"act_cust_seq".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] revTpCd =	(JSPUtil.getParameter(request, prefix +	"rev_tp_cd".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] dfltInvCurrDivCd =	(JSPUtil.getParameter(request, prefix +	"dflt_inv_curr_div_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoiceCustomerChangeVO();
						if ( porCd[i] !=	null)
						model.setPorCd( porCd[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( issDt[i] !=	null)
						model.setIssDt( issDt[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( revSrcCd[i] !=	null)
						model.setRevSrcCd( revSrcCd[i]);
						if ( invCustCntCd[i] !=	null)
						model.setInvCustCntCd( invCustCntCd[i]);
						if ( arIfNo[i] !=	null)
						model.setArIfNo( arIfNo[i]);
						if ( actCustCntCd[i] !=	null)
						model.setActCustCntCd( actCustCntCd[i]);
						if ( invCustNm[i] !=	null)
						model.setInvCustNm( invCustNm[i]);
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
						if ( invRefNo[i] !=	null)
						model.setInvRefNo( invRefNo[i]);
						if ( glEffDt[i] !=	null)
						model.setGlEffDt( glEffDt[i]);
						if ( invCustSeq[i] !=	null)
						model.setInvCustSeq( invCustSeq[i]);
						if ( actCustSeq[i] !=	null)
						model.setActCustSeq( actCustSeq[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( revTpCd[i] !=	null)
						model.setRevTpCd( revTpCd[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( dfltInvCurrDivCd[i] !=	null)
						model.setDfltInvCurrDivCd( dfltInvCurrDivCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoiceCustomerChangeVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvoiceCustomerChangeVO[]
	 */
	public InvoiceCustomerChangeVO[]	 getInvoiceCustomerChangeVOs(){
		InvoiceCustomerChangeVO[] vos = (InvoiceCustomerChangeVO[])models.toArray(new	InvoiceCustomerChangeVO[models.size()]);
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
		this.porCd =	this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt =	this.issDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd =	this.revSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd =	this.invCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo =	this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd =	this.actCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustNm =	this.invCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo =	this.blSrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo =	this.invRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt =	this.glEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq =	this.invCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq =	this.actCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd =	this.revTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltInvCurrDivCd =	this.dfltInvCurrDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}