/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DryWetClaimBC.java
*@FileTitle : DW Claim Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.basic;

import java.util.List;

import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CniDwTrnsVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.HandlerHistoryVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.ManagerHistoryVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CondSearchStatusListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.ContainerHandlingCostVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CustomDryWetClaimVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CustomHandlingCostVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchAgentVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchDryWetClaimCodeListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchDryWetClaimVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchRoeListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchStatusListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchVesselListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchVesselVvdListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.TransferCondVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.TransferVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * Dry&Wet Claim Business Logic Command Interface<br>
 * - Dry&Wet Claim에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoon, Seyeong
 * @see Cps_cni_0301EventResponse 참조
 * @since J2EE 1.6
 */

public interface DryWetClaimBC {

	/**
	 * Dry & Wet Claim을 조회한다.<br>
	 * 
	 * @param String dwClmNo
	 * @return SearchDryWetClaimVO
	 * @exception EventException
	 */
	public SearchDryWetClaimVO searchDryWetClaim(String dwClmNo) throws EventException ;
	
	/**
	 * Dry & Wet Claim를 생성 및 변경한다.<br>
	 * 
	 * @param CustomDryWetClaimVO customDryWetClaimVO
	 * @param CniDwTrnsVO cniDwTrnsVO
	 * @param String usrId
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String manageDryWetClaim(CustomDryWetClaimVO customDryWetClaimVO, CniDwTrnsVO cniDwTrnsVO, String usrId, String ofcCd) throws EventException;
	
	/**
	 * Dry & Wet Claim의 MISCELLANEOUS  코드를 조회한다.<br>
	 * 
	 * @param String typeCd
	 * @return List<SearchDryWetClaimCodeListVO>
	 * @exception EventException
	 */
	public List<SearchDryWetClaimCodeListVO> searchDryWetClaimCodeList(String typeCd) throws EventException ;
	/**
	 * Handler 코드를 조회한다.<br>
	 * 
	 * @param String handler
	 * @return String
	 * @exception EventException
	 */
	public String searchDryWetClaimHandler(String handler) throws EventException ;
	
	/**
	 * 통화를 검사한다.<br>
	 * 
	 * @param String currCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCurrency(String currCd) throws EventException ;
	
	/**
	 * Agent 에 관련된 전화번호, e-Mail 정보를 조회한다.<br>
	 * 
	 * @param String agentCd
	 * @return List<SearchAgentVO>
	 * @exception EventException
	 */
	public List<SearchAgentVO> searchAgent(String agentCd ) throws EventException ;

	/**
	 * Dry & Wet Claim를 Status Close한다.<br>
	 * 
	 * @param dwClmNo String
	 * @param usrId String
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void modifyCloseDryWetClaim(String dwClmNo, String usrId, String ofcCd) throws EventException;
	
	/**
	 * Dry & Wet Claim를 Status Reopen한다.<br>
	 * 
	 * @param dwClmNo String
	 * @param usrId String
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String modifyReopenDryWetClaim(String dwClmNo, String usrId, String ofcCd) throws EventException;

	/**
	 * Dry & Wet Claim를 Status Cancel한다.<br>
	 * 
	 * @param dwClmNo String
	 * @param usrId String
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void modifyCancelDryWetClaim(String dwClmNo, String usrId, String ofcCd) throws EventException;
	
	/**
	 * 선박명을 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @return String
	 * @exception EventException
	 */
	public String searchVesselName(String vslCd) throws EventException ;
	
	/**
	 * Claim 및Incident Case 접수 및 처리 현황 조회한다.<br>
	 * 
	 * @param CondSearchStatusListVO condSearchStatusListVO
	 * @return List<SearchStatusListVO>
	 * @exception EventException
	 */
	public List<SearchStatusListVO> searchStatusList(CondSearchStatusListVO condSearchStatusListVO) throws EventException ;
	
	/**
	 * Office Code를 검사한다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchDryWetClaimOffice(String ofcCd) throws EventException ;

	/**
	 * 선박 항차 정보를 조회한다.<br>
	 * 
	 * @param String vvdCd
	 * @param String vslEngNm
	 * @return List<SearchVesselVvdListVO>
	 * @exception EventException
	 */
	public List<SearchVesselVvdListVO> searchVesselVvdList(String vvdCd, String vslEngNm) throws EventException ;
	
	/**
	 * 경리환율 정보를 조회한다.<br>
	 * 
	 * @param String fmDt
	 * @param String toDt
	 * @param String currCd
	 * @return List<SearchRoeListVO>
	 * @exception EventException
	 */
	public List<SearchRoeListVO> searchRoeList(String fmDt, String toDt, String currCd) throws EventException ;

	/**
	 * 해당 Case 관련 발생된 제 처리비용을 조회한다.<br>
	 * 
	 * @param String dwClmNo
	 * @return ContainerHandlingCostVO
	 * @exception EventException
	 */
	public ContainerHandlingCostVO searchHandlingCostList(String dwClmNo) throws EventException ;
	
	/**
	 * 해당 Case 관련 발생된 제 처리비용을 생성 및 변경한다<br>
	 * 
	 * @param customHandlingCostVOs CustomHandlingCostVO[]
	 * @param dwClmNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageHandlingCost(CustomHandlingCostVO[] customHandlingCostVOs, String dwClmNo, String usrId) throws EventException;
	
	/**
	 * 선박 정보를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @param String vslNm
	 * @return List<SearchVesselListVO>
	 * @exception EventException
	 */
	public List<SearchVesselListVO> searchVesselList(String vslCd, String vslNm) throws EventException ;
	
	// ===========================================================================
    // 정행룡
    // ===========================================================================
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0310] Handler History
	// ---------------------------------------------------------------------------
	/**
	 * Claim No별 Handler History 리스트 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0310
	 * @category searchHandlerHistoryList 
	 * @param String dwClmNo 
     * @return List<HandlerHistoryVO> 
     * @throws EventException
     */
	public List<HandlerHistoryVO> searchHandlerHistoryList(String dwClmNo) throws EventException;
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0311] Manager History
	// ---------------------------------------------------------------------------
	/**
	 * Claim No별 Manager History 리스트 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0311
	 * @category searchManagerManagerHistoryList 
	 * @param String dwClmNo
     * @return List<ManagerHistoryVO>  
     * @throws EventException
     */
	public List<ManagerHistoryVO> searchManagerHistoryList(String dwClmNo) throws EventException;
    
	/**
	 * Claim Manager 정보 등록, 수정, 삭제 처리<br>
	 * @author 정행룡
	 * @category CPS_CNI_0311
	 * @category manageManagerHistory 
	 * @param HandlerHistoryVO[] HandlerHistoryVOs
	 * @exception EventException
	 */
	
	public void manageManagerHistory(HandlerHistoryVO[] handlerHistoryVOs) throws EventException;
	
	/**
	 * Handler History 정보 등록<br>
	 * @author 정행룡
	 * @category CPS_CNI_0301
	 * @category addHandlerHistory
	 * @param HandlerHistoryVO handlerHistoryVO
	 * @exception EventException
	 */
	public void addHandlerHistory(HandlerHistoryVO handlerHistoryVO) throws EventException;
	
	
	/**
	 * Claim Handler 정보 등록, 수정<br>
	 * @author 정행룡
	 * @category CPS_CNI_0311
	 * @category manageHandlerHistory 
	 * @param HandlerHistoryVO handlerHistoryVO 
	 * @param String afterDwClmStsCd
	 * @exception EventException
	 */
	public void manageHandlerHistory(HandlerHistoryVO handlerHistoryVO, String afterDwClmStsCd) throws EventException;
		
	/**
	 * Handler History 정보 수정<br>
	 * @author 정행룡
	 * @category CPS_CNI_0301
	 * @category modifyHandlerHistory
	 * @param HandlerHistoryVO handlerHistoryVO
	 * @exception EventException
	 */
	public void modifyHandlerHistory(HandlerHistoryVO handlerHistoryVO) throws EventException;
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0312] Transfer
	// ---------------------------------------------------------------------------
	/**
	 * Transfer 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0312
	 * @category searchTransferList 
	 * @param TransferCondVO transferCondVO
     * @return List<TransferVO> 
     * @throws EventException
     */
	public List<TransferVO> searchTransferList(TransferCondVO transferCondVO) throws EventException;
	
	/**
	 * Transfer 멀티 이벤트 처리<br>
	 * @author 양정란
	 * @category CPS_CNI_0312
	 * @category manageTransfer
	 * @param TransferVO[] transferVO
	 * @exception EventException  
	 */
	public void manageTransfer(TransferVO[] transferVO) throws EventException;	

}