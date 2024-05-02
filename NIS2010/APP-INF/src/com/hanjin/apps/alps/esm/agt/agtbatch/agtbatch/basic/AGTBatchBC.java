/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : AGTBatchBC.java
*@FileTitle : Closing Basic Command
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-31
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-31 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtbatch.agtbatch.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * eNIS-AGT Business Logic Command Interface<br>
 * - eNIS-AGT에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hwang GyeongNam
 * @see ESM_AGT_BatchEventResponse 참조
 * @since J2EE 1.4
 */
public interface AGTBatchBC  {
	
	/**
	 * AGT Commission 추정 결산 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse ESM_AGT_BatchEventResponse
	 * @exception EventException
	 */
	public EventResponse processAGTBatchBC(Event e) throws EventException;
	
}