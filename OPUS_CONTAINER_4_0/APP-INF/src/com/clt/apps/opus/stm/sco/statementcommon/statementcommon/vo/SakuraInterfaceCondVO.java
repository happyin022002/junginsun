/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SakuraInterfaceCondVO.java
 *@FileTitle : SakuraInterfaceCondVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.04.20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.04.20  
 * 1.0 Creation
=========================================================*/

//package	 com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo;
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo;
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
public class SakuraInterfaceCondVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SakuraInterfaceCondVO>  models =	new	ArrayList<SakuraInterfaceCondVO>();


	/*	Column Info	*/
	private  String	 ifDocTpCd   =  null;
	/*	Column Info	*/
	private  String	 pstDtFm   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 asgnNo   =  null;
	/*	Column Info	*/
	private  String	 refDocNo   =  null;
	/*	Column Info	*/
	private  String	 ifFlg   =  null;
	/*	Column Info	*/
	private  String	 pstDtTo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 module   =  null;
	/*	Column Info	*/
	private  String	 ifDtFm   =  null;
	/*	Column Info	*/
	private  String	 ifDtTo   =  null;
	/*	Column Info	*/
	private  String	 iPage   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public SakuraInterfaceCondVO(){}

	public SakuraInterfaceCondVO(String ifDocTpCd,String pstDtFm,String ibflag,String asgnNo,String refDocNo,String ifFlg,String pstDtTo,String pagerows,String module,String ifDtFm,String ifDtTo,String iPage)	{
		this.ifDocTpCd  = ifDocTpCd ;
		this.pstDtFm  = pstDtFm ;
		this.ibflag  = ibflag ;
		this.asgnNo  = asgnNo ;
		this.refDocNo  = refDocNo ;
		this.ifFlg  = ifFlg ;
		this.pstDtTo  = pstDtTo ;
		this.pagerows  = pagerows ;
		this.module  = module ;
		this.ifDtFm  = ifDtFm ;
		this.ifDtTo  = ifDtTo ;
		this.iPage  = iPage ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_doc_tp_cd", getIfDocTpCd());		
		this.hashColumns.put("pst_dt_fm", getPstDtFm());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("asgn_no", getAsgnNo());		
		this.hashColumns.put("ref_doc_no", getRefDocNo());		
		this.hashColumns.put("if_flg", getIfFlg());		
		this.hashColumns.put("pst_dt_to", getPstDtTo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("module", getModule());		
		this.hashColumns.put("if_dt_fm", getIfDtFm());		
		this.hashColumns.put("if_dt_to", getIfDtTo());		
		this.hashColumns.put("i_page", getIPage());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("if_doc_tp_cd", "ifDocTpCd");
		this.hashFields.put("pst_dt_fm", "pstDtFm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("asgn_no", "asgnNo");
		this.hashFields.put("ref_doc_no", "refDocNo");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("pst_dt_to", "pstDtTo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("module", "module");
		this.hashFields.put("if_dt_fm", "ifDtFm");
		this.hashFields.put("if_dt_to", "ifDtTo");
		this.hashFields.put("i_page", "iPage");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  ifDocTpCd
	*/
	public void	setIfDocTpCd( String	ifDocTpCd ) {
		this.ifDocTpCd =	ifDocTpCd;
	}
 
	/**
	 * Column Info
	 * @return	ifDocTpCd
	 */
	 public	 String	getIfDocTpCd() {
		 return	this.ifDocTpCd;
	 } 
 	/**
	* Column Info
	* @param  pstDtFm
	*/
	public void	setPstDtFm( String	pstDtFm ) {
		this.pstDtFm =	pstDtFm;
	}
 
	/**
	 * Column Info
	 * @return	pstDtFm
	 */
	 public	 String	getPstDtFm() {
		 return	this.pstDtFm;
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
	* @param  asgnNo
	*/
	public void	setAsgnNo( String	asgnNo ) {
		this.asgnNo =	asgnNo;
	}
 
	/**
	 * Column Info
	 * @return	asgnNo
	 */
	 public	 String	getAsgnNo() {
		 return	this.asgnNo;
	 } 
 	/**
	* Column Info
	* @param  refDocNo
	*/
	public void	setRefDocNo( String	refDocNo ) {
		this.refDocNo =	refDocNo;
	}
 
	/**
	 * Column Info
	 * @return	refDocNo
	 */
	 public	 String	getRefDocNo() {
		 return	this.refDocNo;
	 } 
 	/**
	* Column Info
	* @param  ifFlg
	*/
	public void	setIfFlg( String	ifFlg ) {
		this.ifFlg =	ifFlg;
	}
 
	/**
	 * Column Info
	 * @return	ifFlg
	 */
	 public	 String	getIfFlg() {
		 return	this.ifFlg;
	 } 
 	/**
	* Column Info
	* @param  pstDtTo
	*/
	public void	setPstDtTo( String	pstDtTo ) {
		this.pstDtTo =	pstDtTo;
	}
 
	/**
	 * Column Info
	 * @return	pstDtTo
	 */
	 public	 String	getPstDtTo() {
		 return	this.pstDtTo;
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
	* @param  module
	*/
	public void	setModule( String	module ) {
		this.module =	module;
	}
 
	/**
	 * Column Info
	 * @return	module
	 */
	 public	 String	getModule() {
		 return	this.module;
	 } 
 	/**
	* Column Info
	* @param  ifDtFm
	*/
	public void	setIfDtFm( String	ifDtFm ) {
		this.ifDtFm =	ifDtFm;
	}
 
	/**
	 * Column Info
	 * @return	ifDtFm
	 */
	 public	 String	getIfDtFm() {
		 return	this.ifDtFm;
	 } 
 	/**
	* Column Info
	* @param  ifDtTo
	*/
	public void	setIfDtTo( String	ifDtTo ) {
		this.ifDtTo =	ifDtTo;
	}
 
	/**
	 * Column Info
	 * @return	ifDtTo
	 */
	 public	 String	getIfDtTo() {
		 return	this.ifDtTo;
	 } 
 	/**
	* Column Info
	* @param  iPage
	*/
	public void	setIPage( String	iPage ) {
		this.iPage =	iPage;
	}
 
	/**
	 * Column Info
	 * @return	iPage
	 */
	 public	 String	getIPage() {
		 return	this.iPage;
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
		setIfDocTpCd(JSPUtil.getParameter(request,	prefix + "if_doc_tp_cd", ""));
		setPstDtFm(JSPUtil.getParameter(request,	prefix + "pst_dt_fm", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAsgnNo(JSPUtil.getParameter(request,	prefix + "asgn_no", ""));
		setRefDocNo(JSPUtil.getParameter(request,	prefix + "ref_doc_no", ""));
		setIfFlg(JSPUtil.getParameter(request,	prefix + "if_flg", ""));
		setPstDtTo(JSPUtil.getParameter(request,	prefix + "pst_dt_to", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setModule(JSPUtil.getParameter(request,	prefix + "module", ""));
		setIfDtFm(JSPUtil.getParameter(request,	prefix + "if_dt_fm", ""));
		setIfDtTo(JSPUtil.getParameter(request,	prefix + "if_dt_to", ""));
		setIPage(JSPUtil.getParameter(request,	prefix + "i_page", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SakuraInterfaceCondVO[]
	 */
	public SakuraInterfaceCondVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SakuraInterfaceCondVO[]
	 */
	public SakuraInterfaceCondVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SakuraInterfaceCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ifDocTpCd =	(JSPUtil.getParameter(request, prefix +	"if_doc_tp_cd".trim(),	length));
				String[] pstDtFm =	(JSPUtil.getParameter(request, prefix +	"pst_dt_fm".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] asgnNo =	(JSPUtil.getParameter(request, prefix +	"asgn_no".trim(),	length));
				String[] refDocNo =	(JSPUtil.getParameter(request, prefix +	"ref_doc_no".trim(),	length));
				String[] ifFlg =	(JSPUtil.getParameter(request, prefix +	"if_flg".trim(),	length));
				String[] pstDtTo =	(JSPUtil.getParameter(request, prefix +	"pst_dt_to".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] module =	(JSPUtil.getParameter(request, prefix +	"module".trim(),	length));
				String[] ifDtFm =	(JSPUtil.getParameter(request, prefix +	"if_dt_fm".trim(),	length));
				String[] ifDtTo =	(JSPUtil.getParameter(request, prefix +	"if_dt_to".trim(),	length));
				String[] iPage =	(JSPUtil.getParameter(request, prefix +	"i_page".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	SakuraInterfaceCondVO();
						if ( ifDocTpCd[i] !=	null)
						model.setIfDocTpCd( ifDocTpCd[i]);
						if ( pstDtFm[i] !=	null)
						model.setPstDtFm( pstDtFm[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( asgnNo[i] !=	null)
						model.setAsgnNo( asgnNo[i]);
						if ( refDocNo[i] !=	null)
						model.setRefDocNo( refDocNo[i]);
						if ( ifFlg[i] !=	null)
						model.setIfFlg( ifFlg[i]);
						if ( pstDtTo[i] !=	null)
						model.setPstDtTo( pstDtTo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( module[i] !=	null)
						model.setModule( module[i]);
						if ( ifDtFm[i] !=	null)
						model.setIfDtFm( ifDtFm[i]);
						if ( ifDtTo[i] !=	null)
						model.setIfDtTo( ifDtTo[i]);
						if ( iPage[i] !=	null)
						model.setIPage( iPage[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getSakuraInterfaceCondVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return SakuraInterfaceCondVO[]
	 */
	public SakuraInterfaceCondVO[]	 getSakuraInterfaceCondVOs(){
		SakuraInterfaceCondVO[] vos = (SakuraInterfaceCondVO[])models.toArray(new	SakuraInterfaceCondVO[models.size()]);
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
		this.ifDocTpCd =	this.ifDocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstDtFm =	this.pstDtFm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnNo =	this.asgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refDocNo =	this.refDocNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg =	this.ifFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstDtTo =	this.pstDtTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.module =	this.module.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifDtFm =	this.ifDtFm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifDtTo =	this.ifDtTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage =	this.iPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}