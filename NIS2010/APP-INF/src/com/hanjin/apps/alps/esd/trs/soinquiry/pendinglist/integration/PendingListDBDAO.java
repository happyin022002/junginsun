/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PendingListDBDAO.java
*@FileTitle : Pending List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-18
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-18 juhyun
* 1.0 최초 생성
* N200902240170 2009-03-05 Pending list ofc 매뉴얼 입력 가능 조정
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.basic.PendingListBCImpl;
import com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.event.EsdTrs0001Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author juhyun
 * @see PendingListBCImpl 참조
 * @since J2EE 1.4
 */
public class PendingListDBDAO extends DBDAOSupport {

	/**
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * @param event EsdTrs0001Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchPendingListList(EsdTrs0001Event event) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			String cre_ofc_cd = event.getOfc_cd();

			List<String> ofcCd = new ArrayList();
			ofcCd  = this.seperationParameter(cre_ofc_cd, ","); 

			param.put("from_date", event.getHid_from_date().toString());
			param.put("to_date", event.getHid_to_date().toString());
			param.put("cargo", event.getHid_cargo().toString());
			param.put("bound", event.getHid_bound().toString());	
			param.put("hid_cost", event.getHid_cost().toString());
			param.put("sel_transmode", event.getSel_transmode().toString());
			param.put("hid_rhq", event.getHid_rhq().toString());			
			param.put("trunk_vvd", event.getTrunk_vvd().toString());
			param.put("trunk_vvd1", event.getTrunk_vvd1().toString());
			param.put("trunk_vvd2", event.getTrunk_vvd2().toString());
			param.put("trunk_vvd3", event.getTrunk_vvd3().toString());
			
			param.put("OfcCd", ofcCd);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			PendingListDBDAOSearchPendingListListRSQL template = new PendingListDBDAOSearchPendingListListRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;		
	
}

	/**
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * @param event EsdTrs0001Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet search_vvd(EsdTrs0001Event event) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			
			param.put("trunk_vvd", event.getTrunk_vvd().toString());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			PendingListDBDAOSearchVvdRSQL template = new PendingListDBDAOSearchVvdRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;

}

	/**
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * @param event EsdTrs0001Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet search_ofc(EsdTrs0001Event event) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("hid_rhq", event.getHid_rhq().toString());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			PendingListDBDAOSearchOfcRSQL template = new PendingListDBDAOSearchOfcRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
}

	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return
	 */
	public ArrayList seperationParameter(String sparameter, String sSeperate) {
		ArrayList arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}	
	
}
