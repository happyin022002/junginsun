/*=========================================================
 *Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeBalanceDBDAO.java
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.20 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.basic.CanalTransitFeeBalanceBCImpl;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.BalDiffAcctDtlVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.BalDiffAcctMstVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.BalDiffAcctVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.CanalTzFeeBalDtlVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.CanalTzFeeBalVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.GlIfDataThisMonVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.GlIfDataTtlVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PsoMsaVO;


/**
 * ALPS CanalTransitFeeBalanceDBDAO <br>
 * - ALPS-EstimateInvoiceAudit system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jin Ihl
 * @see CanalTransitFeeBalanceBCImpl 참조
 * @since J2EE 1.4
 */
public class CanalTransitFeeBalanceDBDAO extends DBDAOSupport {

	/**
	 * VOP_PSO_0020의 첫번째 탭화면 조회 Statement Of Balance정보
	 * @param canalTzFeeBalVO
	 * @return List<CanalTzFeeBalVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CanalTzFeeBalVO> searchCanalTzFeeBalSum(CanalTzFeeBalVO canalTzFeeBalVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CanalTzFeeBalVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(canalTzFeeBalVO != null){
				Map<String, String> mapVO = canalTzFeeBalVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CanalTransitFeeBalanceBCDBDAOsearchCanalTzFeeBalSumRSQL template = new CanalTransitFeeBalanceBCDBDAOsearchCanalTzFeeBalSumRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTzFeeBalVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

	/**PSO_MSA를 수정한다.
	 * @param List<CanalTzFeeBalVO> canalTzFeeBalVOs
	 */
	public void modifyPsoMsa(List<CanalTzFeeBalVO> canalTzFeeBalVOs) throws DAOException,Exception {
		try {
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CanalTransitFeeBalanceBCDBDAOmodifyPsoMsaUSQL template = new CanalTransitFeeBalanceBCDBDAOmodifyPsoMsaUSQL();
			int updCnt[] = null;
			if(canalTzFeeBalVOs.size() > 0){
				updCnt = sqlExe.executeBatch(template, canalTzFeeBalVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * 조회 조건으로 다건의 데이터 조회
	 * VOP_PSO-0020-2 Details of Remittance 조회 DAO처리 
	 * @param CanalTzFeeBalDtlVO canalTzFeeBalDtlVO
	 * @return List<CanalTzFeeBalDtlVO>
	 */
	@SuppressWarnings("unchecked")
	public List<CanalTzFeeBalDtlVO> searchCanalTzFeeBalDtl(CanalTzFeeBalDtlVO canalTzFeeBalDtlVO)  throws DAOException {
		DBRowSet dbRowset = null;
		List<CanalTzFeeBalDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(canalTzFeeBalDtlVO != null){
				Map<String, String> mapVO = canalTzFeeBalDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CanalTransitFeeBalanceBCDBDAOsearchCanalTzFeeBalDtlRSQL template = new CanalTransitFeeBalanceBCDBDAOsearchCanalTzFeeBalDtlRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTzFeeBalDtlVO .class);
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
	 * G/L Data를 조회합니다.
	 * @category VOP_PSO-0031 Top Grid 조회 
	 * @param PsoMsaVO psoMsaVO
	 * @return List<GlIfDataThisMonVO>
	 */
	@SuppressWarnings("unchecked")
	public List<GlIfDataThisMonVO> searchGlifDateByMon(PsoMsaVO psoMsaVO)  throws DAOException {
		DBRowSet dbRowset = null;
		List<GlIfDataThisMonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(psoMsaVO != null){
				Map<String, String> mapVO = psoMsaVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CanalTransitFeeBalanceDBDAOSearchGLRSQL template = new CanalTransitFeeBalanceDBDAOSearchGLRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, GlIfDataThisMonVO .class);
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
	 * G/L Summay Data를 조회합니다.
	 * @category VOP_PSO-0031 Bottom Grid 조회 (Summay) 
	 * @param PsoMsaVO psoMsaVO
	 * @return List<GlIfDataTtlVO>
	 */
	@SuppressWarnings("unchecked")
	public List<GlIfDataTtlVO> searchGlifDateByMonSum(PsoMsaVO psoMsaVO)  throws DAOException {
		DBRowSet dbRowset = null;
		List<GlIfDataTtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(psoMsaVO != null){
				Map<String, String> mapVO = psoMsaVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CanalTransitFeeBalanceDBDAOSearchGLSummaryRSQL template = new CanalTransitFeeBalanceDBDAOSearchGLSummaryRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, GlIfDataTtlVO .class);
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
	 * Balance Diff. Account Data를 조회합니다.
	 * @category VOP_PSO-0032 Top Grid 조회 
	 * @param  BalDiffAcctVO balDiffAcctVO
	 * @return List<BalDiffAcctMstVO>
	 */
	@SuppressWarnings("unchecked")
	public List<BalDiffAcctMstVO> searchBalDiffAcct(BalDiffAcctVO balDiffAcctVO)  throws DAOException {
		DBRowSet dbRowset = null;
		List<BalDiffAcctMstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(balDiffAcctVO != null){
				Map<String, String> mapVO = balDiffAcctVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CanalTransitFeeBalanceDBDAOSearchBalDiffAcctSummayRSQL template = new CanalTransitFeeBalanceDBDAOSearchBalDiffAcctSummayRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BalDiffAcctMstVO.class);
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
	 * Balance Diff. Account Data를 조회합니다.
	 * @category VOP_PSO-0032 Bottom Grid 조회 (Summay) 
	 * @param  BalDiffAcctVO balDiffAcctVO
	 * @return List<BalDiffAcctDtlVO>
	 */
	@SuppressWarnings("unchecked")
	public List<BalDiffAcctDtlVO> searchBalDiffAcctDtl(BalDiffAcctVO balDiffAcctVO)  throws DAOException {
		DBRowSet dbRowset = null;
		List<BalDiffAcctDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(balDiffAcctVO != null){
				Map<String, String> mapVO = balDiffAcctVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			CanalTransitFeeBalanceDBDAOSearchBalDiffAcctDtlRSQL template = new CanalTransitFeeBalanceDBDAOSearchBalDiffAcctDtlRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BalDiffAcctDtlVO.class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
}
