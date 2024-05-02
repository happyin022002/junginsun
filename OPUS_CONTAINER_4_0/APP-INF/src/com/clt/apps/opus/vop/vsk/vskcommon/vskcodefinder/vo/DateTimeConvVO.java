/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : DateTimeConvVO.java
 *@FileTitle : DateTimeConvVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.17
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.10.17 dongsoo 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo;

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
 * @author dongsoo
 * @since J2EE 1.6
 * @see	..
 */
public class DateTimeConvVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<DateTimeConvVO>  models =	new	ArrayList<DateTimeConvVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String vpsPortCd = null;
	/*	Column Info	*/
	private String actArrDt = null;
	/*	Column Info	*/
	private String prePortCd = null;
	/*	Column Info	*/
	private String preEtdDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public DateTimeConvVO(){}

	public DateTimeConvVO(String ibflag,String pagerows,String vpsPortCd,String actArrDt,String prePortCd,String preEtdDt)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.actArrDt = actArrDt;
		this.prePortCd = prePortCd;
		this.preEtdDt = preEtdDt;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("act_arr_dt", getActArrDt());
		this.hashColumns.put("pre_port_cd", getPrePortCd());
		this.hashColumns.put("pre_etd_dt", getPreEtdDt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("act_arr_dt", "actArrDt");
		this.hashFields.put("pre_port_cd", "prePortCd");
		this.hashFields.put("pre_etd_dt", "preEtdDt");
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
	 * @return vpsPortCd
	 */
	public	String getVpsPortCd() {
		return	this.vpsPortCd;
	}

	/**
	 * Column Info
	 * @return actArrDt
	 */
	public	String getActArrDt() {
		return	this.actArrDt;
	}

	/**
	 * Column Info
	 * @return prePortCd
	 */
	public	String getPrePortCd() {
		return	this.prePortCd;
	}

	/**
	 * Column Info
	 * @return preEtdDt
	 */
	public	String getPreEtdDt() {
		return	this.preEtdDt;
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
	 * @param  vpsPortCd
 	 */
	public void	setVpsPortCd(String vpsPortCd ) {
		this.vpsPortCd =	vpsPortCd;
	}
 	/**
	 * Column Info
	 * @param  actArrDt
 	 */
	public void	setActArrDt(String actArrDt ) {
		this.actArrDt =	actArrDt;
	}
 	/**
	 * Column Info
	 * @param  prePortCd
 	 */
	public void	setPrePortCd(String prePortCd ) {
		this.prePortCd =	prePortCd;
	}
 	/**
	 * Column Info
	 * @param  preEtdDt
 	 */
	public void	setPreEtdDt(String preEtdDt ) {
		this.preEtdDt =	preEtdDt;
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
		setVpsPortCd(JSPUtil.getParameter(request,	prefix + "vps_port_cd", ""));
		setActArrDt(JSPUtil.getParameter(request,	prefix + "act_arr_dt", ""));
		setPrePortCd(JSPUtil.getParameter(request,	prefix + "pre_port_cd", ""));
		setPreEtdDt(JSPUtil.getParameter(request,	prefix + "pre_etd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DateTimeConvVO[]
	 */
	public DateTimeConvVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DateTimeConvVO[]
	 */
	public DateTimeConvVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		DateTimeConvVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] vpsPortCd =	(JSPUtil.getParameter(request, prefix +	"vps_port_cd",	length));
			String[] actArrDt =	(JSPUtil.getParameter(request, prefix +	"act_arr_dt",	length));
			String[] prePortCd =	(JSPUtil.getParameter(request, prefix +	"pre_port_cd",	length));
			String[] preEtdDt =	(JSPUtil.getParameter(request, prefix +	"pre_etd_dt",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	DateTimeConvVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( vpsPortCd[i] !=	null)
					model.setVpsPortCd( vpsPortCd[i]);
				if ( actArrDt[i] !=	null)
					model.setActArrDt( actArrDt[i]);
				if ( prePortCd[i] !=	null)
					model.setPrePortCd( prePortCd[i]);
				if ( preEtdDt[i] !=	null)
					model.setPreEtdDt( preEtdDt[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getDateTimeConvVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return DateTimeConvVO[]
	 */
	public DateTimeConvVO[]	 getDateTimeConvVOs(){
		DateTimeConvVO[] vos = (DateTimeConvVO[])models.toArray(new	DateTimeConvVO[models.size()]);
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
		this.vpsPortCd =	this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actArrDt =	this.actArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePortCd =	this.prePortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEtdDt =	this.preEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}