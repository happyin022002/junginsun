/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SendFlatFileVO.java
 *@FileTitle : SendFlatFileVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.03
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.03 dongsoo 
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
public class SendFlatFileVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SendFlatFileVO>  models =	new	ArrayList<SendFlatFileVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String queueNm = null;
	/*	Column Info	*/
	private String rcvId = null;
	/*	Column Info	*/
	private String flatFile = null;
	/*	Column Info	*/
	private String senderId = null;
	/*	Column Info	*/
	private String target = null;
	/*	Column Info	*/
	private String transferType = null;
	/*	Column Info	*/
	private String channel = null;
	/*	Column Info	*/
	private String factory = null;
	/*	Column Info	*/
	private String targetClient = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public SendFlatFileVO(){}

	public SendFlatFileVO(String ibflag,String pagerows,String queueNm,String rcvId,String flatFile,String senderId,String target,String transferType,String channel,String factory,String targetClient)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.queueNm = queueNm;
		this.rcvId = rcvId;
		this.flatFile = flatFile;
		this.senderId = senderId;
		this.target = target;
		this.transferType = transferType;
		this.channel = channel;
		this.factory = factory;
		this.targetClient = targetClient;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("queue_nm", getQueueNm());
		this.hashColumns.put("rcv_id", getRcvId());
		this.hashColumns.put("flat_file", getFlatFile());
		this.hashColumns.put("sender_id", getSenderId());
		this.hashColumns.put("target", getTarget());
		this.hashColumns.put("transfer_type", getTransferType());
		this.hashColumns.put("channel", getChannel());
		this.hashColumns.put("factory", getFactory());
		this.hashColumns.put("target_client", getTargetClient());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("queue_nm", "queueNm");
		this.hashFields.put("rcv_id", "rcvId");
		this.hashFields.put("flat_file", "flatFile");
		this.hashFields.put("sender_id", "senderId");
		this.hashFields.put("target", "target");
		this.hashFields.put("transfer_type", "transferType");
		this.hashFields.put("channel", "channel");
		this.hashFields.put("factory", "factory");
		this.hashFields.put("target_client", "targetClient");
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
	 * @return queueNm
	 */
	public	String getQueueNm() {
		return	this.queueNm;
	}

	/**
	 * Column Info
	 * @return rcvId
	 */
	public	String getRcvId() {
		return	this.rcvId;
	}

	/**
	 * Column Info
	 * @return flatFile
	 */
	public	String getFlatFile() {
		return	this.flatFile;
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
	 * @return target
	 */
	public	String getTarget() {
		return	this.target;
	}

	/**
	 * Column Info
	 * @return transferType
	 */
	public	String getTransferType() {
		return	this.transferType;
	}

	/**
	 * Column Info
	 * @return channel
	 */
	public	String getChannel() {
		return	this.channel;
	}

	/**
	 * Column Info
	 * @return factory
	 */
	public	String getFactory() {
		return	this.factory;
	}

	/**
	 * Column Info
	 * @return targetClient
	 */
	public	String getTargetClient() {
		return	this.targetClient;
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
	 * @param  queueNm
 	 */
	public void	setQueueNm(String queueNm ) {
		this.queueNm =	queueNm;
	}
 	/**
	 * Column Info
	 * @param  rcvId
 	 */
	public void	setRcvId(String rcvId ) {
		this.rcvId =	rcvId;
	}
 	/**
	 * Column Info
	 * @param  flatFile
 	 */
	public void	setFlatFile(String flatFile ) {
		this.flatFile =	flatFile;
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
	 * @param  target
 	 */
	public void	setTarget(String target ) {
		this.target =	target;
	}
 	/**
	 * Column Info
	 * @param  transferType
 	 */
	public void	setTransferType(String transferType ) {
		this.transferType =	transferType;
	}
 	/**
	 * Column Info
	 * @param  channel
 	 */
	public void	setChannel(String channel ) {
		this.channel =	channel;
	}
 	/**
	 * Column Info
	 * @param  factory
 	 */
	public void	setFactory(String factory ) {
		this.factory =	factory;
	}
 	/**
	 * Column Info
	 * @param  targetClient
 	 */
	public void	setTargetClient(String targetClient ) {
		this.targetClient =	targetClient;
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
		setQueueNm(JSPUtil.getParameter(request,	prefix + "queue_nm", ""));
		setRcvId(JSPUtil.getParameter(request,	prefix + "rcv_id", ""));
		setFlatFile(JSPUtil.getParameter(request,	prefix + "flat_file", ""));
		setSenderId(JSPUtil.getParameter(request,	prefix + "sender_id", ""));
		setTarget(JSPUtil.getParameter(request,	prefix + "target", ""));
		setTransferType(JSPUtil.getParameter(request,	prefix + "transfer_type", ""));
		setChannel(JSPUtil.getParameter(request,	prefix + "channel", ""));
		setFactory(JSPUtil.getParameter(request,	prefix + "factory", ""));
		setTargetClient(JSPUtil.getParameter(request,	prefix + "target_client", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendFlatFileVO[]
	 */
	public SendFlatFileVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SendFlatFileVO[]
	 */
	public SendFlatFileVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SendFlatFileVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] queueNm =	(JSPUtil.getParameter(request, prefix +	"queue_nm",	length));
			String[] rcvId =	(JSPUtil.getParameter(request, prefix +	"rcv_id",	length));
			String[] flatFile =	(JSPUtil.getParameter(request, prefix +	"flat_file",	length));
			String[] senderId =	(JSPUtil.getParameter(request, prefix +	"sender_id",	length));
			String[] target =	(JSPUtil.getParameter(request, prefix +	"target",	length));
			String[] transferType =	(JSPUtil.getParameter(request, prefix +	"transfer_type",	length));
			String[] channel =	(JSPUtil.getParameter(request, prefix +	"channel",	length));
			String[] factory =	(JSPUtil.getParameter(request, prefix +	"factory",	length));
			String[] targetClient =	(JSPUtil.getParameter(request, prefix +	"target_client",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	SendFlatFileVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( queueNm[i] !=	null)
					model.setQueueNm( queueNm[i]);
				if ( rcvId[i] !=	null)
					model.setRcvId( rcvId[i]);
				if ( flatFile[i] !=	null)
					model.setFlatFile( flatFile[i]);
				if ( senderId[i] !=	null)
					model.setSenderId( senderId[i]);
				if ( target[i] !=	null)
					model.setTarget( target[i]);
				if ( transferType[i] !=	null)
					model.setTransferType( transferType[i]);
				if ( channel[i] !=	null)
					model.setChannel( channel[i]);
				if ( factory[i] !=	null)
					model.setFactory( factory[i]);
				if ( targetClient[i] !=	null)
					model.setTargetClient( targetClient[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getSendFlatFileVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return SendFlatFileVO[]
	 */
	public SendFlatFileVO[]	 getSendFlatFileVOs(){
		SendFlatFileVO[] vos = (SendFlatFileVO[])models.toArray(new	SendFlatFileVO[models.size()]);
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
		this.queueNm =	this.queueNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvId =	this.rcvId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatFile =	this.flatFile.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderId =	this.senderId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.target =	this.target.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transferType =	this.transferType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.channel =	this.channel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.factory =	this.factory.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetClient =	this.targetClient.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}