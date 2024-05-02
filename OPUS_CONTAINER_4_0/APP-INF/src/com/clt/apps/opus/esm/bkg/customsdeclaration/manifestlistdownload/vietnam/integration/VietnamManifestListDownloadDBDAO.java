/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MalaysiaManifestListDownloadDBDAO.java
 *@FileTitle : CustomsTransmission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.02.07
 *@LastModifier : 변종건
 *@LastVersion : 1.0
 * 2012.02.07 변종건
 * 1.0 Creation
 * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.basic.MalaysiaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS MalaysiaManifestListDownloadDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Byeon, Jong-Geon
 * @see MalaysiaCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public class VietnamManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 1149화면, B/L info를 조회한다.
	 *
	 * @param VietnamManifestListCondVO inputVO
	 * @return List<VietnamManifestListBlInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<VietnamManifestListBlInfoVO> searchCustomsBlInfo(VietnamManifestListCondVO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <VietnamManifestListBlInfoVO> list = null;

		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new VietnamManifestListDownloadDBDAOSearchCustomsBlInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VietnamManifestListBlInfoVO.class);

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
