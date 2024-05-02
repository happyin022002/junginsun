/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TesAdvanceAuditBC   
*@FileTitle : Equipment Auto Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-04-13 Jong-Ock Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.LgsCostSubjCdVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAudCfgVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAuditConditionVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAuditMRHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAuditOndockRailHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesInvoiceAuditVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesInvoiceConfirmVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMRStorageFreeDayHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMRStorageFreePoolHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMarineStorageDetailCostByDayVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMarineStorageDetailCostByPoolVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMarineTerminalDetailVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYDetailCostByDayVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYDetailCostByPoolVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYDetailTMNLVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYFreeDayHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYFreePoolHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYGateOutDateVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYTerminalHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOndockRailChargeInvoiceVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * TesAdvanceAuditBC PDTO(Data Transfer Object including Parameters)<br>
 * @author Jong-Ock Kim
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface TesAdvanceAuditBC {
	
	/**
	 * ESD_EAS_0370 조회<br>
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesAudCfgVO>
	 * @exception EventException
	 */
	public List<TesAudCfgVO> searchTesAudCfgList(TesAuditConditionVO tesAuditConditionVO) throws EventException;
	
	/**
	 * ESD_EAS_0370 - Save<br>
	 * 
	 * @param TesAudCfgVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyTesAudCfg(TesAudCfgVO[] listVos, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESD_EAS_0370 - Cost Group
	 * 
	 * @return List<LgsCostSubjCdVO>
	 * @throws DAOException
	 */
	public List<LgsCostSubjCdVO> searchLgsCostSubjCd() throws EventException;
	
	/**
	 * ESD_EAS_0378 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesAuditMRHistoryVO>
	 * @throws DAOException
	 */
	public List<TesAuditMRHistoryVO> searchTesAuditMRHistoryList(TesAuditConditionVO tesAuditConditionVO) throws EventException;
	
	/**
	 * ESD_EAS_0379 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOndockRailChargeInvoiceVO>
	 * @throws DAOException
	 */
	public List<TesOndockRailChargeInvoiceVO> searchTesOndockRailChargeInvoiceAuditDetailList(TesAuditConditionVO tesAuditConditionVO) throws EventException;
	
	/**
	 * ESD_EAS_0371 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesInvoiceConfirmVO>
	 * @exception EventException
	 */
	public List<TesInvoiceConfirmVO> searchTesInvoiceConfirmList(TesAuditConditionVO tesAuditConditionVO) throws EventException;
	
	/**
	 * ESD_EAS_0373 - Init
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYGateOutDateVO>
	 * @exception EventException
	 */
	public List<TesOffdockCYGateOutDateVO> searchTesOffdockCYInvoiceGateOutDate(TesAuditConditionVO tesAuditConditionVO) throws EventException;
	
	/**
	 * ESD_EAS_0373 - Cost Calc.(TMNL)
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYDetailTMNLVO>
	 * @exception EventException
	 */
	public List<TesOffdockCYDetailTMNLVO> searchTesOffdockCYInvoiceAuditDetailTMNLList(TesAuditConditionVO tesAuditConditionVO) throws EventException;
	
	/**
	 * ESD_EAS_0373 - Cost Calc.(SRbyFD)
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYDetailCostByDayVO>
	 * @exception EventException
	 */
	public List<TesOffdockCYDetailCostByDayVO> searchTesOffdockCYInvoiceAuditDetailCostByDayList(TesAuditConditionVO tesAuditConditionVO) throws EventException;
	
	/**
	 * ESD_EAS_0373 - Cost Calc.(SRbyFP)
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYDetailCostByPoolVO>
	 * @exception EventException
	 */
	public List<TesOffdockCYDetailCostByPoolVO> searchTesOffdockCYInvoiceAuditDetailCostByPoolList(TesAuditConditionVO tesAuditConditionVO) throws EventException;
	
	/**
	 * ESD_EAS_0375 - Cost Calc.(SRbyFD)
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesMarineStorageDetailCostByDayVO>
	 * @exception EventException
	 */
	public List<TesMarineStorageDetailCostByDayVO> searchTesMarineStorageInvoiceAuditDetailCostByDayList(TesAuditConditionVO tesAuditConditionVO) throws EventException;
	
	/**
	 * ESD_EAS_0375 - Cost Calc.(SRbyFP)
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesMarineStorageDetailCostByPoolVO>
	 * @exception EventException
	 */
	public List<TesMarineStorageDetailCostByPoolVO> searchTesMarineStorageInvoiceAuditDetailCostByPoolList(TesAuditConditionVO tesAuditConditionVO) throws EventException;

	/**
	 * ESD_EAS_0380 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesAuditOndockRailHistoryVO>
	 * @throws DAOException
	 */
	public List<TesAuditOndockRailHistoryVO> searchTesAuditOndockRailHistoryList(TesAuditConditionVO tesAuditConditionVO) throws EventException;
	
	/**
	 * ESD_EAS_0377 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesMarineTerminalDetailVO>
	 * @throws DAOException
	 */
	public List<TesMarineTerminalDetailVO> searchTesMarineTerminalInvoiceAuditDetailList(TesAuditConditionVO tesAuditConditionVO) throws EventException;

	/**
	 * ESD_EAS_0372 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesInvoiceAuditVO>
	 * @exception EventException
	 */
	public List<TesInvoiceAuditVO> searchTesInvoiceAuditList(TesAuditConditionVO tesAuditConditionVO) throws EventException;
	
	/**
	 * ESD_EAS_0372 - Confirm<br>
	 * 
	 * @param TesInvoiceAuditVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyTesInvoiceAudit(TesInvoiceAuditVO[] listVos, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESD_EAS_0372 - Batch(5분 매뉴얼) 등록<br>
	 * 
	 * @param TesInvoiceAuditVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createTesInvoiceAuditBatch(TesInvoiceAuditVO[] listVos, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESD_EAS_0374 - TMNL
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYTerminalHistoryVO>
	 * @exception EventException
	 */
	public List<TesOffdockCYTerminalHistoryVO> searchTesAuditOffdockCYTerminalHistoryList(TesAuditConditionVO tesAuditConditionVO) throws EventException;

	/**
	 * ESD_EAS_0374 - SR by FD
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYFreeDayHistoryVO>
	 * @exception EventException
	 */
	public List<TesOffdockCYFreeDayHistoryVO> searchTesAuditOffdockCYFreeDayHistoryList(TesAuditConditionVO tesAuditConditionVO) throws EventException;

	/**
	 * ESD_EAS_0374 - SR by FP
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYFreePoolHistoryVO>
	 * @exception EventException
	 */
	public List<TesOffdockCYFreePoolHistoryVO> searchTesAuditOffdockCYFreePoolHistoryList(TesAuditConditionVO tesAuditConditionVO) throws EventException;
	
	/**
	 * ESD_EAS_0376 - SR by FD
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesMRStorageFreeDayHistoryVO>
	 * @exception EventException
	 */
	public List<TesMRStorageFreeDayHistoryVO> searchTesAuditMRStorageFreeDayHistoryList(TesAuditConditionVO tesAuditConditionVO) throws EventException;

	/**
	 * ESD_EAS_0376 - SR by FP
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesMRStorageFreePoolHistoryVO>
	 * @exception EventException
	 */
	public List<TesMRStorageFreePoolHistoryVO> searchTesAuditMRStorageFreePoolHistoryList(TesAuditConditionVO tesAuditConditionVO) throws EventException;	


	/********************	Batch Method START	*******************************/	
	/**
	 * ESD_EAS_B003
	 * 
	 * @param tesAuditConditionVO
	 * @return List<TesInvoiceAuditVO>
	 * @throws EventException
	 */
	public List<TesInvoiceAuditVO> searchTesAutoAuditList(TesAuditConditionVO tesAuditConditionVO) throws EventException;	

	
	/**
	 * ESD_EAS_B003 - Auto Audit 등록<br>
	 * 
	 * @param List<TesInvoiceAuditVO> listVos
	 * @exception EventException
	 */
	public void createInvAud(List<TesInvoiceAuditVO> listVos) throws EventException;
	
	/**
	 * ESD_EAS_B007 - Update<br>
	 * 
	 * @param List<TesInvoiceAuditVO> listVos
	 * @exception EventException
	 */
	public void updateBatchStatus(List<TesInvoiceAuditVO> listVos) throws EventException;
	

	/********************	Batch Method END	*******************************/	
}
