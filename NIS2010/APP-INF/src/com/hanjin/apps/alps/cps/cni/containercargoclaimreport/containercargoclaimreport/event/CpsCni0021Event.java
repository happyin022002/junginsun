/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0021Event.java
 *@FileTitle : Occurrence Analysis
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.21
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.12.21 박제성
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.event;

import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisByAreaVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisCondVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.SettlementAnalysisCondVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.SettlementAnalysisVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0006] Occurrence Analysis
 * @author 박제성
 * @see CPS_CNI_0021HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* VO */
    private OccurrenceAnalysisCondVO occurrenceAnalysisCondVO;
    private OccurrenceAnalysisByAreaVO occurrenceAnalysisByAreaVO;
    
     
	public void setOccurrenceAnalysisCondVO(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) {
		this.occurrenceAnalysisCondVO = occurrenceAnalysisCondVO;
	}
	public OccurrenceAnalysisCondVO getOccurrenceAnalysisCondVO() {
		return occurrenceAnalysisCondVO;
	}

	public void setOccurrenceAnalysisByAreaVO(OccurrenceAnalysisByAreaVO occurrenceAnalysisByAreaVO) {
		this.occurrenceAnalysisByAreaVO = occurrenceAnalysisByAreaVO;
	}
	public OccurrenceAnalysisByAreaVO getOccurrenceAnalysisByAreaVO() {
		return occurrenceAnalysisByAreaVO;
	}

    
	
}