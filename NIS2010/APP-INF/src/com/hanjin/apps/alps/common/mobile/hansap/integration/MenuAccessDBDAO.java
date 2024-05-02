/**
 * Copyright(c) 2013 CyberLogitec
 * @FileName : MenuAccessDBDAO.java
 * @FileTitle : Hanjin Menu별 접근 권한 추가, 삭제 DB 처리
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2013.12.17
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.0
 * 2013.12.17 1.0 Sang-Hyun Kim Creation
 */
package com.hanjin.apps.alps.common.mobile.hansap.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.common.mobile.hansap.vo.MobAuthorityVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * Hanjin Menu별 접근 권한 추가, 삭제 DB 처리.
 * 
 * @author Sang-Hyun Kim
 * @see
 * @since J2EE 1.6
 */
public class MenuAccessDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Menu 접권 권한 정보 추가.
	 * @param mobAuthorityVO
	 * @return Integer
	 * @throws DAOException
	 */
	public Integer addAuth(MobAuthorityVO mobAuthorityVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Integer affectCount = null;

		try {
			if (mobAuthorityVO != null) {
				param.putAll(mobAuthorityVO.getColumnValues());
				SQLExecuter sqlExecuter = new SQLExecuter("SysComDB");
				int result = sqlExecuter.executeUpdate((ISQLTemplate)new MenuAccessDBDAOAddAuthCSQL(), param, null);
				affectCount = Integer.valueOf(result);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

		return affectCount;
    }

	/**
	 * Menu 접권 권한 정보 삭제.
	 * @param mobAuthorityVO
	 * @return Integer
	 * @throws DAOException
	 */
	public Integer removeAuth(MobAuthorityVO mobAuthorityVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Integer affectCount = null;

		try {
			if (mobAuthorityVO != null) {
				param.putAll(mobAuthorityVO.getColumnValues());
				SQLExecuter sqlExecuter = new SQLExecuter("SysComDB");
				int result = sqlExecuter.executeUpdate((ISQLTemplate)new MenuAccessDBDAORemoveAuthDSQL(), param, null);
				affectCount = Integer.valueOf(result);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

		return affectCount;
	}
}
