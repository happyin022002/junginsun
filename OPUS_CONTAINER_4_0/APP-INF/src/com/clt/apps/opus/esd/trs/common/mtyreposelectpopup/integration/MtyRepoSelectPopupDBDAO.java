/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MtyRepoSelectPopupDBDAO.java
*@FileTitle : 엠티리포
*Open Issues :
*Change history :
*@LastModifyDate : 2009-03-19
*@LastModifier : eunju son
*@LastVersion : 1.0
* 2009-03-19 eunju son
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.common.mtyreposelectpopup.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.trs.common.mtyreposelectpopup.basic.MtyRepoSelectPopupBCImpl;
import com.clt.apps.opus.esd.trs.common.mtyreposelectpopup.event.EsdTrs0909Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;



/**
 * ENIS-MtyRepoSelectPopup에 대한 DB 처리를 담당<br>
 * - ENIS-MtyRepoSelectPopup Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author eunju son
 * @see MtyRepoSelectPopupBCImpl 참조
 * @since J2EE 1.4
 */
public class MtyRepoSelectPopupDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * MtyRepoSelectPopup의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchMtyRepoSelectPopup(EsdTrs0909Event event) throws DAOException {
		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		StringTokenizer st = null;
		ArrayList<String> arrBkgno = new ArrayList<String>();
	
		String bkg_no = event.getMty_bkg_no();
		
		if( !bkg_no.equals("") && !bkg_no.equals("null")) {
			int j = 0;
			st = new StringTokenizer(bkg_no, ",");

			while( st.hasMoreTokens() ) {
				arrBkgno.add(j++,  st.nextToken());
			}
			
		} 

		param.put("arrBkgno", arrBkgno);

		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new MtyRepoSelectPopupDAOsearchMtyRepoSelectPopupRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
		
		
		
				
			
	}


	}

