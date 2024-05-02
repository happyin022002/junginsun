/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAO.java
*@FileTitle : Settlement Item & Account Code List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.04.24 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.AuthorityCarrierVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.CarrierVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.FinancialAffairsMtxVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.MstConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.SettlementBssPortVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS JointOperationMasterDataMgtDBDAO <br>
 * - OPUS-JointOperationMasterDataMgtSC system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Hee Dong
 * @see RenewalMasterDataMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class RenewalMasterDataMgtDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * ===================================================================================
	 * 2016.05.13 Renewal Add.
	 * ===================================================================================
	 */

	/**
	 * Carrier 조회.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param MstConditionVO mstConditionVO
	 * @return List<CarrierVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CarrierVO> searchCarrierList(MstConditionVO mstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CarrierVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mstConditionVO != null){
				Map<String, String> mapVO = mstConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RenewalMasterDataMgtDBDAOSearchCarrierListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CarrierVO .class);
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
	 * Authority Carrier 조회.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param MstConditionVO mstConditionVO
	 * @return List<AuthorityCarrierVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AuthorityCarrierVO> searchAuthorityCarrierList(MstConditionVO mstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AuthorityCarrierVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mstConditionVO != null){
				Map<String, String> mapVO = mstConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RenewalMasterDataMgtDBDAOSearchAuthorityCarrierListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AuthorityCarrierVO .class);
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
	 * Financial Affairs Matrix 조회.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param MstConditionVO mstConditionVO
	 * @return List<FinancialAffairsMtxVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<FinancialAffairsMtxVO> searchFinancialAffairsMtxList(MstConditionVO mstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FinancialAffairsMtxVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mstConditionVO != null){
				Map<String, String> mapVO = mstConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RenewalMasterDataMgtDBDAOSearchFinancialAffairsMtxListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FinancialAffairsMtxVO .class);
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
	 * 하위 테이블 Carrier 사용여부.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param CarrierVO carrierVO
	 * @return String
	 * @exception EventException
	 */
	public String checkCarrierUsed(CarrierVO carrierVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(carrierVO != null){
				Map<String, String> mapVO = carrierVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalMasterDataMgtDBDAOCheckCarrierUsedRSQL(),param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("EXIST_FLG");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}

	/**
	 * Carrier 존재 여부.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param CarrierVO carrierVO
	 * @return String
	 * @exception EventException
	 */
	public String checkExistCarrier(CarrierVO carrierVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(carrierVO != null){
				Map<String, String> mapVO = carrierVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalMasterDataMgtDBDAOCheckExistCarrierRSQL(),param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("EXIST_FLG");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}

	/**
	 * Carrier Insert
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param CarrierVO carrierVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCarrier(CarrierVO carrierVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = carrierVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalMasterDataMgtDBDAOAddCarrierCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Carrier 수정
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param CarrierVO carrierVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyCarrier(CarrierVO carrierVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = carrierVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalMasterDataMgtDBDAOModifyCarrierUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Carrier 삭제.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param CarrierVO carrierVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCarrier(CarrierVO carrierVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = carrierVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			//joo_stl_itm 입력
			int result = sqlExe.executeUpdate((ISQLTemplate)new RenewalMasterDataMgtDBDAORemoveCarrierDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Authority Carrier에 존재 여부
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param AuthorityCarrierVO authorityCarrierVO
	 * @return String
	 * @exception EventException
	 */
	public String checkExistAuthorityCarrier(AuthorityCarrierVO authorityCarrierVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(authorityCarrierVO != null){
				Map<String, String> mapVO = authorityCarrierVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalMasterDataMgtDBDAOCheckExistAuthorityCarrierRSQL(),param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("EXIST_FLG");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}
	
	/**
	 * Authority Carrier 삭제.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param AuthorityCarrierVO authorityCarrierVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeAuthorityCarrier(AuthorityCarrierVO authorityCarrierVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = authorityCarrierVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			//joo_stl_itm 입력
			int result = sqlExe.executeUpdate((ISQLTemplate)new RenewalMasterDataMgtDBDAORemoveAuthorityCarrierDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Financial Affairs Matrix Carrier에 존재 여부
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param FinancialAffairsMtxVO financialAffairsMtxVO
	 * @return String
	 * @exception EventException
	 */
	public String checkExistFinancialAffairsMtx(FinancialAffairsMtxVO financialAffairsMtxVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(financialAffairsMtxVO != null){
				Map<String, String> mapVO = financialAffairsMtxVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalMasterDataMgtDBDAOCheckExistFinancialAffairsMtxRSQL(),param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("EXIST_FLG");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}
	
	/**
	 * Financial Affairs Mtx 삭제.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param FinancialAffairsMtxVO financialAffairsMtxVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeFinancialAffairsMtx(FinancialAffairsMtxVO financialAffairsMtxVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = financialAffairsMtxVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			//joo_stl_itm 입력
			int result = sqlExe.executeUpdate((ISQLTemplate)new RenewalMasterDataMgtDBDAORemoveFinancialAffairsMtxDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Stl Bss Port 삭제.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param SettlementBssPortVO settlementBssPortVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeStlBssPort(SettlementBssPortVO settlementBssPortVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = settlementBssPortVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			//joo_stl_itm 입력
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalMasterDataMgtDBDAORemoveStlBssPortDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Auto Financial Affairs Matrix by carrier 조회.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param CarrierVO carrierVO
	 * @return List<FinancialAffairsMtxVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<FinancialAffairsMtxVO> searchAutoFinancialAffairsMtxByCarrier(CarrierVO carrierVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FinancialAffairsMtxVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(carrierVO != null){
				Map<String, String> mapVO = carrierVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RenewalMasterDataMgtDBDAOSearchAutoFinancialAffairsMtxByCarrierRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FinancialAffairsMtxVO .class);
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
	 * Financial Affairs Matrix Insert
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param FinancialAffairsMtxVO financialAffairsMtxVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addFinancialAffairsMtx(FinancialAffairsMtxVO financialAffairsMtxVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = financialAffairsMtxVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalMasterDataMgtDBDAOAddFinancialAffairsMtxCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Financial Affairs Matrix 수정
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param FinancialAffairsMtxVO financialAffairsMtxVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyFinancialAffairsMtx(FinancialAffairsMtxVO financialAffairsMtxVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = financialAffairsMtxVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalMasterDataMgtDBDAOModifyFinancialAffairsMtxUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Financial Affairs Matrix 수정
	 * LOCL_CURR_CD 데이타만 Update 한다.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param FinancialAffairsMtxVO financialAffairsMtxVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyFinancialAffairsMtxAllCurrency(FinancialAffairsMtxVO financialAffairsMtxVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = financialAffairsMtxVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalMasterDataMgtDBDAOModifyFinancialAffairsMtxAllCurrencyUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * Financial Affairs Matrix LOC_CD, AP_CTR_CD  조회
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param MstConditionVO mstConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchFinancialAffairsMtxOffice(MstConditionVO mstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(mstConditionVO != null){
				Map<String, String> mapVO = mstConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalMasterDataMgtDBDAOSearchFinancialAffairsMtxOfficeRSQL(),param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("OFF_CDS");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}


	/**
	 * Financial Affairs Matrix Check Local Currency  조회
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param CarrierVO carrierVO
	 * @return String
	 * @exception EventException
	 */
	public String checkFinancialAffairsMtxCurrency(CarrierVO carrierVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(carrierVO != null){
				Map<String, String> mapVO = carrierVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RenewalMasterDataMgtDBDAOCheckFinancialAffairsMtxCurrencyRSQL(),param, velParam);
			while (dbRowset.next()) {
				rtnStr = dbRowset.getString("CHK_FLG");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}

	/**
	 * Authority Carrier Insert
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param AuthorityCarrierVO authorityCarrierVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAuthorityCarrier(AuthorityCarrierVO authorityCarrierVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = authorityCarrierVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalMasterDataMgtDBDAOAddAuthorityCarrierCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Authority Carrier  수정
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param AuthorityCarrierVO authorityCarrierVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyAuthorityCarrier(AuthorityCarrierVO authorityCarrierVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = authorityCarrierVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RenewalMasterDataMgtDBDAOModifyAuthorityCarrierUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Financial Affairs Matrix Create 조회.
	 * 2016.05.13 Renewal Add.
	 * 
	 * @param MstConditionVO mstConditionVO
	 * @return List<FinancialAffairsMtxVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<FinancialAffairsMtxVO> calculateFinancialAffairsMtxList(MstConditionVO mstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FinancialAffairsMtxVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mstConditionVO != null){
				Map<String, String> mapVO = mstConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RenewalMasterDataMgtDBDAOCalculateFinancialAffairsMtxListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FinancialAffairsMtxVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}
