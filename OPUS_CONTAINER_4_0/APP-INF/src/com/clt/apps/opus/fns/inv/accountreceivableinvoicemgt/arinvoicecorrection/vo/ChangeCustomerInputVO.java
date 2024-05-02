/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ChangeCustomerInputVO.java
 *@FileTitle : ChangeCustomerInputVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.12
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.01.12  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

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
public class ChangeCustomerInputVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ChangeCustomerInputVO>  models =	new	ArrayList<ChangeCustomerInputVO>();


	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 custCd   =  null;
	/*	Column Info	*/
	private  String	 cntCd   =  null;
	/*	Column Info	*/
	private  String	 issToDt   =  null;
	/*	Column Info	*/
	private  String	 issFmDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ChangeCustomerInputVO(){}

	public ChangeCustomerInputVO(String ofcCd,String ibflag,String custCd,String cntCd,String issToDt,String issFmDt,String pagerows,String invCurrCd)	{
		this.ofcCd  = ofcCd ;
		this.ibflag  = ibflag ;
		this.custCd  = custCd ;
		this.cntCd  = cntCd ;
		this.issToDt  = issToDt ;
		this.issFmDt  = issFmDt ;
		this.pagerows  = pagerows ;
		this.invCurrCd  = invCurrCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cust_cd", getCustCd());		
		this.hashColumns.put("cnt_cd", getCntCd());		
		this.hashColumns.put("iss_to_dt", getIssToDt());		
		this.hashColumns.put("iss_fm_dt", getIssFmDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("iss_to_dt", "issToDt");
		this.hashFields.put("iss_fm_dt", "issFmDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	 public	 String	getOfcCd() {
		 return	this.ofcCd;
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
	* @param  custCd
	*/
	public void	setCustCd( String	custCd ) {
		this.custCd =	custCd;
	}
 
	/**
	 * Column Info
	 * @return	custCd
	 */
	 public	 String	getCustCd() {
		 return	this.custCd;
	 } 
 	/**
	* Column Info
	* @param  cntCd
	*/
	public void	setCntCd( String	cntCd ) {
		this.cntCd =	cntCd;
	}
 
	/**
	 * Column Info
	 * @return	cntCd
	 */
	 public	 String	getCntCd() {
		 return	this.cntCd;
	 } 
 	/**
	* Column Info
	* @param  issToDt
	*/
	public void	setIssToDt( String	issToDt ) {
		this.issToDt =	issToDt;
	}
 
	/**
	 * Column Info
	 * @return	issToDt
	 */
	 public	 String	getIssToDt() {
		 return	this.issToDt;
	 } 
 	/**
	* Column Info
	* @param  issFmDt
	*/
	public void	setIssFmDt( String	issFmDt ) {
		this.issFmDt =	issFmDt;
	}
 
	/**
	 * Column Info
	 * @return	issFmDt
	 */
	 public	 String	getIssFmDt() {
		 return	this.issFmDt;
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
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCustCd(JSPUtil.getParameter(request,	prefix + "cust_cd", ""));
		setCntCd(JSPUtil.getParameter(request,	prefix + "cnt_cd", ""));
		setIssToDt(JSPUtil.getParameter(request,	prefix + "iss_to_dt", ""));
		setIssFmDt(JSPUtil.getParameter(request,	prefix + "iss_fm_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChangeCustomerInputVO[]
	 */
	public ChangeCustomerInputVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChangeCustomerInputVO[]
	 */
	public ChangeCustomerInputVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ChangeCustomerInputVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] custCd =	(JSPUtil.getParameter(request, prefix +	"cust_cd".trim(),	length));
				String[] cntCd =	(JSPUtil.getParameter(request, prefix +	"cnt_cd".trim(),	length));
				String[] issToDt =	(JSPUtil.getParameter(request, prefix +	"iss_to_dt".trim(),	length));
				String[] issFmDt =	(JSPUtil.getParameter(request, prefix +	"iss_fm_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ChangeCustomerInputVO();
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( custCd[i] !=	null)
						model.setCustCd( custCd[i]);
						if ( cntCd[i] !=	null)
						model.setCntCd( cntCd[i]);
						if ( issToDt[i] !=	null)
						model.setIssToDt( issToDt[i]);
						if ( issFmDt[i] !=	null)
						model.setIssFmDt( issFmDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getChangeCustomerInputVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ChangeCustomerInputVO[]
	 */
	public ChangeCustomerInputVO[]	 getChangeCustomerInputVOs(){
		ChangeCustomerInputVO[] vos = (ChangeCustomerInputVO[])models.toArray(new	ChangeCustomerInputVO[models.size()]);
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
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd =	this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd =	this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issToDt =	this.issToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issFmDt =	this.issFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}