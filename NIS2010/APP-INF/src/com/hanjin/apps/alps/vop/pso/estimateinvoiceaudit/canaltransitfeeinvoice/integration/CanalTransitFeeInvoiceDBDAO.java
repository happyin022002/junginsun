/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeInvoiceDBDAO.java
*@FileTitle : Requested Actual Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.23 김진일
* 1.0 Creation
* 
* History
* 2012.03.22 진마리아 CHM-201216307-01 Canal invoice 화면 변경 및 File download 기능 개발
* 2012.04.09 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가 - file download는 전도금이 아닌 invoice 화면으로 수정
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.basic.CanalTransitFeeInvoiceBCImpl;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.AtchFileVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlCondVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlByVvdOwnerAccountVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeSummaryVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzOwnerAccountInterfaceVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration.PortTariffMgtBCDBDAOAddPsoTrfAtchFileCSQL;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration.PortTariffMgtBCDBDAORemovePsoTrfAtchFileDSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PsoCnlTzAtchFileVO;
import com.hanjin.syscommon.common.table.PsoTrfAtchFileVO;


/**
 * ALPS CanalTransitFeeInvoiceDBDAO <br>
 * - ALPS-EstimateInvoiceAudit system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jin Ihl
 * @see CanalTransitFeeInvoiceBCImpl 참조
 * @since J2EE 1.6
 */
public class CanalTransitFeeInvoiceDBDAO extends DBDAOSupport {

	/**
	 * Requested Actual Invoice WindowOpen이벤트 조회 : SPP 로 분터 Requested Actual Invoice 를 조회한다
	 * @category VOP_PSO_0019_windowOpen
	 * @param CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO
	 * @return List<CanalTzFeeInvDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CanalTzFeeInvDtlVO> searchCanalTzFeeInvByVvd(
			CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<CanalTzFeeInvDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(canalTzFeeInvDtlCondVO != null){
				Map<String, String> mapVO = canalTzFeeInvDtlCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeInvDtlByVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTzFeeInvDtlVO .class);
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
	 * Requested Actual Invoice WindowOpen이벤트 조회 : SPP 로 분터 Requested Actual Invoice (OA비용) 를 조회한다
	 * @category VOP_PSO_0019_windowOpen
	 * @param CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO
	 * @return List<CanalTzFeeInvDtlByVvdOwnerAccountVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CanalTzFeeInvDtlByVvdOwnerAccountVO> searchCanalTzFeeInvByVvdOwnerAccount(
			CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<CanalTzFeeInvDtlByVvdOwnerAccountVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(canalTzFeeInvDtlCondVO != null){
				Map<String, String> mapVO = canalTzFeeInvDtlCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeInvDtlByVvdOwnerAccountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTzFeeInvDtlByVvdOwnerAccountVO .class);
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
	 * Requested Actual Invoice WindowOpen이벤트 조회 :summary data 조회
	 * @category VOP_PSO_0019_windowOpen
	 * @param CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO
	 * @return List<CanalTzFeeSummaryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CanalTzFeeSummaryVO> searchCanalTzFeeSummary(
			CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<CanalTzFeeSummaryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(canalTzFeeInvDtlCondVO != null){
				Map<String, String> mapVO = canalTzFeeInvDtlCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeSummaryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTzFeeSummaryVO .class);
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
	 * 
	 * @category VOP_PSO_0215_SaveButtonClick (lsh)
	 * @param  List<PsoCnlTzAtchFileVO> psoTrfAtchFileVOs
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void addAtchFile(List<PsoCnlTzAtchFileVO> psoTrfAtchFileVOs)  throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(psoTrfAtchFileVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CanalTransitFeeInvoiceDBDAOaddAtchFileCSQL(), psoTrfAtchFileVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 
	 * @category VOP_PSO_0215_SaveButtonClick (lsh)
	 * @param List<PsoCnlTzAtchFileVO> psoTrfAtchFileVOs
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void removeAtchFile(List<PsoCnlTzAtchFileVO> psoTrfAtchFileVOs)  throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(psoTrfAtchFileVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CanalTransitFeeInvoiceDBDAOremoveAtchFileDSQL(), psoTrfAtchFileVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Canal Invoice 조회 처리 
	 * @category FMS모듈에서 OA 비용에 대해 조회시
	 * @param String vvd
	 * @return List<CanalTzOwnerAccountInterfaceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	
	public List<CanalTzOwnerAccountInterfaceVO> searchCanalTzOwnerAccountInterface(String vvd) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<CanalTzOwnerAccountInterfaceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvd != null){

				param.put("vvd", vvd);
				velParam.put("vvd", vvd);
			
			}
			
            SQLExecuter sqlExe = new SQLExecuter("");
            CanalTransitFeeInvoiceBCDBDAOsearchCanalTzOwnerAccountInterfaceRSQL template = new CanalTransitFeeInvoiceBCDBDAOsearchCanalTzOwnerAccountInterfaceRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTzOwnerAccountInterfaceVO .class);
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
	 *Requested Actual Invoice 관련 atch file retrieve
	 * @category VOP_PSO_0215_windows_open
	 * @param AtchFileVO atchFileVO
	 * @return List<AtchFileVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AtchFileVO> searchAtchFileList(AtchFileVO atchFileVO)  throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<AtchFileVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(atchFileVO != null){
				Map<String, String> mapVO = atchFileVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("");
            CanalTransitFeeInvoiceDBDAOSearchAtchFileListRSQL template = new CanalTransitFeeInvoiceDBDAOSearchAtchFileListRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AtchFileVO .class);
		}catch(SQLException ex){
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
}