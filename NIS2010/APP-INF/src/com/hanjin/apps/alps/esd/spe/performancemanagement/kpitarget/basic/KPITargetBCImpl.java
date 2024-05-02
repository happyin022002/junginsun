/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPITargetBCImpl.java
*@FileTitle : KPI Target Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.basic;

import java.util.ArrayList;
import java.util.List;


import com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.integration.KPITargetDBDAO;
import com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.vo.KpiPerformanceTargetVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-PerformanceManagement Business Logic Command Interface<br>
 * - ALPS-PerformanceManagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */
public class KPITargetBCImpl extends BasicCommandSupport implements KPITargetBC {

	// Database Access Object
	private transient KPITargetDBDAO dbDao = null;

	/**
	 * KPITargetBCImpl 객체 생성<br>
	 * KPITargetDBDAO를 생성한다.<br>
	 */
	public KPITargetBCImpl() {
		dbDao = new KPITargetDBDAO();
	}
	

	
	/**
	 *  KPI Target 가중치 조회.<br>
	 * @param KpiPerformanceTargetVO KpiPerformanceTargetVO
	 * @return List<KpiPerformanceTargetVO>
	 */
	@Override
	public List<KpiPerformanceTargetVO> searchKpiPerformanceTarget(KpiPerformanceTargetVO KpiPerformanceTargetVO)throws EventException {
		try {
			return dbDao.searchKpiPerformanceTarget(KpiPerformanceTargetVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	
	/**
	  * Level3 목록 조회
	  * @param KpiPerformanceTargetVO
	  * @return List<KpiPerformanceTargetVO>
	 */	
	@Override
	public List<KpiPerformanceTargetVO> searchSpSvcCateKpi(KpiPerformanceTargetVO KpiPerformanceTargetVO) throws EventException{
		try {
			return dbDao.searchSpSvcCateKpi(KpiPerformanceTargetVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 *  KPI Target 가중치 입력/수정/삭제.<br>
	 * @param KpiPerformanceTargetVO[] kpiPerformanceTargetVOs
	 * @param SignOnUserAccount account
	 */	
	@Override
	public void multiKpiTargetCreation(KpiPerformanceTargetVO[] kpiPerformanceTargetVOs,SignOnUserAccount account) throws EventException {
		try {
			List<KpiPerformanceTargetVO> insertVoList = new ArrayList<KpiPerformanceTargetVO>();
			List<KpiPerformanceTargetVO> updateVoList = new ArrayList<KpiPerformanceTargetVO>();
			List<KpiPerformanceTargetVO> deleteVoList = new ArrayList<KpiPerformanceTargetVO>();
			for ( int i=0; i<kpiPerformanceTargetVOs .length; i++ ) {
				kpiPerformanceTargetVOs[i].setCreUsrId(account.getUsr_id());
				kpiPerformanceTargetVOs[i].setUpdUsrId(account.getUsr_id());
				if ( kpiPerformanceTargetVOs[i].getIbflag().equals("I")){
					insertVoList.add(kpiPerformanceTargetVOs[i]);
				} else if ( kpiPerformanceTargetVOs[i].getIbflag().equals("U")){
					updateVoList.add(kpiPerformanceTargetVOs[i]);
				} else if ( kpiPerformanceTargetVOs[i].getIbflag().equals("D")){
					deleteVoList.add(kpiPerformanceTargetVOs[i]);
				}
			}
			
			// 삭제 -> insert 순.
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiSpeGrpKpiTargetCreation(deleteVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.modifymultiSpeGrpKpiTargetCreation(insertVoList);
				//dbDao.addmultiSpeGrpKpiTargetCreation(insertVoList);
				
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpeGrpKpiTargetCreation(updateVoList);
				
			}
			
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}