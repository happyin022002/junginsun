/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingProcessMgtBCImpl.java
*@FileTitle : Location of goods Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.04 김경섭
* 1.0 Creation
* 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration.BookingProcessMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCstmsAdvScacVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgDocPerfOfcVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEsvcHndlOfcVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkganDestOfcStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CgoClzTmStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CodeDescVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBackEndJob;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-BookingMasterDataSC Business Logic Basic Command implementation<br>
 * - ALPS-BookingMasterDataSC 에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Gyoung Sub
 * @see esm_bkg_0374EventResponse 참조
 * @since J2EE 1.6
 */

public class BookingProcessMgtBCImpl extends BasicCommandSupport implements BookingProcessMgtBC{
 
	// Database Access Object
	private transient BookingProcessMgtDBDAO dbDao = null;

	/**
	 * BookingProcessMgtBCImpl 객체 생성<br>
	 * BookingProcessMgtDBDAO 생성한다.<br>
	 */
	public BookingProcessMgtBCImpl() {
		dbDao = new BookingProcessMgtDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 *  BookingProcessMgt화면에 대한 조회 이벤트 처리<br>
	 * @author Lee Jin Seo
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
	 *  0374  Arrival Notice의 Office Default  US Destination Office Setup 을 조회합니다.<br>
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
	 * 0374  저장을 위한 조회. EQ OFC가 HQ OFC에 이미 등록되어 있으면 저장을 하지 못한다.<br>
	 * 단. EQ OFC와 HQ OFC가 같은 경우는 예외이다<br>
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
     * 0374  Arrival Notice의 Office Default  US Destination Office Setup 을 트랜잭션 처리합니다.<br>	
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
			 * INPUT 필드의 값을 트랜잭션시 시용한다.
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
	 *  Office Setup 에 정보를 조회합니다.(ESM_BKG_0741)<br>
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
	 * Office Setup 에 Office 를 저장/수정/삭제 합니다. (ESM_BKG_0741)<br>
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
	 *  Office Setup 에 등록된 Office code 인지 여부를 체크합니다.(ESM_BKG_0741)<br>
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
	 *  Office Setup 에 등록된 Office 가 H/OFC에 등록 되지 않도록 Office code 를 체크합니다.(ESM_BKG_0741)<br>
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
	 * NVOCC SCAC (Standard Carrier Alpha Code 정보를 조회한다.(ESM_BKG_0040)<br>
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
	 * NVOCC SCAC (Standard Carrier Alpha Code) 정보를 입력 한다.(ESM_BKG_0040)<br>
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
	 * Activate 시점에 처음 만들어 Booking을 받을 수 있는 최종 시점을 관리 하는 BDR LOG 테이블을<br>
	 * 관리할 목적. SKD를 Update될 때마다 항상 조건을 확인한 후 VBL_ESTBDR_DT, VBL_FESTBDR_DT를<br>
	 * 수정하도록 한다.<br>
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
	 * Activate 시점에 처음 만들어 Booking을 받을 수 있는 최종 시점을 관리 하는 BDR LOG 테이블을<br>
	 * 관리할 목적. SKD를 Update될 때마다 항상 조건을 확인한 후 VBL_ESTBDR_DT, VBL_FESTBDR_DT를<br>
	 * 수정하도록 한다.<br>
	 * 
	 * @param BkgVvdBdrLogVO vo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	
	public String manageBKGBDRLOGBackEndJob(BkgVvdBdrLogVO vo,SignOnUserAccount account) throws EventException {
		BkgBdrLogBackEndJob bkgBdrLogBackEndJob = new BkgBdrLogBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			vo.setUpdUsrId("ESVCUSER");
			bkgBdrLogBackEndJob.setBkgVvdBdrLogVO(vo);
		
			return backEndJobManager.execute(bkgBdrLogBackEndJob, account.getUsr_id(), "manageBKGBDRLOGBackEndJob");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * User SMS list를 조회<br>
	 * 
	 * @param BkgUserSmsInputVO bkgUserSmsInputVO
	 * @return List<BkgUserSmsListVO>
	 * @exception EventException
	 */	
	public List<BkgUserSmsListVO> searchSmsRcvList(BkgUserSmsInputVO bkgUserSmsInputVO) throws EventException {
		try {
			
			return dbDao.searchSmsRcvList(bkgUserSmsInputVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * User SMS list를 add<br>
	 * 
	 * @param BkgUserSmsListVO[] bkgUserSmsListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageSmsRcvList(BkgUserSmsListVO[] bkgUserSmsListVOs, SignOnUserAccount account) throws EventException {
//		BkgUserSmsListVO cvo = new BkgUserSmsListVO();
		try {
			
			for ( int i=0; i<bkgUserSmsListVOs.length; i++ ) {
				
				if ( bkgUserSmsListVOs[i].getIbflag().equals("I")){
//					cvo.setScacCd(bkgCstmsAdvScacVOs[i].getScacCd());
//					List<BkgCstmsAdvScacVO> cVos = dbDao.searchScacNumber(cvo);
//					if (cVos != null && cVos.size() > 0){
//						throw new EventException(new ErrorHandler("BKG03056",new String[]{"SCAC Code: ["+bkgCstmsAdvScacVOs[i].getScacCd() + "]"}).getMessage());
//					}
					dbDao.addSmsRcvList (bkgUserSmsListVOs[i], account);					
//					dbDao.addScacByCSTMS(bkgCstmsAdvScacVOs[i]);
					
				} else if ( bkgUserSmsListVOs[i].getIbflag().equals("U")){

//					dbDao.modifyScacNumber(bkgUserSmsListVOs[i]);
					dbDao.modifytSmsRcvList(bkgUserSmsListVOs[i], account);
				} else if ( bkgUserSmsListVOs[i].getIbflag().equals("D")){
				
					dbDao.removeSmsRcvList(bkgUserSmsListVOs[i], account);
//					dbDao.removeScacNumber(bkgUserSmsListVOs[i]);
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
	 * office cnt check<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param String slanCd
	 * @param String dirCd
	 * @return String 
	 * @exception EventException
	 */	
	public String chkOfcCnt(SignOnUserAccount account, String slanCd, String dirCd) throws EventException {
		try {
			
			return dbDao.chkOfcCnt(account, slanCd, dirCd);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Cargo Closing Time Setup list를 조회<br>
	 * 
	 * @param CgoClzTmStupVO cgoClzTmStupVO
	 * @return List<CgoClzTmStupVO>
	 * @exception EventException
	 */	
	public List<CgoClzTmStupVO> searchCgoClzTmStupList(CgoClzTmStupVO cgoClzTmStupVO) throws EventException {
		try {
			
			return dbDao.searchCgoClzTmStupList(cgoClzTmStupVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * cargo closing time setup list를 추가, 수정, 삭제<br>
	 * 
	 * @param CgoClzTmStupVO[] cgoClzTmStupVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageCgoClzTmList(CgoClzTmStupVO[] cgoClzTmStupVOs, SignOnUserAccount account) throws EventException {

		try {
			
			for ( int i=0; i<cgoClzTmStupVOs.length; i++ ) {
				
				if ( cgoClzTmStupVOs[i].getIbflag().equals("I")){
					dbDao.addCgoClzTmList (cgoClzTmStupVOs[i], account);	
					
				} else if ( cgoClzTmStupVOs[i].getIbflag().equals("U")){

					dbDao.modifytCgoClzTmList(cgoClzTmStupVOs[i], account);
				} else if ( cgoClzTmStupVOs[i].getIbflag().equals("D")){
				
					dbDao.removeCgoClzTmList(cgoClzTmStupVOs[i], account);
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
	 * Cargo Closing Time Setup check<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param String polCd
	 * @param String laneCd
	 * @param String dirCd
	 * @return List<CgoClzTmStupVO> 
	 * @exception EventException
	 */	
	public List<CgoClzTmStupVO> chkSetUpCnt(SignOnUserAccount account, String polCd, String laneCd, String dirCd) throws EventException {
		try {
			
			return dbDao.chkSetUpCnt(account, polCd, laneCd, dirCd);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 *  이미 등록된 Bkg Office & POR 인지 여부를 체크합니다.(ESM_BKG_0741)<br>
	 * 
	 * @param BkgDocPerfOfcVO bkgDocPerfOfcVO
	 * @return List<BkgDocPerfOfcVO>
	 * @exception EventException
	 */	
	public List<BkgDocPerfOfcVO> checkBkgOfcPorPfmc(BkgDocPerfOfcVO bkgDocPerfOfcVO) throws EventException {
		try {
			return dbDao.checkPorPfmc(bkgDocPerfOfcVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
}