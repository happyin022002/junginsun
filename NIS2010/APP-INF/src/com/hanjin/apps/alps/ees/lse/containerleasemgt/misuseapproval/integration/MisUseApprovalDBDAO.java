/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MisUseApprovalDBDAO.java
*@FileTitle : Mis Use In & Out Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.14 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.basic.MisUseApprovalBCImpl;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseApprovalVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseContainerInfoVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseInOutInquiryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseReqContainerVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseRequestVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.SearchParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS MisUseApprovalDBDAO <br>
 * - ALPS-ContainerLeaseMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jang Jun-Woo
 * @see MisUseApprovalBCImpl 참조
 * @since J2EE 1.6
 */
public class MisUseApprovalDBDAO extends DBDAOSupport {

	/**
	 * Miss Use 최대 Request No.를 조회합니다.<br>
	 *
	 * @param  String ofcCd
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchNewMisUseRequestNumberData(String ofcCd) throws DAOException {
		String rqstNo = "";
	    DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
	    	param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter().executeQuery(new MisUseApprovalDBDAOMisUseRequestNumberRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		rqstNo = dbRowset.getString("RQST_NO");
	    	}
	    } catch(SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}

		return rqstNo;
	}

	/**
	 * 입력된 컨테이너 번호에 대한 요청내역을 조회합니다.<br>
	 *
	 * @param  String cntrNo
	 * @return List<MisUseReqContainerVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MisUseReqContainerVO> searchMisUseReqContainerExistData(String cntrNo) throws DAOException {

		DBRowSet dbRowset = null;
		List<MisUseReqContainerVO> resultVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);

			dbRowset  = new SQLExecuter().executeQuery(new MisUseApprovalDBDAOMisUseReqContainerListRSQL(), param, velParam);
			resultVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, MisUseReqContainerVO.class);
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return resultVOs;
	}

	/**
	 * 입력된 컨테이너 번호에 대한 기본정보를 조회합니다.<br>
	 *
	 * @param  String cntrNo
	 * @return List<MisUseContainerInfoVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MisUseContainerInfoVO> searchMisUseRequestContainerData(String cntrNo) throws DAOException {

		DBRowSet dbRowset = null;
		List<MisUseContainerInfoVO> resultVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);

			dbRowset  = new SQLExecuter().executeQuery(new MisUseApprovalDBDAOMisUseReqContainerInfoRSQL(), param, velParam);
			resultVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, MisUseContainerInfoVO.class);
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return resultVOs;
	}

	/**
	 * Miss Use Request 요청내역 정보를 생성합니다.<br>
	 *
	 * @param  MisUseRequestVO misUseRequestVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addMisUseRequestInfoData(MisUseRequestVO misUseRequestVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = misUseRequestVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new MisUseApprovalDBDAOMisUseRequestInfoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Miss Use Request 요청장비 목록을 일괄 생성합니다.<br>
	 *
	 * @param  List<MisUseReqContainerVO> misUseReqContainerVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addMisUseReqContainerInfoListData(List<MisUseReqContainerVO> misUseReqContainerVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			int insCnt[] = null;
			if(misUseReqContainerVOs.size() > 0) {
				insCnt = sqlExe.executeBatch(new MisUseApprovalDBDAOMisUseReqContainerInfoCSQL(), misUseReqContainerVOs, null);
				for(int i = 0; i < insCnt.length; i++) {
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Miss Use 최대 Approval No.를 조회합니다.<br>
	 *
	 * @param  String ofcCd
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchNewMisUseApprovalNumberData(String ofcCd) throws DAOException {
		String aproNo = "";
	    DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
	    	param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter().executeQuery(new MisUseApprovalDBDAOMisUseApprovalNumberRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		aproNo = dbRowset.getString("APRO_NO");
	    	}
	    } catch(SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}

		return aproNo;
	}

	/**
	 * 승인대상 Miss Use Request No. 목록을 조회합니다.<br>
	 *
	 * @return List<MisUseRequestVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MisUseRequestVO> searchMisUseRequestNoItemsData() throws DAOException {

		DBRowSet dbRowset = null;
		List<MisUseRequestVO> resultVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset  = new SQLExecuter().executeQuery(new MisUseApprovalDBDAOMisUseRequestNoItemsRSQL(), param, velParam);
			resultVOs = (List)RowSetUtil. rowSetToVOs(dbRowset, MisUseRequestVO.class);
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return resultVOs;
	}

	/**
	 * 선택 Request No.에 대한 요청정보을 조회합니다.<br>
	 *
	 * @param  String rqstNo
	 * @return List<MisUseRequestVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MisUseRequestVO> searchMisUseRequestInfoData(String rqstNo) throws DAOException {

		DBRowSet dbRowset = null;
		List<MisUseRequestVO> resultVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("rqst_no", rqstNo);
			velParam.put("rqst_no", rqstNo);

			dbRowset  = new SQLExecuter().executeQuery(new MisUseApprovalDBDAOMisUseRequestInfoRSQL(), param, velParam);
			resultVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, MisUseRequestVO.class);
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return resultVOs;
	}

	/**
	 * 선택 Request No.에 대한 장비내역 목록을 조회합니다.<br>
	 *
	 * @param  String rqstNo
	 * @return List<MisUseReqContainerVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MisUseReqContainerVO> searchMisUseReqContainerListData(String rqstNo) throws DAOException {

		DBRowSet dbRowset = null;
		List<MisUseReqContainerVO> resultVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("rqst_no", rqstNo);
			velParam.put("rqst_no", rqstNo);

			dbRowset  = new SQLExecuter().executeQuery(new MisUseApprovalDBDAOMisUseReqContainerListRSQL(), param, velParam);
			resultVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, MisUseReqContainerVO.class);
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return resultVOs;
	}

	/**
	 * Miss Use Request 요청내역 정보를 갱신합니다.<br>
	 *
	 * @param  MisUseRequestVO misUseRequestVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyMisUseRequestInfoData(MisUseRequestVO misUseRequestVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = misUseRequestVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new MisUseApprovalDBDAOMisUseRequestInfoUSQL(), param, velParam);
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
	 * Miss Use Approval 승인내역 정보를 생성합니다.
	 *
	 * @param  MisUseApprovalVO misUseApprovalVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addMisUseApprovalInfoData(MisUseApprovalVO misUseApprovalVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = misUseApprovalVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new MisUseApprovalDBDAOMisUseApprovalInfoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Miss Use Request 승인장비 목록을 일괄 갱신합니다.<br>
	 *
	 * @param  List<MisUseReqContainerVO> misUseReqContainerVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyMisUseReqContainerInfoListData(List<MisUseReqContainerVO> misUseReqContainerVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			int updCnt[] = null;
			if(misUseReqContainerVOs.size() > 0) {
				updCnt = sqlExe.executeBatch(new MisUseApprovalDBDAOMisUseReqContainerInfoUSQL(), misUseReqContainerVOs, null);
				for(int i = 0; i < updCnt.length; i++) {
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 자사 및 타사장비의 Miss Use된 장비의 현황을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<MisUseInOutInquiryListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MisUseInOutInquiryVO> searchMisUseInOutInquiryListData(SearchParamVO searchParamVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<MisUseInOutInquiryVO> resultVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(searchParamVO != null) {
				Map<String, String> mapVO = searchParamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset  = new SQLExecuter().executeQuery(new MisUseApprovalDBDAOMisUseInOutInquiryListRSQL(), param, velParam);
			resultVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, MisUseInOutInquiryVO.class);
		} catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return resultVOs;
	}

	/**
	 * Miss Use Approval 승인장비 목록을 일괄 갱신합니다.<br>
	 *
	 * @param  List<MisUseInOutInquiryVO> misUseInOutInquiryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyMisUseApprovalCancelListData(List<MisUseInOutInquiryVO> misUseInOutInquiryVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			int updCnt[] = null;
			if(misUseInOutInquiryVOs.size() > 0) {
				updCnt = sqlExe.executeBatch(new MisUseApprovalDBDAOMisUseApprovalCancelUSQL(), misUseInOutInquiryVOs, null);
				for(int i = 0; i < updCnt.length; i++) {
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}