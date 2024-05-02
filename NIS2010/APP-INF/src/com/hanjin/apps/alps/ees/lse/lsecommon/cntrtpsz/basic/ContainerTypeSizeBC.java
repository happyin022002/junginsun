/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrTpSzBC.java
*@FileTitle : Container Type/Size Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.cntrtpsz.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;

/**
 * NIS2010-CntrTpSz Business Logic Command Interface<br>
 * - NIS2010-CntrTpSz에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Nho Jung Yong
 * @see
 * @since J2EE 1.4
 */

public interface ContainerTypeSizeBC {

	/**
	 * 조회 이벤트 처리<br>
	 * Container Type/Size에 대한 조회 이벤트 처리<br>
	 *
	 * @return List<MdmCntrTpSzVO>
	 * @exception EventException
	 */
	public List<MdmCntrTpSzVO> searchCntrTpSzListBasic() throws EventException;

	/**
	 * Container Type Size의 가변적 Header를 조회합니다.<br>
	 *
	 * @return String
	 * @exception EventException
	 */
	public String searchContainerTypeSizeDynamicHeaderBasic() throws EventException;
}