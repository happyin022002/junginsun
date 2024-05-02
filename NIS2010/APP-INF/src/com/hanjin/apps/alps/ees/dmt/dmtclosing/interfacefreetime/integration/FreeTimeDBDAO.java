package com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.vo.IfFtCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.vo.IfFtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

public class FreeTimeDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Inbound Inland Demurrage 에 대한 Movement 정보를 조회합니다.
	 * 
	 * @param IfFtCondVO ifFtCondVO
	 * @return IfFtCondVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public IfFtCondVO searchInlndMvmtIbDem(IfFtCondVO ifFtCondVO) throws DAOException {
	 
		IfFtCondVO ftCondVO = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			if (ifFtCondVO != null) {
				Map<String, String> mapVO = ifFtCondVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new FreeTimeDBDAOSearchInlndMvmtIbDemRSQL(), param, null);
			List<IfFtCondVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, IfFtCondVO .class);
			
			if (list != null) {
				ftCondVO = list.get(0);
			}			
		}
		catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return ftCondVO;
	 }
	
	/**
	 * Inbound Port Demurrage 에 대한 Movement 정보를 조회합니다.
	 * 
	 * @param IfFtCondVO ifFtCondVO
	 * @return IfFtCondVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public IfFtCondVO searchPortInlndMvmtIbDem(IfFtCondVO ifFtCondVO) throws DAOException {
	 
		IfFtCondVO ftCondVO = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			if (ifFtCondVO != null) {
				Map<String, String> mapVO = ifFtCondVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new FreeTimeDBDAOSearchPortMvmtIbDemRSQL(), param, null);
			List<IfFtCondVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, IfFtCondVO .class);
			
			if (list != null) {
				ftCondVO = list.get(0);
			}
		}
		catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return ftCondVO;
	 }
	 
	/**
	 * SCE 모듈에서 FreeTime 정보를 얻기 위해 호출한 이력정보를 생성합니다.
	 * 
	 * @param IfFtVO ifFtVO
	 * @throws DAOException
	 */
	public void addIfFtHis(IfFtVO ifFtVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = ifFtVO.getColumnValues();

			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new FreeTimeDBDAOAddIfFtHisCSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	 
}
