/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiBkg0429Event.java
*@FileTitle : Receive File
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.06.01 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_BKG_0429 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG_0429HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0429HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0429Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReceiveLogCondVO receiveLogCondVO = null;

	public EsmBkg0429Event(){}

	public ReceiveLogCondVO getReceiveLogCondVO() {
		return receiveLogCondVO;
	}

	public void setReceiveLogCondVO(ReceiveLogCondVO receiveLogCondVO) {
		this.receiveLogCondVO = receiveLogCondVO;
	}


}