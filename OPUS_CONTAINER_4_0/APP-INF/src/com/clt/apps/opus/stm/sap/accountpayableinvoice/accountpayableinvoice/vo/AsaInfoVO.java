/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AsaInfoVO.java
 *@FileTitle : AsaInfoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.03.29
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.03.29  
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
public class AsaInfoVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AsaInfoVO>  models =	new	ArrayList<AsaInfoVO>();


	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 asaOffice   =  null;
	/*	Column Info	*/
	private  String	 asaStatus   =  null;
	/*	Column Info	*/
	private  String	 asaCurrency   =  null;
	/*	Column Info	*/
	private  String	 asaNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 asaPeriodFrom   =  null;
	/*	Column Info	*/
	private  String	 asaPeriodTo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AsaInfoVO(){}

	public AsaInfoVO(String ibflag,String asaOffice,String asaStatus,String asaCurrency,String asaNo,String pagerows,String asaPeriodFrom,String asaPeriodTo)	{
		this.ibflag  = ibflag ;
		this.asaOffice  = asaOffice ;
		this.asaStatus  = asaStatus ;
		this.asaCurrency  = asaCurrency ;
		this.asaNo  = asaNo ;
		this.pagerows  = pagerows ;
		this.asaPeriodFrom  = asaPeriodFrom ;
		this.asaPeriodTo  = asaPeriodTo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("asa_office", getAsaOffice());		
		this.hashColumns.put("asa_status", getAsaStatus());		
		this.hashColumns.put("asa_currency", getAsaCurrency());		
		this.hashColumns.put("asa_no", getAsaNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("asa_period_from", getAsaPeriodFrom());		
		this.hashColumns.put("asa_period_to", getAsaPeriodTo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("asa_office", "asaOffice");
		this.hashFields.put("asa_status", "asaStatus");
		this.hashFields.put("asa_currency", "asaCurrency");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("asa_period_from", "asaPeriodFrom");
		this.hashFields.put("asa_period_to", "asaPeriodTo");
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
	 public	String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  asaOffice
	*/
	public void	setAsaOffice( String	asaOffice ) {
		this.asaOffice =	asaOffice;
	}
 
	/**
	 * Column Info
	 * @return	asaOffice
	 */
	 public	String	getAsaOffice() {
		 return	this.asaOffice;
	 } 
 	/**
	* Column Info
	* @param  asaStatus
	*/
	public void	setAsaStatus( String	asaStatus ) {
		this.asaStatus =	asaStatus;
	}
 
	/**
	 * Column Info
	 * @return	asaStatus
	 */
	 public	String	getAsaStatus() {
		 return	this.asaStatus;
	 } 
 	/**
	* Column Info
	* @param  asaCurrency
	*/
	public void	setAsaCurrency( String	asaCurrency ) {
		this.asaCurrency =	asaCurrency;
	}
 
	/**
	 * Column Info
	 * @return	asaCurrency
	 */
	 public	String	getAsaCurrency() {
		 return	this.asaCurrency;
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
	 public	String	getAsaNo() {
		 return	this.asaNo;
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
	* @param  asaPeriodFrom
	*/
	public void	setAsaPeriodFrom( String	asaPeriodFrom ) {
		this.asaPeriodFrom =	asaPeriodFrom;
	}
 
	/**
	 * Column Info
	 * @return	asaPeriodFrom
	 */
	 public	String	getAsaPeriodFrom() {
		 return	this.asaPeriodFrom;
	 } 
 	/**
	* Column Info
	* @param  asaPeriodTo
	*/
	public void	setAsaPeriodTo( String	asaPeriodTo ) {
		this.asaPeriodTo =	asaPeriodTo;
	}
 
	/**
	 * Column Info
	 * @return	asaPeriodTo
	 */
	 public	String	getAsaPeriodTo() {
		 return	this.asaPeriodTo;
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
		setAsaOffice(JSPUtil.getParameter(request,	prefix + "asa_office", ""));
		setAsaStatus(JSPUtil.getParameter(request,	prefix + "asa_status", ""));
		setAsaCurrency(JSPUtil.getParameter(request,	prefix + "asa_currency", ""));
		setAsaNo(JSPUtil.getParameter(request,	prefix + "asa_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAsaPeriodFrom(JSPUtil.getParameter(request,	prefix + "asa_period_from", ""));
		setAsaPeriodTo(JSPUtil.getParameter(request,	prefix + "asa_period_to", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AsaInfoVO[]
	 */
	public AsaInfoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AsaInfoVO[]
	 */
	public AsaInfoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AsaInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] asaOffice =	(JSPUtil.getParameter(request, prefix +	"asa_office".trim(),	length));
				String[] asaStatus =	(JSPUtil.getParameter(request, prefix +	"asa_status".trim(),	length));
				String[] asaCurrency =	(JSPUtil.getParameter(request, prefix +	"asa_currency".trim(),	length));
				String[] asaNo =	(JSPUtil.getParameter(request, prefix +	"asa_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] asaPeriodFrom =	(JSPUtil.getParameter(request, prefix +	"asa_period_from".trim(),	length));
				String[] asaPeriodTo =	(JSPUtil.getParameter(request, prefix +	"asa_period_to".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AsaInfoVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( asaOffice[i] !=	null)
						model.setAsaOffice( asaOffice[i]);
						if ( asaStatus[i] !=	null)
						model.setAsaStatus( asaStatus[i]);
						if ( asaCurrency[i] !=	null)
						model.setAsaCurrency( asaCurrency[i]);
						if ( asaNo[i] !=	null)
						model.setAsaNo( asaNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( asaPeriodFrom[i] !=	null)
						model.setAsaPeriodFrom( asaPeriodFrom[i]);
						if ( asaPeriodTo[i] !=	null)
						model.setAsaPeriodTo( asaPeriodTo[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAsaInfoVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return AsaInfoVO[]
	 */
	public AsaInfoVO[]	 getAsaInfoVOs(){
		AsaInfoVO[] vos = (AsaInfoVO[])models.toArray(new	AsaInfoVO[models.size()]);
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
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaOffice =	this.asaOffice.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaStatus =	this.asaStatus.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaCurrency =	this.asaCurrency.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo =	this.asaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaPeriodFrom =	this.asaPeriodFrom.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaPeriodTo =	this.asaPeriodTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}