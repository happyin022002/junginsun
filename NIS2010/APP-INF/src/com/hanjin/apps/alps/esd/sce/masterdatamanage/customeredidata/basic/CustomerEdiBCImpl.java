/*========================================================= 
*Copyright(c) 2006 CyberLogitec
*@FileName : CustomerEdiBCImpl.java
*@FileTitle : Customer EDI Data 관리 및 Control
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-26
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.basic;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0062Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0073Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0090Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration.CustomerEdiDBDAO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.CustomerEdiDBDAOOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.CustomerInqChoiceVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.GetMyPerformanceSelectVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCargoTrackingDataOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchComboPerformanceVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCsInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustStsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomTpIdVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerDataVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInqueryVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiActivityInquiryDataOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiActivityInquiryDataVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiStatusDataVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiSummaryReportOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEstimationListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMissingListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMyCustomerVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMyPerformanceVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchPerCsInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchPerRepPupModiVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchStsListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchVesselSkdOptionsVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ENIS-SCEM Business Logic Command Interface<br>
 * - ENIS-SCEM에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yongcheonshin
 * @see EdiSendEventResponse 참조
 * @since J2EE 1.4
 */
public class CustomerEdiBCImpl extends BasicCommandSupport implements CustomerEdiBC{

//  Database Access Object
    private transient CustomerEdiDBDAO dbDao = null;
    
    /**
     * Constructor
     */
    public CustomerEdiBCImpl(){
        dbDao = new CustomerEdiDBDAO();
    }
    
    /**
     * EDI Customer Data Search<br>
     * EsdSce0032 <br>
     * 
     * @param CustomerEdiDBDAOOptionsVO cusEdiOpt
     * @return List<SearchCustomerDataVO> 
     * @exception EventException
     */
    public List<SearchCustomerDataVO> searchCustomerData(CustomerEdiDBDAOOptionsVO cusEdiOpt)  throws EventException {
    
    log.debug("2:searchCustomerData 함수 진입");
		try {
			return dbDao.searchCustomerData(cusEdiOpt);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
     * EDI Customer Data status Search<br>
     * EsdSce0035 ?? ???? ??? ???? <br>
     * 
     * @param CustomerEdiDBDAOOptionsVO cusEdiOpt
     * @return List<SearchEdiStatusDataVO> 
     * @exception EventException
     */
      public List<SearchEdiStatusDataVO> searchEdiStatusData(CustomerEdiDBDAOOptionsVO cusEdiOpt)  throws EventException {
    	
        log.debug("2:searchEdiStatusData 함수 진입");
		try {
			return dbDao.searchEdiStatusData(cusEdiOpt);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }   
 
    
    /**
     * Customer Edi Sending history Search<br>
     * EsdSce0037 ?? ???? ??? ???? <br>
     * @param Event e
     * @return EventResponse 
     * @exception EventException
     */
//    public EventResponse searchEdiSendingHistory(Event e) throws EventException{
//        EsdSce0037Event event =(EsdSce0037Event)e;
//        DBRowSet rowSet = null;
//        try{
//            rowSet = dbDao.searchEdiSendHistoryData(event.getParameterMap());  
//            return new EsdSce0037EventResponse(rowSet);
//        } catch (DAOException de) {
//            log.error("err "+de.toString(),de);
//            throw new EventException(de.getMessage());
//        }
//    }
    
    
    
    /**
     * EDI Customer 관련 data Search<br>
     * EsdSce0062 ?? ???? ??? ???? <br>
     * 
     * @param CustomerInqChoiceVO custInq
     * @return List<SearchCustomerInqueryVO> 
     * @exception EventException
     */
    public List<SearchCustomerInqueryVO> searchCustomerInquery(CustomerInqChoiceVO custInq) throws EventException{
    	//DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
        //int cnt = 0;
		try {
            return dbDao.searchCustomerInquery(custInq);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
     * EDI Customer 관련 data Search<br>
     * EsdSce0062 ?? ???? ??? ???? <br>
     * 
     * @param CustomerInqChoiceVO custInq
     * @return EventResponse 
     * @exception EventException
     */
    public EventResponse searchCustomercnt(CustomerInqChoiceVO custInq) throws EventException{
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            int cnt = dbDao.searchCustomercnt(custInq);
            
            Map<String, String> m = new HashMap<String, String>();
            m.put("cust_cnt", String.valueOf(cnt));
            eventResponse.setETCData(m);
            return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * EDI Customer 관련 data save<br>
     * EsdSce0062 ?? ???? ??? ???? <br>
     * 
     * @param Event e
     * @return EventResponse 
     * @exception EventException
     */
    public EventResponse updateCustomerInquery(Event e) throws EventException{
        EsdSce0062Event event =(EsdSce0062Event)e;
        try{
        	
        	//my cust 저장 
        	dbDao.updateCustomerInquery(event.getCustChoice());
        	
        	return	null;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    
    /**
     * customer tp id가 2개 이상이 었을 경우<br>
     * EsdSce0062 ?? ???? ??? ???? <br>
     * 
     * @param SearchEDIPerformanceOptionsVO schEpOpts
     * @return List<SearchCustomTpIdVO> 
     * @exception EventException
     */
      public List<SearchCustomTpIdVO> searchCustomTpId(SearchEDIPerformanceOptionsVO schEpOpts)  throws EventException {
        log.debug("2:searchCustomTpId is set");
		try {
			return dbDao.searchCustomTpId(schEpOpts);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
     * EDI 운송 관련 data Search<br>
     * EsdSce0035 ?? ???? ??? ???? <br>
     * 
     * @param Event e
     * @return EventResponse 
     * @exception EventException
     */
//    public EventResponse searchEdiTransportationData(Event e) throws EventException{
//        EsdSce0035Event event =(EsdSce0035Event)e;
//        DBRowSet rowSet = null;
//        try{
//            rowSet = dbDao.searchEdiTransportationData(event.getParameterMap());  
//            return new EsdSce0035EventResponse(rowSet);
//        } catch (DAOException de) {
//            log.error("err "+de.toString(),de);
//            throw new EventException(de.getMessage());
//        }
//    }
    
    /**
     * Cargo Tracking EDI Save/Send - Individual Data 추출
     * @param SearchCargoTrackingDataOptionsVO schCtdOpts
     * @return EventResponse
     * @throws EventException
     */
   
    public EventResponse searchCargoTrackingData(SearchCargoTrackingDataOptionsVO schCtdOpts) throws EventException{
    	
        DBRowSet rowSet     =null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
        DBRowSet descRowSet = null;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
	            rowSet     = dbDao.searchCargoTrackingData(schCtdOpts);
	            descRowSet = dbDao.searchEdiStsDesc(schCtdOpts);
				/*
				 *RowSet 에 공통 데이터를 ETC_DATA 로 추출하여 만들어 주는 과정
				 **/ 
				ResultSetMetaData rsmd = descRowSet.getMetaData();
				int cint= rsmd.getColumnCount();
				Map<String,String> etcMap = new HashMap<String,String>();
	            
				while (descRowSet.next()) { 
					for (int j = 0 ; j < cint; j++) {
						String columns = rsmd.getColumnName(j+1).toLowerCase();
						Object values  = descRowSet.getObject(j +1);
						log.debug("Column No    :" + descRowSet.findColumn(columns));
						log.debug("Colunm Name  :" + columns);
						log.debug("Column Value :" + values);
						if(values != null)
						    etcMap.put(columns, values.toString());
						else
							etcMap.put(columns,"");
					}
					break;
				}
				eventResponse.setETCData(etcMap); // ETC 데이터를 맵으로 세팅
				descRowSet.beforeFirst();//초기값을 돌린다(중요함) 
			 
				eventResponse.setRsVo(rowSet);
				return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }catch(Exception ex){
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage());
        }
    }
    /**
     * Cargo Tracking EDI Save/Send - Individual Data update
     * @param e
     * @return EventResponse
     * @throws EventException
     */
//    public EventResponse updateCageTrackingSaveSend(Event e) throws EventException{
////    	EsdSce0061Event event =(EsdSce0061Event)e;
////        try{
//          //  dbDao.updateCageTrackingSaveSend(event.getParameterMap()); 
//            return new EsdSce0061EventResponse("");
////        } catch (DAOException de) {
////            log.error("err "+de.toString(),de);
////            throw new EventException(de.getMessage());
////        }
//    }
//    
    /**
     * EDI Search Activity Inquiry Data 추출
     * @param SearchEdiActivityInquiryDataOptionsVO schEAIDOpts
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchEdiActivityInquiryData(SearchEdiActivityInquiryDataOptionsVO schEAIDOpts)  throws EventException {
        log.debug("SearchEdiActivityInquiryDataOptionsVO is set");
		try {
			 List<SearchEdiActivityInquiryDataVO> list= dbDao.searchEdiActivityInquiryData(schEAIDOpts);
			 GeneralEventResponse eventResponse = new GeneralEventResponse();
			 eventResponse.setRsVoList(list);
			 return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}//try
    }
    
    
    /**
     * Edi Summary Report 리스트 조회
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchEdiSummaryReport(SearchEdiSummaryReportOptionsVO schSROptsVO) throws EventException {
        DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//        int cnt = 0;   
        try {
        	//cnt    = dbDao.searchEdiSummaryReportCnt(schSROptsVO);
        	rowSet = dbDao.searchEdiSummaryReport(schSROptsVO);
        	/*Test Of Paging*/
        	//cnt = 1000;
          // rowSet.setMaxRows(cnt);
            GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
//        } catch (SQLException de) {
//            log.error("err "+de.toString(),de);
//            throw new EventException(de.getMessage());
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }catch(Exception ex){
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage());
        }
    }   
    
    /**
     * Edi Detail Report - Mvmt 리스트 조회
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchDetailMvmtReport(SearchEdiSummaryReportOptionsVO schSROptsVO) throws EventException {
        DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//        int cnt = 0;   
        try {

        	//cnt    = dbDao.searchDetailMvmtReportCnt(schSROptsVO);
            rowSet = dbDao.searchDetailMvmtReport(schSROptsVO);
            /*TEST Code
            cnt =  1000;
            */
         //   rowSet.setMaxRows(cnt);
            GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
//        } catch (SQLException de) {
//            log.error("err "+de.toString(),de);
//            throw new EventException(de.getMessage());
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }catch(Exception ex){
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage());
        }
    } 
    /**
     * Edi Detail Report - Other 리스트 조회
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchDetailOtherReport(SearchEdiSummaryReportOptionsVO schSROptsVO) throws EventException {
        DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
        int cnt = 0;   
        try {

        	cnt    = dbDao.searchDetailOtherReportCnt(schSROptsVO);  
        	rowSet = dbDao.searchDetailOtherReport(schSROptsVO); 
            rowSet.setMaxRows(cnt);
            GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
        } catch (SQLException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }catch(Exception ex){
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage());
        }
    }  
    
    /**
     * EDI Customer Information 조회
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return List<SearchCsInfoVO>
     * @throws EventException
     */
    public List<SearchCsInfoVO> searchCsInfo(SearchEdiSummaryReportOptionsVO schSROptsVO) throws EventException{
    	try{
    	     return dbDao.searchCsInfo(schSROptsVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
     * EDI Customer TP ID Information 조회
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return EventResponse
     * @throws EventException
     */
//    public EventResponse searchCsTpIdInfo(Event e) throws EventException{
//    	EsdSce0035Event event =(EsdSce0035Event)e;
//        HashMap map = null;
//        int rowCnt = 1;
//        
//        try{
//        	//rowCnt = dbDao.searchCsTpIdInfoCnt(event.getParameterMap());     
//       		map = dbDao.searchCsTpIdInfo(event.getParameterMap());   
// 
//       		return new EsdSce0035EventResponse(map,rowCnt);
//        } catch (DAOException de) {
//            log.error("err "+de.toString(),de);
//            throw new EventException(de.getMessage());
//        }
//    }
    /**
     * EDI Document Data Search<br>
     * EsdSce0035 ?? ???? ??? ???? <br>
     * 
     * @param Event e
     * @return EventResponse 
     * @exception EventException
     */
//    public EventResponse searchEdiDocumentationData(Event e) throws EventException{
//        EsdSce0035Event event =(EsdSce0035Event)e;
//        DBRowSet rowSet = null;
//        try{
//        	
//            rowSet = dbDao.searchEdiDocumentationData(event.getParameterMap());  
//            return new EsdSce0035EventResponse(rowSet);
//        } catch (DAOException de) {
//            log.error("err "+de.toString(),de);
//            throw new EventException(de.getMessage());
//        }
//    }
    
    /**
     * Actual data cop detail에 update
     * 
     * @param Event e
     * @return EventResponse  
     * @exception EventException
     */
//    public EventResponse actualCopDetail(EsdSce0035Event event) throws EventException{ 
//        String resultCd = "";
//        try{
//            resultCd = dbDao.actualCopDetail(event.getParameterMap());  
//            log.debug("\n actual result cd : " + resultCd);
//            return new EsdSce0035EventResponse(resultCd);
//        } catch (EventException de) {
//            log.error("err "+de.toString(),de);
//            throw new EventException(de.getMessage());
//        }
//    }
    
    /**
	 * 해당 기간의 VVD List를 조회 한다.
	 * 
	 * @param SearchVesselSkdOptionsVO schVSlVO
	 * @return EventResponse
	 * @exception EventException
	 */
    
    public EventResponse searchVvdList(SearchVesselSkdOptionsVO schVSlVO) throws EventException{
        DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
        
        try {
        	/*Actually there is no parameter which takes iPage, so we cross out this method in DAO*/ 
        	//cnt    = dbDao.searchVesselSkdCnt(schVSlVO); 
        	//rowSet.setMaxRows(cnt);
        	rowSet = dbDao.searchVesselSkd(schVSlVO);
            GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }catch(Exception ex){
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage());
        }
    	
    }
	
	 /**
	 * EDI Customer Status 조회
	 * 
	 * @param SearchEDIPerformanceOptionsVO schEpOpts
	 * @return List<SearchStsListVO>
	 * @exception EventException
	 */
      public List<SearchStsListVO> searchStsList(SearchEDIPerformanceOptionsVO schEpOpts)  throws EventException {
    	
        log.debug("2:searchStsList is entered");
		try {
			return dbDao.searchStsList(schEpOpts);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    } 
	
    /**
     * Edi Performance Report Missing 리스트 조회
     * @param SearchEDIPerformanceOptionsVO schEPOpts
     * @return EventResponse
     * @throws EventException
	 */
    public EventResponse searchEDIPerformance(SearchEDIPerformanceOptionsVO schEPOpts)  throws EventException {
    	DBRowSet rowSet = null;
        log.debug("EsdSce0072:searchEDIPerformance 함수 진입");
    		try {
    			 rowSet = dbDao.searchEDIPerformanceReport(schEPOpts);
    			 GeneralEventResponse eventResponse = new GeneralEventResponse();
    			 eventResponse.setRsVo(rowSet);
    			return eventResponse;
    		} catch (DAOException ex) {
    			throw new EventException(ex.getMessage(),ex);
    		} catch (Exception ex) {
    			throw new EventException(ex.getMessage(),ex);
    		}
        }	
	
    /**
     * Edi Total Performance Report on-time-performance 리스트 조회
     * @param SearchEDIPerformanceOptionsVO schEPOpts
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse searchEDITotalPerformance(SearchEDIPerformanceOptionsVO schEPOpts) throws EventException{
		DBRowSet rowSet = null;
        log.debug("##EsdSce0072 - searchEDITotalPerformance - BCimpl ");
		try {
			 rowSet = dbDao.searchEDITotalPerformance(schEPOpts);
			 GeneralEventResponse eventResponse = new GeneralEventResponse();
			 eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }
	
	/**
     * Edi Total Performance Report Combo 리스트 조회
     * @param SearchEDIPerformanceOptionsVO custOpts
     * @return List<SearchComboPerformanceVO>
     * @throws EventException
     */
	public List<SearchComboPerformanceVO> searchComboPerformance(SearchEDIPerformanceOptionsVO custOpts) throws EventException{
        log.debug("ESDSCE0072 - searchComboPerformance 함수 진입");
		try {
			return dbDao.searchComboPerformance(custOpts);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }
	/**
     * Edi CustSts 조회
     * @param SearchEDIPerformanceOptionsVO custOpts
     * @return List<SearchCustStsVO>
     * @throws EventException
     */
    public List<SearchCustStsVO> searchCustSts(SearchEDIPerformanceOptionsVO custOpts)  throws EventException {
        log.debug("ESDSCE0072 - searchCustSts");
    		try {
    			return dbDao.searchCustSts(custOpts);
    		} catch (DAOException ex) {
    			throw new EventException(ex.getMessage(),ex);
    		} catch (Exception ex) {
    			throw new EventException(ex.getMessage(),ex);
    		}
        }	
	
    /**
     * EDI Customer Information 조회
     * @param SearchEDIPerformanceOptionsVO custOpts
     * @return List<SearchPerCsInfoVO>
     * @throws EventException
     */
    
    public List<SearchPerCsInfoVO> searchPerCsInfo(SearchEDIPerformanceOptionsVO custOpts)  throws EventException {
        log.debug("ESDSCE0072 - searchPerCsInfo");
    		try {
    			return dbDao.searchPerCsInfo(custOpts);
    		} catch (DAOException ex) {
    			throw new EventException(ex.getMessage(),ex);
    		} catch (Exception ex) {
    			throw new EventException(ex.getMessage(),ex);
    		}
        }
    
    /**
     * EDI Customer TP ID Information 조회
     * @param SearchEDIPerformanceOptionsVO custOpts
     * @return EventResponse
     * @throws EventException
     */
     public EventResponse searchPerCsTpIdInfo(SearchEDIPerformanceOptionsVO custOpts) throws EventException{
    	DBRowSet rowSet=null;
    	int cnt = 0;
    	 try {
         	   cnt    = dbDao.searchCsTpIdInfoCnt(custOpts);
               rowSet = dbDao.searchPerCsTpIdInfo(custOpts);
               GeneralEventResponse eventResponse = new GeneralEventResponse();
 			   eventResponse.setRsVo(rowSet);
 			    			
 			   Map<String,String> etcMap = new HashMap<String,String>();
		       etcMap.put("tp_id_cnt", String.valueOf(cnt));
 			   eventResponse.setETCData(etcMap); // ETC 데이터를 맵으로 세팅
 			   return eventResponse;     
         } catch (DAOException de) {
             log.error("err "+de.toString(),de);
             throw new EventException(de.getMessage());
         }catch(Exception ex){
             log.error("err "+ex.toString(),ex);
             throw new EventException(ex.getMessage());
         }  	
    }
    /**
     * EDI Customer TP ID Information 조회
     * @param SearchEDIPerformanceOptionsVO custOpts
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchPerCsTpIdInfo1(SearchEDIPerformanceOptionsVO custOpts) throws EventException{
    	DBRowSet rowSet=null;
    	int cnt = 0;
    	 try {
         	   cnt    = dbDao.searchCsTpIdInfoCnt(custOpts);
         	   log.debug("cnt==="+cnt);
               rowSet = dbDao.searchPerCsTpIdInfo(custOpts);
               GeneralEventResponse eventResponse = new GeneralEventResponse();
 			   //eventResponse.setRsVo(rowSet);
 			    			
 			   Map<String,String> etcMap = new HashMap<String,String>();
 			   etcMap.put("tp_id_cnt", String.valueOf(cnt));
 			   if (rowSet.next()) {
 				   etcMap.put("tp_id", rowSet.getString("tp_id"));
 				   etcMap.put("cs_grp_id", rowSet.getString("cs_grp_id"));
 				   etcMap.put("grp_nm", rowSet.getString("cs_desc"));
 				   etcMap.put("edi_sts", rowSet.getString("edi_sts"));
		       }
 			   eventResponse.setETCData(etcMap); // ETC 데이터를 맵으로 세팅
			   
 			   return eventResponse;     
         } catch (DAOException de) {
             log.error("err "+de.toString(),de);
             throw new EventException(de.getMessage());
         }catch(Exception ex){
             log.error("err "+ex.toString(),ex);
             throw new EventException(ex.getMessage());
         }  	
    }
    /**
     * Missing List popup 조회
     * @param SearchMissingListVO searchMissingListVo
     * @return List<SearchMissingListVO>
     * @throws EventException
     */
    public List<SearchMissingListVO> searchMissingList(SearchMissingListVO searchMissingListVo) throws EventException{
    	//EsdSce0074Event event =(EsdSce0074Event)e;
        //DBRowSet rowSet = null;
        //int rowCnt = 0;
        List<SearchMissingListVO> list = null;  
        try{
        	//rowCnt = dbDao.searchMissingCnt(event.getParameterMap());
            //rowSet = dbDao.searchMissingList(event.getParameterMap(),event.getIPage());  
        	list = dbDao.searchMissingList(searchMissingListVo); 
            return list;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage()); 
        }
    }
    
    /**
     * Missing List popup 조회
     * @param SearchMissingListVO searchOnTimeListVo
     * @return List<SearchMissingListVO>
     * @throws EventException
     */
   	public List<SearchMissingListVO> searchOnTimeList(SearchMissingListVO searchOnTimeListVo) throws EventException{
    	//EsdSce0074Event event =(EsdSce0074Event)e;
        //DBRowSet rowSet = null;
        //int rowCnt = 0;
        List<SearchMissingListVO> list = null;        
        try{
        	//rowCnt = dbDao.searchOnTimeCnt(event.getParameterMap());
        	//rowSet = dbDao.searchOnTimeList(event.getParameterMap(),event.getIPage());  
        	list = dbDao.searchOnTimeList(searchOnTimeListVo);
            return list;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage()); 
        }
    }
    
    /**
     * Edi Detail Report - Mvmt 리스트 조회
     * @param SearchMissingListVO searchMissingListVo
     * @return List<SearchMissingListVO>
     * @throws EventException
     */
    public List<SearchMissingListVO> searchDetailMissingList(SearchMissingListVO searchMissingListVo) throws EventException{
    	/*
    	EsdSce0074Event event =(EsdSce0074Event)e;
        DBRowSet rowSet = null;
//        int rowCnt = 0;
        try{
//        	rowCnt = dbDao.searchDetailMvmtReportCnt(event.getParameterMap());
            rowSet = dbDao.searchMissingList(event.getParameterMap(),event.getIPage());  
            return new EsdSce0074EventResponse(rowSet);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage()); 
        }*/
        List<SearchMissingListVO> list = null;  
        try{
        	//rowCnt = dbDao.searchMissingCnt(event.getParameterMap());
            //rowSet = dbDao.searchMissingList(event.getParameterMap(),event.getIPage());  
        	list = dbDao.searchMissingList(searchMissingListVo); 
            return list;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage()); 
        }    	
    }
    
    /**
     * Vessel Schedule Accuracy 조회
     * @param SearchEstimationListVO searchEstimationListVO
     * @return List<SearchEstimationListVO>
     * @throws EventException
     */    
	public List<SearchEstimationListVO> searchEstimation(SearchEstimationListVO searchEstimationListVO) throws EventException {
		try {
			return dbDao.searchEstimation(searchEstimationListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
    
    /**
     *  My Performance Report Modify조회
     * @param SearchCustomerInfoVO myCustInfo
     * @return List<SearchPerRepPupModiVO>
     * @throws EventException
     */
    public List<SearchPerRepPupModiVO> searchPerRepPupModi(SearchCustomerInfoVO myCustInfo) throws EventException {
    	
    	try{
    		return dbDao.searchPerRepPupModi(myCustInfo);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     *  My Performance Report Modify 중복 체크
     * @param CustomerInqChoiceVO perMod
     * @param CustomerInqChoiceVO[] perMods
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse updatePerformanceCnt(CustomerInqChoiceVO perMod, CustomerInqChoiceVO[] perMods, Event e) throws EventException{
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            int cnt = dbDao.updatePerformanceCnt(perMod);
            
            Map<String, String> m = new HashMap<String, String>();
            m.put("cust_cnt", String.valueOf(cnt));
            eventResponse.setETCData(m);
            log.debug("eventResponse.getETCData = "+eventResponse.getETCData("cust_cnt"));
            
            return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * My Performance Report Modify 저장
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse updatePerformanceModify(Event e) throws EventException{
    	EsdSce0073Event event =(EsdSce0073Event)e;
    	try{
    		dbDao.updatePerformanceDelete(event.getMyUserInfo(), event.getMyUserInfos());
        	dbDao.updatePerformanceModify(event.getMyUserInfo(), event.getMyUserInfos());   
       		return	null;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * My Performance Report 저장
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse updatePerformance(Event e) throws EventException{
    	EsdSce0073Event event =(EsdSce0073Event)e;
        
        try{
        	dbDao.updatePerformanceGroup(event.getMyUserInfo());
        	dbDao.updatePerformance(event.getMyUserInfo(), event.getMyUserInfos());

       		return	null;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * My Page - My Customer 조회
     * @param String fUserid
     * @return List<SearchMyCustomerVO>
     * @throws EventException
     */
    public List<SearchMyCustomerVO> searchMyCustomer(String fUserid) throws EventException{
    	log.debug("1:searchMyCustomer 함수 진입");

        try{
        	return dbDao.searchMyCustomer(fUserid);   
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * My Page - My performance 조회
     * @param String fUserid
     * @return List<SearchMyPerformanceVO>
     * @throws EventException
     */
    public List<SearchMyPerformanceVO> searchMyPerformance(String fUserid) throws EventException{
    	log.debug("2:searchMyPerformance 함수 진입");
        
        try{
        	return dbDao.searchMyPerformance(fUserid);   
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * My page - My Cutomer 삭제
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse deleteMyCustomer(Event e) throws EventException{
    	EsdSce0090Event event =(EsdSce0090Event)e;
    	
    	try{
        	dbDao.deleteMyCustomer(event.getMyCustInfo(), event.getMyCustInfos());   
       		return	null;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * My page - My Performace 삭제
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse deleteMyPerformance(Event e) throws EventException{
    	EsdSce0090Event event =(EsdSce0090Event)e;
        
        try{
        	dbDao.deleteMyPerformance(event.getMyCustInfo(), event.getMyCustInfos());
       		return	null;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * EDI Group Information 조회
     * @param SearchEDIPerformanceOptionsVO schEdOpts
     * @return List<GetMyPerformanceSelectVO>
     * @throws EventException
     */
    /*public DBRowSet searchGroupID(CustomerInqChoiceVO myUserInfo) throws EventException {
    	try {
			return dbDao.searchCsInfo(myUserInfo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }*/
    public List<GetMyPerformanceSelectVO> getMyPerformance(SearchEDIPerformanceOptionsVO schEdOpts)  throws EventException {
    		try {
    			return dbDao.getMyPerformance(schEdOpts);
    		} catch (DAOException ex) {
    			throw new EventException(ex.getMessage(),ex);
    		} catch (Exception ex) {
    			throw new EventException(ex.getMessage(),ex);
    		}
        }
    
    /**
     * EDI manual 전송시 입력한 location 유효성 체크 
     * @param List<Edi315SendVO> list
     * @param boolean ibflgChk
     * @return String
     * @throws EventException
     */
    public String searchMdmLocation(List<Edi315SendVO> list,  boolean ibflgChk) throws EventException{
        String resultFlag = null;
        
        try{
            resultFlag = dbDao.searchMdmLocation(list, ibflgChk);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }  
        return resultFlag;
    }    
    
    /**
     * EDI Customer Information 조회
     * @param CustomerEdiDBDAOOptionsVO cusEdiOpt
     * @return String[]
     * @throws EventException
     */
    public String[] searchCsInfoList(CustomerEdiDBDAOOptionsVO cusEdiOpt) throws EventException{
    	try{
    	     return dbDao.searchCsInfoList(cusEdiOpt);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    
    /**
     * 조회 이벤트 처리<br>
     * Performance Setting Info 조회 이벤트 처리<br>
     *
     * @param SearchPerRepPupModiVO searchPerRepPupModiVO
     * @return List<SearchPerRepPupModiVO>
     * @throws EventException ... 
     */
    public  List<SearchPerRepPupModiVO> searchUsrPerformanceSettingInfo(SearchPerRepPupModiVO searchPerRepPupModiVO) throws EventException {
		List<SearchPerRepPupModiVO> list = null;        
        try {
        	list = dbDao.searchUsrPerformanceSettingInfo(searchPerRepPupModiVO);
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
        return list;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Performance Setting Info를 이전에 저장했는지 조회 이벤트 처리<br>
     *
     * @param SearchCustomerInfoVO myCustInfo
     * @return int
     * @throws EventException ... 
     */
    public  int checkUsrPerformanceSettingInfo(SearchCustomerInfoVO myCustInfo) throws EventException {
		int cnt = 0;        
        try {
        	cnt = dbDao.checkUsrPerformanceSettingInfo(myCustInfo);
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
        return cnt;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Performance Basic Form 조회 이벤트 처리<br>
     *
     * @param SearchCustomerInfoVO myCustInfo
     * @return List<SearchPerRepPupModiVO>
     * @throws EventException ... 
     */
    public  List<SearchPerRepPupModiVO> searchUsrPerformanceBasicForm(SearchCustomerInfoVO myCustInfo) throws EventException {
		List<SearchPerRepPupModiVO> list = null;        
        try {
        	list = dbDao.searchUsrPerformanceBasicForm(myCustInfo);
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
        return list;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * My Performance Report Edi Group code 별 EDI Standard Status Code 및 Customer Status Code 정보 조회<br>
     *
     * @param SearchCustomerInfoVO myCustInfo
     * @return List<SearchPerRepPupModiVO>
     * @throws EventException ... 
     */
    public  List<SearchPerRepPupModiVO> searchEdiGrpCgoSts(SearchCustomerInfoVO myCustInfo) throws EventException {
		List<SearchPerRepPupModiVO> list = null;        
        try {
        	log.debug("poong impl=================");
        	list = dbDao.searchEdiGrpCgoSts(myCustInfo);
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
        return list;
    }
    
    /**
     * 삭제 이벤트 처리
     * My Performance Report EDI Group Code 정보 삭제
     *
     * @param SearchCustomerInfoVO myCustInfo
     * @throws EventException ... 
     */
    public  void removePerRepPupInfo(SearchCustomerInfoVO myCustInfo) throws EventException {
        try {
        	dbDao.removePerRepPupInfo(myCustInfo);
        	dbDao.removePerRepPupDtlInfo(myCustInfo);
        	
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }
}
