/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OTRCommRequestDBDAO.java
*@FileTitle : OTRCommRequestDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.02 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.basic.OTRCommRequestBCImpl;
import com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.vo.OTRCommRequestVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS OTRCommRequestDBDAO <br>
 * - OPUS-ACMRequest system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM YOUNG-OH
 * @see OTRCommRequestBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class OTRCommRequestDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 목록을 조회<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OTRCommRequestVO> searchOTRCommRequest(OTRCommRequestVO otrCommRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OTRCommRequestVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (otrCommRequestVO != null) {
				Map<String, String> mapVO= otrCommRequestVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OTRCommRequestDBDAOSearchOTRCommRequestListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OTRCommRequestVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 화면의 office 및 vendor 정보를 조회한다.<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OTRCommRequestVO> searchOfficeVendorInfo(OTRCommRequestVO otrCommRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OTRCommRequestVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (otrCommRequestVO != null) {
				Map<String, String> mapVO= otrCommRequestVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OTRCommRequestDBDAOSearchOfficeVendorInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OTRCommRequestVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

		/**
		 * [ESM_ACM_0014]
		 * Other Commission Request 화면의 Add Row 시  PatmentAmt, UsdAmt를 조회한다.<br>
		 *
		 * @param OTRCommRequestVO otrCommRequestVO
		 * @return List<OTRCommRequestVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<OTRCommRequestVO> searchPatmentUsdAmt(OTRCommRequestVO otrCommRequestVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<OTRCommRequestVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (otrCommRequestVO != null) {
					Map<String, String> mapVO= otrCommRequestVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OTRCommRequestDBDAOSearchPatmentUsdAmtRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OTRCommRequestVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}

		/**
		 * [ESM_ACM_0014]
		 * Other Commission Request 화면의 Cur 변경시 , xchRt를 조회한다.<br>
		 *
		 * @param OTRCommRequestVO otrCommRequestVO
		 * @return List<OTRCommRequestVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<OTRCommRequestVO> searchCurrXchRt(OTRCommRequestVO otrCommRequestVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<OTRCommRequestVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (otrCommRequestVO != null) {
					Map<String, String> mapVO= otrCommRequestVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OTRCommRequestDBDAOSearchCurrXchRtRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OTRCommRequestVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}


	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 목록을 일괄적으로 생성<br>
	 *
	 * @param List<OTRCommRequestVO> otrCommRequestVOs
	 * @throws DAOException
	 */
	public void addOTRCommRequestAcmAgnOtrComm(List<OTRCommRequestVO> otrCommRequestVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (otrCommRequestVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OTRCommRequestDBDAOAddOTRCommRequestAcmAgnOtrCommCSQL(), otrCommRequestVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 목록을 일괄적으로 수정<br>
	 *
	 * @param List<OTRCommRequestVO> otrCommRequestVOs
	 * @throws DAOException
	 */
	public void modifyOTRCommRequestAcmAgnOtrComm(List<OTRCommRequestVO> otrCommRequestVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (otrCommRequestVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OTRCommRequestDBDAOmodifyOTRCommRequestAcmAgnOtrCommUSQL(), otrCommRequestVOs, null);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<OTRCommRequestVO> otrCommRequestVOs
	 * @throws DAOException
	 */
	public void removeOTRCommRequestAcmAgnOtrComm(List<OTRCommRequestVO> otrCommRequestVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (otrCommRequestVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OTRCommRequestDBDAOremoveOTRCommRequestAcmAgnOtrCommDSQL(), otrCommRequestVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 목록을 Request<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return
	 * @throws DAOException
	 */
	public int requestOTRCommRequest(OTRCommRequestVO otrCommRequestVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if(otrCommRequestVO != null){
				Map<String, String> mapVO = otrCommRequestVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new OTRCommRequestDBDAOReqOTRCommRequestListUSQL(), param,velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}




	/**
	 * (ESM_AGT_0042) Other Commission Maintenance & Request의 정보를 조회한다.<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OTRCommRequestVO> searchOTRCommRequestNo(OTRCommRequestVO otrCommRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OTRCommRequestVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(otrCommRequestVO != null){
				Map<String, String> mapVO = otrCommRequestVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OTRCommRequestDBDAOSearchOTRCommRequestNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OTRCommRequestVO .class);
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
	 * [ESM_ACM_0014]
	 * Other Commission Request 화면의 Cur 변경시 xchRt를 조회(XCH_RT_DIV_LVL 값 4인경우 사용)<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OTRCommRequestVO> searchFxCurrRt(OTRCommRequestVO otrCommRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OTRCommRequestVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (otrCommRequestVO != null) {
				Map<String, String> mapVO= otrCommRequestVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OTRCommRequestDBDAOSearchFxCurrRtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OTRCommRequestVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


	/**
	 * [ESM_ACM_0014]
	 * Other Commission Request 화면의 Cur 변경시 xchRt를 조회(XCH_RT_DIV_LVL 값 4인경우 사용)<br>
	 *
	 * @param OTRCommRequestVO otrCommRequestVO
	 * @return List<OTRCommRequestVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OTRCommRequestVO> searchPatmentFxCurrUsdAmt(OTRCommRequestVO otrCommRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OTRCommRequestVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (otrCommRequestVO != null) {
				Map<String, String> mapVO= otrCommRequestVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OTRCommRequestDBDAOSearchPatmentFxCurrUsdAmtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OTRCommRequestVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}