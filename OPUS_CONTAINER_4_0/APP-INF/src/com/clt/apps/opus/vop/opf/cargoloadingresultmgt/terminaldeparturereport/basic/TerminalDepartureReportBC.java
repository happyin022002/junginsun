/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalDepartureReportBC.java
*@FileTitle : TDR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.basic;

import java.util.List;

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
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrDistLoadVolVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrHeaderSkdVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrSlotHC45VO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrUtilizeSlotPortVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportConditionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformInputVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.VskVslPortSkdSheetVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmYardVO;
import com.clt.syscommon.common.table.OpfRstwgRsnCdVO;
import com.clt.syscommon.common.table.TdrAllocationVO;
import com.clt.syscommon.common.table.TdrCntrDetailVO;
import com.clt.syscommon.common.table.TdrHeaderVO;

/**
 * OPUS-Cargoloadingresultmgt Business Logic Command Interface<br>
 *
 * @author 
 * @see Reference Vop_opf_0036EventResponse 
 * @since J2EE 1.6
 */

public interface TerminalDepartureReportBC {
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR VESSAL SCHEDULE]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<VskVslPortSkdSheetVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdSheetVO> searchTdrSKDList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR HEADER]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrHeaderVO>
	 * @exception EventException
	 */
	public List<TdrHeaderSkdVO> searchTdrHeaderList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR PORT LOG HEADER]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<PortLogHeadVO>
	 * @exception EventException
	 */
	public List<PortLogHeadVO> searchTdrPortLogHeadList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR PORT LOG DETAIL]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<PortLogDetailVO>
	 * @exception EventException
	 */
	public List<PortLogDetailVO> searchTdrPortLogDetailList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * [TDR DISCHARGE TOTAL VOLUME IMPORT]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrDistLoadVolVO>
	 * @exception EventException
	 */
	public List<TdrDistLoadVolVO> searchBkgVolumeDischTotal(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR TOTAL VOLUME]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrDistLoadVolVO>
	 * @exception EventException
	 */
	public List<TdrDistLoadVolVO> searchTdrDischargeTotalList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR DISCHARGE SCG IMPORT]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<DischVolSGTdrVO>
	 * @exception EventException
	 */
	public List<DischVolSGTdrVO> searchBkgVolumeDischSG(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR DISCHARGE SCG]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<DischVolSGTdrVO>
	 * @exception EventException
	 */
	public List<DischVolSGTdrVO> searchTdrDischargeSGList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR DISCHARGE SCG SUMMARY]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<DischVolSGTdrVO>
	 * @exception EventException
	 */
	public List<DischVolSGTdrVO> searchTdrLoadSGList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR DISCHARGE BREAK BULK IMPORT]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchBkgVolumeDischBreak(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR DISCHARGE BREAK BULK]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchTdrDischargeBreakList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR LOAD OCEAN]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<LoadVolOceanTdrVO>
	 * @exception EventException
	 */
	public List<TdrDistLoadVolVO> searchTdrLoadOceanPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR LOAD OCEAN IMPORT]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrDistLoadVolVO> searchBkgVolumeLoadTotal(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR LOAD SCG IMPORT]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<DischVolSGTdrVO>
	 * @exception EventException
	 */
	public List<DischVolSGTdrVO> searchBkgVolumeLoadSG(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR LOAD BREAK BULK IMPORT]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchBkgVolumeLoadBreak(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

    /**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR COD]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<LoadVolOceanTdrVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchTdrCodList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR REHANDLE]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchTdrRHList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR MISHANDLE]<br>
	 * 
	 * @param  TerminalDepartureReportConditionVO terminalDepartureReportCondVO  
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchTdrMisHandleList(TerminalDepartureReportConditionVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR SLOT BSA]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrAllocationBSAVO>
	 * @exception EventException
	 */
	public List<TdrAllocationBSAVO> searchTdrSlotBSAList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR SLOT BSA IMPORT]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrAllocationBSAVO>
	 * @exception EventException
	 */
	public List<TdrAllocationBSAVO> searchTdrSlotBSAImportList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR SLOT HC45]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrSlotHC45VO>
	 * @exception EventException
	 */
	public List<TdrSlotHC45VO> searchTdrSlotHC45List(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR SLOT HC45 IMPORT]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrSlotHC45VO>
	 * @exception EventException
	 */
	public List<TdrSlotHC45VO> searchTdrSlotHC45ImportList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR SLOT HC45 IMPORT]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrUtilizeSlotPortVO>
	 * @exception EventException
	 */
	public List<TdrUtilizeSlotPortVO> searchTdrSlotDepList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR SLOT PORT]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrUtilizeSlotPortVO>
	 * @exception EventException
	 */
	public List<TdrUtilizeSlotPortVO> searchTdrSlotPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR SLOT PORT IMPORT]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrUtilizeSlotPortVO>
	 * @exception EventException
	 */
	public List<TdrUtilizeSlotPortVO> searchTdrSlotPortImpList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR SLOT DEP IMPORT]<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrAllocationBSAVO>
	 * @throws DAOException
	 */
	public List<TdrUtilizeSlotPortVO> searchTdrSlotDepImportList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR TEMP STWG]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<TdrCntrDetailVO>
	 * @exception EventException
	 */
	public List<TdrCntrDetailVO> searchTdrTmpStwgList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR REHANDLE REASON]<br>
	 * 
	 * @param opfRstwgRsnCdVO OpfRstwgRsnCdVO 
	 * @return List<OpfRstwgRsnCdVO>
	 * @exception EventException
	 */
	public List<OpfRstwgRsnCdVO> searchTdrRHReasonCdList(OpfRstwgRsnCdVO opfRstwgRsnCdVO) throws EventException;

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve [TDR REHANDLE REASON]<br>
	 * 
	 * @param terminalDepartureReportCondVO TerminalDepartureReportCondVO 
	 * @return List<OpfTmlProdRptRsnCdVO>
	 * @exception EventException
	 */
	public List<OpfTmlProdRptRsnCdVO> searchExcludeTpr(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Create, Update, Delete [TERMINAL DEPARTURE REPORT HEADER] <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdr(TdrHeaderVO[] tdrHeaderVO, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_OPF_0036 : Save <br>
	 * Create, Update, Delete [TERMINAL DEPARTURE REPORT CRANE] <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param portLogDetailVO PortLogDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrCrane(TdrHeaderVO[] tdrHeaderVO, PortLogDetailVO[] portLogDetailVO, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_OPF_0036 : Save <br>
	 * Create, Update, Delete [TERMINAL DEPARTURE REPORT SUMMARY TOTAL] <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param DischVolTotalVO PortLogDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrDischTotal(TdrHeaderVO[] tdrHeaderVO, TdrDistLoadVolVO[] dischVolTotalVO, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_OPF_0036 : Save <br>
	 * Create, Update, Delete [TERMINAL DEPARTURE REPORT SUMMARY SCG] <br>
	 * 
	 * @param TdrHeaderVO[] tdrHeaderVO
	 * @param DischVolSGTdrVO[] dischVolSGTdrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTdrDischSG(TdrHeaderVO[] tdrHeaderVO, DischVolSGTdrVO[] dischVolSGTdrVO, SignOnUserAccount account) throws EventException;
	
    /**
     * VOP_OPF_0036 : Save <br>
     * Create, Update, Delete [TERMINAL DEPARTURE REPORT SUMMARY SCG] <br>
     * 
     * @param TdrHeaderVO[] tdrHeaderVO
     * @param DischVolSGTdrVO[] dischVolSGTdrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTdrLoadSG(TdrHeaderVO[] tdrHeaderVO, DischVolSGTdrVO[] dischVolSGTdrVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Create, Update, Delete [TERMINAL DEPARTURE REPORT SUMMARY BREAK BULK] <br>
	 * 
	 * @param TdrHeaderVO[] tdrHeaderVO
	 * @param TdrCntrDetailVO[] tdrCntrDetailVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTdrDischBreak(TdrHeaderVO[] tdrHeaderVO, TdrCntrDetailVO[] tdrCntrDetailVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Create, Update, Delete [TERMINAL DEPARTURE REPORT CNTR DETAIL COD] <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param tdrCntrDetailVO TdrCntrDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrCod(TdrHeaderVO[] tdrHeaderVO, TdrCntrDetailVO[] tdrCntrDetailVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Create, Update, Delete [TERMINAL DEPARTURE REPORT CNTR DETAIL REHANDLE] <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param tdrCntrDetailVO TdrCntrDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrRH(TdrHeaderVO[] tdrHeaderVO, TdrCntrDetailVO[] tdrCntrDetailVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Create, Update, Delete [TERMINAL DEPARTURE REPORT CNTR DETAIL MISHANDLE] <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param tdrCntrDetailVO TdrCntrDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrMishandle(TdrHeaderVO[] tdrHeaderVO, TdrCntrDetailVO[] tdrCntrDetailVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Create, Update, Delete [TERMINAL DEPARTURE REPORT ALLOCATION] <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param tdrAllocationVO TdrAllocationVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrSlotBSA(TdrHeaderVO[] tdrHeaderVO, TdrAllocationVO[] tdrAllocationVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Create, Update, Delete [TERMINAL DEPARTURE REPORT BSA] <br>
	 * 
	 * @param TdrHeaderVO[] tdrHeaderVO
	 * @param TdrSlotHC45VO[] tdrSlotHC45VO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTdrSlotHC45(TdrHeaderVO[] tdrHeaderVO, TdrSlotHC45VO[] tdrSlotHC45VO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Create, Update, Delete [TERMINAL DEPARTURE REPORT UTILIZE] <br>
	 * 
	 * @param TdrHeaderVO[] tdrHeaderVO
	 * @param TdrUtilizeSlotPortVO[] tdrUtilizeSlotPortVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTdrSlotPort(TdrHeaderVO[] tdrHeaderVO, TdrUtilizeSlotPortVO[] tdrUtilizeSlotPortVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Create, Update, Delete [TERMINAL DEPARTURE REPORT CNTR DETAIL TEMPSTWG] <br>
	 * 
	 * @param tdrHeaderVO TdrHeaderVO[]
	 * @param tdrCntrDetailVO TdrCntrDetailVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTdrTmpStwg(TdrHeaderVO[] tdrHeaderVO, TdrCntrDetailVO[] tdrCntrDetailVO, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_OPF_0038 : Save <br>
	 * Create, Update, Delete [OPF TERMINAL DEPARTURE REPORT DETAIL] <br>
	 * 
	 * @param OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageExcludeTpr(OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  Retrieve Cargo Handling Performance <br>
	 * 
	 * @param TerminalDepartureReportConditionVO	terminalDepartureReportConditionVO
	 * @return List<CgoHndPerformInputVO>
	 * @exception EventException
	 */
	public List<CgoHndPerformInputVO> searchCgoHndPerformList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;
	
	/**
	 * Retrieve checking Port Code validation in retrieve condition <br>
	 * 
	 * @param TerminalDepartureReportConditionVO   terminalDepartureReportConditionVO
	 * @return List<MdmYardVO>
	 * @exception EventException
	 */
	public List<MdmYardVO> searchMdmYardCombo(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;

	/**
	 *  Retrieve Cargo Re-Handling Performance <br>
	 * 
	 * @param TerminalDepartureReportConditionVO	terminalDepartureReportConditionVO
	 * @return List<CgoRhndPerformInputVO>
	 * @exception EventException
	 */
	public List<CgoRhndPerformInputVO> searchCgoRhndPerformList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;

	/**
	 *  Retrieve Cargo Re-Handling Performance <br>
	 * 
	 * @param TerminalDepartureReportConditionVO	terminalDepartureReportConditionVO
	 * @return List<CgoRhndPerformInputVO>
	 * @exception EventException
	 */
	public List<CgoRhndPerformInputVO> searchRestowReasonList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;

	
	/**
	 *  Retrieve VSL Condition Statistics <br>
	 * 
	 * @param TerminalDepartureReportConditionVO	terminalDepartureReportConditionVO
	 * @return List<TdrListOptionVO>
	 * @exception EventException
	 */
	public List<TdrListOptionVO> searchVslConditionList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;

//	/**
//	 *  Retrieve Terminal Performance - Port<br>
//	 * 
//	 * @param TerminalDepartureReportConditionVO	terminalDepartureReportConditionVO
//	 * @return List<TmnlPerformInputVO>
//	 * @exception EventException
//	 */
//	public List<TmnlPerformInputVO> searchTmnlPerformPortList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;

	/**
	 * Retrieve Terminal Performance - Lane<br>
	 * 
	 * @param TerminalDepartureReportConditionVO	terminalDepartureReportConditionVO
	 * @return List<TmnlPerformInputVO>
	 * @exception EventException
	 */
	public List<TmnlPerformInputVO> searchTmnlPerformLaneList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;	

	/**
	 *  Retrieve Terminal Productivity Report<br>
	 * 
	 * @param TerminalDepartureReportConditionVO	terminalDepartureReportConditionVO
	 * @return List<TmnlPerformVO>
	 * @exception EventException
	 */
	public List<TmnlPerformVO> searchTmnlProdList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;	

	/**
	 * Retrieve checking Port Code validation in retrieve condition<br>
	 * 
	 * @param TerminalDepartureReportConditionVO   terminalDepartureReportConditionVO
	 * @return List<MdmRhqComboVO>
	 * @exception EventException
	 */
	public List<MdmRhqComboVO> searchMdmRhqCombo(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;
	
	/**
	 *  Retrieve TDR Details <br>
	 * 
	 * @param TerminalDepartureReportConditionVO	terminalDepartureReportConditionVO
	 * @return List<TerminalDepartureReportVO>
	 * @exception EventException
	 */
	public List<TerminalDepartureReportVO> searchTdrDetailList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws EventException;	
	
    /**
     * VOP_OPF_0036 : Save <br>
     * Re-calculating Header Mvs in case [TERMINAL DEPARTURE REPORT SUMMARY TOTAL] register  <br>
     * 
     * @param TdrHeaderVO[] tdrHeaderVO 
     * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyTdrHeaderMvs(TdrHeaderVO[] tdrHeaderVO, TerminalDepartureReportCondVO terminalDepartureReportCondVO, SignOnUserAccount account) throws EventException;
 
    /**
     * VOP_OPF_0036 : Save <br>
     * Create, Update, Delete [TERMINAL DEPARTURE REPORT SUMMARY LOAD- OCEAN] <br>
     * 
     * @param tdrHeaderVO TdrHeaderVO[]
     * @param DischVolTotalVO PortLogDetailVO[]
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void manageTdrLoad(TdrHeaderVO[] tdrHeaderVO, TdrDistLoadVolVO[] dischVolTotalVO, SignOnUserAccount account) throws EventException;

    
	/**
	 * VOP_OPF_0095 : Retrieve <br>
	 * Retrieve Missing TDR List<br>
	 * 
	 * @param MissingTDRCondVO missingTDRCondVO
	 * @return List<MissingTDRVO>
	 * @exception EventException
	 */
	public List<MissingTDRVO> searchMissingTDRList(MissingTDRCondVO missingTDRCondVO) throws EventException;

	/**
	 * VOP_OPF_0095 : Port Code OnChange <br>
	 * After checking Port Code Validation, get RHQ Office Code<br>
	 * 
	 * @param MissingTDRCondVO missingTDRCondVO
	 * @return List<MissingTDRVO>
	 * @exception EventException
	 */
	public List<MissingTDRVO> searchPortCodeNRhqOfcCdList(MissingTDRCondVO missingTDRCondVO) throws EventException;
	
	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * Retrieve mail Receiver Info<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @param String spclCgoCateCd
	 * @return String
	 * @throws EventException
	 */
	public String searchReceiver(String vslCd, String skdVoyNo, String skdDirCd, String ydCd, String spclCgoCateCd) throws EventException;
}