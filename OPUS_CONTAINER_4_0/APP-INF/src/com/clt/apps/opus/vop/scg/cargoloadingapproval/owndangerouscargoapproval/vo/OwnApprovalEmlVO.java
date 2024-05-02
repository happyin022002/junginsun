/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : OwnApprovalEmlVO.java
 *@FileTitle : OwnApprovalEmlVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.16
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.16 dongsoo 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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
public class OwnApprovalEmlVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<OwnApprovalEmlVO>  models =	new	ArrayList<OwnApprovalEmlVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String fromEml = null;
	/*	Column Info	*/
	private String globalName = null;
	/*	Column Info	*/
	private String ccEml = null;
	/*	Column Info	*/
	private String toEml = null;
	/*	Column Info	*/
	private String bookingNo = null;
	/*	Column Info	*/
	private String userNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public OwnApprovalEmlVO(){}

	public OwnApprovalEmlVO(String ibflag,String pagerows,String fromEml,String globalName,String ccEml,String toEml,String bookingNo,String userNm)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.fromEml = fromEml;
		this.globalName = globalName;
		this.ccEml = ccEml;
		this.toEml = toEml;
		this.bookingNo = bookingNo;
		this.userNm = userNm;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("from_eml", getFromEml());
		this.hashColumns.put("global_name", getGlobalName());
		this.hashColumns.put("cc_eml", getCcEml());
		this.hashColumns.put("to_eml", getToEml());
		this.hashColumns.put("booking_no", getBookingNo());
		this.hashColumns.put("user_nm", getUserNm());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("from_eml", "fromEml");
		this.hashFields.put("global_name", "globalName");
		this.hashFields.put("cc_eml", "ccEml");
		this.hashFields.put("to_eml", "toEml");
		this.hashFields.put("booking_no", "bookingNo");
		this.hashFields.put("user_nm", "userNm");
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
	 * @return fromEml
	 */
	public	String getFromEml() {
		return	this.fromEml;
	}

	/**
	 * Column Info
	 * @return globalName
	 */
	public	String getGlobalName() {
		return	this.globalName;
	}

	/**
	 * Column Info
	 * @return ccEml
	 */
	public	String getCcEml() {
		return	this.ccEml;
	}

	/**
	 * Column Info
	 * @return toEml
	 */
	public	String getToEml() {
		return	this.toEml;
	}

	/**
	 * Column Info
	 * @return bookingNo
	 */
	public	String getBookingNo() {
		return	this.bookingNo;
	}

	/**
	 * Column Info
	 * @return userNm
	 */
	public	String getUserNm() {
		return	this.userNm;
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
	 * @param  fromEml
 	 */
	public void	setFromEml(String fromEml ) {
		this.fromEml =	fromEml;
	}
 	/**
	 * Column Info
	 * @param  globalName
 	 */
	public void	setGlobalName(String globalName ) {
		this.globalName =	globalName;
	}
 	/**
	 * Column Info
	 * @param  ccEml
 	 */
	public void	setCcEml(String ccEml ) {
		this.ccEml =	ccEml;
	}
 	/**
	 * Column Info
	 * @param  toEml
 	 */
	public void	setToEml(String toEml ) {
		this.toEml =	toEml;
	}
 	/**
	 * Column Info
	 * @param  bookingNo
 	 */
	public void	setBookingNo(String bookingNo ) {
		this.bookingNo =	bookingNo;
	}
 	/**
	 * Column Info
	 * @param  userNm
 	 */
	public void	setUserNm(String userNm ) {
		this.userNm =	userNm;
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
		setFromEml(JSPUtil.getParameter(request,	prefix + "from_eml", ""));
		setGlobalName(JSPUtil.getParameter(request,	prefix + "global_name", ""));
		setCcEml(JSPUtil.getParameter(request,	prefix + "cc_eml", ""));
		setToEml(JSPUtil.getParameter(request,	prefix + "to_eml", ""));
		setBookingNo(JSPUtil.getParameter(request,	prefix + "booking_no", ""));
		setUserNm(JSPUtil.getParameter(request,	prefix + "user_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OwnApprovalEmlVO[]
	 */
	public OwnApprovalEmlVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return OwnApprovalEmlVO[]
	 */
	public OwnApprovalEmlVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		OwnApprovalEmlVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] fromEml =	(JSPUtil.getParameter(request, prefix +	"from_eml",	length));
			String[] globalName =	(JSPUtil.getParameter(request, prefix +	"global_name",	length));
			String[] ccEml =	(JSPUtil.getParameter(request, prefix +	"cc_eml",	length));
			String[] toEml =	(JSPUtil.getParameter(request, prefix +	"to_eml",	length));
			String[] bookingNo =	(JSPUtil.getParameter(request, prefix +	"booking_no",	length));
			String[] userNm =	(JSPUtil.getParameter(request, prefix +	"user_nm",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	OwnApprovalEmlVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( fromEml[i] !=	null)
					model.setFromEml( fromEml[i]);
				if ( globalName[i] !=	null)
					model.setGlobalName( globalName[i]);
				if ( ccEml[i] !=	null)
					model.setCcEml( ccEml[i]);
				if ( toEml[i] !=	null)
					model.setToEml( toEml[i]);
				if ( bookingNo[i] !=	null)
					model.setBookingNo( bookingNo[i]);
				if ( userNm[i] !=	null)
					model.setUserNm( userNm[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getOwnApprovalEmlVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return OwnApprovalEmlVO[]
	 */
	public OwnApprovalEmlVO[]	 getOwnApprovalEmlVOs(){
		OwnApprovalEmlVO[] vos = (OwnApprovalEmlVO[])models.toArray(new	OwnApprovalEmlVO[models.size()]);
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
		this.fromEml =	this.fromEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.globalName =	this.globalName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccEml =	this.ccEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEml =	this.toEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingNo =	this.bookingNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userNm =	this.userNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}