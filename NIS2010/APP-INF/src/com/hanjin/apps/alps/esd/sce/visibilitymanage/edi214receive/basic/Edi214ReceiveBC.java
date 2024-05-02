/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : Edi214ReceiveBC.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2008-08-01
*@LastModifier : yjlee
*@LastVersion : 1.0
* 2008-08-01 yjlee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.basic;

import com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.vo.SearchActualDateInfoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.syscommon.common.table.Edi214MsgVO;
/**
 * ENIS-SCEM EDI 214 Message
 * - ENIS-SCEM EDI 214 Message에 대한 비지니스 로직에 대한 인터페이스
 *
 * @author Yoonjung Lee
 * @see EsdSce085Event 참조
 * @since J2EE 1.4
 */
public interface Edi214ReceiveBC{
	
	/**
	 * EAI 로 넘어온 Message 를 분해하는 메소드.
	 * @param String inv
	 * @return SearchActualDateInfoVO
	 * @throws EventException
	 */
	public SearchActualDateInfoVO getEDI214DataFormat(String inv)throws EventException;

	/**
	 * 214 Message 를 분해하여 Temp table 에 Insert 한다.
	 * @param SearchActualDateInfoVO msgVO
	 * @throws EventException
	 */
	public void createEDI214TmpData(SearchActualDateInfoVO msgVO)throws EventException;
	//public void createEDI214TmpData(EventResponse evntRs)throws EventException;
	/**
	 * 214 로직에 의해 Message 의 Validation check 후 Update 한다.
	 * @param SearchActualDateInfoVO msgVO
	 * @throws EventException
	 */
	public void confirmEDI214(SearchActualDateInfoVO msgVO)throws EventException;
	//public void confirmEDI214(EventResponse evntRs)throws EventException;
	
}