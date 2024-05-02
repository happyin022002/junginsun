/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmBkg1175Event.java
*@FileTitle : B/L Detail 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.05
*@LastModifier : 임재관
*@LastVersion : 1.0
* 2010.02.17 임재관
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SurchageSummaryInVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1175 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1175HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_1175HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1175Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SurchageSummaryInVO surchageSummaryInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SurchageSummaryInVO[] surchageSummaryInVOs = null;

	public EsmBkg1175Event(){}
	
	public void setSurchageSummaryInVO(SurchageSummaryInVO surchageSummaryInVO){
		this. surchageSummaryInVO = surchageSummaryInVO;
	}

	public void setSurchageSummaryInVOS(SurchageSummaryInVO[] surchageSummaryInVOs){
		this. surchageSummaryInVOs = surchageSummaryInVOs;
	}

	public SurchageSummaryInVO getSurchageSummaryInVO(){
		return surchageSummaryInVO;
	}

	public SurchageSummaryInVO[] getSurchageSummaryInVOS(){
		return surchageSummaryInVOs;
	}

}