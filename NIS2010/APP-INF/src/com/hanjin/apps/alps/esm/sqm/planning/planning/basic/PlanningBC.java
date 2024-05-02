/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : PlanningBC.java
*@FileTitle      : Planning
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.21
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.21 SQM USER
* 1.0 Creation
* 2015.09.17 김용습 [CHM-201537764] [CSR 전환건] QTA Set up by Head Office for IAS Sector 화면 내 Raw Data Export 버튼 신규 생성 
* 2015.09.22 김용습 [CHM-201537819] [CSR 전환건] QTA Set up by Head Office for IAS Sector 화면 내 Freezing, Add-Freezing 버튼 Validation 추가
* 2015.10.06 김용습 소스품질보완(메소드주석)
* 2016.01.28 최성민 [CHM-201639851] Basic Data Creation for IAS Secotr 화면의 Creation 로직 변경
* 2016.02.05 최성민 [CHM-201639787] SQM Planning 도중 & Planning 완료 후 노선, P/F Group, Sector 추가 로직 Process 변경
* 2016.07.04 최성민 [CHM-201642330] SQM 화면 버튼 추가 요청

=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaByRhqListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaByRhqResultVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaByRhqSimulationVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaLoadRevForSectorAddListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaLoadRevForSectorListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaLoadRevListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaRhqDistributeResultListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaRhqQtaSummaryListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaSetUpHeadOfficeListVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaSetupForIsaSecByHoSummaryVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchRbcLaneQtaListVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmQtaLodRevVO;
import com.hanjin.syscommon.common.table.SqmQtaPotnMgmtVO;
import com.hanjin.syscommon.common.table.SqmQtaRbcVO;
import com.hanjin.syscommon.common.table.SqmSctrLodRevVO;

/**
 * ALPS-Planning Business Logic Command Interface<br>
 * - ALPS-Planning 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
 * @see
 * @since J2EE 1.6
 */
public interface PlanningBC {
	
	/**
	 * ESM_SQM_0015 : [이벤트]<br>
	 * [RBC Lane QTA Setting]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchRbcLaneQtaListVO>
	 * @throws EventException
	 */
	public List<SearchRbcLaneQtaListVO> searchRbcLaneQtaList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0015 : [이벤트]<br>
	 * [RBC Lane QTA Setting]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @throws EventException
	 */
	public String searchRbcLaneQtaListCnt(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0015 : [이벤트]<br>
	 * [RBC Lane QTA Setting]의 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @exception EventException
	 */
	public void createRbcLaneQtaSetting(ConditionVO conditionVO, String usrId) throws EventException;
	
	/**
	 * ESM_SQM_0015 : [이벤트]<br>
	 * [RBC Lane QTA Setting]의 [저장] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmQtaRbcVO[] sqmQtaRbcVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageRbcLaneQtaSetting(ConditionVO conditionVO, SqmQtaRbcVO[] sqmQtaRbcVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0014 : [이벤트]<br>
	 * [QTA Set up by Head Office (L/F & G.RPB)]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaLoadRevListVO>
	 * @throws EventException
	 */
	public List<SearchQtaLoadRevListVO> searchQtaLoadRevList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0014 : [이벤트]<br>
	 * [QTA Set up by Head Office (L/F & G.RPB)]을 [업데이트] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmQtaLodRevVO[] sqmQtaLodRevVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaLoadRev(ConditionVO conditionVO, SqmQtaLodRevVO[] sqmQtaLodRevVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0014 : [이벤트]<br>
	 * [QTA Set up by Head Office (L/F & G.RPB)]을 [confirm] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void confirmQtaLoadRev(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0016 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaSetUpHeadOfficeListVO>
	 * @throws EventException
	 */
	public List<SearchQtaSetUpHeadOfficeListVO> searchQtaSetUpHeadOfficeList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0016 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [수정] 합니다.<br>
	 * 
	 * @param SqmQtaPotnMgmtVO[] sqmQtaPotnMgmtVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaSetUpHeadOffice(SqmQtaPotnMgmtVO[] sqmQtaPotnMgmtVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0016 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [confirm] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void confirmQtaSetUpHeadOffice(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0017 : [이벤트]<br>
	 * [QTA Set up by Head Office RHQ Distribute Result]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaRhqDistributeResultListVO>
	 * @throws EventException
	 */
	public List<SearchQtaRhqDistributeResultListVO> searchQtaRhqDistributeResultList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0018 : [이벤트]<br>
	 * [QTA Set up by Head Office RHQ QTA Summary]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaRhqQtaSummaryListVO>
	 * @throws EventException
	 */
	public List<SearchQtaRhqQtaSummaryListVO> searchQtaRhqQtaSummaryList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	 
	/**
	 * ESM_SQM_0019 : [이벤트]<br>
	 * [QTA Set up by RHQ ]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaByRhqListVO>
	 * @throws EventException
	 */
	public List<SearchQtaByRhqListVO> searchQtaByRhqList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	 
	/**
	 * ESM_SQM_0019 : [이벤트]<br>
	 * [Loading View Figure Copy ]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaByRhqListVO>
	 * @throws EventException
	 */
	public List<SearchQtaByRhqListVO> searchLoadingViewFigureList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * ESM_SQM_0019 : [이벤트]<br>
	 * [QTA Set up by RHQ]을 [업데이트] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmQtaPotnMgmtVO[] sqmQtaPotnMgmtVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaByRhq(ConditionVO conditionVO, SqmQtaPotnMgmtVO[] sqmQtaPotnMgmtVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0019 : [이벤트]<br>
	 * [QTA Set up by RHQ]을 [confirm] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void confirmQtaByRhq(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0014 : [이벤트]<br>
	 * [SQM_QTA_STEP_VER]의 특정STS를 [Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @param String sts
	 * @return int
	 * @throws EventException
	 */
	public int searchQtaVerStatusCnt(ConditionVO conditionVO, SignOnUserAccount account, String sts) throws EventException;
	
	/**
	 * ESM_SQM_0020 : [이벤트]<br>
	 * [ QTA Set-up by RHQ (O/B Loading)_Office Distribute Result] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaByRhqResultVO>
	 * @throws EventException
	 */
	public List<SearchQtaByRhqResultVO> searchQtaByRhqResult(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0021 : [이벤트]<br>
	 * [QTA Set-up by RHQ (O/B Loading)_Office QTA Simulation]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaByRhqSimulationVO>
	 * @throws EventException
	 */
	public List<SearchQtaByRhqSimulationVO> searchQtaByRhqSimulation(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_SQM_0213 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchQtaLoadRevForSectorListVO>
	 * @throws EventException
	 */
	public List<SearchQtaLoadRevForSectorListVO> searchQtaLoadRevForSectorList(ConditionVO conditionVO, String excelFlg) throws EventException;
	
	/**
	 * ESM_SQM_0213 : Raw Data Export 이벤트 처리<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchRawDataOfQtaLoadRevForSectorList(ConditionVO conditionVO, String excelFlg) throws EventException;
	
	/**
	 * ESM_SQM_0213 : Freezing 및 Add-Freezing 클릭시 발생<br>
	 * Freezing 및 Add-Freezing 시도시 Load가 0이 아닌데 G.RPB가 0인 데이터를 찾아냄
	 * 
	 * @param ConditionVO conditionVO
	 * @param String freezingFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchProblematicDataInFreezing(ConditionVO conditionVO, String freezingFlg) throws EventException;
	
	/**
	 * ESM_SQM_0213 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office] 테이블의 상태를 체크합니다<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @throws EventException
	 */
	public String searchQtaLoadRevForSectorListCnt(ConditionVO conditionVO) throws EventException ;
	
	/**
	 * ESM_SQM_0213 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office]의 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaLoadRevForSector(ConditionVO conditionVO,  SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0213 : [Freezing]<br>
	 * [확정] 데이터를 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaFreezingForSector(ConditionVO conditionVO,  SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0213 : [1Q Transfer]<br>
	 * [1Q] 데이터를 [복사] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaTransferForSector(ConditionVO conditionVO,  SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0213 : [Save]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [저장] 합니다.<br>
	 * 
	 * @param SqmSctrLodRevVO[] sqmSctrLodRevVO
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void updateQtaLoadRevForSector(SqmSctrLodRevVO[] sqmSctrLodRevVO, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0214 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Creation] 테이블의 상태를 체크합니다<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaLoadRevForSectorAddListVO>
	 * @throws EventException
	 */
	public List<SearchQtaLoadRevForSectorAddListVO> searchQtaLoadRevForSectorAddCreationList(ConditionVO conditionVO) throws EventException ;

	/**
	 * ESM_SQM_0214 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Creation]의 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SearchQtaLoadRevForSectorAddListVO[]  saveListVo 
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaLoadRevForSectorAddCreation(ConditionVO conditionVO,  SearchQtaLoadRevForSectorAddListVO[] saveListVo ,SignOnUserAccount account) throws EventException;

	/**
	 * ESM_SQM_0215 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Freezing] 테이블의 상태를 체크합니다<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaLoadRevForSectorAddListVO>
	 * @throws EventException
	 */
	public List<SearchQtaLoadRevForSectorAddListVO> searchQtaLoadRevForSectorAddFreezingList(ConditionVO conditionVO) throws EventException ;

	/**
	 * ESM_SQM_0215 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Freezing] : [확정데이터]를 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SearchQtaLoadRevForSectorAddListVO[]  saveListVo 
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createQtaLoadRevForSectorAddFreezing(ConditionVO conditionVO,  SearchQtaLoadRevForSectorAddListVO[] saveListVo ,SignOnUserAccount account) throws EventException;

	/**
	 * ESM_SQM_0216 : [Retrieve]<br>
	 * [QTA Set Up for IAS Sector by Head Office_Summary]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaSetupForIsaSecByHoSummaryVO>
	 * @throws EventException
	 */
	public List<SearchQtaSetupForIsaSecByHoSummaryVO> searchQtaSetupForIsaSecByHoSummary(ConditionVO conditionVO) throws EventException ;

	/**
	 * ESM_SQM_0222 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaLoadRevForSectorListVO>
	 * @throws EventException
	 */
	public List<SearchQtaLoadRevForSectorListVO> searchQtaLoadRevForAddSectorList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0222 : [Save]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [저장] 합니다.<br>
	 * 
	 * @param SqmSctrLodRevVO[] sqmSctrLodRevVO
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createQtaLoadRevForAddSector(SqmSctrLodRevVO[] sqmSctrLodRevVO, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
}