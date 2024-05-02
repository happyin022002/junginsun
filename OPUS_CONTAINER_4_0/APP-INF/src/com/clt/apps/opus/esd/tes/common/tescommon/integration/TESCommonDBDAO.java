/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESCommonDBDAO.java
*@FileTitle : TES Common 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-31 byungheeyoo
* 1.0 최초 생성
* 2009-03-03 : 성능측정 관련 기능 추가
* 2009-05-08 : Office change기능 추가로 인해 session의 ofc_cd를 기준으로 (session이 아닌) MDM의 cnt_cd를 조회  method 추가
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tescommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.tes.common.tescommon.basic.TESCommonBCImpl;
import com.clt.apps.opus.esd.tes.common.tescommon.event.TESCommonEvent;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TesJbExePerfLogVO;


/**
 * ESD에 대한 DB 처리를 담당<br>
 * ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author byungheeyoo
 * @see TESCommonBCImpl 참조
 * @since J2EE 1.4
 */
public class TESCommonDBDAO extends DBDAOSupport {

	/**
	 * 2009-05-08 : Office change기능 추가로 인해 session의 ofc_cd를 기준으로 (session이 아닌) MDM의 cnt_cd를 조회
	 * @param ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String getMDMCnt_cd(String ofcCd) throws DAOException {
		log.debug("\n[TESCommonDBDAO][getMDMCnt_cd] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String	cntCd	= "";
		
		try {

			if ( ofcCd != null && !"".equals(ofcCd) ) {
				param	.put("ofc_cd", ofcCd);
				velParam.put("ofc_cd", ofcCd);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOGetMDMCnt_cdRSQL(), param, velParam);

			if ( dbRowset.next() ){
				cntCd = dbRowset.getString("cnt_cd");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		log.debug("\n DAO.getMDMCnt_cd \n");

		return JSPUtil.getNull(cntCd);		
	}

	
	/**
	 * Cost Office Code 조회
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCostOFC(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchCostOFC] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals( event.getMdmYardVO().getYdCd() ) ) {
				param.put("yd_cd", event.getMdmYardVO().getYdCd() );
				velParam.put("yd_cd", event.getMdmYardVO().getYdCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchCostOFCRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/** searchEQNo
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEQNo(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchEQNo] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals( event.getTesCommonVO().getEqNo() ) ) {
				param.put("eq_no", event.getTesCommonVO().getEqNo());
				velParam.put("eq_no", event.getTesCommonVO().getEqNo());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchEQNoRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}	
	/**
	 * validate Cost Office Code
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateCostOFC(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][validateCostOFC]\n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try {

			if ( !"".equals( event.getTesTmlSoHdrVO().getCostOfcCd() ) ) {
				param.put("cost_ofc_cd", event.getTesTmlSoHdrVO().getCostOfcCd() );
				velParam.put("cost_ofc_cd", event.getTesTmlSoHdrVO().getCostOfcCd() );
			}
			
			if ( !"".equals( event.getMdmYardVO().getYdCd() ) ) {
				param.put("yd_cd", event.getMdmYardVO().getYdCd() );
				velParam.put("yd_cd", event.getMdmYardVO().getYdCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOValidateCostOFCRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * validate Cost Office Code
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateCostOFC2(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][validateCostOFC2] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO	= event.getTesTmlSoHdrVO().getColumnValues();
			
			if ( mapVO != null ) {

				if ( !"".equals( mapVO.get("cost_ofc_cd") ) ) {
					param.put("cost_ofc_cd", mapVO.get("cost_ofc_cd") );
					velParam.put("cost_ofc_cd", mapVO.get("cost_ofc_cd") );
				}
				
				if ( !"".equals( mapVO.get("yd_cd") ) ) {
					param.put("yd_cd", mapVO.get("yd_cd") );
					velParam.put("yd_cd", mapVO.get("yd_cd") );
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOValidateCostOFC2RSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * validate Yard Code
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateYardCode(TESCommonEvent event) throws DAOException {
		
		log.debug("\n[TESCommonDBDAO][validateYardCode \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if ( !"".equals( event.getMdmYardVO().getYdCd() ) ) {
				param.put("yd_cd", event.getMdmYardVO().getYdCd() );
				velParam.put("yd_cd", event.getMdmYardVO().getYdCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOValidateYardCodeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * validate Yard Code ( Delt_flg )
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateYardCode2(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][validateYardCode2] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if ( !"".equals( event.getMdmYardVO().getYdCd() ) ) {
				param.put("yd_cd", event.getMdmYardVO().getYdCd() );
				velParam.put("yd_cd", event.getMdmYardVO().getYdCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOValidateYardCode2RSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * TES 내에 미존재 (2009-07-07)
	 * @param event 
	 * @return String
	 * @exception DAOException
	 */
	public String searchOrganizationCurrencyCode(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchOrganizationCurrencyCode] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String		arCurrCd	= "";

		try {
			if ( !"".equals( event.getTesCommonVO().getInvOfcCd() ) ) {
				param.put("inv_ofc_cd", event.getTesCommonVO().getInvOfcCd() );
				velParam.put("inv_ofc_cd", event.getTesCommonVO().getInvOfcCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchOrganizationCurrencyCodeRSQL(), param, velParam);

			log.debug("\n dRs.getRow:"+dbRowset.getRow() + " - dRs.getRowCount:"+ dbRowset.getRowCount()+"\n");
			
			while (dbRowset.next()){
				arCurrCd = dbRowset.getString("AR_CURR_CD"); //일단 하나라는 전제에 작업
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return arCurrCd;
	}

	/**
	 * Currency List(통화) 조회
	 * @param event 
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCurrencyList(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchCurrencyList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals( event.getSignOnUserAccount().getOfc_cd() ) ) {
				param.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
				velParam.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchCurrencyListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}



	/**
	 * Node Code 조회
	 * @param TESCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet getNodeCode(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][getNodeCode] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if( !"".equals( event.getMdmYardVO().getLocCd() ) ) {
				param.put("loc_cd", event.getMdmYardVO().getLocCd());
				velParam.put("loc_cd", event.getMdmYardVO().getLocCd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOGetNodeCodeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
	}

	/**
	 * OFC LOCAL Date Time 조회
	 * @param TESCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchDBdate(TESCommonEvent event) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			log.debug("\n[TESCommonDBDAO][searchDBdate][] - ofc_cd : " + event.getSignOnUserAccount().getOfc_cd()+"\n");

			if ( !"".equals( event.getSignOnUserAccount().getOfc_cd() ) ) {
				param.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
				velParam.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchDBdateRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return dbRowset;
	}

	/**
	 *  validate Vendor Seq Code
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateVndrCode(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][validateVndrCode] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals( event.getTesTmlSoHdrVO().getVndrSeq() ) ) {
				param.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );
				velParam.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOValidateVndrCodeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * validate Vendor Seq Code ( Delt_flg )
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateVndrCode2(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][validateVndrCode2] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if ( !"".equals( event.getTesTmlSoHdrVO().getVndrSeq() ) ) {
				param.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );
				velParam.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOValidateVndrCode2RSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Yard, Cost Code List Inquiry
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchYdCostCodeList(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchYdCostCodeList] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO	= event.getTesCommonVO().getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchYdCostCodeListRSQL(), param, velParam);

			log.debug("\n dRs.getRow:"+dbRowset.getRow() + " - dRs.getRowCount:"+ dbRowset.getRowCount()+"\n");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
	}

	/**
	 * validate Yard Code & Cost Code List 조회 
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateYardCodeNsearchYdCostCodeList(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][validateYardCodeNsearchYdCostCodeList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try {
			
			if ( !"".equals( event.getMdmYardVO().getYdCd() ) ) {
				param.put("yd_cd", event.getMdmYardVO().getYdCd() );
				velParam.put("yd_cd", event.getMdmYardVO().getYdCd() );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOValidateYardCodeNsearchYdCostCodeListRSQL(), param, velParam);

			log.debug("\n dRs.getRow:"+dbRowset.getRow() + " - dRs.getRowCount:"+ dbRowset.getRowCount()+"\n");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * TES Cost Code List Inquiry
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchTESCostCodeList() throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchTESCostCodeList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchTESCostCodeListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return dbRowset;
	}
	
	/** searchAgmtCostCodeList
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAgmtCostCodeList(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchAgmtCostCodeList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vndr_seq", 	event.getTesTmlSoHdrVO().getVndrSeq());
			velParam.put("vndr_seq", 	event.getTesTmlSoHdrVO().getVndrSeq());
			
			param.put("yd_cd", 	event.getTesTmlSoHdrVO().getYdCd());
			velParam.put("yd_cd", 	event.getTesTmlSoHdrVO().getYdCd());
			
			param.put("atb_dt", 	event.getTesCommonVO().getAtbDt());
			velParam.put("atb_dt", 	event.getTesCommonVO().getAtbDt());
			
			param.put("fm_prd_dt", 	event.getTesCommonVO().getFmPrdDt());
			velParam.put("fm_prd_dt", 	event.getTesCommonVO().getFmPrdDt());
			
			param.put("to_prd_dt", 	event.getTesCommonVO().getToPrdDt());
			velParam.put("to_prd_dt", 	event.getTesCommonVO().getToPrdDt());
			
			param.put("min_wrk_dt", 	event.getTesCommonVO().getMinWrkDt());
			velParam.put("min_wrk_dt", 	event.getTesCommonVO().getMinWrkDt());

			param.put("agmt_ftr_inv_tp_cd", 	event.getTesCommonVO().getAgmtFtrInvTpCd());
			velParam.put("agmt_ftr_inv_tp_cd", 	event.getTesCommonVO().getAgmtFtrInvTpCd());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchAgmtCostCodeListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return dbRowset;
	}	

	/**
	 * Container Type Cd List 조회
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCntrTPCDList() throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchCntrTPCDList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchCntrTPCDListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Container Size Cd List 조회
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCntrSZCDList() throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchCntrSZCDList] \n");

		DBRowSet				dbRowset	= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchCntrSZCDListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Container Type Size Cd List 조회
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCntrTPSZCDList() throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchCntrTPSZCDList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchCntrTPSZCDListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Lnae Code List 조회
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchLaneList(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchLaneList] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= event.getVskVslPortSkdVO().getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchLaneListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return dbRowset;
	}

	/**
	 * Invoice Auto Cost Code List 조회
	 * @param event TESCommonEvent
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAutoTESTmlSoCostCDList(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchAutoTESTmlSoCostCDList] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if ( !"".equals( event.getTesCommonVO().getCalcCostGrpCd() ) ) {
				param.put("calc_cost_grp_cd", event.getTesCommonVO().getCalcCostGrpCd() );
				velParam.put("calc_cost_grp_cd", event.getTesCommonVO().getCalcCostGrpCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchAutoTESTmlSoCostCDListRSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Invoice Manual Cost Code List 조회
	 * @param event TESCommonEvent
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchManualTESTmlSoCostCDList(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchManualTESTmlSoCostCDList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if ( !"".equals( event.getTesCommonVO().getCalcCostGrpCd() ) ) {
				param.put("calc_cost_grp_cd", event.getTesCommonVO().getCalcCostGrpCd() );
				velParam.put("calc_cost_grp_cd", event.getTesCommonVO().getCalcCostGrpCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchManualTESTmlSoCostCDListRSQL(), param, velParam);
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return dbRowset;
	}

	/**
	 * TES Common Cost Code List 조회
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchTESInvoiceCommonCodeList() throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchTESInvoiceCommonCodeList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		/**
		# yd_chr_inv_tp_cd : yard의 특성을 조회하기 위한 code값...
		1. Marine Terminal Invoice = 'MT'
		2. On-dock Rail Charge Invoice = 'ON'
		3. Off-dock CY Invoice(Terminal) = 'OT'
		4. Off-dock CY Invoice(Storage) = 'OS'
		5. Storage Invoice = 'ST'
		 */

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchTESInvoiceCommonCodeListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return dbRowset;
	}

	/**
	 * Agreement Cost Code List 조회
	 * @param event TESCommonEvent
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAgreementCostCodeList(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchAgreementCostCodeList] \n");

		DBRowSet					dbRowset	= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if( !"".equals( event.getMdmYardVO().getYdCd() ) ) {
				param.put("yd_cd", event.getMdmYardVO().getYdCd());
				velParam.put("yd_cd", event.getMdmYardVO().getYdCd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchAgreementCostCodeListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Lane Code List 조회
	 * @param event TESCommonEvent
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchLaneCodeList(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchLaneCodeList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if ( !"".equals( event.getMdmYardVO().getYdCd() ) ) {
				param.put("yd_cd", event.getMdmYardVO().getYdCd() );
				velParam.put("yd_cd", event.getMdmYardVO().getYdCd() );
			}

			if ( !"".equals( event.getTesCommonVO().getVvd() ) ) {
				param.put("vvd", event.getTesCommonVO().getVvd() );
				velParam.put("vvd", event.getTesCommonVO().getVvd() );
			}
			
			velParam.put("vsl_cd_sub", event.getTesCommonVO().getVvd().substring(0,4) );

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchLaneCodeListRSQL(), param, velParam);
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
	/**
	 * Sub Trade Code List 조회
	 * @param event TESCommonEvent
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchSubTrdCodeList(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchSubTrdCodeList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchSubTrdCodeListRSQL(), param, velParam);
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
    /** searchBkgCntrTPCDList
     * 
     * @param event
     * @return
     * @throws DAOException
     */
	public DBRowSet searchBkgCntrTPCDList(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchBkgCntrTPCDList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		
		param.put("cntr_no", event.getTesCommonVO().getCntrNo() );
		velParam.put("cntr_no", event.getTesCommonVO().getCntrNo() );

		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchBkgCntrTPCDListRSQL(), param, velParam);
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}	
	
	/**
	 * MDM Account 조회
	 * @param TESCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchMDMAccount(TESCommonEvent event) throws DAOException {
		
		log.debug("\n[TESCommonDBDAO][searchMDMAccount] \n");
		
		DBRowSet dbRowset = null;
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchMDMAccountRSQL(), null, null);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return dbRowset;
	}
	
	/**
	 * MDM Account 조회
	 * @param TESCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAuthOfcCd(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchAuthOfcCd] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO	= event.getTesCommonVO().getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );
			}
			
				
			log.debug("param cre_ofc_cd===>"+param.get("cre_ofc_cd"));
			log.debug("param agmt_no_ofc_cd===>"+param.get("no_ofc_cd"));
			log.debug("param act_tp===>"+param.get("act_tp"));
			log.debug("param yd_cd===>"+param.get("no_yd_cd"));
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchAuthOfcCdRSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return dbRowset;
	}
	
	/**
	 * 등록된 주용 기능의 성능 측정 시작용 Sequence Select
	 * @param TesJbExePerfLogVO tesJbExePerfLogVO
	 * @return String
	 * @exception DAOException
	 */
	public String beginJobExecutionPerformanceR(TesJbExePerfLogVO tesJbExePerfLogVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String				logSeq		= "";
		
		try {
			if( tesJbExePerfLogVO != null ){
				Map<String, String> mapVO = tesJbExePerfLogVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset	= new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOBeginJobExecutionPerformanceRSQL(), param, velParam);
			
			while ( dbRowset.next()) {
				logSeq	= dbRowset.getString(1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}
		
		return	logSeq;
	}

		
	/**
	 * 등록된 주용 기능의 성능 측정 시작 Insert
	 * @param TesJbExePerfLogVO	tesJbExePerfLogVO
	 * @exception DAOException
	 */
	public void beginJobExecutionPerformanceC(TesJbExePerfLogVO	tesJbExePerfLogVO) throws DAOException {
		log.debug("\n[TESCommonDBDAO][beginJobExecutionPerformance] ### \n");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if( tesJbExePerfLogVO != null ) {
				Map<String, String> mapVO = tesJbExePerfLogVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TESCommonDBDAOBeginJobExecutionPerformanceCSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}

	}
	
	/**
	 * 등록된 주용 기능의 성능 측정 마침용 
	 * @param curr_seq
	 * @param mode
	 * @exception DAOException
	 */
	public void endJobExecutionPerformance(String curr_seq, String mode) throws DAOException {
		log.debug("\n[TESCommonDBDAO][endJobExecutionPerformance - MODE:"+(mode!=null?mode:"NO MODE FOUND ERROR")+"  ### \n");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {

			if( !"".equals( mode ) ) {
				param.put("mode", mode);
			}

			if( !"".equals( curr_seq ) ) {
				param.put("exe_perf_log_seq", curr_seq);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new TESCommonDBDAOEndJobExecutionPerformanceUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

	}
	
	/**
	 * Invoice No 중복 확인
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchInvNoDupChk(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchInvNoDupChk] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals( event.getTesTmlSoHdrVO().getInvNo())) {
				param.put("inv_no", event.getTesTmlSoHdrVO().getInvNo() );
				velParam.put("inv_no", event.getTesTmlSoHdrVO().getInvNo() );
			}
			
			if ( !"".equals( event.getTesTmlSoHdrVO().getVndrSeq())) {
				param.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );
				velParam.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() ); 
			}
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchInvNoDupChkRSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
	}
	
	
}