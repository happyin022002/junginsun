/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AgreementImportBC.java
*@FileTitle : Agreement File Import
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.DummyAgmtRateVO;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.SearchAgmtHdrVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic Command Interface<br>
 *
 * @author agreement
 * @see EsdTrs0220EventResponse 
 * @since J2EE 1.5
 */
public interface AgreementImportBC  {

    /**
     * Agreement Header<br>
     * 
     * @param e ESD_TRS_0220Event
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse searchAgmtHdr(Event e) throws EventException;
    
    /**
     * Agreement Child S/P<br>
     * 
     * @param e ESD_TRS_0220Event
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse searchAgmtChdVndr(Event e) throws EventException;

    /**
     * Agreement S/P<br>
     * 
     * @param e
     * @return
     * @throws EventException
     */
    public EventResponse searchVenderName(Event e) throws EventException;

    /**
     * Contract Office<br>
     * 
     * @param e
     * @return
     * @throws EventException
     */
    public EventResponse searchContractOffice(Event e) throws EventException;

    /**
     * Agreement <br>
     * 
     * @param searchAgmtHdrVO
     * @return
     * @throws EventException
     */
    public EventResponse searchAgmtDupChk(SearchAgmtHdrVO searchAgmtHdrVO) throws EventException;
    
    /**
     * Agreement Header<br>
     * 
     * @param searchAgmtHdrVO
     * @return
     * @throws EventException
     */
    public EventResponse multiAgmtHdr(SearchAgmtHdrVO searchAgmtHdrVO) throws EventException;
    
    /**
     * Agreement Header<br>
     * 
     * @param e
     * @return
     * @throws EventException
     */
    public EventResponse multiAgmtHdrRmk(Event e) throws EventException;
    
    /**
     * Agreement S/P <br>
     * 
     * @param e ESD_TRS_0220Event
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse multiAgmtHdrVndr(Event e) throws EventException;
    
    /**
     * Sequence <br>
     * Verify Sequence<br>
     * 
     * @return String
     * @exception EventException
     */
    public String createAgmtVerifyNewTmpSeq() throws EventException ;
    
    /**
     * Agreement verify - temp Insert<br>
     * 
     * @param e ESD_TRS_0221Event
     * @exception EventException
     */
    public void insertAgmtVerifyData(Event e) throws EventException; 
    
    /**
     * AgreementPair Verify <br>
     * AgreementPair Verify - Inquiry event process<br>
     * 
     * @param e ESD_TRS_0221Event
     * @return event EsdTrs0221Event
     * @exception EventException
     */
    public EventResponse verifyAgmtPair(Event e) throws EventException;
    
    
    /**
     * Agreement verify - temp Delete<br>
     * 
     * @param e
     * @throws EventException
     */
    public void deleteAgmtVerifyData(Event e) throws EventException; 

    /**
     * Agreement Surcharge Verify<br>
     * Agreement Surcharge Verify - Inquiry event process<br>
     * 
     * @param e ESD_TRS_0221Event
     * @return event EsdTrs0221Event
     * @exception EventException
     */
    public EventResponse verifyAgmtSurcharge(Event e) throws EventException;

    /**
     * Agreement Sub Office<br>
     * 
     * @param e ESD_TRS_0221Event
     * @return event EsdTrs0221Event
     * @exception EventException
     */
    public EventResponse searchSubOfcCd(Event e) throws EventException; 
    
    /**
     * Agreement Rate<br>
     * 
     * @param e ESD_TRS_0224Event
     * @return event EsdTrs0224Event
     * @exception EventException
     */
    public EventResponse deleteCorrRateAgmt(Event e) throws EventException; 
    
    /**
     * Agreement Rate <br>
     * 
     * @param e ESD_TRS_0221Event
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse multiCorrRateAgmt(Event e) throws EventException;
    
    /**
     * Agreement Surcharge Rate<br>
     * 
     * @param e ESD_TRS_0221Event
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse multiCorrScgAgmt(Event e) throws EventException;
    
    /**
     * Agreement Surcharge Rate Update : CALL TRS_AGMT_RATE_CC_PKG.GET_TRS_All_RATE_PRC (Only for "Auto Apply" checked)
     * 2014.11.20    Hyungwook Choi
     * @param e ESD_TRS_0221Event
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse multiCorrScgAgmtForAutoApply(Event e) throws EventException;

    /**
     * Agreement Surcharge Rate<br>
     * 
     * @param dummyAgmtRateVOs
     * @param account
     * @throws EventException
     */
    public void deleteCorrScgAgmt(DummyAgmtRateVO[] dummyAgmtRateVOs, SignOnUserAccount account) throws EventException; 

    /**
     * TRS_AGMT_TMP Delete
     * 2014.11.27    Hyungwook Choi
     * @param e
     * @throws EventException
     */
    public void deleteTrsAgmtTmp(Event e) throws EventException; 
}