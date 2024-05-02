/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BangladeshManifestListDownloadBCImpl.java
*@FileTitle : Bangladesh Cargo Manifest
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 전창현
*@LastVersion : 1.0
* 2009.10.06 전창현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.basic;

import java.util.ArrayList;
import java.util.List;


//import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.integration.AusDgManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusBkgAndLocalDgListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusDgListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusDgListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgCargoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgCntrInfoListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgInqModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.FeederNameVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
  
/**
 * ALPS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Subin
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class AusDgManifestListDownloadBCImpl  extends ManifestListDownloadBCImpl {
	
	// Database Access Object
	private transient AusDgManifestListDownloadDBDAO dbDao = null;
	
	/**
	 * AusDGManifestListDownloadBCImpl 객체 생성<br>
	 * AusDGManifestListDownloadDBDAO 생성한다.<br>
	 */
	public AusDgManifestListDownloadBCImpl() {
		dbDao = new AusDgManifestListDownloadDBDAO();
	}	
	
	/**
     * 호주 위험물 정보 조회시, 위험물테이블과 booking쪽 테이블에서 동시에 조회한다.<Br>
     * 
	 * @param AusBkgAndLocalDgListDetailVO ausBkgAndLocalDgListDetailVO
     * @return List<AusBkgAndLocalDgListDetailVO>
     * @throws EventException
     */
	
	 public List<AusBkgAndLocalDgListDetailVO> searchAusDgInfoAtBkgAndLocal(AusDgListCondVO ausDgListCondVO) throws EventException { 
			try {
				return dbDao.searchAusDgInfoAtBkgAndLocal(ausDgListCondVO);
			} catch (DAOException ex) {
	            log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
			} catch (Exception ex) {
	            log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
			}
	    }	

	/**
     * 수출,수입, T/S, Barge별로 전송 대상을 조회한다.<Br>
     * 
	 * @param AusDgListCondVO ausDgListCondVO
     * @return List<DgListDetailVO>
     * @throws EventException
     */
	public List<AusDgListDetailVO> searchAusDgInfo(AusDgListCondVO ausDgListCondVO) throws EventException {
		List<AusDgListDetailVO> list   = null;  
        
        try {
        	
        	// dg쪽 저장된놈 조회
            list = dbDao.searchAusDgInfoAtLocal(ausDgListCondVO);
            
            if(list == null || list.size() == 0){
            	list = dbDao.searchAusDgInfoAtBkgDg(ausDgListCondVO);
            }
        } catch (DAOException ex) {
        log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
        }
        
        return list;

	}
	
	
	
	/**
	 * Lloyd, vessel name등 Vessel 정보를 조회해옴-local,<br>
	 * 도착일시/출발일시 정보를 Local 운항스케쥴에서 조회함 <br>
	 * @param AusDgListCondVO ausDgListCondVO
	 * @return List<AusVslInfoVO> list
	 * @throws DAOException
	 */
	
	public List<AusVslInfoVO> searchAusVslInfo(AusDgListCondVO ausDgListCondVO) throws EventException {
		List<AusVslInfoVO> list   = null;  

        
        try {         
              list = dbDao.searchAusVslInfo(ausDgListCondVO);
              
              if(list == null || list.size() == 0 ) {
            	  list = dbDao.serachVslAtCommon(ausDgListCondVO);
            	  

              }
    
        } catch (DAOException ex) {
        log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
        }
        
        return list;

	}
	
	
	
	/**
	 * 위험물 정보들을 관리한다.<br>
	 * 
	 * @param  AusVslInfoVO ausVslInfoVO
	 * @param  AusDgListDetailVO[] ausDgListDetailVOs
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
    public void manageDgManifestList(AusVslInfoVO ausVslInfoVO, AusDgListDetailVO[] ausDgListDetailVOs, SignOnUserAccount account) throws EventException {
		try {
			AusVslInfoVO insertVslInfo = null;
			AusVslInfoVO updateVslInfo = null;

			List<AusDgListDetailVO> insertDgList = new ArrayList<AusDgListDetailVO>();
			List<AusDgListDetailVO> updateDgList = new ArrayList<AusDgListDetailVO>();
			List<AusDgListDetailVO> deleteDgList = new ArrayList<AusDgListDetailVO>();
			
			AusDgListDetailVO ausDgListDetailVO = null;

			
	
			String localDbYn = null;
//			if(ausVslInfoVO != null){
			if(!"".equals(ausVslInfoVO.getVslInfoLocalYn())){
				localDbYn = ausVslInfoVO.getVslInfoLocalYn();
			
				if("Y".equals(localDbYn)) { // update
					updateVslInfo = ausVslInfoVO;
				} else {	// insert
					insertVslInfo = ausVslInfoVO;
				}
				
				if(insertVslInfo != null) {
					dbDao.addAusVslInfo(insertVslInfo, account);
				}
				if(updateVslInfo != null) {
					dbDao.modifyAusVslInfo(updateVslInfo ,account);
				}
				
			}

//				Dg List 정보 저장 VO 구성
	
			String dgListLocalYn = null;
			if(ausDgListDetailVOs != null){
				for (int i = 0; i < ausDgListDetailVOs.length; i++) {
					ausDgListDetailVO= ausDgListDetailVOs[i];
					dgListLocalYn = ausDgListDetailVO.getDgListLocalYn();
						
					ausDgListDetailVO.setUpdUsrId(account.getUsr_id());
					ausDgListDetailVO.setCreUsrId(account.getUsr_id());
					
					if("Y".equals(dgListLocalYn)) { 
						
						if (ausDgListDetailVO.getIbflag().equals("I")){
							insertDgList.add(ausDgListDetailVO);
						} else if (ausDgListDetailVO.getIbflag().equals("U")){
							updateDgList.add(ausDgListDetailVO);
						} else if ( ausDgListDetailVO.getIbflag().equals("D")){
							deleteDgList.add(ausDgListDetailVO);
						}
					} else {	// insert
						insertDgList.add(ausDgListDetailVO);
					}

				}
					
			}
			if(insertDgList != null && insertDgList.size() > 0) {
				dbDao.addDgList(insertDgList);
			}
			if(updateDgList != null && updateDgList.size() > 0) {
				dbDao.modifyDgList(updateDgList);
			}
			if(deleteDgList != null && deleteDgList.size() > 0) {
				dbDao.removeDgList(deleteDgList);
			}
			
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	
    }
    
    
    /**
     * 호주 1512팝업 Danger cargo 정보를 컨테이너 단위로 조회한다.<br>
     * 
     * @param dgCargoCondVO
     * @return DgInqModiVO
     * @throws EventException
     */
    public List<DgInqModiVO> searchDgCargoInfo(DgCargoCondVO dgCargoCondVO) throws EventException { 
		try {
			return dbDao.searchDgInfoinquiry(dgCargoCondVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
    }	
    
    
    /**
	 * 호주 1512팝업 위험물 상세 정보들을 수정+저장한다.<br>
	 * 
	 * @param  DgInqModiVO dgInqModiVO
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
    public void modifyDgInquiry(DgInqModiVO dgInqModiVO, SignOnUserAccount account) throws EventException {
    	
		try {

			if(dgInqModiVO != null) {
				dgInqModiVO.setCreUsrId(account.getUsr_id());
				dgInqModiVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.modifyDgInqBySeq(dgInqModiVO);
			}

		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	
    }
    
    
    /**
     * 호주 1512팝업 DG: 	Forward Code로 Forward Name을 조회한다.<br>
     * 
     * @param dgListCondVO
     * @return
     * @throws EventException
     */
    public String searchForwarderName(DgListCondVO dgListCondVO) throws EventException { 
		try {
			return dbDao.searchForwarderNameByCd(dgListCondVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
    }	
    
    
    /**
     * 호주 1512팝업 DG: UN NO로 NAME을 조회한다.<br>
     * 
     * @param dgListCondVO
     * @return
     * @throws EventException
     */
    public String searchUnnoName(DgListCondVO dgListCondVO) throws EventException { 
		try {
			return dbDao.searchUnnoNameByCd(dgListCondVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
    }
    
    /**
	 *호주 1512팝업 DG: Feeder Name, Lloyd No를 조회한다.<br>
     * 
	 * @return List<FeederNameVO>
     * @throws EventException
     */
    public List<FeederNameVO> searchDgFeederNameList() throws EventException { 
		try {
			return dbDao.searchDgFeederNameList();
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
    }
    
    /**
     * 호주 1512팝업 DG: 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
     * 
     * @param dgCargoCondVO
     * @return List<DgCntrInfoListVO>
     * @throws EventException
     */
    public List<DgCntrInfoListVO> searchCntrInfoListByBl(DgCargoCondVO dgCargoCondVO) throws EventException { 
		try {
			return dbDao.searchCntrInfoListByBl(dgCargoCondVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
    }
    
    /**
     * 호주 1512팝업 DG: 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
     * 
     * @param dgCargoCondVO
     * @return List<DgCntrInfoListVO>
     * @throws EventException
     */
    public List<DgCntrInfoListVO> searchCgoSeqListByCntr(DgCargoCondVO dgCargoCondVO) throws EventException { 
		try {
			return dbDao.searchCgoSeqListByCntr(dgCargoCondVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
    }
    
    
    
  
}




