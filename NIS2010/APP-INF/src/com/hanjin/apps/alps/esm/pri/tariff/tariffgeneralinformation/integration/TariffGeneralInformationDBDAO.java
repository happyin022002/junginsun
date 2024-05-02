/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffGeneralInformationDBDAO.java
*@FileTitle : Tariff General Information Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.06
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.10.06 김민아
* 1.0 Creation
* 
* 2015.08.07 현성길 [CHM-201537109] Split19-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.basic.TariffGeneralInformationBCImpl;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.PriTrfBzcHistoryAmendVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.PriTrfBzcHistoryVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.RsltMdmOrganizationVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.RsltPriTrfBzcRoutPntVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.RsltPriTrfBzcVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTrfBzcProgVO;
import com.hanjin.syscommon.common.table.PriTrfBzcRoutPntVO;
import com.hanjin.syscommon.common.table.PriTrfBzcVO;


/**
 * ALPS TariffGeneralInformationDBDAO <br>
 * - ALPS-Tariff system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author KIM MINAH
 * @see TariffGeneralInformationBCImpl 참조
 * @since J2EE 1.6
 */
public class TariffGeneralInformationDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Tariff Code의 General Information을 Select한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @param RsltMdmOrganizationVO orgVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPriTrfBzcVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriTrfBzcVO> searchTariffGeneralInformation(PriTrfBzcVO priTrfBzcVO, RsltMdmOrganizationVO orgVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTrfBzcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfBzcVO != null){
				Map<String, String> mapVO = priTrfBzcVO .getColumnValues();
				
				if(account != null){
					mapVO.put("ofc_cd", account.getOfc_cd());
					mapVO.put("rhq_ofc_cd",account.getRhq_ofc_cd());
				}
				// Head Quoter Office 일경우에만 RHQ Office를 이용해서 승인권자 권한을 판단한다.
				if( orgVO != null && "QT".equals(orgVO.getOfcTpCd()) ){
					if (account.getRhq_ofc_cd().equals("HAMRU")
					    ||account.getRhq_ofc_cd().equals("NYCRA")
						||account.getRhq_ofc_cd().equals("SHARC") 
						||account.getRhq_ofc_cd().equals("SINRS")){
						velParam.put("rhq_yn", "Y");
					}else{
						velParam.put("rhq_yn", "N");
					}
				}else{
					velParam.put("rhq_yn", "N");
				}
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfBzcVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
		/**
		 * Tariff Code의 Scope을 Select한다.<br>
		 * 
		 * @param PriTrfBzcVO priTrfBzcVO
		 * @param String org_dest_tp_cd
		 * @return List<RsltPriTrfBzcRoutPntVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<RsltPriTrfBzcRoutPntVO> searchTariffGeneralInformationScope(PriTrfBzcVO priTrfBzcVO, String org_dest_tp_cd) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltPriTrfBzcRoutPntVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(priTrfBzcVO != null){
					Map<String, String> mapVO = priTrfBzcVO .getColumnValues();
					
					mapVO.put("org_dest_tp_cd", org_dest_tp_cd);
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcRoutPntVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfBzcRoutPntVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
	
	/**
	 * Tariff Code의 General Information을 Insert한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addTariffBasic(PriTrfBzcVO priTrfBzcVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfBzcVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 General Information을 Update한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyTariffBasic(PriTrfBzcVO priTrfBzcVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = priTrfBzcVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 General Information을 Delete한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeTariffBasic(PriTrfBzcVO priTrfBzcVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = priTrfBzcVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 Scope을 Delete한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeTariffBasicRoutePoint(PriTrfBzcVO priTrfBzcVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = priTrfBzcVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcRoutPntVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 Scope을 Multi Insert한다.<br>
	 * @param List<PriTrfBzcRoutPntVO> PriTrfBzcRoutPntVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addTariffBasicRoutePoints(List<PriTrfBzcRoutPntVO> PriTrfBzcRoutPntVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(PriTrfBzcRoutPntVO .size() > 0){
				int[] insCnt = sqlExe.executeBatch((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcRoutPntVOsCSQL(), PriTrfBzcRoutPntVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 Scope을 Multi Update한다.<br>
	 * 
	 * @param List<PriTrfBzcRoutPntVO> PriTrfBzcRoutPntVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyTariffBasicRoutePoints(List<PriTrfBzcRoutPntVO> PriTrfBzcRoutPntVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(PriTrfBzcRoutPntVO .size() > 0){
				int[] updCnt = sqlExe.executeBatch((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcRoutPntVOsUSQL(), PriTrfBzcRoutPntVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 Scope을 Multi Delete한다.<br>
	 * 
	 * @param List<PriTrfBzcRoutPntVO> PriTrfBzcRoutPntVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeTariffBasicRoutePoints(List<PriTrfBzcRoutPntVO> PriTrfBzcRoutPntVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(PriTrfBzcRoutPntVO .size() > 0){
				int[] delCnt = sqlExe.executeBatch((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcRoutPntVOsDSQL(), PriTrfBzcRoutPntVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 General Information Status를 Update한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyTariffBasicStatus(PriTrfBzcVO priTrfBzcVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = priTrfBzcVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcStatusUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 General Information Progress를 Insert한다.<br>
	 * 
	 * @param PriTrfBzcProgVO priTrfBzcProgVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addTariffBasicProgress(PriTrfBzcProgVO priTrfBzcProgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfBzcProgVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcProgVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 General Information Progress를 Delete한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeTariffBasicProgress(PriTrfBzcVO priTrfBzcVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfBzcVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcProgVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 General Information을 Amend하여 Insert한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addTariffBasicAmend(PriTrfBzcVO priTrfBzcVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfBzcVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcAmendCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 Scope을 Amend하여 Insert한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addTariffBasicRoutePointAmend(PriTrfBzcVO priTrfBzcVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfBzcVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcAmendScopeCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Code의 General Information을 Publish하여 이전SEQ의 EXP_DT를 현재SEQ의 EFF_DT -1 로 Update한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyTariffBasicPublish(PriTrfBzcVO priTrfBzcVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfBzcVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcPublishUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff General Information List를 조회한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return List<RsltPriTrfBzcVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriTrfBzcVO> searchTariffGeneralInformationInquiryList(PriTrfBzcVO priTrfBzcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTrfBzcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priTrfBzcVO != null){
				Map<String, String> mapVO = priTrfBzcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcInquiryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfBzcVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
		/**
		 * Tariff General Information Scope을 Select한다.<br>
		 * 
		 * @param PriTrfBzcVO priTrfBzcVO
		 * @param String org_dest_tp_cd
		 * @return List<RsltPriTrfBzcRoutPntVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<RsltPriTrfBzcRoutPntVO> searchTariffGeneralInformationInquiryScope(PriTrfBzcVO priTrfBzcVO, String org_dest_tp_cd) throws DAOException {
			DBRowSet dbRowset = null;
			List<RsltPriTrfBzcRoutPntVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(priTrfBzcVO != null){
					Map<String, String> mapVO = priTrfBzcVO .getColumnValues();
					
					mapVO.put("org_dest_tp_cd", org_dest_tp_cd);
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcRoutPntInquiryVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriTrfBzcRoutPntVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		 
		/**
		 * ESM_PRI_3504 : Retrieve <br>
		 * Tariff General Information History
		 * 
		 * @param PriTrfBzcHistoryVO priTrfBzcHistoryVO
		 * @return List<PriTrfBzcHistoryVO>
		 * @exception DAOException
		 */
		public List<PriTrfBzcHistoryVO> searchTariffGeneralHistoryList(PriTrfBzcHistoryVO priTrfBzcHistoryVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PriTrfBzcHistoryVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(priTrfBzcHistoryVO != null){
					Map<String, String> mapVO = priTrfBzcHistoryVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcHistoryRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriTrfBzcHistoryVO.class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
		
		/**
		 * ESM_PRI_3504 : sheet1 double click <br>
		 * Tariff General Information Amend History
		 * 
		 * @param PriTrfBzcHistoryAmendVO priTrfBzcHistoryAmendVO
		 * @return List<PriTrfBzcHistoryAmendVO>
		 * @exception DAOException
		 */
		public List<PriTrfBzcHistoryAmendVO> searchTariffGeneralAmendHistoryList(PriTrfBzcHistoryAmendVO priTrfBzcHistoryAmendVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PriTrfBzcHistoryAmendVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(priTrfBzcHistoryAmendVO != null){
					Map<String, String> mapVO = priTrfBzcHistoryAmendVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcHistoryAmendRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriTrfBzcHistoryAmendVO.class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}	
		 
		/**
		 * Tariff Code의 General Information Save/Delete/Request/Cancel 전 체크<br>
		 * 
		 * @param PriTrfBzcVO priTrfBzcVO
		 * @return int
		 * @exception DAOException
		 */
		public int searchTariffCodeExistCheck(PriTrfBzcVO priTrfBzcVO) throws DAOException {
			DBRowSet dbRowset = null;
			int cnt = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(priTrfBzcVO != null){
					Map<String, String> mapVO = priTrfBzcVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfCdExistCheckRSQL(), param, velParam);
				if(dbRowset.next()) cnt = dbRowset.getInt("cnt");
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return cnt;
		}
		
		/**
		 * Tariff Code의 General Information Save/Delete/Request/Cancel 전 체크<br>
		 * 
		 * @param PriTrfBzcVO priTrfBzcVO
		 * @return int
		 * @exception DAOException
		 */
		public int searchTariffBasicExistCheck(PriTrfBzcVO priTrfBzcVO) throws DAOException {
			DBRowSet dbRowset = null;
			int cnt = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(priTrfBzcVO != null){
					Map<String, String> mapVO = priTrfBzcVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffGeneralInformationDBDAOPriTrfBzcExistCheckRSQL(), param, velParam);
				if(dbRowset.next()) cnt = dbRowset.getInt("cnt");
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return cnt;
		}
		
		/**
		 * 해당 Office의 Office Type Code를 조회한다.<br>
		 * 
		 * @param SignOnUserAccount account
		 * @return RsltMdmOrganizationVO
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked") 
		public RsltMdmOrganizationVO searchMdmOrganization(SignOnUserAccount account) throws DAOException {
			DBRowSet dbRowset = null;
			RsltMdmOrganizationVO orgVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			try{
	 
				param.put("ofc_cd", account.getOfc_cd());
					 
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TariffGeneralInformationDBDAORsltMdmOrganizationVORSQL(), param, null);
				List<RsltMdmOrganizationVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltMdmOrganizationVO .class);
				if( list.size() != 0 ){
					orgVO = list.get(0);
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return orgVO;
		}
		
}