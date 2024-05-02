/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : InternalRemarkPopupBCImpl.java
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

import com.clt.apps.opus.esd.trs.common.internalremarkpopup.event.EsdTrs0982Event;
import com.clt.apps.opus.esd.trs.common.internalremarkpopup.integration.InternalRemarkPopupDBDAO;
import com.clt.apps.opus.esd.trs.common.internalremarkpopup.vo.InternalRemarkVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Internal Remark Logic Command Implementation
 * 
 * @author 2015510
 * @see EsdTrs0982EventResponse
 * @since J2EE 1.6
 */
public class InternalRemarkPopupBCImpl extends BasicCommandSupport implements InternalRemarkPopupBC {

	private transient InternalRemarkPopupDBDAO dbDao = null;

	/**
	 * InternalRemarkPopupBCImpl()
	 */
	public InternalRemarkPopupBCImpl() {
		dbDao = new InternalRemarkPopupDBDAO();
	}

	/**
	 * Inquiry event process
	 * 
	 * @param e EsdTrs0982Event
	 * @return List<InternalRemarkVO>
	 * @throws EventException
	 */
	public List<InternalRemarkVO> searchInternalRemarkList(Event e) throws EventException {
		try {
			EsdTrs0982Event event = (EsdTrs0982Event) e;
			return dbDao.searchInternalRemarkList(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Manage event process
	 * 
	 * @param internalRemarkVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageInternalRemarkList(InternalRemarkVO[] internalRemarkVOs, SignOnUserAccount account) throws EventException {
		try {
			if (internalRemarkVOs != null) {
				String ofcCd = JSPUtil.getNull(account.getOfc_cd());
				for (int i = 0; i < internalRemarkVOs.length; i++) {
					if (internalRemarkVOs[i].getIbflag().equals("I")) {
						dbDao.addInternalRemarkList(internalRemarkVOs[i], ofcCd);
					} else if (internalRemarkVOs[i].getIbflag().equals("U")) {
						dbDao.manageInternalRemarkList(internalRemarkVOs[i], "U", ofcCd);
					} else if (internalRemarkVOs[i].getIbflag().equals("D")) {
						dbDao.manageInternalRemarkList(internalRemarkVOs[i], "D", ofcCd);
					}
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * Manage event process by S/O No. W/O No.
	 * 
	 * @param e
	 * @param account
	 * @throws EventException
	 */
	public void manageInternalRemarkListbySoWo(Event e, SignOnUserAccount account) throws EventException {
		try {
			EsdTrs0982Event event = (EsdTrs0982Event) e;
			event.setOfc_cd(account.getOfc_cd());
			dbDao.manageInternalRemarkListbySoWo(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
}
