/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvoiceApprovalInfoListVO.java
 *@FileTitle : InvoiceApprovalInfoListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.01
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.10.01  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo;

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
public class InvoiceApprovalInfoListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvoiceApprovalInfoListVO>  models =	new	ArrayList<InvoiceApprovalInfoListVO>();


	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 lginUsrApOfc   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 lginUsrNm   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 glDt   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvoiceApprovalInfoListVO(){}

	public InvoiceApprovalInfoListVO(String ibflag,String lginUsrApOfc,String usrId,String invSeq,String lginUsrNm,String pagerows,String invNo,String ofcCd,String glDt,String invDt)	{
		this.ibflag  = ibflag ;
		this.lginUsrApOfc  = lginUsrApOfc ;
		this.usrId  = usrId ;
		this.invSeq  = invSeq ;
		this.lginUsrNm  = lginUsrNm ;
		this.pagerows  = pagerows ;
		this.invNo  = invNo ;
		this.ofcCd  = ofcCd ;
		this.glDt  = glDt ;
		this.invDt  = invDt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("lgin_usr_ap_ofc", getLginUsrApOfc());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("lgin_usr_nm", getLginUsrNm());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("gl_dt", getGlDt());		
		this.hashColumns.put("inv_dt", getInvDt());
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lgin_usr_ap_ofc", "lginUsrApOfc");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("lgin_usr_nm", "lginUsrNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("inv_dt", "invDt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  lginUsrApOfc
	*/
	public void	setLginUsrApOfc( String	lginUsrApOfc ) {
		this.lginUsrApOfc =	lginUsrApOfc;
	}
 
	/**
	 * Column Info
	 * @return	lginUsrApOfc
	 */
	 public	 String	getLginUsrApOfc() {
		 return	this.lginUsrApOfc;
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
	* @param  invSeq
	*/
	public void	setInvSeq( String	invSeq ) {
		this.invSeq =	invSeq;
	}
 
	/**
	 * Column Info
	 * @return	invSeq
	 */
	 public	 String	getInvSeq() {
		 return	this.invSeq;
	 } 
 	/**
	* Column Info
	* @param  lginUsrNm
	*/
	public void	setLginUsrNm( String	lginUsrNm ) {
		this.lginUsrNm =	lginUsrNm;
	}
 
	/**
	 * Column Info
	 * @return	lginUsrNm
	 */
	 public	 String	getLginUsrNm() {
		 return	this.lginUsrNm;
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
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
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
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setLginUsrApOfc(JSPUtil.getParameter(request,	prefix + "lgin_usr_ap_ofc", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setLginUsrNm(JSPUtil.getParameter(request,	prefix + "lgin_usr_nm", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setGlDt(JSPUtil.getParameter(request,	prefix + "gl_dt", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceApprovalInfoListVO[]
	 */
	public InvoiceApprovalInfoListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvoiceApprovalInfoListVO[]
	 */
	public InvoiceApprovalInfoListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoiceApprovalInfoListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] lginUsrApOfc =	(JSPUtil.getParameter(request, prefix +	"lgin_usr_ap_ofc".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] lginUsrNm =	(JSPUtil.getParameter(request, prefix +	"lgin_usr_nm".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] glDt =	(JSPUtil.getParameter(request, prefix +	"gl_dt".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoiceApprovalInfoListVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( lginUsrApOfc[i] !=	null)
						model.setLginUsrApOfc( lginUsrApOfc[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( lginUsrNm[i] !=	null)
						model.setLginUsrNm( lginUsrNm[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( glDt[i] !=	null)
						model.setGlDt( glDt[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoiceApprovalInfoListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvoiceApprovalInfoListVO[]
	 */
	public InvoiceApprovalInfoListVO[]	 getInvoiceApprovalInfoListVOs(){
		InvoiceApprovalInfoListVO[] vos = (InvoiceApprovalInfoListVO[])models.toArray(new	InvoiceApprovalInfoListVO[models.size()]);
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
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lginUsrApOfc =	this.lginUsrApOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lginUsrNm =	this.lginUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt =	this.glDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}