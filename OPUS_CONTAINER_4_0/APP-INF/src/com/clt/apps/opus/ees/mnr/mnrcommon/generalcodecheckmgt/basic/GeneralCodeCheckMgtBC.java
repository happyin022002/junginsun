/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtBC.java 
*@FileTitle : Damage Flagging/Unflagging Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.basic;

import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.VerifyTariffFileListGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeCheckMgtGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalPriceFileListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.SoldEQFileListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.VerifyEQFlagFileListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.VerifyEQTypeSizeFlagFileListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.VerifyRPRCreateFileListGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

  
/**
 * COM-Operationmanage Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_mnr_0139EventResponse reference
 * @since J2EE 1.4   
 */

public interface GeneralCodeCheckMgtBC {
	/**
	 * [EES_MNR_S139]verifying Repair Creation File Import_Pop Up.  <br>
	 * 	
	 * handling event validaion on EES_MNR_S139<br>
	 * @param  VerifyRPRCreateFileListGRPVO verifyRPRCreateFileListGRPVO
	 * @return VerifyRPRCreateFileListGRPVO
	 * @exception EventException  
	 */    
	public VerifyRPRCreateFileListGRPVO verifyRPRCreateFileListBasic(VerifyRPRCreateFileListGRPVO verifyRPRCreateFileListGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0023] checking Repair Estimate Creation. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException
	 */	
	public EstimateGRPVO verifyEstimateCalcBasic(EstimateGRPVO estimateGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0139]checking Damage Flagging/Unflagging Pop Up. <br>
	 *
	 * @param VerifyEQFlagFileListGRPVO verifyEQFlagFileListGRPVO
	 * @return VerifyEQFlagFileListGRPVO	
	 * @exception EventException
	 */
	public VerifyEQFlagFileListGRPVO verifyEQFlagFileListBasic(VerifyEQFlagFileListGRPVO verifyEQFlagFileListGRPVO) throws EventException;
		
	/**
	 * [EES_MNR_0221]handling Sold Creation File Import_Pop Up. <br>
	 *
	 * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */      
	public String createMnrTempBasic(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0226]checking Vessel Reefer Spare Part Purchase W/O Creation. <br>
	 *
	 * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	 * @return GeneralCodeCheckMgtGRPVO
	 * @exception EventException
	 */      
	public GeneralCodeCheckMgtGRPVO checkGeneralCodeBasic(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO) throws EventException;


	/**
	 * [EES_MNR_0143]checking M&R Invoice Creation File Import Pop Up. <br>
	 *
	 * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralCodeCheckMgtGRPVO
	 * @exception EventException
	 */
	public GeneralCodeCheckMgtGRPVO verifyPayableInvoiceFileListBasic(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0219] checking M&R Simple WO File Import Pop_Up. <br>
	 *
	 * @param VerifyEQTypeSizeFlagFileListGRPVO verifyEQTypeSizeFlagFileListGRPVO
	 * @return VerifyEQTypeSizeFlagFileListGRPVO
	 * @exception EventException
	 */
	public VerifyEQTypeSizeFlagFileListGRPVO verifyWOFileListBasic(VerifyEQTypeSizeFlagFileListGRPVO verifyEQTypeSizeFlagFileListGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0220]checking Disposal Price File Import_Pop Up. <br>
	 *
	 * @param DisposalPriceFileListGRPVO disposalPriceFileListGRPVO
	 * @return DisposalPriceFileListGRPVO
	 * @exception EventException
	 */
	public DisposalPriceFileListGRPVO verifyDisposalPriceFileListBasic(DisposalPriceFileListGRPVO disposalPriceFileListGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0190]handling Standard Tariff File Import_Pop Up. <br>
	 *
	 * @param VerifyTariffFileListGRPVO verifyTariffFileListGRPVO
	 * @return VerifyTariffFileListGRPVO
	 * @exception EventException
	 */        
	public VerifyTariffFileListGRPVO verifyTariffFileListBasic(VerifyTariffFileListGRPVO verifyTariffFileListGRPVO) throws EventException;

	/**
	 * [EES_MNR_0190]handling Local Tariff File Import_Pop Up. <br>
	 *
	 * @param VerifyTariffFileListGRPVO verifyTariffFileListGRPVO
	 * @return VerifyTariffFileListGRPVO
	 * @exception EventException
	 */        
	public VerifyTariffFileListGRPVO verifyLocalTariffFileListBasic(VerifyTariffFileListGRPVO verifyTariffFileListGRPVO) throws EventException;
	
	/** 
	 * [EES_MNR_0221]checking Sold Creation File Import_Pop Up. <br>
	 *
	 * @param SoldEQFileListGRPVO soldEQFileListGRPVO
	 * @return SoldEQFileListGRPVO
	 * @exception EventException
	 */          
	public SoldEQFileListGRPVO verifySoldEQFileListBasic(SoldEQFileListGRPVO soldEQFileListGRPVO) throws EventException;

	/**
	 * [EES_MNR_0141]Change Currency M&R Invoice . <br>
	 *
	 * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralCodeCheckMgtGRPVO
	 * @exception EventException
	 */
	public GeneralCodeCheckMgtGRPVO searchPayableINVInquiryCalCurrRateBasic(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [common]Check Tariff Flag <br>
	 *
	 * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String checkTariffFlagBasic(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO, SignOnUserAccount account) throws EventException;

}