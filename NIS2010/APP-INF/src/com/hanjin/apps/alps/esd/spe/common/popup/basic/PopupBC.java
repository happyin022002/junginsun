/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PopupBC.java
*@FileTitle : S/P Help
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.11 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common.popup.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.spe.common.popup.vo.SpePopupVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Common Business Logic Command Interface<br>
 * ALPS-Common에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */

public interface PopupBC {

	/**
	 * Service Provider 를 조회한다.<br>
	 * 
	 * @param SpePopupVO spePopupVO
	 * @return List<SpePopupVO>
	 * @exception EventException
	 */
	public List<SpePopupVO> searchSPList(SpePopupVO spePopupVO) throws EventException;	
	
	/**
	 * 조직트리룰 조회한다.<br>
	 * 
	 * @param SpePopupVO spePopupVO
	 * @return List<SpePopupVO>
	 * @exception EventException
	 */
	public List<SpePopupVO> searchDeptList(SpePopupVO spePopupVO) throws EventException;	
}