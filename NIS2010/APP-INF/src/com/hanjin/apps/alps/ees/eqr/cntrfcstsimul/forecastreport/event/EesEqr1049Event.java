/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EesEqr1049Event.java
*@FileTitle : EesEqr1049Event
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.28
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2014.10.28 신용찬 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.event;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1049ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
 
/**
 * EES_EQR_1049 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1049HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_1049HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EesEqr1049Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr1049ConditionVO eesEqr1049ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr1049ConditionVO[] eesEqr1049ConditionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ForecastReportListVO forecastReportListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public ForecastReportListVO[] forecastReportListVOs = null;

	public EesEqr1049Event(){}
	
	public void setEesEqr1049ConditionVO(EesEqr1049ConditionVO eesEqr1049ConditionVO){
		this. eesEqr1049ConditionVO = eesEqr1049ConditionVO;
	}

	public void setEesEqr1049ConditionVOS(EesEqr1049ConditionVO[] eesEqr1049ConditionVOs){
		this. eesEqr1049ConditionVOs = eesEqr1049ConditionVOs;
	}
	public EesEqr1049ConditionVO getEesEqr1049ConditionVO(){
		return eesEqr1049ConditionVO;
	}

	public EesEqr1049ConditionVO[] getEesEqr1049ConditionVOS(){
		return eesEqr1049ConditionVOs;
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