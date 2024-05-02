/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : CanadaCCTManageDBDAO.java
 *@FileTitle : CanadaCCTManageDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012-06-18
 *@LastModifier : Junkun Lee
 *@LastVersion : 1.0
 *2012-06-18 JunKun Lee : Rail Receiving (Cut Off) Date 산출 Logic 변경 및 추가 요청
 *2012.11.02 정선용 [CHM-201221039] [PRD] Canada rail cut off 기능개선
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.event.EsdPrd0037Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.vo.CanadaCCTManageVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MdmLocationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ENIS-PRD에 대한 DB 처리를 담당<br>
 * - ENIS-PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JunKun Lee
 * @see CCTmanageBCImpl 참조
 * @since J2EE 1.4
 */
public class CanadaCCTManageDBDAO extends DBDAOSupport{

	/**
	 * searchCanadaCCTManage
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<CanadaCCTManageVO> searchCanadaCCTManage(CanadaCCTManageVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<CanadaCCTManageVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CanadaCCTManageDBDAOSearchCCTManageRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CanadaCCTManageVO.class);

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
	 * searchCanadaCCTInterval
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<CanadaCCTManageVO> searchCanadaCCTInterval(CanadaCCTManageVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<CanadaCCTManageVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CanadaCCTManageDBDAOSearchCCTIntervalRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CanadaCCTManageVO.class);

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
	 * searchMdmLocation
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public List<MdmLocationVO> searchMdmLocation(EsdPrd0037Event event) throws DAOException{
		DBRowSet dbRowset = null;
		List<MdmLocationVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(event.getFrmLocCd() != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("loc_cd", event.getFrmLocCd());
				mapVO.put("cnt_cd", event.getFrmCntCd());

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CanadaCCTManageDBDAOSearchMdmLocationRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmLocationVO.class);

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
	 * insertCanadaCCTManage
	 * @param insertVoList
	 * @throws DAOException
	 */
	public void insertCanadaCCTManage(List<CanadaCCTManageVO> insertVoList) throws DAOException{
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (insertVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new CanadaCCTManageDBDAOInsertCCTManageCSQL(), insertVoList, null);
				for (int i = 0; i < creCnt.length; i++) {
					if (creCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * updateCanadaCCTManage
	 * @param updateVoList
	 * @throws DAOException
	 */
	public void updateCanadaCCTManage(List<CanadaCCTManageVO> updateVoList) throws DAOException{
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter(""); 
			if (updateVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new CanadaCCTManageDBDAOUpdateCCTManageUSQL(),updateVoList, null);
				for (int i = 0; i < creCnt.length; i++) {
					if (creCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to modify No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * deleteCanadaCCTManage
	 * @param deleteVoList
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteCanadaCCTManage(List<CanadaCCTManageVO> deleteVoList) throws DAOException, Exception{
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (deleteVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new CanadaCCTManageDBDAODeleteCCTManageDSQL(), deleteVoList, null);
				for (int i = 0; i < creCnt.length; i++) {
					if (creCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to remove No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public List<MdmLocationVO> searchPolNode(EsdPrd0037Event event) throws DAOException{
		DBRowSet dbRowset = null;
		List<MdmLocationVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(event.getFrmLocCd() != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("loc_cd", event.getFrmLocCd());
				mapVO.put("cnt_cd", event.getFrmCntCd());

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CanadaCCTManageDBDAOSearchPolNodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmLocationVO.class);

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
	 * @param updateVoList
	 * @throws DAOException
	 */
	public void updateCaCctItvalMgmt(List<CanadaCCTManageVO> updateVoList) throws DAOException{
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter(""); 
			if (updateVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new CanadaCCTManageDBDAOUpdateCaCctItvalMgmtUSQL(),updateVoList, null);
				for (int i = 0; i < creCnt.length; i++) {
					if (creCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to modify No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * @param updateVoList
	 * @throws DAOException
	 */
	public void updateUsaCctItvalMgmt(List<CanadaCCTManageVO> updateVoList) throws DAOException{
		int creCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter(""); 
			if (updateVoList.size() > 0) {
				creCnt = sqlExe.executeBatch((ISQLTemplate) new CanadaCCTManageDBDAOUpdateUsaCctItvalMgmtUSQL(),updateVoList, null);
				for (int i = 0; i < creCnt.length; i++) {
					if (creCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to modify No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	public String getAuthUsrYn(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String authUsrYn = "";
		try {
			param.put("usr_id", usrId );
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new CanadaCCTManageDBDAOSearchAuthUsrYnRSQL(), param,param);
			while (dbRowset.next()){
				authUsrYn = dbRowset.getString("auth_usr_yn");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return authUsrYn;
	}
	
}
