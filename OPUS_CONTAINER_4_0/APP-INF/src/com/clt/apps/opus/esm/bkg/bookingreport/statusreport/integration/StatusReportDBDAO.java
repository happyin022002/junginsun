/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : StatusReportDBDAO.java
 *@FileTitle : StatusReport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.28
 *@LastModifier : 源�寃쎌꽠
 *@LastVersion : 1.0
 * 2009.05.28 源�寃쎌꽠
 * 1.0 Creation 
 * 1.29 2010.09.27 �씠�옱�쐞 [CHM-201005253-01] [BKG/DOC] EIR Exchange & Customs Release Check Report �떊洹쒓컻諛�(ESM_BKG_1110)[SZPBB]
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.basic.StatusReportBCImpl;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BdrBookingNoListVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListByBLVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListinVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListinVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListoutVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgClearanceCrossCheckListInVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListByBLVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListinVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BlStsReportInVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BlStsReportOutVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BokCntrListInVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BokCntrListOutVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CntrStowageintVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CustVipReportInVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CustVipReportOutVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.DocsAmendReasonCDVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.DocsQueueDetailVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdEirMovementStatusListVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsListInVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsTPSZSumListOutVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsYardSumListOutVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.SearchBDRBookingStatusListVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.SearchTradeListVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportInVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportOutVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportSpecialCargoOutVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportSummaryOutVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.TsLoadingRptByLocListInVO;
//import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.TsLoadingRptByLocListOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.*;								//SJH.20150130.MOD : �떎�븯硫대맆�뀗�뜲..	
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BlCntrInfoReportOutVO;			//SJH.20150113.ADD

/**
 *  StatusReportDBDAO <br>
 * - BookingReport system Business Logic�쓣 泥섎━�븯湲� �쐞�븳 JDBC �옉�뾽�닔�뻾.<br>
 * 
 * @author Kim Gyoung Sub
 * @see StatusReportBCImpl 李몄“
 * @since J2EE 1.6
 */
public class StatusReportDBDAO extends DBDAOSupport {

	/**
	 * BDR Status Inquiry �젙蹂대�� 議고쉶�빀�땲�떎.<br>
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
	 * B/L Data  �엯�젰 �셿猷� �솗�씤 由ы룷�듃 湲곕뒫 <br>
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
	 * B/L Data �엯�젰 �셿猷� �솗�씤 由ы룷�듃 湲곕뒫<br>
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
	 * �솕硫� - ESM_BKG_0162<BR>
	 * Bay-Plan怨� Booking Data瑜� Cross Check�븳 寃곌낵瑜� 蹂댁뿬二쇰뒗 �솕硫�<BR>
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
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
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
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
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
	 * 0103 Booking Status Report �젙蹂대�� 議고쉶�빀�땲�떎.<br>
	 * 
	 * @param StatusReportInVO statusReportInVO
	 * @return List<StatusReportOutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<StatusReportOutVO> searchBLStatusList(StatusReportInVO statusReportInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StatusReportOutVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

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

				statusReportInVO.setOrderbySelect(statusReportInVO.getOrderby().replaceAll(",", "||"));
				
				mapVO = statusReportInVO.getColumnValues();
			}

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusList1RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, StatusReportOutVO.class);

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
	 * 0103 Booking Status Report �젙蹂대�� �쐞�븳 BKG OFC SUB�젙蹂대�쇱“�쉶�빀�땲�떎.<br>
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
	 * 0103 Booking Status Report SpecialCargo �젙蹂대�� 議고쉶�빀�땲�떎.<br>
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
		Map<String, String> mapVO = new HashMap<String, String>();
		
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
				
				statusReportInVO.setOrderbySelect(statusReportInVO.getOrderby().replaceAll(",", "||"));
				mapVO = statusReportInVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if(statusReportInVO.getPReportType().equals("ak"))
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusListSpecialCargo1RSQL(), param, velParam);
				else if(statusReportInVO.getPReportType().equals("bb"))
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusListSpecialCargo2RSQL(), param, velParam);
				else if(statusReportInVO.getPReportType().equals("dg"))
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusListSpecialCargo3RSQL(), param, velParam);
				else 
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusListSpecialCargo4RSQL(), param, velParam);
				
				
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, StatusReportSpecialCargoOutVO.class);
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
	 * 0103 Booking Status Report Summary �젙蹂대�� 議고쉶�빀�땲�떎.<br>
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
		Map<String, String> mapVO = new HashMap<String, String>();
		
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
				
				statusReportInVO.setOrderbySelect(statusReportInVO.getOrderby().replaceAll(",", "||"));
				mapVO = statusReportInVO.getColumnValues();
			}
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLStatusListSummary1RSQL(), param, velParam);
				
				
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, StatusReportSummaryOutVO.class);
			
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
	 * B/L Status Report(0647) �젙蹂대�� 議고쉶�빀�땲�떎.<br>
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
	 * C/M Data Cross-Check List (Master BL/Houser BL)瑜� 議고쉶�빀�땲�떎.<br>
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
	 * C/M Print by VVD �젙蹂대�� 議고쉶�빀�땲�떎.<br>
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
	 * C/M Print by VVD (Fax) �젙蹂대�� 議고쉶�빀�땲�떎.<br>
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
	 * 1006 Queue Detail Amend Reason Detail�쓣 議고쉶�빀�땲�떎.<br>
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
	 * 1007 Queue Detail Return Reason�쓣 議고쉶�빀�땲�떎.<br>
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
	 * 0953 O/B & T/S Loading Report by Location �젙蹂대�� 議고쉶�빀�땲�떎.<br>
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
	 * ESM_BKG_0619) Trade, Sub Trade瑜� 議고쉶�빀�땲�떎.<br>
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
	
	/**
	 * VIP Customer Report(0625) �젙蹂대�� 議고쉶�빀�땲�떎.<br>
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
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			if (custVipReportInVO != null) {
				if (!JSPUtil.getNull(custVipReportInVO.getCustTpCd()).equals("")) {
					custVipReportInVO.setCustTpCd("'" + custVipReportInVO.getCustTpCd().replaceAll(",", "','") + "'");
				}
				mapVO = custVipReportInVO.getColumnValues();
			}

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchCustVipReport1RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustVipReportOutVO.class);
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
	 * (ESM_BKG_1143)C/M Data Cross-Check List (Master BL/Houser BL)瑜� 議고쉶�빀�땲�떎.<br>
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
	 * 1701 Booking Status Report �젙蹂대�� 議고쉶�빀�땲�떎.<br>
	 * 
	 * @param BokCntrListInVO bokCntrListInVO
	 * @return List<StatusReportOutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BokCntrListOutVO> searchBokCntrList(BokCntrListInVO bokCntrListInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BokCntrListOutVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (bokCntrListInVO != null) {
				if (!JSPUtil.getNull(bokCntrListInVO.getDirCd()).equals("")) {
					bokCntrListInVO.setDirCd("'" + bokCntrListInVO.getDirCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(bokCntrListInVO.getRTerm()).equals("")) {
					bokCntrListInVO.setRTerm("'" + bokCntrListInVO.getRTerm().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(bokCntrListInVO.getDTerm()).equals("")) {
					bokCntrListInVO.setDTerm("'" + bokCntrListInVO.getDTerm().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(bokCntrListInVO.getBkgKind()).equals("")) {
					bokCntrListInVO.setBkgKind("'" + bokCntrListInVO.getBkgKind().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(bokCntrListInVO.getEqType()).equals("")) {
					bokCntrListInVO.setEqType("'" + bokCntrListInVO.getEqType().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(bokCntrListInVO.getBOfcCd()).equals("") && !JSPUtil.getNull(bokCntrListInVO.getBOfcCdSub()).equals("")) {
					StatusReportInVO vo = new StatusReportInVO();
					vo.setBOfcCd(bokCntrListInVO.getBOfcCd());
					bokCntrListInVO.setBOfcCdSub(searchBLStatusList2(vo));
				}
				bokCntrListInVO.setOrderbySelect(bokCntrListInVO.getOrderby().replaceAll(",", "||"));
				mapVO = bokCntrListInVO.getColumnValues();
			}

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBokCntrListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BokCntrListOutVO.class);

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
	 * 1702 BL Container Information Report �젙蹂대�� 議고쉶�빀�땲�떎.<br>
	 * 
	 * @param CmBkgRptVO cmBkgRptVO
	 * @return List<BlCntrInfoReportOutVO>
	 * @throws DAOException
	 * @author SJH.20150113.ADD
	 */
	@SuppressWarnings("unchecked")
	public List<BlCntrInfoReportOutVO> searchBLCntrInfoList(CmBkgRptVO cmBkgRptVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlCntrInfoReportOutVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			if (cmBkgRptVO != null) {
				//Multi Combo媛� rtrer, dterm留�..
				if (!JSPUtil.getNull(cmBkgRptVO.getRTerm()).equals("")) {
					cmBkgRptVO.setRTerm(cmBkgRptVO.getRTerm().replaceAll(",", "','"));
				}
				if (!JSPUtil.getNull(cmBkgRptVO.getDTerm()).equals("")) {
					cmBkgRptVO.setDTerm(cmBkgRptVO.getDTerm().replaceAll(",", "','"));
				}
				mapVO = cmBkgRptVO.getColumnValues();			
			}

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchBLCntrInfoList1RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BlCntrInfoReportOutVO.class);

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
	 * Booking Container Report information retrieve (Down Excel)
	 * @param BokCntrListInVO bokCntrListInVO
	 * @param String selectCol
	 * @return DBRowSet
	 * @throws DAOException
	 * @author SJH.20150113.ADD
	 */
	public DBRowSet searchBokCntrDownExcel(BokCntrListInVO bokCntrListInVO, String selectCol) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try {
			if (bokCntrListInVO != null) {
				if (!JSPUtil.getNull(bokCntrListInVO.getDirCd()).equals("")) {
					bokCntrListInVO.setDirCd("'" + bokCntrListInVO.getDirCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(bokCntrListInVO.getRTerm()).equals("")) {
					bokCntrListInVO.setRTerm("'" + bokCntrListInVO.getRTerm().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(bokCntrListInVO.getDTerm()).equals("")) {
					bokCntrListInVO.setDTerm("'" + bokCntrListInVO.getDTerm().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(bokCntrListInVO.getBkgKind()).equals("")) {
					bokCntrListInVO.setBkgKind("'" + bokCntrListInVO.getBkgKind().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(bokCntrListInVO.getEqType()).equals("")) {
					bokCntrListInVO.setEqType("'" + bokCntrListInVO.getEqType().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(bokCntrListInVO.getBOfcCd()).equals("") && !JSPUtil.getNull(bokCntrListInVO.getBOfcCdSub()).equals("")) {
					StatusReportInVO vo = new StatusReportInVO();
					vo.setBOfcCd(bokCntrListInVO.getBOfcCd());
					bokCntrListInVO.setBOfcCdSub(searchBLStatusList2(vo));
				}
				bokCntrListInVO.setOrderbySelect(bokCntrListInVO.getOrderby().replaceAll(",", "||"));
				mapVO = bokCntrListInVO.getColumnValues();
			}

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("sel_cols", selectCol);
			velParam.put("sel_cols", selectCol);				
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusReportDBDAOSearchBokCntrDownExcelRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * 1701 Retrieving columns of selected report kind<br>
	 * 
	 * @param String rptId
	 * @param String rptKndCd
	 * @return String[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String[] searchSelectColumn(String rptId, String rptKndCd) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] cols = new String[2];

		try {
			if(rptId!=null && rptKndCd!=null){
				param.put("rpt_id", rptId);
				param.put("rpt_knd_cd", rptKndCd);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchSelectColumnRSQL(), param, velParam);			
			if (dbRowset.next()) {
				cols[0] = dbRowset.getString("COLS");
				cols[1] = dbRowset.getString("COLS_SEQ");
			} else {
				cols[0] = "";
				cols[1] = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cols;
	}
	
	/**
	 * Booking Loading Report information retrieve (Down Excel)
	 * @param CmBkgRptVO cmBkgRptVO
	 * @param String selectCol
	 * @param String rptId
	 * @return DBRowSet
	 * @throws DAOException
	 * @author SJH.20150130.ADD
	 */
	public DBRowSet searchCmBkgRptDownExcel(CmBkgRptVO cmBkgRptVO, String selectCol, String rptId) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		try {
			if (cmBkgRptVO != null) {
				if(rptId.equals("1702") || rptId.equals("1703") || rptId.equals("1704") || rptId.equals("1705")) {		//SJH.20150327.ADD 1702 異붽�..
					//Multi Combo媛� rtrer, dterm留�..
					if (!JSPUtil.getNull(cmBkgRptVO.getRTerm()).equals("")) {
						cmBkgRptVO.setRTerm("'" + cmBkgRptVO.getRTerm().replaceAll(",", "','") + "'");
					}
					if (!JSPUtil.getNull(cmBkgRptVO.getDTerm()).equals("")) {
						cmBkgRptVO.setDTerm("'" + cmBkgRptVO.getDTerm().replaceAll(",", "','") + "'");
					}				
				}
				if(rptId.equals("1703")) {
					if (!JSPUtil.getNull(cmBkgRptVO.getBkgStsCd()).equals("")) {
						cmBkgRptVO.setBkgStsCd("'" + cmBkgRptVO.getBkgStsCd().replaceAll(",", "','") + "'");
					}
					if (!JSPUtil.getNull(cmBkgRptVO.getEqType()).equals("")) {
						cmBkgRptVO.setEqType("'" + cmBkgRptVO.getEqType() + "'");
					}
				}
				mapVO = cmBkgRptVO.getColumnValues();
			}			
			mapVO.put("rptId",	rptId);					//蹂닿퀬�꽌援щ텇
			mapVO.put("sel_cols", selectCol);			//�꽑�깮 而щ읆	

			param.putAll(mapVO);
			velParam.putAll(mapVO); 
			
			if(rptId.equals("1702")) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusReportDBDAOBkgRptDownExcel1702RSQL(), param, velParam);
			} else if(rptId.equals("1703")) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusReportDBDAOBkgRptDownExcel1703RSQL(), param, velParam);
			} else if(rptId.equals("1704")) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusReportDBDAOBkgRptDownExcel1704RSQL(), param, velParam);
			} else if(rptId.equals("1705")) {
				if(cmBkgRptVO!=null){
					if(cmBkgRptVO.getPBkgRptKndCd().equals("G")) {
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusReportDBDAOBkgRptDownExcel1705DGRSQL(), param, velParam);
					} else if(cmBkgRptVO.getPBkgRptKndCd().equals("R")) {
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusReportDBDAOBkgRptDownExcel1705RFRSQL(), param, velParam);
					} else if(cmBkgRptVO.getPBkgRptKndCd().equals("A")) {
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusReportDBDAOBkgRptDownExcel1705AKRSQL(), param, velParam);
					} else if(cmBkgRptVO.getPBkgRptKndCd().equals("S")) {
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusReportDBDAOBkgRptDownExcel1705BBRSQL(), param, velParam);
					} else if(cmBkgRptVO.getPBkgRptKndCd().equals("H")) {//2015.05.30 decide to delete HG type.
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusReportDBDAOBkgRptDownExcel1705HGRSQL(), param, velParam);
					} else {
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusReportDBDAOBkgRptDownExcel1705DGRSQL(), param, velParam);
					}
				}				
			} else if(rptId.equals("1706")) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusReportDBDAOBkgRptDownExcel1706RSQL(), param, velParam);				
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}	
	
	/**
	 * VGM Dashboard<br>
	 * 
	 * @param VgmDashboardVO vgmDashboardVO
	 * @return List<VgmDashboardVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VgmDashboardVO> searchVgmDashboardList(VgmDashboardVO vgmDashboardVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VgmDashboardVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			
			Map<String, String> mapVO = vgmDashboardVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			if(vgmDashboardVO.getBkgNoList() != null){
				ArrayList<String> bkgNoList = new ArrayList();
				
				StringTokenizer multiBkgNoToken = new StringTokenizer(vgmDashboardVO.getBkgNoList().toUpperCase(),"\n");
				while(multiBkgNoToken.hasMoreTokens()){
					String bkgNo = multiBkgNoToken.nextToken();
					bkgNoList.add(bkgNo);
				}
				if(bkgNoList != null && bkgNoList.size() > 0){
					param.put("bkg_no_list", bkgNoList);
					velParam.put("bkg_no_list", bkgNoList);
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchVgmDashboardListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VgmDashboardVO.class);

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
	 * Update Vgm Wgt
	 * @param VgmDashboardVO vgmDashboardVO
	 * @throws DAOException
	 */
	public void updateVgmWgt(VgmDashboardVO vgmDashboardVO) throws DAOException {
		//query parameter
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vgmDashboardVO != null){
				mapVO = vgmDashboardVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusReportDBDAOupdateVgmWgtUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
			}
					
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * VGM Dashboard<br>
	 * 
	 * @param VgmDashboardVO vgmDashboardVO
	 * @return List<CllCdlVslSumForRDVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CllCdlVslSumForRDVO> searchCllCdlRdParam(VgmDashboardVO vgmDashboardVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CllCdlVslSumForRDVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			
			Map<String, String> mapVO = vgmDashboardVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOsearchCllCdlVslSumForRDRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CllCdlVslSumForRDVO.class);

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
	 * VGM History<br>
	 * 
	 * @param VgmHistoryVO vgmHistoryVO
	 * @return List<VgmHistoryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VgmHistoryVO> searchVgmHistory(VgmHistoryVO vgmHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VgmHistoryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			
			Map<String, String> mapVO = vgmHistoryVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchVgmHistoryRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VgmHistoryVO.class);

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
	 * Manage VGM Close
	 * @param VgmDashboardVO vgmDashboardVO
	 * @param String saveFlg
	 * @throws DAOException
	 */
	public void manageVgmClz(VgmDashboardVO vgmDashboardVO, String saveFlg) throws DAOException {
		//query parameter
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vgmDashboardVO != null){
				mapVO = vgmDashboardVO .getColumnValues();
				param.putAll(mapVO);
				param.put("save_flg", saveFlg);
				velParam.putAll(mapVO);
				velParam.put("save_flg", saveFlg);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusReportDBDAOManageVgmClzUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
			}
					
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	/**
	 * Search VGM EDI SUP<br>
	 * 
	 * @param VgmEdiSupVO vgmEdiSupVO
	 * @return List<VgmEdiSupVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VgmEdiSupVO> searchVgmEdiSup(VgmEdiSupVO vgmEdiSupVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VgmEdiSupVO> list = null;
		//query parameter
		Map<String, String> mapVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(vgmEdiSupVO != null){
				mapVO = vgmEdiSupVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOsearchVgmEdiSupRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VgmEdiSupVO.class);

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
	 * Search VGM Auto 301 EDI SUP<br>
	 * 
	 * @param String bkgNo
	 * @return List<VgmEdiSupVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VgmEdiSupVO> searchVgmAuto301EdiSup(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<VgmEdiSupVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchVgmAuto301EdiSupRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VgmEdiSupVO.class);

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
	 * Search VGM Auto VERMAS EDI SUP<br>
	 * 
	 * @param String bkgNo
	 * @return List<VgmEdiSupVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VgmEdiSupVO> searchVgmAutoVermasEdiSup(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<VgmEdiSupVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchVgmAutoVermasEdiSupRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VgmEdiSupVO.class);

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
	 * Search VGM Auto VERMAS EDI SUP<br>
	 * 
	 * @param String bkgNo
	 * @return String output_text
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String checkBkgForVgmClz(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String output_text = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOcheckBkgForVgmClzRSQL(), param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("VGM_CLZ_YN");
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
	 * Search VGM EDI SUP<br>
	 * 
	 * @param VgmEdiSupVO vgmEdiSupVO
	 * @return List<VgmEdiSupVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VgmEdiSupVO> searchVgmEdiSupMlt(VgmEdiSupVO vgmEdiSupVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VgmEdiSupVO> list = null;
		//query parameter
		Map<String, String> mapVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(vgmEdiSupVO != null){
				mapVO = vgmEdiSupVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchVgmEdiSupMltRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VgmEdiSupVO.class);

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
	 * Search VGM EDI SUP<br>
	 * 
	 * @param VgmEdiSupVO vgmEdiSupVO
	 * @return List<VgmEdiSupVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VgmEdiSupVO> searchVgmEdiMltList(VgmEdiSupVO vgmEdiSupVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VgmEdiSupVO> list = null;
		//query parameter
		Map<String, String> mapVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(vgmEdiSupVO != null){
				mapVO = vgmEdiSupVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StatusReportDBDAOSearchVgmEdiMltLstRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VgmEdiSupVO.class);

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
