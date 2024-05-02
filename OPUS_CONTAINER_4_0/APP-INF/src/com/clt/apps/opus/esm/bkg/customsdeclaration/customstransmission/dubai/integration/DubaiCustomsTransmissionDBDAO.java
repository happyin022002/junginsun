/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : DubaiCustomsTransmissionDBDAO.java
 *@FileTitle : CustomsTransmission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.03.02
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.05.25 경종윤
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.basic.BrcsCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.vo.DubaiBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.vo.DubaiCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.vo.DubaiCntrMfInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.vo.DubaiManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.vo.DubaiVvdInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS DubaiCustomsTransmissionDBDAO.java <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kyoung Jong Yun
 * @see BrcsCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public class DubaiCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * 두바이 FlatFile - 배정보를 조회한다.<br>
	 * 
	 * @param DubaiManifestTransmitVO dubaiManifestTransmitVO
	 * @return DubaiVvdInfoVO
	 * @throws DAOException
	 */
	public DubaiVvdInfoVO searchFlatFileVvdInfo(DubaiManifestTransmitVO dubaiManifestTransmitVO) throws DAOException {
		DubaiVvdInfoVO dubaiVvdInfoVO = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dubaiManifestTransmitVO != null)
			{
				Map<String, String> mapVO = dubaiManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DubaiCustomsTransmissionDBDAOsearchFlatFileVvdInfoRSQL(), param, velParam);

			List<Object> list = RowSetUtil.rowSetToVOs(dbRowset, DubaiVvdInfoVO.class);

			if (list != null && list.size() > 0)
			{
				dubaiVvdInfoVO = (DubaiVvdInfoVO) list.get(0);
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
		return dubaiVvdInfoVO;
	}

	/**
	 * 두바이 FlatFile - BL정보를 조회한다.<br>
	 * 
	 * @param DubaiManifestTransmitVO dubaiManifestTransmitVO
	 * @return DubaiBlInfoVO
	 * @throws DAOException
	 */
	public DubaiBlInfoVO searchFlatFileBlInfo(DubaiManifestTransmitVO dubaiManifestTransmitVO) throws DAOException {
		DubaiBlInfoVO dubaiBlInfoVO = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dubaiManifestTransmitVO != null)
			{
				Map<String, String> mapVO = dubaiManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DubaiCustomsTransmissionDBDAOsearchFlatFileBlInfoRSQL(), param, velParam);

			List<Object> list = RowSetUtil.rowSetToVOs(dbRowset, DubaiBlInfoVO.class);

			if (list != null && list.size() > 0)
			{
				dubaiBlInfoVO = (DubaiBlInfoVO) list.get(list.size() - 1);
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

	/**
	 * 두바이 FlatFile - 컨테이너정보를 조회한다.<br>
	 * 
	 * @param DubaiManifestTransmitVO dubaiManifestTransmitVO
	 * @return List<DubaiCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DubaiCntrInfoVO> searchFlatFileCntrList(DubaiManifestTransmitVO dubaiManifestTransmitVO)
			throws DAOException {
		List<DubaiCntrInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dubaiManifestTransmitVO != null)
			{
				Map<String, String> mapVO = dubaiManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DubaiCustomsTransmissionDBDAOsearchFlatFileCntrListRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DubaiCntrInfoVO.class);

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
	 * 두바이 FlatFile - 컨테이너MF정보를 조회한다.<br>
	 * 
	 * @param DubaiManifestTransmitVO dubaiManifestTransmitVO
	 * @return List<DubaiCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DubaiCntrMfInfoVO> searchFlatFileCntrMfList(DubaiManifestTransmitVO dubaiManifestTransmitVO)
			throws DAOException {
		List<DubaiCntrMfInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dubaiManifestTransmitVO != null)
			{
				Map<String, String> mapVO = dubaiManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new DubaiCustomsTransmissionDBDAOsearchFlatFileCntrMfListRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DubaiCntrMfInfoVO.class);

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