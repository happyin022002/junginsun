/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VerifyTariffFileListGRPVO.java
*@FileTitle : VerifyTariffFileListGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.22 김완규 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo;

import java.util.List;

import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;

/**
 * VerifyTariffFileListGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 김완규
 * @since J2EE 1.5
 * @see
 */
public class VerifyTariffFileListGRPVO {
	private VerifyTariffFileListINVO verifyTariffFileListINVO = null;
	 
	private List<CustomMnrDatVrfyVO> customMnrDatVrfyVOS = null;

	public VerifyTariffFileListINVO getVerifyTariffFileListINVO() {
		return verifyTariffFileListINVO;
	}

	public void setVerifyTariffFileListINVO(
			VerifyTariffFileListINVO verifyTariffFileListINVO) {
		this.verifyTariffFileListINVO = verifyTariffFileListINVO;
	}

	public List<CustomMnrDatVrfyVO> getCustomMnrDatVrfyVOS() {
		return customMnrDatVrfyVOS;
	}

	public void setCustomMnrDatVrfyVOS(List<CustomMnrDatVrfyVO> customMnrDatVrfyVOS) {
		this.customMnrDatVrfyVOS = customMnrDatVrfyVOS;
	}  
}
