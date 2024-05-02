/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanSensitivityAnalysisBCImpl.java
*@FileTitle : 민감도 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.18 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.basic;

import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.integration.CntrRepoPlanSensitivityAnalysisDBDAO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0065ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0088ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0065MultiVO;


/**
 * ALPS-CntrRepoPlanSensitivityAnalysis Business Logic Command Interface<br>
 * - ALPS-CntrRepoPlanSensitivityAnalysis에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Chae Change Ho
 * @see EventResponse 참조
 * @since J2EE 1.6
 */
public class CntrRepoPlanSensitivityAnalysisBCImpl extends BasicCommandSupport implements CntrRepoPlanSensitivityAnalysisBC {

	// Database Access Object
	private transient CntrRepoPlanSensitivityAnalysisDBDAO dbDao = null;
	//private transient CntrRepoPlanSensitivityAnalysisEAIDAO eaiDao = null;
    

	/**
	 * CntrRepoPlanSensitivityAnalysisBCImpl 객체 생성<br>
	 * CntrRepoPlanSensitivityAnalysisDBDAO를 생성한다.<br>
	 */
	public CntrRepoPlanSensitivityAnalysisBCImpl() {
		dbDao = new CntrRepoPlanSensitivityAnalysisDBDAO();
	//	eaiDao = new CntrRepoPlanSensitivityAnalysisEAIDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoPlanSensitivityAnalysis화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditonVO EesEqr0065ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchPlanSensitivity(EesEqr0065ConditionVO conditonVO) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try {
			return dbDao.searchPlanSensitivity(conditonVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoPlanSensitivityAnalysis화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param mutiVO EesEqr0065MultiVO[]
	 * @param conditonVO EesEqr0065ConditionVO
	 * @param old_sncr_id String
	 * @exception EventException
	 */
	public void modifyPlanSensitivity(EesEqr0065MultiVO[] mutiVO ,EesEqr0065ConditionVO conditonVO ,String old_sncr_id) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try {
			 dbDao.modifyPlanSensitivity(mutiVO ,conditonVO , old_sncr_id);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoPlanSensitivityAnalysis화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditonVO EesEqr0065ConditionVO
	 * @exception EventException
	 */
	public void send0065ReRunSteve(EesEqr0065ConditionVO conditonVO) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try {
			CntrRepoPlanSensitivityAnalysisBackEndJob cntrRepoPlanSensitivityAnalysisBJ = new CntrRepoPlanSensitivityAnalysisBackEndJob();
			
			/*
			 * 전달하는 파라메터로 String을 만든다. 
			 */
	    	//------------------------------------------------
			String sendStr = "";
			sendStr = sendStr + "oldScrnid"  + ":" + conditonVO.getScnrid()   + "|";  // 시나리오 아이디 
			sendStr = sendStr + "sim_pln_id" + ":" + Constants.REPO_WORD+conditonVO.getYyyyww()+Constants.REPO_WEEK+conditonVO.getSeq() + "|"; 
			sendStr = sendStr + "user_id"    + ":" + conditonVO.getUserId()  + "|";
			sendStr = sendStr + "yyyyww"     + ":" + conditonVO.getYyyyww()   + "|";
			sendStr = sendStr + "sens"       + ":" + conditonVO.getSens()     + "|";
			sendStr = sendStr + "cost_code"  + ":" + conditonVO.getCostobj()  + "|";
			sendStr = sendStr + "run_id_no"  + ":" + conditonVO.getRunId()    + "|";
			sendStr = sendStr + "limit_code" + ":" + conditonVO.getLimitobj();
			//------------------------------------------------
			cntrRepoPlanSensitivityAnalysisBJ.setParamString(sendStr);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String key = backEndJobManager.execute(cntrRepoPlanSensitivityAnalysisBJ, conditonVO.getUserId() ,"EQR_SENSITIVITT_RERUN");
	        log.debug("===호출 ID:" + key);

			// eaiDao.send0065ReRunSteve(conditonVO);
		}
//		catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		} 
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoPlanSensitivityAnalysis화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditonVO EesEqr0088ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchPlanSensitivityCompare(EesEqr0088ConditionVO conditonVO) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try {
			return dbDao.searchPlanSensitivityCompare(conditonVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoPlanSensitivityAnalysis화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditonVO EesEqr0088ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchUnitCostSensitivityCompare(EesEqr0088ConditionVO conditonVO) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try {
			return dbDao.searchUnitCostSensitivityCompare(conditonVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoPlanSensitivityAnalysis화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditonVO EesEqr0088ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchRepoPlanType(EesEqr0088ConditionVO conditonVO) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try {
			return dbDao.searchRepoPlanType(conditonVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}