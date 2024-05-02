/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesMvmtAudBCImpl
*@FileTitle : Contianer Movement - Reefer
*Open Issues :   
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02 9014613
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesaud.basic;


import java.util.List;

import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.integration.TesAudDBDAO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.CostCodeListVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.StorageCoincidenceVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.StorageCostCalculationVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.TesOnDockRailCostCalculationVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.TesOnDockRailVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.TesRowDataVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * TesAudBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * @author 9014613
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class TesAudBCImpl extends BasicCommandSupport implements TesAudBC {

	
	// Database Access Object
	private transient TesAudDBDAO dbDao = null;

	/**
	 * TesAudBCImpl 객체 생성<br>
	 * TesAudDBDAO 생성한다.<br>
	 */
	public TesAudBCImpl(){
		dbDao = new TesAudDBDAO();
	}

	/**
	 * MR invoice Report
	 * 
	 * @category ESD_EAS_0311
	 * @param TesRowDataVO tesRowDataVO
	 * @return List<TesRowDataVO>
	 * @throws EventException
	 */
	public List<TesRowDataVO> searchTesRowDataList(TesRowDataVO tesRowDataVO) throws EventException {

		try {
			return dbDao.searchTesRowDataList(tesRowDataVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * On Dock Rail Data Inquiry - Coincidence
	 * 
	 * @category ESD_EAS_0312
	 * @param TesOnDockRailVO tesOnDockRailVO
	 * @return List<TesOnDockRailVO>
	 * @throws EventException
	 */
	public List<TesOnDockRailVO> searchOnDockRailDataList(TesOnDockRailVO tesOnDockRailVO) throws EventException {

		try {
			return dbDao.searchOnDockRailDataList(tesOnDockRailVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * On Dock Rail Data Inquiry - Cost Calculation
	 * 
	 * @category ESD_EAS_0320
	 * @param TesOnDockRailCostCalculationVO tesOnDockRailCostCalculationVO
	 * @return List<TesOnDockRailCostCalculationVO>
	 * @throws EventException
	 */
	public List<TesOnDockRailCostCalculationVO> searchOnDockRailCostCalculationList(TesOnDockRailCostCalculationVO tesOnDockRailCostCalculationVO) throws EventException {

		try {
			return dbDao.searchOnDockRailCostCalculationList(tesOnDockRailCostCalculationVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Storage Data inquiry -Cost Calculated
	 * 
	 * @category ESD_EAS_0321,ESD_EAS_0322
	 * @param StorageCostCalculationVO storageCostCalculationVO
	 * @return List<StorageCostCalculationVO>
	 * @throws EventException
	 */
	public List<StorageCostCalculationVO> searchStorageCostCalculationList(StorageCostCalculationVO storageCostCalculationVO)  throws EventException {

		try {
			return dbDao.searchStorageCostCalculationList(storageCostCalculationVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * CostCodeList search
	 * 
	 * @category ESD_EAS_0321,ESD_EAS_0322
	 * @param CostCodeListVO costCodeListVO
	 * @return List<CostCodeListVO>
	 * @throws EventException
	 */
	public List<CostCodeListVO> searchCostCodeList(CostCodeListVO costCodeListVO)  throws EventException {

		try {
			return dbDao.searchCostCodeList(costCodeListVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Storage Calculation - Coincidence
	 * 
	 * @category ESD_EAS_0313
	 * @param StorageCoincidenceVO storageCoincidenceVO
	 * @return List<storageCoincidenceVO>
	 * @throws EventException
	 */
	public List<StorageCoincidenceVO> searchStorageCoincidenceList(StorageCoincidenceVO storageCoincidenceVO)  throws EventException {

		try {
			return dbDao.searchStorageCoincidenceList(storageCoincidenceVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
}
