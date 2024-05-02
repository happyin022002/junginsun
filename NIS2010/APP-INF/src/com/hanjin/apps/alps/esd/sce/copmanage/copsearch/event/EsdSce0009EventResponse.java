/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0009Event.java
*@FileTitle : COP Mode Change
*Open Issues :
*Change history :
*@LastModifyDate : 2006-07-03
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-07-03 Se-Hoon PARK
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event;

import java.util.ArrayList;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventResponseSupport;


/**
 * EsdSce0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 *  @author Se-Hoon PARK
 *  @version v1.0.0
 *  @see COPManageSC 참조
 *  @since J2EE 1.4
 **/
public class EsdSce0009EventResponse extends EventResponseSupport {
   
	/** Database ResultSet */
    private DBRowSet  rowSet;
    private DBRowSet   rowSet2;

    /** Success Flag */
    private String successFlag;

    /** result */
    private String resultCd;
    
    private String maxCnt;
    private String[][] dataSet;
    
    // Database ResultSet
    private ArrayList list;
    
    private String ioBndCd = "";
    
    private String alertMessage = "";
    
    /**
	 * @return Returns the dataSet.
	 */
	public String[][] getDataSet() {
		return dataSet;
	}

	/**
	 * @param dataSet The dataSet to set.
	 */
	public void setDataSet(String[][] dataSet) {
		this.dataSet = dataSet;
	}

	/**
     * EsdSce0009EventResponse 객체를 생성
     */
	public EsdSce0009EventResponse() { }

	/**
     * EsdSce0009 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0009EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     */
	public EsdSce0009EventResponse(DBRowSet rowSet) {
        this.rowSet = rowSet;
    }


	/**
     * EsdSce0009 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0009EventResponse 객체를 생성
     * 
     * @param resultCd 서버 실행 결과
     * @param successFlag 성공여부
     */
    public EsdSce0009EventResponse(String resultCd, String successFlag) {
        this.resultCd = resultCd;
        this.successFlag=successFlag;
    }
    
    
    /**
     * EsdSce0009 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0009EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     * @param successFlag 성공여부
     */
    public EsdSce0009EventResponse(DBRowSet rowSet, String successFlag) {
        this.rowSet=rowSet;
        this.successFlag=successFlag;
    }
    
	/**
	 * EES_EQR_021 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EES_EQR_021EventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 * @param rowSet2 
	 * @param successFlag 성공여부
	 */
	public EsdSce0009EventResponse(DBRowSet rowSet, DBRowSet rowSet2, String successFlag) {
		this.rowSet=rowSet;
		this.rowSet2 = rowSet2;
		this.successFlag=successFlag;
	}


    /**
     * EsdSce0009 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0009EventResponse 객체를 생성
     * 
     * @param list 서버 실행 결과
     * @param successFlag 성공여부
     */
    public EsdSce0009EventResponse(ArrayList list , String successFlag) {
        this.list = list;
        this.successFlag = successFlag ;
    }
    
    
    /**
     * DBRowSet 반환작업
     * 
     * @return rowSet 서버 실행 결과
     */
    public DBRowSet getRs() {
        return this.rowSet;
    }

	/**
	 * @return rowSet2
	 */
	public DBRowSet getRs2() {
		return this.rowSet2;
	}

    /**
     * successFlag 반환작업
     * 
     * @return succesFlag
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }

    
    
    /**
     * list 반환작업
     * 
     * @return list 서버 실행 결과
     */
    public ArrayList getList() {
        return this.list;
    }
    
    
    
    /**
     * 객체 표현 문자열(EsdSce0009EventResponse)을 반환
     * 
     * @return String EsdSce0009EventResponse
     */
    public String toString() {
        return "EsdSce0009EventResponse";
    }

    /**
     * 이벤트 명(EsdSce0009EventResponse)을 반환
     * 
     * @return String EsdSce0009EventResponse
     */
    public String getEventName() {
        return "EsdSce0009EventResponse";
    }

	/**
	 * @return Returns the maxCnt.
	 */
	public String getMaxCnt() {
		return maxCnt;
	}

	/**
	 * @param maxCnt The maxCnt to set.
	 */
	public void setMaxCnt(String maxCnt) {
		this.maxCnt = maxCnt;
	}

	/**
	 * @return Returns the resultCd.
	 */
	public String getResultCd() {
		return resultCd;
	}

	/**
	 * @param resultCd The resultCd to set.
	 */
	public void setResultCd(String resultCd) {
		this.resultCd = resultCd;
	}

	/**
	 * @return Returns the rowSet.
	 */
	public DBRowSet getRowSet() {
		return rowSet;
	}

	/**
	 * @param rowSet The rowSet to set.
	 */
	public void setRowSet(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}

	/**
	 * @return Returns the rowSet2.
	 */
	public DBRowSet getRowSet2() {
		return rowSet2;
	}

	/**
	 * @param rowSet2 The rowSet2 to set.
	 */
	public void setRowSet2(DBRowSet rowSet2) {
		this.rowSet2 = rowSet2;
	}

	/**
	 * @param list The list to set.
	 */
	public void setList(ArrayList list) {
		this.list = list;
	}

	/**
	 * @param successFlag The successFlag to set.
	 */
	public void setSuccessFlag(String successFlag) {
		this.successFlag = successFlag;
	}

	public String getAlertMessage() {
		return alertMessage;
	}

	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}

	/**
	 * @return Returns the ioBndCd.
	 */
	public String getIoBndCd() {
		return ioBndCd;
	}

	/**
	 * @param ioBndCd The ioBndCd to set.
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

}