/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : NetworkDistributionBC.java
*@FileTitle : Network Distribution BC
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : KimJongBeom
*@LastVersion : 1.0
* 2006-11-28 KimJongBeom
* 1.0 최초 생성
* 
* =========================================================
* History
* 2008.07.22 전윤주 N200807218173 Commercial Base U/C 화면 추가 
* 2010.10.22 이행지 [CHM-201006375-01][COA] Trunk IPC와 Ocean간 내부거래 신규 추가 
* 2013.01.29 서미진 [CHM-201322638] 한 주차만 생성 가능하던 로직을 여러 주차 생성 가능하도록 신규 배치 생성으로 변경
* 2014.03.25 최성민 [CHM-201429403-01] [COA] Apply to P&L시 전 OP view에 대해서 장기주차 가능하도록 수정
=========================================================*/

package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.AllocResultCommitListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistNewListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistResultListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostSntListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchHJSSalesAmountListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchLaneTSCommitmentListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchLaneTSUnitCostListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchSpcChtrRevMssListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaFxAmtDtrbVO;
import com.hanjin.syscommon.common.table.CoaLaneRgstVO;
import com.hanjin.syscommon.common.table.CoaLaneTsBsaCmmtVO;
import com.hanjin.syscommon.common.table.CoaLaneTsUtCostVO;

/**
 * enis-WeeklyPFMC Business Logic Command Interface<br>
 * - enis-WeeklyPFMC에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KimJongBeom
 * @see ESM_COA_045EventResponse 참조
 * @since J2EE 1.4
 */

public interface NetworkDistributionBC {

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @param SignOnUserAccount account
	 * @return List<SearchHJSSalesAmountListVO>
	 * @exception EventException
	 */
	public List<SearchHJSSalesAmountListVO> searchHJSSalesAmountList(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException;

	/**
	 * 생성 이벤트 처리<br>
	 * NetworkDistribution화면에 대한 생성 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @param NetworkDistributionCommonVO vo
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createHJSSalesAmount(SearchConditionVO searchVO, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SignOnUserAccount account
	 * @return List<SearchFixCostDistListVO>
	 * @exception EventException
	 */
	public List<SearchFixCostDistListVO> searchFixCostDistList(SearchConditionVO searchVo, SignOnUserAccount account) throws EventException;

	/**
	 * T/S Allocation2 조회<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SignOnUserAccount account
	 * @return List<SearchFixCostDistNewListVO>
	 * @exception EventException
	 */
	public List<SearchFixCostDistNewListVO> searchFixCostDistNewList(SearchConditionVO searchVo, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createFixCostDist(SearchConditionVO searchVo, SignOnUserAccount account) throws EventException;
	

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkDistributionCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchFixCostDistResultListVO>
	 * @exception EventException
	 */
	public List<SearchFixCostDistResultListVO> searchFixCostDistResultList(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException;


	/**
	 * Allocation Results(Commitment base) 조회 <br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @return List<AllocResultCommitListVO>
	 * @exception EventException
	 */
	public List<AllocResultCommitListVO> searchAllocResultCommitList(SearchConditionVO searchVo) throws EventException;

    /**
     * Apply to P/L <br>
     *
	 * @param SearchConditionVO searchVo
 	 * @param NetworkDistributionCommonVO vo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
     */
	public String applyToPL(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException;
	
//	/**
//	 * APPLY 이벤트 처리<br>
//	 * NetworkDistribution화면에 대한 APPLY 이벤트 처리<br>
//	 * 
//	 * @param SearchConditionVO searchVo
//	 * @param NetworkDistributionCommonVO vo
//	 * @param SignOnUserAccount account
//	 * @return EventResponse
//	 * @exception DAOException
//	 */
//	public EventResponse applyToPL(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_COA_0125Event 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @return List<SearchLaneTSCommitmentListVO>
	 * @exception EventException
	 */
	public List<SearchLaneTSCommitmentListVO> searchLaneTSCommitmentList(SearchConditionVO searchVo) throws EventException;

	/**
	 * ESM_COA_0125Event 저장 이벤트 처리<br>
	 * 
	 * @param CoaLaneTsBsaCmmtVO[] vos
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiLaneTSCommitment(CoaLaneTsBsaCmmtVO[] vos, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkDistributionCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchSpcChtrRevMssListVO>
	 * @exception EventException
	 */
	public List<SearchSpcChtrRevMssListVO> searchSpcChtrRevMssList(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkDistributionCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchLaneTSUnitCostListVO>
	 * @exception EventException
	 */
	public List<SearchLaneTSUnitCostListVO> searchLaneTSUnitCostList(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 저장 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkDistributionCommonVO vo
	 * @param CoaLaneTsUtCostVO[] vos
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiLaneTSUnitCost(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, CoaLaneTsUtCostVO[] vos, SignOnUserAccount account) throws EventException;
	
	/**
	 * [TS Allocation(SNT)]을 [조회] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @param SignOnUserAccount account
	 * @return List<SearchFixCostSntListVO>
	 * @exception EventException
	 */
	public List<SearchFixCostSntListVO> searchFixCostSntList(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 생성 이벤트 처리<br>
	 * TS Allocation(SNT) 화면에 대한 TS배부 생성 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createFixCostSnt(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException;
	/**
	 * [Allocation Result(Internal Pricing)]을 [조회] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<CoaFxAmtDtrbVO>
	 * @exception EventException
	 */
	public List<CoaFxAmtDtrbVO> searchAllocationResultInter(SearchConditionVO searchConditionVO) throws EventException;
	/**
	 * [Allocation Result(Internal Pricing)]을 [Create] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createAllocationResultInter(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * Allocation Result(Internal Pricing) Aply To PL 이벤트 처리<br>
	 * NetworkDistribution화면에 대한 APPLY 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception DAOException
	 */
	public EventResponse applyToPLInter(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * TS Allocation BATCH 가 실행중인지를 check 한다.
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String checkTsAllocationCreateBatchStatus() throws EventException ;
	
	/**
	 * Week 단위로 TS Allocation BATCH 를 수행한다. <br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createTsAllocation(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * TS Allocation BATCH status 를 생성한다. <br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addTSAllocationBatchStatus(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	

	/**
	 * Rlane, Direction 별 Haul bound 정보를 조회한다.<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @return List<CoaLaneRgstVO>
	 * @exception EventException
	 */
	public List<CoaLaneRgstVO> searchTradeDirbyLaneList(SearchConditionVO searchVo) throws EventException;

}