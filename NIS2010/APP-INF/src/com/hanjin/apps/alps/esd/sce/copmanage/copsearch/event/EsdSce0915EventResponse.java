/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0915EventResponse.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-20
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-20 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventResponseSupport;


/**
 *  1. 기능 : RDTO(Data Transfer Object including DB ResultSet) <p>
 *  2. 처리개요 : <p>
 *    - EsdSce0915 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object <p>
 *    - EsdSce0915 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환 <p>
 * 3. 주의사항 : <p>
 * ===================================<br>
 * 4. 작성자/작성일 : Se-Hoon PARK/2006.07.03<br>
 * ===================================<br>
 * 5. 수정사항<p>
 * 5.1 요구사항 ID :<p>
 * - 수정자/수정일 :<p>
 * - 수정사유/내역 :<p>
 * ===================================<br>
 * <p/>
 *  @author Se-Hoon PARK
 *  @version v1.0.0
 *  @see COPManageSC 참조
 *  @since J2EE 1.4
 **/
public class EsdSce0915EventResponse extends EventResponseSupport {
   
	/** Database ResultSet */
    private DBRowSet  rowSet;
    private DBRowSet  rowSetVVD;

    /** Success Flag */
    private String successFlag;

    
   /**
     * Constructor
     **/
	public EsdSce0915EventResponse() { }

	
	/**
	 * Constructor
     * @param DBRowSet rowSet
     */
	public EsdSce0915EventResponse(DBRowSet rowSet) {
        this.rowSet = rowSet;
    }

	/** 
	 * Constructor
     * @param DBRowSet rowSet
     * @param DBRowSet rowSetVVD
     */
    public EsdSce0915EventResponse(DBRowSet rowSet, DBRowSet rowSetVVD) {
        this.rowSet = rowSet;
        this.rowSetVVD = rowSetVVD;
    }


   /**
     * Constructor
     * @param DBRowSet rowSet
     * @param String successFlag
	 **/
    public EsdSce0915EventResponse(DBRowSet rowSet, String successFlag) {
        this.rowSet=rowSet;
        this.successFlag=successFlag;
    }


   /**
     * return rowSet
     * @return DBRowSet
	 **/
    public DBRowSet getRs() {
        return this.rowSet;
    }
    
    /**
     * return rowSetVVD
     * @return DBRowSet
	 **/
    public DBRowSet getRsVVD() {
        return this.rowSetVVD;
    }

    /**
     * return SuccessFlg
     * @return String
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }

   /**
     * 객체 표현 문자열 반환작업<p>
     * @return String
	 **/
    public String toString() {
        return "EsdSce0915EventResponse";
    }

   /**
     * 이벤트 명 반환작업<p>
     * @return String
	 **/
    public String getEventName() {
        return "EsdSce0915EventResponse";
    }

}