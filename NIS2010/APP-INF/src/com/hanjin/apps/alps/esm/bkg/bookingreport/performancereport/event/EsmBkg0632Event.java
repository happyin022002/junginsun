/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0632Event.java
*@FileTitle : Sales Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.09.01 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SaelsPerformanceReportInVO;


/**
 * ESM_BKG_0632 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0632HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0632HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBkg0632Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaelsPerformanceReportInVO caSummaryReportInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaelsPerformanceReportInVO[] caSummaryReportInVOs = null;

	public EsmBkg0632Event(){}
	
	public void setSaelsPerformanceReportInVO(SaelsPerformanceReportInVO caSummaryReportInVO){
		this. caSummaryReportInVO = caSummaryReportInVO;
	}

	public void setSaelsPerformanceReportInVOS(SaelsPerformanceReportInVO[] caSummaryReportInVOs){
		if(caSummaryReportInVOs != null){
			SaelsPerformanceReportInVO[] tmpVOs = new SaelsPerformanceReportInVO[caSummaryReportInVOs.length];
			System.arraycopy(caSummaryReportInVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.caSummaryReportInVOs = tmpVOs;
		}
	}

	public SaelsPerformanceReportInVO getSaelsPerformanceReportInVO(){
		return caSummaryReportInVO;
	}

	public SaelsPerformanceReportInVO[] getSaelsPerformanceReportInVOS(){
		SaelsPerformanceReportInVO[] rtnVOs = null;
		if (this.caSummaryReportInVOs != null) {
			rtnVOs = new SaelsPerformanceReportInVO[caSummaryReportInVOs.length];
			System.arraycopy(caSummaryReportInVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	
}