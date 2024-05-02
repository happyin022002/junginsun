/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalDepartureReportBCImpl.java
*@FileTitle : TDR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.06 장석현
* 1.0 Creation
* 
* History
* 2015.04.21 이병훈 [CHM-201535480] VNOR Report Creation 화면 기능 개선(Remark Submit)
* 2015.05.22 이병훈 [CHM-201535464] VNOR Report Summary Inquiry 개발
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration.TerminalDepartureReportDBDAO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.CgoHndPerformInputVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.CgoRhndPerformInputVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.DischVolSGTdrVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.FleetStatusVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MdmRhqComboVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MissingTDRCondVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MissingTDRVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfTdrAtchFileVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfTmlProdRptRsnCdVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfVnorAtchFileVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfVnorSummaryVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.PortLogDetailVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.PortLogHeadVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.RHContainerVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrAllocationBSAVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrBsaVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrDistLoadVolVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrHeaderSkdVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrSlotHC45VO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrUtilizeSlotPortVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrUtilizeVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportConditionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformInputVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.VskVslPortSkdSheetVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.ComComboVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmYardVO;
import com.hanjin.syscommon.common.table.OpfAtchFileVO;
import com.hanjin.syscommon.common.table.OpfRstwgRsnCdVO;
import com.hanjin.syscommon.common.table.OpfTmlDepRptDtlVO;
import com.hanjin.syscommon.common.table.OpfVnorEmlStupVO;
import com.hanjin.syscommon.common.table.OpfVnorItmVO;
import com.hanjin.syscommon.common.table.OpfVnorVO;
import com.hanjin.syscommon.common.table.TdrAllocationVO;
import com.hanjin.syscommon.common.table.TdrCntrDetailVO;
import com.hanjin.syscommon.common.table.TdrCraneVO;
import com.hanjin.syscommon.common.table.TdrHeaderVO;
import com.hanjin.syscommon.common.table.TdrSummaryVO;

/**
 * NIS2010-CargoLoadingResultMgt Business Logic Basic Command implementation<br>
 * - NIS2010-CargoLoadingResultMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jang Suk Hyun
 * @see VOP_OPF_0036EventResponse,TerminalDepartureReportBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class TerminalDepartureReportBCImpl extends BasicCommandSupport implements TerminalDepartureReportBC {

	// Database Access Object 
	private transient TerminalDepartureReportDBDAO dbDao = null;

	/**
	 * TerminalDepartureReportBCImpl 객체 생성<br>
	 * TerminalDepartureReportDBDAO를 생성한다.<br>
	 */
	public TerminalDepartureReportBCImpl() {
		dbDao = new TerminalDepartureReportDBDAO();
	}
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR VESSAL SCHEDULE]을 [조회] 합니다.<br>
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
	 * [TDR Header]을 [조회] 합니다.<br>
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
	 * [TDR Port Log]을 [조회] 합니다.<br>
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
	 * [TDR Port Log Detail]을 [조회] 합니다.<br>
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
	 * [TDR Discharge Total Volume Import]을 [조회] 합니다.<br>
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
	 * [TDR Discharge Total Volume]을 [조회] 합니다.<br>
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
	 * [TDR Discharge SCG Import]을 [조회] 합니다.<br>
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
	 * [TDR Load SCG]을 [조회] 합니다.<br>
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
	 * [TDR Discharge SCG]을 [조회] 합니다.<br>
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
	 * [TDR Discharge Break Bulk Import]을 [조회] 합니다.<br>
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
	 * [TDR Discharge Break Bulk]을 [조회] 합니다.<br>
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
	 * [TDR Load Break Bulk Import]을 [조회] 합니다.<br>
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
	 * [TDR Load SCG Import]을 [조회] 합니다.<br>
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
	 * [TDR Load Break Bulk Import]을 [조회] 합니다.<br>
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
	 * [TDR COD]을 [조회] 합니다.<br>
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
	 * [TDR Ocean Port]을 [조회] 합니다.<br>
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
	 * [TDR ReHandle]을 [조회] 합니다.<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<RHContainerVO>
	 * @exception EventException
	 */
	public List<RHContainerVO> searchTdrRHList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
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
	 * [TDR MisHandle]을 [조회] 합니다.<br>
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
	 * [TDR Slot BSA]을 [조회] 합니다.<br>
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
	 * [TDR Slot BSA Import]을 [조회] 합니다.<br>
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
	 * [TDR Slot HC45']을 [조회] 합니다.<br>
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
	 * [TDR Slot HC45' Import]을 [조회] 합니다.<br>
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
	 * [TDR Slot Dep]을 [조회] 합니다.<br>
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
	 * [TDR Slot Port]을 [조회] 합니다.<br>
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
	 * [TDR Slot Port Import]을 [조회] 합니다.<br>
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
	 * [TDR Slot Dep Import]을 [조회] 합니다.<br>
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
	 * [TDR TmpStwg]을 [조회] 합니다.<br>
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
	 * [TDR ReHandle Code]을 [조회] 합니다.<br>
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
	 * [Exclude Tpr]을 [조회] 합니다.<br>
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
	 * [TERMINAL DEPARTURE REPORT HEADER]를 생성, 수정, 삭제 합니다. <br>
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
	 * [TERMINAL DEPARTURE REPORT CRANE]를 생성, 수정, 삭제 합니다. <br>
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
					insVO.setWorkTime(hourMinuteStr(portLogDetailVO[i].getWork()));
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
	 * [TERMINAL DEPARTURE REPORT Total]를 생성, 수정, 삭제 합니다. <br>
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
				//Import시에 Delete All Logic추가.
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
     * [TERMINAL DEPARTURE REPORT Total]를 생성, 수정, 삭제 합니다. <br>
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
                //Import시에 Delete All Logic추가.
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
	 * [TERMINAL DEPARTURE REPORT SCG]를 생성, 수정, 삭제 합니다. <br>
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
				//Import시에 Delete All Logic추가.
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
     * [TERMINAL DEPARTURE REPORT SCG]를 생성, 수정, 삭제 합니다. <br>
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
                //Import시에 Delete All Logic추가.
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
                        convertSCDelToSummaryLoadAkDeVO(deleteVoList, tdrHeaderVO[0], dischVolSGTdrVO[i], Integer.parseInt(dischVolSGTdrVO[i].getIdxSheet()));
                        convertSCDelToSummaryDeVO(deleteVoList, tdrHeaderVO[0], dischVolSGTdrVO[i], Integer.parseInt(dischVolSGTdrVO[i].getIdxSheet()));
                        convertSCSheetToSummaryVO(insertVoList, tdrHeaderVO[0], dischVolSGTdrVO[i], account, Integer.parseInt(dischVolSGTdrVO[i].getIdxSheet()));
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
	 * [TERMINAL DEPARTURE REPORT Break Bulk]를 생성, 수정, 삭제 합니다. <br>
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
				//Import시에 Delete All Logic추가.
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
					
					//CargoType추가.... 아이스토지 데이터 마추기위해... 
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
	 * [TERMINAL DEPARTURE REPORT COD]를 생성, 수정, 삭제 합니다. <br>
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
					tdrCntrDetailVO[i].setStatus("LS");		//2009-07-29 Daniel(Jung-Hwan) IN 
					
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
	 * [TERMINAL DEPARTURE REPORT ReHandle]를 생성, 수정, 삭제 합니다. <br>
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
					tdrCntrDetailVO[i].setVslCd(tdrHeaderVO[0].getVslCd());
					tdrCntrDetailVO[i].setVoyNo(tdrHeaderVO[0].getVoyNo());
					tdrCntrDetailVO[i].setDirCd(tdrHeaderVO[0].getDirCd());
					tdrCntrDetailVO[i].setPortCd(tdrHeaderVO[0].getPortCd());
					tdrCntrDetailVO[i].setCallInd(tdrHeaderVO[0].getCallInd());
					tdrCntrDetailVO[i].setStatus("ST");		//2009-07-29 Daniel(Jung-Hwan) IN
					
					if ( tdrCntrDetailVO[i].getIbflag().equals("I")){
						tdrCntrDetailVO[i].setUpdateUser(account.getUsr_id());
						
						//Reson Code분리...
						if(tdrCntrDetailVO[i].getShiftRsn() != null && tdrCntrDetailVO[i].getShiftRsn().length() > 2){
							tdrCntrDetailVO[i].setShiftType(tdrCntrDetailVO[i].getShiftRsn().substring(0, 1));
							tdrCntrDetailVO[i].setShiftRsn(tdrCntrDetailVO[i].getShiftRsn().substring(1));
						}
						
						insertVoList.add(tdrCntrDetailVO[i]);
					} else if ( tdrCntrDetailVO[i].getIbflag().equals("U")){
						tdrCntrDetailVO[i].setUpdateUser(account.getUsr_id());
						
						//Reson Code분리...
						if(tdrCntrDetailVO[i].getShiftRsn() != null && tdrCntrDetailVO[i].getShiftRsn().length() > 2){
							tdrCntrDetailVO[i].setShiftType(tdrCntrDetailVO[i].getShiftRsn().substring(0, 1));
							tdrCntrDetailVO[i].setShiftRsn(tdrCntrDetailVO[i].getShiftRsn().substring(1));
						}
						
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
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report ReHandle"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report ReHandle"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * [TERMINAL DEPARTURE REPORT MisHandle]를 생성, 수정, 삭제 합니다. <br>
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
	 * [TERMINAL DEPARTURE REPORT SlotBSA]를 생성, 수정, 삭제 합니다. <br>
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
						
						//만약 있으면 Update...........
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
	 * [TERMINAL DEPARTURE REPORT Slot HC45']를 생성, 수정, 삭제 합니다. <br>
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
						//20FtLoad물량...
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
						
						//40FtLoad물량...
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

						//45FtLoad물량...
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
				
				//Dao Delete 호출
				dbDao.removeTdrSlotHC45UtilizeS(deleteVoList1);
				dbDao.removeTdrBsaS(deleteVoList2);
				
				//Dao Insert 호출
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
	 * [TERMINAL DEPARTURE REPORT Slot Utilize]를 생성, 수정, 삭제 합니다. <br>
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
	 * [TERMINAL DEPARTURE REPORT TmpStwg]를 생성, 수정, 삭제 합니다. <br>
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
	 * [Exclude Tpr]를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageExcludeTpr(OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVO, SignOnUserAccount account) throws EventException{
		
		try{
			if(opfTmlProdRptRsnCdVO != null){
				OpfTmlDepRptDtlVO opfTmlDepRptDtlVO = new OpfTmlDepRptDtlVO();
//				String tempStr = opfTmlProdRptRsnCdVO[0].getKeyOfRemark();
				String tempStr = "";
				boolean chkFlag = false;
				for ( int i=0; i< opfTmlProdRptRsnCdVO.length; i++ ) {
					if("1".equals(opfTmlProdRptRsnCdVO[i].getTdrRptRsnCd())){
						chkFlag = true;
						tempStr = opfTmlProdRptRsnCdVO[i].getKeyOfRemark();
					}
				}
				
				if(!chkFlag){
					for ( int i=0; i< opfTmlProdRptRsnCdVO.length; i++ ) {
						if("D".equals(opfTmlProdRptRsnCdVO[i].getIbflag())){
							tempStr = opfTmlProdRptRsnCdVO[i].getKeyOfRemark();
						}
					}
				}
				
				String[] arrDataKey = tempStr.split("_/");
				
				opfTmlDepRptDtlVO.setVslCd(arrDataKey[0]);
				opfTmlDepRptDtlVO.setSkdVoyNo(arrDataKey[1]);
				opfTmlDepRptDtlVO.setSkdDirCd(arrDataKey[2]);
				opfTmlDepRptDtlVO.setClptIndSeq(arrDataKey[3]);
				opfTmlDepRptDtlVO.setClptCd(arrDataKey[4]);
				if(chkFlag){
					opfTmlDepRptDtlVO.setTmlProdRptRsnCd(arrDataKey[5]);
					opfTmlDepRptDtlVO.setTmlProdRptRsnRmk(arrDataKey.length > 6 ?  arrDataKey[6] : "");
				}
				
				opfTmlDepRptDtlVO.setTmlProdRptRsnCreUsrId(account.getUsr_id());
//				opfTmlDepRptDtlVO.setTmlProdRptRsnCd(opfTmlProdRptRsnCdVO[0].getTmlProdRptRsnCd());
				
				opfTmlDepRptDtlVO.setCreUsrId(account.getUsr_id());
				opfTmlDepRptDtlVO.setUpdUsrId(account.getUsr_id());
				
				if(opfTmlProdRptRsnCdVO[0].getIbflag().equals("U")){
					boolean existsVO = dbDao.existsExcludeTpr(opfTmlDepRptDtlVO);
//					if(existsVO)
//						dbDao.modifyExcludeTpr(opfTmlDepRptDtlVO);
//					else
//						dbDao.addExcludeTpr(opfTmlDepRptDtlVO);
					if(existsVO)
						dbDao.removeExcludeTpr(opfTmlDepRptDtlVO);
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
	 * Sheet의 Vo를 CUD가 가능한 Vo로 Convert<br>
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
	 * Sheet의 Vo를 CUD가 가능한 Vo로 Convert
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
	 * Sheet의 Vo를 CUD가 가능한 Vo로 Convert
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
		
		String[] checkExsits = new String[6];

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
		
		TdrSummaryVO tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		if(!tdrDistLoadVolVO.getFullBo20().equals("") && !tdrDistLoadVolVO.getFullBo20().equals("0")){
			tdrSummaryVO.setCntrSize("2");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullBo20());
			tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt20());
			checkExsits[0] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}else{
			tdrSummaryVO.setCntrSize("2");
			tdrSummaryVO.setQty("0");
			tdrSummaryVO.setWeight("0");
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		if(!tdrDistLoadVolVO.getFullBo2h().equals("") && !tdrDistLoadVolVO.getFullBo2h().equals("0")){
			tdrSummaryVO.setCntrSize("3");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullBo2h());
			tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt2h());
			checkExsits[1] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		if(!tdrDistLoadVolVO.getFullBo40().equals("") && !tdrDistLoadVolVO.getFullBo40().equals("0")){
			tdrSummaryVO.setCntrSize("4");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullBo40());
			tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt40());
			checkExsits[2] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		if(!tdrDistLoadVolVO.getFullBo4h().equals("") && !tdrDistLoadVolVO.getFullBo4h().equals("0")){
			tdrSummaryVO.setCntrSize("H");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullBo4h());
			tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt4h());
			checkExsits[3] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		if(!tdrDistLoadVolVO.getFullBo45().equals("") && !tdrDistLoadVolVO.getFullBo45().equals("0")){
			tdrSummaryVO.setCntrSize("L");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullBo45());
			tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt45());
			checkExsits[4] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		//DX add
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		if(!tdrDistLoadVolVO.getFullBoDx().equals("") && !tdrDistLoadVolVO.getFullBoDx().equals("0")){
			tdrSummaryVO.setCntrSize("X");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullBoDx());
			tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWtDx());
			checkExsits[5] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		if(!tdrDistLoadVolVO.getFullTs20().equals("") && !tdrDistLoadVolVO.getFullTs20().equals("0")){
			tdrSummaryVO.setCntrSize("2");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullTs20());
			if(checkExsits[0].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt20()); }
			checkExsits[0] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		if(!tdrDistLoadVolVO.getFullTs2h().equals("") && !tdrDistLoadVolVO.getFullTs2h().equals("0")){
			tdrSummaryVO.setCntrSize("3");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullTs2h());
			if(checkExsits[1].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt2h()); }
			checkExsits[1] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		if(!tdrDistLoadVolVO.getFullTs40().equals("") && !tdrDistLoadVolVO.getFullTs40().equals("0")){
			tdrSummaryVO.setCntrSize("4");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullTs40());
			if(checkExsits[2].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt40()); }
			checkExsits[2] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		if(!tdrDistLoadVolVO.getFullTs4h().equals("") && !tdrDistLoadVolVO.getFullTs4h().equals("0")){
			tdrSummaryVO.setCntrSize("H");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullTs4h());
			if(checkExsits[3].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt4h()); }
			checkExsits[3] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		if(!tdrDistLoadVolVO.getFullTs45().equals("") && !tdrDistLoadVolVO.getFullTs45().equals("0")){
			tdrSummaryVO.setCntrSize("L");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullTs45());
			if(checkExsits[4].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt45()); }
			checkExsits[4] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}	
		
		//DX add
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("F");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		if(!tdrDistLoadVolVO.getFullTsDx().equals("") && !tdrDistLoadVolVO.getFullTsDx().equals("0")){
			tdrSummaryVO.setCntrSize("X");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getFullTsDx());
			if(checkExsits[5].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWtDx()); }
			checkExsits[5] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}	
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		if(!tdrDistLoadVolVO.getEtBo20().equals("") && !tdrDistLoadVolVO.getEtBo20().equals("0")){
			tdrSummaryVO.setCntrSize("2");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtBo20());
			if(checkExsits[0].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt20()); }
			checkExsits[0] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		if(!tdrDistLoadVolVO.getEtBo2h().equals("") && !tdrDistLoadVolVO.getEtBo2h().equals("0")){
			tdrSummaryVO.setCntrSize("3");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtBo2h());
			if(checkExsits[1].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt2h()); }
			checkExsits[1] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		if(!tdrDistLoadVolVO.getEtBo40().equals("") && !tdrDistLoadVolVO.getEtBo40().equals("0")){
			tdrSummaryVO.setCntrSize("4");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtBo40());
			if(checkExsits[2].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt40()); }
			checkExsits[2] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		if(!tdrDistLoadVolVO.getEtBo4h().equals("") && !tdrDistLoadVolVO.getEtBo4h().equals("0")){
			tdrSummaryVO.setCntrSize("H");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtBo4h());
			if(checkExsits[3].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt4h()); }
			checkExsits[3] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		if(!tdrDistLoadVolVO.getEtBo45().equals("") && !tdrDistLoadVolVO.getEtBo45().equals("0")){
			tdrSummaryVO.setCntrSize("L");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtBo45());
			if(checkExsits[4].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt45()); }
			checkExsits[4] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		//DX add
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][0]);
		if(!tdrDistLoadVolVO.getEtBoDx().equals("") && !tdrDistLoadVolVO.getEtBoDx().equals("0")){
			tdrSummaryVO.setCntrSize("X");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtBoDx());
			if(checkExsits[5].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWtDx()); }
			checkExsits[5] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		if(!tdrDistLoadVolVO.getEtTs20().equals("") && !tdrDistLoadVolVO.getEtTs20().equals("0")){
			tdrSummaryVO.setCntrSize("2");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtTs20());
			if(checkExsits[0].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt20()); }
			checkExsits[0] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		if(!tdrDistLoadVolVO.getEtTs2h().equals("") && !tdrDistLoadVolVO.getEtTs2h().equals("0")){
			tdrSummaryVO.setCntrSize("3");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtTs2h());
			if(checkExsits[1].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt2h()); }
			checkExsits[1] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		if(!tdrDistLoadVolVO.getEtTs40().equals("") && !tdrDistLoadVolVO.getEtTs40().equals("0")){
			tdrSummaryVO.setCntrSize("4");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtTs40());
			if(checkExsits[2].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt40()); }
			checkExsits[2] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		if(!tdrDistLoadVolVO.getEtTs4h().equals("") && !tdrDistLoadVolVO.getEtTs4h().equals("0")){
			tdrSummaryVO.setCntrSize("H");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtTs4h());
			if(checkExsits[3].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt4h()); }
			checkExsits[3] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		if(!tdrDistLoadVolVO.getEtTs45().equals("") && !tdrDistLoadVolVO.getEtTs45().equals("0")){
			tdrSummaryVO.setCntrSize("L");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtTs45());
			if(checkExsits[4].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWt45()); }
			checkExsits[4] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}	
		
		//DX add
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, tdrDistLoadVolVO, account);
		tdrSummaryVO.setCntrType("E");
		tdrSummaryVO.setStatus(status[idxKindRow][1]);
		if(!tdrDistLoadVolVO.getEtTsDx().equals("") && !tdrDistLoadVolVO.getEtTsDx().equals("0")){
			tdrSummaryVO.setCntrSize("X");
			tdrSummaryVO.setQty(tdrDistLoadVolVO.getEtTsDx());
			if(checkExsits[5].equals("N")){ tdrSummaryVO.setWeight(tdrDistLoadVolVO.getWtDx()); }
			checkExsits[5] = "Y";
			
			voList.add(voList.size(), tdrSummaryVO);
		}	
	}
	
	/**
	 * Sheet의 Vo를 CUD가 가능한 Vo로 Convert
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
	 * Sheet의 Vo를 CUD가 가능한 Vo로 Convert
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
			
			//POD_ISO저장
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

			//POD_ISO저장
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
			
			//POD_ISO저장
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
			//tdrUtilizeVO.setCntrSize("2");	//I-Stowage에서 Size를 A로 잡고있슴........
			tdrUtilizeVO.setCntrSize("A");
			tdrUtilizeVO.setStatus(tdrUtilizeSlotPortVO.getStatus() + "M");
			tdrUtilizeVO.setQty(tdrUtilizeSlotPortVO.getTradeAb());
			
			//POD_ISO저장
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
			
			//POD_ISO저장
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
			
			//POD_ISO저장
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

			//POD_ISO저장
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
			//tdrUtilizeVO.setCntrSize("2");	//I-Stowage에서 Size를 A로 잡고있슴........
			tdrUtilizeVO.setCntrSize("A");
			tdrUtilizeVO.setStatus(tdrUtilizeSlotPortVO.getStatus() + "I");
			tdrUtilizeVO.setQty(tdrUtilizeSlotPortVO.getInterAb());
			
			//POD_ISO저장
			if( tdrUtilizeSlotPortVO.getStatus() != null && tdrUtilizeSlotPortVO.getStatus().equals("O") )
				tdrUtilizeVO.setPodIso(tdrHeaderVO.getPortCd());
			else
				tdrUtilizeVO.setPodIso("XXXXX");

			voList.add(voList.size(), tdrUtilizeVO);
		}		
/*
 * 	언제 복원 될지몰라서..
		if(!tdrUtilizeSlotPortVO.getTrade45().equals("") && !tdrUtilizeSlotPortVO.getTrade45().equals("0")){
			TdrUtilizeVO tdrUtilizeVO = setTdrUtilizeVO(tdrHeaderVO, tdrUtilizeSlotPortVO, account);
			
			tdrUtilizeVO.setPod("ALL");
			tdrUtilizeVO.setCntrType("A");
			tdrUtilizeVO.setCntrSize("3");
			tdrUtilizeVO.setStatus(tdrUtilizeSlotPortVO.getStatus() + "M");
			tdrUtilizeVO.setQty(tdrUtilizeSlotPortVO.getTrade45());
			
			//POD_ISO저장
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
			
			//POD_ISO저장
			if( tdrUtilizeSlotPortVO.getStatus() != null && tdrUtilizeSlotPortVO.getStatus().equals("O") )
				tdrUtilizeVO.setPodIso(tdrHeaderVO.getPortCd());
			else
				tdrUtilizeVO.setPodIso("XXXXX");

			voList.add(voList.size(), tdrUtilizeVO);
		}
*/				
	}
	
	/**
	 * Sheet의 Vo를 CUD가 가능한 Vo로 Convert
	 * Lane 
	 * @param 	TdrHeaderVO tdrHeaderVO
	 * @param 	TdrDistLoadVolVO tdrDistLoadVolVO
	 * @param 	SignOnUserAccount account
	 * @exception EventException
	 */
	private TdrSummaryVO setTdrSummaryVO(TdrHeaderVO tdrHeaderVO, TdrDistLoadVolVO tdrDistLoadVolVO, SignOnUserAccount account){
		TdrSummaryVO tdrSummaryVO = new TdrSummaryVO();
		
		tdrSummaryVO.setVslCd(tdrHeaderVO.getVslCd());
		tdrSummaryVO.setVoyNo(tdrHeaderVO.getVoyNo());
		tdrSummaryVO.setDirCd(tdrHeaderVO.getDirCd());
		tdrSummaryVO.setPortCd(tdrHeaderVO.getPortCd());
		tdrSummaryVO.setCallInd(tdrHeaderVO.getCallInd());
		tdrSummaryVO.setOprCd(tdrDistLoadVolVO.getOprCd());
		tdrSummaryVO.setPod(tdrDistLoadVolVO.getIdxSheet().equals("0") ? tdrHeaderVO.getPortCd() : tdrDistLoadVolVO.getPodCd());
		tdrSummaryVO.setUpdateUser(account.getUsr_id());
		
		return tdrSummaryVO;
	}
	
	/**
	 * Sheet의 Vo를 CUD가 가능한 Vo로 Convert
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
	 * Sheet의 Vo를 CUD가 가능한 Vo로 Convert
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
     * Sheet의 Vo를 CUD가 가능한 Vo로 Convert
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
	 * Sheet의 Vo를 CUD가 가능한 Vo로 Convert
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
	 * Sheet의 Vo를 CUD가 가능한 Vo로 Convert
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
		status[1] = "LS";
		status[2] = "ST";
		
		TdrSummaryVO tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, dischVolSGTdrVO, account);
		if(!dischVolSGTdrVO.getDg20Qty().equals("") && !dischVolSGTdrVO.getDg20Qty().equals("0")){
			tdrSummaryVO.setCntrType("D");
			tdrSummaryVO.setCntrSize("2");
			tdrSummaryVO.setStatus(status[idxSheet]);
			tdrSummaryVO.setQty(dischVolSGTdrVO.getDg20Qty());
			tdrSummaryVO.setWeight(dischVolSGTdrVO.getDg20Wgt());
			
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
			tdrSummaryVO.setWeight(dischVolSGTdrVO.getDg40Wgt());
			
			voList.add(tdrSummaryVO);
		}

		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, dischVolSGTdrVO, account);
		if(!dischVolSGTdrVO.getRf20Qty().equals("") && !dischVolSGTdrVO.getRf20Qty().equals("0")){
			tdrSummaryVO.setCntrType("R");
			tdrSummaryVO.setCntrSize("2");
			tdrSummaryVO.setStatus(status[idxSheet]);
			tdrSummaryVO.setQty(dischVolSGTdrVO.getRf20Qty());
			tdrSummaryVO.setWeight(dischVolSGTdrVO.getRf20Wgt());
			
			voList.add(tdrSummaryVO);
		}

		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, dischVolSGTdrVO, account);
		if(!dischVolSGTdrVO.getRf40Qty().equals("") && !dischVolSGTdrVO.getRf40Qty().equals("0")){
			tdrSummaryVO.setCntrType("R");
			tdrSummaryVO.setCntrSize("4");
			tdrSummaryVO.setStatus(status[idxSheet]);
			tdrSummaryVO.setQty(dischVolSGTdrVO.getRf40Qty());
			tdrSummaryVO.setWeight(dischVolSGTdrVO.getRf40Wgt());
			
			voList.add(tdrSummaryVO);
		}
		
		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, dischVolSGTdrVO, account);
		if(!dischVolSGTdrVO.getAk20Qty().equals("") && !dischVolSGTdrVO.getAk20Qty().equals("0")){
			tdrSummaryVO.setCntrType("A");
			tdrSummaryVO.setCntrSize("2");
			tdrSummaryVO.setStatus(idxSheet == 1 ? status[idxSheet + 1] : status[idxSheet]);
			tdrSummaryVO.setQty(dischVolSGTdrVO.getAk20Qty());
			tdrSummaryVO.setWeight(dischVolSGTdrVO.getAk20Wgt());
			
			voList.add(tdrSummaryVO);
		}

		tdrSummaryVO = setTdrSummaryVO(tdrHeaderVO, dischVolSGTdrVO, account);
		if(!dischVolSGTdrVO.getAk40Qty().equals("") && !dischVolSGTdrVO.getAk40Qty().equals("0")){
			tdrSummaryVO.setCntrType("A");
			tdrSummaryVO.setCntrSize("4");
			tdrSummaryVO.setStatus(idxSheet == 1 ? status[idxSheet + 1] : status[idxSheet]);
			tdrSummaryVO.setQty(dischVolSGTdrVO.getAk40Qty());
			tdrSummaryVO.setWeight(dischVolSGTdrVO.getAk40Wgt());
			
			voList.add(tdrSummaryVO);
		}
	}
	/**
	 * Sheet의 Vo를 CUD가 가능한 Vo로 Convert
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
	 * 멀티 이벤트 처리<br>
	 * In화면에 대한 멀티 이벤트 처리<br>
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
	 * [Cargo Handling Performance]을 [조회] 합니다.<br>
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
	 * [Port Code 유효성(체크)]을 [조회] 합니다.<br>
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
	 * [Cargo Re-Handling Performance]을 [조회] 합니다.<br>
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
	 * VOP_OPF_0064 : Retrieve <br>
	 * [VSL Condition Statistics]을 [조회] 합니다.<br>
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
	
	/**
	 * VOP_OPF_0063 : Retrieve <br>
	 * [Terminal Performance - Port]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<TmnlPerformInputVO>
	 * @exception EventException
	 */
	public List<TmnlPerformInputVO> searchTmnlPerformPortList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException {
		try {
			return dbDao.searchTmnlPerformPortList(terminalDepartureReportConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Performance - Port'"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Performance - Port'"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_OPF_0063 : Retrieve <br>
	 * [Terminal Performance - Lane]을 [조회] 합니다.<br>
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
	 * [Terminal Productivity Report]을 [조회] 합니다.<br>
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
	 * [Port Code 유효성(체크)]을 [조회] 합니다.<br>
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
	 * [TDR Details]을 [조회] 합니다.<br>
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
     * TDR Header 의 Total Container Handling Moves 수정한다. <br>
     *
     * @param  TdrHeaderVO[]      tdrHeaderVO
     * @param  TerminalDepartureReportCondVO terminalDepartureReportCondVO
     * @param  SignOnUserAccount account
     * @throws EventException
     * @author jang kang cheol
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
                        	 grossTml =  JSPUtil.round( Integer.parseInt(totMvs) / ( parseHHMM( tdrHeaderSkdVO.get(0).getGrossWork() )  / 60d), -1)   +"";
                         }
                    }
                    if ( !tdrHeaderSkdVO.get(0).getNetWork().equals("") ){
                        if( parseHHMM( tdrHeaderSkdVO.get(0).getNetWork() ) == 0 ) {
                        	netTml = totMvs;
                        }else{
                        	netTml =  JSPUtil.round( Integer.parseInt(totMvs) /    ( parseHHMM( tdrHeaderSkdVO.get(0).getNetWork() )  / 60d) , -1) +"";
                        }
                        
                    }
                    if ( !tdrHeaderSkdVO.get(0).getGrossGang().equals("") ){
                        if( parseHHMM( tdrHeaderSkdVO.get(0).getGrossGang() ) == 0 ) {
                        	grossGc = totMvs;
                        }else{
                        	grossGc =  JSPUtil.round( Integer.parseInt(totMvs) /  ( parseHHMM( tdrHeaderSkdVO.get(0).getGrossGang() )  / 60d),-1) +"";
                        }
                    }
                    if ( !tdrHeaderSkdVO.get(0).getNetGang().equals("") ){
                        if( parseHHMM( tdrHeaderSkdVO.get(0).getNetGang() ) == 0 ) {
                        	netGc = totMvs;
                        }else{
                        	netGc    =  JSPUtil.round( Integer.parseInt(totMvs) /  ( parseHHMM( tdrHeaderSkdVO.get(0).getNetGang() )  / 60d), -1) +"";
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
        if( strHH.equals("") ) { strHH = "0"; }
        if( strMM.equals("") ) { strMM = "0"; }
        
        sumMM  = Integer.parseInt( strHH  ) * 60;
        sumMM  = sumMM + Integer.parseInt(strMM);
        
        return sumMM;
    }
 
	/**
	 * VOP_OPF_0095 : Retrieve <br>
	 * Missing TDR List을 [조회] 합니다.<br>
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
	 * Port Code Validation Check하고 RHQ Office Code를 읽어온다..<br>
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
	 * Rehandling Account ( Carrier ) Code 의 유효성을 [조회] 합니다.<br>
	 * 
	 * @param TdrCntrDetailVO tdrCntrDetailVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> checkReHndlAcctCd(TdrCntrDetailVO tdrCntrDetailVO) throws EventException {
		try {
			return dbDao.checkReHndlAcctCd(tdrCntrDetailVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rehandling Account Check"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Rehandling Account Check"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR LOAD Inter Port]을 [조회] 합니다.<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrDistLoadVolVO>
	 * @exception EventException
	 */
	public List<TdrDistLoadVolVO> searchTdrLoadInterPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException{
		try {
			return dbDao.searchTdrLoadInterPortList(terminalDepartureReportCondVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Inter Port"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TDR Inter Port"}).getMessage(), ex);
		}
	}

	/**
	 * TDR R/H 의 File Attached 건을 조회합니다.<br>
	 * 
	 * @param OpfTdrAtchFileVO opfTdrAtchFileVO
	 * @return List<OpfTdrAtchFileVO>
	 * @exception EventException
	 */
	public List<OpfTdrAtchFileVO> searchOpfTdrAtchFileVO(OpfTdrAtchFileVO opfTdrAtchFileVO) throws EventException {
		try {
			return dbDao.searchOpfTdrAtchFileVO(opfTdrAtchFileVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * TDR R/H 의 File Attached 건을 생성, 수정 및 삭제합니다.<br>
	 * 
	 * @param OpfTdrAtchFileVO[] opfTdrAtchFileVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageOpfTdrAtchFileVO(OpfTdrAtchFileVO[] opfTdrAtchFileVO, SignOnUserAccount account) throws EventException{
		try {
			List<OpfTdrAtchFileVO> insertVoList = new ArrayList<OpfTdrAtchFileVO>();
			List<OpfTdrAtchFileVO> updateVoList = new ArrayList<OpfTdrAtchFileVO>();
			List<OpfTdrAtchFileVO> deleteVoList = new ArrayList<OpfTdrAtchFileVO>();
			for ( int i=0; i<opfTdrAtchFileVO .length; i++ ) {
				if ( opfTdrAtchFileVO[i].getIbflag().equals("I")){
					opfTdrAtchFileVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(opfTdrAtchFileVO[i]);
				} else if ( opfTdrAtchFileVO[i].getIbflag().equals("U")){
					opfTdrAtchFileVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(opfTdrAtchFileVO[i]);
				} else if ( opfTdrAtchFileVO[i].getIbflag().equals("D")){
					deleteVoList.add(opfTdrAtchFileVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanageOpfTdrAtchFileVOS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageOpfTdrAtchFileVOS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanageOpfTdrAtchFileVOS(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * VOP_OPF_0065 : Retrieve <br>
	 * Fleet Status을 조회 합니다.<br>
	 * 
	 * @param FleetStatusVO fleetStatusVO
	 * @return List<FleetStatusVO>
	 * @exception EventException
	 */
	public List<FleetStatusVO> searchFleetStatusList(FleetStatusVO fleetStatusVO) throws EventException {
		try {
			return dbDao.searchFleetStatusList(fleetStatusVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Fleet Status"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Fleet Status"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0071 : SEARCHLIST01 & SEARCHLIST02 & SEARCHLIST03<br>
	 * 콤보리스트를 조회한다.<br>
	 * 
	 * @param ComComboVO comComboVO
	 * @return List<ComComboVO>
	 * @throws EventException
	 */
	public List<ComComboVO> searchComComboList(ComComboVO comComboVO) throws EventException {
		try {
			return dbDao.searchComComboList(comComboVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Code List"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Code List"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0071 : SEARCHLIST04<br>
	 * 해당 Vessel의 Off-Hire Time List를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @return List<ComComboVO>
	 * @throws EventException
	 */
	public List<ComComboVO> searchOffHireTimeList(String vslCd) throws EventException {
		try {
			return dbDao.searchOffHireTimeList(vslCd);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Off-Hire Time List"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Off-Hire Time List"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0071 : SEARCH01<br>
	 * 유효한 Vessel Code 인지 체크한다.<br>
	 * 
	 * @param String vslCd
	 * @return String
	 * @throws EventException
	 */
	public String checkVessel(String vslCd) throws EventException {
		try {
			return dbDao.checkVessel(vslCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Code"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Code"}).getMessage(), ex);
		} 
	}
	
	/**
	 * VOP_OPF_0071 : SEARCH02<br>
	 * 유효한 Voyage No 인지 체크한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return String
	 * @throws EventException
	 */
	public String checkVskSkd(OpfVnorVO opfVnorVO) throws EventException {
		try {
			return dbDao.checkVskSkd(opfVnorVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Code"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Code"}).getMessage(), ex);
		} 
	}
	
	/**
	 * VOP_OPF_0071 : SEARCH05<br>
	 * 유효한 Office Code 인지 체크한다.<br>
	 * 
	 * @param ofcCd
	 * @return
	 * @throws EventException
	 */
	public String checkOfficeCode(String ofcCd) throws EventException {
		try {
			return dbDao.checkOfficeCode(ofcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Office Code"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Office Code"}).getMessage(), ex);
		} 
	}
	
	/**
	 * VOP_OPF_0071 : SEARCH<br>
	 * Vessel Not Operationally Ready Report 조회한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws EventException
	 */
	public OpfVnorVO searchVnor(OpfVnorVO opfVnorVO) throws EventException {
		try {
			return dbDao.searchVnor(opfVnorVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"VNOR Data"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"VNOR Data"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0071 : SEARCH<br>
	 * Vessel Not Operationally Ready Report Item 조회한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws EventException
	 */
	public List<OpfVnorItmVO> searchVnorItm(OpfVnorVO opfVnorVO) throws EventException {
		try {
			return dbDao.searchVnorItm(opfVnorVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"VNOR Item Data"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"VNOR Item Data"}).getMessage(), ex);
		}
	}
	
	/**
	 * Off-Hire Time Duplicaton 체크한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws EventException
	 */
	public String checkDupOffHireTime(OpfVnorVO opfVnorVO) throws EventException {
		try {
			String rtnStr = "";
			if ("N".equals(opfVnorVO.getCrChkFlg())) {
				rtnStr = dbDao.checkDupOffHireTime(opfVnorVO);
			} else {
				rtnStr = dbDao.checkDupOffHireTimeCr(opfVnorVO);
			}
			return rtnStr;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Off-Hire Time Duplication Data"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Off-Hire Time Duplication Data"}).getMessage(), ex);
		} 
	}
	
	/**
	 * VOP_OPF_0071 : COMMAND01 <br>
	 * Vessel Not Operationally Ready Report 수정한다.<br>
	 * 
	 * @param opfVnorVO
	 * @param opfVnorItmVOs
	 * @param account
	 * @throws EventException
	 */
	public void saveVnor(OpfVnorVO opfVnorVO, OpfVnorItmVO[] opfVnorItmVOs, SignOnUserAccount account) throws EventException {
		try {
			List<OpfVnorItmVO> insertVoList = new ArrayList<OpfVnorItmVO>();
			List<OpfVnorItmVO> updateVoList = new ArrayList<OpfVnorItmVO>();
			List<OpfVnorItmVO> deleteVoList = new ArrayList<OpfVnorItmVO>();
			String nextVnorSeq = "";
			
			// VNOR Main Info 셋팅
			if ("".equals(opfVnorVO.getVnorStupStsCd())) {
				nextVnorSeq = dbDao.searchNextVnorSeq(opfVnorVO.getVslCd());
				opfVnorVO.setVnorStupStsCd("SA");
				opfVnorVO.setVnorSeq(nextVnorSeq);
			}
			opfVnorVO.setCreUsrId(account.getUsr_id());
			
			// VNOR Item Info 셋팅
			if (opfVnorItmVOs != null) {
				for ( int i=0; i<opfVnorItmVOs.length; i++ ) {
					if ( opfVnorItmVOs[i].getIbflag().equals("I")){
						opfVnorItmVOs[i].setVslCd(opfVnorVO.getVslCd());
						opfVnorItmVOs[i].setVnorSeq(opfVnorVO.getVnorSeq());
						opfVnorItmVOs[i].setVnorItmStsCd("SA");
						opfVnorItmVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(opfVnorItmVOs[i]);
					} else if ( opfVnorItmVOs[i].getIbflag().equals("U")){
						opfVnorItmVOs[i].setVslCd(opfVnorVO.getVslCd());
						opfVnorItmVOs[i].setVnorSeq(opfVnorVO.getVnorSeq());
						opfVnorItmVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(opfVnorItmVOs[i]);
					} else if ( opfVnorItmVOs[i].getIbflag().equals("D")) {
						opfVnorItmVOs[i].setVslCd(opfVnorVO.getVslCd());
						opfVnorItmVOs[i].setVnorSeq(opfVnorVO.getVnorSeq());
						deleteVoList.add(opfVnorItmVOs[i]);
					}
				}
			}
			
			dbDao.mergeVnor(opfVnorVO);
			
			if ( insertVoList.size() > 0 ) {
				dbDao.insertVnorItem(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateVnorItem(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteVnorItem(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * VOP_OPF_0071 : COMMAND02 <br>
	 * Vessel Not Operationally Ready Report Submit한다.<br>
	 * 
	 * @param opfVnorVO
	 * @param opfVnorItmVOs
	 * @param account
	 * @throws EventException
	 */
	public void submitVnor(OpfVnorVO opfVnorVO, OpfVnorItmVO[] opfVnorItmVOs, SignOnUserAccount account) throws EventException {
		try {
			List<OpfVnorItmVO> updateVoList = new ArrayList<OpfVnorItmVO>();
			
			// VNOR Main Info Submit
			if ("SA".equals(opfVnorVO.getVnorStupStsCd())) {
				opfVnorVO.setVnorStupStsCd("SU");
				opfVnorVO.setCreUsrId(account.getUsr_id());
				dbDao.mergeVnor(opfVnorVO);
			}
			
			// VNOR Item Info Submit
			if (opfVnorItmVOs != null) {
				for ( int i=0; i<opfVnorItmVOs.length; i++ ) {
					opfVnorItmVOs[i].setVslCd(opfVnorVO.getVslCd());
					opfVnorItmVOs[i].setVnorSeq(opfVnorVO.getVnorSeq());
					opfVnorItmVOs[i].setVnorItmStsCd("SU");
					opfVnorItmVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(opfVnorItmVOs[i]);
				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.updateVnorItem(updateVoList);
				}
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * VOP_OPF_0071 : COMMAND03 <br>
	 * Vessel Not Operationally Ready Report 삭제한다.<br>
	 * 
	 * @param opfVnorVO
	 * @throws EventException
	 */
	public void deleteVnor(OpfVnorVO opfVnorVO) throws EventException {
		try {
			dbDao.deleteVnor(opfVnorVO);
			dbDao.deleteVnorItemAll(opfVnorVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * VOP_OPF_0072 : SEARCH<br>
	 * Item Attach File을 조회한다.<br>
	 * 
	 * @param opfAtchFileVO
	 * @return
	 * @throws EventException
	 */
	public List<OpfVnorAtchFileVO> searchItemAttachFile(OpfAtchFileVO opfAtchFileVO) throws EventException {
		try {
			return dbDao.searchItemAttachFile(opfAtchFileVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Item Attach File Data"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Item Attach File Data"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0072 : MULTI <br>
	 * VNOR 의 File Attached 건을 생성, 수정 및 삭제합니다.<br>
	 * 
	 * @param opfAtchFileVOs OpfAtchFileVO[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void manageOpfVnorAtchFile(OpfAtchFileVO[] opfAtchFileVOs, SignOnUserAccount account) throws EventException {
		try {
			List<OpfAtchFileVO> insertVoList = new ArrayList<OpfAtchFileVO>();
			List<OpfAtchFileVO> deleteVoList = new ArrayList<OpfAtchFileVO>();
			
			for ( int i=0; i<opfAtchFileVOs.length; i++ ) {
				if ( opfAtchFileVOs[i].getIbflag().equals("I")){
					opfAtchFileVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(opfAtchFileVOs[i]);
				} else if ( opfAtchFileVOs[i].getIbflag().equals("D")){
					deleteVoList.add(opfAtchFileVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanageOpfVnorAtchFile(insertVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanageOpfVnorAtchFile(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * VOP_OPF_0072 : MULTI <br>
	 * VNOR Item의 File Attached 정보를 갱신합니다.<br>
	 * 
	 * @param vslCd
	 * @param vnorSeq
	 * @param vnorItmSeq
	 * @param atchfileLnkId
	 * @throws EventException
	 */
	public void updateVnorItemAttachFile(String vslCd, String vnorSeq, String vnorItmSeq, String atchfileLnkId) throws EventException {
		try {
			dbDao.updateVnorItemAttachFile(vslCd, vnorSeq, vnorItmSeq, atchfileLnkId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Item Attach File Data"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Item Attach File Data"}).getMessage(), ex);
		}
	}
	
	/**
	 * VNOR Email Setup 정보를 조회한다.<br>
	 * 
	 * @return
	 * @throws EventException
	 */
	public List<OpfVnorEmlStupVO> searchVnorEmlStup() throws EventException {
		try {
			return dbDao.searchVnorEmlStup();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"VNOR Email Setup Data"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"VNOR Email Setup Data"}).getMessage(), ex);
		}
	}
	
	/**
	 * VNOR All Code 가져온다.<br>
	 * 
	 * @return
	 * @throws EventException
	 */
	public Map<String, String> getVnorAllCode() throws EventException {
		try {
			return dbDao.getVnorAllCode();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"VNOR All Code Data"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"VNOR All Code Data"}).getMessage(), ex);
		}
	}
	
	/**
	 * VNOR Email 전송한다.<br>
	 * 
	 * @param opfVnorVO
	 * @param opfVnorItmVOs
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String sendVnorEmail(OpfVnorVO opfVnorVO, OpfVnorItmVO[] opfVnorItmVOs, SignOnUserAccount account) throws EventException {
		String subject = null;
		StringBuilder sbHtmlContent = null;
		List<String> recipients = new ArrayList<String>();
		String emlSndNo = null;
		String nowDate = DateTime.getFormatDate(new Date(),"yyyy.MM.dd HH:mm");
		List<OpfVnorEmlStupVO> vnorEmlStupList = new ArrayList<OpfVnorEmlStupVO>();
		Map<String, String> vnorCodeMap = new HashMap<String, String>();
		boolean isSubItem = false;
		int subItemIndex = 0;
		String subItemUom = null;
		
	    try {
	    	// Set subject
	    	subject = "Vessel Not Operationally Ready Report (" + opfVnorVO.getVslCd() + " " + opfVnorVO.getSkdVoyNo() + ")";
	    	
	    	// Set contents
	    	vnorCodeMap = getVnorAllCode();
	    	
	    	if ("SA".equals(opfVnorVO.getVnorStupStsCd()) && opfVnorItmVOs.length == 1) {
	    		isSubItem = false;
	    	} else if ("SA".equals(opfVnorVO.getVnorStupStsCd()) && opfVnorItmVOs.length > 1) {
	    		isSubItem = true;
	    		subItemIndex = 1;
	    	} else if ("SU".equals(opfVnorVO.getVnorStupStsCd())) {
	    		isSubItem = true;
	    		subItemIndex = 0;
	    	}
	    	
	    	 sbHtmlContent = new StringBuilder();
	    	 sbHtmlContent.append("<html>");
	    	 sbHtmlContent.append("<head>");
	    	 sbHtmlContent.append("<title></title>");
	    	 sbHtmlContent.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=euc-kr\">");
	    	 sbHtmlContent.append("<link rel=\"stylesheet\" href=\"include/style.css\" type=\"text/css\">");
	    	 sbHtmlContent.append("</head>");
	    	 sbHtmlContent.append("<body>");
	    	 sbHtmlContent.append("<table border=\"0\" width=\"100%\">");
	    	 sbHtmlContent.append("	<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">Below VNOR submitted by " + account.getUsr_nm() + " on " + nowDate + "</td></tr>");
	    	 sbHtmlContent.append("</table>");
	    	 sbHtmlContent.append("<br><br>");
	    	 sbHtmlContent.append("<table border=\"0\" width=\"600\">");
	    	 sbHtmlContent.append("	<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\" colspan=\"4\">Vessel Not Operationally Ready Report</td></tr>");
	    	 sbHtmlContent.append("	<tr><td><br><br></td></tr>");
	    	 sbHtmlContent.append("	<tr>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:80; font-weight:bold;\">Vessel :</td>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:150\">" + opfVnorVO.getVslCd() + "</td>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:80; font-weight:bold;\">Voy No. :</td>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:250\">" + opfVnorVO.getSkdVoyNo() + "</td>");
	    	 sbHtmlContent.append("	</tr>");
	    	 sbHtmlContent.append("	<tr><td><br></td></tr>");
	    	 sbHtmlContent.append("	<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\" colspan=\"4\">Off-Hire Time<br></td></tr>");
	    	 sbHtmlContent.append("	<tr>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:80; font-weight:bold;\">From :</td>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:150\">" + opfVnorVO.getVnorOffhFmDt() + "</td>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:80; font-weight:bold;\">To :</td>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:250\">" + opfVnorVO.getVnorOffhToDt() + "</td>");
	    	 sbHtmlContent.append("	</tr>");
	    	 sbHtmlContent.append("	<tr><td><br></td></tr>");
	    	 sbHtmlContent.append("	<tr>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:80; font-weight:bold;\">Place :</td>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:150\">" + vnorCodeMap.get(opfVnorVO.getVnorVslStsCd()) + "</td>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:80\">" + opfVnorVO.getVnorFmPortCd() + "</td>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:250\">" + opfVnorVO.getVnorToPortCd() + "</td>");
	    	 sbHtmlContent.append("	</tr>");
	    	 sbHtmlContent.append("	<tr><td><br></td></tr>");
	    	 sbHtmlContent.append("	<tr>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:80; font-weight:bold;\">Kind :</td>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:150\">" + vnorCodeMap.get(opfVnorVO.getVnorOffhKndCd()) + "</td>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:80; font-weight:bold;\">Type :</td>");
	    	 sbHtmlContent.append("		<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; width:250\">" +  vnorCodeMap.get(opfVnorVO.getVnorOffhTpCd()) + "</td>");
	    	 sbHtmlContent.append("	</tr>");
	    	 sbHtmlContent.append("</table>");
	    	 sbHtmlContent.append("<br><br>");
	    	 
	    	 if ("SA".equals(opfVnorVO.getVnorStupStsCd())) {
		    	 sbHtmlContent.append("<table  border=\"1\" bordercolor=\"#313131\" cellspacing=\"0\" width=\"1000\" style=\"table-layout:fixed\">");
		    	 sbHtmlContent.append("	<tr bgcolor=\"#08abba\">");
		    	 sbHtmlContent.append("		<td align=\"center\" width=\"150\">Item</td>");
		    	 sbHtmlContent.append("		<td align=\"center\" width=\"80\">UOM</td>");
		    	 sbHtmlContent.append("		<td align=\"center\" width=\"100\">Value</td>");
		    	 sbHtmlContent.append("		<td align=\"center\">Remark</td>");
		    	 sbHtmlContent.append("	</tr>");
		    	 sbHtmlContent.append("	<tr>");
		    	 sbHtmlContent.append("		<td align=\"center\">" + vnorCodeMap.get(opfVnorItmVOs[0].getVnorItmCd()) + "</td>");
		    	 sbHtmlContent.append("		<td align=\"center\">Hour</td>");
		    	 sbHtmlContent.append("		<td align=\"center\">" + opfVnorItmVOs[0].getVnorItmVal() + "</td>");
		    	 sbHtmlContent.append("		<td align=\"left\" height=\"auto\" style=\"word-break:break-all;\">" + opfVnorItmVOs[0].getVnorItmRmk() + "&nbsp;</td>");
		    	 sbHtmlContent.append("	</tr>");
		    	 sbHtmlContent.append("</table>");
		    	 sbHtmlContent.append("<br>");
	    	 }
	    	 
	    	 if (isSubItem) {
		    	 sbHtmlContent.append("<table  border=\"1\" bordercolor=\"#313131\" cellspacing=\"0\" width=\"1000\" style=\"table-layout:fixed\">");
		    	 sbHtmlContent.append("	<tr bgcolor=\"#08abba\">");
		    	 sbHtmlContent.append("		<td align=\"center\" width=\"150\">Item</td>");
		    	 sbHtmlContent.append("		<td align=\"center\" width=\"80\">Office</td>");
		    	 sbHtmlContent.append("		<td align=\"center\" width=\"80\">UOM</td>");
		    	 sbHtmlContent.append("		<td align=\"center\" width=\"100\">Value</td>");
		    	 sbHtmlContent.append("		<td align=\"center\">Remark</td>");
		    	 sbHtmlContent.append("	</tr>");
		    	 
		    	 while (subItemIndex < opfVnorItmVOs.length) {
		    		 if ("D".equals(opfVnorItmVOs[subItemIndex].getVnorItmUtCd())) {
		    			 subItemUom = "$";
		    		 } else if ("T".equals(opfVnorItmVOs[subItemIndex].getVnorItmUtCd())) {
		    			 subItemUom = "MT";
		    		 }
			    	 sbHtmlContent.append("	<tr>");
			    	 sbHtmlContent.append("		<td align=\"center\">" + vnorCodeMap.get(opfVnorItmVOs[subItemIndex].getVnorItmCd()) + "</td>");
			    	 sbHtmlContent.append("		<td align=\"center\">" + opfVnorItmVOs[subItemIndex].getVnorItmOfcCd() + "&nbsp;</td>");
			    	 sbHtmlContent.append("		<td align=\"center\">" + subItemUom + "</td>");
			    	 sbHtmlContent.append("		<td align=\"center\">" + opfVnorItmVOs[subItemIndex].getVnorItmVal() + "</td>");
			    	 sbHtmlContent.append("		<td align=\"left\" height=\"auto\" style=\"word-break:break-all;\">" + opfVnorItmVOs[subItemIndex].getVnorItmRmk() + "&nbsp;</td>");
			    	 sbHtmlContent.append("	</tr>");
			    	 subItemIndex++;
		    	 }
		    	 
		    	 sbHtmlContent.append("</table>");
	    	 }

	    	 sbHtmlContent.append("<br><br>");
	    	 sbHtmlContent.append("<table class=\"search\" border=\"0\" width=\"100%\">");
	    	 sbHtmlContent.append("	<tr>");
	    	 sbHtmlContent.append("	<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px; font-weight:bold;\">RDGS.</td>");
	    	 sbHtmlContent.append("	</tr>");
	    	 sbHtmlContent.append("</table>");
	    	 sbHtmlContent.append("</body>");
	    	 sbHtmlContent.append("</html>");
	    	
	    	 // Set recipients
	    	 vnorEmlStupList = searchVnorEmlStup();
			for (int i = 0; i < vnorEmlStupList.size(); i++) {
				recipients.add(vnorEmlStupList.get(i).getUsrEml());
			}
	    	
	    	// Send Mail
			if (recipients.size() > 0) {
		    	Mail mail = new Mail();
				mail.setGroupwareMail();
				mail.setRdSubSysCd("OPF");
				mail.setBatFlg("N");
				mail.setFrom(account.getUsr_eml(), account.getUsr_nm());
				mail.setSubject(subject);
				mail.setRecipients(recipients);
				mail.setHtmlContent(sbHtmlContent.toString());
				emlSndNo = mail.send();
			}

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12229").getMessage(), ex);
		}
		return emlSndNo;
	}
	
	/**
	 * VOP_OPF_0074 : MULTI <br>
	 * VNOR Email Setup 생성 및 삭제합니다.<br>
	 * 
	 * @param opfVnorEmlStupVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageVnorEmlStup(OpfVnorEmlStupVO[] opfVnorEmlStupVOs, SignOnUserAccount account) throws EventException {
		try {
			List<OpfVnorEmlStupVO> insertVoList = new ArrayList<OpfVnorEmlStupVO>();
			List<OpfVnorEmlStupVO> deleteVoList = new ArrayList<OpfVnorEmlStupVO>();
			
			for ( int i=0; i<opfVnorEmlStupVOs.length; i++ ) {
				if ( opfVnorEmlStupVOs[i].getIbflag().equals("I")){
					opfVnorEmlStupVOs[i].setCreUsrId(account.getUsr_id());
					opfVnorEmlStupVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(opfVnorEmlStupVOs[i]);
				} else if ( opfVnorEmlStupVOs[i].getIbflag().equals("D")){
					deleteVoList.add(opfVnorEmlStupVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addVnorEmlStup(insertVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeVnorEmlStup(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 사선/용선 구분 코드를 가져온다.
	 * 
	 * @param vslCd
	 * @return
	 * @throws EventException
	 */
	public String getVslOwnIndCd(String vslCd) throws EventException {
		try {
			return dbDao.getVslOwnIndCd(vslCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"VESSEL OWNED INDICATOR CODE"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"VESSEL OWNED INDICATOR CODE"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0071 : SEARCHLIST07<br>
	 * 해당 Vessel / Voy No 의 SKD Port List를 조회한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws EventException
	 */
	public List<ComComboVO> searchSkdPortList(OpfVnorVO opfVnorVO) throws EventException {
		try {
			return dbDao.searchSkdPortList(opfVnorVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Off-Hire Time List"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Off-Hire Time List"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0071 : SEARCHLIST08<br>
	 * 해당 Port의 Office Code List를 조회한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws EventException
	 */
	public List<ComComboVO> searchPortOfcCdList(OpfVnorVO opfVnorVO) throws EventException {
		try {
			return dbDao.searchPortOfcCdList(opfVnorVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Off-Hire Time List"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Off-Hire Time List"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_OPF_0073 : SEARCH <br>
	 * VNOR Summary Inquiry 조회합니다.<br>
	 * 
	 * @param opfVnorSummaryVO
	 * @return
	 * @throws EventException
	 */
	public List<OpfVnorSummaryVO> searchVnorSummary(OpfVnorSummaryVO opfVnorSummaryVO) throws EventException {
		try {
			List<OpfVnorSummaryVO> resultList =  dbDao.searchVnorSummary(opfVnorSummaryVO);
			
			// Other Loss Item Remark 셋팅
			for (int i = 0; i < resultList.size(); i++) {
				OpfVnorSummaryVO resultVO = resultList.get(i);
				List<String> otItmRmkList = dbDao.searchOtItmRmk(resultVO);
				StringBuffer otItmRmkSb = new StringBuffer();
				
				for (int j = 0; j < otItmRmkList.size(); j++) {
					if (otItmRmkList.get(j) != null && !"".equals(otItmRmkList.get(j))) {
						if (otItmRmkSb.length() == 0) {
							otItmRmkSb.append(otItmRmkList.get(j));
						} else {
							otItmRmkSb.append("\n" + otItmRmkList.get(j));
						}
					}
				}
				resultVO.setOtItmRmk(otItmRmkSb.toString());
			}
			
			return resultList;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"VNOR Summary"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"VNOR Summary"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_OPF_0036 : Save <br>
	 * TERMINAL DEPARTURE REPORT HEADER의 AvgGang를 수정 합니다. <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTdrSAvgGang(TdrHeaderVO[] tdrHeaderVO, SignOnUserAccount account) throws EventException{
		
		try {
			List<TdrHeaderVO> updateVoList = new ArrayList<TdrHeaderVO>();
			for ( int i=0; i< tdrHeaderVO.length; i++ ) {
				tdrHeaderVO[i].setUpdateUser(account.getUsr_id());
				updateVoList.add(tdrHeaderVO[i]); 
			}
		
			dbDao.modifyTdrSAvgGang(updateVoList);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report HEADER"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report HEADER"}).getMessage(), ex);
        }
	}	
}