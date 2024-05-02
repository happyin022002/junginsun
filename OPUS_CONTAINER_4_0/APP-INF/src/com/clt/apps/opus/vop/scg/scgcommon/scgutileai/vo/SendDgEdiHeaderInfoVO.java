/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SendDgEdiHeaderInfoVO.java
 *@FileTitle : SendDgEdiHeaderInfoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.05
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.05 dongsoo 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo;

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
public class SendDgEdiHeaderInfoVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SendDgEdiHeaderInfoVO>  models =	new	ArrayList<SendDgEdiHeaderInfoVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String header = null;
	/*	Column Info	*/
	private String senderId = null;
	/*	Column Info	*/
	private String receiverId = null;
	/*	Column Info	*/
	private String messageType = null;
	/*	Column Info	*/
	private String flatFileReference = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public SendDgEdiHeaderInfoVO(){}

	public SendDgEdiHeaderInfoVO(String ibflag,String pagerows,String header,String senderId,String receiverId,String messageType,String flatFileReference)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.header = header;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.messageType = messageType;
		this.flatFileReference = flatFileReference;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("header", getHeader());
		this.hashColumns.put("sender_id", getSenderId());
		this.hashColumns.put("receiver_id", getReceiverId());
		this.hashColumns.put("message_type", getMessageType());
		this.hashColumns.put("flat_file_reference", getFlatFileReference());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("header", "header");
		this.hashFields.put("sender_id", "senderId");
		this.hashFields.put("receiver_id", "receiverId");
		this.hashFields.put("message_type", "messageType");
		this.hashFields.put("flat_file_reference", "flatFileReference");
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
	 * @return header
	 */
	public	String getHeader() {
		return	this.header;
	}

	/**
	 * Column Info
	 * @return senderId
	 */
	public	String getSenderId() {
		return	this.senderId;
	}

	/**
	 * Column Info
	 * @return receiverId
	 */
	public	String getReceiverId() {
		return	this.receiverId;
	}

	/**
	 * Column Info
	 * @return messageType
	 */
	public	String getMessageType() {
		return	this.messageType;
	}

	/**
	 * Column Info
	 * @return flatFileReference
	 */
	public	String getFlatFileReference() {
		return	this.flatFileReference;
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
	 * @param  header
 	 */
	public void	setHeader(String header ) {
		this.header =	header;
	}
 	/**
	 * Column Info
	 * @param  senderId
 	 */
	public void	setSenderId(String senderId ) {
		this.senderId =	senderId;
	}
 	/**
	 * Column Info
	 * @param  receiverId
 	 */
	public void	setReceiverId(String receiverId ) {
		this.receiverId =	receiverId;
	}
 	/**
	 * Column Info
	 * @param  messageType
 	 */
	public void	setMessageType(String messageType ) {
		this.messageType =	messageType;
	}
 	/**
	 * Column Info
	 * @param  flatFileReference
 	 */
	public void	setFlatFileReference(String flatFileReference ) {
		this.flatFileReference =	flatFileReference;
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
		setHeader(JSPUtil.getParameter(request,	prefix + "header", ""));
		setSenderId(JSPUtil.getParameter(request,	prefix + "sender_id", ""));
		setReceiverId(JSPUtil.getParameter(request,	prefix + "receiver_id", ""));
		setMessageType(JSPUtil.getParameter(request,	prefix + "message_type", ""));
		setFlatFileReference(JSPUtil.getParameter(request,	prefix + "flat_file_reference", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendDgEdiHeaderInfoVO[]
	 */
	public SendDgEdiHeaderInfoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SendDgEdiHeaderInfoVO[]
	 */
	public SendDgEdiHeaderInfoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SendDgEdiHeaderInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] header =	(JSPUtil.getParameter(request, prefix +	"header",	length));
			String[] senderId =	(JSPUtil.getParameter(request, prefix +	"sender_id",	length));
			String[] receiverId =	(JSPUtil.getParameter(request, prefix +	"receiver_id",	length));
			String[] messageType =	(JSPUtil.getParameter(request, prefix +	"message_type",	length));
			String[] flatFileReference =	(JSPUtil.getParameter(request, prefix +	"flat_file_reference",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	SendDgEdiHeaderInfoVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( header[i] !=	null)
					model.setHeader( header[i]);
				if ( senderId[i] !=	null)
					model.setSenderId( senderId[i]);
				if ( receiverId[i] !=	null)
					model.setReceiverId( receiverId[i]);
				if ( messageType[i] !=	null)
					model.setMessageType( messageType[i]);
				if ( flatFileReference[i] !=	null)
					model.setFlatFileReference( flatFileReference[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getSendDgEdiHeaderInfoVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return SendDgEdiHeaderInfoVO[]
	 */
	public SendDgEdiHeaderInfoVO[]	 getSendDgEdiHeaderInfoVOs(){
		SendDgEdiHeaderInfoVO[] vos = (SendDgEdiHeaderInfoVO[])models.toArray(new	SendDgEdiHeaderInfoVO[models.size()]);
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
		this.header =	this.header.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderId =	this.senderId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiverId =	this.receiverId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.messageType =	this.messageType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatFileReference =	this.flatFileReference.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}