/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanManageBCImpl.java
*@FileTitle : managing CNTR repo plan
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.eqr.common.Constants;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.integration.CommonDBDAO;
import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration.CntrRepoExecutionPlanEstablishDBDAO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration.CntrRepoPlanManageDBDAO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0045ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0048ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0048MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0051ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0052ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0052MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0054ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0129ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.GetRepoPlanListVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrOnHireApprovalVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrRepoInOutPlanLaneVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrRepoInOutPlanVVDVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchTSGuidelineVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.EqrAddPlnVO;
import com.clt.syscommon.common.table.EqrInlndTrspPlnQtyVO;
import com.clt.syscommon.common.table.EqrInlndTrspPlnVO;
import com.clt.syscommon.common.table.EqrOnfHirPlnQtyVO;
import com.clt.syscommon.common.table.EqrOnfHirPlnVO;
import com.clt.syscommon.common.table.EqrVslLodgDchgPlnQtyVO;
import com.clt.syscommon.common.table.EqrVslLodgDchgPlnVO;

/**
 * -CntrRepoPlanManage Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see EES_EQR_0045EventResponse,CntrRepoPlanManageBC
 * @since J2EE 1.6
 */
public class CntrRepoPlanManageBCImpl extends BasicCommandSupport implements CntrRepoPlanManageBC {

	// Database Access Object
	private transient CntrRepoPlanManageDBDAO dbDao = null;

	/**
	 * creating CntrRepoPlanManageBCImpl<br>
	 * creating CntrRepoPlanManageDBDAO<br>
	 */
	public CntrRepoPlanManageBCImpl() {
		dbDao = new CntrRepoPlanManageDBDAO();
	}
	
	/**
	 * retrieving for CNTR repo plan<br>
	 * 
	 * @param conditionVO EesEqr0045ConditionVO
	 * @return List<GetRepoPlanListVO>
	 * @exception EventException
	 */
	public List<GetRepoPlanListVO> searchRepoPlanList(EesEqr0045ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchRepoPlanList(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * creating new CNTR repo plan id<br>
	 * call EQR_COPY_REPO_PLAN_PRC 
	 * 
	 * @param conditionVO EesEqr0045ConditionVO
	 * @param usrId String
	 * @exception EventException
	 */
	public void createNewRepoPlanID(EesEqr0045ConditionVO conditionVO, String usrId) throws EventException {
		try {
			dbDao.createNewRepoPlanID(conditionVO, usrId); // call EQR_COPY_REPO_PLAN_PRC 
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * removing CNTR repo plan id<br>
	 * 
	 * @param conditionVO EesEqr0045ConditionVO
	 * @exception EventException
	 */
	public void removeRepoPlanID(EesEqr0045ConditionVO conditionVO) throws EventException {
		try {
			dbDao.removeRepoPlanID(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * retrieving for forecasted land inventory<br>
	 * 
	 * @param conditionVO EesEqr0051ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchForecastedLandInventory(EesEqr0051ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchForecastedLandInventory(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * saving forecasted land inventory<br>
	 * 
	 * @param eqrAddPlnVOS EqrAddPlnVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyForecastedLandInventory(EqrAddPlnVO[] eqrAddPlnVOS, SignOnUserAccount account) throws EventException {
		try {
			List<EqrAddPlnVO> updateVoList = new ArrayList<EqrAddPlnVO>();
			
			for ( int i=0; i<eqrAddPlnVOS .length; i++ ) {
				if ( eqrAddPlnVOS[i].getIbflag().equals("U")){
					eqrAddPlnVOS[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrAddPlnVOS[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyForecastedLandInventory(updateVoList);
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
	 * retrieving for Distribution forecasted land inventory<br>
	 * 
	 * @param conditionVO EesEqr0051ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDtrbForecastedLandInventory(EesEqr0051ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchDtrbForecastedLandInventory(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Distribution  forecasted land inventory<br>
	 * 
	 * @param conditionVO EesEqr0051ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void dtrbForecastedLandInventory(EesEqr0051ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyForecastLandInvDistributeRepoPln(conditionVO, account);
			dbDao.modifyForecastLandInvDistributeScnrMst(conditionVO, account);
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * retriving for CNTR repo InOut plan <br>
	 * 
	 * @param conditionVO EesEqr0052ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrRepoInOutPlanDtInfo(EesEqr0052ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchCntrRepoInOutPlanDtInfo(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * retriving for CNTR repo InOut plan lane info<br>
	 * 
	 * @param conditionVO EesEqr0052ConditionVO
	 * @return List<SearchCntrRepoInOutPlanLaneVO>
	 * @exception EventException
	 */
	public List<SearchCntrRepoInOutPlanLaneVO> searchCntrRepoInOutPlanLaneInfo(EesEqr0052ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchCntrRepoInOutPlanLaneInfo(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * retriving for CNTR repo InOut plan VVD info<br>
	 * 
	 * @param conditionVO EesEqr0052ConditionVO
	 * @return List<SearchCntrRepoInOutPlanVVDVO>
	 * @exception EventException
	 */
	public List<SearchCntrRepoInOutPlanVVDVO> searchCntrRepoInOutPlanVvdInfo(EesEqr0052ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchCntrRepoInOutPlanVvdInfo(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * saving CNTR repo InOut plan info<br>
	 * 
	 * @param eesEqr0052MultiVOS EesEqr0052MultiVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyCntrRepoInOutPlanDtInfo(EesEqr0052MultiVO[] eesEqr0052MultiVOS, String usrId) throws EventException {
		
		try {
			EqrVslLodgDchgPlnVO eqrVslLodgDchgPlnVO = null;
			EqrVslLodgDchgPlnQtyVO eqrVslLodgDchgPlnQtyVO = null;
			EqrInlndTrspPlnVO eqrInlndTrspPlnVO = null;
			EqrInlndTrspPlnQtyVO eqrInlndTrspPlnQtyVO = null;
			
			CommonDBDAO commonDAO = new CommonDBDAO();
			CntrRepoExecutionPlanEstablishDBDAO execDao = new CntrRepoExecutionPlanEstablishDBDAO();
			EesEqr0052MultiVO model = null;
			String plnSeq = null;
			String pln_flg = "P";
			String[] unit_cost_amt = new String[3];
			float cntr_qty = 0;
			
			for ( int i=0; i<eesEqr0052MultiVOS .length; i++ ) {
				model = eesEqr0052MultiVOS[i];
				List<String> cntrTpszCdList = model.getCntrTpszCd();
				List<String> cntrQtyList = model.getCntrQty();
				
				//checking PLAN INSERT(only WATER, TRUCK, RAIL) target has LINK info
				if (model.getIbflag().equals("I") && !model.getTrspModCd().equals("V")) {//INSERT && WATER, TRUCK, RAIL
					//true 면 link 정보가 없다.
					if(execDao.inlandInsertCheck_link(model.getFmEccCd(), model.getToEccCd(), model.getTrspModCd())){
						String[] errMessage ={" ("+model.getFmEccCd()+"-"+model.getToEccCd()+")"};
            			log.debug(errMessage);
            			throw new EventException(new ErrorHandler("EQR10033", errMessage).getMessage());
					}
				}
				
				if (model.getIbflag().equals("I") || model.getIbflag().equals("U")){
					// Vessel
					if ("V".equals(model.getTrspModCd())) {
						eqrVslLodgDchgPlnVO = new EqrVslLodgDchgPlnVO();
						eqrVslLodgDchgPlnVO.setRepoPlnId(model.getRepoPlnId());
						eqrVslLodgDchgPlnVO.setPlnYrwk(model.getPlnYrwk());
						eqrVslLodgDchgPlnVO.setVslLaneCd(model.getVslLaneCd());
						eqrVslLodgDchgPlnVO.setVslCd(model.getVslCd());
						eqrVslLodgDchgPlnVO.setSkdVoyNo(model.getSkdVoyNo());
						eqrVslLodgDchgPlnVO.setSkdDirCd(model.getSkdDirCd());
						eqrVslLodgDchgPlnVO.setFmEccCd(model.getFmEccCd());
						eqrVslLodgDchgPlnVO.setFmEtdDt(model.getFmEtdDt());
						eqrVslLodgDchgPlnVO.setToEccCd(model.getToEccCd());
						eqrVslLodgDchgPlnVO.setToEtbDt(model.getToEtaDt());
						eqrVslLodgDchgPlnVO.setTrspModCd(model.getTrspModCd());
						eqrVslLodgDchgPlnVO.setUpdUsrId(usrId);
						if(model.getLdisTsFlg().equals("")){
							eqrVslLodgDchgPlnVO.setLdisTsFlg("N");
						} else {
							eqrVslLodgDchgPlnVO.setLdisTsFlg(model.getLdisTsFlg());
						}
						
						// setting PLN_SEQ
						if (model.getIbflag().equals("I")) {
							// DB Data Dup Check
							if (dbDao.isDupVslPlanData(eqrVslLodgDchgPlnVO) > 0) {
								throw new EventException(new ErrorHandler("EQR10035").getMessage());
							} else {
								plnSeq = commonDAO.getNextPlnSeq("EQR_VSL_LODG_DCHG_PLN", model.getRepoPlnId(), model.getPlnYrwk()).getResultString();
							}
						} else {
							plnSeq = model.getPlnSeq();
						}
						eqrVslLodgDchgPlnVO.setPlnSeq(plnSeq);

						// modifying EQR_VSL_LODG_DCHG_PLN
						dbDao.mergeCntrRepoInOutPlanDtVessel(eqrVslLodgDchgPlnVO);
						
						// modifying EQR_VSL_LODG_DCHG_PLN_QTY
						for (int j = 0; j < cntrTpszCdList.size(); j++) {
							//	on screen, vol = 0, setting vol = 1 cause to get unit Cost of lodg_port_cost_amt & dchg_port_cost_amt 
							if (cntrQtyList.get(j).equals("0")){
								cntr_qty = 1;
							}else {
								cntr_qty = Float.parseFloat(cntrQtyList.get(j));
							}
							unit_cost_amt = dbDao.searchUnitCost(pln_flg, model.getFmEccCd(), model.getToEccCd(), model.getTrspModCd() ,cntrTpszCdList.get(j)).getResultStrArray();
							
							eqrVslLodgDchgPlnQtyVO = new EqrVslLodgDchgPlnQtyVO();
							eqrVslLodgDchgPlnQtyVO.setRepoPlnId(model.getRepoPlnId());
							eqrVslLodgDchgPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
							eqrVslLodgDchgPlnQtyVO.setPlnSeq(plnSeq);
							eqrVslLodgDchgPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
							eqrVslLodgDchgPlnQtyVO.setCntrQty(cntrQtyList.get(j));
							eqrVslLodgDchgPlnQtyVO.setUpdUsrId(usrId);
							eqrVslLodgDchgPlnQtyVO.setLodgDchgCostAmt(String.valueOf((Float.parseFloat(cntrQtyList.get(j)) * Float.parseFloat(unit_cost_amt[0])) + (Float.parseFloat(cntrQtyList.get(j)) * Float.parseFloat(unit_cost_amt[1]))));
							eqrVslLodgDchgPlnQtyVO.setPlnUcAmt(String.valueOf(Float.parseFloat(unit_cost_amt[0]) + Float.parseFloat(unit_cost_amt[1])));
							eqrVslLodgDchgPlnQtyVO.setLodgPortCostAmt(String.valueOf(cntr_qty * Float.parseFloat(unit_cost_amt[0])));
							eqrVslLodgDchgPlnQtyVO.setDchgPortCostAmt(String.valueOf(cntr_qty * Float.parseFloat(unit_cost_amt[1])));
							dbDao.mergeCntrRepoInOutPlanDtVesselQty(eqrVslLodgDchgPlnQtyVO);
						}
						
					// Inland
					} else {
						eqrInlndTrspPlnVO = new EqrInlndTrspPlnVO();
						eqrInlndTrspPlnVO.setRepoPlnId(model.getRepoPlnId());
						eqrInlndTrspPlnVO.setPlnYrwk(model.getPlnYrwk());
						eqrInlndTrspPlnVO.setTrspModCd(model.getTrspModCd());
						eqrInlndTrspPlnVO.setFmEccCd(model.getFmEccCd());
						eqrInlndTrspPlnVO.setToEccCd(model.getToEccCd());
						eqrInlndTrspPlnVO.setPastRepoPlnFlg(model.getPastRepoPlnFlg());
						eqrInlndTrspPlnVO.setFmYrwk(model.getFmEtdDt().replaceAll("W",""));
						eqrInlndTrspPlnVO.setToYrwk(model.getToEtaDt().replaceAll("W",""));
						eqrInlndTrspPlnVO.setUpdUsrId(usrId);
						
						// setting PLN_SEQ
						if (model.getIbflag().equals("I")) {
							// DB Data Dup Check
							if (dbDao.isDupIndPlanData(eqrInlndTrspPlnVO) > 0) {
								throw new EventException(new ErrorHandler("EQR10035").getMessage());
							} else {
								plnSeq = commonDAO.getNextPlnSeq("EQR_INLND_TRSP_PLN", model.getRepoPlnId(), model.getPlnYrwk()).getResultString();
							}
						} else {
							plnSeq = model.getPlnSeq();
						}
						eqrInlndTrspPlnVO.setPlnSeq(plnSeq);

						// modifying EQR_INLND_TRSP_PLN
						dbDao.mergeCntrRepoInOutPlanDtInland(eqrInlndTrspPlnVO);
						
						// modifying EQR_INLND_TRSP_PLN_QTY
						for (int j = 0; j < cntrTpszCdList.size(); j++) {
							//	on screen, vol = 0, setting vol = 1 cause to get unit Cost of lodg_port_cost_amt & dchg_port_cost_amt
							if (cntrQtyList.get(j).equals("0")){
								cntr_qty = 1;
							}else {
								cntr_qty = Float.parseFloat(cntrQtyList.get(j));
							}
							unit_cost_amt = dbDao.searchUnitCost(pln_flg, model.getFmEccCd(), model.getToEccCd(), model.getTrspModCd() ,cntrTpszCdList.get(j)).getResultStrArray();
							
							eqrInlndTrspPlnQtyVO = new EqrInlndTrspPlnQtyVO();
							eqrInlndTrspPlnQtyVO.setRepoPlnId(model.getRepoPlnId());
							eqrInlndTrspPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
							eqrInlndTrspPlnQtyVO.setPlnSeq(plnSeq);
							eqrInlndTrspPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
							eqrInlndTrspPlnQtyVO.setCntrQty(cntrQtyList.get(j));
							eqrInlndTrspPlnQtyVO.setUpdUsrId(usrId);
							eqrInlndTrspPlnQtyVO.setTrspCostAmt(String.valueOf((Float.parseFloat(cntrQtyList.get(j)) * Float.parseFloat(unit_cost_amt[0])) + (Float.parseFloat(cntrQtyList.get(j)) * Float.parseFloat(unit_cost_amt[1]))));
							eqrInlndTrspPlnQtyVO.setPlnUcAmt(String.valueOf(Float.parseFloat(unit_cost_amt[0]) + Float.parseFloat(unit_cost_amt[1])));
							eqrInlndTrspPlnQtyVO.setFmEccCostAmt(String.valueOf(cntr_qty * Float.parseFloat(unit_cost_amt[0])));
							eqrInlndTrspPlnQtyVO.setToEccCostAmt(String.valueOf(cntr_qty * Float.parseFloat(unit_cost_amt[1])));
							dbDao.mergeCntrRepoInOutPlanDtInlandQty(eqrInlndTrspPlnQtyVO);
						}
					}

				} else if (model.getIbflag().equals("D")) {
					// Vessel
					if ("V".equals(model.getTrspModCd())) {
						// removing EQR_VSL_LODG_DCHG_PLN_QTY
						for (int j = 0; j < cntrTpszCdList.size(); j++) {
							eqrVslLodgDchgPlnQtyVO = new EqrVslLodgDchgPlnQtyVO();
							eqrVslLodgDchgPlnQtyVO.setRepoPlnId(model.getRepoPlnId());
							eqrVslLodgDchgPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
							eqrVslLodgDchgPlnQtyVO.setPlnSeq(model.getPlnSeq());
							eqrVslLodgDchgPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
							dbDao.deleteVesselPlanQty(eqrVslLodgDchgPlnQtyVO);
						}
						
						// removing EQR_VSL_LODG_DCHG_PLN
						eqrVslLodgDchgPlnVO = new EqrVslLodgDchgPlnVO();
						eqrVslLodgDchgPlnVO.setRepoPlnId(model.getRepoPlnId());
						eqrVslLodgDchgPlnVO.setPlnYrwk(model.getPlnYrwk());
						eqrVslLodgDchgPlnVO.setPlnSeq(model.getPlnSeq());
						dbDao.deleteVesselPlan(eqrVslLodgDchgPlnVO);
						
					// Inland
					} else {
						// removing EQR_INLND_TRSP_PLN_QTY
						for (int j = 0; j < cntrTpszCdList.size(); j++) {
							eqrInlndTrspPlnQtyVO = new EqrInlndTrspPlnQtyVO();
							eqrInlndTrspPlnQtyVO.setRepoPlnId(model.getRepoPlnId());
							eqrInlndTrspPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
							eqrInlndTrspPlnQtyVO.setPlnSeq(model.getPlnSeq());
							eqrInlndTrspPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
							dbDao.deleteInlandPlanQty(eqrInlndTrspPlnQtyVO);
						}
						
						// removing EQR_INLND_TRSP_PLN
						eqrInlndTrspPlnVO = new EqrInlndTrspPlnVO();
						eqrInlndTrspPlnVO.setRepoPlnId(model.getRepoPlnId());
						eqrInlndTrspPlnVO.setPlnYrwk(model.getPlnYrwk());
						eqrInlndTrspPlnVO.setPlnSeq(model.getPlnSeq());
						dbDao.deleteInlandPlan(eqrInlndTrspPlnVO);
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
	 * retreiving for TS Guideline PopUp<br>
	 * 
	 * @param conditionVO EesEqr0129ConditionVO
	 * @return List<SearchTSGuidelineVO>
	 * @exception EventException
	 */
	public List<SearchTSGuidelineVO> searchTSGuideline(EesEqr0129ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchTSGuideline(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * retrieving for CNTR on hire repo plan info(On-Hire)<br>
	 * 
	 * @param conditionVO EesEqr0053ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrOnHireRepoPlanDtInfo(EesEqr0053ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchCntrOnHireRepoPlanDtInfo(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * retrieving for On-Hire approval<br>
	 * 
	 * @param conditionVO EesEqr0053ConditionVO
	 * @return List<SearchCntrOnHireApprovalVO>
	 * @exception EventException
	 */
	public List<SearchCntrOnHireApprovalVO> searchOnHireApproval(EesEqr0053ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchOnHireApproval(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * saving CNTR on hire repo plan info(On-Hire)<br>
	 * 
	 * @param eesEqr0053MultiVOS EesEqr0053MultiVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyCntrOnHireRepoPlanDtInfo(EesEqr0053MultiVO[] eesEqr0053MultiVOS, String usrId) throws EventException {
		
		try {
			EqrOnfHirPlnVO eqrOnfHirPlnVO = null;
			EqrOnfHirPlnQtyVO eqrOnfHirPlnQtyVO = null;
			
			CommonDBDAO commonDAO = new CommonDBDAO();
			EesEqr0053MultiVO model = null;
			String plnSeq = null;
			String pln_flg = "P";
			String[] unit_cost_amt = new String[3];
			
			for ( int i=0; i<eesEqr0053MultiVOS .length; i++ ) {
				model = eesEqr0053MultiVOS[i];
				List<String> cntrTpszCdList = model.getCntrTpszCd();
				List<String> cntrQtyList = model.getCntrQty();
				
				if (model.getIbflag().equals("I") || model.getIbflag().equals("U")){
					eqrOnfHirPlnVO = new EqrOnfHirPlnVO();
					eqrOnfHirPlnVO.setRepoPlnId(model.getRepoPlnId());
					eqrOnfHirPlnVO.setPlnYrwk(model.getPlnYrwk());
					eqrOnfHirPlnVO.setOnfHirDivCd(model.getOnfHirDivCd());
					eqrOnfHirPlnVO.setEccCd(model.getEccCd());
					eqrOnfHirPlnVO.setCntrLstmCd(model.getCntrLstmCd());
					eqrOnfHirPlnVO.setUpdUsrId(usrId);
					
					// setting PLN_SEQ
					if (model.getIbflag().equals("I")) {
						// DB Data Dup Check
						if (dbDao.isDupOnHirPlanData(eqrOnfHirPlnVO) > 0) {
							throw new EventException(new ErrorHandler("EQR10035").getMessage());
						} else {
							plnSeq = commonDAO.getNextPlnSeq("EQR_ONF_HIR_PLN", model.getRepoPlnId(), model.getPlnYrwk()).getResultString();
						}
					} else {
						plnSeq = model.getPlnSeq();
					}
					eqrOnfHirPlnVO.setPlnSeq(plnSeq);

					// modifying EQR_ONF_HIR_PLN
					dbDao.mergeCntrOnHireRepoPlanDt(eqrOnfHirPlnVO);
					
					// modifying EQR_ONF_HIR_PLN_QTY
					for (int j = 0; j < cntrTpszCdList.size(); j++) {
						unit_cost_amt = dbDao.searchUnitCost(pln_flg, model.getEccCd(), model.getEccCd(), model.getOnfHirDivCd() ,cntrTpszCdList.get(j)).getResultStrArray();
						
						eqrOnfHirPlnQtyVO = new EqrOnfHirPlnQtyVO();
						eqrOnfHirPlnQtyVO.setRepoPlnId(model.getRepoPlnId());
						eqrOnfHirPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
						eqrOnfHirPlnQtyVO.setPlnSeq(plnSeq);
						eqrOnfHirPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
						eqrOnfHirPlnQtyVO.setCntrQty(cntrQtyList.get(j));
						eqrOnfHirPlnQtyVO.setOnfHirCostAmt(String.valueOf(Float.parseFloat(unit_cost_amt[1])  * Float.parseFloat(cntrQtyList.get(j))));
						eqrOnfHirPlnQtyVO.setPlnUcAmt(unit_cost_amt[1]);
						eqrOnfHirPlnQtyVO.setUpdUsrId(usrId);
						dbDao.mergeCntrOnHireRepoPlanDtQty(eqrOnfHirPlnQtyVO);
					}

				} else if (model.getIbflag().equals("D")) {
					// removing EQR_ONF_HIR_PLN_QTY
					for (int j = 0; j < cntrTpszCdList.size(); j++) {
						eqrOnfHirPlnQtyVO = new EqrOnfHirPlnQtyVO();
						eqrOnfHirPlnQtyVO.setRepoPlnId(model.getRepoPlnId());
						eqrOnfHirPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
						eqrOnfHirPlnQtyVO.setPlnSeq(model.getPlnSeq());
						eqrOnfHirPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
						dbDao.deleteOnOffPlanQty(eqrOnfHirPlnQtyVO);
					}
					
					// removing EQR_ONF_HIR_PLN
					eqrOnfHirPlnVO = new EqrOnfHirPlnVO();
					eqrOnfHirPlnVO.setRepoPlnId(model.getRepoPlnId());
					eqrOnfHirPlnVO.setPlnYrwk(model.getPlnYrwk());
					eqrOnfHirPlnVO.setPlnSeq(model.getPlnSeq());
					dbDao.deleteOnOffPlan(eqrOnfHirPlnVO);
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
	 * retrieving for CNTR off hire repo plan info(On-Hire)<br>
	 * 
	 * @param conditionVO EesEqr0054ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrOffHireRepoPlanDtInfo(EesEqr0054ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchCntrOffHireRepoPlanDtInfo(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * saving CNTR off hire repo plan info(On-Hire)<br>
	 * 
	 * @param eesEqr0053MultiVOS EesEqr0053MultiVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyCntrOffHireRepoPlanDtInfo(EesEqr0053MultiVO[] eesEqr0053MultiVOS, String usrId) throws EventException {
		
		try {
			EqrOnfHirPlnVO eqrOnfHirPlnVO = null;
			EqrOnfHirPlnQtyVO eqrOnfHirPlnQtyVO = null;
			
			CommonDBDAO commonDAO = new CommonDBDAO();
			EesEqr0053MultiVO model = null;
			String plnSeq = null;
			String pln_flg = "P";
			String[] unit_cost_amt = new String[3];
			
			for ( int i=0; i<eesEqr0053MultiVOS .length; i++ ) {
				model = eesEqr0053MultiVOS[i];
				List<String> cntrTpszCdList = model.getCntrTpszCd();
				List<String> cntrQtyList = model.getCntrQty();
				
				if (model.getIbflag().equals("I") || model.getIbflag().equals("U")){
					eqrOnfHirPlnVO = new EqrOnfHirPlnVO();
					eqrOnfHirPlnVO.setRepoPlnId(model.getRepoPlnId());
					eqrOnfHirPlnVO.setPlnYrwk(model.getPlnYrwk());
					eqrOnfHirPlnVO.setOnfHirDivCd(model.getOnfHirDivCd());
					eqrOnfHirPlnVO.setEccCd(model.getEccCd());
					eqrOnfHirPlnVO.setUpdUsrId(usrId);
					
					// in case of Insert, getting new PLN_SEQ
					if (model.getIbflag().equals("I")) {
						// DB Data Dup Check
						if (dbDao.isDupOffHirPlanData(eqrOnfHirPlnVO) > 0) {
							throw new EventException(new ErrorHandler("EQR10035").getMessage());
						} else {
							plnSeq = commonDAO.getNextPlnSeq("EQR_ONF_HIR_PLN", model.getRepoPlnId(), model.getPlnYrwk()).getResultString();
						}
						
					// in case of Update, existing PLN_SEQ 
					} else {
						eqrOnfHirPlnVO = new EqrOnfHirPlnVO();
						eqrOnfHirPlnVO.setRepoPlnId(model.getRepoPlnId());
						eqrOnfHirPlnVO.setPlnYrwk(model.getPlnYrwk());
						eqrOnfHirPlnVO.setOnfHirDivCd(model.getOnfHirDivCd());
						eqrOnfHirPlnVO.setEccCd(model.getEccCd());
						String [] plnSeqArr = dbDao.getOnfHirPlnSeq(eqrOnfHirPlnVO).getResultStrArray();
						if (plnSeqArr.length != 1) {
							throw new EventException("Duplicated PLN_SEQ Of EQR_ONF_HIR_PLN!!!");
						} else {
							plnSeq = plnSeqArr[0];
						}
					}
					eqrOnfHirPlnVO.setPlnSeq(plnSeq);

					// modifying EQR_ONF_HIR_PLN
					dbDao.mergeCntrOffHireRepoPlanDt(eqrOnfHirPlnVO);
					
					// modifying EQR_ONF_HIR_PLN_QTY
					for (int j = 0; j < cntrTpszCdList.size(); j++) {
						unit_cost_amt = dbDao.searchUnitCost(pln_flg, model.getEccCd(), model.getEccCd(), model.getOnfHirDivCd() ,cntrTpszCdList.get(j)).getResultStrArray();
						
						eqrOnfHirPlnQtyVO = new EqrOnfHirPlnQtyVO();
						eqrOnfHirPlnQtyVO.setRepoPlnId(model.getRepoPlnId());
						eqrOnfHirPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
						eqrOnfHirPlnQtyVO.setPlnSeq(plnSeq);
						eqrOnfHirPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
						eqrOnfHirPlnQtyVO.setCntrQty(cntrQtyList.get(j));
						eqrOnfHirPlnQtyVO.setOnfHirCostAmt(String.valueOf(Float.parseFloat(unit_cost_amt[0])  * Float.parseFloat(cntrQtyList.get(j))));
						eqrOnfHirPlnQtyVO.setPlnUcAmt(unit_cost_amt[0]);
						eqrOnfHirPlnQtyVO.setUpdUsrId(usrId);
						dbDao.mergeCntrOffHireRepoPlanDtQty(eqrOnfHirPlnQtyVO);
					}

				} else if (model.getIbflag().equals("D")) {
					eqrOnfHirPlnVO = new EqrOnfHirPlnVO();
					eqrOnfHirPlnVO.setRepoPlnId(model.getRepoPlnId());
					eqrOnfHirPlnVO.setPlnYrwk(model.getPlnYrwk());
					eqrOnfHirPlnVO.setOnfHirDivCd(model.getOnfHirDivCd());
					eqrOnfHirPlnVO.setEccCd(model.getEccCd());
					String [] plnSeqArr = dbDao.getOnfHirPlnSeq(eqrOnfHirPlnVO).getResultStrArray();
					if (plnSeqArr.length != 1) {
						throw new EventException("Duplicated PLN_SEQ Of EQR_ONF_HIR_PLN!!!");
					} else {
						plnSeq = plnSeqArr[0];
					}
					
					// removing EQR_ONF_HIR_PLN_QTY
					for (int j = 0; j < cntrTpszCdList.size(); j++) {
						eqrOnfHirPlnQtyVO = new EqrOnfHirPlnQtyVO();
						eqrOnfHirPlnQtyVO.setRepoPlnId(model.getRepoPlnId());
						eqrOnfHirPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
						eqrOnfHirPlnQtyVO.setPlnSeq(plnSeq);
						eqrOnfHirPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
						dbDao.deleteOnOffPlanQty(eqrOnfHirPlnQtyVO);
					}
					
					// removing EQR_ONF_HIR_PLN
					eqrOnfHirPlnVO = new EqrOnfHirPlnVO();
					eqrOnfHirPlnVO.setRepoPlnId(model.getRepoPlnId());
					eqrOnfHirPlnVO.setPlnYrwk(model.getPlnYrwk());
					eqrOnfHirPlnVO.setPlnSeq(plnSeq);
					dbDao.deleteOnOffPlan(eqrOnfHirPlnVO);
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
	 * retrieving for RLA repo plan info(RLA List)<br>
	 * 
	 * @param conditionVO EesEqr0048ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchRLARepoPlanDtList(EesEqr0048ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchRLARepoPlanDtList(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * saving RLA repo plan info(RLA List)<br>
	 * 
	 * @param eesEqr0048MultiVOS EesEqr0048MultiVO[]
	 * @param conditionVO EesEqr0048ConditionVO
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyRLARepoPlanDtList(EesEqr0048MultiVO[] eesEqr0048MultiVOS, EesEqr0048ConditionVO conditionVO, String usrId) throws EventException {
		try {
			EqrInlndTrspPlnVO eqrInlndTrspPlnVO = null;
			EqrInlndTrspPlnQtyVO eqrInlndTrspPlnQtyVO = null;
			EqrOnfHirPlnVO eqrOnfHirPlnVO = null;
			EqrOnfHirPlnQtyVO eqrOnfHirPlnQtyVO = null;
			EqrVslLodgDchgPlnVO eqrVslLodgDchgPlnVO = null;
			EqrVslLodgDchgPlnQtyVO eqrVslLodgDchgPlnQtyVO = null;
			
			EesEqr0048MultiVO model = null;
			
			String repoPlnId = Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
			
			for ( int i=0; i<eesEqr0048MultiVOS .length; i++ ) {
				model = eesEqr0048MultiVOS[i];
				List<String> cntrTpszCdList = model.getCntrTpszCd();
				List<String> cntrQtyList = model.getCntrQty();
				List<String> costAmtList = model.getCostAmt();
				
				if (model.getIbflag().equals("U")){
					// Vessel
					if (model.getTablenm().equals("EQR_VSL_LODG_DCHG_PLN")) {
						
						// getting PLN_SEQ from EQR_VSL_LODG_DCHG_PLN
						eqrVslLodgDchgPlnVO = new EqrVslLodgDchgPlnVO();
						eqrVslLodgDchgPlnVO.setRepoPlnId(repoPlnId);
						eqrVslLodgDchgPlnVO.setPlnYrwk(model.getPlnYrwk());
						eqrVslLodgDchgPlnVO.setVslLaneCd(model.getVslLaneCd());
						eqrVslLodgDchgPlnVO.setVslCd(model.getVslCd());
						eqrVslLodgDchgPlnVO.setSkdVoyNo(model.getSkdVoyNo());
						eqrVslLodgDchgPlnVO.setSkdDirCd(model.getSkdDirCd());
						eqrVslLodgDchgPlnVO.setFmEccCd(model.getFmEccCd());
						eqrVslLodgDchgPlnVO.setFmEtdDt(model.getFmEtdDt());
						eqrVslLodgDchgPlnVO.setToEccCd(model.getToEccCd());
						eqrVslLodgDchgPlnVO.setToEtbDt(model.getToEtaDt());
						eqrVslLodgDchgPlnVO.setTrspModCd(model.getTrspModCd());
						String [] plnSeqArr = dbDao.getVslPlnSeq(eqrVslLodgDchgPlnVO).getResultStrArray();
						
						// modifying EQR_VSL_LODG_DCHG_PLN_QTY
						for (int k = 0; k < plnSeqArr.length; k++) {
							String plnSeq = plnSeqArr[k];
							
							for (int j = 0; j < cntrTpszCdList.size(); j++) {
								eqrVslLodgDchgPlnQtyVO = new EqrVslLodgDchgPlnQtyVO();
								eqrVslLodgDchgPlnQtyVO.setRepoPlnId(repoPlnId);
								eqrVslLodgDchgPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
								eqrVslLodgDchgPlnQtyVO.setPlnSeq(plnSeq);
								eqrVslLodgDchgPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
								eqrVslLodgDchgPlnQtyVO.setCntrQty(cntrQtyList.get(j));
								eqrVslLodgDchgPlnQtyVO.setLodgDchgCostAmt(costAmtList.get(j));
								eqrVslLodgDchgPlnQtyVO.setUpdUsrId(usrId);
								dbDao.modifyRLARepoPlanDtVesselQty(eqrVslLodgDchgPlnQtyVO);
							}
						}
						
					// Inland
					} else if (model.getTablenm().equals("EQR_INLND_TRSP_PLN")) {
						
						// getting PLN_SEQ from EQR_INLND_TRSP_PLN
						eqrInlndTrspPlnVO = new EqrInlndTrspPlnVO();
						eqrInlndTrspPlnVO.setRepoPlnId(repoPlnId);
						eqrInlndTrspPlnVO.setPlnYrwk(model.getPlnYrwk());
						eqrInlndTrspPlnVO.setTrspModCd(model.getTrspModCd());
						eqrInlndTrspPlnVO.setFmEccCd(model.getFmEccCd());
						eqrInlndTrspPlnVO.setToEccCd(model.getToEccCd());
						eqrInlndTrspPlnVO.setFmYrwk(model.getFmEtdDt().replaceAll("W",""));
						eqrInlndTrspPlnVO.setToYrwk(model.getToEtaDt().replaceAll("W",""));
						String [] plnSeqArr = dbDao.getInLndPlnSeq(eqrInlndTrspPlnVO).getResultStrArray();
						
						// modifying EQR_INLND_TRSP_PLN_QTY
						for (int k = 0; k < plnSeqArr.length; k++) {
							String plnSeq = plnSeqArr[k];
							
							for (int j = 0; j < cntrTpszCdList.size(); j++) {
								eqrInlndTrspPlnQtyVO = new EqrInlndTrspPlnQtyVO();
								eqrInlndTrspPlnQtyVO.setRepoPlnId(repoPlnId);
								eqrInlndTrspPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
								eqrInlndTrspPlnQtyVO.setPlnSeq(plnSeq);
								eqrInlndTrspPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
								eqrInlndTrspPlnQtyVO.setCntrQty(cntrQtyList.get(j));
								eqrInlndTrspPlnQtyVO.setTrspCostAmt(costAmtList.get(j));
								eqrInlndTrspPlnQtyVO.setUpdUsrId(usrId);
								dbDao.modifyRLARepoPlanDtInlandQty(eqrInlndTrspPlnQtyVO);
							}
						}
						
					// On/Off Hire
					} else if (model.getTablenm().equals("EQR_ONF_HIR_PLN")) {
						
						// getting PLN_SEQ from EQR_INLND_TRSP_PLN
						eqrOnfHirPlnVO = new EqrOnfHirPlnVO();
						eqrOnfHirPlnVO.setRepoPlnId(repoPlnId);
						eqrOnfHirPlnVO.setPlnYrwk(model.getPlnYrwk());
						eqrOnfHirPlnVO.setOnfHirDivCd(model.getItem());
						if (model.getItem().equals("O")) {//on-hire
							eqrOnfHirPlnVO.setEccCd(model.getToEccCd());
						} else {
							eqrOnfHirPlnVO.setEccCd(model.getFmEccCd());
						}
						String [] plnSeqArr = dbDao.getOnfHirPlnSeq(eqrOnfHirPlnVO).getResultStrArray();
						
						// modifying EQR_ONF_HIR_PLN
						for (int k = 0; k < plnSeqArr.length; k++) {
							String plnSeq = plnSeqArr[k];
							
							for (int j = 0; j < cntrTpszCdList.size(); j++) {
								eqrOnfHirPlnQtyVO = new EqrOnfHirPlnQtyVO();
								eqrOnfHirPlnQtyVO.setRepoPlnId(repoPlnId);
								eqrOnfHirPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
								eqrOnfHirPlnQtyVO.setPlnSeq(plnSeq);
								eqrOnfHirPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
								eqrOnfHirPlnQtyVO.setCntrQty(cntrQtyList.get(j));
								eqrOnfHirPlnQtyVO.setOnfHirCostAmt(costAmtList.get(j));
								eqrOnfHirPlnQtyVO.setUpdUsrId(usrId);
								dbDao.modifyRLARepoPlanDtOnOffQty(eqrOnfHirPlnQtyVO);
							}
						}
					}

				} else if (model.getIbflag().equals("D")) {
					// Vessel
					if (model.getTablenm().equals("EQR_VSL_LODG_DCHG_PLN")) {
						
						//  getting PLN_SEQ from EQR_VSL_LODG_DCHG_PLN
						eqrVslLodgDchgPlnVO = new EqrVslLodgDchgPlnVO();
						eqrVslLodgDchgPlnVO.setRepoPlnId(repoPlnId);
						eqrVslLodgDchgPlnVO.setPlnYrwk(model.getPlnYrwk());
						eqrVslLodgDchgPlnVO.setVslLaneCd(model.getVslLaneCd());
						eqrVslLodgDchgPlnVO.setVslCd(model.getVslCd());
						eqrVslLodgDchgPlnVO.setSkdVoyNo(model.getSkdVoyNo());
						eqrVslLodgDchgPlnVO.setSkdDirCd(model.getSkdDirCd());
						eqrVslLodgDchgPlnVO.setFmEccCd(model.getFmEccCd());
						eqrVslLodgDchgPlnVO.setFmEtdDt(model.getFmEtdDt());
						eqrVslLodgDchgPlnVO.setToEccCd(model.getToEccCd());
						eqrVslLodgDchgPlnVO.setToEtbDt(model.getToEtaDt());
						eqrVslLodgDchgPlnVO.setTrspModCd(model.getTrspModCd());
						String [] plnSeqArr = dbDao.getVslPlnSeq(eqrVslLodgDchgPlnVO).getResultStrArray();
						
						for (int k = 0; k < plnSeqArr.length; k++) {
							String plnSeq = plnSeqArr[k];
							
							// removing EQR_VSL_LODG_DCHG_PLN_QTY
							for (int j = 0; j < cntrTpszCdList.size(); j++) {
								eqrVslLodgDchgPlnQtyVO = new EqrVslLodgDchgPlnQtyVO();
								eqrVslLodgDchgPlnQtyVO.setRepoPlnId(repoPlnId);
								eqrVslLodgDchgPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
								eqrVslLodgDchgPlnQtyVO.setPlnSeq(plnSeq);
								eqrVslLodgDchgPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
								dbDao.deleteVesselPlanQty(eqrVslLodgDchgPlnQtyVO);
							}
							
							// removing EQR_VSL_LODG_DCHG_PLN
							eqrVslLodgDchgPlnVO.setPlnSeq(plnSeq);
							dbDao.deleteVesselPlan(eqrVslLodgDchgPlnVO);
						}
						
					// Inland
					} else if (model.getTablenm().equals("EQR_INLND_TRSP_PLN")) {
						
						//  getting PLN_SEQ from EQR_INLND_TRSP_PLN
						eqrInlndTrspPlnVO = new EqrInlndTrspPlnVO();
						eqrInlndTrspPlnVO.setRepoPlnId(repoPlnId);
						eqrInlndTrspPlnVO.setPlnYrwk(model.getPlnYrwk());
						eqrInlndTrspPlnVO.setTrspModCd(model.getTrspModCd());
						eqrInlndTrspPlnVO.setFmEccCd(model.getFmEccCd());
						eqrInlndTrspPlnVO.setToEccCd(model.getToEccCd());
						eqrInlndTrspPlnVO.setFmYrwk(model.getFmEtdDt().replaceAll("W",""));
						eqrInlndTrspPlnVO.setToYrwk(model.getToEtaDt().replaceAll("W",""));
						String [] plnSeqArr = dbDao.getInLndPlnSeq(eqrInlndTrspPlnVO).getResultStrArray();
						
						for (int k = 0; k < plnSeqArr.length; k++) {
							String plnSeq = plnSeqArr[k];
							
							// removing EQR_INLND_TRSP_PLN_QTY
							for (int j = 0; j < cntrTpszCdList.size(); j++) {
								eqrInlndTrspPlnQtyVO = new EqrInlndTrspPlnQtyVO();
								eqrInlndTrspPlnQtyVO.setRepoPlnId(repoPlnId);
								eqrInlndTrspPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
								eqrInlndTrspPlnQtyVO.setPlnSeq(plnSeq);
								eqrInlndTrspPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
								dbDao.deleteInlandPlanQty(eqrInlndTrspPlnQtyVO);
							}
							
							// removing EQR_INLND_TRSP_PLN
							eqrInlndTrspPlnVO.setPlnSeq(plnSeq);
							dbDao.deleteInlandPlan(eqrInlndTrspPlnVO);
						}
						
					// On/Off Hire
					} else if (model.getTablenm().equals("EQR_ONF_HIR_PLN")) {
						
						//  getting PLN_SEQ from EQR_INLND_TRSP_PLN
						eqrOnfHirPlnVO = new EqrOnfHirPlnVO();
						eqrOnfHirPlnVO.setRepoPlnId(repoPlnId);
						eqrOnfHirPlnVO.setPlnYrwk(model.getPlnYrwk());
						eqrOnfHirPlnVO.setOnfHirDivCd(model.getItem());
						if (model.getItem().equals("O")) {//on-hire
							eqrOnfHirPlnVO.setEccCd(model.getToEccCd());
						} else {
							eqrOnfHirPlnVO.setEccCd(model.getFmEccCd());
						}
						String [] plnSeqArr = dbDao.getOnfHirPlnSeq(eqrOnfHirPlnVO).getResultStrArray();
						
						for (int k = 0; k < plnSeqArr.length; k++) {
							String plnSeq = plnSeqArr[k];
							
							// removing EQR_ONF_HIR_PLN_QTY
							for (int j = 0; j < cntrTpszCdList.size(); j++) {
								eqrOnfHirPlnQtyVO = new EqrOnfHirPlnQtyVO();
								eqrOnfHirPlnQtyVO.setRepoPlnId(repoPlnId);
								eqrOnfHirPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
								eqrOnfHirPlnQtyVO.setPlnSeq(plnSeq);
								eqrOnfHirPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
								dbDao.deleteOnOffPlanQty(eqrOnfHirPlnQtyVO);
							}
							
							// removing EQR_ONF_HIR_PLN
							eqrOnfHirPlnVO.setPlnSeq(plnSeq);
							dbDao.deleteOnOffPlan(eqrOnfHirPlnVO);
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
	 * To Eta <br>
	 * @param EesEqr0059ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String searchToEta(EesEqr0059ConditionVO condVO) throws EventException {
		try{
			return dbDao.searchToEta(condVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR0059", new String[]{"checkLocCd"}).getMessage(),ex);
		}
    }
	
	
	/**
	 * Now week 처리 <br>
	 * @param EesEqr0059ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String searchNowWeek(EesEqr0059ConditionVO condVO) throws EventException {
		try{
			return dbDao.searchNowWeek(condVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR0059", new String[]{"checkLocCd"}).getMessage(),ex);
		}
    }
}