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
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SaelsPerformanceReportInVO;
import com.clt.framework.support.layer.event.EventSupport;


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
			SaelsPerformanceReportInVO[] tmpVOs = Arrays.copyOf(caSummaryReportInVOs, caSummaryReportInVOs.length);
			this.caSummaryReportInVOs = tmpVOs;
		}
	}

	public SaelsPerformanceReportInVO getSaelsPerformanceReportInVO(){
		return caSummaryReportInVO;
	}

	public SaelsPerformanceReportInVO[] getSaelsPerformanceReportInVOS(){
		SaelsPerformanceReportInVO[] rtnVOs = null;
		if(this.caSummaryReportInVOs != null){
			rtnVOs= Arrays.copyOf(caSummaryReportInVOs, caSummaryReportInVOs.length);
		}
		return rtnVOs;
	}

}