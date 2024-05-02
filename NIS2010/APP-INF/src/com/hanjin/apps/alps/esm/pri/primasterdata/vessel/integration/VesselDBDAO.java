/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselDBDAO.java
*@FileTitle : Vessel Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.27 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.vessel.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.primasterdata.vessel.basic.VesselBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;


/**
 * NIS2010 VesselDBDAO <br>
 * - NIS2010-PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Moon Dong Gyu
 * @see VesselBCImpl 참조
 * @since J2EE 1.6
 */
public class VesselDBDAO extends DBDAOSupport {

	/**
	 * Vessel Code 정보를 조회합니다.<br>
	 * 
	 * @param MdmVslCntrVO mdmVslCntrVO
	 * @return List<MdmVslCntrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmVslCntrVO> searchVesselList(MdmVslCntrVO mdmVslCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmVslCntrVO != null){
				Map<String, String> mapVO = mdmVslCntrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselDBDAOMdmVslCntrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslCntrVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}