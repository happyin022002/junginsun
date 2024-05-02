/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerOnOffhireBC.java
*@FileTitle : ContainerOnOffhire
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.06.03 김석준
* 1.0 Creation
* ======================================================
* 2010.10.19 남궁진호 [CHM-201006507-01] EES_MST_0047 신규화면추가
* 			 modifyCntrReeferUnitInfoBasic,searchCntrReeferUnitInfoBasic 
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.LongStayUclmDetailVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.vo.ImmediateExitCreationVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalOwnListVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo.TermChangeCreationVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.ApprovalListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrLotVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureInfoVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterInquiryVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterUpdateIFVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrReeferUnitInfoVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrReeferUnitListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrStatusCreationVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.FaTargetListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.IFGateVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.LeasedCntrVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.LostFoundVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.LotNoListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.MstEtcVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusHistoryVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusUpdateGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Equipmentmanagement Business Logic Command Interface<br>
 * - ALPS-Equipmentmanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Suk Jun Kim
 * @see Ees_mst_0032EventResponse 참조
 * @since J2EE 1.6
 */

public interface ContainerOnOffhireBC {

    /**
     * Own Container를 생성합니다.<br> 
     * 
     * @param  CntrLotVO cntrLotVO
     * @param  SignOnUserAccount account
     * @return CntrLotVO
     * @throws EventException
     */
    public CntrLotVO createOwnCntrBasic(CntrLotVO cntrLotVO, SignOnUserAccount account) throws EventException;
 
    /**
     * Own Container의 Lot No를 조회합니다.<br>
     * 
     * @author J.H.Min
     * @category EES_MST_0016_01
     * @category searchLotInfoBasic
     * 
     * @param	CntrLotVO cntrLotVO
     * @return	CntrLotVO
     * @throws EventException
     */    
    public CntrLotVO searchLotInfoBasic(CntrLotVO cntrLotVO) throws EventException;
    
    
    /**
     * Own Container 내용을 수정합니다.<br>
     *  
     * @author J.H.Min
     * @category EES_MST_0016_03
     * @category modifyOwnCntrBasic 
     *  
     * @param CntrLotVO cntrLotVO
     * @param SignOnUserAccount account
     * @throws EventException
     */   
    public void modifyOwnCntrBasic(CntrLotVO cntrLotVO, SignOnUserAccount account) throws EventException;
    
	/** 
	 * EES_MST_0019, EES_MST_0044 : retrieve <br>
	 * Container Master Inquiry, Container Master Update를 리스트 조회처리합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0019, EES_MST_0044
	 * @category searchCntrMasterInquiryBasic    
	 * @param MstEtcVO   mstEtcVO
	 * @return CntrMasterInquiryVO
	 * @exception EventException
	 */ 
	 public CntrMasterInquiryVO searchCntrMasterInquiryBasic(MstEtcVO mstEtcVO) throws EventException;
	
	/** 
	 * EES_MST_0014 : retrieve <br>
	 * Leased Container를 조회합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0014
	 * @category searchApprovalListBasic    
	 * @param mstEtcVO   MstEtcVO
	 * @return List<CntrMasterInquiryVO>
	 * @exception EventException
	 */
	 public List<ApprovalListVO> searchApprovalListBasic(MstEtcVO mstEtcVO) throws EventException;
	 
	/** 
	 * EES_MST_0014 : save <br>
	 * Leased Container를 저장합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0014
	 * @category manageLeasedCntrBasic 
	 * @param LeasedCntrVO[] leasedCntrVOs
	 * @param SignOnUserAccount account
	 * @return List<LeasedCntrVO>
	 * @exception EventException
	 */
	 public List<LeasedCntrVO> manageLeasedCntrBasic(LeasedCntrVO[] leasedCntrVOs, SignOnUserAccount account) throws EventException;
	 
	/** 
	 * EES_MST_0044 : save <br>
	 * Container Master Update를 저장합니다. <br>
	 * @author LEE HO SUN
	 * @category EES_MST_0044
	 * @category modifyCntrMasterBasic  
	 * @param MstEtcVO mstEtcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
    public void modifyCntrMasterBasic(MstEtcVO mstEtcVO, SignOnUserAccount account) throws EventException; 
    
	/** 
	 * Lot No Inquiry 화면에 대한  조회이벤트 처리.<br>
	 * 
	 * @author J.H.Min
	 * @category EES_MST_0038
	 * @category searchLotNoListBrieflyBasic	 
	 * 
	 * @param MstEtcVO mstEtcVO
	 * @return List<LotNoListVO>
	 * @exception EventException
	 */	
    public List<LotNoListVO> searchLotNoListBrieflyBasic(MstEtcVO mstEtcVO) throws EventException;
    
    
	/** 
	 * 해당 컨테이너의 장비 상태(Movement,Status) 정보를 조회한다.<br>
	 * 
     * @author J.H.Min
     * @category EES_MST_0025
     * @category searchLostFoundListBasic
	 * 
	 * @param LostFoundVO[] lostFoundVOs
	 * @return List<LostFoundVO>
	 * @exception EventException
	 */	
    public List<LostFoundVO> searchLostFoundListBasic(LostFoundVO[] lostFoundVOs) throws EventException;
    
	/** 
	 * EES_MST_0024 : retrieve <br>
	 * Container Status Creation을 조회합니다. <br>
	 * @author LEE HO SUN
	 * @category EES_MST_0024
	 * @category searchLeaseOutTargetListBasic  
	 * @param CntrStatusCreationVO[] cntrStatusCreationVOs
	 * @return List<CntrStatusCreationVO>
	 * @exception EventException
	 */	
	public List<CntrStatusCreationVO> searchLeaseOutTargetListBasic(CntrStatusCreationVO[] cntrStatusCreationVOs) throws EventException;
	
	/** 
	 * EES_MST_0024 : save <br>
     * Container Status Creation을 저장합니다. <br>
	 * @author LEE HO SUN
	 * @category EES_MST_0024
	 * @category manageCntrStatusCreationBasic
	 * @param CntrStatusCreationVO[] cntrStatusCreationVOs
	 * @param SignOnUserAccount account
	 * @return List<CntrStatusCreationVO>
	 * @exception EventException
	 */	
	public List<CntrStatusCreationVO> manageCntrStatusCreationBasic(CntrStatusCreationVO[] cntrStatusCreationVOs, SignOnUserAccount account) throws EventException ;
	
	/** 
	 * EES_MST_0017 : retrieve <br>
	 * Own Container Interface to ERP FA를 조회합니다. <br>
	 * @author LEE HO SUN
	 * @category EES_MST_0017
	 * @category searchFATargetListBasic
	 * @param MstEtcVO mstEtcVO
	 * @return List<FaTargetListVO>
	 * @exception EventException
	 */		
	public List<FaTargetListVO> searchFATargetListBasic(MstEtcVO mstEtcVO) throws EventException;
	
	/** 
	 * EES_MST_0017 : save<br>
	 * Own Container Interface to ERP FA를 저장합니다. <br>
	 * @author LEE HO SUN
	 * @category EES_MST_0017
	 * @category updateCntrSendToFABasic 
	 * @param FaTargetListVO[] faTargetListVOs
	 * @param SignOnUserAccount		account
	 * @return List<FaTargetListVO>
	 * @exception EventException
	 */
    public List<FaTargetListVO> updateCntrSendToFABasic(FaTargetListVO[] faTargetListVOs, SignOnUserAccount account) throws EventException;	
    
	/** 
	 * EES_MST_0017 : save<br>
	 * Own Container Interface to ERP FA를 전송합니다. <br>
	 * @author LEE HO SUN
	 * @category EES_MST_0017
	 * @category sendToFABasic 
	 * @param List<FaTargetListVO> faTargetListVOs
	 * @exception EventException
	 */    
    public void sendToFABasic(List<FaTargetListVO> faTargetListVOs) throws EventException;
    
	/** 
	 * 해당 컨테이너의 장비 상태(Movement,Status) 정보를 저장한다.<br>
	 * 
	 * @param LostFoundVO[] lostFoundVOs
	 * @param SignOnUserAccount account
	 * @return List<LostFoundVO>
	 * @exception EventException
	 */	
    public List<LostFoundVO> manageLostFoundBasic(LostFoundVO[] lostFoundVOs, SignOnUserAccount account) throws EventException;
    
	/**
	 * Immediate Exit Creation 대상 장비목록을 일괄 갱신합니다.<br>
	 * 
	 * @param ImmediateExitCreationVO[] immediateExitCreationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateImmediateExitCreationListBasic(ImmediateExitCreationVO[] immediateExitCreationVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Term Change Creation 대상 장비목록을 일괄 저장합니다.<br>
	 * 
	 * @param TermChangeCreationVO[] termChangeCreationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createTermChangeCreationListBasic(TermChangeCreationVO[] termChangeCreationVOs, SignOnUserAccount account) throws EventException;
	
	/** 
	 * EES_MST_0028 : retrieve <br>
	 * Container Status Update를 조회합니다.
	 * @author LEE HO SUN
	 * @category EES_MST_0028
	 * @category searchCntrStatusUpdateTargetBasic 
	 * @param MstEtcVO mstEtcVO
	 * @return StatusUpdateGRPVO
	 * @exception EventException
	 */
	public StatusUpdateGRPVO searchCntrStatusUpdateTargetBasic(MstEtcVO mstEtcVO) throws EventException;
	
	/** 
	 * EES_MST_0028 : save <br>
	 * Container Status Update를 저장합니다.
	 * @author LEE HO SUN
	 * @category EES_MST_0028
	 * @category manageCntrStatusUpdateBasic  
	 * @param StatusHistoryVO[] statusHistoryVOs
	 * @param SignOnUserAccount		account
	 * @exception EventException
	 */
    public void manageCntrStatusUpdateBasic(StatusHistoryVO[] statusHistoryVOs, SignOnUserAccount account) throws EventException;
	
	/** 
	 * EES_MST_0028 : save <br>
	 * Container Status Update를 저장합니다.
	 * @author LEE HO SUN
	 * @category EES_MST_0028
	 * @category modifyCntrMasterByUpdateBasic   
	 * @param StatusHistoryVO statusHistoryVO
	 * @param SignOnUserAccount		account
	 * @exception EventException
	 */	    
    public void modifyCntrMasterByUpdateBasic(StatusHistoryVO statusHistoryVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * CIM/CTM 에서 요청한 Master 정보를 수정합니다.<br>
	 * 
	 * @param crossItemVO CrossItemVO  
	 * @return String
	 * @exception EventException
	 */
	public String updateCntrMasterByMvmtBasic(CrossItemVO crossItemVO) throws EventException;		
	
	
	/**
	 * On hire Approval  된 OW Term 컨테이너에 Approval Number 를 Update 시킨다.<br>
	 * 
	 * @param OnhireApprovalOwnListVO[] onhireApprovalOwnListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateAuthNoBasic(OnhireApprovalOwnListVO[] onhireApprovalOwnListVOs, SignOnUserAccount account) throws EventException;
	
	/** 
	 * FNS026R001 : EAI receive
	 * FNS026R001을 호출하여 Receive합니다.<br>
	 * @author LEE HO SUN
	 * @category FNS0260001
	 * @category receiveFABasic    
	 * @param CntrMasterUpdateIFVO[] cntrMasterUpdateIFVOs
	 * @param SignOnUserAccount		account
	 * @exception EventException
	 */
    public void receiveFABasic(CntrMasterUpdateIFVO[] cntrMasterUpdateIFVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Miss Use Approval 된 컨테이너르 Status를 추가시킨다.<br>
	 * 
	 * @param IFMnrFlagVO[] iFMnrFlagVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void createMNRStatusBasic(IFMnrFlagVO[] iFMnrFlagVOs, SignOnUserAccount account) throws EventException;	
	
	/**
	 * CTM 에서 요청한 Master 정보를 수정한다.<br>
	 * 
	 * @param IFGateVO[] iFGateVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */			
	public void createMvmtBasic(IFGateVO[] iFGateVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 *  장기체화장비(L/Staying) 및 Unclaim 장비 Flag 와 해소 방안을 등록한다.<br>
	 * 
	 * @param LongStayUclmDetailVO[] longStayUclmDetailVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateCntrMasterByLongStayCreationBasic(LongStayUclmDetailVO[] longStayUclmDetailVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * EES_MST_0046 : retrieve <br>
	 * Manufacture Date & Manufacturer Inquiry and Update를 조회합니다.
	 * @author LEE HO SUN
	 * @category EES_MST_0046
	 * @category searchCntrManufactureInfoBasic 
	 * @param CntrManufactureListVO[] cntrManufactureListVOs
	 * @return List<CntrManufactureInfoVO> 
	 * @exception EventException
	 */	
	public List<CntrManufactureInfoVO> searchCntrManufactureInfoBasic(CntrManufactureListVO[] cntrManufactureListVOs) throws EventException;
	
	/**
	 * EES_MST_0046 : save <br>
	 * Manufacture Date & Manufacturer Inquiry and Update를 수정합니다.
	 * @author LEE HO SUN
	 * @category EES_MST_0046
	 * @category modifyCntrManufactureInfoBasic 
	 * @param CntrManufactureInfoVO[] cntrManufactureInfoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
    public void modifyCntrManufactureInfoBasic(CntrManufactureInfoVO[] cntrManufactureInfoVOs, SignOnUserAccount account) throws EventException;
    
    /**
	 * EES_MST_0047 : retrieve <br>
	 * Reefer Unit Info Inquiry and Update를 조회합니다.
	 * @author NamKoong JinHo
	 * @category EES_MST_0047
	 * @category searchCntrReeferUnitInfoBasic 
	 * @param CntrReeferUnitListVO[] cntrReeferUnitListVOs
	 * @return List<CntrReeferUnitInfoVO> 
	 * @exception EventException
	 */	
	public List<CntrReeferUnitInfoVO> searchCntrReeferUnitInfoBasic(CntrReeferUnitListVO[] cntrReeferUnitListVOs) throws EventException;
	
	/**
	 * EES_MST_0047 : save <br>
	 * Reefer Unit Info Inquiry and Update를 수정합니다.
	 * @author NamKoong JinHo
	 * @category EES_MST_0047
	 * @category modifyCntrReeferUnitInfoBasic 
	 * @param CntrReeferUnitInfoVO[] cntrReeferUnitInfoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
    public void modifyCntrReeferUnitInfoBasic(CntrReeferUnitInfoVO[] cntrReeferUnitInfoVOs, SignOnUserAccount account) throws EventException;
    
	/** 
	 * EES_MST_28 : re-creation <br>
	 * Sold status를 re-cration하기 위한 정보를 조회처리합니다.<br>
	 * @author Sang-bo La
	 * @category EES_MST_0028
	 * @param IFMnrFlagVO iFMnrFlagVO
	 * @return IFMnrFlagVO
	 * @exception EventException
	 */	
	public IFMnrFlagVO searchSoldStatusBasic(IFMnrFlagVO iFMnrFlagVO) throws EventException;
	
	/** 
	 * EES_MST_28 : save <br>
	 * CNTR STS 삭제 시 MST_CONTAINER의 정보도 삭제합니다.<br>
	 * @author Sang-bo La
	 * @category EES_MST_0028
	 * @param String CntrNo
	 * @exception EventException
	 */	
	public void removeMstContainerBasic(String CntrNo) throws EventException;
}