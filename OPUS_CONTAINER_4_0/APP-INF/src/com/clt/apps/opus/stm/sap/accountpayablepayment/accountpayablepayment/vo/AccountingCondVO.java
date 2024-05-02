/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountingCondVO.java
 *@FileTitle : AccountingCondVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.05.06
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.05.06  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo;

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
public class AccountingCondVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AccountingCondVO>  models =	new	ArrayList<AccountingCondVO>();


	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 acctgFrDt   =  null;
	/*	Column Info	*/
	private  String	 acctgToDt   =  null;
	/*	Column Info	*/
	private  String	 acctgEvntTpCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 functionalCurrency   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AccountingCondVO(){}

	public AccountingCondVO(String ibflag,String acctgFrDt,String acctgToDt,String acctgEvntTpCd,String pagerows,String functionalCurrency,String invNo)	{
		this.ibflag  = ibflag ;
		this.acctgFrDt  = acctgFrDt ;
		this.acctgToDt  = acctgToDt ;
		this.acctgEvntTpCd  = acctgEvntTpCd ;
		this.pagerows  = pagerows ;
		this.functionalCurrency  = functionalCurrency ;
		this.invNo  = invNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("acctg_fr_dt", getAcctgFrDt());		
		this.hashColumns.put("acctg_to_dt", getAcctgToDt());		
		this.hashColumns.put("acctg_evnt_tp_cd", getAcctgEvntTpCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("functional_currency", getFunctionalCurrency());		
		this.hashColumns.put("inv_no", getInvNo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acctg_fr_dt", "acctgFrDt");
		this.hashFields.put("acctg_to_dt", "acctgToDt");
		this.hashFields.put("acctg_evnt_tp_cd", "acctgEvntTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("functional_currency", "functionalCurrency");
		this.hashFields.put("inv_no", "invNo");
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
	* @param  acctgFrDt
	*/
	public void	setAcctgFrDt( String	acctgFrDt ) {
		this.acctgFrDt =	acctgFrDt;
	}
 
	/**
	 * Column Info
	 * @return	acctgFrDt
	 */
	 public	 String	getAcctgFrDt() {
		 return	this.acctgFrDt;
	 } 
 	/**
	* Column Info
	* @param  acctgToDt
	*/
	public void	setAcctgToDt( String	acctgToDt ) {
		this.acctgToDt =	acctgToDt;
	}
 
	/**
	 * Column Info
	 * @return	acctgToDt
	 */
	 public	 String	getAcctgToDt() {
		 return	this.acctgToDt;
	 } 
 	/**
	* Column Info
	* @param  acctgEvntTpCd
	*/
	public void	setAcctgEvntTpCd( String	acctgEvntTpCd ) {
		this.acctgEvntTpCd =	acctgEvntTpCd;
	}
 
	/**
	 * Column Info
	 * @return	acctgEvntTpCd
	 */
	 public	 String	getAcctgEvntTpCd() {
		 return	this.acctgEvntTpCd;
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
	* @param  functionalCurrency
	*/
	public void	setFunctionalCurrency( String	functionalCurrency ) {
		this.functionalCurrency =	functionalCurrency;
	}
 
	/**
	 * Column Info
	 * @return	functionalCurrency
	 */
	 public	 String	getFunctionalCurrency() {
		 return	this.functionalCurrency;
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
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAcctgFrDt(JSPUtil.getParameter(request,	prefix + "acctg_fr_dt", ""));
		setAcctgToDt(JSPUtil.getParameter(request,	prefix + "acctg_to_dt", ""));
		setAcctgEvntTpCd(JSPUtil.getParameter(request,	prefix + "acctg_evnt_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setFunctionalCurrency(JSPUtil.getParameter(request,	prefix + "functional_currency", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AccountingCondVO[]
	 */
	public AccountingCondVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AccountingCondVO[]
	 */
	public AccountingCondVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AccountingCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] acctgFrDt =	(JSPUtil.getParameter(request, prefix +	"acctg_fr_dt".trim(),	length));
				String[] acctgToDt =	(JSPUtil.getParameter(request, prefix +	"acctg_to_dt".trim(),	length));
				String[] acctgEvntTpCd =	(JSPUtil.getParameter(request, prefix +	"acctg_evnt_tp_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] functionalCurrency =	(JSPUtil.getParameter(request, prefix +	"functional_currency".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AccountingCondVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( acctgFrDt[i] !=	null)
						model.setAcctgFrDt( acctgFrDt[i]);
						if ( acctgToDt[i] !=	null)
						model.setAcctgToDt( acctgToDt[i]);
						if ( acctgEvntTpCd[i] !=	null)
						model.setAcctgEvntTpCd( acctgEvntTpCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( functionalCurrency[i] !=	null)
						model.setFunctionalCurrency( functionalCurrency[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAccountingCondVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return AccountingCondVO[]
	 */
	public AccountingCondVO[]	 getAccountingCondVOs(){
		AccountingCondVO[] vos = (AccountingCondVO[])models.toArray(new	AccountingCondVO[models.size()]);
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
		this.acctgFrDt =	this.acctgFrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgToDt =	this.acctgToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgEvntTpCd =	this.acctgEvntTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.functionalCurrency =	this.functionalCurrency.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}