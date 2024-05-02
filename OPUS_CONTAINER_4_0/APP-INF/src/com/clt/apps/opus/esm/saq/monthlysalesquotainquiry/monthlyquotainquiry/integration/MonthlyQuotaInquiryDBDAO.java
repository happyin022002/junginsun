/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : MonthlyQuotaInquiryDBDAO.java
*@FileTitle      : Container SBU 
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.basic.MonthlyQuotaInquiryBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab01VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab02VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab03HRVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab03Sub01HRVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab03Sub01VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab03VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab04VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab05VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0127Tab10VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0128Tab03VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0128Tab10VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0139Tab01VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0139Tab02VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0139Tab03Sub01VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0139Tab03VO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * MonthlyQuotaInquiryDBDAO <br>
 * - MonthlySalesQuotaInquiry system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jong-Ho Kim
 * @see MonthlyQuotaInquiryBCImpl 참조
 * @since J2EE 1.6
 */
public class MonthlyQuotaInquiryDBDAO extends DBDAOSupport {

	/**
	 * [ESM_SAQ_0139]을 [SEARCHLIST01] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0139Tab01VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0139Tab01VO> searchMonthlyQuotaInquiry0139Tab01(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0139Tab01VO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getQuarter() ; // month 계산용 변수
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; // 쿼리에서 month를 사용할 수 있도록 quarter로부터 계산 처리
				// 이후 프로세스에서의 사용을 위해 map에 입력
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경. 
				
				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				List itemlist = new ArrayList(); // 이 배열을 인덱스로 사용하여 값을  넣을 리스트 생성
				param.put("items0", items[0]); 	 // ALL 용 변수에 ALL 입력
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		 // item 갯수만큼 itemList에 공간 생성 
				}
				velParam.put("ilist", itemlist);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0139Tab01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0139Tab01VO.class); //결과 VO
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
	 * [ESM_SAQ_0139]을 [SEARCHLIST02] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0139Tab02VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0139Tab02VO> searchMonthlyQuotaInquiry0139Tab02(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0139Tab02VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getQuarter() ; 
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.

				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				
				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0139Tab02RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0139Tab02VO.class);
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
	 * [ESM_SAQ_0139]을 [SEARCHLIST03] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0139Tab03VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0139Tab03VO> searchMonthlyQuotaInquiry0139Tab03(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0139Tab03VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getQuarter() ; 
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.
				
				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				
				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0139Tab03RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0139Tab03VO.class);
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
	 * [ESM_SAQ_0139]을 [SEARCHLIST13] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0139Tab03Sub01VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0139Tab03Sub01VO> searchMonthlyQuotaInquiry0139Tab03Sub01(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0139Tab03Sub01VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getQuarter() ; 
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.
				
				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				

				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0139Tab03Sub01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0139Tab03Sub01VO.class);
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
	 * [ESM_SAQ_0126]을 [SEARCHLIST01] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab01VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0126Tab01VO> searchMonthlyQuotaInquiry0126Tab01(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0126Tab01VO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
			
		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getQuarter() ; 
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.
				
				String items[] = (quotaConditionVO.getItem()).split(":");
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				
				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
								
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0126Tab01VO.class); //결과 VO
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
	 * [ESM_SAQ_0126]을 [SEARCHLIST02] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab02VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0126Tab02VO> searchMonthlyQuotaInquiry0126Tab02(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0126Tab02VO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
			
		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getQuarter() ; 
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.
				
				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				

				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab02RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0126Tab02VO.class); //결과 VO
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
	 * [ESM_SAQ_0126]을 [SEARCHLIST03] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab03HRVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0126Tab03HRVO> searchMonthlyQuotaInquiry0126Tab03HR(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0126Tab03HRVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
			
		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getQuarter() ; 
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.
				
				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				

				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab03HRRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0126Tab03HRVO.class); //결과 VO
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
	 * [ESM_SAQ_0126]을 [SEARCHLIST13] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab03Sub01HRVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0126Tab03Sub01HRVO> searchMonthlyQuotaInquiry0126Tab03Sub01HR(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0126Tab03Sub01HRVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
			
		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getQuarter() ; 
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.
				
				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				

				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab03Sub01HRRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0126Tab03Sub01HRVO.class); //결과 VO
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
	 * [ESM_SAQ_0126]을 [SEARCHLIST04] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab04VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0126Tab04VO> searchMonthlyQuotaInquiry0126Tab04(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0126Tab04VO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
			
		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getQuarter() ; 
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.
				
				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				

				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab04RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0126Tab04VO.class); //결과 VO
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
	 * [ESM_SAQ_0126]을 [SEARCHLIST05] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab05VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0126Tab05VO> searchMonthlyQuotaInquiry0126Tab05(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0126Tab05VO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
			
		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getQuarter() ; 
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.
				
				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				

				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab05RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0126Tab05VO.class); //결과 VO
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
	 * [ESM_SAQ_0127]을 [SEARCHLIST03] 합니다.<br>
	 * 0126을 0127에서 공유하다가 실제 0126Tab03이 0126Tab03HR로 변하고 0127은 그대로 0126을 사용하는 듯.   
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab03VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0126Tab03VO> searchMonthlyQuotaInquiry0126Tab03(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0126Tab03VO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
			
		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getQuarter() ; 
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.
				
				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				

				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
								
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab03RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0126Tab03VO.class); //결과 VO
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
	 * [ESM_SAQ_0127]을 [SEARCHLIST13] 합니다.<br>
	 * 0126을 0127에서 공유하다가 실제 0126Tab03Sub01이 0126Tab03Sub01HR로 변하고 0127은 그대로 0126을 사용하는 듯.   
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab03Sub01VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0126Tab03Sub01VO> searchMonthlyQuotaInquiry0126Tab03Sub01(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0126Tab03Sub01VO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getQuarter() ; 
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.
				
				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				

				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
								
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab03Sub01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0126Tab03Sub01VO.class); //결과 VO
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
	 * [ESM_SAQ_0127]을 [SEARCHLIST10] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0127Tab10VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0127Tab10VO> searchMonthlyQuotaInquiry0127Tab10(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0127Tab10VO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
			
		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getQuarter() ; 
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.
				
				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				

				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
								
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0127Tab10RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0127Tab10VO.class); //결과 VO
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
	 * [ESM_SAQ_0128]을 [SEARCHLIST01] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab01VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0126Tab01VO> searchMonthlyQuotaInquiry0128Tab01(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0126Tab01VO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
			
		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getMonth() ; //0126 용메소드에서  Quarter값을 month에 저장해서 사용했으므로 getQuarter 대신 getMonth를 사용 
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.
				
				param.put("quarter", quarter);  //String quarter = 부분에서 설정된 quarter 값을 실제 쿼터 변수에 저장
				
				
				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
								
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0126Tab01VO.class); //결과 VO
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
	 * [ESM_SAQ_0128]을 [SEARCHLIST02] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab02VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0126Tab02VO> searchMonthlyQuotaInquiry0128Tab02(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0126Tab02VO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
			
		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getMonth() ; //0126 용메소드에서  Quarter값을 month에 저장해서 사용했으므로 getQuarter 대신 getMonth를 사용 
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.
				
				param.put("quarter", quarter);  //String quarter = 부분에서 설정된 quarter 값을 실제 쿼터 변수에 저장
				
				
				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				

				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
								
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab02RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0126Tab02VO.class); //결과 VO
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
	 * [ESM_SAQ_0128]을 [SEARCHLIST03] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0128Tab03VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0128Tab03VO> searchMonthlyQuotaInquiry0128Tab03(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0128Tab03VO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
			
		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String quarter = quotaConditionVO.getMonth() ; //0126 용메소드에서  Quarter값을 month에 저장해서 사용했으므로 getQuarter 대신 getMonth를 사용 
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.
				
				param.put("quarter", quarter);  //String quarter = 부분에서 설정된 quarter 값을 실제 쿼터 변수에 저장
				
				
				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				

				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
								
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0128Tab03RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0128Tab03VO.class); //결과 VO
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
	 * [ESM_SAQ_0128]을 [SEARCHLIST10] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0128Tab10VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiry0128Tab10VO> searchMonthlyQuotaInquiry0128Tab10(QuotaConditionVO quotaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0128Tab10VO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
			
		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				String quarter = quotaConditionVO.getMonth() ;  // 기존 DBDAO를 참고하면 month 변수에 실제로는 Quarter값을 저장해서 사용하므로 getQuarter 대신 getMonth를 사용
				int month = Integer.parseInt(quarter.substring(0,1))*3-2; 
				velParam.put("month", month); // 쿼리파일에서 값의 크기를 비교하는 조건문에 사용되기 때문에 int 로 설정하고
				param.put("month", String.valueOf(month));  // param 데이터를 사용할 때는 String 타입으로 사용해야하므로 변경.
				
				param.put("quarter", quarter); // 기존 month 값이 들어있던 quarter 변수에 quarter 값을 입력.
				
				
				String items[] = (quotaConditionVO.getItem()).split(":"); 
				// js의 comObj.GetText(code[i], 1) 를 통해 화면에서 받아온 item들을 입력할 배열 생성

				

				List itemlist = new ArrayList(); 
				param.put("items0", items[0]); 	 
				for ( int i = 0; i < items.length; i++){
					itemlist.add(items[i]);		  
				}
				velParam.put("ilist", itemlist);
								
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0128Tab10RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0128Tab10VO.class); //결과 VO
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
	 * [ESM_SAQ_0127]을 [분기를 위해 조회] 합니다.<br>
	 * 
	 * @param orgCd String
	 * @return String
	 * @throws DAOException
	 */
	public String isRhq(String orgCd) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		DBRowSet dbRowset = null; 
		String isRhq = "false";
		
		try{
			
			if(orgCd != null){
				
				param.put("orgCd", orgCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaInquiryDBDAOIsRhqRSQL(), param, velParam);
			
			while(dbRowset.next()){
				String is_rhq = dbRowset.getString("is_rhq");
				if (is_rhq.equals("O")){
					isRhq = "true";	
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isRhq;
	}
}