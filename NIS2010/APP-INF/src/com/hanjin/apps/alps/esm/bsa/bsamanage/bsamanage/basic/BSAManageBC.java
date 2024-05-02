/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : BSAManageBC.java
 *@FileTitle : BSA Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-02
 *@LastModifier : KimJongBeom
 *@LastVersion : 1.0
 * 2006-10-02 KimJongBeom
 * 1.0 최초 생성
 * 2008.10.01 전성진 CSR No.N200809059194 
 * 					 : Over Used Slot Price Table 생성
 * 2009.05.21 김종열 CSR No.N200904020151
 * 					: BSA Legacy 변경 관련 수정
 * 2009.07.01 김종열 CSR No.N200905220063 
 * 					: H/C Rate 개발 관련 수정
 * 2009.08.14 Kim Ki-Dae ENIS --> ALPS 변환
 * 2009.11.18 남궁진호 CHM-200901152
 *                  : Carrier Code의 MDM 통합관리에 따른 로직 수정
 * 2010.06.21 이행지  - CHM-201004175 : 소스품질검토결과 적용(20100503)
 * 2011.08.19 최성민 [CHM-201112943-01] Add Carrier Time-Out 에러 수정  
 * 2014.12.11 김용습 [CHM-201433095] Overlapped Contract Check 화면 추가
 =========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.basic;

import java.util.List; 

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaAddCarrierSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaHighCubicRateSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaManageSltPrcSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaOverUsedSlotCostSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaSlotInfoForSpcCntrSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaTableSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.CreateBSAVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchOverlappedContractInquiryListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchChgSlotSwapListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcJoPortDownDetailListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcJoPortDownMasterListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcScPortDownDetailListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcScPortDownMasterListVO;
import com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BsaCrrInfoVO;
import com.hanjin.syscommon.common.table.BsaJntOpCrrCapaVO;
import com.hanjin.syscommon.common.table.BsaJntOpPortDwnVO;
import com.hanjin.syscommon.common.table.BsaSltChtrCrrCapaVO;
import com.hanjin.syscommon.common.table.BsaSltChtrPortDwnVO;
import com.hanjin.syscommon.common.table.BsaSpcCtrlSwapVO;

/**
 * enis-BSAManage Business Logic Command Interface<br>
 * - enis-BSAManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KimJongBeom
 * @see ESM_BSA_0xxEventResponse 참조
 * @since J2EE 1.4
 */

public interface BSAManageBC { 

	/* ===============================================================================
	 * ESM_BSA_021: 화면<br>  
	 * =============================================================================== 
	 */
	/**
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchBSATableHeaderList() throws EventException;

	/**
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchBSATableJOList(SearchBsaConditionVO searchBsaConditionVO) throws EventException;

	/**
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchBSATableSCList(SearchBsaConditionVO searchBsaConditionVO) throws EventException;

	/**
	 * @param BsaTableSaveVO[] bsaTableSaveVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiBSATableJO(BsaTableSaveVO[] bsaTableSaveVOs, SignOnUserAccount account) throws EventException;

	/**
	 * @param BsaTableSaveVO[] bsaTableSaveVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiBSATableSC(BsaTableSaveVO[] bsaTableSaveVOs, SignOnUserAccount account) throws EventException;

	/**
	 * @param BsaTableSaveVO[] bsaTableSaveVOs
	 * @exception EventException
	 */
	public void removeBSATableJO(BsaTableSaveVO[] bsaTableSaveVOs) throws EventException;

	/**
	 * @param BsaTableSaveVO[] bsaTableSaveVOs
	 * @exception EventException
	 */
	public void removeBSATableSC(BsaTableSaveVO[] bsaTableSaveVOs) throws EventException;

	/**
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @param SignOnUserAccount account
	 * @return CreateBSAVO
	 * @exception EventException
	 */
	public CreateBSAVO createBSA(SearchBsaConditionVO searchBsaConditionVO, SignOnUserAccount account) throws EventException;

	
	/* ===============================================================================
	 * ESM_BSA_023: 화면<br>
	 * =============================================================================== 
	 */

	/**
	 * 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String bsaOpCd
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchCarrierRegisterList(String bsaOpCd) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * BSAManage화면에 대한 수정 이벤트 처리<br>
	 * 
	 * @param BsaAddCarrierSaveVO[] vos
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String modifyCarrierRegister(BsaAddCarrierSaveVO[] vos, SignOnUserAccount account) throws EventException;

	/* ===============================================================================
	 * ESM_BSA_0026: 화면<br>
	 * =============================================================================== 
	 */

	/**
	 * ESM_BSA_0026: 화면<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @return List<SearchSpcJoPortDownMasterListVO>
	 * @exception EventException
	 */
	public List<SearchSpcJoPortDownMasterListVO> searchSpcJoPortDownMasterList(SearchBsaConditionVO vo) throws EventException;

	/**
	 * @param SearchBsaConditionVO vo
	 * @return List<SearchSpcJoPortDownDetailListVO>
	 * @throws EventException
	 */
	public List<SearchSpcJoPortDownDetailListVO> searchSpcJoPortDownDetailList(SearchBsaConditionVO vo) throws EventException;

	/**
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void resetSpcJoPortDown(SearchBsaConditionVO searchBsaConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createSpcJoPortDown(SearchBsaConditionVO searchBsaConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * @param BsaJntOpCrrCapaVO[] bsaJntOpCrrCapaVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSPCDownPortJOMaster(BsaJntOpCrrCapaVO[] bsaJntOpCrrCapaVOs, SignOnUserAccount account) throws EventException;

	/**
	 * @param BsaJntOpPortDwnVO[] bsaJntOpPortDwnVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSPCDownPortJODetail(BsaJntOpPortDwnVO[] bsaJntOpPortDwnVOs, SignOnUserAccount account) throws EventException;


	/**
	 * @param SearchBsaConditionVO vo
	 * @return List<SearchSpcScPortDownMasterListVO>
	 * @exception EventException
	 */
	public List<SearchSpcScPortDownMasterListVO> searchSpcScPortDownMasterList(SearchBsaConditionVO vo) throws EventException;

	/**
	 * @param SearchBsaConditionVO vo
	 * @return List<SearchSpcScPortDownDetailListVO>
	 * @throws EventException
	 */
	public List<SearchSpcScPortDownDetailListVO> searchSpcScPortDownDetailList(SearchBsaConditionVO vo) throws EventException;

	/**
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void resetSpcScPortDown(SearchBsaConditionVO searchBsaConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createSpcScPortDown(SearchBsaConditionVO searchBsaConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * @param BsaSltChtrCrrCapaVO[] bsaSltChtrCrrCapaVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSPCDownPortSCMaster( BsaSltChtrCrrCapaVO[] bsaSltChtrCrrCapaVOs, SignOnUserAccount account) throws EventException;

	/**
	 * @param BsaSltChtrPortDwnVO[] bsaSltChtrPortDwnVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSPCDownPortSCDetail(BsaSltChtrPortDwnVO[] bsaSltChtrPortDwnVOs, SignOnUserAccount account) throws EventException;

	/* 
	 =================================================================================
	 ESM_BSA_024: 화면<br>
	 ================================================================================= 
	 */
	/**
	 * bsa_crr_rgst테이블의 Carrier목록을 조회
	 * 
	 * @param String bsaOpCd
	 * @return String
	 * @throws EventException
	 */
	public String searchCarrierItem(String bsaOpCd) throws EventException;

	/**
	 * BSAManage Slot-info for SPC Control JO화면에 대한 조회 이벤트 처리[ESM_BSA_0024]
	 * 
	 * @param  SearchBsaConditionVO vo
	 * @return CommonBsaRsVO
	 * @throws EventException
	 */
	public CommonBsaRsVO searchSPCJOBSA(SearchBsaConditionVO vo) throws EventException;

	/**
	 * BSAManage Slot-info for SPC Control JO화면에 대한 저장 이벤트 처리[ESM_BSA_0024]
	 * 
	 * @param BsaSlotInfoForSpcCntrSaveVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSPCJOBSA(BsaSlotInfoForSpcCntrSaveVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * BSAManage Slot-info for SPC Control SC화면에 대한 조회 이벤트 처리[ESM_BSA_0025]
	 * 
	 * @param  SearchBsaConditionVO searchBsaConditionVO
	 * @return CommonBsaRsVO
	 * @throws EventException
	 */
	public CommonBsaRsVO searchSPCSCBSA(SearchBsaConditionVO searchBsaConditionVO) throws EventException;

	/**
	 * BSAManage Slot-info for SPC Control SC화면에 대한 저장 이벤트 처리[ESM_BSA_025]
	 * 
	 * @param BsaSlotInfoForSpcCntrSaveVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSPCSCBSA(BsaSlotInfoForSpcCntrSaveVO[] vos, SignOnUserAccount account) throws EventException;
	
	/* 
	 =================================================================================
	 ESM_BSA_0122: 화면<br>
	 ================================================================================= 
	 */
	/**
	 * BSAManage Slot-info for SPC Control JO화면 PopUp화면에 대한 조회 이벤트 처리
	 * 
	 * @param  SearchBsaConditionVO searchBsaConditionVO
	 * @return List<SearchChgSlotSwapListVO>
	 * @throws EventException
	 */
	public List<SearchChgSlotSwapListVO> searchChgSlotSwapList(SearchBsaConditionVO searchBsaConditionVO) throws EventException;

	/**
	 * BSAManage Slot-info for SPC Control JO화면 PopUp화면에 대한 저장 이벤트 처리
	 * 
	 * @param  BsaSpcCtrlSwapVO[] bsaSpcCtrlSwapVOs
	 * @param  SearchBsaConditionVO searchBsaConditionVO
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiChgSlotSwap(BsaSpcCtrlSwapVO[] bsaSpcCtrlSwapVOs,SearchBsaConditionVO searchBsaConditionVO, SignOnUserAccount account) throws EventException;

	/* ===============================================================================
	 * ESM_BSA_0120: 화면<br>
	 * =============================================================================== 
	 */

	/**
	 * 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return List<BsaCrrInfoVO>
	 * @exception EventException
	 */
	public List<BsaCrrInfoVO> searchCarrierInfoList() throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiCarrierInfo(SearchBsaConditionVO searchBsaConditionVO,SignOnUserAccount account) throws EventException;
	
	/* ===============================================================================
	 * ESM_BSA_028: 화면<br>
	 * =============================================================================== 
	 */

	/**
	 * 헤더구성 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchBsaCrrRgstList() throws EventException;
	

	/**
	 * 헤더구성 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchBsaCrrRgstList1() throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO searchSlotPrcConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchSlotCostList(SearchBsaConditionVO searchSlotPrcConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO searchSlotPrcConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchRFCostList(SearchBsaConditionVO searchSlotPrcConditionVO) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO searchSlotPrcConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	
	public CommonBsaRsVO searchOverCostList(SearchBsaConditionVO searchSlotPrcConditionVO) throws EventException;
	
	/**
	 * ESM_BSA_0172:조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchBSARateList(SearchBsaConditionVO searchBsaConditionVO) throws EventException;
	
	/**
	 * ESM_BSA_0172: 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaHighCubicRateSaveVO[] bsaHighCubicRateSaveVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiBSARate(BsaHighCubicRateSaveVO[] bsaHighCubicRateSaveVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param BsaManageSltPrcSaveVO[] bsaManageSltPrcSaveVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSlotCost(BsaManageSltPrcSaveVO[] bsaManageSltPrcSaveVOs,SignOnUserAccount account ) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaManageSltPrcSaveVO[] bsaManageSltPrcSaveVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiRFCost(BsaManageSltPrcSaveVO[] bsaManageSltPrcSaveVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaManageSltPrcSaveVO[] bsaManageSltPrcSaveVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiOverCost(BsaManageSltPrcSaveVO[] bsaManageSltPrcSaveVOs,SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 헤더구성 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchBsaCrrRgstList2() throws EventException;	
	
	/**
	 * ESM_BSA_0162: 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchOverUsedSlotCostList(SearchBsaConditionVO searchBsaConditionVO) throws EventException;

	/**
	 * ESM_BSA_0162:멀티 이벤트 처리<br>
	 * BSAManage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BsaOverUsedSlotCostSaveVO[] bsaOverUsedSlotCostSaveVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiOverUsedSlotCost(BsaOverUsedSlotCostSaveVO[] bsaOverUsedSlotCostSaveVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchBackEndJobStatus(String key) throws EventException;

	/**
	 * @param SearchBsaConditionVO searchBsaConditionVO
	 * @return List<BsaTableSaveVO>
	 * @exception EventException
	 */ 
	public List<BsaTableSaveVO> searchBSATableVvdList(SearchBsaConditionVO searchBsaConditionVO) throws EventException;

	/**
	 * ESM_BSA_0035: 조회 이벤트 처리 (JOINT OPERATING)<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @return List<SearchOverlappedContractInquiryListVO>
	 * @exception EventException
	 */	
	public List<SearchOverlappedContractInquiryListVO> searchOverlappedContractInquiryJOList(SearchBsaConditionVO vo) throws EventException;
	
	/**
	 * ESM_BSA_0035: 조회 이벤트 처리 (SPACE CHARTERING)<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @return List<SearchOverlappedContractInquiryListVO>
	 * @exception EventException
	 */	
	public List<SearchOverlappedContractInquiryListVO> searchOverlappedContractInquirySCList(SearchBsaConditionVO vo) throws EventException;
	
	/**
	 * ESM_BSA_0035: 조회 이벤트 처리 (SLOT PRICE)<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO vo
	 * @return List<SearchOverlappedContractInquiryListVO>
	 * @exception EventException
	 */	
	public List<SearchOverlappedContractInquiryListVO> searchOverlappedContractInquirySPList(SearchBsaConditionVO vo) throws EventException;
	

}