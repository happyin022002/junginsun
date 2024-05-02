/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableAdjustDBDAO.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.SapInvoiceInterfaceDetailVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.basic.AccountReceivableAdjustBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjViewAccountingListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustDtlListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustHdrListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustHisListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.ApIfSetVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.ArOtsDtlListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AutoSettlementInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AutoSettlementSubInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AutosettlementCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.CurrRndChkVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OffsetAPPopupListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OffsetARPopupListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OffsetInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OtsTypeExcludeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.SapInvIfDtlVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.SapInvIfHdrVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.SarAcctMtxVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.SarDtrbVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.ZeroBalanceDtlVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.ZeroBalanceHdrVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.AROfficeListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingChgVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingDtlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHdrVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHistVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SarAdjHisVO;
import com.clt.syscommon.common.table.SarAsaMstVO;
import com.clt.syscommon.common.table.SarOffstMstVO;
import com.clt.syscommon.common.table.SarOtsHisVO;

/**
 * AccountReceivableAdjustDBDAO <br>
 * - AccountReceivableAdjust system Business Logic��泥섎━�섍린 �꾪븳 JDBC �묒뾽�섑뻾.<br>
 *
 * @author
 * @see AccountReceivableAdjustBCImpl 李몄“
 * @since J2EE 1.4
 */
public class AccountReceivableAdjustDBDAO extends DBDAOSupport {
	/**
     * Supplier Code Popup<br>
     *
     * @author MCJung 2014.03.18
     * @category STM_SAP_0002
     * @category searchOtsTypeExcludeList
     * @return List<OtsTypeExcludeListVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")

    public List<OtsTypeExcludeListVO> searchOtsTypeExcludeList() throws DAOException {
        DBRowSet dbRowset = null;

        List<OtsTypeExcludeListVO> list = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            //param.put("vndr_lgl_eng_nm", vendorName);
            //param.put("vndr_seq", vendorCode);
            //param.put("delt_flg", enableFlag);

            dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOOtsTypeExcludeListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OtsTypeExcludeListVO.class);
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
	 * AP Search Popup
	 * @author jinyoonoh 2014. 4. 7.
	 * @param OffsetAPPopupListVO offsetAPPopupListVO
	 * @return List<OffsetAPPopupListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OffsetAPPopupListVO> searchOffsetAPPopupList(OffsetAPPopupListVO offsetAPPopupListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OffsetAPPopupListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = offsetAPPopupListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
							new AccountReceivableAdjustDBDAOsearchOffsetAPPopupListRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,OffsetAPPopupListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * AR Search Popup
	 * @author jinyoonoh 2014. 4. 7.
	 * @param AROfficeListVO arOfficeListVO
	 * @param OffsetARPopupListVO offsetARPopupListVO
	 * @return List<OffsetARPopupListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OffsetARPopupListVO> searchOffsetARPopupList(AROfficeListVO arOfficeListVO, OffsetARPopupListVO offsetARPopupListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OffsetARPopupListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			// set search  condition
			Map<String, String> mapVO = offsetARPopupListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			// set office  info
			param.putAll(arOfficeListVO.getColumnValues());
			velParam.putAll(arOfficeListVO.getColumnValues());

			dbRowset = new SQLExecuter("").executeQuery(
							new AccountReceivableAdjustDBDAOsearchOffsetARPopupListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,OffsetARPopupListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}


	/**
	 * Insert into SAR_OFFST_MST<br>
	 * @author jinyoonoh 2014. 4. 17.
	 * @param SarOffstMstVO sarOffstMstVO
	 * @throws DAOException
	 */
	public void addOffsetInfo (SarOffstMstVO sarOffstMstVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = sarOffstMstVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOaddSarOffstMstCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}


	/**
	 * update SAR_OFFST_MST<br>
	 * @author jinyoonoh 2014. 4. 17.
	 * @param SarOffstMstVO sarOffstMstVO
	 * @throws DAOException
	 */
	public void updateOffsetInfo (SarOffstMstVO sarOffstMstVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = sarOffstMstVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOupdateSarOffstMstUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Insert into SAR_OTS_HIS
	 * @author jinyoonoh 2014. 4. 28.
	 * @param SarOtsHisVO sarOtsHis
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSarOtsHis (SarOtsHisVO sarOtsHis) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = sarOtsHis.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOaddSarOtsHisCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}


	/**
	 * Insert into SAR_ADJ_HIS
	 * @author jinyoonoh 2014. 4. 28.
	 * @param SarAdjHisVO sarAdjHis
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSarAdjHis (SarAdjHisVO sarAdjHis) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = sarAdjHis.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOaddSarAdjHisCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * AR Search Popup
	 * @author jinyoonoh 2014. 4. 7.
	 * @param OffsetInfoVO offsetInfoVO
	 * @return List<OffsetInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OffsetInfoVO> searchOffsetList(OffsetInfoVO offsetInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OffsetInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			// set search  condition
			Map<String, String> mapVO = offsetInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(
							new AccountReceivableAdjustDBDAOsearchOffsetInfoRSQL() ,param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OffsetInfoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Search AR OTS Detail
	 * @author jinyoonoh 2014. 4. 7.
	 * @param ArOtsDtlListVO arOtsDtlListVO
	 * @return List<ArOtsDtlListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ArOtsDtlListVO> searchArOtsDtlList(ArOtsDtlListVO arOtsDtlListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ArOtsDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			// set search  condition
			Map<String, String> mapVO = arOtsDtlListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
							new AccountReceivableAdjustDBDAOsearchArOtsDtlListRSQL() ,param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ArOtsDtlListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}


	/**
	 * Search sar adjust history (SAR_ADJ_HIS)
	 * @author jinyoonoh 2014. 4. 29.
	 * @param SarAdjHisVO sarAdjHisVO
	 * @return List<SarAdjHisVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SarAdjHisVO> searchSarAdjHisList(SarAdjHisVO sarAdjHisVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SarAdjHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			// set search  condition
			Map<String, String> mapVO = sarAdjHisVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
							new AccountReceivableAdjustDBDAOsearchSarAdjHisRSQL() ,param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SarAdjHisVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Retrieve Outstanding Adjustment <br>
	 *
	 * @param AdjustCondVO adjustCondVO
	 * @return List<AdjustHdrListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AdjustHdrListVO> searchAdjustHdrList(AdjustCondVO adjustCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AdjustHdrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(adjustCondVO != null){
				Map<String, String> mapVO = adjustCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchAdjustHdrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AdjustHdrListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


	 /**
	 * Retrieve Outstanding Adjustment <br>
	 *
	 * @param AdjustCondVO adjustCondVO
	 * @return List<AdjustDtlListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AdjustDtlListVO> searchAdjustDtlList(AdjustCondVO adjustCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AdjustDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(adjustCondVO != null){
				Map<String, String> mapVO = adjustCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchAdjustDtlListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AdjustDtlListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


	 /**
	 * Retrieve Outstanding Adjustment <br>
	 *
	 * @param AdjustCondVO adjustCondVO
	 * @return List<AdjustHdrListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AdjustHdrListVO> searchOtsAdjustHdrList(AdjustCondVO adjustCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AdjustHdrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(adjustCondVO != null){
				Map<String, String> mapVO = adjustCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchOtsAdjustHdrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AdjustHdrListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}



	 /**
	 * Retrieve Outstanding Adjustment <br>
	 *
	 * @param AdjustCondVO adjustCondVO
	 * @return List<AdjustDtlListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AdjustDtlListVO> searchOtsAdjustDtlList(AdjustCondVO adjustCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AdjustDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(adjustCondVO != null){
				Map<String, String> mapVO = adjustCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchOtsAdjustDtlListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AdjustDtlListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	 /**
	 * get Sequence No for Adjust No <br>
	 *
	 * @return String
	 * @exception EventException
	 */
	public String searchAdjustSeqNo() throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String seq = "";

		try {
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchAdjustListSeqNoRSQL(), param, velParam);
			if(dbRowset.next()){
				seq = dbRowset.getString("sar_ots_adj_seq");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return seq;
	}

	/**
	 * Save Adjust Header List <br>
	 *
	 * @param List<AdjustHdrListVO> insertHdrVoList
	 * @exception EventException
	 */
	public void addAdjustHdrList(List<AdjustHdrListVO> insertHdrVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertHdrVoList.size() > 0) {
				insCnt = sqlExe.executeBatch(new AccountReceivableAdjustDBDAOaddAdjustHdrListCSQL(), insertHdrVoList, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * get Ledger exchange Rate <br>
	 *
	 * @param AdjustDtlListVO adjustDtlListVO
	 * @param AdjustCondVO adjustCondVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLegrXchRtList(AdjustDtlListVO adjustDtlListVO, AdjustCondVO adjustCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String legrXchRt = "";

		try {
			if(adjustDtlListVO != null){
				Map<String, String> mapVO = adjustDtlListVO.getColumnValues();
				Map<String, String> mapCondVO = adjustCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.putAll(mapCondVO);
				velParam.putAll(mapCondVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchLegrXchRtListRSQL(), param, velParam);
			if(dbRowset.next()){
				legrXchRt = dbRowset.getString("legr_xch_rt");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return legrXchRt;
	}

	/**
	 * Save Adjust Detail List <br>
	 *
	 * @param List<AdjustDtlListVO> insertDtlVoList
	 * @exception EventException
	 */
	public void addAdjustDtlList(List<AdjustDtlListVO> insertDtlVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertDtlVoList.size() > 0) {
				insCnt = sqlExe.executeBatch(new AccountReceivableAdjustDBDAOaddAdjustDtlListCSQL(), insertDtlVoList, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Save Adjust History List <br>
	 *
	 * @param AdjustHisListVO adjustHisListVO
	 * @exception EventException
	 */
	public void addAdjustHisList(AdjustHisListVO adjustHisListVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = adjustHisListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOaddAdjustHisListCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Reverse Adjust List <br>
	 *
	 * @param AdjustCondVO adjustCondVO
	 * @param String usrId
	 * @exception EventException
	 */
	public void modifyAdjustInfoRvs(AdjustCondVO adjustCondVO, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if(adjustCondVO != null){
				Map<String, String> mapVO = adjustCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("user_id", usrId);
				velParam.put("user_id", usrId);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOmodifyAdjustInfoRvsUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Search Sail Arrival Date, GL Date, Balance Update Date<br>
	 *
	 * @param String lOfcCd
	 * @return List<AutosettlementCondVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AutosettlementCondVO> searchAutosettlementSetupDate(String lOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<AutosettlementCondVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO =  new HashMap<String, String>();

			mapVO.put("l_ofc_cd", lOfcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchAutosettlementSetupDateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AutosettlementCondVO.class);

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
	 * Retrieve Temporary Autosettlement Entry Summary<br>
	 *
	 * @param String batSeq
	 * @return List<AutoSettlementSubInfoVO>
	 * @exception DAOException
	 */
	public List<AutoSettlementSubInfoVO> searchAutoSettlementSummaryList(String batSeq) throws DAOException{
		DBRowSet dbRowset = null;
		List<AutoSettlementSubInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO =  new HashMap<String, String>();
		mapVO.put("bat_seq", batSeq);
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		try{
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchAutoSettlementSummaryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AutoSettlementSubInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Save Autosettlement Header Data <br>
	 *
	 * @param List<AutoSettlementInfoVO> insertAutosettlementHdrVoList
	 * @exception DAOException
	 */
	public void createAutoSettlementHeaderlInfo(List<AutoSettlementInfoVO> insertAutosettlementHdrVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertAutosettlementHdrVoList.size() > 0) {
				insCnt = sqlExe.executeBatch(new AccountReceivableAdjustDBDAOcreateAutoSettlementHeaderInfoCSQL(), insertAutosettlementHdrVoList, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Save Autosettlement Detail Data <br>
	 *
	 * @param List<AutoSettlementInfoVO> insertAutosettlementDtlVoList
	 * @exception DAOException
	 */
	public void createAutoSettlementDetailInfo(List<AutoSettlementInfoVO> insertAutosettlementDtlVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertAutosettlementDtlVoList.size() > 0) {
				insCnt = sqlExe.executeBatch(new AccountReceivableAdjustDBDAOcreateAutoSettlementDetailInfoCSQL(), insertAutosettlementDtlVoList, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Remove Temporary Data <br>
	 *
	 * @exception DAOException
	 */
	public void removeAutoSettlementTemporaryList() throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOremoveAutoSettlementTemporaryListDSQL(), null, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Retrieve Temporary Autosettlement Entry <br>
	 *
	 * @param String batSeq
	 * @return List<AutoSettlementInfoVO>
	 * @exception EventException
	 */
	public List<AutoSettlementInfoVO> searchAutoSettlementTemporaryList(String batSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<AutoSettlementInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO =  new HashMap<String, String>();
		mapVO.put("bat_seq", batSeq);
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		try{
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchAutoSettlementTemporaryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AutoSettlementInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * get Functional Currency Rate <br>
	 *
	 * @param String blCurrCd
	 * @param String funcCurrCd
	 * @param String adjDt
	 * @return String
	 * @exception EventException
	 */
	public String searchFunctionalCurrencyRate(String blCurrCd, String funcCurrCd, String adjDt) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String funcCurrRate = "";

		try {
			Map<String, String> mapVO =  new HashMap<String, String>();
			mapVO.put("bl_curr_cd", blCurrCd);
			mapVO.put("func_curr_cd", funcCurrCd);
			mapVO.put("adj_dt", adjDt);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchFunctionalCurrencyRateRSQL(), param, velParam);
			if(dbRowset.next()){
				funcCurrRate = dbRowset.getString("conv_xch_rt");
			}

			if(blCurrCd.equals(funcCurrCd)){
				funcCurrRate = "1";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return funcCurrRate;
	}

	/**
	 * get Sequence No for Adjust History <br>
	 *
	 * @return String
	 * @exception EventException
	 */
	public String searchAdjustHisSeqNo() throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String seq = "";

		try {
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchAdjustHisListSeqNoRSQL(), param, velParam);
			if(dbRowset.next()){
				seq = dbRowset.getString("sar_adj_his_seq");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return seq;
	}

	/**
	 * Search Adjust for OTS Header<br>
	 *
	 * @param List<String> adjNoList
	 * @param String stsCd
	 * @return List<AROutstandingHdrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROutstandingHdrVO> searchAdjustForOTSHeader(List<String> adjNoList,String stsCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROutstandingHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("adj_no_list", adjNoList);
			param.put("sts_cd", stsCd);
			velParam.put("adj_no_list", adjNoList);
			velParam.put("sts_cd", stsCd);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchAdjustForOTSHeaderRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROutstandingHdrVO .class);

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
	 * Search Adjust for OTS History<br>
	 *
	 * @param List<String> adjNoList
	 * @param String stsCd
	 * @return List<AROutstandingHistVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROutstandingHistVO> searchAdjustForOTSHistory(List<String> adjNoList,String stsCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROutstandingHistVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("adj_no_list", adjNoList);
			param.put("sts_cd", stsCd);
			velParam.put("adj_no_list", adjNoList);
			velParam.put("sts_cd", stsCd);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchAdjustForOTSHistoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROutstandingHistVO .class);

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
	 * Search Adjust for OTS Detail<br>
	 *
	 * @param List<String> adjNoList
	 * @param String stsCd
	 * @return List<AROutstandingDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROutstandingDtlVO> searchAdjustForOTSDetail(List<String> adjNoList,String stsCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROutstandingDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("adj_no_list", adjNoList);
			param.put("sts_cd", stsCd);
			velParam.put("adj_no_list", adjNoList);
			velParam.put("sts_cd", stsCd);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchAdjustForOTSDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROutstandingDtlVO .class);

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
	 * Search Adjust for OTS Charge<br>
	 *
	 * @param List<String> adjNoList
	 * @param String stsCd
	 * @return List<AROutstandingChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROutstandingChgVO> searchAdjustForOTSCharge(List<String> adjNoList,String stsCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROutstandingChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("adj_no_list", adjNoList);
			param.put("sts_cd", stsCd);
			velParam.put("adj_no_list", adjNoList);
			velParam.put("sts_cd", stsCd);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchAdjustForOTSChargeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROutstandingChgVO .class);

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
	 * Search Target OTS for Apply and Adjust Reverse<br>
	 *
	 * @param String chgTpCd
	 * @param String blCurrCd
	 * @param AdjustCondVO adjustCondVO
	 * @return List<AdjustHisListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AdjustHisListVO> searchOutstandingForApplyAdjustRvs(String chgTpCd, String blCurrCd, AdjustCondVO adjustCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AdjustHisListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = adjustCondVO.getColumnValues();
			param.put("chg_tp_cd", chgTpCd);
			velParam.put("chg_tp_cd", chgTpCd);

			param.put("bl_curr_cd", blCurrCd);
			velParam.put("bl_curr_cd", blCurrCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchOutstandingForApplyAdjustRvsRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AdjustHisListVO .class);

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
	 * get Account Matrix Sequence <br>
	 *
	 * @param String adjTpCd
	 * @param String glDt
	 * @return String
	 * @exception DAOException
	 */
	public String searchAcctMtxSeq(String adjTpCd, String glDt) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String acctMtxSeq = "";

		try {
			param.put("adj_tp_cd", adjTpCd);
			velParam.put("adj_tp_cd", adjTpCd);

			param.put("gl_dt", glDt);
			velParam.put("gl_dt", glDt);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOsearchAcctMtxSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				acctMtxSeq = dbRowset.getString("acct_mtx_seq");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return acctMtxSeq;
	}

	/**
	 * Save SAR Distribution Adjust <br>
	 *
	 * @param SarDtrbVO sarDtrbAdjVO
	 * @exception EventException
	 */
	public void addSarDtrbAdjList(SarDtrbVO sarDtrbAdjVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sarDtrbAdjVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOAddSarDistributionAdjustListCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Save SAR Distribution Receivable <br>
	 *
	 * @param SarDtrbVO sarDtrbRecVO
	 * @exception EventException
	 */
	public void addSarDtrbRecList(SarDtrbVO sarDtrbRecVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sarDtrbRecVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOAddSarDistributionReceivableListCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * get OTS Code Combination Sequence <br>
	 *
	 * @param String otsHisSeq
	 * @param String chgTpCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchOtsCdCmbSeq(String otsHisSeq, String chgTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String otsCdCmbSeq = "";

		try {
			param.put("ots_his_seq", otsHisSeq);
			velParam.put("ots_his_seq", otsHisSeq);

			param.put("chg_tp_cd", chgTpCd);
			velParam.put("chg_tp_cd", chgTpCd);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchOtsCdCmbSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				otsCdCmbSeq = dbRowset.getString("ots_cd_cmb_seq");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return otsCdCmbSeq;
	}

	/**
	 * get Account Code, Common VVD <br>
	 *
	 * @param String tjCd
	 * @param String adjTpCd
	 * @return SarAcctMtxVO
	 * @exception DAOException
	 */
	public SarAcctMtxVO searchAcctCdForAdjCdCmbSeq(String tjCd, String adjTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<SarAcctMtxVO> list = null;
		SarAcctMtxVO sarAcctMtxVO = null;

		try {
			param.put("tj_cd", tjCd);
			velParam.put("tj_cd", tjCd);

			param.put("adj_tp_cd", adjTpCd);
			velParam.put("adj_tp_cd", adjTpCd);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchAcctCdForAdjCdCmbSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SarAcctMtxVO .class);

			if (list != null && list.size() > 0) {
				sarAcctMtxVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sarAcctMtxVO;
	}

	/**
	 * get Code Combination Sequence <br>
	 *
	 * @param SarAcctMtxVO sarAcctMtxVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchAdjCdCmbSeq(SarAcctMtxVO sarAcctMtxVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String adjCdCmbSeq = "";

		try {
			Map<String, String> mapVO = sarAcctMtxVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchAdjCdCmbSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				adjCdCmbSeq = dbRowset.getString("cd_cmb_seq");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return adjCdCmbSeq;
	}

	/**
	 * Update code combination to SAR ADJUST HISTORY <br>
	 * @param SarAdjHisVO adjHisVO
	 * @exception DAOException
	 */
	public void modifyAdjustHisList(SarAdjHisVO adjHisVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = adjHisVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOModifyAdjustHisListUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * get ORIGINAL ADJUST HISTORY SEQUENCE <br>
	 * @param SarAdjHisVO adjHisVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchOriginAdjustHisSeqList(SarAdjHisVO adjHisVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String adjHisSeq = "";

		try {

			Map<String, String> mapVO = adjHisVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchOriginAdjustHisSeqListRSQL(), param, velParam);
			if(dbRowset.next()){
				adjHisSeq = dbRowset.getString("adj_his_seq");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return adjHisSeq;
	}

	/**
	 * Save SAR Distribution For REVERSE <br>
	 *
	 * @param SarDtrbVO sarDtrbVO
	 * @exception DAOException
	 */
	public void addSarDtrbForRvsList(SarDtrbVO sarDtrbVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sarDtrbVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOAddSarDtrbForRvsListCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * GET Adjust History List <br>
	 *
	 * @param String adjHisSeq
	 * @return SarAdjHisVO
	 * @exception DAOException
	 */
	public SarAdjHisVO searchAdjHisList(String adjHisSeq) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<SarAdjHisVO> list = null;
		SarAdjHisVO sarAdjHisVO = null;

		try {

			param.put("adj_his_seq", adjHisSeq);
			velParam.put("adj_his_seq", adjHisSeq);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchAdjHisListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SarAdjHisVO .class);

			if (list != null && list.size() > 0) {
				sarAdjHisVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sarAdjHisVO;
	}

	/**
	 * GET SAR DISTRIBUTION ( CASE 'EXCH_GAIN', 'EXCH_LOSS' ) <br>
	 *
	 * @param String adjHisSeq
	 * @return SarDtrbVO
	 * @exception DAOException
	 */
	public SarDtrbVO searchSarDtrbExchGainLossList(String adjHisSeq) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<SarDtrbVO> list = null;
		SarDtrbVO sarDtrbVO = null;

		try {

			param.put("adj_his_seq", adjHisSeq);
			velParam.put("adj_his_seq", adjHisSeq);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchSarDtrbExchGainLossListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SarDtrbVO .class);

			if (list != null && list.size() > 0) {
				sarDtrbVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sarDtrbVO;
	}

	/**
	 * Save SAR Distribution CASE 'EXCH_GAIN', 'EXCH_LOSS' <br>
	 *
	 * @param SarDtrbVO sarDtrbGainLossVO
	 * @exception DAOException
	 */
	public void addSarDtrbExchGainLossList(SarDtrbVO sarDtrbGainLossVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sarDtrbGainLossVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOAddSarDtrbExchGainLossListCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Save SAR Distribution CASE 'EXCH_GAIN', 'EXCH_LOSS' <br>
	 *
	 * @param SarDtrbVO sarDtrbGainLossVO
	 * @exception DAOException
	 */
	public void addSarTargetDtrbExchGainLossList(SarDtrbVO sarDtrbGainLossVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sarDtrbGainLossVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOaddSarTargetDtrbExchGainLossListCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * COPY SAR Distribution CASE 'EXCH_GAIN', 'EXCH_LOSS' <br>
	 *
	 * @param SarDtrbVO sarDtrbGainLossVO
	 * @exception DAOException
	 */
	public void modifySarTargetDtrbExchGainLossList(SarDtrbVO sarDtrbGainLossVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sarDtrbGainLossVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOmodifySarTargetDtrbExchGainLossListUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * get Currency Rounding Check List <br>
	 *
	 * @param SarAdjHisVO adjHisVO
	 * @param String dpPrcsKnt
	 * @return CurrRndChkVO
	 * @exception DAOException
	 */
	public CurrRndChkVO searchCurrencyRoundingCheckList(SarAdjHisVO adjHisVO, String dpPrcsKnt) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<CurrRndChkVO> list = null;
		CurrRndChkVO currRndChkVO = null;

		try {
			Map<String, String> mapVO = adjHisVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			param.put("dp_prcs_knt", dpPrcsKnt);
			velParam.put("dp_prcs_knt", dpPrcsKnt);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchCurrencyRoundingCheckListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CurrRndChkVO .class);

			if (list != null && list.size() > 0) {
				currRndChkVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return currRndChkVO;
	}

	/**
	 * Save SAR Distribution CASE 'ROUNDING' <br>
	 *
	 * @param SarDtrbVO sarDtrbRoundingVO
	 * @exception EventException
	 */
	public void addSarDtrbRoundingList(SarDtrbVO sarDtrbRoundingVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sarDtrbRoundingVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOAddSarDtrbRoundingListCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * Search SAR_OTS_HIS
	 * @author jinyoonoh 2014. 5. 28.
	 * @param SarOtsHisVO paramVO
	 * @return List<SarOtsHisVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SarOtsHisVO> searchArOtsHisList(SarOtsHisVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SarOtsHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = paramVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchArOtsHisListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SarOtsHisVO .class);

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
	 * Retrieve AP GL DT <br>
	 *
	 * @param String adjNo
	 * @param String rvsFlg
	 * @param String dtTpCd
	 * @return String
	 * @exception EventException
	 */
	public String searchApGlDtList(String adjNo, String rvsFlg, String dtTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String apGlDt = "";

		try {

			param.put("adj_no", adjNo);
			param.put("rvs_flg", rvsFlg);
			param.put("dt_tp_cd", dtTpCd);
			velParam.put("adj_no", adjNo);
			velParam.put("rvs_flg", rvsFlg);
			velParam.put("dt_tp_cd", dtTpCd);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchApGlDtListRSQL(), param, velParam);
			if(dbRowset.next()){
				apGlDt = dbRowset.getString("ap_gl_dt");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return apGlDt;
	}

	/**
	 * Retrieve AP INTERFACE Header Info <br>
	 *
	 * @param ApIfSetVO apIfSetVO
	 * @return List<SapInvIfHdrVO>
	 * @exception DAOException
	 */
	public List<SapInvIfHdrVO> searchSapInvIfHdrList(ApIfSetVO apIfSetVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<SapInvIfHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(apIfSetVO != null){
				Map<String, String> mapVO = apIfSetVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchSapInvIfHdrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapInvIfHdrVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * get Sequence No for AP HDR IF <br>
	 *
	 * @return String
	 * @exception DAOException
	 */
	public String searchSapInvHdrIfSeqNo() throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String invIfSeq = "";

		try {
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchSapInvHdrIfSeqNoRSQL(), param, velParam);
			if(dbRowset.next()){
				invIfSeq = dbRowset.getString("inv_if_seq");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return invIfSeq;
	}

	/**
	 * get Code Combination Sequence No for AP HDR IF <br>
	 *
	 * @param SapInvIfHdrVO sapInvIfHdrVO
	 * @param String adjTpcd
	 * @param String sysTpCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSapInvHdrIfCdCmbSeq(SapInvIfHdrVO sapInvIfHdrVO, String adjTpcd, String sysTpCd) throws DAOException{
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String cdCmbSeq = "";

		try{
			if(sapInvIfHdrVO != null){
				Map<String, String> mapVO = sapInvIfHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("adj_tp_cd", adjTpcd);
				velParam.put("adj_tp_cd", adjTpcd);

				param.put("sys_tp_cd", sysTpCd);
				velParam.put("sys_tp_cd", sysTpCd);
			}
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchSapInvHdrIfCdCmbSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				cdCmbSeq = dbRowset.getString("cd_cmb_seq");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cdCmbSeq;
	}

	/**
	 * Retrieve AP INTERFACE Detail Info <br>
	 *
	 * @param ApIfSetVO apIfSetVO
	 * @return List<SapInvIfDtlVO>
	 * @exception EventException
	 */
	public List<SapInvIfDtlVO> searchSapInvIfDtlList(ApIfSetVO apIfSetVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<SapInvIfDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(apIfSetVO != null){
				Map<String, String> mapVO = apIfSetVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchSapInvIfLineListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapInvIfDtlVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * get Sequence No for AP DTL IF <br>
	 *
	 * @return String
	 * @exception EventException
	 */
	public String searchSapInvDtlIfSeqNo() throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String invIfLineSeq = "";

		try {
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchSapInvDtlIfSeqNoRSQL(), param, velParam);
			if(dbRowset.next()){
				invIfLineSeq = dbRowset.getString("inv_if_line_seq");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return invIfLineSeq;
	}

	/**
	 * get Code Combination Sequence No for AP DTL IF <br>
	 *
	 * @param SapInvIfDtlVO sapInvIfDtlVO
	 * @param String adjTpcd
	 * @param String sysTpCd
	 * @param String adjNo
	 * @param String offArAcctCd
	 * @param String offInterCoCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSapInvDtlIfCdCmbSeq(SapInvIfDtlVO sapInvIfDtlVO, String adjTpcd, String sysTpCd, String adjNo, String offArAcctCd, String offInterCoCd) throws DAOException{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String cdCmbSeq = "";

		try{
			if(sapInvIfDtlVO != null){
				Map<String, String> mapVO = sapInvIfDtlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("adj_tp_cd", adjTpcd);
				velParam.put("adj_tp_cd", adjTpcd);

				param.put("sys_tp_cd", sysTpCd);
				velParam.put("sys_tp_cd", sysTpCd);

				//2014.08.18 add adjNo
				param.put("adj_no", adjNo);
				velParam.put("adj_no", adjNo);

				param.put("off_ar_acct_cd", offArAcctCd);
				velParam.put("off_ar_acct_cd", offArAcctCd);

				param.put("off_inter_co_cd", offInterCoCd);
				velParam.put("off_inter_co_cd", offInterCoCd);
			}
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchSapInvDtlIfCdCmbSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				cdCmbSeq = dbRowset.getString("cd_cmb_seq");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cdCmbSeq;
	}

	/**
	 * get Next Code Combination Sequence No for AP DTL IF <br>
	 *
	 * @param SapInvIfDtlVO sapInvIfDtlVO
	 * @param String adjTpcd
	 * @param String dtrbCdCmbSeq
	 * @param String offGainAndLssAcctCd
	 * @param String sysTpCd
	 * @param String rvsFlg
	 * @return String
	 * @exception DAOException
	 */
	public String searchSapInvDtlIfCdCmbNextSeq(SapInvIfDtlVO sapInvIfDtlVO, String adjTpcd, String dtrbCdCmbSeq, String offGainAndLssAcctCd, String sysTpCd, String rvsFlg) throws DAOException{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String cdCmbSeq = "";

		try{
			if(sapInvIfDtlVO != null){
				Map<String, String> mapVO = sapInvIfDtlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("adj_tp_cd", adjTpcd);
				velParam.put("adj_tp_cd", adjTpcd);

				//2014.08.18 add dtrbCdCmbSeq
				param.put("dtrb_cd_cmb_seq", dtrbCdCmbSeq);
				velParam.put("dtrb_cd_cmb_seq", dtrbCdCmbSeq);

				param.put("off_gain_and_lss_acct_cd", offGainAndLssAcctCd);
				velParam.put("off_gain_and_lss_acct_cd", offGainAndLssAcctCd);

				param.put("sys_tp_cd", sysTpCd);
				velParam.put("sys_tp_cd", sysTpCd);

				param.put("rvs_flg", rvsFlg);
				velParam.put("rvs_flg", rvsFlg);
			}
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchSapInvDtlIfCdCmbNextSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				cdCmbSeq = dbRowset.getString("cd_cmb_seq");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cdCmbSeq;
	}

	/**
	 * 2014.06.19 임시 로직 추가
	 * CODE COMBINATION SEQUENCE 없으면 저장하고 조회 로직
	 * Insert into SCO_LEGR_CD_CMB<br>
	 * @param SarAcctMtxVO sarAcctMtxVO
	 * @exception DAOException
	 */
	public void addAdjCdCmbSeq(SarAcctMtxVO sarAcctMtxVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = sarAcctMtxVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOAddAdjCdCmbSeqCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * 2014.06.19 임시 로직 추가
	 * CODE COMBINATION SEQUENCE 없으면 저장하고 조회 로직
	 * Insert SCO_LEGR_CD_CMB Table <br>
	 * @param SapInvIfHdrVO sapInvIfHdrVO
	 * @param String adjTpcd
	 * @param String sysTpCd
	 * @exception DAOException
	 */
	public void addSapInvHdrIfCdCmbSeq(SapInvIfHdrVO sapInvIfHdrVO, String adjTpcd, String sysTpCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if(sapInvIfHdrVO != null){
				Map<String, String> mapVO = sapInvIfHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("adj_tp_cd", adjTpcd);
				velParam.put("adj_tp_cd", adjTpcd);

				param.put("sys_tp_cd", sysTpCd);
				velParam.put("sys_tp_cd", sysTpCd);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOAddSapInvHdrIfCdCmbSeqCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * 2014.06.19 임시 로직 추가
	 * CODE COMBINATION SEQUENCE 없으면 저장하고 조회 로직
	 * Insert SCO_LEGR_CD_CMB Table <br>
	 * @param SapInvIfDtlVO sapInvIfDtlVO
	 * @param String adjTpcd
	 * @param String sysTpCd
	 * @param String adjNo
	 * @param String offArAcctCd
	 * @param String offInterCoCd
	 * @exception DAOException
	 */
	public void addSapInvDtlIfCdCmbSeq(SapInvIfDtlVO sapInvIfDtlVO, String adjTpcd, String sysTpCd, String adjNo, String offArAcctCd, String offInterCoCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if(sapInvIfDtlVO != null){
				Map<String, String> mapVO = sapInvIfDtlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("adj_tp_cd", adjTpcd);
				velParam.put("adj_tp_cd", adjTpcd);

				param.put("sys_tp_cd", sysTpCd);
				velParam.put("sys_tp_cd", sysTpCd);

				//2014.08.18 add adjNo
				param.put("adj_no", adjNo);
				velParam.put("adj_no", adjNo);

				param.put("off_ar_acct_cd", offArAcctCd);
				velParam.put("off_ar_acct_cd", offArAcctCd);

				param.put("off_inter_co_cd", offInterCoCd);
				velParam.put("off_inter_co_cd", offInterCoCd);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOAddSapInvDtlIfCdCmbSeqCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * 2014.06.19 임시 로직 추가
	 * CODE COMBINATION SEQUENCE 없으면 저장하고 조회 로직
	 * Insert SCO_LEGR_CD_CMB Table <br>
	 * @param SapInvIfDtlVO sapInvIfDtlVO
	 * @param String adjTpcd
	 * @param String sysTpCd
	 * @param String dtrbCdCmbSeq
	 * @param String offGainAndLssAcctCd
	 * @param String rvsFlg
	 * @exception DAOException
	 */
	public void addSapInvDtlIfCdCmbNextSeq(SapInvIfDtlVO sapInvIfDtlVO, String adjTpcd, String sysTpCd, String dtrbCdCmbSeq, String offGainAndLssAcctCd, String rvsFlg) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if(sapInvIfDtlVO != null){
				Map<String, String> mapVO = sapInvIfDtlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("adj_tp_cd", adjTpcd);
				velParam.put("adj_tp_cd", adjTpcd);

				param.put("sys_tp_cd", sysTpCd);
				velParam.put("sys_tp_cd", sysTpCd);

				//2014.08.18 add dtrbCdCmbSeq
				param.put("dtrb_cd_cmb_seq", dtrbCdCmbSeq);
				velParam.put("dtrb_cd_cmb_seq", dtrbCdCmbSeq);

				param.put("off_gain_and_lss_acct_cd", offGainAndLssAcctCd);
				velParam.put("off_gain_and_lss_acct_cd", offGainAndLssAcctCd);

				param.put("rvs_flg", rvsFlg);
				velParam.put("rvs_flg", rvsFlg);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOAddSapInvDtlIfCdCmbNextSeqCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Search ASA No, Currency List<br>
	 *
	 * @param AdjustCondVO adjustCondVO
	 * @return List<SarAsaMstVO>
	 * @exception DAOException
	 */
	public List<SarAsaMstVO> searchAsaNoList(AdjustCondVO adjustCondVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<SarAsaMstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(adjustCondVO != null){
				Map<String, String> mapVO = adjustCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchAsaNoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SarAsaMstVO .class);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}


	/**
	 * Search Adjust view accounting
	 * @author jinyoonoh 2014. 7. 16.
	 * @param AdjViewAccountingListVO vo
	 * @return List<AdjViewAccountingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AdjViewAccountingListVO> searchAdjViewAccountingList(AdjViewAccountingListVO vo) throws DAOException {

		DBRowSet dbRowset = null;
		List<AdjViewAccountingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
							new AccountReceivableAdjustDBDAOSearchAdjViewAccountingListRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,AdjViewAccountingListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Call Ap Functional Exchange Rate Function<br>
	 * @param ApIfSetVO apIfSetVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSarGetGlXchRtFncList(ApIfSetVO apIfSetVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String result = "";

		try{
			if(apIfSetVO != null){
				Map<String, String> mapVO = apIfSetVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchSarGetGlXchRtFncListRSQL(), param, velParam);
			if(dbRowset.next()){
				result = dbRowset.getString("xch_rt");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Search sum of adj_acct_amt<br>
	 * @param String offsetNo
	 * @param String rvsFlg
	 * @return String
	 * @throws DAOException
	 */
	public String searchAdjAcctAmtSumList(String offsetNo, String rvsFlg) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String result = "";

		try{
			param.put("off_no", offsetNo);
			velParam.put("off_no", offsetNo);

			param.put("rvs_flg", rvsFlg);
			velParam.put("rvs_flg", rvsFlg);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchAdjAcctAmtSumListRSQL(), param, velParam);
			if(dbRowset.next()){
				result = dbRowset.getString("adj_acct_amt");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Search sum of offst_amt<br>
	 * @param String offsetNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchOffsetAmtSumList(String offsetNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String result = "";

		try{
			param.put("off_no", offsetNo);
			velParam.put("off_no", offsetNo);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchOffsetAmtSumListRSQL(), param, velParam);
			if(dbRowset.next()){
				result = dbRowset.getString("offst_amt");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Search AR/GAIN/LOSS Account Code<br>
	 * @param String adjTpCd
	 * @return SarAcctMtxVO
	 * @throws DAOException
	 */
	public SarAcctMtxVO searchSarAcctCodeList(String adjTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<SarAcctMtxVO> list = null;
		SarAcctMtxVO sarAcctMtxVO = null;

		try{
			param.put("adj_tp_cd", adjTpCd);
			velParam.put("adj_tp_cd", adjTpCd);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchSarAcctCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SarAcctMtxVO .class);

			if (list != null && list.size() > 0) {
				sarAcctMtxVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sarAcctMtxVO;
	}

	/**
	 * Calculate Ap Line/GAIN/LOSS Amount<br>
	 * @param String offApFuncExRt
	 * @param String offAdjAcctAmt
	 * @param String offMstSumAmt
	 * @param String offApHdrAmt
	 * @param String dpPrcsKnt
	 * @param String adjTpcd
	 * @param String rvsFlg
	 * @return SapInvoiceInterfaceDetailVO
	 * @throws DAOException
	 */
	public SapInvoiceInterfaceDetailVO searchApLineAmtCalcList(String offApFuncExRt, String offAdjAcctAmt, String offMstSumAmt, String offApHdrAmt, String dpPrcsKnt, String adjTpcd, String rvsFlg) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<SapInvoiceInterfaceDetailVO> list = null;
		SapInvoiceInterfaceDetailVO result = null;

		try{
			param.put("off_ap_func_ex_rt", offApFuncExRt);
			velParam.put("off_ap_func_ex_rt", offApFuncExRt);

			param.put("off_adj_acct_amt", offAdjAcctAmt);
			velParam.put("off_adj_acct_amt", offAdjAcctAmt);

			param.put("off_mst_sum_amt", offMstSumAmt);
			velParam.put("off_mst_sum_amt", offMstSumAmt);

			param.put("off_ap_hdr_amt", offApHdrAmt);
			velParam.put("off_ap_hdr_amt", offApHdrAmt);

			param.put("dp_prcs_knt", dpPrcsKnt);
			velParam.put("dp_prcs_knt", dpPrcsKnt);

			param.put("adj_tp_cd", adjTpcd);
			velParam.put("adj_tp_cd", adjTpcd);

			param.put("rvs_flg", rvsFlg);
			velParam.put("rvs_flg", rvsFlg);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchApLineAmtCalcListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapInvoiceInterfaceDetailVO .class);

			if (list != null && list.size() > 0) {
				result = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Setting INV NO of Offset, INV TYPE LOOKUP CODE<br>
	 * @param ApIfSetVO apIfSetVO
	 * @param String offApHdrAmt
	 * @param String offOfcCd
	 * @return List<SapInvIfHdrVO>
	 * @throws DAOException
	 */
	public List<SapInvIfHdrVO> searchOffSapInvNoList(ApIfSetVO apIfSetVO, String offApHdrAmt, String offOfcCd) throws DAOException{
		DBRowSet dbRowset = null;
		List<SapInvIfHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(apIfSetVO != null){
				Map<String, String> mapVO = apIfSetVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("off_ap_hdr_amt", offApHdrAmt);
				velParam.put("off_ap_hdr_amt", offApHdrAmt);

				param.put("off_ofc_cd", offOfcCd);
				velParam.put("off_ofc_cd", offOfcCd);
			}

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAdjustDBDAOSearchOffSapInvNoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapInvIfHdrVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * small autosettlement insert temp <br>
	 *
	 * @param AutosettlementCondVO autosettlementCondVO
	 * @exception DAOException
	 */
	public void addSmallOutstandingList(AutosettlementCondVO autosettlementCondVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(autosettlementCondVO != null){
				Map<String, String> mapVO = autosettlementCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOaddSmallOutstandingListCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Overpayment autosettlement insert temp  <br>
	 *
	 * @param AutosettlementCondVO autosettlementCondVO
	 * @exception DAOException
	 */
	public void addOverpaymentOutstandingList(AutosettlementCondVO autosettlementCondVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(autosettlementCondVO != null){
				Map<String, String> mapVO = autosettlementCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOaddOverpaymentOutstandingListCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Remove User Check Temporary Data <br>
	 *
	 * @param AutoSettlementInfoVO[] autoSettlementInfoVOs
	 * @exception EventException
	 */
	public void removeAutoSettlementDelCheckList(AutoSettlementInfoVO[] autoSettlementInfoVOs) throws DAOException {
		try {
			List<AutoSettlementInfoVO> list= new ArrayList<AutoSettlementInfoVO>();
			list = Arrays.asList(autoSettlementInfoVOs);

			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (list.size() > 0) {
				updCnt = sqlExe.executeBatch(new AccountReceivableAdjustDBDAOremoveAutoSettlementDelCheckListDSQL(), list, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * RESET WF SAR Distribution CASE 'EXCH_GAIN', 'EXCH_LOSS' <br>
	 *
	 * @param SarDtrbVO sarDtrbGainLossVO
	 * @exception DAOException
	 */
	public void modifyWFDtrbExchGainLossList(SarDtrbVO sarDtrbGainLossVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sarDtrbGainLossVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOmodifyWFDtrbExchGainLossListUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * WF REC -> ADJ 로 복사 <br>
	 *
	 * @param SarDtrbVO sarDtrbGainLossVO
	 * @exception DAOException
	 */
	public void modifyWFRECToADJDtrb(SarDtrbVO sarDtrbGainLossVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = sarDtrbGainLossVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO); 
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAdjustDBDAOmodifyWFRECToADJDtrbUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Save Zero Balance Header Data <br>
	 *
	 * @param List<ZeroBalanceHdrVO> zeroBalanceHdrVOs
	 * @exception DAOException
	 */
	public void addZeroBalanceHdrInfo(List<ZeroBalanceHdrVO> zeroBalanceHdrVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (zeroBalanceHdrVOs.size() > 0) {
				insCnt = sqlExe.executeBatch(new AccountReceivableAdjustDBDAOAddZeroBalanceHdrInfoCSQL(), zeroBalanceHdrVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Save Zero Balance Detail Data <br>
	 *
	 * @param List<ZeroBalanceDtlVO> zeroBalanceDtlVOs
	 * @exception DAOException
	 */
	public void addZeroBalanceDtlInfo(List<ZeroBalanceDtlVO> zeroBalanceDtlVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (zeroBalanceDtlVOs.size() > 0) {
				insCnt = sqlExe.executeBatch(new AccountReceivableAdjustDBDAOAddZeroBalanceDtlInfoCSQL(), zeroBalanceDtlVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * batch 가 running 상태일 경우, E로 update
	 * 
	 * @param batSeq
	 * @throws DAOException
	 */
	public void manageCancelAutoSettlementBat(String batSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try { 
			param.put("bat_seq",batSeq);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableAdjustDBDAOManageCancelAutoSettlementBatUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
}
