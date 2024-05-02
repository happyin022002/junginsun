/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomsTransmissionBC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.04.21 김승민
* 1.0 Creation
* 
* 2011.07.06 민정호 [CHM-201111866] US AMS : AMS Report 의 general의 조회 기능 보완
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.eur.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.SendLogCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.SendLogDetailVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * ALPS-CustomsTransmission Business Logic Command Interface<br>
 * - ALPS-CustomsTransmission에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM SEUNG MIN
 * @see 
 * @since J2EE 1.4
 */
public interface EurCustomsReportBC {	 
	
	/**
	 * EUR 전송 로그를 조회한다.
	 * 
	 * @param SendLogCondVO sendLogCondVO
	 * @return List<SendLogDetailVO>
	 * @throws EventException
	 */
	public List<SendLogDetailVO> searchSendLog(SendLogCondVO sendLogCondVO) throws EventException;

}