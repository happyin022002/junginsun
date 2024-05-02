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
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic.OwnContainerBookingForecastMgtBCImpl;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFIFSummaryListVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFAllSummaryPreviewVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFIFSummaryDiffListVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSpecialStwgVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSummaryVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CargoBookingForecastVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.VskVslPortSkdCustVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.PodComboVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFPartnerEDIVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.SearchYardCodeVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFPartnerConditionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFWgtGroupSummaryVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration.SpecialCargoIrregularMgtDBDAOVskCarrierVORSQL;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.OpfCgoBkgFcastWgtGrpVO;
import com.hanjin.syscommon.common.table.OpfPrnrEdiCgoBkgFcastVO;
import com.hanjin.syscommon.common.table.OpfPrnrEdiLogVO;
import com.hanjin.syscommon.common.table.VskCarrierVO;

/**
 * NIS2010 OwnContainerBookingForecastMgtDBDAO <br>
 * - NIS2010-CargoLoadingPlanMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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

			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchOprCdRSQL(), param, velParam);
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

			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOPodComboRSQL(),	param, velParam);
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

			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchMlbCdRSQL(), param, velParam);
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
		String[] arrCbf = new String[7];
//		String[] arrCbf = new String[5];
		try {
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("yd_cd", ydCd);

			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchCBFBSRSQL(), param, velParam);
			int k = 1;
			if (dbRowset.next()) {
				for (int i = 0; i < 6; i++) {
//					for (int i = 0; i < 4; i++) {
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
	 * CBF Booking Status 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchCBFHeaderInfo(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] arrCbf = new String[7];
//		String[] arrCbf = new String[5];
		try {
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("yd_cd", ydCd);

			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOSearchCBFHeaderInfoRSQL(), param, velParam);
			log.debug(dbRowset);
			int k = 1;
			if (dbRowset.next()) {
				for (int i = 0; i < 3; i++) {
					log.debug(".getString(k)"+dbRowset.getString(k));
					arrCbf[i] = dbRowset.getString(k);
					k++;
				}
			}
			log.debug("arrCbf"+arrCbf);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCargoBookingForecastVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchCBFListRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchCBFVolumeSpecialListRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchCBFOwnSpecialListRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOCBFSummaryVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOsearchCBFSpecialListRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOsearchCBFSpecialStwgRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOCBFInquirySummaryRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOsearchCBFSpecialStwgPreviewRSQL(), param, velParam);
			
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOsearchCBFInquirySpecialListRSQL(), param, velParam);
			
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

			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOcheckCBFSaveRSQL(),	param, velParam);
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
	 * CBF Header Save 정보를 확인합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkCBFHeaderSave(CBFListOptionVO cBFListOptionVO) throws DAOException {
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
			
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOcheckCBFHeaderSaveRSQL(),	param, velParam);
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
			
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
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
	 * CBF 정보를 삭제합니다.<br>
	 * 
	 * @param CBFListOptionVO cBFListOptionVO
	 * @return int
	 * @throws DAOException
	 */
	public int removeCBFListHeader(CBFListOptionVO cBFListOptionVO) throws DAOException,Exception {
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
			
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVORSQL(), param, velParam);
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

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");

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

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOsearchCBFSummaryPreviewHeaderListRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOsearchCBFSummaryPreviewSTWGCDListRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFListOptionVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchPartnerCBFSpecialListRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOsearchWGPRSQL(), param, velParam);
			
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOFmComboRSQL(),	param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCgoComboRSQL(), param, velParam);
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");

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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");

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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOcheckPCBFSaveRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOcheckPCBFSpecialSaveRSQL(), param, velParam);
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
	 * Carrier Type/Size 정보를 체크합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return String 
	 * @throws DAOException
	 */
	public String checkTypeSize(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String strRet = "";
		try{
			if(cBFIFSummaryListVO != null){
				Map<String, String> mapVO = cBFIFSummaryListVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOSearchCBFCheckTypeSizeRSQL(), param, velParam);
			if(dbRowset.next()){
				strRet = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}
	
	/**
	 * Pod Code 정보를 체크합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return String 
	 * @throws DAOException
	 */
	public String checkTypePodCd(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String strRet = "";
		try{
			if(cBFIFSummaryListVO != null){
				Map<String, String> mapVO = cBFIFSummaryListVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOSearchCBFIFCheckPodCdRSQL(), param, velParam);
			if(dbRowset.next()){
				strRet = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}
	
	/**
	 * KOREA 세관신고CLL과 BOOKING 데이터 비교 정보 가져온다.<br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return String 
	 * @throws DAOException
	 */
	public String checkCllDiff(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String strRet = "";
		try{
			if(cBFIFSummaryListVO != null){
				Map<String, String> mapVO = cBFIFSummaryListVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOIFSummaryIfBkgDiffRSQL(), param, velParam);
			if(dbRowset.next()){
				strRet = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}
	
	/**
	 * PARTNER EDI 수신 전 MANUAL 입력 데이터 존재 여부<br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return String 
	 * @throws DAOException
	 */
	public String checkPartnerEdiExist(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String strRet = "";
		try{
			if(cBFIFSummaryListVO != null){
				Map<String, String> mapVO = cBFIFSummaryListVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerExistCgoRSQL(), param, velParam);
			if(dbRowset.next()){
				strRet = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}
	
	
	/*********************************************************************************************************************************/
	// #.[조회조건]
	/*********************************************************************************************************************************/
	/**
	 * 조회조건 Carrier Combo 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return List<CBFIFSummaryListVO> 
	 * @throws DAOException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFCarrierList(CBFIFSummaryListVO cbfIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFIFSummaryListVO> cbfIFSummaryListVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfIFSummaryListVO != null) {
				Map<String, String> mapVO = cbfIFSummaryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOSearchCBFIFCarrierListRSQL(), param, velParam);
			cbfIFSummaryListVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFIFSummaryListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfIFSummaryListVOs;
	}

	/**
	 * 조회조건 POD Combo 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return List<CBFIFSummaryListVO> 
	 * @throws DAOException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFPodList(CBFIFSummaryListVO cbfIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFIFSummaryListVO> cbfIFSummaryListVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfIFSummaryListVO != null) {
				Map<String, String> mapVO = cbfIFSummaryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOSearchCBFIFPodListRSQL(), param, velParam);
			cbfIFSummaryListVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFIFSummaryListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfIFSummaryListVOs;
	}

	/**
	 * Dg, Awk, Stwg, Rf, Bb, Mty, Bn POD Combo 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return List<CBFIFSummaryListVO> 
	 * @throws DAOException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFOprPodList(CBFIFSummaryListVO cbfIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFIFSummaryListVO> cbfIFSummaryListVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfIFSummaryListVO != null) {
				Map<String, String> mapVO = cbfIFSummaryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOSearchCBFIFOprPodListRSQL(), param, velParam);
			cbfIFSummaryListVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFIFSummaryListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfIFSummaryListVOs;
	}

	/**
	 * Dg - UN NO. Combo 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return List<CBFIFSummaryListVO> 
	 * @throws DAOException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFDgUnNoList(CBFIFSummaryListVO cbfIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFIFSummaryListVO> cbfIFSummaryListVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfIFSummaryListVO != null) {
				Map<String, String> mapVO = cbfIFSummaryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOSearchCBFIFDgUnNoListRSQL(), param, velParam);
			cbfIFSummaryListVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFIFSummaryListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfIFSummaryListVOs;
	}

	/**
	 * Special STWG Combo 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return List<CBFIFSummaryListVO> 
	 * @throws DAOException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFSTWGList(CBFIFSummaryListVO cbfIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFIFSummaryListVO> cbfIFSummaryListVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfIFSummaryListVO != null) {
				Map<String, String> mapVO = cbfIFSummaryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOSearchCBFIFSTWGCdListRSQL(), param, velParam);
			cbfIFSummaryListVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFIFSummaryListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfIFSummaryListVOs;
	}

	/**
	 * Weight 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCgoGrsWgt(CBFIFSummaryListVO cbfIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sWGP = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfIFSummaryListVO != null) {
				Map<String, String> mapVO = cbfIFSummaryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFCgoGrsWgtRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				sWGP = dbRowset.getString("cgo_grs_wgt");
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
	 * OPR HJS의 등록여부 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchOprHJSExist(CBFIFSummaryListVO cbfIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String crrCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfIFSummaryListVO != null) {
				Map<String, String> mapVO = cbfIFSummaryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFOprHJSExistRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				crrCd = dbRowset.getString("crr_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return crrCd;
	}

	/**
	 * OPF_CGO_BKG_FCAST_SPCL_SMRY - CBF_SPCL_SMRY_SEQ  정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO CBFIFSummaryListVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCBFIFSummaryCbfSpclSmrySeq(CBFIFSummaryListVO cbfIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cbfSpclSmrySeq = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfIFSummaryListVO != null) {
				Map<String, String> mapVO = cbfIFSummaryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOSearchCBFIFSummaryCbfSpclSmrySeqRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				cbfSpclSmrySeq = dbRowset.getString("cbf_spcl_smry_seq");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfSpclSmrySeq;
	}

	/**
	 * OPF_CGO_BKG_FCAST_DG_DTL - CBF_SMRY_DCGO_SEQ  정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCBFIFSummaryCbfSmryDcgoSeq(CBFIFSummaryListVO cbfIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String CbfSmryDcgoSeq = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfIFSummaryListVO != null) {
				Map<String, String> mapVO = cbfIFSummaryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOSearchCBFIFSummaryCbfSmryDcgoSeqRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				CbfSmryDcgoSeq = dbRowset.getString("cbf_smry_dcgo_seq");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return CbfSmryDcgoSeq;
	}
	
	/*********************************************************************************************************************************/
	// #.[시트]
	/*********************************************************************************************************************************/
	/**
	 * Carrier POD 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return List<CBFIFSummaryListVO> 
	 * @throws DAOException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFSummaryList(CBFIFSummaryListVO cbfIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFIFSummaryListVO> cbfIFSummaryListVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfIFSummaryListVO != null) {
				Map<String, String> mapVO = cbfIFSummaryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOSearchCBFIFSummaryListRSQL(), param, velParam);
			cbfIFSummaryListVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFIFSummaryListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfIFSummaryListVOs;
	}

	/**
	 * Dg, Awk, Stwg, Rf, Bb, Mty, Bn 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return List<CBFIFSummaryListVO> 
	 * @throws DAOException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFSummarySpecialList(CBFIFSummaryListVO cbfIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFIFSummaryListVO> cbfIFSummaryListVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfIFSummaryListVO != null) {
				Map<String, String> mapVO = cbfIFSummaryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOSearchCBFIFSummarySpecialListRSQL(), param, velParam);
			cbfIFSummaryListVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFIFSummaryListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfIFSummaryListVOs;
	}

	/**
	 * CBF - Creation : Carrier 정보를 조회합니다. <br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return List<CBFIFSummaryListVO> 
	 * @throws DAOException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFSummaryCarrierAllList(CBFIFSummaryListVO cbfIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFIFSummaryListVO> cbfIFSummaryListVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfIFSummaryListVO != null) {
				Map<String, String> mapVO = cbfIFSummaryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOSearchCBFIFCarrierAllListRSQL(), param, velParam);
			cbfIFSummaryListVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFIFSummaryListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfIFSummaryListVOs;
	}

	/**
	 * Over Dimension 정보를 조회합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return List<CBFIFSummaryListVO> 
	 * @throws DAOException
	 */
	public List<CBFIFSummaryListVO> searchCBFIFSummaryOverDmsList(CBFIFSummaryListVO cbfIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFIFSummaryListVO> cbfIFSummaryListVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfIFSummaryListVO != null) {
				Map<String, String> mapVO = cbfIFSummaryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOSearchCBFIFSummaryOverDmsListRSQL(), param, velParam);
			cbfIFSummaryListVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CBFIFSummaryListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cbfIFSummaryListVOs;
	}
	
	
	
	/*********************************************************************************************************************************/
	// #.[]
	/*********************************************************************************************************************************/
	/**
	 * Carrier 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFSummaryCarrier(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException,	Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryCSQL(), param, velParam);
			
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
	 * Carrier 정보를 삭제합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void removeCBFIFSummaryCarrier(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException,	Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryDSQL(), param, velParam);
			
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/*********************************************************************************************************************************/
	// #.[]
	/*********************************************************************************************************************************/
	/**
	 * Carrier-POD 정보를 추가합니다.<br>
	 * 
	 * @param List<CBFIFSummaryListVO> cBFIFSummaryListVOs
	 * @throws DAOException
	 */
	public void addCBFIFSummaryPod(List<CBFIFSummaryListVO> cBFIFSummaryListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int insCnt[] = null;
			if (cBFIFSummaryListVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryPodCSQL(), cBFIFSummaryListVOs, null);
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
	 * Carrier-POD 정보를 수정합니다.<br>
	 * 
	 * @param List<CBFIFSummaryListVO> cBFIFSummaryListVOs
	 * @throws DAOException
	 */
	public void modifyCBFIFSummaryPod(List<CBFIFSummaryListVO> cBFIFSummaryListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int updCnt[] = null;
			if (cBFIFSummaryListVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryPodUSQL(), cBFIFSummaryListVOs, null);
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
	 * Carrier-POD 정보를 삭제합니다.<br>
	 * 
	 * @param List<CBFIFSummaryListVO> cBFIFSummaryListVOs
	 * @throws DAOException
	 */
	public void removeCBFIFSummaryPod(List<CBFIFSummaryListVO> cBFIFSummaryListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int delCnt[] = null;
			if (cBFIFSummaryListVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryPodDSQL(), cBFIFSummaryListVOs, null);
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
	 * Weight 정보를 수정합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void modifyCBFIFSummaryCgoGrsWgt(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException,	Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFCgoGrsWgtUSQL(), param, velParam);
			
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
	 * Over Dimension 정보를 추가합니다.<br>
	 * 
	 * @param List<CBFIFSummaryListVO> cBFIFSummaryListVOs
	 * @throws DAOException
	 */
	public void addCBFIFSummaryOverDms(List<CBFIFSummaryListVO> cBFIFSummaryListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int insCnt[] = null;
			if (cBFIFSummaryListVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryOverDmsCSQL(), cBFIFSummaryListVOs, null);
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
	 * Over Dimension 정보를 수정합니다.<br>
	 * 
	 * @param List<CBFIFSummaryListVO> cBFIFSummaryListVOs
	 * @throws DAOException
	 */
	public void modifyCBFIFSummaryOverDms(List<CBFIFSummaryListVO> cBFIFSummaryListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int updCnt[] = null;
			if (cBFIFSummaryListVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryOverDmsUSQL(), cBFIFSummaryListVOs, null);
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
	 * Over Dimension 정보를 삭제합니다.<br>
	 * 
	 * @param List<CBFIFSummaryListVO> cBFIFSummaryListVOs
	 * @throws DAOException
	 */
	public void removeCBFIFSummaryOverDms(List<CBFIFSummaryListVO> cBFIFSummaryListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int delCnt[] = null;
			if (cBFIFSummaryListVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryOverDmsDSQL(), cBFIFSummaryListVOs, null);
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
	 * Special 삭제시 Over Dimension 정보를 삭제합니다.<br>
	 * 
	 * @param List<CBFIFSummaryListVO> cBFIFSummaryListVOs
	 * @throws DAOException
	 */
	public void removeCBFIFSummarySpecialOverDms(List<CBFIFSummaryListVO> cBFIFSummaryListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int delCnt[] = null;
			if (cBFIFSummaryListVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummarySpecialOverDmsDSQL(), cBFIFSummaryListVOs, null);
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
	/*********************************************************************************************************************************/
	// #.[]
	/*********************************************************************************************************************************/
	/**
	 * Dg, Awk, Stwg, Rf, Bb, Mty, Bn 정보를 추가합니다.<br>
	 * 
	 * @param List<CBFIFSummaryListVO> cBFIFSummaryListVOs
	 * @throws DAOException
	 */
	public void addCBFIFSummarySpecial(List<CBFIFSummaryListVO> cBFIFSummaryListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int insCnt[] = null;
			if (cBFIFSummaryListVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummarySpecialCSQL(), cBFIFSummaryListVOs, null);
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
	 * Dg, Awk, Stwg, Rf, Bb, Mty, Bn 정보를 수정합니다.<br>
	 * 
	 * @param List<CBFIFSummaryListVO> cBFIFSummaryListVOs
	 * @throws DAOException
	 */
	public void modifyCBFIFSummarySpecial(List<CBFIFSummaryListVO> cBFIFSummaryListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int updCnt[] = null;
			
			if (cBFIFSummaryListVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummarySpecialUSQL(), cBFIFSummaryListVOs, null);
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
	 * Dg, Awk, Stwg, Rf, Bb, Mty, Bn 정보를 삭제합니다.<br>
	 * 
	 * @param List<CBFIFSummaryListVO> cBFIFSummaryListVOs
	 * @throws DAOException
	 */
	public void removeCBFIFSummarySpecial(List<CBFIFSummaryListVO> cBFIFSummaryListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int delCnt[] = null;
			if (cBFIFSummaryListVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummarySpecialDSQL(), cBFIFSummaryListVOs, null);
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

	
	/*********************************************************************************************************************************/
	// #.[인터페이스]
	/*********************************************************************************************************************************/
	/**
	 * I/F D-CUDE Interface - DG 정보를 삭제합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void removeCBFIFSummaryIfDcube(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfDcubeDgDSQL(), param, velParam);
			
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
	 *  POD 삭제시 해당 POD의 SPECIAL 데이터가 있는지 확인하기 위함 <br>
	 * 
	 * @param CBFIFSummaryListVO cbfIFSummaryListVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCBFIFSpecialExist(CBFIFSummaryListVO cbfIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String flg = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (cbfIFSummaryListVO != null) {
				Map<String, String> mapVO = cbfIFSummaryListVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummarySpecialExistRSQL(), param, null);
	
			if (dbRowset.next()) {
				flg = dbRowset.getString("flg");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return flg;
	}
	
	/**
	 * I/F D-CUDE Interface - DG 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFSummaryIfDcubeDg(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfDcubeDgCSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface - Carrier 정보를 삭제합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void removeCBFIFSummaryIfBkgDtCarrier(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtCarrierDSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface - Weight 정보를 삭제합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void removeCBFIFSummaryIfBkgDtCgoGrsWgt(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtCgoGrsWgtDSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface - 정보를 삭제합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void removeCBFIFSummaryIfBkgDt(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtDSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface - WGT GROUP SUMMARY 정보를 삭제합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void removeCBFIFSummaryWgtGroup(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgWgtGroupDSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface - 정보를 삭제합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void removeCBFIFSummaryIfBkgDtDtl(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtDtlDSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface - Carrier 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFSummaryIfBkgDtCarrier(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtCarrierCSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface -  Weight 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFSummaryIfBkgDtCgoGrsWgt(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtCgoGrsWgtCSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface - DG 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFSummaryIfBkgDtDg(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtDgCSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface - DG DTL 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFSummaryIfBkgDtDgDtl(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtDgDtlCSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface - AWK 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFSummaryIfBkgDtAwk(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtAwkCSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface - RF 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFSummaryIfBkgDtRf(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtRfCSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface - STWG 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFSummaryIfBkgDtStwg(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtStwgCSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface - BB 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFSummaryIfBkgDtBb(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtBbCSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface - Bundle 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFSummaryIfBkgDtBn(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtBnCSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface - MTY 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFSummaryIfBkgDtMty(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtMtyCSQL(), param, velParam);
			
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
	 * I/F BKG DT Interface -WEIGHT GROUP SUMMARY 추가한다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFSummaryWgtGroup(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgWgtGroupSummaryCSQL(), param, velParam);
			
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
	 * CBF의 VVD,YD의 모든 데이터를 삭제한다..<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void delCBFAll(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.put("del_tab","1");

			SQLExecuter sqlExe1 = new SQLExecuter("OPF_HJSBAT");
			int result1 = sqlExe1.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFAllDataDSQL(), param, velParam);
			
			param.putAll(mapVO);
			velParam.put("del_tab","2");

			SQLExecuter sqlExe2 = new SQLExecuter("OPF_HJSBAT");
			int result2 = sqlExe2.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFAllDataDSQL(), param, velParam);
			
			param.putAll(mapVO);
			velParam.put("del_tab","3");

			SQLExecuter sqlExe3 = new SQLExecuter("OPF_HJSBAT");
			int result3 = sqlExe3.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFAllDataDSQL(), param, velParam);
			
			param.putAll(mapVO);
			velParam.put("del_tab","4");

			SQLExecuter sqlExe4 = new SQLExecuter("OPF_HJSBAT");
			int result4 = sqlExe4.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFAllDataDSQL(), param, velParam);
		
			param.putAll(mapVO);
			velParam.put("del_tab","5");

			SQLExecuter sqlExe5 = new SQLExecuter("OPF_HJSBAT");
			int result5 = sqlExe5.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFAllDataDSQL(), param, velParam);
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe6 = new SQLExecuter("OPF_HJSBAT");
			int result6 = sqlExe6.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgUpldUSQL(), param, velParam);
			
			
			if (result1 == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			if (result2 == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			if (result3 == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			if (result4 == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
			if (result5 == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
			if (result6 == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * CBF ALLSummary 정보를 조회합니다.<br>
	 * 
	 * @param  String vvd
	 * @param  String ydCd
	 * @param  String polclptindseq
	 * @return List<CBFAllSummaryPreviewVO>
	 * @throws DAOException
	 */
	public List<CBFAllSummaryPreviewVO> searchCBFAllSummary(String vvd, String ydCd, String polclptindseq) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFAllSummaryPreviewVO>  list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			    param.put("vvd", vvd);
		        param.put("yd_cd", ydCd);
			    param.put("pol_clpt_ind_seq", polclptindseq);

			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOsearchCBFAllSummaryPreviewRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CBFAllSummaryPreviewVO.class);
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
	  * CBF: CLL과 BOOKING DATA 비교 LIST<br>
	 * 
	 * @param  String vvd
	 * @param  String ydCd
	 * @param  String polclptindseq
	 * @return List<CBFIFSummaryDiffListVO>
	 * @throws DAOException
	 */
	public List<CBFIFSummaryDiffListVO> searchCBFIFSummaryDiffCntrList(String vvd, String ydCd, String polclptindseq) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFIFSummaryDiffListVO>  list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			    param.put("vvd", vvd);
		        param.put("yd_cd", ydCd);
			    param.put("pol_clpt_ind_seq", polclptindseq);

		    	dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOCBFIFSummaryDiffListRSQL(), param, velParam);
			    list = (List)RowSetUtil.rowSetToVOs(dbRowset, CBFIFSummaryDiffListVO.class);
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
	 * VVD 정보를 체크합니다.<br>
	 * 
	 * @param  CBFPartnerEDIVO cBFPartnerEDIVO
	 * @return String 
	 * @throws DAOException
	 */
	public String checkVvdExist(CBFPartnerEDIVO cBFPartnerEDIVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String strRet = "";
		try{
			if(cBFPartnerEDIVO != null){
				Map<String, String> mapVO = cBFPartnerEDIVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOCheckVvdExistRSQL(), param, velParam);
			if(dbRowset.next()){
				strRet = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}
	
	
	/**
	 * Carrier Type/Size 정보를 체크합니다.<br>
	 * 
	 * @param  CBFPartnerEDIVO cBFPartnerEDIVO
	 * @return String 
	 * @throws DAOException
	 */
	public String checkTypeSizeCd(CBFPartnerEDIVO cBFPartnerEDIVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String strRet = "";
		try{
			if(cBFPartnerEDIVO != null){
				Map<String, String> mapVO = cBFPartnerEDIVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOSearchCBFCheckTypeSizeRSQL(), param, velParam);
			if(dbRowset.next()){
				strRet = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}
	
	/**
	 * yard code를 가져온다<br>
	 * 
	 * @param CBFPartnerEDIVO cBFPartnerEDIVO
	 * @return List<SearchYardCodeVO>
	 * @throws DAOException
	 */
	public List<SearchYardCodeVO> checkYardCd(CBFPartnerEDIVO cBFPartnerEDIVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
		List<SearchYardCodeVO>  list = null;


		try{
			if(cBFPartnerEDIVO != null){
				Map<String, String> mapVO = cBFPartnerEDIVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOCheckYardCodeRSQL(), param, velParam	);	  
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchYardCodeVO.class);
		
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
	  * CBF:Partner CLL EDI LIST<br>
	 * 
	 * @param  CBFPartnerConditionVO cBFPartnerConditionVO
	 * @return List<CBFPartnerEDIVO>
	 * @throws DAOException
	 */
	public List<CBFPartnerEDIVO> searchCBFPartnerEDIList(CBFPartnerConditionVO cBFPartnerConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFPartnerEDIVO>  list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			    Map<String, String> mapVO = cBFPartnerConditionVO.getColumnValues();
			    
			    param.putAll(mapVO);
			    velParam.putAll(mapVO);
			    
		    	dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new  OwnContainerBookingForecastMgtDBDAOCBFPartnerEDIRSQL(), param, velParam);
			    list = (List)RowSetUtil.rowSetToVOs(dbRowset, CBFPartnerEDIVO.class);
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
	  * CBF:Partner CLL EDI LIST<br>
	 * 
	 * @param  List<CBFPartnerEDIVO> updateVoList
	 * @throws DAOException
	 */
	public void manageCBFPartnerEDI(List<CBFPartnerEDIVO> updateVoList) throws DAOException {
			
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int updCnt[] = null;
			
			if(updateVoList.size() > 0){				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOmodifyCBFPartnerEDIUSQL(), updateVoList, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
	  				 throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Partner EDI 수신 - SUMMARY 데이터 삭제 <br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void removeCBFIFPartnerDelCgoSummary(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerDelCgoSummaryDSQL(), param, velParam);
			
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to DELETE SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Partner EDI 수신 - SPEICAL 데이터 삭제 <br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void removeCBFIFPartnerDelCgoSpeicalSummary(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerDelCgoSpeicalSummaryDSQL(), param, velParam);
			
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to DELETE SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Partner EDI 수신 - D/G CO-LOAD데이터 삭제<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void removeCBFIFPartnerDelCgoDgDtl(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerDelCgoDgDtlDSQL(), param, velParam);
			
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to DELETE SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Partner EDI 수신 - WEIGHT삭제<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void removeCBFIFPartnerDelWgt(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerDelWgtDSQL(), param, velParam);
			
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to DELETE SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Partner EDI 수신 - WEIGHT Group Summary 삭제 <br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void removeCBFIFPartnerDelWgtGrp(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerDelCgoWgtGroupSummaryDSQL(), param, velParam);
			
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to DELETE SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Partner EDI 수신 - 데이터 upload전에 user가 manual로 입력한 데이터가 있는 지 확인<br>
	 * 
	 * @param CBFIFSummaryListVO CBFIFSummaryListVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCBFIFPartnerExistCgo(CBFIFSummaryListVO cbfIFSummaryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cbfIFSummaryListVO != null) {
				Map<String, String> mapVO = cbfIFSummaryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerExistCgoRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				cnt = dbRowset.getString("cnt");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * CBF: WGT GROUP SUMMARY 조회 <br>
	 * 
	 * @param  CBFWgtGroupSummaryVO cBFWgtGroupSummaryVO
	 * @return List<CBFWgtGroupSummaryVO>
	 * @exception EventException
	 */
	public List<CBFWgtGroupSummaryVO> searchCBFWgtGroupSummary(CBFWgtGroupSummaryVO cBFWgtGroupSummaryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CBFWgtGroupSummaryVO>  list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			    Map<String, String> mapVO = cBFWgtGroupSummaryVO.getColumnValues();
			    
			    param.putAll(mapVO);
			    velParam.putAll(mapVO);
			    
		    	dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new  OwnContainerBookingForecastMgtDBDAOCBFWgtGroupSummaryRSQL(), param, velParam);
			    list = (List)RowSetUtil.rowSetToVOs(dbRowset, CBFWgtGroupSummaryVO.class);
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
	 * CBF: WGT GROUP SUMMARY 수정 <br>
	 * 
	 * @param  List<CBFWgtGroupSummaryVO> updateVoList
	 * @exception EventException
	 */
	public void manageCBFWgtGroupSummary(List<CBFWgtGroupSummaryVO> updateVoList) throws DAOException {
	 	Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int updCnt[] = null;
			
			log.debug("updateVoList**++"+updateVoList);
	
			if(updateVoList.size() > 0){				
			 for( int j=1;j<=4;j++){
				  velParam.put("col", j);				
					updCnt = sqlExe.executeBatch((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOCBFModifyWgtGroupSummaryUSQL(), updateVoList, velParam);
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
		  				 throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Partner EDI 수신 - SUMMARY <br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFPartnerIfBkgDtCarrier(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtCarrierCSQL(), param, velParam);
			
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
	 *  PARTNER CLL - DG 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFPartnerIfBkgDtDg(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtDgCSQL(), param, velParam);
			
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
	 *  PARTNER CLL - DG detail(CO-LOAD) 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFPartnerIfBkgDtDgDtl(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtDgDtlCSQL(), param, velParam);
			
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
	 *  PARTNER CLL - AWK 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFPartnerIfBkgDtAwk(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtAwkCSQL(), param, velParam);
			
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
	 *  PARTNER CLL - REFEER 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFPartnerIfBkgDtRf(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtRfCSQL(), param, velParam);
			
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
	 *  PARTNER CLL - BB 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFPartnerIfBkgDtBb(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtBbCSQL(), param, velParam);
			
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
	 * PARTNER CLL - MTY 정보를 추가합니다.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFPartnerIfBkgDtMty(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtMtyCSQL(), param, velParam);
			
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
	 * PARTNER CLL - weight group summary insert.<br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFPartnerIfBkgWgtGrpSummary(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerCgoWgtGroupSummaryCSQL(), param, velParam);
			
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
	 * PARTNER CLL - cbf 테이블에 저장후 완료 일자 넣기 <br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void modifyCBFIFPartnerIfUpload(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgUploadUSQL(), param, velParam);
			
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
	 * OPF EDI 전문 List 정렬 후 저장 , 단건 처리
	 * @param  OpfPrnrEdiCgoBkgFcastVO opfPrnrEdiCgoBkgFcastVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addOpfPrnrEdiCgoBkgFcast(OpfPrnrEdiCgoBkgFcastVO opfPrnrEdiCgoBkgFcastVO ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			Map<String, String> paramMap = opfPrnrEdiCgoBkgFcastVO.getColumnValues();
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOOpfPrnrEdiCgoBkgFcastCSQL(), paramMap, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * OPF EDI Log Next Seq 조회
	 * @return int
	 * @throws DAOException
	 */
	public int searchEdiLogNextSeq() throws DAOException {
		DBRowSet dbRowset	= null;
		int nextSeq			= 1;
		
		Map<String, Object> param		= new HashMap<String, Object>();	// query parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();	// velocity parameter

		try {
			log.debug("!!!!!---- NEXTSEQ SQL");
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOOpfPrnrEdiLogNextSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				nextSeq = dbRowset.getInt("NEXTSEQ");
			} else {
				nextSeq = 1;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return nextSeq;
	}
	
	/**
	 * OPF EDI Log 생성
	 * @param  OpfPrnrEdiLogVO opfPrnrEdiLogVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addOpfPrnrEdiLog(OpfPrnrEdiLogVO opfPrnrEdiLogVO ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			Map<String , String> paramMap	= opfPrnrEdiLogVO.getColumnValues();
			Map<String, Object> velParam	= new HashMap<String, Object>();

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOOpfPrnrEdiLogCSQL(), paramMap, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * OPF EDI Log 저장
	 * @param  OpfPrnrEdiLogVO opfPrnrEdiLogVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyOpfPrnrEdiLog(OpfPrnrEdiLogVO opfPrnrEdiLogVO ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			Map<String, String> paramMap = opfPrnrEdiLogVO.getColumnValues();
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = sqlExe.executeUpdate((ISQLTemplate)new OwnContainerBookingForecastMgtDBDAOOpfPrnrEdiLogUSQL(), paramMap, velParam);
			if(result == Statement.EXECUTE_FAILED){
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
	 * VSL_CD 조회
	 * @param String callSgnNo
	 * @param String ediVslNm
	 * @return String
	 * @throws DAOException
	 */
	public String searchCBFIFPartnerVesselName(String callSgnNo, String ediVslNm) throws DAOException {
		DBRowSet dbRowset	= null;
		String vslCd		= null;

		Map<String, Object> param		= new HashMap<String, Object>();	// query parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();	// velocity parameter

		param.put("call_sgn_no", callSgnNo);
		param.put("edi_vsl_nm", ediVslNm);
		
		try {
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerVesselNameRSQL(), param, velParam);
			if (dbRowset.next()) {
				vslCd = dbRowset.getString("VSL_CD");
			} else {
				vslCd = null;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslCd;
	}

	/**
	 * CRR_CD 조회
	 * @param String crrNm
	 * @return String
	 * @throws DAOException
	 */
	public String searchCBFIFPartnerCarrier(String crrNm) throws DAOException {
		DBRowSet dbRowset	= null;
		String crrCd		= "";

		Map<String, Object> param		= new HashMap<String, Object>();	// query parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();	// velocity parameter

		param.put("crr_nm", crrNm);
		
		try {
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerCarrierRSQL(), param, velParam);
			if (dbRowset.next()) {
				crrCd = dbRowset.getString("CRR_CD");
			} else {
				crrCd = null;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return crrCd;
	}
	
	/**
	 * POD_CD 조회
	 * @param String ediPodCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCBFIFPartnerPortCode(String ediPodCd) throws DAOException {
		DBRowSet dbRowset	= null;
		String podCd		= "";

		Map<String, Object> param		= new HashMap<String, Object>();	// query parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();	// velocity parameter

		param.put("edi_pod_cd", ediPodCd);
		
		try {
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerPortCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				podCd = dbRowset.getString("POD_CD");
			} else {
				podCd = null;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return podCd;
	}
	
	/**
	 * VOY, DIR 조회
	 * @param String skdVoyNo
	 * @param String vslCd
	 * @param String ediPolYdCd
	 * @param  String etaDt
	 * @return String
	 * @throws DAOException
	 */
	public String searchCBFIFPartnerVoyageDirection(String skdVoyNo, String vslCd, String ediPolYdCd, String etaDt) throws DAOException {
		DBRowSet dbRowset	= null;
		String voyDir 		= "";

		Map<String, Object> param		= new HashMap<String, Object>();	// query parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();	// velocity parameter

		param.put("skd_voy_no", skdVoyNo);
		param.put("vsl_cd", vslCd);
		param.put("edi_pol_yd_cd", ediPolYdCd);
		param.put("eta_dt", etaDt);
		
		try {
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerVoyageNumberRSQL(), param, velParam);
			if (dbRowset.next()) {
				voyDir = dbRowset.getString("VOY_DIR");
			} else {
				voyDir = null;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return voyDir;
	}

	/**
	 * YD_CD, CLPT_IND_SEQ 조회
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String vslCd
	 * @param String ediPolYdCd
	 * @param String etaDt
	 * @return String
	 * @throws DAOException
	 */
	public String searchCBFIFPartnerYardCodeCallingPortIndicatorSequence(String skdVoyNo, String skdDirCd, String vslCd, String ediPolYdCd, String etaDt) throws DAOException {
		DBRowSet dbRowset		= null;
		String ydCodeClptSeq	= "";

		Map<String, Object> param		= new HashMap<String, Object>();	// query parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();	// velocity parameter

		param.put("skd_voy_no", skdVoyNo);
		param.put("skd_dir_cd", skdDirCd);
		param.put("vsl_cd", vslCd);
		param.put("edi_pol_yd_cd", ediPolYdCd);
		param.put("eta_dt", etaDt);
		
		try {
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerYardCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				ydCodeClptSeq = dbRowset.getString("YD_CD_CLPT_IND_SEQ");
			} else {
				ydCodeClptSeq = null;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ydCodeClptSeq;
	}
	

	
	/**
	 * PARTNER CLL -GROSS WGT <br>
	 * 
	 * @param CBFIFSummaryListVO cBFIFSummaryListVO
	 * @throws DAOException
	 */
	public void addCBFIFPartnerIfBkgDtCgoGrsWgt(CBFIFSummaryListVO cBFIFSummaryListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cBFIFSummaryListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate) new OwnContainerBookingForecastMgtDBDAOCBFIFPartnerCgoGrsWgtCSQL(), param, velParam);
			
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
}
