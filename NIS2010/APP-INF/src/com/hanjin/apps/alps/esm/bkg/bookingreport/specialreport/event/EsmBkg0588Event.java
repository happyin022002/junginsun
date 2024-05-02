/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0588Event.java
*@FileTitle : Special cargo summary information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.08.05 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo.SpecialCargoSummaryReportVO;


/**
 * ESM_BKG_0588 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0588HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0588HTMLAction 참조
 * @since J2EE 1.6
 */ 

public class EsmBkg0588Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpecialCargoSummaryReportVO specialCargoSummaryReportVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpecialCargoSummaryReportVO[] specialCargoSummaryReportVOs = null;

	public EsmBkg0588Event(){}
	
	public void setSpecialCargoSummaryReportVO(SpecialCargoSummaryReportVO specialCargoSummaryReportVO){
		this. specialCargoSummaryReportVO = specialCargoSummaryReportVO;
	}

	public void setSpecialCargoSummaryReportVOS(SpecialCargoSummaryReportVO[] specialCargoSummaryReportVOs){
		this. specialCargoSummaryReportVOs = specialCargoSummaryReportVOs;
	}

	public SpecialCargoSummaryReportVO getSpecialCargoSummaryReportVO(){
		return specialCargoSummaryReportVO;
	}

	public SpecialCargoSummaryReportVO[] getSpecialCargoSummaryReportVOS(){
		return specialCargoSummaryReportVOs;
	}

}