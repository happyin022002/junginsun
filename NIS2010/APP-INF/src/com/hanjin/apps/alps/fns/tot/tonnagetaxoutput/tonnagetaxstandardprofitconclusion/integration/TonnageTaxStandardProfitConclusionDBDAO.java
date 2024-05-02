
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxOutputMasterDataMgtDBDAO.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.21 장창수
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2012.01.27 이준범 [CHM-201113807-01]
* 제목 : ALPS 톤세 시스템 기능보완 - T/TAX Recalculation
* 내용 : 1) T/Tax Recalculated 옆에 Lane이 추가 되면 추가된 선박만 재배치 할 수 있게 처리
*       2) T/Tax Recalculated 작업 후, 변경된 내역을 표시해주는 팝업창 또는 화면을 추가하여
*          변경사항 확인할 수 있게 처리
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

import com.hanjin.syscommon.common.table.TotStlCfmVO;

import com.hanjin.syscommon.common.table.TotBsaVO;
import com.hanjin.syscommon.common.table.TotPortStlAmtVO;
import com.hanjin.syscommon.common.table.TotStlClzVO;
import com.hanjin.syscommon.common.table.TotVvdStlAmtVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.ErpIfVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.FdrStlAmtVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.PortStlAmtVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.StlCfmVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.VvdStlAmtVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.JbSkdVO;
/**
 * ALPS TonnageTaxOutputMasterDataMgtDBDAO <br>
 * - ALPS-TonnageTaxOutput system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jang Chang Soo
 * @see TonnageTaxOutputMasterDataMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class TonnageTaxStandardProfitConclusionDBDAO extends DBDAOSupport {



	/**
	 * ERP I/F Inquiry 최종마감년월을 조회한다. <br>
	 * 
	 * @return List<ErpIfVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ErpIfVO> searchMaxCosingYearMm() throws DAOException {
		DBRowSet dbRowset = null;
		List<ErpIfVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			
	        SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	        log.debug("::CALL::> FNS_TOT_0020 DAQ > search 진입:::::::::");
	        TonnageTaxStandardProfitConclusionDBDAOErpIFMaxCosingYearMmVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOErpIFMaxCosingYearMmVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ErpIfVO .class);
			log.debug("::CALL::> FNS_TOT_0020 DAQ > 끝:::::::::");
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
	 * 월별 선박당 사용율 및 톤세 관련 데이터를 조회한다. <br>
	 * 
	 * @param ErpIfVO erpIfVO
	 * @return List<ErpIfVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ErpIfVO> searchTaxableAmountListByERPInterface(ErpIfVO erpIfVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ErpIfVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(erpIfVO != null){
				Map<String, String> mapVO = erpIfVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
	        SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	        log.debug("::CALL::> FNS_TOT_0020 DAQ > search 진입:::::::::");
	        TonnageTaxStandardProfitConclusionDBDAOErpIFInquiryVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOErpIFInquiryVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ErpIfVO .class);
			log.debug("::CALL::> FNS_TOT_0020 DAQ > 끝:::::::::");
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
	 * Lane별 NRT/CAPA/BSA Allocation을 조회한다. <br>
	 * 
	 * @param BsaVO bsaVO
	 * @return List<BsaVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BsaVO> searchNrtNCapaNBsaListByLane(BsaVO bsaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BsaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(bsaVO != null){
				Map<String, String> mapVO = bsaVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
	        SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	        log.debug("::CALL::> FNS_TOT_0010 DAQ >  search 진입:::::::::");
	        TonnageTaxStandardProfitConclusionDBDAONrtNCapaNBsaListByLaneVORSQL template = new TonnageTaxStandardProfitConclusionDBDAONrtNCapaNBsaListByLaneVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BsaVO .class);
			log.debug("::CALL::> FNS_TOT_0010 DAQ > 끝:::::::::");
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
	 * (FNS_TOT_0018) POPUP ERP TAX로 I/F 결과를 조회한다. <br>
	 * 
	 * @param TotStlCfmVO totStlCfmVO
	 * @return List<TotStlCfmVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TotStlCfmVO> searchTaxableAmountStatusList(TotStlCfmVO totStlCfmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TotStlCfmVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(totStlCfmVO != null){
				Map<String, String> mapVO = totStlCfmVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0019 DAQ > search 진입:::::::::");
            TonnageTaxStandardProfitConclusionDBDAOTaxableAmountIFStatusVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountIFStatusVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TotStlCfmVO .class);
			log.debug("::CALL::> FNS_TOT_0019 DAQ > 끝:::::::::");
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
	 * 해당 년월, TRADE의 NRT, USE, DAYS 체크여부를 조회한다. <br>
	 * 
	 * @param StlCfmVO stlCfmVO
	 * @return List<StlCfmVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<StlCfmVO> searchTaxableAmountConfirmationCheck(StlCfmVO stlCfmVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<StlCfmVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(stlCfmVO != null){
					Map<String, String> mapVO = stlCfmVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
	            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	            log.debug("::CALL::> FNS_TOT_0011 CFM CHECK DAQ > search 진입:::::::::");
	            TonnageTaxStandardProfitConclusionDBDAOTaxableAmountCfmCheckVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountCfmCheckVORSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, StlCfmVO .class);
				log.debug("::CALL::> FNS_TOT_0011 CFM CHECK DAQ > 끝:::::::::");
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
	 * 해당 년월, TRADE의 배치처리된 데이터가(TOT_PORT_STL_AMT) 있는지 조회한다. <br>
	 * 
	 * @param TotPortStlAmtVO totPortStlAmtVO
	 * @return List<TotPortStlAmtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TotPortStlAmtVO> searchPortStlAmtCheck(TotPortStlAmtVO totPortStlAmtVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<TotPortStlAmtVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(totPortStlAmtVO != null){
						Map<String, String> mapVO = totPortStlAmtVO.getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					
		            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
		            log.debug("::CALL::> FNS_TOT_0011 port CHECK DAQ > search 진입:::::::::");
		            TonnageTaxStandardProfitConclusionDBDAOPortStlAmtCheckVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOPortStlAmtCheckVORSQL();
					dbRowset = sqlExe.executeQuery(template, param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, TotPortStlAmtVO .class);
					log.debug("::CALL::> FNS_TOT_0011 port CHECK DAQ > 끝:::::::::");
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
	 * 해당 년월, TRADE의 데이터를 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VvdStlAmtVO> searchTaxableAmountConfirmationList(VvdStlAmtVO vvdStlAmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdStlAmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdStlAmtVO != null){
				Map<String, String> mapVO = vvdStlAmtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0011 DAQ > search 진입:::::::::");
            TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdStlAmtVO .class);
			log.debug("::CALL::> FNS_TOT_0011 DAQ > 끝:::::::::");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		log.debug("::CALL::> FNS_TOT_0011 DAQ > 끝2222222222222222222222222:::::::::");
		return list;
	}

	/**
	 * 체크된 NRT, USE, DAYS 데이터를 TOT_STL_CFM에 추가한다. <br>
	 * 
	 * @param StlCfmVO stlCfmVO
	 * @exception DAOException
	 */
	 
	public void addTaxableAmountConfirmationMark (StlCfmVO stlCfmVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = stlCfmVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
	            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	            
				//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL();
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVOCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
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
	 * FNS_TOT_0012 Popup 상세데이터를 조회한다.  <br>
	 * 
	 * @param PortStlAmtVO portStlAmtVO
	 * @return List<PortStlAmtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PortStlAmtVO> searchTaxableAmountConfirmationDetailListByVVD(PortStlAmtVO portStlAmtVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PortStlAmtVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(portStlAmtVO != null){
					Map<String, String> mapVO = portStlAmtVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
	            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	            log.debug("::CALL::> FNS_TOT_0012 DAQ > search 진입:::::::::");
	            TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationByDetailVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationByDetailVORSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortStlAmtVO .class);
				log.debug("::CALL::> FNS_TOT_0012 DAQ > 끝:::::::::");
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
	 * 수정된 데이터로 tax 재계산하여 저장한다 <br>
	 * TOT_VVD_STL_AMT
	 * @param PortStlAmtVO portStlAmtVO
	 * @exception DAOException
	 */
	public void modifyVvdStlAmtByRecalculate (PortStlAmtVO portStlAmtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("::CALL::> modifyTaxableAmountConfirmation DAQ > 시작:::::::::");
		int result1 = 0;
		try {
			Map<String, String> mapVO = portStlAmtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            result1 = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVOUSQL(), param, velParam);
           
            if(result1 == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * 수정된 데이터로 tax 재계산하여 저장한다 <br>
	 * TOT_VVD_STL_AMT
	 * @param PortStlAmtVO portStlAmtVO
	 * @exception DAOException
	 */
	public void modifyVvdStlAmtByRecalculateLoadCapa (PortStlAmtVO portStlAmtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("::CALL::> modifyTaxableAmountConfirmation DAQ > 시작:::::::::");
		int result1 = 0;
		try {
			Map<String, String> mapVO = portStlAmtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            result1 = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationLoadCapaVOUSQL(), param, velParam);
           
            if(result1 == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * 수정된 데이터로 tax 재계산하여 저장한다 <br>
	 * TOT_PORT_STL_AMT
	 * @param PortStlAmtVO portStlAmtVO
	 * @exception DAOException
	 */
	public void modifyPortStlAmtByRecalculate(PortStlAmtVO portStlAmtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("::CALL::> modifyTaxableAmountConfirmation DAQ > 시작:::::::::");
		int result2 = 0;
		try {
			Map<String, String> mapVO = portStlAmtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            result2 = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationByDetailVOUSQL(), param, velParam);

            if(result2 == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * 수정된 데이터로 tax 재계산하여 저장한다 <br>
	 * TOT_PORT_STL_AMT
	 * @param PortStlAmtVO portStlAmtVO
	 * @exception DAOException
	 */
	public void modifyPortStlAmtByRecalculateLoadCapa(PortStlAmtVO portStlAmtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("::CALL::> modifyTaxableAmountConfirmation DAQ > 시작:::::::::");
		int result2 = 0;
		try {
			Map<String, String> mapVO = portStlAmtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            result2 = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationByDetailLoadCapaVOUSQL(), param, velParam);

            if(result2 == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * VVD 최종년월을 조회한다. <br>
	 * 
	 * @return List<VvdStlAmtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VvdStlAmtVO> searchMaxCosingYearMmByVessel() throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdStlAmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			
	        SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	        log.debug("::CALL::> FNS_TOT_0013 DAQ > search 진입:::::::::");
	        TonnageTaxStandardProfitConclusionDBDAOVesselMaxCosingYearMmVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOVesselMaxCosingYearMmVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdStlAmtVO .class);
			log.debug("::CALL::> FNS_TOT_0013 DAQ > 끝:::::::::");
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
	 * 해당 VESSEL, 기간의  Taxable Amount 데이터를 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<VvdStlAmtVO> searchTaxableAmountListByVessel(VvdStlAmtVO vvdStlAmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdStlAmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdStlAmtVO != null){
				Map<String, String> mapVO = vvdStlAmtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0013 DAQ > search 진입:::::::::");
            TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByVesselVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByVesselVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdStlAmtVO .class);
			log.debug("::CALL::> FNS_TOT_0013 DAQ > 끝:::::::::");
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
	 * 해당년도를 마감한다. <br>
	 * 
	 * @param TotStlClzVO totStlClzVO
	 * @exception DAOException
	 */
	public void createTaxClosingMark (TotStlClzVO totStlClzVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = totStlClzVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            
			int result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAOcloseTonnageTaxStlYearVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * LANE, TRADE, 기간에 해당하는 데이터를 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VvdStlAmtVO> searchTaxableAmountListByLane(VvdStlAmtVO vvdStlAmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdStlAmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdStlAmtVO != null){
				Map<String, String> mapVO = vvdStlAmtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0015 DAQ > search 진입:::::::::");
            TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByLaneVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByLaneVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdStlAmtVO .class);
			log.debug("::CALL::> FNS_TOT_0015 DAQ > 끝:::::::::");
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
		 * 해당년월의 톤세 데이터를 조회한다. <br>
		 * 
		 * @param ErpIfVO erpIfVO
		 * @return List<ErpIfVO>
		 * @exception DAOException
		 */
	 @SuppressWarnings("unchecked")
	public List<ErpIfVO> searchTaxableAmountList(ErpIfVO erpIfVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ErpIfVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(erpIfVO != null){
				Map<String, String> mapVO = erpIfVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
	        SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	        log.debug("::CALL::> FNS_TOT_0018 DAQ > search 진입:::::::::");
	        TonnageTaxStandardProfitConclusionDBDAOErpIFByMonthlyVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOErpIFByMonthlyVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ErpIfVO .class);
			log.debug("::CALL::> FNS_TOT_0018 DAQ > 끝:::::::::");
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
	 * 생성하기 위한 ERP I/F 데이터를 조회한다. <br>
	 * 
	 * @param String stlYrmon
	 * @param String usrId
	 * @return List<ErpIfVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ErpIfVO> searchTaxableAmountForCreationIF(String stlYrmon, String usrId) throws DAOException {
			DBRowSet dbRowset = null;
			List<ErpIfVO> list = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {

				param.put("stl_yrmon", stlYrmon);
				param.put("cre_usr_id", usrId);
				
				velParam.put("stl_yrmon", stlYrmon);
				velParam.put("cre_usr_id", usrId);
				
	            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	        log.debug("::CALL::> FNS_TOT_0018 DAQ > search 진입:::::::::");
	        TonnageTaxStandardProfitConclusionDBDAOTaxableAmountForCreationIFVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountForCreationIFVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ErpIfVO .class);
			log.debug("::CALL::> FNS_TOT_0018 DAQ > 끝:::::::::");
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
	 * ERP I/F 데이터를 TOT_ERP_IF테이블에 생성한다. <br>
	 * 
	 * @param List<ErpIfVO> erpIfVOs
	 * @exception DAOException
	 */
	public void createTaxableAmountIF (List<ErpIfVO> erpIfVOs) throws DAOException,Exception {
		try {
			log.debug("::CALL::> FNS_TOT_0018 DAQ createTaxableAmountIF> 진입-----:::::::::");
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
			//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOCSQL();
			int insCnt[] = null;

			log.debug("::CALL::> FNS_TOT_0006 createTaxableAmountIF DAQ >IB_FLAG : I 존재:::::::::");

			if(erpIfVOs.size() > 0){
				log.debug("::CALL::> FNS_TOT_0006 createTaxableAmountIF DAQ >IB_FLAG : I 존재:::::::::");
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountIFVOCSQL(), erpIfVOs,null);
				//insCnt = sqlExe.executeBatch(template, insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * 연동을 위한 ERP I/F 데이터를 조회한다.  <br>
	 * 
	 * @param String stlYrmon
	 * @return List<ErpIfVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ErpIfVO> searchTaxableAmountIF(String stlYrmon) throws DAOException {
		DBRowSet dbRowset = null;
		List<ErpIfVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(stlYrmon != null){
				param.put("stl_yrmon", stlYrmon);
				velParam.put("stl_yrmon", stlYrmon);
			}
			
	        SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	        log.debug("::CALL::> FNS_TOT_0018 DAQ > search 진입:::::::::");
	        TonnageTaxStandardProfitConclusionDBDAOTaxableAmountIFVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountIFVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ErpIfVO .class);
			log.debug("::CALL::> FNS_TOT_0018 DAQ > 끝:::::::::");
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
	 * 해당년월의 톤세 관련 현재상태를 조회한다. <br>
	 * 
	 * @param StlCfmVO stlCfmVO
	 * @return List<StlCfmVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<StlCfmVO> searchTaxableAmountStatus(StlCfmVO stlCfmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StlCfmVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(stlCfmVO != null){
				Map<String, String> mapVO = stlCfmVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
	        SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	        log.debug("::CALL::> FNS_TOT_0018 DAQ > search 진입:::::::::");
	        TonnageTaxStandardProfitConclusionDBDAOErpIFByMonthlyStatusVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOErpIFByMonthlyStatusVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StlCfmVO .class);
			log.debug("::CALL::> FNS_TOT_0018 DAQ > 끝:::::::::");
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
	 * 해당년월, data type, 선박 기준 feeder 데이터를 조회한다. <br>
	 * 
	 * @param FdrStlAmtVO fdrStlAmtVO
	 * @return List<FdrStlAmtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FdrStlAmtVO> searchFeederTaxableAmountListByVessel(FdrStlAmtVO fdrStlAmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FdrStlAmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(fdrStlAmtVO != null){
				Map<String, String> mapVO = fdrStlAmtVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
	        SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	        log.debug("::CALL::> FNS_TOT_0016 DAQ > search 진입:::::::::");
	        TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByDayVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByDayVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FdrStlAmtVO .class);
			log.debug("::CALL::> FNS_TOT_0016 DAQ > 끝:::::::::");
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
	 * 수정한 선박 기준 feeder데이터를 저장한다. <br>
	 * 
	 * @param List<FdrStlAmtVO> fdrStlAmtVOs
	 * @exception DAOException
	 */
	public void modifyFeederTaxableAmountByVessel(List<FdrStlAmtVO> fdrStlAmtVOs) throws DAOException,Exception {
		try {
	            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
				//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL();
				int updCnt[] = null;
				if(fdrStlAmtVOs.size() > 0){
					//updCnt = sqlExe.executeBatch(template, updModels, null);
					updCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountInquiryByDayVOUSQL(), fdrStlAmtVOs,null);
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
	 * 해당 VVD가 존재하는지 여부를 조회한다.
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchVvdExistYn(VvdStlAmtVO vvdStlAmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		//List<VvdStlAmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String vvd_exist_yn = null;
		try{
			if(vvdStlAmtVO != null){
				Map<String, String> mapVO = vvdStlAmtVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			TonnageTaxStandardProfitConclusionDBDAOTaxableAmountVvdExistVORSQL existTemp = new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountVvdExistVORSQL();
			dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery(existTemp, param, velParam); 

			dbRowset.next(); 
			vvd_exist_yn = dbRowset.getString("vvd_exist_yn"); 
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return vvd_exist_yn;
	}
	
	/**
	 * 해당년월의 feeder summary 데이터를 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @param String vvd_exist_yn
	 * @return List<VvdStlAmtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VvdStlAmtVO> searchFeederTaxableAmountListByMonthly(VvdStlAmtVO vvdStlAmtVO, String vvd_exist_yn) throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdStlAmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(vvdStlAmtVO != null){
				Map<String, String> mapVO = vvdStlAmtVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("vvd_exist_yn", vvd_exist_yn);
		    SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	        log.debug("::CALL::> FNS_TOT_0017 DAQ > search 진입:::::::::");
	        TonnageTaxStandardProfitConclusionDBDAOTaxableAmountSummaryVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountSummaryVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdStlAmtVO .class);
			
			log.debug("::CALL::> FNS_TOT_0017 DAQ > 끝:::::::::");
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
	 * 해당년월의 feeder summary 데이터를 TOT_VVD_STL_AMT로 저장한다.<br>
	 * 
	 * @param List<VvdStlAmtVO> vvdStlAmtVOs
	 * @exception DAOException
	 */
	public void addsFromFeederTaxToVVDTax(List<VvdStlAmtVO> vvdStlAmtVOs) throws DAOException,Exception {
		try {
			log.debug("::CALL::> FNS_TOT_0017 DAQ addsFromFeederTaxToVVDTax> 진입-----:::::::::");
	        SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	
	        int insCntVvd[] = null;
	        int insCntPort[] = null;
	
			log.debug("::CALL::> FNS_TOT_0017 addsFromFeederTaxToVVDTax DAQ >IB_FLAG : I 존재:::::::::");
	
			if(vvdStlAmtVOs.size() > 0){
				log.debug("::CALL::> FNS_TOT_0017 addsFromFeederTaxToVVDTax DAQ >IB_FLAG : I 존재:::::::::");
				insCntVvd = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountSummaryVvdVOCSQL(), vvdStlAmtVOs,null);
				
				for(int i = 0; i < insCntVvd.length; i++){
					if(insCntVvd[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
				
				insCntPort = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountSummaryPortVOCSQL(), vvdStlAmtVOs,null);
				
				for(int i = 0; i < insCntPort.length; i++){
					if(insCntPort[i]== Statement.EXECUTE_FAILED)
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
	 * 해당기간의 배치 history정보를 조회한다. <br>
	 * 
	 * @param JbSkdVO jbSkdVO
	 * @param String hisType
	 * @return List<JbSkdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<JbSkdVO> searchNonFeederNFeederTaxBatchHis(JbSkdVO jbSkdVO, String hisType) throws DAOException {
			DBRowSet dbRowset = null;
			List<JbSkdVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				if(jbSkdVO != null){
					Map<String, String> mapVO = jbSkdVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
                param.put("his_type", hisType);
                velParam.put("his_type", hisType);
                
		        SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
		        log.debug("::CALL::> FNS_TOT_0021 DAQ > search batch status 진입:::::::::");
		        TonnageTaxStandardProfitConclusionDBDAOTaxCalculationJobSkdVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOTaxCalculationJobSkdVORSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, JbSkdVO .class);
				log.debug("::CALL::> FNS_TOT_0021 DAQ >  search batch status  끝:::::::::");
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
	 * 해당기간의 배치 history정보를 저장한다. <br>
	 * 
	 * @param String paramStDt
	 * @param String paramEndDt
	 * @param String stDate
	 * @param String jobID
	 * @param String batItmNm
	 * @param String usrId
	 * @exception DAOException
	 */
	public void addNonFeederNFeederTaxBatch (String paramStDt, String paramEndDt, String stDate ,String jobID , String batItmNm, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			log.debug("paramStDt ::"+paramStDt);
			log.debug("paramEndDt ::"+paramEndDt);
			log.debug("stDate ::"+stDate);
			log.debug("jobID ::"+jobID);
			log.debug("batItmNm ::"+batItmNm);
			log.debug("usrId ::"+usrId);
			
			param.put("paramStDt", paramStDt);
			param.put("paramEndDt", paramEndDt);
			param.put("stDate", stDate);
			param.put("jobID", jobID);
			param.put("bat_itm_nm", batItmNm);
			param.put("cre_usr_id", usrId);
			
            velParam.put("paramStDt", paramStDt);
            velParam.put("paramEndDt", paramEndDt);
            velParam.put("stDate", stDate);
            velParam.put("jobID", jobID);
            velParam.put("bat_itm_nm", batItmNm);
            velParam.put("cre_usr_id", usrId);
            log.debug("addNonFeederNFeederTaxBatch ============================ ");
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
        	
			int result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAOTaxCalculationJobSkdVOCSQL(), param, velParam);
			log.debug("addNonFeederNFeederTaxBatch ============================ end ");
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * 해당기간의 배치history정보를 삭제한다. <br>
	 * 
	 * @param String jobID
	 * @exception DAOException
	 */
	public void removeNonFeederNFeederTaxBatch (String jobID) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			log.debug("jobID ::"+jobID);
			
			param.put("jb_id", jobID);
            velParam.put("jb_id", jobID);

            log.debug("removeNonFeederNFeederTaxBatch ============================ ");
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
        	
			int result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAOTaxCalculationJobSkdVODSQL(), param, velParam);
			log.debug("removeNonFeederNFeederTaxBatch ============================ end ");
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * BSA 정보의 tax 재계산전 변경된 데이터가 있는지 여부를 조회한다. <br>
	 * 
	 * @param TotBsaVO totBsaVO
	 * @return List<TotBsaVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TotBsaVO>  searchRecalculateBsaForModiFlg(TotBsaVO totBsaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TotBsaVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(totBsaVO != null){
				log.debug("getStlYrmon ::::::: "+totBsaVO.getStlYrmon());
				Map<String, String> mapVO = totBsaVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0006 searchRecalculateBsaForModiFlg DAQ > search 진입:::::::::");
            TonnageTaxStandardProfitConclusionDBDAORecalculateBsaForModiFlgVORSQL template = new TonnageTaxStandardProfitConclusionDBDAORecalculateBsaForModiFlgVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TotBsaVO .class);

			log.debug("::CALL::> FNS_TOT_0006 searchRecalculateBsaForModiFlg DAQ > 끝:::::::::");
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
	 * BSA 정보의 NRT 재계산전 변경된 데이터가 있는지 여부를 조회한다. <br>
	 * 
	 * @param TotBsaVO totBsaVO
	 * @return List<TotBsaVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TotBsaVO>  searchRecalculateNrtForModiFlg(TotBsaVO totBsaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TotBsaVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(totBsaVO != null){
				log.debug("getStlYrmon ::::::: "+totBsaVO.getStlYrmon());
				Map<String, String> mapVO = totBsaVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0006 searchRecalculateNrtForModiFlg DAQ > search 진입:::::::::");
            TonnageTaxStandardProfitConclusionDBDAORecalculateNrtForModiFlgVORSQL template = new TonnageTaxStandardProfitConclusionDBDAORecalculateNrtForModiFlgVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TotBsaVO .class);
             
			log.debug("::CALL::> FNS_TOT_0006 searchRecalculateNrtForModiFlg DAQ > 끝:::::::::");
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
	 *  BSA 정보의 조회된 데이터로 TOT_PORT_STL_AMT NRT 재계산. <br>
	 * 
	 * @param List<TotBsaVO> totBsaVOs
	 * @exception DAOException
	 */
	public void modifyRecalculateNrtByPort(List<TotBsaVO> totBsaVOs) throws DAOException,Exception {
		try {
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            Map<String, Object> velParam = new HashMap<String, Object>();
            int updCnt[] = null;
			if(totBsaVOs.size() > 0){
				Map<String, String> mapVO = totBsaVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAORecalculateNrtByPortVOUSQL(), totBsaVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			log.debug("::CALL::> FNS_TOT_0006 DAO LEE>IB_FLAG : U 끝:::::::::");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
	}	
	

	/**
	 *  조회된 데이터를 tot_vvd_stl_amt에 NRT 재계산 저장한다. <br>
	 * 
	 * @param List<TotBsaVO> totBsaVOs
	 * @exception DAOException
	 */ 
	
	public void modifyRecalculateNrtByVvd (List<TotBsaVO> totBsaVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            Map<String, Object> velParam = new HashMap<String, Object>();
            int updCnt[] = null;
			if(totBsaVOs.size() > 0){
				Map<String, String> mapVO = totBsaVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAORecalculateNrtByVvdVOUSQL(), totBsaVOs,null);
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
	 *  BSA 정보의 조회된 데이터로 recalculate하여 tot_port_stl_amt 테이블에 저장. <br>
	 * 
	 * @param List<TotBsaVO> totBsaVOs
	 * @exception DAOException
	 */
	public void modifyRecalculateBsaByPort(List<TotBsaVO> totBsaVOs) throws DAOException,Exception {
		try {
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
			//TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL() template = new TonnageTaxOutputMasterDataMgtDBDAOTotVesselVOUSQL();
			int updCnt[] = null;
			if(totBsaVOs.size() > 0){
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAORecalculateBsaByPortVOUSQL(), totBsaVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			log.debug("::CALL::> FNS_TOT_0006 DAO >IB_FLAG : U 끝:::::::::");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	
	
	/**
	 *  recalculate하여 tot_port_stl_amt에 저장된 데이터를 조회한다 <br>
	 * 
	 * @param TotBsaVO totBsaVO
	 * @return  List<TotVvdStlAmtVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TotVvdStlAmtVO>  searchRecalculateBsaForVvd(TotBsaVO totBsaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TotVvdStlAmtVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(totBsaVO != null){
				Map<String, String> mapVO = totBsaVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0006 searchRecalculateBsaForVvd DAQ > search 진입:::::::::");
            TonnageTaxStandardProfitConclusionDBDAORecalculateBsaForVvdVORSQL template = new TonnageTaxStandardProfitConclusionDBDAORecalculateBsaForVvdVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TotVvdStlAmtVO .class);

			log.debug("::CALL::> FNS_TOT_0006 searchRecalculateBsaForVvd DAQ > 끝:::::::::");
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
	 *  조회된 데이터를 tot_vvd_stl_amt에 vessel단위로 저장한다. <br>
	 * 
	 * @param TotVvdStlAmtVO totVvdStlAmtVO
	 * @return  int
	 * @exception DAOException
	 */ 
	
	public int modifyRecalculateBsaByVvd (TotVvdStlAmtVO totVvdStlAmtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = totVvdStlAmtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
			
            result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAORecalculateBsaByVvdVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
			
		} catch (SQLException ex) {

			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return result;
	}			

	/**
	 * 해당년월의 일수가 0이면서, Booking 물량이 있는 데이터를 조회한다. <br>
	 * 
	 * @param PortStlAmtVO portStlAmtVO
	 * @return List<PortStlAmtVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<PortStlAmtVO> searchInquiryActVsDays(PortStlAmtVO portStlAmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortStlAmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portStlAmtVO != null){
				Map<String, String> mapVO = portStlAmtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0022 DAQ > search 진입:::::::::");
            TonnageTaxStandardProfitConclusionDBDAOInquiryActVsDaysVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOInquiryActVsDaysVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortStlAmtVO .class);
			log.debug("::CALL::> FNS_TOT_0022 DAQ > 끝:::::::::");
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
	 * 운항스케쥴대비 배치후 누락 port 데이터를 조회한다. <br>
	 * 
	 * @param PortStlAmtVO portStlAmtVO
	 * @return List<PortStlAmtVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<PortStlAmtVO> searchExceptedVslPortSkd(PortStlAmtVO portStlAmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortStlAmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portStlAmtVO != null){
				Map<String, String> mapVO = portStlAmtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0023 DAQ > search 진입:::::::::");
            TonnageTaxStandardProfitConclusionDBDAOExceptedVslPortSkdVORSQL template = new TonnageTaxStandardProfitConclusionDBDAOExceptedVslPortSkdVORSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortStlAmtVO .class);
			log.debug("::CALL::> FNS_TOT_0023 DAQ > 끝:::::::::");
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
     * JB ID를 조회한다.
     * @param JbSkdVO jbSkdVO
     * @return List<JbSkdVO>
     * @throws DAOException
     */
	public List<JbSkdVO> searchJbIdList(JbSkdVO jbSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JbSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(jbSkdVO != null){
				Map<String, String> mapVO = jbSkdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
	        SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");	        
	        TonnageTaxStandardProfitConclusionDBDAOGetJbIdRSQL template = new TonnageTaxStandardProfitConclusionDBDAOGetJbIdRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JbSkdVO .class);
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
	 * NonFeederPortCalculation 정보를 저장한다. <br>
	 * 
	 * @param String stlYrmon
	 * @param String vslCd
	 * @param String creUsrId
	 * @exception DAOException
	 */
	public void addNonFeederPortCalculation (String stlYrmon, String vslCd, String creUsrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
					
			param.put("stl_yrmon", stlYrmon);
			param.put("vsl_cd", vslCd);
			
			param.put("cre_usr_id", creUsrId);
			
            velParam.put("stl_yrmon", stlYrmon);
            velParam.put("vsl_cd", vslCd);
            velParam.put("cre_usr_id", creUsrId);

            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
        	
			int result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAONonFeederPortCalculationVOCSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * NonFeederVvdCalculation 정보를 저장한다. <br>
	 * 
	 * @param String stlYrmon
	 * @param String vslCd
	 * @param String creUsrId
	 * @exception DAOException
	 */
	public void addNonFeederVvdCalculation (String stlYrmon, String vslCd, String creUsrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
					
			param.put("stl_yrmon", stlYrmon);
			param.put("vsl_cd", vslCd);
			param.put("cre_usr_id", creUsrId);
			
            velParam.put("stl_yrmon", stlYrmon);
            velParam.put("vsl_cd", vslCd);
            velParam.put("cre_usr_id", creUsrId);

            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
        	
			int result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxStandardProfitConclusionDBDAONonFeederVvdCalculationVOCSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * SHEET에 해당년월의 DETAIL_DOWN 데이터를 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @param String vvd_exist_yn
	 * @return List<VvdStlAmtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VvdStlAmtVO> searchFeederTaxableAmountListByDetailDown(VvdStlAmtVO vvdStlAmtVO, String vvd_exist_yn) throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdStlAmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(vvdStlAmtVO != null){
				Map<String, String> mapVO = vvdStlAmtVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("vvd_exist_yn", vvd_exist_yn);
		    SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	        log.debug("::CALL::> FNS_TOT_0017 DAQ > search 진입:::::::::");
	        TonnageTaxStandardProfitConclusionDBDAOTaxableAmountSummaryDetailDownRSQL template = new TonnageTaxStandardProfitConclusionDBDAOTaxableAmountSummaryDetailDownRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdStlAmtVO .class);
			
			log.debug("::CALL::> FNS_TOT_0017 DAQ > 끝:::::::::");
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
	 * Inquiry VSL Owner/Charter화면의 내용을 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VvdStlAmtVO> searchInquiryVslOwnerCharterList(VvdStlAmtVO vvdStlAmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdStlAmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdStlAmtVO != null){
				Map<String, String> mapVO = vvdStlAmtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
            log.debug("::CALL::> FNS_TOT_0030 DAQ > search 진입:::::::::");
            TonnageTaxStandardProfitConclusionDBDAOInquiryVslOwnerCharterListRSQL template = new TonnageTaxStandardProfitConclusionDBDAOInquiryVslOwnerCharterListRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdStlAmtVO .class);
			log.debug("::CALL::> FNS_TOT_0030 DAQ > 끝:::::::::");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		log.debug("::CALL::> FNS_TOT_0030 DAQ > 끝:::::::::");
		return list;
	}
	
	/**
	 * FNS_TOT_0012 Popup 상세데이터를 조회한다.  <br>
	 * 
	 * @param PortStlAmtVO portStlAmtVO
	 * @return List<PortStlAmtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PortStlAmtVO> searchInquiryVslOwnerCharterDetailList(PortStlAmtVO portStlAmtVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PortStlAmtVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(portStlAmtVO != null){
					Map<String, String> mapVO = portStlAmtVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
	            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
	            log.debug("::CALL::> FNS_TOT_0012 DAQ > search 진입:::::::::");
	            TonnageTaxStandardProfitConclusionDBDAOInquiryVslOwnerCharterDetailListRSQL template = new TonnageTaxStandardProfitConclusionDBDAOInquiryVslOwnerCharterDetailListRSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortStlAmtVO .class);
				log.debug("::CALL::> FNS_TOT_0012 DAQ > 끝:::::::::");
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
