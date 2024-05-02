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
package com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.vo.PickupReturnCYVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.basic.YardManageBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * PRD에 대한 DB 처리를 담당<br>
 * PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kimyoungchul
 * @see YardManageBCImpl 참조
 * @since J2EE 1.4
 */
public class PickupReturnCyManageDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * YardManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param vo
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List searchPickupList(PickupReturnCYVO vo) throws DAOException {
		List<PickupReturnCYVO> list = new ArrayList<PickupReturnCYVO>();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
				list = (List) new SQLExecuter().executeQuery((ISQLTemplate) new PickupReturnCyManageDBDAOSelectPickupReturnCyRSQL(), mapVO, mapVO, PickupReturnCYVO.class);
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
	 * @param vos
	 * @throws DAOException
	 */
	public void insertPickupReturnCY(List<PickupReturnCYVO> vos) throws DAOException {
		try {
			new SQLExecuter().executeBatch((ISQLTemplate) new PickupReturnCyManageDBDAOInsertPickupReturnCyCSQL(), vos, null, null);
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
	 * @param vos
	 * @throws DAOException
	 */
	public void updatePickupReturnCY(List<PickupReturnCYVO> vos) throws DAOException {
		try {
			new SQLExecuter().executeBatch((ISQLTemplate) new PickupReturnCyManageDBDAOUpdatePickupReturnCyUSQL(), vos, null, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * cnkDupPickupReturnCY
	 * 
	 * @param pickupReturnCYVO
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet cnkDupPickupReturnCY(PickupReturnCYVO pickupReturnCYVO) throws DAOException {
		DBRowSet dbRowset = null;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			if (pickupReturnCYVO != null) {
				mapVO = pickupReturnCYVO.getColumnValues();
				dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new PickupReturnCyManageDBDAOChkDupPickupReturnCYRSQL(), mapVO, null);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler(de).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}
}
