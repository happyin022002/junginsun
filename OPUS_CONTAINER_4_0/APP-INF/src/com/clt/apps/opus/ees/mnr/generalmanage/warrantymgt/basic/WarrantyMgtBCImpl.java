/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WarrantyMgtBCImpl.java
*@FileTitle : Warranty Alert_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.basic;

import java.util.List;
  
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.integration.WarrantyMgtDBDAO;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.CustomMnrEqRngStsVO;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.CustomWarrantyAlertListVO;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertInfoGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertListGRPVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
          
/**
 * COM-GeneralManage Business Logic Basic Command implementation<br>
 *
 * @author    
 * @see EesMnr0213Event,WarrantyMgtBC DAO class reference
 * @since J2EE 1.4    
 */        
    
public class WarrantyMgtBCImpl extends BasicCommandSupport implements WarrantyMgtBC {

	// Database Access Object 
	private transient WarrantyMgtDBDAO dbDao = null; 
	 	
	/** 
	 * creating GeneralCodeMgtBCImpl object<br>
	 * creating GeneralCodeMgtDBDAO <br>
	 */    
	public WarrantyMgtBCImpl() {  
		dbDao = new WarrantyMgtDBDAO();
	}

	/**
	 * [EES_MNR_0213] retrieving Warranty Alert_Pop Up. <br>
	 *
	 * @param WarrantyAlertInfoGRPVO warrantyAlertInfoGRPVO
	 * @return WarrantyAlertInfoGRPVO
	 * @exception EventException
	 */
	public WarrantyAlertInfoGRPVO searchWarrantyAlertInfoBasic(WarrantyAlertInfoGRPVO warrantyAlertInfoGRPVO) throws EventException {
		try { 
			//multiple search  
			List<CustomMnrEqRngStsVO> customMnrEqRngStsVOS = null;
			
			customMnrEqRngStsVOS = dbDao.searchWarrantyAlertInfoData(warrantyAlertInfoGRPVO.getWarrantyAlertInfoINVO());
			  		
			warrantyAlertInfoGRPVO.setCustomMnrEqRngStsVOS(customMnrEqRngStsVOS);   
			return warrantyAlertInfoGRPVO;      
			
		} catch (DAOException ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0213] searchWarrantyAlertInfoBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0213] searchWarrantyAlertInfoBasic"}).getMessage(),ex);
		}
	}  
	 
	/**
	 * [EES_MNR_0170] retrieving Reefer Unit Warranty Period. <br>
	 *
	 * @param WarrantyAlertListGRPVO warrantyAlertListGRPVO
	 * @return WarrantyAlertListGRPVO
	 * @exception EventException
	 */
	public WarrantyAlertListGRPVO searchWarrantyAlertListBasic(WarrantyAlertListGRPVO warrantyAlertListGRPVO) throws EventException {
		try { 
			//multiple search     
			List<CustomWarrantyAlertListVO> customWarrantyAlertListVOS = null;
			  
			customWarrantyAlertListVOS = dbDao.searchWarrantyAlertListData(warrantyAlertListGRPVO.getWarrantyAlertListINVO());
			   		 
			warrantyAlertListGRPVO.setCustomWarrantyAlertListVOS(customWarrantyAlertListVOS);    
			return warrantyAlertListGRPVO;       
			
		} catch (DAOException ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0170] searchWarrantyAlertListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0170] searchWarrantyAlertListBasic"}).getMessage(),ex);
		}  
	} 
}
	  
