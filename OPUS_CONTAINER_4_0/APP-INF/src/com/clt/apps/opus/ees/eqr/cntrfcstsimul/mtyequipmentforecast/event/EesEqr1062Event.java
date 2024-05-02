/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1062Event.java
*@FileTitle : Forecast Accuracy Review (By Week)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.12.17 김종준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event;

import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.ForecastAccuracyListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.ForecastAccuracyOptionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_1062 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_1062HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim jong jun
 * @see EES_CIM_1062HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1062Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ForecastAccuracyOptionVO forecastAccuracyOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ForecastAccuracyOptionVO[] forecastAccuracyOptionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ForecastAccuracyListVO forecastAccuracyListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ForecastAccuracyListVO[] forecastAccuracyListVOs = null;

	public EesEqr1062Event(){}
	
	public void setForecastAccuracyOptionVO(ForecastAccuracyOptionVO forecastAccuracyOptionVO){
		this. forecastAccuracyOptionVO = forecastAccuracyOptionVO;
	}

	public void setForecastAccuracyOptionVOS(ForecastAccuracyOptionVO[] forecastAccuracyOptionVOs){
		if (forecastAccuracyOptionVOs != null) {
			ForecastAccuracyOptionVO[] tmpVOs = new ForecastAccuracyOptionVO[forecastAccuracyOptionVOs.length];
			System.arraycopy(forecastAccuracyOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.forecastAccuracyOptionVOs = tmpVOs;
		}
	}
	public ForecastAccuracyOptionVO getForecastAccuracyOptionVO(){
		return forecastAccuracyOptionVO;
	}

	public ForecastAccuracyOptionVO[] getForecastAccuracyOptionVOS(){
		ForecastAccuracyOptionVO[] tmpVOs = null;
		if (this.forecastAccuracyOptionVOs != null) {
			tmpVOs = new ForecastAccuracyOptionVO[forecastAccuracyOptionVOs.length];
			System.arraycopy(forecastAccuracyOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	
	public void setForecastAccuracyListVO(ForecastAccuracyListVO forecastAccuracyListVO){
		this. forecastAccuracyListVO = forecastAccuracyListVO;
	}

	public void setForecastAccuracyListVOS(ForecastAccuracyListVO[] forecastAccuracyListVOs){
		if (forecastAccuracyListVOs != null) {
			ForecastAccuracyListVO[] tmpVOs = new ForecastAccuracyListVO[forecastAccuracyListVOs.length];
			System.arraycopy(forecastAccuracyListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.forecastAccuracyListVOs = tmpVOs;
		}
	}
	public ForecastAccuracyListVO getForecastAccuracyListVO(){
		return forecastAccuracyListVO;
	}

	public ForecastAccuracyListVO[] getForecastAccuracyListVOS(){
		ForecastAccuracyListVO[] tmpVOs = null;
		if (this.forecastAccuracyListVOs != null) {
			tmpVOs = new ForecastAccuracyListVO[forecastAccuracyListVOs.length];
			System.arraycopy(forecastAccuracyListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	
}