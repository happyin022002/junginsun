/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OrganizationBCImpl.java
*@FileTitle : Office Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.24 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.organization.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.organization.integration.OrganizationDBDAO;
import com.hanjin.apps.alps.esm.pri.primasterdata.organization.vo.MdmOrzVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-PRIMasterData Business Logic Command Interface<br>
 * - ALPS-PRIMasterData에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_4023EventResponse,OrganizationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class OrganizationBCImpl extends BasicCommandSupport implements OrganizationBC {

	// Database Access Object
	private transient OrganizationDBDAO dbDao = null;

	/**
	 * OrganizationBCImpl 객체 생성<br>
	 * OrganizationDBDAO를 생성한다.<br>
	 */
	public OrganizationBCImpl() {
		dbDao = new OrganizationDBDAO();
	}
	/**
	 * Office Code List를 조회합니다. <br>
	 * 
	 * @param MdmOrzVO mdmOrzVO
	 * @return List<MdmOrzVO>
	 * @exception EventException
	 */
	public List<MdmOrzVO> searchOrganizationList(MdmOrzVO mdmOrzVO) throws EventException {
		try {
			return dbDao.searchOrganizationList(mdmOrzVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
}