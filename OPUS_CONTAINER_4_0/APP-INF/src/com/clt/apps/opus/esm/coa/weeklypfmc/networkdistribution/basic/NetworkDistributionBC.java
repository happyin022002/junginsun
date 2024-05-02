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
=========================================================*/

package com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistResultListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchCOMSalesAmountListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchSpcChtrRevMssListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaFxAmtDtrbVO;



/**
 * WeeklyPFMC Business Logic Command Interface<br>
 * - WeeklyPFMC에 대한 비지니스 로직에 대한 인터페이스<br>
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
	 * @return List<SearchCOMSalesAmountListVO>
	 * @exception EventException
	 */
	public List<SearchCOMSalesAmountListVO> searchCOMSalesAmountList(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException;

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
	public EventResponse createCOMSalesAmount(SearchConditionVO searchVO, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException;

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
	 * APPLY 이벤트 처리<br>
	 * NetworkDistribution화면에 대한 APPLY 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkDistributionCommonVO vo
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception DAOException
	 */
	public EventResponse applyToPL(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException;
	
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

}