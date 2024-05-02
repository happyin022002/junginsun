/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SpecialReportDBDAO.java
 *@FileTitle : BookingReport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.28
 *@LastModifier : 강동윤
 *@LastVersion : 1.0
 * 2009.05.28 강동윤
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.specialreport.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.basic.SpecialReportBCImpl;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.BkgRptSetVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.ReportTemplateListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.SpecialCargoManifestInfoVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.SpecialCargoSummaryReportVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 *  SpecialReportDBDAO <br>
 * - BookingReport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kang dong yun
 * @see SpecialReportBCImpl 참조
 * @since J2EE 1.6
 */
public class SpecialReportDBDAO extends DBDAOSupport {

	/**
	 * SpecialReportDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String usrId
	 * @param String rptId
	 * @param String bkgRptKndCd
	 * @return List<BkgRptSetVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgRptSetVO> searchReportTemplateId(String usrId, String rptId, String bkgRptKndCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgRptSetVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (usrId != null) {
				param.put("usr_id", usrId);
				param.put("rpt_id", rptId);
				param.put("bkg_rpt_knd_cd", bkgRptKndCd);

				velParam.put("usr_id", usrId);
				velParam.put("rpt_id", rptId);
				velParam.put("bkg_rpt_knd_cd", bkgRptKndCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SpecialReportDBDAOBkgRptSetVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgRptSetVO.class);
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
	 * SpecialReportDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String usrId
	 * @return List<BkgRptSetVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgRptSetVO> searchUserInfo(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgRptSetVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (usrId != null) {
				param.put("usr_id", usrId);

				velParam.put("usr_id", usrId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SpecialReportDBDAOReportTemplateListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgRptSetVO.class);
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
	 * 단건의 데이터를 생성한다.<br>
	 * 
	 * @param ReportTemplateListVO vo
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addReportTemplateList(ReportTemplateListVO vo) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<ReportTemplateListVO> list = null;

		int result = 0;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SpecialReportDBDAOReportTemplateListVO2RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReportTemplateListVO.class);

			// bkg_rpt_set 테이블에 기존등록정보가 없을 때
			if (list.size() == 0) {

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate) new SpecialReportDBDAOReportTemplateListVOCSQL(), param, velParam);
			} else {

				throw new DAOException(new ErrorHandler("COM12240").getMessage());
			}

			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 단건의 데이터를 수정한다.<br>
	 * 
	 * @param ReportTemplateListVO vo
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyReportTemplateList(ReportTemplateListVO vo) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<ReportTemplateListVO> list = null;

		int result = 0;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SpecialReportDBDAOReportTemplateListVO2RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReportTemplateListVO.class);
			log.debug("LIST2 SIZE = " + list.size());
			// bkg_rpt_set 테이블에 기존등록정보가 없을 때
			if (list.size() == 0) {

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate) new SpecialReportDBDAOReportTemplateListVOCSQL(), param, velParam);
			} else {

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate) new SpecialReportDBDAOReportTemplateListVOUSQL(), param, velParam);
			}

			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PerformanceReportDBDAO의 데이타 모델에 해당되는 값을 수정온다.<br>
	 * 
	 * @param ReportTemplateListVO vo
	 * @throws DAOException
	 */
	public void removeReportTemplateList(ReportTemplateListVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new SpecialReportDBDAOReportTemplateListVODSQL(), param, velParam);

			if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * 0104 Report template(Default, Detail, User Set) 을 조회합니다.<br>
	 * 
	 * @param ReportTemplateListVO reportTemplateListVO
	 * @return List<ReportTemplateListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ReportTemplateListVO> searchReportTemplateBstVipList(ReportTemplateListVO reportTemplateListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportTemplateListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = reportTemplateListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SpecialReportDBDAOSearchReportTemplateBstVipList1RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReportTemplateListVO.class);

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
	 * 0104_01 S/Route Code(MDM table Sconti_cd) 목록을 조회합니다.<br>
	 * 
	 * @return List<BkgComboVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgComboVO> searchScontiCd() throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SpecialReportDBDAOSearchReportTemplateBstVipList2RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgComboVO.class);

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
	 * VVD별 special cargo 요약정보 조회 기능(ESM_BKG_0588)<br>
	 * Special cargo summary information<br>
	 * 
	 * @param SpecialCargoSummaryReportVO vo
	 * @return List<SpecialCargoSummaryReportVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SpecialCargoSummaryReportVO> searchSpecialCargoSummaryReport(SpecialCargoSummaryReportVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpecialCargoSummaryReportVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SpecialReportDBDAOSpecialCargoSummaryReportVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SpecialCargoSummaryReportVO.class);

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
	 * checkDBDAOException
	 * 
	 * @param int[] updCnt
	 * @throws DAOException
	 */
	public void checkDBDAOException(int[] updCnt) throws DAOException {
		for (int i = 0; updCnt != null && i < updCnt.length; i++) {
			checkDBDAOException(updCnt[i]);
		}
	}

	/**
	 * checkDBDAOException
	 * 
	 * @param int updCnt
	 * @throws DAOException
	 */
	public void checkDBDAOException(int updCnt) throws DAOException {
		if (updCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + updCnt + " SQL");
	}


	/**
	 * Special Cargo Manifest 요약정보 조회 기능(ESM_BKG_0485)<br>
	 * Special Cargo Manifest information<br>
	 * 
	 * @param SpecialCargoManifestInfoVO vo
	 * @return List<SpecialCargoManifestInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SpecialCargoManifestInfoVO> searchSpecialCargoManifestInfo(SpecialCargoManifestInfoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpecialCargoManifestInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SpecialReportDBDAOSpecialCargoManifestInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SpecialCargoManifestInfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

}
