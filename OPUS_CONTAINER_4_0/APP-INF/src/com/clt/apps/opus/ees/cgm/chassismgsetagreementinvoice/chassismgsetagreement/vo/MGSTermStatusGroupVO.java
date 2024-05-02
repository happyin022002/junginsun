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

package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo;

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

public class MGSTermStatusGroupVO {
	
	public String[] getHead() {
		return head;
	}

	public void setHead(String[] head) {
		this.head = head;
	}
	
    private String[] head = null;

    private List<MGSTermStatusMGTVO> mgstermstatusmgtvos = null;
    
    private MGSTermStatusMGTVO       mgstermstatusmgtvo = null;

	/**
	 * @return the mgstermstatusmgtvos
	 */
	public List<MGSTermStatusMGTVO> getMgstermstatusmgtvos() {
		return mgstermstatusmgtvos;
	} 

	/**
	 * @param mgstermstatusmgtvos the mgstermstatusmgtvos to set
	 */
	public void setMgstermstatusmgtvos(List<MGSTermStatusMGTVO> mgstermstatusmgtvos) {
		this.mgstermstatusmgtvos = mgstermstatusmgtvos;
	}

	/**
	 * @return the mgstermstatusmgtvo
	 */
	public MGSTermStatusMGTVO getMgstermstatusmgtvo() {
		return mgstermstatusmgtvo;
	}

	/**
	 * @param mgstermstatusmgtvo the mgstermstatusmgtvo to set
	 */
	public void setMgstermstatusmgtvo(MGSTermStatusMGTVO mgstermstatusmgtvo) {
		this.mgstermstatusmgtvo = mgstermstatusmgtvo;
	}



    
    
}
