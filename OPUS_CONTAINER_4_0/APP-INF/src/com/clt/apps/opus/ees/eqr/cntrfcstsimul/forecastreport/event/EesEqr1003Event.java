/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1003Event.java
*@FileTitle : Forecast Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.event;

import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportOptionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author la sangbo
 * @see EES_CIM_5010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ForecastReportOptionVO forecastReportOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ForecastReportOptionVO[] forecastReportOptionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ForecastReportVO mtyWeeklySimulationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ForecastReportVO[] mtyWeeklySimulationVOs = null;

	public EesEqr1003Event(){}
	
	public void setForecastReportOptionVO(ForecastReportOptionVO forecastReportOptionVO){
		this. forecastReportOptionVO = forecastReportOptionVO;
	}

	public void setForecastReportOptionVOS(ForecastReportOptionVO[] forecastReportOptionVOs){
		if (forecastReportOptionVOs != null) {
			ForecastReportOptionVO[] tmpVOs = new ForecastReportOptionVO[forecastReportOptionVOs.length];
			System.arraycopy(forecastReportOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.forecastReportOptionVOs = tmpVOs;
		}
	}
	public ForecastReportOptionVO getForecastReportOptionVO(){
		return forecastReportOptionVO;
	}

	public ForecastReportOptionVO[] getForecastReportOptionVOS(){
		ForecastReportOptionVO[] tmpVOs = null;
		if (this.forecastReportOptionVOs != null) {
			tmpVOs = new ForecastReportOptionVO[forecastReportOptionVOs.length];
			System.arraycopy(forecastReportOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	
	public void setMtyWeeklySimulationVO(ForecastReportVO mtyWeeklySimulationVO){
		this. mtyWeeklySimulationVO = mtyWeeklySimulationVO;
	}

	public void setMtyWeeklySimulationVOS(ForecastReportVO[] mtyWeeklySimulationVOs){
		if (mtyWeeklySimulationVOs != null) {
			ForecastReportVO[] tmpVOs = new ForecastReportVO[mtyWeeklySimulationVOs.length];
			System.arraycopy(mtyWeeklySimulationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mtyWeeklySimulationVOs = tmpVOs;
		}
	}
	public ForecastReportVO getMtyWeeklySimulationVO(){
		return mtyWeeklySimulationVO;
	}

	public ForecastReportVO[] getMtyWeeklySimulationVOS(){
		ForecastReportVO[] tmpVOs = null;
		if (this.mtyWeeklySimulationVOs != null) {
			tmpVOs = new ForecastReportVO[mtyWeeklySimulationVOs.length];
			System.arraycopy(mtyWeeklySimulationVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
}