/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0251Event.java
*@FileTitle : SLD Cancelation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.28
*@LastModifier : 김종옥  
*@LastVersion : 1.0
* 2011.04.28 김종옥 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalSoldINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispCancelVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * EES_MNR_0251 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_MNR_0251HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김종옥
 * @see EES_MNR_0251HTMLAction 참조
 * @since J2EE 1.6
 */    
      
public class EesMnr0251Event extends EventSupport {

	private static final long serialVersionUID = 1L; 
	 
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomMnrDispCancelVO customMnrDispCancelVO = null;
	private DisposalSoldINVO disposalSoldINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomMnrDispCancelVO[] customMnrDispCancelVOs = null;

	public EesMnr0251Event(){}
	
	public void setCustomMnrDispCancelVO(CustomMnrDispCancelVO customMnrDispCancelVO){
		this. customMnrDispCancelVO = customMnrDispCancelVO;
	}

	public void setCustomMnrDispCancelVOS(CustomMnrDispCancelVO[] customMnrDispCancelVOs){
		this. customMnrDispCancelVOs = customMnrDispCancelVOs;
	}

	public CustomMnrDispCancelVO getCustomMnrDispCancelVO(){
		return customMnrDispCancelVO;
	}

	public CustomMnrDispCancelVO[] getCustomMnrDispCancelVOS(){
		return customMnrDispCancelVOs;
	}

	public void setDisposalSoldINVO(DisposalSoldINVO disposalSoldINVO) {
		this.disposalSoldINVO = disposalSoldINVO;
	}
	
	public DisposalSoldINVO getDisposalSoldINVO() {
		return disposalSoldINVO;
	}	
}