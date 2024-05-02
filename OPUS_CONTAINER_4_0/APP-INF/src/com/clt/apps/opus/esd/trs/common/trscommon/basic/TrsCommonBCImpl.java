/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : TrsCommonBCImpl.java
 *@FileTitle : TrsCommon
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.trscommon.basic;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0221Event;
import com.clt.apps.opus.esd.trs.common.trscommon.event.EsdTrs0999Event;
import com.clt.apps.opus.esd.trs.common.trscommon.integration.TrsCommonDBDAO;
import com.clt.apps.opus.esd.trs.common.trscommon.vo.TrsCommonComboVO;
import com.clt.apps.opus.esd.trs.common.trscommon.vo.TrsSOHistoryVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event.EsdTrs0023Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;

/**
 * ALPS-Common Business Logic Command Interface<br>
 * 
 * @author
 * @see TrsCommonBC 참조
 * @since J2EE 1.6
 */
public class TrsCommonBCImpl extends BasicCommandSupport implements TrsCommonBC {
	private transient TrsCommonDBDAO dbDao = null;

	/**
	 * TrsCommonBCImpl <br>
	 * TrsCommonDBDAO<br>
	 */
	public TrsCommonBCImpl() {
		dbDao = new TrsCommonDBDAO();
	}

	/**
	 * Inquiry event process<br>
	 * Rail Vendor Code List<br>
	 * 
	 * @param e ESD_TRS_0999Event
	 * @return EventResponse ESD_TRS_0999EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailVndrCd(Event e) throws EventException {

		EsdTrs0999Event event = (EsdTrs0999Event) e;
		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet = dbDao.searchRailVndrCd(event);

			StringBuffer railVndrCd = new StringBuffer();
			StringBuffer railVndrNm = new StringBuffer();

			while (rowSet.next()) {
				railVndrCd.append(rowSet.getString(1)).append("|");
				railVndrNm.append(rowSet.getString(2)).append("|");
			}

			railVndrCd.deleteCharAt(railVndrCd.length() - 1);
			railVndrNm.deleteCharAt(railVndrNm.length() - 1);

			eventResponse.setETCData("rail_vndr_code", railVndrCd.toString());
			eventResponse.setETCData("rail_vndr_desc", railVndrNm.toString());

			return eventResponse;
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * Other s/o 의 Commodity Code를 조회<br>
	 * TRS CY/DOOR S/O와 관련된 각 이벤트 별로 Commodity Code를 입력<br>
	 * 
	 * @param e ESD_TRS_0999Event
	 * @return EventResponse ESD_TRS_0999EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCmdtCd(Event e) throws EventException {
		DBRowSet rowSet = null;
		EsdTrs0999Event event = (EsdTrs0999Event) e;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet = dbDao.searchCmdtCd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			if (formcommand.isCommand(FormCommand.SEARCH04)) {
				if (rowSet.next()) {
					eventResponse.setETCData("cmdt_cd", rowSet.getString("CMDT_CD"));
					eventResponse.setETCData("cmdt_nm", rowSet.getString("CMDT_NM"));
				}
			}
			return eventResponse;

		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * Other s/o 의 Customer Code를 조회<br>
	 * TRS CY/DOOR S/O와 관련된 각 이벤트 별로 Customer Code를 입력<br>
	 * 
	 * @param e ESD_TRS_0999Event
	 * @return EventResponse ESD_TRS_0999EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCustCd(Event e) throws EventException {
		DBRowSet rowSet = null;
		EsdTrs0999Event event = (EsdTrs0999Event) e;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet = dbDao.searchCustCd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if (formcommand.isCommand(FormCommand.SEARCH05)) {
				if (rowSet != null && rowSet.next()) {
					eventResponse.setRsVo(rowSet);
					eventResponse.setETCData("input_cust_cd", rowSet.getString("CUST_CD"));
					eventResponse.setETCData("input_cust_nm", rowSet.getString("CUST_NM"));
				}
			}
			return eventResponse;
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * MDM Container Type/Size Combo List
	 * 
	 * @param e
	 * @return List<MdmCntrTpSzVO>
	 * @exception EventException
	 */
	public List<MdmCntrTpSzVO> searchMdmCntrTpSz(Event e) throws EventException {
		List<MdmCntrTpSzVO> mdmCntrTpSzVOs = null;
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		try {
			mdmCntrTpSzVOs = dbDao.searchMdmCntrTpSz(event);
			return mdmCntrTpSzVOs;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Common lookup combo list<br>
	 * 
	 * @param String comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	public List<TrsCommonComboVO> searchCombo(String comCode) throws EventException {
		try {
			return dbDao.searchCombo(comCode);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Common lookup combo list<br>
	 * 
	 * @param e
	 * @return List<TrsCommonComboVO>
	 * @exception EventException
	 */
	public List<TrsCommonComboVO> searchComboCustCode(Event e) throws EventException {
		EsdTrs0221Event event = (EsdTrs0221Event) e;
		try {
			return dbDao.searchComboCustCode(event);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Common lookup combo list<br>
	 * 
	 * @param e
	 * @return List<TrsCommonComboVO>
	 * @exception EventException
	 */
	public List<TrsCommonComboVO> searchComboVendor(Event e) throws EventException {
		EsdTrs0221Event event = (EsdTrs0221Event) e;
		try {
			return dbDao.searchComboVendor(event);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * searchChangeWeight
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchChangeWeight(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0999Event event = (EsdTrs0999Event) e;
		try {
			DBRowSet dbRowSet = dbDao.searchChangeWeight(event);
			dbRowSet.next();
			eventResponse.setETCData("wgt_meas_ut_cd", dbRowSet.getString("wgt_meas_ut_cd"));
			eventResponse.setETCData("cntr_wgt", dbRowSet.getString("cntr_wgt"));
			return eventResponse;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
		}
	}
	
	/**
	 * 입력 이벤트 처리<br>
	 * TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY를 입력<br>
	 *
	 * @param soHisVo TrsSOHistoryVO
	 * @exception EventException
	 */
	public void multiSoHistory(TrsSOHistoryVO soHisVo) throws EventException{
		
		try {
			dbDao.multiSoHistory(soHisVo);
		
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * USA/CA Rail S/O Creation 화면 Package Type 조회
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchMdmPckTp(Event e) throws EventException {
		EsdTrs0999Event event = (EsdTrs0999Event) e;
		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet = dbDao.searchMdmPckTp(event);
			StringBuffer mdmPckTp = new StringBuffer();
			
			while (rowSet.next()) {
				mdmPckTp.append(rowSet.getString(1)).append("|");
			}
			
			mdmPckTp.deleteCharAt(mdmPckTp.length() - 1);
			eventResponse.setETCData("pck_tp_cd", mdmPckTp.toString());
			return eventResponse;
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
}
