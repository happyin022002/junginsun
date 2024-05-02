/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : MasterDataMgtBCImpl.java
*@FileTitle : MDM DATA Management
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.06.28
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.integration.MasterDataMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.MdmStateVO;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.SearchBkgIdaSacMstVO;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.SearchMdmChargeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgIdaSacMstVO;
import com.hanjin.syscommon.common.table.MdmChargeVO;

/**
 * ALPS-MdmDataMgtSC Business Logic Basic Command implementation<br>
 * - ALPS-MdmDataMgtSC 에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SONG Min Seok
 * @since J2EE 1.6
 */

public class MasterDataMgtBCImpl extends BasicCommandSupport implements MasterDataMgtBC{
 
	// Database Access Object
	private transient MasterDataMgtDBDAO dbDao = null;

	/**
	 * MasterDataMgtBCImpl 객체 생성<br>
	 * MasterDataMgtDBDAO 생성한다.<br>
	 */
	public MasterDataMgtBCImpl() {
		dbDao = new MasterDataMgtDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
     * MDM_CHARGE LIST 데이타 모델에 해당되는 값을 불러온다.<br>
     * @author SONG Min Seok
	 * @param SearchMdmChargeVO paramVO
	 * @return List<SearchMdmChargeVO> 
	 * @exception EventException
	 */
	public List<SearchMdmChargeVO> searchMdmChargeList(SearchMdmChargeVO paramVO) throws EventException {
		try {
			
			return dbDao.searchMdmChargeList (paramVO);
		
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage());
		}
	}
	  
 
	/**
     * MDM_CHARGE의 정보중 mdm에서 interface 되지 않는 일부 정보를 update한다<br>	
     * 
	 * @param MdmChargeVO[] mdmChargeVOs
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageMdmChargeList(MdmChargeVO[] mdmChargeVOs,SignOnUserAccount account) throws EventException{
    	
    	if(mdmChargeVOs == null)
			return;
    	
		try {
			/*
			 * INPUT 필드의 값을 트랜잭션시 시용한다.
			 * */
			String officeCD ="";
			String handlingOfficeCD="";
			
			List<MdmChargeVO> updateVoList = new ArrayList<MdmChargeVO>();
			
			for ( int i=0; i<mdmChargeVOs.length; i++ ) {
				
			    mdmChargeVOs[i].setUpdUsrId(account.getUsr_id());
   
				if ( mdmChargeVOs[i].getIbflag().equals("U")){
					updateVoList.add(mdmChargeVOs[i]);
				}  
			}
			
		 
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMdmChargeList(updateVoList);
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
     * 조회 이벤트 처리<br>
     * India SAC Master Data LIST 데이타 모델에 해당되는 값을 불러온다.<br>
     * @author SONG Min Seok
     * @param SearchBkgIdaSacMstVO paramVO
     * @return List<SearchBkgIdaSacMstVO> 
     * @exception EventException
     */ 
    public List<SearchBkgIdaSacMstVO> searchIndiaSacMasterList (SearchBkgIdaSacMstVO paramVO) throws EventException {
        try {
            
            return dbDao.searchIndiaSacMasterList (paramVO);
        
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage());
        }
    }
    
    

    /**
     * India SAC Master 정보를 update한다<br>    
     * 
     * @param BkgIdaSacMstVO[] bkgIdaSacMstVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageBkgIdaSacMstList(BkgIdaSacMstVO[] bkgIdaSacMstVOs,SignOnUserAccount account) throws EventException{
        
        if(bkgIdaSacMstVOs == null)
            return;
        
        try {
 
            
            List<BkgIdaSacMstVO> updateVoList = new ArrayList<BkgIdaSacMstVO>();
            
            for ( int i=0; i<bkgIdaSacMstVOs.length; i++ ) {
                
                bkgIdaSacMstVOs[i].setUpdUsrId(account.getUsr_id());
   
                if ( bkgIdaSacMstVOs[i].getIbflag().equals("U")){
                    updateVoList.add(bkgIdaSacMstVOs[i]);
                }  
            }
            
         
            
            if ( updateVoList.size() > 0 ) {
                dbDao.manageBkgIdaSacMstList(updateVoList);
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
	 * ESM_BKG_S002 MDM State 에 대한 조회 이벤트 처리<br>
	 * @param MdmStateVo MdmStateVo
	 * @return MdmStateVo
	 * @exception EventException
	 */
	public List<MdmStateVO> searchMdmStateList(MdmStateVO paramVO) throws EventException {
		List<MdmStateVO> list = null;
		
		try {		
			list =dbDao.searchMdmStateList(paramVO);
			return list;
			
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

	}
	
	
	/**
     * MDM_State의 일부 정보를 update한다<br>	
     * 
	 * @param MdmChargeVO[] mdmChargeVOs
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageMdmState(MdmStateVO[] mdmStateVOs,SignOnUserAccount account) throws EventException{
    	
    	if(mdmStateVOs == null)
    		return;

		try {
			/*
			 * INPUT 필드의 값을 트랜잭션시 시용한다.
			 * */
			List<MdmStateVO> updateVoList = new ArrayList<MdmStateVO>();
			
			for ( int i=0; i<mdmStateVOs.length; i++ ) {
				
				mdmStateVOs[i].setUpdUsrId(account.getUsr_id());
				if ( mdmStateVOs[i].getIbflag().equals("U")){
					updateVoList.add(mdmStateVOs[i]);
				}  
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMdmState(updateVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}	
    }
     
	
}