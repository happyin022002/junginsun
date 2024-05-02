 /*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkCostDBDAO.java
 *@FileTitle : Network Cost DBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-13
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-11-13 kimyoungchul
 * 1.0 최초 생성
 * =========================================================
 * History
 * 2008.04.22 박칠서 N200803130011  월간 대상항차/고정비 관련 수정
 * 2008.06.17 박칠서 N200805276924  Lane Transit Time에서 Port 정보,
                                    Calling Terminal Matrix에서 CY 정보를 가져옴
 * 2009.04.01 박은주 N200903160170  Port Tariff(PA)기능 변경
 * 2009.04.01 김종열 N200903170121  Port Tariff(PA)기능 변경
                                   -조회(searchPortTariffList)와 생성(createPortTariff) 분리
 * 2009.04.30 김종열 N200904300311,N200904300150  장비비 관련 계정 삭제, OPR2는 HJS를 Default로 변경, OPR1과 OPR2는 and 조건으로 변경
 * 2009.09.30 김기대 0041 화면 New FrameWork 적용
 * 2009.09.30 김기대 0042 화면 New FrameWork 적용
 * 2009.09.30 김기대 0043 화면 New FrameWork 적용
 * 2009.09.30 김기대 0029 화면 New FrameWork 적용
 * 2009.09.30 김기대 0039 화면 New FrameWork 적용
 * 2009.09.30 김기대 0110 화면 New FrameWork 적용
 * 2009.09.30 김기대 0114 화면 New FrameWork 적용
 * 2010.01.04  최인경 0174   화면 ALPS 적용하여 새로 화면추가
 * 2010.01.11 김기식 0175 화면 New FrameWork 적용
 * 2010.02.05 임옥영 품질검토 결과 반영
 * 2010.05.06 이행지 CHM-201003663-Port tariff vessel class 변경
 * 2010.10.22 이행지 [CHM-201006375-01][COA] Trunk IPC와 Ocean간 내부거래 신규 추가
 * 2011.02.21 김상수 [CHM-201108827-01] * R.month/Week 및 OPR/OPR2 정보 보여주는 칼럼 추가
 * 2011.03.23 최성민 [CHM-201109616-01] * Bunker Fee (PA)화면에서 사용하는 COA_BNK_TRF 테이블에 COST_WK 컬럼이 추가
 *                                     * Load Excel, Create 기능 추가
 * 2011.06.16 최성민 [CHM-201111497-01] COA 운항일수 산정 로직 변경
 * 2011.07.07 이석준 [CHM-201111498-01] PSO와 연계하여 VVD,TERMINAL별로 TARIFF 직접 수정및 PSO I/F 추가
 * 2011.12.23 최성민 [CHM-201114896-01] [COA] CM2 추가 개발 요청
 * 2012.01.31 김종준 [CHM-201215754-01] SEL에서 대상항차 선택 후, VVD Send를 누르면 해당 대상항차를 FCM 시스템으로 전송 etc.
 * 2012.02.07 김종준 소스 품질 결과 - 사전 검토 결과 조치
 * 2012.07.05 이석준 [CHM-201218728-01] Dailyhire by Cht-VSL (PA) Create 기능 추가
 * 2012.08.14 이석준 [CHM-201219592-01] AVG-hire by Own-VSL (PA) 화면에 Load excel 기능 추가 
 * 2013.05.08 성미영 [CHM-201324182] AVG-hire by Own-VSL (PA), Dailyhire by Cht-VSL (PA) 전월 COPY 기능 추가
 =========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.coa.common.vo.ProcedureParamVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.basic.NetworkCostBCImpl;
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
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaBnkTrfVO;
import com.hanjin.syscommon.common.table.CoaInterPrcUtCostVO;
import com.hanjin.syscommon.common.table.CoaLaneTsBsaCmmtVO;
import com.hanjin.syscommon.common.table.CoaMonVvdPortOpDysVO;
import com.hanjin.syscommon.common.table.CoaNtwkCostCreVO;
import com.hanjin.syscommon.common.table.CoaOpAvgUtCostVO;
import com.hanjin.syscommon.common.table.CoaSltChtrInfoVO;
import com.hanjin.syscommon.common.table.CoaUtCostCreStsVO;



/**
 * eNIS-COA에 대한 DB 처리를 담당<br>
 * - eNIS-COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author kimyoungchul
 * @see NetworkCostBCImpl 참조
 * @since J2EE 1.4
 */
public class NetworkCostDBDAO extends DBDAOSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 9087872133738930570L;

	/**
     *  목록을 가져온다.<br>
     *
     * @param SearchConditionVO searchConditionVO
     * @return List<SearchIntervalTransitTimeListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchIntervalTransitTimeListVO> searchIntervalTransitTimeList(SearchConditionVO searchConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchIntervalTransitTimeListVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(searchConditionVO == null) return null;

            param.putAll(searchConditionVO.getColumnValues());
            velParam.putAll(searchConditionVO.getColumnValues());
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchIntervalTransitTimeListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchIntervalTransitTimeListVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }


    /**
     * COA_PORT_TARIFF 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
     *
     * @param  List<CoaMonVvdPortOpDysVO> multiList
     * @throws DAOException
     */
	public void multiIntervalTransitTime(List<CoaMonVvdPortOpDysVO> multiList) throws DAOException {
        int updCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(multiList != null ){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiIntervalTransitTimeUSQL(), multiList, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
     * COA_PORT_TARIFF 목록을 생성한다.
     *
     * @param SearchConditionVO searchConditionVO
     * @param SignOnUserAccount account
     * @throws DAOException
     */
	public void createPortTariff(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws DAOException {
        int insCnt = 0;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(searchConditionVO != null){
                param.putAll(searchConditionVO.getColumnValues());
                velParam.putAll(searchConditionVO.getColumnValues());

                param.put("cre_usr_id", account.getUsr_id());
                param.put("upd_usr_id", account.getUsr_id());

                insCnt = sqlExe.executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreatePortTariffCSQL(), param, velParam);
                if(insCnt == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to createPortTariff SQL");
            }
        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    /**
     * COA_PORT_TARIFF 목록을 조회한다.
     *
     * @param SearchConditionVO searchConditionVO
     * @return List<SearchPortTariffListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchPortTariffListVO> searchPortTariffList(SearchConditionVO searchConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchPortTariffListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(searchConditionVO == null) return null;

            param.putAll(searchConditionVO.getColumnValues());
            velParam.putAll(searchConditionVO.getColumnValues());
            if(searchConditionVO.getFYrtype().equals("M")){
            	velParam.put("apply", Integer.parseInt(searchConditionVO.getFYear()+searchConditionVO.getFFmMon()));
            } else {
            	velParam.put("apply", Integer.parseInt(searchConditionVO.getFYear()+searchConditionVO.getFFmWk()));
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchPortTariffListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPortTariffListVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * COA_PORT_TARIFF 목록을 조회한다.
     *
     * @param SearchConditionVO searchConditionVO
     * @return List<SearchPortTariffDetailListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchPortTariffDetailListVO> searchPortTariffDetailList(SearchConditionVO searchConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchPortTariffDetailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(searchConditionVO == null) return null;

            param.putAll(searchConditionVO.getColumnValues());
            velParam.putAll(searchConditionVO.getColumnValues());

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchPortTariffDetailListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPortTariffDetailListVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * COA_PORT_TARIFF 데이타를 삽입한다.<br>
     *
     * @param  List<SearchPortTariffDetailListVO> createList
     * @throws DAOException
     */
    public void addPortTariffDetail(List<SearchPortTariffDetailListVO> createList) throws DAOException {
        int insCnt[] = null;
        try{
            if(createList.size() > 0){
                insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiPortTariffDetailCSQL(), createList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
                log.error("err " + se.toString(), se);
                log.error(se.getMessage(),se);
                throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    /**
     * COA_PORT_TARIFF 데이타를 수정한다.<br>
     *
     * @param  List<SearchPortTariffListVO> modifyList
     * @throws DAOException
     */
    public void modifyPortTariff( List<SearchPortTariffListVO> modifyList) throws DAOException {
        int insCnt[] = null;

        try{
            if(modifyList.size()> 0){
                insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiPortTariffUSQL(), modifyList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
                log.error("err " + se.toString(), se);
                log.error(se.getMessage(),se);
                throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    /**
     * COA_PORT_TARIFF 데이타를 수정한다.<br>
     *
     * @param  List<SearchPortTariffDetailListVO> modifyList
     * @throws DAOException
     */
    public void modifyPortTariffDetail(List<SearchPortTariffDetailListVO> modifyList) throws DAOException {
        int insCnt[] = null;

        try{
            if(modifyList.size() > 0){
                insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiPortTariffDetailUSQL(), modifyList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
                log.error("err " + se.toString(), se);
                log.error(se.getMessage(),se);
                throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    /**
     * COA_PORT_TARIFF 데이타를 수정한다.<br>
     *
     * @param  List<SearchPortTariffListVO> removeList
     * @throws DAOException
     */
    public void removePortTariff(List<SearchPortTariffListVO> removeList) throws DAOException {
        int insCnt[] = null;

        try{
            if(removeList.size() > 0){
                insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiPortTariffDSQL(), removeList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to remove No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
                log.error("err " + se.toString(), se);
                log.error(se.getMessage(),se);
                throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    
	/**
	 * [COA_BUNKER_TARIFF] 존재유무를 [조회] 합니다.<br>
	 *
	 * @param  CoaBnkTrfVO coaBnkTrfVO
     * @param  SearchConditionVO searchConditionVO
     * @return CoaBnkTrfVO
     * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CoaBnkTrfVO searchBunkerTariffCount(CoaBnkTrfVO coaBnkTrfVO, SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoaBnkTrfVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(coaBnkTrfVO != null){	
				Map<String, String> mapVO = coaBnkTrfVO .getColumnValues();
				
				param.putAll(mapVO);
	            velParam.put("f_yrtype", searchConditionVO.getFYrtype()); 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchBunkerTariffCountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaBnkTrfVO .class);
					
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		if (list == null || list.size() <= 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

    /**
     * COA_BUNKER_TARIFF 목록을 조회한다.
     *
     * @param  NetworkCostCommonVO vo
     * @return List<SearchBunkerTariffListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchBunkerTariffListVO> searchBunkerTariffList(NetworkCostCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchBunkerTariffListVO> list = null;
        try{

            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchBunkerTariffListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBunkerTariffListVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * COA_BUNKER_TARIFF 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
     *
     * @param  NetworkCostCommonVO vo
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public void multiBunkerTariff(NetworkCostCommonVO vo) throws DAOException {
        int saveCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiSaveList().size() > 0){
                saveCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiBunkerTariffCSQL(), vo.getMultiSaveList(), null);
                for(int i = 0; i < saveCnt.length; i++){
                    if(saveCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
     * COA_BUNKER_TARIFF 한주차에 2개월이 공존하는 경우 조사
     *
     * @param  NetworkCostCommonVO vo
     * @return List<SearchDailyHire2MonthCountVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<SearchDailyHire2MonthCountVO> searchDailyHire2MonthCount(NetworkCostCommonVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyHire2MonthCountVO> list = null;
		try{
			if(vo == null) return null;
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchDailyHire2MonthCountRSQL(), vo.getIndirectQueryParameter(), null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDailyHire2MonthCountVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err " + se.toString(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err " + ex.toString(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


    /**
     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
     *
     * @param NetworkCostCommonVO vo
     * @return List<SearchDailyHireListVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<SearchDailyHireListVO> searchDailyHireList(NetworkCostCommonVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyHireListVO> list = null;
		try{
			if(vo == null) return null;
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchDailyHireListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDailyHireListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err " + se.toString(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err " + ex.toString(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


    /**
     * NetworkCost의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
     *
     * @param NetworkCostCommonVO vo
     * @see ESM_COA_042Event
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public void multiDailyHire(NetworkCostCommonVO vo) throws DAOException {
        int insCnt[] = null;
        int updCnt[] = null;
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiCreateList().size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiDailyHireCSQL(), vo.getMultiCreateList(), null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }

            if(vo.getMultiUpdateList().size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiDailyHireUSQL(), vo.getMultiUpdateList(), null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
        	log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
        	log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }


    /**
     * COA_STND_ACCT 에서 고정비 항목을 조회한다.
     *  Operation Fixed Cost
     *
     * @param NetworkCostCommonVO vo
     * @return List<SearchOptFixedCostListVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<SearchOptFixedCostListVO> searchOptFixedCostList(NetworkCostCommonVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOptFixedCostListVO> list = null;
		try{
			if(vo == null) return null;
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchOptFixedCostListRSQL(), vo.getQueryParameter(), vo.getVelocityParameter());
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOptFixedCostListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err " + se.toString(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err " + ex.toString(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

    /**
     * COA_OWN_VSL_DLY_HIR 목록을 조회한다.
     *
     * @param  NetworkCostCommonVO vo
     * @return NetworkCostCommonVO
     * @throws DAOException
     */
	public NetworkCostCommonVO searchOwnDailyHireList(NetworkCostCommonVO vo) throws DAOException {
		DBRowSet dbRowset = null;
        NetworkCostCommonVO retVo = null;
		try{
			if(vo == null) return null;
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchOwnDailyHireListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            retVo = new NetworkCostCommonVO();
			retVo.setRowSet(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err " + se.toString(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err " + ex.toString(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVo;
	}

    /**
     * COA_OWN_VSL_DLY_HIR 목록을 조회한다.
     *
     * @param  NetworkCostCommonVO vo
     * @return NetworkCostCommonVO
     * @throws DAOException
     */
	public NetworkCostCommonVO searchOwnDHireByClassList(NetworkCostCommonVO vo) throws DAOException {
		DBRowSet dbRowset = null;
        NetworkCostCommonVO retVo = null;
		try{
			if(vo == null) return null;
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchOwnDHireByClassListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            retVo = new NetworkCostCommonVO();
			retVo.setRowSet(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err " + se.toString(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err " + ex.toString(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVo;
	}

    /**
     * COA_OWN_VSL_DLY_HIR 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
     *
     * @param  NetworkCostCommonVO vo
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public void multiOwnDailyHire(NetworkCostCommonVO vo) throws DAOException {
        int insCnt[] = null;
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiCreateList().size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiOwnDailyHireCSQL(), vo.getMultiCreateList(), null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
        	log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
        	log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 사용 프로그램 : ESM_COA_0044
     *
     * @param SearchConditionVO searchConditionVO
     * @return List<SearchFixCostByVVDListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchFixCostByVVDListVO> searchFixCostByVVDList(SearchConditionVO searchConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchFixCostByVVDListVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.putAll(searchConditionVO.getColumnValues());
			velParam.putAll(searchConditionVO.getColumnValues());

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchFixCostByVVDListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFixCostByVVDListVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 사용 프로그램 : ESM_COA_0110
     *
     * @param NetworkCostCommonVO vo
     * @return List<SearchNWCreListVO>
     * @throws DAOException
    */
    @SuppressWarnings("unchecked")
	public List<SearchNWCreListVO> searchNWCreList(NetworkCostCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchNWCreListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchNWCreListRSQL(), null, null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNWCreListVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 사용 프로그램 : ESM_COA_0110
     *
     * @param  NetworkCostCommonVO vo
     * @return List<SearchNWCreRStatusListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchNWCreRStatusListVO> searchNWCreRStatusList(NetworkCostCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchNWCreRStatusListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchNWCreRStatusListRSQL(), null, null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNWCreRStatusListVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * COA_NTWK_COST_CRE를 DB에 반영한다.(삭제, 추가)<br>
     * 사용 프로그램 : ESM_COA_0110
     *
     * @param List<CoaNtwkCostCreVO> createList
     * @throws DAOException
     */
    public void multiNWCreForVVD(List<CoaNtwkCostCreVO> createList) throws DAOException {
        int insCnt[] = null;
        int delCnt = 0;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");

            if(createList != null ){
                // COA_NTWK_COST_CRE 테이블 전체 삭제
                delCnt = sqlExe.executeUpdate((ISQLTemplate)new NetworkCostDBDAOMultiNWCreForVVDDSQL(), null, null);
                    if(delCnt== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete SQL");
                // 화면에 조회된 사항을 테이블에 삽입..
                insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiNWCreForVVDCSQL(), createList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }


// ******************************************************************
//    [중요]ALPS변환 작업중 사용 안함으로 판단 주석 처리 ---> 2009.09.22
// ******************************************************************
//    /**
//     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
//     * 사용 프로그램 : ESM_COA_110
//     *
//     * @param et Event
//     * @return void
//     * @throws DAOException
//     */
//    public void createNWCreForVVD(Event et) throws DAOException {
//        if (et == null) {
//            return;
//        }
//
//        Connection con = null; // Connection Interface
//        CallableStatement cs = null; // 정적파싱을 지원하는 SQL Statement
//        int i = 1; // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//
//        ESM_COA_110Event event = (ESM_COA_110Event) et;
//        int resultCount = 0; // 수행 결과가 정상인지를 판별하기 위한 변수
//        String err_cd  = ""; //에러코드
//        String err_msg = ""; //에러메시지
//
//        String txtYear     = event.getString("txtYear");
//        String txtFmWeek   = event.getString("txtFmWeek");
//        String cobTrade    = event.getCobTrade();
//        String cobLane     = event.getCobLane();
//        String cobDir      = event.getCobDir();
//        String txtVessel   = event.getTxtVessel();
//        String txtVoyage   = event.getTxtVoyage();
//        String txtDir      = event.getTxtDir();
//
//        String strYear = txtYear;
//        String strWeek = txtFmWeek;
//        String strDir  = cobDir;
//        if (cobDir.trim().equals("")) {
//            strDir = txtDir;
//        }
//
//        StringBuffer strBuf = new StringBuffer();
//        strBuf.append("CALL COA_CREATE_NTCOST_PRC(?,?,?,?,?,?,?, ?,?,?) ");
//
//        try {
//            con = getConnection();
//
//            // Loggable Statement 사용에 의해 추가 ??
//            cs = con.prepareCall(strBuf.toString());
//
//            if (cobTrade == null) cobTrade = "";
//            if (cobLane == null) cobLane = "";
//            if (cobDir == null) cobDir = "";
//            if (txtVessel == null) txtVessel = "";
//            if (txtVoyage == null) txtVoyage = "";
//            if (txtDir == null) txtDir = "";
//
//            String user_id = event.getUserId();
//
//            // 쿼리에 변수 세팅.
//            cs.setString(i++, strYear);
//            cs.setString(i++, strWeek);
//            cs.setString(i++, cobTrade);
//            cs.setString(i++, cobLane);
//            cs.setString(i++, txtVessel);
//            cs.setString(i++, txtVoyage);
//            cs.setString(i++, strDir);
//
//            cs.setString(i++, user_id);
//
//            int out_param = i;
//
//            cs.registerOutParameter(i++, Types.VARCHAR);
//            cs.registerOutParameter(i++, Types.VARCHAR);
//
//            log.info("\n PROCEDURE : " + strBuf.toString() +
//                     "\n IN Param (1) : " + strYear +
//                     "\n IN Param (2) : " + strWeek +
//                     "\n IN Param (3) : " + cobTrade +
//                     "\n IN Param (4) : " + cobLane +
//                     "\n IN Param (5) : " + txtVessel +
//                     "\n IN Param (6) : " + txtVoyage +
//                     "\n IN Param (7) : " + strDir +
//                     "\n IN Param (8) : " + user_id);
//
//            resultCount = cs.executeUpdate();
//
//            err_cd  = cs.getString(out_param++);
//            err_msg = cs.getString(out_param++);
//
//            log.info("\n >>>>>>>>>>>> 생성결과(resultCount) = " + resultCount);
//            log.info("\n PROCEDURE : " + strBuf.toString() +
//             "\n OUT Param (err_cd)  : " + err_cd +
//             "\n OUT Param (err_msg) : " + err_msg);
//
//
//            event.setErrorCode(err_cd);
//            event.setErrorMsg(err_msg);
//
//      if (!err_cd.equals("00000")) {
//                String[] errMessage = {err_cd,err_msg};
//                throw new DAOException(new ErrorHandler("COA00025",errMessage).getMessage());
//      }
//        } catch (SQLException se) {
//            log.error("SQLException " + se.getMessage(), se);
//            throw new DAOException(new ErrorHandler(se).getMessage());
//        } catch (DAOException de) {
//      if (!err_cd.equals("00000")) {
//        log.error("정보:: ErrorHandler에 의한 DAOException 입니다. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> \n");
//      }
//            log.error("DAOException " + de.getMessage(), de);
//            throw de;
//        } catch (Exception e) {
//            log.error("Exception " + e.getMessage(), e);
//            throw new DAOException(e.getMessage());
//        } finally {
//            closeStatement(cs);
//            closeConnection(con);
//        }
//    }

    /**
     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 사용 프로그램 : ESM_COA_0110
     *
     * @param NetworkCostCommonVO vo
     * @return List<SearchSltChtrCreListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SearchSltChtrCreListVO> searchSltChtrCreList(NetworkCostCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchSltChtrCreListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchSltChtrCreListRSQL(), null, null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSltChtrCreListVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 사용 프로그램 : ESM_COA_0110
     *
     * @param  NetworkCostCommonVO vo
     * @return List<SearchSltChtrCreRStatusListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SearchSltChtrCreRStatusListVO> searchSltChtrCreRStatusList(NetworkCostCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchSltChtrCreRStatusListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchSltChtrCreRStatusListRSQL(), null, null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSltChtrCreRStatusListVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * COA_SLT_CHTR_INFO를 DB에 반영한다.(삭제, 추가)<br>
     * 사용 프로그램 : ESM_COA_0110
     *
     * @param List<CoaSltChtrInfoVO> createList
     * @throws DAOException
     */
    public void multiSltChtrCre(List<CoaSltChtrInfoVO> createList) throws DAOException {
        int insCnt[] = null;
        int delCnt = 0;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");

            if(createList != null && createList.size() > 0){
            	// COA_SLT_CHTR_INFO 전체삭제
	            delCnt = sqlExe.executeUpdate((ISQLTemplate)new NetworkCostDBDAOMultiSltChtrCreDSQL(), null, null);

                if(delCnt== Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL.");

	            // 조회된 내용으로 COA_SLT_CHTR_INFO 삽입
                insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiSltChtrCreCSQL(), createList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

// ******************************************************************
//  [중요]ALPS변환 작업중 사용 안함으로 판단 주석 처리 ---> 2009.09.22
//******************************************************************
//    /**
//     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
//     * 사용 프로그램 : ESM_COA_110
//     *
//     * @param et Event
//     * @return void
//     * @throws DAOException
//     */
//    public void createSltChtrCre(Event et) throws DAOException {
//        if (et == null) {
//            return;
//        }
//
//        Connection con = null; // Connection Interface
//        CallableStatement cs = null; // 정적파싱을 지원하는 SQL Statement
//        int i = 1; // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//
//        ESM_COA_110Event event = (ESM_COA_110Event) et;
//        int resultCount = 0; // 수행 결과가 정상인지를 판별하기 위한 변수
//        String err_cd  = ""; //에러코드
//        String err_msg = ""; //에러메시지
//
//        String txtYear     = event.getString("txtYear");
//        String txtFmWeek   = event.getString("txtFmWeek");
//        String cobTrade    = event.getCobTrade();
//        String cobLane     = event.getCobLane();
//        String cobDir      = event.getCobDir();
//        String txtVessel   = event.getTxtVessel();
//        String txtVoyage   = event.getTxtVoyage();
//        String txtDir      = event.getTxtDir();
//
//        String strYear = txtYear;
//        String strWeek = txtFmWeek;
//        String strDir = cobDir;
//        if (cobDir.trim().equals("")) {
//            strDir = txtDir;
//        }
//
//        StringBuffer strBuf = new StringBuffer();
//        strBuf.append("CALL COA_CREATE_SPC_CHT_PRC(?,?,?,?,?,?,?, ?,?,?) ");
//
//        try {
//            con = getConnection();
//
//            // Loggable Statement 사용에 의해 추가 ??
//            cs = con.prepareCall(strBuf.toString());
//
//            if (cobTrade == null) cobTrade = "";
//            if (cobLane == null) cobLane = "";
//            if (cobDir == null) cobDir = "";
//            if (txtVessel == null) txtVessel = "";
//            if (txtVoyage == null) txtVoyage = "";
//            if (txtDir == null) txtDir = "";
//
//            String user_id = event.getUserId();
//
//            // 쿼리에 변수 세팅.
//            cs.setString(i++, strYear);
//            cs.setString(i++, strWeek);
//            cs.setString(i++, cobTrade);
//            cs.setString(i++, cobLane);
//            cs.setString(i++, txtVessel);
//            cs.setString(i++, txtVoyage);
//            cs.setString(i++, strDir);
//
//            cs.setString(i++, user_id);
//
//            int out_param = i;
//
//            cs.registerOutParameter(i++, Types.VARCHAR);
//            cs.registerOutParameter(i++, Types.VARCHAR);
//
//            log.info("\n PROCEDURE : " + strBuf.toString() +
//             "\n IN Param (1) : " + strYear +
//             "\n IN Param (2) : " + strWeek +
//             "\n IN Param (3) : " + cobTrade +
//             "\n IN Param (4) : " + cobLane +
//             "\n IN Param (5) : " + txtVessel +
//             "\n IN Param (6) : " + txtVoyage +
//             "\n IN Param (7) : " + strDir +
//             "\n IN Param (8) : " + user_id);
//
//            resultCount = cs.executeUpdate();
//
//            err_cd  = cs.getString(out_param++);
//            err_msg = cs.getString(out_param++);
//
//            log.info("\n >>>>>>>>>>>> 생성결과(resultCount) = " + resultCount);
//            log.info("\n PROCEDURE : " + strBuf.toString() +
//             "\n OUT Param (err_cd)  : " + err_cd +
//             "\n OUT Param (err_msg) : " + err_msg);
//
//
//            event.setErrorCode(err_cd);
//            event.setErrorMsg(err_msg);
//
//      if (!err_cd.equals("00000")) {
//                String[] errMessage = {err_cd,err_msg};
//                throw new DAOException(new ErrorHandler("COA00025",errMessage).getMessage());
//      }
//        } catch (SQLException se) {
//            log.error("SQLException " + se.getMessage(), se);
//            throw new DAOException(new ErrorHandler(se).getMessage());
//        } catch (DAOException de) {
//      if (!err_cd.equals("00000")) {
//        log.error("정보:: ErrorHandler에 의한 DAOException 입니다. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> \n");
//      }
//            log.error("DAOException " + de.getMessage(), de);
//            throw de;
//        } catch (Exception e) {
//            log.error("Exception " + e.getMessage(), e);
//            throw new DAOException(e.getMessage());
//        } finally {
//            closeStatement(cs);
//            closeConnection(con);
//        }
//    }

    /**
     * Missing List<br>
     * 사용 프로그램 : ESM_COA_0114
     *
     * @param NetworkCostCommonVO vo
     * @return List<SearchMissingStatusListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SearchMissingStatusListVO> searchMissingStatusList(NetworkCostCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchMissingStatusListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchMissingStatusListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMissingStatusListVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * Average U/C 조회<br>
     * 사용 프로그램 : ESM_COA_0174
     *
     * @param AverageUCVO averageUCVO
     * @return List<AverageUCVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AverageUCVO> searchAverageUCList(AverageUCVO averageUCVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<AverageUCVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(averageUCVO != null){
            	param.putAll(averageUCVO.getColumnValues());
            	velParam.putAll(averageUCVO.getColumnValues());
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOAverageUCRSQL(), param, velParam);
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, AverageUCVO.class);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }


    /**
     * Average U/C Raw Data 조회<br>
     * 사용 프로그램 : ESM_COA_0174
     *
     * @param AverageUCVO averageUCVO
     * @return List<AverageUCVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AverageUCVO> searchAverageUCRawList(AverageUCVO averageUCVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<AverageUCVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(averageUCVO != null){
            	param.putAll(averageUCVO.getColumnValues());
            	velParam.putAll(averageUCVO.getColumnValues());
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOAverageUCRawRSQL(), param, velParam);
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, AverageUCVO.class);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
  
	/**
	 * [Average U/C] 정보를 [삽입] 합니다.<br>
	 *
	 * @param List<AverageUCVO> insertVoList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addAverageUC(List<AverageUCVO> insertVoList) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOAverageUCCSQL(), insertVoList,null);
				for(int i = 0; i < insCnt.length; i++){  
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	/**
	 * [Average U/C] 정보를 [수정] 합니다.<br>
	 *
	 * @param List<AverageUCVO> updateVoList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyAverageUC(List<AverageUCVO> updateVoList) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOAverageUCUSQL(), updateVoList,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}

	/**
	 * [Average U/C] 정보를 [삭제] 합니다.<br>
	 *
	 * @param List<AverageUCVO> deleteVoList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] deleteAverageUC(List<AverageUCVO> deleteVoList) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOAverageUCDSQL(), deleteVoList,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}

	/**
	 * interface테이블에 BSA정보 업데이트한다..
	 *
	 * @param  CoaOpAvgUtCostVO coaOpAvgUtCostVO
	 * @throws DAOException
	 */
	public void modifyAverageUC(CoaOpAvgUtCostVO coaOpAvgUtCostVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
        	if( coaOpAvgUtCostVO != null ){
        		param.putAll(coaOpAvgUtCostVO.getColumnValues());
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOModifyAverageUCUSQL(), param, null);
        	}

            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

	}

	/**
	 * COA_OP_AVG_UT_COST테이블에서 해당월을 삭제한다.
	 *
	 * @param AverageUCVO averageUCVO
	 * @throws DAOException
	 */
	public void removeAverageUC(AverageUCVO averageUCVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
        	if( averageUCVO != null ){
        		param.putAll(averageUCVO.getColumnValues());
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAORemoveAverageUCDSQL(), param, null);
        	}

            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

	}
	

	/**
	 * COA_OP_AVG_UT_COST테이블에서 해당월을 삭제한다.
	 *
	 * @param AverageUCVO averageUCVO
	 * @throws DAOException
	 */
	public void removeAverageUCRaw(AverageUCVO averageUCVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
        	if( averageUCVO != null ){
        		param.putAll(averageUCVO.getColumnValues());
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateAverageUCRawDSQL(), param, null);
        	}

            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

	}


	/**
	 * Average UC단가를 생성한다.(OA_OP_AVG_UT_COST테이블에 데이타를 생성한다)
	 *
	 * @param  AverageUCVO averageUCVO
	 * @throws DAOException
	 */
	public void createAverageUC(AverageUCVO averageUCVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
        	if( averageUCVO != null ){
        		param.putAll(averageUCVO.getColumnValues());
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateAverageUCCSQL(), param, null);
        	}

            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

	}
	

	/**
	 * Average UC단가를 생성한다.(OA_OP_AVG_UT_COST테이블에 데이타를 생성한다)
	 *
	 * @param  AverageUCVO averageUCVO
	 * @throws DAOException
	 */
	public void addAverageUCRaw(AverageUCVO averageUCVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
        	if( averageUCVO != null ){
        		param.putAll(averageUCVO.getColumnValues());
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateAverageUCRawCSQL(), param, null);
        	}

            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

	}

	/**
	 * Average UC 월단가를 복사해서 생성한다.
	 *
	 * @param  HashMap<String, String> map
	 * @throws DAOException
	 */
	public void createAverageMonthCopy(HashMap<String, String> map) throws DAOException {
//		int saveCnt = 0;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");
//            saveCnt = sqlExe.executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateAverageMonthCopyCSQL(), map, null);
            sqlExe.executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateAverageMonthCopyCSQL(), map, null);

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	

	/**
	 * Average UC Raw Data 월단가를 복사해서 생성한다.
	 *
	 * @param  HashMap<String, String> map
	 * @throws DAOException
	 */
	public void createAverageRawMonthCopy(HashMap<String, String> map) throws DAOException {

        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateAverageRawMonthCopyCSQL(), map, null);

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	

	/**
	 * Average UC Status정보를 복사해서 생성한다.
	 *
	 * @param  HashMap<String, String> map
	 * @throws DAOException
	 */
	public void createAverageStatusMonthCopy(HashMap<String, String> map) throws DAOException {

        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateAverageStatusMonthCopyCSQL(), map, null);

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}

	/**
     * NetworkCost의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 사용 프로그램 : ESM_COA_0175
     * @param SearchConditionVO searchConditionVO
     * @return List<SearchFixCostByVVDOP4ListVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
    public List<SearchFixCostByVVDOP4ListVO> searchFixCostByVVDOP4List(SearchConditionVO searchConditionVO) throws DAOException {
        /*
		-- 순서, 계정, TITLE
		--01 - 54100000 "|Crew \nExpense"
		--02 - 54250000 "|Insurance"
		--03 - 54200000 "|Store Supply \nExpense"
		--04 - 54300000 "|Lubricant \nExpense"
		--05 - 54150000 "|Vessel \nM&R"
		--06 - 54450000 "|Depreciations"
		--07 - 54180000 "|Telecom \nExpense"
		--08 - 54550000 "|Other Operation \nFixed Exp"
		--09 - 54350000 "|Time \nCharterage"
		--10 - 54400000 "|Space \nCharterage"
		--11 - 43102011 "|Space \nCHT Revenue"
		--12 - 53101000 "|Port \nExpense"
		--13 - 53102000 "|Canal \nTransit Fee"
		--14 - 53200000 "|Bunker\nExpanse"
		*/
    	DBRowSet dbRowset = null;
        List<SearchFixCostByVVDOP4ListVO> list = null;

        //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			param.putAll(searchConditionVO.getColumnValues());
			velParam.putAll(searchConditionVO.getColumnValues());

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchFixCostByVVDOP4ListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFixCostByVVDOP4ListVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}

    /**
	 * [Lane Detail] 정보를 [조회] 합니다.<br>
	 *
     * @param LaneTable1CycleVO LaneTable1CycleVO
	 * @return List<LaneTable1CycleVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<LaneTable1CycleVO> searchLaneDetailList(LaneTable1CycleVO LaneTable1CycleVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LaneTable1CycleVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.putAll(LaneTable1CycleVO.getColumnValues());
        	velParam.putAll(LaneTable1CycleVO.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOLaneTable1CycleRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LaneTable1CycleVO .class);
			
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * [Lane Detail] 정보를 [삽입] 합니다.<br>
	 *
	 * @param List<LaneTable1CycleVO> insertVoList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addLaneDetail(List<LaneTable1CycleVO> insertVoList) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOLaneTable1CycleCSQL(), insertVoList,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	/**
	 * [Lane Detail] 정보를 [수정] 합니다.<br>
	 *
	 * @param List<LaneTable1CycleVO> updateVoList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyLaneDetail(List<LaneTable1CycleVO> updateVoList) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOLaneTable1CycleUSQL(), updateVoList,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}

	/**
	 * [Lane Detail] 정보를 [삭제] 합니다.<br>
	 *
	 * @param List<LaneTable1CycleVO> deleteVoList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] deleteLaneDetail(List<LaneTable1CycleVO> deleteVoList) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOLaneTable1CycleDSQL(), deleteVoList,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}

	/**
	 * [Trunk IPC Internal Pricing 단가] 정보를 [조회] 합니다.<br>
	 *
	 * @param String cost_yrmon
	 * @return List<CoaInterPrcUtCostVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CoaInterPrcUtCostVO> searchTrunkIPCPricing(String cost_yrmon) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoaInterPrcUtCostVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("f_cost_yrmon", cost_yrmon);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchTrunkIPCPricingRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaInterPrcUtCostVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [Trunk IPC Internal Pricing 단가] 정보를 [삽입] 합니다.<br>
	 *
	 * @param List<CoaInterPrcUtCostVO> insertVoList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addTrunkIPCPricing(List<CoaInterPrcUtCostVO> insertVoList) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiTrunkIPCPricingCSQL(), insertVoList,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * [Trunk IPC Internal Pricing 단가] 정보를 [수정] 합니다.<br>
	 *
	 * @param List<CoaInterPrcUtCostVO> updateVoList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyTrunkIPCPricing(List<CoaInterPrcUtCostVO> updateVoList) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiTrunkIPCPricingUSQL(), updateVoList,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * [Re-Assignment by Bound(Internal Pricing)] 정보를 [조회] 합니다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchFixCostByVVDInterPrcListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchFixCostByVVDInterPrcListVO> searchFixCostByVVDInterPrcList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchFixCostByVVDInterPrcListVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.putAll(searchConditionVO.getColumnValues());
			velParam.putAll(searchConditionVO.getColumnValues());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchFixCostByVVDInterPrcListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFixCostByVVDInterPrcListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [Re-Assignment by Bound(Internal Pricing)] 정보를 [조회] 합니다.<br>
	 *
	 * @param ProcedureParamVO procedureParamVO
	 * @return ProcedureParamVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ProcedureParamVO createFixCostByVVDInterPrc(ProcedureParamVO procedureParamVO) throws DAOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
    	ProcedureParamVO resultVO = new ProcedureParamVO();

		try{
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new NetworkCostDBDAOCreateFixCostByVVDInterPrcCSQL(), procedureParamVO.getColumnValues(), null);

        	if (resultMap != null) {
        		resultVO.setOutErrCd((String) resultMap.get("out_err_cd"));
        		resultVO.setOutErrMsg((String) resultMap.get("out_err_msg"));
        	}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultVO;
	}

	/**
	 * [Bunker Fee 정보]을 생성합니다.<br>
	 *
	 * @param  CoaBnkTrfVO coaBnkTrfVO
	 * @throws DAOException
	 */
	public void createBunkerTariff(CoaBnkTrfVO coaBnkTrfVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = coaBnkTrfVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateBunkerTariffCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * COA_LANE_TS_BSA_CMMT 테이블에서 해당월을 삭제한다.
	 *
	 * @param CoaLaneTsBsaCmmtVO coaLaneTsBsaCmmtVO
	 * @throws DAOException
	 */
	public void removeBSACommitmentMonth(CoaLaneTsBsaCmmtVO coaLaneTsBsaCmmtVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
        	if( coaLaneTsBsaCmmtVO != null ){
        		param.putAll(coaLaneTsBsaCmmtVO.getColumnValues());
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetWorkCostDBDAOCoaLaneTsBsaCmmtVODSQL(), param, null);
        	}

            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

	}
	

	/**
	 * COA_LANE_TS_BSA_CMMT 테이블에서 월단가를 복사해서 생성한다.
	 *
	 * @param  HashMap<String, String> map
	 * @throws DAOException
	 */
	public void createBSACommitmentMonthCopy(HashMap<String, String> map) throws DAOException {
		
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate)new NetWorkCostDBDAOCoaLaneTsBsaCmmtCopyCSQL(), map, null);

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	
    
	/**
	 * [Lane Transit Time] 정보를 [조회] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
     * @return List<SearchIntervalTransitTimeListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchIntervalTransitTimeListVO> searchLaneTransitTimeList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchIntervalTransitTimeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOCoaMonVvdPortOpDysVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchIntervalTransitTimeListVO.class);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

    /**
     * Lane Transit Time 2 정보를 저장한다.<br>
     *
     * @param  List<CoaMonVvdPortOpDysVO> multiList
     * @throws DAOException
     */
	public void multiLaneTransitTime(List<CoaMonVvdPortOpDysVO> multiList) throws DAOException {
        int updCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(multiList != null ){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkCostDBDAOCoaMonVvdPortOpDysVOUSQL(), multiList, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }
            }
        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
	

    /**
     * Average U/C (CM2) 를 조회한다. (ESM_COA_0182)<br>
     *
     * @param SearchConditionVO searchConditionVO
     * @return List<SearchAverageUCListVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchAverageUCListVO> searchAverageCM2List(SearchConditionVO searchConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchAverageUCListVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(searchConditionVO != null){
            	param.putAll(searchConditionVO.getColumnValues());
            	velParam.putAll(searchConditionVO.getColumnValues());
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOSearchAverageCM2ListRSQL(), param, velParam);
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAverageUCListVO.class);
            }
        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return list;
    }
    

    /**
	 * op_uc_amt값을 수정한다 (ESM_COA_0182)<br>
	 * 
	 * @param  List<CoaOpAvgUtCostVO> multiList
	 * @throws DAOException
	 */
	public void multiAverageCM2(List<CoaOpAvgUtCostVO> multiList) throws DAOException {
		int saveCnt[] = null;

        try{
            if(multiList.size() > 0){
                saveCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new NetworkCostDBDAOMultiAverageCM2CSQL(), multiList, null);
                for(int i = 0; i < saveCnt.length; i++){
                    if(saveCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

	/**
	 * Average UC (CM2) 단가를 생성한다.(OA_OP_AVG_UT_COST테이블에 데이타를 생성한다)
	 *
	 * @param  CoaOpAvgUtCostVO coaOpAvgUtCostVO
	 * @throws DAOException
	 */
	public void createAverageCM2(CoaOpAvgUtCostVO coaOpAvgUtCostVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
        	if( coaOpAvgUtCostVO != null ){
        		param.putAll(coaOpAvgUtCostVO.getColumnValues());
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateAverageCM2CSQL(), param, null);
        	}

            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	
	/**
     * 경리환율이 있는지 check하는 함수 (ESM_COA_0042)<br>
     *
     * @param String yyyymm
     * @return int
     * @throws DAOException
     */
	public int checkExchangeRate(String yyyymm) throws DAOException {
        DBRowSet dbRowset = null;
        int select_row = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(yyyymm != null){
            	param.put("f_yearweek", yyyymm);
            	velParam.put("f_yearweek", yyyymm);
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOCheckExchangeRateRSQL(), param, velParam);
	            select_row = dbRowset.getRowCount();
            }
            
        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return select_row;
    }
    
	/**
	 * Daily Hire I/F Table을 삭제 한다.
	 *
	 * @param String yyyymm
	 * @throws DAOException
	 */
	public void removeDailyHireIF(String yyyymm) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
            if(yyyymm != null){
            	param.put("f_yearweek", yyyymm);
            	
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAORemoveDailyHireIFDSQL(), param, null);
        	}

            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

	}
	
	/**
	 * Daily Hire I/F Table을 삭제 한다.
	 *
	 * @param String yyyymm
	 * @throws DAOException
	 */
	public void removeDailyHire(String yyyymm) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
            if(yyyymm != null){
            	param.put("f_yearweek", yyyymm);
            	
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAORemoveDailyHireDSQL(), param, null);
        	}

            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

	}
	
	/**
	 * FMS로부터 Daily Hire를 I/F 한다.
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void createDailyHireFromFMS(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
        	if( searchConditionVO != null ){
        		param.putAll(searchConditionVO.getColumnValues());
        		param.put("user_id", account.getUsr_id());
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateDailyHireFromFMSCSQL(), param, null);
        	}

            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * FMS로부터 I/F한 DailyHire를 COA 용선료 관리 Table로 입력한다.
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void createDailyHireFromIFTable(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
        	if( searchConditionVO != null ){
        		param.putAll(searchConditionVO.getColumnValues());
        		param.put("user_id", account.getUsr_id());
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateDailyHireFromIFTableCSQL(), param, null);
        	}

            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * DailyHire를 생성한뒤에 단가 관리 Table에 입력한다.
	 *
	 * @param HashMap<String, String> map
	 * @throws DAOException
	 */
	public void modifyDailyHireCreationStatus(HashMap<String, String> map) throws DAOException {

		int saveCnt = 0;

        try{
      		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOUpdateDailyHireCreationStatusUSQL(), map, null);
            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * 사선 고정비 CLASS별 평균값을 삭제한다
	 *
	 * @param String yyyymm
	 * @throws DAOException
	 */
	public void removeAverageOwnDailyHire(String yyyymm) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
            if(yyyymm != null){
            	param.put("f_yearweek", yyyymm);
            	
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOremoveAverageOwnDailyHireDSQL(), param, null);
        	}

            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

	}
	
	/**
	 * 사선 고정비 CLASS별 평균값을 생성한다
	 *
	 * @param String yyyymm
	 * @param String user_id
	 * @throws DAOException
	 */
	public void createAverageOwnDailyHire(String yyyymm,String user_id) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
            if(yyyymm != null){
            	param.put("f_yearweek", yyyymm);
            	param.put("user_id", user_id);
            	
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOcreateAverageOwnDailyHireCSQL(), param, null);
        	}

            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

	}


	/**
	 * Daily Hire FMS 테이블을 전월 copy 한다.
	 *
	 * @param HashMap<String, String> map
	 * @throws DAOException
	 */
	public void createDailyHireFromFMSMonthCopy(HashMap<String, String> map) throws DAOException {

		int saveCnt = 0;
		try{
		
			saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateDailyHireFromFMSMonthCopyCSQL(), map, null);
			
            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * FMS로부터 I/F한 DailyHire를 전월 Copy 한다.
	 *
	 * @param HashMap<String, String> map
	 * @throws DAOException
	 */
	public void createDailyHireFromIFTableMonthCopy(HashMap<String, String> map) throws DAOException {

		int saveCnt = 0;
        try{
       		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateDailyHireFromIFTableMonthCopyCSQL(), map, null);
            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	
	/**
	 * AVG hire by Own VSL 해당월 데이터를 삭제한다.
	 *
	 * @param String yyyymm
	 * @throws DAOException
	 */
	public void removeOwnDailyHire(String yyyymm) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
            if(yyyymm != null){
            	param.put("f_yearweek", yyyymm);
            	
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAORemoveOwnDailyHireDSQL(), param, null);
        	}

            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

	}	

	/**
	 * AVG hire by Own VSL 의 전월 데이터를 copy 한다.
	 *
	 * @param HashMap<String, String> map
	 * @throws DAOException
	 */
	public void createOwnDailyHireMonthCopy(HashMap<String, String> map) throws DAOException {

		int saveCnt = 0;
        try{
       		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOCreateOwnDailyHireMonthCopyCSQL(), map, null);
            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}	
	
	
	/**
	 * AVG hire by Own VSL 를 생성한뒤에 단가 관리 Table에 입력한다.
	 *
	 * @param HashMap<String, String> map
	 * @throws DAOException
	 */
	public void modifyOwnDailyHireCreationStatus(HashMap<String, String> map) throws DAOException {

		int saveCnt = 0;

        try{
      		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOModifyOwnDailyHireCreationStatusUSQL(), map, null);
            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}	
	
	
	/**
	 * [Lane Table] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param HashMap<String, String> map
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeLaneTableMonthCopy(HashMap<String, String> map) throws DAOException,Exception {
		
		int result = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new NetworkCostDBDAOLaneTable1CycleCopyDSQL(), map, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");
			
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * [Lane Table] 정보를 [복사] 합니다.<br>
	 * 
	 * @param HashMap<String, String> map
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addLaneTableMonthCopy(HashMap<String, String> map) throws DAOException,Exception {
		
		int result = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new NetworkCostDBDAOLaneTable1CycleCopyCSQL(), map, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");
			
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	 /**
     * Create Status<br>
     * 사용 프로그램 : ESM_COA_0174
     *
     * @param SearchConditionVO searchConditionVO
     * @return List<CoaUtCostCreStsVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<CoaUtCostCreStsVO> searchAverageUCStatus(SearchConditionVO searchConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<CoaUtCostCreStsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(searchConditionVO == null) return null;

            param.putAll(searchConditionVO.getColumnValues());
            velParam.putAll(searchConditionVO.getColumnValues());

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkCostDBDAOUnitCostCreationStatusRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaUtCostCreStsVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
	/**
	 * Average U/C Status Create
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyAverageUCStatus(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
        	if( searchConditionVO != null ){
        		param.putAll(searchConditionVO.getColumnValues());
        		param.put("user_id", account.getUsr_id());
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new NetworkCostDBDAOUnitCostCreationStatusUSQL(), param, null);
        	}

            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
}
