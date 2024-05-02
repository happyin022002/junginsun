/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAO.java
*@FileTitle : DEM/DET Adjustment Request - Before Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.11 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.ApprovalRequestUserListVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.ApprovalRequestUserVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeAfterStatusInputVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeAfterStatusVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionDeleteVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionListInputVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionListVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVersionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCommodityVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCoverageVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionRateAdjustVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAProgressVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS RFAExceptionTariffMgtDBDAO <br>
 * - OPUS-RFAExceptionTariffMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SungHoon, Lee
 * @see RFAExceptionTariffMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class RFAExceptionTariffMgtDBDAO extends DBDAOSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Before Booking의 Proposal No. 에 해당되는 DAR No.를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RFAProgressVO> searchBeforeDARList(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAProgressVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchBeforeDARListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAProgressVO .class);
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
	 * Before Booking의 DAR No. 에 해당되는 Version을 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RFAProgressVO> searchBeforeVERList(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAProgressVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchBeforeVERListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAProgressVO .class);
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
	 * Before Booking Exception을 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<BeforeExceptionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeExceptionVO> searchBeforeExceptionList(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeExceptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchBeforeExceptionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeExceptionVO .class);
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
	 * Actual Customer를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCustomerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RFAExceptionCustomerVO> searchCustomerListByRFA(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAExceptionCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchCustomerByRFARSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAExceptionCustomerVO .class);
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
	 * Proposal No. 에 해당되는 Affiliate를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCustomerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RFAExceptionCustomerVO> searchAffiliateListByRFA(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAExceptionCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchAffiliateByRFARSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAExceptionCustomerVO .class);
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
	 * DAR No. 나 Approval No. 로 Proposal No.를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RFAProgressVO> searchPropNoByDARApprovalNo(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAProgressVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchPropNoByDARApprovalNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAProgressVO .class);
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
	 * DAR No. 를 생성, 조회 합니다. <br>
	 * 
	 * @param SignOnUserAccount account
	 * @param String bkgTpCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchNewDAR(SignOnUserAccount account, String bkgTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer newDarNo = new StringBuffer();
		String darYrMon = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", 		account.getOfc_cd());
			param.put("dar_div_cd", 	bkgTpCd);
			SQLExecuter sqlExecuter = new SQLExecuter("");
			//DB 시스템의 Year, Month 정보를 조회한다.
			dbRowset = sqlExecuter.executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchNewDARYrMonRSQL(), param, null);
			dbRowset.next();
			darYrMon = dbRowset.getString(1);
			param.put("dar_yrmon", 		darYrMon);
			
			//DAR SEQ 정보를 조회한다.
			param.put("dar_ofc_cd", 	account.getOfc_cd());
			dbRowset = sqlExecuter.executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchNewDARNoRSQL(), param, null);
			
			if (dbRowset.next()) {
				//DAR No. 를 생성하는 로직
				newDarNo.append(account.getOfc_cd()).append(darYrMon).append(dbRowset.getString(1)).append(bkgTpCd);
				param.put("upd_usr_id", 	account.getUsr_id());
				param.put("upd_ofc_cd", 	account.getOfc_cd());
				param.put("dar_seq", 		Integer.parseInt(dbRowset.getString(1)));

				//Before Booking 일 경우
				if ("B".equals(bkgTpCd))
					param.put("rfa_expt_dar_no", newDarNo.toString());
				//After Booking 일 경우
				else
					param.put("aft_expt_dar_no", newDarNo.toString());				
				
				//DAR No. 를 채번 테이블에서 수정한다.
				sqlExecuter.executeUpdate((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAOModifyNewDARNoUSQL(), param, null);
			} else {
				//DAR No. 를 생성하는 로직
				newDarNo.append(account.getOfc_cd()).append(darYrMon).append("0001").append(bkgTpCd);
				param.put("cre_usr_id", 	account.getUsr_id());
				param.put("cre_ofc_cd", 	account.getOfc_cd());
				param.put("dar_ofc_cd", 	account.getOfc_cd());
				param.put("dar_seq", 		"1");

				//Before Booking 일 경우
				if ("B".equals(bkgTpCd)) 
					param.put("rfa_expt_dar_no", newDarNo.toString());
				//After Booking 일 경우
				else
					param.put("aft_expt_dar_no", newDarNo.toString());
				
				//DAR No. 를 채번 테이블에서 입력한다.
				sqlExecuter.executeUpdate((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAOAddNewDARNoCSQL(), param, null);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return newDarNo.toString();
	}
	
	
	/**
	 * 승인된 이전버전이 존재할 경우 그 승인번호를 조회 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPrevApprovalNo(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		String approvalNo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchPrevApprovalNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				approvalNo = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return approvalNo;
	}
	
	
	/**
	 * Approval No. 를 생성, 조회 합니다. <br>
	 * 
	 * @param String usrId
	 * @param String rhqOfcCd
	 * @param String bkgTpCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchNewApprovalNo(String usrId, String rhqOfcCd, String bkgTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer newApprNo = new StringBuffer();
		String darYrMon = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", 		rhqOfcCd);
			param.put("dar_div_cd", 	bkgTpCd);
			SQLExecuter sqlExecuter = new SQLExecuter("");
			
			//DB 시스템의 Year, Month 정보를 조회한다.
			dbRowset = sqlExecuter.executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchNewDARYrMonRSQL(), param, null);
			dbRowset.next();
			darYrMon = dbRowset.getString(1);
			param.put("dar_apro_yrmon", darYrMon);
			
			//Approval SEQ 정보를 조회한다.
			param.put("apro_ofc_cd", rhqOfcCd);
			dbRowset = sqlExecuter.executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchNewAPRONoRSQL(), param, null);
			if (dbRowset.next()) {
				//DAR No. 를 생성하는 로직
				newApprNo.append(rhqOfcCd).append(darYrMon).append(dbRowset.getString(1)).append(bkgTpCd);
				param.put("upd_usr_id", 		usrId);
				param.put("upd_ofc_cd", 		rhqOfcCd);
				param.put("dar_apro_seq", 		Integer.parseInt(dbRowset.getString(1)));
				
				//Before Booking DAR
				if ("B".equals(bkgTpCd))
					param.put("rfa_expt_apro_no", 	newApprNo.toString());
				//After Booking DAR
				else
					param.put("aft_bkg_apro_no", 	newApprNo.toString());
				   	                   
				//DAR No. 를 채번 테이블에서 수정한다.
				sqlExecuter.executeUpdate((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAOModifyNewAPRONoUSQL(), param, null);
			} else {
				//DAR No. 를 생성하는 로직
				newApprNo.append(rhqOfcCd).append(darYrMon).append("0001").append(bkgTpCd);
				param.put("cre_usr_id", 		usrId);
				param.put("cre_ofc_cd", 		rhqOfcCd);
				param.put("apro_ofc_cd", 		rhqOfcCd);
				param.put("dar_apro_seq", 		"1");
				
				//Before Booking DAR
				if ("B".equals(bkgTpCd))
					param.put("rfa_expt_apro_no", 	newApprNo.toString());
				//After Booking DAR
				else
					param.put("aft_bkg_apro_no", 	newApprNo.toString());
				
				//DAR No. 를 채번 테이블에서 입력한다.
				sqlExecuter.executeUpdate((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAOAddNewAPRONoCSQL(), param, null);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return newApprNo.toString();
	}	
		

	/**
	 * Version 에 해당되는 Comment History를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })	
	public List<RFAProgressVO> searchCommentHistory(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAProgressVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchCommentHistoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAProgressVO .class);
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
	 * DAR No. 와 Version No. 에 해당되는 모든 Multi Origin or Destination 정보를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCoverageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RFAExceptionCoverageVO> searchMultiCoverageByRFA(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAExceptionCoverageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchMultiCoverageByRFARSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAExceptionCoverageVO .class);
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
	 * DAR No. 와 Version No. 에 해당되는 모든 Rate Adjustment 정보를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionRateAdjustVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RFAExceptionRateAdjustVO> searchRateAdjustmentByRFA(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAExceptionRateAdjustVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchRateAdjustmentByRFARSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAExceptionRateAdjustVO .class);
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
	 * 주어진 Dar No, Version Seq 에 해당되는 최대 Request Detail Seq 를 조회 합니다. <br>
	 * 
	 * @param BeforeExceptionVO beforeExceptionVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchNextTariffSequence(BeforeExceptionVO beforeExceptionVO) throws DAOException,Exception {
		int result = -1;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (beforeExceptionVO != null) {
				Map<String, String> mapVO = beforeExceptionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchNextTariffSequenceRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1);
				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * 중복된 Version이 존재하는지 조회 합니다. <br>
	 * 
	 * @param BeforeExceptionVersionVO beforeExceptionVersionVO
	 * @return boolean
	 * @throws DAOException
	 */	
	public boolean duplicateBeforeExceptionVersion(BeforeExceptionVersionVO beforeExceptionVersionVO) throws DAOException {
		boolean result = false;
		DBRowSet dbRowset = null;		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (beforeExceptionVersionVO != null) {
				Map<String, String> mapVO = beforeExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new 
					RFAExceptionTariffMgtDBDAODuplicateBeforeExceptionVersionRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * Before Exception Version를 생성 합니다. <br>
	 * 
	 * @param BeforeExceptionVersionVO beforeExceptionVersionVO
	 * @throws DAOException
	 */
	public void addBeforeExceptionVersion(BeforeExceptionVersionVO beforeExceptionVersionVO) throws DAOException {
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (beforeExceptionVersionVO != null) {
				Map<String, String> mapVO = beforeExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOAddBeforeExceptionVersionCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Comment를 생성 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void addCommentHistory(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOAddCommentHistoryCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 최종버전이 Approval 될 경우, 만일 이전버전에 Approval 된 데이터가 있다면, 그 버전에 Cancel Comment 를 생성 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void addCancelCommentHistory(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOAddCancelCommentHistoryCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Before Exception를 생성 합니다. <br>
	 * 
	 * @param List<BeforeExceptionVO> beforeExceptionVOs
	 * @throws DAOException
	 */
	public void addBeforeExceptionTariff(List<BeforeExceptionVO> beforeExceptionVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(beforeExceptionVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAOAddBeforeExceptionTariffCSQL(), beforeExceptionVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Multi Origin or Destination를 생성 합니다. <br>
	 * 
	 * @param List<RFAExceptionCoverageVO> rFAExceptionCoverageVOs
	 * @throws DAOException
	 */
	public void addBeforeExceptionCoverage(List<RFAExceptionCoverageVO> rFAExceptionCoverageVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(rFAExceptionCoverageVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAOAddBeforeExceptionCoverageCSQL(), rFAExceptionCoverageVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Rate Adjustment를 생성 합니다. <br>
	 * 
	 * @param List<RFAExceptionRateAdjustVO> rFAExceptionRateAdjustVOs
	 * @throws DAOException
	 */
	public void addBeforeExceptionRate(List<RFAExceptionRateAdjustVO> rFAExceptionRateAdjustVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(rFAExceptionRateAdjustVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAOAddBeforeExceptionRateCSQL(), rFAExceptionRateAdjustVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Before Exception Version를 수정 합니다. <br>
	 * 
	 * @param BeforeExceptionVersionVO beforeExceptionVersionVO
	 * @throws DAOException
	 */
	public void modifyBeforeExceptionVersion(BeforeExceptionVersionVO beforeExceptionVersionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (beforeExceptionVersionVO != null) {
				Map<String, String> mapVO = beforeExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOModifyBeforeExceptionVersionUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Before Exception를 수정 합니다. <br>
	 * 
	 * @param List<BeforeExceptionVO> beforeExceptionVOs
	 * @throws DAOException
	 */
	public void modifyBeforeExceptionTariff(List<BeforeExceptionVO> beforeExceptionVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int upsCnt[] = null;
			if(beforeExceptionVOs.size() > 0){
				upsCnt = sqlExe.executeBatch((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAOModifyBeforeExceptionTariffUSQL(), beforeExceptionVOs, null);
				for(int i = 0; i < upsCnt.length; i++){
					if(upsCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Multi Origin or Destination를 수정 합니다. <br>
	 * 
	 * @param List<RFAExceptionCoverageVO> rFAExceptionCoverageVOs
	 * @throws DAOException
	 */
	public void modifyBeforeExceptionCoverage(List<RFAExceptionCoverageVO> rFAExceptionCoverageVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int upsCnt[] = null;
			if(rFAExceptionCoverageVOs.size() > 0){
				upsCnt = sqlExe.executeBatch((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAOModifyBeforeExceptionCoverageUSQL(), rFAExceptionCoverageVOs, null);
				for(int i = 0; i < upsCnt.length; i++){
					if(upsCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Rate Adjustment를 수정 합니다. <br>
	 * 
	 * @param List<RFAExceptionRateAdjustVO> rFAExceptionRateAdjustVOs
	 * @throws DAOException
	 */
	public void modifyBeforeExceptionRate(List<RFAExceptionRateAdjustVO> rFAExceptionRateAdjustVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int upsCnt[] = null;
			if(rFAExceptionRateAdjustVOs.size() > 0){
				upsCnt = sqlExe.executeBatch((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAOModifyBeforeExceptionRateUSQL(), rFAExceptionRateAdjustVOs, null);
				for(int i = 0; i < upsCnt.length; i++){
					if(upsCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Before Booking를 삭제 합니다. <br>
	 * 
	 * @param List<BeforeExceptionVO> beforeExceptionVOs
	 * @throws DAOException
	 */
	public void removeBeforeExceptionTariff(List<BeforeExceptionVO> beforeExceptionVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(beforeExceptionVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAORemoveBeforeExceptionTariffDSQL(), beforeExceptionVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Multi Origin or Destination를 삭제 합니다. <br>
	 * 
	 * @param List<RFAExceptionCoverageVO> rFAExceptionCoverageVOs
	 * @throws DAOException
	 */
	public void removeBeforeExceptionCoverage(List<RFAExceptionCoverageVO> rFAExceptionCoverageVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(rFAExceptionCoverageVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAORemoveBeforeExceptionCoverageDSQL(), rFAExceptionCoverageVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Tariff 에 해당하는 모든 Coverage 정보를 삭제 합니다. <br>
	 * 
	 * @param List<BeforeExceptionVO> beforeExceptionVOs
	 * @throws DAOException
	 */
	public void removeBeforeExceptionCoverageByTariff(List<BeforeExceptionVO> beforeExceptionVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(beforeExceptionVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAORemoveBeforeExceptionCoverageByTariffDSQL(), beforeExceptionVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Rate Adjustment를 삭제 합니다. <br>
	 * 
	 * @param List<RFAExceptionRateAdjustVO> rFAExceptionRateAdjustVOs
	 * @throws DAOException
	 */
	public void removeBeforeExceptionRate(List<RFAExceptionRateAdjustVO> rFAExceptionRateAdjustVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(rFAExceptionRateAdjustVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAORemoveBeforeExceptionRateDSQL(), rFAExceptionRateAdjustVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Before Booking Exception Version 의 상태를 수정 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void modifyBeforeExceptionStatus(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOModifyBeforeExceptionStatusUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 이전 버전의 승인상태가 Cancelled 로 변경되기 때문에 승인번호도 삭제 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void modifyBeforeExceptionOtherTariffStatus(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExecuter = new SQLExecuter("");
			sqlExecuter.executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOModifyBeforeExceptionOtherTariffStatusUSQL(), param, velParam);
//			2009-08-14(금) History 는 이전버전들의 승인된 상태에 대한 정보를 Cancel 로 변경하지 않음. 
//			sqlExecuter.executeUpdate((ISQLTemplate)
//					new RFAExceptionTariffMgtDBDAOModifyBeforeExceptionOtherTariffProgStatusUSQL(), param, velParam);			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	/**
	 * DAR No. 에 해당되는 Approval No.를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RFAProgressVO> searchBeforeAPROList(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAProgressVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchBeforeAPROListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAProgressVO .class);
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
	 * Proposal No. 에 해당되는 Customer를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RFAProgressVO> searchCustomerByProp(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAProgressVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchCustomerByPropRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAProgressVO .class);
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
	 * Proposal No. 에 해당되는 RFA No.를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RFAProgressVO> searchRFAByProp(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAProgressVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchRFAByPropRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAProgressVO .class);
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
	 * Coverage 데이터를 추가하기 전에 부모 테이블에 Coverage Seq. 에 해당되는 데이터가 있는지 확인후 없는것만 Before Booking를 생성 합니다. <br>
	 * 
	 * @param RFAExceptionCoverageVO rFAExceptionCoverageVO
	 * @throws DAOException
	 */
	public void addBeforeExceptionTariffByCVRG(RFAExceptionCoverageVO rFAExceptionCoverageVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAExceptionCoverageVO != null) {
				Map<String, String> mapVO = rFAExceptionCoverageVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOAddBeforeExceptionTariffByCVRGCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 삭제된 Coverage 정보가 있다면, 관련 Coverage Seq. 를 갖는 Before Booking도 삭제 합니다. <br>
	 * 
	 * @param BeforeExceptionVersionVO beforeExceptionVersionVO
	 * @throws DAOException
	 */
	public void removeBeforeExceptionTariffByCVRG(BeforeExceptionVersionVO beforeExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (beforeExceptionVersionVO != null) {
				Map<String, String> mapVO = beforeExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAORemoveBeforeExceptionTariffByCVRGDSQL(), param, velParam);			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Proposal No. 에 해당되는 RFA No. 와 Customer를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCustomerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RFAExceptionCustomerVO> searchRFANoCustomerByProposalNo(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAExceptionCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAOSearchRFANoCustomerByProposalNoRSQL(), param, velParam);				
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAExceptionCustomerVO .class);
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
	 * Approval No. 에 해당되는 Version를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RFAProgressVO> searchVERByApprovalNo(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAProgressVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAOSearchVERByApprovalNoRSQL(), param, velParam);				
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAProgressVO .class);
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
	 * DAR No. 에 해당되는 Approval Office를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RFAProgressVO> searchApprovalOfcByDAR(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAProgressVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
						new RFAExceptionTariffMgtDBDAOApprovalOfcByDARRSQL(), param, velParam);				
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAProgressVO .class);
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
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeAfterStatusVO> searchSCTariffListByDateUserIDRCV(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeAfterStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (beforeAfterStatusInputVO != null) {
				Map<String, String> mapVO = beforeAfterStatusInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Tariff
				String trfCd = beforeAfterStatusInputVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = trfCd.split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//2.Office
				String ofcCd = beforeAfterStatusInputVO.getUsrOfcCd();
				if (ofcCd != null && ofcCd.length() > 1) {
					List<String> ofcCdList = new ArrayList<String>();
					String[] ofcCdArray = ofcCd.split(",");
					for (int i = 0 ; i < ofcCdArray.length ; i++) {
						ofcCdList.add(ofcCdArray[i]);
				    }				
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchSCTariffListByDateUserIDRCVRSQL(), param, velParam);			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeAfterStatusVO .class);
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
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeAfterStatusVO> searchSCTariffListByDateUserOfficeRCV(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeAfterStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (beforeAfterStatusInputVO != null) {
				Map<String, String> mapVO = beforeAfterStatusInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Tariff
				String trfCd = beforeAfterStatusInputVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = trfCd.split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//2.Office
				String ofcCd = beforeAfterStatusInputVO.getUsrOfcCd();
				if (ofcCd != null && ofcCd.length() > 1) {
					List<String> ofcCdList = new ArrayList<String>();
					String[] ofcCdArray = ofcCd.split(",");
					for (int i = 0 ; i < ofcCdArray.length ; i++) {
						ofcCdList.add(ofcCdArray[i]);
				    }				
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchSCTariffListByDateUserOfficeRCVRSQL(), param, velParam);			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeAfterStatusVO .class);
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
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeAfterStatusVO> searchSCTariffListByDateUserIDSND(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeAfterStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (beforeAfterStatusInputVO != null) {
				Map<String, String> mapVO = beforeAfterStatusInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Tariff
				String trfCd = beforeAfterStatusInputVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = trfCd.split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//2.Office
				String ofcCd = beforeAfterStatusInputVO.getUsrOfcCd();
				if (ofcCd != null && ofcCd.length() > 1) {
					List<String> ofcCdList = new ArrayList<String>();
					String[] ofcCdArray = ofcCd.split(",");
					for (int i = 0 ; i < ofcCdArray.length ; i++) {
						ofcCdList.add(ofcCdArray[i]);
				    }				
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchSCTariffListByDateUserIDSNDRSQL(), param, velParam);			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeAfterStatusVO .class);
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
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeAfterStatusVO> searchSCTariffListByDateUserOfficeSND(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeAfterStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (beforeAfterStatusInputVO != null) {
				Map<String, String> mapVO = beforeAfterStatusInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Tariff
				String trfCd = beforeAfterStatusInputVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = trfCd.split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//2.Office
				String ofcCd = beforeAfterStatusInputVO.getUsrOfcCd();
				if (ofcCd != null && ofcCd.length() > 1) {
					List<String> ofcCdList = new ArrayList<String>();
					String[] ofcCdArray = ofcCd.split(",");
					for (int i = 0 ; i < ofcCdArray.length ; i++) {
						ofcCdList.add(ofcCdArray[i]);
				    }				
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchSCTariffListByDateUserOfficeSNDRSQL(), param, velParam);			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeAfterStatusVO .class);
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
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeAfterStatusVO> searchSCTariffListByDAR(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeAfterStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (beforeAfterStatusInputVO != null) {
				Map<String, String> mapVO = beforeAfterStatusInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Tariff
				String trfCd = beforeAfterStatusInputVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = trfCd.split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//2.Office
				String ofcCd = beforeAfterStatusInputVO.getUsrOfcCd();
				if (ofcCd != null && ofcCd.length() > 1) {
					List<String> ofcCdList = new ArrayList<String>();
					String[] ofcCdArray = ofcCd.split(",");
					for (int i = 0 ; i < ofcCdArray.length ; i++) {
						ofcCdList.add(ofcCdArray[i]);
				    }				
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchSCTariffListByDARRSQL(), param, velParam);			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeAfterStatusVO .class);
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
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeAfterStatusVO> searchBeforeBookingListByDateUserIDRCV(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeAfterStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (beforeAfterStatusInputVO != null) {
				Map<String, String> mapVO = beforeAfterStatusInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Tariff
				String trfCd = beforeAfterStatusInputVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = trfCd.split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//2.Office
				String ofcCd = beforeAfterStatusInputVO.getUsrOfcCd();
				if (ofcCd != null && ofcCd.length() > 1) {
					List<String> ofcCdList = new ArrayList<String>();
					String[] ofcCdArray = ofcCd.split(",");
					for (int i = 0 ; i < ofcCdArray.length ; i++) {
						ofcCdList.add(ofcCdArray[i]);
				    }				
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchBeforeBookingListByDateUserIDRCVRSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeAfterStatusVO .class);
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
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeAfterStatusVO> searchBeforeBookingListByDateUserOfficeRCV(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeAfterStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (beforeAfterStatusInputVO != null) {
				Map<String, String> mapVO = beforeAfterStatusInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Tariff
				String trfCd = beforeAfterStatusInputVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = trfCd.split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//2.Office
				String ofcCd = beforeAfterStatusInputVO.getUsrOfcCd();
				if (ofcCd != null && ofcCd.length() > 1) {
					List<String> ofcCdList = new ArrayList<String>();
					String[] ofcCdArray = ofcCd.split(",");
					for (int i = 0 ; i < ofcCdArray.length ; i++) {
						ofcCdList.add(ofcCdArray[i]);
				    }				
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchBeforeBookingListByDateUserOfficeRCVRSQL(), param, velParam);			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeAfterStatusVO .class);
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
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeAfterStatusVO> searchBeforeBookingListByDateUserIDSND(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeAfterStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (beforeAfterStatusInputVO != null) {
				Map<String, String> mapVO = beforeAfterStatusInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Tariff
				String trfCd = beforeAfterStatusInputVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = trfCd.split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//2.Office
				String ofcCd = beforeAfterStatusInputVO.getUsrOfcCd();
				if (ofcCd != null && ofcCd.length() > 1) {
					List<String> ofcCdList = new ArrayList<String>();
					String[] ofcCdArray = ofcCd.split(",");
					for (int i = 0 ; i < ofcCdArray.length ; i++) {
						ofcCdList.add(ofcCdArray[i]);
				    }				
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchBeforeBookingListByDateUserIDSNDRSQL(), param, velParam);			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeAfterStatusVO .class);
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
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeAfterStatusVO> searchBeforeBookingListByDateUserOfficeSND(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeAfterStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (beforeAfterStatusInputVO != null) {
				Map<String, String> mapVO = beforeAfterStatusInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Tariff
				String trfCd = beforeAfterStatusInputVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = trfCd.split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//2.Office
				String ofcCd = beforeAfterStatusInputVO.getUsrOfcCd();
				if (ofcCd != null && ofcCd.length() > 1) {
					List<String> ofcCdList = new ArrayList<String>();
					String[] ofcCdArray = ofcCd.split(",");
					for (int i = 0 ; i < ofcCdArray.length ; i++) {
						ofcCdList.add(ofcCdArray[i]);
				    }				
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchBeforeBookingListByDateUserOfficeSNDRSQL(), param, velParam);			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeAfterStatusVO .class);
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
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeAfterStatusVO> searchBeforeBookingListByDAR(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeAfterStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (beforeAfterStatusInputVO != null) {
				Map<String, String> mapVO = beforeAfterStatusInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Tariff
				String trfCd = beforeAfterStatusInputVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = trfCd.split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//2.Office
				String ofcCd = beforeAfterStatusInputVO.getUsrOfcCd();
				if (ofcCd != null && ofcCd.length() > 1) {
					List<String> ofcCdList = new ArrayList<String>();
					String[] ofcCdArray = ofcCd.split(",");
					for (int i = 0 ; i < ofcCdArray.length ; i++) {
						ofcCdList.add(ofcCdArray[i]);
				    }				
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchBeforeBookingListByDARRSQL(), param, velParam);			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeAfterStatusVO .class);
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
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeAfterStatusVO> searchAfterBookingListByDateUserIDRCV(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeAfterStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (beforeAfterStatusInputVO != null) {
				Map<String, String> mapVO = beforeAfterStatusInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Tariff
				String trfCd = beforeAfterStatusInputVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = trfCd.split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//2.Office
				String ofcCd = beforeAfterStatusInputVO.getUsrOfcCd();
				if (ofcCd != null && ofcCd.length() > 1) {
					List<String> ofcCdList = new ArrayList<String>();
					String[] ofcCdArray = ofcCd.split(",");
					for (int i = 0 ; i < ofcCdArray.length ; i++) {
						ofcCdList.add(ofcCdArray[i]);
				    }				
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchAfterBookingListByDateUserIDRCVRSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeAfterStatusVO .class);
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
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeAfterStatusVO> searchAfterBookingListByDateUserOfficeRCV(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeAfterStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (beforeAfterStatusInputVO != null) {
				Map<String, String> mapVO = beforeAfterStatusInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Tariff
				String trfCd = beforeAfterStatusInputVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = trfCd.split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//2.Office
				String ofcCd = beforeAfterStatusInputVO.getUsrOfcCd();
				if (ofcCd != null && ofcCd.length() > 1) {
					List<String> ofcCdList = new ArrayList<String>();
					String[] ofcCdArray = ofcCd.split(",");
					for (int i = 0 ; i < ofcCdArray.length ; i++) {
						ofcCdList.add(ofcCdArray[i]);
				    }				
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchAfterBookingListByDateUserOfficeRCVRSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeAfterStatusVO .class);
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
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeAfterStatusVO> searchAfterBookingListByDateUserIDSND(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeAfterStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (beforeAfterStatusInputVO != null) {
				Map<String, String> mapVO = beforeAfterStatusInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Tariff
				String trfCd = beforeAfterStatusInputVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = trfCd.split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//2.Office
				String ofcCd = beforeAfterStatusInputVO.getUsrOfcCd();
				if (ofcCd != null && ofcCd.length() > 1) {
					List<String> ofcCdList = new ArrayList<String>();
					String[] ofcCdArray = ofcCd.split(",");
					for (int i = 0 ; i < ofcCdArray.length ; i++) {
						ofcCdList.add(ofcCdArray[i]);
				    }				
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchAfterBookingListByDateUserIDSNDRSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeAfterStatusVO .class);
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
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeAfterStatusVO> searchAfterBookingListByDateUserOfficeSND(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeAfterStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (beforeAfterStatusInputVO != null) {
				Map<String, String> mapVO = beforeAfterStatusInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Tariff
				String trfCd = beforeAfterStatusInputVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = trfCd.split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//2.Office
				String ofcCd = beforeAfterStatusInputVO.getUsrOfcCd();
				if (ofcCd != null && ofcCd.length() > 1) {
					List<String> ofcCdList = new ArrayList<String>();
					String[] ofcCdArray = ofcCd.split(",");
					for (int i = 0 ; i < ofcCdArray.length ; i++) {
						ofcCdList.add(ofcCdArray[i]);
				    }				
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchAfterBookingListByDateUserOfficeSNDRSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeAfterStatusVO .class);
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
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeAfterStatusVO> searchAfterBookingListByDAR(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeAfterStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (beforeAfterStatusInputVO != null) {
				Map<String, String> mapVO = beforeAfterStatusInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1.Tariff
				String trfCd = beforeAfterStatusInputVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				String[] trfCdArray = trfCd.split(",");
				for (int i = 0 ; i < trfCdArray.length ; i++) {
					trfCdList.add(trfCdArray[i]);
			    }				
				velParam.put("trf_cd_list", trfCdList);
				
				//2.Office
				String ofcCd = beforeAfterStatusInputVO.getUsrOfcCd();
				if (ofcCd != null && ofcCd.length() > 1) {
					List<String> ofcCdList = new ArrayList<String>();
					String[] ofcCdArray = ofcCd.split(",");
					for (int i = 0 ; i < ofcCdArray.length ; i++) {
						ofcCdList.add(ofcCdArray[i]);
				    }				
					velParam.put("ofc_cd_list", ofcCdList);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchAfterBookingListByDARRSQL(), param, velParam);			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeAfterStatusVO .class);
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
	 * Before Booking Customer여부를 조회 합니다. <br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean isBeforeBKGCustomer(String custCntCd, String custSeq) throws DAOException {
		boolean result = false;		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("ctrt_cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOIsBeforeBKGCustomerRSQL(), param, null);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * Proposal No. 에 해당되는 Before Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeExceptionListInputVO beforeExceptionListInputVO
	 * @return List<BeforeExceptionListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeExceptionListVO> searchBeforeExceptionListByPropNo(BeforeExceptionListInputVO beforeExceptionListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeExceptionListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (beforeExceptionListInputVO != null) {
				Map<String, String> mapVO = beforeExceptionListInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchBeforeExceptionListByPropNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeExceptionListVO .class);
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
	 * Customer Code 와 RFA No. 에 해당되는 Before Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeExceptionListInputVO beforeExceptionListInputVO
	 * @return List<BeforeExceptionListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BeforeExceptionListVO> searchBeforeExceptionListByCustomer(BeforeExceptionListInputVO beforeExceptionListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BeforeExceptionListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (beforeExceptionListInputVO != null) {
				Map<String, String> mapVO = beforeExceptionListInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchBeforeExceptionListByCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeExceptionListVO .class);
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
	 * DAR No. 와 Version에 해당되는 Before Booking Exception를 삭제 합니다. <br>
	 * 
	 * @param  BeforeExceptionDeleteVO beforeExceptionDeleteVO
	 * @throws DAOException
	 */
	public void removeBeforeExceptionByDARVerNo(BeforeExceptionDeleteVO beforeExceptionDeleteVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (beforeExceptionDeleteVO != null) {
				Map<String, String> mapVO = beforeExceptionDeleteVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sQLExecuter = new SQLExecuter("");
			
			//1.Before Exception DAR 의 Rate Adjustment 정보를 삭제한다.
			sQLExecuter.executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAORemoveRTAdjustByDARVerNoDSQL(), param, velParam);
			
			//2.Before Exception DAR 의 Multi Origin or Dest. 정보를 삭제한다.
			sQLExecuter.executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAORemoveMultiCVRGByDARVerNoDSQL(), param, velParam);
			
			//3.Before Exception DAR 의 Tariff Detail 정보를 삭제한다.
			sQLExecuter.executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAORemoveBeforeExceptionByDARVerNoDSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 승인권한자를 조회 합니다. <br>
	 * 
	 * @param ApprovalRequestUserVO approvalRequestUserVO
	 * @param String condType
	 * @return List<ApprovalRequestUserListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ApprovalRequestUserListVO> searchApprovalAuthorityList(ApprovalRequestUserVO approvalRequestUserVO, String condType) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApprovalRequestUserListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (approvalRequestUserVO != null) {
				Map<String, String> mapVO = approvalRequestUserVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("cond_type", condType);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchApprovalAuthorityListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApprovalRequestUserListVO .class);
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
	 * DMT03 권한을 가진 사용자인지 조회 합니다. <br>
	 * 
	 * @param String usrId
	 * @param String roleId
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchOwnedRole(String usrId, String roleId) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("usr_id", usrId);
			param.put("usr_role_cd", roleId);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchOwnedRoleRSQL(), param, null);
			
			if (dbRowset.next()) {
				result = dbRowset.getInt(1) > 0 ? true : false;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 특정 Version 정보가 존재하는지 조회 합니다. <br>
	 * 
	 * @param BeforeExceptionVersionVO beforeExceptionVersionVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean existBeforeExceptionVersion(BeforeExceptionVersionVO beforeExceptionVersionVO) throws DAOException {
		boolean 				result 		= false;
		DBRowSet 				dbRowset 	= null;		
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();
		
		try{
			if (beforeExceptionVersionVO != null) {
				Map<String, String> mapVO = beforeExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOExistBeforeExceptionVersionRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Before Booking Request Version 의 상태를 수정 합니다. <br>
	 * 
	 * @param BeforeExceptionVersionVO beforeExceptionVersionVO
	 * @throws DAOException
	 */
	public void modifyVersionSTS(BeforeExceptionVersionVO beforeExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (beforeExceptionVersionVO != null) {
				Map<String, String> mapVO = beforeExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOModifyVersionSTSUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Before Booking Request 에 생성된 이력중 마지막 이력상태가 'Temp.Saved' 인지를 조회 합니다. <br>
	 * 
	 * @param BeforeExceptionVersionVO beforeExceptionVersionVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean isTempSavedStatusOfLastVersionProg(BeforeExceptionVersionVO beforeExceptionVersionVO) throws DAOException {
		boolean				result		= false;
		DBRowSet			dbRowset	= null;
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();

		try{
			if (beforeExceptionVersionVO != null) {
				Map<String, String> mapVO = beforeExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOIsTempSavedStatusOfLastVersionProgRSQL(), param, velParam);

			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	
	/**
	 * Before Booking Request 의 이력중 마지막 Prog 의 상태가 'Temp.Saved' 인 경우, 그 수정자정보를 수정 합니다. <br>
	 * 
	 * @param BeforeExceptionVersionVO beforeExceptionVersionVO
	 * @throws DAOException
	 */
	public void modifyLastVersionProg(BeforeExceptionVersionVO beforeExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (beforeExceptionVersionVO != null) {
				Map<String, String> mapVO = beforeExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOModifyLastVersionProgUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Version No.에 해당하는 Before Exception Request 의 Version 정보를 삭제 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */	
	public void removeBeforeExceptionVersion(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
			}	

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAORemoveBeforeExceptionVersionDSQL(), param, null);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Version No.에 해당하는 Before Exception Request 의 Prog 정보를 삭제 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */	
	public void removeBeforeExceptionVersionProg(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
			}	

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAORemoveBeforeExceptionVersionProgDSQL(), param, null);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C 의 버전상태가 변경될 경우 그 이력을 생성 합니다. <br>
	 * 
	 * @param BeforeExceptionVersionVO beforeExceptionVersionVO
	 * @throws DAOException
	 */
	public void addBeforeExceptionVersionProg(BeforeExceptionVersionVO beforeExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (beforeExceptionVersionVO != null) {
				Map<String, String> mapVO = beforeExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOAddBeforeExceptionVersionProgCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 선택한 Before Booking Request 의 다음 Detail Seq. 정보를 조회 합니다.<br>
	 * 
	 * @param  BeforeExceptionVO beforeExceptionVO
	 * @return String
	 * @throws DAOException
	 */	
	public String searchBeforeExceptionDetailSeq(BeforeExceptionVO beforeExceptionVO)  throws DAOException {
		String				result		= null;
		DBRowSet			dbRowset	= null;
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (beforeExceptionVO != null) {
				Map<String, String> mapVO = beforeExceptionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchBeforeExceptionDetailSeqRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getInt(1) + "";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Before Booking Request 의 Detail 정보를 생성 합니다. <br>
	 * 
	 * @param BeforeExceptionVO beforeExceptionVO
	 * @throws DAOException
	 */
	public void addBeforeExceptionDetail(BeforeExceptionVO beforeExceptionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (beforeExceptionVO != null) {
				Map<String, String> mapVO = beforeExceptionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOAddBeforeExceptionTariffCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Before Booking Request 의 Detail 정보를 수정 합니다. <br>
	 * 
	 * @param BeforeExceptionVO beforeExceptionVO
	 * @throws DAOException
	 */
	public void modifyBeforeExceptionDetail(BeforeExceptionVO beforeExceptionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (beforeExceptionVO != null) {
				Map<String, String> mapVO = beforeExceptionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOModifyBeforeExceptionTariffUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Before Booking Request 의 Version 에 포함된 Detail 정보가 존재하는지 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return boolean
	 * @throws DAOException
	 */	
	public boolean existBeforeException(RFAProgressVO rFAProgressVO) throws DAOException {
		boolean 				result 		= false;
		DBRowSet 				dbRowset 	= null;		
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOExistBeforeExceptionDetailRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Version No. 에 해당하는 Before Exception를 삭제 합니다. <br>
	 * 
	 * @param  BeforeExceptionDeleteVO beforeExceptionDeleteVO
	 * @throws DAOException
	 */
	public void removeBeforeExceptionByVerNo(BeforeExceptionDeleteVO beforeExceptionDeleteVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (beforeExceptionDeleteVO != null) {
				Map<String, String> mapVO = beforeExceptionDeleteVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sQLExecuter = new SQLExecuter("");
			
			//1.Before Booking Request 의 Detail Seq. 에 해당되는 Rate Adjustment 정보를 삭제한다.
			sQLExecuter.executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAORemoveRateAdjustmentByVerNoDSQL(), param, velParam);

			//2.Before Booking Request 의 Detail Seq. 에 해당되는 Multi Origin or Dest. 정보를 삭제한다.
			sQLExecuter.executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAORemoveMultiCoverageByVerNoDSQL(), param, velParam);
			
			//3.Before Booking Request 의 Detail 정보를 삭제한다.
			sQLExecuter.executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAORemoveBeforeExceptionByVerNoDSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * DAR History 팝업에서 선택한 버전의 모든 Before Exception Request 의 Detail 정보를 현재 버전으로 생성 합니다.<br>
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void addBeforeExceptionDetailOfHistVersion(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOAddBeforeExceptionDetailOfHistVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * DAR History 팝업에서 선택한 버전의 모든 Before Exception Request 의 Detail 에 해당되는 Multi Origin or Dest. 정보를 현재 버전으로 생성 합니다.<br>
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void addBeforeExceptionCoverageOfHistVersion(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOAddBeforeExceptionCoverageOfHistVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * DAR History 팝업에서 선택한 버전의 모든 Before Exception Request 의 Detail 에 해당되는 Rate Adjustment 정보를 현재 버전으로 생성 합니다.<br>
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void addBeforeExceptionRateAdjustmentOfHistVersion(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOAddBeforeExceptionRateAdjustmentOfHistVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 선택한 Before Exception Request 의 다음 Version Seq. 정보를 조회 합니다.<br>
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @return String
	 * @throws DAOException
	 */	
	public String searchBeforeExceptionVersionSeq(RFAProgressVO rFAProgressVO)  throws DAOException {
		String				result		= null;
		DBRowSet			dbRowset	= null;
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchBeforeExceptionVersionSeqRSQL(), param, null);
			
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 이전 버전의 모든 Before Booking Request 의 Detail 정보를 신규 버전으로 생성 합니다.<br>
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void addBeforeExceptionDetailOfPrevVersion(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOAddBeforeExceptionDetailOfPrevVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 이전 버전의 모든 Before Booking Request 의 Detail 에 해당되는  Multi Origin or Dest. 정보를 신규 버전으로 생성 합니다.<br>
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void addBeforeExceptionCoverageOfPrevVersion(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOAddBeforeExceptionCoverageOfPrevVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 이전 버전의 모든 Before Booking Request 의 Detail 에 해당되는 Rate Adjustment 정보를 신규 버전으로 생성 합니다.<br>
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void addBeforeExceptionRateAdjustmentOfPrevVersion(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOAddBeforeExceptionRateAdjustmentOfPrevVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 선택한 Before Exception Request 의 Detail 에 해당하는 모든 Rate Adjustment 정보를 삭제 합니다.<br>
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void removeBeforeExceptionRateAdjustment(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAORemoveBeforeExceptionRateAdjustmentDSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 선택한 Before Exception Request 의 Detail 에 해당하는 모든 Multi Origin or Dest. 정보를 삭제 합니다.<br>
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void removeBeforeExceptionCoverage(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAORemoveBeforeExceptionCoverageByDetailSeqDSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * 선택한 Before Exception Request 의 Detail 정보를 삭제 합니다.<br>
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void removeBeforeExceptionDetail(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAORemoveBeforeExceptionDetailDSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 화면에서 입력한 RFA 정보와 기등록된 RFA 정보중 중복된 데이터가 있는지 조회 합니다.<br>
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean isDuplicateRFA(RFAProgressVO rFAProgressVO) throws DAOException {
		//result object
		boolean 				isDuplicate	= false;
		DBRowSet				dbRowSet	= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//Coverage >==================================================================================
				List<String> 	coverageList 	= new ArrayList<String>();
				String[] 		coverageArray 	= rFAProgressVO.getCoverageList().split("\\|");
				for (int i = 0 ; i < coverageArray.length ; i++) {
					coverageList.add(coverageArray[i]);
				}				
				velParam.put("list_coverage", coverageList);
				
				//Commodity >==================================================================================
				List<String> 	cmdtList 	= new ArrayList<String>();
				String[] 		cmdtArray 	= rFAProgressVO.getCmdtList().split("\\|");
				for (int i = 0 ; i < cmdtArray.length ; i++) {
					cmdtList.add(cmdtArray[i]);
				}				
				velParam.put("list_cmdt", cmdtList);
				//============================================================================================
			}

			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOIsDuplicateRFARSQL(), param, velParam);
			
			if (dbRowSet.next()) {
				isDuplicate = dbRowSet.getInt(1) > 0 ? true : false;
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isDuplicate;
	}	
	
	/**
	 * Approval, Counter Offer, Reject 시 최종 Update Date 를 조회 합니다.<br>
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchUpdateDate(RFAProgressVO rFAProgressVO) throws DAOException {
		//result object
		String 					result		= null;
		DBRowSet				dbRowSet	= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchUpdateDateRSQL(), param, velParam);
			
			if (dbRowSet.next()) {
				result = dbRowSet.getString(1);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Before Booking의 APVL No. 에 해당되는 APVL OFC, DAR No., Version, Status 를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RFAProgressVO> searchRFATariffByAPVLNo(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAProgressVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new RFAExceptionTariffMgtDBDAOSearchRFATariffByAPVLNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAProgressVO .class);
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
	 * Proposal No.나 DAR No. 로 Approval No.를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return RFAProgressVO
	 * @throws DAOException
	 */
	public RFAProgressVO searchAproNoByPropApprovalNo(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet				dbRowset	= null;
		RFAProgressVO 			returnVO 	= new RFAProgressVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();
		
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAExceptionTariffMgtDBDAOSearchAproNoByPropApprovalNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnVO.setRfaExptAproNo(dbRowset.getString(1));
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}	
		 
	 
	/**
	 * Before Booking Exception-Tiered Free Time 조회 합니다. <br>
	 * [2016.01.04] NYK Add
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionFreeTimeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 public List<RFAExceptionFreeTimeVO> searchTieredFreeTimeByRFA(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAExceptionFreeTimeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAExceptionTariffMgtDBDAOSearchTieredFreeTimeByRFARSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAExceptionFreeTimeVO .class);
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
	 * Before Booking Exception-Commodity 조회 합니다. <br>
	 * [2016.01.04] NYK Add
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCommodityVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 public List<RFAExceptionCommodityVO> searchCommodityListByRFA(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAExceptionCommodityVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAExceptionTariffMgtDBDAOSearchCommodityListByRFARSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAExceptionCommodityVO .class);
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
	 * RFA Exception Free Time 다건의 데이터를 일괄적으로 삭제 합니다. <br>
	 * [2016.01.04] NYK Add
	 * @param List<RFAExceptionFreeTimeVO> rFAExceptionFreeTimeVOs
	 * @throws DAOException
	 */
	public void removeRFAExceptionTieredFreeTimes(List<RFAExceptionFreeTimeVO> rFAExceptionFreeTimeVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(rFAExceptionFreeTimeVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAExceptionTariffMgtDBDAORemoveTieredFreeTimeDSQL(), rFAExceptionFreeTimeVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * RFA Exception Commodity All 데이터를 삭제 합니다. <br>
	 * [2016.01.04] NYK Add
	 * @param RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void removeRFAExceptionCommodityAll(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new RFAExceptionTariffMgtDBDAORemoveCommodityAllDSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * RFA Exception Free Time 다건의 데이터를 일괄적으로 생성 합니다. <br>
	 * [2016.01.04] NYK Add
	 * @param List<RFAExceptionFreeTimeVO> rFAExceptionFreeTimeVOs
	 * @throws DAOException
	 */
	public void addRFAExceptionTieredFreeTimes(List<RFAExceptionFreeTimeVO> rFAExceptionFreeTimeVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(rFAExceptionFreeTimeVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAExceptionTariffMgtDBDAOAddTieredFreeTimeCSQL(), rFAExceptionFreeTimeVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * RFA Exception Commodity 다건의 데이터를 일괄적으로 생성 합니다. <br>
	 * [2016.01.04] NYK Add
	 * @param List<RFAExceptionCommodityVO> rFAExceptionCommodityVOs
	 * @throws DAOException
	 */
	public void addRFAExceptionCommodities(List<RFAExceptionCommodityVO> rFAExceptionCommodityVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(rFAExceptionCommodityVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAExceptionTariffMgtDBDAOAddCommodityCSQL(), rFAExceptionCommodityVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * RFA Exception Free Time 다건의 데이터를 일괄적으로 수정 합니다. <br>
	 * [2016.01.04] NYK Add
	 * @param List<RFAExceptionFreeTimeVO> rFAExceptionFreeTimeVOs
	 * @throws DAOException
	 */
	public void modifyRFAExceptionTieredFreeTimes(List<RFAExceptionFreeTimeVO> rFAExceptionFreeTimeVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int upsCnt[] = null;
			if(rFAExceptionFreeTimeVOs.size() > 0){
				upsCnt = sqlExe.executeBatch((ISQLTemplate)new RFAExceptionTariffMgtDBDAOModifyTieredFreeTimeUSQL(), rFAExceptionFreeTimeVOs, null);
				for(int i = 0; i < upsCnt.length; i++){
					if(upsCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Before Booking Exception-Default Commodity 조회 합니다. <br>
	 * [2016.01.04] NYK Add
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCommodityVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 public List<RFAExceptionCommodityVO> searchCommodityDefaultListByRFA(RFAProgressVO rFAProgressVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RFAExceptionCommodityVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAExceptionTariffMgtDBDAOSearchCommodityDefaultListByRFARSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RFAExceptionCommodityVO .class);
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
	 * 이전 버전의 모든 Before Booking Request 의 Detail 에 해당되는 Tiered Free Time를 신규 버전으로 Create 합니다. <br>
	 * [2016.01.04] NYK Add
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void addBeforeExceptionTieredFreeTimeOfPrevVersion(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new RFAExceptionTariffMgtDBDAOAddBeforeExceptionTieredFreeTimeOfPrevVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 이전 버전의 모든 Before Booking Request 의 Detail 에 해당되는 Commodity를 신규 버전으로 Create 합니다.  <br>
	 * [2016.01.04] NYK Add
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void addBeforeExceptionCommodityOfPrevVersion(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
	
			new SQLExecuter("").executeUpdate((ISQLTemplate)new RFAExceptionTariffMgtDBDAOAddBeforeExceptionCommodityOfPrevVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 선택한 Before Exception Request 의 Detail 에 해당하는 모든 Tiered Free Time. 정보를 삭제 합니다.<br>
	 * [2016.01.04] NYK Add
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void removeBeforeExceptionTieredFreeTimeByDetailSeq(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new RFAExceptionTariffMgtDBDAORemoveBeforeExceptionTieredFreeTimeByDetailSeqDSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 선택한 Before Exception Request 의 Detail 에 해당하는 모든 Commodity. 정보를 삭제 합니다.<br>
	 * [2016.01.04] NYK Add
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void removeBeforeExceptionCommodityByDetailSeq(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new RFAExceptionTariffMgtDBDAORemoveBeforeExceptionCommodityByDetailSeqDSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * DAR History 팝업에서 선택한 버전의 모든 Before Exception Request 의 Detail 에 해당되는 Tiered Free Time. 정보를 현재 버전으로 생성 합니다.<br>
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void addBeforeExceptionTieredFreeTimeOfHistVersion(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new RFAExceptionTariffMgtDBDAOAddBeforeExceptionTieredFreeTimeOfHistVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * DAR History 팝업에서 선택한 버전의 모든 Before Exception Request 의 Detail 에 해당되는 Commodity. 정보를 현재 버전으로 생성 합니다.<br>
	 * 
	 * @param  RFAProgressVO rFAProgressVO
	 * @throws DAOException
	 */
	public void addBeforeExceptionCommodityOfHistVersion(RFAProgressVO rFAProgressVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (rFAProgressVO != null) {
				Map<String, String> mapVO = rFAProgressVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new RFAExceptionTariffMgtDBDAOAddBeforeExceptionCommodityOfHistVersionCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
}