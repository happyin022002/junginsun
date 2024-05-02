/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TesMvmtAudDBDAO.java
*@FileTitle : Contianer Movement - Reefer
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-05
*@LastModifier : Do-Hyun Kim
*@LastVersion : 1.0
* 2014-12-05 Do-Hyun Kim
* 1.0 최초 생성
*  
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.vo.SearchMvmtLegListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * PsoAdvanceAuditDBDAO ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author Do-Hyun Kim
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class TesMvmtAudDBDAO extends DBDAOSupport {
	 /**
	  * Contianer Movement - Reefer 조회한다.<br>
	  * 
	  * @param SearchMvmtLegListVO searchMvmtLegListVO
	  * @return List<SearchMvmtLegListVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchMvmtLegListVO> searchMvmtLegList(SearchMvmtLegListVO searchMvmtLegListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchMvmtLegListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchMvmtLegListVO != null){
				 Map<String, String> mapVO = searchMvmtLegListVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 String sTmp = "";
				 List<String> ltBkTmp = new ArrayList();
				 List<String> ltCntrTmp = new ArrayList();
				 String arrTmp[] = null;
				 
				 // bkg_no : Multi로 입력됨 -> "," 로 구분해서 list 형으로 Param/ Velparam 에 입력
				 sTmp = (String)param.get("bkg_no");
				 
				 if(!sTmp.equals("")){
					arrTmp = sTmp.split(",");
					for(int i=0;i<arrTmp.length;i++){   
						ltBkTmp.add(arrTmp[i]);   
					} 
					param.put("bkg_no",ltBkTmp);
					velParam.put("bkg_no",ltBkTmp);
				 }
				 
				 // cntr_no :  Multi로 입력됨 -> "," 로 구분해서 list 형으로 Param/ Velparam 에 입력
				 sTmp = (String)param.get("cntr_no");
				 
				 if(!sTmp.equals("")){
					arrTmp = sTmp.split(",");
					for(int i=0;i<arrTmp.length;i++){   
						ltCntrTmp.add(arrTmp[i]);   
					} 
					param.put("cntr_no",ltCntrTmp);
					velParam.put("cntr_no",ltCntrTmp);
				 }
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TesMvmtAudDBDAOSearchMvmtLegListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMvmtLegListVO .class);
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