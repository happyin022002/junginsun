/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoRlseMailSendVO.java
*@FileTitle : CargoRlseMailSendVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.28 손윤석 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Customs Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @@author
 * @since J2EE 1.5
 * @see ESM_FMS_0079HTMLAction
 */

public class FullCntrRlseOrderMailSendVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FullCntrRlseOrderMailSendVO> models = new ArrayList<FullCntrRlseOrderMailSendVO>();
	
	/* Column Info */
	private String blNo = null;		
	/* Column Info */
	private String bkgNo = null;	
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
	private String ydCd = null;
	/* Column Info */
	private String ydEml = null;	
	
	
	
	/* Column Info */
	private String ntcSndId = null;	
	
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
	public FullCntrRlseOrderMailSendVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String from, String carbonCopy, String blindCarbonCopy, String subject, String content, String fileKey, String recipient, String argument, String template
	 * @return 
	 */
	public FullCntrRlseOrderMailSendVO( String template,String argument,String content,String blindCarbonCopy,String carbonCopy ,String subject ,String fileKey	,String recipient,String from ,String blNo ,String bkgNo ,String ydCd,String ydEml, String ntcSndId,String pagerows ,String ibflag ){
 		this.template 		= template;
		this.argument 		= argument;
		this.content		 = content;
		this.blindCarbonCopy 	= blindCarbonCopy;
		this.carbonCopy 	= carbonCopy;
		this.subject 		= subject;
		this.fileKey 		= fileKey;
		this.recipient 		= recipient;
		this.from 		= from;
		this.blNo 		= blNo;
		this.bkgNo 		= bkgNo;
		this.ydCd		 = ydCd;
		this.ydEml		 = ydEml;
		this.ntcSndId	 = ntcSndId;
		this.pagerows 		= pagerows;
		this.ibflag 		= ibflag;
		
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
		this.hashColumns.put("carbonCopy", getCarbonCopy());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("fileKey", getFileKey());
		this.hashColumns.put("recipient", getRecipient());
		this.hashColumns.put("from", getFrom());	
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("yd_cd", getYdCd());		
		this.hashColumns.put("yd_eml", getYdEml());		
		this.hashColumns.put("ntc_snd_id", getNtcSndId());		
		this.hashColumns.put("ibflag", getIbflag());
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
		this.hashFields.put("carbonCopy", "carbonCopy");
		this.hashFields.put("subject", "subject");
		this.hashFields.put("fileKey", "fileKey");
		this.hashFields.put("recipient", "recipient");
		this.hashFields.put("from", "from");	
		this.hashFields.put("bl_no", "blNo");	
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("yd_cd", "ydCd");		
		this.hashFields.put("yd_eml", "ydEml");		
		this.hashFields.put("ntc_snd_id", "ntcSndId");		
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getNtcSndId() {
		return this.ntcSndId;
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
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return ydEml
	 */
	public String getYdEml() {
		return this.ydEml;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
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
	
	
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setNtcSndId(String ntcSndId) {
		this.ntcSndId = ntcSndId;
	}
	
	
	
	
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	
	
	/**
	 * Column Info
	 * @param ydEml
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param ydEml
	 */
	public void setYdEml(String ydEml) {
		this.ydEml = ydEml;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	
	public void fromRequest(HttpServletRequest request) {
		setTemplate(JSPUtil.getParameter(request, "template", ""));
		setArgument(JSPUtil.getParameter(request, "argument", ""));
		setContent(JSPUtil.getParameter(request, "content", ""));
		setBlindCarbonCopy(JSPUtil.getParameter(request, "blindCarbonCopy", ""));
		setCarbonCopy(JSPUtil.getParameter(request, "carbonCopy", ""));
		setSubject(JSPUtil.getParameter(request, "subject", ""));
		setFileKey(JSPUtil.getParameter(request, "fileKey", ""));
		setRecipient(JSPUtil.getParameter(request, "recipient", ""));
		setFrom(JSPUtil.getParameter(request, "from", ""));	
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));		
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));	
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));		
		setYdCd(JSPUtil.getParameter(request, "yd_eml", ""));
		setYdEml(JSPUtil.getParameter(request, "yd_cd", ""));
		setNtcSndId(JSPUtil.getParameter(request, "ntc_snd_id", ""));
		
	}

	public FullCntrRlseOrderMailSendVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public FullCntrRlseOrderMailSendVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FullCntrRlseOrderMailSendVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] template = (JSPUtil.getParameter(request, prefix	+ "template".trim(), length));
			String[] argument = (JSPUtil.getParameter(request, prefix	+ "argument".trim(), length));
			String[] content = (JSPUtil.getParameter(request, prefix	+ "content".trim(), length));
			String[] blindCarbonCopy = (JSPUtil.getParameter(request, prefix	+ "blindCarbonCopy".trim(), length));
			String[] carbonCopy = (JSPUtil.getParameter(request, prefix	+ "carbonCopy".trim(), length));
			String[] subject = (JSPUtil.getParameter(request, prefix	+ "subject".trim(), length));
			String[] fileKey = (JSPUtil.getParameter(request, prefix	+ "fileKey".trim(), length));
			String[] recipient = (JSPUtil.getParameter(request, prefix	+ "recipient".trim(), length));
			String[] from = (JSPUtil.getParameter(request, prefix	+ "from".trim(), length));		
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));			
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));	
			String[] ydEml = (JSPUtil.getParameter(request, prefix	+ "yd_eml", length));	
			String[] ntcSndId = (JSPUtil.getParameter(request, prefix	+ "ntc_snd_id", length));	
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));			
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new FullCntrRlseOrderMailSendVO();
				if (template[i] != null)
					model.setTemplate(template[i]);
				if (argument[i] != null)
					model.setArgument(argument[i]);
				if (content[i] != null)
					model.setContent(content[i]);
				if (blindCarbonCopy[i] != null)
					model.setBlindCarbonCopy(blindCarbonCopy[i]);
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
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);			
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);		
				if (ydEml[i] != null)
					model.setYdEml(ydEml[i]);			
				if (ntcSndId[i] != null)
					model.setNtcSndId(ntcSndId[i]);		
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);			
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				
				models.add(model);
			}

		} catch (Exception e) {}
		return getCustomSendEmailVOs();
	}

	public FullCntrRlseOrderMailSendVO[] getCustomSendEmailVOs(){
		FullCntrRlseOrderMailSendVO[] vos = (FullCntrRlseOrderMailSendVO[])models.toArray(new FullCntrRlseOrderMailSendVO[models.size()]);
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
		this.carbonCopy = this.carbonCopy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileKey = this.fileKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recipient = this.recipient .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.from = this.from .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydEml = this.ydEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSndId = this.ntcSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	
	   
	}
}
