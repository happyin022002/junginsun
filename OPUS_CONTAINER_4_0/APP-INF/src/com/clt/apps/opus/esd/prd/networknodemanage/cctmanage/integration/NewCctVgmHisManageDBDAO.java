/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : NewCctVgmHisManageDBDAO.java
 *@FileTitle : PRD_TML_VGM_CCT_HIS
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 =========================================================*/

package com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.integration;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PrdTmlVgmCctHisVO;

/**
 * CCT VGM History 관리 DAO
 * @author
 * @see NewCctVgmHisManageDBDAO 참조
 * @since J2EE 1.4
 */
public class NewCctVgmHisManageDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = -2576857001123346401L;

	/**
	 * @param prdTmlVgmCctHisVO
	 * @throws DAOException
	 */
	public void addPrdTmlVgmCctHisByPrdNewData(PrdTmlVgmCctHisVO prdTmlVgmCctHisVO) throws DAOException {
		try {
			new SQLExecuter().executeUpdate((ISQLTemplate) new NewCctVgmHisManageDBDAOAddPrdTmlVgmCctHisByPrdNewDataCSQL(), prdTmlVgmCctHisVO.getColumnValues(), null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * @param prdTmlVgmCctHisVO
	 * @throws DAOException
	 */
	public void addPrdTmlVgmCctHis(PrdTmlVgmCctHisVO prdTmlVgmCctHisVO) throws DAOException {
		try {
			Map<String, String> mapVO = prdTmlVgmCctHisVO.getColumnValues();
			new SQLExecuter().executeUpdate((ISQLTemplate) new NewCctVgmHisManageDBDAOAddPrdTmlVgmCctHisByPrdCSQL(), mapVO, mapVO);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * @param prdTmlVgmCctHisVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PrdTmlVgmCctHisVO> searchPrdTmlVgmCctHis(PrdTmlVgmCctHisVO prdTmlVgmCctHisVO) throws DAOException {
		DBRowSet dbRowSet = null;
		List<PrdTmlVgmCctHisVO> list;
		try {
			Map<String, String> mapVO = prdTmlVgmCctHisVO.getColumnValues();
			dbRowSet = new SQLExecuter().executeQuery((ISQLTemplate) new NewCctVgmHisManageDBDAOSearchPrdTmlVgmCctHisRSQL(), mapVO, mapVO);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet, PrdTmlVgmCctHisVO.class);
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
