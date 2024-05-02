/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : InternalRemarkPopupBC.java
 *@FileTitle : Internal Remark 조회(공통 Popup)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015-05-07
 *@LastModifier : ChanWooPark
 *@LastVersion : 1.0
 * 2015-05-07 ChanWooPark
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.common.internalremarkpopup.basic;

import java.util.List;

import com.clt.apps.opus.esd.trs.common.internalremarkpopup.vo.InternalRemarkVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Internal Remark Logic Command Interface
 * 
 * @author 2015510
 * @see EsdTrs0982EventResponse
 * @since J2EE 1.6
 */
public interface InternalRemarkPopupBC {

	/**
	 * Inquiry event process
	 * 
	 * @param e EsdTrs0982Event
	 * @return List<InternalRemarkVO>
	 * @throws EventException
	 */
	public List<InternalRemarkVO> searchInternalRemarkList(Event e) throws EventException;

	/**
	 * Manage event process
	 * 
	 * @param internalRemarkVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageInternalRemarkList(InternalRemarkVO[] internalRemarkVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Manage event process by S/O No. W/O No.
	 * 
	 * @param e
	 * @param account
	 * @throws EventException
	 */
	public void manageInternalRemarkListbySoWo(Event e, SignOnUserAccount account) throws EventException;
}
