/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CnlBKGCntrmanageDAO.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 ���� ��
* * N200903200050 EAS 보완요청 
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0005Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * CnlBKGCntrmanageDAO PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see DBDAOSupport ��v
 * @since J2EE 1.4
 */
public class CnlBKGCntrmanageDBDAO extends DBDAOSupport {


	/**
	 * Canceled 된 BKG이 가지고 있는 Cntr가 새로운 BKG에 붙은 내역 조회
	 * @param EsdEas0005Event event
	 * @return DBRowSet
	 * @throws DAOException
	 * * N200903200050 EAS 보완요청 
	 */
	public DBRowSet searchCnlBKGCntrList(EsdEas0005Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			
			Map<String, String> velparam = event.getColumnValues();
			param.put("str_bkgno",velparam.get("bkgno"));
			param.put("str_blno" ,velparam.get("blno"));
			
//			dbRowset = new SQLExecuter("eNIS").executeQuery(new CnlBKGCntrmanageDBDAOSearchCnlBKGCntrListRSQL(), param,param);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CnlBKGCntrmanageDBDAOSearchCnlBKGCntrListRSQL(), param, param);
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
