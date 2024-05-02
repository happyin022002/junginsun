/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseTermBC.java
*@FileTitle : Agreement No. Selection
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.leaseterm.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MstLseTermVO;

/**
 * LeaseTerm Business Logic Command Interface<br>
 * @author
 * @see Ui_lse_0091EventResponse
 * @since J2EE 1.4
 */

public interface LeaseTermBC {

	/**
	 * retrieving for Lease Term<br>
	 *
	 * @return List<MstLseTermVO>
	 * @exception EventException
	 */
	public List<MstLseTermVO> searchLeaseTermComboItemBasic() throws EventException;
}