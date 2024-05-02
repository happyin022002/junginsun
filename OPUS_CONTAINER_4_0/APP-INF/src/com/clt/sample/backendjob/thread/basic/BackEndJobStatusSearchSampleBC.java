/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsingTimerBC.java
*@FileTitle : BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 김정훈
*@LastVersion : 1.0
* 2009.09.14 김정훈
* 1.0 Creation
=========================================================*/
package com.clt.sample.backendjob.thread.basic;

import com.clt.framework.core.layer.event.EventException;

/**
 * 
 * ALPS-Backendjob Business Logic Command Interface<br>
 * - ALPS-Backendjob에 대한 비지니스 로직에 대한 인터페이스<br>
 * BackEndJobStatusSearchSampleBC.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2016. 1. 11.
 */
public interface BackEndJobStatusSearchSampleBC {

	/**
	 * 
	 * ComBakEndJbVO
	 * @author Jeong-Hoon, KIM
	 * @param object
	 * @return
	 * @throws EventException String
	 */
	public String comBakEndJbVO(String object) throws EventException;
}