/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ArgCustomsTransmissionDBDAO.java
 *@FileTitle : ArgCustomsTransmissionDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.basic.ArgCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo.ArgElInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo.ArgManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo.ArgTransmitBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo.ArgTransmitCmListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo.BkgCstmsArgSndLogVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS ArgCustomsTransmissionDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Min Jeong
 * @see ArgCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
public class ArgCustomsTransmissionDBDAO extends DBDAOSupport {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * BKG_CSTMS_ARS_SND_LOG
	 * 
	 * @param bkgCstmsArgSndLogVOs
	 * @throws DAOException
	 */
	public void addBkgCstmsArgSndLog(List<BkgCstmsArgSndLogVO> bkgCstmsArgSndLogVOs) throws DAOException {
		try
		{
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsArgSndLogVOs != null && bkgCstmsArgSndLogVOs.size() > 0)
			{
				Map<String, String> mapVO = bkgCstmsArgSndLogVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ArgCustomsTransmissionDBDAOaddBkgCstmsArgSndLogCSQL(), bkgCstmsArgSndLogVOs, velParam);
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
	 * BL정보 조회
	 * 
	 * @param arsManifestTransmitVO
	 * @return ArgTransmitBlInfoVO
	 * @throws DAOException
	 */
	public ArgTransmitBlInfoVO searchTransmitBlInfo(ArgManifestTransmitVO arsManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		ArgTransmitBlInfoVO arsTransmitBlInfoVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.putAll(arsManifestTransmitVO.getColumnValues());
			velParam.putAll(arsManifestTransmitVO.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ArgCustomsTransmissionDBDAOsearchTransmitBlInfoRSQL(), param, velParam);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, ArgTransmitBlInfoVO.class);
			if (list.size() > 0)
				arsTransmitBlInfoVO = (ArgTransmitBlInfoVO)list.get(0);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return arsTransmitBlInfoVO;
	}
	
	/**
	 * CM정보 조회
	 * @param arsManifestTransmitVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ArgTransmitCmListVO> searchTransmitCmList(ArgManifestTransmitVO arsManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ArgTransmitCmListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.putAll(arsManifestTransmitVO.getColumnValues());
			velParam.putAll(arsManifestTransmitVO.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ArgCustomsTransmissionDBDAOsearchTransmitCmListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ArgTransmitCmListVO.class);
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
	 * View Send Log File 
	 * 
	 * @param bkgCstmsArgSndLogVO 조회조건
	 * @return List<BkgCstmsArgSndLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsArgSndLogVO searchCstmsArgSndLog(BkgCstmsArgSndLogVO bkgCstmsArgSndLogVO) throws DAOException {
		DBRowSet dbRowset = null;
		BkgCstmsArgSndLogVO vo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.putAll(bkgCstmsArgSndLogVO.getColumnValues());
			velParam.putAll(bkgCstmsArgSndLogVO.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ArgCustomsTransmissionDBDAOsearchCstmsArgSndLogRSQL(), param, velParam);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsArgSndLogVO.class);
			if (list.size() > 0)
				vo = (BkgCstmsArgSndLogVO)list.get(0);
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
	 * BL정보 조회
	 * 
	 * @param arsManifestTransmitVO
	 * @return
	 * @throws DAOException
	 */
	public List<ArgElInfoVO> searchElNoList(ArgManifestTransmitVO arsManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ArgElInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.putAll(arsManifestTransmitVO.getColumnValues());
			velParam.putAll(arsManifestTransmitVO.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ArgCustomsTransmissionDBDAOsearchElNoListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ArgElInfoVO.class);
			
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