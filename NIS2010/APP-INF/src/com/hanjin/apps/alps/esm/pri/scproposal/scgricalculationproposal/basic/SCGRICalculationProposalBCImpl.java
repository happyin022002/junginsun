/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCRateProposalBCImpl.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.25 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.integration.SCGRICalculationProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgCombo1VO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLAllListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLArbitraryListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLSubListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcRateActualCustListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.ScGriCalcVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpArbGriGrpVO;
import com.hanjin.syscommon.common.table.PriSpScpGriActCustVO;
import com.hanjin.syscommon.common.table.PriSpScpGriCmdtVO;
import com.hanjin.syscommon.common.table.PriSpScpGriGrpVO;
import com.hanjin.syscommon.common.table.PriSpScpGriRoutPntVO;
import com.hanjin.syscommon.common.table.PriSpScpGriRoutViaVO;
import com.hanjin.syscommon.common.table.PriSpScpGriRtVO;
import com.hanjin.syscommon.common.table.PriSpScpRtActCustVO;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Sungsoo, Park
 * @see UI_PRI_0030EventResponse,SCRateGuidelineBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SCGRICalculationProposalBCImpl extends BasicCommandSupport implements SCGRICalculationProposalBC {

	// Database Access Object
	private transient SCGRICalculationProposalDBDAO dbDao = null;

	/**
	 * SCRateGuidelineBCImpl 객체 생성<br>
	 * SCRateGuidelineDBDAO를 생성한다.<br>
	 */
	public SCGRICalculationProposalBCImpl() {
		dbDao = new SCGRICalculationProposalDBDAO();
	}

	/**
	 * GRI Calculation Header 리스트를 조회합니다.<br>
	 * 
	 * @param PriSpScpGriGrpVO vo
	 * @return List<RsltGriCalcGrpListVO>
	 * @exception EventException
	 */
	public List<RsltGriCalcGrpListVO> searchGRICalculationHeaderList(PriSpScpGriGrpVO vo) throws EventException {
		try {
			return dbDao.searchGRICalculationHeaderList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * GRI Calculation 리스트를 조회합니다.<br>
	 * 
	 * @param PriSpScpGriGrpVO vo
	 * @return RsltGriCalcListVO
	 * @exception EventException
	 */
	public RsltGriCalcListVO searchGRICalculationList(PriSpScpGriGrpVO vo) throws EventException {
		RsltGriCalcListVO rVo = new RsltGriCalcListVO();
		try {
			rVo.setRsltGriCalcRtListVOS(dbDao.searchGRICalculationRateList(vo));
			rVo.setRsltGriCalcCmdtListVOS(dbDao.searchGRICalculationCommodityList(vo));
			rVo.setRsltGriCalcActCustListVOS(dbDao.searchGRICalculationActualCustomerList(vo));
			rVo.setRsltGriCalcOrgPntListVOS(dbDao.searchGRICalculationRouteOriginPointList(vo));
			rVo.setRsltGriCalcOrgViaListVOS(dbDao.searchGRICalculationRouteOriginViaList(vo));
			rVo.setRsltGriCalcDestViaListVOS(dbDao.searchGRICalculationRouteDestinationViaList(vo));
			rVo.setRsltGriCalcDestPntListVOS(dbDao.searchGRICalculationRouteDestinationPointList(vo));

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * GRI Calculation 데이터의 CUD 트랜잭션을 처리합니다.<br>
	 * 
	 * @param ScGriCalcVO pVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGRICalculation(ScGriCalcVO pVo, SignOnUserAccount account) throws EventException {
		try {
			PriSpScpGriGrpVO[] grpvo = pVo.getPriSpScpGriGrpVOS();
			PriSpScpGriRtVO[] rtvo = pVo.getPriSpScpGriRtVOS();
			PriSpScpGriCmdtVO[] cmdtvo = pVo.getPriSpScpGriCmdtVOS();
			PriSpScpGriActCustVO[] custvo = pVo.getPriSpScpGriActCustVOS();
			PriSpScpGriRoutPntVO[] orgpntvo = pVo.getPriSpScpGriRoutOrgPntVOS();
			PriSpScpGriRoutViaVO[] orgviavo = pVo.getPriSpScpGriRoutOrgViaVOS();
			PriSpScpGriRoutViaVO[] destviavo = pVo.getPriSpScpGriRoutDestViaVOS();
			PriSpScpGriRoutPntVO[] destpntvo = pVo.getPriSpScpGriRoutDestPntVOS();

			List<PriSpScpGriGrpVO> insertGrpList = new ArrayList<PriSpScpGriGrpVO>();
			List<PriSpScpGriGrpVO> updateGrpList = new ArrayList<PriSpScpGriGrpVO>();
			List<PriSpScpGriGrpVO> deleteGrpList = new ArrayList<PriSpScpGriGrpVO>();
			List<PriSpScpGriRtVO> insertRtList = new ArrayList<PriSpScpGriRtVO>();
			List<PriSpScpGriRtVO> updateRtList = new ArrayList<PriSpScpGriRtVO>();
			List<PriSpScpGriRtVO> deleteRtList = new ArrayList<PriSpScpGriRtVO>();
			List<PriSpScpGriCmdtVO> insertCmdtList = new ArrayList<PriSpScpGriCmdtVO>();
			List<PriSpScpGriCmdtVO> updateCmdtList = new ArrayList<PriSpScpGriCmdtVO>();
			List<PriSpScpGriCmdtVO> deleteCmdtList = new ArrayList<PriSpScpGriCmdtVO>();
			List<PriSpScpGriActCustVO> insertCustList = new ArrayList<PriSpScpGriActCustVO>();
			List<PriSpScpGriActCustVO> updateCustList = new ArrayList<PriSpScpGriActCustVO>();
			List<PriSpScpGriActCustVO> deleteCustList = new ArrayList<PriSpScpGriActCustVO>();
			List<PriSpScpGriRoutPntVO> insertPntList = new ArrayList<PriSpScpGriRoutPntVO>();
			List<PriSpScpGriRoutPntVO> updatePntList = new ArrayList<PriSpScpGriRoutPntVO>();
			List<PriSpScpGriRoutPntVO> deletePntList = new ArrayList<PriSpScpGriRoutPntVO>();
			List<PriSpScpGriRoutViaVO> insertViaList = new ArrayList<PriSpScpGriRoutViaVO>();
			List<PriSpScpGriRoutViaVO> updateViaList = new ArrayList<PriSpScpGriRoutViaVO>();
			List<PriSpScpGriRoutViaVO> deleteViaList = new ArrayList<PriSpScpGriRoutViaVO>();

			for (int i = 0; grpvo != null && i < grpvo.length; i++) {
				if (grpvo[i].getIbflag().equals("I")) {
					grpvo[i].setCreUsrId(account.getUsr_id());
					grpvo[i].setUpdUsrId(account.getUsr_id());
					insertGrpList.add(grpvo[i]);
				} else if (grpvo[i].getIbflag().equals("U")) {
					grpvo[i].setUpdUsrId(account.getUsr_id());
					updateGrpList.add(grpvo[i]);
				} else if (grpvo[i].getIbflag().equals("D")) {
					grpvo[i].setUpdUsrId(account.getUsr_id());
					deleteGrpList.add(grpvo[i]);
				}
			}
			for (int i = 0; rtvo != null && i < rtvo.length; i++) {
				if (rtvo[i].getIbflag().equals("I")) {
					rtvo[i].setCreUsrId(account.getUsr_id());
					rtvo[i].setUpdUsrId(account.getUsr_id());
					insertRtList.add(rtvo[i]);
				} else if (rtvo[i].getIbflag().equals("U")) {
					rtvo[i].setUpdUsrId(account.getUsr_id());
					updateRtList.add(rtvo[i]);
				} else if (rtvo[i].getIbflag().equals("D")) {
					deleteRtList.add(rtvo[i]);
				}
			}
			for (int i = 0; cmdtvo != null && i < cmdtvo.length; i++) {
				if (cmdtvo[i].getIbflag().equals("I")) {
					cmdtvo[i].setCreUsrId(account.getUsr_id());
					cmdtvo[i].setUpdUsrId(account.getUsr_id());
					insertCmdtList.add(cmdtvo[i]);
				} else if (cmdtvo[i].getIbflag().equals("U")) {
					cmdtvo[i].setUpdUsrId(account.getUsr_id());
					updateCmdtList.add(cmdtvo[i]);
				} else if (cmdtvo[i].getIbflag().equals("D")) {
					cmdtvo[i].setUpdUsrId(account.getUsr_id());
					deleteCmdtList.add(cmdtvo[i]);
				}
			}
			for (int i = 0; custvo != null && i < custvo.length; i++) {
				if (custvo[i].getIbflag().equals("I")) {
					custvo[i].setCreUsrId(account.getUsr_id());
					custvo[i].setUpdUsrId(account.getUsr_id());
					insertCustList.add(custvo[i]);
				} else if (custvo[i].getIbflag().equals("U")) {
					custvo[i].setUpdUsrId(account.getUsr_id());
					updateCustList.add(custvo[i]);
				} else if (custvo[i].getIbflag().equals("D")) {
					custvo[i].setUpdUsrId(account.getUsr_id());
					deleteCustList.add(custvo[i]);
				}
			}
			for (int i = 0; orgpntvo != null && i < orgpntvo.length; i++) {
				if (orgpntvo[i].getIbflag().equals("I")) {
					orgpntvo[i].setCreUsrId(account.getUsr_id());
					orgpntvo[i].setUpdUsrId(account.getUsr_id());
					insertPntList.add(orgpntvo[i]);
				} else if (orgpntvo[i].getIbflag().equals("U")) {
					orgpntvo[i].setUpdUsrId(account.getUsr_id());
					updatePntList.add(orgpntvo[i]);
				} else if (orgpntvo[i].getIbflag().equals("D")) {
					deletePntList.add(orgpntvo[i]);
				}
			}
			for (int i = 0; orgviavo != null && i < orgviavo.length; i++) {
				if (orgviavo[i].getIbflag().equals("I")) {
					orgviavo[i].setCreUsrId(account.getUsr_id());
					orgviavo[i].setUpdUsrId(account.getUsr_id());
					insertViaList.add(orgviavo[i]);
				} else if (orgviavo[i].getIbflag().equals("U")) {
					orgviavo[i].setUpdUsrId(account.getUsr_id());
					updateViaList.add(orgviavo[i]);
				} else if (orgviavo[i].getIbflag().equals("D")) {
					deleteViaList.add(orgviavo[i]);
				}
			}
			for (int i = 0; destviavo != null && i < destviavo.length; i++) {
				if (destviavo[i].getIbflag().equals("I")) {
					destviavo[i].setCreUsrId(account.getUsr_id());
					destviavo[i].setUpdUsrId(account.getUsr_id());
					insertViaList.add(destviavo[i]);
				} else if (destviavo[i].getIbflag().equals("U")) {
					destviavo[i].setUpdUsrId(account.getUsr_id());
					updateViaList.add(destviavo[i]);
				} else if (destviavo[i].getIbflag().equals("D")) {
					deleteViaList.add(destviavo[i]);
				}
			}
			for (int i = 0; destpntvo != null && i < destpntvo.length; i++) {
				if (destpntvo[i].getIbflag().equals("I")) {
					destpntvo[i].setCreUsrId(account.getUsr_id());
					destpntvo[i].setUpdUsrId(account.getUsr_id());
					insertPntList.add(destpntvo[i]);
				} else if (destpntvo[i].getIbflag().equals("U")) {
					destpntvo[i].setUpdUsrId(account.getUsr_id());
					updatePntList.add(destpntvo[i]);
				} else if (destpntvo[i].getIbflag().equals("D")) {
					deletePntList.add(destpntvo[i]);
				}
			}

			if (deleteViaList.size() > 0) {
				dbDao.removeProposalGRICalculationRouteVia(deleteViaList);
			}
			if (deletePntList.size() > 0) {
				dbDao.removeProposalGRICalculationRoutePoint(deletePntList);
			}
			if (deleteCustList.size() > 0) {
				dbDao.removeProposalGRICalculationActualCustomer(deleteCustList);
			}
			if (deleteCmdtList.size() > 0) {
				dbDao.removeProposalGRICalculationCommodity(deleteCmdtList);
			}
			if (deleteRtList.size() > 0) {
				dbDao.removeProposalGRICalculationRate(deleteRtList);
			}
			if (deleteGrpList.size() > 0) {
				dbDao.removeProposalGRICalculationGroupCascadeRt(deleteGrpList);
				dbDao.removeProposalGRICalculationGroupCascadeRoutVia(deleteGrpList);
				dbDao.removeProposalGRICalculationGroupCascadeRoutPnt(deleteGrpList);
				dbDao.removeProposalGRICalculationGroupCascadeActCust(deleteGrpList);
				dbDao.removeProposalGRICalculationGroupCascadeCmdt(deleteGrpList);
				dbDao.removeProposalGRICalculationGroup(deleteGrpList);
			}

			if (insertGrpList.size() > 0) {
				dbDao.addProposalGRICalculationGroup(insertGrpList);
			}
			if (insertRtList.size() > 0) {
				dbDao.addProposalGRICalculationRate(insertRtList);
			}
			if (insertCmdtList.size() > 0) {
				dbDao.addProposalGRICalculationCommodity(insertCmdtList);
			}
			if (insertCustList.size() > 0) {
				dbDao.addProposalGRICalculationActualCustomer(insertCustList);
			}
			if (insertPntList.size() > 0) {
				dbDao.addProposalGRICalculationRoutePoint(insertPntList);
			}
			if (insertViaList.size() > 0) {
				dbDao.addProposalGRICalculationRouteVia(insertViaList);
			}

			if (updateGrpList.size() > 0) {
				dbDao.modifyProposalGRICalculationGroup(updateGrpList);
			}
			if (updateRtList.size() > 0) {
				dbDao.modifyProposalGRICalculationRate(updateRtList);
			}
			if (updateCmdtList.size() > 0) {
				dbDao.modifyProposalGRICalculationCommodity(updateCmdtList);
			}
			if (updateCustList.size() > 0) {
				dbDao.modifyProposalGRICalculationActualCustomer(updateCustList);
			}
			if (updatePntList.size() > 0) {
				dbDao.modifyProposalGRICalculationRoutePoint(updatePntList);
			}
			if (updateViaList.size() > 0) {
				dbDao.modifyProposalGRICalculationRouteVia(updateViaList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}
    /**
     * GRI Calculation Apply Flag 처리합니다.<br>
     * 
     * @param ScGriCalcVO pVo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageGRIApplyFlag(PriSpScpGriGrpVO pVo, SignOnUserAccount account) throws EventException {
 
        
        try {
            if( pVo != null  ){
                pVo.setUpdUsrId(account.getUsr_id());
            
                dbDao.modifyProposalGRICalculationGroupApplyFlg(pVo);
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        }
    }
	/************************************** ESM_PRI_0109 Start *******************************************/
	/**
	 * GRI Calculation - Arbitrary 화면에서 콤보 필터를 위해 전체 콤보 데이터를 조회한다.<br>
	 * 
	 * @param PriSpScpTrspAddChgCombo1VO vo
	 * @return List<PriSpScpTrspAddChgCombo1VO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgCombo1VO> searchPriSpScpTrspAddChgCombo1VOs(PriSpScpTrspAddChgCombo1VO vo)
			throws EventException {
		try {
			return dbDao.searchPriSpScpTrspAddChgCombo1VOs(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * GRI Calculation - Arbitrary 화면에서의 적용 GRI(상단그리드)를 조회한다.<br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLListVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgGriArbOKCLListVO> searchPriSpScpTrspAddChgGriArbOKCLList(
			PriSpScpTrspAddChgGriArbOKCLListVO vo) throws EventException {
		try {
			return dbDao.searchPriSpScpTrspAddChgGriArbOKCLList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * GRI Calculation - Arbitrary 화면에서의 적용 GRI 옵션(하단그리드)를 조회한다.<br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLSubListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLSubListVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgGriArbOKCLSubListVO> searchPriSpScpTrspAddChgGriArbOKCLSubList(
			PriSpScpTrspAddChgGriArbOKCLSubListVO vo) throws EventException {
		try {
			return dbDao.searchPriSpScpTrspAddChgGriArbOKCLSubList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용시 적용할 모든 GRI 와 옵션을 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLAllListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLAllListVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgGriArbOKCLAllListVO> searchPriSpScpTrspAddChgGriArbOKCLAllList(
			PriSpScpTrspAddChgGriArbOKCLAllListVO vo) throws EventException {
		try {
			return dbDao.searchPriSpScpTrspAddChgGriArbOKCLAllList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용시 모든 Arbitrary 항목을 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLArbitraryListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLArbitraryListVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgGriArbOKCLArbitraryListVO> searchPriSpScpTrspAddChgGriArbOKCLArbitraryList(
			PriSpScpTrspAddChgGriArbOKCLArbitraryListVO vo) throws EventException {
		try {
			return dbDao.searchPriSpScpTrspAddChgGriArbOKCLArbitraryList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 항목을 저장한다. <br>
	 * 
	 * @param PriSpScpArbGriGrpVO[] pVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriSpScpArbGriGrpVOS(PriSpScpArbGriGrpVO[] pVO, SignOnUserAccount account) throws EventException {
		List<PriSpScpArbGriGrpVO> insertVoList = new ArrayList<PriSpScpArbGriGrpVO>();
		List<PriSpScpArbGriGrpVO> updateGrpList = new ArrayList<PriSpScpArbGriGrpVO>();
		List<PriSpScpArbGriGrpVO> deleteGrpList = new ArrayList<PriSpScpArbGriGrpVO>();
		try {
			for (int i = 0; pVO != null && i < pVO.length; i++) {
				if (pVO[i].getIbflag().equals("I")) {
					pVO[i].setCreUsrId(account.getUsr_id());
					pVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(pVO[i]);
				} else if (pVO[i].getIbflag().equals("U")) {
					pVO[i].setUpdUsrId(account.getUsr_id());
					updateGrpList.add(pVO[i]);
				} else if (pVO[i].getIbflag().equals("D")) {
					pVO[i].setUpdUsrId(account.getUsr_id());
					deleteGrpList.add(pVO[i]);
				}
			}
			if (insertVoList.size() > 0) { // 입력
				dbDao.addProposalGRICalculationArbGroup(insertVoList);
			}
			if (updateGrpList.size() > 0) { // 수정
				dbDao.modifyProposalGRICalculationArbGroup(updateGrpList);
			}
			if (deleteGrpList.size() > 0) {
				// PriSpScpArbGriRt 디테일데이터 삭제
				dbDao.removeProposalGRICalculationArbRt(deleteGrpList, "1"); // gri_grp_seq 조건, gri_adj_seq 조건없음
				// PriSpScpArbGriGrp 마스터데이터 삭제
				dbDao.removeProposalGRICalculationArbGroup(deleteGrpList, "1"); // gri_grp_seq 조건
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 옵션 항목을 저장한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLSubListVO[] pVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriSpScpArbGriRtVOS(PriSpScpTrspAddChgGriArbOKCLSubListVO[] pVO, SignOnUserAccount account)
			throws EventException {
		List<PriSpScpTrspAddChgGriArbOKCLSubListVO> insertVoList = new ArrayList<PriSpScpTrspAddChgGriArbOKCLSubListVO>();
		List<PriSpScpTrspAddChgGriArbOKCLSubListVO> updateGrpList = new ArrayList<PriSpScpTrspAddChgGriArbOKCLSubListVO>();
		List<PriSpScpArbGriGrpVO> deleteGrpList = new ArrayList<PriSpScpArbGriGrpVO>();
		PriSpScpArbGriGrpVO tmpVo = null;
		try {
			for (int i = 0; pVO != null && i < pVO.length; i++) {
				pVO[i].setCreUsrId(account.getUsr_id());
				pVO[i].setUpdUsrId(account.getUsr_id());
				if (i == 0) { // 마스터 옵션 up
					dbDao.modifyProposalGRICalculationArbGroupOption(pVO[i]);
				}
				if (pVO[i].getIbflag().equals("I")) {
					insertVoList.add(pVO[i]);
				} else if (pVO[i].getIbflag().equals("U")) {
					updateGrpList.add(pVO[i]);
				} else if (pVO[i].getIbflag().equals("D")) {
					tmpVo = new PriSpScpArbGriGrpVO();
					ObjectCloner.build(pVO[i], tmpVo);
					deleteGrpList.add(tmpVo);
				}
			}
			if (insertVoList.size() > 0) { // 입력
				dbDao.addProposalGRICalculationArbRt(insertVoList);
			}
			if (updateGrpList.size() > 0) { // 수정
				dbDao.modifyProposalGRICalculationArbRt(updateGrpList);
			}
			if (deleteGrpList.size() > 0) { // 삭제
				dbDao.removeProposalGRICalculationArbRt(deleteGrpList, "2"); // gri_grp_seq, gri_adj_seq 조건있음
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO[] pVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriSpScpTrspAddChgGriArbOKCLListVOS(PriSpScpTrspAddChgGriArbOKCLListVO[] pVO,
			SignOnUserAccount account) throws EventException {
		try {
			for (int i = 0; pVO != null && i < pVO.length; i++) {
				if (pVO[i].getIbflag().equals("U")) {
					pVO[i].setUpdUsrId(account.getUsr_id());
					/*
					dbDao.modifyProposalGRICalculationArbGroup3(pVO[i]); // Arbitrary 항목 적용
					=>책임변경
					SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
					command1.modifyProposalGRICalculationArbOK(event.getPriSpScpTrspAddChgGriArbOKCLListVOS(), account);
					*/
					pVO[i].setGriApplFlg("Y");
					dbDao.modifyProposalGRICalculationArbGroupStatus(pVO[i]); // GRI 항목에 적용여부 수정
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용 취소를 한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO[] pVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriSpScpTrspAddChgGriArbOKCLCancleListVOS(PriSpScpTrspAddChgGriArbOKCLListVO[] pVO, SignOnUserAccount account) throws EventException {
		try {
			List<PriSpScpTrspAddChgGriArbOKCLListVO> deleteGrpList = new ArrayList<PriSpScpTrspAddChgGriArbOKCLListVO>();
			List<PriSpScpArbGriGrpVO> deleteRtList = new ArrayList<PriSpScpArbGriGrpVO>();
			PriSpScpArbGriGrpVO tmpDGrpVo = null;
			
			for (int i = 0; pVO != null && i < pVO.length; i++) {
				if (pVO[i].getIbflag().equals("U")) {
					pVO[i].setUpdUsrId(account.getUsr_id());
					/*
					dbDao.modifyProposalGRICalculationArbCancel(pVO[i]); // Arbitrary 항목 되돌리기.
					책임변경
					*/
					deleteGrpList.add(pVO[i]);
					
					tmpDGrpVo = new PriSpScpArbGriGrpVO();
					ObjectCloner.build(pVO[i], tmpDGrpVo);
					deleteRtList.add(tmpDGrpVo);
					
				}
			}
			
			if (deleteRtList.size() > 0) {
				// PriSpScpArbGriRt 디테일데이터 삭제
				dbDao.removeProposalGRICalculationArbRt(deleteRtList, "ALL"); // gri_grp_seq, gri_adj_seq 조건없음
				// PriSpScpArbGriGrp 마스터데이터 삭제
				dbDao.removeProposalGRICalculationArbGroup(deleteRtList, "ALL");
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/************************************** ESM_PRI_0109 End *******************************************/

	/**
	 * Init Cancel시 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.removeProposalActCust(priSpMnVO);
			dbDao.removeProposalCmdt(priSpMnVO);
			dbDao.removeProposalRoutPnt(priSpMnVO);
			dbDao.removeProposalRoutVia(priSpMnVO);
			dbDao.removeProposalRt(priSpMnVO);
			dbDao.removeProposalGrp(priSpMnVO);
			dbDao.removeProposalArbRt(priSpMnVO);
			dbDao.removeProposalArbGrp(priSpMnVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}
	
	
    /**
     * GRI Calculation - Actual Customer List을 조회한다. <br>
     * 
     * @param PriSpScpRtActCustVO vo
     * @return List<RsltGriCalcRateActualCustListVO>
     * @exception EventException
     */
    public List<RsltGriCalcRateActualCustListVO> searchGriCalcRateActualCustList(
            PriSpScpRtActCustVO vo) throws EventException {
        try {
            return dbDao.searchGriCalcRateActualCustList(vo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    
    

    /**
     * GRI Calculation 데이터의 COPY 트랜잭션을 처리합니다.<br>
     * 
     * @param ScGriCalcVO pVo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageGRICopy(ScGriCalcVO pVo, SignOnUserAccount account) throws EventException {
        try {
            PriSpScpGriGrpVO[] grpvo = pVo.getPriSpScpGriGrpVOS();
            List<PriSpScpGriGrpVO> grpList = new ArrayList<PriSpScpGriGrpVO>();

            for (int i = 0; grpvo != null && i < grpvo.length; i++) {
                grpvo[i].setCreUsrId(account.getUsr_id());
                grpList.add(grpvo[i]);
            }
            
            if (grpList.size() > 0) {
                dbDao.copyProposalGRICalculationGrp(grpList);
                dbDao.copyProposalGRICalculationCmdt(grpList);
                dbDao.copyProposalGRICalculationActCust(grpList);
                dbDao.copyProposalGRICalculationRoutePnt(grpList);
                dbDao.copyProposalGRICalculationRouteVia(grpList);
                dbDao.copyProposalGRICalculationRt(grpList);
            }
            

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        }
    }
    
    

    /**
     * GRI Calculation 데이터의 REMOVE 트랜잭션을 처리합니다.<br>
     * 
     * @param ScGriCalcVO pVo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeGRICopy(ScGriCalcVO pVo, SignOnUserAccount account) throws EventException {
        try {
            PriSpScpGriGrpVO[] grpvo = pVo.getPriSpScpGriGrpVOS();
            List<PriSpScpGriGrpVO> grpList = new ArrayList<PriSpScpGriGrpVO>();

            for (int i = 0; grpvo != null && i < grpvo.length; i++) {
                grpvo[i].setCreUsrId(account.getUsr_id());
                grpList.add(grpvo[i]);
            }
            
            if (grpList.size() > 0) {

                dbDao.removeProposalGRICalculationRtCpy(grpList);
                dbDao.removeProposalGRICalculationRoutePntCpy(grpList);
                dbDao.removeProposalGRICalculationRouteViaCpy(grpList);
                dbDao.removeProposalGRICalculationActCustCpy(grpList);
                dbDao.removeProposalGRICalculationCmdtCpy(grpList);
                dbDao.removeProposalGRICalculationGrpCpy(grpList);

            }
            

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        }
    }    

 
    
    

    /**
     * GRI Calculation 데이터의 PASTE 트랜잭션을 처리합니다.<br>
     * 
     * @param PriSpScpGriGrpVO pVo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageGRIPaste(PriSpScpGriGrpVO pVo, SignOnUserAccount account) throws EventException {
        try {
             List<PriSpScpGriGrpVO> grpList = new ArrayList<PriSpScpGriGrpVO>();

             if (pVo != null ) {
                 pVo.setCreUsrId(account.getUsr_id());
                 grpList.add(pVo);
             }
            
            if (grpList.size() > 0) {
                dbDao.pasteProposalGRICalculationGrp(grpList);
                dbDao.pasteProposalGRICalculationCmdt(grpList);
                dbDao.pasteProposalGRICalculationActCust(grpList);
                dbDao.pasteProposalGRICalculationRoutePnt(grpList);
                dbDao.pasteProposalGRICalculationRouteVia(grpList);
                dbDao.pasteProposalGRICalculationRt(grpList);
            }
            

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        }
    }
    
        

    /**
     * GRI Calculation 데이터의 REMOVE 트랜잭션을 처리합니다.<br>
     * 
     * @param ScGriCalcVO pVo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeGRIAll(PriSpScpGriGrpVO pVo, SignOnUserAccount account) throws EventException {
        try {
 
            if (pVo != null ) {
 
                dbDao.removeProposalGRIRtAll(pVo);
                dbDao.removeProposalGRIRoutPntAll(pVo);
                dbDao.removeProposalGRIRoutViaAll(pVo);
                dbDao.removeProposalGRIActCustAll(pVo);
                dbDao.removeProposalGRICmdtAll(pVo);
                dbDao.removeProposalGRIGrpAll(pVo);

            }
            

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        }
    }    

    
}