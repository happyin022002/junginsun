/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesEqr1081Event.java
*@FileTitle : Reposition In Detail 
*Open Issues : 
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.event;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1081ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

 
/**
 * EES_EQR_1081 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1081HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_1081HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EesEqr1081Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr1081ConditionVO eesEqr1081ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr1081ConditionVO[] eesEqr1081ConditionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ForecastReportListVO forecastReportListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public ForecastReportListVO[] forecastReportListVOs = null;

	public EesEqr1081Event(){}
	
	public void setEesEqr1081ConditionVO(EesEqr1081ConditionVO eesEqr1081ConditionVO){
		this. eesEqr1081ConditionVO = eesEqr1081ConditionVO;
	}

	public void setEesEqr1081ConditionVOS(EesEqr1081ConditionVO[] eesEqr1081ConditionVOs){
		this. eesEqr1081ConditionVOs = eesEqr1081ConditionVOs;
	}
	public EesEqr1081ConditionVO getEesEqr1081ConditionVO(){
		return eesEqr1081ConditionVO; 
	}

	public EesEqr1081ConditionVO[] getEesEqr1081ConditionVOS(){
		return eesEqr1081ConditionVOs;
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