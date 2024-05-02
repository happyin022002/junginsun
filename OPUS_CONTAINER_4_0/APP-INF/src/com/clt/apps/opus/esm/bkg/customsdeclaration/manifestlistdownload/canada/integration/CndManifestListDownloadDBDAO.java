/*========================================================= 
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CndManifestListDownloadDBDAO.java
 *@FileTitle : CndManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.common.CountryCode;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlCstmsRsltVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlHblListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlMainVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsMfDtlListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsMfDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsMfListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsMfVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVesselArrivalInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVesselInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVesselInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVslCrnNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVvdInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndVesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndVesselVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.HusBlInpChkCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.HusBlInpChkVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CstmsHldVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsAdvBlVO;
import com.clt.syscommon.common.table.BkgCstmsAdvCntrMfVO;
import com.clt.syscommon.common.table.BkgCstmsAdvCntrVO;
import com.clt.syscommon.common.table.BkgCstmsAdvCustVO;
import com.clt.syscommon.common.table.BkgCstmsAdvMkDescVO;
import com.clt.syscommon.common.table.BkgCstmsAdvRcvLogVO;
import com.clt.syscommon.common.table.BkgCstmsCndVslVO;
import com.clt.syscommon.common.table.BkgCstmsSealNoVO;

/**
 * OPUS CndManifestListDownloadDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Kim Min Jeong
 * @see CndManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class CndManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Canada ACI_CRN(Conveyance Ref. No.) 생성을 위해 VVD 정보 조회<br>
	 *
	 * @param cndCstmsVvdInfoCondVO 조회조건
 	 * @return List<CstmsVvdInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsVvdInfoVO> searchCndCstmsVvdInfo(CndCstmsVvdInfoCondVO cndCstmsVvdInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstmsVvdInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndCstmsVvdInfoCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsVvdInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchCstmsVvdInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CstmsVvdInfoVO.class);
			// 비교할 대상
//			CstmsVvdInfoVO[] copyVO = new CstmsVvdInfoVO[list.size()];
//			copyVO = (CstmsVvdInfoVO[]) list.toArray(copyVO);
//			for (int i = 0; i < list.size(); i++)
//			{
//				CstmsVvdInfoVO vvdInfo = (CstmsVvdInfoVO) list.get(i);
//				CstmsVvdInfoVO preVvdInfo = null;
//				if ("T".equals(vvdInfo.getCheckFlag()))
//				{
//					/*
//					 * 동일 CRN 허용 조건에 해당하면 checkbox disabled 1. Vessel & Voyage 는 동일하고 Bound (E/W)만 상이한 경우 2. Vessel &
//					 * Voyage 는 동일하고 POD 만 상이한 경우 3. Voyage가 상이하나, Vessel 이 동일하고 ETA가 동일한 경우
//					 */
//					if (i != 0)
//					{
//						preVvdInfo = (CstmsVvdInfoVO) list.get(i - 1);
//					}
//					for (int j = 0; j < i; j++)
//					{
//						if (i != j)
//						{
//							if (copyVO[j].getVslCd().equals(vvdInfo.getVslCd())
//									&& copyVO[j].getSkdVoyNo().equals(vvdInfo.getSkdVoyNo()))
//							{
//								if (!"".equals(copyVO[j].getCvyRefNo()))
//								{
//									vvdInfo.setUpdCrn(copyVO[j].getCvyRefNo());
//								}
//								vvdInfo.setCheckFlag(vvdInfo.getVvdCd());
//								break;
//							}
//							if (copyVO[j].getVslCd().equals(vvdInfo.getVslCd())
//									&& copyVO[j].getEtaDt().equals(vvdInfo.getEtaDt()))
//							{
//								if (!"".equals(copyVO[j].getCvyRefNo()))
//								{
//									vvdInfo.setUpdCrn(copyVO[j].getCvyRefNo());
//								}
//								vvdInfo.setCheckFlag(vvdInfo.getVvdCd());
//								break;
//							}
//						}
//					}
//					// 바로 위에 행과 PK가 같으면 다시 ""세팅
//					if (preVvdInfo != null && preVvdInfo.getVslCd().equals(vvdInfo.getVslCd())
//							&& preVvdInfo.getSkdVoyNo().equals(vvdInfo.getSkdVoyNo())
//							&& preVvdInfo.getSkdDirCd().equals(vvdInfo.getSkdDirCd()))
//					{
//						vvdInfo.setCheckFlag("F");
//						vvdInfo.setUpdCrn("");
//					}
//				}
//			}
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
	 * 세관 관련 VVD 정보 조회
	 *
	 * @param bkgCstmsCndVslVO VVD 정보
	 * @return List<BkgCstmsCndVslVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsCndVslVO> searchBkgCstmsCndVsl(BkgCstmsCndVslVO bkgCstmsCndVslVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCstmsCndVslVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (bkgCstmsCndVslVO != null)
			{
				Map<String, String> mapVO = bkgCstmsCndVslVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgCstmsCndVslRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsCndVslVO.class);
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
	 * 세관 관련 VVD 정보 생성
	 *
	 * @param bkgCstmsCndVslVO VVD 정보
	 * @throws DAOException
	 */
	public void addBkgCstmsCndVsl(List<BkgCstmsCndVslVO> bkgCstmsCndVslVO) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsCndVslVO.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsCndVslVO.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CndManifestListDownloadDBDAOaddBkgCstmsCndVsl1CSQL(),
						bkgCstmsCndVslVO, velParam);
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
	 * 세관 관련 VVD 정보 생성
	 *
	 * @param bkgCstmsCndVslVO VVD 정보
	 * @throws DAOException
	 */
	public void mergeBkgCstmsCndVsl(List<BkgCstmsCndVslVO> bkgCstmsCndVslVO) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsCndVslVO.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsCndVslVO.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CndManifestListDownloadDBDAOaddBkgCstmsCndVsl1CSQL(),
						bkgCstmsCndVslVO, velParam);
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
	 * VVD 정보 수정
	 *
	 * @param bkgCstmsCndVslVO VVD 정보
	 * @throws DAOException
	 */
	public void modifyBkgCstmsCndVsl(List<BkgCstmsCndVslVO> bkgCstmsCndVslVO) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsCndVslVO != null && bkgCstmsCndVslVO.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsCndVslVO.get(0).getColumnValues();
				velParam.putAll(mapVO);
				if (bkgCstmsCndVslVO.get(0).getCndAckCtrlNo() == null
						|| "".equals(bkgCstmsCndVslVO.get(0).getCndAckCtrlNo()))
				{
					updCnt = sqlExe.executeBatch(
							(ISQLTemplate) new CndManifestListDownloadDBDAOaddBkgCstmsCndVsl1CSQL(), bkgCstmsCndVslVO,
							velParam);
				}
				else
				{
					updCnt = sqlExe.executeBatch(
							(ISQLTemplate) new CndManifestListDownloadDBDAOmodifyBkgCstmsCndVslUSQL(),
							bkgCstmsCndVslVO, velParam);
				}
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
	 * 중복된 VVD조회
	 *
	 * @param bkgCstmsCndVslVO VVD 정보
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchDuplicateVvd(List<BkgCstmsCndVslVO> bkgCstmsCndVslVO) throws DAOException {
		DBRowSet dbRowset = null;
		String vvdCd = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			String vvd_cd = "";
			for (int i = 0; i < bkgCstmsCndVslVO.size(); i++)
			{
				if (i == 0)
				{
					vvd_cd = "'" + bkgCstmsCndVslVO.get(i).getVslCd() + bkgCstmsCndVslVO.get(i).getSkdVoyNo()
							+ bkgCstmsCndVslVO.get(i).getSkdDirCd() + "'";
				}
				else
				{
					vvd_cd = vvd_cd + ",'" + bkgCstmsCndVslVO.get(i).getVslCd() + bkgCstmsCndVslVO.get(i).getSkdVoyNo()
							+ bkgCstmsCndVslVO.get(i).getSkdDirCd() + "'";
				}
			}
			param.put("cvy_ref_no", bkgCstmsCndVslVO.get(0).getCvyRefNo());
			param.put("vps_port_cd", bkgCstmsCndVslVO.get(0).getVpsPortCd());
			velParam.put("vvd_cd", vvd_cd);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchDuplicateVvdRSQL(), param, velParam);
			List list = RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsCndVslVO.class);
			if (list != null && list.size() > 0)
			{
				vvdCd = ((BkgCstmsCndVslVO) list.get(0)).getVslCd();
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
		return vvdCd;
	}

	/**
	 * 세관 신고용 VVD별 Reference No 생성
	 *
	 * @param cndCarrierCd CrrCode
	 * @return String
	 * @throws DAOException
	 */
	public String createCndCstmsVvdRefNo(String cndCarrierCd) throws DAOException {
		DBRowSet dbRowset = null;
		String strVvdRefNo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("crr_cd", cndCarrierCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOcreateCndCstmsVvdRefNoRSQL(), param, velParam);
			if (dbRowset.next())
			{
				strVvdRefNo = dbRowset.getString(1);
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
		return strVvdRefNo;
	}

	/**
	 * Vessel 정보 조회
	 *
	 * @param cndCstmsVesselInfoCondVO 조회조건
	 * @return List<VesselVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VesselVO> searchCndCstmsVesselInfo(CndCstmsVesselInfoCondVO cndCstmsVesselInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VesselVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndCstmsVesselInfoCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsVesselInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchCndVesselRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndVesselVO.class);
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
	 * Vessel 정보 수정
	 *
	 * @param cndCstmsVesselInfoVOs Vessel 정보
	 * @throws DAOException
	 */
	public void modifyMdmVslCntr(List<CndCstmsVesselInfoVO> cndCstmsVesselInfoVOs) throws DAOException, Exception {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cndCstmsVesselInfoVOs.size() > 0)
			{
				Map<String, Object> velParam = new HashMap<String, Object>();
				Map<String, String> mapVO = cndCstmsVesselInfoVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CndManifestListDownloadDBDAOmodifyMdmVslCntrUSQL(),
						cndCstmsVesselInfoVOs, velParam);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
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
	 * 캐나다세관 신고 필수항목중 ETL Data 조회
	 *
	 * @param cstmsVvdListCondVO 조회조건
	 * @return List<CstmsVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsVvdVO> searchCndCstmsVvdList(CstmsVvdListCondVO cstmsVvdListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstmsVvdVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cstmsVvdListCondVO != null)
			{
				Map<String, String> mapVO = cstmsVvdListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchCstmsVvdListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CstmsVvdVO.class);
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
	 * Customer, Container, Commodity(CM) 등의 BL 정보 조회/확인<br>
	 *
	 * @param cndCstmsVesselArrivalInfoCondVO 조회조건
	 * @return List<VesselArrivalDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VesselArrivalDetailVO> searchVesselArrival(CndCstmsVesselArrivalInfoCondVO cndCstmsVesselArrivalInfoCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<VesselArrivalDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndCstmsVesselArrivalInfoCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsVesselArrivalInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchVesselArrivalRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndVesselArrivalDetailVO.class);
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
	 * 세관 신고를 위해 다운로드 받은 B/L Main 정보 조회
	 *
	 * @param blNo B/L No.
	 * @return CndCstmsBlMainVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CndCstmsBlMainVO searchCndCstmsBlMain(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		CndCstmsBlMainVO vo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (blNo != null)
			{
				param.put("bl_no", blNo);
				velParam.put("bl_no", blNo);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchCndCstmsBlMainRSQL(), param, velParam);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsBlMainVO.class);
			if (list.size() > 0)
			{
				vo = (CndCstmsBlMainVO) list.get(0);
			}
			else
			{
				vo = new CndCstmsBlMainVO();
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
		return vo;
	}

	/**
	 * B/L별 Customer 정보 조회
	 *
	 * @param blNo B/L No.
	 * @return CndCstmsBlCustVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CndCstmsBlCustVO searchCndCstmsBlCust(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		CndCstmsBlCustVO vo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (blNo != null)
			{
				param.put("bl_no", blNo);
				velParam.put("bl_no", blNo);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchCndCstmsBlCustRSQL(), param, velParam);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsBlCustVO.class);
			if (list.size() > 0)
			{
				vo = (CndCstmsBlCustVO) list.get(0);
			}
			else
			{
				vo = new CndCstmsBlCustVO();
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
		return vo;
	}

	/**
	 * B/L별 세관 신고 전송 결과 조회
	 *
	 * @param blNo B/L No.
	 * @return List<CndCstmsBlCstmsRsltVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CndCstmsBlCstmsRsltVO> searchCndCstmsBlCstmsRslt(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CndCstmsBlCstmsRsltVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (blNo != null)
			{
				param.put("bl_no", blNo);
				velParam.put("bl_no", blNo);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchCndCstmsBlCstmsRsltRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsBlCstmsRsltVO.class);
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
	 * B/L별 House B/L 정보 조회
	 *
	 * @param blNo B/L No.
	 * @return List<CndCstmsBlHblListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CndCstmsBlHblListVO> searchCndCstmsBlHblList(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CndCstmsBlHblListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (blNo != null)
			{
				param.put("bl_no", blNo);
				velParam.put("bl_no", blNo);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchCndCstmsBlHblListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsBlHblListVO.class);
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
	 * 세관 BL수정
	 * @param bkgCstmsAdvBlVOs BL정보
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAdvBl(List<BkgCstmsAdvBlVO> bkgCstmsAdvBlVOs) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAdvBlVOs.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsAdvBlVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				if (bkgCstmsAdvBlVOs.get(0).getCstmsAckKeyNo() != null
						&& !"".equals(bkgCstmsAdvBlVOs.get(0).getCstmsAckKeyNo()))
				{
					// EDI 수신메시지
					updCnt = sqlExe.executeBatch(
							(ISQLTemplate) new CndManifestListDownloadDBDAOmodifyBkgCstmsAdvBl4USQL(),
							bkgCstmsAdvBlVOs, velParam);
				}
				else if ("AvcNoteSetUp".equals(bkgCstmsAdvBlVOs.get(0).getIbflag()))
				{
					// 화면 0025(Advice Notes (Canada))에서 A/N Type 수정
					updCnt = sqlExe.executeBatch(
							(ISQLTemplate) new CndManifestListDownloadDBDAOmodifyBkgCstmsAdvBl2USQL(),
							bkgCstmsAdvBlVOs, velParam);
				}
				else if ("MF_STS_CD".equals(bkgCstmsAdvBlVOs.get(0).getIbflag()))
				{
					// 화면 0002, 0028에서 MF_STS_CD 변경
					updCnt = sqlExe.executeBatch(
							(ISQLTemplate) new CndManifestListDownloadDBDAOmodifyMfStsCdUSQL(),
							bkgCstmsAdvBlVOs, velParam);
				}
				else
				{
					updCnt = sqlExe.executeBatch(
							(ISQLTemplate) new CndManifestListDownloadDBDAOmodifyBkgCstmsAdvBlUSQL(), bkgCstmsAdvBlVOs,
							velParam);
				}
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
     * 기 다운로드 된 B/L 정보를 삭제한다.<br>
     * @param CndManifestModificationVO cndManifestModificationVO
     * @exception DAOException
     */
	public void removeBKGAdvManifestBlCA(CndManifestModificationVO cndManifestModificationVO) throws DAOException {
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO =  cndManifestModificationVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new CndManifestListDownloadDBDAOremoveBkgCstmsAdvBlByVVDDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

	 /**
     * 기 다운로드 된 B/L 정보를 삭제한다.<br>
     * @param CndManifestModificationVO cndManifestModificationVO
     * @exception DAOException
     */
	public void removeBKGAdvManifestCntrCA( CndManifestModificationVO cndManifestModificationVO) throws DAOException {
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO =  cndManifestModificationVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new CndManifestListDownloadDBDAOremoveBkgCstmsAdvCntrByVVDDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

	 /**
     * 기 다운로드 된 B/L 정보를 삭제한다.<br>
     * @param CndManifestModificationVO cndManifestModificationVO
     * @exception DAOException
     */
	public void removeBKGAdvManifestCustCA( CndManifestModificationVO cndManifestModificationVO) throws DAOException {
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO =  cndManifestModificationVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new CndManifestListDownloadDBDAOremoveBkgCstmsAdvCustByVVDDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

	 /**
     * 기 다운로드 된 B/L 정보를 삭제한다.<br>
     * @param CndManifestModificationVO cndManifestModificationVO
     * @exception DAOException
     */
	public void removeBKGAdvManifestSealNoCA( CndManifestModificationVO cndManifestModificationVO) throws DAOException {
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO =  cndManifestModificationVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new CndManifestListDownloadDBDAOremoveBkgCstmsAdvSealNoByVVDDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

	 /**
     * 기 다운로드 된 B/L 정보를 삭제한다.<br>
     * @param CndManifestModificationVO cndManifestModificationVO
     * @exception DAOException
     */
	public void removeBKGAdvManifestCntrMfCA( CndManifestModificationVO cndManifestModificationVO) throws DAOException {
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO =  cndManifestModificationVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new CndManifestListDownloadDBDAOremoveBkgCstmsAdvCntrMfByVVDDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

	/**
	 * CUSTOMER 수정
	 *
	 * @param bkgCstmsAdvCustVOs CUSTOMER정보
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAdvCust(List<BkgCstmsAdvCustVO> bkgCstmsAdvCustVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAdvCustVOs.size() > 0)
			{
				if ("ESM_BKG_0025".equals(bkgCstmsAdvCustVOs.get(0).getIbflag()))
				{
					updCnt = sqlExe.executeBatch(
							(ISQLTemplate) new CndManifestListDownloadDBDAOmodifyBkgCstmsAdvCust2USQL(),
							bkgCstmsAdvCustVOs, null);
				}
				else
				{
					updCnt = sqlExe.executeBatch(
							(ISQLTemplate) new CndManifestListDownloadDBDAOmodifyBkgCstmsAdvCustUSQL(),
							bkgCstmsAdvCustVOs, null);
				}
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
	 * CONTAINER 수정
	 *
	 * @param List<BkgCstmsAdvCntrVO> bkgCstmsAdvCntrVOs
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAdvCntr(List<BkgCstmsAdvCntrVO> bkgCstmsAdvCntrVOs) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAdvCntrVOs.size() > 0)
			{
				Map<String, Object> velParam = new HashMap<String, Object>();
				Map<String, String> mapVO = bkgCstmsAdvCntrVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CndManifestListDownloadDBDAOmodifyBkgCstmsAdvCntrUSQL(),
						bkgCstmsAdvCntrVOs, velParam);
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
	 * Hub 정보 취득
	 *
	 * @param podCd
	 * @param delCd
	 * @param podNodCd
	 * @return
	 * @throws DAOException
	 */
	public String[] searchHubInfo(String podCd, String delCd, String podNodCd) throws DAOException {
		DBRowSet dbRowset = null;
		String[] arrHubInfo = { "", "" };
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("pod_cd", podCd);
			param.put("del_cd", delCd);
			if( podNodCd != null && podNodCd.length() == 7 ){
				param.put("pod_yd_no", podNodCd.substring(5, 7));
				velParam.put("pod_yd_no", podNodCd.substring(5, 7));
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchHubInfoRSQL(), param, velParam);
			if (dbRowset.next())
			{
				arrHubInfo[0] = dbRowset.getString(1);
				arrHubInfo[1] = dbRowset.getString(2);
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
		return arrHubInfo;
	}

	/**
	 * 대상 B/L 조회 기능
	 *
	 * @param cndCstmsMfListCondVO 조회조건
	 * @param SignOnUserAccount account
	 * @return List<ManifestListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchCndCstmsMfList(CndCstmsMfListCondVO cndCstmsMfListCondVO, SignOnUserAccount account)
			throws DAOException {
		DBRowSet dbRowset = null;
		log.info("=== searchCndCstmsMfList  ===");
		List<ManifestListDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		cndCstmsMfListCondVO.setUpdUsrId(account.getUpd_usr_id());
		try
		{
			if (cndCstmsMfListCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsMfListCondVO.getColumnValues();
				param.put("cnt_cd", CountryCode.CA);
				velParam.put("cnt_cd", CountryCode.CA);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchCndCstmsMfListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsMfVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		log.info("=== searchCndCstmsMfList End ===");
		return list;
	}

	/**
	 * 대상 B/L 상세 조회 기능
	 *
	 * @param cndCstmsMfDtlListCondVO 조회조건
	 * @return List<ManifestListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchCndCstmsMfDtlList(CndCstmsMfDtlListCondVO cndCstmsMfDtlListCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<ManifestListDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (cndCstmsMfDtlListCondVO != null)
			{
				Map<String, String> mapVO = cndCstmsMfDtlListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cnt_cd", CountryCode.CA);
				velParam.put("cnt_cd", CountryCode.CA);
				int pageNo = Integer.parseInt("".equals(cndCstmsMfDtlListCondVO.getPageNo()) ? "1"
						: cndCstmsMfDtlListCondVO.getPageNo());
				int pageRows = Integer.parseInt(cndCstmsMfDtlListCondVO.getPagerows());
				int totalRows = Integer.parseInt(cndCstmsMfDtlListCondVO.getTotal());
				int startNo = (pageNo - 1) * pageRows + 1;
				int endNo = pageNo * pageRows;
				endNo = (totalRows > 0 && endNo > totalRows) ? totalRows : endNo;
				param.put("startNo", startNo);
				param.put("endNo", endNo);
				velParam.put("startNo", startNo);
				velParam.put("endNo", endNo);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchCndCstmsMfDtlListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CndCstmsMfDtlVO.class);
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
	 * CCN prefix 존재여부
	 *
	 * @param vslCd Vessel Code
	 * @param skdVoyNo Voy No
	 * @param skdDirCd Dir Code
	 * @param podCd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkIfCCNAval(String vslCd, String skdVoyNo, String skdDirCd, String podCd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isCCNNo = false;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("pod_cd", podCd);
			velParam.put("cnt_cd", podCd.substring(0, 2));
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOcheckIfCCNAvalRSQL(), param, velParam);
			if (dbRowset.next())
			{
				isCCNNo = true;
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
		return isCCNNo;
	}

	/**
	 * Canada B/L Download 시 BKG_CSTMS_ADV_CNTR 테이블의 RAIL_CRR_REF_NO, USA_IB_TRSP_NO 2개 칼럼 기존 데이터 유지
	 *
	 * @param bkgCstmsAdvCntrVO
	 * @return List<BkgCstmsAdvCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsAdvCntrVO> searchBkgCstmsAdvCntr(BkgCstmsAdvCntrVO bkgCstmsAdvCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCstmsAdvCntrVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsAdvCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgCstmsAdvCntrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvCntrVO.class);
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
	 * Manifest Desc 삭제
	 *
	 * @param bkgCstmsAdvMkDesc Manifest Desc
	 * @throws DAOException
	 */
	public void removeBkgCstmsAdvMkDesc(BkgCstmsAdvMkDescVO bkgCstmsAdvMkDesc) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new CndManifestListDownloadDBDAOremoveBkgCstmsAdvMkDescDSQL(),
					bkgCstmsAdvMkDesc.getColumnValues(), null);
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
	 * 컨테이너 Manifest 삭제
	 *
	 * @param bkgCstmsAdvCntrMf Manifest MF
	 * @throws DAOException
	 */
	public void removeBkgCstmsAdvCntrMf(BkgCstmsAdvCntrMfVO bkgCstmsAdvCntrMf) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new CndManifestListDownloadDBDAOremoveBkgCstmsAdvCntrMfDSQL(),
					bkgCstmsAdvCntrMf.getColumnValues(), null);
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
	 * 컨테이너 SEAL NO 삭제
	 *
	 * @param bkgCstmsSealNoVO SealNo 정보
	 * @throws DAOException
	 */
	public void removeBkgCstmsSealNo(BkgCstmsSealNoVO bkgCstmsSealNoVO) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new CndManifestListDownloadDBDAOremoveBkgCstmsSealNoDSQL(),
					bkgCstmsSealNoVO.getColumnValues(), null);
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
	 * 컨테이너 삭제
	 *
	 * @param bkgCstmsAdvCntr 컨테이너
	 * @throws DAOException
	 */
	public void removeBkgCstmsAdvCntr(BkgCstmsAdvCntrVO bkgCstmsAdvCntr) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new CndManifestListDownloadDBDAOremoveBkgCstmsAdvCntrDSQL(),
					bkgCstmsAdvCntr.getColumnValues(), null);
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
	 * Customer 삭제
	 *
	 * @param bkgCstmsAdvCust Customer
	 * @throws DAOException
	 */
	public void removeBkgCstmsAdvCust(BkgCstmsAdvCustVO bkgCstmsAdvCust) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new CndManifestListDownloadDBDAOremoveBkgCstmsAdvCustDSQL(),
					bkgCstmsAdvCust.getColumnValues(), null);
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
	 * Booking Table의 원정보조회
	 *
	 * @param bkgNo BKG_NO
	 * @param vslCd VSL_CD
	 * @param skdVoyNo SKD_VOY_NO
	 * @param skdDirCd SKD_DIR_CD
	 * @return BkgCstmsAdvBlVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsAdvBlVO searchBkgBookingMaster(String bkgNo, String vslCd, String skdVoyNo, String skdDirCd)
			throws DAOException {
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO = null;
		try
		{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgBookingMasterRSQL(), param, null);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvBlVO.class);
			if (list.size() > 0)
			{
				bkgCstmsAdvBlVO = (BkgCstmsAdvBlVO) list.get(0);
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
		return bkgCstmsAdvBlVO;
	}

	/**
	 * Booking Table의 원정보조회
	 *
	 * @param bkgNo BKG_NO
	 * @param blNo BL_NO
	 * @param vslCd VSL_CD
	 * @param skdVoyNo SKD_VOY_NO
	 * @param skdDirCd SKD_DIR_CD
	 * @return BkgCstmsAdvBlVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsAdvBlVO searchBkgBookingHBl(String bkgNo, String blNo, String vslCd, String skdVoyNo, String skdDirCd)
			throws DAOException {
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO = null;
		try
		{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgBookingHBlRSQL(), param, null);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvBlVO.class);
			if (list.size() > 0)
			{
				bkgCstmsAdvBlVO = (BkgCstmsAdvBlVO) list.get(0);
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
		return bkgCstmsAdvBlVO;
	}

	/**
	 * BDR 이후 정보조회
	 *
	 * @param bkgNo BKG_NO
	 * @return BkgCstmsAdvBlVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsAdvBlVO searchBkgCorrection(String bkgNo) throws DAOException {
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO = null;
		try
		{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgCorrectionRSQL(), param, null);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvBlVO.class);
			if (list.size() > 0)
			{
				bkgCstmsAdvBlVO = (BkgCstmsAdvBlVO) list.get(0);
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
		return bkgCstmsAdvBlVO;
	}

	/**
	 * BKG_CSTMS_ADV_BL Insert Or Update
	 *
	 * @param bkgCstmsAdvBlVO BL정보
	 * @throws DAOException
	 */
	public void mergeSelectBkgCstmsAdvBl(BkgCstmsAdvBlVO bkgCstmsAdvBlVO) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			if ("C".equals(bkgCstmsAdvBlVO.getIbflag()))
			{
				sqlExe.executeUpdate((ISQLTemplate) new CndManifestListDownloadDBDAOaddBkgCstmsAdvBlCSQL(), bkgCstmsAdvBlVO.getColumnValues(), null);
			}
			else
			{
				sqlExe.executeUpdate((ISQLTemplate) new CndManifestListDownloadDBDAOmodifyBkgCstmsAdvBl3USQL(), bkgCstmsAdvBlVO.getColumnValues(), null);
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
	 * BKG_CUSTOMER 정보조회
	 *
	 * @param bkgCstmsAdvBlVO
	 * @return List<BkgCstmsAdvCustVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsAdvCustVO> searchBkgCustomer(BkgCstmsAdvBlVO bkgCstmsAdvBlVO) throws DAOException {
		List<BkgCstmsAdvCustVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try
		{
			Map<String, String> mapVO = bkgCstmsAdvBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgCustomerRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvCustVO.class);

			dbRowset = null;
			for (int i = 0; i < list.size(); i++)
			{
				BkgCstmsAdvCustVO cust = list.get(i);
				// Shipper 정보가 없을때
				if ("S".equals(cust.getBkgCustTpCd())
						&& ("".equals(cust.getCustCtyNm()) || "".equals(cust.getCustSteCd()) || "".equals(cust
								.getCstmsDeclCntCd())))
				{
					dbRowset = new SQLExecuter("")
							.executeQuery((ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgCustomerShprRSQL(),
									param, velParam);
				}
				// Consignee 정보가 없을때
				else if ("C".equals(cust.getBkgCustTpCd())
						&& ("".equals(cust.getCustCtyNm()) || "".equals(cust.getCustSteCd()) || "".equals(cust
								.getCstmsDeclCntCd())))
				{
					dbRowset = new SQLExecuter("")
							.executeQuery((ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgCustomerCneeRSQL(),
									param, velParam);
				}
				// Notify 정보가 없을때
				else if ("N".equals(cust.getBkgCustTpCd())
						&& ("".equals(cust.getCustCtyNm()) || "".equals(cust.getCustSteCd()) || "".equals(cust
								.getCstmsDeclCntCd())))
				{
					dbRowset = new SQLExecuter("")
							.executeQuery((ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgCustomerNtfyRSQL(),
									param, velParam);
				}
				if (dbRowset != null && dbRowset.next())
				{
					if ("".equals(cust.getCustCtyNm()))
					{
						cust.setCustCtyNm(dbRowset.getString("CUST_CTY_NM"));
					}
					if ("".equals(cust.getCstmsDeclCntCd()))
					{
						cust.setCstmsDeclCntCd(dbRowset.getString("CUST_CNT_CD"));
					}
					if ("".equals(cust.getCustSteCd()))
					{
						cust.setCustSteCd(dbRowset.getString("CUST_STE_CD"));
					}
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
		return list;
	}

	/**
	 * BKG_HBL_CUST 정보조회
	 *
	 * @param BkgCstmsAdvBlVO bkgCstmsAdvBlVO
	 * @return List<BkgCstmsAdvCustVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsAdvCustVO> searchBkgHblCust(BkgCstmsAdvBlVO bkgCstmsAdvBlVO) throws DAOException {
		List<BkgCstmsAdvCustVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsAdvBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgHblCustRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvCustVO.class);

			dbRowset = null;
			for (int i = 0; i < list.size(); i++)
			{
				BkgCstmsAdvCustVO cust = list.get(i);
				// Shipper 정보가 없을때
				if ("S".equals(cust.getBkgCustTpCd())
						&& ("".equals(cust.getCustCtyNm()) || "".equals(cust.getCustSteCd()) || "".equals(cust
								.getCstmsDeclCntCd())))
				{
					dbRowset = new SQLExecuter("")
							.executeQuery((ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgCustomerShprRSQL(),
									param, velParam);
				}
				// Consignee 정보가 없을때
				else if ("C".equals(cust.getBkgCustTpCd())
						&& ("".equals(cust.getCustCtyNm()) || "".equals(cust.getCustSteCd()) || "".equals(cust
								.getCstmsDeclCntCd())))
				{
					dbRowset = new SQLExecuter("")
							.executeQuery((ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgCustomerCneeRSQL(),
									param, velParam);
				}
				// Notify 정보가 없을때
				else if ("N".equals(cust.getBkgCustTpCd())
						&& ("".equals(cust.getCustCtyNm()) || "".equals(cust.getCustSteCd()) || "".equals(cust
								.getCstmsDeclCntCd())))
				{
					dbRowset = new SQLExecuter("")
							.executeQuery((ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgCustomerNtfyRSQL(),
									param, velParam);
				}
				if (dbRowset != null && dbRowset.next())
				{
					if ("".equals(cust.getCustCtyNm()))
					{
						cust.setCustCtyNm(dbRowset.getString("CUST_CTY_NM"));
					}
					if ("".equals(cust.getCstmsDeclCntCd()))
					{
						cust.setCstmsDeclCntCd(dbRowset.getString("CUST_CNT_CD"));
					}
					if ("".equals(cust.getCustSteCd()))
					{
						cust.setCustSteCd(dbRowset.getString("CUST_STE_CD"));
					}
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
		return list;
	}

	/**
	 * BKG_CSTMS_ADV_CUST Insert
	 *
	 * @param bkgCstmsAdvCustVOs Customer
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvCust(List<BkgCstmsAdvCustVO> bkgCstmsAdvCustVOs) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAdvCustVOs != null && bkgCstmsAdvCustVOs.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsAdvCustVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CndManifestListDownloadDBDAOaddBkgCstmsAdvCustCSQL(),
						bkgCstmsAdvCustVOs, velParam);
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
	 * BKG_CONTAINER 정보조회
	 *
	 * @param bkgCstmsAdvBlVO
	 * @return List<BkgCstmsAdvCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsAdvCntrVO> searchBkgContainer(BkgCstmsAdvBlVO bkgCstmsAdvBlVO) throws DAOException {
		List<BkgCstmsAdvCntrVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsAdvBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgContainerRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvCntrVO.class);
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
	 * BKG_CSTMS_ADV_CNTR Insert
	 *
	 * @param bkgCstmsAdvCntrVOs Container
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvCntr(List<BkgCstmsAdvCntrVO> bkgCstmsAdvCntrVOs) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAdvCntrVOs != null && bkgCstmsAdvCntrVOs.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsAdvCntrVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CndManifestListDownloadDBDAOaddBkgCstmsAdvCntrCSQL(),
						bkgCstmsAdvCntrVOs, velParam);
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
	 * BKG_CNTR_SEAL_NO 정보조회
	 *
	 * @param bkgCstmsAdvBlVO
	 * @return List<BkgCstmsSealNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsSealNoVO> searchBkgCntrSealNo(BkgCstmsAdvBlVO bkgCstmsAdvBlVO) throws DAOException {
		List<BkgCstmsSealNoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsAdvBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgCntrSealNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsSealNoVO.class);
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
	 * BKG_CSTMS_SEAL_NO Insert
	 *
	 * @param bkgCstmsSealNoVOs Seal No. 정보
	 * @throws DAOException
	 */
	public void addBkgCstmsSealNo(List<BkgCstmsSealNoVO> bkgCstmsSealNoVOs) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsSealNoVOs != null && bkgCstmsSealNoVOs.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsSealNoVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CndManifestListDownloadDBDAOaddBkgCstmsSealNoCSQL(),
						bkgCstmsSealNoVOs, velParam);
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
	 * BKG_CNTR_MF_DESC 정보조회
	 *
	 * @param bkgCstmsAdvBlVO
	 * @return List<BkgCstmsAdvCntrMfVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsAdvCntrMfVO> searchBkgCntrMfDesc(BkgCstmsAdvBlVO bkgCstmsAdvBlVO) throws DAOException {
		List<BkgCstmsAdvCntrMfVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsAdvBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgCntrMfDescRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvCntrMfVO.class);
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
	 * BKG_CSTMS_ADV_CNTR_MF Insert
	 *
	 * @param bkgCstmsAdvCntrMfVOs Container MF
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvCntrMf(List<BkgCstmsAdvCntrMfVO> bkgCstmsAdvCntrMfVOs) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAdvCntrMfVOs != null && bkgCstmsAdvCntrMfVOs.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsAdvCntrMfVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CndManifestListDownloadDBDAOaddBkgCstmsAdvCntrMfCSQL(),
						bkgCstmsAdvCntrMfVOs, velParam);
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
	 * BKG_BL_MK_DESC 정보조회
	 *
	 * @param bkgCstmsAdvBlVO
	 * @return List<BkgCstmsAdvMkDescVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsAdvMkDescVO> searchBkgBlMkDesc(BkgCstmsAdvBlVO bkgCstmsAdvBlVO) throws DAOException {
		List<BkgCstmsAdvMkDescVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsAdvBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchBkgBlMkDescRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvMkDescVO.class);
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
	 * BKG_CSTMS_ADV_MK_DESC Insert
	 *
	 * @param bkgCstmsAdvMkDescVOs MK DESC
	 * @throws DAOException
	 */
	public void addBkgCstmsAdvMkDesc(List<BkgCstmsAdvMkDescVO> bkgCstmsAdvMkDescVOs) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAdvMkDescVOs != null && bkgCstmsAdvMkDescVOs.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsAdvMkDescVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CndManifestListDownloadDBDAOaddBkgCstmsAdvMkDescCSQL(),
						bkgCstmsAdvMkDescVOs, velParam);
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
	 * Manifest Desc 삭제
	 *
	 * @param bkgCstmsAdvBlVO BL정보
	 * @throws DAOException
	 */
	public void removeBkgCstmsAdvBl(BkgCstmsAdvBlVO bkgCstmsAdvBlVO) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new CndManifestListDownloadDBDAOremoveBkgCstmsAdvBlDSQL(),
					bkgCstmsAdvBlVO.getColumnValues(), null);
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
	 * BL Batch No. 존재여부
	 *
	 * @param cstmsBatNo Batch No.
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchCndCstmsBlByKey(String cstmsBatNo) throws DAOException {
		boolean bResult = false;
		try
		{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("cstms_bat_no", cstmsBatNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchCndCstmsBlByKeyRSQL(), param, null);
			if (dbRowset.next())
				bResult = true;
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bResult;
	}

	/**
	 * VVD Batch No. 존재여부
	 * @param cstmsBatNo
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchCndCstmsVvdByKey(String cstmsBatNo) throws DAOException {
		boolean bResult = false;
		try
		{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("cstms_bat_no", cstmsBatNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchCndCstmsVvdByKeyRSQL(), param, null);
			if (dbRowset.next())
				bResult = true;
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bResult;
	}

	/**
	 * House B/L정보가 정확히 입력되었는지 확인하기 위해 관련 정보를 조회한다.<br>
	 *
	 * @param husBlInpChkCondVO 조회조건
	 * @return List<HouseBlDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HouseBlDetailVO> searchHusBlInpChkList(HusBlInpChkCondVO husBlInpChkCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HouseBlDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (husBlInpChkCondVO != null)
			{
				Map<String, String> mapVO = husBlInpChkCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchHusBlInpChkListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, HusBlInpChkVO.class);
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
	 * 현재시간 EST 시간대 구하기
	 *
	 * @return String
	 * @throws DAOException
	 */
	public String searchSysdate() throws DAOException {
		String strSysdate = "";
		try
		{
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchSysdateRSQL(), null, null);
			if (dbRowset.next())
			{
				strSysdate = dbRowset.getString(1);
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
		return strSysdate;
	}

	/**
	 * SEND LOG 테이블에 데이타 있는지 여부
	 *
	 * @param sBlNo BL_NO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkMiSendLog(String sBlNo) throws DAOException {
		boolean isMiSendLog = false;
		try
		{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bl_no", sBlNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOcheckMiSendLogRSQL(), param, null);
			if (dbRowset.next())
			{
				isMiSendLog = true;
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
		return isMiSendLog;
	}

	/**
	 * Vessel이 US Port를 지나는지 체크
	 *
	 * @param sVslCd sVslCd
	 * @param sSkdVoyNo sSkdVoyNo
	 * @param sSkdDirCd sSkdDirCd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkUsPort(String sVslCd, String sSkdVoyNo, String sSkdDirCd) throws DAOException {
		boolean isUsPort = false;
		try
		{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vsl_cd", sVslCd);
			param.put("skd_voy_no", sSkdVoyNo);
			param.put("skd_dir_cd", sSkdDirCd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOcheckUsPortRSQL(), param, null);
			if (dbRowset.next())
			{
				isUsPort = true;
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
		return isUsPort;
	}

	/**
	 * O/B Flag 가 'Y'인 CndCstmsRcvLogVO정보를 검색
	 *
	 * @param bkgCstmsAdvRcvLogVO BkgCstmsAdvRcvLogVO
	 * @return CstmsHldVO
	 * @throws DAOException
	 */
	public CstmsHldVO searchCstmsAlertFlag(BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO) throws DAOException {
		CstmsHldVO cstmsHldVO = null;
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("cstms_ack_rcv_dt", bkgCstmsAdvRcvLogVO.getRcvDt());
			param.put("cstms_ack_proc_rslt_cd", bkgCstmsAdvRcvLogVO.getCndAckSubCd());
			param.put("cstms_ack_key_no", bkgCstmsAdvRcvLogVO.getCstmsBatNo());
			param.put("cnt_cd", bkgCstmsAdvRcvLogVO.getCntCd());

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CndManifestListDownloadDBDAOsearchCstmsAlertFlagRSQL(), param, null);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, CstmsHldVO.class);
			if (list.size() > 0)
			{
				cstmsHldVO = (CstmsHldVO) list.get(0);
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
		return cstmsHldVO;
	}

	/**
	 * CRN 정보 조회
	 *
	 * @param CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO
	 * @return List<CndCstmsVslCrnNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CndCstmsVslCrnNoVO> searchBkgCstmsCndVslCrnNo(CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CndCstmsVslCrnNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cndCstmsVslCrnNoVO != null){
				Map<String, String> mapVO = cndCstmsVslCrnNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CndManifestListDownloadDBDAOsearchBkgCstmsCndVslCrnNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CndCstmsVslCrnNoVO .class);
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
	 * CRN 삭제
	 *
	 * @param CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO
	 * @throws DAOException
	 */
	public void removeBkgCstmsCndVslCrnNo(CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO) throws DAOException {
		//query parameter
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cndCstmsVslCrnNoVO != null){
				mapVO = cndCstmsVslCrnNoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CndManifestListDownloadDBDAOremoveBkgCstmsCndVslCrnNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 수정 저장<br>
	 *
	 * @param List<CndCstmsManifestAmendmentVO> cndCstmsManifestAmendmentVOList
	 * @param String aiDiv
	 * @exception DAOException, Exception
	 */
	public void modifyCstmsAmendManifest(List<CndCstmsManifestAmendmentVO> cndCstmsManifestAmendmentVOList, String aiDiv) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			velParam.put("ai_div", aiDiv);

			if (cndCstmsManifestAmendmentVOList.size() > 0) {
				int updCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate) new CndManifestListDownloadDBDAOmodifyCstmsAmendManifestUSQL(), cndCstmsManifestAmendmentVOList, velParam);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}

		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

}