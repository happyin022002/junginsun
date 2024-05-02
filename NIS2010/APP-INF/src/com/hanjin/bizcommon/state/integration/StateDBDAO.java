/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ContinentDBDAO.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-13
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-13 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.state.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.bizcommon.continent.basic.ContinentBCImpl;
import com.hanjin.bizcommon.state.event.ComEns0X1Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hyung Choon_Roh
 * @see ContinentBCImpl 참조
 * @since J2EE 1.4
 */
public class StateDBDAO extends DBDAOSupport {

	/**
     * 1. 기능 : State count<p>
     * 2. 처리개요 : State의 총 카운트를 조회한다.<p>
     * - totalState<p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : HyungChoonRoh/2006.08.03<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
	 * @param et COM_ENS_0X1Event
     * @return int
     * @throws DAOException
     */
	public int totalState(Event et) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		
		// PDTO(Data Transfer Object including Parameters)
		ComEns0X1Event event=(ComEns0X1Event)et;
		
		String cnt_cd = event.getCnt_cd();
		
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("cnt_cd", cnt_cd);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new StateDBDAOTotalStateRSQL(), mapParam, mapParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
		
		return cnt;
	}
	
	/**
	 * State의 모든 목록을 가져온다.<br>
	 * @param et ComEns0X1Event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchStateList(Event et) throws DAOException {
        DBRowSet dbRowset = null;
		
		// PDTO(Data Transfer Object including Parameters)
		ComEns0X1Event event=(ComEns0X1Event)et;
        String cnt_cd = event.getCnt_cd();
        
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("cnt_cd", cnt_cd);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new StateDBDAOSearchStateListRSQL(), mapParam, mapParam);

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return dbRowset;
	}
}