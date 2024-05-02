/*========================================================
*Copyright(c) 2009 CyberLogitec
*ProcessChain    : NPI
*@FileName       : SampleBCImpl.java
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

import java.sql.SQLException;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.sample.backendjob.workonremotelongtxserver.integration.BackEndJobSampleDBDAO;

/** It's SampleBCImpl.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2EE 1.5
 * Aug 12, 2009
 */
public class WorkOnRemoteLongTxServerSampleBCImpl extends BasicCommandSupport implements WorkOnRemoteLongTxServerSampleBC {


	/**
	 * BackEndjobWorkOnLongTxRemoteServerWork 를 시작한다.
	 * @throws EventException 
	 */
	@Override
	public String getBackEndjobWorkOnLongTxRemoteServerWork(String usrId) throws EventException {
		BackEndJobSampleDBDAO backEndJobSampleDBDAO = new BackEndJobSampleDBDAO();
		DBRowSet rowSet = null;
		String returnTotalCountMdmVandors = "";
		try {
			rowSet = backEndJobSampleDBDAO.searchMdmVandor();
			returnTotalCountMdmVandors = String.valueOf(rowSet.getRowCount());
		} catch (SQLException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}

		return returnTotalCountMdmVandors;
	}

}
