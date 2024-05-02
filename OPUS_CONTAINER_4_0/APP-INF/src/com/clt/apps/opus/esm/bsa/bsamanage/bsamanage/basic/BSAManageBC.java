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
 =========================================================*/

package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.basic;

import java.util.List;

import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaAddCarrierSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaHighCubicRateSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaManageSltPrcSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaOverUsedSlotCostSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaSlotInfoForSpcCntrSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaTableSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.CreateBSAVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchChgSlotSwapListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchSpcJoPortDownDetailListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchSpcJoPortDownMasterListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchSpcScPortDownDetailListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchSpcScPortDownMasterListVO;
import com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BsaCrrInfoVO;
import com.clt.syscommon.common.table.BsaJntOpCrrCapaVO;
import com.clt.syscommon.common.table.BsaJntOpPortDwnVO;
import com.clt.syscommon.common.table.BsaSltChtrCrrCapaVO;
import com.clt.syscommon.common.table.BsaSltChtrPortDwnVO;
import com.clt.syscommon.common.table.BsaSpcCtrlSwapVO;

/**
 * BSAManage Business Logic Command Interface<br>
 * - BSAManage에 대한 비지니스 로직에 대한 인터페이스<br>
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
	 * @param BsaAddCarrierSaveVO[] bsaAddCarrierSaveVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCarrierRegister(BsaAddCarrierSaveVO[] bsaAddCarrierSaveVOs, SignOnUserAccount account ) throws EventException;

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
	 * @param Event e
	 * @exception EventException
	 * @return String
	 */
	public String multiBSARate(BsaHighCubicRateSaveVO[] bsaHighCubicRateSaveVOs, SignOnUserAccount account, Event e) throws EventException;
	
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
	 * @return String
	 */
	public String multiOverUsedSlotCost(BsaOverUsedSlotCostSaveVO[] bsaOverUsedSlotCostSaveVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchBsaConditionVO searchSlotPrcConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 * @author 20150514.ADD
	 */
	public CommonBsaRsVO searchOpSlotCostList(SearchBsaConditionVO searchSlotPrcConditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param BsaManageSltPrcSaveVO[] bsaManageSltPrcSaveVOs
	 * @param SignOnUserAccount account
	 * @param Event e
	 * @return String
	 * @exception EventException
	 * @author 20150514.ADD
	 */
	public String multiOpSlotCost(BsaManageSltPrcSaveVO[] bsaManageSltPrcSaveVOs, SignOnUserAccount account, Event e ) throws EventException;	
	
	/**
	 * 헤더구성 조회 이벤트 처리<br>
	 * BSAManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchBsaCrrRgstList3() throws EventException;
	

}