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
* 2012.08.03 전윤주 [CHM-201216347] [COA] ACM 프로젝트 연동 변경 작업
*                 기존 AGT JAVA 소스를 호출하던 부분을 ACM 프로시져 호출로 변경함
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.basic;

//import com.hanjin.apps.alps.esm.agt.agtcalculation.agtcalctocoa.basic.AGTCalcToCoaBC;
//import com.hanjin.apps.alps.esm.agt.agtcalculation.agtcalctocoa.basic.AGTCalcToCoaBCImpl;
import java.util.List;

import com.clt.apps.opus.esm.coa.multidimensionrpt.MultiDimensionRPTSC;
import com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.integration.PreCMSimulationDBDAO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtInVO;
//import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.PriSimRoutInfoVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * - Pre CM/OP 에 대한 BackEndJob<br>
 *
 * @author KIM JONGJUN
 * @see MultiDimensionRPTSC
 * @since J2EE 1.6
 */
public class PreCMSimulationCreateBackEndJob  extends BackEndCommandSupport{

	private static final long serialVersionUID = 7869461307221308362L;
	
	private transient PreCMSimulationDBDAO dbDao = new PreCMSimulationDBDAO();
	
	private AplyRtInVO aplyRtInVO;
	
//	private PreCMSimulationBCImpl  pCSImpl= new PreCMSimulationBCImpl();
	
	private SignOnUserAccount account;
	
	/**
	 * BackEndJob  조회조건을 셋팅한다. <br>
	 *  
	 * @param AplyRtInVO aplyRtInVO
	 * @param String jobCommand
	 * @param SignOnUserAccount account
	 * @exception
	 */	
	public void setAplyRtInVO(AplyRtInVO aplyRtInVO,SignOnUserAccount account) {
		this.aplyRtInVO = aplyRtInVO;
		this.account = account;
	}
	
	/**
	 * BackEndJob 실행 <br>
	 *  
	 * @return SearchCondition0153VO
	 * @exception Exception
	 */	
	@Override
	public AplyRtInVO doStart() throws Exception {
		try {
			createPreCMSimulation();
			aplyRtInVO.setErrorCode("00000");
			aplyRtInVO.setErrorMsg("Completed!");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return aplyRtInVO;
	}

	
	/**
	 * Pre CM/OP 화면 Backandjob로 조회 <br>
	 *  
	 * @return SearchCondition0153VO
	 * @exception Exception
	 */	
	public AplyRtInVO createPreCMSimulation() throws Exception {
		AplyRtInVO result = new AplyRtInVO();
		aplyRtInVO.setFUserId(account.getUsr_id());
		String msg = "";
		try {
//			List<AplyRtInVO> list = dbDao.searchPctlNo(aplyRtInVO);
//			if(list.size()>0){
//			for(int i=0; i<list.size(); i++){
//					aplyRtInVO.setPctlNo(aplyRtInVO.getPctlNo());
					
					msg = dbDao.createCostAssignPreCM(aplyRtInVO);
					log.info("\n### createCostAssignPreCM msg =" + msg);
					String cost_yrmon = dbDao.searchBzcCostYrmon();
					aplyRtInVO.setFCostYrmon(cost_yrmon);
					log.info("\n### COST_YRMON="+cost_yrmon);
					msg = dbDao.createTrsAgmtApplyToCoa(aplyRtInVO);
					log.info("\n### TRS msg= " +msg);
					msg = dbDao.createTesCoaRate(aplyRtInVO);
					log.info("\n### TES msg= " +msg);
					msg = dbDao.createCoaCostPkgMainPreCMAvg(aplyRtInVO);
					log.info("\n### COAPKG msg= " +msg);
					
					log.info("\n### AGT start");
					msg = dbDao.createAcmAplyOtrCommToCoa(aplyRtInVO);
					log.info("\n### AGT end");
					
					
					//AGTCalcToCoaBC agtCalcToCoaBC = new AGTCalcToCoaBCImpl();
					//agtCalcToCoaBC.createCMComm(JSPUtil.getNull(searchCondition0153VO.getFPctlNo()));
						
		
					msg = dbDao.createCoaCostPkgMainComTtl(aplyRtInVO);
					log.info("\n### TTL msg=" + msg);
//				}
//			}
			  
        	result.setErrorCode("00000");
        	result.setErrorMsg("Completed!");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return result;
	}
}
