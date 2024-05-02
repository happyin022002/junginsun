/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAO.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015-07-08
*@LastModifier : 심성윤
*@LastVersion : 1.0
* 2015-07-08 심성윤
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.authorization.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.hanjin.bizcommon.authorization.vo.AuthEmlSndVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationAproVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationProgramInfoVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationRouteVO;
import com.hanjin.bizcommon.authorization.vo.ComAuthAproRqstVO;
import com.hanjin.bizcommon.authorization.vo.SearchAuthAproVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;



/**
 * BIZCOMMON에 대한 DB 처리를 담당<br>
 * BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 심성윤
 * @see AuthorizationBCImpl 참조
 * @since J2EE 1.4
 */
public class AuthorizationDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	
	/**
	 * Authorization Approval Seq 채번 <br>
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchAuthAproSeq() throws DAOException {		
		DBRowSet dbRowset = null;
		String sRtn = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOSearchAuthAproSeqRSQL(), param, null);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("AUTH_APRO_RQST_NO");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return sRtn;
	}
	
	
	/**
	 * Authorization Apro Rqst 항목 생성 <br>
	 * 
	 * @param ComAuthAproRqstVO authRqstVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createAuthorizationAproRqst(ComAuthAproRqstVO authRqstVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(authRqstVO != null){
				Map<String, String> mapVO = authRqstVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new AuthorizationDBDAOcreateAuthorizationAproRqstCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to createAuthorizationAproRqst SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Authorization Approval Route의 Detail 정보 생성.<br>
	 * 
	 * @param List<AuthorizationRouteVO> authorizationRouteVOs
	 * @throws DAOException
	 */
	public void addAuthAproRouteDetail(List<AuthorizationRouteVO> authorizationRouteVOs)throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(authorizationRouteVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AuthorizationDBDAOcreateRouteDetailCSQL(), authorizationRouteVOs, null);
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
	 * Authorization 설정 정보 조회
	 * 
	 * @param AuthorizationProgramInfoVO authorizationProgramInfoVO
	 * @return List<AuthorizationProgramInfoVO>
	 * @throws DAOException
	 */
	public List<AuthorizationProgramInfoVO> searchAuthPgmInfo(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AuthorizationProgramInfoVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	if(authorizationProgramInfoVO != null){
				Map<String, String> mapVO = authorizationProgramInfoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOsearchAuthPgmInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AuthorizationProgramInfoVO.class); 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
	}
	
	
	/**
	 * Authorization 전체 설정 정보 조회
	 * 
	 * @param AuthorizationProgramInfoVO authorizationProgramInfoVO
	 * @return List<AuthorizationProgramInfoVO>
	 * @throws DAOException
	 */
	public List<AuthorizationProgramInfoVO> searchAllAuthPgmInfo(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AuthorizationProgramInfoVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	if(authorizationProgramInfoVO != null){
				Map<String, String> mapVO = authorizationProgramInfoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOsearchAllAuthPgmInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AuthorizationProgramInfoVO.class); 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
	}
	
	
	
	/**
	 * Authorization Approval Default Line 조회
	 * 
	 * @param SearchAuthAproVO searchAuthAproVO
	 * @return List<SearchAuthAproVO>
	 * @throws DAOException
	 */
	public List<SearchAuthAproVO> searchAuthAproDflt(SearchAuthAproVO searchAuthAproVO)throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAuthAproVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	if(searchAuthAproVO != null){
				Map<String, String> mapVO = searchAuthAproVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOsearchAuthAproDfltRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAuthAproVO.class); 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
	}
	
	/**
	 * Transaction 완료 확인 여부 Update
	 * 
	 * @param String authAproRqstNo
	 * @throws DAOException
	 */
	public void updateAuthAproCfm(String authAproRqstNo)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			param.put("auth_apro_rqst_no", JSPUtil.getNull(authAproRqstNo));
			
			sqlExe.executeUpdate((ISQLTemplate)new AuthorizationDBDAOupdateAuthAproCfmUSQL(), param, velParam); 
				
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 결재 정보 cancel처리 (TRS 요청)
	 * 
	 * @param String authAproRqstNo
	 * @throws DAOException
	 */	
	public void cancelAuthApro(String authAproRqstNo)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			param.put("auth_apro_rqst_no", JSPUtil.getNull(authAproRqstNo));
			sqlExe.executeUpdate((ISQLTemplate)new AuthorizationDBDAOcancelAuthAproUSQL(), param, velParam); 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * COM_APR_0T1
	 * Self 결재자 인지 Check 하는 로직<br>
	 * 
	 * @param  AuthorizationRouteVO authorizationRouteVO
	 * @param  SignOnUserAccount account
	 * @return String
	 * @throws DAOException
	 */
	public String searchAuthSelfApprovalCheck(AuthorizationRouteVO authorizationRouteVO, 
			SignOnUserAccount account) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			String subject = null;
			if(authorizationRouteVO != null) {
								
				param.put("auth_apro_usr_id", JSPUtil.getNull(authorizationRouteVO.getAuthAproUsrId()));
				param.put("usr_id", account.getUsr_id());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOsearchAuthSelfApprovalRSQL(), param, param); 
			if (dbRowset.next()) {
               	subject = dbRowset.getString(1);            	 
			}					
			return subject; 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Excel Download 승인 대상 화면인지 확인
	 * COM_APR_0T1 
	 * @param SearchAuthAproVO searchAuthAproVO
	 * @return String
	 * @throws EventException
	 */
	public String searchAuthChkXlsBtnPrmt(SearchAuthAproVO searchAuthAproVO) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			String subject = null;
			if(searchAuthAproVO != null) {
								
				param.put("sub_sys_cd_auth", JSPUtil.getNull(searchAuthAproVO.getSubSysCdAuth()));
				param.put("auth_apro_tp_cd", JSPUtil.getNull(searchAuthAproVO.getAuthAproTpCd()));
				param.put("pgm_no", JSPUtil.getNull(searchAuthAproVO.getPgmNo()));
				param.put("usr_id", JSPUtil.getNull(searchAuthAproVO.getUsrId()));
				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOsearchAuthChkXlsBtnPrmtRSQL(), param, param); 
			if (dbRowset.next()) {
               	subject = dbRowset.getString(1)+"|"+dbRowset.getString(2)+"|"+dbRowset.getString(3)+"|"+dbRowset.getString(4)+"|"+dbRowset.getString(5);             	 
			}					
			return subject; 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * 결재자 E-mail 유/무 확인
	 * COM_APR_0T1 
	 * @param String authAproRqstNo
	 * @return String
	 * @throws EventException
	 */
	public String searchNoEmlAddr(String authAproRqstNo) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			String subject = null;
			if(authAproRqstNo != null) {
								
				param.put("auth_apro_rqst_no", JSPUtil.getNull(authAproRqstNo));
				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOsearchNoEmlAddrRSQL(), param, param); 
			if (dbRowset.next()) {
               	subject = dbRowset.getString(1);             	 
			}					
			return subject; 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * 결재자 E-mail 유/무 확인 RMK Update
	 * COM_APR_0T1 
	 * @param String authAproRqstNo
	 * @param String noEmlApro
	 * @throws EventException
	 */
	public void updateNoEmlAddrRmk(String authAproRqstNo, String noEmlApro) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			param.put("auth_apro_rqst_no", JSPUtil.getNull(authAproRqstNo));
			param.put("no_eml_apro", JSPUtil.getNull(noEmlApro));
			
			sqlExe.executeUpdate((ISQLTemplate)new AuthorizationDBDAOupdateNoEmlAddrRmkUSQL(), param, velParam); 
				
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * Excel Download 승인 대상 화면인지 확인
	 * COM_ENS_0U1
	 * @param String authAproRqstNo
	 * @return String
	 * @throws EventException
	 */
	public String checkXlsApproval(String authAproRqstNo) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			String sRtn = null;
			if(authAproRqstNo != null) {
								
				param.put("auth_apro_rqst_no", JSPUtil.getNull(authAproRqstNo));
				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOcheckXlsApprovalRSQL(), param, param); 
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("XLS_DOWN_CHK");
			}					
			return sRtn; 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Excel - 첫번째 결재자 E-mail 정보 조회
	 * COM_APR_0T1 
	 * @param String authAproRqstNo
	 * @return String
	 * @throws EventException
	 */
	public String searchAuthEmlRcvInit(String authAproRqstNo) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			String subject = null;
			if(authAproRqstNo != null) {
								
				param.put("auth_apro_rqst_no", JSPUtil.getNull(authAproRqstNo));
				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOsearchAuthEmlRcvInitRSQL(), param, param); 
			if (dbRowset.next()) {
               	subject = dbRowset.getString(1)+" - "+dbRowset.getString(2);            	 
			}					
			return subject; 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * E-mail 발송 / 결재 정보 조회
	 * COM_APR_0T1 
	 * @param String authAproRqstNo
	 * @return String
	 * @throws EventException
	 */
	public String searchAuthSndEmlPgm(String authAproRqstNo) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			String subject = null;
			if(authAproRqstNo != null) {
								
				param.put("auth_apro_rqst_no", JSPUtil.getNull(authAproRqstNo));
				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOsearchAuthSndEmlPgmRSQL(), param, param); 
			if (dbRowset.next()) {
               	subject = dbRowset.getString(1)+" - "+dbRowset.getString(2)+" - "+dbRowset.getString(3)+" - "+dbRowset.getString(4)+" - "+dbRowset.getString(5)+" - "+dbRowset.getString(6);            	 
			}					
			return subject; 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * E-mail 발송 / 결재자 목록 및 Approve/Reject 결과
	 * COM_APR_0T1 
	 * @param String authAproRqstNo
	 * @return String
	 * @throws EventException
	 */
	public List<AuthEmlSndVO> searchAuthSndEmlAproDtl(String authAproRqstNo) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			List<AuthEmlSndVO> list = null;
			
		try {	
			if(authAproRqstNo != null) {
				
				param.put("auth_apro_rqst_no", JSPUtil.getNull(authAproRqstNo));
				
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOsearchAuthSndEmlAproDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AuthEmlSndVO.class); 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
		return list;
	}
	
	/**
	 * Excel - E-mail Seq 추출
	 * COM_APR_0T1 
	 * @return String
	 * @throws EventException
	 */
	public String searchAuthEmlSndSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String authEmlSndNoSeq = "";

		try{			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOsearchAuthEmlSndSeqRSQL(), null, null);
			if(dbRowset.next()) {
				authEmlSndNoSeq = dbRowset.getString("AUTH_EML_SND_NO");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return authEmlSndNoSeq;
	}
	
	/**
	 * COM_APR_0T1
	 * COM_AUTH_EML_SND 생성
	 * @param AuthEmlSndVO emlSndVO
	 * @throws DAOException
	 */
	public void createAuthEmlSnd(AuthEmlSndVO emlSndVO) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			if(emlSndVO != null){
				Map<String, String> mapVO = emlSndVO.getColumnValues();
				param.putAll(mapVO);	
			}
				sqlExe.executeUpdate((ISQLTemplate)new AuthorizationDBDAOcreateAuthEmlSndCSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * COM_APR_0T1
	 * COM_AUTH_EML_SND 발송 Update
	 * @param AuthEmlSndVO emlSndVO
	 * @throws DAOException
	 */
	public void updateAuthEmlSndAft(AuthEmlSndVO emlSndVO)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			param.put("eml_snd_no", JSPUtil.getNull(emlSndVO.getEmlSndNo()));
			param.put("auth_eml_snd_no", JSPUtil.getNull(emlSndVO.getAuthEmlSndNo()));
			
			sqlExe.executeUpdate((ISQLTemplate)new AuthorizationDBDAOupdateAuthEmlSndAftUSQL(), param, velParam); 
				
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * COM_APR_0T1
	 * COM_AUTH_EML_SND 발송 Update
	 * @param String authEmlSndNoSeq
	 * @throws DAOException
	 */
	public void updateAuthEmlSndFail(String authEmlSndNoSeq)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			param.put("auth_eml_snd_no", JSPUtil.getNull(authEmlSndNoSeq));
			
			sqlExe.executeUpdate((ISQLTemplate)new AuthorizationDBDAOupdateAuthEmlSndFailUSQL(), param, velParam); 
				
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Excel Download Request 사유 조회
	 * COM_APR_0T1 
	 * @param String authAproRqstNo
	 * @return String
	 * @throws EventException
	 */
	public String searchAuthRqstRsn(String authAproRqstNo) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			String reason = null;
			if(authAproRqstNo != null) {
								
				param.put("auth_apro_rqst_no", JSPUtil.getNull(authAproRqstNo));
				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOsearchAuthRqstRsnRSQL(), param, param); 
			if (dbRowset.next()) {
               	reason = dbRowset.getString(1);            	 
			}					
			return reason; 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * COM_APR_0S2 모듈 콤보 데이터 조회
	 * @return
	 * @throws DAOException
	 */
	public String[] getComboDataSubSysCdAuth() throws DAOException {
		
		//log.debug("\n\n================= marineterminalinvoicemanageDBDAO  getVrfyTmls  ================\n");
		String[] comboStringArray = new String[2];
		List<AuthorizationProgramInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer subSysCdAuth = new StringBuffer(512);
		StringBuffer subSysCd = new StringBuffer(512);
		
		try {
			DBRowSet moduleRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOsearchSubSysCdAuthRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(moduleRowSet, AuthorizationProgramInfoVO.class);
			
			subSysCdAuth.append(list.get(0).getSubSysCdAuth());
			subSysCd.append(list.get(0).getSubSysCd());
			
			for(int i = 1; i < list.size(); i++){
				subSysCdAuth.append("|"+list.get(i).getSubSysCdAuth());
				subSysCd.append("|"+list.get(i).getSubSysCd());
			}
			comboStringArray[0] = subSysCdAuth.toString();
			comboStringArray[1] = subSysCd.toString();
			log.error("\n---------------->"+comboStringArray[0]);
			log.error("\n---------------->"+comboStringArray[1]);
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return comboStringArray;
	}

	/**
	 * COM_APR_0S2 Program Name 조회
	 * @return
	 * @throws DAOException
	 */
	public String getPgmNm(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String pgmNM = "";
		try {
			if(authorizationProgramInfoVO != null) {
				Map<String, String> mapVO = authorizationProgramInfoVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOsearchPgmNmRSQL(), param, param);
			while (dbRowset.next()) {
				pgmNM = dbRowset.getString("PGM_NM");
			}
			
		} catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return pgmNM;
	}
	
	/**
	 * COM_APR_0S2 Program Name 조회
	 * 
	 * @param AuthorizationProgramInfoVO authorizationProgramInfoVO
	 * @return AuthorizationProgramInfoVO
	 * @throws DAOException
	 */
	public AuthorizationProgramInfoVO searchPgmDetail(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		List<AuthorizationProgramInfoVO> list = null;
		AuthorizationProgramInfoVO vo = new AuthorizationProgramInfoVO();
		try {
			if(authorizationProgramInfoVO != null) {
				Map<String, String> mapVO = authorizationProgramInfoVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOsearchAuthPgmDetailRSQL(), param, null);
			list =(List)RowSetUtil.rowSetToVOs(dbRowset, AuthorizationProgramInfoVO.class); 
			vo = list.get(0);
		} catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vo;
	}
	
	/**
	 * COM_APR_0S2
	 * Add/Update Auth Program 
	 * @param authorizationProgramInfoVO
	 * @throws DAOException
	 */
	public void addAuthPgm(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			if(authorizationProgramInfoVO != null){
				Map<String, String> mapVO = authorizationProgramInfoVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			
				sqlExe.executeUpdate((ISQLTemplate)new AuthorizationDBDAOcreateAuthPgmCSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * COM_APR_0S2
	 * Add/Update Autn Pgm Button
	 * @param authorizationProgramInfoVO
	 * @throws DAOException
	 */
	public void addAuthPgmBtn(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			if(authorizationProgramInfoVO != null){
				Map<String, String> mapVO = authorizationProgramInfoVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
				sqlExe.executeUpdate((ISQLTemplate)new AuthorizationDBDAOcreateAuthPgmBtnCSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * COM_APR_0S2
	 * Add/Update Auth Pgm Field
	 * @param authorizationProgramInfoVO
	 * @throws DAOException
	 */
	public void addAuthPgmFld(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			if(authorizationProgramInfoVO != null){
				Map<String, String> mapVO = authorizationProgramInfoVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
				sqlExe.executeUpdate((ISQLTemplate)new AuthorizationDBDAOcreateAuthPgmFldCSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * COM_ENS_0U1
	 * 동시결재 방지 로직
	 * @param authorizationAproVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkAuthDuplApro(AuthorizationAproVO authorizationAproVO) throws DAOException {	
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String duplChk = "";
		try {
			if(authorizationAproVO != null) {
				Map<String, String> mapVO = authorizationAproVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AuthorizationDBDAOcheckAuthDuplAproRSQL(), param, param);
			while (dbRowset.next()) {
				duplChk = dbRowset.getString("CHK_VAL");
			}
			
			log.error("\n>>>>>>>>>>>> duplChk : "+ JSPUtil.getNull(duplChk) + "<<<<<<<<<<<<<<<");
			
		} catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return duplChk;
	}	
	
}