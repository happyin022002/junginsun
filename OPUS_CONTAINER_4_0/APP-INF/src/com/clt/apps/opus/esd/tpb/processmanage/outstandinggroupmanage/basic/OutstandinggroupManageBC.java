/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OutstandinggroupManageBC.java
*@FileTitle : OutstandinggroupManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo.ModifyTPBGroupRemakingVO;
import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo.ModifyTPBModificationVO;
import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchTPBGroupRemakingVO;
import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchTPBModificationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -Outstandinggroupmanage Business Logic Command Interface<br>
 * - -Outstandinggroupmanage business logic interface<br>
 *
 * @author 
 * @see Esd_TPB_0105EventResponse reference
 * @since J2EE 1.6
 */

public interface OutstandinggroupManageBC {
	/**
	 * <br>
	 * 
	 * @param SearchTPBGroupRemakingVO	searchTPBGroupRemakingVO
	 * @return List<SearchOutstandinggroupListVO>
	 * @exception EventException
	 */
	public List<SearchTPBGroupRemakingVO> searchTPBGroupRemaking(SearchTPBGroupRemakingVO searchTPBGroupRemakingVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchTPBModificationVO	searchTPBModificationVO
	 * @return List<SearchOutstandinggroupListVO>
	 * @exception EventException
	 */
	public List<SearchTPBModificationVO> searchTPBModification(SearchTPBModificationVO searchTPBModificationVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param ModifyTPBGroupRemakingVO[] modifyTPBGroupRemakingVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTPBGroupRemaking(ModifyTPBGroupRemakingVO[] modifyTPBGroupRemakingVO,SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param ModifyTPBModificationVO[] modifyTPBModificationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTPBModification(ModifyTPBModificationVO[] modifyTPBModificationVO,SignOnUserAccount account) throws EventException;
}