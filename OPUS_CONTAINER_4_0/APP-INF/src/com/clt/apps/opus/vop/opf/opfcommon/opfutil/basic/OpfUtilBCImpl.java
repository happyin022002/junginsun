/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfUtilBCImpl.java
*@FileTitle : OpfUtil Common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.opf.opfcommon.opfutil.basic;

import java.util.List;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration.OpfUtilDBDAO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfXterCdConvVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.RdrRgnCdVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.SearchVVDVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgContainerVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskCarrierVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.ComComboVO;

/**
 * OPUS-OpfCommon Business Logic Basic Command implementation<br>
 *
 * @author
 * @see Reference each DAO class of OpfUtilEventResponse,OpfUtilBC 
 * @since J2EE 1.4
 */
public class OpfUtilBCImpl extends BasicCommandSupport implements OpfUtilBC {

	// Database Access Object
	private transient OpfUtilDBDAO dbDao = null;

	/**
	 * Creating object OpfUtilBCImpl <br>
	 * Creating OpfUtilDBDAO<br>
	 */
	public OpfUtilBCImpl() {
		dbDao = new OpfUtilDBDAO();
	}
	/**
	 * Retrieve[OPF Combo]<br>
	 * 
	 * @param String comCode
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchCombo(String comCode) throws EventException {
		try {
			return dbDao.searchCombo(comCode);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Com Code Value"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Com Code Value"}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve[I-Stowge Code]<br>
	 * 
	 * @param String comCode
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchComboGeneral(String comCode) throws EventException {
		try {
			return dbDao.searchComboGeneral(comCode);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Com General Value"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Com General Value"}).getMessage(), ex);
		}
	}

	/**
	 * Retrieve[Lane Code]<br>
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException {
		try {
			return dbDao.searchLane(mdmVslSvcLaneVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Lane Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Lane Search"}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve[Lane Code]<br>
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> checkLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException {
		try {
			return dbDao.checkLane(mdmVslSvcLaneVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Lane Check"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Lane Check"}).getMessage(), ex);
		}
	}

	/**
	 * Retrieve[Carrier Code]<br>
	 * 
	 * @param VskCarrierVO vskCarrierVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> checkCarrier(VskCarrierVO vskCarrierVO) throws EventException {
		try {
			return dbDao.checkCarrier(vskCarrierVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Carrier Check"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Carrier Check"}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve [Yard of VVD]<br>
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchVvdYard(VskVslPortSkdVO vskVslPortSkdVO) throws EventException {
		try {
			return dbDao.searchVvdYard(vskVslPortSkdVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Yard"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Yard"}).getMessage(), ex);
		}
	}
	
	/**
	 * Checking VVD <br>
	 * 
	 * @param VskVslSkdVO vskVslSkdVO
	 * @return List<SearchVVDVO>
	 * @exception EventException
	 */
	public List<SearchVVDVO> searchVVD(VskVslSkdVO vskVslSkdVO) throws EventException {
		try {
			return dbDao.searchVVD(vskVslSkdVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Search"}).getMessage(), ex);
		}
	}
		
	/**
	 * Checking Container<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<BkgContainerVO>
	 * @exception EventException
	 */
	public List<BkgContainerVO> searchContainer(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchContainer(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cntr Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cntr Search"}).getMessage(), ex);
		}
	}

	/**
	 * Retrieve[Pod of VVD]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchVskVslPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchVskVslPortList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel VSK Port"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel VSK Port"}).getMessage(), ex);
		}
	}

	/**
	 * Retrieve[Pod of VVD]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchVskVslPortLoadVolList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchVskVslPortLoadVolList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel VSK Port Load"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel VSK Port Load"}).getMessage(), ex);
		}
	}

	/**
	 * Retrieve[Container Type/Size]<br>
	 * 
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> searchCntrTpSzList() throws EventException {
		try {
			return dbDao.searchCntrTpSzList();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cntr Type Size"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cntr Type Size"}).getMessage(), ex);
		}
	}
 
    /**
     * Retrieve Port of VVD Code<br>
     * 
     * @param  OpfUtilSearchOptVO opfUtilSearchOptVO
     * @return List<OpfUtilSearchOptVO>
     * @exception EventException
     */
    public List<OpfUtilSearchOptVO> searchVvdPort(OpfUtilSearchOptVO opfUtilSearchOptVO) throws EventException {
        try {
            return dbDao.searchVvdPort(opfUtilSearchOptVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Port"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Port"}).getMessage(), ex);
        }
    }
    /**
     * Retrieve Port Info. <br>
     * 
     * @param  OpfUtilSearchOptVO opfUtilSearchOptVO
     * @return List<OpfComboVO> 
     * @throws DAOException
     */
    public List<OpfComboVO> searchPortInfo(OpfUtilSearchOptVO opfUtilSearchOptVO) throws EventException{
        try {
            return dbDao.searchPortInfo(opfUtilSearchOptVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Port"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VVD Port"}).getMessage(), ex);
        }
    } 

    /**
     * Checking Container No. Validation in MST_CONTAINE
     * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
     * @return List<OpfComboVO>
     * @throws EventException
     */
	public List<OpfComboVO> searchCntrNoValid(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchCntrNoValid(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cntr Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cntr Search"}).getMessage(), ex);
		}
	}

	/**
	 * Get RHQ_OFC_CD by OFC_CD
	 * @param String sPortCd
	 * @return String
	 * @throws EventException
	 */
	public String searchRHQofPortCd(String sPortCd) throws EventException {
		try {
			return dbDao.searchRHQofPortCd(sPortCd);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"HeadQuarter Office Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"HeadQuarter Office Search"}).getMessage(), ex);
		}
	}
	
	/**
	 * Get RHQ_OFC_CD by OFC_CD
	 * @return List<OpfComboVO>
	 * @throws EventException
	 */
	public List<OpfComboVO> searchRhqCdList() throws EventException {
		try {
			return dbDao.searchRhqCdList();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"HeadQuarter Office Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"HeadQuarter Office Search"}).getMessage(), ex);
		}
	}	
	
	/**
	 * 공통코드를 조회 합니다. <br>
	 * 
	 * @param ComComboVO comComboVO
	 * @return List<ComComboVO>
	 * @exception EventException
	 */
	public List<ComComboVO> searchComComboList(ComComboVO comComboVO) throws EventException {
		try {
			return dbDao.searchComComboList(comComboVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel VSK Port"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Vessel VSK Port"}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve[Region Code]<br>
	 * 
	 * @param RdrRgnCdVO rdrRgnCdVO
	 * @return List<RdrRgnCdVO>
	 * @exception EventException
	 */
	public List<RdrRgnCdVO> searchRegion(RdrRgnCdVO rdrRgnCdVO) throws EventException {
		try {
			return dbDao.searchRegion(rdrRgnCdVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Lane Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Lane Search"}).getMessage(), ex);
		}
	}

	/**
	 * Retrieve[Responsible Party Code]<br>
	 * 
	 * @param VskCarrierVO vskCarrierVO
	 * @return List<OpfXterCdConvVO>
	 * @exception EventException
	 */
	public List<OpfXterCdConvVO> searchParty(VskCarrierVO vskCarrierVO) throws EventException {
		try {
			return dbDao.searchParty(vskCarrierVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Responsible Party Code Check"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Responsible Party Code Check"}).getMessage(), ex);
		}
	}
}