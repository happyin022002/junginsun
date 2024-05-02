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
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.FreightChargeSummaryReportInVO;


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

//	public void setFreightChargeSummaryReportInVOS(FreightChargeSummaryReportInVO[] freightChargeSummaryReportInVOs){
//		this. freightChargeSummaryReportInVOs = freightChargeSummaryReportInVOs;
//	}

	public FreightChargeSummaryReportInVO getFreightChargeSummaryReportInVO(){
		return freightChargeSummaryReportInVO;
	}

//	public FreightChargeSummaryReportInVO[] getFreightChargeSummaryReportInVOS(){
//		return freightChargeSummaryReportInVOs;
//	}

	//2015.03.01 Secure Coding 적용 [CWE-495]
	public FreightChargeSummaryReportInVO[] getFreightChargeSummaryReportInVOS(){
		FreightChargeSummaryReportInVO[] rtnVOs = null;
		if (this.freightChargeSummaryReportInVOs != null) {
			rtnVOs = new FreightChargeSummaryReportInVO[freightChargeSummaryReportInVOs.length];
			System.arraycopy(freightChargeSummaryReportInVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	//2015.03.01 Secure Coding 적용[CWE-496]
	public void setFreightChargeSummaryReportInVOS(FreightChargeSummaryReportInVO[] freightChargeSummaryReportInVOs){
		if (freightChargeSummaryReportInVOs != null) {
			FreightChargeSummaryReportInVO[] tmpVOs = new FreightChargeSummaryReportInVO[freightChargeSummaryReportInVOs.length];
			System.arraycopy(freightChargeSummaryReportInVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.freightChargeSummaryReportInVOs = tmpVOs;
		}
	}	
}