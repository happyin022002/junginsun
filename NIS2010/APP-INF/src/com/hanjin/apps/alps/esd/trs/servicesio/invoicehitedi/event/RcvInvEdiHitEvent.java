/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RcvInvEdiHitEvent.java
*@FileTitle : HIT INVOICE EDI RECEIVE, PDF FILE ATTACH  & ACK 
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-24
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2016-06-24 SHIN DONG IL
* 1.0 최초생성
=============================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.jf.transfer.TransferEAI;

/**
 *  PDTO(Data Transfer Object including Parameters)<br>
 * - HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Sang-Woo
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class RcvInvEdiHitEvent extends EventSupport {
	
public RcvInvEdiHitEvent(){}
	
	public String str = null;
	public String fileNm = null;
	public byte[] fileBuf = null;
	public TransferEAI eai = null;

	public String getEventName() {
		return "RcvInvEdiHitEvent";
	}

	public String toString() {
		return "RcvInvEdiHitEvent";
	}
	
	public String getString() {
		return str;
	}

	public void setString(String str) {
		this.str = str;
	}



	public String getFileNm() {
		return fileNm;
	}

	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}

	public byte[] getFileBuf() {
		return fileBuf;
	}

	public void setFileBuf(byte[] fileBuf) {
		this.fileBuf = fileBuf;
	}

	public TransferEAI getEai() {
		return eai;
	}

	public void setEai(TransferEAI eai) {
		this.eai = eai;
	}
	

}
