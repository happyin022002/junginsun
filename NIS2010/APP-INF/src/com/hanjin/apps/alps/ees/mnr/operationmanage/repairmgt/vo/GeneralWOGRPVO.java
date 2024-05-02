/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExtraWOGRPVO.java
*@FileTitle : ExtraWOGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.07.09 정영훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.hanjin.framework.component.common.AbstractValueObject;
	
/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정영훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GeneralWOGRPVO {
	
	private static final long serialVersionUID = 1L;
	
    private GeneralWOINVO generalWOINVO = null;
    private EQFlagListINVO eQFlagListINVO = null;    
    
    //Invoice Status를 저장하기 위한
    private String mnrInvStsCd = null;
    
	public String getMnrInvStsCd() {
		return mnrInvStsCd;
	}

	public void setMnrInvStsCd(String mnrInvStsCd) {
		this.mnrInvStsCd = mnrInvStsCd;
	}
	//verify and verify save을 위한  	 	 
	private CustomMnrOrdHdrVO customMnrOrdHdrVO = null; 
    private  List <CustomBzcAmtVO> customBzcAmtVOLST = null;
    
	private  CustomMnrOrdHdrVO[] arrCustomMnrOrdHdrVO = null;
    private  List <CustomMnrOrdHdrVO> customMnrOrdHdrVOLst = null;

    private  CustomMnrOrdDtlVO[] arrCustomMnrOrdDtlVO = null;
    private  List <CustomMnrOrdDtlVO> customMnrOrdDtlVOLst = null;
	
	private CustomMnrOrdDtlVO[] arrCustomMnrOrdDtlVOS = null;
	private CustomMnrOrdDtlVO customMnrOrdDtlVO = null;
	
	public GeneralWOGRPVO(){}

	public GeneralWOINVO getGeneralWOINVO() {
		return generalWOINVO;
	}

	public void setGeneralWOINVO(GeneralWOINVO generalWOINVO) {
		this.generalWOINVO = generalWOINVO;
	}

	public EQFlagListINVO getEQFlagListINVO() {
		return eQFlagListINVO;
	}

	public void setEQFlagListINVO(EQFlagListINVO eQFlagListINVO) {
		this.eQFlagListINVO = eQFlagListINVO;
	}
	
	public CustomMnrOrdHdrVO getCustomMnrOrdHdrVO() {
		return customMnrOrdHdrVO;  
	}
	public void setCustomMnrOrdHdrVO(CustomMnrOrdHdrVO customMnrOrdHdrVO) {
		this.customMnrOrdHdrVO = customMnrOrdHdrVO;
	}
	

	public CustomMnrOrdHdrVO[] getArrCustomMnrOrdHdrVO() {
		return arrCustomMnrOrdHdrVO;
	}

	public void setArrCustomMnrOrdHdrVO(CustomMnrOrdHdrVO[] arrCustomMnrOrdHdrVO) {
		this.arrCustomMnrOrdHdrVO = arrCustomMnrOrdHdrVO;
	}

	public List<CustomMnrOrdHdrVO> getCustomMnrOrdHdrVOLst() {
		return customMnrOrdHdrVOLst;
	}

	public void setCustomMnrOrdHdrVOLst(List<CustomMnrOrdHdrVO> customMnrOrdHdrVOLst) {
		this.customMnrOrdHdrVOLst = customMnrOrdHdrVOLst;
	}

	public CustomMnrOrdDtlVO[] getArrCustomMnrOrdDtlVO() {
		return arrCustomMnrOrdDtlVO;
	}

	public void setArrCustomMnrOrdDtlVO(CustomMnrOrdDtlVO[] arrCustomMnrOrdDtlVO) {
		this.arrCustomMnrOrdDtlVO = arrCustomMnrOrdDtlVO;
	}
	
	public CustomMnrOrdDtlVO[] getArrCustomMnrOrdDtlVOS() {
		return arrCustomMnrOrdDtlVOS;
	}
	public void setArrCustomMnrOrdDtlVOS(
			CustomMnrOrdDtlVO[] arrCustomMnrOrdDtlVOS) {
		this.arrCustomMnrOrdDtlVOS = arrCustomMnrOrdDtlVOS;
	}

	public List<CustomMnrOrdDtlVO> getCustomMnrOrdDtlVOLst() {
		return customMnrOrdDtlVOLst;
	}

	public void setCustomMnrOrdDtlVOLst(List<CustomMnrOrdDtlVO> customMnrOrdDtlVOLst) {
		this.customMnrOrdDtlVOLst = customMnrOrdDtlVOLst;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public List<CustomBzcAmtVO> getCustomBzcAmtVOLST() {
		return customBzcAmtVOLST;
	}

	public void setCustomBzcAmtVOLST(List<CustomBzcAmtVO> customBzcAmtVOLST) {
		this.customBzcAmtVOLST = customBzcAmtVOLST;
	}

	public CustomMnrOrdDtlVO getCustomMnrOrdDtlVO() {
		return customMnrOrdDtlVO;  
	}
	public void setCustomMnrOrdDtlVO(CustomMnrOrdDtlVO customMnrOrdDtlVO) {
		this.customMnrOrdDtlVO = customMnrOrdDtlVO;
	}
	

}
