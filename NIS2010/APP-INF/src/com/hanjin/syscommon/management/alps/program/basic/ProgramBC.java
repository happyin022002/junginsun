/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProgramBC.java
*@FileTitle : Program Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.02.17
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2009.02.17 김경범
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.program.basic;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComProgramVO;
import com.hanjin.syscommon.management.alps.program.vo.ComProgramSearchVO;


/**
 * NIS2010-Programmanagement Business Logic Command Interface<br>
 * - NIS2010-Programmanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KyungBum Kim
 * @see ProgrammanagementEventResponse 참조
 * @since J2EE 1.4
 */

public interface ProgramBC {
	/**
	 * 조회 이벤트 처리<br>
	 * Program화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ComProgramVO comprogramvo
	 * @return ComProgramSearchVO[]
	 * @exception EventException
	 */
	public ComProgramSearchVO[] searchProgramList(ComProgramVO comprogramvo) throws EventException;
	/**
	 * 멀티 이벤트 처리<br>
	 * Program 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param ComProgramVO[] comprogramvos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiComProgramVO(ComProgramVO[] comprogramvos, SignOnUserAccount account) throws EventException;
}