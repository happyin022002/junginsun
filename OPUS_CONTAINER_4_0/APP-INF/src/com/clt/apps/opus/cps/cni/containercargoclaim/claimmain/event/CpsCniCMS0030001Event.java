/*=========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : CpsCniCrm0030001Event.java
 * @FileTitle : Voc 정보 제공
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009-06-25
 * @LastModifier : 진윤오
 * @LastVersion : 1.0
 * 2009-06-25 진윤오
 * 
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * CRM003_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * CRM003_0001HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author cyo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class CpsCniCMS0030001Event extends EventSupport {
	private static final long serialVersionUID = 6498880634263177698L;

	public String crmVocNo = "";
	
	public String cgoClmNo  = "";

	public String getCgoClmNo() {
		return cgoClmNo;
	}

	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}

	public String getCrmVocNo() {
		return crmVocNo;
	}

	public void setCrmVocNo(String crmVocNo) {
		this.crmVocNo = crmVocNo;
	}
	

}