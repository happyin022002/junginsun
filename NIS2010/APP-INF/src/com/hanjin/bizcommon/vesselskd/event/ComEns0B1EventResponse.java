/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_0B1EventResponse.java
*@FileTitle : Vessel SKD조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-07
*@LastModifier : Hyunsu, Ryu
*@LastVersion : 1.0
* 2006-08-07 Hyunsu, Ryu
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.vesselskd.event;

import com.hanjin.bizcommon.BizCommonSC;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventResponseSupport;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - COM_ENS_0B1 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - COM_ENS_0B1 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author Hyunsu, Ryu
 * @see BizCommonSC 참조
 * @since J2EE 1.4
 */
public class ComEns0B1EventResponse extends EventResponseSupport {

    // Database ResultSet
    private DBRowSet   rowSet;

    // Success Flag
    private String successFlag;
    
    private int cnt = 0;


    /**
     * COM_ENS_0B1EventResponse 객체를 생성
     */
    public ComEns0B1EventResponse() {
    }

    /**
     * COM_ENS_0B1 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 COM_ENS_0B1EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     */
    public ComEns0B1EventResponse(DBRowSet rowSet) {
        this.rowSet = rowSet;
    }

    /**
     * COM_ENS_0B1 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 COM_ENS_0B1EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     * @param successFlag 성공여부
     */
    public ComEns0B1EventResponse(DBRowSet rowSet, String successFlag) {
        this.rowSet=rowSet;
        this.successFlag=successFlag;
    }

    /**
     * DB ResultSet 반환작업
     * 
     * @return DBRowSet 서버 실행 결과
     */
    public DBRowSet getRs() {
        return this.rowSet;
    }

    /**
     * SuccessFlg 반환<br>
     * @return 
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }

    /**
     * 객체 표현 문자열(COM_ENS_0B1EventResponse)을 반환
     * 
     * @return String COM_ENS_0B1EventResponse
     */
    public String toString() {
        return "COM_ENS_0B1EventResponse";
    }

    /**
     * 이벤트 명(COM_ENS_0B1EventResponse)을 반환
     * 
     * @return String COM_ENS_0B1EventResponse
     */
    public String getEventName() {
        return "COM_ENS_0B1EventResponse";
    }
    
	/**
	 * Count 반환<br>
	 * @return
	 */
	public int getCnt() {
		return cnt;
	}
	
	/**
	 * Count 세팅<br>
	 * @param cnt
	 */
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

}