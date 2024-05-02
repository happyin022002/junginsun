/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0006EventResponse.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-30
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-30 Seong-mun Kang
* 1.0 최초 생성
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventResponseSupport;



/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EsdSce0006 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EsdSce0006 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author Seong-mun Kang
 * @see COPManageSC 참조
 * @since J2EE 1.4
 */
public class EsdSce0006EventResponse extends EventResponseSupport {

    private DBRowSet         rowSet;
    private String           dlvPlnDt;
    private String           dlvDstmDt;
    private String           totTranPlnDt;
    private String           totTranEstmDt;
    private String           copSts ;
    private String           successFlag;
    private String           dueDt;
    private String           appmnt;
    private String 			 stsNm;
    private String 			 obDrDate;
    private String 			 ibDrDate;

    /**
	 * @return Returns the stsNm.
	 */
	public String getStsNm() {
		return stsNm;
	}

	/**
	 * @param stsNm The stsNm to set.
	 */
	public void setStsNm(String stsNm) {
		this.stsNm = stsNm;
	}

	/**
	 * @return Returns the appmnt.
	 */
	public String getAppmnt() {
		return appmnt;
	}

	/**
	 * @param appmnt The appmnt to set.
	 */
	public void setAppmnt(String appmnt) {
		this.appmnt = appmnt;
	}

	/**
	 * @return Returns the dueDt.
	 */
	public String getDueDt() {
		return dueDt;
	}

	/**
	 * @param dueDt The dueDt to set.
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}

	/**
	 * @return Returns the dueDt.
	 */
	public String getObDrDate() {
		return this.obDrDate;
	}

	/**
	 * @param dueDt The dueDt to set.
	 */
	public void setObDrDate(String drDate) {
		this.obDrDate = drDate;
	}	
	
	/**
	 * @return Returns the dueDt.
	 */
	public String getIbDrDate() {
		return this.ibDrDate;
	}

	/**
	 * @param dueDt The dueDt to set.
	 */
	public void setIbDrDate(String drDate) {
		this.ibDrDate = drDate;
	}	
	
	/**
     * EsdSce0006EventResponse 객체를 생성
     */
    public EsdSce0006EventResponse() {
    }

    /**
     * EsdSce0006 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0006EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     */
    public EsdSce0006EventResponse(DBRowSet rowSet) {
        this.rowSet = rowSet;
    }
    
    /**
     * EsdSce0006 요청을 처리한 서버 실행 결과(DB ResultSet)와 <br>
     * 성공여부(successFlag)를 담아 EsdSce0006EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     * @param successFlag 성공여부
     */
    public EsdSce0006EventResponse(DBRowSet rowSet, String successFlag) {
        this.rowSet=rowSet;
        this.successFlag=successFlag;
    }
    
    /**
     * EsdSce0006 요청을 처리한 서버 실행 결과(DB ResultSet)와 <br>
     * 성공여부(successFlag)를 담아 EsdSce0006EventResponse 객체를 생성
     * 
     * @param copSts 서버 실행 결과
     * @param successFlag 성공여부
     */
    public EsdSce0006EventResponse(String copSts, String successFlag) {
        this.copSts=copSts;
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
     * DB ResultSet 반환작업
     * 
     * @return DBRowSet 서버 실행 결과
     */
    public String getDlvPlnDT() {
        return this.dlvPlnDt;
    }
    
    /**
     * DB ResultSet 반환작업
     * 
     * @return String 서버 실행 결과
     */
    public String getDlvEstmDT() {
        return this.dlvDstmDt;
    }
    
    /**
     * DB ResultSet 반환작업
     * 
     * @return String 서버 실행 결과
     */
    public String getTotTranPlnDT() {
        return this.totTranPlnDt;
    }
    
    /**
     * DB ResultSet 반환작업
     * 
     * @return String 서버 실행 결과
     */
    public String getTotTranEstmDT() {
        return this.totTranEstmDt;
    }
    
    /**
     * DB ResultSet 반환작업
     * 
     * @return String 서버 실행 결과
     */
    public String getCOPStatus() {
        return this.copSts;
    }
    
    /**
     * @return successFlag
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }

    /**
     * 객체 표현 문자열(EsdSce0006EventResponse)을 반환
     * 
     * @return String EsdSce0006EventResponse
     */
    public String toString() {
        return "EsdSce0006EventResponse";
    }

    /**
     * 이벤트 명(EsdSce0006EventResponse)을 반환
     * 
     * @return String EsdSce0006EventResponse
     */
    public String getEventName() {
        return "EsdSce0006EventResponse";
    }

}