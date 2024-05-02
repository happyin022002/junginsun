/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseOrderBCDBDAO.java
*@FileTitle : esm_bkg-0913
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.15 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdDetailOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdSimpleOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdUsaOutVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS EmptyReleaseOrderBCDBDAO <br>
 * - ALPS-OutboundBLMgtSC system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Lee Jin Seo
 * @see EmptyReleaseOrderBCBCImpl 참조
 * @since J2EE 1.6
 */
public class EmptyReleaseOrderDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = -967202402232355851L;

	/**
	 * EmptyReleaseOrderBCDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param model 데이타 모델
	 * @return DBRowSet
	 * @throws DAOException
	 */

	/**
	 * Simple 조회 이벤트 처리 ESM_BKG_0252<br>
	 * 
	 * Empty Release Order를 내기 위해 booking list를 Simple type으로 조회한다.
	 * 
	 * @param MtyRlseOrdInVO mtyRlseOrdIn
	 * @author Choi Do Soon
	 * @return List<MtyRlseOrdSimpleOutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MtyRlseOrdSimpleOutVO> searchMtyRlseOrdForSimple(MtyRlseOrdInVO mtyRlseOrdIn) throws DAOException {
	    DBRowSet dbRowset = null;
	    List<MtyRlseOrdSimpleOutVO> list = null;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try {

	        Map<String, String> mapVO =  mtyRlseOrdIn.getColumnValues();

	        param.putAll(mapVO);
	        velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");

	        EmptyReleaseOrderDBDAOMtyRlseOrdSimpleOutRSQL template = new EmptyReleaseOrderDBDAOMtyRlseOrdSimpleOutRSQL();
	      	dbRowset = exec.executeQuery(template, param, velParam);

	        list = (List) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdSimpleOutVO.class);
	    } catch(SQLException ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    } catch(Exception ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    return list;
	}

	 /**
	  * Detail 조회 이벤트 처리 ESM_BKG_0252<br>
	  * 
	  * Empty Release Order를 내기 위해 booking list를 Detail(s) type으로 조회한다.
	  * 
	  * @param MtyRlseOrdInVO mtyRlseOrdIn
	  * @author Choi Do Soon
	  * @return List<MtyRlseOrdDetailOutVO>
	  * @throws DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<MtyRlseOrdDetailOutVO> searchMtyRlseOrdForDetail(MtyRlseOrdInVO mtyRlseOrdIn) throws DAOException {
	    DBRowSet dbRowset = null;
	    List<MtyRlseOrdDetailOutVO> list = null;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try {

	        Map<String, String> mapVO =  mtyRlseOrdIn.getColumnValues();

	        param.putAll(mapVO);
	        velParam.putAll(mapVO);

	        SQLExecuter exec = new SQLExecuter("DEFAULT");

	        EmptyReleaseOrderDBDAOMtyRlseOrdDetailOutRSQL template = new EmptyReleaseOrderDBDAOMtyRlseOrdDetailOutRSQL();
	        dbRowset = exec.executeQuery(template, param, velParam);

	        list = (List) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdDetailOutVO.class);
	    } catch(SQLException ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    } catch(Exception ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    return list;
	}

	/**
	 * Detail(USA) 조회 이벤트 처리 ESM_BKG_0252<br>
	 * 
	 * Empty Release Order를 내기 위해 booking list를 Detail(s) USA type으로 조회한다.
	 * 
	 * @param MtyRlseOrdInVO mtyRlseOrdIn
	 * @author Choi Do Soon
	 * @return List<MtyRlseOrdUsaOutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MtyRlseOrdUsaOutVO> searchMtyRlseOrdForUsa(MtyRlseOrdInVO mtyRlseOrdIn) throws DAOException {
	    DBRowSet dbRowset = null;
	    List<MtyRlseOrdUsaOutVO> list = null;
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try {

	        Map<String, String> mapVO =  mtyRlseOrdIn.getColumnValues();

	        param.putAll(mapVO);
	        velParam.putAll(mapVO);

	        SQLExecuter exec = new SQLExecuter("DEFAULT");

	        EmptyReleaseOrderDBDAOMtyRlseOrdUsaOutRSQL template = new EmptyReleaseOrderDBDAOMtyRlseOrdUsaOutRSQL();
	        dbRowset = exec.executeQuery(template, param, velParam);

	        list = (List) RowSetUtil.rowSetToVOs(dbRowset, MtyRlseOrdUsaOutVO.class);
	    } catch(SQLException ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    } catch(Exception ex) {
	        //log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    return list;
	}

}
