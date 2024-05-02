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
package com.clt.apps.opus.esd.tpb.jocasemanage.jooutstandinggroupmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.tpb.jocasemanage.jooutstandinggroupmanage.vo.SearchTPBGroupModifyListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -JOOutstandinggroupManagemanage Business Logic Command Interface<br>
 * - -JOOutstandinggroupManagemanage business logic interface<br>
 *
 * @author 
 * @see Esd_tpb_105EventResponse reference
 * @since J2EE 1.6
 */

public interface JOOutstandinggroupManageBC {
	/**
	 * <br>
	 * 
	 * @param SearchTPBGroupModifyListVO searchTPBGroupModifyListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchTPBGroupModifyListVO>
	 * @exception EventException
	 */
	public List<SearchTPBGroupModifyListVO> searchTPBGroupModifyList(SearchTPBGroupModifyListVO searchTPBGroupModifyListVO,SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchTPBGroupModifyListVO[] searchTPBGroupModifyListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchTPBGroupModifyListVO>
	 * @exception EventException
	 */
	public List<SearchTPBGroupModifyListVO> multiTPBGroupModify(SearchTPBGroupModifyListVO[] searchTPBGroupModifyListVO,SignOnUserAccount account) throws EventException;

	/**
	 * <br>
	 * 
	 * @param SearchTPBGroupModifyListVO[] searchTPBGroupModifyListVO
	 * @param SignOnUserAccount account
	 * @return List<SearchTPBGroupModifyListVO>
	 * @exception EventException
	 */
	public List<SearchTPBGroupModifyListVO> updateJOTPBCancel(SearchTPBGroupModifyListVO[] searchTPBGroupModifyListVO,SignOnUserAccount account) throws EventException;
}