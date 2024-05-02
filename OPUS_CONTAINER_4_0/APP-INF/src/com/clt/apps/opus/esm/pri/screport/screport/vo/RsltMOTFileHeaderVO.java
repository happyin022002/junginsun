/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : RsltMOTFileHeaderVO.java
 *@FileTitle : RsltMOTFileHeaderVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.06
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2015.01.06 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.vo;

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
 * @author jaewonLee
 * @since J2EE 1.6
 * @see	..
 */
public class RsltMOTFileHeaderVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<RsltMOTFileHeaderVO>  models =	new	ArrayList<RsltMOTFileHeaderVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String chgLst = null;
	/*	Column Info	*/
	private String chgTy = null;
	/*	Column Info	*/
	private String ind = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public RsltMOTFileHeaderVO(){}

	public RsltMOTFileHeaderVO(String ibflag,String pagerows,String chgLst,String chgTy,String ind)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.chgLst = chgLst;
		this.chgTy = chgTy;
		this.ind = ind;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chg_lst", getChgLst());
		this.hashColumns.put("chg_ty", getChgTy());
		this.hashColumns.put("ind", getInd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chg_lst", "chgLst");
		this.hashFields.put("chg_ty", "chgTy");
		this.hashFields.put("ind", "ind");
		return this.hashFields;
	}

	//	Getters	and	Setters

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public	String getIbflag() {
		return	this.ibflag;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public	String getPagerows() {
		return	this.pagerows;
	}

	/**
	 * Column Info
	 * @return chgLst
	 */
	public	String getChgLst() {
		return	this.chgLst;
	}

	/**
	 * Column Info
	 * @return chgTy
	 */
	public	String getChgTy() {
		return	this.chgTy;
	}

	/**
	 * Column Info
	 * @return ind
	 */
	public	String getInd() {
		return	this.ind;
	}

 	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
	public void	setIbflag(String ibflag ) {
		this.ibflag =	ibflag;
	}
 	/**
	 * Page Number
	 * @param  pagerows
 	 */
	public void	setPagerows(String pagerows ) {
		this.pagerows =	pagerows;
	}
 	/**
	 * Column Info
	 * @param  chgLst
 	 */
	public void	setChgLst(String chgLst ) {
		this.chgLst =	chgLst;
	}
 	/**
	 * Column Info
	 * @param  chgTy
 	 */
	public void	setChgTy(String chgTy ) {
		this.chgTy =	chgTy;
	}
 	/**
	 * Column Info
	 * @param  ind
 	 */
	public void	setInd(String ind ) {
		this.ind =	ind;
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
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setChgLst(JSPUtil.getParameter(request,	prefix + "chg_lst", ""));
		setChgTy(JSPUtil.getParameter(request,	prefix + "chg_ty", ""));
		setInd(JSPUtil.getParameter(request,	prefix + "ind", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltMOTFileHeaderVO[]
	 */
	public RsltMOTFileHeaderVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return RsltMOTFileHeaderVO[]
	 */
	public RsltMOTFileHeaderVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		RsltMOTFileHeaderVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] chgLst =	(JSPUtil.getParameter(request, prefix +	"chg_lst",	length));
			String[] chgTy =	(JSPUtil.getParameter(request, prefix +	"chg_ty",	length));
			String[] ind =	(JSPUtil.getParameter(request, prefix +	"ind",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	RsltMOTFileHeaderVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( chgLst[i] !=	null)
					model.setChgLst( chgLst[i]);
				if ( chgTy[i] !=	null)
					model.setChgTy( chgTy[i]);
				if ( ind[i] !=	null)
					model.setInd( ind[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getRsltMOTFileHeaderVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return RsltMOTFileHeaderVO[]
	 */
	public RsltMOTFileHeaderVO[]	 getRsltMOTFileHeaderVOs(){
		RsltMOTFileHeaderVO[] vos = (RsltMOTFileHeaderVO[])models.toArray(new	RsltMOTFileHeaderVO[models.size()]);
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
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgLst =	this.chgLst.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTy =	this.chgTy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ind =	this.ind.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}