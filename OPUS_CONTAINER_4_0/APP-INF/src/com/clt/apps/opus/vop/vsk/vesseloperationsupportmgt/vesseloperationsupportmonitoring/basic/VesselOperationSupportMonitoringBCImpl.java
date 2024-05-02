/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselOperationSupportMonitoringBCImpl.java
*@FileTitle : VOSI Update Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmRhqComboVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.integration.VesselOperationSupportMonitoringDBDAO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo.VosiUpdateMonitoringConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo.VosiUpdateMonitoringVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * VesselOperationSupportMgt Business Logic Basic Command implementation<br>
 * - Handling business logic of VesselOperationSupportMgt<br>
 *
 * @author 
 * @see VOP_VSK_0517EventResponse,VesselOperationSupportMonitoringBC, DAO
 * @since J2EE 1.6
 */
public class VesselOperationSupportMonitoringBCImpl extends BasicCommandSupport implements VesselOperationSupportMonitoringBC {

	// Database Access Object
	private transient VesselOperationSupportMonitoringDBDAO dbDao = null;

	/**
	 * VesselOperationSupportMonitoringBCImpl object creation<br>
	 * Creating VesselOperationSupportMonitoringDBDAO<br>
	 */
	public VesselOperationSupportMonitoringBCImpl() {
		dbDao = new VesselOperationSupportMonitoringDBDAO();
	}
	/**
	 * Retrieving VOSI Update Monitoring
	 * 
	 * @param VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO
	 * @return List<VosiUpdateMonitoringVO>
	 * @exception EventException
	 */
	public List<VosiUpdateMonitoringVO> searchVOSIUpdateList(VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO) throws EventException {
		try {
			return dbDao.searchVOSIUpdateList(vosiUpdateMonitoringConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"VOSI Update Monitoring"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"VOSI Update Monitoring"}).getMessage(), ex);
		}
	}
	
	/**
	 * Checking Port Code and Retrieving RHQ
	 * 
	 * @param VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO
	 * @return List<MdmRhqComboVO>
	 * @exception EventException
	 */
	public List<MdmRhqComboVO> searchMdmRhqCombo(VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO) throws EventException {
		try {
			return dbDao.searchMdmRhqCombo(vosiUpdateMonitoringConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
		}
	}	
}