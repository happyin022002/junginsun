/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAuditDBDAO.java
*@FileTitle : AGNCommAuditDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.02 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.facommaudit.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.acm.acmaudit.facommaudit.vo.FACCommListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS FACommAuditDBDAO <br>
 * - ALPS-ACMRequest system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Young-Oh
 * @see AGNCommAuditBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class FACommAuditDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0029]
	 * FAC Audit 목록을 조회<br>
	 *
	 * @param FACCommListVO facCommListVO
	 * @return List<FACCommListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FACCommListVO> searchFACommAudit(FACCommListVO facCommListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FACCommListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (facCommListVO != null) {
				Map<String, String> mapVO= facCommListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACAuditDBDAOSearchFACCommListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FACCommListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	
}