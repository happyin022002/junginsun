/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualEmailSettingBC.java
*@FileTitle : Accrual Mail Setting
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.basic;

import java.util.List;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchAccrualEmailSettingVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchParameterAccrualEmailSettingVO;
import com.clt.framework.component.javamail.SingleMailAttachedFile;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.LeaEmlSetVO;

/**
 * ALPS-LogisticsExpenseAccrual Business Logic Command Interface<br>
 * - The interface of the business logic about ALPS-LogisticsExpenseAccrual<br>
 *
 * @author
 * @see Esd_lea_0009EventResponse 
 * @since J2EE 1.6
 */

public interface AccrualEmailSettingBC {

	/**
	 * Sending the result of the batch or ERP I/F to the list of the receivers by email.<br>
	 * 
	 * @param SearchParameterAccrualEmailSettingVO	searchParameterAccrualEmailSettingVO
	 * @exception EventException
	 */
	public void sendTestAccrualEmailSetting(SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO) throws EventException;

	/**
	 * Inquiring the parameter settings for sending email<br>
	 * 
	 * @param SearchParameterAccrualEmailSettingVO	searchParameterAccrualEmailSettingVO
	 * @return List<SearchParameterAccrualEmailSettingVO>
	 * @exception EventException
	 */
	public List<SearchParameterAccrualEmailSettingVO> searchParameterAccrualEmailSetting(SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO) throws EventException;

	/**
	 * Inquiring the setting items for sending email<br>
	 * 
	 * @param SearchAccrualEmailSettingVO	searchAccrualEmailSettingVO
	 * @return List<SearchAccrualEmailSettingVO>
	 * @exception EventException
	 */
	public List<SearchAccrualEmailSettingVO> searchAccrualEmailSetting(SearchAccrualEmailSettingVO searchAccrualEmailSettingVO) throws EventException;
	
	/**
	 * Modifying the setting items for sending email.<br>
	 * 
	 * @param LeaEmlSetVO[] leaEmlSetVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAccrualEmailSetting(LeaEmlSetVO[] leaEmlSetVOs ,SignOnUserAccount account) throws EventException;
	
	/**
	 * Sending email.<br>
	 * 
	 * @param String str_fm_eml
	 * @param String[] to_eml
	 * @param String subject_nm
	 * @param String contents
	 * @exception EventException
	 */
	public void sendEml(String str_fm_eml, String[] to_eml, String subject_nm, String contents) throws EventException;
}