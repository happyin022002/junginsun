/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostStructureDBDAO.java
*@FileTitle : CostStructureDBDAO (물류비용 코드 등록, 전사계정과목 등록)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.basic.CostStructureBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event.EsmCoa0002Event;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.CostStructureCommonVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.CostStructureConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.MainGrpCostCodeVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.NodLnkCostCodeVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchCostCodeListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchCostStructure0139ListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchCostStructure0140ListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchSoCodeListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SpclRepoCntrVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SubGrpCostCodeVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.TableColumnVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CoaSpclRepoCntrRgstVO;
import com.clt.syscommon.common.table.CoaTrnsFdrTermVO;
import com.clt.syscommon.common.table.CoaTrnsTermCalcVO;
import com.clt.syscommon.common.table.CoaUsaSvcModVO;
import com.clt.syscommon.common.table.CoaWkPrdVO;



/**
 * COA에 대한 DB 처리를 담당<br>
 * - COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author OKYOUNG IM
 * @see CostStructureBCImpl 참조
 * @since J2EE 1.4
 */
public class CostStructureDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8149817611972815713L;



	/**
	 * CostStructureDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @return List<SpclRepoCntrVO>
	 * @throws DAOException
	 */
	public List<SpclRepoCntrVO> searchSpclRepoCntrList() throws DAOException {
		DBRowSet dbRowset = null;
		List<SpclRepoCntrVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchSpclRepoCntrRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpclRepoCntrVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<CoaSpclRepoCntrRgstVO> insModels
	 * @throws DAOException
	 */
	public void addSpclRepoCntr(List<CoaSpclRepoCntrRgstVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiSpclRepoCntrCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<CoaSpclRepoCntrRgstVO> updModels
	 * @throws DAOException
	 */
	public void modifySpclRepoCntr(List<CoaSpclRepoCntrRgstVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiSpclRepoCntrUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<CoaSpclRepoCntrRgstVO> delModels
	 * @throws DAOException
	 */
	public void removeSpclRepoCntr(List<CoaSpclRepoCntrRgstVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiSpclRepoCntrDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * Cost Element의 모든 목록을 가져온다.<br>
	 * join table COA_STND_ACCT, COA_MN_GRP_COST, COA_SUB_GRP_COST<br>
	 * main table COA_STND_ACCT<br>
	 * ESM_COA_0002
	 * 
	 * @param CostStructureCommonVO vo
	 * @return List<SearchCostCodeListVO>
	 * @throws DAOException
	 */
	 public List<SearchCostCodeListVO> searchCostCodeList(CostStructureCommonVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCostCodeListVO> list = null;
		try{
			if(vo == null) return null;	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchCostCodeListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCostCodeListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }	

	/**
	 * Cost Element의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 입력, 삭제 작업은 COA_STND_ACCT 테이블에서만 일어난다.<br>
	 * 수정 작업은 COA_COST_SRC_ACCT, COA_STND_ACCT에서 일어난다.<br>
	 * 
	 * @param CostStructureCommonVO vo
	 * @see EsmCoa0002Event
	 * @throws DAOException
	 */
	 public void multiCostCode(CostStructureCommonVO vo) throws DAOException {
        int insCnt[] = null;
        int updCnt[] = null;
        int delCnt[] = null;
		
        try{
        	SQLExecuter sqlExe = new SQLExecuter("");
            
            if(vo.getMultiCreateList().size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiCostCodeCSQL(), vo.getMultiCreateList(), null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }            	
            }
            
            if(vo.getMultiUpdateList().size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiCostCodeUSQL(), vo.getMultiUpdateList(), null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }            	
            }
            
            if(vo.getMultiDeleteList().size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiCostCodeDSQL(), vo.getMultiDeleteList(), null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete No"+ i + " SQL");
                }            	
            }            
        }catch (SQLException se) {
        	log.error("err "+se.toString(),se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
        	log.error("err "+ex.toString(),ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	 }	
	
	 
	/**
	 * So Cost Code의 모든 목록을 가져온다.<br>
	 * ESM_COA_003
	 * 
	 * @param  CostStructureConditionVO vo
	 * @param  String userId 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSoCodeList(CostStructureConditionVO vo, String userId) throws DAOException {
		DBRowSet dbRowset = null;
		//헤더용
		DBRowSet dRs2 = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> cols  = new ArrayList();
		int saveCnt = 0;
		
		try{			
			Map<String, String> mapVO = vo.getColumnValues();				
			param.putAll(mapVO);
			velParam.putAll(mapVO);	
			
			//header 변수 세팅
			dRs2 = getVariableHeader();
			
			if(dRs2 != null){
				while(dRs2.next()){									
					cols.add(dRs2.getString("code"));
				}
			}
			velParam.put("allcols", cols);						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchSoCodeListRSQL(), param, velParam);
			
			// COA_ACT_GRP_COST_MAPG 테이블 싱크 처리 
			param.put("user_id"  , userId);
			saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CostStructureDBDAOUpdateCoaActGrpCostMapgCSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
		
	/**
	 * 가변헤더를 가져온다. TABLE:PRD_ACT_GRP
	 * @return DBRowSet DB 처리 결과 "|"으로 연결
	 * @throws DAOException
	 */
	public DBRowSet getVariableHeader() throws DAOException{
		DBRowSet dbRowset = null;
		
		try{			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOGetVariableHeaderRSQL(), null, null);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	
	/**
	 * So Cost Code의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 입력, 수정, 삭제 작업은 COA_COST_SRC_ACCT 테이블에서 일어난다.
	 * <br>
	 * 
	 * @param   SearchSoCodeListVO vo
	 * @see ESM_COA_0003Event
	 * @throws  DAOException
	 */
	public void multiSoCodeSrcAcct(SearchSoCodeListVO vo) throws DAOException {
        int saveCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiSaveList().size() > 0){
                saveCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiSoCodeSrcAcctCSQL(), vo.getMultiSaveList(), null);
                for(int i = 0; i < saveCnt.length; i++){
                    if(saveCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }

        }catch (SQLException se) {
            log.error("err "+se.toString(),se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err "+ex.toString(),ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
	
	/**
	 * So Cost Code의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 입력, 수정, 삭제 작업은 COA_ACT_GRP_COST_MAPG 테이블에서 일어난다.
	 * <br>
	 * 
	 * @param   SearchSoCodeListVO vo
	 * @see ESM_COA_0003Event
	 * @throws  DAOException
	 */
	public void multiSoCodeCostMapg(SearchSoCodeListVO vo) throws DAOException {
        int saveCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiSaveList2().size() > 0){
                saveCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiSoCodeCostMapgCSQL(), vo.getMultiSaveList2(), null);
                for(int i = 0; i < saveCnt.length; i++){
                    if(saveCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }

        }catch (SQLException se) {
            log.error("err "+se.toString(),se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err "+ex.toString(),ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

	/**
	 * 조회할 테이블 필드명 가져오기<br>
	 * 
	 * @param  SearchConditionVO searchConditionVO
	 * @return List<SearchCostStructure0139ListVO> searchCostStructure0139List
	 * @throws DAOException
	 */	
	 public List<SearchCostStructure0139ListVO> searchCostStructure0139List(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCostStructure0139ListVO> list = null;
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
			//dbRowset으로값을 담음
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchCostStructure0139ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCostStructure0139ListVO .class);
			//list형 으로 변경해서 값을 리턴해줌
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CoaTrnsFdrTermVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addCostStructure0139(List<CoaTrnsFdrTermVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOCoaTrnsFdrTermVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CoaTrnsFdrTermVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyCostStructure0139(List<CoaTrnsFdrTermVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOCoaTrnsFdrTermVOCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
		
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CoaTrnsFdrTermVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeCostStructure0139(List<CoaTrnsFdrTermVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOCoaTrnsFdrTermVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
		
	
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchCostStructure0140ListVO searchCostStructure0140ListVO
	 * @param SearchConditionVO searchCondition
	 * @return List<SearchCostStructure0140ListVO>
	 * @throws DAOException
	 */
	 public List<SearchCostStructure0140ListVO> searchCostStructure0140List(SearchCostStructure0140ListVO searchCostStructure0140ListVO
			                                                              ,SearchConditionVO searchCondition) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCostStructure0140ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCostStructure0140ListVO != null){
				Map<String, String> mapVO = searchCostStructure0140ListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			if(searchCondition != null){
				Map<String, String> mapVO = searchCondition .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchCostStructure0140ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCostStructure0140ListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }
	 
     /**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CoaTrnsTermCalcVO> instupdModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	 public int[] modifyCostStructure0140(List<CoaTrnsTermCalcVO> instupdModels) throws DAOException,Exception {
		int updCnt[] = null;
		// 데이터를 동시에 저장할 때 block할 건수
		int      msg_cnt    = 200;
		String   msg_action = "save";				
		String[] errMessage = {msg_action, msg_cnt+""};	
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(instupdModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOCoaTrnsTermCalcVOCSQL(), instupdModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert or update No"+ i + " SQL");
				}
				
				if(updCnt.length >= msg_cnt){
					log.info("\n You can't "+msg_action+" more than "+msg_cnt+" rows.");				
					throw new DAOException(new ErrorHandler("COA00030",errMessage).getMessage());	
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	 }
		
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CoaTrnsTermCalcVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeCostStructure0140(List<CoaTrnsTermCalcVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		int      msg_cnt    = 200;
		String   msg_action = "delete";				
		String[] errMessage = {msg_action, msg_cnt+""};
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOCoaTrnsTermCalcVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
				
				if(delCnt.length >= msg_cnt){
					log.info("\n You can't "+msg_action+" more than "+msg_cnt+" rows.");				
					throw new DAOException(new ErrorHandler("COA00030",errMessage).getMessage());	
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
		
	/**
	 * Sheet1의 테이블의 컬럼 목록을 조회(NODE, LINK))<br>
	 * 
	 * @param String fTableName
	 * @return List<TableColumnVO>
	 * @throws DAOException
	 */
	public List<TableColumnVO> searchCostStructure0137List(String fTableName ) throws DAOException {
		DBRowSet dbRowset = null;
		List<TableColumnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			velParam.put("f_col_only", "Y");
			velParam.put("f_table_name", fTableName);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchCostStructure0137ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TableColumnVO.class);
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
	 * NODE,LINK 단가 조회<br>
	 * 
	 * @param String fTableName
	 * @param TableColumnVO[] tableColumnVOs
	 * @return List<NodLnkCostCodeVO>
	 * @throws DAOException
	 */
	public List<NodLnkCostCodeVO> searchCostStructure0137List2(String fTableName, TableColumnVO[] tableColumnVOs) throws DAOException {
		DBRowSet dbRowset = null;
		List<NodLnkCostCodeVO> list = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TableColumnVO> paramList = new ArrayList<TableColumnVO>();
		
		int msg_cnt    = 10000;
		String   msg_action = "retrieve";
		try{
			paramList = new ArrayList<TableColumnVO>();
			if(tableColumnVOs.length>0){
				for(int i=0; i<tableColumnVOs.length; i++) {
					if(!"".equals(tableColumnVOs[i].getValue())) 	paramList.add( tableColumnVOs[i]);
					log.debug("i=" + i + ">>>>>>>>" + tableColumnVOs[i].getColName() + tableColumnVOs[i].getInEquality() + tableColumnVOs[i].getValue());
				}
			}
			velParam.put("conditionArr", paramList);
			velParam.put("f_table_name", fTableName);
			
			//먼저 검색결과 개수를 센다.
			velParam.put("f_row_count", "Y");
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchCostStructure0137List2RSQL(), null, velParam);
			String[] errMessage = {msg_action, msg_cnt + ""};
			
			if(dbRowset != null){
				dbRowset.next(); 
				//결과가 지정한 값보다 크면 사용자에게 메시지를 보여준다.
				if(dbRowset.getInt(1) >= msg_cnt) {
					log.info("\n You can't "+msg_action+" more than "+msg_cnt+" rows.");
					throw new EventException(new ErrorHandler("COA00030",errMessage).getMessage());
				}
				else {
					//데이터 조회를 하기 위해 새로 세팅해준다.
					velParam.put("f_row_count", "N");
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchCostStructure0137List2RSQL(), null, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, NodLnkCostCodeVO.class);
				}	
			}					
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
	 *NODE, LINK단가 입력/수정<br>
	 * 
	 * @param String fTableName
	 * @param List<NodLnkCostCodeVO> mergeModels
	 * @throws DAOException List<CoaTrnsTermCalcVO>
	 * @throws Exception
	 */
	public void modifyCostStructure0137(String fTableName, List<NodLnkCostCodeVO> mergeModels) throws DAOException,Exception {
//		int msg_cnt    = 200;									//SJH.20150508.소스품질
//		String   msg_action = "save";							//SJH.20150508.소스품질
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int mergeCnt[] = null;

			//String[] errMessage = {msg_action, msg_cnt+""};
			log.debug("CostStructureDBDAO.multiCostStructure0137S fTableName=" + fTableName);
			if(mergeModels.size() > 0){
				//SJH.20141222.MOD : 200 line 제한 풀기..
//				if(mergeModels.size() > msg_cnt) {
//					log.info("\n You can't "+msg_action+" more than "+msg_cnt+" rows.");
//					throw new EventException(new ErrorHandler("COA00030",errMessage).getMessage());
//				} else {
					velParam.put("f_table_name", fTableName);
					mergeCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiCostStructure0137CSQL(), mergeModels,velParam);
					for(int i = 0; i < mergeCnt.length; i++){
						if(mergeCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to merge No"+ i + " SQL");
					}
//				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
							
	/**
	 * NODE, LINK단가 삭제<br>
	 * 
	 * @param String fTableName
	 * @param List<NodLnkCostCodeVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeCostStructure0137(String fTableName, List<NodLnkCostCodeVO> delModels) throws DAOException,Exception {
		int msg_cnt    = 200;
		String   msg_action = "delete";
		int delCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			String[] errMessage = {msg_action, msg_cnt+""};
			log.debug("CostStructureDBDAO.deleteCostStructure0137 fTableName=" + fTableName);
			if(delModels.size() > 0){
				
				if(delModels.size() > msg_cnt) {
					log.info("\n You can't "+msg_action+" more than "+msg_cnt+" rows.");
					throw new EventException(new ErrorHandler("COA00030",errMessage).getMessage());
				} else {
					velParam.put("f_table_name", fTableName);
					delCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOMultiCostStructure0137DSQL(), delModels,velParam);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

				
	
	/**
	 * COA_OFC_LVL 데이블에 데이터를 생성한다.<br>
	 * 
	 * @param   SearchConditionVO searchconditionVO
	 * @throws  DAOException
	 */
	public void addOfficeLevel(SearchConditionVO searchconditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = searchconditionVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			sqlExe.executeSP((ISQLTemplate)new CostStructureDBDAOCreateOfficeLevelCSQL(), param, velParam);
				
        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
	
	 
	/**
	 * [Year Month] 정보를 [조회] 합니다.<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String searchYearMonthValue() throws DAOException {
		DBRowSet dbRowset = null;
		String tYearMonth = null;
	
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOCoaBkgCostCalcVORSQL(), null, null);
			
			if (dbRowset.next()) {
				tYearMonth = dbRowset.getString(1);
			}
	            
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return tYearMonth;
	}
	
	
	/**
	 *  [Year Month] 정보를 [수정] 합니다.<br>
	 * 
	 * @param   SearchConditionVO searchconditionVO
	 * @throws  DAOException
	 */
	public void modifyYearMonthValue(SearchConditionVO searchconditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = searchconditionVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CostStructureDBDAOCoaBkgCostCalcVOUSQL(), param, velParam);
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
	 * Main Group Cost Code 정보를 조회해 온다.<br>
	 * 
	 * @param String stndCostTpCd
	 * @return List<MainGrpCostCodeVO>
	 * @throws DAOException
	 */
	public List<MainGrpCostCodeVO> searchMainGrpCostCode(String stndCostTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MainGrpCostCodeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(stndCostTpCd != null){
				param.put("f_profitLevelCombo", stndCostTpCd);
				velParam.put("f_profitLevelCombo", stndCostTpCd);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchMainGrpCostCodeRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, MainGrpCostCodeVO.class);
			}
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
	 * Main Group Cost Code 중복을 체크한다.<br>
	 * 
	 * @param MainGrpCostCodeVO mainGrpCostCodeVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkAddMainGrpCostCode(MainGrpCostCodeVO mainGrpCostCodeVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int checkCnt = 0;

		try{
			Map<String, String> mapVO = mainGrpCostCodeVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOCheckMainGrpCostCodeRSQL(), param, velParam);
            while(dbRowset.next()){
            	checkCnt = dbRowset.getInt(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkCnt;
	}
	
	/**
	 * Main Group Cost Code Description 중복을 체크한다.<br>
	 * 
	 * @param MainGrpCostCodeVO mainGrpCostCodeVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkMainGrpCostCodeDesc(MainGrpCostCodeVO mainGrpCostCodeVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int checkCnt = 0;

		try{
			Map<String, String> mapVO = mainGrpCostCodeVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOCheckMainGrpCostCodeDescRSQL(), param, velParam);
            while(dbRowset.next()){
            	checkCnt = dbRowset.getInt(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkCnt;
	}
	
	/**
	 * Main Group Cost Code 삭제전 Sub Group Cost Code에서 사용 하는지를 체크한다.<br>
	 * 
	 * @param MainGrpCostCodeVO mainGrpCostCodeVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkSubGrpCostCodeFromMain(MainGrpCostCodeVO mainGrpCostCodeVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int checkCnt = 0;

		try{
			Map<String, String> mapVO = mainGrpCostCodeVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOCheckSubGrpCostCodeFromMainRSQL(), param, velParam);
            while(dbRowset.next()){
            	checkCnt = dbRowset.getInt(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkCnt;
	}
	
	/**
	 * Main Group Cost Code 정보를 생성한다.<br>
	 * 
	 * @param List<MainGrpCostCodeVO> insertVoList
	 * @throws DAOException
	 */
	public void addMainGrpCostCode(List<MainGrpCostCodeVO> insertVoList) throws DAOException {
		
		//query parameter
		@SuppressWarnings("unused")
		int creCnt[] = null;
		try{
		
			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOAddCoaMainGrpCostCodeCSQL(), insertVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
	
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	
	}

	/**
	 * Main Group Cost Code 정보를 수정한다.<br>
	 * 
	 * @param List<MainGrpCostCodeVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyMainGrpCostCode(List<MainGrpCostCodeVO> updateVoList) throws DAOException {
		//query parameter
		@SuppressWarnings("unused")
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOModifyCoaMainGrpCostCodeUSQL(), updateVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No"+ i + " SQL");
					}
				}
			}
	
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Main Group Cost Code 정보를 삭제한다.<br>
	 * 
	 * @param List<MainGrpCostCodeVO> deleteVoList
	 * @throws DAOException
	 */
	public void removeMainGrpCostCode(List<MainGrpCostCodeVO> deleteVoList) throws DAOException {
		
		//query parameter
		@SuppressWarnings("unused")
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAORemoveCoaMainGrpCostCodeDSQL(), deleteVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to delete No"+ i + " SQL");
					}
				}
			}

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
				
	
	/**
	 * Sub Group Cost Code 정보를 조회해 온다.<br>
	 * 
	 * @param String stndCostTpCd
	 * @param String mgrpCostCd
	 * @return List<SubGrpCostCodeVO>
	 * @throws DAOException
	 */
	public List<SubGrpCostCodeVO> searchSubGrpCostCode(String stndCostTpCd,String mgrpCostCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SubGrpCostCodeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(stndCostTpCd != null ){
				param.put("f_profitLevelCombo", stndCostTpCd);
				velParam.put("f_profitLevelCombo", stndCostTpCd);
				param.put("f_mainGroupCombo", mgrpCostCd);
				velParam.put("f_mainGroupCombo", mgrpCostCd);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchSubGrpCostCodeRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SubGrpCostCodeVO.class);
				log.debug(list);
			}
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
	 * Sub Group Cost Code 중복을 체크한다.<br>
	 * 
	 * @param SubGrpCostCodeVO subGrpCostCodeVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkSubGrpCostCode(SubGrpCostCodeVO subGrpCostCodeVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int checkCnt = 0;

		try{
			Map<String, String> mapVO = subGrpCostCodeVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOCheckSubGrpCostCodeRSQL(), param, velParam);
            while(dbRowset.next()){
            	checkCnt = dbRowset.getInt(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkCnt;
	}
	
	
	/**
	 * Sub Group Cost Code 중복을 체크한다.<br>
	 * 
	 * @param SubGrpCostCodeVO subGrpCostCodeVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkSubGrpCostCodeDesc(SubGrpCostCodeVO subGrpCostCodeVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int checkCnt = 0;

		try{
			Map<String, String> mapVO = subGrpCostCodeVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOCheckSubGrpCostCodeDescRSQL(), param, velParam);
            while(dbRowset.next()){
            	checkCnt = dbRowset.getInt(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkCnt;
	}
	
	/**
	 * Sub Group Cost Code 정보를 생성한다.<br>
	 * 
	 * @param List<SubGrpCostCodeVO> insertVoList
	 * @throws DAOException
	 */
	public void addSubGrpCostCode(List<SubGrpCostCodeVO> insertVoList) throws DAOException {
		
		//query parameter
		@SuppressWarnings("unused")
		int creCnt[] = null;
		try{
		
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOAddCoaSubGrpCostCodeCSQL(), insertVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
	
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	
	}

	/**
	 * Sub Group Cost Code 정보를 수정한다.<br>
	 * 
	 * @param List<SubGrpCostCodeVO> updateVoList
	 * @throws DAOException
	 */
	public void modifySubGrpCostCode(List<SubGrpCostCodeVO> updateVoList) throws DAOException {
		//query parameter
		@SuppressWarnings("unused")
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOModifySubGrpCostCodeUSQL(), updateVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No"+ i + " SQL");
					}
				}
			}
	
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Sub Group Cost Code 삭제전 C/A Code에서 사용 하는지를 체크한다.<br>
	 * 
	 * @param SubGrpCostCodeVO subGrpCostCodeVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkCaCodeFromSub(SubGrpCostCodeVO subGrpCostCodeVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int checkCnt = 0;

		try{
			Map<String, String> mapVO = subGrpCostCodeVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOCheckCaCodeFromSubRSQL(), param, velParam);
            while(dbRowset.next()){
            	checkCnt = dbRowset.getInt(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkCnt;
	}	
	
	/**
	 * Sub Group Cost Code 정보를 삭제한다.<br>
	 * 
	 * @param List<SubGrpCostCodeVO> deleteVoList
	 * @throws DAOException
	 */
	public void removeSubGrpCostCode(List<SubGrpCostCodeVO> deleteVoList) throws DAOException {
		
		//query parameter
		@SuppressWarnings("unused")
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAORemoveSubGrpCostCodeDSQL(), deleteVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to delete No"+ i + " SQL");
					}
				}
			}

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}



	/**
	 * USA Service Mode을 조회한다.<br>
	 * 
	 * @param String orgRgnCd
	 * @param String destRgnCd
	 * @param String svcModCd   
	 * @return List<CoaUsaSvcModVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoaUsaSvcModVO> searchUsaServiceModeListData(String orgRgnCd, String destRgnCd, String svcModCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoaUsaSvcModVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(orgRgnCd != null ){
				param.put("org_rgn_cd", orgRgnCd);
				velParam.put("org_rgn_cd", orgRgnCd);
			}
			if(destRgnCd != null ){
				param.put("dest_rgn_cd", destRgnCd);
				velParam.put("dest_rgn_cd", destRgnCd);
			}
			if(svcModCd != null ){
				param.put("svc_mod_cd", svcModCd);
				velParam.put("svc_mod_cd", svcModCd);
			}

//			if(coaUsaSvcModVO != null){
//				Map<String, String> mapVO = coaUsaSvcModVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchUSAServiceModeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaUsaSvcModVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
}
	 
		
	 /**
	 * USA Service Mode을 저장합니다.<br>
	 * 
	 * @param List<CoaUsaSvcModVO> coaUsaSvcModVOs
	 * @exception DAOException
	 * @exception Exception  
	 */
	public void addUsaServiceModeData(List<CoaUsaSvcModVO> coaUsaSvcModVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(coaUsaSvcModVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOAddUSAServiceModeCSQL(), coaUsaSvcModVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * USA Service Mode을 수정합니다.<br>
	 * 
	 * @param List<CoaUsaSvcModVO> coaUsaSvcModVOs 
	 * @exception DAOException
	 * @exception Exception  
	 */
	public void modifyUsaServiceModeData(List<CoaUsaSvcModVO> coaUsaSvcModVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(coaUsaSvcModVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOModifyUSAServiceModeUSQL(), coaUsaSvcModVOs,null);
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
	}
	
	/**
	 * USA Service Mode을 삭제합니다.<br>
	 * 
	 * @param List<CoaUsaSvcModVO> coaUsaSvcModVOs
	 * @exception DAOException
	 * @exception Exception 
	 */
	public void removeUsaServiceModeData(List<CoaUsaSvcModVO> coaUsaSvcModVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(coaUsaSvcModVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAORemoveUSAServiceModeDSQL(), coaUsaSvcModVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Week Period을 조회한다.<br>
	 * 
	 * @param String costYr
	 * @param String costWkFm
	 * @param String costWkTo   
	 * @return List<CoaWkPrdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CoaWkPrdVO> searchWeekPeriodListData(String costYr, String costWkFm, String costWkTo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoaWkPrdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(costYr != null ){
				param.put("cost_yr", costYr);
				velParam.put("cost_yr", costYr);
			}
			if(costWkFm != null ){
				param.put("cost_wk_fm", costWkFm);
				velParam.put("cost_wk_fm", costWkFm);
			}
			if(costWkTo != null ){
				param.put("cost_wk_to", costWkTo);
				velParam.put("cost_wk_to", costWkTo);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostStructureDBDAOSearchWeekPeriodListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaWkPrdVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
		
	 /**
	 * Week Period을 저장합니다.<br>
	 * 
	 * @param List<CoaWkPrdVO> coaWkPrdVOs
	 * @exception DAOException
	 * @exception Exception  
	 */
	public void addWeekPeriodData(List<CoaWkPrdVO> coaWkPrdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(coaWkPrdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOAddWeekPeriodCSQL(), coaWkPrdVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Week Period을 수정합니다.<br>
	 * 
	 * @param List<CoaWkPrdVO> coaWkPrdVOs 
	 * @exception DAOException
	 * @exception Exception  
	 */
	public void modifyWeekPeriodData(List<CoaWkPrdVO> coaWkPrdVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(coaWkPrdVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAOModifyWeekPeriodUSQL(), coaWkPrdVOs,null);
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
	}
	
	/**
	 * Week Period을 삭제합니다.<br>
	 * 
	 * @param List<CoaWkPrdVO> coaWkPrdVOs
	 * @exception DAOException
	 * @exception Exception 
	 */
	public void removeWeekPeriodData(List<CoaWkPrdVO> coaWkPrdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(coaWkPrdVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CostStructureDBDAORemoveWeekPeriodDSQL(), coaWkPrdVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}



