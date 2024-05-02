/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkCostBC.java
 *@FileTitle : Network Cost BC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-13
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-11-13 kimyoungchul
 * 1.0 최초 생성
 *=========================================================
 * History
 * 2009.04.01 김종열 CSR No.N200903170121  Port Tariff(PA)기능 변경  
 								        -조회(searchPortTariffList)와 생성(createPortTariff) 분리
 * 2009.09.30 김기대 0041 화면 New FrameWork 적용       
 * 2009.09.30 김기대 0042 화면 New FrameWork 적용
 * 2009.09.30 김기대 0043 화면 New FrameWork 적용
 * 2009.09.30 김기대 0029 화면 New FrameWork 적용
 * 2009.09.30 김기대 0039 화면 New FrameWork 적용
 * 2009.09.30 김기대 0110 화면 New FrameWork 적용
 * 2009.09.30  김기대 0114 화면 New FrameWork 적용    			
 * 2010.01.04  최인경 0174화면 ALPS 적용하여 새로 화면추가		
 * 2010.01.11 김기식 0175 화면 New FrameWork 적용
 * 2010.10.22 이행지 [CHM-201006375-01][MAS] Trunk IPC와 Ocean간 내부거래 신규 추가 
 * 2011.02.21 김상수 [CHM-201108827-01] * R.month/Week 및 OPR/OPR2 정보 보여주는 칼럼 추가
 *                                      * 불필요하게 사용된 VO에 관련된 소스제거
 * 2011.03.23 최성민 [CHM-201109616-01] * Bunker Fee (PA)화면에서 사용하는 MAS_BNK_TRF 테이블에 COST_WK 컬럼이 추가
 *                                     * Load Excel, Create 기능 추가
 * 2011.06.16 최성민 [CHM-201111497-01] MAS 운항일수 산정 로직 변경 - ESM_MAS_0034 생성
 * 2011.07.07 이석준 [CHM-201111498-01] PSO와 연계하여 VVD,TERMINAL별로 TARIFF 직접 수정및 PSO I/F 추가
 * 2011.12.23 최성민 [CHM-201114896-01] [MAS] CM2 추가 개발 요청
 * 2012.01.31 김종준 [CHM-201215754-01] SEL에서 대상항차 선택 후, VVD Send를 누르면 해당 대상항차를 FCM 시스템으로 전송 etc.
 * 2012.02.07 김종준 소스 품질 결과 - 사전 검토 결과 조치
 * 2012.07.05 이석준 [CHM-201218728-01] Dailyhire by Cht-VSL (PA) Create 기능 추가
 * 2013.05.08 성미영 [CHM-201324182] Daily Hire by Cht-VSL / AVG hire by Own VSL / SMU 단가 화면 전월 copy 기능 추가
 =========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.AverageUCVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.AverageUCVesselDetailVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.AverageUCVesselRegisterVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.AverageUCVesselUtDetailVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.AverageUCVesselUtVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.AverageUCVesselVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.AvgHireOwnVslVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.BunkerTariffCostVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.GNAExpAssignVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.GNAExpCreByOfcVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.GenExpStndCostVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.LaneTable1CycleVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.MASCreateMonitorVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.NetworkCostExceptionListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchAverageUCListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchAvgHireOwnVslDtrbListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchBunkerTariffListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchDailyHireListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchFixCostByVVDInterPrcListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchFixCostByVVDListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchFixCostByVVDOP4ListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchIntervalTransitTimeListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchMissingStatusListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchNWCreListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchNWCreRStatusListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchOtherVesselDailyHireListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffDetailListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffWeekListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchSltChtrCreListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchSltChtrCreRStatusListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasBnkTrfVO;
import com.hanjin.syscommon.common.table.MasGenExpnAsgnVO;
import com.hanjin.syscommon.common.table.MasInterPrcUtCostVO;
import com.hanjin.syscommon.common.table.MasMonVvdPortOpDysVO;
import com.hanjin.syscommon.common.table.MasNtwkCostCreVO;
import com.hanjin.syscommon.common.table.MasOpAvgUtCostVO;
import com.hanjin.syscommon.common.table.MasOwnVslDlyHirVO;
import com.hanjin.syscommon.common.table.MasSltChtrInfoVO;
import com.hanjin.syscommon.common.table.MasUtCostCreStsVO;

/**
 * eNIS-MAS Business Logic Command Interface<br>
 * - eNIS-MAS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kimyoungchul
 * @see ESM_MAS_042EventResponse 참조
 * @since J2EE 1.4
 */
public interface NetworkCostBC {

	/**
	 * ESM_MAS_0039 화면에 대한 조회 이벤트 처리
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchIntervalTransitTimeListVO>
	 * @exception EventException
	 */
	public List<SearchIntervalTransitTimeListVO> searchIntervalTransitTimeList(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_MAS_0039 화면에 대한 저장 이벤트 처리
	 * 
	 * @param MasMonVvdPortOpDysVO[] masMonVvdPortOpDysVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiIntervalTransitTime(MasMonVvdPortOpDysVO[] masMonVvdPortOpDysVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_MAS_0040 화면에 대한 조회 이벤트 처리
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchPortTariffListVO>
	 * @exception EventException
	 */
	public List<SearchPortTariffListVO> searchPortTariffList(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * ESM_MAS_0181 화면에 대한 조회 이벤트 처리
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchPortTariffDetailListVO>
	 * @exception EventException
	 */
	public List<SearchPortTariffDetailListVO> searchPortTariffDetailList(SearchConditionVO searchConditionVO) throws EventException;	
	
	/**
	 * ESM_MAS_0185 화면에 대한 조회 이벤트 처리
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchPortTariffWeekListVO>
	 * @exception EventException
	 */
	public List<SearchPortTariffWeekListVO> searchPortTariffWeekList(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * ESM_MAS_0185 화면에 대한 조회 이벤트 처리
	 * 
	 * @param SearchPortTariffWeekListVO searchPortTariffWeekListVO
	 * @return List<SearchPortTariffWeekListVO>
	 * @exception EventException
	 */
	public List<SearchPortTariffWeekListVO> searchPortTariffDistributeList(SearchPortTariffWeekListVO searchPortTariffWeekListVO) throws EventException;	

//	/**
//	 * ESM_MAS_0040 화면에 대한 생성 이벤트 처리
//	 * 
//	 * @param SearchPortTariffListVO[] searchPortTariffListVOs
//	 * @param SignOnUserAccount account
//	 * @return String
//	 * @throws EventException
//	 */
//	public String createPortTariff(SearchPortTariffListVO[] searchPortTariffListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_MAS_0040 화면에 대한 멀티 이벤트 처리
	 * 
	 * @param SearchConditionVO SearchConditionVO
	 * @param SearchPortTariffListVO[] searchPortTariffListVOs
	 * @param String userId
	 * @return EventResponse EventResponse
	 * @throws EventException
	 */
	public EventResponse multiPortTariff(SearchConditionVO SearchConditionVO, SearchPortTariffListVO[] searchPortTariffListVOs, String userId) throws EventException;
	
	/**
	 * ESM_MAS_0181 화면에 대한 멀티 이벤트 처리
	 * 
	 * @param SearchConditionVO SearchConditionVO
	 * @param SearchPortTariffDetailListVO[] searchPortTariffDetailListVOs
	 * @param String userId
	 * @return EventResponse EventResponse
	 * @throws EventException
	 */
	public EventResponse multiPortTariffDetail(SearchConditionVO SearchConditionVO, SearchPortTariffDetailListVO[] searchPortTariffDetailListVOs, String userId) throws EventException ;
	/**
	 * ESM_MAS_0041 화면에 대한 조회 이벤트를 처리
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchBunkerTariffListVO>
	 * @exception EventException
	 */
	public List<SearchBunkerTariffListVO> searchBunkerTariffList(SearchConditionVO searchConditionVO) throws EventException;

	/**
	 * Bunker Fee (PA) 엑셀 업로드시 데이터 존재 유무 확인한다.
	 * 
	 * @param MasBnkTrfVO[] masBnkTrfVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<MasBnkTrfVO>
	 * @exception EventException
	 */
	public List<MasBnkTrfVO> searchBunkerTariffCount(MasBnkTrfVO[] masBnkTrfVO, SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * ESM_MAS_0041 화면에 대한 저장 이벤트를 처리
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param MasBnkTrfVO[] vos
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiBunkerTariff(SearchConditionVO searchVo, NetworkCostCommonVO vo, MasBnkTrfVO[] vos, String userId) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @return List<SearchDailyHireListVO>
	 * @exception EventException
	 */
	public List<SearchDailyHireListVO> searchDailyHireList(SearchConditionVO searchVo, NetworkCostCommonVO vo) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_MAS_0042 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param NetworkCostCommonVO[] vos
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiDailyHire(SearchConditionVO searchVo, NetworkCostCommonVO vo, NetworkCostCommonVO[] vos, String userId) throws EventException;
	
	/**
	 * ESM_MAS_0043 화면에 대한 동적 해더정보를 조회<br>
	 * 
	 * @param  SearchConditionVO searchVo
	 * @param  NetworkCostCommonVO vo
	 * @return List<NetworkCostCommonVO>
	 * @throws EventException
	 */
	public List<NetworkCostCommonVO> searchOptFixedCostList(SearchConditionVO searchVo, NetworkCostCommonVO vo) throws EventException;

	/**
	 * ESM_MAS_0043 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @return NetworkCostCommonVO
	 * @exception EventException
	 */
	public NetworkCostCommonVO searchOwnDailyHireList(SearchConditionVO searchVo, NetworkCostCommonVO vo) throws EventException;

	/**
	 * ESM_MAS_0043 화면에 대한 저장 이벤트를 처리
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param MasOwnVslDlyHirVO[] vos
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOwnDailyHire(SearchConditionVO searchVo, NetworkCostCommonVO vo, MasOwnVslDlyHirVO[] vos, String userId) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchFixCostByVVDListVO>
	 * @exception EventException
	 */
	public List<SearchFixCostByVVDListVO> searchFixCostByVVDList(SearchConditionVO searchConditionVO) throws EventException;

	/**
	 * 초기화 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchNWCreListVO>
	 * @exception EventException
	 */
	public List<SearchNWCreListVO> searchNWCreList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * 결과 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchNWCreRStatusListVO>
	 * @exception EventException
	 */
	public List<SearchNWCreRStatusListVO> searchNWCreRStatusList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * 생성 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param MasNtwkCostCreVO[] masNtwkCostCreVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
     */
	public String createNWCreForVVD(SearchConditionVO searchConditionVO, MasNtwkCostCreVO[] masNtwkCostCreVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 초기화 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchSltChtrCreListVO>
	 * @exception EventException
	 */
	public List<SearchSltChtrCreListVO> searchSltChtrCreList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * 결과 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchSltChtrCreRStatusListVO>
	 * @exception EventException
	 */
	public List<SearchSltChtrCreRStatusListVO> searchSltChtrCreRStatusList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException ;

	
	/**
	 * 생성 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param MasSltChtrInfoVO[] masSltChtrInfoVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createSltChtrCre(SearchConditionVO searchConditionVO, MasSltChtrInfoVO[] masSltChtrInfoVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchMissingStatusListVO>
	 * @exception EventException
	 */
	public List<SearchMissingStatusListVO> searchMissingStatusList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Average U/C화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AverageUCVO averageUCVO
	 * @return List<AverageUCVO>
	 * @exception EventException
	 */
	public List<AverageUCVO> searchAverageUCList(AverageUCVO averageUCVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Average U/C화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AverageUCVO averageUCVO
	 * @return List<AverageUCVO>
	 * @exception EventException
	 */
	public List<AverageUCVO> searchAverageUCRawList(AverageUCVO averageUCVO) throws EventException;
	
	/**
	 * 생성 이벤트 처리<br>
	 * Average U/C화면에 대한 저장 이벤트 처리<br>
	 * 
	 * @param AverageUCVO[] masAverageUCVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiAverageUC(AverageUCVO[] masAverageUCVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 생성 이벤트 처리<br>
	 * Average UC단가를 생성한다.<br>
	 * 
	 * @param AverageUCVO averageUCVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createAverageUC(AverageUCVO averageUCVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 생성 이벤트 처리<br>
	 * Average UC 월단가를 복사해서 생성한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createAverageMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @return List<SearchFixCostByVVDOP4ListVO>
	 * @exception EventException
	 */
	public List<SearchFixCostByVVDOP4ListVO> searchFixCostByVVDOP4List(SearchConditionVO searchVo) throws EventException;
	
	/**
	 * [Lane Table (1Cycle)]을 [조회] 합니다.<br>
	 * @param LaneTable1CycleVO laneTable1CycleVO
	 * 
	 * @return List<LaneTable1CycleVO>
	 * @exception EventException
	 */
	public List<LaneTable1CycleVO> searchLaneDetailList(LaneTable1CycleVO laneTable1CycleVO) throws EventException;
	
	/**
	 * [Lane Detail]을 [수정] 합니다.<br>
	 * 
	 * @param LaneTable1CycleVO[] laneTable1CycleVOs
	 * @param LaneTable1CycleVO laneTable1CycleVO
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiLaneDetail(LaneTable1CycleVO[] laneTable1CycleVOs, LaneTable1CycleVO laneTable1CycleVO, SignOnUserAccount account) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<MasInterPrcUtCostVO>
	 * @exception EventException
	 */
	public List<MasInterPrcUtCostVO> searchTrunkIPCPricing(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * [Trunk IPC Internal Pricing]을 [수정] 합니다.<br>
	 * 
	 * @param MasInterPrcUtCostVO[] MasInterPrcUtCostVOs
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTrunkIPCPricing(MasInterPrcUtCostVO[] MasInterPrcUtCostVOs, SignOnUserAccount account) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchFixCostByVVDInterPrcListVO>
	 * @exception EventException
	 */
	public List<SearchFixCostByVVDInterPrcListVO> searchFixCostByVVDInterPrcList(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createFixCostByVVDInterPrc(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [Bunker Fee 정보]을 [CREATE] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createBunkerTariff(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Average UC 월단가를 복사해서 생성한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createBSACommitmentMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_MAS_0034 화면에 대한 조회 이벤트 처리
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchIntervalTransitTimeListVO>
	 * @exception EventException
	 */
	public List<SearchIntervalTransitTimeListVO> searchLaneTransitTimeList(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_MAS_0034 화면에 대한 저장 이벤트 처리
	 * 
	 * @param MasMonVvdPortOpDysVO[] masMonVvdPortOpDysVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiLaneTransitTime(MasMonVvdPortOpDysVO[] masMonVvdPortOpDysVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Average U/C화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchAverageUCListVO>
	 * @exception EventException
	 */
	public List<SearchAverageUCListVO> searchAverageCM2List(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * Average U/C화면에 대한 저장 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param MasOpAvgUtCostVO[] masOpAvgUtCostVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiAverageCM2(SearchConditionVO searchConditionVO, MasOpAvgUtCostVO[] masOpAvgUtCostVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Average UC단가를 생성한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createAverageCM2(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * DailyHire 단가를 생성한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createDailyHire(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * Daily Hire by Cht-VSL 전월 단가를 copy 한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createDailyHireMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;	

	/**
	 * AVG hire by Own VSL 전월 단가를 copy 한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createOwnDailyHireMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String object
	 * @return String
	 * @exception EventException
	 */
	public String searchBackEndJobStatus(String object) throws EventException;

	/**
	 * [Lane Table]을 [복사] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createLaneTableMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account)  throws EventException;
	

	/**
	 * [Average U/C Status]을 [조회] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<MasUtCostCreStsVO>
	 * @exception EventException
	 */
	public List<MasUtCostCreStsVO> searchAverageUCStatus(SearchConditionVO searchConditionVO)  throws EventException;
	
	/**
	 * Port Tariff Create 시 기존에 존재하는 항차를 삭제한다.<br>
	 * @param SearchPortTariffListVO[] listVos
	 * @exception EventException
	 */
	public void deletePortTariff(SearchPortTariffListVO[] listVos) throws EventException;
	
	/**
	 * AVG-hire by Own-VSL (PA).<br>
	 * ESM_MAS_0043 화면 조회
	 * @param AvgHireOwnVslVO avgHireOwnVslVO
	 * @return List<AvgHireOwnVslVO>
	 * @exception EventException
	 */
	public List<AvgHireOwnVslVO> searchAvgHireOwnVslMainList(AvgHireOwnVslVO avgHireOwnVslVO) throws EventException;
	 
	/**
	 * AVG-hire by Own-VSL (PA).<br>
	 * ESM_MAS_0043 화면 추가저장, 수정, 삭제
	 * @param AvgHireOwnVslVO[] avgHireOwnVslVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiAvgHireOwnVslMainList(AvgHireOwnVslVO[] avgHireOwnVslVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * AVG-hire by Own-VSL (PA) 비용 생성<br>
	 * @param AvgHireOwnVslVO avgHireOwnVslVO
	 * @return 
	 * @exception EventException
	 */
	public String createAvgHireOwnVslMain(AvgHireOwnVslVO avgHireOwnVslVO, SignOnUserAccount account) throws EventException;
		
	/**
	 * MAS 사선고정비 메뉴얼 비용 수정
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchAvgHireOwnVslDtrbListVO>
	 * @exception EventException
	 */
	public List<SearchAvgHireOwnVslDtrbListVO> searchAvgHireOwnVslDtrbList(SearchConditionVO searchConditionVO)  throws EventException;
	
	/**
	 * MAS 사선고정비 메뉴얼 비용 수정<br>
	 * @param SearchAvgHireOwnVslDtrbListVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public String multiAvgHireOwnVslDtrb(SearchAvgHireOwnVslDtrbListVO[] listVos, SignOnUserAccount account) throws EventException;
	
	/**
	 * MAS 사선고정비 메뉴얼 비용 생성<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @exception EventException
	 */
	public String createAvgHireOwnVslDtrb(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_MAS_0042 용선료 Other 항목 배부
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchOtherVesselDailyHireListVO>
	 * @exception EventException
	 */
	public List<SearchOtherVesselDailyHireListVO> searchOtherVesselDailyHireList(SearchConditionVO searchConditionVO)  throws EventException;
	
	/**
	 * ESM_MAS_0042 용선료 Other 항목 배부 - Save<br>
	 * @param SearchOtherVesselDailyHireListVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiOtherVesselDailyHire(SearchOtherVesselDailyHireListVO[] listVos, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_MAS_0042 용선료 Other 항목 배부 - Create<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createOtherVesselDailyHire(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 생성 이벤트 처리<br>
	 * Port Tariff Modification 화면 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SearchPortTariffWeekListVO[] searchPortTariffWeekListVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
     */
	public String multiPortTariffByVvd(SearchConditionVO searchConditionVO, SearchPortTariffWeekListVO[] searchPortTariffWeekListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [MAS_STND_USE_QTY Table]을 [복사] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createStndUseQtyMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account)  throws EventException ;
	
	/**
	 * General Expense Pre OP Cost.<br>
	 * ESM_MAS_0327 화면 조회
	 * @param GenExpStndCostVO genExpStndCostVO
	 * @return List<GenExpStndCostVO>
	 * @exception EventException
	 */
	public List<GenExpStndCostVO> searchGenExpStndCostMainList(GenExpStndCostVO genExpStndCostVO) throws EventException;
	
	/**
	 * General Expense Pre OP Cost<br>
	 * ESM_MAS_0327 비용 생성
	 * @param GenExpStndCostVO genExpStndCostVO
	 * @return 
	 * @exception EventException
	 */
	public String createGenExpStndCostMainList(GenExpStndCostVO genExpStndCostVO, SignOnUserAccount account) throws EventException;
		
	/**
	 * General Expense Cost Modification.<br>
	 * ESM_MAS_0328 화면 조회
	 * @param GenExpStndCostVO genExpStndCostVO
	 * @return List<GenExpStndCostVO>
	 * @exception EventException
	 */
	public List<GenExpStndCostVO> searchGenExpStndCostDodPop(GenExpStndCostVO genExpStndCostVO) throws EventException;
	
	/**
	 * General Expense Cost Modification.<br>
	 * ESM_MAS_0328 화면 수정 저장
	 * @param GenExpStndCostVO[] genExpStndCostVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiGenExpStndCostDodPop(GenExpStndCostVO[] genExpStndCostVOs, SignOnUserAccount account) throws EventException;
		
	/**
	 * General Expense Cost Modification<br>
	 * ESM_MAS_0328 비용 생성
	 * @param GenExpStndCostVO genExpStndCostVO
	 * @return 
	 * @exception EventException
	 */
	public String createGenExpStndCostDodPop(GenExpStndCostVO genExpStndCostVO, SignOnUserAccount account) throws EventException;
		
	/**
	 * General Expense Lane Check.<br>
	 * ESM_MAS_0329 화면 조회
	 * @param GenExpStndCostVO genExpStndCostVO
	 * @return List<GenExpStndCostVO>
	 * @exception EventException
	 */
	public List<GenExpStndCostVO> searchGenExpStndCostLanePop(GenExpStndCostVO genExpStndCostVO) throws EventException;

	/**
	 * ESM_MAS_0321 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<BunkerTariffCostVO>
	 * @exception EventException
	 */
	public List<BunkerTariffCostVO> searchBunkerTariffCostList(SearchConditionVO searchConditionVO ) throws EventException;
	
	/**
	 * ESM_MAS_0321 - Save<br>
	 * @param BunkerTariffCostVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiBunkerTariffCost(BunkerTariffCostVO[] listVos, SignOnUserAccount account) throws EventException ;

	

	/**
	 * ESM_MAS_0330 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<AverageUCVesselVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselVO> searchAverageUCVesselList(SearchConditionVO searchConditionVO) throws EventException;

	/**
	 * ESM_MAS_0330 조회<br>
	 * sheetObjects[10] -> Total 탭의 결과조회
	 * @param AverageUCVesselVO averageUCVesselVO
	 * @return List<AverageUCVesselVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselVO> searchAverageUCVesselListTotal(AverageUCVesselVO averageUCVesselVO) throws EventException;

	/**
	 * ESM_MAS_0330 Class 콤보 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<AverageUCVesselVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselVO> searchAverageUCVesselClassList(SearchConditionVO searchConditionVO) throws EventException;	
	
	/**
	 * ESM_MAS_0330 Vessel 콤보 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<AverageUCVesselVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselVO> searchAverageUCVesselCombo(SearchConditionVO searchConditionVO) throws EventException;	
	
	/**
	 * ESM_MAS_0330 - Save<br>
	 * @param AverageUCVesselVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiAverageUCVessel(AverageUCVesselVO[] listVos, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_MAS_0330 - Month Copy<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createAverageUCVesselMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account)  throws EventException;
	
	/**
	 * ESM_MAS_0331 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<AverageUCVesselRegisterVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselRegisterVO> searchAverageUCVesselRegisterList(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * ESM_MAS_0331 - Save<br>
	 * @param AverageUCVesselRegisterVO[] listVos
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiAverageUCVesselRegister(AverageUCVesselRegisterVO[] listVos, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_MAS_0331 - Month Copy<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createAverageUCVesselRegisterMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account)  throws EventException;
	
	/**
	 * ESM_MAS_0332 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<AverageUCVesselDetailVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselDetailVO> searchAverageUCVesselDetailList(SearchConditionVO searchConditionVO ) throws EventException;
	
	/**
	 * ESM_MAS_0332 - Save<br>
	 * @param AverageUCVesselDetailVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiAverageUCVesselDetail(AverageUCVesselDetailVO[] listVos, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_MAS_0332 - Create<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String createAverageUCVesselDetail(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * ESM_MAS_0333 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<AverageUCVesselUtVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselUtVO> searchlAverageUCVesselUtList(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * ESM_MAS_0333 조회<br>
	 * Cost Total 탭 조회
	 * @param AverageUCVesselUtVO averageUCVesselUtVO
	 * @return List<AverageUCVesselUtVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselUtVO> searchlAverageUCVesselUtListTotal(AverageUCVesselUtVO averageUCVesselUtVO) throws EventException;
		
	/**
	 * ESM_MAS_0333 - Save<br>
	 * @param AverageUCVesselUtVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiAverageUCVesselUt(AverageUCVesselUtVO[] listVos, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_MAS_0333 - Create<br>
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createAverageUCVesselUt(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_MAS_0333 - Month Copy<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createAverageUCVesselUtMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException ;

	/**
	 * ESM_MAS_0335 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<AverageUCVesselUtDetailVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselUtDetailVO> searchlAverageUCVesselUtDetailList(SearchConditionVO searchConditionVO ) throws EventException;
	
	/**
	 * ESM_MAS_0335 - Save<br>
	 * @param AverageUCVesselUtDetailVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiAverageUCVesselUtDetail(AverageUCVesselUtDetailVO[] listVos, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_MAS_0335 - Create<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String createAverageUCVesselUtDetail(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * ESM_MAS_0190 조회<br>
	 * @param NetworkCostExceptionListVO networkCostExceptionListVO
	 * @return List<NetworkCostExceptionListVO>
	 * @exception EventException
	 */
	public List<NetworkCostExceptionListVO> searchNetworkCostExceptionList(NetworkCostExceptionListVO networkCostExceptionListVO) throws EventException;
	
	/**
	 * ESM_MAS_0190 - Save-insert,update<br>
	 * @param NetworkCostExceptionListVO[] listVos
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public void multiNetworkCostExceptionList(NetworkCostExceptionListVO[] listVos, SignOnUserAccount account) throws EventException ;
	
	/**
	 * ESM_MAS_0190 - Save-delete<br>
	 * @param NetworkCostExceptionListVO[] listVos
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public void multidelNetworkCostExceptionList(NetworkCostExceptionListVO[] listVos, SignOnUserAccount account) throws EventException ;
	
	/**
	 * ESM_MAS_0190
	 * @param NetworkCostExceptionListVO networkCostExceptionListVO
	 * @return List<NetworkCostExceptionListVO>
	 * @throws EventException
	 */
	public List<NetworkCostExceptionListVO> searchComBoCdListCdNm0190(NetworkCostExceptionListVO networkCostExceptionListVO) throws EventException;

	/**
	 * ESM_MAS_0191 조회<br>
	 * @param MASCreateMonitorVO mASCreateMonitorVO
	 * @return List<MASCreateMonitorVO>
	 * @exception EventException
	 */
	public List<MASCreateMonitorVO> searchMASCreateMonitor(MASCreateMonitorVO mASCreateMonitorVO) throws EventException;

	
    /**
     * ESM_MAS_0336 조회<br>
     * @param SearchConditionVO searchConditionVO
     * @return List<GNAExpCreByOfcVO>
     * @exception EventException
     */
    public List<GNAExpCreByOfcVO> searchGNAExpCreByOfcList(SearchConditionVO searchConditionVO) throws EventException ;
    
    /**
     * ESM_MAS_0336 - Creation <br>
     * @param SearchConditionVO searchConditionVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public EventResponse createGNAExpCreByOfc(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException ; 
    
    /**
     * ESM_MAS_0336 G&A Expense Creation by Office - Save<br>
     * @param GNAExpCreByOfcVO[] listVos
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void multiGNAExpCreByOfc(GNAExpCreByOfcVO[] listVos, SignOnUserAccount account) throws EventException ;  
    
    
    /**
     * ESM_MAS_0337 조회<br>
     * @param SearchConditionVO searchConditionVO
     * @return List<GNAExpCreByOfcVO>
     * @exception EventException
     */
    public List<GNAExpAssignVO> searchGNAExpAssignList(SearchConditionVO searchConditionVO) throws EventException ;
    
    /**
     * ESM_MAS_0337 - Creation <br>
     * @param SearchConditionVO searchConditionVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public EventResponse createGNAExpAssign(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException ; 
    
    /**
     * ESM_MAS_0337 - Save <br>
     * @param MasGenExpnAsgnVO masGenExpnAsgnVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageGNAExpAssign(MasGenExpnAsgnVO[] masGenExpnAsgnVOs, SignOnUserAccount account) throws EventException ; 
        
    
}