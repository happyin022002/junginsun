/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ImmediateExitDBDAO.java
*@FileTitle : Immediate Exit Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.10 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.basic.ImmediateExitBCImpl;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.vo.ImmediateExitCreationVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.vo.SearchParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ImmediateExitDBDAO <br>
 * - ALPS-ContainerLeaseMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jang Jun-Woo
 * @see ImmediateExitBCImpl 참조
 * @since J2EE 1.6
 */
public class ImmediateExitDBDAO extends DBDAOSupport {

	/**
	 * Immediate Exit Creation 대상 장비목록을 조회합니다.<br>
	 * 
	 * @param SearchParamVO searchParamVO
	 * @return List<ImmediateExitCreationVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ImmediateExitCreationVO> searchImmediateExitCreationListData(SearchParamVO searchParamVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<ImmediateExitCreationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				List<String> cntrNolist  = null;
				if(JSPUtil.getNull(searchParamVO.getCntrNo()).equals("")){
					if ( !JSPUtil.getNull(searchParamVO.getCntrNoList()).equals("") ) {
						cntrNolist = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrNoList(),",","|"));
						param.put("cntr_no_list_seq", cntrNolist);
						velParam.put("cntr_no_list_seq", cntrNolist);
					}					
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new ImmediateExitDBDAOImmediateExitCreationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ImmediateExitCreationVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}