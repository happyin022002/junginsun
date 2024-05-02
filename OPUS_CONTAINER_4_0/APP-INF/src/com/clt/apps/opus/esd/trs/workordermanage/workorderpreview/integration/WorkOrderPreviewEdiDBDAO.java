/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderPreviewEdiDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 理쒖큹 �앹꽦
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.basic.WorkOrderPreviewBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TrsEdiWrkOrdHisVO;

/**
 * - ESD-workordermanage Business Logic.<br>
 * 
 * @author
 * @see WorkOrderPreviewBCImpl
 * @since J2EE 1.4
 */
public class WorkOrderPreviewEdiDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 7105703269833442705L;

	/**
	 * NYK-Hawk_FFile(USV_N)-JOEDIUPDT_IAS_OUTBOUND <br>
	 * {CRT /UPDT
	 * 
	 * @param woVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileUsvMaster(WorkOrderPreviewVO woVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", woVO.getEdiTrspSoOfcCtyCd());
			param.put("trsp_so_seq", woVO.getEdiTrspSoSeq());
			param.put("wo_iss_sts_cd", woVO.getEdiWoIssStsCd());
			param.put("jo_item_ref", woVO.getJoItemRef());
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileUsvMasterRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(USV_N)-JOEDIUPDT_IAS_OUTBOUND <br>
	 * {EQUIPMENT
	 * 
	 * @param pDs
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileUsvEquipment(DBRowSet pDs) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", pDs.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", pDs.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileUsvEquipmentRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(USV_N)-JOEDIUPDT_IAS_OUTBOUND <br>
	 * Seal
	 * 
	 * @param ds
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileUsvSeal(DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", ds.getString("bkg_no"));
			param.put("cntr_no", ds.getString("cntr_no"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileUsvSealRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(USV_N)-JOEDIUPDT_IAS_OUTBOUND <br>
	 * CHARGE
	 * 
	 * @param mRowSet
	 * @param ds
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileUsvCharge(DBRowSet mRowSet, DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", mRowSet.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", mRowSet.getString("trsp_so_seq"));
			param.put("cntr_no", ds.getString("cntr_no"));
			param.put("cntr_tpsz", ds.getString("cntr_tpsz"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileUsvChargeRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(USV_N)-JOEDIUPDT_IAS_OUTBOUND <br>
	 * {HAZARDODUS
	 * 
	 * @param mRowSet
	 * @param ds
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileUsvHazardodus(DBRowSet mRowSet, DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", mRowSet.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", mRowSet.getString("trsp_so_seq"));
			param.put("cntr_no", ds.getString("cntr_no"));
			param.put("cntr_tpsz", ds.getString("cntr_tpsz"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileUsvHazardodusRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(USV_N)-JOEDIUPDT_IAS_OUTBOUND <br>
	 * {STOP
	 * 
	 * @param ds
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileUsvStop(DBRowSet ds) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("trsp_so_ofc_cty_cd", ds.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", ds.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileUsvStopRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * 
	 * NYK-Hawk_FFile(USV_N)-JOEDIUPDT_IAS_OUTBOUND <br>
	 * {LOCATION
	 * 
	 * @deprecated
	 * @param ds
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileUsvLocation(DBRowSet ds) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("trsp_so_ofc_cty_cd", "");
			param.put("trsp_so_seq", "");
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileUsvLocationRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(USV_N)-JOEDIUPDT_IAS_OUTBOUND <br>
	 * {APPT
	 * 
	 * @param ds
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileUsvAppt(DBRowSet ds) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("trsp_so_ofc_cty_cd", "");
			param.put("trsp_so_seq", "");
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileUsvApptRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(USV_N)-JOEDIUPDT_IAS_OUTBOUND <br>
	 * APPT_EQ
	 * 
	 * @param ds
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileUsvApptEq(DBRowSet ds) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("trsp_so_ofc_cty_cd", "");
			param.put("trsp_so_seq", "");
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileUsvApptEqRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {EU 2015.01.05 Hyungwook Choi
	 * 
	 * @param wrkOrdPrvVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvMaster(WorkOrderPreviewVO wrkOrdPrvVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", wrkOrdPrvVO.getEdiTrspSoOfcCtyCd());
			param.put("trsp_so_seq", wrkOrdPrvVO.getEdiTrspSoSeq());
			param.put("wo_iss_sts_cd", wrkOrdPrvVO.getEdiWoIssStsCd());
			param.put("wo_prv_grp_seq", wrkOrdPrvVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", wrkOrdPrvVO.getWoIssNo());
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvMasterRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {RAIL_SCAC_CODE 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet mRowSet
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvRail(DBRowSet mRowSet) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", mRowSet.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", mRowSet.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvRailRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {PORT_VOYAGE_DETAIL 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet ds
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvPort(DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", ds.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", ds.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvPortRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {PARTY 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet ds
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvParty(DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", ds.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", ds.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvPartyRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {CHARGE 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet ds
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvCharge(DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", ds.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", ds.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvChargeRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {SURCHARGE 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet ds
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvSurcharge(DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", ds.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", ds.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvSurchargeRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {EQUIPMENT 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet ds
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvEquipment(DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", ds.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", ds.getString("trsp_so_seq"));
			param.put("cgo_tp_cd", ds.getString("cgo_tp_cd"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvEquipmentRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {MEASUREMENT 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet ds
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvEquipmentCaegoDetailMeasure(DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", ds.getString("bkg_no"));
			param.put("cntr_no", ds.getString("cntr_no"));
			param.put("trsp_so_ofc_cty_cd", ds.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", ds.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOSearchFlatFileEsvEquipmentCaegoDetailMeasureRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {HAZARDODUS 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet ds
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvHazard(DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", ds.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", ds.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvHazardRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {HAZARDODUS MEASUREMENT
	 * 
	 * @param ds
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvHazardodusMeasurement(DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", ds.getString("bkg_no"));
			param.put("dcgo_seq", ds.getString("dcgo_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOSearchFlatFileEsvHazardodusMeasurementRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {SEAL_NUMBER 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet ds
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvSeal(DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", ds.getString("bkg_no"));
			param.put("cntr_no", ds.getString("cntr_no"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvSealRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {EQUIPMENT_REFERENCE 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet ds
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvEquipmentReference(DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", ds.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", ds.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOSearchFlatFileEsvEquipmentReferenceRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {MRN_NUMBER_LIST 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet ds
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvMrn(DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", ds.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", ds.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvMrnRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {AWKARD 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet ds
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvAwkard(DBRowSet ds) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", ds.getString("bkg_no"));
			param.put("cntr_no", ds.getString("cntr_no"));
			param.put("cntr_tpsz", ds.getString("cntr_tpsz"));
			param.put("trsp_so_ofc_cty_cd", ds.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", ds.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvAwkardRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {AWKARD_MEASUREMENT 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet ds
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvAwkardMeasure(DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", ds.getString("bkg_no"));
			param.put("awk_cgo_seq", ds.getString("awk_cgo_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvAwkardMeasureRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {AWKARD_MEASUREMENT 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet ds
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvReefer(DBRowSet ds) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("cntr_no", ds.getString("cntr_no"));
			param.put("bkg_no", ds.getString("bkg_no"));
			param.put("cntr_tpsz", ds.getString("cntr_tpsz"));
			param.put("trsp_so_ofc_cty_cd", ds.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", ds.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvReeferRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {MEASUREMENT 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet ds
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvMeasure(DBRowSet ds) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", ds.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", ds.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvMeasureRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {STOP_LIST 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet mRowSet
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvStop(DBRowSet mRowSet) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("trsp_so_ofc_cty_cd", mRowSet.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", mRowSet.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvStopRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {ORIGIN 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet mRowSet
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvOrigin(DBRowSet mRowSet) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("wo_prv_grp_seq", mRowSet.getString("wo_prv_grp_seq"));
			param.put("wo_iss_no", mRowSet.getString("wo_iss_no"));
			param.put("trsp_so_ofc_cty_cd", mRowSet.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", mRowSet.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvOriginRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {DESTINATION 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet mRowSet
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvDestination(DBRowSet mRowSet) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("wo_prv_grp_seq", mRowSet.getString("wo_prv_grp_seq"));
			param.put("wo_iss_no", mRowSet.getString("wo_iss_no"));
			param.put("trsp_so_ofc_cty_cd", mRowSet.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", mRowSet.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvDestinationRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND {LOCATION 2015.01.05 Hyungwook Choi
	 * 
	 * @param DBRowSet mRowSet
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFlatFileEsvAppoint(DBRowSet mRowSet) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("wo_prv_grp_seq", mRowSet.getString("wo_prv_grp_seq"));
			param.put("wo_iss_no", mRowSet.getString("wo_iss_no"));
			param.put("trsp_so_ofc_cty_cd", mRowSet.getString("trsp_so_ofc_cty_cd"));
			param.put("trsp_so_seq", mRowSet.getString("trsp_so_seq"));
			return new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOsearchFlatFileEsvAppointRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * 
	 * @param trsEdiWrkOrdHisVO
	 * @throws DAOException
	 */
	public void addJoEdiHistory(TrsEdiWrkOrdHisVO trsEdiWrkOrdHisVO) throws DAOException {
		Map<String, String> param = new HashMap<String, String>();
		try {
			param = trsEdiWrkOrdHisVO.getColumnValues();
			new SQLExecuter().executeUpdate(new WorkOrderPreviewEAIDAOAddJoEdiHistoryCSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * JO EDI - Receiver Info.
	 * 
	 * @param ediVndrSeq
	 * @return
	 * @throws DAOException
	 */
	public String searchJoEdiEuReceiver(String ediVndrSeq) throws DAOException {
		String ediRcvrNm = "";
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vndr_seq", ediVndrSeq);
			DBRowSet ds = new SQLExecuter().executeQuery(new WorkOrderPreviewEdiDBDAOSearchJoEdiEuReceiverRSQL(), param, param);
			if (ds.next()) {
				ediRcvrNm = ds.getString("edi_rcvr_nm");
			}
			return ediRcvrNm;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}
}