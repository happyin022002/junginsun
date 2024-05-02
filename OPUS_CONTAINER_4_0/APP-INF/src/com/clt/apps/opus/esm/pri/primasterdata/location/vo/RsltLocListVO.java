/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : RsltLocListVO.java
 *@FileTitle : RsltLocListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.15
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2015.04.15 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.primasterdata.location.vo;

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
public class RsltLocListVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<RsltLocListVO>  models =	new	ArrayList<RsltLocListVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String scontiNm = null;
	/*	Column Info	*/
	private String locCd = null;
	/*	Column Info	*/
	private String rgnCd = null;
	/*	Column Info	*/
	private String orgDestCd = null;
	/*	Column Info	*/
	private String zipCd = null;
	/*	Column Info	*/
	private String svcScpCd = null;
	/*	Column Info	*/
	private String locNm = null;
	/*	Column Info	*/
	private String scontiCd = null;
	/*	Column Info	*/
	private String steCd = null;
	/*	Column Info	*/
	private String cntCd = null;
	/*	Column Info	*/
	private String unLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public RsltLocListVO(){}

	public RsltLocListVO(String ibflag,String pagerows,String scontiNm,String locCd,String rgnCd,String orgDestCd,String zipCd,String svcScpCd,String locNm,String scontiCd,String steCd,String cntCd,String unLocCd)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.scontiNm = scontiNm;
		this.locCd = locCd;
		this.rgnCd = rgnCd;
		this.orgDestCd = orgDestCd;
		this.zipCd = zipCd;
		this.svcScpCd = svcScpCd;
		this.locNm = locNm;
		this.scontiCd = scontiCd;
		this.steCd = steCd;
		this.cntCd = cntCd;
		this.unLocCd = unLocCd;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sconti_nm", getScontiNm());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("org_dest_cd", getOrgDestCd());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("sconti_cd", getScontiCd());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("un_loc_cd", getUnLocCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sconti_nm", "scontiNm");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("org_dest_cd", "orgDestCd");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("un_loc_cd", "unLocCd");
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
	 * @return scontiNm
	 */
	public	String getScontiNm() {
		return	this.scontiNm;
	}

	/**
	 * Column Info
	 * @return locCd
	 */
	public	String getLocCd() {
		return	this.locCd;
	}

	/**
	 * Column Info
	 * @return rgnCd
	 */
	public	String getRgnCd() {
		return	this.rgnCd;
	}

	/**
	 * Column Info
	 * @return orgDestCd
	 */
	public	String getOrgDestCd() {
		return	this.orgDestCd;
	}

	/**
	 * Column Info
	 * @return zipCd
	 */
	public	String getZipCd() {
		return	this.zipCd;
	}

	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public	String getSvcScpCd() {
		return	this.svcScpCd;
	}

	/**
	 * Column Info
	 * @return locNm
	 */
	public	String getLocNm() {
		return	this.locNm;
	}

	/**
	 * Column Info
	 * @return scontiCd
	 */
	public	String getScontiCd() {
		return	this.scontiCd;
	}

	/**
	 * Column Info
	 * @return steCd
	 */
	public	String getSteCd() {
		return	this.steCd;
	}

	/**
	 * Column Info
	 * @return cntCd
	 */
	public	String getCntCd() {
		return	this.cntCd;
	}

	/**
	 * Column Info
	 * @return unLocCd
	 */
	public	String getUnLocCd() {
		return	this.unLocCd;
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
	 * @param  scontiNm
 	 */
	public void	setScontiNm(String scontiNm ) {
		this.scontiNm =	scontiNm;
	}
 	/**
	 * Column Info
	 * @param  locCd
 	 */
	public void	setLocCd(String locCd ) {
		this.locCd =	locCd;
	}
 	/**
	 * Column Info
	 * @param  rgnCd
 	 */
	public void	setRgnCd(String rgnCd ) {
		this.rgnCd =	rgnCd;
	}
 	/**
	 * Column Info
	 * @param  orgDestCd
 	 */
	public void	setOrgDestCd(String orgDestCd ) {
		this.orgDestCd =	orgDestCd;
	}
 	/**
	 * Column Info
	 * @param  zipCd
 	 */
	public void	setZipCd(String zipCd ) {
		this.zipCd =	zipCd;
	}
 	/**
	 * Column Info
	 * @param  svcScpCd
 	 */
	public void	setSvcScpCd(String svcScpCd ) {
		this.svcScpCd =	svcScpCd;
	}
 	/**
	 * Column Info
	 * @param  locNm
 	 */
	public void	setLocNm(String locNm ) {
		this.locNm =	locNm;
	}
 	/**
	 * Column Info
	 * @param  scontiCd
 	 */
	public void	setScontiCd(String scontiCd ) {
		this.scontiCd =	scontiCd;
	}
 	/**
	 * Column Info
	 * @param  steCd
 	 */
	public void	setSteCd(String steCd ) {
		this.steCd =	steCd;
	}
 	/**
	 * Column Info
	 * @param  cntCd
 	 */
	public void	setCntCd(String cntCd ) {
		this.cntCd =	cntCd;
	}
 	/**
	 * Column Info
	 * @param  unLocCd
 	 */
	public void	setUnLocCd(String unLocCd ) {
		this.unLocCd =	unLocCd;
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
		setScontiNm(JSPUtil.getParameter(request,	prefix + "sconti_nm", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setRgnCd(JSPUtil.getParameter(request,	prefix + "rgn_cd", ""));
		setOrgDestCd(JSPUtil.getParameter(request,	prefix + "org_dest_cd", ""));
		setZipCd(JSPUtil.getParameter(request,	prefix + "zip_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setLocNm(JSPUtil.getParameter(request,	prefix + "loc_nm", ""));
		setScontiCd(JSPUtil.getParameter(request,	prefix + "sconti_cd", ""));
		setSteCd(JSPUtil.getParameter(request,	prefix + "ste_cd", ""));
		setCntCd(JSPUtil.getParameter(request,	prefix + "cnt_cd", ""));
		setUnLocCd(JSPUtil.getParameter(request,	prefix + "un_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltLocListVO[]
	 */
	public RsltLocListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return RsltLocListVO[]
	 */
	public RsltLocListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		RsltLocListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] scontiNm =	(JSPUtil.getParameter(request, prefix +	"sconti_nm",	length));
			String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd",	length));
			String[] rgnCd =	(JSPUtil.getParameter(request, prefix +	"rgn_cd",	length));
			String[] orgDestCd =	(JSPUtil.getParameter(request, prefix +	"org_dest_cd",	length));
			String[] zipCd =	(JSPUtil.getParameter(request, prefix +	"zip_cd",	length));
			String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd",	length));
			String[] locNm =	(JSPUtil.getParameter(request, prefix +	"loc_nm",	length));
			String[] scontiCd =	(JSPUtil.getParameter(request, prefix +	"sconti_cd",	length));
			String[] steCd =	(JSPUtil.getParameter(request, prefix +	"ste_cd",	length));
			String[] cntCd =	(JSPUtil.getParameter(request, prefix +	"cnt_cd",	length));
			String[] unLocCd =	(JSPUtil.getParameter(request, prefix +	"un_loc_cd",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	RsltLocListVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( scontiNm[i] !=	null)
					model.setScontiNm( scontiNm[i]);
				if ( locCd[i] !=	null)
					model.setLocCd( locCd[i]);
				if ( rgnCd[i] !=	null)
					model.setRgnCd( rgnCd[i]);
				if ( orgDestCd[i] !=	null)
					model.setOrgDestCd( orgDestCd[i]);
				if ( zipCd[i] !=	null)
					model.setZipCd( zipCd[i]);
				if ( svcScpCd[i] !=	null)
					model.setSvcScpCd( svcScpCd[i]);
				if ( locNm[i] !=	null)
					model.setLocNm( locNm[i]);
				if ( scontiCd[i] !=	null)
					model.setScontiCd( scontiCd[i]);
				if ( steCd[i] !=	null)
					model.setSteCd( steCd[i]);
				if ( cntCd[i] !=	null)
					model.setCntCd( cntCd[i]);
				if ( unLocCd[i] !=	null)
					model.setUnLocCd( unLocCd[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getRsltLocListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return RsltLocListVO[]
	 */
	public RsltLocListVO[]	 getRsltLocListVOs(){
		RsltLocListVO[] vos = (RsltLocListVO[])models.toArray(new	RsltLocListVO[models.size()]);
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
		this.scontiNm =	this.scontiNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd =	this.rgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestCd =	this.orgDestCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd =	this.zipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm =	this.locNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd =	this.scontiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd =	this.steCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd =	this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unLocCd =	this.unLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}