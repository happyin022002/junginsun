/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0242Event.java
*@FileTitle : Integrated Customer Data Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustRefVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0242 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0242HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
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

//	public ArrNtcCustRefVO[] getArrNtcCustRefVOS() {
//		return arrNtcCustRefVOS;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public ArrNtcCustRefVO[] getArrNtcCustRefVOS() {
		ArrNtcCustRefVO[] tmpVOs = null;
		if (this.arrNtcCustRefVOS != null) {
			tmpVOs = new ArrNtcCustRefVO[arrNtcCustRefVOS.length];
			System.arraycopy(arrNtcCustRefVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}
	
//	public void setArrNtcCustRefVOS(ArrNtcCustRefVO[] arrNtcCustRefVOS) {
//		this.arrNtcCustRefVOS = arrNtcCustRefVOS;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setArrNtcCustRefVOS(ArrNtcCustRefVO[] arrNtcCustRefVOS) {
		if (arrNtcCustRefVOS != null) {
			ArrNtcCustRefVO[] tmpVOs = new ArrNtcCustRefVO[arrNtcCustRefVOS.length];
			System.arraycopy(arrNtcCustRefVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.arrNtcCustRefVOS = tmpVOs;
		}		
	} 
	
}