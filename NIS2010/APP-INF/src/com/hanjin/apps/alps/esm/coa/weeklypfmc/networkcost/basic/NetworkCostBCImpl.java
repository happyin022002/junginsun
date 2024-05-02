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
 * 2010.10.22 이행지 [CHM-201006375-01][COA] Trunk IPC와 Ocean간 내부거래 신규 추가
 * 2011.02.21 김상수 [CHM-201108827-01] * R.month/Week 및 OPR/OPR2 정보 보여주는 칼럼 추가
 *                                      * 불필요하게 사용된 VO에 관련된 소스제거
 * 2011.03.23 최성민 [CHM-201109616-01]  * Bunker Fee (PA)화면에서 사용하는 COA_BNK_TRF 테이블에 COST_WK 컬럼이 추가
 *                                     * Load Excel, Create 기능 추가
 * 2011.06.16 최성민 [CHM-201111497-01] COA 운항일수 산정 로직 변경 - ESM_COA_0034 생성
 * 2011.07.07 이석준 [CHM-201111498-01] PSO와 연계하여 VVD,TERMINAL별로 TARIFF 직접 수정및 PSO I/F 추가
 * 2011.12.23 최성민 [CHM-201114896-01] [COA] CM2 추가 개발 요청
 * 2012.01.31 김종준 [CHM-201215754-01] SEL에서 대상항차 선택 후, VVD Send를 누르면 해당 대상항차를 FCM 시스템으로 전송 etc.
 * 2012.02.07 김종준 소스 품질 결과 - 사전 검토 결과 조치
 * 2012.07.05 이석준 [CHM-201218728-01] Dailyhire by Cht-VSL (PA) Create 기능 추가
 * 2012.08.14 이석준 [CHM-201219592-01] AVG-hire by Own-VSL (PA) 화면에 Load excel 기능 추가
 * 2013.05.08 성미영 [CHM-201324182] Daily Hire by Cht-VSL / AVG hire by Own VSL / SMU 단가 화면 전월 copy 기능 추가 
 * 2013.06.26 박찬민 [CHM-201325163] [COA] Network Cost by VVD - Network Cost 탭 Creation 관련 CSR
 =========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.Utils;
import com.hanjin.apps.alps.esm.coa.common.vo.ProcedureParamVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration.NetworkCostDBDAO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.AverageUCVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.LaneTable1CycleVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchAverageUCListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchBunkerTariffListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchDailyHire2MonthCountVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchDailyHireListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchFixCostByVVDInterPrcListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchFixCostByVVDListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchFixCostByVVDOP4ListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchIntervalTransitTimeListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchMissingStatusListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchNWCreListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchNWCreRStatusListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchOptFixedCostListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffDetailListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchSltChtrCreListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchSltChtrCreRStatusListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration.WeeklyCMDBDAO;
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
import com.hanjin.syscommon.common.table.CoaBnkTrfVO;
import com.hanjin.syscommon.common.table.CoaInterPrcUtCostVO;
import com.hanjin.syscommon.common.table.CoaLaneTsBsaCmmtVO;
import com.hanjin.syscommon.common.table.CoaMonVvdPortOpDysVO;
import com.hanjin.syscommon.common.table.CoaNtwkCostCreVO;
import com.hanjin.syscommon.common.table.CoaOpAvgUtCostVO;
import com.hanjin.syscommon.common.table.CoaOwnVslDlyHirVO;
import com.hanjin.syscommon.common.table.CoaSltChtrInfoVO;
import com.hanjin.syscommon.common.table.CoaUtCostCreStsVO;

/**
 * eNIS-COA Business Logic Basic Command implementation<br>
 * - eNIS-COA에 대한 비지니스 로직을 처리한다.<br>
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
	 * 1. 기능 : 구간별 운항일수 및 비율생성 화면에 대한 조회 이벤트 처리(ESM_COA_039)<p>
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
	 * 1. 기능 : 구간별 운항일수 및 비율생성 화면에 대한 저장 이벤트 처리(ESM_COA_039)<p>
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
	 * @param CoaMonVvdPortOpDysVO[] coaMonVvdPortOpDysVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse multiIntervalTransitTime(CoaMonVvdPortOpDysVO[] coaMonVvdPortOpDysVOs, SignOnUserAccount account) throws EventException{
        try{
            List<CoaMonVvdPortOpDysVO> multiList        = new ArrayList<CoaMonVvdPortOpDysVO>();

            if(coaMonVvdPortOpDysVOs.length > 0){
                for(int i = 0 ; i < coaMonVvdPortOpDysVOs.length ; i++){
                	coaMonVvdPortOpDysVOs[i].setUpdUsrId(account.getUse_flg());

                	multiList.add(coaMonVvdPortOpDysVOs[i]);
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
	 * 1. 기능 : Port Class별 Tariff 조회/변경 화면에 대한 조회 이벤트 처리(ESM_COA_040)<p>
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
	 * 1. 기능 : Port Tariff 조회/변경 화면에 대한 조회 이벤트 처리(ESM_COA_0181)<p>
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
	 * 1. 기능 : Port Class별 Tariff 조회/변경 화면에 대한 멀티 이벤트 처리(ESM_COA_040)<p>
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
                	
                	if ("N".equals(searchPortTariffListVOs[i].getCostSts())) continue; //COA에도 없고, PSO에도 create되지 않은 경우는 저장하지 않는다.
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
	 * 1. 기능 : Port Class별 Tariff 조회/변경 화면에 대한 멀티 이벤트 처리(ESM_COA_040)<p>
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

			boolean save_ind=true; // 화면에서 넘어온 데이터중 COA쪽 Data의 합이 0인 포트가 하나라고 있으면 SAVE 불가능
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
	 * 1. 기능 : 연료비 조회/변경 화면에 대한 조회 이벤트 처리(ESM_COA_041)<p>
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
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @return List<SearchBunkerTariffListVO>
	 * @exception EventException
	 */
	public List<SearchBunkerTariffListVO> searchBunkerTariffList(SearchConditionVO searchVo, NetworkCostCommonVO vo) throws EventException {
		try {
			List<SearchBunkerTariffListVO> list = null;		
			String[] arrSearch = searchVo.getFYearweek().split("[-]");

            HashMap<String, String> qParam = new HashMap<String, String>();
            qParam.put("sls_yrmon"     , arrSearch[0]);
            qParam.put("cost_wk"       , arrSearch[1]);
            qParam.put("slan_cd"       , JSPUtil.getNull(searchVo.getFSelslane()));
            qParam.put("rlane_cd"      , JSPUtil.getNull(searchVo.getFSelrlane()));
            qParam.put("vsl_clss_capa" , JSPUtil.getNull(searchVo.getFSelclass()));
            vo.setIndirectColumnValues(qParam);

            HashMap<String, Object> vParam = new HashMap<String, Object>();
            vParam.put("yrType", searchVo.getFYrtype());
            vParam.put("slan_cd"       , JSPUtil.getNull(searchVo.getFSelslane()));
            vParam.put("rlane_cd"      , JSPUtil.getNull(searchVo.getFSelrlane()));
            vParam.put("vsl_clss_capa" , JSPUtil.getNull(searchVo.getFSelclass()));

	        vo.setIndirectVariableValues(vParam);

			list = dbDao.searchBunkerTariffList(vo);

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
	 * Bunker Fee (PA) 엑셀 업로드시 데이터 존재 유무 확인한다.
	 * 
	 * @param CoaBnkTrfVO[] coaBnkTrfVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<CoaBnkTrfVO>
	 * @exception EventException
	 */
	public List<CoaBnkTrfVO> searchBunkerTariffCount(CoaBnkTrfVO[] coaBnkTrfVO, SearchConditionVO searchConditionVO) throws EventException{
		
		try {
			List<CoaBnkTrfVO> list = new ArrayList<CoaBnkTrfVO>();
			CoaBnkTrfVO vo = null;
			CoaBnkTrfVO rowVo = null;

			//Row 별 조회
			for ( int i=0; i<coaBnkTrfVO.length; i++ ) {				
				vo = dbDao.searchBunkerTariffCount(coaBnkTrfVO[i], searchConditionVO);
				
				if (vo == null) {
					rowVo = new CoaBnkTrfVO();
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
	 * 1. 기능 : 연료비 조회/변경 화면에 대한 멀티 이벤트 처리(ESM_COA_041)<p>
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
	 * @param CoaBnkTrfVO[] vos
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse multiBunkerTariff(SearchConditionVO searchVo, NetworkCostCommonVO vo, CoaBnkTrfVO[] vos, String userId) throws EventException{
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
	 * 1. 기능 : Header 정보를 조회한다.(ESM_COA_043)<p>
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

			String headerCD = "";
			String headerNM = "";

			List<NetworkCostCommonVO> list = new ArrayList<NetworkCostCommonVO>();
			int size = retList.size();
			for(int i=0; i<size; i++){
				headerCD = headerCD + ((SearchOptFixedCostListVO)(retList.get(i))).getStndCostCd();
				headerNM = headerNM + ((SearchOptFixedCostListVO)(retList.get(i))).getStndCostNm();

				if(i != (size-1)){
					headerCD = headerCD + "|";
					headerNM = headerNM + "|";
				}
			}

			NetworkCostCommonVO tempVo = new NetworkCostCommonVO();
			tempVo.setHeaderCD(headerCD);
			tempVo.setHeaderNM(headerNM);
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
	 * 1. 기능 : 시선 일당 고정비 관리 화면에 대한 조회 이벤트 처리(ESM_COA_043)<p>
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
	 * 1. 기능 : 시선 일당 고정비 관리화면에 대한 멀티 이벤트 처리(ESM_COA_043)<p>
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
	 * @param CoaOwnVslDlyHirVO[] vos
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOwnDailyHire(SearchConditionVO searchVo, NetworkCostCommonVO vo, CoaOwnVslDlyHirVO[] vos, String userId) throws EventException{
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
	 * ESM_COA_0042 화면에 대한 멀티 이벤트 처리<br>
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
            if(vo.getEventName().equals("EsmCoa0110Event")){
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
            if(vo.getEventName().equals("EsmCoa0110Event")){
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
            if(vo.getEventName().equals("EsmCoa0110Event")){
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
            if(vo.getEventName().equals("EsmCoa0110Event")){
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
	 * @param CoaNtwkCostCreVO[] coaNtwkCostCreVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
    public String createNWCreForVVD(SearchConditionVO searchConditionVO, CoaNtwkCostCreVO[] coaNtwkCostCreVOs, SignOnUserAccount account) throws EventException{
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

				List<CoaNtwkCostCreVO> createList = new ArrayList<CoaNtwkCostCreVO>();

	            // COA_NTWK_COST_CRE 테이블 Setting
	            //----------------------------------------------------

	            if(coaNtwkCostCreVOs.length > 0){
	                for(int i = 0 ; i < coaNtwkCostCreVOs.length ; i++){
	                	coaNtwkCostCreVOs[i].setCreUsrId(inUserId);
	                	coaNtwkCostCreVOs[i].setUpdUsrId(inUserId);
	                	coaNtwkCostCreVOs[i].setCreSlctFlg(Utils.change10ToYN(coaNtwkCostCreVOs[i].getCreSlctFlg()));

	                    createList.add(coaNtwkCostCreVOs[i]);
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
	 * @param CoaSltChtrInfoVO[] coaSltChtrInfoVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse createSltChtrCre(SearchConditionVO searchConditionVO, CoaSltChtrInfoVO[] coaSltChtrInfoVOs, SignOnUserAccount account) throws EventException{
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

	            //COA_SLT_CHTR_INFO 테이블 Setting
	            //----------------------------------------------------
				List<CoaSltChtrInfoVO> createList = new ArrayList<CoaSltChtrInfoVO>();
	            if(coaSltChtrInfoVOs.length > 0){
	                for(int i = 0 ; i < coaSltChtrInfoVOs.length ; i++){

	                	coaSltChtrInfoVOs[i].setCreSlctFlg(Utils.change10ToYN(coaSltChtrInfoVOs[i].getCreSlctFlg()));
	                	coaSltChtrInfoVOs[i].setCreUsrId(inUserId);
	                	coaSltChtrInfoVOs[i].setUpdUsrId(inUserId);

	                	createList.add(coaSltChtrInfoVOs[i]);
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
            if(vo.getEventName().equals("EsmCoa0114Event")){

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
			//  dbDao.modifyAverageUC(coaOpAvgUtCostVO);
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
            //2.COA_OP_AVG_UT_COST테이블에서  TARGET 해당월을 삭제한다.
            dbDao.removeAverageUC(averageUCVO);
            //3.Raw Data 생성
            dbDao.createAverageRawMonthCopy(param);
            //4.COA_OP_AVG_UT_COST테이블에  SOURCE 해당월을 복사해서  TARGET 데이타를 생성한다.
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
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiLaneDetail(LaneTable1CycleVO[] laneTable1CycleVOs, SignOnUserAccount account) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<LaneTable1CycleVO> insertVoList = new ArrayList<LaneTable1CycleVO>();
			List<LaneTable1CycleVO> updateVoList = new ArrayList<LaneTable1CycleVO>();
			List<LaneTable1CycleVO> deleteVoList = new ArrayList<LaneTable1CycleVO>();
			
			for ( int i=0; i<laneTable1CycleVOs .length; i++ ) {
				if ( laneTable1CycleVOs[i].getIbflag().equals("I")){
					laneTable1CycleVOs[i].setCreUsrId(account.getUsr_id());
					laneTable1CycleVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(laneTable1CycleVOs[i]);
				} else if ( laneTable1CycleVOs[i].getIbflag().equals("U")){
					laneTable1CycleVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(laneTable1CycleVOs[i]);
				} else if ( laneTable1CycleVOs[i].getIbflag().equals("D")){
					deleteVoList.add(laneTable1CycleVOs[i]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addLaneDetail(insertVoList);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyLaneDetail(updateVoList);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteLaneDetail(deleteVoList);
			}
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
	 * @return List<CoaInterPrcUtCostVO>
	 * @exception EventException
	 */
	public List<CoaInterPrcUtCostVO> searchTrunkIPCPricing(SearchConditionVO searchConditionVO) throws EventException {
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
	 * @param CoaInterPrcUtCostVO[] coaInterPrcUtCostVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTrunkIPCPricing(CoaInterPrcUtCostVO[] coaInterPrcUtCostVOs, SignOnUserAccount account) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CoaInterPrcUtCostVO> insertVoList = new ArrayList<CoaInterPrcUtCostVO>();
			List<CoaInterPrcUtCostVO> updateVoList = new ArrayList<CoaInterPrcUtCostVO>();
			List<CoaInterPrcUtCostVO> deleteVoList = new ArrayList<CoaInterPrcUtCostVO>();
			for ( int i=0; i<coaInterPrcUtCostVOs .length; i++ ) {
				if ( coaInterPrcUtCostVOs[i].getIbflag().equals("I")){
					coaInterPrcUtCostVOs[i].setCreUsrId(account.getUsr_id());
					coaInterPrcUtCostVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(coaInterPrcUtCostVOs[i]);
				} else if ( coaInterPrcUtCostVOs[i].getIbflag().equals("U")){
					coaInterPrcUtCostVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(coaInterPrcUtCostVOs[i]);
				} else if ( coaInterPrcUtCostVOs[i].getIbflag().equals("D")){
					deleteVoList.add(coaInterPrcUtCostVOs[i]);
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
					out_err_msg = new ErrorHandler("COA00025", out_err_msg).getMessage();
//        			throw new DAOException(new ErrorHandler("COA00025",out_err_cd).getMessage());
        			throw new DAOException(new ErrorHandler("COA00025",out_err_cd).getMessage());
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
    		CoaBnkTrfVO coaBnkTrfVO = new CoaBnkTrfVO();		
    		String[] tYearWk = searchConditionVO.getFYearweek().split("[-]");
    		
    		coaBnkTrfVO.setCostYrmon(tYearWk[0]);
    		coaBnkTrfVO.setCostWk(tYearWk[1]);
    		coaBnkTrfVO.setCreUsrId(account.getUsr_id());
    		coaBnkTrfVO.setUpdUsrId(account.getUsr_id());
    		
    		dbDao.createBunkerTariff(coaBnkTrfVO);
    		
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
			CoaLaneTsBsaCmmtVO coaLaneTsBsaCmmtVO = new CoaLaneTsBsaCmmtVO();
			coaLaneTsBsaCmmtVO.setCostYrmon(costYrmon);
			coaLaneTsBsaCmmtVO.setCreUsrId(account.getUsr_id());

			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, searchConditionVO.getFTarMon().replaceAll("-", ""));
            param.put("user_id"   		, account.getUsr_id());

          //1.COA_LANE_TS_BSA_CMMT테이블에서  TARGET 해당월을 삭제한다.
            dbDao.removeBSACommitmentMonth(coaLaneTsBsaCmmtVO);
          //2.COA_LANE_TS_BSA_CMMT테이블에  SOURCE 해당월을 복사해서  TARGET 데이타를 생성한다.
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
	 * @param CoaMonVvdPortOpDysVO[] coaMonVvdPortOpDysVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void multiLaneTransitTime(CoaMonVvdPortOpDysVO[] coaMonVvdPortOpDysVOs, SignOnUserAccount account) throws EventException{
        try{
            List<CoaMonVvdPortOpDysVO> multiList = new ArrayList<CoaMonVvdPortOpDysVO>();

            if(coaMonVvdPortOpDysVOs.length > 0){
                for(int i = 0 ; i < coaMonVvdPortOpDysVOs.length ; i++){
                	coaMonVvdPortOpDysVOs[i].setUpdUsrId(account.getUse_flg());

                	multiList.add(coaMonVvdPortOpDysVOs[i]);
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
	 * @param CoaOpAvgUtCostVO[] coaOpAvgUtCostVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiAverageCM2(SearchConditionVO searchConditionVO, CoaOpAvgUtCostVO[] coaOpAvgUtCostVOs, SignOnUserAccount account) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<CoaOpAvgUtCostVO> multiList = new ArrayList<CoaOpAvgUtCostVO>();

		try {
			String costYrMon = searchConditionVO.getFCostYrmon().replaceAll("-", "");
			if(coaOpAvgUtCostVOs.length > 0){
				for(int i = 0 ; i < coaOpAvgUtCostVOs.length ; i++){
	            	if(coaOpAvgUtCostVOs[i].getIbflag().equals("I") || coaOpAvgUtCostVOs[i].getIbflag().equals("U")) {
	            		coaOpAvgUtCostVOs[i].setCostYrmon(costYrMon);
	            		coaOpAvgUtCostVOs[i].setCreUsrId(account.getUsr_id());
	            		coaOpAvgUtCostVOs[i].setCostUseTpCd(searchConditionVO.getFCostUseTpCd());

	            		multiList.add(coaOpAvgUtCostVOs[i]);
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
			CoaOpAvgUtCostVO coaOpAvgUtCostVO = new CoaOpAvgUtCostVO();
			coaOpAvgUtCostVO.setCostYrmon(costYrmon);
			coaOpAvgUtCostVO.setCreUsrId(account.getUsr_id());
			coaOpAvgUtCostVO.setUpdUsrId(account.getUsr_id());
			coaOpAvgUtCostVO.setCostUseTpCd(searchConditionVO.getFCostUseTpCd());

          //1.interface테이블에 BSA정보 업데이트한다.
          //  dbDao.modifyAverageUC(coaOpAvgUtCostVO);
          //2.COA_OP_AVG_UT_COST테이블에서 해당월을 삭제한다.
          //  dbDao.removeAverageUC(coaOpAvgUtCostVO);
          //3.COA_OP_AVG_UT_COST테이블에 데이타를 생성한다.
            dbDao.createAverageCM2(coaOpAvgUtCostVO);

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
	 * @return List<CoaUtCostCreStsVO>
	 * @exception EventException
	 */
	public List<CoaUtCostCreStsVO> searchAverageUCStatus(SearchConditionVO searchConditionVO)  throws EventException {
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
	
	
}





