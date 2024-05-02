/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralMailFormVO.java
*@FileTitle : GeneralMailFormVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.09.16 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GeneralMailFormVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GeneralMailFormVO> models = new ArrayList<GeneralMailFormVO>();
	
	/* Column Info */
	private String sender = null;
	/* Column Info */
	private String textcontent = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String subject = null;
	/* Column Info */
	private String recipient = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public GeneralMailFormVO() {}

	public GeneralMailFormVO(String ibflag, String pagerows, String sender, String subject, String recipient, String textcontent) {
		this.sender = sender;
		this.textcontent = textcontent;
		this.ibflag = ibflag;
		this.subject = subject;
		this.recipient = recipient;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sender", getSender());
		this.hashColumns.put("textcontent", getTextcontent());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("recipient", getRecipient());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */  
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sender", "sender");
		this.hashFields.put("textcontent", "textcontent");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("subject", "subject");
		this.hashFields.put("recipient", "recipient");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sender
	 */
	public String getSender() {
		return this.sender;
	}
	
	/**
	 * Column Info
	 * @return textcontent
	 */
	public String getTextcontent() {
		return this.textcontent;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return subject
	 */
	public String getSubject() {
		return this.subject;
	}
	
	/**
	 * Column Info
	 * @return recipient
	 */
	public String getRecipient() {
		return this.recipient;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	/**
	 * Column Info
	 * @param sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	/**
	 * Column Info
	 * @param textcontent
	 */
	public void setTextcontent(String textcontent) {
		this.textcontent = textcontent;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * Column Info
	 * @param recipient
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSender(JSPUtil.getParameter(request, "sender", ""));
		setTextcontent(JSPUtil.getParameter(request, "textcontent", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSubject(JSPUtil.getParameter(request, "subject", ""));
		setRecipient(JSPUtil.getParameter(request, "recipient", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GeneralMailFormVO[]
	 */
	public GeneralMailFormVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GeneralMailFormVO[]
	 */
	public GeneralMailFormVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GeneralMailFormVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sender = (JSPUtil.getParameter(request, prefix	+ "sender", length));
			String[] textcontent = (JSPUtil.getParameter(request, prefix	+ "textcontent", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] subject = (JSPUtil.getParameter(request, prefix	+ "subject", length));
			String[] recipient = (JSPUtil.getParameter(request, prefix	+ "recipient", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GeneralMailFormVO();
				if (sender[i] != null)
					model.setSender(sender[i]);
				if (textcontent[i] != null)
					model.setTextcontent(textcontent[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (subject[i] != null)
					model.setSubject(subject[i]);
				if (recipient[i] != null)
					model.setRecipient(recipient[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGeneralMailFormVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GeneralMailFormVO[]
	 */
	public GeneralMailFormVO[] getGeneralMailFormVOs(){
		GeneralMailFormVO[] vos = (GeneralMailFormVO[])models.toArray(new GeneralMailFormVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
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
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.sender = this.sender .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.textcontent = this.textcontent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recipient = this.recipient .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
