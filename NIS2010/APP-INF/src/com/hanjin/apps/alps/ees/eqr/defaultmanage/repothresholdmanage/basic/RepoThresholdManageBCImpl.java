/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RepoThresholdManageBCImpl.java
*@FileTitle : Red Light Alert 기준 조회/수정---이송 계획 Input Data
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-20
*@LastModifier : chung eun ho
*@LastVersion : 1.0
* 2009-07-20 chung eun ho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.integration.RepoThresholdManageDBDAO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.vo.RepoThresholdManageRsVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.vo.SearchRepoPlanRLAThresholdVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrInpDatRedLgtAltVO;
import com.hanjin.syscommon.common.table.EqrObFcastRedLgtAltVO;
import com.hanjin.syscommon.common.table.EqrRepoExePlnFbExptVO;
import com.hanjin.syscommon.common.table.EqrRepoExePlnFbVO;
import com.hanjin.syscommon.common.table.EqrRepoPlnRedLgtAltDtlVO;
import com.hanjin.syscommon.common.table.EqrRepoPlnRedLgtAltMstVO;



/**
 * ALPS-RepoThresholdManage Business Logic Basic Command implementation<br>
 * - ALPS-RepoThresholdManage에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jungran yang
 * @see RepoThresholdManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class RepoThresholdManageBCImpl extends BasicCommandSupport implements RepoThresholdManageBC {

	// Database Access Object
	private transient RepoThresholdManageDBDAO dbDao=null;

	/**
	 * RepoThresholdManageBCImpl 객체 생성<br>
	 * RepoThresholdManageDBDAO를 생성한다.<br>
	 */
	public RepoThresholdManageBCImpl(){
		dbDao = new RepoThresholdManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RepoThresholdManage화면에 대한 조회 이벤트 처리<br>
	 *  
	 * @return RepoThresholdManageRsVO
	 * @exception EventException
	 */
	public RepoThresholdManageRsVO searchCntrRepoPlanInputDataRLAThreshold() throws EventException {
		
		RepoThresholdManageRsVO retVO=null;
		
		try {

			retVO=dbDao.searchCntrRepoPlanInputDataRLAThreshold();

			return retVO;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * EES_EQR_001 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param vos EqrInpDatRedLgtAltVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void multiCntrRepoPlanInputDataRLAThreshold(EqrInpDatRedLgtAltVO[] vos , SignOnUserAccount account) throws EventException{

		boolean isUpdate = false ;
		try {
			List updtModels = new ArrayList();
			String user_id = account.getUsr_id();
			for(int i = 0 ; i < vos.length ; i++){
				EqrInpDatRedLgtAltVO vo = vos[i];
				if(vo.getIbflag() == null){
					vo.setIbflag("");
				}
				if(vo.getIbflag().equals("U")){ //항상 여기만 간다.
					isUpdate = true ;

				    // RCC_CD
					String rccCd[] = {"USNYC","DEHAM","SGSIN","KRSEL","CNHKG","CNSHA","JPTYO","TWTPE"};
				    
				    // Alt_cost_amt
				    String[] costAmt = new String[rccCd.length];
				    costAmt[0] = vo.getAltCostAmtUsnyc();
				    costAmt[1] = vo.getAltCostAmtDeham();
				    costAmt[2] = vo.getAltCostAmtSgsin();
				    costAmt[3] = vo.getAltCostAmtKrsel();
				    costAmt[4] = vo.getAltCostAmtCnhkg();
				    costAmt[5] = vo.getAltCostAmtCnsha();
				    costAmt[6] = vo.getAltCostAmtJptyo();
				    costAmt[7] = vo.getAltCostAmtTwtpe();
				    
				    // Alt_bse_cd
				    String[] bseCd = new String[rccCd.length];
				    bseCd[0] = vo.getAltBseCdUsnyc();
				    bseCd[1] = vo.getAltBseCdDeham();
				    bseCd[2] = vo.getAltBseCdSgsin();
				    bseCd[3] = vo.getAltBseCdKrsel();
				    bseCd[4] = vo.getAltBseCdCnhkg();
				    bseCd[5] = vo.getAltBseCdCnsha();
				    bseCd[6] = vo.getAltBseCdJptyo();
				    bseCd[7] = vo.getAltBseCdTwtpe();
				    for( int j = 0; j < 8; j++ ){

						HashMap<String, String> param = new HashMap<String, String>();//vo.getColumnValues();
						param.put("user_id", user_id); 
						param.put("alt_cost_amt", costAmt[j]);
						param.put("alt_bse_cd", bseCd[j]);
						param.put("rcc_cd", rccCd[j]);
						param.put("alt_itm_div_cd", vo.getAltItmDivCd());
						param.put("cntr_sz_cd", vo.getCntrSzCd());
						updtModels.add(param);
				    }
				}
			}
			if(isUpdate){
				dbDao.multiCntrRepoPlanInputDataRLAThreshold(updtModels);
			}
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Red Light Alert 기준 조회/수정---컨테이너 이송 계획 조회 이벤트 처리<br>
	 * 
	 * @return List<SearchRepoPlanRLAThresholdVO>
	 * @exception EventException
	 */
	public List<SearchRepoPlanRLAThresholdVO> searchCntrRepoPlanRLAThreshold() throws EventException {
		try {
			return dbDao.searchCntrRepoPlanRLAThreshold();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Red Light Alert 기준 조회/수정---컨테이너 이송 계획 조회 이벤트 처리<br>
	 * 
	 * @param rccCd String
	 * @param tpsz String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrRepoPlanRLADTLThreshold(String rccCd, String tpsz) throws EventException {
		try {
			return dbDao.searchCntrRepoPlanRLADTLThreshold(rccCd, tpsz);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Red Light Alert 기준 조회/수정---컨테이너 이송 계획 멀티 이벤트 처리<br>
	 * 
	 * @param eqrRepoPlnRedLgtAltMstVOs EqrRepoPlnRedLgtAltMstVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCntrRepoPlanRLAThreshold(EqrRepoPlnRedLgtAltMstVO[] eqrRepoPlnRedLgtAltMstVOs,SignOnUserAccount account) throws EventException {
		try {
			List<EqrRepoPlnRedLgtAltMstVO> updateVoList = new ArrayList<EqrRepoPlnRedLgtAltMstVO>();
			
			for ( int i=0; i<eqrRepoPlnRedLgtAltMstVOs .length; i++ ) {
				if ( eqrRepoPlnRedLgtAltMstVOs[i].getIbflag().equals("U")){
					eqrRepoPlnRedLgtAltMstVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrRepoPlnRedLgtAltMstVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCntrRepoPlanRLAThreshold(updateVoList);
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
	 * Red Light Alert 기준 조회/수정---컨테이너 이송 계획 멀티 이벤트 처리<br>
	 * 
	 * @param eqrRepoPlnRedLgtAltDtlVOs EqrRepoPlnRedLgtAltDtlVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCntrRepoPlanRLADTLThreshold(EqrRepoPlnRedLgtAltDtlVO[] eqrRepoPlnRedLgtAltDtlVOs,SignOnUserAccount account) throws EventException {
		try {
			List<EqrRepoPlnRedLgtAltDtlVO> updateVoList = new ArrayList<EqrRepoPlnRedLgtAltDtlVO>();
			
			for ( int i=0; i<eqrRepoPlnRedLgtAltDtlVOs .length; i++ ) {
				if ( eqrRepoPlnRedLgtAltDtlVOs[i].getIbflag().equals("U")){
					eqrRepoPlnRedLgtAltDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrRepoPlnRedLgtAltDtlVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCntrRepoPlanRLADTLThreshold(updateVoList);
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
	 * 실행 계획 Feedback 기준 설정 조회 이벤트 처리<br>
	 * 
	 * @param tpsz String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchExecutionFeedback(String tpsz) throws EventException {
		try {
			CommonRsVO returnVO = new CommonRsVO();
			List<DBRowSet> rsList = new ArrayList<DBRowSet>();
			
			CommonRsVO rsVO1 = dbDao.searchExecutionFeedback(tpsz);
			CommonRsVO rsVO2 = dbDao.searchExecutionFeedbackExpt(tpsz);
			
			rsList.add(rsVO1.getDbRowset());
			rsList.add(rsVO2.getDbRowset());
			
			returnVO.setRsList(rsList);
			
			return returnVO;
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 실행 계획 Feedback 기준 설정 멀티 이벤트 처리<br>
	 * 
	 * @param eqrRepoExePlnFbVOs EqrRepoExePlnFbVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiExecutionFeedback(EqrRepoExePlnFbVO[] eqrRepoExePlnFbVOs,SignOnUserAccount account) throws EventException {
		try {
			List<EqrRepoExePlnFbVO> updateMainVoList = new ArrayList<EqrRepoExePlnFbVO>();
			List<EqrRepoExePlnFbVO> deleteMainVoList = new ArrayList<EqrRepoExePlnFbVO>();
			List<EqrRepoExePlnFbVO> deleteSubVoList = new ArrayList<EqrRepoExePlnFbVO>();
			
			for ( int i=0; i<eqrRepoExePlnFbVOs .length; i++ ) {
				if ( eqrRepoExePlnFbVOs[i].getIbflag().equals("U")){
					eqrRepoExePlnFbVOs[i].setUpdUsrId(account.getUsr_id());
					
					if(!eqrRepoExePlnFbVOs[i].getOldBseCd().equals(eqrRepoExePlnFbVOs[i].getFbItmBseCd())){
						deleteSubVoList.add(eqrRepoExePlnFbVOs[i]);
						deleteMainVoList.add(eqrRepoExePlnFbVOs[i]);
					} else {
						updateMainVoList.add(eqrRepoExePlnFbVOs[i]);
					}
				}
			}
			
			if ( deleteSubVoList.size() > 0 ) {
				dbDao.deleteExecutionFeedBackExpt(deleteSubVoList, "Y");
			}
			if ( deleteMainVoList.size() > 0 ) {
				dbDao.mergeSubExecutionFeedBack(deleteMainVoList);
			}
			if ( updateMainVoList.size() > 0 ) {
				dbDao.mergeExecutionFeedBack(updateMainVoList);
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
	 * 실행 계획 Feedback 기준 설정 멀티 이벤트 처리<br>
	 * 
	 * @param eqrRepoExePlnFbExptVOs EqrRepoExePlnFbExptVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiExecutionFeedbackExpt(EqrRepoExePlnFbExptVO[] eqrRepoExePlnFbExptVOs,SignOnUserAccount account) throws EventException {
		try {
			List<EqrRepoExePlnFbExptVO> updateVoList = new ArrayList<EqrRepoExePlnFbExptVO>();
			List<EqrRepoExePlnFbExptVO> deleteVoList = new ArrayList<EqrRepoExePlnFbExptVO>();
			
			for ( int i=0; i<eqrRepoExePlnFbExptVOs .length; i++ ) {
				if ( eqrRepoExePlnFbExptVOs[i].getIbflag().equals("U") || eqrRepoExePlnFbExptVOs[i].getIbflag().equals("I")){
					eqrRepoExePlnFbExptVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrRepoExePlnFbExptVOs[i]);
				} else if (eqrRepoExePlnFbExptVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(eqrRepoExePlnFbExptVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.mergeExecutionFeedBackExpt(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteExecutionFeedBackExpt(deleteVoList, "N");
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
	 * Red Light Alert 기준 조회/수정---컨테이너 수급 예측 조회 이벤트 처리<br>
	 * 
	 * @param tpsz String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrForecastRLAThreshold(String tpsz) throws EventException {
		try {
			return dbDao.searchCntrForecastRLAThreshold(tpsz);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Red Light Alert 기준 조회/수정---컨테이너 수급 예측 수정 이벤트 처리<br>
	 * 
	 * @param eqrObFcastRedLgtAltVOs EqrObFcastRedLgtAltVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCntrForecastRLAThreshold(EqrObFcastRedLgtAltVO[] eqrObFcastRedLgtAltVOs,SignOnUserAccount account) throws EventException {
		try {
			List<EqrObFcastRedLgtAltVO> insertVoList = new ArrayList<EqrObFcastRedLgtAltVO>();
			List<EqrObFcastRedLgtAltVO> updateVoList1 = new ArrayList<EqrObFcastRedLgtAltVO>();
			List<EqrObFcastRedLgtAltVO> updateVoList2 = new ArrayList<EqrObFcastRedLgtAltVO>();
			
			for ( int i=0; i<eqrObFcastRedLgtAltVOs .length; i++ ) {
				if ( eqrObFcastRedLgtAltVOs[i].getIbflag().equals("U")){
					eqrObFcastRedLgtAltVOs[i].setUpdUsrId(account.getUsr_id());
					
					DBRowSet resultRs = dbDao.checkCntrFcstRLSThreshold(eqrObFcastRedLgtAltVOs[i]).getDbRowset();
					boolean checkResult = false;
					if (resultRs.next()) {
						if (resultRs.getInt("coun") == 0) {
							checkResult = true;
						}
					}
					
					if (checkResult) {
						if ("Ratio".equals(eqrObFcastRedLgtAltVOs[i].getType2())) {
							eqrObFcastRedLgtAltVOs[i].setRlaRto(eqrObFcastRedLgtAltVOs[i].getRlaQty());
							eqrObFcastRedLgtAltVOs[i].setRlaQty("0");
						} else {
							eqrObFcastRedLgtAltVOs[i].setRlaRto("0");
							eqrObFcastRedLgtAltVOs[i].setRlaQty(eqrObFcastRedLgtAltVOs[i].getRlaQty());
						}
						
						insertVoList.add(eqrObFcastRedLgtAltVOs[i]);
						
					} else {
						if ("Ratio".equals(eqrObFcastRedLgtAltVOs[i].getType2())) {
							updateVoList1.add(eqrObFcastRedLgtAltVOs[i]);
						} else {
							updateVoList2.add(eqrObFcastRedLgtAltVOs[i]);
						}
					}
					
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.insertCntrFcstRLSThreshold(insertVoList);
			}
			if ( updateVoList1.size() > 0 ) {
				dbDao.updateCntrFcstRLSThresholdRatio(updateVoList1);
			}
			if ( updateVoList2.size() > 0 ) {
				dbDao.updateCntrFcstRLSThresholdVol(updateVoList2);
			}

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
}