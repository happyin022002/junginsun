/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CustomsMasterMgtBCImpl.java
 *@FileTitle : Location of goods Setup
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration.CustomsMasterMgtDBDAO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgcustomscanadagrouplocationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -BookingMasterDataSC Business Logic Basic Command implementation<br>
 * - BookingMasterDataSC handling business transaction.<br>
 *
 * @author
 * @see esm_bkg_0354EventResponse
 * @since J2EE 1.6
 */

public class CustomsMasterMgtBCImpl extends BasicCommandSupport implements CustomsMasterMgtBC {

	// Database Access Object
	private transient CustomsMasterMgtDBDAO dbDao = null;

	/**
	 * CustomsMasterMgtBCImpl object creation.<br>
	 * CustomsMasterMgtDBDAO object creation.<br>
	 */
	public CustomsMasterMgtBCImpl() {
		dbDao = new CustomsMasterMgtDBDAO();
	}
	
	/**
	 *  0354: Canada ACI: Location of Goods retrieve.<br> 
	 *
	 * @author
	 * @param BkgcustomscanadagrouplocationVO bkgcustomscanadagrouplocationVO
	 * @return List<BkgcustomscanadagrouplocationVO>
	 * @throws EventException
	 */
	public List<BkgcustomscanadagrouplocationVO> searchCanadaGroupLocationCD(BkgcustomscanadagrouplocationVO bkgcustomscanadagrouplocationVO) throws EventException {
		 
		 try {
			 return dbDao.searchCanadaGroupLocationCD(bkgcustomscanadagrouplocationVO);
		 } catch (DAOException ex) {
			 throw new EventException((String)new ErrorHandler("BKG00450").getUserMessage());
		 }
	 }
	 /**
	  * 0354 Canada ACI: Location of Goods Setup.<br>
	  *  - retrieve basic data for create(modify) Loc Code.<br>
	  * 
	  * @author
	  * @param BkgcustomscanadagrouplocationVO bkgcustomscanadagrouplocationVO
	  * @return List<BkgcustomscanadagrouplocationVO>
	  * @throws EventException
	  */
	 public List<BkgcustomscanadagrouplocationVO> searchCanadaGroupLocationCD2(BkgcustomscanadagrouplocationVO bkgcustomscanadagrouplocationVO) throws EventException {
		
		try {
			return dbDao.searchCanadaGroupLocationCD2(bkgcustomscanadagrouplocationVO);
		} catch (DAOException ex) {
			throw new EventException((String)new ErrorHandler("BKG00450").getUserMessage());
		}
	}
		 
	 
	/**
     * 0354: Canada ACI: Location of Goods.<br>
     *  - handling business transaction<br>
     * 
     * @author
	 * @param BkgcustomscanadagrouplocationVO[] bkgcustomscanadagrouplocationVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageCanadaGroupLocationCD(BkgcustomscanadagrouplocationVO[] bkgcustomscanadagrouplocationVO,SignOnUserAccount account) throws EventException{
    	
    	if(bkgcustomscanadagrouplocationVO == null)
			return;
		try { 
			List<BkgcustomscanadagrouplocationVO> insertVoList = new ArrayList<BkgcustomscanadagrouplocationVO>();
			List<BkgcustomscanadagrouplocationVO> updateVoList = new ArrayList<BkgcustomscanadagrouplocationVO>();
			List<BkgcustomscanadagrouplocationVO> deleteVoList = new ArrayList<BkgcustomscanadagrouplocationVO>();
			
			for ( int i=0; i<bkgcustomscanadagrouplocationVO.length; i++ ) {
				
				bkgcustomscanadagrouplocationVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( bkgcustomscanadagrouplocationVO[i].getIbflag().equals("I")){
					insertVoList.add(bkgcustomscanadagrouplocationVO[i]);
				} else if ( bkgcustomscanadagrouplocationVO[i].getIbflag().equals("U")){
					updateVoList.add(bkgcustomscanadagrouplocationVO[i]);
				} else if ( bkgcustomscanadagrouplocationVO[i].getIbflag().equals("D")){
					deleteVoList.add(bkgcustomscanadagrouplocationVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addLocCode(insertVoList);
			}
			
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyLocCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeLocCode(deleteVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException((String)new ErrorHandler("BKG00391").getUserMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException((String)new ErrorHandler("BKG00391").getUserMessage());
		}    	
    }
    
    /**
     * @param inputVO
     * @return
     * @throws EventException
     */
    public String searchYardDesc(BkgcustomscanadagrouplocationVO inputVO) throws EventException {
		 try {
			 return dbDao.searchYardDesc(inputVO);
		 } catch (DAOException ex) {
			 throw new EventException((String)new ErrorHandler("BKG00450").getUserMessage());
		 }
	}
    
    /**
     * @param inputVO
     * @return
     * @throws EventException
     */
    public String searchLocDesc(BkgcustomscanadagrouplocationVO inputVO) throws EventException {
		 try {
			 return dbDao.searchLocDesc(inputVO);
		 } catch (DAOException ex) {
			 throw new EventException((String)new ErrorHandler("BKG00450").getUserMessage());
		 }
	}    
	    
}