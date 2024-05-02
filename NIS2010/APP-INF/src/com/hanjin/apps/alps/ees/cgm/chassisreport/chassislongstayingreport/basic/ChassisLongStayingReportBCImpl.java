/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ChassisLongStayingReportBC.java
 *@FileTitle : Chassis Long Staying Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.07
 *@LastModifier : 이율규
 *@LastVersion : 1.0
 * 2015.04.07 이율규
 * 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.integration.ChassisLongStayingReportDBDAO;
import com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.vo.ChassisLongStayingVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * 
 * @author Lee, YulKyu
 * @param <ChassisLongStayingReportLandInvMonitoringDetailBackEndJob>
 * @see ees_cgm_1158EventResponse,ChassisLongStayingReportBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ChassisLongStayingReportBCImpl extends BasicCommandSupport
		implements ChassisLongStayingReportBC {

	// Database Access Object
	private transient ChassisLongStayingReportDBDAO dbDao = null;

	/**
	 * ChassisLongStayingReportBCImpl 객체 생성<br>
	 * ChassisLongStayingReportDBDAO 생성한다.<br>
	 */
	public ChassisLongStayingReportBCImpl() {
		dbDao = new ChassisLongStayingReportDBDAO();
	}

	/**
	 * [EES_CGM_1158] Detail 시작<br>
	 *
	 * @param ChassisLongStayingVO chassisLongStayingVO
	 * @return List<ChassisLongStayingVO>
	 */
	@Override
	public List<ChassisLongStayingVO> searchLongStayingChassisList(ChassisLongStayingVO chassisLongStayingVO)
			throws EventException {
		try {
			
			if("A".equals(chassisLongStayingVO.getCntrTpszCd())){
				chassisLongStayingVO.setCntrTpszCd("");
			}
			
			return dbDao.searchLongStayingChassisList(chassisLongStayingVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}