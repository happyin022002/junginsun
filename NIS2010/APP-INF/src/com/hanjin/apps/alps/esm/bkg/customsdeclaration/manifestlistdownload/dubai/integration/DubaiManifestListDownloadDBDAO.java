/*=========================================================
 *Copyright(c) 2017 SM Line
 *@FileName : DubaiMainfestListDownloadDBDAO.java
 *@FileTitle : DubaiMainfestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.02.16
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiBlManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiCntrManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiVesselManifestListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgCstmsCdConvCtntVO;
import com.hanjin.syscommon.common.table.BkgCstmsDuBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsDuCntrMfVO;
import com.hanjin.syscommon.common.table.BkgCstmsDuCntrVO;
import com.hanjin.syscommon.common.table.BkgCstmsDuCustVO;
import com.hanjin.syscommon.common.table.BkgCstmsDuVvdVO;

/**
 * NIS2010 DubaiMainfestListDownloadDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Min Jeong
 * @see DubaiMainfestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class DubaiManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * VVD 정보 조회<br>
	 * 
	 * @param dubaiManifestListCondVO 조회조건
	 * @return DubaiVesselManifestListVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DubaiVesselManifestListVO> searchDubaiVesselManifestList(DubaiManifestListCondVO dubaiManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DubaiVesselManifestListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (dubaiManifestListCondVO != null)
			{
				Map<String, String> mapVO = dubaiManifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("")
						.executeQuery((ISQLTemplate) new DubaiManifestListDownloadDBDAOsearchDubaiVesselManifestListRSQL(),
								param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, DubaiVesselManifestListVO.class);
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
	 * BL 정보 조회<br>
	 * 
	 * @param dubaiManifestListCondVO 조회조건
	 * @return List<DubaiBlManifestListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DubaiBlManifestListVO> searchDubaiBlManifestList(DubaiManifestListCondVO dubaiManifestListCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<DubaiBlManifestListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (dubaiManifestListCondVO != null)
			{
				Map<String, String> mapVO = dubaiManifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new DubaiManifestListDownloadDBDAOsearchDubaiBlManifestListRSQL(), param,
						velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, DubaiBlManifestListVO.class);
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
	 * Container 정보 조회<br>
	 * 
	 * @param dubaiManifestListCondVO 조회조건
	 * @return List<DubaiCntrManifestListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DubaiCntrManifestListVO> searchDubaiCntrManifestList(DubaiManifestListCondVO dubaiManifestListCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<DubaiCntrManifestListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (dubaiManifestListCondVO != null)
			{
				Map<String, String> mapVO = dubaiManifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery((ISQLTemplate) new DubaiManifestListDownloadDBDAOsearchDubaiCntrManifestListRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DubaiCntrManifestListVO.class);
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
	 * @param dubaiManifestListCondVO 조회정보
	 * @throws DAOException
	 */
	public void addBkgCstmsDuVvd(DubaiManifestListCondVO dubaiManifestListCondVO) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new DubaiManifestListDownloadDBDAOaddBkgCstmsDuVvdCSQL(),
					dubaiManifestListCondVO.getColumnValues(), dubaiManifestListCondVO.getColumnValues());
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
	 * 세관 관련 BL 정보 생성
	 * 
	 * @param dubaiManifestListCondVO 조회정보
	 * @throws DAOException
	 */
	public void addBkgCstmsDuBl(DubaiManifestListCondVO dubaiManifestListCondVO) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new DubaiManifestListDownloadDBDAOaddBkgCstmsDuBlCSQL(),
					dubaiManifestListCondVO.getColumnValues(), dubaiManifestListCondVO.getColumnValues());
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
	 * 세관 관련 Customer 정보 생성
	 * 
	 * @param dubaiManifestListCondVO 조회정보
	 * @throws DAOException
	 */
	public void addBkgCstmsDuCust(DubaiManifestListCondVO dubaiManifestListCondVO) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new DubaiManifestListDownloadDBDAOaddBkgCstmsDuCustCSQL(),
					dubaiManifestListCondVO.getColumnValues(), dubaiManifestListCondVO.getColumnValues());
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
	 * 세관 관련 Container 정보 생성
	 * 
	 * @param dubaiManifestListCondVO 조회정보
	 * @throws DAOException
	 */
	public void addBkgCstmsDuCntr(DubaiManifestListCondVO dubaiManifestListCondVO) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new DubaiManifestListDownloadDBDAOaddBkgCstmsDuCntrCSQL(),
					dubaiManifestListCondVO.getColumnValues(), dubaiManifestListCondVO.getColumnValues());
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
	 * 세관 관련 Container Mf 정보 생성
	 * 
	 * @param dubaiManifestListCondVO 조회정보
	 * @throws DAOException
	 */
	public void addBkgCstmsDuCntrMf(DubaiManifestListCondVO dubaiManifestListCondVO) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new DubaiManifestListDownloadDBDAOaddBkgCstmsDuCntrMfCSQL(),
					dubaiManifestListCondVO.getColumnValues(), dubaiManifestListCondVO.getColumnValues());
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
	 * 세관 VVD 정보 삭제
	 * 
	 * @param dubaiManifestListCondVO 조회정보
	 * @throws DAOException
	 */
	public void removeBkgCstmsDuVvd(DubaiManifestListCondVO dubaiManifestListCondVO) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new DubaiManifestListDownloadDBDAOremoveBkgCstmsDuVvdDSQL(),
					dubaiManifestListCondVO.getColumnValues(), dubaiManifestListCondVO.getColumnValues());
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
	 * 세관 BL 정보 삭제
	 * 
	 * @param dubaiManifestListCondVO 조회정보
	 * @throws DAOException
	 */
	public void removeBkgCstmsDuBl(DubaiManifestListCondVO dubaiManifestListCondVO) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new DubaiManifestListDownloadDBDAOremoveBkgCstmsDuBlDSQL(),
					dubaiManifestListCondVO.getColumnValues(), dubaiManifestListCondVO.getColumnValues());
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
	 * 세관 Customer 정보 삭제
	 * 
	 * @param dubaiManifestListCondVO 조회정보
	 * @throws DAOException
	 */
	public void removeBkgCstmsDuCust(DubaiManifestListCondVO dubaiManifestListCondVO) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new DubaiManifestListDownloadDBDAOremoveBkgCstmsDuCustDSQL(),
					dubaiManifestListCondVO.getColumnValues(), dubaiManifestListCondVO.getColumnValues());

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
	 * 세관 Container 정보 삭제
	 * 
	 * @param dubaiManifestListCondVO 조회정보
	 * @throws DAOException
	 */
	public void removeBkgCstmsDuCntr(DubaiManifestListCondVO dubaiManifestListCondVO) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new DubaiManifestListDownloadDBDAOremoveBkgCstmsDuCntrDSQL(),
					dubaiManifestListCondVO.getColumnValues(), dubaiManifestListCondVO.getColumnValues());
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
	 * 세관 Container MF 정보 삭제
	 * 
	 * @param dubaiManifestListCondVO 조회정보
	 * @throws DAOException
	 */
	public void removeBkgCstmsDuCntrMf(DubaiManifestListCondVO dubaiManifestListCondVO) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new DubaiManifestListDownloadDBDAOremoveBkgCstmsDuCntrMfDSQL(),
					dubaiManifestListCondVO.getColumnValues(), dubaiManifestListCondVO.getColumnValues());
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
	 * VVD 수정
	 * 
	 * @param bkgCstmsDuVvd VVD
	 * @throws DAOException
	 */
	public void modifyBkgCstmsDuVvd(BkgCstmsDuVvdVO bkgCstmsDuVvd) throws DAOException {
		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new DubaiManifestListDownloadDBDAOmodifyBkgCstmsDuVvdUSQL(),
					bkgCstmsDuVvd.getColumnValues(), bkgCstmsDuVvd.getColumnValues());
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
	 * BL 수정
	 * 
	 * @param bkgCstmsDuBls BL
	 * @throws DAOException
	 */
	public void modifyBkgCstmsDuBl(List<BkgCstmsDuBlVO> bkgCstmsDuBls) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsDuBls.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsDuBls.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new DubaiManifestListDownloadDBDAOmodifyBkgCstmsDuBlUSQL(),
						bkgCstmsDuBls, velParam);
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
	 * CUSTOMER 수정
	 * 
	 * @param bkgCstmsDuCusts CUSTOMER
	 * @throws DAOException
	 */
	public void modifyBkgCstmsDuCust(List<BkgCstmsDuCustVO> bkgCstmsDuCusts) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsDuCusts.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsDuCusts.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new DubaiManifestListDownloadDBDAOmodifyBkgCstmsDuCustUSQL(), bkgCstmsDuCusts,
						velParam);
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
	 * Container 수정
	 * 
	 * @param bkgCstmsDuCntrs Container
	 * @throws DAOException
	 */
	public void modifyBkgCstmsDuCntr(List<BkgCstmsDuCntrVO> bkgCstmsDuCntrs) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsDuCntrs.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsDuCntrs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new DubaiManifestListDownloadDBDAOmodifyBkgCstmsDuCntrUSQL(), bkgCstmsDuCntrs,
						velParam);
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
	 * Container Mf 수정
	 * 
	 * @param bkgCstmsDuCntrMfs Container Mf
	 * @throws DAOException
	 */
	public void modifyBkgCstmsDuCntrMf(List<BkgCstmsDuCntrMfVO> bkgCstmsDuCntrMfs) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsDuCntrMfs.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsDuCntrMfs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new DubaiManifestListDownloadDBDAOmodifyBkgCstmsDuCntrMfUSQL(),
						bkgCstmsDuCntrMfs, velParam);
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
	 * 국가별 Package Unit 조회
	 * 
	 * @param bkgCstmsCdConvCtntVO
	 * @return List<BkgCstmsCdConvCtntVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsCdConvCtntVO> searchPkgUnitList(BkgCstmsCdConvCtntVO bkgCstmsCdConvCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCstmsCdConvCtntVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (bkgCstmsCdConvCtntVO != null)
			{
				Map<String, String> mapVO = bkgCstmsCdConvCtntVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new DubaiManifestListDownloadDBDAOsearchPkgUnitListRSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsCdConvCtntVO.class);
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
	 * BL 정보 조회<br>
	 * 
	 * @param dubaiManifestListCondVO 조회조건
	 * @return DubaiBlInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DubaiBlInfoVO searchDubaiManifestInfo(DubaiManifestListCondVO dubaiManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		DubaiBlInfoVO dubaiBlInfoVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (dubaiManifestListCondVO != null)
			{
				Map<String, String> mapVO = dubaiManifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("")
						.executeQuery((ISQLTemplate) new DubaiManifestListDownloadDBDAOsearchDubaiManifestInfoRSQL(),
								param, velParam);
				List<DubaiBlInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, DubaiBlInfoVO.class);
				if (list.size() > 0)
				{
					dubaiBlInfoVO = list.get(0);
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
		return dubaiBlInfoVO;
	}
	
}
