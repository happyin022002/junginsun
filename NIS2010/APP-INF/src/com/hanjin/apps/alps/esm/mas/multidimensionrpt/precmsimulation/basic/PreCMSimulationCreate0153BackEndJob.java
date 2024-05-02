/*=========================================================

*Copyright(c) 2012 CyberLogitec
*@FileName : PreCMSimulationCreate0153BackEndJob.java
*@FileTitle : Pre CM/OP 화면 Backandjob로 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.20
*@LastModifier : 김종준
*@LastVersion : 1.0
* 1.0 Creation
*--------------------------------------------------------
* 2012.08.03 전윤주 [CHM-201216347] [MAS] ACM 프로젝트 연동 변경 작업
*                 기존 AGT JAVA 소스를 호출하던 부분을 ACM 프로시져 호출로 변경함
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.basic;

//import com.hanjin.apps.alps.esm.agt.agtcalculation.agtcalctomas.basic.AGTCalcToMasBC;
//import com.hanjin.apps.alps.esm.agt.agtcalculation.agtcalctomas.basic.AGTCalcToMasBCImpl;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.MultiDimensionRPTSC;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.integration.PreCMSimulationDBDAO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo.SearchCondition0153VO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * - Pre CM/OP 에 대한 BackEndJob<br>
 *
 * @author KIM JONGJUN
 * @see MultiDimensionRPTSC
 * @since J2EE 1.6
 */
public class PreCMSimulationCreate0153BackEndJob  extends BackEndCommandSupport{

	private static final long serialVersionUID = 7869461307221308362L;
	
	private transient PreCMSimulationDBDAO dbDao = new PreCMSimulationDBDAO();
	
	private SearchCondition0153VO searchCondition0153VO;
	
	private PreCMSimulationBCImpl  pCSImpl= new PreCMSimulationBCImpl();
	
	private SignOnUserAccount account;
	
	/**
	 * BackEndJob  조회조건을 셋팅한다. <br>
	 *  
	 * @param SearchCondition0153VO searchCondition0153VO
	 * @param SignOnUserAccount account
	 * @exception
	 */	
	public void setMasCreate0153Vo(SearchCondition0153VO searchCondition0153VO,SignOnUserAccount account) {
		this.searchCondition0153VO = searchCondition0153VO;
		this.account = account;
	}
	
	/**
	 * BackEndJob 실행 <br>
	 *  
	 * @return SearchCondition0153VO
	 * @exception Exception
	 */	
	@Override
	public SearchCondition0153VO doStart() throws Exception {
		try {
			createPreCMSimulation();
			searchCondition0153VO.setErrorCode("00000");
			searchCondition0153VO.setErrMsg("Completed!");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return searchCondition0153VO;
	}

	
	/**
	 * Pre CM/OP 화면 Backandjob로 조회 <br>
	 *  
	 * @return SearchCondition0153VO
	 * @exception Exception
	 */	
	public SearchCondition0153VO createPreCMSimulation() throws Exception {
		SearchCondition0153VO result = new SearchCondition0153VO();
		String msg = "";
		try {
			msg = dbDao.createCostAssignPreCM(searchCondition0153VO);
			log.info("\n### createCostAssignPreCM msg =" + msg);
			String cost_yrmon = pCSImpl.searchBzcCostYrmon();
			searchCondition0153VO.setFCostYrmon(cost_yrmon);
			log.info("\n### COST_YRMON="+cost_yrmon);
			msg = dbDao.createTrsAgmtApplyToMas(searchCondition0153VO);
			log.info("\n### TRS msg= " +msg);
			msg = dbDao.createTesMasRate(searchCondition0153VO);
			log.info("\n### TES msg= " +msg);
			msg = dbDao.createMasCostPkgMainPreCMAvg(searchCondition0153VO);
			log.info("\n### MASPKG msg= " +msg);
			msg = dbDao.createMasCostPkgPreCMAbcStp(searchCondition0153VO);
			log.info("\n### MAS ABC msg= " +msg);
			
			log.info("\n### AGT start");
			msg = dbDao.createAcmAplyOtrCommToMas(searchCondition0153VO);
			log.info("\n### AGT end");
			
			
			//AGTCalcToMasBC agtCalcToMasBC = new AGTCalcToMasBCImpl();
			//agtCalcToMasBC.createCMComm(JSPUtil.getNull(searchCondition0153VO.getFPctlNo()));
				

			msg = dbDao.createMasCostPkgMainComTtl(searchCondition0153VO);
			log.info("\n### TTL msg=" + msg);
			  
        	result.setErrorCode("00000");
        	result.setErrMsg("Completed!");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return result;
	}
}
