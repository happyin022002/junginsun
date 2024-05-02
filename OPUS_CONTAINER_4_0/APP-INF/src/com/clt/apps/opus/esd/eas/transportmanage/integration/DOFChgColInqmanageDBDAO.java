/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DOFChgColInqmanageDBDAO.java
*@FileTitle : Drop Off Charge Collection Inquiry List
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-21
*@LastModifier : choice
*@LastVersion : 1.0
* 2009-10-21 choice
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0008Event;
import com.clt.apps.opus.esd.eas.transportmanage.vo.DOFChgColInqmanageListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * DOFChgColInqmanageDBDAO ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class DOFChgColInqmanageDBDAO extends DBDAOSupport {

	/**
	 * Drop Off Charge Collection Inquiry List 조회.<br>
	 * @param EsdEas0008Event event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDofChgColList(EsdEas0008Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			DOFChgColInqmanageListVO model = event.getDOFChgColInqmanageListVo();
			if( model != null ){
				String search_choice = model.getSearchChoice();
				if(search_choice == null ){
					model.setSearchChoice("MM");
				}
				
				Map<String, String> velparam = model.getColumnValues();
				param.putAll(velparam);
			}
//			dbRowset = new SQLExecuter("ENIS").executeQuery(new DOFChgColInqmanageDBDAOSearchDofChgColListRSQL(), param,param);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DOFChgColInqmanageDBDAOSearchDofChgColListRSQL(), param, param); 
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
