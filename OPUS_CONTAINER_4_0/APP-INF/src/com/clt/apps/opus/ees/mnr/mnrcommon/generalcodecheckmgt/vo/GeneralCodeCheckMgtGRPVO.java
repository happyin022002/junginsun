/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtGRPVO
*@FileTitle : 
*Open Issues :	
*Change history :
*@LastModifyDate : 2009. 5. 20.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 5. 20. 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo;

import java.util.List;

import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrGeneralCodeVO;
 
/**
 * GeneralCodeCheckMgtGRPVO GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *   
 * @author 박명신 
 * @since J2EE 1.5 
 * @see	  ..     
 */  
public class GeneralCodeCheckMgtGRPVO {
	//벨리데이션 로그 테이블 EES_MNR_139
	private CustomMnrDatVrfyVO[] customMnrDatVrfyVOS = null;
    
	public CustomMnrDatVrfyVO[] getCustomMnrDatVrfyVOS() {
		return customMnrDatVrfyVOS;
	}

	public void setCustomMnrDatVrfyVOS(CustomMnrDatVrfyVO[] customMnrDatVrfyVOS) {
		this.customMnrDatVrfyVOS = customMnrDatVrfyVOS;
	}  
	
	//벨리데이션 체크 공통용 INVO
	private GeneralCodeINVO generalCodeINVO = null;

	public GeneralCodeINVO getGeneralCodeINVO() {
		return generalCodeINVO;
	}
    
	public void setGeneralCodeINVO(GeneralCodeINVO generalCodeINVO) {
		this.generalCodeINVO = generalCodeINVO;
	} 
	 
	//CustomMnrGeneralCodeVO  벨리데이션 체크 조회결과 
	private List<CustomMnrGeneralCodeVO> customMnrGeneralCodeVOS = null;
    
	public List<CustomMnrGeneralCodeVO> getCustomMnrGeneralCodeVOS() {
		return customMnrGeneralCodeVOS;
	}

	public void setCustomMnrGeneralCodeVOS(
			List<CustomMnrGeneralCodeVO> customMnrGeneralCodeVOS) {
		this.customMnrGeneralCodeVOS = customMnrGeneralCodeVOS;
	}

	private List<CustomMnrDatVrfyVO> customMnrDatVrfyListVO = null;     

	public List<CustomMnrDatVrfyVO> getCustomMnrDatVrfyListVO() {
		return customMnrDatVrfyListVO;
	}
	public void setCustomMnrDatVrfyListVO(List<CustomMnrDatVrfyVO> customMnrDatVrfyListVO) {
		this.customMnrDatVrfyListVO = customMnrDatVrfyListVO;
	}
}
