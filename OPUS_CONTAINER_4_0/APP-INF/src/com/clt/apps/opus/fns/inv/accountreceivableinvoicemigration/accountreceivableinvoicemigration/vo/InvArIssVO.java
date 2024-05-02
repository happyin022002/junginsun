/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvArIssVO.java
 *@FileTitle : InvArIssVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.07.18
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.07.18  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo;

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
public class InvArIssVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvArIssVO>  models =	new	ArrayList<InvArIssVO>();


	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 userId   =  null;
	/*	Column Info	*/
	private  String	 issGrpTpCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 issDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvArIssVO(){}

	public InvArIssVO(String invNo,String ofcCd,String ibflag,String userId,String issGrpTpCd,String pagerows,String issDt)	{
		this.invNo  = invNo ;
		this.ofcCd  = ofcCd ;
		this.ibflag  = ibflag ;
		this.userId  = userId ;
		this.issGrpTpCd  = issGrpTpCd ;
		this.pagerows  = pagerows ;
		this.issDt  = issDt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("user_id", getUserId());		
		this.hashColumns.put("iss_grp_tp_cd", getIssGrpTpCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("iss_dt", getIssDt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("iss_grp_tp_cd", "issGrpTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("iss_dt", "issDt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  userId
	*/
	public void	setUserId( String	userId ) {
		this.userId =	userId;
	}
 
	/**
	 * Column Info
	 * @return	userId
	 */
	 public	 String	getUserId() {
		 return	this.userId;
	 } 
 	/**
	* Column Info
	* @param  issGrpTpCd
	*/
	public void	setIssGrpTpCd( String	issGrpTpCd ) {
		this.issGrpTpCd =	issGrpTpCd;
	}
 
	/**
	 * Column Info
	 * @return	issGrpTpCd
	 */
	 public	 String	getIssGrpTpCd() {
		 return	this.issGrpTpCd;
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
	* @param  issDt
	*/
	public void	setIssDt( String	issDt ) {
		this.issDt =	issDt;
	}
 
	/**
	 * Column Info
	 * @return	issDt
	 */
	 public	 String	getIssDt() {
		 return	this.issDt;
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
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setUserId(JSPUtil.getParameter(request,	prefix + "user_id", ""));
		setIssGrpTpCd(JSPUtil.getParameter(request,	prefix + "iss_grp_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIssDt(JSPUtil.getParameter(request,	prefix + "iss_dt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvArIssVO[]
	 */
	public InvArIssVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvArIssVO[]
	 */
	public InvArIssVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvArIssVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] userId =	(JSPUtil.getParameter(request, prefix +	"user_id".trim(),	length));
				String[] issGrpTpCd =	(JSPUtil.getParameter(request, prefix +	"iss_grp_tp_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] issDt =	(JSPUtil.getParameter(request, prefix +	"iss_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvArIssVO();
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( userId[i] !=	null)
						model.setUserId( userId[i]);
						if ( issGrpTpCd[i] !=	null)
						model.setIssGrpTpCd( issGrpTpCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( issDt[i] !=	null)
						model.setIssDt( issDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvArIssVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvArIssVO[]
	 */
	public InvArIssVO[]	 getInvArIssVOs(){
		InvArIssVO[] vos = (InvArIssVO[])models.toArray(new	InvArIssVO[models.size()]);
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
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId =	this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issGrpTpCd =	this.issGrpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt =	this.issDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}