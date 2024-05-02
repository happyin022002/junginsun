/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationBCImpl.java
*@FileTitle : S/C Quotation
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
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration.SCRateQuotationDBDAO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InPriLocationViaListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InPriQuotationRateAdjustSetVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InPriRateAdjustListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.PriSqRtCmdtRoutSetVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RateQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltCmpbViewAllListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriCostDetailByTransModeListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriRateCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtAllViewVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtCmdtRoutVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtCmdtVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtRoutPntVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtRoutViaVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustCommodityDetailVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustCommodityVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustLocationGroupDetailVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustLocationGroupVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeLastAccessDateVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeViewAllVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPrsSurchargeDetailListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltRtListVerticalExcelVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.table.PriSqHdrVO;
import com.hanjin.syscommon.common.table.PriSqMnVO;
import com.hanjin.syscommon.common.table.PriSqRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSqRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSqRtCmdtVO;
import com.hanjin.syscommon.common.table.PriSqRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriSqRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriSqRtScgVO;
import com.hanjin.syscommon.common.table.PriSqRtUsdRoutCsVO;
import com.hanjin.syscommon.common.table.PriSqRtVO;
import com.hanjin.syscommon.common.table.PriSqScgAdjVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * ALPS-SCQuotation Business Logic Basic Command implementation<br>
 * - ALPS-SCQuotation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6018EventResponse,SCRateQuotationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SCRateQuotationBCImpl extends BasicCommandSupport implements SCRateQuotationBC {

	// Database Access Object
	private transient SCRateQuotationDBDAO dbDao = null;

	/**
	 * SCRateQuotationBCImpl 객체 생성<br>
	 * SCRateQuotationDBDAO를 생성한다.<br>
	 */
	public SCRateQuotationBCImpl() {
		dbDao = new SCRateQuotationDBDAO();
	}
 

	/**
	 * PRS- Applicable Route, Surcharge Detail을 조회 처리합니다.<br>
	 * 
	 * @param inpPrsSurchargeDetailApplicableRouteVO InpPrsSurchargeDetailApplicableRouteVO
	 * @return List<RsltRQPrsSurchargeDetailListVO>
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
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * PRS- Surcharge Detail 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param priSqRtScgVOs PriSqRtScgVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageRateSurcharge(PriSqRtScgVO[] priSqRtScgVOs, SignOnUserAccount account)
			throws EventException {
		try {
			List<PriSqRtScgVO> insertVoList = new ArrayList<PriSqRtScgVO>();
			List<PriSqRtScgVO> updateVoList = new ArrayList<PriSqRtScgVO>();
			List<PriSqRtScgVO> deleteVoList = new ArrayList<PriSqRtScgVO>();
			PriSqRtScgVO priSqRtScgVO = null; 

			for (int i = 0; i < priSqRtScgVOs.length; i++) {
				if (priSqRtScgVOs[i].getIbflag().equals("I")) {
					priSqRtScgVOs[i].setCreUsrId(account.getUsr_id());
					priSqRtScgVOs[i].setUpdUsrId(account.getUsr_id());
					priSqRtScgVOs[i].setTrfAdjTpCd("I");
					
					insertVoList.add(priSqRtScgVOs[i]);
				} else if (priSqRtScgVOs[i].getIbflag().equals("U")) {
					priSqRtScgVOs[i].setUpdUsrId(account.getUsr_id());
					priSqRtScgVOs[i].setTrfAdjTpCd("I");
					updateVoList.add(priSqRtScgVOs[i]);
				} else if (priSqRtScgVOs[i].getIbflag().equals("D")) {
					priSqRtScgVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priSqRtScgVOs[i]);
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
				priSqRtScgVO = deleteVoList.get(0);
			}else if( updateVoList.size() > 0){
				priSqRtScgVO = updateVoList.get(0);
			}else if(insertVoList.size() > 0){
				priSqRtScgVO = insertVoList.get(0);
			}
			if(priSqRtScgVO != null){
				dbDao.modifyPrsRateSurchargeCmpb(priSqRtScgVO,"2");
				dbDao.modifyPrsRateCmdtRoutCmpb(priSqRtScgVO,"2");
				
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	

	

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param rsltPriPrsCostListVO RsltPriPrsCostListVO
	 * @return List<RsltPriPrsCostListVO>
	 * @exception EventException
	 */
	public List<RsltPriPrsCostListVO> searchCostDetailList(RsltPriPrsCostListVO rsltPriPrsCostListVO)
			throws EventException {
		try {
			return dbDao.searchCostDetailList(rsltPriPrsCostListVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 상세내용 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param rsltPriPrsCostDetailVO RsltPriPrsCostDetailVO
	 * @return List<RsltPriPrsCostDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriPrsCostDetailVO> searchCostDetailInquiryList(RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO)
			throws EventException {
		try {
			return dbDao.searchCostDetailInquiryList(rsltPriPrsCostDetailVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

	


	/**
	 * PRS- Surcharge Adjust을 조회합니다.<br>
	 * 
	 * @param rsltPriSurchargeAdjustListVO RsltPriSurchargeAdjustListVO
	 * @return List<RsltPriSurchargeAdjustListVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustListVO> searchSurchargeAdjustList(
			RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO) throws EventException {
		try {
			return dbDao.searchSurchargeAdjustList(rsltPriSurchargeAdjustListVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * PRS- Surcharge Adjust 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param priSqScgAdjVO PriSqScgAdjVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageSurchargeAdjust(PriSqScgAdjVO[] priSqScgAdjVO, SignOnUserAccount account)
			throws EventException {
		try {
			List<PriSqScgAdjVO> insertVoList = new ArrayList<PriSqScgAdjVO>();
			List<PriSqScgAdjVO> updateVoList = new ArrayList<PriSqScgAdjVO>();
			List<PriSqScgAdjVO> deleteVoList = new ArrayList<PriSqScgAdjVO>();

			for (int i = 0; i < priSqScgAdjVO.length; i++) {
				if (priSqScgAdjVO[i].getIbflag().equals("I")) {
					priSqScgAdjVO[i].setCreUsrId(account.getUsr_id());
					priSqScgAdjVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSqScgAdjVO[i]);
				} else if (priSqScgAdjVO[i].getIbflag().equals("U")) {
					priSqScgAdjVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSqScgAdjVO[i]);
				} else if (priSqScgAdjVO[i].getIbflag().equals("D")) {
					priSqScgAdjVO[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priSqScgAdjVO[i]);
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
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * PRS- Surcharge Adjust 내용을 바탕으로 calc 로직을 수행 합니다.<br>
	 * 
	 * @param PriSqScgAdjVO priSqScgAdjVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargeAdjustCalc(PriSqScgAdjVO priSqScgAdjVO, SignOnUserAccount account)
			throws EventException {
		PriSqScgAdjVO tmpPriSqScgAdjVO = new PriSqScgAdjVO();
		RsltPriPrsCostListVO rsltPriPrsCostListVO = null;
		PriSqRtScgVO priSqRtScgVo = null; 
		try {
			if( tmpPriSqScgAdjVO != null ){
				rsltPriPrsCostListVO = new RsltPriPrsCostListVO();
				rsltPriPrsCostListVO.setUpdUsrId(account.getUsr_id());
				rsltPriPrsCostListVO.setQttnNo(priSqScgAdjVO.getQttnNo());
				rsltPriPrsCostListVO.setQttnVerNo(priSqScgAdjVO.getQttnVerNo());
				rsltPriPrsCostListVO.setGenSpclRtTpCd(priSqScgAdjVO.getGenSpclRtTpCd());

				priSqRtScgVo = new PriSqRtScgVO();
				priSqRtScgVo.setUpdUsrId(account.getUsr_id());
				priSqRtScgVo.setQttnNo(priSqScgAdjVO.getQttnNo());
				priSqRtScgVo.setQttnVerNo(priSqScgAdjVO.getQttnVerNo());
				priSqRtScgVo.setGenSpclRtTpCd(priSqScgAdjVO.getGenSpclRtTpCd());
				
				//Calc의 일부 로직
				dbDao.addPriSqRtScgAmtCostDetail(rsltPriPrsCostListVO,"1");//mergePRI_SQ_RT_SCG
				dbDao.modifyPrsRateSurchargeCmpb(priSqRtScgVo,"1");
				dbDao.modifyPrsRateCmdtRoutCmpb(priSqRtScgVo,"1");
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
	 * Commodity Group을 조회합니다.<br>
	 * 
	 * @param rsltPriSurchargeAdjustCommodityVO RsltPriSurchargeAdjustCommodityVO
	 * @return List<RsltPriSurchargeAdjustCommodityVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustCommodityVO> searchRateCommodityAllList(
			RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO) throws EventException {
		try {
			return dbDao.searchRateCommodityAllList(rsltPriSurchargeAdjustCommodityVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * Surcharge Adjust-Commodity group에 대한 상세 내용을 조회합니다.<br>
	 * 
	 * @param rsltPriSurchargeAdjustCommodityDetailVO RsltPriSurchargeAdjustCommodityDetailVO
	 * @return List<RsltPriSurchargeAdjustCommodityDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustCommodityDetailVO> searchRateGroupCommodityDetailList(
			RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityDetailVO) throws EventException {
		try {
			return dbDao.searchRateGroupCommodityDetailList(rsltPriSurchargeAdjustCommodityDetailVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * Surcharge Adjust-Location Group을 조회 합니다.<br>
	 * 
	 * @param rsltPriSurchargeAdjustLocationGroupVO RsltPriSurchargeAdjustLocationGroupVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustLocationGroupVO> searchRateLocationAllList(
			RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationGroupVO) throws EventException {
		try {
			return dbDao.searchRateLocationAllList(rsltPriSurchargeAdjustLocationGroupVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * Surcharge Adjust-Location Group에 상세 정보를 조회 합니다.<br>
	 * 
	 * @param rsltPriSurchargeAdjustLocationGroupVO RsltPriSurchargeAdjustLocationGroupDetailVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustLocationGroupDetailVO> searchRateGroupLocationDetailList(
			RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupVO) throws EventException {
		try {
			return dbDao.searchRateGroupLocationDetailList(rsltPriSurchargeAdjustLocationGroupVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}


	/**
	 * CM/OP View 내용을 조회 합니다.<br>
	 * 
	 * @param rsltPriRateCmViewAllVO RsltPriRateCmViewAllVO
	 * @return List<RsltPriRateCmViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriRateCmViewAllVO> searchRateCmViewAllList(
			RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO) throws EventException {
		try {
			return dbDao.searchRateCmViewAllList(rsltPriRateCmViewAllVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * CM/OP View 의 Load 값을 갱신처리 합니다.<BR>
	 * 
	 * @param priSqRtCmdtRoutSetVO PriSqRtCmdtRoutSetVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyPrsPfmc(PriSqRtCmdtRoutSetVO priSqRtCmdtRoutSetVO, SignOnUserAccount account)
			throws EventException {
		try {
			List<PriSqRtCmdtRoutVO> updateVoList = new ArrayList<PriSqRtCmdtRoutVO>();
			String pfmcUnit = priSqRtCmdtRoutSetVO.getPfmcUnit();
			PriSqRtCmdtRoutVO[] priSqRtCmdtRoutVO = priSqRtCmdtRoutSetVO.getPriSqRtCmdtRoutVOS();
 
			for (int i = 0; i < priSqRtCmdtRoutVO.length; i++) {
				if (priSqRtCmdtRoutVO[i].getIbflag().equals("U")) {
					priSqRtCmdtRoutVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSqRtCmdtRoutVO[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyPrsPfmc(updateVoList,pfmcUnit);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}


	
	/**
	 * Cost Detail by Trans.Mode 를 조회 합니다.<br>
	 *  
	 * @param RsltPriCostDetailByTransModeListVO    rsltPriCostDetailByTransModeListVO
	 * @return List<RsltPriCostDetailByTransModeListVO>
	 * @exception EventException
	 */
	public  List<RsltPriCostDetailByTransModeListVO> searchCostDetailByTransModeList(RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO) throws EventException {
		try {
			return dbDao.searchCostDetailByTransModeList(rsltPriCostDetailByTransModeListVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	

	
	
	
	//////////////////////////////////////////////////SQ RATE MAIN//////////////////////////////////////////////////////////
	
	
	
	
	/**
	 * PRI_SQ_RT_CMDT_HDR, PRI_SQ_RT_CMDT 을 조회 합니다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltPriSqRtCmdtVO>
	 * @exception EventException
	 */
	public List<RsltPriSqRtCmdtVO> searchSCRateQuotationList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchPriSqRtCmdtGrpList(priSqRtCmdtHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	
	/**
	 * PRI_SQ_RT_CMDT_ROUT 을 조회 합니다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltPriSqRtCmdtVO>
	 * @exception EventException
	 */
	public List<RsltPriSqRtCmdtRoutVO> searchRateCommodityRouteList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchPriSqRtCmdtRoutVOList(priSqRtCmdtHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	
	/**
	 * PRI_SQ_RT_ROUT_PNT,PRI_SQ_RT_ROUT_VIA,PRI_SQ_RT 을 조회 합니다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return RateQuotationVO
	 * @exception EventException
	 */
	public RateQuotationVO searchRateList(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws EventException {
		try {
			//컨테이너 vo
			RateQuotationVO rateQuotationVO = new RateQuotationVO();
			//detail List
			List<RsltPriSqRtCmdtVO> 	rsltPriSqRtCmdtVOList 	 		= new ArrayList<RsltPriSqRtCmdtVO>();
			List<RsltPriSqRtRoutPntVO> 	rsltPriSqRtRoutOrgPntVOList 	= new ArrayList<RsltPriSqRtRoutPntVO>();
			List<RsltPriSqRtRoutPntVO> 	rsltPriSqRtRoutDestPntVOList 	= new ArrayList<RsltPriSqRtRoutPntVO>();
			List<RsltPriSqRtRoutViaVO> 	rsltPriSqRtRoutOrgViaVOList 	= new ArrayList<RsltPriSqRtRoutViaVO>();
			List<RsltPriSqRtRoutViaVO> 	rsltPriSqRtRoutDestViaVOList 	= new ArrayList<RsltPriSqRtRoutViaVO>();
			List<RsltPriSqRtVO> 		rsltPriSqRtVOList				= new ArrayList<RsltPriSqRtVO>();
			
				
			rsltPriSqRtCmdtVOList 		 = dbDao.searchPriSqRtCmdtVOList(priSqRtCmdtRoutVO);
			rsltPriSqRtRoutOrgPntVOList  = dbDao.searchPriSqRtRoutOrgPntVOList(priSqRtCmdtRoutVO);
			rsltPriSqRtRoutDestPntVOList = dbDao.searchPriSqRtRoutDestPntVOList(priSqRtCmdtRoutVO);
			rsltPriSqRtRoutOrgViaVOList  = dbDao.searchPriSqRtRoutOrgViaVOList(priSqRtCmdtRoutVO);
			rsltPriSqRtRoutDestViaVOList = dbDao.searchPriSqRtRoutDestViaVOList(priSqRtCmdtRoutVO);
			rsltPriSqRtVOList		 	 = dbDao.searchPriSqRtVOList(priSqRtCmdtRoutVO);
			
			rateQuotationVO.setRsltPriSqRtCmdtVOList(rsltPriSqRtCmdtVOList); 
			rateQuotationVO.setRsltPriSqRtRoutOrgPntVOList(rsltPriSqRtRoutOrgPntVOList);
			rateQuotationVO.setRsltPriSqRtRoutDestPntVOList(rsltPriSqRtRoutDestPntVOList);
			rateQuotationVO.setRsltPriSqRtRoutOrgViaVOList(rsltPriSqRtRoutOrgViaVOList);
			rateQuotationVO.setRsltPriSqRtRoutDestViaVOList(rsltPriSqRtRoutDestViaVOList);
			rateQuotationVO.setRsltPriSqRtVOList(rsltPriSqRtVOList);
			
			
			return rateQuotationVO;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}
	
	
	/**
	 * PRI_SQ_RT_CMDT_HDR, PRI_SQ_RT_CMDT 입력 수정 삭제한다<br>
	 * 
	 * @param rateQuotationVO RateQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCommoditySCRateQuotation(RateQuotationVO rateQuotationVO, SignOnUserAccount account) 
		throws EventException{
		try {
			
			//컨테이너 vo에서 CMDT_HDR, CMDT 뺀다
//			PriSqRtCmdtHdrVO priSqRtCmdtHdrVO 		= rateQuotationVO.getPriSqRtCmdtHdrVO();
			PriSqRtCmdtHdrVO[] priSqRtCmdtHdrVOs 	= rateQuotationVO.getPriSqRtCmdtHdrVOs();
			PriSqRtCmdtVO[] priSqRtCmdtVOs 			= rateQuotationVO.getPriSqRtCmdtVOs();
//			PriSqRtCmdtVO[] priSqRtCmdtVOs 			= null;
			
			List<PriSqRtCmdtHdrVO> insertVoList = new ArrayList<PriSqRtCmdtHdrVO>();
			List<PriSqRtCmdtHdrVO> updateVoList = new ArrayList<PriSqRtCmdtHdrVO>();
			List<PriSqRtCmdtHdrVO> deleteVoList = new ArrayList<PriSqRtCmdtHdrVO>();
			List<PriSqRtCmdtVO> insertDtlVoList = new ArrayList<PriSqRtCmdtVO>();
			List<PriSqRtCmdtVO> updateDtlVoList = new ArrayList<PriSqRtCmdtVO>();
			List<PriSqRtCmdtVO> deleteDtlVoList = new ArrayList<PriSqRtCmdtVO>();
			
			
			////////////////////////////CMDT_HDR / CMDT 저장/////////////////////////////////////	
			
			//int max_hdr_seq = dbDao.searchPriSqRtCmdtHdrMaxSeq(priSqRtCmdtHdrVO);
			
			//CMDT_HDR
			for (int i = 0; priSqRtCmdtHdrVOs != null && i < priSqRtCmdtHdrVOs.length; i++) {
				
				if ( priSqRtCmdtHdrVOs[i].getIbflag().equals("I")){
				
					//priSqRtCmdtHdrVOs[i].setCmdtHdrSeq(String.valueOf(max_hdr_seq+i));
					
					priSqRtCmdtHdrVOs[i].setCreUsrId(account.getUsr_id());
					priSqRtCmdtHdrVOs[i].setUpdUsrId(account.getUsr_id());
//					dbDao.addScQuotationCommodityHeader(priSqRtCmdtHdrVOs[i]);
					insertVoList.add(priSqRtCmdtHdrVOs[i]);
										
				} else if ( priSqRtCmdtHdrVOs[i].getIbflag().equals("U")){
					priSqRtCmdtHdrVOs[i].setUpdUsrId(account.getUsr_id());
//					dbDao.modifyScQuotationCommodityHeader(priSqRtCmdtHdrVOs[i]);
					updateVoList.add(priSqRtCmdtHdrVOs[i]);
					
				} else if ( priSqRtCmdtHdrVOs[i].getIbflag().equals("D")){
					priSqRtCmdtHdrVOs[i].setUpdUsrId(account.getUsr_id());
					
					//qttn no, qttn ver no 별  삭제
					PriSqRtCmdtHdrVO delPriSqRtCmdtHdrVO = new PriSqRtCmdtHdrVO();
					delPriSqRtCmdtHdrVO.setQttnNo(priSqRtCmdtHdrVOs[i].getQttnNo());
					delPriSqRtCmdtHdrVO.setQttnVerNo(priSqRtCmdtHdrVOs[i].getQttnVerNo());
					delPriSqRtCmdtHdrVO.setGenSpclRtTpCd(priSqRtCmdtHdrVOs[i].getGenSpclRtTpCd());
					delPriSqRtCmdtHdrVO.setCmdtHdrSeq(priSqRtCmdtHdrVOs[i].getCmdtHdrSeq());
					//cmdt 삭제
					dbDao.removeScQuotationCommodity(delPriSqRtCmdtHdrVO);
					
					PriSqRtCmdtRoutVO delPriSqRtCmdtRoutVO = new PriSqRtCmdtRoutVO();
					delPriSqRtCmdtRoutVO.setQttnNo(priSqRtCmdtHdrVOs[i].getQttnNo());
					delPriSqRtCmdtRoutVO.setQttnVerNo(priSqRtCmdtHdrVOs[i].getQttnVerNo());
					delPriSqRtCmdtRoutVO.setGenSpclRtTpCd(priSqRtCmdtHdrVOs[i].getGenSpclRtTpCd());
					delPriSqRtCmdtRoutVO.setCmdtHdrSeq(priSqRtCmdtHdrVOs[i].getCmdtHdrSeq());
					
					//detail 삭제
					removeRouteRateSCRateQuotationByRout(delPriSqRtCmdtRoutVO);
					//hdr 삭제
					dbDao.removeScQuotationCommodityHeader(priSqRtCmdtHdrVOs[i]);
					
					//이미 삭제 했으므로 null 세팅
					priSqRtCmdtVOs 	= null;
					
				}
			}	
				

			
			//Cmdt
			for (int k = 0; priSqRtCmdtVOs != null && k < priSqRtCmdtVOs.length; k++) {
			
				if(k==0) {
					
					PriSqRtCmdtHdrVO delPriSqRtCmdtHdrVO = new PriSqRtCmdtHdrVO();
					delPriSqRtCmdtHdrVO.setQttnNo(priSqRtCmdtVOs[k].getQttnNo());
					delPriSqRtCmdtHdrVO.setQttnVerNo(priSqRtCmdtVOs[k].getQttnVerNo());
					delPriSqRtCmdtHdrVO.setGenSpclRtTpCd(priSqRtCmdtVOs[k].getGenSpclRtTpCd());
//					delPriSqRtCmdtHdrVO.setCmdtHdrSeq(priSqRtCmdtVOs[k].getCmdtHdrSeq());
					
					dbDao.removeScQuotationCommodity(delPriSqRtCmdtHdrVO);
//					max_seq = dbDao.searchPriSqRtRoutPntMaxSeq(priSqRtRoutOrgPntVOs[i]);
				}
				
//				priSqRtCmdtVOs[k].setCmdtSeq(String.valueOf(max_seq+k));
				priSqRtCmdtVOs[k].setCreUsrId(account.getUsr_id());
				priSqRtCmdtVOs[k].setUpdUsrId(account.getUsr_id());
				
				insertDtlVoList.add(priSqRtCmdtVOs[k]);
				
			}
			
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeScQuotationCommodityS(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeScQuotationCommodityHeaderS(deleteVoList);
			}
				
			if (insertVoList.size() > 0) {
				dbDao.addScQuotationCommodityHeaderS(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addScQuotationCommodityS(insertDtlVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyScQuotationCommodityHeaderS(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyScQuotationCommodityS(updateDtlVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Rate 관련 테이블 Base 별 삭제한다<br>
	 * 
	 * @param priSqRtCmdtRoutVO PriSqRtCmdtRoutVO
	 * @exception EventException
	 */
	public void removeRouteRateSCRateQuotationByRout(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws EventException{
		try {
			
			//Rout 별 모든 데이터를 삭제한다
			if(priSqRtCmdtRoutVO != null) {
				
				dbDao.removeScQuotationRoutePoint(priSqRtCmdtRoutVO);
				dbDao.removeScQuotationRouteVia(priSqRtCmdtRoutVO);
				
				dbDao.removeScQuotationRateUsedRouteCase(priSqRtCmdtRoutVO);
				dbDao.removeScQuotationRateSurcharge(priSqRtCmdtRoutVO);
				dbDao.removeScQuotationRateSurchargeRoute(priSqRtCmdtRoutVO);
				
				
				dbDao.removeScQuotationRate(priSqRtCmdtRoutVO);
				dbDao.removeScQuotationCommodityRoute(priSqRtCmdtRoutVO);
				
			}	
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * PRI_SQ_RT_CMDT_ROUT, PRI_SQ_RT_ROUT_PNT, PRI_SQ_RT_ROUT_VIA, PRI_SQ_RT 입력 수정 삭제한다<br>
	 * 
	 * @param rateQuotationVO RateQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageRouteRateSCRateQuotation(RateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException {
		try {
			
			//vo
//			PriCmpbGlineMnVO priCmpbGlineMnVO 	  = cmpbGuidelineVO.getPriCmpbGlineMnVO();
//			PriCmpbGlineCustVO priCmpbGlineCustVO = cmpbGuidelineVO.getPriCmpbGlineCustVO();
			PriSqRtCmdtHdrVO priSqRtCmdtHdrVO     = rateQuotationVO.getPriSqRtCmdtHdrVO();
			PriSqRtCmdtRoutVO priSqRtCmdtRoutVO   = rateQuotationVO.getPriSqRtCmdtRoutVO();
//			RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO = cmpbGuidelineVO.getRsltDurationCreationOfficeVO();
			
			
			
			PriSqRtCmdtRoutVO[] priSqRtCmdtRoutVOs 		= rateQuotationVO.getPriSqRtCmdtRoutVOs();
			PriSqRtRoutPntVO[] priSqRtRoutOrgPntVOs 	= rateQuotationVO.getPriSqRtRoutOrgPntVOs();
			PriSqRtRoutPntVO[] priSqRtRoutDestPntVOs 	= rateQuotationVO.getPriSqRtRoutDestPntVOs();
			PriSqRtRoutViaVO[] priSqRtRoutOrgViaVOs 	= rateQuotationVO.getPriSqRtRoutOrgViaVOs();
			PriSqRtRoutViaVO[] priSqRtRoutDestViaVOs 	= rateQuotationVO.getPriSqRtRoutDestViaVOs();
			PriSqRtVO[] priSqRtVOs 						= rateQuotationVO.getPriSqRtVOs();
			
			String ibFlag = "";
			
			////////////////////////////Cmdt Rout / detail 저장/////////////////////////////////////	
			
			int max_rout_seq = dbDao.searchPriSqRtCmdtRoutMaxSeq(priSqRtCmdtHdrVO);
			
			//Cmdt Rout 
			for (int i = 0; priSqRtCmdtRoutVOs != null && i < priSqRtCmdtRoutVOs.length; i++) {
				
				ibFlag = priSqRtCmdtRoutVOs[i].getIbflag();
				
				if ( priSqRtCmdtRoutVOs[i].getIbflag().equals("I")){
					
					priSqRtCmdtRoutVOs[i].setRoutSeq(String.valueOf(max_rout_seq+i));
					
					priSqRtCmdtRoutVOs[i].setCreUsrId(account.getUsr_id());
					priSqRtCmdtRoutVOs[i].setUpdUsrId(account.getUsr_id());
					
					dbDao.addScQuotationCommodityRoute(priSqRtCmdtRoutVOs[i]);
					
				} else if ( priSqRtCmdtRoutVOs[i].getIbflag().equals("U")){
					
					priSqRtCmdtRoutVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyScQuotationCommodityRoute(priSqRtCmdtRoutVOs[i]);
					
				} else if ( priSqRtCmdtRoutVOs[i].getIbflag().equals("D")){
					//detail별  삭제
					removeRouteRateSCRateQuotationByRout(priSqRtCmdtRoutVOs[i]);
					//이미 삭제 했으므로 null 세팅
					priSqRtRoutOrgPntVOs 	= null;
					priSqRtRoutDestPntVOs 	= null;
					priSqRtRoutOrgViaVOs 	= null;
					priSqRtRoutDestViaVOs 	= null;
					priSqRtVOs 				= null;
				}
				
			}
			
			int max_seq = -1;
			
			
			PriSqRtRoutPntVO delPriSqRtRoutPntVO = new PriSqRtRoutPntVO();
			
			if(!"D".equals(ibFlag)) {	
				if(priSqRtRoutOrgPntVOs == null || priSqRtRoutOrgPntVOs.length == 0) {
					delPriSqRtRoutPntVO.setQttnNo(priSqRtCmdtRoutVO.getQttnNo());
					delPriSqRtRoutPntVO.setQttnVerNo(priSqRtCmdtRoutVO.getQttnVerNo());
					delPriSqRtRoutPntVO.setGenSpclRtTpCd(priSqRtCmdtRoutVO.getGenSpclRtTpCd());
					delPriSqRtRoutPntVO.setCmdtHdrSeq(priSqRtCmdtRoutVO.getCmdtHdrSeq());
					delPriSqRtRoutPntVO.setRoutSeq(priSqRtCmdtRoutVO.getRoutSeq());
					delPriSqRtRoutPntVO.setOrgDestTpCd("O");
					dbDao.removeScQuotationRoutePoint(delPriSqRtRoutPntVO);
				}	
			}
			
			//OrgRoutPnt
			for (int i = 0; priSqRtRoutOrgPntVOs != null && i < priSqRtRoutOrgPntVOs.length; i++) {
			
				//rout seq 별로 모두 삭제 후 입력
				
				if(i==0) {
					
					delPriSqRtRoutPntVO = new PriSqRtRoutPntVO();
					delPriSqRtRoutPntVO.setQttnNo(priSqRtRoutOrgPntVOs[i].getQttnNo());
					delPriSqRtRoutPntVO.setQttnVerNo(priSqRtRoutOrgPntVOs[i].getQttnVerNo());
					delPriSqRtRoutPntVO.setGenSpclRtTpCd(priSqRtRoutOrgPntVOs[i].getGenSpclRtTpCd());
					delPriSqRtRoutPntVO.setCmdtHdrSeq(priSqRtRoutOrgPntVOs[i].getCmdtHdrSeq());
					delPriSqRtRoutPntVO.setRoutSeq(priSqRtRoutOrgPntVOs[i].getRoutSeq());
					delPriSqRtRoutPntVO.setOrgDestTpCd("O");
					
					dbDao.removeScQuotationRoutePoint(delPriSqRtRoutPntVO);
					max_seq = dbDao.searchPriSqRtRoutPntMaxSeq(priSqRtRoutOrgPntVOs[i]);
				}
				
				priSqRtRoutOrgPntVOs[i].setRoutPntSeq(String.valueOf(max_seq+i));
				priSqRtRoutOrgPntVOs[i].setCreUsrId(account.getUsr_id());
				priSqRtRoutOrgPntVOs[i].setUpdUsrId(account.getUsr_id());
				
				dbDao.addScQuotationRoutePoint(priSqRtRoutOrgPntVOs[i]);
				
			}
			
			
			
			PriSqRtRoutViaVO delPriSqRtRoutViaVO = new PriSqRtRoutViaVO();
			if(!"D".equals(ibFlag)) {
				if(priSqRtRoutOrgViaVOs == null || priSqRtRoutOrgViaVOs.length == 0) {
					delPriSqRtRoutViaVO.setQttnNo(priSqRtCmdtRoutVO.getQttnNo());
					delPriSqRtRoutViaVO.setQttnVerNo(priSqRtCmdtRoutVO.getQttnVerNo());
					delPriSqRtRoutViaVO.setGenSpclRtTpCd(priSqRtCmdtRoutVO.getGenSpclRtTpCd());
					delPriSqRtRoutViaVO.setCmdtHdrSeq(priSqRtCmdtRoutVO.getCmdtHdrSeq());
					delPriSqRtRoutViaVO.setRoutSeq(priSqRtCmdtRoutVO.getRoutSeq());
					delPriSqRtRoutViaVO.setOrgDestTpCd("O");
					dbDao.removeScQuotationRouteVia(delPriSqRtRoutViaVO);
				}	
			}	
			
			//OrgRoutVia
			for (int i = 0; priSqRtRoutOrgViaVOs != null && i < priSqRtRoutOrgViaVOs.length; i++) {
			
				if(i==0) {
				
					//rout seq 별로 모두 삭제 후 입력
					delPriSqRtRoutViaVO = new PriSqRtRoutViaVO();
					delPriSqRtRoutViaVO.setQttnNo(priSqRtRoutOrgViaVOs[i].getQttnNo());
					delPriSqRtRoutViaVO.setQttnVerNo(priSqRtRoutOrgViaVOs[i].getQttnVerNo());
					delPriSqRtRoutViaVO.setGenSpclRtTpCd(priSqRtRoutOrgViaVOs[i].getGenSpclRtTpCd());
					delPriSqRtRoutViaVO.setCmdtHdrSeq(priSqRtRoutOrgViaVOs[i].getCmdtHdrSeq());
					delPriSqRtRoutViaVO.setRoutSeq(priSqRtRoutOrgViaVOs[i].getRoutSeq());
					delPriSqRtRoutViaVO.setOrgDestTpCd("O");
					dbDao.removeScQuotationRouteVia(delPriSqRtRoutViaVO);
					
					max_seq = dbDao.searchPriSqRtRoutViaMaxSeq(priSqRtRoutOrgViaVOs[i]);
					
				}	
				
				priSqRtRoutOrgViaVOs[i].setRoutViaSeq(String.valueOf(max_seq+i));
				priSqRtRoutOrgViaVOs[i].setCreUsrId(account.getUsr_id());
				priSqRtRoutOrgViaVOs[i].setUpdUsrId(account.getUsr_id());
				
				dbDao.addScQuotationRouteVia(priSqRtRoutOrgViaVOs[i]);
				
			}
			
			if(!"D".equals(ibFlag)) {
				if(priSqRtRoutDestViaVOs == null || priSqRtRoutDestViaVOs.length == 0) {
					delPriSqRtRoutViaVO = new PriSqRtRoutViaVO();
					delPriSqRtRoutViaVO.setQttnNo(priSqRtCmdtRoutVO.getQttnNo());
					delPriSqRtRoutViaVO.setQttnVerNo(priSqRtCmdtRoutVO.getQttnVerNo());
					delPriSqRtRoutViaVO.setGenSpclRtTpCd(priSqRtCmdtRoutVO.getGenSpclRtTpCd());
					delPriSqRtRoutViaVO.setCmdtHdrSeq(priSqRtCmdtRoutVO.getCmdtHdrSeq());
					delPriSqRtRoutViaVO.setRoutSeq(priSqRtCmdtRoutVO.getRoutSeq());
					delPriSqRtRoutViaVO.setOrgDestTpCd("D");
					dbDao.removeScQuotationRouteVia(delPriSqRtRoutViaVO);
				}	
			}
			
			//DestRoutVia
			for (int i = 0; priSqRtRoutDestViaVOs != null && i < priSqRtRoutDestViaVOs.length; i++) {
			
				if(i==0) {
					//rout seq 별로 모두 삭제 후 입력
					delPriSqRtRoutViaVO = new PriSqRtRoutViaVO();
					delPriSqRtRoutViaVO.setQttnNo(priSqRtRoutDestViaVOs[i].getQttnNo());
					delPriSqRtRoutViaVO.setQttnVerNo(priSqRtRoutDestViaVOs[i].getQttnVerNo());
					delPriSqRtRoutViaVO.setGenSpclRtTpCd(priSqRtRoutDestViaVOs[i].getGenSpclRtTpCd());
					delPriSqRtRoutViaVO.setCmdtHdrSeq(priSqRtRoutDestViaVOs[i].getCmdtHdrSeq());
					delPriSqRtRoutViaVO.setRoutSeq(priSqRtRoutDestViaVOs[i].getRoutSeq());
					delPriSqRtRoutViaVO.setOrgDestTpCd("D");
					dbDao.removeScQuotationRouteVia(delPriSqRtRoutViaVO);
					
					max_seq = dbDao.searchPriSqRtRoutViaMaxSeq(priSqRtRoutDestViaVOs[i]);
				}
				
				priSqRtRoutDestViaVOs[i].setRoutViaSeq(String.valueOf(max_seq+i));
				priSqRtRoutDestViaVOs[i].setCreUsrId(account.getUsr_id());
				priSqRtRoutDestViaVOs[i].setUpdUsrId(account.getUsr_id());
				
				dbDao.addScQuotationRouteVia(priSqRtRoutDestViaVOs[i]);
				
			}
			
			if(!"D".equals(ibFlag)) {
				if(priSqRtRoutDestPntVOs == null || priSqRtRoutDestPntVOs.length == 0) {
					delPriSqRtRoutPntVO = new PriSqRtRoutPntVO();
					delPriSqRtRoutPntVO.setQttnNo(priSqRtCmdtRoutVO.getQttnNo());
					delPriSqRtRoutPntVO.setQttnVerNo(priSqRtCmdtRoutVO.getQttnVerNo());
					delPriSqRtRoutPntVO.setGenSpclRtTpCd(priSqRtCmdtRoutVO.getGenSpclRtTpCd());
					delPriSqRtRoutPntVO.setCmdtHdrSeq(priSqRtCmdtRoutVO.getCmdtHdrSeq());
					delPriSqRtRoutPntVO.setRoutSeq(priSqRtCmdtRoutVO.getRoutSeq());
					delPriSqRtRoutPntVO.setOrgDestTpCd("D");
					dbDao.removeScQuotationRoutePoint(delPriSqRtRoutPntVO);
				}
			}
			
			//DestRoutPnt
			for (int i = 0; priSqRtRoutDestPntVOs != null && i < priSqRtRoutDestPntVOs.length; i++) {
			
				if(i==0) {
					//rout seq 별로 모두 삭제 후 입력
					delPriSqRtRoutPntVO = new PriSqRtRoutPntVO();
					delPriSqRtRoutPntVO.setQttnNo(priSqRtRoutDestPntVOs[i].getQttnNo());
					delPriSqRtRoutPntVO.setQttnVerNo(priSqRtRoutDestPntVOs[i].getQttnVerNo());
					delPriSqRtRoutPntVO.setGenSpclRtTpCd(priSqRtRoutDestPntVOs[i].getGenSpclRtTpCd());
					delPriSqRtRoutPntVO.setCmdtHdrSeq(priSqRtRoutDestPntVOs[i].getCmdtHdrSeq());
					delPriSqRtRoutPntVO.setRoutSeq(priSqRtRoutDestPntVOs[i].getRoutSeq());
					delPriSqRtRoutPntVO.setOrgDestTpCd("D");
					
					dbDao.removeScQuotationRoutePoint(delPriSqRtRoutPntVO);
					
					if(i==0) max_seq = dbDao.searchPriSqRtRoutPntMaxSeq(priSqRtRoutDestPntVOs[i]);
				}
				
				priSqRtRoutDestPntVOs[i].setRoutPntSeq(String.valueOf(max_seq+i));
				priSqRtRoutDestPntVOs[i].setCreUsrId(account.getUsr_id());
				priSqRtRoutDestPntVOs[i].setUpdUsrId(account.getUsr_id());
				
				dbDao.addScQuotationRoutePoint(priSqRtRoutDestPntVOs[i]);
				
			}
			
			
			
			//마스터가 신규인 경우
			if("I".equals(ibFlag))
				priSqRtCmdtRoutVO.setRoutSeq(String.valueOf(max_rout_seq));
			else
				max_rout_seq = Integer.parseInt(priSqRtCmdtRoutVO.getRoutSeq());
			
			max_seq = dbDao.searchPriSqRtMaxSeq(priSqRtCmdtRoutVO);
			
			//Amt
			for (int i = 0; priSqRtVOs != null && i < priSqRtVOs.length; i++) {
			
				if ( priSqRtVOs[i].getIbflag().equals("I")){
					
					priSqRtVOs[i].setRoutSeq(String.valueOf(max_rout_seq));
					
					priSqRtVOs[i].setRtSeq(String.valueOf(max_seq+i));
	
					priSqRtVOs[i].setCreUsrId(account.getUsr_id());
					priSqRtVOs[i].setUpdUsrId(account.getUsr_id());
					
					dbDao.addScQuotationRate(priSqRtVOs[i]);
					
				} else if ( priSqRtVOs[i].getIbflag().equals("U")){
					priSqRtVOs[i].setCreUsrId(account.getUsr_id());
					priSqRtVOs[i].setUpdUsrId(account.getUsr_id());

					dbDao.modifyScQuotationRate(priSqRtVOs[i]);

				} else if ( priSqRtVOs[i].getIbflag().equals("D")){
					dbDao.removeScQuotationRate(priSqRtVOs[i]);
				}
				
			}
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	

	/**
	 * Quotaion의 route 리스트 조회 이벤트 처리<br>
	 * 
	 * @param inPriCommodityRouteVO InPriCommodityRouteVO
	 * @return List<RsltPriCommodityRouteVO>
	 * @exception EventException
	 */
	public List<RsltPriCommodityRouteVO> searchCommodityRouteList(InPriCommodityRouteVO inPriCommodityRouteVO)
			throws EventException {
		try {
			return dbDao.searchCommodityRouteList(inPriCommodityRouteVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	
	/**
	 * Quotaion의 route의 모든 Area 리스트 조회 이벤트 처리<br>
	 * 구분에 따라 조회 하는 테이블을 달리하지만 성격이 같은 route정보를 조회한다.<BR>
	 * 
	 * @param inPriCommodityRouteVO InPriCommodityRouteVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCommodityRouteAreaList(InPriCommodityRouteVO inPriCommodityRouteVO)
			throws EventException {
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
		try {
			String opTpCd = inPriCommodityRouteVO.getOpTpCd();
			if( opTpCd.equals("A")){
				list= dbDao.searchCommodityRoutePntAreaList(inPriCommodityRouteVO);
			}else if( opTpCd.equals("B")){
				list= dbDao.searchCommodityRouteViaAreaList(inPriCommodityRouteVO);
			}else if( opTpCd.equals("C")){
				list= dbDao.searchCommodityRouteTermAreaList(inPriCommodityRouteVO);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		return list;
	}		
	
	
 
	
	/**
	 * S/C Quotaion의 생성 일자를 조회 처리<br>
	 * 
	 * @param inPriCommodityRouteVO InPriCommodityRouteVO
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO searchSCQuotationCreationDate(InPriCommodityRouteVO inPriCommodityRouteVO)	throws EventException {
		try {
			List<RsltCdListVO> list = dbDao.searchSCQuotationCreationDate(inPriCommodityRouteVO);
			RsltCdListVO vo  = new RsltCdListVO();
			if( list.size() > 0 ){
				vo = list.get(0);
			}
			return vo; 
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	
	



	/**
	 * Quotaion Rate 의 Surcharge Amount값을  갱신처리 합니다.
	 * 
	 * @param inPriQuotationRateAdjustSetVO InPriQuotationRateAdjustSetVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyRateScQuotation(InPriQuotationRateAdjustSetVO inPriQuotationRateAdjustSetVO, SignOnUserAccount account)
			throws EventException {
		try {
			InPriCommodityRouteVO cmdtroutVO = inPriQuotationRateAdjustSetVO.getInPriCommodityRouteVO();
			InPriLocationViaListVO[] locList = inPriQuotationRateAdjustSetVO.getInPriLocationViaListVOS();
			InPriRateAdjustListVO[] adjList = inPriQuotationRateAdjustSetVO.getInPriRateAdjustListVOS();
			List<InPriLocationViaListVO> updateVoList = new ArrayList<InPriLocationViaListVO>();
			for (int i = 0; i < locList.length; i++) {
				String seq = locList[i].getSeq();
				for (int j = 0; j < adjList.length; j++) {
					if(seq.equals(adjList[j].getParentsSeq())){
						InPriLocationViaListVO inParam = (InPriLocationViaListVO)locList[i].clone();
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
				log.debug("===========>>>>>"+updateVoList.get(i).getAmount());
			}		
			
			if (updateVoList.size() > 0) {
				dbDao.modifyRateScQuotation(updateVoList,cmdtroutVO);
			}			
			//dbDao.searchTEMP( updateVoList,  cmdtroutVO);
 
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	
	/**
	 * Rate 관련 테이블 에 가이드라인 정보를 조회 입력한다<br>
	 * 
	 * @param rsltPriSqMnVO RsltPriSqMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void glineCopyScRateQuotation(RsltPriSqMnVO rsltPriSqMnVO, SignOnUserAccount account) 
		throws EventException{
		try {
			rsltPriSqMnVO.setCreUsrId(account.getUsr_id());
			rsltPriSqMnVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.addGlineCopyScQuotationCommodityHeader(rsltPriSqMnVO);
			dbDao.addGlineCopyScQuotationCommodity(rsltPriSqMnVO);
			dbDao.addGlineCopyScQuotationCommodityRoute(rsltPriSqMnVO);
			dbDao.addGlineCopyScQuotationRoutePoint(rsltPriSqMnVO);
			dbDao.addGlineCopyScQuotationRouteVia(rsltPriSqMnVO);
			dbDao.addGlineCopyScQuotationRate(rsltPriSqMnVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * COPY TO QUOTATION Rate 관련 테이블<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyToQuotationScRateQuotaionReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) 
		throws EventException{
		try {
			rsltCopyToQuotationVO.setCreUsrId(account.getUsr_id());
			rsltCopyToQuotationVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.addCopyToQuotationScQuotationCommodityHeader(rsltCopyToQuotationVO);
			dbDao.addCopyToQuotationScQuotationCommodity(rsltCopyToQuotationVO);
			dbDao.addCopyToQuotationScQuotationCommodityRoute(rsltCopyToQuotationVO);
			dbDao.addCopyToQuotationScQuotationRoutePoint(rsltCopyToQuotationVO);
			dbDao.addCopyToQuotationScQuotationRouteVia(rsltCopyToQuotationVO);
			dbDao.addCopyToQuotationScQuotationRate(rsltCopyToQuotationVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	
	/**
	 * REMOVE Rate 관련 테이블 BY QTTN NO<br>
	 * 
	 * @param priSqHdrVO PriSqHdrVO
	 * @exception EventException
	 */
	public void removeScRateQuotation(PriSqHdrVO priSqHdrVO) throws EventException{
		try {
			
			dbDao.removeScQuotationScgAdj(priSqHdrVO);
			dbDao.removeScQuotationSchg(priSqHdrVO);
			dbDao.removeScQuotationSchgRout(priSqHdrVO);
			dbDao.removeScQuotationUsdRoutCs(priSqHdrVO);
			
			dbDao.removeScQuotationRate(priSqHdrVO);
			dbDao.removeScQuotationRoutVia(priSqHdrVO);
			dbDao.removeScQuotationRoutPnt(priSqHdrVO);
			dbDao.removeScQuotationCommodityRoute(priSqHdrVO);
			dbDao.removeScQuotationCommodity(priSqHdrVO);
			dbDao.removeScQuotationCommodityHeader(priSqHdrVO);
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	/**
	 * Quotaion Rate View All<br>
	 * 
	 * @param priSqRtCmdtHdrVO PriSqRtCmdtHdrVO
	 * @return List<RsltPriSqRtAllViewVO>
	 * @exception EventException
	 */
	public List<RsltPriSqRtAllViewVO> searchViewAllSCRateQuotationList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO)
			throws EventException {
		try {
			return dbDao.searchViewAllSCRateQuotationList(priSqRtCmdtHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	
	

	
	/**
	 * Calculate Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @param String rotationPrsBatId
	 * @param SignOnUserAccount account
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO executeCalculate(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO, String rotationPrsBatId, SignOnUserAccount account) throws EventException {
		try {
			//컨테이너 vo
//			RateQuotationVO rateQuotationVO = new RateQuotationVO();
			ScheduleUtil schedule = new ScheduleUtil();

			PriPrsBatVO priPrsBatVO = null;
			List<PriSqMnVO> priSqMnVOList;
			PriSqMnVO priSqMnVO = new PriSqMnVO();
			String params = "";
			String jobID = "";
			String pgmNm = "";
			
 
			
			priSqMnVO.setQttnNo(priSqRtCmdtRoutVO.getQttnNo() );
			priSqMnVO.setQttnVerNo(priSqRtCmdtRoutVO.getQttnVerNo() );
			
			priSqMnVOList = dbDao.searchPriSqMn(priSqMnVO);
			if( priSqMnVOList.size() != 0){
				params = priSqRtCmdtRoutVO.getQttnNo() 
						+ "#" + priSqRtCmdtRoutVO.getQttnVerNo()
						+ "#" + priSqMnVOList.get(0).getSvcScpCd()
						+ "#" + priSqRtCmdtRoutVO.getGenSpclRtTpCd()
						+ "#" + priSqMnVOList.get(0).getCustCntCd()
						+ "#" + priSqMnVOList.get(0).getCustSeq()
						+ "#" + account.getUsr_id();
				
				/********************************************************************/
				 
				if ( rotationPrsBatId.length() == 1 ) {
					pgmNm = "0"+rotationPrsBatId;
				}else{
					pgmNm = rotationPrsBatId;
				}
				pgmNm = "ESM_PRI_B006-"+pgmNm;
				log.debug("== pgmNm == "+pgmNm);
				if(!schedule.isRunning(pgmNm)){
					jobID = schedule.directExecuteJob(pgmNm, params);	
		 			
		 			priPrsBatVO = new PriPrsBatVO();
		 			priPrsBatVO.setPrsBatId(jobID);
		 			priPrsBatVO.setParaInfoCtnt(params);
		 			priPrsBatVO.setPgmNo(pgmNm);
				}else{
					throw new EventException(new ErrorHandler("PRI03027", new String[]{}).getMessage());
				}
				log.debug("== jobID == "+jobID);
				/********************************************************************/
						
//	 			jobID = schedule.directExecuteJob("ESM_PRI_B006", params);
//	 			
//	 			priPrsBatVO = new PriPrsBatVO();
//	 			priPrsBatVO.setPrsBatId(jobID);
//	 			priPrsBatVO.setParaInfoCtnt(params);
//	 			priPrsBatVO.setPgmNo("ESM_PRI_B006");
	 			
			}
			return priPrsBatVO;
			
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
		
	}
	

	/**
	 * Calculate Batch ID를 조회 하기 위한 Parameter를 조합한다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO searchMonitorCalculateParam(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws EventException {
		try {
			PriPrsBatVO priPrsBatVO = null;
			List<PriSqMnVO> priSqMnVOList;
			PriSqMnVO priSqMnVO = new PriSqMnVO();
			String params = "";
			
			//조회불가 메시지
			if( priSqRtCmdtRoutVO.getQttnNo()  == null || priSqRtCmdtRoutVO.getQttnVerNo() == null){
				throw new EventException(new ErrorHandler("PRI02014").getMessage());
			}
			priSqMnVO.setQttnNo(priSqRtCmdtRoutVO.getQttnNo() );
			priSqMnVO.setQttnVerNo(priSqRtCmdtRoutVO.getQttnVerNo() );
			
			priSqMnVOList = dbDao.searchPriSqMn(priSqMnVO);
			
			
			if( priSqMnVOList.size() != 0){
				params = priSqRtCmdtRoutVO.getQttnNo() 
						+ "#" + priSqRtCmdtRoutVO.getQttnVerNo()
						+ "#" + priSqMnVOList.get(0).getSvcScpCd()
						+ "#" + priSqRtCmdtRoutVO.getGenSpclRtTpCd()
						+ "#" + priSqMnVOList.get(0).getCustCntCd()
						+ "#" + priSqMnVOList.get(0).getCustSeq()
						+ "#" ; //USER ID정보는  parameter 정보에서 빼고 like 검색으로 batch id를 검색한다.

	 			priPrsBatVO = new PriPrsBatVO();
	 			priPrsBatVO.setParaInfoCtnt(params);
	 			priPrsBatVO.setPgmNo("ESM_PRI_B006");
	 			
			}else{ //조회 불가 메시지
				throw new EventException(new ErrorHandler("PRI02014").getMessage());
			}
			return priPrsBatVO;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
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
 					if( Float.compare(min,10.0f) > 0 ){  // 10분이 지다도 0이 return될때 Batch 서버가 해당 Calc를 돌려주지 못했다고 판단한다. Code 99
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
	 * 멀티 이벤트 처리<br>
	 * S/C RATE관련 Cost, CMPB,OPB 값을 갱신하고 그 갱신여부를 Mark해둔다.
	 * 
	 * @param rsltPriPrsCostListVOS RsltPriPrsCostListVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyPrsCost(RsltPriPrsCostListVO[] rsltPriPrsCostListVOS, SignOnUserAccount account)
			throws EventException {
		try {
			List<RsltPriPrsCostListVO> rateUpdateVoList = new ArrayList<RsltPriPrsCostListVO>();
			List<RsltPriPrsCostListVO> routCsUpdateVoList = new ArrayList<RsltPriPrsCostListVO>();

			for (int i = 0; i < rsltPriPrsCostListVOS.length; i++) {
				if (rsltPriPrsCostListVOS[i].getIbflag().equals("U")) {
					rsltPriPrsCostListVOS[i].setUpdUsrId(account.getUsr_id());
					if( "Y".equals(rsltPriPrsCostListVOS[i].getUsdRoutCsSelFlg() ) || "1".equals(rsltPriPrsCostListVOS[i].getUsdRoutCsSelFlg() ) ){
						rateUpdateVoList.add(rsltPriPrsCostListVOS[i]);
						rsltPriPrsCostListVOS[i].setUsdRoutCsSelFlg("Y");
					}else{
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
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	

	/**
	 * Route의 선택여부를 Mark해둔다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyPrsRateCommodityRoute(List<RsltPriPrsCostListVO>  rsltPriPrsCostListVO) throws EventException{
		try {
			dbDao.modifyPrsRateCommodityRoute(rsltPriPrsCostListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Calculate Logic을 이용해 data를 갱신한다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyCalculateLogicData(List<RsltPriPrsCostListVO>  rsltPriPrsCostListVO) throws EventException{
		try {
			
			dbDao.modifyRate(rsltPriPrsCostListVO);
			//SCQuotationCalculate Logic 추가
			dbDao.removePriSqRtScgRoutCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.addPriSqRtScgRoutCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.removePriSqRtScgCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.addPriSqRtScgCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.addPriSqRtScgAmtCostDetail(rsltPriPrsCostListVO.get(0),"2");
			dbDao.modifyPriSqRtSurchargeCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriSqRtCMPBCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriSqRtSvcLaneCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriSqRtGlineMappingCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriSqRtCmdtRoutEstmCostDetail(rsltPriPrsCostListVO.get(0));			
			
			
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
	 * @param RsltPriPrsCostListVO[] rsltPriPrsCostListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsSimulationCost(RsltPriPrsCostListVO[] rsltPriPrsCostListVOS, SignOnUserAccount account)
			throws EventException {
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
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
			
	
	
	/**
	 * Rate Proposal Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateListVerticalExcel(priSqRtCmdtHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Rate Proposal Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param priSqRtCmdtHdrVO PriSqRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateListHorizontalExcel(priSqRtCmdtHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * SC Rate CMPB VIEW ALL (ESM_PRI_6074) 리스트를 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */
	public List<RsltCmpbViewAllListVO> searchRateCmpbViewAllList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateCmpbViewAllList(priSqRtCmdtHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * SQ Rate LOAD EXCEL(ESM_PRI_6006) 화면에 대한 입력 이벤트 처리<br>
	 * 
	 * @param PriSqRtCmdtHdrVO PriSqRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelHorizontal(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs, SignOnUserAccount account) 
		throws EventException {
		
		List<PriSqRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriSqRtCmdtHdrVO>();
		List<PriSqRtCmdtVO> cmdtVoList = new ArrayList<PriSqRtCmdtVO>();
		List<PriSqRtCmdtRoutVO> routVoList = new ArrayList<PriSqRtCmdtRoutVO>();
		List<PriSqRtRoutPntVO> pntVoList = new ArrayList<PriSqRtRoutPntVO>();
		List<PriSqRtRoutViaVO> viaVoList = new ArrayList<PriSqRtRoutViaVO>();
		List<PriSqRtVO> rtVoList = new ArrayList<PriSqRtVO>();
		
		try {
			int nextCmdtHdrSeq = dbDao.searchPriSqRtCmdtHdrMaxSeq(priSqRtCmdtHdrVO);
			nextCmdtHdrSeq = nextCmdtHdrSeq-1;
			
			int nextCmdtSeq = 0;
			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;
			
			String strQttnNo = priSqRtCmdtHdrVO.getQttnNo();
			String strQttnVerNo = priSqRtCmdtHdrVO.getQttnVerNo();
			String strGenSpclRtTpCd = priSqRtCmdtHdrVO.getGenSpclRtTpCd();
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
				String strDirCall = (row.getDirCallFlg() == null || "".equals(row.getDirCallFlg())) ? "N" : row.getDirCallFlg();
				
				String strRateDry20 = row.getRateDry20();
				String strRateDry40 = row.getRateDry40();
				String strRateDry40hc = row.getRateDry40hc();
				String strRateDry45 = row.getRateDry45();
				String strRateRf40hc = row.getRateRf40hc();
				String strRateRd40hc = row.getRateRd40hc();
				
				//cmdt hdr
				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextCmdtSeq = 0;
					nextRoutSeq = 0;
					
					PriSqRtCmdtHdrVO cmdtHdr = new PriSqRtCmdtHdrVO();
					cmdtHdr.setQttnNo(strQttnNo);
					cmdtHdr.setQttnVerNo(strQttnVerNo);
					cmdtHdr.setGenSpclRtTpCd(strGenSpclRtTpCd);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setSrcInfoCd("NW");
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);
					
					cmdtHdrVoList.add(cmdtHdr);
				}
				
				//cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;
					
					String cmdtTpCd = "";
					if(strCmdtCd.length() == 6) cmdtTpCd = "C";
					else if(strCmdtCd.length() == 5) cmdtTpCd = "G";
					else if(strCmdtCd.length() == 4) cmdtTpCd = "R";
					
					
					PriSqRtCmdtVO cmdt = new PriSqRtCmdtVO();
					cmdt.setQttnNo(strQttnNo);
					cmdt.setQttnVerNo(strQttnVerNo);
					cmdt.setGenSpclRtTpCd(strGenSpclRtTpCd);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setSrcInfoCd("NW");
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);
					
					cmdtVoList.add(cmdt);
				}
				
				//cmdt rout
				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;
					
					PriSqRtCmdtRoutVO rout = new PriSqRtCmdtRoutVO();
					rout.setQttnNo(strQttnNo);
					rout.setQttnVerNo(strQttnVerNo);
					rout.setGenSpclRtTpCd(strGenSpclRtTpCd);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setDirCallFlg(strDirCall);
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);
					
					routVoList.add(rout);
				}
				
				//pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;
					
					String locTpCd = "";
					
					if(strOrgPntCd.length() == 5) locTpCd = "L";
					else if(strOrgPntCd.length() == 4) locTpCd = "G";
					else if(strOrgPntCd.length() == 3) locTpCd = "R";
					else if(strOrgPntCd.length() == 2) locTpCd = "C";
					
					PriSqRtRoutPntVO pnt = new PriSqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
				
				//via origin
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					nextRoutViaSeq++;
					
					String locTpCd = "";
					
					if(strOrgViaCd.length() == 5) locTpCd = "L";
					else if(strOrgViaCd.length() == 4) locTpCd = "G";
					else if(strOrgViaCd.length() == 3) locTpCd = "R";
					else if(strOrgViaCd.length() == 2) locTpCd = "C";
					
					PriSqRtRoutViaVO via = new PriSqRtRoutViaVO();
					via.setQttnNo(strQttnNo);
					via.setQttnVerNo(strQttnVerNo);
					via.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
				
				//via dest
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					nextRoutViaSeq++;
					
					String locTpCd = "";
					
					if(strDestViaCd.length() == 5) locTpCd = "L";
					else if(strDestViaCd.length() == 4) locTpCd = "G";
					else if(strDestViaCd.length() == 3) locTpCd = "R";
					else if(strDestViaCd.length() == 2) locTpCd = "C";
					
					PriSqRtRoutViaVO via = new PriSqRtRoutViaVO();
					via.setQttnNo(strQttnNo);
					via.setQttnVerNo(strQttnVerNo);
					via.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
				
				//pnt dest
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;
					
					String locTpCd = "";
					
					if(strDestPntCd.length() == 5) locTpCd = "L";
					else if(strDestPntCd.length() == 4) locTpCd = "G";
					else if(strDestPntCd.length() == 3) locTpCd = "R";
					else if(strDestPntCd.length() == 2) locTpCd = "C";
					
					PriSqRtRoutPntVO pnt = new PriSqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
				
				
				PriSqRtVO rt = new PriSqRtVO();
				//Dry 20
				if (strRateDry20 != null && !"".equals(strRateDry20)) {
					nextRtSeq++;
					
					rt = new PriSqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
				
				//Dry 40	
				if (strRateDry40 != null && !"".equals(strRateDry40)) {
					nextRtSeq++;
					
					rt = new PriSqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
				
				//Dry 40 hc
				if (strRateDry40hc != null && !"".equals(strRateDry40hc)) {
					nextRtSeq++;
					
					rt = new PriSqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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

				//Dry45
				if (strRateDry45 != null && !"".equals(strRateDry45)) {
					nextRtSeq++;
					
					rt = new PriSqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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

				//Rf40hc
				if (strRateRf40hc != null && !"".equals(strRateRf40hc)) {
					nextRtSeq++;
					
					rt = new PriSqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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

				//Rd40hc
				if (strRateRd40hc != null && !"".equals(strRateRd40hc)) {
					nextRtSeq++;
					
					rt = new PriSqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
				dbDao.addScQuotationCommodityHeaderS(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addScQuotationCommodityS(cmdtVoList);
			}
			if (routVoList.size() > 0) {
				dbDao.addScQuotationCommodityRouteS(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addScQuotationRoutePointS(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addScQuotationRouteViaS(viaVoList);
			}
			if (rtVoList.size() > 0) {
				dbDao.addScQuotationRateS(rtVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * SQ Rate LOAD EXCEL(ESM_PRI_6006) 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param priSqRtCmdtHdrVO PriSqRtCmdtHdrVO
	 * @param rsltRtListHorizontalExcelVOs RsltRtListHorizontalExcelVO[]
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelHorizontal(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs) throws EventException {
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
		
		try {
			for (int i = 0; i < rsltRtListHorizontalExcelVOs.length; i++) {
				RsltRtListHorizontalExcelVO row = rsltRtListHorizontalExcelVOs[i];
				
				String strCmdtCd = row.getPrcCmdtDefCd();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				
				//cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setQttnNo(priSqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priSqRtCmdtHdrVO.getQttnVerNo());
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
				
				//pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setQttnNo(priSqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priSqRtCmdtHdrVO.getQttnVerNo());
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
					paramVO.setQttnNo(priSqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priSqRtCmdtHdrVO.getQttnVerNo());
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
					paramVO.setQttnNo(priSqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priSqRtCmdtHdrVO.getQttnVerNo());
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
					paramVO.setQttnNo(priSqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priSqRtCmdtHdrVO.getQttnVerNo());
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
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
		return rslt;
	}
	
	
	/**
	 * SQ Rate LOAD EXCEL(ESM_PRI_6007) 화면에 대한 입력 이벤트 처리<br>
	 * 
	 * @param PriSqRtCmdtHdrVO PriSqRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVertical(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account) 
		throws EventException {
		
		List<PriSqRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriSqRtCmdtHdrVO>();
		List<PriSqRtCmdtVO> cmdtVoList = new ArrayList<PriSqRtCmdtVO>();
		List<PriSqRtCmdtRoutVO> routVoList = new ArrayList<PriSqRtCmdtRoutVO>();
		List<PriSqRtRoutPntVO> pntVoList = new ArrayList<PriSqRtRoutPntVO>();
		List<PriSqRtRoutViaVO> viaVoList = new ArrayList<PriSqRtRoutViaVO>();
		List<PriSqRtVO> rtVoList = new ArrayList<PriSqRtVO>();
		
		try {
			int nextCmdtHdrSeq = dbDao.searchPriSqRtCmdtHdrMaxSeq(priSqRtCmdtHdrVO);
			nextCmdtHdrSeq = nextCmdtHdrSeq-1;
			
			int nextCmdtSeq = 0;
			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;
			
			String strQttnNo = priSqRtCmdtHdrVO.getQttnNo();
			String strQttnVerNo = priSqRtCmdtHdrVO.getQttnVerNo();
			String strGenSpclRtTpCd = priSqRtCmdtHdrVO.getGenSpclRtTpCd();
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
				String strDirCall = (row.getDirCallFlg() == null || "".equals(row.getDirCallFlg())) ? "N" : row.getDirCallFlg();
				
				String strRatUtCd = row.getRatUtCd();
				String strPrcCgoTpCd = row.getPrcCgoTpCd();
				String strCurrCd = "USD";
				String strQttnRtAmt = row.getQttnRtAmt();
				
				//cmdt hdr
				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextCmdtSeq = 0;
					nextRoutSeq = 0;
					
					PriSqRtCmdtHdrVO cmdtHdr = new PriSqRtCmdtHdrVO();
					cmdtHdr.setQttnNo(strQttnNo);
					cmdtHdr.setQttnVerNo(strQttnVerNo);
					cmdtHdr.setGenSpclRtTpCd(strGenSpclRtTpCd);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setSrcInfoCd("NW");
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);
					
					cmdtHdrVoList.add(cmdtHdr);
				}
				
				//cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;
					
					String cmdtTpCd = "";
					if(strCmdtCd.length() == 6) cmdtTpCd = "C";
					else if(strCmdtCd.length() == 5) cmdtTpCd = "G";
					else if(strCmdtCd.length() == 4) cmdtTpCd = "R";
					
					
					PriSqRtCmdtVO cmdt = new PriSqRtCmdtVO();
					cmdt.setQttnNo(strQttnNo);
					cmdt.setQttnVerNo(strQttnVerNo);
					cmdt.setGenSpclRtTpCd(strGenSpclRtTpCd);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setSrcInfoCd("NW");
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);
					
					cmdtVoList.add(cmdt);
				}
				
				//cmdt rout
				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;
					
					PriSqRtCmdtRoutVO rout = new PriSqRtCmdtRoutVO();
					rout.setQttnNo(strQttnNo);
					rout.setQttnVerNo(strQttnVerNo);
					rout.setGenSpclRtTpCd(strGenSpclRtTpCd);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setDirCallFlg(strDirCall);
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);
					
					routVoList.add(rout);
				}
				
				//pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;
					
					String locTpCd = "";
					
					if(strOrgPntCd.length() == 5) locTpCd = "L";
					else if(strOrgPntCd.length() == 4) locTpCd = "G";
					else if(strOrgPntCd.length() == 3) locTpCd = "R";
					else if(strOrgPntCd.length() == 2) locTpCd = "C";
					
					PriSqRtRoutPntVO pnt = new PriSqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
				
				//via origin
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					nextRoutViaSeq++;
					
					String locTpCd = "";
					
					if(strOrgViaCd.length() == 5) locTpCd = "L";
					else if(strOrgViaCd.length() == 4) locTpCd = "G";
					else if(strOrgViaCd.length() == 3) locTpCd = "R";
					else if(strOrgViaCd.length() == 2) locTpCd = "C";
					
					PriSqRtRoutViaVO via = new PriSqRtRoutViaVO();
					via.setQttnNo(strQttnNo);
					via.setQttnVerNo(strQttnVerNo);
					via.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
				
				//via dest
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					nextRoutViaSeq++;
					
					String locTpCd = "";
					
					if(strDestViaCd.length() == 5) locTpCd = "L";
					else if(strDestViaCd.length() == 4) locTpCd = "G";
					else if(strDestViaCd.length() == 3) locTpCd = "R";
					else if(strDestViaCd.length() == 2) locTpCd = "C";
					
					PriSqRtRoutViaVO via = new PriSqRtRoutViaVO();
					via.setQttnNo(strQttnNo);
					via.setQttnVerNo(strQttnVerNo);
					via.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
				
				//pnt dest
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;
					
					String locTpCd = "";
					
					if(strDestPntCd.length() == 5) locTpCd = "L";
					else if(strDestPntCd.length() == 4) locTpCd = "G";
					else if(strDestPntCd.length() == 3) locTpCd = "R";
					else if(strDestPntCd.length() == 2) locTpCd = "C";
					
					PriSqRtRoutPntVO pnt = new PriSqRtRoutPntVO();
					pnt.setQttnNo(strQttnNo);
					pnt.setQttnVerNo(strQttnVerNo);
					pnt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
				
				
				
				//rate
				if (strQttnRtAmt != null && !"".equals(strQttnRtAmt)) {
					nextRtSeq++;
					
					PriSqRtVO rt = new PriSqRtVO();
					rt.setQttnNo(strQttnNo);
					rt.setQttnVerNo(strQttnVerNo);
					rt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
				dbDao.addScQuotationCommodityHeaderS(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addScQuotationCommodityS(cmdtVoList);
			}
			if (routVoList.size() > 0) {
				dbDao.addScQuotationCommodityRouteS(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addScQuotationRoutePointS(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addScQuotationRouteViaS(viaVoList);
			}
			if (rtVoList.size() > 0) {
				dbDao.addScQuotationRateS(rtVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * SQ Rate LOAD EXCEL(ESM_PRI_6007) 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVertical(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs) throws EventException {
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
		
		try {
			for (int i = 0; i < rsltRtListVerticalExcelVOs.length; i++) {
				RsltRtListVerticalExcelVO row = rsltRtListVerticalExcelVOs[i];
				
				String strCmdtCd = row.getPrcCmdtDefCd();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				
				//cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setQttnNo(priSqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priSqRtCmdtHdrVO.getQttnVerNo());
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
				
				//pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setQttnNo(priSqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priSqRtCmdtHdrVO.getQttnVerNo());
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
					paramVO.setQttnNo(priSqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priSqRtCmdtHdrVO.getQttnVerNo());
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
					paramVO.setQttnNo(priSqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priSqRtCmdtHdrVO.getQttnVerNo());
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
					paramVO.setQttnNo(priSqRtCmdtHdrVO.getQttnNo());
					paramVO.setQttnVerNo(priSqRtCmdtHdrVO.getQttnVerNo());
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
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
		return rslt;
	}
	
	/**
	 * Rate Route Case를 추가 한다. .<br>
	 * 
	 * @param PriSqRtUsdRoutCsVO priSqRtUsdRoutCsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriRateUsedRouteCase(PriSqRtUsdRoutCsVO priSqRtUsdRoutCsVO, SignOnUserAccount account) throws EventException{	
		try {
			List<PriSqRtUsdRoutCsVO> priSqRtUsdRoutCsVOs = new ArrayList<PriSqRtUsdRoutCsVO>();
			if (priSqRtUsdRoutCsVO != null) {
				priSqRtUsdRoutCsVO.setUpdUsrId(account.getUsr_id());
				priSqRtUsdRoutCsVO.setUsdRoutCsSelFlg("Y");
				priSqRtUsdRoutCsVOs.add(priSqRtUsdRoutCsVO);
			}
			dbDao.addPriRateUsedRouteCase(priSqRtUsdRoutCsVOs);
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
	 * S/C Quotation - Rate Tab의 Surcharge View All Popup의 내용을 조회를 처리합니다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltPriSurchargeViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeViewAllVO> searchSurchargeViewAllList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchSurchargeViewAllList(priSqRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}    
	
	
	/**
	 * S/C Quotation - Rate Tab의 Surcharge View All Popup에서 Surcharge 값이 언제 만들어 졌는지를 조회 처리합니다.<br>
	 * 
	 * @param priSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltPriSurchargeLastAccessDateVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeLastAccessDateVO> searchSurchargeLastAccessDateList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchSurchargeLastAccessDateList(priSqRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}    
	
}