/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InterfacedCancelBC.java
*@FileTitle : InterfacedCancel
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-16
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2009-04-01 O Wan-Ki 			1.0	최초 생성
* 2009-09-16 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.interfacedcancel.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.candidatemanage.interfacedcancel.vo.SearchInterfacedCancelListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-InterfacedCancelmanage Business Logic Command Interface<br>
 * - ALPS-InterfacedCancelmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author GUN-HA HWANG
 * @see Esd_tpb_0133EventResponse 참조
 * @since J2EE 1.6
 */

public interface InterfacedCancelBC {
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInterfacedCancelListVO	searchInterfacedCancelListVO
	 * @return List<SearchInterfacedCancelListVO>
	 * @exception EventException
	 */
	public List<SearchInterfacedCancelListVO> searchCanceledTPB(SearchInterfacedCancelListVO searchInterfacedCancelListVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInterfacedCancelListVO[] searchInterfacedCancelListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void interfacedTPBCancel(SearchInterfacedCancelListVO[] searchInterfacedCancelListVO,SignOnUserAccount account) throws EventException;
}