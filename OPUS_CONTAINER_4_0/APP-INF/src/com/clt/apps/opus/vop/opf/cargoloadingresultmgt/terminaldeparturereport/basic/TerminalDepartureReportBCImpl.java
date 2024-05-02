/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalDepartureReportBCImpl.java
*@FileTitle : TDR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration.TerminalDepartureReportDBDAO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.CgoHndPerformInputVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.CgoRhndPerformInputVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.DischVolSGTdrVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MdmRhqComboVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MissingTDRCondVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MissingTDRVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfTmlProdRptRsnCdVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.PortLogDetailVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.PortLogHeadVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrAllocationBSAVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrBsaVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrDistLoadVolVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrHeaderSkdVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrSlotHC45VO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrUtilizeSlotPortVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrUtilizeVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportConditionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformInputVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.VskVslPortSkdSheetVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmYardVO;
import com.clt.syscommon.common.table.OpfRstwgRsnCdVO;
import com.clt.syscommon.common.table.OpfTmlDepRptDtlVO;
import com.clt.syscommon.common.table.TdrAllocationVO;
import com.clt.syscommon.common.table.TdrCntrDetailVO;
import com.clt.syscommon.common.table.TdrCraneVO;
import com.clt.syscommon.common.table.TdrHeaderVO;
import com.clt.syscommon.common.table.TdrSummaryVO;

/**
 * OPUS-CargoLoadingResultMgt Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see Reference each DAO class of VOP_OPF_0036EventResponse,TerminalDepartureReportBC 
 * @since J2EE 1.6
 */
public class TerminalDepartureReportBCImpl extends BasicCommandSupport implements TerminalDepartureReportBC {

	// Database Access Object
	private transient TerminalDepartureReportDBDAO dbDao = null;

	/**
	 * Creating object TerminalDepartureReportBCImpl <br>
	 * Creating TerminalDepartureReportDBDAO<br>
	 */
	public TerminalDepartureReportBCImpl() {
		dbDao = new TerminalDepartureReportDBDAO();
	}
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR VESSAL SCHEDULE]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<VskVslPortSkdSheetVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdSheetVO> searchTdrSKDList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchTdrSKDList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Tdr Vessal Schedule"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Tdr Vessal Schedule"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Header]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrHeaderSkdVO>
	 * @exception EventException
	 */
	public List<TdrHeaderSkdVO> searchTdrHeaderList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchTdrHeaderList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Tdr Header"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Tdr Header"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Port Log]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<PortLogHeadVO>
	 * @exception EventException
	 */
	public List<PortLogHeadVO> searchTdrPortLogHeadList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchTdrPortLogHeadList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Port Log"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Port Log"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Port Log Detail]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<PortLogDetailVO>
	 * @exception EventException
	 */
	public List<PortLogDetailVO> searchTdrPortLogDetailList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchTdrPortLogDetailList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Port Log Crane"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Port Log Crane"}).getMessage(), ex);
		}
	}
	

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Discharge Total Volume Import]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrDistLoadVolVO>
	 * @exception EventException
	 */
	public List<TdrDistLoadVolVO> searchBkgVolumeDischTotal(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchBkgVolumeDischTotal(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Total Volume Import"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Total Volume Import"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Discharge Total Volume]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrDistLoadVolVO>
	 * @exception EventException
	 */
	public List<TdrDistLoadVolVO> searchTdrDischargeTotalList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrDischargeTotalList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Total Volume"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Total Volume"}).getMessage(), ex);
		}
	}
	

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Discharge SCG Import]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<DischVolSGTdrVO>
	 * @exception EventException
	 */
	public List<DischVolSGTdrVO> searchBkgVolumeDischSG(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchBkgVolumeDischSG(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR SCG Import"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR SCG Import"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Load SCG]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<DischVolSGTdrVO>
	 * @exception EventException
	 */
	public List<DischVolSGTdrVO> searchTdrLoadSGList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchTdrLoadSGList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Load SCG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Load SCG"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Discharge SCG]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<DischVolSGTdrVO>
	 * @exception EventException
	 */
	public List<DischVolSGTdrVO> searchTdrDischargeSGList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrDischargeSGList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR SCG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR SCG"}).getMessage(), ex);
		}
	}
	

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Discharge Break Bulk Import]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchBkgVolumeDischBreak(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchBkgVolumeDischBreak(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Break Bulk Import"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Break Bulk Import"}).getMessage(), ex);
		}
	}	
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Discharge Break Bulk]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchTdrDischargeBreakList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrDischargeBreakList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Break Bulk"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Break Bulk"}).getMessage(), ex);
		}
	}	
		
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Load Break Bulk Import]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrDistLoadVolVO> searchBkgVolumeLoadTotal(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchBkgVolumeLoadTotal(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Break Bulk Import"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Break Bulk Import"}).getMessage(), ex);
		}
	}	

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Load SCG Import]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<DischVolSGTdrVO>
	 * @exception EventException
	 */
	public List<DischVolSGTdrVO> searchBkgVolumeLoadSG(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchBkgVolumeLoadSG(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR SCG Import"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR SCG Import"}).getMessage(), ex);
		}
	}	
	 
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Load Break Bulk Import]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchBkgVolumeLoadBreak(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchBkgVolumeLoadBreak(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Break Bulk Import"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Break Bulk Import"}).getMessage(), ex);
		}
	}	

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR COD]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchTdrCodList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrCodList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR COD"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR COD"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Ocean Port]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrDistLoadVolVO>
	 * @exception EventException
	 */
	public List<TdrDistLoadVolVO> searchTdrLoadOceanPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrLoadOceanPortList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Ocean Port"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Ocean Port"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR ReHandle]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchTdrRHList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrRHList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Re Handle"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Re Handle"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR MisHandle]<br>
	 * 
	 * @param   TerminalDepartureReportConditionVO terminalDepartureReportCondVO  
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchTdrMisHandleList(TerminalDepartureReportConditionVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrMisHandleList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Mis Handle"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Mis Handle"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Slot BSA]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrAllocationBSAVO>
	 * @exception EventException
	 */
	public List<TdrAllocationBSAVO> searchTdrSlotBSAList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrSlotBSAList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot BSA"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot BSA"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Slot BSA Import]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrAllocationBSAVO>
	 * @exception EventException
	 */
	public List<TdrAllocationBSAVO> searchTdrSlotBSAImportList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrSlotBSAImportList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot BSA Import"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot BSA Import"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Slot HC45']<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrSlotHC45VO>
	 * @exception EventException
	 */
	public List<TdrSlotHC45VO> searchTdrSlotHC45List(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrSlotHC45List(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot HC45'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot HC45'"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Slot HC45' Import]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrSlotHC45VO>
	 * @exception EventException
	 */
	public List<TdrSlotHC45VO> searchTdrSlotHC45ImportList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException {
		try {
			return dbDao.searchTdrSlotHC45ImportList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot HC45' Import"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot HC45' Import"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Slot Dep]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrUtilizeSlotPortVO>
	 * @exception EventException
	 */
	public List<TdrUtilizeSlotPortVO> searchTdrSlotDepList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrSlotDepList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot Dep"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot Dep"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Slot Port]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrUtilizeSlotPortVO>
	 * @exception EventException
	 */
	public List<TdrUtilizeSlotPortVO> searchTdrSlotPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrSlotPortList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot Port"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot Port"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Slot Port Import]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrUtilizeSlotPortVO>
	 * @exception EventException
	 */
	public List<TdrUtilizeSlotPortVO> searchTdrSlotPortImpList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrSlotPortImpList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot Port Import"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot Port Import"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR Slot Dep Import]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrAllocationBSAVO>
	 * @throws DAOException
	 */
	public List<TdrUtilizeSlotPortVO> searchTdrSlotDepImportList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrSlotDepImportList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot Dep Import"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Slot Dep Import"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR TmpStwg]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchTdrTmpStwgList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrTmpStwgList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR TmpStwg"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR TmpStwg"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0040 : Retrieve <br>
	 * Retrieve [TDR ReHandle Code]<br>
	 * 
	 * @param opfRstwgRsnCdVO OpfRstwgRsnCdVO 
	 * @return List<OpfRstwgRsnCdVO>
	 * @exception EventException
	 */
	public List<OpfRstwgRsnCdVO> searchTdrRHReasonCdList(OpfRstwgRsnCdVO opfRstwgRsnCdVO) throws EventException{
		try {
			return dbDao.searchTdrRHReasonCdList(opfRstwgRsnCdVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR ReHandle Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR ReHandle Code"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0040 : Retrieve <br>
	 * Retrieve [Exclude Tpr]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<OpfTmlProdRptRsnCdVO>
	 * @exception EventException
	 */
	public List<OpfTmlProdRptRsnCdVO> searchExcludeTpr(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchExcludeTpr(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Exclude Tpr"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Exclude Tpr"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Creating, Updating, Deleting [TERMINAL DEPARTURE REPORT HEADER] <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdr(TdrHeaderVO[] tdrHeaderVO, SignOnUserAccount account) throws EventException{
		try {
			List<TdrHeaderVO> insertVoList = new ArrayList<TdrHeaderVO>();
			List<TdrHeaderVO> updateVoList = new ArrayList<TdrHeaderVO>();
			List<TdrHeaderVO> deleteVoList = new ArrayList<TdrHeaderVO>();
			for ( int i=0; i< tdrHeaderVO.length; i++ ) {
				if ( tdrHeaderVO[i].getIbflag().equals("I")){
					tdrHeaderVO[i].setUpdateUser(account.getUsr_id());
					insertVoList.add(tdrHeaderVO[i]);
				} else if ( tdrHeaderVO[i].getIbflag().equals("U")){
					tdrHeaderVO[i].setUpdateUser(account.getUsr_id());
					updateVoList.add(tdrHeaderVO[i]); 
				} else if ( tdrHeaderVO[i].getIbflag().equals("D")){
					deleteVoList.add(tdrHeaderVO[i]);
				}
			}
		
			if ( insertVoList.size() > 0 ) {
				dbDao.addTdrS(insertVoList);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyTdrS(updateVoList);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeTdrAll(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report HEADER"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report HEADER"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Creating, Updating, Deleting [TERMINAL DEPARTURE REPORT CRANE] <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param portLogDetailVO PortLogDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrCrane(TdrHeaderVO[] tdrHeaderVO, PortLogDetailVO[] portLogDetailVO, SignOnUserAccount account) throws EventException{
		try {
			List<TdrHeaderVO> headerVoList = new ArrayList<TdrHeaderVO>();

			List<TdrCraneVO> insertVoList = new ArrayList<TdrCraneVO>();
			List<TdrCraneVO> deleteVoList = new ArrayList<TdrCraneVO>();
			
			tdrHeaderVO[0].setUpdateUser(account.getUsr_id());
			headerVoList.add(tdrHeaderVO[0]);
			
			TdrCraneVO delVO = new TdrCraneVO();
			
			String vslCd = tdrHeaderVO[0].getVslCd();
			String voyNo = tdrHeaderVO[0].getVoyNo();
			String dirCd = tdrHeaderVO[0].getDirCd();
			String portCd = tdrHeaderVO[0].getPortCd();
			String callInd = tdrHeaderVO[0].getCallInd();
			
			delVO.setVslCd(vslCd);
			delVO.setVoyNo(voyNo);
			delVO.setDirCd(dirCd);
			delVO.setPortCd(portCd);
			delVO.setCallInd(callInd);
			
			deleteVoList.add(delVO);
			if(portLogDetailVO != null){
				for ( int i=0; i< portLogDetailVO.length; i++ ) {
					TdrCraneVO insVO = new TdrCraneVO();
	
					insVO.setVslCd(vslCd);
					insVO.setVoyNo(voyNo);
					insVO.setDirCd(dirCd);
					insVO.setPortCd(portCd);
					insVO.setCallInd(callInd);
					insVO.setCraneNo(Integer.toString(i + 1));
					insVO.setStartDate(portLogDetailVO[i].getWorkComm());
					insVO.setEndDate(portLogDetailVO[i].getWorkComp());
					insVO.setBdtTime(hourMinuteStr(portLogDetailVO[i].getBreakDown()));
					insVO.setMtTime(hourMinuteStr(portLogDetailVO[i].getMeal()));
					insVO.setBwTime(hourMinuteStr(portLogDetailVO[i].getWeather()));
					insVO.setOtherTime(hourMinuteStr(portLogDetailVO[i].getOther()));
					//2014-08-26 추가
					String work = (String)(portLogDetailVO[i].getWork()).replaceAll(":", "");
					
					insVO.setWorkTime(hourMinuteStr(work));
					
					insVO.setLoseTime(hourMinuteStr(portLogDetailVO[i].getTotal()));
					insVO.setUpdateUser(account.getUsr_id());
					
					insertVoList.add(insVO);
				}
			}
		
			if(tdrHeaderVO[0].getIbflag().equals("I")){
				dbDao.addTdrS(headerVoList);
			}else{
				dbDao.modifyTdrS(headerVoList);
			}
			dbDao.deleteTdrCraneS(deleteVoList);
			
			if(insertVoList.size() > 0){
				dbDao.addTdrCaneS(insertVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Crane"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Crane"}).getMessage(), ex);
        }
	}	
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Creating, Updating, Deleting [TERMINAL DEPARTURE REPORT Total] <br>
	 * 
	 * @param TdrHeaderVO[] tdrHeaderVO
	 * @param TdrDistLoadVolVO[] tdrDistLoadVolVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTdrDischTotal(TdrHeaderVO[] tdrHeaderVO, TdrDistLoadVolVO[] tdrDistLoadVolVO, SignOnUserAccount account) throws EventException{
		try {
			List<TdrHeaderVO> headerVoList = new ArrayList<TdrHeaderVO>();
			
			List<TdrSummaryVO> insertVoList = new ArrayList<TdrSummaryVO>();
			List<TdrSummaryVO> deleteVoList = new ArrayList<TdrSummaryVO>();
			List<TdrSummaryVO> deleteAllVoList = new ArrayList<TdrSummaryVO>();

			tdrHeaderVO[0].setUpdateUser(account.getUsr_id());
			headerVoList.add(tdrHeaderVO[0]);
			
			if(tdrHeaderVO[0].getIbflag().equals("I")){
				dbDao.addTdrS(headerVoList);
			}
			
			if(tdrDistLoadVolVO != null && tdrDistLoadVolVO.length > 0){
				//Adding Delete All Logic in case of Import 
				if(!tdrDistLoadVolVO[0].getIdxSheet().equals("") && Integer.parseInt(tdrDistLoadVolVO[0].getIdxSheet()) > 2){
					convertDelAllToSummaryVO(deleteAllVoList, tdrHeaderVO[0], tdrDistLoadVolVO[0], Integer.parseInt(tdrDistLoadVolVO[0].getIdxSheet()) - 3);
				}
				
				for ( int i=0; i< tdrDistLoadVolVO.length; i++ ) {
					if ( tdrDistLoadVolVO[i].getIbflag().equals("I")){
						int idxSheet = 0;
						
						if(!tdrDistLoadVolVO[i].getIdxSheet().equals("") && Integer.parseInt(tdrDistLoadVolVO[i].getIdxSheet()) > 2)
							idxSheet = Integer.parseInt(tdrDistLoadVolVO[i].getIdxSheet()) - 3;
						else
							idxSheet = Integer.parseInt(tdrDistLoadVolVO[i].getIdxSheet());

						this.convertSheetToSummaryVO(insertVoList, tdrHeaderVO[0], tdrDistLoadVolVO[i], account, idxSheet);
					}else if( tdrDistLoadVolVO[i].getIbflag().equals("U")){
						convertDelToSummaryVO(deleteVoList, tdrHeaderVO[0], tdrDistLoadVolVO[i], Integer.parseInt(tdrDistLoadVolVO[i].getIdxSheet()));
						this.convertSheetToSummaryVO(insertVoList, tdrHeaderVO[0], tdrDistLoadVolVO[i], account, Integer.parseInt(tdrDistLoadVolVO[i].getIdxSheet()));
					}else if( tdrDistLoadVolVO[i].getIbflag().equals("D")){
						convertDelToSummaryVO(deleteVoList, tdrHeaderVO[0], tdrDistLoadVolVO[i], Integer.parseInt(tdrDistLoadVolVO[i].getIdxSheet()));
					}
				}
				
				if(deleteAllVoList.size() > 0){
					dbDao.deleteTdrSummaryTotalS(deleteAllVoList);
				}
				
				if(deleteVoList.size() > 0){
					dbDao.deleteTdrSummaryDisTotal(deleteVoList);
				}
				
				if(insertVoList.size() > 0){
					dbDao.addTdrSummaryS(insertVoList);
				}
			}

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Total"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Total"}).getMessage(), ex);
        }
	}
    /**
     * VOP_OPF_0036 : Save <br>
     * Creating, Updating, Deleting [TERMINAL DEPARTURE REPORT Total] <br>
     * 
     * @param TdrHeaderVO[] tdrHeaderVO
     * @param TdrDistLoadVolVO[] tdrDistLoadVolVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTdrLoad(TdrHeaderVO[] tdrHeaderVO, TdrDistLoadVolVO[] tdrDistLoadVolVO, SignOnUserAccount account) throws EventException{
        try {
            List<TdrHeaderVO> headerVoList = new ArrayList<TdrHeaderVO>();
            
            List<TdrSummaryVO> insertVoList = new ArrayList<TdrSummaryVO>();
            List<TdrSummaryVO> deleteVoList = new ArrayList<TdrSummaryVO>();
            List<TdrSummaryVO> deleteAllVoList = new ArrayList<TdrSummaryVO>();

            tdrHeaderVO[0].setUpdateUser(account.getUsr_id());
            headerVoList.add(tdrHeaderVO[0]);
            
            if(tdrHeaderVO[0].getIbflag().equals("I")){
                dbDao.addTdrS(headerVoList);
            }
            
            if(tdrDistLoadVolVO != null && tdrDistLoadVolVO.length > 0){
            	//Adding Delete All Logic in case of Import 
                if(!tdrDistLoadVolVO[0].getIdxSheet().equals("") && Integer.parseInt(tdrDistLoadVolVO[0].getIdxSheet()) > 2){
                    convertDelAllToSummaryVO(deleteAllVoList, tdrHeaderVO[0], tdrDistLoadVolVO[0], Integer.parseInt(tdrDistLoadVolVO[0].getIdxSheet()) - 3);
                }
                
                for ( int i=0; i< tdrDistLoadVolVO.length; i++ ) {
                    if ( tdrDistLoadVolVO[i].getIbflag().equals("I")){
                        int idxSheet = 0;
                        
                        if(!tdrDistLoadVolVO[i].getIdxSheet().equals("") && Integer.parseInt(tdrDistLoadVolVO[i].getIdxSheet()) > 2)
                            idxSheet = Integer.parseInt(tdrDistLoadVolVO[i].getIdxSheet()) - 3;
                        else
                            idxSheet = Integer.parseInt(tdrDistLoadVolVO[i].getIdxSheet());

                        convertSheetToSummaryVO(insertVoList, tdrHeaderVO[0], tdrDistLoadVolVO[i], account, idxSheet);
                    }else if( tdrDistLoadVolVO[i].getIbflag().equals("U")){
                        convertDelToSummaryVO(deleteVoList, tdrHeaderVO[0], tdrDistLoadVolVO[i], Integer.parseInt(tdrDistLoadVolVO[i].getIdxSheet()));
                        convertSheetToSummaryVO(insertVoList, tdrHeaderVO[0], tdrDistLoadVolVO[i], account, Integer.parseInt(tdrDistLoadVolVO[i].getIdxSheet()));
                    }else if( tdrDistLoadVolVO[i].getIbflag().equals("D")){
                        convertDelToSummaryVO(deleteVoList, tdrHeaderVO[0], tdrDistLoadVolVO[i], Integer.parseInt(tdrDistLoadVolVO[i].getIdxSheet()));
                    }
                }
                
                if(deleteAllVoList.size() > 0){
                    dbDao.deleteTdrSummaryTotalS(deleteAllVoList);
                }
                
                if(deleteVoList.size() > 0){
                    dbDao.deleteTdrSummaryDisTotal(deleteVoList);
                }
                
                if(insertVoList.size() > 0){
                    dbDao.addTdrSummaryS(insertVoList);
                }
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Total"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Total"}).getMessage(), ex);
        }
    }
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Creating, Updating, Deleting [TERMINAL DEPARTURE REPORT SCG] <br>
	 * 
	 * @param TdrHeaderVO[] tdrHeaderVO
	 * @param DischVolSGTdrVO[] dischVolSGTdrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTdrDischSG(TdrHeaderVO[] tdrHeaderVO, DischVolSGTdrVO[] dischVolSGTdrVO, SignOnUserAccount account) throws EventException{
		try {
			List<TdrSummaryVO> insertVoList = new ArrayList<TdrSummaryVO>();
			List<TdrSummaryVO> deleteVoList = new ArrayList<TdrSummaryVO>();
			List<TdrSummaryVO> deleteAllVoList = new ArrayList<TdrSummaryVO>();
			
			if(dischVolSGTdrVO != null && dischVolSGTdrVO.length > 0){
				//Adding Delete All Logic in case of Import 
				if(!dischVolSGTdrVO[0].getIdxSheet().equals("") && Integer.parseInt(dischVolSGTdrVO[0].getIdxSheet()) > 1){
					convertSCDelAllToSummaryDeVO(deleteAllVoList, tdrHeaderVO[0], dischVolSGTdrVO[0], Integer.parseInt(dischVolSGTdrVO[0].getIdxSheet()) - 2);
				}				
				
				for ( int i=0; i< dischVolSGTdrVO.length; i++ ) {
					if ( dischVolSGTdrVO[i].getIbflag().equals("I")){
						int idxSheet = 0;
						
						if(!dischVolSGTdrVO[0].getIdxSheet().equals("") && Integer.parseInt(dischVolSGTdrVO[0].getIdxSheet()) > 1)
							idxSheet = Integer.parseInt(dischVolSGTdrVO[0].getIdxSheet()) - 2;
						else
							idxSheet = Integer.parseInt(dischVolSGTdrVO[0].getIdxSheet());

						convertSCSheetToSummaryVO(insertVoList, tdrHeaderVO[0], dischVolSGTdrVO[i], account, idxSheet);
					}else if( dischVolSGTdrVO[i].getIbflag().equals("U")){
					    log.debug(" dischVolSGTdrVO[i].getIdxSheet() "+dischVolSGTdrVO[i].getIdxSheet() );
						convertSCDelToSummaryDeVO(deleteVoList, tdrHeaderVO[0], dischVolSGTdrVO[i], Integer.parseInt(dischVolSGTdrVO[i].getIdxSheet()));
						convertSCSheetToSummaryVO(insertVoList, tdrHeaderVO[0], dischVolSGTdrVO[i], account, Integer.parseInt(dischVolSGTdrVO[i].getIdxSheet()));
					}else if( dischVolSGTdrVO[i].getIbflag().equals("D")){
						convertSCDelToSummaryDeVO(deleteVoList, tdrHeaderVO[0], dischVolSGTdrVO[i], Integer.parseInt(dischVolSGTdrVO[i].getIdxSheet()));
					}
				}
			}
			
			if(deleteAllVoList.size() > 0){
				dbDao.deleteTdrSummarySGS(deleteAllVoList);
			}
			
			if(deleteVoList.size() > 0){
				dbDao.deleteTdrSummaryDischSG(deleteVoList);
			}
			
			if(insertVoList.size() > 0){
				dbDao.addTdrSummaryS(insertVoList);
			}
				
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report SCG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report SCG"}).getMessage(), ex);
        }
	}

    /**
     * VOP_OPF_0036 : Save <br>
     * Creating, Updating, Deleting [TERMINAL DEPARTURE REPORT SCG] <br>
     * 
     * @param TdrHeaderVO[] tdrHeaderVO
     * @param DischVolSGTdrVO[] dischVolSGTdrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTdrLoadSG(TdrHeaderVO[] tdrHeaderVO, DischVolSGTdrVO[] dischVolSGTdrVO, SignOnUserAccount account) throws EventException{
        try {
            List<TdrSummaryVO> insertVoList = new ArrayList<TdrSummaryVO>();
            List<TdrSummaryVO> deleteVoList = new ArrayList<TdrSummaryVO>();
            List<TdrSummaryVO> deleteAllVoList = new ArrayList<TdrSummaryVO>();
            
            if(dischVolSGTdrVO != null && dischVolSGTdrVO.length > 0){
                //Adding Delete All Logic in case of Import 
                if(!dischVolSGTdrVO[0].getIdxSheet().equals("") && Integer.parseInt(dischVolSGTdrVO[0].getIdxSheet()) > 1){
                    convertSCDelAllToSummaryDeVO(deleteAllVoList, tdrHeaderVO[0], dischVolSGTdrVO[0], Integer.parseInt(dischVolSGTdrVO[0].getIdxSheet()) - 2);
                }               
                
                for ( int i=0; i< dischVolSGTdrVO.length; i++ ) {
                    if ( dischVolSGTdrVO[i].getIbflag().equals("I")){
                        int idxSheet = 0;
                        
                        if(!dischVolSGTdrVO[0].getIdxSheet().equals("") && Integer.parseInt(dischVolSGTdrVO[0].getIdxSheet()) > 1)
                            idxSheet = Integer.parseInt(dischVolSGTdrVO[0].getIdxSheet()) - 2;
                        else
                            idxSheet = Integer.parseInt(dischVolSGTdrVO[0].getIdxSheet());
                        
                        log.error("\n TDR LOAD VOLUME VO.length ["+dischVolSGTdrVO.length+"] >>> original ["+Integer.parseInt(dischVolSGTdrVO[0].getIdxSheet())+"] :: VS :: idxSheet revised idxSheet ["+idxSheet+"]");

                        this.convertSCSheetToSummaryVO(insertVoList, tdrHeaderVO[0], dischVolSGTdrVO[i], account, idxSheet);
                    }else if( dischVolSGTdrVO[i].getIbflag().equals("U")){
                        convertSCDelToSummaryLoadAkDeVO(deleteVoList, tdrHeaderVO[0], dischVolSGTdrVO[i], Integer.parseInt(dischVolSGTdrVO[i].getIdxSheet()));
                        convertSCDelToSummaryDeVO(deleteVoList, tdrHeaderVO[0], dischVolSGTdrVO[i], Integer.parseInt(dischVolSGTdrVO[i].getIdxSheet()));
                        this.convertSCSheetToSummaryVO(insertVoList, tdrHeaderVO[0], dischVolSGTdrVO[i], account, Integer.parseInt(dischVolSGTdrVO[i].getIdxSheet()));
                    }else if( dischVolSGTdrVO[i].getIbflag().equals("D")){
                        convertSCDelToSummaryLoadAkDeVO(deleteVoList, tdrHeaderVO[0], dischVolSGTdrVO[i], Integer.parseInt(dischVolSGTdrVO[i].getIdxSheet()));
                        convertSCDelToSummaryDeVO(deleteVoList, tdrHeaderVO[0], dischVolSGTdrVO[i], Integer.parseInt(dischVolSGTdrVO[i].getIdxSheet()));
                    }
                }
            }
            
            if(deleteAllVoList.size() > 0){
                dbDao.deleteTdrSummarySGS(deleteAllVoList);
            }
            
            if(deleteVoList.size() > 0){
               dbDao.deleteTdrSummaryLoadSG(deleteVoList);
            }
            
            if(insertVoList.size() > 0){
            	dbDao.deleteTdrSummaryLoadSG(insertVoList);	////:Add:2016-12-14:////
                dbDao.addTdrSummaryS		(insertVoList);
            }
                
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report SCG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report SCG"}).getMessage(), ex);
        }
    }	
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Creating, Updating, Deleting [TERMINAL DEPARTURE REPORT Break Bulk] <br>
	 * 
	 * @param TdrHeaderVO[] tdrHeaderVO
	 * @param TdrCntrDetailVO[] tdrCntrDetailVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTdrDischBreak(TdrHeaderVO[] tdrHeaderVO, TdrCntrDetailVO[] tdrCntrDetailVO, SignOnUserAccount account) throws EventException{
		try{
			List<TdrCntrDetailVO> insertVoList = new ArrayList<TdrCntrDetailVO>();
			List<TdrCntrDetailVO> updateVoList = new ArrayList<TdrCntrDetailVO>();
			List<TdrCntrDetailVO> deleteVoList = new ArrayList<TdrCntrDetailVO>();
			List<TdrCntrDetailVO> deleteAllVoList = new ArrayList<TdrCntrDetailVO>();
			
			if(tdrCntrDetailVO != null && tdrCntrDetailVO.length > 0){
				//Adding Delete All Logic in case of Import .
				if(!tdrCntrDetailVO[0].getCodChk().equals("") && Integer.parseInt(tdrCntrDetailVO[0].getCodChk()) > 1){
					TdrCntrDetailVO tempVO = new TdrCntrDetailVO();
					
					tempVO.setVslCd(tdrHeaderVO[0].getVslCd());
					tempVO.setVoyNo(tdrHeaderVO[0].getVoyNo());
					tempVO.setDirCd(tdrHeaderVO[0].getDirCd());
					tempVO.setPortCd(tdrHeaderVO[0].getPortCd());
					tempVO.setCallInd(tdrHeaderVO[0].getCallInd());
					
					if(tdrCntrDetailVO[0].getCodChk().equals("2")){
						tempVO.setStatus("DS");
					}else{
						tempVO.setStatus("LI");
					}
					deleteAllVoList.add(tempVO);
				}				

				for ( int i=0; i< tdrCntrDetailVO.length; i++ ) {
					tdrCntrDetailVO[i].setVslCd(tdrHeaderVO[0].getVslCd());
					tdrCntrDetailVO[i].setVoyNo(tdrHeaderVO[0].getVoyNo());
					tdrCntrDetailVO[i].setDirCd(tdrHeaderVO[0].getDirCd());
					tdrCntrDetailVO[i].setPortCd(tdrHeaderVO[0].getPortCd());
					tdrCntrDetailVO[i].setCallInd(tdrHeaderVO[0].getCallInd());
					
					if(tdrCntrDetailVO[i].getCodChk().equals("0") || tdrCntrDetailVO[i].getCodChk().equals("2")){
						tdrCntrDetailVO[i].setStatus("DS");
					}else{
						tdrCntrDetailVO[i].setStatus("LS");
	                   //  tdrCntrDetailVO[i].setStatus("LI");
					}
					
					//Adding CargoType to match with I Stowage data
					tdrCntrDetailVO[i].setCargoType("BB");
					
					if ( tdrCntrDetailVO[i].getIbflag().equals("I")){
						tdrCntrDetailVO[i].setUpdateUser(account.getUsr_id());
						insertVoList.add(tdrCntrDetailVO[i]);
					} else if ( tdrCntrDetailVO[i].getIbflag().equals("U")){
						tdrCntrDetailVO[i].setUpdateUser(account.getUsr_id());
						updateVoList.add(tdrCntrDetailVO[i]); 
					} else if ( tdrCntrDetailVO[i].getIbflag().equals("D")){
						deleteVoList.add(tdrCntrDetailVO[i]);
					}
				}
				
				if(deleteAllVoList.size() > 0){
					dbDao.removeTdrCntrBreakS(insertVoList);
				}
				
				if(insertVoList.size() > 0){
					dbDao.addTdrCntrS(insertVoList);
				}
				
				if(updateVoList.size() > 0){
					dbDao.modifyTdrCntrS(updateVoList);
				}
				
				if(deleteVoList.size() > 0){
					dbDao.removeTdrCntrS(deleteVoList);
				}
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Break Bulk"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Break Bulk"}).getMessage(), ex);
        }
	}

	
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Creating, Updating, Deleting [TERMINAL DEPARTURE REPORT COD] <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param tdrCntrDetailVO TdrCntrDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrCod(TdrHeaderVO[] tdrHeaderVO, TdrCntrDetailVO[] tdrCntrDetailVO, SignOnUserAccount account) throws EventException{
		try{
			List<TdrHeaderVO> headerVoList = new ArrayList<TdrHeaderVO>();

			List<TdrCntrDetailVO> insertVoList = new ArrayList<TdrCntrDetailVO>();
			List<TdrCntrDetailVO> updateVoList = new ArrayList<TdrCntrDetailVO>();
			List<TdrCntrDetailVO> deleteVoList = new ArrayList<TdrCntrDetailVO>();

			tdrHeaderVO[0].setUpdateUser(account.getUsr_id());
			headerVoList.add(tdrHeaderVO[0]);

			if(tdrHeaderVO[0].getIbflag().equals("I")){
				dbDao.addTdrS(headerVoList);
			}
			
			
			if(tdrCntrDetailVO != null){
				for ( int i=0; i< tdrCntrDetailVO.length; i++ ) {
					tdrCntrDetailVO[i].setVslCd(tdrHeaderVO[0].getVslCd());
					tdrCntrDetailVO[i].setVoyNo(tdrHeaderVO[0].getVoyNo());
					tdrCntrDetailVO[i].setDirCd(tdrHeaderVO[0].getDirCd());
					tdrCntrDetailVO[i].setPortCd(tdrHeaderVO[0].getPortCd());
					tdrCntrDetailVO[i].setCallInd(tdrHeaderVO[0].getCallInd());
					tdrCntrDetailVO[i].setStatus("LS");		
					
					if ( tdrCntrDetailVO[i].getIbflag().equals("I")){
						tdrCntrDetailVO[i].setUpdateUser(account.getUsr_id());
						insertVoList.add(tdrCntrDetailVO[i]);
					} else if ( tdrCntrDetailVO[i].getIbflag().equals("U")){
						tdrCntrDetailVO[i].setUpdateUser(account.getUsr_id());
						updateVoList.add(tdrCntrDetailVO[i]); 
					} else if ( tdrCntrDetailVO[i].getIbflag().equals("D")){
						deleteVoList.add(tdrCntrDetailVO[i]);
					}
				}
				
				if(insertVoList.size() > 0){
					dbDao.addTdrCntrS(insertVoList);
				}
				
				if(updateVoList.size() > 0){
					dbDao.modifyTdrCntrS(updateVoList);
				}
				
				if(deleteVoList.size() > 0){
					dbDao.removeTdrCntrS(deleteVoList);
				}
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report COD"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report COD"}).getMessage(), ex);
        }
	}	
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Creating, Updating, Deleting  [TERMINAL DEPARTURE REPORT ReHandle] <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param tdrCntrDetailVO TdrCntrDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrRH(TdrHeaderVO[] tdrHeaderVO, TdrCntrDetailVO[] tdrCntrDetailVO, SignOnUserAccount account) throws EventException{
		try{
			List<TdrHeaderVO> headerVoList = new ArrayList<TdrHeaderVO>();

			List<TdrCntrDetailVO> insertVoList = new ArrayList<TdrCntrDetailVO>();
			List<TdrCntrDetailVO> updateVoList = new ArrayList<TdrCntrDetailVO>();
			List<TdrCntrDetailVO> deleteVoList = new ArrayList<TdrCntrDetailVO>();

			tdrHeaderVO[0].setUpdateUser(account.getUsr_id());
			headerVoList.add(tdrHeaderVO[0]);

			if(tdrHeaderVO[0].getIbflag().equals("I")){
				dbDao.addTdrS(headerVoList);
			}
			
			
			if(tdrCntrDetailVO != null){
			
				for ( int i=0; i< tdrCntrDetailVO.length; i++ ) {
					tdrCntrDetailVO[i].setVslCd		(tdrHeaderVO[0].getVslCd	());
					tdrCntrDetailVO[i].setVoyNo		(tdrHeaderVO[0].getVoyNo	());
					tdrCntrDetailVO[i].setDirCd		(tdrHeaderVO[0].getDirCd	());
					tdrCntrDetailVO[i].setPortCd	(tdrHeaderVO[0].getPortCd	());
					tdrCntrDetailVO[i].setCallInd	(tdrHeaderVO[0].getCallInd	());
					tdrCntrDetailVO[i].setStatus	("ST");		
					
					if ( tdrCntrDetailVO[i].getIbflag().equals("I")){
						tdrCntrDetailVO[i].setUpdateUser(account.getUsr_id());
						
						//Separating Reson Code
						if(tdrCntrDetailVO[i].getShiftRsn() != null && tdrCntrDetailVO[i].getShiftRsn().length() > 2){
							tdrCntrDetailVO[i].setShiftType	(tdrCntrDetailVO[i].getShiftRsn().substring(0,1));
							tdrCntrDetailVO[i].setShiftRsn	(tdrCntrDetailVO[i].getShiftRsn().substring(1,2));
						}
						
						insertVoList.add(tdrCntrDetailVO[i]);
					} else if ( tdrCntrDetailVO[i].getIbflag().equals("U")){
						tdrCntrDetailVO[i].setUpdateUser(account.getUsr_id());
						
						//Separating Reson Code
						if(tdrCntrDetailVO[i].getShiftRsn() != null && tdrCntrDetailVO[i].getShiftRsn().length() > 2){
							tdrCntrDetailVO[i].setShiftType	(tdrCntrDetailVO[i].getShiftRsn().substring(0,1));
							tdrCntrDetailVO[i].setShiftRsn	(tdrCntrDetailVO[i].getShiftRsn().substring(1,2));
						}
						
						updateVoList.add(tdrCntrDetailVO[i]); 
					} else if ( tdrCntrDetailVO[i].getIbflag().equals("D")){
						deleteVoList.add(tdrCntrDetailVO[i]);
					}
				}
				
				
				/**************************************************************/
				dbDao.removeTdrCntrDetailRH	(tdrCntrDetailVO[0]);
				//dbDao.saveTdrCntrS		(insertVoList);
				if(insertVoList.size() > 0)	dbDao.addTdrCntrS	(insertVoList);
				
				//:2016-09-20://
//				if(insertVoList.size() > 0){
//					dbDao.addTdrCntrS	(insertVoList);
//				}
//				if(updateVoList.size() > 0){
//					dbDao.modifyTdrCntrS(updateVoList);
//				}
//				if(deleteVoList.size() > 0){
//					dbDao.removeTdrCntrS(deleteVoList);
//				}
				
				/**************************************************************/
				
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report ReHandle"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report ReHandle"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Creating, Updating, Deleting [TERMINAL DEPARTURE REPORT MisHandle] <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param tdrCntrDetailVO TdrCntrDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrMishandle(TdrHeaderVO[] tdrHeaderVO, TdrCntrDetailVO[] tdrCntrDetailVO, SignOnUserAccount account) throws EventException{
		try{
			List<TdrHeaderVO> headerVoList = new ArrayList<TdrHeaderVO>();

			List<TdrCntrDetailVO> insertVoList = new ArrayList<TdrCntrDetailVO>();
			List<TdrCntrDetailVO> updateVoList = new ArrayList<TdrCntrDetailVO>();
			List<TdrCntrDetailVO> deleteVoList = new ArrayList<TdrCntrDetailVO>();
			
			tdrHeaderVO[0].setUpdateUser(account.getUsr_id());
			headerVoList.add(tdrHeaderVO[0]);

			if(tdrHeaderVO[0].getIbflag().equals("I")){
				dbDao.addTdrS(headerVoList);
			}
			
			if(tdrCntrDetailVO != null){
				for ( int i=0; i< tdrCntrDetailVO.length; i++ ) {
					tdrCntrDetailVO[i].setVslCd(tdrHeaderVO[0].getVslCd());
					tdrCntrDetailVO[i].setVoyNo(tdrHeaderVO[0].getVoyNo());
					tdrCntrDetailVO[i].setDirCd(tdrHeaderVO[0].getDirCd());
					tdrCntrDetailVO[i].setPortCd(tdrHeaderVO[0].getPortCd());
					tdrCntrDetailVO[i].setCallInd(tdrHeaderVO[0].getCallInd());
					tdrCntrDetailVO[i].setStatus("MI");		//2009-07-29 Daniel(Jung-Hwan) IN
					
					if ( tdrCntrDetailVO[i].getIbflag().equals("I")){
						tdrCntrDetailVO[i].setUpdateUser(account.getUsr_id());
						insertVoList.add(tdrCntrDetailVO[i]);
					} else if ( tdrCntrDetailVO[i].getIbflag().equals("U")){
						tdrCntrDetailVO[i].setUpdateUser(account.getUsr_id());
						updateVoList.add(tdrCntrDetailVO[i]); 
					} else if ( tdrCntrDetailVO[i].getIbflag().equals("D")){
						deleteVoList.add(tdrCntrDetailVO[i]);
					}
				}
				
				if(insertVoList.size() > 0){
					dbDao.addTdrCntrS(insertVoList);
				}
				
				if(updateVoList.size() > 0){
					dbDao.modifyTdrCntrS(updateVoList);
				}
				
				if(deleteVoList.size() > 0){
					dbDao.removeTdrCntrS(deleteVoList);
				}
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report MisHandle"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report MisHandle"}).getMessage(), ex);
        }
	}	
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Creating, Updating, Deleting [TERMINAL DEPARTURE REPORT SlotBSA] <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param tdrAllocationVO TdrAllocationVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrSlotBSA(TdrHeaderVO[] tdrHeaderVO, TdrAllocationVO[] tdrAllocationVO, SignOnUserAccount account) throws EventException{
		try{
			List<TdrHeaderVO> headerVoList = new ArrayList<TdrHeaderVO>();

			List<TdrAllocationVO> insertVoList = new ArrayList<TdrAllocationVO>();
			List<TdrAllocationVO> updateVoList = new ArrayList<TdrAllocationVO>();
			List<TdrAllocationVO> deleteVoList = new ArrayList<TdrAllocationVO>();

			tdrHeaderVO[0].setUpdateUser(account.getUsr_id());
			headerVoList.add(tdrHeaderVO[0]);

			if(tdrHeaderVO[0].getIbflag().equals("I")){
				dbDao.addTdrS(headerVoList);
			}
			
			if(tdrAllocationVO != null){
				for ( int i=0; i< tdrAllocationVO.length; i++ ) {
					tdrAllocationVO[i].setVslCd(tdrHeaderVO[0].getVslCd());
					tdrAllocationVO[i].setVoyNo(tdrHeaderVO[0].getVoyNo());
					tdrAllocationVO[i].setDirCd(tdrHeaderVO[0].getDirCd());
					tdrAllocationVO[i].setPortCd(tdrHeaderVO[0].getPortCd());
					tdrAllocationVO[i].setCallInd(tdrHeaderVO[0].getCallInd());
					
					if ( tdrAllocationVO[i].getIbflag().equals("I")){
						tdrAllocationVO[i].setUpdateUser(account.getUsr_id());
						
						if(dbDao.searchTdrAllocationList(tdrAllocationVO[i]))
							updateVoList.add(tdrAllocationVO[i]);
						else
							insertVoList.add(tdrAllocationVO[i]);
						
					} else if ( tdrAllocationVO[i].getIbflag().equals("U")){
						tdrAllocationVO[i].setUpdateUser(account.getUsr_id());
						updateVoList.add(tdrAllocationVO[i]); 
					} else if ( tdrAllocationVO[i].getIbflag().equals("D")){
						deleteVoList.add(tdrAllocationVO[i]);
					}
				}
				
				if(insertVoList.size() > 0){
					dbDao.addTdrSlotBSAS(insertVoList);
				}
				
				if(updateVoList.size() > 0){
					dbDao.modifyTdrSlotBSAS(updateVoList);
				}
				
				if(deleteVoList.size() > 0){
					dbDao.removeTdrSlotBSAS(deleteVoList);
				}
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Slot BSA"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Slot BSA"}).getMessage(), ex);
        }
	}
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Creating, Updating, Deleting [TERMINAL DEPARTURE REPORT Slot HC45'] <br>
	 * 
	 * @param TdrHeaderVO[] tdrHeaderVO
	 * @param TdrSlotHC45VO[] tdrSlotHC45VO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTdrSlotHC45(TdrHeaderVO[] tdrHeaderVO, TdrSlotHC45VO[] tdrSlotHC45VO, SignOnUserAccount account) throws EventException{
		try{
			List<TdrHeaderVO> headerVoList = new ArrayList<TdrHeaderVO>();

			List<TdrUtilizeVO> insertVoList1 = new ArrayList<TdrUtilizeVO>();
			List<TdrUtilizeVO> deleteVoList1 = new ArrayList<TdrUtilizeVO>();

			List<TdrBsaVO> insertVoList2 = new ArrayList<TdrBsaVO>();
			List<TdrBsaVO> deleteVoList2 = new ArrayList<TdrBsaVO>();

			tdrHeaderVO[0].setUpdateUser(account.getUsr_id());
			headerVoList.add(tdrHeaderVO[0]);

			if(tdrSlotHC45VO != null){
				TdrBsaVO delBsaVO = new TdrBsaVO();
				
				//Bsa Delete Vo
				delBsaVO.setVslCd(tdrHeaderVO[0].getVslCd());
				delBsaVO.setVoyNo(tdrHeaderVO[0].getVoyNo());
				delBsaVO.setDirCd(tdrHeaderVO[0].getDirCd());
				delBsaVO.setPortCd(tdrHeaderVO[0].getPortCd());
				delBsaVO.setCallInd(tdrHeaderVO[0].getCallInd());
				
				deleteVoList2.add(delBsaVO);
				
				for(int i = 0; i < tdrSlotHC45VO.length; i++){
					TdrUtilizeVO delUtilVO = new TdrUtilizeVO();
					
					//Utilize Delete Vo
					delUtilVO.setVslCd(tdrHeaderVO[0].getVslCd());
					delUtilVO.setVoyNo(tdrHeaderVO[0].getVoyNo());
					delUtilVO.setDirCd(tdrHeaderVO[0].getDirCd());
					delUtilVO.setPortCd(tdrHeaderVO[0].getPortCd());
					delUtilVO.setCallInd(tdrHeaderVO[0].getCallInd());
					delUtilVO.setOprCd(tdrSlotHC45VO[i].getOprCd());
					delUtilVO.setCntrType("F");
					delUtilVO.setStatus("SM");

					deleteVoList1.add(delUtilVO);
					
					//Load Utilize Insert VO 
					if(tdrSlotHC45VO[i].getIbflag().equals("I") || tdrSlotHC45VO[i].getIbflag().equals("U")){
						//Utilize Insert Vo
						//20FtLoad supply
						if(tdrSlotHC45VO[i].getHcLd20() != null && !(tdrSlotHC45VO[i].getHcLd20().equals("") || tdrSlotHC45VO[i].getHcLd20().equals("0"))){
							TdrUtilizeVO insUtilVO = new TdrUtilizeVO();

							insUtilVO.setVslCd(tdrHeaderVO[0].getVslCd());
							insUtilVO.setVoyNo(tdrHeaderVO[0].getVoyNo());
							insUtilVO.setDirCd(tdrHeaderVO[0].getDirCd());
							insUtilVO.setPortCd(tdrHeaderVO[0].getPortCd());
							insUtilVO.setCallInd(tdrHeaderVO[0].getCallInd());
							insUtilVO.setOprCd(tdrSlotHC45VO[i].getOprCd());
							insUtilVO.setPod("ALL");
							insUtilVO.setCntrType("F");
							insUtilVO.setCntrSize("3");
							insUtilVO.setStatus("SM");
							insUtilVO.setQty(tdrSlotHC45VO[i].getHcLd20());
							insUtilVO.setPodIso("XXXXX");
							
							insertVoList1.add(insUtilVO);
						}

						//20Ft Add Slot
						if(tdrSlotHC45VO[i].getHcAdd20() != null && !(tdrSlotHC45VO[i].getHcAdd20().equals("") || tdrSlotHC45VO[i].getHcAdd20().equals("0"))){
							TdrUtilizeVO insUtilVO = new TdrUtilizeVO();

							insUtilVO.setVslCd(tdrHeaderVO[0].getVslCd());
							insUtilVO.setVoyNo(tdrHeaderVO[0].getVoyNo());
							insUtilVO.setDirCd(tdrHeaderVO[0].getDirCd());
							insUtilVO.setPortCd(tdrHeaderVO[0].getPortCd());
							insUtilVO.setCallInd(tdrHeaderVO[0].getCallInd());
							insUtilVO.setOprCd(tdrSlotHC45VO[i].getOprCd());
							insUtilVO.setPod("ALL");
							insUtilVO.setCntrType("A");
							insUtilVO.setCntrSize("3");
							insUtilVO.setStatus("SM");
							insUtilVO.setQty(tdrSlotHC45VO[i].getHcAdd20());
							insUtilVO.setPodIso("XXXXX");
							
							insertVoList1.add(insUtilVO);
						}
						
						//40FtLoad supply
						if(tdrSlotHC45VO[i].getHcLd40() != null && !(tdrSlotHC45VO[i].getHcLd40().equals("") || tdrSlotHC45VO[i].getHcLd40().equals("0"))){
							TdrUtilizeVO insUtilVO = new TdrUtilizeVO();

							insUtilVO.setVslCd(tdrHeaderVO[0].getVslCd());
							insUtilVO.setVoyNo(tdrHeaderVO[0].getVoyNo());
							insUtilVO.setDirCd(tdrHeaderVO[0].getDirCd());
							insUtilVO.setPortCd(tdrHeaderVO[0].getPortCd());
							insUtilVO.setCallInd(tdrHeaderVO[0].getCallInd());
							insUtilVO.setOprCd(tdrSlotHC45VO[i].getOprCd());
							insUtilVO.setPod("ALL");
							insUtilVO.setCntrType("F");
							insUtilVO.setCntrSize("H");
							insUtilVO.setStatus("SM");
							insUtilVO.setQty(tdrSlotHC45VO[i].getHcLd40());
							insUtilVO.setPodIso("XXXXX");
							
							insertVoList1.add(insUtilVO);
						}
						
						//40Ft Add Slot
						if(tdrSlotHC45VO[i].getHcAdd40() != null && !(tdrSlotHC45VO[i].getHcAdd40().equals("") || tdrSlotHC45VO[i].getHcAdd40().equals("0"))){
							TdrUtilizeVO insUtilVO = new TdrUtilizeVO();

							insUtilVO.setVslCd(tdrHeaderVO[0].getVslCd());
							insUtilVO.setVoyNo(tdrHeaderVO[0].getVoyNo());
							insUtilVO.setDirCd(tdrHeaderVO[0].getDirCd());
							insUtilVO.setPortCd(tdrHeaderVO[0].getPortCd());
							insUtilVO.setCallInd(tdrHeaderVO[0].getCallInd());
							insUtilVO.setOprCd(tdrSlotHC45VO[i].getOprCd());
							insUtilVO.setPod("ALL");
							insUtilVO.setCntrType("A");
							insUtilVO.setCntrSize("H");
							insUtilVO.setStatus("SM");
							insUtilVO.setQty(tdrSlotHC45VO[i].getHcAdd40());
							insUtilVO.setPodIso("XXXXX");
							
							insertVoList1.add(insUtilVO);
						}

						//45FtLoad supply
						if(tdrSlotHC45VO[i].getHcLd45() != null && !(tdrSlotHC45VO[i].getHcLd45().equals("") || tdrSlotHC45VO[i].getHcLd45().equals("0"))){
							TdrUtilizeVO insUtilVO = new TdrUtilizeVO();

							insUtilVO.setVslCd(tdrHeaderVO[0].getVslCd());
							insUtilVO.setVoyNo(tdrHeaderVO[0].getVoyNo());
							insUtilVO.setDirCd(tdrHeaderVO[0].getDirCd());
							insUtilVO.setPortCd(tdrHeaderVO[0].getPortCd());
							insUtilVO.setCallInd(tdrHeaderVO[0].getCallInd());
							insUtilVO.setOprCd(tdrSlotHC45VO[i].getOprCd());
							insUtilVO.setPod("ALL");
							insUtilVO.setCntrType("F");
							insUtilVO.setCntrSize("L");
							insUtilVO.setStatus("SM");
							insUtilVO.setQty(tdrSlotHC45VO[i].getHcLd45());
							insUtilVO.setPodIso("XXXXX");
							
							insertVoList1.add(insUtilVO);
						}
						
						//45Ft Add Slot
						if(tdrSlotHC45VO[i].getHcAdd45() != null && !(tdrSlotHC45VO[i].getHcAdd45().equals("") || tdrSlotHC45VO[i].getHcAdd45().equals("0"))){
							TdrUtilizeVO insUtilVO = new TdrUtilizeVO();

							insUtilVO.setVslCd(tdrHeaderVO[0].getVslCd());
							insUtilVO.setVoyNo(tdrHeaderVO[0].getVoyNo());
							insUtilVO.setDirCd(tdrHeaderVO[0].getDirCd());
							insUtilVO.setPortCd(tdrHeaderVO[0].getPortCd());
							insUtilVO.setCallInd(tdrHeaderVO[0].getCallInd());
							insUtilVO.setOprCd(tdrSlotHC45VO[i].getOprCd());
							insUtilVO.setPod("ALL");
							insUtilVO.setCntrType("A");
							insUtilVO.setCntrSize("L");
							insUtilVO.setStatus("SM");
							insUtilVO.setQty(tdrSlotHC45VO[i].getHcAdd45());
							insUtilVO.setPodIso("XXXXX");
							
							insertVoList1.add(insUtilVO);
						}
							
						TdrBsaVO insBsaVO = new TdrBsaVO();
						
						//Bsa Insert Vo
						insBsaVO.setVslCd(tdrHeaderVO[0].getVslCd());
						insBsaVO.setVoyNo(tdrHeaderVO[0].getVoyNo());
						insBsaVO.setDirCd(tdrHeaderVO[0].getDirCd());
						insBsaVO.setPortCd(tdrHeaderVO[0].getPortCd());
						insBsaVO.setCallInd(tdrHeaderVO[0].getCallInd());
						insBsaVO.setOprCd(tdrSlotHC45VO[i].getOprCd());
						insBsaVO.setHc20Qty(tdrSlotHC45VO[i].getHcBsa20());
						insBsaVO.setHc20Rat(tdrSlotHC45VO[i].getHcOr20());
						insBsaVO.setHc40Qty(tdrSlotHC45VO[i].getHcBsa40());
						insBsaVO.setHc40Rat(tdrSlotHC45VO[i].getHcOr40());
						insBsaVO.setQty45(tdrSlotHC45VO[i].getHcBsa45());
						insBsaVO.setUnRat45(tdrSlotHC45VO[i].getHcUr45());
						insBsaVO.setOvRat45(tdrSlotHC45VO[i].getHcOr45());

						insertVoList2.add(insBsaVO);
					}
				}
				
				//Calling Dao Delete 
				dbDao.removeTdrSlotHC45UtilizeS(deleteVoList1);
				dbDao.removeTdrBsaS(deleteVoList2);
				
				//Calling Dao Insert 
				dbDao.addTdrSlotUtilizeS(insertVoList1);
				dbDao.addTdrBsaS(insertVoList2);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Slot HC45'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Slot HC45'"}).getMessage(), ex);
        }
	}
		
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Creating, Updating, Deleting [TERMINAL DEPARTURE REPORT Slot Utilize] <br>
	 * 
	 * @param TdrHeaderVO[] tdrHeaderVO
	 * @param TdrUtilizeSlotPortVO[] tdrUtilizeSlotPortVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTdrSlotPort(TdrHeaderVO[] tdrHeaderVO, TdrUtilizeSlotPortVO[] tdrUtilizeSlotPortVO, SignOnUserAccount account) throws EventException{
		try{
			List<TdrHeaderVO> headerVoList = new ArrayList<TdrHeaderVO>();

			List<TdrUtilizeVO> insertVoList = new ArrayList<TdrUtilizeVO>();
			List<TdrUtilizeVO> deleteVoList = new ArrayList<TdrUtilizeVO>();

			tdrHeaderVO[0].setUpdateUser(account.getUsr_id());
			headerVoList.add(tdrHeaderVO[0]);

			if(tdrUtilizeSlotPortVO != null){
				for ( int i=0; i< tdrUtilizeSlotPortVO.length; i++ ) {
					if ( tdrUtilizeSlotPortVO[i].getIbflag().equals("I")){
						convertDelToUtilizeVO(deleteVoList, tdrHeaderVO[0], tdrUtilizeSlotPortVO[i]);
						convertSheetToUtilizeVO(insertVoList, tdrHeaderVO[0], tdrUtilizeSlotPortVO[i], account);
					}else if( tdrUtilizeSlotPortVO[i].getIbflag().equals("U")){
						convertDelToUtilizeVO(deleteVoList, tdrHeaderVO[0], tdrUtilizeSlotPortVO[i]);
						convertSheetToUtilizeVO(insertVoList, tdrHeaderVO[0], tdrUtilizeSlotPortVO[i], account);
					}else if( tdrUtilizeSlotPortVO[i].getIbflag().equals("D")){
						convertDelToUtilizeVO(deleteVoList, tdrHeaderVO[0], tdrUtilizeSlotPortVO[i]);
					}
				}
			}
			
			dbDao.removeTdrSlotPortUtilizeS(deleteVoList);
			dbDao.addTdrSlotUtilizeS(insertVoList);

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Slot Utilize'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Slot Utilize'"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Creating, Updating, Deleting [TERMINAL DEPARTURE REPORT TmpStwg] <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param tdrCntrDetailVO TdrCntrDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrTmpStwg(TdrHeaderVO[] tdrHeaderVO, TdrCntrDetailVO[] tdrCntrDetailVO, SignOnUserAccount account) throws EventException{
		try{
			List<TdrHeaderVO> headerVoList = new ArrayList<TdrHeaderVO>();

			List<TdrCntrDetailVO> insertVoList = new ArrayList<TdrCntrDetailVO>();
			List<TdrCntrDetailVO> updateVoList = new ArrayList<TdrCntrDetailVO>();
			List<TdrCntrDetailVO> deleteVoList = new ArrayList<TdrCntrDetailVO>();
			
			tdrHeaderVO[0].setUpdateUser(account.getUsr_id());
			headerVoList.add(tdrHeaderVO[0]);

			if(tdrHeaderVO[0].getIbflag().equals("I")){
				dbDao.addTdrS(headerVoList);
			}

			if(tdrCntrDetailVO != null){
				for ( int i=0; i< tdrCntrDetailVO.length; i++ ) {
					tdrCntrDetailVO[i].setVslCd(tdrHeaderVO[0].getVslCd());
					tdrCntrDetailVO[i].setVoyNo(tdrHeaderVO[0].getVoyNo());
					tdrCntrDetailVO[i].setDirCd(tdrHeaderVO[0].getDirCd());
					tdrCntrDetailVO[i].setPortCd(tdrHeaderVO[0].getPortCd());
					tdrCntrDetailVO[i].setCallInd(tdrHeaderVO[0].getCallInd());
					tdrCntrDetailVO[i].setStatus("TS");		//2009-07-29 Daniel(Jung-Hwan) IN
					tdrCntrDetailVO[i].setTempChk("Y");		
					
					if ( tdrCntrDetailVO[i].getIbflag().equals("I")){
						tdrCntrDetailVO[i].setUpdateUser(account.getUsr_id());
						insertVoList.add(tdrCntrDetailVO[i]);
					} else if ( tdrCntrDetailVO[i].getIbflag().equals("U")){
						tdrCntrDetailVO[i].setUpdateUser(account.getUsr_id());
						updateVoList.add(tdrCntrDetailVO[i]); 
					} else if ( tdrCntrDetailVO[i].getIbflag().equals("D")){
						deleteVoList.add(tdrCntrDetailVO[i]);
					}
				}
				
				if(insertVoList.size() > 0){
					dbDao.addTdrCntrS(insertVoList);
				}
				
				if(updateVoList.size() > 0){
					dbDao.modifyTdrCntrS(updateVoList);
				}
				
				if(deleteVoList.size() > 0){
					dbDao.removeTdrCntrS(deleteVoList);
				}
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report TmpStwg'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report TmpStwg'"}).getMessage(), ex);
        }
	}
		
	/**   
	 * VOP_OPF_0038 : Save <br>
	 * Creating, Updating, Deleting [Exclude Tpr] <br>
	 * 
	 * @param OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageExcludeTpr(OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVO, SignOnUserAccount account) throws EventException{
		
		try{
			if(opfTmlProdRptRsnCdVO != null){
				OpfTmlDepRptDtlVO opfTmlDepRptDtlVO = new OpfTmlDepRptDtlVO();
				String tempStr = opfTmlProdRptRsnCdVO[0].getKeyOfRemark();
				
				String[] arrDataKey = tempStr.split("_/");

				opfTmlDepRptDtlVO.setVslCd(arrDataKey[0]);
				opfTmlDepRptDtlVO.setSkdVoyNo(arrDataKey[1]);
				opfTmlDepRptDtlVO.setSkdDirCd(arrDataKey[2]);
				opfTmlDepRptDtlVO.setClptIndSeq(arrDataKey[3]);
				opfTmlDepRptDtlVO.setClptCd(arrDataKey[4]);
				opfTmlDepRptDtlVO.setTmlProdRptRsnRmk(arrDataKey.length > 5 ?  arrDataKey[5] : "");
				
				opfTmlDepRptDtlVO.setTmlProdRptRsnCreUsrId(account.getUsr_id());
				opfTmlDepRptDtlVO.setTmlProdRptRsnCd(opfTmlProdRptRsnCdVO[0].getTmlProdRptRsnCd());
				
				opfTmlDepRptDtlVO.setCreUsrId(account.getUsr_id());
				opfTmlDepRptDtlVO.setUpdUsrId(account.getUsr_id());
				
				if(opfTmlProdRptRsnCdVO[0].getIbflag().equals("U")){
					boolean existsVO = dbDao.existsExcludeTpr(opfTmlDepRptDtlVO);
					
					if(existsVO)
						dbDao.modifyExcludeTpr(opfTmlDepRptDtlVO);
					else
						dbDao.addExcludeTpr(opfTmlDepRptDtlVO);
				}else{
					dbDao.removeExcludeTpr(opfTmlDepRptDtlVO);
				}
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Opf Terminal Departure Report Detail'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Opf Terminal Departure Report Detail'"}).getMessage(), ex);
        }
	}
	
	/**
	 * Converting Vo of Sheet to Vo which is possible CUD<br>
	 * 
	 * @param 	List<TdrSummaryVO> voList  
	 * @param 	TdrHeaderVO tdrHeaderVO 
	 * @param 	TdrDistLoadVolVO tdrDistLoadVolVO 
	 * @exception EventException
	 */
	private void convertDelToSummaryVO(List<TdrSummaryVO> voList,
										TdrHeaderVO tdrHeaderVO,
										TdrDistLoadVolVO tdrDistLoadVolVO,
										int idxKindRow){
		String[][] status = new String[3][2];
		//Status - 1 Disch
		status[0][0] = "DS"; 
		status[0][1] = "DT"; 
		//Status - 2 Load Ocean
		status[1][0] = "LM"; 
		status[1][1] = "OT"; 
		//Status - 3 Load Inter
		status[2][0] = "LI"; 
		status[2][1] = "LT"; 
		
		TdrSummaryVO tdrSummaryVO = new TdrSummaryVO();
		
		tdrSummaryVO.setVslCd(tdrHeaderVO.getVslCd());
		tdrSummaryVO.setVoyNo(tdrHeaderVO.getVoyNo());
		tdrSummaryVO.setDirCd(tdrHeaderVO.getDirCd());
		tdrSummaryVO.setPortCd(tdrHeaderVO.getPortCd());
		tdrSummaryVO.setCallInd(tdrHeaderVO.getCallInd());
		tdrSummaryVO.setOprCd(tdrDistLoadVolVO.getOprCd());
		tdrSummaryVO.setPod(tdrDistLoadVolVO.getIdxSheet().equals("0") ? tdrHeaderVO.getPortCd() : tdrDistLoadVolVO.getPodCd());
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		voList.add(tdrSummaryVO);
		
		tdrSummaryVO = new TdrSummaryVO();
		
		tdrSummaryVO.setVslCd(tdrHeaderVO.getVslCd());
		tdrSummaryVO.setVoyNo(tdrHeaderVO.getVoyNo());
		tdrSummaryVO.setDirCd(tdrHeaderVO.getDirCd());
		tdrSummaryVO.setPortCd(tdrHeaderVO.getPortCd());
		tdrSummaryVO.setCallInd(tdrHeaderVO.getCallInd());
		tdrSummaryVO.setOprCd(tdrDistLoadVolVO.getOprCd());
		tdrSummaryVO.setPod(tdrDistLoadVolVO.getIdxSheet().equals("0") ? tdrHeaderVO.getPortCd() : tdrDistLoadVolVO.getPodCd());
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		voList.add(tdrSummaryVO);
	}
	
	
	/**
	 * Converting Vo of Sheet to Vo which is possible CUD
	 * Lane 
	 * @param 	List<TdrSummaryVO> voList  
	 * @param 	TdrHeaderVO tdrHeaderVO 
	 * @param 	TdrDistLoadVolVO tdrDistLoadVolVO 
	 * @exception EventException
	 */
	private void convertDelAllToSummaryVO( List<TdrSummaryVO> voList,
											TdrHeaderVO tdrHeaderVO,
											TdrDistLoadVolVO tdrDistLoadVolVO,
											int idxKindRow){
		String[][] status = new String[3][2];
		//Status - 1 Disch
		status[0][0] = "DS"; 
		status[0][1] = "DT"; 
		//Status - 2 Load Ocean
		status[1][0] = "LM"; 
		status[1][1] = "OT"; 
		//Status - 3 Load Inter
		status[2][0] = "LI"; 
		status[2][1] = "LT"; 
		
		TdrSummaryVO tdrSummaryVO = new TdrSummaryVO();
		
		tdrSummaryVO.setVslCd(tdrHeaderVO.getVslCd());
		tdrSummaryVO.setVoyNo(tdrHeaderVO.getVoyNo());
		tdrSummaryVO.setDirCd(tdrHeaderVO.getDirCd());
		tdrSummaryVO.setPortCd(tdrHeaderVO.getPortCd());
		tdrSummaryVO.setCallInd(tdrHeaderVO.getCallInd());
		tdrSummaryVO.setStatus(status[idxKindRow][0]);

		voList.add(tdrSummaryVO);
		
		tdrSummaryVO = new TdrSummaryVO();
		
		tdrSummaryVO.setVslCd(tdrHeaderVO.getVslCd());
		tdrSummaryVO.setVoyNo(tdrHeaderVO.getVoyNo());
		tdrSummaryVO.setDirCd(tdrHeaderVO.getDirCd());
		tdrSummaryVO.setPortCd(tdrHeaderVO.getPortCd());
		tdrSummaryVO.setCallInd(tdrHeaderVO.getCallInd());
		tdrSummaryVO.setStatus(status[idxKindRow][1]);

		voList.add(tdrSummaryVO);
	}	
	/**
	 * Converting Vo of Sheet to Vo which is possible CUD
	 * Lane 
	 * @param 	List<TdrSummaryVO> voList,  
	 * @param 	DischVolTotalVO DischVolTotalVO, 
	 * @param 	SignOnUserAccount account 
	 * @exception EventException
	 */
	private void convertSheetToSummaryVO(List<TdrSummaryVO> voList,
										  TdrHeaderVO tdrHeaderVO,
										  TdrDistLoadVolVO tdrDistLoadVolVO, 
										  SignOnUserAccount account,
										  int idxKindRow){
		
		String[] checkExsits = new String[5];

		String[][] status = new String[3][2];
		//Status - 1 Disch
		status[0][0] = "DS"; 
		status[0][1] = "DT"; 
		//Status - 2 Load Ocean
		status[1][0] = "LM"; 
		status[1][1] = "OT"; 
		//Status - 3 Load Inter
		status[2][0] = "LI"; 
		status[2][1] = "LT"; 

		for(int cnt=0; cnt < checkExsits.length; cnt++){
			checkExsits[cnt] = "N";
		}
		
		TdrSummaryVO tdrSummaryVO = this.setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		
		////if(!tdrDistLoadVolVO.getFullBo20().equals("") && !tdrDistLoadVolVO.getFullBo20().equals("0")){
		if(!tdrDistLoadVolVO.getFullBo20().equals("") && !tdrDistLoadVolVO.getFullBo20().equals("0.00") && !tdrDistLoadVolVO.getFullBo20().equals("0")){
			tdrSummaryVO.setCntrSize("2");
			
			////tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullBo20());
			tdrSummaryVO.setQty("999.99");
			
			tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt20()));
			checkExsits[0] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}else{
			tdrSummaryVO.setCntrSize("2");
			////tdrSummaryVO.setQty("0");
			////tdrSummaryVO.setWeight("0");
			tdrSummaryVO.setQty("0.00");
			tdrSummaryVO.setWeight("0.00");
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		
		if(!tdrDistLoadVolVO.getFullBo2h().equals("") && !tdrDistLoadVolVO.getFullBo2h().equals("0.00") && !tdrDistLoadVolVO.getFullBo2h().equals("0")){
			tdrSummaryVO.setCntrSize("3");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullBo2h());
			tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt2h()));
			checkExsits[1] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		
		if(!tdrDistLoadVolVO.getFullBo40().equals("") && !tdrDistLoadVolVO.getFullBo40().equals("0.00") && !tdrDistLoadVolVO.getFullBo40().equals("0")){
			tdrSummaryVO.setCntrSize("4");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullBo40());
			tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt40()));
			checkExsits[2] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		
		if(!tdrDistLoadVolVO.getFullBo4h().equals("") && !tdrDistLoadVolVO.getFullBo4h().equals("0.00") && !tdrDistLoadVolVO.getFullBo4h().equals("0")){
			tdrSummaryVO.setCntrSize("H");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullBo4h());
			tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt4h()));
			checkExsits[3] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		
		if(!tdrDistLoadVolVO.getFullBo45().equals("") && !tdrDistLoadVolVO.getFullBo45().equals("0.00") && !tdrDistLoadVolVO.getFullBo45().equals("0")){
			tdrSummaryVO.setCntrSize("L");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullBo45());
			tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt45()));
			checkExsits[4] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		
		if(!tdrDistLoadVolVO.getFullTs20().equals("") && !tdrDistLoadVolVO.getFullTs20().equals("0.00") && !tdrDistLoadVolVO.getFullTs20().equals("0")){
			tdrSummaryVO.setCntrSize("2");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullTs20());
			if(checkExsits[0].equals("N")){ tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt20())); }
			checkExsits[0] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		
		if(!tdrDistLoadVolVO.getFullTs2h().equals("") && !tdrDistLoadVolVO.getFullTs2h().equals("0.00") && !tdrDistLoadVolVO.getFullTs2h().equals("0")){
			tdrSummaryVO.setCntrSize("3");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullTs2h());
			if(checkExsits[1].equals("N")){ tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt2h())); }
			checkExsits[1] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		
		if(!tdrDistLoadVolVO.getFullTs40().equals("") && !tdrDistLoadVolVO.getFullTs40().equals("0.00") && !tdrDistLoadVolVO.getFullTs40().equals("0")){
			tdrSummaryVO.setCntrSize("4");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullTs40());
			if(checkExsits[2].equals("N")){ tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt40())); }
			checkExsits[2] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		
		if(!tdrDistLoadVolVO.getFullTs4h().equals("") && !tdrDistLoadVolVO.getFullTs4h().equals("0.00") && !tdrDistLoadVolVO.getFullTs4h().equals("0")){
			tdrSummaryVO.setCntrSize("H");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullTs4h());
			if(checkExsits[3].equals("N")){ tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt4h())); }
			checkExsits[3] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		
		if(!tdrDistLoadVolVO.getFullTs45().equals("") && !tdrDistLoadVolVO.getFullTs45().equals("0.00") && !tdrDistLoadVolVO.getFullTs45().equals("0")){
			tdrSummaryVO.setCntrSize("L");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullTs45());
			if(checkExsits[4].equals("N")){ tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt45())); }
			checkExsits[4] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}		
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		
		if(!tdrDistLoadVolVO.getEtBo20().equals("") && !tdrDistLoadVolVO.getEtBo20().equals("0.00") && !tdrDistLoadVolVO.getEtBo20().equals("0")){
			tdrSummaryVO.setCntrSize("2");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtBo20());
			if(checkExsits[0].equals("N")){ tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt20())); }
			checkExsits[0] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		
		if(!tdrDistLoadVolVO.getEtBo2h().equals("") && !tdrDistLoadVolVO.getEtBo2h().equals("0.00") && !tdrDistLoadVolVO.getEtBo2h().equals("0")){
			tdrSummaryVO.setCntrSize("3");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtBo2h());
			if(checkExsits[1].equals("N")){ tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt2h())); }
			checkExsits[1] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		
		if(!tdrDistLoadVolVO.getEtBo40().equals("") && !tdrDistLoadVolVO.getEtBo40().equals("0.00") && !tdrDistLoadVolVO.getEtBo40().equals("0")){
			tdrSummaryVO.setCntrSize("4");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtBo40());
			if(checkExsits[2].equals("N")){ tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt40())); }
			checkExsits[2] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		if(!tdrDistLoadVolVO.getEtBo4h().equals("") && !tdrDistLoadVolVO.getEtBo4h().equals("0.00") && !tdrDistLoadVolVO.getEtBo4h().equals("0")){
			tdrSummaryVO.setCntrSize("H");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtBo4h());
			if(checkExsits[3].equals("N")){ tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt4h())); }
			checkExsits[3] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		
		if(!tdrDistLoadVolVO.getEtBo45().equals("") && !tdrDistLoadVolVO.getEtBo45().equals("0.00") && !tdrDistLoadVolVO.getEtBo45().equals("0")){
			tdrSummaryVO.setCntrSize("L");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtBo45());
			if(checkExsits[4].equals("N")){ tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt45())); }
			checkExsits[4] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		
		if(!tdrDistLoadVolVO.getEtTs20().equals("") && !tdrDistLoadVolVO.getEtTs20().equals("0.00") && !tdrDistLoadVolVO.getEtTs20().equals("0")){
			tdrSummaryVO.setCntrSize("2");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtTs20());
			if(checkExsits[0].equals("N")){ tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt20())); }
			checkExsits[0] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		
		if(!tdrDistLoadVolVO.getEtTs2h().equals("") && !tdrDistLoadVolVO.getEtTs2h().equals("0.00") && !tdrDistLoadVolVO.getEtTs2h().equals("0")){
			tdrSummaryVO.setCntrSize("3");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtTs2h());
			if(checkExsits[1].equals("N")){ tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt2h())); }
			checkExsits[1] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		
		if(!tdrDistLoadVolVO.getEtTs40().equals("") && !tdrDistLoadVolVO.getEtTs40().equals("0.00") && !tdrDistLoadVolVO.getEtTs40().equals("0")){
			tdrSummaryVO.setCntrSize("4");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtTs40());
			if(checkExsits[2].equals("N")){ tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt40())); }
			checkExsits[2] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		
		if(!tdrDistLoadVolVO.getEtTs4h().equals("") && !tdrDistLoadVolVO.getEtTs4h().equals("0.00") && !tdrDistLoadVolVO.getEtTs4h().equals("0")){
			tdrSummaryVO.setCntrSize("H");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtTs4h());
			if(checkExsits[3].equals("N")){ tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt4h())); }
			checkExsits[3] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		
		if(!tdrDistLoadVolVO.getEtTs45().equals("") && !tdrDistLoadVolVO.getEtTs45().equals("0.00") && !tdrDistLoadVolVO.getEtTs45().equals("0")){
			tdrSummaryVO.setCntrSize("L");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtTs45());
			if(checkExsits[4].equals("N")){ tdrSummaryVO.setWeight(chgTonToKg(tdrDistLoadVolVO.getWt45())); }
			checkExsits[4] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}		
	}
	
	/**
	 * Converting Vo of Sheet to Vo which is possible CUD
	 * Lane 
	 * @param 	List<TdrUtilizeVO> voList  
	 * @param 	TdrHeaderVO tdrHeaderVO
	 * @param 	TdrUtilizeSlotPortVO tdrUtilizeSlotPortVO
	 * @exception EventException
	 */
	private void convertDelToUtilizeVO(List<TdrUtilizeVO> voList,
										TdrHeaderVO tdrHeaderVO,
										TdrUtilizeSlotPortVO tdrUtilizeSlotPortVO){
		
		TdrUtilizeVO tdrUtilizeVO = new TdrUtilizeVO();
		
		tdrUtilizeVO.setVslCd(tdrHeaderVO.getVslCd());
		tdrUtilizeVO.setVoyNo(tdrHeaderVO.getVoyNo());
		tdrUtilizeVO.setDirCd(tdrHeaderVO.getDirCd());
		tdrUtilizeVO.setPortCd(tdrHeaderVO.getPortCd());
		tdrUtilizeVO.setCallInd(tdrHeaderVO.getCallInd());
		tdrUtilizeVO.setOprCd(tdrUtilizeSlotPortVO.getOprCd());
		tdrUtilizeVO.setStatus(tdrUtilizeSlotPortVO.getStatus() + "M");
		
		voList.add(tdrUtilizeVO);

		tdrUtilizeVO = new TdrUtilizeVO();
		
		tdrUtilizeVO.setVslCd(tdrHeaderVO.getVslCd());
		tdrUtilizeVO.setVoyNo(tdrHeaderVO.getVoyNo());
		tdrUtilizeVO.setDirCd(tdrHeaderVO.getDirCd());
		tdrUtilizeVO.setPortCd(tdrHeaderVO.getPortCd());
		tdrUtilizeVO.setCallInd(tdrHeaderVO.getCallInd());
		tdrUtilizeVO.setOprCd(tdrUtilizeSlotPortVO.getOprCd());
		tdrUtilizeVO.setStatus(tdrUtilizeSlotPortVO.getStatus() + "I");
		
		voList.add(tdrUtilizeVO);
	}
		
	/**
	 * Converting Vo of Sheet to Vo which is possible CUD
	 * Lane 
	 * @param 	List<TdrUtilizeVO> voList 
	 * @param 	TdrHeaderVO tdrHeaderVO
	 * @param 	TdrUtilizeSlotPortVO tdrUtilizeSlotPortVO
	 * @param   SignOnUserAccount account
	 * @exception EventException
	 */
	private void convertSheetToUtilizeVO(List<TdrUtilizeVO> voList,
										  TdrHeaderVO tdrHeaderVO,
										  TdrUtilizeSlotPortVO tdrUtilizeSlotPortVO, 
										  SignOnUserAccount account){

		if(!tdrUtilizeSlotPortVO.getTradeFull().equals("") && !tdrUtilizeSlotPortVO.getTradeFull().equals("0")){
			TdrUtilizeVO tdrUtilizeVO = setTdrUtilizeVO(tdrHeaderVO, tdrUtilizeSlotPortVO, account);

			tdrUtilizeVO.setPod("ALL");
			tdrUtilizeVO.setCntrType("F");
			tdrUtilizeVO.setCntrSize("2");
			tdrUtilizeVO.setStatus(tdrUtilizeSlotPortVO.getStatus() + "M");
			tdrUtilizeVO.setQty(tdrUtilizeSlotPortVO.getTradeFull());
			tdrUtilizeVO.setWeight(tdrUtilizeSlotPortVO.getTradeSubWgt());
			
			//Save POD_ISO
			if( tdrUtilizeSlotPortVO.getStatus() != null && tdrUtilizeSlotPortVO.getStatus().equals("O") )
				tdrUtilizeVO.setPodIso(tdrHeaderVO.getPortCd());
			else
				tdrUtilizeVO.setPodIso("XXXXX");
			
			voList.add(voList.size(), tdrUtilizeVO);
		}else{
			TdrUtilizeVO tdrUtilizeVO = setTdrUtilizeVO(tdrHeaderVO, tdrUtilizeSlotPortVO, account);

			tdrUtilizeVO.setPod("ALL");
			tdrUtilizeVO.setCntrType("F");
			tdrUtilizeVO.setCntrSize("2");
			tdrUtilizeVO.setStatus(tdrUtilizeSlotPortVO.getStatus() + "M");
			tdrUtilizeVO.setQty("0");
			tdrUtilizeVO.setWeight(tdrUtilizeSlotPortVO.getTradeSubWgt());

			//Save POD_ISO
			if( tdrUtilizeSlotPortVO.getStatus() != null && tdrUtilizeSlotPortVO.getStatus().equals("O") )
				tdrUtilizeVO.setPodIso(tdrHeaderVO.getPortCd());
			else
				tdrUtilizeVO.setPodIso("XXXXX");
			
			voList.add(voList.size(), tdrUtilizeVO);
		}

		if(!tdrUtilizeSlotPortVO.getTradeMt().equals("") && !tdrUtilizeSlotPortVO.getTradeMt().equals("0")){
			TdrUtilizeVO tdrUtilizeVO = setTdrUtilizeVO(tdrHeaderVO, tdrUtilizeSlotPortVO, account);

			tdrUtilizeVO.setPod("ALL");
			tdrUtilizeVO.setCntrType("E");
			tdrUtilizeVO.setCntrSize("2");
			tdrUtilizeVO.setStatus(tdrUtilizeSlotPortVO.getStatus() + "M");
			tdrUtilizeVO.setQty(tdrUtilizeSlotPortVO.getTradeMt());
			
			//Save POD_ISO
			if( tdrUtilizeSlotPortVO.getStatus() != null && tdrUtilizeSlotPortVO.getStatus().equals("O") )
				tdrUtilizeVO.setPodIso(tdrHeaderVO.getPortCd());
			else
				tdrUtilizeVO.setPodIso("XXXXX");
			
			voList.add(voList.size(), tdrUtilizeVO);
		}		

		if(!tdrUtilizeSlotPortVO.getTradeAb().equals("") && !tdrUtilizeSlotPortVO.getTradeAb().equals("0")){
			TdrUtilizeVO tdrUtilizeVO = setTdrUtilizeVO(tdrHeaderVO, tdrUtilizeSlotPortVO, account);

			tdrUtilizeVO.setPod("ALL");
			tdrUtilizeVO.setCntrType("F");	
			//tdrUtilizeVO.setCntrSize("2");	//Size is fixed A in I-Stowage
			tdrUtilizeVO.setCntrSize("A");
			tdrUtilizeVO.setStatus(tdrUtilizeSlotPortVO.getStatus() + "M");
			tdrUtilizeVO.setQty(tdrUtilizeSlotPortVO.getTradeAb());
			
			//Save POD_ISO
			if( tdrUtilizeSlotPortVO.getStatus() != null && tdrUtilizeSlotPortVO.getStatus().equals("O") )
				tdrUtilizeVO.setPodIso(tdrHeaderVO.getPortCd());
			else
				tdrUtilizeVO.setPodIso("XXXXX");
			
			voList.add(voList.size(), tdrUtilizeVO);
		}		

		if(!tdrUtilizeSlotPortVO.getInterFull().equals("") && !tdrUtilizeSlotPortVO.getInterFull().equals("0")){
			TdrUtilizeVO tdrUtilizeVO = setTdrUtilizeVO(tdrHeaderVO, tdrUtilizeSlotPortVO, account);

			tdrUtilizeVO.setPod("ALL");
			tdrUtilizeVO.setCntrType("F");
			tdrUtilizeVO.setCntrSize("2");
			tdrUtilizeVO.setStatus(tdrUtilizeSlotPortVO.getStatus() + "I");
			tdrUtilizeVO.setQty(tdrUtilizeSlotPortVO.getInterFull());
			tdrUtilizeVO.setWeight(tdrUtilizeSlotPortVO.getInterSubWgt());
			
			//Save POD_ISO
			if( tdrUtilizeSlotPortVO.getStatus() != null && tdrUtilizeSlotPortVO.getStatus().equals("O") )
				tdrUtilizeVO.setPodIso(tdrHeaderVO.getPortCd());
			else
				tdrUtilizeVO.setPodIso("XXXXX");

			voList.add(voList.size(), tdrUtilizeVO);
		}else{
			TdrUtilizeVO tdrUtilizeVO = setTdrUtilizeVO(tdrHeaderVO, tdrUtilizeSlotPortVO, account);

			tdrUtilizeVO.setPod("ALL");
			tdrUtilizeVO.setCntrType("F");
			tdrUtilizeVO.setCntrSize("2");
			tdrUtilizeVO.setStatus(tdrUtilizeSlotPortVO.getStatus() + "I");
			tdrUtilizeVO.setQty("0");
			tdrUtilizeVO.setWeight(tdrUtilizeSlotPortVO.getInterSubWgt());
			
			//Save POD_ISO
			if( tdrUtilizeSlotPortVO.getStatus() != null && tdrUtilizeSlotPortVO.getStatus().equals("O") )
				tdrUtilizeVO.setPodIso(tdrHeaderVO.getPortCd());
			else
				tdrUtilizeVO.setPodIso("XXXXX");

			voList.add(voList.size(), tdrUtilizeVO);
		}

		if(!tdrUtilizeSlotPortVO.getInterMt().equals("") && !tdrUtilizeSlotPortVO.getInterMt().equals("0")){
			TdrUtilizeVO tdrUtilizeVO = setTdrUtilizeVO(tdrHeaderVO, tdrUtilizeSlotPortVO, account);

			tdrUtilizeVO.setPod("ALL");
			tdrUtilizeVO.setCntrType("E");
			tdrUtilizeVO.setCntrSize("2");
			tdrUtilizeVO.setStatus(tdrUtilizeSlotPortVO.getStatus() + "I");
			tdrUtilizeVO.setQty(tdrUtilizeSlotPortVO.getInterMt());

			//Save POD_ISO
			if( tdrUtilizeSlotPortVO.getStatus() != null && tdrUtilizeSlotPortVO.getStatus().equals("O") )
				tdrUtilizeVO.setPodIso(tdrHeaderVO.getPortCd());
			else
				tdrUtilizeVO.setPodIso("XXXXX");

			voList.add(voList.size(), tdrUtilizeVO);
		}		

		if(!tdrUtilizeSlotPortVO.getInterAb().equals("") && !tdrUtilizeSlotPortVO.getInterAb().equals("0")){
			TdrUtilizeVO tdrUtilizeVO = setTdrUtilizeVO(tdrHeaderVO, tdrUtilizeSlotPortVO, account);
			
			tdrUtilizeVO.setPod("ALL");
			tdrUtilizeVO.setCntrType("F");
			//tdrUtilizeVO.setCntrSize("2");	//Size is fixed A in I-Stowage
			tdrUtilizeVO.setCntrSize("A");
			tdrUtilizeVO.setStatus(tdrUtilizeSlotPortVO.getStatus() + "I");
			tdrUtilizeVO.setQty(tdrUtilizeSlotPortVO.getInterAb());
			
			//Save POD_ISO
			if( tdrUtilizeSlotPortVO.getStatus() != null && tdrUtilizeSlotPortVO.getStatus().equals("O") )
				tdrUtilizeVO.setPodIso(tdrHeaderVO.getPortCd());
			else
				tdrUtilizeVO.setPodIso("XXXXX");

			voList.add(voList.size(), tdrUtilizeVO);
		}		
/*
 * 	
		if(!tdrUtilizeSlotPortVO.getTrade45().equals("") && !tdrUtilizeSlotPortVO.getTrade45().equals("0")){
			TdrUtilizeVO tdrUtilizeVO = setTdrUtilizeVO(tdrHeaderVO, tdrUtilizeSlotPortVO, account);
			
			tdrUtilizeVO.setPod("ALL");
			tdrUtilizeVO.setCntrType("A");
			tdrUtilizeVO.setCntrSize("3");
			tdrUtilizeVO.setStatus(tdrUtilizeSlotPortVO.getStatus() + "M");
			tdrUtilizeVO.setQty(tdrUtilizeSlotPortVO.getTrade45());
			
			//Save POD_ISO
			if( tdrUtilizeSlotPortVO.getStatus() != null && tdrUtilizeSlotPortVO.getStatus().equals("O") )
				tdrUtilizeVO.setPodIso(tdrHeaderVO.getPortCd());
			else
				tdrUtilizeVO.setPodIso("XXXXX");

			voList.add(voList.size(), tdrUtilizeVO);
		}		
		

		if(!tdrUtilizeSlotPortVO.getInter45().equals("") && !tdrUtilizeSlotPortVO.getInter45().equals("0")){
			TdrUtilizeVO tdrUtilizeVO = setTdrUtilizeVO(tdrHeaderVO, tdrUtilizeSlotPortVO, account);
			
			tdrUtilizeVO.setPod("ALL");
			tdrUtilizeVO.setCntrType("A");
			tdrUtilizeVO.setCntrSize("9");		//HC45 Used Change 9
			tdrUtilizeVO.setStatus(tdrUtilizeSlotPortVO.getStatus() + "I");
			tdrUtilizeVO.setQty(tdrUtilizeSlotPortVO.getInter45());
			
			//Save POD_ISO
			if( tdrUtilizeSlotPortVO.getStatus() != null && tdrUtilizeSlotPortVO.getStatus().equals("O") )
				tdrUtilizeVO.setPodIso(tdrHeaderVO.getPortCd());
			else
				tdrUtilizeVO.setPodIso("XXXXX");

			voList.add(voList.size(), tdrUtilizeVO);
		}
*/				
	}
	
	/**
	 * Converting Vo of Sheet to Vo which is possible CUD
	 * Lane 
	 * @param 	TdrHeaderVO tdrHeaderVO
	 * @param 	TdrDistLoadVolVO tdrDistLoadVolVO
	 * @param 	SignOnUserAccount account
	 * @exception EventException
	 */
	private TdrSummaryVO setTdrSummaryVO(TdrHeaderVO tdrHeaderVO, TdrDistLoadVolVO tdrDistLoadVolVO, SignOnUserAccount account){
		TdrSummaryVO tdrSummaryVO 	= new TdrSummaryVO();
		
		tdrSummaryVO.setVslCd		(tdrHeaderVO.getVslCd		());
		tdrSummaryVO.setVoyNo		(tdrHeaderVO.getVoyNo		());
		tdrSummaryVO.setDirCd		(tdrHeaderVO.getDirCd		());
		tdrSummaryVO.setPortCd		(tdrHeaderVO.getPortCd		());
		tdrSummaryVO.setCallInd		(tdrHeaderVO.getCallInd		());
		tdrSummaryVO.setOprCd		(tdrDistLoadVolVO.getOprCd	());
		////tdrSummaryVO.setPod			(tdrDistLoadVolVO.getIdxSheet().equals("0") ? tdrHeaderVO.getPortCd() : tdrDistLoadVolVO.getPodCd());
		tdrSummaryVO.setPod			(tdrDistLoadVolVO.getIdxSheet().equals("0") ? tdrHeaderVO.getPortCd() : tdrDistLoadVolVO.getPodCd());
		tdrSummaryVO.setUpdateUser	(account.getUsr_id());
		
		return tdrSummaryVO;
	}
	
	/**
	 * Converting Vo of Sheet to Vo which is possible CUD
	 * Lane 
	 * @param 	TdrHeaderVO tdrHeaderVO 
	 * @param 	TdrUtilizeSlotPortVO tdrUtilizeSlotPortVO
	 * @param 	SignOnUserAccount account
	 * @exception EventException
	 */
	private TdrUtilizeVO setTdrUtilizeVO(TdrHeaderVO tdrHeaderVO, TdrUtilizeSlotPortVO tdrUtilizeSlotPortVO, SignOnUserAccount account){
		TdrUtilizeVO tdrUtilizeVO = new TdrUtilizeVO();
		
		tdrUtilizeVO.setVslCd(tdrHeaderVO.getVslCd());
		tdrUtilizeVO.setVoyNo(tdrHeaderVO.getVoyNo());
		tdrUtilizeVO.setDirCd(tdrHeaderVO.getDirCd());
		tdrUtilizeVO.setPortCd(tdrHeaderVO.getPortCd());
		tdrUtilizeVO.setCallInd(tdrHeaderVO.getCallInd());
		tdrUtilizeVO.setOprCd(tdrUtilizeSlotPortVO.getOprCd());
		tdrUtilizeVO.setUpdateUser(account.getUsr_id());
		
		return tdrUtilizeVO;
	}	
	/**
	 * Converting Vo of Sheet to Vo which is possible CUD
	 * Lane 
	 * @param 	List<TdrSummaryVO> voList
	 * @param 	TdrHeaderVO tdrHeaderVO
	 * @param 	DischVolSGTdrVO dischVolSGTdrVO
	 * @exception EventException
	 */
	private void convertSCDelToSummaryDeVO(List<TdrSummaryVO> voList,
											TdrHeaderVO tdrHeaderVO,
											DischVolSGTdrVO dischVolSGTdrVO,
											int idxSheet){
		String[] status = new String[2];
		status[0] = "DS";
		status[1] = "LS";
		
		TdrSummaryVO tdrSummaryVO = new TdrSummaryVO();
		
		tdrSummaryVO.setVslCd(tdrHeaderVO.getVslCd());
		tdrSummaryVO.setVoyNo(tdrHeaderVO.getVoyNo());
		tdrSummaryVO.setDirCd(tdrHeaderVO.getDirCd());
		tdrSummaryVO.setPortCd(tdrHeaderVO.getPortCd());
		tdrSummaryVO.setCallInd(tdrHeaderVO.getCallInd());
		tdrSummaryVO.setOprCd(dischVolSGTdrVO.getOprCd());
		tdrSummaryVO.setPod(dischVolSGTdrVO.getPod());
		tdrSummaryVO.setStatus(status[idxSheet]);
		
		voList.add(tdrSummaryVO);
	}
    /**
     * Converting Vo of Sheet to Vo which is possible CUD
     * Lane 
     * @param   List<TdrSummaryVO> voList
     * @param   TdrHeaderVO tdrHeaderVO
     * @param   DischVolSGTdrVO dischVolSGTdrVO
     * @exception EventException
     */
    private void convertSCDelToSummaryLoadAkDeVO(List<TdrSummaryVO> voList,
                                            TdrHeaderVO tdrHeaderVO,
                                            DischVolSGTdrVO dischVolSGTdrVO,
                                            int idxSheet){
        String[] status = new String[2];
        status[0] = "DS";
        status[1] = "ST";
        
        TdrSummaryVO tdrSummaryVO = new TdrSummaryVO();
        
        tdrSummaryVO.setVslCd(tdrHeaderVO.getVslCd());
        tdrSummaryVO.setVoyNo(tdrHeaderVO.getVoyNo());
        tdrSummaryVO.setDirCd(tdrHeaderVO.getDirCd());
        tdrSummaryVO.setPortCd(tdrHeaderVO.getPortCd());
        tdrSummaryVO.setCallInd(tdrHeaderVO.getCallInd());
        tdrSummaryVO.setOprCd(dischVolSGTdrVO.getOprCd());
        tdrSummaryVO.setPod(dischVolSGTdrVO.getPod());
        tdrSummaryVO.setStatus(status[idxSheet]);
        
        voList.add(tdrSummaryVO);
    }
	/**
	 * Converting Vo of Sheet to Vo which is possible CUD
	 * Lane 
	 * @param 	List<TdrSummaryVO> voList
	 * @param 	TdrHeaderVO tdrHeaderVO
	 * @param 	DischVolSGTdrVO dischVolSGTdrVO
	 * @exception EventException
	 */
	private void convertSCDelAllToSummaryDeVO(	List<TdrSummaryVO> voList,
												TdrHeaderVO tdrHeaderVO,
												DischVolSGTdrVO dischVolSGTdrVO,
												int idxSheet){
		String[] status = new String[2];
		status[0] = "DS";
		status[1] = "LS";
		
		TdrSummaryVO tdrSummaryVO = new TdrSummaryVO();
		
		tdrSummaryVO.setVslCd(tdrHeaderVO.getVslCd());
		tdrSummaryVO.setVoyNo(tdrHeaderVO.getVoyNo());
		tdrSummaryVO.setDirCd(tdrHeaderVO.getDirCd());
		tdrSummaryVO.setPortCd(tdrHeaderVO.getPortCd());
		tdrSummaryVO.setCallInd(tdrHeaderVO.getCallInd());
		tdrSummaryVO.setStatus(status[idxSheet]);
		
		voList.add(tdrSummaryVO);
		
		if(idxSheet == 1){
			tdrSummaryVO = new TdrSummaryVO();
			
			tdrSummaryVO.setVslCd(tdrHeaderVO.getVslCd());
			tdrSummaryVO.setVoyNo(tdrHeaderVO.getVoyNo());
			tdrSummaryVO.setDirCd(tdrHeaderVO.getDirCd());
			tdrSummaryVO.setPortCd(tdrHeaderVO.getPortCd());
			tdrSummaryVO.setCallInd(tdrHeaderVO.getCallInd());
			tdrSummaryVO.setStatus("ST");
			
			voList.add(tdrSummaryVO);
		}
	}
	
	/**
	 * Converting Vo of Sheet to Vo which is possible CUD
	 * Lane 
	 * @param 	List<TdrSummaryVO> voList
	 * @param 	TdrHeaderVO tdrHeaderVO
	 * @param 	DischVolSGTdrVO dischVolSGTdrVO
	 * @param 	SignOnUserAccount account 
	 * @exception EventException
	 */
	private void convertSCSheetToSummaryVO(List<TdrSummaryVO> voList,
											TdrHeaderVO tdrHeaderVO,
											DischVolSGTdrVO dischVolSGTdrVO,
											SignOnUserAccount account,
											int idxSheet){
		String[] status = new String[3];
		status[0] = "DS";
		////:2016-12-14:////status[1] = "LS";
		status[1] = "LM";
		
		status[2] = "ST";
		
		TdrSummaryVO tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, dischVolSGTdrVO, account);
		
		if(!dischVolSGTdrVO.getDg20Qty().equals("") && !dischVolSGTdrVO.getDg20Qty().equals("0")){
			tdrSummaryVO.setCntrType("D");
			tdrSummaryVO.setCntrSize("2");
			tdrSummaryVO.setStatus(status[idxSheet]);
			tdrSummaryVO.setQty(dischVolSGTdrVO.getDg20Qty());
			tdrSummaryVO.setWeight(chgTonToKg(dischVolSGTdrVO.getDg20Wgt()));
			
			voList.add(tdrSummaryVO);
		}else{
			tdrSummaryVO.setCntrType("D");
			tdrSummaryVO.setCntrSize("2");
			tdrSummaryVO.setStatus(status[idxSheet]);
			tdrSummaryVO.setQty("0");
			tdrSummaryVO.setWeight("0");
			
			voList.add(tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, dischVolSGTdrVO, account);
		if(!dischVolSGTdrVO.getDg40Qty().equals("") && !dischVolSGTdrVO.getDg40Qty().equals("0")){
			tdrSummaryVO.setCntrType("D");
			tdrSummaryVO.setCntrSize("4");
			tdrSummaryVO.setStatus(status[idxSheet]);
			tdrSummaryVO.setQty(dischVolSGTdrVO.getDg40Qty());
			tdrSummaryVO.setWeight(chgTonToKg(dischVolSGTdrVO.getDg40Wgt()));
			
			voList.add(tdrSummaryVO);
		}

		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, dischVolSGTdrVO, account);
		if(!dischVolSGTdrVO.getRf20Qty().equals("") && !dischVolSGTdrVO.getRf20Qty().equals("0")){
			tdrSummaryVO.setCntrType("R");
			tdrSummaryVO.setCntrSize("2");
			tdrSummaryVO.setStatus(status[idxSheet]);
			tdrSummaryVO.setQty(dischVolSGTdrVO.getRf20Qty());
			tdrSummaryVO.setWeight(chgTonToKg(dischVolSGTdrVO.getRf20Wgt()));
			
			voList.add(tdrSummaryVO);
		}

		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, dischVolSGTdrVO, account);
		if(!dischVolSGTdrVO.getRf40Qty().equals("") && !dischVolSGTdrVO.getRf40Qty().equals("0")){
			tdrSummaryVO.setCntrType("R");
			tdrSummaryVO.setCntrSize("4");
			tdrSummaryVO.setStatus(status[idxSheet]);
			tdrSummaryVO.setQty(dischVolSGTdrVO.getRf40Qty());
			tdrSummaryVO.setWeight(chgTonToKg(dischVolSGTdrVO.getRf40Wgt()));
			
			voList.add(tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, dischVolSGTdrVO, account);
		if(!dischVolSGTdrVO.getAk20Qty().equals("") && !dischVolSGTdrVO.getAk20Qty().equals("0")){
			tdrSummaryVO.setCntrType("A");
			tdrSummaryVO.setCntrSize("2");
			
			////:TOP:TEMP:2016-12-13:////tdrSummaryVO.setStatus(idxSheet == 1 ? status[idxSheet + 1] : status[idxSheet]);
			tdrSummaryVO.setStatus(status[idxSheet]);
			
			tdrSummaryVO.setQty(dischVolSGTdrVO.getAk20Qty());
			tdrSummaryVO.setWeight(chgTonToKg(dischVolSGTdrVO.getAk20Wgt()));
			
			voList.add(tdrSummaryVO);
		}

		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, dischVolSGTdrVO, account);
		if(!dischVolSGTdrVO.getAk40Qty().equals("") && !dischVolSGTdrVO.getAk40Qty().equals("0")){
			tdrSummaryVO.setCntrType("A");
			tdrSummaryVO.setCntrSize("4");
			
			////:TOP:TEMP:2016-12-13:////tdrSummaryVO.setStatus(idxSheet == 1 ? status[idxSheet + 1] : status[idxSheet]);
			tdrSummaryVO.setStatus(status[idxSheet]);
			
			tdrSummaryVO.setQty(dischVolSGTdrVO.getAk40Qty());
			tdrSummaryVO.setWeight(chgTonToKg(dischVolSGTdrVO.getAk40Wgt()));
			
			voList.add(tdrSummaryVO);
		}
	}
	
	/**
	 * Converting Vo of Sheet to Vo which is possible CUD
	 * Lane 
	 * @param 	TdrHeaderVO tdrHeaderVO
	 * @param 	DischVolSGTdrVO dischVolSGTdrVO
	 * @param 	SignOnUserAccount account 
	 * @exception EventException
	 */
	private TdrSummaryVO setTdrSummaryVO(TdrHeaderVO tdrHeaderVO, DischVolSGTdrVO dischVolSGTdrVO, SignOnUserAccount account){
		TdrSummaryVO tdrSummaryVO = new TdrSummaryVO();

		tdrSummaryVO.setVslCd(tdrHeaderVO.getVslCd());
		tdrSummaryVO.setVoyNo(tdrHeaderVO.getVoyNo());
		tdrSummaryVO.setDirCd(tdrHeaderVO.getDirCd());
		tdrSummaryVO.setPortCd(tdrHeaderVO.getPortCd());
		tdrSummaryVO.setCallInd(tdrHeaderVO.getCallInd());
		tdrSummaryVO.setOprCd(dischVolSGTdrVO.getOprCd());
		tdrSummaryVO.setPod(dischVolSGTdrVO.getPod());
		
		return tdrSummaryVO;
	}
	
	/**
	 * Handling multi event<br>
	 * Handling multi event about In page <br>
	 * 
	 * @param String str
	 * @return String
	 * @exception EventException
	 */
	private String hourMinuteStr(String str){
		str = str.replaceAll(" ", "");
		String mmStr = str.substring(str.length() - 2); 
		String hhStr = str.substring(0, str.length() - 2);
		str = Integer.parseInt(hhStr) + ":" + mmStr;
		return str;
	}
	
	/**
	 * VOP_OPF_0057 : Retrieve <br>
	 * Retrieve [Cargo Handling Performance]<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<CgoHndPerformInputVO>
	 * @exception EventException
	 */
	public List<CgoHndPerformInputVO> searchCgoHndPerformList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException {
		try {
			return dbDao.searchCgoHndPerformList(terminalDepartureReportConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cargo Handling Performance'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cargo Handling Performance'"}).getMessage(), ex);
        }
	}
	 
	/**
	 * VOP_OPF_0057 : Retrieve <br>
	 * Checking Port Code validation<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<MdmYardVO>
	 * @exception EventException
	 */
	public List<MdmYardVO> searchMdmYardCombo(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException {
		try {
			return dbDao.searchMdmYardCombo(terminalDepartureReportConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Code'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Code'"}).getMessage(), ex);
        }
	}

	/**
	 * VOP_OPF_0061 : Retrieve <br>
	 * Retrieve [Cargo Re-Handling Performance]<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<CgoHndPerformInputVO>
	 * @exception EventException
	 */
	public List<CgoRhndPerformInputVO> searchCgoRhndPerformList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException {
		try {
			return dbDao.searchCgoRhndPerformList(terminalDepartureReportConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cargo Re-Handling Performance'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cargo Re-Handling Performance'"}).getMessage(), ex);
        }
	}	
	
	/**
	 * VOP_OPF_0061 : Retrieve <br>
	 * Retrieve [Cargo Re-Handling Performance]<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<CgoHndPerformInputVO>
	 * @exception EventException
	 */
	public List<CgoRhndPerformInputVO> searchRestowReasonList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException {
		try {
			return dbDao.searchRestowReasonList(terminalDepartureReportConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cargo Re-Handling Performance'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Cargo Re-Handling Performance'"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_OPF_0064 : Retrieve <br>
	 * Retrieve [VSL Condition Statistics]<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<TdrListOptionVO>
	 * @exception EventException
	 */
	public List<TdrListOptionVO> searchVslConditionList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException {
		try {
			return dbDao.searchVslConditionList(terminalDepartureReportConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VSL Condition Statistics'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VSL Condition Statistics'"}).getMessage(), ex);
        }
	}
	
//	/**
//	 * VOP_OPF_0063 : Retrieve <br>
//	 * Retrieve [Terminal Performance - Port]<br>
//	 * 
//	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
//	 * @return List<TmnlPerformInputVO>
//	 * @exception EventException
//	 */
//	public List<TmnlPerformInputVO> searchTmnlPerformPortList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException {
//		try {
//			return dbDao.searchTmnlPerformPortList(terminalDepartureReportConditionVO);
//        } catch (DAOException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Performance - Port'"}).getMessage(), ex);
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Performance - Port'"}).getMessage(), ex);
//        }
//	}
	
	/**
	 * VOP_OPF_0063 : Retrieve <br>
	 * Retrieve [Terminal Performance - Lane]<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<TmnlPerformInputVO>
	 * @exception EventException
	 */
	public List<TmnlPerformInputVO> searchTmnlPerformLaneList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException {
		try {
			return dbDao.searchTmnlPerformLaneList(terminalDepartureReportConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Performance - Lane'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Performance - Lane'"}).getMessage(), ex);
        }
	}

	/**
	 * VOP_OPF_0069 : Retrieve <br>
	 * Retrieve [Terminal Productivity Report]<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<TmnlPerformVO>
	 * @exception EventException
	 */
	public List<TmnlPerformVO> searchTmnlProdList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException {
		try {
			if( terminalDepartureReportConditionVO.getGroupBy().equals("L")){
				return dbDao.searchTmnlProdList(terminalDepartureReportConditionVO);
			}else{
				return dbDao.searchTmnlProdMonthList(terminalDepartureReportConditionVO);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Productivity Report'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Productivity Report'"}).getMessage(), ex);
        }
	}	

	/**
	 * VOP_OPF_0069 : Retrieve <br>
	 * Checking Port Code validation<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<MdmRhqComboVO>
	 * @exception EventException
	 */
	public List<MdmRhqComboVO> searchMdmRhqCombo(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException {
		try {
			return dbDao.searchMdmRhqCombo(terminalDepartureReportConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Code'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Code'"}).getMessage(), ex);
        }
	}		
	
	/**
	 * VOP_OPF_2069 : Retrieve <br>
	 * Retrieve [TDR Details]<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<TerminalDepartureReportVO>
	 * @exception EventException
	 */
	public List<TerminalDepartureReportVO> searchTdrDetailList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException {
		try {
			if( terminalDepartureReportConditionVO.getGroupBy().equals("L")){
				return dbDao.searchTdrDetailList(terminalDepartureReportConditionVO);
			}else{
				return dbDao.searchTdrDetailMonthList(terminalDepartureReportConditionVO);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Details'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Details'"}).getMessage(), ex);
        }
	}
    /**
     * 
     * Modifying Total Container Handling Moves of TDR Header  <br>
     *
     * @param  TdrHeaderVO[]      tdrHeaderVO
     * @param  TerminalDepartureReportCondVO terminalDepartureReportCondVO
     * @param  SignOnUserAccount account
     * @throws EventException
     */
    public void modifyTdrHeaderMvs(TdrHeaderVO[] tdrHeaderVO,TerminalDepartureReportCondVO terminalDepartureReportCondVO, SignOnUserAccount account)throws EventException{
        String totMvs = "0";
        List<TerminalDepartureReportVO> list = null;
        TerminalDepartureReportConditionVO terminalDepartureReportConditionVO = null;
        try{
            tdrHeaderVO[0].setUpdateUser(account.getUsr_id());
            terminalDepartureReportConditionVO = new TerminalDepartureReportConditionVO();
            
            terminalDepartureReportConditionVO.setVslCd     (   terminalDepartureReportCondVO.getVslCd()                      );
            terminalDepartureReportConditionVO.setVoyNo     (   terminalDepartureReportCondVO.getVoyNo()                      );
            terminalDepartureReportConditionVO.setDirCd     (   terminalDepartureReportCondVO.getDirCd()                      );
            terminalDepartureReportConditionVO.setYdCd      (   terminalDepartureReportCondVO.getYdCd()        );
            terminalDepartureReportConditionVO.setClptIndSeq(   terminalDepartureReportCondVO.getClptIndSeq()  );
 
            list = dbDao.searchTotMoveData( terminalDepartureReportConditionVO );  
            
            if( list.size() > 0 ){
                totMvs = list.get(0).getTotMvs();
            }
     
            List<TdrHeaderSkdVO> tdrHeaderSkdVO = dbDao.searchTdrHeaderList( terminalDepartureReportCondVO);
            tdrHeaderVO[0].setMvs     (    totMvs  );
            /* 
             * 1. GrossTml =  tdrRound(moveHandle / parseFloat(parseHHMM(formObject.gross_work.value) / 60), 1);
             * 2. NET_TML  =  tdrRound(moveHandle / parseFloat(parseHHMM(formObject.net_work.value) / 60), 1); 
             * 3. GROSS_GC =  tdrRound(moveHandle / parseFloat(parseHHMM(formObject.gross_gang.value) / 60), 1);
             * 4. NET_GC   =  tdrRound(moveHandle / parseFloat(parseHHMM(formObject.net_gang.value) / 60), 1);
             */
            String grossTml = "";
            String netTml   = "";
            String grossGc  = "";
            String netGc    = "";
            if( tdrHeaderSkdVO.size() > 0 ){
                if( !totMvs.equals("0")){
                    if ( !tdrHeaderSkdVO.get(0).getGrossWork().equals("") ) {
                         if( parseHHMM( tdrHeaderSkdVO.get(0).getGrossWork() ) == 0 ) {
                        	 grossTml =  totMvs;
                         }else{
                        	 grossTml =  JSPUtil.round(Float.parseFloat(totMvs) / ( parseHHMM( tdrHeaderSkdVO.get(0).getGrossWork() )  / 60d), -1)   +"";
                         }
                    }
                    if ( !tdrHeaderSkdVO.get(0).getNetWork().equals("") ){
                        if( parseHHMM( tdrHeaderSkdVO.get(0).getNetWork() ) == 0 ) {
                        	netTml = totMvs;
                        }else{
                        	netTml =  JSPUtil.round(Float.parseFloat(totMvs) /    ( parseHHMM( tdrHeaderSkdVO.get(0).getNetWork() )  / 60d) , -1) +"";
                        }
                        
                    }
                    if ( !tdrHeaderSkdVO.get(0).getGrossGang().equals("") ){
                        if( parseHHMM( tdrHeaderSkdVO.get(0).getGrossGang() ) == 0 ) {
                        	grossGc = totMvs;
                        }else{
                        	grossGc =  JSPUtil.round(Float.parseFloat(totMvs) /  ( parseHHMM( tdrHeaderSkdVO.get(0).getGrossGang() )  / 60d),-1) +"";
                        }
                    }
                    if ( !tdrHeaderSkdVO.get(0).getNetGang().equals("") ){
                        if( parseHHMM( tdrHeaderSkdVO.get(0).getNetGang() ) == 0 ) {
                        	netGc = totMvs;
                        }else{
                        	netGc    =  JSPUtil.round(Float.parseFloat(totMvs) /  ( parseHHMM( tdrHeaderSkdVO.get(0).getNetGang() )  / 60d), -1) +"";
                        }
                    }
                }
            }
            
            
            tdrHeaderVO[0].setGrossTml(    grossTml );
            tdrHeaderVO[0].setNetTml  (    netTml   );
            tdrHeaderVO[0].setGrossGc (    grossGc  );
            tdrHeaderVO[0].setNetGc   (    netGc    );
            dbDao.modifyTdrHeaderMvs(tdrHeaderVO[0]);
            
            
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Mvs"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Mvs"}).getMessage(), ex);
        }
    }
    private int  parseHHMM(String sHhmm){
        String[] arrHHMM = sHhmm.split(":");
        String strHH = arrHHMM[0];
        String strMM = arrHHMM[1];
        
        int sumMM = 0;
        if("".compareTo(strHH)==0){ strHH = "0"; }  //if( strHH == "")
        if("".compareTo(strMM)==0){ strMM = "0"; }	// if( strMM == "") 
        
        sumMM  = Integer.parseInt( strHH  ) * 60;
        sumMM  = sumMM + Integer.parseInt(strMM);
        
        return sumMM;
    }
 
	/**
	 * VOP_OPF_0095 : Retrieve <br>
	 * Retrieve Missing TDR List<br>
	 * 
	 * @param MissingTDRCondVO missingTDRCondVO
	 * @return List<MissingTDRVO>
	 * @exception EventException
	 */
	public List<MissingTDRVO> searchMissingTDRList(MissingTDRCondVO missingTDRCondVO) throws EventException {
		try {
			return dbDao.searchMissingTDRList(missingTDRCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Missing TDR List"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Missing TDR List"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0095 : Port Code OnChange <br>
	 * After checking Port Code Validation, get RHQ Office Code<br>
	 * 
	 * @param MissingTDRCondVO missingTDRCondVO
	 * @return List<MissingTDRVO>
	 * @exception EventException
	 */
	public List<MissingTDRVO> searchPortCodeNRhqOfcCdList(MissingTDRCondVO missingTDRCondVO) throws EventException {
		try {
			return dbDao.searchPortCodeNRhqOfcCdList(missingTDRCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Code List"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Code List"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * Retrieve mail Receiver Info<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String portCd
	 * @param String spclCgoCateCd
	 * @return String
	 * @throws EventException
	 */
	public String searchReceiver(String vslCd, String skdVoyNo, String skdDirCd, String portCd, String spclCgoCateCd) throws EventException {
		try {
			return dbDao.searchReceiver(vslCd,skdVoyNo,skdDirCd,portCd,spclCgoCateCd);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Opf Terminal Departure Report Detail'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Opf Terminal Departure Report Detail'"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0036 : Save<br>
	 * change ton to kg
	 * @param String ton
	 * @return String
	 */
	private String chgTonToKg(String ton) {
		String kg = "0";
		if(ton != null && !ton.equals("")) {
			float fTon = Float.parseFloat(ton);
			kg = String.valueOf(fTon);
			//kg = String.valueOf(fTon * 1000); //2015.06.19 주석처리. 
		}
		return kg;
	}
}