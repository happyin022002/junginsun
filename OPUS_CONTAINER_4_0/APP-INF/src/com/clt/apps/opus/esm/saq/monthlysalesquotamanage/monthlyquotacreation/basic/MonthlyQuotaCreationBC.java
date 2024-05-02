/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaCreationBC.java
 *@FileTitle : Model Execution
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.basic;

import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event.EsmSaq0176Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.BaseDataFromCoaListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.BaseDataInterfaceVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.SearchMonthlyQuotaCheckListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.SearchMonthlyQuotaInfoList0077VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.SearchMonthlyQuotaModelLogListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Monthlysalesquotamanage Business Logic Command Interface<br>
 * 
 * @author
 * @see Esm_saq_0047EventResponse
 * @since J2EE 1.6
 */

public interface MonthlyQuotaCreationBC {
	/**
	 * 
	 * @param quotaConditionVO
	 * @return List<searchMonthlyQuotaCheckListVO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaCheckListVO> searchMonthlyQuotaCheckList0047Tab01(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param quotaConditionVO
	 * @return List<searchMonthlyQuotaModelLogListVO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaModelLogListVO> searchMonthlyQuotaModelLogList0047Tab02(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param quotaConditionVO
	 * @param account SignOnUserAccount
	 *            
	 * @exception EventException
	 */
	public void transferMonthlyProcess0047(QuotaConditionVO quotaConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param quotaConditionVO
	 * @return List<searchMonthlyQuotaCheckListVO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInfoList0077VO> searchMonthlyQuotaInfoList0077(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0077]을 [MULTI01] 합니다.<br>
	 * 
	 * @param quotaConditionVO
	 * @param account SignOnUserAccount
	 *            
	 * @exception EventException
	 */
	public void confirmMonthlyQuotaFinalVersion0077(QuotaConditionVO quotaConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SAQ_0077]을 [MODIFY01] 합니다.<br>	
	 * @param bseYr
	 * @param bse_qtr_cd
	 * @param account
	 * @throws EventException
	 */
	public void procMonthlyInitSmryCreation0077(String bseYr, String bse_qtr_cd, SignOnUserAccount account) throws EventException;

	/**
	 * @param baseDataFromCoaListVO
	 * @param account
	 * @throws EventException
	 */
	public void createCoaInterfaceList(BaseDataFromCoaListVO baseDataFromCoaListVO, SignOnUserAccount account) throws EventException;

	/**
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchInterfaceList(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException;

	/**
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchCOfcVerify(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException;

	/**
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchLOfcVerify(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException;
	
	/**
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public String checkOfficeValid(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException;
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO []
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateOfcVerify(BaseDataInterfaceVO[] baseDataInterfaceVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 	 
	 * @param baseDataInterfaceVO
	 * @param account
	 * @throws EventException
	 */
	public void updateReCalRpbCpb(BaseDataInterfaceVO[] baseDataInterfaceVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public String checkConfirmFlg(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException;
	
	/**
	 * 
	 * @param baseDataInterfaceVO
	 * @param account
	 * @throws EventException
	 */
	public void updateConfirm(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 
	 * @param baseDataInterfaceVO
	 * @param account
	 * @throws EventException
	 */
	public void updateCancel(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 
	 * @param baseDataInterfaceVO
	 * @param account
	 * @throws EventException
	 */
	public void updateNotify(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchOfcAdjust(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException;
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO []
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateOfcAdjust(BaseDataInterfaceVO[] baseDataInterfaceVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchLaneAdjust(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException;
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO []
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateLaneAdjust(BaseDataInterfaceVO[] baseDataInterfaceVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchCPBAdjust(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException;
	
	/**
	 * 
	 * @param baseDataInterfaceVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void updateCPBAdjust(BaseDataInterfaceVO[] baseDataInterfaceVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param baseDataInterfaceVO
	 * @param SignOnUserAccount account
	 * @return 
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchGuidelineInitList(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchGuidelineList(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException;
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO []
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateGuideline(BaseDataInterfaceVO[] baseDataInterfaceVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateGuidelineCancelConfirm(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateGuidelineConfirm(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateGuidelineNotify(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateGuidelineCancelNotify(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException;

}
