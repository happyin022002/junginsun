/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs0114Event.java
*@FileTitle : S/P Performace Comparison Report
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-18
*@LastModifier : CJH
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.event;

import com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.vo.ComparisonCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_0114 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_0114HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CJH
 * @see ESD_TRS_0114HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs0114Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComparisonCondVO comparisonCondVO = null;
	
	public EsdTrs0114Event(){}

	public ComparisonCondVO getComparisonCondVO() {
		return comparisonCondVO;
	}

	public void setComparisonCondVO(ComparisonCondVO comparisonCondVO) {
		this.comparisonCondVO = comparisonCondVO;
	}

}
