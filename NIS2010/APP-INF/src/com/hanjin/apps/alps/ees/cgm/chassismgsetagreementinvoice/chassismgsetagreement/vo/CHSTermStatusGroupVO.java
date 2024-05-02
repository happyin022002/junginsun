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

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo;

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

public class CHSTermStatusGroupVO {
	
	public String[] getHead() {
		return head;
	}

	public void setHead(String[] head) {
		this.head = head;
	}
	
    private String[] head = null;

    private List<CHSTermStatusMGTVO> chstermstatusmgtvos = null;
    
    private CHSTermStatusMGTVO       chstermstatusmgtvo = null;

	/**
	 * @return the chstermstatusmgtvos
	 */
	public List<CHSTermStatusMGTVO> getChstermstatusmgtvos() {
		return chstermstatusmgtvos;
	}

	/**
	 * @param chstermstatusmgtvos the chstermstatusmgtvos to set
	 */
	public void setChstermstatusmgtvos(List<CHSTermStatusMGTVO> chstermstatusmgtvos) {
		this.chstermstatusmgtvos = chstermstatusmgtvos;
	}

	/**
	 * @return the chstermstatusmgtvo
	 */
	public CHSTermStatusMGTVO getChstermstatusmgtvo() {
		return chstermstatusmgtvo;
	}

	/**
	 * @param chstermstatusmgtvo the chstermstatusmgtvo to set
	 */
	public void setChstermstatusmgtvo(CHSTermStatusMGTVO chstermstatusmgtvo) {
		this.chstermstatusmgtvo = chstermstatusmgtvo;
	}
    
    
}
