/*========================================================
*Copyright(c) 2009 CyberLogitec
*ProcessChain    : NPI
*@FileName       : BackEndJobSampleDBDAO.java
*@FileTitle      : NIS2010
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009. 4. 21.
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.sample.backendjob.workonremotelongtxserver.integration;

import java.sql.SQLException;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * It's BackEndJobSampleDBDAO.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2EE 1.5
 * 2009. 4. 21.
 */
public class BackEndJobSampleDBDAO extends DBDAOSupport{
	/**
	 * MDM Vandor 테이블의 값을 가져온다.
	 * @author Jeong-Hoon, KIM
	 * @return
	 * @throws DAOException 
	 * @throws SQLException 
	 */
	public DBRowSet searchMdmVandor() throws SQLException, DAOException{
		return new SQLExecuter().executeQuery(new BackEndJobSampleDAOMdmVandorRSQL(),null,null);
	}

}
