/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmSvcScopeTotalDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmSvcScpVO;
import com.hanjin.syscommon.common.table.MdmSvcScpLaneVO;
import com.hanjin.syscommon.common.table.MdmSvcScpLmtVO;
import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmSvcScpDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmSvcScpLaneDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmSvcScpLmtDBDAO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmSvcScpGeneralDBDAO extends DBDAOSupport{
	/**
	 * insert, update
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean addMdmSvcScopeTotal(MdmSvcScpVO vo1, Collection<MdmSvcScpLaneVO> vos2,  Collection<MdmSvcScpLmtVO> vos3) throws DAOException {

		ReceiveQueueMdmSvcScpDBDAO dbDao = new ReceiveQueueMdmSvcScpDBDAO();
		boolean isSuccessful = false; 
		//ReceiveQueueMdmSvcScpLaneDBDAO dbDao = new ReceiveQueueMdmSvcScpLaneDBDAO();
		//ReceiveQueueMdmSvcScpLmtDBDAO dbDao = new ReceiveQueueMdmSvcScpLmtDBDAO();
		//dbDao에서 있으면 넣어주고 없으면 안넣어준다.
		try {
				if(dbDao.searchMdmSvcScpList(vo1.getSvcScpCd())) {
					dbDao.addMdmSvcScp(vo1);
					addMdmSvcScpLane(vos2);
					addMdmSvcScpLmt(vos3);
				}  else {
					dbDao.modifyMdmSvcScp(vo1);
					addMdmSvcScpLane(vos2);
					addMdmSvcScpLmt(vos3);
				}
			isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
	
	/**
	 * insert,update
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean addMdmSvcScpLane( Collection<MdmSvcScpLaneVO> vos2) throws DAOException {
		ReceiveQueueMdmSvcScpLaneDBDAO dbDao2 = new ReceiveQueueMdmSvcScpLaneDBDAO();
		boolean isSuccessful = false; 
		Iterator iter = vos2.iterator();
		MdmSvcScpLaneVO vo2 = null;
		//ReceiveQueueMdmSvcScpLaneDBDAO dbDao = new ReceiveQueueMdmSvcScpLaneDBDAO();
		//ReceiveQueueMdmSvcScpLmtDBDAO dbDao = new ReceiveQueueMdmSvcScpLmtDBDAO();
		//dbDao에서 있으면 넣어주고 없으면 안넣어준다.
		try {
			while (iter.hasNext()){
				vo2 = (MdmSvcScpLaneVO)iter.next();
				if(dbDao2.searchMdmSvcScpLaneList(vo2.getSvcScpCd(), vo2.getVslSlanCd())) {
					dbDao2.addMdmSvcScpLane(vo2);
				}  else {
					dbDao2.modifyMdmSvcScpLane(vo2);
				}
			}
			isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
	
	/**
	 * insert, update
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean addMdmSvcScpLmt(Collection<MdmSvcScpLmtVO> vos3) throws DAOException {
		ReceiveQueueMdmSvcScpLmtDBDAO dbDao3 = new ReceiveQueueMdmSvcScpLmtDBDAO();
		boolean isSuccessful = false; 
		Iterator iter = vos3.iterator();
		MdmSvcScpLmtVO vo3 = null;
		//ReceiveQueueMdmSvcScpLaneDBDAO dbDao = new ReceiveQueueMdmSvcScpLaneDBDAO();
		//ReceiveQueueMdmSvcScpLmtDBDAO dbDao = new ReceiveQueueMdmSvcScpLmtDBDAO();
		//dbDao에서 있으면 넣어주고 없으면 안넣어준다.
		try {
			while (iter.hasNext()){
				vo3 = (MdmSvcScpLmtVO)iter.next();
				//String svc_scp_cd, String rgn_cd, String org_dest_cd
				if(dbDao3.searchMDMSVCSCPLMTList(vo3.getSvcScpCd(), vo3.getRgnCd(), vo3.getOrgDestCd())) {
					dbDao3.addMdmSvcScpLmt(vo3);
				}  else {
					dbDao3.modifyMdmSvcScpLmt(vo3);
				}
			}
			isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
	
	/**
	 * delete
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean removeMdmSvcScopeTotal(MdmSvcScpVO vo1, Collection<MdmSvcScpLaneVO> vos2,  Collection<MdmSvcScpLmtVO> vos3) throws DAOException{
		ReceiveQueueMdmSvcScpDBDAO dbDao = new ReceiveQueueMdmSvcScpDBDAO();
		boolean isSuccessful = false; 

		try {
				if(dbDao.searchMdmSvcScpList(vo1.getSvcScpCd())) {
					dbDao.removeMdmSvcScp(vo1);
				}
			isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}