/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : Edi214ReceiveDBDAO.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2008-08-01
*@LastModifier : Y
*@LastVersion : 1.0
* 2008-08-01 Y
* 1.0 최초 생성
=========================================================*/


package com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.vo.SearchEdi322ActDatRcvDtVO;
import com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.vo.SearchEdi322BkgNoVO;
import com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.vo.SearchEdi322CntrNoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ENIS-SCE에 대한 DB 처리를 담당<br>
 * - ENIS-SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see Edi322ReceiveBCImpl 참조 
 * @since J2EE 1.4
 */
public class Edi322ReceiveDBDAO extends DBDAOSupport {

	/**
	 * create EDI322 MSG Temp Data
	 *    
	 * @param  Map param
	 * @throws DAOException
	 */
	public void createEDI322TmpData(Map param) throws DAOException {

		//int rowCnt = 0;
		// query parameter
		//Map<String, Object> param = new HashMap<String, Object>();

		try {
			new SQLExecuter("").executeUpdate(new Edi322ReceiveDBDAOAddEdi322MsgUSQL(),param, null);

		} catch (SQLException se) {
			//log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * create EDI322 Msg If
	 * 
	 * @param Map param
	 * @throws DAOException
	 */
	public void createEDI322MsgIf(Map param) throws DAOException {

		int rowCnt = 0;

		try {
			if(param.get("EVENT_STS").equals("NT") || param.get("EVENT_STS").equals("NF") || 
					param.get("EVENT_STS").equals("FT")){
				rowCnt = new SQLExecuter("")
				.executeUpdate(new Edi322ReceiveDBDAOAddEdi322MsgIFUSQL(),param, null);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchEdi322CntrNoVO searchEdi322CntrNoVO
	 * @return List<SearchEdi322CntrNoVO>
	 * @throws DAOException
	 */
	public List<SearchEdi322CntrNoVO> searchEdi322CntrNoVO(SearchEdi322CntrNoVO searchEdi322CntrNoVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEdi322CntrNoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if (searchEdi322CntrNoVO != null) {

				Map<String, String> mapVO = searchEdi322CntrNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi322ReceiveDBDAOSearchEdi322CntrNoRSQL(),
					param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					SearchEdi322CntrNoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		
	
	
	/**
	 * 최신 컨테이너의 최신 BKG_NO를 조회한다.
	 * 
	 * @param SearchEdi322BkgNoVO searchEdi322BkgNoVO
	 * @return List<SearchEdi322BkgNoVO>
	 * @throws DAOException
	 */
	public List<SearchEdi322BkgNoVO> searchEdi322BkgNo(SearchEdi322BkgNoVO searchEdi322BkgNoVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEdi322BkgNoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if (searchEdi322BkgNoVO != null) {

				Map<String, String> mapVO = searchEdi322BkgNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi322ReceiveDBDAOSearchEdi322BkgNoRSQL(),
					param, null);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					SearchEdi322BkgNoVO.class);
			
			log.error("\n searchEdi322BkgNo get BkgNo Count:"+dbRowset.getRowCount()+"--------------------------");
			while(dbRowset.next()){
				log.error("\n searchEdi322BkgNo get BkgNo bkg# : "+dbRowset.getString("BKG_NO"));
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		
	
	/**
	 * ACT_DAT_RCV_DT 정보를 조회한다.
	 * 
	 * @param SearchEdi322ActDatRcvDtVO searchEdi322ActDatRcvDtVO
	 * @return List<SearchEdi322ActDatRcvDtVO>
	 * @throws DAOException
	 */
	public List<SearchEdi322ActDatRcvDtVO> searchEdi322ActDatRcvDt(SearchEdi322ActDatRcvDtVO searchEdi322ActDatRcvDtVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEdi322ActDatRcvDtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if (searchEdi322ActDatRcvDtVO != null) {

				Map<String, String> mapVO = searchEdi322ActDatRcvDtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi322ReceiveDBDAOSearchEdi322ActDatRcvDtRSQL(),
					param, null);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchEdi322ActDatRcvDtVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}			
}