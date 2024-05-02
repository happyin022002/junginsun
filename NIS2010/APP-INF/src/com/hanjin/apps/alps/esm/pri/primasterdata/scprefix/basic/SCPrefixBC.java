/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCPrefixBC.java
*@FileTitle : S/C Prefix Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.04.16 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.scprefix.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.scprefix.vo.PriScPfxMapgListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScPfxMapgVO;
import com.hanjin.syscommon.common.table.PriScPfxVO;

/**
 * NIS2010-Primasterdata Business Logic Command Interface<br>
 * - NIS2010-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Moon Dong Gyu
 * @see Ui_pri_0014EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCPrefixBC {

    /**
	 * S/C Prefix and Scope Mapping List 를 조회합니다.<br>
	 * 
	 * @param PriScPfxMapgVO priScPfxMapgVO
	 * @return List<PriScPfxMapgListVO>
	 * @exception EventException
	 */
	public List<PriScPfxMapgListVO> searchSCPrefixMappingList(PriScPfxMapgVO priScPfxMapgVO) throws EventException;

	/**
	 * S/C Prefix 를 조회합니다.<br>
	 * 
	 * @param PriScPfxVO priScPfxVO
	 * @return List<PriScPfxVO>
	 * @exception EventException
	 */
	public List<PriScPfxVO> searchSCPrefixList(PriScPfxVO priScPfxVO) throws EventException;

	/**
	 * S/C Prefix and Scope Mapping List 를 저장합니다.<br>
	 * 
	 * @param PriScPfxMapgVO[] priScPfxMapgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSCPrefixMapping(PriScPfxMapgVO[] priScPfxMapgVOs, SignOnUserAccount account) throws EventException;

	/**
	 * S/C Prefix 를 저장합니다.<br>
	 * 
	 * @param PriScPfxVO[] priScPfxVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSCPrefix(PriScPfxVO[] priScPfxVOs, SignOnUserAccount account) throws EventException;
	
    /**
     * S/C Prefix and Scope Mapping 에서 사용하는 Prefix 인지 여부를 조회합니다.<br>
     * 
     * @param PriScPfxVO[] priScPfxVOs
     * @return String
     * @exception EventException
     */
    public String searchUsedPrefix (PriScPfxVO[] priScPfxVOs) throws EventException;
}