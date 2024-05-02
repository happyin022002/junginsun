/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0507Event.java
*@FileTitle : US AMS: Transmit History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.07.14 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistListCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0507 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0507HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0507HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0507Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TransmitHistListCondVO transmitHistListCondVO = null;

	public EsmBkg0507Event(){}

	/**
	 * @return the transmitHistListCondVO
	 */
	public TransmitHistListCondVO getTransmitHistListCondVO() {
		return transmitHistListCondVO;
	}

	/**
	 * @param transmitHistListCondVO the transmitHistListCondVO to set
	 */
	public void setTransmitHistListCondVO(TransmitHistListCondVO transmitHistListCondVO) {
		this.transmitHistListCondVO = transmitHistListCondVO;
	}


}