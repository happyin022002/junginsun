/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0508Event.java
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

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistFileCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0508 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0508HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0508HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0508Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TransmitHistFileCondVO transmitHistFileCondVO = null;

	public EsmBkg0508Event(){}

	/**
	 * @return the transmitHistFileCondVO
	 */
	public TransmitHistFileCondVO getTransmitHistFileCondVO() {
		return transmitHistFileCondVO;
	}

	/**
	 * @param transmitHistFileCondVO the transmitHistFileCondVO to set
	 */
	public void setTransmitHistFileCondVO(
			TransmitHistFileCondVO transmitHistFileCondVO) {
		this.transmitHistFileCondVO = transmitHistFileCondVO;
	}


}