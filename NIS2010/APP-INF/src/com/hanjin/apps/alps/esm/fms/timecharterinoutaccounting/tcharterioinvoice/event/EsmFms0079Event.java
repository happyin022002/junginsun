/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0079Event.java
*@FileTitle : SEND E-mail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.29 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSendEmailVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0079 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0079HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGINSUN
 * @see ESM_FMS_0079HTMLAction 참조
 * @since J2EE 1.5 
 */

public class EsmFms0079Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** MailFlag(메일 구분) **/
	private String mailFlg = "";		
	private List<String> keys = null;
	private String csrNo = "";	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomSendEmailVO customSendEmailVO = null;

	public EsmFms0079Event(){}
	
	public void setCustomSendEmailVO(CustomSendEmailVO customSendEmailVO){
		this.customSendEmailVO = customSendEmailVO;
	}
	
	public CustomSendEmailVO getCustomSendEmailVO(){
		return customSendEmailVO;
	}
	
	public String getMailFlg() {
		return mailFlg;
	}

	public void setMailFlg(String mailFlg) {
		this.mailFlg = mailFlg;
	}
	
	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	
	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}	
}