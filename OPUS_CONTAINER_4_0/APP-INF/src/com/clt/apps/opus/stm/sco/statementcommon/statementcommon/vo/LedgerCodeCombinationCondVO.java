/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : LedgerCodeCombinationCondVO.java
 *@FileTitle : LedgerCodeCombinationCondVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.06.18
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.06.18  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo;

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
public class LedgerCodeCombinationCondVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<LedgerCodeCombinationCondVO>  models =	new	ArrayList<LedgerCodeCombinationCondVO>();


	/*	Column Info	*/
	private  String	 fRegion   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 fInterCompany   =  null;
	/*	Column Info	*/
	private  String	 fVvd   =  null;
	/*	Column Info	*/
	private  String	 fAccount   =  null;
	/*	Column Info	*/
	private  String	 fCenter   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 fCompany   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public LedgerCodeCombinationCondVO(){}

	public LedgerCodeCombinationCondVO(String fRegion,String ibflag,String fInterCompany,String fVvd,String fAccount,String fCenter,String pagerows,String fCompany)	{
		this.fRegion  = fRegion ;
		this.ibflag  = ibflag ;
		this.fInterCompany  = fInterCompany ;
		this.fVvd  = fVvd ;
		this.fAccount  = fAccount ;
		this.fCenter  = fCenter ;
		this.pagerows  = pagerows ;
		this.fCompany  = fCompany ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_region", getFRegion());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("f_inter_company", getFInterCompany());		
		this.hashColumns.put("f_vvd", getFVvd());		
		this.hashColumns.put("f_account", getFAccount());		
		this.hashColumns.put("f_center", getFCenter());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("f_company", getFCompany());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("f_region", "fRegion");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_inter_company", "fInterCompany");
		this.hashFields.put("f_vvd", "fVvd");
		this.hashFields.put("f_account", "fAccount");
		this.hashFields.put("f_center", "fCenter");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_company", "fCompany");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  fRegion
	*/
	public void	setFRegion( String	fRegion ) {
		this.fRegion =	fRegion;
	}
 
	/**
	 * Column Info
	 * @return	fRegion
	 */
	 public	 String	getFRegion() {
		 return	this.fRegion;
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
	* @param  fInterCompany
	*/
	public void	setFInterCompany( String	fInterCompany ) {
		this.fInterCompany =	fInterCompany;
	}
 
	/**
	 * Column Info
	 * @return	fInterCompany
	 */
	 public	 String	getFInterCompany() {
		 return	this.fInterCompany;
	 } 
 	/**
	* Column Info
	* @param  fVvd
	*/
	public void	setFVvd( String	fVvd ) {
		this.fVvd =	fVvd;
	}
 
	/**
	 * Column Info
	 * @return	fVvd
	 */
	 public	 String	getFVvd() {
		 return	this.fVvd;
	 } 
 	/**
	* Column Info
	* @param  fAccount
	*/
	public void	setFAccount( String	fAccount ) {
		this.fAccount =	fAccount;
	}
 
	/**
	 * Column Info
	 * @return	fAccount
	 */
	 public	 String	getFAccount() {
		 return	this.fAccount;
	 } 
 	/**
	* Column Info
	* @param  fCenter
	*/
	public void	setFCenter( String	fCenter ) {
		this.fCenter =	fCenter;
	}
 
	/**
	 * Column Info
	 * @return	fCenter
	 */
	 public	 String	getFCenter() {
		 return	this.fCenter;
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
	* @param  fCompany
	*/
	public void	setFCompany( String	fCompany ) {
		this.fCompany =	fCompany;
	}
 
	/**
	 * Column Info
	 * @return	fCompany
	 */
	 public	 String	getFCompany() {
		 return	this.fCompany;
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
		setFRegion(JSPUtil.getParameter(request,	prefix + "f_region", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setFInterCompany(JSPUtil.getParameter(request,	prefix + "f_inter_company", ""));
		setFVvd(JSPUtil.getParameter(request,	prefix + "f_vvd", ""));
		setFAccount(JSPUtil.getParameter(request,	prefix + "f_account", ""));
		setFCenter(JSPUtil.getParameter(request,	prefix + "f_center", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setFCompany(JSPUtil.getParameter(request,	prefix + "f_company", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LedgerCodeCombinationCondVO[]
	 */
	public LedgerCodeCombinationCondVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return LedgerCodeCombinationCondVO[]
	 */
	public LedgerCodeCombinationCondVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		LedgerCodeCombinationCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] fRegion =	(JSPUtil.getParameter(request, prefix +	"f_region".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] fInterCompany =	(JSPUtil.getParameter(request, prefix +	"f_inter_company".trim(),	length));
				String[] fVvd =	(JSPUtil.getParameter(request, prefix +	"f_vvd".trim(),	length));
				String[] fAccount =	(JSPUtil.getParameter(request, prefix +	"f_account".trim(),	length));
				String[] fCenter =	(JSPUtil.getParameter(request, prefix +	"f_center".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] fCompany =	(JSPUtil.getParameter(request, prefix +	"f_company".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	LedgerCodeCombinationCondVO();
						if ( fRegion[i] !=	null)
						model.setFRegion( fRegion[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( fInterCompany[i] !=	null)
						model.setFInterCompany( fInterCompany[i]);
						if ( fVvd[i] !=	null)
						model.setFVvd( fVvd[i]);
						if ( fAccount[i] !=	null)
						model.setFAccount( fAccount[i]);
						if ( fCenter[i] !=	null)
						model.setFCenter( fCenter[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( fCompany[i] !=	null)
						model.setFCompany( fCompany[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getLedgerCodeCombinationCondVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return LedgerCodeCombinationCondVO[]
	 */
	public LedgerCodeCombinationCondVO[]	 getLedgerCodeCombinationCondVOs(){
		LedgerCodeCombinationCondVO[] vos = (LedgerCodeCombinationCondVO[])models.toArray(new	LedgerCodeCombinationCondVO[models.size()]);
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
		this.fRegion =	this.fRegion.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fInterCompany =	this.fInterCompany.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVvd =	this.fVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAccount =	this.fAccount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCenter =	this.fCenter.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCompany =	this.fCompany.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}