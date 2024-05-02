/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CndCustomsTransmissionBCImpl.java
 *@FileTitle : CustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2013.06.10 김보배 [CHM-201324023] ACI - Vessel Arrival Transmit (A6) 화면 및 로직 보완
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.basic;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.common.CountryCode;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration.CndCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BayPlanCntrDetailCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BayPlanCntrListConCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BayPlanPolDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BlInfoForFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsTrsmRsltListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsTrsmRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndVesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CstmsSendLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.SendDetailLogCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.SendLogDetailCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.StiCondListCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.StiDetailCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.VesselEtaCondCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.VesselEtaInfoCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.BayPlanCntrDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.StowageManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsAdvBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvEdiBlRspnVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRcvLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRcvLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvSndLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsCndVslVO;
import com.hanjin.syscommon.common.table.BkgDocProcSkdVO;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Min Jeong
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CndCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {
	// Database Access Object
	private transient CndCustomsTransmissionDBDAO dbDao = null;
	private BookingHistoryMgtBC bkgHisBC = null;	

	/**
	 * CndCustomsTransmissionBCImpl 객체 생성<br>
	 * CndCustomsTransmissionDBDAO 생성한다.<br>
	 */
	public CndCustomsTransmissionBCImpl() {
		dbDao = new CndCustomsTransmissionDBDAO();
	}
	
	/**
	 * 입출항 선박 신고된 적하목록 현황 조회 
	 * @param cstmsManifestCondVO 조회조건
	 * @return List<CstmsManifestVO>
	 * @exception EventException
	 */
	public List<CstmsManifestVO> searchManifestList(CstmsManifestCondVO cstmsManifestCondVO) throws EventException {
		try
		{
			return dbDao.searchCndCstmsManifest((CndCstmsManifestCondVO) cstmsManifestCondVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
		
	/**
	 * 입출항 선박 신고된 적하목록 현황 조회 
	 * @param cstmsManifestCondVO 조회조건
	 * @return List<CstmsManifestVO>
	 * @exception EventException
	 */
	public List<CstmsManifestVO> searchExportManifestList(CstmsManifestCondVO cstmsManifestCondVO) throws EventException {
		try
		{
			return dbDao.searchCndCstmsExportManifest((CndCstmsManifestCondVO) cstmsManifestCondVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}		

	/**
	 * 세관 신고 대상 상세List를 조회한다.
	 * 
	 * @param cstmsManifestCondVO 조회조건
	 * @return List<CstmsManifestVO>
	 * @throws EventException
	 */
	public List<CstmsManifestVO> searchManifestDtlList(CstmsManifestCondVO cstmsManifestCondVO)
			throws EventException {
		try
		{
			return dbDao.searchCndCstmsManifestDtl((CndCstmsManifestCondVO) cstmsManifestCondVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Vessel Arrival 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param vesselArrivalTransmitVO 전송정보
	 * @param account 세션정보
	 * @return String
	 * @throws EventException
	 */
	public String transmitVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account)
			throws EventException {
		CndVesselArrivalTransmitVO condVO = (CndVesselArrivalTransmitVO) vesselArrivalTransmitVO;
		try
		{
			// ACI Vessel Information
			CndVesselArrivalTransmitVO vslVO = dbDao.searchVesselArrival(condVO);
			if (!"".equals(vslVO.getDtNullChk()))
			{
				// ACI Vessel Information 화면 (UI_BKG-0016) 에 data 가 빠져있는 경우 에러처리
				String[] changeStr = { vslVO.getDtNullChk() };
				throw new EventException(new ErrorHandler("BKG00976", changeStr).getMessage());
			}
			if (!"".equals(vslVO.getDtDiffChk()))
			{
				// 만료일자가 Last Foreign Port Departure Date 보다 이전인 경우 에러처리
				String[] changeStr = { vslVO.getDtDiffChk() };
				throw new EventException(new ErrorHandler("BKG00977", changeStr).getMessage());
			}
			if ("D".equals(condVO.getDelFlag()))
			{
				vslVO.setStatus("03");
			}
			else
			{
				// 삭제 전송이 아닐 경우
				//@ TO-BE LOGIC
//				if ("".equals(vslVO.getCstmsTrsmStsCd())){
//					vslVO.setStatus("00");//보낸 적이 없으면 00
//				//@ 이전에 전송한것이 삭제 03이면 00전송
//				}else if ("03".equals(vslVO.getCstmsTrsmStsCd()) ){
//					vslVO.setStatus("00");
//				}else{
//					vslVO.setStatus("04");//04
//				}
				
				//@ AS-IS LOGIC
				// 이전로직으로 복귀 Accept받은 후 전송의 경우 수정 전송임. 2018.05.25
				if ("A".equals(vslVO.getCndAckRspnCd()))
				{
					vslVO.setStatus("04");
				}
				else
				{
					vslVO.setStatus("00");
				}
			}
			// MAX POL POD
			CndVesselArrivalTransmitVO polVO = dbDao.searchPolPod(condVO);
			// PORT List
			List<CndVesselArrivalTransmitVO> portList = dbDao.searchVesselPort(condVO);
			/***********************************************************
			 * flatFile 만들기
			 ***********************************************************/
			String flatFile = makeCndVesselArrivalFlatFile(condVO, vslVO, polVO, portList);
			/***********************************************************
			 * 로그VO 세팅
			 ***********************************************************/
			CstmsSendLogVO logVO = new CstmsSendLogVO();
			logVO.setCntCd(CountryCode.CA);
			logVO.setIoBndCd("I");
			logVO.setSndDt(condVO.getVslArrRptSndDt());
			logVO.setTrsmMsgTpId("A6");
			logVO.setVslCd(condVO.getVslCd());
			logVO.setSkdVoyNo(condVO.getSkdVoyNo());
			logVO.setSkdDirCd(condVO.getSkdDirCd());
//			logVO.setPolCd(polVO.getPolCd()); // 헤깔림
			logVO.setPodCd(condVO.getPodCd());
			logVO.setSndUsrId(account.getUsr_id());
			logVO.setSndUsrOfcCd(account.getOfc_cd());
			logVO.setCreUsrId(account.getUsr_id());
			logVO.setEdiSndLogCtnt(flatFile);
			logVO.setCrrBatNo(flatFile.substring(62, 77));
//			if ("D".equals(condVO.getDelFlag()))
//			{
//				logVO.setDeltFlg("Y");
//			}
//			else
//			{
//				logVO.setDeltFlg("N");
//			}
			/***********************************************************
			 * 로그DB Insert
			 ***********************************************************/
			CndCustomsTransmissionBackEndJob cndBackEndJob = new CndCustomsTransmissionBackEndJob();
			cndBackEndJob.writeCstmsSendLog(dbDao, logVO);
			return flatFile;
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Vessel Actual Arrival 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param vesselArrivalTransmitVO 전송정보
	 * @param account 세션정보
	 * @return String
	 * @throws EventException
	 */
	public String transmitActualVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account)
			throws EventException {
		CndVesselArrivalTransmitVO condVO = (CndVesselArrivalTransmitVO) vesselArrivalTransmitVO;
		try
		{
			// ACI Vessel Information
			CndVesselArrivalTransmitVO vslVO = dbDao.searchVesselArrival(condVO);
			if (!"".equals(vslVO.getDtNullChk()))
			{
				// ACI Vessel Information 화면 (UI_BKG-0016) 에 data 가 빠져있는 경우 에러처리
				String[] changeStr = { vslVO.getDtNullChk() };
				throw new EventException(new ErrorHandler("BKG00976", changeStr).getMessage());
			}
			if (!"".equals(vslVO.getDtDiffChk()))
			{
				// 만료일자가 Last Foreign Port Departure Date 보다 이전인 경우 에러처리
				String[] changeStr = { vslVO.getDtDiffChk() };
				throw new EventException(new ErrorHandler("BKG00977", changeStr).getMessage());
			}
			/***********************************************************
			 * flatFile 만들기
			 ***********************************************************/
			String flatFile = makeCndActualVesselArrivalFlatFile(vslVO);
			/***********************************************************
			 * 로그VO 세팅
			 ***********************************************************/
			CstmsSendLogVO logVO = new CstmsSendLogVO();
			logVO.setCntCd(CountryCode.CA);
			logVO.setIoBndCd("I");
			logVO.setSndDt(condVO.getVslArrRptSndDt());
			logVO.setTrsmMsgTpId("ATA");
			logVO.setVslCd(condVO.getVslCd());
			logVO.setSkdVoyNo(condVO.getSkdVoyNo());
			logVO.setSkdDirCd(condVO.getSkdDirCd());
//			logVO.setPolCd(polVO.getPolCd()); // 헤깔림
			logVO.setPodCd(condVO.getPodCd());
			
			if(account.getAccess_system() != null && "EsmBkgB908".equals(account.getAccess_system())) {
				// batch 에서 넘어 왔을 경우 
				logVO.setSndUsrId("EsmBkgB908");
				logVO.setSndUsrOfcCd("SYS");
				logVO.setCreUsrId("EsmBkgB908");
				
			} else {
				// 화면에서 넘어 왔을 경우
				
				logVO.setSndUsrId(account.getUsr_id());
				logVO.setSndUsrOfcCd(account.getOfc_cd());
				logVO.setCreUsrId(account.getUsr_id());
			}
			
			logVO.setEdiSndLogCtnt(flatFile);
			logVO.setCrrBatNo(flatFile.substring(62, 77));
			/***********************************************************
			 * 로그DB Insert
			 ***********************************************************/
			CndCustomsTransmissionBackEndJob cndBackEndJob = new CndCustomsTransmissionBackEndJob();
			cndBackEndJob.writeCstmsSendLog(dbDao, logVO);
			return flatFile;
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Receive History
	 * 
	 * @param cstmsRcvHisListCondVO 조회조건
	 * @return List<CstmsRcvHisVO>
	 * @throws EventException
	 */
	public List<CstmsRcvHisVO> searchCstmsRcvHisList(CstmsRcvHisListCondVO cstmsRcvHisListCondVO) throws EventException {
		try
		{
			return dbDao.searchCndCstmsRcvHisList((CndCstmsRcvHisListCondVO) cstmsRcvHisListCondVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Receive History Detail
	 * 
	 * @param cstmsRcvLogDtlCondVO 조회조건
	 * @return List<CstmsRcvLogDtlVO>
	 * @throws EventException
	 */
	public List<CstmsRcvLogDtlVO> searchCstmsRcvLogDtl(CstmsRcvLogDtlCondVO cstmsRcvLogDtlCondVO) throws EventException {
		try
		{
			return dbDao.searchCndCstmsRcvLogDtl((CndCstmsRcvLogDtlCondVO) cstmsRcvLogDtlCondVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SendLog History
	 * 
	 * @param cstmsSndHisListCondVO 조회조건
	 * @return List<CstmsSndHisVO>
	 * @throws EventException
	 */
	public List<CstmsSndHisVO> searchCstmsSndHisList(CstmsSndHisListCondVO cstmsSndHisListCondVO) throws EventException {
		try
		{
			return dbDao.searchCndCstmsSndHisList((CndCstmsSndHisListCondVO) cstmsSndHisListCondVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SendLog History Detail
	 * 
	 * @param cstmsSndLogDtlCondVO 조회조건
	 * @return List<CstmsSndLogDtlVO>
	 * @throws EventException
	 */
	public List<CstmsSndLogDtlVO> searchCstmsSndLogDtl(CstmsSndLogDtlCondVO cstmsSndLogDtlCondVO) throws EventException {
		try
		{
			return dbDao.searchCndCstmsSndLogDtl((CndCstmsSndLogDtlCondVO) cstmsSndLogDtlCondVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관 적하 목록 정정 신고를 위한 적하 정정 목록 조회
	 * 
	 * @param cstmsManifestAmendmentCondVO 조회조건
	 * @return List<CstmsManifestAmendmentVO>
	 * @throws EventException
	 */
	public List<CstmsManifestAmendmentVO> searchCstmsManifestAmendment(
			CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO) throws EventException {
		try
		{
			return dbDao
					.searchCndCstmsManifestAmendment((CndCstmsManifestAmendmentCondVO) cstmsManifestAmendmentCondVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ACI Report
	 * 
	 * @param cstmsTrsmRsltListCondVO 조회조건
	 * @return List<CstmsTrsmRsltVO>
	 * @throws EventException
	 */
	public List<CstmsTrsmRsltVO> searchCstmsTrsmRsltList(CstmsTrsmRsltListCondVO cstmsTrsmRsltListCondVO)
			throws EventException {
		try
		{
			CndCstmsTrsmRsltListCondVO condVO = (CndCstmsTrsmRsltListCondVO) cstmsTrsmRsltListCondVO;
			condVO.setTotcountFlag("true");
			List<CstmsTrsmRsltVO> list = dbDao.searchCndCstmsTrsmRsltList(condVO);
			// 유형별 건수
			int iManifestTtl = 0;
			int iSentByA6a = 0;
			int iSentByAl = 0;
			int iTargetTtl = 0;
			int iUnmanifest = 0;
			int iTotal = 0;
			int iProcessed = 0;
			int iError = 0;
			for (int i = 0; i < list.size(); i++)
			{
				CndCstmsTrsmRsltVO vo = (CndCstmsTrsmRsltVO) list.get(i);
				if (!"".equals(vo.getBlNo()))
				{
					if ("00".equals(vo.getCstmsTrsmStsCd()))
					{
						iManifestTtl++;
						iSentByA6a++;
						iTargetTtl++;
					}
					if ("04".equals(vo.getCstmsTrsmStsCd()))
					{
						iManifestTtl++;
						iSentByAl++;
						iTargetTtl++;
					}
					if ("".equals(vo.getCstmsTrsmStsCd()) || "03".equals(vo.getCstmsTrsmStsCd()))
					{
						iTargetTtl++;
						iUnmanifest++;
					}
					if ("06".equals(vo.getCstmsAckProcRsltCd()))
					{
						iProcessed++;
					}
					if ("".equals(vo.getCstmsAckProcRsltCd())
							&& ("A".equals(vo.getCstmsAckRcvRsltCd()) || "E".equals(vo.getCstmsAckRcvRsltCd())))
					{
						iProcessed++;
					}
					if (!"".equals(vo.getCstmsAckProcRsltCd()) && !"06".equals(vo.getCstmsAckProcRsltCd())
							&& !"".equals(vo.getCstmsAckRcvRsltCd()) && !"E".equals(vo.getCstmsAckRcvRsltCd())
							&& !"A".equals(vo.getCstmsAckRcvRsltCd()))
					{
						iError++;
					}
				}
				iTotal++;
			}
			if (list.size() > 0)
			{
				CndCstmsTrsmRsltVO vo = (CndCstmsTrsmRsltVO) list.get(0);
				vo.setManifestTtl("" + iManifestTtl);
				vo.setSentByA6a("" + iSentByA6a);
				vo.setSentByAl("" + iSentByAl);
				vo.setTargetTtl("" + iTargetTtl);
				vo.setUnmanifest("" + iUnmanifest);
				vo.setTotal("" + iTotal);
				vo.setProcessed("" + iProcessed);
				vo.setError("" + iError);
			}
			return list;
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account)
			throws EventException {
		String sFlatFile = null;
		try
		{
			if ("ESM_BKG_0002".equals(manifestTransmitVO.getPgmNo())) {

				// MI 전송(최초전송)
				CndCustomsTransmissionBackEndJob cndBackEndJob = new CndCustomsTransmissionBackEndJob();
				cndBackEndJob.setManifestTransmitVO(manifestTransmitVO, account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				sFlatFile = backEndJobManager.execute(cndBackEndJob, account.getUsr_id(), "Canada Manifest Transmit(MI)");

			} else if ("ESM_BKG_0006".equals(manifestTransmitVO.getPgmNo())) {

					CndCustomsTransmissionBackEndJob cndBackEndJob = new CndCustomsTransmissionBackEndJob();
					cndBackEndJob.setPgmNo(manifestTransmitVO.getPgmNo());
					cndBackEndJob.setManifestTransmitVO(manifestTransmitVO, account);
					BackEndJobManager backEndJobManager = new BackEndJobManager();
					sFlatFile = backEndJobManager.execute(cndBackEndJob, account.getUsr_id(), "Canada Export Manifest Transmit");
				
			} else {
				// ESM_BKG_0029
				CndCstmsManifestVO cndVO = (CndCstmsManifestVO) manifestTransmitVO;
				/***********************************************************
				 * 전송 FlatFile 만들어서 로그테이블에 등록
				 **********************************************************/
				// 1건이기 때문에
				String[] blNos = new String[1];
				blNos[0] = cndVO.getBlNo();
				cndVO.setBlNos(blNos);
				
				CndCustomsTransmissionBackEndJob cndBackEndJob = new CndCustomsTransmissionBackEndJob();
				cndBackEndJob.setManifestTransmitVO(cndVO, account);
				sFlatFile = cndBackEndJob.makeCndCstmsMfFlatFile(dbDao, cndVO, account).get(0);
			}
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return sFlatFile;
	}
	
	/**
	 * AI 전송(재전송)
	 * 
	 * @param cstmsManifestAmendmentVO 전송정보
	 * @param account 세션정보
	 * @return String FlatFile
	 */
	public String transAmendManifest(CstmsManifestAmendmentVO cstmsManifestAmendmentVO, SignOnUserAccount account)
			throws EventException {
		
		// FlatFile
		StringBuilder flatFile = new StringBuilder();
		try
		{
			CndCstmsManifestAmendmentVO cndVO = (CndCstmsManifestAmendmentVO) cstmsManifestAmendmentVO;
			/************************************************
			 * BL 조회
			 ***********************************************/
			BlInfoForFlatFileVO blInfo = dbDao.searchBlInfoForFlatFile(cndVO);

			// 추가 2009.09.25 CC_CUSTOFCO, CC_CUSTOFCD
			if ("".equals(blInfo.getCustofcd()) && blInfo.getHubLocCd().startsWith("CA"))
			{
				blInfo.setCustofcd(blInfo.getCustofco());
			}
			if (blInfo.getHubLocCd().startsWith("CA") && 
					"".equals(blInfo.getCustofco()) && "".equals(blInfo.getCustofcd()))
			{
				String[] arrErrCd = new String[3];
				arrErrCd[0] = blInfo.getBlnbr();
				arrErrCd[1] = blInfo.getBlpod();
				arrErrCd[2] = blInfo.getDelcode();
				throw new EventException(new ErrorHandler("BKG06040", arrErrCd).getMessage());
			}
			/************************************************
			 * FlatFile 만들기
			 ***********************************************/
			// Header 
			// 2017.12.27 Header 변경  CK92756 > SMLINE
			BookingUtil utilBC = new BookingUtil();
			if ("A6A".equals(blInfo.getCstmsMfTpCd())) {
				flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE", "RCCECECPP", "311A6A")).append("\n");
			} else if ("S10".equals(blInfo.getCstmsMfTpCd())) {
				flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE", "RCCECECPP", "311S10")).append("\n");
			} else if ("E10".equals(blInfo.getCstmsMfTpCd())) {
				flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE", "RCCECECPP", "311E10")).append("\n");
			}
			// Body
			CndCustomsTransmissionBackEndJob cndBackEndJob = new CndCustomsTransmissionBackEndJob();
			flatFile.append(cndBackEndJob.makeFlatFile(dbDao, cndVO, blInfo));
			/***********************************************************
			 * BL별 CrrBatNo 셋팅<BR>
			 * 사실 캐나다는 CrrBatNo를 세팅할 필요는 없다<BR>
			 * 수신에서 BL별로 오기 때문에 해당BL의 CSTMS_ACK_KEY_NO로 BL을 찾아서<BR>
			 * BL테이블에 UPDATE하면된다.<BR> 
			 * 송신한 BL별 수신결과를 보기위함이라면 필요하겠지만..
			 ***********************************************************/
			BkgCstmsAdvEdiBlRspnVO bkgCstmsAdvEdiBlRspnVO = new BkgCstmsAdvEdiBlRspnVO();
			bkgCstmsAdvEdiBlRspnVO.setCntCd(CountryCode.CA);
			bkgCstmsAdvEdiBlRspnVO.setBlNo(cndVO.getBlNo());
			bkgCstmsAdvEdiBlRspnVO.setCrrBatNo(flatFile.toString().substring(62, 77));

			bkgCstmsAdvEdiBlRspnVO.setCreUsrId(account.getUsr_id());
			List<BkgCstmsAdvEdiBlRspnVO> bkgCstmsAdvEdiBlRspnVOs = new ArrayList<BkgCstmsAdvEdiBlRspnVO>();
			bkgCstmsAdvEdiBlRspnVOs.add(bkgCstmsAdvEdiBlRspnVO);
			dbDao.addBkgCstmsAdvEdiBlRspn(bkgCstmsAdvEdiBlRspnVOs);
			/***********************************************************
			 * 로그남기기
			 ***********************************************************/
			cndBackEndJob.makeManifestLog(dbDao, blInfo, cndVO.getMiSndDt(), flatFile.toString(), account, "");
			
			/***********************************************************
			 * 2014.06.24
			 * AI 전송후 DocProcAIFlag='Y' 처리 			
			 ***********************************************************/			
			// HOSTORY BCImpl - mbl, hbl ai flag update
			BkgDocProcSkdVO bkgDocProcSkdVO = null;
			bkgHisBC = new BookingHistoryMgtBCImpl();
			String mfNo = ""; // 'X'이면 마스터, 아니면 하우스.
			String usrId = account.getUsr_id();
			
			bkgDocProcSkdVO = new BkgDocProcSkdVO();
			bkgDocProcSkdVO.setBkgDocProcTpCd("CA_SND"); 
			bkgDocProcSkdVO.setBkgNo(cndVO.getBlNo());
			mfNo = blInfo.getMfNo();
			
			if(!"X".equals(mfNo)) {
				bkgDocProcSkdVO.setDiffRmk(mfNo);
			} else {
				bkgDocProcSkdVO.setDiffRmk("");
			}
			bkgDocProcSkdVO.setUpdUsrId(usrId);
			bkgHisBC.manageDocProcAIFlag(mfNo, bkgDocProcSkdVO);
			
			/***********************************************************
			 * EDI 전송 START
			 ***********************************************************/
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			BookingUtil utilCommand = new BookingUtil();
			sendFlatFileVO.setFlatFile(flatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CANCUS.IBMMQ.QUEUE"));
			FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return flatFile.toString();
	}

	/**
	 * EDI Inbound 처리 메서드
	 * 
	 * @param CstmsRcvLogVO cstmsRcvLogVO
	 * @return RcvMsgVO
	 */
	public RcvMsgVO loadCstmsRcvMsg(CstmsRcvLogVO cstmsRcvLogVO) {
		try
		{
			CndCstmsRcvLogVO cndCstmsRcvLogVO = (CndCstmsRcvLogVO) cstmsRcvLogVO;
			BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO = cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogVOs().get(0);
			
			//BAPLIE Response
			if ("BRC".equals(bkgCstmsAdvRcvLogVO.getRcvMsgTpId())) {
				BookingUtil utilCmd = new BookingUtil();
				utilCmd.addBkgLog("BKG_BAPLIE", "CA_BAPLIE", bkgCstmsAdvRcvLogVO.getRcvMsgTpId());
				writeCstmsBaplieRcvLog(cstmsRcvLogVO);	
				
			} else {
				writeCstmsRcvLog(cstmsRcvLogVO);
			}
		}
//		catch (DAOException ex)
//		{
//			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
//		}
		catch (Exception ex)
		{
//			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
			log.error("loadCstmsRcvMsg ERROR==="+ex.getMessage());
		}
		return null;
	}
	
	/**
	 * FlatFile
	 * 
	 * @param condVO 조회조건
	 * @param vslVO Vessel정보
	 * @param polVO POL 정보
	 * @param portList Port 정보
	 * @return String FlatFile
	 */
	private String makeCndVesselArrivalFlatFile(CndVesselArrivalTransmitVO condVO, CndVesselArrivalTransmitVO vslVO,
			CndVesselArrivalTransmitVO polVO, List<CndVesselArrivalTransmitVO> portList) throws EventException {
		// flatFile
		StringBuilder flatFile = new StringBuilder();
		// 로그를 남기기 위한 값을 cndVesselArrivalTransmitVO에 담는다(일단 POL정보만)
		condVO.setPolCd(polVO.getPolCd());
		// 헤더
		BookingUtil utilBC = new BookingUtil();
		// 2017.12.27 Header 변경  CK92756 > SMLINE
		flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE", "RCCECECPP", "311A6")).append("\n");
		// 메시지 시작
		flatFile.append("{ST").append("\n");
		flatFile.append("STCNT:").append(vslVO.getCndAckCtrlNo()).append("\n");
		flatFile.append("CC_TRANS:21").append("\n");
		flatFile.append("CC_STATUS:").append(vslVO.getStatus()).append("\n");
		flatFile.append("CC_REPNO:").append(vslVO.getCvyRefNo()).append("\n");
		flatFile.append("SFCDATE:").append(vslVO.getVslSftCstruCertiExpDt()).append("\n");
		flatFile.append("SFRDATE:").append(vslVO.getVslSftRdoCertiExpDt()).append("\n");
		flatFile.append("SFEDATE:").append(vslVO.getVslSftEqCertiExpDt()).append("\n");
		flatFile.append("LLDATE:").append(vslVO.getVslLodLineCertiExpDt()).append("\n");
		flatFile.append("DERDATE:").append(vslVO.getVslDeratCertiExpDt()).append("\n");
		flatFile.append("LLOYDCODE:").append(vslVO.getLloydNo()).append("\n");
		flatFile.append("VSLFULLNAME:").append(vslVO.getVslEngNm()).append("\n");
		flatFile.append("VSLCOUNTRY:").append(vslVO.getVslRgstCntCd()).append("\n");
		flatFile.append("VOYAGE:").append(condVO.getSkdVoyNo()).append(condVO.getSkdDirCd()).append("\n");
		flatFile.append("VSLTPCD:CT").append("\n");
		flatFile.append("PORTREG:").append(vslVO.getRgstPortCd()).append("\n");
		flatFile.append("OFFICE:").append(vslVO.getRgstNo()).append("\n");
		flatFile.append("NETWGT:").append(vslVO.getNetRgstTongWgt()).append("\n");
		flatFile.append("NETWGTU:E").append("\n");
		flatFile.append("GROSSWGT:").append(vslVO.getGrsRgstTongWgt()).append("\n");
		flatFile.append("GROSSWGTU:E").append("\n");
		flatFile.append("CC_MAINWGT:").append(condVO.getCgoWgt()).append("\n");
		flatFile.append("CC_MAINWGTU:E").append("\n");
		flatFile.append("NCCT:0").append("\n");
		flatFile.append("NCCTU:E").append("\n");
		flatFile.append("DEADWGT:").append(vslVO.getDwtWgt()).append("\n");
		flatFile.append("DEADWGTU:E").append("\n");
		flatFile.append("CC_CAPTNAME:").append(vslVO.getCapNm()).append("\n");
		flatFile.append("LOA:").append(vslVO.getLoaLen()).append("\n");
		flatFile.append("LOAU:MR").append("\n");
		flatFile.append("CREW:").append(vslVO.getCrwKnt()).append("\n");
		flatFile.append("PASG:").append(vslVO.getPasgCnt()).append("\n");
		// 선적항, 선적일, 양하항 (polVO정보)
		flatFile.append("CC_POL:").append(polVO.getPolCd()).append("\n");
		flatFile.append("CC_ETD:").append(polVO.getVpsEtdDt()).append("\n");
		flatFile.append("CC_POD:").append(polVO.getPodCd()).append("\n");
		flatFile.append("CC_ETA:").append(vslVO.getEtaDt()).append("\n");
		flatFile.append("REGDATE:").append(vslVO.getRgstDt()).append("\n");
		// 양하 터미널 이름
		flatFile.append("CC_TERMNAME:");
		if ("HNKH0059E".equals(condVO.getVslCd() + condVO.getSkdVoyNo() + condVO.getSkdDirCd()))
		{
			flatFile.append("CENTERM (3380)").append("\n");
		}
		else
		{
			flatFile.append("VANTERM (3395)").append("\n");
		}
		// Port 정보
		for (int i = 0; i < portList.size(); i++)
		{
			flatFile.append("{CC_PORT").append("\n");
			flatFile.append("CC_PORT:").append(((CndVesselArrivalTransmitVO) portList.get(i)).getVpsPortCd()).append(
					"\n");
			flatFile.append("}CC_PORT").append("\n");
		}
		// 선적 컨테이너 정보
		flatFile.append("CC_TEU:").append(condVO.getTeuFul()).append("\n");
		flatFile.append("CC_FEU:").append(condVO.getFeuFul()).append("\n");
		flatFile.append("CC_OTL:").append(condVO.getOthFul()).append("\n");
		flatFile.append("CC_TEUE:").append(condVO.getTeuMty()).append("\n");
		flatFile.append("CC_FEUE:").append(condVO.getFeuMty()).append("\n");
		flatFile.append("CC_OTE:").append(condVO.getOthMty()).append("\n");
		flatFile.append("}SE").append("\n");
		return flatFile.toString();
	}
	
	
	/**
	 * Actual FlatFile
	 * 
	 * @param condVO 조회조건
	 * @param actVslVO Vessel 정보
	 * @return String FlatFile
	 */
	private String makeCndActualVesselArrivalFlatFile(CndVesselArrivalTransmitVO actVslVO) throws EventException {
		// flatFile
		StringBuilder flatFile = new StringBuilder();
		// 헤더
		BookingUtil utilBC = new BookingUtil();
		flatFile.append(utilBC.searchCstmsEdiHeader("SMLINE", "RCCECECPP", "353")).append("\n");
		// 메시지 시작
		flatFile.append("{ARR_INFO").append("\n");
		flatFile.append("STCNT:").append(actVslVO.getCndAckCtrlNo()).append("\n");
		flatFile.append("E_I_IND:I").append("\n");
		flatFile.append("CBSA_CARRIER_CD:918P").append("\n");// 9525 > 918P (한진 > SM) 변경 217.11.03
		flatFile.append("VVD:").append(actVslVO.getVslCd()).append(actVslVO.getSkdVoyNo()).append(actVslVO.getSkdDirCd()).append("\n");
		flatFile.append("VSL_FULLNAME:").append(actVslVO.getVslEngNm()).append("\n");
		flatFile.append("VSL_NATION_CD:").append(actVslVO.getVslRgstCntCd()).append("\n");
		flatFile.append("POD_CD:").append(actVslVO.getPodCd()).append("\n");
		flatFile.append("POD_NM:").append(actVslVO.getPodNm()).append("\n");
		
		String actArrDt[] = actVslVO.getActArrDt().split(":");
		String date = "";
		String time = "";
		if(actArrDt != null) {
			 if( actArrDt.length == 1 ) {
				 date  = actArrDt[0];
			 } else if( actArrDt.length > 1 ) {
				 date  = actArrDt[0];
				 time  = actArrDt[1];
			 }
		}
		flatFile.append("POD_ATA_D:").append(date).append("\n");
		flatFile.append("POD_ATA_T:").append(time).append("\n");
		flatFile.append("CRN:").append(actVslVO.getCvyRefNo()).append("\n");
		flatFile.append("}ARR_INFO").append("\n");
		return flatFile.toString();
	}
	
	/**
	 * 수신정보 로그기록
	 * 
	 * @param cstmsRcvLogVO 로그정보
	 * @throws DAOException
	 */
	private void writeCstmsRcvLog(CstmsRcvLogVO cstmsRcvLogVO) {
		log.info("<<<<<<<<<<<< writeCstmsRcvLog Start >>>>>>>>>>>>>>>");
		CndCstmsRcvLogVO cndCstmsRcvLogVO = (CndCstmsRcvLogVO) cstmsRcvLogVO;
		BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO = cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogVOs().get(0);
		// MaxRcvSeq를 Proxy에서 가져올수 없으므로(Proxy에서 DAO를 호출하면 안될거 같아서..)
		String rcvSeq = dbDao.searchMaxRcvLogSeq(bkgCstmsAdvRcvLogVO);
		log.info("MaxRcvSeq=" + rcvSeq);
		bkgCstmsAdvRcvLogVO.setRcvSeq(rcvSeq);
		// VslCd, VoyNo, DirCd, BLNo, Pod, Pol 정보조회
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO = dbDao.searchCndCstmsBlByKey(bkgCstmsAdvRcvLogVO.getCstmsBatNo());
		if (bkgCstmsAdvBlVO != null)
		{
			bkgCstmsAdvRcvLogVO.setBlNo(bkgCstmsAdvBlVO.getBlNo());
			bkgCstmsAdvRcvLogVO.setVslCd(bkgCstmsAdvBlVO.getVslCd());
			bkgCstmsAdvRcvLogVO.setSkdVoyNo(bkgCstmsAdvBlVO.getSkdVoyNo());
			bkgCstmsAdvRcvLogVO.setSkdDirCd(bkgCstmsAdvBlVO.getSkdDirCd());
			bkgCstmsAdvRcvLogVO.setPolCd(bkgCstmsAdvBlVO.getCstmsPolCd());
			bkgCstmsAdvRcvLogVO.setPodCd(bkgCstmsAdvBlVO.getCstmsPodCd());
		}
		else
		{
			// VslCd, VoyNo, DirCd 정보조회
			BkgCstmsCndVslVO bkgCstmsCndVslVO = dbDao.searchCndCstmsVvdByKey(bkgCstmsAdvRcvLogVO.getCstmsBatNo());
			if (bkgCstmsCndVslVO != null)
			{
				bkgCstmsAdvRcvLogVO.setVslCd(bkgCstmsCndVslVO.getVslCd());
				bkgCstmsAdvRcvLogVO.setSkdVoyNo(bkgCstmsCndVslVO.getSkdVoyNo());
				bkgCstmsAdvRcvLogVO.setSkdDirCd(bkgCstmsCndVslVO.getSkdDirCd());
			}
		}
		for (int i = 0; i < cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogDtlVOs().size(); i++)
		{
			BkgCstmsAdvRcvLogDtlVO bkgCstmsAdvRcvLogDtlVO = cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogDtlVOs().get(i);
			bkgCstmsAdvRcvLogDtlVO.setRcvSeq(rcvSeq);
		}
		dbDao.addBkgCstmsAdvRcvLog(cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogVOs());
		dbDao.addBkgCstmsAdvRcvLogDtl(cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogDtlVOs());
		dbDao.modifyBkgCstmsAdvSndLog(cndCstmsRcvLogVO.getBkgCstmsAdvSndLogVOs());
	}


	
	/**
	 * BAPLIE 수신메시지 저장
	 *  
	 * @param CstmsRcvLogVO cstmsRcvLogVO 
	 * @throws DAOException 
	 * 
	 */
	public void writeCstmsBaplieRcvLog(CstmsRcvLogVO cstmsRcvLogVO) throws DAOException {
		BookingUtil utilCmd = new BookingUtil();
		
		try {
			CndCstmsRcvLogVO cndCstmsRcvLogVO = (CndCstmsRcvLogVO) cstmsRcvLogVO;			
			String rcvMsg = cndCstmsRcvLogVO.getRcvMsg();
			
			if(rcvMsg == null || rcvMsg.equals("")) return;
			
			String orgRefNo = getReceiveSingleItem(rcvMsg, "ORG_FF_REF_NO:", "\n");
			String msgVvd = getReceiveSingleItem(rcvMsg, "VVD:", "\n");
			//String msgCrn = getReceiveSingleItem(rcvMsg, "CRN:", "\n");		
			String cstmsAckStsCd = getReceiveSingleItem(rcvMsg, "ACK_RESULT:", "\n");
			String cstmsAckCd = ""; //getReceiveSingleItem(rcvMsg, "ACK_CODE:", "\n");  1(A) 또는 2(R) 로 의미없음
			String cstmsAckDesc = getReceiveSingleItem(rcvMsg, "ACK_DESCRIPTION:", "\n");
			String rcvDt = getReceiveSingleItem(rcvMsg, "FILE_PROCESS_DATE:", "\n"); //201604081405 
			
			utilCmd.addBkgLog("BKG_BAPLIE", "CA_BAPLIE", orgRefNo);
			
			List<BkgCstmsAdvRcvLogVO> bkgCstmsAdvRcvLogVOs = new ArrayList<BkgCstmsAdvRcvLogVO>();	
			BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO = cndCstmsRcvLogVO.getBkgCstmsAdvRcvLogVOs().get(0);
			bkgCstmsAdvRcvLogVO.setRcvDt(rcvDt);
			String rcvSeq = dbDao.searchMaxRcvLogSeq(bkgCstmsAdvRcvLogVO);	
			bkgCstmsAdvRcvLogVO.setRcvSeq(rcvSeq);
			
			utilCmd.addBkgLog("BKG_BAPLIE", "CA_BAPLIE", orgRefNo + " : " + rcvSeq);
	
			BkgCstmsAdvRcvLogVO orgRefVO = dbDao.searchCusResDataBySndId(orgRefNo); // 수신 msg 의 ORG_FF_REF_NO로 관련 데이터 구하기
			if(orgRefVO != null){
				bkgCstmsAdvRcvLogVO.setVslCd(orgRefVO.getVslCd());
				bkgCstmsAdvRcvLogVO.setSkdVoyNo(orgRefVO.getSkdVoyNo());
				bkgCstmsAdvRcvLogVO.setSkdDirCd(orgRefVO.getSkdDirCd());
				bkgCstmsAdvRcvLogVO.setPodCd(orgRefVO.getPodCd());
				bkgCstmsAdvRcvLogVO.setPolCd(orgRefVO.getPolCd());
			}else{ //해당하는 값이 존재하지 않을 때 수신한 msg로부터 Data를 획득해서 입력한다.
				bkgCstmsAdvRcvLogVO.setSkdVoyNo(msgVvd.substring(0,4)); //수신 msg의 VVD형식 : ex>0106E
				bkgCstmsAdvRcvLogVO.setSkdDirCd(msgVvd.substring(4,5));
			}
			
			String errorDesc = "";
			//{ERROR_DETAIL 있지만, CRN단위로 수신으로 여러개의 ERROR 불필요.
			List<String> errList = getReceiveMultiItem(rcvMsg, "\\{ERROR_DETAIL","}ERROR_DETAIL");
			if(errList != null && errList.size()> 0){
				cstmsAckCd = getReceiveSingleItem(errList.get(0), "ERROR_RESULT:", "\n"); // 22 , 29
				errorDesc = getReceiveSingleItem(errList.get(0), "ERROR_CODE:", "\n");
	        }
			
			//BKG_CSTMS_ADV_RCV_LOG insert
			bkgCstmsAdvRcvLogVO.setCstmsBatNo("");
			bkgCstmsAdvRcvLogVO.setCrrBatNo(orgRefNo);
			bkgCstmsAdvRcvLogVO.setCndAckSubCd(cstmsAckCd);
			bkgCstmsAdvRcvLogVO.setCndAckRcvId(cstmsAckStsCd);  //A or R
			bkgCstmsAdvRcvLogVO.setCstmsRjctMsg(errorDesc);
			bkgCstmsAdvRcvLogVO.setCndAckErrNoteDesc("");
			bkgCstmsAdvRcvLogVOs.add(bkgCstmsAdvRcvLogVO);
			dbDao.addBkgCstmsAdvRcvLog(bkgCstmsAdvRcvLogVOs);
			
			utilCmd.addBkgLog("BKG_BAPLIE", "CA_BAPLIE", orgRefNo + " : addBkgCstmsAdvRcvLog ");
			
			//BKG_CSTMS_ADV_RCV_LOG_DTL insert
			List<BkgCstmsAdvRcvLogDtlVO> bkgCstmsAdvRcvLogDtlVOs = new ArrayList<BkgCstmsAdvRcvLogDtlVO>();				
			StringTokenizer token = new StringTokenizer(rcvMsg, "\n");
			token = new StringTokenizer(rcvMsg, "\n");
			int k = 0;
			while (token.hasMoreTokens())
			{
				String str = token.nextToken();
				k++;
	
				BkgCstmsAdvRcvLogDtlVO bkgCstmsAdvRcvLogDtlVO  = new BkgCstmsAdvRcvLogDtlVO();	
				bkgCstmsAdvRcvLogDtlVO.setCntCd(CountryCode.CA);
				bkgCstmsAdvRcvLogDtlVO.setIoBndCd("I");
				bkgCstmsAdvRcvLogDtlVO.setRcvDt(rcvDt);
				bkgCstmsAdvRcvLogDtlVO.setRcvSeq(rcvSeq);
				bkgCstmsAdvRcvLogDtlVO.setRcvMsgDtlSeq(Integer.toString(k));
				bkgCstmsAdvRcvLogDtlVO.setMsgDesc(str);
				bkgCstmsAdvRcvLogDtlVO.setCstmsBatNo(""); //BKG_CSTMS_ADV_RCV_LOG_DTL에는 해당 값을 Insert 하지 않는다.	
				bkgCstmsAdvRcvLogDtlVO.setCreUsrId("BAPLIE_ACK");
				bkgCstmsAdvRcvLogDtlVO.setUpdUsrId("BAPLIE_ACK");
				bkgCstmsAdvRcvLogDtlVOs.add(bkgCstmsAdvRcvLogDtlVO);				
			}
			dbDao.addBkgCstmsAdvRcvLogDtl(bkgCstmsAdvRcvLogDtlVOs);
			
			utilCmd.addBkgLog("BKG_BAPLIE", "CA_BAPLIE", orgRefNo + " : addBkgCstmsAdvRcvLogDtl ");

			
			//STOWAGE SEND LOG 테이블 업데이트
			SendDetailLogCndVO sendDetailLogVO  = new SendDetailLogCndVO();	
			sendDetailLogVO.setCrrBatNo(orgRefNo);
			sendDetailLogVO.setCstmsAckStsCd(cstmsAckStsCd);
			sendDetailLogVO.setCstmsAckCd(cstmsAckCd);
			sendDetailLogVO.setCstmsAckDesc(cstmsAckDesc);
			sendDetailLogVO.setRcvDt(rcvDt);
			dbDao.modifyBaplieCusResSndLog(sendDetailLogVO);
			
			utilCmd.addBkgLog("BKG_BAPLIE", "CA_BAPLIE", orgRefNo + " : modifyBaplieCusResSndLog ");
			
			if(errList != null && errList.size()> 0){
	        	sendDetailLogVO.setErrResult("R");
	        	sendDetailLogVO.setErrCode("");
	        	sendDetailLogVO.setErrDesc(errorDesc);			
	        	sendDetailLogVO.setRcvDt(rcvDt);
				dbDao.modifyBaplieCusResByCntr(sendDetailLogVO);
	        } else {
	        	//ERROR_DETAIL 없을 시 나머지 항목 모두 ACK로 업데이트
	        	dbDao.modifyBaplieCusResByVvd(sendDetailLogVO);
	        }
			
			utilCmd.addBkgLog("BKG_BAPLIE", "CA_BAPLIE", orgRefNo + " : END ");
			
		} catch (EventException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * loadCstmsRcvMsg에서 사용하는 내부 메소드<br>
	 * 수신메시지에서 각항목별 정보를 추출한다.<br>
	 *  
	 * @param String src
	 * @param String prefix
	 * @param String endDelimeter
	 * @return String
	 */
	private String getReceiveSingleItem(String src, String prefix, String endDelimeter){
		if(src == null) return "";

		String tmp ="";
	
		int index   = src.indexOf(prefix);
			
		if( index >= 0){
			tmp = src.substring(index+prefix.length());
			return JSPUtil.getNull(tmp.substring(0,tmp.indexOf(endDelimeter)).replace("\r",""));
		}
		return "";
	}	

	
	/**
	 * loadCstmsRcvMsg에서 사용하는 내부 메소드<br>
	 * 수신메시지에서 각항목별 반복되는 정보를 추출한다.<br>
	 *  
	 * @param String src
	 * @param String prefix
	 * @param String surfix
	 * @return List<String>
	 */
	private List<String> getReceiveMultiItem(String src, String prefix, String surfix){
		String[] srcArr = src.split(prefix);
		List<String> rlist = null;
		if(srcArr.length > 1){
			rlist = new ArrayList<String>();
			for (int i = 1; i < srcArr.length; i++) {
				rlist.add(srcArr[i].substring(0,srcArr[i].indexOf(surfix)));
			}
		}
		return rlist;
	}	
	
	/**
	 * Vessel Stowage Plan Transmit 화면을 조회.
	 * 
	 * @param StowageManifestCondVO stowageManifestCondVO
	 * @return List<ManifestTransmitVO>
	 * @throws EventException
	 */
	public List<ManifestTransmitVO> searchStowageManifestList(StowageManifestCondVO stowageManifestCondVO)
			throws EventException {
		StiCondListCndVO condVO = (StiCondListCndVO) stowageManifestCondVO;
		List<ManifestTransmitVO> rtnList = new ArrayList<ManifestTransmitVO>();
		List<StiDetailCndVO> list = null;
		String paramVvd = ""; 	// 파라메터로 넘오는 vvd
		String tmpVvd = "";		// 가공한 값을 담을 vvd
		String sLane = "";
		try
		{
			// 조회조건이 유효한 조건일때 로직 실행.
			if (condVO != null)
			{
				paramVvd = tmpVvd = condVO.getVvd();
				sLane = dbDao.searchSvcLane(paramVvd); // service lane값을 조회한다.
				
				/* 20090602 JHPARK Lane 이 PNS 이거나 CEN 이면 temp_vvd 를 바꿔준다. (입력된 E/B 를 W/B 로) */
				if("PNS".equals(sLane) || "CEN".equals(sLane)) {
					
					tmpVvd = paramVvd.subSequence(0, 8) + "W";
				}
				
				/****************************************************************************/
				/* 20090602 JHPARK 아시아 -> 캐나다 -> 미국인 경우에 캐나다에서는 West Bound*/
				/* 로 Upload 한다. (아시아 선적분 포함) PNS, CEN Lane 의 경우에는 User 가 	*/
				/* E/B 로 조회하더라도 W/B 로 Upload 된 데이터를 조회할 수 있어야 한다. 	*/
				/****************************************************************************/
				if("EXCLUDECA".equals(condVO.getExcludeca())) {
					condVO.setVvd(tmpVvd);
				} else {
					// 화면에서 가져온 vvd를 그대로 사용한다.
					condVO.setVvd(paramVvd);
				}
				
				list = dbDao.searchStiListAtCnd(condVO);
				if (list != null)
				{
					// Vessel Info.를 조회한다.
					MdmVslCntrVO vo = dbDao.searchVslInfo(paramVvd);
					// vos의 결과 수 만큼 루프를 돌며, list를 채워준다.
					StiDetailCndVO itemVO = null;
					for (int i = 0; i < list.size(); i++)
					{
						itemVO = list.get(i);
						itemVO.setVslEngNm(vo.getVslEngNm());
						itemVO.setVslVoy(paramVvd.substring(4));
						itemVO.setCrrCd(vo.getCrrCd());
						rtnList.add(itemVO);
					}
				}
			}
			return rtnList;
		}
		catch (DAOException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * BackEndJob을 실행.
	 * 
	 * @param account SignOnUserAccount
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] manifestTransmitVO, String pgmNo)
			throws EventException {
		try
		{
			CndCustomsTransmissionBackEndJob backEndJob = new CndCustomsTransmissionBackEndJob();
			backEndJob.setPgmNo(pgmNo);
			String resultStr = "";
			if (pgmNo.equals("ESM_BKG_1023"))
			{
				backEndJob.setStiDetailCndVO((StiDetailCndVO[]) manifestTransmitVO);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "Vessel Stowage Plan Transmit.");
			}

			return resultStr;
			// DAO 호출이 없으므로 DAOException을 catch하는 부분은 생략한다.
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}


	/**
	 * Vessel Stowage Plan Transmit을 실행.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @return String
	 * @throws EventException
	 */
	public String transmitStowageManifest(ManifestTransmitVO[] manifestTransmitVOs) throws EventException {

		String condVvd = ""; // 조회조건 vvd값
		String searchVvdCd = ""; // 조회시 조회된 vvd 값
		String pod = "";
		String lastpol = "";
		String usrId = "";
		String ofcCd = "";
		String usPortCd = "";
		String fristPod = "";
		String polEstDepDt = ""; 
		String polActDepDt = "";
		String fristCaEtaDt = "";
		
		String lsDate = dbDao.searchSysdate();//현재시간
		try
		{
			StringBuffer flatFile = new StringBuffer();
			if (manifestTransmitVOs != null)
			{
				// searchVesselEta 를 위한 파라미터 변수VO
				VesselEtaCondCndVO vslCondVo = null;
				// StowageManifestDetailVO[] cvos 를 할당받아 형변환된 vo변수.
				StiDetailCndVO vo = null;
				// searchVesselEta 의 결과를 담을 변수VO
				VesselEtaInfoCndVO vslVo = null;
				// 컨테이너 번호별로 BayPlan데이터를 조회하기 위한 조회조건 VO.
				BayPlanCntrListConCndVO bayCondVo = null;
				// 컨테이너 번호별로 BayPlan데이터를 조회하기 위한 조회결과 VO.
				BayPlanCntrDetailCndVO bayDetailVo = null;
				List<BayPlanCntrDetailCndVO>  bayCmVos = null;
				
				// Last Pol을 위한 조회결과 VO.
				BayPlanPolDetailVO bayPolDetailVo = null;
				
				// 컨테이너 번호별로 BayPlan데이터를 조회하기 위한 조회결과 VO들의 배열.
				// 두번째 루프에서 다시 컨테이너별 BayPlan을 조회하지 않고, 이 결과배열로 루프를 돌린다.
				BayPlanCntrDetailCndVO[] bayDetailVos = new BayPlanCntrDetailCndVO[manifestTransmitVOs.length];
				condVvd = ((StiDetailCndVO) manifestTransmitVOs[0]).getVvd();
				/*
				 * 조회시 skd_dir_cd가 "E" -> "W"바뀌는 경우가 있습니다.
				 * 로직은 조회 로직 참고 하세요
				 */
				searchVvdCd = ((StiDetailCndVO) manifestTransmitVOs[0]).getSearchVvdCd(); 
				pod = ((StiDetailCndVO) manifestTransmitVOs[0]).getPod();
				lastpol = ((StiDetailCndVO) manifestTransmitVOs[0]).getLPol();
				usrId = ((StiDetailCndVO) manifestTransmitVOs[0]).getTmp1();
				ofcCd = ((StiDetailCndVO) manifestTransmitVOs[0]).getTmp2();
				
				for (int i = 0; i < manifestTransmitVOs.length; i++)
				{
					if (i == 0)
					{
						vslCondVo = new VesselEtaCondCndVO();
						vo = (StiDetailCndVO) manifestTransmitVOs[i];
						vslCondVo.setVvd(condVvd);
						vslCondVo.setLastpol(vo.getLPol());
						vslCondVo.setSndDt(lsDate);
						vslVo = dbDao.searchVesselEta(vslCondVo);
						
						/***************************************************
						 * CRN NO.가 없으면 에러처리
						 ***************************************************/
						if(vslVo == null) throw new EventException(new ErrorHandler("BKG00841", new String[] {}).getMessage());
						if ( "".equals(vslVo.getCvyRefNo())) {
							throw new EventException(new ErrorHandler("BKG06090").getMessage());
						}
						
						bayCondVo = new BayPlanCntrListConCndVO();
						bayCondVo.setVvd(searchVvdCd);
						bayCondVo.setPol(lastpol);
						bayCondVo.setPod(pod);
						bayPolDetailVo = dbDao.searchBayPlanPolInfo(bayCondVo);
						String msgFunc = dbDao.searchMessageFunctioncCode(condVvd) ;
						if(bayPolDetailVo == null) {
							fristPod = "";
							polEstDepDt = ""; 
							polActDepDt = "";
							fristCaEtaDt = "";
						} else {
							fristPod = bayPolDetailVo.getFristCaPort();
							polEstDepDt = bayPolDetailVo.getPolEstDepDt();
							polActDepDt = bayPolDetailVo.getPolActDepDt();
							fristCaEtaDt = bayPolDetailVo.getFristCaEtaDt();
						}
						
						usPortCd = vslVo.getCaPortCd();
						flatFile.append("MSG_FUNC:").append(msgFunc).append("\n");/* 9 ORIGINAL, 4 CHANGE */
						flatFile.append("MSG_DATE:").append(vslVo.getCurrdate()).append("\n");
						flatFile.append("CARRIER_CD:").append(vslVo.getCvyRefNo()).append("\n");//추가
						flatFile.append("VSL_CD:").append(vslVo.getVslCd()).append("\n");
						flatFile.append("VOY:").append(vslVo.getSkdVoyNo()).append("\n");
						flatFile.append("DIR:").append(vslVo.getSkdDirCd()).append("\n");
						flatFile.append("CALLSIGN:").append(vslVo.getCallSgnNo()).append("\n");
						flatFile.append("LLOYD_CD:").append(vslVo.getLloydNo()).append("\n");
						flatFile.append("VSL_NM:").append(vslVo.getVslEngNm()).append("\n");
						flatFile.append("CRN:").append(vslVo.getCvyRefNo()).append("\n");//추가
						flatFile.append("POL_ETD:").append(polEstDepDt).append("\n");//추가 필수X 마지막 Foreign Port에서 떠나는 Estimated Time of Depart
						flatFile.append("POL_ATD:").append(polActDepDt).append("\n");//추가	마지막 Foreign Port에서 떠난 Actual Time of Depart			
						flatFile.append("POD_ETA:").append(fristCaEtaDt).append("\n");//추가 첫번째 Canadian Port에 도착하는 Estimated Time of Arrival
						flatFile.append("LAST_POL:").append(lastpol).append("\n");//추가
						flatFile.append("FIRST_POD:").append(fristPod).append("\n");//추가	
					}
					
					bayCondVo = new BayPlanCntrListConCndVO();
					vo = (StiDetailCndVO) manifestTransmitVOs[i];
					bayCondVo.setVvd(searchVvdCd);
					bayCondVo.setPol(vo.getLPol());
					bayCondVo.setCntrNo(vo.getCntrNo());
					bayDetailVo = dbDao.searchBayPlanCntrList(bayCondVo);
					bayCmVos = dbDao.searchBayPlanCntrCmList(bayCondVo);
					if (bayDetailVo != null)
					{
						flatFile.append("{CNTR_INFO").append("\n");
						flatFile.append("CNTRNBR:").append(bayDetailVo.getCntrNo()).append("\n");
						flatFile.append("CNTRTYPE:").append(bayDetailVo.getCntrtype()).append("\n");						
						flatFile.append("CNTR_LENGTH:").append(bayDetailVo.getXterLen()).append("\n");//추가
						flatFile.append("CNTR_LENGTH_UNIT:").append("CM").append("\n");//추가
						flatFile.append("CNTR_WIDTH:").append(bayDetailVo.getXterWdt()).append("\n");//추가
						flatFile.append("CNTR_WIDTH_UNIT:").append("CM").append("\n");//추가
						flatFile.append("CNTR_HEIGHT:").append(bayDetailVo.getXterHgt()).append("\n");//추가
						flatFile.append("CNTR_HEIGHT_UNIT:").append("CM").append("\n");//추가
						flatFile.append("FM_IND:").append(bayDetailVo.getFmInd()).append("\n");
						flatFile.append("CNTR_STATUS:").append(bayDetailVo.getCntrStatus()).append("\n");
						flatFile.append("EQA_UNIT:").append("\n");
						flatFile.append("EQA_VAL:").append("\n");
						flatFile.append("STW_POS:").append(bayDetailVo.getPos()).append("\n");
						flatFile.append("WGT_UNIT:").append("KGM").append("\n");
						flatFile.append("WGT_VAL:").append(bayDetailVo.getWgt()).append("\n");
						flatFile.append("OVF_IND:").append("\n");
						flatFile.append("OVF_VAL:").append("\n");
						flatFile.append("OVR_IND:").append("\n");
						flatFile.append("OVR_VAL:").append("\n");
						flatFile.append("OVLW_IND:").append("\n");
						flatFile.append("OVLW_VAL:").append("\n");
						flatFile.append("OVRW_IND:").append("\n");
						flatFile.append("OVRW_VAL:").append("\n");
						flatFile.append("OVH_IND:").append("\n");
						flatFile.append("OVH_VAL:").append("\n");
						
						for (int k = 0; k < bayCmVos.size(); k++)
						{
							flatFile.append("{DESC").append("\n");
							flatFile.append("DESC:").append(bayCmVos.get(k).getCntrMfGdsDesc()).append("\n");//추가
							flatFile.append("PKG_TOTAL:").append(bayCmVos.get(k).getPckQty()).append("\n");//추가
							flatFile.append("PKG_UNIT:").append(bayCmVos.get(k).getPckTpCd()).append("\n");//추가
							flatFile.append("}DESC").append("\n");
						}		
						
						flatFile.append("TUNIT:").append(bayDetailVo.getTunit()).append("\n");
						flatFile.append("TEMP:").append(bayDetailVo.getTemp()).append("\n");
						flatFile.append("TEMP_MIN:").append("\n");
						flatFile.append("TEMP_MAX:").append("\n");
						flatFile.append("POR:").append(bayDetailVo.getPor()).append("\n");
						flatFile.append("POL:").append(bayDetailVo.getPol()).append("\n");
						flatFile.append("POD:").append(bayDetailVo.getPod()).append("\n");
						flatFile.append("DEL:").append(bayDetailVo.getDel()).append("\n");
						flatFile.append("REF_NO:").append("\n");

						flatFile.append("{DANGER").append("\n");//추가
						flatFile.append("IMDG_CD:").append(bayDetailVo.getImdg()).append("\n");
						flatFile.append("PAGE:").append("\n");
						flatFile.append("UNNBR:").append(bayDetailVo.getUnno()).append("\n");
						flatFile.append("FLSH_UNIT:").append("\n");
						flatFile.append("FLSH_TEMP:").append("\n");
						flatFile.append("CLASS:").append("\n");
						flatFile.append("EMS:").append("\n");
						flatFile.append("MFAG:").append("\n");						
						flatFile.append("DG_DESC:").append("").append("\n");//추가		
						flatFile.append("}DANGER").append("\n");
						
						// IMDG_CD(2),UNNBR(4) 값은 CoLoad_ed 컬럼에 있다. 
						if (bayDetailVo.getCoLoaded() != "" ) {
						
							String strCoLoad = bayDetailVo.getCoLoaded();
							int num = strCoLoad.length()/6;
							   
							int checkLen = 0;
							for (int q = 0; q < num; q++)
							{
								checkLen = q*6;
								bayDetailVo.setImdg(strCoLoad.substring(checkLen,checkLen+2));
								bayDetailVo.setUnno(strCoLoad.substring(checkLen+2,checkLen+6));
								
								flatFile.append("{DANGER").append("\n");//추가
								flatFile.append("IMDG_CD:").append(bayDetailVo.getImdg()).append("\n");
								flatFile.append("PAGE:").append("\n");
								flatFile.append("UNNBR:").append(bayDetailVo.getUnno()).append("\n");
								flatFile.append("FLSH_UNIT:").append("\n");
								flatFile.append("FLSH_TEMP:").append("\n");
								flatFile.append("CLASS:").append("\n");
								flatFile.append("EMS:").append("\n");
								flatFile.append("MFAG:").append("\n");						
								flatFile.append("DG_DESC:").append("").append("\n");//추가
								flatFile.append("}DANGER").append("\n");		
							}
						}

						flatFile.append("SCAC:").append(bayDetailVo.getScac()).append("\n");
						flatFile.append("}CNTR_INFO").append("\n");						

					}
					// 조회결과를 배열에 Set up.
					bayDetailVos[i] = bayDetailVo;
				}
				
				// BKG_CSTMS_ADV_STWG_SND_LOG 입력을 위한 VO.
				String seq = dbDao.searchDateSeq();
				flatFile.insert(0, "$$$MSGSTART:SMLINE              RCCECECPP           BAPLIE    BKC" + seq+ "\n");
				SendDetailLogCndVO sendDetailLogVO = new SendDetailLogCndVO();
				sendDetailLogVO.setSndProcId("STW_CA");
				sendDetailLogVO.setSeq(seq);
				sendDetailLogVO.setVvd(condVvd);
				sendDetailLogVO.setPol(lastpol);
				sendDetailLogVO.setUsrId(usrId);
				sendDetailLogVO.setOfcCd(ofcCd);
				sendDetailLogVO.setCntrCount(Integer.toString(manifestTransmitVOs.length));
				sendDetailLogVO.setSndDt(lsDate);
				// POD는 Row중 첫번째 POD로 지정한다. 이 방법은 추후 확인을 받아야 한다.
				// 조회조건상의 POD를 입력한다. 없으면 안 넣는다.
				sendDetailLogVO.setPod(pod);				
				sendDetailLogVO.setCstmsPortCd(usPortCd);	// CSTMS_PORT_CD 칼럼 추가

				// BKG_CSTMS_ADV_STWG_SND_LOG 입력 실행.
				int result = dbDao.addStowageSendLog(sendDetailLogVO);
				if (result > 0)
				{
					StringTokenizer token = new StringTokenizer(flatFile.toString(), "\n");
					int i = 1;
					int j = 0; // 개행문자를 j 가 0보다 큰경우, 구문 앞에 추가한다.
					String tmpStr = "";
					String lineStr = "";
					StringBuffer lineBuf = new StringBuffer();
					while (token.hasMoreTokens())
					{
						tmpStr = token.nextToken();
						if (j > 0)
							tmpStr = "\n" + tmpStr;
						lineStr = lineBuf.toString();
						lineBuf.append(tmpStr);
						// 4000Byte 까지 채운다.
						// tmpStr까지 합친 값이 3900바이트를 넘는다면, 이전까지 취합되었던 lineStr만을
						// 로그에 넣고, 다시 초기화 한다.
						if (lineBuf.length() > 3900)
						{
							sendDetailLogVO.setDtlSeq(i + "");
							sendDetailLogVO.setMsg(lineStr);
							dbDao.addSendDetailLog(sendDetailLogVO);
							i++;
							lineBuf = new StringBuffer(tmpStr);
						}
						j++;
					}
					if (lineBuf.length() > 0)
					{
						sendDetailLogVO.setDtlSeq(i + "");
						sendDetailLogVO.setMsg(lineBuf.toString());
						dbDao.addSendDetailLog(sendDetailLogVO);
					}
				}
				result = 0;
				SendLogDetailCndVO sendLogDetailVO = new SendLogDetailCndVO();
				;
				// ams_stowplan Proc파일에서는 전달받은 컨테이너 번호를 다시 한번 루프돌려 조회하는 로직.
				// 그러나, 조회내용이 위에서 조회한 searchBayPlanCntrList 와 동일하므로 이를 생략하고,
				// 위에서 구한 bayDetailVos로 루프를 돌려 이후 로직을 구현한다.
				
				for (int i = 0; i < bayDetailVos.length; i++)
				{
					bayDetailVo = new BayPlanCntrDetailCndVO(); // 초기화.
					bayDetailVo = bayDetailVos[i];
					// BKG_CSTMS_ADV_STWG_CNTR 갱신및 입력을 위한 VO.
					sendLogDetailVO.setCntrNo(bayDetailVo.getCntrNo());
					sendLogDetailVO.setDel(bayDetailVo.getDel());
					sendLogDetailVO.setLastpol(lastpol);
					sendLogDetailVO.setOfcCd(ofcCd);
					sendLogDetailVO.setPod(bayDetailVo.getPod());
					sendLogDetailVO.setPol(bayDetailVo.getPol());
					sendLogDetailVO.setPos(bayDetailVo.getPos());
					sendLogDetailVO.setSeq(seq);
					sendLogDetailVO.setUsrId(usrId);
					sendLogDetailVO.setVvd(searchVvdCd);
					// BKG_CSTMS_ADV_STWG_CNTR 갱신 실행.
					result = dbDao.modifySendLogByCntr(sendLogDetailVO);
					if (result == 0)
					{
						result = dbDao.addSendLogByCntr(sendLogDetailVO);
					}
				}
			}
			
			/*********************************************
			 * // Message Send Start
			 *********************************************/
			BookingUtil command2 = new BookingUtil();
			FlatFileAckVO flatFileAckVO = null;
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CANCUS.IBMMQ.QUEUE"));
			sendFlatFileVO.setFlatFile(flatFile.toString());
			flatFileAckVO = command2.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			/*********************************************
			 * // Message Send End.
			 *********************************************/
			
			//System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");
			//System.out.println(flatFile.toString());
			//System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");
			
			return flatFile.toString();
		}
		catch (EventException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw ex;
		}
		catch (DAOException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

}