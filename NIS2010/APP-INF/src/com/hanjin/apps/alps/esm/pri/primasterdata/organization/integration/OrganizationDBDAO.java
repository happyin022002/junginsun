/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OrganizationDBDAO.java
*@FileTitle : Office Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.24 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.organization.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.primasterdata.organization.basic.OrganizationBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.organization.vo.MdmOrzVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS OrganizationDBDAO <br>
 * - ALPS-PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JaeYeon Kim
 * @see OrganizationBCImpl 참조
 * @since J2EE 1.6
 */
public class OrganizationDBDAO extends DBDAOSupport {

	/**
	 * Office Code List를 조회합니다. <br>
	 * 
	 * @param MdmOrzVO mdmOrzVO
	 * @return List<MdmOrzVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmOrzVO> searchOrganizationList(MdmOrzVO mdmOrzVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmOrzVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmOrzVO != null){
				Map<String, String> mapVO = mdmOrzVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OrganizationDBDAOMdmOrzVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmOrzVO .class);
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