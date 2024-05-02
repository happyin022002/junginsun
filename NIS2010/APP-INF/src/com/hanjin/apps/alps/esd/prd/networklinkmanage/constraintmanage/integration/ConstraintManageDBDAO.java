/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ConstraintManageDBDAO.java
 *@FileTitle : Node Constraint Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-16
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-16 kimyoungchul
 * 1.0 최초 생성
 * 2011.11.22 이수진 [CHM-201113877-01] [PRD] Constraint 기능상에 Update 이력 관리 기능 추가 및 관련 Alert Message 기능 추가
 * 2011.11.30 이수진 [CHM-201114264-01] R4J 패치 이후 발생한 결함 건 수정 - Null 객체 참조 수정
 * 2012.06.07 이준근 [CHM-201217814-01] Constraint Management 입력 Data Validation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.basic.ConstraintManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.CheckCommodityVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.ConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchLinkConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchListCnstExptVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchNodeConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchRouteConstraintVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * alps-PRD에 대한 DB 처리를 담당<br>
 * - alps-PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kimyoungchul
 * @see ConstraintManageBCImpl 참조
 * @since J2EE 1.4
 */
public class ConstraintManageDBDAO extends DBDAOSupport{

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<SearchNodeConstraintVO> searchNodeConstraintList(ConstraintVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchNodeConstraintVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);

				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOSearchNodeConstraintRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchNodeConstraintVO.class);
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
	 * NODE INSERT
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 * ★ 2009-08-19 KIM KWIJIN생성
	 */
	public int[] insertNode(List<SearchNodeConstraintVO> insModels) throws DAOException, Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOInsertNodeConstraintCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * NODE UPDATE
	 * ★ 2009-08-19 KIM KWIJIN생성
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] updateNode(List<SearchNodeConstraintVO> updModels) throws DAOException, Exception{
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOUpdateNodeConstraintUSQL(), updModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
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
		return updCnt;
	}

	/**
	 * NODE DELETE
	 * ★ 2009-08-19 KIM KWIJIN생성
	 * @param delModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteNode(List<SearchNodeConstraintVO> delModels) throws DAOException, Exception{
		int delCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAODeleteNodeConstraintDSQL(), delModels, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to delete No" + i + " SQL");
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
		return delCnt;


	}
	
	/**
	 * NODE HISTORY INSERT
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 * ★ 2011-11-04 LEE SU JIN
	 */
	public int[] addNodeConstraintHistory(List<SearchNodeConstraintVO> insModels) throws DAOException, Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOAddNodeConstraintHistoryCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No" + i + " SQL");
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
	 *
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<SearchLinkConstraintVO> searchLinkConstraintList(ConstraintVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchLinkConstraintVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);

				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOSearchLinkConstraintRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchLinkConstraintVO.class);
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
	 * INSERT LINK
	 * ★2009-08-19 kim kwijin 생성
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] insertLink(List<SearchLinkConstraintVO> insModels) throws DAOException, Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOInsertLinkConstraintCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * UPDATE LINK
	 * ★2009-08-19 kim kwijin 생성
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] updateLink(List<SearchLinkConstraintVO> updModels) throws DAOException, Exception{
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOUpdateLinkConstraintUSQL(), updModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No" + i + " SQL");
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
		return updCnt;

	}

	/**
	 * DELETE LINK
	 * ★2009-08-19 kim kwijin 생성
	 * @param delModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteLink(List<SearchLinkConstraintVO> delModels) throws DAOException, Exception{
		int delCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAODeleteLinkConstraintUSQL(), delModels, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i] == Statement.EXECUTE_FAILED){
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
		return delCnt;

	}
	
	/**
	 * INSERT LINK HISTORY
	 * ★2011-11-04 LEE SU JIN
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addLinkConstraintHistory(List<SearchLinkConstraintVO> insModels) throws DAOException, Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOAddLinkConstraintHistoryCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<SearchRouteConstraintVO> searchRouteConstraintList(ConstraintVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchRouteConstraintVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);

				velParam.putAll(mapVO);
			}
			log.debug("★★:::" + param + " " + param.get("dir_cd"));
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOSearchRouteConstraintRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchRouteConstraintVO.class);
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
	 * INSERT ROUTE
	 * ★2009-08-19 KIM KWIJIN 생성
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] insertRoute(List<SearchRouteConstraintVO> insModels) throws DAOException, Exception{		
		int insCnt[] = new int[1];
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if (insModels.size() > 0) {
				insCnt = new int[insModels.size()];
				SQLExecuter sqlExe = new SQLExecuter("");
				for (int i = 0; i < insModels.size(); i ++) {
					Map<String, String> mapVO = insModels.get(i).getColumnValues();
					param.putAll(mapVO);
					insCnt[i]= sqlExe.executeUpdate((ISQLTemplate)new ConstraintManageDBDAOInsertRouteConstraintCSQL(), param, param);
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
			
			
//			if(insModels.size() > 0){
//				SQLExecuter sqlExe = new SQLExecuter("");
//				insCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOInsertRouteConstraintCSQL(), insModels, null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i] == Statement.EXECUTE_FAILED){
//						throw new DAOException("Fail to insert No" + i + " SQL");
//					}
//				}
//			}
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
	 * UPDATE ROUTE
	 * ★2009-08-19 KIM KWIJIN 생성
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] updateRoute(List<SearchRouteConstraintVO> updModels) throws DAOException, Exception{
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOUpdateRouteConstraintUSQL(), updModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No" + i + " SQL");
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
		return updCnt;

	}

	/**
	 * DELETE ROUTE
	 * ★2009-08-19 KIM KWIJIN 생성
	 * @param delModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteRoute(List<SearchRouteConstraintVO> delModels) throws DAOException, Exception{
		int delCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAODeleteRouteConstraintUSQL(), delModels, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No" + i + " SQL");
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
		return delCnt;
	}

	/**
	 * INSERT UPDATE ROUTE
	 * ★2009-08-19 KIM KWIJIN 생성
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] insertUpdateRoute(List<SearchRouteConstraintVO> updModels) throws DAOException, Exception{
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOInsertUpdateConstraintUSQL(), updModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
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
		return updCnt;


	}
	
	/**
	 * 저장 할 대상의 validation를 체크 합니다. <br>
	 * @param vo
	 * @return List<SearchRouteConstraintVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchRouteConstraintVO> checkRouteConstraint(SearchRouteConstraintVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchRouteConstraintVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);

				velParam.putAll(mapVO);
			}
			log.debug("★★:::" + param + " " + param.get("dir_cd"));
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOCheckRouteConstraintRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchRouteConstraintVO.class);
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
	 * INSERT ROUTE
	 * ★2009-08-19 KIM KWIJIN 생성
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addRouteConstraintHistory(List<SearchRouteConstraintVO> insModels) throws DAOException, Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOAddRouteConstraintHistoryCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No" + i + " SQL");
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
	
//	public int[] addRouteConstraintHistory(List<SearchRouteConstraintVO> insModels) throws DAOException, Exception{
//		int insCnt[] = null;
//		Map<String, Object> param = new HashMap<String, Object>();
//		try{
//			if (insModels.size() > 0) {
//				SQLExecuter sqlExe = new SQLExecuter("");
//				for (int i = 0; i < insModels.size(); i ++) {
//					Map<String, String> mapVO = insModels.get(0).getColumnValues();
//					param.putAll(mapVO);
//					sqlExe.executeUpdate((ISQLTemplate)new ConstraintManageDBDAOAddRouteConstraintHistoryCSQL(), param, param);
//				}
//			}
//
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return insCnt;
//	}
	

	/**
	 * chkPs
	 * ★2009-08-19 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet chkPs(SearchRouteConstraintVO vo) throws DAOException{
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);

				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOCheckPsRSQL(), param, velParam);

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
	 * chkPsNODE
	 * ★2009-08-19 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet chkPsNode(SearchNodeConstraintVO vo) throws DAOException{
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);

				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOCheckPsNodeRSQL(), param, velParam);

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
	 * chkPsLINK
	 * ★2009-08-19 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet chkPsLink(SearchLinkConstraintVO vo) throws DAOException{
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);

				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOCheckPsLinkRSQL(), param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;

	}

//	/**
//	 * get MAX SEQ
//	 * ★2009-08-19 kim kwijin생성
//	 * @param vo
//	 * @return
//	 * @throws DAOException
//	 */
//	public DBRowSet getMaxSeq(SearchRouteConstraintVO vo) throws DAOException{
//		DBRowSet dbRowset = null;
//
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(vo != null){
//				Map<String, String> mapVO = vo.getColumnValues();
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOGetMaxSeqRSQL(), param, velParam);
//
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return dbRowset;
//	}

	/**
	 *  ConstraintManageDBDAO's checkCommodity
	 *  ★ 2009-08-20 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<CheckCommodityVO> checkCommodity(CheckCommodityVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<CheckCommodityVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOCheckCommodityRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CheckCommodityVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;


	}
	
	public int[] insertExptCust(List<SearchListCnstExptVO> insModels, String nod_cd, String nod_cnst_itm_cd, String nod_cnst_seq) throws DAOException, Exception{
		DBRowSet dbRowset = null;
		int insCnt[] = new int[1];
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(insModels.size() > 0) {
				insCnt = new int[insModels.size()];
				SQLExecuter sqlExe = new SQLExecuter("");
				for (int i = 0; i < insModels.size(); i ++) {
					Map<String, String> mapVO = insModels.get(i).getColumnValues();
					param.putAll(mapVO);
					param.put("nod_cd", nod_cd);
					param.put("nod_cnst_itm_cd", nod_cnst_itm_cd);
					param.put("nod_cnst_seq", nod_cnst_seq);
					
					dbRowset=new SQLExecuter("DEFAULT").executeQuery(new ConstraintManageDBDAOExptCustDupChkRSQL(), param, param);
					
					while (dbRowset.next()) {
						int dupCnt = dbRowset.getInt("dup_cnt");
						if(dupCnt > 0) {
							throw new DAOException(new ErrorHandler("COM12225", new String[]{"Exception Customer"}).getMessage());
						}
					}
					
					insCnt[i]= sqlExe.executeUpdate((ISQLTemplate)new ConstraintManageDBDAOInsertExptCustCSQL(), param, param);
					
					if(insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No" + i + " SQL");
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
	
	public List<SearchListCnstExptVO> searchListExptCust(SearchListCnstExptVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchListCnstExptVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOSearchExptCustRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchListCnstExptVO.class);
		}catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	public int[] updateExptCust(List<SearchListCnstExptVO> updModels, String nod_cd, String nod_cnst_itm_cd, String nod_cnst_seq) throws DAOException, Exception {
		int updCnt[] = new int[1];
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if (updModels.size() > 0) {
				updCnt = new int[updModels.size()];
				SQLExecuter sqlExe = new SQLExecuter("");
				for (int i = 0; i < updModels.size(); i ++) {
					Map<String, String> mapVO = updModels.get(i).getColumnValues();
					param.putAll(mapVO);
					param.put("nod_cd", nod_cd);
					param.put("nod_cnst_itm_cd", nod_cnst_itm_cd);
					param.put("nod_cnst_seq", nod_cnst_seq);
					updCnt[i]= sqlExe.executeUpdate((ISQLTemplate)new ConstraintManageDBDAOUpdateExptCustUSQL(), param, param);
					if(updCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No" + i + " SQL");
					}
				}
			}
		}catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
}
