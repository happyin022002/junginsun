/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopOpf9036Event.java
*@FileTitle : File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.21
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2011.06.21 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfTdrAtchFileVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_OPF_9036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_9036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song HoJin
 * @see VOP_OPF_9036HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf9036Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfTdrAtchFileVO opfTdrAtchFileVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfTdrAtchFileVO[] opfTdrAtchFileVOs = null;
	/*
	private HttpServletRequest request = null;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	 */
	public VopOpf9036Event(){}
	
	public void setOpfTdrAtchFileVO(OpfTdrAtchFileVO opfTdrAtchFileVO){
		this. opfTdrAtchFileVO = opfTdrAtchFileVO;
	}

	public void setOpfTdrAtchFileVOS(OpfTdrAtchFileVO[] opfTdrAtchFileVOs){
		if (opfTdrAtchFileVOs != null) {
			OpfTdrAtchFileVO[] tmpVOs = new OpfTdrAtchFileVO[opfTdrAtchFileVOs.length];
			System.arraycopy(opfTdrAtchFileVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfTdrAtchFileVOs = tmpVOs;
		}
	}

	public OpfTdrAtchFileVO getOpfTdrAtchFileVO(){
		return opfTdrAtchFileVO;
	}

	public OpfTdrAtchFileVO[] getOpfTdrAtchFileVOS(){
		OpfTdrAtchFileVO[] rtnVOs = null;

 		if (this.opfTdrAtchFileVOs != null) {
 			rtnVOs = new OpfTdrAtchFileVO[opfTdrAtchFileVOs.length];
 			System.arraycopy(opfTdrAtchFileVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

}