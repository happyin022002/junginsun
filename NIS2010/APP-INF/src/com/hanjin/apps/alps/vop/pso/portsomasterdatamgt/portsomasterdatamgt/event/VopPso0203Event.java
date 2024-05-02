/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiPso0203Event.java
*@FileTitle : Bank Information 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.04.30 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_PSO-0203 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_PSO-0203HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see UI_PSO-0203HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopPso0203Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private int vndrSeq = -1;//mdm_vendor의 pk인 vndr_seq값

	public int getVndrSeq() {
		return vndrSeq;
	}

	public void setVndrSeq(int vndrSeq) {
		// TODO Auto-generated method stub
		this.vndrSeq  = vndrSeq;
	}
	
}