/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName           : SPCManageBC.java
 *@FileTitle          : SPC Manage
 *Open Issues         :
 *Change history      :
 *@LastModifyDate     : 2006-12-21
 *@LastModifier       : Park Eun Ju
 *@LastVersion        : 1.0
 * 1.0 최초 생성
 =========================================================
 * History :
 * 2008.10.24 전성진 CSR No.N200810100017 [030]
 *                   : Slot Price 및 TEU & Slot Price 화면 추가
 *                     searchSlotPrcSwapVvdList, searchTEUPrcSwapVvdList
 =========================================================*/

package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.basic;

import java.util.List;

import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.BsaSpcSlotInfoByVvdSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotInfoByVvdOnVesselListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotSwapByVvdListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdDetailListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdMasterListVO;
import com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BsaVvdMstVO;
import com.clt.syscommon.common.table.BsaVvdPortDwnVO;
import com.clt.syscommon.common.table.BsaVvdSwapInfoVO;

/**
 * SPCManage Business Logic Command Interface<br>
 * - SPCManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Eun Ju
 * @see    ESM_BSA_0xxEventResponse 참조
 * @since  J2EE 1.4
 */

public interface SPCManageBC {
	
	// //////////////////////////////////////////////////////////////////////////// //
	//                            ESM_BSA_0030: 화면                                                                                      //
	// //////////////////////////////////////////////////////////////////////////// //
	/**
	 * ESM_BSA_0030의 HEADER목록을 조회한다.
	 * 
	 * @param  SearchSpcConditionVO searchSpcConditionVO
	 * @return CommonBsaRsVO
	 * @throws EventException
	 */
	public CommonBsaRsVO searchOpJobCarrierList(SearchSpcConditionVO searchSpcConditionVO) throws EventException;

	/**
	 * ESM_BSA_0030화면의 조회 이벤트를 처리한다.<br>
	 * 
	 * @param     SearchSpcConditionVO searchSpcConditionVO
	 * @return    CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchSupplySwapVvdList(SearchSpcConditionVO searchSpcConditionVO) throws EventException;
	
	/**
	 * ESM_BSA_0030화면의 조회 이벤트를 처리한다.<br>
	 * 
	 * @param     SearchSpcConditionVO searchSpcConditionVO
	 * @return    CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchSlotPrcSwapVvdList(SearchSpcConditionVO searchSpcConditionVO) throws EventException;
	
	/**
	 * ESM_BSA_030화면의 조회 이벤트를 처리한다.<br>
	 * 
	 * @param     SearchSpcConditionVO searchSpcConditionVO
	 * @return    CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchTEUPrcSwapVvdList(SearchSpcConditionVO searchSpcConditionVO) throws EventException;
	
	/**
	 * ESM_BSA_0030화면의 조회 이벤트를 처리한다.(수입/비용)<br>
	 * 
	 * @param searchSpcConditionVO SearchSpcConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchRevCostSwapVvdList(SearchSpcConditionVO searchSpcConditionVO) throws EventException;
	
	/**
	 * ESM_BSA_0030화면의 생성 이벤트를 처리한다.<br>
	 * 
	 * @param SearchSpcConditionVO searchSpcConditionVO
	 * @param SignOnUserAccount account
	 * @return CommonBsaRsVO
	 * @throws EventException
	 */
	public CommonBsaRsVO createSupplySwapVvd(SearchSpcConditionVO searchSpcConditionVO,SignOnUserAccount account) throws EventException;

	/**
	 * ESM_BSA_0030화면의 RESET 이벤트를 처리한다.<br>
	 * 
	 * @param SearchSpcConditionVO searchSpcConditionVO
	 * @param SignOnUserAccount account
	 * @return CommonBsaRsVO
	 * @throws EventException
	 */
	public CommonBsaRsVO resetSupplySwapVvd(SearchSpcConditionVO searchSpcConditionVO,SignOnUserAccount account) throws EventException;

	// //////////////////////////////////////////////////////////////////////////// //
	//                            ESM_BSA_0032: 화면                                         	                //
	// //////////////////////////////////////////////////////////////////////////// //

	/**
	 * ESM_BSA_0032: 화면<br>
	 * 
	 * @param SearchSpcConditionVO searchSpcConditionVO
	 * @return List< SearchStepUpDownVvdMasterListVO >
	 * @exception EventException
	 */
	public List<SearchStepUpDownVvdMasterListVO> searchStepUpDownVvdMasterList(SearchSpcConditionVO searchSpcConditionVO) throws EventException;

	/**
	 * @param SearchSpcConditionVO searchSpcConditionVO
	 * @return List< SearchStepUpDownVvdDetailListVO >
	 * @throws EventException
	 */
	public List<SearchStepUpDownVvdDetailListVO> searchStepUpDownVvdDetailList(SearchSpcConditionVO searchSpcConditionVO) throws EventException;
	
	/**
	 * @param BsaVvdMstVO[] bsaVvdMstVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyStepUpDownVvdMaster(BsaVvdMstVO[] bsaVvdMstVOs, SignOnUserAccount account) throws EventException;

	/**
	 * @param BsaVvdPortDwnVO[] bsaVvdPortDwnVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiStepUpDownVvd(BsaVvdPortDwnVO[] bsaVvdPortDwnVOs,SignOnUserAccount account) throws EventException;
	

	// //////////////////////////////////////////////////////////////////////////// //
	//                            ESM_BSA_104: 화면                                                                   //
	// //////////////////////////////////////////////////////////////////////////// //
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BSA_0104 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchSpcConditionVO searchSpcConditionVO 
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchSpcSlotInfoByVvdList(SearchSpcConditionVO searchSpcConditionVO) throws EventException;
	
	/**
	 * ESM_BSA_0104 화면의 저장 이벤트를 처리한다.
	 * 
	 * @param  BsaSpcSlotInfoByVvdSaveVO[] bsaSpcSlotInfoByVvdSaveVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSpcSlotInfoByVvd(BsaSpcSlotInfoByVvdSaveVO[] bsaSpcSlotInfoByVvdSaveVOs,SignOnUserAccount account) throws EventException;


	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BSA_0104 화면의 팝업 ESM_BSA_0121화면  대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchSpcConditionVO searchSpcConditionVO 
	 * @return List<SearchSpcSlotSwapByVvdListVO>
	 * @exception EventException
	 */
	public List<SearchSpcSlotSwapByVvdListVO> searchSpcSlotSwapByVvdList(SearchSpcConditionVO searchSpcConditionVO) throws EventException;
	
	/**
	 * ESM_BSA_0104 화면의 팝업 ESM_BSA_0121화면 저장 이벤트를 처리한다.
	 * 
	 * @param  SearchSpcConditionVO searchSpcConditionVO
	 * @param  BsaVvdSwapInfoVO[] bsaVvdSwapInfoVOs
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSpcSlotSwapByVvd(SearchSpcConditionVO searchSpcConditionVO,BsaVvdSwapInfoVO[] bsaVvdSwapInfoVOs, SignOnUserAccount account ) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BSA_0104 화면의 팝업 ESM_BSA_0143화면  대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchSpcConditionVO searchSpcConditionVO 
	 * @return List<SearchSpcSlotInfoByVvdOnVesselListVO>
	 * @exception EventException
	 */
	public List<SearchSpcSlotInfoByVvdOnVesselListVO> searchSpcSlotInfoByVvdOnVesselList(SearchSpcConditionVO searchSpcConditionVO) throws EventException;

}