/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PodManageDBDAO.java
 *@FileTitle : PodManageDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-08-24
 *@LastModifier : Noh Seung Bae
 *@LastVersion : 1.0
 * 2009-08-24 Noh Seung Bae
 * 1.0 최초 생성
 * 2011.08.09 변종건 [CHM-201112199-01] Inland Route POD Management 기능변경 및 보완 요청
 * 2011.11.02 이수진 [CHM-201113877-01] Constraint 기능상에 Update 이력 관리 기능 추가  
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.vo.PrdImdgClssCdVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.vo.SearchPodListVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.basic.YardManageBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * eNIS-PRD에 대한 DB 처리를 담당<br>
 * - eNIS-PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kimyoungchul
 * @see YardManageBCImpl 참조
 * @since J2EE 1.4
 */
public class PodManageDBDAO extends DBDAOSupport{

	/**
	 * pod list
	 * ★2009-10-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<SearchPodListVO> searchPodList(SearchPodListVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchPodListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PodManageDBDAOSearchPodListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchPodListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;


	}

	/**
	 * search location state
	 * ★2009-10-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<SearchPodListVO> searchLocationState(SearchPodListVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchPodListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PodManageDBDAOSearchLocationStateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchPodListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;

	}

	/**
	 * update prd_pod_mgmt
	 * ★2009-10-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdPodMgmt(SearchPodListVO vo) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new PodManageDBDAOUpdatePrdPodMgmtUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;

	}

	/**
	 * search validation
	 * ★2009-10-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchValidation(SearchPodListVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PodManageDBDAOSearchValidationRSQL(), param, null);

		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;

	}

	/**
	 * insert pod
	 * ★2009-10-16 kim kwijin생성
	 * @param insModels
	 * @return
	 * @throws DAOException
	 */
	public int[] insertPod(List<SearchPodListVO> insModels) throws DAOException{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new PodManageDBDAOInsertPodCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);

			if( se.getErrorCode() == 1) {
				throw new DAOException(new ErrorHandler("COM12115").getMessage().replaceAll("\\(\\$s\\)", "Inland Route POL/POD Constraint"));
			} else {
				throw new DAOException(new ErrorHandler(se).getMessage());
			}
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * update pod
	 * ★2009-10-16 kim kwijin생성
	 * @param insModels
	 * @return
	 * @throws DAOException
	 */
	public int[] updatePod(List<SearchPodListVO> insModels) throws DAOException{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new PodManageDBDAOUpdatePodUSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No" + i + " SQL");
					}
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * insert pod History
	 * ★2011-11-03 Lee Su-Jin
	 * @param insModels
	 * @return
	 * @throws DAOException
	 */
	public int[] addPrdPodMgmtHistory(List<SearchPodListVO> insModels) throws DAOException{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new PodManageDBDAOAddPrdPodMgmtHistoryCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);

			if( se.getErrorCode() == 1) {
				throw new DAOException(new ErrorHandler("COM12115").getMessage().replaceAll("\\(\\$s\\)", "Inland Route POL/POD Constraint History"));
			} else {
				throw new DAOException(new ErrorHandler(se).getMessage());
			}
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * Class 를 조회 합니다. <br>
	 * 
	 * @return List<PrdImdgClssCdVO>
	 * @throws DAOException
	 */
	public List<PrdImdgClssCdVO> searchUNClass() throws DAOException {
		DBRowSet dbRowset = null;
		List<PrdImdgClssCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("\nEsdPrd0087Event---------searchUNClass");
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PodManageDBDAOSearchUNClassRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PrdImdgClssCdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}
