/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg037501Event.java
*@FileTitle : Arrival Notice Form Setting General, Door, CY, CFS Cargo, Special Cargo, Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.04.28 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcWdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0375 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0375HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mangeon
 * @see ESM_BKG_0375HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0375Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ArrNtcWdVO arrNtcWdVO = null;

	public ArrNtcWdVO getArrNtcWdVO() {
		return arrNtcWdVO;
	}

	public void setArrNtcWdVO(ArrNtcWdVO arrNtcWdVO) {
		this.arrNtcWdVO = arrNtcWdVO;
	}
	

}