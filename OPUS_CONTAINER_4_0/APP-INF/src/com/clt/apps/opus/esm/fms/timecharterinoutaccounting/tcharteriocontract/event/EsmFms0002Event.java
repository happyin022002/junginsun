/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0002Event.java
*@FileTitle : Agreement Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.27 정윤태
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.event;

import com.clt.framework.support.layer.event.EventSupport;

 
/**
 * Agreement Inquiry 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer 로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGYOONTAE
 * @see ESM_FMS_0002HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0002Event extends EventSupport {
	
	private static final long serialVersionUID = 1821987575925859092L;

	private String fletCtrtNo = "";
	
	public String getFletCtrtNo() {
		return fletCtrtNo;
	}

	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
}