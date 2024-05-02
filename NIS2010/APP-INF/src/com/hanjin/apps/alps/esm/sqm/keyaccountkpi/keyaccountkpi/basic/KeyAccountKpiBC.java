/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : KeyAccountKpiBC.java
*@FileTitle      : KeyAccountKpi
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.08.13
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.08.13 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.vo.SearchKpiUploadVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmKeyAcctCfmQtaVO;

/**
 * ALPS-KeyAccountKpi Business Logic Command Interface<br>
 * - ALPS-KeyAccountKpi 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 이혜민
 * @see
 * @since J2EE 1.6
 */
public interface KeyAccountKpiBC {
	/**
	 * ESM_SQM_0601 : [SEARCH]<br>
	 * [KPI Upload]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchKpiUploadVO>
	 * @exception EventException
	 */
	public List<SearchKpiUploadVO> searchKpiUpload(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0601 : [SEARCH]<br>
	 * [KPI Upload]을 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchKpiUploadCnt(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0601 : [SEARCH01]<br>
	 * [KPI Upload]화면에서 Yearly 조회 후 Quarterly 1Q 데이터가 있는지 없는지 [확인]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String search1QTransferDataCnt(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0601 : [MULTI]<br>
	 * [KPI Upload]을 [저장] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmKeyAcctCfmQtaVO[] sqmKeyAcctCfmQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageKpiUpload(ConditionVO conditionVO, SqmKeyAcctCfmQtaVO[] sqmKeyAcctCfmQtaVOS, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_SQM_0601 : [MULTI01]<br>
	 * [KPI Upload]화면에서 [1Q Data]을 [Transfer] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String create1QTransferData(ConditionVO conditionVO, String usrId) throws EventException;
}