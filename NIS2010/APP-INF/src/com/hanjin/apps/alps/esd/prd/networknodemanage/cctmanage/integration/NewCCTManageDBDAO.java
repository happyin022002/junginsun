/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NewCCTManageDBDAO.java
 *@FileTitle : Yard별 CCT
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-09
 *@LastModifier : Jeongseon An
 *@LastVersion : 1.0
 * 20090608 jsy
 * 1.0 최초 생성
 * CSR: N200903040130 20090608 e-NIS CCT MGMT by Yard UI 수정 관련 PRD SKD Logic 보완
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.vo.NewCCTManageVO;
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
 * @author Jeongseon An
 * @see CCTmanageBCImpl 참조
 * @since J2EE 1.4
 */
public class NewCCTManageDBDAO extends DBDAOSupport{

	/**
	 * CCTmanage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public List<NewCCTManageVO> searchCCTManage(NewCCTManageVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<NewCCTManageVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewCCTManageDBDAOSearchCCTManageRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, NewCCTManageVO.class);

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
	 *
	 * @param vo
	 * @throws DAOException
	 */
	public void insertMultiCCTManage(NewCCTManageVO vo) throws DAOException{
		try{
			int successFlag = 0;
			Map<String, String> mapVO = vo.getColumnValues();

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new NewCCTManageDBDAOInsertCCTManageCSQL(), mapVO, mapVO);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 *
	 * @param vo
	 * @throws DAOException
	 */
	public void updateMultiCCTManage(NewCCTManageVO vo) throws DAOException{
		try{
			int successFlag = 0;
			Map<String, String> mapVO = vo.getColumnValues();
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new NewCCTManageDBDAOMultiCCTManageRSQL(), mapVO, mapVO);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 
	 * @param newCCTManageVO
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet checkCct(NewCCTManageVO newCCTManageVO) throws DAOException{
		DBRowSet dbRowset = null;
//		List<NewCCTManageVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try{

			if(newCCTManageVO != null){
				Map<String, String> mapVO = newCCTManageVO.getColumnValues();
				param.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewCCTManageDBDAOCheckCctRSQL(), param, null);


		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
}
