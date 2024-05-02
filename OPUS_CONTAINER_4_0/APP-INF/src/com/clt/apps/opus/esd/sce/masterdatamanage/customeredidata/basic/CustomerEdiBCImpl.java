/*========================================================= 
*Copyright(c) 2006 CyberLogitec
*@FileName : CustomerEdiBCImpl.java
*@FileTitle : Customer EDI Data management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.basic;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315SendVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0062Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0073Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0090Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration.CustomerEdiDBDAO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.CustomerEdiDBDAOOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.CustomerInqChoiceVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.GetMyPerformanceSelectVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCargoTrackingDataOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchComboPerformanceVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCsInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustStsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomTpIdVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerDataVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInqueryVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiActivityInquiryDataOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiActivityInquiryDataVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiStatusDataVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiSummaryReportOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMissingListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMyCustomerVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMyPerformanceVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchPerCsInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchPerRepPupModiVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchStsListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchVesselSkdOptionsVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * SCEM Business Logic Command Interface<br>
 *
 * @author yongcheonshin
 * @see EdiSendEventResponse 
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
     * EsdSce0035 <br>
     * 
     * @param CustomerEdiDBDAOOptionsVO cusEdiOpt
     * @return List<SearchEdiStatusDataVO> 
     * @exception EventException
     */
      public List<SearchEdiStatusDataVO> searchEdiStatusData(CustomerEdiDBDAOOptionsVO cusEdiOpt)  throws EventException {
    	
		try {
			return dbDao.searchEdiStatusData(cusEdiOpt);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }   

   /**
     * retrieving EDI Customer data<br>
     * EsdSce0062 <br>
     * 
     * @param CustomerInqChoiceVO custInq
     * @return List<SearchCustomerInqueryVO> 
     * @exception EventException
     */
    public List<SearchCustomerInqueryVO> searchCustomerInquery(CustomerInqChoiceVO custInq) throws EventException{
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
     * retrieving EDI Customer data<br>
     * EsdSce0062  <br>
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
     * managing EDI Customer data<br>
     * EsdSce0062   <br>
     * 
     * @param Event e
     * @return EventResponse 
     * @exception EventException
     */
    public EventResponse updateCustomerInquery(Event e) throws EventException{
        EsdSce0062Event event =(EsdSce0062Event)e;
        try{
        	
        	dbDao.updateCustomerInquery(event.getCustChoice());
        	
        	return	null;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    
    /**
     * setting customer tp id over 2<br>
     * EsdSce0062 <br>
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
     * retrieving Cargo Tracking EDI Individual Data
     * @param SearchCargoTrackingDataOptionsVO schCtdOpts
     * @return EventResponse
     * @throws EventException
     */
   
    public EventResponse searchCargoTrackingData(SearchCargoTrackingDataOptionsVO schCtdOpts) throws EventException{
    	
        DBRowSet rowSet     =null; 
        DBRowSet descRowSet = null;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
	            rowSet     = dbDao.searchCargoTrackingData(schCtdOpts);
	            descRowSet = dbDao.searchEdiStsDesc(schCtdOpts);

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
				eventResponse.setETCData(etcMap); 
				descRowSet.beforeFirst();//changing first value 
			 
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
     * retrieving EDIActivity Inquiry Data
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
     * retrieving Edi Summary Report
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchEdiSummaryReport(SearchEdiSummaryReportOptionsVO schSROptsVO) throws EventException {
        DBRowSet rowSet=null; 
        int cnt = 0;   
        try {
        	cnt    = dbDao.searchEdiSummaryReportCnt(schSROptsVO);
        	rowSet = dbDao.searchEdiSummaryReport(schSROptsVO);
        	/*Test Of Paging*/
        	//cnt = 1000;
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
     * retrieving Edi Detail Report - Mvmt List
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchDetailMvmtReport(SearchEdiSummaryReportOptionsVO schSROptsVO) throws EventException {
        DBRowSet rowSet=null; 
        int cnt = 0;   
        try {

        	cnt    = dbDao.searchDetailMvmtReportCnt(schSROptsVO);
            rowSet = dbDao.searchDetailMvmtReport(schSROptsVO);
            /*TEST Code
            cnt =  1000;
            */
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
     * retrieving Edi Detail Report - Other List
     * @param SearchEdiSummaryReportOptionsVO schSROptsVO
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchDetailOtherReport(SearchEdiSummaryReportOptionsVO schSROptsVO) throws EventException {
        DBRowSet rowSet=null; 
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
     * retrieving EDI Customer Information
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
	 * retrieving VVD List
	 * 
	 * @param SearchVesselSkdOptionsVO schVSlVO
	 * @return EventResponse
	 * @exception EventException
	 */    
    public EventResponse searchVvdList(SearchVesselSkdOptionsVO schVSlVO) throws EventException{
        DBRowSet rowSet=null; 
        
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
	 * retrieving EDI Customer Status
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
     * retrieving Edi Performance Report Missing List
     * @param SearchEDIPerformanceOptionsVO schEPOpts
     * @return EventResponse
     * @throws EventException
	 */
    public EventResponse searchEDIPerformance(SearchEDIPerformanceOptionsVO schEPOpts)  throws EventException {
    	DBRowSet rowSet = null;
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
     * retrieving Edi Total Performance Report on-time-performance
     * @param SearchEDIPerformanceOptionsVO schEPOpts
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse searchEDITotalPerformance(SearchEDIPerformanceOptionsVO schEPOpts) throws EventException{
		DBRowSet rowSet = null;
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
     * retrieving Edi Total Performance Report Combo List
     * @param SearchEDIPerformanceOptionsVO custOpts
     * @return List<SearchComboPerformanceVO>
     * @throws EventException
     */
	public List<SearchComboPerformanceVO> searchComboPerformance(SearchEDIPerformanceOptionsVO custOpts) throws EventException{

		try {
			return dbDao.searchComboPerformance(custOpts);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }
	/**
     * retrieving Edi Customer Status
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
     * retrieving EDI Customer Information
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
     * retrieving EDI Customer TP ID Information
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
 			   eventResponse.setETCData(etcMap);
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
 			   eventResponse.setETCData(etcMap);
			   
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
     * retrieving Missing List popup
     * @param SearchMissingListVO searchMissingListVo
     * @return List<SearchMissingListVO>
     * @throws EventException
     */
    public List<SearchMissingListVO> searchMissingList(SearchMissingListVO searchMissingListVo) throws EventException{

        List<SearchMissingListVO> list = null;  
        try{
        	list = dbDao.searchMissingList(searchMissingListVo); 
            return list;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage()); 
        }
    }
    
    /**
     * retrieving Missing List popup
     * @param SearchMissingListVO searchOnTimeListVo
     * @return List<SearchMissingListVO>
     * @throws EventException
     */
   	public List<SearchMissingListVO> searchOnTimeList(SearchMissingListVO searchOnTimeListVo) throws EventException{

        List<SearchMissingListVO> list = null;        
        try{
        	list = dbDao.searchOnTimeList(searchOnTimeListVo);
            return list;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage()); 
        }
    }
    
    /**
     * retrieving Edi Detail Report - Mvmt List
     * @param SearchMissingListVO searchMissingListVo
     * @return List<SearchMissingListVO>
     * @throws EventException
     */
    public List<SearchMissingListVO> searchDetailMissingList(SearchMissingListVO searchMissingListVo) throws EventException{
        List<SearchMissingListVO> list = null;  
        try{
        	list = dbDao.searchMissingList(searchMissingListVo); 
            return list;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage()); 
        }    	
    }


    /**
     *  retrieving My Performance Report
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
     * changing My Performance Report 
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
     * update Performance Report
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
     * update Performance Report
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse updatePerformance(Event e) throws EventException{
    	EsdSce0073Event event =(EsdSce0073Event)e;
        
        try{
        	dbDao.updatePerformanceGroup(event.getMyUserInfo());
        	dbDao.updatePerformanceDelete(event.getMyUserInfo(), event.getMyUserInfos());
        	dbDao.updatePerformance(event.getMyUserInfo(), event.getMyUserInfos());

       		return	null;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * retrieving My Page - My Customer
     * @param String fUserid
     * @return List<SearchMyCustomerVO>
     * @throws EventException
     */
    public List<SearchMyCustomerVO> searchMyCustomer(String fUserid) throws EventException{

        try{
        	return dbDao.searchMyCustomer(fUserid);   
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * retrieving My Page - My performance
     * @param String fUserid
     * @return List<SearchMyPerformanceVO>
     * @throws EventException
     */
    public List<SearchMyPerformanceVO> searchMyPerformance(String fUserid) throws EventException{
        
        try{
        	return dbDao.searchMyPerformance(fUserid);   
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * retrieving My page - My Customer
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
     * delete My page - My Performance
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
     * retrieving My page - My Performance
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
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
     * retrieving location at send EDI(manual) 
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
    
}
