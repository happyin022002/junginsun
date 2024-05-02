/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MyanmarManifestListDownloadDBDAO.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 2012.11.19 윤태승
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.vo.MyanmarManifestListBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.vo.MyanmarManifestListCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS MyanmarManifestListDownloadDBDAO <br>
 * - OPUS-Myanmar Customs Manifest system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Byeon, Jong-Geon
 * @see MyanmarCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public class MyanmarManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 1155화면, B/L info를 조회한다.
	 *
	 * @param MyanmarManifestListCondVO inputVO
	 * @return List<MyanmarManifestListBlInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MyanmarManifestListBlInfoVO> searchCustomsBlInfo(MyanmarManifestListCondVO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <MyanmarManifestListBlInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MyanmarManifestListDownloadDBDAOSearchCustomsBlInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MyanmarManifestListBlInfoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

}
