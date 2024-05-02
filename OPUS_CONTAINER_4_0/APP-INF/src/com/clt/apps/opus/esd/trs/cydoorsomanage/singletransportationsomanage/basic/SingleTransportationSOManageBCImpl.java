/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : SingleTransportationSOManageBCImpl.java
 *@FileTitle : CY & Door S/O Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0002Event;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0930Event;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration.SingleTransportationSOManageDBDAO;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS handling business logic.<br>
 * 
 * @author
 * @see ESD_TRS_002EventResponse,SingleTransportationSOManageBC refer to each DAO classes
 * @since
 */
public class SingleTransportationSOManageBCImpl extends BasicCommandSupport implements SingleTransportationSOManageBC {

	// Database Access Object
	private transient SingleTransportationSOManageDBDAO dbDao = null;

	/**
	 * SingleTransportationSOManageBCImpl objects creation<br>
	 * Generate SingleTransportationSOManageDBDAO.<br>
	 */
	public SingleTransportationSOManageBCImpl() {
		dbDao = new SingleTransportationSOManageDBDAO();
	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @return
	 * @exception EventException
	 */
	public String searchSingleTransportationSOCandidatesListK() throws EventException {
		String lSeq = "";
		try {
			lSeq = dbDao.searchSingleTransportationSOCandidatesListK();
			return lSeq;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public List<SingleTransportationVO> searchSingleTransportationSOCandidatesListP(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		try {
			dbDao.searchContiCodeCheck(event);
			return dbDao.searchSingleTransportationSOCandidatesListP(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * 
	 * @param e ESD_TRS_002Event
	 * @param vo
	 * @param lSeq
	 * @exception EventException
	 */
	public void searchSingleTransportationSOCandidatesListC(Event e, List<SingleTransportationVO> vo, String lSeq) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		try {
			dbDao.searchSingleTransportationSOCandidatesListC(event, vo, lSeq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * 
	 * @param e ESD_TRS_002Event
	 * @param lSeq
	 * @exception EventException
	 */
	public void searchSingleTransportationSOCandidatesListU(Event e, String lSeq) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		try {
			dbDao.searchSingleTransportationSOCandidatesListU(event, lSeq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_002Event
	 * @param lSeq
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSingleTransportationSOCandidatesList(Event e, String lSeq) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		try {
			dbDao.searchContiCodeCheck(event);
			eventResponse.setRsVo(dbDao.searchSingleTransportationSOCandidatesList(event, lSeq));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * 
	 * @param lSeq
	 * @exception EventException
	 */
	public void searchSingleTransportationSOCandidatesListD(String lSeq) throws EventException {
		try {
			dbDao.searchSingleTransportationSOCandidatesListD(lSeq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSingleTransportationSOList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		try {
			eventResponse.setRsVo(dbDao.searchSingleTransportationSOList(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * modify event process<br>
	 * ESD_TRS_002 event process<br>
	 * 
	 * @param e ESD_TRS_002Event
	 * @param rowCnt int
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse modifySingleTransportationSOManage(Event e, int rowCnt) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.modifySINGLE_TRANSPORTATION_VO(event, rowCnt);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * modify event process<br>
	 * ESD_TRS_0051 event process<br>
	 * CY & DOOR S/O Correction Separate process
	 * 
	 * @param e ESD_TRS_0051Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public EventResponse modify01SingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.modify01SINGLE_TRANSPORTATION_VO(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * W/O Issued modify event process<br>
	 * ESD_TRS_002 event process<br>
	 * 
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public GeneralEventResponse modify02SingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<TrsTrspSvcOrdVO> seqVoList = new ArrayList<TrsTrspSvcOrdVO>();
		try {
			ArrayList arrSeq = dbDao.modify02SINGLE_TRANSPORTATION_VO(event);
			if (arrSeq != null) {
				for (int m = 0; m < arrSeq.size(); m++) {
					TrsTrspSvcOrdVO seqVo = new TrsTrspSvcOrdVO();
					seqVo.setTrspSoSeq(String.valueOf(arrSeq.get(m)));
					seqVoList.add(seqVo);
				}
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * CY&DOOR Correction S/O delete event process<br>
	 * ESD_TRS_0051 event process<br>
	 * 
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public GeneralEventResponse removeSingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<TrsTrspSvcOrdVO> seqVoList = new ArrayList<TrsTrspSvcOrdVO>();
		try {
			ArrayList arrSeq = dbDao.removeSINGLE_TRANSPORTATION_VO(event);
			if (arrSeq != null) {
				for (int m = 0; m < arrSeq.size(); m++) {
					TrsTrspSvcOrdVO seqVo = new TrsTrspSvcOrdVO();
					seqVo.setTrspSoSeq(String.valueOf(arrSeq.get(m)));
					seqVoList.add(seqVo);
				}
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param singleTransportationVO
	 * @exception EventException
	 */
	public void verifySingleTransportationSOIRG(SingleTransportationVO singleTransportationVO) throws EventException {
		try {
			dbDao.verifySingleTransportationSOIRG(singleTransportationVO.getColumnValues());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * multi event process<br>
	 * ESD_TRS_002 multi event process<br>
	 * 
	 * @param e ESD_TRS_002Event
	 * @param sRow
	 * @return
	 * @exception EventException
	 */
	public String verifySingleTransportationDupChk(Event e, int sRow) throws EventException {
		String sSoNo = "";
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		try {
			dbDao.verifySingleTransportationDupChk(event, sRow);
			return sSoNo;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * multi event process<br>
	 * ESD_TRS_002 multi event process<br>
	 * 
	 * @param e ESD_TRS_002Event
	 * @param sRow
	 * @return
	 * @exception EventException
	 */
	public String multiSingleTransportationSOManage(Event e, int sRow) throws EventException {
		String sSoNo = "";
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		try {
			sSoNo = dbDao.multiSINGLE_TRANSPORTATION_VO(event, sRow);
			return sSoNo;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * modify event process<br>
	 * ESD_TRS_930 event process<br>
	 * 
	 * @param e ESD_TRS_930Event
	 * @return EventResponse ESD_TRS_930EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOfficeTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0930Event event = (EsdTrs0930Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.modifyOfficeSINGLE_TRANSPORTATION_VO(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * modify event process<br>
	 * ESD_TRS_930 event process<br>
	 * 
	 * @param e ESD_TRS_930Event
	 * @return EventResponse ESD_TRS_930EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOfficeTransportationSOManageMT(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0930Event event = (EsdTrs0930Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.modifyOfficeMT_TRANSPORTATION_VO(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * ESD_TRS_930 event process<br>
	 * 
	 * @param e ESD_TRS_930Event
	 * @return EventResponse ESD_TRS_930EventResponse
	 * @exception EventException
	 */
	public EventResponse search10TransportationSOManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0930Event event = (EsdTrs0930Event) e;
		try {
			eventResponse.setRsVo(dbDao.search10TransportationSOManage(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * ESD_TRS_002 event process<br>
	 * 
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubOfficeSOManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchSubOfficeSOManageList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * modify event process<br>
	 * ESD_TRS_002 event process<br>
	 * Actual Customer Info Change cause from Door Location/Zone Modification
	 * 
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchActualCustomerInfoSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0002Event event = (EsdTrs0002Event) e;

		try {
			return dbDao.searchActualCustomerInfoSet(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * SO Candidate delete event process<br>
	 * 
	 * @param e ESD_TRS_002Event
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public List<SingleTransportationVO> removeSOCandidate(Event e) throws EventException {
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		try {
			return dbDao.removeSOCandidate(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Container OffHireVerify check<br>
	 * ESD_TRS_0002 event process<br>
	 * OffHireVerify check
	 * 
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchOffHireVerify(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		try {
			eventResponse.setRsVo(dbDao.searchOffHireVerify(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * CY/Door Cost Mode retrieve according to the change <br>
	 * ESD_TRS_0002 event process<br>
	 * 
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchCostMode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		DBRowSet rowSet = null;
		String comboText = "";
		StringBuilder sb = new StringBuilder();
		try {
			rowSet = dbDao.searchCostMode(event);

			while (rowSet.next()) {
				sb.append(rowSet.getString("CODE") + "|");
			}
			comboText = sb.toString();

			if (comboText.length() > 0)
				comboText = comboText.substring(0, comboText.length() - 1);
			eventResponse.setETCData("COST_MODE", comboText);

			eventResponse.setRsVo(rowSet);
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
	 * S/O issued to the management changes, After History table
	 * 
	 * @param singleTransportationVO
	 * @param replanSts
	 * @throws EventException
	 */
	public void multiSoIssueBeforeHis(SingleTransportationVO singleTransportationVO, String replanSts) throws EventException {
		try {
			dbDao.multiSoIssueBeforeHis(singleTransportationVO, replanSts);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * S/O issued to the management changes, After History table
	 * 
	 * @param singleTransportationVO
	 * @param replanSts
	 * @throws EventException
	 */
	public void multiSoIssueAfterHis(SingleTransportationVO singleTransportationVO, String replanSts) throws EventException {
		try {
			dbDao.multiSoIssueAfterHis(singleTransportationVO, replanSts);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * MDM Container Type/Size
	 * 
	 * @param e
	 * @return GeneralEventResponse
	 * @throws EventException
	 */
	public GeneralEventResponse searchMdmCntrTpSz(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<MdmCntrTpSzVO> list = null;
		EsdTrs0002Event event = (EsdTrs0002Event) e;
		try {
			list = dbDao.searchMdmCntrTpSz(event);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * TRS biz scenario closing<br>
	 * SingleTransportationSOManage clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}
