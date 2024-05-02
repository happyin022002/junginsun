/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : MonthlyQuotaAdjustmentInquiryDBDAO.java
*@FileTitle      : Trade Group
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.basic.MonthlyQuotaAdjustmentInquiryBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.vo.SearchMonthlyQuotaInquiry0049Tab01VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.vo.SearchMonthlyQuotaInquiry0049Tab02VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.vo.SearchMonthlyQuotaInquiry0049Tab04VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.vo.SearchMonthlyQuotaInquiry0049Tab05VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.vo.SearchMonthlyQuotaInquiryHR0049Tab03VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.vo.SearchMonthlyQuotaInquiryListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * MonthlyQuotaAdjustmentInquiryDBDAO <br>
 * - MonthlySalesQuotaAdjustmentInquiry system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Ju Sun Young
 * @see MonthlyQuotaAdjustmentInquiryBCImpl 참조
 * @since J2EE 1.6
 */
public class MonthlyQuotaAdjustmentInquiryDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ReturnVO searchMonthlyQuotaInquiry0049Tab01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0049Tab01VO> list = null;
		ReturnVO returnVO = new ReturnVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				
				String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
				List<String> item = new ArrayList();
				for(int i=0; i<items.length; i++){
					item.add(items[i]);
				}
				velParam.put("itemAr", item);
				
				mapVO.put("item", items[0]);
				mapVO.put("isRhq", "");
				mapVO.put("ofcCd", "");
				mapVO.put("rhqCd", "");
				mapVO.put("orgType", "HO");
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//3개월
				String mon = "";
				List<String> cols = new ArrayList();
				for (int j=1; j< 4; j++) {
					mon = j < 10?"0" + j:String.valueOf(j);
					cols.add(mon);
				}
				velParam.put("term",cols);			
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0049Tab01RSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0049Tab01VO .class);
				
				returnVO.addList(list);
				returnVO.setConditionVO(conditionVO);			
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @throws DAOException
	 */
	
	@SuppressWarnings("unchecked")
	public ReturnVO searchMonthlyQuotaInquiry0049Tab02(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0049Tab02VO> list = null;
		ReturnVO returnVO = new ReturnVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				
				String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
				List<String> item = new ArrayList();
				
				for(int i=0; i<items.length; i++){
					item.add(items[i]);
				}
				velParam.put("itemAr", item);
				
				mapVO.put("item", items[0]);
				mapVO.put("isRhq", "");
				mapVO.put("ofcCd", "");
				mapVO.put("rhqCd", "");
				mapVO.put("orgType", "HO");
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				
				
				//3개월
				String mon = "";
				List<String> cols = new ArrayList();
				
				for (int j=1; j< 4; j++) {
					mon = j < 10?"0" + j:String.valueOf(j);
					cols.add(mon);
				}
				velParam.put("term",cols);

			
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0049Tab02RSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0049Tab02VO .class);
				
				returnVO.addList(list);
				returnVO.setConditionVO(conditionVO);
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @throws DAOException
	 */
	
	@SuppressWarnings("unchecked")
	public ReturnVO searchMonthlyQuotaInquiryHR0049Tab03(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiryHR0049Tab03VO> list = null;
		ReturnVO returnVO = new ReturnVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				
				String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
				List<String> item = new ArrayList();
				for(int i=0; i<items.length; i++){
					item.add(items[i]);
				}
				velParam.put("itemAr", item);
				
				mapVO.put("item", items[0]);
			
				mapVO.put("rhqCd", "");
				
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//3개월
				String mon = "";
				List<String> cols = new ArrayList();
				for (int i=1; i< 4; i++) {
					mon = i < 10?"0" + i:String.valueOf(i);
					cols.add(mon);
				}
				velParam.put("term",cols);

			
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiryHR0049Tab03RSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiryHR0049Tab03VO .class);
				
				returnVO.addList(list);
				returnVO.setConditionVO(conditionVO);
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}		
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public ReturnVO searchMonthlyQuotaInquiry0049HRTab03Sub(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiryHR0049Tab03VO> list = null;
		ReturnVO returnVO = new ReturnVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				
				String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
				List<String> item = new ArrayList();
				for(int i=0; i<items.length; i++){
					item.add(items[i]);
				}
				velParam.put("itemAr", item);
				mapVO.put("item", items[0]);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//3개월
				String mon = "";
				List<String> cols = new ArrayList();
				for (int i=1; i< 4; i++) {
					mon = i < 10?"0" + i:String.valueOf(i);
					cols.add(mon);
				}
				velParam.put("term",cols);

			
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiryHR0049Tab03SubRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiryHR0049Tab03VO .class);
				
				returnVO.addList(list);
				returnVO.setConditionVO(conditionVO);
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}			
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @throws DAOException
	 */
	
	@SuppressWarnings("unchecked")
	public ReturnVO searchMonthlyQuotaInquiry0049Tab04(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0049Tab04VO> list = null;
		ReturnVO returnVO = new ReturnVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				
				String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
				List<String> item = new ArrayList();
				for(int i=0; i<items.length; i++){
					item.add(items[i]);
				}
				velParam.put("itemAr", item);
				
				mapVO.put("item", items[0]);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//3개월
				String mon = "";
				List<String> cols = new ArrayList();
				for (int i=1; i< 4; i++) {
					mon = i < 10?"0" + i:String.valueOf(i);
					cols.add(mon);
				}
				velParam.put("term",cols);

			
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0049Tab04RSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0049Tab04VO .class);
				
				returnVO.addList(list);
				returnVO.setConditionVO(conditionVO);
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}	
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public ReturnVO searchMonthlyQuotaInquiry0049Tab05(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiry0049Tab05VO> list = null;
		ReturnVO returnVO = new ReturnVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				
				String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
				List<String> item = new ArrayList();
				
				for(int j=0; j< items.length; j++){
					
					item.add(items[j]);
				}
				velParam.put("itemAr", item);
				
				mapVO.put("item", items[0]);
				mapVO.put("isRhq", "");
				mapVO.put("aqCd", "");

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//3개월
				String mon = "";
				List<String> cols = new ArrayList();
				for (int i=1; i< 4; i++) {
					mon = i < 10?"0" + i:String.valueOf(i);
					cols.add(mon);
				}
				velParam.put("term",cols);

			
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0049Tab05RSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiry0049Tab05VO .class);
				
				returnVO.addList(list);
				returnVO.setConditionVO(conditionVO);
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	
	/**
	 * ofc_cd 여부.
	 * @param String orgCd
	 * @return String
	 * @throws DAOException
	 */
	public String isRhq(String orgCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		DBRowSet dbRowset  = null;
		String isRhq = "false";
		
		try{
			
			param.put("orgCd", orgCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentInquiryDBDAOIsRhqRSQL(), param, velParam);
			while(dbRowset.next()){
				String is_rhq = dbRowset.getString("is_rhq");
				if (is_rhq.equals("O")) {
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
	 
	/**
	 * MonthlySalesQuotaAdjustmentInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaInquiryListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiry0088Tab01(QuotaConditionVO conditionVO) throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				List<String> item = new ArrayList();
				for(int i=0; i<items.length; i++){
					item.add(items[i]);
				}
				param.put("item", items[0]);
				
				//3개월
				String mon = "";
				List<String> cols = new ArrayList();
				for (int j=1; j< 4; j++) {
					mon = j < 10?"0" + j:String.valueOf(j);
					cols.add(mon);
				}
				velParam.put("term",cols);
				velParam.put("itemAr" , item);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0049Tab01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiryListVO .class);
			
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
	 * MonthlySalesQuotaAdjustmentInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaInquiryListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiry0088Tab02(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				List<String> item = new ArrayList();
				for(int i=0; i<items.length; i++){
					item.add(items[i]);
				}
				param.put("item", items[0]);
				
				//3개월
				String mon = "";
				List<String> cols = new ArrayList();
				
				for (int j=1; j< 4; j++) {
					mon = j < 10?"0" + j:String.valueOf(j);
					cols.add(mon);
				}
				velParam.put("term",cols);
				velParam.put("itemAr" , item);
				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0049Tab02RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiryListVO .class);
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
	 * MonthlySalesQuotaAdjustmentInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaInquiryListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiry0088Tab03(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅				
				for (int j=0; j<8; j++) {
					
					param.put("items"+j, (j>items.length-1 ? "" : items[j]) );
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0049Tab03RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiryListVO .class);
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
	 * MonthlySalesQuotaAdjustmentInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaInquiryListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiry0088Tab03Child(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				param.put("ctrtAqCd", conditionVO.getCtrtAqCd().equals("") ? " " : conditionVO.getCtrtAqCd());
				
				for (int j=0; j<8; j++) {
					
					param.put("items"+j, (j>items.length-1 ? "" : items[j]) );
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0049Tab03SubRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiryListVO .class);
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
	 * MonthlySalesQuotaAdjustmentInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Lane/Area Director/C.Office Tab 조회 <br>
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaInquiryListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiry0088Tab04(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				List<String> item = new ArrayList();
				for(int i=0; i<items.length; i++){
					item.add(items[i]);
				}
				param.put("item", items[0]);
				
				//3개월
				String mon = "";
				List<String> cols = new ArrayList();
				for (int i=1; i< 4; i++) {
					mon = i < 10?"0" + i:String.valueOf(i);
					cols.add(mon);
				}
				velParam.put("term"  , cols);
				velParam.put("itemAr", item);

			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0049Tab04RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiryListVO .class);
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
	 * MonthlySalesQuotaAdjustmentInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaInquiryListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiry0088Tab05(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				List<String> item = new ArrayList();
				for(int j=0; j< items.length; j++){
					
					item.add(items[j]);
				}
				param.put("item", items[0]);
				
				//3개월
				String mon = "";
				List<String> cols = new ArrayList();
				for (int i=1; i< 4; i++) {
					mon = i < 10?"0" + i:String.valueOf(i);
					cols.add(mon);
				}
				velParam.put("term"  , cols);
				velParam.put("itemAr", item);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0049Tab05RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiryListVO .class);
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
	 * MonthlySalesQuotaAdjustmentInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaInquiryListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiry0089Tab04(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInquiryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String items[] = conditionVO.getItem().split(":"); // 선택된 item text array
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				List<String> item = new ArrayList();
				for(int j=0; j< items.length; j++){
					
					item.add(items[j]);
				}
				param.put("item", items[0]);
				velParam.put("itemAr", item);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0089Tab04RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInquiryListVO .class);
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