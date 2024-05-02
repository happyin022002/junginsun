/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanKpiAnalysisBCImpl.java
*@FileTitle : 컨테이너 이송 계획 KPI 요약 조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           			modifier date    explanation
* 1		1.0			Se-Hoon Park				2006-11-01		1.0 최초 생성
* 2     1.0      	Lee Byoung Hun				2009.09.16		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.09.16
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.integration.CntrRepoPlanKpiAnalysisDBDAO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.EesEqr0071ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.EesEqr0072ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.EesEqr0074ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.EesEqr0136ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.GetForecastedSeaInventoryVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.SearchCntrPlanKPISummaryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-CntrRepoPlanKpiAnalysis Business Logic Command Interface<br>
 * - ALPS-CntrRepoPlanKpiAnalysis 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see	EventResponse 참조
 * @since J2EE 1.6
 */
public class CntrRepoPlanKpiAnalysisBCImpl extends BasicCommandSupport implements CntrRepoPlanKpiAnalysisBC {

	// Database Access Object
	private transient CntrRepoPlanKpiAnalysisDBDAO dbDao = null;

	/**
	 * CntrRepoPlanKpiAnalysisBCImpl 객체 생성<br>
	 * CntrRepoPlanKpiAnalysisDBDAO를 생성한다.<br>
	 */
	public CntrRepoPlanKpiAnalysisBCImpl() {
		dbDao = new CntrRepoPlanKpiAnalysisDBDAO();
	}
	
	/**
	 * 컨테이너 이송 계획 KPI 요약 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0071ConditionVO 
	 * @return List<SearchCntrPlanKPISummaryVO>
	 * @exception EventException
	 */
	public List<SearchCntrPlanKPISummaryVO> searchCntrRepoPlanKPISummary(EesEqr0071ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchCntrRepoPlanKPISummary(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Forecasted M/B 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0136ConditionVO	
	 * @return List<GetForecastedSeaInventoryVO>
	 * @exception EventException
	 */
	public List<GetForecastedSeaInventoryVO> searchForecastedSeaInventory(EesEqr0136ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchForecastedSeaInventory(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * KpiAnalysisLoadFactor화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditonVO EesEqr0074ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchKpiAnalysisLoadFactorInfo(EesEqr0074ConditionVO conditonVO) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try {
			
			// EES_EQR_0074 하나의 화면에서 각각 다른 조건으로 조회 하므로 여기에서 dao를 분기시켜서 호출함.
	        
        	if(conditonVO.getReport().equals("L")) { //Report : Load Factor
        		return dbDao.searchKPILoadFactor(conditonVO);
    		}
        	else  { //Report :Vessel Utilization
        		return dbDao.searchKPIVesselUtilization(conditonVO);
        	}
			//return dbDao.searchRepoPlanType(conditonVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 정보 조회 <br>
	 * CntrRepoPlanKpiAnalysis화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditonVO EesEqr0072ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchForecastedMatchBackInfo(EesEqr0072ConditionVO conditonVO) throws EventException {
		
		try {
			return dbDao.searchForecastedMatchBackInfo(conditonVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
    
}