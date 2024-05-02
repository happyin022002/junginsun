/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EdiEns001Event.java
 *@FileTitle : USARail WO 신고 정보
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-12-20
 *@LastModifier : Lee Sang-Woo
 *@LastVersion : 1.0
 * 2006-12-20 Lee Sang-Woo
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.usarailwoack.event;

import java.util.ArrayList;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * PDTO(Data Transfer Object including Parameters)<br>
 * - 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Lee Sang-Woo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EdiEns002Event extends EventSupport {

	public String str = null;

	private String sender_id;
	private String receiver_id;
	private String message_type;
	private String reference_no;

	private ArrayList flatFileMap = new ArrayList();

	public String getEventName() {
		return "EdiEns002Event";
	}

	public String toString() {
		return "EdiEns002Event";
	}

	public String getString() {
		return str;
	}

	public void setString(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getSender_id() {
		return sender_id;
	}

	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}

	public String getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}

	public String getMessage_type() {
		return message_type;
	}

	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}

	public String getReference_no() {
		return reference_no;
	}

	public void setReference_no(String reference_no) {
		this.reference_no = reference_no;
	}

	public ArrayList getFlatFileMap() {
		return flatFileMap;
	}

	public void setFlatFileMap(ArrayList flatFileMap) {
		this.flatFileMap = flatFileMap;
	}
}
