/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : OfficeManagementBCImpl.java
*@FileTitle : Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.07.02 정인선
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.management.alps.officemanagement.basic;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComOfcPgmMtchVO;
import com.hanjin.syscommon.management.alps.officemanagement.integration.OfficeManagementDBDAO;
import com.hanjin.syscommon.management.alps.officemanagement.vo.OfficListVO;
import java.util.List;

/**
 * ALPS-ProgramManagement Business Logic Basic Command implementation<br>
 * - ALPS-ProgramManagement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jung In Sun
 * @see Office_ManagementEventResponse,OfficeManagementBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
 
public class OfficeManagementBCImpl extends BasicCommandSupport
    implements OfficeManagementBC
{

/**
	 * OfficeManagementBCImpl 객체 생성<br>
	 * OfficeManagementDBDAO를 생성한다.<br>
	 */
    public OfficeManagementBCImpl()
    {
        dbDao = null;
        dbDao = new OfficeManagementDBDAO();
    }

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param OfficListVO officListVO
	 * @param String pgm_no
	 * @return List
	 * @exception EventException
	 */
    public List comOfcPgmMtchSearch(OfficListVO officListVO, String pgm_no)
        throws EventException
    {
        try
        {
            return dbDao.comOfcPgmMtchSearch(officListVO, pgm_no);
        }
        catch(DAOException ex)
        {
            throw new EventException(ex.getMessage(), ex);
        }
        catch(Exception ex)
        {
            throw new EventException(ex.getMessage(), ex);
        }
    }

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ComOfcPgmMtchVO comOfcPgmMtchVO[]
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void comOfcPgmMtchs(ComOfcPgmMtchVO comOfcPgmMtchVO[], SignOnUserAccount account)
        throws EventException
    {
        try
        {
            dbDao.multiOfcPgmMtchs(comOfcPgmMtchVO, account);
        }
        catch(DAOException ex)
        {
            throw new EventException(ex.getMessage(), ex);
        }
        catch(Exception ex)
        {
            throw new EventException(ex.getMessage(), ex);
        }
    }

    private transient OfficeManagementDBDAO dbDao;
}
