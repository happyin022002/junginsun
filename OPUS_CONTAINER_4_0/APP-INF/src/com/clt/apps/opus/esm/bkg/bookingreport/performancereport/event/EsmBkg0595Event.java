/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0595Event.java
*@FileTitle : Freight & Charge Summary Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.19 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.FreightChargeSummaryReportInVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0595 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0595HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0595HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0595Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FreightChargeSummaryReportInVO freightChargeSummaryReportInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private FreightChargeSummaryReportInVO[] freightChargeSummaryReportInVOs = null;

	public EsmBkg0595Event(){}
	
	public void setFreightChargeSummaryReportInVO(FreightChargeSummaryReportInVO freightChargeSummaryReportInVO){
		this. freightChargeSummaryReportInVO = freightChargeSummaryReportInVO;
	}

	public void setFreightChargeSummaryReportInVOS(FreightChargeSummaryReportInVO[] freightChargeSummaryReportInVOs){
		if(freightChargeSummaryReportInVOs != null){
			FreightChargeSummaryReportInVO[] tmpVOs = Arrays.copyOf(freightChargeSummaryReportInVOs, freightChargeSummaryReportInVOs.length);
			this.freightChargeSummaryReportInVOs = tmpVOs;
		}
	}

	public FreightChargeSummaryReportInVO getFreightChargeSummaryReportInVO(){
		return freightChargeSummaryReportInVO;
	}

	public FreightChargeSummaryReportInVO[] getFreightChargeSummaryReportInVOS(){
		FreightChargeSummaryReportInVO[] rtnVOs = null;
		if(this.freightChargeSummaryReportInVOs != null){
			rtnVOs= Arrays.copyOf(freightChargeSummaryReportInVOs, freightChargeSummaryReportInVOs.length);
		}
		return rtnVOs;
	}

}