/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : StccCodeRestrictionDBDAO.java
 *@FileTitle : StccCodeRestrictionDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.stcccoderestrictionpopup.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.bizcommon.comm.Constants;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TrsStccCdRstrVO;

/**
 * StccCodeRestrictionDBDAO <br>
 * - STCC Code Restriction Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author
 * @see StccCodeRestrictionBCImpl 참조
 * @since J2EE 1.6
 */
public class StccCodeRestrictionDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 4787592839185072992L;

	/**
	 * 
	 * @param searchVo
	 * @param iPage
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<TrsStccCdRstrVO> searchStccCodeRestriction(TrsStccCdRstrVO searchVo, int iPage) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			int startPart = Constants.PAGE_SIZE_50 * (iPage - 1) + 1;
			int endPart = Constants.PAGE_SIZE_50 * iPage;
			param.put("startpart", startPart);
			param.put("endpart", endPart);
			param.putAll(searchVo.getColumnValues());
			return (List) new SQLExecuter("").executeQuery((ISQLTemplate) new StccCodeRestrictionDBDAOSearchStccCodeRestrictionRSQL(), param, param, TrsStccCdRstrVO.class);
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
	 * @param searchVo
	 * @return
	 * @throws DAOException
	 */
	public int searchTotalStccCodeRestriction(TrsStccCdRstrVO searchVo) throws DAOException {
		DBRowSet dbRowSet = null;
		Map<String, Object> param = new HashMap<String, Object>();
		int totalRow = 0;
		try {
			param.putAll(searchVo.getColumnValues());
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new StccCodeRestrictionDBDAOSearchTotalStccCodeRestrictionRSQL(), param, param);
			if (dbRowSet.next()) {
				totalRow = dbRowSet.getInt("TOTAL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return totalRow;

	}
}
