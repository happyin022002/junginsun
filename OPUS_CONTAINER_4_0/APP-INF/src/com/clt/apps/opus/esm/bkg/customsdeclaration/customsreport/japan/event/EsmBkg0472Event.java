/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0472Event.java
*@FileTitle : ESM_BKG-0472
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.06.02 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanReceiveLogCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0472 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0472HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0472HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0472Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanReceiveLogCondVO japanReceiveLogCondVO = null;

	public EsmBkg0472Event(){}

	public void setJapanReceiveLogCondVO(JapanReceiveLogCondVO japanReceiveLogCondVO){
		this. japanReceiveLogCondVO = japanReceiveLogCondVO;
	}

	public JapanReceiveLogCondVO getJapanReceiveLogCondVO(){
		return japanReceiveLogCondVO;
	}

}

