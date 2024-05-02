/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CIMCommonDBDAO.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.04.24 박광석
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2011.10.26 신자영 [CHM-201113916-01] [CIM] Load factor by cy의 sub-trade 검색 기능 추가
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.vo.SearchDayListVO;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.vo.TypeSizeSequenceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS-CNTROperatioNPerformanceMgt Business Logic Basic Command implementation<br>
 * - ALPS-CNTROperatioNPerformanceMgt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Prak Kwang Seok
 * @see CIMCommonBCImpl 참조
 * @since J2EE 1.6
 */
public class CIMCommonDBDAO extends DBDAOSupport {

		/**
		 * TPSZSequence의 List를 조회 합니다. <br>
		 * 
		 * @return List<TypeSizeSequenceVO>
		 * @throws DAOException
		 * @throws SQLException
		 * @throws Exception
		 */
		 @SuppressWarnings("unchecked")
		public List<TypeSizeSequenceVO> searchTPSZSequenceList() throws DAOException {
			DBRowSet dbRowset = null;
			List<TypeSizeSequenceVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	
			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOTypeSizeSequenceVORSQL(), param, velParam);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, TypeSizeSequenceVO .class);
				
				if(list.size() == 0){
					throw new DAOException(new ErrorHandler("CIM21003",new String[]{}).getMessage());
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
		 * Location을 check  합니다. <br>
		 * 
		 * @param locLevel
		 * @param locCD
		 * @return String
		 * @throws DAOException
		 * @throws SQLException
		 * @throws Exception
		 
		public String checkLocationYardr(String locLevel ,String locCD) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String check = "OK";
			try{
				param.put("locLevel", locLevel);
				param.put("locCD", locCD);
				velParam.put("locLevel", locLevel);
				velParam.put("locCD", locCD);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOCIMCommonDBCheckLocationMdmYardRSQL(), param, velParam);
				if(!dbRowset.next()){
					check = "NO";
				}
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return check;
		}	
		*/
		
		/**
		 * VVD를 check  합니다. <br>
		 * 
		 * @param vvd
		 * @return String
		 * @throws DAOException
		 * @throws SQLException
		 * @throws Exception
		 */
		public String checkVVD(String vvd) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String check = "OK";
			try{
				param.put("vvd", vvd);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOcheckVVDRSQL(), param, velParam);
				if(!dbRowset.next()){
					check = "NO";
				}
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return check;
		}			
		
		/**
		 * Location을 check  합니다. <br>
		 * 
		 * @param locLevel
		 * @param locCD
		 * @return String
		 * @throws DAOException
		 * @throws SQLException
		 * @throws Exception
		 */
		public String checkLocation(String locLevel ,String locCD) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String check = "OK";
			try{
				param.put("locLevel", locLevel);
				param.put("locCD", locCD);
				velParam.put("locLevel", locLevel);
				velParam.put("locCD", locCD);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOCIMCommonDBCheckLocationMdmLocationRSQL(), param, velParam);
				if(!dbRowset.next()){
					check = "NO";
				}
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return check;
		}
		
		/**
		 * Location을 check  합니다. <br>
		 * 
		 * @param locLevel
		 * @param locCD
		 * @return String
		 * @throws DAOException
		 * @throws SQLException
		 * @throws Exception
		 
		public String checkLocationEqOrzCht(String locLevel ,String locCD) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String check = "OK";
			try{
				param.put("locLevel", locLevel);
				param.put("locCD", locCD);
				velParam.put("locLevel", locLevel);
				velParam.put("locCD", locCD);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOCIMCommonDBCheckLocationMdmEqOrzChtRSQL(), param, velParam);
				if(!dbRowset.next()){
					check = "NO";
				}
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return check;
		}	
		*/
		
		
		/**
		 * Port List를 조회 합니다. <br>
		 * 
		 * @return String[] 
		 * @throws DAOException
		 * @throws SQLException
		 * @throws Exception
		 */
		public String[] searchPortList() throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String[] arrPort = null;
			try{
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOsearchPortListRSQL(), param, velParam);
				int i = 0;
				while(dbRowset.next()){
					if(i == 0){
						
						arrPort = new String[dbRowset.getRowCount()];
					}
					arrPort[i] = dbRowset.getString(1);
					i++;
				}
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return arrPort;
		}	
		
		/**
		 * trade에 해당하는 Lane List를 조회 합니다. <br>
		 * 
		 * @param trade
		 * @return String[] 
		 * @throws DAOException
		 * @throws SQLException
		 * @throws Exception
		 */
		public String[] searchLaneList(String trade) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String[] arrPort = null;
			try{
				param.put("trade", trade);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOsearchLaneListRSQL(), param, velParam);
				int i = 0;
				while(dbRowset.next()){
					if(i == 0){
						
						arrPort = new String[dbRowset.getRowCount()];
					}
					arrPort[i] = dbRowset.getString(1);
					i++;
				}
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return arrPort;
		}	
		
		/**
		 * trade에 해당하는 Lane List를 조회 합니다. <br>
		 * 
		 * @param trade
		 * @return String[] 
		 * @throws DAOException
		 * @throws SQLException
		 * @throws Exception
		 */
		public String[] searchSubTradeList(String trade) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String[] arrPort = null;
			try{
				param.put("trade", trade);
				velParam.put("trade", trade);
				log.debug("\n!!!!!!!!!!!!!!!!!!!!!!!!trade"+ trade);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOsearchSubTradeListRSQL(), param, velParam);
				int i = 0;
				while(dbRowset.next()){
					if(i == 0){
						
						arrPort = new String[dbRowset.getRowCount()];
					}
					arrPort[i] = dbRowset.getString(1);
					i++;
				}
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return arrPort;
		}
		/**
		 * 입력받은 lane Code를 가지고 Validation Check.<br>
		 * 
		 * @param lane
		 * @return String
		 * @throws DAOException
		 * @throws SQLException
		 * @throws Exception
		 */
		public String checkLane(String lane) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String check = "OK";
			try{
				param.put("lane", lane);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOcheckLaneRSQL(), param, velParam);
				if(!dbRowset.next()){
					check = "NO";
				}
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return check;
		}			
		
		/**
		 * Rcc List를 조회 합니다. <br>
		 * 
		 * @return String[] 
		 * @throws DAOException
		 * @throws SQLException
		 * @throws Exception
		 */
		public String[] searchRCCList() throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String[] arrRcc = null;
			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOsearchRCCListRSQL(), param, velParam);
				int i = 0;
				while(dbRowset.next()){
					if(i == 0){
						
						arrRcc = new String[dbRowset.getRowCount()];
					}
					arrRcc[i] = dbRowset.getString(1);
					i++;
				}
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return arrRcc;
		}			
		
		/**
		 * PortTurnTime화면에 있는 COMBO List를 조회 합니다. <br>
		 * 
		 * @return String[] 
		 * @throws DAOException
		 * @throws SQLException
		 * @throws Exception
		 */
		public String[] searchCntrTypeSizeList() throws DAOException {
			DBRowSet dbRowset = null;
			String[] arrTpsz = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAODAOsearchCntrTypeSizeListRSQL(), param, velParam);
				int i = 0;
				while(dbRowset.next()){
					if(i == 0){
						
						arrTpsz = new String[dbRowset.getRowCount()];
					}
					arrTpsz[i] = dbRowset.getString(1);
					i++;
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return arrTpsz;
		}	
		
		
		/**
		 * Trade List를 조회합니다.<br>
		 * 
		 * @return String[] 
		 * @throws DAOException
		 * @throws SQLException
		 * @throws Exception
		 */
		public String[] searchTradeList() throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String[] arrTrade = null;
			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOsearchTradeListRSQL(), param, velParam);
				int i = 0;
				while(dbRowset.next()){
					if(i == 0){
						
						arrTrade = new String[dbRowset.getRowCount()];
					}
					arrTrade[i] = dbRowset.getString(1);
					i++;
				}
				
				if(arrTrade != null){
					if(arrTrade.length == 0){
						throw new DAOException(new ErrorHandler("CIM21015",new String[]{}).getUserMessage());
					}
				}	
				
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return arrTrade;
		}	

		/**
		 * TPSZSequence의 List를 조회 합니다. <br>
		 * 
		 * @return List<SearchDayListVO>
		 * @throws DAOException
		 * @throws SQLException
		 * @throws Exception
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchDayListVO> searchDayList() throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchDayListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	
			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOSearchDayListVORSQL(), param, velParam);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDayListVO .class);
				
				if(list.size() == 0){
					throw new DAOException(new ErrorHandler("CIM21003",new String[]{}).getMessage());
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
}
