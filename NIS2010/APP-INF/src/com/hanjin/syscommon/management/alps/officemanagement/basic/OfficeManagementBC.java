/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : OfficeManagementBC.java
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
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComOfcPgmMtchVO;
import com.hanjin.syscommon.management.alps.officemanagement.vo.OfficListVO;
import java.util.List;

/**
 * ALPS-Programmanagement Business Logic Command Interface<br>
 * - ALPS-Programmanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jung In Sun
 * @see Office_managementEventResponse 참조
 * @since J2EE 1.6
 */
 
public interface OfficeManagementBC
{
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param OfficListVO officlistvo
	 * @param String s
	 * @return List
	 * @exception EventException
	 */
    public abstract List comOfcPgmMtchSearch(OfficListVO officlistvo, String s)
        throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ComOfcPgmMtchVO[] acomofcpgmmtchvo
	 * @param SignOnUserAccount signonuseraccount
	 * @exception EventException
	 */
    public abstract void comOfcPgmMtchs(ComOfcPgmMtchVO acomofcpgmmtchvo[], SignOnUserAccount signonuseraccount)
        throws EventException;
}
