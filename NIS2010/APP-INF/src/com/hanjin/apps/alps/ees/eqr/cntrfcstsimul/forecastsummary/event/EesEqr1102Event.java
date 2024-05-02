/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EES_EQR_1102Event.java
*@FileTitle : EQC Organization Chart
*Open Issues :
*Change history :
*@LastModifyDate : 2015-12-03
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.event;

import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1066ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQForecastSummaryINVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1102 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_1102HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesEqr1102Event extends EventSupport {
	
	private static final long serialVersionUID = 5223633691362843800L;	
	private EesEqr1066ConditionVO eesEqr1066ConditionVO = null;	
	private EQForecastSummaryINVO eQForecastSummaryINVO = null;	
	private String fcastYrwk = null;

	public String getFcastYrwk() {
		return fcastYrwk;
	}

	public void setFcastYrwk(String fcastYrwk) {
		this.fcastYrwk = fcastYrwk;
	}

	public EesEqr1066ConditionVO getEesEqr1066ConditionVO() {
		return eesEqr1066ConditionVO;
	}

	public void setEesEqr1066ConditionVO(EesEqr1066ConditionVO eesEqr1066ConditionVO) {
		this.eesEqr1066ConditionVO = eesEqr1066ConditionVO;
	}

	
	public EQForecastSummaryINVO getEQForecastSummaryINVO() {
		return eQForecastSummaryINVO;
	}

	
	public void setEQForecastSummaryINVO(EQForecastSummaryINVO eQForecastSummaryINVO) {
		this.eQForecastSummaryINVO = eQForecastSummaryINVO;
	}
	
}
