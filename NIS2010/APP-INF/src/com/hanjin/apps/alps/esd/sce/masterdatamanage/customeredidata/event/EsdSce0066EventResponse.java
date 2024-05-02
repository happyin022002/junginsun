/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0035EventResponse.java
*@FileTitle : EsdSce0035
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-26
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import java.util.HashMap;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * EsdSce0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yong-cheon Shin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsdSce0066EventResponse  extends EventResponseSupport  {
    
    private DBRowSet rowSet = null;
    private String resultCd = "";
    
    /** Constructor
     * @param rowSet_
     */
    public EsdSce0066EventResponse(DBRowSet rowSet_){
        this.rowSet = rowSet_;
    }
    
    /** Constructor
     * @param resultCd_
     */
    public EsdSce0066EventResponse(String resultCd_){
    	this.resultCd = resultCd_;
    }
    /**
     * @return
     */
    public String getResultCd() {
		return resultCd;
	}

	
    /** 객체 표현 문자열(EdiSendEventResponse)을 반환
     * @return String EsdSce0066EventResponse
     */
    public String toString() {
        return "EsdSce0066EventResponse";
    }

    /** 이벤트 명(EdiSendEventResponse)을 반환
     * @return String EsdSce0066EventResponse
     */
    public String getEventName() {
        return "EsdSce0066EventResponse";
    }

    /**
     * @return Returns the rowSet.
     */
    public DBRowSet getRowSet() {
        return rowSet;
    }
}
