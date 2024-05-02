/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Kor24ManifestListDownloadDBDAO.java
 *@FileTitle : Kor24ea Manifest List Download DB DAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 박상훈
 *@LastVersion : 1.0
 * 2009.05.25 박상훈
 * 1.0 Creation
 * --------------------------------------------------------
 * history
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.DateVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.HjtRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24BkgCstmsVvdSmryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.MrnCreateInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.BkgCstmsKrBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.BkgCstmsKrCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.BkgCstmsKrVvdSmryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.BlSummaryCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.BlSummaryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.ElNoMakeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BizNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BkgCntrQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BkgCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BkgCustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BlCustInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BlInfoKorVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BondCdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CblCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CgoDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CntrDataVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CorrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CustExistVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CustInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24DnHistVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24DownCheckVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24DownHistVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ElNoKorVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24EmpBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24EmptyCorrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ExistCntVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ExpDataVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ExportCheckInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ExportInfoDNVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ExportNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24FullEmpSumVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24IbMtInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24IbTransWhfVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24KcdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MailBoxVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestCrsChkInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestDNVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MrnInfoKorVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MrnVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MrnVslSysEtaEtdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MsnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ObTransWhfVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24OldExpChkVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24OrgBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24RateHeadVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24SubNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24SumVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsKrBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsKrCustVO;
import com.hanjin.syscommon.common.table.BkgCstmsKrDlHisVO;
import com.hanjin.syscommon.common.table.BkgCstmsKrXptLicVO;
import com.hanjin.syscommon.common.table.BkgRateVO;


/**
 * NIS2010 JapanManifestListDownloadDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author SON YUN SEUK
 * @see JapanManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class Kor24ManifestListDBDAO  extends DBDAOSupport {

	private static final long serialVersionUID = 8970020093005417506L;

	/**
	 * Kor24ManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param Kor24MrnNoVO p
	 * @return Kor24MrnNoVO
	 * @exception DAOException
	 **/
	@SuppressWarnings("unchecked")
	public Kor24MrnNoVO searchMrnNo(Kor24MrnNoVO p) throws DAOException
	{
		DBRowSet dbRowset = null;
		Kor24MrnNoVO kor24MrnNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24MrnNoVO> list = null;

		try
		{
			if(p != null)
			{
				Map<String, String> mapVO = p.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchMrnNoRSQL(),param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24MrnNoVO.class);
				if(list.size() > 0) kor24MrnNoVO = list.get(0);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return kor24MrnNoVO;
	}

	/**
	 * Manifest List정보를 조회하기 위해 우선 MrnNo를 조회한다.
	 * @param Kor24MrnNoVO p
	 * @return Kor24MrnVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24MrnVO searchMrnNoKor(Kor24MrnNoVO p) throws DAOException
	{
		DBRowSet dbRowset = null;
		Kor24MrnVO kor24MrnNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24MrnVO> list = null;

		try
		{
			if(p != null)
			{
				Map<String, String> mapVO = p.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchMrnNoKorRSQL(),param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24MrnVO.class);
				if(list.size() > 0) kor24MrnNoVO = list.get(0);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return kor24MrnNoVO;
	}

	/**
	 * ManifestList 조회
	 * @param Kor24MrnNoVO manifestInfoVO
	 * @return List<Kor24ManifestInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Kor24ManifestInfoVO> searchManifestInfoList(Kor24MrnNoVO manifestInfoVO)throws DAOException
	{
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24ManifestInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = manifestInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchManifestInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24ManifestInfoVO.class);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 세관에 이미 다운로드 시키기 위해 다시 ManifestInfo조회
	 * @param Kor24MrnNoVO manifestInfoVO
	 * @return List<Kor24ManifestCrsChkInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Kor24ManifestCrsChkInfoVO> searchManifestCrsChkInfoKorList(Kor24MrnNoVO manifestInfoVO)throws DAOException
	{
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24ManifestCrsChkInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = manifestInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchManifestCrsChkInfoKorRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24ManifestCrsChkInfoVO.class);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 세관에 이미 다운로드 시키기 위해 다시 ManifestInfo조회
	 * @param Kor24MrnNoVO manifestInfoVO
	 * @return List<Kor24ManifestInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Kor24ManifestInfoVO> searchManifestInfoKorList(Kor24MrnNoVO manifestInfoVO)throws DAOException
	{
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24ManifestInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = manifestInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchManifestInfoKorRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24ManifestInfoVO.class);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 컨테이너 정보조회
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return List<Kor24BkgCntrQtyInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Kor24BkgCntrQtyInfoVO> searchCntrInfo(String bkgNo, String bkgNoSplit)throws DAOException
	{
		//Kor24BkgCntrQtyInfoVO kor24BkgCntrQtyInfoVO = null;

		DBRowSet dbRowset = null;
		//Kor24MrnNoVO kor24MrnNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24BkgCntrQtyInfoVO> list = null;

		try
		{
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchCNTRInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24BkgCntrQtyInfoVO.class);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Download 된 컨테이너 목록 조회
	 * @param String bkgNo
	 * @param String tpCd
	 * @param String portCd
	 * @param String vvdCd
	 * @param String cBlNo
	 * @return List<Kor24BkgCntrQtyInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Kor24BkgCntrQtyInfoVO> searchCNTRCntInfoList(String bkgNo, String tpCd, String portCd, String vvdCd, String cBlNo) throws DAOException
	{
		//Kor24BkgCntrQtyInfoVO kor24BkgCntrQtyInfoVO = null;

		DBRowSet dbRowset = null;
		//Kor24MrnNoVO kor24MrnNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24BkgCntrQtyInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bkg_no",  bkgNo);
			mapVO.put("tp_cd",   tpCd);
			mapVO.put("port_cd", portCd);
			mapVO.put("vvd_cd",  vvdCd);
			mapVO.put("c_bl_no",  cBlNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchCNTRCntInfoListRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24BkgCntrQtyInfoVO.class);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * ExportInfo 조회
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return Kor24ExportNoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24ExportNoVO searchExportInfo(String bkgNo, String bkgNoSplit) throws DAOException
	{
		Kor24ExportNoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24ExportNoVO> list = null;

		try
		{
			param.put("a_bkg_no", bkgNo);
			param.put("a_bkg_no_split", bkgNoSplit);
			velParam.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchExportInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24ExportNoVO.class);
			if(list.size() > 0) kor24ExportNoVO = list.get(0);

		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kor24ExportNoVO;
	}

	/**
	 * ExportCheckInfo 조회
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return Kor24ExportCheckInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24ExportCheckInfoVO searchExportCheckInfo(String bkgNo, String bkgNoSplit) throws DAOException
	{
		Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24ExportCheckInfoVO> list = null;

		try
		{
			param.put("a_bkg_no", bkgNo);
			param.put("a_bkg_no_split", bkgNoSplit);
			velParam.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestLIstDBDAOSearchExportCheckInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24ExportCheckInfoVO.class);
			if(list.size() > 0) kor24ExportNoVO = list.get(0);

		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kor24ExportNoVO;
	}

	/**
	 * CustInfo 를 조회한다.
	 * @param String in_bound
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return Kor24CustInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24CustInfoVO searchCustInfo(String in_bound, String bkgNo, String bkgNoSplit) throws DAOException
	{
		Kor24CustInfoVO kor24CustInfoVO = null;

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24CustInfoVO> list = null;

		try
		{
			param.put("in_bound", in_bound);
			param.put("bkg_no", bkgNo);
			velParam.put("in_bound", in_bound);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchCustInfoRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24CustInfoVO.class);
			if(list.size() > 0) kor24CustInfoVO = list.get(0);

		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kor24CustInfoVO;
	}

	/**
	 * CargoDesc를 구한다.
	 * @param Kor24CgoDescVO kor24CgoDescVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCargoDesc(Kor24CgoDescVO kor24CgoDescVO) throws DAOException
	{
		String kor24CargoDescVO = null;

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try
		{
			Map<String, String> mapVO = kor24CgoDescVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchCargoDescRSQL(),param, velParam);
			if(dbRowset.next())
			{
				kor24CargoDescVO = dbRowset.getString("cstms_desc");
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kor24CargoDescVO;
	}

	/**
	 * CargoDesc를 구한다.
	 * @param Kor24CgoDescVO kor24CgoDescVO
	 * @return Kor24CgoDescVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24CgoDescVO searchCargoDescDN(Kor24CgoDescVO kor24CgoDescVO) throws DAOException
	{
		Kor24CgoDescVO returnVO = null;
		List<Kor24CgoDescVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = kor24CgoDescVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchCargoDescDNRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24CgoDescVO.class);
			if(list.size() > 0) returnVO = list.get(0);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnVO;
	}

	/**
	 * BizNo를 구한다.
	 * @param Kor24CgoDescVO kor24BizNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchOBBizNo(Kor24CgoDescVO kor24BizNoVO) throws DAOException
	{
		String returnString = null;

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = kor24BizNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchOBBizNoRSQL(),param, velParam);
			if(dbRowset.next())
			{
				returnString = dbRowset.getString("biz_no");
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnString;
	}

	/**
	 * BizNo를 구한다.
	 * @param Kor24CgoDescVO kor24BizNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBizNo(Kor24CgoDescVO kor24BizNoVO) throws DAOException
	{
		String returnString = null;

		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = kor24BizNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchBizNoRSQL(),param, velParam);
			if(dbRowset.next())
			{
				returnString = dbRowset.getString("biz_no");
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnString;
	}

	/**
	 * 컨테이너 타입을 구한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return Kor24CustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24CustVO searchCntCdTpS(String bkgNo, String bkgNoSplit)throws DAOException
	{
		Kor24CustVO returnValue = null;

		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24CustVO> list = null;

		try
		{
			param.put("a_bkg_no", bkgNo);
			param.put("a_bkg_no_split", bkgNoSplit);
			velParam.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchCntCdTpSRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24CustVO.class);
			if(list.size() > 0) returnValue = list.get(0);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnValue;
	}

	/**
	 * 컨테이너 타입을 구한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return Kor24CustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24CustVO searchCntCdTpC(String bkgNo, String bkgNoSplit)throws DAOException
	{
		Kor24CustVO returnValue = null;

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24CustVO> list = null;

		try
		{
			param.put("a_bkg_no", bkgNo);
			param.put("a_bkg_no_split", bkgNoSplit);
			velParam.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchCntCdTpCRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24CustVO.class);
			if(list.size() > 0) returnValue = list.get(0);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnValue;
	}

	/**
	 * 컨테이너 정보를 조회한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return Kor24CustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24CustVO searchCntCdTpN(String bkgNo, String bkgNoSplit)throws DAOException
	{
		Kor24CustVO returnValue = null;

		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24CustVO> list = null;

		try
		{
			param.put("a_bkg_no", bkgNo);
			param.put("a_bkg_no_split", bkgNoSplit);
			velParam.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no_split", bkgNoSplit);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchCntCdTpNRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24CustVO.class);
			if(list.size() > 0) returnValue = list.get(0);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnValue;
	}

	/**
	 * 국가정보를 조회한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @param String bcsTp
	 * @return Kor24CustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24CustVO searchCountryCode(String bkgNo, String bkgNoSplit, String bcsTp) throws DAOException
	{
		Kor24CustVO returnValue = null;

		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24CustVO> list = null;

		try
		{
			param.put("a_bkg_no", bkgNo);
			param.put("a_bkg_no_split", bkgNoSplit);
			param.put("biz_no_op", bcsTp);
			velParam.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no_split", bkgNoSplit);
			velParam.put("biz_no_op", bcsTp);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchCountryCodeRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24CustVO.class);
			if(list.size() > 0) returnValue = list.get(0);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnValue;
	}

	/**
	 * RegNo를 조회한다.
	 * @param String cntCd
	 * @param String custCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchRegNo(String cntCd, String custCd)throws DAOException
	{
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String returnString = null;
		try
		{
			param.put("cnt_cd", cntCd);
			param.put("cust_cd", custCd);
			velParam.put("cnt_cd", cntCd);
			velParam.put("cust_cd", custCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchRegNoRSQL(),param, velParam);
			if(dbRowset.next())
			{
				returnString = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnString;
	}

	/**
	 * ManifestList 조회
	 * @param String inPol
	 * @param Kor24ManifestInfoVO kor24ManifestInfoVO
	 * @return Kor24ManifestInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24ManifestInfoVO searchIBManifestInfoKor( String inPol, Kor24ManifestInfoVO kor24ManifestInfoVO )throws DAOException
	{
		Kor24ManifestInfoVO iBManifest = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24ManifestInfoVO> list = null;

		try
		{
			param.put("in_pol",   inPol);
			param.put("a_bkg_no", kor24ManifestInfoVO.getBkgNo());
			param.put("in_vvd", kor24ManifestInfoVO.getInVvd());

			velParam.put("in_pol", inPol);
			velParam.put("a_bkg_no", kor24ManifestInfoVO.getBkgNo());
			velParam.put("in_vvd", kor24ManifestInfoVO.getInVvd());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchIBManifestKorRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24ManifestInfoVO.class);
			if(list!=null && list.size() > 0)
			{
				iBManifest = list.get(0);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return iBManifest;
	}

	/**
	 * Cust정보를 조회한다.
	 * @param Kor24ManifestInfoVO kor24ManifestInfoVO
	 * @return Kor24ManifestInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24ManifestInfoVO searchCustInfoKor( Kor24ManifestInfoVO kor24ManifestInfoVO )throws DAOException
	{
		Kor24ManifestInfoVO kor24CustInfo = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24ManifestInfoVO> list = null;

		try
		{
			param.put("a_bkg_no",kor24ManifestInfoVO.getBkgNo());
			param.put("a_tr_cd", kor24ManifestInfoVO.getTp());
			param.put("kt_port", kor24ManifestInfoVO.getKtPort());
			param.put("a_kt_seq",kor24ManifestInfoVO.getHidden3());

			velParam.put("a_bkg_no",kor24ManifestInfoVO.getBkgNo());
			velParam.put("a_tr_cd", kor24ManifestInfoVO.getTp());
			velParam.put("kt_port", kor24ManifestInfoVO.getKtPort());
			velParam.put("a_kt_seq",kor24ManifestInfoVO.getHidden3());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchCustInfoKorRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24ManifestInfoVO.class);
			if(list !=null && list.size() > 0)
			{
				kor24CustInfo = list.get(0);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kor24CustInfo;
	}

	/**
	 * CustInfoCheck
	 * @param Kor24ManifestInfoVO kor24ManifestInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCustInfoCheck(Kor24ManifestInfoVO kor24ManifestInfoVO )throws DAOException
	{
		String returnValue = "";
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("a_bkg_no",kor24ManifestInfoVO.getBkgNo());
			param.put("a_tr_cd", kor24ManifestInfoVO.getTp());
			param.put("kt_port", kor24ManifestInfoVO.getKtPort());
			param.put("a_kt_seq",kor24ManifestInfoVO.getHidden3());

			velParam.put("a_bkg_no",kor24ManifestInfoVO.getBkgNo());
			velParam.put("a_tr_cd", kor24ManifestInfoVO.getTp());
			velParam.put("kt_port", kor24ManifestInfoVO.getKtPort());
			velParam.put("a_kt_seq",kor24ManifestInfoVO.getHidden3());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchCustInfoCheckRSQL(),param, velParam);
			if(dbRowset.next())
			{
				returnValue = dbRowset.getString("CUST_CHECK");
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnValue;
	}

	/**
	 * 컨테이너 토탈 카운트를 구한다.
	 * @param Kor24ManifestInfoVO kor24ManifestInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCntrTtlCntKor(Kor24ManifestInfoVO kor24ManifestInfoVO )throws DAOException
	{
		String returnValue = "";
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("a_bkg_no",kor24ManifestInfoVO.getBkgNo());
			param.put("a_tr_cd", kor24ManifestInfoVO.getTp());
			param.put("kt_port", kor24ManifestInfoVO.getKtPort());
			param.put("a_kt_seq",kor24ManifestInfoVO.getHidden3());
			param.put("c_bl_no",kor24ManifestInfoVO.getCBlNo());

			velParam.put("a_bkg_no",kor24ManifestInfoVO.getBkgNo());
			velParam.put("a_tr_cd", kor24ManifestInfoVO.getTp());
			velParam.put("kt_port", kor24ManifestInfoVO.getKtPort());
			velParam.put("a_kt_seq",kor24ManifestInfoVO.getHidden3());
			velParam.put("c_bl_no", kor24ManifestInfoVO.getCBlNo());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchCntrTtlCntKorRSQL(),param, velParam);
			if(dbRowset.next())
			{
				returnValue = dbRowset.getString("CNT");
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnValue;
	}

	/**
	 * ExportInfo정보를 구한다.
	 * @param Kor24ManifestInfoVO kor24ManifestInfoVO
	 * @return Kor24ExportNoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24ExportNoVO searchExportInfoKor(Kor24ManifestInfoVO kor24ManifestInfoVO) throws DAOException
	{
		Kor24ExportNoVO kor24ExportInfo = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24ExportNoVO> list = null;


		try
		{
			param.put("a_bkg_no",kor24ManifestInfoVO.getBkgNo());
			param.put("a_tr_cd", kor24ManifestInfoVO.getTp());
			param.put("kt_port", kor24ManifestInfoVO.getKtPort());
			param.put("a_kt_seq",kor24ManifestInfoVO.getHidden3());

			velParam.put("a_bkg_no",kor24ManifestInfoVO.getBkgNo());
			velParam.put("a_tr_cd", kor24ManifestInfoVO.getTp());
			velParam.put("kt_port", kor24ManifestInfoVO.getKtPort());
			velParam.put("a_kt_seq",kor24ManifestInfoVO.getHidden3());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchExportInfoKorRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24ExportNoVO.class);
			if(list!=null && list.size()>0)
			{
				kor24ExportInfo = list.get(0);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kor24ExportInfo;
	}

	/**
	 * 다운로드할 Manifest정보를 조회한다.
	 * @param Kor24ManifestInfoVO kor24ManifestInfoVO
	 * @return Kor24ManifestDNVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24ManifestDNVO[] searchDownManifestInfo(Kor24ManifestInfoVO kor24ManifestInfoVO) throws DAOException
	{
		Kor24ManifestDNVO[] kor24ManifestDNVOs = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24ManifestDNVO> list = null;

		try
		{
			Map<String, String> mapVO = kor24ManifestInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchDownManifestInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24ManifestDNVO.class);
			if(list != null && list.size() > 0)
			{
				kor24ManifestDNVOs = list.toArray(new Kor24ManifestDNVO[0]);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kor24ManifestDNVOs;
	}

	/**
	 * 면체여부 체크할 정보를 구한다.
	 * @param String inBkgNo
	 * @return Kor24RateHeadVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24RateHeadVO searchExemptWhf(String inBkgNo) throws DAOException
	{
		Kor24RateHeadVO whfNode = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24RateHeadVO> list = null;

		try
		{
			param.put("in_bkg_no", inBkgNo);
			velParam.put("in_bkg_no", inBkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchExemptWhfRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24RateHeadVO.class);
			if(list != null)
			{
				if(list.size() > 0)	whfNode = list.get(0);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return whfNode;
	}

	/**
	 * 위험여부 정보를 구한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchDangerInfo(String bkgNo, String bkgNoSplit) throws DAOException
	{
		String[] a_imo_class = new String[3];
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no_split", bkgNoSplit);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchDangerInfoRSQL(),param, velParam);
			int i=0;
//			while(dbRowset.next() && i < 3 )
//			{
//				a_imo_class[i] = dbRowset.getString(1);
//				i++;
//			}
//			for(int j=i;j<3;j++)
//			{
//				a_imo_class[j] = "";
//			}

			// R4J Rule에 의한 변경
			for(int j=0;j<3;j++)
			{
				a_imo_class[j] = "";
			}
			while(dbRowset.next()){
				if(i<3){
	                 a_imo_class[i] = dbRowset.getString(1);
	                 i++;
				}
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return a_imo_class;
	}

	/**
	 * BkgCntrList를 구한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return List<Kor24BkgCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Kor24BkgCntrVO> searchBKGCNTRList(String bkgNo, String bkgNoSplit) throws DAOException
	{
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24BkgCntrVO> list = null;

		try
		{
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchBKGCNTRListRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24BkgCntrVO.class);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * ExportInfo를 구한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return List<Kor24ExportInfoDNVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Kor24ExportInfoDNVO> searchExportInfoDNList(String bkgNo, String bkgNoSplit) throws DAOException
	{
		List<Kor24ExportInfoDNVO> list = null;

		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("a_bkg_no", bkgNo);
			velParam.put("a_bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchExportInfoDNRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24ExportInfoDNVO.class);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * CustomerInfo를 구한다.
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return List<Kor24BkgCustVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Kor24BkgCustVO> searchCustomerInfoList(String bkgNo, String bkgNoSplit) throws DAOException
	{
		List<Kor24BkgCustVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchCustomerInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24BkgCustVO.class);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * ElNo를 구한다.
	 * @param ElNoMakeVO elNoMakeVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchElNoMake(ElNoMakeVO elNoMakeVO)throws DAOException
	{
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = elNoMakeVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchElNoMakeRSQL(),param, velParam);
			if(dbRowset.next())
			{
				list = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 전송된 Manifest History의 Seq정보를 구한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return List<BkgCstmsKrBlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsKrBlVO> searchSeqNSndHistKor(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException
	{
		List<BkgCstmsKrBlVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchSeqNSndHisKorRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsKrBlVO.class);
			if (list==null || list.size() < 1) return null;
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Mrn No를 구한다.
	 * @param Kor24BkgCstmsVvdSmryVO paramVO
	 * @return Kor24BkgCstmsVvdSmryVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24BkgCstmsVvdSmryVO searchMrnKor(Kor24BkgCstmsVvdSmryVO paramVO) throws DAOException
	{
		Kor24BkgCstmsVvdSmryVO rtnValue = null;

		List<Kor24BkgCstmsVvdSmryVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = paramVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchMrnKorRSQL(),param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24BkgCstmsVvdSmryVO.class);
			if(list != null && list.size() > 0)
			{
				rtnValue = list.get(0);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnValue;
	}

	/**
	 * 다운로드 히스토리 Insert를 위한 MaxSeq정보를 구한다.
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxSeqDownHist(BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO) throws DAOException
	{
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrDlHisVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchMaxSeqDownHistRSQL(),param, velParam);
			if(dbRowset.next())
			{
				list = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 다운로드 히스토리 Insert를 위한 MaxSeq정보를 구한다.
	 * @param String mrnNbr
	 * @param String vvd
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxSeqDownHistKor(String mrnNbr, String vvd) throws DAOException
	{
		String cnt = "0";
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("mrn_nbr", mrnNbr);
			param.put("vvd", vvd);
			velParam.put("mrn_nbr", mrnNbr);
			velParam.put("vvd", vvd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchMaxSeqDownHistKorRSQL(),param, velParam);
			if(dbRowset.next())
			{
				cnt = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * VVDInfo에서 MaxSeq를 구한다.
	 * @param Kor24BkgCstmsVvdSmryVO vvdPararm
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxSeqVVDKor(Kor24BkgCstmsVvdSmryVO vvdPararm) throws DAOException
	{
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = vvdPararm.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchMaxSeqVVDKorRSQL(),param, velParam);

			if(dbRowset.next())
			{
				list = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 세관에 다운로드된 히스토리건수를 구한다.
	 * @param BkgCstmsKrDlHisVO cntDnHistParam
	 * @return String
	 * @exception DAOException
	 */
	public String searchCountDownHistKor(BkgCstmsKrDlHisVO cntDnHistParam)throws DAOException
	{
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = cntDnHistParam.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchCountDownHistKorRSQL(),param, velParam);

			if(dbRowset.next())
			{
				list = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 해당 Manifest 의 BlNo를 조회한다.
	 * @param BkgRateVO bkgRateVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBizNo (BkgRateVO bkgRateVO) throws DAOException
	{
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgRateVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchBizNoRSQL(),param, velParam);

			if(dbRowset.next())
			{
				list = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Cust 정보를 다운로드하기 위해 Seq값을 구한다.
	 * @param Kor24BizNoVO kor24BizNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCustRegNo(Kor24BizNoVO kor24BizNoVO)throws DAOException
	{
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = kor24BizNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchCustRegNoRSQL(),param, velParam);

			if(dbRowset.next())
			{
				list = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * ElNo조회
	 * @param Kor24ElNoKorVO elNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchElNoKor(Kor24ElNoKorVO elNoVO) throws DAOException
	{
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = elNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchElNoKorRSQL(),param, velParam);

			if(dbRowset.next())
			{
				list = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 세관에 다운로드된 히스토리를 체크한다.
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchDownHistCheck(BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO) throws DAOException
	{
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrDlHisVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchDownHistCheckRSQL(),param, velParam);

			if(dbRowset.next())
			{
				list = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 해당 부킹에 BREAK BULK가 있는 지 체크한다.
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBreakBulkCheck(BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO) throws DAOException
	{
		String list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrDlHisVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchBreakBulkCheckRSQL(),param, velParam);

			if(dbRowset.next())
			{
				list = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * BkgSts정보를 조회한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBkgSts(BkgCstmsKrBlVO bkgCstmsKrBlVO)throws DAOException
	{
		String rtn = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchBkgStsRSQL(),param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24ManifestInfoVO.class);
			if(dbRowset.next())
			{
				rtn = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return rtn;
	}

	/**
	 * 이미 다운로드된 정보를 다시 다운로드 하기 위해 해당 Manifest정보를 ReLoad한다.
	 * @param Kor24MrnNoVO manifestInfoVO
	 * @return List<Kor24ManifestInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Kor24ManifestInfoVO> searchReManifestInfoList(Kor24MrnNoVO manifestInfoVO)throws DAOException
	{
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24ManifestInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = manifestInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchReManifestInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24ManifestInfoVO.class);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Export정보를 조회한다.
	 * @param BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchExportChk(BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String rtn = null;
		try
		{
			Map<String, String> mapVO = bkgCstmsKrXptLicVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchExportChkRSQL(),param, velParam);

			if(dbRowset.next())
			{
				rtn = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return rtn;
	}

	/**
	 * 세관에 전송되었는지 여부를 알아본다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return BkgCstmsKrBlVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsKrBlVO searchTransmitCheckKor(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException
	{
		List<BkgCstmsKrBlVO> list = null;
		BkgCstmsKrBlVO rtnNode = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchTransmitCheckKorRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsKrBlVO.class);
			if(list != null && list.size() > 0)
			{
				rtnNode = list.get(0);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return rtnNode;
	}

	/**
	 * VVD Yard Insert를 위한 Max Seq값을 구한다.
	 * @param Kor24BkgCstmsVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxSeqVVDYard(Kor24BkgCstmsVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException
	{
		String yd_chk = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchMaxSeqVVDYardRSQL(),param, velParam);
			if(dbRowset.next())
			{
				yd_chk = dbRowset.getString(1);
			}

		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return yd_chk;
	}

	/**
	 * 다운로드하기 위한 max Seq값을 조회한다.
	 * @param Kor24BkgCstmsVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxSendCheckKor(Kor24BkgCstmsVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException
	{
		String mf_snd_dt = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchMaxSendCheckKorRSQL(),param, velParam);
			if(dbRowset.next())
			{
				mf_snd_dt = dbRowset.getString(1);
			}

		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return mf_snd_dt;
	}

	/**
	 * BkgStatus정보를 조회한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return List<BkgCstmsKrBlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsKrBlVO> searchBkgStsKorList(BkgCstmsKrBlVO bkgCstmsKrBlVO)throws DAOException
	{
		List<BkgCstmsKrBlVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchBkgStsKorRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsKrBlVO.class);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 세관에 다운로드된 정보가 이미 전송되지 않았는지 여부를 체크한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchNotTransmitCheck(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException
	{
		String stringCount = null;
		int returnCount = 0;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchNotTransmitCheckRSQL(),param, velParam);
			if(dbRowset.next())
			{
				stringCount = dbRowset.getString(1);
			}
			if("".equals(stringCount)) stringCount = "0";
			returnCount = Integer.parseInt(stringCount);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnCount;
	}

	/**
	 * 세관에 다운로드된 Break Bulk가 포함된경우 이미 전송되지 않았는지 여부를 체크한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchBbNotTransmitCheck(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException
	{
		String stringCount = null;
		int returnCount = 0;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchBbNotTransmitCheckRSQL(),param, velParam);
			if(dbRowset.next())
			{
				stringCount = dbRowset.getString(1);
			}
			if("".equals(stringCount)) stringCount = "0";
			returnCount = Integer.parseInt(stringCount);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnCount;
	}

	/**
	 * 세관에 다운로드시킬 Trans정보의 Seq번호를 구한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxTransSeqKor(BkgCstmsKrBlVO bkgCstmsKrBlVO)throws DAOException
	{
		String stringCount = "0";
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchMaxTransSeqKorRSQL(),param, velParam);
			if(dbRowset.next())
			{
				stringCount = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return stringCount;
	}

	/**
	 * 세관에 다운로드시킬 Trans정보의 Seq번호를 구한다.(Break Bulk 혼재된 경우)
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBbMaxTransSeqKor(BkgCstmsKrBlVO bkgCstmsKrBlVO)throws DAOException
	{
		String stringCount = "0";
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchBbMaxTransSeqKorRSQL(),param, velParam);
			if(dbRowset.next())
			{
				stringCount = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return stringCount;
	}

	/**
	 * 세관에 다운로드된 Manifest가 이미 전송되었는지 그 여부를 체크한다.
	 * @param Kor24BkgCstmsVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchSendCheckKor(Kor24BkgCstmsVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException
	{
		String stringCount = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchSendCheckKorRSQL(),param, velParam);
			if(dbRowset.next())
			{
				stringCount = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return stringCount;
	}

	/**
	 * 인바운드의 경우 TransType을 구한다.
	 * @param Kor24IbTransWhfVO ibTransWhfVO
	 * @return Kor24IbTransWhfVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24IbTransWhfVO searchIBTransTypeChg(Kor24IbTransWhfVO ibTransWhfVO) throws DAOException
	{
		List <Kor24IbTransWhfVO> list = null;
		Kor24IbTransWhfVO returnVal = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = ibTransWhfVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOSearchIBTransTypeChgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24IbTransWhfVO.class);
			if(list == null) return null;
			if(list.size() > 0)
			{
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * 아웃바운드의 경우 TransType을 구한다.
	 * @param Kor24ObTransWhfVO obTransWhfVO
	 * @return Kor24ObTransWhfVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24ObTransWhfVO searchOBTransTypeChg(Kor24ObTransWhfVO obTransWhfVO) throws DAOException
	{
		List <Kor24ObTransWhfVO> list = null;
		Kor24ObTransWhfVO returnVal = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = obTransWhfVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOSearchOBTransTypeChgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24ObTransWhfVO.class);
			if(list == null) return null;
			if(list.size() > 0)
			{
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * 세관에 Send Count를 구한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchKor24MainSndCount(BkgCstmsKrBlVO bkgCstmsKrBlVO)throws DAOException
	{
		String transType = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchKorMainSndCountRSQL(),param, velParam);
			if(dbRowset.next())
			{
				transType = dbRowset.getString(1);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return transType;
	}

	/**
	 * 세관으로 Bl정보를 다운로드한다.
	 * @param Kor24ManifestDNVO kor24ManifestDNVO
	 * @return int
	 * @exception DAOException
	 */
	public int addBlInfoKor(Kor24ManifestDNVO kor24ManifestDNVO) throws DAOException
	{
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int rtn = 0;
		try
		{
			Map<String, String> mapVO = kor24ManifestDNVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			rtn = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOaddBlInfoKorCSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtn;
	}

	/**
	 * 세관으로 컨테이너 정보를 다운로드한다.
	 * @param BkgCstmsKrCntrVO bkgCstmsKrCntrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addCNTRInfoKor(BkgCstmsKrCntrVO bkgCstmsKrCntrVO) throws DAOException
	{
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOaddCntrInfoKorCSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관으로 ExportNo를 다운로드한다.
	 * @param BkgCstmsKrXptLicVO xptlicVO
	 * @return int
	 * @exception DAOException
	 */
	public int addExportNoMake(BkgCstmsKrXptLicVO xptlicVO) throws DAOException
	{
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = xptlicVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOAddExportNoMakeCSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			if(se.getErrorCode() == 1) { // 무결성 에러가 날 경우
				throw new DAOException("BKG01125@" + xptlicVO.getCBlNo());
			}

			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관으로 ExportNo를 다운로드한다.
	 * @param BkgCstmsKrXptLicVO xptlicVO
	 * @return int
	 * @exception DAOException
	 */
	public int addExportNoKor(BkgCstmsKrXptLicVO xptlicVO) throws DAOException
	{
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = xptlicVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOAddExportNoKorCSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			if(se.getErrorCode() == 1) { // 무결성 에러가 날 경우
				throw new DAOException("BKG01125@" + xptlicVO.getCBlNo());
			}

			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관으로 ExportNo를 다운로드한다.
	 * @param Kor24MailBoxVO kor24MailBoxVO
	 * @return int
	 * @exception DAOException
	 */
	public int addExportNo(Kor24MailBoxVO kor24MailBoxVO)throws DAOException
	{
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = kor24MailBoxVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOAddExportNoCSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			if(se.getErrorCode() == 1) { // 무결성 에러가 날 경우
				throw new DAOException("BKG01125@" + kor24MailBoxVO.getCBlNo());
			}
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * B/L List check후 조회된 Cust 정보 Insert
	 * @param BkgCstmsKrCustVO custKrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addCustInfoKor(BkgCstmsKrCustVO custKrVO)throws DAOException
	{
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = custKrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOaddCustInfoKorCSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * B/L List check후 조회된 Cust 정보 Insert(Break Bulk인 경우)
	 * @param BkgCstmsKrCustVO custKrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addBbCustInfoKor(BkgCstmsKrCustVO custKrVO)throws DAOException
	{
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = custKrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOaddBbCustInfoKorCSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관에 다운로드된 Manifest DownLoad History를 Insert한다.
	 * @param Kor24DownHistVO kor24DownHistVO
	 * @return int
	 * @exception DAOException
	 */
	public int addDownHistSeq(Kor24DownHistVO kor24DownHistVO) throws DAOException
	{
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = kor24DownHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOAddDownHistSeqCSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			int errcd = se.getErrorCode();
			if(errcd != 1)
			{
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관에 다운로드된 Manifest DownLoad History를 Insert한다.
	 * @param BkgCstmsKrDlHisVO hisParam
	 * @return int
	 * @exception DAOException
	 */
	public int addDownHistKor(BkgCstmsKrDlHisVO hisParam) throws DAOException
	{
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = hisParam.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOAddDownHistKorCSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관에 다운로드된 Manifest DownLoad History를 Insert한다.
	 * @param Kor24DownHistVO kor24DownHistVO
	 * @return int
	 * @exception DAOException
	 */
	public int addDownHist(Kor24DownHistVO kor24DownHistVO) throws DAOException
	{
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = kor24DownHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOAddDownHistCSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			int errcd = se.getErrorCode();
			if(errcd != 1)
			{
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관으로 Vessel정보를 다운로드한다.
	 * @param Kor24BkgCstmsVvdSmryVO vvdParam
	 * @return int
	 * @exception DAOException
	 */
	public int addVVDInfo(Kor24BkgCstmsVvdSmryVO vvdParam) throws DAOException
	{
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = vvdParam.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOAddVVDInfoCSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			int errcd = se.getErrorCode();
			if(errcd != 1)
			{
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관에 B/L정보를 다운로드한다.(이미 다운로드되었던 B/L정보)
	 * @param Kor24ManifestDNVO kor24ManifestDNVO
	 * @return int
	 * @exception DAOException
	 */
	public int addReBlInfoKor(Kor24ManifestDNVO kor24ManifestDNVO) throws DAOException
	{
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = kor24ManifestDNVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOAddReBlInfoKorCSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관에 ExportNo를 다운로드한다.
	 * @param Kor24MailBoxVO kor24MailBoxVO
	 * @return int
	 * @exception DAOException
	 */
	public int addExportNoMailBoxKor(Kor24MailBoxVO kor24MailBoxVO)throws DAOException
	{
		int insertCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = kor24MailBoxVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insertCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOAddExportNoMailBoxKorCSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			if(se.getErrorCode() == 1) { // 무결성 에러가 날 경우
				throw new DAOException("BKG01125@" + kor24MailBoxVO.getCBlNo());
			}
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insertCount;
	}

	/**
	 * 세관에 다운로드된 MrnNo정보를 업데이트한다.
	 * @param Kor24BkgCstmsVvdSmryVO mrnParam
	 * @return int
	 * @exception DAOException
	 */
	public int modifyMrnNoKor(Kor24BkgCstmsVvdSmryVO mrnParam) throws DAOException
	{
		int modifyCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = mrnParam.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			modifyCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOModifyMrnNoKorUSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return modifyCount;
	}

	/**
	 * 세관에 다운로드된 히스토리정보를 업데이트한다.
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyDownHistKor(BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO) throws DAOException
	{
		int modifyCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrDlHisVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			modifyCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOModifyDownHistKorUSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return modifyCount;
	}

	/**
	 * 세관에 다운로드된 BizNo정보를 업데이트한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyBizNo(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException
	{
		int modifyCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			modifyCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOModifyBizNoUSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return modifyCount;

	}

	/**
	 * 세관에 다운로드된 삭제 표시 테이블의 정보를 업데이트한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyDelMarkKor(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException
	{
		int modifyCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			modifyCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOModifyDelMarkKorUSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return modifyCount;
	}

	/**
	 * 다운로드 히스토리를 업데이트 한다.
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyDownHist(BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO)throws DAOException
	{
		int modifyCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrDlHisVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			modifyCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOModifyDownHistUSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return modifyCount;
	}

	/**
	 * 세관에 다운로드된 Bl정보중에 가장 최근의 정보를 삭제한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeBlMaxInfoKor(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException
	{
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAORemoveBlMaxInfoKorDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 Bl정보중에 가장 최근의 정보를 삭제한다.(break bulk 포함된 경우)
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeBbBlMaxInfoKor(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException
	{
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAORemoveBbBlMaxInfoKorDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 컨테이너 정보중에 가장 최근의 정보를 삭제한다.
	 * @param BkgCstmsKrCntrVO bkgCstmsKrCntrVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeCNTRMaxInfoKor(BkgCstmsKrCntrVO bkgCstmsKrCntrVO) throws DAOException
	{
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAORemoveCNTRMaxInfoKorDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 컨테이너 정보중에 가장 최근의 정보를 삭제한다.(Break Bulk포함된 경우)
	 * @param BkgCstmsKrCntrVO bkgCstmsKrCntrVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeBbCNTRMaxInfoKor(BkgCstmsKrCntrVO bkgCstmsKrCntrVO) throws DAOException
	{
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAORemoveBbCNTRMaxInfoKorDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 고객정보중에 가장 최근의 정보를 삭제한다.
	 * @param BkgCstmsKrCustVO bkgCstmsKrCustVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeCustMaxInfoKor(BkgCstmsKrCustVO bkgCstmsKrCustVO) throws DAOException
	{
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrCustVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAORemoveCustMaxInfoKorDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 고객정보중에 가장 최근의 정보를 삭제한다. (Break Bulk포함된 경우)
	 * @param BkgCstmsKrCustVO bkgCstmsKrCustVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeBbCustMaxInfoKor(BkgCstmsKrCustVO bkgCstmsKrCustVO) throws DAOException
	{
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrCustVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAORemoveBbCustMaxInfoKorDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 ElNo중에서 가장 최근의 Seq번호를 삭제한다.
	 * @param BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeElNoMaxInfoKor(BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO) throws DAOException
	{
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrXptLicVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAORemoveElNoMaxInfoKorDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 ElNo중에서 가장 최근의 Seq번호를 삭제한다.(Break Bulk 포함된 경우)
	 * @param BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeBbElNoMaxInfoKor(BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO) throws DAOException
	{
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrXptLicVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAORemoveBbElNoMaxInfoKorDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 다운로드된 컨테이너 정보를 삭제한다.
	 * @param BkgCstmsKrCntrVO bkgCstmsKrCntrVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeCNTRInfoKor(BkgCstmsKrCntrVO bkgCstmsKrCntrVO) throws DAOException
	{
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAORemoveCNTRInfoKorDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 DownLoad되어 있는 ElNo정보를 삭제한다.
	 * @param BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeElNoInfoKor(BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO) throws DAOException
	{
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrXptLicVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAORemoveElNoInfoKorDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관으로 DownLoad되어 있는 Cust정보를 삭제한다.
	 * @param BkgCstmsKrCustVO bkgCstmsKrCustVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeCustInfoKor(BkgCstmsKrCustVO bkgCstmsKrCustVO) throws DAOException
	{
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrCustVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAORemoveCustInfoKorDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * 세관에 DownLoad되어 있는 Bl정보를 삭제한다.
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeBlInfoKor(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException
	{
		int deleteCount = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			deleteCount = new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAORemoveBlInfoKorDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return deleteCount;
	}

	/**
	 * MRN 조회
	 *
	 * @param Kor24MrnNoVO kor24MrnNoVO
	 * @return Kor24MrnNoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24MrnNoVO searchMrn(Kor24MrnNoVO kor24MrnNoVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<Kor24MrnNoVO> kor24MrnNoVOs = null;
		Kor24MrnNoVO outKor24MrnNoVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = kor24MrnNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchMRNRSQL(),param, velParam);
			kor24MrnNoVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24MrnNoVO.class);
			if (kor24MrnNoVOs==null) return null;
			if (kor24MrnNoVOs.size() > 0) outKor24MrnNoVO = kor24MrnNoVOs.get(0);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outKor24MrnNoVO;
	}

	/**
	 * BL별 Container 정보, EL등 정보를 맞추기 위하여 Max SEQ 조회
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxSeq(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException
	{
		String seq = "0";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchMaxSeqRSQL(),param, velParam);
			if(dbRowset.next()) seq = dbRowset.getString("TRNS_SEQ");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return seq;
	}

	/**
	 * 초기 BKG NO 를 만든다.
	 * @return String
	 * @exception DAOException
	 */
	public String searchFirstTmpBkgNoAssign() throws DAOException
	{
		String bkgNo = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try
		{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchFirstTmpBkgNoAssignRSQL(),param, velParam);
			if(dbRowset.next()) bkgNo = dbRowset.getString("BKG_NO");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgNo;
	}

	/**
	 * 초기 BL No 생성
	 * @return String
	 * @exception DAOException
	 */
	public String searchFirstTmpBlNoAssign() throws DAOException
	{
		String blNo = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try
		{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchFirstTmpBlNoAssignRSQL(),param, velParam);
			if(dbRowset.next()) blNo = dbRowset.getString("BL_NO");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return blNo;
	}

	/**
	 * 생성된 BL 번호가 존재하는지 확인
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchTmpBlExistKor(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException {
		int cnt =0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchTmpBlExistKorRSQL(),param, velParam);
			if(dbRowset.next()) cnt = dbRowset.getInt("CNT");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * BKG NO 자동 생성 ( PACKAGE 이용 )
	 * @param String ofcCd
	 * @param String usrId
	 * @return String
	 * @exception DAOException
	 */
	public String searchFirstTmpBkgNoAssign(String ofcCd, String usrId) throws DAOException
	{
		String bkgNo = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("usr_id", usrId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchFirstTmpBkgNoAssignRSQL(),param, velParam);
			if(dbRowset.next()) bkgNo = dbRowset.getString("BKG_NO");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bkgNo;
	}

	/**
	 * Bonded WareHouse 코드 조회
	 * @param String cstmsCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchWareHouseLoc(String cstmsCd) throws DAOException
	{
		String locCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();

		DBRowSet dbRowset = null;
		try
		{
			mapVO.put("cstms_cd", cstmsCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchWarehouseLocRSQL(),param, velParam);
			if(dbRowset.next()) locCd = dbRowset.getString("LOC_CD");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return locCd;
	}

	/**
	 * Amendment 정정 정보 삭제
	 * @param String subNo
	 * @exception DAOException
	 */
	public void removeCorrInfo(String subNo) throws DAOException
	{
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sub_no", subNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOremoveCorrInfoDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * Amendment 정정 정보 추가
	 * @param Kor24CorrInfoVO corrInfoVO
	 * @exception DAOException
	 */
	public void addCorrInfo(Kor24CorrInfoVO corrInfoVO) throws DAOException
	{
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = corrInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOaddCorrInfoCSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Amendment BL 정정 정보 삭제
	 * @param String subNo
	 * @exception DAOException
	 */
	public void removeBlCorrInfo(String subNo) throws DAOException
	{
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sub_no", subNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOremoveBlCorrInfoDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * Amendment Container 정정 정보 삭제
	 * @param String subNo
	 * @exception DAOException
	 */
	public void removeCNTRCorrInfo(String subNo) throws DAOException
	{
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sub_no", subNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOremoveCNTRCorrInfoDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * Amendment Export Lic. No정보를 삭제
	 * @param String subNo
	 * @exception DAOException
	 */
	public void removeExportCorrInfo(String subNo) throws DAOException
	{
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sub_no", subNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOremoveExportCorrInfoDSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 *  신규 Download하기위해 다른 VVD로 같은 B/L이 Download된것이 있는지 여부 확인하기 위해 조회
	 * @param Kor24DownCheckVO downCheckVO
	 * @return Kor24DownCheckVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24DownCheckVO searchDownCheck(Kor24DownCheckVO downCheckVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		Kor24DownCheckVO outVO = null;
		List<Kor24DownCheckVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = downCheckVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchDownCheckRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24DownCheckVO.class);
			if(list!=null && list.size() > 0) outVO = list.get(0);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outVO;
	}

	/**
	 * Discharing CY 의 Validation Check
	 * @param String dischCy
	 * @return String
	 * @throws DAOException
	 */
	public String searchDischCyValChk(String dischCy) throws DAOException
	{
		DBRowSet dbRowset = null;
		String valCheck = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("otr_dchg_cd", dischCy);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchDischCyValChkRSQL(),param, velParam);
			if (dbRowset.next()) valCheck = dbRowset.getString(1);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return valCheck;
	}

	/**
	 * 입력받은 BAC 일괄 UPDATE (UPDATE BONDED AREA CODE)
	 * @param Kor24BondCdVO kor24BondCdVO
	 * @exception DAOException
	 */
	public void modifyBondCdKor(Kor24BondCdVO kor24BondCdVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = kor24BondCdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOmodifyBondCdKorUSQL(), param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG VVD Summary Info 정보를 UPDATE
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	public void modifyManifestSmryInfo(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			 new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOmodifyManifestSmryInfoUSQL(), param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * B/L INFO 삭제
	 * @param Kor24BlInfoKorVO kor24BlInfoKorVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeBlInfo(Kor24BlInfoKorVO kor24BlInfoKorVO) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try
		{
			Map<String, String> mapVO = kor24BlInfoKorVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			cnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOremoveBlInfoDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * 전송 후 전송일 + 전송자 저장
	 * @param Kor24BlInfoKorVO kor24BlInfoKorVO
	 * @exception DAOException
	 */
	public void modifyDiscSendDate(Kor24BlInfoKorVO kor24BlInfoKorVO) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = kor24BlInfoKorVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOmodifyDiscSendDateUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Manifest VVD 전송정보 UPDATE
	 * @param bkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	public void modifyVVDSendKor(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO)throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOmodifyVVDSendKorUSQL(), param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Manifest 전송일시 UPDATE
	 * @param Kor24BondCdVO kor24BondCdVO
	 * @exception DAOException
	 */
	public void modifyKor24ManiSndDateUser(Kor24BondCdVO kor24BondCdVO)throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = kor24BondCdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOmodifyKorManiSndDateUserUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * HJT로 부터 수신된 메시지를 Update한다.
	 * @param HjtRcvMsgVO hjtRcvMsgVO
	 * @exception DAOException
	 */
	public void modifyHJTResponse(HjtRcvMsgVO hjtRcvMsgVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = hjtRcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOmodifyHJTResponseUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 전송이 안된경우 SNED DATE UPDATE
	 *
	 * @param Kor24BlInfoKorVO kor24BlInfoKorVO
	 * @exception DAOException
	 */
	public void modifyTransmitDate(Kor24BlInfoKorVO kor24BlInfoKorVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = kor24BlInfoKorVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOmodifyTransmitDateUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MSN table에서 MRN Info를 Delete
	 * @param MrnCreateInfoVO[] mrnCreateInfoVOs
	 * @exception DAOException
	 */
	public void removeMsnCreateInfo(MrnCreateInfoVO[] mrnCreateInfoVOs) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = null;
		try
		{
			for (int i=0; i < mrnCreateInfoVOs.length; i++) {
				mapVO = mrnCreateInfoVOs[i].getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOremoveMsnCreateInfoDSQL(), param, velParam);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MRN 정보 DELETE
	 * @param MrnCreateInfoVO[] mrnCreateInfoVOs
	 * @exception DAOException
	 */
	public void removeMrnCreateInfo(MrnCreateInfoVO[] mrnCreateInfoVOs) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = null;
		try
		{
			for (int i=0; i < mrnCreateInfoVOs.length; i++) {
				mapVO = mrnCreateInfoVOs[i].getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOremoveMrnCreateInfoDSQL(), param, velParam);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MRN 정보 조회
	 * @param Kor24MrnInfoKorVO mrnInfoKorVO
	 * @return Kor24MrnInfoKorVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24MrnInfoKorVO searchMrnInfoKor(Kor24MrnInfoKorVO mrnInfoKorVO) throws DAOException
	{
		Kor24MrnInfoKorVO kor24MrnInfoKorVO = null;
		List<Kor24MrnInfoKorVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = mrnInfoKorVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchMrnInfoKorRSQL(),param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24MrnInfoKorVO.class);
			if (list!=null && list.size() > 0) kor24MrnInfoKorVO = list.get(0);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kor24MrnInfoKorVO;
	}

	/**
	 * 전송할 DATA가 존재하는지 COUNT 조회
	 * @param Kor24ExistCntVO kor24ExistCntVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchExistCntKor(Kor24ExistCntVO kor24ExistCntVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String cnt = null;

		try
		{
			Map<String, String> mapVO = kor24ExistCntVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOsearchExistCntKorRSQL(), param, velParam);
			if(dbRowset.next())
			{
				cnt = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}

	/**
	 * Container Summary 정보 조회
	 * @param Kor24SumVO sumVO
	 * @return Kor24SumVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24SumVO searchSummaryInfo(Kor24SumVO sumVO) throws DAOException
	{
		List <Kor24SumVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Kor24SumVO kor24SumVO = null;
		try
		{
			Map<String, String> mapVO = sumVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOsearchSummaryInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24SumVO.class);
			if(list != null && list.size() > 0) kor24SumVO = list.get(0);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return kor24SumVO;
	}

	/**
	 * Master, Console, Empty B/L Count 및 Package, Weight, Measure Total 값 조회
	 * @param BlSummaryCondVO blSummaryCondVO
	 * @return BlSummaryVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BlSummaryVO searchBlSummaryInfo(BlSummaryCondVO blSummaryCondVO) throws DAOException
	{
		List <BlSummaryVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		BlSummaryVO returnNode = null;
		try
		{
			Map<String, String> mapVO = blSummaryCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOsearchBlSummaryInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlSummaryVO.class);
			if(list == null) return null;
			if(list.size() > 0) returnNode = list.get(0);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnNode;
	}

	/**
	 * VVD Max Sequence 조회
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchVVDSeqKor(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO)throws DAOException
	{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnString = "";
		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOsearchVVDSeqKorRSQL(), param, velParam);
			if(dbRowset.next())
			{
				rtnString = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * VVD INFO가 이전에 전송되었는지 여부 조회
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchVVDSendCheck(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnString = null;
		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOsearchVVDSendCheckRSQL(), param, velParam);
			if(dbRowset.next())
			{
				rtnString = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * 전송되었거나 데이터가 없는 경우 새로운 데이터를 추가
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	public void addVVDInfoInKor24Cstm(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException
	{
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOaddVVDInfoInKorCstmCSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 전송되지 않은 데이터인 경우 조회 조건으로 UPDATE
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	public void modifyVVDInfoKor(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException
	{
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOmodifyVVDInfoKorUSQL(),param, velParam);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * OutBound 'A' Type 의 Bond Area Code 조회
	 * @param BkgCstmsKrBlCondVO bkgCstmsKrBlCondVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBondAreaCd(BkgCstmsKrBlCondVO bkgCstmsKrBlCondVO)throws DAOException
	{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnString = null;
		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOsearchBondAreaCdRSQL(), param, velParam);
			if(dbRowset.next())
			{
				rtnString = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * 전송 날짜와 시간을 조회
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return DateVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public DateVO searchSendDate(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO)throws DAOException
	{
		List <DateVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DateVO returnNode = null;
		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOsearchSendDateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DateVO.class);
			if(list == null) return null;
			if(list.size() > 0) returnNode = list.get(0);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnNode;
	}

	/**
	 * C Type 의 Transmit Count 조회
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchTransPreCnt(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO)throws DAOException
	{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnString = null;
		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOsearchTransPreCntRSQL(), param, velParam);
			if(dbRowset.next())
			{
				rtnString = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * BKG_1344 화면에 조회되는 VVD 정보 조회
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return BkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsKrVvdSmryVO searchVVDInfoKor(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO)throws DAOException
	{
		List <BkgCstmsKrVvdSmryVO> list = null;
		BkgCstmsKrVvdSmryVO returnVal = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOsearchVVDInfoKorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsKrVvdSmryVO.class);
			if(list == null) return null;
			if(list.size() > 0)
			{
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * Manifest Main VVD 정보 삭제
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	public void removeVvdInfoKor(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO)throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOremoveVvdInfoKorDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * B/L Container 정보 삭제
	 * @param Kor24CntrDataVO kor24CntrDataVO
	 * @exception DAOException
	 */
	public void removeCNTRDataKor(Kor24CntrDataVO kor24CntrDataVO) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = kor24CntrDataVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOremoveCNTRDataKorDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * B/L Customer 정보 삭제
	 * @param Kor24BlCustInfoVO kor24BlCustInfoVO
	 * @exception DAOException
	 */
	public void removeBlCustInfoKor(Kor24BlCustInfoVO kor24BlCustInfoVO) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = kor24BlCustInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOremoveBlCustInfoKorDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Export License 정보 삭제
	 * @param Kor24ExpDataVO kor24ExpDataVO
	 * @exception DAOException
	 */
	public void removeExportDataKor(Kor24ExpDataVO kor24ExpDataVO) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = kor24ExpDataVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOremoveExportDataKorDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 삭제를 하기 위해 DOWN LOAD SEQ 를 조회
	 * @param Kor24DnHistVO kor24DnHistVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxSeqDnHistKor(Kor24DnHistVO kor24DnHistVO)throws DAOException
	{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String dlSeq = null;
		try
		{
			Map<String, String> mapVO = kor24DnHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOsearchMaxSeqDnHistKorRSQL(), param, velParam);
			if (dbRowset.next()) dlSeq = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dlSeq;
	}

	/**
	 * DownLoad History 추가
	 * @param Kor24DnHistVO kor24DnHistVO
	 * @exception DAOException
	 */
	public void addDnHistKor(Kor24DnHistVO kor24DnHistVO)throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = kor24DnHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOaddDnHistKorCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG VVD Summary Info 정보를 UPDATE (하선신고)
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	public void modifyDiscVVDSmryKor24Info(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOmodifyDiscVVDSmryKorInfoUSQL(), param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Download 전의 MRN No 와 ETA/ETD, Sysdate 조회
	 *
	 * @param Kor24MrnVslSysEtaEtdVO mrnVslSysEtaEtdVO
	 * @return Kor24MrnVslSysEtaEtdVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24MrnVslSysEtaEtdVO searchMrnVslSysDtEtaEtdDt(Kor24MrnVslSysEtaEtdVO mrnVslSysEtaEtdVO) throws DAOException
	{
		List <Kor24MrnVslSysEtaEtdVO> list = null;
		Kor24MrnVslSysEtaEtdVO returnVal = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = mrnVslSysEtaEtdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOsearchMrnVslSysDtEtaEtdDtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24MrnVslSysEtaEtdVO.class);
			if(list == null) return null;
			if(list.size() > 0)
			{
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * searcMrnNoSysDtEtaEtdDt에서 조회값이 없을 경우 Vessel Port Skd상의 Max calling Indicator를 이용하여 다시조회
	 *
	 * @param Kor24MrnVslSysEtaEtdVO mrnVslSysEtaEtdVO
	 * @return Kor24MrnVslSysEtaEtdVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24MrnVslSysEtaEtdVO searchMrnVslSysDtEtaEtdMaxDt(Kor24MrnVslSysEtaEtdVO mrnVslSysEtaEtdVO) throws DAOException
	{
		List <Kor24MrnVslSysEtaEtdVO> list = null;
		Kor24MrnVslSysEtaEtdVO returnVal = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = mrnVslSysEtaEtdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOsearchMrnVslSysDtEtaEtdMaxDtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24MrnVslSysEtaEtdVO.class);
			if(list == null) return null;
			if(list.size() > 0)
			{
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * InBound Trans Type 조회, WHF/CTT Exception CHECK
	 *
	 * @param Kor24IbTransWhfVO ibTransWhfVO
	 * @return Kor24IbTransWhfVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24IbTransWhfVO searchIbTransTpExpWhf(Kor24IbTransWhfVO ibTransWhfVO) throws DAOException
	{
		List <Kor24IbTransWhfVO> list = null;
		Kor24IbTransWhfVO returnVal = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = ibTransWhfVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOsearchIbTransTpExpWhfRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24IbTransWhfVO.class);
			if(list == null) return null;
			if(list.size() > 0)
			{
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * OutBound Trans Type 조회, WHF/CTT Exception CHECK
	 *
	 * @param Kor24ObTransWhfVO obTransWhfVO
	 * @return Kor24ObTransWhfVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24ObTransWhfVO searchObTransTpExpWhf(Kor24ObTransWhfVO ObTransWhfVO) throws DAOException
	{
		List <Kor24ObTransWhfVO> list = null;
		Kor24ObTransWhfVO returnVal = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = ObTransWhfVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24ManifestListDBDAOsearchObTransTpExpWhfRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24ObTransWhfVO.class);
			if(list == null) return null;
			if(list.size() > 0)
			{
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * BKG Creation_Customer Info.화면상의 BL Type과 같은 걸로 조회
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchBlTp(String bkgNo) throws DAOException
	{
		String blTp = "S";

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchBlTpRSQL(),param, velParam);
			if(dbRowset.next()) blTp = dbRowset.getString("BL_TP");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return blTp;
	}

	/**
	 * 2009/12/22일 이후 Outbound로 다운로드된 데이터중에서 Inbound B/L정보를 조회
	 * @param cntrNo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24IbMtInfoVO searchIbTsMtInfo(String cntrNo) throws DAOException
	{
		Kor24IbMtInfoVO kor24IbMtInfoVO = null;
		List <Kor24IbMtInfoVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchIbTsMtInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24IbMtInfoVO.class);
			if(list == null) return null;
			if(list.size() > 0) kor24IbMtInfoVO = list.get(0);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


		return kor24IbMtInfoVO;
	}

	/**
	 * Customer테이블에 BL테이블의 CSTMS_DEL_TP_CD와 같은 코드를 넣기위해 재 조회
	 * @param Kor24KcdVO kor24KcdVO
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchKcdTpCust(Kor24KcdVO kor24KcdVO) throws DAOException
	{
		String[] kcdTp = null;
		List<String> list = new ArrayList<String>();

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try
		{
			Map<String, String> mapVO = kor24KcdVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchKcdTpCustRSQL(),param, velParam);
			if (dbRowset!=null) {
				while(dbRowset.next()) {
					list.add(dbRowset.getString("CSTMS_DECL_TP_CD"));
				}
			}
			if(list == null) return null;
			if(list.size() > 0) {
				kcdTp = new String[list.size()];
				for(int i=0; i < list.size(); i++) {
					kcdTp[i] = list.get(i);
				}
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kcdTp;
	}

	/**
	 * MSN 이 존재하는지 여부 체크
	 * @param String vvdCd
	 * @param String portCd
	 * @param String msnNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchMsnExistCnt(String vvdCd, String portCd, String msnNo) throws DAOException
	{
		String check = null;

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("in_vvd", vvdCd);
			mapVO.put("kt_port", portCd);
			mapVO.put("msn_number", msnNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchMsnExistCntRSQL(),param, velParam);
			if(dbRowset.next()) check = dbRowset.getString("CNT");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return check;
	}

	/**
	 * Msn No를 Update
	 * @param Kor24MsnNoVO kor24MsnNoVO
	 * @throws DAOException
	 */
	public void modifyMsnNo(Kor24MsnNoVO kor24MsnNoVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = kor24MsnNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOmodifyMsnNoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Wharfage Notice 정보 조회
	 * @param String inVvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchWhfNotice(String inVvd) throws DAOException
	{
		String notice = null;

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("in_vvd", inVvd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchWhfNoticeRSQL(),param, velParam);
			if(dbRowset.next()) notice = dbRowset.getString("CNT");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return notice;
	}

	/**
	 * Original BL No 조회
	 * @param String cBlNo
	 * @return Kor24OrgBlVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24OrgBlVO searchOrgBlNo(String cBlNo) throws DAOException
	{
		Kor24OrgBlVO kor24OrgBlVO = null;
		List <Kor24OrgBlVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("c_bl_no", cBlNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchOrgBlNoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24OrgBlVO.class);
			if(list == null) return null;
			if(list.size() > 0) kor24OrgBlVO = list.get(0);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kor24OrgBlVO;
	}

	/**
	 * SUB_NO 조회
	 * @param Kor24SubNoVO kor24SubNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSubNo(Kor24SubNoVO kor24SubNoVO) throws DAOException
	{
		String subNo = null;

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = kor24SubNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchSubNoRSQL(),param, velParam);
			if(dbRowset.next()) subNo = dbRowset.getString("SUB_NO");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return subNo;
	}

	/**
	 * SUB_NO 정보 삭제
	 * @param String subNo
	 * @exception DAOException
	 */
	public void removeSubNo(String subNo) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sub_no", subNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOremoveSubNoDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Empty Amend 정보 추가
	 * @param Kor24EmptyCorrInfoVO emptyCorrInfoVO
	 * @throws DAOException
	 */
	public void addEmptyCorrInfo(Kor24EmptyCorrInfoVO emptyCorrInfoVO) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = emptyCorrInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOaddEmptyCorrInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * InBound Empty 전송일시 UPDATE
	 *
	 * @param Kor24EmpBlInfoVO empBlInfoVO
	 * @throws DAOException
	 */
	public void modifyEmpTransmitDate(Kor24EmpBlInfoVO empBlInfoVO) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = empBlInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOmodifyEmpTransmitDateUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * InBound Empty 전송일시 UPDATE
	 *
	 * @param Kor24EmpBlInfoVO empBlInfoVO
	 * @throws DAOException
	 */
	public void modifyEmpCorrInfo(Kor24EmpBlInfoVO empBlInfoVO) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = empBlInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOmodifyEmpCorrInfoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Empty BL 의 CSTMS_BL_NO 재조회
	 *
	 * @param Kor24CblCntrVO cblCntrVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCblNo(Kor24CblCntrVO cblCntrVO) throws DAOException
	{
		String cBlNo = null;

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = cblCntrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchCblNoRSQL(),param, velParam);
			if(dbRowset.next()) cBlNo = dbRowset.getString("C_BL_NO");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cBlNo;
	}

	/**
	 * Full/Empty Container Summary 조회
	 *
	 * @param Kor24SumVO sumVO
	 * @return Kor24FullEmpSumVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24FullEmpSumVO searchFullEmpCntrSum(Kor24SumVO sumVO) throws DAOException
	{
		Kor24FullEmpSumVO kor24FullEmpSumVO = null;
		List <Kor24FullEmpSumVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = sumVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchFullEmpCntrSumRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24FullEmpSumVO.class);
			if(list == null) return null;
			if(list.size() > 0) kor24FullEmpSumVO = list.get(0);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kor24FullEmpSumVO;
	}

	/**
	 * Customer 정보가 존재하는지 체크
	 *
	 * @param Kor24CustExistVO custExistVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCustExistCnt(Kor24CustExistVO  custExistVO) throws DAOException
	{
		String cnt = "0";

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = custExistVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchCustExistCntRSQL(),param, velParam);
			if(dbRowset.next()) cnt = dbRowset.getString("CNT");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * searchExportInfoDNList의 조회갯수와 비교하기위해 조회
	 * @param Kor24OldExpChkVO kor24OldExpChkVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchOldExportChk(Kor24OldExpChkVO Kor24OldExpChkVO) throws DAOException
	{
		String cnt = "0";

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = Kor24OldExpChkVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchOldExportChkRSQL(),param, velParam);
			if(dbRowset.next()) cnt = dbRowset.getString("CNT");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * 최초 다운인지 여부를 판단 조회
	 *
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchDownHistChkForRtv(BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO) throws DAOException
	{
		String cnt = "0";

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrDlHisVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchDownHistChkForRtvRSQL(),param, velParam);
			if(dbRowset.next()) cnt = dbRowset.getString("CNT");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * Correction 전송후 SendDate Update
	 *
	 * @param String usrId
	 * @param String subNo
	 * @throws DAOException
	 */
	public void modifySndDtCorrInfo(String usrId, String subNo) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String,String>();

			mapVO.put("usr_id", usrId);
			mapVO.put("sub_no", subNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOmodifyEmpCorrInfoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * OutBound 조회시 ETB Date 조회
	 *
	 * @param String vvdCd
	 * @param String polCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchEtbDate(String vvdCd, String polCd) throws DAOException
	{
		String etbDt = "";

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("in_vvd", vvdCd);
			mapVO.put("in_pol", polCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchEtbDateRSQL(),param, velParam);
			if(dbRowset.next()) etbDt = dbRowset.getString("ETB_DT");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return etbDt;
	}

	/**
	 * Shipper Code에 따라 MDM Customer에서 Customer Type을 조회
	 *
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchCustType(String bkgNo) throws DAOException
	{
		String custType = "";

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchCustTypeRSQL(),param, velParam);
			if(dbRowset.next()) custType = dbRowset.getString("CUST_TYPE");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return custType;
	}
	
	/**
	 * Shipper Code에 따라 MDM Customer에서 Customer Order Type을 조회
	 *
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchCustOrderType(String bkgNo) throws DAOException
	{
		String custType = "";

		//Kor24ExportCheckInfoVO kor24ExportNoVO = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOsearchCustOrderTypeRSQL(),param, velParam);
			if(dbRowset.next()) custType = dbRowset.getString("CUST_TYPE");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return custType;
	}

	/**
	 * 해당 VVD가 B/L이 없는 공동 VVD 인지 체크
	 *
	 * @param String vvd
	 * @param String portCd
	 * @param String polCd
	 * @return int
	 * @throws DAOException
	 */
	public int searchNoneBLCheck(String vvd, String portCd, String polCd) throws DAOException
	{
		int cntBkg = 0;

		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvd);
			mapVO.put("port_cd", portCd);
			mapVO.put("pol_cd", polCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchNoneBLVVDCheckRSQL(),param, velParam);
			if(dbRowset.next()) cntBkg = dbRowset.getInt("CNTBKG");
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cntBkg;
	}

	/**
	 * 해당 VVD가 B/L이 없는 VVD 정보를 조회
	 *
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return BkgCstmsKrVvdSmryVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsKrVvdSmryVO searchNoneBLInfo(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException
	{
		BkgCstmsKrVvdSmryVO returnVal = null;
		List <BkgCstmsKrVvdSmryVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchNoneBLVVDInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsKrVvdSmryVO.class);
			if(list == null) return null;
			if(list.size() > 0) returnVal = list.get(0);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnVal;
	}

	/**
	 * [ESM_BKG_1329]cross check 관련 result remark 저장<br>
	 *
	 * @param Kor24ManifestCrsChkInfoVO kor24ManifestCrsChkInfoVO
	 * @throws EventException
	 * @throws DAOException
	 */
	public void modifyCrossInfoKor(Kor24ManifestCrsChkInfoVO kor24ManifestCrsChkInfoVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = kor24ManifestCrsChkInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOmodifyCrossInfoKorUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1329]cross check 관련 result remark 저장<br>
	 *
	 * @param Kor24ManifestCrsChkInfoVO kor24ManifestCrsChkInfoVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 * @throws DAOException
	 */
	public void addCrossInfoKor(Kor24ManifestCrsChkInfoVO kor24ManifestCrsChkInfoVO , SignOnUserAccount account ) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try	{
			Map<String, String> mapVO = kor24ManifestCrsChkInfoVO.getColumnValues();

			param.put("usr_id", account.getUsr_id());

			param.putAll(mapVO);
			velParam.putAll(mapVO);


//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOaddCrossInfoKorCSQL(), param,	velParam);
//			if (result == Statement.EXECUTE_FAILED)
//				throw new DAOException("Fail to insert SQL");
			new SQLExecuter("").executeUpdate((ISQLTemplate) new Kor24ManifestListDBDAOaddCrossInfoKorCSQL(),param, velParam);
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * amand 후에 snd flg 업데이트
	 *
	 * @param Kor24BlInfoKorVO kor24BlInfoKorVO
	 * @exception DAOException
	 */
	public void modifySndFlg(Kor24BlInfoKorVO kor24BlInfoKorVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = kor24BlInfoKorVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24ManifestListDBDAOmodifySndFlgUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 한국세관 Cross Chk 화면에 BL Count 조회
	 *
	 * @param Kor24MrnNoVO manifestInfoVO
	 * @return Kor24MrnNoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24MrnNoVO searchManifestCrsChkInfoSumKorList(Kor24MrnNoVO manifestInfoVO)throws DAOException

	{
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24MrnNoVO> list = null;
		Kor24MrnNoVO returnVal = null;

		try
		{
			Map<String, String> mapVO = manifestInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24ManifestListDBDAOSearchManifestCrsChkInfoSumKorRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24MrnNoVO.class);

			if(list == null) return null;
			if(list.size() > 0) returnVal = list.get(0);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnVal;
	}

}