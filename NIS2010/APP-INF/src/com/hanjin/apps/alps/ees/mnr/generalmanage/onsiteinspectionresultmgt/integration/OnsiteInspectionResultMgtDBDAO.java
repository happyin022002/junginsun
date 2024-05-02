/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OnsiteInspectionResultMgtDBDAO.java
 *@FileTitle : On-site Inspection Result Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.07.21
 *@LastModifier : 이율규
 *@LastVersion : 1.0
 * 2015.07.21 이율규
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.basic.OnsiteInspectionResultMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.vo.MnrOnSite2VO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.vo.MnrOnSiteVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * alps OnsiteInspectionResultMgtDBDAO <br>
 * - alps-GeneralManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LEE YULKYU
 * @see OnsiteInspectionResultMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class OnsiteInspectionResultMgtDBDAO extends DBDAOSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * [EES_MNR_0273]M&R Onsite Inspection Result Detail 의 정보를 조회 합니다. <br>
	 * 
	 * @param MnrOnSiteVO mnrOnSiteVO
	 * @return List<MnrOnSiteVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MnrOnSiteVO> searchOnsiteInspectionResultDetailData(MnrOnSiteVO mnrOnSiteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MnrOnSiteVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mnrOnSiteVO != null) {
				Map<String, String> mapVO = mnrOnSiteVO.getColumnValues();

				param.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OnsiteInspectionResultMgtDBDAOSearchDataBeforeRetrievalRSQL(), param, velParam);

			if (dbRowset.next()) {
				log.error("Data Exist!");
			} else {
				new SQLExecuter("").executeUpdate((ISQLTemplate) new OnsiteInspectionResultMgtDBDAOInsertDetailCSQL(), param, velParam);
				new SQLExecuter("").executeUpdate((ISQLTemplate) new OnsiteInspectionResultMgtDBDAOInsertHeaderCSQL(), param, velParam);
			}
			dbRowset = null;

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OnsiteInspectionResultMgtDBDAOSearchDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MnrOnSiteVO.class);
			dbRowset = null;
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OnsiteInspectionResultMgtDBDAOSearchFileSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				list.get(0).setFileSeq(dbRowset.getString("FILE_SEQ"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [EES_MNR_0273]M&R Onsite Inspection Result Detail 의 정보를 조회 합니다. <br>
	 * 
	 * @param List<MnrOnSiteVO> mnrOnSiteVOs
	 * @exception DAOException
	 */
	public void updateOnsiteInspectionResultListData(List<MnrOnSiteVO> mnrOnSiteVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (mnrOnSiteVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OnsiteInspectionResultMgtDBDAOUpdateDetailUSQL(), mnrOnSiteVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
				
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();
				Map<String, String> mapVO = mnrOnSiteVOs.get(0).getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				new SQLExecuter("").executeUpdate((ISQLTemplate) new OnsiteInspectionResultMgtDBDAOUpdateHeaderUSQL(), param, velParam);
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
	 * [EES_MNR_0273]M&R Onsite Inspection Result Detail 의 정보를 삭제 합니다. <br>
	 * 
	 * @param MnrOnSiteVO mnrOnSiteVO
	 * @exception DAOException
	 */
	public void deleteOnsiteInspectionResultListData(MnrOnSiteVO mnrOnSiteVO) throws DAOException {
		try {
				
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, String> mapVO = mnrOnSiteVO.getColumnValues();

				param.putAll(mapVO);
				new SQLExecuter("").executeUpdate((ISQLTemplate) new OnsiteInspectionResultMgtDBDAODeleteHeaderDSQL(), param, null);
				new SQLExecuter("").executeUpdate((ISQLTemplate) new OnsiteInspectionResultMgtDBDAODeleteDetailDSQL(), param, null);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0271]M&R Onsite Inspection Result Header 의 정보를 조회 합니다. <br>
	 * 
	 * @param MnrOnSiteVO mnrOnSiteVO
	 * @return List<MnrOnSiteVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<MnrOnSiteVO> searchOnsiteInspectionResultListData(MnrOnSiteVO mnrOnSiteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MnrOnSiteVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mnrOnSiteVO != null) {
				Map<String, String> mapVO = mnrOnSiteVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OnsiteInspectionResultMgtDBDAOSearchHeaderRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MnrOnSiteVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [EES_MNR_0271]M&R Onsite Inspection Result Header 의 정보를 조회 합니다. <br>
	 * 
	 * @param MnrOnSite2VO mnrOnSite2VO
	 * @return List<MnrOnSite2VO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<MnrOnSite2VO> searchOnsiteInspectionResultListData2(MnrOnSite2VO mnrOnSite2VO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MnrOnSite2VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mnrOnSite2VO != null) {
				Map<String, String> mapVO = mnrOnSite2VO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OnsiteInspectionResultMgtDBDAOSearchHeader2RSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MnrOnSite2VO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [EES_MNR_0274]M&R Onsite Inspection Result 의 설문항목들을 조회 합니다. <br>
	 * 
	 * @param MnrOnSiteVO mnrOnSiteVO
	 * @return List<MnrOnSiteVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MnrOnSiteVO> searchOnsiteInspectionResultItems(MnrOnSiteVO mnrOnSiteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MnrOnSiteVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mnrOnSiteVO != null) {
				Map<String, String> mapVO = mnrOnSiteVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OnsiteInspectionResultMgtDBDAOSearchSurveyItemsRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MnrOnSiteVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [EES_MNR_0274]M&R Onsite Inspection Result 의 설문항목들을 수정 합니다. <br>
	 * 
	 * @param List<MnrOnSiteVO> mnrOnSiteVOs
	 * @exception DAOException
	 */
	public void insertOnsiteInspectionResultItems(List<MnrOnSiteVO> mnrOnSiteVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = mnrOnSiteVOs.get(0).getColumnValues();

			param.putAll(mapVO);
			
			//수정 작업 전에 Delete Flag가 Y가 아닌 데이터를 모두 삭제
			new SQLExecuter("").executeUpdate((ISQLTemplate) new OnsiteInspectionResultMgtDBDAODeleteSurveyItemsDSQL(), param, null);
			
			
			//ALPS상에서 사용자가 지정한 정렬 순서를 반영하여 전체 설문항목을 재 입력
			if (mnrOnSiteVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OnsiteInspectionResultMgtDBDAOInsertSurveyItemsCSQL(), mnrOnSiteVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * [EES_MNR_0274]M&R Onsite Inspection Result 의 설문항목의 DELETE FLAG를 Y로 변경합니다. <br>
	 * 
	 * @param List<MnrOnSiteVO> mnrOnSiteVOs
	 * @exception DAOException
	 */
	public void updateOnsiteInspectionResultItems(List<MnrOnSiteVO> mnrOnSiteVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if (mnrOnSiteVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OnsiteInspectionResultMgtDBDAOUpdateSurveyItemsDeleteFlagUSQL(), mnrOnSiteVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
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
}
