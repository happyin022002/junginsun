/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomSendEmailVO.java
*@FileTitle : CustomSendEmailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.29 정윤태 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0079HTMLAction
 */

public class CustomSendEmailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomSendEmailVO> models = new ArrayList<CustomSendEmailVO>();
	
	/* Column Info */
	private String template = null;
	/* Column Info */
	private String argument = null;
	/* Column Info */
	private String content = null;
	/* Column Info */
	private String blindCarbonCopy = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String carbonCopy = null;
	/* Column Info */
	private String subject = null;
	/* Column Info */
	private String fileKey = null;
	/* Column Info */
	private String recipient = null;
	/* Column Info */
	private String from = null;
	/* Column Info */
	private String signature = null;
	
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public CustomSendEmailVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String from, String carbonCopy, String blindCarbonCopy, String subject, String content, String fileKey, String recipient, String argument, String template, String signature
	 * @return 
	 */
	public CustomSendEmailVO(String ibflag, String pagerows, String from, String carbonCopy, String blindCarbonCopy, String subject, String content, String fileKey, String recipient, String argument, String template, String signature) {
		this.template = template;
		this.argument = argument;
		this.content = content;
		this.blindCarbonCopy = blindCarbonCopy;
		this.ibflag = ibflag;
		this.carbonCopy = carbonCopy;
		this.subject = subject;
		this.fileKey = fileKey;
		this.recipient = recipient;
		this.from = from;
		this.signature = signature;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("template", getTemplate());
		this.hashColumns.put("argument", getArgument());
		this.hashColumns.put("content", getContent());
		this.hashColumns.put("blindCarbonCopy", getBlindCarbonCopy());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("carbonCopy", getCarbonCopy());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("fileKey", getFileKey());
		this.hashColumns.put("recipient", getRecipient());
		this.hashColumns.put("from", getFrom());
		this.hashColumns.put("signature", getSignature());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("template", "template");
		this.hashFields.put("argument", "argument");
		this.hashFields.put("content", "content");
		this.hashFields.put("blindCarbonCopy", "blindCarbonCopy");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("carbonCopy", "carbonCopy");
		this.hashFields.put("subject", "subject");
		this.hashFields.put("fileKey", "fileKey");
		this.hashFields.put("recipient", "recipient");
		this.hashFields.put("from", "from");
		this.hashFields.put("signature", "signature");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getTemplate() {
		return this.template;
	}
	public String getArgument() {
		return this.argument;
	}
	public String getContent() {
		return this.content;
	}
	public String getBlindCarbonCopy() {
		return this.blindCarbonCopy;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getCarbonCopy() {
		return this.carbonCopy;
	}
	public String getSubject() {
		return this.subject;
	}
	public String getFileKey() {
		return this.fileKey;
	}
	public String getRecipient() {
		return this.recipient;
	}
	public String getFrom() {
		return this.from;
	}
	public String getSignature() {
		return this.signature;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setTemplate(String template) {
		this.template = template;
		//this.template=true;
	}
	public void setArgument(String argument) {
		this.argument = argument;
		//this.argument=true;
	}
	public void setContent(String content) {
		this.content = content;
		//this.content=true;
	}
	public void setBlindCarbonCopy(String blindCarbonCopy) {
		this.blindCarbonCopy = blindCarbonCopy;
		//this.blindCarbonCopy=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setCarbonCopy(String carbonCopy) {
		this.carbonCopy = carbonCopy;
		//this.carbonCopy=true;
	}
	public void setSubject(String subject) {
		this.subject = subject;
		//this.subject=true;
	}
	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
		//this.fileKey=true;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
		//this.recipient=true;
	}
	public void setFrom(String from) {
		this.from = from;
		//this.from=true;
	}
	public void setSignature(String signature) {
		this.signature = signature;
		//this.signature=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setTemplate(JSPUtil.getParameter(request, "template", ""));
		setArgument(JSPUtil.getParameter(request, "argument", ""));
		setContent(JSPUtil.getParameter(request, "content", ""));
		setBlindCarbonCopy(JSPUtil.getParameter(request, "blindCarbonCopy", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCarbonCopy(JSPUtil.getParameter(request, "carbonCopy", ""));
		setSubject(JSPUtil.getParameter(request, "subject", ""));
		setFileKey(JSPUtil.getParameter(request, "fileKey", ""));
		setRecipient(JSPUtil.getParameter(request, "recipient", ""));
		setFrom(JSPUtil.getParameter(request, "from", ""));
		setSignature(JSPUtil.getParameter(request, "signature", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CustomSendEmailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CustomSendEmailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomSendEmailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] template = (JSPUtil.getParameter(request, prefix	+ "template".trim(), length));
			String[] argument = (JSPUtil.getParameter(request, prefix	+ "argument".trim(), length));
			String[] content = (JSPUtil.getParameter(request, prefix	+ "content".trim(), length));
			String[] blindCarbonCopy = (JSPUtil.getParameter(request, prefix	+ "blindCarbonCopy".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] carbonCopy = (JSPUtil.getParameter(request, prefix	+ "carbonCopy".trim(), length));
			String[] subject = (JSPUtil.getParameter(request, prefix	+ "subject".trim(), length));
			String[] fileKey = (JSPUtil.getParameter(request, prefix	+ "fileKey".trim(), length));
			String[] recipient = (JSPUtil.getParameter(request, prefix	+ "recipient".trim(), length));
			String[] from = (JSPUtil.getParameter(request, prefix	+ "from".trim(), length));
			String[] signature = (JSPUtil.getParameter(request, prefix	+ "signature".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomSendEmailVO();
				if (template[i] != null)
					model.setTemplate(template[i]);
				if (argument[i] != null)
					model.setArgument(argument[i]);
				if (content[i] != null)
					model.setContent(content[i]);
				if (blindCarbonCopy[i] != null)
					model.setBlindCarbonCopy(blindCarbonCopy[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (carbonCopy[i] != null)
					model.setCarbonCopy(carbonCopy[i]);
				if (subject[i] != null)
					model.setSubject(subject[i]);
				if (fileKey[i] != null)
					model.setFileKey(fileKey[i]);
				if (recipient[i] != null)
					model.setRecipient(recipient[i]);
				if (from[i] != null)
					model.setFrom(from[i]);
				if (signature[i] != null)
					model.setSignature(signature[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCustomSendEmailVOs();
	}

	public CustomSendEmailVO[] getCustomSendEmailVOs(){
		CustomSendEmailVO[] vos = (CustomSendEmailVO[])models.toArray(new CustomSendEmailVO[models.size()]);
		return vos;
	}
	
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.template = this.template .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.argument = this.argument .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.content = this.content .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blindCarbonCopy = this.blindCarbonCopy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carbonCopy = this.carbonCopy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileKey = this.fileKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recipient = this.recipient .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.from = this.from .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.signature = this.signature .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
