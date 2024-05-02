/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableCommonDBDAO.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopSupplierListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.APPeriodVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARAcctListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARCustomerVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARExrateVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.AROfficeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARRhqListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARRhqOfficeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.AcctTypeVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ApOfficeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.BankListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.CreditCustomerVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.CurrencyCodeVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.MiscLimitCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.OfficeAddInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.OtsSourceExcludeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.PayGroupInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.PaymentLetterMDMInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.PaymentLetterTitVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.PopCustomerListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ReceiptBankListCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.RevAcctMatrixInfoCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.RevAcctMatrixInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.StmOfcInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.VendorInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterByEmailFaxVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SarOtsHdrVO;

/**
 * AccountReceivableCommonDBDAO <br>
 * - AccountReceivableCommon system Business Logic<br>
 *
 * @author
 * @see AccountReceivableCommonBCImpl
 * @since J2EE 1.4
 */
public class AccountReceivableCommonDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	private String dataSource = "";
	/**
	 * AccountReceivableCommonDBDAO object creation<br>
	 * AccountReceivableCommonDBDAO creation<br>
	 */
	public AccountReceivableCommonDBDAO() { }

	/**
	 * AccountReceivableCommonDBDAO object creation<br>
	 * AccountReceivableCommonDBDAO creation<br>
	 * @param String dataSource
	 */
	public AccountReceivableCommonDBDAO(String dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Search VVD exchange rate<br>
	 *
	 * @param ARExrateVO arExrateVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchVVDExrate(ARExrateVO arExrateVO) throws DAOException {
		DBRowSet dbRowset = null;
		String exrate = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = arExrateVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchVVDExrateRSQL(), param, velParam);
			if(dbRowset.next()){
				exrate = dbRowset.getString("exrate");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return exrate;
	}

	/**
	 * Search Individual exchange rate<br>
	 *
	 * @param ARExrateVO arExrateVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchIndExrate(ARExrateVO arExrateVO) throws DAOException {
		DBRowSet dbRowset = null;
		String exrate = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = arExrateVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchIndExrateRSQL(), param, velParam);
			if(dbRowset.next()){
				exrate = dbRowset.getString("exrate");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return exrate;
	}

	/**
	 * Search Daily exchange rate<br>
	 *
	 * @param ARExrateVO arExrateVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchDailyExrate(ARExrateVO arExrateVO) throws DAOException {
		DBRowSet dbRowset = null;
		String exrate = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = arExrateVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchDailyExrateRSQL(), param, velParam);
			if(dbRowset.next()){
				exrate = dbRowset.getString("exrate");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return exrate;
	}

	/**
	 * Search Account exchange rate<br>
	 *
	 * @param ARExrateVO arExrateVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAccountExrate(ARExrateVO arExrateVO) throws DAOException {
		DBRowSet dbRowset = null;
		String exrate = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = arExrateVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchAccountExrateRSQL(), param, velParam);
			if(dbRowset.next()){
				exrate = dbRowset.getString("exrate");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return exrate;
	}

	/**
	 * Search Effective Date<br>
	 *
	 * @param String effDt
	 * @param String ofcCd
	 * @param String sysDivCd
	 * @param String arApDivCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchEffectiveDate(String effDt, String ofcCd, String sysDivCd, String arApDivCd) throws DAOException {
		DBRowSet dbRowset = null;
		String newEffDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("eff_dt", effDt);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("sys_div_cd", sysDivCd);
			mapVO.put("ar_ap_div_cd", arApDivCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchEffectiveDateRSQL(), param, velParam);
			if(dbRowset.next()){
				newEffDt = dbRowset.getString("new_eff_dt");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return newEffDt;
	}


	/**
	 * Search Effective Date<br>
	 *
	 * @param String effDt
	 * @param String ofcCd
	 * @param String sysDivCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchEffectiveDate(String effDt, String ofcCd, String sysDivCd) throws DAOException {
		return searchEffectiveDate(effDt, ofcCd, sysDivCd, "R");
	}

	/**
	 * Search Effective Date<br>
	 *
	 * @param String ofcCd
	 * @param String sysDivCd
	 * @param String arApDivCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchMinEffectiveDate(String ofcCd, String sysDivCd, String arApDivCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("sys_div_cd", sysDivCd);
			mapVO.put("ar_ap_div_cd", arApDivCd);


			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchMinEffectiveDateRSQL(), param, velParam);

			String ofcGlDate = "";
			String rhqGlDate = "";
			//OFC G/L date is a priority.
			while(dbRowset.next()){
				String glType = dbRowset.getString("GL_TYPE");
				String glDate = dbRowset.getString("GL_DATE");
				if ("OFC".equals(glType)  && !StringUtils.isEmpty(glDate)) {
					ofcGlDate = glDate;
				} else if ("RHQ".equals(glType)  && !StringUtils.isEmpty(glDate)) {
					rhqGlDate = glDate;
				}
			}

			if (!StringUtils.isEmpty(ofcGlDate)) {
				return ofcGlDate;
			}

			if (!StringUtils.isEmpty(rhqGlDate)) {
				return rhqGlDate;
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return "";
	}


	/**
	 * Search Office Info<br>
	 *
	 * @param String usrOfcCd
	 * @return AROfficeListVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public AROfficeListVO searchOfficeInfo(String usrOfcCd) throws DAOException {
		return searchOfficeInfo(usrOfcCd, "");
	}



	/**
	 * Search Office Info<br>
	 * @author jinyoonoh 2014. 4. 8.
	 * @param String usrOfcCd
	 * @param String ofcLvlTp
	 * @return AROfficeListVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AROfficeListVO searchOfficeInfo(String usrOfcCd, String ofcLvlTp) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROfficeListVO> list = null;
		AROfficeListVO arOfficeListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("usr_ofc_cd", usrOfcCd);
		    mapVO.put("ofc_lvl_tp", ofcLvlTp);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchOfficeInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROfficeListVO .class);

			if (list != null && list.size() > 0) {
				arOfficeListVO = list.get(0);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arOfficeListVO;
	}

	/**
	 * Search Office Info<br>
	 * @author jinyoonoh 2014. 4. 8.
	 * @param String usrOfcCd
	 * @param String ofcLvlTp
	 * @param String ofcBrncAgnTpCd
	 * @return AROfficeListVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AROfficeListVO searchOfficeInfo(String usrOfcCd, String ofcLvlTp, String ofcBrncAgnTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROfficeListVO> list = null;
		AROfficeListVO arOfficeListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("usr_ofc_cd", usrOfcCd);
		    mapVO.put("ofc_lvl_tp", ofcLvlTp);
		    mapVO.put("ofc_brnc_agn_tp_cd", ofcBrncAgnTpCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchOfficeInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROfficeListVO .class);

			if (list != null && list.size() > 0) {
				arOfficeListVO = list.get(0);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arOfficeListVO;
	}


	/**
	 * Search MDM Office & SCO Office
	 *
	 * @author jinyoonoh 2014. 7. 1.
	 * @param String ofcCd
	 * @return StmOfcInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public StmOfcInfoVO searchStmOfcInfo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<StmOfcInfoVO> list = null;
		StmOfcInfoVO stmOfcInfoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("")
					.executeQuery(
							new AccountReceivableCommonDBDAOSearchStmOfcInfoRSQL(),
							param, velParam);
			list = (List) RowSetUtil
					.rowSetToVOs(dbRowset, StmOfcInfoVO.class);

			if (list != null && list.size() > 0) {
				stmOfcInfoVO = list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return stmOfcInfoVO;
	}

	/**
	 * Search Office in RHQ List<br>
	 *
	 * @param String usrRhqCd
	 * @return List<ARRhqOfficeListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARRhqOfficeListVO> searchARRhqOfficeList(String usrRhqCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARRhqOfficeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("ar_rhq_cd", usrRhqCd);
		    param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchARRhqOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARRhqOfficeListVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Search AR RHQ List<br>
	 *
	 * @param String usrRhqCd
	 * @return List<ARRhqListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARRhqListVO> searchARRhqList(String usrRhqCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARRhqListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("rhq_cd", usrRhqCd);
		    param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchARRhqListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARRhqListVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}


	/**
	 * Search AR Acount List<br>
	 *
	 * @param String usrAcctCd
	 * @return List<ARAcctListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARAcctListVO> searchARAcctList(String usrAcctCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARAcctListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("acct_cd", usrAcctCd);
		    param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchARAcctListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARAcctListVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Search AR Office List<br>
	 *
	 * @param AROfficeListVO arOfficeListVO
	 * @return List<AROfficeListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROfficeListVO> searchAROfficeList(AROfficeListVO arOfficeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROfficeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  arOfficeListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchAROfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROfficeListVO.class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Search Agent Office List<br>
	 *
	 * @param AROfficeListVO arOfficeListVO
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchAgentOffice(AROfficeListVO arOfficeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  arOfficeListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchAgentOfficeRSQL(), param, velParam);
			while(dbRowset.next()) {
				list.add(dbRowset.getString("agt_ofc_cd"));
	    	}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Search Account Type List<br>
	 *
	 * @param String acctCtnt
	 * @param String acctCtnt2
	 * @param String acctCtnt3
	 * @param String acctCtnt4
	 * @param String ofcCd
	 * @return List<AcctTypeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AcctTypeVO> searchAccountType(String acctCtnt, String acctCtnt2, String acctCtnt3, String acctCtnt4, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<AcctTypeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("acct_ctnt", acctCtnt);
			mapVO.put("acct_ctnt2", acctCtnt2);
			mapVO.put("acct_ctnt3", acctCtnt3);
			mapVO.put("acct_ctnt4", acctCtnt4);
			mapVO.put("ofc_cd", ofcCd);		//2014.08.19 add ofc_cd

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchAccountTypeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AcctTypeVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Search AR Customer List<br>
	 *
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String custUseFlg
	 * @return ARCustomerVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ARCustomerVO searchARCustomer(String custCntCd, String custSeq, String custUseFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARCustomerVO> list = null;
		ARCustomerVO arCustomerVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cust_cnt_cd", custCntCd);
			mapVO.put("cust_seq", custSeq);
			mapVO.put("cust_use_flg", custUseFlg);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchARCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARCustomerVO .class);

			if (list != null && list.size() > 0) {
				arCustomerVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arCustomerVO;
	}

	/**
	 * Search Local Time<br>
	 *
	 * @param String lOfcCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchLocalTime(String lOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String lclTime = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("l_ofc_cd", lOfcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOSearchLocalTimeRSQL(), param, velParam);
			while(dbRowset.next()) {
				lclTime = dbRowset.getString("lcl_time");
	    	}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return lclTime;
	}

	/**
	 * Search Local Time<br>
	 *
	 * @param String lOfcCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchLocalTimeYMDHMS(String lOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String lclTime = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("l_ofc_cd", lOfcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOSearchLocalTimeYMDHMSRSQL(), param, velParam);
			while(dbRowset.next()) {
				lclTime = dbRowset.getString("lcl_time");
	    	}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return lclTime;
	}

	/**
     * AP Office Code Popup <br>
     *
     * @author SWJEON
     * @category STM_SAP_0001
     * @category searchPopAPOfficeList
     * @param String ofcCd
     * @return List<ApOfficeListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ApOfficeListVO> searchPopAPOfficeList(String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;

        List<ApOfficeListVO> list = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {

          	 param.put("ofc_cd", ofcCd);     // where 議곌굔, where office_code = @ [ofc_cd]

         	 velParam.put("ofc_cd", ofcCd);  // 荑쇰━�먯꽌 if 臾��ъ슜���ъ슜�쒕떎.

             dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOSearchPopAPOfficeListRSQL(), param, velParam); // 臾몄꽌 李멸퀬
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApOfficeListVO.class);
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
     * Supplier Code Popup<br>
     *
     * @author MCJung 2014.03.18
     * @category STM_SAP_0002
     * @category searchPopSupplierList
     * @param String vendorName
     * @param String vendorCode
     * @param String enableFlag
     * @return List<PopSupplierListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PopSupplierListVO> searchPopSupplierList(String vendorName,	String vendorCode, String enableFlag) throws DAOException {
        DBRowSet dbRowset = null;

        List<PopSupplierListVO> list = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {

        	param.put("vndr_lgl_eng_nm", vendorName);
            velParam.put("vndr_lgl_eng_nm", vendorName);
            param.put("vndr_seq", vendorCode);
            velParam.put("vndr_seq", vendorCode);
            param.put("delt_flg", enableFlag);
            velParam.put("delt_flg", enableFlag);

            dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOSearchPopSupplierListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PopSupplierListVO.class);
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
	 * Search Bank List<br>
	 *
	 * @param String rctTpCd
	 * @param String rctOfcCd
	 * @param String bankCtrlCd
	 * @param String bankAcctNm
	 * @param String localCurrCd
	 * @return List<BankListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BankListVO> searchBankList(String rctTpCd, String rctOfcCd, String bankCtrlCd, String bankAcctNm, String localCurrCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BankListVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rct_tp_cd", rctTpCd);
			mapVO.put("rct_ofc_cd", rctOfcCd);
			mapVO.put("bank_ctrl_cd", bankCtrlCd);
			mapVO.put("bank_acct_nm", bankAcctNm);
			mapVO.put("local_curr_cd", localCurrCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchBankListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BankListVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Search Receipt Bank List<br>
	 *
	 * @param ReceiptBankListCondVO receiptBankListCondVO
	 * @return List<BankListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BankListVO> searchReceiptBankList(ReceiptBankListCondVO receiptBankListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BankListVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = receiptBankListCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOSearchReceiptBankListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BankListVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Search Currency Code List<br>
	 *
	 * @param String currCd
	 * @return List<CurrencyCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CurrencyCodeVO> searchCurrencyCode(String currCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CurrencyCodeVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("curr_cd", currCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchCurrencyCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CurrencyCodeVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Search New Adjust, Receipt No<br>
	 *
	 * @param String ajTjTpCd
	 * @param String ofcCd
	 * @param String lclTime
	 * @param String lOfcCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAdjustReceiptNo(String ajTjTpCd, String ofcCd, String lclTime, String lOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String adjustReceiptNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("aj_tj_tp_cd", ajTjTpCd);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("usr_id", lclTime);
			mapVO.put("l_ofc_cd", lOfcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchAdjustReceiptNoRSQL(), param, velParam);
			while(dbRowset.next()) {
				adjustReceiptNo = dbRowset.getString("adj_rec_no");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return adjustReceiptNo;
	}

	/**
	 * Insert New Adjust, Receipt No<br>
	 *
	 * @param String ajTjTpCd
	 * @param String ofcCd
	 * @param String lclTime
	 * @param String lOfcCd
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addAdjustReceiptNo(String ajTjTpCd, String ofcCd, String lclTime, String lOfcCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("aj_tj_tp_cd", ajTjTpCd);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("usr_id", lclTime);
			mapVO.put("l_ofc_cd", lOfcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new AccountReceivableCommonDBDAOaddAdjustReceiptNoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Insert Local Receipt No<br>
	 *
	 * @param String ajTjTpCd
	 * @param String ofcCd
	 * @param String lclTime
	 * @param String lOfcCd
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addAdjustReceiptNoLocal(String ajTjTpCd, String ofcCd, String lclTime, String lOfcCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("aj_tj_tp_cd", ajTjTpCd);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("usr_id", lclTime);
			mapVO.put("l_ofc_cd", lOfcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new AccountReceivableCommonDBDAOaddAdjustReceiptNoLocalCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Update New Adjust, Receipt No<br>
	 *
	 * @param String ajTjTpCd
	 * @param String ofcCd
	 * @param String lclTime
	 * @param String lOfcCd
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyAdjustReceiptNo(String ajTjTpCd, String ofcCd, String lclTime, String lOfcCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("aj_tj_tp_cd", ajTjTpCd);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("usr_id", lclTime);
			mapVO.put("l_ofc_cd", lOfcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new AccountReceivableCommonDBDAOmodifyAdjustReceiptNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Update New Adjust, Receipt No<br>
	 *
	 * @param String ajTjTpCd
	 * @param String ofcCd
	 * @param String lclTime
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyAdjustReceiptNoLocal(String ajTjTpCd, String ofcCd, String lclTime) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("aj_tj_tp_cd", ajTjTpCd);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("usr_id", lclTime);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new AccountReceivableCommonDBDAOmodifyAdjustReceiptNoLocalUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Search Period Status<br>
	 *
	 * @param String glDt
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPeriodStatus(String glDt) throws DAOException {
		DBRowSet dbRowset = null;
		String prdStsCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("gl_dt", glDt);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchPeriodStatusRSQL(), param, velParam);
			while(dbRowset.next()) {
				prdStsCd = dbRowset.getString("prd_sts_cd");
	    	}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return prdStsCd;
	}


	/**
     * Retrieve Outstanding Source To Exclude<br>
     *
     * @return List<OtsSourceExcludeListVO>
     * @throws DAOException
     */
    public List<OtsSourceExcludeListVO> searchOtsSourceExcludeList() throws DAOException{
    	DBRowSet dbRowset = null;

        List<OtsSourceExcludeListVO> list = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {

            dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchOtsSourceExcludeListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OtsSourceExcludeListVO.class);
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
	 * Search Functional Currency<br>
	 *
	 * @param String luTpCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchFunctionalCurrency(String luTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		String funcCurr = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("lu_tp_cd", luTpCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchFunctionalCurrencyRSQL(), param, velParam);
			if(dbRowset.next()){
				funcCurr = dbRowset.getString("func_curr");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return funcCurr;
	}


    /**
	 * Search Functional Currency<br>
	 *
	 * @param String seqName
	 * @return BigDecimal
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BigDecimal getSequence(String seqName) throws DAOException {
		DBRowSet dbRowset = null;
		BigDecimal seq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("seq_name", seqName);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOgetSequenceRSQL(), param, velParam);
			if(dbRowset.next()){
				seq = dbRowset.getBigDecimal("seq");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return seq;
	}

	/**
     * Account Matrix<br><br>
     *
     * @author hee jin Park
     * @category STM_SAR_4001
     * @category searchRevAcctMatrixInfo
     * @param RevAcctMatrixInfoCondVO revAcctMatrixInfoCondVO
     * @return List<RevAcctMatrixInfoVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RevAcctMatrixInfoVO> searchRevAcctMatrixInfo(RevAcctMatrixInfoCondVO revAcctMatrixInfoCondVO) throws DAOException {
        DBRowSet dbRowset = null;

        List<RevAcctMatrixInfoVO> list = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

       try {

    	   if(revAcctMatrixInfoCondVO != null){
				Map<String, String> mapVO = revAcctMatrixInfoCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

             dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchRevAcctMatrixInfoRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevAcctMatrixInfoVO.class);
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
	 * Account Matrix - modify<br>
     *
     * @param RevAcctMatrixInfoVO revAcctMatrixInfoVO
     * @return int
     * @throws DAOException
     */
	public int modifyRevAcctMatrixInfo(RevAcctMatrixInfoVO revAcctMatrixInfoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = revAcctMatrixInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate(new AccountReceivableCommonDBDAOmodifyRevAcctMatrixInfoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}


    /**
	 * Account Matrix - insert<br>
     *
     * @param RevAcctMatrixInfoVO revAcctMatrixInfoVO
     * @return int
     * @throws DAOException
     */
	public int insertRevAcctMatrixInfo(RevAcctMatrixInfoVO revAcctMatrixInfoVO) throws DAOException,Exception {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(revAcctMatrixInfoVO != null){
				Map<String, String> mapVO = revAcctMatrixInfoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate(new AccountReceivableCommonDBDAOinsertRevAcctMatrixInfoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return result;
	}

    /**
	 * Account Type Code - Retrieve<br>
     *
     * @param RevAcctMatrixInfoCondVO revAcctMatrixInfoCondVO
     * @return List<RevAcctMatrixInfoVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RevAcctMatrixInfoVO> searchPopAccountTypeList(RevAcctMatrixInfoCondVO revAcctMatrixInfoCondVO) throws DAOException {
        DBRowSet dbRowset = null;

        List<RevAcctMatrixInfoVO> list = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

       try {

    	   if(revAcctMatrixInfoCondVO != null){
				Map<String, String> mapVO = revAcctMatrixInfoCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
             dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOSearchPopAccountTypeListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevAcctMatrixInfoVO.class);
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
	 * Check AP Period Status<br>
	 *
	 * @param String ofcCd
	 * @param String glDt
	 * @return Boolean
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Boolean checkAPPeriod(String ofcCd, String glDt) throws DAOException {
		DBRowSet dbRowset = null;
		String prdCd = "";
		Boolean chkPrd = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("gl_dt", glDt);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOCheckAPPeriodRSQL(), param, velParam);
			while(dbRowset.next()) {
				prdCd = dbRowset.getString("chk_prd");

				if(prdCd.equals("O")) chkPrd = true;
	    	}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return chkPrd;
	}

	/**
	 * Search Vendor info<br>
	 *
	 * @param String vndrNo
	 * @return VendorInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VendorInfoVO searchVendorInfo(String vndrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<VendorInfoVO> list = null;
		VendorInfoVO vendorInfoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vndr_no", vndrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOSearchVendorInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorInfoVO .class);

			if (list != null && list.size() > 0) {
				vendorInfoVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return vendorInfoVO;
	}

	/**
	 * Search pay group info<br>
	 *
	 * @param String apOfcCd
	 * @return PayGroupInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PayGroupInfoVO searchPayGroupInfo(String apOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<PayGroupInfoVO> list = null;
		PayGroupInfoVO payGroupInfoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ap_ofc_cd", apOfcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOSearchPayGroupInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PayGroupInfoVO .class);

			if (list != null && list.size() > 0) {
				payGroupInfoVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return payGroupInfoVO;
	}


	/**
	 * search g/l date
	 * @param APPeriodVO apPeriodVO
	 * @return List<APPeriodVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<APPeriodVO> searchAPPreriod(APPeriodVO apPeriodVO) throws DAOException {

		DBRowSet dbRowset = null;

		List<APPeriodVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = apPeriodVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							new AccountReceivableCommonDBDAOSearchAPPeriodRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					APPeriodVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * Search MDM Charge List<br>
	 *
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchMDMChargeList() throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOSearchMDMChargeListRSQL(), param, velParam);
			while(dbRowset.next()) {
				list.add(dbRowset.getString("chg_cd"));
	    	}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}


	/**
	 * Update SAR_OTS_HDR
	 * @author jinyoonoh 2014. 7. 4.
	 * @param SarOtsHdrVO paramVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifySarOtsHdr(SarOtsHdrVO paramVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = paramVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new AccountReceivableCommonDBDAOModifySarOtsHdrUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Check MI/ML Limit Amount<br>
	 *
	 * @author sungyong park 2014.08.25
	 * @param MiscLimitCondVO miscLimitCondVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String checkMiscLimitAmount(MiscLimitCondVO miscLimitCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String chkMiscLmt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = miscLimitCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOCheckMiscLimitAmountRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("cnt") > 0) chkMiscLmt = "Y";
				else chkMiscLmt = "N";
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return chkMiscLmt;
	}

	/**
	 * Search MDM Charge List<br>
	 * @param PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO
	 * @return PaymentLetterMDMInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PaymentLetterMDMInfoVO searchMDMinfo(PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PaymentLetterMDMInfoVO> list = null;
		PaymentLetterMDMInfoVO paymentLetterMDMInfoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = paymentRequestLetterByEmailFaxVO.getColumnValues();

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		try{
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchMDMinfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PaymentLetterMDMInfoVO.class);
			if(list.size() > 0){
				paymentLetterMDMInfoVO =  list.get(0);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return paymentLetterMDMInfoVO;
	}

	/**
	 * Search MDM Charge List<br>
	 * @param PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO
	 * @return PaymentLetterTitVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PaymentLetterTitVO searchPaymentLetterTit(PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PaymentLetterTitVO> list = null;
		PaymentLetterTitVO paymentLetterTitVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = paymentRequestLetterByEmailFaxVO.getColumnValues();

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		try{
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchPaymentLetterTitRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PaymentLetterTitVO.class);
			if(list.size() > 0){
				paymentLetterTitVO =  list.get(0);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return paymentLetterTitVO;
	}

	/**
	 * Search New Adjust, Receipt No<br>
	 *
	 * @param String ajTjTpCd
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAdjustReceiptNoLocal(String ajTjTpCd, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String adjustReceiptNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("aj_tj_tp_cd", ajTjTpCd);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOSearchAdjustReceiptNoLocalRSQL(), param, velParam);
			while(dbRowset.next()) {
				adjustReceiptNo = dbRowset.getString("adj_rec_no");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return adjustReceiptNo;
	}

	/**
	 * Search New Adjust, Receipt No<br>
	 *
	 * @param String ajTjTpCd
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAdjustReceiptNoLocalNoLock(String ajTjTpCd, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String adjustReceiptNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("aj_tj_tp_cd", ajTjTpCd);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchAdjustReceiptNoLocalNoLockRSQL(), param, velParam);
			while(dbRowset.next()) {
				adjustReceiptNo = dbRowset.getString("adj_rec_no");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return adjustReceiptNo;
	}

	/**
	 * Search Ctrl Office List<br>
	 *
	 * @param AROfficeListVO arOfficeListVO
	 * @return List<AROfficeListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROfficeListVO> searchCtrlOfficeList(AROfficeListVO arOfficeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROfficeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  arOfficeListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchCtrlOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROfficeListVO.class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Search Ctrl Office List<br>
	 *
	 * @param String arOfcCd
	 * @param String otsCd
	 * @param String ctrlOfcCd
	 * @return List<AROfficeListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROfficeListVO> searchControlOfficeListByRep(String arOfcCd,String otsCd,String ctrlOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROfficeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("ots_cd", otsCd);
			mapVO.put("ctrl_ofc_cd", ctrlOfcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchControlOfficeListByRepRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROfficeListVO.class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * CUSTOMER 테이블에 Customer code or 사업자등록번호(주민등록번호)로 정보를 조회한다.<br>
	 *
	 * @author Dong Hoon Han
	 * @param String country
	 * @param String cust
	 * @param String regNo
	 * @return CreditCustomerVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CreditCustomerVO searchCreditCustomer(String country, String cust, String regNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CreditCustomerVO> list = null;
		CreditCustomerVO creditCustomerVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("frm_cust_cnt_cd", country);
			mapVO.put("frm_cust_rgst_no", regNo);
			mapVO.put("frm_cust_seq", cust);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchCreditCustomerRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CreditCustomerVO.class);
			if (list != null && list.size() > 0) {
				creditCustomerVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return creditCustomerVO;
	}

	/**
	 * MDM_CUSTOMER 테이블에 Cntry code, Customer Name, Zipcode로 조회한다.<br>
	 *
	 * @author Dong Hoon Han
	 * @param String cntry
	 * @param String custNm
	 * @param String zipNo
	 * @param String chkNm
	 * @param String custRgstNo
	 * @return List<PopCustomerListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PopCustomerListVO> searchPopCustomerList(String cntry, String custNm, String zipNo, String chkNm, String custRgstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PopCustomerListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			StringTokenizer st = new StringTokenizer(custNm, " ");
			String custNm1 = "";
			String custNm2 = "";
			String custNm3 = "";
			int i = 1;
			while (st.hasMoreTokens()) {
				if(i==1){
					custNm1 = st.nextToken();
				}else if(i==2){
					custNm2 = st.nextToken();
				}else if(i==3){
					custNm3 = st.nextToken();
				}
				i++;
			}
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cust_cnt_cd", cntry);
			mapVO.put("cust_lgl_eng_nm", custNm);
			mapVO.put("cust_lgl_eng_nm1", custNm1);
			mapVO.put("cust_lgl_eng_nm2", custNm2);
			mapVO.put("cust_lgl_eng_nm3", custNm3);
			mapVO.put("zip_cd", zipNo);
			mapVO.put("chk_nm", chkNm);
			mapVO.put("cust_rgst_no", custRgstNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchPopCustomerListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PopCustomerListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Search AR Office List<br>
	 *
	 * @param AROfficeListVO arOfficeListVO
	 * @return List<AROfficeListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROfficeListVO> searchAROfficePlusRepList(AROfficeListVO arOfficeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROfficeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  arOfficeListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchAROfficePlusRepListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROfficeListVO.class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * search AcctXchRtDt <br>
	 *
	 * @param String ym
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAcctXchRtDt(String ym) throws DAOException {
		DBRowSet dbRowset = null;
		String exrate = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ym", ym);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchAcctXchRtDtRSQL(), param, velParam);
			if(dbRowset.next()){
				exrate = dbRowset.getString("acct_xch_rt_dt");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return exrate;
	}

	/**
	 * Search Office additioal Info<br>
	 * @param String usrOfcCd
	 * @return OfficeAddInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public OfficeAddInfoVO searchIsHiddenInoice(String usrOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeAddInfoVO> list = null;
		OfficeAddInfoVO officeAddInfoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("ofc_cd", usrOfcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOsearchIsHiddenInoiceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeAddInfoVO .class);

			if (list != null && list.size() > 0) {
				officeAddInfoVO = list.get(0);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return officeAddInfoVO;
	}
	
	/**
	 * searchLoginUserOfcType <br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchLoginUserOfcType(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOSearchLoginUserOfcTypeRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnStr = dbRowset.getString("OFC_TP_CD");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr;
	}	
	
	/**
	 * searchLoginUserEml <br>
	 *
	 * @param String usrId
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchLoginUserEml(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("usr_id", usrId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableCommonDBDAOSearchLoginUserEmlRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnStr = dbRowset.getString("USR_EML");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnStr;
	}	
}
