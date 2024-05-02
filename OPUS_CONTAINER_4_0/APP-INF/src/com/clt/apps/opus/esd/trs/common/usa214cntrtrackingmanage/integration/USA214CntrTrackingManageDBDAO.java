/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : Usa214CntrTrackingDBDAO.java
*@FileTitle : USA 214 CONTAINER TRACKING
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-18
*@LastModifier : Park Jun-Yong
*@LastVersion : 1.0
* 2008-07-18 Park Jun-Yong
* 1.0 최초 생성
* 1.14 N200906110140 [TRS] PB 214개발 및 W/O Cancel시 기 입력된 Appt, Deliv Time 삭제 요청 
=========================================================*/
package com.clt.apps.opus.esd.trs.common.usa214cntrtrackingmanage.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.common.usa214cntrtrackingmanage.event.USA214CntrTrackingManageEvent;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * USA 214 CONTAINER TRACKING<br>
 * - TRS 테이블 갱신을 위해 SCEM에 제공하는 메소드<br>
 * 
 * @author Park Jun-Yong
 * @see USA214CntrTrackingBCImpl 참조
 * @since J2EE 1.4
 */
public class USA214CntrTrackingManageDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * USA214CntrTracking의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 1.14 N200906110140 [TRS] PB 214개발 및 W/O Cancel시 기 입력된 Appt, Deliv Time 삭제 요청
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet usa214CntrTracking(USA214CntrTrackingManageEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("so_no", event.getSoNo());
			param.put("cntr_no", event.getCntrNo());
			param.put("de_dt", event.getDeDt());
			param.put("apnt_dt", event.getApntDt());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			USA214CntrTrackingManageDBDAOUsa214CntrTrackingRSQL template = new USA214CntrTrackingManageDBDAOUsa214CntrTrackingRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);
			if (dbRowset.getRowCount() == 0) param.put("cntr_no", "");

			sqlExe.executeUpdate((ISQLTemplate)new USA214CntrTrackingManageDBDAOUsa214CntrTrackingUSQL(), param, param);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return null;
	}
}