/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeDBDAO.java
*@FileTitle : Charge Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.25 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.charge.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.primasterdata.charge.basic.ChargeBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.charge.vo.MdmChgVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ChargeDBDAO <br>
 * - ALPS-PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JaeYeon Kim
 * @see ChargeBCImpl 참조
 * @since J2EE 1.6
 */
public class ChargeDBDAO extends DBDAOSupport {

	/**
	 * Charge Code List를 조회합니다.<br>
	 * 
	 * @param MdmChgVO mdmChgVO
	 * @return List<MdmChgVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmChgVO> searchChargeList(MdmChgVO mdmChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmChgVO != null){
				Map<String, String> mapVO = mdmChgVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeDBDAOMdmChgVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmChgVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}