/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0037EventResponse.java
*@FileTitle : EsdSce0037
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
 * EsdSce0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yong-cheon Shin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("deprecation")
public class EsdSce0037EventResponse  extends EventResponseSupport  {
	private static final long serialVersionUID = 1L;
	
	private DBRowSet rowSet = null;
    
    /** Constructor
     * @param rowSet_
     */
    public EsdSce0037EventResponse(DBRowSet rowSet_){
        this.rowSet = rowSet_;
    }
    /** 객체 표현 문자열(EdiSendEventResponse)을 반환
     * @return String EsdSce37EventResponse
     */
    public String toString() {
        return "EsdSce0037EventResponse";
    }

    /** 이벤트 명(EdiSendEventResponse)을 반환
     * @return String EsdSce37EventResponse
     */
    public String getEventName() {
        return "EsdSce0037EventResponse";
    }
    /**
     * @return Returns the rowSet.
     */
    public DBRowSet getRowSet() {
        return rowSet;
    }
}
