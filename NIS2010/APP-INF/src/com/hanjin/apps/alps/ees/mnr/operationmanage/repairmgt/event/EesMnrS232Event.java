/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0139Event.java
*@FileTitle : Damage Flagging/Unflagging Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.11.24 권영법
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.VerifyRPRCreateFileListINVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * EES_MNR_S139 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_S139HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author park myoung sin
 * @see EES_MNR_S232HTMLAction 참조
 * @since J2EE 1.4
 */
   
public class EesMnrS232Event extends EventSupport {

	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomMnrDatVrfyVO customMnrDatVrfyVO = null;
	 
	/** Table Value Object Multi Data 처리 */
	private CustomMnrDatVrfyVO[] customMnrDatVrfyVOs = null;
	 
	/** Table Value Object 조회 조건*/ 
	private VerifyRPRCreateFileListINVO rPRCreateMgtINVO = null;
			    
	public EesMnrS232Event(){}

	public VerifyRPRCreateFileListINVO getRPRCreateMgtINVO() {
		return rPRCreateMgtINVO;
	}

	public void setRPRCreateMgtINVO(VerifyRPRCreateFileListINVO createMgtINVO) {
		rPRCreateMgtINVO = createMgtINVO;
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
