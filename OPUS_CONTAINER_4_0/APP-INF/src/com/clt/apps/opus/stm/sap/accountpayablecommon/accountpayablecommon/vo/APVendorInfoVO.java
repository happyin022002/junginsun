/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : APVendorInfoVO.java
 *@FileTitle : APVendorInfoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.06.18
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.06.18  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo;

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
public class APVendorInfoVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<APVendorInfoVO>  models =	new	ArrayList<APVendorInfoVO>();


	/*	Column Info	*/
	private  String	 lIntercompanyCode   =  null;
	/*	Column Info	*/
	private  String	 pCenterCode   =  null;
	/*	Column Info	*/
	private  String	 pAccountCode   =  null;
	/*	Column Info	*/
	private  String	 payCdCmbSeq   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 vndrNm   =  null;
	/*	Column Info	*/
	private  String	 lCompanyCode   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 pVvdCode   =  null;
	/*	Column Info	*/
	private  String	 lCenterCode   =  null;
	/*	Column Info	*/
	private  String	 liabCdCmbSeq   =  null;
	/*	Column Info	*/
	private  String	 lRegionCode   =  null;
	/*	Column Info	*/
	private  String	 lVvdCode   =  null;
	/*	Column Info	*/
	private  String	 pRegionCode   =  null;
	/*	Column Info	*/
	private  String	 pIntercompanyCode   =  null;
	/*	Column Info	*/
	private  String	 pCompanyCode   =  null;
	/*	Column Info	*/
	private  String	 lAccountCode   =  null;
	/*	Column Info	*/
	private  String	 payPrioCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public APVendorInfoVO(){}

	public APVendorInfoVO(String lIntercompanyCode,String pCenterCode,String pAccountCode,String payCdCmbSeq,String pagerows,String vndrNm,String lCompanyCode,String ibflag,String vndrNo,String usrId,String pVvdCode,String lCenterCode,String liabCdCmbSeq,String lRegionCode,String lVvdCode,String pRegionCode,String pIntercompanyCode,String pCompanyCode,String lAccountCode,String payPrioCd)	{
		this.lIntercompanyCode  = lIntercompanyCode ;
		this.pCenterCode  = pCenterCode ;
		this.pAccountCode  = pAccountCode ;
		this.payCdCmbSeq  = payCdCmbSeq ;
		this.pagerows  = pagerows ;
		this.vndrNm  = vndrNm ;
		this.lCompanyCode  = lCompanyCode ;
		this.ibflag  = ibflag ;
		this.vndrNo  = vndrNo ;
		this.usrId  = usrId ;
		this.pVvdCode  = pVvdCode ;
		this.lCenterCode  = lCenterCode ;
		this.liabCdCmbSeq  = liabCdCmbSeq ;
		this.lRegionCode  = lRegionCode ;
		this.lVvdCode  = lVvdCode ;
		this.pRegionCode  = pRegionCode ;
		this.pIntercompanyCode  = pIntercompanyCode ;
		this.pCompanyCode  = pCompanyCode ;
		this.lAccountCode  = lAccountCode ;
		this.payPrioCd  = payPrioCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("l_intercompany_code", getLIntercompanyCode());		
		this.hashColumns.put("p_center_code", getPCenterCode());		
		this.hashColumns.put("p_account_code", getPAccountCode());		
		this.hashColumns.put("pay_cd_cmb_seq", getPayCdCmbSeq());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("vndr_nm", getVndrNm());		
		this.hashColumns.put("l_company_code", getLCompanyCode());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("p_vvd_code", getPVvdCode());		
		this.hashColumns.put("l_center_code", getLCenterCode());		
		this.hashColumns.put("liab_cd_cmb_seq", getLiabCdCmbSeq());		
		this.hashColumns.put("l_region_code", getLRegionCode());		
		this.hashColumns.put("l_vvd_code", getLVvdCode());		
		this.hashColumns.put("p_region_code", getPRegionCode());		
		this.hashColumns.put("p_intercompany_code", getPIntercompanyCode());		
		this.hashColumns.put("p_company_code", getPCompanyCode());		
		this.hashColumns.put("l_account_code", getLAccountCode());		
		this.hashColumns.put("pay_prio_cd", getPayPrioCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("l_intercompany_code", "lIntercompanyCode");
		this.hashFields.put("p_center_code", "pCenterCode");
		this.hashFields.put("p_account_code", "pAccountCode");
		this.hashFields.put("pay_cd_cmb_seq", "payCdCmbSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("l_company_code", "lCompanyCode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("p_vvd_code", "pVvdCode");
		this.hashFields.put("l_center_code", "lCenterCode");
		this.hashFields.put("liab_cd_cmb_seq", "liabCdCmbSeq");
		this.hashFields.put("l_region_code", "lRegionCode");
		this.hashFields.put("l_vvd_code", "lVvdCode");
		this.hashFields.put("p_region_code", "pRegionCode");
		this.hashFields.put("p_intercompany_code", "pIntercompanyCode");
		this.hashFields.put("p_company_code", "pCompanyCode");
		this.hashFields.put("l_account_code", "lAccountCode");
		this.hashFields.put("pay_prio_cd", "payPrioCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  lIntercompanyCode
	*/
	public void	setLIntercompanyCode( String	lIntercompanyCode ) {
		this.lIntercompanyCode =	lIntercompanyCode;
	}
 
	/**
	 * Column Info
	 * @return	lIntercompanyCode
	 */
	 public	 String	getLIntercompanyCode() {
		 return	this.lIntercompanyCode;
	 } 
 	/**
	* Column Info
	* @param  pCenterCode
	*/
	public void	setPCenterCode( String	pCenterCode ) {
		this.pCenterCode =	pCenterCode;
	}
 
	/**
	 * Column Info
	 * @return	pCenterCode
	 */
	 public	 String	getPCenterCode() {
		 return	this.pCenterCode;
	 } 
 	/**
	* Column Info
	* @param  pAccountCode
	*/
	public void	setPAccountCode( String	pAccountCode ) {
		this.pAccountCode =	pAccountCode;
	}
 
	/**
	 * Column Info
	 * @return	pAccountCode
	 */
	 public	 String	getPAccountCode() {
		 return	this.pAccountCode;
	 } 
 	/**
	* Column Info
	* @param  payCdCmbSeq
	*/
	public void	setPayCdCmbSeq( String	payCdCmbSeq ) {
		this.payCdCmbSeq =	payCdCmbSeq;
	}
 
	/**
	 * Column Info
	 * @return	payCdCmbSeq
	 */
	 public	 String	getPayCdCmbSeq() {
		 return	this.payCdCmbSeq;
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
	* @param  vndrNm
	*/
	public void	setVndrNm( String	vndrNm ) {
		this.vndrNm =	vndrNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrNm
	 */
	 public	 String	getVndrNm() {
		 return	this.vndrNm;
	 } 
 	/**
	* Column Info
	* @param  lCompanyCode
	*/
	public void	setLCompanyCode( String	lCompanyCode ) {
		this.lCompanyCode =	lCompanyCode;
	}
 
	/**
	 * Column Info
	 * @return	lCompanyCode
	 */
	 public	 String	getLCompanyCode() {
		 return	this.lCompanyCode;
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
	* @param  pVvdCode
	*/
	public void	setPVvdCode( String	pVvdCode ) {
		this.pVvdCode =	pVvdCode;
	}
 
	/**
	 * Column Info
	 * @return	pVvdCode
	 */
	 public	 String	getPVvdCode() {
		 return	this.pVvdCode;
	 } 
 	/**
	* Column Info
	* @param  lCenterCode
	*/
	public void	setLCenterCode( String	lCenterCode ) {
		this.lCenterCode =	lCenterCode;
	}
 
	/**
	 * Column Info
	 * @return	lCenterCode
	 */
	 public	 String	getLCenterCode() {
		 return	this.lCenterCode;
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
	* @param  lRegionCode
	*/
	public void	setLRegionCode( String	lRegionCode ) {
		this.lRegionCode =	lRegionCode;
	}
 
	/**
	 * Column Info
	 * @return	lRegionCode
	 */
	 public	 String	getLRegionCode() {
		 return	this.lRegionCode;
	 } 
 	/**
	* Column Info
	* @param  lVvdCode
	*/
	public void	setLVvdCode( String	lVvdCode ) {
		this.lVvdCode =	lVvdCode;
	}
 
	/**
	 * Column Info
	 * @return	lVvdCode
	 */
	 public	 String	getLVvdCode() {
		 return	this.lVvdCode;
	 } 
 	/**
	* Column Info
	* @param  pRegionCode
	*/
	public void	setPRegionCode( String	pRegionCode ) {
		this.pRegionCode =	pRegionCode;
	}
 
	/**
	 * Column Info
	 * @return	pRegionCode
	 */
	 public	 String	getPRegionCode() {
		 return	this.pRegionCode;
	 } 
 	/**
	* Column Info
	* @param  pIntercompanyCode
	*/
	public void	setPIntercompanyCode( String	pIntercompanyCode ) {
		this.pIntercompanyCode =	pIntercompanyCode;
	}
 
	/**
	 * Column Info
	 * @return	pIntercompanyCode
	 */
	 public	 String	getPIntercompanyCode() {
		 return	this.pIntercompanyCode;
	 } 
 	/**
	* Column Info
	* @param  pCompanyCode
	*/
	public void	setPCompanyCode( String	pCompanyCode ) {
		this.pCompanyCode =	pCompanyCode;
	}
 
	/**
	 * Column Info
	 * @return	pCompanyCode
	 */
	 public	 String	getPCompanyCode() {
		 return	this.pCompanyCode;
	 } 
 	/**
	* Column Info
	* @param  lAccountCode
	*/
	public void	setLAccountCode( String	lAccountCode ) {
		this.lAccountCode =	lAccountCode;
	}
 
	/**
	 * Column Info
	 * @return	lAccountCode
	 */
	 public	 String	getLAccountCode() {
		 return	this.lAccountCode;
	 } 
 	/**
	* Column Info
	* @param  payPrioCd
	*/
	public void	setPayPrioCd( String	payPrioCd ) {
		this.payPrioCd =	payPrioCd;
	}
 
	/**
	 * Column Info
	 * @return	payPrioCd
	 */
	 public	 String	getPayPrioCd() {
		 return	this.payPrioCd;
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
		setLIntercompanyCode(JSPUtil.getParameter(request,	prefix + "l_intercompany_code", ""));
		setPCenterCode(JSPUtil.getParameter(request,	prefix + "p_center_code", ""));
		setPAccountCode(JSPUtil.getParameter(request,	prefix + "p_account_code", ""));
		setPayCdCmbSeq(JSPUtil.getParameter(request,	prefix + "pay_cd_cmb_seq", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request,	prefix + "vndr_nm", ""));
		setLCompanyCode(JSPUtil.getParameter(request,	prefix + "l_company_code", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setPVvdCode(JSPUtil.getParameter(request,	prefix + "p_vvd_code", ""));
		setLCenterCode(JSPUtil.getParameter(request,	prefix + "l_center_code", ""));
		setLiabCdCmbSeq(JSPUtil.getParameter(request,	prefix + "liab_cd_cmb_seq", ""));
		setLRegionCode(JSPUtil.getParameter(request,	prefix + "l_region_code", ""));
		setLVvdCode(JSPUtil.getParameter(request,	prefix + "l_vvd_code", ""));
		setPRegionCode(JSPUtil.getParameter(request,	prefix + "p_region_code", ""));
		setPIntercompanyCode(JSPUtil.getParameter(request,	prefix + "p_intercompany_code", ""));
		setPCompanyCode(JSPUtil.getParameter(request,	prefix + "p_company_code", ""));
		setLAccountCode(JSPUtil.getParameter(request,	prefix + "l_account_code", ""));
		setPayPrioCd(JSPUtil.getParameter(request,	prefix + "pay_prio_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APVendorInfoVO[]
	 */
	public APVendorInfoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return APVendorInfoVO[]
	 */
	public APVendorInfoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		APVendorInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] lIntercompanyCode =	(JSPUtil.getParameter(request, prefix +	"l_intercompany_code".trim(),	length));
				String[] pCenterCode =	(JSPUtil.getParameter(request, prefix +	"p_center_code".trim(),	length));
				String[] pAccountCode =	(JSPUtil.getParameter(request, prefix +	"p_account_code".trim(),	length));
				String[] payCdCmbSeq =	(JSPUtil.getParameter(request, prefix +	"pay_cd_cmb_seq".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] vndrNm =	(JSPUtil.getParameter(request, prefix +	"vndr_nm".trim(),	length));
				String[] lCompanyCode =	(JSPUtil.getParameter(request, prefix +	"l_company_code".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] pVvdCode =	(JSPUtil.getParameter(request, prefix +	"p_vvd_code".trim(),	length));
				String[] lCenterCode =	(JSPUtil.getParameter(request, prefix +	"l_center_code".trim(),	length));
				String[] liabCdCmbSeq =	(JSPUtil.getParameter(request, prefix +	"liab_cd_cmb_seq".trim(),	length));
				String[] lRegionCode =	(JSPUtil.getParameter(request, prefix +	"l_region_code".trim(),	length));
				String[] lVvdCode =	(JSPUtil.getParameter(request, prefix +	"l_vvd_code".trim(),	length));
				String[] pRegionCode =	(JSPUtil.getParameter(request, prefix +	"p_region_code".trim(),	length));
				String[] pIntercompanyCode =	(JSPUtil.getParameter(request, prefix +	"p_intercompany_code".trim(),	length));
				String[] pCompanyCode =	(JSPUtil.getParameter(request, prefix +	"p_company_code".trim(),	length));
				String[] lAccountCode =	(JSPUtil.getParameter(request, prefix +	"l_account_code".trim(),	length));
				String[] payPrioCd =	(JSPUtil.getParameter(request, prefix +	"pay_prio_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	APVendorInfoVO();
						if ( lIntercompanyCode[i] !=	null)
						model.setLIntercompanyCode( lIntercompanyCode[i]);
						if ( pCenterCode[i] !=	null)
						model.setPCenterCode( pCenterCode[i]);
						if ( pAccountCode[i] !=	null)
						model.setPAccountCode( pAccountCode[i]);
						if ( payCdCmbSeq[i] !=	null)
						model.setPayCdCmbSeq( payCdCmbSeq[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( vndrNm[i] !=	null)
						model.setVndrNm( vndrNm[i]);
						if ( lCompanyCode[i] !=	null)
						model.setLCompanyCode( lCompanyCode[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( pVvdCode[i] !=	null)
						model.setPVvdCode( pVvdCode[i]);
						if ( lCenterCode[i] !=	null)
						model.setLCenterCode( lCenterCode[i]);
						if ( liabCdCmbSeq[i] !=	null)
						model.setLiabCdCmbSeq( liabCdCmbSeq[i]);
						if ( lRegionCode[i] !=	null)
						model.setLRegionCode( lRegionCode[i]);
						if ( lVvdCode[i] !=	null)
						model.setLVvdCode( lVvdCode[i]);
						if ( pRegionCode[i] !=	null)
						model.setPRegionCode( pRegionCode[i]);
						if ( pIntercompanyCode[i] !=	null)
						model.setPIntercompanyCode( pIntercompanyCode[i]);
						if ( pCompanyCode[i] !=	null)
						model.setPCompanyCode( pCompanyCode[i]);
						if ( lAccountCode[i] !=	null)
						model.setLAccountCode( lAccountCode[i]);
						if ( payPrioCd[i] !=	null)
						model.setPayPrioCd( payPrioCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAPVendorInfoVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return APVendorInfoVO[]
	 */
	public APVendorInfoVO[]	 getAPVendorInfoVOs(){
		APVendorInfoVO[] vos = (APVendorInfoVO[])models.toArray(new	APVendorInfoVO[models.size()]);
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
		this.lIntercompanyCode =	this.lIntercompanyCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCenterCode =	this.pCenterCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pAccountCode =	this.pAccountCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCdCmbSeq =	this.payCdCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm =	this.vndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lCompanyCode =	this.lCompanyCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVvdCode =	this.pVvdCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lCenterCode =	this.lCenterCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCdCmbSeq =	this.liabCdCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lRegionCode =	this.lRegionCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lVvdCode =	this.lVvdCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pRegionCode =	this.pRegionCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIntercompanyCode =	this.pIntercompanyCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCompanyCode =	this.pCompanyCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lAccountCode =	this.lAccountCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payPrioCd =	this.payPrioCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}