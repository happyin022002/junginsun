/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeGroupLocationBC.java
*@FileTitle : Surcharge Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.06 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.basic;

import com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.vo.SurchargeGroupLocationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Surcharge Business Logic Command Interface<br>
 * - NIS2010-Surcharge에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung Jun Lee
 * @see Esm_pri_4004EventResponse 참조
 * @since J2EE 1.4
 */

public interface SurchargeGroupLocationBC {
	/**
	 * 조회 이벤트 처리<br>
	 *  SurchargeGroupLocation화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SurchargeGroupLocationVO surchargeGroupLocation
	 * @return SurchargeGroupLocationVO
	 * @exception EventException
	 */
	public SurchargeGroupLocationVO searchGroupLocationList(SurchargeGroupLocationVO surchargeGroupLocation) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * In화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SurchargeGroupLocationVO surchargeGroupLocation
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageGroupLocation(SurchargeGroupLocationVO surchargeGroupLocation, SignOnUserAccount account) throws EventException;
}