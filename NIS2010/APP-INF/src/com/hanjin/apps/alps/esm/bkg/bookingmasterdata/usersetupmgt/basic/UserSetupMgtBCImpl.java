/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UserSetupMgtBCImpl.java
 *@FileTitle : Mark & Description Template
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.27
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.27 김영출
 * 1.0 Creation
 * ------------------------------------------------------
 * HISTORY
 * 2014.10.20 김도현[CHM-201431786] 테스트_온라인(WEB) Booking 개선 (1차) - Web Booking Manual Upload Setup Table 추가 
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.MandatoryItemSetupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration.UserSetupMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgAlocMgmtVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgChkPntItemTpVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgChkPntItemVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgCustChkPntVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgInternetAuthorityVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgSrchSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlckKwListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.CustChkPntAttachVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.DraftBlImageVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.RptItmStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.TroRmkStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgAlocMgmtDetailVO;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCorrectionVO;
import com.hanjin.syscommon.common.table.BkgUsrDfltSetVO;
import com.hanjin.syscommon.common.table.BkgUsrTmpltVO;
import com.hanjin.syscommon.common.table.BkgXterSrchSetVO;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.WebBkgManualUploadSetupVO;

/**
 * NIS2010-BookingMaterData Business Logic Basic Command implementation<br>
 * - NIS2010-BookingMaterData에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Youngchul
 * @see UI_BKG-0365EventResponse,UserSetupMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class UserSetupMgtBCImpl extends BasicCommandSupport implements UserSetupMgtBC {

    // Database Access Object
    private transient UserSetupMgtDBDAO dbDao = null;
    

    /**
     * UserSetupMgtBCImpl 객체 생성<br>
     * UserSetupMgtDBDAO를 생성한다.<br>
     */
    public UserSetupMgtBCImpl() {
        dbDao = new UserSetupMgtDBDAO();
    }
    
    /**
     * User Template List 조회 메소드.<br>
     *
     * @author KimYoungchul
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
     * User Template List 관리 메소드.<br>
     *
     * @author KimYoungchul
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
     * 조회 이벤트 처리<br>
     * UserSetupMgt화면에 대한 조회 이벤트 처리<br>
     * 
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
     * 조회 이벤트 처리<br>
     * UserSetupMgt화면에 대한 조회 이벤트 처리<br>
     * 
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
     * 멀티 이벤트 처리<br>
     * In화면에 대한 멀티 이벤트 처리<br>
     * 
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
     * 조회 이벤트 처리<br>
     * 0232 화면의 조회조건 Set을 조회한다<br> 
     * UserSetupMgt화면에 대한 조회 이벤트 처리<br>
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
     * 멀티 이벤트 처리<br>
     * 0232화면의 조회조건 Set을 멀티로 저장한다<br> 
     * 없는 Country Code시 오류 메시지 발생<br>
     * In화면에 대한 멀티 이벤트 처리<br>
     * 
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
			
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} 	
    }

    /**
	 * 0743,0064 B/L Print 옵션을 조회합니다.<br>
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
	  * 0743 C/A No 옵션을 조회합니다.<br>
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
	  * 0743_01 그룹 프린트를 위해 초기 조건들을 조회한다.<br>
	  * @param BkgUsrDfltSetVO bkgUsrDfltSetVO 
	  * @param String module
	  * @return List<BkgUsrDfltSetVO>
	  * @throws EventException
	  */
	 public List<BkgUsrDfltSetVO> searchUserPrintSetup3(BkgUsrDfltSetVO bkgUsrDfltSetVO, String module) throws EventException{
		 try {
			 return dbDao.searchUserPrintSetup3(bkgUsrDfltSetVO, module);
			 
		 } catch(DAOException ex) {
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		 } catch (Exception ex) {
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		 }
	 }    
	 
	 /**
	  * 0743_01 프린트 설정을 조회한다.<br>
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
	 *  0743,0064 B/L Print 옵션을 저장합니다.<br>
	 *  
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
	  * 0922 Office 상세정보를 조회합니다.<br>
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
     * @author KimYoungchul
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
     * @author KimYoungchul
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
                        if(cust_cd != null && !cust_cd.equals("")){
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
     * @author KimYoungchul
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
     * searchTroRmkStup
     * 
     * @author WonjooCho
     * @param String bkgTroOfcCd
     * @return List<TroRmkStupVO>
      * @throws EventException
     */
    public List<TroRmkStupVO> searchTroRmkStup(String bkgTroOfcCd) throws EventException{
        try {
            return dbDao.searchTroRmkStup(bkgTroOfcCd);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * manageTroRmkStup
     * 
     * @author Wonjoo Cho
     * @param TroRmkStupVO[] troRmkStupVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void manageTroRmkStup(TroRmkStupVO[] troRmkStupVOs, SignOnUserAccount account) throws EventException{

        try {
            if(troRmkStupVOs !=null && troRmkStupVOs.length > 0){
                
                String io_bnd_cd = null;
                String bkg_tro_ofc_cd = null;

                String checkDup = null;
                
                for(int i=0; i<troRmkStupVOs.length; i++ ) {
                    
                    bkg_tro_ofc_cd = troRmkStupVOs[i].getBkgTroOfcCd();
                    io_bnd_cd = troRmkStupVOs[i].getIoBndCd();
                    
                    // manage
                    if (troRmkStupVOs[i].getIbflag().equals("I")){                       
                        // dup. check
                        checkDup = dbDao.searchTroRmkStupDup(bkg_tro_ofc_cd, io_bnd_cd);
                        if("Y".equals(checkDup)){
                            throw new EventException(new ErrorHandler("BKG00764", new String[]{bkg_tro_ofc_cd}).getMessage());
                        }

                        troRmkStupVOs[i].setCreUsrId(account.getUsr_id());
                        troRmkStupVOs[i].setUpdUsrId(account.getUsr_id());
                        dbDao.addTroRmkStup(troRmkStupVOs[i]);                   
                    } else if (troRmkStupVOs[i].getIbflag().equals("U")){
                    	troRmkStupVOs[i].setUpdUsrId(account.getUsr_id());
                        dbDao.modifyTroRmkStup(troRmkStupVOs[i]);
                    } else if (troRmkStupVOs[i].getIbflag().equals("D")){
                        dbDao.removeTroRmkStup(troRmkStupVOs[i]);
                    }
                }// end of FOR(int i=0; i<rptItmStupVOs.length; i++ )
            }// end of IF(rptItmStupVOs !=null && rptItmStupVOs.length > 0)
        }catch(EventException ex) {
            throw ex;
        }catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * Booking Allocation Master Table 화면 조회 메소드
     * 
     * @author ChoiMoonHwan
     * @param BkgAlocMgmtVO bkgAlocMgmtVO
     * @return List<BkgAlocMgmtVO>
     * @throws EventException
     */
    public List<BkgAlocMgmtVO> searchBkgAlocMgmt(BkgAlocMgmtVO bkgAlocMgmtVO) throws EventException{
        try {
            return dbDao.searchBkgAlocMgmt(bkgAlocMgmtVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * Booking Allocation Master Table 화면 관리 메소드.<br>
     *
     * @author ChoiMoonHwan
     * @param BkgAlocMgmtVO[] bkgAlocMgmtVO
     * @param account
     * @exception EventException
     */
    public void manageBkgAlocMgmt(BkgAlocMgmtVO[] bkgAlocMgmtVO, SignOnUserAccount account) throws EventException {
        try {
        	//BookingUtil utilCmd = new BookingUtil();
        	int bkgAlocMgmtSeq = 0; 
        	String[] trunk_pod_cd = null;
        	String[] trunk_pol_cd = null;
        	String[] n1st_ts_pol_cd = null;
        	String[] n1st_ts_pod_cd = null;
        	BkgAlocMgmtDetailVO bkgAlocMgmtDetailVO =null;
			List<BkgAlocMgmtDetailVO> insertDetailVoList = new ArrayList<BkgAlocMgmtDetailVO>();
			List<BkgAlocMgmtDetailVO> updateDeatilVoList = new ArrayList<BkgAlocMgmtDetailVO>();

			for ( int i=0; i<bkgAlocMgmtVO.length; i++ ) {
				if (bkgAlocMgmtVO[i].getTrunkPolCd() != null && !bkgAlocMgmtVO[i].getTrunkPolCd().equals("")){
					trunk_pol_cd = bkgAlocMgmtVO[i].getTrunkPolCd().split(",");
				}
				if (bkgAlocMgmtVO[i].getTrunkPodCd() != null && !bkgAlocMgmtVO[i].getTrunkPodCd().equals("")){
					trunk_pod_cd = bkgAlocMgmtVO[i].getTrunkPodCd().split(",");
				}
				if (bkgAlocMgmtVO[i].getN1stTsPolCd() != null && !bkgAlocMgmtVO[i].getN1stTsPolCd().equals("")){
					n1st_ts_pol_cd = bkgAlocMgmtVO[i].getN1stTsPolCd().split(",");
				}
				if (bkgAlocMgmtVO[i].getN1stTsPodCd() != null && !bkgAlocMgmtVO[i].getN1stTsPodCd().equals("")){
					n1st_ts_pod_cd = bkgAlocMgmtVO[i].getN1stTsPodCd().split(",");
				}
								
				if ( bkgAlocMgmtVO[i].getIbflag().equals("I")){
					bkgAlocMgmtVO[i].setCreUsrId(account.getUsr_id());
					bkgAlocMgmtVO[i].setUpdUsrId(account.getUsr_id());
					
					List<BkgAlocMgmtVO> list = null;
                    list = dbDao.searchBkgAlocDupCheckData(bkgAlocMgmtVO[i]);
                    if(list.size()>0){
	                    String detail = list.get(0).getBkgAlocTpCd();
	                    throw new EventException((String)new ErrorHandler("BKG00488",new String[]{ detail }).getMessage());
                    }

					bkgAlocMgmtSeq = Integer.parseInt(dbDao.searchBkgAlocMgmtSeq());
					bkgAlocMgmtVO[i].setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
					
                    dbDao.addBkgAlocMgmt(bkgAlocMgmtVO[i]);			
                    
                    if(trunk_pol_cd!=null&&trunk_pol_cd.length>0){
						for(int k = 0; k < trunk_pol_cd.length ; k++){
							log.debug("POL-SEQ");
							bkgAlocMgmtDetailVO = new BkgAlocMgmtDetailVO();
							bkgAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							bkgAlocMgmtDetailVO.setLocDivCd("POL");
							bkgAlocMgmtDetailVO.setLocCd(trunk_pol_cd[k]);
							bkgAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							bkgAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(bkgAlocMgmtDetailVO);
						}
                    }
                    if(trunk_pod_cd!=null&&trunk_pod_cd.length>0){
						for(int k = 0; k < trunk_pod_cd.length ; k++){
							log.debug("POD-SEQ");
							bkgAlocMgmtDetailVO = new BkgAlocMgmtDetailVO();
							bkgAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							bkgAlocMgmtDetailVO.setLocDivCd("POD");
							bkgAlocMgmtDetailVO.setLocCd(trunk_pod_cd[k]);
							bkgAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							bkgAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(bkgAlocMgmtDetailVO);
						}
                    }
                    if(n1st_ts_pol_cd!=null&&n1st_ts_pol_cd.length>0){
						for(int k = 0; k < n1st_ts_pol_cd.length ; k++){
							log.debug("POL-SEQ");
							bkgAlocMgmtDetailVO = new BkgAlocMgmtDetailVO();
							bkgAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							bkgAlocMgmtDetailVO.setLocDivCd("POL");
							bkgAlocMgmtDetailVO.setLocCd(n1st_ts_pol_cd[k]);
							bkgAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							bkgAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(bkgAlocMgmtDetailVO);
						}
                    }
                    if(n1st_ts_pod_cd!=null&&n1st_ts_pod_cd.length>0){
						for(int k = 0; k < n1st_ts_pod_cd.length ; k++){
							log.debug("POD-SEQ");
							bkgAlocMgmtDetailVO = new BkgAlocMgmtDetailVO();
							bkgAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							bkgAlocMgmtDetailVO.setLocDivCd("POD");
							bkgAlocMgmtDetailVO.setLocCd(n1st_ts_pod_cd[k]);
							bkgAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							bkgAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(bkgAlocMgmtDetailVO);
						}
                    }
				} else if ( bkgAlocMgmtVO[i].getIbflag().equals("U")){
					List<BkgAlocMgmtVO> list = null;
                    list = dbDao.searchBkgAlocDupCheckData(bkgAlocMgmtVO[i]);
                    if(list.size()>0){
                         String detail = list.get(0).getBkgAlocTpCd();
                         throw new EventException((String)new ErrorHandler("BKG00488",new String[]{ detail }).getMessage());
                    }
					
					bkgAlocMgmtVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.removeBkgAlocDetailMgmt(bkgAlocMgmtVO[i]);
					dbDao.modifyBkgAlocMgmt(bkgAlocMgmtVO[i]);
					
                    if(trunk_pol_cd!=null&&trunk_pol_cd.length>0){
						for(int k = 0; k < trunk_pol_cd.length ; k++){
							log.debug("update:POL-SEQ");
							bkgAlocMgmtDetailVO = new BkgAlocMgmtDetailVO();
							bkgAlocMgmtDetailVO.setBkgAlocSeq(bkgAlocMgmtVO[i].getBkgAlocSeq());
							bkgAlocMgmtDetailVO.setLocDivCd("POL");
							bkgAlocMgmtDetailVO.setLocCd(trunk_pol_cd[k]);
							bkgAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							bkgAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(bkgAlocMgmtDetailVO);
						}
                    }
                    if(trunk_pod_cd!=null&&trunk_pod_cd.length>0){
						for(int k = 0; k < trunk_pod_cd.length ; k++){
							log.debug("update:POD-SEQ");
							bkgAlocMgmtDetailVO = new BkgAlocMgmtDetailVO();
							bkgAlocMgmtDetailVO.setBkgAlocSeq(bkgAlocMgmtVO[i].getBkgAlocSeq());
							bkgAlocMgmtDetailVO.setLocDivCd("POD");
							bkgAlocMgmtDetailVO.setLocCd(trunk_pod_cd[k]);
							bkgAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							bkgAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(bkgAlocMgmtDetailVO);
						}
                    }
                    if(n1st_ts_pol_cd!=null&&n1st_ts_pol_cd.length>0){
						for(int k = 0; k < n1st_ts_pol_cd.length ; k++){
							log.debug("update:POL-SEQ");
							bkgAlocMgmtDetailVO = new BkgAlocMgmtDetailVO();
							bkgAlocMgmtDetailVO.setBkgAlocSeq(bkgAlocMgmtVO[i].getBkgAlocSeq());
							bkgAlocMgmtDetailVO.setLocDivCd("POL");
							bkgAlocMgmtDetailVO.setLocCd(n1st_ts_pol_cd[k]);
							bkgAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							bkgAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(bkgAlocMgmtDetailVO);
						}
                    }
                    if(n1st_ts_pod_cd!=null&&n1st_ts_pod_cd.length>0){
						for(int k = 0; k < n1st_ts_pod_cd.length ; k++){
							log.debug("update:POD-SEQ");
							bkgAlocMgmtDetailVO = new BkgAlocMgmtDetailVO();
							bkgAlocMgmtDetailVO.setBkgAlocSeq(bkgAlocMgmtVO[i].getBkgAlocSeq());
							bkgAlocMgmtDetailVO.setLocDivCd("POD");
							bkgAlocMgmtDetailVO.setLocCd(n1st_ts_pod_cd[k]);
							bkgAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							bkgAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(bkgAlocMgmtDetailVO);
						}
                    }
				}
			}
			
			if ( insertDetailVoList.size() > 0 ) {
				dbDao.addBkgAlocMgmtDetail(insertDetailVoList);
			}
			if ( updateDeatilVoList.size() > 0 ) {
				dbDao.addBkgAlocMgmtDetail(updateDeatilVoList);
			}
        } catch (EventException ex) {
            throw ex;      
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
     * Booking Allocation Master Table 화면에서 단건의 Seq별로 삭제를 처리한다.<br>
     * 
	 * @author 		ChoiMoonHwan
     * @param 		BkgAlocMgmtVO bkgAlocMgmtVO
	 * @exception 	EventException
     */
    public void removeBkgAlocMgmt(BkgAlocMgmtVO bkgAlocMgmtVO) throws EventException {
        try {
        	dbDao.removeBkgAlocDetailMgmt(bkgAlocMgmtVO);
            dbDao.removeBkgAlocMgmt(bkgAlocMgmtVO);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
	 * Booking Allocation Master Table 화면에서 T.Lane과 BD값을 검증 한다.<br>
	 * 
	 * @param String valType
	 * @param String valValue
	 * @return List<BkgAlocMgmtVO>
	 * @exception EventException
	 */	
	public List<BkgAlocMgmtVO> searchBkgAlocValidationData(String valType, String valValue) throws EventException {
		try {
			
			return dbDao.searchBkgAlocValidationData(valType, valValue);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
     * Booking Allocation Master Table 화면에 Commodity Name을 찾아온다.
     * 
     * @author ChoiMoonHwan
     * @param BkgAlocMgmtVO bkgAlocMgmtVO
     * @return List<BkgAlocMgmtVO>
     * @throws EventException
     */
    public List<BkgAlocMgmtVO> searchCmdtNm(BkgAlocMgmtVO bkgAlocMgmtVO) throws EventException{
        try {
            return dbDao.searchCmdtNm(bkgAlocMgmtVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }    
    
	/**
     * Booking Allocation Master Table 화면에 Group Commodity Name을 찾아온다.
     * 
     * @author ChoiMoonHwan
     * @param BkgAlocMgmtVO bkgAlocMgmtVO
     * @return List<BkgAlocMgmtVO>
     * @throws EventException
     */
    public List<BkgAlocMgmtVO> searchGrpCmdtNm(BkgAlocMgmtVO bkgAlocMgmtVO) throws EventException{
        try {
            return dbDao.searchGrpCmdtNm(bkgAlocMgmtVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    } 
    
    /**
     * Draft B/L image 목록을 조회한다.
     * 
     * @author ChaSangyoung
     * @param DraftBlImageVO draftBlImageVO
     * @return List<DraftBlImageVO>
     * @throws EventException
     */
    public List<DraftBlImageVO> searchDraftBlImageList(DraftBlImageVO draftBlImageVO) throws EventException{
        try {
            return dbDao.searchDraftBlImageList(draftBlImageVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    } 
    
	/**
     * 멀티 이벤트 처리<br>
     * draft B/L image 화면에 대한 멀티 이벤트 처리<br>
     * 
     * @param DraftBlImageVO[] draftBlImageVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageDraftBlImage(DraftBlImageVO[] draftBlImageVOs, SignOnUserAccount account) throws EventException {
    	
    	if(draftBlImageVOs == null)
			return;
		try { 
			List<DraftBlImageVO> insertVoList = new ArrayList<DraftBlImageVO>();
			List<DraftBlImageVO> updateVoList = new ArrayList<DraftBlImageVO>();
			List<DraftBlImageVO> deleteVoList = new ArrayList<DraftBlImageVO>();
			
			for ( int i=0; i<draftBlImageVOs.length; i++ ) {
				
				draftBlImageVOs[i].setUpdUsrId(account.getUsr_id());
				
				if ( draftBlImageVOs[i].getIbflag().equals("I")){
					insertVoList.add(draftBlImageVOs[i]);
				} else if ( draftBlImageVOs[i].getIbflag().equals("U")){
					updateVoList.add(draftBlImageVOs[i]);
				} else if ( draftBlImageVOs[i].getIbflag().equals("D")){
					deleteVoList.add(draftBlImageVOs[i]);		
				}
			}
						
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeDraftBlImage(deleteVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addDraftBlImage(insertVoList);
			}
			
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDraftBlImage(updateVoList);
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
     * draft b/l image customer code 존재여부 조회
     * 
     * @author ChaSangyoung
     * @param DraftBlImageVO draftBlImageVO
     * @return String
     * @throws EventException
     */
    public String searchDraftBlImageCustCodeYN(DraftBlImageVO draftBlImageVO) throws EventException{
        try {
            return dbDao.searchDraftBlImageCustCodeYN(draftBlImageVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    } 
    
    /**
     * Web Booking Manual Upload Setup Table 화면 조회 메소드
     * 
     * @param WebBkgManualUploadSetupVO webBkgManualUploadSetupVO
     * @return List<WebBkgManualUploadSetupVO>
     * @throws EventException
     */
    public List<WebBkgManualUploadSetupVO> searchWebBkgManualUploadSetup(WebBkgManualUploadSetupVO webBkgManualUploadSetupVO) throws EventException{
        try {
            return dbDao.searchWebBkgManualUploadSetup(webBkgManualUploadSetupVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * Web Booking Manual Upload Setup Table 화면 관리(저장/수정/삭제) 메소드.<br>
     *
     * @param WebBkgManualUploadSetupVO[] webBkgManualUploadSetupVO
     * @param account
     * @exception EventException
     */
    public void manageWebBkgManualUploadSetup(WebBkgManualUploadSetupVO[] webBkgManualUploadSetupVO, SignOnUserAccount account) throws EventException {
        try {
			for ( int i=0; i<webBkgManualUploadSetupVO.length; i++ ) {
				if ( webBkgManualUploadSetupVO[i].getIbflag().equals("I")){
					webBkgManualUploadSetupVO[i].setCreUsrId(account.getUsr_id());
					webBkgManualUploadSetupVO[i].setUpdUsrId(account.getUsr_id());
                    dbDao.addWebBkgManualUploadSetup(webBkgManualUploadSetupVO[i]);			
				} else if ( webBkgManualUploadSetupVO[i].getIbflag().equals("U")){
					webBkgManualUploadSetupVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyWebBkgManualUploadSetup(webBkgManualUploadSetupVO[i]);
				} else if ( webBkgManualUploadSetupVO[i].getIbflag().equals("D")){
					webBkgManualUploadSetupVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.removeWebBkgManualUploadSetup(webBkgManualUploadSetupVO[i]);
				}
			}
        } catch (EventException ex) {
            throw ex;      
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
     * Web Booking Manual Upload Setup Table 등록 항목이 중복되는지 체크
     * 
     * @param WebBkgManualUploadSetupVO webBkgManualUploadSetupVO
     * @return String
     * @throws EventException
     */
    public String searchWebBkgManualUploadSetupDupChk(WebBkgManualUploadSetupVO[] webBkgManualUploadSetupVO) throws EventException{
    	String chkFlg = "0";
        try {
        	for ( int i=0; i<webBkgManualUploadSetupVO.length; i++ ) {
        		if ( webBkgManualUploadSetupVO[i].getIbflag().equals("I") || webBkgManualUploadSetupVO[i].getIbflag().equals("U")){
        			chkFlg = dbDao.searchWebBkgManualUploadSetupDupChk(webBkgManualUploadSetupVO[i]);
        			
        			if(!"0".equals(chkFlg)){
        				return chkFlg;
        			}
        			
        		}
        	}
        	
        	return chkFlg;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
	/**
	 * Web Booking Manual Upload Setup Table 등록 시 VVD와 Country 체크.<br>
	 * 
	 * @param String vslCd 
	 * @param String voyNo 
	 * @param String dirCd 
	 * @param String cntCd 
	 * @return String
	 * @throws EventException
	 */
	public String searchWebBkgManualUploadSetupvalidateVvdCnt (String vslCd, String voyNo, String dirCd, String cntCd) throws EventException {
		try {
			return dbDao.searchWebBkgManualUploadSetupvalidateVvdCnt(vslCd,voyNo,dirCd,cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
    
    /**
     * 유저id 별로 조회조건정보를 조회한다.
     * @param String usrId
     * @return List<BkgSrchSetVO>
     * @throws EventException
     */
    public List<BkgSrchSetVO> searchUserSearchSet(String usrId) throws EventException{
        try {
            return dbDao.searchUserSearchSet(usrId);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    
    /**
     * 유저id 별로 조회조건정보를 저장한다.
     * @param BkgSrchSetVO[] bkgSrchSetVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void manageUserSearchSet(BkgSrchSetVO[] bkgSrchSetVOs,SignOnUserAccount account) throws EventException{
    	
    	if(bkgSrchSetVOs == null)
			return;
		try { 
			List<BkgSrchSetVO> insertVoList = new ArrayList<BkgSrchSetVO>();
			List<BkgSrchSetVO> updateVoList = new ArrayList<BkgSrchSetVO>();
			List<BkgSrchSetVO> deleteVoList = new ArrayList<BkgSrchSetVO>();
			
			for ( int i=0; i<bkgSrchSetVOs.length; i++ ) {
				
				bkgSrchSetVOs[i].setUpdUsrId(account.getUsr_id());
				
				if ( bkgSrchSetVOs[i].getIbflag().equals("I")){
					insertVoList.add(bkgSrchSetVOs[i]);
				} else if ( bkgSrchSetVOs[i].getIbflag().equals("U")){
					updateVoList.add(bkgSrchSetVOs[i]);
				} else if ( bkgSrchSetVOs[i].getIbflag().equals("D")){
					deleteVoList.add(bkgSrchSetVOs[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeUserSearchSet(deleteVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addUserSearchSet(insertVoList);
			}
			
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyUserSearchSet(updateVoList);
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
     *Customer Check Point 조회
     * @param BkgCustChkPntVO bkgCustChkPntVO
     * @return  List<BkgCustChkPntVO>
     * @throws EventException
     */    
    public List<BkgCustChkPntVO> searchCustChkPnt(BkgCustChkPntVO bkgCustChkPntVO) throws EventException {
    	 try {
             return dbDao.searchCustChkPnt(bkgCustChkPntVO);
         } catch(DAOException ex) {
             throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
         } catch (Exception ex) {
             throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
         }
    }
    
    /**
     * Customer Check Point 관리<br>
     *
     * @param BkgCustChkPntVO[] bkgCustChkPntVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageBkgCustChkPnt(BkgCustChkPntVO[] bkgCustChkPntVOs, SignOnUserAccount account) throws EventException {
        try {
        	if(bkgCustChkPntVOs!=null){
				for ( int i=0; i<bkgCustChkPntVOs.length; i++ ) {
					
					if ( bkgCustChkPntVOs[i].getIbflag().equals("I")){	
						
						bkgCustChkPntVOs[i].setCreUsrId(account.getUsr_id());
						bkgCustChkPntVOs[i].setUpdUsrId(account.getUsr_id());
						
	                    dbDao.addBkgCustChkPnt(bkgCustChkPntVOs[i]);	     
	                    
					} else if ( bkgCustChkPntVOs[i].getIbflag().equals("U")){
						
						bkgCustChkPntVOs[i].setUpdUsrId(account.getUsr_id());
						dbDao.modifyBkgCustChkPnt(bkgCustChkPntVOs[i]);
						
					} else if ( bkgCustChkPntVOs[i].getIbflag().equals("D")){
						
						bkgCustChkPntVOs[i].setUpdUsrId(account.getUsr_id());
						bkgCustChkPntVOs[i].setDeltFlg("Y");
						
						dbDao.modifyBkgCustChkPnt(bkgCustChkPntVOs[i]);
						
					}
				}
        	}
        } catch (EventException ex) {
            throw ex;      
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
     * Check Point Item 조회
     * @param BkgChkPntItemVO bkgChkPntItemVO
     * @return  List<BkgChkPntItemVO>
     * @throws EventException
     */    
    public List<BkgChkPntItemVO> searchChkPntItem(BkgChkPntItemVO bkgChkPntItemVO) throws EventException {
    	 try {
             return dbDao.searchChkPntItem(bkgChkPntItemVO);
         } catch(DAOException ex) {
             throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
         } catch (Exception ex) {
             throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
         }
    }
    
    /**
     * Check Point Item 관리<br>
     *
     * @param BkgChkPntItemVO[] bkgChkPntItemVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageBkgChkPntItem(BkgChkPntItemVO[] bkgChkPntItemVOs, SignOnUserAccount account) throws EventException {
        try {
        	if(bkgChkPntItemVOs != null){
				for ( int i=0; i<bkgChkPntItemVOs.length; i++ ) {	
					
					if ( bkgChkPntItemVOs[i].getIbflag().equals("I")){	
						
						bkgChkPntItemVOs[i].setCreUsrId(account.getUsr_id());
						bkgChkPntItemVOs[i].setUpdUsrId(account.getUsr_id());
						
	                    dbDao.addBkgChkPntItem(bkgChkPntItemVOs[i]);	    
	                    
					} else if ( bkgChkPntItemVOs[i].getIbflag().equals("U")){
						
						bkgChkPntItemVOs[i].setUpdUsrId(account.getUsr_id());
						
						dbDao.modifyBkgChkPntItem(bkgChkPntItemVOs[i]);
						
					} else if ( bkgChkPntItemVOs[i].getIbflag().equals("D")){
						
						bkgChkPntItemVOs[i].setUpdUsrId(account.getUsr_id());
						bkgChkPntItemVOs[i].setDeltFlg("Y");
						
						dbDao.modifyBkgChkPntItem(bkgChkPntItemVOs[i]);
						
					}
				}
        	}
        } catch (EventException ex) {
            throw ex;      
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
     *Check Point Item Type조회
     * @param BkgChkPntItemTpVO bkgChkPntItemTpVO
     * @return  List<BkgChkPntItemTpVO>
     * @throws EventException
     */    
    public List<BkgChkPntItemTpVO> searchChkPntItemTp(BkgChkPntItemTpVO bkgChkPntItemTpVO) throws EventException {
    	 try {
             return dbDao.searchChkPntItemTp(bkgChkPntItemTpVO);
         } catch(DAOException ex) {
             throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
         } catch (Exception ex) {
             throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
         }
    }
    
    /**
     * Check Point Item Type 관리<br>
     *
     * @param BkgChkPntItemTpVO[] bkgChkPntItemTpVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageBkgChkPntItemTp(BkgChkPntItemTpVO[] bkgChkPntItemTpVOs, SignOnUserAccount account) throws EventException {
        try {
        	if(bkgChkPntItemTpVOs != null){
				for ( int i=0; i<bkgChkPntItemTpVOs.length; i++ ) {	
					
					if ( bkgChkPntItemTpVOs[i].getIbflag().equals("I")){	
						
						bkgChkPntItemTpVOs[i].setCreUsrId(account.getUsr_id());
						bkgChkPntItemTpVOs[i].setUpdUsrId(account.getUsr_id());
						
	                    dbDao.addBkgChkPntItemTp(bkgChkPntItemTpVOs[i]);	    
	                    
					} else if ( bkgChkPntItemTpVOs[i].getIbflag().equals("U")){
						
						bkgChkPntItemTpVOs[i].setUpdUsrId(account.getUsr_id());
						
						dbDao.modifyBkgChkPntItemTp(bkgChkPntItemTpVOs[i]);
						
					} else if ( bkgChkPntItemTpVOs[i].getIbflag().equals("D")){
						
						bkgChkPntItemTpVOs[i].setUpdUsrId(account.getUsr_id());
						bkgChkPntItemTpVOs[i].setDeltFlg("Y");
						
						dbDao.modifyBkgChkPntItemTp(bkgChkPntItemTpVOs[i]);
						
					}
				}
        	}
        } catch (EventException ex) {
            throw ex;      
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    

	/**
	 *  Attachment File 목록 조회<br>
	 * 
	 * @param CustChkPntAttachVO vo
	 * @return List<CustChkPntAttachVO>
	 * @exception EventException
	 */
	public List<CustChkPntAttachVO> searchCustChkPntAttach(CustChkPntAttachVO vo) throws EventException {
		try {			
			return dbDao.searchCustChkPntAttach(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		}
	}

	/**
	 * ESM_BKG_0239 멀티 이벤트 처리<br>
	 * @param CustChkPntAttachVO[] vos
	 * @param String[] fileSavId
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustChkPntAttach(CustChkPntAttachVO[] vos, String[] fileSavId, SignOnUserAccount account) throws EventException {
		
		try {
			List<CustChkPntAttachVO> insertVoList = new ArrayList<CustChkPntAttachVO>();
			List<CustChkPntAttachVO> deleteVoList = new ArrayList<CustChkPntAttachVO>();
			int saveIdCnt = 0;
			String atchFileLnkId = "";
			
			if(vos.length > 0){
				atchFileLnkId = dbDao.searchCustChkPntAttachFileLinkId(vos[0]);
			}				
					
					
			for (int i = 0; i < vos.length; i++) {
				if (vos[i].getIbflag().equals("U")) {
					deleteVoList.add(vos[i]);
					vos[i].setIbflag("I");
				}

				if (vos[i].getIbflag().equals("D")) {
					deleteVoList.add(vos[i]);
					UpdateFileMetaInfo.delete(vos[i].getFileSavId());

				} else if (vos[i].getIbflag().equals("I")) {

					if (vos[i].getFileSavId() == null || vos[i].getFileSavId().length() == 0) {
						vos[i].setFileSavId(fileSavId[saveIdCnt]);
						saveIdCnt  = saveIdCnt + 1;
					}

					vos[i].setAtchFileLnkId(atchFileLnkId);
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(vos[i]);
				}
			}
			if (deleteVoList.size() > 0) {

				dbDao.removeCustChkPntAttach(deleteVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addCustChkPntAttach(insertVoList);				
			}
			
			dbDao.modifyCustChkPntAttachFileLinkId(vos[0]);	 

		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
		log.debug("[END::]==========");
	}
	
	/**
	 * Block Keyword List 조회<br>
	 * 
	 * @param  String blckKwTpCd
	 * @return List<BlckKwListVO>
	 * @exception EventException
	 */
	public List<BlckKwListVO> searchBkgBlckKwList(String blckKwTpCd) throws EventException {
		try {			
			return dbDao.searchBkgBlckKwList(blckKwTpCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		}
	}
	
	/**
	 * Bkg Block keyword list  SAVE 처리.<br>
	 * 
	 * @param BlckKwListVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBkgBlckKwList(BlckKwListVO[] vos,SignOnUserAccount account) throws EventException{
		
		try {
			if (vos != null && vos.length >0){
				for ( int i=0; i<vos.length; i++ ) {
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					
					if ( vos[i].getIbflag().equals("I")){
						dbDao.addBkgBlckKwList(vos[i]);
					}
					if ( vos[i].getIbflag().equals("U")){
						dbDao.modifyBkgBlckKwList(vos[i]);
					}
					if ( vos[i].getIbflag().equals("D")){
						dbDao.removeBkgBlckKwList(vos[i]);
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
	
	
    
} 