/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0105Event.java
*@FileTitle : Total Loss Payment to Lessor Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.06 민정호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossLessorReportINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossLessorReportVO;


/**
 * EES_MNR_0105 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0105HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MNR_0105HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0105Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TotalLossLessorReportINVO totalLossLessorReportINVO = null;

	/** Table Value Object Multi Data 처리 */
	private TotalLossLessorReportVO[] totalLossLessorReportVOs = null;

	public EesMnr0105Event(){}

	public void setTotalLossLessorReportINVO(TotalLossLessorReportINVO totalLossLessorReportINVO){
		this. totalLossLessorReportINVO = totalLossLessorReportINVO;
	}

	public void setTotalLossLessorReportVOS(TotalLossLessorReportVO[] totalLossLessorReportVOs){
		if(totalLossLessorReportVOs != null){
			TotalLossLessorReportVO[] tmpVOs = java.util.Arrays.copyOf(totalLossLessorReportVOs, totalLossLessorReportVOs.length);
			this.totalLossLessorReportVOs = tmpVOs;
		}
	}

	public TotalLossLessorReportINVO getTotalLossLessorReportINVO(){
		return totalLossLessorReportINVO;
	}

	public TotalLossLessorReportVO[] getTotalLossLessorReportVOS(){
		TotalLossLessorReportVO[] rtnVOs = null;
		if (this.totalLossLessorReportVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(totalLossLessorReportVOs, totalLossLessorReportVOs.length);
		}
		return rtnVOs;
	}

}