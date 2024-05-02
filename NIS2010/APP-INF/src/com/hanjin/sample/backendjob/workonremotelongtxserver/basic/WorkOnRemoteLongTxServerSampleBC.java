/*========================================================
*Copyright(c) 2009 CyberLogitec
*ProcessChain    : NPI
*@FileName       : SampleBC.java
*@FileTitle      : NIS2010
*Open Issues     :
*Change history  :
*@LastModifyDate : Aug 12, 2009
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
/**
 * 
 */
package com.hanjin.sample.backendjob.workonremotelongtxserver.basic;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.basic.BasicCommand;
import com.hanjin.framework.core.layer.event.EventException;

/** It's SampleBC.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2EE 1.5
 * Aug 12, 2009
 */
public interface WorkOnRemoteLongTxServerSampleBC extends BasicCommand{

	/**This method 
	 * @author Jeong-Hoon, KIM
	 * @param sampleBackEndBCImpl
	 * @param usrId
	 * @param string
	 * @throws EventException 
	 */
	public String getBackEndjobWorkOnLongTxRemoteServerWork(String usrId) throws EventException;
}
