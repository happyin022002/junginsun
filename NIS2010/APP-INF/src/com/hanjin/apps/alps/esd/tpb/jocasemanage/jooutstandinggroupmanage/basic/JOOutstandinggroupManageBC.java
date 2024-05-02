/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOutstandinggroupManageBC.java
*@FileTitle : JOOutstandinggroupManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.jooutstandinggroupmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.jooutstandinggroupmanage.vo.SearchTPBGroupModifyListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-JOOutstandinggroupManagemanage Business Logic Command Interface<br>
 * - ALPS-JOOutstandinggroupManagemanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author GUN-HA HWANG
 * @see Esd_tpb_105EventResponse 참조
 * @since J2EE 1.6
 */

public interface JOOutstandinggroupManageBC {
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBGroupModifyListVO searchTPBGroupModifyListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchTPBGroupModifyListVO>
	 * @exception EventException
	 */
	public List<SearchTPBGroupModifyListVO> searchTPBGroupModifyList(SearchTPBGroupModifyListVO searchTPBGroupModifyListVO,SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBGroupModifyListVO[] searchTPBGroupModifyListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchTPBGroupModifyListVO>
	 * @exception EventException
	 */
	public List<SearchTPBGroupModifyListVO> multiTPBGroupModify(SearchTPBGroupModifyListVO[] searchTPBGroupModifyListVO,SignOnUserAccount account) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBGroupModifyListVO[] searchTPBGroupModifyListVO
	 * @param SignOnUserAccount account
	 * @return List<SearchTPBGroupModifyListVO>
	 * @exception EventException
	 */
	public List<SearchTPBGroupModifyListVO> updateJOTPBCancel(SearchTPBGroupModifyListVO[] searchTPBGroupModifyListVO,SignOnUserAccount account) throws EventException;
}