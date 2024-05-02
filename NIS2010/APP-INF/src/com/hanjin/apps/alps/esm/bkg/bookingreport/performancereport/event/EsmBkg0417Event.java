/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0417Event.java
*@FileTitle : Port Closing Report (for Branch Office)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.11 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.PortCLSReportVO;


/**
 * ESM_BKG_0417 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0417HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0417HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBkg0417Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortCLSReportVO portCLSReportVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortCLSReportVO[] portCLSReportVOs = null;

	public EsmBkg0417Event(){}
	
	public void setPortCLSReportVO(PortCLSReportVO portCLSReportVO){
		this. portCLSReportVO = portCLSReportVO;
	}

	public void setPortCLSReportVOS(PortCLSReportVO[] portCLSReportVOs){
		if(portCLSReportVOs != null){
			PortCLSReportVO[] tmpVOs = new PortCLSReportVO[portCLSReportVOs.length];
			System.arraycopy(portCLSReportVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.portCLSReportVOs = tmpVOs;
		}
	}

	public PortCLSReportVO getPortCLSReportVO(){
		return portCLSReportVO;
	}

	public PortCLSReportVO[] getPortCLSReportVOS(){
		PortCLSReportVO[] rtnVOs = null;
		if (this.portCLSReportVOs != null) {
			rtnVOs = new PortCLSReportVO[portCLSReportVOs.length];
			System.arraycopy(portCLSReportVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	
}