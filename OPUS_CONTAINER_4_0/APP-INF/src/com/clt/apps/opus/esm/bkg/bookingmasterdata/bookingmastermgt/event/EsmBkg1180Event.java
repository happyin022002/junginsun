/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1180Event.java
*@FileTitle : Booking Creation 1_MT P/UP CY inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.04 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHandlingOfficeSetupVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1180 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1180HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김기종
 * @see ESM_BKG_1180HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1180Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO = null;
	
	private BkgHandlingOfficeSetupVO[] bkgHandlingOfficeSetupVOS = null;

	public BkgHandlingOfficeSetupVO getBkgHandlingOfficeSetupVO() {
		return bkgHandlingOfficeSetupVO;
	}

	public void setBkgHandlingOfficeSetupVO(
			BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO) {
		this.bkgHandlingOfficeSetupVO = bkgHandlingOfficeSetupVO;
	}

//	public BkgHandlingOfficeSetupVO[] getBkgHandlingOfficeSetupVOS() {
//		return bkgHandlingOfficeSetupVOS;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgHandlingOfficeSetupVO[] getBkgHandlingOfficeSetupVOS() {
		BkgHandlingOfficeSetupVO[] tmpVOs = null;
		if (this.bkgHandlingOfficeSetupVOS != null) {
			tmpVOs = new BkgHandlingOfficeSetupVO[bkgHandlingOfficeSetupVOS.length];
			System.arraycopy(bkgHandlingOfficeSetupVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}
	
//	public void setBkgHandlingOfficeSetupVOS(
//			BkgHandlingOfficeSetupVO[] bkgHandlingOfficeSetupVOS) {
//		this.bkgHandlingOfficeSetupVOS = bkgHandlingOfficeSetupVOS;
//	}
//	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgHandlingOfficeSetupVOS(
			BkgHandlingOfficeSetupVO[] bkgHandlingOfficeSetupVOS) {
		if (bkgHandlingOfficeSetupVOS != null) {
			BkgHandlingOfficeSetupVO[] tmpVOs = new BkgHandlingOfficeSetupVO[bkgHandlingOfficeSetupVOS.length];
			System.arraycopy(bkgHandlingOfficeSetupVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgHandlingOfficeSetupVOS = tmpVOs;
		}		
	}		
}