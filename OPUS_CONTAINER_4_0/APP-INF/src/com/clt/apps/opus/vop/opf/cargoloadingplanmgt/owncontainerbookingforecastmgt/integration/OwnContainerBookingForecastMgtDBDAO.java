/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OwnContainerBookingForecastMgtDBDAO.java
 *@FileTitle : Weight Group (Creation)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.11
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.05.11 우지석
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic.OwnContainerBookingForecastMgtBCImpl;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSpecialStwgVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSummaryVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CargoBookingForecastVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.PodComboVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.VskVslPortSkdCustVO;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration.SpecialCargoIrregularMgtDBDAOVskCarrierVORSQL;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.OpfCgoBkgFcastWgtGrpVO;
import com.clt.syscommon.common.table.VskCarrierVO;



/**
 * OPUS OwnContainerBookingForecastMgtDBDAO <br>
 * - OPUS-CargoLoadingPlanMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Ji Seok Woo
 * @see OwnContainerBookingForecastMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class OwnContainerBookingForecastMgtDBDAO extends DBDAOSupport {

	/**
	 * Pol 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchPol(String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] arrPol = null;
		try {
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchPolRSQL(), param, velParam);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrPol = new String[dbRowset.getRowCount()];
				}
				arrPol[i] = dbRowset.getString(1);
				i++;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrPol;
	}

	/**
	 * OPR list 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchOpr(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] arrOpr = null;
		try {
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("yd_cd", ydCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchOprCdRSQL(), param, velParam);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrOpr = new String[dbRowset.getRowCount()];
				}
				arrOpr[i] = dbRowset.getString(1);
				i++;
			}
			if (arrOpr == null) {
				log.debug("searchOpr if (arrOpr == null) ");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrOpr;
	}

	/**
	 * POD list 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchPodbyVvd(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] arrPod = null;
		try {
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("yd_cd", ydCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOPodComboRSQL(),	param, velParam);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrPod = new String[dbRowset.getRowCount()];
				}
				arrPod[i] = dbRowset.getString(1);
				i++;
			}
			if (arrPod == null) {
				log.debug("searchPodbyVvd if (arrPod == null) ");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrPod;
	}

	/**
	 * MLB list 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchMlb(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] arrMlb = null;
		try {
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("yd_cd", ydCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchMlbCdRSQL(), param, velParam);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrMlb = new String[dbRowset.getRowCount()];
				}
				arrMlb[i] = dbRowset.getString(1);
				i++;
			}
			if (arrMlb == null) {
				log.debug("searchMlb if (arrMlb == null) ");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrMlb;
	}
	
	/**
	 * LOC 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchLocInfo(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] arrLoc = new String[5];
		try {
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("yd_cd", ydCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchLocInfoRSQL(), param, velParam);
			int k = 2;
			if (dbRowset.next()) {
				for (int i = 0; i < 3; i++) {
					arrLoc[i] = dbRowset.getString(k);
					k++;
				}
			}
			if (arrLoc == null) {
				throw new DAOException(new ErrorHandler("OPF00021").getUserMessage());
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrLoc;
	}

	/**
	 * CBF Booking Status 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchCBFBS(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] arrCbf = new String[5];
		try {
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("yd_cd", ydCd);

//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchCBFBSRSQL(), param, velParam);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchCBFBSRSQL(), param, velParam);
			int k = 1;
			if (dbRowset.next()) {
				for (int i = 0; i < 4; i++) {
					arrCbf[i] = dbRowset.getString(k);
					k++;
				}
			}
			if (arrCbf == null) {
				throw new DAOException(new ErrorHandler("OPF00021").getUserMessage());
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrCbf;
	}


	/**
	 * Weight Group List 정보를 조회합니다. <br>
	 * 
	 * @param CargoBookingForecastVO cargoBookingForecastVO
	 * @return List<CargoBookingForecastVO>
	 * @throws DAOException
	 */
	public List<CargoBookingForecastVO> searchWeightGRPList(CargoBookingForecastVO cargoBookingForecastVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CargoBookingForecastVO> cargoBookingForecastVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cargoBookingForecastVO != null) {
				Map<String, String> mapVO = cargoBookingForecastVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCargoBookingForecastVORSQL(), param, velParam);
			cargoBookingForecastVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CargoBookingForecastVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cargoBookingForecastVOs;
	}

	/**
	 * CBF Volume List 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return List<CBFListOptionVO> 
	 * @throws DAOException
	 */
	public List<CBFListOptionVO> searchCBFVolumeList(CBFListOptionVO cbfListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFListOptionVO> cbfListOptionVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfListOptionVO != null) {
				Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchCBFListRSQL(), param, velParam);
			cbfListOptionVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFListOptionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfListOptionVOs;
	}
		
	/**
	 * CBF Special List 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return List<CBFListOptionVO>
	 * @throws DAOException
	 */
	public List<CBFListOptionVO> searchCBFVolumeSpecialList(CBFListOptionVO cbfListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFListOptionVO> cbfListOptionVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfListOptionVO != null) {
				Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchCBFVolumeSpecialListRSQL(), param, velParam);
			cbfListOptionVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFListOptionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfListOptionVOs;
	}

	/**
	 * CBF Inquiry SpecialList 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return List<CBFListOptionVO>
	 * @throws DAOException
	 */
	public List<CBFListOptionVO> searchCBFOwnSpecialList(CBFListOptionVO cbfListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFListOptionVO> cbfListOptionVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfListOptionVO != null) {
				Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchCBFOwnSpecialListRSQL(), param, velParam);
			cbfListOptionVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFListOptionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfListOptionVOs;
	}

	/**
	 * CBF Summary 정보를 조회합니다.<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @throws DAOException
	 */
	public List<CBFSummaryVO> calCBFSummary(CBFSummaryVO cbfSummaryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFSummaryVO>  list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (cbfSummaryVO != null) {
				Map<String, String> mapVO = cbfSummaryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOCBFSummaryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CBFSummaryVO.class);
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
	 * CBF Special List 정보를 조회합니다.<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @throws DAOException
	 */
	public List<CBFSummaryVO> searchCBFSpecialList(CBFSummaryVO cbfSummaryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFSummaryVO>  list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfSummaryVO != null) {
				Map<String, String> mapVO = cbfSummaryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOsearchCBFSpecialListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CBFSummaryVO.class);
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
	 * CBF Special Stwg 정보를 조회합니다.<br>
	 * 
	 * @param CBFSpecialStwgVO cbfSpecialStwgVO
	 * @return List<CBFSpecialStwgVO>
	 * @throws DAOException
	 */
	public List<CBFSpecialStwgVO> searchCBFSpecialStwg(CBFSpecialStwgVO cbfSpecialStwgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFSpecialStwgVO>  list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfSpecialStwgVO != null) {
				Map<String, String> mapVO = cbfSpecialStwgVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOsearchCBFSpecialStwgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CBFSpecialStwgVO.class);
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
	 * CBF Summary 정보를 조회합니다.<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @throws DAOException
	 */
	public List<CBFSummaryVO> calCBFInquirySummary(CBFSummaryVO cbfSummaryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFSummaryVO>  list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfSummaryVO != null) {
				Map<String, String> mapVO = cbfSummaryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOCBFInquirySummaryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CBFSummaryVO.class);
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
	 * CBF Special Stwg 정보를 조회합니다.<br>
	 * 
	 * @param CBFSpecialStwgVO cbfSpecialStwgVO
	 * @return List<CBFSpecialStwgVO>
	 * @throws DAOException
	 */
	public List<CBFSpecialStwgVO> searchCBFSpecialStwgPreview(CBFSpecialStwgVO cbfSpecialStwgVO)	throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFSpecialStwgVO>  list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfSpecialStwgVO != null) {
				Map<String, String> mapVO = cbfSpecialStwgVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOsearchCBFSpecialStwgPreviewRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CBFSpecialStwgVO.class);
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
	 * CBF Special List 정보를 조회합니다.<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @throws DAOException
	 */
	public List<CBFSummaryVO> searchCBFInquirySpecialList(CBFSummaryVO cbfSummaryVO)	throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFSummaryVO>  list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfSummaryVO != null) {
				Map<String, String> mapVO = cbfSummaryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOsearchCBFInquirySpecialListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CBFSummaryVO.class);
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
	 * CBF BKG Volume List 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return List<CBFListOptionVO>
	 * @throws DAOException
	 */
	public List<CBFListOptionVO> searchCBFBKGVolumeList(CBFListOptionVO cbfListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<CBFListOptionVO> cbfListOptionVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (cbfListOptionVO != null) {
				Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchCBFBKGListRSQL(), param, velParam);
			cbfListOptionVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFListOptionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfListOptionVOs;
	}

	/**
	 * CBF BKG Special List 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return List<CBFListOptionVO>
	 * @throws DAOException
	 */
	public List<CBFListOptionVO> searchCBFBKGSpecialList(CBFListOptionVO cbfListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<CBFListOptionVO> cbfListOptionVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (cbfListOptionVO != null) {
				Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchCBFBKGSpecialListRSQL(), param, velParam);
			cbfListOptionVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFListOptionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfListOptionVOs;
	}

	/**
	 * BKG VVD 정보를 확인합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return vslCdCnt
	 * @throws DAOException
	 */
	public int checkBKGVVD(CBFListOptionVO cbfListOptionVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int vslCdCnt = 0;
		try {

			if (cbfListOptionVO != null) {
				Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOcheckBKGVVDRSQL(), param, velParam);
			if (dbRowset.next()) {
				vslCdCnt = dbRowset.getInt("VslCdCnt");
			} else {
				vslCdCnt = 0;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslCdCnt;
	}

	/**
	 * CBF Save 정보를 확인합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkCBFSave(CBFListOptionVO cBFListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cbfCount = 0;
		try {
			Map<String, String> mapVO = cBFListOptionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOcheckCBFSaveRSQL(),	param, velParam);
			if (dbRowset.next()) {
				cbfCount = dbRowset.getInt("CBFCOUNT");
			} else {
				cbfCount = 0;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfCount;
	}

	/**
	 * CBF 정보를 삭제합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return int
	 * @throws DAOException
	 */
	public int removeCBFList(CBFListOptionVO cBFListOptionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			
			Map<String, String> mapVO = cBFListOptionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//Subs Risk 삭제
			result = sqlExe.executeUpdate((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOOpfCbfCntrImdgSubsRskDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			
			//Forecast Container 삭제 
			result = sqlExe.executeUpdate((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastCntrDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			
			//Forecast 삭제
			result = sqlExe.executeUpdate((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");			
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
    /**
     * TURNING PORT SKIP CALL 정보를 확인합니다.<br>
     * 
     * @param CBFListOptionVO cbfListOptionVO
     * @return VskVslPortSkdCustVO
     * @throws DAOException
     */
	public VskVslPortSkdCustVO checkTurningPortSkipCall(CBFListOptionVO cbfListOptionVO) throws DAOException {
    	DBRowSet dbRowset = null;
    	List<VskVslPortSkdCustVO> list = null;
    	VskVslPortSkdCustVO vskVslPortSkdCustVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

        try {
			if (cbfListOptionVO != null) {
				Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOcheckTurningPortSkipCallRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdCustVO .class);        	
        	
			if(list != null && list.size() > 0){
				vskVslPortSkdCustVO = (VskVslPortSkdCustVO) list.get(0);
			}			
        } catch(SQLException se) {
            //log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return vskVslPortSkdCustVO;
    }    	
	
	/**
	 * Weight Group 정보를 조회합니다.<br>
	 * 
	 * @param OpfCgoBkgFcastWgtGrpVO opfCgoBkgFcastWgtGrpVO
	 * @return opfCgoBkgFcastWgtGrpVOs.size
	 * @throws DAOException
	 */
	public int searchWeightGRP(OpfCgoBkgFcastWgtGrpVO opfCgoBkgFcastWgtGrpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfCgoBkgFcastWgtGrpVO> opfCgoBkgFcastWgtGrpVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (opfCgoBkgFcastWgtGrpVO != null) {
				Map<String, String> mapVO = opfCgoBkgFcastWgtGrpVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVORSQL(), param, velParam);
			opfCgoBkgFcastWgtGrpVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, OpfCgoBkgFcastWgtGrpVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return opfCgoBkgFcastWgtGrpVOs.size();
	}

	/**
	 * Weight Group 정보를 생성합니다.<br>
	 * 
	 * @param OpfCgoBkgFcastWgtGrpVO opfCgoBkgFcastWgtGrpVO
	 * @throws DAOException
	 */
	public void addWeightGRP(OpfCgoBkgFcastWgtGrpVO opfCgoBkgFcastWgtGrpVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = opfCgoBkgFcastWgtGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Weight Group 정보를 수정합니다. <br>
	 * 
	 * @param OpfCgoBkgFcastWgtGrpVO opfCgoBkgFcastWgtGrpVO
	 * @return result
	 * @exception DAOException
	 */	
	public int modifyWeightGRP(OpfCgoBkgFcastWgtGrpVO opfCgoBkgFcastWgtGrpVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = opfCgoBkgFcastWgtGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Weight Group 정보를 삭제합니다.<br>
	 * 
	 * @param OpfCgoBkgFcastWgtGrpVO opfCgoBkgFcastWgtGrpVO
	 * @return result
	 * @throws DAOException
	 */
	public int removeWeightGRP(OpfCgoBkgFcastWgtGrpVO opfCgoBkgFcastWgtGrpVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = opfCgoBkgFcastWgtGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Weight Group List 정보를 생성합니다. <br>
	 * 
	 * @param List<OpfCgoBkgFcastWgtGrpVO> opfCgoBkgFcastWgtGrpVOs
	 * @throws DAOException
	 */
	public void addWeightGRPList(List<OpfCgoBkgFcastWgtGrpVO> opfCgoBkgFcastWgtGrpVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (opfCgoBkgFcastWgtGrpVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVOCSQL(), opfCgoBkgFcastWgtGrpVOs, null);
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
	 * Weight Group List 정보를 수정합니다. <br>
	 * 
	 * @param List<OpfCgoBkgFcastWgtGrpVO> opfCgoBkgFcastWgtGrpVOs
	 * @throws DAOException
	 */
	public void modifyWeightGRPList(List<OpfCgoBkgFcastWgtGrpVO> opfCgoBkgFcastWgtGrpVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (opfCgoBkgFcastWgtGrpVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVOUSQL(), opfCgoBkgFcastWgtGrpVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
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
	 * Weight Group List 정보를 삭제합니다. <br>
	 * 
	 * @param List<OpfCgoBkgFcastWgtGrpVO> opfCgoBkgFcastWgtGrpVOs
	 * @throws DAOException
	 */
	public void removeWeightGRPList(List<OpfCgoBkgFcastWgtGrpVO> opfCgoBkgFcastWgtGrpVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (opfCgoBkgFcastWgtGrpVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVODSQL(), opfCgoBkgFcastWgtGrpVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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
	 * OwnCBFList 정보를 생성합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @param List<CBFListOptionVO> cBFListOptionVOs
	 * @throws DAOException
	 */
	public void addOwnCBFList(CBFListOptionVO cBFListOptionVO, List<CBFListOptionVO> cBFListOptionVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int insCnt[] = null;
			if(cBFListOptionVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOsearchCBFListCSQL(), cBFListOptionVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
			List<CBFListOptionVO> insertSubRVoList = cBFListOptionVO.getCBFListOptionVOS();
			if(insertSubRVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOOpfCbfCntrImdgSubsRskCSQL(), insertSubRVoList, null);				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CBFSRL 정보를 생성합니다.<br>
	 * 
	 * @param List<CBFListOptionVO> cbfListOptionVOs
	 * @throws DAOException
	 */
	public void addCBFSRL(List<CBFListOptionVO> cbfListOptionVOs) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			log.debug("::CALL::> addCBFSRL >:::::::::"+cbfListOptionVOs.size());
			CBFListOptionVO cbfListOptionVO = new CBFListOptionVO();
			
			if (cbfListOptionVOs.size() > 0) {

				for(int i=0; i<cbfListOptionVOs.size(); i++){
					cbfListOptionVO =  cbfListOptionVOs.get(i);
					
					Map<String, String> mapVO = cbfListOptionVO.getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);

					if(!(cbfListOptionVO.getBkgNo() == null || cbfListOptionVO.getBkgNo().equals(""))) {						
						int trd_result = sqlExe.executeUpdate((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOOpfCbfCntrImdgSubsRskCSQL(), param, velParam);
						if(trd_result == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to insert SQL");
						}						
					}
				}
			}
		} catch (SQLException se) {
			log.debug("addOwnCBFList SQLException ");
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.debug("addOwnCBFList Exception ");
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CgoBkgFcast 정보를 수정합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @throws DAOException
	 */
	public void addOpfCgoBkgFcast(CBFListOptionVO cbfListOptionVO) throws DAOException,	Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcast1CSQL(), param, velParam);
			
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * OwnCBFList 정보를 수정합니다.<br>
	 * 
	 * @param List<CBFListOptionVO> cbfListOptionVOs
	 * @throws DAOException
	 */
	public void modifyOwnCBFList(List<CBFListOptionVO> cbfListOptionVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cbfListOptionVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchCBFListUSQL(), cbfListOptionVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
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
	 * OpfCgoBkgFcast 정보를 수정합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @throws DAOException
	 */
	public void modifyOpfCgoBkgFcast(CBFListOptionVO cbfListOptionVO) throws DAOException,	Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * OpfCgoBkgFcast 정보를 삭제합니다.<br>
	 * 
	 * @param List<CBFListOptionVO> cbfListOptionVOs
	 * @throws DAOException
	 */
	public void removeOwnCBFList(List<CBFListOptionVO> cbfListOptionVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (cbfListOptionVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchCBFListDSQL(), cbfListOptionVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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
	 * CBF - Volume/Weight(Inquiry) OprPodMlbComboList 정보를 조회합니다.<br>
     * 
	 * @return List<VskCarrierVO>
	 * @throws DAOException
	 */
	public List<VskCarrierVO> searchOprPodMlbComboList() throws DAOException {
		DBRowSet dbRowset = null;
		List<VskCarrierVO> vskCarrierVOs = null;

		try{
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("crr_cd", "vsl_opr_tp_cd");
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOVskCarrierVORSQL(), null, velParam);
			vskCarrierVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, VskCarrierVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vskCarrierVOs;
	}

	/**
	 * CBF - Volume/Weight(Inquiry) CBFSummaryPreviewHeaderList 정보를 조회합니다.<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @throws DAOException
	 */
	 public List<CBFSummaryVO> searchCBFSummaryPreviewHeaderList(CBFSummaryVO cbfSummaryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFSummaryVO> cbfSummaryVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cbfSummaryVO != null){
				Map<String, String> mapVO = cbfSummaryVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOsearchCBFSummaryPreviewHeaderListRSQL(), param, velParam);
			cbfSummaryVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CBFSummaryVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfSummaryVOs;
	}

	/**
	 * CBF - Volume/Weight(Inquiry) CBFSummaryPreviewStwgCd 정보를 조회합니다.<br>
	 * 
	 * @param CBFSummaryVO cbfSummaryVO
	 * @return List<CBFSummaryVO>
	 * @throws DAOException
	 */
	 public List<CBFSummaryVO> searchCBFSummaryPreviewStwgCdList(CBFSummaryVO cbfSummaryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFSummaryVO> cbfSummaryVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cbfSummaryVO != null){
				Map<String, String> mapVO = cbfSummaryVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOsearchCBFSummaryPreviewSTWGCDListRSQL(), param, velParam);
			cbfSummaryVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CBFSummaryVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfSummaryVOs;
	}
	 
	/**
	 * PartnerCBFList 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return List<CBFListOptionVO>
	 * @throws DAOException
	 */
	public List<CBFListOptionVO> searchPartnerCBFList(CBFListOptionVO cbfListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFListOptionVO> cbfListOptionVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfListOptionVO != null) {
				Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFListOptionVORSQL(), param, velParam);
			cbfListOptionVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFListOptionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfListOptionVOs;
	}

	/**
	 * PartnerCBFSpecialList 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return List<CBFListOptionVO>
	 * @throws DAOException
	 */
	public List<CBFListOptionVO> searchPartnerCBFSpecialList(CBFListOptionVO cbfListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFListOptionVO> cbfListOptionVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfListOptionVO != null) {
				Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchPartnerCBFSpecialListRSQL(), param, velParam);
			cbfListOptionVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFListOptionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfListOptionVOs;
	}

	/**
	 * Tp 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @throws DAOException
	 */
	public List<PodComboVO> searchTp(PodComboVO podComboVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PodComboVO> podComboVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (podComboVO != null) {
				Map<String, String> mapVO = podComboVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOTpComboRSQL(), param, velParam);
			podComboVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, PodComboVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return podComboVOs;
	}

	/**
	 * WGP 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSingleWgp(PodComboVO podComboVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sWGP = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (podComboVO != null) {
				Map<String, String> mapVO = podComboVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchWGPRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				sWGP = dbRowset.getString("wgt_grp_cd_desc");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sWGP;
	}

	/**
	 * FM 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @throws DAOException
	 */
	public List<PodComboVO> searchFm(PodComboVO podComboVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PodComboVO> podComboVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (podComboVO != null) {
				Map<String, String> mapVO = podComboVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOFmComboRSQL(),	param, velParam);
			podComboVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, PodComboVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return podComboVOs;
	}

	/**
	 * CGO 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @throws DAOException
	 */
	public List<PodComboVO> searchCgo(PodComboVO podComboVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PodComboVO> podComboVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (podComboVO != null) {
				Map<String, String> mapVO = podComboVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCgoComboRSQL(), param, velParam);
			podComboVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, PodComboVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return podComboVOs;
	}

	/**
	 * IMO 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @throws DAOException
	 */
	public List<PodComboVO> searchImo(PodComboVO podComboVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PodComboVO> podComboVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (podComboVO != null) {
				Map<String, String> mapVO = podComboVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOImoComboRSQL(), param, velParam);
			podComboVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, PodComboVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return podComboVOs;
	}

	/**
	 * PostExtd 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @throws DAOException
	 */
	public List<PodComboVO> searchPostExtd(PodComboVO podComboVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PodComboVO> podComboVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (podComboVO != null) {
				Map<String, String> mapVO = podComboVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOPostExtdComboRSQL(),	param, velParam);
			podComboVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, PodComboVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return podComboVOs;
	}

	/**
	 * STWG 정보를 조회합니다.<br>
	 * 
	 * @param PodComboVO podComboVO
	 * @return List<PodComboVO>
	 * @throws DAOException
	 */
	public List<PodComboVO> searchStwg(PodComboVO podComboVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PodComboVO> podComboVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (podComboVO != null) {
				Map<String, String> mapVO = podComboVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOStwgComboRSQL(),	param, velParam);
			podComboVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, PodComboVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return podComboVOs;
	}

	/**
	 * OpfCgoBkgFcast 정보를 생성합니다.<br>
	 * 
	 * @param List<CBFListOptionVO> cbfListOptionVOs
	 * @throws DAOException
	 */
	public void addOpfCgoBkgFcast(List<CBFListOptionVO> cbfListOptionVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (cbfListOptionVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOPartnerOpfCgoBkgFcastCSQL(), cbfListOptionVOs, null);
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
	 * Partner CBF 정보를 생성한다.<br>
	 * 
	 * @param List<CBFListOptionVO> cbfListOptionVOs
	 * @exception DAOException
	 */
	public void addPartnerCBFList(List<CBFListOptionVO> cbfListOptionVOs) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			CBFListOptionVO cbfListOptionVO = new CBFListOptionVO();

			if (cbfListOptionVOs.size() > 0) {
				for (int i = 0; i < cbfListOptionVOs.size(); i++) {

					cbfListOptionVO = cbfListOptionVOs.get(i);

					Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					int trd_result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFListOptionVOCSQL(), param, velParam);
					if (trd_result == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert SQL");
					}
					if (!cbfListOptionVO.getImdgSubsRskLblCd().equals("")) {
						int trd_result2 = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOOpfCbfCntrImdgSubsRsk2CSQL(), param, velParam);
						if (trd_result2 == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to insert SQL2");
						}
					}
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
	 * OpfCgoBkgFcast 정보를 수정합니다.<br>
	 * 
	 * @param List<CBFListOptionVO> cbfListOptionVOs
	 * @throws DAOException
	 */
	public void modifyPartnerOpfCgoBkgFcast(List<CBFListOptionVO> cbfListOptionVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cbfListOptionVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOPartnerOpfCgoBkgFcastUSQL(), cbfListOptionVOs, null);

				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
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
	 * PartnerCBFList 정보를 수정합니다.<br>
	 * 
	 * @param List<CBFListOptionVO> cbfListOptionVOs
	 * @throws DAOException
	 */
	public void modifyPartnerCBFList(List<CBFListOptionVO> cbfListOptionVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			CBFListOptionVO cbfListOptionVO = new CBFListOptionVO();
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = 0;
			if (cbfListOptionVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFListOptionVOUSQL(), cbfListOptionVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
				for (int i = 0; i < cbfListOptionVOs.size(); i++) {
					cbfListOptionVO = cbfListOptionVOs.get(i);
					
					Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOOpfCbfCntrImdgSubsRsk2DSQL(), param, velParam);
					if (result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
					
					if (!cbfListOptionVO.getImdgSubsRskLblCd().equals("")) {						
						int trd_result2 = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOOpfCbfCntrImdgSubsRsk2CSQL(), param, velParam);
						if (trd_result2 == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to insert SQL2");
						}
					}
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
	 * PartnerCBFList 정보를 삭제합니다.<br>
	 * 
	 * @param List<CBFListOptionVO> cbfListOptionVOs
	 * @throws DAOException
	 */
	public void removePartnerCBFList(List<CBFListOptionVO> cbfListOptionVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (cbfListOptionVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOOpfCbfCntrImdgSubsRsk2DSQL(), cbfListOptionVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
						
				delCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFListOptionVODSQL(), cbfListOptionVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
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
	 * OpfCgoBkgFcast 정보를 삭제합니다.<br>
	 * 
	 * @param List<CBFListOptionVO> cbfListOptionVOs
	 * @exception DAOException
	 */
	public void removeOpfCgoBkgFcast(List<CBFListOptionVO> cbfListOptionVOs) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			CBFListOptionVO cbfListOptionVO = new CBFListOptionVO();

			if (cbfListOptionVOs.size() > 0) {
				cbfListOptionVO = cbfListOptionVOs.get(0);

				Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOPartnerOpfCgoBkgFcastDSQL(), param, velParam);
				if (result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
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
	 * Partner Line CBF Save 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return int cbfCount
	 * @throws DAOException
	 */
	public int checkPCBFSave(CBFListOptionVO cbfListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		int cbfCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfListOptionVO != null) {
				Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOcheckPCBFSaveRSQL(), param, velParam);
			if (dbRowset.next()) {
				cbfCount = dbRowset.getInt("CBFCOUNT");
			} else {
				cbfCount = 0;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfCount;
	}

	/**
	 * Partner Line CBF Save 정보를 조회합니다.<br>
	 * 
	 * @param CBFListOptionVO cbfListOptionVO
	 * @return int cbfCount
	 * @throws DAOException
	 */
	public int checkPCBFSpecialSave(CBFListOptionVO cbfListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		int cbfCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfListOptionVO != null) {
				Map<String, String> mapVO = cbfListOptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOcheckPCBFSpecialSaveRSQL(), param, velParam);
			if (dbRowset.next()) {
				cbfCount = dbRowset.getInt("CBFCOUNT");
			} else {
				cbfCount = 0;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfCount;
	}

}
