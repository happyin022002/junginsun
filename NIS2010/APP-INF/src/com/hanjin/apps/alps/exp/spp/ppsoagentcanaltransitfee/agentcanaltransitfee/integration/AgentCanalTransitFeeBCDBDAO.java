/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgentCanalTransitFeeBCDBDAO.java
*@FileTitle : Requested Advance Payment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.07.15 김성광
* 1.0 Creation
*  
* History
* 2012.02.17 박연진 CHM-201216307 SPP 및 PSO내 Canal invoice 화면 변경 및 File upload 기능 개발 
=========================================================*/
package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration.RateMgtDBDAOremoveAGMTCostDTLGRPDataDSQL;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration.RateMgtDBDAOremoveAGMTHDRGRPDataDSQL;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.basic.AgentCanalTransitFeeBCImpl;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTransitScheduleVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzAllowanceTEUVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzBkgVvdVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeEstDtlByVvdCondVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeEstDtlByVvdVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeInvDtlByVvdVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeSumVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzInvAllowanceTEUVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzVVDListVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaBalVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaDisbVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaRemVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.PsoCanalInvAttachFileVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PsoCnlTzAtchFileVO;
import com.hanjin.syscommon.common.table.PsoCnlTzFeeDtlVO;
import com.hanjin.syscommon.common.table.PsoCnlTzFeeVO;
import com.hanjin.syscommon.common.table.PsoMsaDtlVO;
import com.hanjin.syscommon.common.table.PsoMsaVO;
import com.hanjin.syscommon.common.table.PsoTgtVvdVO;


/**
 * ALPS AgentCanalTransitFeeBCDBDAO <br>
 * - ALPS-AgentCanalTransitFee system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Seong Kwang
 * @see AgentCanalTransitFeeBCImpl 참조
 * @since J2EE 1.6
 */
public class AgentCanalTransitFeeBCDBDAO extends DBDAOSupport {

	/**
	 * Canal Invoice 조회 처리 <br>
	 * 
	 * @param CanalTzFeeSumVO canalTzFeeSumVO
	 * @return List<CanalTzFeeSumVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CanalTzFeeSumVO> searchCanalTzFeeSumRpt(
			CanalTzFeeSumVO canalTzFeeSumVO) throws DAOException {
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
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            AgentCanalTransitFeeBCDBDAOsearchCanalTzFeeSumRptRSQL template = new AgentCanalTransitFeeBCDBDAOsearchCanalTzFeeSumRptRSQL();
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
	
	/**
	 * VVD List 조회 처리 <br>
	 * 
	 * @param CanalTzVVDListVO canalTzVVDListVO
	 * @return List<CanalTzVVDListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CanalTzVVDListVO> searchCanalTzVVDList(
			CanalTzVVDListVO canalTzVVDListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CanalTzVVDListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(canalTzVVDListVO != null){

				Map<String, String> mapVO = canalTzVVDListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            AgentCanalTransitFeeBCDBDAOsearchCanalTzVVDListRSQL template = new AgentCanalTransitFeeBCDBDAOsearchCanalTzVVDListRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTzVVDListVO .class);
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
	 * Requested Advanced Payment windows_open<br>
	 *
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return List<CanalTzFeeEstDtlByVvdVO>
	 * @exception DAOException 
	 */	
	@SuppressWarnings("unchecked")
	public List<CanalTzFeeEstDtlByVvdVO> searchCanalTzFeeEstDtlByVvd(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO)  throws DAOException {
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
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            AgentCanalTransitFeeBCDBDAOsearchCanalTzFeeEstDtlByVvdRSQL template = new AgentCanalTransitFeeBCDBDAOsearchCanalTzFeeEstDtlByVvdRSQL();
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
	 * Requested Advanced Payment windows_open Allowance TEU<br>
	 * 
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return CanalTzAllowanceTEUVO
	 * @exception DAOException 
	 */	
	 @SuppressWarnings("unchecked")
	public CanalTzAllowanceTEUVO searchCanalTzAllowanceTEU(CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CanalTzAllowanceTEUVO> list = null;
		CanalTzAllowanceTEUVO canalTzAllowanceTEUVO = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgentCanalTransitFeeBCDBDAOsearchCanalTzAllowanceTEURSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTzAllowanceTEUVO.class);
            
            if (list != null && !list.isEmpty()) {
            	canalTzAllowanceTEUVO = (CanalTzAllowanceTEUVO)list.get(0);
            }
		}catch(SQLException se){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return canalTzAllowanceTEUVO;
	}
	
	/**
	 * 저장 전 데이터가 존재하는지 여부 체크 : PSO_CNL_TZ_FEE<br>
	 * EXP_SPP_0002_save, EXP_SPP_0003_save 시 PSO_CNL_TZ_FEE에 데이터가 존재하는지 체크하는 DAO처리 <br>
	 * 
	 * @param PsoCnlTzFeeVO psoCnlTzFeeVO
	 * @exception DAOException
	 */		
    @SuppressWarnings("unchecked")
     public void deletePsoCnlTzFee(PsoCnlTzFeeVO psoCnlTzFeeVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{ 
			if(psoCnlTzFeeVO != null){
				Map<String, String> mapVO = psoCnlTzFeeVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	        	
			SQLExecuter sqlExe = new SQLExecuter("");  
			sqlExe.executeUpdate((ISQLTemplate)new AgentCanalTransitFeeBCDBDAOdeletePsoCnlTzFeeDSQL(), param, velParam);
			
			
        }catch(SQLException ex){
        	//log.error(ex.getMessage(),ex);
        	throw new DAOException(ex.getMessage(), ex);
        }catch(Exception ex){
        	//log.error(ex.getMessage(),ex);
        	throw new DAOException(ex.getMessage(), ex);
        }         

     }
    
	/**
	 * CanalTzFee by VVD Save : PSO_CNL_TZ_FEE<br>
	 * 
	 * @param PsoCnlTzFeeVO psoCnlTzFeeVO
	 * @exception DAOException 
	 */
	@SuppressWarnings("unchecked")
	public void addPsoCnlTzFee(PsoCnlTzFeeVO psoCnlTzFeeVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
	        //query parameter
	        Map<String, String> param = psoCnlTzFeeVO.getColumnValues();				
			sqlExe.executeUpdate((ISQLTemplate) new AgentCanalTransitFeeBCDBDAOaddPsoCnlTzFeeCSQL(), param, null);
			
		} catch (SQLException ex) { 
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * 저장 전 데이터가 존재하는지 여부 체크 : PSO_CNL_TZ_FEE_DTL<br>
	 * EXP_SPP_0002_save, EXP_SPP_0003_save 시 PSO_CNL_TZ_FEE_DTL에 데이터가 존재하는지 체크하는 DAO처리 <br>
	 * 
	 * @param PsoCnlTzFeeDtlVO psoCnlTzFeeDtlVO
	 * @exception DAOException 
	 */		
    @SuppressWarnings("unchecked")
     public void deletePsoCnlTzFeeDtl(PsoCnlTzFeeDtlVO psoCnlTzFeeDtlVO) throws DAOException {
       
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{ 
			if(psoCnlTzFeeDtlVO != null){
				Map<String, String> mapVO = psoCnlTzFeeDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	        	
			SQLExecuter sqlExe = new SQLExecuter("");  
			sqlExe.executeUpdate((ISQLTemplate)new AgentCanalTransitFeeBCDBDAOdeletePsoCnlTzFeeDtlDSQL(), param, velParam);
           
        }catch(SQLException ex){
        	//log.error(ex.getMessage(),ex);
        	throw new DAOException(ex.getMessage(), ex);
        }catch(Exception ex){
        	//log.error(ex.getMessage(),ex);
        	throw new DAOException(ex.getMessage(), ex);
        }         

     }
    
	/**
	 * CanalTzFee by VVD Save : PSO_CNL_TZ_FEE_DTL<br>
	 *
	 * @param PsoCnlTzFeeDtlVO psoCnlTzFeeDtlVO
	 * @exception DAOException 
	 */
	@SuppressWarnings("unchecked")
	public void addPsoCnlTzFeeDtl(PsoCnlTzFeeDtlVO psoCnlTzFeeDtlVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
	        //query parameter
	        Map<String, String> param = psoCnlTzFeeDtlVO.getColumnValues();				
			sqlExe.executeUpdate((ISQLTemplate) new AgentCanalTransitFeeBCDBDAOaddPsoCnlTzFeeDtlCSQL(), param, null);
			
		} catch (SQLException ex) { 
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	/**
	 * CanalTzFee by VVD 저장 : PSO_CNL_TZ_FEE<br>
	 * 
	 * @param PsoCnlTzFeeVO psoCnlTzFeeVO
	 * @exception DAOException 
	 */
	@SuppressWarnings("unchecked")
	public void modifyPsoCnlTzFee(PsoCnlTzFeeVO psoCnlTzFeeVO) throws DAOException, Exception {
		
		//query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try { 
			 Map<String, String> mapVO = psoCnlTzFeeVO.getColumnValues();
			  
			 param.putAll(mapVO);
			 velParam.putAll(mapVO); 
			 
			 SQLExecuter sqlExe = new SQLExecuter("");
			 int result = sqlExe.executeUpdate((ISQLTemplate)new AgentCanalTransitFeeBCDBDAOmodifyPsoCnlTzFeeUSQL(), param, velParam);
			 if(result == Statement.EXECUTE_FAILED)   
				 throw new DAOException("Fail to AgentCanalTransitFeeBCDBDAOmodifyPsoCnlTzFeeUSQL");
		 } catch (SQLException se) {   
			 log.error(se.getMessage(),se); 
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){    
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
	}	 
	
	/**
	 * Request Actual Invoice windows_open<br>
	 * 
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return List<CanalTzFeeInvDtlByVvdVO>
	 * @exception DAOException 
	 */	
	@SuppressWarnings("unchecked")
	public List<CanalTzFeeInvDtlByVvdVO> searchCanalTzFeeInvDtlByVvd(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO)  throws DAOException {
		DBRowSet dbRowset = null;
		List<CanalTzFeeInvDtlByVvdVO> list = null;
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
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            AgentCanalTransitFeeBCDBDAOsearchCanalTzFeeInvDtlByVvdRSQL template = new AgentCanalTransitFeeBCDBDAOsearchCanalTzFeeInvDtlByVvdRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTzFeeInvDtlByVvdVO .class);
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
	 * Request Actual Invoice windows_open Allowance TEU<br>
	 * 
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return CanalTzInvAllowanceTEUVO
	 * @exception DAOException 
	 */	
	 @SuppressWarnings("unchecked")
	public CanalTzInvAllowanceTEUVO searchCanalTzInvAllowanceTEU(CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CanalTzInvAllowanceTEUVO> list = null;
		CanalTzInvAllowanceTEUVO canalTzInvAllowanceTEUVO = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgentCanalTransitFeeBCDBDAOsearchCanalTzInvAllowanceTEURSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTzInvAllowanceTEUVO.class);
            
            if (list != null && !list.isEmpty()) {
            	canalTzInvAllowanceTEUVO = (CanalTzInvAllowanceTEUVO)list.get(0);
            }
		}catch(SQLException se){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return canalTzInvAllowanceTEUVO;
	}	
	 
		/**
		 * MSA Balance 조회<br>
		 * 
		 * @param MsaBalVO msaBalVO
		 * @return List<MsaBalVO>
		 * @exception DAOException 
		 */	
		@SuppressWarnings("unchecked")
		public List<MsaBalVO> searchMsaBal(MsaBalVO msaBalVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<MsaBalVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(msaBalVO != null){
					Map<String, String> mapVO = msaBalVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	            AgentCanalTransitFeeBCDBDAOsearchMsaBalRSQL template = new AgentCanalTransitFeeBCDBDAOsearchMsaBalRSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, MsaBalVO .class);
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
		 * 저장 전 데이터가 존재시 삭제처리 : PSO_MSA<br>
		 * EXP_SPP_0004 Save 시 MSA 기존데이타 삭제처리 DAO <br>
		 * 
		 * @param PsoMsaVO psoMsaVO
		 * @exception DAOException 
		 */		
	    @SuppressWarnings("unchecked")
	     public void deletePsoMsa(PsoMsaVO psoMsaVO) throws DAOException {
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        
	        
	        try{ 
				if(psoMsaVO != null){
					Map<String, String> mapVO = psoMsaVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}	        	
				SQLExecuter sqlExe = new SQLExecuter("");  
				sqlExe.executeUpdate((ISQLTemplate)new AgentCanalTransitFeeBCDBDAOdeletePsoMsaDSQL(), param, velParam);
	           
	        }catch(SQLException ex){
	        	//log.error(ex.getMessage(),ex);
	        	throw new DAOException(ex.getMessage(), ex);
	        }catch(Exception ex){
	        	//log.error(ex.getMessage(),ex);
	        	throw new DAOException(ex.getMessage(), ex);
	        }         

	     } 
	    
		/**
		 * Msa Save : PSO_MSA<br>
		 * 
		 * @param PsoMsaVO psoMsaVO
		 * @exception DAOException 
		 */
		@SuppressWarnings("unchecked")
		public void addPsoMsa(PsoMsaVO psoMsaVO) throws DAOException, Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
		        //query parameter
		        Map<String, String> param = psoMsaVO.getColumnValues();				
				sqlExe.executeUpdate((ISQLTemplate) new AgentCanalTransitFeeBCDBDAOaddPsoMsaCSQL(), param, null);
				
			} catch (SQLException ex) { 
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			} catch (Exception ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}	
		
		/**
		 * Msa Save : PSO_MSA<br>
		 * 
		 * @param PsoMsaVO psoMsaVO
		 * @exception DAOException 
		 */
		@SuppressWarnings("unchecked")
		public void modifyPsoMsa(PsoMsaVO psoMsaVO) throws DAOException, Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
		        //query parameter
		        Map<String, String> param = psoMsaVO.getColumnValues();					
				sqlExe.executeUpdate((ISQLTemplate) new AgentCanalTransitFeeBCDBDAOmodifyPsoMsaUSQL(), param, null);

			} catch (SQLException ex) { 
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			} catch (Exception ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}		
	    
		
		/**
		 * 저장 전 데이터가 존재시 삭제처리 : PSO_MSA_DTL<br>
		 * EXP_SPP_0004 Save 시 MSA Detail 데이터가 존재시 삭제처리 DAO <br>
		 * 
		 * @param PsoMsaDtlVO psoMsaDtlVO
		 * @exception DAOException
		 */		
	    @SuppressWarnings("unchecked")
	     public void deletePsoMsaDtl(PsoMsaDtlVO psoMsaDtlVO) throws DAOException {
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        
	        try{ 
				if(psoMsaDtlVO != null){
					Map<String, String> mapVO = psoMsaDtlVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}	        	
				SQLExecuter sqlExe = new SQLExecuter("");  
				sqlExe.executeUpdate((ISQLTemplate)new AgentCanalTransitFeeBCDBDAOdeletePsoMsaDtlDSQL(), param, velParam);
	           
	        }catch(SQLException ex){
	        	//log.error(ex.getMessage(),ex);
	        	throw new DAOException(ex.getMessage(), ex);
	        }catch(Exception ex){
	        	//log.error(ex.getMessage(),ex);
	        	throw new DAOException(ex.getMessage(), ex);
	        }         

	     } 
	    
		/**
		 * Msa Save : PSO_MSA_DTL<br>
		 * 
		 * @param PsoMsaDtlVO psoMsaDtlVO
		 * @exception DAOException 
		 */
		@SuppressWarnings("unchecked")
		public void addPsoMsaDtl(PsoMsaDtlVO psoMsaDtlVO) throws DAOException, Exception {
			
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
		        //query parameter
		        Map<String, String> param = psoMsaDtlVO.getColumnValues();	
				sqlExe.executeUpdate((ISQLTemplate) new AgentCanalTransitFeeBCDBDAOaddPsoMsaDtlCSQL(), param, null);

			} catch (SQLException ex) { 
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			} catch (Exception ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}	
		
		/**
		 * MSA Remittance 조회<br>
		 *
		 * @param MsaRemVO msaRemVO
		 * @return List<MsaRemVO>
		 * @exception DAOException 
		 */	
		@SuppressWarnings("unchecked")
		public List<MsaRemVO> searchMsaRem(MsaRemVO msaRemVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<MsaRemVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(msaRemVO != null){
					Map<String, String> mapVO = msaRemVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	            AgentCanalTransitFeeBCDBDAOsearchMsaRemRSQL template = new AgentCanalTransitFeeBCDBDAOsearchMsaRemRSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, MsaRemVO .class);
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
		 * MSA Disbursement 조회<br>
		 * 
		 * @param MsaDisbVO msaDisbVO
		 * @return List<MsaDisbVO>
		 * @exception DAOException 
		 */	
		@SuppressWarnings("unchecked")
		public List<MsaDisbVO> searchMsaDisb(MsaDisbVO msaDisbVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<MsaDisbVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(msaDisbVO != null){
					Map<String, String> mapVO = msaDisbVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	            AgentCanalTransitFeeBCDBDAOsearchMsaDisbRSQL template = new AgentCanalTransitFeeBCDBDAOsearchMsaDisbRSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, MsaDisbVO .class);
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
		 * Canal booking status for Panama 전체 건수 조회<br>
		 * 
		 * @param CanalTzBkgVvdVO canalTzBkgVvdVO
		 * @return int
		 * @throws DAOException
		 */
		public int searchCanalTzBkgVvdCountData(CanalTzBkgVvdVO canalTzBkgVvdVO) throws DAOException {
			int cnt  =0;
	        DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	        
	        try {
				if(canalTzBkgVvdVO != null){
					Map<String, String> mapVO = canalTzBkgVvdVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgentCanalTransitFeeBCDBDAOsearchCanalTzBkgVvdCountDataRSQL(), param, velParam);	
		    	if(dbRowset.next()) {
		    		cnt = dbRowset.getInt("CNT");
		    	}
			}catch(SQLException ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
				
			return cnt;
		}		
		
		/**
		 * Canal booking status for Panama 조회<br>
		 * 
		 * @param CanalTzBkgVvdVO canalTzBkgVvdVO
		 * @return List<CanalTzBkgVvdVO>
		 * @exception DAOException 
		 */	
		@SuppressWarnings("unchecked")
		public List<CanalTzBkgVvdVO> searchCanalTzBkgVvd(CanalTzBkgVvdVO canalTzBkgVvdVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CanalTzBkgVvdVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(canalTzBkgVvdVO != null){
					Map<String, String> mapVO = canalTzBkgVvdVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	            AgentCanalTransitFeeBCDBDAOsearchCanalTzBkgVvdRSQL template = new AgentCanalTransitFeeBCDBDAOsearchCanalTzBkgVvdRSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTzBkgVvdVO .class);
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
		 * Canal booking status for Panama Save 처리<br>
		 * 
		 * @param List<PsoTgtVvdVO> psoTgtVvdVO
		 * @exception DAOException 
		 */
		@SuppressWarnings("unchecked")
		public void modifyPsoTgtVvd(List<PsoTgtVvdVO> psoTgtVvdVO) throws DAOException, Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (psoTgtVvdVO.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate) new AgentCanalTransitFeeBCDBDAOmodifyPsoTgtVvdUSQL(), psoTgtVvdVO, null);
					for (int i = 0; i < insCnt.length; i++) {
						if (insCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException ex) { 
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			} catch (Exception ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}		
	    
		/**
		 * Msa 처리여부조회 <br>
		 * 
		 * @param PsoCnlTzFeeVO psoCnlTzFeeVO
		 * @return int
		 * @throws DAOException
		 */
		public int searchMsaCnt(PsoCnlTzFeeVO psoCnlTzFeeVO) throws DAOException {
			int cnt  =0;
	        DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	        
	        try {
				if(psoCnlTzFeeVO != null){
					Map<String, String> mapVO = psoCnlTzFeeVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgentCanalTransitFeeBCDBDAOsearchMsaCntRSQL(), param, velParam);	
		    	if(dbRowset.next()) {
		    		cnt = dbRowset.getInt("CNT");
		    	}
			}catch(SQLException ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
				
			return cnt;
		}
		
		/**
		 * Canal Tz Fee 존재여부조회 <br>
		 * 
		 * @param PsoCnlTzFeeVO psoCnlTzFeeVO
		 * @return int
		 * @throws DAOException
		 */
		public int searchCanalTzFeeCnt(PsoCnlTzFeeVO psoCnlTzFeeVO) throws DAOException {
			int cnt  =0;
	        DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	        
	        try {
				if(psoCnlTzFeeVO != null){
					Map<String, String> mapVO = psoCnlTzFeeVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgentCanalTransitFeeBCDBDAOsearchCanalTzFeeCntRSQL(), param, velParam);	
		    	if(dbRowset.next()) {
		    		cnt = dbRowset.getInt("CNT");
		    	}
			}catch(SQLException ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
				
			return cnt;
		}
		
		
		/**
		 * Canal transit schedule 전체 건수 조회<br>
		 * 
		 * @param CanalTransitScheduleVO canalTransitScheduleVO
		 * @return int
		 * @throws DAOException
		 */
		public int searchCanalTransitScheduleCountData(CanalTransitScheduleVO canalTransitScheduleVO) throws DAOException {
			int cnt  =0;
	        DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	        
	        try {
				if(canalTransitScheduleVO != null){
					Map<String, String> mapVO = canalTransitScheduleVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgentCanalTransitFeeBCDBDAOsearchCanalTransitScheduleCountDataRSQL(), param, velParam);	
		    	if(dbRowset.next()) {
		    		cnt = dbRowset.getInt("CNT");
		    	}
			}catch(SQLException ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
				
			return cnt;
		}		
		
		/**
		 * Canal transit schedule 조회<br>
		 * 
		 * @param CanalTransitScheduleVO canalTransitScheduleVO
		 * @return List<CanalTransitScheduleVO>
		 * @exception DAOException 
		 */	
		@SuppressWarnings("unchecked")
		public List<CanalTransitScheduleVO> searchCanalTransitSchedule(CanalTransitScheduleVO canalTransitScheduleVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CanalTransitScheduleVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(canalTransitScheduleVO != null){
					Map<String, String> mapVO = canalTransitScheduleVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	            AgentCanalTransitFeeBCDBDAOsearchCanalTransitScheduleRSQL template = new AgentCanalTransitFeeBCDBDAOsearchCanalTransitScheduleRSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTransitScheduleVO .class);
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
		 * Canal transit Attach File 조회<br>
		 * 
		 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
		 * @return List<PsoCanalInvAttachFileVO>
		 * @exception DAOException 
		 */	
		@SuppressWarnings("unchecked")
		public List<PsoCanalInvAttachFileVO> searchPsoCanalInvAttachFileList(CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PsoCanalInvAttachFileVO> list = null;
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
				
	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	            AgentCanalTransitFeeBCDBDAOsearchPsoCanalInvAttachFileListRSQL template = new AgentCanalTransitFeeBCDBDAOsearchPsoCanalInvAttachFileListRSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoCanalInvAttachFileVO .class);
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
		 * EXP_SPP_0002_save, EXP_SPP_0003_save 시 PSO_CNL_TZ_FEE_DTL에 데이터가 존재하는지 체크하는 DAO처리 <br>
		 * 
		 * @param PsoCnlTzAtchFileVO psoCnlTzAtchFileVO
		 * @exception DAOException 
		 */		
	    @SuppressWarnings("unchecked")
	     public void deletePsoCnlTzAtchFile(PsoCnlTzAtchFileVO psoCnlTzAtchFileVO) throws DAOException {
	       
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try{ 
				if(psoCnlTzAtchFileVO != null){
					Map<String, String> mapVO = psoCnlTzAtchFileVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}	        	
				SQLExecuter sqlExe = new SQLExecuter("");  
				sqlExe.executeUpdate((ISQLTemplate)new AgentCanalTransitFeeBCDBDAOdeletePsoCnlTzAtchFileDSQL(), param, velParam);
	           
	        }catch(SQLException ex){
	        	//log.error(ex.getMessage(),ex);
	        	throw new DAOException(ex.getMessage(), ex);
	        }catch(Exception ex){
	        	//log.error(ex.getMessage(),ex);
	        	throw new DAOException(ex.getMessage(), ex);
	        }         

	     }
	    
		/**
		 * CanalTzFee by VVD Save : PSO_CNL_TZ_ATCH_FILE<br>
		 *
		 * @param PsoCnlTzAtchFileVO psoCnlTzAtchFileVO
		 * @exception DAOException 
		 */
		@SuppressWarnings("unchecked")
		public void addPsoCnlTzAtchFile(PsoCnlTzAtchFileVO psoCnlTzAtchFileVO) throws DAOException, Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
		        //query parameter
		        Map<String, String> param = psoCnlTzAtchFileVO.getColumnValues();				
				sqlExe.executeUpdate((ISQLTemplate) new AgentCanalTransitFeeBCDBDAOaddPsoCnlTzAtchFileCSQL(), param, null);
				
			} catch (SQLException ex) { 
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			} catch (Exception ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 * Canal booking status for Panama Save 처리<br>
		 * 
		 * @param List<CanalTransitScheduleVO> canalTransitScheduleVO
		 * @exception DAOException 
		 */
		@SuppressWarnings("unchecked")
		public void addVskCnlTzBkgList(List<CanalTransitScheduleVO> canalTransitScheduleVO) throws DAOException, Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (canalTransitScheduleVO.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate) new AgentCanalTransitFeeBCDBDAOaddVskCnlTzBkgCSQL(), canalTransitScheduleVO, null);
					for (int i = 0; i < insCnt.length; i++) {
						if (insCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException ex) { 
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			} catch (Exception ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 * Canal booking status for Panama 존재 여부 조회<br>
		 * 
		 * @param CanalTransitScheduleVO canalTzSkdVo
		 * @return int
		 * @throws DAOException
		 */
		public int searchVskCnlTzBkgCount(CanalTransitScheduleVO canalTzSkdVo) throws DAOException {
			int cnt = 0;
	        DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	        
	        try {
				if(canalTzSkdVo != null){
					Map<String, String> mapVO = canalTzSkdVo .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgentCanalTransitFeeBCDBDAOsearchVskCnlTzBkgCountRSQL(), param, velParam);	
		    	if(dbRowset.next()) {
		    		cnt = dbRowset.getInt("CNT");
		    	}
			}catch(SQLException ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
				
			return cnt;
		}
		
		/**
		 * Canal booking status for Panama Update 처리<br>
		 * 
		 * @param List<CanalTransitScheduleVO> canalTransitScheduleVO
		 * @exception DAOException 
		 */
		@SuppressWarnings("unchecked")
		public void modifyVskCnlTzBkgList(List<CanalTransitScheduleVO> canalTransitScheduleVO) throws DAOException, Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (canalTransitScheduleVO.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate) new AgentCanalTransitFeeBCDBDAOmodifyVskCnlTzBkgUSQL(), canalTransitScheduleVO, null);
					for (int i = 0; i < insCnt.length; i++) {
						if (insCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException ex) { 
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			} catch (Exception ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 * 데이터 삭제 : VSK_CNL_TZ_BKG<br>
		 * Canal booking status for Panama Delete 처리<br>
		 * 
		 * @param List<CanalTransitScheduleVO> canalTransitScheduleVO
		 * @exception DAOException
		 */		
	    @SuppressWarnings("unchecked")
	     public void deleteVskCnlTzBkgList(List<CanalTransitScheduleVO> canalTransitScheduleVO) throws DAOException {
	    	try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (canalTransitScheduleVO.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate) new AgentCanalTransitFeeBCDBDAOdeleteVskCnlTzBkgDSQL(), canalTransitScheduleVO, null);
					for (int i = 0; i < insCnt.length; i++) {
						if (insCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}				
	        }catch(SQLException ex){
	        	//log.error(ex.getMessage(),ex);
	        	throw new DAOException(ex.getMessage(), ex);
	        }catch(Exception ex){
	        	//log.error(ex.getMessage(),ex);
	        	throw new DAOException(ex.getMessage(), ex);
	        }         

	     }

}