/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RegionDepartureReportBC.java
*@FileTitle : RDR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.basic;

import java.util.List;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004605Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRAddSlotVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRAkVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRBbVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRCrtListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRDgVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRHcVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRLoadVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRNextPortVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDROverUsedVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRemarkVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRfInterPortVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRfMainTradeVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotReleaseVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotSwapVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotUtilVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslAllocVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslMvmtVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RdrCreatInfoVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSearchRegionLastPortVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;

/**
 * OPUS-Cargoloadingresultmgt Business Logic Command Interface<br>
 *
 * @author
 * @see Reference Vop_opf_0045EventResponse 
 * @since J2EE 1.6
 */

public interface RegionDepartureReportBC {
	
	/**
	 * Retrieve[Region Code]<br>
	 * 
	 * @param String code
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchComCodeList(String code) throws EventException;
	
	/**
	 * Retrieve[Operator]<br>
	 * 
	 * @param rdrListOptionVO RDRListOptionVO
	 * @return List<RDRListOptionVO>
	 * @exception EventException
	 */
	public List<RDRListOptionVO> searchCarrierList(RDRListOptionVO rdrListOptionVO) throws EventException;

	/**
	 * Retrieve[RDR VESSAL MOVE]<br>
	 * 
	 * @param RDRListOptionVO	rdrListOptionVO
	 * @return List<RDRListOptionVO>
	 * @exception EventException
	 */
	public List<RDRVslMvmtVO> searchRDRVSLMvmtList(RDRListOptionVO rdrListOptionVO) throws EventException;
	/**
	 * Retrieve[RDR NEXT PORT]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<RDRNextPortVO> searchRDRNextPortList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR SLOT HEADER]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRListOptionVO>
	 * @exception EventException
	 */
	public List<RDRListOptionVO> searchRDRAddSlotHeaderList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR ADD SLOT]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRAddSlotVO>
	 * @exception EventException
	 */
	public List<RDRAddSlotVO> searchRDRAddSlotList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR SLOT UTILIZE]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRSlotUtilVO>
	 * @exception EventException
	 */
	public List<RDRSlotUtilVO> searchRDRSlotUtilList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR AKWARD]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRAkVO>
	 * @exception EventException
	 */
	public List<RDRAkVO> searchRDRAKList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR BREAK BULK]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRBbVO>
	 * @exception EventException
	 */
	public List<RDRBbVO> searchRDRBBList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR HC]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRHcVO>
	 * @exception EventException
	 */
	public List<RDRHcVO> searchRDRHCList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR REFER MAIN TRADE]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRRfMainTradeVO>
	 * @exception EventException
	 */
	public List<RDRRfMainTradeVO> searchRDRRfMainTradeList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR REFER INTER TRADE]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRRfInterPortVO>
	 * @exception EventException
	 */
	public List<RDRRfInterPortVO> searchRDRRfInterPortList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR DANGER CNTR]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRDgVO>
	 * @exception EventException
	 */
	public List<RDRDgVO> searchRDRDGList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR VESSEL ALLOCATION]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRVslAllocVO>
	 * @exception EventException
	 */
	public List<RDRVslAllocVO> searchRDRVSLAllocList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR SLOT RELEASE]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRSlotReleaseVO>
	 * @exception EventException
	 */
	public List<RDRSlotReleaseVO> searchRDRSlotReleaseList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR SLOT SWAP]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRSlotSwapVO>
	 * @exception EventException
	 */
	public List<RDRSlotSwapVO> searchRDRSlotSwapList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR LOAD HEADER]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRListOptionVO>
	 * @exception EventException
	 */
	public List<RDRListOptionVO> searchRDRLoadHeaderList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR LOAD]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRLoadVO>
	 * @exception EventException
	 */
	public List<RDRLoadVO> searchRDRLoadList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR IPC OVERUSED]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDROverUsedVO>
	 * @exception EventException
	 */
	public List<RDROverUsedVO> searchRDROverList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * Retrieve[RDR REMARK]<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRRemarkVO>
	 * @exception EventException
	 */
	public List<RDRRemarkVO> searchRDRRemarkList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
    /**
     * Retrieve Move List of RDR Creation<br>
     * 
     * @param  RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RDRVslMvmtVO>
     * @exception EventException
     */
    public List<RDRVslMvmtVO> searchRDRCrtVSLMvmtList(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;

    /**
     * Retrieve to Import Vessel Movement Info<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRDRImpVSLMvmtList(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;
    
    /**
     * 
     * Save modification of RDR Vessel Movement <br>
     *
     * @param  RDRCrtListOptionVO rDRCrtListOptionVO
     * @param  RdrCreatInfoVO[]   rdrCreatInfoVOs
     * @param  SignOnUserAccount  signOnUserAccount
     * @throws EventException
     */
    public void manageRDRVSLMvmt(RDRCrtListOptionVO rDRCrtListOptionVO, RdrCreatInfoVO[] rdrCreatInfoVOs, SignOnUserAccount signOnUserAccount) throws EventException;
 
    /**
     *Retrieve to Import Vessel Movement Info<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRdrHeader(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;
    
 
     
     /**
      * Delete RDR Header, RDR Move Info<br>
      * 
      * @param  RDRCrtListOptionVO rDRCrtListOptionVO 
      * @throws EventException
      */
      public void removeRDRVSLMvmt(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;     
     
    
      /**
       * Retrieve RDR Slot/WGT Util Info<br>
       * 
       * @param RDRCrtListOptionVO rDRCrtListOptionVO
       * @return List<RdrCreatInfoVO>
       * @throws EventException
       */
      public List<RdrCreatInfoVO> searchRdrSltWgtUtil(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;
    
      /**
       * 
       * Save modification of RDR Slot/WGT Util  <br>
       *
       * @param  RDRCrtListOptionVO rDRCrtListOptionVO
       * @param  RdrCreatInfoVO[]   rdrCreatInfoVOs
       * @param  SignOnUserAccount  signOnUserAccount
       * @throws EventException
       */
      public void manageRdrSltWgtUtil(RDRCrtListOptionVO rDRCrtListOptionVO, RdrCreatInfoVO[] rdrCreatInfoVOs, SignOnUserAccount signOnUserAccount) throws EventException;
      
  /**
   * Delete RDR Header, RDR Slot/WGT Util Info <br>
   * 
   * @param  RDRCrtListOptionVO rDRCrtListOptionVO 
   * @throws EventException
   */
   public void removeRdrSltWgtUtilAll(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;   
     
   /**
    * Retrieve RDR HC/45 Info<br>
    * 
    * @param RDRCrtListOptionVO rDRCrtListOptionVO
    * @return List<RdrCreatInfoVO>
    * @throws EventException
    */
    public List<RdrCreatInfoVO> searchRdrHC45(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;
    
   /**
    * 
    * Save modification of RDR HC45 <br>
    *
    * @param  RDRCrtListOptionVO rDRCrtListOptionVO
    * @param  RdrCreatInfoVO[]   rdrCreatInfoVOs
    * @param  SignOnUserAccount  signOnUserAccount
    * @throws EventException
    */
    public void manageRdrHC45(RDRCrtListOptionVO rDRCrtListOptionVO, RdrCreatInfoVO[] rdrCreatInfoVOs, SignOnUserAccount signOnUserAccount) throws EventException;
       
    /**
    * Delete RDR HC45 Info<br>
    * 
    * @param  RDRCrtListOptionVO rDRCrtListOptionVO 
    * @throws EventException
    */
    public void removeRdrHC45(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;
    
    /**
     * Retrieve RDR HC/45 Import Sub Alloction Info<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRDRImpHC45(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;
 
    /**
     * Retrieve Main Trade Info of RDR RF<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRdrRfListMainTrade(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;

    /**
     * Retrieve Main Trade Info of RDR RF<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRdrRfListInterPort(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;

    /**
     * 
     * Save modification of RDR HC45<br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @param  RdrCreatInfoVO[]   rdrCreatInfoMainTradeVOs
     * @param  RdrCreatInfoVO[]   rdrCreatInfoInterPortVOs
     * @param  SignOnUserAccount  signOnUserAccount
     * @throws EventException
     */
     public void manageRdrRf(RDRCrtListOptionVO rdrCrtListOptionVO, RdrCreatInfoVO[] rdrCreatInfoMainTradeVOs,RdrCreatInfoVO[] rdrCreatInfoInterPortVOs, SignOnUserAccount signOnUserAccount) throws EventException;
        
     /**
      * Delete all RDR REPORT RF by VVD, REGION <br>
      * 
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO 
      * @throws EventException
      */
     public void removeRdrRfAll(RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException;

     
     /**
      * 
      * Retrieve RDR VSL Alloc Info<br>
      *
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO
      * @throws EventException
      * @return List<RdrCreatInfoVO>
      */
     public List<RdrCreatInfoVO> searchRdrVSLAlloc(RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException;
     
     /**
      * 
      * Retrieve Import RDR VSL Alloc Info <br>
      * 
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO
      * @throws EventException
      * @return List<RdrCreatInfoVO>
      */
     public  List<RdrCreatInfoVO>  searchImpRdrVSLAlloc(RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException;
     
     /**
      * 
      * Save RDR Vsl Allocation Info <br>
      *
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO
      * @param  RdrCreatInfoVO[] rdrCreatInfoVOs
      * @param  SignOnUserAccount signOnUserAccount
      * @throws EventException
      */
     public  void   manageRdrVSLAlloc(RDRCrtListOptionVO rdrCrtListOptionVO, RdrCreatInfoVO[] rdrCreatInfoVOs, SignOnUserAccount signOnUserAccount) throws EventException;  
 
    /**
     * 
     * Delete RDR VSL Allocation Info <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws EventException
     */
     public void removeRdrVSLAllocAll(RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException;  

     /**
      * 
      * Save Remark Info of RDR Header <br>
      *
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO
      * @throws EventException
      */
     public void modifyRdrHeaderForRemark(RDRCrtListOptionVO rdrCrtListOptionVO ) throws EventException;  
 
     /**
      * 
      * Retrieve Import RDR VSL Alloc Info<br>
      * 
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO
      * @throws EventException
      * @return List<RdrCreatInfoVO>
      */
     public  List<RdrCreatInfoVO>  searchRdrHeaderRemark(RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException;
     
     /**
      * Retrieve [RDR NEXT PORT]<br>
      * 
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO
      * @return List<RdrCreatInfoVO>
      * @exception EventException
      */
     public List<RdrCreatInfoVO> searchRDRCreNextPortList(RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException;     
     
     /**
      * VOP_OPF_0046  : Delete <br>
      * Delete all RDR Info   <br>
      *
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO
      * @throws EventException
      * @author 
      */
     public void removeRdrData(RDRCrtListOptionVO rdrCrtListOptionVO ) throws EventException;  
     
     /**
 	 * [RDR Creation 화면 VVD 별 Last Port ] 정보를 [조회] 합니다.<br>
 	 * 
 	 * @param RDRCrtListOptionVO rDRCrtListOptionVO
 	 * @return List<RDRSearchRegionLastPortVO>
 	 * @exception EventException
 	 */
 	 public List<RDRSearchRegionLastPortVO> searchRegionLastPort(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;

}
