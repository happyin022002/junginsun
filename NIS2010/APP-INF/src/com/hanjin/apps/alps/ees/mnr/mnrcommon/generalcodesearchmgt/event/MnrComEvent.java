/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MnrCommonEvent.java
*@FileTitle : 공통펑션으로 코드값과 디스크립션을 받아온다.
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.04
*@LastModifier : 조경완 
*@LastVersion : 1.0   
* 2009.05.12 박명신 
* 1.0 Creation 
* 2013.01.04 조경완 [CHM-201220942-01] ALPS MNR-Total Loss Module에서 Write Off 처리 건을 위하여 추가 메뉴 개발 요청                       
* 2013.01.04 조경완 [CHM-201220984-01] ALPS MNR-Total Loss-Write Off - Approval
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.ApprovalStepGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.PartnerMgtINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ComboInitDataINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CommonInitDataINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMdmCurrencyVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomerInfoVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.DefaultUnitOfMeasureVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.EQGeneralInfoINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.EtcInfoGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.MnrCommonVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.UnitPriceGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.VesselInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
    
/**
 * MNR_COM 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  MNR_COM_HTMLAction 에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author park myoung sin
 * @see MNR_COM_HTMLAction 참조 
 * @since J2EE 1.4 
 */ 
     
public class MnrComEvent extends EventSupport { 
	private static final long serialVersionUID = 1L;
	
	public MnrComEvent(){} 
	
	/** Table Value Object 조회 조건 */
	//공통코드 콤보용
	private ComboInitDataINVO[] comboInitDataINVOS = null;
	
	//공통코드 그리드용 추가	
	private CommonInitDataINVO commonInitDataINVO = null;    
	
	//EQGeneralInfo 조회  		
	private EQGeneralInfoINVO eQGeneralInfoINVO = null;
	
	//벨리데이션 체크 공용 
	private GeneralCodeINVO generalCodeINVO = null;    
	
	//Service Provider Detail Information   
	private PartnerMgtINVO partnerMgtINVO = null;  
	
	//Agreement Rt
	private AGMTRtGRPVO agmtRtGRPVO = null;
	
	//Cost Code 구하기 
	private CostCodeGRPVO costCodeGRPVO = null;
	
	//Vessel Code 구하기 
	private VesselInfoVO vesselInfoVO = null; 
	private VesselInfoVO[] vesselInfoVOS = null;
	
	//Status History 
	private StatusHistoryGRPVO statusHistoryGRPVO = null;
	
	//Unit Price
	private UnitPriceGRPVO unitPriceGRPVO = null;
	
	//Customer 구하기 
	private CustomerInfoVO customerInfoVO = null; 
	private CustomerInfoVO[] customerInfoVOS = null;
	
	//Default Unit Of Measure
	private DefaultUnitOfMeasureVO defaultUnitOfMeasureVO = null;

	//Currency별 소수점자리
	private CustomMdmCurrencyVO customMdmCurrencyVO = null;	
	
	//로칼 데이트 정보 가져오기	
	private EtcInfoGRPVO etcInfoGRPVO = null;
	
	//Approval Step
	private ApprovalStepGRPVO approvalStepGRPVO = null;
	
	//MNR Common
	private MnrCommonVO mnrCommonVO = null;
	private MnrCommonVO[] mnrCommonVOs = null;
	
	/**
	 * @return the mnrCommonVO
	 */
	public MnrCommonVO getMnrCommonVO() {
		return mnrCommonVO;
	}

	/**
	 * @param mnrCommonVO the mnrCommonVO to set
	 */
	public void setMnrCommonVO(MnrCommonVO mnrCommonVO) {
		this.mnrCommonVO = mnrCommonVO;
	}

	/**
	 * @return the mnrCommonVOs
	 */
	public MnrCommonVO[] getMnrCommonVOs() {
		return mnrCommonVOs;
	}

	/**
	 * @param mnrCommonVOs the mnrCommonVOs to set
	 */
	public void setMnrCommonVOs(MnrCommonVO[] mnrCommonVOs) {
		this.mnrCommonVOs = mnrCommonVOs;
	}

	public ApprovalStepGRPVO getApprovalStepGRPVO() {
		return approvalStepGRPVO;
	}

	public void setApprovalStepGRPVO(ApprovalStepGRPVO approvalStepGRPVO) {
		this.approvalStepGRPVO = approvalStepGRPVO;
	}

	public EtcInfoGRPVO getEtcInfoGRPVO() {
		return etcInfoGRPVO;
	}

	public void setEtcInfoGRPVO(EtcInfoGRPVO etcInfoGRPVO) {
		this.etcInfoGRPVO = etcInfoGRPVO;
	}

	public DefaultUnitOfMeasureVO getDefaultUnitOfMeasureVO() {
		return defaultUnitOfMeasureVO;
	}

	public void setDefaultUnitOfMeasureVO(
			DefaultUnitOfMeasureVO defaultUnitOfMeasureVO) {
		this.defaultUnitOfMeasureVO = defaultUnitOfMeasureVO;
	}

	public UnitPriceGRPVO getUnitPriceGRPVO() {
		return unitPriceGRPVO;
	}

	public void setUnitPriceGRPVO(UnitPriceGRPVO unitPriceGRPVO) {
		this.unitPriceGRPVO = unitPriceGRPVO;
	}
	
	public CostCodeGRPVO getCostCodeGRPVO() {
		return costCodeGRPVO;
	}

	public void setCostCodeGRPVO(CostCodeGRPVO costCodeGRPVO) {
		this.costCodeGRPVO = costCodeGRPVO;
	}
	
	public PartnerMgtINVO getPartnerMgtINVO() {
		return partnerMgtINVO;
	}

	public void setPartnerMgtINVO(PartnerMgtINVO partnerMgtINVO) {
		this.partnerMgtINVO = partnerMgtINVO;
	}
	
	public AGMTRtGRPVO getAGMTRtGRPVO() {
		return agmtRtGRPVO;
	}
    
	public void setAGMTRtGRPVO(AGMTRtGRPVO agmtRtGRPVO) {
		this.agmtRtGRPVO = agmtRtGRPVO;
	}
	 
	public StatusHistoryGRPVO getStatusHistoryGRPVO() {
		return statusHistoryGRPVO;
	}
	 
	public void setStatusHistoryGRPVO(StatusHistoryGRPVO statusHistoryGRPVO) {
		this.statusHistoryGRPVO = statusHistoryGRPVO;
	} 
	
	public GeneralCodeINVO getGeneralCodeINVO() {
		return generalCodeINVO; 
	}  
	public void setGeneralCodeINVO(GeneralCodeINVO generalCodeINVO) {
		this.generalCodeINVO = generalCodeINVO;
	}
	public ComboInitDataINVO[] getComboInitDataINVOS() {
		return comboInitDataINVOS;
	}
	public void setComboInitDataINVOS(ComboInitDataINVO[] comboInitDataINVOS) {
		this.comboInitDataINVOS = comboInitDataINVOS;
	}
	public CommonInitDataINVO getCommonInitDataINVO() {
		return commonInitDataINVO;
	}
	public void setCommonInitDataINVO(CommonInitDataINVO commonInitDataINVO) {
		this.commonInitDataINVO = commonInitDataINVO;
	}
	public EQGeneralInfoINVO getEQGeneralInfoINVO() {
		return eQGeneralInfoINVO;
	}
	public void setEQGeneralInfoINVO(EQGeneralInfoINVO generalInfoINVO) {
		eQGeneralInfoINVO = generalInfoINVO;
	} 
	public VesselInfoVO getVesselInfoVO() {
		return vesselInfoVO;
	}
	public void setVesselInfoVO(VesselInfoVO vesselInfoVO) {
		this.vesselInfoVO = vesselInfoVO;
	} 
	public VesselInfoVO[] getVesselInfoVOS() {
		return vesselInfoVOS;
	}
	public void setVesselInfoVOS(VesselInfoVO[] vesselInfoVOS) {
		this.vesselInfoVOS = vesselInfoVOS;
	}

	public CustomerInfoVO getCustomerInfoVO() {
		return customerInfoVO;
	}
	public void setCustomerInfoVO(CustomerInfoVO customerInfoVO) {
		this.customerInfoVO = customerInfoVO;
	} 
	public CustomerInfoVO[] getCustomerInfoVOS() {
		return customerInfoVOS;
	}
	public void setCustomerInfoVOS(CustomerInfoVO[] customerInfoVOS) {
		this.customerInfoVOS = customerInfoVOS;
	}
	
	public CustomMdmCurrencyVO getCustomMdmCurrencyVO() {
		return customMdmCurrencyVO;
	}
	public void setCustomMdmCurrencyVO(
			CustomMdmCurrencyVO customMdmCurrencyVO) {
		this.customMdmCurrencyVO = customMdmCurrencyVO;
	}	
}