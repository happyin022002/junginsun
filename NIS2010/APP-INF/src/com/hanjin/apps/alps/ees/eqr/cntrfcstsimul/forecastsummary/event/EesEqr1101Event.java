/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EES_EQR_1101Event.java
*@FileTitle : EQ Forecast Summary Filter
*Open Issues :
*Change history :
*@LastModifyDate : 2015-12-03
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.event;

import java.util.Arrays;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQBalanceSheetListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQForecastSummaryINVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_1101HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesEqr1101Event extends EventSupport {
	
	private static final long serialVersionUID = 7627061231088057361L;

	private EQForecastSummaryINVO eQForecastSummaryINVO = null;
	
	private EQBalanceSheetListVO eQBalanceSheetListVO = null;
	
	private EQBalanceSheetListVO[] eQBalanceSheetListVOS = null;
	
	public EesEqr1101Event(){
		
	}

	
	public EQForecastSummaryINVO getEQForecastSummaryINVO() {
		return eQForecastSummaryINVO;
	}

	
	public void setEQForecastSummaryINVO(EQForecastSummaryINVO eQForecastSummaryINVO) {
		this.eQForecastSummaryINVO = eQForecastSummaryINVO;
	}

	
	public EQBalanceSheetListVO getEQBalanceSheetListVO() {
		return eQBalanceSheetListVO;
	}

	
	public void setEQBalanceSheetListVO(EQBalanceSheetListVO eQBalanceSheetListVO) {
		this.eQBalanceSheetListVO = eQBalanceSheetListVO;
	}

	
	public EQBalanceSheetListVO[] getEQBalanceSheetListVOS() {
		EQBalanceSheetListVO[] rtnVOs = null;
		if (this.eQBalanceSheetListVOS != null) {
			rtnVOs = new EQBalanceSheetListVO[eQBalanceSheetListVOS.length];
			System.arraycopy(eQBalanceSheetListVOS, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	
	public void setEQBalanceSheetListVOS(EQBalanceSheetListVO[] eQBalanceSheetListVOS) {
		if(eQBalanceSheetListVOS != null){
			EQBalanceSheetListVO[] tmpVOs = Arrays.copyOf(eQBalanceSheetListVOS, eQBalanceSheetListVOS.length);
			this.eQBalanceSheetListVOS = tmpVOs;
		}
	}
	
	
}
