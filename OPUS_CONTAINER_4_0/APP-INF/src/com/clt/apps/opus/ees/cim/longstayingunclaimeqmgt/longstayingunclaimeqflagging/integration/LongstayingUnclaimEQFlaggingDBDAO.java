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
=========================================================*/
package com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration.CNTRInventoryReportDBDAOsearchCntrListBkgWiseByLocRSQL;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration.CNTRInventoryReportDBDAOsearchCntrListEqWiseByLocRSQL;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration.CNTRInventoryReportDBDAOsearchRccDateListRSQL;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCntrListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.basic.LongstayingUnclaimEQFlaggingBCImpl;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingOptionVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingSummayVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingDetailVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.CntrFdayListVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.FlaggingListSmryVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.FlaggingSDaysOptionVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.LongStayUclmDetailVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.SDaysLisDetailVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.SDaysListSmryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * LongstayingUnclaimEQFlaggingDBDAO <br>
 * LongstayingUnclaimEQMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kim jong jun
 * @see LongstayingUnclaimEQFlaggingBCImpl 참조
 * @since J2EE 1.6
 */
public class LongstayingUnclaimEQFlaggingDBDAO extends DBDAOSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int PAGE_SIZE_10000  =  10000;
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
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보갯수<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int searchSDaysTotalCnt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO) throws DAOException {
		int totalCnt = 0;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(flaggingSDaysOptionVO != null){							
				Map<String, String> mapVO = flaggingSDaysOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchSDaysTotalCntRSQL(), param, velParam);
			if(dbRowset.next()) {
	    		totalCnt = dbRowset.getInt("TOTAL_CNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return totalCnt;
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
		int currentPage = flaggingSDaysOptionVO.getIPage();
		int pageRow	  = PAGE_SIZE_10000;
   	  	int startNo = pageRow * (currentPage -1) +1;
   	  	int endNo   = pageRow *  currentPage;
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
		         param.put("startno", startNo);
				 param.put("endno", endNo);
		         velParam.put("startno", startNo);
		         velParam.put("endno", endNo);
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
	 * “Total S/Days” 현황을 컨테이너별 “최초반입일시/야드” 및 “현 MVMT 및 Yard 정보”등을 포함하여 체류일수를 총갯수한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int searchSDaysListTotalDaysCnt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO) throws DAOException {
		int totalCnt = 0;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(flaggingSDaysOptionVO != null){							
				Map<String, String> mapVO = flaggingSDaysOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchSDaysListTotalDaysCntRSQL(), param, velParam);
			if(dbRowset.next()) {
	    		totalCnt = dbRowset.getInt("TOTAL_CNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return totalCnt;
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
		int currentPage = flaggingSDaysOptionVO.getIPage();
		int pageRow	  = PAGE_SIZE_10000;
   	  	int startNo = pageRow * (currentPage -1) +1;
   	  	int endNo   = pageRow *  currentPage;
   	  	
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
		        param.put("startno", startNo);
				param.put("endno", endNo);
		        velParam.put("startno", startNo);
		        velParam.put("endno", endNo);
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
			dbRowset = new SQLExecuter("CIM_OPUSBAT").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchOPInventoryForPseudoBookingRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("CIM_OPUSBAT").executeQuery((ISQLTemplate)new LongstayingUnclaimEQFlaggingDBDAOsearchOPInventoryForPseudoBookingDetailRSQL(), param, velParam);
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
}