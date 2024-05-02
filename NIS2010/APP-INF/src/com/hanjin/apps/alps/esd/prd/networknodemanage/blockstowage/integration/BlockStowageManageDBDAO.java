/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PickupReturnCYDBDAO.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-24
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-24 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.integration;

import com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.vo.CodeInquiryVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.vo.GroupCreationVO;

import java.sql.SQLException;
import java.sql.Statement;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import java.util.List;
import java.util.Map;

/**
 * alps-PRD에 대한 DB 처리를 담당<br>
 * - alps-PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kimyoungchul
 * @see YardManageBCImpl 참조
 * @since J2EE 1.4
 */
public class BlockStowageManageDBDAO extends DBDAOSupport{

	/**
	 * YardManage의 모든 목록을 가져온다.<br>
	 *
	 * @param vo
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public List searchGroupCreationList(GroupCreationVO vo) throws DAOException{
		List<GroupCreationVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();

			}
			list = (List) new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BlockStowageManageDBDAOSelectGroupCreationRSQL(), mapVO, mapVO, GroupCreationVO.class);
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
	 * @return
	 * @throws DAOException
	 */
	public List searchLaneCode(GroupCreationVO vo) throws DAOException{
		List<GroupCreationVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BlockStowageManageDBDAOSelectLaneCodeRSQL(), mapVO, mapVO, GroupCreationVO.class);
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
	 * PickupReturnCYDBDAO's searchYardDetail
	 * @param vo
	 * @throws DAOException
	 */
	public void insertGroupCreation(GroupCreationVO vo) throws DAOException{
		try{
			int successFlag = 0;
			Map<String, String> mapVO = vo.getColumnValues();

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new BlockStowageManageDBDAOInsertGroupCreationCSQL(), mapVO, mapVO);
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
	 * @param vo PickupReturnCY
	 * @throws DAOException
	 */
	public void updateGroupCreation(GroupCreationVO vo) throws DAOException{
		try{
			int successFlag = 0;
			Map<String, String> mapVO = vo.getColumnValues();

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new BlockStowageManageDBDAOUpdateGroupCreationUSQL(), mapVO, mapVO);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
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
	 * YardManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param vo
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public List searchCodeInquiryList(CodeInquiryVO vo) throws DAOException{
		List<CodeInquiryVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery(
					(ISQLTemplate) new BlockStowageManageDBDAOSelectCodeInquiryRSQL(), mapVO, mapVO, CodeInquiryVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;

	}
}
