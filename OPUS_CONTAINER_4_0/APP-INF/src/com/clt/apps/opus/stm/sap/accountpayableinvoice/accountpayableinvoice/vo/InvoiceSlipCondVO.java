/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvoiceSlipCondVO.java
 *@FileTitle : InvoiceSlipCondVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.15
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.12.15  
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
public class InvoiceSlipCondVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvoiceSlipCondVO>  models =	new	ArrayList<InvoiceSlipCondVO>();


	/*	Column Info	*/
	private  String	 invDtFr   =  null;
	/*	Column Info	*/
	private  String	 approval   =  null;
	/*	Column Info	*/
	private  String	 invDtTo   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 apPayGrpLuCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 glDtTo   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 apInvSrcCd   =  null;
	/*	Column Info	*/
	private  String	 glDtFr   =  null;
	/*	Column Info	*/
	private  String	 vendorInvNo   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvoiceSlipCondVO(){}

	public InvoiceSlipCondVO(String invDtFr,String approval,String invDtTo,String invCurrCd,String pagerows,String invNo,String ofcCd,String apPayGrpLuCd,String ibflag,String glDtTo,String vndrNo,String apInvSrcCd,String glDtFr,String vendorInvNo,String usrId)	{
		this.invDtFr  = invDtFr ;
		this.approval  = approval ;
		this.invDtTo  = invDtTo ;
		this.invCurrCd  = invCurrCd ;
		this.pagerows  = pagerows ;
		this.invNo  = invNo ;
		this.ofcCd  = ofcCd ;
		this.apPayGrpLuCd  = apPayGrpLuCd ;
		this.ibflag  = ibflag ;
		this.glDtTo  = glDtTo ;
		this.vndrNo  = vndrNo ;
		this.apInvSrcCd  = apInvSrcCd ;
		this.glDtFr  = glDtFr ;
		this.vendorInvNo  = vendorInvNo ;
		this.usrId  = usrId ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_dt_fr", getInvDtFr());		
		this.hashColumns.put("approval", getApproval());		
		this.hashColumns.put("inv_dt_to", getInvDtTo());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ap_pay_grp_lu_cd", getApPayGrpLuCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("gl_dt_to", getGlDtTo());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("ap_inv_src_cd", getApInvSrcCd());		
		this.hashColumns.put("gl_dt_fr", getGlDtFr());		
		this.hashColumns.put("vendor_inv_no", getVendorInvNo());		
		this.hashColumns.put("usr_id", getUsrId());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("inv_dt_fr", "invDtFr");
		this.hashFields.put("approval", "approval");
		this.hashFields.put("inv_dt_to", "invDtTo");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ap_pay_grp_lu_cd", "apPayGrpLuCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gl_dt_to", "glDtTo");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ap_inv_src_cd", "apInvSrcCd");
		this.hashFields.put("gl_dt_fr", "glDtFr");
		this.hashFields.put("vendor_inv_no", "vendorInvNo");
		this.hashFields.put("usr_id", "usrId");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  invDtFr
	*/
	public void	setInvDtFr( String	invDtFr ) {
		this.invDtFr =	invDtFr;
	}
 
	/**
	 * Column Info
	 * @return	invDtFr
	 */
	 public	String	getInvDtFr() {
		 return	this.invDtFr;
	 } 
 	/**
	* Column Info
	* @param  approval
	*/
	public void	setApproval( String	approval ) {
		this.approval =	approval;
	}
 
	/**
	 * Column Info
	 * @return	approval
	 */
	 public	String	getApproval() {
		 return	this.approval;
	 } 
 	/**
	* Column Info
	* @param  invDtTo
	*/
	public void	setInvDtTo( String	invDtTo ) {
		this.invDtTo =	invDtTo;
	}
 
	/**
	 * Column Info
	 * @return	invDtTo
	 */
	 public	String	getInvDtTo() {
		 return	this.invDtTo;
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
	* @param  glDtTo
	*/
	public void	setGlDtTo( String	glDtTo ) {
		this.glDtTo =	glDtTo;
	}
 
	/**
	 * Column Info
	 * @return	glDtTo
	 */
	 public	String	getGlDtTo() {
		 return	this.glDtTo;
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
	* @param  glDtFr
	*/
	public void	setGlDtFr( String	glDtFr ) {
		this.glDtFr =	glDtFr;
	}
 
	/**
	 * Column Info
	 * @return	glDtFr
	 */
	 public	String	getGlDtFr() {
		 return	this.glDtFr;
	 } 
 	/**
	* Column Info
	* @param  vendorInvNo
	*/
	public void	setVendorInvNo( String	vendorInvNo ) {
		this.vendorInvNo =	vendorInvNo;
	}
 
	/**
	 * Column Info
	 * @return	vendorInvNo
	 */
	 public	String	getVendorInvNo() {
		 return	this.vendorInvNo;
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
	 public	String	getUsrId() {
		 return	this.usrId;
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
		setInvDtFr(JSPUtil.getParameter(request,	prefix + "inv_dt_fr", ""));
		setApproval(JSPUtil.getParameter(request,	prefix + "approval", ""));
		setInvDtTo(JSPUtil.getParameter(request,	prefix + "inv_dt_to", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setApPayGrpLuCd(JSPUtil.getParameter(request,	prefix + "ap_pay_grp_lu_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setGlDtTo(JSPUtil.getParameter(request,	prefix + "gl_dt_to", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setApInvSrcCd(JSPUtil.getParameter(request,	prefix + "ap_inv_src_cd", ""));
		setGlDtFr(JSPUtil.getParameter(request,	prefix + "gl_dt_fr", ""));
		setVendorInvNo(JSPUtil.getParameter(request,	prefix + "vendor_inv_no", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceSlipCondVO[]
	 */
	public InvoiceSlipCondVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvoiceSlipCondVO[]
	 */
	public InvoiceSlipCondVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoiceSlipCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] invDtFr =	(JSPUtil.getParameter(request, prefix +	"inv_dt_fr".trim(),	length));
				String[] approval =	(JSPUtil.getParameter(request, prefix +	"approval".trim(),	length));
				String[] invDtTo =	(JSPUtil.getParameter(request, prefix +	"inv_dt_to".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] apPayGrpLuCd =	(JSPUtil.getParameter(request, prefix +	"ap_pay_grp_lu_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] glDtTo =	(JSPUtil.getParameter(request, prefix +	"gl_dt_to".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] apInvSrcCd =	(JSPUtil.getParameter(request, prefix +	"ap_inv_src_cd".trim(),	length));
				String[] glDtFr =	(JSPUtil.getParameter(request, prefix +	"gl_dt_fr".trim(),	length));
				String[] vendorInvNo =	(JSPUtil.getParameter(request, prefix +	"vendor_inv_no".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoiceSlipCondVO();
						if ( invDtFr[i] !=	null)
						model.setInvDtFr( invDtFr[i]);
						if ( approval[i] !=	null)
						model.setApproval( approval[i]);
						if ( invDtTo[i] !=	null)
						model.setInvDtTo( invDtTo[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( apPayGrpLuCd[i] !=	null)
						model.setApPayGrpLuCd( apPayGrpLuCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( glDtTo[i] !=	null)
						model.setGlDtTo( glDtTo[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( apInvSrcCd[i] !=	null)
						model.setApInvSrcCd( apInvSrcCd[i]);
						if ( glDtFr[i] !=	null)
						model.setGlDtFr( glDtFr[i]);
						if ( vendorInvNo[i] !=	null)
						model.setVendorInvNo( vendorInvNo[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoiceSlipCondVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvoiceSlipCondVO[]
	 */
	public InvoiceSlipCondVO[]	 getInvoiceSlipCondVOs(){
		InvoiceSlipCondVO[] vos = (InvoiceSlipCondVO[])models.toArray(new	InvoiceSlipCondVO[models.size()]);
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
		this.invDtFr =	this.invDtFr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approval =	this.approval.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtTo =	this.invDtTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayGrpLuCd =	this.apPayGrpLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDtTo =	this.glDtTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apInvSrcCd =	this.apInvSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDtFr =	this.glDtFr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vendorInvNo =	this.vendorInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}