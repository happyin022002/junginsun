/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IOnOffHireAuditDBDAO.java
*@FileTitle : On off Hire Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.19 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.basic.OnOffHireAuditBCImpl;
import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditDetailVO;
import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditSearchVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * IOnOffHireAuditDBDAO <br>
 * ContainerCostAnalysis system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jin Jun Sung
 * @see OnOffHireAuditBCImpl 참조
 * @since J2EE 1.6
 */
public class OnOffHireAuditDBDAO extends DBDAOSupport {


		/**
		 * OnOffHireAuditDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
		 * 저장된 Audit Result 리스트를 조회
		 * @param  OnOffHireAuditSearchVO onOffHireAuditSearchVO
		 * @param  String strLseAudTpCd
		 * @return List<OnOffHireAuditSearchVO>
		 * @throws DAOException
		 */
		 
		public List<OnOffHireAuditSearchVO> searchAuditResultOnOffHirelistData(OnOffHireAuditSearchVO onOffHireAuditSearchVO , String strLseAudTpCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<OnOffHireAuditSearchVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(onOffHireAuditSearchVO != null){
					String srtSearchStdt    = onOffHireAuditSearchVO.getSearchStdt();
					String strSearchEnddt   = onOffHireAuditSearchVO.getSearchEnddt();
					String strVndrSeq       = onOffHireAuditSearchVO.getVndrSeq();
					String strAudVerSeq     = onOffHireAuditSearchVO.getAudVerSeq();
					String strFileAudVerSeq = onOffHireAuditSearchVO.getFileAudVerSeq();
					String strAgmtCtyCd     = onOffHireAuditSearchVO.getAgmtCtyCd();
					String strAgmtSeq       = onOffHireAuditSearchVO.getAgmtSeq();
					String strLstmCd        = onOffHireAuditSearchVO.getLstmCd();
									
					param.put("search_stdt"      , srtSearchStdt);
					param.put("search_enddt"     , strSearchEnddt);
					param.put("vndr_seq"         , strVndrSeq);
					param.put("aud_ver_seq"      , strAudVerSeq);
					param.put("file_aud_ver_seq" , strFileAudVerSeq);
					param.put("agmt_cty_cd"      , strAgmtCtyCd);
					param.put("agmt_seq"         , strAgmtSeq);
					param.put("audit_tp"         , strLseAudTpCd);
					param.put("lstm_cd"          , strLstmCd);
					param.put("lse_aud_tp_cd"    , strLseAudTpCd);
		
					velParam.put("search_stdt"      , srtSearchStdt);
					velParam.put("search_enddt"     , strSearchEnddt);
					velParam.put("vndr_seq"         , strVndrSeq);
					velParam.put("aud_ver_seq"      , strAudVerSeq);
					velParam.put("file_aud_ver_seq" , strFileAudVerSeq);
					velParam.put("agmt_cty_cd"      , strAgmtCtyCd);
					velParam.put("agmt_seq"         , strAgmtSeq);
					velParam.put("audit_tp"         , strLseAudTpCd);
					velParam.put("lstm_cd"          , strLstmCd);
					velParam.put("lse_aud_tp_cd"    , strLseAudTpCd);
				}
				dbRowset = new SQLExecuter("").executeQuery(new OnOffHireAuditDBDAOsearchAuditResultOnOffHirelistRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OnOffHireAuditSearchVO .class);
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
	 * OnOffHireAuditDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * verify LSE_CTRT_NO 정합성 체크를 위한 조회
	 * @param  OnOffHireAuditSearchVO onOffHireAuditSearchVO
	 * @return List<OnOffHireAuditSearchVO>
	 * @throws DAOException
	 */
	public List<OnOffHireAuditSearchVO> verifyImportOnOffHireListData(OnOffHireAuditSearchVO onOffHireAuditSearchVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OnOffHireAuditSearchVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			
			param.put("lse_ctrt_no", onOffHireAuditSearchVO.getContractNo());
			param.put("vndr_seq",    onOffHireAuditSearchVO.getVndrSeq());
			
			velParam.put("lse_ctrt_no", onOffHireAuditSearchVO.getContractNo());
			velParam.put("vndr_seq",    onOffHireAuditSearchVO.getVndrSeq());
			
			dbRowset = new SQLExecuter("").executeQuery(new OnOffHireAuditDBDAOverifyImportOnOffHireListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OnOffHireAuditSearchVO.class);
				
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
	 * OnhireApprovalDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * verify 리스트를 저장한다.
	 * @param  OnOffHireAuditSearchVO onOffHireAuditSearchVO
	 * @param  String audVerSeq
	 * @param  int audSeq
	 * @param  SignOnUserAccount account
	 * @return OnOffHireAuditSearchVO
	 * @throws DAOException
	 */
	public OnOffHireAuditSearchVO addImportOnOffHireListData(OnOffHireAuditSearchVO onOffHireAuditSearchVO , String audVerSeq , int audSeq , SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		OnOffHireAuditSearchVO rtnOnOffHireAuditSearchVO = new OnOffHireAuditSearchVO();
		try{
			param.put("vndr_seq"           , onOffHireAuditSearchVO.getVndrSeq());
			param.put("aud_ver_seq"        , audVerSeq );
			param.put("aud_seq"            , audSeq + "" );
			param.put("agmt_cty_cd"        , onOffHireAuditSearchVO.getAgmtCtyCd());
			param.put("agmt_seq"           , onOffHireAuditSearchVO.getAgmtSeq());
			param.put("lstm_cd"            , onOffHireAuditSearchVO.getLstmCd());
			param.put("cntr_no"            , onOffHireAuditSearchVO.getCntrNo());
			param.put("cntr_tpsz_cd"       , onOffHireAuditSearchVO.getCntrTpszCd());
			param.put("onh_dt"             , onOffHireAuditSearchVO.getOnhDt());
			param.put("onh_loc_cd"         , onOffHireAuditSearchVO.getOnhLocCd());
			param.put("offh_dt"            , onOffHireAuditSearchVO.getOffhDt());
			param.put("offh_loc_cd"        , onOffHireAuditSearchVO.getOffhLocCd());
			param.put("lr_onh_dt"          , onOffHireAuditSearchVO.getLrOnhDt());
			param.put("lr_onh_loc_cd"      , onOffHireAuditSearchVO.getLrOnhLocCd());
			param.put("lr_offh_dt"         , onOffHireAuditSearchVO.getLrOffhDt());
			param.put("lr_offh_loc_cd"     , onOffHireAuditSearchVO.getLrOffhLocCd());
			param.put("onf_hir_sts_cd"     , onOffHireAuditSearchVO.getOnfHirStsCd());
		    param.put("cre_usr_id"         , account.getUsr_id());
		    param.put("upd_usr_id"         , account.getUsr_id());
		    param.put("ref_no"             , onOffHireAuditSearchVO.getContractNo());
		    param.put("audit_remark"             , "");
					    
		    SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new OnOffHireAuditDBDAOaddImportOnOffHireListCSQL(), param, velParam);
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
		return rtnOnOffHireAuditSearchVO;
	}
	/**
	 * LSE_ONF_HIR_AUD.AUD_SEQ 생성<br>
	 * 
	 * @param  String vndr_seq
	 * @return String
	 * @throws DAOException
	 */
	public String addImportOnOffHireSequenceData(String vndr_seq) throws DAOException {
		DBRowSet dbRowset = null;
		String audVerSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("vndr_seq"  , vndr_seq );
			dbRowset = new SQLExecuter("").executeQuery(new OnOffHireAuditDBDAOaddImportOnOffHireSequenceRSQL(), param, velParam);
			if(dbRowset.next()){
				audVerSeq=	dbRowset.getString("aud_ver_seq");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return audVerSeq ;
	}
		
	/**
	 * OnOffHireAuditDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Audit 버전 리스트를 조회한다.
	 * @param  OnOffHireAuditSearchVO onOffHireAuditSearchVO
	 * @return List<OnOffHireAuditSearchVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OnOffHireAuditSearchVO> searchAuditResultOnOffHireVersionlistData(OnOffHireAuditSearchVO onOffHireAuditSearchVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OnOffHireAuditSearchVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(onOffHireAuditSearchVO != null){
				String srtSearchStdt  = onOffHireAuditSearchVO.getSearchStdt();
				String strSearchEnddt = onOffHireAuditSearchVO.getSearchEnddt();
				String strVndrSeq     = onOffHireAuditSearchVO.getVndrSeq();
								
				param.put("search_stdt"  , srtSearchStdt);
				param.put("search_enddt" , strSearchEnddt);
				param.put("vndr_seq"     , strVndrSeq);
	
			}
			dbRowset = new SQLExecuter("").executeQuery(new OnOffHireAuditDBDAOsearchAuditResultOnOffHireVersionlistRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OnOffHireAuditSearchVO .class);
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
	 * OnOffHireAuditDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Lessor & 자사를 비교하여 Audit Result 리스트를 조회한다.
	 * @param  OnOffHireAuditDetailVO onOffHireAuditDetailVO
	 * @return List<OnOffHireAuditDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OnOffHireAuditDetailVO> searchAuditResultOnOffHireData(OnOffHireAuditDetailVO onOffHireAuditDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OnOffHireAuditDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(onOffHireAuditDetailVO != null){
				
				String strVndrSeq     = onOffHireAuditDetailVO.getVndrSeq();
				String srtSearchStdt  = onOffHireAuditDetailVO.getSearchStdt();
				if(srtSearchStdt != null){
					srtSearchStdt = srtSearchStdt.replaceAll("-", "");
				}
				String strSearchEnddt = onOffHireAuditDetailVO.getSearchEnddt();
				if(strSearchEnddt != null){
					strSearchEnddt = strSearchEnddt.replaceAll("-", "");
				}
				String strAudVerSeq   = onOffHireAuditDetailVO.getAudVerSeq();
				String strRefNo       = onOffHireAuditDetailVO.getRefNo();
				
				String strAgmtCtyCd   = onOffHireAuditDetailVO.getAgmtCtyCd();
				String strAgmtSeq     = onOffHireAuditDetailVO.getAgmtSeq();
				if(strAgmtSeq == null){
					strAgmtSeq = "";
				}
				String strAuditTp     = onOffHireAuditDetailVO.getAuditType();
				
				param.put("vndr_seq"        , strVndrSeq);
				param.put("aud_ver_seq"     , strAudVerSeq);
				if(srtSearchStdt != null){
					param.put("search_stdt"     , srtSearchStdt);
				}
				if(strSearchEnddt != null){
					param.put("search_enddt"    , strSearchEnddt);
				}
				param.put("ref_no"          , strRefNo);
				param.put("agmt_cty_cd"     , strAgmtCtyCd);
				param.put("agmt_seq"        , strAgmtSeq);
				param.put("audit_tp"        , strAuditTp);

				velParam.put("vndr_seq"        , strVndrSeq);
				velParam.put("aud_ver_seq"     , strAudVerSeq);
				if(srtSearchStdt != null){
					velParam.put("search_stdt"     , srtSearchStdt);
				}
				if(strSearchEnddt != null){
					velParam.put("search_enddt"    , strSearchEnddt);
				}
				velParam.put("ref_no"          , strRefNo);
				velParam.put("agmt_cty_cd"     , strAgmtCtyCd);
				velParam.put("agmt_seq"        , strAgmtSeq);
				velParam.put("audit_tp"        , strAuditTp);
			}
			dbRowset = new SQLExecuter("").executeQuery(new OnOffHireAuditDBDAOsearchAuditResultOnOffHireRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OnOffHireAuditDetailVO .class);
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
	* OnOffHireAuditDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	* Lessor & 자사를 비교하여 Audit Result 한 결과 저장시 삭제후 저장시 삭제
	* @param  String strVndrSeq
	* @param  String strAudVerSeq
	* @throws DAOException
	*/
	 public void removeOnOffHireListData( String strVndrSeq , String strAudVerSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
		    param.put("vndr_seq"    , strVndrSeq);
		    param.put("aud_ver_seq" , strAudVerSeq);
		    
		    SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new OnOffHireAuditDBDAOremoveOnOffHireListDSQL(), param, velParam);
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
	 * OnhireApprovalDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Lessor & 자사를 비교하여 Audit Result 한 결과 저장
	 * 
	 * @param  OnOffHireAuditDetailVO onOffHireAuditDetailVO
	 * @param  String audVerSeq
	 * @param  int audSeq
	 * @param  SignOnUserAccount account
	 * @return OnOffHireAuditSearchVO
	 * @throws DAOException
	 */
	public OnOffHireAuditSearchVO addOnOffHireListData(OnOffHireAuditDetailVO onOffHireAuditDetailVO , String audVerSeq , int audSeq , SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		OnOffHireAuditSearchVO rtnOnOffHireAuditSearchVO = new OnOffHireAuditSearchVO();
		try{
			param.put("vndr_seq"           , onOffHireAuditDetailVO.getVndrSeq());
			param.put("aud_ver_seq"        , audVerSeq );
			param.put("aud_seq"            , audSeq + "" );
			param.put("agmt_cty_cd"        , onOffHireAuditDetailVO.getAgmtCtyCd());
			param.put("agmt_seq"           , onOffHireAuditDetailVO.getAgmtSeq());
			param.put("lstm_cd"            , onOffHireAuditDetailVO.getLstmCd());
			param.put("ref_no"             , onOffHireAuditDetailVO.getRefNo());
			param.put("cntr_no"            , onOffHireAuditDetailVO.getCntrNo());
			param.put("cntr_tpsz_cd"       , onOffHireAuditDetailVO.getCntrTpszCd());
			param.put("onh_dt"             , onOffHireAuditDetailVO.getOnhDt() );
			param.put("onh_loc_cd"         , onOffHireAuditDetailVO.getOnhLocCd());
			param.put("offh_dt"            , onOffHireAuditDetailVO.getOffhDt());
			param.put("offh_loc_cd"        , onOffHireAuditDetailVO.getOffhLocCd());
			param.put("lr_onh_dt"          , onOffHireAuditDetailVO.getLrOnhDt());
			param.put("lr_onh_loc_cd"      , onOffHireAuditDetailVO.getLrOnhLocCd());
			param.put("lr_offh_dt"         , onOffHireAuditDetailVO.getLrOffhDt());
			param.put("lr_offh_loc_cd"     , onOffHireAuditDetailVO.getLrOffhLocCd());
			param.put("lse_aud_tp_cd"      , onOffHireAuditDetailVO.getLseAudTpCd());
			param.put("onf_hir_sts_cd"     , onOffHireAuditDetailVO.getAuditType());
			param.put("cre_usr_id"         , account.getUsr_id());
		    param.put("upd_usr_id"         , account.getUsr_id());
		    param.put("bil_fm_dt"          , onOffHireAuditDetailVO.getBilFmDt());
		    param.put("bil_to_dt"          , onOffHireAuditDetailVO.getBilToDt());
		    param.put("audit_remark"       , onOffHireAuditDetailVO.getAuditRemark());
					    
		    SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new OnOffHireAuditDBDAOaddImportOnOffHireListCSQL(), param, velParam);
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
		return rtnOnOffHireAuditSearchVO;
	}
}