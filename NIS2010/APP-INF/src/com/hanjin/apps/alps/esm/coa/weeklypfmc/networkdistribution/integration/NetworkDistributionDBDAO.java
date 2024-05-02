/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkDistributionDBDAO.java
 *@FileTitle : Network Distribution DBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-28
 *@LastModifier : KimJongBeom
 *@LastVersion : 1.0
 * 2006-11-28 KimJongBeom
 * 1.0 최초 생성
 * 
 *=========================================================
 * History
 * 2008.07.22 박칠서 CSR No.N200807218174 Commercial Base U/C 화면 추가 (159번 화면)
 * 2008.07.22 전성진 CSR No.N200807218175 Commercial Base U/C 화면 추가 (159번 화면)
 * 2008.07.22 박칠서 CSR No.N200807180003 Commercial Base U/C 화면 추가 (159번 화면)
 * 2008.07.22 전윤주 CSR No.N200807218173 Commercial Base U/C 화면 추가 (159번 화면)
 * 2009.09.30 김기대 0045 화면 New FrameWork 적용
 * 2009.09.30 김기대 0047 화면 New FrameWork 적용
 * 2009.09.30 김기대 0125 화면 New FrameWork 적용
 * 2009.09.30 김기대 0106 화면 New FrameWork 적용
 * 2009.09.30 김기대 0154 화면 New FrameWork 적용
 * 2009.09.30 김기대 0159 화면 New FrameWork 적용
 * 2009.09.24 임옥영 Ticket ID:CHM-200900832 CNTR BU 수지분석 기준 변경(Vessel Pool 및 표준원가 반영)
 * 2009.12.09 최인경 Ticket ID:CHM-200901816 남북항로(SNT) 운항 변/고정비 배부를 위한 T/S Logic신규 개발 
 *                                           로 인한 TS ALLOCATION(SNT)화면(ESM_COA_176) 추가
 * 2009.      최인경 Ticket ID:CHM-200901632 INTRA ASIA 공급량 산출 LOGIC 변경 요청 - 유저의 요청으로 로직 변경 적용 안됨.
 *                                          추후 로직 요청시 테스트 수행 후 현재의 로직을 막고 주석처리된 로직으로 적용하여야 함. 
 * 2010.02.05 이행지 Ticket ID:CHM-201002501 남북항로 시스템 조회 기능 수정요청
 * 2010.02.10 박은주 Ticket ID:CHM-201002364 Vessel Pool 및 OP4 logic 보완 요청 
 * 2010.10.22 이행지 [CHM-201006375-01][COA] Trunk IPC와 Ocean간 내부거래 신규 추가 
 * 2013.01.29 서미진 [CHM-201322638] 한 주차만 생성 가능하던 로직을 여러 주차 생성 가능하도록 신규 배치 생성으로 변경
=========================================================*/

package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.coa.common.vo.ProcedureParamVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.basic.NetworkDistributionBCImpl;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.AllocResultCommitListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistNewListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistResultListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostSntListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchHJSSalesAmountListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchLaneTSCommitmentListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchLaneTSUnitCostListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchMissingStatusVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchSpcChtrRevMssListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.CoaFxAmtDtrbVO;
import com.hanjin.syscommon.common.table.CoaLaneRgstVO;
import com.hanjin.syscommon.common.table.CoaLaneTsBsaCmmtVO;
import com.hanjin.syscommon.common.table.CoaUtCostCreStsVO;

/**
 * WeeklyPFMC에 대한 DB 처리를 담당<br>
 * - WeeklyPFMC Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KimJongBeom
 * @see NetworkDistributionBCImpl 참조
 * @since J2EE 1.4
 */

public class NetworkDistributionDBDAO extends DBDAOSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -822031596983105338L;

	/**
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_COA_0045
	 * 
	 * @param SearchConditionVO searchVO
	 * @return List<SearchHJSSalesAmountListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchHJSSalesAmountListVO> searchHJSSalesAmountList(SearchConditionVO searchVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchHJSSalesAmountListVO> list = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
        	if ( searchVO != null ) {
	        	Map<String, String> map = searchVO.getColumnValues();
	        	
	        	param.putAll(map);
	        	velParam.putAll(map);
	        	
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchHJSSalesAmountListRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchHJSSalesAmountListVO.class);        		
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
	 * NetworkDistribution의 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_COA_0045
	 * 
	 * @param NetworkDistributionCommonVO vo
	 * @return List<SearchMissingStatusVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchMissingStatusVO> searchMissingStatus(NetworkDistributionCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchMissingStatusVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchMissingStatusRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMissingStatusVO.class);
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
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_COA_0047
	 * 
	 * @param SearchConditionVO searchVO
	 * @return List<SearchFixCostDistListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchFixCostDistListVO> searchFixCostDistList(SearchConditionVO searchVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchFixCostDistListVO> list = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
        	if ( searchVO != null ) {
	        	Map<String, String> map = searchVO.getColumnValues();
	        	
	        	param.putAll(map);
	        	velParam.putAll(map);
            	
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchFixCostDistListRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFixCostDistListVO.class);        		
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
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_COA_0050
	 * 
	 * @param SearchConditionVO searchVO
	 * @return List<SearchFixCostDistNewListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchFixCostDistNewListVO> searchFixCostDistNewList(SearchConditionVO searchVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchFixCostDistNewListVO> list = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
        	if ( searchVO != null ) {
	        	Map<String, String> map = searchVO.getColumnValues();
	        	
	        	param.putAll(map);
	        	velParam.putAll(map);
            	
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchFixCostDistNewListRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFixCostDistNewListVO.class);        		
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
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_COA_0106
	 * 
	 * @param NetworkDistributionCommonVO vo
	 * @return List<SearchFixCostDistResultListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchFixCostDistResultListVO> searchFixCostDistResultList(NetworkDistributionCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchFixCostDistResultListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchFixCostDistResultListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFixCostDistResultListVO.class);
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
	 * Allocation Results(Commitment base) 조회 <br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @return List<AllocResultCommitListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AllocResultCommitListVO> searchAllocResultCommitList(SearchConditionVO searchVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AllocResultCommitListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchVo != null){
				Map<String, String> mapVO = searchVo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOAllocResultCommitListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AllocResultCommitListVO .class);
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
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 생성한다.<br>
	 * - 사용 프로그램 : ESM_COA_0106,ESM_COA_0108
	 *
	 * @param NetworkDistributionCommonVO vo
	 * @throws DAOException
	 */
    public void applyToPL(NetworkDistributionCommonVO vo) throws DAOException {
        int insCnt [] = null;
        int insCnt2[] = null;
        int insCnt3[] = null;
        int updCnt[]  = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            //Space Charter Revenue를 제외한 총 고정비 비용을 PL Chart에 반영
            if(vo.getMultiCreateList() != null && vo.getMultiCreateList().size() > 0){
            	if (vo.getEventName().equals("EsmCoa0106Event")){
            		insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPL1CSQL(), vo.getMultiCreateList(), vo.getIndirectVelocityParameter());
            	}else if (vo.getEventName().equals("EsmCoa0108Event")){
            		insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPLOP51CSQL(), vo.getMultiCreateList(), vo.getIndirectVelocityParameter());
            	}
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
            
            //Space Chater Revenue및 BSA를 밀어넣기
            //Intra Isia 로직 반영 요청이 있으면 이 부분은 주석처리 하고 아래의 2개를 풀어서 적용하여야 함.
            if(vo.getMultiCreateList2() != null && vo.getMultiCreateList2().size() > 0){
            	if (vo.getEventName().equals("EsmCoa0106Event")){
            		insCnt2 = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPL2CSQL(), vo.getMultiCreateList2(), vo.getIndirectVelocityParameter());
            	}else if (vo.getEventName().equals("EsmCoa0108Event")){
            		insCnt2 = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPLOP52CSQL(), vo.getMultiCreateList2(), vo.getIndirectVelocityParameter());
            	}
                
                for(int i = 0; i < insCnt2.length; i++){
                    if(insCnt2[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
            
            //Intra Isia 로직 변경 후 Space Chater Revenue및 BSA를 밀어넣기
            //추후 유저의 요청이 있으면 테스트 완료가 된 로직이 아니기 때문에 충분한 테스트 후 
            //아래의 주석 2개를 풀어서 적용하여야 한다.
//            if(vo.getMultiCreateList2() != null && vo.getMultiCreateList2().size() > 0){
//                insCnt2 = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPL4CSQL(), vo.getMultiCreateList2(), vo.getIndirectVelocityParameter());
//                for(int i = 0; i < insCnt2.length; i++){
//                    if(insCnt2[i]== Statement.EXECUTE_FAILED)
//                        throw new DAOException("Fail to insert No"+ i + " SQL");
//                }
//            }
//            if(vo.getMultiCreateList2() != null && vo.getMultiCreateList2().size() > 0){
//                insCnt2 = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPL5CSQL(), vo.getMultiCreateList2(), vo.getIndirectVelocityParameter());
//                for(int i = 0; i < insCnt2.length; i++){
//                    if(insCnt2[i]== Statement.EXECUTE_FAILED)
//                        throw new DAOException("Fail to insert No"+ i + " SQL");
//                }
//            }
         
            //Special Lane에 대한 LOAD(수송량)을 BSA(공급량)으로 밀어넣기 
            if(vo.getMultiCreateList3() != null && vo.getMultiCreateList3().size() > 0){
            	if (vo.getEventName().equals("EsmCoa0106Event")){
            		insCnt3 = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPL3CSQL(), vo.getMultiCreateList3(), vo.getIndirectVelocityParameter());
            	}else if (vo.getEventName().equals("EsmCoa0108Event")){
            		insCnt3 = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPLOP53CSQL(), vo.getMultiCreateList3(), vo.getIndirectVelocityParameter());
            	}
            	
                
                for(int i = 0; i < insCnt3.length; i++){
                    if(insCnt3[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }            

            //
            if(vo.getMultiUpdateList() != null && vo.getMultiUpdateList().size() > 0){
            	if (vo.getEventName().equals("EsmCoa0106Event")){
            		updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPLUSQL(), vo.getMultiUpdateList(), vo.getIndirectVelocityParameter());
            	}else if (vo.getEventName().equals("EsmCoa0108Event")){
            		updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPLxUSQL(), vo.getMultiUpdateList(), vo.getIndirectVelocityParameter());
            	}
            	
                
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
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_COA_0125
	 * 
	 * @param SearchConditionVO vo
	 * @return List<SearchLaneTSCommitmentListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchLaneTSCommitmentListVO> searchLaneTSCommitmentList(SearchConditionVO vo) throws DAOException {
        DBRowSet dbRowset = null;
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();
         List<SearchLaneTSCommitmentListVO> list = null;
         try{
         	if( vo != null){
         		Map<String, String> mapVO = vo.getColumnValues();
         		param.putAll(mapVO);
         		velParam.putAll(mapVO);
         		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchLaneTSCommitmentListRSQL(), param, velParam);
                 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLaneTSCommitmentListVO.class);
         	}            
         }catch(SQLException se){
             log.error("err " + se.toString(), se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error("err " + ex.toString(), ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
    }	

	/**
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_COA_0159
	 * 
	 * @param NetworkDistributionCommonVO vo
	 * @return List<SearchLaneTSUnitCostListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchLaneTSUnitCostListVO> searchLaneTSUnitCostList(NetworkDistributionCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchLaneTSUnitCostListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchLaneTSUnitCostListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLaneTSUnitCostListVO.class);
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

	/*
	 * COA_BSA_CRR_INFO의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정)<br>
	 * 사용 프로그램 : ESM_COA_0125
	 * 
	 * @param NetworkDistributionCommonVO vo
	 * @throws DAOException
	 */
//    public void multiLaneTSCommitment(NetworkDistributionCommonVO vo) throws DAOException {
//        int insCnt[] = null;
//        int updCnt[] = null;
//        int delCnt[] = null;
//        try{
//            SQLExecuter sqlExe = new SQLExecuter("");
//            if(vo.getMultiCreateList() != null && vo.getMultiCreateList().size() > 0){
//                insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOMultiLaneTSCommitmentCSQL(), vo.getMultiCreateList(), null);
//                for(int i = 0; i < insCnt.length; i++){
//                    if(insCnt[i]== Statement.EXECUTE_FAILED)
//                        throw new DAOException("Fail to insert No"+ i + " SQL");
//                }
//            }
//
//            if(vo.getMultiUpdateList() != null && vo.getMultiUpdateList().size() > 0){
//                updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOMultiLaneTSCommitmentUSQL(), vo.getMultiUpdateList(), null);
//                for(int i = 0; i < updCnt.length; i++){
//                    if(updCnt[i]== Statement.EXECUTE_FAILED)
//                        throw new DAOException("Fail to update No"+ i + " SQL");
//                }
//            }
//
//            if(vo.getMultiDeleteList() != null && vo.getMultiDeleteList().size() > 0){
//                delCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOMultiLaneTSCommitmentDSQL(), vo.getMultiDeleteList(), null);
//                for(int i = 0; i < delCnt.length; i++){
//                    if(delCnt[i]== Statement.EXECUTE_FAILED)
//                        throw new DAOException("Fail to delete No"+ i + " SQL");
//                }
//            }
//        }catch (SQLException se) {
//            log.error("err " + se.toString(), se);
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage());
//        }catch(Exception ex){
//            log.error("err " + ex.toString(), ex);
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage());
//        }
//    }
    
	/**
	 * [Commitment BSA/Ratio] 정보를 [추가] 합니다.<br>
	 * 사용 프로그램 : ESM_COA_0125<br>
	 *
	 * @param List<CoaLaneTsBsaCmmtVO> createList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addLaneTSCommitment(List<CoaLaneTsBsaCmmtVO> createList) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(createList .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOMultiLaneTSCommitmentCSQL(), createList,null);
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
	 * [Commitment BSA/Ratio] 정보를 [수정] 합니다.<br>
	 * 사용 프로그램 : ESM_COA_0125<br>
	 *
	 * @param List<CoaLaneTsBsaCmmtVO> updateList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyLaneTSCommitment(List<CoaLaneTsBsaCmmtVO> updateList) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateList .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOMultiLaneTSCommitmentUSQL(), updateList,null);
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
	 * [Commitment BSA/Ratio] 정보를 [수정] 합니다.<br>
	 * 사용 프로그램 : ESM_COA_0125<br>
	 *
	 * @param List<CoaLaneTsBsaCmmtVO> deleteList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeLaneTSCommitment(List<CoaLaneTsBsaCmmtVO> deleteList) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteList .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOMultiLaneTSCommitmentDSQL(), deleteList,null);
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
	 * COA_BSA_CRR_INFO의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정)<br>
	 * 사용 프로그램 : ESM_COA_0159
	 * 
	 * @param NetworkDistributionCommonVO vo
	 * @throws DAOException
	 */
    public void multiLaneTSUnitCost(NetworkDistributionCommonVO vo) throws DAOException {
        int insCnt[] = null;
        int updCnt[] = null;
        int delCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiCreateList() != null && vo.getMultiCreateList().size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOMultiLaneTSUnitCostCSQL(), vo.getMultiCreateList(), null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }

            if(vo.getMultiUpdateList() != null && vo.getMultiUpdateList().size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOMultiLaneTSUnitCostUSQL(), vo.getMultiUpdateList(), null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }
            }

            if(vo.getMultiDeleteList() != null && vo.getMultiDeleteList().size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOMultiLaneTSUnitCostDSQL(), vo.getMultiDeleteList(), null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * Allocation Result 화면에서 PL Apply 시 Space Charter Revenue Missing 를 보여주는 화면.<br>
	 * 사용 프로그램 : ESM_COA_0153
	 * 
	 * @param NetworkDistributionCommonVO vo
	 * @return List<SearchSpcChtrRevMssListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchSpcChtrRevMssListVO> searchSpcChtrRevMssList(NetworkDistributionCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchSpcChtrRevMssListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchSpcChtrRevMssListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpcChtrRevMssListVO.class);
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
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 생성한다.<br>
	 * - 사용 프로그램 : ESM_COA_0106
	 *
	 * @param NetworkDistributionCommonVO vo
	 * @throws DAOException
	 */
    public void applyToPLOP4(NetworkDistributionCommonVO vo) throws DAOException {
        int insCnt [] = null;
        int insCnt2[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");

            //STEP1 기존 OP1의 데이터를 OP4 컬럼에 복사
            if(vo.getMultiCreateList() != null && vo.getMultiCreateList().size() > 0){
            	if (vo.getEventName().equals("EsmCoa0106Event")){
            		insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPLOP41CSQL(), vo.getMultiCreateList(), vo.getIndirectVelocityParameter());
            	}else if (vo.getEventName().equals("EsmCoa0108Event")){
            		insCnt = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPLOP61CSQL(), vo.getMultiCreateList(), vo.getIndirectVelocityParameter());
            	}
                
                //log.error("********cik-insCnt***********"+insCnt.length);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
            
            
            if(vo.getMultiCreateList2() != null && vo.getMultiCreateList2().size() > 0){
            	if (vo.getEventName().equals("EsmCoa0106Event")){
            		insCnt2 = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPLOP42CSQL(), vo.getMultiCreateList2(), vo.getIndirectVelocityParameter());
            	}else if (vo.getEventName().equals("EsmCoa0108Event")){
            		insCnt2 = sqlExe.executeBatch((ISQLTemplate)new NetworkDistributionDBDAOApplyToPLOP62CSQL(), vo.getMultiCreateList2(), vo.getIndirectVelocityParameter());
            	}
                
                //log.error("********cik-insCnt2***********"+insCnt2.length);
                for(int i = 0; i < insCnt2.length; i++){
                    if(insCnt2[i]== Statement.EXECUTE_FAILED)
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
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_COA_0176
	 * 
	 * @param SearchConditionVO searchVO
	 * @return List<SearchFixCostSntListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchFixCostSntListVO> searchFixCostSntList(SearchConditionVO searchVO) throws DAOException {
        DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        List<SearchFixCostSntListVO> list = null;
        try{
        	if( searchVO != null){
        		Map<String, String> mapVO = searchVO.getColumnValues();
        		param.putAll(mapVO);
        		velParam.putAll(mapVO);
        		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchFixCostSntListRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFixCostSntListVO.class);
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
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 사용 프로그램 : ESM_COA_0107
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<CoaFxAmtDtrbVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CoaFxAmtDtrbVO> searchAllocationResultInter(SearchConditionVO searchConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        List<CoaFxAmtDtrbVO> list = null;
        try{
        	if( searchConditionVO != null){
        		Map<String, String> mapVO = searchConditionVO.getColumnValues();
        		param.putAll(mapVO);
        		velParam.putAll(mapVO);
        		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchAllocationResultInterRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaFxAmtDtrbVO.class);
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
	 * Allocation Result(Internal Pricing) Create 이벤트 처리<br>
	 * 
	 * @param ProcedureParamVO procedureParamVO
	 * @return ProcedureParamVO
	 * @exception DAOException
	 */
	public ProcedureParamVO createAllocationResultInter(ProcedureParamVO procedureParamVO) throws DAOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
    	ProcedureParamVO resultVO = new ProcedureParamVO();
		
		try{
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new NetworkDistributionDBDAOCreateAllocationResultInterCSQL(), procedureParamVO.getColumnValues(), null);
        	
        	if ( resultMap != null) {
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
	 * NetworkDistribution의 데이타 모델에 해당되는 값을 생성한다.<br>
	 * - 사용 프로그램 : ESM_COA_0107
	 *
	 * @param ProcedureParamVO procedureParamVO
	 * @return ProcedureParamVO
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public ProcedureParamVO applyToPLInter(ProcedureParamVO procedureParamVO) throws DAOException {
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	ProcedureParamVO resultVO = new ProcedureParamVO();
		
		try{
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new NetworkDistributionDBDAOCreateAllocationResultInterCSQL(), procedureParamVO.getColumnValues(), null);
        	
        	if ( resultMap != null) {
        		resultVO.setOutErrCd((String) resultMap.get("out_err_cd"));
        		resultVO.setOutErrMsg((String) resultMap.get("out_err_msg"));
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
		return resultVO;
    }
    
	/**
	 * TS Allocation BATCH 가 실행중인지를 check 한다.
	 * 
	 * @return List<SearchHJSSalesAmountListVO>
	 * @throws DAOException
	 */
	public List<CoaUtCostCreStsVO> checkTsAllocationCreateBatchStatus() throws DAOException {
        DBRowSet dbRowset = null;
        List<CoaUtCostCreStsVO> list = null;
      //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
	        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOCheckTsAllocationCreateBatchStatusRSQL(), param, velParam);
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
	 * TS Allocation BATCH status 를 생성한다. <br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @throws DAOException
	 */
	public void addTSAllocationBatchStatus(SearchConditionVO searchConditionVO) throws DAOException {
      //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
        try{
        	if(searchConditionVO != null){
        		Map<String, String> mapVO = searchConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
        	}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new NetworkDistributionDBDAOAddTSAllocationBatchStatusCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
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
    }
	

	/**
	 * Revenue Lane 정보를 조회하다.<br>
	 * 사용 프로그램 : ESM_COA_0125
	 * 
	 * @param SearchConditionVO vo
	 * @return List<CoaLaneRgstVO>
	 * @throws DAOException
	 */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CoaLaneRgstVO> searchTradeDirbyLaneList(SearchConditionVO vo) throws DAOException {
        DBRowSet dbRowset = null;
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();
         List<CoaLaneRgstVO> list = null;
         try{
         	if( vo != null){
         		Map<String, String> mapVO = vo.getColumnValues();
         		param.putAll(mapVO);
         		velParam.putAll(mapVO);
         		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NetworkDistributionDBDAOSearchTradeDirbyLaneListRSQL(), param, velParam);
                 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaLaneRgstVO.class);
         	}            
         }catch(SQLException se){
             log.error("err " + se.toString(), se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error("err " + ex.toString(), ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
    }	

}