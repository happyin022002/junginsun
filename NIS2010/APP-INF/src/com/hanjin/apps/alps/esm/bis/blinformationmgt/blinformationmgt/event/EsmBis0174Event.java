/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmBis0174Event.java
*@FileTitle : C/A Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2010.01.14 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaSummaryReportInVO;


/**
 * ESM_BIS_0174 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BIS_0174HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BIS_0174HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBis0174Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CaSummaryReportInVO caSummaryReportInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CaSummaryReportInVO[] caSummaryReportInVOs = null;

	public EsmBis0174Event(){}
	
	public void setCaSummaryReportInVO(CaSummaryReportInVO caSummaryReportInVO){
		this. caSummaryReportInVO = caSummaryReportInVO;
	}

	public void setCaSummaryReportInVOS(CaSummaryReportInVO[] caSummaryReportInVOs){
		this. caSummaryReportInVOs = caSummaryReportInVOs;
	}

	public CaSummaryReportInVO getCaSummaryReportInVO(){
		return caSummaryReportInVO;
	}

	public CaSummaryReportInVO[] getCaSummaryReportInVOS(){
		return caSummaryReportInVOs;
	}

}