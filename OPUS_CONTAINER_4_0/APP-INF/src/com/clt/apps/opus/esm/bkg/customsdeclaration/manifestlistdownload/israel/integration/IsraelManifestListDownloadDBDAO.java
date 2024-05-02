/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : IsraelManifestListDownloadDBDAO.java
 *@FileTitle : IsraelManifestListDownloadDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.08.11
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2013.08.11 김보배
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2013.09.06 김보배 [CHM-201325976] Israel FROB 신고 결과 조회 화면 생성 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelManifestListBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelRcvHisCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelSearchRcvHisVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS IsraelManifestListDownloadDBDAO <br>
 * - ALPS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author BOBAE KIM
 * @see IsraelCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public class IsraelManifestListDownloadDBDAO extends DBDAOSupport {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * 입력된 VVD 가 이스라엘을 거치는지 아닌지 VVD schedule 을 조회한다.
	 * 
	 * @param IsraelManifestListCondVO israelManifestListCondVO
	 * @return String skdFlg
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchVesselSchedule(IsraelManifestListCondVO israelManifestListCondVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String skdFlg = "";

		try
		{			
			Map<String, String> mapVO = israelManifestListCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IsraelManifestListDownloadDBDAOsearchVesselScheduleRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				skdFlg = dbRowset.getString(1);
			} else {
				skdFlg = "";
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return skdFlg;
	}
	
	
	/**
	 * B/L info 를 조회한다.
	 * 
	 * @param IsraelManifestListCondVO israelManifestListCondVO
	 * @return List<IsraelManifestListBlInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IsraelManifestListBlInfoVO> searchCustomsBlInfo(IsraelManifestListCondVO israelManifestListCondVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <IsraelManifestListBlInfoVO> list = null;

		try
		{			
			Map<String, String> mapVO = israelManifestListCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IsraelManifestListDownloadDBDAOsearchEurManifestListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, IsraelManifestListBlInfoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/////////////////////////////////////////// history 화면 //////////////////////////////////////////////////
	/////////////////////////////////////////// history 화면 //////////////////////////////////////////////////
	/**
	 * 이스라엘 수신 히스토리를 조회한다.
	 * 
	 * @param IsraelRcvHisCondVO israelRcvHisCondVO
	 * @return List<IsraelRcvHisCondVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IsraelSearchRcvHisVO> searchRcvHis(IsraelRcvHisCondVO israelRcvHisCondVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <IsraelSearchRcvHisVO> list = null;

		try
		{			
			Map<String, String> mapVO = israelRcvHisCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IsraelManifestListDownloadDBDAOsearchRcvHisRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, IsraelSearchRcvHisVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/////////////////////////////////////////// history 화면 //////////////////////////////////////////////////
	/////////////////////////////////////////// history 화면 //////////////////////////////////////////////////

	
}
