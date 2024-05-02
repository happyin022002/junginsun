/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChassisReportLandInvMonitoringBackEndJob
*@FileTitle : ChassisReportLandInvMonitoringBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.18
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.04.18 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.integration.ChassisReportDBDAO;
import com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.vo.LandInvMonitoringVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * @author Choi, Duk-Woo
 * @see EES_CGM_1157 EventResponse, ChassisReportLandInvMonitoringBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ChassisReportLandInvMonitoringBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318313L;

	private LandInvMonitoringVO landInvMonitoringVO;
	// Database Access Object
	private ChassisReportDBDAO dbDao = new ChassisReportDBDAO();

	/**
	 * 데이터 세팅
	 *
	 * @param LandInvMonitoringVO landInvMonitoringVO
	 */
	public void setLandInvMonitoringVO(LandInvMonitoringVO landInvMonitoringVO) {
		this.landInvMonitoringVO = landInvMonitoringVO;
	}

	/**
	 * Back End Job Result
	 * @return List<LandInvMonitoringVO>
	 * @throws Exception
	 */
	public List<LandInvMonitoringVO> doStart() throws Exception {
		try {
			LandInvMonitoringVO bLandInvMonitoringVO = this.landInvMonitoringVO;
			
			// ALL로 넘어오면 아무값도 안넘김
			if (bLandInvMonitoringVO.getCntrTpszCd().equals("A")) {
				bLandInvMonitoringVO.setCntrTpszCd("");
			}
			
			List<LandInvMonitoringVO> allLandInvMonitoringVO = new ArrayList<LandInvMonitoringVO>();
			
			//MVMT Status 갯수만큼 Query조회 후 VO에 담기
			String[] mvmtSts = bLandInvMonitoringVO.getMvmtStsCd().split(",");
			
			for (int i=0; i<mvmtSts.length; i++) {
				List<LandInvMonitoringVO> resultLandInvMonitoringVOS = new ArrayList<LandInvMonitoringVO>();
				
				bLandInvMonitoringVO.setMvmtStsCd(mvmtSts[i]);
				
				resultLandInvMonitoringVOS = dbDao.searchLandInvMonitoringSummary(bLandInvMonitoringVO);
				
				allLandInvMonitoringVO.addAll(resultLandInvMonitoringVOS);
			}
			return allLandInvMonitoringVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}