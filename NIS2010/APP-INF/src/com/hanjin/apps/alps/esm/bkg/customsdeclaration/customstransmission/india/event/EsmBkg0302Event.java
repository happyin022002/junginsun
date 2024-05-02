/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0302Event.java
*@FileTitle : EsmBkg0302Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.24 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaTransmitCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0302 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0302HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0302HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0302Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private IndiaTransmitCondVO indiaTransmitCondVO = null;

	/**
	 * @return the indiaTransmitCondVO
	 */
	public IndiaTransmitCondVO getIndiaTransmitCondVO() {
		return indiaTransmitCondVO;
	}

	/**
	 * @param indiaTransmitCondVO the indiaTransmitCondVO to set
	 */
	public void setIndiaTransmitCondVO(IndiaTransmitCondVO indiaTransmitCondVO) {
		this.indiaTransmitCondVO = indiaTransmitCondVO;
	}

	
	
	
}
