/*=========================================================
 *Copyright(c) 2009 CyberLogitec 
 *@FileName : LongTxContainerMovementFinderDBDAO.java
 *@FileTitle : LongTxContainerMovementFinderDBDAO
 *Open Issues :
 *Change history : 2009.08.27 (우경민) - EES_CTM_0418 관련업무 최초생성
 *                 2009.08.28 (김상수) - EES_CTM_0417 관련업무 추가
 *@LastModifyDate : 2009.08.28
 *@LastModifier : 김상수
 *@LastVersion : 1.1
 * 2009.08.27 우경민
 * 1.0 Creation
 * 2009.08.28 김상수
 * 1.1 Modification
 * --------------------------------------------------------
 * History
 * 2010.12.28 김상수 [CHM-201007850-01] [CTM] 업무 고도화 관련 소스 보완
 *                    Log 확인용 표준 출력 로그 제거
 *                    관련 대상 : 16개 file
 *                    변경 사항 : System.out.println => log.info 또는 제거
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.basic.LongTxContainerMovementFinderBCImpl;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.MovementEDIReportVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIErrorVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIResultVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.UpdateRatioDetailVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.VLVDUpdateStatusVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreStsListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS LongTxContainerMovementFinderDBDAO <br>
 * - ALPS-EquipmentMovementMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Kyung Min Woo
 * @see LongTxContainerMovementFinderBCImpl 참조
 * @since J2EE 1.6
 */
public class LongTxContainerMovementFinderDBDAO extends DBDAOSupport {

	/**
	 * CTM_0418 EDI지연시간 통계작성.<br>
	 *
	 * @param MovementEDIReportVO  movementEDIReportVO
	 * @return List<iMovementEDIReportVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MovementEDIReportVO> searchEDIOnTimeDetailList(MovementEDIReportVO  movementEDIReportVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<MovementEDIReportVO > list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(movementEDIReportVO  != null){
				Map<String, String> mapVO = movementEDIReportVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongTxContainerMovementFinderDBDAOiMovementEDIReportVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MovementEDIReportVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 화면 로딩시 RCC 리스트를 조회한다.<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String getRccList(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer comboList = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongTxContainerMovementFinderDBDAOGetRccListRSQL(), param, velParam);
			while (dbRowset.next()) {
				comboList.append(dbRowset.getString("RCC_CD")).append("|").append(dbRowset.getString("CHECKED")).append("|").append("^");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return comboList.toString();
	}

	/**
	 * RCC변경에 따른 해당 LCC를 조회한다.<br>
	 *
	 * @param String rccCd
	 * @return String
	 * @throws DAOException
	 */
	public String getLccList(String rccCd) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer comboList = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("rcc_cd", rccCd);
			velParam.put("rcc_cd", rccCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongTxContainerMovementFinderDBDAOGetLccListRSQL(), param, velParam);
			while (dbRowset.next()) {
				comboList.append(dbRowset.getString("LCC_CD")).append("^");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return comboList.toString();
	}

	/**
	 * EES_CTM_0417 : EDI error율 및 row data를 조회합니다.<br>
	 *
	 * @param SearchEDIErrorVO searchEDIErrorVO
	 * @return List<SearchEDIErrorVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEDIErrorVO> searchEDIErrorSumList(SearchEDIErrorVO SearchEDIErrorVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEDIErrorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(SearchEDIErrorVO != null){
				Map<String, String> mapVO = SearchEDIErrorVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongTxContainerMovementFinderDBDAOSearchEDIErrorSumListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEDIErrorVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * EES_CTM_0417 : 엑셀 다운용 EDI error 상세 데이터를 조회합니다.<br>
	 *
	 * @param SearchEDIErrorVO searchEDIErrorVO
	 * @return List<SearchEDIErrorVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEDIErrorVO> searchEDIErrorDetailExcel(SearchEDIErrorVO searchEDIErrorVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEDIErrorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchEDIErrorVO != null){
				Map<String, String> mapVO = searchEDIErrorVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongTxContainerMovementFinderDBDAOSearchEDIErrorDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEDIErrorVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * EES_CTM_0418 : 엑셀 다운용 EDI 처리지연 통계 상세 데이터를 조회합니다.<br>
	 *
	 * @param UpdateRatioDetailVO  updateRatioDetailVO
	 * @return List<UpdateRatioDetailVO >
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<UpdateRatioDetailVO> getUpdateRatioDetail(UpdateRatioDetailVO  updateRatioDetailVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<UpdateRatioDetailVO > list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.info("VEL :: " + updateRatioDetailVO.getTimeOff());
		log.info("VEL :: " + updateRatioDetailVO.getGap());
		try{
			if(updateRatioDetailVO  != null){
				Map<String, String> mapVO = updateRatioDetailVO.getColumnValues();
				log.info("DOM FLG :: " + updateRatioDetailVO.getDomFlg());

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongTxContainerMovementFinderDBDAOgetUpdateRatioDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UpdateRatioDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * EES_CTM_0420 : EDI result율 및 row data를 조회합니다.<br>
	 *
	 * @param SearchEDIResultVO searchEDIResultVO
	 * @return List<SearchEDIResultVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEDIResultVO> searchEDIResultSumList(SearchEDIResultVO searchEDIResultVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEDIResultVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchEDIResultVO != null){
				Map<String, String> mapVO = searchEDIResultVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongTxContainerMovementFinderDBDAOSearchEDIResultSumListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEDIResultVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * EES_CTM_0420 : 엑셀 다운용 EDI result 상세 데이터를 조회합니다.<br>
	 *
	 * @param SearchEDIResultVO searchEDIResultVO
	 * @return List<SearchEDIResultVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEDIResultVO> searchEDIResultDetailExcel(SearchEDIResultVO searchEDIResultVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEDIResultVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchEDIResultVO != null){
				Map<String, String> mapVO = searchEDIResultVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongTxContainerMovementFinderDBDAOSearchEDIResultDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEDIResultVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * EES_CTM_0420 : EDI result율 및 row data를 조회합니다.<br>
	 *
	 * @param VLVDUpdateStatusVO vLVDUpdateStatusVO
	 * @return List<VLVDUpdateStatusVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VLVDUpdateStatusVO> searchVLVDUpdateStatus(VLVDUpdateStatusVO vLVDUpdateStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VLVDUpdateStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vLVDUpdateStatusVO != null){
				Map<String, String> mapVO = vLVDUpdateStatusVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongTxContainerMovementFinderDBDAOVLVDUpdateStatusRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VLVDUpdateStatusVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * EES_CTM_0462 : AUTO CRE STATUS LIST를 조회한다<br>
	 *
	 * @param AutoCreStsListVO autoCreStsListVO
	 * @return List<AutoCreStsListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AutoCreStsListVO> getAutoCreSts(AutoCreStsListVO autoCreStsListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AutoCreStsListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (autoCreStsListVO != null) {
				Map<String, String> mapVO = autoCreStsListVO.getColumnValues();
				log.info("::::" + autoCreStsListVO.getStsCd() + "::::");
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ContainerMovementMgtDBDAOGetAutoCreStsListRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AutoCreStsListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


}