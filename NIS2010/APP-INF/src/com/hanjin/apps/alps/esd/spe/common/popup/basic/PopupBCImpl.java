/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PopupBCImpl.java
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

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.esd.spe.common.popup.integration.PopupDBDAO;
import com.hanjin.apps.alps.esd.spe.common.popup.vo.SpePopupVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Common Business Logic Command Interface<br>
 * ALPS-Common에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */
public class PopupBCImpl extends BasicCommandSupport implements PopupBC {

	// Database Access Object
	private transient PopupDBDAO dbDao = null;

	/**
	 * PopupBCImpl 객체 생성<br>
	 * PopupDBDAO를 생성한다.<br>
	 */
	public PopupBCImpl() {
		dbDao = new PopupDBDAO();
	}
	
	/**
	 * Service Provider 를 조회한다.<br>
	 * 
	 * @param SpePopupVO spePopupVO
	 * @return List<SpePopupVO>
	 * @exception EventException
	 */
	public List<SpePopupVO> searchSPList(SpePopupVO spePopupVO) throws EventException {
		try {
			return dbDao.searchSPList(spePopupVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * 조직트리룰 조회한다.<br>
	 * 
	 * @param SpePopupVO spePopupVO
	 * @return List<SpePopupVO>
	 * @exception EventException
	 */
	public List<SpePopupVO> searchDeptList(SpePopupVO spePopupVO) throws EventException {
		try {
			return dbDao.searchDeptList(spePopupVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
}