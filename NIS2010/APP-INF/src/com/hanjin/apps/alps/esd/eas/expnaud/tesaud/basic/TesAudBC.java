/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesMvmtAudBC   
*@FileTitle : Contianer Movement - Reefer
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02 : 9014613
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesaud.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.CostCodeListVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.StorageCoincidenceVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.StorageCostCalculationVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.TesOnDockRailCostCalculationVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.TesOnDockRailVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.TesRowDataVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * TesAudBC PDTO(Data Transfer Object including Parameters)<br>
 * @author 9014613
 * @see List<SearchMvmtLegListVO> 참조
 * @since J2EE 1.4
 */
public interface TesAudBC {
	/**
	 * MR invoice Report
	 * 
	 * @category EDS_EAS_0311
	 * @param TesRowDataVO tesRowDataVO
	 * @return List<TesRowDataVO>
	 * @throws EventException
	 */
	public List<TesRowDataVO> searchTesRowDataList(TesRowDataVO tesRowDataVO) throws EventException;
	
	/**
	 * On Dock Rail Data Inquiry - Coincidence
	 * 
	 * @category EDS_EAS_0312
	 * @param TesOnDockRailVO tesOnDockRailVO
	 * @return List<TesOnDockRailVO>
	 * @throws EventException
	 */
	public List<TesOnDockRailVO> searchOnDockRailDataList(TesOnDockRailVO tesOnDockRailVO) throws EventException;
	
	/**
	 * On Dock Rail Data Inquiry - Cost Calculation
	 * 
	 * @category EDS_EAS_0320
	 * @param TesOnDockRailCostCalculationVO tesOnDockRailCostCalculationVO
	 * @return List<TesOnDockRailCostCalculationVO>
	 * @throws EventException
	 */
	public List<TesOnDockRailCostCalculationVO> searchOnDockRailCostCalculationList(TesOnDockRailCostCalculationVO tesOnDockRailCostCalculationVO) throws EventException;

	/**
	 * Storage Data inquiry -Cost Calculated
	 * 
	 * @category EDS_EAS_0321,EDS_EAS_0322
	 * @param StorageCostCalculationVO storageCostCalculationVO
	 * @return List<StorageCostCalculationVO>
	 * @throws EventException
	 */
	public List<StorageCostCalculationVO> searchStorageCostCalculationList(StorageCostCalculationVO storageCostCalculationVO) throws EventException;
	
	/**
	 * CostCodeList search
	 * 
	 * @category EDS_EAS_0321,EDS_EAS_0322
	 * @param CostCodeListVO costCodeListVO
	 * @return List<CostCodeListVO>
	 * @throws EventException
	 */
	public List<CostCodeListVO> searchCostCodeList(CostCodeListVO costCodeListVO) throws EventException;
	
	/**
	 * Storage Calculation - Coincidence
	 * 
	 * @category EDS_EAS_0313
	 * @param StorageCoincidenceVO storageCoincidenceVO
	 * @return List<StorageCostCalculationVO>
	 * @throws EventException
	 */
	public List<StorageCoincidenceVO> searchStorageCoincidenceList(StorageCoincidenceVO storageCoincidenceVO) throws EventException;
	
}