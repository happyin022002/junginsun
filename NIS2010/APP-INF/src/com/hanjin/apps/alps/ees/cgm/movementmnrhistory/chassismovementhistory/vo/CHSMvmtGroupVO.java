/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolMvmtINVO.java
*@FileTitle : PoolMvmtINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.12 최민회 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSMvmtGroupVO {
	
	public String[] getHead() {
		return head;
	}

	public void setHead(String[] head) {
		this.head = head;
	}
	
    private String[] head = null;

    List<CHSMvmtHistoryMGTVO>  chsmvmthistorymgtvo   = null;
    List<CHSMvmtHistoryMGTVO>  chsmvmthistorymgtvo2  = null;
    List<CHSMvmtHistoryMGTVO>  chsmvmthistorymgtvo3  = null;
	/**
	 * @return the chsmvmthistorymgtvo
	 */
	public List<CHSMvmtHistoryMGTVO> getChsmvmthistorymgtvo() {
		return chsmvmthistorymgtvo;
	}

	/**
	 * @param chsmvmthistorymgtvo the chsmvmthistorymgtvo to set
	 */
	public void setChsmvmthistorymgtvo(List<CHSMvmtHistoryMGTVO> chsmvmthistorymgtvo) {
		this.chsmvmthistorymgtvo = chsmvmthistorymgtvo;
	}

	/**
	 * @return the chsmvmthistorymgtvo2
	 */
	public List<CHSMvmtHistoryMGTVO> getChsmvmthistorymgtvo2() {
		return chsmvmthistorymgtvo2;
	}

	/**
	 * @param chsmvmthistorymgtvo2 the chsmvmthistorymgtvo2 to set
	 */
	public void setChsmvmthistorymgtvo2(
			List<CHSMvmtHistoryMGTVO> chsmvmthistorymgtvo2) {
		this.chsmvmthistorymgtvo2 = chsmvmthistorymgtvo2;
	}

	/**
	 * @return the chsmvmthistorymgtvo3
	 */
	public List<CHSMvmtHistoryMGTVO> getChsmvmthistorymgtvo3() {
		return chsmvmthistorymgtvo3;
	}

	/**
	 * @param chsmvmthistorymgtvo3 the chsmvmthistorymgtvo3 to set
	 */
	public void setChsmvmthistorymgtvo3(
			List<CHSMvmtHistoryMGTVO> chsmvmthistorymgtvo3) {
		this.chsmvmthistorymgtvo3 = chsmvmthistorymgtvo3;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
