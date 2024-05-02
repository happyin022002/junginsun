/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0139Event.java
*@FileTitle : Damage Flagging/Unflagging Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.19 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.VerifyEQTypeSizeFlagFileListINVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * EES_MNR_0139 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0139HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author park myoung sin
 * @see EES_MNR_0219HTMLAction 참조
 * @since J2EE 1.4
 */
   
public class EesMnr0219Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomMnrDatVrfyVO customMnrDatVrfyVO = null;
	 
	/** Table Value Object Multi Data 처리 */
	private CustomMnrDatVrfyVO[] customMnrDatVrfyVOs = null;
	 
	/** Table Value Object 조회 조건*/ 
	private VerifyEQTypeSizeFlagFileListINVO eQFlagMgtINVO = null;
    
	public EesMnr0219Event(){}
	
	public VerifyEQTypeSizeFlagFileListINVO getEQFlagMgtINVO() {
		return eQFlagMgtINVO;
	}

	public void setEQFlagMgtINVO(VerifyEQTypeSizeFlagFileListINVO flagMgtINVO) {
		eQFlagMgtINVO = flagMgtINVO;
	}

	public void setCustomMnrDatVrfyVO(CustomMnrDatVrfyVO CustomMnrDatVrfyVO){
		this. customMnrDatVrfyVO = CustomMnrDatVrfyVO;
	} 

	public void setCustomMnrDatVrfyVOS(CustomMnrDatVrfyVO[] CustomMnrDatVrfyVOs){
		this. customMnrDatVrfyVOs = CustomMnrDatVrfyVOs;
	} 

	public CustomMnrDatVrfyVO getCustomMnrDatVrfyVO(){
		return customMnrDatVrfyVO;
	}

	public CustomMnrDatVrfyVO[] getCustomMnrDatVrfyVOS(){
		return customMnrDatVrfyVOs; 
	}

}
