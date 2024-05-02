/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : UncollectedCargoBC.java
*@FileTitle : Container Staying Days (Summary)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.09 김종준
* 1.0 Creation
* =========================================================
* 2010.09.07 남궁진호 [CHM-201005814-01] 소스품질 결함 조치.
*                   List<VO >공백제거
* 2012.09.19 신자영 [CHM-201220003-01] L/S U/C CREATION - COR DRAFT 기능 개발
* 
* 2014.04.07 김창영 [HJSBIZ_CR_45] 장비 과부족현황 Mailing 기능개발
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.CodeVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.UncollectedCargoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedCargoFileVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedVolDtlListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedGlMonXchRtListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.UncollectedCargoAuthorizerVO;

/**
 * ALPS-Longstayingunclaimeqmgt Business Logic Command Interface<br>
 * - ALPS-Longstayingunclaimeqmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kim jong jun
 * @see Ees_cim_0021EventResponse 참조
 * @since J2EE 1.6
 */

public interface UncollectedCargoBC {
	
	/**
	 * EES_CIM_0063 Retrieve<br>
	 * Uncollectecd Cargo <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @return List<UncollectedCargoVO>
	 * @exception EventException
	 */
	public List<UncollectedCargoVO> searchUncollectedCargoCreation(UncollectedCargoVO uncollectedCargoVO) throws EventException;
	/**
	 * EES_CIM_0063 Retrieve<br>
	 * Search ComboCode List <br>
	 * 
	 * @param String intgCdId
	 * @return List<CodeVO>
	 * @exception EventException
	 */	
	public List<CodeVO> searchComboCodeList(String intgCdId) throws EventException;
	
			
	/**
	 * EES_CIM_0063 <br>
	 * Create New Uncollected Cargo Case Number <br>
	 * 
	 * @param String ucCDHd
	 * @return String
	 * @exception EventException
	 */	
	public String checkNewUCCaseNo(String ucCDHd) throws EventException;	
	
	/**
	 * EES_CIM_0063 <br>
	 * BL 중복 체크 <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @return String
	 * @exception EventException
	 */	
	public String checkBLNo3(UncollectedCargoVO uncollectedCargoVO) throws EventException;
	
	/**
	 * EES_CIM_0063 <br>
	 * Check BL No <br>
	 * 
	 * @param String strBLNo
	 * @return String
	 * @exception EventException
	 */	
	public String checkBLNo(String strBLNo) throws EventException;

	/**
	 * EES_CIM_0063 <br>
	 * CIM_UC_CGO_DTL 에 해당 B/L NO 존재 여부 조회 <br>
	 * 
	 * @param String strBLNo
	 * @return String
	 * @exception EventException
	 */	
	public String checkBLNo2(String strBLNo) throws EventException;

	/**
	 * EES_CIM_0063 <br>
	 * Check Branch/Agent <br>
	 * 
	 * @param String strAgnt
	 * @return String
	 * @exception EventException
	 */	
	public String checkAgent(String strAgnt) throws EventException;

	/**
	 * EES_CIM_0063 <br>
	 * Check RHQ <br>
	 * 
	 * @param String strRhq
	 * @return String
	 * @exception EventException
	 */	
	public String checkRHQ(String strRhq) throws EventException;

	/**
	 * EES_CIM_0063 <br>
	 * Check HANDLER <br>
	 * 
	 * @param String strHndlr
	 * @return String
	 * @exception EventException
	 */	
	public String checkHandler(String strHndlr) throws EventException;

	/**
	 * EES_CIM_0063 <br>
	 * Check HANDLER <br>
	 * 
	 * @param String strOfcCd
	 * @return String
	 * @exception EventException
	 */	
	public String checkOfcCd(String strOfcCd) throws EventException;
	
	/**
	 * EES_CIM_0063 <br>
	 * Create UC Creation Data <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageUncollectedCargoCreation(UncollectedCargoVO uncollectedCargoVO, SignOnUserAccount account) throws EventException ;

	/**
	 * EES_CIM_0063 <br>
	 * Create UC Creation Data01 <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageUncollectedCargoCreation01(UncollectedCargoVO uncollectedCargoVO, SignOnUserAccount account) throws EventException ;

	/**
	 * EES_CIM_0063 <br>
	 * Create UC Creation Data02 <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageUncollectedCargoCreation02(UncollectedCargoVO uncollectedCargoVO, SignOnUserAccount account) throws EventException ;

	/**
	 * EES_CIM_0063 <br>
	 * Create UC Creation Data03 <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageUncollectedCargoCreation03(UncollectedCargoVO uncollectedCargoVO, SignOnUserAccount account) throws EventException ;
	/**
	 * EES_CIM_0063 <br>
	 * Create UC Creation Data04 <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageUncollectedCargoCreation04(UncollectedCargoVO uncollectedCargoVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * EES_CIM_0063 <br>
	 * Create UC Creation Data05 <br>
	 * 
	 * @param String managerMemo
	 * @param String isAuthority
	 * @param String ucCsNo
	 * @param String blNo
	 * @param String usr_id
	 * @exception EventException
	 */	
	public void manageUncollectedCargoCreation05(String managerMemo,String isAuthority,String ucCsNo,String blNo, String usr_id) throws EventException ;
	
	
//	/**
//	 * EES_CIM_0062 : Save<br>
//	 * 
//	 * @param MailingServiceSettingListVO[] mailingServiceSettingListVOs
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageMailingServiceSetting(MailingServiceSettingListVO[] mailingServiceSettingListVOs, SignOnUserAccount account) throws EventException;
	/**
	 * UC Inquiry 리스트 조회 [EES_CIM_0064]<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUncollectedInquiryList(Event e) throws EventException;
	/**
	 * UC Activity 리스트 조회 [EES_CIM_0066]<br>
	 * 
	 * @param searchUncollectedCargoFileVO SearchUncollectedCargoFileVO 
	 * @return List<SearchUncollectedCargoFileVO>
	 * @exception EventException
	 */
	public List<SearchUncollectedCargoFileVO> searchUncollectedCargoFileList(SearchUncollectedCargoFileVO searchUncollectedCargoFileVO) throws EventException;
	/**
	 * UC Activity 저장/수정/삭제 처리 [EES_CIM_0066]<br>
	 * 
	 * @param searchUncollectedCargoFileVOs SearchUncollectedCargoFileVO[] 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageUncollectedCargoFile(SearchUncollectedCargoFileVO[] searchUncollectedCargoFileVOs,SignOnUserAccount account) throws EventException;
	/**
	 * UC-VOL_DTL 리스트 조회 [EES_CIM_0070]<br>
	 * 
	 * @param searchUncollectedVolDtlListVO SearchUncollectedVolDtlListVO 
	 * @return List<SearchUncollectedVolDtlListVO>
	 * @exception EventException
	 */
	public List<SearchUncollectedVolDtlListVO> searchUncollectedVolDtlList(SearchUncollectedVolDtlListVO searchUncollectedVolDtlListVO) throws EventException;
	/**
	 * Help Exchange 리스트 조회 - 년월/통화코드별 환율조회 [EES_CIM_0071]<br>
	 * 
	 * @param searchUncollectedGlMonXchRtListVO SearchUncollectedGlMonXchRtListVO 
	 * @return List<SearchUncollectedGlMonXchRtListVO>
	 * @exception EventException
	 */
	public List<SearchUncollectedGlMonXchRtListVO> searchUncollectedGlMonXchRtList(SearchUncollectedGlMonXchRtListVO searchUncollectedGlMonXchRtListVO) throws EventException;
	/**
	 * Help Exchange - 통화코드Combo리스트 [EES_CIM_0071]<br>
	 * 
	 * @param e EES_CIM_0071Event
	 * @return EventResponse EES_CIM_0071EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCurrCdCombo(Event e) throws EventException;	
	
	/**
	 * UC File Attach 업로드된 파일정보(목록) 조회 이벤트 처리 [EES_CIM_0065]<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUploadFileInfo(Event e) throws EventException; 
	/**
	 * UC File Attach FileUpload정보 저장(생성) 이벤트 처리 [EES_CIM_0067]<br>
	 * @param e EesCim0065Event
	 * @return EventResponse EesCim0067Event
	 * @exception EventException
	 */
	public EventResponse createUploadFileInfo(Event e) throws EventException;
	/**
	 * UC File Attach FileUpload정보-공통테이블 저장(생성) 이벤트 처리 [EES_CIM_0067]<br>
	 * @param e EesCim0065Event
	 * @return EventResponse EesCim0067Event
	 * @exception EventException
	 */
	public EventResponse createUploadFileInfoCOM(Event e) throws EventException;
	/**
	 * UC File Attach FileUpload정보 삭제 이벤트 처리 [EES_CIM_0067]<br>
	 * @param e EesCim0065Event
	 * @return EventResponse EesCim0067Event
	 * @exception EventException
	 */
	public EventResponse removeUploadFiles(Event e) throws EventException;
	/**
	 * UC File Attach FileUpload정보-공통 삭제 이벤트 처리 [EES_CIM_0067]<br>
	 * @param e EesCim0065Event
	 * @return EventResponse EesCim0067Event
	 * @exception EventException
	 */
	public EventResponse removeUploadFilesCOM(Event e) throws EventException;		
	
	/**
	 * UC Creation B/L info 조회 [EES_CIM_0063]<br>
	 * 
	 * @param String strBLNo
	 * @return EventResponse
	 * @exception EventException
	 */
	public UncollectedCargoVO searchUncollectedCargoCreationBlInfo(String strBLNo)  throws EventException;
	
	/**
	 * EES_CIM_0063 <br>
	 * Check Office & Handler <br>
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param String strOfcCd
	 * @return String
	 * @exception EventException
	 */	
	public String checkOfcHandlerMatch(UncollectedCargoVO uncollectedCargoVO, String strOfcCd) throws EventException;
	
	/**
	 * EES_CIM_0063 <br>
	 * Check Office & Authority <br>
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param String usrid
	 * @return String
	 * @exception EventException
	 */	
	public String checkOfAuthority(UncollectedCargoVO uncollectedCargoVO, String usrid) throws EventException;
	
	/**
	 * EES_CIM_0072 Retrieve<br>
	 * Uncollectecd Cargo search<br>
	 * 
	 * @param UncollectedCargoAuthorizerVO uncollectedCargoAuthorizerVO
	 * @return List<UncollectedCargoAuthorizerVO>
	 * @exception EventException
	 */
	public List<UncollectedCargoAuthorizerVO> searchUncollectedCargoAuthorizer(UncollectedCargoAuthorizerVO uncollectedCargoAuthorizerVO) throws EventException;
	
	/**
	 * EES_CIM_0072 Check<br>
	 * Uncollectecd Cargo <br>
	 * 
	 * @param UncollectedCargoAuthorizerVO uncollectedCargoAuthorizerVO
	 * @return List<UncollectedCargoAuthorizerVO>
	 * @exception EventException
	 */
	public List<UncollectedCargoAuthorizerVO> checkAuthorizerInputId(UncollectedCargoAuthorizerVO uncollectedCargoAuthorizerVO) throws EventException;
	
	/**
	 * EES_CIM_0072 SAVE<br>
	 * Uncollectecd Cargo <br>
	 * 
	 * @param UncollectedCargoAuthorizerVO[] uncollectedCargoAuthorizerVOs
	 * @param String usrid
	 * @exception EventException
	 */
	public void manageUncollectedCargoAuthorizer(UncollectedCargoAuthorizerVO[] uncollectedCargoAuthorizerVOs, String usrid) throws EventException;
		
}