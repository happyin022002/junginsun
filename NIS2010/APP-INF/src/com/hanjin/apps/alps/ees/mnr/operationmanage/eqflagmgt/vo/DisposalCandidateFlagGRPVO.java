/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : DisposalCandidateFlagGRPVO
 *@FileTitle : 
 *Open Issues :	
 *Change history :
 *@LastModifyDate : 2009. 9. 15.
 *@LastModifier : 
 *@LastVersion : 1.0
 *2009. 09. 15. 권영법
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
 
/**
 * DisposalCandidateFlagGRPVO GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 권영법 
 * @since J2EE 1.5 
 * @see	  ..   
 */
public class DisposalCandidateFlagGRPVO {
	//IN 
	private DisposalCandidateFlagINVO disposalCandidateFlagINVO = null;
	//SEARCH 
	private List<CustomMnrEqStsVO> customMnrEqStsVOS = null; 
	//SEARCH 
	private List<CustomMnrEqRngStsVO> customMnrEqRngStsVOS = null; 
	//MULTI  
	private CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = null;   
	//MULTI  
	private CustomMnrEqRngStsVO[] arrCustomMnrEqRngStsVOS = null;  
	 
	//EQ Range에서 EQ_no를 구하기 위한    
	private List<IFMnrFlagVO> iFMnrFlagVOS = null; 
	//EQ Range에서 EQ_no를 구하기 위한  
	private IFMnrFlagVO iFMnrFlagVO = null;   
	//EQ Range에서 EQ_no를 구하기 위한      
	private String eqFrNo = ""; 
	//EQ Range에서 EQ_no를 구하기 위한  
	private String eqToNo = "";
	//EQ Range에서 EQ_no를 구하기 위한  
	private String eqPfx = ""; 
	
	public List<IFMnrFlagVO> getIFMnrFlagVOS() {
		return iFMnrFlagVOS;
	}

	public void setIFMnrFlagVOS(List<IFMnrFlagVO> mnrFlagVOS) {
		iFMnrFlagVOS = mnrFlagVOS;
	}
	
	public IFMnrFlagVO getIFMnrFlagVO() {
		return iFMnrFlagVO;
	}

	public void setIFMnrFlagVO(IFMnrFlagVO mnrFlagVO) {
		iFMnrFlagVO = mnrFlagVO;
	}

	public String getEqFrNo() {
		return eqFrNo;
	}

	public void setEqFrNo(String eqFrNo) {
		this.eqFrNo = eqFrNo;
	}

	public String getEqToNo() {
		return eqToNo;
	}

	public void setEqToNo(String eqToNo) {
		this.eqToNo = eqToNo;
	}

	public String getEqPfx() {
		return eqPfx;
	}

	public void setEqPfx(String eqPfx) {
		this.eqPfx = eqPfx;
	}
	
	public List<CustomMnrEqRngStsVO> getCustomMnrEqRngStsVOS() {
		return customMnrEqRngStsVOS;
	} 

	public void setCustomMnrEqRngStsVOS(List<CustomMnrEqRngStsVO> customMnrEqRngStsVOS) {
		this.customMnrEqRngStsVOS = customMnrEqRngStsVOS;
	}

	public CustomMnrEqRngStsVO[] getarrCustomMnrEqRngStsVOS() {
		return arrCustomMnrEqRngStsVOS;
	}

	public void setArrCustomMnrEqRngStsVOS(CustomMnrEqRngStsVO[] arrCustomMnrEqRngStsVOS) {
		this.arrCustomMnrEqRngStsVOS = arrCustomMnrEqRngStsVOS;
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
    
	public DisposalCandidateFlagINVO getDisposalCandidateFlagINVO() {
		return disposalCandidateFlagINVO;
	}
	
	public void setDisposalCandidateFlagINVO(DisposalCandidateFlagINVO disposalCandidateFlagINVO) {
		this.disposalCandidateFlagINVO = disposalCandidateFlagINVO;
	}
}
