/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VopVsk2507Event.java
*@FileTitle : File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.20
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2013.03.20 정상기
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.event;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.TerminalHandlingInfoAttachFileVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_VSK_2507 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_2507HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong Sang-Ki
 * @see VOP_VSK_2507HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk2507Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TerminalHandlingInfoAttachFileVO 	terminalHandlingInfoAttachFileVO 	= null;
	
	/** Table Value Object Multi Data 처리 */
	private TerminalHandlingInfoAttachFileVO[] 	terminalHandlingInfoAttachFileVOs 	= null;
	/*
	private HttpServletRequest request = null;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	 */
	public VopVsk2507Event(){}
	
	public void setTerminalHandlingInfoAttachFileVO(TerminalHandlingInfoAttachFileVO terminalHandlingInfoAttachFileVO){
		this. terminalHandlingInfoAttachFileVO = terminalHandlingInfoAttachFileVO;
	}

	public void setTerminalHandlingInfoAttachFileVOS(TerminalHandlingInfoAttachFileVO[] terminalHandlingInfoAttachFileVOs){
		if(terminalHandlingInfoAttachFileVOs != null){
			TerminalHandlingInfoAttachFileVO[] tmpVOs = new TerminalHandlingInfoAttachFileVO[terminalHandlingInfoAttachFileVOs.length];
			System.arraycopy(terminalHandlingInfoAttachFileVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.terminalHandlingInfoAttachFileVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this. terminalHandlingInfoAttachFileVOs = terminalHandlingInfoAttachFileVOs;
	}

	public TerminalHandlingInfoAttachFileVO getTerminalHandlingInfoAttachFileVO(){
		return terminalHandlingInfoAttachFileVO;
	}

	public TerminalHandlingInfoAttachFileVO[] getTerminalHandlingInfoAttachFileVOS(){
		TerminalHandlingInfoAttachFileVO[] rtnVOs =  null;
		if(this.terminalHandlingInfoAttachFileVOs != null){
			rtnVOs = new TerminalHandlingInfoAttachFileVO[terminalHandlingInfoAttachFileVOs.length];
			System.arraycopy(terminalHandlingInfoAttachFileVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return terminalHandlingInfoAttachFileVOs;
	}

}