/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : BLMaxIfNoVO.java
 *@FileTitle : BLMaxIfNoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.09.13
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.09.13  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
public class BLMaxIfNoVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<BLMaxIfNoVO>  models =	new	ArrayList<BLMaxIfNoVO>();


	/*	Column Info	*/
	private  String	 blSrcNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 maxArIfNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 blCnt   =  null;
	/*	Column Info	*/
	private  String	 invDeltDivCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public BLMaxIfNoVO(){}

	public BLMaxIfNoVO(String blSrcNo,String ibflag,String maxArIfNo,String pagerows,String blCnt,String invDeltDivCd)	{
		this.blSrcNo  = blSrcNo ;
		this.ibflag  = ibflag ;
		this.maxArIfNo  = maxArIfNo ;
		this.pagerows  = pagerows ;
		this.blCnt  = blCnt ;
		this.invDeltDivCd  = invDeltDivCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("max_ar_if_no", getMaxArIfNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("bl_cnt", getBlCnt());		
		this.hashColumns.put("inv_delt_div_cd", getInvDeltDivCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("max_ar_if_no", "maxArIfNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_cnt", "blCnt");
		this.hashFields.put("inv_delt_div_cd", "invDeltDivCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  blSrcNo
	*/
	public void	setBlSrcNo( String	blSrcNo ) {
		this.blSrcNo =	blSrcNo;
	}
 
	/**
	 * Column Info
	 * @return	blSrcNo
	 */
	 public	 String	getBlSrcNo() {
		 return	this.blSrcNo;
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
	* @param  maxArIfNo
	*/
	public void	setMaxArIfNo( String	maxArIfNo ) {
		this.maxArIfNo =	maxArIfNo;
	}
 
	/**
	 * Column Info
	 * @return	maxArIfNo
	 */
	 public	 String	getMaxArIfNo() {
		 return	this.maxArIfNo;
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
	* @param  blCnt
	*/
	public void	setBlCnt( String	blCnt ) {
		this.blCnt =	blCnt;
	}
 
	/**
	 * Column Info
	 * @return	blCnt
	 */
	 public	 String	getBlCnt() {
		 return	this.blCnt;
	 } 
 	/**
	* Column Info
	* @param  invDeltDivCd
	*/
	public void	setInvDeltDivCd( String	invDeltDivCd ) {
		this.invDeltDivCd =	invDeltDivCd;
	}
 
	/**
	 * Column Info
	 * @return	invDeltDivCd
	 */
	 public	 String	getInvDeltDivCd() {
		 return	this.invDeltDivCd;
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
		setBlSrcNo(JSPUtil.getParameter(request,	prefix + "bl_src_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setMaxArIfNo(JSPUtil.getParameter(request,	prefix + "max_ar_if_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setBlCnt(JSPUtil.getParameter(request,	prefix + "bl_cnt", ""));
		setInvDeltDivCd(JSPUtil.getParameter(request,	prefix + "inv_delt_div_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BLMaxIfNoVO[]
	 */
	public BLMaxIfNoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BLMaxIfNoVO[]
	 */
	public BLMaxIfNoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		BLMaxIfNoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] maxArIfNo =	(JSPUtil.getParameter(request, prefix +	"max_ar_if_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] blCnt =	(JSPUtil.getParameter(request, prefix +	"bl_cnt".trim(),	length));
				String[] invDeltDivCd =	(JSPUtil.getParameter(request, prefix +	"inv_delt_div_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	BLMaxIfNoVO();
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( maxArIfNo[i] !=	null)
						model.setMaxArIfNo( maxArIfNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( blCnt[i] !=	null)
						model.setBlCnt( blCnt[i]);
						if ( invDeltDivCd[i] !=	null)
						model.setInvDeltDivCd( invDeltDivCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getBLMaxIfNoVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return BLMaxIfNoVO[]
	 */
	public BLMaxIfNoVO[]	 getBLMaxIfNoVOs(){
		BLMaxIfNoVO[] vos = (BLMaxIfNoVO[])models.toArray(new	BLMaxIfNoVO[models.size()]);
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
		this.blSrcNo =	this.blSrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxArIfNo =	this.maxArIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt =	this.blCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDeltDivCd =	this.invDeltDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}