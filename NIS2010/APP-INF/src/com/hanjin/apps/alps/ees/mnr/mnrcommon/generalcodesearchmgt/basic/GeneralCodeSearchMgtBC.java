/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeSearchMgtBC.java
*@FileTitle : ghost
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.12 박명신
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.12.16 신혜정 [CHM-201115121-01] 유저아이디 Office Change 로 로긴정보 중 RHQ 변경 안되는 로직 보완
* 2011.12.27 신혜정 [CHM-201115280] Estimate Creation 화면 Reefer Uint Maker 필드 추가  
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.basic;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomerInfoVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.DefaultUnitOfMeasureVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.EtcInfoGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.GeneralCodeSearchGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ServiceProviderInfoListGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.UnitPriceGRPVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
	
/**
 * alps-Mnrcommon Business Logic Command Interface<br>
 * - alps-Mnrcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author park myoung sin
 * @see Ees_mnr_initEventResponse 참조
 * @since J2EE 1.4
 */
 
public interface GeneralCodeSearchMgtBC {
	/**
	 * [EES_MNR_0011] 스탠다드 타리프의 EQ TYPE별 디폴트 Unit Of Measure를 구합니다. <br>
	 *
	 * @param DefaultUnitOfMeasureVO InDefaultUnitOfMeasureVO
	 * @return DefaultUnitOfMeasureVO
	 * @exception EventException 
	 */  
	public DefaultUnitOfMeasureVO searchDEFUnitOfMeasureBasic(DefaultUnitOfMeasureVO inDefaultUnitOfMeasureVO) throws EventException;
	
	/**
	 * [EES_MNR_0189]M&R Service Provider Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param ServiceProviderInfoListGRPVO serviceProviderInfoListGRPVO
	 * @return ServiceProviderInfoListGRPVO
	 * @exception EventException
	 */
	public ServiceProviderInfoListGRPVO searchServiceProviderInfoListBasic(ServiceProviderInfoListGRPVO serviceProviderInfoListGRPVO) throws EventException ;
	/**
	 * [MNR_COMMON] 공통콤보를 조회합니다.<br>
	 * 
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @param SignOnUserAccount 	 account
	 * @return GeneralCodeSearchGRPVO 
	 * @exception EventException
	 */  
	public GeneralCodeSearchGRPVO searchComboInitDataListBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO,SignOnUserAccount account) throws EventException;
	/**
	 * [EES_MNR_0223]MNR PFMC by VNDR/Manufacturer의 정보를 조회 합니다. <br>
	 *
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @return GeneralCodeSearchGRPVO
	 * @exception EventException
	 */
	public GeneralCodeSearchGRPVO searchCommonInitDataListBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO) throws EventException;
	/**
	 * [EES_MNR_0226]Total Loss Request의 정보를 조회 합니다. <br>
	 *
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @return GeneralCodeSearchGRPVO
	 * @exception EventException
	 */
	public GeneralCodeSearchGRPVO searchEQGeneralInfoBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0226]Simple W/O Inquiry Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param AGMTRtGRPVO agmtRtGRPVO
	 * @return AGMTRtGRPVO
	 * @exception EventException
	 */
	public AGMTRtGRPVO searchAgmtRtInfoBasic(AGMTRtGRPVO agmtRtGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 조회 합니다. <br>
	 *
	 * @param CostCodeGRPVO costCodeGRPVO
	 * @return CostCodeGRPVO
	 * @exception EventException
	 */		 
	public CostCodeGRPVO searchCostCodeBasic(CostCodeGRPVO costCodeGRPVO) throws EventException;

	/**
	 * [EES_MNR_0194]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @return GeneralCodeSearchGRPVO
	 * @exception EventException
	 */		 
	public GeneralCodeSearchGRPVO searchVesselInfoBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO) throws EventException;

	/**
	 * [EES_MNR_0155]Disposal Buyer Management의 정보를 조회 합니다. <br>
	 *
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @return GeneralCodeSearchGRPVO
	 * @exception EventException
	 */		 
	public GeneralCodeSearchGRPVO searchCustomerInfoBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0157]Disposal Request의 정보를 조회 합니다. <br>
	 *
	 * @param UnitPriceGRPVO unitPriceGRPVO
	 * @return UnitPriceGRPVO
	 * @exception EventException
	 */
	public UnitPriceGRPVO searchUnitPriceBasic(UnitPriceGRPVO unitPriceGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0041]Conversion할 Curr rate를 조회 합니다.  <br>
	 *
	 * @param UnitPriceGRPVO unitPriceGRPVO
	 * @return UnitPriceGRPVO
	 * @exception EventException
	 */
	public UnitPriceGRPVO searchCurrXchRtInfoBasic(UnitPriceGRPVO unitPriceGRPVO) throws EventException;	
	
	/**
	 * [CoMnr] OFFICE 별 로칼 날짜(YYYY-MM-DD)를 조회합니다. <br>
	 *
	 * @param EtcInfoGRPVO etcInfoGRPVO
	 * @return EtcInfoGRPVO
	 * @exception EventException
	 */	
	public EtcInfoGRPVO searchLoCalDateInfoBasic(EtcInfoGRPVO etcInfoGRPVO) throws EventException;
	
	/**
	 * [CoMnr] SPP바이어 OFC정보를 조회 <br>
	 *	 
	 * @param EtcInfoGRPVO etcInfoGRPVO
	 * @return EtcInfoGRPVO
	 * @exception EventException
	 */	
	public EtcInfoGRPVO searchSPPOFCInfoBasic(EtcInfoGRPVO etcInfoGRPVO) throws EventException;
	
	/**
	 * [CoMnr]Office 의 RHQ 정보를 조회 합니다. <br>
	 * 
	 * @param CustomerInfoVO customerInfoVO 
	 * @return String 
	 * @throws EventException
	 */
	public String searchHqOfcByOfcBasic(CustomerInfoVO customerInfoVO) throws EventException;
	
	/**
	 * [EES_MNR_0019] rfUnitMaker를 조회 합니다. <br>
	 * 
	 * @param String eqNo
	 * @return CustomMnrEqStsVVO
	 * @throws EventException
	 */
	public CustomMnrEqStsVVO searchRfUnitMakerBasic(String eqNo) throws EventException;
	
	/**
	 * MNR 공통 조회 기능 <br>
	 * OFFICE CODE 의 AGMT NO 를 조회하여 AGMT NO 를 리턴<br>
	 * 
	 * @param String agmt_no
	 * @param String ofc_cd
	 * @return String return_agmt_no
	 * @exception EventException
	 */
	public String searchMnrAgmtNoBasic(String agmt_no, String ofc_cd) throws EventException;	
	
	/**
	 * India SAC Code Validation Check <br>
	 * Error Flag 를 리턴<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validSacCd(Event e) throws EventException;
	
	/**
	 * Office Code, Vendor Seq, SAC Code를 통한 India GST 세율 정보 조회 <br>
	 * CGST, SGST, IGST, UGST Rate 리턴<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception DAOException
	 */
	public EventResponse getIdaGstRto(Event e) throws EventException;
		
}