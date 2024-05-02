/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : WorkOrderManagementDBDAO.java
 *@FileTitle : W/O BFI Management 瑜� 議고쉶�븯�뒗 �솕硫�
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014-11-17
 *@LastModifier : P.K.S
 *@LastVersion : 1.0
 * 2014-11-17 P.K.S
 * 1.0 理쒖큹 �깮�꽦
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.vo.WorkOrderBFIManagementVO;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ESD-workordermanage�뿉 ���븳 DB 泥섎━瑜� �떞�떦<br>
 * - ESD-workordermanage Business Logic�쓣 泥섎━�븯湲� �쐞�븳 JDBC �옉�뾽�닔�뻾.<br>
 * 
 * @author P.K.S
 * @see WorkOrderManagementBCImpl 李몄“
 * @since J2EE 1.6
 */
public class WorkOrderManagementDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * [ESD_TRS_0029] W/O BFI Management 瑜� 議고쉶�빀�땲�떎. (Servlet CSV �슜) <br>
	 * 
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return List<WorkOrderBFIManagementVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<WorkOrderBFIManagementVO> searchWorkOrderManagementBFIListData(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<WorkOrderBFIManagementVO> resultVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (workOrderBFIManagementVO != null) {
				Map<String, String> mapVO = workOrderBFIManagementVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				List<String> vndrSeqs = new ArrayList<String>();
				String[] arrVndrSeq = workOrderBFIManagementVO.getVndrSeq().split(",");
				for (int i = 0; i < arrVndrSeq.length; i++) {
					vndrSeqs.add(arrVndrSeq[i]);
				}
				velParam.put("vndrSeqs", vndrSeqs);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new WorkOrderManagementDBDAOsearchWorkOrderBFIManagementRSQL(), param, velParam);
			resultVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, WorkOrderBFIManagementVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return resultVOs;
	}

	/**
	 * [ESD_TRS_0029] W/O BFI Management 瑜� 議고쉶�빀�땲�떎. <br>
	 * 
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return List<WorkOrderBFIManagementVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<WorkOrderBFIManagementVO> searchWorkOrderManagementBFIUiListData(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<WorkOrderBFIManagementVO> resultVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (workOrderBFIManagementVO != null) {
				Map<String, String> mapVO = workOrderBFIManagementVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				List<String> vndrSeqs = new ArrayList<String>();
				String[] arrVndrSeq = workOrderBFIManagementVO.getVndrSeq().split(",");
				for (int i = 0; i < arrVndrSeq.length; i++) {
					vndrSeqs.add(arrVndrSeq[i]);
				}
				velParam.put("vndrSeqs", vndrSeqs);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new WorkOrderManagementDBDAOsearchWorkOrderBFIManagementUiRSQL(), param, velParam);
			resultVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, WorkOrderBFIManagementVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultVOs;
	}

	/**
	 * [I/F]
	 * 
	 * @param cntrNo
	 * @param eventDt
	 * @param woNo
	 * @param yardCd
	 * @param mvmtStsCd
	 * @param bkgNo
	 * @param usrId
	 * @param inMvmtCreTpCd
	 * @return
	 * @throws DAOException
	 */
	public int modifyWorkOrderExecuteDate(String cntrNo, String eventDt, String woNo, String yardCd, String mvmtStsCd, String bkgNo, String usrId, String inMvmtCreTpCd) throws DAOException {
		int rtnVal = 0;
		SQLExecuter sqlExecuter = new SQLExecuter();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cntr_no", cntrNo);
		param.put("wo_exe_dt", eventDt);
		param.put("wo_no", woNo);
		param.put("node_cd", yardCd);
		param.put("mvmt_sts_cd", mvmtStsCd);
		param.put("bkg_no", bkgNo);
		param.put("upd_usr_id", usrId);
		param.put("mvmt_cre_tp_cd", inMvmtCreTpCd);
		try {
			sqlExecuter.executeUpdate((ISQLTemplate) new WorkOrderManagementDBDAOInsertTrsSubStsHisCSQL(), param, param);
			rtnVal = sqlExecuter.executeUpdate((ISQLTemplate) new WorkOrderManagementDBDAOModifyWorkOrderExecuteDateUSQL(), param, param);
			sqlExecuter.executeUpdate((ISQLTemplate) new WorkOrderManagementDBDAOModifyWorkOrderStatusUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}

	/**
	 * 
	 * @param inTrspSoOfcCtyCd
	 * @param inTrspSoSeq
	 * @param inTrspWoOfcCtyCd
	 * @param inTrspWoSeq
	 * @param inCntrNo
	 * @param inBkgNo
	 * @param inUpdUsrId
	 * @return
	 * @throws DAOException
	 */
	public int modifyWorkOrderExecuteDateByTrs(String inTrspSoOfcCtyCd, String inTrspSoSeq, String inTrspWoOfcCtyCd, String inTrspWoSeq, String inCntrNo, String inBkgNo, String inUpdUsrId) throws DAOException {
		int rtnVal = 0;
		SQLExecuter sqlExecuter = new SQLExecuter();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("trsp_so_ofc_cty_cd", inTrspSoOfcCtyCd);
		param.put("trsp_so_seq", inTrspSoSeq);
		param.put("trsp_wo_ofc_cty_cd", inTrspWoOfcCtyCd);
		param.put("trsp_wo_seq", inTrspWoSeq);
		param.put("cntr_no", inCntrNo);
		param.put("bkg_no", inBkgNo);
		param.put("upd_usr_id", inUpdUsrId);
		try {
			sqlExecuter.executeUpdate((ISQLTemplate) new WorkOrderManagementDBDAOInsertTrsSubStsHisForCntrAttachCSQL(), param, param);
			rtnVal = sqlExecuter.executeUpdate((ISQLTemplate) new WorkOrderManagementDBDAOModifyWorkOrderExecuteDateForCntrAttachUSQL(), param, param);
			if (!CheckUtilities.isInBlank(inTrspWoOfcCtyCd)) {
				sqlExecuter.executeUpdate((ISQLTemplate) new WorkOrderManagementDBDAOModifyWorkOrderStatusForCntrAttachUSQL(), param, param);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}

	/**
	 * searchTrsSubStsHis
	 * 
	 * @param List<TrsTrspSvcOrdVO> voList
	 * @return DBRowSet dRs
	 * @throws DAOException
	 */
	public DBRowSet searchTrsSubStsHis(List<TrsTrspSvcOrdVO> voList) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		if (voList != null && !voList.isEmpty()) {
			param.put("voList", voList);
			param.put("loc_ofc_cd", voList.get(0).getCreOfcCd());
			try {
				dRs = new SQLExecuter().executeQuery(new WorkOrderManagementDBDAOSearchTrsSubStsHisRSQL(), param, param);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(e.getMessage());
			}
		}

		return dRs;
	}

	/**
	 * [ESD_TRS_0029] download포맷의 W/O BFI Management 를 조회합니다. <br>
	 * 
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return List<WorkOrderBFIManagementVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<WorkOrderBFIManagementVO> searchWorkOrderBFIDownForInvoice(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<WorkOrderBFIManagementVO> resultVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (workOrderBFIManagementVO != null) {
				Map<String, String> mapVO = workOrderBFIManagementVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				List<String> vndrSeqs = new ArrayList<String>();
				String[] arrVndrSeq = workOrderBFIManagementVO.getVndrSeq().split(",");
				for (int i = 0; i < arrVndrSeq.length; i++) {
					vndrSeqs.add(arrVndrSeq[i]);
				}
				velParam.put("vndrSeqs", vndrSeqs);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new WorkOrderManagementDBDAOsearchWorkOrderBFIDownForInvoiceRSQL(), param, velParam);
			resultVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, WorkOrderBFIManagementVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultVOs;
	}

	/**
	 * [ESD_TRS_0029] W/O BFI Management retieve. <br>
	 * 
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchBFIManagementListForEmail(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (workOrderBFIManagementVO != null) {
				Map<String, String> mapVO = workOrderBFIManagementVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				List<String> vndrSeqs = new ArrayList<String>();
				String[] arrVndrSeq = workOrderBFIManagementVO.getVndrSeq().split(",");
				for (int i = 0; i < arrVndrSeq.length; i++) {
					vndrSeqs.add(arrVndrSeq[i]);
				}
				velParam.put("vndrSeqs", vndrSeqs);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new WorkOrderManagementDBDAOsearchWorkOrderBFIManagementUiRSQL(), param, velParam);
			// TODO : dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new WorkOrderMangementDBDAOsearchBFIManagementListRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * check vendor's email address exists or not
	 * 
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return
	 * @throws DAOException
	 */
	public int checkVndrPrmrCntcPntEmailAddr(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws DAOException {
		int rtnVal = 0;
		DBRowSet dbRowset = null;
		SQLExecuter sqlExecuter = new SQLExecuter();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = workOrderBFIManagementVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			List<String> vndrSeqs = new ArrayList<String>();
			String[] arrVndrSeq = workOrderBFIManagementVO.getVndrSeq().split(",");
			for (int i = 0; i < arrVndrSeq.length; i++) {
				vndrSeqs.add(arrVndrSeq[i]);
			}
			velParam.put("vndrSeqs", vndrSeqs);
			
			dbRowset = sqlExecuter.executeQuery((ISQLTemplate) new WorkOrderManagementDBDAOCheckVndrPrmrCntcPntEmailAddrRSQL(), param, velParam);
			while(dbRowset.next()) {
				rtnVal = dbRowset.getInt("cnt");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}

	/**
	 * searchVendorList
	 * 
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return String[] vendors
	 * @throws DAOException
	 */
	public String[] searchVendorList(WorkOrderBFIManagementVO workOrderBFIManagementVO) throws DAOException {
		String[] vendors = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = workOrderBFIManagementVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			List<String> vndrSeqs = new ArrayList<String>();
			String[] arrVndrSeq = workOrderBFIManagementVO.getVndrSeq().split(",");
			for (int i = 0; i < arrVndrSeq.length; i++) {
				vndrSeqs.add(arrVndrSeq[i]);
			}
			velParam.put("vndrSeqs", vndrSeqs);
			DBRowSet dRs = new SQLExecuter().executeQuery(new WorkOrderManagementDBDAOsearchWorkOrderBFIManagementVndrListRSQL(), param, velParam);
			if(dRs.getRowCount() > 0) {
				vendors = new String[dRs.getRowCount()];
				int ndx = 0;
				while(dRs.next()) {
					vendors[ndx] = dRs.getString("VNDR_SEQ");
					ndx ++;
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}

		return vendors;
	}
}
