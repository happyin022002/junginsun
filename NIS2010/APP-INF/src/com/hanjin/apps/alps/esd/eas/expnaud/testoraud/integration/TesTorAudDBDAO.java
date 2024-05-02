/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TesTorAudDBDAO.java
*@FileTitle : Expense Audit case Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.testoraud.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.basic.EacMgtBCImpl;
import com.hanjin.apps.alps.esd.eas.expnaud.testoraud.vo.RehandlingExpenseTorVsTpbVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS TesTorAudDBDAO <br>
 * - ALPS-Eac system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see EacMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class TesTorAudDBDAO extends DBDAOSupport {

	 /**
	  * Rehandling Expense - TOR vs. TPB 조회한다.<br>
	  * 
	  * @param RehandlingExpenseTorVsTpbVO rehandlingExpenseTorVsTpbVO
	  * @return List<RehandlingExpenseTorVsTpbVO>
	  * @exception EventException
	  */
	 @SuppressWarnings("unchecked")
	 public List<RehandlingExpenseTorVsTpbVO> searchRhndList(RehandlingExpenseTorVsTpbVO rehandlingExpenseTorVsTpbVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<RehandlingExpenseTorVsTpbVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(rehandlingExpenseTorVsTpbVO != null){
				 Map<String, String> mapVO = rehandlingExpenseTorVsTpbVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 // VVD : Multi로 입력됨 -> "," 로 구분해서 list 형으로 Param/ Velparam 에 입력
				 String sVVD = (String)param.get("s_vvd");
				 List<String> ltVVD = new ArrayList();
				 
				 if(!sVVD.equals("")){
					String arrVVD[] = sVVD.split(",");
					for(int i=0;i<arrVVD.length;i++){   
						ltVVD.add(arrVVD[i]);   
					} 
					param.put("s_vvd",ltVVD);
					velParam.put("s_vvd",ltVVD);
				 }
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TesTorAudDBDAOSearchRehandlingExpenseTorVsTpbRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, RehandlingExpenseTorVsTpbVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
}

