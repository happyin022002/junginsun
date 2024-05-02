/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffTariffBC.java
*@FileTitle : DropOffTariff
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.02
*@LastModifier : YOON, Yong-Sang
*@LastVersion : 1.0
* 2015.11.0 YOON, Yong-Sang
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.basic;

import java.util.List;
import java.util.Map;
import com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.vo.SearchDodTariffListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-DropOffTariff Business Logic Command Interface<br>
 * - ALPS-DropOffTariff ���븳 鍮꾩��땲�뒪 濡쒖쭅�뿉 ���븳 �씤�꽣�럹�씠�뒪<br>
 *
 * @author YOON, Yong-Sang
 * @see EES_DOD_0005EventResponse 李몄“
 * @since J2EE 1.6
 */

public interface DropOffTariffBC {
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO searchDodTariffListVO
	 * @return List<SearchDodTariffListVO>
	 * @exception EventException
	 */
	public List<SearchDodTariffListVO> searchDodTariffList(SearchDodTariffListVO searchDodTariffListVO) throws EventException;	
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO[] searchDodTariffListVOs
	 * @param SignOnUserAccount account
	 * @return List<SearchDodTariffListVO>
	 * @exception EventException
	 */
	public List<SearchDodTariffListVO> expireDodTariffData(SearchDodTariffListVO[] searchDodTariffListVOs, SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO[] searchDodTariffListVOs
	 * @param SignOnUserAccount account
	 * @return List<SearchDodTariffListVO>
	 * @exception EventException
	 */
	public List<SearchDodTariffListVO> expireRestOfDodTariffData(SearchDodTariffListVO[] searchDodTariffListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO[] searchDodTariffListVOs
	 * @return List<SearchDodTariffListVO>
	 * @exception EventException
	 */
	public List<SearchDodTariffListVO> searchDodDuplTariffList(SearchDodTariffListVO[] searchDodTariffListVOs) throws EventException;	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO searchDodTariffListVO
	 * @return List<SearchDodTariffListVO>
	 * @exception EventException
	 */
	public List<SearchDodTariffListVO> searchDodTariffConti(SearchDodTariffListVO searchDodTariffListVO) throws EventException;	
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO searchDodTariffListVO
	 * @param String sTrfDivCd  
	 * @return List<SearchDodTariffListVO>
	 * @exception EventException
	 */
	public List<SearchDodTariffListVO> searchDodTariffList(SearchDodTariffListVO searchDodTariffListVO, String sTrfDivCd) throws EventException;

	
	/**
	 * DodTariffList 를 Confirm 한다.
	 * @param SearchDodTariffListVO[] searchDodTariffListVOs
	 * @param String usrId
	 * @throws EventException
	 */
	public void manageConfirmDodTariffList(SearchDodTariffListVO[] searchDodTariffListVOs, String usrId) throws EventException;

	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO[] searchDodTariffListVOs
	 * @param SignOnUserAccount account
	 * @return List<SearchDodTariffListVO>
	 * @exception EventException
	 */
	public List<SearchDodTariffListVO> manageDodTariffList(SearchDodTariffListVO[] searchDodTariffListVOs,	SignOnUserAccount account) throws EventException;
	
	/**
	 * DropOff Tarriff Creation Special Customer Tab Grid에서 Customer조회
	 * SC_NO, RFA_NO에 종속된 Customer List를 조회 
	 * @param rfaNo
	 * @param scNo
	 * @return
	 * @throws EventException
	 */
	public Map<String, String> searchDodTariffSpecialCustomer(String rfaNo, String scNo) throws EventException;
}
