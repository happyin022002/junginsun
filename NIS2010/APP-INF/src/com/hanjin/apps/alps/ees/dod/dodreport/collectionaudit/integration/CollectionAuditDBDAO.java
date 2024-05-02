/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CollectionAuditDBDAO.java
*@FileTitle : DOD Collection Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2015-11-04
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-11-04 Jeong-Min Park
* 1.0 최초 생성
*  
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.vo.CollectionAuditINVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.vo.CollectionAuditListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * CollectionAuditDBDAO <br>
 * 
 * @author Jeong-Min Park
 * @see EventSupport
 * @since J2EE 1.4
 */
public class CollectionAuditDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 7296549438223955377L;

	/**
	 * EES_DOD_0008 DOD Collection Audit
	 * DOD Collection Audit 조회
	 * 
	 * @param CollectionAuditINVO
	 * @return List<CollectionAuditListVO>
	 * @throws DAOException
	 */
	public List<CollectionAuditListVO> searchCollectionAuditList(CollectionAuditINVO collectionAuditINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CollectionAuditListVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = collectionAuditINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CollectionAuditDBDAOsearchCollecationAuditListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CollectionAuditListVO.class);
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
