/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CustomerInfoVO.java
 *@FileTitle : CustomerInfoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.02.26
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.02.26  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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
public class CustomerInfoVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CustomerInfoVO>  models =	new	ArrayList<CustomerInfoVO>();


	/*	Column Info	*/
	private  String	 custLoclLangNm   =  null;
	/*	Column Info	*/
	private  String	 phnNo   =  null;
	/*	Column Info	*/
	private  String	 ibcsTp   =  null;
	/*	Column Info	*/
	private  String	 addr   =  null;
	/*	Column Info	*/
	private  String	 custRgstNo   =  null;
	/*	Column Info	*/
	private  String	 custEml   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 custLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 loclAddr3   =  null;
	/*	Column Info	*/
	private  String	 zipCd   =  null;
	/*	Column Info	*/
	private  String	 loclAddr2   =  null;
	/*	Column Info	*/
	private  String	 cntcPsonNm   =  null;
	/*	Column Info	*/
	private  String	 loclAddr1   =  null;
	/*	Column Info	*/
	private  String	 faxNo   =  null;
	/*	Column Info	*/
	private  String	 ctyNm   =  null;
	/*	Column Info	*/
	private  String	 steCd   =  null;
	/*	Column Info	*/
	private  String	 custCntCd   =  null;
	/*	Column Info	*/
	private  String	 custSeq   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public CustomerInfoVO(){}

	public CustomerInfoVO(String custLoclLangNm,String phnNo,String ibcsTp,String addr,String custRgstNo,String custEml,String pagerows,String custLglEngNm,String ibflag,String loclAddr3,String zipCd,String loclAddr2,String cntcPsonNm,String loclAddr1,String faxNo,String ctyNm,String steCd,String custCntCd,String custSeq)	{
		this.custLoclLangNm  = custLoclLangNm ;
		this.phnNo  = phnNo ;
		this.ibcsTp  = ibcsTp ;
		this.addr  = addr ;
		this.custRgstNo  = custRgstNo ;
		this.custEml  = custEml ;
		this.pagerows  = pagerows ;
		this.custLglEngNm  = custLglEngNm ;
		this.ibflag  = ibflag ;
		this.loclAddr3  = loclAddr3 ;
		this.zipCd  = zipCd ;
		this.loclAddr2  = loclAddr2 ;
		this.cntcPsonNm  = cntcPsonNm ;
		this.loclAddr1  = loclAddr1 ;
		this.faxNo  = faxNo ;
		this.ctyNm  = ctyNm ;
		this.steCd  = steCd ;
		this.custCntCd  = custCntCd ;
		this.custSeq  = custSeq ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_locl_lang_nm", getCustLoclLangNm());		
		this.hashColumns.put("phn_no", getPhnNo());		
		this.hashColumns.put("ibcs_tp", getIbcsTp());		
		this.hashColumns.put("addr", getAddr());		
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());		
		this.hashColumns.put("cust_eml", getCustEml());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("locl_addr3", getLoclAddr3());		
		this.hashColumns.put("zip_cd", getZipCd());		
		this.hashColumns.put("locl_addr2", getLoclAddr2());		
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());		
		this.hashColumns.put("locl_addr1", getLoclAddr1());		
		this.hashColumns.put("fax_no", getFaxNo());		
		this.hashColumns.put("cty_nm", getCtyNm());		
		this.hashColumns.put("ste_cd", getSteCd());		
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());		
		this.hashColumns.put("cust_seq", getCustSeq());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("cust_locl_lang_nm", "custLoclLangNm");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("ibcs_tp", "ibcsTp");
		this.hashFields.put("addr", "addr");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("locl_addr3", "loclAddr3");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("locl_addr2", "loclAddr2");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("locl_addr1", "loclAddr1");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  custLoclLangNm
	*/
	public void	setCustLoclLangNm( String	custLoclLangNm ) {
		this.custLoclLangNm =	custLoclLangNm;
	}
 
	/**
	 * Column Info
	 * @return	custLoclLangNm
	 */
	 public	 String	getCustLoclLangNm() {
		 return	this.custLoclLangNm;
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
	* @param  ibcsTp
	*/
	public void	setIbcsTp( String	ibcsTp ) {
		this.ibcsTp =	ibcsTp;
	}
 
	/**
	 * Column Info
	 * @return	ibcsTp
	 */
	 public	 String	getIbcsTp() {
		 return	this.ibcsTp;
	 } 
 	/**
	* Column Info
	* @param  addr
	*/
	public void	setAddr( String	addr ) {
		this.addr =	addr;
	}
 
	/**
	 * Column Info
	 * @return	addr
	 */
	 public	 String	getAddr() {
		 return	this.addr;
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
	* @param  custLglEngNm
	*/
	public void	setCustLglEngNm( String	custLglEngNm ) {
		this.custLglEngNm =	custLglEngNm;
	}
 
	/**
	 * Column Info
	 * @return	custLglEngNm
	 */
	 public	 String	getCustLglEngNm() {
		 return	this.custLglEngNm;
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
	* @param  loclAddr3
	*/
	public void	setLoclAddr3( String	loclAddr3 ) {
		this.loclAddr3 =	loclAddr3;
	}
 
	/**
	 * Column Info
	 * @return	loclAddr3
	 */
	 public	 String	getLoclAddr3() {
		 return	this.loclAddr3;
	 } 
 	/**
	* Column Info
	* @param  zipCd
	*/
	public void	setZipCd( String	zipCd ) {
		this.zipCd =	zipCd;
	}
 
	/**
	 * Column Info
	 * @return	zipCd
	 */
	 public	 String	getZipCd() {
		 return	this.zipCd;
	 } 
 	/**
	* Column Info
	* @param  loclAddr2
	*/
	public void	setLoclAddr2( String	loclAddr2 ) {
		this.loclAddr2 =	loclAddr2;
	}
 
	/**
	 * Column Info
	 * @return	loclAddr2
	 */
	 public	 String	getLoclAddr2() {
		 return	this.loclAddr2;
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
	* @param  loclAddr1
	*/
	public void	setLoclAddr1( String	loclAddr1 ) {
		this.loclAddr1 =	loclAddr1;
	}
 
	/**
	 * Column Info
	 * @return	loclAddr1
	 */
	 public	 String	getLoclAddr1() {
		 return	this.loclAddr1;
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
	* @param  ctyNm
	*/
	public void	setCtyNm( String	ctyNm ) {
		this.ctyNm =	ctyNm;
	}
 
	/**
	 * Column Info
	 * @return	ctyNm
	 */
	 public	 String	getCtyNm() {
		 return	this.ctyNm;
	 } 
 	/**
	* Column Info
	* @param  steCd
	*/
	public void	setSteCd( String	steCd ) {
		this.steCd =	steCd;
	}
 
	/**
	 * Column Info
	 * @return	steCd
	 */
	 public	 String	getSteCd() {
		 return	this.steCd;
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
		setCustLoclLangNm(JSPUtil.getParameter(request,	prefix + "cust_locl_lang_nm", ""));
		setPhnNo(JSPUtil.getParameter(request,	prefix + "phn_no", ""));
		setIbcsTp(JSPUtil.getParameter(request,	prefix + "ibcs_tp", ""));
		setAddr(JSPUtil.getParameter(request,	prefix + "addr", ""));
		setCustRgstNo(JSPUtil.getParameter(request,	prefix + "cust_rgst_no", ""));
		setCustEml(JSPUtil.getParameter(request,	prefix + "cust_eml", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCustLglEngNm(JSPUtil.getParameter(request,	prefix + "cust_lgl_eng_nm", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setLoclAddr3(JSPUtil.getParameter(request,	prefix + "locl_addr3", ""));
		setZipCd(JSPUtil.getParameter(request,	prefix + "zip_cd", ""));
		setLoclAddr2(JSPUtil.getParameter(request,	prefix + "locl_addr2", ""));
		setCntcPsonNm(JSPUtil.getParameter(request,	prefix + "cntc_pson_nm", ""));
		setLoclAddr1(JSPUtil.getParameter(request,	prefix + "locl_addr1", ""));
		setFaxNo(JSPUtil.getParameter(request,	prefix + "fax_no", ""));
		setCtyNm(JSPUtil.getParameter(request,	prefix + "cty_nm", ""));
		setSteCd(JSPUtil.getParameter(request,	prefix + "ste_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomerInfoVO[]
	 */
	public CustomerInfoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CustomerInfoVO[]
	 */
	public CustomerInfoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CustomerInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] custLoclLangNm =	(JSPUtil.getParameter(request, prefix +	"cust_locl_lang_nm".trim(),	length));
				String[] phnNo =	(JSPUtil.getParameter(request, prefix +	"phn_no".trim(),	length));
				String[] ibcsTp =	(JSPUtil.getParameter(request, prefix +	"ibcs_tp".trim(),	length));
				String[] addr =	(JSPUtil.getParameter(request, prefix +	"addr".trim(),	length));
				String[] custRgstNo =	(JSPUtil.getParameter(request, prefix +	"cust_rgst_no".trim(),	length));
				String[] custEml =	(JSPUtil.getParameter(request, prefix +	"cust_eml".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] custLglEngNm =	(JSPUtil.getParameter(request, prefix +	"cust_lgl_eng_nm".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] loclAddr3 =	(JSPUtil.getParameter(request, prefix +	"locl_addr3".trim(),	length));
				String[] zipCd =	(JSPUtil.getParameter(request, prefix +	"zip_cd".trim(),	length));
				String[] loclAddr2 =	(JSPUtil.getParameter(request, prefix +	"locl_addr2".trim(),	length));
				String[] cntcPsonNm =	(JSPUtil.getParameter(request, prefix +	"cntc_pson_nm".trim(),	length));
				String[] loclAddr1 =	(JSPUtil.getParameter(request, prefix +	"locl_addr1".trim(),	length));
				String[] faxNo =	(JSPUtil.getParameter(request, prefix +	"fax_no".trim(),	length));
				String[] ctyNm =	(JSPUtil.getParameter(request, prefix +	"cty_nm".trim(),	length));
				String[] steCd =	(JSPUtil.getParameter(request, prefix +	"ste_cd".trim(),	length));
				String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd".trim(),	length));
				String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	CustomerInfoVO();
						if ( custLoclLangNm[i] !=	null)
						model.setCustLoclLangNm( custLoclLangNm[i]);
						if ( phnNo[i] !=	null)
						model.setPhnNo( phnNo[i]);
						if ( ibcsTp[i] !=	null)
						model.setIbcsTp( ibcsTp[i]);
						if ( addr[i] !=	null)
						model.setAddr( addr[i]);
						if ( custRgstNo[i] !=	null)
						model.setCustRgstNo( custRgstNo[i]);
						if ( custEml[i] !=	null)
						model.setCustEml( custEml[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( custLglEngNm[i] !=	null)
						model.setCustLglEngNm( custLglEngNm[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( loclAddr3[i] !=	null)
						model.setLoclAddr3( loclAddr3[i]);
						if ( zipCd[i] !=	null)
						model.setZipCd( zipCd[i]);
						if ( loclAddr2[i] !=	null)
						model.setLoclAddr2( loclAddr2[i]);
						if ( cntcPsonNm[i] !=	null)
						model.setCntcPsonNm( cntcPsonNm[i]);
						if ( loclAddr1[i] !=	null)
						model.setLoclAddr1( loclAddr1[i]);
						if ( faxNo[i] !=	null)
						model.setFaxNo( faxNo[i]);
						if ( ctyNm[i] !=	null)
						model.setCtyNm( ctyNm[i]);
						if ( steCd[i] !=	null)
						model.setSteCd( steCd[i]);
						if ( custCntCd[i] !=	null)
						model.setCustCntCd( custCntCd[i]);
						if ( custSeq[i] !=	null)
						model.setCustSeq( custSeq[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getCustomerInfoVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return CustomerInfoVO[]
	 */
	public CustomerInfoVO[]	 getCustomerInfoVOs(){
		CustomerInfoVO[] vos = (CustomerInfoVO[])models.toArray(new	CustomerInfoVO[models.size()]);
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
		this.custLoclLangNm =	this.custLoclLangNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo =	this.phnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcsTp =	this.ibcsTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addr =	this.addr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo =	this.custRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml =	this.custEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm =	this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr3 =	this.loclAddr3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd =	this.zipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr2 =	this.loclAddr2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm =	this.cntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr1 =	this.loclAddr1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo =	this.faxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm =	this.ctyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd =	this.steCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}