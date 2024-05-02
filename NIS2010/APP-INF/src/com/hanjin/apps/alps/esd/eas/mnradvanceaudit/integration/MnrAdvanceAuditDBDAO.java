/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAO.java
*@FileTitle : Port (Service) Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-04-13 Jeong-Min Park
* 1.0 理쒖큹 �깮�꽦
*  
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0367Event;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0369Event;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.AuditMnrInvoiceVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.CleaningContainerBKGListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.CleaningContainerInquiryDetailVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.CleaningContainerInquiryListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MNRPreAuditCriterionVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrChargeDetailListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrChargeListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrGeneralCodeVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrInvoiceChargeINVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrMovementEmailSendHistoryVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrMovementVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrReportINVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MultipleRepairCNTRByAreaDetailVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MultipleRepairCNTRByAreaListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MultipleRepairCNTRByPeriodDetailVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MultipleRepairCNTRbyPeriodListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * MnrAdvanceAuditDBDAO 占쏙옙占쏙옙 PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author Jeong-Min Park
 * @see EventSupport 李몄“
 * @since J2EE 1.4
 */
public class MnrAdvanceAuditDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = -1132976440312128013L;
	
	/**
	 * ESD_EAS_0360 MNR CHARGE LIST
	 * 
	 * @param mnrInvoiceChargeINVO
	 * @return List<MNRChargeListVO>
	 * @throws DAOException
	 */
	public List<MnrChargeListVO> searchPreAuditList(MnrInvoiceChargeINVO mnrInvoiceChargeINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MnrChargeListVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrInvoiceChargeINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(mnrInvoiceChargeINVO.getSCostCd() != null && mnrInvoiceChargeINVO.getSCostCd().length() > 0) {
				List<String> costCds = new ArrayList<String>();
				String[] arrCostCd = mnrInvoiceChargeINVO.getSCostCd().split(",");
				for(int i = 0; i < arrCostCd.length; i++) {
					costCds.add(arrCostCd[i]);
				}
				param.put("costCds", costCds);
				velParam.put("costCds", costCds);
			}
			
			if(mnrInvoiceChargeINVO.getSErrType() != null && mnrInvoiceChargeINVO.getSErrType().length() > 0) {
				List<String> errTypes = new ArrayList<String>();
				String[] arrErrType = mnrInvoiceChargeINVO.getSErrType().split(",");
				for(int i = 0; i < arrErrType.length; i++) {
					errTypes.add(arrErrType[i]);
				}
				param.put("errTypes", errTypes);
				velParam.put("errTypes", errTypes);
			}
			
			if(mnrInvoiceChargeINVO.getSInvNo() != null && mnrInvoiceChargeINVO.getSInvNo().length() > 0) {
				List<String> invNos = new ArrayList<String>();
				String[] arrInvNo = mnrInvoiceChargeINVO.getSInvNo().split(",");
				for(int i = 0; i < arrInvNo.length; i++) {
					invNos.add(arrInvNo[i]);
				}
				param.put("invNos", invNos);
				velParam.put("invNos", invNos);
			}

			
			if(mnrInvoiceChargeINVO.getSCsrNo() != null && mnrInvoiceChargeINVO.getSCsrNo().length() > 0) {
				List<String> csrNos = new ArrayList<String>();
				String[] arrCsrNo = mnrInvoiceChargeINVO.getSCsrNo().split(",");
				for(int i = 0; i < arrCsrNo.length; i++) {
					csrNos.add(arrCsrNo[i]);
				}
				param.put("csrNos", csrNos);
				velParam.put("csrNos", csrNos);
			}

			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOsearchMNRChargeListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MnrChargeListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * MNR �떖�궗���긽 �긽�꽭 紐⑸줉
	 * 
	 * @param mnrInvoiceChargeINVO
	 * @return List<MnrChargeDetailListVO>
	 * @throws DAOException
	 */
	public List<MnrChargeDetailListVO> searchPreAuditDetailList(MnrInvoiceChargeINVO mnrInvoiceChargeINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MnrChargeDetailListVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrInvoiceChargeINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(mnrInvoiceChargeINVO.getSCostCd() != null && mnrInvoiceChargeINVO.getSCostCd().length() > 0) {
				List<String> costCds = new ArrayList<String>();
				String[] arrCostCd = mnrInvoiceChargeINVO.getSCostCd().split(",");
				for(int i = 0; i < arrCostCd.length; i++) {
					costCds.add(arrCostCd[i]);
				}
				param.put("costCds", costCds);
				velParam.put("costCds", costCds);
			}
			
			if(mnrInvoiceChargeINVO.getSErrType() != null && mnrInvoiceChargeINVO.getSErrType().length() > 0) {
				List<String> errTypes = new ArrayList<String>();
				String[] arrErrType = mnrInvoiceChargeINVO.getSErrType().split(",");
				for(int i = 0; i < arrErrType.length; i++) {
					errTypes.add(arrErrType[i]);
				}
				param.put("errTypes", errTypes);
				velParam.put("errTypes", errTypes);
			}

			// s_subsys_no가 없는 경우는 eas에서 직접 조회된 경우
			// s_mnr_inv_sts_cd가 HC인 경우는 MNR에서 팝업이 조회되더라도 Invoice Confirm 상태는 정상적인 Detail을 보여준다. 
			if("".equals(mnrInvoiceChargeINVO.getSSubsysNo()) || "HC".equals(mnrInvoiceChargeINVO.getSMnrInvStsCd())){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOsearchMNRChargeInoviceDetailListRSQL(), param, velParam);
			} else {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOsearchMNRChargeInvoiceDetailListForMNRRepairRSQL(), param, velParam);
			}
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MnrChargeDetailListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0360 MNR GENERAL CODE
	 * 
	 * @param mnrInvoiceChargeINVO
	 * @return List<MnrGeneralCodeVO>
	 * @throws DAOException
	 */
	public List<MnrGeneralCodeVO> searchMnrGeneralCode(MnrInvoiceChargeINVO mnrInvoiceChargeINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MnrGeneralCodeVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrInvoiceChargeINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOsearchMNRGenCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MnrGeneralCodeVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0360 CONFIRM MNR CHARGE LIST
	 * 
	 * @param mnrChargeListVOS
	 * @param account
	 * @throws DAOException
	 */
	public void manageMNRChargeList(MnrChargeListVO[] mnrChargeListVOS, SignOnUserAccount account) throws DAOException {
		try {
			int insCnt = 0;
			Map<String, String> param = new HashMap<String, String>();
			if(account == null){
				for(int f = 0; mnrChargeListVOS != null && f < mnrChargeListVOS.length; f++) {
					Map<String, String> mapVO = mnrChargeListVOS[f].getColumnValues();
					String batchTpCd = mnrChargeListVOS[f].getBatchTpCd();
					param.putAll(mapVO);
					insCnt = new SQLExecuter().executeUpdate(new MnrAdvanceAuditDBDAOupdatePreAuditUSQL(), param, param);
					
					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update SQL");
					}else{
						//실시간 배치일때는 배치 상태를 완료로 변경한다.
						if(batchTpCd != null && batchTpCd.equals("M")){
							insCnt = new SQLExecuter().executeUpdate((ISQLTemplate) new MnrAdvanceAuditDBDAOupdateBatchStatusUSQL() , param, null);
							if(insCnt == Statement.EXECUTE_FAILED){
								throw new DAOException("Fail to update SQL");
							}
						}
					}
				}
			}else{
				for(int f = 0; mnrChargeListVOS != null && f < mnrChargeListVOS.length; f++) {
					if("1".equals(mnrChargeListVOS[f].getSel()) || "S".equals(mnrChargeListVOS[f].getSSaveTpCd())) {
						
						param = mnrChargeListVOS[f].getColumnValues();
						param.put("upd_usr_id", account.getUsr_id());
						param.put("cre_ofc_cd", account.getOfc_cd());
						param.put("expn_aud_sts_cd", mnrChargeListVOS[f].getSelectFlg());
						
						DBRowSet dbRowset = null;
						//실시간 배치대상에 이미 포함되어 있는지를 검사한다.
						MnrAdvanceAuditDBDAOsearchReBatchTargetCheckRSQL chkSQL = new MnrAdvanceAuditDBDAOsearchReBatchTargetCheckRSQL();
						dbRowset = new SQLExecuter("").executeQuery(chkSQL, param, param);
						
						String progFlg = "";
						if(dbRowset.next()){
							progFlg = dbRowset.getString("prog_flg");
							if(progFlg.equals("Y")){
								throw new DAOException((new ErrorHandler("EAS99999",new String[]{"It is already included in batch target."})).getMessage());
							}
						}
						
						insCnt = new SQLExecuter().executeUpdate(new MnrAdvanceAuditDBDAOupdatePreAuditUSQL(), param, param);
						
						if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update " + " SQL");
					}
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * searchMultipleRepairCNTRByAreaList
	 * 
	 * @param mnrReportINVO
	 * @return List<MultipleRepairCNTRByAreaListVO>
	 * @throws DAOException
	 */
	public List<MultipleRepairCNTRByAreaListVO> searchMultipleRepairCNTRByAreaList(MnrReportINVO mnrReportINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MultipleRepairCNTRByAreaListVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrReportINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRByAreaListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MultipleRepairCNTRByAreaListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * searchMultipleRepairCNTRByAreaDetail
	 * 
	 * @param mnrReportINVO
	 * @return List<MultipleRepairCNTRByAreaDetailVO>
	 * @throws DAOException
	 */
	public List<MultipleRepairCNTRByAreaDetailVO> searchMultipleRepairCNTRByAreaDetail(MnrReportINVO mnrReportINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MultipleRepairCNTRByAreaDetailVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrReportINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRByAreaDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MultipleRepairCNTRByAreaDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * searchMultipleRepairCNTRByPeriodList
	 * 
	 * @param mnrReportINVO
	 * @return List<MultipleRepairCNTRbyPeriodListVO>
	 * @throws DAOException
	 */
	public List<MultipleRepairCNTRbyPeriodListVO> searchMultipleRepairCNTRByPeriodList(MnrReportINVO mnrReportINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MultipleRepairCNTRbyPeriodListVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrReportINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(mnrReportINVO.getSEqTpszCd() != null && mnrReportINVO.getSEqTpszCd().length() > 0) {
				List<String> eqTpSzCds = new ArrayList<String>();
				String[] arrEqTpSzCds = mnrReportINVO.getSEqTpszCd().split(",");
				for(int i = 0; i < arrEqTpSzCds.length; i++) {
					eqTpSzCds.add(arrEqTpSzCds[i]);
				}
				param.put("eqTpSzCds", eqTpSzCds);
				velParam.put("eqTpSzCds", eqTpSzCds);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRbyPeriodListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MultipleRepairCNTRbyPeriodListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * searchMultipleRepairCNTRByPeriodDetail
	 * 
	 * @param mnrReportINVO
	 * @return List<MultipleRepairCNTRByPeriodDetailVO>
	 * @throws DAOException
	 */
	public List<MultipleRepairCNTRByPeriodDetailVO> searchMultipleRepairCNTRByPeriodDetail(MnrReportINVO mnrReportINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MultipleRepairCNTRByPeriodDetailVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrReportINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRByPeriodDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MultipleRepairCNTRByPeriodDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * searchCleaningContainerInquiryList
	 * 
	 * @param mnrReportINVO
	 * @return List<CleaningContainerInquiryListVO>
	 * @throws DAOException
	 */
	public List<CleaningContainerInquiryListVO> searchCleaningContainerInquiryList(MnrReportINVO mnrReportINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CleaningContainerInquiryListVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrReportINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(mnrReportINVO.getSEqTpszCd() != null && mnrReportINVO.getSEqTpszCd().length() > 0) {
				List<String> eqTpSzCds = new ArrayList<String>();
				String[] arrEqTpSzCds = mnrReportINVO.getSEqTpszCd().split(",");
				for(int i = 0; i < arrEqTpSzCds.length; i++) {
					eqTpSzCds.add(arrEqTpSzCds[i]);
				}
				param.put("eqTpSzCds", eqTpSzCds);
				velParam.put("eqTpSzCds", eqTpSzCds);
			}
			
			if(mnrReportINVO.getSCostDtlCd() != null && mnrReportINVO.getSCostDtlCd().length() > 0) {
				List<String> costDtlCds = new ArrayList<String>();
				String[] arrCostDtlCds = mnrReportINVO.getSCostDtlCd().split(",");
				for(int i = 0; i < arrCostDtlCds.length; i++) {
					costDtlCds.add(arrCostDtlCds[i]);
				}
				param.put("costDtlCds", costDtlCds);
				velParam.put("costDtlCds", costDtlCds);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOsearchCleaningContainerInquiryListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CleaningContainerInquiryListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * searchCleaningContainerInquiryDetail
	 * 
	 * @param mnrReportINVO
	 * @return List<CleaningContainerInquiryDetailVO>
	 * @throws DAOException
	 */
	public List<CleaningContainerInquiryDetailVO> searchCleaningContainerInquiryDetail(MnrReportINVO mnrReportINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CleaningContainerInquiryDetailVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrReportINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(mnrReportINVO.getSEqTpszCd() != null && mnrReportINVO.getSEqTpszCd().length() > 0) {
				List<String> eqTpSzCds = new ArrayList<String>();
				String[] arrEqTpSzCds = mnrReportINVO.getSEqTpszCd().split(",");
				for(int i = 0; i < arrEqTpSzCds.length; i++) {
					eqTpSzCds.add(arrEqTpSzCds[i]);
				}
				param.put("eqTpSzCds", eqTpSzCds);
				velParam.put("eqTpSzCds", eqTpSzCds);
			}
			
			if(mnrReportINVO.getSCostDtlCd() != null && mnrReportINVO.getSCostDtlCd().length() > 0) {
				List<String> costDtlCds = new ArrayList<String>();
				String[] arrCostDtlCds = mnrReportINVO.getSCostDtlCd().split(",");
				for(int i = 0; i < arrCostDtlCds.length; i++) {
					costDtlCds.add(arrCostDtlCds[i]);
				}
				param.put("costDtlCds", costDtlCds);
				velParam.put("costDtlCds", costDtlCds);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOsearchCleaningContainerInquiryDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CleaningContainerInquiryDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * searchCleaningContainerBKGList
	 * 
	 * @param mnrReportINVO
	 * @return List<CleaningContainerBKGListVO>
	 * @throws DAOException
	 */
	public List<CleaningContainerBKGListVO> searchCleaningContainerBKGList(MnrReportINVO mnrReportINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CleaningContainerBKGListVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrReportINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			String pageNo = mnrReportINVO.getPageNo();
			
			int currentPage=1;
			
			if (pageNo != null && !pageNo.equals("")) {
				currentPage = Integer.parseInt(pageNo);
			}
			
			if (currentPage > 0) {
				int startNo     = EsdEas0367Event.MNR_PAGE_SIZE * (currentPage - 1) + 1;
				int endNo       = EsdEas0367Event.MNR_PAGE_SIZE * currentPage;					
				param.put("start_row", startNo);
				param.put("end_row", endNo);	
			}
			
			if(mnrReportINVO.getSEqTpszCd() != null && mnrReportINVO.getSEqTpszCd().length() > 0) {
				List<String> eqTpSzCds = new ArrayList<String>();
				String[] arrEqTpSzCds = mnrReportINVO.getSEqTpszCd().split(",");
				for(int i = 0; i < arrEqTpSzCds.length; i++) {
					eqTpSzCds.add(arrEqTpSzCds[i]);
				}
				param.put("eqTpSzCds", eqTpSzCds);
				velParam.put("eqTpSzCds", eqTpSzCds);
			}
			
			if(mnrReportINVO.getSCostDtlCd() != null && mnrReportINVO.getSCostDtlCd().length() > 0) {
				List<String> costDtlCds = new ArrayList<String>();
				String[] arrCostDtlCds = mnrReportINVO.getSCostDtlCd().split(",");
				for(int i = 0; i < arrCostDtlCds.length; i++) {
					costDtlCds.add(arrCostDtlCds[i]);
				}
				param.put("costDtlCds", costDtlCds);
				velParam.put("costDtlCds", costDtlCds);
			}
			
			if(mnrReportINVO.getSEqNo() != null && mnrReportINVO.getSEqNo().length() > 0) {
				List<String> eqNos = new ArrayList<String>();
				String[] arrEqNos = mnrReportINVO.getSEqNo().split(",");
				for(int i = 0; i < arrEqNos.length; i++) {
					eqNos.add(arrEqNos[i]);
				}
				param.put("eqNos", eqNos);
				velParam.put("eqNos", eqNos);
			}


			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOsearchCleaningContainerBKGListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CleaningContainerBKGListVO.class);
			
			if(list != null && !list.isEmpty()){
				CleaningContainerBKGListVO vo = list.get(0);
				int maxRows = Integer.parseInt(vo.getTotal());
				vo.setMaxRows(maxRows);
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0362 MNR PRE-AUDIT CRITERION BY ERROR CODE
	 * 
	 * @param mnrPreAuditCriterionVO
	 * @return List<MNRPreAuditCriterionVO>
	 * @throws DAOException
	 */
	public List<MNRPreAuditCriterionVO> searchMNRPreAuditCriterionByErrorCode(MNRPreAuditCriterionVO mnrPreAuditCriterionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MNRPreAuditCriterionVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrPreAuditCriterionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOsearchMNRPreAuditCriterionByErrorCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MNRPreAuditCriterionVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0363 MNR PRE-AUDIT CRITERION BY DIFFERENCE W/O & INV AMT
	 * 
	 * @param mnrPreAuditCriterionVO
	 * @return List<MNRPreAuditCriterionVO>
	 * @throws DAOException
	 */
	public List<MNRPreAuditCriterionVO> searchMNRPreAuditCriterionByDifference(MNRPreAuditCriterionVO mnrPreAuditCriterionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MNRPreAuditCriterionVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrPreAuditCriterionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOsearchMNRPreAuditCriterionByDifferenceRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MNRPreAuditCriterionVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0362 MNR PRE-AUDIT CRITERION BY ERROR CODE
	 * 
	 * @param mnrPreAuditCriterionVO
	 * @param account
	 * @throws DAOException
	 */
	public void deleteMNRPreAuditCriterionByErrorCode(MNRPreAuditCriterionVO mnrPreAuditCriterionVO, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			mnrPreAuditCriterionVO.setOfcCd(account.getOfc_cd());
			mnrPreAuditCriterionVO.setCreUsrId(account.getUsr_id());
			mnrPreAuditCriterionVO.setUpdUsrId(account.getUsr_id());
			Map<String, String> mapVO = mnrPreAuditCriterionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate) new MnrAdvanceAuditDBDAOdeleteMNRPreAuditCriterionByErrorCodeDSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * ESD_EAS_0362 MNR PRE-AUDIT CRITERION BY ERROR CODE
	 * 
	 * @param mnrPreAuditCriterionVO
	 * @param account
	 * @throws DAOException
	 */
	public void insertMNRPreAuditCriterionByErrorCode(MNRPreAuditCriterionVO mnrPreAuditCriterionVO, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			mnrPreAuditCriterionVO.setOfcCd(account.getOfc_cd());
			mnrPreAuditCriterionVO.setCreUsrId(account.getUsr_id());
			mnrPreAuditCriterionVO.setUpdUsrId(account.getUsr_id());
			Map<String, String> mapVO = mnrPreAuditCriterionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate) new MnrAdvanceAuditDBDAOinsertMNRPreAuditCriterionByErrorCodeCSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * ESD_EAS_0362 MNR PRE-AUDIT CRITERION BY ERROR CODE
	 * 
	 * @return String
	 * @param mnrPreAuditCriterionVO
	 * @throws DAOException
	 */
	public String[] searchMNROfficeCodeForValidation(MNRPreAuditCriterionVO mnrPreAuditCriterionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MNRPreAuditCriterionVO> list = null;
		String[] string = new String[5];
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrPreAuditCriterionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOsearchMNROfficeCodeForValidationRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MNRPreAuditCriterionVO.class);
			
			// System.out.println("offce code: " + list.get(0).getOfcCd());
			
			if(list.size() != 0) {
				string[1] = "Y";
				string[3] = "Y";
				if(!"Y".equals(list.get(0).getEas0362())) {
					string[0] = "Y";
				} else {
					string[0] = "N";
				}
				if(!"Y".equals(list.get(0).getEas0363())) {
					string[2] = "Y";
				} else {
					string[2] = "N";
				}
				if(!"Y".equals(list.get(0).getRhqOfcCd())) {
					string[4] = "N";
				} else {
					string[4] = "Y";
				}
			} else {
				string[1] = "N";
				string[3] = "N";
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return string;
	}
	
	/**
	 * ESD_EAS_0362 MNR PRE-AUDIT CRITERION BY ERROR CODE
	 * 
	 * @param mnrPreAuditCriterionVOs
	 * @param account
	 * @throws DAOException
	 */
	public void updateMNRPreAuditCriterionByErrorCode(MNRPreAuditCriterionVO[] mnrPreAuditCriterionVOs, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			for(int i = 0; i < mnrPreAuditCriterionVOs.length; i++) {
				mnrPreAuditCriterionVOs[i].setUptOfcCd(account.getOfc_cd());
				mnrPreAuditCriterionVOs[i].setUpdUsrId(account.getUsr_id());
				Map<String, String> mapVO = mnrPreAuditCriterionVOs[i].getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				new SQLExecuter("").executeUpdate((ISQLTemplate) new MnrAdvanceAuditDBDAOupdateMNRPreAduitCriterionByErrorCodeUSQL(), param, velParam);
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * ESD_EAS_0363 MNR PRE-AUDIT CRITERION BY DIFFERENCE
	 * 
	 * @param mnrPreAuditCriterionVO
	 * @param account
	 * @throws DAOException
	 */
	public void deleteMNRPreAuditCriterionByDifference(MNRPreAuditCriterionVO mnrPreAuditCriterionVO, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			mnrPreAuditCriterionVO.setOfcCd(account.getOfc_cd());
			mnrPreAuditCriterionVO.setCreUsrId(account.getUsr_id());
			mnrPreAuditCriterionVO.setUpdUsrId(account.getUsr_id());
			Map<String, String> mapVO = mnrPreAuditCriterionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate) new MnrAdvanceAuditDBDAOdeleteMNRPreAuditCriterionByDifferenceDSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * ESD_EAS_0363 MNR PRE-AUDIT CRITERION BY DIFFERENCE
	 * 
	 * @param mnrPreAuditCriterionVO
	 * @param account
	 * @throws DAOException
	 */
	public void insertMNRPreAuditCriterionByDifference(MNRPreAuditCriterionVO mnrPreAuditCriterionVO, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			mnrPreAuditCriterionVO.setOfcCd(account.getOfc_cd());
			mnrPreAuditCriterionVO.setCreUsrId(account.getUsr_id());
			mnrPreAuditCriterionVO.setUpdUsrId(account.getUsr_id());
			Map<String, String> mapVO = mnrPreAuditCriterionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate) new MnrAdvanceAuditDBDAOinsertMNRPreAuditCriterionByDifferenceCSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * ESD_EAS_0363 MNR PRE-AUDIT CRITERION BY DIFFERENCE
	 * 
	 * @param mnrPreAuditCriterionVOs
	 * @param account
	 * @throws DAOException
	 */
	public void updateMNRPreAuditCriterionByDifference(MNRPreAuditCriterionVO[] mnrPreAuditCriterionVOs, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			for(int i = 0; i < mnrPreAuditCriterionVOs.length; i++) {
				mnrPreAuditCriterionVOs[i].setUptOfcCd(account.getOfc_cd());
				mnrPreAuditCriterionVOs[i].setUpdUsrId(account.getUsr_id());
				Map<String, String> mapVO = mnrPreAuditCriterionVOs[i].getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				new SQLExecuter("").executeUpdate((ISQLTemplate) new MnrAdvanceAuditDBDAOupdateMNRPreAuditCriterionByDifferenceUSQL(), param, velParam);
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * MNR Invoice에 심사결과 Return
	 * MNR 심사 Logic이 변경될경우 같이 수정해야 함
	 * 
	 * @param String invNo
	 * @param String vndrSeq
	 * @return
	 * @throws DAOException
	 */
	public List<AuditMnrInvoiceVO> auditMnrInvoice(String invNo, String vndrSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<AuditMnrInvoiceVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("inv_no", invNo);
			param.put("vndr_seq", vndrSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOauditMnrInvoiceRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AuditMnrInvoiceVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Transportation Invoice Auto Audit 대상 조회 (배치에서 사용)<br>
	 * 
	 * @param MnrChargeListVO mnrPreAudListVO
	 * @return List<MnrPreAudListVO>
	 * @exception DAOException
	 */
	public List<MnrChargeListVO> searchMnrAutoAudList(MnrChargeListVO mnrPreAudListVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<MnrChargeListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			 Map<String, String> mapVO = mnrPreAudListVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MnrAdvanceAuditDBDAOsearchMnrAutoAudListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, MnrChargeListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	  * Audit History를 저장한다.<br>
	  * 
	  * @param MnrChargeListVO mnrPreAudListVO
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public void addAutoAuditHis(MnrChargeListVO mnrPreAudListVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mnrPreAudListVO != null){
				Map<String, String> mapVO = mnrPreAudListVO.getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate) new MnrAdvanceAuditDBDAOaddAutoAuditHisCSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
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
	  * Auto Audit 내역을 삭제한다.<br>
	  * 
	  * @param MnrChargeListVO mnrPreAudListVO
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public void removeAutoAudit(MnrChargeListVO mnrPreAudListVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mnrPreAudListVO != null){
				Map<String, String> mapVO = mnrPreAudListVO.getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate) new MnrAdvanceAuditDBDAOremoveAutoAuditDSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
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
	  * Auto Audit Detail 내역을 삭제한다.<br>
	  * 
	  * @param MnrChargeListVO mnrPreAudListVO
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public void removeAutoAuditDetail(MnrChargeListVO mnrPreAudListVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mnrPreAudListVO != null){
				Map<String, String> mapVO = mnrPreAudListVO.getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate) new MnrAdvanceAuditDBDAOremoveAutoAuditDetailDSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
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
	  * 실시간 배치 대상을 저장한다.<br>
	  * 
	  * @param MnrChargeListVO mnrChargeListVO
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public void saveReBatchTarget(MnrChargeListVO mnrChargeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mnrChargeListVO != null){
				Map<String, String> mapVO = mnrChargeListVO.getColumnValues();
				param.putAll(mapVO);
				
				//실시간 배치대상에 이미 포함되어 있는지를 검사한다.
				MnrAdvanceAuditDBDAOsearchReBatchTargetCheckRSQL chkSQL = new MnrAdvanceAuditDBDAOsearchReBatchTargetCheckRSQL();
				dbRowset = sqlExe.executeQuery(chkSQL, param, param);
				
				String progFlg = "";
				if(dbRowset.next()){
					progFlg = dbRowset.getString("prog_flg");
					if(progFlg.equals("Y")){
						throw new DAOException((new ErrorHandler("EAS99999",new String[]{"It is already included in batch target."})).getMessage());
					}
				}
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new MnrAdvanceAuditDBDAOsaveReBatchTargetCSQL(), param, param);
				if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	  * Futile Trip Container 조회.<br>
	  * 
	  * @param MnrMovementVO mnrMovementVO
	  * @return List<MnrMovementVO>
	  * @exception DAOException
	  */
	public List<MnrMovementVO> searchMovementList(MnrMovementVO mnrMovementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MnrMovementVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			Map<String, String> mapVO = mnrMovementVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(mnrMovementVO.getCntrTpszCd() != null && mnrMovementVO.getCntrTpszCd().length() > 0) {
				List<String> eqTpSzCds = new ArrayList<String>();
				String[] arrEqTpSzCds = mnrMovementVO.getCntrTpszCd().split(",");
				for(int i = 0; i < arrEqTpSzCds.length; i++) {
					eqTpSzCds.add(arrEqTpSzCds[i]);
				}
				param.put("eqTpSzCds", eqTpSzCds);
				velParam.put("eqTpSzCds", eqTpSzCds);
			}
			
			if(mnrMovementVO.getCntrNo() != null && mnrMovementVO.getCntrNo().length() > 0) {
				List<String> cntrNos = new ArrayList<String>();
				String[] arrCntrNos = mnrMovementVO.getCntrNo().split(",");
				for(int i = 0; i < arrCntrNos.length; i++) {
					cntrNos.add(arrCntrNos[i]);
				}
				param.put("cntrNos", cntrNos);
				velParam.put("cntrNos", cntrNos);
			}
			
			if(mnrMovementVO.getMvmtStsCd() != null && mnrMovementVO.getMvmtStsCd().length() > 0) {
				String mvmtStsCd1 = null;
				String[] arr = mnrMovementVO.getMvmtStsCd().split(",");
				int id_cd = arr.length + 1;
				mvmtStsCd1 = arr[0];
				param.put("mvmt_sts_cd1", mvmtStsCd1);
				velParam.put("mvmt_sts_cd1", mvmtStsCd1);
				
				param.put("id_cnt", id_cd);
				velParam.put("id_cnt", id_cd);
			}


			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MnrAdvanceAuditDBDAOsearchMovementListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MnrMovementVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	  * next JobId 조회.<br>
	  * 
	  * @return String
	  * @exception DAOException
	  */
	public String getMovementEmailSendJobId() throws DAOException {
		DBRowSet dbRowset = null;
		String jobId = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MnrAdvanceAuditDBDAOgetMovementEmailSendJobIdRSQL(), param, velParam);
			if (dbRowset.next()) {
				jobId = dbRowset.getString("JB_ID");
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return jobId;
	}
	
	/**
	  * 배치 파라미터를 저장한다.<br>
	  * 
	  * @param MnrMovementEmailSendHistoryVO mnrMovementEmailSendHistoryVO
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public void insertMovementEmailSendHistory(MnrMovementEmailSendHistoryVO mnrMovementEmailSendHistoryVO) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrMovementEmailSendHistoryVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new MnrAdvanceAuditDBDAOinsertMovementEmailSendHistoryCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
	}
}
