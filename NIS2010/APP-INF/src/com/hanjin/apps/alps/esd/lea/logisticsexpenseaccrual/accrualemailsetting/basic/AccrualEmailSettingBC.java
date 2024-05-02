/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualEmailSettingBC.java
*@FileTitle : Accrual Mail Setting
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.18
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.09.18 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.basic;

import java.util.List;

import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.LeaEmlSetVO;
//import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SendTestAccrualEmailSetting;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchParameterAccrualEmailSettingVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchAccrualEmailSettingVO;

/**
 * ALPS-Logisticsexpenseaccrual Business Logic Command Interface<br>
 * - ALPS-Logisticsexpenseaccrual에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jeon Jae Hong
 * @see Esd_lea_0009EventResponse 참조
 * @since J2EE 1.6
 */

public interface AccrualEmailSettingBC {

	/**
	 * Batch 또는 ERP I/F 결과를 수신자 목록의 Email로 송신한다.<br>
	 * 
	 * @param SearchParameterAccrualEmailSettingVO	searchParameterAccrualEmailSettingVO
	 * @exception EventException
	 */
	public void sendTestAccrualEmailSetting(SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO) throws EventException;

	/**
	 * Email 송신을 위한  Parameter Setting 항목 조회<br>
	 * 
	 * @param SearchParameterAccrualEmailSettingVO	searchParameterAccrualEmailSettingVO
	 * @return List<SearchParameterAccrualEmailSettingVO>
	 * @exception EventException
	 */
	public List<SearchParameterAccrualEmailSettingVO> searchParameterAccrualEmailSetting(SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO) throws EventException;

	/**
	 * Email 송신을 위한 Setting 항목조회<br>
	 * 
	 * @param SearchAccrualEmailSettingVO	searchAccrualEmailSettingVO
	 * @return List<SearchAccrualEmailSettingVO>
	 * @exception EventException
	 */
	public List<SearchAccrualEmailSettingVO> searchAccrualEmailSetting(SearchAccrualEmailSettingVO searchAccrualEmailSettingVO) throws EventException;
	
	/**
	 * Email 송신을 위한 Setting 항목 변경<br>
	 * 
	 * @param LeaEmlSetVO[] leaEmlSetVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAccrualEmailSetting(LeaEmlSetVO[] leaEmlSetVOs ,SignOnUserAccount account) throws EventException;
	
	/**
	 * Email 송신<br>
	 * 
	 * @param String str_fm_eml
	 * @param String[] to_eml
	 * @param String subject_nm
	 * @param String contents
	 * @exception EventException
	 */
	public void sendEml(String str_fm_eml, String[] to_eml, String subject_nm, String contents) throws EventException;
}