/*=========================================================
 *Copyright(c) SMLines. All Rights Reserved.
 *@FileName : CndExpCustomsTransmissionDBDAO.java
 *@FileTitle : CndExpCustomsTransmissionDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BayPlanCntrDetailCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BayPlanCntrListConCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BayPlanPolDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BlInfoForFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsBlByKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestDtlListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsTrsmRsltListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsTrsmRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndVesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CntrInfoForFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.SealNoInfoForFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.SendDetailLogCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.SendLogDetailCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.StiCondListCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.StiDetailCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.VesselEtaCondCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.VesselEtaInfoCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CmInfoForFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgCstmsAdvEdiBlRspnVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRcvLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRcvLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvSndLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvSndLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsCndVslVO;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;


/**
 * CndExpCustomsTransmissionDBDAO<br>
 * - CndExpCustomsTransmissionDBDAO system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author
 * @see 상위 BCImpl 참조
 * @since J2EE 1.6
 */
public class CndExpCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Vessel Arrival 정보조회
	 *
	 * @param CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO
	 * @return CndVesselArrivalTransmitVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CndVesselArrivalTransmitVO searchVesselArrival(CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		DBRowSet dbRowset = null;

		try {
			Map<String, String> mapVO = cndVesselArrivalTransmitVO.getColumnValues();
			param.putAll(mapVO);
			if (cndVesselArrivalTransmitVO.getBlNo() == null || "".equals(cndVesselArrivalTransmitVO.getBlNo())) {
				dbRowset = sqlExe.executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchVesselArrivalRSQL(), param, null);
			} else {
				// ESM_BKG_N002(MI화면)에서 Vessel 의 CRN No.가 없을때 에러처리
				param.put("bl_no", cndVesselArrivalTransmitVO.getBlNo());
				dbRowset = sqlExe.executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchVesselArrival2RSQL(), param, null);
			}
			List<CndVesselArrivalTransmitVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndVesselArrivalTransmitVO.class);
			return (list != null && list.size() > 0) ? list.get(list.size()-1) : null;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * Vessel Departure 정보조회
	 *
	 * @param CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO
	 * @return CndVesselArrivalTransmitVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CndVesselArrivalTransmitVO searchVesselDeparture(CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		DBRowSet dbRowset = null;
		
		try {
			Map<String, String> mapVO = cndVesselArrivalTransmitVO.getColumnValues();
			param.putAll(mapVO);
			dbRowset = sqlExe.executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchVesselDepartureRSQL(), param, null);
			List<CndVesselArrivalTransmitVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndVesselArrivalTransmitVO.class);
			return (list != null && list.size() > 0) ? list.get(list.size()-1) : null;
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 선적항, 출항일, 양하항, 양하일 조회<br>
	 * 도착직전 port를 조회하는것 같은데 의미없는 값을 조회함(as-is). 향후 검토필요
	 *
	 * @param CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO
	 * @return CndVesselArrivalTransmitVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CndVesselArrivalTransmitVO searchPolPod(CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cndVesselArrivalTransmitVO != null) {
				Map<String, String> mapVO = cndVesselArrivalTransmitVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchPolPodRSQL(), param, null);
			List<CndVesselArrivalTransmitVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndVesselArrivalTransmitVO.class);
			return (list != null && list.size() > 0) ? list.get(list.size()-1) : null;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 선적항, 출항일, 양하항, 양하일 조회<br>
	 * 도착직전 port를 조회하는것 같은데 의미없는 값을 조회함(as-is). 향후 검토필요
	 *
	 * @param CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO
	 * @return CndVesselArrivalTransmitVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CndVesselArrivalTransmitVO searchPolPodForDeparture(CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		 
		try {
			if (cndVesselArrivalTransmitVO != null) {
				Map<String, String> mapVO = cndVesselArrivalTransmitVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchPolPodForDepartureRSQL(), param, null);
			List<CndVesselArrivalTransmitVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndVesselArrivalTransmitVO.class);
			return (list != null && list.size() > 0) ? list.get(list.size()-1) : null;
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Vessel Port 조회
	 *
	 * @param CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO
	 * @return List<CndVesselArrivalTransmitVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CndVesselArrivalTransmitVO> searchVesselPort(CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cndVesselArrivalTransmitVO != null) {
				Map<String, String> mapVO = cndVesselArrivalTransmitVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchVesselPortRSQL(), param, null);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CndVesselArrivalTransmitVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * EDI Send 로그등록
	 *
	 * @param List<BkgCstmsAdvSndLogVO> BkgCstmsAdvSndLogVOList
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvSndLog(List<BkgCstmsAdvSndLogVO> BkgCstmsAdvSndLogVOList) throws DAOException {
		try {
			if (BkgCstmsAdvSndLogVOList.size() > 0) {
				int rsltCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndExpCustomsTransmissionDBDAOaddBkgCstmsAdvSndLogCSQL(), BkgCstmsAdvSndLogVOList, null);
				for (int i=0; i<rsltCnt.length; i++) {
					if (rsltCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * EDI Send Detail 로그
	 *
	 * @param List<BkgCstmsAdvSndLogDtlVO> BkgCstmsAdvSndLogDtlVOList
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvSndLogDtl(List<BkgCstmsAdvSndLogDtlVO> BkgCstmsAdvSndLogDtlVOList) throws DAOException {
		try {
			if (BkgCstmsAdvSndLogDtlVOList.size() > 0) {
				int rsltCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndExpCustomsTransmissionDBDAOaddBkgCstmsAdvSndLogDtlCSQL(), BkgCstmsAdvSndLogDtlVOList, null);
				for (int i = 0; i < rsltCnt.length; i++) {
					if (rsltCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 로그 일련번호
	 *
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxSndLogSeq() throws DAOException {
		try {
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchLogSeqRSQL(), null, null);
			return dbRowset.next() ? dbRowset.getString(1) : "1";

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 캐나다 세관 적하 목록 정정 대상을 가져옴
	 *
	 * @param CndCstmsManifestAmendmentCondVO cndCstmsManifestAmendmentCondVO
	 * @return List<CstmsManifestAmendmentVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CstmsManifestAmendmentVO> searchCndCstmsManifestAmendment(CndCstmsManifestAmendmentCondVO cndCstmsManifestAmendmentCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		DBRowSet dbRowset = null;
		List<CstmsManifestAmendmentVO> list = null;

		try {
			Map<String, String> mapVO = cndCstmsManifestAmendmentCondVO.getColumnValues();
			mapVO.put("start_no", cndCstmsManifestAmendmentCondVO.getStartNo());
			mapVO.put("end_no", cndCstmsManifestAmendmentCondVO.getEndNo());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			if (!"".equals(cndCstmsManifestAmendmentCondVO.getBkgNo()) || !"".equals(cndCstmsManifestAmendmentCondVO.getMblNo()) || !"".equals(cndCstmsManifestAmendmentCondVO.getVvdCd())) {
				// Vessel 스케줄 조회
				dbRowset = sqlExe.executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchMinClptSeqRSQL(), param, velParam);
				if (dbRowset.next()) {
					mapVO.put("min_seq", dbRowset.getString(1));
					mapVO.put("vsl_skd_flg", dbRowset.getString(2));
				}
			}
			// 조회
			dbRowset = sqlExe.executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchCndCstmsManifestAmendmentRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsManifestAmendmentVO.class);

			for (int i = 0; i < list.size(); i++) {
				StringBuffer sbActionCode = new StringBuffer();
				CndCstmsManifestAmendmentVO vo = (CndCstmsManifestAmendmentVO) list.get(i);
				// Total Count 세팅
				list.get(0).setMaxRows(Integer.parseInt(vo.getTotal()));
				/***********************************************************
				 * Action Code 세팅
				 ***********************************************************/
				if (!"D".equals(vo.getMfStsCd())) {
					if (("X".equals(vo.getBkgStsCd()) || "A".equals(vo.getBkgStsCd()) || "S".equals(vo.getBkgStsCd()) || !vo.getBVvdCd().equals(vo.getTVvdCd())) && ("Y".equals(vo.getBMi()))) {
						// BOOKING의 VVD와 BKC의 VVD가 다르고 전송한 적이 있다면
						sbActionCode.append("DADC");
					}
				}
				if (!"X".equals(vo.getBkgStsCd()) && !"A".equals(vo.getBkgStsCd()) && !"S".equals(vo.getBkgStsCd()) && ("D".equals(vo.getMfStsCd()) || sbActionCode.toString().indexOf("DA") != -1)) {
					// 상태가
					sbActionCode.append("RA");
				}
				// 나올수가 없음
				if ("DARA".equals(sbActionCode.toString())) sbActionCode.setLength(0);
				if (!"X".equals(vo.getBkgStsCd()) && !"A".equals(vo.getBkgStsCd()) && !"S".equals(vo.getBkgStsCd())) sbActionCode.append("DN");
				// Log 테이블에 데이타가 있으면
				if (!"X".equals(vo.getBkgStsCd()) && !"A".equals(vo.getBkgStsCd()) && !"S".equals(vo.getBkgStsCd()) && "Y".equals(vo.getVMi())) sbActionCode.append("AC");

				vo.setActionCode(sbActionCode.toString());
				/***********************************************************
				 * AI TYPE 세팅
				 ***********************************************************/
				if (sbActionCode.toString().startsWith("DA")) {
					vo.setAiType("Delete");
				} else if (sbActionCode.toString().endsWith("DN")) {
					vo.setAiType("D/L");
				} else if (sbActionCode.toString().endsWith("AC")) {
					if ("Y".equals(vo.getVMi()) && "Y".equals(vo.getBMi())) {
						if ("Y".equals(vo.getAiFlag())) {
							vo.setAiType("Update");
						} else {
							vo.setAiType("N/A");
						}
					} else {
						vo.setAiType("Add");
					}
				}
				/***********************************************************
				 * 조회조건 중 AI Type별 조회 조회 쿼리로 못해서 여기서 로직으로 List 제거
				 ***********************************************************/
				if (!cndCstmsManifestAmendmentCondVO.getAiType().equals("") && !cndCstmsManifestAmendmentCondVO.getAiType().equals(vo.getAiType())) {
					list.remove(i);
					i--;
					continue;
				}
				/***********************************************************
				 * ActionCode Description 세팅
				 ***********************************************************/
				StringBuffer sbActionDesc = new StringBuffer();
				for (int j = 0; j < vo.getActionCode().length(); j = j + 2) {
					if ("DN".equals(vo.getActionCode().substring(j, j + 2))) {
						sbActionDesc.append("DownLoad");
					} else if ("AC".equals(vo.getActionCode().substring(j, j + 2))) {
						sbActionDesc.append("Add Transmit");
					} else if ("DA".equals(vo.getActionCode().substring(j, j + 2))) {
						sbActionDesc.append("DeActivate");
					} else if ("RA".equals(vo.getActionCode().substring(j, j + 2))) {
						sbActionDesc.append("ReActivate");
					} else if ("DC".equals(vo.getActionCode().substring(j, j + 2))) {
						sbActionDesc.append("Delete Transmit");
					}
					if (j + 2 < vo.getActionCode().length()) sbActionDesc.append("->");
				}
				vo.setActionDesc(sbActionDesc.toString());
			}
			// Total Count 세팅
			if (!"".equals(cndCstmsManifestAmendmentCondVO.getAiType()) && list.size() > 0) list.get(0).setMaxRows(list.size());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 캐나다 세관 Cancel 대상 적하 목록을 가져옴
	 *
	 * @param CndCstmsManifestAmendmentCondVO cndCstmsManifestAmendmentCondVO
	 * @return List<CstmsManifestAmendmentVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CstmsManifestAmendmentVO> searchDelManifestAmendment(CndCstmsManifestAmendmentCondVO cndCstmsManifestAmendmentCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cndCstmsManifestAmendmentCondVO != null) {
				Map<String, String> mapVO = cndCstmsManifestAmendmentCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchDelManifestAmendmentRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsManifestAmendmentVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Receive History Detail
	 *
	 * @param CndCstmsRcvLogDtlCondVO cndCstmsRcvLogDtlCondVO
	 * @return List<CstmsRcvLogDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CstmsRcvLogDtlVO> searchCndCstmsRcvLogDtl(CndCstmsRcvLogDtlCondVO cndCstmsRcvLogDtlCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cndCstmsRcvLogDtlCondVO != null) {
				Map<String, String> mapVO = cndCstmsRcvLogDtlCondVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchCndCstmsRcvLogDtlRSQL(), param, null);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsRcvLogDtlVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * SendLog History Detail
	 *
	 * @param CndCstmsSndLogDtlCondVO cndCstmsSndLogDtlCondVO
	 * @return List<CndCstmsSndLogDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CndCstmsSndLogDtlVO> searchCndCstmsSndLogDtl(CndCstmsSndLogDtlCondVO cndCstmsSndLogDtlCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cndCstmsSndLogDtlCondVO != null) {
				Map<String, String> mapVO = cndCstmsSndLogDtlCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchCndCstmsSndLogDtlRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsSndLogDtlVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * SendLog Stowage History Detail
	 *
	 * @param CndCstmsSndLogDtlCondVO cndCstmsSndLogDtlCondVO
	 * @return List<CndCstmsSndLogDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CndCstmsSndLogDtlVO> searchCndCstmsSndStwgLogDtl(CndCstmsSndLogDtlCondVO cndCstmsSndLogDtlCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cndCstmsSndLogDtlCondVO != null) {
				Map<String, String> mapVO = cndCstmsSndLogDtlCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchCndCstmsSndSwgLogDtlRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsSndLogDtlVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ACI Report
	 *
	 * @param CndCstmsTrsmRsltListCondVO cndCstmsTrsmRsltListCondVO
	 * @return List<CstmsTrsmRsltVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CstmsTrsmRsltVO> searchCndCstmsTrsmRsltList(CndCstmsTrsmRsltListCondVO cndCstmsTrsmRsltListCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cndCstmsTrsmRsltListCondVO != null) {
				if (!"".equals(cndCstmsTrsmRsltListCondVO.getCstmsAckProcRsltCd())) {
					String tempAckProcRsltCd = "'"+cndCstmsTrsmRsltListCondVO.getCstmsAckProcRsltCd().replaceAll(" ", "").replaceAll(",", "', '")+"'";
					cndCstmsTrsmRsltListCondVO.setCstmsAckProcRsltCd(tempAckProcRsltCd);
				}
				Map<String, String> mapVO = cndCstmsTrsmRsltListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchCndCstmsTrsmRsltListRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsTrsmRsltVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * FlatFile 생성을 위한 BL 정보
	 *
	 * @param CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO
	 * @return BlInfoForFlatFileVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BlInfoForFlatFileVO searchBlInfoForFlatFile(CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cstmsManifestAmendmentVO != null) {
				Map<String, String> mapVO = cstmsManifestAmendmentVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchBlInfoForFlatFileRSQL(), param, null);
			List<BlInfoForFlatFileVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BlInfoForFlatFileVO.class);
			return list.size() > 0 ? list.get(0) : null;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * FlatFile 생성을 위한 Container 정보
	 *
	 * @param CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO
	 * @return List<CntrInfoForFlatFileVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CntrInfoForFlatFileVO> searchCntrInfoForFlatFile(CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cstmsManifestAmendmentVO != null) {
				Map<String, String> mapVO = cstmsManifestAmendmentVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchCntrInfoForFlatFileRSQL(), param, null);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CntrInfoForFlatFileVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * FlatFile 생성을 위한 Seal No. 정보
	 *
	 * @param CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO
	 * @return List<SealNoInfoForFlatFileVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SealNoInfoForFlatFileVO> searchSealNoInfoForFlatFile(CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cstmsManifestAmendmentVO != null) {
				Map<String, String> mapVO = cstmsManifestAmendmentVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchSealNoInfoForFlatFileRSQL(), param, null);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, SealNoInfoForFlatFileVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * FlatFile 생성을 위한 CM 정보
	 *
	 * @param CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO
	 * @return List<CmInfoForFlatFileVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CmInfoForFlatFileVO> searchCmInfoForFlatFile(CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cstmsManifestAmendmentVO != null) {
				Map<String, String> mapVO = cstmsManifestAmendmentVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchCmInfoForFlatFileRSQL(), param, null);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CmInfoForFlatFileVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_ADV_EDI_BL_RSPN
	 *
	 * @param List<BkgCstmsAdvEdiBlRspnVO> bkgCstmsAdvEdiBlRspnVOList
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvEdiBlRspn(List<BkgCstmsAdvEdiBlRspnVO> bkgCstmsAdvEdiBlRspnVOList) throws DAOException {
		try {
			if (bkgCstmsAdvEdiBlRspnVOList != null && bkgCstmsAdvEdiBlRspnVOList.size() > 0) {
				int rsltCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndExpCustomsTransmissionDBDAOaddBkgCstmsAdvEdiBlRspnCSQL(), bkgCstmsAdvEdiBlRspnVOList, null);
				for (int i = 0; i < rsltCnt.length; i++) {
					if (rsltCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_ADV_RCV_LOG 등록
	 *
	 * @param List<BkgCstmsAdvRcvLogVO> bkgCstmsAdvRcvLogVOList
	 */
	public void addBkgCstmsAdvRcvLog(List<BkgCstmsAdvRcvLogVO> bkgCstmsAdvRcvLogVOList) {
		try {
			if (bkgCstmsAdvRcvLogVOList.size() > 0) {
				int rsltCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndExpCustomsTransmissionDBDAOaddBkgCstmsAdvRcvLogCSQL(), bkgCstmsAdvRcvLogVOList, null);
				for (int i = 0; i < rsltCnt.length; i++) {
					if (rsltCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
	}

	/**
	 * BKG_CSTMS_ADV_RCV_LOG_DTL 등록
	 *
	 * @param List<BkgCstmsAdvRcvLogDtlVO> bkgCstmsAdvRcvLogDtlVOList
	 */
	public void addBkgCstmsAdvRcvLogDtl(List<BkgCstmsAdvRcvLogDtlVO> bkgCstmsAdvRcvLogDtlVOList) {
		try {
			if (bkgCstmsAdvRcvLogDtlVOList.size() > 0) {
				int rsltCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndExpCustomsTransmissionDBDAOaddBkgCstmsAdvRcvLogDtlCSQL(), bkgCstmsAdvRcvLogDtlVOList, null);
				for (int i = 0; i < rsltCnt.length; i++) {
					if (rsltCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
	}

	/**
	 * 수신 로그 일련번호
	 *
	 * @param BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO
	 * @return String
	 */
	public String searchMaxRcvLogSeq(BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		String sSeq = "1";

		try {
			if (bkgCstmsAdvRcvLogVO != null) {
				Map<String, String> mapVO = bkgCstmsAdvRcvLogVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchMaxRcvSeqRSQL(), param, null);
			if (dbRowset.next()) sSeq = dbRowset.getString(1);

		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return sSeq;
	}

	/**
	 * BKG_CSTMS_ADV_SND_LOG 수정
	 *
	 * @param List<BkgCstmsAdvSndLogVO> bkgCstmsAdvSndLogVOList
	 */
	public void modifyBkgCstmsAdvSndLog(List<BkgCstmsAdvSndLogVO> bkgCstmsAdvSndLogVOList) {
		try {
			if (bkgCstmsAdvSndLogVOList.size() > 0) {
				int rsltCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndExpCustomsTransmissionDBDAOmodifyBkgCstmsAdvSndLogUSQL(), bkgCstmsAdvSndLogVOList, null);
				for (int i = 0; i < rsltCnt.length; i++) {
					if (rsltCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
	}

	/**
	 * BL batch No 조회
	 * 
	 * @param String cstmsBatNo
	 * @return CndCstmsBlByKeyVO
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CndCstmsBlByKeyVO searchCndCstmsBlByKey(String cstmsBatNo) {
		Map<String, Object> param = new HashMap<String, Object>();
		CndCstmsBlByKeyVO cndCstmsBlByKeyVO = null;

		try {
			param.put("cstms_bat_no", cstmsBatNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchCndCstmsBlByKeyRSQL(), param, null);
			List<CndCstmsBlByKeyVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsBlByKeyVO.class);
			if (list.size() > 0) cndCstmsBlByKeyVO = list.get(0);

		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return cndCstmsBlByKeyVO;
	}

	/**
	 * VVD batch No 조회
	 *
	 * @param String cstmsBatNo
	 * @return BkgCstmsCndVslVO
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BkgCstmsCndVslVO searchCndCstmsVvdByKey(String cstmsBatNo) {
		Map<String, Object> param = new HashMap<String, Object>();
		BkgCstmsCndVslVO bkgCstmsCndVslVO = null;

		try {
			param.put("cstms_bat_no", cstmsBatNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchCndCstmsVvdByKeyRSQL(), param, null);
			List<BkgCstmsCndVslVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsCndVslVO.class);
			if (list.size() > 0) bkgCstmsCndVslVO = list.get(0);

		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return bkgCstmsCndVslVO;
	}

	/**
	 * Manifest Transmit(MI)전송을 위한 BL Count정보 상위그리드<br>
	 *
	 * @param CndCstmsManifestCondVO cndCstmsManifestCondVO
	 * @return List<CstmsManifestVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CstmsManifestVO> searchCndCstmsManifest(CndCstmsManifestCondVO cndCstmsManifestCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cndCstmsManifestCondVO != null) {
				Map<String, String> mapVO = cndCstmsManifestCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchCndCstmsManifestRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsManifestListVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ManifestList 상세정보
	 *
	 * @param CndCstmsManifestCondVO cndCstmsManifestCondVO
	 * @return List<CstmsManifestVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CstmsManifestVO> searchCndCstmsManifestDtl(CndCstmsManifestCondVO cndCstmsManifestCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<CstmsManifestVO> list = null;

		try {
			if (cndCstmsManifestCondVO != null) {
				Map<String, String> mapVO = cndCstmsManifestCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchCndCstmsManifestDtlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsManifestDtlListVO.class);

			if (list.size() > 0) {
				int iHblCnt = 0;
				int iMbl1Cnt = 0;
				int iMbl2Cnt = 0;
				int iMbl3Cnt = 0;
				int iBlTotCnt = 0;
				String blNo = "";
				int iBlCnt = 0;
				int iTemp = 0;
				for (int i=0; i<list.size(); i++) {
					CndCstmsManifestDtlListVO cndCstmsManifestDtlListVO = (CndCstmsManifestDtlListVO) list.get(i);
					if (!blNo.equals(cndCstmsManifestDtlListVO.getBlNo())) {
						blNo = cndCstmsManifestDtlListVO.getBlNo();
						iBlCnt++;
						cndCstmsManifestDtlListVO.setBlCnt("" + iBlCnt);
						// H/BL Count
						if ("H".equals(cndCstmsManifestDtlListVO.getMh())) {
							iHblCnt++;
							continue;
						}
						if ("1".equals(cndCstmsManifestDtlListVO.getCstmsFileTpCd())) {
							iMbl1Cnt++;
						} else if ("2".equals(cndCstmsManifestDtlListVO.getCstmsFileTpCd())) {
							iMbl2Cnt++;
						} else if ("3".equals(cndCstmsManifestDtlListVO.getCstmsFileTpCd())) {
							iMbl3Cnt++;
						} else {
							iTemp++;
						}
					} else {
						cndCstmsManifestDtlListVO.setBlCnt("" + iBlCnt);
					}
				}
				iBlTotCnt = iHblCnt + iMbl1Cnt + iMbl2Cnt + iMbl3Cnt + iTemp;
				CndCstmsManifestDtlListVO cndCstmsManifestDtlListVO = (CndCstmsManifestDtlListVO) list.get(0);
				cndCstmsManifestDtlListVO.setHblCount(String.valueOf(iHblCnt));
				cndCstmsManifestDtlListVO.setMbl1Count(String.valueOf(iMbl1Cnt));
				cndCstmsManifestDtlListVO.setMbl2Count(String.valueOf(iMbl2Cnt));
				cndCstmsManifestDtlListVO.setMbl3Count(String.valueOf(iMbl3Cnt));
				cndCstmsManifestDtlListVO.setBlTotCount(String.valueOf(iBlTotCnt));
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Local Time
	 *
	 * @param String podCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchLocalTime(String podCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("pod_cd", podCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchLocalTimeRSQL(), param, null);
			return dbRowset.next() ? dbRowset.getString(1) : "";

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * crr_bat_no 로 BL정보 조회
	 *
	 * @param String crrBatNo
	 * @return List<CndCstmsBlByKeyVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CndCstmsBlByKeyVO> searchBlForCrrBatNo(String crrBatNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("crr_bat_no", crrBatNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchBlForCrrBatNoRSQL(), param, null);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsBlByKeyVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Vessel Stowage Plan - Exclude Canada Import정보를 조회한다.
	 *
	 * @param StiCondListCndVO stiCondListCndVO
	 * @return List<StiDetailCndVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<StiDetailCndVO> searchStiListAtCnd(StiCondListCndVO stiCondListCndVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (stiCondListCndVO != null) {
				Map<String, String> mapVO = stiCondListCndVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchStiListAtCndRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, StiDetailCndVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Vessel Stowage Plan VVD값을 입력할 때, Last Port을 조회한다 .<br>
	 *
	 * @param String vvd
	 * @return List<StiDetailCndVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<StiDetailCndVO> searchLastForeignPort(String vvd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("vvd", vvd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchLastForeignPortRSQL(), param, null);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, StiDetailCndVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Vessel Stowage Plan Transmit 할때, Vessel Info를 조회한다.
	 *
	 * @param VesselEtaCondCndVO vesselEtaCondCndVO
	 * @return VesselEtaInfoCndVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public VesselEtaInfoCndVO searchVesselEta(VesselEtaCondCndVO vesselEtaCondCndVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vesselEtaCondCndVO != null) {
				Map<String, String> mapVO = vesselEtaCondCndVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchVesselEtaRSQL(), param, velParam);
			List<VesselEtaInfoCndVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, VesselEtaInfoCndVO.class);
			return (list != null && list.size() > 0) ? list.get(0) : null;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Vessel Stowage Plan Transmit 할때, Container별 Bay Info를 조회한다.
	 *
	 * @param BayPlanCntrListConCndVO bayPlanCntrListCondCndVO
	 * @return BayPlanCntrDetailCndVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BayPlanCntrDetailCndVO searchBayPlanCntrList(BayPlanCntrListConCndVO bayPlanCntrListCondCndVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bayPlanCntrListCondCndVO != null) {
				Map<String, String> mapVO = bayPlanCntrListCondCndVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchBayPlanCntrListRSQL(), param, null);
			List<BayPlanCntrDetailCndVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BayPlanCntrDetailCndVO.class);
			return (list != null && list.size() > 0) ? list.get(0) : null;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Vessel Stowage Plan Transmit 할때,  Last Pol을 조회한다.
	 *
	 * @param BayPlanCntrListConCndVO bayPlanCntrListCondCndVO
	 * @return BayPlanPolDetailVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BayPlanPolDetailVO searchBayPlanPolInfo(BayPlanCntrListConCndVO bayPlanCntrListCondCndVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (bayPlanCntrListCondCndVO != null) {
				Map<String, String> mapVO = bayPlanCntrListCondCndVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchBayPlanPolInfoRSQL(), param, null);
			List<BayPlanPolDetailVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BayPlanPolDetailVO.class);
			return (list != null && list.size() > 0) ? list.get(0) : null;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 1023_02화면, 화면이 열리면 자동으로 양쪽 방향의 CRN을 조회한다 .<br>
	 *
	 * @param String vvd
	 * @param String vpsPortCd
	 * @param String clptIndSeq
	 * @return List<StiDetailCndVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<StiDetailCndVO> searchCrnNo(String vvd, String vpsPortCd, String clptIndSeq) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("vvd", vvd);
			param.put("vps_port_cd", vpsPortCd);
			param.put("clpt_ind_seq", clptIndSeq);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchCrnNoRSQL(), param, null);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, StiDetailCndVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Vsl_cd가 등록된 BKG_BOOKING로 부터 LANE 정보를 조회한다.
	 *
	 * @param String vvd
	 * @return String
	 */
	public String searchSvcLane(String vvd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchSvcLaneRSQL(), param, null);
			return dbRowset.next() ? dbRowset.getString(1) : "";

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MDM_VSL_CNTR 정보를 조회한다.
	 *
	 * @param String vvd
	 * @return MdmVslCntrVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MdmVslCntrVO searchVslInfo(String vvd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchMdmVslCntrRSQL(), param, null);
			List<MdmVslCntrVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmVslCntrVO.class);
			return (list != null && list.size() > 0) ? list.get(0) : null;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Sysdate 를 조회한다.
	 *
	 * @return String
	 */
	public String searchSysdate() {
		String retVal = "";

		try {
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOselectSysdateRSQL(), null, null);
			if (dbRowset.next()) dbRowset.getString(1);

		} catch (Exception ex) {
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return retVal;
	}

	/**
	 * bkg_cstms_adv_snd_log.crr_bat_no 를 Setup 하기 위해 새로운 번호를 조회한다.
	 *
	 * @return String
	 * @throws DAOException
	 */
	public String searchDateSeq() throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchDateSeqRSQL(), param, velParam);
			return dbRowset.next() ? dbRowset.getString(1) : "";

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_ADV_STWG_SND_LOG 테이블에 로그를 입력한다.<br>
	 *
	 * @param SendDetailLogCndVO sendDetailLogVO
	 * @return int
	 * @throws DAOException
	 */
	public int addStowageSendLog(SendDetailLogCndVO sendDetailLogVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sendDetailLogVO != null) {
				Map<String, String> mapVO = sendDetailLogVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpCustomsTransmissionDBDAOaddStowageSendLogCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
			return result;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_ADV_STWG_SND_DTL 테이블에 로그를 입력한다.<br>
	 *
	 * @param SendDetailLogCndVO sendDetailLogVO
	 * @return int
	 * @throws DAOException
	 */
	public int addSendDetailLog(SendDetailLogCndVO sendDetailLogVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;

		try {
			if (sendDetailLogVO != null) {
				Map<String, String> mapVO = sendDetailLogVO.getColumnValues();
				param.putAll(mapVO);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpCustomsTransmissionDBDAOaddSendDetailLogCSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
			return result;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_ADV_STWG_CNTR 테이블에 로그를 갱신한다.<br>
	 *
	 * @param SendLogDetailCndVO sendLogDetailVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifySendLogByCntr(SendLogDetailCndVO sendLogDetailVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			if (sendLogDetailVO != null) {
				Map<String, String> mapVO = sendLogDetailVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpCustomsTransmissionDBDAOmodifySendLogByCntrUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
			return result;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_ADV_STWG_CNTR 테이블에 로그를 입력(Insert)한다.<br>
	 *
	 * @param SendLogDetailCndVO sendLogDetailVO
	 * @return int
	 * @throws DAOException
	 */
	public int addSendLogByCntr(SendLogDetailCndVO sendLogDetailVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			if (sendLogDetailVO != null) {
				Map<String, String> mapVO = sendLogDetailVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpCustomsTransmissionDBDAOAddSendLogByCntrCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
			return result;

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 수신 msg 의 ORG_FF_REF_NO로 관련 데이터 구한다.<br>
	 *
	 * @param String orgRefNo
	 * @return BkgCstmsAdvRcvLogVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BkgCstmsAdvRcvLogVO searchCusResDataBySndId(String orgRefNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("crr_bat_no", orgRefNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchCusResDataBySndIdRSQL(), param, null);
			List<BkgCstmsAdvRcvLogVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvRcvLogVO.class);
			return (list != null && list.size() > 0) ? list.get(0) : null;

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * STOWAGE SEND LOG 테이블 업데이트
	 *
	 * @param SendDetailLogCndVO sendDetailLogVO
	 * @return int
	 */
	public int modifyBaplieCusResSndLog(SendDetailLogCndVO sendDetailLogVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;

		try {
			if (sendDetailLogVO != null) {
				Map<String, String> mapVO = sendDetailLogVO.getColumnValues();
				param.putAll(mapVO);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpCustomsTransmissionDBDAOmodifyBaplieCusResSndLogUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");

		} catch (Exception ex) {
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return result;
	}

	/**
	 * ERROR_DETAIL 루프 내, Cntr_no error result 별 업데이트
	 *
	 * @param SendDetailLogCndVO sendDetailLogVO
	 * @return int
	 */
	public int modifyBaplieCusResByCntr(SendDetailLogCndVO sendDetailLogVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;

		try {
			if (sendDetailLogVO != null) {
				Map<String, String> mapVO = sendDetailLogVO.getColumnValues();
				param.putAll(mapVO);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpCustomsTransmissionDBDAOmodifyBaplieCusResByCntrCSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");

		} catch (Exception ex) {
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return result;

	}

	/**
	 * STOWAGE CNTR 테이블 수신 메소드 수행
	 *
	 * @param SendDetailLogCndVO sendDetailLogVO
	 * @return int
	 */
	public int modifyBaplieCusResByVvd(SendDetailLogCndVO sendDetailLogVO) {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;

		try {
			if (sendDetailLogVO != null) {
				Map<String, String> mapVO = sendDetailLogVO.getColumnValues();
				param.putAll(mapVO);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new CndExpCustomsTransmissionDBDAOmodifyBaplieCusResByVvdUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");

		} catch (Exception ex) {
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return result;
	}

	/**
	 * Vessel Stowage Plan Transmit 할때, Container별 Bay Info를 조회한다.
	 *
	 * @param BayPlanCntrListConCndVO bayPlanCntrListCondCndVO
	 * @return List<BayPlanCntrDetailCndVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BayPlanCntrDetailCndVO> searchBayPlanCntrCmList(BayPlanCntrListConCndVO bayPlanCntrListCondCndVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bayPlanCntrListCondCndVO.getColumnValues();
			param.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchBayPlanCntrCmListRSQL(), param, null);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, BayPlanCntrDetailCndVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * SendLog History
	 *
	 * @param CndCstmsSndHisListCondVO cndCstmsSndHisListCondVO
	 * @return List<CndCstmsSndHisVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CndCstmsSndHisVO> searchCndCstmsSndHisList(CndCstmsSndHisListCondVO cndCstmsSndHisListCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cndCstmsSndHisListCondVO != null) {
				Map<String, String> mapVO = cndCstmsSndHisListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchCndCstmsSndHisListRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsSndHisVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Receive History
	 *
	 * @param CndCstmsRcvHisListCondVO cndCstmsRcvHisListCondVO
	 * @return List<CstmsRcvHisVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CstmsRcvHisVO> searchCndCstmsRcvHisList(CndCstmsRcvHisListCondVO cndCstmsRcvHisListCondVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cndCstmsRcvHisListCondVO != null) {
				Map<String, String> mapVO = cndCstmsRcvHisListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndExpCustomsTransmissionDBDAOsearchCndCstmsRcvHisListRSQL(), param, velParam);
			return (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsRcvHisVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	} 

}
