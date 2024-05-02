/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CalculateDBDAO.java
 *@FileTitle : CalculateDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.03.24
 *@LastModifier : 송민석
 *@LastVersion : 1.0
 * 2010.03.24 송민석
 * 1.0 Creation
 * 2012.07.17 송호진 CHM-201218988 : PRS ROUTE CASE 비용 산출 배치 작업 요청(7월) 건에 의해 발견된 부분 수정 두번째 
				    Cost 계산에서 사용되는 COA 의 데이터들을 지우는 로직을 추가                                                                  
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.basic.CalculateBCImpl;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.PriPrsInCalculateVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsBatCalculateVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsRoutActCostSimulationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsRoutCsMaxRoutCsNoVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsRoutEstmCostSimulationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsUsdRoutCsInfoSimulationVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.InPriPrsRoutCsVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.PriTriRouteCaseNotFoundOthersVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
 

/**
 * NIS2010 SCRateProposalDBDAO <br>
 * - NIS2010-SCGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Minseok, Song
 * @see CalculateBCImpl 참조
 * @since J2EE 1.4
 */
public class CalculateDBDAO extends DBDAOSupport {
 	
	/**
	 * Surchage값을 (PRI_PRS_USD_ROUT_CS_INFO) 추가합니다.<br>
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @return int
	 * @exception DAOException
	 */
	public int addPriPrsUsdRoutCsInfoSimulation(InPriPrsRoutCsVO inPriPrsRoutCsVO) throws DAOException, Exception {
		try {
			Map<String, String> mapVO = inPriPrsRoutCsVO.getColumnValues();
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");


			int result = sqlExe.executeUpdate((ISQLTemplate) new CalculateDBDAOPriPrsUsdRoutCsInfoSimulationCSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
	/**
	 * Surchage값을 (PRI_PRS_USD_ROUT_ACT_COST) 추가합니다.<br>
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @return int
	 * @exception DAOException
	 */
	public int addPriPrsUsdRoutActCostSimulation(InPriPrsRoutCsVO inPriPrsRoutCsVO) throws DAOException, Exception {
		try {
			Map<String, String> mapVO = inPriPrsRoutCsVO.getColumnValues();
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");


			int result = sqlExe.executeUpdate((ISQLTemplate) new CalculateDBDAOPriPrsUsdRoutActCostSimulationCSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
	/**
	 * Surchage값을 (PRI_PRS_USD_ROUT_ESTM_COST) 추가합니다.<br>
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @return int
	 * @exception DAOException
	 */
	public int addPriPrsUsdRoutEstmCostSimulation(InPriPrsRoutCsVO inPriPrsRoutCsVO) throws DAOException, Exception {
		try {
			Map<String, String> mapVO = inPriPrsRoutCsVO.getColumnValues();
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");


			int result = sqlExe.executeUpdate((ISQLTemplate) new CalculateDBDAOPriPrsUsdRoutEstmCostSimulationCSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}

			return result;
	 
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * Rate 데이터를 생성한다.<br>
	 * 
	 * @param List<InPriPrsRoutCsVO> inPriPrsRoutCsVOs
	 * @exception DAOException
	 */
	public void addPriPrsRouteCase(List<InPriPrsRoutCsVO> inPriPrsRoutCsVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = null;
			sqlExe = new SQLExecuter("PRS_HJSBAT");
			int insCnt[] = null;
			if (inPriPrsRoutCsVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new CalculateDBDAOPriPrsRoutCsPreSimulationCSQL(), inPriPrsRoutCsVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 *  Used Rout Case Info 를 조회합니다.<br>
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @return List<RsltPriPrsUsdRoutCsInfoSimulationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriPrsUsdRoutCsInfoSimulationVO> searchPriPrsUsdRoutCsInfoSimulationList(InPriPrsRoutCsVO inPriPrsRoutCsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriPrsUsdRoutCsInfoSimulationVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inPriPrsRoutCsVO != null) {
				Map<String, String> mapVO = inPriPrsRoutCsVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CalculateDBDAORsltPriPrsUsdRoutCsInfoSimulationVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriPrsUsdRoutCsInfoSimulationVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 *  Used Act Cost 를 조회합니다.<br>
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @return List<RsltPriPrsRoutActCostSimulationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriPrsRoutActCostSimulationVO> searchPriPrsRoutActCostSimulationList(InPriPrsRoutCsVO inPriPrsRoutCsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriPrsRoutActCostSimulationVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inPriPrsRoutCsVO != null) {
				Map<String, String> mapVO = inPriPrsRoutCsVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CalculateDBDAORsltPriPrsRoutActCostSimulationVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriPrsRoutActCostSimulationVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 *  Used Estm Cost 를 조회합니다.<br>
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @return List<RsltPriPrsRoutEstmCostSimulationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriPrsRoutEstmCostSimulationVO> searchPriPrsRoutEstmCostSimulationList(InPriPrsRoutCsVO inPriPrsRoutCsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriPrsRoutEstmCostSimulationVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inPriPrsRoutCsVO != null) {
				Map<String, String> mapVO = inPriPrsRoutCsVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CalculateDBDAORsltPriPrsRoutEstmCostSimulationVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriPrsRoutEstmCostSimulationVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Route Case Info 데이터를  BATCH DB에 생성한다.<br>
	 * 
	 * @param List<RsltPriPrsUsdRoutCsInfoSimulationVO> insModels
	 * @exception DAOException
	 */
	public void addPriPrsRoutCsInfoSimulation(List<RsltPriPrsUsdRoutCsInfoSimulationVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = null;
			sqlExe = new SQLExecuter("PRS_HJSBAT");
			
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new CalculateDBDAOPriPrsRoutCsInfoSimulationCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Act Cost 데이터를  BATCH DB에 생성한다.<br>
	 * 
	 * @param List<RsltPriPrsRoutActCostSimulationVO> insModels
	 * @exception DAOException
	 */
	public void addPriPrsRoutActCostSimulation(List<RsltPriPrsRoutActCostSimulationVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = null;
			sqlExe = new SQLExecuter("PRS_HJSBAT");
		
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new CalculateDBDAOPriPrsRoutActCostSimulationCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
	/**
	 * Estm Cost 데이터를  BATCH DB에 생성한다.<br>
	 * 
	 * @param List<RsltPriPrsRoutEstmCostSimulationVO> insModels
	 * @exception DAOException
	 */
	public void addPriPrsRoutEstmCostSimulation(List<RsltPriPrsRoutEstmCostSimulationVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = null;
			sqlExe = new SQLExecuter("PRS_HJSBAT");
			
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new CalculateDBDAOPriPrsRoutEstmCostSimulationCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
	/**
	 *  Used Estm Cost 를 조회합니다.<br>
	 * 
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @return List<RsltPriPrsBatCalculateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriPrsBatCalculateVO> searchPriPrsBatCalculateList(PriPrsInCalculateVO priPrsInCalculateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriPrsBatCalculateVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priPrsInCalculateVO != null) {
				Map<String, String> mapVO = priPrsInCalculateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CalculateDBDAORsltPriPrsBatCalculateVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriPrsBatCalculateVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * "pri/TRICalculate", "insertPRI_PRS_ROUTE_CS"
	 * 
	 * @param PriTriRouteCaseNotFoundOthersVO priTriRouteCaseNotFoundOthersVO
	 * @exception DAOException
	 */
	public void addPriPrsRoutCsCalculate(PriTriRouteCaseNotFoundOthersVO priTriRouteCaseNotFoundOthersVO) throws DAOException, Exception {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = null;
			sqlExe = new SQLExecuter("PRS_HJSBAT");
			
 
			if (priTriRouteCaseNotFoundOthersVO != null) {
				Map<String, String> mapVO = priTriRouteCaseNotFoundOthersVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new CalculateDBDAOPriPrsRoutCsCalculateCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
		
	
	
	/**
	 *   "pri/TRICalculate","updateMARK_PRI_PRS_ROUT_CS_COA"
	 * 
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @return int 
	 * @exception DAOException
	 * @throws Exception
	 */
	public int modifyPriPrsRoutCsMarkCalculate(PriPrsInCalculateVO priPrsInCalculateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priPrsInCalculateVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("PRS_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CalculateDBDAOPriPrsRoutCsMarkCalculateUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			return result;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
 

	/**
	 *   "pri/TRICalculate", "updateMARK_PRI_PRS_ROUT_CS_FLG_COA"
	 * 
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @return int 
	 * @exception DAOException
	 * @throws Exception
	 */
	public int modifyPriPrsRoutCsFlgCalculate(PriPrsInCalculateVO priPrsInCalculateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priPrsInCalculateVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("PRS_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CalculateDBDAOPriPrsRoutCsFlgCalculateUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			return result;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
 
	

	/**
	 *  ROUT_CS_NO의 max값을 구한다.<br>
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @return RsltPriPrsRoutCsMaxRoutCsNoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RsltPriPrsRoutCsMaxRoutCsNoVO searchPriPrsRoutCsMaxRoutCsNoCalculate(InPriPrsRoutCsVO inPriPrsRoutCsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriPrsRoutCsMaxRoutCsNoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inPriPrsRoutCsVO != null) {
				Map<String, String> mapVO = inPriPrsRoutCsVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("PRS_HJSBAT").executeQuery(
					(ISQLTemplate) new CalculateDBDAORsltPriPrsRoutCsMaxRoutCsNoVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriPrsRoutCsMaxRoutCsNoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list.get(0);
	}

	/**
	 * 비용 생성시 Temporary Data 성으로 만들어진 COA_COM_PARA 상의 Row 를 PCTL_NO 기준으로 Delete 한다.
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @return int
	 * @exception DAOException
	 */
	public int deleteCoaComPara(InPriPrsRoutCsVO inPriPrsRoutCsVO) throws DAOException, Exception {
		try {
			Map<String, String> mapVO = inPriPrsRoutCsVO.getColumnValues();
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");


			int result = sqlExe.executeUpdate((ISQLTemplate) new CalculateDBDAOCoaComParaDSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to Delete COA_COM_PARA");
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * 비용 생성시 Temporary Data 성으로 만들어진 COA_COM_COST_PARA 상의 Row 를 PCTL_NO 기준으로 Delete 한다.
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @return int
	 * @exception DAOException
	 */
	public int deleteCoaComCostPara(InPriPrsRoutCsVO inPriPrsRoutCsVO) throws DAOException, Exception {
		try {
			Map<String, String> mapVO = inPriPrsRoutCsVO.getColumnValues();
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");


			int result = sqlExe.executeUpdate((ISQLTemplate) new CalculateDBDAOCoaComCostParaDSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to Delete COA_COM_COST_PARA");
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * 비용 생성시 Temporary Data 성으로 만들어진 COA_COM_QTY_PARA 상의 Row 를 PCTL_NO 기준으로 Delete 한다.
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @return int
	 * @exception DAOException
	 */
	public int deleteCoaComQtyPara(InPriPrsRoutCsVO inPriPrsRoutCsVO) throws DAOException, Exception {
		try {
			Map<String, String> mapVO = inPriPrsRoutCsVO.getColumnValues();
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");


			int result = sqlExe.executeUpdate((ISQLTemplate) new CalculateDBDAOCoaComQtyParaDSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to Delete COA_COM_QTY_PARA");
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * 비용 생성시 Temporary Data 성으로 만들어진 COA_COM_SVC_TRNS_PRC_PARA 상의 Row 를 PCTL_NO 기준으로 Delete 한다.
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @return int
	 * @exception DAOException
	 */
	public int deleteCoaComSvcTrnsPrcPara(InPriPrsRoutCsVO inPriPrsRoutCsVO) throws DAOException, Exception {
		try {
			Map<String, String> mapVO = inPriPrsRoutCsVO.getColumnValues();
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");


			int result = sqlExe.executeUpdate((ISQLTemplate) new CalculateDBDAOCoaComSvcTrnsPrcParaDSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to Delete COA_COM_SVC_TRNS_PRC_PARA");
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
}