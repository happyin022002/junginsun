/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtBC.java
*@FileTitle : Damage Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic;

import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSdmsSettlementVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCmpnVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCreateVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsCompensationReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDamageReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDetailsGRPVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsOptionVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsRepairReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsSettlementReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsStepHistoryVO;
import com.clt.bizcommon.currency.vo.MdmCurrencyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;
import com.clt.syscommon.common.table.ComUserVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.OpfStvDmgAtchFileVO;
import com.clt.syscommon.common.table.OpfStvDmgDtlVO;
import com.clt.syscommon.common.table.OpfStvDmgRprVO;
import com.clt.syscommon.common.table.OpfStvDmgStepHisVO;
import com.clt.syscommon.common.table.OpfStvDmgStlVO;
import com.clt.syscommon.common.table.OpfStvDmgVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * OPUS-Stevedoredamagemgt Business Logic Command Interface<br>
 *
 * @author 
 * @see Reference Vop_opf_0052EventResponse 
 * @since J2EE 1.4
 */

public interface StevedoreDamageMgtBC {
	/**
	 * Retrieve Stevedore Damage Info <br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<OpfStvDmgCreateVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgCreateVO> searchDamage(OpfStvDmgCreateVO opfStvDmgCreateVO) throws EventException;
	/**
	 * Retrieve VVD Info of Stevedore Damage  <br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<OpfStvDmgVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgVO> checkVVDInfo(OpfStvDmgCreateVO opfStvDmgCreateVO) throws EventException;
	/**
	 *  Handling retrieve event StevedoreDamageMgt page<br>
	 *  Retrieve File Upload Data 
	 * 
	 * @param OpfStvDmgAtchFileVO opfStvDmgAtchFileVO
	 * @return List<OpfStvDmgAtchFileVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgAtchFileVO> searchDamageAttachFile(OpfStvDmgAtchFileVO opfStvDmgAtchFileVO) throws EventException;
	/**
	 * Save Stevedore Damage Info <br>
	 * 
	 * @param OpfStvDmgCreateVO[] opfStvDmgCreateVO
	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageDamage(OpfStvDmgCreateVO[] opfStvDmgCreateVO,OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO, List<String> keys,SignOnUserAccount account) throws EventException;
	/**
	 * Delete Stevedore Damage Info <br>
	 * 
	 * @param String delStvDmgNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeDamage(String delStvDmgNo, SignOnUserAccount account) throws EventException;
	/**
	 * Handling retrieve event VVD Port Code and ETA/ETD Data of StevedoreDamageMgt page<br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdVO> searchVskVslPortSkdVO(OpfStvDmgCreateVO opfStvDmgCreateVO) throws EventException;
	/**
	 * Handling Lane Code retrieve event of Stevedore Damage page<br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<VskVslSkdVO>
	 * @exception EventException
	 */
	public List<VskVslSkdVO> searchLaneCode(OpfStvDmgCreateVO opfStvDmgCreateVO) throws EventException;
	/**
	 * Handling Common Code retrieve event of StevedoreDamageMgt page<br>
	 * 
	 * @param String codeID
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchComCodeList(String codeID) throws EventException;
	/**
	 * Handling Approval Permission retrieve event of StevedoreDamageMgt page<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int searchApprovalPermissionCheck(SignOnUserAccount account) throws EventException;
	/**
	 * Save Stevedore Damage Approval Info <br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageApproval(OpfStvDmgCreateVO opfStvDmgCreateVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Handling Office Code retrieve event of Stevedore Damage page<br>
	 * 
	 * @param String ofcCd
	 * @return List<MdmOrganizationVO>
	 * @exception EventException
	 */
	public List<MdmOrganizationVO> searchOfficeCode(String ofcCd) throws EventException;
	
	/**
	 * Handling E-mail [PIC of Claim Handling Office] retrieve event of Stevedore Damage page<br>
	 * 
	 * @param String ofcCd
	 * @return List<ComUserVO>
	 * @exception EventException
	 */
	public List<ComUserVO> searchMailContentPic(String ofcCd) throws EventException;	
	
	/**
	 *  Handling retrieve event of Stevedore Damage Inquiry page<br>
	 * 
	 * @param SdmsOptionVO sdmsOptionVO
	 * @return List<SdmsOptionVO>
	 * @exception EventException
	 */
	public List<SdmsOptionVO> searchSDList(SdmsOptionVO sdmsOptionVO) throws EventException;
	
	/**
	 * Handling retrieve event of Stevedore Damage Details page<br>
	 * 
	 * @param String stvDmgNo
	 * @return SdmsDetailsGRPVO
	 * @exception EventException
	 */
	public SdmsDetailsGRPVO searchSdmsDetails(String stvDmgNo) throws EventException;
	
	/**
	 * Handling User Name retrieve event of Stevedore Damage Update <br>
	 * 
	 * @param String usrId
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchUserName(String usrId, String ofcCd) throws EventException;
	
	/**
	 * Handling USD_AMT retrieve event of Stevedore Damage Update page<br>
	 * 
	 * @param String loclAmt
	 * @param String currCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalPayUsd(String loclAmt, String currCd) throws EventException;
	
	/**
	 * Handling Default Currency retrieve event of Stevedore Damage Update page<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchDefaultCurrency(String ofcCd) throws EventException;
	
	/**
	 * Handling Currency Code retrieve event of Stevedore Damage page<br>
	 * 
	 * @return List<MdmCurrencyVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyVO> searchCurrencyCode() throws EventException;
	
	/**
	 * Handling Damage Info retrieve event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgVO opfStvDmgVO
	 * @return List<OpfStvDmgVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgVO> searchStvDamage(OpfStvDmgVO opfStvDmgVO) throws EventException;
	/**
	 * Handling Damage Detail Info retrieve event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgDtlVO opfStvDmgDtlVO
	 * @return List<OpfStvDmgDtlVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgDtlVO> searchDamageDetail(OpfStvDmgDtlVO opfStvDmgDtlVO) throws EventException;
	/**
	 * Handling Damage Repair Info retrieve event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgRprVO opfStvDmgRprVO
	 * @return List<OpfStvDmgRprVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgRprVO> searchDamageRepair(OpfStvDmgRprVO opfStvDmgRprVO) throws EventException;
	/**
	 * Handling Damage Compensation Info retrieve event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgCmpnVO opfStvDmgCmpnVO
	 * @return List<OpfStvDmgCmpnVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgCmpnVO> searchDamageCompensation(OpfStvDmgCmpnVO opfStvDmgCmpnVO) throws EventException;
	/**
	 * Handling Damage Settlement Info retrieve event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgStlVO opfStvDmgStlVO
	 * @return List<OpfStvDmgStlVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgStlVO> searchDamageSettlement(OpfStvDmgStlVO opfStvDmgStlVO) throws EventException;
	
	/**
	 * Method used in case of Payment Data Insert in FMS<br>
	 * 
	 * @param CustomSdmsSettlementVO[] customSdmsSettlementVOs
	 * @exception EventException
	 */
	public void addSettlementFMS(CustomSdmsSettlementVO[] customSdmsSettlementVOs) throws EventException;
	/**
	 * Method used in case of Payment Data Delete in FMS<br>
	 * 
	 * @param CustomInvDtlVO[] customInvDtlVOs
	 * @exception EventException
	 */
	public void removeSettlementFMS(CustomInvDtlVO[] customInvDtlVOs) throws EventException;
	
	/**
	 * Method used in case Save is available in this Tab 현재탭이 Save가능한지 알아보는 메서드<br>
	 * @since 2010.12.15
	 * 
	 * @param String tabName
	 * @param String stvDmgNo
	 * @return String
	 * @exception EventException
	 */
	public String checkTabSavable(String tabName, String stvDmgNo) throws EventException;
	
	/**
	 * Handling Damage Info save event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgVO[] opfStvDmgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageStvDamage(OpfStvDmgVO[] opfStvDmgVO, SignOnUserAccount account) throws EventException;
	/**
	 * Handling Damage Detail Info save event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgDtlVO[] opfStvDmgDtlVO
	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDamageDetail(OpfStvDmgDtlVO[] opfStvDmgDtlVO, OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO, List<String> keys, SignOnUserAccount account) throws EventException;
	/**
	 * Handling Damage Repair Info save event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgRprVO[] opfStvDmgRprVO
 	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDamageRepair(OpfStvDmgRprVO[] opfStvDmgRprVO, OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO, List<String> keys, SignOnUserAccount account) throws EventException;
	/**
	 * Handling Damage Compensation Info save event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgCmpnVO[] opfStvDmgCmpnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDamageCompensation(OpfStvDmgCmpnVO[] opfStvDmgCmpnVO, SignOnUserAccount account) throws EventException;
	/**
	 * Handling Damage Settlement Info save event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgStlVO[] opfStvDmgStlVO
 	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDamageSettlement(OpfStvDmgStlVO[] opfStvDmgStlVO, OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO, List<String> keys, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve Info of Stevedore Damage History <br>
	 * 
	 * @param SdmsStepHistoryVO sdmsStepHistoryVO
	 * @return List<SdmsStepHistoryVO>
	 * @exception EventException
	 */
	public List<SdmsStepHistoryVO> searchSDHistoryList(SdmsStepHistoryVO sdmsStepHistoryVO) throws EventException;
	
	/**
	 * Save Info of Stevedore Damage History <br>
	 * 
	 * @param OpfStvDmgStepHisVO[] opfStvDmgStepHisVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDamageHistory(OpfStvDmgStepHisVO[] opfStvDmgStepHisVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 *  Handling mail transmitting event of StevedoreDamageMgt page<br>
	 *  Transmitting VOP_OPF_1153 Report page to mail
	 * 
	 * @param event   Event
	 * @return String
	 * @exception EventException
	 */
	//public String sendMail(Event event) throws EventException;
	
	/**
	 * Retrieve Stevedore Damage Performance Report Info<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsReportVO>
	 * @exception EventException
	 */
	public List<SdmsReportVO> searchSdmsReportList(SdmsReportVO sdmsReportVO) throws EventException;
	/**
	 * Retrieve Stevedore Damage Report Info<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsDamageReportVO>
	 * @exception EventException
	 */
	public List<SdmsDamageReportVO> searchDamageReportList(SdmsReportVO sdmsReportVO) throws EventException;
	/**
	 * Retrieve Stevedore Damage Repair Report Info<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsRepairReportVO>
	 * @exception EventException
	 */
	public List<SdmsRepairReportVO> searchRepairReportList(SdmsReportVO sdmsReportVO) throws EventException;
	/**
	 * Retrieve Stevedore Damage Compensation Report Info<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsCompensationReportVO>
	 * @exception EventException
	 */
	public List<SdmsCompensationReportVO> searchCompensationReportList(SdmsReportVO sdmsReportVO) throws EventException;
	/**
	 * Retrieve Stevedore Damage Settlement Report Info<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsSettlementReportVO>
	 * @exception EventException
	 */
	public List<SdmsSettlementReportVO> searchSettlementReportList(SdmsReportVO sdmsReportVO) throws EventException;

	/**
	 * Checking VSL,VVD,Lane,Port Code Validation .<br>
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return String
	 * @exception EventException
	 */	
	public String checkMainCode(VskVslPortSkdVO vskVslPortSkdVO) throws EventException;	

	/**
	 * VOP_OPF_0052 :Adding checking logic whether delete is available in case of Delete
	 * 
	 * @param String stvDmgNo
	 * @return String
	 * @exception EventException
	 */		
	public String checkDeleteFlag(String stvDmgNo) throws EventException;	

	/**
	 * Retrieve ETB, ETD to VVD, Port
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<VskVslPortSkdVO>
	 * @throws EventException
	 */
	public List<VskVslPortSkdVO> searchVpsEtbEtdDtList(VskVslPortSkdVO vskVslPortSkdVO) throws EventException;
	
	/**
	 * VOP_OPF_1053 : Delete <br>
	 * Delete Stevedore Damage Detail Info<br>
	 * 
	 * @param String delStvDmgNo
	 * @param String tabNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeDamageDetail(String delStvDmgNo, String tabNo, SignOnUserAccount account) throws EventException;
}