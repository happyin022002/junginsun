/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EdiTransmitHistoryBCImpl.java
 *@FileTitle : DG EDI Transmit History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.basic;

import java.util.List;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.integration.EdiTransmitHistoryDBDAO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.vo.EdiTransmitHistoryHdrVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.vo.ImdgItemBkgSummaryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;




/**
 * OPUS-DG EDI Transmit History Business Logic Basic Command implementation<br>
 * 
 * @author 
 * @see Reference each DAO class of  VOP_SCG-5011EventResponse,EdiTransmitHistoryBC 
 * @since J2EE 1.6
 */

public class EdiTransmitHistoryBCImpl extends BasicCommandSupport implements EdiTransmitHistoryBC {

	// Database Access Object
	private transient EdiTransmitHistoryDBDAO dbDao = null;

	/**
	 * Creating object EdiTransmitHistoryBCImpl <br>
	 * Creating ReceiveEdiFromParnterLinesMgtDBDAO<br>
	 */
	public EdiTransmitHistoryBCImpl() {
		dbDao = new EdiTransmitHistoryDBDAO();
	}


	/**
	 * Retrieve searchEdiTransmitHistoryHdr <br>
	 * 
	 * @param EdiTransmitHistoryHdrVO VO
	 * @return List<EdiTransmitHistoryHdrVO>
	 * @exception EventException
	 */
	public List<EdiTransmitHistoryHdrVO> searchEdiTransmitHistoryHdr(EdiTransmitHistoryHdrVO vo) throws EventException {
		try {
			return dbDao.searchEdiTransmitHistoryHdr(vo);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG EDI Transmit History"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG EDI Transmit History"}).getMessage(), ex);
        }
	}

	/**
	 * Retrieve searchEdiTransmitHistoryDtl <br>
	 * 
	 * @param EdiTransmitHistoryHdrVO VO
	 * @return List<EdiTransmitHistoryHdrVO>
	 * @exception EventException
	 */
	public List<EdiTransmitHistoryHdrVO> searchEdiTransmitHistoryDtl(EdiTransmitHistoryHdrVO vo) throws EventException {
		try {
			return dbDao.searchEdiTransmitHistoryDtl(vo);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG EDI Transmit History"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG EDI Transmit History"}).getMessage(), ex);
        }
	}

	/**
	 * Retrieve searchEdiTransmitHistoryDtl <br>
	 * 
	 * @param ImdgItemBkgSummaryVO VO
	 * @return List<ImdgItemBkgSummaryVO>
	 * @exception EventException
	 */
	public List<ImdgItemBkgSummaryVO> searchImdgItemBkgSummary(ImdgItemBkgSummaryVO vo) throws EventException {
		try {
			return dbDao.searchImdgItemBkgSummary(vo);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG EDI Transmit History"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG EDI Transmit History"}).getMessage(), ex);
        }
	}
	
	/**
	 * Retrieve searchEdiTransmitFlatFile <br>
	 * 
	 * @param EdiTransmitHistoryHdrVO VO
	 * @return List<EdiTransmitHistoryHdrVO>
	 * @exception EventException
	 */
	public List<EdiTransmitHistoryHdrVO> searchEdiTransmitFlatFile(EdiTransmitHistoryHdrVO vo) throws EventException {
		try {
			return dbDao.searchEdiTransmitFlatFile(vo);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"EDI Transmit Flat File"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"EDI Transmit Flat File"}).getMessage(), ex);
        }
	}
}