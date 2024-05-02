/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OutstandinggroupManageBC.java
*@FileTitle : OutstandinggroupManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2008-09-16 Kim Jin-seung	1.0	최초 생성
* 2009.09.04 Sun, CHOI		1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.vo.ModifyTPBGroupRemakingVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.vo.ModifyTPBModificationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchTPBGroupRemakingVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchTPBModificationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Outstandinggroupmanage Business Logic Command Interface<br>
 * - ALPS-Outstandinggroupmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Sun, CHOI
 * @see Esd_TPB_0105EventResponse 참조
 * @since J2EE 1.6
 */

public interface OutstandinggroupManageBC {
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBGroupRemakingVO	searchTPBGroupRemakingVO
	 * @return List<SearchOutstandinggroupListVO>
	 * @exception EventException
	 */
	public List<SearchTPBGroupRemakingVO> searchTPBGroupRemaking(SearchTPBGroupRemakingVO searchTPBGroupRemakingVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBModificationVO	searchTPBModificationVO
	 * @return List<SearchOutstandinggroupListVO>
	 * @exception EventException
	 */
	public List<SearchTPBModificationVO> searchTPBModification(SearchTPBModificationVO searchTPBModificationVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ModifyTPBGroupRemakingVO[] modifyTPBGroupRemakingVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTPBGroupRemaking(ModifyTPBGroupRemakingVO[] modifyTPBGroupRemakingVO,SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ModifyTPBModificationVO[] modifyTPBModificationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTPBModification(ModifyTPBModificationVO[] modifyTPBModificationVO,SignOnUserAccount account) throws EventException;
}