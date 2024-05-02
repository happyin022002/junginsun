/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFARateQuotationBCImpl.java
 *@FileTitle : RFA Quotation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.04
 *@LastModifier : 송호진
 *@LastVersion : 1.0
 * 2009.07.29 송민석
 * 1.0 Creation
 * 2010.10.04 송호진 CHM-201006291-01 - [긴급 요청사항] Session 정보 관련 getCre_usr_id - getUsr_id 로 교체
 * 2011.06.29 김민아 [CHM-201111837] Split 20-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건 : 문자열 비교는 문자열 비교 메소드를 사용하도록 수정
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.CompareToBuilder;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration.RFARateQuotationDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.FicCheckCYPortLocationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.FicRouteGroupVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.InPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.InPriLocationViaListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.InPriQuotationRateAdjustSetVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.InPriRateAdjustListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.PriRqRtCmdtRoutSetVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RFARateQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltCmpbViewAllListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltFicCheckCYPortLocationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriCostDetailByTransModeListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRateCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtCmdtRoutVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtDuplicateCheckVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtGuidelineRateVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtListHorizontalExcelForAddOnTariffVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtListVerticalExcelForAddOnTariffVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtRoutDestPntVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtRoutOrgPntVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtRoutViaVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustCommodityDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustCommodityVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustLocationGroupDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustLocationGroupVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeLastAccessDateVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPrsSurchargeDetailListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListHorizontalExcelForIHCVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListHorizontalLoadExcelForIHCVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListVerticalExcelForIHCVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListVerticalExcelVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.table.PriRqHdrVO;
import com.hanjin.syscommon.common.table.PriRqMnVO;
import com.hanjin.syscommon.common.table.PriRqRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRqRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRqRtCmdtVO;
import com.hanjin.syscommon.common.table.PriRqRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriRqRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriRqRtScgVO;
import com.hanjin.syscommon.common.table.PriRqRtUsdRoutCsVO;
import com.hanjin.syscommon.common.table.PriRqRtVO;
import com.hanjin.syscommon.common.table.PriRqScgAdjVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * ALPS-RFAQuotation Business Logic Basic Command implementation<br>
 * - ALPS-RFAQuotation에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author SONG MIN SEOK
 * @see ESM_PRI_6018EventResponse,RFARateQuotationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class RFARateQuotationBCImpl extends BasicCommandSupport implements RFARateQuotationBC {

	// Database Access Object
	private transient RFARateQuotationDBDAO dbDao = null;

	/**
	 * RFARateQuotationBCImpl 객체 생성<br>
	 * RFARateQuotationDBDAO를 생성한다.<br>
	 */
	public RFARateQuotationBCImpl() {
		dbDao = new RFARateQuotationDBDAO();
	}

	/**
	 * PRS- Applicable Route, Surcharge Detail을 조회 처리합니다.<br>
	 * 
	 * @param InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO
	 * @return RsltPrsSurchargeDetailListVO
	 * @exception EventException
	 */
	public RsltPrsSurchargeDetailListVO searchRateSurchargeList(InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO) throws EventException {
		try {
			RsltPrsSurchargeDetailListVO rsltPrsSurchargeDetailListVO = new RsltPrsSurchargeDetailListVO();
			rsltPrsSurchargeDetailListVO.setRsltPrsSurchargeDetailVOS(dbDao.searchSurchargeDetailList(inpPrsSurchargeDetailApplicableRouteVO));
			rsltPrsSurchargeDetailListVO.setRsltPrsSurchargeDetailApplicableRouteVOS(dbDao.searchSurchargeList(inpPrsSurchargeDetailApplicableRouteVO));
			return rsltPrsSurchargeDetailListVO;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * PRS- Surcharge Detail 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param PriRqRtScgVO[] priRqRtScgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateSurcharge(PriRqRtScgVO[] priRqRtScgVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRqRtScgVO> insertVoList = new ArrayList<PriRqRtScgVO>();
			List<PriRqRtScgVO> updateVoList = new ArrayList<PriRqRtScgVO>();
			List<PriRqRtScgVO> deleteVoList = new ArrayList<PriRqRtScgVO>();
			PriRqRtScgVO tmpPriRqRtScgVO = null;

			for (int i = 0; i < priRqRtScgVOs.length; i++) {
				if (priRqRtScgVOs[i].getIbflag().equals("I")) {
					priRqRtScgVOs[i].setCreUsrId(account.getUsr_id());
					priRqRtScgVOs[i].setUpdUsrId(account.getUsr_id());
					priRqRtScgVOs[i].setTrfAdjTpCd("I");
					insertVoList.add(priRqRtScgVOs[i]);
				} else if (priRqRtScgVOs[i].getIbflag().equals("U")) {
					priRqRtScgVOs[i].setUpdUsrId(account.getUsr_id());
					priRqRtScgVOs[i].setTrfAdjTpCd("I");
					updateVoList.add(priRqRtScgVOs[i]);
				} else if (priRqRtScgVOs[i].getIbflag().equals("D")) {
					priRqRtScgVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priRqRtScgVOs[i]);
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

			// chg_cd를 뺀 나머지 Key 부분만 있으면 되기때문에
			// CUD중 하나의 key만 있으면 된다.
			if (deleteVoList.size() > 0) {
				tmpPriRqRtScgVO = deleteVoList.get(0);
			} else if (updateVoList.size() > 0) {
				tmpPriRqRtScgVO = updateVoList.get(0);
			} else if (insertVoList.size() > 0) {
				tmpPriRqRtScgVO = insertVoList.get(0);
			}
			if (tmpPriRqRtScgVO != null) {
				dbDao.modifyPrsRateSurchargeCmpb(tmpPriRqRtScgVO, "2");
				dbDao.modifyPrsRateCmdtRoutCmpb(tmpPriRqRtScgVO, "2");

			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @return List<RsltPriPrsCostListVO>
	 * @exception EventException
	 */
	public List<RsltPriPrsCostListVO> searchCostDetailList(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws EventException {
		try {
			return dbDao.searchCostDetailList(rsltPriPrsCostListVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 상세 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO
	 * @return List<RsltPriPrsCostDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriPrsCostDetailVO> searchCostDetailInquiryList(RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO) throws EventException {
		try {
			return dbDao.searchCostDetailInquiryList(rsltPriPrsCostDetailVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * PRS- Surcharge Adjust을 조회합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO
	 * @return List<RsltPriSurchargeAdjustListVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustListVO> searchSurchargeAdjustList(RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO) throws EventException {
		try {
			return dbDao.searchSurchargeAdjustList(rsltPriSurchargeAdjustListVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * PRS- Surcharge Adjust 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param PriRqScgAdjVO[] priRqScgAdjVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageSurchargeAdjust(PriRqScgAdjVO[] priRqScgAdjVO, SignOnUserAccount account) throws EventException {
		try {
			List<PriRqScgAdjVO> insertVoList = new ArrayList<PriRqScgAdjVO>();
			List<PriRqScgAdjVO> updateVoList = new ArrayList<PriRqScgAdjVO>();
			List<PriRqScgAdjVO> deleteVoList = new ArrayList<PriRqScgAdjVO>();

			for (int i = 0; i < priRqScgAdjVO.length; i++) {
				if (priRqScgAdjVO[i].getIbflag().equals("I")) {
					priRqScgAdjVO[i].setCreUsrId(account.getUsr_id());
					priRqScgAdjVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRqScgAdjVO[i]);
				} else if (priRqScgAdjVO[i].getIbflag().equals("U")) {
					priRqScgAdjVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRqScgAdjVO[i]);
				} else if (priRqScgAdjVO[i].getIbflag().equals("D")) {
					priRqScgAdjVO[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priRqScgAdjVO[i]);
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeSurchargeAdjust(deleteVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifySurchargeAdjust(updateVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addSurchargeAdjust(insertVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * PRS- Surcharge Adjust 내용을 바탕으로 calc 로직을 수행 합니다.<br>
	 * 
	 * @param PriRqScgAdjVO priRqScgAdjVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargeAdjustCalc(PriRqScgAdjVO priRqScgAdjVO, SignOnUserAccount account) throws EventException {
		PriRqScgAdjVO tmpPriRqScgAdjVO = new PriRqScgAdjVO();
		RsltPriPrsCostListVO rsltPriPrsCostListVO = null;
		PriRqRtScgVO priRqRtScgVo = null;
		try {
			if (tmpPriRqScgAdjVO != null) {
				rsltPriPrsCostListVO = new RsltPriPrsCostListVO();
				rsltPriPrsCostListVO.setUpdUsrId(account.getUsr_id());
				rsltPriPrsCostListVO.setQttnNo(priRqScgAdjVO.getQttnNo());
				rsltPriPrsCostListVO.setQttnVerNo(priRqScgAdjVO.getQttnVerNo());

				priRqRtScgVo = new PriRqRtScgVO();
				priRqRtScgVo.setUpdUsrId(account.getUsr_id());
				priRqRtScgVo.setQttnNo(priRqScgAdjVO.getQttnNo());
				priRqRtScgVo.setQttnVerNo(priRqScgAdjVO.getQttnVerNo());

				// Calc의 일부 로직
				dbDao.addPriRqRtScgAmtCostDetail(rsltPriPrsCostListVO, "1");// mergePRI_SQ_RT_SCG
				dbDao.modifyPrsRateSurchargeCmpb(priRqRtScgVo, "1");
				dbDao.modifyPrsRateCmdtRoutCmpb(priRqRtScgVo, "1");
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
	 * Commodity Group을 조회합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO
	 * @return List<RsltPriSurchargeAdjustCommodityVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustCommodityVO> searchRateCommodityAllList(RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO) throws EventException {
		try {
			return dbDao.searchRateCommodityAllList(rsltPriSurchargeAdjustCommodityVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Surcharge Adjust-Commodity group에 대한 상세 내용을 조회합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityDetailVO
	 * @return List<RsltPriSurchargeAdjustCommodityDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustCommodityDetailVO> searchRateGroupCommodityDetailList(
			RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityDetailVO) throws EventException {
		try {
			return dbDao.searchRateGroupCommodityDetailList(rsltPriSurchargeAdjustCommodityDetailVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Surcharge Adjust-Location Group을 조회 합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationGroupVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustLocationGroupVO> searchRateLocationAllList(RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationGroupVO)
			throws EventException {
		try {
			return dbDao.searchRateLocationAllList(rsltPriSurchargeAdjustLocationGroupVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Surcharge Adjust-Location Group에 상세 정보를 조회 합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupDetailVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustLocationGroupDetailVO> searchRateGroupLocationDetailList(
			RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupDetailVO) throws EventException {
		try {
			return dbDao.searchRateGroupLocationDetailList(rsltPriSurchargeAdjustLocationGroupDetailVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Trans.Mode에 따른 Cost 상세정보를 조회 합니다.<br>
	 * 
	 * @param RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO
	 * @return List<RsltPriCostDetailByTransModeListVO>
	 * @exception EventException
	 */
	public List<RsltPriCostDetailByTransModeListVO> searchCostDetailByTransModeList(RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO)
			throws EventException {
		try {
			return dbDao.searchCostDetailByTransModeList(rsltPriCostDetailByTransModeListVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CM/OP View All 팝업화면 조회 처리<br>
	 * 
	 * @param RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO
	 * @return List<RsltPriRateCmViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriRateCmViewAllVO> searchRateCmViewAllList(RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO) throws EventException {
		try {
			return dbDao.searchRateCmViewAllList(rsltPriRateCmViewAllVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * CM/OP View 의 Load 값을 갱신처리 합니다.<BR>
	 * 
	 * @param PriRqRtCmdtRoutSetVO priRqRtCmdtRoutSetVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsPfmc(PriRqRtCmdtRoutSetVO priRqRtCmdtRoutSetVO, SignOnUserAccount account) throws EventException {
		try {
			List<PriRqRtCmdtRoutVO> updateVoList = new ArrayList<PriRqRtCmdtRoutVO>();
			String pfmcUnit = priRqRtCmdtRoutSetVO.getPfmcUnit();
			PriRqRtCmdtRoutVO[] priRqRtCmdtRoutVO = priRqRtCmdtRoutSetVO.getPriRqRtCmdtRoutVOS();

			for (int i = 0; i < priRqRtCmdtRoutVO.length; i++) {
				if (priRqRtCmdtRoutVO[i].getIbflag().equals("U")) {
					priRqRtCmdtRoutVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRqRtCmdtRoutVO[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyPrsPfmc(updateVoList, pfmcUnit);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * RFA RATE관련 Cost, CMPB,OPB 값을 갱신하고 그 갱신여부를 Mark해둔다.
	 * 
	 * @param RsltPriPrsCostListVO[] rsltPriPrsCostListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsCost(RsltPriPrsCostListVO[] rsltPriPrsCostListVOS, SignOnUserAccount account) throws EventException {
		try {
			List<RsltPriPrsCostListVO> rateUpdateVoList = new ArrayList<RsltPriPrsCostListVO>();
			List<RsltPriPrsCostListVO> routCsUpdateVoList = new ArrayList<RsltPriPrsCostListVO>();

			for (int i = 0; i < rsltPriPrsCostListVOS.length; i++) {
				if (rsltPriPrsCostListVOS[i].getIbflag().equals("U")) {
					rsltPriPrsCostListVOS[i].setUpdUsrId(account.getUsr_id());
					if ("Y".equals(rsltPriPrsCostListVOS[i].getUsdRoutCsSelFlg()) || "1".equals(rsltPriPrsCostListVOS[i].getUsdRoutCsSelFlg())) {
						rateUpdateVoList.add(rsltPriPrsCostListVOS[i]);
						rsltPriPrsCostListVOS[i].setUsdRoutCsSelFlg("Y");
					} else {
						rsltPriPrsCostListVOS[i].setUsdRoutCsSelFlg("N");
					}
					routCsUpdateVoList.add(rsltPriPrsCostListVOS[i]);
				}
			}

			if (routCsUpdateVoList.size() > 0) {
				this.modifyPrsRateCommodityRoute(routCsUpdateVoList);
			}
			if (rateUpdateVoList.size() > 0) {
				this.modifyCalculateLogicData(rateUpdateVoList);
			}
		} catch (EventException de) {
			throw de;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Route의 선택여부를 Mark해둔다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyPrsRateCommodityRoute(List<RsltPriPrsCostListVO> rsltPriPrsCostListVO) throws EventException {
		try {
			dbDao.modifyPrsRateCommodityRoute(rsltPriPrsCostListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Calculate Logic을 이용해 data를 갱신한다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyCalculateLogicData(List<RsltPriPrsCostListVO> rsltPriPrsCostListVO) throws EventException {
		try {
			dbDao.modifyRate(rsltPriPrsCostListVO);
			// RFAQuotationCalculate Logic 추가
			dbDao.removePriRqRtScgRoutCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.addPriRqRtScgRoutCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.removePriRqRtScgCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.addPriRqRtScgCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.addPriRqRtScgAmtCostDetail(rsltPriPrsCostListVO.get(0), "2");
			dbDao.modifyPriRqRtSurchargeCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriRqRtCMPBCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriRqRtSvcLaneCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriRqRtGlineMappingCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriRqRtCmdtRoutEstmCostDetail(rsltPriPrsCostListVO.get(0));

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Pre CM/OP Simulation Cost관련 Cost, CMPB,OPB 값을 갱신.
	 * 
	 * @param RsltPriPrsCostListVO[] rsltPriPrsCostListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsSimulationCost(RsltPriPrsCostListVO[] rsltPriPrsCostListVOS, SignOnUserAccount account) throws EventException {
		try {
			List<RsltPriPrsCostListVO> rateUpdateVoList = new ArrayList<RsltPriPrsCostListVO>();

			for (int i = 0; i < rsltPriPrsCostListVOS.length; i++) {
				rateUpdateVoList.add(rsltPriPrsCostListVOS[i]);
			}
			if (rateUpdateVoList.size() > 0) {
				dbDao.modifyRate(rateUpdateVoList);
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
	 * Quotaion의 route 조회 처리<br>
	 * Quotaion의 route 리스트 조회 이벤트 처리<br>
	 * 
	 * @param String ficRtTpCd
	 * @param InPriCommodityRouteVO inPriCommodityRouteVO
	 * @return List<RsltPriCommodityRouteVO>
	 * @exception EventException
	 */
	public List<RsltPriCommodityRouteVO> searchCommodityRouteList(String ficRtTpCd, InPriCommodityRouteVO inPriCommodityRouteVO) throws EventException {
		try {
			return dbDao.searchCommodityRouteList(ficRtTpCd, inPriCommodityRouteVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Quotaion의 route의 모든 Area 리스트 조회 이벤트 처리<br>
	 * 구분에 따라 조회 하는 테이블을 달리하지만 성격이 같은 route정보를 조회한다.<BR>
	 * 
	 * @param InPriCommodityRouteVO inPriCommodityRouteVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCommodityRouteAreaList(InPriCommodityRouteVO inPriCommodityRouteVO) throws EventException {
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
		try {
			String opTpCd = inPriCommodityRouteVO.getOpTpCd();
			if (opTpCd.equals("A")) {
				list = dbDao.searchCommodityRoutePntAreaList(inPriCommodityRouteVO);
			} else if (opTpCd.equals("B")) {
				list = dbDao.searchCommodityRouteViaAreaList(inPriCommodityRouteVO);
			} else if (opTpCd.equals("C")) {
				list = dbDao.searchCommodityRouteTermAreaList(inPriCommodityRouteVO);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
		return list;
	}

	/**
	 * S/C Quotaion의 생성 일자를 조회 처리<br>
	 * 
	 * @param InPriCommodityRouteVO inPriCommodityRouteVO
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO searchSCQuotationCreationDate(InPriCommodityRouteVO inPriCommodityRouteVO) throws EventException {
		try {
			List<RsltCdListVO> list = dbDao.searchSCQuotationCreationDate(inPriCommodityRouteVO);
			RsltCdListVO vo = new RsltCdListVO();
			if (list.size() > 0) {
				vo = list.get(0);
			}
			return vo;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * uotaion Rate 의 Rate Amount값을 갱신처리 합니다.
	 * 
	 * @param String ficRtpTpCd
	 * @param InPriQuotationRateAdjustSetVO inPriQuotationRateAdjustSetVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyRateRfaQuotation(String ficRtpTpCd, InPriQuotationRateAdjustSetVO inPriQuotationRateAdjustSetVO, SignOnUserAccount account) throws EventException {
		try {
			InPriCommodityRouteVO cmdtroutVO = inPriQuotationRateAdjustSetVO.getInPriCommodityRouteVO();
			InPriLocationViaListVO[] locList = inPriQuotationRateAdjustSetVO.getInPriLocationViaListVOS();
			InPriRateAdjustListVO[] adjList = inPriQuotationRateAdjustSetVO.getInPriRateAdjustListVOS();
			List<InPriLocationViaListVO> updateVoList = new ArrayList<InPriLocationViaListVO>();
			for (int i = 0; i < locList.length; i++) {
				String seq = locList[i].getSeq();
				for (int j = 0; j < adjList.length; j++) {
					if (seq.equals(adjList[j].getParentsSeq())) {
						InPriLocationViaListVO inParam = (InPriLocationViaListVO) locList[i].clone();
						inParam.setPer(adjList[j].getPer());
						inParam.setCargo(adjList[j].getCargo());
						inParam.setCurrency(adjList[j].getCurrency());
						inParam.setAmount(adjList[j].getAmount());
						inParam.setPercent(adjList[j].getPercent());
						inParam.setCreUsrId(account.getUsr_id());
						inParam.setUpdUsrId(account.getUsr_id());
						updateVoList.add(inParam);
					}
				}
			}
			for (int i = 0; i < updateVoList.size(); i++) {
				log.debug("===========>>>>>" + updateVoList.get(i).getAmount());
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateRfaQuotation(updateVoList, cmdtroutVO, ficRtpTpCd);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	// ////////////////////////////////////////////////RQ RATE MAIN//////////////////////////////////////////////////////////

	/**
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 을 조회 합니다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltPriRqRtCmdtVO>
	 * @exception EventException
	 */
	public List<RsltPriRqRtCmdtVO> searchRfaRateQuotationList(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchPriRqRtCmdtGrpList(priRqRtCmdtHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}

	}

	/**
	 * PRI_RQ_RT_CMDT_ROUT 을 조회 합니다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltPriRqRtCmdtRoutVO>
	 * @exception EventException
	 */
	public List<RsltPriRqRtCmdtRoutVO> searchRateCommodityRouteList(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchPriRqRtCmdtRoutVOList(priRqRtCmdtHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}

	}

	/**
	 * PRI_RQ_RT_ROUT_PNT,PRI_RQ_RT_ROUT_VIA,PRI_RQ_RT 을 조회 합니다.<br>
	 * 
	 * @param RFARateQuotationVO inRateQuotationVO
	 * @return RFARateQuotationVO
	 * @exception EventException
	 */
	public RFARateQuotationVO searchRateList(RFARateQuotationVO inRateQuotationVO) throws EventException {
		try {
			PriRqRtCmdtRoutVO priRqRtCmdtRoutVO = inRateQuotationVO.getPriRqRtCmdtRoutVO();
			// 컨테이너 vo
			RFARateQuotationVO rateQuotationVO = new RFARateQuotationVO();
			// detail List
			List<RsltPriRqRtCmdtVO> rsltPriRqRtCmdtVOList = new ArrayList<RsltPriRqRtCmdtVO>();
			List<RsltPriRqRtRoutOrgPntVO> rsltPriRqRtRoutOrgPntVOList = new ArrayList<RsltPriRqRtRoutOrgPntVO>();
			List<RsltPriRqRtRoutDestPntVO> rsltPriRqRtRoutDestPntVOList = new ArrayList<RsltPriRqRtRoutDestPntVO>();
			List<RsltPriRqRtRoutViaVO> rsltPriRqRtRoutOrgViaVOList = new ArrayList<RsltPriRqRtRoutViaVO>();
			List<RsltPriRqRtRoutViaVO> rsltPriRqRtRoutDestViaVOList = new ArrayList<RsltPriRqRtRoutViaVO>();
			List<RsltPriRqRtVO> rsltPriRqRtVOList = new ArrayList<RsltPriRqRtVO>();

			rsltPriRqRtCmdtVOList = dbDao.searchPriRqRtCmdtVOList(priRqRtCmdtRoutVO, inRateQuotationVO.getFicRtTpCd());
			rsltPriRqRtRoutOrgPntVOList = dbDao.searchPriRqRtRoutOrgPntVOList(priRqRtCmdtRoutVO);
			rsltPriRqRtRoutDestPntVOList = dbDao.searchPriRqRtRoutDestPntVOList(priRqRtCmdtRoutVO);
			rsltPriRqRtRoutOrgViaVOList = dbDao.searchPriRqRtRoutOrgViaVOList(priRqRtCmdtRoutVO);
			rsltPriRqRtRoutDestViaVOList = dbDao.searchPriRqRtRoutDestViaVOList(priRqRtCmdtRoutVO);
			rsltPriRqRtVOList = dbDao.searchPriRqRtVOList(priRqRtCmdtRoutVO);

			rateQuotationVO.setRsltPriRqRtCmdtVOList(rsltPriRqRtCmdtVOList);
			rateQuotationVO.setRsltPriRqRtRoutOrgPntVOs(rsltPriRqRtRoutOrgPntVOList);
			rateQuotationVO.setRsltPriRqRtRoutDestPntVOs(rsltPriRqRtRoutDestPntVOList);
			rateQuotationVO.setRsltPriRqRtRoutOrgViaVOList(rsltPriRqRtRoutOrgViaVOList);
			rateQuotationVO.setRsltPriRqRtRoutDestViaVOList(rsltPriRqRtRoutDestViaVOList);
			rateQuotationVO.setRsltPriRqRtVOList(rsltPriRqRtVOList);

			return rateQuotationVO;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 입력 수정 삭제한다<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCommodityRouteRateRfaRateQuotation(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException {
		try {

			// 컨테이너 vo에서 CMDT_HDR, CMDT 뺀다
			PriRqRtCmdtHdrVO[] priRqRtCmdtHdrVOs = rateQuotationVO.getPriRqRtCmdtHdrVOs();
			PriRqRtCmdtVO[] priRqRtCmdtVOs = rateQuotationVO.getPriRqRtCmdtVOs();

			List<PriRqRtCmdtHdrVO> insertVoList = new ArrayList<PriRqRtCmdtHdrVO>();
			List<PriRqRtCmdtHdrVO> updateVoList = new ArrayList<PriRqRtCmdtHdrVO>();
			List<PriRqRtCmdtHdrVO> deleteVoList = new ArrayList<PriRqRtCmdtHdrVO>();
			List<PriRqRtCmdtVO> insertDtlVoList = new ArrayList<PriRqRtCmdtVO>();
			List<PriRqRtCmdtVO> updateDtlVoList = new ArrayList<PriRqRtCmdtVO>();
			List<PriRqRtCmdtVO> deleteDtlVoList = new ArrayList<PriRqRtCmdtVO>();

			// //////////////////////////CMDT_HDR / CMDT 저장/////////////////////////////////////

			// CMDT_HDR
			for (int i = 0; priRqRtCmdtHdrVOs != null && i < priRqRtCmdtHdrVOs.length; i++) {

				if (priRqRtCmdtHdrVOs[i].getIbflag().equals("I")) {

					priRqRtCmdtHdrVOs[i].setCreUsrId(account.getUsr_id());
					priRqRtCmdtHdrVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRqRtCmdtHdrVOs[i]);

				} else if (priRqRtCmdtHdrVOs[i].getIbflag().equals("U")) {
					priRqRtCmdtHdrVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRqRtCmdtHdrVOs[i]);

				} else if (priRqRtCmdtHdrVOs[i].getIbflag().equals("D")) {
					priRqRtCmdtHdrVOs[i].setUpdUsrId(account.getUsr_id());

					// qttn no, qttn ver no 별 삭제
					PriRqRtCmdtHdrVO delPriRqRtCmdtHdrVO = new PriRqRtCmdtHdrVO();
					delPriRqRtCmdtHdrVO.setQttnNo(priRqRtCmdtHdrVOs[i].getQttnNo());
					delPriRqRtCmdtHdrVO.setQttnVerNo(priRqRtCmdtHdrVOs[i].getQttnVerNo());
					delPriRqRtCmdtHdrVO.setCmdtHdrSeq(priRqRtCmdtHdrVOs[i].getCmdtHdrSeq());
					delPriRqRtCmdtHdrVO.setFicRtTpCd(rateQuotationVO.getFicRtTpCd());
					// cmdt 삭제
					dbDao.removeRfaQuotationCommodity(delPriRqRtCmdtHdrVO);

					PriRqRtCmdtRoutVO delPriRqRtCmdtRoutVO = new PriRqRtCmdtRoutVO();
					delPriRqRtCmdtRoutVO.setQttnNo(priRqRtCmdtHdrVOs[i].getQttnNo());
					delPriRqRtCmdtRoutVO.setQttnVerNo(priRqRtCmdtHdrVOs[i].getQttnVerNo());
					delPriRqRtCmdtRoutVO.setCmdtHdrSeq(priRqRtCmdtHdrVOs[i].getCmdtHdrSeq());

					// detail 삭제
					removeRouteRateRfaRateQuotationByRout(delPriRqRtCmdtRoutVO);
					// hdr 삭제
					dbDao.removeRfaQuotationCommodityHeader(priRqRtCmdtHdrVOs[i]);

					// 이미 삭제 했으므로 null 세팅
					priRqRtCmdtVOs = null;
				}
			}

			// CMDT
			for (int k = 0; priRqRtCmdtVOs != null && k < priRqRtCmdtVOs.length; k++) {
				if (k == 0) {
					PriRqRtCmdtHdrVO delPriRqRtCmdtHdrVO = new PriRqRtCmdtHdrVO();
					delPriRqRtCmdtHdrVO.setQttnNo(priRqRtCmdtVOs[k].getQttnNo());
					delPriRqRtCmdtHdrVO.setQttnVerNo(priRqRtCmdtVOs[k].getQttnVerNo());
					delPriRqRtCmdtHdrVO.setFicRtTpCd(rateQuotationVO.getFicRtTpCd());
					dbDao.removeRfaQuotationCommodity(delPriRqRtCmdtHdrVO);
				}

				priRqRtCmdtVOs[k].setCreUsrId(account.getUsr_id());
				priRqRtCmdtVOs[k].setUpdUsrId(account.getUsr_id());

				insertDtlVoList.add(priRqRtCmdtVOs[k]);

			}

			if (deleteDtlVoList.size() > 0) {
				dbDao.removeRfaQuotationCommodityS(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeRfaQuotationCommodityHeaderS(deleteVoList);
			}

			if (insertVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityHeaderS(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityS(insertDtlVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRfaQuotationCommodityHeaderS(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyRfaQuotationCommodityS(updateDtlVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * RATE 관련 테이블을 Base SEQ 별 삭제한다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @exception EventException
	 */
	public void removeRouteRateRfaRateQuotationByRout(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws EventException {
		try {

			// Rout 별 모든 데이터를 삭제한다
			if (priRqRtCmdtRoutVO != null) {
				dbDao.removeRfaQuotationRoutePoint(priRqRtCmdtRoutVO);
				dbDao.removeRfaQuotationRouteVia(priRqRtCmdtRoutVO);
				dbDao.removeRfaQuotationRateUsedRouteCase(priRqRtCmdtRoutVO);
				dbDao.removeRfaQuotationRateSurcharge(priRqRtCmdtRoutVO);
				dbDao.removeRfaQuotationRateSurchargeRoute(priRqRtCmdtRoutVO);
				dbDao.removeRfaQuotationRate(priRqRtCmdtRoutVO);
				dbDao.removeRfaQuotationCommodityRoute(priRqRtCmdtRoutVO);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * PRI_RQ_RT_CMDT_ROUT, PRI_RQ_RT_ROUT_PNT, PRI_RQ_RT_ROUT_VIA, PRI_RQ_RT 입력 수정 삭제한다<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRouteRateRfaRateQuotation(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException {
		try {

			// vo
			PriRqRtCmdtHdrVO priRqRtCmdtHdrVO = rateQuotationVO.getPriRqRtCmdtHdrVO();
			PriRqRtCmdtRoutVO priRqRtCmdtRoutVO = rateQuotationVO.getPriRqRtCmdtRoutVO();

			PriRqRtCmdtRoutVO[] priRqRtCmdtRoutVOs = rateQuotationVO.getPriRqRtCmdtRoutVOs();
			PriRqRtRoutPntVO[] priRqRtRoutOrgPntVOs = rateQuotationVO.getPriRqRtRoutOrgPntVOs();
			PriRqRtRoutPntVO[] priRqRtRoutDestPntVOs = rateQuotationVO.getPriRqRtRoutDestPntVOs();
			PriRqRtRoutViaVO[] priRqRtRoutOrgViaVOs = rateQuotationVO.getPriRqRtRoutOrgViaVOs();
			PriRqRtRoutViaVO[] priRqRtRoutDestViaVOs = rateQuotationVO.getPriRqRtRoutDestViaVOs();
			PriRqRtVO[] priRqRtVOs = rateQuotationVO.getPriRqRtVOs();

			String ibFlag = "";

			// //////////////////////////Cmdt Rout / detail 저장/////////////////////////////////////

			int max_rout_seq = dbDao.searchPriRqRtCmdtRoutMaxSeq(priRqRtCmdtHdrVO);

			// Cmdt Rout
			for (int i = 0; priRqRtCmdtRoutVOs != null && i < priRqRtCmdtRoutVOs.length; i++) {

				ibFlag = priRqRtCmdtRoutVOs[i].getIbflag();

				if (priRqRtCmdtRoutVOs[i].getIbflag().equals("I")) {

					priRqRtCmdtRoutVOs[i].setRoutSeq(String.valueOf(max_rout_seq + i));

					priRqRtCmdtRoutVOs[i].setCreUsrId(account.getUsr_id());
					priRqRtCmdtRoutVOs[i].setUpdUsrId(account.getUsr_id());

					dbDao.addRfaQuotationCommodityRoute(priRqRtCmdtRoutVOs[i]);

				} else if (priRqRtCmdtRoutVOs[i].getIbflag().equals("U")) {

					priRqRtCmdtRoutVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyRfaQuotationCommodityRoute(priRqRtCmdtRoutVOs[i]);

				} else if (priRqRtCmdtRoutVOs[i].getIbflag().equals("D")) {
					// detail별 삭제
					removeRouteRateRfaRateQuotationByRout(priRqRtCmdtRoutVOs[i]);
					// 이미 삭제 했으므로 null 세팅
					priRqRtRoutOrgPntVOs = null;
					priRqRtRoutDestPntVOs = null;
					priRqRtRoutOrgViaVOs = null;
					priRqRtRoutDestViaVOs = null;
					priRqRtVOs = null;
				}

			}

			int max_seq = -1;

			PriRqRtRoutPntVO delPriRqRtRoutPntVO = new PriRqRtRoutPntVO();
			if (!"D".equals(ibFlag)) {
				if (priRqRtRoutOrgPntVOs == null || priRqRtRoutOrgPntVOs.length == 0) {
					delPriRqRtRoutPntVO.setQttnNo(priRqRtCmdtRoutVO.getQttnNo());
					delPriRqRtRoutPntVO.setQttnVerNo(priRqRtCmdtRoutVO.getQttnVerNo());
					delPriRqRtRoutPntVO.setCmdtHdrSeq(priRqRtCmdtRoutVO.getCmdtHdrSeq());
					delPriRqRtRoutPntVO.setRoutSeq(priRqRtCmdtRoutVO.getRoutSeq());
					delPriRqRtRoutPntVO.setOrgDestTpCd("O");
					dbDao.removeRfaQuotationRoutePoint(delPriRqRtRoutPntVO);
				}
			}

			// OrgRoutPnt
			for (int i = 0; priRqRtRoutOrgPntVOs != null && i < priRqRtRoutOrgPntVOs.length; i++) {
				if (i == 0) {
					delPriRqRtRoutPntVO = new PriRqRtRoutPntVO();
					delPriRqRtRoutPntVO.setQttnNo(priRqRtRoutOrgPntVOs[i].getQttnNo());
					delPriRqRtRoutPntVO.setQttnVerNo(priRqRtRoutOrgPntVOs[i].getQttnVerNo());
					delPriRqRtRoutPntVO.setCmdtHdrSeq(priRqRtRoutOrgPntVOs[i].getCmdtHdrSeq());
					delPriRqRtRoutPntVO.setRoutSeq(priRqRtRoutOrgPntVOs[i].getRoutSeq());
					delPriRqRtRoutPntVO.setOrgDestTpCd("O");

					dbDao.removeRfaQuotationRoutePoint(delPriRqRtRoutPntVO);
					max_seq = dbDao.searchPriRqRtRoutPntMaxSeq(priRqRtRoutOrgPntVOs[i]);
				}
				priRqRtRoutOrgPntVOs[i].setRoutPntSeq(String.valueOf(max_seq + i));
				priRqRtRoutOrgPntVOs[i].setCreUsrId(account.getUsr_id());
				priRqRtRoutOrgPntVOs[i].setUpdUsrId(account.getUsr_id());

				dbDao.addRfaQuotationRoutePoint(priRqRtRoutOrgPntVOs[i]);
			}

			PriRqRtRoutViaVO delPriRqRtRoutViaVO = new PriRqRtRoutViaVO();
			if (!"D".equals(ibFlag)) {
				if (priRqRtRoutOrgViaVOs == null || priRqRtRoutOrgViaVOs.length == 0) {
					delPriRqRtRoutViaVO.setQttnNo(priRqRtCmdtRoutVO.getQttnNo());
					delPriRqRtRoutViaVO.setQttnVerNo(priRqRtCmdtRoutVO.getQttnVerNo());
					delPriRqRtRoutViaVO.setCmdtHdrSeq(priRqRtCmdtRoutVO.getCmdtHdrSeq());
					delPriRqRtRoutViaVO.setRoutSeq(priRqRtCmdtRoutVO.getRoutSeq());
					delPriRqRtRoutViaVO.setOrgDestTpCd("O");
					dbDao.removeRfaQuotationRouteVia(delPriRqRtRoutViaVO);
				}
			}

			// OrgRoutVia
			for (int i = 0; priRqRtRoutOrgViaVOs != null && i < priRqRtRoutOrgViaVOs.length; i++) {

				if (i == 0) {

					// rout seq 별로 모두 삭제 후 입력
					delPriRqRtRoutViaVO = new PriRqRtRoutViaVO();
					delPriRqRtRoutViaVO.setQttnNo(priRqRtRoutOrgViaVOs[i].getQttnNo());
					delPriRqRtRoutViaVO.setQttnVerNo(priRqRtRoutOrgViaVOs[i].getQttnVerNo());
					delPriRqRtRoutViaVO.setCmdtHdrSeq(priRqRtRoutOrgViaVOs[i].getCmdtHdrSeq());
					delPriRqRtRoutViaVO.setRoutSeq(priRqRtRoutOrgViaVOs[i].getRoutSeq());
					delPriRqRtRoutViaVO.setOrgDestTpCd("O");
					dbDao.removeRfaQuotationRouteVia(delPriRqRtRoutViaVO);
					max_seq = dbDao.searchPriRqRtRoutViaMaxSeq(priRqRtRoutOrgViaVOs[i]);
				}

				priRqRtRoutOrgViaVOs[i].setRoutViaSeq(String.valueOf(max_seq + i));
				priRqRtRoutOrgViaVOs[i].setCreUsrId(account.getUsr_id());
				priRqRtRoutOrgViaVOs[i].setUpdUsrId(account.getUsr_id());
				dbDao.addRfaQuotationRouteVia(priRqRtRoutOrgViaVOs[i]);

			}

			if (!"D".equals(ibFlag)) {
				if (priRqRtRoutDestViaVOs == null || priRqRtRoutDestViaVOs.length == 0) {
					delPriRqRtRoutViaVO = new PriRqRtRoutViaVO();
					delPriRqRtRoutViaVO.setQttnNo(priRqRtCmdtRoutVO.getQttnNo());
					delPriRqRtRoutViaVO.setQttnVerNo(priRqRtCmdtRoutVO.getQttnVerNo());
					delPriRqRtRoutViaVO.setCmdtHdrSeq(priRqRtCmdtRoutVO.getCmdtHdrSeq());
					delPriRqRtRoutViaVO.setRoutSeq(priRqRtCmdtRoutVO.getRoutSeq());
					delPriRqRtRoutViaVO.setOrgDestTpCd("D");
					dbDao.removeRfaQuotationRouteVia(delPriRqRtRoutViaVO);
				}
			}

			// DestRoutVia
			for (int i = 0; priRqRtRoutDestViaVOs != null && i < priRqRtRoutDestViaVOs.length; i++) {

				if (i == 0) {
					// rout seq 별로 모두 삭제 후 입력
					delPriRqRtRoutViaVO = new PriRqRtRoutViaVO();
					delPriRqRtRoutViaVO.setQttnNo(priRqRtRoutDestViaVOs[i].getQttnNo());
					delPriRqRtRoutViaVO.setQttnVerNo(priRqRtRoutDestViaVOs[i].getQttnVerNo());
					delPriRqRtRoutViaVO.setCmdtHdrSeq(priRqRtRoutDestViaVOs[i].getCmdtHdrSeq());
					delPriRqRtRoutViaVO.setRoutSeq(priRqRtRoutDestViaVOs[i].getRoutSeq());
					delPriRqRtRoutViaVO.setOrgDestTpCd("D");
					dbDao.removeRfaQuotationRouteVia(delPriRqRtRoutViaVO);

					max_seq = dbDao.searchPriRqRtRoutViaMaxSeq(priRqRtRoutDestViaVOs[i]);
				}

				priRqRtRoutDestViaVOs[i].setRoutViaSeq(String.valueOf(max_seq + i));
				priRqRtRoutDestViaVOs[i].setCreUsrId(account.getUsr_id());
				priRqRtRoutDestViaVOs[i].setUpdUsrId(account.getUsr_id());

				dbDao.addRfaQuotationRouteVia(priRqRtRoutDestViaVOs[i]);

			}

			if (!"D".equals(ibFlag)) {
				if (priRqRtRoutDestPntVOs == null || priRqRtRoutDestPntVOs.length == 0) {
					delPriRqRtRoutPntVO = new PriRqRtRoutPntVO();
					delPriRqRtRoutPntVO.setQttnNo(priRqRtCmdtRoutVO.getQttnNo());
					delPriRqRtRoutPntVO.setQttnVerNo(priRqRtCmdtRoutVO.getQttnVerNo());
					delPriRqRtRoutPntVO.setCmdtHdrSeq(priRqRtCmdtRoutVO.getCmdtHdrSeq());
					delPriRqRtRoutPntVO.setRoutSeq(priRqRtCmdtRoutVO.getRoutSeq());
					delPriRqRtRoutPntVO.setOrgDestTpCd("D");
					dbDao.removeRfaQuotationRoutePoint(delPriRqRtRoutPntVO);
				}
			}

			// DestRoutPnt
			for (int i = 0; priRqRtRoutDestPntVOs != null && i < priRqRtRoutDestPntVOs.length; i++) {

				if (i == 0) {
					// rout seq 별로 모두 삭제 후 입력
					delPriRqRtRoutPntVO = new PriRqRtRoutPntVO();
					delPriRqRtRoutPntVO.setQttnNo(priRqRtRoutDestPntVOs[i].getQttnNo());
					delPriRqRtRoutPntVO.setQttnVerNo(priRqRtRoutDestPntVOs[i].getQttnVerNo());
					delPriRqRtRoutPntVO.setCmdtHdrSeq(priRqRtRoutDestPntVOs[i].getCmdtHdrSeq());
					delPriRqRtRoutPntVO.setRoutSeq(priRqRtRoutDestPntVOs[i].getRoutSeq());
					delPriRqRtRoutPntVO.setOrgDestTpCd("D");

					dbDao.removeRfaQuotationRoutePoint(delPriRqRtRoutPntVO);

					if (i == 0)
						max_seq = dbDao.searchPriRqRtRoutPntMaxSeq(priRqRtRoutDestPntVOs[i]);
				}

				priRqRtRoutDestPntVOs[i].setRoutPntSeq(String.valueOf(max_seq + i));
				priRqRtRoutDestPntVOs[i].setCreUsrId(account.getUsr_id());
				priRqRtRoutDestPntVOs[i].setUpdUsrId(account.getUsr_id());

				dbDao.addRfaQuotationRoutePoint(priRqRtRoutDestPntVOs[i]);

			}

			// 마스터가 신규인 경우
			if ("I".equals(ibFlag))
				priRqRtCmdtRoutVO.setRoutSeq(String.valueOf(max_rout_seq));
			else
				max_rout_seq = Integer.parseInt(priRqRtCmdtRoutVO.getRoutSeq());

			max_seq = dbDao.searchPriRqRtMaxSeq(priRqRtCmdtRoutVO);

			// Amt
			for (int i = 0; priRqRtVOs != null && i < priRqRtVOs.length; i++) {

				if (priRqRtVOs[i].getIbflag().equals("I")) {

					priRqRtVOs[i].setRoutSeq(String.valueOf(max_rout_seq));

					priRqRtVOs[i].setRtSeq(String.valueOf(max_seq + i));

					priRqRtVOs[i].setCreUsrId(account.getUsr_id());
					priRqRtVOs[i].setUpdUsrId(account.getUsr_id());

					dbDao.addRfaQuotationRate(priRqRtVOs[i]);

				} else if (priRqRtVOs[i].getIbflag().equals("U")) {
					priRqRtVOs[i].setCreUsrId(account.getUsr_id());
					priRqRtVOs[i].setUpdUsrId(account.getUsr_id());

					dbDao.modifyRfaQuotationRate(priRqRtVOs[i]);

				} else if (priRqRtVOs[i].getIbflag().equals("D")) {
					dbDao.removeRfaQuotationRate(priRqRtVOs[i]);
				}

			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Rate 관련 테이블 에 가이드라인 정보를 조회 입력한다<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void glineCopyRfaRateQuotation(RsltPriRqMnVO rsltPriRqMnVO, SignOnUserAccount account) throws EventException {
		try {
			rsltPriRqMnVO.setCreUsrId(account.getUsr_id());
			rsltPriRqMnVO.setUpdUsrId(account.getUsr_id());

			dbDao.addGlineCopyRfaQuotationCommodityHeader(rsltPriRqMnVO);
			dbDao.addGlineCopyRfaQuotationCommodity(rsltPriRqMnVO);
			dbDao.addGlineCopyRfaQuotationCommodityRoute(rsltPriRqMnVO);
			dbDao.addGlineCopyRfaQuotationRoutePoint(rsltPriRqMnVO);
			dbDao.addGlineCopyRfaQuotationRouteVia(rsltPriRqMnVO);
			dbDao.addGlineCopyRfaQuotationRate(rsltPriRqMnVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * RATE 관련 테이블에 COPY TO QUOTATION<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyToQuotationRfaRateQuotaionReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) throws EventException {
		try {
			rsltCopyToQuotationVO.setCreUsrId(account.getUsr_id());
			rsltCopyToQuotationVO.setUpdUsrId(account.getUsr_id());

			dbDao.addCopyToQuotationRfaQuotationCommodityHeader(rsltCopyToQuotationVO);
			dbDao.addCopyToQuotationRfaQuotationCommodity(rsltCopyToQuotationVO);
			dbDao.addCopyToQuotationRfaQuotationCommodityRoute(rsltCopyToQuotationVO);
			dbDao.addCopyToQuotationRfaQuotationRoutePoint(rsltCopyToQuotationVO);
			dbDao.addCopyToQuotationRfaQuotationRouteVia(rsltCopyToQuotationVO);
			dbDao.addCopyToQuotationRfaQuotationRate(rsltCopyToQuotationVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Duplicate List를 조회 합니다.<br>
	 * 
	 * @param String ficRtTpCd
	 * @param PriRqMnVO priRqMnVO
	 * @return List<RsltPriRqRtDuplicateCheckVO>
	 * @exception EventException
	 */
	public List<RsltPriRqRtDuplicateCheckVO> searchRateDuplicateList(String ficRtTpCd, PriRqMnVO priRqMnVO) throws EventException {
		try {
			return dbDao.searchRateDuplicateList(ficRtTpCd, priRqMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}

	}

	/**
	 * RATE 관련 테이블을 REMOVE BY QTTN NO<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @exception EventException
	 */
	public void removeRfaRateQuotation(PriRqHdrVO priRqHdrVO) throws EventException {
		try {

			dbDao.removeRfaQuotationScgAdj(priRqHdrVO);
			dbDao.removeRfaQuotationSchg(priRqHdrVO);
			dbDao.removeRfaQuotationSchgRout(priRqHdrVO);
			dbDao.removeRfaQuotationUsdRoutCs(priRqHdrVO);

			dbDao.removeRfaQuotationRate(priRqHdrVO);
			dbDao.removeRfaQuotationRoutVia(priRqHdrVO);
			dbDao.removeRfaQuotationRoutPnt(priRqHdrVO);
			dbDao.removeRfaQuotationCommodityRoute(priRqHdrVO);
			dbDao.removeRfaQuotationCommodity(priRqHdrVO);
			dbDao.removeRfaQuotationCommodityHeader(priRqHdrVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN VerticalExcel)<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateListVerticalExcel(priRqRtCmdtHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN Horizontal)<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateListHorizontalExcel(priRqRtCmdtHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * SC Rate CMPB VIEW ALL (ESM_PRI_6076) 리스트를 조회한다.<br>
	 * 
	 * @param PriRqMnVO priRqMnVO
	 * @return List<RsltCmpbViewAllListVO>
	 * @exception EventException
	 */
	public List<RsltCmpbViewAllListVO> searchRateCmpbViewAllList(PriRqMnVO priRqMnVO) throws EventException {
		try {
			return dbDao.searchRateCmpbViewAllList(priRqMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * RQ Rate LOAD EXCEL(ESM_PRI_6056) 정보를 저장한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelHorizontal(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs, SignOnUserAccount account)
			throws EventException {

		List<PriRqRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRqRtCmdtHdrVO>();
		List<PriRqRtCmdtVO> cmdtVoList = new ArrayList<PriRqRtCmdtVO>();
		List<PriRqRtCmdtRoutVO> routVoList = new ArrayList<PriRqRtCmdtRoutVO>();
		List<PriRqRtRoutPntVO> pntVoList = new ArrayList<PriRqRtRoutPntVO>();
		List<PriRqRtRoutViaVO> viaVoList = new ArrayList<PriRqRtRoutViaVO>();
		List<PriRqRtVO> rtVoList = new ArrayList<PriRqRtVO>();

		try {
			int nextCmdtHdrSeq = dbDao.searchPriRqRtCmdtHdrMaxSeq(priRqRtCmdtHdrVO);
			nextCmdtHdrSeq = nextCmdtHdrSeq - 1;

			int nextCmdtSeq = 0;
			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;

			String strQttnNo = priRqRtCmdtHdrVO.getQttnNo();
			String strQttnVerNo = priRqRtCmdtHdrVO.getQttnVerNo();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();

			for (int i = 0; i < rsltRtListHorizontalExcelVOs.length; i++) {
				RsltRtListHorizontalExcelVO row = rsltRtListHorizontalExcelVOs[i];

				String strCmdtDpSeq = row.getCmdtDpSeq();
				String strCmdtCd = row.getPrcCmdtDefCd();

				String strRoutDpSeq = row.getRoutDpSeq();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				String strDestPrcTrspModCd = row.getDestPrcTrspModNm();

				String strRateDry20 = row.getRateDry20();
				String strRateDry40 = row.getRateDry40();
				String strRateDry40hc = row.getRateDry40hc();
				String strRateDry45 = row.getRateDry45();
				String strRateRf40hc = row.getRateRf40hc();
				String strRateRd40hc = row.getRateRd40hc();

				// cmdt hdr
				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextCmdtSeq = 0;
					nextRoutSeq = 0;

					PriRqRtCmdtHdrVO cmdtHdr = new PriRqRtCmdtHdrVO();
					cmdtHdr.setQttnNo(strQttnNo);
					cmdtHdr.setQttnVerNo(strQttnVerNo);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setSrcInfoCd("NW");
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);

					cmdtHdrVoList.add(cmdtHdr);
				}

				// cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;

					String cmdtTpCd = "";
					if (strCmdtCd.length() == 6)
						cmdtTpCd = "C";
					else if (strCmdtCd.length() == 5)
						cmdtTpCd = "G";
					else if (strCmdtCd.length() == 4)
						cmdtTpCd = "R";

					PriRqRtCmdtVO cmdt = new PriRqRtCmdtVO();
					cmdt.setQttnNo(strQttnNo);
					cmdt.setQttnVerNo(strQttnVerNo);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setSrcInfoCd("NW");
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);

					cmdtVoList.add(cmdt);
				}

				// cmdt rout
				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;

					PriRqRtCmdtRoutVO rout = new PriRqRtCmdtRoutVO();
					rout.setQttnNo(strQttnNo);
					rout.setQttnVerNo(strQttnVerNo);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);

					routVoList.add(rout);
				}

				// pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = "";

					if (strOrgPntCd.length() == 5)
						locTpCd = "L";
					else if (strOrgPntCd.length() == 4)
						locTpCd = "G";
					else if (strOrgPntCd.length() == 3)
						locTpCd = "R";
					else if (strOrgPntCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutPntVO pnt = new PriRqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("O");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strOrgPntCd);
					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
					pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
					pnt.setSrcInfoCd("NW");
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					pntVoList.add(pnt);
				}

				// via origin
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					nextRoutViaSeq++;

					String locTpCd = "";

					if (strOrgViaCd.length() == 5)
						locTpCd = "L";
					else if (strOrgViaCd.length() == 4)
						locTpCd = "G";
					else if (strOrgViaCd.length() == 3)
						locTpCd = "R";
					else if (strOrgViaCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutViaVO via = new PriRqRtRoutViaVO();
					via.setQttnNo(strQttnNo);
					via.setQttnVerNo(strQttnVerNo);
					via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					via.setRoutSeq(String.valueOf(nextRoutSeq));
					via.setOrgDestTpCd("O");
					via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
					via.setRoutViaPortTpCd(locTpCd);
					via.setRoutViaPortDefCd(strOrgViaCd);
					via.setSrcInfoCd("NW");
					via.setCreUsrId(strCreUsrId);
					via.setUpdUsrId(strUpdUsrId);

					viaVoList.add(via);
				}

				// via dest
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					nextRoutViaSeq++;

					String locTpCd = "";

					if (strDestViaCd.length() == 5)
						locTpCd = "L";
					else if (strDestViaCd.length() == 4)
						locTpCd = "G";
					else if (strDestViaCd.length() == 3)
						locTpCd = "R";
					else if (strDestViaCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutViaVO via = new PriRqRtRoutViaVO();
					via.setQttnNo(strQttnNo);
					via.setQttnVerNo(strQttnVerNo);
					via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					via.setRoutSeq(String.valueOf(nextRoutSeq));
					via.setOrgDestTpCd("D");
					via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
					via.setRoutViaPortTpCd(locTpCd);
					via.setRoutViaPortDefCd(strDestViaCd);
					via.setSrcInfoCd("NW");
					via.setCreUsrId(strCreUsrId);
					via.setUpdUsrId(strUpdUsrId);

					viaVoList.add(via);
				}

				// pnt dest
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = "";

					if (strDestPntCd.length() == 5)
						locTpCd = "L";
					else if (strDestPntCd.length() == 4)
						locTpCd = "G";
					else if (strDestPntCd.length() == 3)
						locTpCd = "R";
					else if (strDestPntCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutPntVO pnt = new PriRqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("D");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strDestPntCd);
					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
					pnt.setPrcTrspModCd(strDestPrcTrspModCd);
					pnt.setSrcInfoCd("NW");
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					pntVoList.add(pnt);
				}

				PriRqRtVO rt = new PriRqRtVO();
				// Dry 20
				if (strRateDry20 != null && !"".equals(strRateDry20)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D2");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateDry20);
					rt.setQttnRtAmt(strRateDry20);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rtVoList.add(rt);
				}

				// Dry 40
				if (strRateDry40 != null && !"".equals(strRateDry40)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D4");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateDry40);
					rt.setQttnRtAmt(strRateDry40);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rtVoList.add(rt);
				}

				// Dry 40 hc
				if (strRateDry40hc != null && !"".equals(strRateDry40hc)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D5");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateDry40hc);
					rt.setQttnRtAmt(strRateDry40hc);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rtVoList.add(rt);
				}

				// Dry45
				if (strRateDry45 != null && !"".equals(strRateDry45)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D7");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateDry45);
					rt.setQttnRtAmt(strRateDry45);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rtVoList.add(rt);
				}

				// Rf40hc
				if (strRateRf40hc != null && !"".equals(strRateRf40hc)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("R5");
					rt.setPrcCgoTpCd("RF");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateRf40hc);
					rt.setQttnRtAmt(strRateRf40hc);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rtVoList.add(rt);
				}

				// Rd40hc
				if (strRateRd40hc != null && !"".equals(strRateRd40hc)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("R5");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateRd40hc);
					rt.setQttnRtAmt(strRateRd40hc);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rtVoList.add(rt);
				}
			}

			if (cmdtHdrVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityHeaderS(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityS(cmdtVoList);
			}
			if (routVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityRouteS(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addRfaQuotationRoutePointS(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addRfaQuotationRouteViaS(viaVoList);
			}
			if (rtVoList.size() > 0) {
				dbDao.addRfaQuotationRateS(rtVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * RFA Rate LOAD EXCEL(ESM_PRI_6056) 정보 정합성을 체크한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelHorizontal(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs)
			throws EventException {
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();

		try {
			for (int i = 0; i < rsltRtListHorizontalExcelVOs.length; i++) {
				RsltRtListHorizontalExcelVO row = rsltRtListHorizontalExcelVOs[i];

				String strCmdtCd = row.getPrcCmdtDefCd();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();

				// cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strCmdtCd);

					RsltCdListVO cdVO = dbDao.searchCheckCommodityCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCmdtCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("prc_cmdt_def_cd");

						rslt.add(cdVO);
					}
				}

				// pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strOrgPntCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strOrgViaCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strDestViaCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strDestPntCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}

		return rslt;
	}

	/**
	 * RFA Rate LOAD EXCEL(ESM_PRI_6057) 정보를 저장한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVertical(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account)
			throws EventException {

		List<PriRqRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRqRtCmdtHdrVO>();
		List<PriRqRtCmdtVO> cmdtVoList = new ArrayList<PriRqRtCmdtVO>();
		List<PriRqRtCmdtRoutVO> routVoList = new ArrayList<PriRqRtCmdtRoutVO>();
		List<PriRqRtRoutPntVO> pntVoList = new ArrayList<PriRqRtRoutPntVO>();
		List<PriRqRtRoutViaVO> viaVoList = new ArrayList<PriRqRtRoutViaVO>();
		List<PriRqRtVO> rtVoList = new ArrayList<PriRqRtVO>();

		try {
			int nextCmdtHdrSeq = dbDao.searchPriRqRtCmdtHdrMaxSeq(priRqRtCmdtHdrVO);
			nextCmdtHdrSeq = nextCmdtHdrSeq - 1;

			int nextCmdtSeq = 0;
			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;

			String strQttnNo = priRqRtCmdtHdrVO.getQttnNo();
			String strQttnVerNo = priRqRtCmdtHdrVO.getQttnVerNo();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();

			for (int i = 0; i < rsltRtListVerticalExcelVOs.length; i++) {
				RsltRtListVerticalExcelVO row = rsltRtListVerticalExcelVOs[i];

				String strCmdtDpSeq = row.getCmdtDpSeq();
				String strCmdtCd = row.getPrcCmdtDefCd();

				String strRoutDpSeq = row.getRoutDpSeq();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				String strDestPrcTrspModCd = row.getDestPrcTrspModNm();

				String strRatUtCd = row.getRatUtCd();
				String strPrcCgoTpCd = row.getPrcCgoTpCd();
				String strCurrCd = "USD";
				String strQttnRtAmt = row.getQttnRtAmt();

				// cmdt hdr
				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextCmdtSeq = 0;
					nextRoutSeq = 0;

					PriRqRtCmdtHdrVO cmdtHdr = new PriRqRtCmdtHdrVO();
					cmdtHdr.setQttnNo(strQttnNo);
					cmdtHdr.setQttnVerNo(strQttnVerNo);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setSrcInfoCd("NW");
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);

					cmdtHdrVoList.add(cmdtHdr);
				}

				// cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;

					String cmdtTpCd = "";
					if (strCmdtCd.length() == 6)
						cmdtTpCd = "C";
					else if (strCmdtCd.length() == 5)
						cmdtTpCd = "G";
					else if (strCmdtCd.length() == 4)
						cmdtTpCd = "R";

					PriRqRtCmdtVO cmdt = new PriRqRtCmdtVO();
					cmdt.setQttnNo(strQttnNo);
					cmdt.setQttnVerNo(strQttnVerNo);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setSrcInfoCd("NW");
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);

					cmdtVoList.add(cmdt);
				}

				// cmdt rout
				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;

					PriRqRtCmdtRoutVO rout = new PriRqRtCmdtRoutVO();
					rout.setQttnNo(strQttnNo);
					rout.setQttnVerNo(strQttnVerNo);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);

					routVoList.add(rout);
				}

				// pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = "";

					if (strOrgPntCd.length() == 5)
						locTpCd = "L";
					else if (strOrgPntCd.length() == 4)
						locTpCd = "G";
					else if (strOrgPntCd.length() == 3)
						locTpCd = "R";
					else if (strOrgPntCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutPntVO pnt = new PriRqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("O");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strOrgPntCd);
					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
					pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
					pnt.setSrcInfoCd("NW");
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					pntVoList.add(pnt);
				}

				// via origin
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					nextRoutViaSeq++;

					String locTpCd = "";

					if (strOrgViaCd.length() == 5)
						locTpCd = "L";
					else if (strOrgViaCd.length() == 4)
						locTpCd = "G";
					else if (strOrgViaCd.length() == 3)
						locTpCd = "R";
					else if (strOrgViaCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutViaVO via = new PriRqRtRoutViaVO();
					via.setQttnNo(strQttnNo);
					via.setQttnVerNo(strQttnVerNo);
					via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					via.setRoutSeq(String.valueOf(nextRoutSeq));
					via.setOrgDestTpCd("O");
					via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
					via.setRoutViaPortTpCd(locTpCd);
					via.setRoutViaPortDefCd(strOrgViaCd);
					via.setSrcInfoCd("NW");
					via.setCreUsrId(strCreUsrId);
					via.setUpdUsrId(strUpdUsrId);

					viaVoList.add(via);
				}

				// via dest
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					nextRoutViaSeq++;

					String locTpCd = "";

					if (strDestViaCd.length() == 5)
						locTpCd = "L";
					else if (strDestViaCd.length() == 4)
						locTpCd = "G";
					else if (strDestViaCd.length() == 3)
						locTpCd = "R";
					else if (strDestViaCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutViaVO via = new PriRqRtRoutViaVO();
					via.setQttnNo(strQttnNo);
					via.setQttnVerNo(strQttnVerNo);
					via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					via.setRoutSeq(String.valueOf(nextRoutSeq));
					via.setOrgDestTpCd("D");
					via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
					via.setRoutViaPortTpCd(locTpCd);
					via.setRoutViaPortDefCd(strDestViaCd);
					via.setSrcInfoCd("NW");
					via.setCreUsrId(strCreUsrId);
					via.setUpdUsrId(strUpdUsrId);

					viaVoList.add(via);
				}

				// pnt dest
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = "";

					if (strDestPntCd.length() == 5)
						locTpCd = "L";
					else if (strDestPntCd.length() == 4)
						locTpCd = "G";
					else if (strDestPntCd.length() == 3)
						locTpCd = "R";
					else if (strDestPntCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutPntVO pnt = new PriRqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("D");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strDestPntCd);
					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
					pnt.setPrcTrspModCd(strDestPrcTrspModCd);
					pnt.setSrcInfoCd("NW");
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					pntVoList.add(pnt);
				}

				// rate
				if (strQttnRtAmt != null && !"".equals(strQttnRtAmt)) {
					nextRtSeq++;

					PriRqRtVO rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd(strRatUtCd);
					rt.setPrcCgoTpCd(strPrcCgoTpCd);
					rt.setCurrCd(strCurrCd);
					rt.setQttnInitRtAmt(strQttnRtAmt);
					rt.setQttnRtAmt(strQttnRtAmt);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rtVoList.add(rt);
				}

			}

			if (cmdtHdrVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityHeaderS(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityS(cmdtVoList);
			}
			if (routVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityRouteS(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addRfaQuotationRoutePointS(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addRfaQuotationRouteViaS(viaVoList);
			}
			if (rtVoList.size() > 0) {
				dbDao.addRfaQuotationRateS(rtVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * RFA Rate LOAD EXCEL(ESM_PRI_6057) 정보 정합성을 체크한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVertical(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs) throws EventException {
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();

		try {
			for (int i = 0; i < rsltRtListVerticalExcelVOs.length; i++) {
				RsltRtListVerticalExcelVO row = rsltRtListVerticalExcelVOs[i];

				String strCmdtCd = row.getPrcCmdtDefCd();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();

				// cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strCmdtCd);

					RsltCdListVO cdVO = dbDao.searchCheckCommodityCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCmdtCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("prc_cmdt_def_cd");

						rslt.add(cdVO);
					}
				}

				// pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strOrgPntCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strOrgViaCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strDestViaCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strDestPntCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}

		return rslt;
	}

	/**
	 * Calculate Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @param String rotationPrsBatId
	 * @param SignOnUserAccount account
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO executeCalculate(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO, String rotationPrsBatId, SignOnUserAccount account) throws EventException {
		try {
			// 컨테이너 vo
			// RateQuotationVO rateQuotationVO = new RateQuotationVO();
			ScheduleUtil schedule = new ScheduleUtil();

			PriPrsBatVO priPrsBatVO = null;
			List<PriRqMnVO> priRqMnVOList;
			PriRqMnVO priRqMnVO = new PriRqMnVO();
			String params = "";
			String jobID = "";
			String pgmNm = "";

			priRqMnVO.setQttnNo(priRqRtCmdtRoutVO.getQttnNo());
			priRqMnVO.setQttnVerNo(priRqRtCmdtRoutVO.getQttnVerNo());

			priRqMnVOList = dbDao.searchPriRqMn(priRqMnVO);
			if (priRqMnVOList.size() != 0) {
				params = priRqRtCmdtRoutVO.getQttnNo() + "#" + priRqRtCmdtRoutVO.getQttnVerNo() + "#" + priRqMnVOList.get(0).getSvcScpCd() + "#"
						+ priRqMnVOList.get(0).getCustCntCd() + "#" + priRqMnVOList.get(0).getCustSeq() + "#" + account.getUsr_id();

				/********************************************************************/

				if (rotationPrsBatId.length() == 1) {
					pgmNm = "0" + rotationPrsBatId;
				} else {
					pgmNm = rotationPrsBatId;
				}
				pgmNm = "ESM_PRI_B008-" + pgmNm;
				log.debug("== pgmNm == " + pgmNm);
				if (!schedule.isRunning(pgmNm)) {
					jobID = schedule.directExecuteJob(pgmNm, params);

					priPrsBatVO = new PriPrsBatVO();
					priPrsBatVO.setPrsBatId(jobID);
					priPrsBatVO.setParaInfoCtnt(params);
					priPrsBatVO.setPgmNo(pgmNm);
				} else {
					throw new EventException(new ErrorHandler("PRI03027", new String[] {}).getMessage());
				}
				log.debug("== jobID == " + jobID);
				/********************************************************************/

				// jobID = schedule.directExecuteJob("ESM_PRI_B008", params);
				//
				// priPrsBatVO = new PriPrsBatVO();
				// priPrsBatVO.setPrsBatId(jobID);
				// priPrsBatVO.setParaInfoCtnt(params);
				// priPrsBatVO.setPgmNo("ESM_PRI_B008");

			}
			return priPrsBatVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * Calculate Batch ID를 조회 하기 위한 Parameter를 조합한다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO searchMonitorCalculateParam(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws EventException {
		try {
			PriPrsBatVO priPrsBatVO = null;
			List<PriRqMnVO> priRqMnVOList;
			PriRqMnVO priRqMnVO = new PriRqMnVO();
			String params = "";

			// 조회불가 메시지
			if (priRqRtCmdtRoutVO.getQttnNo() == null || priRqRtCmdtRoutVO.getQttnVerNo() == null) {
				throw new EventException(new ErrorHandler("PRI02014").getMessage());
			}
			priRqMnVO.setQttnNo(priRqRtCmdtRoutVO.getQttnNo());
			priRqMnVO.setQttnVerNo(priRqRtCmdtRoutVO.getQttnVerNo());

			priRqMnVOList = dbDao.searchPriRqMn(priRqMnVO);

			if (priRqMnVOList.size() != 0) {
				params = priRqRtCmdtRoutVO.getQttnNo() + "#" + priRqRtCmdtRoutVO.getQttnVerNo() + "#" + priRqMnVOList.get(0).getSvcScpCd() + "#"
						+ priRqMnVOList.get(0).getCustCntCd() + "#" + priRqMnVOList.get(0).getCustSeq() + "#"; // USER ID정보는 parameter 정보에서 빼고 like 검색으로 batch id를 검색한다.

				priPrsBatVO = new PriPrsBatVO();
				priPrsBatVO.setParaInfoCtnt(params);
				priPrsBatVO.setPgmNo("ESM_PRI_B008");

			} else { // 조회 불가 메시지
				throw new EventException(new ErrorHandler("PRI02014").getMessage());
			}
			return priPrsBatVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
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
			if (prsBatchVO != null) {
				status = su.getJobStatus(prsBatchVO.getPrsBatId(), prsBatchVO.getPgmNo());
				if (status == 0) {
					float min = Float.valueOf(prsBatchVO.getExecMinutes());
					if (Float.compare(min, 10.0f) > 0) { // 10분이 지다도 0이 return될때 Batch 서버가 해당 Calc를 돌려주지 못했다고 판단한다. Code 99
						status = 99;
					} else {
						// 기존에 nothing으로 표현 하던 내용으로 pri_prs_bat에는 데이터가 있으나 batch에서 null을 return할때는 Running...으로 표현한다.
						status = 80;
					}
					log.debug(" =================  status === " + status);
				}
			}

			return String.valueOf(status);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * Rate Route Case를 추가 한다. .<br>
	 * 
	 * @param PriRqRtUsdRoutCsVO priRqRtUsdRoutCsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriRateUsedRouteCase(PriRqRtUsdRoutCsVO priRqRtUsdRoutCsVO, SignOnUserAccount account) throws EventException {
		try {
			List<PriRqRtUsdRoutCsVO> priRqRtUsdRoutCsVOs = new ArrayList<PriRqRtUsdRoutCsVO>();
			if (priRqRtUsdRoutCsVO != null) {
				priRqRtUsdRoutCsVO.setUpdUsrId(account.getUsr_id());
				priRqRtUsdRoutCsVO.setUsdRoutCsSelFlg("Y");
				priRqRtUsdRoutCsVOs.add(priRqRtUsdRoutCsVO);
			}
			dbDao.addPriRateUsedRouteCase(priRqRtUsdRoutCsVOs);
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
	public List<RsltPriCostSimulationCheckRouteVO> searchCostSimulationCheckRoutList(InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO) throws EventException {
		try {
			List<RsltPriCostSimulationCheckRouteVO> rsltPriCostSimulationCheckRouteVOs = dbDao.searchCostSimulationCheckRoutList(inCostSimulationCheckRouteVO);

			return rsltPriCostSimulationCheckRouteVOs;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * S/C Quotation - Rate Tab의 Surcharge View All Popup의 내용을 조회를 처리합니다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltPriSurchargeViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeViewAllVO> searchSurchargeViewAllList(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchSurchargeViewAllList(priRqRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * S/C Quotation - Rate Tab의 Surcharge View All Popup에서 Surcharge 값이 언제 만들어 졌는지를 조회 처리합니다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltPriSurchargeLastAccessDateVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeLastAccessDateVO> searchSurchargeLastAccessDateList(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchSurchargeLastAccessDateList(priRqRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 을 조회 합니다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltPriRqRtCmdtVO>
	 * @exception EventException
	 */
	public List<RsltPriRqRtCmdtVO> searchRfaRateQuotationListForIHC(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchPriRqRtCmdtGrpList(priRqRtCmdtHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * ESM_PRI_6014_03 : Rate Commodify Sequence <br>
	 * Rate Commodify Sequence<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return int
	 * @exception EventException
	 */
	public int searchRateCommoditySequence(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateCommoditySequence(priRqRtCmdtHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 입력 수정 삭제한다<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCommodityRouteRateRfaRateQuotationForIHC(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException {
		try {
			// 컨테이너 vo에서 CMDT_HDR, CMDT 뺀다
			PriRqRtCmdtHdrVO[] priRqRtCmdtHdrVOs = rateQuotationVO.getPriRqRtCmdtHdrVOs();
			PriRqRtCmdtVO[] priRqRtCmdtVOs = rateQuotationVO.getPriRqRtCmdtVOs();

			List<PriRqRtCmdtHdrVO> insertVoList = new ArrayList<PriRqRtCmdtHdrVO>();
			List<PriRqRtCmdtHdrVO> updateVoList = new ArrayList<PriRqRtCmdtHdrVO>();
			List<PriRqRtCmdtHdrVO> deleteVoList = new ArrayList<PriRqRtCmdtHdrVO>();
			List<PriRqRtCmdtVO> insertDtlVoList = new ArrayList<PriRqRtCmdtVO>();
			List<PriRqRtCmdtVO> updateDtlVoList = new ArrayList<PriRqRtCmdtVO>();
			List<PriRqRtCmdtVO> deleteDtlVoList = new ArrayList<PriRqRtCmdtVO>();

			// //////////////////////////CMDT_HDR / CMDT 저장/////////////////////////////////////

			// CMDT_HDR
			for (int i = 0; priRqRtCmdtHdrVOs != null && i < priRqRtCmdtHdrVOs.length; i++) {
				if (priRqRtCmdtHdrVOs[i].getIbflag().equals("I")) {
					priRqRtCmdtHdrVOs[i].setCreUsrId(account.getUsr_id());
					priRqRtCmdtHdrVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRqRtCmdtHdrVOs[i]);
				} else if (priRqRtCmdtHdrVOs[i].getIbflag().equals("U")) {
					priRqRtCmdtHdrVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRqRtCmdtHdrVOs[i]);
				} else if (priRqRtCmdtHdrVOs[i].getIbflag().equals("D")) {
					priRqRtCmdtHdrVOs[i].setUpdUsrId(account.getUsr_id());

					// qttn no, qttn ver no 별 삭제
					PriRqRtCmdtHdrVO delPriRqRtCmdtHdrVO = new PriRqRtCmdtHdrVO();
					delPriRqRtCmdtHdrVO.setQttnNo(priRqRtCmdtHdrVOs[i].getQttnNo());
					delPriRqRtCmdtHdrVO.setQttnVerNo(priRqRtCmdtHdrVOs[i].getQttnVerNo());
					delPriRqRtCmdtHdrVO.setCmdtHdrSeq(priRqRtCmdtHdrVOs[i].getCmdtHdrSeq());
					delPriRqRtCmdtHdrVO.setFicRtTpCd(rateQuotationVO.getFicRtTpCd());
					// cmdt 삭제
					dbDao.removeRfaQuotationCommodity(delPriRqRtCmdtHdrVO);

					PriRqRtCmdtRoutVO delPriRqRtCmdtRoutVO = new PriRqRtCmdtRoutVO();
					delPriRqRtCmdtRoutVO.setQttnNo(priRqRtCmdtHdrVOs[i].getQttnNo());
					delPriRqRtCmdtRoutVO.setQttnVerNo(priRqRtCmdtHdrVOs[i].getQttnVerNo());
					delPriRqRtCmdtRoutVO.setCmdtHdrSeq(priRqRtCmdtHdrVOs[i].getCmdtHdrSeq());

					// detail 삭제
					removeRouteRateRfaRateQuotationByRout(delPriRqRtCmdtRoutVO);
					// hdr 삭제
					dbDao.removeRfaQuotationCommodityHeader(priRqRtCmdtHdrVOs[i]);

					// 이미 삭제 했으므로 null 세팅
					priRqRtCmdtVOs = null;
				}
			}

			// CMDT
			for (int k = 0; priRqRtCmdtVOs != null && k < priRqRtCmdtVOs.length; k++) {
				priRqRtCmdtVOs[k].setCreUsrId(account.getUsr_id());
				priRqRtCmdtVOs[k].setUpdUsrId(account.getUsr_id());
				insertDtlVoList.add(priRqRtCmdtVOs[k]);
			}

			if (deleteDtlVoList.size() > 0) {
				dbDao.removeRfaQuotationCommodityS(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeRfaQuotationCommodityHeaderS(deleteVoList);
			}

			if (insertVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityHeaderS(insertVoList);
			}

			if (insertDtlVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityS(insertDtlVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRfaQuotationCommodityHeaderS(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyRfaQuotationCommodityS(updateDtlVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * PRI_RQ_RT_CMDT_ROUT, PRI_RQ_RT_ROUT_PNT, PRI_RQ_RT_ROUT_VIA, PRI_RQ_RT 입력 수정 삭제한다<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRouteRateRfaRateQuotationForIHC(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException {
		try {
			PriRqRtCmdtRoutVO[] priRqRtCmdtRoutVOs = rateQuotationVO.getPriRqRtCmdtRoutVOs();
			PriRqRtRoutPntVO[] priRqRtRoutOrgPntVOs = rateQuotationVO.getPriRqRtRoutOrgPntVOs();
			PriRqRtRoutPntVO[] priRqRtRoutDestPntVOs = rateQuotationVO.getPriRqRtRoutDestPntVOs();
			PriRqRtRoutViaVO[] priRqRtRoutOrgViaVOs = rateQuotationVO.getPriRqRtRoutOrgViaVOs();
			PriRqRtRoutViaVO[] priRqRtRoutDestViaVOs = rateQuotationVO.getPriRqRtRoutDestViaVOs();
			PriRqRtVO[] priRqRtVOs = rateQuotationVO.getPriRqRtVOs();
			for (int i = 0; priRqRtCmdtRoutVOs != null && i < priRqRtCmdtRoutVOs.length; i++) {
				if (priRqRtCmdtRoutVOs[i].getIbflag().equals("I")) {
					priRqRtCmdtRoutVOs[i].setCreUsrId(account.getUsr_id());
					priRqRtCmdtRoutVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.addRfaQuotationCommodityRoute(priRqRtCmdtRoutVOs[i]);
				} else if (priRqRtCmdtRoutVOs[i].getIbflag().equals("U")) {
					priRqRtCmdtRoutVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyRfaQuotationCommodityRoute(priRqRtCmdtRoutVOs[i]);
				} else if (priRqRtCmdtRoutVOs[i].getIbflag().equals("D")) {
					removeRouteRateRfaRateQuotationByRout(priRqRtCmdtRoutVOs[i]);
				}
			}

			// OrgRoutPnt
			PriRqRtRoutPntVO delPriRqRtRoutPntVO = new PriRqRtRoutPntVO();
			for (int i = 0; priRqRtRoutOrgPntVOs != null && i < priRqRtRoutOrgPntVOs.length; i++) {
				if (i == 0) {
					delPriRqRtRoutPntVO.setQttnNo(priRqRtRoutDestPntVOs[i].getQttnNo());
					delPriRqRtRoutPntVO.setQttnVerNo(priRqRtRoutDestPntVOs[i].getQttnVerNo());
					delPriRqRtRoutPntVO.setCmdtHdrSeq(priRqRtRoutDestPntVOs[i].getCmdtHdrSeq());
					delPriRqRtRoutPntVO.setRoutSeq(priRqRtRoutDestPntVOs[i].getRoutSeq());
					delPriRqRtRoutPntVO.setOrgDestTpCd("O");
					dbDao.removeRfaQuotationRoutePoint(delPriRqRtRoutPntVO);
				}
				priRqRtRoutOrgPntVOs[i].setRoutPntSeq(String.valueOf(i + 1));
				priRqRtRoutOrgPntVOs[i].setCreUsrId(account.getUsr_id());
				priRqRtRoutOrgPntVOs[i].setUpdUsrId(account.getUsr_id());
				dbDao.addRfaQuotationRoutePoint(priRqRtRoutOrgPntVOs[i]);
			}

			PriRqRtRoutViaVO delPriRqRtRoutViaVO = new PriRqRtRoutViaVO();
			delPriRqRtRoutViaVO.setQttnNo(delPriRqRtRoutPntVO.getQttnNo());
			delPriRqRtRoutViaVO.setQttnVerNo(delPriRqRtRoutPntVO.getQttnVerNo());
			delPriRqRtRoutViaVO.setCmdtHdrSeq(delPriRqRtRoutPntVO.getCmdtHdrSeq());
			delPriRqRtRoutViaVO.setRoutSeq(delPriRqRtRoutPntVO.getRoutSeq());
			delPriRqRtRoutViaVO.setOrgDestTpCd("O");
			dbDao.removeRfaQuotationRouteVia(delPriRqRtRoutViaVO);
			// OrgRoutVia
			for (int i = 0; priRqRtRoutOrgViaVOs != null && i < priRqRtRoutOrgViaVOs.length; i++) {
				priRqRtRoutOrgViaVOs[i].setRoutViaSeq(String.valueOf(i + 1));
				priRqRtRoutOrgViaVOs[i].setCreUsrId(account.getUsr_id());
				priRqRtRoutOrgViaVOs[i].setUpdUsrId(account.getUsr_id());
				dbDao.addRfaQuotationRouteVia(priRqRtRoutOrgViaVOs[i]);
			}

			delPriRqRtRoutViaVO.setOrgDestTpCd("D");
			dbDao.removeRfaQuotationRouteVia(delPriRqRtRoutViaVO);
			// DestRoutVia
			for (int i = 0; priRqRtRoutDestViaVOs != null && i < priRqRtRoutDestViaVOs.length; i++) {
				priRqRtRoutDestViaVOs[i].setRoutViaSeq(String.valueOf(i + 1));
				priRqRtRoutDestViaVOs[i].setCreUsrId(account.getUsr_id());
				priRqRtRoutDestViaVOs[i].setUpdUsrId(account.getUsr_id());
				dbDao.addRfaQuotationRouteVia(priRqRtRoutDestViaVOs[i]);
			}

			// DestRoutPnt
			for (int i = 0; priRqRtRoutDestPntVOs != null && i < priRqRtRoutDestPntVOs.length; i++) {
				if (i == 0) {
					// rout seq 별로 모두 삭제 후 입력
					delPriRqRtRoutPntVO = new PriRqRtRoutPntVO();
					delPriRqRtRoutPntVO.setQttnNo(priRqRtRoutDestPntVOs[i].getQttnNo());
					delPriRqRtRoutPntVO.setQttnVerNo(priRqRtRoutDestPntVOs[i].getQttnVerNo());
					delPriRqRtRoutPntVO.setCmdtHdrSeq(priRqRtRoutDestPntVOs[i].getCmdtHdrSeq());
					delPriRqRtRoutPntVO.setRoutSeq(priRqRtRoutDestPntVOs[i].getRoutSeq());
					delPriRqRtRoutPntVO.setOrgDestTpCd("D");
					dbDao.removeRfaQuotationRoutePoint(delPriRqRtRoutPntVO);

				}
				priRqRtRoutDestPntVOs[i].setRoutPntSeq(String.valueOf(i + 1));
				priRqRtRoutDestPntVOs[i].setCreUsrId(account.getUsr_id());
				priRqRtRoutDestPntVOs[i].setUpdUsrId(account.getUsr_id());
				dbDao.addRfaQuotationRoutePoint(priRqRtRoutDestPntVOs[i]);
			}

			// PRI_RQ_RT
			for (int i = 0; priRqRtVOs != null && i < priRqRtVOs.length; i++) {
				if (priRqRtVOs[i].getIbflag().equals("I")) {
					priRqRtVOs[i].setCreUsrId(account.getUsr_id());
					priRqRtVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.addRfaQuotationRate(priRqRtVOs[i]);
				} else if (priRqRtVOs[i].getIbflag().equals("U")) {
					priRqRtVOs[i].setCreUsrId(account.getUsr_id());
					priRqRtVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyRfaQuotationRate(priRqRtVOs[i]);
				} else if (priRqRtVOs[i].getIbflag().equals("D")) {
					dbDao.removeRfaQuotationRate(priRqRtVOs[i]);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * PRI_RQ_RT_ROUT_PNT,PRI_RQ_RT_ROUT_VIA,PRI_RQ_RT 을 조회 합니다.<br>
	 * 
	 * @param RFARateQuotationVO inRateQuotationVO
	 * @return RFARateQuotationVO
	 * @exception EventException
	 */
	public RFARateQuotationVO searchRateListForIHC(RFARateQuotationVO inRateQuotationVO) throws EventException {
		try {
			PriRqRtCmdtRoutVO priRqRtCmdtRoutVO = inRateQuotationVO.getPriRqRtCmdtRoutVO();
			// 컨테이너 vo
			RFARateQuotationVO rateQuotationVO = new RFARateQuotationVO();
			// detail List
			List<RsltPriRqRtCmdtVO> rsltPriRqRtCmdtVOList = new ArrayList<RsltPriRqRtCmdtVO>();
			List<RsltPriRqRtRoutOrgPntVO> rsltPriRqRtRoutOrgPntVOList = new ArrayList<RsltPriRqRtRoutOrgPntVO>();
			List<RsltPriRqRtRoutDestPntVO> rsltPriRqRtRoutDestPntVOList = new ArrayList<RsltPriRqRtRoutDestPntVO>();
			List<RsltPriRqRtRoutViaVO> rsltPriRqRtRoutOrgViaVOList = new ArrayList<RsltPriRqRtRoutViaVO>();
			List<RsltPriRqRtRoutViaVO> rsltPriRqRtRoutDestViaVOList = new ArrayList<RsltPriRqRtRoutViaVO>();
			List<RsltPriRqRtVO> rsltPriRqRtVOList = new ArrayList<RsltPriRqRtVO>();

			rsltPriRqRtCmdtVOList = dbDao.searchPriRqRtCmdtVOList(priRqRtCmdtRoutVO, inRateQuotationVO.getFicRtTpCd());
			rsltPriRqRtRoutOrgPntVOList = dbDao.searchPriRqRtRoutOrgPntVOList(priRqRtCmdtRoutVO);
			rsltPriRqRtRoutDestPntVOList = dbDao.searchPriRqRtRoutDestPntVOList(priRqRtCmdtRoutVO);
			rsltPriRqRtRoutOrgViaVOList = dbDao.searchPriRqRtRoutOrgViaVOList(priRqRtCmdtRoutVO);
			rsltPriRqRtRoutDestViaVOList = dbDao.searchPriRqRtRoutDestViaVOList(priRqRtCmdtRoutVO);
			rsltPriRqRtVOList = dbDao.searchPriRqRtVOList(priRqRtCmdtRoutVO);

			rateQuotationVO.setRsltPriRqRtCmdtVOList(rsltPriRqRtCmdtVOList);
			rateQuotationVO.setRsltPriRqRtRoutOrgPntVOs(rsltPriRqRtRoutOrgPntVOList);
			rateQuotationVO.setRsltPriRqRtRoutDestPntVOs(rsltPriRqRtRoutDestPntVOList);
			rateQuotationVO.setRsltPriRqRtRoutOrgViaVOList(rsltPriRqRtRoutOrgViaVOList);
			rateQuotationVO.setRsltPriRqRtRoutDestViaVOList(rsltPriRqRtRoutDestViaVOList);
			rateQuotationVO.setRsltPriRqRtVOList(rsltPriRqRtVOList);

			return rateQuotationVO;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * FIC Route Group을 조회한다.<br>
	 * 
	 * @param FicRouteGroupVO ficRouteGroupVO
	 * @param boolean addOnFlag
	 * @return List<FicRouteGroupVO>
	 * @exception EventException
	 */
	public List<FicRouteGroupVO> searchFicRouteGroup(FicRouteGroupVO ficRouteGroupVO, boolean addOnFlag) throws EventException {
		try {
			return dbDao.searchFicRouteGroup(ficRouteGroupVO, addOnFlag);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * location code또는 group location code에 CY가 포함돼 있는 확인한다.<br>
	 * 
	 * @param FicCheckCYPortLocationVO ficCheckCYPortLocationVO
	 * @return List<RsltFicCheckCYPortLocationVO>
	 * @exception EventException
	 */
	public List<RsltFicCheckCYPortLocationVO> checkCYPortLocationCode(FicCheckCYPortLocationVO ficCheckCYPortLocationVO) throws EventException {
		try {
			return dbDao.searchCYPortLocationCode(ficCheckCYPortLocationVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN VerticalExcel)<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @return List<RsltRtListVerticalExcelForIHCVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelForIHCVO> searchRateListVerticalExcelForIHC(RFARateQuotationVO rfaRateQuotationVO) throws EventException {
		try {
			return dbDao.searchRateListVerticalExcelForIHC(rfaRateQuotationVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN Horizontal)<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @return List<RsltRtListHorizontalExcelForIHCVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelForIHCVO> searchRateListHorizontalExcelForIHC(RFARateQuotationVO rfaRateQuotationVO) throws EventException {
		try {
			return dbDao.searchRateListHorizontalExcelForIHC(rfaRateQuotationVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * RFA Rate LOAD EXCEL(ESM_PRI_6095) 정보를 저장한다.<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVerticalForIHC(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException {

		List<PriRqRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRqRtCmdtHdrVO>();
		List<PriRqRtCmdtVO> cmdtVoList = new ArrayList<PriRqRtCmdtVO>();
		List<PriRqRtCmdtRoutVO> routVoList = new ArrayList<PriRqRtCmdtRoutVO>();
		List<PriRqRtRoutPntVO> pntVoList = new ArrayList<PriRqRtRoutPntVO>();
		List<PriRqRtRoutViaVO> viaVoList = new ArrayList<PriRqRtRoutViaVO>();
		List<PriRqRtVO> rtVoList = new ArrayList<PriRqRtVO>();

		try {
			PriRqRtCmdtHdrVO priRqRtCmdtHdrVO = rateQuotationVO.getPriRqRtCmdtHdrVO();
			RsltRtListVerticalExcelForIHCVO[] rsltRtListVerticalExcelForIHCVOs = rateQuotationVO.getRsltRtListVerticalExcelForIHCVOs();

			int nextCmdtHdrSeq = dbDao.searchPriRqRtCmdtHdrMaxSeq(priRqRtCmdtHdrVO);
			nextCmdtHdrSeq = nextCmdtHdrSeq - 1;

			int nextCmdtSeq = 0;
			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;

			String strQttnNo = priRqRtCmdtHdrVO.getQttnNo();
			String strQttnVerNo = priRqRtCmdtHdrVO.getQttnVerNo();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();
			String strSvcScpCd = rateQuotationVO.getSvcScpCd();
			String strFicRtTpCd = rateQuotationVO.getFicRtTpCd();

			for (int i = 0; i < rsltRtListVerticalExcelForIHCVOs.length; i++) {
				RsltRtListVerticalExcelForIHCVO row = rsltRtListVerticalExcelForIHCVOs[i];

				String strCmdtDpSeq = row.getCmdtDpSeq();
				String strCmdtCd = row.getPrcCmdtDefCd();

				String strRoutDpSeq = row.getRoutDpSeq();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				String strDestPrcTrspModCd = row.getDestPrcTrspModNm();

				String strRatUtCd = row.getRatUtCd();
				String strPrcCgoTpCd = row.getPrcCgoTpCd();
				String strCurrCd = "USD";
				String strQttnRtAmt = row.getQttnRtAmt();

				String strBsePortLocCd = row.getBsePortLocCd();
				String strFicRoutCmbTpCd = row.getFicRoutCmbTpCd();
				String strFicGlineRtAmt = row.getFicGlineRtAmt();
				String strFicQttnRtAmt = row.getFicQttnRtAmt();
				String strFicRtUseStsCd = row.getFicRtUseStsCd();

				// cmdt hdr
				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextCmdtSeq = 0;
					nextRoutSeq = 0;

					PriRqRtCmdtHdrVO cmdtHdr = new PriRqRtCmdtHdrVO();
					cmdtHdr.setQttnNo(strQttnNo);
					cmdtHdr.setQttnVerNo(strQttnVerNo);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setSrcInfoCd("NW");
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);
					cmdtHdr.setFicRtTpCd(strFicRtTpCd);
					cmdtHdrVoList.add(cmdtHdr);
				}

				// cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;

					String cmdtTpCd = "";
					if (strCmdtCd.length() == 6)
						cmdtTpCd = "C";
					else if (strCmdtCd.length() == 5)
						cmdtTpCd = "G";
					else if (strCmdtCd.length() == 4)
						cmdtTpCd = "R";

					PriRqRtCmdtVO cmdt = new PriRqRtCmdtVO();
					cmdt.setQttnNo(strQttnNo);
					cmdt.setQttnVerNo(strQttnVerNo);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setSrcInfoCd("NW");
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);

					cmdtVoList.add(cmdt);
				}

				// cmdt rout
				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;

					PriRqRtCmdtRoutVO rout = new PriRqRtCmdtRoutVO();
					rout.setQttnNo(strQttnNo);
					rout.setQttnVerNo(strQttnVerNo);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);
					routVoList.add(rout);
				}

				// pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = "";

					if (strOrgPntCd.length() == 5)
						locTpCd = "L";
					else if (strOrgPntCd.length() == 4)
						locTpCd = "G";
					else if (strOrgPntCd.length() == 3)
						locTpCd = "R";
					else if (strOrgPntCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutPntVO pnt = new PriRqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("O");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strOrgPntCd);
					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
					pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
					pnt.setSrcInfoCd("NW");
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					if ("AEE".equals(strSvcScpCd)) {
						pnt.setBsePortLocCd(strBsePortLocCd);
						pnt.setFicRoutCmbTpCd(strFicRoutCmbTpCd);
					}

					pntVoList.add(pnt);
				}

				// via origin
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					boolean dupChk = false;
					if ("AEE".equals(strSvcScpCd)) {
						dupChk = duplicateRouteVia(viaVoList, strQttnNo, strQttnVerNo, nextCmdtHdrSeq, nextRoutSeq, strOrgViaCd);
					}
					if (!dupChk) {
						nextRoutViaSeq++;

						String locTpCd = "";

						if (strOrgViaCd.length() == 5)
							locTpCd = "L";
						else if (strOrgViaCd.length() == 4)
							locTpCd = "G";
						else if (strOrgViaCd.length() == 3)
							locTpCd = "R";
						else if (strOrgViaCd.length() == 2)
							locTpCd = "C";

						PriRqRtRoutViaVO via = new PriRqRtRoutViaVO();
						via.setQttnNo(strQttnNo);
						via.setQttnVerNo(strQttnVerNo);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("O");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strOrgViaCd);
						via.setSrcInfoCd("NW");
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}

				// via dest
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					boolean dupChk = false;
					if ("AEE".equals(strSvcScpCd)) {
						dupChk = duplicateRouteVia(viaVoList, strQttnNo, strQttnVerNo, nextCmdtHdrSeq, nextRoutSeq, strDestViaCd);
					}
					if (!dupChk) {
						nextRoutViaSeq++;

						String locTpCd = "";

						if (strDestViaCd.length() == 5)
							locTpCd = "L";
						else if (strDestViaCd.length() == 4)
							locTpCd = "G";
						else if (strDestViaCd.length() == 3)
							locTpCd = "R";
						else if (strDestViaCd.length() == 2)
							locTpCd = "C";

						PriRqRtRoutViaVO via = new PriRqRtRoutViaVO();
						via.setQttnNo(strQttnNo);
						via.setQttnVerNo(strQttnVerNo);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("D");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strDestViaCd);
						via.setSrcInfoCd("NW");
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}

				// pnt dest
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = "";

					if (strDestPntCd.length() == 5)
						locTpCd = "L";
					else if (strDestPntCd.length() == 4)
						locTpCd = "G";
					else if (strDestPntCd.length() == 3)
						locTpCd = "R";
					else if (strDestPntCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutPntVO pnt = new PriRqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("D");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strDestPntCd);
					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
					pnt.setPrcTrspModCd(strDestPrcTrspModCd);
					pnt.setSrcInfoCd("NW");
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);
					if ("AEW".equals(strSvcScpCd)) {
						pnt.setBsePortLocCd(strBsePortLocCd);
						pnt.setFicRoutCmbTpCd(strFicRoutCmbTpCd);
					}
					pntVoList.add(pnt);
				}

				// rate
				if (strQttnRtAmt != null && !"".equals(strQttnRtAmt)) {
					nextRtSeq++;
					PriRqRtVO rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd(strRatUtCd);
					rt.setPrcCgoTpCd(strPrcCgoTpCd);
					rt.setCurrCd(strCurrCd);
					rt.setQttnInitRtAmt(strQttnRtAmt);
					rt.setQttnRtAmt(strQttnRtAmt);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);
					rt.setFicGlineRtAmt(strFicGlineRtAmt);
					rt.setFicQttnRtAmt(strFicQttnRtAmt);
					rt.setFicRtUseStsCd(strFicRtUseStsCd);
					rtVoList.add(rt);
				}

			}

			if (cmdtHdrVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityHeaderS(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityS(cmdtVoList);
			}
			if (routVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityRouteS(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addRfaQuotationRoutePointS(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addRfaQuotationRouteViaS(viaVoList);
			}
			if (rtVoList.size() > 0) {
				dbDao.addRfaQuotationRateS(rtVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * RFA Rate LOAD EXCEL(ESM_PRI_6057) 정보 정합성을 체크한다.<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVerticalForIHC(RFARateQuotationVO rateQuotationVO) throws EventException {
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();

		try {
			PriRqRtCmdtHdrVO priRqRtCmdtHdrVO = rateQuotationVO.getPriRqRtCmdtHdrVO();
			RsltRtListVerticalExcelForIHCVO[] rsltRtListVerticalExcelForIHCVOs = rateQuotationVO.getRsltRtListVerticalExcelForIHCVOs();

			for (int i = 0; i < rsltRtListVerticalExcelForIHCVOs.length; i++) {
				RsltRtListVerticalExcelForIHCVO row = rsltRtListVerticalExcelForIHCVOs[i];

				String strCmdtCd = row.getPrcCmdtDefCd();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();

				// cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strCmdtCd);

					RsltCdListVO cdVO = dbDao.searchCheckCommodityCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCmdtCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("prc_cmdt_def_cd");

						rslt.add(cdVO);
					}
				}

				// pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strOrgPntCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strOrgViaCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strDestViaCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strDestPntCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}

		return rslt;
	}

	/**
	 * RFA Rate LOAD EXCEL(ESM_PRI_6096) 정보 정합성을 체크한다.<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelHorizontalForIHC(RFARateQuotationVO rateQuotationVO) throws EventException {
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
		PriRqRtCmdtHdrVO priRqRtCmdtHdrVO = rateQuotationVO.getPriRqRtCmdtHdrVO();
		RsltRtListHorizontalExcelForIHCVO[] rsltRtListHorizontalExcelForIHCVO = rateQuotationVO.getRsltRtListHorizontalExcelForIHCVOs();

		try {
			for (int i = 0; i < rsltRtListHorizontalExcelForIHCVO.length; i++) {
				RsltRtListHorizontalExcelForIHCVO row = rsltRtListHorizontalExcelForIHCVO[i];

				String strCmdtCd = row.getPrcCmdtDefCd();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();

				// cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strCmdtCd);

					RsltCdListVO cdVO = dbDao.searchCheckCommodityCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCmdtCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("prc_cmdt_def_cd");
						rslt.add(cdVO);
					}
				}

				// pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strOrgPntCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strOrgViaCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strDestViaCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
					paramVO.setQttnNo(priRqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priRqRtCmdtHdrVO.getQttnVerNo());
					paramVO.setCd(strDestPntCd);

					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
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
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}

		return rslt;
	}

	/**
	 * RQ Rate LOAD EXCEL(ESM_PRI_6096) 정보를 저장한다.<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelHorizontalForIHC(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException {

		List<PriRqRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRqRtCmdtHdrVO>();
		List<PriRqRtCmdtVO> cmdtVoList = new ArrayList<PriRqRtCmdtVO>();
		List<PriRqRtCmdtRoutVO> routVoList = new ArrayList<PriRqRtCmdtRoutVO>();
		List<PriRqRtRoutPntVO> pntVoList = new ArrayList<PriRqRtRoutPntVO>();
		List<PriRqRtRoutViaVO> viaVoList = new ArrayList<PriRqRtRoutViaVO>();
		List<PriRqRtVO> rtVoList = new ArrayList<PriRqRtVO>();

		PriRqRtCmdtHdrVO priRqRtCmdtHdrVO = rateQuotationVO.getPriRqRtCmdtHdrVO();
		RsltRtListHorizontalLoadExcelForIHCVO[] rsltRtListHorizontalLoadExcelForIHCVOs = rateQuotationVO.getRsltRtListHorizontalLoadExcelForIHCVOs();

		try {
			int nextCmdtHdrSeq = dbDao.searchPriRqRtCmdtHdrMaxSeq(priRqRtCmdtHdrVO);
			nextCmdtHdrSeq = nextCmdtHdrSeq - 1;

			int nextCmdtSeq = 0;
			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;

			String strQttnNo = priRqRtCmdtHdrVO.getQttnNo();
			String strQttnVerNo = priRqRtCmdtHdrVO.getQttnVerNo();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();
			String strSvcScpCd = rateQuotationVO.getSvcScpCd();

			for (int i = 0; i < rsltRtListHorizontalLoadExcelForIHCVOs.length; i++) {
				RsltRtListHorizontalLoadExcelForIHCVO row = rsltRtListHorizontalLoadExcelForIHCVOs[i];

				String strCmdtDpSeq = row.getCmdtDpSeq();
				String strCmdtCd = row.getPrcCmdtDefCd();

				String strRoutDpSeq = row.getRoutDpSeq();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				String strDestPrcTrspModCd = row.getDestPrcTrspModNm();

				String strRateDry20 = row.getRateDry20();
				String strRateDry40 = row.getRateDry40();
				String strRateDry40hc = row.getRateDry40hc();
				String strRateDry45 = row.getRateDry45();
				String strRateRf40hc = row.getRateRf40hc();
				String strRateRd40hc = row.getRateRd40hc();

				String strBasePortLocCd = row.getBsePortLocCd();
				String strFicRoutCmbTpCd = row.getFicRoutCmbTpCd();

				String strRatePropDry20 = row.getRatePropDry20();
				String strRatePropDry40 = row.getRatePropDry40();
				String strRatePropDry40hc = row.getRatePropDry40hc();
				String strRatePropDry45 = row.getRatePropDry45();
				String strRatePropRf40hc = row.getRatePropRf40hc();
				String strRatePropRd40hc = row.getRatePropRd40hc();

				String strFicGlineRtAmtRateDry20 = row.getFicGlineRtAmtRateDry20();
				String strFicGlineRtAmtRateDry40 = row.getFicGlineRtAmtRateDry40();
				String strFicGlineRtAmtRateDry40hc = row.getFicGlineRtAmtRateDry40hc();
				String strFicGlineRtAmtRateDry45 = row.getFicGlineRtAmtRateDry45();
				String strFicGlineRtAmtRateRf40hc = row.getFicGlineRtAmtRateRf40hc();
				String strFicGlineRtAmtRateRd40hc = row.getFicGlineRtAmtRateRd40hc();

				String strFicRtUseStsCdRateDry20 = row.getFicRtUseStsCdRateDry20();
				String strFicRtUseStsCdRateDry40 = row.getFicRtUseStsCdRateDry40();
				String strFicRtUseStsCdRateDry40hc = row.getFicRtUseStsCdRateDry40hc();
				String strFicRtUseStsCdRateDry45 = row.getFicRtUseStsCdRateDry45();
				String strFicRtUseStsCdRateRf40hc = row.getFicRtUseStsCdRateRf40hc();
				String strFicRtUseStsCdRateRd40hc = row.getFicRtUseStsCdRateRd40hc();

				String strOptmTrspModFlgRateDry20 = row.getOptmTrspModFlgRateDry20();
				String strOptmTrspModFlgRateDry40 = row.getOptmTrspModFlgRateDry40();
				String strOptmTrspModFlgRateDry40hc = row.getOptmTrspModFlgRateDry40hc();
				String strOptmTrspModFlgRateDry45 = row.getOptmTrspModFlgRateDry45();
				String strOptmTrspModFlgRateRf40hc = row.getOptmTrspModFlgRateRf40hc();
				String strOptmTrspModFlgRateRd40hc = row.getOptmTrspModFlgRateRd40hc();

				// cmdt hdr
				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextCmdtSeq = 0;
					nextRoutSeq = 0;

					PriRqRtCmdtHdrVO cmdtHdr = new PriRqRtCmdtHdrVO();
					cmdtHdr.setQttnNo(strQttnNo);
					cmdtHdr.setQttnVerNo(strQttnVerNo);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setSrcInfoCd("NW");
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);
					cmdtHdr.setFicRtTpCd(rateQuotationVO.getFicRtTpCd());
					cmdtHdrVoList.add(cmdtHdr);
				}

				// cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;

					String cmdtTpCd = "";
					if (strCmdtCd.length() == 6)
						cmdtTpCd = "C";
					else if (strCmdtCd.length() == 5)
						cmdtTpCd = "G";
					else if (strCmdtCd.length() == 4)
						cmdtTpCd = "R";

					PriRqRtCmdtVO cmdt = new PriRqRtCmdtVO();
					cmdt.setQttnNo(strQttnNo);
					cmdt.setQttnVerNo(strQttnVerNo);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setSrcInfoCd("NW");
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);

					cmdtVoList.add(cmdt);
				}

				// cmdt rout
				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;

					PriRqRtCmdtRoutVO rout = new PriRqRtCmdtRoutVO();
					rout.setQttnNo(strQttnNo);
					rout.setQttnVerNo(strQttnVerNo);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);

					routVoList.add(rout);
				}

				// pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = "";

					if (strOrgPntCd.length() == 5)
						locTpCd = "L";
					else if (strOrgPntCd.length() == 4)
						locTpCd = "G";
					else if (strOrgPntCd.length() == 3)
						locTpCd = "R";
					else if (strOrgPntCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutPntVO pnt = new PriRqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("O");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strOrgPntCd);
					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
					pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
					pnt.setSrcInfoCd("NW");
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					if ("AEE".equals(strSvcScpCd)) {
						pnt.setBsePortLocCd(strBasePortLocCd);
						pnt.setFicRoutCmbTpCd(strFicRoutCmbTpCd);
					}

					pntVoList.add(pnt);
				}

				// via origin
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					boolean dupChk = false;
					if ("AEE".equals(strSvcScpCd)) {
						dupChk = duplicateRouteVia(viaVoList, strQttnNo, strQttnVerNo, nextCmdtHdrSeq, nextRoutSeq, strOrgViaCd);
					}
					if (!dupChk) {
						nextRoutViaSeq++;

						String locTpCd = "";

						if (strOrgViaCd.length() == 5)
							locTpCd = "L";
						else if (strOrgViaCd.length() == 4)
							locTpCd = "G";
						else if (strOrgViaCd.length() == 3)
							locTpCd = "R";
						else if (strOrgViaCd.length() == 2)
							locTpCd = "C";

						PriRqRtRoutViaVO via = new PriRqRtRoutViaVO();
						via.setQttnNo(strQttnNo);
						via.setQttnVerNo(strQttnVerNo);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("O");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strOrgViaCd);
						via.setSrcInfoCd("NW");
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}

				// via dest
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					boolean dupChk = false;
					if ("AEE".equals(strSvcScpCd)) {
						dupChk = duplicateRouteVia(viaVoList, strQttnNo, strQttnVerNo, nextCmdtHdrSeq, nextRoutSeq, strDestViaCd);
					}
					if (!dupChk) {
						nextRoutViaSeq++;

						String locTpCd = "";

						if (strDestViaCd.length() == 5)
							locTpCd = "L";
						else if (strDestViaCd.length() == 4)
							locTpCd = "G";
						else if (strDestViaCd.length() == 3)
							locTpCd = "R";
						else if (strDestViaCd.length() == 2)
							locTpCd = "C";

						PriRqRtRoutViaVO via = new PriRqRtRoutViaVO();
						via.setQttnNo(strQttnNo);
						via.setQttnVerNo(strQttnVerNo);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("D");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strDestViaCd);
						via.setSrcInfoCd("NW");
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}

				// pnt dest
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = "";

					if (strDestPntCd.length() == 5)
						locTpCd = "L";
					else if (strDestPntCd.length() == 4)
						locTpCd = "G";
					else if (strDestPntCd.length() == 3)
						locTpCd = "R";
					else if (strDestPntCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutPntVO pnt = new PriRqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("D");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strDestPntCd);
					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
					pnt.setPrcTrspModCd(strDestPrcTrspModCd);
					pnt.setSrcInfoCd("NW");
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					if ("AEW".equals(strSvcScpCd)) {
						pnt.setBsePortLocCd(strBasePortLocCd);
						pnt.setFicRoutCmbTpCd(strFicRoutCmbTpCd);
					}

					pntVoList.add(pnt);
				}

				PriRqRtVO rt = new PriRqRtVO();
				// Dry 20
				if (strRateDry20 != null && !"".equals(strRateDry20)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D2");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateDry20);
					rt.setQttnRtAmt(strRateDry20);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rt.setFicQttnRtAmt(strRatePropDry20);
					rt.setFicGlineRtAmt(strFicGlineRtAmtRateDry20);
					rt.setOptmTrspModFlg(strOptmTrspModFlgRateDry20);
					rt.setFicRtUseStsCd(strFicRtUseStsCdRateDry20);

					rtVoList.add(rt);
				}

				// Dry 40
				if (strRateDry40 != null && !"".equals(strRateDry40)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D4");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateDry40);
					rt.setQttnRtAmt(strRateDry40);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rt.setFicQttnRtAmt(strRatePropDry40);
					rt.setFicGlineRtAmt(strFicGlineRtAmtRateDry40);
					rt.setOptmTrspModFlg(strOptmTrspModFlgRateDry40);
					rt.setFicRtUseStsCd(strFicRtUseStsCdRateDry40);

					rtVoList.add(rt);
				}

				// Dry 40 hc
				if (strRateDry40hc != null && !"".equals(strRateDry40hc)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D5");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateDry40hc);
					rt.setQttnRtAmt(strRateDry40hc);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rt.setFicQttnRtAmt(strRatePropDry40hc);
					rt.setFicGlineRtAmt(strFicGlineRtAmtRateDry40hc);
					rt.setOptmTrspModFlg(strOptmTrspModFlgRateDry40hc);
					rt.setFicRtUseStsCd(strFicRtUseStsCdRateDry40hc);

					rtVoList.add(rt);
				}

				// Dry45
				if (strRateDry45 != null && !"".equals(strRateDry45)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D7");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateDry45);
					rt.setQttnRtAmt(strRateDry45);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rt.setFicQttnRtAmt(strRatePropDry45);
					rt.setFicGlineRtAmt(strFicGlineRtAmtRateDry45);
					rt.setOptmTrspModFlg(strOptmTrspModFlgRateDry45);
					rt.setFicRtUseStsCd(strFicRtUseStsCdRateDry45);

					rtVoList.add(rt);
				}

				// Rf40hc
				if (strRateRf40hc != null && !"".equals(strRateRf40hc)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("R5");
					rt.setPrcCgoTpCd("RF");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateRf40hc);
					rt.setQttnRtAmt(strRateRf40hc);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rt.setFicQttnRtAmt(strRatePropRf40hc);
					rt.setFicGlineRtAmt(strFicGlineRtAmtRateRf40hc);
					rt.setOptmTrspModFlg(strOptmTrspModFlgRateRf40hc);
					rt.setFicRtUseStsCd(strFicRtUseStsCdRateRf40hc);

					rtVoList.add(rt);
				}

				// Rd40hc
				if (strRateRd40hc != null && !"".equals(strRateRd40hc)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("R5");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateRd40hc);
					rt.setQttnRtAmt(strRateRd40hc);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rt.setFicQttnRtAmt(strRatePropRd40hc);
					rt.setFicGlineRtAmt(strFicGlineRtAmtRateRd40hc);
					rt.setOptmTrspModFlg(strOptmTrspModFlgRateRd40hc);
					rt.setFicRtUseStsCd(strFicRtUseStsCdRateRd40hc);

					rtVoList.add(rt);
				}
			}

			if (cmdtHdrVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityHeaderS(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityS(cmdtVoList);
			}
			if (routVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityRouteS(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addRfaQuotationRoutePointS(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addRfaQuotationRouteViaS(viaVoList);
			}
			if (rtVoList.size() > 0) {
				dbDao.addRfaQuotationRateS(rtVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Route Via 중복 체크
	 * 
	 * @param vias
	 * @param strPropNo
	 * @param strAmdtSeq
	 * @param strSvcScpCd
	 * @param nextCmdtHdrSeq
	 * @param nextRoutSeq
	 * @param strViaCd
	 * @return
	 */
	private boolean duplicateRouteVia(List<PriRqRtRoutViaVO> vias, String strQttnNo, String strQttnVerNo, int nextCmdtHdrSeq, int nextRoutSeq, String strViaCd) {
		for (int i = 0; i < vias.size(); i++) {
			CompareToBuilder builder = new CompareToBuilder();
			builder.append(vias.get(i).getQttnNo(), strQttnNo);
			builder.append(vias.get(i).getQttnVerNo(), strQttnVerNo);
			builder.append(vias.get(i).getCmdtHdrSeq(), String.valueOf(nextCmdtHdrSeq));
			builder.append(vias.get(i).getRoutSeq(), String.valueOf(nextRoutSeq));
			builder.append(vias.get(i).getRoutViaPortDefCd(), strViaCd);
			if (builder.toComparison() == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN VerticalExcel)<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @return List<RsltPriRqRtListVerticalExcelForAddOnTariffVO>
	 * @exception EventException
	 */
	public List<RsltPriRqRtListVerticalExcelForAddOnTariffVO> searchRateListVerticalExcelForAddOnTariff(RFARateQuotationVO rfaRateQuotationVO) throws EventException {
		try {
			return dbDao.searchRateListVerticalExcelForAddOnTariff(rfaRateQuotationVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN Horizontal)<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @return List<RsltPriRqRtListHorizontalExcelForAddOnTariffVO>
	 * @exception EventException
	 */
	public List<RsltPriRqRtListHorizontalExcelForAddOnTariffVO> searchRateListHorizontalExcelForAddOnTariff(RFARateQuotationVO rfaRateQuotationVO) throws EventException {
		try {
			return dbDao.searchRateListHorizontalExcelForAddOnTariff(rfaRateQuotationVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Load된 엑셀 데이터의 FIC Rate를 조회한다.<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @param boolean addOnFlag
	 * @return List<RsltPriRqRtGuidelineRateVO>
	 * @exception EventException
	 */
	public List<RsltPriRqRtGuidelineRateVO> searchFicGuidelineRateForLoadExcel(RFARateQuotationVO rfaRateQuotationVO, boolean addOnFlag) throws EventException {
		try {
			return dbDao.searchFicGuidelineRateForLoadExcel(rfaRateQuotationVO, addOnFlag);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RFA Rate LOAD EXCEL(ESM_PRI_6095) 정보를 저장한다.<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVerticalForAddOnTariff(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException {

		List<PriRqRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRqRtCmdtHdrVO>();
		List<PriRqRtCmdtVO> cmdtVoList = new ArrayList<PriRqRtCmdtVO>();
		List<PriRqRtCmdtRoutVO> routVoList = new ArrayList<PriRqRtCmdtRoutVO>();
		List<PriRqRtRoutPntVO> pntVoList = new ArrayList<PriRqRtRoutPntVO>();
		List<PriRqRtRoutViaVO> viaVoList = new ArrayList<PriRqRtRoutViaVO>();
		List<PriRqRtVO> rtVoList = new ArrayList<PriRqRtVO>();
		try {
			PriRqRtCmdtHdrVO priRqRtCmdtHdrVO = rateQuotationVO.getPriRqRtCmdtHdrVO();
			RsltPriRqRtListVerticalExcelForAddOnTariffVO[] rsltPriRqRtListVerticalExcelForAddOnTariffVOs = rateQuotationVO.getRsltPriRqRtListVerticalExcelForAddOnTariffVOs();

			int nextCmdtHdrSeq = dbDao.searchPriRqRtCmdtHdrMaxSeq(priRqRtCmdtHdrVO);
			nextCmdtHdrSeq = nextCmdtHdrSeq - 1;

			int nextCmdtSeq = 0;
			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;

			String strQttnNo = priRqRtCmdtHdrVO.getQttnNo();
			String strQttnVerNo = priRqRtCmdtHdrVO.getQttnVerNo();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();
			String strFicRtTpCd = rateQuotationVO.getFicRtTpCd();

			for (int i = 0; i < rsltPriRqRtListVerticalExcelForAddOnTariffVOs.length; i++) {
				RsltPriRqRtListVerticalExcelForAddOnTariffVO row = rsltPriRqRtListVerticalExcelForAddOnTariffVOs[i];

				String strCmdtDpSeq = row.getCmdtDpSeq();
				String strCmdtCd = row.getPrcCmdtDefCd();

				String strRoutDpSeq = row.getRoutDpSeq();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				String strDestPrcTrspModCd = row.getDestPrcTrspModNm();

				String strRatUtCd = row.getRatUtCd();
				String strPrcCgoTpCd = row.getPrcCgoTpCd();
				String strCurrCd = "USD";
				String strQttnRtAmt = row.getQttnRtAmt();

				String strOrgBsePortLocCd = row.getOrgBsePortLocCd();
				String strFicOrgRoutCmbTpCd = row.getFicOrgRoutCmbTpCd();
				String strFicOrgGlineRtAmt = row.getFicOrgGlineRtAmt();
				String strFicOrgQttnRtAmt = row.getFicOrgQttnRtAmt();
				String strFicOrgRtUseStsCd = row.getFicOrgRtUseStsCd();
				String strOrgCyDorRtTpCd = row.getOrgCyDorRtTpCd();
				String strOrgOptmTrspModFlg = row.getOrgOptmTrspModFlg();

				String strDestBsePortLocCd = row.getDestBsePortLocCd();
				String strFicDestRoutCmbTpCd = row.getFicDestRoutCmbTpCd();
				String strFicDestGlineRtAmt = row.getFicDestGlineRtAmt();
				String strFicDestQttnRtAmt = row.getFicDestQttnRtAmt();
				String strFicDestRtUseStsCd = row.getFicDestRtUseStsCd();
				String strDestCyDorRtTpCd = row.getDestCyDorRtTpCd();
				String strDestOptmTrspModFlg = row.getDestOptmTrspModFlg();

				// cmdt hdr
				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextCmdtSeq = 0;
					nextRoutSeq = 0;
					PriRqRtCmdtHdrVO cmdtHdr = new PriRqRtCmdtHdrVO();
					cmdtHdr.setQttnNo(strQttnNo);
					cmdtHdr.setQttnVerNo(strQttnVerNo);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setSrcInfoCd("NW");
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);
					cmdtHdr.setFicRtTpCd(strFicRtTpCd);
					cmdtHdrVoList.add(cmdtHdr);
				}

				// cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;
					String cmdtTpCd = "";
					if (strCmdtCd.length() == 6)
						cmdtTpCd = "C";
					else if (strCmdtCd.length() == 5)
						cmdtTpCd = "G";
					else if (strCmdtCd.length() == 4)
						cmdtTpCd = "R";
					PriRqRtCmdtVO cmdt = new PriRqRtCmdtVO();
					cmdt.setQttnNo(strQttnNo);
					cmdt.setQttnVerNo(strQttnVerNo);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setSrcInfoCd("NW");
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);

					cmdtVoList.add(cmdt);
				}

				// cmdt rout
				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;

					PriRqRtCmdtRoutVO rout = new PriRqRtCmdtRoutVO();
					rout.setQttnNo(strQttnNo);
					rout.setQttnVerNo(strQttnVerNo);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);
					rout.setOrgCyDorRtTpCd(strOrgCyDorRtTpCd);
					rout.setDestCyDorRtTpCd(strDestCyDorRtTpCd);
					routVoList.add(rout);
				}

				// pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;
					String locTpCd = "";
					if (strOrgPntCd.length() == 5)
						locTpCd = "L";
					else if (strOrgPntCd.length() == 4)
						locTpCd = "G";
					else if (strOrgPntCd.length() == 3)
						locTpCd = "R";
					else if (strOrgPntCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutPntVO pnt = new PriRqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("O");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strOrgPntCd);
					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
					pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
					pnt.setSrcInfoCd("NW");
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);
					pnt.setBsePortLocCd(strOrgBsePortLocCd);
					pnt.setFicRoutCmbTpCd(strFicOrgRoutCmbTpCd);

					pntVoList.add(pnt);
				}

				// via origin
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					boolean dupChk = duplicateRouteVia(viaVoList, strQttnNo, strQttnVerNo, nextCmdtHdrSeq, nextRoutSeq, strOrgViaCd);
					if (!dupChk) {
						nextRoutViaSeq++;

						String locTpCd = "";

						if (strOrgViaCd.length() == 5)
							locTpCd = "L";
						else if (strOrgViaCd.length() == 4)
							locTpCd = "G";
						else if (strOrgViaCd.length() == 3)
							locTpCd = "R";
						else if (strOrgViaCd.length() == 2)
							locTpCd = "C";

						PriRqRtRoutViaVO via = new PriRqRtRoutViaVO();
						via.setQttnNo(strQttnNo);
						via.setQttnVerNo(strQttnVerNo);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("O");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strOrgViaCd);
						via.setSrcInfoCd("NW");
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}

				// via dest
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					boolean dupChk = duplicateRouteVia(viaVoList, strQttnNo, strQttnVerNo, nextCmdtHdrSeq, nextRoutSeq, strDestViaCd);
					if (!dupChk) {
						nextRoutViaSeq++;

						String locTpCd = "";

						if (strDestViaCd.length() == 5)
							locTpCd = "L";
						else if (strDestViaCd.length() == 4)
							locTpCd = "G";
						else if (strDestViaCd.length() == 3)
							locTpCd = "R";
						else if (strDestViaCd.length() == 2)
							locTpCd = "C";

						PriRqRtRoutViaVO via = new PriRqRtRoutViaVO();
						via.setQttnNo(strQttnNo);
						via.setQttnVerNo(strQttnVerNo);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("D");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strDestViaCd);
						via.setSrcInfoCd("NW");
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}

				// pnt dest
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = "";

					if (strDestPntCd.length() == 5)
						locTpCd = "L";
					else if (strDestPntCd.length() == 4)
						locTpCd = "G";
					else if (strDestPntCd.length() == 3)
						locTpCd = "R";
					else if (strDestPntCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutPntVO pnt = new PriRqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("D");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strDestPntCd);
					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
					pnt.setPrcTrspModCd(strDestPrcTrspModCd);
					pnt.setSrcInfoCd("NW");
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);
					pnt.setBsePortLocCd(strDestBsePortLocCd);
					pnt.setFicRoutCmbTpCd(strFicDestRoutCmbTpCd);
					pntVoList.add(pnt);
				}

				// rate
				if (strQttnRtAmt != null && !"".equals(strQttnRtAmt)) {
					nextRtSeq++;
					PriRqRtVO rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd(strRatUtCd);
					rt.setPrcCgoTpCd(strPrcCgoTpCd);
					rt.setCurrCd(strCurrCd);
					rt.setQttnInitRtAmt(strQttnRtAmt);
					rt.setQttnRtAmt(strQttnRtAmt);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);
					rt.setFicOrgGlineRtAmt(strFicOrgGlineRtAmt);
					rt.setFicOrgQttnRtAmt(strFicOrgQttnRtAmt);
					rt.setFicOrgRtUseStsCd(strFicOrgRtUseStsCd);
					rt.setOrgOptmTrspModFlg(strOrgOptmTrspModFlg);

					rt.setFicDestGlineRtAmt(strFicDestGlineRtAmt);
					rt.setFicDestQttnRtAmt(strFicDestQttnRtAmt);
					rt.setFicDestRtUseStsCd(strFicDestRtUseStsCd);
					rt.setDestOptmTrspModFlg(strDestOptmTrspModFlg);
					rtVoList.add(rt);
				}

			}

			if (cmdtHdrVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityHeaderS(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityS(cmdtVoList);
			}
			if (routVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityRouteS(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addRfaQuotationRoutePointS(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addRfaQuotationRouteViaS(viaVoList);
			}
			if (rtVoList.size() > 0) {
				dbDao.addRfaQuotationRateS(rtVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * RQ Rate LOAD EXCEL(ESM_PRI_6096) 정보를 저장한다.<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelHorizontalForAddOnTariff(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException {

		List<PriRqRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRqRtCmdtHdrVO>();
		List<PriRqRtCmdtVO> cmdtVoList = new ArrayList<PriRqRtCmdtVO>();
		List<PriRqRtCmdtRoutVO> routVoList = new ArrayList<PriRqRtCmdtRoutVO>();
		List<PriRqRtRoutPntVO> pntVoList = new ArrayList<PriRqRtRoutPntVO>();
		List<PriRqRtRoutViaVO> viaVoList = new ArrayList<PriRqRtRoutViaVO>();
		List<PriRqRtVO> rtVoList = new ArrayList<PriRqRtVO>();

		PriRqRtCmdtHdrVO priRqRtCmdtHdrVO = rateQuotationVO.getPriRqRtCmdtHdrVO();
		RsltPriRqRtListHorizontalExcelForAddOnTariffVO[] rsltPriRqRtListHorizontalExcelForAddOnTariffVOs = rateQuotationVO.getRsltPriRqRtListHorizontalExcelForAddOnTariffVOs();

		try {
			int nextCmdtHdrSeq = dbDao.searchPriRqRtCmdtHdrMaxSeq(priRqRtCmdtHdrVO);
			nextCmdtHdrSeq = nextCmdtHdrSeq - 1;

			int nextCmdtSeq = 0;
			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;

			String strQttnNo = priRqRtCmdtHdrVO.getQttnNo();
			String strQttnVerNo = priRqRtCmdtHdrVO.getQttnVerNo();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();
			for (int i = 0; i < rsltPriRqRtListHorizontalExcelForAddOnTariffVOs.length; i++) {
				RsltPriRqRtListHorizontalExcelForAddOnTariffVO row = rsltPriRqRtListHorizontalExcelForAddOnTariffVOs[i];

				String strCmdtDpSeq = row.getCmdtDpSeq();
				String strCmdtCd = row.getPrcCmdtDefCd();

				String strRoutDpSeq = row.getRoutDpSeq();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				String strDestPrcTrspModCd = row.getDestPrcTrspModNm();

				String strOrgCyDorRtTpCd = row.getOrgCyDorRtTpCd();
				String strDestCyDorRtTpCd = row.getDestCyDorRtTpCd();

				String strRateDry20 = row.getRateDry20();
				String strRateDry40 = row.getRateDry40();
				String strRateDry40hc = row.getRateDry40hc();
				String strRateDry45 = row.getRateDry45();
				String strRateRf40hc = row.getRateRf40hc();
				String strRateRd40hc = row.getRateRd40hc();
				// Origin
				String strOrgBasePortLocCd = row.getOrgBsePortLocCd();
				String strFicOrgRoutCmbTpCd = row.getFicOrgRoutCmbTpCd();

				String strOrgRatePropDry20 = row.getOrgRateFicDry20();
				String strOrgRatePropDry40 = row.getOrgRateFicDry40();
				String strOrgRatePropDry40hc = row.getOrgRateFicDry40hc();
				String strOrgRatePropDry45 = row.getOrgRateFicDry45();
				String strOrgRatePropRf40hc = row.getOrgRateFicRf40hc();
				String strOrgRatePropRd40hc = row.getOrgRateFicRd40hc();

				String strFicOrgGlineRtAmtRateDry20 = row.getFicOrgGlineRtAmtDry20();
				String strFicOrgGlineRtAmtRateDry40 = row.getFicOrgGlineRtAmtDry40();
				String strFicOrgGlineRtAmtRateDry40hc = row.getFicOrgGlineRtAmtDry40hc();
				String strFicOrgGlineRtAmtRateDry45 = row.getFicOrgGlineRtAmtDry45();
				String strFicOrgGlineRtAmtRateRf40hc = row.getFicOrgGlineRtAmtRf40hc();
				String strFicOrgGlineRtAmtRateRd40hc = row.getFicOrgGlineRtAmtRd40hc();

				String strFicOrgRtUseStsCdRateDry20 = row.getFicOrgRtUseStsCdDry20();
				String strFicOrgRtUseStsCdRateDry40 = row.getFicOrgRtUseStsCdDry40();
				String strFicOrgRtUseStsCdRateDry40hc = row.getFicOrgRtUseStsCdDry40hc();
				String strFicOrgRtUseStsCdRateDry45 = row.getFicOrgRtUseStsCdDry45();
				String strFicOrgRtUseStsCdRateRf40hc = row.getFicOrgRtUseStsCdRf40hc();
				String strFicOrgRtUseStsCdRateRd40hc = row.getFicOrgRtUseStsCdRd40hc();

				String strOrgOptmTrspModFlgRateDry20 = row.getOrgOptmTrspModFlgDry20();
				String strOrgOptmTrspModFlgRateDry40 = row.getOrgOptmTrspModFlgDry40();
				String strOrgOptmTrspModFlgRateDry40hc = row.getOrgOptmTrspModFlgDry40hc();
				String strOrgOptmTrspModFlgRateDry45 = row.getOrgOptmTrspModFlgDry45();
				String strOrgOptmTrspModFlgRateRf40hc = row.getOrgOptmTrspModFlgRf40hc();
				String strOrgOptmTrspModFlgRateRd40hc = row.getOrgOptmTrspModFlgRd40hc();

				// Destination
				String strDestBasePortLocCd = row.getDestBsePortLocCd();
				String strFicDestRoutCmbTpCd = row.getFicDestRoutCmbTpCd();

				String strDestRatePropDry20 = row.getDestRateFicDry20();
				String strDestRatePropDry40 = row.getDestRateFicDry40();
				String strDestRatePropDry40hc = row.getDestRateFicDry40hc();
				String strDestRatePropDry45 = row.getDestRateFicDry45();
				String strDestRatePropRf40hc = row.getDestRateFicRf40hc();
				String strDestRatePropRd40hc = row.getDestRateFicRd40hc();

				String strFicDestGlineRtAmtRateDry20 = row.getFicDestGlineRtAmtDry20();
				String strFicDestGlineRtAmtRateDry40 = row.getFicDestGlineRtAmtDry40();
				String strFicDestGlineRtAmtRateDry40hc = row.getFicDestGlineRtAmtDry40hc();
				String strFicDestGlineRtAmtRateDry45 = row.getFicDestGlineRtAmtDry45();
				String strFicDestGlineRtAmtRateRf40hc = row.getFicDestGlineRtAmtRf40hc();
				String strFicDestGlineRtAmtRateRd40hc = row.getFicDestGlineRtAmtRd40hc();

				String strFicDestRtUseStsCdRateDry20 = row.getFicDestRtUseStsCdDry20();
				String strFicDestRtUseStsCdRateDry40 = row.getFicDestRtUseStsCdDry40();
				String strFicDestRtUseStsCdRateDry40hc = row.getFicDestRtUseStsCdDry40hc();
				String strFicDestRtUseStsCdRateDry45 = row.getFicDestRtUseStsCdDry45();
				String strFicDestRtUseStsCdRateRf40hc = row.getFicDestRtUseStsCdRf40hc();
				String strFicDestRtUseStsCdRateRd40hc = row.getFicDestRtUseStsCdRd40hc();

				String strDestOptmTrspModFlgRateDry20 = row.getDestOptmTrspModFlgDry20();
				String strDestOptmTrspModFlgRateDry40 = row.getDestOptmTrspModFlgDry40();
				String strDestOptmTrspModFlgRateDry40hc = row.getDestOptmTrspModFlgDry40hc();
				String strDestOptmTrspModFlgRateDry45 = row.getDestOptmTrspModFlgDry45();
				String strDestOptmTrspModFlgRateRf40hc = row.getDestOptmTrspModFlgRf40hc();
				String strDestOptmTrspModFlgRateRd40hc = row.getDestOptmTrspModFlgRd40hc();

				// cmdt hdr
				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextCmdtSeq = 0;
					nextRoutSeq = 0;

					PriRqRtCmdtHdrVO cmdtHdr = new PriRqRtCmdtHdrVO();
					cmdtHdr.setQttnNo(strQttnNo);
					cmdtHdr.setQttnVerNo(strQttnVerNo);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setSrcInfoCd("NW");
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);
					cmdtHdr.setFicRtTpCd(rateQuotationVO.getFicRtTpCd());
					cmdtHdrVoList.add(cmdtHdr);
				}

				// cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;

					String cmdtTpCd = "";
					if (strCmdtCd.length() == 6)
						cmdtTpCd = "C";
					else if (strCmdtCd.length() == 5)
						cmdtTpCd = "G";
					else if (strCmdtCd.length() == 4)
						cmdtTpCd = "R";

					PriRqRtCmdtVO cmdt = new PriRqRtCmdtVO();
					cmdt.setQttnNo(strQttnNo);
					cmdt.setQttnVerNo(strQttnVerNo);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setSrcInfoCd("NW");
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);

					cmdtVoList.add(cmdt);
				}

				// cmdt rout
				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;

					PriRqRtCmdtRoutVO rout = new PriRqRtCmdtRoutVO();
					rout.setQttnNo(strQttnNo);
					rout.setQttnVerNo(strQttnVerNo);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);
					rout.setOrgCyDorRtTpCd(strOrgCyDorRtTpCd);
					rout.setDestCyDorRtTpCd(strDestCyDorRtTpCd);
					routVoList.add(rout);
				}

				// pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = "";

					if (strOrgPntCd.length() == 5)
						locTpCd = "L";
					else if (strOrgPntCd.length() == 4)
						locTpCd = "G";
					else if (strOrgPntCd.length() == 3)
						locTpCd = "R";
					else if (strOrgPntCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutPntVO pnt = new PriRqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("O");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strOrgPntCd);
					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
					pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
					pnt.setSrcInfoCd("NW");
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);
					pnt.setBsePortLocCd(strOrgBasePortLocCd);
					pnt.setFicRoutCmbTpCd(strFicOrgRoutCmbTpCd);
					pntVoList.add(pnt);
				}

				// via origin
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					boolean dupChk = duplicateRouteVia(viaVoList, strQttnNo, strQttnVerNo, nextCmdtHdrSeq, nextRoutSeq, strOrgViaCd);
					if (!dupChk) {
						nextRoutViaSeq++;

						String locTpCd = "";

						if (strOrgViaCd.length() == 5)
							locTpCd = "L";
						else if (strOrgViaCd.length() == 4)
							locTpCd = "G";
						else if (strOrgViaCd.length() == 3)
							locTpCd = "R";
						else if (strOrgViaCd.length() == 2)
							locTpCd = "C";

						PriRqRtRoutViaVO via = new PriRqRtRoutViaVO();
						via.setQttnNo(strQttnNo);
						via.setQttnVerNo(strQttnVerNo);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("O");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strOrgViaCd);
						via.setSrcInfoCd("NW");
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}

				// via dest
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					boolean dupChk = duplicateRouteVia(viaVoList, strQttnNo, strQttnVerNo, nextCmdtHdrSeq, nextRoutSeq, strDestViaCd);
					if (!dupChk) {
						nextRoutViaSeq++;

						String locTpCd = "";

						if (strDestViaCd.length() == 5)
							locTpCd = "L";
						else if (strDestViaCd.length() == 4)
							locTpCd = "G";
						else if (strDestViaCd.length() == 3)
							locTpCd = "R";
						else if (strDestViaCd.length() == 2)
							locTpCd = "C";

						PriRqRtRoutViaVO via = new PriRqRtRoutViaVO();
						via.setQttnNo(strQttnNo);
						via.setQttnVerNo(strQttnVerNo);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("D");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strDestViaCd);
						via.setSrcInfoCd("NW");
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}

				// pnt dest
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = "";

					if (strDestPntCd.length() == 5)
						locTpCd = "L";
					else if (strDestPntCd.length() == 4)
						locTpCd = "G";
					else if (strDestPntCd.length() == 3)
						locTpCd = "R";
					else if (strDestPntCd.length() == 2)
						locTpCd = "C";

					PriRqRtRoutPntVO pnt = new PriRqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("D");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strDestPntCd);
					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
					pnt.setPrcTrspModCd(strDestPrcTrspModCd);
					pnt.setSrcInfoCd("NW");
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);
					pnt.setBsePortLocCd(strDestBasePortLocCd);
					pnt.setFicRoutCmbTpCd(strFicDestRoutCmbTpCd);
					pntVoList.add(pnt);
				}

				PriRqRtVO rt = new PriRqRtVO();
				// Dry 20
				if (strRateDry20 != null && !"".equals(strRateDry20)) {
					nextRtSeq++;
					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D2");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateDry20);
					rt.setQttnRtAmt(strRateDry20);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);
					rt.setFicOrgQttnRtAmt(strOrgRatePropDry20);
					rt.setFicOrgGlineRtAmt(strFicOrgGlineRtAmtRateDry20);
					rt.setOrgOptmTrspModFlg(strOrgOptmTrspModFlgRateDry20);
					rt.setFicOrgRtUseStsCd(strFicOrgRtUseStsCdRateDry20);

					rt.setFicDestQttnRtAmt(strDestRatePropDry20);
					rt.setFicDestGlineRtAmt(strFicDestGlineRtAmtRateDry20);
					rt.setDestOptmTrspModFlg(strDestOptmTrspModFlgRateDry20);
					rt.setFicDestRtUseStsCd(strFicDestRtUseStsCdRateDry20);

					rtVoList.add(rt);
				}

				// Dry 40
				if (strRateDry40 != null && !"".equals(strRateDry40)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D4");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateDry40);
					rt.setQttnRtAmt(strRateDry40);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rt.setFicOrgQttnRtAmt(strOrgRatePropDry40);
					rt.setFicOrgGlineRtAmt(strFicOrgGlineRtAmtRateDry40);
					rt.setOrgOptmTrspModFlg(strOrgOptmTrspModFlgRateDry40);
					rt.setFicOrgRtUseStsCd(strFicOrgRtUseStsCdRateDry40);

					rt.setFicDestQttnRtAmt(strDestRatePropDry40);
					rt.setFicDestGlineRtAmt(strFicDestGlineRtAmtRateDry40);
					rt.setDestOptmTrspModFlg(strDestOptmTrspModFlgRateDry40);
					rt.setFicDestRtUseStsCd(strFicDestRtUseStsCdRateDry40);

					rtVoList.add(rt);
				}

				// Dry 40 hc
				if (strRateDry40hc != null && !"".equals(strRateDry40hc)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D5");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateDry40hc);
					rt.setQttnRtAmt(strRateDry40hc);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rt.setFicOrgQttnRtAmt(strOrgRatePropDry40hc);
					rt.setFicOrgGlineRtAmt(strFicOrgGlineRtAmtRateDry40hc);
					rt.setOrgOptmTrspModFlg(strOrgOptmTrspModFlgRateDry40hc);
					rt.setFicOrgRtUseStsCd(strFicOrgRtUseStsCdRateDry40hc);

					rt.setFicDestQttnRtAmt(strDestRatePropDry40hc);
					rt.setFicDestGlineRtAmt(strFicDestGlineRtAmtRateDry40hc);
					rt.setDestOptmTrspModFlg(strDestOptmTrspModFlgRateDry40hc);
					rt.setFicDestRtUseStsCd(strFicDestRtUseStsCdRateDry40hc);

					rtVoList.add(rt);
				}

				// Dry45
				if (strRateDry45 != null && !"".equals(strRateDry45)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D7");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateDry45);
					rt.setQttnRtAmt(strRateDry45);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rt.setFicOrgQttnRtAmt(strOrgRatePropDry45);
					rt.setFicOrgGlineRtAmt(strFicOrgGlineRtAmtRateDry45);
					rt.setOrgOptmTrspModFlg(strOrgOptmTrspModFlgRateDry45);
					rt.setFicOrgRtUseStsCd(strFicOrgRtUseStsCdRateDry45);

					rt.setFicDestQttnRtAmt(strDestRatePropDry45);
					rt.setFicDestGlineRtAmt(strFicDestGlineRtAmtRateDry45);
					rt.setDestOptmTrspModFlg(strDestOptmTrspModFlgRateDry45);
					rt.setFicDestRtUseStsCd(strFicDestRtUseStsCdRateDry45);

					rtVoList.add(rt);
				}

				// Rf40hc
				if (strRateRf40hc != null && !"".equals(strRateRf40hc)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("R5");
					rt.setPrcCgoTpCd("RF");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateRf40hc);
					rt.setQttnRtAmt(strRateRf40hc);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rt.setFicOrgQttnRtAmt(strOrgRatePropRf40hc);
					rt.setFicOrgGlineRtAmt(strFicOrgGlineRtAmtRateRf40hc);
					rt.setOrgOptmTrspModFlg(strOrgOptmTrspModFlgRateRf40hc);
					rt.setFicOrgRtUseStsCd(strFicOrgRtUseStsCdRateRf40hc);

					rt.setFicDestQttnRtAmt(strDestRatePropRf40hc);
					rt.setFicDestGlineRtAmt(strFicDestGlineRtAmtRateRf40hc);
					rt.setDestOptmTrspModFlg(strDestOptmTrspModFlgRateRf40hc);
					rt.setFicDestRtUseStsCd(strFicDestRtUseStsCdRateRf40hc);

					rtVoList.add(rt);
				}

				// Rd40hc
				if (strRateRd40hc != null && !"".equals(strRateRd40hc)) {
					nextRtSeq++;

					rt = new PriRqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("R5");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setQttnInitRtAmt(strRateRd40hc);
					rt.setQttnRtAmt(strRateRd40hc);
					rt.setSrcInfoCd("NW");
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rt.setFicOrgQttnRtAmt(strOrgRatePropRd40hc);
					rt.setFicOrgGlineRtAmt(strFicOrgGlineRtAmtRateRd40hc);
					rt.setOrgOptmTrspModFlg(strOrgOptmTrspModFlgRateRd40hc);
					rt.setFicOrgRtUseStsCd(strFicOrgRtUseStsCdRateRd40hc);

					rt.setFicDestQttnRtAmt(strDestRatePropRd40hc);
					rt.setFicDestGlineRtAmt(strFicDestGlineRtAmtRateRd40hc);
					rt.setDestOptmTrspModFlg(strDestOptmTrspModFlgRateRd40hc);
					rt.setFicDestRtUseStsCd(strFicDestRtUseStsCdRateRd40hc);

					rtVoList.add(rt);
				}
			}

			if (cmdtHdrVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityHeaderS(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityS(cmdtVoList);
			}
			if (routVoList.size() > 0) {
				dbDao.addRfaQuotationCommodityRouteS(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addRfaQuotationRoutePointS(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addRfaQuotationRouteViaS(viaVoList);
			}
			if (rtVoList.size() > 0) {
				dbDao.addRfaQuotationRateS(rtVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

}