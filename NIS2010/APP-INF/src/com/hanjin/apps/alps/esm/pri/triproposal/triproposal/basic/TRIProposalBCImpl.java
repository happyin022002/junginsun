/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TRIProposalBCImpl.java
 *@FileTitle : TRI Creation & Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.13
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.11.13 박성수
 * 1.0 Creation
=========================================================
 * History
 * 2015.08.13 [CHM-201537109] Split19-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
 * 2016.06.17 [CHM-201642005] TRI Amendment & Creation 상에서 Publish 버튼 클릭 후 30초가 지나도 서비스 가능하도록 시스템 개발  
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.PriPrsInCalculateVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration.TRIProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration.TRIProposalEAIDAO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltPrsSurchargeDetailListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPropDtlListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPropInquiryListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPropListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropGRIVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropParamVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.table.PriTriMnVO;
import com.hanjin.syscommon.common.table.PriTriRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriTriRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriTriRtScgVO;
import com.hanjin.syscommon.common.table.PriTriRtUsdRoutCsVO;
import com.hanjin.syscommon.common.table.PriTriRtVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * ALPS-TRIProposal Business Logic Command Interface<br>
 * - ALPS-TRIProposal에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Sungsoo Park
 * @since J2EE 1.6
 */
public class TRIProposalBCImpl extends BasicCommandSupport implements TRIProposalBC {

	// Database Access Object
	private transient TRIProposalDBDAO dbDao = null;

	/**
	 * TRIProposalBCImpl 객체 생성<br>
	 * TRIProposalDBDAO를 생성한다.<br>
	 */
	public TRIProposalBCImpl() {
		dbDao = new TRIProposalDBDAO();
	}

	/**
	 * TRI Proposal List를 조회합니다.<br>
	 * 
	 * @param TriPropParamVO triPropParamVO
	 * @return List<RsltTriPropListVO>
	 * @exception EventException
	 */
	public List<RsltTriPropListVO> searchTRIProposalList(TriPropParamVO triPropParamVO) throws EventException {
		try {
			return dbDao.searchTRIProposalList(triPropParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * TRI Proposal - Rate 및 Route정보를 조회합니다.<br>
	 * 
	 * @param PriTriMnVO priTriMnVO
	 * @return RsltTriPropDtlListVO
	 * @exception EventException
	 */
	public RsltTriPropDtlListVO searchTRIRateProposalList(PriTriMnVO priTriMnVO) throws EventException {
		RsltTriPropDtlListVO rVo = new RsltTriPropDtlListVO();
		try {
			rVo.setRsltTriRtListVOS(dbDao.searchTRIRateProposalList(priTriMnVO));
			rVo.setRsltTriRoutOrgPntVOS(dbDao.searchTRIRouteOriginPointList(priTriMnVO));
			rVo.setRsltTriRoutOrgViaVOS(dbDao.searchTRIRouteOriginViaList(priTriMnVO));
			rVo.setRsltTriRoutDestViaVOS(dbDao.searchTRIRouteDestinationViaList(priTriMnVO));
			rVo.setRsltTriRoutDestPntVOS(dbDao.searchTRIRouteDestinationPointList(priTriMnVO));
			rVo.setRsltPriTriNoteConvVO(dbDao.searchNoteConversionList(priTriMnVO));

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 중복된 TRI Rate가 존재하는지 검색한다.<br>
	 * 
	 * @param TriPropParamVO triPropParamVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckRateDuplicate(TriPropParamVO triPropParamVO) throws EventException {
		try {
			return dbDao.searchCheckRateDuplicate(triPropParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 새로운 TRI_PROP_NO를 채번한다.<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchNextTRIPropNo(SignOnUserAccount account) throws EventException {
		try {
			PriTriMnVO nextNoVO = new PriTriMnVO();
			nextNoVO.setCreUsrId(account.getOfc_cd());
			return dbDao.searchNextTRIPropNo(nextNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * TRI Proposal 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param TriPropVO triPropVO
	 * @param SignOnUserAccount account
	 * @param String newTriPropNo
	 * @exception EventException
	 */
	public void manageTRIRateProposal(TriPropVO triPropVO, SignOnUserAccount account, String newTriPropNo) throws EventException {
		try {
			PriTriMnVO trimnvo = triPropVO.getPriTriMnVO();
			PriTriRtRoutPntVO[] orgpntvo = triPropVO.getPriTriRtRoutOrgPntVOS();
			PriTriRtRoutViaVO[] orgviavo = triPropVO.getPriTriRtRoutOrgViaVOS();
			PriTriRtRoutViaVO[] destviavo = triPropVO.getPriTriRtRoutDestViaVOS();
			PriTriRtRoutPntVO[] destpntvo = triPropVO.getPriTriRtRoutDestPntVOS();
			PriTriRtVO[] rtvo = triPropVO.getPriTriRtVOS();

			List<PriTriMnVO> insertMnList = new ArrayList<PriTriMnVO>();
			List<PriTriMnVO> updateMnList = new ArrayList<PriTriMnVO>();
			List<PriTriMnVO> deleteMnList = new ArrayList<PriTriMnVO>();
			List<PriTriRtRoutPntVO> insertPntList = new ArrayList<PriTriRtRoutPntVO>();
			List<PriTriRtRoutPntVO> updatePntList = new ArrayList<PriTriRtRoutPntVO>();
			List<PriTriRtRoutPntVO> deletePntList = new ArrayList<PriTriRtRoutPntVO>();
			List<PriTriRtRoutViaVO> insertViaList = new ArrayList<PriTriRtRoutViaVO>();
			List<PriTriRtRoutViaVO> updateViaList = new ArrayList<PriTriRtRoutViaVO>();
			List<PriTriRtRoutViaVO> deleteViaList = new ArrayList<PriTriRtRoutViaVO>();
			List<PriTriRtVO> insertRtList = new ArrayList<PriTriRtVO>();
			List<PriTriRtVO> updateRtList = new ArrayList<PriTriRtVO>();
			List<PriTriRtVO> deleteRtList = new ArrayList<PriTriRtVO>();

			if (trimnvo.getIbflag().equals("I")) {
				trimnvo.setCreUsrId(account.getUsr_id());
				trimnvo.setUpdUsrId(account.getUsr_id());

				trimnvo.setTriPropNo(newTriPropNo);
				
				insertMnList.add(trimnvo);
			} else if (trimnvo.getIbflag().equals("U")) {
				trimnvo.setUpdUsrId(account.getUsr_id());
				updateMnList.add(trimnvo);
			} else if (trimnvo.getIbflag().equals("D")) {
				trimnvo.setUpdUsrId(account.getUsr_id());
				deleteMnList.add(trimnvo);
			}
			for (int i = 0; orgpntvo != null && i < orgpntvo.length; i++) {
				if (orgpntvo[i].getIbflag().equals("I")) {
					if (trimnvo.getIbflag().equals("I") && newTriPropNo != null) {
						orgpntvo[i].setTriPropNo(newTriPropNo);
					}
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
					if (trimnvo.getIbflag().equals("I") && newTriPropNo != null) {
						orgviavo[i].setTriPropNo(newTriPropNo);
					}
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
					if (trimnvo.getIbflag().equals("I") && newTriPropNo != null) {
						destviavo[i].setTriPropNo(newTriPropNo);
					}
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
					if (trimnvo.getIbflag().equals("I") && newTriPropNo != null) {
						destpntvo[i].setTriPropNo(newTriPropNo);
					}
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
			for (int i = 0; rtvo != null && i < rtvo.length; i++) {
				if (rtvo[i].getIbflag().equals("I")) {
					if (trimnvo.getIbflag().equals("I") && newTriPropNo != null) {
						rtvo[i].setTriPropNo(newTriPropNo);
					}
					rtvo[i].setTriRqstOfcCd(account.getOfc_cd());
					rtvo[i].setTriRqstUsrId(account.getUsr_id());
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

			if (insertMnList.size() > 0) {
				dbDao.addTriMain(insertMnList);
			}
			if (insertPntList.size() > 0) {
				dbDao.addRateRoutePoint(insertPntList);
			}
			if (insertViaList.size() > 0) {
				dbDao.addRateRouteVia(insertViaList);
			}
			if (insertRtList.size() > 0) {
				dbDao.addRate(insertRtList);
			}

			if (updateMnList.size() > 0) {
				dbDao.modifyTriMain(updateMnList);
			}
			if (updatePntList.size() > 0) {
				dbDao.modifyRateRoutePoint(updatePntList);
			}
			if (updateViaList.size() > 0) {
				dbDao.modifyRateRouteVia(updateViaList);
			}
			if (updateRtList.size() > 0) {
				dbDao.modifyRate(updateRtList);
			}

			if (deleteRtList.size() > 0) {
				dbDao.removeRateCascadeScg(deleteRtList);
				dbDao.removeRateCascadeScgRout(deleteRtList);
				dbDao.removeRateCascadeUsdRoutCs(deleteRtList);
				dbDao.removeRate(deleteRtList);
			}
			if (deleteViaList.size() > 0) {
				dbDao.removeRateRouteVia(deleteViaList);
			}
			if (deletePntList.size() > 0) {
				dbDao.removeRateRoutePoint(deletePntList);
			}
			if (deleteMnList.size() > 0) {
				dbDao.removeTriMainCascadeScg(deleteMnList);
				dbDao.removeTriMainCascadeScgRout(deleteMnList);
				dbDao.removeTriMainCascadeUsdRoutCs(deleteMnList);
				dbDao.removeTriMainCascadeRt(deleteMnList);
				dbDao.removeTriMainCascadeRoutVia(deleteMnList);
				dbDao.removeTriMainCascadeRoutPnt(deleteMnList);
				dbDao.removeTriMain(deleteMnList);
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
	 * TRI Proposal 데이터의 승인을 요청한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVO != null) {
				priTriRtVO.setPropStsCd("Q");
				priTriRtVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyRateRequestProposal(priTriRtVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 다건의 TRI Proposal 데이터의 승인을 요청한다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVOs != null && priTriRtVOs.length > 0) {
				for (int i = 0; i < priTriRtVOs.length; i++) {
					priTriRtVOs[i].setPropStsCd("Q");
					priTriRtVOs[i].setUpdUsrId(account.getUsr_id());

					dbDao.modifyRateRequestProposal(priTriRtVOs[i]);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * TRI Proposal 데이터를 Amend한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVO != null) {
				dbDao.modifyTriMainPrsCalcFlagOnAmend(priTriRtVO);
				
				priTriRtVO.setTriRqstUsrId(account.getUsr_id());
				priTriRtVO.setTriRqstOfcCd(account.getOfc_cd());
				priTriRtVO.setCreUsrId(account.getUsr_id());
				priTriRtVO.setUpdUsrId(account.getUsr_id());
				dbDao.addRateAmendProposal(priTriRtVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * TRI Proposal 데이터의 C/Offer 처리한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cofferTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVO != null) {
				dbDao.modifyTriMainPrsCalcFlagOnCOffer(priTriRtVO);
				
				priTriRtVO.setPropStsCd("R");
				priTriRtVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyRateCofferProposal(priTriRtVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * TRI Proposal 데이터를 승인한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVO != null) {
				priTriRtVO.setPropStsCd("A");
				priTriRtVO.setTriAproUsrId(account.getUsr_id());
				priTriRtVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyRateApproveProposal(priTriRtVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 다건의 TRI Proposal 데이터를 승인한다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVOs != null && priTriRtVOs.length > 0) {
				for (int i = 0; i < priTriRtVOs.length; i++) {
					priTriRtVOs[i].setPropStsCd("A");
					priTriRtVOs[i].setTriAproUsrId(account.getUsr_id());
					priTriRtVOs[i].setUpdUsrId(account.getUsr_id());

					dbDao.modifyRateApproveProposal(priTriRtVOs[i]);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * TRI Proposal 데이터를 Publish한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVO != null) {
				priTriRtVO.setPropStsCd("F");
				priTriRtVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyRatePublishProposal(priTriRtVO);
				dbDao.modifyRateClosePrevExpDtPostPublish(priTriRtVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 다건의 TRI Proposal 데이터를 Publish한다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVOs != null && priTriRtVOs.length > 0) {
				for (int i = 0; i < priTriRtVOs.length; i++) {
					priTriRtVOs[i].setPropStsCd("F");
					priTriRtVOs[i].setUpdUsrId(account.getUsr_id());

					dbDao.modifyRatePublishProposal(priTriRtVOs[i]);
					dbDao.modifyRateClosePrevExpDtPostPublish(priTriRtVOs[i]);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *  -------------------------------------------------------------------------------------
	 * 다건의 TRI Proposal 데이터를 BackEnd 로 Publish한다.[Rule of 30 Sec]<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String publishMultiTRIRateProposalPublishBackEnd(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		TRIProposalPublishBackEndJob jobImpl = new TRIProposalPublishBackEndJob();
		try {
			
			jobImpl.setPriTriRtVOs(priTriRtVOs);
			jobImpl.setAccount(account);
			
			return backEndJobManager.execute(jobImpl, account.getUsr_id(), "ESM_PRI_3018 : Publish All");
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex); // 'Problem occurred while saving data.';
		}
	}	

	/**
	 * TRI Proposal 데이터에 TRI Number를 Assign한다.<br>
	 * 
	 * @param PriTriMnVO priTriMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void assignNoTRIRateProposal(PriTriMnVO priTriMnVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriMnVO != null) {
				priTriMnVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyTriMainAssignTRINo(priTriMnVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * TRI Proposal 데이터의 상태를 이전으로 되돌린다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVO != null) {
				
				String sPropStsCd = priTriRtVO.getPropStsCd();
				
				if ("A".equals(sPropStsCd)) { // Approved. Requested상태로 돌아감.
					priTriRtVO.setPropStsCd("Q");
					priTriRtVO.setTriAproUsrId(null);
					priTriRtVO.setUpdUsrId(account.getUsr_id());
					priTriRtVO.setFnlFrtRtAmt(null);

					dbDao.modifyRateApproveProposal(priTriRtVO);
					
					if (Integer.parseInt(priTriRtVO.getAmdtSeq()) == 0) {
						dbDao.modifyTriMainClearTRINo(priTriRtVO);
					}
				} else if ("R".equals(sPropStsCd)) { // Returned. Requested상태로 돌아감.
					dbDao.modifyTriMainPrsCalcFlagOnCOffer(priTriRtVO);
					
					priTriRtVO.setPropStsCd("Q");
					priTriRtVO.setUpdUsrId(account.getUsr_id());
					priTriRtVO.setCoffrFrtRtAmt(null);

					dbDao.modifyRateCofferProposal(priTriRtVO);
				} else if ("Q".equals(sPropStsCd)) { // Requested. Initial상태로 돌아감.
					priTriRtVO.setPropStsCd("I");
					priTriRtVO.setUpdUsrId(account.getUsr_id());

					dbDao.modifyRateRequestProposal(priTriRtVO);
				} else if ("I".equals(sPropStsCd)) { // Initial. 해당로우를 삭제함.
					dbDao.modifyTriMainPrsCalcFlagOnAmend(priTriRtVO);
					
					List<PriTriRtVO> deleteRtList = new ArrayList<PriTriRtVO>();
					deleteRtList.add(priTriRtVO);
					
					dbDao.removeRateCascadeScg(deleteRtList);
					dbDao.removeRateCascadeScgRout(deleteRtList);
					dbDao.removeRateCascadeUsdRoutCs(deleteRtList);
					dbDao.removeRate(deleteRtList);
					
					if (Integer.parseInt(priTriRtVO.getAmdtSeq()) == 0) {
						PriTriMnVO row = new PriTriMnVO();
						row.setTriPropNo(priTriRtVO.getTriPropNo());
						
						List<PriTriMnVO> deleteMnList = new ArrayList<PriTriMnVO>();
						deleteMnList.add(row);
						
						dbDao.removeTriMainCascadeRoutVia(deleteMnList);
						dbDao.removeTriMainCascadeRoutPnt(deleteMnList);
						dbDao.removeTriMain(deleteMnList);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 다건의 TRI Proposal 데이터의 상태를 이전으로 되돌린다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVOs != null && priTriRtVOs.length > 0) {
				for (int i = 0; i < priTriRtVOs.length; i++) {
					String sPropStsCd = priTriRtVOs[i].getPropStsCd();
					
					if ("A".equals(sPropStsCd)) { // Approved. Requested상태로 돌아감.
						priTriRtVOs[i].setPropStsCd("Q");
						priTriRtVOs[i].setTriAproUsrId(null);
						priTriRtVOs[i].setUpdUsrId(account.getUsr_id());
						priTriRtVOs[i].setFnlFrtRtAmt(null);

						dbDao.modifyRateApproveProposal(priTriRtVOs[i]);
						
						if (Integer.parseInt(priTriRtVOs[i].getAmdtSeq()) == 0) {
							dbDao.modifyTriMainClearTRINo(priTriRtVOs[i]);
						}
					} else if ("Q".equals(sPropStsCd)) { // Requested. Initial상태로 돌아감.
						priTriRtVOs[i].setPropStsCd("I");
						priTriRtVOs[i].setUpdUsrId(account.getUsr_id());

						dbDao.modifyRateRequestProposal(priTriRtVOs[i]);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * TRI Note Content 정보를 저장합니다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNote(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException{
		try {
			priTriRtVO.setUpdUsrId(account.getUsr_id());
			dbDao.manageNote(priTriRtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * TRI GRI가 Apply가능한지 검색한다.<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckGRIApplicable(TriPropGRIVO triPropGRIVO) throws EventException {
		try {
			return dbDao.searchCheckGRIApplicable(triPropGRIVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculation(TriPropGRIVO triPropGRIVO, SignOnUserAccount account) throws EventException {
		try {
			if (triPropGRIVO != null) {
				String dupTriNo = dbDao.searchCheckGRIApplicable(triPropGRIVO);
				if (dupTriNo != null && !"".equals(dupTriNo)) {
					throw new EventException(new ErrorHandler("PRI05008").getMessage());
				}
				
				String sOfcCd = account.getOfc_cd();
				String sRhqOfcCd = account.getRhq_ofc_cd();
				if (sOfcCd.length() == 6 && ("SHARC".equals(sRhqOfcCd) || "HAMRU".equals(sRhqOfcCd) || "NYCRA".equals(sRhqOfcCd) || "SINRS".equals(sRhqOfcCd))) {
					triPropGRIVO.setTriAproOfcCd(sRhqOfcCd);
				} else {
					triPropGRIVO.setTriAproOfcCd(sOfcCd);
				}
				
				triPropGRIVO.setTriRqstOfcCd(account.getOfc_cd());
				triPropGRIVO.setTriRqstUsrId(account.getUsr_id());
				triPropGRIVO.setTriAproUsrId(account.getUsr_id());
				triPropGRIVO.setCreUsrId(account.getUsr_id());
				triPropGRIVO.setUpdUsrId(account.getUsr_id());

				dbDao.addRateGRIApply(triPropGRIVO);
			}
		} catch(EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 적용한 GRI Calculation을 취소합니다.<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculation(TriPropGRIVO triPropGRIVO, SignOnUserAccount account) throws EventException {
		try {
			if (triPropGRIVO != null) {
				dbDao.removeRateScgOnGRICancel(triPropGRIVO);
				dbDao.removeRateScgRoutOnGRICancel(triPropGRIVO);
				dbDao.removeRateUsdRoutCsOnGRICancel(triPropGRIVO);
				
				int rslt = dbDao.removeRateGRICancel(triPropGRIVO);
				if (rslt <= 0) {
					throw new EventException(new ErrorHandler("PRI00352").getMessage());
				}
			}
		} catch(EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltTriPrsCostListVO rsltTriPrsCostListVO
	 * @return List<RsltTriPrsCostListVO>
	 * @exception EventException
	 */
	public List<RsltTriPrsCostListVO> searchCostDetailList(RsltTriPrsCostListVO rsltTriPrsCostListVO)
			throws EventException {
		try {
			return dbDao.searchCostDetailList(rsltTriPrsCostListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltTriPrsCostDetailVO rsltTriPrsCostDetailVO
	 * @return List<RsltTriPrsCostDetailVO>
	 * @exception EventException
	 */
	public List<RsltTriPrsCostDetailVO> searchCostDetailInquiryList(RsltTriPrsCostDetailVO rsltTriPrsCostDetailVO)
			throws EventException {
		try {
			return dbDao.searchCostDetailInquiryList(rsltTriPrsCostDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	

	/**
	 * RATE관련 Cost, CMPB,OPB 값을 갱신하고 그 갱신여부를 Mark해둔다..<BR>
	 * 
	 * @param RsltTriPrsCostListVO[] rsltTriPrsCostListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsCost(RsltTriPrsCostListVO[] rsltTriPrsCostListVOS, SignOnUserAccount account)
			throws EventException {
		try {
			List<RsltTriPrsCostListVO> rateUpdateVoList = new ArrayList<RsltTriPrsCostListVO>();
			List<RsltTriPrsCostListVO> routCsUpdateVoList = new ArrayList<RsltTriPrsCostListVO>();

			for (int i = 0; i < rsltTriPrsCostListVOS.length; i++) {
				if (rsltTriPrsCostListVOS[i].getIbflag().equals("U")) {		
					rsltTriPrsCostListVOS[i].setUpdUsrId(account.getUpd_usr_id());
					if( "Y".equals(rsltTriPrsCostListVOS[i].getUsdRoutCsSelFlg() ) || "1".equals(rsltTriPrsCostListVOS[i].getUsdRoutCsSelFlg() ) ){
						rateUpdateVoList.add(rsltTriPrsCostListVOS[i]);
						rsltTriPrsCostListVOS[i].setUsdRoutCsSelFlg("Y");
					}else{
						rsltTriPrsCostListVOS[i].setUsdRoutCsSelFlg("N");
					}
					routCsUpdateVoList.add(rsltTriPrsCostListVOS[i]);
				}
			}
			
			if (routCsUpdateVoList.size() > 0) {
				this.modifyPrsRateCommodityRoute(routCsUpdateVoList);
			}
			if (rateUpdateVoList.size() > 0) {
				this.modifyCalculateLogicData( rateUpdateVoList);
 
				//SCProposalCalculate Logic시작
 
				
			}		
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * Calculate Logic을 이용해 data를 갱신한다..<BR>
	 * 
	 * @param List<RsltTriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyCalculateLogicData(List<RsltTriPrsCostListVO>  rsltPriPrsCostListVO) throws EventException{
		try {
			
			dbDao.modifyPrsRate(rsltPriPrsCostListVO);
			//SCProposalCalculate Logic시작
			dbDao.removePriTriRtScgRoutCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.addPriTriRtScgRoutCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.removePriTriRtScgCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.addPriTriRtScgCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriTriRtSurchargeCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriTriRtCMPBCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriTriRtSvcLaneCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriTriRtGlineMappingCostDetail(rsltPriPrsCostListVO.get(0));			
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}		
	
	
	/**
	 * Route의 선택여부를 Mark해둔다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @param boolean isXaDrive
	 * @exception EventException
	 */
	public void modifyPrsRateCommodityRoute(List<RsltTriPrsCostListVO>  routCsUpdateVoList) throws EventException{
		try {
			dbDao.modifyPrsRateCommodityRoute(routCsUpdateVoList);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	
	
	
	/**
	 * Pre CM/OP Simulation Cost관련 Cost, CMPB,OPB 값을 갱신.
	 * 
	 * @param RsltTriPrsCostListVO[] rsltPriPrsCostListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsSimulationCost(RsltTriPrsCostListVO[] rsltTriPrsCostListVOS, SignOnUserAccount account)
			throws EventException {
		try {
			List<RsltTriPrsCostListVO> rateUpdateVoList = new ArrayList<RsltTriPrsCostListVO>();


			for (int i = 0; i < rsltTriPrsCostListVOS.length; i++) {
				rateUpdateVoList.add(rsltTriPrsCostListVOS[i]);
			}
			if (rateUpdateVoList.size() > 0) {
				dbDao.modifyPrsRate(rateUpdateVoList);
			}			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}		
	
	
	/**
	 * PRS- Applicable Route, Surcharge Detail을 조회 처리합니다.<br>
	 * 
	 * @param InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO
	 * @return RsltPrsSurchargeDetailListVO
	 * @exception EventException
	 */
	public RsltPrsSurchargeDetailListVO searchRateSurchargeList(InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO)
			throws EventException {
		try {
			RsltPrsSurchargeDetailListVO rsltPrsSurchargeDetailListVO = new RsltPrsSurchargeDetailListVO();
			rsltPrsSurchargeDetailListVO.setRsltPrsSurchargeDetailVOS(dbDao
					.searchSurchargeDetailList(inpPrsSurchargeDetailApplicableRouteVO));
			rsltPrsSurchargeDetailListVO.setRsltPrsSurchargeDetailApplicableRouteVOS(dbDao
					.searchSurchargeList(inpPrsSurchargeDetailApplicableRouteVO));
			return rsltPrsSurchargeDetailListVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * PRS- Surcharge Detail 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param PriTriRtScgVO[] priPriTriRtScgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateSurcharge(PriTriRtScgVO[] priPriTriRtScgVO, SignOnUserAccount account)
			throws EventException {
		try {
			List<PriTriRtScgVO> insertVoList = new ArrayList<PriTriRtScgVO>();
			List<PriTriRtScgVO> updateVoList = new ArrayList<PriTriRtScgVO>();
			List<PriTriRtScgVO> deleteVoList = new ArrayList<PriTriRtScgVO>();
			PriTriRtScgVO priTriRtScgVo = null; 

			for (int i = 0; i < priPriTriRtScgVO.length; i++) {
				if (priPriTriRtScgVO[i].getIbflag().equals("I")) {
					priPriTriRtScgVO[i].setCreUsrId(account.getUsr_id());
					priPriTriRtScgVO[i].setUpdUsrId(account.getUsr_id());
					priPriTriRtScgVO[i].setTrfAdjTpCd("I");
					insertVoList.add(priPriTriRtScgVO[i]);
				} else if (priPriTriRtScgVO[i].getIbflag().equals("U")) {
					priPriTriRtScgVO[i].setUpdUsrId(account.getUsr_id());
					priPriTriRtScgVO[i].setTrfAdjTpCd("I");
					updateVoList.add(priPriTriRtScgVO[i]);
				} else if (priPriTriRtScgVO[i].getIbflag().equals("D")) {
					priPriTriRtScgVO[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priPriTriRtScgVO[i]);
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeRateSurcharge(deleteVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyRateSurcharge(updateVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addRateSurcharge(insertVoList);
			}
			//chg_cd를 뺀 나머지 Key 부분만 있으면 되기때문에 
			// CUD중 하나의 key만 있으면 된다.
			if( deleteVoList.size() > 0 ){
				priTriRtScgVo = deleteVoList.get(0);
			}else if( updateVoList.size() > 0){
				priTriRtScgVo = updateVoList.get(0);
			}else if(insertVoList.size() > 0){
				priTriRtScgVo = insertVoList.get(0);
			}
			if(priTriRtScgVo != null){
				dbDao.modifyPrsRateSurchargeCmpb(priTriRtScgVo);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * TRI Proposal Inquiry List를 조회합니다.<br>
	 * 
	 * @param TriPropParamVO triPropParamVO
	 * @return List<RsltTriPropListVO>
	 * @exception EventException
	 */
	public List<RsltTriPropInquiryListVO> searchTRIProposalInquiryList(TriPropParamVO triPropParamVO) throws EventException {
		try {
			return dbDao.searchTRIProposalInquiryList(triPropParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

    /**
     * TRI Proposal Excel Data 를 첨부하여 Descartes 로 메일을 전송합니다.<br>
     * 
     * @param TriPropSendMailVO triPropSendMailVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void sendMailTRIProposal(TriPropSendMailVO triPropSendMailVO, SignOnUserAccount account) throws EventException {
        try {
            triPropSendMailVO.setFromUser(account.getUsr_eml());
            triPropSendMailVO.setFromUserNm(account.getUsr_nm());
            log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ToUser : " + triPropSendMailVO.getToUser());
            triPropSendMailVO.setSubject("Request of TRI Publication");
            StringBuilder sbContent = new StringBuilder();
            sbContent.append("To whom it may concerned");
            sbContent.append("\n\n");
            sbContent.append("We would like you to review the attachment and publish them at the web page.");
            sbContent.append("\n");
            sbContent.append("Thank you for your cooperation as always.");
            sbContent.append("\n\n");
            sbContent.append("Best regards");
            sbContent.append("\n\n");
            
            triPropSendMailVO.setTextContent(sbContent.toString());
            
            TRIProposalEAIDAO eaiDao = new TRIProposalEAIDAO();
            eaiDao.sendMailTRIProposal(triPropSendMailVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00120",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00120",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TRI Proposal Rate 의 Send Date 를 업데이트 합니다.<BR>
     * 
     * @param PriTriRtVO[] priTriRtVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyPriTriRtSendDate(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException {
        try {
            for (int i = 0, n = priTriRtVOs.length ; i < n ; i++) {
                priTriRtVOs[i].setUpdUsrId(account.getUsr_id());
                dbDao.modifyPriTriRtSendDate(priTriRtVOs[i]);
            }
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
	/**
	 * Calculate Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO executeCalculate_BATCH(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			//컨테이너 vo
//			RateQuotationVO rateQuotationVO = new RateQuotationVO();
			ScheduleUtil schedule = new ScheduleUtil();
			PriPrsBatVO priPrsBatVO = null;
			String params = "";
			String jobID = "";
			
			params = priTriRtVO.getTriPropNo() 
					+ "#" + priTriRtVO.getAmdtSeq()
					+ "#" + account.getUsr_id();
			log.debug("insert Params = "+params);
 			jobID = schedule.directExecuteJob("ESM_PRI_B012", params);
 			
 			priPrsBatVO = new PriPrsBatVO();
 			priPrsBatVO.setPrsBatId(jobID);
 			priPrsBatVO.setParaInfoCtnt(params);
 			priPrsBatVO.setPgmNo("ESM_PRI_B012");
 			log.debug("params ===> "+params);
			return priPrsBatVO;
 
			 
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
		
	}
	
	
	/**
	 * Calculate Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @param PriPrsBatVO priPrsBatVO
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public String executeCalculate(PriTriRtVO priTriRtVO,PriPrsBatVO priPrsBatVO, SignOnUserAccount account) throws EventException {
		try {
//			//컨테이너 vo
////			RateQuotationVO rateQuotationVO = new RateQuotationVO();
//			ScheduleUtil schedule = new ScheduleUtil();
//			PriPrsBatVO priPrsBatVO = null;
//			String params = "";
//			String jobID = "";
//			
//			params = priTriRtVO.getTriPropNo() 
//					+ "#" + priTriRtVO.getAmdtSeq()
//					+ "#" + account.getUsr_id();
//			log.debug("insert Params = "+params);
// 			jobID = schedule.directExecuteJob("ESM_PRI_B012", params);
// 			
// 			priPrsBatVO = new PriPrsBatVO();
// 			priPrsBatVO.setPrsBatId(jobID);
// 			priPrsBatVO.setParaInfoCtnt(params);
// 			priPrsBatVO.setPgmNo("ESM_PRI_B012");
// 			log.debug("params ===> "+params);
//			return priPrsBatVO;
 
			
			
			TRIProposalCalculateBackEndJob triProposalCalculateBackEndJob = new TRIProposalCalculateBackEndJob(); 
			PriPrsInCalculateVO priPrsInCalculateVO = new PriPrsInCalculateVO();
			priPrsInCalculateVO.setTriPropNo( priTriRtVO.getTriPropNo());
			priPrsInCalculateVO.setAmdtSeq(priTriRtVO.getAmdtSeq());
			triProposalCalculateBackEndJob.setSearchParameterVOs(  priPrsInCalculateVO,priPrsBatVO, account); 
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			return backEndJobManager.execute(triProposalCalculateBackEndJob, account.getUsr_id(), "ESM_PRI_3001 - Calculate");
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
		
	}

	/**
	 * Calculate Batch ID를 조회 하기 위한 Parameter를 조합한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO searchMonitorCalculateParam(PriTriRtVO priTriRtVO) throws EventException {
		try {
			PriPrsBatVO priPrsBatVO = null;
			String params = "";
			
			//조회불가 메시지
			if( priTriRtVO.getTriPropNo() == null || priTriRtVO.getAmdtSeq() == null){
				throw new EventException(new ErrorHandler("PRI02014").getMessage());
			}
			params = priTriRtVO.getTriPropNo() 
					+ "#" + priTriRtVO.getAmdtSeq()
					+ "#" ; //USER ID정보는  parameter 정보에서 빼고 like 검색으로 batch id를 검색한다.

 			priPrsBatVO = new PriPrsBatVO();
 			priPrsBatVO.setParaInfoCtnt(params);
 			priPrsBatVO.setPgmNo("ESM_PRI_B012");
	 			
			return priPrsBatVO;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Calculate Batch의 상태 조회.<br>
	 * 
	 * @param PrsBatchVO prsBatchVO
	 * @return String
	 * @exception EventException
	 */
	public String monitorCalculate(PrsBatchVO prsBatchVO) throws EventException {
		try {
 			ScheduleUtil su = new ScheduleUtil();
 			int status = 0;
 			if( prsBatchVO != null ){
 				status = su.getJobStatus(prsBatchVO.getPrsBatId(),prsBatchVO.getPgmNo());
 				if( status == 0 ){
 					float min = Float.valueOf(prsBatchVO.getExecMinutes());
 					if( min > 10){  // 10분이 지다도 0이 return될때 Batch 서버가 해당 Calc를 돌려주지 못했다고 판단한다. Code 99
 						status = 99;
 					}else{
 						// 기존에 nothing으로 표현 하던 내용으로 pri_prs_bat에는 데이터가 있으나 batch에서 null을 return할때는 Running...으로 표현한다.
 						status = 80;
 					}
 					log.debug(" =================  status === "+status);
 				}
 			} 
			 
			return String.valueOf(status);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
		
	}
	
	
	
	/**
	 * Rate Route Case를 추가 한다. .<br>
	 * 
	 * @param PriTriRtUsdRoutCsVO priTriRtUsdRoutCsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriTriRateUsedRouteCase(PriTriRtUsdRoutCsVO priTriRtUsdRoutCsVO, SignOnUserAccount account) throws EventException{	
		try {
			List<PriTriRtUsdRoutCsVO> priTriRtUsdRoutCsVOs = new ArrayList<PriTriRtUsdRoutCsVO>();
			if (priTriRtUsdRoutCsVO != null) {
				priTriRtUsdRoutCsVO.setUpdUsrId(account.getUsr_id());
				priTriRtUsdRoutCsVO.setUsdRoutCsSelFlg("Y");
				priTriRtUsdRoutCsVOs.add(priTriRtUsdRoutCsVO);
			}
			dbDao.addPriTriRateUsedRouteCase(priTriRtUsdRoutCsVOs);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * COST CM/OP PRE SIMULATION 화면에서 ROUTE정보를 조회 한다.<br>
	 * 
	 * @param InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO
	 * @return List<RsltPriCostSimulationCheckRouteVO>
	 * @exception EventException
	 */
	public List<RsltPriCostSimulationCheckRouteVO> searchCostSimulationCheckRoutList(
			InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO) throws EventException {
		try {
			List<RsltPriCostSimulationCheckRouteVO> rsltPriCostSimulationCheckRouteVOs = dbDao.searchCostSimulationCheckRoutList(inCostSimulationCheckRouteVO);
			 
			return rsltPriCostSimulationCheckRouteVOs;
			
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
		
    /**
     * TRI Proposal 에서 Publish 할 때 담당자에게 GW 메일을 전송합니다.<br>
     * 
     * @param PriTriRtVO priTriRtVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void sendMailTRIProposalPublish(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
        try {
            TriPropSendMailVO triPropSendMailVO = new TriPropSendMailVO();
            List<String> emailList = new ArrayList<String>();
            // mail 대상 조회
            String[] emails = dbDao.searchTRIPublishTargetMail(priTriRtVO);
            
            if (emails == null || emails.length == 0) {
                return;
            }
            
            for (int i = 0, n = emails.length ; i < n ; i++) {
                emailList.add(emails[i]);
            }
            
            // mail content 조회
            List<RsltTriPropListVO> list = dbDao.searchTRIPublishMailContent(priTriRtVO);
            
            if (list == null || list.size() == 0) {
                return;
            }
            
            RsltTriPropListVO rsltTriPropListVO = list.get(0);
            
            triPropSendMailVO.setFromUser(account.getUsr_eml());
            triPropSendMailVO.setFromUserNm(account.getUsr_nm());
            
            triPropSendMailVO.setSubject("Notice of TRI Publication");
            StringBuilder sbHtmlContent = new StringBuilder();
            
            sbHtmlContent.append("<html>");
            sbHtmlContent.append("<head>");
            sbHtmlContent.append("<title></title>");
            sbHtmlContent.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=euc-kr\">");
            sbHtmlContent.append("<link rel=\"stylesheet\" href=\"include/style.css\" type=\"text/css\">");
            sbHtmlContent.append("</head>");
            sbHtmlContent.append("<table style=\"width:100%\" class=\"popup\" cellpadding=\"0\" border=\"0\">");
            sbHtmlContent.append("<tr><td class=\"top\"></td></tr>");
            sbHtmlContent.append("<tr><td valign=\"top\">");
            sbHtmlContent.append("<table width=\"100%\" border=\"0\">");
            sbHtmlContent.append("<tr><td style=\"font-family:verdana,arial; font-size: 14px; word-spacing:-0px; color: #FF4E00; padding-left:10;\">To whom it may concerned</td></tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("<table class=\"search\">");
            sbHtmlContent.append("<tr><td class=\"bg\">");
            sbHtmlContent.append("<table border=\"0\" style=\"width:100%;\">");
            sbHtmlContent.append("<tr>");
            sbHtmlContent.append("<td style=\"padding:0px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 12px; word-spacing:-0px;\">");

            if (priTriRtVO.getAmdtSeq().equals("0")) {
                sbHtmlContent.append("Please be advised that below Tariff Rate, you requested, is published as below.<br>");
                sbHtmlContent.append("Now you can create TAA with this TRI.");
            } else {
                sbHtmlContent.append("Please be advised that below Tariff Rate is published as following.<br>");
                sbHtmlContent.append("● If you are the one who requests below TRI, now you can create TAA with this TRI.<br>");
                sbHtmlContent.append("● If you are the one who is using this TRI in your TAA, please check the rate changes.");
            }

            sbHtmlContent.append("<br><br>");
            sbHtmlContent.append("</td>");
            sbHtmlContent.append("</tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("<table cellpadding=\"1\" cellspacing=\"1\" bgcolor=\"A6C3CB\" border=\"0\" style=\"width:100%;\">");
            sbHtmlContent.append("<tr>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Tariff Code</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Tariff Rate Item<br>(TRI)</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Current<br>Status</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Commodity</td>");
            sbHtmlContent.append("<td colspan=\"4\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Route</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Per </td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Cargo<br>Type</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Cur.</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Rate</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Note</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Effective<br>Date</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Expiration<br>Date</td>");
            sbHtmlContent.append("</tr>");
            sbHtmlContent.append("<tr>");
            sbHtmlContent.append("<td style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Origin</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Origin Via</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\"> Dest Via</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\"> Dest</td>");
            sbHtmlContent.append("</tr>");
            sbHtmlContent.append("<tr>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getTrfCd()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getTriNo()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #ffffff; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getCurStatus()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getCmdtNm()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getOrgRoutPntLocNm()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getOrgRoutViaPortNm()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getDestRoutViaPortNm()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getDestRoutPntLocNm()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getRatUtCd()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getPrcCgoTpCd()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getCurrCd()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(JSPUtil.formatCurrency(rsltTriPropListVO.getFnlFrtRtAmt())).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #ffffff; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getNoteCtnt()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getEffDt()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getExpDt()).append("</td>");
            sbHtmlContent.append("</tr>");
            sbHtmlContent.append("</tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("<table class=\"search\" border=\"0\" style=\"width:100%;\">");
            sbHtmlContent.append("<tr>");
            sbHtmlContent.append("<td style=\"padding:0px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 12px; word-spacing:-0px;\"><br>Thank you.<br>");
            sbHtmlContent.append("Best regards</td>");
            sbHtmlContent.append("</tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("</td></tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("</td></tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("</td></tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("</body>");
            sbHtmlContent.append("</html>");
            triPropSendMailVO.setHtmlContent(sbHtmlContent.toString());
            
            TRIProposalEAIDAO eaiDao = new TRIProposalEAIDAO();
            eaiDao.sendMailTRIProposalPublish(triPropSendMailVO, emailList);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00120",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00120",new String[]{}).getMessage(), ex);
        }
    }
    
    
	/**
	 * MAIN table에 calculate 여부를 Mark해둔다..<BR>
	 * 
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @exception EventException
	 */
	public void modifyPriTriMnCalcFlgCalculate(PriPrsInCalculateVO priPrsInCalculateVO) throws EventException{
		try {
			dbDao.modifyPriTriMnCalcFlgCalculate(priPrsInCalculateVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	

}