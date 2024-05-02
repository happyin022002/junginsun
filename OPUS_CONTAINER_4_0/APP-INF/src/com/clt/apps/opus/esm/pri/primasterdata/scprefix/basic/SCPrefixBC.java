/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCPrefixBC.java
*@FileTitle : S/C Prefix Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.scprefix.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.scprefix.vo.PriScPfxMapgListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriScPfxMapgVO;
import com.clt.syscommon.common.table.PriScPfxVO;

/**
 * Primasterdata Business Logic Command Interface<br>
 * - Handling a biz logic about Primaster data<br>
 *
 * @author 
 * @see Ui_pri_0014EventResponse 
 * @since J2EE 1.4
 */

public interface SCPrefixBC {

    /**
	 * Retrieving S/C Prefix and Scope Mapping List .<br>
	 * 
	 * @param PriScPfxMapgVO priScPfxMapgVO
	 * @return List<PriScPfxMapgListVO>
	 * @exception EventException
	 */
	public List<PriScPfxMapgListVO> searchSCPrefixMappingList(PriScPfxMapgVO priScPfxMapgVO) throws EventException;

	/**
	 * Retrieving S/C Prefix.<br>
	 * 
	 * @param PriScPfxVO priScPfxVO
	 * @return List<PriScPfxVO>
	 * @exception EventException
	 */
	public List<PriScPfxVO> searchSCPrefixList(PriScPfxVO priScPfxVO) throws EventException;

	/**
	 * Saving S/C Prefix and Scope Mapping List.<br>
	 * 
	 * @param PriScPfxMapgVO[] priScPfxMapgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSCPrefixMapping(PriScPfxMapgVO[] priScPfxMapgVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Saving S/C Prefix<br>
	 * 
	 * @param PriScPfxVO[] priScPfxVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSCPrefix(PriScPfxVO[] priScPfxVOs, SignOnUserAccount account) throws EventException;
	
    /**
     * Retrieving whether the prfix is in use at S/C Prefix and Scope Mapping <br>
     * 
     * @param PriScPfxVO[] priScPfxVOs
     * @return String
     * @exception EventException
     */
    public String searchUsedPrefix (PriScPfxVO[] priScPfxVOs) throws EventException;
}