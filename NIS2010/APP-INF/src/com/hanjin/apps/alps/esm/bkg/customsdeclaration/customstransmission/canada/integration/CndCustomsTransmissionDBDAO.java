/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CndCustomsTransmissionDBDAO.java
 *@FileTitle : CustomsTransmission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.sql.SQLException; 
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.basic.CndCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BayPlanCntrDetailCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BayPlanCntrListConCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BayPlanPolDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.BlInfoForFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CmInfoForFlatFileVO;
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
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgCstmsAdvBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvEdiBlRspnVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRcvLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRcvLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvSndLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvSndLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsCndVslVO;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;

/** 
 * NIS2010 CndCustomsTransmissionDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Min Jeong
 * @see CndCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4 
 */
public class CndCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Vessel Arrival 정보조회
	 * 
	 * @param cndVesselArrivalTransmitVO 조회조건
	 * @return CndVesselArrivalTransmitVO 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CndVesselArrivalTransmitVO searchVesselArrival(CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO)
			throws DAOException {
		CndVesselArrivalTransmitVO iVO = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndVesselArrivalTransmitVO.getBlNo() == null || "".equals(cndVesselArrivalTransmitVO.getBlNo()))
			{
				Map<String, String> mapVO = cndVesselArrivalTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchVesselArrivalRSQL(), param, velParam);
			} else {
				// ESM_BKG_0002(MI화면)에서 Vessel 의 CRN No.가 없을때 에러처리
				param.put("bl_no", cndVesselArrivalTransmitVO.getBlNo());
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchVesselArrival2RSQL(), param, null);
			}
			List<CndVesselArrivalTransmitVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,	CndVesselArrivalTransmitVO.class);
			if (list != null && list.size() > 0)
			{
				iVO = (CndVesselArrivalTransmitVO) list.get(list.size() - 1);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return iVO;
	}

	/**
	 * Vessel Arrival 정보조회
	 * 
	 * @param cndVesselArrivalTransmitVO 조회조건
	 * @return CndVesselArrivalTransmitVO 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CndVesselArrivalTransmitVO searchExportVesselArrival(CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO)
			throws DAOException {
		CndVesselArrivalTransmitVO iVO = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			// ESM_BKG_0006(MI화면)에서 Vessel 의 CRN No.가 없을때 에러처리
			param.put("bl_no", cndVesselArrivalTransmitVO.getBlNo());
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchExportVesselArrivalRSQL(), param, null);
			List<CndVesselArrivalTransmitVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,	CndVesselArrivalTransmitVO.class);
			if (list != null && list.size() > 0)
			{
				iVO = (CndVesselArrivalTransmitVO) list.get(list.size() - 1);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return iVO;
	}

	
	/**
	 * 선적항, 출항일, 양하항, 양하일 조회<br>
	 * 도착직전 port를 조회하는것 같은데 의미없는 값을 조회함(as-is). 향후 검토필요
	 * 
	 * @param cndVesselArrivalTransmitVO 조회조건
	 * @return CndVesselArrivalTransmitVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CndVesselArrivalTransmitVO searchPolPod(CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO)
			throws DAOException {
		CndVesselArrivalTransmitVO iVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndVesselArrivalTransmitVO != null)
			{
				Map<String, String> mapVO = cndVesselArrivalTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchPolPodRSQL(), param, velParam);
			List<CndVesselArrivalTransmitVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					CndVesselArrivalTransmitVO.class);
			if (list != null && list.size() > 0)
			{
				iVO = (CndVesselArrivalTransmitVO) list.get(list.size() - 1);
			}
			else
			{
				iVO = new CndVesselArrivalTransmitVO();
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return iVO;
	}

	/**
	 * Model에 있어서 일단 삽입(의미는 없음)
	 * 
	 * @param cndVesselArrivalTransmitVO 조건
	 * @return CndVesselArrivalTransmitVO 
	 * @throws DAOException
	 */
	public CndVesselArrivalTransmitVO searchCndCstmsVvdSndLog(CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO)
			throws DAOException {
		return cndVesselArrivalTransmitVO;
	}

	/**
	 * Vessel Port 조회
	 * 
	 * @param cndVesselArrivalTransmitVO 조건
	 * @return List<CndVesselArrivalTransmitVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CndVesselArrivalTransmitVO> searchVesselPort(CndVesselArrivalTransmitVO cndVesselArrivalTransmitVO)
			throws DAOException {
		List<CndVesselArrivalTransmitVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndVesselArrivalTransmitVO != null)
			{
				Map<String, String> mapVO = cndVesselArrivalTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchVesselPortRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndVesselArrivalTransmitVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EDI Send 로그등록
	 * 
	 * @param bkgCstmsAdvSndLogs 로그정보
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvSndLog(List<BkgCstmsAdvSndLogVO> bkgCstmsAdvSndLogs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAdvSndLogs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CndCustomsTransmissionDBDAOaddBkgCstmsAdvSndLogCSQL(),
						bkgCstmsAdvSndLogs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * EDI Send Detail 로그
	 * 
	 * @param bkgCstmsAdvSndLogDtlVOs 로그상세정보
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvSndLogDtl(List<BkgCstmsAdvSndLogDtlVO> bkgCstmsAdvSndLogDtlVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (bkgCstmsAdvSndLogDtlVOs.size() > 0)
			{
				int updCnt[] = null;
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new CndCustomsTransmissionDBDAOaddBkgCstmsAdvSndLogDtlCSQL(),
						bkgCstmsAdvSndLogDtlVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 로그 일련번호
	 * 
	 * @param bkgCstmsAdvSndLogVO 조건
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxSndLogSeq(BkgCstmsAdvSndLogVO bkgCstmsAdvSndLogVO) throws DAOException {
		String sSeq = "1";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsAdvSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchLogSeqRSQL(), param, velParam);
			if (dbRowset.next())
				sSeq = dbRowset.getString(1);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sSeq;
	}

	/**
	 * 캐나다 세관 적하 목록 정정 대상을 가져옴
	 * 
	 * @param cndCstmsManifestAmendmentCondVO 조회조건
	 * @return List<CstmsManifestAmendmentVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsManifestAmendmentVO> searchCndCstmsManifestAmendment(
			CndCstmsManifestAmendmentCondVO cndCstmsManifestAmendmentCondVO) throws DAOException {
		List<CstmsManifestAmendmentVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
        String allSearch = "";		
		try
		{
			if (cndCstmsManifestAmendmentCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsManifestAmendmentCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("start_no", cndCstmsManifestAmendmentCondVO.getStartNo());
				param.put("end_no", cndCstmsManifestAmendmentCondVO.getEndNo());
				allSearch = cndCstmsManifestAmendmentCondVO.getAiType();				

				if (!"".equals(cndCstmsManifestAmendmentCondVO.getBkgNo())
						|| !"".equals(cndCstmsManifestAmendmentCondVO.getMblNo())
						|| !"".equals(cndCstmsManifestAmendmentCondVO.getVvdCd()))
				{
					// Vessel 스케줄 조회
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchMinClptSeqRSQL(), param, velParam);
					if (dbRowset.next())
					{
						param.put("min_seq", dbRowset.getString(1));
						velParam.put("min_seq", dbRowset.getString(1));
						param.put("vsl_skd_flg", dbRowset.getString(2));
						velParam.put("vsl_skd_flg", dbRowset.getString(2));
					}
				}
				//★Immediate Delete & AI(추가)
				if ("DAI".equals(cndCstmsManifestAmendmentCondVO.getAiGubun())) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCndCstmsManifestDeleteAmendmentRSQL(), param,velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsManifestAmendmentVO.class);
				} else {
				
					// 조회
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCndCstmsManifestAmendmentRSQL(), param,velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsManifestAmendmentVO.class);
					for (int i = 0; i < list.size(); i++)
					{
						StringBuffer sbActionCode = new StringBuffer();
						CndCstmsManifestAmendmentVO vo = (CndCstmsManifestAmendmentVO) list.get(i);
						// Total Count 세팅
						list.get(0).setMaxRows(Integer.parseInt(vo.getTotal()));
						/***********************************************************
						 * Action Code 세팅
						 ***********************************************************/
						if (!"D".equals(vo.getMfStsCd()))
						{
							if (("X".equals(vo.getBkgStsCd()) || "A".equals(vo.getBkgStsCd()) || "S".equals(vo.getBkgStsCd()) || !vo
									.getBVvdCd().equals(vo.getTVvdCd()))
									&& ("Y".equals(vo.getBMi())))
							{
								// BOOKING의 VVD와 BKC의 VVD가 다르고 전송한 적이 있다면
								sbActionCode.append("DADC");
							}
						}
						if (!"X".equals(vo.getBkgStsCd()) && !"A".equals(vo.getBkgStsCd()) && !"S".equals(vo.getBkgStsCd())
								&& ("D".equals(vo.getMfStsCd()) || sbActionCode.toString().indexOf("DA") != -1))
						{
							// 상태가
							sbActionCode.append("RA");
						}
						// 나올수가 없음
						if ("DARA".equals(sbActionCode.toString()))
						{
							sbActionCode.setLength(0);
						}
						if (!"X".equals(vo.getBkgStsCd()) && !"A".equals(vo.getBkgStsCd()) && !"S".equals(vo.getBkgStsCd()))
						{
							sbActionCode.append("DN");
						}
						if (!"X".equals(vo.getBkgStsCd()) && !"A".equals(vo.getBkgStsCd()) && !"S".equals(vo.getBkgStsCd())
								&& "Y".equals(vo.getVMi()))
						{
							// Log 테이블에 데이타가 있으면
							sbActionCode.append("AC");
						}
						vo.setActionCode(sbActionCode.toString());
						/***********************************************************
						 * AI TYPE 세팅
						 ***********************************************************/
						if (sbActionCode.toString().startsWith("DA"))
						{
							vo.setAiType("Delete");
						}
						else if (sbActionCode.toString().endsWith("DN"))
						{
							vo.setAiType("D/L");
						}
						else if (sbActionCode.toString().endsWith("AC"))
						{
							// 2010.04.19  Update추가
							// Add:  V.EDI가 "Y"이고, B.EDI가 "N"인 경우
							// Update: V.EDI가 "Y"이고, B.EDI가 "Y"인 경우
							if ("Y".equals(vo.getVMi()) && "Y".equals(vo.getBMi()))
							{
								vo.setAiType("Update");
							}
							else
							{
								vo.setAiType("Add");
							}
						}
						
						/*
						 * 2014.06.20 AI 판단 FLAG 적용(BKG DATA가 변경 시만)
						 */
						if(!"".equals(allSearch) && "Update".equals(vo.getAiType()) && !"Y".equals(vo.getAiFlag()) ) {
							list.remove(i);
							i--;
							continue;
						}
						
						/***********************************************************
						 * 조회조건 중 AI Type별 조회 조회 쿼리로 못해서 여기서 로직으로 List 제거
						 ***********************************************************/
						if (!cndCstmsManifestAmendmentCondVO.getAiType().equals("")
								&& !cndCstmsManifestAmendmentCondVO.getAiType().equals(vo.getAiType()))
						{
							list.remove(i);
							i--;
							continue;
						}
						/***********************************************************
						 * ActionCode Description 세팅
						 ***********************************************************/
						StringBuffer sbActionDesc = new StringBuffer();
						for (int j = 0; j < vo.getActionCode().length(); j = j + 2)
						{
							if ("DN".equals(vo.getActionCode().substring(j, j + 2)))
							{
								sbActionDesc.append("DownLoad");
							}
							else if ("AC".equals(vo.getActionCode().substring(j, j + 2)))
							{
								sbActionDesc.append("Add Transmit");
							}
							else if ("DA".equals(vo.getActionCode().substring(j, j + 2)))
							{
								sbActionDesc.append("DeActivate");
							}
							else if ("RA".equals(vo.getActionCode().substring(j, j + 2)))
							{
								sbActionDesc.append("ReActivate");
							}
							else if ("DC".equals(vo.getActionCode().substring(j, j + 2)))
							{
								sbActionDesc.append("Delete Transmit");
							}
							if (j + 2 < vo.getActionCode().length())
							{
								sbActionDesc.append("->");
							}
						}
						vo.setActionDesc(sbActionDesc.toString());
					}
				}
				// Total Count 세팅
				if (!"".equals(cndCstmsManifestAmendmentCondVO.getAiType()) && list.size() > 0)
				{
					list.get(0).setMaxRows(list.size());
				}
			}//End of cndCstmsManifestAmendmentCondVO != null
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Receive History
	 * 
	 * @param cndCstmsRcvHisListCondVO 조회조건
	 * @return List<CstmsRcvHisVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsRcvHisVO> searchCndCstmsRcvHisList(CndCstmsRcvHisListCondVO cndCstmsRcvHisListCondVO)
			throws DAOException {
		List<CstmsRcvHisVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndCstmsRcvHisListCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsRcvHisListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCndCstmsRcvHisListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsRcvHisVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Receive History Detail
	 * 
	 * @param cndCstmsRcvLogDtlCondVO 조회조건
	 * @return List<CstmsRcvLogDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsRcvLogDtlVO> searchCndCstmsRcvLogDtl(CndCstmsRcvLogDtlCondVO cndCstmsRcvLogDtlCondVO)
			throws DAOException {
		List<CstmsRcvLogDtlVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndCstmsRcvLogDtlCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsRcvLogDtlCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCndCstmsRcvLogDtlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsRcvLogDtlVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * SendLog History
	 * 
	 * @param cndCstmsSndHisListCondVO 조회조건
	 * @return List<CstmsSndHisVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsSndHisVO> searchCndCstmsSndHisList(CndCstmsSndHisListCondVO cndCstmsSndHisListCondVO)
			throws DAOException {
		List<CstmsSndHisVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndCstmsSndHisListCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsSndHisListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCndCstmsSndHisListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsSndHisVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * SendLog History Detail
	 * 
	 * @param cndCstmsSndLogDtlCondVO 조건
	 * @return List<CstmsSndLogDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsSndLogDtlVO> searchCndCstmsSndLogDtl(CndCstmsSndLogDtlCondVO cndCstmsSndLogDtlCondVO)
			throws DAOException {
		List<CstmsSndLogDtlVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String trsmMsgTp = null;
		try
		{
			if (cndCstmsSndLogDtlCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsSndLogDtlCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				trsmMsgTp = cndCstmsSndLogDtlCondVO.getTrsmMsgTpId();
			}
			
			if ("BAPLIE".equals(trsmMsgTp))
			{
				dbRowset = new SQLExecuter("DEFAULT").executeQuery(
						(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCndCstmsSndSwgLogDtlRSQL(), param, velParam);
			}
			else
			{
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCndCstmsSndLogDtlRSQL(), param, velParam);
			}
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsSndLogDtlVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * ACI Report
	 * 
	 * @param cndCstmsTrsmRsltListCondVO 조건
	 * @return List<CstmsTrsmRsltVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsTrsmRsltVO> searchCndCstmsTrsmRsltList(CndCstmsTrsmRsltListCondVO cndCstmsTrsmRsltListCondVO)
			throws DAOException {
		List<CstmsTrsmRsltVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndCstmsTrsmRsltListCondVO != null)
			{
				if (!"".equals(cndCstmsTrsmRsltListCondVO.getCstmsAckProcRsltCd()))
				{
					StringTokenizer st = new StringTokenizer(cndCstmsTrsmRsltListCondVO.getCstmsAckProcRsltCd(), ",");
					String[] arrCd = new String[st.countTokens()];
					int j = 0;
					while (st.hasMoreTokens())
					{
						arrCd[j] = st.nextToken();
						j++;
					}
					String sRsltCd = "";
					for (int i = 0; i < arrCd.length; i++)
					{
						if (i == 0)
						{
							sRsltCd = "'" + arrCd[i] + "'";
						}
						else
						{
							sRsltCd = sRsltCd + ",'" + arrCd[i] + "'";
						}
					}
					cndCstmsTrsmRsltListCondVO.setCstmsAckProcRsltCd(sRsltCd);
				}
				Map<String, String> mapVO = cndCstmsTrsmRsltListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				DBRowSet dbRowset = null;
				if (!"V".equals(cndCstmsTrsmRsltListCondVO.getRptFlag()))
				{
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchMinClptSeqRSQL(), param, velParam);
					if (dbRowset.next())
					{
						param.put("min_seq", dbRowset.getString(1));
						velParam.put("min_seq", dbRowset.getString(1));
					}
				}
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCndCstmsTrsmRsltListRSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsTrsmRsltVO.class);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * FlatFile 생성을 위한 BL 정보
	 * 
	 * @param cstmsManifestAmendmentVO 전송정보
	 * @return BlInfoForFlatFileVO 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BlInfoForFlatFileVO searchBlInfoForFlatFile(CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO)
			throws DAOException {
		BlInfoForFlatFileVO blInfoForFlatFileVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cstmsManifestAmendmentVO != null)
			{
				Map<String, String> mapVO = cstmsManifestAmendmentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchBlInfoForFlatFileRSQL(), param, velParam);
			List<BlInfoForFlatFileVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BlInfoForFlatFileVO.class);
			if (list.size() > 0)
			{
				blInfoForFlatFileVO = list.get(0);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return blInfoForFlatFileVO;
	}
	
	/**
	 * FlatFile 생성을 위한 BL 정보
	 * 
	 * @param cstmsManifestAmendmentVO 전송정보
	 * @return BlInfoForFlatFileVO 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BlInfoForFlatFileVO searchExportBlInfoForFlatFile(CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO)
			throws DAOException {
		BlInfoForFlatFileVO blInfoForFlatFileVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cstmsManifestAmendmentVO != null)
			{
				Map<String, String> mapVO = cstmsManifestAmendmentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchExportBlInfoForFlatFileRSQL(), param, velParam);
			List<BlInfoForFlatFileVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BlInfoForFlatFileVO.class);
			if (list.size() > 0)
			{
				blInfoForFlatFileVO = list.get(0);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return blInfoForFlatFileVO;
	}

	/**
	 * FlatFile 생성을 위한 Container 정보
	 * 
	 * @param cstmsManifestAmendmentVO 전송정보
	 * @return List<CntrInfoForFlatFileVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrInfoForFlatFileVO> searchCntrInfoForFlatFile(CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO)
			throws DAOException {
		List<CntrInfoForFlatFileVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cstmsManifestAmendmentVO != null)
			{
				Map<String, String> mapVO = cstmsManifestAmendmentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCntrInfoForFlatFileRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrInfoForFlatFileVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * FlatFile 생성을 위한 Container 정보
	 * 
	 * @param cstmsManifestAmendmentVO 전송정보
	 * @return List<CntrInfoForFlatFileVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrInfoForFlatFileVO> searchExportCntrInfoForFlatFile(CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO)
			throws DAOException {
		List<CntrInfoForFlatFileVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cstmsManifestAmendmentVO != null)
			{
				Map<String, String> mapVO = cstmsManifestAmendmentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchExportCntrInfoForFlatFileRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrInfoForFlatFileVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	

	
	/**
	 * FlatFile 생성을 위한 Seal No. 정보
	 * 
	 * @param cstmsManifestAmendmentVO 전송정보
	 * @return List<SealNoInfoForFlatFileVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SealNoInfoForFlatFileVO> searchSealNoInfoForFlatFile(
			CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO) throws DAOException {
		List<SealNoInfoForFlatFileVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cstmsManifestAmendmentVO != null)
			{
				Map<String, String> mapVO = cstmsManifestAmendmentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchSealNoInfoForFlatFileRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SealNoInfoForFlatFileVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * FlatFile 생성을 위한 Seal No. 정보
	 * 
	 * @param cstmsManifestAmendmentVO 전송정보
	 * @return List<SealNoInfoForFlatFileVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SealNoInfoForFlatFileVO> searchExportSealNoInfoForFlatFile(
			CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO) throws DAOException {
		List<SealNoInfoForFlatFileVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cstmsManifestAmendmentVO != null)
			{
				Map<String, String> mapVO = cstmsManifestAmendmentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchExportSealNoInfoForFlatFileRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SealNoInfoForFlatFileVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	
	/**
	 * FlatFile 생성을 위한 CM 정보
	 * 
	 * @param cstmsManifestAmendmentVO 전송정보
	 * @return List<CmInfoForFlatFileVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CmInfoForFlatFileVO> searchCmInfoForFlatFile(CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO)
			throws DAOException {
		List<CmInfoForFlatFileVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cstmsManifestAmendmentVO != null)
			{
				Map<String, String> mapVO = cstmsManifestAmendmentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCmInfoForFlatFileRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CmInfoForFlatFileVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * FlatFile 생성을 위한 CM 정보
	 * 
	 * @param cstmsManifestAmendmentVO 전송정보
	 * @return List<CmInfoForFlatFileVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CmInfoForFlatFileVO> searchExportCmInfoForFlatFile(CndCstmsManifestAmendmentVO cstmsManifestAmendmentVO)
			throws DAOException {
		List<CmInfoForFlatFileVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cstmsManifestAmendmentVO != null)
			{
				Map<String, String> mapVO = cstmsManifestAmendmentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchExportCmInfoForFlatFileRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CmInfoForFlatFileVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	
	/**
	 * BKG_CSTMS_ADV_EDI_BL_RSPN
	 * 
	 * @param bkgCstmsAdvEdiBlRspnVOs BKG_CSTMS_ADV_EDI_BL_RSPN정보
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvEdiBlRspn(List<BkgCstmsAdvEdiBlRspnVO> bkgCstmsAdvEdiBlRspnVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (bkgCstmsAdvEdiBlRspnVOs != null && bkgCstmsAdvEdiBlRspnVOs.size() > 0)
			{
				int updCnt[] = null;
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new CndCustomsTransmissionDBDAOaddBkgCstmsAdvEdiBlRspnCSQL(),
						bkgCstmsAdvEdiBlRspnVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_ADV_RCV_LOG 등록
	 * 
	 * @param bkgCstmsAdvRcvLogVOs 로그정보
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvRcvLog(List<BkgCstmsAdvRcvLogVO> bkgCstmsAdvRcvLogVOs) {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (bkgCstmsAdvRcvLogVOs.size() > 0)
			{
				int updCnt[] = null;
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CndCustomsTransmissionDBDAOaddBkgCstmsAdvRcvLogCSQL(),
						bkgCstmsAdvRcvLogVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
		}
	}

	/**
	 * BKG_CSTMS_ADV_RCV_LOG_DTL 등록
	 * 
	 * @param bkgCstmsAdvRcvLogDtlVOs 로그상세
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvRcvLogDtl(List<BkgCstmsAdvRcvLogDtlVO> bkgCstmsAdvRcvLogDtlVOs) {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (bkgCstmsAdvRcvLogDtlVOs.size() > 0)
			{
				int updCnt[] = null;
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new CndCustomsTransmissionDBDAOaddBkgCstmsAdvRcvLogDtlCSQL(),
						bkgCstmsAdvRcvLogDtlVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
		}
	}

	/**
	 * 수신 로그 일련번호
	 * 
	 * @param bkgCstmsAdvRcvLogVO 로그정보
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxRcvLogSeq(BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO) {
		String sSeq = "1";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsAdvRcvLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchMaxRcvSeqRSQL(), param, velParam);
			if (dbRowset.next())
				sSeq = dbRowset.getString(1);
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
		}
		return sSeq;
	}

	/**
	 * BKG_CSTMS_ADV_SND_LOG 수정
	 * 
	 * @param bkgCstmsAdvSndLogVOs 로그정보
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAdvSndLog(List<BkgCstmsAdvSndLogVO> bkgCstmsAdvSndLogVOs) {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (bkgCstmsAdvSndLogVOs.size() > 0)
			{
				int updCnt[] = null;
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new CndCustomsTransmissionDBDAOmodifyBkgCstmsAdvSndLogUSQL(),
						bkgCstmsAdvSndLogVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
		}
	}

	/**
	 * BL batch No 조회
	 * @param cstmsBatNo batch No 
	 * @return BkgCstmsAdvBlVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsAdvBlVO searchCndCstmsBlByKey(String cstmsBatNo) {
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO = null;
		try
		{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("cstms_bat_no", cstmsBatNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCndCstmsBlByKeyRSQL(), param, null);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvBlVO.class);
			if (list.size() > 0)
			{
				bkgCstmsAdvBlVO = (BkgCstmsAdvBlVO) list.get(0);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
		}
		return bkgCstmsAdvBlVO;
	}

	/**
	 * VVD batch No 조회
	 * 
	 * @param cstmsBatNo batch No 
	 * @return BkgCstmsCndVslVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsCndVslVO searchCndCstmsVvdByKey(String cstmsBatNo) {
		BkgCstmsCndVslVO bkgCstmsCndVslVO = null;
		try
		{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("cstms_bat_no", cstmsBatNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCndCstmsVvdByKeyRSQL(), param, null);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsCndVslVO.class);
			if (list.size() > 0)
			{
				bkgCstmsCndVslVO = (BkgCstmsCndVslVO) list.get(0);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
		}
		return bkgCstmsCndVslVO;
	}
	
	/**
	 * Manifest Transmit(MI)전송을 위한 BL Count정보 상위그리드<br>
	 * UI_BKG_0002
	 * 
	 * @param cndCstmsManifestCondVO 조회조건
	 * @return List<CstmsManifestVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsManifestVO> searchCndCstmsManifest(CndCstmsManifestCondVO cndCstmsManifestCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CstmsManifestVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndCstmsManifestCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsManifestCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCndCstmsManifestRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsManifestListVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * Canada Export EDI 전송을 위한 BL Count정보 상위그리드<br>
	 * UI_BKG_0006
	 * 
	 * @param CndCstmsManifestCondVO 조회조건
	 * @return List<CstmsManifestVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsManifestVO> searchCndCstmsExportManifest(CndCstmsManifestCondVO cndCstmsManifestCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstmsManifestVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndCstmsManifestCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsManifestCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCndCstmsExportManifestRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsManifestListVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ManifestList 상세정보
	 * 
	 * @param cndCstmsManifestCondVO 조회조건
	 * @return List<CstmsManifestVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsManifestVO> searchCndCstmsManifestDtl(CndCstmsManifestCondVO cndCstmsManifestCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CstmsManifestVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndCstmsManifestCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsManifestCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCndCstmsManifestDtlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsManifestDtlListVO.class);
			if (list.size() > 0)
			{
				int iHblCnt = 0;
				int iMbl1Cnt = 0;
				int iMbl2Cnt = 0;
				int iMbl3Cnt = 0;
				int iBlTotCnt = 0;
				String blNo = "";
				int iBlCnt = 0;
				int iTemp = 0;
				for (int i = 0; i < list.size(); i++)
				{
					CndCstmsManifestDtlListVO vo = (CndCstmsManifestDtlListVO) list.get(i);
					if (!blNo.equals(vo.getBlNo()))
					{
						blNo = vo.getBlNo();
						iBlCnt++;
						vo.setBlCnt("" + iBlCnt);
						// H/BL Count
						if ("H".equals(vo.getMh()))
						{
							iHblCnt++;
							continue;
						}
						if ("1".equals(vo.getCstmsFileTpCd()))
						{
							iMbl1Cnt++;
						}
						else if ("2".equals(vo.getCstmsFileTpCd()))
						{
							iMbl2Cnt++;
						}
						else if ("3".equals(vo.getCstmsFileTpCd()))
						{
							iMbl3Cnt++;
						}
						else
						{
							iTemp++;
						}
					}
					else
					{
						vo.setBlCnt("" + iBlCnt);
					}
				}
				iBlTotCnt = iHblCnt + iMbl1Cnt + iMbl2Cnt + iMbl3Cnt + iTemp;
				CndCstmsManifestDtlListVO detailVO = (CndCstmsManifestDtlListVO) list.get(0);
				detailVO.setHblCount(String.valueOf(iHblCnt));
				detailVO.setMbl1Count(String.valueOf(iMbl1Cnt));
				detailVO.setMbl2Count(String.valueOf(iMbl2Cnt));
				detailVO.setMbl3Count(String.valueOf(iMbl3Cnt));
				detailVO.setBlTotCount(String.valueOf(iBlTotCnt));
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Local Time 
	 * @param podCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchLocalTime(String podCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try
		{
			param.put("pod_cd", podCd);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchLocalTimeRSQL(), param, null);
			if (dbRowset.next())
			{
				return dbRowset.getString(1);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return "";
	}
	
	/**
	 * Local Time 
	 * @param podCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchExportLocalTime(String podCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try
		{
			param.put("pod_cd", podCd);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchExportLocalTimeRSQL(), param, null);
			if (dbRowset.next())
			{
				return dbRowset.getString(1);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return "";
	}

	/**
	 * 1023화면, Vessel Stowage Plan - Exclude Canada Import정보를 조회한다.
	 * 
	 * @param StiCondListCndVO stiCondListCndVO
	 * @return List<StiDetailCndVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<StiDetailCndVO> searchStiListAtCnd(StiCondListCndVO stiCondListCndVO) throws DAOException {
		List<StiDetailCndVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = stiCondListCndVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchStiListAtCndRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, StiDetailCndVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 1023화면, Vessel Stowage Plan Transmit 할때, Vessel Info를 조회한다.
	 * 
	 * @param VesselEtaCondCndVO vesselEtaCondCndVO
	 * @return VesselEtaInfoCndVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public VesselEtaInfoCndVO searchVesselEta(VesselEtaCondCndVO vesselEtaCondCndVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<VesselEtaInfoCndVO> list = null;
		VesselEtaInfoCndVO vesselEtaInfoCndVO = null;
		try
		{
			Map<String, String> mapVO = vesselEtaCondCndVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchVesselEtaRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VesselEtaInfoCndVO.class);
			
			if(list != null && list.size() > 0) {
				vesselEtaInfoCndVO = list.get(0);
			}
			
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vesselEtaInfoCndVO;
	}

	/**
	 * 1023화면, Vessel Stowage Plan Transmit 할때, Container별 Bay Info를 조회한다.
	 * 
	 * @param BayPlanCntrListConCndVO bayPlanCntrListCondCndVO
	 * @return BayPlanCntrDetailCndVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BayPlanCntrDetailCndVO searchBayPlanCntrList(BayPlanCntrListConCndVO bayPlanCntrListCondCndVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<BayPlanCntrDetailCndVO> list = null;
		try
		{
			Map<String, String> mapVO = bayPlanCntrListCondCndVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchBayPlanCntrListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BayPlanCntrDetailCndVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list.get(0);
	}

	
	/**
	 * 1023화면, Vessel Stowage Plan Transmit 할때,  Last Pol을 조회한다.
	 * 
	 * @param BayPlanCntrListConCndVO bayPlanCntrListCondCndVO
	 * @return BayPlanPolDetailVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BayPlanPolDetailVO searchBayPlanPolInfo(BayPlanCntrListConCndVO bayPlanCntrListCondCndVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<BayPlanPolDetailVO> list = null;
		try
		{
			Map<String, String> mapVO = bayPlanCntrListCondCndVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchBayPlanPolInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BayPlanPolDetailVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list.get(0);
	}
	
	/**
	 * Vsl_cd가 등록된 BKG_BOOKING로 부터 LANE 정보를 조회한다.
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchSvcLane(String vvd) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			velParam.put("vvd", vvd);
			param.put("vvd", vvd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchSvcLaneRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}
	/**
	 * Baplie Message Function Code 조회 - 9 ORIGINAL, 4 CHANGE
	 * 
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchMessageFunctioncCode(String vvd) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			velParam.put("vvd", vvd);
			param.put("vvd", vvd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchMessageFunctioncCodeRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}
	
	/**
	 * MDM_VSL_CNTR 정보를 조회한다.
	 * 
	 * @param String vvd
	 * @return MdmVslCntrVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmVslCntrVO searchVslInfo(String vvd) throws DAOException {
		// CntrLineInfoVO
		List<MdmVslCntrVO> list = null;
		MdmVslCntrVO mdmVslCntrVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchMdmVslCntrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmVslCntrVO.class);
			if (list != null && list.size() > 0)
			{
				mdmVslCntrVO = list.get(0);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mdmVslCntrVO;
	}
	
	
	/**
	 * Sysdate 를 조회한다.
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchSysdate() {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOselectSysdateRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
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
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchDateSeqRSQL(), param, velParam);
			if (dbRowset.next())
			{
				retVal = dbRowset.getString(1);
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}
	
	/**
	 * BKG_CSTMS_ADV_STWG_SND_LOG 테이블에 로그를 입력한다.<br>
	 * 
	 * @param SendDetailLogCndVO sendDetailLogVO
	 * @return int
	 * @throws DAOException
	 */
	public int addStowageSendLog(SendDetailLogCndVO sendDetailLogVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendDetailLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new CndCustomsTransmissionDBDAOaddStowageSendLogCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			return result;
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
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
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendDetailLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new CndCustomsTransmissionDBDAOaddSendDetailLogCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			return result;
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
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
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendLogDetailVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new CndCustomsTransmissionDBDAOmodifySendLogByCntrUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			return result;
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
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
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendLogDetailVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new CndCustomsTransmissionDBDAOAddSendLogByCntrCSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			return result;
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
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
	@SuppressWarnings("unchecked")
	public BkgCstmsAdvRcvLogVO searchCusResDataBySndId(String orgRefNo) throws DAOException {
		List<BkgCstmsAdvRcvLogVO> list = null;
		BkgCstmsAdvRcvLogVO orgRefVO = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (orgRefNo != null)
			{
				param.put("crr_bat_no", orgRefNo);
				velParam.put("crr_bat_no", orgRefNo);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CndCustomsTransmissionDBDAOsearchCusResDataBySndIdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvRcvLogVO.class);
			if (list != null && list.size() > 0)
			{
				orgRefVO = list.get(0);
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return orgRefVO;
	}
	
	
	/**
	 * STOWAGE SEND LOG 테이블 업데이트
	 * 
	 * @param SendDetailLogCndVO sendDetailLogVO
	 * @return int result
	 * @throws DAOException
	 */	
	public int modifyBaplieCusResSndLog(SendDetailLogCndVO sendDetailLogVO){
		int result = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{			
			Map<String, String> mapVO = sendDetailLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CndCustomsTransmissionDBDAOmodifyBaplieCusResSndLogUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return result;
	}
	
	/**
	 * ERROR_DETAIL 루프 내, Cntr_no error result 별 업데이트
	 * 
	 * @param SendDetailLogCndVO sendDetailLogVO
	 * @return int result
	 * @throws DAOException
	 */
	public int modifyBaplieCusResByCntr(SendDetailLogCndVO sendDetailLogVO) {
		int result = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendDetailLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CndCustomsTransmissionDBDAOmodifyBaplieCusResByCntrCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return result;
	}	
	
	/**
	 * STOWAGE CNTR 테이블 수신 메소드 수행
	 * 
	 * @param SendDetailLogCndVO sendDetailLogVO
	 * @return int result
	 * @throws DAOException
	 */
	public int modifyBaplieCusResByVvd(SendDetailLogCndVO sendDetailLogVO) {
		int result = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = sendDetailLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new CndCustomsTransmissionDBDAOmodifyBaplieCusResByVvdUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
			
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
		return result;
	}
	
	
	/**
	 * 응답메세지 수신 C01 항목으로 리스팅 된 Cntr 에 대해 R03 의 Remark 를 표기
	 * 
	 * @param List<BkgCstmsAdvSndLogVO> bkgCstmsAdvSndSwgLogVOs
	 */
	public void modifyBaplieRcvByCntr(List<BkgCstmsAdvSndLogVO> bkgCstmsAdvSndSwgLogVOs) {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (bkgCstmsAdvSndSwgLogVOs.size() > 0)
			{
				int updCnt[] = null;
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new CndCustomsTransmissionDBDAOmodifyBaplieRcvByCntrUSQL(),	bkgCstmsAdvSndSwgLogVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
		}
	}

	
	
	/**
	 * 응답메세지 수신 C01 항목으로 리스팅 되지 않은 CNTR 에 대해 해당 VVD의 BAPLIE 전송이력이 있는 CNTR 는 모두 ACK 로 표기
	 * 
	 * @param BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO
	 * @throws DAOException
	 */
	public void modifyBaplieRcvByVvd(BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO) {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsAdvRcvLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new CndCustomsTransmissionDBDAOmodifyBaplieRcvByVvdUSQL(),	param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to UPDATE SQL");
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
	}	
	
	/**
	 * 1023화면, Vessel Stowage Plan Transmit 할때, Container별 Bay Info를 조회한다.
	 * 
	 * @param BayPlanCntrListConCndVO bayPlanCntrListCondCndVO
	 * @return List<BayPlanCntrDetailCndVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BayPlanCntrDetailCndVO> searchBayPlanCntrCmList(BayPlanCntrListConCndVO bayPlanCntrListCondCndVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<BayPlanCntrDetailCndVO> list = null;
		try
		{
			Map<String, String> mapVO = bayPlanCntrListCondCndVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndCustomsTransmissionDBDAOsearchBayPlanCntrCmListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BayPlanCntrDetailCndVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}