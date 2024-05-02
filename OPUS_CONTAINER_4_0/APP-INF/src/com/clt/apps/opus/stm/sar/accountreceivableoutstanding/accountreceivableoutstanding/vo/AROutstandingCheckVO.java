/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AROutstandingCheckVO.java
 *@FileTitle : AROutstandingCheckVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.01.27
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.01.27  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

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
public class AROutstandingCheckVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AROutstandingCheckVO>  models =	new	ArrayList<AROutstandingCheckVO>();


	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 chgTpCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 otsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 rhqCd   =  null;
	/*	Column Info	*/
	private  String	 blCurrCd   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ifNo   =  null;
	/*	Column Info	*/
	private  String	 asaFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AROutstandingCheckVO(){}

	public AROutstandingCheckVO(String invNo,String chgTpCd,String ibflag,String otsOfcCd,String rhqCd,String blCurrCd,String blNo,String pagerows,String ifNo,String asaFlg)	{
		this.invNo  = invNo ;
		this.chgTpCd  = chgTpCd ;
		this.ibflag  = ibflag ;
		this.otsOfcCd  = otsOfcCd ;
		this.rhqCd  = rhqCd ;
		this.blCurrCd  = blCurrCd ;
		this.blNo  = blNo ;
		this.pagerows  = pagerows ;
		this.ifNo  = ifNo ;
		this.asaFlg  = asaFlg ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("chg_tp_cd", getChgTpCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());		
		this.hashColumns.put("rhq_cd", getRhqCd());		
		this.hashColumns.put("bl_curr_cd", getBlCurrCd());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("if_no", getIfNo());		
		this.hashColumns.put("asa_flg", getAsaFlg());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bl_curr_cd", "blCurrCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("asa_flg", "asaFlg");
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
	* @param  chgTpCd
	*/
	public void	setChgTpCd( String	chgTpCd ) {
		this.chgTpCd =	chgTpCd;
	}
 
	/**
	 * Column Info
	 * @return	chgTpCd
	 */
	 public	 String	getChgTpCd() {
		 return	this.chgTpCd;
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
	* @param  otsOfcCd
	*/
	public void	setOtsOfcCd( String	otsOfcCd ) {
		this.otsOfcCd =	otsOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	otsOfcCd
	 */
	 public	 String	getOtsOfcCd() {
		 return	this.otsOfcCd;
	 } 
 	/**
	* Column Info
	* @param  rhqCd
	*/
	public void	setRhqCd( String	rhqCd ) {
		this.rhqCd =	rhqCd;
	}
 
	/**
	 * Column Info
	 * @return	rhqCd
	 */
	 public	 String	getRhqCd() {
		 return	this.rhqCd;
	 } 
 	/**
	* Column Info
	* @param  blCurrCd
	*/
	public void	setBlCurrCd( String	blCurrCd ) {
		this.blCurrCd =	blCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	blCurrCd
	 */
	 public	 String	getBlCurrCd() {
		 return	this.blCurrCd;
	 } 
 	/**
	* Column Info
	* @param  blNo
	*/
	public void	setBlNo( String	blNo ) {
		this.blNo =	blNo;
	}
 
	/**
	 * Column Info
	 * @return	blNo
	 */
	 public	 String	getBlNo() {
		 return	this.blNo;
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
	* @param  ifNo
	*/
	public void	setIfNo( String	ifNo ) {
		this.ifNo =	ifNo;
	}
 
	/**
	 * Column Info
	 * @return	ifNo
	 */
	 public	 String	getIfNo() {
		 return	this.ifNo;
	 } 
 	/**
	* Column Info
	* @param  asaFlg
	*/
	public void	setAsaFlg( String	asaFlg ) {
		this.asaFlg =	asaFlg;
	}
 
	/**
	 * Column Info
	 * @return	asaFlg
	 */
	 public	 String	getAsaFlg() {
		 return	this.asaFlg;
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
		setChgTpCd(JSPUtil.getParameter(request,	prefix + "chg_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setOtsOfcCd(JSPUtil.getParameter(request,	prefix + "ots_ofc_cd", ""));
		setRhqCd(JSPUtil.getParameter(request,	prefix + "rhq_cd", ""));
		setBlCurrCd(JSPUtil.getParameter(request,	prefix + "bl_curr_cd", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIfNo(JSPUtil.getParameter(request,	prefix + "if_no", ""));
		setAsaFlg(JSPUtil.getParameter(request,	prefix + "asa_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AROutstandingCheckVO[]
	 */
	public AROutstandingCheckVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AROutstandingCheckVO[]
	 */
	public AROutstandingCheckVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AROutstandingCheckVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] chgTpCd =	(JSPUtil.getParameter(request, prefix +	"chg_tp_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] otsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ots_ofc_cd".trim(),	length));
				String[] rhqCd =	(JSPUtil.getParameter(request, prefix +	"rhq_cd".trim(),	length));
				String[] blCurrCd =	(JSPUtil.getParameter(request, prefix +	"bl_curr_cd".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ifNo =	(JSPUtil.getParameter(request, prefix +	"if_no".trim(),	length));
				String[] asaFlg =	(JSPUtil.getParameter(request, prefix +	"asa_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AROutstandingCheckVO();
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( chgTpCd[i] !=	null)
						model.setChgTpCd( chgTpCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( otsOfcCd[i] !=	null)
						model.setOtsOfcCd( otsOfcCd[i]);
						if ( rhqCd[i] !=	null)
						model.setRhqCd( rhqCd[i]);
						if ( blCurrCd[i] !=	null)
						model.setBlCurrCd( blCurrCd[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ifNo[i] !=	null)
						model.setIfNo( ifNo[i]);
						if ( asaFlg[i] !=	null)
						model.setAsaFlg( asaFlg[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAROutstandingCheckVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return AROutstandingCheckVO[]
	 */
	public AROutstandingCheckVO[]	 getAROutstandingCheckVOs(){
		AROutstandingCheckVO[] vos = (AROutstandingCheckVO[])models.toArray(new	AROutstandingCheckVO[models.size()]);
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
		this.chgTpCd =	this.chgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd =	this.otsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd =	this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCurrCd =	this.blCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo =	this.ifNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaFlg =	this.asaFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}