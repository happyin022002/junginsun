/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailTransitReportBCImpl.java
*@FileTitle : RailTransit Report BC Impl
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-16
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-16 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.basic;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration.RailTransitReportDBDAO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListOptionsVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListPopVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputBKGNoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputBLNoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputCntrVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputVVDVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRInfoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRListVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRSmmyListVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchTRCListOptionsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;



/**
 * ENIS-SCEM Commission Business Logic Basic Command implementation<br>
 * - ENIS-SCEM Commission에 대한 비지니스 로직을 처리한다.<br>
 * @author Se-Hoon PARK
 * @see EsdSce022EventResponse,ManageUserBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RailTransitReportBCImpl extends BasicCommandSupport implements RailTransitReportBC {

    // Database Access Object
    private transient RailTransitReportDBDAO dbDao=null;


    /**
     * RailTransitReportBCImpl 객체 생성<br>
     * RailTransitReportDBDAO를 생성한다.<br>
     */
    public RailTransitReportBCImpl(){
        dbDao = new RailTransitReportDBDAO();
    }
    
    /**
     * Car Location Message 조회
     * 
     * @param SearchCLMListOptionsVO schClmlOpts
     * @return EventResponse
     * @throws EventException
     */
   
    public EventResponse searchCLMList(SearchCLMListOptionsVO schClmlOpts) throws EventException {
        DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
        int cnt = 0;
        
        try {
        	  GeneralEventResponse eventResponse = new GeneralEventResponse();
        	  cnt    = dbDao.searchCLMCount(schClmlOpts);
        	  if(cnt > 0){
		                   rowSet = dbDao.searchCLMList(schClmlOpts);
		                   rowSet.setMaxRows(cnt);
					       eventResponse.setRsVo(rowSet);
					/*
					 *RowSet 에 공통 데이터를 ETC_DATA 로 추출하여 만들어 주는 과정
					 * */ 
					ResultSetMetaData rsmd = rowSet.getMetaData();
					int cint= rsmd.getColumnCount();
					Map<String,String> etcMap = new HashMap();
		            
					while (rowSet.next()) { 
						for (int j = 0 ; j < cint; j++) {
							String columns = rsmd.getColumnName(j+1).toLowerCase();
							Object values  = rowSet.getObject(j +1);
							log.debug("Column No    :" + rowSet.findColumn(columns));
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
					 rowSet.beforeFirst();//초기값을 돌린다(중요함)
           }//if
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
     * Car Location Message 조회(Pop)
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchCLMCountPop(SearchRTRInfoVO rtrInfo) throws EventException {
    	GeneralEventResponse eventResponse     = new GeneralEventResponse();
//    	DBRowSet                 rowSet        = null ;
    	int                      totCnt        = 0 ;
    	
    	try {
    		totCnt = dbDao.searchCLMCountPop(rtrInfo) ;
    		eventResponse.setETCData("totcnt", String.valueOf(totCnt));
    		log.debug("totCnt===" + totCnt);
 
    		return eventResponse;
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
    
    /**
     * Car Location Message 조회(Pop)
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @return List<SearchCLMListPopVO>
     * @throws EventException
     */
    public List<SearchCLMListPopVO> searchCLMListPop(SearchRTRInfoVO rtrInfo) throws EventException {
    	log.debug("searchCLMListPop - single Start!! ");
    	
    	try {
			return dbDao.searchCLMListPop(rtrInfo) ;
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    	/*RequestDataSetBC         dataSet       = event.getDataSet() ;
    	RequestDataSetBC         dataSet2      = RequestDataSetBC.getInstance() ;
    	EsdSce044EventResponse eventResponse = null ;
    	DBRowSet                 rowSet        = null ;
    	int                      totCnt        = 0 ;
    	
    	try {
			totCnt = dbDao.searchCLMCountPop(dataSet) ;
			rowSet = dbDao.searchCLMListPop(dataSet) ;
			
			dataSet2.put("total_count", totCnt + "") ;
			eventResponse = new EsdSce044EventResponse(rowSet, totCnt) ; 
			
		} catch (DAOException de) {
			log.error(de.toString(),de);
            throw new EventException(de.getMessage());
		}
    	
		return eventResponse;*/
	}
    
    /**
     * Train & Rail Car 조회
     * 
     * @param SearchTRCListOptionsVO schTrlOpts
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchTRCList(SearchTRCListOptionsVO schTrlOpts) throws EventException {
        DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
        int cnt = 0;
        
        try {
        	//cnt    = dbDao.searchTRCCount(schTrlOpts);
            rowSet = dbDao.searchTRCList(schTrlOpts);
            DBRowSet tempRowSet = rowSet.createCopy();
            if(tempRowSet.getRowCount()>0){
            	tempRowSet.next();
            	cnt = tempRowSet.getInt("tot_cnt");
            }
            
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
     * Rail Transit Report
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @param String searchType
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchRTRCnt(SearchRTRInfoVO rtrInfo, String searchType) throws EventException {
    	GeneralEventResponse eventResponse     = new GeneralEventResponse();
//    	DBRowSet                 rowSet        = null ;
    	int                      totCnt        = 0 ;
    	
    	try {
			//20070612
    		totCnt = dbDao.searchRTRCount(rtrInfo, searchType) ;
    		eventResponse.setETCData("totcnt", String.valueOf(totCnt));
    		log.debug("totCnt===" + totCnt);
 
    		return eventResponse;
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}

    /**
     * searchRTRList
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchRTRList(SearchRTRInfoVO rtrInfo) throws EventException {
    	log.debug("searchRTRList - single Start!! ");
    	GeneralEventResponse eventResponse     = new GeneralEventResponse();
    	DBRowSet                 rowSet        = null ;
    	DBRowSet                 rowSet2        = null ;
    	int                      totCnt        = 0 ;
    	
    	try {
//    		totCnt = dbDao.searchRTRCount(rtrInfo, "single") ;
    		rowSet = dbDao.searchRTRList(rtrInfo) ;
    		rowSet2=(DBRowSet)rowSet.clone();
    		if(rowSet.next()) {
    			totCnt = rowSet.getInt("CNT");
        	}
    		rowSet.setMaxRows(totCnt);
            eventResponse.setRsVo(rowSet2);
            eventResponse.setETCData("totcnt", String.valueOf(totCnt));
			return eventResponse;
		} catch (CloneNotSupportedException cnse) {
            log.error("err "+cnse.toString(),cnse);
            throw new EventException(cnse.getMessage());
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
    /**
     * searchRTRList
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @param SearchRTRListVO[] rtrLists
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchRTRList(SearchRTRInfoVO rtrInfo, SearchRTRListVO[] rtrLists) throws EventException {
    	log.debug("searchRTRList - multi Start!! ");
    	GeneralEventResponse eventResponse     = new GeneralEventResponse();
    	DBRowSet                 rowSet        = null ;
    	DBRowSet                 rowSet2        = null ;
    	int                      totCnt        = 0 ;
    	
    	try {
//    		totCnt = dbDao.searchRTRCount(rtrInfo, "multi") ;
    		rowSet = dbDao.searchRTRList(rtrInfo, rtrLists) ;
    		rowSet2=(DBRowSet)rowSet.clone();
    		if(rowSet.next()) {
    			totCnt = rowSet.getInt("CNT");
        	}
    		rowSet.setMaxRows(totCnt);
            eventResponse.setRsVo(rowSet2);
            eventResponse.setETCData("totcnt", String.valueOf(totCnt));
			return eventResponse;
		} catch (CloneNotSupportedException cnse) {
            log.error("err "+cnse.toString(),cnse);
            throw new EventException(cnse.getMessage());
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
    
    /**
     * searchMultiInput
     * 
     * @param SearchMultiInputCntrVO[] cntrInfos
     * @return List<SearchMultiInputCntrVO>
     * @throws EventException
     */
    public List<SearchMultiInputCntrVO> searchMultiInput(SearchMultiInputCntrVO[] cntrInfos) throws EventException {
    	log.debug("searchMultiInput - multi Start!! ");
    	
    	try {
    		return dbDao.searchMultiInputCntr(cntrInfos) ;
    	} catch (DAOException ex) {
    		throw new EventException(ex.getMessage(),ex);
    	} catch (Exception ex) {
    		throw new EventException(ex.getMessage(),ex);
    	}
    }
    /**
     * searchMultiInputBkgNo
     * 
     * @param SearchMultiInputBKGNoVO[] bkgInfos
     * @return List<SearchMultiInputBKGNoVO>
     * @throws EventException
     */
    public List<SearchMultiInputBKGNoVO> searchMultiInputBkgNo(SearchMultiInputBKGNoVO[] bkgInfos) throws EventException {
    	log.debug("searchMultiInputBkgNo - multi Start!! ");
    	
    	try {
    		return dbDao.searchMultiInputBKGNo(bkgInfos) ;
    	} catch (DAOException ex) {
    		throw new EventException(ex.getMessage(),ex);
    	} catch (Exception ex) {
    		throw new EventException(ex.getMessage(),ex);
    	}
    }
    /**
     * searchMultiInputBlNo
     * 
     * @param SearchMultiInputBLNoVO[] blnoInfos
     * @return List<SearchMultiInputBLNoVO>
     * @throws EventException
     */
    public List<SearchMultiInputBLNoVO> searchMultiInputBlNo(SearchMultiInputBLNoVO[] blnoInfos) throws EventException {
    	log.debug("searchMultiInputBlNo - multi Start!! ");
    	
    	try {
    		return dbDao.searchMultiInputBlNo(blnoInfos) ;
    	} catch (DAOException ex) {
    		throw new EventException(ex.getMessage(),ex);
    	} catch (Exception ex) {
    		throw new EventException(ex.getMessage(),ex);
    	}
    }
    /**
     * searchMultiInputVvd
     * 
     * @param SearchMultiInputVVDVO[] vvdInfos
     * @return List<SearchMultiInputVVDVO>
     * @throws EventException
     */
    public List<SearchMultiInputVVDVO> searchMultiInputVvd(SearchMultiInputVVDVO[] vvdInfos) throws EventException {
    	log.debug("searchMultiInputVvd - multi Start!! ");
    	
    	try {
    		return dbDao.searchMultiInputVVD(vvdInfos) ;
    	} catch (DAOException ex) {
    		throw new EventException(ex.getMessage(),ex);
    	} catch (Exception ex) {
    		throw new EventException(ex.getMessage(),ex);
    	}
    }
    
    /**
	 * Multi Save<br>
	 * UI_COM_SYS_007 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SearchRTRListVO[] models
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyRTRReport(SearchRTRListVO[] models) throws EventException{
    	GeneralEventResponse eventResponse     = new GeneralEventResponse();
		try {
			dbDao.modifyRTRReport(models);
			return eventResponse;
		} catch (DAOException ex) {
    		throw new EventException(ex.getMessage(),ex);
    	} catch (Exception ex) {
    		throw new EventException(ex.getMessage(),ex);
    	}
	}
	
    /**
	 * Multi Save<br>
	 * UI_COM_SYS_007 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SearchRTRListVO[] models
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyRTRReportRemark(SearchRTRListVO[] models) throws EventException{
    	GeneralEventResponse eventResponse     = new GeneralEventResponse();
		try {
			dbDao.modifyRTRReportRemark(models);
			return eventResponse;
		} catch (DAOException ex) {
    		throw new EventException(ex.getMessage(),ex);
    	} catch (Exception ex) {
    		throw new EventException(ex.getMessage(),ex);
    	}
	}
	
	/**
     * RTR Summary List 조회
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse searchRTRSmmyList(Event e) throws EventException {
    	GeneralEventResponse eventResponse     = new GeneralEventResponse();
    	List<SearchRTRSmmyListVO> list  = null ;
    	try {
    		list = dbDao.searchRTRSmmyList(e) ;
    		eventResponse.setRsVoList(list);
//            eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
     * RTR Summary Detail 조회
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse searchRTRSmmyDetail(Event e) throws EventException {
    	GeneralEventResponse eventResponse      = new GeneralEventResponse();
    	DBRowSet                 rowSet         = null ;
    	DBRowSet                 rowSet2        = null ;
    	int						totCnt			= 0;
    	try {
    		rowSet = dbDao.searchRTRSmmyDetail(e);
            
    		rowSet2=(DBRowSet)rowSet.clone();
    		if(rowSet.next()) {
    			totCnt = rowSet.getInt("CNT");
        	}
    		rowSet.setMaxRows(totCnt);
            eventResponse.setRsVo(rowSet2);
            eventResponse.setETCData("totcnt", String.valueOf(totCnt));
            
			return eventResponse;
		} catch (DAOException de) {
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}