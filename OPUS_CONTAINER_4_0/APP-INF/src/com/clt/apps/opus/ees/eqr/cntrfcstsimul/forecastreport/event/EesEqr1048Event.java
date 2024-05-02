/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1048Event.java
*@FileTitle : Discharging List (Forecast Report) 
*Open Issues : 
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.event;

import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1048ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportListVO;
import com.clt.framework.support.layer.event.EventSupport;

 
/**
 * EES_EQR_1048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_1048HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EesEqr1048Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr1048ConditionVO eesEqr1048ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EesEqr1048ConditionVO[] eesEqr1048ConditionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ForecastReportListVO forecastReportListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ForecastReportListVO[] forecastReportListVOs = null;

	public EesEqr1048Event(){}
	
	public void setEesEqr1048ConditionVO(EesEqr1048ConditionVO eesEqr1048ConditionVO){
		this. eesEqr1048ConditionVO = eesEqr1048ConditionVO;
	}

	public void setEesEqr1048ConditionVOS(EesEqr1048ConditionVO[] eesEqr1048ConditionVOs){
		if (eesEqr1048ConditionVOs != null) {
			EesEqr1048ConditionVO[] tmpVOs = new EesEqr1048ConditionVO[eesEqr1048ConditionVOs.length];
			System.arraycopy(eesEqr1048ConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eesEqr1048ConditionVOs = tmpVOs;
		}
	}
	public EesEqr1048ConditionVO getEesEqr1048ConditionVO(){
		return eesEqr1048ConditionVO;
	}

	public EesEqr1048ConditionVO[] getEesEqr1048ConditionVOS(){
		EesEqr1048ConditionVO[] tmpVOs = null;
		if (this.eesEqr1048ConditionVOs != null) {
			tmpVOs = new EesEqr1048ConditionVO[eesEqr1048ConditionVOs.length];
			System.arraycopy(eesEqr1048ConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	
	public void setForecastReportListVO(ForecastReportListVO forecastReportListVO){
		this. forecastReportListVO = forecastReportListVO;
	}

	public void setForecastReportListVOS(ForecastReportListVO[] forecastReportListVOs){
		if (forecastReportListVOs != null) {
			ForecastReportListVO[] tmpVOs = new ForecastReportListVO[forecastReportListVOs.length];
			System.arraycopy(forecastReportListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.forecastReportListVOs = tmpVOs;
		}
	}
	public ForecastReportListVO getForecastReportListVO(){
		return forecastReportListVO;
	}

	public ForecastReportListVO[] getForecastReportListVOS(){
		ForecastReportListVO[] tmpVOs = null;
		if (this.forecastReportListVOs != null) {
			tmpVOs = new ForecastReportListVO[forecastReportListVOs.length];
			System.arraycopy(forecastReportListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	
}