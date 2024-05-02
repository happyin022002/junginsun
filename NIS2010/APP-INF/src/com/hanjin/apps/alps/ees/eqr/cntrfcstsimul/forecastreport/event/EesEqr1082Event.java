/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesEqr1082Event.java
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

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1082ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

 
/**
 * EES_EQR_1082 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1082HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_1082HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EesEqr1082Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr1082ConditionVO eesEqr1082ConditionVO = null;
	 
	/** Table Value Object Multi Data 처리 */
	public EesEqr1082ConditionVO[] eesEqr1082ConditionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ForecastReportListVO forecastReportListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public ForecastReportListVO[] forecastReportListVOs = null;

	public EesEqr1082Event(){}
	
	public void setEesEqr1082ConditionVO(EesEqr1082ConditionVO eesEqr1082ConditionVO){
		this. eesEqr1082ConditionVO = eesEqr1082ConditionVO;
	}

	public void setEesEqr1082ConditionVOS(EesEqr1082ConditionVO[] eesEqr1082ConditionVOs){
		this. eesEqr1082ConditionVOs = eesEqr1082ConditionVOs;
	}
	public EesEqr1082ConditionVO getEesEqr1082ConditionVO(){
		return eesEqr1082ConditionVO;
	}

	public EesEqr1082ConditionVO[] getEesEqr1082ConditionVOS(){
		return eesEqr1082ConditionVOs;
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