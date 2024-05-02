/*========================================================= 
*Copyright(c) 2006 CyberLogitec
*@FileName : ApprovalDBDAO.java
*@FileTitle : VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2008-08-29
*@LastModifier : Jeong-Hoon Kim
*@LastVersion : 1.1
* 2006-10-31 Hyung Choon_Roh
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2013.09.05 조인영 [CHM-201326202] ETS연동에 따른 TRS CSR삭제로직 추가 요청
* 2014.11.19 김영신 [CHM-201432872] 10만불 이상 G/W연동 관련 로직 추가
* 2014.12.18 김영신 [CHM-201433354] I/F ERROR 경우 결재권자 우회 로직 추가
* 2015.04.14 심성윤 [CHM-201534125] 결재라인 체크 로직 추가
* 2015.07.20 심성윤 [CHM-201536387] [Develop]ALPS Auth 사후 결재 기능 탭 로직 추가(0U1,0U2,0V1) 
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.bizcommon.approval.basic.ApprovalBCImpl;
import com.hanjin.bizcommon.approval.vo.ApPayInvVO;
import com.hanjin.bizcommon.approval.vo.ApprovalCsrVO;
import com.hanjin.bizcommon.approval.vo.ApprovalDeptVO;
import com.hanjin.bizcommon.approval.vo.ApprovalInqueryCondtionVO;
import com.hanjin.bizcommon.approval.vo.ApprovalInqueryVO;
import com.hanjin.bizcommon.approval.vo.ApprovalRouteVO;
import com.hanjin.bizcommon.approval.vo.ApprovalStaffVO;
import com.hanjin.bizcommon.approval.vo.ApprovalStepVO;
import com.hanjin.bizcommon.approval.vo.SearchApprovalVO;
import com.hanjin.bizcommon.approval.vo.UnApprovalCsrVO;
import com.hanjin.bizcommon.authorization.vo.AuthAproStaffVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationAproVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationInquiryVO;
import com.hanjin.bizcommon.authorization.vo.SearchAuthAproVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.IfCsrListInputVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
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
import com.hanjin.syscommon.common.table.ComAproCsrDtlVO;
import com.hanjin.syscommon.common.table.ComAproRqstHdrVO;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;


/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hyung Choon_Roh
 * @see ApprovalBCImpl 참조
 * @since J2EE 1.4
 */
public class ApprovalDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

 	/**
 	 * 현재 LOGIN USER가 현재 결재권자 여부 확인<br>
 	 * 
 	 * @param csrNo
 	 * @param loginUsrId
 	 * @return String
 	 * @throws DAOException
 	 */
    public String checkCurrentApprovalUserYN(String csrNo, String loginUsrId) throws DAOException {        
        DBRowSet dbRowset = null;
        
        try{
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();     
            
        	// 조회조건
        	// velocity parameter 설정 
            //velParam.putAll(param);
        	param.put("csr_no", csrNo);
        	param.put("login_usr_id", loginUsrId);            
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOCheckCurrentApprovalUserYNRSQL(), param, velParam);
            
            if (dbRowset.next()) {            	
            	String agmtCfmCd = dbRowset.getString(1);            	 
            	return agmtCfmCd;
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }       
    }
    
	/**
	 * Staff의 목록을 조회합니다.<br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
	 * @return List<ApprovalStaffVO>
	 * @throws DAOException
	 */
	public List<ApprovalStaffVO> searchStaffList(ApprovalStaffVO approvalStaffVO) throws DAOException {		
		DBRowSet dbRowset = null;
		List<ApprovalStaffVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(approvalStaffVO != null) {
				Map<String, String> mapVO = approvalStaffVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOApprovalStaffVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApprovalStaffVO.class);
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
	 * Organization의 목록을 조회합니다.<br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
	 * @return List<SearchDeptListVO>
	 * @throws DAOException
	 */
	public List<ApprovalDeptVO> searchDeptList(ApprovalStaffVO approvalStaffVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApprovalDeptVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	if(approvalStaffVO != null){
				Map<String, String> mapVO = approvalStaffVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOApprovalDeptVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApprovalDeptVO.class);        	
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return list;
	}
	
	/**
	 * Route의 Sequence를 조회합니다.<br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
	 * @return String
	 * @Exception DAOException
	 */
	public String searchApprovalRouteSeq(ApprovalStaffVO approvalStaffVO) throws DAOException {		
		DBRowSet dbRowset = null;
		String sRtn = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			if(approvalStaffVO != null) {
				Map<String, String> mapVO = approvalStaffVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOApprovalRouteSeqRSQL(), param, null);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("APRO_ROUT_SEQ");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return sRtn;
	}
	
	/**
	 * Auth Route의 Sequence를 조회합니다.<br>
	 * 
	 * @param AuthAproStaffVO authAproStaffVO
	 * @return String
	 * @Exception DAOException
	 */
	public String searchAuthApprovalRouteSeq(AuthAproStaffVO authAproStaffVO) throws DAOException {		
		DBRowSet dbRowset = null;
		String sRtn = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			if(authAproStaffVO != null) {
				Map<String, String> mapVO = authAproStaffVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOAuthorizationApprovalRouteSeqRSQL(), param, param);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("AUTH_APRO_ROUT_SEQ");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return sRtn;
	}
	
	/**
	 * Route의 Sequence를 생성합니다.<br>
	 * 
	 * @return String
	 * @Exception DAOException
	 */
	public String createApprovalRouteSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String sRtn = "";
		
		try {			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOApprovalRouteSeqCSQL(), null, null);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("newseq");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return sRtn;
	}
	
	/**
	 * Route의 목록을 조회합니다.<br>
	 * 
	 * @param ApprovalRouteVO aprovalRouteVO
	 * @return List<ApprovalRouteVO>
	 * @throws DAOException
	 */
	public List<ApprovalRouteVO> searchApprovalRouteList(ApprovalRouteVO aprovalRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApprovalRouteVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	if(aprovalRouteVO != null){
				Map<String, String> mapVO = aprovalRouteVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOApprovalRouteVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApprovalRouteVO.class);        	
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return list;
	}
	
	/**
	 * Authorization Approval Route의 Sequence를 생성합니다.<br>
	 * 
	 * @return String
	 * @Exception DAOException
	 */
	public String createAuthApprovalRouteSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String sRtn = "";
		
		try {			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOAuthApprovalRouteSeqCSQL(), null, null);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("newseq");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return sRtn;
	}
	
	/**
	 * Route의 목록을 조회합니다.<br>
	 * 
	 * @param ApprovalRouteVO aprovalRouteVO
	 * @return List<ApprovalRouteVO>
	 * @throws DAOException
	 */
	public List<ApprovalRouteVO> searchApprovalRouteUtilList(ApprovalRouteVO aprovalRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApprovalRouteVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	if(aprovalRouteVO != null){
				Map<String, String> mapVO = aprovalRouteVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOApprovalRouteUtil02RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApprovalRouteVO.class);        	
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return list;
	}
	
	/**
	 * Approval Route 의 정보를 수정합니다. <br>
	 * 
	 * @param ApprovalRouteVO aprovalRouteVO
	 * @throws DAOException
	 */
	public void modifyApprovalRoute(ApprovalRouteVO aprovalRouteVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(aprovalRouteVO != null){
				Map<String, String> mapVO = aprovalRouteVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOsaveApprovalRouteUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyApprovalRoute SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Approval Route 의 정보를 삭제합니다. <br>
	 * 
	 * @param ApprovalRouteVO aprovalRouteVO
	 * @throws DAOException
	 */
	public void removeApprovalRoute(ApprovalRouteVO aprovalRouteVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(aprovalRouteVO != null){
				Map<String, String> mapVO = aprovalRouteVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOdetailDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to removeApprovalRoute SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Approval Route 의 정보를 생성합니다. <br>
	 * 
	 * @param String aproRoutSeq
	 * @param ApprovalStaffVO approvalStaffVO
	 * @throws DAOException
	 */
	public void addApprovalRoute(String aproRoutSeq, ApprovalStaffVO approvalStaffVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(approvalStaffVO != null){
				Map<String, String> mapVO = approvalStaffVO.getColumnValues();
				mapVO.put("apro_rout_seq", aproRoutSeq);
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOsaveApprovalRouteCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to addApprovalRoute SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Approval Route 의 Detail 정보를 생성합니다. <br>
	 * 
	 * @param List<ApprovalRouteVO> approvalRouteVOs
	 * @throws DAOException
	 */
	public void addApprovalRouteDetail(List<ApprovalRouteVO> approvalRouteVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(approvalRouteVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ApprovalDBDAOdetailCSQL(), approvalRouteVOs, null);
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
	 * Authorization Approval Route 의 정보를 수정합니다. <br>
	 * 
	 * @param SearchAuthAproVO searchAuthAproVO
	 * @throws DAOException
	 */
	public void modifyAuthApprovalRoute(SearchAuthAproVO searchAuthAproVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(searchAuthAproVO != null){
				Map<String, String> mapVO = searchAuthAproVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOsaveAuthApprovalRouteUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyAuthApprovalRoute SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Authorization Approval Route 의 정보를 삭제합니다. <br>
	 * 
	 * @param SearchAuthAproVO searchAuthAproVO
	 * @throws DAOException
	 */
	public void removeAuthApprovalRoute(SearchAuthAproVO searchAuthAproVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(searchAuthAproVO != null){
				Map<String, String> mapVO = searchAuthAproVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOdeleteAuthAproUsrDtlDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to removeAuthApprovalRoute SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Authorization Approval Route 의 정보를 생성합니다. <br>
	 * 
	 * @param String authAproRoutSeq
	 * @param AuthAproStaffVO authAproStaffVO
	 * @throws DAOException
	 */
	public void addAuthApprovalRoute(String authAproRoutSeq, AuthAproStaffVO authAproStaffVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(authAproStaffVO != null){
				Map<String, String> mapVO = authAproStaffVO.getColumnValues();
				mapVO.put("auth_apro_rout_seq", authAproRoutSeq);
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOsaveAuthApprovalRouteCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to addApprovalRoute SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Authorization Approval Route 의 Detail 정보를 생성합니다. <br>
	 * 
	 * @param List<SearchAuthAproVO> searchAuthAproVOs
	 * @throws DAOException
	 */
	public void addAuthApprovalRouteDetail(List<SearchAuthAproVO> searchAuthAproVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(searchAuthAproVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ApprovalDBDAOAuthAproUsrDtlCSQL(), searchAuthAproVOs, null);
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
	 * Approval Request Number를 조회합니다. <br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @return String
	 * @Exception DAOException
	 */
	public String searchAproRqstNo(ApprovalCsrVO approvalCsrVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sRtn = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		if(approvalCsrVO != null){
			Map<String, String> mapVO = approvalCsrVO.getColumnValues();
			param.putAll(mapVO);	
		}
		
		try {			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOApprovalReqNoRSQL(), param, null);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("APRO_RQST_NO");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return sRtn;
	}
	
	/**
	 * COM_APRO_RQST_HDR 결제정보를 수정한다.<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @Exception DAOException
	 */ 
	public void modifyApprovalReqHdr(ApprovalCsrVO approvalCsrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOApprovalReqHdrUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyApprovalReqHdr SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
	
	/**
	 * Approval Route 정보를 삭제한다.<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @Exception DAOException
	 */
	public void removeApprovalReqRoute(ApprovalCsrVO approvalCsrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOApprovalReqRouteDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to removeApprovalReqRoute SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Approval Route 정보를 생성합니다. <br>
	 * 
	 * @param List<ComAproRqstRoutVO> comAproRqstRoutVOs
	 * @throws DAOException
	 */
	public void addApprovalReqRoute(List<ComAproRqstRoutVO> comAproRqstRoutVOs) throws DAOException {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			DBRowSet dbRowset = null;
//			int insCnt[] = null;
//			int chkCnt =0;
		
			String apro_rout_flg = "Y";
			
			if(comAproRqstRoutVOs.size() > 0){
				for(int k =0 ; k<comAproRqstRoutVOs.size();k++){
					param.put("apro_rqst_no", 		comAproRqstRoutVOs.get(k).getAproRqstNo());
					param.put("apro_rqst_seq", 		comAproRqstRoutVOs.get(k).getAproRqstSeq());
					param.put("apro_usr_nm",		comAproRqstRoutVOs.get(k).getAproUsrNm());
					param.put("apro_usr_id",		comAproRqstRoutVOs.get(k).getAproUsrId());
					param.put("apro_ofc_nm",		comAproRqstRoutVOs.get(k).getAproOfcNm());
					param.put("apro_usr_jb_tit_nm",	comAproRqstRoutVOs.get(k).getAproUsrJbTitNm());
					param.put("cre_usr_id",			comAproRqstRoutVOs.get(k).getCreUsrId());
					param.put("upd_usr_id",			comAproRqstRoutVOs.get(k).getUpdUsrId());
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchApprovedReqRouteRSQL(), param, param); 
					
					while(dbRowset.next()){
						apro_rout_flg = dbRowset.getString("APRO_ROUT_FLG");
						if(apro_rout_flg.equals("Y")){
							sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOApprovalReqRouteCSQL(), param, param);
						}
					}
				}
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
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
	 * 결재라인 체크 로직<br>
	 * CHM-201534125 심성윤(2015.04.14)<br>
	 * Approval Route 체크 <br> 
	 * 
	 * @param  ApprovalCsrVO approvalCsrVO
	 * @param  List<ComAproRqstRoutVO> comAproRqstRoutVOs	 
	 * @return String
	 * @throws DAOException
	 */
	public String checkApprovalReqRoute(ApprovalCsrVO approvalCsrVO, List<ComAproRqstRoutVO> comAproRqstRoutVOs) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			String subject = null;
			if(approvalCsrVO != null) {
				List<String> aproUsrId = new ArrayList();
				
				for(int i=0;comAproRqstRoutVOs!=null && i<comAproRqstRoutVOs.size();i++){   
					aproUsrId.add(comAproRqstRoutVOs.get(i).getAproUsrId());   
				}
				
				param.put("sub_sys_cd", JSPUtil.getNull(approvalCsrVO.getSubSysCd()));
				param.put("ofc_cd", JSPUtil.getNull(approvalCsrVO.getOfcCd()));
				param.put("aproUsrId", aproUsrId);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOApprovalReqCheckRSQL(), param, param); 
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
	 * AP_INV_HDR 결제정보를 수정한다.<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @Exception DAOException
	 */ 
	public void modifyApInvHdr(ApprovalCsrVO approvalCsrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOApInvHdrUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyApInvHdr SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
	
	/**
	 * Approval 목록을 조회합니다. <br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
	 * @return List<SearchApprovalVO>
	 * @throws DAOException
	 */
	public List<SearchApprovalVO> searchApprovalByCsrNo(ApprovalStaffVO approvalStaffVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchApprovalVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	if(approvalStaffVO != null){
				Map<String, String> mapVO = approvalStaffVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchApprovalByCsrNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchApprovalVO.class);        	
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return list;
	}
	
	/**
	 * 부서모듈 사용자별 기본결재라인(COM_APRO_ROUT_DFLT_DTL) 목록을 조회합니다. <br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
	 * @return List<SearchApprovalVO>
	 * @throws DAOException
	 */
	public List<SearchApprovalVO> searchApprovalByAproRouteSeq(ApprovalStaffVO approvalStaffVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchApprovalVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	if(approvalStaffVO != null){
				Map<String, String> mapVO = approvalStaffVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchApprovalByAproRoutSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchApprovalVO.class);        	
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return list;
	}
	
	/**
	 * 부서모듈 사용자별 기본 Auth 결재라인(COM_AUTH_APRO_DFLT_ROUT_USR) 목록을 조회합니다. <br>
	 * 
	 * @param AuthAproStaffVO authAproStaffVO
	 * @return List<AuthAproStaffVO>
	 * @throws DAOException
	 */
	public List<AuthAproStaffVO> searchAuthApprovalByAuthAproRouteSeq(AuthAproStaffVO authAproStaffVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AuthAproStaffVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	if(authAproStaffVO != null){
				Map<String, String> mapVO = authAproStaffVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchAuthApprovalByAuthAproRoutSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAuthAproVO.class);        	
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return list;
	}
	
	
	/**
	 * Csr의 목록을 조회합니다.<br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
	 * @return List<ApprovalCsrVO>
	 * @Exception DAOException
	 */
	public List<ApprovalCsrVO> searchApprovalCsrList(ApprovalStaffVO approvalStaffVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApprovalCsrVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	if(approvalStaffVO != null){
				Map<String, String> mapVO = approvalStaffVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOApprovalCsrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApprovalCsrVO.class);        	
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return list;
	}
	
	
	/**
	 * Authorization Approval의 목록을 조회합니다.<br>
	 * 
	 * @param AuthorizationAproVO authorizationAproVO
	 * @param SignOnUserAccount account
	 * @return List<AuthorizationAproVO>
	 * @Exception DAOException
	 */
	public List<AuthorizationAproVO> searchAuthApprovalList(AuthorizationAproVO authorizationAproVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<AuthorizationAproVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	if(authorizationAproVO != null){
				Map<String, String> mapVO = authorizationAproVO.getColumnValues();
				param.putAll(mapVO);
				param.put("login_usr_id", account.getUsr_id());
				velParam.putAll(mapVO);
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchAuthApprovalListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AuthorizationAproVO.class);        	
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return list;
	}
	
	
	/**
	 *  OFC_CD로 OFC_TP_CD를 조회한다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @Exception DAOException
	 */
	public String searchOfcTpCd(String ofcCd) throws DAOException {		
		DBRowSet dbRowset = null;
		String sRtn = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("ofc_cd", ofcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchOfcTpCdRSQL(), param, null);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("OFC_TP_CD");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return sRtn;
	}
	
	/**
	 *  RHQ OFC_CD를 조회한다.<br>
	 * 
	 * @return String
	 * @Exception DAOException
	 */
	public String searchRhqOfcCdList() throws DAOException {		
		DBRowSet dbRowset = null;
		String sRtn = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer sbRtn = new StringBuffer();
		try {
//			param.put("ofc_cd", ofcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchRhqOfcCdListRSQL(), param, null);
			while (dbRowset.next()) {
//				sRtn = sRtn + dbRowset.getString("RHQ_OFC_CD") + "|";
				sbRtn.append(dbRowset.getString("RHQ_OFC_CD"));
				sbRtn.append("|");
			}
			sRtn = sbRtn.toString();
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return sRtn;
	}
	
	/**
	 *  OFC_CD로 OFFICE COMBO CODE LIST를 조회한다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @Exception DAOException
	 */
	public String searchOfcCdList(String ofcCd) throws DAOException {		
		DBRowSet dbRowset = null;
		String sRtn = "";
		StringBuffer sbRtn = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("ofc_cd", ofcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchOfcCdListRSQL(), param, null);
			while (dbRowset.next()) {
//				sRtn = sRtn + dbRowset.getString("OFC_CD") + "|";
				sbRtn.append(dbRowset.getString("OFC_CD"));
				sbRtn.append("|");
			}
			sRtn = sbRtn.toString();
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return sRtn;
	}
	
	/**
	 *  Approval Inquery 화면에서 RHQ콤보 변경시 OFFICE COMBO CODE LIST조회.<br>
	 * 
	 * @param String rhqOfcCd
	 * @return String
	 * @Exception DAOException
	 */
	public String searchOfcCdListByRhq(String rhqOfcCd) throws DAOException {		
		DBRowSet dbRowset = null;
		String sRtn = "";
		StringBuffer sbRtn = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("rhq_ofc_cd", rhqOfcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchOfcCdListByRhqRSQL(), param, velParam);
			while (dbRowset.next()) {
//				sRtn = sRtn + dbRowset.getString("OFC_CD") + "|";
				sbRtn.append(dbRowset.getString("OFC_CD"));
				sbRtn.append("|");
			}
			sRtn = sbRtn.toString();
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return sRtn;
	}
	
	/**
	 *  Approval Inquery 화면에서 모듈 LIST조회.<br>
	 * 
	 * @param AuthorizationInquiryVO authorizationInquiryVO
	 * @return List<AuthorizationInquiryVO>
	 * @Exception DAOException
	 */
	public List<AuthorizationInquiryVO> searchAuthSubSysCdList(AuthorizationInquiryVO authorizationInquiryVO) throws DAOException {		
		DBRowSet dbRowset = null;
		List<AuthorizationInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("auth_apro_tp_cd", authorizationInquiryVO.getAuthAproTpCd());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchAuthSubSysCdListRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AuthorizationInquiryVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
	}
	
	/**
	 *  Approval Inquery 화면에서 모듈콤보 변경시 프로그램 LIST조회.<br>
	 * 
	 * @param AuthorizationInquiryVO authorizationInquiryVO
	 * @return List<AuthorizationInquiryVO>
	 * @Exception DAOException
	 */
	public List<AuthorizationInquiryVO> searchAuthPgmNmList(AuthorizationInquiryVO authorizationInquiryVO) throws DAOException {		
		DBRowSet dbRowset = null;
		List<AuthorizationInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(authorizationInquiryVO != null){
				Map<String, String> mapVO = authorizationInquiryVO.getColumnValues();
				param.put("sub_sys_cd", authorizationInquiryVO.getSubSysCdAuth());
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchAuthPgmNmListRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AuthorizationInquiryVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
	}
	
	
	/**
	 *  Authorization Approval 조회.<br>
	 * 
	 * @param AuthorizationInquiryVO authorizationInquiryVO
	 * @return List<AuthorizationInquiryVO>
	 * @Exception DAOException
	 */
	public List<AuthorizationInquiryVO> searchAuthAproInquiry(AuthorizationInquiryVO authorizationInquiryVO) throws DAOException {		
		DBRowSet dbRowset = null;
		List<AuthorizationInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(authorizationInquiryVO != null){
				Map<String, String> mapVO = authorizationInquiryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchAuthAproInquiryRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AuthorizationInquiryVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
	}
	
	/**
	 * Approval Inquery Csr의 목록을 조회합니다.<br>
	 * 
	 * @param ApprovalInqueryCondtionVO approvalInqueryCondtionVO
	 * @return List<ApprovalInqueryVO>
	 * @Exception DAOException
	 */
	public List<ApprovalInqueryVO> searchApprovalInqueryCsrList(ApprovalInqueryCondtionVO approvalInqueryCondtionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApprovalInqueryVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	if(approvalInqueryCondtionVO != null){
				Map<String, String> mapVO = approvalInqueryCondtionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOApprovalInqueryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApprovalInqueryVO.class);        	
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return list;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * 현 결재자 정보를 조회한다. <br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @return ComAproRqstRoutVO
	 * @Exception DAOException
	 */
	public ComAproRqstRoutVO searchApprovalCurCsrRoute(ApprovalCsrVO approvalCsrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComAproRqstRoutVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOApprovalCurCsrRouteRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComAproRqstRoutVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list.size()==0?new ComAproRqstRoutVO():list.get(0);
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 기결재 완료 여부 파악 - 중복 결재 피하기 위함<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @return boolean
	 * @Exception DAOException
	 */
	public boolean chkUrgPayFlgAproRout(ApprovalCsrVO approvalCsrVO) throws DAOException {
		DBRowSet dbRowset = null;
		String retval = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOChkUrgPayFlgAproRoutRSQL(), param, null);
			if (dbRowset.next()) {
				retval = dbRowset.getString("RETVAL");
			}
			log.error("\n\n @@@@@@@ ApprovalDBDAO.chkUrgPayFlgAproRout() - retval : " + JSPUtil.getNull(retval) + " @@@@@@@@@\n\n");
			if (retval!=null && retval.trim().equals("Y")){
				return true;
			} else {
				return false;
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 최종 결재 여부를 체크한다 - 최종 결재시에만 CSR AP전송  <br>
	 * @param ApprovalCsrVO approvalCsrVO
	 * @return boolean
	 * @Exception DAOException
	 */
	public boolean searchLastApprovalRoute(ApprovalCsrVO approvalCsrVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isReqNo = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchLastApprovalRouteRSQL(), param, null);
			if(dbRowset.next()) {
				if(dbRowset.getInt(1) > 0) isReqNo = true;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return isReqNo;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 기결재 완료 여부 파악 - 중복 결재 피하기 위함<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @return boolean
	 * @Exception DAOException
	 */
	public boolean searchApprovalCompletion(ApprovalCsrVO approvalCsrVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isCmlt = true;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchApprovalCompletionRSQL(), param, null);
			if(dbRowset.next()) {
				if("P".equals(dbRowset.getString("apsts_cd"))) isCmlt = false;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return isCmlt;
	}
	
	/**
	 * 결재상신 엔티티 라우트테이블의 해당 결재권자 결재상태를 완료처리한다<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @Exception DAOException
	 */ 
	public void modifyConfirmRqstRout(ApprovalCsrVO approvalCsrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			//APRO_RQST_SEQ의 조건이 있으면 결재자가 다수인경우 처리안됨
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOConfirmRqstRoutUSQL(), param, null);
			log.error("result="+result);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyConfirmRqstRout SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
	
	/**
	 * Approval Completion 정보를 조회합니다. <br>
	 *  
	 * @param ApprovalCsrVO approvalCsrVO
	 * @return boolean
	 * @Exception DAOException
	 */
	public boolean searchApprovalCompleteCount(ApprovalCsrVO approvalCsrVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isCt = true;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOApprovalCompleteCountRSQL(), param, null);
			if(dbRowset.next()) {
				if(dbRowset.getInt("CNT") > 0) isCt = false;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return isCt;
	}
	
	/**
	 * COM_APRO_RQST_HDR 승인정보를 완료로 수정한다.<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @Exception DAOException
	 */ 
	public void modifyConfirmRqstHdrC(ApprovalCsrVO approvalCsrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOConfirmRqstHdrCUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyConfirmRqstHdrC SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
	
	/**
	 * COM_APRO_RQST_HDR 승인정보를 진행으로 수정한다.<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @Exception DAOException
	 */ 
	public void modifyConfirmRqstHdrP(ApprovalCsrVO approvalCsrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOConfirmRqstHdrPUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyConfirmRqstHdrP SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
	
	/**
	 * AP_PAY_INV 승인정보를 수정한다.<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @Exception DAOException
	 */ 
	public void modifyConfirmApPayInv(ApprovalCsrVO approvalCsrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOConfirmApPayInvUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyConfirmApPayInv SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
	
	/**
	 * 결재상신 엔티티 라우트테이블(COM_APRO_RQST_ROUT)의 해당 결재권자 결재상태를 반려처리한다<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @Exception DAOException
	 */ 
	public void modifyRejectAproRqstRout(ApprovalCsrVO approvalCsrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAORejectAproRqstRoutUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyRejectAproRqstRout SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
	
	/**
	 * 헤더테이블(COM_APRO_RQST_HDR)의 결재상태를 반려처리한다<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @Exception DAOException
	 */ 
	public void modifyRejectAproRqstHdr(ApprovalCsrVO approvalCsrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAORejectAproRqstHdrUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyRejectAproRqstHdr SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
	
	/**
	 * 승인권자가 Reject 할 경우 CSR 중간테이블(AP_PAY_INV)의 INVOICE 진행상태를 반려로 업데이트한다<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @Exception DAOException
	 */ 
	public void modifyRejectApPayInv(ApprovalCsrVO approvalCsrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAORejectApPayInvUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyRejectApPayInv SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AP_PAY_INV의 목록을 조회합니다.<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @return List<ApPayInvVO>
	 * @Exception DAOException
	 */
	public List<ApPayInvVO> searchSO(ApprovalCsrVO approvalCsrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApPayInvVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
        try {
        	if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
				param.putAll(mapVO);
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOApPayInvVORSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApPayInvVO.class);        	
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return list;
	}
	
	/**
	 * CLZ_STS_CD, GL_DT, NEW_GL_DT 의 실시간 데이타를 구해온다 <br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @return ApPayInvVO
	 * @Exception DAOException
	 */
	public ApPayInvVO checkUpdateRevVVD(ApprovalCsrVO approvalCsrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApPayInvVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOCheckUpdateRevVVDRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApPayInvVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list.size()==0?new ApPayInvVO():list.get(0);
	}
	
	/**
	 * AP_INV_DTRB의 VVD 정보를 수정한다.<br>
	 * 
	 * @param String csrNo
	 * @param String newGlDt
	 * @Exception DAOException
	 */ 
	public void modifyUpdateRevVVDDtrb(String csrNo, String newGlDt) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(csrNo != null){
				Map<String, String> mapVO =  new HashMap<String, String>();
				 
				mapVO.put("csr_no"   , csrNo);
				mapVO.put("new_gl_dt", newGlDt);
				param.putAll(mapVO);
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOUpdateRevVVDDtrbUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyUpdateRevVVDDtrb SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AP_PAY_INV_DTL의 VVD 정보를 수정한다.<br>
	 * 
	 * @param String csrNo
	 * @param String newGlDt
	 * @Exception DAOException
	 */ 
	public void modifyUpdateRevVVDDtl(String csrNo, String newGlDt) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(csrNo != null){
				Map<String, String> mapVO =  new HashMap<String, String>();
				 
				mapVO.put("csr_no"   , csrNo);
				mapVO.put("new_gl_dt", newGlDt);
				param.putAll(mapVO);
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOUpdateRevVVDDtlUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyUpdateRevVVDDtl SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 최종 승인자 정보 및 GL_DT 정보를 CSR AP전송을 위한 테이블(AP_INV_HDR)로 업데이트한다 <br>
	 * 
	 * @param String titleName
	 * @param String csrNo
	 * @param String newGlDt
	 * @Exception DAOException
	 */ 
	public void modifyApprovalStep(String titleName, String csrNo, String newGlDt) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(csrNo != null){
				Map<String, String> mapVO =  new HashMap<String, String>();
				 
				mapVO.put("title_name", titleName);
				mapVO.put("csr_no"    , csrNo);
				mapVO.put("new_gl_dt" , newGlDt);
				param.putAll(mapVO);
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOApprovalStepUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyApprovalStep SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 최종 승인자 정보 및 GL_DT 정보를 CSR AP전송을 위한 테이블(AP_INV_HDR)로 업데이트한다 <br>
	 * 
	 * @param String csrNo
	 * @param String newGlDt
	 * @Exception DAOException
	 */ 
	public void modifyApprovalStep2(String csrNo, String newGlDt) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(csrNo != null){
				Map<String, String> mapVO =  new HashMap<String, String>();
				 
				mapVO.put("csr_no"    , csrNo);
				mapVO.put("new_gl_dt" , newGlDt);
				param.putAll(mapVO);
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOApprovalStep2USQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyApprovalStep2 SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CSR 상태를 정의하고있는 중간테이블(AP_PAY_INV) 의 상태를 P(A/P Interfaced) 로 업데이트 한다<br>
	 * 
	 * @param List<ApPayInvVO> apPayInvVOs
	 * @Exception DAOException
	 */
	public void modifyStsCdPayInv(List<ApPayInvVO> apPayInvVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(apPayInvVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ApprovalDBDAOApPayInvVOUSQL(), apPayInvVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
     * COM_CSR_0008 View Approval Step 버튼 -> COM_ENS_0W1 팝업 조회 이벤트 처리<br>
     * Approval Step 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @return List<ApprovalStepVO>
	 * @Exception DAOException
	 */
	public List<ApprovalStepVO> searchApprovalStepList(ApprovalCsrVO approvalCsrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApprovalStepVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
        try {
        	if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
				param.putAll(mapVO);
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOApprovalStepRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApprovalStepVO.class);        	
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return list;
	}
	
	/**
	 * AP_INV_HDR 의 최종 승인자 정보를 업데이트 합니다. <br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @Exception DAOException
	 */ 
	public void confirmApprovalRemark(ApprovalCsrVO approvalCsrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOConfirmApprovalRemarkUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to confirmApprovalRemark SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * New Approval Request Number를 생성한다. <br>
	 * 
	 * @return DBRowSet
	 * @Exception DAOException
	 */
	public String searchNewAproRqstNo() throws DAOException {
		DBRowSet dbRowset = null;
		String newAproNo = "";

		try{			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchNewAproRqstNoRSQL(), null, null);
			if(dbRowset.next()) {
				newAproNo = dbRowset.getString("APRO_RQST_NO");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return newAproNo;
	}
	
	/**
	 * 결재요청 헤더 정보를 생성합니다. <br>
	 * 
	 * @param ComAproRqstHdrVO comAproRqstHdrVO
	 * @Exception DAOException
	 */ 
	public void addApprovalHeader(ComAproRqstHdrVO comAproRqstHdrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(comAproRqstHdrVO != null){
				Map<String, String> mapVO = comAproRqstHdrVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOApprovalHeaderCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to addApprovalHeader SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 결재요청 결재권자 정보를 생성합니다. <br>
	 * 
	 * @param List<ComAproRqstRoutVO> comAproRqstRoutVOs
	 * @Exception DAOException
	 */ 
	public void addApprovalRoute(List<ComAproRqstRoutVO> comAproRqstRoutVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(comAproRqstRoutVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ApprovalDBDAOApprovalRouteCSQL(), comAproRqstRoutVOs, null);
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
	 * COM_APRO_CSR_DTL 정보를 생성합니다. <br>
	 * 
	 * @param ComAproCsrDtlVO comAproCsrDtlVO
	 * @Exception DAOException
	 */ 
	public void addApprovalCsr(ComAproCsrDtlVO comAproCsrDtlVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(comAproCsrDtlVO != null){
				Map<String, String> mapVO = comAproCsrDtlVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOApprovalCsrCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to addApprovalCsr SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * AP_INV_HDR 의 최종 승인자 정보를 업데이트 합니다. <br>
	 * 
	 * @param String csrNo
	 * @Exception DAOException
	 */ 
	public void cancelApproval(String csrNo) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(csrNo != null){
				Map<String, String> mapVO =  new HashMap<String, String>();
				 
				mapVO.put("csr_no"    , csrNo);
				param.putAll(mapVO);
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOCancelApprovalUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyApprovalStep SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
     * CSR 번호로 Approval Step조회한다. (JOO)
     * @param String csrNo
     * @return List<ApprovalRouteVO>
     * @throws DAOException
     */
	public List<ApprovalRouteVO> searchApprovalRouteListByCsrNo(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApprovalRouteVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
        try {
			Map<String, String> mapVO =  new HashMap<String, String>();
			 
			mapVO.put("csr_no"   , csrNo);
			param.putAll(mapVO);
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOApprovalRouteUtilRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApprovalRouteVO.class);        	
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return list;
	}
	
	/**
	 * MDM_ORGANIGATION에서 RHQ(AR_HD_QTR_OFC_CD)에 해당하는 Office code의 list를 구해온다.<br>
	 * 
	 * @author ds ham
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchARRHQOfficeList() throws DAOException {
		DBRowSet dbRowset = null;

		List list = new ArrayList();
		String arOfcCd = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ApprovalDBDAOSearchARRHQOfficeListRSQL(), param, velParam);

			while (dbRowset.next()) {
				arOfcCd = dbRowset.getString("ar_ofc_cd");

				list.add(arOfcCd);
			}
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
	 * Office code의 list를 구해온다.<br>
	 * 
	 * @author ds ham
	 * @param UnApprovalCsrVO unApprovalCsrVO
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchSelOfficeList(UnApprovalCsrVO unApprovalCsrVO) throws DAOException {
		DBRowSet dbRowset = null;

		List list = new ArrayList();
		
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_hd_qtr_ofc_cd", unApprovalCsrVO.getArHdQtrOfcCd());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ApprovalDBDAOSearchOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnApprovalCsrVO .class);
			
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
	 * ESD_SCE_0125 : 조회를 위한 토크나이져 스트링가져오기 
	 * @param ExceptionalRouteVO exceptionalRouteVO
	 * @return List<ExceptionalRouteVO>
	 * @throws DAOException
	 */
	private String setParams(StringBuffer sbuf, StringTokenizer token, int max) throws SQLException { 
	    for ( int i = 0; i < max; i++ )
	    { 
    	  if(i==0){
    		 sbuf.append ( "" ).append ( token.nextToken ( ) ).append ( "" );
    		 if(max > 1){
    			 sbuf.append("',");
    		 }
    	  }else{
		      if ( i != max - 1 ){
		    	 sbuf.append ( "'" ).append ( token.nextToken ( ) ).append ( "'," );
		      }else{
		         sbuf.append ( "'" ).append ( token.nextToken ( ) ).append ( "" );
		      }
    	  }
	    }
		return sbuf.toString();
	}
	
	/**
	 * CSR의 결재권자가 미승인된 내역을 조회한다.<br>
	 * 
	 * @param UnApprovalCsrVO unApprovalCsrVO
	 * @return List<UnApprovalCsrVO>
	 * @Exception DAOException
	 */
	public List<UnApprovalCsrVO> searchUnApprovalCsrList(UnApprovalCsrVO unApprovalCsrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnApprovalCsrVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	if(unApprovalCsrVO != null){
				Map<String, String> mapVO = unApprovalCsrVO.getColumnValues();
				
			    StringBuffer sbuf = new StringBuffer ( );
			    sbuf.setLength ( 0 ); 

			    StringTokenizer ofc_cd_token = new StringTokenizer ( (String)mapVO.get("ofc_cd"), "," );
			    
			    String ofcs = setParams(sbuf, ofc_cd_token, ofc_cd_token.countTokens ( ));
				
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
				List<String> ofcvec = new ArrayList();
				if(!ofcs.equals("") && !ofcs.equals("ALL")){
					ofcvec.add(ofcs);
					velParam.put("ofc_cd", 	ofcvec);
				}else{
					velParam.put("ofc_cd", 	"");
				}
				
				velParam.put("ar_hd_qtr_ofc_cd", mapVO.get("ar_hd_qtr_ofc_cd"));
				velParam.put("inv_eff_dt", mapVO.get("inv_eff_dt"));
				velParam.put("sub_sys_cd", mapVO.get("sub_sys_cd"));
				velParam.put("csr_no", mapVO.get("csr_no"));
			}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOUnApprovalCsrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnApprovalCsrVO.class);        	
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return list;
	}
	
	
	/**
	 *  OFC_CD로 RHQ_OFC_CD를 조회한다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @Exception DAOException
	 */
	public String searchRhqOfcCdByOfcCd(String ofcCd) throws DAOException {		
		DBRowSet dbRowset = null;
		String sRtn = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("ofc_cd", ofcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchRhqOfcCodeByOfcCodeRSQL(), param, null);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("RHQ_OFC_CD");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return sRtn;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * 결재시에 Invoice 존재 여부 체크  <br>
	 * @param ApprovalCsrVO approvalCsrVO
	 * @return boolean
	 * @Exception DAOException
	 */
	public boolean searchInvoice(ApprovalCsrVO approvalCsrVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isReqNo = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOsearchInvoiceRSQL(), param, null);
			if(dbRowset.next()) {
				if(dbRowset.getInt(1) > 0) isReqNo = true;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return isReqNo;
	}
	
	/**
	 * Approval Step 유효성 확인 (PDT 지시 사항)
	 * @param csr_no
	 * @param usr_id
	 * @return String
	 * @throws DAOException
	 */
	public String checkAproStepSts(String csr_no, String usr_id) throws DAOException {
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		String retval = null;
		
		try {
			param.put("csr_no", csr_no);
			param.put("usr_id", usr_id);
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOCheckAproStepStsRSQL(), param, velParam);
			if (dbRowSet.next()){
				retval = dbRowSet.getString("RETVAL");
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retval;
	}
	
	/**
	 * COM_APRO_RQST_ROUT 삭제 하기
	 * @param csr_no
	 * @throws DAOException
	 */
	public void deltComAproStepRout(String csr_no) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (csr_no != null){
				param.put("csr_no", csr_no);
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAODeltComAproStepRoutDSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to deltComAproStepRout SQL");
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
	 * COM_APRO_RQST_HDR 삭제 하기
	 * @param csr_no
	 * @throws DAOException
	 */
	public void deltComAproStepHdr(String csr_no) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (csr_no != null){
				param.put("csr_no", csr_no);
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAODeltComAproStepHdrDSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to deltComAproStepHdr SQL");
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
	 * COM_APRO_RQST_DTL 삭제 하기
	 * @param csr_no
	 * @throws DAOException
	 */
	public void deltComAproStepDtl(String csr_no) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (csr_no != null){
				param.put("csr_no", csr_no);
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAODeltComAproStepDtlDSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to deltComAproStepHdr SQL");
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
	 * 후결 처리시 현단계 이후의 모든 결재선 완료처리 
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @Exception DAOException
	 */ 
	public void modifyConfirmRqstRestOfRout(ApprovalCsrVO approvalCsrVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(approvalCsrVO != null){
				Map<String, String> mapVO = approvalCsrVO.getColumnValues();
				param.putAll(mapVO);	
			}
			
			//APRO_RQST_SEQ의 조건이 있으면 결재자가 다수인경우 처리안됨
			int result = sqlExe.executeUpdate((ISQLTemplate)new ApprovalDBDAOModifyConfirmRqstRestOfRoutUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modifyConfirmRqstRout SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
	
	/**
	 * Edit Approval Step시  결재자 중 승인된 결재자가 있는지 확인.
	 * 
	 * @param csr_no
	 * @param apro_rqst_seq
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckApprovedStep(String csr_no,String apro_rqst_seq) throws DAOException {
		String sRtn = "";
		
		try {
			DBRowSet dbRowset = null;

			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			param.put("csr_no", csr_no);
			param.put("apro_rqst_seq", apro_rqst_seq);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchCheckApprovedStepRSQL(), param, null);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("APRO_FLG");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtn;
	} 	
	
	/**
	 * Edit Approval Step시 Approval Request한 사용자를 기준으로 
	 * Validation 체크한다.
	 * @param csrNo String
	 * @return String
	 * @Exception DAOException
	 */ 
	public String searchAproRqstUsr(String csrNo) throws DAOException {
		String sRtn = "";
		
		try {
			DBRowSet dbRowset = null;

			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			param.put("csr_no", csrNo);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchApprovalReqUsrRSQL(), param, null);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("APRO_RQST_USR_ID");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtn;
	} 
	
	/**
	 * 입력된 결재라인이 모두 결재된 건인지 체크한다.
	 * Validation 체크한다.
	 * @param aproRqstNo String
	 * @return String
	 * @Exception DAOException
	 */ 
	public String searchCheckAproAll(String aproRqstNo) throws DAOException {
		String sRtn = "";
		
		try {
			DBRowSet dbRowset = null;

			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			param.put("apro_rqst_no", aproRqstNo);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchCheckAproAllRSQL(), param, param);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("APRO_ALL_FLG");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtn;
	} 
	
	/**
     * Add버튼 클릭시 CSR Approved된 건은 결재라인 추가 못하도록 한다.<br>
     * COM_ENS_0T1
	 *
	 * @param csr_no String
	 * @return String
	 * @throws EventException
	 */
	public String searchCheckApprovedCsr(String csr_no) throws DAOException {
		String sRtn = "";
		
		try {
			DBRowSet dbRowset = null;

			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			param.put("csr_no", csr_no);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchCheckApprovedCsrRSQL(), param, param);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("IF_FLG");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtn;
	}
	
	
	/**
     * Approval시 결재자가 Approval Step에 존재유무 체크.<br>
     * COM_ENS_0U1
	 *
	 * @param sLoginUsrId String
	 * @return String
	 * @throws DAOException
	 */
	public String searchAproUsrId(String sLoginUsrId) throws DAOException {
		String sRtn = "";
		
		try {
			DBRowSet dbRowset = null;

			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			param.put("usr_id", sLoginUsrId);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchAproUsrIdRSQL(), param, param);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("USR_ID");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtn;
	} 
	
	/**
     * 조회 이벤트 처리 <br>
	 * Authorization  Approve / Confirm 버튼 클릭시 최종결재완료 여부 확인<br>
	 *
	 * @param authorizationAproVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkAuthApproval(AuthorizationAproVO authorizationAproVO) throws DAOException {
		String sRtn = "";
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			DBRowSet dbRowset = null;
			if(authorizationAproVO != null){
				//Map<String, String> mapVO = authorizationAproVO.getColumnValues();
				//param.putAll(mapVO);	
				param.put("auth_apro_rqst_no", authorizationAproVO.getAuthAproRqstNo());	
			}	
			
			//query parameter
			

			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOCheckAuthApprovalRSQL(), param, param);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("CRNT_STS");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtn;
	} 
	
		
	/**
     * 조회 이벤트 처리 <br>
	 * Authorization Disapprove 버튼 클릭시 Rout Update<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws DAOException
	 */
	public void updateAuthDisaproRout(AuthorizationAproVO authorizationAproVO) throws DAOException {
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(authorizationAproVO != null){
//				Map<String, String> mapVO = authorizationAproVO.getColumnValues();
				param.put("auth_apro_rqst_no", authorizationAproVO.getAuthAproRqstNo());	
				param.put("usr_id", authorizationAproVO.getUsrId());
				param.put("auth_apro_rmk", authorizationAproVO.getAuthAproRmk());
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAOUpdateAuthDisaproRoutUSQL(), param, velParam);

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
     * 조회 이벤트 처리 <br>
	 * Authorization  Disapprove 버튼 클릭시 Disapprove 실시<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws DAOException
	 */
	public void disaproAuthApproval(AuthorizationAproVO authorizationAproVO) throws DAOException {
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(authorizationAproVO != null){
//				Map<String, String> mapVO = authorizationAproVO.getColumnValues();
				param.put("auth_apro_rqst_no", authorizationAproVO.getAuthAproRqstNo());	
				param.put("usr_id", authorizationAproVO.getUsrId());
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAODisaproAuthApprovalUSQL(), param, velParam);

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
     * 조회 이벤트 처리 <br>
	 * Authorization  RQST Rmk 저장 이벤트 처리<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws DAOException
	 */
	public void saveAuthRqstRmk(AuthorizationAproVO authorizationAproVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
				if(authorizationAproVO != null){
	//					Map<String, String> mapVO = authorizationAproVO.getColumnValues();
					param.put("auth_apro_rqst_no", authorizationAproVO.getAuthAproRqstNo());	
					param.put("auth_apro_rmk", authorizationAproVO.getAuthAproRmk());
					param.put("usr_id", authorizationAproVO.getUsrId());
				}
				
				new SQLExecuter("").executeUpdate((ISQLTemplate) new ApprovalDBDAOsaveAuthAproRmkUSQL(), param, velParam);

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
     * 조회 이벤트 처리 <br>
	 * Authorization  Approve / Confirm 버튼 클릭시 Rout Update<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws DAOException
	 */
	public void updateAuthAproRout(AuthorizationAproVO authorizationAproVO) throws DAOException {
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(authorizationAproVO != null){
//				Map<String, String> mapVO = authorizationAproVO.getColumnValues();
				param.put("auth_apro_rqst_no", authorizationAproVO.getAuthAproRqstNo());	
				param.put("usr_id", authorizationAproVO.getUsrId());	
				param.put("auth_apro_rmk", authorizationAproVO.getAuthAproRmk());
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAOUpdateAuthAproRoutUSQL(), param, velParam);

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
     * 조회 이벤트 처리 <br>
	 * Authorization  Approve / Confirm 버튼 클릭시 최종결재완료 여부 확인<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws DAOException
	 */
	public void confirmAuthAproFinal(AuthorizationAproVO authorizationAproVO) throws DAOException {
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(authorizationAproVO != null){
//				Map<String, String> mapVO = authorizationAproVO.getColumnValues();
				param.put("auth_apro_rqst_no", authorizationAproVO.getAuthAproRqstNo());	
				param.put("usr_id", authorizationAproVO.getUsrId());
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAOUpdateConfirmAuthAproFinalUSQL(), param, velParam);

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
     * 조회 이벤트 처리 <br>
	 * Authorization  Approve / Confirm 버튼 클릭시 최종결재완료 여부 확인<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws DAOException
	 */
	public void confirmAuthAproProgress(AuthorizationAproVO authorizationAproVO) throws DAOException {
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(authorizationAproVO != null){
//				Map<String, String> mapVO = authorizationAproVO.getColumnValues();
				param.put("auth_apro_rqst_no", authorizationAproVO.getAuthAproRqstNo());	
				param.put("usr_id", authorizationAproVO.getUsrId());
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAOUpdateConfirmAuthAproProgressUSQL(), param, velParam);

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
     * JOO,FMS관련 Validation 분기.<br>
     * COM_ENS_0T1
	 *
	 * @param csr_no String
	 * @return String
	 * @throws EventException
	 */
	public String searchCsrSubSystem(String csr_no) throws DAOException {
		String sRtn = "";
		
		try {
			DBRowSet dbRowset = null;

			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			param.put("csr_no", csr_no);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchCsrSubSystemRSQL(), param, param);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("SYS_CD");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtn;
	}
	
	
    /**
     * COM_ENS_0T1화면 Loading시 User ID OR EP ID를 조회
     * Del버튼 클릭시 자기 자신의 결재라인을 지우지 못하게 한다.<br>
     * COM_ENS_0T1
     * @param usrId String
     * @return String
     * @exception EventException
     * @author SHIN DONG IL
     * @date 2014.08.12
     */
	public String searchCheckApprovalUserId(String usrId) throws DAOException {
		String sRtn = "";
		
		try {
			DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			param.put("usr_id", usrId);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchCheckApprovalUserIdRSQL(), param, param);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("EP_ID");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtn;
	}
	
	/**
	 * COM_CSR_0002 : CSR Create 버튼 <br>
	 * AP_INV_HDR 의 RQST_APRO_STEP_FLG, 생성 날짜 업데이트
	 * 
	 * @param IfCsrListInputVO ifCsrListInputVO
	 * @exception DAOException
	 */
	public void updateAproGwFlg(IfCsrListInputVO ifCsrListInputVO) throws DAOException {
		log.debug("\n DAO.updateAproGwFlg --------------------------------------------------");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(ifCsrListInputVO != null){
				Map<String, String> mapVO = ifCsrListInputVO.getColumnValues();
				param.putAll(mapVO);	
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAOUpdateAproGwFlgUSQL(), param, velParam);

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
	 * GW에서 결과 값 전송 <br>
	 * AP_INV_HDR 의 GW Result 값에 따라 날짜 및 계약서 존재여부 업데이트
	 * 
	 * @param comCsrInfoVO
	 * @throws DAOException
	 */
	public void updateAproGwDt(ComCsrInfoVO comCsrInfoVO) throws DAOException {
		log.debug("\n DAO.updateAproGwDt --------------------------------------------------");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		int cnt = 0;
		
		try {

			if(comCsrInfoVO != null){
				Map<String, String> mapVO = comCsrInfoVO.getColumnValues();
				param.putAll(mapVO);	
				velParam.putAll(mapVO);
			}

			cnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAOUpdateAproGwDtUSQL(), param, velParam);
			
			if(cnt == 0) {
				log.error("There is no updated data.");
				throw new DAOException("There is no updated data.");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			//throw de;
			throw new DAOException(new ErrorHandler(de).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * GW에서 결과 값 전송<br>
	 * AP_INV_HDR 의  GW Url, Request_id 업데이트
	 * @param csr_no
	 * @param request_id
	 * @param gw_url
	 * @throws DAOException
	 */
	public void updateAproGwUrl(String csr_no, String request_id, String gw_url) throws DAOException {
		log.debug("\n DAO.updateAproGwUrl --------------------------------------------------");
		
		Map<String, Object> mapVO 		= new HashMap<String, Object>();
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			mapVO.put("csr_no", csr_no);
			mapVO.put("request_id", request_id);
			mapVO.put("gw_url", gw_url);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAOUpdateAproGwUrlUSQL(), param, velParam);

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
	 * Approval Request시 G/W 관련 정보 조회
	 * @param csr_no
	 * @param flg
	 * @return String
	 * @throws DAOException
	 */
	public String searchAproStepInfo(String csr_no, String flg) throws DAOException {
		String sRtn = "";
		
		try {
			DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			param.put("csr_no", csr_no);	
			param.put("flg", flg);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchAproStepInfoRSQL(), param, param);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("attr");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtn;
	}
	
	/**
	 * File Save Id로 File Size를 가져온다.
	 * @param file_id
	 * @return file_size
	 * @throws DAOException
	 */
	public String searchFileSize(String file_id) throws DAOException {
		String sRtn = "";
		
		try {
			DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			param.put("file_id", file_id);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchFileSizeRSQL(), param, param);
			while (dbRowset.next()) {
				sRtn = dbRowset.getString("L_FILE_SZ");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtn;
	}

	/**
	 * CSR_NO로 SUB_SYS_CD 조회<br>
	 * @param String csrNo
	 * @return String subSysCd
	 * @throws DAOException
	 */
    public String searchSubSysCd(String csrNo) throws DAOException {        
        DBRowSet dbRowset = null;
        
        try{
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();     
            
        	// 조회조건
        	param.put("csr_no", csrNo);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchSubSysCdRSQL(), param, velParam);
            
            if (dbRowset.next()) {            	
            	String subSysCd = dbRowset.getString(1);            	 
            	return subSysCd;
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }       
    }  	   
    
    /**
	 * Agreement Doc 존재여부를 조회한다.<br>
	 * @param String csrNo
	 * @return String 
	 * @throws DAOException
	 */
    public String searchAgmtCfmCd(String csrNo) throws DAOException {        
        DBRowSet dbRowset = null;
        
        try{
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();     
            
        	// 조회조건
        	param.put("csr_no", csrNo);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchAgmtCfmCdRSQL(), param, velParam);
            
            if (dbRowset.next()) {            	
            	String agmtCfmCd = dbRowset.getString(1);            	 
            	return agmtCfmCd;
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }       
    }  	   
    
    /**
   	 * PDT우회 계정 정보를 조회한다.<br>
   	 * @param String csrNo
   	 * @return String 
   	 * @throws DAOException
   	 */
       public String searchNewAproJbTitCd(String csrNo) throws DAOException {        
           DBRowSet dbRowset = null;
           
           try{
           	// query parameter
               Map<String, String> param = new HashMap<String, String>();
               // velocity parameter
               Map<String, String> velParam = new HashMap<String, String>();     
               
           	// 조회조건
           	param.put("csr_no", csrNo);   	
           	// velocity parameter 설정 
            velParam.putAll(param);
               
           	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchNewAproJbTitCdRSQL(), param, velParam);
               
               if (dbRowset.next()) {            	
               	String newAproJbTitCd = dbRowset.getString(1);            	 
               	return newAproJbTitCd;
               }
               
               return null;
               
           }catch(SQLException se){
               log.error(se.getMessage(),se);
               throw new DAOException(new ErrorHandler(se).getMessage(), se);
           }catch(Exception ex){
               log.error(ex.getMessage(),ex);
               throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
           }       
       }  
       
    /**
   	 * PDT우회 계정 정보를 업데이트 한다.<br>
   	 * 
   	 * @param String csrNo
   	 * @param String newAproJbTitCd
   	 * @exception DAOException
   	 */
   	public void updateNewAproJbTitCd(String csrNo, String newAproJbTitCd) throws DAOException {
   		log.debug("\n DAO.updateNewAproJbTitCd --------------------------------------------------");
   		
   		Map<String, Object> param 		= new HashMap<String, Object>();
   		//velocity parameter
   		Map<String, Object> velParam 	= new HashMap<String, Object>();
   		
   		try {
   			param.put("csr_no", csrNo);   	
   			param.put("apro_jb_tit_cd", newAproJbTitCd);   	
   	        // velocity parameter 설정 
   	        velParam.putAll(param);;	

   			new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAOUpdateNewAproJbTitCdUSQL(), param, velParam);

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
	 * CSR 생성시의 Agreement 존재 여부 update <br>
	 * 
	 * @param csr_no
	 * @throws DAOException
	 */
   	public void updateAproGwPassFlg(String csr_no) throws DAOException {
		log.debug("\n DAO.updateAproGwPassFlg --------------------------------------------------");
		
		Map<String, Object> mapVO 		= new HashMap<String, Object>();
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			mapVO.put("csr_no", csr_no);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAOUpdateAproGwPassFlgUSQL(), param, velParam);

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
   	 * AGMT_EVID_CFM_FNL_CD update <br>
   	 * @param cfm_fnl_cd
   	 * @param csr_no
   	 * @throws DAOException
   	 */
   	public void updateAproGwFnlPassFlg(String cfm_fnl_cd, String csr_no) throws DAOException {
		log.debug("\n DAO.updateAproGwFnlPassFlg --------------------------------------------------");
		
		Map<String, Object> mapVO 		= new HashMap<String, Object>();
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			mapVO.put("cfm_fnl_cd", cfm_fnl_cd);
			mapVO.put("csr_no", csr_no);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAOUpdateAproGwFnlPassFlgUSQL(), param, velParam);

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
	 * Agreement Doc 존재여부를 조회한다.<br>
	 * @param String csrNo
	 * @return String 
	 * @throws DAOException
	 */
    public String searchAgmtCfmCd2(String csrNo) throws DAOException {        
        DBRowSet dbRowset = null;
        
        try{
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();     
            
        	// 조회조건
        	param.put("csr_no", csrNo);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchAgmtCfmCd2RSQL(), param, velParam);
            
            if (dbRowset.next()) {            	
            	String agmtCfmCd = dbRowset.getString(1);            	 
            	return agmtCfmCd;
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }       
    }  
    
    
 	/**
	 * Agreement Doc 존재여부를 조회한다.<br>
	 * CHM-201535264 비용결재권자 조정<br>
	 * yoo(2015.04.13)심성윤<br> 
	 * @param String csrNo
	 * @param String loginOfcCd
	 * @return String 
	 * @throws DAOException
	 */
    public String getExptOfc(String csrNo, String loginOfcCd) throws DAOException {        
        DBRowSet dbRowset = null;
        
        try{
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();     
            
        	// 조회조건
        	param.put("csr_no", csrNo);
        	param.put("login_ofc_cd", loginOfcCd);
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOGetExptOfcRSQL(), param, velParam);
            
            if (dbRowset.next()) {            	
            	String agmtCfmCd = dbRowset.getString(1);            	 
            	return agmtCfmCd;
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }       
    }
    
 	/**
	 * Default 결재 라인의 존재 유무 확인<br>
	 * CHM-201535264 비용결재권자 조정<br>
	 * yoo(2015.04.13)심성윤<br> 
	 * @return String 
	 * @throws DAOException
	 */
    public String checkDftAproStepYN() throws DAOException {        
        DBRowSet dbRowset = null;
        
        try{
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();     
            
        	// 조회조건
        	// velocity parameter 설정 
            //velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOCheckDftAproStepYNRSQL(), param, velParam);
            
            if (dbRowset.next()) {            	
            	String agmtCfmCd = dbRowset.getString(1);            	 
            	return agmtCfmCd;
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }       
    }
    
    /**
     * ExeActTpCd 구하기
     * @param csrNo
     * @return String
     * @throws DAOException
     */
    public String searchExeActTpCd(String csrNo) throws DAOException {        
        DBRowSet dbRowset = null;
        String exe_act_tp_cd = null;
        
        try{
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();     
            
        	// 조회조건
        	param.put("csr_no", csrNo);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchExeActTpCdRSQL(), param, velParam);
            
            if (dbRowset.next()) {        	
            	exe_act_tp_cd = dbRowset.getString(1);            	 
            }
           
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return exe_act_tp_cd;
    } 
    
    /**
     * ExeActTpCd update하기
     * @param csr_no
     * @param exe_act_tp_cd
     * @throws DAOException
     */
   	public void updateExeActTpCd(String csr_no, String exe_act_tp_cd) throws DAOException {
		log.debug("\n DAO.updateExeActTpCd --------------------------------------------------");
		
		Map<String, Object> mapVO 		= new HashMap<String, Object>();
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			mapVO.put("csr_no", csr_no);
			mapVO.put("exe_act_tp_cd", exe_act_tp_cd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAOUpdateExeActTpCdUSQL(), param, velParam);

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
     * Asa No open/close 정보 구하기
     * @param csrNo costOfcCd
     * @return String
     * @throws DAOException
     */
    public DBRowSet searchAsaNoInfo(String csrNo) throws DAOException {        
        DBRowSet dbRowset = null;
        
        try{
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();     
            
        	// 조회조건
        	param.put("csr_no", csrNo);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchAsaNoInfoRSQL(), param, velParam);
           
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return dbRowset;
    } 
    
    /**
     * open 되어 있는 ASA NO 조회
     * @param asaOfcCd
     * @return asaNo
     * @throws DAOException
     */
    public String searchAsaNo(String asaOfcCd) throws DAOException {        
        DBRowSet dbRowset = null;
        String asaNo = null;
        
        try{
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();     
            
        	// 조회조건
        	param.put("asa_ofc_cd", asaOfcCd);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalDBDAOSearchAsaNoRSQL(), param, velParam);
            
            if (dbRowset.next()) {        	
            	asaNo = dbRowset.getString(1);            	 
            }
           
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return asaNo;
    } 
    
    public void updateAsaNo(String asaNo, String csrNo) throws DAOException {
		log.debug("\n DAO.updateAsaNo --------------------------------------------------");
		
		Map<String, Object> mapVO 		= new HashMap<String, Object>();
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		int cnt = 0;
		
		try {
			mapVO.put("asa_no", asaNo);
			mapVO.put("csr_no", csrNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			cnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ApprovalDBDAOUpdateAsaNoUSQL(), param, velParam);
			
			if(cnt == 0) {
				log.error("There is no updated ASA No.");
			} else {
				log.error("There is updated ASA No.");
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
	}    
}