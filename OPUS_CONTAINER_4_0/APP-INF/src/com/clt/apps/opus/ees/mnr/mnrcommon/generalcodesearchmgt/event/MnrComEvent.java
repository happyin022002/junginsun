/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MnrCommonEvent.java
*@FileTitle : 공통펑션으로 코드값과 디스크립션을 받아온다.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 박명신 
*@LastVersion : 1.0   
* 2009.05.12 박명신 
* 1.0 Creation 
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.event;

import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.PartnerMgtINVO;
import com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.BkgTrdCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ComboInitDataINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CommonInitDataINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMdmCurrencyVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomerInfoVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.DefaultUnitOfMeasureVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.EQGeneralInfoINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.OfficeInfoListVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.UnitPriceGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.VesselInfoVO;
import com.clt.framework.support.layer.event.EventSupport;
    
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
	
	private CustomMnrEqStsVVO customMnrEqStsVVO = null;
	
	private BkgTrdCodeVO bkgTrdCodeVO;
	private OfficeInfoListVO officeInfoListVO;
	
	public OfficeInfoListVO getOfficeInfoListVO() {
		return officeInfoListVO;
	}

	public void setOfficeInfoListVO(OfficeInfoListVO officeInfoListVO) {
		this.officeInfoListVO = officeInfoListVO;
	}

	public BkgTrdCodeVO getBkgTrdCodeVO() {
		return bkgTrdCodeVO;
	}

	public void setBkgTrdCodeVO(BkgTrdCodeVO bkgTrdCodeVO) {
		this.bkgTrdCodeVO = bkgTrdCodeVO;
	}

	public CustomMnrEqStsVVO getCustomMnrEqStsVVO() {
		return customMnrEqStsVVO;
	}

	public void setCustomMnrEqStsVVO(CustomMnrEqStsVVO customMnrEqStsVVO) {
		this.customMnrEqStsVVO = customMnrEqStsVVO;
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
		ComboInitDataINVO[] rtnVOs = null;
		if (this.comboInitDataINVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(comboInitDataINVOS, comboInitDataINVOS.length);
		}
		return rtnVOs;
	}
	public void setComboInitDataINVOS(ComboInitDataINVO[] comboInitDataINVOS){
		if(comboInitDataINVOS != null){
			ComboInitDataINVO[] tmpVOs = java.util.Arrays.copyOf(comboInitDataINVOS, comboInitDataINVOS.length);
			this.comboInitDataINVOS = tmpVOs;
		}
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
		VesselInfoVO[] rtnVOs = null;
		if (this.vesselInfoVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(vesselInfoVOS, vesselInfoVOS.length);
		}
		return rtnVOs;
	}
	public void setVesselInfoVOS(VesselInfoVO[] vesselInfoVOS){
		if(vesselInfoVOS != null){
			VesselInfoVO[] tmpVOs = java.util.Arrays.copyOf(vesselInfoVOS, vesselInfoVOS.length);
			this.vesselInfoVOS = tmpVOs;
		}
	}

	public CustomerInfoVO getCustomerInfoVO() {
		return customerInfoVO;
	}
	public void setCustomerInfoVO(CustomerInfoVO customerInfoVO) {
		this.customerInfoVO = customerInfoVO;
	} 
	public CustomerInfoVO[] getCustomerInfoVOS() {
		CustomerInfoVO[] rtnVOs = null;
		if (this.customerInfoVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(customerInfoVOS, customerInfoVOS.length);
		}
		return rtnVOs;
	}
	public void setCustomerInfoVOS(CustomerInfoVO[] customerInfoVOS){
		if(customerInfoVOS != null){
			CustomerInfoVO[] tmpVOs = java.util.Arrays.copyOf(customerInfoVOS, customerInfoVOS.length);
			this.customerInfoVOS = tmpVOs;
		}
	}
	
	public CustomMdmCurrencyVO getCustomMdmCurrencyVO() {
		return customMdmCurrencyVO;
	}
	public void setCustomMdmCurrencyVO(
			CustomMdmCurrencyVO customMdmCurrencyVO) {
		this.customMdmCurrencyVO = customMdmCurrencyVO;
	}	
}