/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeEstimateDBDAO.java
*@FileTitle : Requested Advance Payment
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.15 김진일
* 1.0 Creation
* 
* History
* 2012.02.01 진마리아 CHM-201215859-01 전도금 비용 수정 기능 추가 요청건(spp로부터 입력받는 전도금을 alps 화면을 통해 수정하여 저장 가능하도록)
* 2012.03.09 진마리아 CHM-201216307-01 Canal invoice 화면 변경 및 File download 기능 개발
* 2012.04.09 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가 - file download는 전도금이 아닌 invoice 화면으로 수정
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.basic.CanalTransitFeeEstimateBCImpl;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidOwnerAccountVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeEstDtlByVvdCondVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeEstDtlByVvdVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeHdVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeSumVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS CanalTransitFeeEstimateDBDAO <br>
 * - ALPS-EstimateInvoiceAudit system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jin Ihl
 * @see CanalTransitFeeEstimateBCImpl 참조
 * @since J2EE 1.6
 */
public class CanalTransitFeeEstimateDBDAO extends DBDAOSupport {

	/**
	 * Requested Advanced Payment windows_open
	 * @category VOP_PSO_0018_windows_open
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return List<CanalTzFeeEstDtlByVvdVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CanalTzFeeEstDtlByVvdVO> searchCanalTzFeeEstDtlByVvd(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO)  throws DAOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<CanalTzFeeEstDtlByVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(canalTzFeeEstDtlByVvdCondVO != null){

				Map<String, String> mapVO = canalTzFeeEstDtlByVvdCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("");
            CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeEstDtlByVvdRSQL template = new CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeEstDtlByVvdRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTzFeeEstDtlByVvdVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
	/**
	 * Canal Invoice 조회 처리 
	 * @category VOP_PSO_0017_retrieve
	 * @param CanalTzFeeSumVO canalTzFeeSumVO
	 * @return List<CanalTzFeeSumVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CanalTzFeeSumVO> searchCanalTzFeeSumRpt(
			CanalTzFeeSumVO canalTzFeeSumVO) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<CanalTzFeeSumVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(canalTzFeeSumVO != null){

				Map<String, String> mapVO = canalTzFeeSumVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("");
            CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeSumRptRSQL template = new CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeSumRptRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTzFeeSumVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
//	/**
//	 * CanalTransitFeeEstimateDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
//	 * @param PsoMsaVO psoMsaVO
//	 * @return List<PsoMsaVO>
//	 * @throws DAOException
//	 */
//	 @SuppressWarnings("unchecked")
//	public List<PsoMsaVO> psoMsaVO(PsoMsaVO psoMsaVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<PsoMsaVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(psoMsaVO != null){
//				Map<String, String> mapVO = psoMsaVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CanalTransitFeeEstimateDBDAOPsoMsaVORSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoMsaVO .class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//	}
//	 /**
//	 * 단건의 데이터를 생성한다.<br>
//	 * @param PsoMsaDtlVO vo
//	 * @throws DAOException
//	 */
//	public void addpsoMsaDtlVO(PsoMsaDtlVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int result = sqlExe.executeUpdate((ISQLTemplate)new CanalTransitFeeEstimateDBDAOPsoMsaDtlVOCSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
//	
//	/**
//	 * 단건의 데이터를 갱신한다.<br>
//	 * @param PsoMsaDtlVO vo
//	 * @return int
//	 * @throws DAOException
//	 */
//	public int modifypsoMsaDtlVO(PsoMsaDtlVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new CanalTransitFeeEstimateDBDAOPsoMsaDtlVOUSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//	}
//	
//	/**
//	 * 단건의 데이터를 삭제한다.<br>
//	 * @param PsoMsaDtlVO vo
//	 * @return int
//	 * @throws DAOException
//	 */
//	public int removepsoMsaDtlVO(PsoMsaDtlVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new CanalTransitFeeEstimateDBDAOPsoMsaDtlVODSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//	}
//
//	/**
//	 * 다건의 데이터를 일괄적으로 생성한다.<br>
//	 * @param List<PsoMsaDtlVO> insModels
//	 * @throws DAOException
//	 */
//	public void addpsoMsaDtlVOS(List<PsoMsaDtlVO> insModels) throws DAOException,Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int insCnt[] = null;
//			if(insModels.size() > 0){
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new CanalTransitFeeEstimateDBDAOPsoMsaDtlVOCSQL(), insModels,null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
//	/**
//	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
//	 * @param List<PsoMsaDtlVO> updModels
//	 * @throws DAOException
//	 */
//	public void modifypsoMsaDtlVOS(List<PsoMsaDtlVO> updModels) throws DAOException,Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int updCnt[] = null;
//			if(updModels.size() > 0){
//				updCnt = sqlExe.executeBatch((ISQLTemplate)new CanalTransitFeeEstimateDBDAOPsoMsaDtlVOUSQL(), updModels,null);
//				for(int i = 0; i < updCnt.length; i++){
//					if(updCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
//	
//	/**
//	 * 다건의 데이터를 일괄적으로 삭제한다.<br>
//	 * @param List<PsoMsaDtlVO> delModels
//	 * @throws DAOException
//	 */
//	public void removepsoMsaDtlVOS(List<PsoMsaDtlVO> delModels) throws DAOException,Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int delCnt[] = null;
//			if(delModels.size() > 0){
//				delCnt = sqlExe.executeBatch((ISQLTemplate)new CanalTransitFeeEstimateDBDAOPsoMsaDtlVODSQL(), delModels,null);
//				for(int i = 0; i < delCnt.length; i++){
//					if(delCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
	/**
	 * Requested Advanced Payment Confirm@CLICK
	 * InvoiceNo를 계산하여 가져온다. 
	 * @category VOP_PSO_0018_confirm_click
	 * @param CanalTzFeeHdVO canalTzFeeHdVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchInvoiceSeq(CanalTzFeeHdVO canalTzFeeHdVO) throws DAOException,Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		//List<CanalTzFeeSumVO> list = null;
		String strRet = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (canalTzFeeHdVO != null) {
				Map<String, String> mapVO = canalTzFeeHdVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("");
            CanalTransitFeeEstimateDBDAOsearchInvoiceSeqRSQL template = new CanalTransitFeeEstimateDBDAOsearchInvoiceSeqRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			if(dbRowset.next())
				strRet = dbRowset.getString(1);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTzFeeSumVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return strRet;
	}

	/**
	 * Requested Advanced Payment Reject@CLICK
	 * Canal Invoice Detail 을 삭제한다. 
	 * @category VOP_PSO_0018_reject
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @throws DAOException
	 */
	public void removePsoCnlTzFeeDtl(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(canalTzFeeEstDtlByVvdCondVO != null ){
				ArrayList<CanalTzFeeEstDtlByVvdCondVO> list = new ArrayList<CanalTzFeeEstDtlByVvdCondVO>();
				list.add(canalTzFeeEstDtlByVvdCondVO);
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CanalTransitFeeEstimateDBDAOremovePsoCnlTzFeeDtlDSQL(),list,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	/**
	 * Requested Advanced Payment Reject@CLICK
	 * Canal Invoice Header 내용 을 삭제한다. 
	 * @category VOP_PSO_0018_reject
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @throws DAOException
	 */
	public void removePsoCnlTzFee(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(canalTzFeeEstDtlByVvdCondVO != null ){
				ArrayList<CanalTzFeeEstDtlByVvdCondVO> list = new ArrayList<CanalTzFeeEstDtlByVvdCondVO>();
				list.add(canalTzFeeEstDtlByVvdCondVO);
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CanalTransitFeeEstimateDBDAOremovePsoCnlTzFeeDSQL(),list,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
		
	}
	/**
	 * Requested Advanced Payment Reject@CLICK
	 * Canal Invoice Header 내용 을 삭제한다. 
	 * @category VOP_PSO_0018_reject
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @throws DAOException
	 */
	/*
	public void modifyPsoTargetVvd(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws DAOException,Exception {
		try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int updCnt[] = null;
				if(canalTzFeeEstDtlByVvdCondVO!=null){
					ArrayList<CanalTzFeeEstDtlByVvdCondVO> list = new ArrayList<CanalTzFeeEstDtlByVvdCondVO>();
					list.add(canalTzFeeEstDtlByVvdCondVO);
					updCnt = sqlExe.executeBatch((ISQLTemplate)new CanalTransitFeeEstimateDBDAOmodifyPsoTargetVvdUSQL(), list,null);
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
	}
	*/
	
	/**
	 * Requested Advanced Payment Reject@CLICK
	 * Estimate Target VVD 의 Status 를 Ready 상태로 변경한다. 
	 * @category VOP_PSO_0018_reject_button_click
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @throws DAOException
	 */
	
	public void modifyPsoCnlTzFee(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(canalTzFeeEstDtlByVvdCondVO!=null){
				ArrayList<CanalTzFeeEstDtlByVvdCondVO> list = new ArrayList<CanalTzFeeEstDtlByVvdCondVO>();
				list.add(canalTzFeeEstDtlByVvdCondVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CanalTransitFeeEstimateDBDAOupdatePsoCnlTzFeeUSQL(), list,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	
	}
	/**
	 * Requested Advanced/Invoice Payment Confirm@CLICK
	 * RunTime에서 계산된 Tariff 내역및 Remark 등을 PSO_CNL_TZ_FEE_DTL에 반영한다. 
	 * @category VOP_PSO_0018_0019_ConfirmClick
	 * @param List<AuditDataValidVO> auditDataValidVOs
	 * @throws DAOException
	 */

	public void modifyCanalTzFeeDtl(List<AuditDataValidVO> auditDataValidVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(auditDataValidVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CanalTransitFeeEstimateDBDAOupdateCanalTzFeeDtlUSQL(), auditDataValidVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Invoice Payment Confirm@CLICK
	 * RunTime에서 계산된 Tariff 내역및 Remark 등을 PSO_CNL_TZ_FEE_DTL에 반영한다. 
	 * @category VOP_PSO_0019_ConfirmClick
	 * @param List<AuditDataValidOwnerAccountVO> auditDataValidOwnerAccountVOs
	 * @throws DAOException
	 */

	public void modifyCanalTzFeeDtlOwnerAccount(List<AuditDataValidOwnerAccountVO> auditDataValidOwnerAccountVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(auditDataValidOwnerAccountVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CanalTransitFeeEstimateDBDAOupdateCanalTzFeeDtlUSQL(), auditDataValidOwnerAccountVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * Requested Advanced/Invoice Payment Confirm@CLICK
	 * PSO_CNL_TZ_FEE의 상태 정보를 APProved 상태  반영한다. 
	 * @category VOP_PSO_0018_0019_ConfirmClick
	 * @param List<AuditDataValidVO> auditDataValidVOs
	 * @throws DAOException
	 */	
	public void modifyPsoCnlTzFeeStsCd(List<AuditDataValidVO> auditDataValidVOs) throws DAOException {
		// TODO Auto-generated method stub
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(auditDataValidVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CanalTransitFeeEstimateDBDAOupdatePsoCnlTzFeeStsCdUSQL(), auditDataValidVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CanalTzFeeDtl의 Remark 정보를 갱신한다.
	 * VOP_PSO_0018,0019 Reject 처리에서 사용
	 * @category VOP_PSO_0018_0019_ConfirmClick
	 * @param List<AuditDataValidVO> auditDataValidVOs
	 * @throws DAOException
	 */
	public void modifyRemark(List<AuditDataValidVO> auditDataValidVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(auditDataValidVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CanalTransitFeeEstimateDBDAOmodifyRemarkUSQL(), auditDataValidVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CanalTzFeeDtl의 Remark 정보를 갱신한다.
	 * VOP_PSO_0019 Reject 처리에서 사용(OA REMARK UPDATE)
	 * @category VOP_PSO_0019_ConfirmClick
	 * @param List<AuditDataValidOwnerAccountVO> auditDataValidOwnerAccountVOs
	 * @throws DAOException
	 */
	public void modifyRemarkOwnerAccount(List<AuditDataValidOwnerAccountVO> auditDataValidOwnerAccountVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(auditDataValidOwnerAccountVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CanalTransitFeeEstimateDBDAOmodifyRemarkUSQL(), auditDataValidOwnerAccountVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	



	/**
	 * CanalTzFeeDtl의 Advanced Payment Temp Due Date 조회
	 * @category VOP_PSO_0018_windows_open
	 * @param CanalTzFeeEstDtlByVvdVO canalTzFeeEstDtlByVvdVO
	 * @return String
	 * @throws DAOException
	 */
	public String getTempDueDate(CanalTzFeeEstDtlByVvdVO canalTzFeeEstDtlByVvdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	//	Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> resultMap  = new HashMap<String, Object>();

		try {
		
			param.put("in_dcc_ft_cmnc      	".trim(), canalTzFeeEstDtlByVvdVO.getDueDt());
			param.put("in_dcc_ft_day		".trim(), 1);
			param.put("in_dcc_excl_sat     	".trim(), "Y");
			param.put("in_dcc_excl_sun   	".trim(), "Y");
			param.put("in_dcc_excl_holi    	".trim(), "Y");
			param.put("in_z_pol_cnt_cd     	".trim(), "KR");
			param.put("in_z_pol_rgn_cd     	".trim(), "");
			param.put("in_z_pol_state_cd	".trim(), "");
			param.put("in_z_pol_loc   		".trim(), "");

			param.put("o_ft_total_day   ".trim(), 0);
			param.put("o_dcc_ft_cmnc    ".trim(), canalTzFeeEstDtlByVvdVO.getDueDt());
//			param.put("msg_cd          	".trim(), "");

			resultMap = new SQLExecuter("PSO_HJSBAT").executeSP((ISQLTemplate)new CanalTransitFeeEstimateDBDAOgetDueDateRSQL(), param, null);
			String oFtTotalDay = (String) resultMap.get("o_ft_total_day");
			String oDccFtCmnc = (String) resultMap.get("o_dcc_ft_cmnc");
			String msgCd = (String) resultMap.get("msg_cd");
		
			log.debug("\n ======================================================="
			+"\n  getDueDate procedure Call       "
			+"\n  param:"+param.toString()
			
			+"\n  o_ft_total_day:["+oFtTotalDay+"]"
			+"\n  o_dcc_ft_cmnc	:["+oDccFtCmnc+"]"
			+"\n  msg_cd:      	["+msgCd+"]"
			+"\n  resultMap:    ["+resultMap.toString()+"]"
			+"\n =======================================================");

			return oDccFtCmnc;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * CanalTzFeeDtl의 Advanced Payment Due Date 조회
	 * @category VOP_PSO_0018_windows_open
	 * @param CanalTzFeeEstDtlByVvdVO canalTzFeeEstDtlByVvdVO
	 * @return String
	 * @throws DAOException
	 */
	public String getDueDate(CanalTzFeeEstDtlByVvdVO canalTzFeeEstDtlByVvdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> resultMap  = new HashMap<String, Object>();

		try {
	
			param.put("in_dcc_ft_cmnc      	".trim(), canalTzFeeEstDtlByVvdVO.getDueDt());
			param.put("in_dcc_ft_day		".trim(), 1);
			param.put("in_dcc_excl_sat     	".trim(), "Y");
			param.put("in_dcc_excl_sun   	".trim(), "Y");
			param.put("in_dcc_excl_holi    	".trim(), "Y");
			param.put("in_z_pol_cnt_cd     	".trim(), "US");
			param.put("in_z_pol_rgn_cd     	".trim(), "");
			param.put("in_z_pol_state_cd	".trim(), "NY");
			param.put("in_z_pol_loc   		".trim(), "");

			param.put("o_ft_total_day   ".trim(), 0);
			param.put("o_dcc_ft_cmnc    ".trim(), canalTzFeeEstDtlByVvdVO.getDueDt());
//			param.put("msg_cd          	".trim(), "");
 
	
			resultMap = new SQLExecuter("PSO_HJSBAT").executeSP((ISQLTemplate)new CanalTransitFeeEstimateDBDAOgetDueDateRSQL(), param, null);
			String oFtTotalDay = (String) resultMap.get("o_ft_total_day");
			String oDccFtCmnc = (String) resultMap.get("o_dcc_ft_cmnc");
			String msgCd = (String) resultMap.get("msg_cd");
	
			log.debug("\n ======================================================="
					+"\n  getDueDate procedure Call       "
					+"\n  param:"+param.toString()
		
					+"\n  o_ft_total_day:["+oFtTotalDay+"]"
					+"\n  o_dcc_ft_cmnc	:["+oDccFtCmnc+"]"
					+"\n  msg_cd:      	["+msgCd+"]"
					+"\n  resultMap:    ["+resultMap.toString()+"]"
					+"\n =======================================================");

			return oDccFtCmnc;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
	 * CanalTzFeeDtl의 Rqst Amt, Rmk 정보를 갱신한다.
	 * @category VOP_PSO_0018_SaveClick
	 * @param List<AuditDataValidVO> auditDataValidVOs
	 * @throws DAOException
	 */
	public void modifyCanalTzFeeRqstAmt(List<AuditDataValidVO> auditDataValidVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(auditDataValidVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CanalTransitFeeEstimateDBDAOModifyCanalTzFeeRqstAmtUSQL(), auditDataValidVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}