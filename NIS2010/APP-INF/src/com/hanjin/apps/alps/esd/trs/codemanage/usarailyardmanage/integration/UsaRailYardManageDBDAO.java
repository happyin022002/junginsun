/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaRailYardManageDBDAO.java
*@FileTitle : UsaRailYardManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009-05-11
*@LastModifier : Jun Yong Park
*@LastVersion : 1.0
* 2009-05-11 Jun Yong Park
* 1.0 최초 생성
* N200905150040 2009-05-20 [TRS]USA RAIL YARD 정보 저장 화면 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.usarailyardmanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.codemanage.usarailyardmanage.basic.UsaRailYardManageBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.usarailyardmanage.event.EsdTrs0084Event;
import com.hanjin.apps.alps.esd.trs.codemanage.usarailyardmanage.vo.UsaRailYardManageVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ENIS-UsaRailYardManage에 대한 DB 처리를 담당<br>
 * - ENIS-UsaRailYardManage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author poong yeon cho
 * @see UsaRailYardManageBCImpl 참조
 * @since J2EE 1.4
 */
public class UsaRailYardManageDBDAO extends DBDAOSupport {

	/**
	 * UsaRailYardManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event EsdTrs0084Event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchUsaRailYardManage(EsdTrs0084Event event) throws DAOException {
		DBRowSet dRs = null;
		try{
			
			String yard = event.getYard()+event.getRailYard();
			Map<String, Object> param = new HashMap<String, Object>();			
			param.put("yard",yard);
	
	        SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	        UsaRailYardManageDBDAOsearchUsaRailYardManageRSQL template = new UsaRailYardManageDBDAOsearchUsaRailYardManageRSQL();
	        dRs = sqlExe.executeQuery(template, param, param);	
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
		return dRs;
	}

	/**
	 * UsaRailYardManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event EsdTrs0084Event
	 * @see EsdTrs0084Event
	 * @throws DAOException
	 */
	public void multiUsaRailYardManage(EsdTrs0084Event event) throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			UsaRailYardManageVO[] model = event.getUsaRailYardManageVOs();
			Collection<UsaRailYardManageVO> updateVoList = new ArrayList<UsaRailYardManageVO>();
			Map<String, Object> param = new HashMap<String, Object>();			
			param.put("upd_usr_id",event.getUserId());			
			
			for ( int i=0; i<model.length; i++ ) {
				updateVoList.add(model[i]);
			}	
			
			if(updateVoList.size() > 0){
				sqlExe.executeBatch((ISQLTemplate)new UsaRailYardManageDBDAOmultiUsaRailYardManageUSQL(), updateVoList, null, param);
			}

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
	}
}