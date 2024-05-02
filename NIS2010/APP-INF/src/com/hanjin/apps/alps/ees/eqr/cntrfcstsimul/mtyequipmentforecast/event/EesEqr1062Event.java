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
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.ForecastAccuracyListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.ForecastAccuracyOptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
	public ForecastAccuracyOptionVO[] forecastAccuracyOptionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ForecastAccuracyListVO forecastAccuracyListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public ForecastAccuracyListVO[] forecastAccuracyListVOs = null;

	public EesEqr1062Event(){}
	
	public void setForecastAccuracyOptionVO(ForecastAccuracyOptionVO forecastAccuracyOptionVO){
		this. forecastAccuracyOptionVO = forecastAccuracyOptionVO;
	}

	public void setForecastAccuracyOptionVOS(ForecastAccuracyOptionVO[] forecastAccuracyOptionVOs){
		this. forecastAccuracyOptionVOs = forecastAccuracyOptionVOs;
	}
	public ForecastAccuracyOptionVO getForecastAccuracyOptionVO(){
		return forecastAccuracyOptionVO;
	}

	public ForecastAccuracyOptionVO[] getForecastAccuracyOptionVOS(){
		return forecastAccuracyOptionVOs;
	}
	
	
	public void setForecastAccuracyListVO(ForecastAccuracyListVO forecastAccuracyListVO){
		this. forecastAccuracyListVO = forecastAccuracyListVO;
	}

	public void setForecastAccuracyListVOS(ForecastAccuracyListVO[] forecastAccuracyListVOs){
		this. forecastAccuracyListVOs = forecastAccuracyListVOs;
	}
	public ForecastAccuracyListVO getForecastAccuracyListVO(){
		return forecastAccuracyListVO;
	}

	public ForecastAccuracyListVO[] getForecastAccuracyListVOS(){
		return forecastAccuracyListVOs;
	}	
}