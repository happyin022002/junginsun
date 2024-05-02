/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BatchForEtdAtdTransmitEvent.java
*@FileTitle : BatchForEtdAtdTransmitEvent
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier :
*@LastVersion : 1.0
* 2013.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.DepartureTimeVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1503에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1503HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_BKG_1503HTMLAction 참조
 * @since J2EE 1.6
 */
public class BatchForEtdAtdTransmitEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DepartureTimeVO departureTimeVO = null;

	public BatchForEtdAtdTransmitEvent() {}

	public DepartureTimeVO getDepartureTimeVO() {
		return this.departureTimeVO;
	}

	public void setDepartureTimeVO(DepartureTimeVO departureTimeVO) {
		this.departureTimeVO = departureTimeVO;
	}

}

