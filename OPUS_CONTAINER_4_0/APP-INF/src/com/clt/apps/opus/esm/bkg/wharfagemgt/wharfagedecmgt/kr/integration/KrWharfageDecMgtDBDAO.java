/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : KrWharfageDecMgtDBDAO.java
 *@FileTitle : KrWharfageDecMgtDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.04.29 정재엽
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBkgCstmsLocVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBlCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrCntrVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrCustVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfAplyPortRtVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBerthCdCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgInfoCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgKrWhfBlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlChkListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlChkVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlExpInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlExptInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCfmVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCgoClassCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgExpSumVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgGenVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCntrExpInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCommInvListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCommInvVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecBzcInfoForApIfVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecCheckSendDtVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecChkListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecChkVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecEdiRtVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecEdiVvdVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecExptVolVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecIfArInvVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfExemptInfoCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfLocCdListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfPortRtListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfPortRtVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfRateListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfRateVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVvdDtlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.VvdPortEtdEtaVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlChkVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfCommInvListVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecChkVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfVslInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ApInvDtrbVO;
import com.clt.syscommon.common.table.ApInvHdrVO;
import com.clt.syscommon.common.table.BkgCstmsLocVO;
import com.clt.syscommon.common.table.BkgKrWhfBlVO;
import com.clt.syscommon.common.table.BkgKrWhfBrthVO;
import com.clt.syscommon.common.table.BkgKrWhfCfmVO;
import com.clt.syscommon.common.table.BkgKrWhfCntrVO;
import com.clt.syscommon.common.table.BkgKrWhfCustVO;
import com.clt.syscommon.common.table.BkgKrWhfPortRtVO;
import com.clt.syscommon.common.table.BkgKrWhfRtVO;
import com.clt.syscommon.common.table.BkgKrWhfVolVO;
import com.clt.syscommon.common.table.BkgKrWhfVvdDtlVO;

/**
 * OPUS KrWharfageDecMgtDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jeong Jay Yoeb
 * @see
 * @since J2EE 1.4
 */

public class KrWharfageDecMgtDBDAO extends DBDAOSupport {

	/**
	 * Wharfage 신고 대상 부두 정보 조회
	 *
	 * @param KrWhfBerthCdCondVO whfBerthCdCondVO
	 * @return List<BkgKrWhfBrthVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgKrWhfBrthVO> searchKrWhfBerthCd(KrWhfBerthCdCondVO whfBerthCdCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgKrWhfBrthVO> list = null;

		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (whfBerthCdCondVO != null)
			{
				Map<String, String> mapVO = whfBerthCdCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfBerthCdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgKrWhfBrthVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


	/**
	 * Whrafage 신고 대상 부두 정보 생성
	 *
	 * @param List<BkgKrWhfBrthVO> bkgKrWhfBrthVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBkgKrWhfBrth (List<BkgKrWhfBrthVO> bkgKrWhfBrthVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfBrthVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOaddBkgKrWhfBrthCSQL(),
						bkgKrWhfBrthVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Wharfage 신고 대상 부두 정보 업데이트
	 *
	 * @param List<BkgKrWhfBrthVO> bkgKrWhfBrthVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyBkgKrWhfBrth (List<BkgKrWhfBrthVO> bkgKrWhfBrthVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfBrthVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOmodifyBkgKrWhfBrthUSQL(),
						bkgKrWhfBrthVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Whrafage 신고 대상 부두 정보 삭제
	 *
	 * @param List<BkgKrWhfBrthVO> bkgKrWhfBrthVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeBkgKrWhfBrth (List<BkgKrWhfBrthVO> bkgKrWhfBrthVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfBrthVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOremoveBkgKrWhfBrthDSQL(),
						bkgKrWhfBrthVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Port별 Wharfage  요율 목록 조회
	 *
	 * @param KrWhfPortRtListCondVO krWhfPortRtListCondVO
	 * @return List<BkgKrWhfPortRtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgKrWhfPortRtVO> searchKrWhfPortRtList(KrWhfPortRtListCondVO krWhfPortRtListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgKrWhfPortRtVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfPortRtListCondVO != null)
			{
				Map<String, String> mapVO = krWhfPortRtListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfPortRtListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgKrWhfPortRtVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


	/**
	 * 항구별 Wharfage 요율 생성
	 *
	 * @param List<BkgKrWhfPortRtVO> bkgKrWhfPortRtVOs
	 * @throws DAOException
	 */
	public void addBkgKrWhfPortRt (List<BkgKrWhfPortRtVO> bkgKrWhfPortRtVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfPortRtVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOaddBkgKrWhfPortRtCSQL(),
						bkgKrWhfPortRtVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Wharfage 신고 대상 부두 정보 업데이트
	 *
	 * @param List<BkgKrWhfPortRtVO> bkgKrWhfPortRtVOs
	 * @throws DAOException
	 */
	public void modifyBkgKrWhfPortRt (List<BkgKrWhfPortRtVO> bkgKrWhfPortRtVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfPortRtVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOmodifyBkgKrWhfPortRtUSQL(),
						bkgKrWhfPortRtVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Port별 Wharfage 요율 삭제
	 *
	 * @param List<BkgKrWhfPortRtVO> bkgKrWhfPortRtVOs
	 * @throws DAOException
	 */
	public void removeBkgKrWhfPortRt (List<BkgKrWhfPortRtVO> bkgKrWhfPortRtVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfPortRtVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOremoveBkgKrWhfPortRtDSQL(),
						bkgKrWhfPortRtVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Wharfage 부과 charge 목록 조회 그리드1
	 *
	 * @param  KrWhfChgListCondVO krWhfChgListCondVO
	 * @return List<KrWhfChgVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfChgVO> searchKrWhfChgList(KrWhfChgListCondVO krWhfChgListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfChgVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfChgListCondVO != null)
			{
				Map<String, String> mapVO = krWhfChgListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfChgListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfChgVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(se.getMessage() + "<||>[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "] KrWharfageDecMgtDBDAOsearchKrWhfChgListRSQL");
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Wharfage 부과 charge 목록 조회 그리드2
	 *
	 * @param  KrWhfChgListCondVO krWhfChgListCondVO
	 * @return List<KrWhfChgVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfChgGenVO> searchKrWhfChgListGenSum (KrWhfChgListCondVO krWhfChgListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfChgGenVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfChgListCondVO != null)
			{
				Map<String, String> mapVO = krWhfChgListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfChgListGenSumRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfChgGenVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


	/**
	 * Wharfage 부과 charge 목록 조회 그리드3
	 *
	 * @param KrWhfChgListCondVO krWhfChgListCondVO
	 * @return BkgKrWhfCfmVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgKrWhfCfmVO searchKrWhfCfmInfo(KrWhfChgListCondVO krWhfChgListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgKrWhfCfmVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfChgListCondVO != null)
			{
				Map<String, String> mapVO = krWhfChgListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfCfmInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfCfmVO.class);

			if(list.size() > 0)
				return list.get(0);
			else
				return null;

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Wharfage 부과 charge 목록 조회 그리드3
	 *
	 * @param  KrWhfChgListCondVO krWhfChgListCondVO
	 * @return List<KrWhfChgVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfChgExpSumVO> searchKrWhfChgListExpSum (KrWhfChgListCondVO krWhfChgListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfChgExpSumVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfChgListCondVO != null)
			{
				Map<String, String> mapVO = krWhfChgListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfChgListExpSumRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfChgExpSumVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}



	/**
	 * Wharfage 선박 정보 (ETD, MRN) 조회
	 *
	 * @param KrWhfVslInfoCondVO krWhfVslInfoCondVO
	 * @return KrWhfVslInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KrWhfVslInfoVO searchKrWhfVslEtdMrn(KrWhfVslInfoCondVO krWhfVslInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfVslInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfVslInfoCondVO != null)
			{
				Map<String, String> mapVO = krWhfVslInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfVslEtdMrnRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfVslInfoVO.class);

			if(list.size() > 0)
				return list.get(0);
			else
				return null;

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
	 * Wharfage 신고 대상 선박 정보 조회
	 *
	 * @param KrWhfVslInfoCondVO krWhfVslInfoCondVO
	 * @return KrWhfVslInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KrWhfVslInfoVO searchKrWhfVslInfo(KrWhfVslInfoCondVO krWhfVslInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfVslInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfVslInfoCondVO != null)
			{
				Map<String, String> mapVO = krWhfVslInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfVslInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfVslInfoVO.class);

			if(list.size() > 0)
				return list.get(0);
			else
				return null;

		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Wharfage 신고 대상 선박 정보 조회 <br>
	 *
	 * - Whrafage 테이블에서 선박 정보를 못 가져 오는 경우 <br>
	 *   한국 세관 테이블에서 선박 정보를 가져와 Wharfage 신고 대상 선박 정보로 갈음한다. <br>
	 *
	 * @param KrWhfVslInfoCondVO krWhfVslInfoCondVO
	 * @return KrWhfVslInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KrWhfVslInfoVO searchKrWhfDfltVslInfo(KrWhfVslInfoCondVO krWhfVslInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfVslInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfVslInfoCondVO != null)
			{
				Map<String, String> mapVO = krWhfVslInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfDfltVslInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfVslInfoVO.class);

			if(list.size() > 0)
				return list.get(0);
			else
				return null;

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
	 * 항구별 부두 목록 조회
	 *
	 * @param KrWhfVslInfoCondVO krWhfVslInfoCondVO
	 * @return KrWhfVslInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfVslInfoVO> searchKrWhfWharfList(KrWhfVslInfoCondVO krWhfVslInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfVslInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfVslInfoCondVO != null)
			{
				Map<String, String> mapVO = krWhfVslInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfWharfListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfVslInfoVO.class);

			if(list.size() > 0)
				return list;
			else
				return null;

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
	 * 한국 WHF 신고 번호, VVD가 존재하는 여부 확인
	 *
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return Boolean
	 */
	public Boolean checkIfVvdExist(String vslCd, String skdVoyNo, String skdDirCd) throws DAOException{
		Boolean boolean1 = false;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String> ();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("skd_voy_no", skdVoyNo);
			mapVO.put("skd_dir_cd", skdDirCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOcheckIfVvdExistRSQL(), param, velParam);

			if(dbRowset.next()){
				String sSsrNo = dbRowset.getString(1);
				if(sSsrNo.length() != 0)
					boolean1 = true;
			}

			return boolean1;
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * VVD 별 Wharfage Summary 정보 생성
	 *
	 * @param List<BkgKrWhfVolVO> bkgKrWhfVolVOs
	 * @throws DAOException
	 */
	public void addBkgKrWhfVol (List<BkgKrWhfVolVO> bkgKrWhfVolVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfVolVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOmergeBkgKrWhfVolCSQL(),
						bkgKrWhfVolVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * Port Rate 존재 유무를 체크한다.
	 *
	 * @param List<BkgKrWhfPortRtVO> bkgKrWhfPortRtVOs
	 * @return List<BkgKrWhfPortRtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgKrWhfPortRtVO> checkIfPortRate(List<BkgKrWhfPortRtVO> bkgKrWhfPortRtVOs) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgKrWhfPortRtVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if(bkgKrWhfPortRtVOs != null){
				for (Iterator iterator = bkgKrWhfPortRtVOs.iterator(); iterator.hasNext();) {
					BkgKrWhfPortRtVO bkgKrWhfPortRtVO = (BkgKrWhfPortRtVO) iterator.next();

					Map<String, String> mapVO = bkgKrWhfPortRtVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOcheckIfPortRateRSQL(), param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgKrWhfPortRtVO.class);

					if(list.size() > 0){
						return list;
					}
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return null;
	}


	/**
	 * 한국 WHF 신고 대상 BL 목록 조회
	 *
	 * @param  KrWhfBlListCondVO krWhfBlListCondVO
	 * @return List<KrWhfBlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfBlVO> searchKrWhfBlList(KrWhfBlListCondVO krWhfBlListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfBlVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfBlListCondVO != null)
			{
				Map<String, String> mapVO = krWhfBlListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfBlListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfBlVO.class);

			if(list.size() > 0)
				return list;
			else
				return null;

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * Wharfage 신고를 위한 Location 변환 정보 조회
	 *
	 * @param  KrWhfLocCdListCondVO krWhfLocCdListCondVO
	 * @return List<BkgCstmsLocVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsLocVO> searchKrWhfLocCdList(KrWhfLocCdListCondVO krWhfLocCdListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCstmsLocVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfLocCdListCondVO != null)
			{
				Map<String, String> mapVO = krWhfLocCdListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfLocCdListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsLocVO.class);

			if(list.size() > 0)
				return list;
			else
				return null;

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * Wharfage Location Code 생성
	 *
	 * @param  List<KrBkgCstmsLocVO> krBkgCstmsLocVOs
	 * @throws DAOException
	 */
	public void addBkgCstmsLoc (List<KrBkgCstmsLocVO> krBkgCstmsLocVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (krBkgCstmsLocVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOaddBkgCstmsLocCSQL(),
						krBkgCstmsLocVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Wharfage Location Code 변경
	 *
	 * @param  List<KrBkgCstmsLocVO> krBkgCstmsLocVOs
	 * @throws DAOException
	 */
	public void modifyBkgCstmsLoc (List<KrBkgCstmsLocVO> krBkgCstmsLocVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (krBkgCstmsLocVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOmodifyBkgCstmsLocUSQL(),
						krBkgCstmsLocVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Wharfage Location Code 삭제
	 *
	 * @param  List<KrBkgCstmsLocVO> krBkgCstmsLocVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteBkgCstmsLoc (List<KrBkgCstmsLocVO> krBkgCstmsLocVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (krBkgCstmsLocVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOdeleteBkgCstmsLocDSQL(),
						krBkgCstmsLocVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * Wharfage 신고 확정 정보 생성 전 이미 생성되어있는지 체크
	 *
	 * @param  BkgKrWhfCfmVO bkgKrWhfCfmVO
	 * @return Boolean
	 * @throws DAOException
	 */
	public Boolean checkWhfConfirm(BkgKrWhfCfmVO bkgKrWhfCfmVO) throws DAOException{
		Boolean boolean1 = false;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgKrWhfCfmVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOcheckWhfConfirmRSQL(), param, velParam);

			if(dbRowset.next()){
				String sCnt = dbRowset.getString(1);
				if(Integer.parseInt(sCnt) == 0)
					boolean1 = true;
			}

			return boolean1;
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Wharfage 신고 확정 정보 생성
	 *
	 * @param  BkgKrWhfCfmVO bkgKrWhfCfmVO
	 * @throws DAOException
	 */
	public void addBkgKrWhfCfm(BkgKrWhfCfmVO bkgKrWhfCfmVO) throws DAOException{

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgKrWhfCfmVO.getColumnValues();
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new KrWharfageDecMgtDBDAOaddBkgKrWhfCfmCSQL(), param, velParam);

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}



	/**
	 * Wharfage B/L을 추가하기 위해 B/L 정보 조회
	 *
	 * @param  KrBlCondVO krBlCondVO
	 * @return KrBlVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KrBlVO searchKrBl(KrBlCondVO krBlCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrBlVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krBlCondVO != null)
			{
				Map<String, String> mapVO = krBlCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrBlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrBlVO.class);

			if(list.size() > 0)
				return list.get(0);
			else
				return null;

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Wharfage B/L을 추가하기 위해 B/L 정보 조회 그리드 1
	 *
	 * @param  KrBlCondVO krBlCondVO
	 * @return List<KrCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrCntrVO> searchKrCntr(KrBlCondVO krBlCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrCntrVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krBlCondVO != null)
			{
				Map<String, String> mapVO = krBlCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrCntrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrCntrVO.class);

			if(list.size() > 0)
				return list;
			else
				return null;

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Wharfage B/L을 추가하기 위해 B/L 정보 조회 그리드 2
	 *
	 * @param  KrBlCondVO krBlCondVO
	 * @return List<KrCustVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrCustVO> searchKrCust(KrBlCondVO krBlCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrCustVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krBlCondVO != null)
			{
				Map<String, String> mapVO = krBlCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrCustRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrCustVO.class);

			if(list.size() > 0)
				return list;
			else
				return null;

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * WHF charge code가 포함된 목록 조회
	 *
	 * @param  KrWhfRateListCondVO krWhfRateListCondVO
	 * @return List<KrWhfRateVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfRateVO> searchKrWhfRateList(KrWhfRateListCondVO krWhfRateListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfRateVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfRateListCondVO != null)
			{
				Map<String, String> mapVO = krWhfRateListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfRateListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfRateVO.class);

			//if(list.size() > 0)
				return list;
			//else
			//	return null;

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 한국 세관에 신고 된 B/L 중 WHF 신고 누락 분이 있는지 조회
	 *
	 * @param  KrWhfBlChkListCondVO krWhfBlChkListCondVO
	 * @return List<WhfBlChkVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<WhfBlChkVO> searchKrWhfBlChkList(KrWhfBlChkListCondVO krWhfBlChkListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<WhfBlChkVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfBlChkListCondVO != null)
			{
				Map<String, String> mapVO = krWhfBlChkListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfBlChkListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfBlChkVO.class);

			//if(list.size() > 0)
			return list;
			//else
			//	return null;

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}



	/**
	 * WHF 저장하기 위해 필요한 추가 정보를 BKG_BOOKING으로 부터 가져 옴
	 *
	 * @param  KrWhfBkgInfoCondVO krWhfBkgInfoCondVO
	 * @return KrWhfBkgInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KrWhfBkgInfoVO searchBkgInfo(KrWhfBkgInfoCondVO krWhfBkgInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfBkgInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfBkgInfoCondVO != null)
			{
				Map<String, String> mapVO = krWhfBkgInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchBkgInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfBkgInfoVO.class);

			if(list.size() > 0)
				return list.get(0);
			else
				return null;

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 한국 WHF 신고 대상 BL별 마스터 정보 생성
	 *
	 * @param  List<KrWhfBkgKrWhfBlVO> krWhfBkgKrWhfBlVOs
	 * @throws DAOException
	 */
	public void mergeBkgKrWhfBl (List<KrWhfBkgKrWhfBlVO> krWhfBkgKrWhfBlVOs) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (krWhfBkgKrWhfBlVOs.size() > 0)
			{
				Map<String, String> mapVO = krWhfBkgKrWhfBlVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				param.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOmergeBkgKrWhfBlCSQL(),
						krWhfBkgKrWhfBlVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * 한국 WHF 신고 대상 BL별 CUST 정보 삭제
	 *
	 * @param  List<BkgKrWhfCustVO> BkgKrWhfCustVOs
	 * @throws DAOException
	 */
	public void removeBkgKrWhfCust (List<BkgKrWhfCustVO> BkgKrWhfCustVOs) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (BkgKrWhfCustVOs.size() > 0)
			{
				Map<String, String> mapVO = BkgKrWhfCustVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				param.putAll(mapVO);

				new SQLExecuter("").executeUpdate(
						(ISQLTemplate) new KrWharfageDecMgtDBDAOremoveBkgKrWhfCustDSQL(), param, velParam);
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 한국 WHF 신고 대상 BL별 CUST 정보 생성
	 *
	 * @param  List<BkgKrWhfCustVO> bkgKrWhfCustVOs
	 * @throws DAOException
	 */
	public void addBkgKrWhfCust (List<BkgKrWhfCustVO> bkgKrWhfCustVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfCustVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOaddBkgKrWhfCustCSQL(),
						bkgKrWhfCustVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * 한국 WHF 신고 대상 BL별 CNTR 정보 삭제
	 *
	 * @param  List<BkgKrWhfCntrVO> bkgKrWhfCntrVOs
	 * @throws DAOException
	 */
	public void removeBkgKrWhfCntr (List<BkgKrWhfCntrVO> bkgKrWhfCntrVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfCntrVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOremoveBkgKrWhfCntrDSQL(),
						bkgKrWhfCntrVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 한국 WHF 신고 대상 BL별 CNTR 정보 생성
	 *
	 * @param  List<BkgKrWhfCntrVO> bkgKrWhfCntrVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBkgKrWhfCntr (List<BkgKrWhfCntrVO> bkgKrWhfCntrVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfCntrVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOaddBkgKrWhfCntrCSQL(),
						bkgKrWhfCntrVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 한국 WHF 신고 대상 BL별 CUST 정보 생성
	 *
	 * @param  List<BkgKrWhfCustVO> bkgKrWhfCustVOs
	 * @throws DAOException
	 */
	public void addSearchBkgKrWhfCust (List<BkgKrWhfCustVO> bkgKrWhfCustVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfCustVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOaddSearchBkgKrWhfCustCSQL(),
						bkgKrWhfCustVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * 한국 WHF 신고 대상 BL별 CNTR 정보 생성
	 *
	 * @param  List<BkgKrWhfCntrVO> bkgKrWhfCntrVOs
	 * @throws DAOException
	 */
	public void addSearchBkgKrWhfCntr (List<BkgKrWhfCntrVO> bkgKrWhfCntrVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfCntrVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOaddSearchBkgKrWhfCntrCSQL(),
						bkgKrWhfCntrVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * 한국 WHF 신고 대상 BL별 마스터 정보 생성 (한국 세관 정보 및 BOOKING 정보 이용)
	 *
	 * @param  List<KrWhfBkgKrWhfBlVO> krWhfBkgKrWhfBlVOs
	 * @throws DAOException
	 */
	public void mergeSearchBkgKrWhfBl (List<KrWhfBkgKrWhfBlVO> krWhfBkgKrWhfBlVOs) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (krWhfBkgKrWhfBlVOs.size() > 0)
			{
				Map<String, String> mapVO = krWhfBkgKrWhfBlVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				param.putAll(mapVO);

				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOmergeSearchBkgKrWhfBlCSQL(),
						krWhfBkgKrWhfBlVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * WHF 신고 현황 조회
	 *
	 * @param  KrWhfDecChkListCondVO krWhfDecChkListCondVO
	 * @return List<WhfDecChkVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<WhfDecChkVO> searchKrWhfDecChkList(KrWhfDecChkListCondVO krWhfDecChkListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<WhfDecChkVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecChkListCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecChkListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfDecChkListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfDecChkVO.class);

			return list;

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 화물입항료 대납경비 청구서 조회
	 *
	 * @param  KrWhfCommInvListCondVO krWhfCommInvListCondVO
	 * @return List<WhfCommInvListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<WhfCommInvListVO> searchKrWhfCommInvList(KrWhfCommInvListCondVO krWhfCommInvListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<WhfCommInvListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfCommInvListCondVO != null)
			{
				Map<String, String> mapVO = krWhfCommInvListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfCommInvListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfCommInvVO.class);

			return list;

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
	 * VVD, Port, Bound별 적용할 실제 Wharfage Container 및 Bulk 단가를 가져 온다.
	 *
	 * @param  List<BkgKrWhfVolVO> bkgKrWhfVolVOs
	 * @throws DAOException
	 */
	public void modifyBkgKrWhfVol (List<BkgKrWhfVolVO> bkgKrWhfVolVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfVolVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOmodifyBkgKrWhfVolUSQL(),
						bkgKrWhfVolVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * Wharfage 선박 정보 (ETD, MRN) 조회
	 *
	 * @param  KrWhfVslInfoCondVO krWhfVslInfoCondVO
	 * @return List<WhfVslInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<WhfVslInfoVO> searchKrWhfMrnSailDt(KrWhfVslInfoCondVO krWhfVslInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<WhfVslInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfVslInfoCondVO != null)
			{
				Map<String, String> mapVO = krWhfVslInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfMrnSailDtRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfVslInfoVO.class);

			return list;

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
	 * 한국 WHF 신고 대상 BL 목록 및 구분 정보 (면제 화주 등) 조회
	 *
	 * @param  KrWhfCgoClassCondVO krWhfCgoClassCondVO
	 * @return List<KrWhfBlInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfBlInfoVO> searchKrWhfCgoClass(KrWhfCgoClassCondVO krWhfCgoClassCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfBlInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfCgoClassCondVO != null)
			{
				Map<String, String> mapVO = krWhfCgoClassCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfCgoClassRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfBlInfoVO.class);

			return list;

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
	 * Port별 Wharfage  요율 목록 조회
	 *
	 * @param  KrWhfPortRtListCondVO krWhfPortRtListCondVO
	 * @return List<KrWhfAplyPortRtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfAplyPortRtVO> searchKrWhfAplyPortRt(KrWhfPortRtListCondVO krWhfPortRtListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfAplyPortRtVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfPortRtListCondVO != null)
			{
				Map<String, String> mapVO = krWhfPortRtListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfAplyPortRtRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfAplyPortRtVO.class);

			return list;

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
	 * B/L별 Wharfage 면제 정보 (면제 사유 등) 조회
	 *
	 * @param  KrWhfExemptInfoCondVO krWhfExemptInfoCondVO
	 * @return KrWhfBlExpInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KrWhfBlExpInfoVO searchKrWhfBlInfo(KrWhfExemptInfoCondVO krWhfExemptInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfBlExpInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfExemptInfoCondVO != null)
			{
				Map<String, String> mapVO = krWhfExemptInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfBlExpInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfBlExpInfoVO.class);

			if(list.size() > 0)
				return list.get(0);
			else
				return null;

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * B/L, CNTR별 Wharfage 면제 정보
	 *
	 * @param  KrWhfExemptInfoCondVO krWhfExemptInfoCondVO
	 * @return List<KrWhfCntrExpInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfCntrExpInfoVO> searchKrWhfCntrExpInfo(KrWhfExemptInfoCondVO krWhfExemptInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfCntrExpInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfExemptInfoCondVO != null)
			{
				Map<String, String> mapVO = krWhfExemptInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfCntrExpInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfCntrExpInfoVO.class);

			return list;

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
	 * Wharfage VVD, Port별 ETD, ETA 조회
	 *
	 * @param  String vvd
	 * @param  String portCd
	 * @return VvdPortEtdEtaVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public VvdPortEtdEtaVO searchVvdPortEtdEta(String vvd, String portCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdPortEtdEtaVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (vvd.length() > 0 && portCd.length() > 0)
			{
				 param.put   ("vvd", vvd);
				 param.put   ("port_cd",  portCd);

				 velParam.put   ("vvd", vvd);
				 velParam.put   ("port_cd",  portCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOSearchVvdPortEtdEtaRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VvdPortEtdEtaVO.class);

			if(list.size() > 0)
				return list.get(0);
			else
				return null;

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * B/L별 Wharfage 면제 정보 (면제 사유 등) 조회
	 *
	 * @param  KrWhfExemptInfoCondVO krWhfExemptInfoCondVO
	 * @return List<KrWhfBlExptInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfBlExptInfoVO> searchKrWhfBlExptInfo(KrWhfExemptInfoCondVO krWhfExemptInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfBlExptInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfExemptInfoCondVO != null)
			{
				Map<String, String> mapVO = krWhfExemptInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfBlExptInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfBlExptInfoVO.class);

			if(list.size() > 0)
				return list;
			else
				return null;

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * B/L별 Wharfage 정보 조회
	 *
	 * @param whfExemptInfoCondVO
	 * @return
	 */
//	public KrWhfBlExpInfoVO searchKrWhfBlInfo(KrWhfExemptInfoCondVO whfExemptInfoCondVO) {
//		return null;
//	}


	/**
	 * 한국 WHF 신고 번호, Dec No (Declaration No)가 존재하는 지 여부 확인 (True, False)
	 *
	 * @param  KrWhfVslInfoCondVO krWhfVslInfoCondVO
	 * @return Boolean
	 * @throws DAOException
	 */
	public Boolean checkIfDecNoExist(KrWhfVslInfoCondVO krWhfVslInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfVslInfoCondVO != null)
			{
				Map<String, String> mapVO = krWhfVslInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOcheckIfDecNoExistRSQL(), param, velParam);

			if(dbRowset.next())
			{
				String sCnt = dbRowset.getString("cnt");
				if("0".equals(sCnt))
					return false;
			}

			return true;

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
	 * VVD, Port, Bound, B/L No별 마지막 Wharfage Rate 정보를 가져 옴
	 *
	 * @param  KrWhfVslInfoCondVO krWhfVslInfoCondVO
	 * @return KrWhfVslInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KrWhfVslInfoVO searchLastKrWhfRtInfo(KrWhfVslInfoCondVO krWhfVslInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<WhfVslInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfVslInfoCondVO != null)
			{
				Map<String, String> mapVO = krWhfVslInfoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchLastKrWhfRtInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfVslInfoVO.class);

			KrWhfVslInfoVO  krWhfVslInfoVO = null;
			if(list.size() > 0){
				krWhfVslInfoVO = (KrWhfVslInfoVO)list.get(0) ;
				return krWhfVslInfoVO;
			}
			return krWhfVslInfoVO;
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
	 * 한국 WHF 신고 대상 BL별 마스터 정보 정정
	 *
	 * @param  List<BkgKrWhfBlVO> bkgKrWhfBlVOs
	 * @throws DAOException
	 */
	public void modifyBkgKrWhfBl (List<BkgKrWhfBlVO> bkgKrWhfBlVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfBlVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOmodifyBkgKrWhfBlUSQL(),
						bkgKrWhfBlVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * VVD, PORT 별로 입항일 및 출항일을 가져 옴
	 *
	 * @param  String portCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchPortOfc(String portCd) throws DAOException {
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (portCd != null)
			{
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("port_cd", portCd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchPortOfcRSQL(), param, velParam);

			if (dbRowset.next()) {
				return dbRowset.getString(1);
			}

			return "";
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
	 * 한국 WHF 신고 대상 BL별 Rate 상세 정보 정정
	 *
	 * @param  List<BkgKrWhfRtVO> bkgKrWhfRtVOs
	 * @throws DAOException
	 */
	public void modifyBkgKrWhfRt (List<BkgKrWhfRtVO> bkgKrWhfRtVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfRtVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOmodifyBkgKrWhfRtUSQL(),
						bkgKrWhfRtVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 한국 WHF 신고 대상 BL별 CNTR FULL/EMPTY 정보 정정
	 *
	 * @param  List<BkgKrWhfRtVO> bkgKrWhfRtVOs
	 * @throws DAOException
	 */
	public void modifyBkgKrWhfCntr (List<BkgKrWhfRtVO> bkgKrWhfRtVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfRtVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOmodifyBkgKrWhfCntrUSQL(),
						bkgKrWhfRtVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 한국 WHF 신고 대상 BL별 Rate 상세 정보 정정
	 *
	 * @param  List<BkgKrWhfRtVO> bkgKrWhfRtVOs
	 * @throws DAOException
	 */
	public void modifyBkgKrWhfRt2 (List<BkgKrWhfRtVO> bkgKrWhfRtVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfRtVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOmodifyBkgKrWhfRt2USQL(),
						bkgKrWhfRtVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 한국 WHF 신고 대상 BL별 RATE 상세 정보 생성
	 *
	 * @param  List<BkgKrWhfRtVO> bkgKrWhfRtVOs
	 * @throws DAOException
	 */
	public void addBkgKrWhfRt (List<BkgKrWhfRtVO> bkgKrWhfRtVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfRtVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOaddBkgKrWhfRtCSQL(),
						bkgKrWhfRtVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 저장된 한국 WHF VVD별 상세 내역 조회
	 *
	 * @param  KrWhfDecCondVO krWhfDecCondVO
	 * @return List<KrWhfVvdDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfVvdDtlVO> searchKrWhfVvdDtlSavedList(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfVvdDtlVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfVvdDtlSavedListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfVvdDtlVO.class);

			return list;

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
	 * 기존에 저장된 값이 없는 경우, 한국 WHF VVD별 상세 내역 초기값 조회
	 *
	 * @param  KrWhfDecCondVO krWhfDecCondVO
	 * @return List<KrWhfVvdDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfVvdDtlVO> searchKrWhfVvdDtlInitialList(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfVvdDtlVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfVvdDtlInitialListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfVvdDtlVO.class);

			return list;

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
	 * BoundCd가 OO, II, IN인 경우 B/L별 WHF 합계를 구함
	 *
	 * @param  KrWhfDecCondVO krWhfDecCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchKrWhfTtlAmt(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sAmount = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfTtlAmtRSQL(), param, velParam);
			if(dbRowset.next())
			{
				sAmount = dbRowset.getString("whf_rt_amt");
			}

			return sAmount;
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
	 * 한국 WHF 신고 정보 조회 (허가일, 신고일, 담당자, 신고금액, 절사 금액 등)
	 *
	 * @param  KrWhfDecCondVO krWhfDecCondVO
	 * @return BkgKrWhfVolVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgKrWhfVolVO searchKrWhfVol(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgKrWhfVolVO> list = null;
		BkgKrWhfVolVO  bkgKrWhfVolVO = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfVolRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgKrWhfVolVO.class);

			if(list.size() > 0){
				bkgKrWhfVolVO = (BkgKrWhfVolVO)list.get(0) ;
			}
			return bkgKrWhfVolVO;
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
	 * Wharfage 신고 번호 조회
	 *
	 * @param  KrWhfDecCondVO krWhfDecCondVO
	 * @return KrWhfDecVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KrWhfDecVO searchKrWhfDec(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfDecVO> list = null;
		KrWhfDecVO krWhfDecVO = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfDecRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfDecVO.class);

			if(list.size() > 0){
				krWhfDecVO = (KrWhfDecVO)list.get(0) ;
			}
			return krWhfDecVO;
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
	 * 년도 4자리를 가져옴 (한국 시간)
	 *
	 * @param  KrWhfDecCondVO krWhfDecCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchYearAsYyyy(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sDeclNoYr = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchYearAsYyyyRSQL(), param, velParam);
			if(dbRowset.next())
			{
				sDeclNoYr = dbRowset.getString("whf_decl_no_yr");
			}
			return sDeclNoYr;
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
	 * 한국 WHF 신고를 위한 면제 사유 별 집계 조회
	 *
	 * @param  KrWhfDecCondVO krWhfDecCondVO
	 * @return List<KrWhfDecExptVolVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfDecExptVolVO> searchKrWhfDecExptVolList(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfDecExptVolVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfDecExptVolListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfDecExptVolVO.class);

			return list;

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
	 * 한국 WHF 신고를 위한 MT 면제 사유 대상 화물 집계
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @param String sizeId
	 * @return String
	 * @throws DAOException
	 */
	public String searchKrWhfDecExptMtCntrVol(KrWhfDecCondVO krWhfDecCondVO, String sizeId) throws DAOException {
		DBRowSet dbRowset = null;
		String sMtQty = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				mapVO.put("size_id", sizeId);
				mapVO.put("mrn", ""); // mrn 에 대한 값을 정확히 어디서 가져오는지 수정해야함.
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfDecExptMtCntrVolRSQL(), param, velParam);
			if(dbRowset.next())
			{
				sMtQty = dbRowset.getString("mt_qty");
			}
			return sMtQty;
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
	 * 한국 WHF 신고를 위한 BULK 면제 사유 대상 화물 집계
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @param String sizeId
	 * @return String
	 * @throws DAOException
	 */
	public String searchKrWhfDecExptBlkVol(KrWhfDecCondVO krWhfDecCondVO, String sizeId) throws DAOException {
		DBRowSet dbRowset = null;
		String sBlkQty = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				mapVO.put("size_id", sizeId);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfDecExptBlkVolRSQL(), param, velParam);
			if(dbRowset.next())
			{
				sBlkQty = dbRowset.getString("blk_qty");
			}
			return sBlkQty;
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
	 * 한국 WHF를 적용할 CNTR WHF 단가 조회
	 *
	 * @param String sPortCd
	 * @param String sWhfBndCd
	 * @param String sWhfVolDcCD
	 * @return KrWhfPortRtVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KrWhfPortRtVO searchKrWhfCntrPortRt(String sPortCd, String sWhfBndCd, String sWhfVolDcCD) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfPortRtVO> list = null;
		KrWhfPortRtVO krWhfPortRtVO = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("port_cd", sPortCd);
			mapVO.put("whf_bnd_cd", sWhfBndCd);
			mapVO.put("whf_vol_dc_cd", sWhfVolDcCD);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfCntrPortRtRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfPortRtVO.class);

			if(list.size() > 0){
				krWhfPortRtVO = (KrWhfPortRtVO)list.get(0) ;
			}
			return krWhfPortRtVO;
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
	 * 한국 WHF를 적용할 BULK WHF 단가 조회
	 *
	 * @param String sPortCd
	 * @param String sWhfBndCd
	 * @param String sWhfVolDcCD
	 * @return KrWhfPortRtVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KrWhfPortRtVO searchKrWhfBlkPortRt(String sPortCd, String sWhfBndCd, String sWhfVolDcCD) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfPortRtVO> list = null;
		KrWhfPortRtVO krWhfPortRtVO = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("port_cd", sPortCd);
			mapVO.put("whf_bnd_cd", sWhfBndCd);
			mapVO.put("whf_vol_dc_cd", sWhfVolDcCD);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfBlkPortRtRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfPortRtVO.class);

			if(list.size() > 0){
				krWhfPortRtVO = (KrWhfPortRtVO)list.get(0) ;
			}
			return krWhfPortRtVO;
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
	 * VVD, Port, Bound 별 한국 WHF B/L 존재 여부 확인
	 *
	 * @param KrWhfBlListCondVO krWhfBlListCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchKrWhfBlExistFlg(KrWhfBlListCondVO krWhfBlListCondVO) throws DAOException {
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfBlListCondVO != null)
			{
				Map<String, String> mapVO = krWhfBlListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOSearchKrWhfBlExistFlgRSQL(), param, velParam);

			if(dbRowset.next()){
				return dbRowset.getString("KR_WHF_EXIST_FLG");
			}
			return "N";
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Wharfage DEC 넘버의 갯수를 가져온다.
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchKrWhfDecKnt(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sBlkQty = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfDecKntRSQL(), param, velParam);
			if(dbRowset.next())
			{
				sBlkQty = dbRowset.getString("blk_qty");
			}
			return Integer.parseInt(sBlkQty);
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
	 * 고객 갯수를 가져온다.
	 *
	 * @param  KrWhfDecCondVO krWhfDecCondVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchKrWhfNoExptCustRgstNoDistinctKnt(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sBlkQty = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfNoExptCustRgstNoDistinctKntRSQL(), param, velParam);
			if(dbRowset.next())
			{
				sBlkQty = dbRowset.getString("DISTINCT_KNT");
			}
			return Integer.parseInt(sBlkQty);
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
	 * BkgKrWhfVol 에 저장하는 메서드
	 *
	 * @param BkgKrWhfVolVO bkgKrWhfVolVO
	 * @throws DAOException
	 */
	public void modifyBkgKrWhfVolWhfDecSave (BkgKrWhfVolVO bkgKrWhfVolVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgKrWhfVolVO.getColumnValues();
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new KrWharfageDecMgtDBDAOmodifyBkgKrWhfVolWhfDecSaveUSQL(), param, velParam);

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * vvd 를 삭제한다.
	 *
	 * @param List<BkgKrWhfVvdDtlVO> bkgKrWhfVvdDtlVOs
	 * @throws DAOException
	 */
	public void removeBkgKrWhfVvdDtlWhfDec (List<BkgKrWhfVvdDtlVO> bkgKrWhfVvdDtlVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfVvdDtlVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOremoveBkgKrWhfVvdDtlWhfDecDSQL(),
						bkgKrWhfVvdDtlVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * VVD별 Wharfage 상세 정보 생성
	 *
	 * @param List<BkgKrWhfVvdDtlVO> bkgKrWhfVvdDtlVOs
	 * @throws DAOException
	 */
	public void addBkgKrWhfVvdDtlWhfDec (List<BkgKrWhfVvdDtlVO> bkgKrWhfVvdDtlVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgKrWhfVvdDtlVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOaddBkgKrWhfVvdDtlWhfDecCSQL(),
						bkgKrWhfVvdDtlVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 한국 WHF 신고 대상 BL별 Rate 상세 정보 정정
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @param String sWhfNtcNo
	 * @throws DAOException
	 */
	public void modifyBkgKrWhfRtWhfDec (KrWhfDecCondVO krWhfDecCondVO, String sWhfNtcNo) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
			mapVO.put("whf_ntc_no", sWhfNtcNo);
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new KrWharfageDecMgtDBDAOmodifyBkgKrWhfRtWhfDecUSQL(), param, velParam);

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * DEC 넘버를 가지고 있는 EDI 전송 VVD 가져온다.
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @return KrWhfDecEdiVvdVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KrWhfDecEdiVvdVO searchKrWhfDecEdiVvd(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfDecEdiVvdVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfDecEdiVvdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfDecEdiVvdVO.class);

			if(list.size() > 0)
				return list.get(0);
			else
				return null;

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * 설계 미완성
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @return KrWhfDecEdiVvdVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KrWhfDecEdiVvdVO searchKrWhfDecEdiQty(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfDecEdiVvdVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfDecEdiQtyRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfDecEdiVvdVO.class);

			if(list.size() > 0)
				return list.get(0);
			else
				return null;

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * WHF Detail 정보 조회
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @return List<KrWhfDecEdiRtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfDecEdiRtVO> searchKrWhfDecEdiRtList(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfDecEdiRtVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfDecEdiRtListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfDecEdiRtVO.class);

			return list;

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
	 * Wharfage 정보 수정.
	 *
	 * @param BkgKrWhfVolVO bkgKrWhfVolVO
	 * @throws DAOException
	 */
	public void modifyBkgKrWhfVolWhfDecSend (BkgKrWhfVolVO bkgKrWhfVolVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgKrWhfVolVO.getColumnValues();
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new KrWharfageDecMgtDBDAOmodifyBkgKrWhfVolWhfDecSendUSQL(), param, velParam);

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * WHF SUMMARY 테이블에서 WHF 금액 합과 WHF 신고 담당자를 구함
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchKrWhfSumAmtFmSmry(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sWhfAmtFmSmry = "0";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfSumAmtFmSmryRSQL(), param, velParam);
			if(dbRowset.next())
			{
				sWhfAmtFmSmry = dbRowset.getString("Whf_Amt_Fm_Smry");
			}

			return sWhfAmtFmSmry;
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
	 * 총 갯수를 가져오는 메서드.
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchKrWhfSumAmtFmDtl(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sWhfAmtFmDtl = "0";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfSumAmtFmDtlRSQL(), param, velParam);
			if(dbRowset.next())
			{
				sWhfAmtFmDtl = dbRowset.getString("Whf_Amt_Fm_Dtl");
			}

			return sWhfAmtFmDtl;
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
	 * 해당 VVD에 이미 Decl No가 존재하는지 확인
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchKrWhfDecDeclNoWithVvdExistFlg(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sWhfDeclNoExistFlg = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfDecDeclNoWithVvdExistFlgRSQL(), param, velParam);
			if(dbRowset.next())
			{
				sWhfDeclNoExistFlg = dbRowset.getString("Whf_Decl_No_Exist_Flg");
			}

			return sWhfDeclNoExistFlg;
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
	 * (신규 생성된) WHF Declaration No가 다른 VVD로 존재하는 지 Flag를 가져 옴 Y=존재함, N=존재하지 않음
	 *
	 * @param String sVvd
	 * @param String sWhfDeclNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchKrWhfDecDeclNoWithDiffVvdExistFlg(String sVvd, String sWhfDeclNo) throws DAOException {
		DBRowSet dbRowset = null;
		String sWhfDeclNoExistFlg = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sVvd != null && sWhfDeclNo != null)
			{
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("vvd", sVvd);
				mapVO.put("whf_dec_no", sWhfDeclNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfDecDeclNoWithDiffVvdExistFlgRSQL(), param, velParam);
			if(dbRowset.next())
			{
				sWhfDeclNoExistFlg = dbRowset.getString("Whf_Decl_No_Exist_Flg");
			}

			return sWhfDeclNoExistFlg;
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
	 * WHF 신고를 위한 기본 정보 조회
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @return KrWhfDecCondVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KrWhfDecCondVO searchKrWhfDecBzcInfo(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfDecCondVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfDecBzcInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfDecCondVO.class);

			if(list.size() > 0)
				return list.get(0);
			else
				return null;

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
	 * AP_INV_HDR, AP_INV_DTRB에 담을 상수성 값 들을 조회 - 향후 유지 보수 편의성을 위해 한 SQL에 집중 시킴
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @return KrWhfDecBzcInfoForApIfVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KrWhfDecBzcInfoForApIfVO searchKrWhfDecBzcInfoForApIf(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfDecBzcInfoForApIfVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfDecBzcInfoForApIfRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfDecBzcInfoForApIfVO.class);

			if(list.size() > 0)
				return list.get(0);
			else
				return null;

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
	 * A/P WHF 금액 Interface시 넘길 Revenue VVD 구함
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchRevVvd(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {

		DBRowSet dbRowset = null;
		String sRevenueVvd = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchRevVvdRSQL(), param, velParam);
			if(dbRowset.next())
				sRevenueVvd = dbRowset.getString("revenue_vvd");

			return sRevenueVvd;
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
	 * A/P interface 하기 위한 header 정보를 추가한다
	 *
	 * @param List<ApInvHdrVO> apInvHdrVOs
	 * @throws DAOException
	 */
	public void addApInvHdrList (List<ApInvHdrVO> apInvHdrVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (apInvHdrVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOaddApInvHdrListCSQL(),
						apInvHdrVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * A/P interface 하기 위한 detail 정보를 추가한다
	 *
	 * @param  List<ApInvDtrbVO> apInvDtrbVOs
	 * @throws DAOException
	 */
	public void addApInvDtrbList (List<ApInvDtrbVO> apInvDtrbVOs) throws DAOException {

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (apInvDtrbVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new KrWharfageDecMgtDBDAOaddApInvDtrbListCSQL(),
						apInvDtrbVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * AP INV INTERFACE 테이블에 AP INV I/F 전송 이력을 남김
	 *
	 * @param String sCsrNo
	 * @param String sCreUseId
	 * @throws DAOException
	 */
	public void addApInvIfSearch(String sCsrNo, String sCreUseId) throws DAOException{

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("csr_no", sCsrNo);
			mapVO.put("cre_usr_id", sCreUseId);
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new KrWharfageDecMgtDBDAOaddApInvIfSearchCSQL(), param, velParam);

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * WHF DEC I/F 시 A/R Invoice I/F 할 대상을 B/L No Level로 조회 함
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @return List<KrWhfDecIfArInvVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfDecIfArInvVO> searchKrWhfDecIfArInv(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfDecIfArInvVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOsearchKrWhfDecIfArInvRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfDecIfArInvVO.class);

			return list;

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
	 * WHF DEC Send 시 부산입항분에 한하여 date check
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @return List<krWhfDecCheckSendDtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrWhfDecCheckSendDtVO> checkSendDate(KrWhfDecCondVO krWhfDecCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfDecCheckSendDtVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (krWhfDecCondVO != null)
			{
				Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KrWharfageDecMgtDBDAOcheckSendDateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, KrWhfDecCheckSendDtVO.class);

			return list;

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
	 * 허가 번호 (Notice No)를 변경함
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @throws DAOException
	 */
	public void modifyBkgKrWhfRtWhfCngNo(KrWhfDecCondVO krWhfDecCondVO) throws DAOException{

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new KrWharfageDecMgtDBDAOmodifyBkgKrWhfRtWhfCngNoUSQL(), param, velParam);

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * AR I/F 기록 저장
	 *
	 * @param BkgKrWhfRtVO bkgKrWhfRtVO
	 * @throws DAOException
	 */
	public void modifyBkgKrWhfRtIfArInv(BkgKrWhfRtVO bkgKrWhfRtVO) throws DAOException{

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgKrWhfRtVO.getColumnValues();
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new KrWharfageDecMgtDBDAOmodifyBkgKrWhfRtIfArInvUSQL(), param, velParam);

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * DEC I/F 기록 저장
	 *
	 * @param krWhfDecCondVO KrWhfDecCondVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyBkgKrWhfRtIfDecNo(KrWhfDecCondVO krWhfDecCondVO, SignOnUserAccount account) throws DAOException{

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
			mapVO.put("upd_usr_id", account.getUsr_id());
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new KrWharfageDecMgtDBDAOModifyBkgKrWhfRtIfDecNoUSQL(), param, velParam);

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CSR 기록 저장
	 *
	 * @param krWhfDecCondVO KrWhfDecCondVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyBkgKrWhfRtIfCsrNo(KrWhfDecCondVO krWhfDecCondVO, SignOnUserAccount account) throws DAOException{

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
			mapVO.put("upd_usr_id", account.getUsr_id());
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new KrWharfageDecMgtDBDAOModifyBkgKrWhfRtIfCsrNoUSQL(), param, velParam);

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * A/P I/F 기록 저장
	 *
	 * @param krWhfDecCondVO KrWhfDecCondVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyBkgKrWhfRtIfAp(KrWhfDecCondVO krWhfDecCondVO, SignOnUserAccount account) throws DAOException{

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = krWhfDecCondVO.getColumnValues();
			mapVO.put("upd_usr_id", account.getUsr_id());
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new KrWharfageDecMgtDBDAOmodifyBkgKrWhfRtIfApUSQL(), param, velParam);

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BkgKrWhfVol 에 CUSTOMER KIND(복수, 단수)만 저장하는 메서드
	 *
	 * @param BkgKrWhfVolVO bkgKrWhfVolVO
	 * @throws DAOException
	 */
	public void modifyBkgKrWhfVolWhfCustKndSave (BkgKrWhfVolVO bkgKrWhfVolVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgKrWhfVolVO.getColumnValues();
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new KrWharfageDecMgtDBDAOmodifyBkgKrWhfVolWhfCustKndSaveUSQL(), param, velParam);

		}
		catch (SQLException se)
		{

			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{

			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}