/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf2052Event.java
*@FileTitle : Supporting Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.29 이선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_2052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_2052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sunyoung
 * @see VOP_OPF_2052HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf2052Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String subSysCd;
	private String senderUsrId;
	private String senderUsrNm;
	private String senderUsrEml;
	private String senderOfcCd;
	private String receiverEml;
	private String title;
	private String content;
	private String tmplMrd;
	private String tmplParam;
	private String emlFileKey1;
	private String emlFileKey2;
	public String getSubSysCd() {
		return subSysCd;
	}
	public void setSubSysCd(String subSysCd) {
		this.subSysCd = subSysCd;
	}
	public String getSenderUsrId() {
		return senderUsrId;
	}
	public void setSenderUsrId(String senderUsrId) {
		this.senderUsrId = senderUsrId;
	}
	public String getSenderUsrNm() {
		return senderUsrNm;
	}
	public void setSenderUsrNm(String senderUsrNm) {
		this.senderUsrNm = senderUsrNm;
	}
	public String getSenderUsrEml() {
		return senderUsrEml;
	}
	public void setSenderUsrEml(String senderUsrEml) {
		this.senderUsrEml = senderUsrEml;
	}
	public String getSenderOfcCd() {
		return senderOfcCd;
	}
	public void setSenderOfcCd(String senderOfcCd) {
		this.senderOfcCd = senderOfcCd;
	}
	public String getReceiverEml() {
		return receiverEml;
	}
	public void setReceiverEml(String receiverEml) {
		this.receiverEml = receiverEml;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTmplMrd() {
		return tmplMrd;
	}
	public void setTmplMrd(String tmplMrd) {
		this.tmplMrd = tmplMrd;
	}
	public String getTmplParam() {
		return tmplParam;
	}
	public void setTmplParam(String tmplParam) {
		this.tmplParam = tmplParam;
	}
	public String getEmlFileKey1() {
		return emlFileKey1;
	}
	public void setEmlFileKey1(String emlFileKey1) {
		this.emlFileKey1 = emlFileKey1;
	}
	public String getEmlFileKey2() {
		return emlFileKey2;
	}
	public void setEmlFileKey2(String emlFileKey2) {
		this.emlFileKey2 = emlFileKey2;
	}
	
	

}