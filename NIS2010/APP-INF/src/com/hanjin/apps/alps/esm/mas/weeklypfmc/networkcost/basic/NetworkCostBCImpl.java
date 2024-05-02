/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkCostBCImpl.java
 *@FileTitle : Network Cost BC Impl
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
 * 2009.09.30 김기대 0114 화면 New FrameWork 적용
 * 2009.11.05 박은주CHM-200901483 OP4 산출을 위한 평균단가 생성 로직 변경
 * 2009.11.05 최인경 CHM-200901484 Split 01-OP4 산출을 위한 평균단가 생성 로직 변경
 * 2010.01.04  최인경 0174   화면 ALPS 적용하여 새로 화면추가
 * 2010.01.05 박은주  대상항차 프로시저 변경으로 소스 수정
 * 2010.01.11 김기식 0175 화면 New FrameWork 적용
 * 2010.02.05 임옥영 품질검토 결과 반영 (변수 이름은 소문자로 시작한다.dbDao_ntAll->dbDaoNtAll)
 * 2010.05.06 이행지 CHM-201003663-Port tariff vessel class 변경
 * 2010.10.22 이행지 [CHM-201006375-01][MAS] Trunk IPC와 Ocean간 내부거래 신규 추가
 * 2011.02.21 김상수 [CHM-201108827-01] * R.month/Week 및 OPR/OPR2 정보 보여주는 칼럼 추가
 *                                      * 불필요하게 사용된 VO에 관련된 소스제거
 * 2011.03.23 최성민 [CHM-201109616-01]  * Bunker Fee (PA)화면에서 사용하는 MAS_BNK_TRF 테이블에 COST_WK 컬럼이 추가
 *                                     * Load Excel, Create 기능 추가
 * 2011.06.16 최성민 [CHM-201111497-01] MAS 운항일수 산정 로직 변경 - ESM_MAS_0034 생성
 * 2011.07.07 이석준 [CHM-201111498-01] PSO와 연계하여 VVD,TERMINAL별로 TARIFF 직접 수정및 PSO I/F 추가
 * 2011.12.23 최성민 [CHM-201114896-01] [MAS] CM2 추가 개발 요청
 * 2012.01.31 김종준 [CHM-201215754-01] SEL에서 대상항차 선택 후, VVD Send를 누르면 해당 대상항차를 FCM 시스템으로 전송 etc.
 * 2012.02.07 김종준 소스 품질 결과 - 사전 검토 결과 조치
 * 2012.07.05 이석준 [CHM-201218728-01] Dailyhire by Cht-VSL (PA) Create 기능 추가
 * 2012.08.14 이석준 [CHM-201219592-01] AVG-hire by Own-VSL (PA) 화면에 Load excel 기능 추가
 * 2013.05.08 성미영 [CHM-201324182] Daily Hire by Cht-VSL / AVG hire by Own VSL / SMU 단가 화면 전월 copy 기능 추가 
 * 2013.06.26 박찬민 [CHM-201325163] [MAS] Network Cost by VVD - Network Cost 탭 Creation 관련 CSR
 * 2015.07.13 손진환 [CHM-201536797] ALPS MAS의 Pooling 화면 Row Add & Save 버튼 추가 CSR
* 2015.09.15 김성욱, 소스 보안 품질 작업
 =========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.Utils;
import com.hanjin.apps.alps.esm.mas.common.vo.ProcedureParamVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration.NetworkCostDBDAO;
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
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchDailyHire2MonthCountVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchDailyHireListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchFixCostByVVDInterPrcListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchFixCostByVVDListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchFixCostByVVDOP4ListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchIntervalTransitTimeListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchMissingStatusListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchNWCreListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchNWCreRStatusListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchOptFixedCostListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchOtherVesselDailyHireListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffDetailListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffWeekListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchSltChtrCreListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchSltChtrCreRStatusListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration.WeeklyCMDBDAO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasBnkTrfVO;
import com.hanjin.syscommon.common.table.MasGenExpnAsgnVO;
import com.hanjin.syscommon.common.table.MasInterPrcUtCostVO;
import com.hanjin.syscommon.common.table.MasLaneTsBsaCmmtVO;
import com.hanjin.syscommon.common.table.MasMonVvdPortOpDysVO;
import com.hanjin.syscommon.common.table.MasNtwkCostCreVO;
import com.hanjin.syscommon.common.table.MasOpAvgUtCostVO;
import com.hanjin.syscommon.common.table.MasOwnVslDlyHirVO;
import com.hanjin.syscommon.common.table.MasSltChtrInfoVO;
import com.hanjin.syscommon.common.table.MasUtCostCreStsVO;

/**
 * eNIS-MAS Business Logic Basic Command implementation<br>
 * - eNIS-MAS에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author kimyoungchul
 * @see NetworkCostBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class NetworkCostBCImpl extends BasicCommandSupport implements NetworkCostBC {

	// Database Access Object
	private transient NetworkCostDBDAO dbDao = null;
	private transient WeeklyCMDBDAO dbDaoNtAll = null;	//Nt cost All Procedure사용을 위해 BY LHI 2007.07.18


	/**
	 * NetworkCostBCImpl 객체 생성<br>
	 * NetworkCostDBDAO를 생성한다.<br>
	 */
	public NetworkCostBCImpl() {
		dbDao = new NetworkCostDBDAO();
		dbDaoNtAll = new WeeklyCMDBDAO();
	}



	/**
	 * 1. 기능 : 구간별 운항일수 및 비율생성 화면에 대한 조회 이벤트 처리(ESM_MAS_039)<p>
	 * 2. 처리개요 : <p>
	 *    - 구간별 운항일수 및 비율생성에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.11.14<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchIntervalTransitTimeListVO>
	 * @exception EventException
	 */
    public List<SearchIntervalTransitTimeListVO> searchIntervalTransitTimeList(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
        try {
            return dbDao.searchIntervalTransitTimeList(searchConditionVO);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }

	/**
	 * 1. 기능 : 구간별 운항일수 및 비율생성 화면에 대한 저장 이벤트 처리(ESM_MAS_039)<p>
	 * 2. 처리개요 : <p>
	 *    - 구간별 운항일수 및 비율생성에 대한 리스트를 저장
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2007.04.27<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 *
	 * @param MasMonVvdPortOpDysVO[] masMonVvdPortOpDysVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse multiIntervalTransitTime(MasMonVvdPortOpDysVO[] masMonVvdPortOpDysVOs, SignOnUserAccount account) throws EventException{
        try{
            List<MasMonVvdPortOpDysVO> multiList        = new ArrayList<MasMonVvdPortOpDysVO>();

            if(masMonVvdPortOpDysVOs.length > 0){
                for(int i = 0 ; i < masMonVvdPortOpDysVOs.length ; i++){
                	masMonVvdPortOpDysVOs[i].setUpdUsrId(account.getUse_flg());

                	multiList.add(masMonVvdPortOpDysVOs[i]);
                }
            }

            dbDao.multiIntervalTransitTime(multiList);

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }

	/**
	 * 1. 기능 : Port Class별 Tariff 조회/변경 화면에 대한 조회 이벤트 처리(ESM_MAS_040)<p>
	 * 2. 처리개요 : <p>
	 *    - Port Class별 Tariff 조회/변경에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.11.16<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p> Kim Ki Dae / 2009.08.27
	 * - 수정사유/내역 :<p> ALPS 변환
	 * ===================================<br>
	 * <p/>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchPortTariffListVO>
	 * @exception EventException
	 */
	public List<SearchPortTariffListVO> searchPortTariffList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			String[] arrSearch = searchConditionVO.getFYearweek().split("[-]");
			String yrType = searchConditionVO.getFYrtype();
			String year = arrSearch[0];
			String cost_wk	= "";
			String cost_mon	= "";

			if( yrType.equals("W")) cost_wk = arrSearch[1];
			if( yrType.equals("M")) cost_mon = arrSearch[1];

			searchConditionVO.setFYear(year);
			searchConditionVO.setFFmWk(cost_wk);
			searchConditionVO.setFFmMon(cost_mon);

			return dbDao.searchPortTariffList(searchConditionVO);
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * 1. 기능 : Port Tariff 조회/변경 화면에 대한 조회 이벤트 처리(ESM_MAS_0181)<p>
	 * 2. 처리개요 : <p>
	 *    - Port Tariff 조회/변경에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : 이석준/2011.07.06<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * ===================================<br>
	 * <p/>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchPortTariffDetailListVO>
	 * @exception EventException
	 */
	public List<SearchPortTariffDetailListVO> searchPortTariffDetailList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchPortTariffDetailList(searchConditionVO);
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * 1. 기능 : Port Class별 Tariff 조회/변경 화면에 대한 멀티 이벤트 처리(ESM_MAS_040)<p>
	 * 2. 처리개요 : <p>
	 *    - Port Class별 Tariff 조회/변경에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.11.16<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p> 
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 *
	 * @param SearchConditionVO SearchConditionVO
	 * @param SearchPortTariffListVO[] searchPortTariffListVOs
	 * @param String userId
	 * @return EventResponse EventResponse
	 * @throws EventException
	 */
	public EventResponse multiPortTariff(SearchConditionVO SearchConditionVO, SearchPortTariffListVO[] searchPortTariffListVOs, String userId) throws EventException{
		try{
//			List<SearchPortTariffListVO> createList	= new ArrayList<SearchPortTariffListVO>();
			List<SearchPortTariffListVO> updateList	= new ArrayList<SearchPortTariffListVO>();
//			List<SearchPortTariffListVO> deleteList	= new ArrayList<SearchPortTariffListVO>();

            if(searchPortTariffListVOs.length > 0){
                for(int i = 0 ; i < searchPortTariffListVOs.length ; i++){
                	
                	if ("N".equals(searchPortTariffListVOs[i].getCostSts())) continue; //MAS에도 없고, PSO에도 create되지 않은 경우는 저장하지 않는다.
                	if ("0".equals(searchPortTariffListVOs[i].getChkFlag())) continue; //CHECK하지 않은것도 그냥 SKIP
                	if ("0".equals(searchPortTariffListVOs[i].getPsoCostPsoTtlAmt())) continue; //PSO에
                	
//                    if(searchPortTariffListVOs[i].getIbflag().equals("I"))
//                        createList.add(searchPortTariffListVOs[i]);
                	searchPortTariffListVOs[i].setUserId(userId);
                     if(searchPortTariffListVOs[i].getIbflag().equals("U"))
                        updateList.add(searchPortTariffListVOs[i]);
//                    else if(searchPortTariffListVOs[i].getIbflag().equals("D"))
//                    	deleteList.add(searchPortTariffListVOs[i]);
                }
            }

//            if( createList.size() > 0 )
//            	dbDao.addPortTariff(createList);
            if( updateList.size() > 0 )
                dbDao.modifyPortTariff(updateList);
//            if( deleteList.size() > 0 )
//            	dbDao.deletePortTariff(deleteList);

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        }
		catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}

	/**
	 * 1. 기능 : Port Class별 Tariff 조회/변경 화면에 대한 멀티 이벤트 처리(ESM_MAS_040)<p>
	 * 2. 처리개요 : <p>
	 *    - Port Class별 Tariff 조회/변경에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.11.16<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 *
	 * @param SearchConditionVO SearchConditionVO
	 * @param SearchPortTariffDetailListVO[] searchPortTariffDetailListVOs
	 * @param String userId
	 * @return EventResponse EventResponse
	 * @throws EventException
	 */
	public EventResponse multiPortTariffDetail(SearchConditionVO SearchConditionVO, SearchPortTariffDetailListVO[] searchPortTariffDetailListVOs, String userId) throws EventException{
		try{ 
			List<SearchPortTariffDetailListVO> updateList	= new ArrayList<SearchPortTariffDetailListVO>();

			boolean save_ind=true; // 화면에서 넘어온 데이터중 MAS쪽 Data의 합이 0인 포트가 하나라고 있으면 SAVE 불가능
			Double port_amt;
			Double canal_amt;
            if(searchPortTariffDetailListVOs.length > 0){            	
                for(int i = 0 ; i < searchPortTariffDetailListVOs.length ; i++){
                	port_amt = Double.parseDouble(JSPUtil.getNull(searchPortTariffDetailListVOs[i].getPortUsdAmt(), "0.0"));
                	canal_amt = Double.parseDouble(JSPUtil.getNull(searchPortTariffDetailListVOs[i].getCnlUsdAmt(), "0.0"));
                	
                	if ((port_amt + canal_amt) == 0.0){
                		save_ind = false;
                		break;
                	}                	
                	searchPortTariffDetailListVOs[i].setCreUsrId(userId);
                	searchPortTariffDetailListVOs[i].setUpdUsrId(userId);                	
                    if(searchPortTariffDetailListVOs[i].getIbflag().equals("U"))
                        updateList.add(searchPortTariffDetailListVOs[i]);
                }
            }

            if( updateList.size() > 0 && save_ind) {
                dbDao.modifyPortTariffDetail(updateList);
            }
            
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        }
		catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}	
	/**
	 * 1. 기능 : 연료비 조회/변경 화면에 대한 조회 이벤트 처리(ESM_MAS_041)<p>
	 * 2. 처리개요 : <p>
	 *    - 연료비 조회/변경에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.11.22<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchBunkerTariffListVO>
	 * @exception EventException
	 */
	public List<SearchBunkerTariffListVO> searchBunkerTariffList(SearchConditionVO searchConditionVO) throws EventException {
		try {
	        String[] arrSearch = searchConditionVO.getFYearweek().split("[-]");
			String cost_yrmon = arrSearch[0]+arrSearch[1];
			searchConditionVO.setFCostYrmon(cost_yrmon);
			return dbDao.searchBunkerTariffList(searchConditionVO);
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Bunker Fee (PA) 엑셀 업로드시 데이터 존재 유무 확인한다.
	 * 
	 * @param MasBnkTrfVO[] masBnkTrfVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<MasBnkTrfVO>
	 * @exception EventException
	 */
	public List<MasBnkTrfVO> searchBunkerTariffCount(MasBnkTrfVO[] masBnkTrfVO, SearchConditionVO searchConditionVO) throws EventException{
		
		try {
			List<MasBnkTrfVO> list = new ArrayList<MasBnkTrfVO>();
			MasBnkTrfVO vo = null;
			MasBnkTrfVO rowVo = null;

			//Row 별 조회
			for ( int i=0; i<masBnkTrfVO.length; i++ ) {				
				vo = dbDao.searchBunkerTariffCount(masBnkTrfVO[i], searchConditionVO);
				
				if (vo == null) {
					rowVo = new MasBnkTrfVO();
					rowVo.setCostYrmon(String.valueOf(i));// Row index
					list.add(rowVo);
             	}
			}
			return list;			
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * 1. 기능 : 연료비 조회/변경 화면에 대한 멀티 이벤트 처리(ESM_MAS_041)<p>
	 * 2. 처리개요 : <p>
	 *    - 연료비 조회/변경에 대한 멀티처리
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.11.22<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 *
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param MasBnkTrfVO[] vos
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse multiBunkerTariff(SearchConditionVO searchVo, NetworkCostCommonVO vo, MasBnkTrfVO[] vos, String userId) throws EventException{
		try{
			List saveList = new ArrayList();
			//
			//----------------------------------------------------
            if(vos.length > 0){
                for(int i = 0 ; i < vos.length ; i++){
                    //query parameter
                    HashMap<String, String> param = vos[i].getColumnValues();
                    param.put("user_id"   , userId);
                    param.put("cre_usr_id", userId);
                    param.put("upd_usr_id", userId);
                    if(vos[i].getIbflag().equals("I") || vos[i].getIbflag().equals("U")) {
                    	param.put("cost_yrmon"		, vos[i].getCostYrmon());
                    //	param.put("cost_wk"			, vos[i].getc);
                    	param.put("slan_cd"			, vos[i].getSlanCd());
                    	param.put("rlane_cd"		, vos[i].getRlaneCd());
                    	param.put("slan_dir_cd"		, vos[i].getSlanDirCd());
                    	param.put("vsl_clss_capa"	, vos[i].getVslClssCapa());
                    	param.put("foil_csm"		, vos[i].getFoilCsm());
                    	param.put("foil_uc_amt"		, vos[i].getFoilUcAmt());
                    	param.put("doil_csm"		, vos[i].getDoilCsm());
                    	param.put("doil_uc_amt"		, vos[i].getDoilUcAmt());
                    	param.put("trd_cd"		    , vos[i].getTrdCd());
                    	param.put("sub_trd_cd"		, vos[i].getSubTrdCd());
                    	param.put("foil_avg_csm"	, vos[i].getFoilAvgCsm());
                    	
                    	saveList.add(param);
                    }
                }
            }
            vo.setMultiSaveList(saveList);

			//[DB 실행]
			dbDao.multiBunkerTariff(vo);
			//############################################################################

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}

	/**
	 * 1. 기능 : Header 정보를 조회한다.(ESM_MAS_043)<p>
	 * 2. 처리개요 : <p>
	 *    - 시선 일당 고정비 관리에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2007.01.16<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 *
	 * @param  SearchConditionVO searchVo
	 * @param  NetworkCostCommonVO vo
	 * @return List<NetworkCostCommonVO>
	 * @throws EventException
	 */
	public List<NetworkCostCommonVO> searchOptFixedCostList(SearchConditionVO searchVo, NetworkCostCommonVO vo) throws EventException {
		try {
			List<SearchOptFixedCostListVO> retList = null;

			retList = dbDao.searchOptFixedCostList(vo);

			//String headerCD = "";
			//String headerNM = "";
			StringBuffer sbCD = new StringBuffer();
			StringBuffer sbNM = new StringBuffer();

			List<NetworkCostCommonVO> list = new ArrayList<NetworkCostCommonVO>();
			int size = retList.size();
			for(int i=0; i<size; i++){
				//headerCD = headerCD + ((SearchOptFixedCostListVO)(retList.get(i))).getStndCostCd();
				//headerNM = headerNM + ((SearchOptFixedCostListVO)(retList.get(i))).getStndCostNm();
				sbCD.append(((SearchOptFixedCostListVO)(retList.get(i))).getStndCostCd());
				sbNM.append(((SearchOptFixedCostListVO)(retList.get(i))).getStndCostNm());

				if(i != (size-1)){
					//headerCD = headerCD + "|";
					//headerNM = headerNM + "|";
					sbCD.append("|");
					sbNM.append("|");
				}
			}

			NetworkCostCommonVO tempVo = new NetworkCostCommonVO();
			tempVo.setHeaderCD(sbCD.toString());
			tempVo.setHeaderNM(sbNM.toString());
			list.add(tempVo);

			return list;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}


	/**
	 * 1. 기능 : 시선 일당 고정비 관리 화면에 대한 조회 이벤트 처리(ESM_MAS_043)<p>
	 * 2. 처리개요 : <p>
	 *    - 시선 일당 고정비 관리에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.11.24<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 *
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @return NetworkCostCommonVO
	 * @exception EventException
	 */
	public NetworkCostCommonVO searchOwnDailyHireList(SearchConditionVO searchVo, NetworkCostCommonVO vo) throws EventException {
		try {
			NetworkCostCommonVO[] rVoArray = new NetworkCostCommonVO[2];
	        String[] yearwk = searchVo.getFYearweek().split("[-]");

	        vo.setIteratorList(vo.seperationParameter(searchVo.getFHeader().trim(), "|"));
	        vo.setIteratorCnt(vo.getIteratorList().size());

            HashMap<String, String> qParam = new HashMap<String, String>();
            qParam.put("sls_yrmon", yearwk[0]);
            qParam.put("cost_wk"  , yearwk[1]);
            qParam.put("vsl_cd"   , Utils.iif(searchVo.getFSelvessel() == null, "", searchVo.getFSelvessel()));
            vo.setIndirectColumnValues(qParam);

            HashMap<String, Object> vParam = new HashMap<String, Object>();
            vParam.put("keyList"  , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("keyList2" , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("keyList3" , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("yrType" , searchVo.getFYrtype());
	        vo.setIndirectVariableValues(vParam);

            HashMap<String, Object> vParam2 = new HashMap<String, Object>();
            vParam2.put("keyList"  , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam2.put("keyList2" , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam2.put("keyList3" , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam2.put("yrType"   , searchVo.getFYrtype());

			rVoArray[0] = new NetworkCostCommonVO();
			rVoArray[0] = dbDao.searchOwnDailyHireList(vo);

			vo.setIndirectVariableValues(vParam2);

			rVoArray[1] = new NetworkCostCommonVO();
			rVoArray[1] = dbDao.searchOwnDHireByClassList(vo);

			vo.setNetworkCostCommonVOArray(rVoArray);

			List<NetworkCostCommonVO> list = new ArrayList<NetworkCostCommonVO>();
			list.add(vo);

			return vo;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}




	/**
	 * 1. 기능 : 시선 일당 고정비 관리화면에 대한 멀티 이벤트 처리(ESM_MAS_043)<p>
	 * 2. 처리개요 : <p>
	 *    - 시선 일당 고정비 관리에 대한 멀티처리
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.11.24<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 *
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param MasOwnVslDlyHirVO[] vos
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOwnDailyHire(SearchConditionVO searchVo, NetworkCostCommonVO vo, MasOwnVslDlyHirVO[] vos, String userId) throws EventException{
		try{
			List<HashMap<String, String>> createList = new ArrayList<HashMap<String, String>>();
            String[] stnd_cost_cd   = searchVo.getFHeader().split("[|]");

			//
			//----------------------------------------------------
            if(vos.length > 0){
                for(int i = 0 ; i < vos.length ; i++){
                    for (int k = 0; k < stnd_cost_cd.length; k++) {
                        String[] dhir_amt = vo.getHashAttribute("t"+stnd_cost_cd[k]);

                        //query parameter
                        HashMap<String, String> param = new HashMap<String, String>();
                        param.put("user_id"   , userId);
                        param.put("cre_usr_id", userId);
                        param.put("upd_usr_id", userId);

                        if(vos[i].getIbflag().equals("I")||vos[i].getIbflag().equals("U")) {
                        	param.put("cost_yrmon"		, vos[i].getCostYrmon()  );
                        	param.put("vsl_cd"			, vos[i].getVslCd()      );
                        	param.put("stnd_cost_cd"	, stnd_cost_cd[k]        );
                        	param.put("dhir_amt"		, dhir_amt[i]            );
                        	param.put("own_vsl_rmk"		, vos[i].getOwnVslRmk()  );
                        	param.put("vsl_clss_capa"	, vos[i].getVslClssCapa());
                            createList.add(param);
                        }
                    }
                }
            }
            vo.setMultiCreateList(createList);

			//[DB 실행]
			dbDao.multiOwnDailyHire(vo);
			// Average 삭제
			dbDao.removeAverageOwnDailyHire(searchVo.getFYearweek());
			// Average 생성
			dbDao.createAverageOwnDailyHire(searchVo.getFYearweek(),userId);
			//############################################################################

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @return List<SearchDailyHireListVO>
	 * @exception EventException
	 */
	public List<SearchDailyHireListVO> searchDailyHireList(SearchConditionVO searchVo, NetworkCostCommonVO vo) throws EventException {
		try {
			String yrType = searchVo.getFYrtype();
			String[] arrSearch = searchVo.getFYearweek().split("[-]");

			int rtnRow = 0;
			if(!yrType.equals("yrmon")){
	            HashMap<String, String> qParam = new HashMap<String, String>();
	            qParam.put("sls_yrmon", arrSearch[0]);
	            qParam.put("cost_wk"  , arrSearch[1]);
	            qParam.put("vsl_cd"   , Utils.iif(searchVo.getFVslCd() == null, "", searchVo.getFVslCd()));
	            vo.setIndirectColumnValues(qParam);

				List<SearchDailyHire2MonthCountVO> retList = dbDao.searchDailyHire2MonthCount(vo);
				SearchDailyHire2MonthCountVO retVo = (SearchDailyHire2MonthCountVO)retList.get(0);
				rtnRow = Integer.parseInt(retVo.getCnt());
			}

            HashMap<String, String> qParam2 = new HashMap<String, String>();
            qParam2.put("sls_yrmon", arrSearch[0]);
            qParam2.put("cost_wk"  , arrSearch[1]);
            qParam2.put("vsl_cd"   , Utils.iif(searchVo.getFVslCd() == null, "", searchVo.getFVslCd()));
            vo.setIndirectColumnValues(qParam2);

            HashMap<String, Object> vParam = new HashMap<String, Object>();
            vParam.put("yrType", searchVo.getFYrtype());
            vParam.put("rtnRow", rtnRow        );
	        vo.setIndirectVariableValues(vParam);

			return dbDao.searchDailyHireList(vo);
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}


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
	@SuppressWarnings("unchecked")
	public EventResponse multiDailyHire(SearchConditionVO searchVo, NetworkCostCommonVO vo, NetworkCostCommonVO[] vos, String userId) throws EventException{
		try{
			List createList = new ArrayList();
			List updateList = new ArrayList();

			//
			//----------------------------------------------------
            if(vos.length > 0){
                for(int i = 0 ; i < vos.length ; i++){
                    //query parameter
                    HashMap<String, String> param = new HashMap<String, String>();
                    param.put("user_id"   , userId);
                    param.put("cre_usr_id", userId);
                    param.put("upd_usr_id", userId);
                    if(vos[i].getSStatus().equals("I")) {
                    	param.put("cost_yrmon"   , vos[i].getSYM()        );
                    	param.put("vsl_cd"       , vos[i].getSVslCd()     );
                    	param.put("chrg_dhir_amt", vos[i].getSDlyHireAmt());
                        createList.add(param);
                    }
                    else if(vos[i].getSStatus().equals("U")) {
                    	param.put("chrg_dhir_amt", vos[i].getSDlyHireAmt());
                    	param.put("cost_yrmon"   , vos[i].getSYM()        );
                    	param.put("vsl_cd"       , vos[i].getSVslCd()     );
                        updateList.add(param);
                    }
                }
            }
            vo.setMultiCreateList(createList);
            vo.setMultiUpdateList(updateList);

			//[DB 실행]
			dbDao.multiDailyHire(vo);
			//############################################################################

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}

    /**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchFixCostByVVDListVO>
	 * @exception EventException
	 */
    public List<SearchFixCostByVVDListVO> searchFixCostByVVDList(SearchConditionVO searchConditionVO) throws EventException {
        try {
            return dbDao.searchFixCostByVVDList(searchConditionVO);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }

	/**
	 * 초기화 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 초기화 조회 이벤트 처리<br>
	 *
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchNWCreListVO>
	 * @exception EventException
	 */
    public List<SearchNWCreListVO> searchNWCreList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException {
        try {
            List<SearchNWCreListVO> list = null;
            if(vo.getEventName().equals("EsmMas0110Event")){
                list = dbDao.searchNWCreList(vo);
            }
            return list;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }

	/**
	 * 결과 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 결과 조회 이벤트 처리<br>
	 *
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchNWCreRStatusListVO>
	 * @exception EventException
	 */
    public List<SearchNWCreRStatusListVO> searchNWCreRStatusList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException {
        try {
            List<SearchNWCreRStatusListVO> list = null;
            if(vo.getEventName().equals("EsmMas0110Event")){
                list = dbDao.searchNWCreRStatusList(vo);
            }
            return list;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }

	/**
	 * 초기화 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 초기화 조회 이벤트 처리<br>
	 *
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchSltChtrCreListVO>
	 * @exception EventException
	 */
    public List<SearchSltChtrCreListVO> searchSltChtrCreList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException {
        try {
            List<SearchSltChtrCreListVO> list = null;
            if(vo.getEventName().equals("EsmMas0110Event")){
                list = dbDao.searchSltChtrCreList(vo);
            }
            return list;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }

	/**
	 * 결과 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 결과 조회 이벤트 처리<br>
	 *
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchSltChtrCreRStatusListVO>
	 * @exception EventException
	 */
    public List<SearchSltChtrCreRStatusListVO> searchSltChtrCreRStatusList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException {
        try {
            List<SearchSltChtrCreRStatusListVO> list = null;
            if(vo.getEventName().equals("EsmMas0110Event")){
                list = dbDao.searchSltChtrCreRStatusList(vo);
            }
            return list;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }

	/**
	 * 화면 : Network Cost by VVD <br>
	 * 경로 : Sales & Marketing > Cost Assignment > Estimated PFMC-PA > Create Network Cost  <br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param MasNtwkCostCreVO[] masNtwkCostCreVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
    public String createNWCreForVVD(SearchConditionVO searchConditionVO, MasNtwkCostCreVO[] masNtwkCostCreVOs, SignOnUserAccount account) throws EventException{
    	String inYr 		= "";
		String inFmMon 		= "";
		String inToMon 		= "";
		String inFmWk 		= "";
		String inToWk 		= "";
		String inMonOrWk	= "";

		String inTrdCd 		= "";
		String inRlaneCd 	= "";
		String inIocCd 		= "";
		String inVslCd 		= "";
		String inSkdVoyNo 	= "";
		String inDirCd 		= "";
		String inUserId		= "";
		String inMssChkFlg 	= "";

        try{
    		inYr 		= searchConditionVO.getFYear();
    		inFmMon 	= searchConditionVO.getFFmMon();
    		inToMon 	= searchConditionVO.getFToMon();
    		inFmWk 		= searchConditionVO.getFFmWk();
    		inToWk 		= searchConditionVO.getFToWk();
    		inMonOrWk	= searchConditionVO.getFChkprd();

    		inTrdCd 	= searchConditionVO.getFCobtrade();
    		inRlaneCd 	= searchConditionVO.getFCoblane();
    		inVslCd 	= searchConditionVO.getFVessel();
    		inSkdVoyNo 	= searchConditionVO.getFVoyage();
    		inDirCd 	= searchConditionVO.getFDir();
    		inUserId	= account.getUsr_id();

			// 한주 선택시
			if ( inFmWk.equals(inToWk) ){
				inMssChkFlg = "N";

				List<MasNtwkCostCreVO> createList = new ArrayList<MasNtwkCostCreVO>();

	            // MAS_NTWK_COST_CRE 테이블 Setting
	            //----------------------------------------------------

	            if(masNtwkCostCreVOs.length > 0){
	                for(int i = 0 ; i < masNtwkCostCreVOs.length ; i++){
	                	masNtwkCostCreVOs[i].setCreUsrId(inUserId);
	                	masNtwkCostCreVOs[i].setUpdUsrId(inUserId);
	                	masNtwkCostCreVOs[i].setCreSlctFlg(Utils.change10ToYN(masNtwkCostCreVOs[i].getCreSlctFlg()));

	                    createList.add(masNtwkCostCreVOs[i]);
	                    //if(vos[i].getIbflag().equals("I")) {
	                    //    createList.add(param);
	                    //}
	                }
	            }

	            //[DB 실행]
	            dbDao.multiNWCreForVVD(createList);
			}else{	// 여러주 선택시
				inMssChkFlg = "Y";
			}

			// 2009.09.15 파라메타 vo방식으로 변경 		--------------------------------- START
			//rtnResult = dbDaoNtAll.createNtwkCostALL(pYear, fMon, tMon, fWeek, tWeek, chkPrd, "3", "N", mss_chk_flg, trd_cd, rlane_cd, ioc_cd,
			//		vsl_cd, skd_voy_no, dir_cd, null, pUserId);

			ProcedureParamVO procedureParamVO = new ProcedureParamVO();
			procedureParamVO.setInYr		(inYr);
			procedureParamVO.setInFmMon		(inFmMon);
			procedureParamVO.setInToMon		(inToMon);
			procedureParamVO.setInFmWk		(inFmWk);
			procedureParamVO.setInToWk		(inToWk);
			procedureParamVO.setInMonOrWk	(inMonOrWk);
			procedureParamVO.setInFmStep	("3");
			procedureParamVO.setInAllFlg	("N");
			procedureParamVO.setInInd		("");
			procedureParamVO.setInMssChkFlg	(inMssChkFlg);
			procedureParamVO.setInTrdCd		(inTrdCd);
			procedureParamVO.setInRlaneCd	(inRlaneCd);
			procedureParamVO.setInIocCd		(inIocCd);
			procedureParamVO.setInVslCd		(inVslCd);
			procedureParamVO.setInSkdVoyNo	(inSkdVoyNo);
			procedureParamVO.setInDirCd		(inDirCd);
			procedureParamVO.setInStndCostCd(null);
			procedureParamVO.setInUserId	(inUserId);
			procedureParamVO.setInLogLvl	("9");
			

			NetWorkCostBackEndJob backEndJob = new NetWorkCostBackEndJob();
			backEndJob.setNetWorkCostVO(procedureParamVO, "createNWCreForVVD");
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String returnValue = backEndJobManager.execute(backEndJob, account.getUsr_id(), "createNWCreForVVD");

            return returnValue; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }

	/**
	 * 생성 이벤트 처리<br>
	 * NetworkCost화면에 대한 생성 이벤트 처리<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param MasSltChtrInfoVO[] masSltChtrInfoVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse createSltChtrCre(SearchConditionVO searchConditionVO, MasSltChtrInfoVO[] masSltChtrInfoVOs, SignOnUserAccount account) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	String inYr 		= "";
		String inFmMon 		= "";
		String inToMon 		= "";
		String inFmWk 		= "";
		String inToWk 		= "";
		String inMonOrWk	= "";

		String inTrdCd 		= "";
		String inRlaneCd 	= "";
		String inIocCd 		= "";
		String inVslCd 		= "";
		String inSkdVoyNo 	= "";
		String inDirCd 		= "";
		String inUserId		= "";
		String inMssChkFlg 	= "";
		String out_err_cd	= "";
		String out_err_msg	= "";

        try{
    		inYr 		= searchConditionVO.getFYear();
    		inFmMon 	= searchConditionVO.getFFmMon();
    		inToMon 	= searchConditionVO.getFToMon();
    		inFmWk 		= searchConditionVO.getFFmWk();
    		inToWk 		= searchConditionVO.getFToWk();
    		inMonOrWk	= searchConditionVO.getFChkprd();

    		inTrdCd 	= searchConditionVO.getFCobtrade();
    		inRlaneCd 	= searchConditionVO.getFCoblane();
    		inVslCd 	= searchConditionVO.getFVessel();
    		inSkdVoyNo 	= searchConditionVO.getFVoyage();
    		inDirCd 	= searchConditionVO.getFDir();
    		inUserId	= account.getUsr_id();

			// 한주 선택시
			if ( inFmWk.equals(inToWk) ){
				inMssChkFlg = "N";

	            //MAS_SLT_CHTR_INFO 테이블 Setting
	            //----------------------------------------------------
				List<MasSltChtrInfoVO> createList = new ArrayList<MasSltChtrInfoVO>();
	            if(masSltChtrInfoVOs.length > 0){
	                for(int i = 0 ; i < masSltChtrInfoVOs.length ; i++){

	                	masSltChtrInfoVOs[i].setCreSlctFlg(Utils.change10ToYN(masSltChtrInfoVOs[i].getCreSlctFlg()));
	                	masSltChtrInfoVOs[i].setCreUsrId(inUserId);
	                	masSltChtrInfoVOs[i].setUpdUsrId(inUserId);

	                	createList.add(masSltChtrInfoVOs[i]);
	                }
	            }
	            log.debug("createList.size() = "+createList.size());

	            //[DB 실행]
	            dbDao.multiSltChtrCre(createList);
			}else{	// 여러주 선택시
				inMssChkFlg = "Y";
			}

			ProcedureParamVO procedureParamVO = new ProcedureParamVO();
			procedureParamVO.setInYr		(inYr);
			procedureParamVO.setInFmMon		(inFmMon);
			procedureParamVO.setInToMon		(inToMon);
			procedureParamVO.setInFmWk		(inFmWk);
			procedureParamVO.setInToWk		(inToWk);
			procedureParamVO.setInMonOrWk	(inMonOrWk);
			procedureParamVO.setInFmStep	("4");
			procedureParamVO.setInAllFlg	("N");
			procedureParamVO.setInInd		("");
			procedureParamVO.setInMssChkFlg	(inMssChkFlg);
			procedureParamVO.setInTrdCd		(inTrdCd);
			procedureParamVO.setInRlaneCd	(inRlaneCd);
			procedureParamVO.setInIocCd		(inIocCd);
			procedureParamVO.setInVslCd		(inVslCd);
			procedureParamVO.setInSkdVoyNo	(inSkdVoyNo);
			procedureParamVO.setInDirCd		(inDirCd);
			procedureParamVO.setInStndCostCd(null);
			procedureParamVO.setInUserId	(inUserId);
			procedureParamVO.setInLogLvl	("9");

			ProcedureParamVO resultVO = new ProcedureParamVO();
			resultVO = dbDaoNtAll.createNtwkCostALL(procedureParamVO);

            if(resultVO != null){

    			out_err_cd = resultVO.getOutErrCd();
    			out_err_msg = resultVO.getOutErrMsg();
                log.debug("==========================================================================");
                log.debug("createSltChtrCre Result :: " + out_err_cd);
                log.debug("createSltChtrCre Result :: " + out_err_msg);
                log.debug("==========================================================================");

                if(out_err_cd.trim().equals("0000")){
                	out_err_cd = "00000";
                	out_err_msg = "Create Success!!";
                }

                eventResponse.setETCData("err_cd", out_err_cd);
                eventResponse.setETCData("err_msg", out_err_msg);
            }

            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }

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
    public List<SearchMissingStatusListVO> searchMissingStatusList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException {
        try {
            List<SearchMissingStatusListVO> list = null;
            if(vo.getEventName().equals("EsmMas0114Event")){

            	HashMap<String, String> qParam = new HashMap<String, String>();
            	qParam.put("prc_nm", searchVo.getFStrprcnm());
            	if (searchVo.getFChkBsazrflg() != null) {
            		qParam.put("bsa_zr_flg", searchVo.getFChkBsazrflg());
            	}
            	if(searchVo.getFStrchkprd().equals("W")) {
            		qParam.put("year", searchVo.getFStryear());
            		qParam.put("fm_week", searchVo.getFStrfmweek());
            		qParam.put("to_week", searchVo.getFStrtoweek());
            	}
            	else{
            		qParam.put("year", searchVo.getFStryear());
            		qParam.put("fm_month", searchVo.getFStrfmmonth());
            		qParam.put("to_month", searchVo.getFStrtomonth());
            	}
            	if (!searchVo.getFStrtrade().equals("")) {
            		qParam.put("trd_cd", searchVo.getFStrtrade());
            	}

            	if (!searchVo.getFStrlane().equals("")) {
            		qParam.put("rlane_cd", searchVo.getFStrlane());
            	}

            	if (!searchVo.getFStrvessel().equals("")) {
            		qParam.put("vsl_cd", searchVo.getFStrvessel());
            	}

            	if (!searchVo.getFStrvoyage().equals("")) {
            		qParam.put("skd_voy_no", searchVo.getFStrvoyage());
            	}

            	if (!searchVo.getFStrdir().equals("")) {
            		qParam.put("dir_cd", searchVo.getFStrdir());
            	}

            	if (!searchVo.getFCobcost().equals("")) {
            		qParam.put("stnd_cost_cd", searchVo.getFCobcost());
            	}
            	vo.setIndirectColumnValues(qParam);

            	HashMap<String, Object> vParam = new HashMap<String, Object>();
            	vParam.put("cost_yrwk"		, searchVo.getFStrchkprd());
            	vParam.put("bsa_zr_flg"		, searchVo.getFChkBsazrflg());
            	vParam.put("trd_cd"			, searchVo.getFStrtrade());
            	vParam.put("rlane_cd"		, searchVo.getFStrlane());
            	vParam.put("vsl_cd"			, searchVo.getFStrvessel());
            	vParam.put("skd_voy_no"		, searchVo.getFStrvoyage());
            	vParam.put("dir_cd"			, searchVo.getFStrdir());
            	vParam.put("stnd_cost_cd"	, searchVo.getFCobcost());
            	vo.setIndirectVariableValues(vParam);

                list = dbDao.searchMissingStatusList(vo);
            }
            return list;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }

    /**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param AverageUCVO averageUCVO
	 * @return List<AverageUCVO>
	 * @exception EventException
	 */
    public List<AverageUCVO> searchAverageUCList(AverageUCVO averageUCVO) throws EventException {
    	try {
    		averageUCVO.setFCostYrmon(averageUCVO.getFCostYrmon().replaceAll("-", ""));
            return dbDao.searchAverageUCList(averageUCVO);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
     }

    /**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param AverageUCVO averageUCVO
	 * @return List<AverageUCVO>
	 * @exception EventException
	 */
    public List<AverageUCVO> searchAverageUCRawList(AverageUCVO averageUCVO) throws EventException {
    	try {
    		averageUCVO.setFCostYrmon(averageUCVO.getFCostYrmon().replaceAll("-", ""));
            return dbDao.searchAverageUCRawList(averageUCVO);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
     }

     
	/**
	 * [Average U/C(OP fixed/variable cost, SPC CHT Rev/Charterage)]을 [삽입,수정,삭제] 합니다.<br>
	 *
	 * @param AverageUCVO[] averageUCVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiAverageUC(AverageUCVO[] averageUCVOs, SignOnUserAccount account) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<AverageUCVO> insertVoList = new ArrayList<AverageUCVO>();
			List<AverageUCVO> updateVoList = new ArrayList<AverageUCVO>();
			List<AverageUCVO> deleteVoList = new ArrayList<AverageUCVO>();
			
			for ( int i=0; i<averageUCVOs .length; i++ ) {
				if ( averageUCVOs[i].getIbflag().equals("I")){
					averageUCVOs[i].setCreUsrId(account.getUsr_id());
					averageUCVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(averageUCVOs[i]);
				} else if ( averageUCVOs[i].getIbflag().equals("U")){
					averageUCVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(averageUCVOs[i]);
				} else if ( averageUCVOs[i].getIbflag().equals("D")){
					deleteVoList.add(averageUCVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addAverageUC(insertVoList);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAverageUC(updateVoList);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteAverageUC(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
	 * 생성 이벤트 처리<br>
	 * Average UC단가를 생성한다.<br>
	 *
	 * @param AverageUCVO averageUCVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createAverageUC(AverageUCVO averageUCVO, SignOnUserAccount account) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			SearchConditionVO vo = new SearchConditionVO();
			averageUCVO.setCreUsrId(account.getUsr_id());
			averageUCVO.setUpdUsrId(account.getUsr_id());
			
			vo.setFCostYrmon(averageUCVO.getFCostYrmon());
			vo.setFTypeCd("OP04");
			vo.setFFmWk(averageUCVO.getFFmYrwk());
			vo.setFToWk(averageUCVO.getFToYrwk());
				
			//1.interface테이블에 BSA정보 업데이트한다.
			//  dbDao.modifyAverageUC(masOpAvgUtCostVO);
			//1.Average U/C 단가 , Raw Data 삭제
            dbDao.removeAverageUCRaw(averageUCVO);
            dbDao.removeAverageUC(averageUCVO);
            //2.verage U/C 단가 , Raw Data 생성
            dbDao.addAverageUCRaw(averageUCVO);
            dbDao.createAverageUC(averageUCVO);
            //3. Status 생성
            dbDao.modifyAverageUCStatus(vo, account);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return eventResponse;

	}

	/**
	 * 생성 이벤트 처리<br>
	 * Average UC 월단가를 복사해서 생성한다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createAverageMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> param = new HashMap<String, String>();

		try {
			String costYrmon = searchConditionVO.getFTarMon().replaceAll("-", "");
			AverageUCVO averageUCVO = new AverageUCVO();
			averageUCVO.setFCostYrmon(costYrmon);
			averageUCVO.setCreUsrId(account.getUsr_id());

			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, searchConditionVO.getFTarMon().replaceAll("-", ""));
            param.put("user_id"   		, account.getUsr_id());
            param.put("cost_use_tp_cd"	, searchConditionVO.getFCostUseTpCd());

            //1.Raw Data 삭제
            dbDao.removeAverageUCRaw(averageUCVO);
            //2.MAS_OP_AVG_UT_COST테이블에서  TARGET 해당월을 삭제한다.
            dbDao.removeAverageUC(averageUCVO);
            //3.Raw Data 생성
            dbDao.createAverageRawMonthCopy(param);
            //4.MAS_OP_AVG_UT_COST테이블에  SOURCE 해당월을 복사해서  TARGET 데이타를 생성한다.
            dbDao.createAverageMonthCopy(param);
            //5. Status 생성
            dbDao.createAverageStatusMonthCopy(param);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchFixCostByVVDOP4ListVO>
	 * @exception EventException
	 */
	public List<SearchFixCostByVVDOP4ListVO> searchFixCostByVVDOP4List(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchFixCostByVVDOP4List(searchConditionVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [Lane Table (1Cycle)]을 [조회] 합니다.<br>
	 * 
	 * @param LaneTable1CycleVO laneTable1CycleVO
	 * @return List<LaneTable1CycleVO>
	 * @exception EventException
	 */
	public List<LaneTable1CycleVO> searchLaneDetailList(LaneTable1CycleVO laneTable1CycleVO) throws EventException {
		try {
			return dbDao.searchLaneDetailList(laneTable1CycleVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}

	/**
	 * [Lane Detail]을 [삽입,수정,삭제] 합니다.<br>
	 *
	 * @param LaneTable1CycleVO[] laneTable1CycleVOs
	 * @param LaneTable1CycleVO laneTable1CycleVO
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiLaneDetail(LaneTable1CycleVO[] laneTable1CycleVOs, LaneTable1CycleVO laneTable1CycleVO, SignOnUserAccount account) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> param = new HashMap<String, String>();
		try {
            //1. 해당월을 삭제한다.
			param.put("f_cost_yrmon", laneTable1CycleVO.getFCostYrmon().replaceAll("-", ""));
            dbDao.deleteLaneDetailAll(param);
//
//            List<AverageUCVesselRegisterVO> insertVoList = new ArrayList<AverageUCVesselRegisterVO>();
//
//			for (int i=0; i<listVos.length; i++) {
//				if(!listVos[i].getIbflag().equals("D")){
//					listVos[i].setCostYrmon(searchConditionVO.getFYearweek().replaceAll("-", ""));
//					listVos[i].setUpdUsrId(account.getUsr_id());			
//			
					
			List<LaneTable1CycleVO> insertVoList = new ArrayList<LaneTable1CycleVO>();
//			List<LaneTable1CycleVO> updateVoList = new ArrayList<LaneTable1CycleVO>();
//			List<LaneTable1CycleVO> deleteVoList = new ArrayList<LaneTable1CycleVO>();
			
			for ( int i=0; i<laneTable1CycleVOs .length; i++ ) {
//				if ( laneTable1CycleVOs[i].getIbflag().equals("I")){
//					laneTable1CycleVOs[i].setCreUsrId(account.getUsr_id());
//					laneTable1CycleVOs[i].setUpdUsrId(account.getUsr_id());
//					insertVoList.add(laneTable1CycleVOs[i]);
//				} else if ( laneTable1CycleVOs[i].getIbflag().equals("U")){
//					laneTable1CycleVOs[i].setUpdUsrId(account.getUsr_id());
//					updateVoList.add(laneTable1CycleVOs[i]);
//				} else if ( laneTable1CycleVOs[i].getIbflag().equals("D")){
//					deleteVoList.add(laneTable1CycleVOs[i]);
				
				if ( !laneTable1CycleVOs[i].getIbflag().equals("D")){
					laneTable1CycleVOs[i].setCostYrmon(laneTable1CycleVO.getFCostYrmon().replaceAll("-", ""));
					laneTable1CycleVOs[i].setCreUsrId(account.getUsr_id());
					laneTable1CycleVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(laneTable1CycleVOs[i]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addLaneDetail(insertVoList);
			}

//			if ( updateVoList.size() > 0 ) {
//				dbDao.modifyLaneDetail(updateVoList);
//			}
//
//			if ( deleteVoList.size() > 0 ) {
//				dbDao.deleteLaneDetail(deleteVoList);
//			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [Trunk IPC Internal Pricing 단가]을 [조회] 합니다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @return List<MasInterPrcUtCostVO>
	 * @exception EventException
	 */
	public List<MasInterPrcUtCostVO> searchTrunkIPCPricing(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchTrunkIPCPricing(searchConditionVO.getFCostYrmon().replaceAll("-", ""));
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}

	/**
	 * [Trunk IPC Internal Pricing]을 [삽입,수정,삭제] 합니다.<br>
	 *
	 * @param MasInterPrcUtCostVO[] masInterPrcUtCostVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTrunkIPCPricing(MasInterPrcUtCostVO[] masInterPrcUtCostVOs, SignOnUserAccount account) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<MasInterPrcUtCostVO> insertVoList = new ArrayList<MasInterPrcUtCostVO>();
			List<MasInterPrcUtCostVO> updateVoList = new ArrayList<MasInterPrcUtCostVO>();
			List<MasInterPrcUtCostVO> deleteVoList = new ArrayList<MasInterPrcUtCostVO>();
			for ( int i=0; i<masInterPrcUtCostVOs .length; i++ ) {
				if ( masInterPrcUtCostVOs[i].getIbflag().equals("I")){
					masInterPrcUtCostVOs[i].setCreUsrId(account.getUsr_id());
					masInterPrcUtCostVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(masInterPrcUtCostVOs[i]);
				} else if ( masInterPrcUtCostVOs[i].getIbflag().equals("U")){
					masInterPrcUtCostVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(masInterPrcUtCostVOs[i]);
				} else if ( masInterPrcUtCostVOs[i].getIbflag().equals("D")){
					deleteVoList.add(masInterPrcUtCostVOs[i]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addTrunkIPCPricing(insertVoList);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyTrunkIPCPricing(updateVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	/**
	 * [Re-Assignment by Bound(Internal Pricing)]을 [조회] 합니다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchFixCostByVVDInterPrcListVO>
	 * @exception EventException
	 */
	public List<SearchFixCostByVVDInterPrcListVO> searchFixCostByVVDInterPrcList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchFixCostByVVDInterPrcList(searchConditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}

	/**
	 * [Re-Assignment by Bound(Internal Pricing)]을 [Create] 합니다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse createFixCostByVVDInterPrc(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	String inYr 		= "";
		String inFmMon 		= "";
		String inToMon 		= "";
		String inFmWk 		= "";
		String inToWk 		= "";
		String inMonOrWk	= "";

		String inTrdCd 		= "";
		String inRlaneCd 	= "";
		String inIocCd 		= "";
		String inVslCd 		= "";
		String inSkdVoyNo 	= "";
		String inDirCd 		= "";
		String inUserId		= "";
		String out_err_cd	= "";
		String out_err_msg	= "";

        try{
    		inYr 		= searchConditionVO.getFYear();
    		inFmMon 	= searchConditionVO.getFFmMon();
    		inToMon 	= searchConditionVO.getFToMon();
    		inFmWk 		= searchConditionVO.getFFmWk();
    		inToWk 		= searchConditionVO.getFToWk();
    		inMonOrWk	= searchConditionVO.getFChkprd();

    		inTrdCd 	= searchConditionVO.getFCobtrade();
    		inRlaneCd 	= searchConditionVO.getFCoblane();
    		inVslCd 	= searchConditionVO.getFVessel();
    		inSkdVoyNo 	= searchConditionVO.getFVoyage();
    		inDirCd 	= searchConditionVO.getFDir();
    		inUserId	= account.getUsr_id();

			ProcedureParamVO procedureParamVO = new ProcedureParamVO();
			procedureParamVO.setInFmStep    ("1");
			procedureParamVO.setInYr		(inYr);
			procedureParamVO.setInFmMon		(inFmMon);
			procedureParamVO.setInToMon		(inToMon);
			procedureParamVO.setInFmWk		(inFmWk);
			procedureParamVO.setInToWk		(inToWk);
			procedureParamVO.setInMonOrWk	(inMonOrWk);
			procedureParamVO.setInStndCostCd("54600000");
			procedureParamVO.setInTrdCd		(inTrdCd);
			procedureParamVO.setInRlaneCd	(inRlaneCd);
			procedureParamVO.setInIocCd		(inIocCd);
			procedureParamVO.setInVslCd		(inVslCd);
			procedureParamVO.setInSkdVoyNo	(inSkdVoyNo);
			procedureParamVO.setInDirCd		(inDirCd);
			procedureParamVO.setInStndCostCd(null);
			procedureParamVO.setInUserId	(inUserId);

			ProcedureParamVO resultVO = new ProcedureParamVO();
			resultVO = dbDao.createFixCostByVVDInterPrc(procedureParamVO);

            if(resultVO != null){

    			out_err_cd = resultVO.getOutErrCd();
    			out_err_msg = resultVO.getOutErrMsg();
                log.debug("==========================================================================");
                log.debug("createNWCreForVVD Result Error Code: " + out_err_cd);
                log.debug("createNWCreForVVD Result Error Message: " + out_err_msg);
                log.debug("==========================================================================");

                if(out_err_cd.trim().equals("00000")){
					out_err_cd = "00000";
					out_err_msg = "Create Success!!";
				} else {
					// 다른 에러 일때
					out_err_msg = new ErrorHandler("MAS00025", out_err_msg).getMessage();
//        			throw new DAOException(new ErrorHandler("MAS00025",out_err_cd).getMessage());
        			throw new DAOException(new ErrorHandler("MAS00025",out_err_cd).getMessage());
				}
            }

            eventResponse.setETCData("err_cd", out_err_cd);
            eventResponse.setETCData("err_msg", out_err_msg);

            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    

    /**
     * [Bunker Fee 정보]을 [CREATE] 합니다.<br>
     * 
     * @param SearchConditionVO searchConditionVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void createBunkerTariff(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
    	try {
    		MasBnkTrfVO masBnkTrfVO = new MasBnkTrfVO();		
    		String[] tYearWk = searchConditionVO.getFYearweek().split("[-]");
    		
    		masBnkTrfVO.setCostYrmon(tYearWk[0]);
    		masBnkTrfVO.setCostWk(tYearWk[1]);
    		masBnkTrfVO.setCreUsrId(account.getUsr_id());
    		masBnkTrfVO.setUpdUsrId(account.getUsr_id());
    		
    		dbDao.createBunkerTariff(masBnkTrfVO);
    		
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
    }

	
	/**
	 * Average UC 월단가를 복사해서 생성한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createBSACommitmentMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> param = new HashMap<String, String>();

		try {
			String costYrmon = searchConditionVO.getFTarMon().replaceAll("-", "");
			MasLaneTsBsaCmmtVO masLaneTsBsaCmmtVO = new MasLaneTsBsaCmmtVO();
			masLaneTsBsaCmmtVO.setCostYrmon(costYrmon);
			masLaneTsBsaCmmtVO.setCreUsrId(account.getUsr_id());

			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, searchConditionVO.getFTarMon().replaceAll("-", ""));
            param.put("user_id"   		, account.getUsr_id());

          //1.MAS_LANE_TS_BSA_CMMT테이블에서  TARGET 해당월을 삭제한다.
            dbDao.removeBSACommitmentMonth(masLaneTsBsaCmmtVO);
          //2.MAS_LANE_TS_BSA_CMMT테이블에  SOURCE 해당월을 복사해서  TARGET 데이타를 생성한다.
            dbDao.createBSACommitmentMonthCopy(param);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return eventResponse;
	}
	
	/**
	 * 구간별 운항일수 및 비율생성 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchIntervalTransitTimeListVO>
	 * @exception EventException
	 */
    public List<SearchIntervalTransitTimeListVO> searchLaneTransitTimeList(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
        try {
            return dbDao.searchLaneTransitTimeList(searchConditionVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		}
    }

	/**
	 * 구간별 운항일수 및 비율생성 화면에 대한 저장 이벤트 처리<br>
	 *
	 * @param MasMonVvdPortOpDysVO[] masMonVvdPortOpDysVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void multiLaneTransitTime(MasMonVvdPortOpDysVO[] masMonVvdPortOpDysVOs, SignOnUserAccount account) throws EventException{
        try{
            List<MasMonVvdPortOpDysVO> multiList = new ArrayList<MasMonVvdPortOpDysVO>();

            if(masMonVvdPortOpDysVOs.length > 0){
                for(int i = 0 ; i < masMonVvdPortOpDysVOs.length ; i++){
                	masMonVvdPortOpDysVOs[i].setUpdUsrId(account.getUse_flg());

                	multiList.add(masMonVvdPortOpDysVOs[i]);
                }
            }

            dbDao.multiLaneTransitTime(multiList);
            
        } catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
    }
    

	/**
	 * Average U/C화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchAverageUCListVO>
	 * @exception EventException
	 */
	public List<SearchAverageUCListVO> searchAverageCM2List(SearchConditionVO searchConditionVO) throws EventException{
        try {
    		searchConditionVO.setFCostYrmon(searchConditionVO.getFCostYrmon().replaceAll("-", ""));
            return dbDao.searchAverageCM2List(searchConditionVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		}
    }
	
	/**
	 * Average U/C화면에 대한 저장 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param MasOpAvgUtCostVO[] masOpAvgUtCostVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiAverageCM2(SearchConditionVO searchConditionVO, MasOpAvgUtCostVO[] masOpAvgUtCostVOs, SignOnUserAccount account) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<MasOpAvgUtCostVO> multiList = new ArrayList<MasOpAvgUtCostVO>();

		try {
			String costYrMon = searchConditionVO.getFCostYrmon().replaceAll("-", "");
			if(masOpAvgUtCostVOs.length > 0){
				for(int i = 0 ; i < masOpAvgUtCostVOs.length ; i++){
	            	if(masOpAvgUtCostVOs[i].getIbflag().equals("I") || masOpAvgUtCostVOs[i].getIbflag().equals("U")) {
	            		masOpAvgUtCostVOs[i].setCostYrmon(costYrMon);
	            		masOpAvgUtCostVOs[i].setCreUsrId(account.getUsr_id());
	            		masOpAvgUtCostVOs[i].setCostUseTpCd(searchConditionVO.getFCostUseTpCd());

	            		multiList.add(masOpAvgUtCostVOs[i]);
	            	}
				}
			}

			dbDao.multiAverageCM2(multiList);

		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
    	
		return eventResponse;
	}

	
	/**
	 * Average UC단가를 생성한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createAverageCM2(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String costYrmon = searchConditionVO.getFCostYrmon().replaceAll("-", "");
			MasOpAvgUtCostVO masOpAvgUtCostVO = new MasOpAvgUtCostVO();
			masOpAvgUtCostVO.setCostYrmon(costYrmon);
			masOpAvgUtCostVO.setCreUsrId(account.getUsr_id());
			masOpAvgUtCostVO.setUpdUsrId(account.getUsr_id());
			masOpAvgUtCostVO.setCostUseTpCd(searchConditionVO.getFCostUseTpCd());

          //1.interface테이블에 BSA정보 업데이트한다.
          //  dbDao.modifyAverageUC(masOpAvgUtCostVO);
          //2.MAS_OP_AVG_UT_COST테이블에서 해당월을 삭제한다.
          //  dbDao.removeAverageUC(masOpAvgUtCostVO);
          //3.MAS_OP_AVG_UT_COST테이블에 데이타를 생성한다.
            dbDao.createAverageCM2(masOpAvgUtCostVO);

		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}

		return eventResponse;

	}
	
	/**
	 * DailyHire 단가를 생성한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createDailyHire(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {		
		HashMap<String, String> param = new HashMap<String, String>();	
		int rtn_rows=0;
		String cre_sts = "N";
		
		try {
			// 경리 환율을 Check 한다.
			rtn_rows = dbDao.checkExchangeRate(searchConditionVO.getFYearweek());
			
            if (rtn_rows == 0){
            	cre_sts = "X";
            	return cre_sts;
            }			
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFYearweek());
			param.put("f_tar_mon"		, searchConditionVO.getFYearweek());
            param.put("user_id"   		, account.getUsr_id());

            //			 생성전에 table을 삭제 한다.
            dbDao.removeDailyHireIF(searchConditionVO.getFYearweek());
            dbDao.removeDailyHire(searchConditionVO.getFYearweek());
//			// I/F 한다
            dbDao.createDailyHireFromFMS(searchConditionVO,account);
//			// I/F값을 가지고 daily Hire 생성한다.
            dbDao.createDailyHireFromIFTable(searchConditionVO, account);
//			// Daily Hire Status값을 Update한다.
            dbDao.modifyDailyHireCreationStatus(param);

		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}

		return cre_sts;
	}	

	/**
	 * Daily Hire by Cht-VSL 전월 단가를 copy 한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createDailyHireMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		
		String costYrmon = searchConditionVO.getFTarMon().replaceAll("-", "");		
		HashMap<String, String> param = new HashMap<String, String>();		
		
		try {
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, costYrmon);
            param.put("user_id"   		, account.getUsr_id());
            
			// 생성전에 table을 삭제 한다.
            dbDao.removeDailyHireIF(costYrmon);
            dbDao.removeDailyHire(costYrmon);

            // I/F 값을 Copy 한다 
            dbDao.createDailyHireFromFMSMonthCopy(param);
			// daily Hire 값을 Copy 한다.
            dbDao.createDailyHireFromIFTableMonthCopy(param);
			// Daily Hire Status값을 Update한다.
            dbDao.modifyDailyHireCreationStatus(param);

		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}

	}		
	
	
	/**
	 * AVG hire by Own VSL 전월 단가를 copy 한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createOwnDailyHireMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		
		String costYrmon = searchConditionVO.getFTarMon().replaceAll("-", "");		
		HashMap<String, String> param = new HashMap<String, String>();		
		
		try {
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, costYrmon);
            param.put("user_id"   		, account.getUsr_id());
            
			// 생성전에 table을 삭제 한다.
            dbDao.removeOwnDailyHire(costYrmon);

			// AVG hire 값을 Copy 한다.
            dbDao.createOwnDailyHireMonthCopy(param);
			// AVG hire Status값을 Update한다.
            dbDao.modifyOwnDailyHireCreationStatus(param);

		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}

	}
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchBackEndJobStatus(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}
	

	/**
	 * [Lane Table]을 [복사] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createLaneTableMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account)  throws EventException{
		HashMap<String, String> param = new HashMap<String, String>();

		try {
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, searchConditionVO.getFTarMon().replaceAll("-", ""));
            param.put("user_id"   		, account.getUsr_id());

            //1. TARGET 해당월을 삭제한다.
            dbDao.removeLaneTableMonthCopy(param);
            //2. CSOURCE 해당월을 복사해서  TARGET 데이타를 생성한다. 
            dbDao.addLaneTableMonthCopy(param);
              
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		}
	}
	
	

	/**
	 * [Average U/C Status]을 [조회] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<MasUtCostCreStsVO>
	 * @exception EventException
	 */
	public List<MasUtCostCreStsVO> searchAverageUCStatus(SearchConditionVO searchConditionVO)  throws EventException {
		try {
			searchConditionVO.setFTypeCd("OP04");
			return dbDao.searchAverageUCStatus(searchConditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * Port Tariff Create 시 기존에 존재하는 항차를 삭제한다.<br>
	 * @param SearchPortTariffListVO[] listVos
	 * @exception EventException
	 */
	public void deletePortTariff(SearchPortTariffListVO[] listVos) throws EventException{
		try {
			List<SearchPortTariffListVO> deleteVoList = new ArrayList<SearchPortTariffListVO>();
			for ( int i=0; i<listVos .length; i++ ) {			   
			   deleteVoList.add(listVos[i]);				
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePortTariff(deleteVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 기능 : AVG-hire by Own-VSL (PA) 리스트를 조회한다.(ESM_MAS_0043)<p>
     * 처리개요 : AVG-hire by Own-VSL (PA) 에 대한 리스트를 조회
	 * ESM_MAS_0043 화면 조회
	 * @param AvgHireOwnVslVO avgHireOwnVslVO
	 * @return List<AvgHireOwnVslVO>
	 * @exception EventException
	 */
	public List<AvgHireOwnVslVO> searchAvgHireOwnVslMainList(AvgHireOwnVslVO avgHireOwnVslVO) throws EventException {
		try {
			return dbDao.searchAvgHireOwnVslMainList(avgHireOwnVslVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * AVG-hire by Own-VSL (PA) 화면에 대한 멀티 이벤트 처리<br>
	 * ESM_MAS_0043 수정 저장
	 * @param AvgHireOwnVslVO[] avgHireOwnVslVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiAvgHireOwnVslMainList(AvgHireOwnVslVO[] avgHireOwnVslVOs, SignOnUserAccount account) throws EventException{
		try {
			List<AvgHireOwnVslVO> updateVoList = new ArrayList<AvgHireOwnVslVO>();
			
			if( avgHireOwnVslVOs != null ) {
				for ( int i=0; i<avgHireOwnVslVOs.length; i++ ) {				
					String ibflag = avgHireOwnVslVOs[i].getIbflag();
					avgHireOwnVslVOs[i].setIbflag(ibflag);
						
//					if ( avgHireOwnVslVOs[i].getCostWk().equals("") || avgHireOwnVslVOs[i].getCostWk().equals(null) || avgHireOwnVslVOs[i].getCostWk().equals("00")){
					if ( avgHireOwnVslVOs[i].getCostWk().equals("") || avgHireOwnVslVOs[i].getCostWk() == null || avgHireOwnVslVOs[i].getCostWk().equals("00")){
						avgHireOwnVslVOs[i].setCostWk("00");
					}else{					
						String cost_wk = avgHireOwnVslVOs[i].getCostWk();
						avgHireOwnVslVOs[i].setCostWk(cost_wk);
					}
					
					String eff_fm_to_yrmon_1 = avgHireOwnVslVOs[i].getEffFmToYrmon().substring(0,6);
					String eff_fm_to_yrmon_2 = avgHireOwnVslVOs[i].getEffFmToYrmon().substring(9);
					avgHireOwnVslVOs[i].setEffFmYrmon(eff_fm_to_yrmon_1);
					avgHireOwnVslVOs[i].setEffToYrmon(eff_fm_to_yrmon_2);
					
					String tab_item = avgHireOwnVslVOs[0].getTabItem();
					avgHireOwnVslVOs[i].setTabItem(tab_item);			
					
					if ( avgHireOwnVslVOs[i].getIbflag().equals("I")){
						String cost_yrmon = avgHireOwnVslVOs[i].getCostYrmon();					
						avgHireOwnVslVOs[i].setCostYrmon(cost_yrmon);
						
						avgHireOwnVslVOs[i].setCreUsrId(account.getUsr_id());
						avgHireOwnVslVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(avgHireOwnVslVOs[i]);
					}else if(avgHireOwnVslVOs[i].getIbflag().equals("U")){
						String cost_yrmon_1 = avgHireOwnVslVOs[i].getCostYrmon().substring(0,4);
						String cost_yrmon_2 = avgHireOwnVslVOs[i].getCostYrmon().substring(5);
						avgHireOwnVslVOs[i].setCostYrmon(cost_yrmon_1 + cost_yrmon_2);
						
						avgHireOwnVslVOs[i].setCreUsrId(account.getUsr_id());
						avgHireOwnVslVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(avgHireOwnVslVOs[i]);
					}
				}
			}

			if ( updateVoList.size() > 0 ) {				
				dbDao.modifyAvgHireOwnVslMainList(updateVoList);				
			}			
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AVG-hire by Own-VSL (PA) 비용 생성<br>
	 * @param AvgHireOwnVslVO avgHireOwnVslVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createAvgHireOwnVslMain(AvgHireOwnVslVO avgHireOwnVslVO, SignOnUserAccount account) throws EventException {
		String pErrorCode = "";
		String Gubun = "";
		try {			
			Gubun = avgHireOwnVslVO.getFYrtype();
			if ("yrmon".equals(Gubun)){
				String year = avgHireOwnVslVO.getFSyearmonth().substring(0,4);
				String cost_mn	= avgHireOwnVslVO.getFSyearmonth().substring(4);
				avgHireOwnVslVO.setFYear(year);
				avgHireOwnVslVO.setFMon(cost_mn);
			} else {
				String year = avgHireOwnVslVO.getFYearweek().substring(0,4);
				String cost_wk	= avgHireOwnVslVO.getFYearweek().substring(4);
				avgHireOwnVslVO.setFYearwk(year);
				avgHireOwnVslVO.setFFmWk(cost_wk);				
			}    		
    		pErrorCode = dbDao.createAvgHireOwnVslMain(avgHireOwnVslVO, account);
    		
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
		return pErrorCode;
    }
	
	/**
	 * MAS 사선고정비 메뉴얼 비용 수정
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchAvgHireOwnVslDtrbListVO>
	 * @exception EventException
	 */
	public List<SearchAvgHireOwnVslDtrbListVO> searchAvgHireOwnVslDtrbList(SearchConditionVO searchConditionVO)  throws EventException {
		try {
			String[] arrSearch = searchConditionVO.getFYearweek().split("[-]");
			String year = arrSearch[0];
			String cost_wk	= arrSearch[1];

			searchConditionVO.setFYear(year);
			searchConditionVO.setFFmWk(cost_wk);
			return dbDao.searchAvgHireOwnVslDtrbList(searchConditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * MAS 사선고정비 메뉴얼 비용 수정<br>
	 * @param SearchAvgHireOwnVslDtrbListVO[] listVos
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String multiAvgHireOwnVslDtrb(SearchAvgHireOwnVslDtrbListVO[] listVos, SignOnUserAccount account) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String strCreationSaveFalse = "Y";
		try {
			List<SearchAvgHireOwnVslDtrbListVO> updateVoList = new ArrayList<SearchAvgHireOwnVslDtrbListVO>();
			for ( int i=0; i<listVos .length; i++ ) {
				if ( listVos[i].getIbflag().equals("U")){
					listVos[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(listVos[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.multiAvgHireOwnVslDtrb(updateVoList);
			}
			strCreationSaveFalse = "N";						
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);						
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return strCreationSaveFalse;
	}

	/**
	 * MAS 사선고정비 메뉴얼 비용 생성<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createAvgHireOwnVslDtrb(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		String pErrorCode = "";
		try {
			String[] arrSearch = searchConditionVO.getFYearweek().split("[-]");
			String year = arrSearch[0];
			String cost_wk	= arrSearch[1];

			searchConditionVO.setFYear(year);
			searchConditionVO.setFFmWk(cost_wk);
			pErrorCode = dbDao.createAvgHireOwnVslDtrb(searchConditionVO, account);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
		return pErrorCode;
    }

	/**
	 * ESM_MAS_0042 용선료 Other 항목 배부
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchOtherVesselDailyHireListVO>
	 * @exception EventException
	 */
	public List<SearchOtherVesselDailyHireListVO> searchOtherVesselDailyHireList(SearchConditionVO searchConditionVO)  throws EventException {
		try {
			String[] arrSearch = searchConditionVO.getFYearweek().split("[-]");
			String year = arrSearch[0];
			String cost_wk	= arrSearch[1];

			searchConditionVO.setFYear(year);
			searchConditionVO.setFFmWk(cost_wk);
			return dbDao.searchOtherVesselDailyHireList(searchConditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0042 용선료 Other 항목 배부 - Save<br>
	 * @param SearchOtherVesselDailyHireListVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiOtherVesselDailyHire(SearchOtherVesselDailyHireListVO[] listVos, SignOnUserAccount account) throws EventException {
		try {
			List<SearchOtherVesselDailyHireListVO> updateVoList = new ArrayList<SearchOtherVesselDailyHireListVO>();
			for ( int i=0; i<listVos .length; i++ ) {
				if ( listVos[i].getIbflag().equals("U")){
					listVos[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(listVos[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.multiOtherVesselDailyHire(updateVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_MAS_0042 용선료 Other 항목 배부 - Create<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createOtherVesselDailyHire(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		String pErrorCode = "";
    	try {
			
			String year = searchConditionVO.getFYearweek().substring(0,4);
			String cost_wk	= searchConditionVO.getFYearweek().substring(4);

			searchConditionVO.setFYear(year);
			searchConditionVO.setFFmWk(cost_wk);
    		pErrorCode = dbDao.createOtherVesselDailyHire(searchConditionVO, account);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
    	return pErrorCode;
    }

	/**
	 * 1. 기능 : Port Tariff 조회/변경 화면에 대한 조회 이벤트 처리(ESM_MAS_0185)
	 * 2. 처리개요 : <p>
	 *    - 주차별, VVD별 Port Tariff 조회
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchPortTariffWeekListVO>
	 * @exception EventException
	 */
	public List<SearchPortTariffWeekListVO> searchPortTariffWeekList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchPortTariffWeekList(searchConditionVO);
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 1. 기능 : Port Tariff 조회/변경 화면에 대한 조회 이벤트 처리(ESM_MAS_0185)
	 * 2. 처리개요 : <p>
	 *    - 주차별, VVD별 배부된 항비 정보 조회
	 *
	 * @param SearchPortTariffWeekListVO searchPortTariffWeekListVO
	 * @return List<SearchPortTariffWeekListVO>
	 * @exception EventException
	 */
	public List<SearchPortTariffWeekListVO> searchPortTariffDistributeList(SearchPortTariffWeekListVO searchPortTariffWeekListVO) throws EventException {
		try {
			return dbDao.searchPortTariffDistributeList(searchPortTariffWeekListVO);
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * 1. 기능 : Port Tariff 조회/변경 화면에 대한 조회 이벤트 처리(ESM_MAS_0185)
	 * 2. 처리개요 : <p>
	 *    - 주차별, VVD별 배부된 항비 정보 저장
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SearchPortTariffWeekListVO[] searchPortTariffWeekListVOs
	 * @param SignOnUserAccount account
	 * @return List<SearchPortTariffWeekListVO>
	 * @exception EventException
	 */
	public String multiPortTariffByVvd(SearchConditionVO searchConditionVO, SearchPortTariffWeekListVO[] searchPortTariffWeekListVOs, SignOnUserAccount account) throws EventException{
        try{
        	List<SearchPortTariffWeekListVO> list = new ArrayList<SearchPortTariffWeekListVO>();

            if(searchPortTariffWeekListVOs.length > 0){
                for(int i = 0 ; i < searchPortTariffWeekListVOs.length ; i++){
                	list.add(searchPortTariffWeekListVOs[i]);
                }
            }
        	
			NetWorkCostBackEndJob backEndJob = new NetWorkCostBackEndJob();
			backEndJob.setPortTariffVO(list, "multiPortTariffByVvd", account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String returnValue = backEndJobManager.execute(backEndJob, account.getUsr_id(), "multiPortTariffByVvd");

            return returnValue; // "SUCCESS"
        } catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}

	/**
	 * [MAS_STND_USE_QTY Table]을 [복사] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createStndUseQtyMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account)  throws EventException {
		HashMap<String, String> param = new HashMap<String, String>();

		try {
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, searchConditionVO.getFTarMon().replaceAll("-", ""));
            param.put("user_id"   		, account.getUsr_id());

            //1. TARGET 해당월을 삭제한다.
            dbDao.removeStndUseQtyMonthCopy(param);
            //2. CSOURCE 해당월을 복사해서  TARGET 데이타를 생성한다. 
            dbDao.addStndUseQtyMonthCopy(param);

//            dbDao.removeLaneTableMonthCopy(param);
//            dbDao.addLaneTableMonthCopy(param);
            
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_MAS_0327 화면 조회
	 * @param GenExpStndCostVO genExpStndCostVO
	 * @return List<GenExpStndCostVO>
	 * @exception EventException
	 */
	public List<GenExpStndCostVO> searchGenExpStndCostMainList(GenExpStndCostVO genExpStndCostVO) throws EventException {
		try {
			String[] arrSearch = genExpStndCostVO.getFYearweek().split("[-]");
			String year = arrSearch[0];
			String cost_wk	= arrSearch[1];
			
			genExpStndCostVO.setFYearweek(year + cost_wk);
			return dbDao.searchGenExpStndCostMainList(genExpStndCostVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * General Expense Pre OP Cost<br>
	 * ESM_MAS_0327 비용 생성
	 * @param GenExpStndCostVO genExpStndCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createGenExpStndCostMainList(GenExpStndCostVO genExpStndCostVO, SignOnUserAccount account) throws EventException {
		String pErrorCode = "";		
		try {
			String[] arrSearch = genExpStndCostVO.getFYearweek().split("[-]");
			String year1 = arrSearch[0];
			String cost_mn1	= arrSearch[1];			
			genExpStndCostVO.setFYearweek(year1 + cost_mn1);
			
			String[] arrSearch2 = genExpStndCostVO.getFSyearmonth().split("[-]");
			String year2 = arrSearch2[0];
			String cost_mn2	= arrSearch2[1];			
			genExpStndCostVO.setFSyearmonth(year2 + cost_mn2);
						
    		pErrorCode = dbDao.createGenExpStndCostMainList(genExpStndCostVO, account);
    		
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
		return pErrorCode;
    }
	
	/**
	 * ESM_MAS_0328 화면 조회
	 * @param GenExpStndCostVO genExpStndCostVO
	 * @return List<GenExpStndCostVO>
	 * @exception EventException
	 */
	public List<GenExpStndCostVO> searchGenExpStndCostDodPop(GenExpStndCostVO genExpStndCostVO)  throws EventException {
		try {
			String[] arrSearch = genExpStndCostVO.getFYearweek().split("[-]");
			String year = arrSearch[0];
			String cost_wk	= arrSearch[1];
			
			genExpStndCostVO.setFYearweek(year + cost_wk);
			return dbDao.searchGenExpStndCostDodPop(genExpStndCostVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * AVG-hire by Own-VSL (PA) 화면에 대한 멀티 이벤트 처리<br>
	 * ESM_MAS_0328 화면 수정
	 * @param GenExpStndCostVO[] genExpStndCostVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiGenExpStndCostDodPop(GenExpStndCostVO[] genExpStndCostVOs, SignOnUserAccount account) throws EventException{
		try {			
			List<GenExpStndCostVO> updateVoList = new ArrayList<GenExpStndCostVO>();		
			
			for ( int i=0; i<genExpStndCostVOs .length; i++ ) {
				genExpStndCostVOs[i].setUpdUsrId(account.getUsr_id());
			
				if ( genExpStndCostVOs[i].getIbflag().equals("U")){
					updateVoList.add(genExpStndCostVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.multiGenExpStndCostDodPop(updateVoList);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * General Expense Cost Modification<br>
	 * ESM_MAS_0328 비용 생성
	 * @param GenExpStndCostVO genExpStndCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createGenExpStndCostDodPop(GenExpStndCostVO genExpStndCostVO, SignOnUserAccount account) throws EventException {
		String pErrorCode = "";		
		try {			
			String[] arrSearch = genExpStndCostVO.getFYearweek().split("[-]");
			String year1 = arrSearch[0];
			String cost_mn1	= arrSearch[1];			
			genExpStndCostVO.setFYearweek(year1 + cost_mn1);
			
//			String[] arrSearch2 = genExpStndCostVO.getFSyearmonth().split("[-]");
//			String year2 = arrSearch2[0];
//			String cost_mn2	= arrSearch2[1];			
//			genExpStndCostVO.setFSyearmonth(year2 + cost_mn2);
			
    		pErrorCode = dbDao.createGenExpStndCostDodPop(genExpStndCostVO, account);
    		
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
		return pErrorCode;
    }
	
	/**
	 * ESM_MAS_0329 화면 조회
	 * @param GenExpStndCostVO genExpStndCostVO
	 * @return List<GenExpStndCostVO>
	 * @exception EventException
	 */
	public List<GenExpStndCostVO> searchGenExpStndCostLanePop(GenExpStndCostVO genExpStndCostVO)  throws EventException {
		try {
			String[] arrSearch = genExpStndCostVO.getFYearweek().split("[-]");
			String year = arrSearch[0];
			String cost_wk	= arrSearch[1];
			
			genExpStndCostVO.setFYearweek(year + cost_wk);
			return dbDao.searchGenExpStndCostLanePop(genExpStndCostVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0321 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<BunkerTariffCostVO>
	 * @exception EventException
	 */
	public List<BunkerTariffCostVO> searchBunkerTariffCostList(SearchConditionVO searchConditionVO ) throws EventException {
		try {
			String[] arrSearch = searchConditionVO.getFYearweek().split("[-]");
			String cost_yrmon = arrSearch[0]+arrSearch[1];
			searchConditionVO.setFCostYrmon(cost_yrmon);                                     
			return dbDao.searchBunkerTariffCostList(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0321 - Save<br>
	 * @param BunkerTariffCostVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiBunkerTariffCost(BunkerTariffCostVO[] listVos, SignOnUserAccount account) throws EventException {
		try {
			List<BunkerTariffCostVO> updateVoList = new ArrayList<BunkerTariffCostVO>();
			for ( int i=0; i<listVos .length; i++ ) {
				if ( listVos[i].getIbflag().equals("U") && listVos[i].getLvl().equals("0")){
					listVos[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(listVos[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyBunkerTariffCost(updateVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
		
	/**
	 * ESM_MAS_0330 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<AverageUCVesselVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselVO> searchAverageUCVesselList(SearchConditionVO searchConditionVO ) throws EventException {
		try {
			return dbDao.searchAverageUCVesselList(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0330 조회<br>
	 * sheetObjects[10] -> Total 탭의 결과조회
	 * @param AverageUCVesselVO averageUCVesselVO
	 * @return List<AverageUCVesselVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselVO> searchAverageUCVesselListTotal(AverageUCVesselVO averageUCVesselVO) throws EventException {
		try {
			return dbDao.searchAverageUCVesselListTotal(averageUCVesselVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0330 Class 콤보 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<AverageUCVesselVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselVO> searchAverageUCVesselClassList(SearchConditionVO searchConditionVO) throws EventException{
		try {
			return dbDao.searchAverageUCVesselClassList(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0330 Vessel 콤보 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<AverageUCVesselVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselVO> searchAverageUCVesselCombo(SearchConditionVO searchConditionVO) throws EventException{
		try {
			return dbDao.searchAverageUCVesselCombo(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0330 - Save<br>
	 * @param AverageUCVesselVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiAverageUCVessel(AverageUCVesselVO[] listVos, SignOnUserAccount account) throws EventException{
		try {
			List<AverageUCVesselVO> updateVoList = new ArrayList<AverageUCVesselVO>();
			for ( int i=0; i<listVos .length; i++ ) {
				if ( listVos[i].getIbflag().equals("U")){
					listVos[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(listVos[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAverageUCVessel(updateVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0330 - Month Copy<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createAverageUCVesselMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		HashMap<String, String> param = new HashMap<String, String>();

		try {
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, searchConditionVO.getFTarMon().replaceAll("-", ""));
			param.put("f_cobcost"		, searchConditionVO.getFCobcost());
            param.put("user_id"   		, account.getUsr_id());

            //1. TARGET 해당월을 삭제한다.
            dbDao.removeAverageUCVesselMonthCopy(param);
            //2. CSOURCE 해당월을 복사해서  TARGET 데이타를 생성한다. 
            dbDao.addAverageUCVesselMonthCopy(param);
            
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_MAS_0331 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<AverageUCVesselRegisterVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselRegisterVO> searchAverageUCVesselRegisterList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchAverageUCVesselRegisterList(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0331 - Save<br>
	 * @param AverageUCVesselRegisterVO[] listVos
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiAverageUCVesselRegister(AverageUCVesselRegisterVO[] listVos, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		HashMap<String, String> param = new HashMap<String, String>();
		
		try {
			
            //1. 해당월을 삭제한다.
			param.put("f_tar_mon", searchConditionVO.getFYearweek().replaceAll("-", ""));
            dbDao.removeAverageUCVesselRegisterMonthCopy(param);

            List<AverageUCVesselRegisterVO> insertVoList = new ArrayList<AverageUCVesselRegisterVO>();

			for (int i=0; i<listVos.length; i++) {
				if(!listVos[i].getIbflag().equals("D")){
					listVos[i].setCostYrmon(searchConditionVO.getFYearweek().replaceAll("-", ""));
					listVos[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(listVos[i]);
//					deleteVoList.add(listVos[i]);
//				} else if(listVos[i].getIbflag().equals("U")){
//					listVos[i].setUpdUsrId(account.getUsr_id());
//					updateVoList.add(listVos[i]);
//				} else if(listVos[i].getIbflag().equals("I")){
//					listVos[i].setCostYrmon(cost_yrmon);
//					listVos[i].setUpdUsrId(account.getUsr_id());
//					insertVoList.add(listVos[i]);
				}
			}

//			if (deleteVoList.size() > 0) {
//				dbDao.removeAverageUCVesselRegister(deleteVoList);
//			} else if (updateVoList.size() > 0){
//				dbDao.modifyAverageUCVesselRegister(updateVoList);
//			} else if (insertVoList.size() > 0){
				dbDao.addAverageUCVesselRegister(insertVoList);
//			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0331 - Month Copy<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createAverageUCVesselRegisterMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account)  throws EventException{
		HashMap<String, String> param = new HashMap<String, String>();

		try {
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, searchConditionVO.getFTarMon().replaceAll("-", ""));
            param.put("user_id"   		, account.getUsr_id());

            //1. TARGET 해당월을 삭제한다.
            dbDao.removeAverageUCVesselRegisterMonthCopy(param);
            //2. CSOURCE 해당월을 복사해서  TARGET 데이타를 생성한다. 
            dbDao.addAverageUCVesselRegisterMonthCopy(param);
            
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * ESM_MAS_0332 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<AverageUCVesselDetailVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselDetailVO> searchAverageUCVesselDetailList(SearchConditionVO searchConditionVO ) throws EventException {
		try {
			return dbDao.searchAverageUCVesselDetailList(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * ESM_MAS_0332 - Save<br>
	 * @param AverageUCVesselDetailVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiAverageUCVesselDetail(AverageUCVesselDetailVO[] listVos, SignOnUserAccount account) throws EventException{
		try {
			List<AverageUCVesselDetailVO> updateVoList = new ArrayList<AverageUCVesselDetailVO>();
			for ( int i=0; i<listVos .length; i++ ) {
				if ( listVos[i].getIbflag().equals("U")){
					listVos[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(listVos[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAverageUCVesselDetail(updateVoList);
				dbDao.modifyAverageUCVesselDetailAvg(updateVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0332 - Create<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String createAverageUCVesselDetail(SearchConditionVO searchConditionVO) throws EventException{
		String pErrorCode = "";
    	try {
    		pErrorCode = dbDao.createAverageUCVesselDetail(searchConditionVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
    	return pErrorCode;
    }
	
	/**
	 * ESM_MAS_0333 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<AverageUCVesselUtVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselUtVO> searchlAverageUCVesselUtList(SearchConditionVO searchConditionVO ) throws EventException {
		try {
			return dbDao.searchlAverageUCVesselUtList(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0333 조회<br>
	 * Cost Total 탭 조회
	 * @param AverageUCVesselUtVO averageUCVesselUtVO
	 * @return List<AverageUCVesselUtVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselUtVO> searchlAverageUCVesselUtListTotal(AverageUCVesselUtVO averageUCVesselUtVO) throws EventException {
		try {
			return dbDao.searchlAverageUCVesselUtListTotal(averageUCVesselUtVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0333 - Save<br>
	 * @param AverageUCVesselUtVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiAverageUCVesselUt(AverageUCVesselUtVO[] listVos, SignOnUserAccount account) throws EventException { 
		try {
			List<AverageUCVesselUtVO> insertVoList = new ArrayList<AverageUCVesselUtVO>();
			List<AverageUCVesselUtVO> updateVoList = new ArrayList<AverageUCVesselUtVO>();
			
			for ( int i=0; i<listVos .length; i++ ) {
				if ( listVos[i].getIbflag().equals("I")){
					listVos[i].setCreUsrId(account.getUsr_id());
					listVos[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(listVos[i]);
				} else if ( listVos[i].getIbflag().equals("U")){
					listVos[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(listVos[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addAverageUCVesselUt(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAverageUCVesselUt(updateVoList);
			}
	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0333 - Create<br>
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createAverageUCVesselUt(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.removeAverageUCVesselUt(searchConditionVO);
    		dbDao.createAverageUCVesselUt(searchConditionVO, account);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
	}
	
	/**
	 * ESM_MAS_0333 - Month Copy<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createAverageUCVesselUtMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		HashMap<String, String> param = new HashMap<String, String>();

		try {
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, searchConditionVO.getFTarMon().replaceAll("-", ""));
			param.put("f_cobcost"		, searchConditionVO.getFCobcost());
            param.put("user_id"   		, account.getUsr_id());

            //1. TARGET 해당월을 삭제한다.
            dbDao.removeAverageUCVesselUtMonthCopy(param);
            
            //2. CSOURCE 해당월을 복사해서  TARGET 데이타를 생성한다.
            //[CHM-201642075] cost total에도 monty copy 기능 추가 작업 (99999999 값이면 모든 계정을 생성한다. 계정이 추가되면 아래 fCobcostLst에 추가)
            if (searchConditionVO.getFCobcost().equals("99999999")) {
            	String fCobcostLst = "54100000,54250000,54200000,54300000,54150000,54450000,54180000,54550000,72100000,54350000,53101000,53102000,53200000,54400000,43102011";
            	String[] fCobcostArr = fCobcostLst.split(",");
            	
            	for (int i=0;i<fCobcostArr.length;i++) {
            		param.put("f_cobcost", fCobcostArr[i]);
                    dbDao.addAverageUCVesselUtMonthCopy(param);
            	}
            } else {
                dbDao.addAverageUCVesselUtMonthCopy(param);
            }
            
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_MAS_0335 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<AverageUCVesselUtDetailVO>
	 * @exception EventException
	 */
	public List<AverageUCVesselUtDetailVO> searchlAverageUCVesselUtDetailList(SearchConditionVO searchConditionVO ) throws EventException {
		try {
			return dbDao.searchlAverageUCVesselUtDetailList(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0335 - Save<br>
	 * @param AverageUCVesselUtDetailVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiAverageUCVesselUtDetail(AverageUCVesselUtDetailVO[] listVos, SignOnUserAccount account) throws EventException{
		try {
			List<AverageUCVesselUtDetailVO> updateVoList = new ArrayList<AverageUCVesselUtDetailVO>();
			for ( int i=0; i<listVos .length; i++ ) {
				if ( listVos[i].getIbflag().equals("U")){
					listVos[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(listVos[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAverageUCVesselUtDetail(updateVoList);
				dbDao.modifyAverageUCVesselUtMerge(updateVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0335 - Create<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String createAverageUCVesselUtDetail(SearchConditionVO searchConditionVO) throws EventException{
		String pErrorCode = "";
    	try {
    		pErrorCode = dbDao.createAverageUCVesselUtDetail(searchConditionVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
    	return pErrorCode;
    }
	
	/**
	 * ESM_MAS_0190 조회<br>
	 * @param NetworkCostExceptionListVO networkCostExceptionListVO
	 * @return List<NetworkCostExceptionListVO>
	 * @exception EventException
	 */
	public List<NetworkCostExceptionListVO> searchNetworkCostExceptionList(NetworkCostExceptionListVO networkCostExceptionListVO) throws EventException {
		try {
			return dbDao.searchNetworkCostExceptionList(networkCostExceptionListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0190 - Save-insert,update<br>
	 * @param NetworkCostExceptionListVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiNetworkCostExceptionList(NetworkCostExceptionListVO[] listVos , SignOnUserAccount account) throws EventException {
		List<NetworkCostExceptionListVO> insertVoList = new ArrayList<NetworkCostExceptionListVO>();
		List<NetworkCostExceptionListVO> updateVoList = new ArrayList<NetworkCostExceptionListVO>();
		try {			
			for ( int i=0; i < listVos.length; i++ ) {
				listVos[i].setCreUsrId(account.getUsr_id());
				listVos[i].setUpdUsrId(account.getUsr_id());
				
				if ( listVos[i].getIbflag().equals("I")){										
					insertVoList.add(listVos[i]);
				} else if ( listVos[i].getIbflag().equals("U")){
					updateVoList.add(listVos[i]);
				}			
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addNetworkCostExceptionList(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyNetworkCostExceptionList(updateVoList);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	/**
	 * ESM_MAS_0190 - Save-delete<br>
	 * @param NetworkCostExceptionListVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multidelNetworkCostExceptionList(NetworkCostExceptionListVO[] listVos, SignOnUserAccount account) throws EventException {
		List<NetworkCostExceptionListVO> deleteVoList = new ArrayList<NetworkCostExceptionListVO>();
		try {
			for ( int i=0; i < listVos.length; i++ ) {
				listVos[i].setCreUsrId(account.getUsr_id());
				listVos[i].setUpdUsrId(account.getUsr_id());
				
				if ( listVos[i].getIbflag().equals("D")){
					deleteVoList.add(listVos[i]); // delt_flg가 "N"에서 "Y"가 됨.
				}			
			}
						
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeNetworkCostExceptionList(deleteVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Sheet Auto Set<br>
	 * ESM_MAS_0190
	 * @param networkCostExceptionListVO
	 * @return List<NetworkCostExceptionListVO>
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	@Override
	public List<NetworkCostExceptionListVO> searchComBoCdListCdNm0190(NetworkCostExceptionListVO networkCostExceptionListVO) throws EventException {
		try{
			return dbDao.searchComBoCdListCdNm0190(networkCostExceptionListVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * ESM_MAS_0191 조회<br>
	 * @param MASCreateMonitorVO mASCreateMonitorVO
	 * @return List<MASCreateMonitorVO>
	 * @exception EventException
	 */
	public List<MASCreateMonitorVO> searchMASCreateMonitor(MASCreateMonitorVO mASCreateMonitorVO) throws EventException {
		try {
			return dbDao.searchMASCreateMonitor(mASCreateMonitorVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

    
    /**
     * ESM_MAS_0336 조회<br>
     * @param SearchConditionVO searchConditionVO
     * @return List<GNAExpCreByOfcVO>
     * @exception EventException
     */
    public List<GNAExpCreByOfcVO> searchGNAExpCreByOfcList(SearchConditionVO searchConditionVO) throws EventException {
        try {
            searchConditionVO.setFCostYrmon(searchConditionVO.getFCostYrmon().replaceAll("-", ""));

            return dbDao.searchGNAExpCreByOfcList(searchConditionVO);
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(),ex);
        }
    }
 
    
    /**
     * ESM_MAS_0336 - Creation <br>
     * @param SearchConditionVO searchConditionVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public EventResponse createGNAExpCreByOfc(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
         try {
             searchConditionVO.setFCostYrmon(searchConditionVO.getFCostYrmon().replaceAll("-", ""));

           dbDao.removeGNAExpCreByOfc(searchConditionVO);
           dbDao.createGNAExpCreByOfc(searchConditionVO,account);

           GeneralEventResponse eventResponse = new GeneralEventResponse();
           return eventResponse; // "SUCCESS"
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }   
    
    /**
     * ESM_MAS_0336 G&A Expense Creation by Office - Save<br>
     * @param GNAExpCreByOfcVO[] listVos
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void multiGNAExpCreByOfc(GNAExpCreByOfcVO[] listVos, SignOnUserAccount account) throws EventException {
        try {
            List<GNAExpCreByOfcVO> updateVoList = new ArrayList<GNAExpCreByOfcVO>();
 
            
            for ( int i=0; i<listVos .length; i++ ) {
                if ( listVos[i].getIbflag().equals("U")){
                    listVos[i].setUpdUsrId(account.getUsr_id());
                    updateVoList.add(listVos[i]);
                }
            }
            
            if ( updateVoList.size() > 0 ) {
                dbDao.modifyGNAExpCreByOfc(updateVoList);
            }

        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
    
    

    
    /**
     * ESM_MAS_0337 조회<br>
     * @param SearchConditionVO searchConditionVO
     * @return List<GNAExpAssignVO>
     * @exception EventException
     */
    public List<GNAExpAssignVO> searchGNAExpAssignList(SearchConditionVO searchConditionVO) throws EventException {
        try {
            return dbDao.searchGNAExpAssignList(searchConditionVO);
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(),ex);
        }
    }
 
    
    /**
     * ESM_MAS_0337 - Creation <br>
     * @param SearchConditionVO searchConditionVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public EventResponse createGNAExpAssign(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
         try {
           dbDao.removeGNAExpAssign(searchConditionVO);
           dbDao.createGNAExpAssign(searchConditionVO,account);

           GeneralEventResponse eventResponse = new GeneralEventResponse();
           return eventResponse; // "SUCCESS"
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }   
    
    /**
     * ESM_MAS_0337 - Save <br>
     * @param MasGenExpnAsgnVO masGenExpnAsgnVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageGNAExpAssign(MasGenExpnAsgnVO[] masGenExpnAsgnVOs, SignOnUserAccount account) throws EventException {
         try {
             List<MasGenExpnAsgnVO> updateVoList = new ArrayList<MasGenExpnAsgnVO>();
             
             for ( int i=0; i<masGenExpnAsgnVOs.length; i++ ) {
                 if ( masGenExpnAsgnVOs[i].getIbflag().equals("U")){
                     masGenExpnAsgnVOs[i].setUpdUsrId(account.getUsr_id());
                     updateVoList.add(masGenExpnAsgnVOs[i]);
                 }
             }
             
             if ( updateVoList.size() > 0 ) {
                 dbDao.manageGNAExpAssign(updateVoList);
             }
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }  
    
	
}
