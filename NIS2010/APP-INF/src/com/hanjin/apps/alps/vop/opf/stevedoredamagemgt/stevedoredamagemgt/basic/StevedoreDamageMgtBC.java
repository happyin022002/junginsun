/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtBC.java
*@FileTitle : Damage Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.05.18 이선영
* 1.0 Creation
* 2010.10.12 이석준 [CSR전 사전 작업] VVD,VSL,Lane,Port 유효성 검사 로직 추가
*                                 Delete시 유효성 check logic 추가
* 2010.10.15 이상민 [CHM-201007482-01] 1053 event에 COMMAND01 - checkTabSavable() Tab이동시 save 가능 여부 확인 로직 추가
* 2011.04.01 공창식 [CHM-201109535-01] SDMS Damage Creation 변경 요청사항
* 2011.10.21 김민아 [CHM-201113609-01] SDMS 신속 처리를 위한 Auto mailing 기능 추가 - 담당자 선택 기능 추가 및 Auto mailing 기능 추가
* 2011.11.21 김민아 [CHM-201114254-01] [VOP-OPF/SDMS] Repaur VVD 및 Port 설정 기능 변경
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSdmsSettlementVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCmpnVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCreateVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.RsltOpfStvDmgEmlSndHisVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsCompensationReportVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDamageReportVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDetailsGRPVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsOptionVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsPortStayingDatesVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsRepairReportVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsReportVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsSettlementReportVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsStepHistoryVO;
import com.hanjin.bizcommon.currency.vo.MdmCurrencyVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComIntgCdDtlVO;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.syscommon.common.table.OpfStvDmgAtchFileVO;
import com.hanjin.syscommon.common.table.OpfStvDmgDtlVO;
import com.hanjin.syscommon.common.table.OpfStvDmgEmlSndHisVO;
import com.hanjin.syscommon.common.table.OpfStvDmgRprVO;
import com.hanjin.syscommon.common.table.OpfStvDmgStepHisVO;
import com.hanjin.syscommon.common.table.OpfStvDmgStlVO;
import com.hanjin.syscommon.common.table.OpfStvDmgVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

/**
 * NIS2010-Stevedoredamagemgt Business Logic Command Interface<br>
 * - NIS2010-Stevedoredamagemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Sunyoung
 * @see Vop_opf_0052EventResponse 참조
 * @since J2EE 1.4
 */

public interface StevedoreDamageMgtBC {
	/**
	 * Stevedore Damage 정보를 조회 합니다. <br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<OpfStvDmgCreateVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgCreateVO> searchDamage(OpfStvDmgCreateVO opfStvDmgCreateVO) throws EventException;
	/**
	 * Stevedore Damage Claim Handling User 정보를 조회 합니다. <br>
	 * 
	 * @param OpfStvDmgEmlSndHisVO opfStvDmgEmlSndHisVO
	 * @return List<RsltOpfStvDmgEmlSndHisVO>
	 * @exception EventException
	 */
	public List<RsltOpfStvDmgEmlSndHisVO> searchDamageClaimHandlingUser(OpfStvDmgEmlSndHisVO opfStvDmgEmlSndHisVO) throws EventException;
	/**
	 * Stevedore Damage에 VVD 정보를 조회 합니다. <br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<OpfStvDmgVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgVO> checkVVDInfo(OpfStvDmgCreateVO opfStvDmgCreateVO) throws EventException;
	/**
	 *  StevedoreDamageMgt화면에 대한 조회 이벤트 처리<br>
	 *  File Upload Data 조회한다.
	 * 
	 * @param OpfStvDmgAtchFileVO opfStvDmgAtchFileVO
	 * @return List<OpfStvDmgAtchFileVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgAtchFileVO> searchDamageAttachFile(OpfStvDmgAtchFileVO opfStvDmgAtchFileVO) throws EventException;
	/**
	 * Stevedore Damage 정보를 저장 합니다. <br>
	 * 
	 * @param OpfStvDmgCreateVO[] opfStvDmgCreateVO
	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO
	 * @param String[] strKeys
	 * @param OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageDamage(OpfStvDmgCreateVO[] opfStvDmgCreateVO, OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO, String[] strKeys, OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVO, SignOnUserAccount account) throws EventException;
	/**
	 * Stevedore Damage 정보를 삭제 합니다. <br>
	 * 
	 * @param String delStvDmgNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeDamage(String delStvDmgNo, SignOnUserAccount account) throws EventException;
	/**
	 * StevedoreDamageMgt화면에 대한 VVD Port Code 및 ETA/ETD Date 조회 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdVO> searchVskVslPortSkdVO(OpfStvDmgCreateVO opfStvDmgCreateVO) throws EventException;
	/**
	 * Stevedore Damage 화면에 대한 Lane Code 조회 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<VskVslSkdVO>
	 * @exception EventException
	 */
	public List<VskVslSkdVO> searchLaneCode(OpfStvDmgCreateVO opfStvDmgCreateVO) throws EventException;
	/**
	 * StevedoreDamageMgt화면에 대한 Common Code 조회 이벤트 처리<br>
	 * 
	 * @param String codeID
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchComCodeList(String codeID) throws EventException;
	/**
	 * StevedoreDamageMgt화면에 대한 Approval Permission 조회 이벤트 처리<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int searchApprovalPermissionCheck(SignOnUserAccount account) throws EventException;
	/**
	 * Stevedore Damage Approval 정보를 저장 합니다. <br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageApproval(OpfStvDmgCreateVO opfStvDmgCreateVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Stevedore Damage 화면에 대한 Office Code 조회 이벤트 처리<br>
	 * 
	 * @param String ofcCd
	 * @return List<MdmOrganizationVO>
	 * @exception EventException
	 */
	public List<MdmOrganizationVO> searchOfficeCode(String ofcCd) throws EventException;
	
	/**
	 * Stevedore Damage 화면에 대한 E-mail [PIC of Claim Handling Office] 조회 이벤트 처리<br>
	 * 
	 * @param String ofcCd
	 * @return List<ComUserVO>
	 * @exception EventException
	 */
	public List<ComUserVO> searchMailContentPic(String ofcCd) throws EventException;	
	
	/**
	 *  Stevedore Damage Inquiry 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SdmsOptionVO sdmsOptionVO
	 * @return List<SdmsOptionVO>
	 * @exception EventException
	 */
	public List<SdmsOptionVO> searchSDList(SdmsOptionVO sdmsOptionVO) throws EventException;
	
	/**
	 * Stevedore Damage Details 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String stvDmgNo
	 * @return SdmsDetailsGRPVO
	 * @exception EventException
	 */
	public SdmsDetailsGRPVO searchSdmsDetails(String stvDmgNo) throws EventException;
	
	/**
	 * Stevedore Damage Update 화면에 대한 User Name 조회 이벤트 처리<br>
	 * 
	 * @param String usrId
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchUserName(String usrId, String ofcCd) throws EventException;
	
	/**
	 * Stevedore Damage Update 화면에 대한 USD_AMT 조회 이벤트 처리<br>
	 * 
	 * @param String loclAmt
	 * @param String currCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalPayUsd(String loclAmt, String currCd) throws EventException;
	
	/**
	 * Stevedore Damage Update 화면에 대한 Default Currency 조회 이벤트 처리<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchDefaultCurrency(String ofcCd) throws EventException;
	
	/**
	 * Stevedore Damage 화면에 대한 Currency Code 조회 이벤트 처리<br>
	 * 
	 * @return List<MdmCurrencyVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyVO> searchCurrencyCode() throws EventException;
	
	/**
	 * Stevedore Damage Update 화면에 대한 Damage 정보 조회 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgVO opfStvDmgVO
	 * @return List<OpfStvDmgVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgVO> searchStvDamage(OpfStvDmgVO opfStvDmgVO) throws EventException;
	/**
	 * Stevedore Damage Update 화면에 대한 Damage Detail 정보 조회 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgDtlVO opfStvDmgDtlVO
	 * @return List<OpfStvDmgDtlVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgDtlVO> searchDamageDetail(OpfStvDmgDtlVO opfStvDmgDtlVO) throws EventException;
	/**
	 * Stevedore Damage Update 화면에 대한 Damage Repair 정보 조회 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgRprVO opfStvDmgRprVO
	 * @return List<OpfStvDmgRprVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgRprVO> searchDamageRepair(OpfStvDmgRprVO opfStvDmgRprVO) throws EventException;
	/**
	 * Stevedore Damage Update 화면에 대한 Damage Compensation 정보 조회 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgCmpnVO opfStvDmgCmpnVO
	 * @return List<OpfStvDmgCmpnVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgCmpnVO> searchDamageCompensation(OpfStvDmgCmpnVO opfStvDmgCmpnVO) throws EventException;
	/**
	 * Stevedore Damage Update 화면에 대한 Damage Settlement 정보 조회 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgStlVO opfStvDmgStlVO
	 * @return List<OpfStvDmgStlVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgStlVO> searchDamageSettlement(OpfStvDmgStlVO opfStvDmgStlVO) throws EventException;
	
	/**
	 * FMS에서 Payment Data Insert에 이용하는 메서드<br>
	 * 
	 * @param CustomSdmsSettlementVO[] customSdmsSettlementVOs
	 * @exception EventException
	 */
	public void addSettlementFMS(CustomSdmsSettlementVO[] customSdmsSettlementVOs) throws EventException;
	/**
	 * FMS에서 Payment Data Delete에 이용하는 메서드<br>
	 * 
	 * @param CustomInvDtlVO[] customInvDtlVOs
	 * @exception EventException
	 */
	public void removeSettlementFMS(CustomInvDtlVO[] customInvDtlVOs) throws EventException;
	
	/**
	 * 현재탭이 Save가능한지 알아보는 메서드<br>
	 * @since 2010.12.15
	 * 
	 * @param String tabName
	 * @param String stvDmgNo
	 * @return String
	 * @exception EventException
	 */
	public String checkTabSavable(String tabName, String stvDmgNo) throws EventException;
	
	/**
	 * Stevedore Damage Update 화면에 대한 Damage 정보 저장 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgVO[] opfStvDmgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageStvDamage(OpfStvDmgVO[] opfStvDmgVO, SignOnUserAccount account) throws EventException;
	/**
	 * Stevedore Damage Update 화면에 대한 Damage Detail 정보 저장 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgDtlVO[] opfStvDmgDtlVO
	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO
	 * @param List<String> keys
	 * @param OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageDamageDetail(OpfStvDmgDtlVO[] opfStvDmgDtlVO, OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO, List<String> keys, OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVO, SignOnUserAccount account) throws EventException;
	/**
	 * Stevedore Damage Update 화면에 대한 Damage Repair 정보 저장 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgRprVO[] opfStvDmgRprVO
 	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO
	 * @param List<String> keys
	 * @param OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageDamageRepair(OpfStvDmgRprVO[] opfStvDmgRprVO, OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO, List<String> keys, OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVO, SignOnUserAccount account) throws EventException;
	/**
	 * Stevedore Damage Update 화면에 대한 Damage Compensation 정보 저장 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgCmpnVO[] opfStvDmgCmpnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDamageCompensation(OpfStvDmgCmpnVO[] opfStvDmgCmpnVO, SignOnUserAccount account) throws EventException;
	/**
	 * Stevedore Damage Update 화면에 대한 Damage Settlement 정보 저장 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgStlVO[] opfStvDmgStlVO
 	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDamageSettlement(OpfStvDmgStlVO[] opfStvDmgStlVO, OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO, List<String> keys, SignOnUserAccount account) throws EventException;
	
	/**
	 * Stevedore Damage History 화면에 대한 정보를 조회 합니다.<br>
	 * 
	 * @param SdmsStepHistoryVO sdmsStepHistoryVO
	 * @return List<SdmsStepHistoryVO>
	 * @exception EventException
	 */
	public List<SdmsStepHistoryVO> searchSDHistoryList(SdmsStepHistoryVO sdmsStepHistoryVO) throws EventException;
	
	/**
	 * Stevedore Damage History 화면에 대한 정보를 저장 합니다.<br>
	 * 
	 * @param OpfStvDmgStepHisVO[] opfStvDmgStepHisVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDamageHistory(OpfStvDmgStepHisVO[] opfStvDmgStepHisVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 메일 전송 이벤트 처리<br>
	 *  StevedoreDamageMgt화면에 대한 메일 전송 이벤트 처리<br>
	 *  VOP_OPF_1153 리포트 화면을 메일로 전송한다.
	 * 
	 * @param event   Event
	 * @return String
	 * @exception EventException
	 */
	//public String sendMail(Event event) throws EventException;
	
	/**
	 * Stevedore Damage Performance Report 정보를 조회 합니다.<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsReportVO>
	 * @exception EventException
	 */
	public List<SdmsReportVO> searchSdmsReportList(SdmsReportVO sdmsReportVO) throws EventException;
	/**
	 * Stevedore Damage Report 정보를 조회 합니다.<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsDamageReportVO>
	 * @exception EventException
	 */
	public List<SdmsDamageReportVO> searchDamageReportList(SdmsReportVO sdmsReportVO) throws EventException;
	/**
	 * Stevedore Damage Repair Report 정보를 조회 합니다.<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsRepairReportVO>
	 * @exception EventException
	 */
	public List<SdmsRepairReportVO> searchRepairReportList(SdmsReportVO sdmsReportVO) throws EventException;
	/**
	 * Stevedore Damage Compensation Report 정보를 조회 합니다.<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsCompensationReportVO>
	 * @exception EventException
	 */
	public List<SdmsCompensationReportVO> searchCompensationReportList(SdmsReportVO sdmsReportVO) throws EventException;
	/**
	 * Stevedore Damage Settlement Report 정보를 조회 합니다.<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsSettlementReportVO>
	 * @exception EventException
	 */
	public List<SdmsSettlementReportVO> searchSettlementReportList(SdmsReportVO sdmsReportVO) throws EventException;

	/**
	 * VSL,VVD,Lane,Port Code Validation 을 검사합니다..<br>
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return String
	 * @exception EventException
	 */	
	public String checkMainCode(VskVslPortSkdVO vskVslPortSkdVO) throws EventException;	

	/**
	 * VOP_OPF_0052 : Delete시에 delete 가능 여부 확인 로직 추가
	 * 
	 * @param String stvDmgNo
	 * @return String
	 * @exception EventException
	 */		
	public String checkDeleteFlag(String stvDmgNo) throws EventException;	

	/**
	 * VVD, Port로 ETB, ETD 일자를 가져온다.
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<VskVslPortSkdVO>
	 * @throws EventException
	 */
	public List<VskVslPortSkdVO> searchVpsEtbEtdDtList(VskVslPortSkdVO vskVslPortSkdVO) throws EventException;
	
	/**
	 * VOP_OPF_1053 : Delete <br>
	 * Stevedore Damage Detail 정보를 삭제 합니다. <br>
	 * 
	 * @param String delStvDmgNo
	 * @param String tabNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeDamageDetail(String delStvDmgNo, String tabNo, SignOnUserAccount account) throws EventException;
	
	/**
	 * Stevedore Damage Compensation Report 정보를 조회 합니다.<br>
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<SdmsPortStayingDatesVO>
	 * @throws EventException
	 */
	public List<SdmsPortStayingDatesVO> searchVesselPortStayingDates(VskVslPortSkdVO vskVslPortSkdVO) throws EventException;
}