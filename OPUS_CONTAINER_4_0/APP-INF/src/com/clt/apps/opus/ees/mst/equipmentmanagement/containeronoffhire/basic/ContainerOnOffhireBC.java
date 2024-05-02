/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerOnOffhireBC.java
*@FileTitle : ContainerOnOffhire
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic;

import java.util.List;

import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.LongStayUclmDetailVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.vo.ImmediateExitCreationVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalOwnListVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.TermChangeCreationVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.ApprovalListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrLotVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureInfoVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterInquiryVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrReeferUnitInfoVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrReeferUnitListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrStatusCreationVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.FACntrListInfoVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.IFGateVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.LeasedCntrVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.LostFoundVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.LotNoListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.MstEtcVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusHistoryVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusUpdateGRPVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.FaTargetListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterUpdateIFVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.CommonListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Equipmentmanagement Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_mst_0032EventResponse
 * @since J2EE 1.6
 */

public interface ContainerOnOffhireBC {

    /**
     * creating Own Container<br> 
     * 
     * @param  CntrLotVO cntrLotVO
     * @param  SignOnUserAccount account
     * @return CntrLotVO
     * @throws EventException
     */
    public CntrLotVO createOwnCntrBasic(CntrLotVO cntrLotVO, SignOnUserAccount account) throws EventException;
 
    /**
     * retrieving for Lot No of Own Container<br>
     * 
     * @category EES_MST_0016_01
     * @category searchLotInfoBasic
     * 
     * @param	CntrLotVO cntrLotVO
     * @return	CntrLotVO
     * @throws EventException
     */    
    public CntrLotVO searchLotInfoBasic(CntrLotVO cntrLotVO) throws EventException;
    
    
    /**
     * modifying Own Container<br>
     *  
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
	 * retrieving for Container Master Inquiry, Container Master Update<br>
	 * @category EES_MST_0019, EES_MST_0044
	 * @category searchCntrMasterInquiryBasic    
	 * @param MstEtcVO   mstEtcVO
	 * @param SignOnUserAccount account
	 * @return CntrMasterInquiryVO
	 * @exception EventException
	 */ 
	 public CntrMasterInquiryVO searchCntrMasterInquiryBasic(MstEtcVO mstEtcVO, SignOnUserAccount account) throws EventException;
	
	/** 
	 * EES_MST_0014 : retrieve <br>
	 * retrieving for Leased Container<br>
	 * @category EES_MST_0014
	 * @category searchApprovalListBasic    
	 * @param mstEtcVO   MstEtcVO
	 * @return List<CntrMasterInquiryVO>
	 * @exception EventException
	 */
	 public List<ApprovalListVO> searchApprovalListBasic(MstEtcVO mstEtcVO) throws EventException;
	 
	/** 
	 * EES_MST_0014 : save <br>
	 * saving Leased Container<br>
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
	 * saving Container Master Update <br>
	 * @category EES_MST_0044
	 * @category modifyCntrMasterBasic  
	 * @param MstEtcVO mstEtcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
    public void modifyCntrMasterBasic(MstEtcVO mstEtcVO, SignOnUserAccount account) throws EventException; 
    
	/** 
	 * retrieving for Lot No Inquiry <br>
	 * 
	 * @category EES_MST_0038
	 * @category searchLotNoListBrieflyBasic	 
	 * 
	 * @param MstEtcVO mstEtcVO
	 * @return List<LotNoListVO>
	 * @exception EventException
	 */	
    public List<LotNoListVO> searchLotNoListBrieflyBasic(MstEtcVO mstEtcVO) throws EventException;
    
    
	/** 
	 * retrieving for Movement,Status of lost and found CNTR<br>
	 * 
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
	 * retrieving for Container Status Creation <br>
	 * @category EES_MST_0024
	 * @category searchLeaseOutTargetListBasic  
	 * @param CntrStatusCreationVO[] cntrStatusCreationVOs
	 * @return List<CntrStatusCreationVO>
	 * @exception EventException
	 */	
	public List<CntrStatusCreationVO> searchLeaseOutTargetListBasic(CntrStatusCreationVO[] cntrStatusCreationVOs) throws EventException;
	
	/** 
	 * EES_MST_0024 : save <br>
     * saving Container Status Creation<br>
	 * @category EES_MST_0024
	 * @category manageCntrStatusCreationBasic
	 * @param CntrStatusCreationVO[] cntrStatusCreationVOs
	 * @param SignOnUserAccount account
	 * @return List<CntrStatusCreationVO>
	 * @exception EventException
	 */	
	public List<CntrStatusCreationVO> manageCntrStatusCreationBasic(CntrStatusCreationVO[] cntrStatusCreationVOs, SignOnUserAccount account) throws EventException ;
	
    
	/** 
	 * saving for Movement,Status of lost and found CNTR<br>
	 * 
	 * @param LostFoundVO[] lostFoundVOs
	 * @param SignOnUserAccount account
	 * @return List<LostFoundVO>
	 * @exception EventException
	 */	
    public List<LostFoundVO> manageLostFoundBasic(LostFoundVO[] lostFoundVOs, SignOnUserAccount account) throws EventException;
    
	/**
	 * updating Immediate Exit Creation<br>
	 * 
	 * @param ImmediateExitCreationVO[] immediateExitCreationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateImmediateExitCreationListBasic(ImmediateExitCreationVO[] immediateExitCreationVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * saving Term Change Creation<br>
	 * 
	 * @param TermChangeCreationVO[] termChangeCreationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createTermChangeCreationListBasic(TermChangeCreationVO[] termChangeCreationVOs, SignOnUserAccount account) throws EventException;
	
	/** 
	 * EES_MST_0028 : retrieve <br>
	 * retrieving for Container Status Update
	 * @category EES_MST_0028
	 * @category searchCntrStatusUpdateTargetBasic 
	 * @param MstEtcVO mstEtcVO
	 * @param SignOnUserAccount account
	 * @return StatusUpdateGRPVO
	 * @exception EventException
	 */
	public StatusUpdateGRPVO searchCntrStatusUpdateTargetBasic(MstEtcVO mstEtcVO , SignOnUserAccount account) throws EventException;
	
	
	/**
	 * EES_MST_0028 : retrieve <br>
	 * retrieving for Container Status Update
	 * @category EES_MST_0028
	 * @category searchCntrStatusSearchTargetBasic 
	 * @param MstEtcVO mstEtcVO
	 * @return StatusUpdateGRPVO
	 * @exception EventException
	 */	
	public StatusUpdateGRPVO searchCntrStatusSearchTargetBasic(MstEtcVO mstEtcVO) throws EventException;
	
	
	/** 
	 * EES_MST_0028 : save <br>
	 * saving Container Status Update
	 * @category EES_MST_0028
	 * @category searchCntrStatusUpdateChkBasic  
	 * @param StatusHistoryVO[] statusHistoryVOs
	 * @param SignOnUserAccount		account
	 * @return String
	 * @exception EventException
	 */
	public String searchCntrStatusUpdateChkBasic(StatusHistoryVO[] statusHistoryVOs, SignOnUserAccount account) throws EventException;
	
	/** 
	 * EES_MST_0028 : save <br> 
	 * saving Container Status Update
	 * @category EES_MST_0028
	 * @category manageCntrStatusUpdateBasic  
	 * @param StatusHistoryVO[] statusHistoryVOs
	 * @param SignOnUserAccount		account
	 * @exception EventException
	 */
    public void manageCntrStatusUpdateBasic(StatusHistoryVO[] statusHistoryVOs, SignOnUserAccount account) throws EventException; 
	
	/** 
	 * EES_MST_0028 : save <br>
	 * saving Container Status Update
	 * @author LEE HO SUN
	 * @category EES_MST_0028
	 * @category modifyCntrMasterByUpdateBasic   
	 * @param StatusHistoryVO statusHistoryVO
	 * @param SignOnUserAccount		account
	 * @exception EventException
	 */	    
    public void modifyCntrMasterByUpdateBasic(StatusHistoryVO statusHistoryVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * updationg CNTR Master Information required from CIM/CTM<br>
	 * 
	 * @param crossItemVO CrossItemVO  
	 * @return String
	 * @exception EventException
	 */
	public String updateCntrMasterByMvmtBasic(CrossItemVO crossItemVO) throws EventException;		
	
	
	/**
	 * updating Approval Number of OW Term CNTR On hire Approval<br>
	 * 
	 * @param OnhireApprovalOwnListVO[] onhireApprovalOwnListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateAuthNoBasic(OnhireApprovalOwnListVO[] onhireApprovalOwnListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * creating CNTR Status in Miss Use Approval<br>
	 * 
	 * @param IFMnrFlagVO[] iFMnrFlagVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void createMNRStatusBasic(IFMnrFlagVO[] iFMnrFlagVOs, SignOnUserAccount account) throws EventException;	
	
	/**
	 * modifying CNTR Master Information required from CTM<br>
	 * 
	 * @param IFGateVO[] iFGateVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */			
	public void createMvmtBasic(IFGateVO[] iFGateVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 *  updating L/Staying, Unclaim Flag<br>
	 * 
	 * @param LongStayUclmDetailVO[] longStayUclmDetailVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateCntrMasterByLongStayCreationBasic(LongStayUclmDetailVO[] longStayUclmDetailVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * EES_MST_0046 : retrieve <br>
	 * retrieving for Manufacture Date & Manufacturer Inquiry and Update
	 * @category EES_MST_0046
	 * @category searchCntrManufactureInfoBasic 
	 * @param CntrManufactureListVO[] cntrManufactureListVOs
	 * @return List<CntrManufactureInfoVO> 
	 * @exception EventException
	 */	
	public List<CntrManufactureInfoVO> searchCntrManufactureInfoBasic(CntrManufactureListVO[] cntrManufactureListVOs) throws EventException;
	
	/**
	 * EES_MST_0046 : save <br>
	 * modifying Manufacture Date & Manufacturer Inquiry and Update
	 * @category EES_MST_0046
	 * @category modifyCntrManufactureInfoBasic 
	 * @param CntrManufactureInfoVO[] cntrManufactureInfoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
    public void modifyCntrManufactureInfoBasic(CntrManufactureInfoVO[] cntrManufactureInfoVOs, SignOnUserAccount account) throws EventException;
    
    /**
	 * EES_MST_0047 : retrieve <br>
	 * retriving for Reefer Unit Info Inquiry and Update
	 * @category EES_MST_0047
	 * @category searchCntrReeferUnitInfoBasic 
	 * @param CntrReeferUnitListVO[] cntrReeferUnitListVOs
	 * @return List<CntrReeferUnitInfoVO> 
	 * @exception EventException
	 */	
	public List<CntrReeferUnitInfoVO> searchCntrReeferUnitInfoBasic(CntrReeferUnitListVO[] cntrReeferUnitListVOs) throws EventException;
	
	/**
	 * EES_MST_0047 : save <br>
	 * saving Reefer Unit Info Inquiry and Update
	 * @category EES_MST_0047
	 * @category modifyCntrReeferUnitInfoBasic 
	 * @param CntrReeferUnitInfoVO[] cntrReeferUnitInfoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
    public void modifyCntrReeferUnitInfoBasic(CntrReeferUnitInfoVO[] cntrReeferUnitInfoVOs, SignOnUserAccount account) throws EventException;
    
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
     * retrieving for Lot No of Own Container<br>
     * 
     * @category EES_MST_0016_01
     * @category searchValidaionSpecNoTpsz
     * 
     * @param	CntrLotVO cntrLotVO
     * @return	CntrLotVO
     * @throws EventException
     */    
    public CntrLotVO searchValidaionSpecNoTpsz(CntrLotVO cntrLotVO) throws EventException;
    
	/**                       
	 * retrieving for Eq Type Size List of Agreement<br>
	 * 
	 * @param MstEtcVO mstEtcVO
	 * @return List<MstEtcVO>
	 * @exception EventException
	 */
	public List<MstEtcVO> searchEqTypeSizeListOfAgmt(MstEtcVO mstEtcVO) throws EventException;
	
    /** 
	 * Searching Container List Information of Interface to ERP FA
	 *
	 * @param MstEtcVO mstEtcVO
	 * @return List<FACntrListInfoVO>
	 * @exception EventException
	 */	
	public List<FACntrListInfoVO> searchFACntrListInfo(MstEtcVO mstEtcVO) throws EventException;
	
    /**
	 * retrieving for Lot No of Own Container<br>
	 * 
     * @category EES_MST_0016_01
     * @category searchLotInfoBasic
     * 
     * @param	String cntrNo
     * @param   String hireDate
     * @return	String 
	 * @exception EventException
	 */
    public String  checkBackDatebyCntr(String cntrNo, String hireDate) throws EventException;
    
}