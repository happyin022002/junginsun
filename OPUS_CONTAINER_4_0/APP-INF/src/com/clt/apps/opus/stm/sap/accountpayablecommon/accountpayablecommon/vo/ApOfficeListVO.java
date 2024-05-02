/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ApOfficeListVO.java
 *@FileTitle : ApOfficeListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.24
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.12.24  
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
public class ApOfficeListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ApOfficeListVO>  models =	new	ArrayList<ApOfficeListVO>();


	/*	Column Info	*/
	private  String	 apOfcCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 ofcEngNm   =  null;
	/*	Column Info	*/
	private  String	 ofcKrnNm   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public ApOfficeListVO(){}

	public ApOfficeListVO(String apOfcCd,String ibflag,String ofcEngNm,String ofcKrnNm,String pagerows,String arOfcCd)	{
		this.apOfcCd  = apOfcCd ;
		this.ibflag  = ibflag ;
		this.ofcEngNm  = ofcEngNm ;
		this.ofcKrnNm  = ofcKrnNm ;
		this.pagerows  = pagerows ;
		this.arOfcCd  = arOfcCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());		
		this.hashColumns.put("ofc_krn_nm", getOfcKrnNm());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("ofc_krn_nm", "ofcKrnNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  apOfcCd
	*/
	public void	setApOfcCd( String	apOfcCd ) {
		this.apOfcCd =	apOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	apOfcCd
	 */
	 public	String	getApOfcCd() {
		 return	this.apOfcCd;
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
	* @param  ofcEngNm
	*/
	public void	setOfcEngNm( String	ofcEngNm ) {
		this.ofcEngNm =	ofcEngNm;
	}
 
	/**
	 * Column Info
	 * @return	ofcEngNm
	 */
	 public	String	getOfcEngNm() {
		 return	this.ofcEngNm;
	 } 
 	/**
	* Column Info
	* @param  ofcKrnNm
	*/
	public void	setOfcKrnNm( String	ofcKrnNm ) {
		this.ofcKrnNm =	ofcKrnNm;
	}
 
	/**
	 * Column Info
	 * @return	ofcKrnNm
	 */
	 public	String	getOfcKrnNm() {
		 return	this.ofcKrnNm;
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
	* @param  arOfcCd
	*/
	public void	setArOfcCd( String	arOfcCd ) {
		this.arOfcCd =	arOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	arOfcCd
	 */
	 public	String	getArOfcCd() {
		 return	this.arOfcCd;
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
		setApOfcCd(JSPUtil.getParameter(request,	prefix + "ap_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setOfcEngNm(JSPUtil.getParameter(request,	prefix + "ofc_eng_nm", ""));
		setOfcKrnNm(JSPUtil.getParameter(request,	prefix + "ofc_krn_nm", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ApOfficeListVO[]
	 */
	public ApOfficeListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ApOfficeListVO[]
	 */
	public ApOfficeListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ApOfficeListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] apOfcCd =	(JSPUtil.getParameter(request, prefix +	"ap_ofc_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] ofcEngNm =	(JSPUtil.getParameter(request, prefix +	"ofc_eng_nm".trim(),	length));
				String[] ofcKrnNm =	(JSPUtil.getParameter(request, prefix +	"ofc_krn_nm".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ApOfficeListVO();
						if ( apOfcCd[i] !=	null)
						model.setApOfcCd( apOfcCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( ofcEngNm[i] !=	null)
						model.setOfcEngNm( ofcEngNm[i]);
						if ( ofcKrnNm[i] !=	null)
						model.setOfcKrnNm( ofcKrnNm[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getApOfficeListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ApOfficeListVO[]
	 */
	public ApOfficeListVO[]	 getApOfficeListVOs(){
		ApOfficeListVO[] vos = (ApOfficeListVO[])models.toArray(new	ApOfficeListVO[models.size()]);
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
		this.apOfcCd =	this.apOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm =	this.ofcEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcKrnNm =	this.ofcKrnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}