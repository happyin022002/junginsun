/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StandardWordingBC.java
*@FileTitle : Standard Wording for S/C Notes
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.standardwording.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriScStndWdgVO;

/**
 * Primasterdata Business Logic Command Interface<br>
 * - Handling a biz logic about Primasterdat<br>
 *
 * @author 
 * @see Esm_pri_0085EventResponse 
 * @since J2EE 1.4
 */

public interface StandardWordingBC {

    /**
	 * Retrieving Standard Wording for S/C Notes .<br>
	 * 
	 * @param PriScStndWdgVO priScStndWdgVO
	 * @return List<PriScStndWdgVO>
	 * @exception EventException
	 */
	public List<PriScStndWdgVO> searchStandardWordingList(PriScStndWdgVO priScStndWdgVO) throws EventException;

	/**
	 * Saving Standard Wording for S/C Notes.<br>
	 * 
	 * @param PriScStndWdgVO[] priScStndWdgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageStandardWording(PriScStndWdgVO[] priScStndWdgVO,SignOnUserAccount account) throws EventException;
}