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
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.basic.CIMCommonBCImpl;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.ComIntgCdListDataVO;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.OscarBookingSearchEdiVO;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.TypeSizeSequenceVO;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.OscarBookingSearchVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusListVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusOptionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CimTpSzDpSeqVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;


/**
 * OPUS--CNTROperatioNPerformanceMgt Business Logic Basic Command implementation<br>
 * - OPUS--CNTROperatioNPerformanceMgt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Prak Kwang Seok
 * @see CIMCommonBCImpl 참조
 * @since J2EE 1.6
 */
public class CIMCommonDBDAO extends DBDAOSupport {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOSearchCntrTPSZSequenceRSQL(), param, velParam);
				
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
		 * Booking Information의 데이타 모델에 해당되는 값을 불러온다.<br>
		 * @param  OscarBookingSearchVO oscarBookingSearchVO
		 * @return List<OscarBookingSearchVO>
		 * @throws DAOException
		 */
		public List<OscarBookingSearchVO> bookingInformationListData(OscarBookingSearchVO oscarBookingSearchVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<OscarBookingSearchVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				param.put("s_cntr_no", oscarBookingSearchVO.getSCntrNo());
				velParam.put("s_cntr_no",    oscarBookingSearchVO.getSCntrNo());
				
				param.put("s_bkg_no", oscarBookingSearchVO.getSBkgNo());
				velParam.put("s_bkg_no",    oscarBookingSearchVO.getSBkgNo());
				
				dbRowset = new SQLExecuter("").executeQuery(new CimCommonDBDAOOscarBookingInformationListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OscarBookingSearchVO.class);
					
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
		 * Vessel Information 데이타 모델에 해당되는 값을 불러온다.<br>
		 * @param  OscarBookingSearchVO oscarBookingSearchVO
		 * @return List<OscarBookingSearchVO>
		 * @throws DAOException
		 */
		public List<OscarBookingSearchVO> vesselInformationListData(OscarBookingSearchVO oscarBookingSearchVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<OscarBookingSearchVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				param.put("h_bkg_no", oscarBookingSearchVO.getHBkgNo());
				velParam.put("h_bkg_no",    oscarBookingSearchVO.getHBkgNo());					
				
				dbRowset = new SQLExecuter("").executeQuery(new CimCommonDBODAOscarVesselInformationListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OscarBookingSearchVO.class);
					
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
		 * Container Information 데이타 모델에 해당되는 값을 불러온다.<br>
		 * @param  OscarBookingSearchVO oscarBookingSearchVO
		 * @return List<OscarBookingSearchVO>
		 * @throws DAOException
		 */
		public List<OscarBookingSearchVO> containerInformationListData(OscarBookingSearchVO oscarBookingSearchVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<OscarBookingSearchVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				param.put("h_bkg_no", oscarBookingSearchVO.getHBkgNo());
				velParam.put("h_bkg_no",    oscarBookingSearchVO.getHBkgNo());					
				
				dbRowset = new SQLExecuter("").executeQuery(new CimCommonDBODAOscarContainerInformationListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OscarBookingSearchVO.class);
					
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
		 * Movement History Information 데이타 모델에 해당되는 값을 불러온다.<br>
		 * @param  SearchMovementListByContainerVO searchMovementListByContainerVO
		 * @return List<SearchMovementListByContainerVO>
		 * @throws DAOException
		 */
		public List<SearchMovementListByContainerVO> movementHistoryInformationListData(SearchMovementListByContainerVO searchMovementListByContainerVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchMovementListByContainerVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				param.put("p_cntrno", searchMovementListByContainerVO.getPCntrno());
				velParam.put("p_cntrno",    searchMovementListByContainerVO.getPCntrno());
				
				param.put("check_digit", searchMovementListByContainerVO.getCheckDigit());
				velParam.put("check_digit",    searchMovementListByContainerVO.getCheckDigit());			
				
				dbRowset = new SQLExecuter("").executeQuery(new CIMCommonDBDAOSearchMovementListByContainerRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMovementListByContainerVO.class);
					
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
		 * Movement History Information 데이타 모델에 해당되는 값을 불러온다.<br>
		 * @param  OscarBookingSearchVO oscarBookingSearchVO
		 * @return List<OscarBookingSearchVO>
		 * @throws DAOException
		 */
		public List<OscarBookingSearchVO> movementEdiErrInformationListData(OscarBookingSearchVO oscarBookingSearchVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<OscarBookingSearchVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				param.put("p_cntrno", oscarBookingSearchVO.getPCntrno());
				velParam.put("p_cntrno",    oscarBookingSearchVO.getPCntrno());
				
				param.put("check_digit", oscarBookingSearchVO.getCheckDigit());
				velParam.put("check_digit",    oscarBookingSearchVO.getCheckDigit());			
				
				param.put("s_event_date1", oscarBookingSearchVO.getSEventDate1());
				velParam.put("s_event_date1",    oscarBookingSearchVO.getSEventDate1());		
				
				param.put("s_event_date2", oscarBookingSearchVO.getSEventDate2());
				velParam.put("s_event_date2",    oscarBookingSearchVO.getSEventDate2());		
				
				dbRowset = new SQLExecuter("").executeQuery(new CIMCommonDBDAOSearchMovementEdiErrListByContainerRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OscarBookingSearchVO.class);
					
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
		 * Movement History Information 데이타 모델에 해당되는 값을 불러온다.<br>
		 * @param  SearchEDIMovementListVO searchEDIMovementListVO
		 * @return List<SearchEDIMovementListVO>
		 * @throws DAOException
		 */
		public List<SearchEDIMovementListVO> ediMessageHistoryInformationListData(SearchEDIMovementListVO searchEDIMovementListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchEDIMovementListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				param.put("p_cntrno", searchEDIMovementListVO.getPCntrno());
				velParam.put("p_cntrno",    searchEDIMovementListVO.getPCntrno());
				
				param.put("check_digit", searchEDIMovementListVO.getCheckDigit());
				velParam.put("check_digit",    searchEDIMovementListVO.getCheckDigit());			
				
				dbRowset = new SQLExecuter("").executeQuery(new CIMCommonDBDAOSearchEDIMessageHistoryListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEDIMovementListVO.class);
					
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
		 * Movement History Information 데이타 모델에 해당되는 값을 불러온다.<br>
		 * @param  CntrStatusOptionVO cntrStatusOptionVO
		 * @return List<CntrStatusListVO>
		 * @throws DAOException
		 */
		public List<CntrStatusListVO> cntrStatusInquiryListData(CntrStatusOptionVO cntrStatusOptionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CntrStatusListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				param.put("p_cntr_no", cntrStatusOptionVO.getPCntrno());
				velParam.put("p_cntr_no",    cntrStatusOptionVO.getPCntrno());
				
				
				dbRowset = new SQLExecuter("").executeQuery(new CIMCommonDBDAOSearchCntrStatusInquiryListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrStatusListVO.class);
					
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
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOSearchCntrTypeSizeListRSQL(), param, velParam);
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
				
				if(arrTrade != null) {
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
		 * COM_INTG_CD를 조회합니다.<br>
		 * @return List<ComIntgCdListDataVO>
		 * @exception EventException
		 */	
		@SuppressWarnings("unchecked")
		public List<ComIntgCdListDataVO> searchComIntgCdListData()throws DAOException {
			DBRowSet dbRowset = null;
			List<ComIntgCdListDataVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOSearchcomIntgCdListDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComIntgCdListDataVO .class);			
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}

		
		/**
		 * COM_INTG_CD를 조회합니다.<br>
		 * @param String   intgCdId
		 * @param String   intgCdVal
		 * @return List<ComIntgCdListDataVO>
		 * @exception EventException
		 */	
		@SuppressWarnings("unchecked")
		public List<ComIntgCdListDataVO> searchComIntgCdListData(String intgCdId, String intgCdVal)throws DAOException {
			DBRowSet dbRowset = null;
			List<ComIntgCdListDataVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (intgCdId != null) {
					param.put("intg_cd_id", intgCdId);
					param.put("intg_cd_val", intgCdVal);
					velParam.put("intg_cd_val", intgCdVal);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOSearchcomIntgCdListDataRSQL(), param, param);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComIntgCdListDataVO .class);			
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		
		
		/**
		 * COM_INTG_CD를 조회합니다.<br>
		 * @return List<ComIntgCdListDataVO>
		 * @exception EventException
		 */	
		@SuppressWarnings("unchecked")
		public List<ComIntgCdListDataVO> searchComAreaGrpIdListData()throws DAOException {
			DBRowSet dbRowset = null;
			List<ComIntgCdListDataVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOSearchcomAreaGrpIdListDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComIntgCdListDataVO .class);			
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}


		/**
		 * Container Type Size Division을 조회한다.<br>
		 * 
		 * @return List<CimTpSzDpSeqVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<CimTpSzDpSeqVO> searchCntrTypeSizeDivListData() throws DAOException {
			DBRowSet dbRowset = null;
			List<CimTpSzDpSeqVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOCimTpSzDpSeqVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CimTpSzDpSeqVO .class);
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		 
			
		/**
		 * Container Type Size Division을 저장합니다.<br>
		 * 
		 * @param List<CimTpSzDpSeqVO> cimTpSzDpSeqVOs
		 * @exception DAOException
		 * @exception Exception  
		 */
		public void addCntrTypeSizeDivData(List<CimTpSzDpSeqVO> cimTpSzDpSeqVOs) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if(cimTpSzDpSeqVOs.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new CIMCommonDBDAOAddCntrTypeSizeDivCSQL(), cimTpSzDpSeqVOs,null);
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		/**
		 * Container Type Size Division을 수정합니다.<br>
		 * 
		 * @param List<CimTpSzDpSeqVO> cimTpSzDpSeqVOs 
		 * @exception DAOException
		 * @exception Exception  
		 */
		public void modifyCntrTypeSizeDivData(List<CimTpSzDpSeqVO> cimTpSzDpSeqVOs) throws DAOException,Exception {
			int updCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(cimTpSzDpSeqVOs.size() > 0){
					updCnt = sqlExe.executeBatch((ISQLTemplate)new CIMCommonDBDAOModifyCntrTypeSizeDivUSQL(), cimTpSzDpSeqVOs,null);
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 * Container Type Size Division을 삭제합니다.<br>
		 * 
		 * @param List<CimTpSzDpSeqVO> cimTpSzDpSeqVOs
		 * @exception DAOException
		 * @exception Exception 
		 */
		public void removeCntrTypeSizeDivData(List<CimTpSzDpSeqVO> cimTpSzDpSeqVOs) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int delCnt[] = null;
				if(cimTpSzDpSeqVOs.size() > 0){
					delCnt = sqlExe.executeBatch((ISQLTemplate)new CIMCommonDBDAORemoveCntrTypeSizeDivDSQL(), cimTpSzDpSeqVOs,null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void addCtmMovementData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOAddCtmMovementDataCSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void modifyCtmMovementforSplitNoData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOModifyCtmMovementforSplitNoDataUSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}		
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void modifyCtmMovementData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOModifyCtmMovementDataUSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void modifyMstContainerData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOModifyMstContainerDataUSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void modifyBkgContainerData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOModifyBkgContainerDataUSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
					
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void modifyBkgContainerEtcData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOModifyBkgContainerEtcDataUSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
					
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void modifyCtmBkgContainerData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOModifyCtmBkgContainerDataUSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
					
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void modifyCtmMvmtEdiMsgData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOModifyCtmMvmtEdiMsgDataUSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void addCtmMvmtEdiRsltData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					//mvmt_edi_msg_seq
					oscarBookingSearchVOs.get(0).setMvmtEdiMsgSeq(Integer.toString(Integer.parseInt(oscarBookingSearchVOs.get(0).getMvmtEdiMsgSeq()) + 1));
					
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOAddCtmMvmtEdiRsltDataCSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void addBkgContainerData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOModifyBkgContainerDataUSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void addBkgContainerEtcData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOModifyBkgContainerEtcDataUSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
					
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void addCtmBkgContainerData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOModifyCtmBkgContainerDataUSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
					
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void addCtmMvmtEdiMsgData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOAddCtmMvmtEdiMsgDataCSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 * 
		 * @param OscarBookingSearchVO oscarBookingSearchVO
		 * @throws DAOException
		 */
		public void modifyBookingCycChangeData(OscarBookingSearchVO oscarBookingSearchVO) throws DAOException {			
			try {
				Map<String, Object> velParams = null;
				Map<String, Object> param = null;
				Map<String, String> mapVO = null;
				
				velParams = new HashMap<String, Object>();
				param = new HashMap<String, Object>();				
				
				mapVO = oscarBookingSearchVO.getColumnValues();
				param.putAll(oscarBookingSearchVO.getColumnValues());
				velParams.putAll(mapVO);
				
				new SQLExecuter("").executeUpdate((ISQLTemplate)new CIMCommonDBDAOModifyBookingCycDataUSQL(), param, velParams);
				
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void modifyResultAsDelForMvmtEdiMsgData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOAddCtmEdiRsltRmkDataCSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
					
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void modifyCtmMovementEdiMsgData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOModifyCtmMovementEdiMsgUSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public CusCtmMovementVO getCntrMvmtInfo(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
			DBRowSet dbRowset = null;
			CusCtmMovementVO cusVo = new CusCtmMovementVO();
			List<CusCtmMovementVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	
			try{			
				String strMvmtEdiMsgAreaCd = cusCtmMovementVO.getMvmtEdiMsgAreaCd();
				String strMvmtEdiMsgSeq = cusCtmMovementVO.getMvmtEdiMsgSeq();
				String strMvmtEdiMsgYrmondy = cusCtmMovementVO.getMvmtEdiMsgYrmondy();
				String strMvmtEdiTpCd = cusCtmMovementVO.getMvmtEdiTpCd();
				String strMvmtEdiMsgTpId = cusCtmMovementVO.getMvmtEdiMsgTpId();
				
				param.put("mvmt_edi_msg_area_cd", strMvmtEdiMsgAreaCd);
				param.put("mvmt_edi_msg_seq",    strMvmtEdiMsgSeq);
				param.put("mvmt_edi_msg_yrmondy",    strMvmtEdiMsgYrmondy);
				param.put("mvmt_edi_tp_cd",    strMvmtEdiTpCd);
				param.put("mvmt_edi_msg_tp_id",    strMvmtEdiMsgTpId);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CIMCommonDBDAOCntrMvmtInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusCtmMovementVO.class);
				
				if (dbRowset == null || list.size() < 1)
					return null;
				else
					cusVo =(CusCtmMovementVO) (list.get(0));				
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return cusVo;
		}
		
		
		/**
		 * 값을 불러온다.<br>
		 * @param  OscarBookingSearchEdiVO oscarBookingSearchEdiVO
		 * @return List<OscarBookingSearchEdiVO>
		 * @throws DAOException
		 */ 
		public List<OscarBookingSearchEdiVO> ediErrorInformationListData(OscarBookingSearchEdiVO oscarBookingSearchEdiVO) throws DAOException {
			int currentPage = oscarBookingSearchEdiVO.getIPage();
			int pageRow	  = Integer.parseInt(oscarBookingSearchEdiVO.getPagerows());
	   	  	int startNo = pageRow * (currentPage -1) +1; //10000 * (1-1)+1
	   	  	int endNo   = pageRow *  currentPage;
	   	  	
			DBRowSet dbRowset = null;
			List<OscarBookingSearchEdiVO> list = null;			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				
				if(oscarBookingSearchEdiVO != null){
					oscarBookingSearchEdiVO.setStartNo(Integer.toString(startNo));
					oscarBookingSearchEdiVO.setEndNo(Integer.toString(endNo));
					Map<String, String> mapVO = oscarBookingSearchEdiVO.getColumnValues();
	
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CimCommonDBDAOOscarEdiErrorInformationListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OscarBookingSearchEdiVO.class);
					
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
		 * 값을 불러온다.<br>
		 * @param  OscarBookingSearchEdiVO oscarBookingSearchEdiVO
		 * @return List<OscarBookingSearchEdiVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public int searchEdiErrorTotalCnt(OscarBookingSearchEdiVO oscarBookingSearchEdiVO) throws DAOException {
			int totalCnt = 0;
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				
				if(oscarBookingSearchEdiVO != null){
					Map<String, String> mapVO = oscarBookingSearchEdiVO.getColumnValues();
	
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CimCommonDBDAOOscarEdiErrorTotalCntRSQL(), param, velParam);
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
		 * 
		 * @param oscarBookingSearchVOs
		 * @throws DAOException
		 */
		public void addCtmMvmtCorrData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int addCnt[] = null;
				if (oscarBookingSearchVOs.size() > 0) {
					addCnt = sqlExe.executeBatch((ISQLTemplate) new CIMCommonDBDAOAddCtmMovementCorrDataCSQL(), oscarBookingSearchVOs, null);
					for (int i = 0; i < addCnt.length; i++) {
						if (addCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
	 
		
		/**
		 * 
		 * @param List<OscarBookingSearchVO> oscarBookingSearchVOs
		 * @exception DAOException
		 * @exception Exception 
		 */
		public void removeCtmMovementData(List<OscarBookingSearchVO> oscarBookingSearchVOs) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int delCnt[] = null;
				if(oscarBookingSearchVOs.size() > 0){
					delCnt = sqlExe.executeBatch((ISQLTemplate)new CIMCommonDBDAORemoveCtmMovementDSQL(), oscarBookingSearchVOs,null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
	 
}
