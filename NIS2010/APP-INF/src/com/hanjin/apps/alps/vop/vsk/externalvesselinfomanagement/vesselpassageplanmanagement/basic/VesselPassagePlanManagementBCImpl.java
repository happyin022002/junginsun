/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : VesselPassagePlanManagementBC.java
 *@FileTitle : Passage Plan Receive from VMS
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015-04-20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.04.20
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.basic;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.integration.VesselPassagePlanManagementDBDAO;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.vo.PassagePlanDtVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration.ProformaScheduleMgtDBDAOCheckYardRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
//import com.hanjin.apps.gnoss.webservice.common.jmssync.jmsreceive.integration.ReceiveQueueVMSDBDAO;
//import com.hanjin.apps.gnoss.webservice.common.jmssync.jmsreceive.vo.HomCertificationVO;
//import com.hanjin.apps.gnoss.webservice.common.jmssync.jmsreceive.vo.HomVslCertiVO;
//import com.hanjin.irep.web.VMS0030001Document;
//import com.hanjin.irep.web.VMS0030001Document.VMS0030001;

/**
 * VMS JMS Consuming에 따른 JMS Inbound Class<br> -
 *  VMS0030001 에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Myoung Sin Park
 * @see ReceiveQueueBC,VMS0030001Document 참조
 * @since J2EE 1.4
 */
public class VesselPassagePlanManagementBCImpl extends BasicCommandSupport implements VesselPassagePlanManagementBC {
	
	private transient VesselPassagePlanManagementDBDAO dbDao = null;
	
	/** ReceiveQueueMDM_CUSTBCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public VesselPassagePlanManagementBCImpl() {
		dbDao = new VesselPassagePlanManagementDBDAO();
	}

	

	
	/**
	 * Create or update passage plan data.<br>
	 * 
	 * @param PassagePlanDtVO passagePlanDtVO
	 * @exception EventException
	 */
	public void managePassagePlan(PassagePlanDtVO passagePlanDtVO) throws EventException {
		try {
			int		checkCnt	= 0;
			
			if(passagePlanDtVO != null){
				checkCnt = dbDao.checkPassagePlan(passagePlanDtVO);
				if(checkCnt == 0){
					dbDao.insertPassagePlan(passagePlanDtVO);
					
				}else if(checkCnt > 0){
					dbDao.updatePassagePlan(passagePlanDtVO);

				}
				

			}
			
			
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("COM12192", new String[] { "Passage Plan I/F Log" }).getMessage(), e);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("COM12192", new String[] { "Passage Plan I/F Log" }).getMessage(), e);
		}
	}
	
	
	

}
