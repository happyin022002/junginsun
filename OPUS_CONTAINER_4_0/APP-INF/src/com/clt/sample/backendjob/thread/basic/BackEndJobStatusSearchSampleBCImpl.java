/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsingTimerBCImpl.java
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

import java.sql.SQLException;

import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * 
 * ALPS-BackEndJob Business Logic Command Interface<br>
 * - ALPS-BackEndJob에 대한 비지니스 로직에 대한 인터페이스<br>
 * BackEndJobStatusSearchSampleBCImpl.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2016. 1. 11.
 */
public class BackEndJobStatusSearchSampleBCImpl extends BasicCommandSupport implements BackEndJobStatusSearchSampleBC{

	/**
	 * 
	 * comBakEndJbVO
	 * @author Jeong-Hoon, KIM
	 * @param key
	 * @return
	 * @throws EventException String
	 */
	public String comBakEndJbVO(String key) throws EventException {

		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}

	}

}