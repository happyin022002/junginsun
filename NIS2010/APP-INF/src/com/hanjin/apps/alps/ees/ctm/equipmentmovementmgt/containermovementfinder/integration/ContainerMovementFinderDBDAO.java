/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : ContainerMovementFinderDBDAO.java
 * @FileTitle : BKG container update Irr.
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion :
 * 2009.04.29 우경민 1.0 Creation.
 * 2016.09.19 김상현 EES_CTM_0437 화면 Script 오류 수정.
 *  - Container No. 없이 전송되는 경우 발생(Validation 추가).
 */
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.basic.ContainerMovementFinderBCImpl;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.ConCBookingVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmCCLMVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmMvmtIrrVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmVvdHistoryVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchCorrectionHistoryVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchDeletedMVMTListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEdiMsgVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEmptyBookingListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementHistoryMonitorListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByBkgInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByCntrInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByCntrTpszCdVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByMultiContainerVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListBySplitBkgNoForMultiComboVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByVvdForMultiComboVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchVermasListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.searchMovementHistoryVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ContainerMovementFinderDBDAO <br>
 * - ALPS-EquipmentMovementMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KyungMin Woo
 * @see ContainerMovementFinderBCImpl 참조
 * @since J2EE 1.4
 */
public class ContainerMovementFinderDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Container IRR Table List 조회.<br>
	 *
	 * @param CtmMvmtIrrVO ctmMvmtIrrVO
	 * @return List<CtmMvmtIrrVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CtmMvmtIrrVO> searchIrregularContainerList(CtmMvmtIrrVO ctmMvmtIrrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CtmMvmtIrrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ctmMvmtIrrVO != null){
				Map<String, String> mapVO = ctmMvmtIrrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOCtmMvmtIrrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CtmMvmtIrrVO.class);
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
	 * 삭제된 Movement List 조회<br>
	 *
	 * @param SearchDeletedMVMTListVO searchDeletedMVMTListVO
	 * @return List<SearchDeletedMVMTListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchDeletedMVMTListVO> searchDeletedMVMTList(SearchDeletedMVMTListVO searchDeletedMVMTListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDeletedMVMTListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchDeletedMVMTListVO != null){
				Map<String, String> mapVO = searchDeletedMVMTListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchDeletedMVMTListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDeletedMVMTListVO.class);
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
	 * Empty Booking List 조회.<br>
	 *
	 * @param SearchEmptyBookingListVO searchEmptyBookingListVO
	 * @return List<SearchEmptyBookingListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEmptyBookingListVO> searchEmptyBookingList(SearchEmptyBookingListVO searchEmptyBookingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEmptyBookingListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchEmptyBookingListVO != null){
				Map<String, String> mapVO = searchEmptyBookingListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchEmptyBookingListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEmptyBookingListVO.class);
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
	 * 컨테이너 번호에 의한 Each Container LIST 조회
	 * @param searchMovementListByContainerVO
	 * @return List<SearchMovementListByContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchMovementListByContainerVO> searchMovementListByContainer(SearchMovementListByContainerVO searchMovementListByContainerVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMovementListByContainerVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (searchMovementListByContainerVO != null) {
				Map<String, String> mapVO = searchMovementListByContainerVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchMovementListByContainerVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementListByContainerVO.class);
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
	 * 컨테이너 번호에 의한 EDI Message List 조회<br>
	 *
	 * @param SearchEdiMsgVO searchEdiMsgVO
	 * @return List<SearchEdiMsgVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchEdiMsgVO> searchEdiMsg(SearchEdiMsgVO searchEdiMsgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEdiMsgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchEdiMsgVO != null){
				Map<String, String> mapVO = searchEdiMsgVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchEdiMsgVORSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEdiMsgVO.class);
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
	 * BL_NO로 BKG번호 조회<br>
	 *
	 * @param String blNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchMovementListByGetBkgNo(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String returnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_no", blNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchMovementListByGetBkgNoVORSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString("BKG_NO");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * BKG_NO로 Booking Information 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListByBkgInfoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMovementListByBkgInfoVO> searchMovementListByBkgInfo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMovementListByBkgInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchMovementListByBkgInfoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementListByBkgInfoVO.class);
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
	 * PRE_VVD(또는 POST_VVD)와 BKG_NO로 멀티콤보용 VVD_CD조회<br>
	 *
	 * @param String vslPrePstCd
	 * @param String bkgNo
	 * @return List<SearchMovementListByVvdForMultiComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMovementListByVvdForMultiComboVO> searchMovementListByVvdForMultiCombo(String vslPrePstCd, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMovementListByVvdForMultiComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_pre_pst_cd", vslPrePstCd);
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchMovementListByVvdForMultiComboVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementListByVvdForMultiComboVO.class);
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
	 * BKG_NO로 SPLIT_BKG_NO 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListBySplitBkgNoForMultiComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMovementListBySplitBkgNoForMultiComboVO> searchMovementListBySplitBkgNoForMultiCombo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMovementListBySplitBkgNoForMultiComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchMovementListBySplitBkgNoForMultiComboVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementListBySplitBkgNoForMultiComboVO.class);
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
	 * BKG_NO로 CNTR_TPSZ 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListByCntrTpszCdVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMovementListByCntrTpszCdVO> searchMovementListByCntrTpszCd(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMovementListByCntrTpszCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchMovementListByCntrTpszCdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementListByCntrTpszCdVO.class);
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
	 * BKG_NO로 SHEET용 Container Information LIST 조회
	 * @param bkgNo
	 * @return List<SearchMovementListByCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchMovementListByCntrInfoVO> searchMovementListByCntrInfo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMovementListByCntrInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchMovementListByCntrInfoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementListByCntrInfoVO.class);
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
	 * 컨테이너의 부킹정보 상세 내역을 얻어온다.<br>
	 *
	 * @param CtmVvdHistoryVO ctmVvdHistoryVO
	 * @return List<CtmVvdHistoryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CtmVvdHistoryVO> searchVvdHistory(CtmVvdHistoryVO ctmVvdHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CtmVvdHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			 if(ctmVvdHistoryVO != null){
					Map<String, String> mapVO = ctmVvdHistoryVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOConINTCommonVORSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CtmVvdHistoryVO.class);
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
	 * 컨테이너의 이동정보 상세 내역을 얻어온다.
	 * @param ctmVvdHistoryVO
	 * @return List<searchMovementHistoryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<searchMovementHistoryVO> searchMvmtHistory(CtmVvdHistoryVO ctmVvdHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<searchMovementHistoryVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (ctmVvdHistoryVO != null) {
				Map<String, String> mapVO = ctmVvdHistoryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOsearchMovementHistoryRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, searchMovementHistoryVO.class);
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
	 * Cargo Location message 리스트 조회.<br>
	 *
	 * @param CtmCCLMVO ctmCCLMVO
	 * @return List<CtmCCLMVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CtmCCLMVO> searchCLMInfo(CtmCCLMVO ctmCCLMVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CtmCCLMVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ctmCCLMVO != null){
				Map<String, String> mapVO = ctmCCLMVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOCtmCCLMVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CtmCCLMVO.class);
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
	 * 부킹과 Movement의 불일치 내역 조회<BR>
	 *
	 * @param ConCBookingVO conCBookingVO
	 * @param String type
	 * @return List<ConCBookingVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ConCBookingVO> searchMVMTBKGUnmatchList(ConCBookingVO conCBookingVO, String type) throws DAOException {
		DBRowSet dbRowset = null;
		List<ConCBookingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conCBookingVO != null){
					Map<String, String> mapVO = conCBookingVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.put("viewtype", type);
					velParam.put("viewtype", type);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOConCBookingVORSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, ConCBookingVO.class);
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
	 * 부킹과 Movement의 불일치 내역  총 갯수 조회<br>
	 *
	 * @param ConCBookingVO conCBookingVO
	 * @param String type
	 * @return String
	 * @throws DAOException
	 */
	public String searchMVMTBKGUnmatchListCount(ConCBookingVO conCBookingVO, String type) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conCBookingVO != null){
					Map<String, String> mapVO = conCBookingVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.put("viewtype", type);
					velParam.put("viewtype", type);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOConCBookingCountRSQL(), param, velParam);
			 if (dbRowset.next())
				 cnt = dbRowset.getString("MAT");
			 else
				 cnt = "0";
		}catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}

	/**
	 * Booking Caontainet와 EDI 에서 넘어온 자료의 불 일치 내역 조회.<br>
	 *
	 * @param ConCBookingVO conCBookingVO
	 * @param String type
	 * @return List<ConCBookingVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ConCBookingVO> searchResultEDIList(ConCBookingVO conCBookingVO, String type) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<ConCBookingVO> list = null;
		try{
			if(conCBookingVO != null){
					Map<String, String> mapVO = conCBookingVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.put("viewtype", type);
					velParam.put("viewtype", type);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOsearchResultEDIListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, ConCBookingVO.class);
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
	 * 컨테이너 번호에 의한 Each Container LIST 조회
	 * @param searchMovementListByMultiContainerVO
	 * @return List<SearchMovementListByMultiContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchMovementListByMultiContainerVO> searchMovementListByMultiContainer(SearchMovementListByMultiContainerVO searchMovementListByMultiContainerVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter
		List<SearchMovementListByMultiContainerVO> list = null;

		try {
			if (searchMovementListByMultiContainerVO != null) {
				if (!searchMovementListByMultiContainerVO.getCntrNo().equals("")) {
					searchMovementListByMultiContainerVO.setRccCd("");
				}

				Map<String, String> mapVO = searchMovementListByMultiContainerVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				// Multi container list 변경
				if (!searchMovementListByMultiContainerVO.getCntrNo().equals("")) {
					String cntrNo = searchMovementListByMultiContainerVO.getCntrNo();
					List<String> cntrNoList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(cntrNo, ",");
					while (st.hasMoreTokens()) {
						cntrNoList.add(st.nextToken());
					}
					velParam.put("cntr_no_list", cntrNoList);

					if (searchMovementListByMultiContainerVO.getCntrNo().length() > 11) {
						velParam.put("check_digit", "");
						velParam.put("p_cntrno", "");
					}
				}

				// Multi container type/size list 변경
				if (!searchMovementListByMultiContainerVO.getCntrTpszCd().equals("")) {
					String tpSz = searchMovementListByMultiContainerVO.getCntrTpszCd();
					List<String> cntrTpSzList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(tpSz, ",");
					while (st.hasMoreTokens()) {
						cntrTpSzList.add(st.nextToken());
					}
					velParam.put("cntr_tpsz_cd_list", cntrTpSzList);
				}

				// Multi movement status list 변경
				if (!searchMovementListByMultiContainerVO.getMvmtStsCd().equals("")) {
					String status = searchMovementListByMultiContainerVO.getMvmtStsCd();
					List<String> statusList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(status, ",");
					while (st.hasMoreTokens()) {
						statusList.add(st.nextToken());
					}
					velParam.put("mvmt_sts_cd_list", statusList);
				}

				// Multi LCC list 변경
				if (!searchMovementListByMultiContainerVO.getLccCd().equals("")) {
					String lccCd = searchMovementListByMultiContainerVO.getLccCd();
					List<String> lccCdList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(lccCd, ",");
					while (st.hasMoreTokens()) {
						lccCdList.add(st.nextToken());
					}
					velParam.put("lcc_cd_list", lccCdList);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchMovementListByMultiContainerRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementListByMultiContainerVO.class);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}
	
	/**
	 * Movement Correction Monitoring LIST 조회<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO 
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMovementHistoryMonitorListVO> containerMovementHistoryMonitorList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchMovementHistoryMonitorListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchMovementHistoryMonitorListVO != null){
				Map<String, String> mapVO = searchMovementHistoryMonitorListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContionerMovementFinderDBDAOSearchMovementHistoryMonitorListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementHistoryMonitorListVO.class);
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
	 * RHQ Office정보를 조회한다<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMovementHistoryMonitorListVO> getRhqOfficeList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchMovementHistoryMonitorListVO> list = null;
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOgetRhqOfficeListRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementHistoryMonitorListVO.class);
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
	 * RHQ Level에 따른 Office 목록을 조회.<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMovementHistoryMonitorListVO> getOfficeByRhqLevelList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchMovementHistoryMonitorListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchMovementHistoryMonitorListVO != null){
				Map<String, String> mapVO = searchMovementHistoryMonitorListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOgetOfficeByRhqLevelListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementHistoryMonitorListVO.class);
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
	 * 컨테이너 번호에 의한 Correction History LIST 조회
	 * @param searchCorrectionHistoryVO
	 * @return List<SearchCorrectionHistoryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCorrectionHistoryVO> searchCorrectionHistory(SearchCorrectionHistoryVO searchCorrectionHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCorrectionHistoryVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (searchCorrectionHistoryVO != null) {
				Map<String, String> mapVO = searchCorrectionHistoryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				// IN 조건을 위한 부분
				if (!searchCorrectionHistoryVO.getCntrNo().equals("")) {
					String cntrNo = searchCorrectionHistoryVO.getCntrNo();
					List<String> cntrNoList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(cntrNo, ",");
					while (st.hasMoreTokens()) {
						cntrNoList.add(st.nextToken());
					}
					velParam.put("cntr_no_list", cntrNoList);
					if (searchCorrectionHistoryVO.getCntrNo().length() > 11) {
						velParam.put("check_digit", "");
						velParam.put("p_cntrno", "");
					}

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchCorrectionHistoryRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCorrectionHistoryVO.class);
				}
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
	 * Movement Correction Monitoring Summary Yard 조회<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO 
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMovementHistoryMonitorListVO> movementCorrctionMonitorList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchMovementHistoryMonitorListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchMovementHistoryMonitorListVO != null){
				Map<String, String> mapVO = searchMovementHistoryMonitorListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchMovementCorrectionMonitoringSummaryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementHistoryMonitorListVO.class);
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
	 * Movement Correction Monitoring Summary Lcc 조회<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO 
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMovementHistoryMonitorListVO> movementCorrctionMonitorLccList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchMovementHistoryMonitorListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchMovementHistoryMonitorListVO != null){
				Map<String, String> mapVO = searchMovementHistoryMonitorListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchMovementCorrectionMonitoringSummaryLccRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementHistoryMonitorListVO.class);
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
	 * Movement Correction Monitoring Summary Rcc 조회<br>
	 *
	 * @param SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO 
	 * @return List<SearchMovementHistoryMonitorListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchMovementHistoryMonitorListVO> movementCorrctionMonitorRccList(SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchMovementHistoryMonitorListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchMovementHistoryMonitorListVO != null){
				Map<String, String> mapVO = searchMovementHistoryMonitorListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchMovementCorrectionMonitoringSummaryRccRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementHistoryMonitorListVO.class);
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
	 * Inbound vermas EDI 수신 데이터 조회.
	 * @param searchVermasListVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchVermasListVO> searchVermasList(SearchVermasListVO searchVermasListVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();    // query parameter.
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter.
		List<SearchVermasListVO> list = null;

		try {
			if (searchVermasListVO != null) {
				param.putAll(searchVermasListVO.getColumnValues());
				velParam.putAll(searchVermasListVO.getColumnValues());

				// Multi Container list
				if (!searchVermasListVO.getCntrNo().equals("")) {
					String cntrNo = searchVermasListVO.getCntrNo();
					List<String> cntrNoList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(cntrNo, ",");
					while (st.hasMoreTokens()) {
						cntrNoList.add(st.nextToken());
					}
					velParam.put("cntr_no_list", cntrNoList);

					if (searchVermasListVO.getCntrNo().length() > 11) {
						velParam.put("check_digit", "");
						velParam.put("p_cntrno", "");
					}
				}

				// Multi Booking list
				if (!searchVermasListVO.getBkgNo().equals("")) {
					String bkgNo = searchVermasListVO.getBkgNo();
					List<String> bkgNoList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(bkgNo, ",");
					while (st.hasMoreTokens()) {
						bkgNoList.add(st.nextToken());
					}
					velParam.put("bkg_no_list", bkgNoList);
				}

				// Multi LCC list 변경
				if (!searchVermasListVO.getLccCd().equals("")) {
					String lccCd = searchVermasListVO.getLccCd();
					List<String> lccCdList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(lccCd, ",");
					while (st.hasMoreTokens()) {
						lccCdList.add(st.nextToken());
					}
					velParam.put("lcc_cd_list", lccCdList);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchVermasListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVermasListVO.class);
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
	 * EDI Error 데이터 조회.
	 * @param searchMovementListByMultiContainerVO
	 * @return List<SearchEDIMovementListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchEDIMovementListVO> searchMovementErrorListByMultiContainer(SearchMovementListByMultiContainerVO searchMovementListByMultiContainerVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter
		List<SearchEDIMovementListVO> list = null;

		try {
			if (searchMovementListByMultiContainerVO != null) {
				if (!searchMovementListByMultiContainerVO.getCntrNo().equals("")) {
					searchMovementListByMultiContainerVO.setRccCd("");
				}

				Map<String, String> mapVO = searchMovementListByMultiContainerVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				// Multi container list 변경
				if (!searchMovementListByMultiContainerVO.getCntrNo().equals("")) {
					String cntrNo = searchMovementListByMultiContainerVO.getCntrNo();
					List<String> cntrNoList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(cntrNo, ",");
					while (st.hasMoreTokens()) {
						cntrNoList.add(st.nextToken());
					}
					velParam.put("cntr_no_list", cntrNoList);

					if (searchMovementListByMultiContainerVO.getCntrNo().length() > 11) {
						velParam.put("check_digit", "");
						velParam.put("p_cntrno", "");
					}
				}

				// Multi container type/size list 변경
				if (!searchMovementListByMultiContainerVO.getCntrTpszCd().equals("")) {
					String tpSz = searchMovementListByMultiContainerVO.getCntrTpszCd();
					List<String> cntrTpSzList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(tpSz, ",");
					while (st.hasMoreTokens()) {
						cntrTpSzList.add(st.nextToken());
					}
					velParam.put("cntr_tpsz_cd_list", cntrTpSzList);
				}

				// Multi movement status list 변경
				if (!searchMovementListByMultiContainerVO.getMvmtStsCd().equals("")) {
					String status = searchMovementListByMultiContainerVO.getMvmtStsCd();
					List<String> statusList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(status, ",");
					while (st.hasMoreTokens()) {
						statusList.add(st.nextToken());
					}
					velParam.put("mvmt_sts_cd_list", statusList);
				}

				// Multi LCC list 변경
				if (!searchMovementListByMultiContainerVO.getLccCd().equals("")) {
					String lccCd = searchMovementListByMultiContainerVO.getLccCd();
					List<String> lccCdList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(lccCd, ",");
					while (st.hasMoreTokens()) {
						lccCdList.add(st.nextToken());
					}
					velParam.put("lcc_cd_list", lccCdList);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchMovementErrorListByMultiContainerRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEDIMovementListVO.class);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}
}
