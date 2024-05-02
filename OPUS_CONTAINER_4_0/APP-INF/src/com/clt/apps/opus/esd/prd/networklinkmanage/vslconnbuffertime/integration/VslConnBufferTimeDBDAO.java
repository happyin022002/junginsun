/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : VslConnBufferTimeDBDAO.java
 *@FileTitle :VslConnBufferTimeDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 =========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.vo.VslConnBufferTimeListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * PRD에 대한 DB 처리를 담당<br>
 * PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author
 * @see VslConnBufferTimeBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class VslConnBufferTimeDBDAO extends DBDAOSupport {
	/**
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<VslConnBufferTimeListVO> searchVslConnBufferTimeList(VslConnBufferTimeListVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		List<VslConnBufferTimeListVO> rsltList = new ArrayList<VslConnBufferTimeListVO>();
		try {
			if (vo != null) {
				param.putAll(vo.getColumnValues());
				rsltList = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new VslConnBufferTimeDBDAOSearchVslConnBufferTimeListRSQL(), param, param, VslConnBufferTimeListVO.class);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsltList;
	}

	/**
	 * 
	 * @param vos
	 * @throws DAOException
	 */
	public void multiVslConnBufferTime(List<VslConnBufferTimeListVO> vos) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			new SQLExecuter("").executeBatch((ISQLTemplate) new VslConnBufferTimeDBDAOMultiVslConnBufferTimeCSQL(), vos, param);
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
	public void deleteVslConnBufferTime(List<VslConnBufferTimeListVO> vos) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			new SQLExecuter("").executeBatch((ISQLTemplate) new VslConnBufferTimeDBDAODeleteVslConnBufferTimeDSQL(), vos, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
