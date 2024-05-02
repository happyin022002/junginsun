/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StandardWordingBC.java
*@FileTitle : Standard Wording for S/C Notes
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.13 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.standardwording.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScStndWdgVO;

/**
 * NIS2010-Primasterdata Business Logic Command Interface<br>
 * - NIS2010-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Moon Dong Gyu
 * @see Esm_pri_0085EventResponse 참조
 * @since J2EE 1.4
 */

public interface StandardWordingBC {

    /**
	 * Standard Wording for S/C Notes 를 조회합니다.<br>
	 * 
	 * @param PriScStndWdgVO priScStndWdgVO
	 * @return List<PriScStndWdgVO>
	 * @exception EventException
	 */
	public List<PriScStndWdgVO> searchStandardWordingList(PriScStndWdgVO priScStndWdgVO) throws EventException;

	/**
	 * Standard Wording for S/C Notes 를 저장합니다.<br>
	 * 
	 * @param PriScStndWdgVO[] priScStndWdgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageStandardWording(PriScStndWdgVO[] priScStndWdgVO,SignOnUserAccount account) throws EventException;
}