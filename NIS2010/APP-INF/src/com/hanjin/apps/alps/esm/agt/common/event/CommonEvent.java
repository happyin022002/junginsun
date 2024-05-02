/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: AGTCommonEvent.java
*@FileTitle 	: AGTCommon
*Open Issues 	:
*Change history :
*@LastModifyDate: 2006-09-28
*@LastModifier 	: junghyung kim
*@LastVersion 	: 1.0
* 2006-09-28 junghyung kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.common.event;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.html.HTMLAction;

/**
 *  1. 기능 : AGTCommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 *  2. 처리개요 : <p>
 *    - ServiceCommand Layer로 전달하는 PDTO로 사용 <p>
 * 3. 주의사항 : <p>
 * ===================================<br>
 * 4. 작성자/작성일 : junghyung kim/2006.09.18<br>
 * ===================================<br>
 * 5. 수정사항<p>
 * 5.1 요구사항 ID :<p>
 * - 수정자/수정일 :<p>
 * - 수정사유/내역 :<p>
 * ===================================<br>
 * <p/>
 *
 * @author junghyung kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class CommonEvent extends AGTEvent {
	
	private DBRowSet rowSet;
	private String year = "";
	private String month = "";
	private String week = "";
	private String frmMonth = "";
	private String toMonth = "";
	private String frmWeek = "";
	private String toWeek = "";

	
	/**
	 * 생성자 
	 */
	public CommonEvent(){}
	
	/**
	 * 변수값을 세팅한다.
	 * @param rowSet
	 */
	public CommonEvent(DBRowSet rowSet){
		this.rowSet = rowSet;
	}
	
	/**
	 * rowSet을 반환
	 * @return
	 */
	public DBRowSet getRs(){
		return rowSet;
	}
	
	/**
	 * year를 입력
	 * @param year
	 */
	public void setYear(String year){
		this.year = year;
	}
	
	/**
	 * Year을 반환 
	 * @return
	 */
	public String getYear(){
		return this.year;
	}
	
	/**
	 * Month를 입력
	 * @param month
	 */
	public void setMonth(String month){
		this.month = month;
	}
	
	/**
	 * Month를 반환
	 * @return
	 */
	public String getMonth(){
		return this.month;
	}
	
	/**
	 * Week를 입력
	 * @param week
	 */
	public void setWeek(String week){
		this.week= week;
	}
	
	/**
	 * Week를 반환
	 * @return
	 */
	public String getWeek(){
		return this.week;
	}
	
	/**
	 * from Month를 입력
	 * @param fmMonth
	 */
	public void setFrmMonth(String fmMonth){
		this.frmMonth = fmMonth;
	}
	
	/**
	 * from Month를 반환
	 * @return
	 */
	public String getFrmMonth(){
		return this.frmMonth;
	}
	
	/**
	 * to Month를 입력
	 * @param toMonth
	 */
	public void setToMonth(String toMonth){
		this.toMonth = toMonth;
	}
	
	/**
	 * to Month를 반환
	 * @return
	 */
	public String getToMonth(){
		return this.toMonth;
	}
	
	/**
	 * from Week를 입력
	 * @param fmWeek
	 */
	public void setFrmWeek(String fmWeek){
		this.frmWeek = fmWeek;
	}
	
	/**
	 * from Week를 반환
	 * @return
	 */
	public String getFrmWeek(){
		return this.frmWeek;
	}
	
	/**
	 * to Week를 입력
	 * @param toWeek
	 */
	public void setToWeek(String toWeek){
		this.toWeek = toWeek;
	}
	
	/**
	 * to Week를 반환
	 * @return
	 */
	public String getToWeek(){
		return this.toWeek;
	}

	
}