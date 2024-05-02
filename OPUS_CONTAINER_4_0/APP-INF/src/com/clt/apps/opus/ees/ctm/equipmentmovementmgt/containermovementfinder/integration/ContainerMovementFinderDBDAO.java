/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementFinderDBDAO.java
*@FileTitle : BKG container update Irr.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.29 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.basic.ContainerMovementFinderBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.ConCBookingVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmCCLMVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmMvmtIrrVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmVvdHistoryVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchAllBKGVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchAllEQRRefVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchAllVVDByBKGVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchDeletedMVMTListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEdiMsgVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEmptyBookingListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByBkgInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByCntrInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByCntrTpszCdVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByEqrRefInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListBySplitBkgNoForMultiComboVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByVvdForMultiComboVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchWoNoByEqrRefInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.searchMovementHistoryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS ContainerMovementFinderDBDAO <br>
 * - OPUS-EquipmentMovementMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	 * 컨테이너 번호에 의한 Each Container LIST 조회<br>
	 *
	 * @param SearchMovementListByContainerVO searchMovementListByContainerVO
	 * @return List<SearchMovementListByContainerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMovementListByContainerVO> searchMovementListByContainer(SearchMovementListByContainerVO searchMovementListByContainerVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMovementListByContainerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMovementListByContainerVO != null){
				Map<String, String> mapVO = searchMovementListByContainerVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchMovementListByContainerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementListByContainerVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/** searchOSCARCtmCycNo
	 *  
	 * @param searchDeletedMVMTListVO
	 * @return  List<SearchDeletedMVMTListVO>
	 * @throws DAOException
	 */
	public List<SearchDeletedMVMTListVO> searchOSCARCtmCycNo(SearchDeletedMVMTListVO searchDeletedMVMTListVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchOSCARCtmCycNoRSQL(), param, velParam);
			
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

	/** searchOPUSBKGwithCycNo
	 *  
	 * @param searchDeletedMVMTListVO
	 * @return  String
	 * @throws DAOException
	 */
	public String searchOPUSBKGwithCycNo(SearchDeletedMVMTListVO searchDeletedMVMTListVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";

		try{
			if(searchDeletedMVMTListVO != null){
				Map<String, String> mapVO = searchDeletedMVMTListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchOPUSBKGwithCycNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("BKG_NO");
			} else {
				rtnValue = "N";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}

	/** searchAllVVDByBKG
	 *  
	 * @param searchAllVVDByBKGVO
	 * @return  List<SearchAllVVDByBKGVO>
	 * @throws DAOException
	 */
	public List<SearchAllVVDByBKGVO> searchAllVVDByBKG(SearchAllVVDByBKGVO searchAllVVDByBKGVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAllVVDByBKGVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchAllVVDByBKGVO != null){
				Map<String, String> mapVO = searchAllVVDByBKGVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchAllVVDByBKGRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAllVVDByBKGVO.class);
			
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
		 * MTY_PLN_NO로 EQR Ref No Information 조회<br>
		 *
		 * @param String mtyPlnNo
		 * @return List<SearchMovementListByBkgInfoVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchMovementListByEqrRefInfoVO> searchMovementListByEqrRefInfo(String mtyPlnNo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchMovementListByEqrRefInfoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("mty_pln_no", mtyPlnNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchMovementListByEqrRefInfoVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementListByEqrRefInfoVO.class);
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
			 * MTY_PLN_NO로 Wo No 조회<br>
			 *
			 * @param String mtyPlnNo
			 * @return List<SearchWoNoByEqrRefInfoVO>
			 * @throws DAOException
			 */
			 @SuppressWarnings("unchecked")
			public List<SearchWoNoByEqrRefInfoVO> searchWoNoByEqrRefInfo(String mtyPlnNo) throws DAOException {
				DBRowSet dbRowset = null;
				List<SearchWoNoByEqrRefInfoVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					Map<String, String> mapVO = new HashMap<String, String>();
					mapVO.put("mty_pln_no", mtyPlnNo);

					param.putAll(mapVO);
					velParam.putAll(mapVO);
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchWoNoByEqrRefInfoRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchWoNoByEqrRefInfoVO.class);
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
	 * MTY_PLN_NO로 CNTR_TPSZ 조회<br>
	 *
	 * @param String mtyPlnNo
	 * @return List<SearchMovementListByCntrTpszCdVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMovementListByCntrTpszCdVO> searchCntrTpszCdByEqrRef(String mtyPlnNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMovementListByCntrTpszCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("mty_pln_no", mtyPlnNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchCntrTpszCdByEqrRefRSQL(), param, velParam);
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
	 * BKG_NO로 SHEET용 Container Information LIST 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<SearchMovementListByCntrInfoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMovementListByCntrInfoVO> searchMovementListByCntrInfo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMovementListByCntrInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchMovementListByCntrInfoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementListByCntrInfoVO.class);
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
	 * MTY_PLN_NO로 SHEET용 Container Information LIST 조회<br>
	 *
	 * @param String mtyPlnNo
	 * @return List<SearchMovementListByCntrInfoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMovementListByCntrInfoVO> searchCntrInfoByEqrRef(String mtyPlnNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMovementListByCntrInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("mty_pln_no", mtyPlnNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchCntrInfoByEqrRefRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementListByCntrInfoVO.class);
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
	 * retrieving All Booking
	 *
	 * @param SearchAllBKGVO searchAllBKGVO
	 * @return List<SearchAllBKGVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchAllBKGVO> searchAllBKG(SearchAllBKGVO searchAllBKGVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAllBKGVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchAllBKGVO != null){
				Map<String, String> mapVO = searchAllBKGVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOSearchAllBKGRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAllBKGVO.class);
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
		 * retrieving All EQR Reference
		 *
		 * @param SearchAllEQRRefVO searchAllEQRRefVO
		 * @return List<SearchAllEQRRefVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchAllEQRRefVO> searchAllEQRRef(SearchAllEQRRefVO searchAllEQRRefVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchAllEQRRefVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchAllEQRRefVO != null){
					Map<String, String> mapVO = searchAllEQRRefVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOsearchAllEQRRefRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAllEQRRefVO.class);
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
	 * 컨테이너의 이동정보 상세 내역을 얻어온다.<br>
	 *
	 * @param CtmVvdHistoryVO ctmVvdHistoryVO
	 * @return List<searchMovementHistoryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<searchMovementHistoryVO> searchMvmtHistory(CtmVvdHistoryVO ctmVvdHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<searchMovementHistoryVO> list = null;
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
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementFinderDBDAOsearchMovementHistoryRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, searchMovementHistoryVO.class);
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

}
