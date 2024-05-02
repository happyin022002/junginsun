/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnAuditDBDAO.java
*@FileTitle : SPCLCmpnAuditDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.23
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.23 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.spclcmpnaudit.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.basic.AGNCommAuditBCImpl;
import com.hanjin.apps.alps.esm.acm.acmaudit.spclcmpnaudit.vo.SPCLCmpnAuditVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS AGNCommAuditDBDAO <br>
 * - ALPS-ACMRequest system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Young-Oh
 * @see AGNCommAuditBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class SPCLCmpnAuditDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0029]
	 * Special Compensation Audit 목록을 조회<br>
	 *
	 * @param SPCLCmpnAuditVO spcLCmpnAuditVO
	 * @return List<SPCLCmpnAuditVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SPCLCmpnAuditVO> searchSPCLCmpnAudit(SPCLCmpnAuditVO spcLCmpnAuditVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SPCLCmpnAuditVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (spcLCmpnAuditVO != null) {
				Map<String, String> mapVO= spcLCmpnAuditVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCLCmpnAuditDBDAOSearchSPCLCmpnAuditListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SPCLCmpnAuditVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0029]
	 * Special Compensation Audit 목록을 수정<br>
	 *
	 * @param List<SPCLCmpnAuditVO> spcLCmpnAuditVOs
	 * @throws DAOException
	 */
	public void manageSPCLCmpnAudit(List<SPCLCmpnAuditVO> spcLCmpnAuditVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (spcLCmpnAuditVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SPCLCmpnAuditDBDAOModifySPCLCmpnAuditListUSQL(), spcLCmpnAuditVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}