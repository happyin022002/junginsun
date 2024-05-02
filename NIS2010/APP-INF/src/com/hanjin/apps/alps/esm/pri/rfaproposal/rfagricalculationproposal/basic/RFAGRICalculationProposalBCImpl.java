/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAGRICalculationProposalBCImpl.java
 *@FileTitle : RFAGRICalculationProposalBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.25
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.25 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.integration.RFAGRICalculationProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.vo.RfaGriCalcVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpGriActCustVO;
import com.hanjin.syscommon.common.table.PriRpScpGriCmdtVO;
import com.hanjin.syscommon.common.table.PriRpScpGriGrpVO;
import com.hanjin.syscommon.common.table.PriRpScpGriRoutPntVO;
import com.hanjin.syscommon.common.table.PriRpScpGriRoutViaVO;
import com.hanjin.syscommon.common.table.PriRpScpGriRtVO;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Sungsoo, Park
 * @see UI_PRI_0030EventResponse,SCRateGuidelineBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class RFAGRICalculationProposalBCImpl extends BasicCommandSupport implements RFAGRICalculationProposalBC {

	// Database Access Object
	private transient RFAGRICalculationProposalDBDAO dbDao = null;

	/**
	 * RFAGRICalculationProposalBCImpl 객체 생성<br>
	 * RFAGRICalculationProposalDBDAO 생성한다.<br>
	 */
	public RFAGRICalculationProposalBCImpl() {
		dbDao = new RFAGRICalculationProposalDBDAO();
	}

	/**
	 * GRI Calculation Header 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return List<RsltGriCalcGrpListVO>
	 * @exception EventException
	 */
	public List<RsltGriCalcGrpListVO> searchGRICalculationHeaderList(PriRpScpGriGrpVO priRpScpGriGrpVO)
			throws EventException {
		try {
			return dbDao.searchGRICalculationHeaderList(priRpScpGriGrpVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * GRI Calculation 리스트를 조회합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return RsltGriCalcListVO
	 * @exception EventException
	 */
	public RsltGriCalcListVO searchGRICalculationList(PriRpScpGriGrpVO priRpScpGriGrpVO) throws EventException {
		RsltGriCalcListVO rVo = new RsltGriCalcListVO();
		try {
			rVo.setRsltGriCalcRtListVOS(dbDao.searchGRICalculationRateList(priRpScpGriGrpVO));
			rVo.setRsltGriCalcCmdtListVOS(dbDao.searchGRICalculationCommodityList(priRpScpGriGrpVO));
			rVo.setRsltGriCalcActCustListVOS(dbDao.searchGRICalculationActualCustomerList(priRpScpGriGrpVO));
			rVo.setRsltGriCalcOrgPntListVOS(dbDao.searchGRICalculationRouteOriginPointList(priRpScpGriGrpVO));
			rVo.setRsltGriCalcOrgViaListVOS(dbDao.searchGRICalculationRouteOriginViaList(priRpScpGriGrpVO));
			rVo.setRsltGriCalcDestViaListVOS(dbDao.searchGRICalculationRouteDestinationViaList(priRpScpGriGrpVO));
			rVo.setRsltGriCalcDestPntListVOS(dbDao.searchGRICalculationRouteDestinationPointList(priRpScpGriGrpVO));

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * GRI Calculation 데이터의 CUD 트랜잭션을 처리합니다.<br>
	 * 
	 * @param RfaGriCalcVO rfaGriCalcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGRICalculation(RfaGriCalcVO rfaGriCalcVO, SignOnUserAccount account) throws EventException {
		try {
			PriRpScpGriGrpVO[] grpvo = rfaGriCalcVO.getPriRpScpGriGrpVOS();
			PriRpScpGriRtVO[] rtvo = rfaGriCalcVO.getPriRpScpGriRtVOS();
			PriRpScpGriCmdtVO[] cmdtvo = rfaGriCalcVO.getPriRpScpGriCmdtVOS();
			PriRpScpGriActCustVO[] custvo = rfaGriCalcVO.getPriRpScpGriActCustVOS();
			PriRpScpGriRoutPntVO[] orgpntvo = rfaGriCalcVO.getPriRpScpGriRoutOrgPntVOS();
			PriRpScpGriRoutViaVO[] orgviavo = rfaGriCalcVO.getPriRpScpGriRoutOrgViaVOS();
			PriRpScpGriRoutViaVO[] destviavo = rfaGriCalcVO.getPriRpScpGriRoutDestViaVOS();
			PriRpScpGriRoutPntVO[] destpntvo = rfaGriCalcVO.getPriRpScpGriRoutDestPntVOS();

			List<PriRpScpGriGrpVO> insertGrpList = new ArrayList<PriRpScpGriGrpVO>();
			List<PriRpScpGriGrpVO> updateGrpList = new ArrayList<PriRpScpGriGrpVO>();
			List<PriRpScpGriGrpVO> deleteGrpList = new ArrayList<PriRpScpGriGrpVO>();
			List<PriRpScpGriRtVO> insertRtList = new ArrayList<PriRpScpGriRtVO>();
			List<PriRpScpGriRtVO> updateRtList = new ArrayList<PriRpScpGriRtVO>();
			List<PriRpScpGriRtVO> deleteRtList = new ArrayList<PriRpScpGriRtVO>();
			List<PriRpScpGriCmdtVO> insertCmdtList = new ArrayList<PriRpScpGriCmdtVO>();
			List<PriRpScpGriCmdtVO> updateCmdtList = new ArrayList<PriRpScpGriCmdtVO>();
			List<PriRpScpGriCmdtVO> deleteCmdtList = new ArrayList<PriRpScpGriCmdtVO>();
			List<PriRpScpGriActCustVO> insertCustList = new ArrayList<PriRpScpGriActCustVO>();
			List<PriRpScpGriActCustVO> updateCustList = new ArrayList<PriRpScpGriActCustVO>();
			List<PriRpScpGriActCustVO> deleteCustList = new ArrayList<PriRpScpGriActCustVO>();
			List<PriRpScpGriRoutPntVO> insertPntList = new ArrayList<PriRpScpGriRoutPntVO>();
			List<PriRpScpGriRoutPntVO> updatePntList = new ArrayList<PriRpScpGriRoutPntVO>();
			List<PriRpScpGriRoutPntVO> deletePntList = new ArrayList<PriRpScpGriRoutPntVO>();
			List<PriRpScpGriRoutViaVO> insertViaList = new ArrayList<PriRpScpGriRoutViaVO>();
			List<PriRpScpGriRoutViaVO> updateViaList = new ArrayList<PriRpScpGriRoutViaVO>();
			List<PriRpScpGriRoutViaVO> deleteViaList = new ArrayList<PriRpScpGriRoutViaVO>();

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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.removeProposalGriActCust(priRpMnVO);
			dbDao.removeProposalGriCmdt(priRpMnVO);
			dbDao.removeProposalGriRoutPnt(priRpMnVO);
			dbDao.removeProposalGriRoutVia(priRpMnVO);
			dbDao.removeProposalGriRt(priRpMnVO);
			dbDao.removeProposalGriGrp(priRpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}
	

	/**
	 * GRI Calculation 데이터의 CUD 트랜잭션을 처리합니다.<br>
	 * 
	 * @param RfaGriCalcVO rfaGriCalcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGRICalculationForIHC(RfaGriCalcVO rfaGriCalcVO, SignOnUserAccount account) throws EventException {
		try {
			PriRpScpGriGrpVO[] grpvo = rfaGriCalcVO.getPriRpScpGriGrpVOS();
			PriRpScpGriRtVO[] rtvo = rfaGriCalcVO.getPriRpScpGriRtVOS();
			PriRpScpGriCmdtVO[] cmdtvo = rfaGriCalcVO.getPriRpScpGriCmdtVOS();
			PriRpScpGriActCustVO[] custvo = rfaGriCalcVO.getPriRpScpGriActCustVOS();
			PriRpScpGriRoutPntVO[] orgpntvo = rfaGriCalcVO.getPriRpScpGriRoutOrgPntVOS();
			PriRpScpGriRoutViaVO[] orgviavo = rfaGriCalcVO.getPriRpScpGriRoutOrgViaVOS();
			PriRpScpGriRoutViaVO[] destviavo = rfaGriCalcVO.getPriRpScpGriRoutDestViaVOS();
			PriRpScpGriRoutPntVO[] destpntvo = rfaGriCalcVO.getPriRpScpGriRoutDestPntVOS();

			List<PriRpScpGriGrpVO> insertGrpList = new ArrayList<PriRpScpGriGrpVO>();
			List<PriRpScpGriGrpVO> updateGrpList = new ArrayList<PriRpScpGriGrpVO>();
			List<PriRpScpGriGrpVO> deleteGrpList = new ArrayList<PriRpScpGriGrpVO>();
			List<PriRpScpGriRtVO> insertRtList = new ArrayList<PriRpScpGriRtVO>();
			List<PriRpScpGriRtVO> updateRtList = new ArrayList<PriRpScpGriRtVO>();
			List<PriRpScpGriRtVO> deleteRtList = new ArrayList<PriRpScpGriRtVO>();
			List<PriRpScpGriCmdtVO> insertCmdtList = new ArrayList<PriRpScpGriCmdtVO>();
			List<PriRpScpGriCmdtVO> updateCmdtList = new ArrayList<PriRpScpGriCmdtVO>();
			List<PriRpScpGriCmdtVO> deleteCmdtList = new ArrayList<PriRpScpGriCmdtVO>();
			List<PriRpScpGriActCustVO> insertCustList = new ArrayList<PriRpScpGriActCustVO>();
			List<PriRpScpGriActCustVO> updateCustList = new ArrayList<PriRpScpGriActCustVO>();
			List<PriRpScpGriActCustVO> deleteCustList = new ArrayList<PriRpScpGriActCustVO>();
			List<PriRpScpGriRoutPntVO> insertPntList = new ArrayList<PriRpScpGriRoutPntVO>();
			List<PriRpScpGriRoutPntVO> updatePntList = new ArrayList<PriRpScpGriRoutPntVO>();
			List<PriRpScpGriRoutPntVO> deletePntList = new ArrayList<PriRpScpGriRoutPntVO>();
			List<PriRpScpGriRoutViaVO> insertViaList = new ArrayList<PriRpScpGriRoutViaVO>();
			List<PriRpScpGriRoutViaVO> updateViaList = new ArrayList<PriRpScpGriRoutViaVO>();
			List<PriRpScpGriRoutViaVO> deleteViaList = new ArrayList<PriRpScpGriRoutViaVO>();

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

}