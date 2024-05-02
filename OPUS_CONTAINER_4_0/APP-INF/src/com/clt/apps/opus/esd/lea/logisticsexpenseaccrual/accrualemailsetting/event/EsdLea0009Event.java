/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0009Event.java
*@FileTitle : Accrual Mail Setting
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.18
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.09.18 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchAccrualEmailSettingVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchParameterAccrualEmailSettingVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.LeaEmlSetVO;
//import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SendTestAccrualEmailSetting;


/**
 * ESD_LEA_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LeaEmlSetVO leaEmlSetVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LeaEmlSetVO[] leaEmlSetVOs = null;

//	/** Table Value Object 조회 조건 및 단건 처리  */
//	private SendTestAccrualEmailSetting sendTestAccrualEmailSetting = null;
//	
//	/** Table Value Object Multi Data 처리 */
//	private SendTestAccrualEmailSetting[] sendTestAccrualEmailSettings = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchParameterAccrualEmailSettingVO[] searchParameterAccrualEmailSettingVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAccrualEmailSettingVO searchAccrualEmailSettingVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAccrualEmailSettingVO[] searchAccrualEmailSettingVOs = null;

	public EsdLea0009Event(){}
	
	public void setLeaEmlSetVO(LeaEmlSetVO leaEmlSetVO){
		this. leaEmlSetVO = leaEmlSetVO;
	}

	public void setLeaEmlSetVOS(LeaEmlSetVO[] leaEmlSetVOs){
		this. leaEmlSetVOs = leaEmlSetVOs;
	}

//	public void setSendTestAccrualEmailSetting(SendTestAccrualEmailSetting sendTestAccrualEmailSetting){
//		this. sendTestAccrualEmailSetting = sendTestAccrualEmailSetting;
//	}
//
//	public void setSendTestAccrualEmailSettingS(SendTestAccrualEmailSetting[] sendTestAccrualEmailSettings){
//		this. sendTestAccrualEmailSettings = sendTestAccrualEmailSettings;
//	}

	public void setSearchParameterAccrualEmailSettingVO(SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO){
		this. searchParameterAccrualEmailSettingVO = searchParameterAccrualEmailSettingVO;
	}

	public void setSearchParameterAccrualEmailSettingVOS(SearchParameterAccrualEmailSettingVO[] searchParameterAccrualEmailSettingVOs){
		this. searchParameterAccrualEmailSettingVOs = searchParameterAccrualEmailSettingVOs;
	}

	public void setSearchAccrualEmailSettingVO(SearchAccrualEmailSettingVO searchAccrualEmailSettingVO){
		this. searchAccrualEmailSettingVO = searchAccrualEmailSettingVO;
	}

	public void setSearchAccrualEmailSettingVOS(SearchAccrualEmailSettingVO[] searchAccrualEmailSettingVOs){
		this. searchAccrualEmailSettingVOs = searchAccrualEmailSettingVOs;
	}

	public LeaEmlSetVO getLeaEmlSetVO(){
		return leaEmlSetVO;
	}

	public LeaEmlSetVO[] getLeaEmlSetVOS(){
		return leaEmlSetVOs;
	}

//	public SendTestAccrualEmailSetting getSendTestAccrualEmailSetting(){
//		return sendTestAccrualEmailSetting;
//	}
//
//	public SendTestAccrualEmailSetting[] getSendTestAccrualEmailSettingS(){
//		return sendTestAccrualEmailSettings;
//	}

	public SearchParameterAccrualEmailSettingVO getSearchParameterAccrualEmailSettingVO(){
		return searchParameterAccrualEmailSettingVO;
	}

	public SearchParameterAccrualEmailSettingVO[] getSearchParameterAccrualEmailSettingVOS(){
		return searchParameterAccrualEmailSettingVOs;
	}

	public SearchAccrualEmailSettingVO getSearchAccrualEmailSettingVO(){
		return searchAccrualEmailSettingVO;
	}

	public SearchAccrualEmailSettingVO[] getSearchAccrualEmailSettingVOS(){
		return searchAccrualEmailSettingVOs;
	}

}