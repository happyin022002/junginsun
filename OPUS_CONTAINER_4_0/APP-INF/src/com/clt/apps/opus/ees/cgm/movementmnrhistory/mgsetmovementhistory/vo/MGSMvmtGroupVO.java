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

package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSMvmtGroupVO {
	
	public String[] getHead() {
		return head;
	}

	public void setHead(String[] head) {
		this.head = head;
	}
	
    private String[] head = null;

    List<MGSMvmtHistoryMGTVO>  mgsmvmthistorymgtvo   = null;
    List<MGSMvmtHistoryMGTVO>  mgsmvmthistorymgtvo2  = null;
    List<MGSMvmtHistoryMGTVO>  mgsmvmthistorymgtvo3  = null;
	
    public List<MGSMvmtHistoryMGTVO> getMgsmvmthistorymgtvo() {
		return mgsmvmthistorymgtvo;
	}

	public void setMgsmvmthistorymgtvo(List<MGSMvmtHistoryMGTVO> mgsmvmthistorymgtvo) {
		this.mgsmvmthistorymgtvo = mgsmvmthistorymgtvo;
	}

	public List<MGSMvmtHistoryMGTVO> getMgsmvmthistorymgtvo2() {
		return mgsmvmthistorymgtvo2;
	}

	public void setMgsmvmthistorymgtvo2(
			List<MGSMvmtHistoryMGTVO> mgsmvmthistorymgtvo2) {
		this.mgsmvmthistorymgtvo2 = mgsmvmthistorymgtvo2;
	}

	public List<MGSMvmtHistoryMGTVO> getMgsmvmthistorymgtvo3() {
		return mgsmvmthistorymgtvo3;
	}

	public void setMgsmvmthistorymgtvo3(
			List<MGSMvmtHistoryMGTVO> mgsmvmthistorymgtvo3) {
		this.mgsmvmthistorymgtvo3 = mgsmvmthistorymgtvo3;
	}
	
}
