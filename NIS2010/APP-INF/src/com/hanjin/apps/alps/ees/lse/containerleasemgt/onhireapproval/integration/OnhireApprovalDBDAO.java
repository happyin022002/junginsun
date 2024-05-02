/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireApprovalDBDAO.java
*@FileTitle : On Hire Approval inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.04 진준성
* 1.0 Creation
* =======================================================
* 2010.10.05 남궁진호 [CHM-201006272-01] Session User Id 변경, CreUsrId -> UsrId
* 					modifyOnhireApprovalNumberData
* 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
* 2013.08.13 채창호 [CHM-201325598]Split 02-EQR T/F 관련 LEGACY 연계 방안 및 일정
* 2013.11.04 채창호[CHM-201327356]EQR RE-OPEN과 관련하여 ALPS LEASE ON-HIRE APPROVAL CREATION/UPDATE/INQUIRY 화면 INTERFACE 요청
* 2013.12.24 채창호 [CHM-201328112] ALPS Lease-On hire Approval Creation-Update-Inquiry화면에 column 추가 요청
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration.AgreementRegistrationDBDAOAgreementRateDolDocRSQL;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.basic.OnhireApprovalBCImpl;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalOwnListVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchRequestListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.LseOnhAproVO;


/**
 * NIS2010 OnhireApprovalDBDAO <br>
 * - NIS2010-ContainerLeaseMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
		List<OnhireApprovalVO> list = new ArrayList<OnhireApprovalVO>();
		OnhireApprovalVO rsVo = new OnhireApprovalVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(onhireApprovalVO != null){

				List<String> arrTysz   = null;
                arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(onhireApprovalVO.getTysz(),",","|"));

                param.put("cntr_onh_auth_no"     , onhireApprovalVO.getCntrOnhAuthNo());
                param.put("tysz"                 , arrTysz);

                velParam.put("cntr_onh_auth_no"  , onhireApprovalVO.getCntrOnhAuthNo());
                velParam.put("tysz"              , arrTysz);
			}

			dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchOnhireApprovalNumberRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OnhireApprovalVO .class);
			if(onhireApprovalVO != null && onhireApprovalVO.getTysz() != null){
			 rsVo.setTysz(onhireApprovalVO.getTysz());
			}
			rsVo.setDbRowset(dbRowset);
			
			list.add(rsVo);

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
		 * @return List<LseOnhAproVO>
		 * @throws DAOException
		 */
	@SuppressWarnings("unchecked")
	public List<LseOnhAproVO> searchOnhireApprovalNumberBrieflyData(String pOnhLocCd , String pLstmCd , String periodStdt , String periodEddt ) throws DAOException {
		DBRowSet dbRowset = null;
		List<LseOnhAproVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			periodStdt = periodStdt.replaceAll("-", "");
			periodEddt = periodEddt.replaceAll("-", "");

			param.put("loc_cd"      , pOnhLocCd);
			param.put("ls_tm_cd"    , pLstmCd);
			param.put("period_stdt" , periodStdt);
			param.put("period_eddt" , periodEddt);

			velParam.put("period_stdt" , periodStdt);
			velParam.put("period_eddt" , periodEddt);

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
	 * @return String
	 * @throws DAOException
	 */
	public String addOnhireApprovalAuthNoData(String cntOnhAuthNo , String onhLocCd , String lstmCd) throws DAOException {
		DBRowSet dbRowset = null;
		String authNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
            param.put("cntr_onh_auth_no"  , cntOnhAuthNo);
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
	 * @param  String pkupDueDt
	 * @param  String mftYr
	 * @param  String freeDys
	 * @param  String pkupChgAmt
	 * @param  String pkupChgCrAmt
	 * @param  String minOnhDys
	 * @param  String aproRmk
	 * @param  String creUsrId
	 * @param  String reqno
	 * @param  String onhOrdYr
	 * @throws DAOException
	 */
	public void addOnhireApprovalNumberData(String cntrOnhAuthNo ,String agmtCtyCd ,String agmtSeq ,String lstmCd ,String onhLocCd ,String pkupDueDt ,String mftYr ,String freeDys ,String pkupChgAmt ,String pkupChgCrAmt ,String minOnhDys ,String aproRmk ,String creUsrId ,String reqno ,String onhOrdYr, String locCod, String eccCd) throws DAOException {
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
			param.put("pkup_due_dt"       , pkupDueDt);
			param.put("mft_yr"            , mftYr);
			param.put("free_dys"          , freeDys);
			param.put("pkup_chg_amt"      , pkupChgAmt);
			param.put("pkup_chg_cr_amt"   , pkupChgCrAmt);
			param.put("min_onh_dys"       , minOnhDys);
			param.put("apro_rmk"          , aproRmk);
			param.put("cre_usr_id"        , creUsrId);
			param.put("upd_usr_id"        , creUsrId);
			param.put("reqno"             , reqno);
			param.put("onh_ord_yr"        , onhOrdYr);
			param.put("loc_cod"           , locCod);
			param.put("ecc_cd"            , eccCd);
			

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
	public void addOnhireApprovalNumberQtyData(String cntrOnhAuthNo  , String agmtCtyCd , String agmtSeq , String cntrTpszCd , String newVanTpCd , String pkupChgQty , String onhQty , String lftChgAmt ,String creusrId, String locCod, String eccCd) throws DAOException {
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
			param.put("loc_cod"          , locCod);
			param.put("ecc_cd"           , eccCd);

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
	 * @param  String reqNo
	 * @param  String totalqty
	 * @return List<OnhireApprovalVO>
	 * @throws DAOException
	 */

	@SuppressWarnings("unchecked")
	public List<OnhireApprovalVO> searchOnhireApprovalNumber2Data(String authNo , String tysz ,String reqNo , String totalqty ) throws DAOException {
		DBRowSet dbRowset = null;
		List<OnhireApprovalVO> list = new ArrayList<OnhireApprovalVO>();
		OnhireApprovalVO rsVo = new OnhireApprovalVO();
		
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
			
			rsVo.setTysz(tysz);
			rsVo.setReqNo(reqNo);
			rsVo.setTotalList(totalqty);
			rsVo.setDbRowset(dbRowset);
			list.add(rsVo);

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
	 * @return SearchApprovalVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SearchApprovalVO searchPickupStatusSummaryData(SearchApprovalVO searchApprovalVO) throws DAOException {
		DBRowSet dbRowset = null;
		SearchApprovalVO rsVo = new SearchApprovalVO();

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
			param.put("ref_no"  		  , searchApprovalVO.getRefNo());
			param.put("vndr_abbr_nm"  	  , searchApprovalVO.getVndrAbbrNm());
			param.put("bal_tp"  	      , searchApprovalVO.getBalTp());
			param.put("ctrt_no"  	      , searchApprovalVO.getCtrtNo());
			param.put("tysz"              , arrTysz);

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
			velParam.put("ref_no"  		    , searchApprovalVO.getRefNo());
			velParam.put("vndr_abbr_nm"  	, searchApprovalVO.getVndrAbbrNm());
			velParam.put("bal_tp"  	        , searchApprovalVO.getBalTp());
			velParam.put("ctrt_no"  	    , searchApprovalVO.getCtrtNo());
			velParam.put("tysz"             , arrTysz);

			dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchPickupStatusSummaryRSQL(), param, velParam);
			rsVo.setTysz(searchApprovalVO.getTysz());
			rsVo.setDbRowset(dbRowset);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
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
			param.put("detail_auth_no"      , SearchApprovalDetailVO.getDetailAuthNo());
			param.put("detail_agmt_cty_cd"  , SearchApprovalDetailVO.getDetailAgmtCtyCd());
			param.put("detail_agmt_seq"     , SearchApprovalDetailVO.getDetailAgmtSeq());
			param.put("detail_cntr_tpsz_cd" , SearchApprovalDetailVO.getDetailCntrTpszCd());
			param.put("detail_divsion"      , SearchApprovalDetailVO.getDetailDivsion());

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
			velParam.put("detail_auth_no"      , SearchApprovalDetailVO.getDetailAuthNo());
			velParam.put("detail_agmt_cty_cd"  , SearchApprovalDetailVO.getDetailAgmtCtyCd());
			velParam.put("detail_agmt_seq"     , SearchApprovalDetailVO.getDetailAgmtSeq());
			velParam.put("detail_cntr_tpsz_cd" , SearchApprovalDetailVO.getDetailCntrTpszCd());
			velParam.put("detail_divsion"      , SearchApprovalDetailVO.getDetailDivsion());

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
	 * EQR Req List Title을 생성하기 위한 값을 조회한다..<br>
	 * @return String
	 * @throws DAOException
	 */
	public String searchReqListTietleCode() throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
		DBRowSet dbRowset = null;
		String titleStr = "";
		StringBuffer inStr    = new StringBuffer();
		int j			= 0;
    	try {
    		dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchReqListTietleCodeRSQL(), param, velParam);
			while (dbRowset.next()){
				inStr.append(((j == 0) ? "" : "|") + dbRowset.getString ("CNTR_TPSZ_CD").replaceAll("&","&amp;").trim());
				j++;
			}
			titleStr = inStr.toString();
    	} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return titleStr;
	}
	
	 /**
     * SEQR Req List을 조회합니다.<br>
	 *
	 * @param  SearchRequestListVO searchRequestListVO
	 * @return List<SearchRequestListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
    public List<SearchRequestListVO> searchEqrReqListDetailData(SearchRequestListVO searchRequestListVO) throws DAOException {

	    DBRowSet dbRowset = null;
	    List<SearchRequestListVO> list = null;
	    //query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try{
	    	if(searchRequestListVO != null){
		        Map<String, String> mapVO = searchRequestListVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);

		        List<String> arrCntrTpszCd = null;

		        if ( !JSPUtil.getNull(searchRequestListVO.getTitlelist()).equals("") ) {
		        	arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchRequestListVO.getTitlelist(),",","|"));
		        	param.put("cntr_tpsz_cd", arrCntrTpszCd);
		        	velParam.put("cntr_tpsz_cd", arrCntrTpszCd);
		        }
	    	}

	    	dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOseachEqrReqListRSQL(), param, velParam);
	    	list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRequestListVO.class);
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
     * EQR Req List을 저장시 validation 조회합니다.<br>
	 *
	 * @param  String reqno
	 * @param  String tpszCd
	 * @return String
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
    public String  searchEqrReqListValidation(String reqno ,String tpszCd) throws DAOException {

	    DBRowSet dbRowset = null;
	    String  list = "";
	    //query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try{
	           List<String> arrCntrTpszCd = null;

		        if ( !JSPUtil.getNull(tpszCd).equals("") ) {
		        	arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(tpszCd,",","|"));
		        	param.put("cntr_tpsz_cd", arrCntrTpszCd);
		        	velParam.put("cntr_tpsz_cd", arrCntrTpszCd);
		        	
		        }
		        param.put("reqno", reqno);
	        	velParam.put("reqno", reqno);

	    	dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchEqrReqListValidationDataRSQL(), param, velParam);
	    	if (dbRowset.next()){
	    		list = dbRowset.getString("REUSTT_FLG");
	    	}
	    	//list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRequestListVO.class);
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
     * Auth No로 해당 reqno와 tpsz별 total을 조회합니다.<br>
	 *
	 * @param  String authNo
	 * @param  String tysz
	 * @return String[]
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
    public String[] searchEqrReqListReqNoData(String authNo , String tysz) throws DAOException {

	    DBRowSet dbRowset = null;
	    String[] result = new String[2];
	    //query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try{
	        List<String> arrCntrTpszCd = null;
	        if ( !JSPUtil.getNull(tysz).equals("") ) {
		        	arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(tysz,",","|"));
		        	param.put("cntr_tpsz_cd", arrCntrTpszCd);
		        	velParam.put("cntr_tpsz_cd", arrCntrTpszCd);
		        }
	                param.put("authNo", authNo);
        	        velParam.put("authNo", authNo);
	    	dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchEqrReqListReqNoDataRSQL(), param, velParam);
	    	if (dbRowset.next()){
	    		result[0] = dbRowset.getString("REQNO");  // auth no 가져오기
	    		result[1] = dbRowset.getString("TOTALLIST"); // totalList 가져오기 (D2:100,D5:100)
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
     * Agmt Seq로 해당 DOL List를 조회합니다.<br>
	 *
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @return List<OnhireApprovalVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
    public List<OnhireApprovalVO> searchDolListData(OnhireApprovalVO onhireApprovalVO) throws DAOException {

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

	    	}

	    	dbRowset = new SQLExecuter("").executeQuery(new AgreementRegistrationDBDAOAgreementRateDolDocRSQL(), param, velParam);
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
     * Loc CD로 해당 ECC List를 조회합니다.<br>
	 *
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @return List<OnhireApprovalVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
    public List<OnhireApprovalVO> searchEccListData(OnhireApprovalVO onhireApprovalVO) throws DAOException {

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

	    	}

	    	dbRowset = new SQLExecuter("").executeQuery(new OnhireApprovalDBDAOsearchEccListDataRSQL(), param, velParam);
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
