/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EssMnr0155Event.java
*@FileTitle : M&R Buyer Management 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.10.05 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.event;

import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.CustomMnrPartnerVO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.CustomMnrPrnrCntcPntVO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.DisposalPartnerMgtINVO;
import com.clt.framework.support.layer.event.EventSupport;
   

/**
 * ESS_MNR_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESS_MNR_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author YoungBueb Kwon 
 * @see EES_MNR_0155HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0155Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DisposalPartnerMgtINVO disposalPartnerMgtINVO = null;
	
	/** Table Value Object 단건 처리  */
	private CustomMnrPartnerVO customMnrPartnerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomMnrPartnerVO[] customMnrPartnerVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomMnrPrnrCntcPntVO[] customMnrPrnrCntcPntVOs = null;

	public EesMnr0155Event(){}
	
	public DisposalPartnerMgtINVO getDisposalPartnerMgtINVO() {
		return disposalPartnerMgtINVO;
	}
	public void setDisposalPartnerMgtINVO(DisposalPartnerMgtINVO disposalPartnerMgtINVO) {
		this.disposalPartnerMgtINVO = disposalPartnerMgtINVO;
	}

	public CustomMnrPartnerVO[] getCustomMnrPartnerVOs() {
		CustomMnrPartnerVO[] rtnVOs = null;
		if (this.customMnrPartnerVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrPartnerVOs, customMnrPartnerVOs.length);
		}
		return rtnVOs;
	}
	public void setCustomMnrPartnerVOs(CustomMnrPartnerVO[] customMnrPartnerVOs){
		if(customMnrPartnerVOs != null){
			CustomMnrPartnerVO[] tmpVOs = java.util.Arrays.copyOf(customMnrPartnerVOs, customMnrPartnerVOs.length);
			this.customMnrPartnerVOs = tmpVOs;
		}
	}
	public CustomMnrPrnrCntcPntVO[] getCustomMnrPrnrCntcPntVOs() {
		CustomMnrPrnrCntcPntVO[] rtnVOs = null;
		if (this.customMnrPrnrCntcPntVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrPrnrCntcPntVOs, customMnrPrnrCntcPntVOs.length);
		}
		return rtnVOs;
	}
	public void setCustomMnrPrnrCntcPntVOs(CustomMnrPrnrCntcPntVO[] customMnrPrnrCntcPntVOs){
		if(customMnrPrnrCntcPntVOs != null){
			CustomMnrPrnrCntcPntVO[] tmpVOs = java.util.Arrays.copyOf(customMnrPrnrCntcPntVOs, customMnrPrnrCntcPntVOs.length);
			this.customMnrPrnrCntcPntVOs = tmpVOs;
		}
	}
	public CustomMnrPartnerVO getCustomMnrPartnerVO() {
		return customMnrPartnerVO;
	} 
	public void setCustomMnrPartnerVO(CustomMnrPartnerVO customMnrPartnerVO) {
		this.customMnrPartnerVO = customMnrPartnerVO;
	}  
	
}