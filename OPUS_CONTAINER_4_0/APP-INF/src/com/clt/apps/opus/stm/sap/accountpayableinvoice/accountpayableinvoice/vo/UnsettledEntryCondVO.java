/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : UnsettledEntryCondVO.java
 *@FileTitle : UnsettledEntryCondVO
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
public class UnsettledEntryCondVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<UnsettledEntryCondVO>  models =	new	ArrayList<UnsettledEntryCondVO>();


	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 unstlYrmon   =  null;
	/*	Column Info	*/
	private  String	 glDt   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 coaAcctCd   =  null;
	/*	Column Info	*/
	private  String	 unstlCurrCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public UnsettledEntryCondVO(){}

	public UnsettledEntryCondVO(String ofcCd,String unstlYrmon,String glDt,String vndrNo,String ibflag,String coaAcctCd,String unstlCurrCd,String pagerows,String usrId)	{
		this.ofcCd  = ofcCd ;
		this.unstlYrmon  = unstlYrmon ;
		this.glDt  = glDt ;
		this.vndrNo  = vndrNo ;
		this.ibflag  = ibflag ;
		this.coaAcctCd  = coaAcctCd ;
		this.unstlCurrCd  = unstlCurrCd ;
		this.pagerows  = pagerows ;
		this.usrId  = usrId ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("unstl_yrmon", getUnstlYrmon());		
		this.hashColumns.put("gl_dt", getGlDt());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("coa_acct_cd", getCoaAcctCd());		
		this.hashColumns.put("unstl_curr_cd", getUnstlCurrCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("usr_id", getUsrId());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("unstl_yrmon", "unstlYrmon");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("coa_acct_cd", "coaAcctCd");
		this.hashFields.put("unstl_curr_cd", "unstlCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usr_id", "usrId");
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
	 public	String	getOfcCd() {
		 return	this.ofcCd;
	 } 
 	/**
	* Column Info
	* @param  unstlYrmon
	*/
	public void	setUnstlYrmon( String	unstlYrmon ) {
		this.unstlYrmon =	unstlYrmon;
	}
 
	/**
	 * Column Info
	 * @return	unstlYrmon
	 */
	 public	String	getUnstlYrmon() {
		 return	this.unstlYrmon;
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
	* @param  coaAcctCd
	*/
	public void	setCoaAcctCd( String	coaAcctCd ) {
		this.coaAcctCd =	coaAcctCd;
	}
 
	/**
	 * Column Info
	 * @return	coaAcctCd
	 */
	 public	String	getCoaAcctCd() {
		 return	this.coaAcctCd;
	 } 
 	/**
	* Column Info
	* @param  unstlCurrCd
	*/
	public void	setUnstlCurrCd( String	unstlCurrCd ) {
		this.unstlCurrCd =	unstlCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	unstlCurrCd
	 */
	 public	String	getUnstlCurrCd() {
		 return	this.unstlCurrCd;
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
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setUnstlYrmon(JSPUtil.getParameter(request,	prefix + "unstl_yrmon", ""));
		setGlDt(JSPUtil.getParameter(request,	prefix + "gl_dt", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCoaAcctCd(JSPUtil.getParameter(request,	prefix + "coa_acct_cd", ""));
		setUnstlCurrCd(JSPUtil.getParameter(request,	prefix + "unstl_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UnsettledEntryCondVO[]
	 */
	public UnsettledEntryCondVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return UnsettledEntryCondVO[]
	 */
	public UnsettledEntryCondVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		UnsettledEntryCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] unstlYrmon =	(JSPUtil.getParameter(request, prefix +	"unstl_yrmon".trim(),	length));
				String[] glDt =	(JSPUtil.getParameter(request, prefix +	"gl_dt".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] coaAcctCd =	(JSPUtil.getParameter(request, prefix +	"coa_acct_cd".trim(),	length));
				String[] unstlCurrCd =	(JSPUtil.getParameter(request, prefix +	"unstl_curr_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	UnsettledEntryCondVO();
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( unstlYrmon[i] !=	null)
						model.setUnstlYrmon( unstlYrmon[i]);
						if ( glDt[i] !=	null)
						model.setGlDt( glDt[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( coaAcctCd[i] !=	null)
						model.setCoaAcctCd( coaAcctCd[i]);
						if ( unstlCurrCd[i] !=	null)
						model.setUnstlCurrCd( unstlCurrCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getUnsettledEntryCondVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return UnsettledEntryCondVO[]
	 */
	public UnsettledEntryCondVO[]	 getUnsettledEntryCondVOs(){
		UnsettledEntryCondVO[] vos = (UnsettledEntryCondVO[])models.toArray(new	UnsettledEntryCondVO[models.size()]);
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
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unstlYrmon =	this.unstlYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt =	this.glDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaAcctCd =	this.coaAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unstlCurrCd =	this.unstlCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}