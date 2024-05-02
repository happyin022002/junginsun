/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtBC.java
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.basic;

import com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.vo.GeneralCodeMgtGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
  
/**
 * alps-Generalmanage Business Logic Command Interface<br>
 * - alps-Generalmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author WanGyu Kim 
 * @see Ees_mnr_0009EventResponse 참조
 * @since J2EE 1.4
 */

public interface GeneralCodeMgtBC { 
	/**
	 * [EES_MNR_0009]M&R Other Code의 정보를 조회 합니다. <br>
	 *
	 * @param GeneralCodeMgtGRPVO generalCodeMgtGRPVO
	 * @return GeneralCodeMgtGRPVO
	 * @exception EventException
	 */
	public GeneralCodeMgtGRPVO searchGeneralCodeListBasic(GeneralCodeMgtGRPVO generalCodeMgtGRPVO) throws EventException;
	/**
	 * [EES_MNR_0009]M&R Other Code의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param GeneralCodeMgtGRPVO generalCodeMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGeneralCodeBasic(GeneralCodeMgtGRPVO generalCodeMgtGRPVO,SignOnUserAccount account) throws EventException;
	
} 