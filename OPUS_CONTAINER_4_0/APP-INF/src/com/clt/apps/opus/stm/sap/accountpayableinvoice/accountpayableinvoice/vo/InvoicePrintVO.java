/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvoicePrintVO.java
 *@FileTitle : InvoicePrintVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.06.11
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.06.11  
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
public class InvoicePrintVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvoicePrintVO>  models =	new	ArrayList<InvoicePrintVO>();


	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 invRqstSeq   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 chkFlg   =  null;
	/*	Column Info	*/
	private  String	 checkbox   =  null;
	/*	Column Info	*/
	private  String	 paySeq   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvoicePrintVO(){}

	public InvoicePrintVO(String ibflag,String usrId,String invRqstSeq,String invSeq,String pagerows,String chkFlg,String checkbox,String paySeq)	{
		this.ibflag  = ibflag ;
		this.usrId  = usrId ;
		this.invRqstSeq  = invRqstSeq ;
		this.invSeq  = invSeq ;
		this.pagerows  = pagerows ;
		this.chkFlg  = chkFlg ;
		this.checkbox  = checkbox ;
		this.paySeq  = paySeq ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("inv_rqst_seq", getInvRqstSeq());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("chk_flg", getChkFlg());		
		this.hashColumns.put("checkbox", getCheckbox());		
		this.hashColumns.put("pay_seq", getPaySeq());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("inv_rqst_seq", "invRqstSeq");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chk_flg", "chkFlg");
		this.hashFields.put("checkbox", "checkbox");
		this.hashFields.put("pay_seq", "paySeq");
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
	* @param  invRqstSeq
	*/
	public void	setInvRqstSeq( String	invRqstSeq ) {
		this.invRqstSeq =	invRqstSeq;
	}
 
	/**
	 * Column Info
	 * @return	invRqstSeq
	 */
	 public	 String	getInvRqstSeq() {
		 return	this.invRqstSeq;
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
	* @param  chkFlg
	*/
	public void	setChkFlg( String	chkFlg ) {
		this.chkFlg =	chkFlg;
	}
 
	/**
	 * Column Info
	 * @return	chkFlg
	 */
	 public	 String	getChkFlg() {
		 return	this.chkFlg;
	 } 
 	/**
	* Column Info
	* @param  checkbox
	*/
	public void	setCheckbox( String	checkbox ) {
		this.checkbox =	checkbox;
	}
 
	/**
	 * Column Info
	 * @return	checkbox
	 */
	 public	 String	getCheckbox() {
		 return	this.checkbox;
	 } 
 	/**
	* Column Info
	* @param  paySeq
	*/
	public void	setPaySeq( String	paySeq ) {
		this.paySeq =	paySeq;
	}
 
	/**
	 * Column Info
	 * @return	paySeq
	 */
	 public	 String	getPaySeq() {
		 return	this.paySeq;
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
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setInvRqstSeq(JSPUtil.getParameter(request,	prefix + "inv_rqst_seq", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setChkFlg(JSPUtil.getParameter(request,	prefix + "chk_flg", ""));
		setCheckbox(JSPUtil.getParameter(request,	prefix + "checkbox", ""));
		setPaySeq(JSPUtil.getParameter(request,	prefix + "pay_seq", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoicePrintVO[]
	 */
	public InvoicePrintVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvoicePrintVO[]
	 */
	public InvoicePrintVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoicePrintVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] invRqstSeq =	(JSPUtil.getParameter(request, prefix +	"inv_rqst_seq".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] chkFlg =	(JSPUtil.getParameter(request, prefix +	"chk_flg".trim(),	length));
				String[] checkbox =	(JSPUtil.getParameter(request, prefix +	"checkbox".trim(),	length));
				String[] paySeq =	(JSPUtil.getParameter(request, prefix +	"pay_seq".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoicePrintVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( invRqstSeq[i] !=	null)
						model.setInvRqstSeq( invRqstSeq[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( chkFlg[i] !=	null)
						model.setChkFlg( chkFlg[i]);
						if ( checkbox[i] !=	null)
						model.setCheckbox( checkbox[i]);
						if ( paySeq[i] !=	null)
						model.setPaySeq( paySeq[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoicePrintVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvoicePrintVO[]
	 */
	public InvoicePrintVO[]	 getInvoicePrintVOs(){
		InvoicePrintVO[] vos = (InvoicePrintVO[])models.toArray(new	InvoicePrintVO[models.size()]);
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
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRqstSeq =	this.invRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkFlg =	this.chkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkbox =	this.checkbox.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paySeq =	this.paySeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}