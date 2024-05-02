/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailTransitReportBCImpl.java
*@FileTitle : RailTransit Report BC Impl
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.basic;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.integration.RailTransitReportDBDAO;
import com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListOptionsVO;
import com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRInfoVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;



/**
 * SCEM Commission Business Logic Basic Command implementation<br>
 * - <br>
 * 
 * @author 
 * @see EsdSce022EventResponse,ManageUserBC 
 * @since J2EE 1.4
 */
public class RailTransitReportBCImpl extends BasicCommandSupport implements RailTransitReportBC {
    private transient RailTransitReportDBDAO dbDao=null;

    /**
     * RailTransitReportBCImpl objects creation<br>
     * create RailTransitReportDBDAO<br>
     */
    public RailTransitReportBCImpl(){
        dbDao = new RailTransitReportDBDAO();
    }
    
    /**
     * retrieving Car Location Message
     * 
     * @param SearchCLMListOptionsVO schClmlOpts
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchCLMList(SearchCLMListOptionsVO schClmlOpts) throws EventException {
        DBRowSet rowSet=null; 
        int cnt = 0;
        
        try {
        	  GeneralEventResponse eventResponse = new GeneralEventResponse();
        	  cnt    = dbDao.searchCLMCount(schClmlOpts);
        	  if(cnt > 0){
		                   rowSet = dbDao.searchCLMList(schClmlOpts);
		                   rowSet.setMaxRows(cnt);
					       eventResponse.setRsVo(rowSet);

					ResultSetMetaData rsmd = rowSet.getMetaData();
					int cint= rsmd.getColumnCount();
					Map<String,String> etcMap = new HashMap<String,String>();
		            
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
					 eventResponse.setETCData(etcMap);
					 rowSet.beforeFirst();
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
     * retrieving Car Location Message(Pop)
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchCLMCountPop(SearchRTRInfoVO rtrInfo) throws EventException {
    	GeneralEventResponse eventResponse     = new GeneralEventResponse();
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
     * retrieving Car Location Message(Pop)
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchCLMListPop(SearchRTRInfoVO rtrInfo) throws EventException {
    	GeneralEventResponse eventResponse     = new GeneralEventResponse();
    	log.debug("searchCLMListPop - single Start!! ");
    	
    	try {
		       eventResponse.setRsVo(dbDao.searchCLMListPop(rtrInfo));
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    	return eventResponse;
	}
}