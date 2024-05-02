/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TesBkgAudDBDAO.java
*@FileTitle : Rehandling(BKG COD)
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 김현주
*@LastVersion : 1.0
* 2015.03.12 김현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.basic.EacMgtBCImpl;
import com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.vo.RehandlingBkgCodVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS TesBkgAudDBDAO <br>
 * - ALPS-Eac system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see EacMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class TesBkgAudDBDAO extends DBDAOSupport {

	 /**
	  * Rehandling(BKG COD) 조회한다.<br>
	  * 
	  * @param RehandlingBkgCodVO rehandlingBkgCodVO
	  * @return List<RehandlingBkgCodVO>
	  * @exception EventException
	  */
	 @SuppressWarnings("unchecked")
	 public List<RehandlingBkgCodVO> searchCodCostList(RehandlingBkgCodVO rehandlingBkgCodVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<RehandlingBkgCodVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(rehandlingBkgCodVO != null){
				 Map<String, String> mapVO = rehandlingBkgCodVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 // CA Reason : Multi로 입력됨 -> "," 로 구분해서 list 형으로 Param/ Velparam 에 입력
				 String sCARsnCd = (String)param.get("s_ca_reason");
				 List<String> ltCARsnCd = new ArrayList<String>();
				 
				 if ( !"".equals(sCARsnCd) ) {
					String[]	arrCARsnCd = sCARsnCd.split(",");
					for ( int i = 0; i < arrCARsnCd.length; i++ ) {
						ltCARsnCd.add(arrCARsnCd[i]);
					} 
					param.put("s_ca_reason", ltCARsnCd);
					velParam.put("s_ca_reason", ltCARsnCd);
				 }
				 
				 // BKg No : Multi로 입력됨 -> "," 로 구분해서 list 형으로 Param/ Velparam 에 입력
				 String sBkgNo = (String)param.get("s_bkg_no");
				 List<String> ltBkgNo = new ArrayList();
				 
				 if(!sBkgNo.equals("")){
					 String arrBkgNo[] = sBkgNo.split(",");
					 for(int i=0;i<arrBkgNo.length;i++){   
						 ltBkgNo.add(arrBkgNo[i]);   
					 } 
					 param.put("s_bkg_no",ltBkgNo);
					 velParam.put("s_bkg_no",ltBkgNo);
				 }
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TesBkgAudDBDAOSearchRehandlingBkgCodRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, RehandlingBkgCodVO .class);
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
