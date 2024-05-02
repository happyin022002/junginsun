/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : FICCostInterfaceBC.java
 *@FileTitle : Cost Table Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.5.08
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.5.08 이은섭
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2013.04.29 김보배 [CHM-201324375] Publish 기능 이전 요청
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.AddOnCostTraiffListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CheckCopyServiceScopeVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CheckFDRCopyServiceScopeVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CopyTariffFdrVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CopyTariffIhcVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.IHCCostTariffInterfaceListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.TariffCodeMappingVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Business Logic Command Interface<br>
 * 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author LEE EUN-SUP
 * @see
 * @since J2EE 1.6
 */
public interface FICCostInterfaceBC {

	/**
	 * ESM_PRI_7021_01 : Cost Table Interface - Add-on Tariff TAB ==> Retrieve
	 * 
	 * @param svcScpCd
	 * @param rhq_cd
	 * @param org_dest_tp_cd
	 * @return List<AddOnCostTraiffListVO>
	 * @throws EventException
	 */
	public List<AddOnCostTraiffListVO> searchAddOnCostTariff(String svcScpCd, String rhq_cd, String org_dest_tp_cd) throws EventException;

	/**
	 * ESM_PRI_7021_01 : Cost Table Interface - Add-on Tariff TAB ==> Cost I/F
	 * 
	 * @param addOnCostTraiffListVOs
	 * @param account
	 * @throws EventException
	 */
	public void managerAddOnCostTraiff(AddOnCostTraiffListVO[] addOnCostTraiffListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_PRI_7021_02 : Cost Table Interface - IHC Tariff TAB ==> Retrieve
	 * 
	 * @param svcScpCd
	 * @param cntCd
	 * @param rhq_cd
	 * @param org_dest_tp_cd
	 * @return List<IHCCostTariffInterfaceListVO>
	 * @throws EventException
	 */
	public List<IHCCostTariffInterfaceListVO> searchIHCCostTariff(String svcScpCd, String cntCd, String rhq_cd, String org_dest_tp_cd) throws EventException;

	/**
	 * ESM_PRI_7021_02 : Cost Table Interface - IHC Tariff TAB ==> Cost I/F
	 * 
	 * @param ihcCostTariffInterfaceListVOs
	 * @param account
	 * @throws EventException
	 */
	public void managerIHCCostTariff(IHCCostTariffInterfaceListVO[] ihcCostTariffInterfaceListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_PRI_7006 : Check Copy Service Scope  ==> Copy to other service scope<br>
	 * 
	 * @param CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs
	 * @return List<CheckCopyServiceScopeVO>
	 * @throws EventException
	 */
	public List<CheckCopyServiceScopeVO> checkCopyServiceScope(CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs) throws EventException;
	
	/**
	 * ESM_PRI_7006 : Check Copy Service Scope - SAVE validation 2 <br>
	 * check exist IHC tariff's status <br>
	 * 
	 * @param CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs
	 * @return List<CheckCopyServiceScopeVO>
	 * @throws EventException
	 */
	public List<CheckCopyServiceScopeVO> checkCopyServiceScopeInitial(CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs) throws EventException;
	
	/**
	 * ESM_PRI_7006 : Check Copy Service Scope - SAVE validation 3 <br>
	 * check exist IHC tariff's effective date <br>
	 * 
	 * @param CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs
	 * @return List<CheckCopyServiceScopeVO>
	 * @throws EventException
	 */
	public List<CheckCopyServiceScopeVO> checkCopyServiceScopeEffdt(CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs) throws EventException;
	
	/**
	 * ESM_PRI_7006 : Copy IHC
	 * 
	 * @param CopyTariffIhcVO[] copyTariffIhcVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageIHCCopy(CopyTariffIhcVO[] copyTariffIhcVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_PRI_7007 : Check Copy Service Scope - SAVE validation 1 <br>
	 * check exist FDR tariff's status <br>
	 * 
	 * @param CheckFDRCopyServiceScopeVO[] checkFDRCopyServiceScopeVOs
	 * @return List<CheckFDRCopyServiceScopeVO>
	 * @throws EventException
	 */
	public List<CheckFDRCopyServiceScopeVO> checkFDRCopyServiceScopeInitial(CheckFDRCopyServiceScopeVO[] checkFDRCopyServiceScopeVOs) throws EventException;
	
	/**
	 * ESM_PRI_7007 : Check Copy Service Scope - SAVE validation 2 <br>
	 * check exist FDR tariff's effective date <br>
	 * 
	 * @param CheckFDRCopyServiceScopeVO[] checkFDRCopyServiceScopeVOs
	 * @return List<CheckFDRCopyServiceScopeVO>
	 * @throws EventException
	 */
	public List<CheckFDRCopyServiceScopeVO> checkFDRCopyServiceScopeEffdt(CheckFDRCopyServiceScopeVO[] checkFDRCopyServiceScopeVOs) throws EventException;

	/**
	 * ESM_PRI_7007 : Copy FDR
	 * 
	 * @param CopyTariffFdrVO[] copyTariffFdrVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageFDRCopy(CopyTariffFdrVO[] copyTariffFdrVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_PRI_7022 : 조회<br>
	 * 
	 * @return List<TariffCodeMappingVO>
	 * @throws EventException
	 */
	public List<TariffCodeMappingVO> searchTariffCodeMapping() throws EventException;
	
	/**
	 * ESM_PRI_7022 : 저장<br>
	 * 
	 * @param TariffCodeMappingVO[] tariffCodeMappingVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageTariffCodeMapping(TariffCodeMappingVO[] tariffCodeMappingVOs, SignOnUserAccount account) throws EventException;

}
