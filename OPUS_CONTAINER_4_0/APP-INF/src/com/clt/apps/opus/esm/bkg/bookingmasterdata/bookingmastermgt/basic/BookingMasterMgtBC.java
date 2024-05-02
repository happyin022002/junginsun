/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtBC.java
*@FileTitle : Booking Creation 1_MT P/UP CY inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlBlGrpCustVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlBlGrpVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlPtyBlGrpVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlPtyVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCustTmpltVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEqlzPortVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHandlingOfficeSetupVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHrdCdgDescVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgInetBlCtrlPtyVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMdtItmVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgSalesRepVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ChnMnlBkgNoGenCondVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.HrdCdgCtnt2VO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.MandatoryItemSetupListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRPolVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeTableVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchCmdtCdRepCmdtCdVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.HrdCdgDesc2VO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchInBoundCustListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchWareHouseVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.VskVslPortSkdConditionVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdSchVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgChnBkgNoGenVO;
import com.clt.syscommon.common.table.BkgCoffTmVO;
import com.clt.syscommon.common.table.BkgCustCntcPsonVO;
import com.clt.syscommon.common.table.BkgDpcsUsrGrpVO;
import com.clt.syscommon.common.table.BkgHamoTrfVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgMTPickupCYVO;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmPckTpVO;

/**
 * Bookingmasterdata Business Logic Command Interface<br>
 * - Interface of Business Logic for Bookingmasterdata<br>
 *
 * @author Kim Ki Jong
 * @see Esm_bkg_0082EventResponse reference
 * @since J2EE 1.4
 */

public interface BookingMasterMgtBC {
	

	
	/**
	 * Booking Creation 1_MT P/UP CY inquiry (ESM_BKG-0082) <br>
	 * 
	 * @param String YardCode
	 * @param String Today
	 * @return List<BkgMTPickupCYVO> 
	 * @exception EventException
	 */
	public List<BkgMTPickupCYVO> searchMTPickUpCY(String YardCode,String Today) throws EventException;
	
	
	/**
	 * retrieve event processing<br>
	 * HTS (Harmonized Tariff Schedule) Code (ESM_BKG_0607)<br>
	 * 
	 * @param BkgHamoTrfVO   vo
	 * @return List<BkgHamoTrfVO>
	 * @exception EventException
	 */
	public List<BkgHamoTrfVO> searchHTSCode(BkgHamoTrfVO vo) throws EventException;
	
	/**
	 * retrieve event processing<br>
	 * HTS (Harmonized Tariff Schedule) Code (ESM_BKG-0079_07)<br>
	 * 
	 * @param String hsCd
	 * @param String hsAplyDt
	 * @param String hamoTpCd
	 * @return String hsCdRslt
	 * @exception EventException
	 */
	public String validateHsCd(String hsCd, String hsAplyDt, String hamoTpCd) throws EventException;
	
	/**
	 * add/modify/delete event processing<br>
	 * HTS (Harmonized Tariff Schedule) Code (ESM_BKG_0607_C)<br>
	 * 
	 * @param BkgHamoTrfVO[] bkgHamoTrfVOs
	 * @param String usrId  
	 * @exception EventException
	 * @throws DAOException 
	 */
	public void manageHtsCode(BkgHamoTrfVO[] bkgHamoTrfVOs, String usrId ) throws EventException, DAOException;   
	
	
	/**
	 * Customer Inquiry Save event processing(ESM_BKG_0652)<br>
	 * manage Customer Person info.<br>
	 * 
	 * @param BkgCustCntcPsonVO[] bkgCustCntcPsonVOs 
	 * @param String userId
	 * @exception EventException
	 */
	public void manageCustContact(	BkgCustCntcPsonVO[] bkgCustCntcPsonVOs, 
														String userId	) throws EventException;		
	
	/**
	 * Vessel code and SKD retrieve  <br>
	 *  
	 * @param VskVslPortSkdConditionVO   vo
	 * @return List<VskVslPortSkdConditionVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdConditionVO> searchEtbEtdEta(	VskVslPortSkdConditionVO vo	) throws EventException;
	
	
	/**
	 * Package Code and Description retrieve(ESM_BKG_0755,ESM_BKG_0696) <br>
	 * 
	 * @param MdmPckTpVO   vo
	 * @return List<MdmPckTpVO>
	 * @exception EventException
	 */
	public List<MdmPckTpVO> searchPackageCode(	MdmPckTpVO vo	) throws EventException;
	
	/**
	 * Retrieve Code for Commodity Code input(ESM_BKG_0653) <br>
	 *  
	 * @param SearchCmdtCdRepCmdtCdVO   vo
	 * @return List<SearchCmdtCdRepCmdtCdVO>
	 * @exception EventException
	 */
	public List<SearchCmdtCdRepCmdtCdVO> searchCmdtCdRepCmdtCd(	SearchCmdtCdRepCmdtCdVO vo	) throws EventException;
	
	/**
	 * Warehouse (Bonded Area) Creation retrieve(ESM_BKG_0554)   <br>
	 *  
	 * @param String cuntryCd
	 * @param String wareHouse
	 * 
	 * @return List<SearchWareHouseVO>
	 * @exception EventException
	 */
	public List<SearchWareHouseVO> searchWareHouse(String cuntryCd , String wareHouse) throws EventException ;

	/**
	 * Warehouse (Bonded Area) Creation save event processing(ESM_BKG_0554)<br>
	 * Manage Warehouse (Bonded Area) info.<br>
	 * 
	 * @param SearchWareHouseVO searchWareHouseVO
	 * @exception EventException
	 */
	public void manageWareHouse(	SearchWareHouseVO searchWareHouseVO) throws EventException;
	
	
	/**
	 * retrieve-Screen is BDR Processing by Manual (ESM_BKG_0596)   <br>
	 * 
	 * @param SearchBDRTimeVO   vo
	 * @return List<SearchBDRTimeVO>
	 * @exception EventException
	 */
	public List<SearchBDRTimeVO> searchBDRTime(SearchBDRTimeVO vo) throws EventException ;
	
	
	/**
	 * Vessesl Schedule B/L Data Release save event processing<br>
	 * BKG_BL_DOC BDR processing.<br>
	 * 
	 * @param SearchBDRTimeVO vo
	 * @exception EventException
	 */	
	public void modifyBDRLog(SearchBDRTimeVO vo) throws EventException ;
	
	/**
	 * vvd check (ESM_BKG_0596)<br>
	 * 
	 * @param SearchBDRTimeVO vo
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkBDRVVDPOL(SearchBDRTimeVO vo) throws EventException ;
	
	/**
	 * @category ESM_BKG_1004
	 * @category searchDPSCUserGroup
	 * DPCS - Search S/R business processing contact person Group info <br>
	 * 
	 * @param String usrId
	 * @param String dpcsWrkGrpCd
	 * @param BkgDpcsUsrGrpVO   vo
	 * @return List<BkgDpcsUsrGrpVO>
	 * @exception EventException
	 */
	public List<BkgDpcsUsrGrpVO> searchDPSCUserGroup(String usrId, String dpcsWrkGrpCd,BkgDpcsUsrGrpVO vo) throws EventException;

	/**
	 * booking close for bayplan info save.<br>
	 * 
	 * @param BkgCoffTmVO[] bkgCoffTmVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void closeBKGForBayPlan(BkgCoffTmVO[] bkgCoffTmVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * booking reopen for bayplan info save.<br>
	 * 
	 * @param BkgCoffTmVO[] bkgCoffTmVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void reopenBkgForBayPlan(BkgCoffTmVO[] bkgCoffTmVO, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieve Lane of BDR TIME register screen(ESM_BKG_0073)<br>
	 * 
	 * @param SearchBDRPolVO vo
	 * @return List<SearchBDRPolVO>
	 * @exception EventException
	 */
	public List<SearchBDRPolVO> searchBDRPol(SearchBDRPolVO vo) throws EventException ;
	
	/**
	 * BDR Time Table retrieve event processing(ESM_BKG_0073) <br>
	 * 
	 * @param SearchBDRTimeTableVO   vo
	 * @return List<SearchBDRTimeTableVO>
	 * @exception EventException
	 */
	public List<SearchBDRTimeTableVO> searchBDRTimeTable(SearchBDRTimeTableVO vo) throws EventException ;
	
	
	/**
	 * BDR Time management save event processing.(ESM_BKG_0073)<br>
	 * Manage registered BDR by Time Lane/Bound/From Location/To Location standard..<br>
	 * 
	 * @param SearchBDRPolVO[] vos1
	 * @param SearchBDRTimeTableVO[] vos2
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVVDBDRTime(SearchBDRPolVO[] vos1,SearchBDRTimeTableVO[] vos2,SignOnUserAccount account) throws EventException ;
	
	/**
	 * Equalization Port register screen retrieve event processing(ESM_BKG_0253)<br>

	 * @param BkgEqlzPortVO vo
	 * @return List<BkgEqlzPortVO>
	 * @throws EventException
	 */
	public List<BkgEqlzPortVO> searchEqualizetionPortCD (BkgEqlzPortVO vo) throws EventException;
	 
	/**
	 * Equalization Port register management save event processing (ESM_BKG-0253) <br>
	 * 
	 * @param BkgEqlzPortVO[] vos
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void manageEqualizationPort(BkgEqlzPortVO[] vos,SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 0192 B/L Customer Information in CRM retrieve 
	 * @param SearchInBoundCustListVO searchInBoundCustListVO
	 * @return List<SearchInBoundCustListVO>
	 * @throws EventException
	 */
	public List<SearchInBoundCustListVO> searchInBoundCustList(SearchInBoundCustListVO searchInBoundCustListVO) throws EventException ;
	 
	 /**
	  *  0192 B/L Customer Information in CRM Template retrieve	
	  * @param BkgCustTmpltVO bkgCustTmpltVO
	  * @return List<BkgCustTmpltVO>
	  * @throws EventException
	  */
	 public List<BkgCustTmpltVO> searchInBoundCustTmpltList(BkgCustTmpltVO bkgCustTmpltVO) throws EventException;

	 /**
     * multi event processing<br>
     * 0192 B/L Customer Information in CRM Template transaction processing
     * 
     * @param BkgCustTmpltVO[] bkgCustTmpltVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageInBoundCustList(BkgCustTmpltVO[] bkgCustTmpltVO,SignOnUserAccount account) throws EventException;	 
	 
	
    /**
	 * China Booking Agent info register screen-retrieve event processing (ESM_BKG-0153)<br>
	 * 
	 * @param BkgChinaAgentVO vo
	 * @return List<BkgChinaAgentVO>
	 * @throws EventException
	 */
	public List<BkgChinaAgentVO> searchChinaAgentCodeList (BkgChinaAgentVO vo) throws EventException;
	
	/**
	 * China Booking Agent info register screen save event processing(ESM_BKG-0153)  <br>

	 * @param BkgChinaAgentVO[] vos
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void manageChinaAgentCode(BkgChinaAgentVO[] vos,SignOnUserAccount account) throws EventException;
	
	/**
	 * BKG_VVD_BDR_LOG TABLE save event processing by Vessel Port Schedule change <br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @exception EventException
	 */
	public void manageBkgVVDBdrLog(String vslCd, String skdVoyNo, String skdDirCd) throws EventException;
	
	/**
	 * Customer Sales Rep interlock management <br>
	 * 
	 * @param String message
	 * @exception EventException
	 */
	public void manageBkgCustSlsRep(String message) throws EventException;
	
	/**
	 * BKG_DOC_CLZ_SET TABLE(Documentation Cut-off Time)  retrieve.<br>
	 * @param ydCd
	 * @param vslSlanCd
	 * @param deltFlg
	 * @return
	 * @throws EventException
	 */
	public List<BkgdocClzSetListVO> searchDocCutOffTimeList(String ydCd, String vslSlanCd, String deltFlg) throws EventException;
	
	
	/**
	 * COUNTRY CODE,NAME  retrieve.<br>
	 * 
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> searchCntCdNm() throws EventException;
	
	/**
	 * Documentation Cut-off Time save.<br>
	 * 
	 * @param BkgdocClzSetVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDocCutOffTimeList(BkgdocClzSetVO[] vos,SignOnUserAccount account) throws EventException;
	
	/**
	 * Mandatory Item(s) Setup for Customized Service  SAVE.<br>
	 * 
	 * @param MandatoryItemSetupListVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMandatoryItemSetupList(MandatoryItemSetupListVO[] vos,SignOnUserAccount account) throws EventException;
	
	/**
	 * Mandatory Item(s) Setup for Customized Service  Retrieve.<br>
	 * 
	 * @param BkgMdtItmVO vo
	 * @return List<BkgMdtItmVO>
	 * @exception EventException
	 */
	public List<BkgMdtItmVO> searchMandatoryItemSetupList(BkgMdtItmVO vo) throws EventException;
	
	/**
	 * BKG_EDI_TRD_PRNR_SUB_LNK interlock processing.
	 * 
	 * @param String message
	 * @exception EventException
	 */
	public void receiveBkgEdiTrdPrnrSubLnk(String message) throws EventException;

	/**
	 * BKG_EDI_SUB_LNK_MSG interlock processing.
	 * 
	 * @param String message
	 * @exception EventException
	 */
	public void receiveBkgEdiSubLnkMsg(String message) throws EventException;

	/**
	 * BKG_EDI_PRNR_PORT_LANE interlock processing.
	 * 
	 * @param String message
	 * @exception EventException
	 */
	public void receiveBkgEdiPrnrPortLane(String message) throws EventException;


	/**
	 * North China Manual Booking No creation present condition retrieve.<br>
	 * 
	 * @param ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO
	 * @return List<BkgChnBkgNoGenVO>
	 * @exception EventException
	 */
	public List<BkgChnBkgNoGenVO> searchChnMnlBkgNoGenList(
			ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO) throws EventException;

	/**
	 * pre creation Booking Number for North China Agent<br>
	 * 
	 * @param ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO
	 * @param SignOnUserAccount account
	 * @return List<BkgChnBkgNoGenVO>
	 * @exception EventException
	 */
	public List<BkgChnBkgNoGenVO> createChnMnlBkgNoGenList(
			ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO, SignOnUserAccount account) throws EventException;

	/**
	 * use check when pre created north china BKG NO use<br>
	 * 
	 * @param List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVOs
	 * @param String bkgPorCd 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyChnBkgNoUseFlgOnList(List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVOs, String bkgPorCd, SignOnUserAccount account) throws EventException;
	
	/**
	 * manageBkgEdiGrp<br>
	 * 
	 * @param String str
	 * @exception EventException
	 */
	public void manageBkgEdiGrp(String str) throws EventException;

	/**
	 * manageBkgEdiGrpCust<br>
	 * 
	 * @param String str
	 * @exception EventException
	 */
	public void manageBkgEdiGrpCust(String str) throws EventException;

	/**
	 * retrieve BDR LOG FLAG of VVD at BKG . <br>
	 * 
	 * @param String vvdCd
	 * @param String polCd
	 * @param String podCd
	 * @param String rdoTrunkFeeder
	 * @return String
	 * @throws EventException
	 */
	public String checkVvdBdrLog(String vvdCd,String polCd,String podCd, String rdoTrunkFeeder ) throws EventException ;
 
	/**
	 * retrieve bkgNo whether china agent bkg no or not .<br>
	 * 
	 * @param 	String bkgNo
	 * @return 	String 
	 * @exception EventException
	 */	
	public String searchIsChnMnlBkgNo(String bkgNo) throws EventException ;
	
	/**
	 * Retrieve processing.<br>
	 * 
	 * @param ZipCdSchVO vo
	 * @return List<ZipCdListVO>
	 * @exception EventException
	 */
	public List<ZipCdListVO> searchZipCode(ZipCdSchVO vo) throws EventException;
	
	/**
	 * Save zip code..<br>
	 * 
	 * @param ZipCdListVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageZipCode(ZipCdListVO[] vos,SignOnUserAccount account) throws EventException;


	/**
	 * SalesRep info save/modify.<br>
	 * 
	 * @param BkgSalesRepVO[] bkgSalesRepVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSalesRep(BkgSalesRepVO[] bkgSalesRepVOs, SignOnUserAccount account) throws EventException;
	

    /**
     * select Hard Coding Setup List
     * @param BkgHrdCdgDescVO bkgHrdCdgDescVO
     * @return List<BkgHrdCdgDescVO>
     * @throws EventException
     */
    public List<BkgHrdCdgDescVO> searchHrdCdgDesc(BkgHrdCdgDescVO bkgHrdCdgDescVO) throws EventException;
    
	/**Hard Coding Setup List Insert, Update, Delete.
	 * @param BkgHrdCdgDescVO[] bkgHrdCdgDescVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageHrdCdgDesc(BkgHrdCdgDescVO[] bkgHrdCdgDescVOs,SignOnUserAccount account) throws EventException;

	/**
	 * select Hard Coding Contents List
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws EventException
	 */
	public List<BkgHrdCdgCtntVO> searchHrdCdgCtnt(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException;
	
	/**
	 * Hard Coding contents List Insert, Update, Delete.
	 * @param BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageHrdCdgCtnt(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs,SignOnUserAccount account) throws EventException;

	/**check if there is the same Hardcoding Id in DB
	 * @param String hrdCdgId
	 * @return String
	 * @throws EventException
	 */
	public String checkHrdCdgId(String hrdCdgId) throws EventException;
	

	/**check if there is data on Hard coding contents
	 * @param hrdCdgId
	 * @return String
	 * @throws EventException
	 */
	public String checkChildCnt(String hrdCdgId) throws EventException;
	
	/**
	 * select Controlling Party List
	 * @param BkgCtrlPtyVO bkgCtrlPtyVO
	 * @return List<BkgCtrlPtyVO>
	 * @throws EventException
	 */
	public List<BkgCtrlPtyVO> searchControllingPartyList(BkgCtrlPtyVO bkgCtrlPtyVO) throws EventException;
	
	/**
	 * select Internet B/L Control  List
	 * @param BkgCtrlPtyVO bkgCtrlPtyVO
	 * @return List<BkgInetBlCtrlPtyVO>
	 * @throws EventException
	 */
	public List<BkgInetBlCtrlPtyVO> searchInernettBlControlPartyList(BkgCtrlPtyVO bkgCtrlPtyVO) throws EventException;

	/**
	 * select BL Group List
	 * @param BkgCtrlPtyVO bkgCtrlPtyVO
	 * @return List<BkgCtrlPtyBlGrpVO>
	 * @throws EventException
	 */
	public List<BkgCtrlPtyBlGrpVO> searchBlGroupList(BkgCtrlPtyVO bkgCtrlPtyVO) throws EventException;
	
	/**
	 * insert/update/delete Controlling Party, Internet B/L Control, BL Group 
	 * @param BkgCtrlPtyVO[] bkgCtrlPtyVOs
	 * @param BkgInetBlCtrlPtyVO[] bkgInetBlCtrlPtyVOs
	 * @param BkgCtrlPtyBlGrpVO[] bkgCtrlPtyBlGrpVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageControllingParty(BkgCtrlPtyVO[] bkgCtrlPtyVOs, BkgInetBlCtrlPtyVO[] bkgInetBlCtrlPtyVOs,BkgCtrlPtyBlGrpVO[] bkgCtrlPtyBlGrpVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * searchBlGroupMasterList
	 * @param BkgCtrlBlGrpVO bkgCtrlBlGrpVO
	 * @return List<BkgCtrlBlGrpVO>
	 * @throws EventException
	 */
	public List<BkgCtrlBlGrpVO> searchBlGroupMasterList(BkgCtrlBlGrpVO bkgCtrlBlGrpVO) throws EventException;
	
	/**
	 * removeControllingParty
	 * @param BkgCtrlPtyVO[] bkgCtrlPtyVOs
	 * @throws EventException
	 */
	public void removeControllingParty(BkgCtrlPtyVO[] bkgCtrlPtyVOs) throws EventException;
	
	/**
	 * removeInernettBlControlParty
	 * @param BkgInetBlCtrlPtyVO[] bkgInetBlCtrlPtyVOs
	 * @throws EventException
	 */
	public void removeInernettBlControlParty(BkgInetBlCtrlPtyVO[] bkgInetBlCtrlPtyVOs) throws EventException;

	/**
	 * removeBlGroup
	 * @param BkgCtrlPtyBlGrpVO[] bkgCtrlPtyBlGrpVOs
	 * @throws EventException
	 */
	public void removeBlGroup(BkgCtrlPtyBlGrpVO[] bkgCtrlPtyBlGrpVOs) throws EventException;
	
	/**
	 * searchBlGroupCustomerList
	 * @param BkgCtrlBlGrpVO bkgCtrlBlGrpVO
	 * @return List<BkgCtrlBlGrpCustVO>
	 * @throws EventException
	 */
	public List<BkgCtrlBlGrpCustVO> searchBlGroupCustomerList(BkgCtrlBlGrpVO bkgCtrlBlGrpVO) throws EventException;
	
	/**
	 * insert/update/delete BL Group, Customer
	 * @param BkgCtrlBlGrpVO[] bkgCtrlBlGrpVOs
	 * @param BkgCtrlBlGrpCustVO[] bkgCtrlBlGrpCustVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageBlGroup(BkgCtrlBlGrpVO[] bkgCtrlBlGrpVOs, BkgCtrlBlGrpCustVO[] bkgCtrlBlGrpCustVOs, SignOnUserAccount account) throws EventException;

	/**
	 * removeBlGroupMaster
	 * @param BkgCtrlBlGrpVO[] bkgCtrlBlGrpVOs
	 * @throws EventException
	 */
	public void removeBlGroupMaster(BkgCtrlBlGrpVO[] bkgCtrlBlGrpVOs) throws EventException;
	
	/**
	 * removeBlGroupCustomer
	 * @param BkgCtrlBlGrpCustVO[] bkgCtrlBlGrpCustVOs
	 * @throws EventException
	 */
	public void removeBlGroupCustomer(BkgCtrlBlGrpCustVO[] bkgCtrlBlGrpCustVOs) throws EventException;
	 
	/**
	 * 북중국 Manual BKG No 선 생성 현황 생성 하기전 생성가능한 인지 B.Office 체크
	 * @param ofc
	 * @return
	 * @throws EventException
	 */
	public String searchOfcCheck(String ofc) throws EventException;
	
	/**
	 * 
	 * @param bkgHandlingOfficeSetupVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageHandlingOffice(BkgHandlingOfficeSetupVO[] bkgHandlingOfficeSetupVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * searchHandlingOffice
	 * @param BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO
	 * @return List<BkgHandlingOfficeSetupVO>
	 * @throws EventException
	 */
	public List<BkgHandlingOfficeSetupVO> searchHandlingOffice(BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO) throws EventException;
	
	/**
	 * BKG_CTRL_BL_GRP MAX SEQ
	 * @return
	 * @throws EventException
	 */
	public String selectMaxBlGroupSeq() throws EventException;
	
	/**
	 * BKG_CTRL_PTY MAX SEQ
	 * @return
	 * @throws EventException
	 */
	public String selectMaxCntrPtySeq() throws EventException;
	
	/**
     * select Hard Coding Setup List
     * @param HrdCdgDesc2VO hrdCdgDesc2VO
     * @return List<BkgHrdCdgDescVO>
     * @throws EventException
     */
    public List<HrdCdgDesc2VO> searchHrdCdgDesc2(HrdCdgDesc2VO hrdCdgDesc2VO) throws EventException;
    
    /**
	 * select Hard Coding Contents List
	 * @param HrdCdgCtnt2VO hrdCdgCtnt2VO
	 * @return List<HrdCdgCtnt2VO>
	 * @throws EventException
	 */
	public List<HrdCdgCtnt2VO> searchHrdCdgCtnt2(HrdCdgCtnt2VO hrdCdgCtnt2VO) throws EventException;
	
	/**
	 * Hard Coding contents List Insert, Update, Delete.
	 * @param HrdCdgCtnt2VO[] hrdCdgCtnt2VOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageHrdCdgCtnt(HrdCdgCtnt2VO[] hrdCdgCtnt2VOs,SignOnUserAccount account) throws EventException;
	
	/**check Duplicate Customer 
	 * @param BkgMdtItmVO[] bkgMdtItmVOs
	 * @return String
	 * @throws EventException
	 */
	public String checkDupCustCd(BkgMdtItmVO[] bkgMdtItmVOs) throws EventException;
	

}
