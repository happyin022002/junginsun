/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DOFChgColPermanageDBDAO.java
*@FileTitle : Drop Off Charge Collection Performance List
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-30
*@LastModifier : ho-sam lee
*@LastVersion : 1.0
* 2008-01-30 ho-sam lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0009Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * DOFChgColPermanageDBDAO ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class DOFChgColPermanageDBDAO extends DBDAOSupport {

	/**
	 * Drop Off Charge Collection Performance 조회.<br>
	 * @param EsdEas0009Event event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDofChgColPerList(EsdEas0009Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			Map<String, String> velparam = event.getColumnValues();
			param.putAll(velparam);
//			dbRowset = new SQLExecuter("ENIS").executeQuery(new DOFChgColPermanageDBDAOSearchDofChgColPerListRSQL(), param,param);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DOFChgColPermanageDBDAOSearchDofChgColPerListRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return dbRowset;
		
	}

}
