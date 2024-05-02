/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQFlagMgtBC.java
*@FileTitle : Damage Flagging/Unflagging Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic;

import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertListGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.DisposalCandidateFlagGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
	
/**
 * COM-Operationmanage Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_mnr_0139EventResponse reference
 * @since J2EE 1.4
 */ 
	
public interface EQFlagMgtBC {
	/**
	 * [EES_MNR_0122] retrieving Hanger Bar Attatch/Detach Qty by CNTR. <br>
	 *
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @return EQFlagListGRPVO
	 * @exception EventException
	 */ 
	public EQFlagListGRPVO searchEQFlagListBasic(EQFlagListGRPVO eQFlagListGRPVO) throws EventException;
	
	
	/**
	 * [EES_MNR_0122] adding/modification/deletion W/O Creation. <br>
	 *
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */   
	public void manageEQFlagListBasic(EQFlagListGRPVO eQFlagListGRPVO, SignOnUserAccount account) throws EventException;
		
	/**	
	 * [Damage Flagging/Unflagging Interface] calling Flagging , CTM <br> 
	 * modifying on MNR, MST, CGM 
	 * @param CustomMnrEqStsVO customMnrEqStsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	  
	public void manageIFFlagForOtherBasic(CustomMnrEqStsVO customMnrEqStsVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0125] retrieving Hanger Bar CNTR History. <br>
	 *
	 * @param EQFlagListGRPVO 	eQFlagListGRPVO
	 * @param SignOnUserAccount account
	 * @return EQFlagListGRPVO
	 * @exception EventException
	 */  
	public EQFlagListGRPVO searchEQFlagHistoryListBasic(EQFlagListGRPVO eQFlagListGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0151] retrieving Disposal Candidate Selection. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @return DisposalCandidateFlagGRPVO
	 * @exception EventException
	 */  
	public DisposalCandidateFlagGRPVO searchDisposalCandidatePopupListBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO) throws EventException;	

	/**
	 * [EES_MNR_0158] retrieving Disposal Candidate Inquiry_Pop Up. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @param SignOnUserAccount account   
	 * @return DisposalCandidateFlagGRPVO
	 * @exception EventException
	 */  
	public DisposalCandidateFlagGRPVO searchDisposalCandidateFlagListBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO, SignOnUserAccount account) throws EventException;	

	/**
	 * [EES_MNR_0151] adding/modification/deletion Disposal Candidate Selection. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */     
	public void manageDisposalCandidateFlagBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0156] adding/modification mkr_nm,mdl_nm of MNR_EQ_STS. <br>
	 * 
	 * @param DisposalGRPVO disposalGRPVO   
	 * @param SignOnUserAccount account      
	 * @exception EventException    
	 */    
	public void manageEqStsMkrNmMdlNmBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0151] retrieving EQ NO list. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @return DisposalCandidateFlagGRPVO
	 * @exception EventException
	 */ 
	public DisposalCandidateFlagGRPVO searchRangeToEQNoBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO) throws EventException;

	/**
	 * [EES_MNR_0019] retrieving EQ NO<br> 
	 * @param String  eqNo  
	 * @return String    
	 * @exception EventException 
	 */ 
	public  CustomMnrEqStsVVO searchEqInfoBasic(String  eqNo) throws EventException;

	/**
	 * [EES_MNR_0170] adding/modification/deletion Reefer Unit Warranty Period. <br>
	 *
	 * @param WarrantyAlertListGRPVO warrantyAlertListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageWarrantyAlertBasic(WarrantyAlertListGRPVO warrantyAlertListGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0058] retrieving Hanger Bar Attatch/Detach Qty by CNTR. <br>
	 * reference EQ_STS Table before deleting WO
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @return EQFlagListGRPVO
	 * @exception EventException
	 */
	public EQFlagListGRPVO searchHangerEQFlagListBasic(EQFlagListGRPVO eQFlagListGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0109] Check EQ Status Remark <br>
	 * @param CustomMnrFlgHisVO customMnrFlgHisVO
	 * @return String
	 * @exception EventException
	 */
	public String searchEQStsRmkBasic(CustomMnrFlgHisVO customMnrFlgHisVO) throws EventException;
	
	/**
	 * [EES_MNR_0109] Check EQ Status Flagging <br>
	 * @param CustomMnrEqStsVO customMnrEqStsVO
	 * @return String
	 * @exception EventException
	 */
	public String checkHngrFlaggingBasic(CustomMnrEqStsVO customMnrEqStsVO) throws EventException;
	
	/**
	 * [EES_MNR_0109] Check EQ Status Count <br>
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @return String
	 * @exception EventException
	 */
	public String searchHangerFlagStatusCountBasic(EQFlagListGRPVO eQFlagListGRPVO) throws EventException;

	/**
	 * [EES_MNR_01222] Check Container OP status <br>
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCntrOpStatusBasic(EQFlagListGRPVO eQFlagListGRPVO) throws EventException;
}