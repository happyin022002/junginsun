/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceScheduleForRevenueVVDDBDAO.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedforrevenuevvd.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 VSKCodeFinderDAO <br>
 * - NIS2010-VSKCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SEO CHANG YUL
 * @see 참조
 * @since J2EE 1.4
 */
public class InterfaceScheduleForRevenueVVDDBDAO extends DBDAOSupport {
	
	/**
	 * Service Lane 리스트를 조회합니다.
	 * 
	 * @param List<VvdVO> vvdVOs
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void interfaceScheduleForRevenueVVD(List<VvdVO> vvdVOs) throws DAOException {
		 
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {
			
				SQLExecuter sqlExe = new SQLExecuter("");
				
				if(vvdVOs == null)	return;
				
				for(VvdVO tmpVO : vvdVOs){
					Map<String, String> mapVO = tmpVO.getColumnValues();

					param.putAll(mapVO);
					
					sqlExe.executeSP((ISQLTemplate)new InterfaceScheduleForRevenueVVDDBDAOCreateRevenueVVDCSQL(), param, velParam);
				}
				
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
	}
	 
}

