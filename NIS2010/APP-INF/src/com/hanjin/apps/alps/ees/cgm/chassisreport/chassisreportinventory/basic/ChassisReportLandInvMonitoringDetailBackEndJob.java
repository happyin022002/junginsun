/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChassisReportLandInvMonitoringDetailBackEndJob
*@FileTitle : ChassisReportLandInvMonitoringDetailBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.02
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2014.07.02 Chang Young Kim
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
 * @see EES_CGM_1157 EventResponse, ChassisReportLandInvMonitoringDetailBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ChassisReportLandInvMonitoringDetailBackEndJob extends BackEndCommandSupport {
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
			List<LandInvMonitoringVO> allLandInvMonitoringVO = new ArrayList<LandInvMonitoringVO>();
			String[] arrMvmtSts = null;
			String strMtSts = null;
			
			// ALL로 넘어오면 아무값도 안넘김
			if (bLandInvMonitoringVO.getCntrTpszCd().equals("A")) {
				bLandInvMonitoringVO.setCntrTpszCd("");
			}
			
			
			List<LandInvMonitoringVO> resultLandInvMonitoringVOS = new ArrayList<LandInvMonitoringVO>();
			
			if(bLandInvMonitoringVO.getHdnPopYn().equals("Y")) {
				
				if (bLandInvMonitoringVO.getHdnFinished().length() > 0) {
					bLandInvMonitoringVO.setFinishCd(bLandInvMonitoringVO.getHdnFinished());
				}
				
				//Click한 Summary Tab의 Hdn_mvmt_sts_cd에 대하여 Query조회 후 VO에 담기
				strMtSts = bLandInvMonitoringVO.getHdnMvmtStsCd();
				
				bLandInvMonitoringVO.setMvmtStsCd(strMtSts);
				
				resultLandInvMonitoringVOS = dbDao.searchLandInvMonitoringDetail(bLandInvMonitoringVO);
				
				allLandInvMonitoringVO.addAll(resultLandInvMonitoringVOS);
				
			} else {
				
				//MVMT Status 갯수만큼 Query조회 후 VO에 담기
				arrMvmtSts = bLandInvMonitoringVO.getMvmtStsCd().split(",");
				
				for (int i=0; i<arrMvmtSts.length; i++) {
					
					bLandInvMonitoringVO.setMvmtStsCd(arrMvmtSts[i]);
					
					resultLandInvMonitoringVOS = dbDao.searchLandInvMonitoringDetail(bLandInvMonitoringVO);
					
					allLandInvMonitoringVO.addAll(resultLandInvMonitoringVOS);
				}
			}
			
			return allLandInvMonitoringVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}