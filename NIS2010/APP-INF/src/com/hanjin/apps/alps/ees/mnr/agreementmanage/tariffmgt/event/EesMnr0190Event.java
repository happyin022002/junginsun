/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0190Event.java
*@FileTitle : Local Tariff File Import_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.22 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.VerifyTariffFileListINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ees_mnr_0190 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0190HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author WanGyu Kim 
 * @see ees_mnr_0190HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0190Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EesMnr0190Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomMnrDatVrfyVO customMnrDatVrfyVO = null;
	/** Table Value Object Multi Data 처리 */
	private CustomMnrDatVrfyVO[] customMnrDatVrfyVOs = null;
	/** Table Value Object 조회 조건*/ 
	private VerifyTariffFileListINVO verifyTariffFileListINVO = null;

	public CustomMnrDatVrfyVO getCustomMnrDatVrfyVO() {
		return customMnrDatVrfyVO;
	}
	public void setCustomMnrDatVrfyVO(CustomMnrDatVrfyVO customMnrDatVrfyVO) {
		this.customMnrDatVrfyVO = customMnrDatVrfyVO;
	}
	public CustomMnrDatVrfyVO[] getCustomMnrDatVrfyVOs() {
		return customMnrDatVrfyVOs;
	}
	public void setCustomMnrDatVrfyVOs(CustomMnrDatVrfyVO[] customMnrDatVrfyVOs) {
		this.customMnrDatVrfyVOs = customMnrDatVrfyVOs;
	}
	public VerifyTariffFileListINVO getVerifyTariffFileListINVO() {
		return verifyTariffFileListINVO;
	}
	public void setVerifyTariffFileListINVO(
			VerifyTariffFileListINVO verifyTariffFileListINVO) {
		this.verifyTariffFileListINVO = verifyTariffFileListINVO;
	}


	
	
}