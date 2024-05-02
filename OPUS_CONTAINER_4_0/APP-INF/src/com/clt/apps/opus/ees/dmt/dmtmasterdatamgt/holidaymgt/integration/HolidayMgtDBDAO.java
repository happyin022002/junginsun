/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HolidayMgtDAO.java
*@FileTitle : Holiday by Country Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.04.27 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration.InvoiceIssueCollectionMgtDBDAOAddCreditInvoiceDetailCSQL;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.basic.HolidayMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.HolidayMgtVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.Sb45RulingExceptionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * HolidayMgtDAO <br>
 * - DMTMasterDataMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SungHoon, Lee
 * @see HolidayMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class HolidayMgtDBDAO extends DBDAOSupport {

	/**
	 * 등록된 국가들의 상세 휴일정보를 조회 합니다. <br>
	 * 
	 * @param HolidayMgtVO holidayMgtVO
	 * @return List<HolidayMgtVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<HolidayMgtVO> searchHolidayList(HolidayMgtVO holidayMgtVO) throws DAOException {
		DBRowSet 				dbRowset 	= null;
		List<HolidayMgtVO> 		list 		= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();
		Map<String, String> 	mapVO		= null;

		try{
			if(holidayMgtVO != null){
				mapVO = holidayMgtVO .getColumnValues();

				param.putAll(		mapVO	);
				velParam.putAll(	mapVO	);
				
				if ("Y".equals(holidayMgtVO.getRetry())) {
					//재조회 쿼리(데이터가 존재하는 년도로 재검색)
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HolidayMgtDBDAOHolidayMgtRetryRSQL(), param, velParam);
				} 
				else {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HolidayMgtDBDAOHolidayMgtRSQL(), param, velParam);
				}
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, HolidayMgtVO .class);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * 국가별로 휴일타입을 조회 합니다. <br>
	 * 
	 * @param HolidayMgtVO holidayMgtVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchWeekendTypeByCountry(HolidayMgtVO holidayMgtVO) throws DAOException {
		DBRowSet 				dbRowset 	= null;
		String 					wkndTp 		= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			if(holidayMgtVO != null){
				Map<String, String> mapVO = holidayMgtVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HolidayMgtDBDAOSearchWeekendTypeByCountryRSQL(), param, velParam);
			if (dbRowset.next()) {
				wkndTp = dbRowset.getString(1);
			} 
			else {
				wkndTp = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return wkndTp;
	}
	
	/**
	 * 등록된 국가들의 휴일정보를 조회 합니다. <br>
	 * 
	 * @param HolidayMgtVO holidayMgtVO
	 * @return List<HolidayMgtVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<HolidayMgtVO> searchHolidayCountList(HolidayMgtVO holidayMgtVO) throws DAOException {
		DBRowSet 				dbRowset 	= null;
		List<HolidayMgtVO> 		list 		= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			if(holidayMgtVO != null){
				Map<String, String> mapVO = holidayMgtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			String svrId = "";
			String cntCd = "";
			
			if(holidayMgtVO != null) {
				svrId = holidayMgtVO.getSvrId() != null ? holidayMgtVO.getSvrId().trim() : "";
				cntCd = holidayMgtVO.getCntCd() != null ? holidayMgtVO.getCntCd().trim() : "";
			}
			
			if (svrId.length() == 0 && cntCd.length() == 0) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HolidayMgtDBDAOHolidayCountByAllRHQRSQL(), param, velParam);
			}
			else if (svrId.length() > 0 && cntCd.length() == 0) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HolidayMgtDBDAOHolidayCountByRHQRSQL(), param, velParam);
			}
			else {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HolidayMgtDBDAOHolidayCountRSQL(), param, velParam);	
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, HolidayMgtVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	 
	/**
	 * 국가들의 휴일정보를 생성 합니다. <br> 
	 * 
	 * @param List<HolidayMgtVO> holidayMgtVOs
	 * @throws DAOException
	 */
	public void addHoliday(List<HolidayMgtVO> holidayMgtVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(holidayMgtVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new HolidayMgtDBDAOHolidayMgtCSQL(), holidayMgtVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * 국가들의 휴일정보를 삭제 합니다. <br> 
	 * 
	 * @param List<HolidayMgtVO> holidayMgtVOs
	 * @throws DAOException
	 */
	public void removeHoliday(List<HolidayMgtVO> holidayMgtVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(holidayMgtVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new HolidayMgtDBDAOHolidayMgtDSQL(), holidayMgtVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * retrieve SB45 Ruling Exceptions <br> 
	 * 
	 * @param Sb45RulingExceptionVO sb45RulingExceptionVO
	 * @return List<Sb45RulingExceptionVO>
	 * @exception DAOException
	 */
//	public List<Sb45RulingExceptionVO> searchSb45RulingExceptionList(Sb45RulingExceptionVO sb45RulingExceptionVO) throws DAOException {
//		DBRowSet 				dbRowset 	= null;
//		List<Sb45RulingExceptionVO> 		list 		= null;
//		Map<String, Object> 	param 		= new HashMap<String, Object>();
//		Map<String, Object> 	velParam 	= new HashMap<String, Object>();
//		Map<String, String> 	mapVO		= null;
//
//		try{
//			if(sb45RulingExceptionVO != null){
//				mapVO = sb45RulingExceptionVO.getColumnValues();
//
//				param.putAll(		mapVO	);
//				velParam.putAll(	mapVO	);
//				
//				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HolidayMgtDBDAOSb45RulingExceptionsRSQL(), param, velParam);
//				list = (List)RowSetUtil.rowSetToVOs(dbRowset, Sb45RulingExceptionVO.class);
//			}
//			
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//	}

	/**
	 * delete SB45 Ruling Exceptions <br> 
	 *  
	 * @param List<Sb45RulingExceptionVO> sb45RulingExceptionVOs
	 * @throws DAOException
	 */
//	public void removeSb45RulingException(List<Sb45RulingExceptionVO> sb45RulingExceptionVOs) throws DAOException {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int delCnt[] = null;
//			if(sb45RulingExceptionVOs.size() > 0){
//				delCnt = sqlExe.executeBatch((ISQLTemplate)new HolidayMgtDBDAOSb45RulingExceptionsDSQL(), sb45RulingExceptionVOs, null);
//				for(int i = 0; i < delCnt.length; i++){
//					if(delCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
	 
	/**
	 * insert/update SB45 Ruling Exceptions <br> 
	 * 
	 * @param List<Sb45RulingExceptionVO> sb45RulingExceptionVOs
	 * @return Sb45RulingExceptionVO
	 * @throws DAOException
	 */
//	public Sb45RulingExceptionVO updateSb45RulingException(List<Sb45RulingExceptionVO> sb45RulingExceptionVOs) throws DAOException {
//		Sb45RulingExceptionVO vo = null;
//		try {
//			if(sb45RulingExceptionVOs.size() > 0){
//				Map<String, Object> param = new HashMap<String, Object>();
//				SQLExecuter sqlExe = new SQLExecuter("");
//				
//				for(int a = 0; a < sb45RulingExceptionVOs.size(); a++) {
//					// dup check
//					vo = searchSb45RulingExceptionDupCheck(sb45RulingExceptionVOs.get(a));
//					if(vo != null) {
//						log.debug("========================== Duplicated Data exists. ==========================");
//						break;
//					}
//					// insert or update
//				    param.putAll(sb45RulingExceptionVOs.get(a).getColumnValues());
//				    int result = sqlExe.executeUpdate((ISQLTemplate)new HolidayMgtDBDAOSb45RulingExceptionsUSQL(), param, param);
//				    if(result == Statement.EXECUTE_FAILED)
//				            throw new DAOException("Fail to updateSb45RulingException SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return vo;
//	}
	 
	/**
	 * retrieve SB45 Ruling Exceptions Dup Check<br> 
	 * 
	 * @param Sb45RulingExceptionVO sb45RulingExceptionVO
	 * @return Sb45RulingExceptionVO
	 * @exception DAOException
	 */
//	public Sb45RulingExceptionVO searchSb45RulingExceptionDupCheck(Sb45RulingExceptionVO sb45RulingExceptionVO) throws DAOException {
//		DBRowSet 				dbRowset 	= null;
//		List<Sb45RulingExceptionVO> 		list 		= null;
//		Map<String, Object> 	param 		= new HashMap<String, Object>();
//		Map<String, Object> 	velParam 	= new HashMap<String, Object>();
//		Map<String, String> 	mapVO		= null;
//
//		try{
//			if(sb45RulingExceptionVO != null){
//				mapVO = sb45RulingExceptionVO.getColumnValues();
//
//				param.putAll(		mapVO	);
//				velParam.putAll(	mapVO	);
//				
//				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HolidayMgtDBDAOSb45RulingExceptionsDupCheckRSQL(), param, velParam);
//				list = (List)RowSetUtil.rowSetToVOs(dbRowset, Sb45RulingExceptionVO.class);
//			}
//			
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//
//		// dup exists
//		if (list != null && list.size() > 0) {
//			((Sb45RulingExceptionVO)list.get(0)).setSeq(sb45RulingExceptionVO.getSeq());
//			log.debug("SIZE : " + list.size() + " :::: SEQ : " + ((Sb45RulingExceptionVO)list.get(0)).getSeq());
//			return list.get(0);
//		}
//		// dup does not exist
//		return null;
//	}
}
