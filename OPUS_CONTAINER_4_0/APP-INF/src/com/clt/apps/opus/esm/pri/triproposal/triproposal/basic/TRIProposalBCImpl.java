/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TRIProposalBCImpl.java
 *@FileTitle : TRI Creation & Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.triproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.triproposal.triproposal.integration.TRIProposalDBDAO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriPropDtlListVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriPropInquiryListVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriPropListVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropGRIVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropParamVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriTriMnVO;
import com.clt.syscommon.common.table.PriTriRtRoutPntVO;
import com.clt.syscommon.common.table.PriTriRtRoutViaVO;
import com.clt.syscommon.common.table.PriTriRtVO;

/**
 * TRIProposal Business Logic Command Interface<br>
 * 
 * @author SHKIM
 * @see EsmPri3001EventResponse,TRIProposalBC - Refer to each DAO class
 * @since J2EE 1.6
 */
public class TRIProposalBCImpl extends BasicCommandSupport implements TRIProposalBC {

	// Database Access Object
	private transient TRIProposalDBDAO dbDao = null;

	/**
	 * Creating TRIProposalBCImpl object<br>
	 * Creating TRIProposalDBDAO <br>
	 */
	public TRIProposalBCImpl() {
		dbDao = new TRIProposalDBDAO();
	}

	/**
	 * Retrieving TRI Proposal List<br>
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
	 * Retrieving TRI Proposal - Rate & Route<br>
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
	 * Checking whether duplicated TRI Rate exists or not<br>
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
	 * Numbering new TRI_PROP_NO<br>
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
	 * Handling multi transaction of TRI Proposal & Rate \.<br>
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
				dbDao.removeRate(deleteRtList);
			}
			if (deleteViaList.size() > 0) {
				dbDao.removeRateRouteVia(deleteViaList);
			}
			if (deletePntList.size() > 0) {
				dbDao.removeRateRoutePoint(deletePntList);
			}
			if (deleteMnList.size() > 0) {
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
	 * Requesting an approval of TRI Proposal data.<br>
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
	 * Requesting an approval of multi TRI Proposal data.<br>
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
	 * Amending TRI Proposal data.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVO != null) {

				
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
	 * handling C/offer of TRI Proposal data.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cofferTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVO != null) {
			 
				
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
	 * Approving TRI Proposal data<br>
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
	 * Approving multi- TRI Proposal data<br>
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
	 * Publishing TRI Proposal data.<br>
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
	 * Puplishing multi TRI Proposal data<br>
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
	 * Numbering TRI Proposal data.<br>
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
	 * making TRI Proposal data's status previous status<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVO != null) {
				
				String sPropStsCd = priTriRtVO.getPropStsCd();
				
				if ("A".equals(sPropStsCd)) { // Approved.  back to Requested
					priTriRtVO.setPropStsCd("Q");
					priTriRtVO.setTriAproUsrId(null);
					priTriRtVO.setUpdUsrId(account.getUsr_id());
					priTriRtVO.setFnlFrtRtAmt(null);

					dbDao.modifyRateApproveProposal(priTriRtVO);
					
 
				} else if ("R".equals(sPropStsCd)) { // Returned.  back to Requested
 
					
					priTriRtVO.setPropStsCd("Q");
					priTriRtVO.setUpdUsrId(account.getUsr_id());
					priTriRtVO.setCoffrFrtRtAmt(null);

					dbDao.modifyRateCofferProposal(priTriRtVO);
				} else if ("Q".equals(sPropStsCd)) { // Requested. back to Initial
					priTriRtVO.setPropStsCd("I");
					priTriRtVO.setUpdUsrId(account.getUsr_id());

					dbDao.modifyRateRequestProposal(priTriRtVO);
				} else if ("I".equals(sPropStsCd)) { // Initial.delete row
					
					List<PriTriRtVO> deleteRtList = new ArrayList<PriTriRtVO>();
					deleteRtList.add(priTriRtVO);
					
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
	 * Making several TRI Proposal data's status previous status다.<br>
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
					
					if ("A".equals(sPropStsCd)) { // Approved. back to Requested
						priTriRtVOs[i].setPropStsCd("Q");
						priTriRtVOs[i].setTriAproUsrId(null);
						priTriRtVOs[i].setUpdUsrId(account.getUsr_id());
						priTriRtVOs[i].setFnlFrtRtAmt(null);

						dbDao.modifyRateApproveProposal(priTriRtVOs[i]);
						
 
					} else if ("Q".equals(sPropStsCd)) { // Requested. back to Initial
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
	 * Saving TRI Note Content information.<br>
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
	 * Checking whether TRI GRI is applicable or not.<br>
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
	 * Applying GRI Calculation to Rate data.<br>
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

				// RHQ Logic deletion
				triPropGRIVO.setTriAproOfcCd(sOfcCd);
				
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
	 * Retrieving TRI Proposal Inquiry List<br>
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
     * Sending gw main to PIC when publishing at TRI Proposal <br>
     * 
     * @param PriTriRtVO priTriRtVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void sendMailTRIProposalPublish(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
        try {
            TriPropSendMailVO triPropSendMailVO = new TriPropSendMailVO();
            List<String> emailList = new ArrayList<String>();
            // retrieving target mail 
            String[] emails = dbDao.searchTRIPublishTargetMail(priTriRtVO);
            
            if (emails == null || emails.length == 0) {
                return;
            }
            
            for (int i = 0, n = emails.length ; i < n ; i++) {
                emailList.add(emails[i]);
            }
            
            // retrieving mail content
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
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00120",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00120",new String[]{}).getMessage(), ex);
        }
    }

}