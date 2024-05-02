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

package com.clt.apps.opus.esm.saq.common.common.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.event.EsmSaq0112Event;
import com.clt.apps.opus.esm.saq.common.common.event.EsmSaqCodEvent;
import com.clt.apps.opus.esm.saq.common.common.integration.CommonDBDAO;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.common.common.vo.SearchMonthlyQuotaAdjustmentVVD0116ListVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * Common Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see ComboxEventResponse,CommonBC
 * @since J2EE 1.4
 */

public class CommonBCImpl extends BasicCommandSupport implements CommonBC {

	private transient CommonDBDAO dbDao = null;

	public CommonBCImpl() {
		dbDao = new CommonDBDAO();
	}
   
	/**
	 * doEnd
	 */
	public void doEnd() {
		dbDao = null;
	}

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommonCodeList(Event e) throws EventException {
		DBRowSet rowSet = null;
		// ESM_SAQ_CODEventResponse response = null;
		GeneralEventResponse response = new GeneralEventResponse();

		if (e.getEventName().equals("EsmSaqCodEvent")) {
			// PDTO(Data Transfer Object including Parameters)
			EsmSaqCodEvent event = (EsmSaqCodEvent) e;
			String masterCode = event.getMasterCode();
			Method m;
			try {
				m = dbDao.getClass().getMethod("search" + masterCode + "List", new Class[] { HashMap.class });
				rowSet = (DBRowSet) m.invoke(dbDao, new Object[] { event.getParams() });
			} catch (SecurityException ex) {
				throw new EventException(ex.getMessage());
			} catch (NoSuchMethodException ex) {
				throw new EventException(ex.getMessage());
			} catch (IllegalArgumentException ex) {
				throw new EventException(ex.getMessage());
			} catch (IllegalAccessException ex) {
				throw new EventException(ex.getMessage());
			} catch (InvocationTargetException ex) {

				throw new EventException(ex.getMessage());
			}
			// response = new ESM_SAQ_CODEventResponse(rowSet, "SUCCESS");
			response.setRsVo(rowSet);
		}
		return response;
	}

	/**
	 * @param Event e
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaTradeRemarkList(Event e) throws EventException {
		// EventResponse response = null;
		// GeneralEventResponse response = new GeneralEventResponse();
		ReturnVO listVO = new ReturnVO();
		DBRowSet rowSet = null;
		try {
			if (e.getEventName().equals("EsmSaq0112Event")) {
				EsmSaq0112Event event = (EsmSaq0112Event) e;
				QuotaConditionVO quotaConditionVO = event.getQuotaConditionVO();
				rowSet = dbDao.searchMonthlyQuotaTradeRemarkList(quotaConditionVO.getMqta_step_cd(), quotaConditionVO.getBse_yr(), quotaConditionVO.getBse_qtr_cd(),
						quotaConditionVO.getTrd_cd(), quotaConditionVO.getDir_cd(), quotaConditionVO.getMqta_ver_no(), quotaConditionVO.getRlane_cd(),
						quotaConditionVO.getSprtGrpCd(), quotaConditionVO.getBsaGrpCd(), quotaConditionVO.getRhq_cd(), quotaConditionVO.getBseMon2(),
						quotaConditionVO.getGline_ver_no(), quotaConditionVO.getCreOfcCd());

				// response = new EsmSaq0112EventResponse(rowSet, "SUCCESS");
				listVO.setDbRowset(rowSet);
			}
			return listVO;
		} catch (DAOException de) {

			throw new EventException(de.getMessage());
		}
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse addMonthlyQuotaTradeRemark(Event e) throws EventException {
		try {
			if (e.getEventName().equals("EsmSaq0112Event")) {
				// PDTO(Data Transfer Object including Parameters)
				EsmSaq0112Event event = (EsmSaq0112Event) e;
				dbDao.addSAQ_MON_QTA_TRD_RMK(event.getSaqMonQtaTrdRmkVO());
			}
			return null;
		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * @param Event e
	 * @return ReturnVO
	 * @exception EventException
	 * 
	 */
	public ReturnVO searchMonthlyQuotaRHQRemarkList(Event e) throws EventException {
		// EventResponse response = null;
		// GeneralEventResponse response = new GeneralEventResponse();
		ReturnVO listVO = new ReturnVO();
		DBRowSet rowSet = null;
		try {
			if (e.getEventName().equals("EsmSaq0112Event")) {
				EsmSaq0112Event event = (EsmSaq0112Event) e;
				QuotaConditionVO quotaConditionVO = event.getQuotaConditionVO();
				rowSet = dbDao.searchMonthlyQuotaRHQRemarkList(quotaConditionVO.getMqta_step_cd(), quotaConditionVO.getBse_yr(), quotaConditionVO.getBse_qtr_cd(),
						quotaConditionVO.getTrd_cd(), quotaConditionVO.getDir_cd(), quotaConditionVO.getMqta_ver_no(), quotaConditionVO.getRlane_cd(),
						quotaConditionVO.getSprtGrpCd(), quotaConditionVO.getBsaGrpCd(), quotaConditionVO.getRgnOfcCd2(), quotaConditionVO.getBseMon2(),
						quotaConditionVO.getGline_ver_no(), quotaConditionVO.getCreOfcCd());
				// response = new EsmSaq0112EventResponse(rowSet, "SUCCESS");
				listVO.setDbRowset(rowSet);
			}
			return listVO;
		} catch (DAOException de) {

			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 
	 * @param Event e
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaSlsRHQRemarkList(Event e) throws EventException {
		// EventResponse response = null;
		// GeneralEventResponse response = new GeneralEventResponse();

		ReturnVO listVO = new ReturnVO();

		DBRowSet rowSet = null;
		try {
			if (e.getEventName().equals("EsmSaq0112Event")) {
				EsmSaq0112Event event = (EsmSaq0112Event) e;
				QuotaConditionVO quotaConditionVO = event.getQuotaConditionVO();
				rowSet = dbDao.searchMonthlyQuotaSlsRHQRemarkList(quotaConditionVO.getMqta_step_cd(), quotaConditionVO.getBse_yr(), quotaConditionVO.getBse_qtr_cd(),
						quotaConditionVO.getTrd_cd(), quotaConditionVO.getDir_cd(), quotaConditionVO.getMqta_ver_no(), quotaConditionVO.getRlane_cd(),
						quotaConditionVO.getSprtGrpCd(), quotaConditionVO.getBsaGrpCd(), quotaConditionVO.getRgnOfcCd2(), quotaConditionVO.getBseMon2(),
						quotaConditionVO.getPolCd(), quotaConditionVO.getPodCd(), quotaConditionVO.getGline_ver_no(), quotaConditionVO.getCreOfcCd());
				// response = new EsmSaq0112EventResponse(rowSet, "SUCCESS");
				listVO.setDbRowset(rowSet);
			}
			return listVO;
		} catch (DAOException de) {

			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse addMonthlyQuotaRHQRemark(Event e) throws EventException {
		try {
			if (e.getEventName().equals("EsmSaq0112Event")) {
				// PDTO(Data Transfer Object including Parameters)
				EsmSaq0112Event event = (EsmSaq0112Event) e;
				dbDao.addSAQ_MON_QTA_RHQ_RMK(event.getSaqMonQtaRhqRmkVO());
			}
			return null;
		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse addMonthlyQuotaSlsRHQRemark(Event e) throws EventException {
		try {
			if (e.getEventName().equals("EsmSaq0112Event")) {
				// PDTO(Data Transfer Object including Parameters)
				EsmSaq0112Event event = (EsmSaq0112Event) e;
				dbDao.addSAQ_MON_QTA_LOD_TGT_RMK(event.getSaqMonQtaLodTgtRmkVO());
			}
			return null;
		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaAdjustmentVVD0116ListVO>
	 * @exception EventException
	 */

	public List<SearchMonthlyQuotaAdjustmentVVD0116ListVO> searchMonthlyQuotaAdjustmentVVD0116List(QuotaConditionVO quotaConditionVO) throws EventException {

		try {

			return dbDao.searchMonthlyQuotaAdjustmentVVD0116List(quotaConditionVO);
		} catch (DAOException de) {

			throw new EventException(de.getMessage());
		}
	}
}