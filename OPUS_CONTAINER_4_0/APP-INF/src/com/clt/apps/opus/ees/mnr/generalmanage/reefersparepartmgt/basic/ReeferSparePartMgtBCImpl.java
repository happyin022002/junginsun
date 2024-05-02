/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ReeferSparePartMgtBCImpl.java
 *@FileTitle : ReeferSparePartMgtBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.integration.ReeferSparePartMgtDBDAO;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo.MnrReeferSparePartCodeVO;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartCodeMgtGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartInventoryListVO;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartInventoryMgtGRPVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
        
/**
 * COM-GeneralManage Business Logic Basic Command implementation<br>
 * - COM-GeneralManage - disposing business logic<br>
 *
 * @author
 * @see Ees_mnr_0009EventResponse, CEDEXCodeMgtBC, ReeferSparePartMgtDBDAO
 * @since J2EE 1.4   
 */         
    
public  class ReeferSparePartMgtBCImpl extends BasicCommandSupport implements ReeferSparePartMgtBC {

	// Database Access Object
	private transient ReeferSparePartMgtDBDAO dbDao = null; 

	/** 
	 * GeneralCodeMgtBCImpl - Creating object<br>
	 * GeneralCodeMgtDBDAO - Creating object<br>
	 */    
	public ReeferSparePartMgtBCImpl() {  
		dbDao = new ReeferSparePartMgtDBDAO();
	}

	/**
	 * [EES_MNR_0214]Retrieving "Vessel Reefer Spare Part Purchase W/O Creation" data<br>
	 *
	 * @param RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO
	 * @return RFSparePartCodeMgtGRPVO
	 * @exception EventException
	 */
	public RFSparePartCodeMgtGRPVO searchRFsparePartCodeListBasic(RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO) throws EventException {
		try { 

			
			List<MnrReeferSparePartCodeVO> mnrReeferSparePartCodeVOS = null; 
			
			mnrReeferSparePartCodeVOS = dbDao.searchRFsparePartCodeListData(rfSparePartCodeMgtGRPVO.getRFSparePartCodeMgtINVO());
				
			rfSparePartCodeMgtGRPVO.setMnrReeferSparePartCodeVOs(mnrReeferSparePartCodeVOS);   
		
			
			return rfSparePartCodeMgtGRPVO;
			
		} catch (DAOException ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0214] searchRFsparePartCodeListBasic"}).getMessage(),ex);
		} catch (Exception ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0214] searchRFsparePartCodeListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0137]Adding, modifying, deleting "Standard Reefer Spare Parts List of the vsl" data<br>
	 *
	 * @param RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRFsparePartCodeBasic(RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO, SignOnUserAccount account) throws EventException{
		try {
			
			MnrReeferSparePartCodeVO[] mnrReeferSparePartCodeVOS = rfSparePartCodeMgtGRPVO.getArrayMnrReeferSparePartCodeVOs(); 
		
			if(mnrReeferSparePartCodeVOS != null){
				List<MnrReeferSparePartCodeVO> insertVoList = new ArrayList<MnrReeferSparePartCodeVO>();
				List<MnrReeferSparePartCodeVO> updateVoList = new ArrayList<MnrReeferSparePartCodeVO>();
				List<MnrReeferSparePartCodeVO> deleteVoList = new ArrayList<MnrReeferSparePartCodeVO>(); 
					
				for ( int i=0; i<mnrReeferSparePartCodeVOS.length; i++ ) {
			
					if ( mnrReeferSparePartCodeVOS[i].getIbflag().equals("I")){
						mnrReeferSparePartCodeVOS[i].setCreUsrId(account.getUsr_id());
						mnrReeferSparePartCodeVOS[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(mnrReeferSparePartCodeVOS[i]);
					} else if ( mnrReeferSparePartCodeVOS[i].getIbflag().equals("U")){
						mnrReeferSparePartCodeVOS[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(mnrReeferSparePartCodeVOS[i]);
					} else if ( mnrReeferSparePartCodeVOS[i].getIbflag().equals("D")){
						deleteVoList.add(mnrReeferSparePartCodeVOS[i]);
					} 
				}  
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addRFsparePartCodeData(insertVoList);
				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyRFsparePartCodeData(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeRFsparePartCodeData(deleteVoList);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0137] manageRFsparePartCodeBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0137] manageRFsparePartCodeBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0056]Retrieving "VSL Reefer Spare part Inventory" data<br>
	 *
	 * @param RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO
	 * @return RFSparePartInventoryMgtGRPVO
	 * @exception EventException
	 */
	public RFSparePartInventoryMgtGRPVO searchRFSparePartInventoryListBasic(RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO) throws EventException {
		try { 
			List<RFSparePartInventoryListVO> rfSparePartInventoryListVOS = null; 
			rfSparePartInventoryListVOS = dbDao.searchRFSparePartInventoryListData(rfSparePartInventoryMgtGRPVO.getRFSparePartInventoryMgtINVO());

			rfSparePartInventoryMgtGRPVO.setRFSparePartInventoryListVOs(rfSparePartInventoryListVOS);   

			return rfSparePartInventoryMgtGRPVO;
		} catch (DAOException ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0056] searchRFSparePartInventoryListBasic"}).getMessage(),ex);
		} catch (Exception ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0056] searchRFSparePartInventoryListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0056]Adding, modifying, deleting "VSL Reefer Spare part Inventory" data<br>
	 *
	 * @param RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRFSparePartInventoryBasic(RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO, SignOnUserAccount account) throws EventException{
		try {
			
			RFSparePartInventoryListVO[] rfSparePartInventoryListVOS = rfSparePartInventoryMgtGRPVO.getArrayRFSparePartInventoryListVOs(); 
		
			if(rfSparePartInventoryListVOS != null){
				List<RFSparePartInventoryListVO> checkVoList = new ArrayList<RFSparePartInventoryListVO>();				
				List<RFSparePartInventoryListVO> insertVoList = new ArrayList<RFSparePartInventoryListVO>();
				List<RFSparePartInventoryListVO> updateVoList = new ArrayList<RFSparePartInventoryListVO>();
				List<RFSparePartInventoryListVO> deleteVoList = new ArrayList<RFSparePartInventoryListVO>(); 
	
				for ( int i=0; i<rfSparePartInventoryListVOS.length; i++ ) {
			
					if ( rfSparePartInventoryListVOS[i].getIbflag().equals("I")){
						rfSparePartInventoryListVOS[i].setCreUsrId(account.getUsr_id());
						rfSparePartInventoryListVOS[i].setUpdUsrId(account.getUsr_id());
						checkVoList.add(rfSparePartInventoryListVOS[i]);
						List<RFSparePartInventoryListVO> checkVos = dbDao.checkRFSparePartInventoryData(checkVoList);
						if(checkVos.size()<=0)
						{
							insertVoList.add(rfSparePartInventoryListVOS[i]);
						}

					} else if ( rfSparePartInventoryListVOS[i].getIbflag().equals("U")){
						rfSparePartInventoryListVOS[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(rfSparePartInventoryListVOS[i]);
					} else if ( rfSparePartInventoryListVOS[i].getIbflag().equals("D")){
						deleteVoList.add(rfSparePartInventoryListVOS[i]);
					} 
				}  
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addRFSparePartInventoryData(insertVoList);
				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyRFSparePartInventoryData(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeRFSparePartInventoryData(deleteVoList);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0056] manageRFSparePartInventoryBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0056] manageRFSparePartInventoryBasic"}).getMessage(),ex);
		}
	}
}