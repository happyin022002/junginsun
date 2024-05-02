/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPIPerformanceBCImpl.java
*@FileTitle : KPI Performance Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.integration.KPIPerformanceDBDAO;
import com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.vo.KpiPerformanceVO;
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
public class KPIPerformanceBCImpl extends BasicCommandSupport implements KPIPerformanceBC {

	// Database Access Object
	private transient KPIPerformanceDBDAO dbDao = null;

	/**
	 * KPIPerformanceBCImpl 객체 생성<br>
	 * KPIPerformanceDBDAO를 생성한다.<br>
	 */
	public KPIPerformanceBCImpl() {
		dbDao = new KPIPerformanceDBDAO();
	}


	/**
	 * KPI Performance 내용 조회
	 * @param KpiPerformanceVO kpiPerformanceVO
	 * @param SignOnUserAccount account
	 * @return List<KpiPerformanceVO>
	 */
	public List<KpiPerformanceVO> searchKpiPerformanceCfm(KpiPerformanceVO kpiPerformanceVO,SignOnUserAccount account) throws EventException{
		try {
			kpiPerformanceVO.setCreUsrId(account.getUsr_id());
			return dbDao.searchKpiPerformanceCfm(kpiPerformanceVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * KPI Performance Confirm 을 저장 수정한다.
	 * @param KpiPerformanceVO[] kpiPerformanceVOs
	 * @param SignOnUserAccount account
	 */
	public void multiKpiPerformanceCfm(KpiPerformanceVO[] kpiPerformanceVOs, SignOnUserAccount account)  throws EventException{
		try {
			if(null != kpiPerformanceVOs){

			
				for(int i=0;i<kpiPerformanceVOs.length;i++){
					kpiPerformanceVOs[i].setCreUsrId(account.getUsr_id());				 
					kpiPerformanceVOs[i].setUpdUsrId(account.getUsr_id());
					// 로직상 Ibflag는 u 만 존재 하게 된다.
					if(kpiPerformanceVOs[i].getIbflag().equals("U")){
						if(kpiPerformanceVOs[i].getHasSaved().equals("Y")){ // 저장된 데이터 UPDATE 해야한다.
							dbDao.modifyKpiPerformanceCfm(kpiPerformanceVOs[i]);  // KPI Performance 수정	
							
						}else{// 신규 데이터 INSERT 해야한다.
							dbDao.addKpiPerformanceCfm(kpiPerformanceVOs[i]);  // KPI Performance 저장	
							
						}
						
					}
				 }
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