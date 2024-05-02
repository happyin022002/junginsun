/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFARateProposalBCImpl.java
 *@FileTitle : RFARateProposalBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.04
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvCommVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.RsltNoteConvVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration.RFARateProposalDBDAO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RfaGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropCmdtVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropRtVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltAllRtListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRpScpRtCgoSpecVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeLastAccessDateVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCheckDuplicateVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtRoutListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutHdrListVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRfaNoteConvVO;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpGriGrpVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;
import com.clt.syscommon.common.table.PriRpScpRtActCustVO;
import com.clt.syscommon.common.table.PriRpScpRtCgoSpecVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtRnoteVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtVO;
import com.clt.syscommon.common.table.PriRpScpRtCnoteVO;
import com.clt.syscommon.common.table.PriRpScpRtRoutPntVO;
import com.clt.syscommon.common.table.PriRpScpRtRoutViaVO;
import com.clt.syscommon.common.table.PriRpScpRtScgVO;
import com.clt.syscommon.common.table.PriRpScpRtVO;

/**
 * SCGuideline Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCGuideline<br>
 * 
 * @author 
 * @see UI_PRI_0030EventResponse,SCRateGuidelineBC refer to each DAO class
 * @since J2EE 1.4
 */

public class RFARateProposalBCImpl extends BasicCommandSupport implements RFARateProposalBC {

	// Database Access Object
	private transient RFARateProposalDBDAO dbDao = null;

	/**
	 * Creating RFARateProposalBCImpl Object<br>
	 * Creating RFARateProposalDBDAO.<br>
	 */
	public RFARateProposalBCImpl() {
		dbDao = new RFARateProposalDBDAO();
	}
	
	
	/**
	 * Retrieving style information for diplay after handling CUD transaction<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return RsltRtCmdtRoutListVO
	 * @exception EventException
	 */
	public RsltRtCmdtRoutListVO searchRateCmdtRoutStyle(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException {
		RsltRtCmdtRoutListVO rVo = new RsltRtCmdtRoutListVO();

		try {
			rVo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderStyleList(priRpScpRtCmdtHdrVO));
			rVo.setRsltRtRoutHdrListVOS(dbDao.searchRateRouteStyleList(priRpScpRtCmdtRoutVO));

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving Rate's Commodity Group.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		RsltRtCmdtListVO rVo = new RsltRtCmdtListVO();

		try {
			rVo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderList(priRpScpRtCmdtHdrVO));
			rVo.setRsltRtCmdtDtlListVOS(dbDao.searchRateCommodityDetailList(priRpScpRtCmdtHdrVO));
			rVo.setRsltActCustListVOS(dbDao.searchActualCustomerList(priRpScpRtCmdtHdrVO));
			rVo.setRsltRtCnoteListVOS(dbDao.searchRateCnoteList(priRpScpRtCmdtHdrVO));
			rVo.setRsltCnoteNoteConvListVOS(dbDao.searchRateCnoteNoteConvList(priRpScpRtCmdtHdrVO));

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *Retrieving Rate Inquiry - Commodity Group<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityInquiryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		RsltRtCmdtListVO rVo = new RsltRtCmdtListVO();

		try {
			rVo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderInquiryList(priRpScpRtCmdtHdrVO));
			rVo.setRsltRtCmdtDtlListVOS(dbDao.searchRateCommodityDetailInquiryList(priRpScpRtCmdtHdrVO));
			rVo.setRsltActCustListVOS(dbDao.searchActualCustomerInquiryList(priRpScpRtCmdtHdrVO));
			rVo.setRsltRtCnoteListVOS(dbDao.searchRateCnoteInquiryList(priRpScpRtCmdtHdrVO));
			rVo.setRsltCnoteNoteConvListVOS(dbDao.searchRateCnoteNoteConvList(priRpScpRtCmdtHdrVO));

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Rate History - Commodity Group<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityHistoryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		RsltRtCmdtListVO rVo = new RsltRtCmdtListVO();

		try {
			rVo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderHistoryList(priRpScpRtCmdtHdrVO));
			rVo.setRsltRtCmdtDtlListVOS(dbDao.searchRateCommodityDetailList(priRpScpRtCmdtHdrVO));
			rVo.setRsltActCustListVOS(dbDao.searchActualCustomerList(priRpScpRtCmdtHdrVO));
			rVo.setRsltRtCnoteListVOS(dbDao.searchRateCnoteList(priRpScpRtCmdtHdrVO));
			rVo.setRsltCnoteNoteConvListVOS(dbDao.searchRateCnoteNoteConvList(priRpScpRtCmdtHdrVO));

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving Rate's Route information<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException {
		try {
			return dbDao.searchRateRouteList(priRpScpRtCmdtRoutVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Rate Inquiry - Route List<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteInquiryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException {
		try {
			return dbDao.searchRateRouteInquiryList(priRpScpRtCmdtRoutVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Rate History - Route List<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteHistoryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException {
		try {
			return dbDao.searchRateRouteHistoryList(priRpScpRtCmdtRoutVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving Rate information<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return RsltRtListVO
	 * @exception EventException
	 */
	public RsltRtListVO searchRateList(PriRpScpRtVO priRpScpRtVO) throws EventException {
		RsltRtListVO rVo = new RsltRtListVO();
		try {
			rVo.setRsltRtDtlListVOS(dbDao.searchRateDetailList(priRpScpRtVO));
			rVo.setRsltRtRoutOrgPntListVOS(dbDao.searchRateRouteOriginPointList(priRpScpRtVO));
			rVo.setRsltRtRoutOrgViaListVOS(dbDao.searchRateRouteOriginViaList(priRpScpRtVO));
			rVo.setRsltRtRoutDestViaListVOS(dbDao.searchRateRouteDestinationViaList(priRpScpRtVO));
			rVo.setRsltRtRoutDestPntListVOS(dbDao.searchRateRouteDestinationPointList(priRpScpRtVO));
			rVo.setRsltRtCmdtRnoteListVOS(dbDao.searchRateCommodityRnoteList(priRpScpRtVO));
			rVo.setRsltRnoteNoteConvListVOS(dbDao.searchRateCommodityRnoteNoteConvList(priRpScpRtVO));

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *  Retrieving Rate Inquiry - Rate information<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return RsltRtListVO
	 * @exception EventException
	 */
	public RsltRtListVO searchRateInquiryList(PriRpScpRtVO priRpScpRtVO) throws EventException {
		RsltRtListVO rVo = new RsltRtListVO();
		try {
			rVo.setRsltRtDtlListVOS(dbDao.searchRateDetailInquiryList(priRpScpRtVO));
			rVo.setRsltRtRoutOrgPntListVOS(dbDao.searchRateRouteOriginPointInquiryList(priRpScpRtVO));
			rVo.setRsltRtRoutOrgViaListVOS(dbDao.searchRateRouteOriginViaInquiryList(priRpScpRtVO));
			rVo.setRsltRtRoutDestViaListVOS(dbDao.searchRateRouteDestinationViaInquiryList(priRpScpRtVO));
			rVo.setRsltRtRoutDestPntListVOS(dbDao.searchRateRouteDestinationPointInquiryList(priRpScpRtVO));
			rVo.setRsltRtCmdtRnoteListVOS(dbDao.searchRateCommodityRnoteInquiryList(priRpScpRtVO));
			rVo.setRsltRnoteNoteConvListVOS(dbDao.searchRateCommodityRnoteNoteConvList(priRpScpRtVO));

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 *Retrieving for Excel Download(Vertical)<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateListVerticalExcel(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving for Excel Download(Horizontal)<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateListHorizontalExcel(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving  duplicated rate list<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtCheckDuplicateVO>/
	 * @exception EventException
	 */
	public List<RsltRtCheckDuplicateVO> searchRateCheckDuplicate(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateCheckDuplicate(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 *  Retrieving Accept All's List<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltAllRtListVO>
	 * @exception EventException
	 */
	public List<RsltAllRtListVO> searchAllRateList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchAllRateList(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving last Bullet No. of Rate's Commodity<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String getMaxOldBulletDispSeq(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchMaxOldBulletDispSeq(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Handling multi transaction of Commodity Group <br>
	 * 
	 * @param RfaRtPropCmdtVO rfaRtPropCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(RfaRtPropCmdtVO rfaRtPropCmdtVO, SignOnUserAccount account) throws EventException {
		try {
			PriRpScpRtCmdtHdrVO[] vo = rfaRtPropCmdtVO.getPriRpScpRtCmdtHdrVOS();
			PriRpScpRtCmdtVO[] dtlvo = rfaRtPropCmdtVO.getPriRpScpRtCmdtVOS();
			PriRpScpRtActCustVO[] custvo = rfaRtPropCmdtVO.getPriRpScpRtActCustVOS();
			PriRpScpRtCnoteVO[] cnotevo = rfaRtPropCmdtVO.getPriRpScpRtCnoteVOS();
			PriRfaNoteConvListVO[] convvo = rfaRtPropCmdtVO.getPriRfaNoteConvListVOS();

			List<PriRpScpRtCmdtHdrVO> insertVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
			List<PriRpScpRtCmdtHdrVO> updateVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
			List<PriRpScpRtCmdtHdrVO> deleteVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
			List<PriRpScpRtCmdtVO> insertDtlVoList = new ArrayList<PriRpScpRtCmdtVO>();
			List<PriRpScpRtCmdtVO> updateDtlVoList = new ArrayList<PriRpScpRtCmdtVO>();
			List<PriRpScpRtCmdtVO> deleteDtlVoList = new ArrayList<PriRpScpRtCmdtVO>();
			List<PriRpScpRtActCustVO> insertCustVoList = new ArrayList<PriRpScpRtActCustVO>();
			List<PriRpScpRtActCustVO> updateCustVoList = new ArrayList<PriRpScpRtActCustVO>();
			List<PriRpScpRtActCustVO> deleteCustVoList = new ArrayList<PriRpScpRtActCustVO>();
			List<PriRpScpRtCnoteVO> insertCnoteVoList = new ArrayList<PriRpScpRtCnoteVO>();
			List<PriRpScpRtCnoteVO> updateCnoteVoList = new ArrayList<PriRpScpRtCnoteVO>();
			List<PriRpScpRtCnoteVO> deleteCnoteVoList = new ArrayList<PriRpScpRtCnoteVO>();
			List<PriRfaNoteConvListVO> insertConvVoList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> updateConvVoList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> deleteConvVoList = new ArrayList<PriRfaNoteConvListVO>();

			for (int i = 0; vo != null && i < vo.length; i++) {
				if (vo[i].getIbflag().equals("I")) {
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(vo[i]);
				} else if (vo[i].getIbflag().equals("U")) {
					vo[i].setUpdUsrId(account.getUsr_id());
					if ("-1".equals(vo[i].getN1stCmncAmdtSeq())) {
						vo[i].setN1stCmncAmdtSeq(vo[i].getAmdtSeq());
						deleteVoList.add(vo[i]);
					} else {
						updateVoList.add(vo[i]);
					}
				} else if (vo[i].getIbflag().equals("D")) {
					vo[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(vo[i]);
				}
			}
			for (int i = 0; dtlvo != null && i < dtlvo.length; i++) {
				if (dtlvo[i].getIbflag().equals("I")) {
					dtlvo[i].setCreUsrId(account.getUsr_id());
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(dtlvo[i]);
				} else if (dtlvo[i].getIbflag().equals("U")) {
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(dtlvo[i]);
				} else if (dtlvo[i].getIbflag().equals("D")) {
					deleteDtlVoList.add(dtlvo[i]);
				}
			}
			for (int i = 0; custvo != null && i < custvo.length; i++) {
				if (custvo[i].getIbflag().equals("I")) {
					custvo[i].setCreUsrId(account.getUsr_id());
					custvo[i].setUpdUsrId(account.getUsr_id());
					insertCustVoList.add(custvo[i]);
				} else if (custvo[i].getIbflag().equals("U")) {
					custvo[i].setUpdUsrId(account.getUsr_id());
					updateCustVoList.add(custvo[i]);
				} else if (custvo[i].getIbflag().equals("D")) {
					deleteCustVoList.add(custvo[i]);
				}
			}
			for (int i = 0; cnotevo != null && i < cnotevo.length; i++) {
				if (cnotevo[i].getIbflag().equals("I")) {
					cnotevo[i].setCreUsrId(account.getUsr_id());
					cnotevo[i].setUpdUsrId(account.getUsr_id());
					insertCnoteVoList.add(cnotevo[i]);
				} else if (cnotevo[i].getIbflag().equals("U")) {
					cnotevo[i].setUpdUsrId(account.getUsr_id());
					updateCnoteVoList.add(cnotevo[i]);
				} else if (cnotevo[i].getIbflag().equals("D")) {
					deleteCnoteVoList.add(cnotevo[i]);
				}
			}
			for (int i = 0; convvo != null && i < convvo.length; i++) {
				if (convvo[i].getIbflag().equals("I")) {
					convvo[i].setCreUsrId(account.getUsr_id());
					convvo[i].setUpdUsrId(account.getUsr_id());
					insertConvVoList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("U")) {
					convvo[i].setUpdUsrId(account.getUsr_id());
					updateConvVoList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("D")) {
					deleteConvVoList.add(convvo[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addRateCommodityHeader(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addRateCommodity(insertDtlVoList);
			}
			if (insertCustVoList.size() > 0) {
				dbDao.addRateActualCustomer(insertCustVoList);
			}
			if (insertCnoteVoList.size() > 0) {
				dbDao.addRateCnote(insertCnoteVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateCommodityHeader(updateVoList, "N");
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyRateCommodity(updateDtlVoList, "N");
			}
			if (updateCustVoList.size() > 0) {
				dbDao.modifyRateActualCustomer(updateCustVoList, "N");
			}
			if (updateCnoteVoList.size() > 0) {
				dbDao.modifyRateCnote(updateCnoteVoList, "N");
			}

			if (deleteCnoteVoList.size() > 0) {
				dbDao.removeRateCnote(deleteCnoteVoList);
			}
			if (deleteCustVoList.size() > 0) {
				dbDao.removeRateActualCustomer(deleteCustVoList);
			}
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeRateCommodity(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeRateCommodityHeaderCascadeCgoSpec(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeRt(deleteVoList);				
				dbDao.removeRateCommodityHeaderCascadeRnote(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeRoutVia(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeRoutPnt(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeCmdtRout(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeCnote(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeActCust(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeCmdt(deleteVoList);
				dbDao.removeRateCommodityHeader(deleteVoList);
				
				dbDao.removeRateCommodityHeaderDelAmendRt(deleteVoList);
				dbDao.removeRateCommodityHeaderDelAmendRnote(deleteVoList);
				dbDao.removeRateCommodityHeaderDelAmendRoutVia(deleteVoList);
				dbDao.removeRateCommodityHeaderDelAmendRoutPnt(deleteVoList);
				dbDao.removeRateCommodityHeaderDelAmendCnote(deleteVoList);
				dbDao.removeRateCommodityHeaderDelAmendActCust(deleteVoList);
				dbDao.removeRateCommodityHeaderDelAmendCmdt(deleteVoList);
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
	 * Handling multi-transaction of Route and Rate data<br>
	 * 
	 * @param RfaRtPropRtVO rfaRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRate(RfaRtPropRtVO rfaRtPropRtVO, SignOnUserAccount account) throws EventException {
		try {
			PriRpScpRtCmdtRoutVO noteSeqVO = rfaRtPropRtVO.getPriRpScpRtCmdtRoutVO();
			PriRpScpRtCmdtRoutVO[] routvo = rfaRtPropRtVO.getPriRpScpRtCmdtRoutVOS();
			PriRpScpRtRoutPntVO[] orgpntvo = rfaRtPropRtVO.getPriRpScpRtRoutOrgPntVOS();
			PriRpScpRtRoutViaVO[] orgviavo = rfaRtPropRtVO.getPriRpScpRtRoutOrgViaVOS();
			PriRpScpRtRoutViaVO[] destviavo = rfaRtPropRtVO.getPriRpScpRtRoutDestViaVOS();
			PriRpScpRtRoutPntVO[] destpntvo = rfaRtPropRtVO.getPriRpScpRtRoutDestPntVOS();
			PriRpScpRtCmdtRnoteVO[] rnotevo = rfaRtPropRtVO.getPriRpScpRtCmdtRnoteVOS();
			PriRfaNoteConvListVO[] convvo = rfaRtPropRtVO.getPriRfaNoteConvListVOS();
			PriRpScpRtVO[] rtvo = rfaRtPropRtVO.getPriRpScpRtVOS();

			List<PriRpScpRtCmdtRoutVO> insertRoutList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			List<PriRpScpRtCmdtRoutVO> updateRoutList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			List<PriRpScpRtCmdtRoutVO> deleteRoutList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			List<PriRpScpRtRoutPntVO> insertPntList = new ArrayList<PriRpScpRtRoutPntVO>();
			List<PriRpScpRtRoutPntVO> updatePntList = new ArrayList<PriRpScpRtRoutPntVO>();
			List<PriRpScpRtRoutPntVO> deletePntList = new ArrayList<PriRpScpRtRoutPntVO>();
			List<PriRpScpRtRoutViaVO> insertViaList = new ArrayList<PriRpScpRtRoutViaVO>();
			List<PriRpScpRtRoutViaVO> updateViaList = new ArrayList<PriRpScpRtRoutViaVO>();
			List<PriRpScpRtRoutViaVO> deleteViaList = new ArrayList<PriRpScpRtRoutViaVO>();
			List<PriRpScpRtCmdtRnoteVO> insertRnoteList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
			List<PriRpScpRtCmdtRnoteVO> updateRnoteList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
			List<PriRpScpRtCmdtRnoteVO> deleteRnoteList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
			List<PriRfaNoteConvListVO> insertConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> updateConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> deleteConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRpScpRtVO> insertRtList = new ArrayList<PriRpScpRtVO>();
			List<PriRpScpRtVO> updateRtList = new ArrayList<PriRpScpRtVO>();
			List<PriRpScpRtVO> deleteRtList = new ArrayList<PriRpScpRtVO>();
			List<PriRpScpRtVO> amendCancelRtList = new ArrayList<PriRpScpRtVO>();

			for (int i = 0; routvo != null && i < routvo.length; i++) {
				if (routvo[i].getIbflag().equals("I")) {
					routvo[i].setCreUsrId(account.getUsr_id());
					routvo[i].setUpdUsrId(account.getUsr_id());
					insertRoutList.add(routvo[i]);
				} else if (routvo[i].getIbflag().equals("U")) {
					routvo[i].setUpdUsrId(account.getUsr_id());
					if ("-1".equals(routvo[i].getN1stCmncAmdtSeq())) {
						routvo[i].setN1stCmncAmdtSeq(routvo[i].getAmdtSeq());
						deleteRoutList.add(routvo[i]);
					} else {
						updateRoutList.add(routvo[i]);
					}
				} else if (routvo[i].getIbflag().equals("D")) {
					routvo[i].setUpdUsrId(account.getUsr_id());
					deleteRoutList.add(routvo[i]);
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
			for (int i = 0; rnotevo != null && i < rnotevo.length; i++) {
				if (rnotevo[i].getIbflag().equals("I")) {
					rnotevo[i].setCreUsrId(account.getUsr_id());
					rnotevo[i].setUpdUsrId(account.getUsr_id());
					insertRnoteList.add(rnotevo[i]);
				} else if (rnotevo[i].getIbflag().equals("U")) {
					rnotevo[i].setUpdUsrId(account.getUsr_id());
					updateRnoteList.add(rnotevo[i]);
				} else if (rnotevo[i].getIbflag().equals("D")) {
					deleteRnoteList.add(rnotevo[i]);
				}
			}
			for (int i = 0; convvo != null && i < convvo.length; i++) {
				if (convvo[i].getIbflag().equals("I")) {
					convvo[i].setCreUsrId(account.getUsr_id());
					convvo[i].setUpdUsrId(account.getUsr_id());
					insertConvList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("U")) {
					convvo[i].setUpdUsrId(account.getUsr_id());
					updateConvList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("D")) {
					deleteConvList.add(convvo[i]);
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
					
					if ("0".equals(rtvo[i].getAmdtSeq())) {
						continue;
					}
					if (!rtvo[i].getAmdtSeq().equals(rtvo[i].getN1stCmncAmdtSeq())) {
						rtvo[i].setCreUsrId(account.getUsr_id());
						rtvo[i].setUpdUsrId(account.getUsr_id());
						amendCancelRtList.add(rtvo[i]);
					}
				} else if (rtvo[i].getIbflag().equals("D")) {
					deleteRtList.add(rtvo[i]);
				}
			}

			if (insertRoutList.size() > 0) {
				dbDao.addRateCommodityRoute(insertRoutList);
			}
			if (insertPntList.size() > 0) {
				dbDao.addRateRoutePoint(insertPntList);
			}
			if (insertViaList.size() > 0) {
				dbDao.addRateRouteVia(insertViaList);
			}
			if (insertRnoteList.size() > 0) {
				dbDao.addRateCommodityRnote(insertRnoteList);
			}
			if (insertRtList.size() > 0) {
				dbDao.addRate(insertRtList);
			}

			if (updateRoutList.size() > 0) {
				dbDao.modifyRateCommodityRoute(updateRoutList, "N");
			}
			if (updatePntList.size() > 0) {
				dbDao.modifyRateRoutePoint(updatePntList, "N");
			}
			if (updateViaList.size() > 0) {
				dbDao.modifyRateRouteVia(updateViaList, "N");
			}
			if (updateRnoteList.size() > 0) {
				dbDao.modifyRateCommodityRnote(updateRnoteList, "N");
			}
			if (updateRtList.size() > 0) {
				dbDao.modifyRate(updateRtList, "N");
			}

			

			if (deleteRtList.size() > 0) {
				dbDao.removeRateCascadeCgoSpec(deleteRtList);
				dbDao.removeRate(deleteRtList);
			}
			if (deleteRnoteList.size() > 0) {
				dbDao.removeRateCommodityRnote(deleteRnoteList);
			}
			if (deleteViaList.size() > 0) {
				dbDao.removeRateRouteVia(deleteViaList);
			}
			if (deletePntList.size() > 0) {
				dbDao.removeRateRoutePoint(deletePntList);
			}
			if (deleteRoutList.size() > 0) {
				dbDao.removeRateCommodityRouteCascadeCgoSpec(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRt(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRnote(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRoutVia(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRoutPnt(deleteRoutList);
				dbDao.removeRateCommodityRoute(deleteRoutList);
				
				dbDao.removeRateCommodityRouteDelAmendRt(deleteRoutList);
				dbDao.removeRateCommodityRouteDelAmendRnote(deleteRoutList);
				dbDao.removeRateCommodityRouteDelAmendRoutVia(deleteRoutList);
				dbDao.removeRateCommodityRouteDelAmendRoutPnt(deleteRoutList);
			}

			dbDao.modifyRouteNoteDispSeq(noteSeqVO, "1");

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Accepting Actual Customer data<br>
	 * 
	 * @param PriRpScpRtActCustVO[] priRpScpRtActCustVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptActualCustomer(PriRpScpRtActCustVO[] priRpScpRtActCustVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtActCustVO> updateVoList = new ArrayList<PriRpScpRtActCustVO>();

			for (int i = 0; priRpScpRtActCustVOs != null && i < priRpScpRtActCustVOs.length; i++) {
				if (priRpScpRtActCustVOs[i].getIbflag().equals("U")) {
					priRpScpRtActCustVOs[i].setPrcProgStsCd("A");
					priRpScpRtActCustVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpRtActCustVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpRtActCustVOs[i].setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
							"yyyy-MM-dd HH:mm:ss"));

					priRpScpRtActCustVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtActCustVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateActualCustomer(updateVoList, "Y");
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
	 * Canceling acceptance of Actual Customer data<br>
	 * 
	 * @param PriRpScpRtActCustVO[] priRpScpRtActCustVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelActualCustomer(PriRpScpRtActCustVO[] priRpScpRtActCustVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtActCustVO> updateVoList = new ArrayList<PriRpScpRtActCustVO>();

			for (int i = 0; priRpScpRtActCustVOs != null && i < priRpScpRtActCustVOs.length; i++) {
				if (priRpScpRtActCustVOs[i].getIbflag().equals("U")) {
					priRpScpRtActCustVOs[i].setAcptUsrId(null);
					priRpScpRtActCustVOs[i].setAcptOfcCd(null);
					priRpScpRtActCustVOs[i].setAcptDt(null);

					priRpScpRtActCustVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtActCustVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateActualCustomer(updateVoList, "Y");
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
	 * Accepting Rate data<br>
	 * 
	 * @param PriRpScpRtVO[] priRpScpRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRate(PriRpScpRtVO[] priRpScpRtVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtVO> updateVoList = new ArrayList<PriRpScpRtVO>();

			for (int i = 0; priRpScpRtVOs != null && i < priRpScpRtVOs.length; i++) {
				if (priRpScpRtVOs[i].getIbflag().equals("U")) {
					priRpScpRtVOs[i].setPrcProgStsCd("A");
					priRpScpRtVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpRtVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpRtVOs[i].setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
							"yyyy-MM-dd HH:mm:ss"));

					priRpScpRtVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRate(updateVoList, "Y");
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
	 * Canceling acceptance of Rate data<br>
	 * 
	 * @param PriRpScpRtVO[] priRpScpRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRate(PriRpScpRtVO[] priRpScpRtVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtVO> updateVoList = new ArrayList<PriRpScpRtVO>();

			for (int i = 0; priRpScpRtVOs != null && i < priRpScpRtVOs.length; i++) {
				if (priRpScpRtVOs[i].getIbflag().equals("U")) {
					priRpScpRtVOs[i].setAcptUsrId(null);
					priRpScpRtVOs[i].setAcptOfcCd(null);
					priRpScpRtVOs[i].setAcptDt(null);

					priRpScpRtVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRate(updateVoList, "Y");
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
	 * Accepting Commodity Note data<br>
	 * 
	 * @param PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCnote(PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtCnoteVO> updateVoList = new ArrayList<PriRpScpRtCnoteVO>();

			for (int i = 0; priRpScpRtCnoteVOs != null && i < priRpScpRtCnoteVOs.length; i++) {
				if (priRpScpRtCnoteVOs[i].getIbflag().equals("U")) {
					priRpScpRtCnoteVOs[i].setPrcProgStsCd("A");
					priRpScpRtCnoteVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpRtCnoteVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpRtCnoteVOs[i].setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
							"yyyy-MM-dd HH:mm:ss"));

					priRpScpRtCnoteVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtCnoteVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateCnote(updateVoList, "Y");
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
	 * Canceling acceptance of Commodity Note data<br>
	 * 
	 * @param PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCnote(PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtCnoteVO> updateVoList = new ArrayList<PriRpScpRtCnoteVO>();

			for (int i = 0; priRpScpRtCnoteVOs != null && i < priRpScpRtCnoteVOs.length; i++) {
				if (priRpScpRtCnoteVOs[i].getIbflag().equals("U")) {
					priRpScpRtCnoteVOs[i].setAcptUsrId(null);
					priRpScpRtCnoteVOs[i].setAcptOfcCd(null);
					priRpScpRtCnoteVOs[i].setAcptDt(null);

					priRpScpRtCnoteVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtCnoteVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateCnote(updateVoList, "Y");
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
	 * Accepting Commodity data<br>
	 * 
	 * @param PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCommodityDetail(PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtCmdtVO> updateVoList = new ArrayList<PriRpScpRtCmdtVO>();

			for (int i = 0; priRpScpRtCmdtVOs != null && i < priRpScpRtCmdtVOs.length; i++) {
				if (priRpScpRtCmdtVOs[i].getIbflag().equals("U")) {
					priRpScpRtCmdtVOs[i].setPrcProgStsCd("A");
					priRpScpRtCmdtVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpRtCmdtVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpRtCmdtVOs[i].setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
							"yyyy-MM-dd HH:mm:ss"));

					priRpScpRtCmdtVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtCmdtVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateCommodity(updateVoList, "Y");
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
	 * Canceling acceptance of Commodity data<br>
	 * 
	 * @param PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCommodityDetail(PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtCmdtVO> updateVoList = new ArrayList<PriRpScpRtCmdtVO>();

			for (int i = 0; priRpScpRtCmdtVOs != null && i < priRpScpRtCmdtVOs.length; i++) {
				if (priRpScpRtCmdtVOs[i].getIbflag().equals("U")) {
					priRpScpRtCmdtVOs[i].setAcptUsrId(null);
					priRpScpRtCmdtVOs[i].setAcptOfcCd(null);
					priRpScpRtCmdtVOs[i].setAcptDt(null);

					priRpScpRtCmdtVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtCmdtVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateCommodity(updateVoList, "Y");
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
	 * Accepting Route Note data<br>
	 * 
	 * @param PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCommodityRnote(PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtCmdtRnoteVO> updateVoList = new ArrayList<PriRpScpRtCmdtRnoteVO>();

			for (int i = 0; priRpScpRtCmdtRnoteVOs != null && i < priRpScpRtCmdtRnoteVOs.length; i++) {
				if (priRpScpRtCmdtRnoteVOs[i].getIbflag().equals("U")) {
					priRpScpRtCmdtRnoteVOs[i].setPrcProgStsCd("A");
					priRpScpRtCmdtRnoteVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpRtCmdtRnoteVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpRtCmdtRnoteVOs[i].setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
							"yyyy-MM-dd HH:mm:ss"));

					priRpScpRtCmdtRnoteVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtCmdtRnoteVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateCommodityRnote(updateVoList, "Y");
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
	 * Canceling acceptance of Route Note data.<br>
	 * 
	 * @param PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCommodityRnote(PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtCmdtRnoteVO> updateVoList = new ArrayList<PriRpScpRtCmdtRnoteVO>();

			for (int i = 0; priRpScpRtCmdtRnoteVOs != null && i < priRpScpRtCmdtRnoteVOs.length; i++) {
				if (priRpScpRtCmdtRnoteVOs[i].getIbflag().equals("U")) {
					priRpScpRtCmdtRnoteVOs[i].setAcptUsrId(null);
					priRpScpRtCmdtRnoteVOs[i].setAcptOfcCd(null);
					priRpScpRtCmdtRnoteVOs[i].setAcptDt(null);

					priRpScpRtCmdtRnoteVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtCmdtRnoteVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateCommodityRnote(updateVoList, "Y");
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
	 * Accepting Route Point data.<br>
	 * 
	 * @param PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateRoutePointDetail(PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtRoutPntVO> updateVoList = new ArrayList<PriRpScpRtRoutPntVO>();

			for (int i = 0; priRpScpRtRoutPntVOs != null && i < priRpScpRtRoutPntVOs.length; i++) {
				if (priRpScpRtRoutPntVOs[i].getIbflag().equals("U")) {
					priRpScpRtRoutPntVOs[i].setPrcProgStsCd("A");
					priRpScpRtRoutPntVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpRtRoutPntVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpRtRoutPntVOs[i].setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
							"yyyy-MM-dd HH:mm:ss"));

					priRpScpRtRoutPntVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtRoutPntVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateRoutePoint(updateVoList, "Y");
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
	 * Canceling acceptance of Route Point data<br>
	 * 
	 * @param PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateRoutePointDetail(PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtRoutPntVO> updateVoList = new ArrayList<PriRpScpRtRoutPntVO>();

			for (int i = 0; priRpScpRtRoutPntVOs != null && i < priRpScpRtRoutPntVOs.length; i++) {
				if (priRpScpRtRoutPntVOs[i].getIbflag().equals("U")) {
					priRpScpRtRoutPntVOs[i].setAcptUsrId(null);
					priRpScpRtRoutPntVOs[i].setAcptOfcCd(null);
					priRpScpRtRoutPntVOs[i].setAcptDt(null);

					priRpScpRtRoutPntVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtRoutPntVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateRoutePoint(updateVoList, "Y");
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
	 * Accepting Route Via. data<br>
	 * 
	 * @param PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateRouteViaDetail(PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtRoutViaVO> updateVoList = new ArrayList<PriRpScpRtRoutViaVO>();

			for (int i = 0; priRpScpRtRoutViaVOs != null && i < priRpScpRtRoutViaVOs.length; i++) {
				if (priRpScpRtRoutViaVOs[i].getIbflag().equals("U")) {
					priRpScpRtRoutViaVOs[i].setPrcProgStsCd("A");
					priRpScpRtRoutViaVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpRtRoutViaVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpRtRoutViaVOs[i].setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
							"yyyy-MM-dd HH:mm:ss"));

					priRpScpRtRoutViaVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtRoutViaVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateRouteVia(updateVoList, "Y");
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
	 * Canceling acceptance of Route Point data<br>
	 * 
	 * @param PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateRouteViaDetail(PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtRoutViaVO> updateVoList = new ArrayList<PriRpScpRtRoutViaVO>();

			for (int i = 0; priRpScpRtRoutViaVOs != null && i < priRpScpRtRoutViaVOs.length; i++) {
				if (priRpScpRtRoutViaVOs[i].getIbflag().equals("U")) {
					priRpScpRtRoutViaVOs[i].setAcptUsrId(null);
					priRpScpRtRoutViaVOs[i].setAcptOfcCd(null);
					priRpScpRtRoutViaVOs[i].setAcptDt(null);

					priRpScpRtRoutViaVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtRoutViaVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateRouteVia(updateVoList, "Y");
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
	 * Accepting all item of rate<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllRate(PriRpScpRtVO priRpScpRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priRpScpRtVO != null) {
				priRpScpRtVO.setPrcProgStsCd("A");
				priRpScpRtVO.setAcptUsrId(account.getUsr_id());
				priRpScpRtVO.setAcptOfcCd(account.getOfc_cd());
				priRpScpRtVO.setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
						"yyyy-MM-dd HH:mm:ss"));
				priRpScpRtVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyAcceptAllRateCmdt(priRpScpRtVO);
				dbDao.modifyAcceptAllRateActCust(priRpScpRtVO);
				dbDao.modifyAcceptAllRateCnote(priRpScpRtVO);
				dbDao.modifyAcceptAllRateRoutPnt(priRpScpRtVO);
				dbDao.modifyAcceptAllRateRoutVia(priRpScpRtVO);
				dbDao.modifyAcceptAllRateRnote(priRpScpRtVO);
				dbDao.modifyAcceptAllRateRt(priRpScpRtVO);
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
	 * Canceling acceptance of Rate's all item<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllRate(PriRpScpRtVO priRpScpRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priRpScpRtVO != null) {
				priRpScpRtVO.setPrcProgStsCd("I");
				priRpScpRtVO.setAcptUsrId(null);
				priRpScpRtVO.setAcptOfcCd(null);
				priRpScpRtVO.setAcptDt(null);
				priRpScpRtVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyAcceptAllRateCmdt(priRpScpRtVO);
				dbDao.modifyAcceptAllRateActCust(priRpScpRtVO);
				dbDao.modifyAcceptAllRateCnote(priRpScpRtVO);
				dbDao.modifyAcceptAllRateRoutPnt(priRpScpRtVO);
				dbDao.modifyAcceptAllRateRoutVia(priRpScpRtVO);
				dbDao.modifyAcceptAllRateRnote(priRpScpRtVO);
				dbDao.modifyAcceptAllRateRt(priRpScpRtVO);
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
	 * copying Guideline's data<br>
	 * 
	 * @param RfaGlineCopyVO rfaGlineCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineRate(RfaGlineCopyVO rfaGlineCopyVO, SignOnUserAccount account) throws EventException {
		try {
			if (rfaGlineCopyVO != null) {
				rfaGlineCopyVO.setCreUsrId(account.getUsr_id());
				rfaGlineCopyVO.setUpdUsrId(account.getUsr_id());

				dbDao.addRateCommodityHeaderGlineCopy(rfaGlineCopyVO);
				dbDao.addRateCommodityGlineCopy(rfaGlineCopyVO);
				dbDao.addRateCommodityRouteGlineCopy(rfaGlineCopyVO);
				dbDao.addRateRoutePointGlineCopy(rfaGlineCopyVO);
				dbDao.addRateRouteViaGlineCopy(rfaGlineCopyVO);
				int rtCnt = dbDao.addRateGlineCopy(rfaGlineCopyVO);
				if (rtCnt > 0) {
					PriRpScpRtCmdtRoutVO routVO = new PriRpScpRtCmdtRoutVO();
					routVO.setPropNo(rfaGlineCopyVO.getPropNo());
					routVO.setAmdtSeq(rfaGlineCopyVO.getAmdtSeq());
					routVO.setSvcScpCd(rfaGlineCopyVO.getSvcScpCd());

					dbDao.modifyRouteNoteDispSeq(routVO, "0");
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
	 * Checking whether Group Location, Group Commodity exists or not before copying Guideline <br>
	 * 
	 * @param RfaGlineCopyVO rfaGlineCopyVO
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO checkGlineCopyGroupCodeExist(RfaGlineCopyVO rfaGlineCopyVO) throws EventException {
		try {
			return dbDao.searchGlineCopyGroupCodeExist(rfaGlineCopyVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Applying GRI Calculation to rate<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculation(PriRpScpGriGrpVO priRpScpGriGrpVO, SignOnUserAccount account) throws EventException {
		try {
			if (priRpScpGriGrpVO != null) {
				priRpScpGriGrpVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyProposalScopeRateGRIApply(priRpScpGriGrpVO);
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
	 * Canceling applied GRI Calculation<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculation(PriRpScpGriGrpVO priRpScpGriGrpVO, SignOnUserAccount account) throws EventException {
		try {
			if (priRpScpGriGrpVO != null) {
				priRpScpGriGrpVO.setCreUsrId(account.getUsr_id());
				priRpScpGriGrpVO.setUpdUsrId(account.getUsr_id());
				


				dbDao.modifyProposalScopeRateGRICancel(priRpScpGriGrpVO);

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
	 *  Deleting Amend SEQ No's all data when canceling Main's Init status<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception EventException
	 */
	public void removeProposalMain(PriRpScpMnVO priRpScpMnVO) throws EventException {
		try {
			if (priRpScpMnVO != null) {
				
				log.debug("removeProposalMainRtScgUsdRout=====================end");
				dbDao.removeProposalMainRtCgoSpec(priRpScpMnVO);
				dbDao.removeProposalMainRt(priRpScpMnVO);
				dbDao.removeProposalMainRtRoutVia(priRpScpMnVO);
				dbDao.removeProposalMainRtRoutPnt(priRpScpMnVO);
				dbDao.removeProposalMainRtCmdtRnote(priRpScpMnVO);
				dbDao.removeProposalMainRtCmdtRout(priRpScpMnVO);
				
				dbDao.removeProposalMainRtCnote(priRpScpMnVO);
				dbDao.removeProposalMainRtActCust(priRpScpMnVO);
				dbDao.removeProposalMainRtCmdt(priRpScpMnVO);
				dbDao.removeProposalMainRtCmdtHdr(priRpScpMnVO);
				
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
	 * checking whether loaded excel data is correct or not<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVertical(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs) throws EventException {
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
		
		try {
            RsltRtListVerticalExcelVO row = new RsltRtListVerticalExcelVO();

            String strCmdtCd = null;
            String strCustSeq = null;
            String strOrgPntCd = null;
            String strOrgViaCd = null;
            String strDestViaCd = null;
            String strDestPntCd = null;
			for (int i = 0; i < rsltRtListVerticalExcelVOs.length; i++) {
				row = rsltRtListVerticalExcelVOs[i];

				strCmdtCd = row.getPrcCmdtDefCd();
				strCustSeq = row.getCustSeq();
				strOrgPntCd = row.getOrgRoutPntLocDefCd();
				strOrgViaCd = row.getOrgRoutViaPortDefCd();
				strDestViaCd = row.getDestRoutViaPortDefCd();
				strDestPntCd = row.getDestRoutPntLocDefCd();

				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strCmdtCd);

					RsltCdListVO cdVO = dbDao.searchCommodityCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCmdtCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("prc_cmdt_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strCustSeq != null && !"".equals(strCustSeq)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strCustSeq);

					RsltCdListVO cdVO = dbDao.searchActualCustomerExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCustSeq);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("cust_seq");

						rslt.add(cdVO);
					}
				}
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgPntCd);
					paramVO.setEtc1("O");
					
					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_pnt_loc_def_cd");
						
						rslt.add(cdVO);
					}
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgViaCd);
					
					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_via_port_def_cd");
						
						rslt.add(cdVO);
					}
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestViaCd);
					
					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_via_port_def_cd");
						
						rslt.add(cdVO);
					}
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestPntCd);
					paramVO.setEtc1("D");
					
					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_pnt_loc_def_cd");
						
						rslt.add(cdVO);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
		return rslt;
	}
	
	/**
	 * Uploading loaded excel data to Sheet<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String uploadRateExcelVertical(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		UploadRateExcelVerticalBackEndJobImpl jobImpl = new UploadRateExcelVerticalBackEndJobImpl();
		String key = null;
		
		try {
			jobImpl.setPriRpScpRtCmdtHdrVO(priRpScpRtCmdtHdrVO);
			jobImpl.setRsltRtListVerticalExcelVOs(rsltRtListVerticalExcelVOs);
			jobImpl.setAccount(account);
			
			key = backEndJobManager.execute(jobImpl, account.getUsr_id(), "ESM_PRI_0065");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
		return key;
	}
	
	/**
	 * Uploading loaded excel data to Sheet<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVerticalOnline(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account) throws EventException {
		List<PriRpScpRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
		List<PriRpScpRtCmdtVO> cmdtVoList = new ArrayList<PriRpScpRtCmdtVO>();
		List<PriRpScpRtActCustVO> custVoList = new ArrayList<PriRpScpRtActCustVO>();
		List<PriRpScpRtCmdtRoutVO> routVoList = new ArrayList<PriRpScpRtCmdtRoutVO>();
		List<PriRpScpRtRoutPntVO> pntVoList = new ArrayList<PriRpScpRtRoutPntVO>();
		List<PriRpScpRtRoutViaVO> viaVoList = new ArrayList<PriRpScpRtRoutViaVO>();
		List<PriRpScpRtVO> rtVoList = new ArrayList<PriRpScpRtVO>();
		List<PriRpScpRtScgVO> scgVoList = new ArrayList<PriRpScpRtScgVO>();
		
		try {
			int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priRpScpRtCmdtHdrVO);
			int nextBletDpSeq = Integer.parseInt(dbDao.searchMaxBulletDispSeq(priRpScpRtCmdtHdrVO));
			int nextCmdtSeq = 0;
			int nextActCustSeq = 0;
			
			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;
			
			String strPropNo = priRpScpRtCmdtHdrVO.getPropNo();
			String strAmdtSeq = priRpScpRtCmdtHdrVO.getAmdtSeq();
			String strSvcScpCd = priRpScpRtCmdtHdrVO.getSvcScpCd();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();
			
			for (int i = 0; i < rsltRtListVerticalExcelVOs.length; i++) {
				RsltRtListVerticalExcelVO row = rsltRtListVerticalExcelVOs[i];
				
				String strCmdtDpSeq = row.getCmdtDpSeq();
				String strCmdtCd = row.getPrcCmdtDefCd();
				String strCustSeq = row.getCustSeq();
				
				String strRoutDpSeq = row.getRoutDpSeq();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				String strDestPrcTrspModCd = row.getDestPrcTrspModNm();
				
				String strPerTypeCd = row.getRatUtCd();
				String strCgoTypeCd = row.getPrcCgoTpCd();
				String strRateAmt = row.getPropFrtRtAmt();
				
				String strBucAmt = row.getBucUsdAmt();
				String strIfcAmt = row.getIfcUsdAmt();
				String strPscAmt = row.getPscUsdAmt();
				
				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextBletDpSeq++;
					nextCmdtSeq = 0;
					nextActCustSeq = 0;
					nextRoutSeq = 0;
					
					PriRpScpRtCmdtHdrVO cmdtHdr = new PriRpScpRtCmdtHdrVO();
					cmdtHdr.setPropNo(strPropNo);
					cmdtHdr.setAmdtSeq(strAmdtSeq);
					cmdtHdr.setSvcScpCd(strSvcScpCd);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setBletDpSeq(String.valueOf(nextBletDpSeq));
					cmdtHdr.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);
					
					cmdtHdrVoList.add(cmdtHdr);
				}
				
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;
					
					String cmdtTpCd = "";
					if (strCmdtCd.length() == 5) {
						cmdtTpCd = "G";
					} else if (strCmdtCd.length() == 4) {
						cmdtTpCd = "R";
					} else if (strCmdtCd.length() == 6) {
						cmdtTpCd = "C";
					}
					
					PriRpScpRtCmdtVO cmdt = new PriRpScpRtCmdtVO();
					cmdt.setPropNo(strPropNo);
					cmdt.setAmdtSeq(strAmdtSeq);
					cmdt.setSvcScpCd(strSvcScpCd);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setPrcProgStsCd("I");
					cmdt.setSrcInfoCd("NW");
					cmdt.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);
					
					cmdtVoList.add(cmdt);
				}
				if (strCustSeq != null && !"".equals(strCustSeq)) {
					nextActCustSeq++;
					
					PriRpScpRtActCustVO cust = new PriRpScpRtActCustVO();
					cust.setPropNo(strPropNo);
					cust.setAmdtSeq(strAmdtSeq);
					cust.setSvcScpCd(strSvcScpCd);
					cust.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cust.setActCustSeq(String.valueOf(nextActCustSeq));
					cust.setCustCntCd(strCustSeq.substring(0, 2));
					cust.setCustSeq(strCustSeq.substring(2));
					cust.setPrcProgStsCd("I");
					cust.setSrcInfoCd("NW");
					cust.setN1stCmncAmdtSeq(strAmdtSeq);
					cust.setCreUsrId(strCreUsrId);
					cust.setUpdUsrId(strUpdUsrId);
					
					custVoList.add(cust);
				}
				
				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;
					
					PriRpScpRtCmdtRoutVO rout = new PriRpScpRtCmdtRoutVO();
					rout.setPropNo(strPropNo);
					rout.setAmdtSeq(strAmdtSeq);
					rout.setSvcScpCd(strSvcScpCd);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setN1stCmncAmdtSeq(strAmdtSeq);
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);
					
					routVoList.add(rout);
				}
				
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;
					
					String locTpCd = strOrgPntCd.length() == 4 ? "G" : "L";
					
					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("O");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strOrgPntCd);
					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
					pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);
					
					pntVoList.add(pnt);
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					nextRoutViaSeq++;
					
					String locTpCd = strOrgViaCd.length() == 4 ? "G" : "L";
					
					PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
					via.setPropNo(strPropNo);
					via.setAmdtSeq(strAmdtSeq);
					via.setSvcScpCd(strSvcScpCd);
					via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					via.setRoutSeq(String.valueOf(nextRoutSeq));
					via.setOrgDestTpCd("O");
					via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
					via.setRoutViaPortTpCd(locTpCd);
					via.setRoutViaPortDefCd(strOrgViaCd);
					via.setPrcProgStsCd("I");
					via.setSrcInfoCd("NW");
					via.setN1stCmncAmdtSeq(strAmdtSeq);
					via.setCreUsrId(strCreUsrId);
					via.setUpdUsrId(strUpdUsrId);
					
					viaVoList.add(via);
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					nextRoutViaSeq++;
					
					String locTpCd = strDestViaCd.length() == 4 ? "G" : "L";
					
					PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
					via.setPropNo(strPropNo);
					via.setAmdtSeq(strAmdtSeq);
					via.setSvcScpCd(strSvcScpCd);
					via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					via.setRoutSeq(String.valueOf(nextRoutSeq));
					via.setOrgDestTpCd("D");
					via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
					via.setRoutViaPortTpCd(locTpCd);
					via.setRoutViaPortDefCd(strDestViaCd);
					via.setPrcProgStsCd("I");
					via.setSrcInfoCd("NW");
					via.setN1stCmncAmdtSeq(strAmdtSeq);
					via.setCreUsrId(strCreUsrId);
					via.setUpdUsrId(strUpdUsrId);
					
					viaVoList.add(via);
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;
					
					String locTpCd = strDestPntCd.length() == 4 ? "G" : "L";
					
					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("D");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strDestPntCd);
					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
					pnt.setPrcTrspModCd(strDestPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);
					
					pntVoList.add(pnt);
				}
				
				if (strRateAmt != null && !"".equals(strRateAmt)) {
					nextRtSeq++;
					
					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd(strPerTypeCd);
					rt.setPrcCgoTpCd(strCgoTypeCd);
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateAmt);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);
					
					rtVoList.add(rt);
					
					if (strBucAmt != null && !"".equals(strBucAmt)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd(strPerTypeCd);
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucAmt);
						scg.setAdjScgUsdAmt(strBucAmt);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
					if (strIfcAmt != null && !"".equals(strIfcAmt)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd(strPerTypeCd);
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcAmt);
						scg.setAdjScgUsdAmt(strIfcAmt);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
					if (strPscAmt != null && !"".equals(strPscAmt)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd(strPerTypeCd);
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscAmt);
						scg.setAdjScgUsdAmt(strPscAmt);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);
						
						scgVoList.add(scg);
					}
				}
			}
			
			if (cmdtHdrVoList.size() > 0) {
				dbDao.addRateCommodityHeader(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addRateCommodity(cmdtVoList);
			}
			if (custVoList.size() > 0) {
				dbDao.addRateActualCustomer(custVoList);
			}
			
			if (routVoList.size() > 0) {
				dbDao.addRateCommodityRoute(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addRateRoutePoint(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addRateRouteVia(viaVoList);
			}
			
			if (rtVoList.size() > 0) {
				dbDao.addRate(rtVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

//	/**
//	 * Checking whether laoded excel data is correct or not<br>
//	 * 
//	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
//	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
//	 * @return List<RsltCdListVO>
//	 * @exception EventException
//	 */
//	public List<RsltCdListVO> checkRateExcelHorizontal(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs) throws EventException {
//		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
//		
//		try {
//            RsltRtListHorizontalExcelVO row = new RsltRtListHorizontalExcelVO();
//            
//            String strCmdtCd    = null;
//            String strCustSeq   = null;
//            String strOrgPntCd  = null;
//            String strOrgViaCd  = null;
//            String strDestViaCd = null;
//            String strDestPntCd = null;
//
//			for (int i = 0; i < rsltRtListHorizontalExcelVOs.length; i++) {
//				row = rsltRtListHorizontalExcelVOs[i];
//				
//				strCmdtCd = row.getPrcCmdtDefCd();
//				strCustSeq = row.getCustSeq();
//				strOrgPntCd = row.getOrgRoutPntLocDefCd();
//				strOrgViaCd = row.getOrgRoutViaPortDefCd();
//				strDestViaCd = row.getDestRoutViaPortDefCd();
//				strDestPntCd = row.getDestRoutPntLocDefCd();
//				
//				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
//					RsltCdListVO paramVO = new RsltCdListVO();
//					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
//					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
//					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
//					paramVO.setCd(strCmdtCd);
//					
//					RsltCdListVO cdVO = dbDao.searchCommodityCodeExists(paramVO);
//					if (cdVO == null) {
//						cdVO = new RsltCdListVO();
//						cdVO.setCd(strCmdtCd);
//						cdVO.setNm("");
//						cdVO.setEtc1(String.valueOf(i));
//						cdVO.setEtc2("prc_cmdt_def_cd");
//						
//						rslt.add(cdVO);
//					}
//				}
//				if (strCustSeq != null && !"".equals(strCustSeq)) {
//					RsltCdListVO paramVO = new RsltCdListVO();
//					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
//					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
//					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
//					paramVO.setCd(strCustSeq);
//					
//					RsltCdListVO cdVO = dbDao.searchActualCustomerExists(paramVO);
//					if (cdVO == null) {
//						cdVO = new RsltCdListVO();
//						cdVO.setCd(strCustSeq);
//						cdVO.setNm("");
//						cdVO.setEtc1(String.valueOf(i));
//						cdVO.setEtc2("cust_seq");
//						
//						rslt.add(cdVO);
//					}
//				}
//				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
//					RsltCdListVO paramVO = new RsltCdListVO();
//					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
//					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
//					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
//					paramVO.setCd(strOrgPntCd);
//					paramVO.setEtc1("O");
//					
//					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
//					if (cdVO == null) {
//						cdVO = new RsltCdListVO();
//						cdVO.setCd(strOrgPntCd);
//						cdVO.setNm("");
//						cdVO.setEtc1(String.valueOf(i));
//						cdVO.setEtc2("org_rout_pnt_loc_def_cd");
//						
//						rslt.add(cdVO);
//					}
//				}
//				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
//					RsltCdListVO paramVO = new RsltCdListVO();
//					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
//					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
//					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
//					paramVO.setCd(strOrgViaCd);
//					
//					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
//					if (cdVO == null) {
//						cdVO = new RsltCdListVO();
//						cdVO.setCd(strOrgViaCd);
//						cdVO.setNm("");
//						cdVO.setEtc1(String.valueOf(i));
//						cdVO.setEtc2("org_rout_via_port_def_cd");
//						
//						rslt.add(cdVO);
//					}
//				}
//				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
//					RsltCdListVO paramVO = new RsltCdListVO();
//					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
//					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
//					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
//					paramVO.setCd(strDestViaCd);
//					
//					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
//					if (cdVO == null) {
//						cdVO = new RsltCdListVO();
//						cdVO.setCd(strDestViaCd);
//						cdVO.setNm("");
//						cdVO.setEtc1(String.valueOf(i));
//						cdVO.setEtc2("dest_rout_via_port_def_cd");
//						
//						rslt.add(cdVO);
//					}
//				}
//				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
//					RsltCdListVO paramVO = new RsltCdListVO();
//					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
//					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
//					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
//					paramVO.setCd(strDestPntCd);
//					paramVO.setEtc1("D");
//					
//					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
//					if (cdVO == null) {
//						cdVO = new RsltCdListVO();
//						cdVO.setCd(strDestPntCd);
//						cdVO.setNm("");
//						cdVO.setEtc1(String.valueOf(i));
//						cdVO.setEtc2("dest_rout_pnt_loc_def_cd");
//
//						rslt.add(cdVO);
//					}
//				}
//			}
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
//        } catch (Exception ex) {
//            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
//		}
//		
//		return rslt;
//	}
	
//	/**
//	 * Uploading loaded excel data to Sheet<<br>
//	 * 
//	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
//	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
//	 * @param SignOnUserAccount account
//	 * @return String
//	 * @exception EventException
//	 */
//	public String uploadRateExcelHorizontal(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs, SignOnUserAccount account) throws EventException {
//		BackEndJobManager backEndJobManager = new BackEndJobManager();
//		UploadRateExcelHorizontalBackEndJobImpl jobImpl = new UploadRateExcelHorizontalBackEndJobImpl();
//		String key = null;
//		
//		try {
//			jobImpl.setPriRpScpRtCmdtHdrVO(priRpScpRtCmdtHdrVO);
//			jobImpl.setRsltRtListHorizontalExcelVOs(rsltRtListHorizontalExcelVOs);
//			jobImpl.setAccount(account);
//			
//			key = backEndJobManager.execute(jobImpl, account.getUsr_id(), "ESM_PRI_0099");
//		} catch (Exception ex) {
//			throw new EventException(ex.getMessage(),ex);
//		}
//		
//		return key;
//	}
	
//	/**
//	 * Uploading loaded excel data to Sheet<<br>
//	 * 
//	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
//	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void uploadRateExcelHorizontalOnline(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs, SignOnUserAccount account) throws EventException {
//		List<PriRpScpRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
//		List<PriRpScpRtCmdtVO> cmdtVoList = new ArrayList<PriRpScpRtCmdtVO>();
//		List<PriRpScpRtActCustVO> custVoList = new ArrayList<PriRpScpRtActCustVO>();
//		List<PriRpScpRtCmdtRoutVO> routVoList = new ArrayList<PriRpScpRtCmdtRoutVO>();
//		List<PriRpScpRtRoutPntVO> pntVoList = new ArrayList<PriRpScpRtRoutPntVO>();
//		List<PriRpScpRtRoutViaVO> viaVoList = new ArrayList<PriRpScpRtRoutViaVO>();
//		List<PriRpScpRtVO> rtVoList = new ArrayList<PriRpScpRtVO>();
//		List<PriRpScpRtScgVO> scgVoList = new ArrayList<PriRpScpRtScgVO>();
//		
//		try {
//			int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priRpScpRtCmdtHdrVO);
//			int nextBletDpSeq = Integer.parseInt(dbDao.searchMaxBulletDispSeq(priRpScpRtCmdtHdrVO));
//			int nextCmdtSeq = 0;
//			int nextActCustSeq = 0;
//			
//			int nextRoutSeq = 0;
//			int nextRoutPntSeq = 0;
//			int nextRoutViaSeq = 0;
//			int nextRtSeq = 0;
//			
//			String strPropNo = priRpScpRtCmdtHdrVO.getPropNo();
//			String strAmdtSeq = priRpScpRtCmdtHdrVO.getAmdtSeq();
//			String strSvcScpCd = priRpScpRtCmdtHdrVO.getSvcScpCd();
//			String strCreUsrId = account.getUsr_id();
//			String strUpdUsrId = account.getUsr_id();
//			
//			for (int i = 0; i < rsltRtListHorizontalExcelVOs.length; i++) {
//				RsltRtListHorizontalExcelVO row = rsltRtListHorizontalExcelVOs[i];
//				
//				String strCmdtDpSeq = row.getCmdtDpSeq();
//				String strCmdtCd = row.getPrcCmdtDefCd();
//				String strCustSeq = row.getCustSeq();
//				
//				String strRoutDpSeq = row.getRoutDpSeq();
//				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
//				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
//				String strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
//				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
//				String strDestViaCd = row.getDestRoutViaPortDefCd();
//				String strDestPntCd = row.getDestRoutPntLocDefCd();
//				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
//				String strDestPrcTrspModCd = row.getDestPrcTrspModNm();
//				
//				String strRateDry20 = row.getRateDry20();
//				String strRateDry40 = row.getRateDry40();
//				String strRateDry40hc = row.getRateDry40hc();
//				String strRateDry45 = row.getRateDry45();
//				String strRateRf40hc = row.getRateRf40hc();
//				String strRateRd40hc = row.getRateRd40hc();
//				
//				String strBucDry20 = row.getBucDry20();
//				String strBucDry40 = row.getBucDry40();
//				String strBucDry40hc = row.getBucDry40hc();
//				String strBucDry45 = row.getBucDry45();
//				String strBucRf40hc = row.getBucRf40hc();
//				String strBucRd40hc = row.getBucRd40hc();
//				
//				String strIfcDry20 = row.getIfcDry20();
//				String strIfcDry40 = row.getIfcDry40();
//				String strIfcDry40hc = row.getIfcDry40hc();
//				String strIfcDry45 = row.getIfcDry45();
//				String strIfcRf40hc = row.getIfcRf40hc();
//				String strIfcRd40hc = row.getIfcRd40hc();
//
//				String strPscDry20 = row.getPscDry20();
//				String strPscDry40 = row.getPscDry40();
//				String strPscDry40hc = row.getPscDry40hc();
//				String strPscDry45 = row.getPscDry45();
//				String strPscRf40hc = row.getPscRf40hc();
//				String strPscRd40hc = row.getPscRd40hc();
//
//				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
//					nextCmdtHdrSeq++;
//					nextBletDpSeq++;
//					nextCmdtSeq = 0;
//					nextActCustSeq = 0;
//					nextRoutSeq = 0;
//					
//					PriRpScpRtCmdtHdrVO cmdtHdr = new PriRpScpRtCmdtHdrVO();
//					cmdtHdr.setPropNo(strPropNo);
//					cmdtHdr.setAmdtSeq(strAmdtSeq);
//					cmdtHdr.setSvcScpCd(strSvcScpCd);
//					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//					cmdtHdr.setBletDpSeq(String.valueOf(nextBletDpSeq));
//					cmdtHdr.setN1stCmncAmdtSeq(strAmdtSeq);
//					cmdtHdr.setCreUsrId(strCreUsrId);
//					cmdtHdr.setUpdUsrId(strUpdUsrId);
//					
//					cmdtHdrVoList.add(cmdtHdr);
//				}
//				
//				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
//					nextCmdtSeq++;
//					
//					String cmdtTpCd = "";
//					if (strCmdtCd.length() == 5) {
//						cmdtTpCd = "G";
//					} else if (strCmdtCd.length() == 4) {
//						cmdtTpCd = "R";
//					} else if (strCmdtCd.length() == 6) {
//						cmdtTpCd = "C";
//					}
//					
//					PriRpScpRtCmdtVO cmdt = new PriRpScpRtCmdtVO();
//					cmdt.setPropNo(strPropNo);
//					cmdt.setAmdtSeq(strAmdtSeq);
//					cmdt.setSvcScpCd(strSvcScpCd);
//					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
//					cmdt.setPrcCmdtTpCd(cmdtTpCd);
//					cmdt.setPrcCmdtDefCd(strCmdtCd);
//					cmdt.setPrcProgStsCd("I");
//					cmdt.setSrcInfoCd("NW");
//					cmdt.setN1stCmncAmdtSeq(strAmdtSeq);
//					cmdt.setCreUsrId(strCreUsrId);
//					cmdt.setUpdUsrId(strUpdUsrId);
//					
//					cmdtVoList.add(cmdt);
//				}
//				if (strCustSeq != null && !"".equals(strCustSeq)) {
//					nextActCustSeq++;
//					
//					PriRpScpRtActCustVO cust = new PriRpScpRtActCustVO();
//					cust.setPropNo(strPropNo);
//					cust.setAmdtSeq(strAmdtSeq);
//					cust.setSvcScpCd(strSvcScpCd);
//					cust.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//					cust.setActCustSeq(String.valueOf(nextActCustSeq));
//					cust.setCustCntCd(strCustSeq.substring(0, 2));
//					cust.setCustSeq(strCustSeq.substring(2));
//					cust.setPrcProgStsCd("I");
//					cust.setSrcInfoCd("NW");
//					cust.setN1stCmncAmdtSeq(strAmdtSeq);
//					cust.setCreUsrId(strCreUsrId);
//					cust.setUpdUsrId(strUpdUsrId);
//					
//					custVoList.add(cust);
//				}
//				
//				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
//					nextRoutSeq++;
//					nextRoutPntSeq = 0;
//					nextRoutViaSeq = 0;
//					nextRtSeq = 0;
//					
//					PriRpScpRtCmdtRoutVO rout = new PriRpScpRtCmdtRoutVO();
//					rout.setPropNo(strPropNo);
//					rout.setAmdtSeq(strAmdtSeq);
//					rout.setSvcScpCd(strSvcScpCd);
//					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//					rout.setRoutSeq(String.valueOf(nextRoutSeq));
//					rout.setN1stCmncAmdtSeq(strAmdtSeq);
//					rout.setCreUsrId(strCreUsrId);
//					rout.setUpdUsrId(strUpdUsrId);
//					
//					routVoList.add(rout);
//				}
//				
//				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
//					nextRoutPntSeq++;
//					
//					String locTpCd = strOrgPntCd.length() == 4 ? "G" : "L";
//					
//					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
//					pnt.setPropNo(strPropNo);
//					pnt.setAmdtSeq(strAmdtSeq);
//					pnt.setSvcScpCd(strSvcScpCd);
//					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
//					pnt.setOrgDestTpCd("O");
//					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
//					pnt.setRoutPntLocTpCd(locTpCd);
//					pnt.setRoutPntLocDefCd(strOrgPntCd);
//					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
//					pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
//					pnt.setPrcProgStsCd("I");
//					pnt.setSrcInfoCd("NW");
//					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
//					pnt.setCreUsrId(strCreUsrId);
//					pnt.setUpdUsrId(strUpdUsrId);
//					
//					pntVoList.add(pnt);
//				}
//				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
//					nextRoutViaSeq++;
//					
//					String locTpCd = strOrgViaCd.length() == 4 ? "G" : "L";
//					
//					PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
//					via.setPropNo(strPropNo);
//					via.setAmdtSeq(strAmdtSeq);
//					via.setSvcScpCd(strSvcScpCd);
//					via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//					via.setRoutSeq(String.valueOf(nextRoutSeq));
//					via.setOrgDestTpCd("O");
//					via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
//					via.setRoutViaPortTpCd(locTpCd);
//					via.setRoutViaPortDefCd(strOrgViaCd);
//					via.setPrcProgStsCd("I");
//					via.setSrcInfoCd("NW");
//					via.setN1stCmncAmdtSeq(strAmdtSeq);
//					via.setCreUsrId(strCreUsrId);
//					via.setUpdUsrId(strUpdUsrId);
//					
//					viaVoList.add(via);
//				}
//				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
//					nextRoutViaSeq++;
//					
//					String locTpCd = strDestViaCd.length() == 4 ? "G" : "L";
//					
//					PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
//					via.setPropNo(strPropNo);
//					via.setAmdtSeq(strAmdtSeq);
//					via.setSvcScpCd(strSvcScpCd);
//					via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//					via.setRoutSeq(String.valueOf(nextRoutSeq));
//					via.setOrgDestTpCd("D");
//					via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
//					via.setRoutViaPortTpCd(locTpCd);
//					via.setRoutViaPortDefCd(strDestViaCd);
//					via.setPrcProgStsCd("I");
//					via.setSrcInfoCd("NW");
//					via.setN1stCmncAmdtSeq(strAmdtSeq);
//					via.setCreUsrId(strCreUsrId);
//					via.setUpdUsrId(strUpdUsrId);
//					
//					viaVoList.add(via);
//				}
//				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
//					nextRoutPntSeq++;
//					
//					String locTpCd = strDestPntCd.length() == 4 ? "G" : "L";
//					
//					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
//					pnt.setPropNo(strPropNo);
//					pnt.setAmdtSeq(strAmdtSeq);
//					pnt.setSvcScpCd(strSvcScpCd);
//					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
//					pnt.setOrgDestTpCd("D");
//					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
//					pnt.setRoutPntLocTpCd(locTpCd);
//					pnt.setRoutPntLocDefCd(strDestPntCd);
//					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
//					pnt.setPrcTrspModCd(strDestPrcTrspModCd);
//					pnt.setPrcProgStsCd("I");
//					pnt.setSrcInfoCd("NW");
//					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
//					pnt.setCreUsrId(strCreUsrId);
//					pnt.setUpdUsrId(strUpdUsrId);
//					
//					pntVoList.add(pnt);
//				}
//				
//				if (strRateDry20 != null && !"".equals(strRateDry20)) {
//					nextRtSeq++;
//					
//					PriRpScpRtVO rt = new PriRpScpRtVO();
//					rt.setPropNo(strPropNo);
//					rt.setAmdtSeq(strAmdtSeq);
//					rt.setSvcScpCd(strSvcScpCd);
//					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//					rt.setRoutSeq(String.valueOf(nextRoutSeq));
//					rt.setRtSeq(String.valueOf(nextRtSeq));
//					rt.setRatUtCd("D2");
//					rt.setPrcCgoTpCd("DR");
//					rt.setCurrCd("USD");
//					rt.setPropFrtRtAmt(strRateDry20);
//					rt.setGriApplTpCd("N");
//					rt.setGriApplAmt("0");
//					rt.setPrcProgStsCd("I");
//					rt.setSrcInfoCd("NW");
//					rt.setN1stCmncAmdtSeq(strAmdtSeq);
//					rt.setCreUsrId(strCreUsrId);
//					rt.setUpdUsrId(strUpdUsrId);
//					
//					rtVoList.add(rt);
//					
//					if (strBucDry20 != null && !"".equals(strBucDry20)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("BUC");
//						scg.setBkgRatUtCd("D2");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strBucDry20);
//						scg.setAdjScgUsdAmt(strBucDry20);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//					if (strIfcDry20 != null && !"".equals(strIfcDry20)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("IFC");
//						scg.setBkgRatUtCd("D2");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strIfcDry20);
//						scg.setAdjScgUsdAmt(strIfcDry20);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//					if (strPscDry20 != null && !"".equals(strPscDry20)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("PSC");
//						scg.setBkgRatUtCd("D2");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strPscDry20);
//						scg.setAdjScgUsdAmt(strPscDry20);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//				}
//				
//				if (strRateDry40 != null && !"".equals(strRateDry40)) {
//					nextRtSeq++;
//					
//					PriRpScpRtVO rt = new PriRpScpRtVO();
//					rt.setPropNo(strPropNo);
//					rt.setAmdtSeq(strAmdtSeq);
//					rt.setSvcScpCd(strSvcScpCd);
//					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//					rt.setRoutSeq(String.valueOf(nextRoutSeq));
//					rt.setRtSeq(String.valueOf(nextRtSeq));
//					rt.setRatUtCd("D4");
//					rt.setPrcCgoTpCd("DR");
//					rt.setCurrCd("USD");
//					rt.setPropFrtRtAmt(strRateDry40);
//					rt.setGriApplTpCd("N");
//					rt.setGriApplAmt("0");
//					rt.setPrcProgStsCd("I");
//					rt.setSrcInfoCd("NW");
//					rt.setN1stCmncAmdtSeq(strAmdtSeq);
//					rt.setCreUsrId(strCreUsrId);
//					rt.setUpdUsrId(strUpdUsrId);
//					
//					rtVoList.add(rt);
//					
//					if (strBucDry40 != null && !"".equals(strBucDry40)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("BUC");
//						scg.setBkgRatUtCd("D4");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strBucDry40);
//						scg.setAdjScgUsdAmt(strBucDry40);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//					if (strIfcDry40 != null && !"".equals(strIfcDry40)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("IFC");
//						scg.setBkgRatUtCd("D4");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strIfcDry40);
//						scg.setAdjScgUsdAmt(strIfcDry40);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//					if (strPscDry40 != null && !"".equals(strPscDry40)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("PSC");
//						scg.setBkgRatUtCd("D4");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strPscDry40);
//						scg.setAdjScgUsdAmt(strPscDry40);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//				}
//
//				if (strRateDry40hc != null && !"".equals(strRateDry40hc)) {
//					nextRtSeq++;
//					
//					PriRpScpRtVO rt = new PriRpScpRtVO();
//					rt.setPropNo(strPropNo);
//					rt.setAmdtSeq(strAmdtSeq);
//					rt.setSvcScpCd(strSvcScpCd);
//					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//					rt.setRoutSeq(String.valueOf(nextRoutSeq));
//					rt.setRtSeq(String.valueOf(nextRtSeq));
//					rt.setRatUtCd("D5");
//					rt.setPrcCgoTpCd("DR");
//					rt.setCurrCd("USD");
//					rt.setPropFrtRtAmt(strRateDry40hc);
//					rt.setGriApplTpCd("N");
//					rt.setGriApplAmt("0");
//					rt.setPrcProgStsCd("I");
//					rt.setSrcInfoCd("NW");
//					rt.setN1stCmncAmdtSeq(strAmdtSeq);
//					rt.setCreUsrId(strCreUsrId);
//					rt.setUpdUsrId(strUpdUsrId);
//					
//					rtVoList.add(rt);
//					
//					if (strBucDry40hc != null && !"".equals(strBucDry40hc)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("BUC");
//						scg.setBkgRatUtCd("D5");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strBucDry40hc);
//						scg.setAdjScgUsdAmt(strBucDry40hc);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//					if (strIfcDry40hc != null && !"".equals(strIfcDry40hc)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("IFC");
//						scg.setBkgRatUtCd("D5");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strIfcDry40hc);
//						scg.setAdjScgUsdAmt(strIfcDry40hc);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//					if (strPscDry40hc != null && !"".equals(strPscDry40hc)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("PSC");
//						scg.setBkgRatUtCd("D5");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strPscDry40hc);
//						scg.setAdjScgUsdAmt(strPscDry40hc);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//				}
//
//				if (strRateDry45 != null && !"".equals(strRateDry45)) {
//					nextRtSeq++;
//					
//					PriRpScpRtVO rt = new PriRpScpRtVO();
//					rt.setPropNo(strPropNo);
//					rt.setAmdtSeq(strAmdtSeq);
//					rt.setSvcScpCd(strSvcScpCd);
//					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//					rt.setRoutSeq(String.valueOf(nextRoutSeq));
//					rt.setRtSeq(String.valueOf(nextRtSeq));
//					rt.setRatUtCd("D7");
//					rt.setPrcCgoTpCd("DR");
//					rt.setCurrCd("USD");
//					rt.setPropFrtRtAmt(strRateDry45);
//					rt.setGriApplTpCd("N");
//					rt.setGriApplAmt("0");
//					rt.setPrcProgStsCd("I");
//					rt.setSrcInfoCd("NW");
//					rt.setN1stCmncAmdtSeq(strAmdtSeq);
//					rt.setCreUsrId(strCreUsrId);
//					rt.setUpdUsrId(strUpdUsrId);
//					
//					rtVoList.add(rt);
//					
//					if (strBucDry45 != null && !"".equals(strBucDry45)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("BUC");
//						scg.setBkgRatUtCd("D7");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strBucDry45);
//						scg.setAdjScgUsdAmt(strBucDry45);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//					if (strIfcDry45 != null && !"".equals(strIfcDry45)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("IFC");
//						scg.setBkgRatUtCd("D7");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strIfcDry45);
//						scg.setAdjScgUsdAmt(strIfcDry45);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//					if (strPscDry45 != null && !"".equals(strPscDry45)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("PSC");
//						scg.setBkgRatUtCd("D7");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strPscDry45);
//						scg.setAdjScgUsdAmt(strPscDry45);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//				}
//
//				if (strRateRf40hc != null && !"".equals(strRateRf40hc)) {
//					nextRtSeq++;
//					
//					PriRpScpRtVO rt = new PriRpScpRtVO();
//					rt.setPropNo(strPropNo);
//					rt.setAmdtSeq(strAmdtSeq);
//					rt.setSvcScpCd(strSvcScpCd);
//					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//					rt.setRoutSeq(String.valueOf(nextRoutSeq));
//					rt.setRtSeq(String.valueOf(nextRtSeq));
//					rt.setRatUtCd("R5");
//					rt.setPrcCgoTpCd("RF");
//					rt.setCurrCd("USD");
//					rt.setPropFrtRtAmt(strRateRf40hc);
//					rt.setGriApplTpCd("N");
//					rt.setGriApplAmt("0");
//					rt.setPrcProgStsCd("I");
//					rt.setSrcInfoCd("NW");
//					rt.setN1stCmncAmdtSeq(strAmdtSeq);
//					rt.setCreUsrId(strCreUsrId);
//					rt.setUpdUsrId(strUpdUsrId);
//					
//					rtVoList.add(rt);
//					
//					if (strBucRf40hc != null && !"".equals(strBucRf40hc)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("BUC");
//						scg.setBkgRatUtCd("R5");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strBucRf40hc);
//						scg.setAdjScgUsdAmt(strBucRf40hc);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//					if (strIfcRf40hc != null && !"".equals(strIfcRf40hc)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("IFC");
//						scg.setBkgRatUtCd("R5");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strIfcRf40hc);
//						scg.setAdjScgUsdAmt(strIfcRf40hc);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//					if (strPscRf40hc != null && !"".equals(strPscRf40hc)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("PSC");
//						scg.setBkgRatUtCd("R5");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strPscRf40hc);
//						scg.setAdjScgUsdAmt(strPscRf40hc);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//				}
//
//				if (strRateRd40hc != null && !"".equals(strRateRd40hc)) {
//					nextRtSeq++;
//					
//					PriRpScpRtVO rt = new PriRpScpRtVO();
//					rt.setPropNo(strPropNo);
//					rt.setAmdtSeq(strAmdtSeq);
//					rt.setSvcScpCd(strSvcScpCd);
//					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//					rt.setRoutSeq(String.valueOf(nextRoutSeq));
//					rt.setRtSeq(String.valueOf(nextRtSeq));
//					rt.setRatUtCd("R5");
//					rt.setPrcCgoTpCd("DR");
//					rt.setCurrCd("USD");
//					rt.setPropFrtRtAmt(strRateRd40hc);
//					rt.setGriApplTpCd("N");
//					rt.setGriApplAmt("0");
//					rt.setPrcProgStsCd("I");
//					rt.setSrcInfoCd("NW");
//					rt.setN1stCmncAmdtSeq(strAmdtSeq);
//					rt.setCreUsrId(strCreUsrId);
//					rt.setUpdUsrId(strUpdUsrId);
//					
//					rtVoList.add(rt);
//					
//					if (strBucRd40hc != null && !"".equals(strBucRd40hc)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("BUC");
//						scg.setBkgRatUtCd("R5");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strBucRd40hc);
//						scg.setAdjScgUsdAmt(strBucRd40hc);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//					if (strIfcRd40hc != null && !"".equals(strIfcRd40hc)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("IFC");
//						scg.setBkgRatUtCd("R5");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strIfcRd40hc);
//						scg.setAdjScgUsdAmt(strIfcRd40hc);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//					if (strPscRd40hc != null && !"".equals(strPscRd40hc)) {
//						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
//						scg.setPropNo(strPropNo);
//						scg.setAmdtSeq(strAmdtSeq);
//						scg.setSvcScpCd(strSvcScpCd);
//						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
//						scg.setRoutSeq(String.valueOf(nextRoutSeq));
//						scg.setRtSeq(String.valueOf(nextRtSeq));
//						scg.setChgCd("PSC");
//						scg.setBkgRatUtCd("R5");
//						scg.setCurrCd("USD");
//						scg.setTrfScgAmt("0");
//						scg.setAdjScgAmt(strPscRd40hc);
//						scg.setAdjScgUsdAmt(strPscRd40hc);
//						scg.setAdjFlg("N");
//						scg.setCreUsrId(strCreUsrId);
//						scg.setUpdUsrId(strUpdUsrId);
//						
//						scgVoList.add(scg);
//					}
//				}
//			}
//			
//			if (cmdtHdrVoList.size() > 0) {
//				dbDao.addRateCommodityHeader(cmdtHdrVoList);
//			}
//			if (cmdtVoList.size() > 0) {
//				dbDao.addRateCommodity(cmdtVoList);
//			}
//			if (custVoList.size() > 0) {
//				dbDao.addRateActualCustomer(custVoList);
//			}
//			
//			if (routVoList.size() > 0) {
//				dbDao.addRateCommodityRoute(routVoList);
//			}
//			if (pntVoList.size() > 0) {
//				dbDao.addRateRoutePoint(pntVoList);
//			}
//			if (viaVoList.size() > 0) {
//				dbDao.addRateRouteVia(viaVoList);
//			}
//			
//			if (rtVoList.size() > 0) {
//				dbDao.addRate(rtVoList);
//			}
//			
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
//		}
//	}
	

	
	/**
	 * Changing Main duration's accepted data to Init at once when canceling Request<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpMnVO> updateVoList = new ArrayList<PriRpScpMnVO>();
			
			for ( int i = 0; priRpScpMnVOs != null && i < priRpScpMnVOs.length; i++ ) {
				priRpScpMnVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(priRpScpMnVOs[i]);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalRtActCustReqCnl(updateVoList);
				dbDao.modifyProposalRtCmdtReqCnl(updateVoList);
				dbDao.modifyProposalRtCmdtRnoteReqCnl(updateVoList);
				dbDao.modifyProposalRtCnoteReqCnl(updateVoList);
				dbDao.modifyProposalRtReqCnl(updateVoList);
				dbDao.modifyProposalRtRoutePntReqCnl(updateVoList);
				dbDao.modifyProposalRtRouteViaReqCnl(updateVoList);
			}
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}			
	
	/**
	 * Requesting Amend<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException {
		try {

			List<PriRpMnVO> insertVoList = new ArrayList<PriRpMnVO>();

			priRpMnVO.setCreUsrId(account.getUsr_id());
			priRpMnVO.setUpdUsrId(account.getUsr_id());
			insertVoList.add(priRpMnVO);
			
			dbDao.addRateCommodityHeaderAmend(insertVoList);			
			dbDao.addRateActualCustomerAmend(insertVoList);
			dbDao.addRateCnoteAmend(insertVoList);			
			dbDao.addRateCommodityAmend(insertVoList);			
			dbDao.addRateCommodityRouteAmend(insertVoList);
			dbDao.addRateAmend(insertVoList);
			dbDao.addRateCommodityRnoteAmend(insertVoList);
			dbDao.addRateRoutePointAmend(insertVoList);
			dbDao.addRateRouteViaAmend(insertVoList);
			dbDao.addRateCargoSpecAmend(insertVoList);	

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	

	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 
	 * @param RsltPriSurchargeAdjustListVO schPriSurchargeAdjustListVO
	 * @return List<RsltPriSurchargeAdjustListVO>
	 * @exception EventException
	 */
//	public List<RsltPriSurchargeAdjustListVO> searchSurchargeAdjustList(
//			RsltPriSurchargeAdjustListVO schPriSurchargeAdjustListVO) throws EventException {
//		try {
//			return dbDao.searchSurchargeAdjustList(schPriSurchargeAdjustListVO);
//		} catch (DAOException ex) {
//            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
//        } catch (Exception ex) {
//            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
//		}
//	}

	/**
	 * Retrieving Rate Cargo Specification<br>
	 *  
	 * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
	 * @return List<RsltPriRpScpRtCgoSpecVO>
	 * @exception EventException
	 */
	public List<RsltPriRpScpRtCgoSpecVO> searchRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO) throws EventException {
		try {
			return dbDao.searchRateCargoSepcification(priRpScpRtCgoSpecVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Modifying Rate Cargo Specification<br>
	 * 
	 * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO, SignOnUserAccount account) throws EventException {
		try {
			if(Integer.parseInt(dbDao.checkRateCargoSepcification(priRpScpRtCgoSpecVO).getEtc2()) > 0) {
				priRpScpRtCgoSpecVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyRateCargoSepcification(priRpScpRtCgoSpecVO);
			} else {
				priRpScpRtCgoSpecVO.setCreUsrId(account.getUsr_id());
				priRpScpRtCgoSpecVO.setUpdUsrId(account.getUsr_id());
				dbDao.addRateCargoSepcification(priRpScpRtCgoSpecVO);
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
	 * Retrieving Rate Note Conversion<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @return List<RsltNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionList(PriRfaNoteConvVO priRfaNoteConvVO) throws EventException {
		try {
			return dbDao.searchNoteConversionList(priRfaNoteConvVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving copied Rate Note Conversion<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<RsltNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionListCopy(PriRfaNoteConvVO priRfaNoteConvVO, SignOnUserAccount account) throws EventException {
		try {

			priRfaNoteConvVO.setCreUsrId(account.getUsr_id());
			
			return dbDao.searchNoteConversionListCopy(priRfaNoteConvVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Copying Rate Note Conversion<br>
	 * 
	 * @param PriRfaNoteConvListVO[] priRfaNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriRfaNoteConvListVO[] priRfaNoteConvListVOs, SignOnUserAccount account) throws EventException{
		try {			
			List<PriRfaNoteConvListVO> insertVoList = new ArrayList<PriRfaNoteConvListVO>();
			
			for ( int i=0; i<priRfaNoteConvListVOs .length; i++ ) {
				if ( priRfaNoteConvListVOs[i].getIbflag().equals("I")){
					priRfaNoteConvListVOs[i].setCreUsrId(account.getUsr_id());
					priRfaNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRfaNoteConvListVOs[i]);
				}
			}			
			if ( insertVoList.size() > 0 ) {
				priRfaNoteConvListVOs[0].setCreUsrId(account.getUsr_id());
				dbDao.removeNoteConversionCopy(priRfaNoteConvListVOs[0]);				
				dbDao.addNoteConversionCopy(insertVoList);
			}
			
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

    /**
     * Copying RFA Proposal Rate information<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeRate(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException {
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_RP_SCP_RT_CMDT_HDR COPY
            dbDao.addCopyProposalScopeRtCmdtHdr(vo);
            // PRI_RP_SCP_RT_ACT_CUST COPY
            dbDao.addCopyProposalScopeRtActCust(vo);
            // PRI_RP_SCP_RT_CMDT COPY
            dbDao.addCopyProposalScopeRtCmdt(vo);
            // PRI_RP_SCP_RT_CNOTE COPY
            dbDao.addCopyProposalScopeRtCnote(vo);
            // PRI_RP_SCP_RT_CMDT_ROUT COPY
            dbDao.addCopyProposalScopeRtCmdtRout(vo);
            // PRI_RP_SCP_RT_ROUT_PNT COPY
            dbDao.addCopyProposalScopeRtRoutPnt(vo);
            // PRI_RP_SCP_RT_ROUT_VIA COPY
            dbDao.addCopyProposalScopeRtRoutVia(vo);
            // PRI_RP_SCP_RT COPY
            dbDao.addCopyProposalScopeRt(vo);
            // PRI_RP_SCP_RT_CMDT_RNOTE COPY
            dbDao.addCopyProposalScopeRtCmdtRnote(vo);

            // PRI_RP_SCP_RT_CMDT_RNOTE Display Seq Update
            PriRpScpRtCmdtRoutVO routVO = new PriRpScpRtCmdtRoutVO();
            routVO.setPropNo(vo.getNewPropNo());
            routVO.setAmdtSeq("0");
            routVO.setSvcScpCd(vo.getSvcScpCd());

            dbDao.modifyRouteNoteDispSeq(routVO, "0");
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Copying Guideline Rate to Proposal <br>
     * 
     * @param RpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineRate(RpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException {
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            // PRI_RP_SCP_RT_CMDT_HDR COPY
            dbDao.addCopyScopeGuidelineRateCmdtHdr(vo);
            // PRI_RP_SCP_RT_CMDT COPY
            dbDao.addCopyScopeGuidelineRateCmdt(vo);
            // PRI_RP_SCP_RT_CMDT_ROUT COPY
            dbDao.addCopyScopeGuidelineRateCmdtRout(vo);
            // PRI_RP_SCP_RT_ROUT_PNT COPY
            dbDao.addCopyScopeGuidelineRateRoutPnt(vo);

            // PRI_RP_SCP_RT_ROUT_VIA COPY
            dbDao.addCopyScopeGuidelineRateRoutVia(vo);
            // PRI_RP_SCP_RT COPY
            dbDao.addCopyScopeGuidelineRate(vo);

            // PRI_RP_SCP_RT_CMDT_RNOTE Display Seq Update
            PriRpScpRtCmdtRoutVO routVO = new PriRpScpRtCmdtRoutVO();
            routVO.setPropNo(vo.getPropNo());
            routVO.setAmdtSeq(vo.getAmdtSeq());
            routVO.setSvcScpCd(vo.getSvcScpCd());

            dbDao.modifyRouteNoteDispSeq(routVO, "0");
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
	/**
	 *Retrieving when surcharge is created on RFA Proposal - Rate Tab's Surcharge View All Popup.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltPriSurchargeLastAccessDateVO>
	 * @exception EventException
	 */
//	public List<RsltPriSurchargeLastAccessDateVO> searchSurchargeLastAccessDateList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
//		try {
//			return dbDao.searchSurchargeLastAccessDateList(priRpScpRtCmdtHdrVO);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
//        } catch (Exception ex) {
//            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
//		}
//	}    
//	
	
	/**
	 *  Deleting Surcharge information<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @exception EventException
	 */
//	public void manageProposalScopeSurchargeRemove(RfaPropMnVO rfaPropMnVO) throws EventException {
//		try {
//			PriRpScpMnVO[] scpVo = rfaPropMnVO.getPriRpScpMnVOs();		
//
//			for ( int i = 0; scpVo != null && i < scpVo.length; i++ ) {
//				if ( scpVo[i].getIbflag().equals("D")){
//	//				dbDao.removeSurchargeAdjustInitCancel(scpVo[i]);
//				}
//			}
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
//		}
//	}	
	
	/**
	 * Retrieving expire data information of main about previous amdt_seq.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBeforeExpireDate(PriRpScpMnVO priRpScpMnVO) throws EventException {
		try {
			return dbDao.searchBeforeExpireDate(priRpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/****************************************************************************************/
	/* ESM_PRI_2060  BackEndJob Start       */
	/****************************************************************************************/
	
	/**
	 *  call backEndJob to Check RFA Contract with Excel and get BackEndJob's Key<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
    public String checkRateExcelHorizontalBackEndJob(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException {
    	RFARateProposalCheckRateExcelHorizontalBackEndJob backEndJob = new RFARateProposalCheckRateExcelHorizontalBackEndJob();
		backEndJob.setPriRpScpRtCmdtHdrVO(priRpScpRtCmdtHdrVO);
		backEndJob.setRsltRtListHorizontalExcelVO(rsltRtListHorizontalExcelVOS);
		backEndJob.setSignOnUserAccount(account);
		backEndJob.setTermOrg(termOrgCodeList);
		backEndJob.setTermDest(termDestCodeList);
		backEndJob.setTrspMod(trspModCodeList);
		
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_PRI_2060 - CHECK EXCEL");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
	 * Check RFA Contract with Excel <br>
	 * Only using in RFARateProposalCheckRateExcelHorizontalBackEndJob <br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */	
	public List<RsltRtListHorizontalExcelVO> checkRateExcelHorizontal(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException {
		List<RsltRtListHorizontalExcelVO> 	returnVO 	= new ArrayList<RsltRtListHorizontalExcelVO>();
		
		try {
			int rowcnt = rsltRtListHorizontalExcelVOS.length;
			for(int i = 0; i < rowcnt; i++){
				returnVO.add(rsltRtListHorizontalExcelVOS[i]);
				String strType = rsltRtListHorizontalExcelVOS[i].getType();
				if(strType.equals("C") || strType.equals("U")){
					List<RsltRtListHorizontalExcelVO> resultVO = dbDao.chkPriRateExl(priRpScpRtCmdtHdrVO, rsltRtListHorizontalExcelVOS[i]);
					if(resultVO != null && resultVO.size() > 0){
						String strCmdt = resultVO.get(0).getChkPrcCmdtDefCd();
						String strCust = resultVO.get(0).getChkCustSeq();
						String strOrgCd = resultVO.get(0).getChkOrgRoutPntLocDefCd();
						String strOrgTerm = resultVO.get(0).getChkOrgRcvDeTermNm();
						String strOrgTrsp = resultVO.get(0).getChkOrgPrcTrspModNm();
						String strDestCd = resultVO.get(0).getChkDestRoutPntLocDefCd();
						String strDestTerm = resultVO.get(0).getChkDestRcvDeTermNm();
						String strDestTrsp = resultVO.get(0).getChkDestPrcTrspModNm();
						String strOrgVia = resultVO.get(0).getChkOrgRoutViaPortDefCd();
						String strDestVia = resultVO.get(0).getChkDestRoutViaPortDefCd();
						String strCmdtDup = resultVO.get(0).getChkPrcCmdtDefDup();
						String strOrgDestDup = resultVO.get(0).getChkOrgDestDup();
						String strCmdtHdrSeq = resultVO.get(0).getChkCmdtHdrSeq();
						String strRoutSeq = resultVO.get(0).getChkRoutSeq();
						String strOrgSemi = resultVO.get(0).getChkOrgSemi();
						String strDestSemi = resultVO.get(0).getChkDestSemi();
						
						returnVO.get(i).setChkPrcCmdtDefCd(strCmdt);
						returnVO.get(i).setChkCustSeq(strCust);
						returnVO.get(i).setChkOrgRoutPntLocDefCd(strOrgCd);
						returnVO.get(i).setChkOrgRcvDeTermNm(strOrgTerm);
						returnVO.get(i).setChkOrgPrcTrspModNm(strOrgTrsp);
						returnVO.get(i).setChkDestRoutPntLocDefCd(strDestCd);
						returnVO.get(i).setChkDestRcvDeTermNm(strDestTerm);
						returnVO.get(i).setChkDestPrcTrspModNm(strDestTrsp);
						returnVO.get(i).setChkOrgRoutViaPortDefCd(strOrgVia);
						returnVO.get(i).setChkDestRoutViaPortDefCd(strDestVia);
						returnVO.get(i).setChkPrcCmdtDefDup(strCmdtDup);
						returnVO.get(i).setChkOrgDestDup(strOrgDestDup);
						returnVO.get(i).setChkCmdtHdrSeq(strCmdtHdrSeq);
						returnVO.get(i).setChkRoutSeq(strRoutSeq);
						returnVO.get(i).setChkOrgSemi(strOrgSemi);
						returnVO.get(i).setChkDestSemi(strDestSemi);
					}
				} 

			}
			
			return returnVO;
			
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 *  call backEndJob to Save RFA Contract with Excel and get BackEndJob's Key<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
    public String uploadRateExcelHorizontalBackEndJob(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException {
		RFARateProposalUploadRateExcelHorizontalBackEndJob backEndJob = new RFARateProposalUploadRateExcelHorizontalBackEndJob();
		backEndJob.setPriRpScpRtCmdtHdrVO(priRpScpRtCmdtHdrVO);
		backEndJob.setRsltRtListHorizontalExcelVO(rsltRtListHorizontalExcelVOS);
		backEndJob.setSignOnUserAccount(account);
		backEndJob.setTermOrg(termOrgCodeList);
		backEndJob.setTermDest(termDestCodeList);
		backEndJob.setTrspMod(trspModCodeList);
		
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_PRI_2060 - EXCEL UPLOAD");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
	 * Save RFA Contract with Excel <br>
	 * Only using in RFARateProposalUploadRateExcelHorizontalBackEndJob <br>
	 * 
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void uploadRateExcelHorizontal(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException {
		try {
			 
	         String strCreUsrId = account.getUsr_id();
	         String strUpdUsrId = account.getUsr_id();

			 List<PriRpScpRtCmdtRoutVO> d_H_routVoList 		= null;
			 List<PriRpScpRtCmdtHdrVO> 	d_cmdtHdrVoList 	= null;	
			 List<PriRpScpRtCmdtRoutVO> d_routVoList 		= null;
		     
		     //----------------------------------------
		     //(1) INSERT
		     //----------------------------------------
		     
		     List<PriRpScpRtCmdtHdrVO> 	cmdtHdrVoList 	= null;
			 List<PriRpScpRtCmdtVO> 	cmdtVoList 		= null;
			 List<PriRpScpRtActCustVO> 	custVoList 		= null;
			 List<PriRpScpRtCmdtRoutVO> routVoList 		= null;
			 List<PriRpScpRtRoutPntVO> 	pntVoList 		= null;
			 List<PriRpScpRtRoutViaVO> 	viaVoList 		= null;
			 List<PriRpScpRtVO> 		rtVoList 		= null;

			 for (int i = 0; i < rsltRtListHorizontalExcelVOS.length; i++) {
				 
				 int delcnt    = 0;
			     int updatecnt = 0;
			     int insertcnt = 0;
			     int deletecnt = 0;
			     
				 d_H_routVoList 	= new ArrayList<PriRpScpRtCmdtRoutVO>();
				 d_cmdtHdrVoList 	= new ArrayList<PriRpScpRtCmdtHdrVO>();	
				 d_routVoList 		= new ArrayList<PriRpScpRtCmdtRoutVO>();
				 
				 cmdtHdrVoList 	= new ArrayList<PriRpScpRtCmdtHdrVO>();
				 cmdtVoList 	= new ArrayList<PriRpScpRtCmdtVO>();
				 custVoList 	= new ArrayList<PriRpScpRtActCustVO>();
				 routVoList 	= new ArrayList<PriRpScpRtCmdtRoutVO>();
				 pntVoList 		= new ArrayList<PriRpScpRtRoutPntVO>();
				 viaVoList 		= new ArrayList<PriRpScpRtRoutViaVO>();
				 rtVoList 		= new ArrayList<PriRpScpRtVO>();
				 
	             RsltRtListHorizontalExcelVO row = rsltRtListHorizontalExcelVOS[i];
	             String rowType = row.getType();
	             
	             if(rowType.equals("U")){

	            	 delcnt++;
	            	 
	            	 //PRI_RP_SCP_RT, /PRI_RP_SCP_RT_ROUT_VIA, PRI_RP_SCP_RT_ROUT_PNT
	            	 if(!exsitsCmdtHdrRout(d_routVoList, row)) {
	            		 PriRpScpRtCmdtRoutVO rout = makeRoutForDel(row, priRpScpRtCmdtHdrVO);
		            	 d_routVoList.add(rout);
	            	 }
	            	 
	            	 //PRI_RP_SCP_RT_ACT_CUST, PRI_RP_SCP_RT_CMDT
	            	 if(!existsCmdtHdr(d_cmdtHdrVoList, row)) {
	            		 PriRpScpRtCmdtHdrVO cmdthdr = makeCmdtHdrForDel(row, priRpScpRtCmdtHdrVO);
		            	 d_cmdtHdrVoList.add(cmdthdr);
	            	 }
	            	 
	             } else if(rowType.equals("D")){
	            	 
	            	 delcnt++;
	            	 
	            	 //PRI_RP_SCP_RT, /PRI_RP_SCP_RT_ROUT_VIA, PRI_RP_SCP_RT_ROUT_PNT
	            	 if(!exsitsCmdtHdrRout(d_routVoList, row)) {
	            		 PriRpScpRtCmdtRoutVO rout = makeRoutForDel(row, priRpScpRtCmdtHdrVO);
		            	 d_routVoList.add(rout);
		            	 
		            	 if(priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0")){
		            		 d_H_routVoList.add(rout);
		            	 }
	            	 }
	            	 
	            	 //PRI_RP_SCP_RT_ACT_CUST, PRI_RP_SCP_RT_CMDT
	            	 if(!existsCmdtHdr(d_cmdtHdrVoList, row)) {
	            		 PriRpScpRtCmdtHdrVO cmdthdr = makeCmdtHdrForDel(row, priRpScpRtCmdtHdrVO);
		            	 d_cmdtHdrVoList.add(cmdthdr);
	            	 }

	             }

	             if(rowType.equals("U")){
	            	 //-----------------------------
	            	 // UPDATE LOGIC
	            	 //-----------------------------
	            	 updatecnt++;
	            	 
	            	 makeLocForCreate(rowType, pntVoList, row, priRpScpRtCmdtHdrVO, "O", termOrgCodeList, termDestCodeList, trspModCodeList, -1, -1, strCreUsrId, strUpdUsrId);
	            	 
	            	 makeLocForCreate(rowType, pntVoList, row, priRpScpRtCmdtHdrVO, "D", termOrgCodeList, termDestCodeList, trspModCodeList, -1, -1, strCreUsrId, strUpdUsrId);
	            	 
	            	 makeViaLocForCreate(rowType, viaVoList, row, priRpScpRtCmdtHdrVO, "O", -1, -1, strCreUsrId, strUpdUsrId);
	            	 
	            	 makeViaLocForCreate(rowType, viaVoList, row, priRpScpRtCmdtHdrVO, "D", -1, -1, strCreUsrId, strUpdUsrId);
	            	 
	            	 makeRtForCreate(rowType, rtVoList, row, priRpScpRtCmdtHdrVO, -1, -1, strCreUsrId, strUpdUsrId);

	            	 
	             } else if(rowType.equals("D")){
	            	 
	            	 deletecnt++;
	            	 
	            	 makeLocForCreate(rowType, pntVoList, row, priRpScpRtCmdtHdrVO, "O", termOrgCodeList, termDestCodeList, trspModCodeList, -1, -1, strCreUsrId, strUpdUsrId);
	            	 
	            	 makeLocForCreate(rowType, pntVoList, row, priRpScpRtCmdtHdrVO, "D", termOrgCodeList, termDestCodeList, trspModCodeList, -1, -1, strCreUsrId, strUpdUsrId);
	            	 
	            	 makeViaLocForCreate(rowType, viaVoList, row, priRpScpRtCmdtHdrVO, "O", -1, -1, strCreUsrId, strUpdUsrId);
	            	 
	            	 makeViaLocForCreate(rowType, viaVoList, row, priRpScpRtCmdtHdrVO, "D", -1, -1, strCreUsrId, strUpdUsrId);
	            	 
	            	 makeRtForCreate(rowType, rtVoList, row, priRpScpRtCmdtHdrVO, -1, -1, strCreUsrId, strUpdUsrId);
	            	 
	             } else if(rowType.equals("C")){
	            	 
	            	 insertcnt++;

	            	 int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priRpScpRtCmdtHdrVO);
					 int nextRoutSeq    = 0;
	            	 
					 boolean isCmdtHdrSeq = false;
					 
					 //-----------------------
	            	 //2016.02.15
	            	 //(1) In Excel Info, when there is the same commodity code with type C, <<share the cmdtHdrSeq>>
	            	 String curPrcCmdtDefCd = row.getPrcCmdtDefCd();
	            	 String[] preCmdtInfo = findPrcCmdtDefCd(rsltRtListHorizontalExcelVOS, curPrcCmdtDefCd, i);
					 
	            	 if((row.getCmdtHdrSeq() == null || row.getCmdtHdrSeq().equals("")) && StringUtils.isEmpty(preCmdtInfo[0])){
	            		 nextCmdtHdrSeq++;
	            		 makeCmdtHdrForCreate(cmdtHdrVoList, row, priRpScpRtCmdtHdrVO, nextCmdtHdrSeq, strCreUsrId, strUpdUsrId);
	            	 } else {
	            		 if(!StringUtils.isEmpty(preCmdtInfo[1])){
	            			 nextCmdtHdrSeq = Integer.valueOf( preCmdtInfo[1] );
	            		 } else {
	            			 nextCmdtHdrSeq = Integer.valueOf(row.getCmdtHdrSeq()); 
	            		 }
	            		 isCmdtHdrSeq = true;
	            	 }
	            	 //------------------------
	            	 
	            	 
	            	 if(!isCmdtHdrSeq){
	            		 makeCmdtForCreate(rowType, cmdtVoList, row, priRpScpRtCmdtHdrVO, nextCmdtHdrSeq, strCreUsrId, strUpdUsrId);
	            		 makeActCustForCreate(rowType, custVoList, row, priRpScpRtCmdtHdrVO, nextCmdtHdrSeq, strCreUsrId, strUpdUsrId);
	            	 } 

	            	 if(row.getRoutSeq() == null || row.getRoutSeq().equals("")){
	            		 priRpScpRtCmdtHdrVO.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
	            		 nextRoutSeq = dbDao.searchNextRoutSeq(priRpScpRtCmdtHdrVO);
	            		 nextRoutSeq++;
	            		 makeCmdtRoutForCreate(routVoList, row, priRpScpRtCmdtHdrVO, nextCmdtHdrSeq, nextRoutSeq, strCreUsrId, strUpdUsrId);
	            	 } else {
	            		 nextRoutSeq = Integer.valueOf(row.getRoutSeq()); 
	            	 }
	            	 
	            	 makeLocForCreate(rowType, pntVoList, row, priRpScpRtCmdtHdrVO, "O", termOrgCodeList, termDestCodeList, trspModCodeList, nextCmdtHdrSeq, nextRoutSeq, strCreUsrId, strUpdUsrId);
	            	 
	            	 makeLocForCreate(rowType, pntVoList, row, priRpScpRtCmdtHdrVO, "D", termOrgCodeList, termDestCodeList, trspModCodeList, nextCmdtHdrSeq, nextRoutSeq, strCreUsrId, strUpdUsrId);
	            	 
	            	 makeViaLocForCreate(rowType, viaVoList, row, priRpScpRtCmdtHdrVO, "O", nextCmdtHdrSeq, nextRoutSeq, strCreUsrId, strUpdUsrId);
	            	 
	            	 makeViaLocForCreate(rowType, viaVoList, row, priRpScpRtCmdtHdrVO, "D", nextCmdtHdrSeq, nextRoutSeq, strCreUsrId, strUpdUsrId);
	            	 
	            	 makeRtForCreate(rowType, rtVoList, row, priRpScpRtCmdtHdrVO, nextCmdtHdrSeq, nextRoutSeq, strCreUsrId, strUpdUsrId);
	            	 
	            	 //------------------------
	            	 //2016.02.15
	            	 //(1) In Excel Info, when there is the same commodity code with type C, <<share the cmdtHdrSeq>>
	            	 row.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
	            	 row.setRoutSeq(String.valueOf(nextRoutSeq));
	            	 //------------------------
	             }
	             
	             if((rowType.equals("U") || rowType.equals("D")) && delcnt > 0){

					 if(d_routVoList != null && d_routVoList.size() > 0){
						 String cgoTpCd = rsltRtListHorizontalExcelVOS[i].getPrcCgoTpCd();
						 dbDao.removeRateCascadeRt(d_routVoList.get(0), cgoTpCd);
						 dbDao.removeRateCascadeRoutVia(d_routVoList);
						 dbDao.removeRateCascadeRoutPnt(d_routVoList);
					 }
					 if(d_H_routVoList != null && d_H_routVoList.size() > 0){
						 dbDao.removeRateCascadeCmdtRout(d_H_routVoList);
					 }
					 
					 if(rowType.equals("D")){
						 d_routVoList.get(0).setUpdUsrId(account.getUpd_usr_id());
						 dbDao.modifyProposalScopeCmdtRouteRnote(d_routVoList.get(0));
					 }

				 }
	             
	             if(updatecnt > 0 || deletecnt > 0 || insertcnt > 0){

					 if (cmdtHdrVoList.size() > 0) {
						 dbDao.addRateCommodityHeaderForExcel(cmdtHdrVoList.get(0));
		             }
			         if (cmdtVoList.size() > 0) {
			             List<PriRpScpRtCmdtVO> bVoList = getBlankCmdtSeqCmdt(cmdtVoList);
			             for(int x = 0; x < cmdtVoList.size() ; x++){
			            	 String val = cmdtVoList.get(x).getCmdtSeq();
			            	 if(!StringUtils.isEmpty(val)){
			            		 dbDao.addRateCommodityForExcel(cmdtVoList.get(x));
			            	 }
						 }
			             if(bVoList.size() > 0){
			            	 for(int x = 0; x < bVoList.size() ; x++){
			            		 dbDao.addRateCommodityForExcel(bVoList.get(x));
				             } 
			             }
			         }
			         if (custVoList.size() > 0) {
			             for(int x = 0; x < custVoList.size() ; x++){
			            	 String val = custVoList.get(x).getCustSeq();
			            	 if(!StringUtils.isEmpty(val)){
			            		 dbDao.addRateActualCustomerForExcel(custVoList.get(x));
			            	 }
						 }
			         }
			         if (routVoList.size() > 0) {
			        	 dbDao.addRateCommodityRoute(routVoList);
		             }
			         if (pntVoList.size() > 0) {
			             List<PriRpScpRtRoutPntVO> bVoList = getBlankRoutPntSeqLocation(pntVoList);
			             for(int x = 0; x < pntVoList.size() ; x++){
			            	 String val = pntVoList.get(x).getRoutPntSeq();
			            	 if(!StringUtils.isEmpty(val)){
			            		 dbDao.addRateRoutePointForExcel(pntVoList.get(x));
			            	 }
						 }
			             if(bVoList.size() > 0){
			            	 for(int x = 0; x < bVoList.size() ; x++){
			            		 dbDao.addRateRoutePointForExcel(bVoList.get(x));
				             } 
			             }
			         }
			         if (viaVoList.size() > 0) {
			             List<PriRpScpRtRoutViaVO> bVoList = getBlankRoutViaSeqLocationVia(viaVoList);
			             for(int x = 0; x < viaVoList.size() ; x++){
			            	 String val = viaVoList.get(x).getRoutViaSeq();
			            	 if(!StringUtils.isEmpty(val)){
			            		 dbDao.addRateRouteViaForExcel(viaVoList.get(x));
			            	 }
						 }
			             if(bVoList.size() > 0){
			            	 for(int x = 0; x < bVoList.size() ; x++){
			            		 dbDao.addRateRouteViaForExcel(bVoList.get(x));
				             } 
			             }
			             
			         }

			         if (rtVoList.size() > 0) {
			        	 List<PriRpScpRtVO> bVoList = getBlankRtSeqRate(rtVoList);
			             for(int x = 0; x < rtVoList.size() ; x++){
			            	 String val = rtVoList.get(x).getRtSeq();
			            	 if(!StringUtils.isEmpty(val)){
			            		 dbDao.addRateForExcel(rtVoList.get(x));
			            	 }
						 }
			             if(bVoList.size() > 0){
			            	 for(int x = 0; x < bVoList.size() ; x++){
			            		 dbDao.addRateForExcel(bVoList.get(x));
				             } 
			             }
			         }
				 }
			 } //end for 
			 
			 //throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), new Exception());
       
       } catch (DAOException ex) {
           throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
       } catch (Exception ex) {
           throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
       }
	}
	
	/**
	 * before RowIdx, When there is the same commodity, share cmdt_hdr_seq
	 * 
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param String prcCmdtDefCd
	 * @param int RowIdx
	 * @return String[] ([0]:PrcCmdtDefCd, [1]:CmdtHdrSeq)
	 */
	private String[] findPrcCmdtDefCd(RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, String prcCmdtDefCd, int RowIdx){
		String[] result = new String[2];
		if(rsltRtListHorizontalExcelVOS == null || rsltRtListHorizontalExcelVOS.length == 0 || RowIdx == 0) return result;
		for(int i = 0; i < RowIdx; i++){
			String tmpPrcCmdtDefCd = rsltRtListHorizontalExcelVOS[i].getPrcCmdtDefCd();
			String tmpCmdtHdrSeq = rsltRtListHorizontalExcelVOS[i].getCmdtHdrSeq();
			if(prcCmdtDefCd.equals(tmpPrcCmdtDefCd)){
				result[0] = tmpPrcCmdtDefCd;
				result[1] = tmpCmdtHdrSeq;
				break;
			}
		}
		return result;
	}
	
	/** 
	 * return Object that cmdt_seq is null <br>
	 * @param List<PriRpScpRtCmdtVO> vo
	 * @return List<PriRpScpRtCmdtVO>	
	 */
	private List<PriRpScpRtCmdtVO> getBlankCmdtSeqCmdt(List<PriRpScpRtCmdtVO> vo){
		List<PriRpScpRtCmdtVO> rtnVo = new ArrayList<PriRpScpRtCmdtVO>();
		
		if(vo != null && vo.size() > 0){
			for(int i = 0; i < vo.size(); i++){
				String val = vo.get(i).getCmdtSeq();
				if(StringUtils.isEmpty(val)){
					rtnVo.add(vo.get(i));
				}
			}
		}
		
		return rtnVo;
	}
	
	
	/** 
	 * return Object that rout_pnt_seq is null <br>
	 * @param List<PriRpScpRtRoutPntVO> vo
	 * @return List<PriRpScpRtRoutPntVO>	
	 */
	private List<PriRpScpRtRoutPntVO> getBlankRoutPntSeqLocation(List<PriRpScpRtRoutPntVO> vo){
		List<PriRpScpRtRoutPntVO> rtnVo = new ArrayList<PriRpScpRtRoutPntVO>();
		
		if(vo != null && vo.size() > 0){
			for(int i = 0; i < vo.size(); i++){
				String val = vo.get(i).getRoutPntSeq();
				if(StringUtils.isEmpty(val)){
					rtnVo.add(vo.get(i));
				}
			}
		}
		
		return rtnVo;
	}

	/** 
	 * return Object that rout_via_seq is null <br>
	 * @param List<PriRpScpRtRoutViaVO> vo
	 * @return List<PriRpScpRtRoutViaVO>	
	 */
	private List<PriRpScpRtRoutViaVO> getBlankRoutViaSeqLocationVia(List<PriRpScpRtRoutViaVO> vo){
		List<PriRpScpRtRoutViaVO> rtnVo = new ArrayList<PriRpScpRtRoutViaVO>();
		
		if(vo != null && vo.size() > 0){
			for(int i = 0; i < vo.size(); i++){
				String val = vo.get(i).getRoutViaSeq();
				if(StringUtils.isEmpty(val)){
					rtnVo.add(vo.get(i));
				}
			}
		}
		return rtnVo;
	}
	
	/** 
	 * return Object that rt_seq is null <br>
	 * @param List<PriRpScpRtVO> vo
	 * @return List<PriRpScpRtVO>	
	 */
	private List<PriRpScpRtVO> getBlankRtSeqRate(List<PriRpScpRtVO> vo){
		List<PriRpScpRtVO> rtnVo = new ArrayList<PriRpScpRtVO>();
		
		if(vo != null && vo.size() > 0){
			for(int i = 0; i < vo.size(); i++){
				String val = vo.get(i).getRtSeq();
				if(StringUtils.isEmpty(val)){
					rtnVo.add(vo.get(i));
				}
			}
		}
		
		return rtnVo;
	}
		
	/** 
	 * check to exists Commdity header <br>
	 * @param List<PriRpScpRtCmdtHdrVO> d_cmdtHdrVoList
	 * @param RsltRtListHorizontalExcelVO row
	 * @return String	
	 */
	 private boolean existsCmdtHdr(List<PriRpScpRtCmdtHdrVO> d_cmdtHdrVoList, RsltRtListHorizontalExcelVO row){
		 boolean result = false;
		 
		 String strOrg = row.getCmdtHdrSeq();
		 
		 if(d_cmdtHdrVoList != null && d_cmdtHdrVoList.size() > 0){
			 for(int i = 0 ; i < d_cmdtHdrVoList.size(); i++){
				 String strTarget = d_cmdtHdrVoList.get(i).getCmdtHdrSeq();
				 if(strOrg.equals(strTarget)){
					 result = true;
					 break;
				 }
			 }
		 }
		 
		 return result;
	 }
	 /**
	  * get the true/false result <br>
	  * whether the parameter value(CmdtHdrSeq+RoutSeq) exists in List<PriRpScpRtCmdtRoutVO> <br>
	  * 
	  * @param List<PriRpScpRtCmdtRoutVO> d_dcallVoList
	  * @param RsltRtListHorizontalExcelVO row
	  * @return boolean
	  */
	 private boolean exsitsCmdtHdrRout(List<PriRpScpRtCmdtRoutVO> d_routVoList, RsltRtListHorizontalExcelVO row){
		 boolean result = false;
		 
		 String strOrg = row.getCmdtHdrSeq()+row.getRoutSeq();
		 
		 if(d_routVoList != null && d_routVoList.size() > 0){
			 for(int i = 0 ; i < d_routVoList.size(); i++){
				 String strTarget = d_routVoList.get(i).getCmdtHdrSeq()+d_routVoList.get(i).getRoutSeq();
				 if(strOrg.equals(strTarget)){
					 result = true;
					 break;
				 }
			 }
		 }
		 
		 return result;
	 }

	 /**
	  * get the true/false result whether the parameter value exists in List<PriRpScpRtRoutPntVO> <br>
	  * 
	  * @param List<PriRpScpRtRoutPntVO> pntVoList
	  * @param String strLocTermTrspMod
	  * @return boolean
	  */
	 private boolean exsitsCmdtRoutLocTermTrspMod(List<PriRpScpRtRoutPntVO> pntVoList, String strLocTermTrspMod){
		 boolean result = false;
		 
		 if(pntVoList != null && pntVoList.size() > 0){
			 for(int i = 0 ; i < pntVoList.size(); i++){
				 String strTarget = pntVoList.get(i).getRoutPntLocDefCd()+pntVoList.get(i).getRcvDeTermCd()+pntVoList.get(i).getPrcTrspModCd();
				 if(strLocTermTrspMod.equals(strTarget)){
					 result = true;
					 break;
				 }
			 }
		 }
		 
		 return result;
	 }
	 /** 
	  * check to exists Commdity <br>
	  * isSame(true) -> if the same data exist, return true<br>
	  * isSame(false) -> if the no same data exist, return true<br>
	  * @param List<PriRpScpRtCmdtVO> vo
	  * @param String code
	  * @return boolean	
	  */
	 private boolean existsCmdt(List<PriRpScpRtCmdtVO> vo, String code){
		 boolean result = false;
		 
		 if(vo != null && vo.size() > 0){
			 for(int i = 0 ; i < vo.size(); i++){
				 String strTarget = vo.get(i).getPrcCmdtDefCd();
				 if(code.equals(strTarget)){
					 result = true;
					 break;
				 } 
			 }
		 }
		 
		 return result;
	 }
	 /** 
	  * check to exists Customer <br>
	  * @param List<PriRpScpRtActCustVO> vo
	  * @param String code
	  * @return boolean	
	  */
	 private boolean existsCust(List<PriRpScpRtActCustVO> vo, String code){
		 boolean result = false;
		 
		 if(vo != null && vo.size() > 0){
			 for(int i = 0 ; i < vo.size(); i++){
				 String strCntCd = vo.get(i).getCustCntCd();
				 String strCustSeq = vo.get(i).getCustSeq();
				 String strTarget = strCntCd+strCustSeq;
				 if(code.equals(strTarget)){
					 result = true;
					 break;
				 }
			 }
		 }
		 
		 return result;
	 }

	 /** 
	  * check to exists Rout Via <br>
	  * @param List<PriRpScpRtRoutViaVO> vo
	  * @param String code
	  * @return boolean	
	  */
	 private boolean existsLocationVia(List<PriRpScpRtRoutViaVO> vo, String code){
		 boolean result = false;
		 
		 if(vo != null && vo.size() > 0){
			 for(int i = 0 ; i < vo.size(); i++){
				 String strTarget = vo.get(i).getRoutViaPortDefCd();
				 if(code.equals(strTarget)){
					 result = true;
					 break;
				 }
			 }
		 }
		 
		 return result;
	 }
	 
	 
	 /** 
	  * check to exists Rate <br>
	  * @param List<PriRpScpRtVO> vo
	  * @param String code
	  * @return boolean	
	  */
	 private boolean existsRate(List<PriRpScpRtVO> vo, String code){
		 boolean result = false;
		 if(vo != null && vo.size() > 0){
			 for(int i = 0 ; i < vo.size(); i++){
				 String strRatUtCd = vo.get(i).getRatUtCd();
				 String strPrcCgoTpCd = vo.get(i).getPrcCgoTpCd();
				 String strPropFrtRtAmt = vo.get(i).getPropFrtRtAmt();
				 String strTarget = strRatUtCd+strPrcCgoTpCd+strPropFrtRtAmt;
				 if(code.equals(strTarget)){
					 result = true;
					 break;
				 }
			 }
		 }
		 
		 return result;
	 }
	 
	 /** 
	  * check Whether the Data of Current DB are AM <br>
	  * @param List<PriRpScpRtCmdtVO> vo
	  * @return boolean	
	  */
	 private boolean isAllAmendedInDataCmdt(List<PriRpScpRtCmdtVO> vo) {
		 boolean result = false;
		 
		 if(vo.size() > 0){
			 int cnt = 0;
			 for(int i = 0; i < vo.size(); i++){
				 String strVal = vo.get(i).getSrcInfoCd();
				 if(strVal != null && strVal.equals("AM")){
					 cnt++;
				 }
			 }
			 if(cnt > 0 && (cnt == vo.size())){
				 result = true;
			 }
		 }

		 return result;
		 
	 }
	 
	 /** 
	  * check Whether the Data of Current DB are AM <br>
	  * @param List<PriRpScpRtActCustVO> vo
	  * @return boolean	
	  */
	 private boolean isAllAmendedInDataCust(List<PriRpScpRtActCustVO> vo) {
		 boolean result = false;
		 
		 if(vo.size() > 0){
			 int cnt = 0;
			 for(int i = 0; i < vo.size(); i++){
				 String strVal = vo.get(i).getSrcInfoCd();
				 if(strVal != null && strVal.equals("AM")){
					 cnt++;
				 }
			 }
			 if(cnt > 0 && (cnt == vo.size())){
				 result = true;
			 }
		 }

		 return result;
		 
	 }
	 
	 /** 
	  * check Whether the Data of Current DB are AM <br>
	  * @param List<PriRpScpRtRoutPntVO> vo
	  * @return boolean	
	  */
	 private boolean isAllAmendedInDataLocation(List<PriRpScpRtRoutPntVO> vo) {
		 boolean result = false;
		 
		 if(vo.size() > 0){
			 int cnt = 0;
			 for(int i = 0; i < vo.size(); i++){
				 String strVal = vo.get(i).getSrcInfoCd();
				 if(strVal != null && strVal.equals("AM")){
					 cnt++;
				 }
			 }
			 if(cnt > 0 && (cnt == vo.size())){
				 result = true;
			 }
		 }

		 return result;
		 
	 }
	 
	 /** 
	  * check Whether the Data of Current DB are AM <br>
	  * @param List<PriRpScpRtRoutViaVO> vo
	  * @return boolean	
	  */
	 private boolean isAllAmendedInDataLocationVia(List<PriRpScpRtRoutViaVO> vo) {
		 boolean result = false;
		 
		 if(vo.size() > 0){
			 int cnt = 0;
			 for(int i = 0; i < vo.size(); i++){
				 String strVal = vo.get(i).getSrcInfoCd();
				 if(strVal != null && strVal.equals("AM")){
					 cnt++;
				 }
			 }
			 if(cnt > 0 && (cnt == vo.size())){
				 result = true;
			 }
		 }

		 return result;
		 
	 }
	 
	 /** 
	  * check Whether the Data of Current DB are AM <br>
	  * @param List<PriRpScpRtVO> vo
	  * @return boolean	
	  */
	 private boolean isAllAmendedInDataRate(List<PriRpScpRtVO> vo) {
		 boolean result = false;
		 
		 if(vo.size() > 0){
			 int cnt = 0;
			 for(int i = 0; i < vo.size(); i++){
				 String strVal = vo.get(i).getSrcInfoCd();
				 if(strVal != null && strVal.equals("AM")){
					 cnt++;
				 }
			 }
			 if(cnt > 0 && (cnt == vo.size())){
				 result = true;
			 }
		 }

		 return result;
		 
	 }
	 

	 
	 /** 
	  * change to exists Commdity <br>
	  * @param List<PriRpScpRtCmdtVO> voList
	  * @param  PriRpScpRtCmdtVO vo
	  */
	 private void changeSameCmdt(List<PriRpScpRtCmdtVO> voList, PriRpScpRtCmdtVO vo){

		 if(voList != null && voList.size() > 0){
			 for(int i = 0 ; i < voList.size(); i++){
				 String strCd = vo.getPrcCmdtDefCd();
				 String strTarget = voList.get(i).getPrcCmdtDefCd();
				 if(strCd.equals(strTarget)){
					 voList.set(i, vo);
					 break;
				 }
			 }
		 }

	 }
	 
	 /** 
	  * change to exists Customer <br>
	  * @param List<PriRpScpRtActCustVO> voList
	  * @param  PriRpScpRtActCustVO vo
	  */
	 private void changeSameCust(List<PriRpScpRtActCustVO> voList, PriRpScpRtActCustVO vo){
		 
		 if(voList != null && voList.size() > 0){
			 for(int i = 0 ; i < voList.size(); i++){
				 
				 String strOCntCd = vo.getCustCntCd();
				 String strOCustSeq = vo.getCustSeq();
				 String strCd = strOCntCd+strOCustSeq;
				 
				 String strCntCd = voList.get(i).getCustCntCd();
				 String strCustSeq = voList.get(i).getCustSeq();
				 String strTarget = strCntCd+strCustSeq;
				 if(strCd.equals(strTarget)){
					 voList.set(i, vo);
				 }
			 }
		 }
		 
	 }

	 /** 
	  * change to exists Rout <br>
	  * @param List<PriRpScpRtRoutPntVO> voList
	  * @param  PriRpScpRtRoutPntVO vo
	  */
	 private void changeSameLocation(List<PriRpScpRtRoutPntVO> voList, PriRpScpRtRoutPntVO vo){

		 if(voList != null && voList.size() > 0){
			 for(int i = 0 ; i < voList.size(); i++){
				 String strCd = vo.getRoutPntLocDefCd();
				 String strTarget = voList.get(i).getRoutPntLocDefCd();
				 if(strCd.equals(strTarget)){
					 voList.set(i, vo);
					 break;
				 }
			 }
		 }

	 }
	 
	 /** 
	  * change to exists Rout Via <br>
	  * @param List<PriRpScpRtRoutViaVO> voList
	  * @param  PriRpScpRtRoutViaVO vo
	  */
	 private void changeSameLocationVia(List<PriRpScpRtRoutViaVO> voList, PriRpScpRtRoutViaVO vo){

		 if(voList != null && voList.size() > 0){
			 for(int i = 0 ; i < voList.size(); i++){
				 String strCd = vo.getRoutViaPortDefCd();
				 String strTarget = voList.get(i).getRoutViaPortDefCd();
				 if(strCd.equals(strTarget)){
					 voList.set(i, vo);
					 break;
				 }
			 }
		 }

	 }

	 /** 
	  * change to exists Rate <br>
	  * @param List<PriRpScpRtVO> voList
	  * @param  PriRpScpRtVO vo
	  */
	 private void changeSameRate(List<PriRpScpRtVO> voList, PriRpScpRtVO vo){
		 
		 if(voList != null && voList.size() > 0){
			 for(int i = 0 ; i < voList.size(); i++){
				 
				 String strORatUtCd = vo.getRatUtCd();
				 String strOPrcCgoTpCd = vo.getPrcCgoTpCd();
				 String strOPropFrtRtAmt = vo.getPropFrtRtAmt();
				 String strCd = strORatUtCd+strOPrcCgoTpCd+strOPropFrtRtAmt;
				 
				 String strRatUtCd = voList.get(i).getRatUtCd();
				 String strPrcCgoTpCd = voList.get(i).getPrcCgoTpCd();
				 String strPropFrtRtAmt = voList.get(i).getPropFrtRtAmt();
				 String strTarget = strRatUtCd+strPrcCgoTpCd+strPropFrtRtAmt;
				 if(strCd.equals(strTarget)){
					 voList.set(i, vo);
				 }
			 }
		 }
		 
	 }
	 
	 /**
	  * make PriRpScpRtCmdtRoutVO for delete <br>
	  * 
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @return PriRpScpRtCmdtRoutVO
	  */
	 private PriRpScpRtCmdtRoutVO makeRoutForDel(RsltRtListHorizontalExcelVO row, PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO){
		 
		 PriRpScpRtCmdtRoutVO vo = new PriRpScpRtCmdtRoutVO();
		 vo.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
		 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
		 vo.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
		 vo.setCmdtHdrSeq(row.getCmdtHdrSeq());
		 vo.setRoutSeq(row.getRoutSeq());
    	 
    	 return vo;
	 }

	 /**
	  * make PriRpScpRtCmdtHdrVO for delete <br>
	  * 
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @return PriRpScpRtCmdtHdrVO
	  */
	 private PriRpScpRtCmdtHdrVO makeCmdtHdrForDel(RsltRtListHorizontalExcelVO row, PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO){
		 
		 PriRpScpRtCmdtHdrVO vo = new PriRpScpRtCmdtHdrVO();
		 vo.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
		 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
		 vo.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
		 vo.setCmdtHdrSeq(row.getCmdtHdrSeq());

    	 return vo;
	 }
	 /**
	  * make PriRpScpRtCmdtHdrVO with RsltRtListHorizontalExcelVO and add it to List<PriRpScpRtCmdtHdrVO> <br>
	  * 
	  * @param List<PriRpScpRtCmdtHdrVO> cmdtHdrVoList : the result object to be created
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @param int nextCmdtHdrSeq
	  * @param String strCreUsrId
	  * @param String strUpdUsrId
	  */
	 private void makeCmdtHdrForCreate(List<PriRpScpRtCmdtHdrVO> 	cmdtHdrVoList, RsltRtListHorizontalExcelVO row, PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, 
			                            int nextCmdtHdrSeq, String strCreUsrId, String strUpdUsrId){
		 
		 PriRpScpRtCmdtHdrVO vo = new PriRpScpRtCmdtHdrVO();
		 vo.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
		 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
		 vo.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
		 vo.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
		 vo.setBletDpSeq("");
		 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
         vo.setCreUsrId(strCreUsrId);
         vo.setUpdUsrId(strUpdUsrId);
         
         cmdtHdrVoList.add(vo);

	 } 
	 
	 /**
	  * check the param value(SrcInfoCd) is the same code like NW <br>
	  * 
	  * @param String val : SrcInfoCd
	  * @exception boolean (true/false)
	  */
	 private boolean isSrcInfoNw(String val){
		 boolean result = false;
		 
		 if(val.equals("NW") || val.equals("PC") || val.equals("PM") || val.equals("GC") || val.equals("GM")){
			 result = true;
		 }
		 
		 return result;
	 }
	 
	 /**
	  * make PriRpScpRtCmdtVO with RsltRtListHorizontalExcelVO and add it to List<PriRpScpRtCmdtVO> <br>
	  * 
	  * @param String rowType
	  * @param List<PriRpScpRtCmdtVO> cmdtVoList : the result object to be created
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @param int nextCmdtHdrSeq
	  * @param String strCreUsrId
	  * @param String strUpdUsrId
	  * @exception EventException
	  */
	 private void makeCmdtForCreate(String rowType, List<PriRpScpRtCmdtVO> cmdtVoList, RsltRtListHorizontalExcelVO row, PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, 
			                         int nextCmdtHdrSeq, String strCreUsrId, String strUpdUsrId) throws EventException {

		 
		 try {
			 //CUR CMDT LIST
			 List<PriRpScpRtCmdtVO> cTmpCmdtVoList = new ArrayList<PriRpScpRtCmdtVO>();
			 //get current info data to compare
			 List<PriRpScpRtCmdtVO> tVO            = new ArrayList<PriRpScpRtCmdtVO>();
			 //previous AmdtSeq's DB Info
			 List<PriRpScpRtCmdtVO> preDBVO        = new ArrayList<PriRpScpRtCmdtVO>();
			 //current AmdtSeq's DB Info
			 List<PriRpScpRtCmdtVO> curDBVO        = new ArrayList<PriRpScpRtCmdtVO>();
			 if(rowType.equals("U") || (rowType.equals("D") && !priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") )){
				 
				 tVO = dbDao.searchPriRpScpRtCmdtList(priRpScpRtCmdtHdrVO);
				 if(tVO.size() == 0){
					 return;
				 }
				 
				 preDBVO        = getCmdtInfoForAmdtSeq(tVO, priRpScpRtCmdtHdrVO.getAmdtSeq(), false);
				 curDBVO        = getCmdtInfoForAmdtSeq(tVO, priRpScpRtCmdtHdrVO.getAmdtSeq(), true);
				 
			 }
			 
			 //TYPE(C) OR TYPE(U) -> CREATE DATA WITH EXCEL
			 if(rowType.equals("U") || rowType.equals("C")){
				 
				 if( priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && (curDBVO == null || curDBVO.size() == 0) && rowType.equals("U") ){
					 return;
				 }
				 
				 String cmdtCds = row.getPrcCmdtDefCd();
				 if(cmdtCds != null && !cmdtCds.equals("")) {
					 String[] arrCmdtCd = cmdtCds.split(";");
					 if(arrCmdtCd.length > 0) {
						 
						 String txCmdtSeq = "";
						 if(rowType.equals("C") && row.getCmdtHdrSeq().equals("")){
							 txCmdtSeq = String.valueOf(nextCmdtHdrSeq);
				         } else {
				        	 txCmdtSeq = row.getCmdtHdrSeq();
				         }
					 
						 for(int i = 0; i < arrCmdtCd.length; i++) {

							 String strPrcCmdtDefCd = arrCmdtCd[i];
							 String strPrcCmdtTpCd = arrCmdtCd[i].length() == 5 ? "G" : "C";
					         
					         PriRpScpRtCmdtVO vo = new PriRpScpRtCmdtVO();
					         vo.setIbflag(rowType);
					         
					         vo.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					         vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					         vo.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					         vo.setCmdtHdrSeq(txCmdtSeq);
					         vo.setCmdtSeq("");
					         vo.setPrcCmdtTpCd(strPrcCmdtTpCd);
					         vo.setPrcCmdtDefCd(strPrcCmdtDefCd);
					         vo.setPrcProgStsCd("I");
					         vo.setSrcInfoCd("NW");	
					         vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					         vo.setCreUsrId(strCreUsrId);
					         vo.setUpdUsrId(strUpdUsrId);
					         
					         if(rowType.equals("C")){
					        	 cmdtVoList.add(vo);
					         } else {
					        	 cTmpCmdtVoList.add(vo);
					         }
					         
						 }
					 }
				 }
			 } else if(rowType.equals("D")){
				 if( priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("D") ){
					 return;
				 }

				 //TYPE(D) AND EXSITS DATA IN DB
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 for(int i = 0; i < curDBVO.size(); i++){
						 curDBVO.get(i).setIbflag(rowType);
						 curDBVO.get(i).setPrcProgStsCd("I");
						 curDBVO.get(i).setSrcInfoCd("AD");
						 curDBVO.get(i).setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
						 curDBVO.get(i).setCreUsrId(strCreUsrId);
						 curDBVO.get(i).setUpdUsrId(strUpdUsrId);
					 }
					 
					 cmdtVoList.addAll(curDBVO);
				 }
				 
			 }
			 
			 if(!priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("U")){
				 
				 
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 if(curDBVO.size() != cTmpCmdtVoList.size()){
						 //------------
						 // current db row count != current(excel) row count
						 //------------
						 
						 //when current db codes(NW,AM) are equal with current data, use current db info
						 //when current data code are not equal with current db code -> already include in current data
						 //(1)
						 for(int i = 0; i < curDBVO.size(); i++){
							 String curDbCd       = curDBVO.get(i).getPrcCmdtDefCd();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPagerows = curDBVO.get(i).getPagerows();
							 for(int x = 0; x < cTmpCmdtVoList.size(); x++){
								 String curCd = cTmpCmdtVoList.get(x).getPrcCmdtDefCd();
								 if(curDbCd.equals(curCd) && ( isSrcInfoNw(curDbSrc) || curDbSrc.equals("AM") ) && StringUtils.isEmpty(curDbPagerows) ){
									 curDBVO.get(i).setPagerows("X");
									 PriRpScpRtCmdtVO vo = curDBVO.get(i);
									 changeSameCmdt(cTmpCmdtVoList, vo);
								 }
							 }
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOCmdt(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOCmdt(cTmpCmdtVoList);
						 
						 boolean isAmendedAll1 = isAllAmendedInDataCmdt(curDBVO);
						 if(!isAmendedAll1){
							 //when there are some diffent codes
							 //different codes(NW) -> using current db code(with AD)
							 //different codes(AM) -> compare preDB
							 //                       current db code is different with previous db code and it's seq is same and there is no comparing current data
							 //						  	-->using previous db info(with AD)
							 //						  current db code is same with previous db code and it's seq is not same and there are comparing current datas
							 //                         -->using prevois db info
							 
							 for(int i = 0; i < curDBVO.size(); i++){
								 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
								 String curDbCd       = curDBVO.get(i).getPrcCmdtDefCd();
								 String curDbCmdtSeq  = curDBVO.get(i).getCmdtSeq();
								 String curDbPagerows = curDBVO.get(i).getPagerows();
								 if(StringUtils.isEmpty(curDbPagerows) && isSrcInfoNw(curDbSrc)){
									 curDBVO.get(i).setPagerows("X");
									 PriRpScpRtCmdtVO vo = curDBVO.get(i);
									 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
									 vo.setPrcProgStsCd("I");
									 vo.setSrcInfoCd("AD");
									 cTmpCmdtVoList.add(vo);								 
								 } else if(StringUtils.isEmpty(curDbPagerows) && curDbSrc.equals("AM")){
									 if(preDBVO != null && preDBVO.size() > 0){
										 for(int x = 0; x < preDBVO.size(); x++){
											 String preDbCd       = preDBVO.get(x).getPrcCmdtDefCd();
											 String preDbCmdtSeq  = preDBVO.get(x).getCmdtSeq();
											 String preDbPagerows = preDBVO.get(x).getPagerows();
											 if( !curDbCd.equals(preDbCd) && curDbCmdtSeq.equals(preDbCmdtSeq) && noUseCurCnt == 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 PriRpScpRtCmdtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setPrcProgStsCd("I");
												 vo.setSrcInfoCd("AD");
												 changeSameCmdt(cTmpCmdtVoList, vo);
												 break;
												 
											 } else if( curDbCd.equals(preDbCd) && !curDbCmdtSeq.equals(preDbCmdtSeq) && noUseCurCnt != 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 curDBVO.get(i).setPagerows("X");
												 PriRpScpRtCmdtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameCmdt(cTmpCmdtVoList, vo);
												 break;
												 
											 }
										 }
									 }
									 
								 }
							 }
							 
						 } else if(isAmendedAll1 && noUseCurDbCnt != 0){
							 //if(noUseCurDbCnt > 0 && noUseCurDbCnt == curDBVO.size()){
							 //when diffent codes are all, compare previous db and current data
							 
							 //previous data codes are same with current data code     -> use previous datas
							 //previous data codes are not same with current data code -> use previous datas(AD)
							 List<PriRpScpRtCmdtVO> tmpCmdt1 =  new ArrayList<PriRpScpRtCmdtVO>();
							 tmpCmdt1.addAll(cTmpCmdtVoList);
							 if(preDBVO != null && preDBVO.size() > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getPrcCmdtDefCd();

									 boolean isExists = existsCmdt(tmpCmdt1, preDbCd);
									 if(isExists){
										 for(int i = 0; i < tmpCmdt1.size(); i++){
											 String cd       = tmpCmdt1.get(i).getPrcCmdtDefCd();
											 if(preDbCd.equals(cd) && tmpCmdt1.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriRpScpRtCmdtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameCmdt(cTmpCmdtVoList, vo);
												 changeSameCmdt(tmpCmdt1, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriRpScpRtCmdtVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 cTmpCmdtVoList.add(vo);
										 continue;
									 }
									 
									 
								 } 
							 }
							 
						 }

						 
					 } else {
						 //------------
						 // current db row count == current(excel) row count
						 //------------
						 
						 //
						 //when current db srcInfoCd is all AM     -> remove current db and compare previous db (2)
						 //when current db srcInfoCd is not all AM -> (1) current db code(NW,AM) equal with current data
						 //													-> using current db info
						 //												  current db code(AD) do not equal with current data
						 //													-> using current db info
						 //                                           (3) current db code(AM) does not exists in current data
						 //(1)
						 
						 boolean isAmendedAll2 = isAllAmendedInDataCmdt(curDBVO);
						 
						 List<PriRpScpRtCmdtVO> tmpCmdt1 =  new ArrayList<PriRpScpRtCmdtVO>();
						 tmpCmdt1.addAll(cTmpCmdtVoList);
						 
						 for(int i = (curDBVO.size() - 1); i >= 0; i--){
							 String curDbCd       = curDBVO.get(i).getPrcCmdtDefCd();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPages    = curDBVO.get(i).getPagerows();
							 int    noCntInCur = 0;
							 boolean isExists = existsCmdt(tmpCmdt1, curDbCd);
							 if(isExists){
								 for(int x = 0; x < tmpCmdt1.size(); x++){

									 String cd       = tmpCmdt1.get(x).getPrcCmdtDefCd();
									 String pages    = tmpCmdt1.get(x).getPagerows();
									 if(!curDbCd.equals(cd) && curDbSrc.equals("AM")){
										 noCntInCur++;
										 break;
									 }

									 if(curDbCd.equals(cd) && StringUtils.isEmpty(pages)){
										 curDBVO.get(i).setPagerows("X");
										 PriRpScpRtCmdtVO vo = curDBVO.get(i);
										 changeSameCmdt(cTmpCmdtVoList, vo);
										 changeSameCmdt(tmpCmdt1, vo);
										 break;
									 }
								 }
							 } else {
								 
								 for(int x = 0; x < cTmpCmdtVoList.size(); x++){
									 String cd       = cTmpCmdtVoList.get(x).getPrcCmdtDefCd();
									 if(!curDbCd.equals(cd) && !curDbSrc.equals("AD")){
										 noCntInCur++;
										 break;
									 }
									 
									 if(!curDbCd.equals(cd) && StringUtils.isEmpty(curDbPages)){
										 curDBVO.get(i).setPagerows("X");
										 PriRpScpRtCmdtVO vo = curDBVO.get(i);
										 cTmpCmdtVoList.add(vo);
										 break;
									 }
								 }
							 }
							 
							 if(noCntInCur > 0 && curDbSrc.equals("AM") ){
								 curDBVO.remove(i);
							 }
						 	 
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOCmdt(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOCmdt(cTmpCmdtVoList);
						 
						 //(2)
						 //compare preDB data with cur data
						 //when preDB code equal with cur data        -> use preDB Info
						 //when preDB code do not equal with cur data -> use preDB Info and srcInfoCd(AD)
						 if(isAmendedAll2){
							 if(preDBVO != null && preDBVO.size() > 0 && noUseCurCnt > 0){
								 
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getPrcCmdtDefCd();
									 
									 boolean isExists = existsCmdt(cTmpCmdtVoList, preDbCd);
									 if(isExists){
										 for(int i = 0; i < cTmpCmdtVoList.size(); i++){
											 String cd       = cTmpCmdtVoList.get(i).getPrcCmdtDefCd();
											 if(preDbCd.equals(cd) && cTmpCmdtVoList.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriRpScpRtCmdtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameCmdt(cTmpCmdtVoList, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriRpScpRtCmdtVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 cTmpCmdtVoList.add(vo);
										 continue;
									 }

								 } 
							 }
						 }
						 
						 //(3)
						 //no use code in current db code(AM) 1 and no use code in current data is 1
						 //change current db code to current code
						 noUseCurCnt   = getNoUseDataCntForVOCmdt(cTmpCmdtVoList);
						 if(noUseCurCnt > 0){
							 for(int x = 0; x < cTmpCmdtVoList.size(); x++){
								 String curDbPagerows   = cTmpCmdtVoList.get(x).getPagerows();
								 //change curDB to cur
								 //using new(=cur) info and only change to the CmdtHdrSeq and CmdtSeq in curDB 
								 if((curDbPagerows == null || curDbPagerows.equals("")) && ((noUseCurDbCnt >= 1 && noUseCurCnt >= 1) && (noUseCurDbCnt == noUseCurCnt))){
									 if(curDBVO != null && curDBVO.size() > 0){
										 for(int i = 0; i < curDBVO.size(); i++){
											 String curPagerows  = curDBVO.get(i).getPagerows();
											 String curSrcInfoCd = curDBVO.get(i).getSrcInfoCd();
											 if(StringUtils.isEmpty(curPagerows) && isSrcInfoNw(curSrcInfoCd)){
												 curDBVO.get(i).setPagerows("X");
												 cTmpCmdtVoList.get(x).setCmdtHdrSeq(curDBVO.get(i).getCmdtHdrSeq());
												 cTmpCmdtVoList.get(x).setCmdtSeq(curDBVO.get(i).getCmdtSeq());
												 cTmpCmdtVoList.get(x).setPrcProgStsCd("I");
												 cTmpCmdtVoList.get(x).setSrcInfoCd("AM");
												 break;
											 }

										 }
									 }
									 
								 }
							 }
						 }
						 
					 }
					 
					 
					 
					 
				 } //end if(curDBVO != null && curDBVO.size() > 0){
			 } // end if(rowType.equals("U")){
			 
			 cmdtVoList.addAll(cTmpCmdtVoList);
			 
		 } catch (DAOException ex) {
			 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         } catch (Exception ex) {
        	 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         }
		 
	 }
	 /**
	  * make PriRpScpRtActCustVO with RsltRtListHorizontalExcelVO and add it to List<PriRpScpRtActCustVO> <br>
	  * 
	  * @param String rowType
	  * @param List<PriRpScpRtActCustVO> custVoList : the result object to be created
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @param int nextCmdtHdrSeq
	  * @param String strCreUsrId
	  * @param String strUpdUsrId
	  * @exception EventException
	  */
	 private void makeActCustForCreate(String rowType, List<PriRpScpRtActCustVO> custVoList, RsltRtListHorizontalExcelVO row, PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, 
			                            int nextCmdtHdrSeq, String strCreUsrId, String strUpdUsrId) throws EventException {

		 try {
			 //CUR LIST
			 List<PriRpScpRtActCustVO> curTmpVoList = new ArrayList<PriRpScpRtActCustVO>();
			 //get current info data to compare
			 List<PriRpScpRtActCustVO> tVO            = new ArrayList<PriRpScpRtActCustVO>();
			 //previous AmdtSeq's DB Info
			 List<PriRpScpRtActCustVO> preDBVO        = new ArrayList<PriRpScpRtActCustVO>();
			 //current AmdtSeq's DB Info
			 List<PriRpScpRtActCustVO> curDBVO        = new ArrayList<PriRpScpRtActCustVO>();
			 if(rowType.equals("U") || (rowType.equals("D") && !priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") )){
				 
				 tVO = dbDao.searchPriRpScpRtActCustList(priRpScpRtCmdtHdrVO);
				 if(tVO.size() == 0){
					 return;
				 }
				 
				 preDBVO        = getCustForAmdtSeq(tVO, priRpScpRtCmdtHdrVO.getAmdtSeq(), false);
				 curDBVO        = getCustForAmdtSeq(tVO, priRpScpRtCmdtHdrVO.getAmdtSeq(), true);
				 
			 }

			 //TYPE(C) OR TYPE(U) -> CREATE DATA WITH EXCEL
			 if(rowType.equals("U") || rowType.equals("C")){
				 
				 if( priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && (curDBVO == null || curDBVO.size() == 0) && rowType.equals("U") ){
					 return;
				 }
				 
				 String custs = row.getCustSeq();
				 if(custs != null && !custs.equals("")) {
					 String[] arrCust = custs.split(";");
					 if(arrCust.length > 0) {
						 
						 String txCmdtSeq = "";
						 if(rowType.equals("C") && row.getCmdtHdrSeq().equals("")){
							 txCmdtSeq = String.valueOf(nextCmdtHdrSeq);
				         } else {
				        	 txCmdtSeq = row.getCmdtHdrSeq();
				         }
					 
						 for(int i = 0; i < arrCust.length; i++) {

							 
					         String strCustCntCd = arrCust[i].substring(0,2);
							 String strCustSeq = arrCust[i].substring(2);
					         
							 PriRpScpRtActCustVO vo = new PriRpScpRtActCustVO();
							 vo.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					         vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					         vo.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					         
					         vo.setCmdtHdrSeq(txCmdtSeq);
					         
			                 vo.setActCustSeq("");
			                 vo.setCustCntCd(strCustCntCd);
			                 vo.setCustSeq(strCustSeq);
			                 vo.setPrcProgStsCd("I");
			                 vo.setSrcInfoCd("NW");	
			                 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
			                 vo.setCreUsrId(strCreUsrId);
			                 vo.setUpdUsrId(strUpdUsrId);
					         
					         
					         if(rowType.equals("C")){
					        	 custVoList.add(vo);
					         } else {
					        	 curTmpVoList.add(vo);
					         }
					         
						 }
					 }
				 }
			 } else if(rowType.equals("D")){
				 
				 if( priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("D") ){
					 return;
				 }
				 
				 //TYPE(D) AND EXSITS DATA IN DB
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 for(int i = 0; i < curDBVO.size(); i++){
						 curDBVO.get(i).setIbflag(rowType);
						 curDBVO.get(i).setPrcProgStsCd("I");
						 curDBVO.get(i).setSrcInfoCd("AD");
						 curDBVO.get(i).setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
						 curDBVO.get(i).setCreUsrId(strCreUsrId);
						 curDBVO.get(i).setUpdUsrId(strUpdUsrId);
					 }
					 
					 custVoList.addAll(curDBVO);
				 }
				 
			 }
			 
			 if(!priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("U")){
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 if(curDBVO.size() != curTmpVoList.size()){
						 //------------
						 // current db row count != current(excel) row count
						 //------------
						 
						 //when current db codes(NW,AM) are equal with current data, use current db info
						 //when current data code are not equal with current db code -> already include in current data
						 //(1)
						 for(int i = 0; i < curDBVO.size(); i++){
							 String curDbCustCntCd= curDBVO.get(i).getCustCntCd();
							 String curDbCustSeq  = curDBVO.get(i).getCustSeq();
							 String curDbCd       = curDbCustCntCd + curDbCustSeq;
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPagerows = curDBVO.get(i).getPagerows();
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curCustCntCd = curTmpVoList.get(x).getCustCntCd();
								 String curCustSeq   = curTmpVoList.get(x).getCustSeq();
								 String curCd        = curCustCntCd + curCustSeq;
								 if(curDbCd.equals(curCd) && ( isSrcInfoNw(curDbSrc) || curDbSrc.equals("AM") ) && StringUtils.isEmpty(curDbPagerows)){
									 curDBVO.get(i).setPagerows("X");
									 PriRpScpRtActCustVO vo = curDBVO.get(i);
									 changeSameCust(curTmpVoList, vo);
								 }
							 }
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOCust(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOCust(curTmpVoList);
						 
						 boolean isAmendedAll1 = isAllAmendedInDataCust(curDBVO);
						 if(!isAmendedAll1){
							 //when there are some diffent codes
							 
							 //different codes(NW) -> using current db code(with AD)
							 //different codes(AM) -> compare preDB
							 //                       current db code is different with previous db code and it's seq is same and there is no comparing current data
							 //						  	-->using previous db info(with AD)
							 //						  current db code is same with previous db code and it's seq is not same and there are comparing current datas
							 //                         -->using prevois db info
							 for(int i = 0; i < curDBVO.size(); i++){
								 String curDbSrc        = curDBVO.get(i).getSrcInfoCd();
								 String curDbCustCntCd  = curDBVO.get(i).getCustCntCd();
								 String curDbCustSeq    = curDBVO.get(i).getCustSeq();
								 String curDbCd         = curDbCustCntCd + curDbCustSeq;
								 String curDbActCustSeq = curDBVO.get(i).getActCustSeq();
								 String curDbPagerows   = curDBVO.get(i).getPagerows();
								 if(StringUtils.isEmpty(curDbPagerows) && isSrcInfoNw(curDbSrc)){
									 curDBVO.get(i).setPagerows("X");
									 PriRpScpRtActCustVO vo = curDBVO.get(i);
									 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
									 vo.setPrcProgStsCd("I");
									 vo.setSrcInfoCd("AD");
									 curTmpVoList.add(vo);								 
								 } else if(StringUtils.isEmpty(curDbPagerows) && curDbSrc.equals("AM")){
									 if(preDBVO != null && preDBVO.size() > 0){
										 for(int x = 0; x < preDBVO.size(); x++){
											 String preDbCustCntCd   = preDBVO.get(x).getCustCntCd();
											 String preDbCustSeq     = preDBVO.get(x).getCustSeq();
											 String preDbCd          = preDbCustCntCd + preDbCustSeq;
											 String preDbActCustSeq  = preDBVO.get(x).getActCustSeq();
											 String preDbPagerows    = preDBVO.get(x).getPagerows();
											 if( !curDbCd.equals(preDbCd) && curDbActCustSeq.equals(preDbActCustSeq) && noUseCurCnt == 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 PriRpScpRtActCustVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setPrcProgStsCd("I");
												 vo.setSrcInfoCd("AD");
												 changeSameCust(curTmpVoList, vo);
												 break;
												 
											 } else if( curDbCd.equals(preDbCd) && !curDbActCustSeq.equals(preDbActCustSeq) && noUseCurCnt != 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 curDBVO.get(i).setPagerows("X");
												 PriRpScpRtActCustVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameCust(curTmpVoList, vo);
												 break;
												 
											 }
										 }
									 }
									 
								 }
							 }
							 
						 } else if(isAmendedAll1 && noUseCurDbCnt != 0){
							 //when diffent codes are all, compare previous db and current data
							 
							 //previous data codes are same with current data code     -> use previous datas
							 //previous data codes are not same with current data code -> use previous datas(AD)
							 List<PriRpScpRtActCustVO> tmpCmdt1 =  new ArrayList<PriRpScpRtActCustVO>();
							 tmpCmdt1.addAll(curTmpVoList);
							 if(preDBVO != null && preDBVO.size() > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCustCntCd   = preDBVO.get(x).getCustCntCd();
									 String preDbCustSeq     = preDBVO.get(x).getCustSeq();
									 String preDbCd          = preDbCustCntCd + preDbCustSeq;
									 
									 boolean isExists = existsCust(tmpCmdt1, preDbCd);
									 if(isExists){
										 for(int i = 0; i < tmpCmdt1.size(); i++){
											 
											 String curCustCntCd  = tmpCmdt1.get(i).getCustCntCd();
											 String curCustSeq    = tmpCmdt1.get(i).getCustSeq();
											 String cd            = curCustCntCd + curCustSeq;
											 
											 if(preDbCd.equals(cd) && tmpCmdt1.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriRpScpRtActCustVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameCust(curTmpVoList, vo);
												 changeSameCust(tmpCmdt1, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriRpScpRtActCustVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 
									 
								 } 
							 }
							 
						 }

						 
					 } else {
						 //------------
						 // current db row count == current(excel) row count
						 //------------
						 
						 //
						 //when current db srcInfoCd is all AM     -> remove current db and compare previous db (2)
						 //when current db srcInfoCd is not all AM -> (1) current db code(NW,AM) equal with current data
						 //													-> using current db info
						 //												  current db code(AD) do not equal with current data
						 //													-> using current db info
						 //                                           (3) current db code(AM) does not exists in current data
						 //(1)
						 
						 boolean isAmendedAll2 = isAllAmendedInDataCust(curDBVO);
						 
						 List<PriRpScpRtActCustVO> tmpCmdt1 =  new ArrayList<PriRpScpRtActCustVO>();
						 tmpCmdt1.addAll(curTmpVoList);
						 
						 for(int i = (curDBVO.size() - 1); i >= 0; i--){

							 String curDbCustCntCd  = curDBVO.get(i).getCustCntCd();
							 String curDbCustSeq    = curDBVO.get(i).getCustSeq();
							 String curDbCd         = curDbCustCntCd + curDbCustSeq;
							 String curDbSrc        = curDBVO.get(i).getSrcInfoCd();
							 String curDbPages      = curDBVO.get(i).getPagerows();
							 int    noCntInCur = 0;
							 boolean isExists = existsCust(tmpCmdt1, curDbCd);
							 if(isExists){
								 for(int x = 0; x < tmpCmdt1.size(); x++){
									 String curCustCntCd  = tmpCmdt1.get(x).getCustCntCd();
									 String curCustSeq    = tmpCmdt1.get(x).getCustSeq();
									 String cd            = curCustCntCd + curCustSeq;
									 
									 String pages    = tmpCmdt1.get(x).getPagerows();
									 if(!curDbCd.equals(cd) && curDbSrc.equals("AM")){
										 noCntInCur++;
										 break;
									 }

									 if(curDbCd.equals(cd) && StringUtils.isEmpty(pages)){
										 curDBVO.get(i).setPagerows("X");
										 PriRpScpRtActCustVO vo = curDBVO.get(i);
										 changeSameCust(curTmpVoList, vo);
										 changeSameCust(tmpCmdt1, vo);
										 break;
									 }
								 }
							 } else {
								 
								 for(int x = 0; x < curTmpVoList.size(); x++){
									 String curCustCntCd  = curTmpVoList.get(x).getCustCntCd();
									 String curCustSeq    = curTmpVoList.get(x).getCustSeq();
									 String cd            = curCustCntCd + curCustSeq;
									 
									 if(!curDbCd.equals(cd) && !curDbSrc.equals("AD")){
										 noCntInCur++;
										 break;
									 }
									 
									 if(!curDbCd.equals(cd) && StringUtils.isEmpty(curDbPages)){
										 curDBVO.get(i).setPagerows("X");
										 PriRpScpRtActCustVO vo = curDBVO.get(i);
										 curTmpVoList.add(vo);
										 break;
									 }
								 }
							 }
							 
							 if(noCntInCur > 0 && curDbSrc.equals("AM") ){
								 curDBVO.remove(i);
							 }
						 	 
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOCust(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOCust(curTmpVoList);
						 
						 //(2)
						 //compare preDB data with cur data
						 //when preDB code equal with cur data        -> use preDB Info
						 //when preDB code do not equal with cur data -> use preDB Info and srcInfoCd(AD)
						 if(isAmendedAll2){
							 if(preDBVO != null && preDBVO.size() > 0 && noUseCurCnt > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCustCntCd   = preDBVO.get(x).getCustCntCd();
									 String preDbCustSeq     = preDBVO.get(x).getCustSeq();
									 String preDbCd          = preDbCustCntCd + preDbCustSeq;
									 
									 boolean isExists = existsCust(curTmpVoList, preDbCd);
									 if(isExists){
										 for(int i = 0; i < curTmpVoList.size(); i++){
											 String curCustCntCd   = curTmpVoList.get(i).getCustCntCd();
											 String curCustSeq     = curTmpVoList.get(i).getCustSeq();
											 String cd             = curCustCntCd + curCustSeq;
											 
											 if(preDbCd.equals(cd) && curTmpVoList.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriRpScpRtActCustVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameCust(curTmpVoList, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriRpScpRtActCustVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 
									 
								 } 
							 }
						 }
						 
						 //(3)
						 //no use code in current db code(AM) 1 and no use code in current data is 1
						 //change current db code to current code
						 noUseCurCnt   = getNoUseDataCntForVOCust(curTmpVoList);
						 if(noUseCurCnt > 0){
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curDbPagerows   = curTmpVoList.get(x).getPagerows();
								 //change curDB to cur
								 //using new(=cur) info and only change to the CmdtHdrSeq and CmdtSeq in curDB 
								 if((curDbPagerows == null || curDbPagerows.equals("")) && ((noUseCurDbCnt >= 1 && noUseCurCnt >= 1) && (noUseCurDbCnt == noUseCurCnt))){
									 if(curDBVO != null && curDBVO.size() > 0){
										 for(int i = 0; i < curDBVO.size(); i++){
											 String curPagerows  = curDBVO.get(i).getPagerows();
											 String curSrcInfoCd = curDBVO.get(i).getSrcInfoCd();
											 if(StringUtils.isEmpty(curPagerows) && isSrcInfoNw(curSrcInfoCd)){
												 curDBVO.get(i).setPagerows("X");
												 curTmpVoList.get(x).setCmdtHdrSeq(curDBVO.get(i).getCmdtHdrSeq());
												 curTmpVoList.get(x).setActCustSeq(curDBVO.get(i).getActCustSeq());
												 curTmpVoList.get(x).setPrcProgStsCd("I");
												 curTmpVoList.get(x).setSrcInfoCd("AM");
												 break;
											 }
										 }
									 }
									 
								 }
							 }
						 }
						 
					 }
					 
					 
					 
					 
				 } //end if(curDBVO != null && curDBVO.size() > 0)
			 } // end if(rowType.equals("U"))

			 custVoList.addAll(curTmpVoList);
			 
		 } catch (DAOException ex) {
			 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         } catch (Exception ex) {
        	 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         }
		 
	 }
	 /**
	  * make PriRpScpRtCmdtRoutVO with RsltRtListHorizontalExcelVO and add it to List<PriRpScpRtCmdtRoutVO> <br>
	  * 
	  * @param List<PriRpScpRtCmdtRoutVO> routVoList : the result object to be created
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @param int nextCmdtHdrSeq
	  * @param int nextRoutSeq
	  * @param String strCreUsrId
	  * @param String strUpdUsrId
	  */
	 private void makeCmdtRoutForCreate(List<PriRpScpRtCmdtRoutVO> routVoList, RsltRtListHorizontalExcelVO row, PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, 
			                             int nextCmdtHdrSeq, int nextRoutSeq, String strCreUsrId, String strUpdUsrId){
	 
		 PriRpScpRtCmdtRoutVO vo = new PriRpScpRtCmdtRoutVO();
		 vo.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
	     vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
	     vo.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
	     vo.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
	     vo.setRoutSeq(String.valueOf(nextRoutSeq));
	     vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
	     vo.setCreUsrId(strCreUsrId);
	     vo.setUpdUsrId(strUpdUsrId);
	     
	     routVoList.add(vo);
     }
	 
	 /**
	  * make PriRpScpRtRoutPntVO with RsltRtListHorizontalExcelVO and add it to List<PriRpScpRtRoutPntVO> <br>
	  * 
	  * @param String rowType
	  * @param List<PriRpScpRtRoutPntVO> pntVoList : the result object to be created
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @param ArrayList<CodeInfo> termOrgCodeList
	  * @param ArrayList<CodeInfo> termDestCodeList
	  * @param ArrayList<CodeInfo> trspModCodeList
	  * @param int nextCmdtHdrSeq
	  * @param int nextRoutSeq
	  * @param String strCreUsrId
	  * @param String strUpdUsrId
	  * @exception EventException
	  */
	 private void makeLocForCreate(String rowType, List<PriRpScpRtRoutPntVO> pntVoList, RsltRtListHorizontalExcelVO row, PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, String strOrgDestTpCd, 
			                        ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, 
			                        int nextCmdtHdrSeq, int nextRoutSeq, String strCreUsrId, String strUpdUsrId) throws EventException {
		 
		 try {
			 
			 //CUR LIST
			 List<PriRpScpRtRoutPntVO> curTmpVoList = new ArrayList<PriRpScpRtRoutPntVO>();
			 //get current info data to compare
			 List<PriRpScpRtRoutPntVO> tVO			= new ArrayList<PriRpScpRtRoutPntVO>();
			 //previous AmdtSeq's DB Info
			 List<PriRpScpRtRoutPntVO> preDBVO      = new ArrayList<PriRpScpRtRoutPntVO>();
			 //current AmdtSeq's DB Info
			 List<PriRpScpRtRoutPntVO> curDBVO      = new ArrayList<PriRpScpRtRoutPntVO>();
			 
			 if(rowType.equals("U") || (rowType.equals("D") && !priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") )){				 
				 tVO = dbDao.searchPriRpScpRtRoutPntList(priRpScpRtCmdtHdrVO, strOrgDestTpCd, row.getCmdtHdrSeq(), row.getRoutSeq());
				 if(tVO.size() == 0){
					 return;
				 }
				 
				 preDBVO        = getRoutPntForAmdtSeq(tVO, priRpScpRtCmdtHdrVO.getAmdtSeq(), false);
				 curDBVO        = getRoutPntForAmdtSeq(tVO, priRpScpRtCmdtHdrVO.getAmdtSeq(), true);
				 
			 }
			 
			 if(rowType.equals("U") || rowType.equals("C")){
				 
				 if( priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && (curDBVO == null || curDBVO.size() == 0) && rowType.equals("U") ){
					 return;
				 }
				 
				 String locs = "";
				 if(strOrgDestTpCd.equals("O")){
					 locs = row.getOrgRoutPntLocDefCd();
				 } else {
					 locs = row.getDestRoutPntLocDefCd();
				 }
				 
				 if(locs != null && !locs.equals("")) {
					 String terms = "";
					 if(strOrgDestTpCd.equals("O")){
						 terms = row.getOrgRcvDeTermNm();
					 } else {
						 terms = row.getDestRcvDeTermNm();
					 }
					 String trspMods = "";
					 if(strOrgDestTpCd.equals("O")){
						 trspMods = row.getOrgPrcTrspModNm();
					 } else {
						 trspMods = row.getDestPrcTrspModNm();
					 }
					 
					 //----------------------------------------------------------
					 //(1) compound the number of LOC, TERM and TRSPMOD
					//----------------------------------------------------------
					 String[] arrLoc = locs.split(";");
					 String[] arrTerms = terms.split(";");
					 String[] arrTrspMods = trspMods.split(";");
					 
					 int arrLocCnt = arrLoc.length;
					 int arrTermCnt = arrTerms.length == 0 ? 1 : arrTerms.length;
					 int arrTrspModCnt = arrTrspMods.length == 0 ? 1 : arrTrspMods.length;
					 int arrTotal = arrLocCnt * arrTermCnt * arrTrspModCnt;
					 StringBuilder sb = new StringBuilder();
					 if(arrTotal > 0){
						 for(int i = 0; i < arrTotal; i++){
							 String tmpVal = "";
							 
							 //ILOC
							 int iTLoc = (arrTermCnt*arrTrspModCnt);
							 int iLoc = i / iTLoc;
							 if(arrLoc != null && !arrLoc[iLoc].equals("")){
								 tmpVal = arrLoc[iLoc];
							 }
							 
							 //TERM
							 int iTTerm = arrTrspModCnt;
							 int iTerm = 0;
							 
							 if(iTTerm > 1 && ((i - iTTerm) >= 0)){
								 int i_temp = i % iTTerm;
								 iTerm = i_temp / iTTerm;
							 } else {
								 if(arrTermCnt == 1){
									 iTerm = i % iTTerm;
								 } else	if(arrTermCnt > 1){
									 iTerm = i % arrTermCnt;
								 }
							 }
							 
							 if(arrTerms != null && arrTerms[iTerm] != null && !arrTerms[iTerm].equals("") && arrTerms[iTerm].length() > 0){
								 tmpVal += ","+arrTerms[iTerm];
							 } else {
								 tmpVal += ",&";
							 }
							 
							 //TRSP
							 int iTrspMod = i % arrTrspModCnt;
							 if(arrTrspMods != null && arrTrspMods[iTrspMod] != null && !arrTrspMods[iTrspMod].equals("") && arrTrspMods[iTrspMod].length() > 0){
								 tmpVal += ","+arrTrspMods[iTrspMod];
							 } else {
								 tmpVal += ",&";
							 }
							 
							 sb.append(tmpVal+"|");
							 
						 } //end for arrLoc
					 }
					 

					 //----------------------------------------------------------
					 //(2) make the location object as many as the number of LOC, TERM and TRSPMOD
					 //----------------------------------------------------------
					 
					 String strLocTermTrsp = sb.toString();
					 String[] arrLocTermTrsp = strLocTermTrsp.split("\\|");
					 
					 if(arrLocTermTrsp != null && arrLocTermTrsp.length > 0) {
					 
						 //int iLocSeq = 0;
						 
						 String txCmdtSeq = "";
						 String txRoutSeq = "";
						 if(rowType.equals("C") && row.getCmdtHdrSeq().equals("")){
							 txCmdtSeq = String.valueOf(nextCmdtHdrSeq);
				         } else {
				        	 txCmdtSeq = row.getCmdtHdrSeq();
				         }
						 if(rowType.equals("C") && row.getRoutSeq().equals("")){
				        	 txRoutSeq = String.valueOf(nextRoutSeq);
				         } else {
				        	 txRoutSeq = row.getRoutSeq();
				         }
				         //iLocSeq = getMaxRoutPntSeq(pntVoList, txCmdtSeq, txRoutSeq);	
						 
						 for(int i = 0; i < arrLocTermTrsp.length; i++) {

							 String tmpLocTermTrsp = arrLocTermTrsp[i];
							 String[] arrTmpLocTermTrsp = tmpLocTermTrsp.split(",");
							 String strLoc = arrTmpLocTermTrsp[0].equals("&") ? "" : arrTmpLocTermTrsp[0];
							 String strRcvDeTermCd = arrTmpLocTermTrsp[1].equals("&") ? "" : arrTmpLocTermTrsp[1];
							 String strPrcTrspModCd = arrTmpLocTermTrsp[2].equals("&") ? "" : arrTmpLocTermTrsp[2];;
							 String strCompareOrg = strLoc+strRcvDeTermCd+strPrcTrspModCd;
							 
							 String locCd = strLoc;
							 String locTpCd = strLoc.length() == 4 ? "G" : "L";
							 
							 if(exsitsCmdtRoutLocTermTrspMod(pntVoList, strCompareOrg)){
								 continue;
							 }
							 
							 //iLocSeq += 1;
			                 
			                 PriRpScpRtRoutPntVO vo = new PriRpScpRtRoutPntVO();
			                 vo.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
			                 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
			                 vo.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());

			    	         vo.setCmdtHdrSeq(txCmdtSeq);
			    	         vo.setRoutSeq(txRoutSeq);
			                 
			                 vo.setOrgDestTpCd(strOrgDestTpCd);
			                 vo.setRoutPntSeq("");
			                 vo.setRoutPntLocTpCd(locTpCd);
			                 vo.setRoutPntLocDefCd(locCd);
			                 
			                 if(strOrgDestTpCd.equals("O")) {
			                	 String strCode = getCodeInCodeBook(termOrgCodeList, strRcvDeTermCd);
			                	 if(!strCode.equals("")){
			                		 vo.setRcvDeTermCd(strCode);
			                	 }
			                 } else {
			                	 String strCode = getCodeInCodeBook(termDestCodeList, strRcvDeTermCd);
			                	 if(!strCode.equals("")){
			                		 vo.setRcvDeTermCd(strCode);
			                	 }
			                 }
			                 
			                 String strPrcTrspModCode = getCodeInCodeBook(trspModCodeList, strPrcTrspModCd);
			                 vo.setPrcTrspModCd(strPrcTrspModCode);

			                 vo.setPrcProgStsCd("I");
			                 vo.setSrcInfoCd("NW");	
			                 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
			                 vo.setCreUsrId(strCreUsrId);
			                 vo.setUpdUsrId(strUpdUsrId);
			                 
			                 if(rowType.equals("C")){
					        	 pntVoList.add(vo);
					         } else {
					        	 curTmpVoList.add(vo);
					         }
						 }
					 }
				 }
			 } else if(rowType.equals("D")){
				 
				 if( priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("D") ){
					 return;
				 }
				 
				 //TYPE(D) AND EXSITS DATA IN DB
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 for(int i = 0; i < curDBVO.size(); i++){
						 curDBVO.get(i).setIbflag(rowType);
						 curDBVO.get(i).setPrcProgStsCd("I");
						 curDBVO.get(i).setSrcInfoCd("AD");
						 curDBVO.get(i).setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
						 curDBVO.get(i).setCreUsrId(strCreUsrId);
						 curDBVO.get(i).setUpdUsrId(strUpdUsrId);
					 }
					 
					 pntVoList.addAll(curDBVO);
				 }
				 
			 }
			 
			 
			 if(!priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("U")){
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 if(curDBVO.size() != curTmpVoList.size()){
						 //------------
						 // current db row count != current(excel) row count
						 //------------
						 
						 //when current db codes(NW,AM) are equal with current data, use current db info
						 //when current data code are not equal with current db code -> already include in current data
						 //(1)
						 for(int i = 0; i < curDBVO.size(); i++){
							 String curDbCd       = curDBVO.get(i).getRoutPntLocDefCd()+curDBVO.get(i).getRcvDeTermCd()+curDBVO.get(i).getPrcTrspModCd();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPagerows = curDBVO.get(i).getPagerows();
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curCd = curTmpVoList.get(x).getRoutPntLocDefCd()+curTmpVoList.get(x).getRcvDeTermCd()+curTmpVoList.get(x).getPrcTrspModCd();
								 if(curDbCd.equals(curCd) && ( isSrcInfoNw(curDbSrc) || curDbSrc.equals("AM") ) && StringUtils.isEmpty(curDbPagerows)){
									 curDBVO.get(i).setPagerows("X");
									 PriRpScpRtRoutPntVO vo = curDBVO.get(i);
									 changeSameLocation(curTmpVoList, vo);
								 }
							 }
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOLocation(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOLocation(curTmpVoList);
						 
						 boolean isAmendedAll1 = isAllAmendedInDataLocation(curDBVO);
						 if(!isAmendedAll1){
							 //when there are some diffent codes
							 
							 //different codes(NW) -> using current db code(with AD)
							 //different codes(AM) -> compare preDB
							 //                       current db code is different with previous db code and it's seq is same and there is no comparing current data
							 //						  	-->using previous db info(with AD)
							 //						  current db code is same with previous db code and it's seq is not same and there are comparing current datas
							 //                         -->using prevois db info
							 for(int i = 0; i < curDBVO.size(); i++){
								 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
								 String curDbCd       = curDBVO.get(i).getRoutPntLocDefCd()+curDBVO.get(i).getRcvDeTermCd()+curDBVO.get(i).getPrcTrspModCd();
								 String curDbRoutPntSeq  = curDBVO.get(i).getRoutPntSeq();
								 String curDbPagerows = curDBVO.get(i).getPagerows();
								 if(StringUtils.isEmpty(curDbPagerows) && isSrcInfoNw(curDbSrc)){
									 curDBVO.get(i).setPagerows("X");
									 PriRpScpRtRoutPntVO vo = curDBVO.get(i);
									 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
									 vo.setPrcProgStsCd("I");
									 vo.setSrcInfoCd("AD");
									 curTmpVoList.add(vo);								 
								 } else if(StringUtils.isEmpty(curDbPagerows) && curDbSrc.equals("AM")){
									 if(preDBVO != null && preDBVO.size() > 0){
										 for(int x = 0; x < preDBVO.size(); x++){
											 String preDbCd       = preDBVO.get(x).getRoutPntLocDefCd()+preDBVO.get(x).getRcvDeTermCd()+preDBVO.get(x).getPrcTrspModCd();
											 String preDbRoutPntSeq  = preDBVO.get(x).getRoutPntSeq();
											 String preDbPagerows = preDBVO.get(x).getPagerows();
											 if( !curDbCd.equals(preDbCd) && curDbRoutPntSeq.equals(preDbRoutPntSeq) && noUseCurCnt == 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 PriRpScpRtRoutPntVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setPrcProgStsCd("I");
												 vo.setSrcInfoCd("AD");
												 changeSameLocation(curTmpVoList, vo);
												 break;
												 
											 } else if( curDbCd.equals(preDbCd) && !curDbRoutPntSeq.equals(preDbRoutPntSeq) && noUseCurCnt != 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 curDBVO.get(i).setPagerows("X");
												 PriRpScpRtRoutPntVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameLocation(curTmpVoList, vo);
												 break;
												 
											 }
										 }
									 }
									 
								 }
							 }
							 
						 } else if(isAmendedAll1 && noUseCurDbCnt != 0){
							 //when diffent codes are all, compare previous db and current data
							 
							 //previous data codes are same with current data code     -> use previous datas
							 //previous data codes are not same with current data code -> use previous datas(AD)
							 List<PriRpScpRtRoutPntVO> tmpCmdt1 =  new ArrayList<PriRpScpRtRoutPntVO>();
							 tmpCmdt1.addAll(curTmpVoList);
							 if(preDBVO != null && preDBVO.size() > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getRoutPntLocDefCd()+preDBVO.get(x).getRcvDeTermCd()+preDBVO.get(x).getPrcTrspModCd();
									 
									 boolean isExists = exsitsCmdtRoutLocTermTrspMod(tmpCmdt1, preDbCd);
									 if(isExists){
										 for(int i = 0; i < tmpCmdt1.size(); i++){
											 String cd     = tmpCmdt1.get(i).getRoutPntLocDefCd()+tmpCmdt1.get(i).getRcvDeTermCd()+tmpCmdt1.get(i).getPrcTrspModCd();
											 
											 if(preDbCd.equals(cd) && tmpCmdt1.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriRpScpRtRoutPntVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameLocation(curTmpVoList, vo);
												 changeSameLocation(tmpCmdt1, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriRpScpRtRoutPntVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 
									 
								 } 
							 }
							 
						 }

						 
					 } else {
						 //------------
						 // current db row count == current(excel) row count
						 //------------
						 
						 //
						 //when current db srcInfoCd is all AM     -> remove current db and compare previous db (2)
						 //when current db srcInfoCd is not all AM -> (1) current db code(NW,AM) equal with current data
						 //													-> using current db info
						 //												  current db code(AD) do not equal with current data
						 //													-> using current db info
						 //                                           (3) current db code(AM) does not exists in current data
						 //(1)
						 boolean isAmendedAll2 = isAllAmendedInDataLocation(curDBVO);
						 
						 List<PriRpScpRtRoutPntVO> tmpCmdt1 =  new ArrayList<PriRpScpRtRoutPntVO>();
						 tmpCmdt1.addAll(curTmpVoList);
						 
						 for(int i = (curDBVO.size() - 1); i >= 0; i--){
							 String curDbCd       = curDBVO.get(i).getRoutPntLocDefCd()+curDBVO.get(i).getRcvDeTermCd()+curDBVO.get(i).getPrcTrspModCd();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPages    = curDBVO.get(i).getPagerows();
							 int    noCntInCur = 0;
							 boolean isExists = exsitsCmdtRoutLocTermTrspMod(tmpCmdt1, curDbCd);
							 if(isExists){
								 for(int x = 0; x < tmpCmdt1.size(); x++){
									 String cd       = tmpCmdt1.get(x).getRoutPntLocDefCd()+tmpCmdt1.get(x).getRcvDeTermCd()+tmpCmdt1.get(x).getPrcTrspModCd();
									 String pages    = tmpCmdt1.get(x).getPagerows();
									 if(!curDbCd.equals(cd) && curDbSrc.equals("AM")){
										 noCntInCur++;
										 break;
									 }

									 if(curDbCd.equals(cd) && StringUtils.isEmpty(pages)){
										 curDBVO.get(i).setPagerows("X");
										 PriRpScpRtRoutPntVO vo = curDBVO.get(i);
										 changeSameLocation(curTmpVoList, vo);
										 changeSameLocation(tmpCmdt1, vo);
										 break;
									 }
								 }
							 } else {
								 
								 for(int x = 0; x < curTmpVoList.size(); x++){
									 String cd       = curTmpVoList.get(x).getRoutPntLocDefCd()+curTmpVoList.get(x).getRcvDeTermCd()+curTmpVoList.get(x).getPrcTrspModCd();
									 if(!curDbCd.equals(cd) && !curDbSrc.equals("AD")){
										 noCntInCur++;
										 break;
									 }
									 
									 if(!curDbCd.equals(cd) && StringUtils.isEmpty(curDbPages)){
										 curDBVO.get(i).setPagerows("X");
										 PriRpScpRtRoutPntVO vo = curDBVO.get(i);
										 curTmpVoList.add(vo);
										 break;
									 }
								 }
							 }
							 
							 if(noCntInCur > 0 && curDbSrc.equals("AM") ){
								 curDBVO.remove(i);
							 }
						 	 
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOLocation(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOLocation(curTmpVoList);
						 
						 //(2)
						 //compare preDB data with cur data
						 //when preDB code equal with cur data        -> use preDB Info
						 //when preDB code do not equal with cur data -> use preDB Info and srcInfoCd(AD)
						 if(isAmendedAll2){
							 if(preDBVO != null && preDBVO.size() > 0 && noUseCurCnt > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getRoutPntLocDefCd()+preDBVO.get(x).getRcvDeTermCd()+preDBVO.get(x).getPrcTrspModCd();
									 
									 boolean isExists = exsitsCmdtRoutLocTermTrspMod(curTmpVoList, preDbCd);
									 if(isExists){
										 for(int i = 0; i < curTmpVoList.size(); i++){
											 String cd = curTmpVoList.get(i).getRoutPntLocDefCd()+curTmpVoList.get(i).getRcvDeTermCd()+curTmpVoList.get(i).getPrcTrspModCd();
											 
											 if(preDbCd.equals(cd) && curTmpVoList.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriRpScpRtRoutPntVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameLocation(curTmpVoList, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriRpScpRtRoutPntVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 
									 
								 } 
							 }
						 }
						 
						 //(3)
						 //no use code in current db code(AM) 1 and no use code in current data is 1
						 //change current db code to current code
						 noUseCurCnt   = getNoUseDataCntForVOLocation(curTmpVoList);
						 if(noUseCurCnt > 0){
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curDbPagerows   = curTmpVoList.get(x).getPagerows();
								 //change curDB to cur
								 //using new(=cur) info and only change to the CmdtHdrSeq and CmdtSeq in curDB 
								 if((curDbPagerows == null || curDbPagerows.equals("")) && ((noUseCurDbCnt >= 1 && noUseCurCnt >= 1) && (noUseCurDbCnt == noUseCurCnt))){
									 if(curDBVO != null && curDBVO.size() > 0){
										 for(int i = 0; i < curDBVO.size(); i++){
											 String curPagerows  = curDBVO.get(i).getPagerows();
											 String curSrcInfoCd = curDBVO.get(i).getSrcInfoCd();
											 if(StringUtils.isEmpty(curPagerows) && isSrcInfoNw(curSrcInfoCd)){
												 curDBVO.get(i).setPagerows("X");
												 curTmpVoList.get(x).setCmdtHdrSeq(curDBVO.get(i).getCmdtHdrSeq());
												 curTmpVoList.get(x).setRoutSeq(curDBVO.get(i).getRoutSeq());
												 curTmpVoList.get(x).setRoutPntSeq(curDBVO.get(i).getRoutPntSeq());
												 curTmpVoList.get(x).setPrcProgStsCd("I");
												 curTmpVoList.get(x).setSrcInfoCd("AM");
												 break;
											 }
										 }
									 }
									 
								 }
							 }
						 }
						 
					 }
					 	 
				 } //end if(curDBVO != null && curDBVO.size() > 0)
			 } // end if(rowType.equals("U"))

			 pntVoList.addAll(curTmpVoList);
			 
		 } catch (DAOException ex) {
			 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         } catch (Exception ex) {
        	 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         }
	 }
	 /**
	  * make PriRpScpRtRoutViaVO with RsltRtListHorizontalExcelVO and add it to List<PriRpScpRtVO> <br>
	  * 
	  * @param String rowType
	  * @param List<PriRpScpRtRoutViaVO> viaVoList : the result object to be created
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @param String strOrgDestTpCd
	  * @param int nextCmdtHdrSeq
	  * @param int nextRoutSeq
	  * @param String strCreUsrId
	  * @param String strUpdUsrId
	  * @exception EventException
	  */
	 private void makeViaLocForCreate(String rowType, List<PriRpScpRtRoutViaVO> viaVoList, RsltRtListHorizontalExcelVO row, PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, 
			                           String strOrgDestTpCd, int nextCmdtHdrSeq, int nextRoutSeq, String strCreUsrId, String strUpdUsrId) throws EventException {

		 try {
			 //CUR LIST
			 List<PriRpScpRtRoutViaVO> curTmpVoList = new ArrayList<PriRpScpRtRoutViaVO>();
			 //get current info data to compare
			 List<PriRpScpRtRoutViaVO> tVO          = new ArrayList<PriRpScpRtRoutViaVO>();
			 //previous AmdtSeq's DB Info
			 List<PriRpScpRtRoutViaVO> preDBVO      = new ArrayList<PriRpScpRtRoutViaVO>();
			 //current AmdtSeq's DB Info
			 List<PriRpScpRtRoutViaVO> curDBVO      = new ArrayList<PriRpScpRtRoutViaVO>();
			 
			 if(rowType.equals("U") || (rowType.equals("D") && !priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") )){
				 //apply only to via(2016.01.29)
				 tVO = dbDao.searchPriRpScpRtRoutViaList(priRpScpRtCmdtHdrVO, strOrgDestTpCd, row.getCmdtHdrSeq(), row.getRoutSeq());
				 if(!rowType.equals("U") && tVO.size() == 0){
					 return; 
				 }
				 
				 if(tVO.size() > 0){
					 preDBVO        = getRoutViaForAmdtSeq(tVO, priRpScpRtCmdtHdrVO.getAmdtSeq(), false);
					 curDBVO        = getRoutViaForAmdtSeq(tVO, priRpScpRtCmdtHdrVO.getAmdtSeq(), true);
				 }
			 }
			 
			 if(rowType.equals("U") || rowType.equals("C")){
				 String viaLocCds = "";
				 if(strOrgDestTpCd.equals("O")){
					 viaLocCds = row.getOrgRoutViaPortDefCd();
				 } else {
					 viaLocCds = row.getDestRoutViaPortDefCd();
				 }
				 
				 if(viaLocCds != null && !viaLocCds.equals("")) {
					 String[] arrLocCd = viaLocCds.split(";");
					 if(arrLocCd.length > 0) {
						 //int iRoutViaSeq = 0;						 
						 String txCmdtSeq = "";
						 String txRoutSeq = "";
						 if(rowType.equals("C") && row.getCmdtHdrSeq().equals("")){
							 txCmdtSeq = String.valueOf(nextCmdtHdrSeq);
				         } else {
				        	 txCmdtSeq = row.getCmdtHdrSeq();
				         }
						 if(rowType.equals("C") && row.getRoutSeq().equals("")){
				        	 txRoutSeq = String.valueOf(nextRoutSeq);
				         } else {
				        	 txRoutSeq = row.getRoutSeq();
				         }
				         //iRoutViaSeq = getMaxRoutViaSeq(viaVoList, txCmdtSeq, txRoutSeq);	 						 
						 for(int i = 0; i < arrLocCd.length; i++) {
							 //iRoutViaSeq+=1;
							 
							 String locCd = arrLocCd[i];
							 String locTpCd = arrLocCd[i].length() == 4 ? "G" : "L";
			                  
							 PriRpScpRtRoutViaVO vo = new PriRpScpRtRoutViaVO();
		                     vo.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
			                 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
			                 vo.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
			    	         
			    	         vo.setCmdtHdrSeq(txCmdtSeq);
			    	         vo.setRoutSeq(txRoutSeq);
			    	         
			                 vo.setOrgDestTpCd(strOrgDestTpCd);
		                     vo.setRoutViaSeq("");
		                     vo.setRoutViaPortTpCd(locTpCd);
		                     vo.setRoutViaPortDefCd(locCd);
		                     vo.setPrcProgStsCd("I");
		                     vo.setSrcInfoCd("NW");
		                     vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
		                     vo.setCreUsrId(strCreUsrId);
		                     vo.setUpdUsrId(strUpdUsrId);
		                  
		                     if(rowType.equals("C")){
		                    	 viaVoList.add(vo);
					         } else {
					        	 curTmpVoList.add(vo);
					         }

						 }
					 }
				 }
			 } else if(rowType.equals("D")){
				 
				 if( priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("D") ){
					 return;
				 }
				 
				 //TYPE(D) AND EXSITS DATA IN DB
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 for(int i = 0; i < curDBVO.size(); i++){
						 curDBVO.get(i).setIbflag(rowType);
						 curDBVO.get(i).setPrcProgStsCd("I");
						 curDBVO.get(i).setSrcInfoCd("AD");
						 curDBVO.get(i).setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
						 curDBVO.get(i).setCreUsrId(strCreUsrId);
						 curDBVO.get(i).setUpdUsrId(strUpdUsrId);
					 }
					 
					 viaVoList.addAll(curDBVO);
				 }
				 
			 }

			 if(!priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("U")){
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 if(curDBVO.size() != curTmpVoList.size()){
						 //------------
						 // current db row count != current(excel) row count
						 //------------
						 
						 //when current db codes(NW,AM) are equal with current data, use current db info
						 //when current data code are not equal with current db code -> already include in current data
						 //(1)
						 for(int i = 0; i < curDBVO.size(); i++){
							 String curDbCd       = curDBVO.get(i).getRoutViaPortDefCd();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPagerows = curDBVO.get(i).getPagerows();
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curCd = curTmpVoList.get(x).getRoutViaPortDefCd();
								 if(curDbCd.equals(curCd) && ( isSrcInfoNw(curDbSrc) || curDbSrc.equals("AM") ) && StringUtils.isEmpty(curDbPagerows)){
									 curDBVO.get(i).setPagerows("X");
									 PriRpScpRtRoutViaVO vo = curDBVO.get(i);
									 changeSameLocationVia(curTmpVoList, vo);
								 }
							 }
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOLocationVia(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOLocationVia(curTmpVoList);
						 
						 boolean isAmendedAll1 = isAllAmendedInDataLocationVia(curDBVO);
						 if(!isAmendedAll1){
							 //when there are some diffent codes
							 
							 //different codes(NW) -> using current db code(with AD)
							 //different codes(AM) -> compare preDB
							 //                       current db code is different with previous db code and it's seq is same and there is no comparing current data
							 //						  	-->using previous db info(with AD)
							 //						  current db code is same with previous db code and it's seq is not same and there are comparing current datas
							 //                         -->using prevois db info
							 for(int i = 0; i < curDBVO.size(); i++){
								 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
								 String curDbCd       = curDBVO.get(i).getRoutViaPortDefCd();
								 String curDbRoutViaSeq  = curDBVO.get(i).getRoutViaSeq();
								 String curDbPagerows = curDBVO.get(i).getPagerows();
								 if(StringUtils.isEmpty(curDbPagerows) && isSrcInfoNw(curDbSrc)){
									 curDBVO.get(i).setPagerows("X");
									 PriRpScpRtRoutViaVO vo = curDBVO.get(i);
									 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
									 vo.setPrcProgStsCd("I");
									 vo.setSrcInfoCd("AD");
									 curTmpVoList.add(vo);								 
								 } else if(StringUtils.isEmpty(curDbPagerows) && curDbSrc.equals("AM")){
									 if(preDBVO != null && preDBVO.size() > 0){
										 for(int x = 0; x < preDBVO.size(); x++){
											 String preDbCd       = preDBVO.get(x).getRoutViaPortDefCd();
											 String preDbRoutViaSeq  = preDBVO.get(x).getRoutViaSeq();
											 String preDbPagerows = preDBVO.get(x).getPagerows();
											 if( !curDbCd.equals(preDbCd) && curDbRoutViaSeq.equals(preDbRoutViaSeq) && noUseCurCnt == 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 PriRpScpRtRoutViaVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setPrcProgStsCd("I");
												 vo.setSrcInfoCd("AD");
												 changeSameLocationVia(curTmpVoList, vo);
												 break;
												 
											 } else if( curDbCd.equals(preDbCd) && !curDbRoutViaSeq.equals(preDbRoutViaSeq) && noUseCurCnt != 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 curDBVO.get(i).setPagerows("X");
												 PriRpScpRtRoutViaVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameLocationVia(curTmpVoList, vo);
												 break;
												 
											 }
										 }
									 }
									 
								 }
							 }
							 
						 } else if(isAmendedAll1 && noUseCurDbCnt != 0){
							 //when diffent codes are all, compare previous db and current data
							 
							 //previous data codes are same with current data code     -> use previous datas
							 //previous data codes are not same with current data code -> use previous datas(AD)
							 List<PriRpScpRtRoutViaVO> tmpCmdt1 =  new ArrayList<PriRpScpRtRoutViaVO>();
							 tmpCmdt1.addAll(curTmpVoList);
							 if(preDBVO != null && preDBVO.size() > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getRoutViaPortDefCd();
									 
									 boolean isExists = existsLocationVia(tmpCmdt1, preDbCd);
									 if(isExists){
										 for(int i = 0; i < tmpCmdt1.size(); i++){
											 String cd       = tmpCmdt1.get(i).getRoutViaPortDefCd();
											 if(preDbCd.equals(cd) && tmpCmdt1.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriRpScpRtRoutViaVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameLocationVia(curTmpVoList, vo);
												 changeSameLocationVia(tmpCmdt1, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriRpScpRtRoutViaVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 
									 
									 
								 } 
							 }
							 
						 }

						 
					 } else {
						 //------------
						 // current db row count == current(excel) row count
						 //------------
						 
						 //
						 //when current db srcInfoCd is all AM     -> remove current db and compare previous db (2)
						 //when current db srcInfoCd is not all AM -> (1) current db code(NW,AM) equal with current data
						 //													-> using current db info
						 //												  current db code(AD) do not equal with current data
						 //													-> using current db info
						 //                                           (3) current db code(AM) does not exists in current data
						 //(1)
						 
						 boolean isAmendedAll2 = isAllAmendedInDataLocationVia(curDBVO);
						 
						 List<PriRpScpRtRoutViaVO> tmpCmdt1 =  new ArrayList<PriRpScpRtRoutViaVO>();
						 tmpCmdt1.addAll(curTmpVoList);
						 
						 for(int i = (curDBVO.size() - 1); i >= 0; i--){
							 String curDbCd       = curDBVO.get(i).getRoutViaPortDefCd();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPages    = curDBVO.get(i).getPagerows();
							 int    noCntInCur = 0;
							 
							 boolean isExists = existsLocationVia(tmpCmdt1, curDbCd);
							 if(isExists){
								 for(int x = 0; x < tmpCmdt1.size(); x++){
									 String cd       = tmpCmdt1.get(x).getRoutViaPortDefCd();
									 String pages    = tmpCmdt1.get(x).getPagerows();
									 if(!curDbCd.equals(cd) && curDbSrc.equals("AM")){
										 noCntInCur++;
										 break;
									 }

									 if(curDbCd.equals(cd) && StringUtils.isEmpty(pages)){
										 curDBVO.get(i).setPagerows("X");
										 PriRpScpRtRoutViaVO vo = curDBVO.get(i);
										 changeSameLocationVia(curTmpVoList, vo);
										 changeSameLocationVia(tmpCmdt1, vo);
										 break;
									 }
								 }
							 } else {
								 
								 for(int x = 0; x < curTmpVoList.size(); x++){
									 String cd       = curTmpVoList.get(x).getRoutViaPortDefCd();
									 if(!curDbCd.equals(cd) && !curDbSrc.equals("AD")){
										 noCntInCur++;
										 break;
									 }
									 
									 if(!curDbCd.equals(cd) && StringUtils.isEmpty(curDbPages)){
										 curDBVO.get(i).setPagerows("X");
										 PriRpScpRtRoutViaVO vo = curDBVO.get(i);
										 curTmpVoList.add(vo);
										 break;
									 }
								 }
							 }
							 
							 if(noCntInCur > 0 && curDbSrc.equals("AM") ){
								 curDBVO.remove(i);
							 }
						 	 
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOLocationVia(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOLocationVia(curTmpVoList);
						 
						 //(2)
						 //compare preDB data with cur data
						 //when preDB code equal with cur data        -> use preDB Info
						 //when preDB code do not equal with cur data -> use preDB Info and srcInfoCd(AD)
						 if(isAmendedAll2){
							 if(preDBVO != null && preDBVO.size() > 0 && noUseCurCnt > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getRoutViaPortDefCd();
									 
									 boolean isExists = existsLocationVia(curTmpVoList, preDbCd);
									 if(isExists){
										 for(int i = 0; i < curTmpVoList.size(); i++){
											 String cd       = curTmpVoList.get(i).getRoutViaPortDefCd();
											 if(preDbCd.equals(cd) && curTmpVoList.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriRpScpRtRoutViaVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameLocationVia(curTmpVoList, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriRpScpRtRoutViaVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 
									 
								 } 
							 }
						 }
						 
						 //(3)
						 //no use code in current db code(AM) 1 and no use code in current data is 1
						 //change current db code to current code
						 noUseCurCnt   = getNoUseDataCntForVOLocationVia(curTmpVoList);
						 if(noUseCurCnt > 0){
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curDbPagerows   = curTmpVoList.get(x).getPagerows();
								 //change curDB to cur
								 //using new(=cur) info and only change to the CmdtHdrSeq and CmdtSeq in curDB 
								 if((curDbPagerows == null || curDbPagerows.equals("")) && ((noUseCurDbCnt >= 1 && noUseCurCnt >= 1) && (noUseCurDbCnt == noUseCurCnt))){
									 if(curDBVO != null && curDBVO.size() > 0){
										 for(int i = 0; i < curDBVO.size(); i++){
											 String curPagerows  = curDBVO.get(i).getPagerows();
											 String curSrcInfoCd = curDBVO.get(i).getSrcInfoCd();
											 if(StringUtils.isEmpty(curPagerows) && isSrcInfoNw(curSrcInfoCd)){
												 curDBVO.get(i).setPagerows("X");
												 curTmpVoList.get(x).setCmdtHdrSeq(curDBVO.get(i).getCmdtHdrSeq());
												 curTmpVoList.get(x).setRoutSeq(curDBVO.get(i).getRoutSeq());
												 curTmpVoList.get(x).setRoutViaSeq(curDBVO.get(i).getRoutViaSeq());
												 curTmpVoList.get(x).setPrcProgStsCd("I");
												 curTmpVoList.get(x).setSrcInfoCd("AM");
												 break;
											 }
										 }
									 }
									 
								 }
							 }
						 }
						 
					 }

				 } //end if(curDBVO != null && curDBVO.size() > 0)
			 } // end if(rowType.equals("U"))

			 viaVoList.addAll(curTmpVoList);

		 } catch (DAOException ex) {
			 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         } catch (Exception ex) {
        	 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         }
	 }
	 /**
	  * make PriRpScpRtVO with RsltRtListHorizontalExcelVO and add it to List<PriRpScpRtVO> <br>
	  * 
	  * @param String rowType
	  * @param List<PriRpScpRtVO> rtVoList : the result object to be created
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @param int nextCmdtHdrSeq
	  * @param int nextRoutSeq
	  * @param String strCreUsrId
	  * @param String strUpdUsrId
	  * @exception EventException
	  */
	 private void makeRtForCreate(String rowType, List<PriRpScpRtVO> rtVoList, RsltRtListHorizontalExcelVO row, PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, 
			 int nextCmdtHdrSeq, int nextRoutSeq, String strCreUsrId, String strUpdUsrId) throws EventException {

		 try {
			 //CUR LIST
			 List<PriRpScpRtVO> curTmpVoList   = new ArrayList<PriRpScpRtVO>();
			 //get current info data to compare
			 List<PriRpScpRtVO> tVO            = new ArrayList<PriRpScpRtVO>();
			 //previous AmdtSeq's DB Info
			 List<PriRpScpRtVO> preDBVO        = new ArrayList<PriRpScpRtVO>();
			 //current AmdtSeq's DB Info
			 List<PriRpScpRtVO> curDBVO        = new ArrayList<PriRpScpRtVO>();
			 
			 if(rowType.equals("U") || (rowType.equals("D") && !priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") )){				 
				 tVO = dbDao.searchPriRpScpRtList(priRpScpRtCmdtHdrVO, row.getCmdtHdrSeq(), row.getRoutSeq(), row.getPrcCgoTpCd());
				 if(tVO.size() == 0){
					 return;
				 }
				 preDBVO        = getRtForAmdtSeq(tVO, priRpScpRtCmdtHdrVO.getAmdtSeq(), false);
				 curDBVO        = getRtForAmdtSeq(tVO, priRpScpRtCmdtHdrVO.getAmdtSeq(), true);
			 }

			 if(rowType.equals("U") || rowType.equals("C")){
				 
				 if( priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && (curDBVO == null || curDBVO.size() == 0) && rowType.equals("U") ){
					 return;
				 }
				 
				 String tmpPrcCgoTpCd = row.getPrcCgoTpCd();
				 String rates = row.getRate20()+";"+row.getRate40()+";"+row.getRate40hc()+";"+row.getRate45()+";";
				 
				 if(rates != null && !rates.equals("")) {
					 String[] arrRate = rates.split(";");
					 
					 if(arrRate.length > 0) {
						 String txCmdtSeq = "";
						 String txRoutSeq = "";
						 if(rowType.equals("C") && row.getCmdtHdrSeq().equals("")){
							 txCmdtSeq = String.valueOf(nextCmdtHdrSeq);
				         } else {
				        	 txCmdtSeq = row.getCmdtHdrSeq();
				         }
						 if(rowType.equals("C") && row.getRoutSeq().equals("")){
				        	 txRoutSeq = String.valueOf(nextRoutSeq);
				         } else {
				        	 txRoutSeq = row.getRoutSeq();
				         } 
								 
						 for(int i = 0; i < arrRate.length; i++) {
							 String strRatUtCd = "";
							 if(arrRate[i] != null && !arrRate[i].equals("")) {
								 String strPrefix = row.getPrefixNm();
								 if(i == 0){
									 strRatUtCd = strPrefix+"2";
								 } else if(i == 1){
									 strRatUtCd = strPrefix+"4";
								 } else if(i == 2){
									 strRatUtCd = strPrefix+"5";
								 } else if(i == 3){
									 strRatUtCd = strPrefix+"7";
								 }
							 } 
							 
							 if(arrRate[i] == null || arrRate[i].equals("")) {
								 continue;
							 }

							 PriRpScpRtVO vo = new PriRpScpRtVO();
							 vo.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
				             vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
				             vo.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
				             
				             vo.setCmdtHdrSeq(txCmdtSeq);
				             vo.setRoutSeq(txRoutSeq);

			                 vo.setRtSeq("");
			                 vo.setRatUtCd(strRatUtCd);
			                 vo.setPrcCgoTpCd(tmpPrcCgoTpCd);
			                 vo.setCurrCd("USD");
			                 vo.setPropFrtRtAmt(arrRate[i]);
			                 vo.setGriApplTpCd("N");
			                 vo.setGriApplAmt("0");
			                 vo.setPrcProgStsCd("I");
			                 vo.setSrcInfoCd("NW");
			                 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
			                 vo.setCreUsrId(strCreUsrId);
			                 vo.setUpdUsrId(strUpdUsrId);
			                  
			                 if(rowType.equals("C")){
					        	 rtVoList.add(vo);
					         } else {
					        	 curTmpVoList.add(vo);
					         }
							 
						 }
					 }
				 }
			 } else if(rowType.equals("D")){
				 
				 if( priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("D") ){
					 return;
				 }
				 
				 //TYPE(D) AND EXSITS DATA IN DB
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 for(int i = 0; i < curDBVO.size(); i++){
						 curDBVO.get(i).setIbflag(rowType);
						 curDBVO.get(i).setPrcProgStsCd("I");
						 curDBVO.get(i).setSrcInfoCd("AD");
						 curDBVO.get(i).setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
						 curDBVO.get(i).setCreUsrId(strCreUsrId);
						 curDBVO.get(i).setUpdUsrId(strUpdUsrId);
					 }
					 
					 rtVoList.addAll(curDBVO);
				 }
				 
			 }
			 
			 if(!priRpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("U")){
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 if(curDBVO.size() != curTmpVoList.size()){
						 //------------
						 // current db row count != current(excel) row count
						 //------------
						 
						 //when current db codes(NW,AM) are equal with current data, use current db info
						 //when current data code are not equal with current db code -> already include in current data
						 //(1)
						 for(int i = 0; i < curDBVO.size(); i++){
							 String curDbCd       = curDBVO.get(i).getRatUtCd()+curDBVO.get(i).getPrcCgoTpCd()+curDBVO.get(i).getPropFrtRtAmt();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPagerows = curDBVO.get(i).getPagerows();
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curCd = curTmpVoList.get(x).getRatUtCd()+curTmpVoList.get(x).getPrcCgoTpCd()+curTmpVoList.get(x).getPropFrtRtAmt();
								 if(curDbCd.equals(curCd) && ( isSrcInfoNw(curDbSrc) || curDbSrc.equals("AM") ) && StringUtils.isEmpty(curDbPagerows)){
									 curDBVO.get(i).setPagerows("X");
									 PriRpScpRtVO vo = curDBVO.get(i);
									 changeSameRate(curTmpVoList, vo);
								 }
							 }
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVORate(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVORate(curTmpVoList);
						 
						 boolean isAmendedAll1 = isAllAmendedInDataRate(curDBVO);
						 if(!isAmendedAll1){
							 //when there are some diffent codes
							 
							 //different codes(NW) -> using current db code(with AD)
							 //different codes(AM) -> compare preDB
							 //                       current db code is different with previous db code and it's seq is same and there is no comparing current data
							 //						  	-->using previous db info(with AD)
							 //						  current db code is same with previous db code and it's seq is not same and there are comparing current datas
							 //                         -->using prevois db info
							 for(int i = 0; i < curDBVO.size(); i++){
								 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
								 String curDbCd       = curDBVO.get(i).getRatUtCd()+curDBVO.get(i).getPrcCgoTpCd()+curDBVO.get(i).getPropFrtRtAmt();
								 String curDbRtSeq  = curDBVO.get(i).getRtSeq();
								 String curDbPagerows = curDBVO.get(i).getPagerows();
								 if(StringUtils.isEmpty(curDbPagerows) && isSrcInfoNw(curDbSrc)){
									 curDBVO.get(i).setPagerows("X");
									 PriRpScpRtVO vo = curDBVO.get(i);
									 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
									 vo.setPrcProgStsCd("I");
									 vo.setSrcInfoCd("AD");
									 curTmpVoList.add(vo);								 
								 } else if(StringUtils.isEmpty(curDbPagerows) && curDbSrc.equals("AM")){
									 if(preDBVO != null && preDBVO.size() > 0){
										 for(int x = 0; x < preDBVO.size(); x++){
											 String preDbCd       = preDBVO.get(x).getRatUtCd()+preDBVO.get(x).getPrcCgoTpCd()+preDBVO.get(x).getPropFrtRtAmt();
											 String preDbRtSeq    = preDBVO.get(x).getRtSeq();
											 String preDbPagerows = preDBVO.get(x).getPagerows();
											 if( !curDbCd.equals(preDbCd) && curDbRtSeq.equals(preDbRtSeq) && noUseCurCnt == 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 PriRpScpRtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setPrcProgStsCd("I");
												 vo.setSrcInfoCd("AD");
												 changeSameRate(curTmpVoList, vo);
												 break;
												 
											 } else if( curDbCd.equals(preDbCd) && !curDbRtSeq.equals(preDbRtSeq) && noUseCurCnt != 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 curDBVO.get(i).setPagerows("X");
												 PriRpScpRtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameRate(curTmpVoList, vo);
												 break;
												 
											 }
										 }
									 }
									 
								 }
							 }
							 
						 } else if(isAmendedAll1 && noUseCurDbCnt != 0){
							 //when diffent codes are all, compare previous db and current data
							 
							 //previous data codes are same with current data code     -> use previous datas
							 //previous data codes are not same with current data code -> use previous datas(AD)
							 List<PriRpScpRtVO> tmpCmdt1 =  new ArrayList<PriRpScpRtVO>();
							 tmpCmdt1.addAll(curTmpVoList);
							 if(preDBVO != null && preDBVO.size() > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getRatUtCd()+preDBVO.get(x).getPrcCgoTpCd()+preDBVO.get(x).getPropFrtRtAmt();
									 
									 
									 boolean isExists = existsRate(tmpCmdt1, preDbCd);
									 if(isExists){
										 for(int i = 0; i < tmpCmdt1.size(); i++){
											 String cd = tmpCmdt1.get(i).getRatUtCd()+tmpCmdt1.get(i).getPrcCgoTpCd()+tmpCmdt1.get(i).getPropFrtRtAmt();
											 
											 if(preDbCd.equals(cd) && tmpCmdt1.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriRpScpRtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameRate(curTmpVoList, vo);
												 changeSameRate(tmpCmdt1, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriRpScpRtVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 
								 } 
							 }
							 
						 }

						 
					 } else {
						 //------------
						 // current db row count == current(excel) row count
						 //------------
						 
						 //
						 //when current db srcInfoCd is all AM     -> remove current db and compare previous db (2)
						 //when current db srcInfoCd is not all AM -> (1) current db code(NW,AM) equal with current data
						 //													-> using current db info
						 //												  current db code(AD) do not equal with current data
						 //													-> using current db info
						 //                                           (3) current db code(AM) does not exists in current data
						 //(1)
						 
						 boolean isAmendedAll2 = isAllAmendedInDataRate(curDBVO);
						 
						 List<PriRpScpRtVO> tmpCmdt1 =  new ArrayList<PriRpScpRtVO>();
						 tmpCmdt1.addAll(curTmpVoList);
						 
						 for(int i = (curDBVO.size() - 1); i >= 0; i--){
							 String curDbCd       = curDBVO.get(i).getRatUtCd()+curDBVO.get(i).getPrcCgoTpCd()+curDBVO.get(i).getPropFrtRtAmt();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPages    = curDBVO.get(i).getPagerows();
							 int    noCntInCur = 0;
							 boolean isExists = existsRate(tmpCmdt1, curDbCd);
							 if(isExists){
								 for(int x = 0; x < tmpCmdt1.size(); x++){
									 String cd       = tmpCmdt1.get(x).getRatUtCd()+tmpCmdt1.get(x).getPrcCgoTpCd()+tmpCmdt1.get(x).getPropFrtRtAmt();
									 String pages    = tmpCmdt1.get(x).getPagerows();
									 if(!curDbCd.equals(cd) && curDbSrc.equals("AM")){
										 noCntInCur++;
										 break;
									 }

									 if(curDbCd.equals(cd) && StringUtils.isEmpty(pages)){
										 curDBVO.get(i).setPagerows("X");
										 PriRpScpRtVO vo = curDBVO.get(i);
										 changeSameRate(curTmpVoList, vo);
										 changeSameRate(tmpCmdt1, vo);
										 break;
									 }
								 }
							 } else {
								 
								 for(int x = 0; x < curTmpVoList.size(); x++){
									 String cd       = curTmpVoList.get(x).getRatUtCd()+curTmpVoList.get(x).getPrcCgoTpCd()+curTmpVoList.get(x).getPropFrtRtAmt();
									 if(!curDbCd.equals(cd) && !curDbSrc.equals("AD")){
										 noCntInCur++;
										 break;
									 }
									 
									 if(!curDbCd.equals(cd) && StringUtils.isEmpty(curDbPages)){
										 curDBVO.get(i).setPagerows("X");
										 PriRpScpRtVO vo = curDBVO.get(i);
										 curTmpVoList.add(vo);
										 break;
									 }
								 }
							 }
							 
							 if(noCntInCur > 0 && curDbSrc.equals("AM") ){
								 curDBVO.remove(i);
							 }
						 	 
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVORate(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVORate(curTmpVoList);
						 
						 //(2)
						 //compare preDB data with cur data
						 //when preDB code equal with cur data        -> use preDB Info
						 //when preDB code do not equal with cur data -> use preDB Info and srcInfoCd(AD)
						 if(isAmendedAll2){
							 if(preDBVO != null && preDBVO.size() > 0 && noUseCurCnt > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getRatUtCd()+preDBVO.get(x).getPrcCgoTpCd()+preDBVO.get(x).getPropFrtRtAmt();
									 
									 boolean isExists = existsRate(curTmpVoList, preDbCd);
									 if(isExists){
										 for(int i = 0; i < curTmpVoList.size(); i++){
											 String cd = curTmpVoList.get(i).getRatUtCd()+curTmpVoList.get(i).getPrcCgoTpCd()+curTmpVoList.get(i).getPropFrtRtAmt();
											 
											 if(preDbCd.equals(cd) && curTmpVoList.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriRpScpRtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameRate(curTmpVoList, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriRpScpRtVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 									 
								 } 
							 }
						 }
						 
						 //(3)
						 //no use code in current db code(AM) 1 and no use code in current data is 1
						 //change current db code to current code
						 noUseCurCnt   = getNoUseDataCntForVORate(curTmpVoList);
						 if(noUseCurCnt > 0){
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curDbPagerows   = curTmpVoList.get(x).getPagerows();
								 //change curDB to cur
								 //using new(=cur) info and only change to the CmdtHdrSeq and CmdtSeq in curDB 
								 if((curDbPagerows == null || curDbPagerows.equals("")) && ((noUseCurDbCnt >= 1 && noUseCurCnt >= 1) && (noUseCurDbCnt == noUseCurCnt))){
									 if(curDBVO != null && curDBVO.size() > 0){
										 for(int i = 0; i < curDBVO.size(); i++){
											 String curPagerows  = curDBVO.get(i).getPagerows();
											 String curSrcInfoCd = curDBVO.get(i).getSrcInfoCd();
											 if(StringUtils.isEmpty(curPagerows) && isSrcInfoNw(curSrcInfoCd)){
												 curDBVO.get(i).setPagerows("X");
												 curTmpVoList.get(x).setCmdtHdrSeq(curDBVO.get(i).getCmdtHdrSeq());
												 curTmpVoList.get(x).setRoutSeq(curDBVO.get(i).getRoutSeq());
												 curTmpVoList.get(x).setRtSeq(curDBVO.get(i).getRtSeq());
												 curTmpVoList.get(x).setPrcProgStsCd("I");
												 curTmpVoList.get(x).setSrcInfoCd("AM");
												 break;
											 }
										 }
									 }
									 
								 }
							 }
						 }
					 }
				 } //end if(curDBVO != null && curDBVO.size() > 0)
			 } // end if(rowType.equals("U"))

			 rtVoList.addAll(curTmpVoList); 
			 
		 } catch (DAOException ex) {
			 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         } catch (Exception ex) {
        	 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         }
	 }	
	 
	 /**
	  * return the code of the parameter code name(strOrgVal) in code book list<br>
	  * 
	  * @param ArrayList<CodeInfo> codeList
	  * @param String strOrgVal
	  * @return String
	  */
	 private String getCodeInCodeBook(ArrayList<CodeInfo> codeList, String strOrgVal){
		 String result = "";
		 
		 String strOrg = strOrgVal.toLowerCase().replaceAll("\\s", "");//replace blank
		 for(int i = 0; i < codeList.size(); i++){
			 String strTarget = codeList.get(i).getName().toLowerCase().replaceAll("\\s", "");
			 if(strOrg.equals(strTarget)){
				 result = codeList.get(i).getCode();
				 break;
			 }
		 }
		 
		 return result;
	 }
	 /**
	  * return the same data with the parameter amdtSeq when isEqual is true<br>
	  * return the no same data with the parameter amdtSeq when isEqual is false<br>
	  * 
	  * @param List<PriRpScpRtCmdtVO> tmpVO
	  * @param String amdtSeq
	  * @param boolean isEqual
	  * @return List<PriRpScpRtCmdtVO>
	  */
	 private List<PriRpScpRtCmdtVO> getCmdtInfoForAmdtSeq(List<PriRpScpRtCmdtVO> tmpVO, String amdtSeq, boolean isEqual){
		 
		 List<PriRpScpRtCmdtVO> vo = new ArrayList<PriRpScpRtCmdtVO>(); 
		 if(tmpVO != null && tmpVO.size() > 0){
			 for(int i = 0; i < tmpVO.size(); i++){
				 String strAmdtSeq = tmpVO.get(i).getAmdtSeq();
				 if(isEqual){
					 if(strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 } else {
					 if(!strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 }
			 }
			 
		 }
		 
		 return vo;
	 }
	 /**
	  * return the same data with the parameter amdtSeq when isEqual is true<br>
	  * return the no same data with the parameter amdtSeq when isEqual is false<br>
	  * 
	  * @param List<PriRpScpRtActCustVO> tmpVO
	  * @param String amdtSeq
	  * @param boolean isEqual
	  * @return List<PriRpScpRtActCustVO>
	  */
	 private List<PriRpScpRtActCustVO> getCustForAmdtSeq(List<PriRpScpRtActCustVO> tmpVO, String amdtSeq, boolean isEqual){
		 
		 List<PriRpScpRtActCustVO> vo = new ArrayList<PriRpScpRtActCustVO>(); 
		 if(tmpVO != null && tmpVO.size() > 0){
			 for(int i = 0; i < tmpVO.size(); i++){
				 String strAmdtSeq = tmpVO.get(i).getAmdtSeq();
				 if(isEqual){
					 if(strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 } else {
					 if(!strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 }
			 }
			 
		 }
		 
		 return vo;
	 }
	 /**
	  * return the same data with the parameter amdtSeq when isEqual is true<br>
	  * return the no same data with the parameter amdtSeq when isEqual is false<br>
	  * 
	  * @param List<PriRpScpRtRoutPntVO> tmpVO
	  * @param String amdtSeq
	  * @param boolean isEqual
	  * @return List<PriRpScpRtRoutPntVO>
	  */
	 private List<PriRpScpRtRoutPntVO> getRoutPntForAmdtSeq(List<PriRpScpRtRoutPntVO> tmpVO, String amdtSeq, boolean isEqual){
		 
		 List<PriRpScpRtRoutPntVO> vo = new ArrayList<PriRpScpRtRoutPntVO>(); 
		 if(tmpVO != null && tmpVO.size() > 0){
			 for(int i = 0; i < tmpVO.size(); i++){
				 String strAmdtSeq = tmpVO.get(i).getAmdtSeq();
				 if(isEqual){
					 if(strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 } else {
					 if(!strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 }
			 }
			 
		 }
		 
		 return vo;
	 }
	 /**
	  * return the same data with the parameter amdtSeq when isEqual is true<br>
	  * return the no same data with the parameter amdtSeq when isEqual is false<br>
	  * 
	  * @param List<PriRpScpRtRoutViaVO> tmpVO
	  * @param String amdtSeq
	  * @param boolean isEqual
	  * @return List<PriRpScpRtRoutViaVO>
	  */
	 private List<PriRpScpRtRoutViaVO> getRoutViaForAmdtSeq(List<PriRpScpRtRoutViaVO> tmpVO, String amdtSeq, boolean isEqual){
		 
		 List<PriRpScpRtRoutViaVO> vo = new ArrayList<PriRpScpRtRoutViaVO>(); 
		 if(tmpVO != null && tmpVO.size() > 0){
			 for(int i = 0; i < tmpVO.size(); i++){
				 String strAmdtSeq = tmpVO.get(i).getAmdtSeq();
				 if(isEqual){
					 if(strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 } else {
					 if(!strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 }
			 }
			 
		 }
		 
		 return vo;
	 }

	 
	 /**
	  * return the same data with the parameter amdtSeq when isEqual is true<br>
	  * return the no same data with the parameter amdtSeq when isEqual is false<br>
	  * 
	  * @param List<PriRpScpRtVO> tmpVO
	  * @param String amdtSeq
	  * @param boolean isEqual
	  * @return List<PriRpScpRtVO>
	  */
	 private List<PriRpScpRtVO> getRtForAmdtSeq(List<PriRpScpRtVO> tmpVO, String amdtSeq, boolean isEqual){
		 
		 List<PriRpScpRtVO> vo = new ArrayList<PriRpScpRtVO>(); 
		 if(tmpVO != null && tmpVO.size() > 0){
			 for(int i = 0; i < tmpVO.size(); i++){
				 String strAmdtSeq = tmpVO.get(i).getAmdtSeq();
				 if(isEqual){
					 if(strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 } else {
					 if(!strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 }
			 }
			 
		 }
		 
		 return vo;
	 }

	 
	 /**
	  * count the no using data<br>
	  * (mark X in the compared data already) <br>
	  * 
	  * @param List<PriRpScpRtCmdtVO> vo
	  * @return int
	  */
	 private int getNoUseDataCntForVOCmdt(List<PriRpScpRtCmdtVO> vo) {
		 int result = 0;
		 if(vo.size() > 0){
			 for(int i = 0; i < vo.size(); i++){
				 String flgCnt = vo.get(i).getPagerows();

				 if(StringUtils.isEmpty(flgCnt)){
					 result++;
				 }
			 }
		 }
		 return result;
	 }
	 
	 /**
	  * count the no using data<br>
	  * (mark X in the compared data already) <br>
	  * 
	  * @param List<PriRpScpRtActCustVO> vo
	  * @return int
	  */
	 private int getNoUseDataCntForVOCust(List<PriRpScpRtActCustVO> vo) {
		 int result = 0;
		 if(vo.size() > 0){
			 for(int i = 0; i < vo.size(); i++){
				 String flgCnt = vo.get(i).getPagerows();

				 if(StringUtils.isEmpty(flgCnt)){
					 result++;
				 }
			 }
		 }
		 return result;
	 }
	 
	 /**
	  * count the no using data<br>
	  * (mark X in the compared data already) <br>
	  * 
	  * @param List<PriRpScpRtRoutPntVO> vo
	  * @return int
	  */
	 private int getNoUseDataCntForVOLocation(List<PriRpScpRtRoutPntVO> vo) {
		 int result = 0;
		 if(vo.size() > 0){
			 for(int i = 0; i < vo.size(); i++){
				 String flgCnt = vo.get(i).getPagerows();

				 if(StringUtils.isEmpty(flgCnt)){
					 result++;
				 }
			 }
		 }
		 return result;
	 }
	 
	 /**
	  * count the no using data<br>
	  * (mark X in the compared data already) <br>
	  * 
	  * @param List<PriRpScpRtRoutViaVO> vo
	  * @return int
	  */
	 private int getNoUseDataCntForVOLocationVia(List<PriRpScpRtRoutViaVO> vo) {
		 int result = 0;
		 if(vo.size() > 0){
			 for(int i = 0; i < vo.size(); i++){
				 String flgCnt = vo.get(i).getPagerows();

				 if(StringUtils.isEmpty(flgCnt)){
					 result++;
				 }
			 }
		 }
		 return result;
	 }
	 
	 /**
	  * count the no using data<br>
	  * (mark X in the compared data already) <br>
	  * 
	  * @param List<PriRpScpRtVO> vo
	  * @return int
	  */
	 private int getNoUseDataCntForVORate(List<PriRpScpRtVO> vo) {
		 int result = 0;
		 if(vo.size() > 0){
			 for(int i = 0; i < vo.size(); i++){
				 String flgCnt = vo.get(i).getPagerows();

				 if(StringUtils.isEmpty(flgCnt)){
					 result++;
				 }
			 }
		 }
		 return result;
	 }
	 
	 
	/**
	 * Retrieving BackEndJob's status value<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String key) throws EventException {
        try {
        	return dbDao.comBakEndJbVOs(key);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
	
	
	/****************************************************************************************/
	/* ESM_PRI_2060  BackEndJob End       */
	/****************************************************************************************/
	
	//########### ESM_PRI_2022 2015.05.19 ADD START ############
	
		/**
		 * Retrieving Rate History - Commodity Group<br>
		 * 2016.05.19 ADD(using ESM_PRI_2022)
		 * @param PriRfaNoteConvCommVO priRfaNoteConvCommVO
		 * @return RsltRtCmdtListVO
		 * @exception EventException
		 */
		public RsltRtCmdtListVO searchRateCommodityConversionHistoryList(PriRfaNoteConvCommVO priRfaNoteConvCommVO) throws EventException {
			RsltRtCmdtListVO rVo = new RsltRtCmdtListVO();

			try {
				rVo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderForCnoteList(priRfaNoteConvCommVO));
				rVo.setRsltRtCnoteListVOS(dbDao.searchRateCommodityCnoteList(priRfaNoteConvCommVO));
				int rowCnt = rVo.getRsltRtCnoteListVOS().size();
				if(rowCnt > 0){
					String strNoteConvMapgId = "";
					if(rowCnt == 1){
						strNoteConvMapgId = rVo.getRsltRtCnoteListVOS().get(0).getNoteConvMapgId();
					} else if(rowCnt == 2){
						strNoteConvMapgId = rVo.getRsltRtCnoteListVOS().get(1).getNoteConvMapgId();
					}
					priRfaNoteConvCommVO.setNoteConvMapgId(strNoteConvMapgId);
				} else {
					priRfaNoteConvCommVO.setNoteConvMapgId("X");
				}
				rVo.setRsltCnoteNoteConvListVOS(dbDao.searchRateCommodityNoteConvList(priRfaNoteConvCommVO));
				
				return rVo;
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	        } catch (Exception ex) {
	            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
			}
		}
		
		/**
		 * Retrieving Rate History - Commodity Cnote and Conversion<br>
		 * 2016.05.19 ADD(using ESM_PRI_2022)
		 * @param PriRfaNoteConvCommVO priRfaNoteConvCommVO
		 * @return RsltRtCmdtListVO
		 * @exception EventException
		 */
		public RsltRtCmdtListVO searchRateCommodityForCnoteConvList(PriRfaNoteConvCommVO priRfaNoteConvCommVO) throws EventException {
			RsltRtCmdtListVO rVo = new RsltRtCmdtListVO();

			try {
				rVo.setRsltRtCnoteListVOS(dbDao.searchRateCommodityCnoteList(priRfaNoteConvCommVO));
				int rowCnt = rVo.getRsltRtCnoteListVOS().size();
				if(rowCnt > 0){
					String strNoteConvMapgId = "";
					if(rowCnt == 1){
						strNoteConvMapgId = rVo.getRsltRtCnoteListVOS().get(0).getNoteConvMapgId();
					} else if(rowCnt == 2){
						strNoteConvMapgId = rVo.getRsltRtCnoteListVOS().get(1).getNoteConvMapgId();
					}
					priRfaNoteConvCommVO.setNoteConvMapgId(strNoteConvMapgId);
				} else {
					priRfaNoteConvCommVO.setNoteConvMapgId("X");
				}
				rVo.setRsltCnoteNoteConvListVOS(dbDao.searchRateCommodityNoteConvList(priRfaNoteConvCommVO));
				
				return rVo;
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	        } catch (Exception ex) {
	            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
			}
		}
		
		/**
		 * Retrieving Rate History - Commodity Conversion<br>
		 * 2016.05.19 ADD(using ESM_PRI_2022)
		 * @param PriRfaNoteConvCommVO priRfaNoteConvCommVO
		 * @return RsltRtCmdtListVO
		 * @exception EventException
		 */
		public RsltRtCmdtListVO searchRateCommodityForConvList(PriRfaNoteConvCommVO priRfaNoteConvCommVO) throws EventException {
			RsltRtCmdtListVO rVo = new RsltRtCmdtListVO();

			try {
				rVo.setRsltCnoteNoteConvListVOS(dbDao.searchRateCommodityNoteConvList(priRfaNoteConvCommVO));
				
				return rVo;
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	        } catch (Exception ex) {
	            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
			}
		}
		
		/**
		 * Handling multi transaction of Commodity CNote <br>
		 * 2016.05.19 ADD
		 * 
		 * @param PriRpScpRtCnoteVO[] priRpScpRtCnoteVOS
		 * @param SignOnUserAccount account
		 * @exception EventException
		 */
		public void manageCommodityCnote(PriRpScpRtCnoteVO[] priRpScpRtCnoteVOS, SignOnUserAccount account) throws EventException {
			try {
				
				List<PriRpScpRtCnoteVO> iCnoteVoList = new ArrayList<PriRpScpRtCnoteVO>();
				List<PriRpScpRtCnoteVO> uCnoteVoList = new ArrayList<PriRpScpRtCnoteVO>();
				List<PriRpScpRtCnoteVO> dCnoteVoList = new ArrayList<PriRpScpRtCnoteVO>();
				
				if(priRpScpRtCnoteVOS != null && priRpScpRtCnoteVOS.length > 0){
					for(int i = 0; i < priRpScpRtCnoteVOS.length; i++){
						if (priRpScpRtCnoteVOS[i].getIbflag().equals("D")) {
							dCnoteVoList.add(priRpScpRtCnoteVOS[i]);
						} else if (priRpScpRtCnoteVOS[i].getIbflag().equals("I")) {
							priRpScpRtCnoteVOS[i].setCreUsrId(account.getCre_usr_id());
							priRpScpRtCnoteVOS[i].setUpdUsrId(account.getCre_usr_id());
							iCnoteVoList.add(priRpScpRtCnoteVOS[i]);
						} else if (priRpScpRtCnoteVOS[i].getIbflag().equals("U")) {
							priRpScpRtCnoteVOS[i].setUpdUsrId(account.getCre_usr_id());
							uCnoteVoList.add(priRpScpRtCnoteVOS[i]);
						}
					}
				}
				
				if (dCnoteVoList.size() > 0) {
					dbDao.removeRateCnote(dCnoteVoList);
				}
				if (iCnoteVoList.size() > 0) {
					dbDao.addRateCnote(iCnoteVoList);
				}
				if (uCnoteVoList.size() > 0) {
					dbDao.modifyRateCnote(uCnoteVoList, "N");
				}


			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
			}
		}
		
		//########### ESM_PRI_2022 2015.05.19 ADD END ############

	
}
