/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQFlagMgtGRPVO
*@FileTitle : 
*Open Issues :	
*Change history :
*@LastModifyDate : 2009. 5. 20.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 5. 20. 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
 
/**
 * EQFlagMgtGRPVO GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 박명신 
 * @since J2EE 1.5 
 * @see	  ..   
 */
public class VerifyEQFlagFileListGRPVO {
	private VerifyEQFlagFileListINVO eQFlagMgtINVO = null;
	 
	private List<CustomMnrDatVrfyVO> customMnrDatVrfyVOS = null;     
	 
	public List<CustomMnrDatVrfyVO> getCustomMnrDatVrfyVOS() {
		return customMnrDatVrfyVOS;
	} 

	public void setCustomMnrDatVrfyVOS(List<CustomMnrDatVrfyVO> customMnrDatVrfyVOS) {
		this.customMnrDatVrfyVOS = customMnrDatVrfyVOS; 
	}

	public VerifyEQFlagFileListINVO getEQFlagMgtINVO() {
		return eQFlagMgtINVO;
	}
	
	public void setEQFlagMgtINVO(VerifyEQFlagFileListINVO flagMgtINVO) {
		eQFlagMgtINVO = flagMgtINVO;
	}
}
