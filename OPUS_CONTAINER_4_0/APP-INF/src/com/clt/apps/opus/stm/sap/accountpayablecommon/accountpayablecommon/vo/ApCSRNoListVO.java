/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ApCSRNoListVO.java
 *@FileTitle : ApCSRNoListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.11.11
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.11.11  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo;

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
public class ApCSRNoListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ApCSRNoListVO>  models =	new	ArrayList<ApCSRNoListVO>();


	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 invDesc   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 invFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public ApCSRNoListVO(){}

	public ApCSRNoListVO(String invNo,String invDesc,String ibflag,String pagerows,String ofcCd,String usrId,String invFlg)	{
		this.invNo  = invNo ;
		this.invDesc  = invDesc ;
		this.ibflag  = ibflag ;
		this.pagerows  = pagerows ;
		this.ofcCd  = ofcCd ;
		this.usrId  = usrId ;
		this.invFlg  = invFlg ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("inv_desc", getInvDesc());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("inv_flg", getInvFlg());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("inv_flg", "invFlg");
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
	 public	String	getInvNo() {
		 return	this.invNo;
	 } 
 	/**
	* Column Info
	* @param  invDesc
	*/
	public void	setInvDesc( String	invDesc ) {
		this.invDesc =	invDesc;
	}
 
	/**
	 * Column Info
	 * @return	invDesc
	 */
	 public	String	getInvDesc() {
		 return	this.invDesc;
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
	* Column Info
	* @param  invFlg
	*/
	public void	setInvFlg( String	invFlg ) {
		this.invFlg =	invFlg;
	}
 
	/**
	 * Column Info
	 * @return	invFlg
	 */
	 public	String	getInvFlg() {
		 return	this.invFlg;
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
		setInvDesc(JSPUtil.getParameter(request,	prefix + "inv_desc", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setInvFlg(JSPUtil.getParameter(request,	prefix + "inv_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ApCSRNoListVO[]
	 */
	public ApCSRNoListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ApCSRNoListVO[]
	 */
	public ApCSRNoListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ApCSRNoListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] invDesc =	(JSPUtil.getParameter(request, prefix +	"inv_desc".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] invFlg =	(JSPUtil.getParameter(request, prefix +	"inv_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ApCSRNoListVO();
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( invDesc[i] !=	null)
						model.setInvDesc( invDesc[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( invFlg[i] !=	null)
						model.setInvFlg( invFlg[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getApCSRNoListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ApCSRNoListVO[]
	 */
	public ApCSRNoListVO[]	 getApCSRNoListVOs(){
		ApCSRNoListVO[] vos = (ApCSRNoListVO[])models.toArray(new	ApCSRNoListVO[models.size()]);
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
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc =	this.invDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invFlg =	this.invFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}