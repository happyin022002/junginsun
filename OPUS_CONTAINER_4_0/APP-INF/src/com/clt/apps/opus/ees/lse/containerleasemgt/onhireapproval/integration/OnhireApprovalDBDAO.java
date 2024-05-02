/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireApprovalDBDAO.java
*@FileTitle : On Hire Approval inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* =======================================================
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration; 

import java.sql.Array;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.basic.OnhireApprovalBCImpl;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalOwnListVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.LseOnhAproVO;


/**
 * OnhireApprovalDBDAO <br>
 * ContainerLeaseMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jin Jun Sung
 * @see OnhireApprovalBCImpl 참조
 * @since J2EE 1.6
 */
public class OnhireApprovalDBDAO extends DBDAOSupport { 

	/**
	 *
	 */
	private static final long serialVersionUID = 2617667291695384433L;

	/**
	 *Onhire 될 장비의 Approval number 내용을 조회<br>
	 *
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @return List<OnhireApprovalVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OnhireApprovalVO> searchOnhireApprovalNumberData(OnhireApprovalVO onhireApprovalVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OnhireApprovalVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(onhireApprovalVO != null){
				
				Map<String, String> mapVO = onhireApprovalVO.getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				
				List<String> arrTysz   = null;
				List<String> arrSTpszCd   = null;
                arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(onhireApprovalVO.getTysz(),",","|"));
                param.put("tysz"    , arrTysz);
                velParam.put("tysz" , arrTysz);
                
                arrSTpszCd   = JSPUtil.convertStringToArrayList(JSPUtil.replace(onhireApprovalVO.getTpszCd(),",","|"));
                param.put("stpsz_cd"    , arrSTpszCd);
                velParam.put("stpsz_cd" , arrSTpszCd);
                
                String strofcType = onhireApprovalVO.getUsrOfcCd().substring(onhireApprovalVO.getUsrOfcCd().length()-2,onhireApprovalVO.getUsrOfcCd().length());
                
                param.put("usr_ofc_cd"    , strofcType);
                velParam.put("usr_ofc_cd" , strofcType);
			}

			dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchOnhireApprovalNumberRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OnhireApprovalVO .class);

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
		 * OnhireApproval화면에 대한  Auth No조회<br>
		 *
		 * @param  String pOnhLocCd
		 * @param  String pLstmCd
	     * @param  String periodStdt
	     * @param  String periodEddt
	     * @param  String cntrOnhAuthNo
		 * @return List<LseOnhAproVO>
		 * @throws DAOException
		 */
	@SuppressWarnings("unchecked")
	public List<LseOnhAproVO> searchOnhireApprovalNumberBrieflyData(String pOnhLocCd , String pLstmCd , String cntrOnhAuthNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<LseOnhAproVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

//			periodStdt = periodStdt.replaceAll("-", "");
//			periodEddt = periodEddt.replaceAll("-", "");

			param.put("loc_cd"      , pOnhLocCd);
			param.put("ls_tm_cd"    , pLstmCd);
			param.put("cntr_onh_auth_no" , cntrOnhAuthNo);
//			param.put("period_stdt" , periodStdt);
//			param.put("period_eddt" , periodEddt);
//
//			velParam.put("period_stdt" , periodStdt);
//			velParam.put("period_eddt" , periodEddt);
			velParam.put("cntr_onh_auth_no" , cntrOnhAuthNo);

			dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchOnhireApprovalNumberBasicRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LseOnhAproVO .class);

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
	 * LSE_ONH_APRO  cntr_onh_auth_no 를 생성한다. .<br>
	 *
	 * @param  String cntOnhAuthNo
     * @param  String onhLocCd
     * @param  String lstmCd
     * @param  String agmtSeq
	 * @return String
	 * @throws DAOException
	 */
	public String addOnhireApprovalAuthNoData(String cntrOnhAuthNo , String onhLocCd , String lstmCd, String agmtSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String authNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
            param.put("cntr_onh_auth_no"  , cntrOnhAuthNo);
			param.put("agmt_seq"          , agmtSeq);            
			param.put("onh_loc_cd"        , onhLocCd);
			param.put("lstm_cd"           , lstmCd);

			dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOcreateOnhireApprovalAuthNoRSQL(), param, velParam);
			if(dbRowset.next()){
				authNo=	dbRowset.getString("CNTR_ONH_AUTH_NO");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return authNo;
	}
	/**
	 * LSE_ONH_APRO를 생성한다. .<br>
	 *
	 * @param  String cntrOnhAuthNo
	 * @param  String agmtCtyCd
	 * @param  String agmtSeq
	 * @param  String lstmCd
	 * @param  String onhLocCd
	 * @param  String pkupFmDt
	 * @param  String pkupDueDt
	 * @param  String mftYr
	 * @param  String freeDys
	 * @param  String pkupChgAmt
	 * @param  String pkupChgCrAmt
	 * @param  String minOnhDys
	 * @param  String aproRmk
	 * @param  String creUsrId
	 * @param  String retrunLccCd    
	 * @throws DAOException
	 */
	public void addOnhireApprovalNumberData(String cntrOnhAuthNo ,String agmtCtyCd ,String agmtSeq ,String lstmCd ,String onhLocCd ,String pkupFmDt ,String pkupDueDt ,String mftYr ,String freeDys ,String pkupChgAmt ,String pkupChgCrAmt ,String minOnhDys ,String aproRmk ,String creUsrId,String retrunLccCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("cntr_onh_auth_no"  , cntrOnhAuthNo);
			param.put("agmt_cty_cd"       , agmtCtyCd);
			param.put("agmt_seq"          , agmtSeq);
			param.put("lstm_cd"           , lstmCd);
			param.put("onh_loc_cd"        , onhLocCd);
			param.put("pkup_fm_dt"        , pkupFmDt);
			param.put("pkup_due_dt"       , pkupDueDt);
			param.put("mft_yr"            , mftYr);
			param.put("free_dys"          , freeDys);
			param.put("pkup_chg_amt"      , pkupChgAmt);
			param.put("pkup_chg_cr_amt"   , pkupChgCrAmt);
			param.put("min_onh_dys"       , minOnhDys);
			param.put("apro_rmk"          , aproRmk);
			param.put("cre_usr_id"        , creUsrId);
			param.put("upd_usr_id"        , creUsrId);
			param.put("return_lcc"        , retrunLccCd);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new OnhireApprovalDBDAOaddOnhireApprovalNumberCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
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
	 * LSE_ONH_APRO_QTY   를 생성한다. .<br>
	 *
	 * @param  String cntrOnhAuthNo
	 * @param  String agmtCtyCd
	 * @param  String agmtSeq
	 * @param  String cntrTpszCd
	 * @param  String newVanTpCd
	 * @param  String pkupChgQty
	 * @param  String onhQty
 	 * @param  String lftChgAmt
	 * @param  String creusrId
	 * @throws DAOException
	 */
	public void addOnhireApprovalNumberQtyData(String cntrOnhAuthNo  , String agmtCtyCd , String agmtSeq , String cntrTpszCd , String newVanTpCd , String pkupChgQty , String onhQty , String lftChgAmt ,String creusrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
		    param.put("cntr_onh_auth_no" , cntrOnhAuthNo);
			param.put("agmt_cty_cd"      , agmtCtyCd);
			param.put("agmt_seq"         , agmtSeq);
			param.put("cntr_tpsz_cd"     , cntrTpszCd);
			param.put("new_van_tp_cd"    , newVanTpCd);
			param.put("onh_qty"          , onhQty);
			if(newVanTpCd != null && "O".equals(newVanTpCd)){
				param.put("lft_chg_amt"  , lftChgAmt);
			}else{
				param.put("lft_chg_amt"  , null);
			}
			param.put("cre_usr_id"       , creusrId);
			param.put("upd_usr_id"       , creusrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new OnhireApprovalDBDAOaddOnhireApprovalNumberQtyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
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
	 * 임차 컨테이너 상세한 pick-up 승인 수정내용을 조회한다.<br>
	 *
	 * @param  String authNo
	 * @param  String tysz
	 * @return List<OnhireApprovalVO>
	 * @throws DAOException
	 */

	@SuppressWarnings("unchecked")
	public List<OnhireApprovalVO> searchOnhireApprovalNumber2Data(String authNo , String tysz) throws DAOException {
		DBRowSet dbRowset = null;
		List<OnhireApprovalVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			List<String> arrTysz   = null;
            arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(tysz,",","|"));

			param.put("cntr_onh_auth_no" , authNo);
			param.put("tysz"             , arrTysz);

			velParam.put("cntr_onh_auth_no" , authNo);
			velParam.put("tysz"          , arrTysz);

			dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchOnhireApprovalNumber2RSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OnhireApprovalVO .class);
			
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
	 * Auth No. 를 사용한 Container 존재여부를 조회한다.<br>
	 *
	 * @param  String authNo
	 * @return int
	 * @throws DAOException
	 */
	public int searchCntrAuthNoCountData(String authNo) throws DAOException {
		DBRowSet dbRowset = null;
		int cntrAuthNoCnt = 0;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("cntr_auth_no" , authNo);

			dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchContainerCountUsedAuthNoRSQL(), param, param);

			if(dbRowset.next()) {
				cntrAuthNoCnt = dbRowset.getInt("CNT");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cntrAuthNoCnt;
	}

	/**
	 * 임차 컨테이너 상세한 pick-up 승인에 대한 취소처리<br>
	 *
	 * @param String authNo
	 * @param String agmtCtyCd
	 * @param String agmtSeq
	 * @param SignOnUserAccount accoun
	 * @throws DAOException
	 */

	public void modifyOnhireApprovalNumberData(String authNo , String agmtCtyCd ,String agmtSeq , SignOnUserAccount accoun) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("upd_usr_id" , accoun.getUsr_id());
			param.put("cntr_onh_auth_no" , authNo);
			param.put("agmt_cty_cd" , agmtCtyCd);
			param.put("agmt_seq" , agmtSeq);


			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new OnhireApprovalDBDAOcancelOnhireApprovalNumberUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * LSE_ONH_APRO   를 삭제한다. .<br>
	 *
	 * @param  String cntrOnhAuthNo
	 * @throws DAOException
	 */
	public void removeOnhireApprovalNumberData(String cntrOnhAuthNo ) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
		    param.put("cntr_onh_auth_no" , cntrOnhAuthNo);

		    SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new OnhireApprovalDBDAOdeleteOnhireApprovalNumberDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
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
	 * LSE_ONH_APRO_QTY   를 삭제한다. .<br>
	 *
	 * @param  String cntrOnhAuthNo
	 * @throws DAOException
	 */
	public void removeOnhireApprovalNumber2Data(String cntrOnhAuthNo ) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
		  param.put("cntr_onh_auth_no" , cntrOnhAuthNo);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new OnhireApprovalDBDAOdeleteOnhireApprovalNumber2DSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
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
	 *자가컨테이너 pick up 한 장비를 auth no를 부여하기위하여 내용을 조회 <br>
	 *
	 * @param  String loc_cd
	 * @param  String loc_tp
	 * @return List<OnhireApprovalOwnListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OnhireApprovalOwnListVO> searchApprovalOwnListData(String loc_cd ,String loc_tp ) throws DAOException {
		DBRowSet dbRowset = null;
		List<OnhireApprovalOwnListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			param.put("loc_cd" , loc_cd);
			param.put("loc_tp" , loc_tp);

			dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchApprovalOwnListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OnhireApprovalOwnListVO .class);

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
	 * OnhireApproval화면에 대한 자가장비 Sum 조회 이벤트 처리.<br>
	 *
	 * @param  String loc_cd
	 * @param  String loc_tp
	 * @return List<OnhireApprovalOwnListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OnhireApprovalOwnListVO> searchApprovalOwnSumListData(String loc_cd ,String loc_tp ) throws DAOException {
		DBRowSet dbRowset = null;
		List<OnhireApprovalOwnListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			param.put("loc_cd" , loc_cd);
			param.put("loc_tp" , loc_tp);

			dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchApprovalOwnSumListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OnhireApprovalOwnListVO .class);

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
	 * 장/단기 컨테이너 임차계약후 pick-up 승인에 대한 pick-up 수량을 조회<br>
	 *
	 * @param  SearchApprovalVO searchApprovalVO
	 * @return List<SearchApprovalVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchApprovalVO> searchPickupStatusSummaryData(SearchApprovalVO searchApprovalVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchApprovalVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			String period_stdt = searchApprovalVO.getPeriodStdt();
			period_stdt = period_stdt.replaceAll("-", "");
			String period_eddt = searchApprovalVO.getPeriodEddt();
			period_eddt = period_eddt.replaceAll("-", "");
			String pkup_due_dt = searchApprovalVO.getPkupDueDt();
			pkup_due_dt = pkup_due_dt.replaceAll("-", "");

			List<String> arrLstmCd      = null;
			arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchApprovalVO.getLstmCd(),",","|"));

			List<String> arrCntrTpszCd      = null;
			arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchApprovalVO.getCntrTpszCd(),",","|"));

			List<String> arrTysz   = null;
            arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchApprovalVO.getTysz(),",","|"));

			param.put("loc_cd"            , searchApprovalVO.getLocCd());
			param.put("loc_tp"            , searchApprovalVO.getLocTp());
			param.put("period_stdt"       , period_stdt);
			param.put("period_eddt"       , period_eddt);
			param.put("auth_no"           , searchApprovalVO.getAuthNo());
			param.put("agmt_cty_cd"       , searchApprovalVO.getAgmtCtyCd());
			param.put("agmt_seq"          , searchApprovalVO.getAgmtSeq());
			param.put("new_van_tp_cd"     , searchApprovalVO.getNewVanTpCd());
			param.put("pkup_due_dt"       , pkup_due_dt);
			param.put("lstm_cd"           , arrLstmCd);
			param.put("lstm_cd_str"       , searchApprovalVO.getLstmCd());
			param.put("cntr_tpsz_cd"      , arrCntrTpszCd);
			param.put("cntr_tpsz_cd_str"  , searchApprovalVO.getCntrTpszCd());
			param.put("tysz"              , arrTysz);
			param.put("lstm_tp_cd"  	  , searchApprovalVO.getLstmTpCd());

			velParam.put("loc_cd"           , searchApprovalVO.getLocCd());
			velParam.put("loc_tp"           , searchApprovalVO.getLocTp());
			velParam.put("period_stdt"      , period_stdt);
			velParam.put("period_eddt"      , period_eddt);
			velParam.put("auth_no"          , searchApprovalVO.getAuthNo());
			velParam.put("agmt_cty_cd"      , searchApprovalVO.getAgmtCtyCd());
			velParam.put("agmt_seq"         , searchApprovalVO.getAgmtSeq());
			velParam.put("new_van_tp_cd"    , searchApprovalVO.getNewVanTpCd());
			velParam.put("pkup_due_dt"      , pkup_due_dt);
			velParam.put("lstm_cd"          , arrLstmCd);
			velParam.put("lstm_cd_str"      , searchApprovalVO.getLstmCd());
			velParam.put("cntr_tpsz_cd"     , arrCntrTpszCd);
			velParam.put("cntr_tpsz_cd_str" , searchApprovalVO.getCntrTpszCd());
			velParam.put("tysz"             , arrTysz);
			velParam.put("lstm_tp_cd"  	  , searchApprovalVO.getLstmTpCd());

			dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchPickupStatusSummaryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchApprovalVO .class);

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
	 * 장/단기 컨테이너 임차계약후 pick-up 승인에 대한 pick-up 수량을 상세조회<br>
	 *
	 * @param  SearchApprovalDetailVO SearchApprovalDetailVO
	 * @return List<SearchApprovalDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchApprovalDetailVO> searchPickupStatusDetailData(SearchApprovalDetailVO SearchApprovalDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchApprovalDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			String period_stdt = SearchApprovalDetailVO.getPeriodStdt();
			period_stdt = period_stdt.replaceAll("-", "");
			String period_eddt = SearchApprovalDetailVO.getPeriodEddt();
			period_eddt = period_eddt.replaceAll("-", "");
			String pkup_due_dt = SearchApprovalDetailVO.getPkupDueDt();
			pkup_due_dt = pkup_due_dt.replaceAll("-", "");

			List<String> arrLstmCd      = null;
			arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(SearchApprovalDetailVO.getLstmCd(),",","|"));

			List<String> arrCntrTpszCd      = null;
			arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(SearchApprovalDetailVO.getCntrTpszCd(),",","|"));
			
			param.put("loc_cd"              , SearchApprovalDetailVO.getLocCd());
			param.put("loc_tp"              , SearchApprovalDetailVO.getLocTp());
			param.put("period_stdt"         , period_stdt);
			param.put("period_eddt"         , period_eddt);
			param.put("auth_no"             , SearchApprovalDetailVO.getAuthNo());
			param.put("agmt_cty_cd"         , SearchApprovalDetailVO.getAgmtCtyCd());
			param.put("agmt_seq"            , SearchApprovalDetailVO.getAgmtSeq());
			param.put("new_van_tp_cd"       , SearchApprovalDetailVO.getNewVanTpCd());
			param.put("pkup_due_dt"         , pkup_due_dt);
			param.put("lstm_cd"             , arrLstmCd);
			param.put("lstm_cd_str"         , SearchApprovalDetailVO.getLstmCd());
			param.put("cntr_tpsz_cd"        , arrCntrTpszCd);
			param.put("cntr_tpsz_cd_str"    , SearchApprovalDetailVO.getCntrTpszCd());
			if(!"G.TTL".equals(SearchApprovalDetailVO.getDetailAuthNo())) {
				param.put("detail_auth_no"      , SearchApprovalDetailVO.getDetailAuthNo());
				param.put("detail_agmt_cty_cd"  , SearchApprovalDetailVO.getDetailAgmtCtyCd());
				param.put("detail_agmt_seq"     , SearchApprovalDetailVO.getDetailAgmtSeq());
			}
			param.put("detail_cntr_tpsz_cd" , SearchApprovalDetailVO.getDetailCntrTpszCd());
			param.put("detail_divsion"      , SearchApprovalDetailVO.getDetailDivsion());
			param.put("lstm_tp_cd"  	  , SearchApprovalDetailVO.getLstmTpCd());

			velParam.put("loc_cd"              , SearchApprovalDetailVO.getLocCd());
			velParam.put("loc_tp"              , SearchApprovalDetailVO.getLocTp());
			velParam.put("period_stdt"         , period_stdt);
			velParam.put("period_eddt"         , period_eddt);
			velParam.put("auth_no"             , SearchApprovalDetailVO.getAuthNo());
			velParam.put("agmt_cty_cd"         , SearchApprovalDetailVO.getAgmtCtyCd());
			velParam.put("agmt_seq"            , SearchApprovalDetailVO.getAgmtSeq());
			velParam.put("new_van_tp_cd"       , SearchApprovalDetailVO.getNewVanTpCd());
			velParam.put("pkup_due_dt"         , pkup_due_dt);
			velParam.put("lstm_cd"             , arrLstmCd);
			velParam.put("lstm_cd_str"         , SearchApprovalDetailVO.getLstmCd());
			velParam.put("cntr_tpsz_cd"        , arrCntrTpszCd);
			velParam.put("cntr_tpsz_cd_str"    , SearchApprovalDetailVO.getCntrTpszCd());
			if(!"G.TTL".equals(SearchApprovalDetailVO.getDetailAuthNo())) {
				velParam.put("detail_auth_no"      , SearchApprovalDetailVO.getDetailAuthNo());
				velParam.put("detail_agmt_cty_cd"  , SearchApprovalDetailVO.getDetailAgmtCtyCd());
				velParam.put("detail_agmt_seq"     , SearchApprovalDetailVO.getDetailAgmtSeq());
			}
			velParam.put("detail_cntr_tpsz_cd" , SearchApprovalDetailVO.getDetailCntrTpszCd());
			velParam.put("detail_divsion"      , SearchApprovalDetailVO.getDetailDivsion());
			
			velParam.put("lstm_tp_cd"  	  , SearchApprovalDetailVO.getLstmTpCd());
			dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchPickupStatusDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchApprovalDetailVO.class);

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
	 *Onhire 될 장비의 Lift On Charge  내용을 조회하는 이벤트 처리<br>
	 *
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @return List<OnhireApprovalVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OnhireApprovalVO> searchOnhireApprovalLiftOnChargeData(OnhireApprovalVO onhireApprovalVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OnhireApprovalVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(onhireApprovalVO != null){
				List<String> arrAgmtSeq      = null;
				arrAgmtSeq = JSPUtil.convertStringToArrayList(JSPUtil.replace(onhireApprovalVO.getAgmtSeq(),",","|"));

				param.put("loc_cd"      , onhireApprovalVO.getLocCd());
				param.put("agmt_seq"    , arrAgmtSeq);

				velParam.put("loc_cd"   , onhireApprovalVO.getLocCd());
				velParam.put("agmt_seq" ,arrAgmtSeq);
			}

			dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchOnhireApprovalLiftOnChargeDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OnhireApprovalVO.class);

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
	 *Onhire 될 장비의 Lift On Charge  내용을 조회하는 이벤트 처리<br>
	 *
	 * @param  String cntrOnhAuthNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchOnhireApprovalNumberHistorySeqData(String cntrOnhAuthNo) throws DAOException {
		DBRowSet dbRowset = null;
		String onhAproSeq = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("cntr_onh_auth_no"      , cntrOnhAuthNo);
			dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOOnhireApprovalNumberHistorySeqRSQL(), param, param);
			if(dbRowset.next()) {
				onhAproSeq = dbRowset.getString("ONH_APRO_SEQ");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return onhAproSeq;
	}

	/**
	 * LSE_ONH_APRO_HIS를 생성한다.<br>
	 *
	 * @param  String cntrOnhAuthNo
	 * @param  String onhAproSeq
	 * @param  String usrId
	 * @throws DAOException
	 */
	public void addOnhireApprovalNumberHistoryData(String cntrOnhAuthNo, String onhAproSeq, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
		    param.put("cntr_onh_auth_no", cntrOnhAuthNo);
		    param.put("onh_apro_seq"    , onhAproSeq);
		    param.put("usr_id"          , usrId);

		    SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new OnhireApprovalDBDAOaddOnhireApprovalNumberHistoryCSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
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
	 * LSE_ONH_APRO_HIS를 생성한다.<br>
	 *
	 * @param  String cntrOnhAuthNo
	 * @param  String onhAproSeq
	 * @param  String usrId
	 * @throws DAOException
	 */
	public void addOnhireApprovalNumberQtyHistoryData(String cntrOnhAuthNo, String onhAproSeq, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
		    param.put("cntr_onh_auth_no", cntrOnhAuthNo);
		    param.put("onh_apro_seq"    , onhAproSeq);
		    param.put("usr_id"          , usrId);

		    SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new OnhireApprovalDBDAOaddOnhireApprovalNumberQtyHistoryCSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
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
	 * Checking AGMT TP/SZ<br>
	 * 
     * @param	OnhireApprovalVO onhireApprovalVO
     * @return	String 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchValidaionAgmtTpsz(OnhireApprovalVO onhireApprovalVO) throws DAOException 
	{
		DBRowSet dbRowset = null;
		String cntrTpszCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(onhireApprovalVO != null){
				Map<String, String> mapVO = onhireApprovalVO.getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireApprovalDBDAOValidationAgmtNoTpszRSQL(), param, velParam);
			if(dbRowset.next()){
				cntrTpszCd = dbRowset.getString("CNTR_TPSZ_CD");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cntrTpszCd;
	}

	/**
	 * 
	 * @param cntrOnhAuthNo
	 * @return
	 * @throws DAOException 
	 */
	 @SuppressWarnings("unchecked")
	public List<OnhireApprovalVO> searchApprovalQtyChkData(String strFullAgmtSeq) throws DAOException {
		 DBRowSet dbRowset = null;
		List<OnhireApprovalVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(strFullAgmtSeq != null){
				List<String> arrAgmtSeq      = null;
				arrAgmtSeq = JSPUtil.convertStringToArrayList(JSPUtil.replace(strFullAgmtSeq,",","|"));
				
				param.put("agmt_seq"    , arrAgmtSeq);
				velParam.put("agmt_seq" ,arrAgmtSeq);
			}

			dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchOnhireApprovalQtyChkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OnhireApprovalVO.class);
			
			
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