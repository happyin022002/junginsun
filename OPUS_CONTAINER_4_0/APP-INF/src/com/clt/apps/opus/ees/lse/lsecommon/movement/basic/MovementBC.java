/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MovementBC.java
*@FileTitle : Container Movement Status Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.08.10 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.movement.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MdmMvmtStsVO;

/**
 * Movement Business Logic Command Interface<br>
 * Movement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Jun-Woo
 * @see UI_LSE_0057EventResponse 참조
 * @since J2EE 1.6
 */

public interface MovementBC {

	/**
	 * Container Movement Status 코드목록을 조회합니다.<br>
	 *  
	 * @return List<MdmMvmtStsVO>
	 * @exception EventException
	 */
	public List<MdmMvmtStsVO> searchContainerMovementStatusListBasic() throws EventException;
}