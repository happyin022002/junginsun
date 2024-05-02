/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMReportDBDAO.java
*@FileTitle : ACMReportDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.16
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.16 김봉균
* 1.0 Creation
* 
* 2014.06.11 박다은 [CHM-201428456] Comm 모듈의 ACM 발행 CSR Detail 기능 로직 변경
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmreport.acmreport.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.basic.ACMReportBCImpl;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CSRDetailVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CSRInquiryVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CommReportVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.EstimatedPerformanceVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.ReportItemVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CSRDetailforCommissionVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CSRDetailforCommissionHdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ACMReportDBDAO <br>
 * - ALPS-ACMReport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Bong-Gyoon
 * @see ACMReportBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class ACMReportDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0034]
	 * CSR Inquiry 목록을 조회<br>
	 *
	 * @param CSRInquiryVO csrInquiryVO
	 * @return List<CSRInquiryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CSRInquiryVO> searchCSRInquiry(CSRInquiryVO csrInquiryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CSRInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (csrInquiryVO != null) {
				Map<String, String> mapVO= csrInquiryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMReportDBDAOSearchCSRInquiryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CSRInquiryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	 /**
	  * [ESM_ACM_0034]
	  * CSR Inquiry 목록을 조회(CURR_CD에 따른 Total 값 구하기)<br>
	  *
	  * @param CSRInquiryVO csrInquiryVO
	  * @return List<CSRInquiryVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CSRInquiryVO> searchCSRInquiryCurrAMT(CSRInquiryVO csrInquiryVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CSRInquiryVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if (csrInquiryVO != null) {
				 Map<String, String> mapVO= csrInquiryVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMReportDBDAOSearchCSRInquiryCurrAMTListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CSRInquiryVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(), se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(), ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }

	/**
	 * [ESM_ACM_0111]
	 * CSR Detail 목록을 조회<br>
	 *
	 * @param CSRDetailVO csrDetailVO
	 * @return List<CSRDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CSRDetailVO> searchCSRDetail(CSRDetailVO csrDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CSRDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (csrDetailVO != null) {
				Map<String, String> mapVO= csrDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMReportDBDAOSearchCSRDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CSRDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0037], [ESM_ACM_0118]
	 * Customized RPT Form 콤보 그룹명을 조회<br>
	 *
	 * @param ReportItemVO reportItemVO
	 * @return List<ReportItemVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReportItemVO> getReportGroup(ReportItemVO reportItemVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportItemVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (reportItemVO != null) {
				Map<String, String> mapVO= reportItemVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMReportDBDAOGetReportGroupListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportItemVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0037], [ESM_ACM_0118]
	 * Customized RPT Form 컬럼 Item 목록을 조회
	 *
	 * @param ReportItemVO reportItemVO
	 * @return List<ReportItemVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReportItemVO> getReportItem(ReportItemVO reportItemVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportItemVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (reportItemVO != null) {
				Map<String, String> mapVO= reportItemVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMReportDBDAOGetReportItemListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportItemVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0037]
	 * Commission Report 목록을 조회<br>
	 *
	 * @param CommReportVO commReportVO
	 * @return List<CommReportVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommReportVO> searchCommReport(CommReportVO commReportVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommReportVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (commReportVO != null) {
				Map<String, String> mapVO= commReportVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMReportDBDAOSearchCommReportListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommReportVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0118]
	 * Customized RPT Form 콤보 그룹명을 삭제<br>
	 *
	 * @param ReportItemVO reportItemVO
	 * @exception EventException
	 */
	public void removeReportGroup(ReportItemVO reportItemVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (reportItemVO != null) {
				Map<String, String> mapVO= reportItemVO.getColumnValues();

				param.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ACMReportDBDAORemoveReportGroupListDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0118]
	 * Customized RPT Form 컬럼 Item 목록을 삭제<br>
	 *
	 * @param ReportItemVO reportItemVO
	 * @exception EventException
	 */
	public void removeReportItem(ReportItemVO reportItemVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (reportItemVO != null) {
				Map<String, String> mapVO= reportItemVO.getColumnValues();
				param.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ACMReportDBDAORemoveReportItemListDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0118]
	 * Customized RPT Form 콤보 그룹에 지정할 SlctItmFomSeq의 Max값을 가져옴
	 *
	 * @param ReportItemVO reportItemVO
	 * @return List<ReportItemVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReportItemVO> getMaxSlctItmFomSeq(ReportItemVO reportItemVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportItemVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (reportItemVO != null) {
				Map<String, String> mapVO= reportItemVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMReportDBDAOGetMaxSlctItmFomSeqInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportItemVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0118]
	 * Customized RPT Form 콤보 그룹명을 생성<br>
	 *
	 * @param ReportItemVO reportItemVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addReportGroup(ReportItemVO reportItemVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (reportItemVO != null) {
				Map<String, String> mapVO= reportItemVO.getColumnValues();
				param.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ACMReportDBDAOAddReportGroupListCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0118]
	 * Customized RPT Form 컬럼 Item 목록을 일괄적으로 생성<br>
	 *
	 * @param List<ReportItemVO> reportItemVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addReportItem(List<ReportItemVO> reportItemVOList) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (reportItemVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMReportDBDAOAddReportItemListCSQL(), reportItemVOList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_ACM_9991]
	 * CSR Detail 목록을 조회<br>
	 *
	 * @param EstimatedPerformanceVO estimatedPerformanceVO
	 * @return List<EstimatedPerformanceVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EstimatedPerformanceVO> searchEstimatedPerformance(EstimatedPerformanceVO estimatedPerformanceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstimatedPerformanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (estimatedPerformanceVO != null) {
				Map<String, String> mapVO= estimatedPerformanceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMReportDBDAOSearchEstimatedPerformanceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EstimatedPerformanceVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 

		/**
		 * [ESM_ACM_9991]
		 * Estimated Performance 목록을 생성<br>
		 *
		 * @param List<EstimatedPerformanceVO> estimatedPerformanceVO
		 * @throws DAOException
		 * @throws Exception
		 */
		public void addEstimatedPerformance(List<EstimatedPerformanceVO> estimatedPerformanceVO) throws DAOException, Exception {
			int insCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if (estimatedPerformanceVO.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMReportDBDAOAddEstimatedPerformanceListCSQL(), estimatedPerformanceVO, null);
					for (int i = 0; i < insCnt.length; i++) {
						if (insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 * [ESM_ACM_9991]
		 * Estimated Performance 목록을 수정<br>
		 *
		 * @param List<EstimatedPerformanceVO> estimatedPerformanceVO
		 * @exception EventException
		 */
		public void modifyEstimatedPerformance(List<EstimatedPerformanceVO> estimatedPerformanceVO) throws DAOException, Exception {
			int delCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if (estimatedPerformanceVO.size() > 0) {
					delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMReportDBDAOModifyEstimatedPerformanceListUSQL(), estimatedPerformanceVO, null);
					for (int i = 0; i < delCnt.length; i++) {
						if (delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		
		/**
		 * [ESM_ACM_0119] CSR Detail 팝업
		 * 
		 * @param csrDetailforCommissionHdVO
		 * @return
		 * @throws DAOException
		 * @throws Exception
		 */
		public List<CSRDetailforCommissionHdVO> searchCSRDetailforCommissionHdr(
				CSRDetailforCommissionHdVO csrDetailforCommissionHdVO) throws DAOException, Exception{
			DBRowSet dbRowSet = null;
			List<CSRDetailforCommissionHdVO> list = null;
			//query paramter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity paramter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(csrDetailforCommissionHdVO != null){
					Map<String, String> mapVO = csrDetailforCommissionHdVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMReportDBDAOCSRDetailforCommissionHdrRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, CSRDetailforCommissionHdVO.class);
			}catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;

	    }

		
		/**
		 * [ESM_ACM_0119] CSR Detail 팝업
		 * 
		 * @param csrDetailforCommissionVO
		 * @return
		 * @throws DAOException
		 * @throws Exception
		 */
		public List<CSRDetailforCommissionVO> searchCSRDetailforCommissionDtrb(
				CSRDetailforCommissionVO csrDetailforCommissionVO) throws DAOException, Exception{
			DBRowSet dbRowSet = null;
			List<CSRDetailforCommissionVO> list = null;
			//query paramter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity paramter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(csrDetailforCommissionVO != null){
					Map<String, String> mapVO = csrDetailforCommissionVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMReportDBDAOCSRDetailforCommissionDtrbRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowSet, CSRDetailforCommissionVO.class);
			}catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
	    }


}