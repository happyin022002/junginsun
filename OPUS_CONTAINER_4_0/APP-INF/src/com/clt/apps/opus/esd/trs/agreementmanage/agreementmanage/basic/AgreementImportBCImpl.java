/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AgreementImportBCImpl.java
*@FileTitle : Agreement File Import
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic;

import java.sql.SQLException;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0220Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0221Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration.AgreementImportDBDAO;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.DummyAgmtRateVO;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.SearchAgmtHdrVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>

 * 
 * @author agreement
 * @see ESD_TRS_061EventResponse,AgreementImportBC
 * @since J2EE 1.4
 */
public class AgreementImportBCImpl   extends BasicCommandSupport implements AgreementImportBC {

    // Database Access Object
    private transient AgreementImportDBDAO dbDao=null;

    /**
     * AgreementImportBCImpl <br>
     * AgreementImportDBDAO<br>
     */
    public AgreementImportBCImpl(){
        dbDao = new AgreementImportDBDAO();
    }

    /**
     * Inquiry event process<br>
     * Agreement Header<br>
     * 
     * @param e
     * @return response GeneralEventResponse
     * @exception EventException
     */
    public EventResponse searchAgmtHdr(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();    
        DBRowSet rowSet=null; // DB ResultSet for sending data
        EsdTrs0220Event event=(EsdTrs0220Event)e;
        try {
            rowSet=dbDao.searchAgmtHdr(event);
            eventResponse.setRsVo(rowSet);
            return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception se) {
            log.error("err "+se.toString(),se);
            throw new EventException(se.getMessage());        
        }
    }
    
    /**
     * Inquiry event process<br>
     * Agreement Child S/P<br>
     * 
     * @param e
     * @return response GeneralEventResponse
     * @exception EventException
     */
    public EventResponse searchAgmtChdVndr(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();    
        DBRowSet rowSet=null; // DB ResultSet for sending data
        EsdTrs0220Event event=(EsdTrs0220Event)e;
        try {
            rowSet=dbDao.searchAgmtChdVndr(event);
            eventResponse.setRsVo(rowSet);
            return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception se) {
            log.error("err "+se.toString(),se);
            throw new EventException(se.getMessage());        
        }
    }
    
    /**
     * Inquiry event process<br>
     * Agreement S/P<br>
     * 
     * @param e
     * @return response GeneralEventResponse
     * @exception EventException
     */

    public EventResponse searchVenderName(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();    
        DBRowSet rowSet=null; // DB ResultSet for sending data
        EsdTrs0220Event event=(EsdTrs0220Event)e;
        try {
            rowSet=dbDao.searchVenderName(event);
            if(rowSet.next()){
                eventResponse.setETCData("VNDR_NM", rowSet.getString("VNDR_NM"));
            }
            eventResponse.setRsVo(rowSet);
            return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception se) {
            log.error("err "+se.toString(),se);
            throw new EventException(se.getMessage());        
        }
    }
    
    
    /**
     * Inquiry event process<br>
     * Contract Office<br>
     * 
     * @param e
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse searchContractOffice(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();    
        DBRowSet rowSet=null; // DB ResultSet for sending data
        EsdTrs0220Event event=(EsdTrs0220Event)e;
        try {
            rowSet=dbDao.searchContractOffice(event);
            if(rowSet.next()){
                eventResponse.setETCData("CTRT_OFC_CD", rowSet.getString("OFC_CD"));
            }
            return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception se) {
            log.error("err "+se.toString(),se);
            throw new EventException(se.getMessage());                        
        }
    }
    
    /**
     * Inquiry event process<br>
     * Agreement Duplication check<br>
     * 
     * @param searchAgmtHdrVO
     * @return response GeneralEventResponse
     * @exception EventException
     */
    public EventResponse searchAgmtDupChk(SearchAgmtHdrVO searchAgmtHdrVO) throws EventException {
        DBRowSet rowSet=null; // DB ResultSet for sending data
        try {
            GeneralEventResponse eventResponse = new GeneralEventResponse();    
            rowSet=dbDao.searchAgmtDupChk(searchAgmtHdrVO);
            if(rowSet.next()){
                eventResponse.setETCData("CNT_CD_AGREE", rowSet.getString("AGMT_NO"));
            }
            return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception se) {
            log.error("err "+se.toString(),se);
            throw new EventException(se.getMessage());                        
        }
    }

    /**
     * Agreement Header<br>
     * 
     * @param searchAgmtHdrVO
     * @return response GeneralEventResponse
     * @exception EventException
     */
    public EventResponse multiAgmtHdr(SearchAgmtHdrVO searchAgmtHdrVO) throws EventException {
        String rtn_agmt_no = "";
        try {
            GeneralEventResponse eventResponse = new GeneralEventResponse();    
            rtn_agmt_no = dbDao.multiAgmtHdr(searchAgmtHdrVO);
            eventResponse.setETCData("NEW_AGMT_NO", rtn_agmt_no);
            return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception se) {
            log.error("err "+se.toString(),se);
            throw new EventException(se.getMessage());                        
        }
    }
    
    /**
     * Modification event process<br>
     * Agreement Header<br>
     * 
     * @param e
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse multiAgmtHdrRmk(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();    
        EsdTrs0220Event event=(EsdTrs0220Event)e;
        try {
            dbDao.multiAgmtHdrRmk(event);
            return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception se) {
            log.error("err "+se.toString(),se);
            throw new EventException(se.getMessage());                        
        }
    }

    /**
     * Inquiry event process<br>
     * Agreement S/P <br>
     * 
     * @param e
     * @return response GeneralEventResponse
     * @exception EventException
     */
    public EventResponse multiAgmtHdrVndr(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();    
        // PDTO(Data Transfer Object including Parameters)
        EsdTrs0220Event event=(EsdTrs0220Event)e;
        try {
            dbDao.multiAgmtHdrVndr(event);
            return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * Sequence<br>
     * Verify Sequence<br>
     * 
     * @return String
     * @exception EventException
     */
    public String createAgmtVerifyNewTmpSeq() throws EventException {
        DBRowSet rowSet=null; // DB ResultSet for sending data
        String newAgmtTmpSeq  = null;
        try {
            rowSet=dbDao.createNewAgmtTmpSeq();
            if(rowSet.next())    newAgmtTmpSeq = rowSet.getString(1);
            return newAgmtTmpSeq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (SQLException se) {
            log.error("err "+se.toString(),se);
            throw new EventException(se.getMessage());                        
        } catch (Exception ex) {
            log.error(ex.toString(), ex);
            throw new EventException(ex.getMessage());
        } 
    }
    
    /**
     * Agreement Verify <br>
     * AgreementImport - Inquiry event process<br>
     * 
     * @param e
     * @exception EventException
     */
    public void insertAgmtVerifyData(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsdTrs0221Event     event    = (EsdTrs0221Event)e;
        try {
            dbDao.insertAgreementVerifyData(event);
        } catch (DAOException de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * Verify event processing <br>
     * Agreement Creation - Pair Type Verify <br>
     * 
     * @param e
     * @return response ESD_TRS_0221EventResponse
     * @exception EventException
     */
    public EventResponse verifyAgmtPair(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsdTrs0221Event     event    = (EsdTrs0221Event)e;
        DBRowSet             rowSet = null;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
            rowSet = dbDao.verifyAgmtPair(event);
            eventResponse.setRsVo(rowSet);
        } catch (DAOException de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    

    /**
     * Delete event processing<br>
     * Agreement Creation Verify data Delete event processing<br>
     * 
     * @param e
     * @exception EventException
     */
    public void deleteAgmtVerifyData(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsdTrs0221Event     event    = (EsdTrs0221Event)e;
        try {
            dbDao.deleteAgmtVerifyData(event);
        } catch (DAOException de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * Verify event processing<br>
     * Agreement Surcharge Verify event processing
     * 
     * @param e
     * @return response ESD_TRS_0221EventResponse
     * @exception EventException
     */
    public EventResponse verifyAgmtSurcharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsdTrs0221Event     event    = (EsdTrs0221Event)e;
        DBRowSet             rowSet = null;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
            rowSet = dbDao.verifyAgmtSurcharge(event);
            eventResponse.setRsVo(rowSet);
            
        } catch (DAOException de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     *  Agreement Sub Office<br>
     * 
     * @param e
     * @return response GeneralEventResponse
     * @exception EventException
     */
    public EventResponse searchSubOfcCd(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();    
        DBRowSet rowSet=null; // DB ResultSet for sending data
        EsdTrs0221Event event=(EsdTrs0221Event)e;
        try {
            rowSet=dbDao.searchSubOfcCd(event);
            eventResponse.setRsVo(rowSet);
            return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception se) {
            log.error("err "+se.toString(),se);
            throw new EventException(se.getMessage());        
        }
    }
    
    /**
     * Agreement Rate<br>
     * 
     * @param e
     * @return response ESD_TRS_0225EventResponse
     * @exception EventException
     */
    public EventResponse deleteCorrRateAgmt(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsdTrs0221Event     event    = (EsdTrs0221Event)e;
        try {
            dbDao.deleteCorrRateAgmt(event);
        } catch (DAOException de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        }
        GeneralEventResponse eventResponse = new GeneralEventResponse();    
        return eventResponse;
    }
    
    /**
     * Save event processing<br>
     * Agreement Rate <br>
     * 
     * @param e
     * @return response GeneralEventResponse
     * @exception EventException
     */
    public EventResponse multiCorrRateAgmt(Event e) throws EventException {
        EsdTrs0221Event     event    = (EsdTrs0221Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();    
        DBRowSet             rowSet = null;
        
        try {
            rowSet = dbDao.verifyAgmtPair(event);
            while(rowSet.next()) {
            	if(!rowSet.getString("RMK").isEmpty() || !rowSet.getString("RMK2").isEmpty()) {
        			throw new EventException(new ErrorHandler("COM12192", new String[] { "Agreement data verification has been failed" }).getMessage());
            	}
            }
            
            dbDao.multiCorrRateAgmt(event);
        } catch (DAOException de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * Save event processing<br>
     * Agreement Surcharge Rate <br>
     * 
     * @param e
     * @return response GeneralEventResponse
     * @exception EventException
     */
    public EventResponse multiCorrScgAgmt(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsdTrs0221Event     event    = (EsdTrs0221Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();    
        try {
            dbDao.multiCorrScgAgmt(event);
        } catch (DAOException de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

    /**
     * Agreement Surcharge Rate Update : CALL TRS_AGMT_RATE_CC_PKG.GET_TRS_All_RATE_PRC (Only for "Auto Apply" checked)
     * 2014.11.20    Hyungwook Choi
     * @param e
     * @return response GeneralEventResponse
     * @exception EventException
     */
    public EventResponse multiCorrScgAgmtForAutoApply(Event e) throws EventException
    {
        EsdTrs0221Event event = (EsdTrs0221Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();    
        try {
            dbDao.multiCorrScgAgmtForAutoApply(event);
        } catch (DAOException de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

    /**
     * Agreement Surcharge Rate<br>
     * 
     * @param dummyAgmtRateVOs
     * @param account
     * @throws EventException
     */
    public void deleteCorrScgAgmt(DummyAgmtRateVO[] dummyAgmtRateVOs, SignOnUserAccount account) throws EventException {
        try {
            for ( int i=0; i < dummyAgmtRateVOs.length; i++ ) {
                dbDao.deleteCorrScgAgmt(dummyAgmtRateVOs[i], account);
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }

    /**
     * Delete event processing<br>
     * TRS_AGMT_TMP Delete event processing<br>
     * 2014.11.27    Hyungwook Choi
     * @param e
     * @exception EventException
     */
    public void deleteTrsAgmtTmp(Event e) throws EventException {
        EsdTrs0221Event event = (EsdTrs0221Event)e;
        try {
            dbDao.deleteTrsAgmtTmp(event);
        } catch (DAOException de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }

    /**
     * End process of TRS task scenario<br>
     * Releasing the related implicit object when AgreementFileImport task is end.<br>
     */
    public void doEnd() {
        dbDao = null;
    }
}
