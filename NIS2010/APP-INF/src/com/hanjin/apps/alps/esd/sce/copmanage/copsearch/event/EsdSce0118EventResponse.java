/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdSce0118EventResponse.java
*@FileTitle : EsdSce0118
*Open Issues :
*Change history :
*@LastModifyDate : 2008-08-01
*@LastModifier : sanghyun_kim
*@LastVersion : 1.0
* 2008-08-01 sanghyun_kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event;

import java.util.HashMap;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.support.layer.event.EventResponseSupport;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EsdSce0118 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EsdSce0118 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author sanghyun_kim
 * @see COPManageSC 참조
 * @since J2EE 1.4
 */
public class EsdSce0118EventResponse extends EventResponseSupport {
	private DBRowSet rowSet = null;
    private String resultCd = "";
    private int count = 0;
    private String trspSoOfcCtyCd = "";
    private String trspSoSeq = "";

    /** Constructor
     * @param rowSet_
     */
    public EsdSce0118EventResponse(DBRowSet rowSet_){
        this.rowSet = rowSet_;
    }
    /**
     * @param count_
     */
    public EsdSce0118EventResponse(int count_){
    	this.count = count_;
    }
    /**
     * @return resultCd
     */
    public String getResultCd() {
		return resultCd;
	}

    /** 객체 표현 문자열(EdiSendEventResponse)을 반환
     * @return String EsdSce0118EventResponse
     */
    public String toString() {
        return "EsdSce0118EventResponse";
    }

    /** 이벤트 명(EdiSendEventResponse)을 반환
     * @return String EsdSce0118EventResponse
     */
    public String getEventName() {
        return "EsdSce0118EventResponse";
    }

    /**
     * @return Returns the rowSet.
     */
    public DBRowSet getRowSet() {
        return rowSet;
    }
    /**
     * @return
     */
    public int getCount() {
		return count;
	}
    /**
     * @param count
     */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @param map
	 */
	public EsdSce0118EventResponse(HashMap map){
		this.trspSoOfcCtyCd = JSPUtil.getNull((String)map.get("trsp_so_ofc_cty_cd"));
        this.trspSoSeq = JSPUtil.getNull((String)map.get("trsp_so_seq"));
	}
}
