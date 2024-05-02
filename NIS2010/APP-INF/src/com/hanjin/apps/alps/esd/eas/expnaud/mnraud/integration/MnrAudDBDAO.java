/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MnrAudDBDAO.java
*@FileTitle : Expense Audit case Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.mnraud.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.basic.EacMgtBCImpl;
import com.hanjin.apps.alps.esd.eas.expnaud.mnraud.vo.HbarInquiryByBkgVO;
import com.hanjin.apps.alps.esd.eas.expnaud.mnraud.vo.HbarInquiryByHistoryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS MnrAudDBDAO <br>
 * - ALPS-Eac system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see EacMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class MnrAudDBDAO extends DBDAOSupport {


	 /**
	  * H/Bar Inquiry by BKG 조회한다.<br>
	  * 
	  * @param HbarInquiryByBkgVO hbarInquiryByBkgVO
	  * @return List<HbarInquiryByBkgVO>
	  * @exception EventException
	  */
	 @SuppressWarnings("unchecked")
	 public List<HbarInquiryByBkgVO> searchBkgHngrList(HbarInquiryByBkgVO hbarInquiryByBkgVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<HbarInquiryByBkgVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(hbarInquiryByBkgVO != null){
				 Map<String, String> mapVO = hbarInquiryByBkgVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 String sTmp = "";
				 String arrTmp[] = null;
				 List<String> ltBkTmp = new ArrayList();
				 List<String> ltCntrTmp = new ArrayList();
				 
				 // Booking NO: Multi로 입력됨 -> "," 로 구분해서 list 형으로 Param/ Velparam 에 입력
				 sTmp = (String)param.get("s_bkg_no");
						 
				 if(!sTmp.equals("")){
					arrTmp = sTmp.split(",");
					for(int i=0;i<arrTmp.length;i++){   
						ltBkTmp.add(arrTmp[i]);   
					} 
					param.put("s_bkg_no",ltBkTmp);
					velParam.put("s_bkg_no",ltBkTmp);
				 }
				 
				 // Container NO: Multi로 입력됨 -> "," 로 구분해서 list 형으로 Param/ Velparam 에 입력
				 sTmp = (String)param.get("s_cntr_no");
						 
				 if(!sTmp.equals("")){
					arrTmp = sTmp.split(",");
					for(int i=0;i<arrTmp.length;i++){   
						ltCntrTmp.add(arrTmp[i]);   
					} 
					param.put("s_cntr_no",ltCntrTmp);
					velParam.put("s_cntr_no",ltCntrTmp);
				 }
				 
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MnrAudDBDAOSearchHbarInquiryByBkgRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HbarInquiryByBkgVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 /**
	  * H/Bar Inquiry by BKG 조회한다.<br>
	  * 
	  * @param HbarInquiryByBkgVO hbarInquiryByBkgVO
	  * @return List<HbarInquiryByBkgVO>
	  * @exception EventException
	  */
	 
	 /**
	  * HBar Inquiry by History 조회한다.<br>
	  * 
	  * @param HbarInquiryByHistoryVO hbarInquiryByHistoryVO
	  * @return List<HbarInquiryByHistoryVO>
	  * @exception EventException
	 */	 
	 @SuppressWarnings("unchecked")
	 public List<HbarInquiryByHistoryVO> searchHngrHisList(HbarInquiryByHistoryVO hbarInquiryByHistoryVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<HbarInquiryByHistoryVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(hbarInquiryByHistoryVO != null){
				 Map<String, String> mapVO = hbarInquiryByHistoryVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 String sTmp = "";
				 String arrTmp[] = null;
				 List<String> ltCntrTmp = new ArrayList();
				 
				 
				 // Container NO: Multi로 입력됨 -> "," 로 구분해서 list 형으로 Param/ Velparam 에 입력
				 sTmp = (String)param.get("s_cntr_no");
				 
				 if(!sTmp.equals("")){
					 arrTmp = sTmp.split(",");
					 for(int i=0;i<arrTmp.length;i++){   
						 ltCntrTmp.add(arrTmp[i]);   
					 } 
					 param.put("s_cntr_no",ltCntrTmp);
					 velParam.put("s_cntr_no",ltCntrTmp);
				 }
				 
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MnrAudDBDAOSearchHbarInquiryByHistoryRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, HbarInquiryByHistoryVO .class);
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

