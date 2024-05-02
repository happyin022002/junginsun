/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RegionDepartureReportBC.java
*@FileTitle : RDR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.20 이선영
* 1.0 Creation
* ---------------------------------------------------------------------
* History
* 2011.06.29 이준범 [CHM-201111792-01]
* 제 목 : Cargo Handling Performance + RDR CREATION 화면 보완
* 내 용 : 1)Cargo Handling Performance - region Check 로직삭제
*       2) RDR CREATION - Region 선택 칼럼 삭제 요하며, Port 칼럼은 해당 VVD의 Turning port및 Normal Port check하여
*                      해당 Port의 Region의 last Port만 Select Box로 표시될수 있도록 처리  
* 2011.08.24 김민아 [CHM-201113050-01] [VOP-OPF] RDR Inquiry 로직 변경 : RDR이 생성된 region만 보일수 있도록 로직 변경
* 2013.11.25 임옥영 [CHM-201327237] [VOP-OPF] RDR Summary 메뉴 추가 
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004605Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRAddSlotVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRAkVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRBbVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRCrtListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRDgVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRHcVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRLoadVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRNextPortVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDROverUsedVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRemarkVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRfInterPortVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRfMainTradeVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotReleaseVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotSwapVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotUtilVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSummaryVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslAllocVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslMvmtVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RdrCreatInfoVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSearchRegionLastPortVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComIntgCdDtlVO;

/**
 * ALPS-Cargoloadingresultmgt Business Logic Command Interface<br>
 * - ALPS-Cargoloadingresultmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SunyoungLee
 * @see Vop_opf_0045EventResponse 참조
 * @since J2EE 1.6
 */

public interface RegionDepartureReportBC {
	
	/**
	 * [Common Code]을 [조회] 합니다.<br>
	 * 
	 * @param String code
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchComCodeList(String code) throws EventException;
	
	/**
	 * [Operator]을 [조회] 합니다.<br>
	 * 
	 * @param rdrListOptionVO RDRListOptionVO
	 * @return List<RDRListOptionVO>
	 * @exception EventException
	 */
	public List<RDRListOptionVO> searchCarrierList(RDRListOptionVO rdrListOptionVO) throws EventException;

	/**
	 * [RDR VESSAL MOVE]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO	rdrListOptionVO
	 * @return List<RDRListOptionVO>
	 * @exception EventException
	 */
	public List<RDRVslMvmtVO> searchRDRVSLMvmtList(RDRListOptionVO rdrListOptionVO) throws EventException;
	/**
	 * [RDR NEXT PORT]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<RDRNextPortVO> searchRDRNextPortList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR SLOT HEADER]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRListOptionVO>
	 * @exception EventException
	 */
	public List<RDRListOptionVO> searchRDRAddSlotHeaderList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR ADD SLOT]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRAddSlotVO>
	 * @exception EventException
	 */
	public List<RDRAddSlotVO> searchRDRAddSlotList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR SLOT UTILIZE]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRSlotUtilVO>
	 * @exception EventException
	 */
	public List<RDRSlotUtilVO> searchRDRSlotUtilList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR AKWARD]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRAkVO>
	 * @exception EventException
	 */
	public List<RDRAkVO> searchRDRAKList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR BREAK BULK]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRBbVO>
	 * @exception EventException
	 */
	public List<RDRBbVO> searchRDRBBList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR HC]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRHcVO>
	 * @exception EventException
	 */
	public List<RDRHcVO> searchRDRHCList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR REFER MAIN TRADE]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRRfMainTradeVO>
	 * @exception EventException
	 */
	public List<RDRRfMainTradeVO> searchRDRRfMainTradeList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR REFER INTER TRADE]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRRfInterPortVO>
	 * @exception EventException
	 */
	public List<RDRRfInterPortVO> searchRDRRfInterPortList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR DANGER CNTR]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRDgVO>
	 * @exception EventException
	 */
	public List<RDRDgVO> searchRDRDGList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR VESSEL ALLOCATION]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRVslAllocVO>
	 * @exception EventException
	 */
	public List<RDRVslAllocVO> searchRDRVSLAllocList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR SLOT RELEASE]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRSlotReleaseVO>
	 * @exception EventException
	 */
	public List<RDRSlotReleaseVO> searchRDRSlotReleaseList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR SLOT SWAP]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRSlotSwapVO>
	 * @exception EventException
	 */
	public List<RDRSlotSwapVO> searchRDRSlotSwapList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR LOAD HEADER]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRListOptionVO>
	 * @exception EventException
	 */
	public List<RDRListOptionVO> searchRDRLoadHeaderList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR LOAD]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRLoadVO>
	 * @exception EventException
	 */
	public List<RDRLoadVO> searchRDRLoadList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR IPC OVERUSED]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDROverUsedVO>
	 * @exception EventException
	 */
	public List<RDROverUsedVO> searchRDROverList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
	/**
	 * [RDR REMARK]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRRemarkVO>
	 * @exception EventException
	 */
	public List<RDRRemarkVO> searchRDRRemarkList(RDRListOptionVO rdrListOptionVO) throws EventException;
	
    /**
     * [RDR Creation의 Move List]를 [조회] 합니다.<br>
     * 
     * @param  RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RDRVslMvmtVO>
     * @exception EventException
     */
    public List<RDRVslMvmtVO> searchRDRCrtVSLMvmtList(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;

    /**
     * Vessel Movement정보를 Import하기 위해 조회한다.<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRDRImpVSLMvmtList(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;
    
    /**
     * 
     * RDR Vessel Movement의 수정내용을 저장 합니다. <br>
     *
     * @param  RDRCrtListOptionVO rDRCrtListOptionVO
     * @param  RdrCreatInfoVO[]   rdrCreatInfoVOs
     * @param  SignOnUserAccount  signOnUserAccount
     * @author jang kang cheol
     * @throws EventException
     */
    public void manageRDRVSLMvmt(RDRCrtListOptionVO rDRCrtListOptionVO, RdrCreatInfoVO[] rdrCreatInfoVOs, SignOnUserAccount signOnUserAccount) throws EventException;
 
    /**
     * Vessel Movement정보를 Import하기 위해 조회한다.<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRdrHeader(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;
    
 
     
     /**
      * RDR Header, RDR Move 정보를 삭제한다. <br>
      * 
      * @param  RDRCrtListOptionVO rDRCrtListOptionVO 
      * @throws EventException
      */
      public void removeRDRVSLMvmt(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;     
     
    
      /**
       * RDR Slot/WGT Util 정보를  조회한다.<br>
       * 
       * @param RDRCrtListOptionVO rDRCrtListOptionVO
       * @return List<RdrCreatInfoVO>
       * @throws EventException
       */
      public List<RdrCreatInfoVO> searchRdrSltWgtUtil(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;
    
      /**
       * 
       * RDR Slot/WGT Util의 수정내용을 저장 합니다. <br>
       *
       * @param  RDRCrtListOptionVO rDRCrtListOptionVO
       * @param  RdrCreatInfoVO[]   rdrCreatInfoVOs
       * @param  SignOnUserAccount  signOnUserAccount
       * @author jang kang cheol
       * @throws EventException
       */
      public void manageRdrSltWgtUtil(RDRCrtListOptionVO rDRCrtListOptionVO, RdrCreatInfoVO[] rdrCreatInfoVOs, SignOnUserAccount signOnUserAccount) throws EventException;
      
  /**
   * RDR Header, RDR Slot/WGT Util 정보를 삭제한다. <br>
   * 
   * @param  RDRCrtListOptionVO rDRCrtListOptionVO 
   * @throws EventException
   */
   public void removeRdrSltWgtUtilAll(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;   
     
   /**
    * RDR HC/45 정보를  조회한다.<br>
    * 
    * @param RDRCrtListOptionVO rDRCrtListOptionVO
    * @return List<RdrCreatInfoVO>
    * @throws EventException
    */
    public List<RdrCreatInfoVO> searchRdrHC45(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;
    
   /**
    * 
    * RDR HC45의 수정내용을 저장 합니다. <br>
    *
    * @param  RDRCrtListOptionVO rDRCrtListOptionVO
    * @param  RdrCreatInfoVO[]   rdrCreatInfoVOs
    * @param  SignOnUserAccount  signOnUserAccount
    * @author jang kang cheol
    * @throws EventException
    */
    public void manageRdrHC45(RDRCrtListOptionVO rDRCrtListOptionVO, RdrCreatInfoVO[] rdrCreatInfoVOs, SignOnUserAccount signOnUserAccount) throws EventException;
       
    /**
    * RDR HC45 정보를 삭제한다. <br>
    * 
    * @param  RDRCrtListOptionVO rDRCrtListOptionVO 
    * @throws EventException
    */
    public void removeRdrHC45(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;
    
    /**
     * RDR HC/45 Import Sub Alloction 정보를  조회한다.<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRDRImpHC45(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;
 
    /**
     * RDR RF의 Main Trade 정보를  조회한다.<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRdrRfListMainTrade(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;

    /**
     * RDR RF의 Main Trade 정보를  조회한다.<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws EventException
     */
    public List<RdrCreatInfoVO> searchRdrRfListInterPort(RDRCrtListOptionVO rDRCrtListOptionVO) throws EventException;

    /**
     * 
     * RDR HC45의 수정내용을 저장 합니다. <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @param  RdrCreatInfoVO[]   rdrCreatInfoMainTradeVOs
     * @param  RdrCreatInfoVO[]   rdrCreatInfoInterPortVOs
     * @param  SignOnUserAccount  signOnUserAccount
     * @author jang kang cheol
     * @throws EventException
     */
     public void manageRdrRf(RDRCrtListOptionVO rdrCrtListOptionVO, RdrCreatInfoVO[] rdrCreatInfoMainTradeVOs,RdrCreatInfoVO[] rdrCreatInfoInterPortVOs, SignOnUserAccount signOnUserAccount) throws EventException;
        
     /**
      * RDR REPORT RF 를 전제(VVD, REGION 별) 삭제  합니다.<br>
      * 
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO 
      * @throws EventException
      */
     public void removeRdrRfAll(RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException;

     
     /**
      * 
      * RDR VSL Alloc 정보를  조회한다.<br>
      *
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO
      * @throws EventException
      * @return List<RdrCreatInfoVO>
      * @author jang kang cheol
      */
     public List<RdrCreatInfoVO> searchRdrVSLAlloc(RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException;
     
     /**
      * 
      * Import RDR VSL Alloc 정보를  조회한다. <br>
      * 
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO
      * @throws EventException
      * @return List<RdrCreatInfoVO>
      * @author jang kang cheol
      */
     public  List<RdrCreatInfoVO>  searchImpRdrVSLAlloc(RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException;
     
     /**
      * 
      * RDR RF 정보를  저장 한다. <br>
      *
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO
      * @param  RdrCreatInfoVO[] rdrCreatInfoVOs
      * @param  SignOnUserAccount signOnUserAccount
      * @throws EventException
      * @author jang kang cheol
      */
     public  void   manageRdrVSLAlloc(RDRCrtListOptionVO rdrCrtListOptionVO, RdrCreatInfoVO[] rdrCreatInfoVOs, SignOnUserAccount signOnUserAccount) throws EventException;  
 
    /**
     * 
     * RDR VSL Allocation 정보를  삭제 한다. <br>
     *
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws EventException
     * @author jang kang cheol
     */
     public void removeRdrVSLAllocAll(RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException;  

     /**
      * 
      * RDR Header의 Remark 정보를  저장 한다. <br>
      *
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO
      * @throws EventException
      * @author jang kang cheol
      */
     public void modifyRdrHeaderForRemark(RDRCrtListOptionVO rdrCrtListOptionVO ) throws EventException;  
 
     /**
      * 
      * Import RDR VSL Alloc 정보를  조회한다. <br>
      * 
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO
      * @throws EventException
      * @return List<RdrCreatInfoVO>
      * @author jang kang cheol
      */
     public  List<RdrCreatInfoVO>  searchRdrHeaderRemark(RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException;
     
     /**
      * [RDR NEXT PORT]을 [조회] 합니다.<br>
      * 
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO
      * @return List<RdrCreatInfoVO>
      * @exception EventException
      */
     public List<RdrCreatInfoVO> searchRDRCreNextPortList(RDRCrtListOptionVO rdrCrtListOptionVO) throws EventException;     
     
     /**
      * VOP_OPF_0046  : Delete <br>
      * RDR  모든 정보를  삭제 한다. <br>
      *
      * @param  RDRCrtListOptionVO rdrCrtListOptionVO
      * @throws EventException
      * @author jang kang cheol
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
 	
	/**
	 * [Region Code]을 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	
 	public List<ComIntgCdDtlVO> searchRDRRegionList(RDRListOptionVO rdrListOptionVO) throws EventException;
    /**
     * [RDR Summary]을 [조회] 합니다.<br>
     * 
     * @param  RDRSummaryVO rDRSummaryVO
     * @return List<RDRSummaryVO>
     * @exception EventException
     */
    public List<RDRSummaryVO> searchRDRSummaryList(RDRSummaryVO rDRSummaryVO) throws EventException;     

}
