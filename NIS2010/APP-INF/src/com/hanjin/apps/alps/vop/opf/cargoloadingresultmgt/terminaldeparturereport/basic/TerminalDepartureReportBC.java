/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalDepartureReportBC.java
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

import java.util.List;
import java.util.Map;

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
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrDistLoadVolVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrHeaderSkdVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrSlotHC45VO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrUtilizeSlotPortVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportConditionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformInputVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.VskVslPortSkdSheetVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.ComComboVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmYardVO;
import com.hanjin.syscommon.common.table.OpfAtchFileVO;
import com.hanjin.syscommon.common.table.OpfRstwgRsnCdVO;
import com.hanjin.syscommon.common.table.OpfVnorEmlStupVO;
import com.hanjin.syscommon.common.table.OpfVnorItmVO;
import com.hanjin.syscommon.common.table.OpfVnorVO;
import com.hanjin.syscommon.common.table.TdrAllocationVO;
import com.hanjin.syscommon.common.table.TdrCntrDetailVO;
import com.hanjin.syscommon.common.table.TdrHeaderVO;

/**
 * NIS2010-Cargoloadingresultmgt Business Logic Command Interface<br>
 * - NIS2010-Cargoloadingresultmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Suk Hyun
 * @see Vop_opf_0036EventResponse 참조
 * @since J2EE 1.6
 */

public interface TerminalDepartureReportBC {
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR VESSAL SCHEDULE]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<VskVslPortSkdSheetVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdSheetVO> searchTdrSKDList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR HEADER]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrHeaderVO>
	 * @exception EventException
	 */
	public List<TdrHeaderSkdVO> searchTdrHeaderList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR PORT LOG HEADER]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<PortLogHeadVO>
	 * @exception EventException
	 */
	public List<PortLogHeadVO> searchTdrPortLogHeadList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR PORT LOG DETAIL]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<PortLogDetailVO>
	 * @exception EventException
	 */
	public List<PortLogDetailVO> searchTdrPortLogDetailList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR DISCHARGE TOTAL VOLUME IMPORT]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrDistLoadVolVO>
	 * @exception EventException 
	 */
	public List<TdrDistLoadVolVO> searchBkgVolumeDischTotal(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR TOTAL VOLUME]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrDistLoadVolVO>
	 * @exception EventException
	 */
	public List<TdrDistLoadVolVO> searchTdrDischargeTotalList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR DISCHARGE SCG IMPORT]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<DischVolSGTdrVO>
	 * @exception EventException
	 */
	public List<DischVolSGTdrVO> searchBkgVolumeDischSG(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR DISCHARGE SCG]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<DischVolSGTdrVO>
	 * @exception EventException
	 */
	public List<DischVolSGTdrVO> searchTdrDischargeSGList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR DISCHARGE SCG SUMMARY]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<DischVolSGTdrVO>
	 * @exception EventException
	 */
	public List<DischVolSGTdrVO> searchTdrLoadSGList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR DISCHARGE BREAK BULK IMPORT]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchBkgVolumeDischBreak(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR DISCHARGE BREAK BULK]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchTdrDischargeBreakList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR LOAD OCEAN]을 [조회] 합니다.<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<LoadVolOceanTdrVO>
	 * @exception EventException
	 */
	public List<TdrDistLoadVolVO> searchTdrLoadOceanPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR LOAD OCEAN IMPORT]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrDistLoadVolVO> searchBkgVolumeLoadTotal(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR LOAD SCG IMPORT]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<DischVolSGTdrVO>
	 * @exception EventException
	 */
	public List<DischVolSGTdrVO> searchBkgVolumeLoadSG(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR LOAD BREAK BULK IMPORT]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchBkgVolumeLoadBreak(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

    /**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR COD]을 [조회] 합니다.<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<LoadVolOceanTdrVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchTdrCodList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR REHANDLE]을 [조회] 합니다.<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<RHContainerVO>
	 * @exception EventException
	 */
	public List<RHContainerVO> searchTdrRHList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR MISHANDLE]을 [조회] 합니다.<br>
	 * 
	 * @param  TerminalDepartureReportConditionVO terminalDepartureReportCondVO  
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchTdrMisHandleList(TerminalDepartureReportConditionVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR SLOT BSA]을 [조회] 합니다.<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrAllocationBSAVO>
	 * @exception EventException
	 */
	public List<TdrAllocationBSAVO> searchTdrSlotBSAList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR SLOT BSA IMPORT]을 [조회] 합니다.<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrAllocationBSAVO>
	 * @exception EventException
	 */
	public List<TdrAllocationBSAVO> searchTdrSlotBSAImportList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR SLOT HC45]을 [조회] 합니다.<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrSlotHC45VO>
	 * @exception EventException
	 */
	public List<TdrSlotHC45VO> searchTdrSlotHC45List(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR SLOT HC45 IMPORT]을 [조회] 합니다.<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrSlotHC45VO>
	 * @exception EventException
	 */
	public List<TdrSlotHC45VO> searchTdrSlotHC45ImportList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR SLOT HC45 IMPORT]을 [조회] 합니다.<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrUtilizeSlotPortVO>
	 * @exception EventException
	 */
	public List<TdrUtilizeSlotPortVO> searchTdrSlotDepList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR SLOT PORT]을 [조회] 합니다.<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrUtilizeSlotPortVO>
	 * @exception EventException
	 */
	public List<TdrUtilizeSlotPortVO> searchTdrSlotPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR SLOT PORT IMPORT]을 [조회] 합니다.<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrUtilizeSlotPortVO>
	 * @exception EventException
	 */
	public List<TdrUtilizeSlotPortVO> searchTdrSlotPortImpList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR SLOT DEP IMPORT]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrAllocationBSAVO>
	 * @throws DAOException
	 */
	public List<TdrUtilizeSlotPortVO> searchTdrSlotDepImportList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR TEMP STWG]을 [조회] 합니다.<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchTdrTmpStwgList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR REHANDLE REASON]을 [조회] 합니다.<br>
	 * 
	 * @param opfRstwgRsnCdVO OpfRstwgRsnCdVO 
	 * @return List<OpfRstwgRsnCdVO>
	 * @exception EventException
	 */
	public List<OpfRstwgRsnCdVO> searchTdrRHReasonCdList(OpfRstwgRsnCdVO opfRstwgRsnCdVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR REHANDLE REASON]을 [조회] 합니다.<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<OpfTmlProdRptRsnCdVO>
	 * @exception EventException
	 */
	public List<OpfTmlProdRptRsnCdVO> searchExcludeTpr(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * [TERMINAL DEPARTURE REPORT HEADER]를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdr(TdrHeaderVO[] tdrHeaderVO, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_OPF_0036 : Save <br>
	 * [TERMINAL DEPARTURE REPORT CRANE]를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param portLogDetailVO PortLogDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrCrane(TdrHeaderVO[] tdrHeaderVO, PortLogDetailVO[] portLogDetailVO, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_OPF_0036 : Save <br>
	 * [TERMINAL DEPARTURE REPORT SUMMARY TOTAL]를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param DischVolTotalVO PortLogDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrDischTotal(TdrHeaderVO[] tdrHeaderVO, TdrDistLoadVolVO[] dischVolTotalVO, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_OPF_0036 : Save <br>
	 * [TERMINAL DEPARTURE REPORT SUMMARY SCG]를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param TdrHeaderVO[] tdrHeaderVO
	 * @param DischVolSGTdrVO[] dischVolSGTdrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTdrDischSG(TdrHeaderVO[] tdrHeaderVO, DischVolSGTdrVO[] dischVolSGTdrVO, SignOnUserAccount account) throws EventException;
	
    /**
     * VOP_OPF_0036 : Save <br>
     * [TERMINAL DEPARTURE REPORT SUMMARY SCG]를 생성, 수정, 삭제 합니다. <br>
     * 
     * @param TdrHeaderVO[] tdrHeaderVO
     * @param DischVolSGTdrVO[] dischVolSGTdrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTdrLoadSG(TdrHeaderVO[] tdrHeaderVO, DischVolSGTdrVO[] dischVolSGTdrVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * VOP_OPF_0036 : Save <br>
	 * [TERMINAL DEPARTURE REPORT SUMMARY BREAK BULK]를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param TdrHeaderVO[] tdrHeaderVO
	 * @param TdrCntrDetailVO[] tdrCntrDetailVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTdrDischBreak(TdrHeaderVO[] tdrHeaderVO, TdrCntrDetailVO[] tdrCntrDetailVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * [TERMINAL DEPARTURE REPORT CNTR DETAIL COD]를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param tdrCntrDetailVO TdrCntrDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrCod(TdrHeaderVO[] tdrHeaderVO, TdrCntrDetailVO[] tdrCntrDetailVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * [TERMINAL DEPARTURE REPORT CNTR DETAIL REHANDLE]를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param tdrCntrDetailVO TdrCntrDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrRH(TdrHeaderVO[] tdrHeaderVO, TdrCntrDetailVO[] tdrCntrDetailVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * [TERMINAL DEPARTURE REPORT CNTR DETAIL MISHANDLE]를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param tdrCntrDetailVO TdrCntrDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrMishandle(TdrHeaderVO[] tdrHeaderVO, TdrCntrDetailVO[] tdrCntrDetailVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * [TERMINAL DEPARTURE REPORT ALLOCATION]를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param tdrAllocationVO TdrAllocationVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrSlotBSA(TdrHeaderVO[] tdrHeaderVO, TdrAllocationVO[] tdrAllocationVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * [TERMINAL DEPARTURE REPORT BSA]를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param TdrHeaderVO[] tdrHeaderVO
	 * @param TdrSlotHC45VO[] tdrSlotHC45VO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTdrSlotHC45(TdrHeaderVO[] tdrHeaderVO, TdrSlotHC45VO[] tdrSlotHC45VO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * [TERMINAL DEPARTURE REPORT UTILIZE]를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param TdrHeaderVO[] tdrHeaderVO
	 * @param TdrUtilizeSlotPortVO[] tdrUtilizeSlotPortVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTdrSlotPort(TdrHeaderVO[] tdrHeaderVO, TdrUtilizeSlotPortVO[] tdrUtilizeSlotPortVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * [TERMINAL DEPARTURE REPORT CNTR DETAIL TEMPSTWG]를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param tdrCntrDetailVO TdrCntrDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrTmpStwg(TdrHeaderVO[] tdrHeaderVO, TdrCntrDetailVO[] tdrCntrDetailVO, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_OPF_0038 : Save <br>
	 * [OPF TERMINAL DEPARTURE REPORT DETAIL]를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageExcludeTpr(OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  Cargo Handling Performance 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO	terminalDepartureReportConditionVO
	 * @return List<CgoHndPerformInputVO>
	 * @exception EventException
	 */
	public List<CgoHndPerformInputVO> searchCgoHndPerformList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;
	
	/**
	 * 조회조건에 Port Code 유효성(체크) 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO   terminalDepartureReportConditionVO
	 * @return List<MdmYardVO>
	 * @exception EventException
	 */
	public List<MdmYardVO> searchMdmYardCombo(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;

	/**
	 *  Cargo Re-Handling Performance 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO	terminalDepartureReportConditionVO
	 * @return List<CgoRhndPerformInputVO>
	 * @exception EventException
	 */
	public List<CgoRhndPerformInputVO> searchCgoRhndPerformList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;

	/**
	 *  VSL Condition Statistics 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO	terminalDepartureReportConditionVO
	 * @return List<TdrListOptionVO>
	 * @exception EventException
	 */
	public List<TdrListOptionVO> searchVslConditionList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;

	/**
	 *  Terminal Performance - Port 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO	terminalDepartureReportConditionVO
	 * @return List<TmnlPerformInputVO>
	 * @exception EventException
	 */
	public List<TmnlPerformInputVO> searchTmnlPerformPortList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;

	/**
	 *  Terminal Performance - Lane 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO	terminalDepartureReportConditionVO
	 * @return List<TmnlPerformInputVO>
	 * @exception EventException
	 */
	public List<TmnlPerformInputVO> searchTmnlPerformLaneList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;	

	/**
	 *  Terminal Productivity Report 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO	terminalDepartureReportConditionVO
	 * @return List<TmnlPerformVO>
	 * @exception EventException
	 */
	public List<TmnlPerformVO> searchTmnlProdList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;	

	/**
	 * 조회조건에 Port Code 유효성(체크) 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO   terminalDepartureReportConditionVO
	 * @return List<MdmRhqComboVO>
	 * @exception EventException
	 */
	public List<MdmRhqComboVO> searchMdmRhqCombo(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;
	
	/**
	 *  TDR Details 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO	terminalDepartureReportConditionVO
	 * @return List<TerminalDepartureReportVO>
	 * @exception EventException
	 */
	public List<TerminalDepartureReportVO> searchTdrDetailList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;	
	
    /**
     * VOP_OPF_0036 : Save <br>
     * [TERMINAL DEPARTURE REPORT SUMMARY TOTAL] 등록시 Header Mvs 재계산. <br>
     * 
     * @param TdrHeaderVO[] tdrHeaderVO 
     * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyTdrHeaderMvs(TdrHeaderVO[] tdrHeaderVO, TerminalDepartureReportCondVO terminalDepartureReportCondVO, SignOnUserAccount account) throws EventException;
 
    /**
     * VOP_OPF_0036 : Save <br>
     * [TERMINAL DEPARTURE REPORT SUMMARY LOAD- OCEAN]를 생성, 수정, 삭제 합니다. <br>
     * 
     * @param tdrHeaderVO TdrHeaderVO[]
     * @param DischVolTotalVO PortLogDetailVO[]
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void manageTdrLoad(TdrHeaderVO[] tdrHeaderVO, TdrDistLoadVolVO[] dischVolTotalVO, SignOnUserAccount account) throws EventException;

    
	/**
	 * VOP_OPF_0095 : Retrieve <br>
	 * Missing TDR List을 [조회] 합니다.<br>
	 * 
	 * @param MissingTDRCondVO missingTDRCondVO
	 * @return List<MissingTDRVO>
	 * @exception EventException
	 */
	public List<MissingTDRVO> searchMissingTDRList(MissingTDRCondVO missingTDRCondVO) throws EventException;

	/**
	 * VOP_OPF_0095 : Port Code OnChange <br>
	 * Port Code Validation Check하고 RHQ Office Code를 읽어온다..<br>
	 * 
	 * @param MissingTDRCondVO missingTDRCondVO
	 * @return List<MissingTDRVO>
	 * @exception EventException
	 */
	public List<MissingTDRVO> searchPortCodeNRhqOfcCdList(MissingTDRCondVO missingTDRCondVO) throws EventException;

	/**
	 * Rehandling Account ( Carrier ) Code 의 유효성을 [조회] 합니다.<br>
	 * 
	 * @param TdrCntrDetailVO tdrCntrDetailVO
	 * @return List<OpfComboVO>
	 * @exception EventException
	 */
	public List<OpfComboVO> checkReHndlAcctCd(TdrCntrDetailVO tdrCntrDetailVO) throws EventException ;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR LOAD INTER PORT]을 [조회] 합니다.<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrDistLoadVolVO>
	 * @exception EventException
	 */
	public List<TdrDistLoadVolVO> searchTdrLoadInterPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * TDR R/H 의 File Attached 건을 조회합니다.<br>
	 * 
	 * @param OpfTdrAtchFileVO	opfTdrAtchFileVO
	 * @return List<OpfTdrAtchFileVO>
	 * @exception EventException
	 */
	public List<OpfTdrAtchFileVO> searchOpfTdrAtchFileVO(OpfTdrAtchFileVO opfTdrAtchFileVO) throws EventException;
	
	/**
	 * TDR R/H 의 File Attached 건을 생성, 수정 및 삭제합니다.<br>
	 * 
	 * @param OpfTdrAtchFileVO[] opfTdrAtchFileVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageOpfTdrAtchFileVO(OpfTdrAtchFileVO[] opfTdrAtchFileVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0065 : Retrieve <br>
	 * Fleet Status을 조회 합니다.<br>
	 * 
	 * @param FleetStatusVO fleetStatusVO
	 * @return List<FleetStatusVO>
	 * @exception EventException
	 */
	public List<FleetStatusVO> searchFleetStatusList(FleetStatusVO fleetStatusVO) throws EventException;
	
	/**
	 * VOP_OPF_0071 : SEARCHLIST01 & SEARCHLIST02 & SEARCHLIST03<br>
	 * 콤보리스트를 조회한다.<br>
	 * 
	 * @param ComComboVO comComboVO
	 * @return List<ComComboVO>
	 * @throws EventException
	 */
	public List<ComComboVO> searchComComboList(ComComboVO comComboVO) throws EventException;
	
	/**
	 * VOP_OPF_0071 : SEARCHLIST04<br>
	 * 해당 Vessel의 Off-Hire Time List를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @return List<ComComboVO>
	 * @throws EventException
	 */
	public List<ComComboVO> searchOffHireTimeList(String vslCd) throws EventException;
	
	/**
	 * VOP_OPF_0071 : SEARCH01<br>
	 * 유효한 Vessel Code 인지 체크한다.<br>
	 * 
	 * @param String vslCd
	 * @return String
	 * @throws EventException
	 */
	public String checkVessel(String vslCd) throws EventException;
	
	/**
	 * VOP_OPF_0071 : SEARCH02<br>
	 * 유효한 Voyage No 인지 체크한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return String
	 * @throws EventException
	 */
	public String checkVskSkd(OpfVnorVO opfVnorVO) throws EventException;
	
	/**
	 * VOP_OPF_0071 : SEARCH05<br>
	 * 유효한 Office Code 인지 체크한다.<br>
	 * 
	 * @param ofcCd
	 * @return
	 * @throws EventException
	 */
	public String checkOfficeCode(String ofcCd) throws EventException;
	
	/**
	 * VOP_OPF_0071 : SEARCH<br>
	 * Vessel Not Operationally Ready Report 조회한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws EventException
	 */
	public OpfVnorVO searchVnor(OpfVnorVO opfVnorVO) throws EventException;
	
	/**
	 * VOP_OPF_0071 : SEARCH<br>
	 * Vessel Not Operationally Ready Report Item 조회한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws EventException
	 */
	public List<OpfVnorItmVO> searchVnorItm(OpfVnorVO opfVnorVO) throws EventException;
	
	/**
	 * Off-Hire Time Duplicaton 체크한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws EventException
	 */
	public String checkDupOffHireTime(OpfVnorVO opfVnorVO) throws EventException;
	
	/**
	 * VOP_OPF_0071 : COMMAND01 <br>
	 * Vessel Not Operationally Ready Report 수정한다.<br>
	 * 
	 * @param opfVnorVO
	 * @param opfVnorItmVOs
	 * @param account
	 * @throws EventException
	 */
	public void saveVnor(OpfVnorVO opfVnorVO, OpfVnorItmVO[] opfVnorItmVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0071 : COMMAND02 <br>
	 * Vessel Not Operationally Ready Report Submit한다.<br>
	 * 
	 * @param opfVnorVO
	 * @param opfVnorItmVOs
	 * @param account
	 * @throws EventException
	 */
	public void submitVnor(OpfVnorVO opfVnorVO, OpfVnorItmVO[] opfVnorItmVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0071 : COMMAND03 <br>
	 * Vessel Not Operationally Ready Report 삭제한다.<br>
	 * 
	 * @param opfVnorVO
	 * @throws EventException
	 */
	public void deleteVnor(OpfVnorVO opfVnorVO) throws EventException;
	
	/**
	 * VOP_OPF_0072 : SEARCH<br>
	 * Item Attach File을 조회한다.<br>
	 * 
	 * @param opfAtchFileVO
	 * @return
	 * @throws EventException
	 */
	public List<OpfVnorAtchFileVO> searchItemAttachFile(OpfAtchFileVO opfAtchFileVO) throws EventException;
	
	/**
	 * VOP_OPF_0072 : MULTI <br>
	 * VNOR 의 File Attached 건을 생성, 수정 및 삭제합니다.<br>
	 * 
	 * @param opfAtchFileVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageOpfVnorAtchFile(OpfAtchFileVO[] opfAtchFileVOs, SignOnUserAccount account) throws EventException;
	
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
	public void updateVnorItemAttachFile(String vslCd, String vnorSeq, String vnorItmSeq, String atchfileLnkId) throws EventException;
	
	/**
	 * VNOR Email Setup 정보를 조회한다.<br>
	 * 
	 * @return
	 * @throws EventException
	 */
	public List<OpfVnorEmlStupVO> searchVnorEmlStup() throws EventException;
	
	/**
	 * VNOR All Code 가져온다.<br>
	 * 
	 * @return
	 * @throws EventException
	 */
	public Map<String, String> getVnorAllCode() throws EventException;
	
	/**
	 * VNOR Email 전송한다.<br>
	 * 
	 * @param opfVnorVO
	 * @param opfVnorItmVOs
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String sendVnorEmail(OpfVnorVO opfVnorVO, OpfVnorItmVO[] opfVnorItmVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0074 : MULTI <br>
	 * VNOR Email Setup 생성 및 삭제합니다.<br>
	 * 
	 * @param opfVnorEmlStupVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageVnorEmlStup(OpfVnorEmlStupVO[] opfVnorEmlStupVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 사선/용선 구분 코드를 가져온다.
	 * 
	 * @param vslCd
	 * @return
	 * @throws EventException
	 */
	public String getVslOwnIndCd(String vslCd) throws EventException;
	
	/**
	 * VOP_OPF_0071 : SEARCHLIST07<br>
	 * 해당 Vessel / Voy No 의 SKD Port List를 조회한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws EventException
	 */
	public List<ComComboVO> searchSkdPortList(OpfVnorVO opfVnorVO) throws EventException;
	
	/**
	 * VOP_OPF_0071 : SEARCHLIST08<br>
	 * 해당 Port의 Office Code List를 조회한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws EventException
	 */
	public List<ComComboVO> searchPortOfcCdList(OpfVnorVO opfVnorVO) throws EventException;
	
	/**
	 * VOP_OPF_0073 : SEARCH <br>
	 * VNOR Summary Inquiry 조회합니다.<br>
	 * 
	 * @param opfVnorSummaryVO
	 * @return
	 * @throws EventException
	 */
	public List<OpfVnorSummaryVO> searchVnorSummary(OpfVnorSummaryVO opfVnorSummaryVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Save <br>
	 * TERMINAL DEPARTURE REPORT HEADER의 AvgGang를 수정 합니다. <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTdrSAvgGang(TdrHeaderVO[] tdrHeaderVO, SignOnUserAccount account) throws EventException;	
	
}