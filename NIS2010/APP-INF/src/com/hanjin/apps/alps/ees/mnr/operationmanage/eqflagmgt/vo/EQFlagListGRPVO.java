/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EQFlagListGRPVO
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
 
/**
 * EQFlagListGRPVO GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 박명신 
 * @since J2EE 1.5 
 * @see	  ..   
 */
public class EQFlagListGRPVO {
	//IN 
	private EQFlagListINVO eQFlagListINVO = null;
	//SEARCH 
	private List<CustomMnrEqStsVO> customMnrEqStsVOS = null; 
	//SEARCH 
	private List<CustomMnrFlgHisVO> customMnrFlgHisVOS = null; 
	//MULTI  
	private CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = null;   
	//MULTI  
	private CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = null;  
	
	//EES_MNR_0058-0109 SEARCH	
	private CustomMnrEqStsVO customMnrEqStsVO = null;	           
			
	public CustomMnrEqStsVO getCustomMnrEqStsVO() {
		return customMnrEqStsVO;
	}

	public void setCustomMnrEqStsVO(CustomMnrEqStsVO customMnrEqStsVO) {
		this.customMnrEqStsVO = customMnrEqStsVO;
	}

	public List<CustomMnrFlgHisVO> getCustomMnrFlgHisVOS() {
		return customMnrFlgHisVOS;
	} 

	public void setCustomMnrFlgHisVOS(List<CustomMnrFlgHisVO> customMnrFlgHisVOS) {
		this.customMnrFlgHisVOS = customMnrFlgHisVOS;
	}

	public CustomMnrFlgHisVO[] getArrCustomMnrFlgHisVOS() {
		return arrCustomMnrFlgHisVOS;
	}

	public void setArrCustomMnrFlgHisVOS(CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS) {
		this.arrCustomMnrFlgHisVOS = arrCustomMnrFlgHisVOS;
	}

	public CustomMnrEqStsVO[] getArrCustomMnrEqStsVOS() {
		return arrCustomMnrEqStsVOS;
	}

	public void setArrCustomMnrEqStsVOS(CustomMnrEqStsVO[] arrCustomMnrEqStsVOS) {
		this.arrCustomMnrEqStsVOS = arrCustomMnrEqStsVOS;
	}

	public List<CustomMnrEqStsVO> getCustomMnrEqStsVOS() {
		return customMnrEqStsVOS; 
	}  
    
	public void setCustomMnrEqStsVOS(List<CustomMnrEqStsVO> customMnrEqStsVOS) {
		this.customMnrEqStsVOS = customMnrEqStsVOS;
	}
    
	public EQFlagListINVO getEQFlagListINVO() {
		return eQFlagListINVO;
	}
	
	public void setEQFlagListINVO(EQFlagListINVO flagListINVO) {
		eQFlagListINVO = flagListINVO;
	}
}
