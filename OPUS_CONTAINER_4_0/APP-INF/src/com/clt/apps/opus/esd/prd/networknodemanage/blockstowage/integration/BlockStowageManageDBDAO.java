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
package com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.integration;

import com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.vo.CodeInquiryVO;
import com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.vo.GroupCreationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PRD에 대한 DB 처리를 담당<br>
 * PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kimyoungchul
 * @see YardManageBCImpl 참조
 * @since J2EE 1.4
 */
public class BlockStowageManageDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * YardManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param vo
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<GroupCreationVO> searchGroupCreationList(GroupCreationVO vo) throws DAOException {
		List<GroupCreationVO> list = new ArrayList<GroupCreationVO>();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
				list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new BlockStowageManageDBDAOSelectGroupCreationRSQL(), mapVO, mapVO, GroupCreationVO.class);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<GroupCreationVO> searchLaneCode(GroupCreationVO vo) throws DAOException {
		List<GroupCreationVO> list = new ArrayList<GroupCreationVO>();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
				list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new BlockStowageManageDBDAOSelectLaneCodeRSQL(), mapVO, mapVO, GroupCreationVO.class);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;

	}

	/**
	 * PickupReturnCYDBDAO's searchYardDetail
	 * 
	 * @param vo
	 * @throws DAOException
	 */
	public void insertGroupCreation(GroupCreationVO vo) throws DAOException {
		try {
			int successFlag = 0;
			Map<String, String> mapVO = new HashMap<String, String>();
			if (vo != null) {
				mapVO = vo.getColumnValues();
				successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new BlockStowageManageDBDAOInsertGroupCreationCSQL(), mapVO, mapVO);
				if (successFlag == Statement.EXECUTE_FAILED) {
					throw new DAOException((new ErrorHandler("PRD00064")).getMessage());
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
	 * 
	 * @param vo PickupReturnCY
	 * @throws DAOException
	 */
	public void updateGroupCreation(GroupCreationVO vo) throws DAOException {
		try {
			int successFlag = 0;
			Map<String, String> mapVO = new HashMap<String, String>();
			if (vo != null) {
				mapVO = vo.getColumnValues();
				successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new BlockStowageManageDBDAOUpdateGroupCreationUSQL(), mapVO, mapVO);
				if (successFlag == Statement.EXECUTE_FAILED) {
					throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
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
	 * YardManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param vo
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CodeInquiryVO> searchCodeInquiryList(CodeInquiryVO vo) throws DAOException {
		List<CodeInquiryVO> list = new ArrayList<CodeInquiryVO>();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
				list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new BlockStowageManageDBDAOSelectCodeInquiryRSQL(), mapVO, mapVO, CodeInquiryVO.class);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;

	}
}
