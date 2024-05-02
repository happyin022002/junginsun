/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ReceiptListByDetailCondVO.java
 *@FileTitle : ReceiptListByDetailCondVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.11.13
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.11.13  
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
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class ReceiptListByDetailCondVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ReceiptListByDetailCondVO>  models =	new	ArrayList<ReceiptListByDetailCondVO>();


	/*	Column Info	*/
	private  String	 bankAcctSeq   =  null;
	/*	Column Info	*/
	private  String	 rctDtFm   =  null;
	/*	Column Info	*/
	private  String	 rctOfcCd   =  null;
	/*	Column Info	*/
	private  String	 chqNo   =  null;
	/*	Column Info	*/
	private  String	 rctDpsDtFm   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 rctUsrId   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 rctUnpayStsFlg   =  null;
	/*	Column Info	*/
	private  String	 rctCustSeq   =  null;
	/*	Column Info	*/
	private  String	 otsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 rctDtTo   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 rctTpCd   =  null;
	/*	Column Info	*/
	private  String	 rctDpsDtTo   =  null;
	/*	Column Info	*/
	private  String	 asaNo   =  null;
	/*	Column Info	*/
	private  String	 rctCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 rctStsCd   =  null;
	/*	Column Info	*/
	private  String	 rctNo   =  null;
	/*	Column Info	*/
	private  String	 rctCxlRsnCd   =  null;
	/*	Column Info	*/
	private  String	 iPage   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ReceiptListByDetailCondVO(){}

	public ReceiptListByDetailCondVO(String bankAcctSeq,String rctDtFm,String rctOfcCd,String chqNo,String rctDpsDtFm,String ioBndCd,String blNo,String rctUsrId,String pagerows,String invNo,String bkgNo,String ibflag,String rctUnpayStsFlg,String rctCustSeq,String otsOfcCd,String rctDtTo,String usrId,String rctTpCd,String rctDpsDtTo,String asaNo,String rctCustCntCd,String rctStsCd,String rctNo,String rctCxlRsnCd,String iPage)	{
		this.bankAcctSeq  = bankAcctSeq ;
		this.rctDtFm  = rctDtFm ;
		this.rctOfcCd  = rctOfcCd ;
		this.chqNo  = chqNo ;
		this.rctDpsDtFm  = rctDpsDtFm ;
		this.ioBndCd  = ioBndCd ;
		this.blNo  = blNo ;
		this.rctUsrId  = rctUsrId ;
		this.pagerows  = pagerows ;
		this.invNo  = invNo ;
		this.bkgNo  = bkgNo ;
		this.ibflag  = ibflag ;
		this.rctUnpayStsFlg  = rctUnpayStsFlg ;
		this.rctCustSeq  = rctCustSeq ;
		this.otsOfcCd  = otsOfcCd ;
		this.rctDtTo  = rctDtTo ;
		this.usrId  = usrId ;
		this.rctTpCd  = rctTpCd ;
		this.rctDpsDtTo  = rctDpsDtTo ;
		this.asaNo  = asaNo ;
		this.rctCustCntCd  = rctCustCntCd ;
		this.rctStsCd  = rctStsCd ;
		this.rctNo  = rctNo ;
		this.rctCxlRsnCd  = rctCxlRsnCd ;
		this.iPage  = iPage ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_seq", getBankAcctSeq());		
		this.hashColumns.put("rct_dt_fm", getRctDtFm());		
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());		
		this.hashColumns.put("chq_no", getChqNo());		
		this.hashColumns.put("rct_dps_dt_fm", getRctDpsDtFm());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("rct_usr_id", getRctUsrId());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("rct_unpay_sts_flg", getRctUnpayStsFlg());		
		this.hashColumns.put("rct_cust_seq", getRctCustSeq());		
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());		
		this.hashColumns.put("rct_dt_to", getRctDtTo());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("rct_tp_cd", getRctTpCd());		
		this.hashColumns.put("rct_dps_dt_to", getRctDpsDtTo());		
		this.hashColumns.put("asa_no", getAsaNo());		
		this.hashColumns.put("rct_cust_cnt_cd", getRctCustCntCd());		
		this.hashColumns.put("rct_sts_cd", getRctStsCd());		
		this.hashColumns.put("rct_no", getRctNo());		
		this.hashColumns.put("rct_cxl_rsn_cd", getRctCxlRsnCd());		
		this.hashColumns.put("i_page", getIPage());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("bank_acct_seq", "bankAcctSeq");
		this.hashFields.put("rct_dt_fm", "rctDtFm");
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("chq_no", "chqNo");
		this.hashFields.put("rct_dps_dt_fm", "rctDpsDtFm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("rct_usr_id", "rctUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rct_unpay_sts_flg", "rctUnpayStsFlg");
		this.hashFields.put("rct_cust_seq", "rctCustSeq");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("rct_dt_to", "rctDtTo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("rct_tp_cd", "rctTpCd");
		this.hashFields.put("rct_dps_dt_to", "rctDpsDtTo");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("rct_cust_cnt_cd", "rctCustCntCd");
		this.hashFields.put("rct_sts_cd", "rctStsCd");
		this.hashFields.put("rct_no", "rctNo");
		this.hashFields.put("rct_cxl_rsn_cd", "rctCxlRsnCd");
		this.hashFields.put("i_page", "iPage");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  bankAcctSeq
	*/
	public void	setBankAcctSeq( String	bankAcctSeq ) {
		this.bankAcctSeq =	bankAcctSeq;
	}
 
	/**
	 * Column Info
	 * @return	bankAcctSeq
	 */
	 public	 String	getBankAcctSeq() {
		 return	this.bankAcctSeq;
	 } 
 	/**
	* Column Info
	* @param  rctDtFm
	*/
	public void	setRctDtFm( String	rctDtFm ) {
		this.rctDtFm =	rctDtFm;
	}
 
	/**
	 * Column Info
	 * @return	rctDtFm
	 */
	 public	 String	getRctDtFm() {
		 return	this.rctDtFm;
	 } 
 	/**
	* Column Info
	* @param  rctOfcCd
	*/
	public void	setRctOfcCd( String	rctOfcCd ) {
		this.rctOfcCd =	rctOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	rctOfcCd
	 */
	 public	 String	getRctOfcCd() {
		 return	this.rctOfcCd;
	 } 
 	/**
	* Column Info
	* @param  chqNo
	*/
	public void	setChqNo( String	chqNo ) {
		this.chqNo =	chqNo;
	}
 
	/**
	 * Column Info
	 * @return	chqNo
	 */
	 public	 String	getChqNo() {
		 return	this.chqNo;
	 } 
 	/**
	* Column Info
	* @param  rctDpsDtFm
	*/
	public void	setRctDpsDtFm( String	rctDpsDtFm ) {
		this.rctDpsDtFm =	rctDpsDtFm;
	}
 
	/**
	 * Column Info
	 * @return	rctDpsDtFm
	 */
	 public	 String	getRctDpsDtFm() {
		 return	this.rctDpsDtFm;
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
	* @param  rctUsrId
	*/
	public void	setRctUsrId( String	rctUsrId ) {
		this.rctUsrId =	rctUsrId;
	}
 
	/**
	 * Column Info
	 * @return	rctUsrId
	 */
	 public	 String	getRctUsrId() {
		 return	this.rctUsrId;
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
	* @param  rctUnpayStsFlg
	*/
	public void	setRctUnpayStsFlg( String	rctUnpayStsFlg ) {
		this.rctUnpayStsFlg =	rctUnpayStsFlg;
	}
 
	/**
	 * Column Info
	 * @return	rctUnpayStsFlg
	 */
	 public	 String	getRctUnpayStsFlg() {
		 return	this.rctUnpayStsFlg;
	 } 
 	/**
	* Column Info
	* @param  rctCustSeq
	*/
	public void	setRctCustSeq( String	rctCustSeq ) {
		this.rctCustSeq =	rctCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	rctCustSeq
	 */
	 public	 String	getRctCustSeq() {
		 return	this.rctCustSeq;
	 } 
 	/**
	* Column Info
	* @param  otsOfcCd
	*/
	public void	setOtsOfcCd( String	otsOfcCd ) {
		this.otsOfcCd =	otsOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	otsOfcCd
	 */
	 public	 String	getOtsOfcCd() {
		 return	this.otsOfcCd;
	 } 
 	/**
	* Column Info
	* @param  rctDtTo
	*/
	public void	setRctDtTo( String	rctDtTo ) {
		this.rctDtTo =	rctDtTo;
	}
 
	/**
	 * Column Info
	 * @return	rctDtTo
	 */
	 public	 String	getRctDtTo() {
		 return	this.rctDtTo;
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
	* @param  rctTpCd
	*/
	public void	setRctTpCd( String	rctTpCd ) {
		this.rctTpCd =	rctTpCd;
	}
 
	/**
	 * Column Info
	 * @return	rctTpCd
	 */
	 public	 String	getRctTpCd() {
		 return	this.rctTpCd;
	 } 
 	/**
	* Column Info
	* @param  rctDpsDtTo
	*/
	public void	setRctDpsDtTo( String	rctDpsDtTo ) {
		this.rctDpsDtTo =	rctDpsDtTo;
	}
 
	/**
	 * Column Info
	 * @return	rctDpsDtTo
	 */
	 public	 String	getRctDpsDtTo() {
		 return	this.rctDpsDtTo;
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
	* @param  rctCustCntCd
	*/
	public void	setRctCustCntCd( String	rctCustCntCd ) {
		this.rctCustCntCd =	rctCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	rctCustCntCd
	 */
	 public	 String	getRctCustCntCd() {
		 return	this.rctCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  rctStsCd
	*/
	public void	setRctStsCd( String	rctStsCd ) {
		this.rctStsCd =	rctStsCd;
	}
 
	/**
	 * Column Info
	 * @return	rctStsCd
	 */
	 public	 String	getRctStsCd() {
		 return	this.rctStsCd;
	 } 
 	/**
	* Column Info
	* @param  rctNo
	*/
	public void	setRctNo( String	rctNo ) {
		this.rctNo =	rctNo;
	}
 
	/**
	 * Column Info
	 * @return	rctNo
	 */
	 public	 String	getRctNo() {
		 return	this.rctNo;
	 } 
 	/**
	* Column Info
	* @param  rctCxlRsnCd
	*/
	public void	setRctCxlRsnCd( String	rctCxlRsnCd ) {
		this.rctCxlRsnCd =	rctCxlRsnCd;
	}
 
	/**
	 * Column Info
	 * @return	rctCxlRsnCd
	 */
	 public	 String	getRctCxlRsnCd() {
		 return	this.rctCxlRsnCd;
	 } 
 	/**
	* Column Info
	* @param  iPage
	*/
	public void	setIPage( String	iPage ) {
		this.iPage =	iPage;
	}
 
	/**
	 * Column Info
	 * @return	iPage
	 */
	 public	 String	getIPage() {
		 return	this.iPage;
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
		setBankAcctSeq(JSPUtil.getParameter(request,	prefix + "bank_acct_seq", ""));
		setRctDtFm(JSPUtil.getParameter(request,	prefix + "rct_dt_fm", ""));
		setRctOfcCd(JSPUtil.getParameter(request,	prefix + "rct_ofc_cd", ""));
		setChqNo(JSPUtil.getParameter(request,	prefix + "chq_no", ""));
		setRctDpsDtFm(JSPUtil.getParameter(request,	prefix + "rct_dps_dt_fm", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setRctUsrId(JSPUtil.getParameter(request,	prefix + "rct_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setRctUnpayStsFlg(JSPUtil.getParameter(request,	prefix + "rct_unpay_sts_flg", ""));
		setRctCustSeq(JSPUtil.getParameter(request,	prefix + "rct_cust_seq", ""));
		setOtsOfcCd(JSPUtil.getParameter(request,	prefix + "ots_ofc_cd", ""));
		setRctDtTo(JSPUtil.getParameter(request,	prefix + "rct_dt_to", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setRctTpCd(JSPUtil.getParameter(request,	prefix + "rct_tp_cd", ""));
		setRctDpsDtTo(JSPUtil.getParameter(request,	prefix + "rct_dps_dt_to", ""));
		setAsaNo(JSPUtil.getParameter(request,	prefix + "asa_no", ""));
		setRctCustCntCd(JSPUtil.getParameter(request,	prefix + "rct_cust_cnt_cd", ""));
		setRctStsCd(JSPUtil.getParameter(request,	prefix + "rct_sts_cd", ""));
		setRctNo(JSPUtil.getParameter(request,	prefix + "rct_no", ""));
		setRctCxlRsnCd(JSPUtil.getParameter(request,	prefix + "rct_cxl_rsn_cd", ""));
		setIPage(JSPUtil.getParameter(request,	prefix + "i_page", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceiptListByDetailCondVO[]
	 */
	public ReceiptListByDetailCondVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ReceiptListByDetailCondVO[]
	 */
	public ReceiptListByDetailCondVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ReceiptListByDetailCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] bankAcctSeq =	(JSPUtil.getParameter(request, prefix +	"bank_acct_seq".trim(),	length));
				String[] rctDtFm =	(JSPUtil.getParameter(request, prefix +	"rct_dt_fm".trim(),	length));
				String[] rctOfcCd =	(JSPUtil.getParameter(request, prefix +	"rct_ofc_cd".trim(),	length));
				String[] chqNo =	(JSPUtil.getParameter(request, prefix +	"chq_no".trim(),	length));
				String[] rctDpsDtFm =	(JSPUtil.getParameter(request, prefix +	"rct_dps_dt_fm".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] rctUsrId =	(JSPUtil.getParameter(request, prefix +	"rct_usr_id".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] rctUnpayStsFlg =	(JSPUtil.getParameter(request, prefix +	"rct_unpay_sts_flg".trim(),	length));
				String[] rctCustSeq =	(JSPUtil.getParameter(request, prefix +	"rct_cust_seq".trim(),	length));
				String[] otsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ots_ofc_cd".trim(),	length));
				String[] rctDtTo =	(JSPUtil.getParameter(request, prefix +	"rct_dt_to".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] rctTpCd =	(JSPUtil.getParameter(request, prefix +	"rct_tp_cd".trim(),	length));
				String[] rctDpsDtTo =	(JSPUtil.getParameter(request, prefix +	"rct_dps_dt_to".trim(),	length));
				String[] asaNo =	(JSPUtil.getParameter(request, prefix +	"asa_no".trim(),	length));
				String[] rctCustCntCd =	(JSPUtil.getParameter(request, prefix +	"rct_cust_cnt_cd".trim(),	length));
				String[] rctStsCd =	(JSPUtil.getParameter(request, prefix +	"rct_sts_cd".trim(),	length));
				String[] rctNo =	(JSPUtil.getParameter(request, prefix +	"rct_no".trim(),	length));
				String[] rctCxlRsnCd =	(JSPUtil.getParameter(request, prefix +	"rct_cxl_rsn_cd".trim(),	length));
				String[] iPage =	(JSPUtil.getParameter(request, prefix +	"i_page".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ReceiptListByDetailCondVO();
						if ( bankAcctSeq[i] !=	null)
						model.setBankAcctSeq( bankAcctSeq[i]);
						if ( rctDtFm[i] !=	null)
						model.setRctDtFm( rctDtFm[i]);
						if ( rctOfcCd[i] !=	null)
						model.setRctOfcCd( rctOfcCd[i]);
						if ( chqNo[i] !=	null)
						model.setChqNo( chqNo[i]);
						if ( rctDpsDtFm[i] !=	null)
						model.setRctDpsDtFm( rctDpsDtFm[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( rctUsrId[i] !=	null)
						model.setRctUsrId( rctUsrId[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( rctUnpayStsFlg[i] !=	null)
						model.setRctUnpayStsFlg( rctUnpayStsFlg[i]);
						if ( rctCustSeq[i] !=	null)
						model.setRctCustSeq( rctCustSeq[i]);
						if ( otsOfcCd[i] !=	null)
						model.setOtsOfcCd( otsOfcCd[i]);
						if ( rctDtTo[i] !=	null)
						model.setRctDtTo( rctDtTo[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( rctTpCd[i] !=	null)
						model.setRctTpCd( rctTpCd[i]);
						if ( rctDpsDtTo[i] !=	null)
						model.setRctDpsDtTo( rctDpsDtTo[i]);
						if ( asaNo[i] !=	null)
						model.setAsaNo( asaNo[i]);
						if ( rctCustCntCd[i] !=	null)
						model.setRctCustCntCd( rctCustCntCd[i]);
						if ( rctStsCd[i] !=	null)
						model.setRctStsCd( rctStsCd[i]);
						if ( rctNo[i] !=	null)
						model.setRctNo( rctNo[i]);
						if ( rctCxlRsnCd[i] !=	null)
						model.setRctCxlRsnCd( rctCxlRsnCd[i]);
						if ( iPage[i] !=	null)
						model.setIPage( iPage[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getReceiptListByDetailCondVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ReceiptListByDetailCondVO[]
	 */
	public ReceiptListByDetailCondVO[]	 getReceiptListByDetailCondVOs(){
		ReceiptListByDetailCondVO[] vos = (ReceiptListByDetailCondVO[])models.toArray(new	ReceiptListByDetailCondVO[models.size()]);
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
		this.bankAcctSeq =	this.bankAcctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDtFm =	this.rctDtFm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcCd =	this.rctOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chqNo =	this.chqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDpsDtFm =	this.rctDpsDtFm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctUsrId =	this.rctUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctUnpayStsFlg =	this.rctUnpayStsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustSeq =	this.rctCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd =	this.otsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDtTo =	this.rctDtTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctTpCd =	this.rctTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDpsDtTo =	this.rctDpsDtTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo =	this.asaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustCntCd =	this.rctCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctStsCd =	this.rctStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctNo =	this.rctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCxlRsnCd =	this.rctCxlRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage =	this.iPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}