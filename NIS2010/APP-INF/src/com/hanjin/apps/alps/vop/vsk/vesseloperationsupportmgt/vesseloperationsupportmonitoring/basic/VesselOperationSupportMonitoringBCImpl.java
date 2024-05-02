/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselOperationSupportMonitoringBCImpl.java
*@FileTitle : VOSI Update Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.10 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmRhqComboVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.integration.VesselOperationSupportMonitoringDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo.VosiUpdateMonitoringVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo.VosiUpdateMonitoringConditionVO;

/**
 * ALPS-VesselOperationSupportMgt Business Logic Basic Command implementation<br>
 * - ALPS-VesselOperationSupportMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Jong Ock
 * @see VOP_VSK_0517EventResponse,VesselOperationSupportMonitoringBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class VesselOperationSupportMonitoringBCImpl extends BasicCommandSupport implements VesselOperationSupportMonitoringBC {

	// Database Access Object
	private transient VesselOperationSupportMonitoringDBDAO dbDao = null;

	/**
	 * VesselOperationSupportMonitoringBCImpl 객체 생성<br>
	 * VesselOperationSupportMonitoringDBDAO를 생성한다.<br>
	 */
	public VesselOperationSupportMonitoringBCImpl() {
		dbDao = new VesselOperationSupportMonitoringDBDAO();
	}
	/**
	 *  VOSI Update Monitoring 을 조회 합니다.<br>
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
	 * 조회조건에 Port Code 유효성 체크 및 해당 Rhq을 조회 합니다.<br>
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