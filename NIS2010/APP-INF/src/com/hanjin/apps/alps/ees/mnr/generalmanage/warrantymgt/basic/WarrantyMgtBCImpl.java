/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WarrantyMgtBCImpl.java
*@FileTitle : Warranty Alert_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.03 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.basic;

import java.util.List;
  
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.integration.WarrantyMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo.CustomMnrEqRngStsVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo.CustomWarrantyAlertListVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertInfoGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertListGRPVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
          
/**
 * alps-GeneralManage Business Logic Basic Command implementation<br>
 * - alps-GeneralManage 에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author park myoung sin   
 * @see EesMnr0213Event,WarrantyMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4    
 */        
    
public class WarrantyMgtBCImpl extends BasicCommandSupport implements WarrantyMgtBC {

	// Database Access Object 
	private transient WarrantyMgtDBDAO dbDao = null; 
	 	
	/** 
	 * GeneralCodeMgtBCImpl 객체 생성<br>
	 * GeneralCodeMgtDBDAO를 생성한다.<br>
	 */    
	public WarrantyMgtBCImpl() {  
		dbDao = new WarrantyMgtDBDAO();
	}

	/**
	 * [EES_MNR_0213]Warranty Alert_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param WarrantyAlertInfoGRPVO warrantyAlertInfoGRPVO
	 * @return WarrantyAlertInfoGRPVO
	 * @exception EventException
	 */
	public WarrantyAlertInfoGRPVO searchWarrantyAlertInfoBasic(WarrantyAlertInfoGRPVO warrantyAlertInfoGRPVO) throws EventException {
		try { 
			//다건조회  
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
	 * [EES_MNR_0170]Reefer Unit Warranty Period의 정보를 조회 합니다. <br>
	 *
	 * @param WarrantyAlertListGRPVO warrantyAlertListGRPVO
	 * @return WarrantyAlertListGRPVO
	 * @exception EventException
	 */
	public WarrantyAlertListGRPVO searchWarrantyAlertListBasic(WarrantyAlertListGRPVO warrantyAlertListGRPVO) throws EventException {
		try { 
			//다건조회   
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
	  
