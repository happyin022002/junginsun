/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseTermBC.java
*@FileTitle : Agreement No. Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.leaseterm.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.MstLseTermVO;

/**
 * NIS2010-LeaseTerm Business Logic Command Interface<br>
 * - NIS2010-LeaseTerm에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Nho Jung Yong
 * @see Ui_lse_0091EventResponse 참조
 * @since J2EE 1.4
 */

public interface LeaseTermBC {

	/**
	 * 조회 이벤트 처리<br>
	 * Lease Term에 대한 조회 이벤트 처리<br>
	 *
	 * @return List<MstLseTermVO>
	 * @exception EventException
	 */
	public List<MstLseTermVO> searchLeaseTermComboItemBasic() throws EventException;
}