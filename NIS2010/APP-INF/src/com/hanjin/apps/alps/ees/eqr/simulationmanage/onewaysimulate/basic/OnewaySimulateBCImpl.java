/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnewaySimulateBCImpl.java
*@FileTitle : OnewaySimulate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.14 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.basic.CntrRepoPlanOptiExecuteBackEndJob;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.integration.OnewaySimulateDBDAO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.vo.EesEqr0010ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.vo.EesEqr0010MutiVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-SimulationManage Business Logic Command Interface<br>
 * - ALPS-SimulationManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Chae Change Ho
 * @see 참조
 * @since J2EE 1.6
 */
public class OnewaySimulateBCImpl extends BasicCommandSupport implements OnewaySimulateBC {

	// Database Access Object
	private transient OnewaySimulateDBDAO dbDao = null;
//	private transient OnewaySimulateEAIDAO eaiDao=null;

	/**
	 * OnewaySimulateBCImpl 객체 생성<br>
	 * OnewaySimulateDBDAO를 생성한다.<br>
	 */
	public OnewaySimulateBCImpl() {
		dbDao = new OnewaySimulateDBDAO();
	//	eaiDao = new OnewaySimulateEAIDAO();
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO EesEqr0010ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTotalOneWayOfferExist(EesEqr0010ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchTotalOneWayOfferExist(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO EesEqr0010ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTotalOneWayOfferGap(EesEqr0010ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchTotalOneWayOfferGap(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO EesEqr0010ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTotalOneWayOfferMax(EesEqr0010ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchTotalOneWayOfferMax(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO EesEqr0010ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTotalOneWayOffer(EesEqr0010ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchTotalOneWayOffer(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * [EES_EQR_0011 : Turn Time 수정, 삭제]<br>
	 * 
	 * @param conditionVO EesEqr0010ConditionVO
	 * @param mutiVO EesEqr0010MutiVO[]
	 * @param new_repo_id  String
	 * @exception EventException
	 */
	public void modifyOneWayOffer( EesEqr0010ConditionVO conditionVO ,EesEqr0010MutiVO[] mutiVO, String new_repo_id) throws EventException{
		
		String repo_id_1 = new_repo_id; // 새로운 REPO_PLN_ID를 생성한다. 
		String repo_pln_Id = Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
		String[] tyszall = conditionVO.getCntrtpsztype().split(",");
		boolean maxCheck  = true  ;
		//int maxValue = 0;
		int maxGap   = 0;
		int dayCount = 0;
		List<String> volList 	 = null;
		//String[] volArr  = null;
    	int vol          = 0;    // type size별 vol 수량
    	int realVol       = 0;
        int realGapVol    = 0;
       
    	EesEqr0010MutiVO vo = null;
		
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			for(int i = 0 ; i < mutiVO.length ; i++){
				vo = (EesEqr0010MutiVO)mutiVO[i];
				volList  = vo.getVolList();
				 if(vo.getNumm().equals("2")){
					for (int k=0 ; k < tyszall.length ; k++)
					{
						vol    = Integer.parseInt((String)volList.get(k));// 볼륨
						dayCount = dbDao.searchDailyCount( conditionVO.getScnrId() , vo.getFcastYrwk(), vo.getFmEccCd() ,vo.getToEccCd() , tyszall[k]); //날짜 카운트 
						//maxValue = dbDao.searchDailyMax(conditionVO.getScnrId() , vo.getFcastYrwk(), vo.getFmEccCd() ,vo.getToEccCd() , tyszall[k] ,dayCount , vol); // Max value 가지고오 오키
						maxGap   = dbDao.searchDailyGap(conditionVO.getScnrId() , vo.getFcastYrwk(), vo.getFmEccCd() ,vo.getToEccCd() , tyszall[k] ,dayCount , vol); // 실제 값과 셋팅 값을 차이
			    	  
						if(!vo.getFcastYrwk().equals("")){
							param.put("scnr_id", conditionVO.getScnrId());
							param.put("fcast_yrwk", vo.getFcastYrwk());
							param.put("fm_ecc_cd", vo.getFmEccCd());
							param.put("to_ecc_cd", vo.getToEccCd());
							param.put("cntr_tpsz_cd", tyszall[k]);
							velParam.put("daycount", dayCount);
							velParam.put("vol", vol);
							
							CommonRsVO retrunVO = dbDao.earchOneWayOBFcst(param , velParam);
							DBRowSet rowSet		= retrunVO.getDbRowset();
							maxCheck = true;
		        	     	realVol  = 0;
		        	     	realGapVol = 0;
							 while(rowSet.next()){
								 param.put("repo_pln_id",repo_id_1);
								 param.put("fcast_yrwk", rowSet.getString("FCAST_YRWK"));
     		                     param.put("fm_ecc_cd" , rowSet.getString("FM_ECC_CD"));
     		                     param.put("to_ecc_cd" , rowSet.getString("TO_ECC_CD"));
     		                     param.put("cntr_tpsz_cd", rowSet.getString("CNTR_TPSZ_CD"));
     		                     if(maxCheck){
    		                    	if (realGapVol < 0){
    		                    		maxCheck = false;
    		                    		realVol  = rowSet.getInt("CNTR_QTY") + realGapVol;
    		                    		if(realVol < 0 ){
    		                    		   realGapVol = realVol;
    		                    		   realVol    = 0;
    		                    		   maxCheck   = true;
    		                    		}else{
    		                    		   maxCheck   = false;	
    		                    		}
    		                    	}else{
    		                    		maxCheck = false;
    		                    		realVol = rowSet.getInt("CNTR_QTY") + maxGap;
    		                    		 if (realVol < 0 ) {
    		                    	    	 realGapVol = realVol;
    		                    	    	 maxCheck = true;
    		                    	    	 realVol =0;
    		                    	       }else {
    		                    	    	    maxCheck = false;
    		                               }
    		                    	 }
    		                    	param.put("cntr_qty", realVol);	
     		                     } else {
     		                    	param.put("cntr_qty", rowSet.getInt("CNTR_QTY"));	
     		                     }
     		                    param.put("sim_pln_id", repo_pln_Id); 
     		                    param.put("crd_usr_id", conditionVO.getUserId());
     		                    param.put("upd_usr_id", conditionVO.getUserId());
    		                    param.put("fcast_del_yrwk", rowSet.getString("FCAST_DEL_YRWK"));
    		                    param.put("fcast_dt", rowSet.getString("FCAST_DEL_YRWK"));
    		     				dbDao.modifyOneWayOffer(param, velParam);
						    }
						}
					}
				}
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO EesEqr0010ConditionVO
	 * @exception EventException
	 */
	public void send0010ReRunSteve(EesEqr0010ConditionVO conditionVO) throws EventException {
		try {
			
			OnewaySimulateBackEndJob onewaySimulateBJ = new OnewaySimulateBackEndJob();
			
			/*
			 * 전달하는 파라메터로 String을 만든다. 
			 */
	    	//------------------------------------------------
			String sendStr = "";
			sendStr = sendStr + "oldScrnid"    + ":" + conditionVO.getScnrId() + "|";
			sendStr = sendStr + "new_repo_pln" + ":" + conditionVO.getNewRepoPlan() + "|";
			sendStr = sendStr + "sim_pln_id"   + ":" + Constants.REPO_WORD + conditionVO.getYyyyww() + Constants.REPO_WEEK + conditionVO.getSeq() + "|";
			sendStr = sendStr + "user_id"      + ":" + conditionVO.getUserId()+ "|";
			sendStr = sendStr + "run_id"       + ":" + conditionVO.getRunIdNo() + "|";
			sendStr = sendStr + "yyyyww"       + ":" + conditionVO.getYyyyww()+ "|";
			sendStr = sendStr + "scnrId"       + ":" + conditionVO.getScnrId() + "|";
			sendStr = sendStr + "uiname"       + ":" + "EES_EQR_0010";
			//------------------------------------------------
			onewaySimulateBJ.setParamString(sendStr);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String key = backEndJobManager.execute(onewaySimulateBJ, conditionVO.getUserId() ,"EQR_OPTIMIZATION_RUN");
	        log.debug("===호출 ID:" + key);
			//eaiDao.send0010ReRunSteve(conditionVO);
		}
//		catch(DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO EesEqr0010ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchOneWayPlanCompare(EesEqr0010ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchOneWayPlanCompare(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
}