/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf1206Event.java
*@FileTitle : Reject Reason Remarks
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.30 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_OPF_1206 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_1206HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_1206HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf1206Event extends EventSupport {

	private static final long serialVersionUID = 1L;
    
	public VopOpf1206Event(){}
    private String isPop=null;
	public String getIsPop() {
		return isPop;
	}
	public void setIsPop(String isPop) {
		this.isPop = isPop;
	}	  
}