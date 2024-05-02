/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtBC.java
*@FileTitle : Booking Creation 1_MT P/UP CY inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.04 김기종
* 1.0 Creation
* -------------------------------------------------------
* history
* 2010.12.21 김영철 1.4 [] R4J 주석수정 ( manageZipCode )
* 2012.08.08 조정민 [CHM-201218814] Booking Receipt Notice - VVD name change 기능
* 2012.09.10 조정민 [] Hard Coding setup화면 추가
* 2014.04.01 신규정 [CHM-201429292 ]  Manual BDR 권한 설정 메뉴 신규 개발
* 2014.06.10 문동선 [CHM-201430335] 미주 bkg handling office 지정을 위한 set up 메뉴 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BdrAccessAuthorityInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCstmsChnAgnCdVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCustTmpltVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgDpcsOfcTmVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEqlzPortVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHandlingOfficeSetupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHrdCdgDescVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMapgVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMdtItmVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVgmClzSetListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVgmClzSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ChnMnlBkgNoGenCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.MandatoryItemSetupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.RestrictCmdtDupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.RestrictCmdtFileVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.RestrictCmdtListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRPolVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeTableVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchCmdtCdRepCmdtCdVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchInBoundCustListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchWareHouseVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.VskVslPortSkdConditionVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdSchVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgTsCoffTmVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgChnBkgNoGenVO;
import com.hanjin.syscommon.common.table.BkgCoffTmVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnAgnStupVO;
import com.hanjin.syscommon.common.table.BkgCustCntcPsonVO;
import com.hanjin.syscommon.common.table.BkgDpcsUsrGrpVO;
import com.hanjin.syscommon.common.table.BkgHamoTrfVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgImpImgStoVO;
import com.hanjin.syscommon.common.table.BkgMTPickupCYVO;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmPckTpVO;

/**
 * NIS2010-Bookingmasterdata Business Logic Command Interface<br>
 * - NIS2010-Bookingmasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Ki Jong
 * @see Esm_bkg_0082EventResponse 참조
 * @since J2EE 1.4
 */

public interface BookingMasterMgtBC {  
	

	
	/**
	 * Booking Creation 1_MT P/UP CY inquiry (ESM_BKG-0082) <br>
	 * 
	 * @param String YardCode
	 * @param String Today
	 * @return List<BkgMTPickupCYVO>
	 * @exception EventException
	 */
	public List<BkgMTPickupCYVO> searchMTPickUpCY(String YardCode,String Today) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * HTS (Harmonized Tariff Schedule) Code (ESM_BKG_0607)<br>
	 * 
	 * @param BkgHamoTrfVO   vo
	 * @param int IPage
	 * @return List<BkgHamoTrfVO>
	 * @exception EventException
	 */
	public List<BkgHamoTrfVO> searchHTSCode(BkgHamoTrfVO vo, int iPage) throws EventException;
	
	/**
	 * 수정/삭제/저장 이벤트 처리<br>
	 * HTS (Harmonized Tariff Schedule) Code (ESM_BKG_0607_C)<br>
	 * 
	 * @param BkgHamoTrfVO[] bkgHamoTrfVOs
	 * @param String usrId  
	 * @exception EventException
	 * @throws DAOException 
	 */
	public void manageHtsCode(BkgHamoTrfVO[] bkgHamoTrfVOs, String usrId ) throws EventException, DAOException;   
	
	
	/**
	 * Customer Inquiry Save 이벤트 처리(ESM_BKG_0652)<br>
	 * Customer Person 정보를 관리한다.<br>
	 * 
	 * @param BkgCustCntcPsonVO[] bkgCustCntcPsonVOs 
	 * @param String userId
	 * @exception EventException
	 */
	public void manageCustContact(	BkgCustCntcPsonVO[] bkgCustCntcPsonVOs, 
														String userId	) throws EventException;		
	
	/**
	 * Vessel code 및 SKD 조회 <br>
	 *  
	 * @param VskVslPortSkdConditionVO   vo
	 * @return List<VskVslPortSkdConditionVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdConditionVO> searchEtbEtdEta(	VskVslPortSkdConditionVO vo	) throws EventException;
	
	
	/**
	 * Package Code 및 Description을 검색 및 조회(ESM_BKG_0755,ESM_BKG_0696)  <br>
	 * 
	 * @param MdmPckTpVO   vo
	 * @return List<MdmPckTpVO>
	 * @exception EventException
	 */
	public List<MdmPckTpVO> searchPackageCode(	MdmPckTpVO vo	) throws EventException;
	
	/**
	 * Commodity Code를 입력하기 위해 Code를 검색(ESM_BKG_0653)  <br>
	 *  
	 * @param SearchCmdtCdRepCmdtCdVO   vo
	 * @return List<SearchCmdtCdRepCmdtCdVO>
	 * @exception EventException
	 */
	public List<SearchCmdtCdRepCmdtCdVO> searchCmdtCdRepCmdtCd(	SearchCmdtCdRepCmdtCdVO vo	) throws EventException;
	
	/**
	 * Warehouse (Bonded Area) Creation 조회(ESM_BKG_0554)  <br>
	 *  
	 * @param String cuntryCd
	 * @param String wareHouse
	 * 
	 * @return List<SearchWareHouseVO>
	 * @exception EventException
	 */
	public List<SearchWareHouseVO> searchWareHouse(String cuntryCd , String wareHouse) throws EventException ;

	/**
	 * Warehouse (Bonded Area) Creation 저장 이벤트 처리(ESM_BKG_0554)<br>
	 * Warehouse (Bonded Area) 정보를 관리한다.<br>
	 * 
	 * @param SearchWareHouseVO searchWareHouseVO
	 * @exception EventException
	 */
	public void manageWareHouse(	SearchWareHouseVO searchWareHouseVO) throws EventException;
	
	
	/**
	 * 조회-Manual로 BDR을 처리하는 화면(ESM_BKG_0596)  <br>
	 * 
	 * @param SearchBDRTimeVO   vo
	 * @return List<SearchBDRTimeVO>
	 * @exception EventException
	 */
	public List<SearchBDRTimeVO> searchBDRTime(SearchBDRTimeVO vo) throws EventException ;
	
	
	/**
	 * Vessel Schedule B/L Data Release 저장이벤트를 처리한다. (ESM_BKG_0596)<br>
	 * BKG_BL_DOC BDR을 처리.<br>
	 * 
	 * @param SearchBDRTimeVO vo
	 * @exception EventException
	 */	
	public void modifyBDRLog(SearchBDRTimeVO vo) throws EventException ;
	
	/**
	 * vvd check (ESM_BKG_0596)<br>
	 * 
	 * @param SearchBDRTimeVO vo
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkBDRVVDPOL(SearchBDRTimeVO vo) throws EventException ;
	
	/**
	 * @category ESM_BKG_1004
	 * @category searchDPSCUserGroup
	 * DPCS - S/R 업무처리 담당자 Group 정보를 Searchg한다<br>
	 * 
	 * @param String usrId
	 * @param String dpcsWrkGrpCd
	 * @param BkgDpcsUsrGrpVO   vo
	 * @return List<BkgDpcsUsrGrpVO>
	 * @exception EventException
	 */
	public List<BkgDpcsUsrGrpVO> searchDPSCUserGroup(String usrId, String dpcsWrkGrpCd,BkgDpcsUsrGrpVO vo) throws EventException;
	
	/**
	 * @category ESM_BKG_0592
	 * @category searchDPSCUserGroup
	 * DPCS - S/R 업무처리 담당자 Group 정보를 Searchg한다<br>
	 * 
	 * @param String usrId
	 * @param String dpcsWrkGrpCd
	 * @param BkgDpcsUsrGrpVO   vo
	 * @return List<BkgDpcsUsrGrpVO>
	 * @exception EventException
	 */
	public List<BkgDpcsUsrGrpVO> searchDPCSUserGroup(String usrId, String dpcsWrkGrpCd,BkgDpcsUsrGrpVO vo) throws EventException;
	
	/**
	 * User Group Creation를 관리한다(ESM_BKG_0592).<br>
	 * DPCS - S/R 업무처리 담당자 Group 정보를 관리한다. <br>
	 * DPSC의 해당 User그룹을 담당자별 작업내역을 할단하주고 그것을 그룹핑해 놓은  Table임<br>
	 * 
	 * @param BkgDpcsUsrGrpVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageDPSCUserGroup(BkgDpcsUsrGrpVO[] vos,SignOnUserAccount account) throws EventException;
	
	/**
	 * booking close for bayplan 정보를 저장한다.<br>
	 * 
	 * @param BkgCoffTmVO[] bkgCoffTmVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void closeBKGForBayPlan(BkgCoffTmVO[] bkgCoffTmVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * booking reopen for bayplan 정보를 저장한다.<br>
	 * 
	 * @param BkgCoffTmVO[] bkgCoffTmVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void reopenBkgForBayPlan(BkgCoffTmVO[] bkgCoffTmVO, SignOnUserAccount account) throws EventException;

	/**
	 * BDR TIME 등록화면 Lane조회(ESM_BKG_0073) <br>
	 * 
	 * @param SearchBDRPolVO vo
	 * @return List<SearchBDRPolVO>
	 * @exception EventException
	 */
	public List<SearchBDRPolVO> searchBDRPol(SearchBDRPolVO vo) throws EventException ;
	
	/**
	 * BDR Time Table 조회 이벤트 처리(ESM_BKG_0073) <br>
	 * 
	 * @param SearchBDRTimeTableVO   vo
	 * @return List<SearchBDRTimeTableVO>
	 * @exception EventException
	 */
	public List<SearchBDRTimeTableVO> searchBDRTimeTable(SearchBDRTimeTableVO vo) throws EventException ;
	
	
	/**
	 * BDR Time 관리 저장 이벤트 처리.(ESM_BKG_0073)<br>
	 * BDR의 기준이 되는 BDR Time을 등록하는 화면에서... <br>
	 * Lane/Bound/From Location/To Location 기준으로 등록된 BDR Time을 관리.<br>
	 * 
	 * @param SearchBDRPolVO[] vos1
	 * @param SearchBDRTimeTableVO[] vos2
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVVDBDRTime(SearchBDRPolVO[] vos1,SearchBDRTimeTableVO[] vos2,SignOnUserAccount account) throws EventException ;
	
	/**
	 * Equalization Port 등록 화면 조회 이벤트 처리(ESM_BKG_0253)<br>

	 * @param BkgEqlzPortVO vo
	 * @return List<BkgEqlzPortVO>
	 * @throws EventException
	 */
	public List<BkgEqlzPortVO> searchEqualizetionPortCD (BkgEqlzPortVO vo) throws EventException;
	 
	/**
	 * Equalization Port 등록 관리 저장 이벤트 처리(ESM_BKG-0253) <br>
	 * 
	 * @param BkgEqlzPortVO[] vos
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void manageEqualizationPort(BkgEqlzPortVO[] vos,SignOnUserAccount account) throws EventException;
	
	
	/**
	 *  0192 B/L Customer Information in CRM 조회	
	 * @param SearchInBoundCustListVO searchInBoundCustListVO
	 * @return List<SearchInBoundCustListVO>
	 * @throws EventException
	 */
	public List<SearchInBoundCustListVO> searchInBoundCustList(SearchInBoundCustListVO searchInBoundCustListVO) throws EventException ;
	 
	 /**
	  *  0192 B/L Customer Information in CRM Template 조회	
	  * @param BkgCustTmpltVO bkgCustTmpltVO
	  * @return List<BkgCustTmpltVO>
	  * @throws EventException
	  */
	 public List<BkgCustTmpltVO> searchInBoundCustTmpltList(BkgCustTmpltVO bkgCustTmpltVO) throws EventException;

	 /**
     * 멀티 이벤트 처리<br>
     * 0192 B/L Customer Information in CRM Template 트랜잭션 처리
     * 
     * @param BkgCustTmpltVO[] bkgCustTmpltVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageInBoundCustList(BkgCustTmpltVO[] bkgCustTmpltVO,SignOnUserAccount account) throws EventException;	 
	 
	
    /**
	 * 중국 Booking Agent 정보 등록 화면-조회 이벤트 처리 (ESM_BKG-0153)<br>
	 * 
	 * @param BkgChinaAgentVO vo
	 * @return List<BkgChinaAgentVO>
	 * @throws EventException
	 */
	public List<BkgChinaAgentVO> searchChinaAgentCodeList (BkgChinaAgentVO vo) throws EventException;
	
	/**
	 * 중국 Booking Agent 정보 등록 화면 저장 이벤트 처리(ESM_BKG-0153) <br>

	 * @param BkgChinaAgentVO[] vos
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void manageChinaAgentCode(BkgChinaAgentVO[] vos,SignOnUserAccount account) throws EventException;
	
	/**
	 * Vessel Port Schedule 변경에 의한 BKG_VVD_BDR_LOG TABLE 관리<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @exception EventException
	 */
	public void manageBkgVVDBdrLog(String vslCd, String skdVoyNo, String skdDirCd) throws EventException;
	
	/**
	 * Customer Sales Rep 연동 관리<br>
	 * 
	 * @param String message
	 * @exception EventException
	 */
	public void manageBkgCustSlsRep(String message) throws EventException;
	
	/**
	 * BKG_DOC_CLZ_SET TABLE(Documentation Cut-off Time)  조회 처리합니다.<br>
	 * 
	 * @param String ydCd
	 * @param String vslSlanCd
	 * @return List<BkgdocClzSetListVO>
	 * @exception EventException
	 */
	public List<BkgdocClzSetListVO> searchDocCutOffTimeList(String ydCd, String vslSlanCd) throws EventException;
	
		
	
	/**
	 * COUNTRY CODE,NAME  조회 처리합니다.<br>
	 * 
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> searchCntCdNm() throws EventException;
	
	/**
	 * Documentation Cut-off Time 을 SAVE 처리합니다.<br>
	 * 
	 * @param BkgdocClzSetVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDocCutOffTimeList(BkgdocClzSetVO[] vos,SignOnUserAccount account) throws EventException;
	
	/**
	 * Mandatory Item(s) Setup for Customized Service 을 SAVE 처리합니다.<br>
	 * 
	 * @param MandatoryItemSetupListVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMandatoryItemSetupList(MandatoryItemSetupListVO[] vos,SignOnUserAccount account) throws EventException;
	
	/**
	 * Mandatory Item(s) Setup for Customized Service 을 Retrieve 처리합니다.<br>
	 * 
	 * @param BkgMdtItmVO vo
	 * @return List<BkgMdtItmVO>
	 * @exception EventException
	 */
	public List<BkgMdtItmVO> searchMandatoryItemSetupList(BkgMdtItmVO vo) throws EventException;
	
	/**
	 * BKG_EDI_TRD_PRNR_SUB_LNK 연동을 처리합니다.
	 * 
	 * @param String message
	 * @exception EventException
	 */
	public void receiveBkgEdiTrdPrnrSubLnk(String message) throws EventException;

	/**
	 * BKG_EDI_SUB_LNK_MSG 연동을 처리합니다.
	 * 
	 * @param String message
	 * @exception EventException
	 */
	public void receiveBkgEdiSubLnkMsg(String message) throws EventException;

	/**
	 * BKG_EDI_PRNR_PORT_LANE 연동을 처리합니다.
	 * 
	 * @param String message
	 * @exception EventException
	 */
	public void receiveBkgEdiPrnrPortLane(String message) throws EventException;


	/**
	 * 북중국 Manual BKG No 사전 생성 현황 및 사용 현황 조회.<br>
	 * 
	 * @param ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO
	 * @return List<BkgChnBkgNoGenVO>
	 * @exception EventException
	 */
	public List<BkgChnBkgNoGenVO> searchChnMnlBkgNoGenList(
			ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO) throws EventException;

	/**
	 * 북중국 Manual BKG No 사전 생성 및 기록<br>
	 * 
	 * @param ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO
	 * @param SignOnUserAccount account
	 * @return List<BkgChnBkgNoGenVO>
	 * @exception EventException
	 */
	public List<BkgChnBkgNoGenVO> createChnMnlBkgNoGenList(
			ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO, SignOnUserAccount account) throws EventException;

	/**
	 * 사전 생성한 북중국 BKG NO 사용시 사용 표시<br>
	 * 
	 * @param List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVOs
	 * @param String bkgPorCd 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyChnBkgNoUseFlgOnList(List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVOs, String bkgPorCd, SignOnUserAccount account) throws EventException;
	
	/**
	 * manageBkgEdiGrp<br>
	 * 
	 * @param String str
	 * @exception EventException
	 */
	public void manageBkgEdiGrp(String str) throws EventException;

	/**
	 * manageBkgEdiGrpCust<br>
	 * 
	 * @param String str
	 * @exception EventException
	 */
	public void manageBkgEdiGrpCust(String str) throws EventException;

	/**
	 * BKG의 VVD의 BDR LOG FLAG를  조회한다. <br>
	 * 
	 * @param String vvdCd
	 * @param String polCd
	 * @param String podCd
	 * @param String rdoTrunkFeeder
	 * @return String
	 * @throws EventException
	 */
	public String checkVvdBdrLog(String vvdCd,String polCd,String podCd, String rdoTrunkFeeder ) throws EventException ;
 
	/**
	 * bkgNo가 china agent bkg no인지 조회한다.<br>
	 * 
	 * @param 	String bkgNo
	 * @return 	String 
	 * @exception EventException
	 */	
	public String searchIsChnMnlBkgNo(String bkgNo) throws EventException ;
	
	/**
	 * Zip Code 을 Retrieve 처리합니다.<br>
	 * 
	 * @param ZipCdSchVO vo
	 * @param int iPage
	 * @return List<ZipCdListVO>
	 * @exception EventException
	 */
	public List<ZipCdListVO> searchZipCode(ZipCdSchVO vo, int iPage) throws EventException;
	
	/**
	 * zip code 을 SAVE 처리합니다.<br>
	 * 
	 * @param ZipCdListVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageZipCode(ZipCdListVO[] vos,SignOnUserAccount account) throws EventException;

	/**
	 *Combo 생성용 Chinese EDI Agent List Retrieve.<br>
	 * 
	 * @param BkgCstmsChnAgnCdVO vo
	 * @return List<BkgCstmsChnAgnCdVO>
	 * @exception EventException
	 */
	public List<BkgCstmsChnAgnCdVO> searchCstmsChnAgnCdList(BkgCstmsChnAgnCdVO vo) throws EventException;
	
	/**
	 *Chinese EDI Agent Retrieve.<br>
	 * 
	 * @param BkgCstmsChnAgnCdVO vo
	 * @return List<BkgCstmsChnAgnStupVO>
	 * @exception EventException
	 */
	public List<BkgCstmsChnAgnStupVO> searchCstmsChnAgnStup(BkgCstmsChnAgnCdVO vo) throws EventException;
	
	/**
	 * Chinese EDI Agent SAVE.<br>
	 * 
	 * @param BkgCstmsChnAgnStupVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstmsChnAgnStup(BkgCstmsChnAgnStupVO[] vos,SignOnUserAccount account) throws EventException;

	/**
	 * DPCS - Office 별 시간을 조회 한다.<br>
	 * @param BkgDpcsOfcTmVO vo
	 * @return List<BkgDpcsOfcTmVO>
	 * @exception EventException
	 */
	public List<BkgDpcsOfcTmVO> searchDpcsOfcTm(BkgDpcsOfcTmVO vo) throws EventException;
	
	/**
	 * DPCS - Office 별 시간을 관리한다.(ESM_BKG_0441).<br>
	 * @param BkgDpcsOfcTmVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageDpcsOfcTm(BkgDpcsOfcTmVO[] vos,SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_BKG_1130] Retrieve
	 *Import Restricted Commodities Set-up<br>
	 * 
	 * @param RestrictCmdtListVO vo
	 * @return List<RestrictCmdtListVO>
	 * @exception EventException
	 */
	public List<RestrictCmdtListVO> searchRestrictCmdtList(RestrictCmdtListVO vo) throws EventException;
	
	/**
	 * [ESM_BKG_1130] 
	 * Restricted, Prohibited 를 중복체크 한다.<br> 
	 *Import Restricted Commodities Set-up<br>
	 * 
	 * @param RestrictCmdtListVO vo
	 * @return List<RestrictCmdtDupListVO>
	 * @exception EventException
	 */
	public List<RestrictCmdtDupListVO> searchRestrictCmdtDupList(RestrictCmdtListVO vo) throws EventException;
	
	/**
	 * [ESM_BKG_1130] Save 
	 *Import Restricted Commodities Set-up<br>
	 * 
	 * @param RestrictCmdtListVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRetrictCmdtList(RestrictCmdtListVO[] vos,SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_BKG_1131] Retrieve
	 *Import Restricted Commodities Upload<br>
	 * 
	 * @param RestrictCmdtFileVO vo
	 * @return List<BkgImpImgStoVO>
	 * @exception EventException
	 */
	public List<BkgImpImgStoVO> searchRestrictCmdtFile(RestrictCmdtFileVO vo) throws EventException;
	
	/**
	 * [ESM_BKG_1131] Save 
	 *Import Restricted Commodities File Upload<br>
	 * 
	 * @param RestrictCmdtFileVO restrictCmdtFileVO
	 * @exception EventException
	 */
	public void manageRestrictCmdtFile(RestrictCmdtFileVO restrictCmdtFileVO) throws EventException;
	
	/**
	 * 타선사와 VVD 표현 방식이 다른 경우 매핑되는 데이터를 조회한다.(ESM_BKG_1150).<br>
	 * @param BkgMapgVvdVO bkgMapgVvdVO
	 * @return List<BkgMapgVvdVO>
	 * @throws EventException
	 */
	public List<BkgMapgVvdVO> searchMapgVvd(BkgMapgVvdVO bkgMapgVvdVO) throws EventException;
	

	/**
	 * 타선사와 VVD 표현 방식이 다른 경우 매핑되는 데이터를 저장한다.(ESM_BKG_1150).<br>
	 * @param BkgMapgVvdVO[] bkgMapgVvdVOs 
	 * @throws EventException
	 */
	public void manageMapgVvd(BkgMapgVvdVO[] bkgMapgVvdVOs) throws EventException;
	
    /**
     * select Hard Coding Setup List
     * @param BkgHrdCdgDescVO bkgHrdCdgDescVO
     * @return List<BkgHrdCdgDescVO>
     * @throws EventException
     */
    public List<BkgHrdCdgDescVO> searchHrdCdgDesc(BkgHrdCdgDescVO bkgHrdCdgDescVO) throws EventException;
    
	/**Hard Coding Setup List Insert, Update, Delete.
	 * @param BkgHrdCdgDescVO[] bkgHrdCdgDescVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageHrdCdgDesc(BkgHrdCdgDescVO[] bkgHrdCdgDescVOs,SignOnUserAccount account) throws EventException;

	/**
	 * select Hard Coding Contents List
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws EventException
	 */
	public List<BkgHrdCdgCtntVO> searchHrdCdgCtnt(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException;
	
	/**
	 * Hard Coding contents List Insert, Update, Delete.
	 * @param BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageHrdCdgCtnt(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs,SignOnUserAccount account) throws EventException;

	/**check if there is the same Hardcoding Id in DB
	 * @param String hrdCdgId
	 * @return String
	 * @throws EventException
	 */
	public String checkHrdCdgId(String hrdCdgId) throws EventException;
	

	/**check if there is data on Hard coding contents
	 * @param String hrdCdgId
	 * @return String
	 * @throws EventException
	 */
	public String checkChildCnt(String hrdCdgId) throws EventException;
	
	/**
	 * booking close for bayplan 정보를 저장한다.<br>
	 * 
	 * @param BkgTsCoffTmVO[] bkgTsCoffTmVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void closeTsBkgForBayPlan(BkgTsCoffTmVO[] bkgTsCoffTmVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * booking reopen for bayplan 정보를 저장한다.<br>
	 * 
	 * @param BkgTsCoffTmVO[] bkgTsCoffTmVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void reopenTsBkgForBayPlan(BkgTsCoffTmVO[] bkgTsCoffTmVOs, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * select BdrAccessAuthority List
	 * @param BdrAccessAuthorityInfoVO bdrAccessAuthorityInfoVO
	 * @return List<BdrAccessAuthorityInfoVO>
	 * @throws EventException
	 */
	public List<BdrAccessAuthorityInfoVO> searchBdrAccessAuthority(BdrAccessAuthorityInfoVO bdrAccessAuthorityInfoVO) throws EventException;
	
	/**
	 * BdrAccessAuthority List Insert, Update, Delete.
	 * @param BdrAccessAuthorityInfoVO[] bdrAccessAuthorityInfoVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageBdrAccessAuthority(BdrAccessAuthorityInfoVO[] bdrAccessAuthorityInfoVOs, SignOnUserAccount account) throws EventException;
	
	/**
     * E-BKG Handling Office 등록 화면 - 조회<br>	
	 * 화면 ESM_BKG_1180
	 * 
	 * @param BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO
	 * @return List<BkgHandlingOfficeSetupVO>
	 * @throws EventException
	 */	
	 public List<BkgHandlingOfficeSetupVO> searchHandlingOffice(BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO) throws EventException;

	/**
     * E-BKG Handling Office 등록 화면 - 등록/수정/삭제<br>	
	 * 화면 ESM_BKG_1180
     * 
	 * @param BkgHandlingOfficeSetupVO[] bkgHandlingOfficeSetupVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageHandlingOffice(BkgHandlingOfficeSetupVO[] bkgHandlingOfficeSetupVO, SignOnUserAccount account) throws EventException;
  
    /**
	 * BKG_VRFD_WGT_CLZ_SET TABLE(VGM Cut-off Time)  조회 처리합니다.<br>
	 * 
	 * @param String locCd
	 * @param String vslSlanCd
	 * @return List<BkgVGMClzSetListVO>
	 * @exception EventException
	 */
	public List<BkgVgmClzSetListVO> searchVgmCutOffTimeList(String locCd, String vslSlanCd) throws EventException;
	
	/**
	 * VGM Cut-off Time 을 SAVE 처리합니다.<br>
	 * 
	 * @param BkgVgmClzSetVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVgmCutOffTimeList(BkgVgmClzSetVO[] vos,SignOnUserAccount account) throws EventException;
	
    
}
