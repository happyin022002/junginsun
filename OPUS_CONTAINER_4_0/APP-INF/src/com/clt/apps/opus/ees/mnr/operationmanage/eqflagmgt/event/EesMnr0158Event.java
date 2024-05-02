/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0158Event.java
*@FileTitle : Disposal Candidate Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 권영법  
*@LastVersion : 1.0
* 2009.09.21 권영법 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event;

import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.DisposalCandidateFlagINVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 권영법
 * @see ees_mnr_0109HTMLAction 참조
 * @since J2EE 1.6
 */    

public class EesMnr0158Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	 
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DisposalCandidateFlagINVO disposalCandidateFlagINVO = null;
	 
	/** Table Value Object Multi Data 처리 */ 
	private CustomMnrEqStsVO[] customMnrEqStsVOs = null;
	
	public CustomMnrEqStsVO[] getCustomMnrEqStsVOs() {
		CustomMnrEqStsVO[] rtnVOs = null;
		if (this.customMnrEqStsVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrEqStsVOs, customMnrEqStsVOs.length);
		}
		return rtnVOs;
	}   
	 
	public void setCustomMnrEqStsVOs(CustomMnrEqStsVO[] customMnrEqStsVOs){
		if(customMnrEqStsVOs != null){
			CustomMnrEqStsVO[] tmpVOs = java.util.Arrays.copyOf(customMnrEqStsVOs, customMnrEqStsVOs.length);
			this.customMnrEqStsVOs = tmpVOs;
		}
	}  

	public EesMnr0158Event(){} 
	   
	public DisposalCandidateFlagINVO getDisposalCandidateFlagINVO() {
		return disposalCandidateFlagINVO; 
	}

	public void setDisposalCandidateFlagINVO(DisposalCandidateFlagINVO disposalCandidateFlagINVO) {
		this.disposalCandidateFlagINVO = disposalCandidateFlagINVO;
	}  


}