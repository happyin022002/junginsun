/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EdiBLPickUpReceiveDBDAO.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2014-11-04
*@LastModifier : Y
*@LastVersion : 1.0
* 2014-11-04 Y
* 1.0 최초 생성
=========================================================*/


package com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.vo.SearchEdiBLPickUpCntrNoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * SCE에 대한 DB 처리를 담당<br>
 * - SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see EdiBLPickUpReceiveBCImpl 참조 
 * @since J2EE 1.4
 */
public class EdiBLPickUpReceiveDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * create EDIBLPickUp MSG Temp Data
	 *    
	 * @param  Map<String, String> param
	 * @throws DAOException
	 */
	public void createEDIBLPickUpTmpData(Map<String, String> param) throws DAOException {
		//int rowCnt = 0;
		// query parameter
		//Map<String, Object> param = new HashMap<String, Object>();

		try {
			new SQLExecuter("").executeUpdate(new EdiBLPickUpReceiveDBDAOAddEdiBLPickUpMsgUSQL(),param, null);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * create EDIBLPickUp Msg If
	 * 
	 * @param Map<String, String> param
	 * @throws DAOException
	 */
	public void createEDIBLPickUpMsgIf(Map<String, String> param) throws DAOException {
		try {
			if(param.get("EVENT_STS").equals("NT") ){
				new SQLExecuter("").executeUpdate(new EdiBLPickUpReceiveDBDAOAddEdiBLPickUpMsgIFUSQL(),param, null);
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
	 * @param SearchEdiBLPickUpCntrNoVO searchEdiBLPickUpCntrNoVO
	 * @return List<SearchEdiBLPickUpCntrNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchEdiBLPickUpCntrNoVO> searchEdiBLPickUpCntrNoVO(SearchEdiBLPickUpCntrNoVO searchEdiBLPickUpCntrNoVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEdiBLPickUpCntrNoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchEdiBLPickUpCntrNoVO != null) {
				Map<String, String> mapVO = searchEdiBLPickUpCntrNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EdiBLPickUpReceiveDBDAOSearchEdiBLPickUpCntrNoRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchEdiBLPickUpCntrNoVO.class);
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