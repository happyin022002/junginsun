/*=========================================================
 *Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeSearchGRPVO
*@FileTitle : 
*Open Issues :	
*Change history :
*@LastModifyDate : 2009. 5. 12.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 5. 12. 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

import java.util.List;
 
/**
 * DamageLocationCodeList GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 박명신 
 * @since J2EE 1.5 
 * @see	  ..   
 */
 
public class GeneralCodeSearchGRPVO {
	//공통코드 콤보용
	private ComboInitDataINVO[] comboInitDataINVOS = null;
	  
	public void setComboInitDataINVOS(ComboInitDataINVO[] comboInitDataINVOS) {
		this.comboInitDataINVOS = comboInitDataINVOS;
	}
	
	public ComboInitDataINVO[] getComboInitDataINVOS() {
		return comboInitDataINVOS;
	}
	
	private List<List<CustomMnrGeneralCodeVO>> listCustomMnrGeneralCodeVOS = null;
	
	public void setListCustomMnrGeneralCodeVOS(
			List<List<CustomMnrGeneralCodeVO>> listCustomMnrGeneralCodeVOS) {
		this.listCustomMnrGeneralCodeVOS = listCustomMnrGeneralCodeVOS;
	}  
	 
	public List<List<CustomMnrGeneralCodeVO>> getListCustomMnrGeneralCodeVOS() {
		return listCustomMnrGeneralCodeVOS;
	}
	 
	//로케이션별 EQ_COMP_CD용
	private List<CustomEqCompCdVO>  customEqCompCdVOS = null;
	
    public List<CustomEqCompCdVO> getCustomEqCompCdVOS() {
		return customEqCompCdVOS;
	}

	public void setCustomEqCompCdVOS(List<CustomEqCompCdVO> customEqCompCdVOS) {
		this.customEqCompCdVOS = customEqCompCdVOS;
	}

	//공통코드 그리드용 추가 
	private CommonInitDataINVO commonInitDataINVO = null;
	    
	public CommonInitDataINVO getCommonInitDataINVO() {
		return commonInitDataINVO;
	}
	public void setCommonInitDataINVO(CommonInitDataINVO commonInitDataINVO) {
		this.commonInitDataINVO = commonInitDataINVO;
	}  
     
	//EQGeneralInfo 조회  
	//Depreciated Value Inquiry 다중조회 결과값을 받기위한 리스트 추가
	private EQGeneralInfoINVO eQGeneralInfoINVO = null;
	
	public EQGeneralInfoINVO getEQGeneralInfoINVO() {
		return eQGeneralInfoINVO;
	}
	
	public void setEQGeneralInfoINVO(EQGeneralInfoINVO generalInfoINVO) {
		eQGeneralInfoINVO = generalInfoINVO;
	} 
	
	private List<List<CustomMnrEqStsVVO>> listCustomMnrEqStsVVOs = null;
	 
	public List<List<CustomMnrEqStsVVO>> getListCustomMnrEqStsVVOs() {
		return listCustomMnrEqStsVVOs;
	}
	public void setListCustomMnrEqStsVVOs(
			List<List<CustomMnrEqStsVVO>> listCustomMnrEqStsVVOs) {
		this.listCustomMnrEqStsVVOs = listCustomMnrEqStsVVOs;
	}
		
	private List<CustomMnrGeneralCodeVO> customMnrGeneralCodeVOS = null;

	public List<CustomMnrGeneralCodeVO> getCustomMnrGeneralCodeVOS() {
		return customMnrGeneralCodeVOS;
	}   
		
	public void setCustomMnrGeneralCodeVOS(
			List<CustomMnrGeneralCodeVO> customMnrGeneralCodeVOS) {
		this.customMnrGeneralCodeVOS = customMnrGeneralCodeVOS;
	}
	
	//VesselCode 용 
	private VesselInfoVO vesselInfoVO = null;


	public VesselInfoVO getVesselInfoVO() {
		return vesselInfoVO;
	}

	public void setVesselInfoVO(VesselInfoVO vesselInfoVO) {
		this.vesselInfoVO = vesselInfoVO;
	}   
	
	private List<VesselInfoVO> vesselInfoVOS = null;

	
	public List<VesselInfoVO> getVesselInfoVOS() {
		return vesselInfoVOS;
	}   
	public void setVesselInfoVOS(
			List<VesselInfoVO> vesselInfoVOS) {
		this.vesselInfoVOS = vesselInfoVOS;
	}
	
	//Customer 정보용 
	private CustomerInfoVO customerInfoVO = null;


	public CustomerInfoVO getCustomerInfoVO() {
		return customerInfoVO;
	}

	public void setCustomerInfoVO(CustomerInfoVO customerInfoVO) {
		this.customerInfoVO = customerInfoVO;
	}   
	
	private List<CustomerInfoVO> customerInfoVOS = null;

	
	public List<CustomerInfoVO> getCustomerInfoVOS() {
		return customerInfoVOS;
	}   
	public void setCustomerInfoVOS(
			List<CustomerInfoVO> customerInfoVOS) {
		this.customerInfoVOS = customerInfoVOS;
	}
}
