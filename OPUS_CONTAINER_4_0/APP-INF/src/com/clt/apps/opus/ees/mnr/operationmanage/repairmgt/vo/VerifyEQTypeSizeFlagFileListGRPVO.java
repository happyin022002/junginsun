/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQFlagMgtGRPVO
*@FileTitle : 
*Open Issues :	
*Change history :
*@LastModifyDate : 2009. 8. 18.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 8. 18. 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import java.util.List;

import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
 
/**
 * EQFlagMgtGRPVO GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 권영법 
 * @since J2EE 1.5 
 * @see	  ..   
 */
public class VerifyEQTypeSizeFlagFileListGRPVO {
	private VerifyEQTypeSizeFlagFileListINVO eQTypeSizeFlagMgtINVO = null;
	 
	private List<CustomMnrDatVrfyVO> customMnrDatVrfyVOS = null;     
	 
	public List<CustomMnrDatVrfyVO> getCustomMnrDatVrfyVOS() {
		return customMnrDatVrfyVOS;
	} 

	public void setCustomMnrDatVrfyVOS(List<CustomMnrDatVrfyVO> customMnrDatVrfyVOS) {
		this.customMnrDatVrfyVOS = customMnrDatVrfyVOS; 
	}

	public VerifyEQTypeSizeFlagFileListINVO getEQFlagMgtINVO() {
		return eQTypeSizeFlagMgtINVO;
	}
	
	public void setEQFlagMgtINVO(VerifyEQTypeSizeFlagFileListINVO verifyEQTypeSizeFlagFileListINVO) {
		eQTypeSizeFlagMgtINVO = verifyEQTypeSizeFlagFileListINVO;
	}
}
