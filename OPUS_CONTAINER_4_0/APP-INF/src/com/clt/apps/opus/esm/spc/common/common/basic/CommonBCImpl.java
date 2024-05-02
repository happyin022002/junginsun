/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : CommonBCImpl.java
*@FileTitle      : Common
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 

=========================================================*/

package com.clt.apps.opus.esm.spc.common.common.basic;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.spc.common.common.event.EsmSpcCodEvent;
import com.clt.apps.opus.esm.spc.common.common.integration.CommonDBDAO;
import com.clt.apps.opus.esm.spc.common.common.integration.CommonDBDAOSearchOfficeCondRSQL;
import com.clt.apps.opus.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.apps.opus.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Common Business Logic Basic Command implementation<br>
 * - handling business transaction for Common<br>
 *
 * @author 
 * @see ComboxEventResponse,CommonBC (Reference DAO Class of each)
 * @since J2EE 1.4
 */

public class CommonBCImpl extends BasicCommandSupport implements CommonBC {

	private transient CommonDBDAO dbDao = null;

	/**
	 * CommonBCImpl Object Creation<br>
	 * CommonDBDAO Object Creation<br>
	 */
	public CommonBCImpl() {
		dbDao = new CommonDBDAO();
	}

	/**
	 * Common biz scenario closing<br>
	 * Common clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
	

	/**
	 * EsmSpcCodEvent retrieve event process<br>
	 * BSAManage  common code retrieve <br>
	 * 
     * @author
	 * @param e EsmSpcCodEvent
	 * @return EventResponse ESM_SPC_CODEventResponse
     * @exception EventException
     */	
	@SuppressWarnings("unchecked")
	public EventResponse searchCommonCodeList(Event e) throws EventException {
		DBRowSet rowSet = null; 
		GeneralEventResponse response = null;
		if (e.getEventName().equals("EsmSpcCodEvent")) {
			// PDTO(Data Transfer Object including Parameters)
			EsmSpcCodEvent event = (EsmSpcCodEvent) e;
			String masterCode = event.getMasterCode();
			Method m;
			try {
				m = dbDao.getClass().getMethod("search" + masterCode + "List",
						new Class[] { HashMap.class });
				HashMap map = event.getParams();
				map.put("login_usr_id", event.getSignOnUserAccount().getUsr_id());
				map.put("login_usr_ofc_cd", event.getSignOnUserAccount().getOfc_cd());
				rowSet = (DBRowSet) m.invoke(dbDao, new Object[] { map });
			} catch (SecurityException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage());
			} catch (NoSuchMethodException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage());
			} catch (IllegalArgumentException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage());
			} catch (IllegalAccessException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage());
			} catch (InvocationTargetException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage());
			}
			response = new GeneralEventResponse();
			response.setRsVo(rowSet);
		}
		return response;
	}

	/**
	 * EsmSaq116Event retrieve event process<br>
	 * BSAManage common child office info retrieve <br>
	 * 
     * @author
	 * @param Event e
	 * @return EventResponse ESM_SAQ_116EventResponse
     * @exception EventException
     */	
	public EventResponse searchChildOfficeList(Event e) throws EventException {
		GeneralEventResponse response = null;
		try {
			// PDTO(Data Transfer Object including Parameters)
			String ofc_cd = e.getSignOnUserAccount().getOfc_cd();
			HashMap map = new HashMap();
			map.put("ofc_cd", new String[]{ofc_cd});
			map.put("level1", new String[]{"4"});
			DBRowSet rowSet = dbDao.searchChildOfficeList(map);
			response = new GeneralEventResponse();
			response.setRsVo(rowSet);
			return response;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	

	/**
	 * EsmSaq116Event retrieve event process<br>
	 * BSAManage common child team office info retrieve <br>
	 * 
     * @author
	 * @param e ESM_SAQ_116Event
	 * @return EventResponse ESM_SAQ_116EventResponse
     * @exception EventException
     */		
	public EventResponse searchChildTeamOfficeList(Event e) throws EventException {
		GeneralEventResponse response = null;
		try {
			// PDTO(Data Transfer Object including Parameters)
			String ofc_cd = e.getSignOnUserAccount().getOfc_cd();
			HashMap map = new HashMap();
			map.put("ofc_cd", new String[]{ofc_cd});
			map.put("level1", new String[]{"4"});
			DBRowSet rowSet = dbDao.searchChildTeamOfficeList(map);
			response = new GeneralEventResponse();
			response.setRsVo(rowSet);
			return response;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param Event e
	 * @param SignOnUserAccount account
	 * @return List<SearchOfficeCondVO>
	 * @exception EventException
	 */
	public List<SearchOfficeCondVO> searchOfficeCond(Event e, SignOnUserAccount account) throws EventException {
		try {
			String ofc_cd  = account.getOfc_cd();
			String ui_name = e.getEventName().substring(0, 10);
			return dbDao.searchOfficeCond(ofc_cd, ui_name);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
}