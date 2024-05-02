/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: LEACommonEvent.java
*@FileTitle 	: LEACommon
*Open Issues 	:
*Change history :
*@LastModifyDate: 2006-09-28
*@LastModifier 	: junghyung kim
*@LastVersion 	: 1.0
* 2006-09-28 junghyung kim
* 1.0 최초 생성
* * * @History
* 2011-05-02 이정수 : Office COMBO가 정상적으로 생성되도록 수정
=========================================================*/
package com.hanjin.apps.alps.esd.lea.common.codecomboutil.event;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.html.HTMLAction;

/**
 *  1. 기능 : LEACommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
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
public class CommonEvent extends LEAEvent {
	
	private DBRowSet rowSet;
	
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

}