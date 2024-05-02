/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EssMnr0009Event.java
*@FileTitle : M&R Other Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.05.14 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.event;

import com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.vo.CustomMnrGenCdVO;
import com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.vo.GeneralCodeMgtINVO;
import com.clt.framework.support.layer.event.EventSupport;
   

/**
 * ESS_MNR_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESS_MNR_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author WanGyu Kim 
 * @see EES_MNR_0009HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private GeneralCodeMgtINVO generalCodeMgtINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomMnrGenCdVO[] customMnrGenCdVOs = null;

	public EesMnr0009Event(){}
	
	public GeneralCodeMgtINVO getGeneralCodeMgtINVO() {
		return generalCodeMgtINVO;
	}
	public void setGeneralCodeMgtINVO(GeneralCodeMgtINVO generalCodeMgtINVO) {
		this.generalCodeMgtINVO = generalCodeMgtINVO;
	}

	public CustomMnrGenCdVO[] getCustomMnrGenCdVOs() {
		CustomMnrGenCdVO[] rtnVOs = null;
		if (this.customMnrGenCdVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrGenCdVOs, customMnrGenCdVOs.length);
		}
		return rtnVOs;
	}
	public void setCustomMnrGenCdVOs(CustomMnrGenCdVO[] customMnrGenCdVOs){
		if(customMnrGenCdVOs != null){
			CustomMnrGenCdVO[] tmpVOs = java.util.Arrays.copyOf(customMnrGenCdVOs, customMnrGenCdVOs.length);
			this.customMnrGenCdVOs = tmpVOs;
		}
	}
	
}