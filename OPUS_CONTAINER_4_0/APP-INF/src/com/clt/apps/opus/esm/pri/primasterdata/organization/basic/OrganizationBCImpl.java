/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OrganizationBCImpl.java
*@FileTitle : Office Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.organization.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.organization.integration.OrganizationDBDAO;
import com.clt.apps.opus.esm.pri.primasterdata.organization.vo.MdmOrzVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * PRIMasterData Business Logic Command Interface<br>
 *
 * @author
 * @see Esm_pri_4023EventResponse,OrganizationBC - refer to each DAO clas
 * @since J2EE 1.6
 */
public class OrganizationBCImpl extends BasicCommandSupport implements OrganizationBC {

	// Database Access Object
	private transient OrganizationDBDAO dbDao = null;

	/**
	 * Creating OrganizationBCImpl object<br>
	 * Creating OrganizationDBDAO<br>
	 */
	public OrganizationBCImpl() {
		dbDao = new OrganizationDBDAO();
	}
	/**
	 * Retrieving Office Code List <br>
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