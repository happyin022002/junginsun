/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCRateProposalBCImpl.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.integration.SCGRICalculationProposalDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgCombo1VO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLAllListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLArbitraryListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLSubListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.ScGriCalcVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpArbGriGrpVO;
import com.clt.syscommon.common.table.PriSpScpGriActCustVO;
import com.clt.syscommon.common.table.PriSpScpGriCmdtVO;
import com.clt.syscommon.common.table.PriSpScpGriGrpVO;
import com.clt.syscommon.common.table.PriSpScpGriRoutPntVO;
import com.clt.syscommon.common.table.PriSpScpGriRoutViaVO;
import com.clt.syscommon.common.table.PriSpScpGriRtVO;

/**
 * SCGuideline Business Logic Basic Command implementation<br>
 * - handling biz logic about SCGuideline <br>
 * 
 * @author  
 * @see UI_PRI_0030EventResponse,SCRateGuidelineBC reference each DAO class
 * @since J2EE 1.4
 */

public class SCGRICalculationProposalBCImpl extends BasicCommandSupport implements SCGRICalculationProposalBC {

	// Database Access Object
	private transient SCGRICalculationProposalDBDAO dbDao = null;

	/**
	 * SCRateGuidelineBCImpl object creation<br>
	 * creating SCRateGuidelineDBDAO<br>
	 */
	public SCGRICalculationProposalBCImpl() {
		dbDao = new SCGRICalculationProposalDBDAO();
	}

	/**
	 * retrieving GRI Calculation Header list<br>
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
	 * retrieving GRI Calculation list<br>
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
	 * handling GRI Calculation data CUD transaction<br>
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

	/************************************** ESM_PRI_0109 Start *******************************************/
	/**
	 * GRI Calculation - retrieving all combo data for combo filter on Arbitrary screen<br>
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
	 * GRI Calculation - retrieving apply GRI(upper grid) on Arbitrary screen<br>
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
	 * GRI Calculation - retrieving apply GRI(lower grid) on Arbitrary screen<br>
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
	 * GRI Calculation - retrieving ALL GRI and option on Arbitrary screen <br>
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
	 * GRI Calculation - retrieving ALL Arbitrary item for applying GRI on Arbitrary screen <br>
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
	 * GRI Calculation - saving GRI item on Arbitrary screen <br>
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
			if (insertVoList.size() > 0) {  
				dbDao.addProposalGRICalculationArbGroup(insertVoList);
			}
			if (updateGrpList.size() > 0) { 
				dbDao.modifyProposalGRICalculationArbGroup(updateGrpList);
			}
			if (deleteGrpList.size() > 0) {

				dbDao.removeProposalGRICalculationArbRt(deleteGrpList, "1"); 

				dbDao.removeProposalGRICalculationArbGroup(deleteGrpList, "1"); 
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
	 * GRI Calculation - saving GRI option item on Arbitrary screen <br>
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
				if (i == 0) {  
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
			if (insertVoList.size() > 0) {  
				dbDao.addProposalGRICalculationArbRt(insertVoList);
			}
			if (updateGrpList.size() > 0) { 
				dbDao.modifyProposalGRICalculationArbRt(updateGrpList);
			}
			if (deleteGrpList.size() > 0) {  
				dbDao.removeProposalGRICalculationArbRt(deleteGrpList, "2");  
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
	 * GRI Calculation - applying GRI on Arbitrary screen <br>
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

					pVO[i].setGriApplFlg("Y");
					dbDao.modifyProposalGRICalculationArbGroupStatus(pVO[i]); 
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
	 * GRI Calculation - GRI applying cancel on Arbitrary screen<br>
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

					deleteGrpList.add(pVO[i]);
					
					tmpDGrpVo = new PriSpScpArbGriGrpVO();
					ObjectCloner.build(pVO[i], tmpDGrpVo);
					deleteRtList.add(tmpDGrpVo);
					
				}
			}
			
			if (deleteRtList.size() > 0) {

				dbDao.removeProposalGRICalculationArbRt(deleteRtList, "ALL"); 

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
	 * when init cancel, deleting all data<br>
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

}