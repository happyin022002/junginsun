/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesEqr1083Event.java
*@FileTitle : Reposition Out Detail 
*Open Issues : 
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.event;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1083ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

 
/**
 * EES_EQR_1083 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1083HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_1083HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EesEqr1083Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr1083ConditionVO eesEqr1083ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr1083ConditionVO[] eesEqr1083ConditionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ForecastReportListVO forecastReportListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public ForecastReportListVO[] forecastReportListVOs = null;

	public EesEqr1083Event(){}
	
	public void setEesEqr1083ConditionVO(EesEqr1083ConditionVO eesEqr1083ConditionVO){
		this. eesEqr1083ConditionVO = eesEqr1083ConditionVO;
	}

	public void setEesEqr1083ConditionVOS(EesEqr1083ConditionVO[] eesEqr1083ConditionVOs){
		this. eesEqr1083ConditionVOs = eesEqr1083ConditionVOs;
	}
	public EesEqr1083ConditionVO getEesEqr1083ConditionVO(){
		return eesEqr1083ConditionVO;
	}

	public EesEqr1083ConditionVO[] getEesEqr1083ConditionVOS(){
		return eesEqr1083ConditionVOs;
	}
	
	
	public void setForecastReportListVO(ForecastReportListVO forecastReportListVO){
		this. forecastReportListVO = forecastReportListVO;
	}

	public void setForecastReportListVOS(ForecastReportListVO[] forecastReportListVOs){
		this. forecastReportListVOs = forecastReportListVOs;
	}
	public ForecastReportListVO getForecastReportListVO(){
		return forecastReportListVO;
	}

	public ForecastReportListVO[] getForecastReportListVOS(){
		return forecastReportListVOs; 
	}	
}