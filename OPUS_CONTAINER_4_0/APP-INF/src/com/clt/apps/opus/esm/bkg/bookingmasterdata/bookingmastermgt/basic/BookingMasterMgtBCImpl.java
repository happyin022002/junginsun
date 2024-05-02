/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtBCImpl.java
*@FileTitle : Booking Creation 1_MT P/UP CY inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration.BookingMasterMgtDBDAO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlBlGrpCustVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlBlGrpVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlPtyBlGrpVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlPtyVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCustTmpltVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiGrpCustVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiGrpVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiPrnrPortLaneVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiSubLnkMsgVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiTrdPrnrSubLnkVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEqlzPortVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHandlingOfficeSetupVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHrdCdgDescVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgInetBlCtrlPtyVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMdtItmVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgSalesRepVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ChnMnlBkgNoGenCondVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CustSlsRepVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.HrdCdgCtnt2VO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.HrdCdgDesc2VO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.MandatoryItemSetupListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRPolVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeTableVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchCmdtCdRepCmdtCdVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchInBoundCustListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchWareHouseVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.VskVslPortSkdConditionVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdSchVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.xmldocuments.XMLDocumentException;
import com.clt.framework.component.util.xmldocuments.XMLDocumentUtils;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.irep.enisEsd.ESD0320001Document;
import com.clt.irep.enisEsd.ESD0320001Document.ESD0320001.DataArea.EDIGroupCollection.EDIGroup;
import com.clt.irep.enisEsd.ESD0340001Document;
import com.clt.irep.enisEsd.ESD0340001Document.ESD0340001.DataArea.EDIGrpCustCollection.EDIGrpCust;
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
 * BookingMasterData Business Logic Basic Command implementation<br>
 * -Process Business Logic for BookingMasterData.<br>
 *
 * @author Kim Ki Jong
 * @see esm_bkg_0082EventResponse,BookingMasterMgtBC each DAO class  reference
 * @since J2EE 1.4
 */

public class BookingMasterMgtBCImpl extends BasicCommandSupport implements BookingMasterMgtBC {

	// Database Access Object
	private transient BookingMasterMgtDBDAO dbDao = null;

	/** 
	 * BookingMasterMgtBCImpl Object Creation<br>
	 * BookingMasterMgtDBDAO create.<br>
	 */
	public BookingMasterMgtBCImpl() {
		dbDao = new BookingMasterMgtDBDAO();
	}

	/**
	 * Booking Creation 1_MT P/UP CY inquiry (ESM_BKG-0082)<br>
	 * 
	 * @param String YardCode
	 * @param String Today
	 * @return List<BkgMTPickupCYVO>
	 * @exception EventException
	 */
	public List<BkgMTPickupCYVO> searchMTPickUpCY(String YardCode,String Today) throws EventException {
		try {
			return dbDao.searchMTPickUpCY(YardCode,Today);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}
	/**
	 * add/modify/delete event processing<br>
	 * HTS (Harmonized Tariff Schedule) Code Creation (ESM_BKG_0607_C)<br>
	 * 
	 * @param BkgHamoTrfVO[] bkgHamoTrfVos
	 * @param String usrId
	 * @exception EventException, DAOException
	 */
	public void manageHtsCode(BkgHamoTrfVO[] bkgHamoTrfVOs, String usrId ) throws EventException, DAOException {
		try {			
			for(int i=0; i < bkgHamoTrfVOs.length; i++) {

				if (bkgHamoTrfVOs[i].getIbflag().equals("D")) {
					dbDao.removeHtsCode(bkgHamoTrfVOs[i],usrId);
				}else if (bkgHamoTrfVOs[i].getIbflag().equals("I")) {
					//before validation
					String valFlg = dbDao.validateHtsCode(bkgHamoTrfVOs[i],usrId);
					if("Y".equals(valFlg)){
                    	throw new EventException(new ErrorHandler("BKG01050", new String[]{"Effective Date, Expire Date"}).getMessage());
                    }
					//variable initialization
					valFlg ="N";
					dbDao.addHtsCode(bkgHamoTrfVOs[i],usrId);
					//after validation
					valFlg = dbDao.validateHamoTrfCode(bkgHamoTrfVOs[i],usrId);
                    log.debug("***** valFlg ***** : " + valFlg);
                    if("Y".equals(valFlg)){
                    	throw new EventException(new ErrorHandler("BKG95066", new String[]{}).getMessage());
                    }
					
				}else if (bkgHamoTrfVOs[i].getIbflag().equals("U")) {
					//before validation
					String valFlg = dbDao.validateHtsCode(bkgHamoTrfVOs[i],usrId);
					if("Y".equals(valFlg)){
						throw new EventException(new ErrorHandler("BKG01050", new String[]{"Effective Date, Expire Date"}).getMessage());
                    }
					//variable initialization
					valFlg ="N";
					dbDao.modifyHtsCode(bkgHamoTrfVOs[i],usrId);
					//after validation
					valFlg = dbDao.validateHamoTrfCode(bkgHamoTrfVOs[i],usrId);
                    log.debug("***** valFlg ***** : " + valFlg);
                    if("Y".equals(valFlg)){
                    	throw new EventException(new ErrorHandler("BKG95066", new String[]{}).getMessage());
                    }
				}
			}
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	

	/**
	 * retrieve event processing<br>
	 * HTS (Harmonized Tariff Schedule) Code (ESM_BKG-0607)<br>
	 * 
	 * @param BkgHamoTrfVO   vo
	 * @return List<BkgHamoTrfVO>
	 * @exception EventException
	 */
	public List<BkgHamoTrfVO> searchHTSCode(BkgHamoTrfVO vo) throws EventException {
		try {
			return dbDao.searchHTSCode(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
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
	public String validateHsCd(String hsCd, String hsAplyDt, String hamoTpCd) throws EventException {
		try {
			String hsCdRslt = "";
			hsCdRslt = dbDao.validateHsCd(hsCd, hsAplyDt, hamoTpCd);
			return hsCdRslt;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Customer Inquiry Save event processing(ESM_BKG_0652)<br>
	 * manage Customer Person info.<br>
	 * 
	 * @param BkgCustCntcPsonVO[] bkgCustCntcPsonVOs
	 * @param String userId
	 * @exception EventException
	 */	
	public void manageCustContact(	BkgCustCntcPsonVO[] bkgCustCntcPsonVOs, 
														String userId) throws EventException {
		try {
			for ( int i=0; i<bkgCustCntcPsonVOs.length; i++ ) {
				if ( bkgCustCntcPsonVOs[i].getIbflag().equals("I")){
					bkgCustCntcPsonVOs[i].setCreUsrId(userId);
					bkgCustCntcPsonVOs[i].setUpdUsrId(userId);
					
					dbDao.addCustContact(bkgCustCntcPsonVOs[i]);					
				} else if ( bkgCustCntcPsonVOs[i].getIbflag().equals("U")){
					bkgCustCntcPsonVOs[i].setUpdUsrId(userId);
					
					dbDao.modifyCustContact(bkgCustCntcPsonVOs[i]);
				} else if ( bkgCustCntcPsonVOs[i].getIbflag().equals("D")){
				
					dbDao.removeCustContact(bkgCustCntcPsonVOs[i]);
				}
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException((String)new ErrorHandler("COM12240").getUserMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException((String)new ErrorHandler("COM12240").getUserMessage(),ex);
		}    
	}	
	
	/**
	 * Vessel code and SKD retrieve <br>
	 *  
	 * @param VskVslPortSkdConditionVO   vo
	 * @return List<VskVslPortSkdConditionVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdConditionVO> searchEtbEtdEta(VskVslPortSkdConditionVO vo) throws EventException {
		try {
			return dbDao.searchEtbEtdEta(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Package Code and Description retrieve(ESM_BKG_0755,ESM_BKG_0696)  <br>
	 * 
	 * @param MdmPckTpVO   vo
	 * @return List<MdmPckTpVO>
	 * @exception EventException
	 */
	public List<MdmPckTpVO> searchPackageCode(MdmPckTpVO vo) throws EventException {
		try {
			return dbDao.searchPackageCode(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Code for Commodity Code input(ESM_BKG_0653)  <br>
	 *  
	 * @param SearchCmdtCdRepCmdtCdVO   vo
	 * @return List<SearchCmdtCdRepCmdtCdVO>
	 * @exception EventException
	 */
	public List<SearchCmdtCdRepCmdtCdVO> searchCmdtCdRepCmdtCd(SearchCmdtCdRepCmdtCdVO vo) throws EventException {
		try {
			return dbDao.searchCmdtCdRepCmdtCd(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Warehouse (Bonded Area) Creation retrieve(ESM_BKG_0554)  <br>
	 *  
	 * @param String cuntryCd
	 * @param String wareHouse
	 * @return List<SearchWareHouseVO>
	 * @exception EventException
	 */
	public List<SearchWareHouseVO> searchWareHouse(String cuntryCd , String wareHouse) throws EventException {
		try {
			return dbDao.searchWareHouse(cuntryCd,wareHouse);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Warehouse (Bonded Area) Creation save event processing(ESM_BKG_0554)<br>
	 * Manage Warehouse (Bonded Area) info.<br>
	 * 
	 * @param SearchWareHouseVO vo
	 * @exception EventException
	 */	
	public void manageWareHouse(	SearchWareHouseVO vo) throws EventException {
		try {
			
			if ( vo.getIbflag().equals("I")){
				dbDao.addWareHouse(vo);		
			} else if ( vo.getIbflag().equals("U")){
				dbDao.modifyWareHouse(vo);
			} else if ( vo.getIbflag().equals("D")){
				dbDao.removeWareHouse(vo);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException((String)new ErrorHandler("COM12240").getUserMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException((String)new ErrorHandler("COM12240").getUserMessage(),ex);
		}     
	}	
	
	
	/**
	 * retrieve-Screen is BDR Processing by Manual (ESM_BKG_0596)  <br>
	 * 
	 * @param SearchBDRTimeVO   vo
	 * @return List<SearchBDRTimeVO>
	 * @exception EventException
	 */
	public List<SearchBDRTimeVO> searchBDRTime(SearchBDRTimeVO vo) throws EventException {
		try {
			return dbDao.searchBDRTime(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Vessesl Schedule B/L Data Release save event processing. (ESM_BKG_0596)<br>
	 * BKG_BL_DOC BDR processing .
	 * 
	 * @param SearchBDRTimeVO vo
	 * @exception EventException
	 */
	public void modifyBDRLog(SearchBDRTimeVO vo) throws EventException {
		try {
			dbDao.modifyBDRLog(vo);
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}
	
	/**
	 * vvd check (ESM_BKG_0596)<br>
	 * 
	 * @param SearchBDRTimeVO vo
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkBDRVVDPOL(SearchBDRTimeVO vo) throws EventException {
		try {
			return dbDao.checkBDRVVDPOL(vo);
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}
	
	
	/**
	 * booking close for bayplan info save.<br>
	 * 
	 * @param BkgCoffTmVO[] bkgCoffTmVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void closeBKGForBayPlan(BkgCoffTmVO[] bkgCoffTmVOs, SignOnUserAccount account) throws EventException{
		try {
			for ( int i=0; i<bkgCoffTmVOs.length; i++ ) {
				
				if ( bkgCoffTmVOs[i].getIbflag().equals("I")){
					bkgCoffTmVOs[i].setCreUsrId(account.getUsr_id());
					dbDao.addBkgCoffTm(bkgCoffTmVOs[i]);					
				} else if ( bkgCoffTmVOs[i].getIbflag().equals("U")){
					bkgCoffTmVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyBkgCoffTm(bkgCoffTmVOs[i]);
				} 
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}

	}
	/**
	 * booking reopen for bayplan info save.<br>
	 * 
	 * @param BkgCoffTmVO[] bkgCoffTmVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void reopenBkgForBayPlan(BkgCoffTmVO[] bkgCoffTmVOs, SignOnUserAccount account) throws EventException{
		try {
			for ( int i=0; i<bkgCoffTmVOs.length; i++ ) {
				
				if ( bkgCoffTmVOs[i].getIbflag().equals("U")){
					bkgCoffTmVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyBkgCoffTm(bkgCoffTmVOs[i]);
				} 
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * DPCS - Search S/R business processing contact person Group info (ESM_BKG_1004)<br>
	 * 
	 * @param String usrId
	 * @param String dpcsWrkGrpCd
	 * @param BkgDpcsUsrGrpVO vo
	 * @return List<BkgDpcsUsrGrpVO>
	 * @exception EventException
	 */
	public List<BkgDpcsUsrGrpVO> searchDPSCUserGroup(String usrId,String dpcsWrkGrpCd,BkgDpcsUsrGrpVO vo) throws EventException {
		try {
			return dbDao.searchDPSCPicUserGroup(usrId, dpcsWrkGrpCd, vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}	
	}
	
	/**
	 *  Retrieve Lane of BDR TIME register screen(ESM_BKG_0073) <br>
	 * 
	 * @param SearchBDRPolVO vo
	 * @return List<SearchBDRPolVO>
	 * @exception EventException
	 */
	public List<SearchBDRPolVO> searchBDRPol(SearchBDRPolVO vo) throws EventException {
		try {
			return dbDao.searchBDRPol(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * BDR Time Table retrieve event processing(ESM_BKG_0073) <br>
	 * 
	 * @param SearchBDRTimeTableVO   vo
	 * @return List<SearchBDRTimeTableVO>
	 * @exception EventException
	 */
	public List<SearchBDRTimeTableVO> searchBDRTimeTable(SearchBDRTimeTableVO vo) throws EventException {
		try {
			if (vo.getOptSelBdr().equals("Lane")){
				return dbDao.searchLaneBDRTime(vo);
			}else{
				return dbDao.searchVVDBDRTime(vo);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * BDR Time management save event processing.(ESM_BKG_0073)<br>
	 * Manage registered BDR by Time Lane/Bound/From Location/To Location standard.<br>
	 * 
	 * @param SearchBDRPolVO[] vos1
	 * @param SearchBDRTimeTableVO[] vos2
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageVVDBDRTime(SearchBDRPolVO[] vos1,SearchBDRTimeTableVO[] vos2,SignOnUserAccount account) throws EventException {
		try {
			
			if (vos1 != null && vos1.length >0){
				for ( int i=0; i<vos1.length; i++ ) {
					vos1[i].setCreUsrId(account.getUsr_id());
					vos1[i].setUpdUsrId(account.getUsr_id());
					if ( vos1[i].getIbflag().equals("I")){
						dbDao.addBDRTime(vos1[i]);
					}
					if ( vos1[i].getIbflag().equals("U")){
						dbDao.modifyBDRTime(vos1[i]);
					}
					if ( vos1[i].getIbflag().equals("D")){
						dbDao.removeBDRTime(vos1[i]);
					}
				}
			}
			if (vos2 != null && vos2.length >0){
				for ( int i=0; i<vos2.length; i++ ) {
					vos2[i].setCreUsrId(account.getUsr_id());
					vos2[i].setUpdUsrId(account.getUsr_id());
					
					if ( vos2[i].getIbflag().equals("U")){
						dbDao.modifyVVDBDRLog(vos2[i]);
					}
				}
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Equalization Port register screen retrieve event processing(ESM_BKG_0253)<br>

	 * @param BkgEqlzPortVO vo
	 * @return List<BkgEqlzPortVO>
	 * @throws EventException
	 */
	public List<BkgEqlzPortVO> searchEqualizetionPortCD (BkgEqlzPortVO vo) throws EventException{
		try {
			return dbDao.searchEqualizetionPortCD(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	 
	 /**
	 * Equalization Port register management save event processing (ESM_BKG-0253) <br>
	 * 
	 * @param BkgEqlzPortVO[] vos
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void manageEqualizationPort(BkgEqlzPortVO[] vos,SignOnUserAccount account) throws EventException{
		try {
			if (vos != null && vos.length >0){
				for ( int i=0; i<vos.length; i++ ) {
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					
					if ( vos[i].getIbflag().equals("I")){
						dbDao.addEqualizationPort(vos[i]);
					}
					if ( vos[i].getIbflag().equals("U")){
						dbDao.modifyEqualizationPort(vos[i]);
					}
					if ( vos[i].getIbflag().equals("D")){
						dbDao.removeEqualizationPort(vos[i]);
					}
					
				}
			}
            
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * China Booking Agent info register screen-retrieve event processing (ESM_BKG-0153)<br>
	 * 
	 * @param BkgChinaAgentVO vo
	 * @return List<BkgChinaAgentVO>
	 * @throws EventException
	 */
	public List<BkgChinaAgentVO> searchChinaAgentCodeList (BkgChinaAgentVO vo) throws EventException {
		try {
			return dbDao.searchChinaAgentCodeList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}  
	
	 /**
	 * China Booking Agent info register screen save event processing(ESM_BKG-0153) <br>

	 * @param BkgChinaAgentVO[] vos
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void manageChinaAgentCode(BkgChinaAgentVO[] vos,SignOnUserAccount account) throws EventException{
		try {
			log.debug("vos.length:"+vos.length);
			BookingUtil utilCmd = new BookingUtil();
			
			if (vos != null && vos.length >0){
				for ( int i=0; i<vos.length; i++ ) {
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					if (vos[i].getAutoDpChkFlg().equals("")){
						vos[i].setAutoDpChkFlg("N");
					}
					if ( vos[i].getIbflag().equals("I")){
						if (utilCmd.checkChnAgnCd(vos[i].getChnAgnCd(),"Y").equals("Y")){
							throw new EventException(new ErrorHandler("BKG03833", new String[]{"Agent Code: ["+vos[i].getChnAgnCd() + "]"}).getMessage());
						} 
						dbDao.addChinaAgentCode(vos[i]);
					}
					if ( vos[i].getIbflag().equals("U")){
						dbDao.modifyChinaAgentCode(vos[i]);
					}
					if ( vos[i].getIbflag().equals("D")){
						dbDao.removeChinaAgentCode(vos[i]);
					}
				}
			}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage());
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *  0192 B/L Customer Information in CRM retrieve <br>		
	 *  
	 * @param SearchInBoundCustListVO searchInBoundCustListVO
	 * @return List<SearchInBoundCustListVO>
	 * @throws EventException
	 */
	public List<SearchInBoundCustListVO> searchInBoundCustList(SearchInBoundCustListVO searchInBoundCustListVO) throws EventException {
		 
		try {
			return dbDao.searchInBoundCustList(searchInBoundCustListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	 }
		 
	 /**
	  *  0192 B/L Customer Information in CRM Template retrieve <br>			 
	  * @param BkgCustTmpltVO bkgCustTmpltVO
	  * @return List<BkgCustTmpltVO>
	  * @throws EventException
	  */
	 public List<BkgCustTmpltVO> searchInBoundCustTmpltList(BkgCustTmpltVO bkgCustTmpltVO) throws EventException {
		 
		 try {
			 return dbDao.searchInBoundCustTmpltList(bkgCustTmpltVO);
		 } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	 }
	 
	/**
     * multi event processing<br>
     * 0192 B/L Customer Information in CRM Template transaction processing <br>
     * 
     * @param BkgCustTmpltVO[] bkgCustTmpltVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageInBoundCustList(BkgCustTmpltVO[] bkgCustTmpltVO,SignOnUserAccount account) throws EventException{
    	
    	if(bkgCustTmpltVO == null)
			return;
		try { 
			List<BkgCustTmpltVO> insertVoList = new ArrayList<BkgCustTmpltVO>();
			List<BkgCustTmpltVO> updateVoList = new ArrayList<BkgCustTmpltVO>();
			List<BkgCustTmpltVO> deleteVoList = new ArrayList<BkgCustTmpltVO>();
			
			for ( int i=0; i<bkgCustTmpltVO.length; i++ ) {
				
				bkgCustTmpltVO[i].setCreUsrId(account.getUsr_id());
				bkgCustTmpltVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( bkgCustTmpltVO[i].getIbflag().equals("I")){
					insertVoList.add(bkgCustTmpltVO[i]);
				} else if ( bkgCustTmpltVO[i].getIbflag().equals("U")){
					updateVoList.add(bkgCustTmpltVO[i]);
				} else if ( bkgCustTmpltVO[i].getIbflag().equals("D")){
					deleteVoList.add(bkgCustTmpltVO[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeInBoundCustList(deleteVoList);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyInBoundCustList(updateVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addInBoundCustList(insertVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException((String)new ErrorHandler("BKG00391").getUserMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException((String)new ErrorHandler("BKG00391").getUserMessage(),de);
		}    	
    }
    
    /**
	 * BKG_VVD_BDR_LOG TABLE save event processing by Vessel Port Schedule change <br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @exception EventException
	 */
	public void manageBkgVVDBdrLog(String vslCd, String skdVoyNo, String skdDirCd) throws EventException{
		
		List<BkgVvdBdrLogVO> stsList 	= null;
		List<BkgVvdBdrLogVO> skdList 	= null;
		List<BkgVvdBdrLogVO> timeList 	= null;
		List<BkgVvdBdrLogVO> flgList 	= null;
		
		BkgVvdBdrLogVO actVo 		= null;
		BkgVvdBdrLogVO polVo 		= null;
		BkgVvdBdrLogVO podVo 		= null;
		BkgVvdBdrLogVO conVo 		= new BkgVvdBdrLogVO();
		BkgVvdBdrLogVO timeVo 		= null;
		
		String slanTpCd = "";
		String actDepDt = "";
		
		try {
			stsList = dbDao.searchVVDStatus(vslCd, skdVoyNo, skdDirCd);
			
			if (stsList.size() > 0){
				
				actVo = (BkgVvdBdrLogVO)stsList.get(0);
				
				/**********************************************************************************
				* Vessel Schedule Status Select for Activate Check	
				* ckech exist or not of Lane Code and Activated .
				***********************************************************************************/				
				if (actVo.getSkdStsCd().equals("ACT")){
					
					/***************************************************************************
					* check Vessel where Trunk or Feeder.
					* Trunk : 'M'.
					* Feeder  : 'P'.
					***************************************************************************/
					slanTpCd = dbDao.searchSvcTpCd(actVo.getSlanCd());
					
					/***************************************************************************
					* Select all SKD of V.V.D and it sort by ETA
					* Prework for BDR LOG will make Pair.
					***************************************************************************/
					skdList = dbDao.searchVslPortSkd(vslCd, skdVoyNo, skdDirCd);
					log.debug("champ......................1");
					for (int i = 0 ; i < (skdList.size()-1) ; i++){
						
						for (int j = 1 ; j < skdList.size() ; j++){
							log.debug("champ......................2");
							polVo = (BkgVvdBdrLogVO)skdList.get(i);
							podVo = (BkgVvdBdrLogVO)skdList.get(j);
							
							//register info setting 
							conVo.setVslCd(vslCd);
							conVo.setSkdVoyNo(skdVoyNo);
							conVo.setSkdDirCd(skdDirCd);
							conVo.setPolCd(polVo.getVpsPortCd());
							conVo.setPodCd(podVo.getVpsPortCd());
							conVo.setPolClptIndSeq(polVo.getClptIndSeq());
							conVo.setPodClptIndSeq(podVo.getClptIndSeq());
							conVo.setVpsEtdDt(polVo.getVpsEtdDt());
							conVo.setSlanCd(polVo.getSlanCd());
							conVo.setCreUsrId(polVo.getCreUsrId());
							conVo.setUpdUsrId(polVo.getUpdUsrId());
							conVo.setTrnkBdrCreUsrId(polVo.getCreUsrId());
							conVo.setFdrBdrCreUsrId(polVo.getCreUsrId());
							log.debug("champ......................3");
							/********************************************************************************************
							* Checking conditions not make <BDR LOG> 
							* 1.POL will not be Discharging Port.(Turing Port is not make BDR LOG.)
							* 2.POL will not be Skipped Port.(Skip Calling is not calls that port.)
							* 3.Can not be same POL and POD.(Not make BDR LOG in case of under Second Calling.)								
							********************************************************************************************/
							if (polVo.getTurnPortIndCd().equals("D") || polVo.getTurnPortIndCd().equals("F") ||
								polVo.getTurnPortIndCd().equals("D") || polVo.getSkdCngStsCd().equals("S") ||
								podVo.getSkdCngStsCd().equals("S")){
								
								continue;
							}
							log.debug("champ......................4");
							/*********************************************************************************
							* refer to BDR_TIME Table for get BDR Estemated Date.
							* reference : 
							*		<in case of Trunk Lane>
							*			Trunk  - created null in case of POL & POD not exist in BDR_TIME Table.
							*			Feeder - created +2 in case of POL & POD not exist in BDR_TIME Table.
							*		<in case of Feeder Lane>
							* 			Trunk  -  created +2 in case of POL & POD not exist BDR_TIME Table.
							*  			Feeder - created +bdr_days in case of POL & POD not exist BDR_TIME Table.
							*********************************************************************************/
							timeList = dbDao.searchBdrTime(polVo.getVpsEtdDt(), polVo.getSlanCd(), polVo.getSkdDirCd(), polVo.getVpsPortCd(), podVo.getVpsPortCd());
							
							//register info setting >>> SLAN_TP_CD
							conVo.setSlanTpCd(slanTpCd);
							log.debug("champ......................5");
							if (timeList.size() == 0){
								
								/***************************************************************************
								* in case of BDR Time not exist and OFF LANE (TYPE = 'P')
								* BDR DT setting ETD + 2, BDR DT of Feeder setting ETD + bdr_days
								***************************************************************************/
								if (slanTpCd.equals("P")){
									
									timeVo = dbDao.searchBdrTimeP(polVo.getVpsEtdDt());																			
								}else{
									
									timeVo = dbDao.searchBdrTimeM(polVo.getVpsEtdDt());
								}
							}else{
								
								timeVo = (BkgVvdBdrLogVO)timeList.get(0);
							}
							
							//register info setting >>> TRNK_ESTM_BDR_DT, FDR_ESTM_BDR_DT
							conVo.setTrnkEstmBdrDt(timeVo.getUpdDt());
							conVo.setFdrEstmBdrDt(timeVo.getCreDt());
							
							// Retrieve existing info at BKG_VVD_BDR_LOG TABLE
							flgList = dbDao.searchBkgVVDBdrLogFlg(conVo);
							
							//in case of existing info not exist >>> INSERT
							if (flgList.size() == 0){
								
								/****************************************************************************
								* checking inputed Actual Report(Departue)
								****************************************************************************/
								actDepDt = dbDao.searchVskActPortSkd(conVo);
								
								//in case of Actual
								if (!actDepDt.equals("")){
									
									//<in case of Trunk Lane>
									if (slanTpCd.equals("M")){
										
										//register info setting
										conVo.setTrnkBdrFlg("Y");
										conVo.setTrnkAutoBdrFlg("Y");
										conVo.setTrnkAutoBdrDt(actDepDt);
										conVo.setTrnkMnlBdrFlg("N");
										conVo.setTrnkMnlBdrDt("");
										conVo.setFdrBdrFlg("N");
										conVo.setFdrAutoBdrFlg("N");
										conVo.setFdrAutoBdrDt("");
										conVo.setFdrMnlBdrFlg("N");
										conVo.setFdrMnlBdrDt("");
										conVo.setFdrBdrUpdDt("");
										conVo.setBdrVslChkFlg("");
									}
									//<in case of Feeder Lane>
									else{
										
										//register info setting
										conVo.setTrnkBdrFlg("N");
										conVo.setTrnkAutoBdrFlg("N");
										conVo.setTrnkAutoBdrDt("");
										conVo.setTrnkMnlBdrFlg("N");
										conVo.setTrnkMnlBdrDt("");
										conVo.setFdrBdrFlg("Y");
										conVo.setFdrAutoBdrFlg("Y");
										conVo.setFdrAutoBdrDt(actDepDt);
										conVo.setFdrMnlBdrFlg("N");
										conVo.setFdrMnlBdrDt("");
										conVo.setFdrBdrUpdDt("");
										conVo.setBdrVslChkFlg("");
									}																			
								}
								//in case of Manual 
								else{
									
									//<in case of Trunk Lane>
									if (slanTpCd.equals("M")){
										
										//register info setting
										conVo.setTrnkBdrFlg("Y");
										conVo.setTrnkAutoBdrFlg("N");
										conVo.setTrnkAutoBdrDt("");
										conVo.setTrnkMnlBdrFlg("Y");
										conVo.setTrnkMnlBdrDt(actDepDt);
										conVo.setFdrBdrFlg("N");
										conVo.setFdrAutoBdrFlg("N");
										conVo.setFdrAutoBdrDt("");
										conVo.setFdrMnlBdrFlg("N");
										conVo.setFdrMnlBdrDt("");
										conVo.setFdrBdrUpdDt("");
										conVo.setBdrVslChkFlg("");
									}
									//<in case of Feeder Lane>
									else{
										
										//register info setting
										conVo.setTrnkBdrFlg("N");
										conVo.setTrnkAutoBdrFlg("N");
										conVo.setTrnkAutoBdrDt("");
										conVo.setTrnkMnlBdrFlg("N");
										conVo.setTrnkMnlBdrDt("");
										conVo.setFdrBdrFlg("Y");
										conVo.setFdrAutoBdrFlg("N");
										conVo.setFdrAutoBdrDt("");
										conVo.setFdrMnlBdrFlg("Y");
										conVo.setFdrMnlBdrDt(actDepDt);
										conVo.setFdrBdrUpdDt("");
										conVo.setBdrVslChkFlg("");
									}						
								}
								
								dbDao.addBkgVVDBdrLog(conVo);
							}
							//in case of existing info exist >>> UPDATE
							else{
								
								//<in case of Trunk Lane>
								if (slanTpCd.equals("M")){
									
									//register info setting
									conVo.setTrnkBdrFlg("Y");
									conVo.setTrnkAutoBdrFlg("N");
									conVo.setTrnkAutoBdrDt("");
									conVo.setTrnkMnlBdrFlg("Y");
									conVo.setTrnkMnlBdrDt(actDepDt);
									conVo.setFdrBdrFlg("N");
									conVo.setFdrAutoBdrFlg("N");
									conVo.setFdrAutoBdrDt("");
									conVo.setFdrMnlBdrFlg("N");
									conVo.setFdrMnlBdrDt("");
									conVo.setFdrBdrUpdDt("");
									conVo.setBdrVslChkFlg("");
								}
								//<in case of Feeder Lane>
								else{
									
									//register info setting
									conVo.setTrnkBdrFlg("N");
									conVo.setTrnkAutoBdrFlg("N");
									conVo.setTrnkAutoBdrDt("");
									conVo.setTrnkMnlBdrFlg("N");
									conVo.setTrnkMnlBdrDt("");
									conVo.setFdrBdrFlg("Y");
									conVo.setFdrAutoBdrFlg("N");
									conVo.setFdrAutoBdrDt("");
									conVo.setFdrMnlBdrFlg("Y");
									conVo.setFdrMnlBdrDt(actDepDt);
									conVo.setFdrBdrUpdDt("");
									conVo.setBdrVslChkFlg("");
								}						
							
								dbDao.modifyBkgVVDBdrLog(conVo);
							}//end if
							
							/*************************************************************************************
							* check BDR data created by current vvd  in the end remove all not checked data (regard unnecessary Data)
							*************************************************************************************/								
							conVo.setChkFlg("Y");
							conVo.setBdrVslChkFlg("Y");
							dbDao.modifyBdrVslChkFlg(conVo);
						}//end for
					}//end for
				
					/*****************************************************************************************
					check BDR data created by current vvd  in the end remove all not checked data (regard unnecessary Data)
					*****************************************************************************************/
					dbDao.removeBkgVVDBdrLog(conVo);
					
					/*****************************************************************************************
					* in original condition, BDR_VSL_CHK_FLG change null
					*****************************************************************************************/
					conVo.setChkFlg("N");
					conVo.setBdrVslChkFlg(" ");
					dbDao.modifyBdrVslChkFlg(conVo);
				}//end if
			}//end if
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Customer Sales Rep interlock management <br>
	 * 
	 * @param String message
	 * @exception EventException
	 * @throws XMLDocumentException 
	 */
	public void manageBkgCustSlsRep(String message) throws EventException {
		log.debug(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> message parsing <<<<<<<<<<<<<<<<<<<< ");
		Element element = null;
		
		String msgId 			= null;
		String msgEtt			= null;
		String srcSysCd			= null;
		String msgCreDt			= null;
		String opCd				= null;
		String cntCd			= null;
		String custSeq			= null;
		String srepCd			= null;
		String objRowId			= null;
		String userKdy			= null;
		String parObjRowId		= null; 
		String srepCustClssCd 	= null;
		
		CustSlsRepVO vo = new CustSlsRepVO();
		
		try {
			element = XMLDocumentUtils.getRootElement(new ByteArrayInputStream(message.getBytes("UTF-8")));
			msgId 			= XMLDocumentUtils.getTagValue(element, "MSGID");
			msgEtt 			= XMLDocumentUtils.getTagValue(element, "MSGETT");
			srcSysCd 		= XMLDocumentUtils.getTagValue(element, "SRCSYSCD");
			msgCreDt 		= XMLDocumentUtils.getTagValue(element, "MSGCREDT");
			opCd 			= XMLDocumentUtils.getTagValue(element, "OPCD");
			cntCd 			= XMLDocumentUtils.getTagValue(element, "CNTCD");
			custSeq 		= XMLDocumentUtils.getTagValue(element, "CUSTSEQ");
			srepCd 			= XMLDocumentUtils.getTagValue(element, "SREPCD");
			objRowId 		= XMLDocumentUtils.getTagValue(element, "OBJROWID");
			userKdy 		= XMLDocumentUtils.getTagValue(element, "USERKEY");
			parObjRowId 	= XMLDocumentUtils.getTagValue(element, "PAROBJROWID");
			srepCustClssCd	= XMLDocumentUtils.getTagValue(element, "DATACHECK");
			
			log.debug("MsgId >>> " + msgId);
			log.debug("MsgEtt >>> " + msgEtt);
			log.debug("SrcSysCd >>> " + srcSysCd);
			log.debug("MsgCreDt >>> " + msgCreDt);
			log.debug("OpCd >>> " + opCd);
			log.debug("CntCd >>> " + cntCd);
			log.debug("CustSeq >>> " + custSeq);
			log.debug("SrepCd >>> " + srepCd);
			log.debug("ObjRowId >>> " + objRowId);
			log.debug("UserKdy >>> " + userKdy);
			log.debug("ParObjRowId >>> " + parObjRowId);
			log.debug("srepCustClssCd(DATACHECK) >>> " + srepCustClssCd);
			
			vo.setSrepCd(srepCd);
			vo.setCustCntCd(cntCd);
			vo.setCustSeq(custSeq);
			vo.setUpdUsrId("SYSTEM");
			vo.setCreUsrId("SYSTEM");
			vo.setSrepCustClssCd(srepCustClssCd);
			
			if (opCd.equals("D")){
				
				vo.setDeltFlg("Y");
			}else{
				
				vo.setDeltFlg("N");
			}							
			
			List<CustSlsRepVO> list = dbDao.searchBkgCustSlsRep(vo);
			
			if (list.size() > 0 ){
				
				dbDao.modifyBkgCustSlsRep(vo);
			}else{
				
				dbDao.addBkgCustSlsRep(vo);
			}
			
		}catch(XMLDocumentException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * BKG_DOC_CLZ_SET TABLE(Documentation Cut-off Time)  retrieve.<br>
	 * @param ydCd
	 * @param vslSlanCd
	 * @param deltFlg
	 * @return
	 * @throws EventException
	 */
	public List<BkgdocClzSetListVO> searchDocCutOffTimeList(String ydCd, String vslSlanCd, String deltFlg) throws EventException{
		
		try {
			 return dbDao.searchDocCutOffTimeList(ydCd, vslSlanCd, deltFlg);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * COUNTRY CODE,NAME  retrieve<br>
	 * 
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> searchCntCdNm() throws EventException{
		
		try {
			 return dbDao.searchCntCdNm();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Documentation Cut-off Time save.<br>
	 * 
	 * @param BkgdocClzSetVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDocCutOffTimeList(BkgdocClzSetVO[] vos,SignOnUserAccount account) throws EventException{
		
		try {
			if (vos != null && vos.length >0){
				for ( int i=0; i<vos.length; i++ ) {
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					
					if ( vos[i].getIbflag().equals("I")){
						dbDao.addDocCutOffTime(vos[i]);
					}
					if ( vos[i].getIbflag().equals("U")){
						dbDao.modifyDocCutOffTime(vos[i]);
					}
					if ( vos[i].getIbflag().equals("D")){
						dbDao.removeDocCutOffTime(vos[i]);
					}
				}
			}
            
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Mandatory Item(s) Setup for Customized Service  SAVE .<br>
	 * 
	 * @param MandatoryItemSetupListVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMandatoryItemSetupList(MandatoryItemSetupListVO[] vos,SignOnUserAccount account) throws EventException{
		
		try {
			if (vos != null && vos.length >0){
				for ( int i=0; i<vos.length; i++ ) {
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					
					if ( vos[i].getIbflag().equals("I")){
						dbDao.addMandatoryItemSetupList (vos[i]);
					}
					if ( vos[i].getIbflag().equals("U")){
						dbDao.modifyMandatoryItemSetupList(vos[i]);
					}
					if ( vos[i].getIbflag().equals("D")){
						dbDao.removeMandatoryItemSetupList(vos[i]);
					}
				}
			}
            
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Mandatory Item(s) Setup for Customized Service  Retrieve.<br>
	 * 
	 * @param BkgMdtItmVO vo
	 * @return List<BkgMdtItmVO>
	 * @exception EventException
	 */
	public List<BkgMdtItmVO> searchMandatoryItemSetupList(BkgMdtItmVO vo) throws EventException{
		
		try {
			 return dbDao.searchMandatoryItemSetupList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * BKG_EDI_TRD_PRNR_SUB_LNK interlock processing.
	 * 
	 * @param String message
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void receiveBkgEdiTrdPrnrSubLnk(String message) throws EventException {
		log.debug(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> receiveBkgEdiTrdPrnrSubLnk Start <<<<<<<<<<<<<<<<<<<< ");
		BkgEdiTrdPrnrSubLnkVO vo             = null;
		String trdPrnrSubLnkSeq              = null;
		String prnrSubLnkDivCd               = null;
		String prnrSubLnkCd                  = null;
		String sndrTrdPrnrId                 = null;
		String rcvrTrdPrnrId                 = null;
		String prnrPortCd                    = null;
		String ediSndFlg                     = null;
		String creUsrId                      = null;
		List<BkgEdiTrdPrnrSubLnkVO> list     = null;
		List<Element>               dataList = null;
		try {
			dataList = XMLDocumentUtils.getChildElementList(
				XMLDocumentUtils.getRootElement(
					new ByteArrayInputStream(message.getBytes("UTF-8"))
				), "E_SUBLINK");
			if (null!=dataList && 0<dataList.size()) {
				for (Element element : dataList) {
					trdPrnrSubLnkSeq = XMLDocumentUtils.getTagValue(element, "TRD_PRNR_SUB_LNK_SEQ");
					prnrSubLnkDivCd  = XMLDocumentUtils.getTagValue(element, "PRNR_SUB_LNK_DIV_CD");
					prnrSubLnkCd     = XMLDocumentUtils.getTagValue(element, "PRNR_SUB_LNK_CD");
					sndrTrdPrnrId    = XMLDocumentUtils.getTagValue(element, "SNDR_TRD_PRNR_ID");
					rcvrTrdPrnrId    = XMLDocumentUtils.getTagValue(element, "RCVR_TRD_PRNR_ID");
					prnrPortCd       = XMLDocumentUtils.getTagValue(element, "PRNR_PORT_CD");
					ediSndFlg        = XMLDocumentUtils.getTagValue(element, "EDI_SND_FLG");
					creUsrId         = XMLDocumentUtils.getTagValue(element, "CRE_USR_ID");
					vo = new BkgEdiTrdPrnrSubLnkVO();
					vo.setTrdPrnrSubLnkSeq(trdPrnrSubLnkSeq);
					vo.setPrnrSubLnkDivCd(prnrSubLnkDivCd);
					vo.setPrnrSubLnkCd(prnrSubLnkCd);
					vo.setSndrTrdPrnrId(sndrTrdPrnrId);
					vo.setRcvrTrdPrnrId(rcvrTrdPrnrId);
					vo.setPrnrPortCd(prnrPortCd);
					vo.setEdiSndFlg(ediSndFlg);
					vo.setCreUsrId(creUsrId);
					vo.setUpdUsrId("SYSTEM");
					list = dbDao.searchBkgEdiTrdPrnrSubLnk(vo);
					if (0<list.size()) {
						dbDao.modifyBkgEdiTrdPrnrSubLnk(vo);
					} else {
						dbDao.addBkgEdiTrdPrnrSubLnk(vo);
					}
				}
			}
			log.debug(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> receiveBkgEdiTrdPrnrSubLnk End <<<<<<<<<<<<<<<<<<<< ");
		} catch(XMLDocumentException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * BKG_EDI_SUB_LNK_MSG interlock processing.
	 * 
	 * @param String message
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void receiveBkgEdiSubLnkMsg(String message) throws EventException {
		log.debug(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> receiveBkgEdiSubLnkMsg Start <<<<<<<<<<<<<<<<<<<< ");
		BkgEdiSubLnkMsgVO vo                 = null;
		String trdPrnrSubLnkSeq              = null;
		String ediMsgTpId                    = null;
		String ediMsgIndCd                   = null;
		String msgTpDesc                     = null;
		String ediStupNo                     = null;
		List<BkgEdiSubLnkMsgVO>     list     = null;
		List<Element>               dataList = null;
		try {
			dataList = XMLDocumentUtils.getChildElementList(
				XMLDocumentUtils.getRootElement(
					new ByteArrayInputStream(message.getBytes("UTF-8"))
				), "E_SUBLINK_MSG_IND");
			if (null!=dataList && 0<dataList.size()) {
				for (Element element : dataList) {
					trdPrnrSubLnkSeq = XMLDocumentUtils.getTagValue(element, "TRD_PRNR_SUB_LNK_SEQ");
					ediMsgTpId  = XMLDocumentUtils.getTagValue(element, "EDI_MSG_TP_ID");
					ediMsgIndCd = XMLDocumentUtils.getTagValue(element, "EDI_MSG_IND_CD");
					msgTpDesc   = XMLDocumentUtils.getTagValue(element, "MSG_TP_DESC");
					ediStupNo   = XMLDocumentUtils.getTagValue(element, "EDI_STUP_NO");
					vo = new BkgEdiSubLnkMsgVO();
					vo.setTrdPrnrSubLnkSeq(trdPrnrSubLnkSeq);
					vo.setEdiMsgTpId(ediMsgTpId);
					vo.setEdiMsgIndCd(ediMsgIndCd);
					vo.setMsgTpDesc(msgTpDesc);
					vo.setEdiStupNo(ediStupNo);
					vo.setCreUsrId("SYSTEM");
					vo.setUpdUsrId("SYSTEM");
					list = dbDao.searchBkgEdiSubLnkMsg(vo);
					if (0<list.size()) {
						dbDao.modifyBkgEdiSubLnkMsg(vo);
					} else {
						dbDao.addBkgEdiSubLnkMsg(vo);
					}
				}
			}
			log.debug(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> receiveBkgEdiSubLnkMsg End <<<<<<<<<<<<<<<<<<<< ");
		} catch(XMLDocumentException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * BKG_EDI_PRNR_PORT_LANE interlock processing.
	 * 
	 * @param String message
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void receiveBkgEdiPrnrPortLane(String message) throws EventException {
		log.debug(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> receiveBkgEdiPrnrPortLane Start <<<<<<<<<<<<<<<<<<<< ");
		BkgEdiPrnrPortLaneVO vo              = null;
		String trdPrnrSubLnkSeq              = null;
		String slanCd                        = null;
		List<BkgEdiPrnrPortLaneVO>  list     = null;
		List<Element>               dataList = null;
		try {
			dataList = XMLDocumentUtils.getChildElementList(
				XMLDocumentUtils.getRootElement(
					new ByteArrayInputStream(message.getBytes("UTF-8"))
				), "E_PORT_LANE");
			if (null!=dataList && 0<dataList.size()) {
				for (Element element : dataList) {
					trdPrnrSubLnkSeq = XMLDocumentUtils.getTagValue(element, "TRD_PRNR_SUB_LNK_SEQ");
					slanCd = XMLDocumentUtils.getTagValue(element, "SLAN_CD");
					vo = new BkgEdiPrnrPortLaneVO();
					vo.setTrdPrnrSubLnkSeq(trdPrnrSubLnkSeq);
					vo.setSlanCd(slanCd);
					vo.setCreUsrId("SYSTEM");
					vo.setUpdUsrId("SYSTEM");
					list = dbDao.searchBkgEdiPrnrPortLane(vo);
					if (0<list.size()) {
						dbDao.modifyBkgEdiPrnrPortLane(vo);
					} else {
						dbDao.addBkgEdiPrnrPortLane(vo);
					}
				}
			}
			log.debug(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> receiveBkgEdiPrnrPortLane End <<<<<<<<<<<<<<<<<<<< ");
		} catch(XMLDocumentException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * North China Manual Booking No creation present condition retrieve<br>
	 * 
	 * @param ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO
	 * @return List<BkgChnBkgNoGenVO>
	 * @exception EventException
	 */
	public List<BkgChnBkgNoGenVO> searchChnMnlBkgNoGenList(ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO) throws EventException {
		try {
			return dbDao.searchChnMnlBkgNoGenList(chnMnlBkgNoGenCondVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	

	/**
	 * pre creation Booking Number for North China Agent <br>
	 * 
	 * @param ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO
	 * @param SignOnUserAccount account
	 * @return List<BkgChnBkgNoGenVO>
	 * @exception EventException
	 */
	@Override
	public List<BkgChnBkgNoGenVO> createChnMnlBkgNoGenList(ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO, SignOnUserAccount account) throws EventException {
		List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVOs = new ArrayList<BkgChnBkgNoGenVO>();
		try {
			BookingUtil utilCmd = new BookingUtil();
			int noOfBkg = Integer.parseInt(chnMnlBkgNoGenCondVO.getNoOfBkg());

			String creOfcCd = account.getOfc_cd();
			String chnAgnCd = chnMnlBkgNoGenCondVO.getactChnAgnCd();
			
			if(chnMnlBkgNoGenCondVO.getAgnFlg().equalsIgnoreCase("Y")){
				if ("N".equals(dbDao.searchChnOfcAgn(creOfcCd, chnAgnCd))) {
					throw new EventException((String) new ErrorHandler("BKG08064", new String []{creOfcCd, chnAgnCd}).getMessage());
				}
			}
			
			String nchnBkgNoPrefix = "";
//			if (creOfcCd.equals("NBOBB")){
//				nchnBkgNoPrefix = "NJ" + chnAgnCd;
//			}else{
				nchnBkgNoPrefix = creOfcCd.substring(0, 2) + chnAgnCd;
//			}
			

			for (int i = 0; i < noOfBkg; i++) {
				BkgBlNoVO bkgBlNoVO = utilCmd.manageBkgNumberGeneration("NCB", nchnBkgNoPrefix, account.getUsr_id());
				
				log.info("bkgBlNoVO.getNcbNo()=[" + bkgBlNoVO.getNcbNo() + "]");
				if ("MAX_OVER".equals(bkgBlNoVO.getNcbNo())) {
					log.info("MAX_OVER~!!!!!!!!!!");
					throw new EventException((String) new ErrorHandler("BKG02067").getMessage());
				}
				BkgChnBkgNoGenVO bkgChnBkgNoGenVO = new BkgChnBkgNoGenVO();
				bkgChnBkgNoGenVO.setBkgNo(bkgBlNoVO.getNcbNo() + "00");
				bkgChnBkgNoGenVO.setBkgNoUseFlg("N");
				bkgChnBkgNoGenVO.setChnAgnCd(chnMnlBkgNoGenCondVO.getactChnAgnCd());
				// setting Creation Date/Time from  Local Time of user Office
				bkgChnBkgNoGenVO.setBkgCreDt(utilCmd.searchTimeLocalOfcFnc(chnMnlBkgNoGenCondVO.getActCreOfcCd()));
//				bkgChnBkgNoGenVO.setBkgCreDt(utilCmd.searchTimeLocalOfcFnc(account.getOfc_cd()));
				bkgChnBkgNoGenVO.setCreOfcCd(account.getOfc_cd());
				bkgChnBkgNoGenVO.setCreUsrId(account.getUsr_id());
				bkgChnBkgNoGenVO.setAgnFlg(chnMnlBkgNoGenCondVO.getAgnFlg());
				bkgChnBkgNoGenVOs.add(bkgChnBkgNoGenVO);
			}

			if (bkgChnBkgNoGenVOs.size() > 0) {
				dbDao.addBkgChnBkgNoGenList(bkgChnBkgNoGenVOs);
			}
			
			return bkgChnBkgNoGenVOs;
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}
	
	/**
	 * use check when pre created north china BKG NO use<br>
	 * 
	 * @param List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVOs
	 * @param String bkgPorCd 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@Override
	public void modifyChnBkgNoUseFlgOnList(List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVOs, String bkgPorCd, SignOnUserAccount account) throws EventException {
		try {
			if (bkgChnBkgNoGenVOs.size() > 0) {
				for (int i = 0; i < bkgChnBkgNoGenVOs.size(); i++) {
					bkgChnBkgNoGenVOs.get(i).setDocUsrId(account.getUsr_id());
					bkgChnBkgNoGenVOs.get(i).setUpdUsrId(account.getUsr_id());
				}
				dbDao.modifyChnBkgNoUseFlgOnList(bkgChnBkgNoGenVOs, bkgPorCd);
			}
		
			return;
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}

	/**
	 * manageBkgEdiGrp<br>
	 * 
	 * @param String str
	 * @exception EventException
	 */
	public void manageBkgEdiGrp(String str) throws EventException {
        EDIGroup[] group_array = null;
		List<BkgEdiGrpVO> list = null;
		BkgEdiGrpVO bkgEdiGrpVO = null;
		try {
            group_array = ESD0320001Document.Factory.parse(str).getESD0320001().getDataArea().getEDIGroupCollection().getEDIGroupArray();
            list = new ArrayList<BkgEdiGrpVO>();
	        for (EDIGroup ediGroup : group_array) {
				bkgEdiGrpVO = new BkgEdiGrpVO();
				bkgEdiGrpVO.setEsvcGrpCd     (ediGroup.getGROUPCD  ());
				bkgEdiGrpVO.setCoCd          (ediGroup.getCOMPANYCD());
				bkgEdiGrpVO.setEsvcGrpNm     (ediGroup.getGROUPNM  ());
				bkgEdiGrpVO.setCustTrdPrnrId (ediGroup.getCUSTTPID ());
				bkgEdiGrpVO.setMchnTrdPrnrId (ediGroup.getHOSTTPID ());
				bkgEdiGrpVO.setEsvcGrpDeltFlg(ediGroup.getDELIND   ());
	        	bkgEdiGrpVO.setEaiSts        (ediGroup.getEAISTS   ());
				list.add(bkgEdiGrpVO);
	        }
			dbDao.manageBkgEdiGrp(list);
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}

	/**
	 * manageBkgEdiGrpCust<br>
	 * 
	 * @param String str
	 * @exception EventException
	 */
	public void manageBkgEdiGrpCust(String str) throws EventException {
    	EDIGrpCust [] group_cust_array = null;
		List<BkgEdiGrpCustVO> list = null;
		BkgEdiGrpCustVO bkgEdiGrpCustVO = null;
		try {
            group_cust_array = ESD0340001Document.Factory.parse(str).getESD0340001().getDataArea().getEDIGrpCustCollection().getEDIGrpCustArray();
            list = new ArrayList<BkgEdiGrpCustVO>();
	        for (EDIGrpCust ediGrpCust : group_cust_array) {
	        	bkgEdiGrpCustVO = new BkgEdiGrpCustVO();
	        	bkgEdiGrpCustVO.setEsvcGrpCd    (ediGrpCust.getGROUPCD     ());
	        	bkgEdiGrpCustVO.setCoCd         (ediGrpCust.getCOMPANYCD   ());
	        	bkgEdiGrpCustVO.setCntCd        (ediGrpCust.getCNTCD       ());
	        	bkgEdiGrpCustVO.setCustSeq      (ediGrpCust.getCUSTCD      ());
	        	bkgEdiGrpCustVO.setScNo         (ediGrpCust.getSCNO        ());
	        	bkgEdiGrpCustVO.setBkgCfmFlg    (ediGrpCust.getBOKCONYN    ());
	        	bkgEdiGrpCustVO.setBkgCfmAutoFlg(ediGrpCust.getBCAUTOIND   ());
	        	bkgEdiGrpCustVO.setBlDrftAutoFlg(ediGrpCust.getBLAUTOIND   ());
	        	bkgEdiGrpCustVO.setBlDrftFlg    (ediGrpCust.getBLDRFTYN    ());
	        	bkgEdiGrpCustVO.setCgoTrakFlg   (ediGrpCust.getCGOTRKYN    ());
	        	bkgEdiGrpCustVO.setAnFlg        (ediGrpCust.getARVNTSYN    ());
	        	bkgEdiGrpCustVO.setEsvcBlTpCd   (ediGrpCust.getBLTYPECD    ());
	        	bkgEdiGrpCustVO.setBkgCtrtTpCd  (ediGrpCust.getBKGCTRTDIVCD());
	        	bkgEdiGrpCustVO.setDeltFlg      (ediGrpCust.getDELYN       ());
	        	bkgEdiGrpCustVO.setEaiSts       (ediGrpCust.getEAISTS      ());
	        	list.add(bkgEdiGrpCustVO);
	        }
			dbDao.manageBkgEdiGrpCust(list);
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}

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
	public String checkVvdBdrLog(String vvdCd,String polCd,String podCd,String rdoTrunkFeeder) throws EventException {
		try {
			return  dbDao.checkVvdBdrLog(vvdCd,polCd,podCd,rdoTrunkFeeder);
		
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}
	
	/**
	 * retrieve bkgNo whether china agent bkg no or not .<br>
	 * 
	 * @param 	String bkgNo
	 * @return 	String 
	 * @exception EventException
	 */	
	public String searchIsChnMnlBkgNo(String bkgNo) throws EventException {
		try {
			return  dbDao.searchIsChnMnlBkgNo(bkgNo);
		
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}
	/**
	 * Retrieve processing.<br>
	 * 
	 * @param ZipCdSchVO vo
	 * @return List<ZipCdListVO>
	 * @exception EventException
	 */
	public List<ZipCdListVO> searchZipCode(ZipCdSchVO vo) throws EventException{
		
	try {
			 return dbDao.searchZipCode(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
 	
	/**
	 * Save zip code.<br>
	 * 
	 * @param ZipCdListVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageZipCode(ZipCdListVO[] vos,SignOnUserAccount account) throws EventException{
		try {
			if (vos != null && vos.length >0){
				for ( int i=0; i<vos.length; i++ ) {

					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					vos[i].setEvntUsrId(account.getUsr_id());
					vos[i].setEvntOfcCd(account.getOfc_cd());
					
					if ( vos[i].getIbflag().equals("I")){						
						dbDao.mergeZipCode(vos[i]);
					}
					if ( vos[i].getIbflag().equals("U")){
						dbDao.mergeZipCode(vos[i]);
					}
					if ( vos[i].getIbflag().equals("D")){
						dbDao.removeZipCode(vos[i]);
					}
				}
			}
            
		} catch(DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * SalesRep info save/modify.<br>
	 * 
	 * @param BkgSalesRepVO[] bkgSalesRepVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSalesRep(BkgSalesRepVO[] bkgSalesRepVOs,  SignOnUserAccount account) throws EventException{
		
		try {
			if (bkgSalesRepVOs != null && bkgSalesRepVOs.length >0){
				for ( int i=0; i<bkgSalesRepVOs.length; i++ ) {
					if ( bkgSalesRepVOs[i].getOpCd().equals("D")){
						bkgSalesRepVOs[i].setUserId(account.getUsr_id());
						dbDao.modifySalesRepCode(bkgSalesRepVOs[i]);
					}
				}
				for ( int i=0; i<bkgSalesRepVOs.length; i++ ) {
					if ( bkgSalesRepVOs[i].getOpCd().equals("I")){
						bkgSalesRepVOs[i].setUserId(account.getUsr_id());
						dbDao.addSalesRepCode(bkgSalesRepVOs[i]);
					}
				}
				for ( int i=0; i<bkgSalesRepVOs.length; i++ ) {
					if ( bkgSalesRepVOs[i].getOpCd().equals("U")){
						bkgSalesRepVOs[i].setUserId(account.getUsr_id());
						dbDao.modifySalesRepCode(bkgSalesRepVOs[i]);
					}
				}				
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
    /**
     * select Hard Coding Setup List
     * @param BkgHrdCdgDescVO bkgHrdCdgDescVO
     * @return List<BkgHrdCdgDescVO>
     * @throws EventException
     */	
    public List<BkgHrdCdgDescVO> searchHrdCdgDesc(BkgHrdCdgDescVO bkgHrdCdgDescVO) throws EventException{
    	try {
			 return dbDao.searchHrdCdgDesc(bkgHrdCdgDescVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
    }
    
	/**Hard Coding Setup List Insert, Update, Delete.
	 * @param BkgHrdCdgDescVO[] bkgHrdCdgDescVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageHrdCdgDesc(BkgHrdCdgDescVO[] bkgHrdCdgDescVOs,SignOnUserAccount account) throws EventException {
		// 파라메터 객체 변환
		try {			
			// 작업 구분 분할
			
			if(bkgHrdCdgDescVOs!=null && bkgHrdCdgDescVOs.length>0){
				for(int i=0; i<bkgHrdCdgDescVOs.length; i++) {
	
					if (bkgHrdCdgDescVOs[i].getIbflag().equals("I")) {
						dbDao.addHrdCdgDesc(bkgHrdCdgDescVOs[i],account);					
					}else if (bkgHrdCdgDescVOs[i].getIbflag().equals("D")) {
//						dbDao.removeHrdCdgChild(bkgHrdCdgDescVOs[i],account);
						dbDao.removeHrdCdgDesc(bkgHrdCdgDescVOs[i],account);
					}else if (bkgHrdCdgDescVOs[i].getIbflag().equals("U")) {
						dbDao.modifyHrdCdgDesc(bkgHrdCdgDescVOs[i],account);
	
					}
				}
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}
	/**
	 * select Hard Coding Contents List
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws EventException
	 */	
    public List<BkgHrdCdgCtntVO> searchHrdCdgCtnt(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException{
    	try {
			 return dbDao.searchHrdCdgCtnt(bkgHrdCdgCtntVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
    }
    
	/**
	 * Hard Coding contents List Insert, Update, Delete.
	 * @param BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */    
	public void manageHrdCdgCtnt(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs,SignOnUserAccount account) throws EventException{
		
		try {			
			// 작업 구분 분할
			
			if(bkgHrdCdgCtntVOs!=null && bkgHrdCdgCtntVOs.length>0){
				for(int i=0; i<bkgHrdCdgCtntVOs.length; i++) {
					
					if (bkgHrdCdgCtntVOs[i].getIbflag().equals("I")) {
						dbDao.addHrdCdgCtnt(bkgHrdCdgCtntVOs[i],account);					
					}else if (bkgHrdCdgCtntVOs[i].getIbflag().equals("D")) {
						dbDao.removeHrdCdgCtnt(bkgHrdCdgCtntVOs[i],account);
					}else if (bkgHrdCdgCtntVOs[i].getIbflag().equals("U")) {
						dbDao.modifyHrdCdgCtnt(bkgHrdCdgCtntVOs[i],account);
	
					}
				}
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}
	/**check if there is the same Hardcoding Id in DB
	 * @param String hrdCdgId
	 * @return String
	 * @throws EventException
	 */	
	public String checkHrdCdgId(String hrdCdgId) throws EventException {
		

		DBRowSet rowSet = null;							
        String retVal = "";
        try {
            rowSet=dbDao.checkHrdCdgId(hrdCdgId);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	
	}	

	/**check if there is data on Hard coding contents
	 * @param hrdCdgId
	 * @return String
	 * @throws EventException
	 */
	public String checkChildCnt(String hrdCdgId) throws EventException{
		
		DBRowSet rowSet = null;							
        String retVal = "";
        try {
            rowSet=dbDao.checkChildCnt(hrdCdgId);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
		
	}	
	
	/**
	 * select Controlling Party List
	 * @param BkgCtrlPtyVO bkgCtrlPtyVO
	 * @return List<BkgCtrlPtyVO>
	 * @throws EventException
	 */
	public List<BkgCtrlPtyVO> searchControllingPartyList(BkgCtrlPtyVO bkgCtrlPtyVO) throws EventException {
		try {
			 return dbDao.searchControllingPartyList(bkgCtrlPtyVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * select Internet B/L Control  List
	 * @param BkgCtrlPtyVO bkgCtrlPtyVO
	 * @return List<BkgInetBlCtrlPtyVO>
	 * @throws EventException
	 */
	public List<BkgInetBlCtrlPtyVO> searchInernettBlControlPartyList(BkgCtrlPtyVO bkgCtrlPtyVO) throws EventException {
		try {
			 return dbDao.searchInernettBlControlPartyList(bkgCtrlPtyVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * select BL Group List
	 * @param BkgCtrlPtyVO bkgCtrlPtyVO
	 * @return List<BkgCtrlPtyBlGrpVO>
	 * @throws EventException
	 */
	public List<BkgCtrlPtyBlGrpVO> searchBlGroupList(BkgCtrlPtyVO bkgCtrlPtyVO) throws EventException {
		try {
			 return dbDao.searchBlGroupList(bkgCtrlPtyVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * insert/update/delete Controlling Party, Internet B/L Control, BL Group
	 * @param BkgCtrlPtyVO[] bkgCtrlPtyVOs
	 * @param BkgInetBlCtrlPtyVO[] bkgInetBlCtrlPtyVOs
	 * @param BkgCtrlPtyBlGrpVO[] bkgCtrlPtyBlGrpVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageControllingParty(BkgCtrlPtyVO[] bkgCtrlPtyVOs, BkgInetBlCtrlPtyVO[] bkgInetBlCtrlPtyVOs, BkgCtrlPtyBlGrpVO[] bkgCtrlPtyBlGrpVOs, SignOnUserAccount account) throws EventException {	
		try {			
			if(bkgCtrlPtyVOs!=null && bkgCtrlPtyVOs.length>0){
				for(int i=0; i<bkgCtrlPtyVOs.length; i++) {
					// MASTER INSERT
					if (bkgCtrlPtyVOs[i].getIbflag().equals("I")) {
						dbDao.addControllingParty(bkgCtrlPtyVOs[i],account);
					}else if (bkgCtrlPtyVOs[i].getIbflag().equals("U")) {
						dbDao.modifyControllingParty(bkgCtrlPtyVOs[i],account);
					}else if(bkgCtrlPtyVOs[i].getIbflag().equals("D")){
						//detail 삭제
						BkgInetBlCtrlPtyVO bkgInetBlCtrlPtyVO = new BkgInetBlCtrlPtyVO();
						bkgInetBlCtrlPtyVO.setCtrlPtySeq(bkgCtrlPtyVOs[i].getCtrlPtySeq());
						dbDao.removeInernettBlControlPartyByCtrlPtySeq(bkgInetBlCtrlPtyVO);
						
						BkgCtrlPtyBlGrpVO bkgCtrlPtyBlGrpVO = new BkgCtrlPtyBlGrpVO();
						bkgCtrlPtyBlGrpVO.setCtrlPtySeq(bkgCtrlPtyVOs[i].getCtrlPtySeq());
						dbDao.removeBlGroup(bkgCtrlPtyBlGrpVO);
						
						//master 삭제
						dbDao.removeControllingParty(bkgCtrlPtyVOs[i]);
					}
				}
			}
//			log.debug("--------------------------------1----------------------");
			// DETAIL(INSERT)
			if(bkgInetBlCtrlPtyVOs!=null && bkgInetBlCtrlPtyVOs.length>0){
				for(int i=0; i<bkgInetBlCtrlPtyVOs.length; i++) {
					if (bkgInetBlCtrlPtyVOs[i].getIbflag().equals("I")) {
						dbDao.addInernettBlControlParty(bkgInetBlCtrlPtyVOs[i],account);
					}else if(bkgInetBlCtrlPtyVOs[i].getIbflag().equals("U")){
						dbDao.modifyInernettBlControlParty(bkgInetBlCtrlPtyVOs[i],account);
					}else if(bkgInetBlCtrlPtyVOs[i].getIbflag().equals("D")){
						dbDao.removeInernettBlControlParty(bkgInetBlCtrlPtyVOs[i]);
					}
				}
			}
//			log.debug("--------------------------------1----------------------");
			// DETAIL(INSERT)
			if(bkgCtrlPtyBlGrpVOs!=null && bkgCtrlPtyBlGrpVOs.length>0){
				for(int i=0; i<bkgCtrlPtyBlGrpVOs.length; i++) {
					if (bkgCtrlPtyBlGrpVOs[i].getIbflag().equals("I")) {
						dbDao.addBlGroup(bkgCtrlPtyBlGrpVOs[i],account);
					}else if (bkgCtrlPtyBlGrpVOs[i].getIbflag().equals("U")) {
						dbDao.modifyBlGroup(bkgCtrlPtyBlGrpVOs[i],account);
					}else if(bkgCtrlPtyBlGrpVOs[i].getIbflag().equals("D")) {
						dbDao.removeBlGroup(bkgCtrlPtyBlGrpVOs[i]);
					}
				}
			}
//			log.debug("--------------------------------1----------------------");
			// MASTER UPDATE
//			if(bkgCtrlPtyVOs!=null && bkgCtrlPtyVOs.length>0){
//				for(int i=0; i<bkgCtrlPtyVOs.length; i++) {
//					if (bkgCtrlPtyVOs[i].getIbflag().equals("U")) {
//						dbDao.modifyControllingParty(bkgCtrlPtyVOs[i],account);
//					}
//				}
//			}
//			log.debug("--------------------------------1----------------------");
			// DETAIL(UPDATE)
//			if(bkgCtrlPtyBlGrpVOs!=null && bkgCtrlPtyBlGrpVOs.length>0){
//				for(int i=0; i<bkgCtrlPtyBlGrpVOs.length; i++) {
//					if (bkgCtrlPtyBlGrpVOs[i].getIbflag().equals("U")) {
//						dbDao.modifyBlGroup(bkgCtrlPtyBlGrpVOs[i],account);
//					}
//				}
//			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * searchBlGroupMasterList
	 * @param BkgCtrlBlGrpVO bkgCtrlBlGrpVO
	 * @return List<BkgCtrlBlGrpVO>
	 * @throws EventException
	 */
	public List<BkgCtrlBlGrpVO> searchBlGroupMasterList(BkgCtrlBlGrpVO bkgCtrlBlGrpVO) throws EventException {
		try {
			 return dbDao.searchBlGroupMasterList(bkgCtrlBlGrpVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * removeControllingParty
	 * @param BkgCtrlPtyVO[] bkgCtrlPtyVOs
	 * @throws EventException
	 */
	public void removeControllingParty(BkgCtrlPtyVO[] bkgCtrlPtyVOs) throws EventException {
		BkgInetBlCtrlPtyVO bkgInetBlCtrlPtyVO 	= new BkgInetBlCtrlPtyVO();
		BkgCtrlPtyBlGrpVO bkgCtrlPtyBlGrpVO 	= new BkgCtrlPtyBlGrpVO();
		
		try {		
			if(bkgCtrlPtyVOs!=null && bkgCtrlPtyVOs.length>0){
				for(int i=0; i<bkgCtrlPtyVOs.length; i++) {
					if(bkgCtrlPtyVOs[i].getIbflag().equals("D")){
					
						//detail 삭제
						bkgInetBlCtrlPtyVO = new BkgInetBlCtrlPtyVO();
						bkgInetBlCtrlPtyVO.setCtrlPtySeq(bkgCtrlPtyVOs[i].getCtrlPtySeq());
						dbDao.removeInernettBlControlPartyByCtrlPtySeq(bkgInetBlCtrlPtyVO);
						
						bkgCtrlPtyBlGrpVO = new BkgCtrlPtyBlGrpVO();
						bkgCtrlPtyBlGrpVO.setCtrlPtySeq(bkgCtrlPtyVOs[i].getCtrlPtySeq());
						dbDao.removeBlGroup(bkgCtrlPtyBlGrpVO);
						
						//master 삭제
						dbDao.removeControllingParty(bkgCtrlPtyVOs[i]);
					}
				}
			}
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}		
	}

	/**
	 * removeInernettBlControlParty
	 * @param BkgInetBlCtrlPtyVO[] bkgInetBlCtrlPtyVOs
	 * @throws EventException
	 */
	public void removeInernettBlControlParty(BkgInetBlCtrlPtyVO[] bkgInetBlCtrlPtyVOs) throws EventException {
		try {		
			if(bkgInetBlCtrlPtyVOs!=null && bkgInetBlCtrlPtyVOs.length>0){
				for(int i=0; i<bkgInetBlCtrlPtyVOs.length; i++) {
					if(bkgInetBlCtrlPtyVOs[i].getIbflag().equals("D")){
						dbDao.removeInernettBlControlParty(bkgInetBlCtrlPtyVOs[i]);
					}
				}
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}		
	}

	/**
	 * removeBlGroup
	 * @param BkgCtrlPtyBlGrpVO[] bkgCtrlPtyBlGrpVOs
	 * @throws EventException
	 */
	public void removeBlGroup(BkgCtrlPtyBlGrpVO[] bkgCtrlPtyBlGrpVOs) throws EventException {
		try {		
			if(bkgCtrlPtyBlGrpVOs!=null && bkgCtrlPtyBlGrpVOs.length>0){
				for(int i=0; i<bkgCtrlPtyBlGrpVOs.length; i++) {
					if(bkgCtrlPtyBlGrpVOs[i].getIbflag().equals("D")){
						dbDao.removeBlGroup(bkgCtrlPtyBlGrpVOs[i]);
					}
				}
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}		
		
	}	
	
	/**
	 * searchBlGroupCustomerList
	 * @param BkgCtrlBlGrpVO bkgCtrlBlGrpVO
	 * @return List<BkgCtrlBlGrpCustVO>
	 * @throws EventException
	 */
	public List<BkgCtrlBlGrpCustVO> searchBlGroupCustomerList(BkgCtrlBlGrpVO bkgCtrlBlGrpVO) throws EventException{
		try {
			 return dbDao.searchBlGroupCustomerList(bkgCtrlBlGrpVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * insert/update/delete BL Group, Customer
	 * @param BkgCtrlBlGrpVO[] bkgCtrlBlGrpVOs
	 * @param BkgCtrlBlGrpCustVO[] bkgCtrlBlGrpCustVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageBlGroup(BkgCtrlBlGrpVO[] bkgCtrlBlGrpVOs, BkgCtrlBlGrpCustVO[] bkgCtrlBlGrpCustVOs, SignOnUserAccount account) throws EventException{
		try {			
			if(bkgCtrlBlGrpVOs!=null && bkgCtrlBlGrpVOs.length>0){
				for(int i=0; i<bkgCtrlBlGrpVOs.length; i++) {
					// KEY SETTING
					if (bkgCtrlBlGrpVOs[i].getIbflag().equals("I")) {
						if(!dbDao.checkBlGroupName(bkgCtrlBlGrpVOs[i])){
							// MASTER INSERT
							dbDao.addBlGroupMaster(bkgCtrlBlGrpVOs[i],account);
						}else{
							throw new EventException(new ErrorHandler("BKG00764", new String[]{"BL Group Name"}).getMessage());
						}
					}
					else if (bkgCtrlBlGrpVOs[i].getIbflag().equals("U")) {
						dbDao.modifyBlGroupMaster(bkgCtrlBlGrpVOs[i],account);
					}
					
					else if(bkgCtrlBlGrpVOs[i].getIbflag().equals("D")){
						//detail 삭제
						BkgCtrlBlGrpVO bkgCtrlBlGrpVO = new BkgCtrlBlGrpVO();
						bkgCtrlBlGrpVO.setBlGrpSeq(bkgCtrlBlGrpVOs[i].getBlGrpSeq());
						dbDao.removeBlGroupCustomerByBlGroupSeq(bkgCtrlBlGrpVO);
						//master 삭제
						dbDao.removeBlGroupMaster(bkgCtrlBlGrpVO);
					}
				}
			}
			log.debug("--------------------------------1----------------------");
			
			// DETAIL(INSERT)
			if(bkgCtrlBlGrpCustVOs!=null && bkgCtrlBlGrpCustVOs.length>0){
				for(int i=0; i<bkgCtrlBlGrpCustVOs.length; i++) {
					if (bkgCtrlBlGrpCustVOs[i].getIbflag().equals("I")||bkgCtrlBlGrpCustVOs[i].getIbflag().equals("U")) {
						dbDao.removeBlGroupCustomer(bkgCtrlBlGrpCustVOs[i]);
						dbDao.addBlGroupCustomer(bkgCtrlBlGrpCustVOs[i],account);
					}
					
					else if(bkgCtrlBlGrpCustVOs[i].getIbflag().equals("D")){
						if(!dbDao.checkEcomUsrInfoForBlGrp(bkgCtrlBlGrpCustVOs[i])){
							dbDao.removeBlGroupCustomer(bkgCtrlBlGrpCustVOs[i]);
						}else{
							throw new EventException(new ErrorHandler("BKG08357", new String[]{bkgCtrlBlGrpCustVOs[i].getCustCd()}).getMessage());
						}
					}
				}
			}
			log.debug("--------------------------------1----------------------");
			// MASTER UPDATE
//			if(bkgCtrlBlGrpVOs!=null && bkgCtrlBlGrpVOs.length>0){
//				for(int i=0; i<bkgCtrlBlGrpVOs.length; i++) {
//					if (bkgCtrlBlGrpVOs[i].getIbflag().equals("U")) {
//						dbDao.modifyBlGroupMaster(bkgCtrlBlGrpVOs[i],account);
//					}
//				}
//			}
			log.debug("--------------------------------1----------------------");
        } catch(EventException ex) {
            throw ex;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * removeBlGroupMaster
	 * @param BkgCtrlBlGrpVO[] bkgCtrlBlGrpVOs
	 * @throws EventException
	 */
	public void removeBlGroupMaster(BkgCtrlBlGrpVO[] bkgCtrlBlGrpVOs) throws EventException {
		BkgCtrlBlGrpVO bkgCtrlBlGrpVO 	= new BkgCtrlBlGrpVO();
		
		try {		
			if(bkgCtrlBlGrpVOs!=null && bkgCtrlBlGrpVOs.length>0){
				for(int i=0; i<bkgCtrlBlGrpVOs.length; i++) {
					if(bkgCtrlBlGrpVOs[i].getIbflag().equals("D")){
					
						//detail 삭제
						bkgCtrlBlGrpVO = new BkgCtrlBlGrpVO();
						bkgCtrlBlGrpVO.setBlGrpSeq(bkgCtrlBlGrpVOs[i].getBlGrpSeq());
						dbDao.removeBlGroupCustomerByBlGroupSeq(bkgCtrlBlGrpVO);
						
						//master 삭제
						dbDao.removeBlGroupMaster(bkgCtrlBlGrpVO);
					}
				}
			}
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}		
	}

	/**
	 * removeBlGroupCustomer
	 * @param BkgCtrlBlGrpCustVO[] bkgCtrlBlGrpCustVOs
	 * @throws EventException
	 */
	public void removeBlGroupCustomer(BkgCtrlBlGrpCustVO[] bkgCtrlBlGrpCustVOs) throws EventException {
		try {		
			if(bkgCtrlBlGrpCustVOs!=null && bkgCtrlBlGrpCustVOs.length>0){
				for(int i=0; i<bkgCtrlBlGrpCustVOs.length; i++) {
					if(bkgCtrlBlGrpCustVOs[i].getIbflag().equals("D")){
						//detail 삭제
						dbDao.removeBlGroupCustomer(bkgCtrlBlGrpCustVOs[i]);
					}
				}
			}
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}		
	}

	/**
	 * 북중국 Manual BKG No 선 생성 현황 생성 하기전 생성가능한 인지 B.Office 체크
	 * @param String ofc
	 * @return String
	 * @throws EventException
	 */
	public String searchOfcCheck(String ofc) throws EventException {
		try {		
			return	dbDao.searchOfcCheck(ofc);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}		
	}

	/**
	 * E-BKG Handling Office 등록 화면 - 조회
	 * @param BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO
	 * @return List<BkgHandlingOfficeSetupVO>
	 * @throws EventException
	 */	
	public List<BkgHandlingOfficeSetupVO> searchHandlingOffice(BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO) throws EventException{
    	try {
			 return dbDao.searchHandlingOffice(bkgHandlingOfficeSetupVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
    }
	 
	/**
	 * E-BKG Handling Office 등록 화면 - 등록/수정/삭제<br>	
	 * 화면 ESM_BKG_1180
	 * @param bkgHandlingOfficeSetupVOs
	 * @param account
	 * @throws EventException
	 */
    public void manageHandlingOffice(BkgHandlingOfficeSetupVO[] bkgHandlingOfficeSetupVOs, SignOnUserAccount account) throws EventException{
    	
		try {
			for ( int i=0; i<bkgHandlingOfficeSetupVOs.length; i++ ) {
				bkgHandlingOfficeSetupVOs[i].setUpdUsrId(account.getUsr_id());
				bkgHandlingOfficeSetupVOs[i].setCreUsrId(account.getUsr_id());
				if ( bkgHandlingOfficeSetupVOs[i].getIbflag().equals("I")){
					bkgHandlingOfficeSetupVOs[i].setInsertCheck("check");
					dbDao.addHandlingOffice(bkgHandlingOfficeSetupVOs[i]);
				} else if ( bkgHandlingOfficeSetupVOs[i].getIbflag().equals("U")){
					dbDao.modifyHandlingOffice(bkgHandlingOfficeSetupVOs[i]);
				} else if ( bkgHandlingOfficeSetupVOs[i].getIbflag().equals("D")){
					dbDao.removeHandlingOffice(bkgHandlingOfficeSetupVOs[i]);
				}
				if(bkgHandlingOfficeSetupVOs[i].getIbflag().equals("I") || bkgHandlingOfficeSetupVOs[i].getIbflag().equals("U")){
					boolean dupChk = dbDao.checkHandlingOfficeDup(bkgHandlingOfficeSetupVOs[i]);
					if(dupChk)
						throw new EventException(new ErrorHandler("BKG01126", new String[]{}).getMessage());
				}
			}
		} catch(EventException ex) {
			throw ex;	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}	
//		return list;
    }

	/**
	 * BKG_CTRL_BL_GRP MAX SEQ
	 * @return String
	 * @throws EventException
	 */
	public String selectMaxBlGroupSeq() throws EventException {
		DBRowSet rowSet = null;
		try {			
			rowSet = dbDao.selectMaxBlGroupSeq();
			while(rowSet.next()){
				return rowSet.getString(1);
			}
		}catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return null;	
	}

	/**
	 * BKG_CTRL_PTY MAX SEQ
	 * @return String
	 * @exception EventException
	 */
	@Override
	public String selectMaxCntrPtySeq() throws EventException {
		DBRowSet rowSet = null;
		try {			
			rowSet = dbDao.selectMaxCntrPtySeq();
			while(rowSet.next()){
				return rowSet.getString(1);
			}
		}catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return null;	
	}			
    /**
     * select Hard Coding Setup List
     * @param HrdCdgDesc2VO hrdCdgDesc2VO
     * @return List<HrdCdgDesc2VO>
     * @throws EventException
     */	
    public List<HrdCdgDesc2VO> searchHrdCdgDesc2(HrdCdgDesc2VO hrdCdgDesc2VO) throws EventException{
    	try {
			 return dbDao.searchHrdCdgDesc2(hrdCdgDesc2VO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
    }
	/**
	 * select Hard Coding Contents List
	 * @param HrdCdgCtnt2VO hrdCdgCtnt2VO
	 * @return List<HrdCdgCtnt2VO>
	 * @throws EventException
	 */	
    public List<HrdCdgCtnt2VO> searchHrdCdgCtnt2(HrdCdgCtnt2VO hrdCdgCtnt2VO) throws EventException{
    	try {
			 return dbDao.searchHrdCdgCtnt2(hrdCdgCtnt2VO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
    }
    
    /**
	 * Hard Coding contents List Insert, Update, Delete.
	 * @param HrdCdgCtnt2VO[] hrdCdgCtnt2VOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */    
	public void manageHrdCdgCtnt(HrdCdgCtnt2VO[] hrdCdgCtnt2VOs,SignOnUserAccount account) throws EventException{
		
		try {			
			// 작업 구분 분할
			
			if(hrdCdgCtnt2VOs!=null && hrdCdgCtnt2VOs.length>0){
				for(int i=0; i<hrdCdgCtnt2VOs.length; i++) {
					
					if (hrdCdgCtnt2VOs[i].getIbflag().equals("I")) {
						dbDao.addHrdCdgCtnt2(hrdCdgCtnt2VOs[i],account);					
					}else if (hrdCdgCtnt2VOs[i].getIbflag().equals("D")) {
						dbDao.removeHrdCdgCtnt2(hrdCdgCtnt2VOs[i],account);
					}else if (hrdCdgCtnt2VOs[i].getIbflag().equals("U")) {
						dbDao.modifyHrdCdgCtnt2(hrdCdgCtnt2VOs[i],account);
	
					}
				}
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}
	
	/**check Duplicate Customer 
	 * @param BkgMdtItmVO[] bkgMdtItmVOs
	 * @return String
	 * @throws EventException
	 */
	public String checkDupCustCd(BkgMdtItmVO[] bkgMdtItmVOs) throws EventException {
		BkgMdtItmVO vo = new BkgMdtItmVO();
		try {
			for(int i = 0; i < bkgMdtItmVOs.length; i++){
				if(bkgMdtItmVOs[i].getIbflag().equals("I")){
					BkgMdtItmVO itmVO = new BkgMdtItmVO();
					List<BkgMdtItmVO> list = dbDao.searchMandatoryItemSetupList(itmVO);
					for(int idx = 0 ; idx < list.size() ; idx ++){
						vo = (BkgMdtItmVO)list.get(idx);
						
						log.debug("I [list] "+idx+":"+vo.getMdtCustTpCd()+":"+vo.getCustCntCd()+":"+vo.getCustSeq());
						log.debug("I [input] "+i+":"+bkgMdtItmVOs[i].getMdtCustTpCd()+":"+bkgMdtItmVOs[i].getCustCntCd()+":"+bkgMdtItmVOs[i].getCustSeq());
						
						if(vo.getMdtCustTpCd().equals(bkgMdtItmVOs[i].getMdtCustTpCd())
								&& vo.getCustCntCd().equals(bkgMdtItmVOs[i].getCustCntCd())
								&& vo.getCustSeq().equals(bkgMdtItmVOs[i].getCustSeq()))
						{
							return "Y";
						}
					}
				}else if(bkgMdtItmVOs[i].getIbflag().equals("U")){
					StringBuffer newStr = new StringBuffer();
					newStr = newStr.append(bkgMdtItmVOs[i].getMdtCustTpCd());
					newStr = newStr.append(bkgMdtItmVOs[i].getCustCntCd());
					newStr = newStr.append(bkgMdtItmVOs[i].getCustSeq());
					
					if(!bkgMdtItmVOs[i].getFcust().equals(newStr.toString())){

						BkgMdtItmVO itmVO = new BkgMdtItmVO();
						List<BkgMdtItmVO> list = dbDao.searchMandatoryItemSetupList(itmVO);
						for(int idx = 0 ; idx < list.size() ; idx ++){
							vo = (BkgMdtItmVO)list.get(idx);
							
							log.debug("U [list] "+idx+":"+vo.getMdtCustTpCd()+":"+vo.getCustCntCd()+":"+vo.getCustSeq());
							log.debug("U [input] "+i+":"+bkgMdtItmVOs[i].getMdtCustTpCd()+":"+bkgMdtItmVOs[i].getCustCntCd()+":"+bkgMdtItmVOs[i].getCustSeq());

							if(vo.getMdtCustTpCd().equals(bkgMdtItmVOs[i].getMdtCustTpCd())
									&& vo.getCustCntCd().equals(bkgMdtItmVOs[i].getCustCntCd())
									&& vo.getCustSeq().equals(bkgMdtItmVOs[i].getCustSeq()))
							{
								return "Y";
							}
						}
					}
				}
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
		return "N";
	}	
}
