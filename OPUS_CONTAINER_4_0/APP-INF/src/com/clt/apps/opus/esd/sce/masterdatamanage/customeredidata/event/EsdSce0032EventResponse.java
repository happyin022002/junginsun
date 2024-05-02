/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0032EventResponse.java
*@FileTitle : EsdSce0032 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-26
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.support.layer.event.EventResponseSupport;

/**
 * EsdSce0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yong-cheon Shin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("deprecation")
public class EsdSce0032EventResponse  extends EventResponseSupport  {
	private static final long serialVersionUID = 1L;
	
	private DBRowSet ediCustomerGrpList = null;
    private DBRowSet customerTpIdList = null;
    private DBRowSet cltTpIdList = null;
    private DBRowSet customerCodeList = null;
    private DBRowSet scNoList = null;
    
    private DBRowSet rowSet = null;
    
    /** Constructor
     * @param edi_customer_grp_list_
     * @param customer_tp_id_list_
     * @param clt_tp_id_list_
     * @param customer_code_list_
     * @param sc_no_list_
     */
    public EsdSce0032EventResponse(DBRowSet edi_customer_grp_list_
            , DBRowSet customer_tp_id_list_
            , DBRowSet clt_tp_id_list_
            , DBRowSet customer_code_list_
            , DBRowSet sc_no_list_){
        this.ediCustomerGrpList = edi_customer_grp_list_;
        this.customerTpIdList = customer_tp_id_list_;
        this.cltTpIdList = clt_tp_id_list_;
        this.customerCodeList = customer_code_list_;
        this.scNoList = sc_no_list_;
        
    }
    
    /** Constructor
     * @param rowSet_
     */
    public EsdSce0032EventResponse(DBRowSet rowSet_){
        this.rowSet = rowSet_;
    }
    /**
     * @return Returns the customerCodeList.
     */
    public DBRowSet getCustomer_code_list() {
        return customerCodeList;
    }

    /**
     * @return Returns the customerTpIdList.
     */
    public DBRowSet getCustomer_tp_id_list() {
        return customerTpIdList;
    }

    /**
     * @return Returns the ediCustomerGrpList.
     */
    public DBRowSet getEdi_customer_grp_list() {
        return ediCustomerGrpList;
    }

    /**
     * @return Returns the cltTpIdList.
     */
    public DBRowSet getClt_tp_id_list() {
        return cltTpIdList;
    }

    /**
     * @return Returns the scNoList.
     */
    public DBRowSet getSc_no_list() {
        return scNoList;
    }

    /** 객체 표현 문자열(EsdSce0032EventResponse)을 반환
     * @return String EsdSce32EventResponse
     */
    public String toString() {
        return "EsdSce32EventResponse";
    }

    /** 이벤트 명(EsdSce0032EventResponse)을 반환
     * @return String EsdSce32EventResponse
     */
    public String getEventName() {
        return "EsdSce32EventResponse";
    }

    /**
     * @return Returns the rowSet.
     */
    public DBRowSet getRowSet() {
        return rowSet;
    }
}
