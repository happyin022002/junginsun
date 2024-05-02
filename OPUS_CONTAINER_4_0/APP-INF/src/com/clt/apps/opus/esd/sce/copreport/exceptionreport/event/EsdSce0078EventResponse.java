/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce001EventResponse.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*2008-07-01: rowSize추가
*@LastModifyDate : 2008-07-01
*@LastModifier : Hun-Il Jung
*@LastVersion : 1.1
* 2006-11-20 minestar
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.exceptionreport.event;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.support.layer.event.EventResponseSupport;

/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EsdSce071 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EsdSce071 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author minestar
 * @see
 * @since J2EE 1.4
 */
@SuppressWarnings("deprecation")
public class EsdSce0078EventResponse extends EventResponseSupport {
	private static final long serialVersionUID = 1L;

	// Database ResultSet
    private DBRowSet   rowSet;
    
    // 총개수
    // Exception Noti Failure Report  rowsize추가 &&&
    private int totalCount ;     

    // Success Flag
    private String successFlag;

    /**
     * EsdSce0078EventResponse 객체를 생성
     */
    public EsdSce0078EventResponse() {
    }

    /**
     * EsdSce002 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce002EventResponse 객체를 생성
     *
     * @param rowSet 서버 실행 결과
     * @param successFlag 성공여부
     */
    public EsdSce0078EventResponse(DBRowSet rowSet, String successFlag) {
        this.rowSet = rowSet;
        this.successFlag = successFlag ;
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
     * return SuccessFlg
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }
    
    /**
     * 객체 표현 문자열(EsdSce0078EventResponse)을 반환
     *
     * @return String EsdSce0078EventResponse
     */
    public String toString() {
        return "EsdSce0078EventResponse";
    }

    /**
     * 이벤트 명(EsdSce0078EventResponse)을 반환
     *
     * @return String EsdSce0078EventResponse
     */
    public String getEventName() {
        return "EsdSce0078EventResponse";
    }
    
    /**
     * EsdSce0078 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아<br>
     * EsdSce0078EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     * @param totalCount 총개수
     * @param successFlag 성공여부 &&&
     */
    public EsdSce0078EventResponse(DBRowSet rowSet, int totalCount, String successFlag) {
        this.rowSet=rowSet;
        this.totalCount = totalCount ;
        this.successFlag=successFlag;
    }
    
    /**
     * 총개수 반환작업 &&&
     * 
     * @return totalCount 서버 실행 결과
     */
    public int getTotalCount() {
        return this.totalCount;
    }    

}