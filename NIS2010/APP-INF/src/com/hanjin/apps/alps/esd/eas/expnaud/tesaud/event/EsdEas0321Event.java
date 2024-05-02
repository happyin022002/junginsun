/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : EsdEas0315Event.java
*@FileTitle : Contianer Movement - Reefer
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesaud.event;

import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.CostCodeListVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.StorageCoincidenceVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.StorageCostCalculationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0321 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0321HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 9014613
 * @see ESD_EAS_0321HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class EsdEas0321Event extends EventSupport {
	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	private StorageCostCalculationVO storageCostCalculationVO = null;
	private StorageCoincidenceVO storageCoincidenceVO = null;
	private CostCodeListVO costCodeListVO = null;
	private static final long serialVersionUID = 1L;
	
	public StorageCostCalculationVO getStorageCostCalculationVO() {
		return storageCostCalculationVO;
	}
	public void setStorageCostCalculationVO(StorageCostCalculationVO storageCostCalculationVO) {
		this.storageCostCalculationVO = storageCostCalculationVO;
	}

	public CostCodeListVO getCostCodeListVO() {
		return costCodeListVO;
	}
	public void setCostCodeListVO(CostCodeListVO costCodeListVO) {
		this.costCodeListVO = costCodeListVO;
	}
	
	public StorageCoincidenceVO getStorageCoincidenceVO() {
		return storageCoincidenceVO;
	}
	public void setStorageCoincidenceVO(StorageCoincidenceVO storageCoincidenceVO) {
		this.storageCoincidenceVO = storageCoincidenceVO;
	}

}