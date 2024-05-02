/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0151Event.java
*@FileTitle : Disposal Candidate Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 권영법  
*@LastVersion : 1.0
* 2009.07.20 권영법 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqRngStsVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.DisposalCandidateFlagINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EqListForDisposalVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 권영법
 * @see ees_mnr_0109HTMLAction 참조
 * @since J2EE 1.6
 */    

public class EesMnr0151Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public String eqKndCd = null;
	 
	public String getEqKndCd() {
		return eqKndCd;
	}

	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DisposalCandidateFlagINVO disposalCandidateFlagINVO = null;
	 
	/** Table Value Object Multi Data 처리 */ 
	public CustomMnrEqStsVO[] customMnrEqStsVOs = null;
	
	/** Table Value Object Multi Data 처리 */ 
	public EqListForDisposalVO[] eqListForDisposalVOs = null;
	
	public EqListForDisposalVO[] getEqListForDisposalVOs() {
		return eqListForDisposalVOs;
	}

	public void setEqListForDisposalVOs(EqListForDisposalVO[] eqListForDisposalVOs) {
		this.eqListForDisposalVOs = eqListForDisposalVOs;
	}

	/** Table Value Object Multi Data 처리 */  
	public CustomMnrEqRngStsVO[] customMnrEqRngStsVOs = null; 
  
	public CustomMnrEqRngStsVO[] getCustomMnrEqRngStsVOs() {
		return customMnrEqRngStsVOs;  
	} 

	public void setCustomMnrEqRngStsVOs(CustomMnrEqRngStsVO[] customMnrEqRngStsVOs) {
		this.customMnrEqRngStsVOs = customMnrEqRngStsVOs;
	}
	public CustomMnrEqStsVO[] getCustomMnrEqStsVOs() {
		return customMnrEqStsVOs;
	}   
	 
	public void setCustomMnrEqStsVOs(CustomMnrEqStsVO[] customMnrEqStsVOs) {
		this.customMnrEqStsVOs = customMnrEqStsVOs;
	}  

	public EesMnr0151Event(){} 
	   
	public DisposalCandidateFlagINVO getDisposalCandidateFlagINVO() {
		return disposalCandidateFlagINVO; 
	}

	public void setDisposalCandidateFlagINVO(DisposalCandidateFlagINVO disposalCandidateFlagINVO) {
		this.disposalCandidateFlagINVO = disposalCandidateFlagINVO;
	}  


}