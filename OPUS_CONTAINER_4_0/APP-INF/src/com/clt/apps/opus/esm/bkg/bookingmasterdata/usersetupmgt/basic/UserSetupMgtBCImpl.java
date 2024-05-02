/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UserSetupMgtBCImpl.java
 *@FileTitle : Mark & Description Template
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration.UserSetupMgtDBDAO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgInternetAuthorityVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlCluzStupVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlESignatureVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.RptItmStupVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCorrectionVO;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;
import com.clt.syscommon.common.table.BkgUsrTmpltVO;
import com.clt.syscommon.common.table.BkgXterSrchSetVO;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.PlaceOfIssueAssociationVO;		//SJH.20141121.ADD

/**
 * BookingMaterData Business Logic Basic Command implementation<br>
 * - BookingMaterData  handling business transaction<br>
 * 
 * @author 
 * @see UI_BKG-0365EventResponse,UserSetupMgtBC
 * @since J2EE 1.4
 */

public class UserSetupMgtBCImpl extends BasicCommandSupport implements UserSetupMgtBC {

    // Database Access Object
    private transient UserSetupMgtDBDAO dbDao = null;
    

    /**
     * UserSetupMgtBCImpl object creation<br>
     * UserSetupMgtDBDAO object creation.<br>
     */
    public UserSetupMgtBCImpl() {
        dbDao = new UserSetupMgtDBDAO();
    }
    
    /**
     * User Template List retrieve method.<br>
     *
     * @author 
     * @param usrTmpltVo
     * @return List<BkgUsrTmpltVO>
     * @exception EventException
     */
    public List<BkgUsrTmpltVO> searchUserTmpltList(BkgUsrTmpltVO usrTmpltVo) throws EventException {
        try {
            return dbDao.searchUserTemplate(usrTmpltVo);
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * User Template List management method.<br>
     *
     * @author 
     * @param usrTmpltVo
     * @param account
     * @exception EventException
     */
    public void manageUserTmpltList(BkgUsrTmpltVO[] usrTmpltVo, SignOnUserAccount account) throws EventException {
        try {
			for ( int i=0; i<usrTmpltVo.length; i++ ) {
				if ( usrTmpltVo[i].getIbflag().equals("I")){
                    usrTmpltVo[i].setUsrId(account.getUsr_id());
                    usrTmpltVo[i].setCreUsrId(account.getUsr_id());
					dbDao.addUserTemplate(usrTmpltVo[i]);					
				} else if ( usrTmpltVo[i].getIbflag().equals("U")){
                    usrTmpltVo[i].setUsrId(account.getUsr_id());
                    usrTmpltVo[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyUserTemplate(usrTmpltVo[i]);
				} else if ( usrTmpltVo[i].getIbflag().equals("D")){
                    usrTmpltVo[i].setUsrId(account.getUsr_id());
					dbDao.removeUserTemplate(usrTmpltVo[i]);
				}
			}
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
     * retrieve event process<br>
     * retrieve event for screen of UserSetupMgt.<br>
     * 
     * @author
     * @param bkgUsrTmpltVO BkgUsrTmpltVO
     * @return List<BkgUsrTmpltVO>
     * @exception EventException
     */
    public List<BkgUsrTmpltVO> searchRmkTemplate(BkgUsrTmpltVO bkgUsrTmpltVo) throws EventException {
        try {        	
            return dbDao.searchRmkTemplate(bkgUsrTmpltVo);
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * retrieve event process.<br>
     * retrieve event for UserSetupMgt.<br>
     * 
     * @author
     * @param String userid
     * @return BkgUsrDfltSetVO
     * @exception EventException
     */
    public BkgUsrDfltSetVO searchUserDefaultSetting (String userid) throws EventException {
        try {        	
            return dbDao.searchUserDefaultSetting(userid);
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * multi event process.<br>
     * multi event process for screen of In.<br>
     * 
     * @author
     * @param BkgUsrDfltSetVO vo
     * @exception EventException
     */
    public void createUserDefaultSettingByBooking(BkgUsrDfltSetVO vo) throws EventException {
        try {
            int result = dbDao.modifyUserDefaultsetting(vo);
            if(result < 1) {
                dbDao.addUserDefaultSetting(vo);
            }
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * retrieve event process.<br>
     * retrieving search condition for 0232 screen.
     * retrieve event for screen of UserSetupMgt<br>
     * 
     * @param String usrId
     * @return List<BkgXterSrchSetVO>
     * @exception EventException
     */
    public List<BkgXterSrchSetVO> searchUserXterSearchSet(String usrId) throws EventException {
        try {        	
            return dbDao.searchUserXterSearchSet(usrId);
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * multi event process.<br>
     * save search condition of 0232 by multi.<br> 
     * showing error msg in case of not existing Country Code.<br>
     * multi event process for screen of In.<br>
     *
     * @author
     * @param bkgXterSrchSetVO BkgXterSrchSetVO[]
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void manageUserXterSearchSet(BkgXterSrchSetVO[] bkgXterSrchSetVO, SignOnUserAccount account) throws EventException {
        try {
        	BookingUtil utilBc = new BookingUtil();

            for ( int i=0; i<bkgXterSrchSetVO.length; i++ ) {

            	if ( !"".equals(bkgXterSrchSetVO[i].getOrgCntCd()) ) {
					MdmCountryVO orgCntCd = utilBc.searchCountryCode(bkgXterSrchSetVO[i].getOrgCntCd());

					if ( orgCntCd == null ) {
						throw new EventException((String)new ErrorHandler("BKG00464", new String[]{bkgXterSrchSetVO[i].getOrgCntCd()}).getUserMessage());
					}
				}

				if (!"".equals(bkgXterSrchSetVO[i].getCustCntCd()) && !"".equals(bkgXterSrchSetVO[i].getCustSeq())
						&& !"0".equals(bkgXterSrchSetVO[i].getCustSeq())) {
					MdmCountryVO custCntCd = utilBc.searchCountryCode(bkgXterSrchSetVO[i].getCustCntCd());
					if ( custCntCd == null ) {
						throw new EventException((String)new ErrorHandler("BKG00464", new String[]{bkgXterSrchSetVO[i].getCustCntCd()}).getUserMessage());
					}

					utilBc.searchMdmCust(bkgXterSrchSetVO[i].getCustCntCd(), bkgXterSrchSetVO[i].getCustSeq(), "Y");
				}

            	if ( bkgXterSrchSetVO[i].getIbflag().equals("I")){
					bkgXterSrchSetVO[i].setUsrId(account.getUsr_id());
					bkgXterSrchSetVO[i].setCreUsrId(account.getUsr_id());
					bkgXterSrchSetVO[i].setUpdUsrId(account.getUsr_id());

					dbDao.addBkgXterSrchSet(bkgXterSrchSetVO[i]);					
				} else if ( bkgXterSrchSetVO[i].getIbflag().equals("U")){
					bkgXterSrchSetVO[i].setUsrId(account.getUsr_id());
					bkgXterSrchSetVO[i].setUpdUsrId(account.getUsr_id());
					
					dbDao.modifyBkgXterSrchSet(bkgXterSrchSetVO[i]);
				} else if ( bkgXterSrchSetVO[i].getIbflag().equals("D")){
					bkgXterSrchSetVO[i].setUsrId(account.getUsr_id());
				
					dbDao.removeBkgXterSrchSet(bkgXterSrchSetVO[i]);
				}
			}
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch(Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }

    /**
	 * retrieve 0743, 0064 B/L Print option.<br>
	 * 
	 * @author
	 * @param BkgUsrDfltSetVO bkgUsrDfltSetVO
	 * @param SignOnUserAccount account
	 * @return List<BkgUsrDfltSetVO>
	 */
	public List<BkgUsrDfltSetVO> searchUserPrintSetup(BkgUsrDfltSetVO bkgUsrDfltSetVO, SignOnUserAccount account) throws EventException{
		try {
			return dbDao.searchUserPrintSetup(bkgUsrDfltSetVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}    

	/**
	  * retrieve 0743 C/A No Option.<br>
	  * 
	  * @author
	  * @param String bkgNo 
  	  * @param SignOnUserAccount account	   
	  * @return List<BkgCorrectionVO>
	  * @throws EventException
	  */
	 public List<BkgCorrectionVO> searchUserPrintSetup2(String bkgNo, SignOnUserAccount account) throws EventException{
			try {
				return dbDao.searchUserPrintSetup2(bkgNo);
				
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
			}
	}    
	 
	 /**
	  * retrieve init condition for 0743_01 group print.<br> 
	  *
	  * @author
	  * @param BkgUsrDfltSetVO bkgUsrDfltSetVO 
	  * @return List<BkgUsrDfltSetVO>
	  * @throws EventException
	  */
	 public List<BkgUsrDfltSetVO> searchUserPrintSetup3(BkgUsrDfltSetVO bkgUsrDfltSetVO) throws EventException{
		 try {
			 return dbDao.searchUserPrintSetup3(bkgUsrDfltSetVO);
			 
		 } catch(DAOException ex) {
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		 } catch (Exception ex) {
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		 }
	 }    
	 
	 /**
	  * retrieve 0743_01 print setting.<br>
	  * 
	  * @author
	  * @param BkgUsrDfltSetVO bkgUsrDfltSetVO 
	  * @return List<BkgUsrDfltSetVO>
	  * @throws EventException
	  */
	 public List<BkgUsrDfltSetVO> searchUserPrintSetup4(BkgUsrDfltSetVO bkgUsrDfltSetVO) throws EventException{
		 try {
			 return dbDao.searchUserPrintSetup4(bkgUsrDfltSetVO);
			 
		 } catch(DAOException ex) {
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		 } catch (Exception ex) {
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		 }
	 }    
	 
    /**
	 *  save 0743,0064 B/L Print Option.<br>
	 *
	 * @author
	 * @param bkgUsrDfltSetVO BkgUsrDfltSetVO
	 * @param SignOnUserAccount account
     * @exception EventException
	 */
	public void manageUserPrintSetup(BkgUsrDfltSetVO bkgUsrDfltSetVO, SignOnUserAccount account) throws EventException{
    	
    	if(bkgUsrDfltSetVO == null)
    		return;
    	try { 
    		dbDao.manageUserPrintSetup(bkgUsrDfltSetVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException((String)new ErrorHandler("BKG00391").getUserMessage());
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException((String)new ErrorHandler("BKG00391").getUserMessage());
    	}    	
    }

	/**
	  * retrieve 0922 Office Detail.<br>
	  * 
	  * @author
	  * @param String ofcCd 
	  * @param SignOnUserAccount account
	  * @return List<MdmOrganizationVO>
	  * @throws EventException
	  */
	 public List<MdmOrganizationVO> searchOfficeDetail(String ofcCd, SignOnUserAccount account) throws EventException{
			try {
				return dbDao.searchOfficeDetail(ofcCd);
				
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
			}
	}   

    /**
     * searchRptItmStup
     * 
     * @author 
     * @param ofcCd
     * @param custCd
     * @return List<RptItmStupVO>
     * @throws EventException
     */
    public List<RptItmStupVO> searchRptItmStup(String ofcCd, String custCd) throws EventException{
        try {
            return dbDao.searchRptItmStup(ofcCd, custCd);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * manageRptItmStup
     * 
     * @author 
     * @param RptItmStupVO[] rptItmStupVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void manageRptItmStup(RptItmStupVO[] rptItmStupVOs, SignOnUserAccount account) throws EventException{

        BookingUtil utilCmd = new BookingUtil();

        try {
            if(rptItmStupVOs !=null && rptItmStupVOs.length > 0){
                
                String ofc_cd = null;
                String cust_cd = null;
                
                MdmCustVO mdmCustVO = null;
                String checkDup = null;
                
                for(int i=0; i<rptItmStupVOs.length; i++ ) {
                    // variables
                    ofc_cd = rptItmStupVOs[i].getBkgOfcCd();
                    cust_cd = rptItmStupVOs[i].getCustCd();

                    // manage
                    if (rptItmStupVOs[i].getIbflag().equals("I")){

                        // valid check
//                        if(cust_cd != null && !cust_cd.equals("")){
                        if(!cust_cd.equals("")){
                            if(cust_cd.length() < 3){
                                throw new EventException(new ErrorHandler("BKG06012", new String[]{cust_cd}).getMessage());
                            }else{
                                mdmCustVO = utilCmd.searchMdmCust(cust_cd.substring(0,2), cust_cd.substring(2), "");
                                if(mdmCustVO == null || mdmCustVO.getCustSeq() == null){
                                    throw new EventException(new ErrorHandler("BKG06012", new String[]{cust_cd}).getMessage());
                                }
                            }
                        }
                        
                        // dup. check
                        checkDup = dbDao.searchRptItmStupDup(ofc_cd, cust_cd);
                        if("Y".equals(checkDup)){
                            throw new EventException(new ErrorHandler("BKG00764", new String[]{ofc_cd+"-"+cust_cd}).getMessage());
                        }

                        rptItmStupVOs[i].setCreUsrId(account.getUsr_id());
                        rptItmStupVOs[i].setUpdUsrId(account.getUsr_id());
                        dbDao.addRptItmStup(rptItmStupVOs[i]);                   
                    } else if (rptItmStupVOs[i].getIbflag().equals("U")){
                        rptItmStupVOs[i].setUpdUsrId(account.getUsr_id());
                        dbDao.modifyRptItmStup(rptItmStupVOs[i]);
                    } else if (rptItmStupVOs[i].getIbflag().equals("D")){
                        dbDao.removeRptItmStup(rptItmStupVOs[i]);
                    }
                }// end of FOR(int i=0; i<rptItmStupVOs.length; i++ )
            }// end of IF(rptItmStupVOs !=null && rptItmStupVOs.length > 0)
        } catch(EventException ex) {
            throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * searchOfcCd
     * 
     * @author 
     * @return List<BkgComboVO>
     * @throws EventException
     */
    public List<BkgComboVO> searchOfcCd() throws EventException {
        try {
            return dbDao.searchOfcCd();
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
	 * Internet O/BL 승인권한에 등록된 유저를 조회한다.
	 * @param BkgInternetAuthorityVO bkgInternetAuthorityVO
	 * @return List<BkgInternetAuthorityVO>
	 * @exception EventException
	 */	
	public List<BkgInternetAuthorityVO> searchUserInternetAuth(BkgInternetAuthorityVO bkgInternetAuthorityVO) throws EventException{
		try {
			return dbDao.searchUserInternetAuth(bkgInternetAuthorityVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}    
	
	/**
     * 멀티 이벤트 처리<br>
     * Usersetupmgt 화면에 대한 멀티 이벤트 처리<br>
     * 
     * @param BkgInternetAuthorityVO[] bkgInternetAuthorityVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageUserInternetAuth(BkgInternetAuthorityVO[] bkgInternetAuthorityVO,SignOnUserAccount account) throws EventException{
    	
    	if(bkgInternetAuthorityVO == null)
			return;
		try { 
			List<BkgInternetAuthorityVO> insertVoList = new ArrayList<BkgInternetAuthorityVO>();
			List<BkgInternetAuthorityVO> updateVoList = new ArrayList<BkgInternetAuthorityVO>();
			List<BkgInternetAuthorityVO> deleteVoList = new ArrayList<BkgInternetAuthorityVO>();
			
			for ( int i=0; i<bkgInternetAuthorityVO.length; i++ ) {
				
				bkgInternetAuthorityVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( bkgInternetAuthorityVO[i].getIbflag().equals("I")){
					//USER CHECK LOGIC -- by kimtaekyun
					if(!dbDao.checkUserInfo(bkgInternetAuthorityVO[i])){
						log.error("BKG00768 ");		//User ID is missing !
						throw new EventException(new ErrorHandler("BKG00768").getMessage());	//User ID is missing !
					}
					insertVoList.add(bkgInternetAuthorityVO[i]);
				} else if ( bkgInternetAuthorityVO[i].getIbflag().equals("U")){
					updateVoList.add(bkgInternetAuthorityVO[i]);
				} else if ( bkgInternetAuthorityVO[i].getIbflag().equals("D")){
					deleteVoList.add(bkgInternetAuthorityVO[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeInternetAuth(deleteVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addInternetAuth(insertVoList);
			}
			
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyInternetAuth(updateVoList);
			}
			
			
		} catch (EventException ex) {
			throw ex;			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} 	
    }
    
	/**
     * search B/L Signature List <br>
     * 
     * @param String countryCode
     * @param String eSignatureLastNm
     * @return List<BlESignatureVO>
     * @exception EventException
     */
	public List<BlESignatureVO> searchBlESignatureList(String countryCode, String eSignatureLastNm) throws EventException {
		try {
			 return dbDao.searchBlESignatureList(countryCode, eSignatureLastNm);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
     * search B/L Signature <br>
     * 
     * @param String blEsigSeq
     * @return List<BlESignatureVO>
     * @exception EventException
     */
	public List<BlESignatureVO> searchBlESignature(String blEsigSeq) throws EventException {
		try {
			 return dbDao.searchBlESignature(blEsigSeq);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * add B/L Signature List <br>
     * 
     * @param BlESignatureVO blESignatureVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void addBlESignature(BlESignatureVO blESignatureVO, SignOnUserAccount account) throws EventException {
		try {
			 dbDao.addBlESignature(blESignatureVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * modify B/L Signature List  <br>
     * 
     * @param BlESignatureVO blESignatureVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void modifyBlESignature(BlESignatureVO blESignatureVO, SignOnUserAccount account) throws EventException {
		try {
			 dbDao.modifyBlESignature(blESignatureVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * remove B/L Signature List   <br>
     * 
     * @param String blEsigSeq
     * @exception EventException
     */
	public void removeBlESignature(String blEsigSeq) throws EventException {
		try {
			 dbDao.removeBlESignature(blEsigSeq);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	//------------------------------------------------------------------------------------------------------- SJH.20141121.ADD

	/**
     * search Place of issue association   <br>
     * 
     * @param String countryCode
     * @param String blIssOfcNm
     * @return List<PlaceOfIssueAssociationVO>
     * @exception EventException
     */
	public List<PlaceOfIssueAssociationVO> searchPlaceOfIssueAssociationList(String countryCode, String blIssOfcNm) throws EventException {
		try {
			 return dbDao.searchPlaceOfIssueAssociationList(countryCode, blIssOfcNm);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * remove Place of issue association   <br>
     * 
     * @param String blEsigSeq
     * @exception EventException
     */
	public void removePlaceOfIssueAssociation(String blEsigSeq) throws EventException {
		try {
			 dbDao.removePlaceOfIssueAssociation(blEsigSeq);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	

	/**
     * search Place of issue association POPUP   <br>
     * 
     * @param String blEsigAsgnSeq
     * @return List<PlaceOfIssueAssociationVO>
     * @exception EventException
     */
	public List<PlaceOfIssueAssociationVO> searchPlaceOfIssueAssociation(String blEsigAsgnSeq) throws EventException {
		try {
			 return dbDao.searchPlaceOfIssueAssociation(blEsigAsgnSeq);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * add Place of issue association POPUP   <br>
     * 
     * @param PlaceOfIssueAssociationVO placeOfIssueAssociationVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void addPlaceOfIssueAssociation(PlaceOfIssueAssociationVO placeOfIssueAssociationVO, SignOnUserAccount account) throws EventException {
		try {
			 dbDao.addPlaceOfIssueAssociation(placeOfIssueAssociationVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * modify Place of issue association POPUP   <br>
     * 
     * @param PlaceOfIssueAssociationVO placeOfIssueAssociationVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void modifyPlaceOfIssueAssociation(PlaceOfIssueAssociationVO placeOfIssueAssociationVO, SignOnUserAccount account) throws EventException {
		try {
			 dbDao.modifyPlaceOfIssueAssociation(placeOfIssueAssociationVO, account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
     * searchEmployeeList   <br>
     * 
     * @param PlaceOfIssueAssociationVO placeOfIssueAssociationVO
     * @return List<PlaceOfIssueAssociationVO>
     * @exception EventException
     */
	public List<PlaceOfIssueAssociationVO> searchEmployeeList(PlaceOfIssueAssociationVO placeOfIssueAssociationVO) throws EventException {
		List<PlaceOfIssueAssociationVO> list = null;
		try {
			//SJH.20141125.MOD : PARAM
			list = dbDao.searchEmployeeList(placeOfIssueAssociationVO.getCntCd());
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	

    /**
     * searchCntClause
     * 
     * @author 
     * @param String orgCntCd
     * @return List<BlCluzStupVO>
     * @throws EventException
     */
    public List<BlCluzStupVO> searchBlCluzStup(String orgCntCd) throws EventException{
        try {
            return dbDao.searchBlCluzStup(orgCntCd);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * manage country clause
     * 
     * @author 
     * @param BlCluzStupVO[] blCluzStupVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void manageBlCluzStup(BlCluzStupVO[] blCluzStupVOs, SignOnUserAccount account) throws EventException{

        try {
            if(blCluzStupVOs !=null && blCluzStupVOs.length > 0){
                
                for(int i=0; i<blCluzStupVOs.length; i++ ) {

                    // manage
                    if (blCluzStupVOs[i].getIbflag().equals("I")){
          
                    	blCluzStupVOs[i].setCreUsrId(account.getUsr_id());
                    	blCluzStupVOs[i].setUpdUsrId(account.getUsr_id());

                        dbDao.addBlCluzStup(blCluzStupVOs[i]);                   
                    } else if (blCluzStupVOs[i].getIbflag().equals("U")){
                    	blCluzStupVOs[i].setUpdUsrId(account.getUsr_id());
                        dbDao.modifyBlCluzStup(blCluzStupVOs[i]);
                    } else if (blCluzStupVOs[i].getIbflag().equals("D")){
                        dbDao.removeBlCluzStup(blCluzStupVOs[i]);
                    }
                }
            }
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

}