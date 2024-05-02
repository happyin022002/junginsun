/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : PlanningBC.java
*@FileTitle      : Planning
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.21
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.21 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planning.basic;

import java.util.List;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaByRhqListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaByRhqResultVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaByRhqSimulationVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaLoadRevForSectorAddListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaLoadRevForSectorListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaLoadRevListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaRhqDistributeResultListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaRhqQtaSummaryListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaSetUpHeadOfficeListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaSetupForIsaSecByHoSummaryVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CsqQtaLodRevVO;
import com.clt.syscommon.common.table.CsqQtaPotnMgmtVO;
import com.clt.syscommon.common.table.CsqSctrLodRevVO;

/**
 * ALPS-Planning Business Logic Command Interface<br>
 * - ALPS-Planning 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CSQ USER
 * @see
 * @since J2EE 1.6
 */
public interface PlanningBC { 
	
	/**
	 * ESM_CSQ_0020 : [이벤트]<br>
	 * [QTA Set up by Head Office (L/F & G.RPB)]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaLoadRevListVO>
	 * @throws EventException
	 */
	public List<SearchQtaLoadRevListVO> searchQtaLoadRevList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0020 : [이벤트]<br>
	 * [QTA Set up by Head Office (L/F & G.RPB)]을 [업데이트] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param CsqQtaLodRevVO[] csqQtaLodRevVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaLoadRev(ConditionVO conditionVO, CsqQtaLodRevVO[] csqQtaLodRevVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0020 : [이벤트]<br>
	 * [QTA Set up by Head Office (L/F & G.RPB)]을 [confirm] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void confirmQtaLoadRev(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0021 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaSetUpHeadOfficeListVO>
	 * @throws EventException
	 */
	public List<SearchQtaSetUpHeadOfficeListVO> searchQtaSetUpHeadOfficeList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0021 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [수정] 합니다.<br>
	 * 
	 * @param CsqQtaPotnMgmtVO[] csqQtaPotnMgmtVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaSetUpHeadOffice(CsqQtaPotnMgmtVO[] csqQtaPotnMgmtVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0021 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [confirm] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void confirmQtaSetUpHeadOffice(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0022 : [이벤트]<br>
	 * [QTA Set up by Head Office RHQ Distribute Result]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaRhqDistributeResultListVO>
	 * @throws EventException
	 */
	public List<SearchQtaRhqDistributeResultListVO> searchQtaRhqDistributeResultList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0023 : [이벤트]<br>
	 * [QTA Set up by Head Office RHQ QTA Summary]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaRhqQtaSummaryListVO>
	 * @throws EventException
	 */
	public List<SearchQtaRhqQtaSummaryListVO> searchQtaRhqQtaSummaryList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	 
	/**
	 * ESM_CSQ_0024 : [이벤트]<br>
	 * [QTA Set up by RHQ ]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaByRhqListVO>
	 * @throws EventException
	 */
	public List<SearchQtaByRhqListVO> searchQtaByRhqList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0024 : [이벤트]<br>
	 * [QTA Set up by RHQ]을 [업데이트] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param CsqQtaPotnMgmtVO[] csqQtaPotnMgmtVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaByRhq(ConditionVO conditionVO, CsqQtaPotnMgmtVO[] csqQtaPotnMgmtVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0024 : [이벤트]<br>
	 * [QTA Set up by RHQ]을 [confirm] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void confirmQtaByRhq(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0020 : [이벤트]<br>
	 * [CSQ_QTA_STEP_VER]의 특정STS를 [Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @param String sts
	 * @return int
	 * @throws EventException
	 */
	public int searchQtaVerStatusCnt(ConditionVO conditionVO, SignOnUserAccount account, String sts) throws EventException;
	
	/**
	 * ESM_CSQ_0025 : [이벤트]<br>
	 * [ QTA Set-up by RHQ (O/B Loading)_Office Distribute Result] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaByRhqResultVO>
	 * @throws EventException
	 */
	public List<SearchQtaByRhqResultVO> searchQtaByRhqResult(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0026 : [이벤트]<br>
	 * [QTA Set-up by RHQ (O/B Loading)_Office QTA Simulation]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaByRhqSimulationVO>
	 * @throws EventException
	 */
	public List<SearchQtaByRhqSimulationVO> searchQtaByRhqSimulation(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_CSQ_0213 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaLoadRevForSectorListVO>
	 * @throws EventException
	 */
	public List<SearchQtaLoadRevForSectorListVO> searchQtaLoadRevForSectorList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0213 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office] 테이블의 상태를 체크합니다<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @throws EventException
	 */
	public String searchQtaLoadRevForSectorListCnt(ConditionVO conditionVO) throws EventException ;
	
	/**
	 * ESM_CSQ_0213 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office]의 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaLoadRevForSector(ConditionVO conditionVO,  SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0213 : [Freezing]<br>
	 * [확정] 데이터를 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaFreezingForSector(ConditionVO conditionVO,  SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0213 : [1Q Transfer]<br>
	 * [1Q] 데이터를 [복사] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaTransferForSector(ConditionVO conditionVO,  SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0213 : [Save]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [저장] 합니다.<br>
	 * 
	 * @param CsqSctrLodRevVO[] csqSctrLodRevVO
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void updateQtaLoadRevForSector(CsqSctrLodRevVO[] csqSctrLodRevVO, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0214 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Creation] 테이블의 상태를 체크합니다<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaLoadRevForSectorAddListVO>
	 * @throws EventException
	 */
	public List<SearchQtaLoadRevForSectorAddListVO> searchQtaLoadRevForSectorAddCreationList(ConditionVO conditionVO) throws EventException ;

	/**
	 * ESM_CSQ_0214 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Creation]의 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SearchQtaLoadRevForSectorAddListVO[]  saveListVo 
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaLoadRevForSectorAddCreation(ConditionVO conditionVO,  SearchQtaLoadRevForSectorAddListVO[] saveListVo ,SignOnUserAccount account) throws EventException;

	/**
	 * ESM_CSQ_0215 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Freezing] 테이블의 상태를 체크합니다<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaLoadRevForSectorAddListVO>
	 * @throws EventException
	 */
	public List<SearchQtaLoadRevForSectorAddListVO> searchQtaLoadRevForSectorAddFreezingList(ConditionVO conditionVO) throws EventException ;

	/**
	 * ESM_CSQ_0215 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Freezing] : [확정데이터]를 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SearchQtaLoadRevForSectorAddListVO[]  saveListVo 
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaLoadRevForSectorAddFreezing(ConditionVO conditionVO,  SearchQtaLoadRevForSectorAddListVO[] saveListVo ,SignOnUserAccount account) throws EventException;

	/**
	 * ESM_CSQ_0216 : [Retrieve]<br>
	 * [QTA Set Up for IAS Sector by Head Office_Summary]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaSetupForIsaSecByHoSummaryVO>
	 * @throws EventException
	 */
	public List<SearchQtaSetupForIsaSecByHoSummaryVO> searchQtaSetupForIsaSecByHoSummary(ConditionVO conditionVO) throws EventException ;
}