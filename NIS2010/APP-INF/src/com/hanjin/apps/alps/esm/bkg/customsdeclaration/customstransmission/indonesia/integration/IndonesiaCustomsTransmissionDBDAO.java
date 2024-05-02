/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndonesiaCustomsTransmissionDBDAO.java
*@FileTitle : UI_BKG-0310
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.04.21 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IdManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestDetail1VO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestDetail2VO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestDokVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestHeaderVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS JapanCustomsTransmissionDAO <br>
 * - ALPS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JI-YOUNG JANG
 * @see IndonesiaCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
public class IndonesiaCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * Indonesia 세관에 Manifest 신고할 내용을 download 받을 File로 생성하기 위해<br>
     * 수출 허가 정보를 조회한다. -- UI_BKG-0310, UI_BKG-0311<br>
	 * 
	 * @param IdManifestListCondVO idManifestListCondVO
 	 * @return IndonesiaManifestHeaderVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public IndonesiaManifestHeaderVO searchManifestHeader(IdManifestListCondVO idManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		IndonesiaManifestHeaderVO indonesiaManifestHeaderVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (idManifestListCondVO != null)
			{
				Map<String, String> mapVO = idManifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndonesiaCustomsTransmissionDBDAOSearchManifestHeaderRSQL(), param, velParam);
			List<IndonesiaManifestHeaderVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, IndonesiaManifestHeaderVO.class);
			if (list.size() > 0) {
				indonesiaManifestHeaderVO = (IndonesiaManifestHeaderVO) list.get(0);
			} else {
				indonesiaManifestHeaderVO = new IndonesiaManifestHeaderVO();
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
		return indonesiaManifestHeaderVO;
	}
	
	/**
	 * Indonesia 세관에 Manifest 신고할 내용을 download 받을 File로 생성하기 위해<br>
	 * Detail 정보를 조회한다. -- UI_BKG-0310, UI_BKG-0311<br>
	 * 
	 * @param IdManifestListCondVO idManifestListCondVO
 	 * @return List<IndonesiaManifestDetail1VO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IndonesiaManifestDetail1VO> searchManifestDetail1ListByOpt01 (IdManifestListCondVO idManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IndonesiaManifestDetail1VO> indonesiaManifestDetail1VOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (idManifestListCondVO != null)
			{
				Map<String, String> mapVO = idManifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt01RSQL(), param, velParam);
			indonesiaManifestDetail1VOs = (List) RowSetUtil.rowSetToVOs(dbRowset, IndonesiaManifestDetail1VO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return indonesiaManifestDetail1VOs;
	}
	
	/**
	 * Indonesia 세관에 Manifest 신고할 내용을 download 받을 File로 생성하기 위해<br>
	 * Detail 정보를 조회한다. -- UI_BKG-0310, UI_BKG-0311<br>
	 * 
	 * @param IdManifestListCondVO idManifestListCondVO
 	 * @return List<IndonesiaManifestDetail1VO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IndonesiaManifestDetail1VO> searchManifestDetail1ListByOpt02 (IdManifestListCondVO idManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IndonesiaManifestDetail1VO> indonesiaManifestDetail1VOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (idManifestListCondVO != null)
			{
				Map<String, String> mapVO = idManifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt02RSQL(), param, velParam);
			indonesiaManifestDetail1VOs = (List) RowSetUtil.rowSetToVOs(dbRowset, IndonesiaManifestDetail1VO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return indonesiaManifestDetail1VOs;
	}
	
	/**
	 * Indonesia 세관에 Manifest 신고할 내용을 download 받을 File로 생성하기 위해<br>
	 * Detail 정보를 조회한다. -- UI_BKG-0310, UI_BKG-0311<br>
	 * 
	 * @param IdManifestListCondVO idManifestListCondVO
 	 * @return List<IndonesiaManifestDetail1VO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IndonesiaManifestDetail1VO> searchManifestDetail1ListByOpt03 (IdManifestListCondVO idManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IndonesiaManifestDetail1VO> indonesiaManifestDetail1VOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (idManifestListCondVO != null)
			{
				Map<String, String> mapVO = idManifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt03RSQL(), param, velParam);
			indonesiaManifestDetail1VOs = (List) RowSetUtil.rowSetToVOs(dbRowset, IndonesiaManifestDetail1VO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return indonesiaManifestDetail1VOs;
	}
	
	/**
	 * Indonesia 세관에 Manifest 신고할 내용을 download 받을 File로 생성하기 위해<br>
	 * Detail 정보를 조회한다. -- UI_BKG-0310, UI_BKG-0311<br>
	 * 
	 * @param IdManifestListCondVO idManifestListCondVO
 	 * @return List<IndonesiaManifestDetail1VO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IndonesiaManifestDetail1VO> searchManifestDetail1ListByOpt04 (IdManifestListCondVO idManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IndonesiaManifestDetail1VO> indonesiaManifestDetail1VOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (idManifestListCondVO != null)
			{
				Map<String, String> mapVO = idManifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndonesiaCustomsTransmissionDBDAOsearchManifestDetail1ListByOpt04RSQL(), param, velParam);
			indonesiaManifestDetail1VOs = (List) RowSetUtil.rowSetToVOs(dbRowset, IndonesiaManifestDetail1VO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return indonesiaManifestDetail1VOs;
	}	

	/**
	 * Indonesia 세관에 Manifest 신고할 내용을 download 받을 File로 생성하기 위해<br>
	 * Detail 정보를 조회한다. -- UI_BKG-0310, UI_BKG-0311<br>
	 * 
	 * @param IdManifestListCondVO idManifestListCondVO
 	 * @return IndonesiaManifestDetail2VO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public IndonesiaManifestDetail2VO searchManifestDetail2List (IdManifestListCondVO idManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IndonesiaManifestDetail2VO> indonesiaManifestDetail2VOs = null;
		IndonesiaManifestDetail2VO indonesiaManifestDetail2VO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (idManifestListCondVO != null)
			{
				Map<String, String> mapVO = idManifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndonesiaCustomsTransmissionDBDAOSearchManifestDetail2ListRSQL(), param, velParam);
			indonesiaManifestDetail2VOs = (List) RowSetUtil.rowSetToVOs(dbRowset, IndonesiaManifestDetail2VO.class);
			if (indonesiaManifestDetail2VOs.size() > 0) {
				indonesiaManifestDetail2VO = indonesiaManifestDetail2VOs.get(0);
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
		return indonesiaManifestDetail2VO;
	}

	/**
	 * Indonesia 세관에 Manifest 신고할 내용을 download 받을 File로 생성하기 위해<br>
	 * Detail 정보를 조회한다. -- UI_BKG-0310, UI_BKG-0311<br>
	 * 
	 * @param IdManifestListCondVO idManifestListCondVO
 	 * @return List<IndonesiaManifestContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IndonesiaManifestContainerVO> searchManifestContainerList (IdManifestListCondVO idManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IndonesiaManifestContainerVO> indonesiaManifestContainerVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (idManifestListCondVO != null)
			{
				Map<String, String> mapVO = idManifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndonesiaCustomsTransmissionDBDAOSearchManifestContainerListRSQL(), param, velParam);
			indonesiaManifestContainerVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, IndonesiaManifestContainerVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return indonesiaManifestContainerVOs;
	}

	/**
	 * Indonesia 세관에 Manifest 신고할 내용을 download 받을 File로 생성하기 위해<br>
	 * DOK 정보를 조회한다. -- UI_BKG-0310, UI_BKG-0311<br>
	 * 
	 * @param IdManifestListCondVO idManifestListCondVO
 	 * @return List<IndonesiaManifestDokVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IndonesiaManifestDokVO> searchManifestDOK (IdManifestListCondVO idManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IndonesiaManifestDokVO> indonesiaManifestDokVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (idManifestListCondVO != null)
			{
				Map<String, String> mapVO = idManifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndonesiaCustomsTransmissionDBDAOSearchManifestDOKRSQL(), param, velParam);
			indonesiaManifestDokVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, IndonesiaManifestDokVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return indonesiaManifestDokVOs;
	}
}
