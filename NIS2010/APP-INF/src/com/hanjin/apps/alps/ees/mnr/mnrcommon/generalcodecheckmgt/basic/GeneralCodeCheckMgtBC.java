/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtBC.java 
*@FileTitle : Damage Flagging/Unflagging Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.19 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.basic;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.VerifyTariffFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeCheckMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalPriceFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.SoldEQFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.VerifyEQFlagFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.VerifyEQTypeSizeFlagFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.VerifyRPRCreateFileListGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

  
/**
 * alps-Operationmanage Business Logic Command Interface<br>
 * - alps-Operationmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author park myoung sin
 * @see Ees_mnr_0139EventResponse 참조
 * @since J2EE 1.4   
 */

public interface GeneralCodeCheckMgtBC {
	/**
	 * [EES_MNR_S139]Repair Creation File Import_Pop Up의 정보를 검증 합니다.  <br>
	 * 	
	 * EES_MNR_S139화면에 대한 벨리데이션체크 이벤트 처리<br>
	 * @param  VerifyRPRCreateFileListGRPVO verifyRPRCreateFileListGRPVO
	 * @return VerifyRPRCreateFileListGRPVO
	 * @exception EventException  
	 */    
	public VerifyRPRCreateFileListGRPVO verifyRPRCreateFileListBasic(VerifyRPRCreateFileListGRPVO verifyRPRCreateFileListGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0023] Repair Estimate Creation의 정보를 체크 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException
	 */	
	public EstimateGRPVO verifyEstimateCalcBasic(EstimateGRPVO estimateGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0139]Damage Flagging/Unflagging Pop Up의 정보를 체크 합니다. <br>
	 *
	 * @param VerifyEQFlagFileListGRPVO verifyEQFlagFileListGRPVO
	 * @return VerifyEQFlagFileListGRPVO	
	 * @exception EventException
	 */
	public VerifyEQFlagFileListGRPVO verifyEQFlagFileListBasic(VerifyEQFlagFileListGRPVO verifyEQFlagFileListGRPVO) throws EventException;
		
	/**
	 * [EES_MNR_0221]Sold Creation File Import_Pop Up 의 정보를 작업 합니다. <br>
	 *
	 * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */      
	public String createMnrTempBasic(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0226]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 체크 합니다. <br>
	 *
	 * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	 * @return GeneralCodeCheckMgtGRPVO
	 * @exception EventException
	 */      
	public GeneralCodeCheckMgtGRPVO checkGeneralCodeBasic(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO) throws EventException;


	/**
	 * [EES_MNR_0143]M&R Invoice Creation File Import Pop Up의 정보를 체크 합니다. <br>
	 *
	 * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralCodeCheckMgtGRPVO
	 * @exception EventException
	 */
	public GeneralCodeCheckMgtGRPVO verifyPayableInvoiceFileListBasic(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0219] M&R Simple WO File Import Pop_Up의 정보를 체크 합니다. <br>
	 *
	 * @param VerifyEQTypeSizeFlagFileListGRPVO verifyEQTypeSizeFlagFileListGRPVO
	 * @return VerifyEQTypeSizeFlagFileListGRPVO
	 * @exception EventException
	 */
	public VerifyEQTypeSizeFlagFileListGRPVO verifyWOFileListBasic(VerifyEQTypeSizeFlagFileListGRPVO verifyEQTypeSizeFlagFileListGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0220]Disposal Price File Import_Pop Up의 정보를 체크 합니다. <br>
	 *
	 * @param DisposalPriceFileListGRPVO disposalPriceFileListGRPVO
	 * @return DisposalPriceFileListGRPVO
	 * @exception EventException
	 */
	public DisposalPriceFileListGRPVO verifyDisposalPriceFileListBasic(DisposalPriceFileListGRPVO disposalPriceFileListGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0190]Standard Tariff File Import_Pop Up의 정보를 작업 합니다. <br>
	 *
	 * @param VerifyTariffFileListGRPVO verifyTariffFileListGRPVO
	 * @return VerifyTariffFileListGRPVO
	 * @exception EventException
	 */        
	public VerifyTariffFileListGRPVO verifyTariffFileListBasic(VerifyTariffFileListGRPVO verifyTariffFileListGRPVO) throws EventException;

	/**
	 * [EES_MNR_0190]Local Tariff File Import_Pop Up의 정보를 작업 합니다. <br>
	 *
	 * @param VerifyTariffFileListGRPVO verifyTariffFileListGRPVO
	 * @return VerifyTariffFileListGRPVO
	 * @exception EventException
	 */        
	public VerifyTariffFileListGRPVO verifyLocalTariffFileListBasic(VerifyTariffFileListGRPVO verifyTariffFileListGRPVO) throws EventException;
	
	/** 
	 * [EES_MNR_0221]Sold Creation File Import_Pop Up 의 정보를 체크 합니다. <br>
	 *
	 * @param SoldEQFileListGRPVO soldEQFileListGRPVO
	 * @return SoldEQFileListGRPVO
	 * @exception EventException
	 */          
	public SoldEQFileListGRPVO verifySoldEQFileListBasic(SoldEQFileListGRPVO soldEQFileListGRPVO) throws EventException;

	/**
	 * [EES_MNR_0141]M&R Invoice 금 을 환율변경적용 합니다. <br>
	 *
	 * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralCodeCheckMgtGRPVO
	 * @exception EventException
	 */
	public GeneralCodeCheckMgtGRPVO searchPayableINVInquiryCalCurrRateBasic(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0252]EDI Estimate Group Auditing의 EDI정보 처리 작업 합니다. <br>
	 *
	 * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */      
	public String createMnrTempDetail(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0023] Repair Estimate Creation의 정보를 체크 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException
	 */	
	public EstimateGRPVO verifyEstimateCalcDetail(EstimateGRPVO estimateGRPVO) throws EventException;
	
}