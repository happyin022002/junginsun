/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanManageBCImpl.java
*@FileTitle : 컨테이너 이송 계획 목록 조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		sangyool pak					2006-11-21		1.0 최초 생성
* 2					Chang Ho Chae				2009-04-10		CSR No : R200904090006 (EAI --> WTC로 전환)
* 3      	1.0      	Lee Byoung Hun				2009.08.14		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.14
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration.CommonDBDAO;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration.CntrRepoExecutionPlanEstablishDBDAO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration.CntrRepoPlanManageDBDAO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0045ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0048ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0048MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0051ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0052ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0052MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0054ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0129ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.GetRepoPlanListVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrOnHireApprovalVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrRepoInOutPlanLaneVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrRepoInOutPlanVVDVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchTSGuidelineVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrAddPlnVO;
import com.hanjin.syscommon.common.table.EqrInlndTrspPlnQtyVO;
import com.hanjin.syscommon.common.table.EqrInlndTrspPlnVO;
import com.hanjin.syscommon.common.table.EqrOnfHirPlnQtyVO;
import com.hanjin.syscommon.common.table.EqrOnfHirPlnVO;
import com.hanjin.syscommon.common.table.EqrVslLodgDchgPlnQtyVO;
import com.hanjin.syscommon.common.table.EqrVslLodgDchgPlnVO;

/**
 * ALPS-CntrRepoPlanManage Business Logic Basic Command implementation<br>
 * - ALPS-CntrRepoPlanManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see EES_EQR_0045EventResponse,CntrRepoPlanManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CntrRepoPlanManageBCImpl extends BasicCommandSupport implements CntrRepoPlanManageBC {

	// Database Access Object
	private transient CntrRepoPlanManageDBDAO dbDao = null;

	/**
	 * CntrRepoPlanManageBCImpl 객체 생성<br>
	 * CntrRepoPlanManageDBDAO를 생성한다.<br>
	 */
	public CntrRepoPlanManageBCImpl() {
		dbDao = new CntrRepoPlanManageDBDAO();
	}
	
	/**
	 * 컨테이너 이송 계획 목록 조회 조회 이벤트 처리<br>
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
	 * 컨테이너 이송 계획 목록 조회 Copy 이벤트 처리<br>
	 * EQR_COPY_REPO_PLAN_PRC 프로시져 호출
	 * 
	 * @param conditionVO EesEqr0045ConditionVO
	 * @param usrId String
	 * @exception EventException
	 */
	public void createNewRepoPlanID(EesEqr0045ConditionVO conditionVO, String usrId) throws EventException {
		try {
			dbDao.createNewRepoPlanID(conditionVO, usrId); // EQR_COPY_REPO_PLAN_PRC 프로시져 호출
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 컨테이너 이송 계획 목록 조회 Delete 이벤트 처리<br>
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
	 * 컨테이너 이송계획 관리 조회 이벤트 처리<br>
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
	 * 컨테이너 이송계획 관리 저장 이벤트 처리<br>
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
	 * 컨테이너 이송계획 관리 Distribution 가능여부 조회 이벤트 처리<br>
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
	 * 컨테이너 이송계획 관리 Distribution 이벤트 처리<br>
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
	 * 최적화된 REPO InOut 계획 수량 조회 이벤트 처리<br>
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
	 * 최적화된 REPO InOut 계획 수량 VVD 조회 이벤트 처리<br>
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
	 * 최적화된 REPO InOut 계획 수량 LOC 조회 이벤트 처리<br>
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
	 * 최적화된 REPO InOut 계획 수량 수정 이벤트 처리<br>
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
				
				//PLAN INSERT(WATER, TRUCK, RAIL 만) 대상이 LINK 정보를 가지고 있는지 확인
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
						
						// PLN_SEQ 세팅
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

						// EQR_VSL_LODG_DCHG_PLN 수정
						dbDao.mergeCntrRepoInOutPlanDtVessel(eqrVslLodgDchgPlnVO);
						
						// EQR_VSL_LODG_DCHG_PLN_QTY 수정
						for (int j = 0; j < cntrTpszCdList.size(); j++) {
							//	화면에서 vol이 0일때  lodg_port_cost_amt와 dchg_port_cost_amt의 unit Cost을 구하기 위해서 vol값을 1로 변경  수량은 변경 없음
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
						
						// PLN_SEQ 세팅
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

						// EQR_INLND_TRSP_PLN 수정
						dbDao.mergeCntrRepoInOutPlanDtInland(eqrInlndTrspPlnVO);
						
						// EQR_INLND_TRSP_PLN_QTY 수정
						for (int j = 0; j < cntrTpszCdList.size(); j++) {
							//	화면에서 vol이 0일때  lodg_port_cost_amt와 dchg_port_cost_amt의 unit Cost을 구하기 위해서 vol값을 1로 변경  수량은 변경 없음
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
						// EQR_VSL_LODG_DCHG_PLN_QTY 삭제
						for (int j = 0; j < cntrTpszCdList.size(); j++) {
							eqrVslLodgDchgPlnQtyVO = new EqrVslLodgDchgPlnQtyVO();
							eqrVslLodgDchgPlnQtyVO.setRepoPlnId(model.getRepoPlnId());
							eqrVslLodgDchgPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
							eqrVslLodgDchgPlnQtyVO.setPlnSeq(model.getPlnSeq());
							eqrVslLodgDchgPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
							dbDao.deleteVesselPlanQty(eqrVslLodgDchgPlnQtyVO);
						}
						
						// EQR_VSL_LODG_DCHG_PLN 삭제
						eqrVslLodgDchgPlnVO = new EqrVslLodgDchgPlnVO();
						eqrVslLodgDchgPlnVO.setRepoPlnId(model.getRepoPlnId());
						eqrVslLodgDchgPlnVO.setPlnYrwk(model.getPlnYrwk());
						eqrVslLodgDchgPlnVO.setPlnSeq(model.getPlnSeq());
						dbDao.deleteVesselPlan(eqrVslLodgDchgPlnVO);
						
					// Inland
					} else {
						// EQR_INLND_TRSP_PLN_QTY 삭제
						for (int j = 0; j < cntrTpszCdList.size(); j++) {
							eqrInlndTrspPlnQtyVO = new EqrInlndTrspPlnQtyVO();
							eqrInlndTrspPlnQtyVO.setRepoPlnId(model.getRepoPlnId());
							eqrInlndTrspPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
							eqrInlndTrspPlnQtyVO.setPlnSeq(model.getPlnSeq());
							eqrInlndTrspPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
							dbDao.deleteInlandPlanQty(eqrInlndTrspPlnQtyVO);
						}
						
						// EQR_INLND_TRSP_PLN 삭제
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
	 * TS Guideline PopUp 조회 이벤트 처리<br>
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
	 * 컨테이너 수급 예측실적 및 정확도(On-Hire) Sheet1 조회 이벤트 처리<br>
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
	 * 컨테이너 수급 예측실적 및 정확도(On-Hire) Sheet2 조회 이벤트 처리<br>
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
	 * 컨테이너 수급 예측실적 및 정확도(On-Hire) 수정 이벤트 처리<br>
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
					
					// PLN_SEQ 세팅
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

					// EQR_ONF_HIR_PLN 수정
					dbDao.mergeCntrOnHireRepoPlanDt(eqrOnfHirPlnVO);
					
					// EQR_ONF_HIR_PLN_QTY 수정
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
					// EQR_ONF_HIR_PLN_QTY 삭제
					for (int j = 0; j < cntrTpszCdList.size(); j++) {
						eqrOnfHirPlnQtyVO = new EqrOnfHirPlnQtyVO();
						eqrOnfHirPlnQtyVO.setRepoPlnId(model.getRepoPlnId());
						eqrOnfHirPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
						eqrOnfHirPlnQtyVO.setPlnSeq(model.getPlnSeq());
						eqrOnfHirPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
						dbDao.deleteOnOffPlanQty(eqrOnfHirPlnQtyVO);
					}
					
					// EQR_ONF_HIR_PLN 삭제
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
	 * 컨테이너 수급 예측실적 및 정확도(Off-Hire) 조회 이벤트 처리<br>
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
	 * 컨테이너 수급 예측실적 및 정확도(Off-Hire) 수정 이벤트 처리<br>
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
					
					// Insert 경우 새로운 PLN_SEQ 취득
					if (model.getIbflag().equals("I")) {
						// DB Data Dup Check
						if (dbDao.isDupOffHirPlanData(eqrOnfHirPlnVO) > 0) {
							throw new EventException(new ErrorHandler("EQR10035").getMessage());
						} else {
							plnSeq = commonDAO.getNextPlnSeq("EQR_ONF_HIR_PLN", model.getRepoPlnId(), model.getPlnYrwk()).getResultString();
						}
						
					// Update 경우 기존의 PLN_SEQ 취득
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

					// EQR_ONF_HIR_PLN 수정
					dbDao.mergeCntrOffHireRepoPlanDt(eqrOnfHirPlnVO);
					
					// EQR_ONF_HIR_PLN_QTY 수정
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
					
					// EQR_ONF_HIR_PLN_QTY 삭제
					for (int j = 0; j < cntrTpszCdList.size(); j++) {
						eqrOnfHirPlnQtyVO = new EqrOnfHirPlnQtyVO();
						eqrOnfHirPlnQtyVO.setRepoPlnId(model.getRepoPlnId());
						eqrOnfHirPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
						eqrOnfHirPlnQtyVO.setPlnSeq(plnSeq);
						eqrOnfHirPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
						dbDao.deleteOnOffPlanQty(eqrOnfHirPlnQtyVO);
					}
					
					// EQR_ONF_HIR_PLN 삭제
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
	 * 컨테이너 수급 예측실적 및 정확도 조회(RLA List) 조회 이벤트 처리<br>
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
	 * 컨테이너 수급 예측실적 및 정확도 조회(RLA List) 수정 이벤트 처리<br>
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
						
						// EQR_VSL_LODG_DCHG_PLN 로부터 PLN_SEQ 취득
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
						
						// EQR_VSL_LODG_DCHG_PLN_QTY 수정
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
						
						// EQR_INLND_TRSP_PLN 로부터 PLN_SEQ 취득
						eqrInlndTrspPlnVO = new EqrInlndTrspPlnVO();
						eqrInlndTrspPlnVO.setRepoPlnId(repoPlnId);
						eqrInlndTrspPlnVO.setPlnYrwk(model.getPlnYrwk());
						eqrInlndTrspPlnVO.setTrspModCd(model.getTrspModCd());
						eqrInlndTrspPlnVO.setFmEccCd(model.getFmEccCd());
						eqrInlndTrspPlnVO.setToEccCd(model.getToEccCd());
						eqrInlndTrspPlnVO.setFmYrwk(model.getFmEtdDt().replaceAll("W",""));
						eqrInlndTrspPlnVO.setToYrwk(model.getToEtaDt().replaceAll("W",""));
						String [] plnSeqArr = dbDao.getInLndPlnSeq(eqrInlndTrspPlnVO).getResultStrArray();
						
						// EQR_INLND_TRSP_PLN_QTY 수정
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
						
						// EQR_INLND_TRSP_PLN 로부터 PLN_SEQ 취득
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
						
						// EQR_ONF_HIR_PLN 수정
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
						
						// EQR_VSL_LODG_DCHG_PLN 로부터 PLN_SEQ 취득
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
							
							// EQR_VSL_LODG_DCHG_PLN_QTY 삭제
							for (int j = 0; j < cntrTpszCdList.size(); j++) {
								eqrVslLodgDchgPlnQtyVO = new EqrVslLodgDchgPlnQtyVO();
								eqrVslLodgDchgPlnQtyVO.setRepoPlnId(repoPlnId);
								eqrVslLodgDchgPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
								eqrVslLodgDchgPlnQtyVO.setPlnSeq(plnSeq);
								eqrVslLodgDchgPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
								dbDao.deleteVesselPlanQty(eqrVslLodgDchgPlnQtyVO);
							}
							
							// EQR_VSL_LODG_DCHG_PLN 삭제
							eqrVslLodgDchgPlnVO.setPlnSeq(plnSeq);
							dbDao.deleteVesselPlan(eqrVslLodgDchgPlnVO);
						}
						
					// Inland
					} else if (model.getTablenm().equals("EQR_INLND_TRSP_PLN")) {
						
						// EQR_INLND_TRSP_PLN 로부터 PLN_SEQ 취득
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
							
							// EQR_INLND_TRSP_PLN_QTY 삭제
							for (int j = 0; j < cntrTpszCdList.size(); j++) {
								eqrInlndTrspPlnQtyVO = new EqrInlndTrspPlnQtyVO();
								eqrInlndTrspPlnQtyVO.setRepoPlnId(repoPlnId);
								eqrInlndTrspPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
								eqrInlndTrspPlnQtyVO.setPlnSeq(plnSeq);
								eqrInlndTrspPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
								dbDao.deleteInlandPlanQty(eqrInlndTrspPlnQtyVO);
							}
							
							// EQR_INLND_TRSP_PLN 삭제
							eqrInlndTrspPlnVO.setPlnSeq(plnSeq);
							dbDao.deleteInlandPlan(eqrInlndTrspPlnVO);
						}
						
					// On/Off Hire
					} else if (model.getTablenm().equals("EQR_ONF_HIR_PLN")) {
						
						// EQR_INLND_TRSP_PLN 로부터 PLN_SEQ 취득
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
							
							// EQR_ONF_HIR_PLN_QTY 삭제
							for (int j = 0; j < cntrTpszCdList.size(); j++) {
								eqrOnfHirPlnQtyVO = new EqrOnfHirPlnQtyVO();
								eqrOnfHirPlnQtyVO.setRepoPlnId(repoPlnId);
								eqrOnfHirPlnQtyVO.setPlnYrwk(model.getPlnYrwk());
								eqrOnfHirPlnQtyVO.setPlnSeq(plnSeq);
								eqrOnfHirPlnQtyVO.setCntrTpszCd(cntrTpszCdList.get(j));
								dbDao.deleteOnOffPlanQty(eqrOnfHirPlnQtyVO);
							}
							
							// EQR_ONF_HIR_PLN 삭제
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
	
}