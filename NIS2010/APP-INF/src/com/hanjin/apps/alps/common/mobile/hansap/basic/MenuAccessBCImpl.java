/**
 * Copyright(c) 2013 CyberLogitec
 * @FileName : MenuAccessBCImpl.java
 * @FileTitle : Menu별 접근 권한 추가, 삭제
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2013.12.17
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.0
 * 2013.12.17 1.0 Sang-Hyun Kim Creation.
 */
package com.hanjin.apps.alps.common.mobile.hansap.basic;

import com.hanjin.apps.alps.common.mobile.hansap.integration.MenuAccessDBDAO;
import com.hanjin.apps.alps.common.mobile.hansap.vo.MobAuthorityVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * Menu별 접근 권한 추가, 삭제
 * @author Sang-Hyun Kim
 * @see 
 * @since J2EE 1.4
 */
public class MenuAccessBCImpl implements MenuAccessBC {

	private MenuAccessDBDAO menuAccessDBDAO = null;

	/**
	 * Constructor.
	 */
	public MenuAccessBCImpl() {
		this.menuAccessDBDAO = new MenuAccessDBDAO();
	}

	/**
	 * Menu별 접근 권한 추가.
	 * @param mobAuthorityVOs
	 * @return Integer
	 * @throws EventException
	 */
	public Integer addAuth(MobAuthorityVO mobAuthorityVOs[]) throws EventException {
		Integer affectCount = null;

		try {
			int totalCount = 0;
			for (int i=0; i<mobAuthorityVOs.length; i++) {
				int count = menuAccessDBDAO.addAuth(mobAuthorityVOs[i]);
				totalCount = totalCount + count;
			}
			affectCount = Integer.valueOf(totalCount);
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		}

		return affectCount;
	}

	/**
	 * Menu별 접근 권한 삭제.
	 * @param mobAuthorityVOs
	 * @return Integer
	 * @throws EventException
	 */
	public Integer removeAuth(MobAuthorityVO mobAuthorityVOs[]) throws EventException {
		Integer affectCount = null;

		try {
			int totalCount = 0;
			for (int i=0; i<mobAuthorityVOs.length; i++) {
				int count = menuAccessDBDAO.removeAuth(mobAuthorityVOs[i]);
				totalCount = totalCount + count;
			}
			affectCount = Integer.valueOf(totalCount);
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		}

		return affectCount;
	}
}
