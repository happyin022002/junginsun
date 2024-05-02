/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingProcessMgtBCImpl.java
*@FileTitle : Location of goods Setup
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration.BookingProcessMgtDBDAO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCstmsAdvScacVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgDocPerfOfcVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEsvcHndlOfcVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkganDestOfcStupVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CodeDescVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBackEndJob;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * BookingMasterDataSC Business Logic Basic Command implementation<br>
 * - BookingMasterDataSC handling business transaction<br>
 *
 * @author
 * @see esm_bkg_0374EventResponse 
 * @since J2EE 1.6
 */

public class BookingProcessMgtBCImpl extends BasicCommandSupport implements BookingProcessMgtBC{
 
	// Database Access Object
	private transient BookingProcessMgtDBDAO dbDao = null;

	/**
	 * BookingProcessMgtBCImpl objects generate.<br>
	 * BookingProcessMgtDBDAO is created.<br>
	 */
	public BookingProcessMgtBCImpl() {
		dbDao = new BookingProcessMgtDBDAO();
	}
	
	/**
	 * event processing<br>
	 * @author 
	 * @param CodeDescVO codeDescVO
	 * @return List<CodeDescVO>
	 * @exception EventException
	 */
	public List<CodeDescVO> searchChargeCode(CodeDescVO codeDescVO) throws EventException {
		try {
			
			return dbDao.searchChargeCode(codeDescVO);
		
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage());
		}
	}
	/**
	 *  0374  Arrival Notice of the Office Default,  US Destination Office Setup search<br>
	 *  
	 * @param String officeCD
	 * @param String  handlingOfficeCD
	 * @return List<BkganDestOfcStupVO>
	 * @throws EventException
	 */
	public List<BkganDestOfcStupVO> searchANDestOfcList(String officeCD,String  handlingOfficeCD) throws EventException {
		 
		 try {
			 return dbDao.searchANDestOfcList(officeCD,handlingOfficeCD);
		 } catch(DAOException ex) {
			 log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		 } catch (Exception ex) {
			 	log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		 }
	 }
		 
	/**
	 * 0374  Search for storing. EQ OFC already exists in the HQ OFC does not save.<br>
	 * exception: EQ OFC = HQ OFC<br>
	 *  
	 * @param String officeCD
	 * @param String  handlingOfficeCD
	 * @return List<BkganDestOfcStupVO>
	 * @throws EventException
	 */
	public List<BkganDestOfcStupVO> searchANDestOfcList2(String officeCD,String  handlingOfficeCD) throws EventException {
		
		try {
			return dbDao.searchANDestOfcList2(officeCD,handlingOfficeCD);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	 
	/**
     * 0374  Transaction processing.<br>	
     * 
	 * @param BkganDestOfcStupVO[] bkganDestOfcStupVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageANDestOfcList(BkganDestOfcStupVO[] bkganDestOfcStupVO,SignOnUserAccount account) throws EventException{
    	
    	if(bkganDestOfcStupVO == null)
			return;
    	
		try {
			/*
			 * INPUT is used on the transaction value.
			 * */
			String officeCD ="";
			String handlingOfficeCD="";
			
			List<BkganDestOfcStupVO> insertVoList = new ArrayList<BkganDestOfcStupVO>();
			List<BkganDestOfcStupVO> updateVoList = new ArrayList<BkganDestOfcStupVO>();
			List<BkganDestOfcStupVO> deleteVoList = new ArrayList<BkganDestOfcStupVO>();
			
			for ( int i=0; i<bkganDestOfcStupVO.length; i++ ) {
				
				bkganDestOfcStupVO[i].setUpdUsrId(account.getUsr_id());
				if(i ==0){
					officeCD = bkganDestOfcStupVO[i].getPEqCtrlOfcCd();
					handlingOfficeCD = bkganDestOfcStupVO[i].getPHndlOfcCd();
				}
				
				bkganDestOfcStupVO[i].setEqCtrlOfcCd(officeCD);
				bkganDestOfcStupVO[i].setHndlOfcCd(handlingOfficeCD);
				
				if ( bkganDestOfcStupVO[i].getIbflag().equals("I")){
					insertVoList.add(bkganDestOfcStupVO[i]);
				} else if ( bkganDestOfcStupVO[i].getIbflag().equals("U")){
					updateVoList.add(bkganDestOfcStupVO[i]);
				} else if ( bkganDestOfcStupVO[i].getIbflag().equals("D")){
					deleteVoList.add(bkganDestOfcStupVO[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeANDestOfcList(deleteVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyANDestOfcList(updateVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addANDestOfcList(insertVoList);
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
	 *  Search Office Setup(ESM_BKG_0741)<br>
	 * 
	 * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	 * @return List<BkgDpcsUsrGrp2VO>
	 * @exception EventException
	 */
	public List<BkgDocPerfOfcVO> searchOfficePfmc(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws EventException {
		try {
			return dbDao.searchOfficePfmc(bkgDocPerfOfcVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Office Setup save / modify / delete it. (ESM_BKG_0741)<br>
	 * 
	 * @param BkgEsvcHndlOfcVO[] bkgEsvcHndlOfcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	
	public void manageOfficePfmc(BkgEsvcHndlOfcVO[] bkgEsvcHndlOfcVO,SignOnUserAccount account) throws EventException{
		
		try {
			for ( int i=0 ; i < bkgEsvcHndlOfcVO.length ; i++) {
				log.debug("ibflag = " + bkgEsvcHndlOfcVO[i].getIbflag());
				if ( bkgEsvcHndlOfcVO[i].getIbflag().equals("I")){

					bkgEsvcHndlOfcVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.addPfmcOfficeCd(bkgEsvcHndlOfcVO[i]);					
				} else if ( bkgEsvcHndlOfcVO[i].getIbflag().equals("U")){
					
					bkgEsvcHndlOfcVO[i].setUpdUsrId(account.getUsr_id());					
					dbDao.modifyPfmcOfficeCd(bkgEsvcHndlOfcVO[i]);
				} else if ( bkgEsvcHndlOfcVO[i].getIbflag().equals("D")){
					
					bkgEsvcHndlOfcVO[i].setUpdUsrId(account.getUsr_id());					
					dbDao.removePfmcOfficeCd(bkgEsvcHndlOfcVO[i]);
				}
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
	 *  Office code checking for the presence.(ESM_BKG_0741)<br>
	 * 
	 * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	 * @return List<BkgDocPerfOfcVO>
	 * @exception EventException
	 */	
	public List<BkgDocPerfOfcVO> checkOfficePfmc(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws EventException {
		try {
			return dbDao.checkOfficePfmc(bkgDocPerfOfcVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 *  Office code to check for duplicates.(ESM_BKG_0741)<br>
	 * 
	 * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	 * @return List<BkgDocPerfOfcVO>
	 * @exception EventException
	 */	
	public List<BkgDocPerfOfcVO> checkCtrlOffice(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws EventException {
		try {
			return dbDao.checkCtrlOffice(bkgDocPerfOfcVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * NVOCC SCAC (Standard Carrier Alpha Code search) (ESM_BKG_0040)<br>
	 * @param BkgCstmsAdvScacVO bkgCstmsAdvScacVO
	 * @return List<BkgCstmsAdvScacVO>
	 * @exception EventException
	 */	
	public List<BkgCstmsAdvScacVO>  searchScacNumber (BkgCstmsAdvScacVO bkgCstmsAdvScacVO) throws EventException {
		try {
			
			return dbDao.searchScacNumber(bkgCstmsAdvScacVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	/**
	 * NVOCC SCAC (Standard Carrier Alpha Code) Information input(ESM_BKG_0040)<br>
	 * @param BkgCstmsAdvScacVO[] bkgCstmsAdvScacVOs
	 * @exception EventException
	 */	
	public void manageScacNumber(BkgCstmsAdvScacVO[] bkgCstmsAdvScacVOs) throws EventException {
		BkgCstmsAdvScacVO cvo = new BkgCstmsAdvScacVO();
		try {
			
			for ( int i=0; i<bkgCstmsAdvScacVOs.length; i++ ) {
				
				if ( bkgCstmsAdvScacVOs[i].getIbflag().equals("I")){
					cvo.setScacCd(bkgCstmsAdvScacVOs[i].getScacCd());
					List<BkgCstmsAdvScacVO> cVos = dbDao.searchScacNumber(cvo);
					if (cVos != null && cVos.size() > 0){
						throw new EventException(new ErrorHandler("BKG03056",new String[]{"SCAC Code: ["+bkgCstmsAdvScacVOs[i].getScacCd() + "]"}).getMessage());
					}
					dbDao.addScacNumber(bkgCstmsAdvScacVOs[i]);					
					dbDao.addScacByCSTMS(bkgCstmsAdvScacVOs[i]);
					
				} else if ( bkgCstmsAdvScacVOs[i].getIbflag().equals("U")){

					dbDao.modifyScacNumber(bkgCstmsAdvScacVOs[i]);
				} else if ( bkgCstmsAdvScacVOs[i].getIbflag().equals("D")){
				
					dbDao.removeScacNumber(bkgCstmsAdvScacVOs[i]);
					dbDao.removeScacByCSTMS(bkgCstmsAdvScacVOs[i]);					
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
	}  
	
	/**
	 * SKD  Update-> VBL_ESTBDR_DT, VBL_FESTBDR_DT modify<br>
	 * 
	 * @param BkgVvdBdrLogVO vo
	 * @param SignOnUserAccount account
	 * @return BkgVvdBdrLogVO
	 * @exception EventException
	 */	 
	public BkgVvdBdrLogVO manageBKGBDRLOG(BkgVvdBdrLogVO vo,SignOnUserAccount account) throws EventException {
		try {
			/*if(account==null){
				vo.setUpdUsrId("ESVCUSER");
			} else {
				vo.setUpdUsrId(account.getUsr_id());
			}*/
			vo.setUpdUsrId("ESVCUSER");
			if (vo.getVslCd().equals("") 
					|| vo.getSkdVoyNo().equals("") 
					|| vo.getSkdDirCd().equals("")){
				throw new EventException(new ErrorHandler("BKG08118",new String[]{}).getMessage());
			}
			vo = dbDao.manageBKGBDRLOG(vo);	
			return vo;
			
		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}  
	
	/**
	 * SKD  Update-> VBL_ESTBDR_DT, VBL_FESTBDR_DT modify<br>
	 * 
	 * @param BkgVvdBdrLogVO vo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	
	public String manageBKGBDRLOGBackEndJob(BkgVvdBdrLogVO vo,SignOnUserAccount account) throws EventException {
		BkgBdrLogBackEndJob bkgBdrLogBackEndJob = new BkgBdrLogBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		String usrId = "ESVCUSER";
		try {
			if(account != null && account.getUsr_id() != null && !account.getUsr_id().equals("")){
				usrId = account.getUsr_id();
			}
			vo.setUpdUsrId(usrId);
			bkgBdrLogBackEndJob.setBkgVvdBdrLogVO(vo);
			
			return backEndJobManager.execute(bkgBdrLogBackEndJob, usrId, "manageBKGBDRLOGBackEndJob");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
}