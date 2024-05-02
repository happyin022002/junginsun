/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0242Event.java
*@FileTitle : Integrated Customer Data Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.06.03 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustRefVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0242 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0242HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Chang June
 * @see ESM_BKG_0240HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0242Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ArrNtcCustRefVO arrNtcCustRefVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ArrNtcCustRefVO[] arrNtcCustRefVOS = null;
	
	public EsmBkg0242Event(){}

	public ArrNtcCustRefVO getArrNtcCustRefVO() {
		return arrNtcCustRefVO;
	}

	public void setArrNtcCustRefVO(ArrNtcCustRefVO arrNtcCustRefVO) {
		this.arrNtcCustRefVO = arrNtcCustRefVO;
	}

	public ArrNtcCustRefVO[] getArrNtcCustRefVOS() {
		return arrNtcCustRefVOS;
	}

	public void setArrNtcCustRefVOS(ArrNtcCustRefVO[] arrNtcCustRefVOS) {
		this.arrNtcCustRefVOS = arrNtcCustRefVOS;
	}
	
	
	
}