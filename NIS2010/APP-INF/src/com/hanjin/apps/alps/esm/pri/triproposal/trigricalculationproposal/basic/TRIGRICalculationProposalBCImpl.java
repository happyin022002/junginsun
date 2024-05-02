/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TRIGRICalculationProposalBCImpl.java
 *@FileTitle : TRI GRI Calculation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.10
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.12.10 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.trigricalculationproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.triproposal.trigricalculationproposal.integration.TRIGRICalculationProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.trigricalculationproposal.vo.TriGriCalcVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTriGriCmdtVO;
import com.hanjin.syscommon.common.table.PriTriGriGrpVO;
import com.hanjin.syscommon.common.table.PriTriGriRoutPntVO;
import com.hanjin.syscommon.common.table.PriTriGriRoutViaVO;
import com.hanjin.syscommon.common.table.PriTriGriRtVO;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Sungsoo, Park
 * @see UI_PRI_3010EventResponse,TRIGRICalculationProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class TRIGRICalculationProposalBCImpl extends BasicCommandSupport implements TRIGRICalculationProposalBC {

	// Database Access Object
	private transient TRIGRICalculationProposalDBDAO dbDao = null;

	/**
	 * TRIGRICalculationProposalBCImpl 객체 생성<br>
	 * TRIGRICalculationProposalDBDAO를 생성한다.<br>
	 */
	public TRIGRICalculationProposalBCImpl() {
		dbDao = new TRIGRICalculationProposalDBDAO();
	}

	/**
	 * GRI Calculation Header 리스트를 조회합니다.<br>
	 * 
	 * @param PriTriGriGrpVO vo
	 * @return List<RsltGriCalcGrpListVO>
	 * @exception EventException
	 */
	public List<RsltGriCalcGrpListVO> searchGRICalculationHeaderList(PriTriGriGrpVO vo) throws EventException {
		try {
			return dbDao.searchGRICalculationHeaderList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * GRI Calculation 리스트를 조회합니다.<br>
	 * 
	 * @param PriTriGriGrpVO vo
	 * @return RsltGriCalcListVO
	 * @exception EventException
	 */
	public RsltGriCalcListVO searchGRICalculationList(PriTriGriGrpVO vo) throws EventException {
		RsltGriCalcListVO rVo = new RsltGriCalcListVO();
		try {
			rVo.setRsltGriCalcRtListVOS(dbDao.searchGRICalculationRateList(vo));
			rVo.setRsltGriCalcCmdtListVOS(dbDao.searchGRICalculationCommodityList(vo));
			rVo.setRsltGriCalcOrgPntListVOS(dbDao.searchGRICalculationRouteOriginPointList(vo));
			rVo.setRsltGriCalcOrgViaListVOS(dbDao.searchGRICalculationRouteOriginViaList(vo));
			rVo.setRsltGriCalcDestViaListVOS(dbDao.searchGRICalculationRouteDestinationViaList(vo));
			rVo.setRsltGriCalcDestPntListVOS(dbDao.searchGRICalculationRouteDestinationPointList(vo));

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
	 * @param TriGriCalcVO pVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGRICalculation(TriGriCalcVO pVo, SignOnUserAccount account) throws EventException {
		try {
			PriTriGriGrpVO[] grpvo = pVo.getPriTriGriGrpVOS();
			PriTriGriRtVO[] rtvo = pVo.getPriTriGriRtVOS();
			PriTriGriCmdtVO[] cmdtvo = pVo.getPriTriGriCmdtVOS();
			PriTriGriRoutPntVO[] orgpntvo = pVo.getPriTriGriRoutOrgPntVOS();
			PriTriGriRoutViaVO[] orgviavo = pVo.getPriTriGriRoutOrgViaVOS();
			PriTriGriRoutViaVO[] destviavo = pVo.getPriTriGriRoutDestViaVOS();
			PriTriGriRoutPntVO[] destpntvo = pVo.getPriTriGriRoutDestPntVOS();

			List<PriTriGriGrpVO> insertGrpList = new ArrayList<PriTriGriGrpVO>();
			List<PriTriGriGrpVO> updateGrpList = new ArrayList<PriTriGriGrpVO>();
			List<PriTriGriGrpVO> deleteGrpList = new ArrayList<PriTriGriGrpVO>();
			List<PriTriGriRtVO> insertRtList = new ArrayList<PriTriGriRtVO>();
			List<PriTriGriRtVO> updateRtList = new ArrayList<PriTriGriRtVO>();
			List<PriTriGriRtVO> deleteRtList = new ArrayList<PriTriGriRtVO>();
			List<PriTriGriCmdtVO> insertCmdtList = new ArrayList<PriTriGriCmdtVO>();
			List<PriTriGriCmdtVO> updateCmdtList = new ArrayList<PriTriGriCmdtVO>();
			List<PriTriGriCmdtVO> deleteCmdtList = new ArrayList<PriTriGriCmdtVO>();
			List<PriTriGriRoutPntVO> insertPntList = new ArrayList<PriTriGriRoutPntVO>();
			List<PriTriGriRoutPntVO> updatePntList = new ArrayList<PriTriGriRoutPntVO>();
			List<PriTriGriRoutPntVO> deletePntList = new ArrayList<PriTriGriRoutPntVO>();
			List<PriTriGriRoutViaVO> insertViaList = new ArrayList<PriTriGriRoutViaVO>();
			List<PriTriGriRoutViaVO> updateViaList = new ArrayList<PriTriGriRoutViaVO>();
			List<PriTriGriRoutViaVO> deleteViaList = new ArrayList<PriTriGriRoutViaVO>();

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