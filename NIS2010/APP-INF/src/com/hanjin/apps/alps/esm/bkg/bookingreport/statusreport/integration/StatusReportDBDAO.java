/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : StatusReportDBDAO.java
 *@FileTitle : StatusReport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.28
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.05.28 김경섭
 * ------------------------------------------------------
 * history
 * 1.0 Creation 
 * 1.29 2010.09.27 이재위 [CHM-201005253-01] [BKG/DOC] EIR Exchange & Customs Release Check Report 신규개발(ESM_BKG_1110)[SZPBB]
 * 1.30 2011.07.08 김영철 [CHM-201111970] [BKG]Booking status report 기능 보완
 * 2011.09.02 변종건 [CHM-201111165-01] [BKG] BL Data Input Cross-check 기능 추가 보완-Sailing Date 및  Multi-VVD Base 검색 조건 추가
 * 2013.01.10 조정민 [CHM-201222115][BL Issue&Print기능] (1) BL Status Report-GSO추가 (2) BL Issue&Onboard Date Update-FWDR정보 추가
 * 2013.02.25 김진주 [CHM-201322909] [O/B Container movement status] multiple office 기능 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.basic.StatusReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BdrBookingNoListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListByBLVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListByExportBLVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListinVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListinVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListoutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgClearanceCrossCheckListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListByBLVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListinVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BlStsReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BlStsReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.CntrStowageintVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.CustVipReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.CustVipReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.DocsAmendReasonCDVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.DocsQueueDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.LoadingConfirmationinVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdEirMovementStatusListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsTPSZSumListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsYardSumListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMvntStsNtcListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMvntStsNtcListSumVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SearchBDRBookingStatusListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SearchRollOverInformationVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SearchTradeListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportSpecialCargoOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportSummaryOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SurchageSummaryInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.TsLoadingRptByLocListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.TsLoadingRptByLocListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.VgmStatusReportVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.WarningReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.WarningReportOutVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 StatusReportDBDAO <br>
 * - NIS2010-BookingReport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Gyoung Sub
 * @see StatusReportBCImpl 참조
 * @since J2EE 1.6
 */
public class StatusReportDBDAO extends DBDAOSupport {

	/**
	 * BDR Status Inquiry 정보를 조회합니다.<br>
	 * @param SearchBDRBookingStatusListVO searchBDRBookingStatusListVO
	 * @return List<SearchBDRBookingStatusListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBDRBookingStatusListVO> searchBDRBookingStatusList(SearchBDRBookingStatusListVO searchBDRBookingStatusListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBDRBookingStatusListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = searchBDRBookingStatusListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBDRBookingStatusList1RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchBDRBookingStatusListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Roll Over Information 정보를 조회합니다.<br>
	 * @param SearchRollOverInformationVO searchRollOverInformationVO
	 * @return List<SearchRollOverInformationVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchRollOverInformationVO> searchRollOverInformationList(SearchRollOverInformationVO searchRollOverInformationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRollOverInformationVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = searchRollOverInformationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchRollOverInformationRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchRollOverInformationVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * B/L Data  입력 완료 확인 리포트 기능 <br>
	 * @param BkgClearanceCrossCheckListInVO bkgClearanceCrossCheckListInVO
	 * @return List<SearchInternetUserAuthVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBDRBookingStatusListVO> getRuntime() throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBDRBookingStatusListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBDRBookingStatusList2RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchBDRBookingStatusListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * B/L Data 입력 완료 확인 리포트 기능<br>
	 * 
	 * @param BkgClearanceCrossCheckListInVO searchBDRBookingStatusListVO
	 * @return List<BkgClearanceCrossCheckListInVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgClearanceCrossCheckListInVO> bkgClearanceCrossCheckList(BkgClearanceCrossCheckListInVO searchBDRBookingStatusListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgClearanceCrossCheckListInVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			String mxFlg = "";
		try {
			
			
			Map<String, String> mapVO = searchBDRBookingStatusListVO.getColumnValues();
			
			if(searchBDRBookingStatusListVO.getPPolCd().indexOf("MX")> -1 ||searchBDRBookingStatusListVO.getPPorCd().indexOf("MX")> -1) {
				mxFlg = "O";
			}else if(searchBDRBookingStatusListVO.getPApodCd().indexOf("MX")> -1 ||searchBDRBookingStatusListVO.getPDelCd().indexOf("MX")> -1) {
				mxFlg = "I";
			}			
			param.putAll(mapVO);
			param.put("mx_flg",mxFlg);
			velParam.putAll(mapVO);
			velParam.put("mx_flg",mxFlg);
			if (!JSPUtil.getNull(searchBDRBookingStatusListVO.getPNoGood()).equals("")) {
				ArrayList<String> nogoolList = JSPUtil.convertStringToArrayList(searchBDRBookingStatusListVO.getPNoGood());
				for (int i = 0; i < nogoolList.size(); i++) {
					velParam.put(nogoolList.get(i), "Y");
				}
			}
			
			ArrayList<String> vvdArr = new ArrayList<String>();
			String multiVvd[] = searchBDRBookingStatusListVO.getMultiVvd().split("\\,");
						
			if(multiVvd != null){
			    for(int idx=0;idx<multiVvd.length;idx++){
			    	vvdArr.add(multiVvd[idx].toString());
			    }

			    if( vvdArr.size() > 0 ){
					velParam.put("vvd_arr", vvdArr);
				} else {
					throw new EventException((String)new ErrorHandler("BKG00007").getMessage());
				}
		    }
			
			ArrayList<String> blckStwgArr = new ArrayList<String>();
			if(searchBDRBookingStatusListVO.getBlckStwgCd() != null && !"".equals(searchBDRBookingStatusListVO.getBlckStwgCd())){
				String multiBlckStwg[] = searchBDRBookingStatusListVO.getBlckStwgCd().split("\\,");
				if(multiBlckStwg != null){
				    for(int idx=0;idx<multiBlckStwg.length;idx++){
				    	blckStwgArr.add(multiBlckStwg[idx].toString());
				    }
	
				    if( blckStwgArr.size() > 0 ){
						velParam.put("blck_stwg_arr", blckStwgArr);
					}
			    }
			}
			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOBkgClearanceCrossCheckList1RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgClearanceCrossCheckListInVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Container List on Stowage & B/L<BR>
	 * 화면 - ESM_BKG_0162<BR>
	 * Bay-Plan과 NIS Booking Data를 Cross Check한 결과를 보여주는 화면<BR>
	 * 
	 * @param CntrStowageintVO vo
	 * @return List<CntrStowageintVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrStowageintVO> searchContainerStowageList(CntrStowageintVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrStowageintVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			log.debug("==========================");
			log.debug("mapVO:" + mapVO);
			log.debug("==========================");
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOCntrStowageintVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrStowageintVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Loading Confirmation by Shipper (Fax / E-Mail)<BR>
	 * 화면 - ESM_BKG_0618<BR>
	 * 고객에게 Container Loading Confirmation을 발송하는 기능
	 * 
	 * @param LoadingConfirmationinVO vo
	 * @return List<LoadingConfirmationinVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<LoadingConfirmationinVO> searchBookingListForLoadingConfirmation(LoadingConfirmationinVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<LoadingConfirmationinVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			log.debug("==========================");
			log.debug("mapVO:" + mapVO);
			log.debug("==========================");
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOLoadingConfirmationinVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, LoadingConfirmationinVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Outbound Container Movement Status(ESM_BKG_1110)<BR>
	 * 1.Outbound Container Movement Status<BR>
	 * 
	 * @param OutBdEirMovementStatusListVO vo
	 * @return List<OutBdEirMovementStatusListVO>
	 * @throws DAOException
	 */
	public List<OutBdEirMovementStatusListVO> searchOutBdEirMovementStatusList(OutBdEirMovementStatusListVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OutBdEirMovementStatusListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			log.debug("==========================");
			log.debug("mapVO:" + mapVO);
			log.debug("==========================");
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchOutBdEirMovementStatusListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OutBdEirMovementStatusListVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Outbound Container Movement Status(ESM_BKG_0619)<BR>
	 * 1.Outbound Container Movement Status<BR>
	 * 
	 * @param OutBdMovementStsListInVO vo
	 * @return List<OutBdMovementStsListInVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OutBdMovementStsListInVO> searchOutBdMovementStsList(OutBdMovementStsListInVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OutBdMovementStsListInVO> list = null;
		List<String> bkgOfcCd = new ArrayList();
		String r_bkgOfcCd		= JSPUtil.getNull(vo.getBkgOfcCd());
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(!r_bkgOfcCd.equals("")){
				String arrBkgNumber[] = vo.getBkgOfcCd().split(",");
				for(int i=0;i<arrBkgNumber.length;i++){   
					bkgOfcCd.add(arrBkgNumber[i]);   
				} 
			}
			param.put("r_bkgOfcCd",bkgOfcCd);
			velParam.put("r_bkgOfcCd",bkgOfcCd);
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOOutBdMovementStsListInVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OutBdMovementStsListInVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Outbound Container Movement Status<br>
	 * 2.Outbound Container Movement Status by Yard Report(ESM_BKG_0619)<BR>
	 * 
	 * @param OutBdMovementStsListInVO vo
	 * @return List<OutBdMovementStsYardSumListOutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OutBdMovementStsYardSumListOutVO> searchOutBdMovementByYardSum(OutBdMovementStsListInVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OutBdMovementStsYardSumListOutVO> list = null;
		List<String> bkgOfcCd = new ArrayList();
		String r_bkgOfcCd		= JSPUtil.getNull(vo.getBkgOfcCd());			
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(!r_bkgOfcCd.equals("")){
				String arrBkgNumber[] = vo.getBkgOfcCd().split(",");
				for(int i=0;i<arrBkgNumber.length;i++){   
					bkgOfcCd.add(arrBkgNumber[i]);   
				} 
			}
			param.put("r_bkgOfcCd",bkgOfcCd);
			velParam.put("r_bkgOfcCd",bkgOfcCd);
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchOutBdMovementByYardSumRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OutBdMovementStsYardSumListOutVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Outbound Container Movement Status(ESM_BKG_0619)<br>
	 * 3.Outbound Container Movement Status by Type/Size Report(ESM_BKG_0619)<br>
	 * 
	 * @param OutBdMovementStsListInVO vo
	 * @return List<OutBdMovementStsTPSZSumListOutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OutBdMovementStsTPSZSumListOutVO> searchOutBdMovementByTPSZSum(OutBdMovementStsListInVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OutBdMovementStsTPSZSumListOutVO> list = null;
		List<String> bkgOfcCd = new ArrayList();
		String r_bkgOfcCd		= JSPUtil.getNull(vo.getBkgOfcCd());
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(!r_bkgOfcCd.equals("")){
				String arrBkgNumber[] = vo.getBkgOfcCd().split(",");
				for(int i=0;i<arrBkgNumber.length;i++){   
					bkgOfcCd.add(arrBkgNumber[i]);   
				} 
			}
			param.put("r_bkgOfcCd",bkgOfcCd);
			velParam.put("r_bkgOfcCd",bkgOfcCd);
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchOutBdMovementByTPSZSumRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OutBdMovementStsTPSZSumListOutVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 0103 Booking Status Report 정보를 조회합니다.<br>
	 * 
	 * @param StatusReportInVO statusReportInVO
	 * @return List<StatusReportOutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<StatusReportOutVO> searchBLStatusList(StatusReportInVO statusReportInVO) throws DAOException {
		DBRowSet dbRowset = null;
		DBRowSet dbRowsetCnrt = null;
		List<StatusReportOutVO> list = null;
		List<StatusReportOutVO> listCntr = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (statusReportInVO != null) {
				if (!JSPUtil.getNull(statusReportInVO.getDirCd()).equals("")) {
					statusReportInVO.setDirCd("'" + statusReportInVO.getDirCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getRTerm()).equals("")) {
					statusReportInVO.setRTerm("'" + statusReportInVO.getRTerm().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getDTerm()).equals("")) {
					statusReportInVO.setDTerm("'" + statusReportInVO.getDTerm().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getDeliMode()).equals("")) {
					statusReportInVO.setDeliMode("'" + statusReportInVO.getDeliMode().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getBkgKind()).equals("")) {
					statusReportInVO.setBkgKind("'" + statusReportInVO.getBkgKind().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getEqType()).equals("")) {
					statusReportInVO.setEqType("'" + statusReportInVO.getEqType().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getSModeOri()).equals("")) {
					statusReportInVO.setSModeOri("'" + statusReportInVO.getSModeOri().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getSModeDest()).equals("")) {
					statusReportInVO.setSModeDest("'" + statusReportInVO.getSModeDest().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getSRouteOri()).equals("")) {
					statusReportInVO.setSRouteOri("'" + statusReportInVO.getSRouteOri().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getSRouteDest()).equals("")) {
					statusReportInVO.setSRouteDest("'" + statusReportInVO.getSRouteDest().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getBOfcCd()).equals("") && !JSPUtil.getNull(statusReportInVO.getBOfcCdSub()).equals("")) {
					statusReportInVO.setBOfcCdSub(searchBLStatusList2(statusReportInVO));
				}
				if (!JSPUtil.getNull(statusReportInVO.getBOfcCd()).equals("")) {
					statusReportInVO.setCanOfcCd(statusReportInVO.getBOfcCd());
					statusReportInVO.setBOfcCd("'" + statusReportInVO.getBOfcCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getRtroKndCd()).equals("")) {
					statusReportInVO.setRtroKndCd("'" + statusReportInVO.getRtroKndCd().replaceAll(",", "','") + "'");
				}				
				if (!JSPUtil.getNull(statusReportInVO.getCtrtCngTpCd()).equals("")) {
					statusReportInVO.setCtrtCngTpCd("'" + statusReportInVO.getCtrtCngTpCd().replaceAll(",", "','") + "'");
				}					
				if (!JSPUtil.getNull(statusReportInVO.getMtyRtnEcc()).equals("")) {
					statusReportInVO.setMtyRtnEcc("'" + statusReportInVO.getMtyRtnEcc().replaceAll(",", "','") + "'");
				}				
				
				statusReportInVO.setOrderbySelect(statusReportInVO.getOrderby().replaceAll(",", "||"));
				
				Map<String, String> mapVO = statusReportInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				ArrayList<String> blckStwgArr = new ArrayList<String>();
				if(statusReportInVO.getBlckStwgCd() != null && !"".equals(statusReportInVO.getBlckStwgCd())){
					String multiBlckStwg[] = statusReportInVO.getBlckStwgCd().split("\\,");
					if(multiBlckStwg != null){
					    for(int idx=0;idx<multiBlckStwg.length;idx++){
					    	blckStwgArr.add(multiBlckStwg[idx].toString());
					    }
		
					    if( blckStwgArr.size() > 0 ){
							velParam.put("blck_stwg_arr", blckStwgArr);
						}
				    }
				}
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusList1RSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, StatusReportOutVO.class);
				for(int i=0 ; i< list.size() ; i++){
					param.put("bkg_no", list.get(i).getBkgNo());
					
					dbRowsetCnrt = null;
					listCntr = null;
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusList3RSQL(), param, velParam);
					listCntr = (List) RowSetUtil.rowSetToVOs(dbRowset, StatusReportOutVO.class);
					list.get(i).setCntrTpszCd(listCntr.get(0).getCntrTpszCd());
					
					dbRowsetCnrt = null;
					listCntr = null;
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusList4RSQL(), param, velParam);
					listCntr = (List) RowSetUtil.rowSetToVOs(dbRowset, StatusReportOutVO.class);
					list.get(i).setCntrNo(listCntr.get(0).getCntrNo());

					dbRowsetCnrt = null;
					listCntr = null;
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusList5RSQL(), param, velParam);
					listCntr = (List) RowSetUtil.rowSetToVOs(dbRowset, StatusReportOutVO.class);
					list.get(i).setSvcScpCd(listCntr.get(0).getSvcScpCd());
				}
			} else {
				list = new ArrayList<StatusReportOutVO>();
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 0103 Booking Status Report 정보를 위한 BKG OFC SUB정보를조회합니다.<br>
	 * 
	 * @param StatusReportInVO statusReportInVO
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchBLStatusList2(StatusReportInVO statusReportInVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String output_text="";
		try {
			Map<String, String> mapVO = statusReportInVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusList2RSQL(), param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("B_OFC_CD_SUB");
			} 
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
	}	
	/**
	 * 0103 Booking Status Report SpecialCargo 정보를 조회합니다.<br>
	 * 
	 * @param StatusReportInVO statusReportInVO
	 * @return List<StatusReportSpecialCargoOutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<StatusReportSpecialCargoOutVO> searchBLStatusListSpecialCargo(StatusReportInVO statusReportInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StatusReportSpecialCargoOutVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (statusReportInVO != null) {
				if (!JSPUtil.getNull(statusReportInVO.getDirCd()).equals("")) {
					statusReportInVO.setDirCd("'" + statusReportInVO.getDirCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getRTerm()).equals("")) {
					statusReportInVO.setRTerm("'" + statusReportInVO.getRTerm().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getDTerm()).equals("")) {
					statusReportInVO.setDTerm("'" + statusReportInVO.getDTerm().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getDeliMode()).equals("")) {
					statusReportInVO.setDeliMode("'" + statusReportInVO.getDeliMode().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getBkgKind()).equals("")) {
					statusReportInVO.setBkgKind("'" + statusReportInVO.getBkgKind().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getEqType()).equals("")) {
					statusReportInVO.setEqType("'" + statusReportInVO.getEqType().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getSModeOri()).equals("")) {
					statusReportInVO.setSModeOri("'" + statusReportInVO.getSModeOri().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getSModeDest()).equals("")) {
					statusReportInVO.setSModeDest("'" + statusReportInVO.getSModeDest().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getSRouteOri()).equals("")) {
					statusReportInVO.setSRouteOri("'" + statusReportInVO.getSRouteOri().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getSRouteDest()).equals("")) {
					statusReportInVO.setSRouteDest("'" + statusReportInVO.getSRouteDest().replaceAll(",", "','") + "'");
				}
				
				if (!JSPUtil.getNull(statusReportInVO.getBOfcCd()).equals("") && !JSPUtil.getNull(statusReportInVO.getBOfcCdSub()).equals("")) {
					statusReportInVO.setBOfcCdSub(searchBLStatusList2(statusReportInVO));
				}
				if (!JSPUtil.getNull(statusReportInVO.getBOfcCd()).equals("")) {
					statusReportInVO.setBOfcCd("'" + statusReportInVO.getBOfcCd().replaceAll(",", "','") + "'");
				}
				
				statusReportInVO.setOrderbySelect(statusReportInVO.getOrderby().replaceAll(",", "||"));
				
				Map<String, String> mapVO = statusReportInVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if(statusReportInVO.getPReportType().equals("ak"))
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusListSpecialCargo1RSQL(), param, velParam);
				else if(statusReportInVO.getPReportType().equals("bb"))
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusListSpecialCargo2RSQL(), param, velParam);
				else if(statusReportInVO.getPReportType().equals("dg"))
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusListSpecialCargo3RSQL(), param, velParam);
				else if(statusReportInVO.getPReportType().equals("rf") || statusReportInVO.getPReportType().equals("cntr")) 
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusListSpecialCargo4RSQL(), param, velParam);
					
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, StatusReportSpecialCargoOutVO.class);				
			} else {
				list = new ArrayList<StatusReportSpecialCargoOutVO>();
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 0103 Booking Status Report Summary 정보를 조회합니다.<br>
	 * 
	 * @param StatusReportInVO statusReportInVO
	 * @return List<StatusReportSummaryOutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<StatusReportSummaryOutVO> searchBLStatusListSummary(StatusReportInVO statusReportInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StatusReportSummaryOutVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (statusReportInVO != null) {
				if (!JSPUtil.getNull(statusReportInVO.getDirCd()).equals("")) {
					statusReportInVO.setDirCd("'" + statusReportInVO.getDirCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getRTerm()).equals("")) {
					statusReportInVO.setRTerm("'" + statusReportInVO.getRTerm().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getDTerm()).equals("")) {
					statusReportInVO.setDTerm("'" + statusReportInVO.getDTerm().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getDeliMode()).equals("")) {
					statusReportInVO.setDeliMode("'" + statusReportInVO.getDeliMode().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getBkgKind()).equals("")) {
					statusReportInVO.setBkgKind("'" + statusReportInVO.getBkgKind().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getEqType()).equals("")) {
					statusReportInVO.setEqType("'" + statusReportInVO.getEqType().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getSModeOri()).equals("")) {
					statusReportInVO.setSModeOri("'" + statusReportInVO.getSModeOri().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getSModeDest()).equals("")) {
					statusReportInVO.setSModeDest("'" + statusReportInVO.getSModeDest().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getSRouteOri()).equals("")) {
					statusReportInVO.setSRouteOri("'" + statusReportInVO.getSRouteOri().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(statusReportInVO.getSRouteDest()).equals("")) {
					statusReportInVO.setSRouteDest("'" + statusReportInVO.getSRouteDest().replaceAll(",", "','") + "'");
				}
				
				if (!JSPUtil.getNull(statusReportInVO.getBOfcCd()).equals("") && !JSPUtil.getNull(statusReportInVO.getBOfcCdSub()).equals("")) {
					statusReportInVO.setBOfcCdSub(searchBLStatusList2(statusReportInVO));
				}
				if (!JSPUtil.getNull(statusReportInVO.getBOfcCd()).equals("")) {
					statusReportInVO.setBOfcCd("'" + statusReportInVO.getBOfcCd().replaceAll(",", "','") + "'");
				}
				
				statusReportInVO.setOrderbySelect(statusReportInVO.getOrderby().replaceAll(",", "||"));
				
				Map<String, String> mapVO = statusReportInVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusListSummary1RSQL(), param, velParam);
					
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, StatusReportSummaryOutVO.class);
				
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * BDR Booking No Status - Inquiry(ESM_BKG_0727)<BR>
	 * 
	 * @param BdrBookingNoListVO vo
	 * @return List<BdrBookingNoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BdrBookingNoListVO> searchBDRBookingNoList(BdrBookingNoListVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BdrBookingNoListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBDRBookingNoListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BdrBookingNoListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * VIP Customer Report(0625) 정보를 조회합니다.<br>
	 * 
	 * @param CustVipReportInVO custVipReportInVO
	 * @return List<CustVipReportOutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustVipReportOutVO> searchCustVipReport(CustVipReportInVO custVipReportInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustVipReportOutVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (custVipReportInVO != null) {
				if (!JSPUtil.getNull(custVipReportInVO.getCustTpCd()).equals("")) {
					custVipReportInVO.setCustTpCd("'" + custVipReportInVO.getCustTpCd().replaceAll(",", "','") + "'");
				}
				
				Map<String, String> mapVO = custVipReportInVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchCustVipReport1RSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustVipReportOutVO.class);
			} else {
				list = new ArrayList<CustVipReportOutVO>();
			}
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * B/L Status Report(0647) 정보를 조회합니다.<br>
	 * 
	 * @param BlStsReportInVO blStsReportInVO
	 * @return List<BlStsReportOutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BlStsReportOutVO> searchBLStsReportList(BlStsReportInVO blStsReportInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlStsReportOutVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = blStsReportInVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStsReportList1RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BlStsReportOutVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * C/M Data Cross-Check List (Master BL/Houser BL)를 조회합니다.<br>
	 * 
	 * @param BkgCMCroChkListinVO vo
	 * @return List<BkgCMCroChkListByBLVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCMCroChkListByBLVO> searchCMCrossCheckList(BkgCMCroChkListinVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCMCroChkListByBLVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			if (vo.getTabItem().equals("0")) {

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOBkgCMCroChkListByBLVORSQL(), param, velParam);
			} else {

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOBkgCMCroChkListByHBLVORSQL(), param, velParam);
			}

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCMCroChkListByBLVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Export C/M Data Cross-Check List를 조회합니다.<br>
	 * 
	 * @param BkgCMCroChkListByExportBLVO vo
	 * @return List<BkgCMCroChkListByExportBLVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCMCroChkListByExportBLVO> searchCMCrossExportCheckList(BkgCMCroChkListByExportBLVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCMCroChkListByExportBLVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOBkgCMCroChkListByExportMBLVORSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCMCroChkListByExportBLVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * C/M Print by VVD 정보를 조회합니다.<br>
	 * 
	 * @param BkgCMPrintListinVO vo
	 * @return List<BkgCMPrintListoutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCMPrintListoutVO> searchCMPrintList(BkgCMPrintListinVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCMPrintListoutVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOBkgCMPrintListinVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCMPrintListoutVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * C/M Print by VVD (Fax) 정보를 조회합니다.<br>
	 * 
	 * @param BkgCMPrintListinVO vo
	 * @return List<BkgCMPrintListoutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCMPrintListoutVO> searchFaxPrintList(BkgCMPrintListinVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCMPrintListoutVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOBkgCMPrintListin2VORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCMPrintListoutVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 1006 Queue Detail Amend Reason Detail을 조회합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String srNo
	 * @return List<DocsAmendReasonCDVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DocsAmendReasonCDVO> searchAmendDetail(String bkgNo, String srNo) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<DocsAmendReasonCDVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("sr_no", srNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchAmendDetail1RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DocsAmendReasonCDVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 1007 Queue Detail Return Reason을 조회합니다.<br>
	 * 
	 * @param String srKndCd
	 * @param String bkgNo
	 * @param String srNo
	 * @return List<DocsQueueDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DocsQueueDetailVO> searchQueueDetail(String srKndCd, String bkgNo, String srNo) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<DocsQueueDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("sr_knd_cd", srKndCd);
			param.put("bkg_no", bkgNo);
			param.put("sr_no", srNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchQueueDetail1RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DocsQueueDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}


	/**
	 * 0953 O/B & T/S Loading Report by Location 정보를 조회합니다.<br>
	 * 
	 * @param tsLoadingRptByLocListInVO TsLoadingRptByLocListInVO
	 * @return List<TsLoadingRptByLocListOutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TsLoadingRptByLocListOutVO> searchTsLoadingReportByLocation(TsLoadingRptByLocListInVO tsLoadingRptByLocListInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TsLoadingRptByLocListOutVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = tsLoadingRptByLocListInVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchTsLoadingReportByLocationRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TsLoadingRptByLocListOutVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	
	/**
	 * (ESM_BKG_1143)C/M Data Cross-Check List (Master BL/Houser BL)를 조회합니다.<br>
	 * 
	 * @param BkgCroChkListinVO vo
	 * @return List<BkgCroChkListByBLVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCroChkListByBLVO> searchCrossCheckList(BkgCroChkListinVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCroChkListByBLVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			if (vo.getTabItem().equals("0")) {

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBkgCroChkListByBLVORSQL(), param, velParam);
			} else {

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBkgCroChkListByHBLVORSQL(), param, velParam);
			}

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCroChkListByBLVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ESM_BKG_0619) Trade, Sub Trade를 조회합니다.<br>
	 * @param div
	 * @param inputVO
	 * @return List<SearchTradeListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchTradeListVO> searchTradeList(String div, OutBdMovementStsListInVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTradeListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = inputVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("div", div);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchTradeListRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchTradeListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/** GSO에 속한 Sub Office 를 조회
	 * @param String gso
	 * @return List<BlStsReportOutVO>
	 * @throws DAOException
	 */
	public List<BlStsReportOutVO> searchGsoOfcList(String gso) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlStsReportOutVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("gso", gso);
			velParam.put("gso", gso);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchGsoOfcListRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BlStsReportOutVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**Outbound Container Movement Status (E-MAIL,SMS) (ESM_BKG_0622)<BR>
	 * @param OutBdMvntStsNtcListInVO vo
	 * @return List<OutBdMvntStsNtcListInVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OutBdMvntStsNtcListInVO> searchOutBdMovementStsNtcList(OutBdMvntStsNtcListInVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OutBdMvntStsNtcListInVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOsearchOutBdMovementStsNtcListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OutBdMvntStsNtcListInVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**Outbound Container Movement Status (E-MAIL,SMS) Summary (ESM_BKG_0622)<BR>
	 * @param OutBdMvntStsNtcListSumVO vo
	 * @return List<OutBdMvntStsNtcListSumVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OutBdMvntStsNtcListSumVO> searchOutBdMovementStsNtcListSum(OutBdMvntStsNtcListSumVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OutBdMvntStsNtcListSumVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOsearchOutBdMovementStsNtcListSumRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OutBdMvntStsNtcListSumVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * (ESM_BKG_1170)Sucharge Summary Report를 조회합니다.<br>
	 * 
	 * @param SurchageSummaryInVO vo
	 * @return List<SurchageSummaryInVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SurchageSummaryInVO> searchSurchageSummary(SurchageSummaryInVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SurchageSummaryInVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				if (!JSPUtil.getNull(vo.getPSvcScpCd()).equals("")) {
					vo.setPSvcScpCd("'" + vo.getPSvcScpCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(vo.getPSelOfcCd()).equals("")) {
					vo.setPSelOfcCd("'" + vo.getPSelOfcCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(vo.getPGsoBkgOfcCd()).equals("")) {
					vo.setPGsoBkgOfcCd("'" + vo.getPGsoBkgOfcCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(vo.getPCtrtOfcCd()).equals("")) {
					vo.setPCtrtOfcCd("'" + vo.getPCtrtOfcCd().replaceAll(",", "','") + "'");
				}
				
				if (!JSPUtil.getNull(vo.getPSelOfcCd2()).equals("")) {
					vo.setPSelOfcCd2("'" + vo.getPSelOfcCd2().replaceAll(",", "','") + "'");
				}
				
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSurchargeSummaryRSQL(), param, velParam);

				list = (List) RowSetUtil.rowSetToVOs(dbRowset, SurchageSummaryInVO.class);
				
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * (ESM_BKG_1175)Sucharge Summary Detail를 조회합니다.<br>
	 * 
	 * @param SurchageSummaryInVO vo
	 * @return List<SurchageSummaryInVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SurchageSummaryInVO> searchSurchageDetail(SurchageSummaryInVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SurchageSummaryInVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				if (!JSPUtil.getNull(vo.getPSvcScpCd()).equals("")) {
					vo.setPSvcScpCd("'" + vo.getPSvcScpCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(vo.getPSelOfcCd()).equals("")) {
					vo.setPSelOfcCd("'" + vo.getPSelOfcCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(vo.getPGsoBkgOfcCd()).equals("")) {
					vo.setPGsoBkgOfcCd("'" + vo.getPGsoBkgOfcCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(vo.getPCtrtOfcCd()).equals("")) {
					vo.setPCtrtOfcCd("'" + vo.getPCtrtOfcCd().replaceAll(",", "','") + "'");
				}
				
				if (!JSPUtil.getNull(vo.getPSelOfcCd2()).equals("")) {
					vo.setPSelOfcCd2("'" + vo.getPSelOfcCd2().replaceAll(",", "','") + "'");
				}
				
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSurchargeDetailRSQL(), param, velParam);

				list = (List) RowSetUtil.rowSetToVOs(dbRowset, SurchageSummaryInVO.class);				
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * @param WarningReportInVO warningReportInVO
	 * @return List<WarningReportOutVO> 
	 * @throws DAOException
	 */
	public List<WarningReportOutVO> searchWarningReportList(WarningReportInVO warningReportInVO)throws DAOException {
			DBRowSet dbRowset = null;
			List<WarningReportOutVO> list = null;
			
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (warningReportInVO != null) {
					if (!JSPUtil.getNull(warningReportInVO.getDirCd()).equals("")) {
						warningReportInVO.setDirCd("'" + warningReportInVO.getDirCd().replaceAll(",", "','") + "'");
					}
					if (!JSPUtil.getNull(warningReportInVO.getBOfcCd()).equals("") && !JSPUtil.getNull(warningReportInVO.getBOfcCdSub()).equals("")) {
						warningReportInVO.setBOfcCdSub(searchBkgOfcSub(warningReportInVO));
					}
					if (!JSPUtil.getNull(warningReportInVO.getBOfcCd()).equals("")) {
						warningReportInVO.setBOfcCd("'" + warningReportInVO.getBOfcCd().replaceAll(",", "','") + "'");
					}

					Map<String, String> mapVO = warningReportInVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOsearchWarningReportListRSQL(), param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, WarningReportOutVO.class);
				}

			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
	}	
	
	/**
	 * 0900 Warning Report 정보를 위한 BKG OFC SUB정보를조회합니다.<br>
	 * 
	 * @param WarningReportInVO warningReportInVO
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchBkgOfcSub(WarningReportInVO warningReportInVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String output_text="";
		try {
			Map<String, String> mapVO = warningReportInVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusList2RSQL(), param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("B_OFC_CD_SUB");
			} 
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
	}	

	/**
	 * @param VgmStatusReportVO vgmStatusReportVO
	 * @return List<VgmStatusReportVO> 
	 * @throws DAOException
	 */
	public List<VgmStatusReportVO> searchVgmCrossCheckList(VgmStatusReportVO vgmStatusReportVO)throws DAOException {
			DBRowSet dbRowset = null;
			List<VgmStatusReportVO> list = null;
			
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (vgmStatusReportVO != null) {
					
					Map<String, String> mapVO = vgmStatusReportVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					ArrayList<String> vvdArr = new ArrayList<String>();
					String multiVvd[] = vgmStatusReportVO.getMultiVvd().split("\\,");
					
					if(multiVvd != null){
					    for(int idx=0;idx<multiVvd.length;idx++){
					    	
							if  (!"".equals(multiVvd[idx].toString())) vvdArr.add(multiVvd[idx].toString());
					    }

					    if( vvdArr.size() > 0 ){
							velParam.put("vvd_arr", vvdArr);
						}
				    }
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOsearchVgmCrossCheckListRSQL(), param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, VgmStatusReportVO.class);
				}

			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
	}		
	
}