/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomsMasterMgtBCImpl.java
*@FileTitle : Location of goods Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.04 김경섭
* 1.0 Creation
* 2012.09.04 변종건 [CHM-201219976-01] Split 01-Canada A/N 수정 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration.CustomsMasterMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgcustomscanadagrouplocationVO;
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
 * @see esm_bkg_0354EventResponse 참조
 * @since J2EE 1.6
 */

public class CustomsMasterMgtBCImpl extends BasicCommandSupport implements CustomsMasterMgtBC {

	// Database Access Object
	private transient CustomsMasterMgtDBDAO dbDao = null;

	/**
	 * CustomsMasterMgtBCImpl 객체 생성<br>
	 * CustomsMasterMgtDBDAO 생성한다.<br>
	 */
	public CustomsMasterMgtBCImpl() {
		dbDao = new CustomsMasterMgtDBDAO();
	}
	
	/**
	 *  0354: Canada ACI: Location of Goods 을 조회합니다.<br>
	 *  
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
	  * 0354 Canada ACI: Location of Goods Setup - Loc Code 생성/수정을 위한 기존 데이타를 조회합니다.<br>
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
     * 0354: Canada ACI: Location of Goods 을 트랜잭션 처리합니다.<br>	
     * 
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