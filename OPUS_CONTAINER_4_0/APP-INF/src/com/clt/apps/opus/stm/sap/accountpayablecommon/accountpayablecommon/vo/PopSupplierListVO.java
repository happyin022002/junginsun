/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PopSupplierListVO.java
 *@FileTitle : PopSupplierListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.03.02
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.03.02  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo;

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
public class PopSupplierListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PopSupplierListVO>  models =	new	ArrayList<PopSupplierListVO>();


	/*	Column Info	*/
	private  String	 vndrCntCd   =  null;
	/*	Column Info	*/
	private  String	 payCurrCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 taxId   =  null;
	/*	Column Info	*/
	private  String	 genPayTermCd   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 rgstNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 payMzdCd   =  null;
	/*	Column Info	*/
	private  String	 sapPayMzdCd   =  null;
	/*	Column Info	*/
	private  String	 bankAcctFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public PopSupplierListVO(){}

	public PopSupplierListVO(String vndrCntCd,String payCurrCd,String ibflag,String taxId,String genPayTermCd,String vndrSeq,String vndrLglEngNm,String invCurrCd,String rgstNo,String pagerows,String payMzdCd,String sapPayMzdCd,String bankAcctFlg)	{
		this.vndrCntCd  = vndrCntCd ;
		this.payCurrCd  = payCurrCd ;
		this.ibflag  = ibflag ;
		this.taxId  = taxId ;
		this.genPayTermCd  = genPayTermCd ;
		this.vndrSeq  = vndrSeq ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.invCurrCd  = invCurrCd ;
		this.rgstNo  = rgstNo ;
		this.pagerows  = pagerows ;
		this.payMzdCd  = payMzdCd ;
		this.sapPayMzdCd  = sapPayMzdCd ;
		this.bankAcctFlg  = bankAcctFlg ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());		
		this.hashColumns.put("pay_curr_cd", getPayCurrCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("tax_id", getTaxId());		
		this.hashColumns.put("gen_pay_term_cd", getGenPayTermCd());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("rgst_no", getRgstNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("pay_mzd_cd", getPayMzdCd());		
		this.hashColumns.put("sap_pay_mzd_cd", getSapPayMzdCd());		
		this.hashColumns.put("bank_acct_flg", getBankAcctFlg());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("pay_curr_cd", "payCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tax_id", "taxId");
		this.hashFields.put("gen_pay_term_cd", "genPayTermCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("rgst_no", "rgstNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pay_mzd_cd", "payMzdCd");
		this.hashFields.put("sap_pay_mzd_cd", "sapPayMzdCd");
		this.hashFields.put("bank_acct_flg", "bankAcctFlg");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  vndrCntCd
	*/
	public void	setVndrCntCd( String	vndrCntCd ) {
		this.vndrCntCd =	vndrCntCd;
	}
 
	/**
	 * Column Info
	 * @return	vndrCntCd
	 */
	 public	String	getVndrCntCd() {
		 return	this.vndrCntCd;
	 } 
 	/**
	* Column Info
	* @param  payCurrCd
	*/
	public void	setPayCurrCd( String	payCurrCd ) {
		this.payCurrCd =	payCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	payCurrCd
	 */
	 public	String	getPayCurrCd() {
		 return	this.payCurrCd;
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
	* @param  taxId
	*/
	public void	setTaxId( String	taxId ) {
		this.taxId =	taxId;
	}
 
	/**
	 * Column Info
	 * @return	taxId
	 */
	 public	String	getTaxId() {
		 return	this.taxId;
	 } 
 	/**
	* Column Info
	* @param  genPayTermCd
	*/
	public void	setGenPayTermCd( String	genPayTermCd ) {
		this.genPayTermCd =	genPayTermCd;
	}
 
	/**
	 * Column Info
	 * @return	genPayTermCd
	 */
	 public	String	getGenPayTermCd() {
		 return	this.genPayTermCd;
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
	 public	String	getVndrSeq() {
		 return	this.vndrSeq;
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
	* @param  rgstNo
	*/
	public void	setRgstNo( String	rgstNo ) {
		this.rgstNo =	rgstNo;
	}
 
	/**
	 * Column Info
	 * @return	rgstNo
	 */
	 public	String	getRgstNo() {
		 return	this.rgstNo;
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
	* @param  payMzdCd
	*/
	public void	setPayMzdCd( String	payMzdCd ) {
		this.payMzdCd =	payMzdCd;
	}
 
	/**
	 * Column Info
	 * @return	payMzdCd
	 */
	 public	String	getPayMzdCd() {
		 return	this.payMzdCd;
	 } 
 	/**
	* Column Info
	* @param  sapPayMzdCd
	*/
	public void	setSapPayMzdCd( String	sapPayMzdCd ) {
		this.sapPayMzdCd =	sapPayMzdCd;
	}
 
	/**
	 * Column Info
	 * @return	sapPayMzdCd
	 */
	 public	String	getSapPayMzdCd() {
		 return	this.sapPayMzdCd;
	 } 
 	/**
	* Column Info
	* @param  bankAcctFlg
	*/
	public void	setBankAcctFlg( String	bankAcctFlg ) {
		this.bankAcctFlg =	bankAcctFlg;
	}
 
	/**
	 * Column Info
	 * @return	bankAcctFlg
	 */
	 public	String	getBankAcctFlg() {
		 return	this.bankAcctFlg;
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
		setVndrCntCd(JSPUtil.getParameter(request,	prefix + "vndr_cnt_cd", ""));
		setPayCurrCd(JSPUtil.getParameter(request,	prefix + "pay_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setTaxId(JSPUtil.getParameter(request,	prefix + "tax_id", ""));
		setGenPayTermCd(JSPUtil.getParameter(request,	prefix + "gen_pay_term_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setRgstNo(JSPUtil.getParameter(request,	prefix + "rgst_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPayMzdCd(JSPUtil.getParameter(request,	prefix + "pay_mzd_cd", ""));
		setSapPayMzdCd(JSPUtil.getParameter(request,	prefix + "sap_pay_mzd_cd", ""));
		setBankAcctFlg(JSPUtil.getParameter(request,	prefix + "bank_acct_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PopSupplierListVO[]
	 */
	public PopSupplierListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PopSupplierListVO[]
	 */
	public PopSupplierListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PopSupplierListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] vndrCntCd =	(JSPUtil.getParameter(request, prefix +	"vndr_cnt_cd".trim(),	length));
				String[] payCurrCd =	(JSPUtil.getParameter(request, prefix +	"pay_curr_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] taxId =	(JSPUtil.getParameter(request, prefix +	"tax_id".trim(),	length));
				String[] genPayTermCd =	(JSPUtil.getParameter(request, prefix +	"gen_pay_term_cd".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] rgstNo =	(JSPUtil.getParameter(request, prefix +	"rgst_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] payMzdCd =	(JSPUtil.getParameter(request, prefix +	"pay_mzd_cd".trim(),	length));
				String[] sapPayMzdCd =	(JSPUtil.getParameter(request, prefix +	"sap_pay_mzd_cd".trim(),	length));
				String[] bankAcctFlg =	(JSPUtil.getParameter(request, prefix +	"bank_acct_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	PopSupplierListVO();
						if ( vndrCntCd[i] !=	null)
						model.setVndrCntCd( vndrCntCd[i]);
						if ( payCurrCd[i] !=	null)
						model.setPayCurrCd( payCurrCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( taxId[i] !=	null)
						model.setTaxId( taxId[i]);
						if ( genPayTermCd[i] !=	null)
						model.setGenPayTermCd( genPayTermCd[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( rgstNo[i] !=	null)
						model.setRgstNo( rgstNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( payMzdCd[i] !=	null)
						model.setPayMzdCd( payMzdCd[i]);
						if ( sapPayMzdCd[i] !=	null)
						model.setSapPayMzdCd( sapPayMzdCd[i]);
						if ( bankAcctFlg[i] !=	null)
						model.setBankAcctFlg( bankAcctFlg[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getPopSupplierListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PopSupplierListVO[]
	 */
	public PopSupplierListVO[]	 getPopSupplierListVOs(){
		PopSupplierListVO[] vos = (PopSupplierListVO[])models.toArray(new	PopSupplierListVO[models.size()]);
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
		this.vndrCntCd =	this.vndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCurrCd =	this.payCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxId =	this.taxId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genPayTermCd =	this.genPayTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstNo =	this.rgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdCd =	this.payMzdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sapPayMzdCd =	this.sapPayMzdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctFlg =	this.bankAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}