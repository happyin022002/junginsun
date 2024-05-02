/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAO.java
*@FileTitle : Container Staying Days (Summary)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.09 김종준
* 1.0 Creation
* =========================================================
* 2010.09.07 남궁진호 [CHM-201005814-01] 소스품질 결함 조치.
*            List<VO >공백제거 
* 2012.09.19 신자영 [CHM-201220003-01] L/S U/C CREATION - COR DRAFT 기능 개발
* 
* 2014.04.07 김창영 [HJSBIZ_CR_45] 장비 과부족현황 Mailing 기능개발
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration.EQMatchBackNLoadFactorMgtDBDAOaddLocationPOPDataCSQL;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration.EQMatchBackNLoadFactorMgtDBDAOclearFormatMBByCOABKGDataDSQL;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration.EQMatchBackNLoadFactorMgtDBDAOmodifyLocationPOPDataUSQL;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByLocationVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration.CNTRInventoryReportDBDAOsearchCntrListBkgWiseByLocRSQL;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration.CNTRInventoryReportDBDAOsearchCntrListEqWiseByLocRSQL;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration.CNTRInventoryReportDBDAOsearchRccDateListRSQL;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCntrListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.basic.LongstayingUnclaimEQFlaggingBCImpl;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.EQBalanceReportInputListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.MailingServiceSettingListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingOptionVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingSummayVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingDetailVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.FlaggingListSmryVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.FlaggingSDaysOptionVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.LongStayUclmDetailVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.SDaysLisDetailVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.SDaysListSmryVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.CntrFdayListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.CimEqSplsDfctEmlVO;
import com.hanjin.syscommon.common.table.CimEqSplsDfctStsVO;


/**
 * ALPS LongstayingUnclaimEQFlaggingDBDAO <br>
 * - ALPS-LongstayingUnclaimEQMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kim jong jun
 * @see LongstayingUnclaimEQFlaggingBCImpl 참조
 * @since J2EE 1.6
 */
public class LongstayingUnclaimEQFlaggingDBDAO extends DBDAOSupport {
	/**
	 * Full/ MTY 컨테이너의 장기체류 현황을 지역별,EQ TP&SZ별로 체류 기간조회를 위해 RCC의 Local 시간을 구함.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO 
	 * @return List<SDaysListSmryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SDaysListSmryVO> searchRccDateList(FlaggingSDaysOptionVO  flaggingSDaysOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SDaysListSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(flaggingSDaysOptionVO  != null){
				Map<String, String> mapVO = flaggingSDaysOptionVO  .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchRccDateListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SDaysListSmryVO.class);
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
	 * Full/ MTY 컨테이너의 장기체류 현황을 지역별,EQ TP&SZ별로 체류 기간을 구분하여 조회합니다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO 
	 * @return List<SDaysListSmryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SDaysListSmryVO> searchSDaysListSmry(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SDaysListSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(flaggingSDaysOptionVO  != null){
				Map<String, String> mapVO = flaggingSDaysOptionVO  .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListSmryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SDaysListSmryVO.class);
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
	 * Full/ MTY 컨테이너의 장기체류 현황을 지역별,MVMT Status 별, EQ TP&SZ별로 체류 기간을 구분하여 조회합니다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO 
	 * @return List<SDaysListSmryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SDaysListSmryVO> searchSDaysListByMvmt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SDaysListSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(flaggingSDaysOptionVO  != null){
				Map<String, String> mapVO = flaggingSDaysOptionVO  .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListByMvmtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SDaysListSmryVO.class);
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
	 * 조회시점에 체류하고 있는 컨테이너의 과거 MVMT History를 조회하여, 지역별, EQ TP&SZ로  MVMT Status 를 분류하여 체류   일수를 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO 
	 * @return List<SDaysListSmryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SDaysListSmryVO> searchSDaysListTotalDays(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SDaysListSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(flaggingSDaysOptionVO  != null){
				Map<String, String> mapVO = flaggingSDaysOptionVO  .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListTotalDaysRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SDaysListSmryVO.class);
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
	 * Full/ MTY 장기체화 장비의 BKG 및 Movement 정보등을 컨테이너 번호별로 일괄적으로 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO 
	 * @return List<SDaysLisDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SDaysLisDetailVO> searchSDaysListDetail(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SDaysLisDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(flaggingSDaysOptionVO  != null){
				Map<String, String> mapVO = flaggingSDaysOptionVO  .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SDaysLisDetailVO.class);
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
	 * 컨테이너 번호별로 Total S/Days의 체류일수를 CNTR MVMT Status별 체류일수를 집계하여 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO 
	 * @return List<SDaysLisDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SDaysLisDetailVO> searchSDaysListTotalDaysByMvmt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SDaysLisDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(flaggingSDaysOptionVO  != null){
				Map<String, String> mapVO = flaggingSDaysOptionVO  .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListTotalDaysByMvmtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SDaysLisDetailVO.class);
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
	 * “Total S/Days” 현황을 컨테이너별 “최초반입일시/야드” 및 “현 MVMT 및 Yard 정보”등을 포함하여 체류일수를 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO 
	 * @return List<SDaysLisDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SDaysLisDetailVO> searchSDaysListTotalDaysDetail(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SDaysLisDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(flaggingSDaysOptionVO  != null){
				Map<String, String> mapVO = flaggingSDaysOptionVO  .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListTotalDaysDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SDaysLisDetailVO.class); 
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
	 * 장기체화장비(L/Staying) 및 Unclaim 요건 장비에 대한 제반 정보를 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO 
	 * @return List<LongStayUclmDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<LongStayUclmDetailVO> searchFlaggingTargetList(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<LongStayUclmDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(flaggingSDaysOptionVO  != null){
				Map<String, String> mapVO = flaggingSDaysOptionVO  .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchFlaggingTargetListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LongStayUclmDetailVO.class);
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
	 * 장기체화장비(L/Staying) 및 Unclaim 요건 장비에 대한 COR Draft를 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<LongStayUclmDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<LongStayUclmDetailVO> searchCorDraft(FlaggingSDaysOptionVO  flaggingSDaysOptionVO )  throws DAOException {
		
		DBRowSet dbRowset = null;
		List<LongStayUclmDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(flaggingSDaysOptionVO  != null){
				Map<String, String> mapVO = flaggingSDaysOptionVO  .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				log.debug("**************************" + flaggingSDaysOptionVO.getInBkgNo());
				
				if(flaggingSDaysOptionVO.getInBkgNo()!= null ){
					 List<String> inBkgNos = new ArrayList(); 
					 String[] arrayBkgNo =  flaggingSDaysOptionVO.getInBkgNo().split(",");
					 for(int i = 0; i < arrayBkgNo.length; i ++){      
						 inBkgNos.add(arrayBkgNo[i]); 	      
					 } 						 		
					 param.put("inBkgNos",inBkgNos);     	  	                    
					 velParam.put("inBkgNos",inBkgNos);   
				}
							
				if(flaggingSDaysOptionVO.getInCntrNo()!= null ){
					 List<String> inCntrNos = new ArrayList(); 
					 String[] arrayCntrNo =  flaggingSDaysOptionVO.getInCntrNo().split(",");
					 for(int i = 0; i < arrayCntrNo.length; i ++){      
						 inCntrNos.add(arrayCntrNo[i]); 	      
					 } 						 		
					 param.put("inCntrNos",inCntrNos);     	  	                    
					 velParam.put("inCntrNos",inCntrNos);   
				}
		    }
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchCorDraftRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LongStayUclmDetailVO.class);
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
	 * RCV/DEL list를 조회한다.<br>
	 * 
	 * @param String pCode 
	 * @return List<LongStayUclmDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<LongStayUclmDetailVO> searchRcvDelCodeData(String pCode)  throws DAOException {
		
		DBRowSet dbRowset = null;
		List<LongStayUclmDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			param.put("code_flg"      , pCode);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchRcvDelCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LongStayUclmDetailVO.class);
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
	 * 장기체화장비(L/Staying) 및 Unclaim 장비 Flag 와 해소 방안을 등록한다.<br>
	 * 
	 * @param List<LongStayUclmDetailVO> longStayUclmDetailVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addFlagging(List<LongStayUclmDetailVO> longStayUclmDetailVOs) throws DAOException,Exception 
	{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insertCnt[] = null;
			if(longStayUclmDetailVOs.size() > 0){
				insertCnt = sqlExe.executeBatch((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOaddFlaggingCSQL(), longStayUclmDetailVOs,null);
				for(int i = 0; i < insertCnt.length; i++){
					if(insertCnt[i]== Statement.EXECUTE_FAILED)
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
	 * L/S & U/C Creation화면에서 Flag된 L/S 및 U/C 장비의 현황을 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO 
	 * @return List<FlaggingListSmryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FlaggingListSmryVO> searchFlaggingStatusListSmry(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<FlaggingListSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(flaggingSDaysOptionVO  != null){
				StringTokenizer  st = new StringTokenizer(flaggingSDaysOptionVO.getTotCntrTpszCd(),"|");
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd1  (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd2  (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd3  (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd4  (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd5  (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd6  (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd7  (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd8  (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd9  (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd10 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd11 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd12 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd13 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd14 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd15 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd16 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd17 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd18 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd19 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd20 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd21 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd22 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd23 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd24 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd25 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd26 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd27 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd28 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd29 (st.nextToken());
				if ( st.hasMoreTokens() ) flaggingSDaysOptionVO.setCntrTpszCd30 (st.nextToken());
				
				
				Map<String, String> mapVO = flaggingSDaysOptionVO  .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchFlaggingStatusListSmryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FlaggingListSmryVO.class); 
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
	 * Full/ MTY 컨테이너의 장기체류 현황을 지역별,EQ TP&SZ별로 체류 기간조회를 위해 RCC의 Local 시간을 구함.<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvtCntrListVO> searchRccDateList(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvtCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(invtOptionVO  != null){
				Map<String, String> mapVO = invtOptionVO  .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchRccDateListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvtCntrListVO.class);
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
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보를 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvtCntrListVO> searchCntrListEqWiseByLoc(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvtCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(invtOptionVO != null){
				if ( invtOptionVO.getCntrTpszCd().equals("") ) {
					if ( invtOptionVO.getD2PayldFlg().equals("Y") ) {
						invtOptionVO.setCntrTpszCd("D2");
					}
				}		
				
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchCntrListEqWiseByLocRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvtCntrListVO.class);
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
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보를 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvtCntrListVO> searchCntrListBkgWiseByLoc(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvtCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(invtOptionVO != null){
				if ( invtOptionVO.getCntrTpszCd().equals("") ) {
					if ( invtOptionVO.getD2PayldFlg().equals("Y") ) {
						invtOptionVO.setCntrTpszCd("D2");
					}			
					if ( !invtOptionVO.getRfTpCdC().equals("") 
							|| !invtOptionVO.getRfTpCdH().equals("") 
							|| !invtOptionVO.getRfCntr().equals("") 
							|| !invtOptionVO.getRdCgoFlg().equals("") 
					) {
						invtOptionVO.setCntrTpszCd("R2,R5");
					}			
				}					
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CNTRInventoryReportDBDAOsearchCntrListBkgWiseByLocRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvtCntrListVO.class);
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
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보를 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrFdayListVO> searchCntrFdayList(InvtOptionVO invtOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrFdayListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(invtOptionVO != null){
				if ( invtOptionVO.getCntrTpszCd().equals("") ) {
					if ( invtOptionVO.getD2PayldFlg().equals("Y") ) {
						invtOptionVO.setCntrTpszCd("D2");
					}			
					if ( !invtOptionVO.getRfTpCdC().equals("") 
							|| !invtOptionVO.getRfTpCdH().equals("") 
							|| !invtOptionVO.getRfCntr().equals("") 
							|| !invtOptionVO.getRdCgoFlg().equals("") 
					) {
						invtOptionVO.setCntrTpszCd("R2,R5");
					}			
				}					
				Map<String, String> mapVO = invtOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchCntrFdayListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrFdayListVO.class);
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
	 * OP Inventory for Pseudo Booking.<br>
	 * 
	 * @param OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO
	 * @return List<OPInventoryForPseudoBookingSummayVO>
	 * @throws DAOException
	 */

	@SuppressWarnings("unchecked")
	public List<OPInventoryForPseudoBookingSummayVO> searchOPInventoryForPseudoBookingList(OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<OPInventoryForPseudoBookingSummayVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(oPInventoryForPseudoBookingOptionVO  != null){
				Map<String, String> mapVO = oPInventoryForPseudoBookingOptionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchOPInventoryForPseudoBookingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OPInventoryForPseudoBookingSummayVO.class);
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
	 * OP Inventory for Pseudo Booking.<br>
	 * 
	 * @param OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO
	 * @return List<OPInventoryForPseudoBookingSummayVO>
	 * @throws DAOException
	 */

	@SuppressWarnings("unchecked")
	public List<OPInventoryForPseudoBookingDetailVO> searchOPInventoryForPseudoBookingDetailList(OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<OPInventoryForPseudoBookingDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(oPInventoryForPseudoBookingOptionVO  != null){
				Map<String, String> mapVO = oPInventoryForPseudoBookingOptionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchOPInventoryForPseudoBookingDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OPInventoryForPseudoBookingDetailVO.class);
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
	 * EES_CIM_0060 : Retrieve<br>
	 * EQ Balance Report Input.<br>
	 * 
	 * @param String rhqCd
	 * @param String periodWeek
	 * @param String scontiCd
	 * @param String lccCd
	 * @param String eccCd
	 * @return List<EQBalanceReportInputListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EQBalanceReportInputListVO> mainSearchEQBalanceReportInputList(String rhqCd, String periodWeek, String scontiCd, String lccCd, String eccCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<EQBalanceReportInputListVO> list = null;
		
		String lastPeriodWeek = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("period_week", periodWeek);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOlastWeekRSQL(), param, velParam);
			while(dbRowset.next()){
				lastPeriodWeek = dbRowset.getString("last_period_week");
		    }
			
			mapVO.put("rhq_cd", rhqCd);
			mapVO.put("sconti_cd", scontiCd);
			mapVO.put("lcc_cd", lccCd);
			mapVO.put("ecc_cd", eccCd);
			mapVO.put("last_period_week", lastPeriodWeek);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOEQBalanceReportInputListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EQBalanceReportInputListVO.class);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * EES_CIM_0060 : Retrieve<br>
	 * EQ Balance Report Input.<br>
	 * 
	 * @param String rhqCd
	 * @param String fmWeek
	 * @param String toWeek
	 * @param String scontiCd
	 * @param String lccCd
	 * @param String eccCd
	 * @return List<EQBalanceReportInputListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EQBalanceReportInputListVO> mainSearchEQBalanceReportInquiryList(String rhqCd, String fmWeek, String toWeek, String scontiCd, String lccCd, String eccCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<EQBalanceReportInputListVO> list = null;
		
		String lastPeriodWeek = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("rhq_cd", rhqCd);
			mapVO.put("sconti_cd", scontiCd);
			mapVO.put("fm_week", fmWeek);
			mapVO.put("to_week", toWeek);
			mapVO.put("lcc_cd", lccCd);
			mapVO.put("ecc_cd", eccCd);
			mapVO.put("last_period_week", lastPeriodWeek);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOEQBalanceReportInquiryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EQBalanceReportInputListVO.class);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * COA_OFC_LVL의 OFC_CD에 해당되는 값을 불러온다.<br>
	 * RHQ combo의 값세팅<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchLclHqOfcCd() throws DAOException {
		DBRowSet dbRowset = null;
		//String lclHqOfcCd = "";
		StringBuffer lclHqOfcCd = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOLclHqOfcCdRSQL(), param, velParam);
			while(dbRowset.next()){
				if(!dbRowset.isFirst()) {
					//lclHqOfcCd = lclHqOfcCd + "^";
					lclHqOfcCd.append("^"); 
				}
				//lclHqOfcCd = lclHqOfcCd + dbRowset.getString("rhq_ofc_cd");
				lclHqOfcCd.append(dbRowset.getString("rhq_ofc_cd")); 
		    }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return lclHqOfcCd.toString();
	}
	
	/**
	 * MDM_ORGANIZATION의 본사에 해당하는 OFC_CD값을 불러온다.<br>
	 * RHQ 활성화 조건<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchGlblhqOfcCd() throws DAOException {
		DBRowSet dbRowset = null;
		//String glblhqOfcCd = "";
		StringBuffer glblhqOfcCd = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOGlblHqOfcCdRSQL(), param, velParam);
			while(dbRowset.next()){
				if(!dbRowset.isFirst()) {
					//glblhqOfcCd = glblhqOfcCd + "^";
					glblhqOfcCd.append("^"); 
				}
				//glblhqOfcCd = glblhqOfcCd + dbRowset.getString("ofc_cd");
				glblhqOfcCd.append(dbRowset.getString("ofc_cd")); 
		    }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return glblhqOfcCd.toString();
	}
	
	/**
	 * 로긴 OFC_CD의 본부코드, RCC 조회조건.<br>
	 * RHQ 비활성화 조건<br>
	 * 
	 * @param String ofcCd
	 * @param String pageType
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchHdQtrByOfcCd(String ofcCd, String pageType) throws DAOException {
		DBRowSet dbRowset = null;
		//String arHdQtrOfcCd = "";
		StringBuffer arHdQtrOfcCd = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOSrchCondByOfcCdRSQL(), param, velParam);
			while(dbRowset.next()){
				if(!dbRowset.isFirst()) {
					//arHdQtrOfcCd = arHdQtrOfcCd + "^";
					arHdQtrOfcCd.append("^"); 
				}
				//arHdQtrOfcCd = arHdQtrOfcCd + dbRowset.getString("ar_hd_qtr_ofc_cd");
				arHdQtrOfcCd.append(dbRowset.getString("ar_hd_qtr_ofc_cd")); 
		    }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arHdQtrOfcCd.toString();
	}
	
	/**
	 * EQR_WK_PRD의 현재일자에 대응하는 주차(W.PLN_YR||W.PLN_WK)를 불러온다.<br>
	 * Period 값 세팅<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchNowWeek() throws DAOException {
		DBRowSet dbRowset = null;
		String nowWeek = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAONowWeekRSQL(), param, velParam);
			while(dbRowset.next()){
				nowWeek = dbRowset.getString("now_week");
		    }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return nowWeek;
	}
	
	/**
	 * EQR_WK_PRD의 현재일자의 -7일에 대응하는 주차(W.PLN_YR||W.PLN_WK)를 불러온다.<br>
	 * Period 값 세팅<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchLastWeek() throws DAOException {
		DBRowSet dbRowset = null;
		String lastWeek = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOBeforeOneWeekRSQL(), param, velParam);
			while(dbRowset.next()){
				lastWeek = dbRowset.getString("last_week");
		    }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return lastWeek;
	}
	
	/**
	 * Sub-Conti combo에 세팅할 값을 불러온다.<br>
	 * Sub-Conti 값 세팅<br>
	 * 
	 * @param String rhqCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchSubContiCd(String rhqCd) throws DAOException {
		DBRowSet dbRowset = null;
		//String subContiCd = "";
		StringBuffer subContiCd = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rhq_cd", rhqCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOSubContiCdRSQL(), param, velParam);
			while(dbRowset.next()){
				if(!dbRowset.isFirst()) {
					//subContiCd = subContiCd + "^";
					subContiCd.append("^"); 
				}
				//subContiCd = subContiCd + dbRowset.getString("SCONTI_CD") + "|" + dbRowset.getString("SCONTI_NM");
				subContiCd.append(dbRowset.getString("SCONTI_CD") + "|" + dbRowset.getString("SCONTI_NM"));
		    }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return subContiCd.toString();
	}
	
	/**
	 * LCC combo에 세팅할 값을 불러온다.<br>
	 * LCC 값 세팅<br>
	 * 
	 * @param String scontiCd
	 * @param String rhqCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchLccCd(String scontiCd, String rhqCd) throws DAOException {
		DBRowSet dbRowset = null;
		//String lccCd = "";
		StringBuffer lccCd = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sconti_cd", scontiCd);
			mapVO.put("rhq_cd", rhqCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOLccCdRSQL(), param, velParam);
			while(dbRowset.next()){
				if(!dbRowset.isFirst()) {
					//lccCd = lccCd + "^";
					lccCd.append("^"); 
				}
				//lccCd = lccCd + dbRowset.getString("LCC_CD");
				lccCd.append(dbRowset.getString("LCC_CD")); 
		    }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return lccCd.toString();
	}
	
	/**
	 * ECC combo에 세팅할 값을 불러온다.<br>
	 * ECC 값 세팅<br>
	 * 
	 * @param String scontiCd
	 * @param String lccCd
	 * @param String rhqCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchEccCd(String scontiCd, String lccCd, String rhqCd) throws DAOException {
		DBRowSet dbRowset = null;
		//String eccCd = "";
		StringBuffer eccCd = new StringBuffer();
		//query parameter
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sconti_cd", scontiCd);
			mapVO.put("lcc_cd", lccCd);
			mapVO.put("rhq_cd", rhqCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOEccCdRSQL(), param, velParam);
			while(dbRowset.next()){
				if(!dbRowset.isFirst()) {
					//eccCd = eccCd + "^";
					eccCd.append("^"); 
				}
				//eccCd = eccCd + dbRowset.getString("ECC_CD");
				eccCd.append(dbRowset.getString("ECC_CD")); 
		    }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eccCd.toString();
	}
	
	/**
	 * EES_CIM_0062 PreSearch before Retrieve<br>
	 * Mailing Service Setting.<br>
	 * 
	 * @param String usrId
	 * @return int cnt
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int cntOfCimEqSplsDfctEmlByUsrId(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("usr_id", usrId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOCntOfCimEqSplsDfctEmlByUsrIdRSQL(), param, velParam);
			while(dbRowset.next()){
				cnt = dbRowset.getInt("CNT");
		    }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		
		return cnt;
	}
	
	/**
	 * EES_CIM_0060 : Retrieve<br>
	 * EQ Balance Report Input.<br>
	 * 
	 * @return List<MailingServiceSettingListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MailingServiceSettingListVO> mainSearchMailingServiceSettingListFromMdm() throws DAOException {
		DBRowSet dbRowset = null;
		List<MailingServiceSettingListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOMailingServiceSettingListFromMdmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MailingServiceSettingListVO.class);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * EES_CIM_0060 : Retrieve<br>
	 * EQ Balance Report Input.<br>
	 * 
	 * @param String usrId
	 * @return List<MailingServiceSettingListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MailingServiceSettingListVO> mainSearchMailingServiceSettingListByUnion(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<MailingServiceSettingListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("usr_id", usrId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOMailingServiceSettingListByUnionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MailingServiceSettingListVO.class);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * EES_CIM_0062 : Delete<br>
	 * Mailing Service Setting.<br>
	 * 
	 * @param String usrId
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void delMailingServiceSetting(String usrId) throws DAOException {
		//query parameter				
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter			
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;				 		
		
		try {		 
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("usr_id", usrId);
			
			param.putAll(mapVO); 	  
			velParam.putAll(mapVO);    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOMailingServiceSettingDSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)    
				throw new DAOException("Fail to Delete for Mailing Service Setting"); 
		} catch (SQLException se) {	 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){	 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	/**
	 * EES_CIM_0062 : Insert<br>
	 * @param List<CimEqSplsDfctEmlVO> cimEqSplsDfctEmlVOs
	 * @exception DAOException
	 */					
	public void addMailingServiceSetting(List<CimEqSplsDfctEmlVO> cimEqSplsDfctEmlVOs) throws DAOException {
		try { 	
			SQLExecuter sqlExe = new SQLExecuter("");  
			int insCnt[] = null;  
			if(cimEqSplsDfctEmlVOs.size() > 0){        
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOMailingServiceSettingCSQL(), cimEqSplsDfctEmlVOs,null);
				
				for(int i = 0; i < insCnt.length; i++){  
					if(insCnt[i]== Statement.EXECUTE_FAILED)     
						throw new DAOException("Fail to insert No"+ i + " SQL"); 
				}			  	       
			}		
		} catch (SQLException se) {	
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	/**
	 * EES_CIM_0060 : before Save<br>
	 * EQ Balance Report Input.<br>
	 * 
	 * @param CimEqSplsDfctStsVO cimEqSplsDfctStsVO
	 * @return List<CimEqSplsDfctStsVO> list
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CimEqSplsDfctStsVO> searchEqSplsDfctSts(CimEqSplsDfctStsVO cimEqSplsDfctStsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CimEqSplsDfctStsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(cimEqSplsDfctStsVO  != null){
				Map<String, String> mapVO = cimEqSplsDfctStsVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOSearchEqSplsDfctStsRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CimEqSplsDfctStsVO.class);
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
	 * EES_CIM_0060 : Add<br>
	 * EQ Balance Report Input.<br>
	 * 
	 * @param List<CimEqSplsDfctStsVO> cimEqSplsDfctStsVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addEqSplsDfctSts(List<CimEqSplsDfctStsVO> cimEqSplsDfctStsVOs) throws DAOException {
		try { 	
			SQLExecuter sqlExe = new SQLExecuter("");  
			int insCnt[] = null;  
			if(cimEqSplsDfctStsVOs.size() > 0){        
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOAddEqSplsDfctStsCSQL(), cimEqSplsDfctStsVOs,null);
				
				for(int i = 0; i < insCnt.length; i++){  
					if(insCnt[i]== Statement.EXECUTE_FAILED)     
						throw new DAOException("Fail to insert No"+ i + " SQL"); 
				}			  	       
			}		
		} catch (SQLException se) {	
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EES_CIM_0060 : Modify<br>
	 * EQ Balance Report Input.<br>
	 * 
	 * @param List<CimEqSplsDfctStsVO> cimEqSplsDfctStsVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void mdfyEqSplsDfctSts(List<CimEqSplsDfctStsVO> cimEqSplsDfctStsVOs) throws DAOException {
		try { 	
			SQLExecuter sqlExe = new SQLExecuter("");  
			int updCnt[] = null;  
			if(cimEqSplsDfctStsVOs.size() > 0){        
				updCnt = sqlExe.executeBatch((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOMdfyEqSplsDfctStsUSQL(), cimEqSplsDfctStsVOs,null);
				
				for(int i = 0; i < updCnt.length; i++){  
					if(updCnt[i]== Statement.EXECUTE_FAILED)     
						throw new DAOException("Fail to update No"+ i + " SQL"); 
				}			  	       
			}		
		} catch (SQLException se) {	
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EES_CIM_0060 : Delete<br>
	 * EQ Balance Report Input.<br>
	 * 
	 * @param List<CimEqSplsDfctStsVO> cimEqSplsDfctStsVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void delEqSplsDfctSts(List<CimEqSplsDfctStsVO> cimEqSplsDfctStsVOs) throws DAOException {
		try { 	
			SQLExecuter sqlExe = new SQLExecuter("");  
			int delCnt[] = null;  
			if(cimEqSplsDfctStsVOs.size() > 0){        
				delCnt = sqlExe.executeBatch((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAODelEqSplsDfctStsDSQL(), cimEqSplsDfctStsVOs,null);
				
				for(int i = 0; i < delCnt.length; i++){  
					if(delCnt[i]== Statement.EXECUTE_FAILED)     
						throw new DAOException("Fail to delete No"+ i + " SQL"); 
				}			  	       
			}		
		} catch (SQLException se) {	
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
}